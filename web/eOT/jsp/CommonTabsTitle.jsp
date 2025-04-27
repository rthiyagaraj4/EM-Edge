<!DOCTYPE html>
<%@ page import ="eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>
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
	String tab_id = CommonBean.checkForNull(request.getParameter("parent_tab_id"));

%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align="center">
<tr>
<% if(tab_id.equals("details_tab")){ %>
		<td class="tablistitem" ><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
<% } else if(tab_id.equals("personnel_tab")) {  %>
		<td class="tablistitem" ><fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/></td>
<% } else if(tab_id.equals("operative_record_tab")) { %>
		<td class="tablistitem" ><fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/></td> 
<% } else if(tab_id.equals("post_oper_diagnosis_tab")) { %>
   <td class="tablistitem" ><fmt:message key="eOT.PostOperativeDiagnosis.Label" bundle="${ot_labels}"/></td>
<% } else if(tab_id.equals("consumable_tab")) { %>
	<td class="tablistitem" ><fmt:message key="eOT.PacksInstrsEquipsImplants.Label" bundle="${ot_labels}"/></td>
<%} else if(tab_id.equals("specimen_tab")) { %>
   <td class="tablistitem" ><fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/></td>
<%} else if(tab_id.equals("disposal_tab")) { %>
	<td class="tablistitem" ><fmt:message key="eOT.DisposalDetails.Label" bundle="${ot_labels}"/></td>
<%} else if(tab_id.equals("unusal_tab")) { %>
   <td class="tablistitem" >Unusual Occurance</td>
<%} else if(tab_id.equals("pre_oper_checklist_tab")) { %>
   <td class="tablistitem" ><fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/></td>
 <%} else if(tab_id.equals("post_oper_checklist_tab")) { %>
	<td class="tablistitem" colspan="8"><fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/></td>
<%} else if(tab_id.equals("swab_count_tab")) { %>
	<td class="tablistitem" colspan="8"><fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/></td>
<% }%>
 </tr>
</table>
