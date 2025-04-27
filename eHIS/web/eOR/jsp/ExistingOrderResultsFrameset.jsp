<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
25/09/2012		IN030279		Ramesh G		Bru-HIMS-CRF-160 	
04/12/2012		IN036393		Ramesh G 		MO Transactions->Manage Deceased/Body Part ->Specimen->Place Order->The Web Page title is displayed blank.							 
-------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
 

<html>
<head>
	<title><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
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

	String view_by			= request.getParameter( "view_by" ) ;
	String BTColorYN		= request.getParameter("BTColorYN");//IN065091
    if (view_by == null) view_by = "";
    //if (view_by.equals("L")) {
		//System.out.println("<script>alert('"+request.getQueryString()+"');</script>");
	//IN030279
	String function_from = (String)request.getParameter("function_from")==null?"":(String)request.getParameter("function_from");
	%>
    <!-- <frameset rows='*%,18%'> --> 
	   <iframe name='ExistingOrderResult' id='ExistingOrderResult' src='ExistingOrderResults.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='yes' noresize style='height:68vh;width:97vw'></iframe>
	   <!--IN065091 start-->
	   <!-- IN030279 Start --> 
	   <!-- frame name='ExistingOrderResultColors' src='ExistingOrderResultsColors.jsp' frameborder=0 scrolling='no' noresize -->
	   <!--<frame name='ExistingOrderResultColors' id='ExistingOrderResultColors' src='ExistingOrderResultsColors.jsp?function_from=<%=function_from %>&view_by=<%=view_by%>' frameborder=0 scrolling='no' noresize>-->
	   <iframe name='ExistingOrderResultColors' id='ExistingOrderResultColors' src='ExistingOrderResultsColors.jsp?function_from=<%=function_from %>&view_by=<%=view_by%>&BTColorYN=<%=BTColorYN%>' frameborder=0 scrolling='no' noresize style='height:18vh;width:99vw'></iframe>
	   <!-- IN030279 End -->
	   <!--IN065091 end-->
    </frameset>
    <%
	//} else {
		%>
    <!--<frameset rows='*%'>
	   <frame name='ExistingOrderResult' id='ExistingOrderResult' src='ExistingOrderResults.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto>
       </frameset>-->
    <%//}
	%>
</html>

