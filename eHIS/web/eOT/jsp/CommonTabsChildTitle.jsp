<!DOCTYPE html>
<%@ page import =",eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>

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
%>

<table border='0' cellpadding=3 cellspacing='0' width='100%' align="center">
<tr>
<%if(tab_id.equals("InstrumentsTab")) {%>
	<td class="CAGROUPHEADING" >Instruments Details</td>
 <%}else if(tab_id.equals("EquipmentsTab")) { %>
	<td class="CAGROUPHEADING" ><fmt:message key="eOT.EquipmentsDetails.Label" bundle="${ot_labels}"/></td>
<%}else if(tab_id.equals("ConsumableTab")) { %>
	<td class="CAGROUPHEADING" >Consumable Packs Details</td>
<%}else if(tab_id.equals("ImplantsTab")) { %>
	<td class="CAGROUPHEADING" ><fmt:message key="eOT.ProsthesisImplantsDetails.Label" bundle="${ot_labels}"/></td>
<%}%>
 </tr>
</table>
