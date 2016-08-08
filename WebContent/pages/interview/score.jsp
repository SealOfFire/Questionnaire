<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>评分</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>面试打分</h1>
		<p>
			<a class="btn btn-default" role="button" href="<s:url action='InterviewList'/>">返回</a>
		</p>
		<s:form action="InterviewSave">
			<s:hidden name="userID" />
			<table class="table table-striped table-bordered table-hover table-responsive">
				<tr>
					<td style="text-align: center;" class="col-sm-1">序号</td>
					<td style="text-align: center;">考察项目</td>
					<td style="text-align: center;">标准</td>
					<td style="text-align: center;">面试问题</td>
					<td style="text-align: center;">追问</td>
					<td style="text-align: center;" class="col-sm-1">评分</td>
				</tr>
				<s:iterator value="interviews" status="status">
					<tr>
						<td style="text-align: center;"><s:property value="#status.index+1" /></td>
						<td style="vertical-align: middle;"><s:property value="title" /></td>
						<td style="vertical-align: middle;"><s:property value="standard" /></td>
						<td style="vertical-align: middle;"><s:property value="question" /></td>
						<td style="vertical-align: middle;"><s:property value="questionAdd" /></td>
						<td style="text-align: center;"><s:textfield class="form-control" name="%{questionID}" value="%{score}" /></td>
					</tr>
				</s:iterator>
			</table>
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">综合评价</div>
				<div class="panel-body">
					<p>请依照下列标准进行评分</p>
					<p>1-2分:非常差;&nbsp;&nbsp;&nbsp;3-4分:差&nbsp;&nbsp;&nbsp;5分:较差&nbsp;&nbsp;&nbsp;6分:基本合格;&nbsp;&nbsp;&nbsp;7分:一般&nbsp;&nbsp;&nbsp;8-9分:良好;&nbsp;&nbsp;&nbsp;10分:优秀</p>
					<p>
						<s:textarea class="form-control" id="overall" name="overall" rows="3" />
					</p>
					<p>
						<s:fielderror style="color:red;">
							<s:param>errmsg</s:param>
						</s:fielderror>
					</p>
					<p>
						<s:submit class="btn btn-primary" action="login" value="保存" />
					</p>
				</div>
			</div>
		</s:form>
	</div>
</body>
</html>