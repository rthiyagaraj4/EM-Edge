<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	ResultSet rset = null;
	Statement stmt1 = null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String currentdate = "";
try {

    con=ConnectionManager.getConnection(request);
	String getDate = "select to_char(sysdate,'dd/mm/rrrr') sdate from dual" ;
	Statement stmt = con.createStatement();
	rset	  = stmt.executeQuery(getDate);
	if (rset.next())
	{
		currentdate	=  rset.getString("sdate");
	}
	if ( stmt != null ) stmt.close();
	if ( rset != null ) rset.close();

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<!--Modified by Ashwini on 27-Feb-2020 for ML-MMOH-SCF-1452-->
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();mychangerepOPAttbyRace();clinicclearrepOPAttbyRace();"  onKeyDown = 'lockKey()'>
<form name="MROPCSEG" id="MROPCSEG" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<input type="hidden" name="current_date" id="current_date" value="<%=currentdate%>">
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
 <th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<tr>
	<td align='right' width='20%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td width='20%'  >
		 <SELECT name="report_type" id="report_type" onchange='mychangerepOPAttbyRace()'>
		 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
		 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
		 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
		 </SELECT>
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>

<tr>
		<td align='right'  class="label"> &nbsp; </td>
		<td align='left' class="label"> <fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
		<td align='left' class="label"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
</tr>

<tr>
		<td align='right' id='MY1'class="label"> &nbsp; </td>
		<td align='left' id='MY' > &nbsp; </td>
		<td align='left' id='MY3' > &nbsp; </td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<tr>
	<td align='right'  class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>

		<td>
		   <SELECT name='p_location_type' id='p_location_type' onchange="clinicclearrepOPAttbyRace()"> 
			   <!--Modified by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352-->
			   <option value='' style='align:center'> ----------------- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ----------------- </option>
			   <option value='ED' style='align:center'><fmt:message key="eMR.EmergencyDepartment.label" bundle="${mr_labels}"/></option>
			   <option value='SC' style='align:center'><fmt:message key="Common.SpecialistClinic.label" bundle="${common_labels}"/></option>
			   <!-- Added by KAMATCHI S for ML-MMOH-CRF-1606-->
				<option value='ST'><fmt:message key="eMR.KlinikKhas.label" bundle="${mr_labels}"/></option>
			   <!--<option value='ST' style='align:center'><fmt:message key="Common.Staff.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>-->
			   <option value='PU' style='align:center'><fmt:message key="Common.PAC.label" bundle="${common_labels}"/></option>
			</select>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;</td>
		<td>
			<input type=text onkeypress='return ValidStringrepOPAttbyRace(event)' name='p_clinic' id='p_clinic' size="4" maxlength="4"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick="searchCodelocn(p_location_type,p_clinic)">&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'>
		<SELECT name="p_type" id="p_type" >
		<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
		<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
		<td >&nbsp; </td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
finally
{
	try
	{
	 if(rset!= null) rset.close();
	 if(stmt1!=null) stmt1.close();
	}
	catch(Exception e) {  }
	 ConnectionManager.returnConnection(con,request);
}
%>
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

