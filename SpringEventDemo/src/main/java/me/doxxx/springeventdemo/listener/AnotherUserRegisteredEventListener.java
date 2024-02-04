package me.doxxx.springeventdemo.listener;

import me.doxxx.springeventdemo.event.UserRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherUserRegisteredEventListener {

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        // 다른 사용자 등록 이벤트 처리 로직
        String username = event.getUsername();
        System.out.println("Another user registered: " + username);
    }
}
