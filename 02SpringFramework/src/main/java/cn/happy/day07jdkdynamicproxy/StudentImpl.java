package cn.happy.day07jdkdynamicproxy;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 17:35
 */
public class StudentImpl implements IStudent {
    @Override
    public void add() {
        System.out.println("jdk动态代理");
    }
}
