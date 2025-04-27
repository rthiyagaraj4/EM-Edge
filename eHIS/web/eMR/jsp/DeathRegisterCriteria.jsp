<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src="../../eMR/js/CreatePatientFile.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	String p_user_name		= (String) session.getValue( "login_user" );
	Connection con = ConnectionManager.getConnection(request);
	ResultSet rs   = null;
	Statement stmt = null;
	
try 
{
	String pat_length="";
    String p_facility_id		= (String) session.getValue( "facility_id" );
	String currentdate = "";
	
	stmt = con.createStatement();
	rs=stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') d ,patient_id_length from mp_param");
	if (rs!=null&&rs.next())
	{
       currentdate = rs.getString("d");
	   pat_length = rs.getString(2);
	}

%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
      <div>
		<table cellpadding="1" cellspacing="0" width="100%" align="center" border="0">
			<tr>
				<td width="18%" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width="29%" class="fields">
				<input type=text  name='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this)" >
				<input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
				<input type=hidden  name='p_encounter_id' id='p_encounter_id' value="">
				</td>
				<td width="18%" class="label"></td>
				<td width="27%" class="label"></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="eIP.Admissions.label" bundle="${ip_labels}"/> <fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				<td class="fields"><!--<input name='p_adm_date' id='p_adm_date' value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.getEle.sys_date);compareDates1(this,document.forms[0].p_discharge_date);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_adm_date.focus();return showCalendar('p_adm_date' );">-->
				<!--<input name='p_adm_from_date' id='p_adm_from_date' value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.getElementById('sys_date'));compareDates2(this,document.getElementById('p_adm_from_date'));compareDates1(this,document.getElementById('p_adm_from_date'));'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_adm_from_date').focus();return showCalendar('p_adm_from_date' );">-->
				
				 <input name='p_adm_from_date' id='p_adm_from_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_adm_to_date);compareDates1(this,document.forms[0].p_adm_from_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_adm_from_date.focus();return showCalendar('p_adm_from_date' );">
				
				
				<!-- <input name='p_adm_to_date' id='p_adm_to_date' value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.getElementById('sys_date'));compareDates2(document.getElementById('p_adm_to_date'),this);compareDates1(document.getElmentById('p_adm_to_date'),document.getElementById('p_adm_to_date'));'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_adm_to_date');return showCalendar('p_adm_to_date' );"></td>-->
				 
				  <input name='p_adm_to_date' id='p_adm_to_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_adm_to_date);compareDates1(this,document.forms[0].p_adm_to_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_adm_to_date.focus();return showCalendar('p_adm_to_date' );">
				 
				<td class='label'><fmt:message key="eMR.DischPeriod.label" bundle="${mr_labels}"/></td>
				<td class="fields"><!--<input name='p_discharge_date' id='p_discharge_date'  value='' size='10' maxlength='10' title='To proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates1(document.forms[0].p_discharge_date,this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_discharge_date.focus(); return showCalendar('p_discharge_date' );">-->
			<!--	<input name='p_discharge_from_date' id='p_discharge_from_date' value size='10' maxlength='10' title='To proc Date' Onblur='compareDates(this,document.getElementById('sys_date'));compareDates2(this,document.getElementById('p_discharge_from_date');compareDates1(document.getElementById('p_discharge_from_date'),this);><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_discharge_from_date').focus(); return showCalendar('p_discharge_from_date' );"> -->
			
			 <input name='p_discharge_from_date' id='p_discharge_from_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_discharge_from_date);compareDates1(this,document.forms[0].p_discharge_from_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_discharge_from_date.focus();return showCalendar('p_discharge_from_date' );">
			 
				<!-- <input name='p_discharge_to_date' id='p_discharge_to_date'  value='' size='10' maxlength='10' title='To proc Date' Onblur='compareDates(this,document.getElementById('sys_date'));compareDates2(document.getElementById.('p_discharge_to_date'),this);compareDates1(document.getElementById('p_discharge_to_date'),document.getElementById(elementId).p_discharge_to_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_discharge_to_date').focus(); return showCalendar('p_discharge_to_date' );">-->
				 <input name='p_discharge_to_date' id='p_discharge_to_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_discharge_to_date);compareDates1(this,document.forms[0].p_discharge_to_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_discharge_to_date.focus();return showCalendar('p_discharge_to_date' );">
				
				</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				<td class="fields">
				<!--<input name='p_deceased_from_date' id='p_deceased_from_date'  value='' size='10' maxlength='10' Onblur='compareDates(this,document.getElementById('sys_date');compareDates2(this,document.getElementById('p_deceased_from_date'));'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_deceased_from_date').focus(); return showCalendar('p_deceased_from_date' );"> -->
				
				 <input name='p_deceased_from_date' id='p_deceased_from_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_deceased_from_date);compareDates1(this,document.forms[0].p_deceased_from_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_deceased_from_date.focus();return showCalendar('p_deceased_from_date' );">
				 
				 
				<!-- <input name='p_deceased_to_date'  id='p_deceased_to_date' size='10' maxlength='10' Onblur='compareDates(this,document.getElementById('sys_date');compareDates2(document.getElementById('p_deceased_from_date'),this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_deceased_to_date').focus(); return showCalendar('p_deceased_to_date' );"></td>-->

                   <input name='p_deceased_to_date' id='p_deceased_to_date'  value='' size='10' maxlength='10' title='From proc Date' Onblur='compareDates(this,document.forms[0].sys_date);compareDates2(this,document.forms[0].p_deceased_to_date);compareDates1(this,document.forms[0].p_deceased_to_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_deceased_to_date.focus();return showCalendar('p_deceased_to_date' );">



			  <td width='25%' class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		      <td width='25%' class='fields' colspan='3'><select name="status" id="status">
			  <!-- <option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> -->
			   <option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	 		  <option value='R'><fmt:message key="eMR.Recorded.label" bundle="${mr_labels}"/></option>
	 		  <option value='F'><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option>

			  </select>

			</tr>
			<tr>
				<td colspan="3" class="label">&nbsp;</td>
				<td class="button"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll1()'></td>
			</tr>
		</table>
     </div>
     <input type='hidden' name='call_function' id='call_function' value=''></input>
     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBIPPRC'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
<%
       if (rs != null) 
			rs.close();
       if (stmt != null) 
		   stmt.close();
} 
catch(Exception e) 
{
  //out.println("Exception @ try"+e.toString());
  e.printStackTrace();
}
finally 
{
	try
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}
	catch(Exception e){	}
	ConnectionManager.returnConnection(con,request);
}
%>
  </form>
</body>

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

