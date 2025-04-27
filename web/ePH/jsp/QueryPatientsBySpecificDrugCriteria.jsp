<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/QueryPatientsBySpecificDrug.js"></script> 
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String	bean_id			=	"QueryPatientsBySpecificDrugBean" ;
	String	bean_name		=	"ePH.QueryPatientsBySpecificDrugBean";

	QueryPatientsBySpecificDrugBean bean = (QueryPatientsBySpecificDrugBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList from_and_to_date=bean.getFrom_and_To_date();//added for performance tuning start
	String todate=(String)from_and_to_date.get(0);
	String fromdate=(String)from_and_to_date.get(1);//added for performance tuning end	
	
	ArrayList patientClass = bean.getPatientClass();
	String sql_ph_drug_search_select1 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT1");
	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

%>
<form name="queryPatientsBySpecificDrugCriteria" id="queryPatientsBySpecificDrugCriteria" > 
<table cellpadding="2" cellspacing="0" width="98%" align="center" border="0">
<tr >
		<td class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		<td colspan="5">&nbsp;&nbsp;<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40" onblur="searchGenericName()"><input type="button" class="button" value="?" name="generic_name_search" id="generic_name_search" onclick="searchGenericName()">
		<input type="hidden" name="generic_id" id="generic_id" value="">
		</td>
</tr>
<tr >
		<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td colspan="5">&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" onblur="searchDrugName()"><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onclick="searchDrugName()">
		<input type="hidden" name="drug_code" id="drug_code" value="">
		</td>
</tr>
<tr >
		<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td colspan="5">&nbsp;
			<select name="pat_class" id="pat_class">
				<option>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
				<%
					for (int i=0;i<patientClass.size();i=i+2){
				%>
					<option value="<%=patientClass.get(i)%>"><%=patientClass.get(i+1)%></option>
				<%
					}
				%>
			</select>			
		</td>
</tr>
<tr>
		<td class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" name="dt_from" id="dt_from" value="<%=fromdate%>" maxlength="10" size="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >
		&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"><!-- added for performance tuning --> <!-- CheckDate(this) function changed to CheckDateLeap(this,'DMY','<%=locale%>') for RollForward from SRR - SRR20056-SCF-9382[IN:056770] -->
		</td>
		<td class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" name="dt_to" id="dt_to" value="<%=todate%>" maxlength="10" size="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >
		&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"><!-- added for performance tuning --> <!-- CheckDate(this) function changed to CheckDateLeap(this,'DMY','<%=locale%>') for RollForward from SRR - SRR20056-SCF-9382[IN:056770] -->
		</td>
		<td class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="status" id="status">
				<option value="*ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="A"><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
			</select>			
		</td>
</tr>
<tr>
	<td colspan="6" align="right"><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
</tr>
</table>
	<input type="hidden" name="sql_ph_drug_search_select1" id="sql_ph_drug_search_select1" value="<%=sql_ph_drug_search_select1%>">
	<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
	<input type="hidden" name="" id="" value="">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html> 

