<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>省市区三级联动</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function() {
            // 初始化省市区
            initAddress();

            // 更改省份后的操作
            $("select[name='province']").change(function() {

                var provCode = $("select[name='province']").val();

                getCity(provCode);

            });

            // 更改城市后的操作
            $("select[name='city']").change(function() {
                var cityCode = $("select[name='city']").val();
                getArea(cityCode);
            });

        });

        function initAddress() {

            var firstProvCode;
            // ajax请求所有省份
            $.get("/getAllProvince", {
            }, function(data) {

                $.each(data, function(i, d) {
                    $("select[name='province']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });

                // 获取第一个省份的code
                firstProvCode = data[0].code;
                // 根据第一个省份code获取对应城市列表
                getCity(firstProvCode);
            }, 'json');

        }

        //获取对应城市列表（里面包括获取第一个城市的区县列表）
        function getCity(provincecode) {

            var firstCityCode;

            // ajax请求所有市级单位
            $.get("/getCityByProvCode", {
                provincecode : provincecode
            }, function(data) {
                // 先清空城市下拉框
                $("select[name='city']").empty();

                $.each(data, function(i, d) {
                    $("select[name='city']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });
                // 获取第一个城市的code
                firstCityCode = data[0].code;
                // 根据第一个城市code获取对应区县列表
                getArea(firstCityCode);

            }, 'json');
        }


        function getArea(citycode) {

            // ajax请求所有区县单位
            $.get("/getAreaByCityCode", {
                citycode : citycode
            }, function(data) {
                // 先清空区县下拉框
                $("select[name='area']").empty();
                $.each(data, function(i, d) {
                    $("select[name='area']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });
            }, 'json');
        }
    </script>
</head>
<body>
<h2>省市区三级菜单联动</h2>
请选择：
<select name='province'></select>
<select name='city'></select>
<select name='area'></select>
</body>
</html>
