<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
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
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/QueryDiscontinuedDrugs.js"></SCRIPT>
 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String sql_ph_drug_query_select1		=	PhRepository.getPhKeyValue("SQL_PH_DRUG_QUERY_SELECT1");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");

	java.util.Date date_time	 	= new java.util.Date();
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>
<form name="queryDiscontinuedDrugsCriteria" id="queryDiscontinuedDrugsCriteria" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr colspan="5">
		<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td colspan="4">&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name"
		 maxlength="40" size="40" value=""  ><input type="button" class="button" value="?" name="drug_search" id="drug_search" onclick="searchDrugName1(this);" >
		<input type="hidden" name="drug_code" id="drug_code" value=""></td>
</tr>
<tr>
		<td class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
		<td colspan="4">&nbsp;&nbsp;<select name="drug_class" id="drug_class">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
					</select>
		</td>
</tr>
<tr>
		<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;&nbsp;<input type="text" size="10" maxlength=10 name="dt_from" id="dt_from" Onblur="CheckDateLeap(this,'DMY','<%= locale %>');DateCheck(currentdate,dt_from);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" onBlur='dt_from.focus()'>&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" size="10" name="dt_to" id="dt_to" Onblur="CheckDateLeap(this,'DMY','<%= locale %>');DateCheck(currentdate,dt_to);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" onBlur='dt_to.focus()'></td><!-- 		Added CheckDateLeap funtion for  RollForward from SRR - SRR20056-SCF-9389 [IN:056585]    -->
		<td align="right"><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick=" callResultPage1();"></td> <!-- Added if((DateCheck(currentdate,dt_from)) && (DateCheck(currentdate,dt_to))) in onClick for SRR - SRR20056-SCF-9381 [IN:56771]  --> <!-- Removed if((DateCheck(currentdate,dt_from)) && (DateCheck(currentdate,dt_to))) in onClick for ML-MMOH-SCF-0568  IN062503 -->
		
	</tr>

	<tr><td class='label' colspan='4' height='4'></td></tr>

</table>
<input type="hidden" name="sql_ph_drug_query_select1" id="sql_ph_drug_query_select1" value="<%=sql_ph_drug_query_select1%>">

	<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
</form>
</body>
</html>

