<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>试卷</title>
</head>
<body>
	<s:form action="ExaminationSave">
		<s:hidden name="questionnaireID" />
		试卷标题:
		<s:property value="questionnaire.title" />
		<br /> 试卷描述:
		<s:property value="questionnaire.description" />
		<br /> 问题
		<br>
		<s:iterator value="questionnaire.questions" status="status">
		(<s:property value="#status.index+1" />)
		<s:property value="caption" />
			<br />
			<s:radio list="options" name="questionID%{questionID}"
				listKey="optionID" listValue="caption" />
			<br />
		</s:iterator>
		<s:submit value="保存" />
	</s:form>
</body>
</html>