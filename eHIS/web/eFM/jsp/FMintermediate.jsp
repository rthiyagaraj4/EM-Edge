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
	
	String action			=	request.getParameter("action")==null?"":request.getParameter("action");
	String facilityID		=   (String)session.getAttribute("facility_id");
	
	if(action.equals("fetchCurrFsLocn")){
		String patientId			= request.getParameter("patientId");
		String LangId			    = request.getParameter("LangId");
		String fmCurrLocnResults	=  "";

		fmCurrLocnResults			= eFM.FMFileTransferBean.currentFileFSLocation(conn, patientId, LangId);
		JSONObject fmCurrLocnObj	= new JSONObject(fmCurrLocnResults);

		out.println(fmCurrLocnObj);

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
            
            
