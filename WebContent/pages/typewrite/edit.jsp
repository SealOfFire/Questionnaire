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
		html2canvas(element, {
			onrendered : function(canvas) {
				// canvas 是最后一个渲染的<canvas> 元素
				var url = canvas.toDataURL();
			}
		});
	}
</script>
<title>编辑问题</title>
</head>
<body>
	<a href="<s:url action='TypewriteList'/>">返回</a>
	<s:form action="TypewriteSave">
		<s:textarea label="内容" name="comments" cols="50" rows="20" />
		<s:submit onclick="javascript:alert();" value="保存" />
	</s:form>
</body>
</html>