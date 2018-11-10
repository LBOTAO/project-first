package cn.happy.dao;

import cn.happy.entity.Area;
import cn.happy.entity.City;
import cn.happy.entity.Province;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-09 16:52
 */
public interface IAreaDao {
    public List<City> getAreaByCityCode(String citycode);
    public List<Province> getCityByProvCode(String provincecode);
    public List<Province> getAllProvince();
}
