<!DOCTYPE html>

<%
/*

Date        Edit History    Name                Rev.Date    Rev.Name        Description
------------------------------------------------------------------------------------------------------------------------------
03/05/2023		TFS-43531  Raja Hanumanthu		04/05/2023	Ramesh Goli   ML-MMOH-CRF-1823
------------------------------------------------------------------------------------------------------------------------------
*/
%>


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
       
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="javascript" src="../../ePH/js/QuotaLimitQry.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
		<!-- <script language='javascript' src='../../eCommon/js/QuotaLimitQryResult.jsp'> </script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String sql_ph_drug_query_select2		=	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
		System.err.println("sql_ph_drug_query_select2 "+sql_ph_drug_query_select2);
		String curr_sys_date = "";
    	String curr_week_date  = "";
    	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
    	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,6,"d");
    	String Sysdate 	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String user_name  =  (String) session.getValue( "login_user" ) ;
	%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="formQuotaLimitQryCriteria" id="formQuotaLimitQryCriteria" TARGET="messageFrame">
		<table cellpadding="0" cellspacing="0" width="99%" align="left" border="0">
			<tr>	
				<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td colspan="8">&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60">&nbsp;<input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onblur="" onclick="searchDrugName1(this)">
		&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif">
		<input type="hidden" name="drug_code" id="drug_code" value="">
		</td>
				<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td colspan="8">&nbsp;&nbsp;<input type="text" name="splName" id="splName" maxlength="20" size="20">&nbsp;<input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onblur="" onclick="populateSpl()">
		&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"> 
		<input type="hidden" name="splCode" id="splCode" size="20" maxlength="20" value="">
		</td>	
			</tr>
			<tr><td colspan=5>&nbsp;</tr>
			<tr>
				<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="patient_id" id="patient_id" size="20" value=""  maxlength="" onKeyPress="changeToUpper()" >
					<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"   >
					&nbsp;
				</td>
			</tr>
			<tr><td colspan=5>&nbsp;</td></tr>	
		<tr>
		<td class="label" ><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></td>
		<td class="label"><input type="text" size="12" maxlength=10 name="p_ord_fm_date" id="p_ord_fm_date" value="<%=curr_week_date%>" OnBlur="CheckDateLeap1(this);">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_ord_fm_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		&nbsp;<td class="label"><input type="text" size="10" name="p_ord_to_date" id="p_ord_to_date" maxlength=10 value="<%=curr_sys_date%>" OnBlur="CheckDateLeap1(this);">&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_ord_to_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		
	</tr>
		<tr>
			<td align=right colspan="12">	<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="loadordersResult()"></td> 			
		</tr> 
			</table>
			<input TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		 	<input type="hidden" name="sql_ph_drug_query_select2" id="sql_ph_drug_query_select2" value="<%=sql_ph_drug_query_select2%>"> 
		 	<input tYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<input type="hidden" name="P_FRDATE" id="P_FRDATE" value="">
		    <input type="hidden" name="P_TODATE" id="P_TODATE" value="">
			<input type="hidden" name="sys_date" id="sys_date" value="<%=curr_sys_date%>"> 
		 	<input TYPE="hidden" name="flag" id="flag" VALUE="">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
 
		</form>
	</body>
 

</html>

