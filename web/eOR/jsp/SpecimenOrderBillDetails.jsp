<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------
29/08/2014	  IN049737	   Chowminya	 					Unbilled services will be regrouped into a new order
---------------------------------------------------------------------------------------------------------------
 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String bean_id = "Or_SpecimenOrder" ;
	String bean_name = "eOR.SpecimenOrder";
	Connection con = null;				
	PreparedStatement pstmt = null;		
	ResultSet rs = null;				

	String details	= request.getParameter("details");	
	String message  = request.getParameter("message");
	String patient_id  = request.getParameter("patient_id");
	String encounter_id  = request.getParameter("encounter_id");
	String facility_id  = request.getParameter("facility_id");
	String rec_num  = request.getParameter("rec_num");
	String dtls     = "";
	String mode	   = "1" ;
	String unbilled_service = "";
	StringTokenizer st1 = new StringTokenizer(message, "|");
    String subStr  = "";
             
    while (st1.hasMoreTokens()) 
    {
       	message					=	st1.nextToken();
       	unbilled_service		=	st1.nextToken();	           	
	} 
%>

<html>
<head>

	<title><fmt:message key="eOR.ServiceUnbilled.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../js/SpecimenOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onload='FocusFirstElement()'  onunload= "windowRet();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<FORM METHOD=POST name="bill_unsettled_order" id="bill_unsettled_order" >
		<table cellpadding=0 cellspacing=0 border=0 width='100%' height="100%">
		<tr><td class=LABEL ><%=message%></td></tr>
<%
StringTokenizer st2 = new StringTokenizer(unbilled_service, "`");
while (st2.hasMoreTokens()) 
{
	subStr = st2.nextToken();	           	
%>	
		<tr><td class=LABEL ><%=subStr%></td></tr>
<%		
} 

%>			
		<tr>
		<td colspan=3 class='button'>
			<input type=button class=button name='ok' id='ok' Value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="amendUnbillLineRecord();">
			<input type=button class=button name='Close' id='Close' Value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.close()">
		</td>
		</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="order_details" id="order_details" value="<%=details%>">
		<input type="hidden" name="called_from" id="called_from" value="unbilled_order_split">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="patientId" id="patientId" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="performing_facility" id="performing_facility" value="<%=facility_id%>">
		<input type="hidden" name="rec_num" id="rec_num" value="<%=rec_num%>">
		<input type="hidden" name="rec_res" id="rec_res" value="">
		
	</FORM>
</body>
</html>

