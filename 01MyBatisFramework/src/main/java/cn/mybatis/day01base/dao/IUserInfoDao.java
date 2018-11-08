package cn.mybatis.day01base.dao;

import cn.mybatis.day01base.entity.ConditionModel;
import cn.mybatis.day01base.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-10-30 15:44
 */
public interface IUserInfoDao {

    public List<UserInfo> findAll() throws Exception;

    public List<UserInfo> findByLikeUserName(@Param("name") String name) throws Exception;

    public UserInfo findByUserName(String name) throws IOException;

    public int insertUserInfo(UserInfo userInfo)throws IOException;

    public List<UserInfo> multiConditionByModel(ConditionModel conditionModel);

    public List<UserInfo> multiConditionByMap(Map<String,Object> map);


}
