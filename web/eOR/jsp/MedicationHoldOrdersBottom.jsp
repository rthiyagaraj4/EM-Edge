<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
07/02/2013	  IN029949	    Chowminya G  Created 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/MedicationHoldOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%	String source_type		= request.getParameter( "location_type" ) ;
	String source_code		= request.getParameter( "locn" ) ;	
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");

	if(priority == null) priority= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ; 
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
System.out.println("source_type"+source_type+"source_code"+source_code);
%>
<iframe name='MediHoldOrderResult' id='MediHoldOrderResult' src='MedicationHoldOrdersBottomResult.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>' frameborder=0 scrolling='auto'  noresize style='height:100vh;width:100vw'></iframe>
	<!--<iframe name='MediHoldOrderBtn' id='MediHoldOrderBtn' src='MedicationHoldOrdersBtn.jsp' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>-->

</html>

