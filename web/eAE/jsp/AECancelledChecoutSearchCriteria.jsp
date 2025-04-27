<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Connection			con	=	null;
java.sql.Statement	stmt =	null;
ResultSet			rs	=	null;
String locale = (String)session.getAttribute("LOCALE");
String pid_length	= "";
String p_sql = "";
String facility_id = "";
try{
    con	= ConnectionManager.getConnection(request);
	facility_id		=	(String)		session.getValue("facility_id");
try
{
	p_sql	= "select patient_id_length from mp_param where module_id='MP'";
	stmt	= con.createStatement();
	rs		= stmt.executeQuery(p_sql);
	while (rs.next())
	{
		pid_length = rs.getString(1);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if (stmt!=null )stmt.close();
}

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eAE/js/AECancelledCheckout.js'></script>
<script language="javascript" src="../../eOP/js/OPPractitionerComponent.js"></script>

</head> 
<body onLoad='callfocus();' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='AECancelChkoutSearchForm' id='AECancelChkoutSearchForm'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' height='10'>
	<tr>
		<td class="label" width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><input type="text" name ="speciality_desc" maxlength="15" size="15" onBlur="getValues(speciality_button,this,speciality_code)" tabindex=1><input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)" tabindex=2><input type='hidden' name='speciality_code' id='speciality_code' value=''></td>
		<td class='LABEL'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'> <input type='text' name='location_desc' id='location_desc' size='20' maxlength='20' onBlur="getValues(locn_button,this,location_id)" tabindex=3><input type='hidden' name='location_id' id='location_id' value=''><input type='button' class='button' readOnly name='locn_button' id='locn_button' value='?' onClick="getValues(this,location_desc,location_id)" tabindex=4></td>
	</tr>
	<tr>
		<td class='LABEL'> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onBlur="getValues(pract_button,this,pract)" tabindex=5><input type='hidden' name='pract' id='pract' value=''><input type='button' class='button' readOnly name='pract_button' id='pract_button' value='?' onClick="getValues(this,pract_desc,pract)" tabindex=6></td>
	
		
		<td class='LABEL' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><input type='text' name='patient_id' id='patient_id'  tabindex=7 onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='<%=pid_length%>' onBlur='changeCase(this);'><input type='button' class='BUTTON' value="?"  name='patient_search' id='patient_search' onClick = 'callPatientSearch()' tabindex=8></td>
	</tr>
	
	<tr>
		<td  class='LABEL'  width="25%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='gender' id='gender' tabindex=9>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<!--<td class='LABEL'  width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='field'  width='25%'><input type='text' name='encounter_id' id='encounter_id' size='13' maxlength='12' onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0));' onBlur='return(ChkNumber(this))' tabindex=10><input type='button' class='BUTTON' value='?' name='encounter_search' id='encounter_search' onClick ='patvisit();' tabindex=11></td>-->

		<td>&nbsp;</td>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td  class='LABEL'  width="25%"><fmt:message key="Common.CancelledDateFrom.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><input type='text' id='patfrom' maxlength='10' size='9' name='cancelperiod_from' id='cancelperiod_from' size='15' onBlur="doDate(this)" tabindex=12 value=''><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patfrom');" style='cursor:pointer' ></img></td>
		
		<td  class='LABEL'  width="25%"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
		<td class='field'  width="25%"><input type='text' id='patto' maxlength='10' size='9' name='cancelperiod_to' id='cancelperiod_to' size='15' onBlur="doDate(this)" tabindex=13 value=''><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patto');" style='cursor:pointer'></img></td>
	</tr>
	<tr>
		<td  class='LABEL'  width="25%"><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><input type='text' name='cancelled_by' id='cancelled_by'  onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' onBlur='changeCase(this);GetLookupBlur(this);' tabindex=14><input type='hidden' name='user' id='user' size='40' maxlength='30' value='' readonly><input type='button' class='BUTTON' value="?"  name='cancel_search' id='cancel_search' onClick = 'GetLookup(cancelled_by);' tabindex=15></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td class='LABEL' width="25%"><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='disaster' id='disaster' tabindex=16><option value=''>&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;</option>
		<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<td class='LABEL' width="25%"><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='caseoftrauma' id='caseoftrauma' tabindex=17><option value=''>&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;</option>
		<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class='button' width="25%" align="right"><input type='button' class='BUTTON' title='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search' id='search' onClick='searchCancelChkout(cancelperiod_from,cancelperiod_to,parent.messageFrame);' tabindex=18>&nbsp;<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='clear' title='Clear' onClick='clearFn();' tabindex=19></td>
	</tr>
</table>

<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='chk_Select1' id='chk_Select1' value=''>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

</form>
</body>
<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con!=null)
		ConnectionManager.returnConnection(con,request);
    }
%>
<html>

