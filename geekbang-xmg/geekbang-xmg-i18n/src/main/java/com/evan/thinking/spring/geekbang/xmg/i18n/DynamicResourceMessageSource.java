package com.evan.thinking.spring.geekbang.xmg.i18n;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

/**
 * @desc: 动态消息来源
 * 
 *        <pre>
 * 1. 定位资源位置（ Properties 文件）
 * 2. 初始化 Properties 对象
 * 3. 实现 AbstractMessageSource#resolveCode 方法
 * 4. 监听资源文件（Java NIO 2 WatchService）
 * 5. 使用线程池处理文件变化
 * 6. 重新装载 Properties 对象
 *        </pre>
 * 
 * @author: evan
 * @date: 2022/4/10
 */
public class DynamicResourceMessageSource extends AbstractMessageSource {

    private static final String resourceFileName = "dynamic.properties";

    private static final String REAOURCE_PATH = "classpath:/META-INF/" + resourceFileName;

    private static final String ENCODING = "UTF-8";

    private final Resource messagePropertiesResource;
    private final Properties msgProperties;
    private final ExecutorService executorService;

    private ResourceLoader resourceLoader;

    public DynamicResourceMessageSource() {
        messagePropertiesResource = getMessagePropertiesResource();
        msgProperties = loadMsgProperteis();
        executorService = Executors.newSingleThreadExecutor();
        // 监听资源文件（Java NIO 2 WatchService）
        onMessagePropertiesChanged();
    }

    private void onMessagePropertiesChanged() {
        if (messagePropertiesResource.isFile()) {
            try {
                File messagePropertiesFile = this.messagePropertiesResource.getFile();
                Path messagePropertiesPath = messagePropertiesFile.toPath();
                // 获取当前OS文件系统
                FileSystem fileSystem = FileSystems.getDefault();
                // 新建WatchService
                WatchService watchService = fileSystem.newWatchService();
                // 获取资源路径所在目录
                Path dirPath = messagePropertiesPath.getParent();
                // 注册watchService 到 dirPath上
                dirPath.register(watchService,StandardWatchEventKinds.ENTRY_MODIFY);
                // 处理资源文件变化
                processMessagePropertiesChanged(watchService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Resource getMessagePropertiesResource() {
        ResourceLoader resourceLoader = getResourceLoader();
        this.resourceLoader = resourceLoader;
        Resource resource = resourceLoader.getResource(REAOURCE_PATH);
        return resource;
    }

    private Properties loadMsgProperteis() {
        EncodedResource encodedResource = new EncodedResource(resourceLoader.getResource(REAOURCE_PATH), ENCODING);
        try {
            return loadMsgProperteis(encodedResource.getReader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties loadMsgProperteis(Reader reader) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }

    /**
     * 处理资源 异步
     * 
     * @param watchService
     */
    private void processMessagePropertiesChanged(WatchService watchService) {
        executorService.submit(() -> {
            while (true) {
                // 阻塞
                WatchKey watchKey = watchService.take();
                System.out.println(watchKey);
                try {
                    if (watchKey.isValid()) {
                        for (WatchEvent<?> event : watchKey.pollEvents()) {
                            Path fileRelativePath = (Path)event.context();
                            // 目录路径（监听的注册目录）
                            Path dirPath = (Path)watchKey.watchable();
                            if (resourceFileName.equals(fileRelativePath.getFileName().toString())) {
                                // 处理为绝对路径
                                Path filePath = dirPath.resolve(fileRelativePath);
                                File file = filePath.toFile();
                                Properties properties = loadMsgProperteis(new FileReader(file));
                                synchronized (msgProperties) {
                                    msgProperties.clear();
                                    msgProperties.putAll(properties);
                                }
                            }
                        }
                    }
                } finally {
                    if (watchKey != null) {
                        watchKey.reset();
                    }
                }
            }

        });
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String messageFormatPattern = msgProperties.getProperty(code);
        if (StringUtils.hasText(messageFormatPattern)) {
            return new MessageFormat(messageFormatPattern, locale);
        }
        return null;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader != null ? resourceLoader : new DefaultResourceLoader();
    }

    public static void main(String[] args) throws InterruptedException {
        DynamicResourceMessageSource messageSource = new DynamicResourceMessageSource();
        for (int i = 0; i < 1000; i++) {
            System.out.println(messageSource.msgProperties);
            String result = messageSource.getMessage("name", new Object[] {}, Locale.getDefault());
            System.out.println(result);
            Thread.sleep(1000);
        }
    }
}
