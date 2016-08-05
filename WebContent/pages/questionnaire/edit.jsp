<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>问卷编辑</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation" class="active"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
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
		<h1>问卷编辑</h1>
		<p>
			<a class="btn btn-default" role="button" href="<s:url action='QuestionnaireList'/>">返回</a>
		</p>
		<!-- --------------------- 问卷部分 start --------------------- -->
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">问卷编辑</div>
			<div class="panel-body">
				<s:form class="form-horizontal" action="QuestionnaireSave">
					<s:hidden name="questionnaire.questionnaireID" />
					<div class="form-group">
						<label class="col-sm-1 control-label">名称</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="questionnaire.title" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">内容</label>
						<div class="col-sm-11">
							<s:textarea class="form-control" id="questionnaire.description" name="questionnaire.description" rows="3" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">类型</label>
						<div class="col-sm-2">
							<s:select class="form-control" name="questionnaire.questionnaireType" list="ddlQuestionnaireType" listKey="key" listValue="value" value="questionnaire.questionnaireType" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">时限</label>
						<div class="col-sm-2">
							<s:textfield class="form-control" name="questionnaire.timeLimit" label="限时" />
						</div>
						<label class="control-label">分钟</label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-10">
							<s:submit class="btn btn-primary" value="保存" />
						</div>
					</div>
				</s:form>
			</div>
		</div>
		<!-- --------------------- 问卷部分 end --------------------- -->

		<!-- --------------------- 问题部分 start --------------------- -->
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">已选问题</div>
			<div class="panel-body"></div>
			<table class="table table-striped table-bordered table-hover table-responsive">
				<tr>
					<th style="text-align: center;" class="col-sm-1">序号</th>
					<th style="text-align: center;">内容</th>
					<th style="text-align: center;" class="col-sm-1">操作</th>
				</tr>
				<s:iterator value="questions" status="status">
					<tr>
						<td style="text-align: center;"><s:property value="#status.index+1" /></td>
						<td><s:property value="caption" /></td>
						<td style="text-align: center;"><a href="<s:url action="QuestionEdit">
						<s:param name="questionID" value="questionID"></s:param></s:url>">编辑</a>&nbsp;<a
							onclick="javascript:return p_del();"
							href="<s:url action="QuestionnaireQuestionDelete"><s:param name="questionID" value="questionID"></s:param><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<!-- --------------------- 问题部分 end --------------------- -->

		<!-- --------------------- 被选题 start --------------------- -->
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">备选问题</div>
			<div class="panel-body"></div>
			<table class="table table-striped table-bordered table-hover table-responsive">
				<tr>
					<th style="text-align: center;" class="col-sm-1">序号</th>
					<th style="text-align: center;">内容</th>
					<th style="text-align: center;" class="col-sm-1">操作</th>
				</tr>
				<s:iterator value="allQuestions" status="status">
					<tr>
						<td style="text-align: center;"><s:property value="#status.index+1" /></td>
						<td><s:property value="caption" /></td>
						<td style="text-align: center;"><a href="<s:url action="QuestionEdit">
						<s:param name="questionID" value="questionID"></s:param></s:url>">编辑</a>&nbsp;<a
							href="<s:url action="QuestionnaireQuestionAdd"><s:param name="questionID" value="questionID"></s:param><s:param name="questionnaireID" value="questionnaireID"></s:param></s:url>">添加</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<!-- --------------------- 被选题 end --------------------- -->
	</div>
</body>
</html>