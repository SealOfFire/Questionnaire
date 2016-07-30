<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/common.js"></script>
<title>问卷列表</title>
</head>
<body>
	<p>问卷列表</p>
	<p>
		<a href="<s:url action='QuestionnaireCreate'/>">创建问卷</a>
	</p>
	<table>
		<tr>
			<th>编号</th>
			<th>问卷名称</th>
			<th>类型</th>
			<th>限时(分钟)</th>
			<th>操作</th>
		</tr>
		<s:iterator value="questionnaires" status="status">
			<tr>
				<td><s:property value="#status.index+1" /></td>
				<td><s:property value="title" /></td>
				<td><s:property value="timeLimit" /></td>
				<td><s:property value="questionnaireTypeString" /></td>
				<td><a
					href="<s:url action="QuestionnaireEdit"><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">编辑</a>
					<a onclick="javascript:return p_del();"
					href="<s:url action="QuestionnaireDelete"><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">删除</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>