package cn.happy.day01helloworld.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author：  刘涛
 *
 * @create 2018-11-29 9:25
 */
public class Hello3Action extends ActionSupport {
    public String hello3(){
        System.out.println("extends ActionSupport success.....");
        return "success";
    }
}
