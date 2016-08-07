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
<script>
	var count = <s:property value="typewrite.timeLimit" />;
	var maxSecond = count * 60;
	function countDown() {
		if (maxSecond > 0) {
			maxSecond--;
		} else {
			// 提交结果
			document.getElementById("form").submit();
		}
		var m = Math.floor(maxSecond / 60);
		var s = Math.floor(maxSecond % 60);
		// var s=Math.floor(maxSecond/);
		$("#lblCountDown").text(m + ":" + s);
	}
	setInterval(countDown, 1000);
</script>
<title>打字测试</title>
</head>
<body>
	<div class="container">
		<h1>打字测试</h1>
		<s:form class="form-horizontal" action="TypewriteTestSave" id="form">
			<s:hidden name="userID" />
			<s:hidden name="questionnaireID" />
			<s:hidden name="questionID" />
			<div class="form-group">
				<label for="exampleInputEmail1">事例</label> <img class="img-responsive" alt="Responsive image" src="<s:property value="typewrite.captionImage" />">
			</div>
			<div class="form-group">
				<label>剩余时间</label> <label id="lblCountDown"></label>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">输入上图的内容</label>
				<s:textarea class="form-control" id="text" name="text" rows="3" />
			</div>
			<button type="submit" class="btn btn-primary">保存</button>
		</s:form>
	</div>
</body>
</html>