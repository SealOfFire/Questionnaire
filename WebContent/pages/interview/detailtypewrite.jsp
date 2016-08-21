<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/jquery-ui.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>打字详细</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">人员信息</div>
			<div class="panel-body">
				<s:form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-1 control-label">姓名</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.name" disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">电话</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.phoneNumber" disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">身份证号</label>
						<div class="col-sm-11">
							<s:textfield class="form-control" name="userInfo.IDCardNumber" disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">性别</label>
						<div class="col-sm-1">
							<s:textfield class="form-control" name="userInfo.sexString" disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">区域中心</label>
						<div class="col-sm-2">
							<s:textfield class="form-control" name="userInfo.area" disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">来源</label>
						<div class="col-sm-2">
							<s:textfield class="form-control" name="userInfo.from" disabled="true" />
						</div>
					</div>
				</s:form>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">打字题</div>
			<div class="panel-body">
				<s:textarea class="form-control" id="typewriteAnswer" name="typewriteAnswer" rows="20" disabled="true" />
			</div>
		</div>
	</div>
</body>
</html>