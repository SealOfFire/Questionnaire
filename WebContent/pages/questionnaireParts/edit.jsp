<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="styles/jquery-ui.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function() {
		var dialog1, dialog2, dialog1, form,

		dialog1 = $("#dialog1").dialog({
			autoOpen : false,
			width : 650,
			modal : true
		});

		dialog2 = $("#dialog2").dialog({
			autoOpen : false,
			width : 650,
			modal : true
		});

		dialog3 = $("#dialog3").dialog({
			autoOpen : false,
			width : 650,
			modal : true
		});

		/* 点击创建选项按钮，弹出对话框 */
		$("#btnSelectParts1").button().on("click", function() {
			dialog1.dialog("open");
		});

		$("#btnSelectParts2").button().on("click", function() {
			dialog2.dialog("open");
		});

		$("#btnSelectParts3").button().on("click", function() {
			dialog3.dialog("open");
		});
	});
</script>
<title>试卷组编辑</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation" class="active"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>试卷组编辑</h1>
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">性格测试</div>
			<div class="panel-body">
				<s:property value="selectParts1.title" />
				<button class="btn btn-default" id="btnSelectParts1">选择</button>
			</div>
		</div>

		<div class="panel panel-default panel-primary">
			<div class="panel-heading">坐席素质</div>
			<div class="panel-body">
				<s:property value="selectParts2.title" />
				<button class="btn btn-default" id="btnSelectParts2">选择</button>
			</div>
		</div>

		<div class="panel panel-default panel-primary">
			<div class="panel-heading">打字测试</div>
			<div class="panel-body">
				<s:property value="selectParts3.title" />
				<button class="btn btn-default" id="btnSelectParts3">选择</button>
			</div>
		</div>
	</div>
	<!-- --------------------- 弹出窗口 end --------------------- -->
	<div id="dialog1" title="性格测试题">
		<table class="table table-striped table-bordered table-hover table-responsive">
			<tr>
				<th style="text-align: center;" class="col-sm-1">编号</th>
				<th style="text-align: center;" class="col-sm-2">问卷名称</th>
				<th style="text-align: center;" class="col-sm-1">类型</th>
				<th style="text-align: center;" class="col-sm-1">限时(分钟)</th>
				<th style="text-align: center;" class="col-sm-1">操作</th>
			</tr>
			<s:iterator value="parts1" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td style="text-align: center;"><s:property value="questionnaireTypeString" /></td>
					<td style="text-align: center;"><s:property value="timeLimit" /></td>
					<td style="text-align: center;"><a
						href="<s:url action="QuestionnairePartsSave">
						<s:param name="selectedID" value="questionnaireID"></s:param>
						<s:param name="partsNo" value="1"></s:param>
						</s:url>">选择</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div id="dialog2" title="坐席素质题">
		<table class="table table-striped table-bordered table-hover table-responsive">
			<tr>
				<th style="text-align: center;" class="col-sm-1">编号</th>
				<th style="text-align: center;" class="col-sm-2">问卷名称</th>
				<th style="text-align: center;" class="col-sm-1">类型</th>
				<th style="text-align: center;" class="col-sm-1">限时(分钟)</th>
				<th style="text-align: center;" class="col-sm-1">操作</th>
			</tr>
			<s:iterator value="parts2" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td style="text-align: center;"><s:property value="questionnaireTypeString" /></td>
					<td style="text-align: center;"><s:property value="timeLimit" /></td>
					<td style="text-align: center;"><a
						href="<s:url action="QuestionnairePartsSave">
						<s:param name="selectedID" value="questionnaireID"></s:param>
						<s:param name="partsNo" value="2"></s:param>
						</s:url>">选择</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div id="dialog3" title="打字测试题">
		<table class="table table-striped table-bordered table-hover table-responsive">
			<tr>
				<th style="text-align: center;" class="col-sm-1">编号</th>
				<th style="text-align: center;" class="col-sm-1">标题</th>
				<th style="text-align: center;" class="col-sm-2">内容</th>
				<th style="text-align: center;" class="col-sm-1">操作</th>
			</tr>
			<s:iterator value="parts3" status="status">
				<tr>
					<td style="text-align: center;"><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="captionText" /></td>
					<td style="text-align: center;"><a
						href="<s:url action="QuestionnairePartsSave">
						<s:param name="selectedID" value="questionID"></s:param>
						<s:param name="partsNo" value="3"></s:param>
						</s:url>">选择</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<!-- --------------------- 弹出窗口 end --------------------- -->
</body>
</html>