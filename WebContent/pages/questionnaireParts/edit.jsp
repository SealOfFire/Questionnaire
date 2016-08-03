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
		var dialog1, dialog2, dialog1, form,

		dialog1 = $("#dialog1").dialog({
			autoOpen : false,
			modal : true
		});

		dialog2 = $("#dialog2").dialog({
			autoOpen : false,
			modal : true
		});

		dialog3 = $("#dialog3").dialog({
			autoOpen : false,
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
	<a href="<s:url action='index'/>">返回首页</a>
	<br /> 性格测试
	<button id="btnSelectParts1">选择</button>
	<s:property value="selectParts1.title" />
	<br />坐席素质
	<button id="btnSelectParts2">选择</button>
	<s:property value="selectParts2.title" />
	<br />打字测试
	<button id="btnSelectParts3">选择</button>
	<s:property value="selectParts3.title" />
	<br />
	<!-- --------------------- 弹出窗口 end --------------------- -->
	<div id="dialog1" title="性格测试题">
		<table>
			<tr>
				<th>编号</th>
				<th>问卷名称</th>
				<th>类型</th>
				<th>限时(分钟)</th>
				<th>操作</th>
			</tr>
			<s:iterator value="parts1" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="timeLimit" /></td>
					<td><s:property value="questionnaireTypeString" /></td>
					<td><a
						href="<s:url action="QuestionnairePartsSave">
						<s:param name="selectedID" value="questionnaireID"></s:param>
						<s:param name="partsNo" value="1"></s:param>
						</s:url>">选择</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div id="dialog2" title="坐席素质题">
		<table>
			<tr>
				<th>编号</th>
				<th>问卷名称</th>
				<th>类型</th>
				<th>限时(分钟)</th>
				<th>操作</th>
			</tr>
			<s:iterator value="parts2" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="timeLimit" /></td>
					<td><s:property value="questionnaireTypeString" /></td>
					<td><a
						href="<s:url action="QuestionnairePartsSave">
						<s:param name="selectedID" value="questionnaireID"></s:param>
						<s:param name="partsNo" value="2"></s:param>
						</s:url>">选择</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div id="dialog3" title="打字测试题">
		<table>
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<s:iterator value="parts3" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="captionText" /></td>
					<td><a
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