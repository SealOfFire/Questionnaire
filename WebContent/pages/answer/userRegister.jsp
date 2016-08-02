<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<s:form action="AnswerRegister">
		<!-- 用户信息 -->
		<s:textfield name="userInfo.name" label="姓名" />
		<s:textfield name="userInfo.phoneNumber" label="电话" />
		<s:textfield name="userInfo.IDCardNumber" label="身份证号" />
		<s:textfield name="userInfo.sex" label="性别" />
		<s:select name="userInfo.sex" label="性别" list="ddlSex" listKey="key"
			listValue="value" value="userInfo.sex" />
		<%-- <s:textfield name="userInfo.name" label="其他信息1" /> --%>
		<%-- <s:textfield name="userInfo.name" label="其他信息2" /> --%>
		<s:submit value="保存" />
	</s:form>
</body>
</html>