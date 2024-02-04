package me.doxxx.springeventdemo.listener;

import me.doxxx.springeventdemo.EventExpressionEvaluator;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConditionalEventListener {

    @EventListener(condition = "#root.event instanceof T(me.doxxx.springeventdemo.event.UserRegisteredEvent)")
    public void handleConditionalEvent(ApplicationEvent event) {
        String eventName = event.getClass().getSimpleName();
        String expression = "#this.username.length() > 5";

        if (EventExpressionEvaluator.evaluateExpression(expression, event)) {
            System.out.println("Conditional event handled: " + eventName);
        } else {
            System.out.println("Conditional event not handled: " + eventName);
        }
    }
}
