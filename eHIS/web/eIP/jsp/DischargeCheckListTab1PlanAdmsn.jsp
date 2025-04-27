<!DOCTYPE html>
<!--Created by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
Connection con	= null;
ResultSet rset  = null; 
PreparedStatement pstmt	= null;

String  patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String  facilityId			= (String)session.getValue("facility_id");
String preferred_date = "";
String nursing_unit = "";

%>

<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<style>
.container {
    width:650px;
}

.container table {
    width: 590px;
    table-layout: fixed;
}


.inner_table {
    height: 100px;
    overflow-y: auto;
}
</style>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListPlannedAdmsn' id='DischargeCheckListPlannedAdmsn'>
<%	try
	{
		con	= ConnectionManager.getConnection(request);

			String sqlQuery = "SELECT TO_CHAR(preferred_date,'dd/mm/yyyy hh24:mi')preferred_date, ip_get_desc.ip_nursing_unit (facility_id, nursing_unit_code, ? , '2' ) nursing_unit FROM ip_booking_list WHERE preferred_date >= SYSDATE AND booking_status = '1' AND facility_id = ? AND patient_id = ?";

			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,patient_id);
			rset= pstmt.executeQuery();
		
		
	%>


	<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class='COLUMNHEADER' colspan='7'><fmt:message key="eIP.PlannedAdmission.label" bundle="${ip_labels}"/></td>
		</tr><tr></tr>
	<div class="container">
	<table border='0' cellpadding='0' cellspacing='0'   width="50%" >
					<tr>
						<th style="width:25%" class="columnheader"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
						<th style="width:25%" class="columnheader"><fmt:message key="eIP.DateOfPlannedAdmission.label" bundle="${ip_labels}"/></th>
					</tr>
	</table>

	<div class="inner_table">
	<table border='0' cellpadding='0' cellspacing='0'   width="50%"  >

			<%while(rset!=null && rset.next())
			{
				preferred_date = rset.getString("preferred_date");	
				if(preferred_date == null) preferred_date = "";
				
				nursing_unit = rset.getString("nursing_unit");	
				if(nursing_unit == null) nursing_unit = "";
				%>

			<tr>
			<td nowrap class='fields' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='location' id='location' value='<%=nursing_unit%>' size='25' maxlength='30' disabled></td>
			
			
			<td nowrap class='fields' ><input type='text' value='<%=preferred_date%>' name='plan_admsn_date'  size='25' maxlength='30' disabled></td>
			</tr>
			
			<%}

			if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();

	}catch(Exception e) 
	{ 
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>

	</table>

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

