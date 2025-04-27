<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,com.ehis.util.*,java.util.*,java.text.*,java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>		
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
		<script language='javascript' src="../../eIP/js/IPQueryCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con 	= null;
	Statement stmt	= null;
	ResultSet rs 	= null;

	String sql	= "";
	String Patient_Id_Length= "";

	try
	{
		con= ConnectionManager.getConnection(request);

		sql="Select Patient_Id_Length from mp_param";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		rs.next();

		Patient_Id_Length=rs.getString("Patient_Id_Length");

		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td class='label' align='right'><fmt:message key="eIP.LodgerId.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<input type='text' maxlength='<%=Patient_Id_Length%>' size='<%=Patient_Id_Length%>' name='lodger_ref_no'  onBlur="return makeValidQueryCriteria(this);" ><input type=button class=button name=lodger_patient_search id=lodger_patient_search value='?' onClick="callLodgerSearch_lodger()">
				</td>
				<td class='label' align='right'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<select name="gender" id="gender">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select>
				</td>
				<td class='label' align='right'><fmt:message key="Common.AttachedtoPatient.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<input type='checkbox'  value='Y' name='attached_patient' id='attached_patient'>
				</td>
			</tr>		
			
			<tr>
				<td class='label' align='right'><fmt:message key="eIP.CheckInDateFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td colspan='5'><input type='text' id="date_from" maxlength='10' size='10' name='from_date' id='from_date' onBlur='DateCompare_lodger(this,to_date);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" maxlength='10' size='10' name='to_date' id='to_date' onBlur='DateCompare_lodger(from_date,this);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('date_to');"></td>
			</tr>		
		</table>

	  <table align='right'>
		<tr>
			<td align='right' class='white'>
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage_lodger()'>
				<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="clearAll_lodger()">
			</td>
		</tr>				
	  </table>
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

