<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%

	String p_module_id		= "MR" ;
	String p_report_id		= "MRIPADRG" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
%>
<html>	
<HEAD>
<SCRIPT LANGUAGE="JavaScript">
function repAdmReg()
    { 
	 if (document.getElementById("p_type").value=='A')
	     document.getElementById("MY1").innerHTML=getLabel("Common.admissiondate.label","Common")+" &nbsp;"
	 else  if (document.getElementById("p_type").value=='D')
	   	     document.getElementById("MY1").innerHTML=getLabel("Common.dischargedate.label","Common")+" &nbsp;"
	 }	
//Added By Rameswar on 30th Apr 2015 against  HSA-CRF-0194.1 IN:053531
 function ClearLocn(obj,P_FM_CLINIC_CODE,P_TO_CLINIC_CODE)
	{
	P_FM_CLINIC_CODE.value='';
	P_TO_CLINIC_CODE.value='';
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="repAdmReg()">
<br>
<br>
<form name="repAdmRegForm" id="repAdmRegForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
			<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
           </tr>
           <tr>
			<!-- <td align='right' width='30%' class="label">Admission Date &nbsp;</td> -->
			 <td align='left' id='MY1'class="label"> &nbsp; &nbsp;</td>
			<td nowrap><input type='text' id='fromdate' name='P_fm_DATE' id='P_fm_DATE' size='10' onBlur='CheckDate(this)'
			maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromdate'); "/> <img align='center' src='../../eMP/images/mandatory.gif'></td>

			<td nowrap>  
			   <input type='text' id='todate' name='P_to_DATE' id='P_to_DATE' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('todate');"/>
			<img align='center' src='../../eMP/images/mandatory.gif'> </td>
          </tr>
		<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
				</tr>
 	<tr>
	<td align='left'  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
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
	 <%-- Commented by Thamizh selvi on 30th Sep 2016 against HSA-CRF-0194.2 -->
	 <%-- <tr><!--Added By Rameswar on 30th Apr 2015 against  HSA-CRF-0194.1 IN:053531-->	
					<td width='20%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'><select name='p_encounter_type' id='p_encounter_type' onchange='ClearLocn(this,P_FM_CLINIC_CODE,P_TO_CLINIC_CODE)'>
					<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td width='20%' class='label'>&nbsp;</td>
					<td width='20%' class='label'>&nbsp;</td>
					<!-- End-->
          </tr> --%>
	<tr>
	<td align='left'  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>
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
				<tr>
					<td align="left" class="label" width="30%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> &nbsp; </td>
					<td width="20%">
						<select name='p_type' id='p_type' onchange='repAdmReg()'>
						
						<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>		
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
	<input type="hidden" name="p_encounter_type" id="p_encounter_type"	value="IP"> <!--Added by Thamizh selvi on 2nd Nov 2016 against HSA-CRF-0194.2-->

</form>
</BODY>
</HTML>

