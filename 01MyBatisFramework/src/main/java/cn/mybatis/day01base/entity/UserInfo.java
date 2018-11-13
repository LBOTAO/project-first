package cn.mybatis.day01base.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */
public class UserInfo implements Serializable{
    private Integer id;  //用户id
    private String name;  //用户姓名
    private String sex;   //用户性别
    private int age;    //年龄
    private int deptno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}
