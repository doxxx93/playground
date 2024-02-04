package me.doxxx.springeventdemo;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class EventExpressionEvaluator {
    private EventExpressionEvaluator() {
    }

    public static boolean evaluateExpression(String expression, Object event) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(event);
        return Boolean.TRUE.equals(parser.parseExpression(expression).getValue(context, Boolean.class));
    }
}
