package cn.happy.day06staticproxy;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 16:22
 */
public class RealSubject implements Subject {
    @Override
    public void findAll() {
        System.out.println("查询全部");
    }
}
