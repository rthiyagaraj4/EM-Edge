<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head><title><fmt:message key="eOR.OrderEntryExternalOrder.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->

  	<script language="JavaScript" src="../../eOR/js/ExternalOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String bean_id = "Or_ExternalOrders" ;
	String bean_name = "eOR.ExternalOrdersBean";
 	String qryString	= request.getQueryString();
	//ExternalOrdersBean bean = (ExternalOrdersBean)mh.getBeanObject( bean_id, request,bean_name ) ;
	 ExternalOrdersBean bean = (ExternalOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);

	bean.clear();
	String patient_id		 = request.getParameter("patient_id");
	String disabled			 = "";

  	if(patient_id==null) {
		patient_id			 = "";
		disabled			 = "";	
	} else 
		disabled			 = "DISABLED";
	  
%>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formExternalOrdersPatient" id="formExternalOrdersPatient" >
<table cellpadding=3 cellspacing=0 border='0' width="100%" align=center>
<tr>
	<td class="label" colspan="8"></td>
</tr>
<tr>
		<td class='label' id='id_pat' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
		<td class='fields' ><input type='text'  name='patientId' id='patientId' value="<%=patient_id%>" nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);populatePatientAge(this);clearMsgFrame();'  size="20" maxlength="<%=bean.getPatientIdLength()%>" <%=disabled%>><input class='button' type=button name=search value='?'  class=button tabIndex="2" onClick="callPatientSearch();clearMsgFrame();" <%=disabled%>>
		<img src="../../eCommon/images/mandatory.gif" align=center></td>
 		<td  class='label' id='name_id'  colspan="0" nowrap></td>
		<td class='label' colspan=4 id="result_name"></td>
		<td class='label' ></td>
</tr>
<tr>
	<td class="label" colspan="8"></td>
</tr>
</table>

<input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRACTITIONER_LOOKUP") %>">
 
<input type='hidden' name='function_from' id='function_from' value='EXTERNAL_ORDER'>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qryString" id="qryString" value="<%=qryString%>"> 
<input type="hidden" name="patient_details" id="patient_details" value="">

<input type="hidden" name="age" id="age" value="">
<input type="hidden" name="sex" id="sex" value="">
<input type="hidden" name="dob" id="dob" value="">
<input type="hidden" name="selected_patient_id" id="selected_patient_id" value="<%=patient_id%>">

<%
	if(patient_id !=null && !patient_id.equals("")) { 
%>
		<script>populatePatientAge(document.formExternalOrdersPatient.patientId);</script>
<%	} %>
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

