package cn.happy.day14autoproxy01;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 15:10
 */
public class MyAfterAdvice implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("====after=========");
    }
}
