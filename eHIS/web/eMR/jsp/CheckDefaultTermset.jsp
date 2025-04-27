<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject" contentType="text/html;charset=UTF-8" %>


<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String) session.getValue( "facility_id" ) ;
	String defaulttermset		= request.getParameter("defaulttermset")==null?"":request.getParameter("defaulttermset");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String diag_class_code		= request.getParameter("diag_class_code");
	int isDefaultAlreadyExists	= 0;
	
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	
	JSONObject json = new JSONObject();
	if(mode.equals("insert")){
		String sql = "select  count(*)  TotCount  from MR_DIAG_CLASS_DTL where TERM_SET_ID=? and DEFAULT_STATUS='Y'";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,defaulttermset);
		rs1 = pstmt.executeQuery();			
		if(rs1!=null && rs1.next()) {		 
			isDefaultAlreadyExists = rs1.getInt("TotCount");
		} 
	}else if(mode.equals("modify")){
		String sql = "select  count(*)  TotCount  from MR_DIAG_CLASS_DTL A, mr_diag_class B where TERM_SET_ID=?   AND a.diag_class_code = b.diag_class_code and A.DEFAULT_STATUS='Y' and B.DIAG_CLASS_CODE!=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,defaulttermset);
		pstmt.setString(2,diag_class_code);
		rs1 = pstmt.executeQuery();			
		if(rs1!=null && rs1.next()) {		 
			isDefaultAlreadyExists = rs1.getInt("TotCount");
		} 
	}

	if(pstmt != null) pstmt.close();
	if(rs1  != null) rs1.close();
	json.put("isDefaultAlreadyExists", isDefaultAlreadyExists);
	out.print(json);
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
