package cn.happy.day06interceptor.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author：  刘涛
 *
 * @create 2018-12-01 16:36
 */
public class Demo1Action extends ActionSupport{

    public String demo1(){
        System.out.println("demo1Action执行了...");
        return SUCCESS;
    }
}
