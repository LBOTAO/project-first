package cn.mybatis.day01base.dao;

import cn.mybatis.day01base.entity.Emp;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-03 16:58
 */
public interface IEmpDao {
    public List<Emp> findEmpAll();
    //智能标签 if
    public List<Emp> dynamicSqlByIf(Emp emp);
    //智能标签 choose
    public List<Emp> dynamicSqlByChoose(Emp emp);
    //智能标签  forech array
    public List<Emp> dynamicSqlForeach(int[] ids);
   // 智能标签  forech list
    public List<Emp> dynamicSqlForeachByList(List<Integer> list);
    // 智能标签  forech list object
    public List<Emp> dynamicSqlForeachByListObject(List<Emp> emp);
}
