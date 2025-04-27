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
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");	
	String shift_code = request.getParameter("shift_code")==null ? "": request.getParameter("shift_code");

	int i=0;
 
	String position_code="";
	String position_desc="";
	String db_action="";
	String checked="";
	String eff_status="";

	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='frm_list' id='frm_list' method=POST action='../../servlet/eAM.ShiftForPositionServlet'
target='messageFrame'>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<td class='columnheader'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<%
try{
	String qry_position = "Select position_code, position_desc,'I' db_action,'E' eff_status from am_position where eff_status = 'E' and position_code not in    (select position_code from am_shift_for_position where  shift_code = ?) Union all Select a.position_code position_code, b.position_desc position_desc, 'U' db_action,a.eff_status eff_status from am_shift_for_position a, am_position b where a.shift_code = ? and a.position_code = b.position_code order by  position_desc";

	pstmt = conn.prepareStatement(qry_position);
	
	pstmt.setString(1,shift_code);
	pstmt.setString(2,shift_code);

	rs = pstmt.executeQuery();
		
	while(rs.next())
	{
		position_code=rs.getString("position_code")==null ? "":rs.getString("position_code");
		position_desc=rs.getString("position_desc")==null ? "":rs.getString("position_desc");
		db_action=rs.getString("db_action")==null ? "":rs.getString("db_action");
		eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");

    	String classValue = "" ;

		if (i%2==0)
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
%>
	<input type=hidden name='position_code<%=i%>' id='position_code<%=i%>' value='<%=position_code%>'>
<%
	out.println(position_desc+"</td><td class='" + classValue + "' align='center'>");
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
	<input type=hidden name="db_action<%=i%>" id="db_action<%=i%>" value="<%=db_action%>">
	<input type=hidden name="prev_select<%=i%>" id="prev_select<%=i%>" value="<%=checked%>">
<%
   out.println("</td></tr>");
	i++;
	}
%>
	</table>
	<input type=hidden name='operation' id='operation' value='showpositions'>
	<input type=hidden name='shift_code' id='shift_code' value='<%=shift_code %>'>
	<input type=hidden name='noOfRecords' id='noOfRecords' value='<%=i-1%>'>
	</form>
<%
}catch(Exception e)
{
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

