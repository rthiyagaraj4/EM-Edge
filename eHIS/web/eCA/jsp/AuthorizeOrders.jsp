<!DOCTYPE html>
<!-- AuthorizeOrders.jsp -->
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<Title><fmt:message key="eOR.AuthorizeOrders.label" bundle="${or_labels}"/></Title>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	*/
%>
<frameset rows='15%,*%'>
	<frame name='AuthoriseOrderTop' id='AuthoriseOrderTop' src='AuthorizeOrdersTop.jsp' frameborder=0 scrolling='no' noresize>
	<!-- <frame name='AuthoriseOrderBottom' id='AuthoriseOrderBottom' src='AuthorizeOrdersBottom.jsp' frameborder=0> -->
	<frame name='AuthoriseOrderBottom' id='AuthoriseOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'>
</frameset>							   
</html>

