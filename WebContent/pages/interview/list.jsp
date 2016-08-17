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
				<th style="text-align: center;">来源</th>
				<th style="text-align: center;">姓名</th>
				<th style="text-align: center;">性别</th>
				<th style="text-align: center;">联系方式</th>
				<th style="text-align: center;">身份证号</th>
				<th style="text-align: center;">性格测试</th>
				<th style="text-align: center;">坐席测试</th>
				<th style="text-align: center;">打字速度得分</th>
				<th style="text-align: center;">面试得分</th>
				<th style="text-align: center;">总分</th>
				<th style="text-align: center;">岗前通关得分</th>
				<th style="text-align: center;">操作</th>
			</tr>
			<s:iterator value="userInfos" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td style="text-align: center;"><s:property value="area" /></td>
					<td style="text-align: center;"><s:property value="from" /></td>
					<td style="text-align: center;"><s:property value="name" /></td>
					<td style="text-align: center;"><s:property value="sexString" /></td>
					<td style="text-align: center;"><s:property value="PhoneNumber" /></td>
					<td style="text-align: center;"><s:property value="IDCardNumber" /></td>
					<td style="text-align: center;">
						<a target="_blank" href="<s:url action="Detail"><s:param name="userID" value="userID"></s:param><s:param name="questionnaireID" value="questionnaireID1"></s:param></s:url>"><s:property value="score1" /></a>
					</td>
					<td style="text-align: center;">
						<a target="_blank" href="<s:url action="Detail"><s:param name="userID" value="userID"></s:param><s:param name="questionnaireID" value="questionnaireID2"></s:param></s:url>"><s:property value="score2" /></a>
					</td>
					<td style="text-align: center;"><s:property value="score3" /></td>
					<td style="text-align: center;"><s:property value="score4" /></td>
					<td style="text-align: center;"><s:property value="sumALLScore" /></td>
					<td style="text-align: center;"><s:property value="score5" /></td>
					<td style="text-align: center;"><a href="<s:url action="InterviewScore"><s:param name="userID" value="userID"></s:param></s:url>">打分</a> <a
						onclick="javascript:return p_del();" href="<s:url action="InterviewDelete"><s:param name="userID" value="userID"></s:param></s:url>">删除</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>