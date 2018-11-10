package cn.happy.service;

import cn.happy.dao.IAreaDao;
import cn.happy.entity.City;
import cn.happy.entity.Province;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-10 9:32
 */
@Service("areaService")
public class AreaServiceImpl implements IAreaService {
    @Resource(name = "IAreaDao")
    private IAreaDao areaDao;
    @Override
    public List<City> getAreaByCityCode(String citycode) {
        return areaDao.getAreaByCityCode(citycode);
    }

    @Override
    public List<Province> getCityByProvCode(String provincecode) {
        return areaDao.getCityByProvCode(provincecode);
    }

    @Override
    public List<Province> getAllProvince() {
        return areaDao.getAllProvince();
    }
}
