<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ABCAnalysisQunatityCostReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String)session.getAttribute("login_user");

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formABCAnalysisQuantityReportCriteria" id="formABCAnalysisQuantityReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' >
			<tr>
				<th align="left" colspan = 10><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td align="right" >&nbsp;</td>
				<td class="label" class="label" colspan=5 width"10%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td align="right" class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<!--	<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fr_item_code" id="p_fr_item_code" value="" onKeyPress="return CheckForSpecChars(event)" onBlur="checkSpecialChars(this);" > --> 
			   <!-- Added by Rabbani #Inc no:44746 on 13-JAN-2014 -->
			 	<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fr_item_code" id="p_fr_item_code" value = "" > 
				<input class="button" name="p_fm_sr1" id="p_fm_sr1" onClick="callItemSearchScreen(p_fr_item_code);" type="button" value="?" ></td>
				<td align="right" class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="callItemSearchScreen(p_to_item_code);" type="button" value="?" ></td>
				<td class="label">&nbsp;</td>
			</tr>	
			<tr>	
				<td align="right" class="label"><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/></td>
				<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fr_month" id="p_fr_month" value="" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
				<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_fr_year1" id="p_fr_year1" value="" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"><img src="../../eCommon/images/mandatory.gif" align="center"></img></td> 
				<td align="right" class="label"><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/></td>
				<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> <class=text> / 	<class=text>
				 <input maxLength=4 size=4 name="p_to_year1" id="p_to_year1" value=""onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"><img src="../../eCommon/images/mandatory.gif" align="center"></img></td> 
				<td class="label">&nbsp;</td>
			 </tr>	
			<tr>
				<td class="label" align="right"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
				<td colspan=2>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type">
						<option value="Q" selected><fmt:message key="eST.ByQuantity.label" bundle="${st_labels}"/></option>
						<option value="C"><fmt:message key="eST.ByCost.label" bundle="${st_labels}"/></option>	</select>
				</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
			</tr>   
		</table>

		<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id"			value="STBABC">
		<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
		<input type="hidden" name="p_fr_year" id="p_fr_year"			value="">
		<input type="hidden" name="p_to_year" id="p_to_year"			value="">
	    <input type="hidden" name="sysdate" id="sysdate"	value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
	
		</form>
	</body>
</html>	

