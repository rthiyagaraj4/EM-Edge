<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	try
	{
		String strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";
%>			
<html>
	<iframe SRC="AddModifyPatFinClassDetails.jsp?<%= strAllParam%>" name='FinClassFrame' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>	
		<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
<%
	}
	catch(Exception eX)
	{
		System.out.println("Error in QryMain.jsp= "+eX);
	}
%>
</html>

