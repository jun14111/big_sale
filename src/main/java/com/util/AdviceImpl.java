package com.util;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
import sun.reflect.MethodAccessor;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通知类
@Component
public class AdviceImpl implements MethodBeforeAdvice , AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("通知类--前置增强处理");
        System.out.println(method.getName());
        System.out.println(objects.length);
        System.out.println(o.getClass().getName());
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(o);
        System.out.println(o1);
        System.out.println("通知类--后置增强处理");
    }
}
