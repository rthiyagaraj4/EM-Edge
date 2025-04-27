<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="eOT.*,eOT.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>

<%  
	 String tab_id = request.getParameter("tab_id");
	 //String qry_mode_flag= CommonBean.checkForNull(request.getParameter("qry_mode_flag"));
%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align="center">
<tr>
<%if(tab_id.equals("hold_notes")) {%>
	<td class="CAGROUPHEADING" ><fmt:message key="eOT.HoldingAreaNotes.Label" bundle="${ot_labels}"/></td>
 <%}else if(tab_id.equals("surg_notes")) { %>
	<td class="CAGROUPHEADING" ><fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/></td>
<%}else if(tab_id.equals("rec_notes")) { %>
	<td class="CAGROUPHEADING" ><fmt:message key="eOT.RecoveryNotes.Label" bundle="${ot_labels}"/></td>
<%}%>
 </tr>
</table>
