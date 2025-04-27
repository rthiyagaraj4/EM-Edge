<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String sql="";
	int resultCount = 0;
	String action = request.getParameter("ACTION") == null ? "": request.getParameter("ACTION");
	obj=new XMLStringParser();
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	if("VALIDATE_PAT_ENC".equals(action)){
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		try{
			con				=	ConnectionManager.getConnection(request);
			sql="select count(*) COUNT from PR_ENCOUNTER where patient_id = ? and encounter_id = ?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()){
				resultCount=Integer.parseInt(rs.getString("COUNT"));	
			}
			if(resultCount<=0){
				out.println("validationCheck('N','','')");
			}else{
				out.println("validationCheck('Y','"+patient_id+"','"+encounter_id+"')");
			}
		}
		catch(Exception e){
			out.println("Exception@1: "+e);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
					
	} else{
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String p_report_id = (String)hash.get("p_report_id");
		Clob clobData = null;
		try{
			con				=	ConnectionManager.getConnection(request);
			sql="select SIGNATURE from CA_PAT_INSU_SIGNATURE where patient_id = ? and encounter_id = ? and report_id = ? ";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			pstmt.setString(3, p_report_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				clobData = rs.getClob("SIGNATURE");
				String wholeClob = clobData.getSubString(1, (int) clobData.length());
				out.println("testView('"+wholeClob+"')");
			}
		}
		catch(Exception e){
			out.println("Exception@1: "+e);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
%>
