<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body BGCOLOR=#C0DCCD TEXT=#000000 LINK=#000000 VLINK=#000000 ALINK=#990000>

<%
PreparedStatement prepStmt = null;
Connection conn = null;

/* try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
	out.println("Could not get connection. Error Message ="+e.getMessage());
	return;
} 
String userName = "IBAEHIS";
String password = "IBAEHIS";
*/
try {
	/* conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@130.78.62.59:1521:srdv", userName,
			password); */
	conn = ConnectionManager.getConnection(request);
} catch (Exception e) {
	out.println("Could not get connection. Error Message ="+e.getMessage());
	return;
}

// safe approach
if(conn == null){
	out.println("Error in showing the details as connection to the database was not obtained");
	return;
}

String query = "Select * from SM_Module order by upper(Module_name)";
ResultSet rs = null;
try{
	prepStmt = conn.prepareStatement(query);	
	rs = prepStmt.executeQuery();
	if(rs != null){
	%>
	<TABLE >
	<TR><TD ALIGN = LEFT>
	<B><FONT FACE=Arial SIZE=4 COLOR=#000000>EHIS Table Modules </FONT></B>
	</TD>
	</TR>
	<TR>
	<TD ALIGN = LEFT>
		<Table>
			<tr>
				<td>
					<FONT FACE=Arial SIZE=1 COLOR=#000000><B>* Click the below EHIS Table Modules links for detailed column information</B>
					</FONT>			
				</td>
			</tr>
		</Table>
	</TD>
	
	<%
		String moduleName = "";
		String moduleId = "";
		while(rs.next()){
			moduleId = rs.getString("MODULE_ID");
			moduleName = rs.getString("MODULE_NAME");
		%>	
			<TR><TD ALIGN = LEFT>
			<A HREF = "ModuleDetails.jsp?moduleName=<%=moduleId %>" TARGET=REPWINDOW><FONT FACE=Arial SIZE=1 style="text-transform: uppercase;"><%=moduleName %>
			</FONT></TD></TR>
		<%	
		}
	%>
	
	</TABLE>
	<%	
	}
}catch(Exception ex){
	out.println("Could not get the list of modules. Error Message ="+ex.getMessage());
	return;
}
finally{
	if(rs != null){
		try{
			rs.close();
		}catch(Exception ex){
			
		}
	}
	
	if(prepStmt != null){
		try{
			prepStmt.close();
		}catch(Exception ex){
			
		}
	}
	ConnectionManager.returnConnection(conn, request);
}
%>

</body>
</html>
