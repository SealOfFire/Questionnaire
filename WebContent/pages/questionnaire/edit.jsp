<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷编辑</title>
</head>
<body>
	<p>问卷编辑</p>
	<s:form action="QuestionnaireEdit">
		<!-- 问卷部分 -->
		<s:hidden name="questionnaireID" />
		<s:textfield name="questionnaire.title" label="名称" />
		<s:select label="类型" name="questionnaire.questionnaireType"
			list="ddlQuestionnaireType" listKey="key" listValue="value"
			value="TemperamentTest" />
		<s:textfield name="questionnaire.timeLimit" label="限时" />
		<!-- 问题部分 -->
		<s:submit value="Submit" />
	</s:form>
</body>
</html>