package com.evan.thinking.spring.geekbang.xmg.resource;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @desc: ResourcePatternResolver 路径解析示例
 * @see ResourcePatternResolver
 * @author: evan
 * @date: 2022/4/9
 */
public class ResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {

        String packagePattern = "classpath*:com\\evan\\thinking\\spring\\geekbang\\xmg\\resource*.java";

        ResourcePatternResolver resourcePatternResolver =
            new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

        Arrays.stream(resourcePatternResolver.getResources(packagePattern)).forEach(resource -> {
            EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
            try {
                IOUtils.toString(encodedResource.getReader());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
