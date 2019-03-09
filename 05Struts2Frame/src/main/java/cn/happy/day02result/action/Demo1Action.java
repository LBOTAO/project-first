package cn.happy.day02result.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author：  刘涛
 *
 * @create 2018-11-29 14:13
 */
public class Demo1Action extends ActionSupport {
    public String demo(){
        System.out.println("看到我了没。。。。");
        return SUCCESS;
    }
}
