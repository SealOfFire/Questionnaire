<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="styles/jquery-ui.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script>
	$(function() {
		var dialog, form,

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 350,
			modal : true
		});

		/* 点击创建选项按钮，弹出对话框 */
		$("#btnCreateOption").button().on("click", function() {
			dialog.dialog("open");
		});
	});
</script>
<title>问题编辑</title>
</head>
<body>
	<a href="<s:url action='QuestionList'/>">返回</a>
	<s:form action="QuestionSave">
		<!-- 问卷部分 -->
		<s:hidden name="question.questionID" />
		<s:textfield name="question.caption" label="内容" />
		<s:select label="类型" name="question.questionType"
			list="ddlQuestionType" listKey="key" listValue="value"
			value="question.questionType" />
		<s:submit value="保存" />
	</s:form>
	<br />
	<br />
	<!-- --------------------- 问题部分 start --------------------- -->
	<div>
		<table>
			<tr>
				<th>选项</th>
				<th>内容</th>
				<th>分值</th>
				<th>操作</th>
			</tr>
			<s:iterator value="options" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="caption" /></td>
					<td><s:property value="score" /></td>
					<td><a onclick="javascript:return p_del();"
						href="<s:url action="OptionDelete"><s:param name="optionID" value="optionID"></s:param><s:param name="questionID" value="questionID"></s:param></s:url>">删除</a></td>
				</tr>
			</s:iterator>
		</table>
		<button id="btnCreateOption">添加选项</button>
	</div>
	<!-- --------------------- 问题部分 end --------------------- -->
	<br />
	<br />
	<!-- --------------------- 弹出窗口 end --------------------- -->
	<div id="dialog-form" title="创建选项">
		<s:form action="OptionCreate">
			<s:hidden name="questionID" />
			<s:textfield name="option.caption" label="内容" />
			<s:textfield name="option.score" label="分值" />
			<s:submit value="创建" />
		</s:form>
	</div>
	<!-- --------------------- 弹出窗口 end --------------------- -->
</body>
</html>