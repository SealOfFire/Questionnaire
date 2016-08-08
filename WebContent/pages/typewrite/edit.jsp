<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/html2canvas.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script>
	function screenshot() {
		html2canvas(
				document.getElementsByName("typewrite.captionText")[0],
				{
					onrendered : function(canvas) {
						// document.body.appendChild(canvas);
						var myImage = canvas.toDataURL("image/jpeg");
						document.getElementsByName("typewrite.captionImage")[0].value = myImage;
						document.getElementById("form").submit();
					}
				});
		//var canvas = html2canvas(comments);
		//alert(canvas);
	}
</script>
<title>编辑问题</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<s:url action='InterviewList'/>">面试列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnaireList'/>">问卷列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionList'/>">问题列表</a></li>
			<li role="presentation" class="active"><a href="<s:url action='TypewriteList'/>">打字题列表</a></li>
			<li role="presentation"><a href="<s:url action='QuestionnairePartsEdit'/>">编辑试卷</a></li>
			<li role="presentation"><a href="<s:url action='AnswerInit'/>">答题</a></li>
		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h1>打字题编辑</h1>
		<p>
			<a class="btn btn-default" role="button" href="<s:url action='TypewriteList'/>">返回</a>
		</p>
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">打字题编辑</div>
			<div class="panel-body">
				<s:form class="form-horizontal" id="form" action="TypewriteSave">
					<s:hidden name="typewrite.questionID" />
					<s:hidden name="typewrite.captionImage" />
					<div class="form-group">
						<label class="col-sm-1 control-label">名称</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="typewrite.title" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">时限</label>
						<div class="col-sm-1">
							<s:textfield class="form-control" name="typewrite.timeLimit" />
						</div>
						<label class="control-label">分</label>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">内容</label>
						<div class="col-sm-11">
							<s:textarea class="form-control" id="typewrite.captionText" name="typewrite.captionText" rows="3" />
						</div>
					</div>
					<s:fielderror style="color:red;">
						<s:param>errmsg</s:param>
					</s:fielderror>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-10">
							<input type="button" class="btn btn-primary" onclick="javascript:screenshot();" value="保存">
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>