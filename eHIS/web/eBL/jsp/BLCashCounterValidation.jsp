<!DOCTYPE html>
<%@page import="eBL.Common.BlRepository"%>
<%@ page   import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%
java.util.Properties prop; 
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty("client_ip_address") ;	
	
String errorId =null;
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	System.err.println("1");
	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute( "login_user" ) ;
//String client_ip_address = (String)session.getAttribute("client_ip_address") ;
	System.err.println("client_ip_address"+client_ip_address);
String retValue="";
ResourceBundle rb = null;
	try{
		Locale loc = new Locale(locale);
	System.out.println("inside cash counter jsp");
		con = ConnectionManager.getConnection();
		rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		
		//system.err.println("client_ip_address"+client_ip_address);
		 String facilityId = request.getParameter("facilityId");
		 //system.err.println("facilityId"+facilityId);
		 String episodeType =  request.getParameter("episode_type");
		 System.err.println("episodeType"+episodeType);
		 
		 cstmt = con.prepareCall("{call IBAEHIS.bl_user_check_for_cash_counter(?,?,?,?,?,?,?)}");
		 cstmt.setString(1, facilityId);
		 //system.err.println("facilityId"+facilityId);
		 cstmt.setString(2, episodeType);
		 //system.err.println("facilityId"+episodeType);
		 cstmt.setString(3, login_user);
		 //system.err.println("facilityId"+login_user);
		 cstmt.setString(4, client_ip_address);
		 //system.err.println("client_ip_address"+client_ip_address);
		 
		 cstmt.registerOutParameter(5, Types.VARCHAR);
		 cstmt.registerOutParameter(6, Types.VARCHAR);
		 cstmt.registerOutParameter(7, Types.VARCHAR);
		 
		 cstmt.execute();
		 errorId = cstmt.getString(7);
	 if(errorId==null)
	 {
		 retValue= "success";
		 con.commit();
		 //system.out.println("commit");
	 }
	 else{
		 retValue=rb.getString(errorId);		 
		 con.rollback();
		 //system.out.println("rollback");
	 }
			
			
			//system.out.println("END cash counter jsp"+errorId+"-retValue-"+retValue);
			
			out.println(retValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
%>
