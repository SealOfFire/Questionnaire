<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/html2canvas.js"></script>
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
	<a href="<s:url action='TypewriteList'/>">返回</a>
	<s:form id="form" action="TypewriteSave">
		<s:hidden name="typewrite.questionID" />
		<s:hidden name="typewrite.captionImage" />
		<s:textfield name="typewrite.title" label="标题" />
		<!-- <input type="hidden" name="hidImg" id="hidImg" value="" /> -->
		<s:textarea label="内容" id="typewrite.captionText"
			name="typewrite.captionText" cols="50" rows="20" />
	</s:form>
	<input type="button" onclick="javascript:screenshot();" value="保存">
</body>
</html>