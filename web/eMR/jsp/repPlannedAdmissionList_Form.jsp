<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   <script src="../../eMR/js/MRReports.js" language="javascript"></script>
   <script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
    <script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 




</head>

<%  
    String p_module_id      = "MR" ;
    String p_report_id      = "MRBCPIPA" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>
<body onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_fr_adm_date')">
	<br>
	<br>
	<form name="repInpatientAdmissionListBCP_Form" id="repInpatientAdmissionListBCP_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%
    Connection con  =  null;
    Statement stmt = null;
    ResultSet rset = null;

	StringBuffer sql = new StringBuffer();
    sql.append("Select TO_CHAR(SYSDATE,'DD/MM/rrrr'),TO_CHAR(SYSDATE+6,'DD/MM/rrrr') From DUAL " );
	String StrVal = "";
	String date_range_week = "";

    try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());

		if(rset.next())
		{
			StrVal = rset.getString(1);
			StrVal=DateUtils.convertDate(StrVal,"DMY","en",locale);
			date_range_week = rset.getString(2);
			date_range_week=DateUtils.convertDate(date_range_week,"DMY","en",locale);
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace(); }
	 finally
	 {
		try{
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		}
		catch(Exception e)
		 {/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
	<table width='80%' align='center' valign='top'>
		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		<tr>
			<td width="100%" class="Border" align='center'>
				<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>

					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					
					<tr>
						<td align="center" width="30%">&nbsp;</td>
						<td class='querydata' width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class='querydata' width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.PrefAdmissionDate.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='30%'>
							<input type='text' name='p_fr_adm_date' id='p_fr_adm_date' size="10" maxlength="10" align="center" value='<%=StrVal%>' onblur='validate_date_xyz(this,"FROM_DATE_LESS_SYSDATE","P");if(document.getElementById("p_to_adm_date").value!="")dateCheckforWeek(this,document.getElementById("p_to_adm_date"))'>
							<img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_fr_adm_date').select();return showCalendar('p_fr_adm_date');"/>
							&nbsp;
							<img align='center' src='../../eCommon/images/mandatory.gif'/>
						</td>
						
<!--30 Sep 2010  IN024014  changed function name validate_date_xyz -->
						<td width='40%'> 
							<input type='text' name='p_to_adm_date' id='p_to_adm_date' size="10" maxlength="10" align="center" value='<%=date_range_week%>' onblur='validate_date_xyz(this,"TO_DATE_LESS_SYSDATE","P");dateCheckforWeek(document.getElementById("p_fr_adm_date"),this)'>
							<img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('p_to_adm_date').select();return showCalendar('p_to_adm_date');"/>
							&nbsp;
							<img align='center' src='../../eCommon/images/mandatory.gif'></img>
						</td> 


						<!--<input type='text' id='pref_to_date' name='p_to_adm_date' id='p_to_adm_date' size="10" maxlength="10" align="center" value='<%=date_range_week%>' onblur='validate_date_xyz(this,"TO_DATE_LESS_SYSDATE","P");validate_date_xyz(this,"TO_DT_GR_EQ_FM_DT","P");dateCheckforWeek(document.getElementById("p_fr_adm_date"),this)'><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_to_adm_date.select();return showCalendar('pref_to_date');"/>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>  -->
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					
					
					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td width='30%'  ><input type=text  name='p_fr_locn_code' id='p_fr_locn_code' size="4" maxlength="4" onBlur='if(this.value != "") searchCoderepAppointmentsforopdBCP_Form(locationcode,this)'align="center" value=""><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='searchCoderepAppointmentsforopdBCP_Form(this, p_fr_locn_code)'></td>
						<td width='40%'> <input type=text  name='p_to_locn_code' id='p_to_locn_code' size="4" maxlength="4" onBlur='if(this.value != "") searchCoderepAppointmentsforopdBCP_Form(locationcode,this)' align="center"><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='searchCoderepAppointmentsforopdBCP_Form(this, p_to_locn_code)'></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
						<td width='30%'><select name='p_bkg_type' id='p_bkg_type' >
						<option value='BO'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value='BK'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></option>
						<option value='RF'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
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
	<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
	<input type="hidden" name="sys_date" id="sys_date"         value="<%= StrVal %>">
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

