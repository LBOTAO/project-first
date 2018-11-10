package cn.mybatis.day02.dao;

import cn.mybatis.day02.entity.Category;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-10 13:17
 */
public interface ICategoryDao {
    //查询某个pid对应的所有分类的集合
    public List<Category> getChildrenListByPid(int pid);

    public List<Category> getCategoriesByCid(int cid) throws Exception;
}
