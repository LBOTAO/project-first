<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
</head>
<s:head/>
<body>
<%--请求参数封装：第一种情况：属性驱动-没有实体类  --%>
<%--<form action="${pageContext.request.contextPath}/demo1.do" method="post">
	姓名：<input type="text" name="username"/><br/>
	年龄：<input type="text" name="age"/><br/>
	生日：<input type="text" name="birthday"/><br/>
	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form>--%>

<%--请求参数封装：第二种情况：属性驱动-有实体类 --%>
<%--<form action="${pageContext.request.contextPath}/demo2.do" method="post">
	姓名：<input type="text" name="user.username"/><br/>
	年龄：<input type="text" name="user.age"/><br/>
	生日：<input type="text" name="user.birthday"/><br/>
	爱好：<input type="checkbox" name="user.hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="user.hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="user.hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form>--%>

<%--

请求参数封装：第三种情况：模型驱动
<form action="${pageContext.request.contextPath}/demo3.do" method="post">
	姓名：<input type="text" name="username"/><s:fielderror fieldName="username"/><br/>
	年龄：<input type="text" name="age"/><s:fielderror fieldName="age"/><br/>
	生日：<input type="text" name="birthday"/><s:fielderror fieldName="birthday"/><br/>
	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="hobby" value="写代码"/>写代码
	<s:fielderror/><br/>
	<input type="submit" value="提交"/>
</form>
--%>

<s:form action="demo3.do">
	<s:textfield name="username" label="姓名"></s:textfield>
	<s:textfield name="age" label="年龄"></s:textfield>
	<s:textfield name="birthday" label="生日"></s:textfield>
	<s:submit value="提交"/>
</s:form>

<%--请求参数封装：List集合类型的封装 --%>
<%--<form action="${pageContext.request.contextPath}/demo4.do" method="post">
	姓名：<input type="text" name="users[0].username"/><br/>
	年龄：<input type="text" name="users[0].age"/><br/>
	生日：<input type="text" name="users[0].birthday"/><br/>
	爱好：<input type="checkbox" name="users[0].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users[0].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users[0].hobby" value="写代码"/>写代码
		<br/>
	姓名：<input type="text" name="users[1].username"/><br/>
	年龄：<input type="text" name="users[1].age"/><br/>
	生日：<input type="text" name="users[1].birthday"/><br/>
	爱好：<input type="checkbox" name="users[1].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users[1].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users[1].hobby" value="写代码"/>写代码
		<br/>
	姓名：<input type="text" name="users[2].username"/><br/>
	年龄：<input type="text" name="users[2].age"/><br/>
	生日：<input type="text" name="users[2].birthday"/><br/>
	爱好：<input type="checkbox" name="users[2].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users[2].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users[2].hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form>--%>
<%--请求参数封装：Map集合类型的封装
<form action="${pageContext.request.contextPath}/demo5.do" method="post">
	姓名：<input type="text" name="users['key1'].username"/><br/>
	年龄：<input type="text" name="users['key1'].age"/><br/>
	生日：<input type="text" name="users['key1'].birthday"/><br/>
	爱好：<input type="checkbox" name="users['key1'].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users['key1'].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users['key1'].hobby" value="写代码"/>写代码
		<br/>
	姓名：<input type="text" name="users['abc'].username"/><br/>
	年龄：<input type="text" name="users['abc'].age"/><br/>
	生日：<input type="text" name="users['abc'].birthday"/><br/>
	爱好：<input type="checkbox" name="users['abc'].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users['abc'].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users['abc'].hobby" value="写代码"/>写代码
		<br/>
	姓名：<input type="text" name="users['key'].username"/><br/>
	年龄：<input type="text" name="users['key'].age"/><br/>
	生日：<input type="text" name="users['key'].birthday"/><br/>
	爱好：<input type="checkbox" name="users['key'].hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="users['key'].hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="users['key'].hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form>--%>
</body>
</html>