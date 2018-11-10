package cn.happy.controller;

import cn.happy.entity.City;
import cn.happy.entity.Province;
import cn.happy.service.IAreaService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-10 9:34
 */
@Controller
public class AreaController {
    @Resource(name = "areaService")
    private IAreaService areaService;

    @RequestMapping("/getAllProvince")
    @ResponseBody
    public void getAllProvince(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Province> provinceList = areaService.getAllProvince();

        Gson gson=new Gson();
        String jsonStr = gson.toJson(provinceList);
        out.print(jsonStr);
    }


    @RequestMapping("/getCityByProvCode")
    @ResponseBody
    public void getCityByProvCode(String provincecode, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Province> cityList = areaService.getCityByProvCode(provincecode);

        Gson gson=new Gson();
        String jsonStr = gson.toJson(cityList);
        out.print(jsonStr);
    }


    @RequestMapping("/getAreaByCityCode")
    @ResponseBody
    public void getAreaByCityCode(String citycode, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<City> areaList = areaService.getAreaByCityCode(citycode);

        Gson gson=new Gson();
        String jsonStr = gson.toJson(areaList);
        out.print(jsonStr);
    }

}
