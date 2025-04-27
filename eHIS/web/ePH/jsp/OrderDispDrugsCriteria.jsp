<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" SRC="../../eCommon/js/dchk.js"></script> 
	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<!-- 	<script language="javascript" src="../js/PhMessages.js"></script>
 -->	 <script language="javascript" src="../js/OrdVsDispDrugs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	<FORM name="formOrderDispDrugs" id="formOrderDispDrugs" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

	<%
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
	%>

	<table cellpadding=2 cellspacing=0 width="90%"  align="center" border="0" >
			<TR><TD colspan="8">&nbsp;</TD>
			<tr>
						<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
						<td colspan="8">&nbsp;&nbsp;<select name="p_order_type" id="p_order_type">
								<option value="R" SELECTED><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						  </select>
						</td>
			</tr>
			<tr>			
						<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_from_dt1" id="p_from_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDateT(this);" >
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_from_dt1');" >
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_from_dt" id="p_from_dt" VALUE=" ">
						</td>
						<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td colspan="3">&nbsp;&nbsp;<input type="text" name="p_to_dt1" id="p_to_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDateT(this);">
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_to_dt1');" >
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_to_dt" id="p_to_dt" VALUE=" ">
						</td>
			</tr>

			<tr>
						<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_locn_type" id="p_locn_type" onchange='clear1(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_locn_name" id="p_locn_name" STYLE='overflow:visible;'  ><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
						<!-- <input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onBlur="locationLookup(p_locn_name)" onClick="locationLookup(p_locn_name)"> --><!-- commented  onBlur for NMC-JD-SCF-0160 -->
						<input type="button" name="btnLocation" id="btnLocation" class="button" value="?"  onClick="locationLookup(p_locn_name)">  
						<input type="hidden" name="p_locn_code" id="p_locn_code">
					</td>		
			</tr>
			<tr >
						<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
						<td colspan="8">&nbsp;&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="67" readonly ><input type="button" class="button" value="?" name="p_drug_name_search" id="p_drug_name_search"onclick="searchDrugName();"> 
							<input type="hidden" name="p_drug_code" id="p_drug_code" value="">  
						</td>	
			</tr>
	<TR><TD colspan="8">&nbsp;</TD>
	</table>
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHORDDISPDRUG">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="P_PAT_ID" id="P_PAT_ID" VALUE=""> 
	<INPUT TYPE="hidden" name="P_PAT_ID1" id="P_PAT_ID1" VALUE=""> 
</form>
		<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</html>

