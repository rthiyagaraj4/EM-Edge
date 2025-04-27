<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%> 
<html>
<head>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
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
	String order_by			= request.getParameter( "order_by" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter		= request.getParameter("filter");
	String Inc_Force_Auth		= request.getParameter("Inc_Force_Auth");
	String auth_filter		= request.getParameter("auth_filter");
//System.out.println("###in AuthorizeOrdersBottomRight.jsp, begin##");
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ; 
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(filter == null || filter.equals("null")) filter =""; else filter = filter.trim();
	if(Inc_Force_Auth == null || Inc_Force_Auth.equals("null")) Inc_Force_Auth =""; else Inc_Force_Auth = Inc_Force_Auth.trim();
	if(auth_filter == null || auth_filter.equals("null")) auth_filter =""; else auth_filter = auth_filter.trim();


%>

	<iframe name='AuthorizeOrdersBottomRight1' id='AuthorizeOrdersBottomRight1' src='AuthorizeOrdersBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>' frameborder=0 scrolling='auto'  noresize style='height:82vh;width:99vw'></iframe>
	<iframe name='AuthorizeOrdersBottomRight2' id='AuthorizeOrdersBottomRight2' src='AuthorizeOrdersBottomRightBtn.jsp' frameborder=0 scrolling='no' noresize style='height:8vh;width:99vw'></iframe>

<%//System.out.println("###in AuthorizeOrdersBottomRight.jsp, ends##");%>
</html>

