<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    		Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
31/10/2013		IN040377		Chowminya		New Immunization report required Patient wise [Created]
4/09/2014		IN050829		Nijitha S		ML-BRU-SCF-1421
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
 %>
<html>
<head>
<%

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/RepPatImmunization.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language="javascript" >
function showCalendarValidate(str){
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name="repPatImmunization" id="repPatImmunization" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellpadding='3'>

		<th class='columnheader' align="left" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table border=0 width='80%' cellPadding="3" cellSpacing="0"  align='center' >

					<tr>
					<td width='25%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%' ><input type=textbox value='' size=20 maxlength=20 name=p_patient_id><input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'><img src="../../eCommon/images/mandatory.gif"></td><!--IN050829-->
						<td width='15%' class="label" ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/> <fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td>
						<td  class="fields" width='55%' ><input type=textbox  name='p_vaccine1' id='p_vaccine1' onblur='callCommonLookup("VN")' size="30" maxlength="30" align="center" ><input type='hidden'  name='P_VACCIN_ID' id='P_VACCIN_ID' value=''><input type='button' name='btnVaccName' id='btnVaccName' value='?' class='button' onclick='call_CommonLookup(this,"VN")'>
						</td>
						
					</tr>	
					<tr>
						<td width='25%'  class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<td class='fields' width ='25%'><select name='p_status1' id='p_status1'> 
						<option value=''>----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option>
						<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
						<option value='DO'><fmt:message key="Common.Due.label" bundle="${common_labels}"/> & <fmt:message key="Common.Overdue.label" bundle="${common_labels}"/> </option>   
						<option value='D'><fmt:message key="Common.Due.label" bundle="${common_labels}"/></option>
						<option value='L'><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>
						<option value='N'><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.Future.label" bundle="${common_labels}"/></option>
						<option value='O'><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
						</select>
						</td>  
						<td width='15%' class="label" ><fmt:message key="eCA.VaccineCategory.label" bundle="${ca_labels}"/></td>
						<td  class="fields" width='55%' ><input type=textbox  name='p_vaccine_category1' id='p_vaccine_category1' onblur='callCommonLookup("VC")' size="30" maxlength="30" align="center" ><input type='hidden'  name='P_VACCIN_CAT_ID' id='P_VACCIN_CAT_ID' value=''><input type='button' name='btnVaccCategory' id='btnVaccCategory' value='?' class='button' onclick='call_CommonLookup(this,"VC")'>
						</td>
					</tr>			
					<tr>
						<td  colspan=1 class="label"><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/> :</td><td colspan=1 ><input type=textbox size=11 maxlength=10 name='p_fm_Date' id='p_fm_Date' onblur='return Check_Date(this,"DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_fm_Date.select();return showCalendarValidate('p_fm_Date');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-<td><input type=textbox size=11 maxlength=10 name='p_to_Date' id='p_to_Date' onblur='return checkingDate(this,"DMY","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_to_Date.select();return showCalendarValidate('p_to_Date');" ></td>
					</tr>
					



				
		</table>
		</tr>
		</table>
		<input type=hidden name=p_facility_id value='<%=facility_id%>'> 
		<input type=hidden name=p_status value=''> 
		<input type=hidden name=p_user_id value='<%=user_id%>'> 
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="CA">
		<input type='hidden' value='N' name='P_ONLINE_YN' id='P_ONLINE_YN'>
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="CAPATIMRPT">
</form>
</html>

