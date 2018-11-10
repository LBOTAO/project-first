package cn.mybatis.day02.dao;

import cn.mybatis.day02.entity.Teacher;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-10 15:09
 */
public interface IStudentDao {
    //多对多
    public List<Teacher> findTeacherBySid(Integer sid);
}
