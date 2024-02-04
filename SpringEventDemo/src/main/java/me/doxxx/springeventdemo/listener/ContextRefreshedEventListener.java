package me.doxxx.springeventdemo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // ContextRefreshedEvent에 대한 처리 로직
        System.out.println("ApplicationContext is refreshed.");
    }
}
