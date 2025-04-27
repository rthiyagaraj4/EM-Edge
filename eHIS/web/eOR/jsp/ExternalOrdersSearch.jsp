<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String bean_id = "Or_ExternalOrders" ;
	String bean_name = "eOR.ExternalOrdersBean";
 	ExternalOrdersBean bean = (ExternalOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	int patient_id_length = bean.getPatientIdLength();
	 
	/* Mandatory checks start */
	String mode	   = "1";// request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

%>

<form name='external_order_search' id='external_order_search' target='messageFrame' >

<table cellpadding=3 cellspacing=0 border=0 width="98%" align=center>
	<tr>
		<td class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='16%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' ><input  type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td colspan=2></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='30' name='name' id='name' value=''  ></td>
		<td class=label><fmt:message key="eOR.AgeSex.label" bundle="${or_labels}"/></td>
		<td><input type='text' width='30' name='name' id='name' value=''  ></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.ExternalPractitioner.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='30' name='name' id='name' value=''  ></td>
		<td colspan=2></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='30' name='name' id='name' value=''  ></td>
		<td colspan=2></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='30' name='name' id='name' value=''  ></td>
		<td colspan=2></td>
	</tr>
</table>


<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%//=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%//= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">

</form>

<%
		putObjectInBean(bean_id,bean,request);
%>

</body>
</html>

