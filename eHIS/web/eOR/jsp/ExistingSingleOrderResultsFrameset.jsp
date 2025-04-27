<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
 
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingSingleOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_category	= request.getParameter( "order_category" ) ;
	if(order_category != null )
		order_category = order_category.trim();	
	else 
		order_category = "";
	String called_from	= request.getParameter( "called_from" ) ;
%>
    <frameset cols='*%,10%'> 
	   <!--<frame name='ExistingOrderResult' id='ExistingOrderResult' src='ExistingSingleContinuousOrderResultsFrameset.jsp?<%=request.getQueryString()%><%=order_category%>' frameborder=0 scrolling='yes' noresize>-->
	   <frame name='ExistingOrderResult' id='ExistingOrderResult' src='ExistingSingleOrderResults.jsp?<%=request.getQueryString()%><%=order_category%>' frameborder=0 scrolling='yes' noresize>
	   
	   <frame name='OrderCategoryList' id='OrderCategoryList' src='OrderCategoryList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize>
	</frameset>
	
</html>

