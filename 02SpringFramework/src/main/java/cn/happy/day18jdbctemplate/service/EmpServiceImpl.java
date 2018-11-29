package cn.happy.day18jdbctemplate.service;

import cn.happy.day18jdbctemplate.dao.IEmpDAO;
import cn.happy.day18jdbctemplate.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 10:03
 */

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDAO empDao;

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }
}
