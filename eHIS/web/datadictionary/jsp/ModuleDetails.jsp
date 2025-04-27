<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/moduleDetails.css"/> 
<script type="text/javascript">
function showAttr(entityName){
	var url = "EntityAttributes.jsp?entityName="+entityName;
	//parent.REPWINDOW.location.href = url;
	parent.showInBottomFrame(url);
	//window.location.href = url;
	
}
function showAssociatedEntities(entityName){
	var url = "EntityAssociates.jsp?entityName="+entityName;
	//parent.REPWINDOW.location.href = url;
	parent.showInBottomFrame(url);
	//window.location.href = url;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body bgcolor="#F2F2F5">

<form name="moduleForm" id="moduleForm">
<%
String moduleId = request.getParameter("moduleId");
if(moduleId == null){
	moduleId = "";
}
String moduleName = request.getParameter("moduleName");
if(moduleName == null){
	moduleName = "";
}
%>
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="maintablestyle" style="border: 1px;">
<tr>
<td class="maintabletdstyle">
<b>List of views for Module :&nbsp;<%=moduleName %></b>
</td>
</tr>

<tr>
<td>
<%

String completeModuleName = moduleId+"%";

String query = "";

PreparedStatement prepStmt = null;
Connection conn = null;

try {
	conn = ConnectionManager.getConnection(request);
} catch (Exception e) {
	out.println("<span class='spanstyle'>Could not get connection. Error Message ="+e.getMessage()+"</span>");
	return;
}

// safe approach
if(conn == null){
	out.println("<span class='spanstyle'>Error in showing details as connection to the database was not obtained</span>");
	return;
}

String userName = "";
DatabaseMetaData dbmd = null;
try{
	dbmd = conn.getMetaData();	
}catch(Exception ex){
	out.println("<span class='spanstyle'>Error in showing details</span>");
	return;
}

if(dbmd == null){
	out.println("<span class='spanstyle'>Error in showing details</span>");
	return;
}

userName = dbmd.getUserName();

query = "SELECT A.OWNER,A.VIEW_NAME,B.TABLE_TYPE,B.COMMENTS FROM ALL_VIEWS A, ALL_TAB_COMMENTS B WHERE A.OWNER = B.OWNER AND A.VIEW_NAME = B.TABLE_NAME and A.owner = '"+userName+"' AND A.VIEW_NAME LIKE ('"+completeModuleName+"') AND B.TABLE_TYPE = 'VIEW'";

String entityName = "";
ResultSet rs = null;
int rowCount = 0;
try{
	prepStmt = conn.prepareStatement(query);
	rs = prepStmt.executeQuery();
	if(rs != null){
	 %>
	 <table width="99%" border="5" cellpadding="0" cellspacing="0" class="datatablestyle">
	 <%	
		while(rs.next()){
			if(rowCount == 0){
		%>
		
		<tr>	<th align="left" class="datatablethstyle">View Name</th>
			<th align="left" class="datatablethstyle">Description</th>
			<th align="center" class="datatablethstyle">Attributes</th>
			<th align="center" class="datatablethstyle">Associated Entities</th>
		</tr>
		<%		rowCount++;
			}
			entityName = rs.getString("VIEW_NAME");
			if(entityName != null && !entityName.trim().equals("")){
			%>	
			<tr>
			<td width="25%" class="datatabletdstyle"><%=entityName %></td>
			<%
			if(rowCount == 1){
			%>
			<td width="48%" class="datatabletdstyle">This is a test for description column this is a very long description in deed just to test how the GUI is showing this column</td>
			<%
			}else{
			%>
			<td width="48%" class="datatabletdstyle">&nbsp;</td>
			<%
			}
			%>
			<td align="center" width="10%" class="datatabletdstyle"><img src="List_Attr.gif" onclick="showAttr('<%=entityName %>')" ></img>
			</td>
			<td align="center" width="15%" class="datatabletdstyle"><img src="Linked_Entities.gif" onclick="showAssociatedEntities('<%=entityName %>')"></img></td>
			</tr>
			<%	
			}
			rowCount++;
		}
		%>
		</table>
		<%
		// indicates no records were fetched
		if(rowCount == 0){
		%>
		<span class="spanstyle">No records obtained for the selected module</span>
		<%	
		}
	}
	
}catch(Exception ex){
	out.println("<span class='spanstyle'>Could not obtain records for the module "+moduleName+"</span>");
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
</td>
</tr>
</table>

<input type="hidden" id="hdnModuleName" value="<%=moduleName %>"/>
</form>

</body>
</html>

