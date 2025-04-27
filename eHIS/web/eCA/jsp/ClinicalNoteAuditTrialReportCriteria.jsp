<!DOCTYPE html>

<%
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String currDate =	com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
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
<script src='../../eCA/js/ClinicalNoteAuditTrialReport.js' language='javascript'></script>
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
<form name="clinialaudittraislreport" id="clinialaudittraislreport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table width='80%' align='center' valign='top' cellpadding='3'>
		<tr>
			<th class='columnheader' align="left" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
			<td width="100%"   class="Border" align='center'>
				<table border=0 width='100%' cellPadding="3" cellSpacing="0"  align='center' >
					<tr>
						<td width='20%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%' >
							<input type=textbox value='' size=20 maxlength=20 name="patientId" id="patientId" OnChange='resetValues();'>
							<input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'>
							<img src="../../eCommon/images/mandatory.gif">
						</td>					
						<td  class='label' id='id_encounter'  width='25%' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
						<td class='fields' width="30%">
							<input type='textbox'  name='encounterId' id='encounterId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  size="20" OnChange='resetValues();'>
							<input align='right' class='button' type=button name=search1  value='?'   tabIndex="4" onClick="patientEncounterDetailNew('clntaudittrial')">
							<img src="../../eCommon/images/mandatory.gif">
						</td>						
					</tr>						
					<tr>
						<td class=label  width='20%'  ><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
						<td class='fields'  width='25%' >
							<input type='text' name='note_group_desc' id='note_group_desc' value="" size="20" maxlength="20" OnBlur ='getNotegrp(this)' OnChange='resetValues();'>
							<input type='button' name='note_desc_search' id='note_desc_search' value='?' class='button' OnClick='resetValues();getNotegrpDesc()'>
							<input type='hidden' name='note_group_id' id='note_group_id' value="" >
						</td>						
						<td  width='25%'  class='label'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
						<td  width='30%'  class='fields' >
							<input type='text' name='note_type_txt' id='note_type_txt' value='' size="20" maxlength="20" OnKeyPress='return CheckForSpecChars(event)' OnBlur ='getNoteType(this)' OnChange='resetValues();' >
							<input type="button" value="?"  class="button" name='notetype_srch' id='notetype_srch' OnClick='resetValues();getNoteTypeDesc()'>
							<input type ="hidden" name ="note_type" value="" >
						</td>
					</tr>		
					
					<tr>
						<td class=label width='20%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields' width='25%'>
							<input type="hidden" name="practitioner_id" id="practitioner_id" size="20" maxlength="20" value="">
							<input type="text" name="pctr" id="pctr" value="" size='20' maxlength='20'  onBlur='getPractCode(this)' OnChange='resetValues();'>
							<input type="button" value="?" class="button" name='searchpctr' id='searchpctr' onClick='resetValues();getPractitionerId13()'>
						</td>
						<td class="label" width='25%'><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/> </td>
						<td  width='30%'  class='fields' >
							<input type=textbox size=11 maxlength=10 name=p_fm_Date id=p_fm_Date value="<%=currDate%>" onblur='return Check_Date(this,"DMY","<%=locale%>");'>
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_fm_Date');" >-
							<input type=textbox size=11 maxlength=10 name=p_to_Date id=p_to_Date onblur='return checkingDate(this,"DMY","<%=locale%>")' value="<%=currDate%>">
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_to_Date');" >
						</td>
					</tr>					
					<tr>
						<td colspan=4 align="center">
							<input type="button" value="Search"  class="button" name='Search' id='Search' OnClick='getResults()'>	
							<input type="button" value="Print Preview"  class="button" name='Print Preview' id='Print Preview' OnClick="showpreview('Preview')">	
							<input type="button" value="Print"  class="button" name='Print' id='Print' OnClick="showpreview('Print')">	
						</td>
					</tr>
				</table>		
			</td>
		</tr>
		<input type=hidden name=p_facility_id value='<%=facility_id%>'> 
		<input type=hidden name=p_status value=''> 
		<input type=hidden name=p_user_id value='<%=user_id%>'> 
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="CA">
		<input type='hidden' value='N' name='P_ONLINE_YN' id='P_ONLINE_YN'>
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="CAREPCLINTAUDTRIAL">
	</table>	
</body>	
</form>
</html>

