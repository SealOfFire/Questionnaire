<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/common.js"></script>
<title>评分</title>
</head>
<body>
	<a href="<s:url action='InterviewList'/>">返回面试人员列表</a>

	<table>
		<tr>
			<td>序号</td>
			<td>考察项目</td>
			<td>标准</td>
			<td>面试问题</td>
			<td>追问</td>
			<td>评分</td>
		</tr>
		<s:iterator value="interviews" status="status">
			<tr>
				<td><s:property value="#status.index+1" /></td>
				<td><s:property value="title" /></td>
				<td><s:property value="standard" /></td>
				<td><s:property value="question" /></td>
				<td><s:property value="questionAdd" /></td>
				<td></td>
			</tr>
		</s:iterator>
	</table>
	请依照下列标准进行评分
	<br /> 1-2分：非常差;&nbsp;3-4分：差
	<br /> 综合评价
	<br />
</body>
</html>