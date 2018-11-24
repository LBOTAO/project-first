package cn.happy.day11aop03;

import org.springframework.aop.ThrowsAdvice;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 16:29
 */
public class MyExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println(ex.getMessage()+"出错，，，");
    }
}
