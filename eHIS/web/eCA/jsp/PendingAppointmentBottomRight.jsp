<!DOCTYPE html>
<%@ page session="false" contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<% 	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
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
	String frmSum		= request.getParameter("frmSum");
	//out.println("priority"+ord_cat+params);	

	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ; 
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(frmSum == null || frmSum.equals("null")) frmSum =""; else frmSum = frmSum.trim();
	if(frmSum.equalsIgnoreCase("Y"))
	{
	%>
			<frameset rows='12%,80%'>
	<%
	}
	else
	{
		%>
			<frameset rows='12%,80%,8%'>
		<%
	}
	%>
	<frame name='CosignOrdersBottomRight0' src='PendingAppointmentBottomRightHeading.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to %>' frameborder=0 scrolling='no' noresize>
	<frame name='CosignOrdersBottomRight1' src='PendingAppointmentBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&total_recs=<%=total_recs%>&ord_cat=<%=ord_cat%>&ord_cat_desc=<%=ord_cat_desc%>&priority_desc=<%=priority_desc%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>' frameborder=0 scrolling='auto'  noresize>
	<%
	if(!frmSum.equalsIgnoreCase("Y"))
	{
	%>
		<frame name='CosignOrdersBottomRight2' src='PendingAppointmentBottomRightBtn.jsp' frameborder=0 scrolling='no' noresize >
	<%
	}
	%>
</frameset>
</html>
