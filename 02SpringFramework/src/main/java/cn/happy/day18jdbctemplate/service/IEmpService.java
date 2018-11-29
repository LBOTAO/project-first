package cn.happy.day18jdbctemplate.service;

import cn.happy.day18jdbctemplate.entity.Emp;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 10:03
 */
public interface IEmpService {

    public List<Emp> findAll();

    public int addEmp(Emp emp);
}
