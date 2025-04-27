<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<%
	String sql_ph_drug_select14		=	PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");

%>
<form name="queryGenericNameCriteria" id="queryGenericNameCriteria" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr colspan="5">
		<td  class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		<td colspan="4">&nbsp;&nbsp;<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="generic_search" id="generic_search" onclick="parent.searchGenericName(this);">
		<input type="hidden" name="generic_id" id="generic_id" value=""></td>
</tr>
<tr>
		<td class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="drug_class" id="drug_class">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
					</select>
		</td>
		<td class="label"><label id="no_of_recs"><fmt:message key="ePH.NoofRecords.label" bundle="${ph_labels}"/></label></td>
		<td>&nbsp;&nbsp;<select name="tot_recs" id="tot_recs">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="20" selected>20</option>
					<option value="40">40</option>
					<option value="60">60</option>
					<option value="80">80</option>
					<option value="100">100</option>
					</select>
		</td>
		<td><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="parent.callResultPage()"></td>
</tr>
</table>
<input type="hidden" name="sql_ph_drug_select14" id="sql_ph_drug_select14" value="<%=sql_ph_drug_select14%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>

