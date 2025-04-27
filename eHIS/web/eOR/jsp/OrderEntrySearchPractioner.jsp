<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head><title><fmt:message key="eOR.OrderEntryMain.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="formSearchPract" id="formSearchPract">
<center>
<%
	// To be passed to all the Files
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id	= request.getParameter("patient_id");
	String encounter_id	= request.getParameter("episode_id");
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
	String function_from= request.getParameter("function_from");
	String patient_class= request.getParameter("patient_class");
	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	String practitioner_id = (String)bean.getPractitionerId();
	if(function_from==null) function_from="";
	if(patient_class==null) patient_class="";
	// Till Here
%>

	<table border='0' cellpadding=3 cellspacing=0 align="center" width="100%">
	<th class='columnheader' colspan="6" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></th>
	<tr>
	<% 
	if(function_from!=null && !function_from.equals("MULTI_PATIENT_ORDERS")) 
	{ 
	%>
		<td  class="label"><input type="radio" name="search_by" id="search_by" value="AT" onClick="searchPractBy(this);"><fmt:message key="eOR.Attending.label" bundle="${or_labels}"/></td>
	<% 
	} 
	%>
		<td  class="label"><input type="radio" name="search_by" id="search_by" value="MT" onClick="searchPractBy(this);"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
		<% 
		if(!patient_class.equals("XT"))
		{ 
		%>
			<td  class="label"><input type="radio" name="search_by" id="search_by" value="LO" onClick="searchPractBy(this);"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<%
		}
		%>
		<td  class="label"><input type="radio" name="search_by" id="search_by" value="SP" onClick="searchPractBy(this);"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<%
		if (!(practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) )
		{
		%>
			<td  class="label"><input type="radio" name="search_by" id="search_by" value="SF" onClick="searchPractBy(this);" ><fmt:message key="Common.self.label" bundle="${common_labels}"/></td>
		<%
		}
		%>
		<td  class="label"><input type="radio" name="search_by" id="search_by" value="AL" onClick="searchPractBy(this);"><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
	
	<center>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	</form>
</body>
</html>

