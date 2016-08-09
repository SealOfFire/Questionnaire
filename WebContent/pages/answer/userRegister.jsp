<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/jquery-ui.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>用户信息收集</title>
</head>
<body>
	<div class="container">
		<h1>人员信息收集</h1>
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">人员信息</div>
			<div class="panel-body">
				<s:form class="form-horizontal" action="AnswerRegister">
					<div class="form-group">
						<label class="col-sm-1 control-label">姓名</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">电话</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.phoneNumber" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">身份证号</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.IDCardNumber" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">性别</label>
						<div class="col-sm-1">
							<s:select class="form-control" name="userInfo.sex" label="性别"
								list="ddlSex" listKey="key" listValue="value"
								value="userInfo.sex" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">区域中心</label>
						<div class="col-sm-2">
							<s:select class="form-control" name="userInfo.area"
								list="ddlArea" listKey="key" listValue="value"
								value="userInfo.area" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-10">
							<s:submit class="btn btn-primary" value="保存" />
						</div>
					</div>
					<%-- <s:textfield name="userInfo.name" label="其他信息1" /> --%>
					<%-- <s:textfield name="userInfo.name" label="其他信息2" /> --%>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>