package cn.happy.day09aop01;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 15:17
 */
public class MyBeforAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before*********");
    }
}
