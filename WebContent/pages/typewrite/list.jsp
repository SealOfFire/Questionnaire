<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>打字题列表</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation" class="active"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>打字题列表</h1>
		<p>
			<a class="btn btn-default" role="button" href="<s:url action='TypewriteCreate'/>">创建问题</a>
		</p>
		<table class="table table-striped table-bordered table-hover table-responsive">
			<tr>
				<th style="text-align: center;" class="col-sm-1">编号</th>
				<th style="text-align: center;" class="col-sm-3">标题</th>
				<th style="text-align: center;">内容</th>
				<th style="text-align: center;" class="col-sm-1">操作</th>
			</tr>
			<s:iterator value="typewrites" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="captionText" /></td>
					<td style="text-align: center;"><a href="<s:url action="TypewriteEdit"><s:param name="questionID" value="questionID"></s:param></s:url>">编辑</a>&nbsp;<a onclick="javascript:return p_del();"
						href="<s:url action="TypewriteDelete"><s:param name="questionID" value="questionID"></s:param></s:url>">删除</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>