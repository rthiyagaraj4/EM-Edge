<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body CLASS='MESSAGE' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name=Dynamic_form>         
			<input type=hidden name='M' id='M' value=''>
			<input type=hidden name='F' id='F' value=''>
			<input type=hidden name='U' id='U' value=''>
			<input type=hidden name='T' id='T' value=''>
			<input type=hidden name='S' id='S' value=''>
 			<input type=hidden name='B' id='B' value=''>
		</form>
	</body>
</html>
	

