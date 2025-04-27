<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute		("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Date date_time	 	= new java.util.Date();
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	String customer_group_query="SELECT  CUST_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID=";//Code added for MMS-QH-CRF-0109[IN039377]
	String customer_query="SELECT CUST_CODE CODE,SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(SHORT_NAME) like upper(?) AND LANGUAGE_ID=";//Code added for MMS-QH-CRF-0109[IN039377]
%>
	<head>		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../js/DispenseStaticsByAgeRange.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
		<script language="javascript" SRC="../../eCommon/js/dchk.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!-- <BODY>  -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="Dispensestaticcriteriaform" id="Dispensestaticcriteriaform" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
				<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
				<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=session.getValue( "facility_id" ) %>">
				<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBDSTAG">
				<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">				
				<tr><!--Added for MMS-QH-CRF-0109[Inc: 39377]-Start -->
				<td class="label" nowrap width='15%'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td class="label" colspan='7'><select name="p_report_by" id="p_report_by">
					<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
				</select>
				</tr><!--Added for MMS-QH-CRF-0109[Inc: 39377]-End -->
				
				
				<tr>
				<td class="label" style="padding-top: 15px;"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td><!--&nbsp;&nbsp; removed after label And name="summ_group" added for MMS-QH-CRF-0109[Inc:39377]-->
				<td class='label' align="left" ><br><input type="text"  maxlength="60" size="20" name="disp_loc_desc" id="disp_loc_desc"><input type="button"  class="button" value="?" onClick="searchCode(this);"><!-- onfocus="searchCode(this);" -->&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"></td><!-- Commenting onfocus for ML-MMOH-SCF-2380 -->
					<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
				<!--Added for MMS-QH-CRF-0109[Inc: 39377]-Start-->
					  <td class="label"  nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					     <td class="label" colspan='1'>
						    <SELECT name="p_patient_class" id="p_patient_class">
							  <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							  <option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							  <option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							  <option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							  <option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
							 <option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
						</select>
				    </td>
				<!--Added for MMS-QH-CRF-0109[Inc: 39377]-End-->
				</tr>
				<tr>
					<td class="label" style="padding-top: 15px;"><fmt:message key="ePH.DispenseDateFrom.label" bundle="${ph_labels}"/></td><!--&nbsp;&nbsp; removed after label for MMS-QH-CRF-0109[Inc:39377]-->
					<td class="label" width='15%'><br><input type="text" name="disp_date_from" id="disp_date_from" value="" maxlength="10" size="10" onBlur="if(CheckDateT(this)) validateDate();"><!--changed CheckDate to CheckDateT for Leap year calculation on 
					24/02/2012 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('disp_date_from');">&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td><!--p_disp_date_from to disp_date_from  && p_disp_date_to to disp_date_to -->
					<input type="hidden" name="p_disp_date_from" id="p_disp_date_from" value=""><!--Added for Inc : 48027 -->
					<td class="label"  width='7%'><fmt:message key="Common.to.label" bundle="${common_labels}"/>
					<td class="label"  width='*%' colspan='4'><input type="text" name="disp_date_to" id="disp_date_to" value="" maxlength="10" size="10" onblur="if(CheckDateT(this) ) validateDate();"><!--changed CheckDate to CheckDateT for Leap year calculation on 
					24/02/2012 -->
					<input type="hidden" name="p_disp_date_to" id="p_disp_date_to" value=""><!--Added for Inc : 48027 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('disp_date_to'); ">&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"><!--p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to -->
					</td>
				</tr>
				<tr>
					<td class="label" style="padding-top: 15px;" nowrap><fmt:message key="ePH.summarizeby.label" bundle="${ph_labels}"/></td>
					<td class="label"><br><select name="p_age_by" id="p_age_by" onchange="displayfields();">
						<option value="A" selected><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class="label" id="lblGender"  style='display:none;' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class="label" id="fldGender"  width='10%' style='display:none;'><select name="p_gender_by" id="p_gender_by" >
					    <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<!--<option value = "" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>-->
						<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;</option>
						<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>&nbsp;</option>
					</select>
					</td>
					<td class="label" width='20%' id="ageRangeFrom"  style='display:none;' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/>
					&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input type="text" name="p_durn_frm" id="p_durn_frm" value="" size="3" maxlength="3" onKeyPress="return allowValidNumber(this,event,3,0);" oncopy="return false" onpaste="return false">&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;<select name="p_durn_type_fr" id="p_durn_type_fr" onchange="assignAgeRangeDurnType(this,'2');"><!--onKeyPress and durn_fr to p_durn_frm added for MMS-QH-CRF-0109[Inc: 39377] And oncopy and onpaste added for Linked Inc 48027--->
						<option value = "D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value = "W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
						<option value = "M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value = "Y" selected><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class="label" width='20%' id="ageRangeTo"  style='display:none;' nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;<input type="text" name="p_durn_to" id="p_durn_to" value="" size="3" maxlength="3" onKeyPress="return allowValidNumber(this,event,3,0);" oncopy="return false" onpaste="return false"><!--onKeyPress and durn_to to p_durn_to added for MMS-QH-CRF-0109[Inc: 39377] And oncopy and onpaste added for Linked Inc 48027-->
					&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;<select name="p_durn_type_to" id="p_durn_type_to" onchange="assignAgeRangeDurnType(this,'1');">
					<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
					<option value = "W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
					<option value = "M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
					<option value = "Y" selected><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class="label" id="lblAgreGroup" width='15%'  ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td><!--&nbsp;&nbsp; removed after label And id="4"  style='display:inline;' for MMS-QH-CRF-0109[Inc:39377]-->
					<td align="left" id='fldAgreGroup' class='label' width='*'><input type="text" maxlength="60" size="20" name="p_summ_age_group_desc" id="p_summ_age_group_desc"><!--summ_age_group_desc to p_summ_age_group_desc for MMS-QH-CRF-0109[Inc:39377]--><input type="button" class="button" name="summ_group" id="summ_group" value="?" onClick="Summarize(this);"><!-- onfocus="Summarize(this);"   -->&nbsp;<img name='mandatory1' style="visibility:visible"  src="../../eCommon/images/mandatory.gif"></td><!--mandatory to mandatory1 And style="visibility:visible" for MMS-QH-CRF-0109[Inc:39377] --><!-- Commenting onfocus for ML-MMOH-SCF-2380 -->
					<input type="hidden" name="p_summ_range_id" id="p_summ_range_id" value="">
				</tr>
				<tr> <!-- Code added for MMS-QH-CRF-0109[IN039377] --Start -->
					<td  class="label" style="padding-top: 15px;" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><br><input type="text" name="p_customer_group" id="p_customer_group" maxlength="40" size="40" style="width: 11.5vw;" value="" onBlur="CustomerGroupSearch(this,'1');"><input type="button" class="button" value="?" name="p_customer_group_desc" id="p_customer_group_desc"  onClick="CustomerGroupSearch(document.Dispensestaticcriteriaform.p_customer_group,'2');"> <!-- onfocus="CustomerGroupSearch(document.Dispensestaticcriteriaform.p_customer_group,'2');" --><!--code  onBlur="CustomerGroupSearch(this,'1');"  added for  MMS-QH-CRF-0109[IN039377]--><!-- Commenting onfocus for ML-MMOH-SCF-2380 -->
					<td  class="label" nowrap><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td> 
					<td align="left" class="label"><input type="text" name="p_customer" id="p_customer" maxlength="40" size="40" style="width: 11.5vw;" value="" onBlur="CustomerSearch(this,'1')"><input type="button" class="button" value="?" name="p_customer_desc" id="p_customer_desc" onClick="CustomerSearch(document.Dispensestaticcriteriaform.p_customer,'2')"> <!-- onfocus="CustomerSearch(document.Dispensestaticcriteriaform.p_customer ,'2')" -->	</td> <!-- code 'onBlur="CustomerSearch(this,'1')"' added for  MMS-QH-CRF-0109[IN039377] -->  <!-- Commenting onfocus for ML-MMOH-SCF-2380 -->
				</tr> <!-- Code added for MMS-QH-CRF-0109[IN039377] -- end -->
				<tr>
					<td class="label" style="padding-top: 15px;"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label"  bundle="${common_labels}"/></td><!--&nbsp;&nbsp; removed after label for MMS-QH-CRF-0109[Inc:39377]-->
					<td align="left" class='label' colspan="4"><br><input type="text" maxlength="60" size="20" name="nationality_group_desc" id="nationality_group_desc"onBlur="Nationality(this);"><input type="button" class="button" value="?" onClick="Nationality(this);"></td><!--code 'onBlur="Nationality(this);" ' added for  MMS-QH-CRF-0109[IN039377] --> <!-- Commenting onfocus for ML-MMOH-SCF-2380 -->
					<input type="hidden" name="p_stat_grp_id" id="p_stat_grp_id" value="">
					<td class="label"   style="display:none"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td ALIGN="left" style="display:none" label='class' colspan='5'>
						<SELECT name="List" id="List">
						<OPTION></OPTION>
						<OPTION value="DM"><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/>  <fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></option>
						<OPTION value="D"><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></option>
						<OPTION value="M"><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">	<!-- Added for ML-MMOH-SCF-0428-0432 -->	
			<input type="hidden" name="SQL_PH_DISP_STAT_AGE_GROUP_SELECT1" id="SQL_PH_DISP_STAT_AGE_GROUP_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_STAT_AGE_GROUP_SELECT1")%>">
			<input type="hidden" name="SQL_PH_DISP_STAT_AGE_GROUP_SELECT2" id="SQL_PH_DISP_STAT_AGE_GROUP_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_STAT_AGE_GROUP_SELECT2")%>">
			<input type="hidden" name="SQL_PH_DISP_STAT_AGE_GROUP_SELECT3" id="SQL_PH_DISP_STAT_AGE_GROUP_SELECT3" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_STAT_AGE_GROUP_SELECT3")%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">			
			<INPUT TYPE="hidden" name="P_CUST_GROUP_CODE" id="P_CUST_GROUP_CODE" VALUE=""> <!-- Code added for MMS-QH-CRF-0109[IN039377] -- Start -->
			<INPUT TYPE="hidden" name="P_CUST_CODE" id="P_CUST_CODE" VALUE="">
			<INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_GROUP_SELECT" id="SQL_PH_CUSTOMER_GROUP_SELECT" value="<%=customer_group_query%>"> 
			<INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_SELECT" id="SQL_PH_CUSTOMER_SELECT" value="<%=customer_query%>"><!-- Code added for MMS-QH-CRF-0109[IN039377] -- End-->
		</form>
	</body>
</html>

