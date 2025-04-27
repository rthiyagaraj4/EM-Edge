<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/ecis.css'></link> -->	
	<script language='javascript' src='../js/Priority.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
/*Conditional Addition by SRIDHAR R on 28 APR 2004
Condition : The following Code will check the Value of Priority Applicable in Ip Parameter function. The Page Will only be displayed if the Priority Applicable check box is enabled in IP Param.
*/
	String facilityId = (String)session.getValue("facility_id");
	Statement stmt	= null;
	Statement stmt1	= null;
	ResultSet rs	= null;
	ResultSet rs1	= null;
	Connection con  = null;
	int count = 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery("select count(*) count from ip_param where FACILITY_ID = '"+facilityId+"'");
		while(rs1!=null && rs1.next())
		{
			count = rs1.getInt("count");
		}
		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();
		if(count == 0)
		{
			%>
				<script>alert(getMessage("PRIORITY_NOT_DEFINED","IP"));</script>
			<%
		}	%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0  style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
		<%
						
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
	}catch(Exception e)
	{
		out.print("Exception "+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

