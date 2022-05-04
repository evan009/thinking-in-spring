package com.evan.thinking.spring.geekbang.xmg.resource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @desc: FileSystemResource 示例
 * @author: evan
 * @date: 2022/4/9
 */
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {
        resourseDemo();
        System.out.println("=======华丽的分割线==========");
        resourseLoaderDemo();
//
//        resourseLoaderDemo2();
    }

    private static void resourseLoaderDemo() throws IOException {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        String currentFile = "classpath:/META-INF/default.properties";
        System.out.println(IOUtils.toString(new EncodedResource(resourceLoader.getResource(currentFile)).getReader()));
    }

    private static void resourseLoaderDemo2() throws IOException {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        String currentFile = System.getProperty("user.dir")
                + "\\geekbang-xmg\\resource\\src\\main\\java\\com\\evan\\thinking\\spring\\geekbang\\xmg\\resource\\EncodedFileSystemResourceDemo.java";
        System.out.println(IOUtils.toString(new EncodedResource(resourceLoader.getResource(currentFile)).getReader()));
    }

    private static void resourseDemo() throws IOException {
        String currentFile = System.getProperty("user.dir")
            + "\\geekbang-xmg\\resource\\src\\main\\java\\com\\evan\\thinking\\spring\\geekbang\\xmg\\resource\\EncodedFileSystemResourceDemo.java";

        FileSystemResource fileSystemResource = new FileSystemResource(new File(currentFile));
        EncodedResource encodedResource = new EncodedResource(fileSystemResource);
        // 字符输入流
        Reader reader = encodedResource.getReader();
        System.out.println(IOUtils.toString(reader));
    }
}