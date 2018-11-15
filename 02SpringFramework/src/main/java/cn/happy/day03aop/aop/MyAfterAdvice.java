package cn.happy.day03aop.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * author：  刘涛
 *
 * @create 2018-11-15 17:34
 */
public class MyAfterAdvice implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("=====after log=============");
    }
}
