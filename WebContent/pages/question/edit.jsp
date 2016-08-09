<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/jquery-ui.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function() {
		var dialog, form,

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 350,
			width : 500,
			modal : true
		});

		/* 点击创建选项按钮，弹出对话框 */
		$("#btnCreateOption").button().on("click", function() {
			dialog.dialog("open");
		});
	});

	function validate() {
		var patt1 = new RegExp("^[0-9]+(.[0-9]{2})?$");
		patt1.test($("#option.score").text());
	}
</script>
<title>问题编辑</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation" class="active"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>编辑问题</h1>
		<p>
			<a class="btn btn-default" role="button" href="<s:url action='QuestionList'/>">返回</a>
		</p>
		<!-- --------------------- 问题部分 start --------------------- -->
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">题目编辑</div>
			<div class="panel-body">
				<s:form class="form-horizontal" action="QuestionSave">
					<s:hidden name="question.questionID" />
					<div class="form-group">
						<label class="col-sm-1 control-label">内容</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="question.caption" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">类型</label>
						<div class="col-sm-2">
							<s:select class="form-control" name="question.questionType" list="ddlQuestionType" listKey="key" listValue="value" value="question.questionType" />
						</div>
					</div>
					<s:fielderror style="color:red;">
						<s:param>errmsg1</s:param>
					</s:fielderror>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-10">
							<s:submit class="btn btn-primary" value="保存" />
						</div>
					</div>
				</s:form>
			</div>
		</div>
		<!-- --------------------- 问题部分 end --------------------- -->

		<!-- --------------------- 选项 start --------------------- -->
		<s:if test="!question.notSaved()">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">选项编辑</div>
				<div class="panel-body">
					<button class="btn btn-default" id="btnCreateOption">添加选项</button>
				</div>
				<s:if test="options.size()>0">
					<table class="table table-striped table-bordered table-hover table-responsive">
						<tr>
							<th class="col-sm-1" style="text-align: center;">选项</th>
							<th style="text-align: center;">内容</th>
							<th class="col-sm-1" style="text-align: center;">分值</th>
							<th class="col-sm-1" style="text-align: center;">操作</th>
						</tr>
						<s:iterator value="options" status="status">
							<tr>
								<td style="text-align: center;"><s:property value="#status.index+1" /></td>
								<td><s:property value="caption" /></td>
								<td style="text-align: center;"><s:property value="score" /></td>
								<td style="text-align: center;"><a onclick="javascript:return p_del();"
									href="<s:url action="OptionDelete"><s:param name="optionID" value="optionID"></s:param><s:param name="questionID" value="questionID"></s:param></s:url>">删除</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
			</div>
		</s:if>
	</div>
	<!-- --------------------- 选项 end --------------------- -->

	<!-- --------------------- 弹出窗口 end --------------------- -->
	<div id="dialog-form" title="创建选项">
		<s:form class="form-horizontal" action="OptionCreate">
			<s:hidden name="questionID" />
			<div class="form-group">
				<label class="col-sm-2 control-label">内容</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="option.caption" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">分值</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="option.scoreString" id="option.scoreString" />
				</div>
			</div>
			<div class="form-group has-error">
				<label class="control-label col-sm-offset-2" id="errmsg2"></label>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit class="btn btn-primary" value="创建" />
				</div>
			</div>
		</s:form>
	</div>
	<!-- --------------------- 弹出窗口 end --------------------- -->
</body>
</html>