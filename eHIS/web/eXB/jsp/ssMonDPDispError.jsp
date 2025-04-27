<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eXH.XHUtil,eXB.XBDBAdapter,eXB.SSMonDPHelper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>
<base target="_self"/>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eXB/js/ssMonDPReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE><fmt:message key="eXH.SSMonDPErr.Label" bundle="${xh_labels}"/></TITLE>

<%
	String dateFormat = "dd/MM/yyyy hh:mm:ss";
	String locale = (String)session.getAttribute("LOCALE");
	SSMonDPHelper ssMonDPHelper = new SSMonDPHelper();
	List<HashMap> errList = ssMonDPHelper.checkErrors(null);	
%>

</HEAD>
 
<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();" onLoad="initErrorScr();">
<form name="ssMonDPDispError" id="ssMonDPDispError" method='post' action="../../servlet/eXB.SSMonDPServlet">
<% if(errList != null) {%>
<table width='100%'>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.NationalityCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.ProcessDate.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.Error.label" bundle="${common_labels}"/></td>
</tr>
<% 
	for(HashMap errData: errList) {
		String errMsg = (String)errData.get("errMsg");
		errMsg = errMsg.replaceAll("\\\\","/");
%>
<tr>
	<td class='LABEL'><%= XBDBAdapter.checkNull((String)errData.get("processID")) %></td>
	<td class='LABEL'><%= XBDBAdapter.checkNull((String)errData.get("natID")) %></td>
	<td class='LABEL'><%= XBDBAdapter.checkNull((String)errData.get("patID")) %></td>	
	<td class='LABEL'><%= XBDBAdapter.checkNull((String)errData.get("facilityID")) %></td>	
	<td class='LABEL'><%= XHUtil.xhLocaleDateDisplay((String)errData.get("processDate"), dateFormat, "DMYHMS", locale, true) %></td>	
	<td class='LABEL'><a href="#" onClick="javascript:showErr('<%= errMsg %>');"><%= (errMsg.length() > 20)?errMsg.substring(0,20):errMsg %></a></td>	
</tr>
<% } %>
<tr>
	<td colspan="6" CLASS="button">
		<INPUT TYPE="submit" VALUE='<fmt:message key="eXH.ClearErrors.Label" bundle="${xh_labels}"/>'>
		<INPUT TYPE="button" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()">
	</td>
</tr>
</table>
<% } %>

<INPUT TYPE="hidden" name="ssDPFunc" id="ssDPFunc" VALUE="DE">

</form>

</BODY>
</HTML>

