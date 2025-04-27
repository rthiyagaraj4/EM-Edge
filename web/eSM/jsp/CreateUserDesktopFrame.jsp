<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
        <script src="../../eSM/js/CreatUserDesktop.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ; // frameAddModifyCreateUserDesktop

%>
	<iframe name="construct_ca_menu" id="construct_ca_menu"  src='../../eSM/jsp/AddModifyCreateUserDesktop.jsp?<%=params%>'frameborder=0 scrolling="no" noresize style='height:45vh;width:100vw'></iframe>
		<iframe name='frameAddModifyCreateUserDesktopResult' id='frameAddModifyCreateUserDesktopResult' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:61vh;width:100vw'></iframe> 
	
</html>

