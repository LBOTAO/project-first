package cn.happy.day03aop.service;

import cn.happy.day03aop.dao.IUserDAO;
import cn.happy.day03aop.entity.User;

/**
 * author：  刘涛
 *
 * @create 2018-11-15 16:47
 */
public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
