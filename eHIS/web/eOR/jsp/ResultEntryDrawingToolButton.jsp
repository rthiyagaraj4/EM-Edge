<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="eCommon.XSSRequestWrapper" %> 
<%@ page import="eOR.OrderEntryDrawingToolBean" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<title></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="JavaScript" src="../../eOR/js/DrawingTool.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name ="buttonForm" action="../../servlet/eOR.SubmitServlet">
	<%
		
 		String order_catalog_code	= request.getParameter("catalog_code");
		String patient_id			= request.getParameter("patient_id");
		String encounter_id			= request.getParameter("encounter_id");
		String order_id				= request.getParameter("order_id");
		
		String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
  		 /* Initialize Function specific start */
		String bean_id				= "@OrderEntryDrawingToolBean"+patient_id+encounter_id;
		String bean_name			= "eOR.OrderEntryDrawingToolBean";
		//OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)mh.getBeanObject( bean_id, request,  bean_name );
		OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)getBeanObject( bean_id, bean_name, request ) ;
		// clear the bean
		beanObj.clear();
 	%>
 
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align=center>
			<tr>
				<td  class="button"><input type="button" name="record" id="record" class="BUTTON" value ="<fmt:message key="Common.record.label" bundle="${common_labels}"/>" title ="Record" onClick="resultApply()"> 
			 </tr>

		
		<input type="hidden" name="image_content" id="image_content" value=""> <!-- to store the image -->
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

		<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">

 		<input type="hidden" name="mode" id="mode" value="2">
		<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">

		</table>
	 	</form>
	</body>
</html>

<%
	// set it back persistence
	putObjectInBean(bean_id,beanObj,request);
%>

