<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>人员列表</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>面试列表</h1>
		<table class="table table-striped table-bordered table-hover table-responsive">
			<tr>
				<th style="text-align: center;">序号</th>
				<th style="text-align: center;">区域中心</th>
				<th style="text-align: center;">姓名</th>
				<th style="text-align: center;">性别</th>
				<th style="text-align: center;">联系方式</th>
				<th style="text-align: center;">身份证号</th>
				<th style="text-align: center;">心理测试得分</th>
				<th style="text-align: center;">打字速度得分</th>
				<th style="text-align: center;">岗前通班得分</th>
				<th style="text-align: center;">总分</th>
				<th style="text-align: center;">操作</th>
			</tr>
			<s:iterator value="userInfos" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td style="text-align: center;">1</td>
					<td style="text-align: center;"><s:property value="name" /></td>
					<td style="text-align: center;"><s:property value="sex" /></td>
					<td style="text-align: center;"><s:property value="PhoneNumber" /></td>
					<td style="text-align: center;"><s:property value="IDCardNumber" /></td>
					<td style="text-align: center;">2</td>
					<td style="text-align: center;">3</td>
					<td style="text-align: center;">4</td>
					<td style="text-align: center;">5</td>
					<td style="text-align: center;"><a href="<s:url action="InterviewScore"><s:param name="userID" value="userID"></s:param></s:url>">打分</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>