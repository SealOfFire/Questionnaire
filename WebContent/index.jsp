<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
	<p>
		<a href="<s:url action='InterviewList'/>">面试列表</a>
	</p>
	<p>
		<a href="<s:url action='QuestionnaireList'/>">问卷列表</a>
	</p>
	<p>
		<a href="<s:url action='QuestionList'/>">问题列表</a>
	</p>
	<p>
		<a href="<s:url action='AnswerInit'/>">答题</a>
	</p>
</body>
</html>