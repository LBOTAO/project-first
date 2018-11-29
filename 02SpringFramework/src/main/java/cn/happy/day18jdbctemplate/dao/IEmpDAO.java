package cn.happy.day18jdbctemplate.dao;

import cn.happy.day18jdbctemplate.entity.Emp;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 9:55
 */
public interface IEmpDAO {
    public List<Emp> findAll();

    public int addEmp(Emp emp);
}
