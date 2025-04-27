<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------
08/06/2020	IN073001		Ramesh Goli		08/06/2020		Ramesh G			PMG2019-GHL-CRF-0003.2
-------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

Connection con=null;
PreparedStatement pstmt=null;

String locale 		= "";
try {
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale 	= (String) p.getProperty("LOCALE");		
	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;	
	String request_num = request.getParameter("request_num")==null?"": request.getParameter("request_num");
	String request_line_num = request.getParameter("request_line_num")==null?"": request.getParameter("request_line_num");
	String facility_id = request.getParameter("facility_id")==null?"": request.getParameter("facility_id");
	String updatedValue = request.getParameter("updatedValue")==null?"": request.getParameter("updatedValue");
	pstmt = con.prepareStatement("UPDATE RD_EXAM_VIEW_REQUESTED SET CA_NOTE_UPDATE_YN = ? WHERE OPERATING_FACILITY_ID= ? AND REQUEST_NUM = ? AND REQUEST_LINE_NUM = ? ");
	pstmt.setString(1, updatedValue);
	pstmt.setString(2, facility_id);
	pstmt.setString(3, request_num);
	pstmt.setString(4, request_line_num);	
	pstmt.executeUpdate() ;
	con.commit();	
	if(pstmt!=null)pstmt.close();		
	
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 
%>
