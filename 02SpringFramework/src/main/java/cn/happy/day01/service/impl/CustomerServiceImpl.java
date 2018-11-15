package cn.happy.day01.service.impl;

import cn.happy.day01.dao.ICustomerDao;
import cn.happy.day01.factory.BeanFactory;
import cn.happy.day01.service.ICustomerService;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:34
 */
public class CustomerServiceImpl implements ICustomerService {
    //ICustomerDao dao=new CustomerDaoImpl();
    private ICustomerDao dao= BeanFactory.getCustomerDao();
    @Override
    public void saveCustomer() {
        System.out.println("service调用dao层数据持久层");
        dao.saveCustomer();
    }
}
