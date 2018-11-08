package cn.mybatis.day02.dao;

import cn.mybatis.day02.entity.Dept;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 14:46
 */
public interface IDeptDao {
    //一对多   单条sql
    public Dept getUserByDeptNo(int deptno);

    //一对多    多条sql
    public Dept getUserByDeptNoMultiSql(int deptno);


}
