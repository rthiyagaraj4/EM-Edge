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
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/moduleDetails.css"/>
</head>
<body bgcolor="#F2F2F5">

<%
String entityName = request.getParameter("entityName");
if(entityName == null){
	entityName = "";
}
Connection conn = null;

try {
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

String query = "select * from EHIS_TABLE_DEPENDANCY WHERE referenced_by_object_type='VIEW' AND referenced_by_object_name = '"+entityName+"' ORDER BY TABLE_NAME";
query = "SELECT referenced_owner AS TABLE_OWNER, referenced_name AS TABLE_NAME, OWNER AS REFERENCED_BY_OBJECT_OWNER, name AS REFERENCED_BY_OBJECT_NAME, TYPE AS REFERENCED_BY_OBJECT_TYPE FROM sys.dba_dependencies WHERE referenced_type='TABLE' AND referenced_owner='IBAEHIS' and name='"+entityName+"' ORDER BY 1,2";
PreparedStatement prepStmt = null;
ResultSet rs = null;

%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
<tr>
     <td class="maintabletdstyle"> <b>List of associated entities for view :&nbsp;<%=entityName %> </b>
     </td>
</tr>
<tr>
<td>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
<%
try{
	prepStmt = conn.prepareStatement(query);
	rs = prepStmt.executeQuery();
	if(rs != null){
	%>
	
	<tr>	
		<th align="left" class="datatablethstyle">Table Owner</th>
		<th align="left" class="datatablethstyle">Table Name</th>
	</tr>
	<%	
		while(rs.next()){
	%>
	<tr>
		<td align="left" class="datatabletdstyle"><%=rs.getString("TABLE_OWNER")%></td>
		<td align="left" class="datatabletdstyle"><%=rs.getString("TABLE_NAME") %></td>
	</tr>		
		<%		
		}
	%>
	
	<%
	}
	
%>	
</table>
</td>
</tr>
</table>
<%	
	}catch(Exception ex){
		out.println("Could not obtain records for "+entityName);
		return;
	}finally{
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
