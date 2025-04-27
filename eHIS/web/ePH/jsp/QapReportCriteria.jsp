<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
    String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean			= (PHReportsBean)getBeanObject(bean_id,bean_name,request);
	
%>
<html>
<head>
	<% request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
bean.setLanguageId(locale);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/QAPReport.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="QapReportCriteria" id="QapReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
    <BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0"> 
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td COLSPAN="4" class="label">&nbsp;</td></tr> 
	<tr>
        <td align="right" class="label" width="23%"><fmt:message key="Common.QAPReport.label" bundle="${common_labels}"/></td>
		<td align="left" COLSPAN="3">&nbsp;
			<SELECT name="location_type" id="location_type" onChange="assignReportid(this);">
				<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION> 
		   		<OPTION VALUE="PHQAPPC1"><fmt:message key="ePH.QAP1PrescriptionsIntervenedOP.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC2"><fmt:message key="ePH.QAP2PrescriptionsIntervenedIP.label" bundle="${ph_labels}"/></OPTION> 
				<OPTION VALUE="PHQAPPC3"><fmt:message key="ePH.QAP3PrescriptionsWronglyFilledAndDetectedOP.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC4"><fmt:message key="ePH.QAP4-PrescriptionsWronglyFilledAndDetected-IP.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC5A"><fmt:message key="ePH.QAP5NumberofItemsWronglyDispensedOPDischarge.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC6"><fmt:message key="ePH.QAP6ParentalNutritionRequestsReviewedandCompoundedSupplied.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC8"><fmt:message key="ePH.QAP8ProportionOfAssaysInterpretedandRecommended.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC10"><fmt:message key="ePH.QAP10ProportionofToxicologycasesInterpretedandrecommended.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="PHQAPPC11"><fmt:message key="ePH.QAP11-ProportionofCDRDefaulters.label" bundle="${ph_labels}"/></OPTION>
				</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
   	</tr>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td  align="left" COLSPAN="4">&nbsp;    
		  <SELECT name="facility_name" id="facility_name" onChange="disable_disp(this);">
		      <OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
			  <OPTION VALUE="*A"><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/></OPTION>
			  <%ArrayList facilities=(ArrayList)bean.getFacilitys();
			    if(facilities.size()!= 0 ){
					for(int i=0;i<facilities.size();i+=2){ %>
					<OPTION VALUE="<%=(String)facilities.get(i)%>"><%=(String)facilities.get(i+1)%></OPTION>
						<%}}%>
	      </SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr id='disp_lookup' style='display:inline'> 
		<td align="right" width="15%" class="label">Dispense Locatin from</td>
		<td align="left" width="30%">&nbsp;&nbsp;<input type="text" name="from_desp_loc" id="from_desp_loc" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search" onClick="locationLookup(from_desp_loc,1)"><input type="hidden" name="locn_code1" id="locn_code1"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<td align="right" width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td align="left" width="50%">&nbsp;<input type="text" name="to_desp_loc" id="to_desp_loc" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="locationLookup(to_desp_loc,2)"><input type="hidden" name="locn_code2" id="locn_code2"></td> 
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
	</tr>
	<tr>
		<td align="right" class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
		<td COLSPAN="3" align="left" >&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="dt_from1" id="dt_from1" OnBlur='CheckDate(this);chkDate(dt_from1,dt_to1);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;<label class="label">To</label>&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" maxlength=10 OnBlur='CheckDate(this);chkDate(dt_from1,dt_to1);'><IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr>
        <td align="right" class="label" width="23%"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td align="left" COLSPAN="3">&nbsp;
			<SELECT name="group_by" id="group_by" onChange="initialize_date(this);">  
				<OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</OPTION> 
		   		<OPTION VALUE="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="D" selected><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
   			</SELECT></td>
   	</tr>
	<TR>
		<TD COLSPAN="4">&nbsp;</TD>
	</TR>
	</table>
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE=""> 
	<INPUT TYPE="hidden" name="CLAUSE" id="CLAUSE" VALUE="">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
	<INPUT TYPE="hidden" name="p_cond" id="p_cond" VALUE="">
</form>
	<input type="hidden" name="SQL_PH_PRINT_FACILITIES_SELECT" id="SQL_PH_PRINT_FACILITIES_SELECT" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_FACILITIES_SELECT")%>">
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>


