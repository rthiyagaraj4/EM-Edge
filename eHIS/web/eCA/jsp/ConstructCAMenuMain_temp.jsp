<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="javascript" src="../js/ConstructCAMenu_temp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ; // frameAddModifyCreateUserDesktop
%>
	<iframe name="construct_ca_menu" id="construct_ca_menu"  src='../../eCA/jsp/AddModifyCreateUserDesktop.jsp?<%=params%>'frameborder=0 scrolling="no" noresize style='height:250%;width:100vw'></iframe>
		<iframe name='frameAddModifyCreateUserDesktopResult' id='frameAddModifyCreateUserDesktopResult' 	src='../../eCA/jsp/ConstructUserDesktop.jsp?<%=params%>' frameborder=0 noresize style='height:100vh;width:100vw'></iframe> 
	
</html>

