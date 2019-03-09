package cn.happy.day01helloworld.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author：  刘涛
 *
 * @create 2018-11-29 9:45
 */
public class UserAction extends ActionSupport {

    public String addUser(){
        System.out.println("添加了用户");
        return SUCCESS;
    }
    public String updateUser(){
        System.out.println("更新了用户");
        return SUCCESS;
    }
    public String deleteUser(){
        System.out.println("删除了用户");
        return SUCCESS;
    }
    public String findUser(){
        System.out.println("查询了用户");
        return SUCCESS;
    }
}

