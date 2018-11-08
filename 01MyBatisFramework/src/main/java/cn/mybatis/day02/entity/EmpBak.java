package cn.mybatis.day02.entity;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 17:02
 */
public class EmpBak {
    private Integer id;
    private String empnames;
    private String empphone;
    private Integer deptid;


    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}
