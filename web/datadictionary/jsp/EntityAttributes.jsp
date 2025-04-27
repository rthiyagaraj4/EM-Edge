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

String query = "SELECT ROWNUM NUMB, ATTRIBUTE_NAME, data_type||'('||data_length||')' data_type, DESCRIPTIONS FROM ( SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 )";
//query = " SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 ";
PreparedStatement prepStmt = null;
ResultSet rs = null;

%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
<tr>
     <td class="maintabletdstyle"> <b>List of attributes for view :&nbsp;<%=entityName %> </b>
     </td>
</tr>
<tr>
<td>


<%
try{
	prepStmt = conn.prepareStatement(query);
	rs = prepStmt.executeQuery();
	if(rs != null){
	%>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>	
		<th align="left" class="datatablethstyle">No</th>
		<th align="left" class="datatablethstyle">Name</th>
		<th align="left" class="datatablethstyle">Type</th>
		<th align="left" class="datatablethstyle">Descriptions</th>
	</tr>	
	<%	
		Object numbObj = null;
		while(rs.next()){
			String desc = rs.getString("DESCRIPTIONS");
			if(desc == null){
				desc = "&nbsp;";
			}
			%>
			<tr>
				<td width="7%" align="left" class="datatabletdstyle"><%=rs.getObject("NUMB") %>					
				</td>
				<td width="25%" align="left" class="datatabletdstyle"><%=rs.getString("ATTRIBUTE_NAME") %>
				</td>
				<td width="20%" align="left" class="datatabletdstyle"><%=rs.getObject("data_type") %>				
				</td>
				<td width="48%" align="left" class="datatabletdstyle"><%=desc %></td>
			</tr>	
		<%		
		}
	%>
	</table>
	<%
	}else{
		out.println("Could not obtain records for "+entityName);
		return;
	}
%>
	
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
