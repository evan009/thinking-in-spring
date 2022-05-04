package com.evan.thinking.spring.geekbang.xmg.event;

import java.util.Observable;
import java.util.Observer;

/**
 * @desc: 观察者实例
 * @author: evan
 * @date: 2022/4/17
 */
public class ObserverDemo {

    public static void main(String[] args) {
        // 事件发送者
        EventObservable observable = new EventObservable();
        // 添加事件监听器
        observable.addObserver(new EventObverser());
        observable.notifyObservers("事件消息220417");

    }

    static class EventObservable extends Observable {

        @Override
        public void notifyObservers(Object arg) {
            super.setChanged();
            super.notifyObservers(arg);
            super.clearChanged();
        }

    }

    static class EventObverser implements Observer {

        @Override
        public void update(Observable o, Object data) {
            System.out.println("Observable" + o.toString());
            System.out.println("data" + data.toString());
        }
    }
}
