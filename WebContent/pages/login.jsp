<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>登陆</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">用户登陆</div>
			<div class="panel-body">
				<s:form class="form-horizontal" action="login">
					<s:hidden name="questionnaire.questionnaireID" />
					<div class="form-group">
						<label class="col-sm-1 control-label">用户名</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userName" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">密码</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="password" />
						</div>
					</div>
					<div class="form-group">
						<s:fielderror style="color:red;">
							<s:param>userName</s:param>
						</s:fielderror>
						<div class="col-sm-offset-1 col-sm-10">
							<s:submit class="btn btn-primary" value="保存" />
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>