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
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="ePH.QuotaLimitApprovalOrders"/>
<%-- Mandatory declarations end --%>


<html>
<head>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	
	<%request.setCharacterEncoding("UTF-8");%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	
	Properties properties	= (Properties) session.getValue( "jdbc" );
	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id");
	
	
	//System.out.println("--------practitioner_id-------->"+practitioner_id);
	//System.out.println("--------facility_id-------->"+facility_id);
	//System.out.println("---------resp_id------->"+resp_id);
	
	if(resp_id== null)resp_id = "";

	String source_type 	= request.getParameter("location_type");
	String source_code 	= request.getParameter("locn");
	String patientId   	= request.getParameter("patientId");
	String period_from	= request.getParameter("period_from");
	String period_to	= request.getParameter("period_to");
	String specialtyCode		= request.getParameter("specialty_code");
	String locale		= request.getParameter("locale");
	if(source_type == null || source_type.equals("null")) source_type =""; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =""; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(specialtyCode == null || specialtyCode.equals("null")) specialtyCode =""; else specialtyCode = specialtyCode.trim();
	
	bean.setLanguageId(locale);

	String  quotaLimitAppr_yn = "N";
	quotaLimitAppr_yn = bean.getQuotaLimitApprovalYN(properties, practitioner_id,resp_id) ;
	//System.out.println("########## quotaLimitAppr_yn::"+quotaLimitAppr_yn);
	if((quotaLimitAppr_yn.trim()).equals(""))
	{
		out.println("<script>parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('PRACT_RESP_NOT_QUOTALIITAPPROVAL','PH')); parent.location.href='../../eCommon/html/blank.html'</script>");
	}

	ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,"PQ",specialtyCode) ;
	//System.out.println("##########facility_id::"+facility_id+", source_type::"+source_type+", source_code::"+source_code+", practitioner_id::"+practitioner_id+", resp_id="+resp_id+",  patientId::"+patientId+", period_from::"+period_from+", period_to::"+period_to+", PriorityData.size()::"+PriorityData.size());

	if(PriorityData.size() == 0){
		out.println("<script>parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}

	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}
%>
<iframe name='QuotaLimitApprovalBottomLeft' id='QuotaLimitApprovalBottomLeft'	src='PhQuotaLimitApprovalBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&specialtyCode=<%=specialtyCode%>&period_from=<%=period_from%>&period_to=<%=period_to%>'  frameborder=0 scrolling='no' noresize style="height:20vh;width:100vw"></iframe>
	<iframe name='QuotaLimitApprovalBottomRight' id='QuotaLimitApprovalBottomRight' src='PhQuotaLimitApprovalBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&specialtyCode=<%=specialtyCode%>&period_from=<%=period_from%>&period_to=<%=period_to%>&order_by=O'  frameborder=0 scrolling='no' noresize style="height:80vh;width:100vw"></iframe>

</html>
<%
//System.out.println("###AuthorizeOrdersBottom.jsp,ends###");
	//putObjectInBean(bean_id,bean,request);
%>

