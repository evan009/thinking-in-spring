package com.evan.thinking.spring.official.context.resource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * @Desc: 内置resource实现
 * @author: evan
 * @date: 2022-04-07
 */
public class BuiltinResource {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // urlResource();
        fileSystemResource();
    }

    private static void fileSystemResource() throws IOException {
        FileSystemResource resource = new FileSystemResource("D:\\awei\\git\\FileSystemResource.txt");
        printResource(resource);
    }

    private static void urlResource() throws URISyntaxException, IOException {
        URI uri = new URI("https://baike.baidu.com/");
        UrlResource resource = new UrlResource(uri);
        printResource(resource);
    }

    private static void printResource(Resource resource) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resource.getInputStream());
        StringBuilder result = new StringBuilder();
        int temp = 0;
        // 当temp等于-1时，表示已经到了文件结尾，停止读取
        while ((temp = bufferedInputStream.read()) != -1) {
            result.append((char)temp);
        }
        System.out.println(result.toString());
    }

}
