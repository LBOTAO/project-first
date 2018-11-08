package cn.mybatis.day01base.entity;

import cn.mybatis.day02.entity.Dept;

/**
 * author：  刘涛
 *
 * @create 2018-11-03 16:56
 */
public class Emp {
    private Integer id;
    private String empnames;
    private String empphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpnames() {
        return empnames;
    }

    public void setEmpnames(String empnames) {
        this.empnames = empnames;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }
}
