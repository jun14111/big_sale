package com.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.jws.Oneway;
import java.util.Date;

//切面类
@Aspect
@Component
public class AspectAOP {
    Date begin = null;

    // 切点注解
    @Pointcut("execution(public * com.model..*(..))")
    public void pointcut() {
    }

    /**
     * 切面方法
     * 统计某个方法运行时间
     *
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        // 开始时间
        Date begin = new Date();

        Object obj = null;
        // 调用原方法
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 结束时间
        Date end = new Date();

        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String funcName = joinPoint.getSignature().getName();

        // 统计时间
        System.out.println("[INFO] " + className + "-->" + funcName + "运行时间 " + (end.getTime() - begin.getTime()) + "ms");

        return obj;
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        System.out.println("[INFO] " + jp.getTarget().getClass().getName() + "-->" + jp.getSignature().getName() + "前置增强处理");
        // 开始时间
        begin = new Date();
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
        // 结束时间
        Date end = new Date();

        // 统计时间
        System.out.println("[INFO] " + jp.getSignature().getName() + "运行时间2 " + (end.getTime() - begin.getTime()) + "ms");

        // 获取原方法参数
        Object[] args = jp.getArgs();
        System.out.println("[INFO] 参数个数-->" + args.length);

        System.out.println("[INFO] " + jp.getTarget().getClass().getName() + "-->" + jp.getSignature().getName() + " 最终增强处理");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "obj")
    public void afterReturn(Object obj) {
        System.out.println("[INFO] 后置增强处理" + obj);
    }

    /**
     * 异常增强处理
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("[FATAL] 异常--> " + ex);
    }
}
