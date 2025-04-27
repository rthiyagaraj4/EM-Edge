<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%request.setCharacterEncoding("UTF-8");	
    Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String shift_code = request.getParameter("shift_code")==null ? "": request.getParameter("shift_code");
	String locn_type = request.getParameter("locn_type")==null ? "": request.getParameter("locn_type");

	String facility_id="";
	String facility_name="";
	String db_action="";
	String checked="";
	String eff_status="";
    int i=0;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='frm_list' id='frm_list' method=POST action='../../servlet/eAM.ShiftForLocationTypeServlet'
target='messageFrame'>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<td class='columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<%
    try
	{
	String qry_facility = "Select facility_id, facility_name,'I' db_action, 'E' eff_status from sm_facility_param where status = 'E' And facility_id not in    (select facility_id from am_shift_for_locn_type    where locn_type = ? and shift_code = ?) Union all Select a.facility_id facility_id, b.facility_name facility_name, 'U' db_action, a.eff_status eff_status from am_shift_for_locn_type a, sm_facility_param b where a.locn_type = ? and a.shift_code = ? and a.facility_id = b.facility_id Order by facility_name";

	pstmt = conn.prepareStatement(qry_facility);
	
	pstmt.setString(1,locn_type);
	pstmt.setString(2,shift_code);
	pstmt.setString(3,locn_type);
	pstmt.setString(4,shift_code);

	rs = pstmt.executeQuery();
	while(rs.next())
	{
		facility_id=rs.getString("facility_id")==null ? "":rs.getString("facility_id");
		facility_name=rs.getString("facility_name")==null ? "":rs.getString("facility_name");
    	db_action=rs.getString("db_action")==null ? "":rs.getString("db_action");
    	eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");

	String classValue = "" ;
		if(i%2 == 0)
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
%>
<input type=hidden name='facility_id<%=i%>' id='facility_id<%=i%>' value='<%=facility_id%>'>
<%
	out.println(facility_name +"</td><td class='" + classValue + "' align='center'>");
	if((db_action.equals("U")) && (eff_status.equals("E")))
	{
		checked="checked";
	}
	else 
	{
		checked="";
	}
%>
	<input type=checkbox name="select<%=i%>" id="select<%=i%>" <%=checked%>>
	<input type=hidden name="db_action<%=i%>" id="db_action<%=i%>" value=<%=db_action%>>
	<input type=hidden name="prev_select<%=i%>" id="prev_select<%=i%>" value="<%=checked%>">
<%
	out.println("</td></tr>");
	i++;
	}
%>
	</table>
	<input type=hidden name='operation' id='operation' value='showfacilities'>
	<input type=hidden name='shift_code' id='shift_code' value='<%= shift_code %>'>
	<input type=hidden name='locn_type' id='locn_type' value='<%= locn_type %>'> 
	<input type=hidden name='noOfRecords' id='noOfRecords' value='<%=i-1%>'>
	</form>
<%
}
catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

