<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/jquery-ui.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>试卷</title>
</head>
<body>
	<div class="container">
		<s:form action="ExaminationSave">
			<s:hidden name="questionnaireID" />
			<s:hidden name="userID" />
			<h1>
				<s:property value="questionnaire.title" />
			</h1>
			<p>
				<s:property value="questionnaire.description" />
			</p>
			<br>
			<s:iterator value="questionnaire.questions" status="status">
				<div class="panel panel-default">
					<div class="panel-heading">
						(
						<s:property value="#status.index+1" />
						)
						<s:property value="caption" />
					</div>
					<div class="panel-body">
						<s:radio list="options" name="questionID%{questionID}" listKey="optionID" listValue="caption" />
					</div>
				</div>
			</s:iterator>
			<s:submit class="btn btn-primary" value="保存" />
		</s:form>
	</div>
</body>
</html>