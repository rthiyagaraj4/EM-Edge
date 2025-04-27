<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
        <script src="../../ePH/js/CreatUserDesktop.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ; // frameAddModifyCreateUserDesktop

%>
	<iframe name="construct_ca_menu" id="construct_ca_menu"  src='../../ePH/jsp/AddModifyCreateUserDesktop.jsp?<%=params%>'frameborder=0 scrolling="no" noresize style='height:26vh;width:98vw'></iframe>
		<iframe name='frameAddModifyCreateUserDesktopResult' id='frameAddModifyCreateUserDesktopResult' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:69vh;width:98vw'></iframe> 
	
</html>

