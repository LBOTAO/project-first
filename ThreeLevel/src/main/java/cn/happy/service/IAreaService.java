package cn.happy.service;

import cn.happy.entity.City;
import cn.happy.entity.Province;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-10 9:31
 */
public interface IAreaService {
    public List<City> getAreaByCityCode(String citycode);
    public List<Province> getCityByProvCode(String provincecode);
    public List<Province> getAllProvince();
}
