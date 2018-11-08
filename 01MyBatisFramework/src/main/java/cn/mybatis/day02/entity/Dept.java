package cn.mybatis.day02.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public class Dept implements Serializable{
    private Integer deptno;
    private String deptname;
    //管理用户集合  1的一方植入多的一方的属性集合
    private List<UserInfo> userList=new ArrayList<UserInfo>();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<UserInfo> getList() {
        return userList;
    }

    public void setList(List<UserInfo> list) {
        this.userList = list;
    }
}
