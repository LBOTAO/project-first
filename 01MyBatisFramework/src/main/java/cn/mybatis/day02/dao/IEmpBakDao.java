package cn.mybatis.day02.dao;

import cn.mybatis.day01base.entity.Emp;
import cn.mybatis.day02.entity.EmpBak;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 17:03
 */
public interface IEmpBakDao {
    public EmpBak getEmpByDeptNo(int deptid);

    public EmpBak getEmpByDeptNoMultiSql(int deptid);
}
