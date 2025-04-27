<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AuthorizeOrders.jsp -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Title><fmt:message key="eOR.PendingAppointment.label" bundle="${or_labels}"/></Title>
 
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<!-- Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added for take Filter criteria value from request . 
						-->
<%
String filter=request.getParameter("filter")==null?"":request.getParameter("filter");	
%>

<iframe name='CosignOrderTop' id='CosignOrderTop'	src='PendingAppointmentTop.jsp?filter=<%=filter%>' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='CosignOrderBottom' id='CosignOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 style='height:85vh;width:100vw'></iframe>
</html>

