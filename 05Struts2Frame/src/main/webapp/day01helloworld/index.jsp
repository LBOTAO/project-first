
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>struts2</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/n1/hello.do">点击一下，你就知道！</a>
<hr/>
<a href="${pageContext.request.contextPath}/n1/hello2.do">implements Action接口实现动作类</a>
<hr/>
<a href="${pageContext.request.contextPath}/n1/hello3.do">extends ActionSupport类实现动作类</a>
</body>
</html>
