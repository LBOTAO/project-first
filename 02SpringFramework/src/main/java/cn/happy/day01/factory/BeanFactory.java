package cn.happy.day01.factory;


import cn.happy.day01.dao.ICustomerDao;
import cn.happy.day01.service.ICustomerService;

import java.util.ResourceBundle;


/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:45
 */
public class BeanFactory {
    private static ResourceBundle bundle=ResourceBundle.getBundle("bean");
    public static Object getBean(String beanName) {
        try {
            String beanPath = bundle.getString(beanName);
            return Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
