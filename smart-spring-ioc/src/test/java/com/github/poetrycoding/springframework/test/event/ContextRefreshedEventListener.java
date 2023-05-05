package com.github.poetrycoding.springframework.test.event;


import com.github.poetrycoding.springframework.context.ApplicationListener;
import com.github.poetrycoding.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
