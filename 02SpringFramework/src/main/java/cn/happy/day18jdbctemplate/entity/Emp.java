package cn.happy.day18jdbctemplate.entity;

import java.io.Serializable;

/**
 * author：  刘涛
 *
 * @create 2018-11-03 16:56
 */
public class Emp implements Serializable {
    private Integer empid;
    private String empname;
    private String empphone;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }
}
