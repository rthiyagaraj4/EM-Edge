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
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
19/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage
21/10/2015	  IN057196		Ramesh G	Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
--> 
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
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
<%
	
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;

	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId		= request.getParameter( "patientId");
	String order_by			= request.getParameter( "order_by" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String period_from		= request.getParameter( "period_from" ) ;
	String period_to		= request.getParameter( "period_to" ) ;
	String function_id		= request.getParameter( "function_id" ) ;
	String consentRec_order_id = request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String calledFrom		= request.getParameter( "calledFrom")==null?"":request.getParameter("calledFrom") ;//IN29559
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	if(function_id == null) function_id= "";
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ; 
	if(period_from== null) period_from="" ; else period_from = period_from.trim();
	if(period_to== null) period_to="" ; else period_to = period_to.trim();

	//IN29559,starts
	String orderCat = "";

	try
	{
		orderCat = request.getParameter("orderCategory")==null?"":request.getParameter("orderCategory");

		if(calledFrom.equals("TASK_LIST"))
		{
			ord_cat = orderCat;
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception from line 62,ConsentOrdersBottomRight.jsp");
		e.printStackTrace();
	}
	//IN29559,ends

	/*out.println("<script>alert('source_type="+source_type+"')</script>");
	out.println("<script>alert('source_code="+source_code+"')</script>");
	out.println("<script>alert('patientId="+patientId+"')</script>");
	out.println("<script>alert('order_by="+order_by+"')</script>");
	out.println("<script>alert('priority="+priority+"')</script>");
	out.println("<script>alert('ord_cat="+ord_cat+"')</script>");
	out.println("<script>alert('ord_cat_desc="+ord_cat_desc+"')</script>");
	out.println("<script>alert('priority_desc="+priority_desc+"')</script>");
	out.println("<script>alert('total_recs="+total_recs+"')</script>");
	out.println("<script>alert('period_from="+period_from+"')</script>");
	out.println("<script>alert('period_to="+period_to+"')</script>");*/
	

%>
<frameset rows='*%,8%'>
<!-- 	<frame name='ConsentOrdersBottomRight0' id='ConsentOrdersBottomRight0' src='ConsentOrdersBottomRightHeading.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>' frameborder=0  scrolling='no' noresize> -->
<!-- 	<frame name='ConsentOrdersBottomRight1' id='ConsentOrdersBottomRight1' src='ConsentOrdersBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&function_id=<%=function_id%>' frameborder=0 scrolling='auto'  noresize>  -->  <!-- commented for  BRU-HIMS-CRF-359 [IN038797]  -->
	<!-- IN057196 Start. -->
	<!--   <frame name='ConsentOrdersBottomRight1' id='ConsentOrdersBottomRight1' src='ConsentOrdersBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&function_id=<%=function_id%>&speciality_code=<%=speciality_code%>' frameborder=0 scrolling='auto'  noresize> --> <!-- modified for BRU-HIMS-CRF-359 [IN038797]  -->
	<frame name='ConsentOrdersBottomRight1' id='ConsentOrdersBottomRight1' src='ConsentOrdersBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&function_id=<%=function_id%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>' frameborder=0 scrolling='auto'  noresize>  <!-- modified for BRU-HIMS-CRF-359 [IN038797]  -->
	<!-- IN057196 End. -->
	<frame name='ConsentOrdersBottomRight2' id='ConsentOrdersBottomRight2' src='ConsentOrdersBottomRightBtn.jsp?calledFrom=<%=calledFrom%>' frameborder=0 scrolling='no' noresize><!--IN29559-->
</frameset>
</html>

