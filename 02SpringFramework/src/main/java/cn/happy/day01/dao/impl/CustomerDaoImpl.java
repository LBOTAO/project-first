package cn.happy.day01.dao.impl;

import cn.happy.day01.dao.ICustomerDao;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:35
 */
public class CustomerDaoImpl implements ICustomerDao {
    @Override
    public void saveCustomer() {
        System.out.println("dao层持久数据！！！");
    }
}
