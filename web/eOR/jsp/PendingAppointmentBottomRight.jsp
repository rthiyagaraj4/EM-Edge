<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page session="false" import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<% 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%

	String source_type= request.getParameter( "source_type" )==null?"":request.getParameter( "source_type" );
	String source_code	= request.getParameter( "source_code" ) ==null?"":request.getParameter( "source_code" );
	String order_by			= request.getParameter( "order_by" )==null?"":request.getParameter( "order_by" );
	String priority			= request.getParameter( "priority" ) ==null?"":request.getParameter( "priority" );
	String ord_cat			= request.getParameter( "ord_cat" ) ==null?"":request.getParameter( "ord_cat" );
	String ord_cat_desc	= request.getParameter( "ord_cat_desc" )==null?"":request.getParameter( "ord_cat_desc" );
	String priority_desc	= request.getParameter( "priority_desc" ) ==null?"":request.getParameter( "priority_desc" );
	String total_recs		= request.getParameter( "total_recs" ) ==null?"":request.getParameter( "total_recs" );
	String patientId  	    = request.getParameter("patientId")==null?"":request.getParameter( "patientId" );
	String period_from		= request.getParameter("period_from")==null?"":request.getParameter( "period_from" );
	String period_to		= request.getParameter("period_to")==null?"":request.getParameter( "period_to" );

	/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added for take Filter criteria value from request . 
						*/
	String filter		= request.getParameter("filter")==null?"":request.getParameter( "filter" );	


%>
<frameset rows='12%,80%,8%'>
	<frame name='CosignOrdersBottomRight0' src='PendingAppointmentBottomRightHeading.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to %>&filter=<%=filter %>' frameborder=0 scrolling='no' noresize>
	<frame name='CosignOrdersBottomRight1' src='PendingAppointmentBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter %>' frameborder=0 scrolling='auto'  noresize>
	<% if(filter.equals("")){%>
		<frame name='CosignOrdersBottomRight2' src='PendingAppointmentBottomRightBtn.jsp' frameborder=0 scrolling='no' noresize >
<%}  %>
</frameset>
</html>
