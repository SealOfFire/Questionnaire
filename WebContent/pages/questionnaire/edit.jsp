<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/common.js"></script>
<title>问卷编辑</title>
</head>
<body>
	<a href="<s:url action='QuestionnaireList'/>">返回</a>
	<s:form action="QuestionnaireSave">
		<!-- 问卷部分 -->
		<s:hidden name="questionnaire.questionnaireID" />
		<s:textfield name="questionnaire.title" label="名称" />
		<s:select label="类型" name="questionnaire.questionnaireType"
			list="ddlQuestionnaireType" listKey="key" listValue="value"
			value="questionnaire.questionnaireType" />
		<s:textfield name="questionnaire.timeLimit" label="限时" />
		<!-- 问题部分 -->
		<s:submit value="保存" />
	</s:form>
	<!-- --------------------- 问题部分 start --------------------- -->
	<div>
		<p>已选问题</p>
		<table>
			<tr>
				<th>序号</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<s:iterator value="questions" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="caption" /></td>
					<td><a onclick="javascript:return p_del();"
						href="<s:url action="QuestionnaireQuestionDelete"><s:param name="questionID" value="questionID"></s:param><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">删除</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<!-- --------------------- 问题部分 end --------------------- -->
	<!-- --------------------- 被选题 start --------------------- -->
	<div>
		<p>备选问题</p>
		<table>
			<tr>
				<th>序号</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<s:iterator value="allQuestions" status="status">
				<tr>
					<td><s:property value="#status.index+1" /></td>
					<td><s:property value="caption" /></td>
					<td><a
						href="<s:url action="QuestionnaireQuestionAdd"><s:param name="questionID" value="questionID"></s:param><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">添加</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<!-- --------------------- 被选题 end --------------------- -->
</body>
</html>