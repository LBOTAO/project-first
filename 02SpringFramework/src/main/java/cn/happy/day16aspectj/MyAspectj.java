package cn.happy.day16aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * author：  刘涛
 *
 * @create 2018-11-24 15:09
 */
@Aspect
public class MyAspectj {
    @Pointcut("execution(* *..*.day16aspectj.*.doSome(..))")
    public void select(){}


    //最终通知
    /*@After("execution(* *..*.day16aspectj.*.add(..))")
    public void after(){
        System.out.println("after=====");
    }
    //前置通知
    @Before("execution(* *..*.day16aspectj.*.add(..))")
    public void before(){
        System.out.println("before=====");
    }
    //后置通知
    @AfterReturning(returning = "rvt",pointcut = "execution(* *..*.day16aspectj.*.add(..))")
    public void test(JoinPoint point,Object rvt){
        Object target = point.getTarget();
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("目标对象"+target);
        System.out.println("获取目标方法的返回值"+rvt);
        System.out.println("------AfterReturning---------------");
    }*/

    //环绕通知
    @Around("select()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before////");
        Object proceed = point.proceed();
        System.out.println(proceed);
        System.out.println("after/////");
    }

    //异常增强
   /* @AfterThrowing(throwing="ex",pointcut = "execution(* *..*.day16aspectj.*.delete(..))")
    public void afterThrowing(Throwable ex){
        System.out.println("exception-------"+ex.getMessage());
        System.out.println("异常增强=====");
    }*/
}
