<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations start --%>
  

<%-- Mandatory declarations end --%>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String mode	   = "1";//request.getParameter( "mode" ) ;

	String ref_facility_id = request.getParameter("ref_facility_id");
	if(ref_facility_id == null || ref_facility_id.equals("null")) ref_facility_id = "";
	

	String ref_date_time = request.getParameter("ref_date_time");
	if(ref_date_time == null || ref_date_time.equals("null")) ref_date_time = "";
	//System.out.println("ref_date_time"+ref_date_time);

	String ref_sent_pract_id = request.getParameter("ref_sent_pract_id");
	if(ref_sent_pract_id == null || ref_sent_pract_id.equals("null")) ref_sent_pract_id = "";

	String ref_sent_remarks = request.getParameter("ref_sent_remarks");
	if(ref_sent_remarks == null || ref_sent_remarks.equals("null")) ref_sent_remarks = "";

	String ref_report_pract_id = request.getParameter("ref_report_pract_id");
	if(ref_report_pract_id == null || ref_report_pract_id.equals("null")) ref_report_pract_id = "";

	String ref_report_date_time = request.getParameter("ref_report_date_time");
	if(ref_report_date_time == null || ref_report_date_time.equals("null")) ref_report_date_time = "";
	//System.out.println("ref_report_date_time"+ref_report_date_time);


	String ref_recieved_date_time = request.getParameter("ref_recieved_date_time");
	if(ref_recieved_date_time == null || ref_recieved_date_time.equals("null")) ref_recieved_date_time = "";
	//System.out.println("ref_recieved_date_time"+ref_recieved_date_time);

	String ref_recieved_pract_id = request.getParameter("ref_recieved_pract_id");
	if(ref_recieved_pract_id == null || ref_recieved_pract_id.equals("null")) ref_recieved_pract_id = "";

	String ref_recieved_remarks = request.getParameter("ref_recieved_remarks");
	if(ref_recieved_remarks == null || ref_recieved_remarks.equals("null")) ref_recieved_remarks = "";

	String bean_id	= request.getParameter("bean_id");
	if (bean_id == null || bean_id.equals("null")) bean_id = "";

	String bean_name	= request.getParameter("bean_name");
	if (bean_name == null || bean_name.equals("null")) bean_name = "";

	String order_id		= request.getParameter("order_id");
	if (order_id == null || order_id.equals("null")) order_id = "";
	
	if(!localeName.equals("en")){
		//System.out.println("ref_date_time"+ref_date_time);
		//System.out.println("in thai"+com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM","en",localeName));
	ref_date_time = com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM","en",localeName);
	ref_report_date_time=com.ehis.util.DateUtils.convertDate(ref_report_date_time,"DMYHM","en",localeName);
	ref_recieved_date_time=com.ehis.util.DateUtils.convertDate(ref_recieved_date_time,"DMYHM","en",localeName);
	}


	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	
	String [] remarks	= bean.viewExternalRemarks(order_id);

	ref_sent_remarks		= (remarks[0] == null) ? "" : remarks[0];
	ref_recieved_remarks	= (remarks[1] == null) ? "" : remarks[1];

%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>


	<title><fmt:message key="eOR.ExternalDetails.label" bundle="${or_labels}"/></title>
</head>
<!-- <body style='background-color:#E2E3F0;' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"> -->
<body style='' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">
<table cellpadding=0 cellspacing=0 border=0 align=center width='100%' height='100%'>
<TR><TD class='label' colspan='2'></TD></TR>
<%if (!ref_facility_id.equals("")) {%>
<tr><TD class='label'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></TD><td  class='data'><B><%=ref_facility_id%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_date_time.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.DateofReferral.label" bundle="${or_labels}"/></TD><td  class='data'><B><%=ref_date_time%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_sent_pract_id.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.SentPractitioner.label" bundle="${or_labels}"/></TD><td class='data'><B><%=ref_sent_pract_id%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_sent_remarks.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.SentRemarks.label" bundle="${or_labels}"/></TD><td class='data'><TEXTAREA NAME="" ROWS="3" COLS="25"  readonly><%=ref_sent_remarks%></TEXTAREA></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_report_pract_id.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.ReportingPractitioner.label" bundle="${or_labels}"/></TD><td class='data'><B><%=ref_report_pract_id%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_report_date_time.equals("")) {%>
<tr><TD class='label'><fmt:message key="Common.DateofReporting.label" bundle="${common_labels}"/></TD><td class='data'><B><%=ref_report_date_time%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_recieved_date_time.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.DateofReceipt.label" bundle="${or_labels}"/></TD><td class='data'><B><%=ref_recieved_date_time%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_recieved_pract_id.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.ReceivingPractitioner.label" bundle="${or_labels}"/></TD><td class='data'><B><%=ref_recieved_pract_id%></B></td></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<%}%>

<%if (!ref_recieved_remarks.equals("")) {%>
<tr><TD class='label'><fmt:message key="eOR.ReceivedRemarks.label" bundle="${or_labels}"/></TD><td class='data'><TEXTAREA NAME="" ROWS="3" COLS="25" readonly><%=ref_recieved_remarks%></TEXTAREA></td></tr>
<%}%>
<TR><TD class='label' colspan='2'></TD></TR>
<!-- </table>
<table  cellpadding=0 cellspacing=0 border=0 align=center width='98%'> -->
<tr><td class='button' colspan=2 align='right'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='const dialogTag = parent.document.getElementById("dialog_tag");dialogTag.close();'></td></tr>
</table>
</FORM>

</BODY>
</HTML>

<%
		putObjectInBean(bean_id,bean,request);
%>

