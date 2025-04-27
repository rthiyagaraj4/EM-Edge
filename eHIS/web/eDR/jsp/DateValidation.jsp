<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
   <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown='lockKey();'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String sys_date ="";
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String sql_sysdate = "SELECT to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'hh24:mi') FROM dual";
		rs = stmt.executeQuery(sql_sysdate);
		while(rs.next())
		{
			sys_date = rs.getString(1);

		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>	
<script>
	parent.frames[1].document.getElementById('sys_date').value='<%=sys_date%>';
	parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?";
</script>
</body>
</html>

