<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问题编辑</title>
</head>
<body>
	<s:form action="QuestionSave">
		<!-- 问卷部分 -->
		<s:hidden name="question.questionID" />
		<s:textfield name="question.caption" label="内容" />
		<s:select label="类型" name="question.questionType"
			list="ddlQuestionType" listKey="key" listValue="value"
			value="TemperamentTest" />
		<!-- 问题部分 -->
		<div>
			<table>
				<tr>
					<th>选项</th>
					<th>内容</th>
					<th>分值</th>
					<th>操作</th>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>上移 下移 编辑 刪除</td>
				</tr>
			</table>
		</div>
		<!-- 弹出窗口 -->
		<div></div>
		<s:submit value="Submit" />
	</s:form>
</body>
</html>