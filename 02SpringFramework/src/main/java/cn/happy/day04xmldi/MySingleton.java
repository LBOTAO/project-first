package cn.happy.day04xmldi;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 14:09
 */
public class MySingleton {
    //第一种:懒汉模式  双重效验锁
    //私有化构造方法
    private MySingleton(){}

    //只有一个对象
    private static MySingleton instance=null;

    //获取实例方法   对外提供静态方法
    public static synchronized MySingleton getInstance(){
      if (instance==null){
          synchronized (MySingleton.class){
              if(instance==null){
                  instance=new MySingleton();
              }
          }
      }
        return instance;
    }

    public static void main(String[] args) {
        MySingleton m1 = MySingleton.getInstance();
        System.out.println(m1);
        MySingleton m2 = MySingleton.getInstance();
        System.out.println(m2);
    }
}
