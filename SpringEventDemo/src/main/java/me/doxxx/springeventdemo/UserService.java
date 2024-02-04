package me.doxxx.springeventdemo;

import me.doxxx.springeventdemo.event.UserRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    // 다른 메서드들...

    public void registerUser(String username) {
        // 사용자 등록 로직...

        // 사용자 등록 이벤트 발생
        UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent(this, username);
        eventPublisher.publishEvent(userRegisteredEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
}
