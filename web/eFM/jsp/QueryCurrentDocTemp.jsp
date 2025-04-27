<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String doc_folder_id = request.getParameter("doc_folder_id")==null?"":request.getParameter("doc_folder_id");
String Facility = request.getParameter("Facility")==null?"":request.getParameter("Facility");

String sql = "SELECT distinct doc_type_code from fm_encounter_doc_type_link where facility_id = ? AND doc_folder_id = ?";
String sql1 = "SELECT distinct doc_type_name from fm_doc_type where facility_id = ? AND doc_type_code = ?";
String doc_type_code = "";
String doc_type_name = "";

%>
<%
Connection con			=	null;
PreparedStatement pstmt	=	null;
ResultSet	rset		=	null;
%>
<%

if(!doc_folder_id.equals("") && !Facility.equals(""))
{
	try
	{
	con		=	ConnectionManager.getConnection(request);	
	try{		
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1, Facility);
		pstmt.setString(2, doc_folder_id);
		rset = pstmt.executeQuery();
		if ((rset != null) && (rset.next()))
		{
			doc_type_code = rset.getString("doc_type_code");			
		}
		}
		catch(Exception e)
		{
			out.println("Exception in accessing fm_encounter_doc_type_link:"+e);
		}		
		
		try{
		if(pstmt!=null) pstmt.close();			
		if(rset!=null)	rset.close();
		pstmt	=	con.prepareStatement(sql1);
		pstmt.setString(1, Facility);
		pstmt.setString(2, doc_type_code);
		rset = pstmt.executeQuery();
		if ((rset != null) && (rset.next()))
		{
			doc_type_name = rset.getString("doc_type_name");			
		}
		}
		catch(Exception e)
		{
			out.println("Exception in accessing fm_doc_type:"+e);
		}
		if(pstmt!=null) pstmt.close();			
		if(rset!=null)	rset.close();
	}catch(Exception e)
		{
		out.println("Exception ::"+e);
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
}

%>
