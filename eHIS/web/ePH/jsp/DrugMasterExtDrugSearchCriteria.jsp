<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/DrugMaster.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="ePH.ExternalDrugSearch.label" bundle="${ph_labels}"/></title>
<body  onKeyDown="lockKey()" topmargin="0" onMouseDown = 'CodeArrest()' >
<%
	String bean_id				= "DrugMasterBean" ;
	String bean_name			= "ePH.DrugMasterBean";
	
	String generic_id		= request.getParameter( "generic_id" );
	if(generic_id==null)	generic_id	=	"";
	String generic_name		= request.getParameter( "generic_name" );	
	if(generic_name==null)	generic_name	=	"";


	String sql_ph_drug_select14	= PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
%>

<form name="ExternalDrugSearchForm" id="ExternalDrugSearchForm" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
		<td align="right" class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
		<input type="text" name="generic_name" id="generic_name" maxlength="20" size="20" value="<%=generic_name%>">&nbsp;
		<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>"></td>
		<td align="right" class="label"><fmt:message key="ePH.ExternalGeneric.label" bundle="${ph_labels}"/></td>
		<td align="left">&nbsp;<input type="text" name="external_generic" id="external_generic" maxlength="20" size="20" value="<%=generic_name%>">
		<input type="hidden" name="external_generic_id" id="external_generic_id" value="<%=generic_id%>"></td>
		<td align="right" class="label"><input type="button" class="button" value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' onClick="showDrugs(document.ExternalDrugSearchForm)" onfocus="showDrugs(document.ExternalDrugSearchForm)"></td>
</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="sql_ph_drug_select14" id="sql_ph_drug_select14" value="<%=sql_ph_drug_select14%>">
</form>
</body>
</html>

