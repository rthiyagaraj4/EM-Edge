<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%

	String p_module_id		= "MR" ;
	String p_report_id		= "MRIPADAY" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale		= (String)session.getAttribute("LOCALE"); //Added by Ashwin K for ML-MMOH-SCF-1859-TF on 28-02-2022
%>
<html>	
<HEAD>
<SCRIPT LANGUAGE="JavaScript">
function repAdmReg()
    { 
	 if (document.getElementById("p_type").value=='A'){
		 if(document.getElementById("rep_period_type").value=='D'){
	     document.getElementById("MY1").innerHTML=getLabel("Common.admissiondate.label","Common")+" &nbsp;" ;
		 }
		 else if (document.getElementById("rep_period_type").value=='M')
		 {
			 document.getElementById("MY1").innerHTML=getLabel("Common.admission.label","Common")+" &nbsp;"+getLabel("Common.month.label","Common");
		 }
		 else if (document.getElementById("rep_period_type").value=='Y')
		 {
			 document.getElementById("MY1").innerHTML=getLabel("Common.admission.label","Common")+" &nbsp;"+getLabel("Common.year.label","Common");
		 }
	 }
	 else  if (document.getElementById("p_type").value=='D'){
	 if(document.getElementById("rep_period_type").value=='D'){
			 document.getElementById("MY1").innerHTML=getLabel("Common.dischargedate.label","Common")+" &nbsp;" ;
			 }
		else if (document.getElementById("rep_period_type").value=='M')
		 {
			 document.getElementById("MY1").innerHTML=getLabel("Common.Discharge.label","Common")+" &nbsp;"+getLabel("Common.month.label","Common");
		 }
		 else if (document.getElementById("rep_period_type").value=='Y')
		 {
			 document.getElementById("MY1").innerHTML=getLabel("Common.Discharge.label","Common")+" &nbsp;"+getLabel("Common.year.label","Common");
		 }
	  }
	 }	
function dateformatchange(){
	var localeName = document.forms[0].locale.value; //Added by Ashwin K for ML-MMOH-SCF-1859-TF on 24-02-2022	
	
	if (document.getElementById("rep_period_type").value=='M')
	 {
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' onblur=\"validDateObj_MR(this,'MY',localeName);DateComparison(this,'MY',p_fm_Date);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7'  onblur=\"DateComparison(p_to_Date,'MY',this);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ; //Modified by Ashwin K where validDateObj_MR and DateComparison for ML-MMOH-SCF-1859-TF on 24-02-2022	
	 }
	 else  if (document.getElementById("rep_period_type").value=='Y')
	 {
		
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' onblur=\"validDateObj_MR(this,'YY',localeName);DateComparison(this,'YY',p_fm_Date);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4'  onblur=\"DateComparison(p_to_Date,'YY',this);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;  //Modified by Ashwin K where validDateObj_MR and DateComparison for ML-MMOH-SCF-1859-TF on 24-02-2022	
	 }
	  else  if (document.getElementById("rep_period_type").value=='D')
	 {
		
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'   maxlength='10' size='10' onblur=\"validDateObj_MR(this,'DMY',localeName);DateComparison(this,'DMY',p_to_Date);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' onblur=\"DateComparison(p_to_Date,'DMY',this);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\"  >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;  //Modified by Ashwin K where validDateObj_MR and DateComparison for ML-MMOH-SCF-1859-TF on 24-02-2022	
	 }

}

</SCRIPT>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added by Ashwin K for ML-MMOH-SCF-1859-TF on 24-02-2022 -->

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="repAdmReg();dateformatchange()">
<br>
<br>
<form name="repAdmRegFormDayCare" id="repAdmRegFormDayCare" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

			<!-- Commented by Ashwin K for ML-MMOH-SCF-1859-TF on 24-02-2022
			<tr>
					<td align="right" class="label" width="30%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> &nbsp; </td>
					<td width="20%">
						<select name='p_type' id='p_type' onchange='repAdmReg()'>
						
						<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr> -->
			<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
			<tr>
					<td align="right" class="label" width="30%"><fmt:message key="Common.Reportperiodtype.label" bundle="${common_labels}"/> &nbsp; </td>
					<td width="20%">
						<select name='rep_period_type' id='rep_period_type' onchange='repAdmReg();dateformatchange()'>
						
						<option value="D"><fmt:message key="Common.day.label" bundle="${common_labels}"/>
						<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
           </tr>
           <tr>
			<!-- <td align='right' width='30%' class="label">Admission Date &nbsp;</td> -->
			 <td align='right' id='MY1'class="label"> &nbsp; &nbsp;</td>
			<td align='left' id='MY' > &nbsp; </td>
			<td align='left' id='MY3' > &nbsp; </td>
          </tr>
		<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
				</tr>
 	<tr>
	
	<td align='right'  class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/>&nbsp;</td>
	<td>
			<input type=text onkeypress='return ValidStringrepAdm(event)' name='P_FM_SPECIALITY_CODE' id='P_FM_SPECIALITY_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repAdm(this, P_FM_SPECIALITY_CODE)'>&nbsp;
	</td>
	
	<td>
			<input type=text onkeypress='return ValidStringrepAdm(event)' name='P_TO_SPECIALITY_CODE' id='P_TO_SPECIALITY_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repAdm(this, P_TO_SPECIALITY_CODE)'>&nbsp;
	</td>
	</tr>
	<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
				</tr>
	
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>

	<tr>
	<td align='right'  class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/>&nbsp;</td>
	<td>
			<input type=text onkeypress='return ValidStringrepAdm(event)' name='P_FM_CLINIC_CODE' id='P_FM_CLINIC_CODE' size="4" maxlength="4"><input type='button' name='P_FM_CLINIC' id='P_FM_CLINIC' value='?' class='button' onclick='searchCode2repAdm(this, P_FM_CLINIC_CODE)'>&nbsp;
	</td>
	<td>
			<input type=text onkeypress='return ValidStringrepAdm(event)' name='P_TO_CLINIC_CODE' id='P_TO_CLINIC_CODE' size="4" maxlength="4"><input type='button' name='P_FM_CLINIC' id='P_FM_CLINIC' value='?' class='button' onclick='searchCode2repAdm(this, P_TO_CLINIC_CODE)'>&nbsp;
	</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<!-- Added by Ashwin K on 24-02-2022  for ML-MMOH-SCF-1859-TF -->
	<tr>
					<td align="right" class="label" width="30%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> &nbsp; </td>
					<td width="20%">
						<select name='p_type' id='p_type' onchange='repAdmReg()'>
						
						<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr> 
	<!--  Ended by Ashwin K on 24-02-2022  for ML-MMOH-SCF-1859-TF -->
	
<tr><td class='label' colspan='3'>&nbsp;</td></tr>
						
		<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
				</tr>


		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_encounter_type" id="p_encounter_type"	value="DC">
	<input type="hidden" name="locale" id="locale"	value="<%= locale %>">  <!-- Added by Ashwin K for for ML-MMOH-SCF-1859-TF on 28-02-2022	--> 

</form>
</BODY>
</HTML>

