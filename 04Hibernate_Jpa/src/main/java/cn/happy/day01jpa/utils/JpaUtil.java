package cn.happy.day01jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * author：  刘涛
 *
 * @create 2018-11-28 10:40
 */
public class JpaUtil {
    //相当于sessionfactory
    private static EntityManagerFactory factory;

    private static ThreadLocal<EntityManager> tl;
    static {
        factory= Persistence.createEntityManagerFactory("myPersistUnit");
        tl=new ThreadLocal<EntityManager>();
    }

    /**
     * 获取jpa操作数据库的对象
     *
     */
   /* public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }*/

    public static EntityManager createEntityManager(){
        //从当前线程获取entitymanager
        EntityManager em = tl.get();
        if (em==null){
            em=factory.createEntityManager();
            tl.set(em);
        }
        return tl.get();
    }

    public static void main(String[] args) {
        createEntityManager();
    }
}
