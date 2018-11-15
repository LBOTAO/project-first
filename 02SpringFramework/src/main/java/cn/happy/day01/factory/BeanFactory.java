package cn.happy.day01.factory;


import cn.happy.day01.dao.ICustomerDao;
import cn.happy.day01.service.ICustomerService;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:45
 */
public class BeanFactory {
    public static ICustomerService getCustomerService() {
        try {
            return (ICustomerService) Class.forName("cn.happy.day01.service.impl.CustomerServiceImpl").newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public static ICustomerDao getCustomerDao(){
        try {
            return (ICustomerDao) Class.forName("cn.happy.day01.dao.impl.CustomerDaoImpl").newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
