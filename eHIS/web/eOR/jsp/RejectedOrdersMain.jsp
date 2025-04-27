<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
10/01/2018  	IN061893		Kamalakannan G  		10/01/2018 		 Ramesh G 		ML-MMOH-CRF-0545
---------------------------------------------------------------------------------------------------------------------------------------------

--%>
<%@page import="eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String ordcat=request.getParameter("ordcat")==null?"":request.getParameter("ordcat");
%>
<html>
<head>
	<title>Rejected specimen orders</title><!-- need to be change with message -->
 	<script language="JavaScript" src="../js/RejectedOrders.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='rejectorders' id='rejectorders' src='../jsp/RejectedOrdersSearchCriteria.jsp?ordcat=<%=ordcat%>' frameborder=0 scrolling=no noresize style='height:12vh;width:100vw'>
	<iframe name="resultframe" id="resultframe" scrolling='yes' frameborder=0 noresize style='height:20vh;width:100vw'></iframe>
	<iframe name="rejectOrdersButtonFrame" id="rejectOrdersButtonFrame"src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:68vh;width:100vw'></iframe>

</html>

