<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用ActionContext向ContextMap存入值</title>
</head>
<body>
<%--借助struts2的标签库来查看ContextMap中的内容 --%>
<s:debug/>

<hr size="50" color="pink"/>
<%--借助struts2的s:property标签和OGNL表达式获取ActionContext存入的数据
我们现在获取的数据，都是在map中。
获取Map中的数据，OGNL表达式的写法：
	#key
	如果还想继续向下获取，使用.key的方式
--%>
<s:property value="#contextMap"/><br/>
<s:property value="#application.applicationKey"/><br/>
<s:property value="#session.sessionServlet"/>
<hr/>
<s:property value="#session.sessionKey"/>
<hr/>
<s:property value="#attr.session"></s:property>
</body>
</html>
