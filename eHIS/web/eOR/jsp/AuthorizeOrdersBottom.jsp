<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.AuthoriseOrders"/>
<%-- Mandatory declarations end --%>


<html>
<head>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	
	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
//	String bean_id = "Or_AuthoriseOrder" ;
//	String bean_name = "eOR.AuthoriseOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
//System.out.println("###in AuthorizeOrdersBottom.jsp,begins###");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";

	String source_type = request.getParameter("location_type");
	String source_code = request.getParameter("locn");
	String patientId   = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter		= request.getParameter("filter");
	String auth_filter		= request.getParameter("auth_filter");
	String Inc_Force_Auth		= request.getParameter("Inc_Force_Auth");
	/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	if(PrivilegeApplicabilityAuth == null || PrivilegeApplicabilityAuth.equals("null")) PrivilegeApplicabilityAuth ="N"; else PrivilegeApplicabilityAuth = PrivilegeApplicabilityAuth.trim();
	/*Ends Here*/


	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(filter == null || filter.equals("null")) filter =""; else filter = filter.trim();
	if(auth_filter == null || auth_filter.equals("null")) auth_filter =""; else auth_filter = auth_filter.trim();
	if(Inc_Force_Auth == null || Inc_Force_Auth.equals("null")) Inc_Force_Auth =""; else Inc_Force_Auth = Inc_Force_Auth.trim();
	
	Properties properties			= (Properties) session.getValue( "jdbc" );

	//AuthoriseOrders bean = (AuthoriseOrders)getBeanObject( bean_id, bean_name, request ) ;

	bean.setLanguageId(localeName);

	String  auth_yn = "";
	auth_yn = bean.getAuthYN(properties, practitioner_id,resp_id,PrivilegeApplicabilityAuth) ;
	//System.out.println("########## auth_yn::"+auth_yn);
	if((auth_yn.trim()).equals(""))
	{
		out.println("<script>parent.AuthoriseOrderTop.document.authorise_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('PRACT_RESP_NOT_AUTHORISED','OR')); parent.location.href='../../eCommon/html/blank.html'</script>");
	}

	ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,"PO",filter,PrivilegeApplicabilityAuth,Inc_Force_Auth,auth_filter) ;
	//System.out.println("##########facility_id::"+facility_id+", source_type::"+source_type+", source_code::"+source_code+", practitioner_id::"+practitioner_id+", resp_id="+resp_id+",  patientId::"+patientId+", period_from::"+period_from+", period_to::"+period_to+", PriorityData.size()::"+PriorityData.size());

	if(PriorityData.size() == 0){
		out.println("<script>parent.AuthoriseOrderTop.document.authorise_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}

	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}
%>
<iframe name='AuthorizeOrdersBottomLeft' id='AuthorizeOrdersBottomLeft'	src='AuthorizeOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>'  frameborder=0 scrolling='no' noresize style='height:40vh;width:20vw' align="left"></iframe>
	<iframe name='AuthorizeOrdersBottomRight' id='AuthorizeOrdersBottomRight' src='AuthorizeOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>&order_by=O'  frameborder=0 scrolling='no' noresize style='height:100vh;width:78vw' align="right"></iframe>

</html>
<%
//System.out.println("###AuthorizeOrdersBottom.jsp,ends###");
	//putObjectInBean(bean_id,bean,request);
%>

