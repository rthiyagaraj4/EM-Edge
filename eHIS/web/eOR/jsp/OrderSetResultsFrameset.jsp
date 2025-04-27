<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
<% 
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
</head>
<%String view_by			= request.getParameter( "view_by" ) ;
    if (view_by == null) view_by = "";
    if (view_by.equals("L")) {%>
    <iframe name='ExistingOrderResult' id='ExistingOrderResult' src='OrderSetExistingOrderResults.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='height:82vh;width:100vw'></iframe>
	<iframe name='ExistingOrderResultColors' id='ExistingOrderResultColors' src='ExistingOrderResultsColors.jsp' frameborder=0 scrolling=no style='height:18vh;width:100vw'></iframe>
    <%} else {%>

		  
    <iframe name='ExistingOrderResult' id='ExistingOrderResult' src='OrderSetExistingOrderResults.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=yes style='height:100vh;width:100vw'></iframe>
    <%}%>
</html>

