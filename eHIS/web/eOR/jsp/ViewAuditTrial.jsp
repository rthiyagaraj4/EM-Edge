<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<title><fmt:message key="eOR.AuditTrial.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--style='background-color:#E2E3F0;' -->
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_autid_trial_view' id='result_autid_trial_view' METHOD=POST>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";


	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	//String result_comment = request.getParameter("result_comment");
	bean.setLanguageId(localeName);

	String order_id = (bean.checkForNull(request.getParameter("order_id"),"")).trim();
	String reporting_date = bean.checkForNull(request.getParameter("reporting_date"),"");
	String reporting_practitioner = bean.checkForNull(request.getParameter("reporting_practitioner"),"");

	ArrayList auditTrialValues = bean.getAuditTrialValues(order_id);
	ArrayList getAuditTrialSpecimenValues = bean.getAuditTrialSpecimenValues(order_id);
	//out.println(row_index);
	//if(row_index==null)	row_index="";

	//String templateText = bean.getClobData(row_index);
	//out.println("template_id= "+template_id+"msr_desc="+msr_desc+);
	//out.println("<script>alert('"+reporting_practitioner+"')</script>");
	//int count = 0;
%>

<%--<Script>alert('<%=getAuditTrialSpecimenValues.size()%>')</Script>--%>
<table cellpadding=0 cellspacing=0 border=1 align=center width='100%'>
 
<% String [] record = (String[])auditTrialValues.get(0);
    String [] record1 = null;
    if (getAuditTrialSpecimenValues.size() > 0)
        record1 = (String[])getAuditTrialSpecimenValues.get(0);
%>    <%--<Script>alert('<%=record.length%>')</Script>--%>
    <%if (record.length > 0) {%>
    <tr><td class='columnheader'></td><td class='columnheader'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td><td class='columnheader'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td></tr>
    <%if (record[0] != null && (!record[0].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.OrderEntry.label" bundle="${or_labels}"/></b></td><td class='label' ><%=record[0]%></td><td class='label'><%=bean.checkForNull(record[1],"")%></td></tr>
     <%}%>
     <%if (record[2] != null && (!record[2].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.OrderConsent.label" bundle="${or_labels}"/></b></td><td class='label' ><%=record[2]%></td><td class='label' ><%=bean.checkForNull(record[3],"")%></td></tr>
     <%}%>
     <%if (record[4] != null && (!record[4].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.OrderAuthorization.label" bundle="${or_labels}"/></b></td><td class='label'><%=record[4]%></td><td class='label'><%=bean.checkForNull(record[5],"")%></td></tr>
      <%}%>
      <%if (record[6] != null && (!record[6].equals(""))) {%>
        <tr><td><b><fmt:message key="eOR.OrderApproval.label" bundle="${or_labels}"/></b></td><td class='label'><%=record[6]%></td><td class='label'><%=bean.checkForNull(bean.getAuditPractionerDesc(record[7]),record[7])%></td></tr>
     <%}%>
     <%if (record[8] != null && (!record[8].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.OrderCosign.label" bundle="${or_labels}"/></b></td><td class='label'><%=record[8]%></td><td class='label' ><%=bean.checkForNull(record[9],"")%></td></tr>
      <%}%>
      <%if (record1 != null && record1[0] != null && (!record1[0].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="Common.SpecimenCollection.label" bundle="${common_labels}"/></b></td><td class='label'><%=record1[0]%></td><td class='label'><%=bean.checkForNull(record1[1],"")%></td></tr>
        <%--<tr><td class='label'><b>Registration</b></td><td class='label'><%=bean.checkForNull(record1[2],"")%></td><td class='label'><%=bean.checkForNull(bean.getAuditPractionerDesc(record1[3]),record1[3])%></td></tr>--%>
      <%}%>
      <%if (record[10] != null && (!record[10].equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.OrderRegistration.label" bundle="${or_labels}"/></b></td><td class='label'><%=record[10]%></td><td class='label' ><%=bean.checkForNull(bean.getAuditPractionerDesc(record[11]),record[11])%></td></tr>
      <%}%>
      <%if (reporting_date != null && (!reporting_date.equals(""))) {%>
        <tr><td class='label'><b><fmt:message key="eOR.ResultEntry.label" bundle="${or_labels}"/></b></td><td class='label' ><%=reporting_date%></td><td class='label' ><%=bean.checkForNull(bean.getAuditPractionerDesc(reporting_practitioner),reporting_practitioner)%></td></tr>
    <%}%>

<%}%>


<%--<tr><td colspan='4' align=right><INPUT TYPE="button" class="button" value="Close" onClick='window.close()'></td></tr>--%>
</table>
</FORM>
</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);

%>

