package cn.happy.day03aop.dao;

import cn.happy.day03aop.entity.User;

/**
 * author：  刘涛
 *
 * @create 2018-11-15 16:45
 */
public interface IUserDAO {
    public void save(User user);

    public int del(int id);
}
