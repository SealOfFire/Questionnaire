<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/common.js"></script>
<title>问题列表</title>
</head>
<body>
	<p>问题列表</p>
	<a href="<s:url action='QuestionCreate'/>">创建问题</a>
	<table>
		<tr>
			<th>编号</th>
			<th>问题名称</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<s:iterator value="questions" status="status">
			<tr>
				<td><s:property value="#status.index+1" /></td>
				<td><s:property value="caption" /></td>
				<td><s:property value="questionTypeString" /></td>
				<td><a
					href="<s:url action="QuestionEdit"><s:param name="questionID" value="questionID"></s:param></s:url>">编辑</a>
					<a onclick="javascript:return p_del();"
					href="<s:url action="QuestionDelete"><s:param name="questionID" value="questionID"></s:param></s:url>">删除</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>