package cn.happy.day03aop.dao;

import cn.happy.day03aop.entity.User;

/**
 * author：  刘涛
 *
 * @create 2018-11-15 16:46
 */
public class UserDAOImpl implements IUserDAO {
    @Override
    public void save(User user) {
        System.out.println("save ok!");
    }
}
