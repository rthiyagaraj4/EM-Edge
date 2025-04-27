<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script LANGUAGE="javascript" src="../js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhMednStatBySrc.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	
	//	String sql_ph_nursing_unit_select	=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
//	String sql_ph_clinic_select			=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	String bean_id				= "PHRepMednOrdStatBySrcBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
	PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
	

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");


%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatBySrcCriteria.p_facility_code.focus();"> 

<form name="formPhMednStatBySrcCriteria" id="formPhMednStatBySrcCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" >
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>	
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_select_by" id="p_select_by">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="D"><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
					<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
		<td  align="left" >&nbsp;<input type="text" size="10" maxlength="10" name="dt_from" id="dt_from" OnBlur='CheckDate(this)'><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><td> &nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;<input type="text" size="10" maxlength="10" name="dt_to" id="dt_to" OnBlur='CheckDate(this)'><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="Location_Type" id="Location_Type" onChange="parent.disableLocation(this.value)">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
    </tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" width="15%" class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td align="left" width="30%">&nbsp;<input type="text" name="loc_name" id="loc_name" maxlength="30" size="30" value=""><input type="button" class="button"  value="?" name="loc_search" id="loc_search"
		onfocus="parent.searchLocationName(formPhMednStatBySrcCriteria.loc_name, 1)"
	 	onClick="parent.searchLocationName(formPhMednStatBySrcCriteria.loc_name, 1)" disabled></td>
		<input type="hidden" name="loc_id" id="loc_id" value="">
		<td align="right"  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tloc_name" id="tloc_name" maxlength="30" size="30" value=""><input type="button" class="button"  value="?" name="tloc_search" id="tloc_search"
		onfocus="parent.searchLocationName(formPhMednStatBySrcCriteria.tloc_name, 2)"
	 	onClick="parent.searchLocationName(formPhMednStatBySrcCriteria.tloc_name, 2)" disabled></td>
		<input type="hidden" name="tloc_id" id="tloc_id" value="">
	</tr>	
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td  align="left">&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="PD"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></option>
					<option value="LC"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 		<td align="right" class="label" nowrap><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;<select name="p_report_by" id="p_report_by">
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
    <tr>		
		<td align="right" class="label" nowrap><fmt:message key="ePH.OnlyDischargeMedicationOrder.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" align="left"><input type="checkbox" name="p_only_discharge" id="p_only_discharge" value="N" onClick="checkStatus(this)" > 
		</td>
 	</tr>

	</table>
	
	<input type="hidden" name="Nursing_Unit_Code" id="Nursing_Unit_Code" value="">
	<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRMSBYSR_SRR">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
    <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
    <INPUT TYPE="hidden" name="p_only_discharge" id="p_only_discharge" VALUE="N">  
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" value="Y">
	
    

</form>
<% putObjectInBean(bean_id,bean,request); %>
<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">
<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
</body>
</html>

