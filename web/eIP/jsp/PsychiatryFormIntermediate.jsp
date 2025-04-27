<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn			=null;
	conn					=ConnectionManager.getConnection(request);
	PreparedStatement pstmt =null;
	ResultSet rs			=null;

try{
	
	String action	=	request.getParameter("action")==null?"":request.getParameter("action");

	if(action.equals("fetchPsychiatryForm"))
	{
		String splty_code	= request.getParameter("splcode");
		String pfResults	=  "";
		pfResults			= eIP.IPCommonBean.getPsychiatryForm(conn, splty_code);
		JSONArray pfArray	= new JSONArray(pfResults);
		out.println(pfArray);
	}

if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}catch(Exception e) { 
	e.printStackTrace();
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%> 
