<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
     <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script src='../js/ShiftForLocationType.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
<%
Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs_locn=null;
ResultSet rs_facility = null;
try{



//Vector locn_list = new Vector();
//Vector facility_list = new Vector();
ArrayList facility_list = new ArrayList();
ArrayList locn_list = new ArrayList();
try
	{
String qry_locn = "Select locn_type, short_desc locn_desc from am_care_locn_type order by short_desc";
pstmt = conn.prepareStatement(qry_locn);
	
	rs_locn = pstmt.executeQuery();
	while(rs_locn.next())
	{
		locn_list.add(rs_locn.getString("locn_type"));
		locn_list.add(rs_locn.getString("locn_desc"));
	}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
		}

String qry_facility = "Select facility_id, facility_name from sm_facility_param where status = 'E' order by facility_name";
pstmt = conn.prepareStatement(qry_facility);

	rs_facility = pstmt.executeQuery();
	while(rs_facility.next())
	{
		facility_list.add(rs_facility.getString("facility_id"));
		facility_list.add(rs_facility.getString("facility_name"));
	}
	
%>
<form name='frm_shift_by_facility' id='frm_shift_by_facility'>
	
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			
			<br>
			<br>
			<br>
			<br>
			<br>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td class="label" width="25%"> <fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> &nbsp;</td>
				<td class='fields' width="55%">
				<select name="locn_type" id="locn_type" onchange='locationval()'>
					<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<%
				for(int i=0;i<locn_list.size();i+=2)
				{
				%>
					<option value='<%= locn_list.get(i) %>' ><%= locn_list.get(i+1) %> </option>
				<%
				}
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp</td>
				<td class='fields' width="55%">
				<select name="facility" id="facility" onchange='facilityval()'>
					<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				for(int i=0;i<facility_list.size();i+=2)
				{
				%>
					<option value='<%= facility_list.get(i) %>' ><%= facility_list.get(i+1) %> </option>
				<%
				}
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td width="20%"><input type=button class='button' name='show_shifts' id='show_shifts' value='<fmt:message key="Common.ShowShifts.label" bundle="${common_labels}"/>' onclick="showShiftsList()"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
	</table>
<%
	
facility_list.clear();
locn_list.clear();
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
	if (pstmt != null) pstmt.close();
	  if (rs_locn != null)   rs_locn.close();
	  if (rs_facility != null)   rs_facility.close();
	  ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>

