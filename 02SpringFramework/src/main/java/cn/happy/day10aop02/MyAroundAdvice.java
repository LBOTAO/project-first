package cn.happy.day10aop02;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 16:18
 */
public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before advice-----");
        methodInvocation.proceed();  //分界点   调用目标方法
        System.out.println("after advice------");
        return null;
    }
}
