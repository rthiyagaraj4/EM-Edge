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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
17/10/2019	  IN071558		sivabagyam	 17/10/2019        Ramesh G       KDAH-SCF-0602
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script language='javascript' src='../js/ManageConsultOrders.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<%	
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//IN071558
	//String source = url + params ;
%>
<title>Multi Consult Orders</title>
<iframe name="ManageConsultpatientinfo" id="ManageConsultpatientinfo" src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>' frameborder=0 scrolling="no" noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='ManageConsultOrderdtl' id='ManageConsultOrderdtl' src='../../eOR/jsp/ManageConsultOrdersDetail.jsp?<%=params%>' frameborder=0 noresize scrolling="auto"style='height:62vh;width:100vw' ></iframe>
	<iframe name="ManageConsultOrderbtn" id="ManageConsultOrderbtn" src = '../../eOR/jsp/ManageConsultOrdersButton.jsp?<%=params%>'marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize style='height:8vh;width:100vw'></iframe>	 
	<iframe name="messageFrame" id="messageFrame"	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling=auto style='height:10vh;width:100vw'></iframe>
</html>

