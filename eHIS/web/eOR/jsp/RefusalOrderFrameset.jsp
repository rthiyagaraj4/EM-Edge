<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<title><fmt:message key="eOR.RefusalOrder.label" bundle="${or_labels}"/></title>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%		

	String pat_id = request.getParameter("patient_id");
	if(pat_id==null) {	 // for Refusal orders  
	//out.println("<script>alert('qry String="+request.getQueryString()+"');</script>");
%>

<!-- <frameset rows="11%,18%,7%,62%" name="Refusal_order_main"> -->
		<iframe src="RefusalOrdersTab.jsp" name="refusal_main" id="refusal_main"  scrolling='no' frameborder="0" noresize style='height:11vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name="refusal_main_search" id="refusal_main_search" scrolling='no' frameborder="0" noresize style='height:0vh;width:100vw'></iframe>	
		<iframe src="../../eCommon/html/blank.html" name="refusal_main_label" id="refusal_main_label"  scrolling='no' frameborder="0" noresize style='height:7vh;width:100vw'></iframe>		
	<!-- <frame src="../../eCommon/html/blank.html" name="refusal_main_label" id="refusal_main_label"  scrolling='no' frameborder="1" noresize>	-->
		<iframe src="../../eCommon/html/blank.html" name="refusal_main_result" id="refusal_main_result" scrolling='no' frameborder="0" noresize style='height:62vh;width:100vw'> </iframe>
	
<%	} else { // for consent orders %>
	<!--<frameset rows="0%,0%,80%,0%" name="Refusal_order_main">
		 <frame src="RefusalOrdersTab.jsp" name="refusal_main" id="refusal_main"  scrolling='no' frameborder="1" noresize> -->
		 <iframe src="RefusalOrdersTab.jsp" name="refusal_main" id="refusal_main"  scrolling='no' frameborder="0" noresize style='height:0vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name="refusal_main_label" id="refusal_main_label"  scrolling='no' frameborder="0" noresize style='height:4vh;width:100vw'>	</iframe>
		<iframe src="../../eCommon/html/blank.html" name="refusal_main_result" id="refusal_main_result" scrolling='no' frameborder="0" noresize style='height:0vh;width:100vw'></iframe>
		<iframe src="RefusalOrders.jsp?<%=request.getQueryString()%>" name="refusal_main_orders" id="refusal_main_orders"   scrolling='no' frameborder="0" noresize style='height:88vh;width:99vw'></iframe>
<%	} %>
	
			
</html>

