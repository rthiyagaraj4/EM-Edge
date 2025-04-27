<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    		Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            			?           	 created
02/04/2013		Bru-HIMS-CRF-311		Nijitha			 A new field by name ?Group By? will be introduced in ?Unsigned Notes List? screen.   								 
25/06/2013		IN041142		        Nijitha			 ALPHA-CA-Not able change the Patient ID by deleting or clicking on Back space by selecting Patient ID 														 number at the Patient ID field.   								    								 
19/11/2020		IN067370				Durga Natarajan  ML-MMOH-CRF-1178
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
<script src='../../eCA/js/RepUnsignedNote.js' language='javascript'></script>
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
<form name="repUnsignedNote" id="repUnsignedNote" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellpadding='3'>

		<th class='columnheader' align="left" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table border=0 width='100%' cellPadding="3" cellSpacing="1"  align='center' >

					<!-- <tr>
						<td align="right"  class="label">Facility&nbsp;&nbsp;</td>
						<td class="label"><input type=textbox value='' size=2 name=p_facility readonly>
						<input type='button' name='btnFacility' id='btnFacility' value='?' class='button' onclick='callCommonLookup("F")'></td><td align="left"></td>
					</tr> -->
					<tr>
					<td width='15%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<!--<td class="fields" width='25%' ><input type=textbox value='' size=20 maxlength=20 readonly name=p_patient_id><input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'></td> //IN041142 Commented-->
						<td class="fields" width='25%' ><input type=textbox value='' size=20 maxlength=20 name=p_patient_id><input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'></td><!-- IN041142-->
						<td width='25%' ></td><td width='25%' ></td>
					</tr>
						<tr>
						<td width='25%'  class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<td width='10%'  class="fields"><input type=textbox size='20' maxlength='20' name='p_practitioner_id1' id='p_practitioner_id1' onblur="call_CommonLookup(this,'P')" ><input type='hidden'  name='p_practitioner_id' id='p_practitioner_id' value=''><input type='button' name='practitioner_type' id='practitioner_type' value='?' class='button' onclick='call_CommonLookup(this,"P")'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					
						<td align='left'  class="label"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
						<td width='5%'    class="fields" ><input type=textbox  name='p_note_type1' id='p_note_type1' onblur='call_CommonLookup(this,"NT")' size="20" maxlength="20" align="center" ><input type='hidden'  name='p_note_type' id='p_note_type' value=''><input type='button' name='btnNoteType' id='btnNoteType' value='?' class='button' onclick='call_CommonLookup(this,"NT")'></td>
						
					</tr>
				
					<tr>
						<td  width='15%' class="label"><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/> :</td>
						<td width='25%' ><input type=textbox size=8 maxlength=8 name='p_frmDate' id='p_frmDate' onblur='return Check_Date(this,"DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_frmDate.select();return showCalendarValidate('p_frmDate');" >-<input type=textbox size=8 maxlength=8 name='p_toDate' id='p_toDate' onblur='return checkingDate(this,"DMY","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_toDate.select();return showCalendarValidate('p_toDate');" ></td>
						
		<!-- IN067370 starts -->
					<td class='label'  width='5%' > <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
					<td class='fields' ><input type='text' name ='grp_by_name'  onblur=' getSpecialty(grp_by_name,p_specialty_code)'><input type='hidden' name='p_specialty_code' id='p_specialty_code' value=''><input type ='button' class='button' name='spec_search' id='spec_search' value='?' onclick=' getSpecialty(grp_by_name,p_specialty_code)'>
					</td>
		<!-- IN067370 ends -->
						
					</tr>
					<!--Bru-HIMS-CRF-311 Starts-->
					<tr>
						<td  class='label'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
						<td class='fields'>&nbsp;<select name='P_GROUP_BY' id='P_GROUP_BY'><option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option><option value='N'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option></select></td>
						<td colspan='4'>&nbsp;</td>
					</tr>
					<!--Bru-HIMS-CRF-311 Ends-->

				
		</table>
		</tr>
		</table>
		<input type=hidden name=p_facility_id value='<%=facility_id%>'> 
		<input type=hidden name=p_user_id value='<%=user_id%>'> 
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="CA">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="CABUNSNN">
</form>
</html>

