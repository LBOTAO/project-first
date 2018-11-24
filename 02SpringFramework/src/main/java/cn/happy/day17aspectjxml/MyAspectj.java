package cn.happy.day17aspectjxml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * author：  刘涛
 *
 * @create 2018-11-24 15:09
 */
public class MyAspectj {

    //前置

    public void beforeAspect() {

        System.out.println("前置增强");
    }

   //后置

    public void AfterReturningAspect() {

        System.out.println("后置增强");
    }


    public void AroundAspect(ProceedingJoinPoint po) {

        System.out.println("环绕前增强");
        try {
            po.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("环绕后增强");
    }

    //异常

    public void AfterThrowingAspect() {

        System.out.println("异常增强");
    }

     //最终

    public void AfterAspect() {

        System.out.println("最终增强");
    }

}
