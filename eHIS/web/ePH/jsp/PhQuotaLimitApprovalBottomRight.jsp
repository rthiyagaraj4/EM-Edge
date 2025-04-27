<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%> 
<html>
<head>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../js/PhQuotaLimitApproval.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");%>

</head>
<%
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String priority			= request.getParameter("priority");
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String specialtyCode		= request.getParameter("specialtyCode");
	
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(total_recs== null) total_recs="" ; 
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(priority == null || priority.equals("null")) priority =""; else priority = priority.trim();
	if(specialtyCode == null || specialtyCode.equals("null")) specialtyCode =""; else specialtyCode = specialtyCode.trim();
%>
<iframe name='QuotaLimitApprovalBottomRight1' id='QuotaLimitApprovalBottomRight1' src='PhQuotaLimitApprovalBottomRightDtl.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&order_by=<%=order_by%>&priority=<%=priority%>&specialtyCode=<%=specialtyCode%>&total_recs=<%=total_recs%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>' frameborder=0 scrolling='auto'  noresize style='height:92vh;width:100vw'></iframe>
	<iframe name='QuotaLimitApprovalBottomRight2' id='QuotaLimitApprovalBottomRight2' src='PhQuotaLimitApprovalBottomRightBtn.jsp' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>


</html>

