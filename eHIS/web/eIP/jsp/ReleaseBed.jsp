<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
	<iframe src="../jsp/ReleaseBedMain.jsp?<%=request.getQueryString()%>" name="ReleaseBed_main"  frameborder=0 noresize scrolling=NO style="height:25vh;width:98vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="ReleaseBed_details" id="ReleaseBed_details" frameborder=0 noresize style="height:68vh;width:98vw"></iframe>
	
</html>

