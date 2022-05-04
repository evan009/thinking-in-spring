package com.evan.thinking.spring.geekbang.xmg.context.lifecycle;

import org.springframework.context.Lifecycle;

public class MyLifeCycel implements Lifecycle {

    private boolean running = false;


    @Override
    public void start() {
        running = true;
        System.out.println("MyLifecycle 启动...");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("MyLifecycle 关闭...");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
