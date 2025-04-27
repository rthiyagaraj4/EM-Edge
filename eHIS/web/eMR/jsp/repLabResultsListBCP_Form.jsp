<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
 request.setCharacterEncoding("UTF-8");  %>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   <script src="../../eMR/js/MRReports.js" language="javascript"></script>
   <script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
 <script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>




<% 

    String p_module_id      = "MR" ;
    String p_report_id      = "MRBCPLBR" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
%>
<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_fr_adm_date')">
	<br>
	<br>
	<form name="repLabResultsListBCP_Form" id="repLabResultsListBCP_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%
    Connection con  =  null;
    Statement stmt = null;
    ResultSet rset = null;

	StringBuffer sql = new StringBuffer();
    sql.append("Select TO_CHAR(SYSDATE,'DD/MM/rrrr') From DUAL " );
	String StrVal = "";

    try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());

		if(rset.next())
		{
			StrVal = rset.getString(1); 
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
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
						<td align='left' width='30%' class="label"><fmt:message key="Common.Event.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
						<td width='30%'>
						<input type='text' name='p_fr_adm_date' id='p_fr_adm_date' size="10" maxlength="10" align="center"  value='' onblur="validDateObj(this,'DMY','<%=localeName%>');labvalidate_date(this);ComparePeriodFromToTime(this,p_to_adm_date)"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_fr_adm_date.select();return showCalendar('p_fr_adm_date');"/></td>


						<td width='40%'> 
						<input type='text' name='p_to_adm_date' id='p_to_adm_date' size="10" maxlength="10" align="center" value='' onblur="validDateObj(this,'DMY','<%=localeName%>');labvalidate_date(this);ComparePeriodFromToTime(p_fr_adm_date,this)"><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_to_adm_date.select();return showCalendar('p_to_adm_date');"/></td>

					</tr>

					
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
                    <tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
						<td width='30%'>
						<input type=text   name='p_fr_nursing_unit' id='p_fr_nursing_unit' size="4" maxlength="4"  onBlur='if(this.value != ""){ searchCoderepCurrentMedicationList(nursing,this)}' align="center">
						<input type='button'  name='nursing' id='nursing' value='?' class='button' onclick='searchCoderepCurrentMedicationList(this, p_fr_nursing_unit)'>
						&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
						
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
	</BODY>
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

