<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
	<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form>
			<input type=hidden name=SelectYNStr value="">
			<input type=hidden name=DeleteYNStr value="">
			<input type=hidden name=nursing_unit value="CC">
		</form>
	</body>
</html>

