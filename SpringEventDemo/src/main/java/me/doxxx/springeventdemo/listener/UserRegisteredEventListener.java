package me.doxxx.springeventdemo.listener;

import me.doxxx.springeventdemo.event.UserRegisteredEvent;
import org.springframework.context.ApplicationListener;

public class UserRegisteredEventListener implements ApplicationListener<UserRegisteredEvent> {

    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        // 사용자 등록 이벤트 처리 로직
        String username = event.getUsername();
        System.out.println("User registered: " + username);
    }
}
