<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/common.js"></script>
<title>人员列表</title>
</head>
<body>
	<a href="<s:url action='index'/>">返回首页</a>
	<table>
		<tr>
			<th>序号</th>
			<th>区域中心</th>
			<th>姓名</th>
			<th>性别</th>
			<th>联系方式</th>
			<th>身份证号</th>
			<th>心理测试得分</th>
			<th>打字速度得分</th>
			<th>岗前通班得分</th>
			<th>总分</th>
			<th>操作</th>
		</tr>
		<s:iterator value="userInfos" status="status">
			<tr>
				<td><s:property value="#status.index+1" /></td>
				<td>1</td>
				<td><s:property value="name" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="PhoneNumber" /></td>
				<td><s:property value="IDCardNumber" /></td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td><a
					href="<s:url action="InterviewScore"><s:param name="userID" value="userID"></s:param></s:url>">打分</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>