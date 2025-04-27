<!DOCTYPE html>
<!-- PositionForMDCPHeader.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	30 Dec 2004

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>	
		<script language='javascript' src='../../eCommon/js/messages.js' ></script>
		<script language="javascript" src="../js/CpMessages.js"></script>  
		<script language="JavaScript" src="../../eCP/js/PositionForMDCP.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String facility_sql="";
String practitioner_sql="";

Vector facility_list=new Vector();
Vector practitioner_list=new Vector();

Connection conn=null;
Statement facility_stmt=null;
Statement practitioner_stmt=null;
ResultSet facility_rs=null;
ResultSet practitioner_rs=null;

try
{
conn=ConnectionManager.getConnection();

facility_sql="Select facility_id,facility_name from sm_facility_param where status='E' order by facility_name";

facility_stmt=conn.createStatement();
facility_rs=facility_stmt.executeQuery(facility_sql);
while(facility_rs.next())
	{
		facility_list.add(facility_rs.getString("facility_id"));
		facility_list.add(facility_rs.getString("facility_name"));
	}


practitioner_sql="Select pract_type, desc_userdef pract_type_desc from am_pract_type where eff_status = 'E' order by pract_type_desc";

practitioner_stmt=conn.createStatement();
practitioner_rs=practitioner_stmt.executeQuery(practitioner_sql);

while(practitioner_rs.next())
	{
		practitioner_list.add(practitioner_rs.getString("pract_type"));
		practitioner_list.add(practitioner_rs.getString("pract_type_desc"));

	}
}catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
finally
{
	if(facility_rs!=null) facility_rs.close();
	if(practitioner_rs!=null) practitioner_rs.close();
	if(facility_stmt!=null) facility_stmt.close();
	if(practitioner_stmt!=null) practitioner_stmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=form_PositionForMDCP>
		<table border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;
					<select name='facility_id1' id='facility_id1' onchange='clearDetail();'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%for(int i=0;i<facility_list.size();i+=2)
						{%>
						<option value='<%=facility_list.get(i)%>'><%= (String)facility_list.get(i+1)%> </option>
						<%}%>
					</select><img src="../../eCommon/images/mandatory.gif"></img>
				</td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;
					<select name='pract_type' id='pract_type' onchange='clearDetail();'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%for(int i=0;i<practitioner_list.size();i+=2){%>
							<option value=<%=practitioner_list.get(i)%>><%=practitioner_list.get(i+1)%></option>
							<%}%>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right">	
					<input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='search_lookup' onclick='viewPosition()'>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

