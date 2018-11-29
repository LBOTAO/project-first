package cn.happy.day18jdbctemplate.dao;

import cn.happy.day18jdbctemplate.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 9:56
 */

@Repository
public class EmpDAOImpl extends JdbcDaoSupport implements IEmpDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public List<Emp> findAll() {
       // JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
        String sql="select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp emp = new Emp();
                emp.setEmpid(rs.getInt("empid"));
                emp.setEmpname(rs.getString("empname"));
                emp.setEmpphone(rs.getString("empphone"));
                return emp;
            }
        });
        return empList;
    }

    //增删改都是用update方法

    @Override
    public int addEmp(Emp emp) {
        String sql="insert into emp(empname,empphone) VALUES(?,?)";
        return jdbcTemplate.update(sql,emp.getEmpname(),emp.getEmpphone());
    }
}
