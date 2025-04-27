<!DOCTYPE html>
 <%@ page import="java.sql.*" %>

<%
	

	String p_module_id		= "PH" ;
	String p_report_id		= "PHBREGPR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

%>
<html>
<HEAD>
<TITLE></TITLE>
</HEAD>

<body onMouseDown="" onKeyDown="lockKey()">
<form>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</body>
</HTML>

