<!DOCTYPE html>
 <%-- saved on 04/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>

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
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhMednStatByPract.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_MODIFIED_SELECT");

	String bean_id				= "PHRepMednOrdStatByPractBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatByPractBean";
	PHRepMednOrdStatByPractBean bean	= (PHRepMednOrdStatByPractBean)getBeanObject( bean_id, bean_name ,request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList        = bean.getMednFacilityList();
	ArrayList jobtitle             = bean.getTitle();

	//ArrayList dateList          = bean.getMednDateList();

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");

%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> 

<form name="formPhMednStatByPractCriteria" id="formPhMednStatByPractCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_facility_code" id="p_facility_code"  onchange='callLocation(this)'>
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_select_by" id="p_select_by">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="D"><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
					<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
		<td COLSPAN="1" >&nbsp;<input type="text" size="10" maxlength=10 name="dt_from" id="dt_from" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		<td class="label" COLSPAN="1"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" size="10" maxlength=10 name="dt_to" id="dt_to" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_job_title" id="p_job_title" DISABLED onchange='clear1(this)'>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<jobtitle.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= jobtitle.get(i) %>"><%= jobtitle.get(i+1) %></OPTION>

	<% 	} %>
	</select>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="pract_search" id="pract_search"
		onClick="parent.searchPractitionerName(formPhMednStatByPractCriteria.pract_name, 1)"></td>
		<input type="hidden" name="pract_id" id="pract_id" value="">
		<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;<input type="text" name="tpract_name" id="tpract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tpract_search" id="tpract_search"
		onClick="parent.searchPractitionerName(formPhMednStatByPractCriteria.tpract_name, 2)"></td>
		<input type="hidden" name="tpract_id" id="tpract_id" value="">
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="PD"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></option>
					<option value="PT"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_report_by" id="p_report_by">
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
	</tr>
	<tr>
		<td class="label" nowrap><fmt:message key="ePH.OnlyDischargeMedicationOrder.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" align="left"><input type="checkbox" name="p_only_discharge" id="p_only_discharge" value="N" onClick="checkStatus(this)" > 
		</td>
 	</tr>
	</table>
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRMSBYDR_SRR">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
<% putObjectInBean(bean_id,bean,request); %>
</form>
<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
</body>
</html>

