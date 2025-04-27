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
	String facilityId = (String) session.getValue("facility_id");
	String errorId =null;
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	//system.err.println("1");
	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute( "login_user" ) ;
//	String client_ip_address = (String)session.getAttribute("client_ip_address") ;
	//system.err.println("client_ip_address"+client_ip_address);
String retValue="";
ResourceBundle rb = null;
	try{
		Locale loc = new Locale(locale);
		
		con = ConnectionManager.getConnection();
		rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		 //String facilityId = request.getParameter("facilityId");
		// System.err.println("facilityId"+facilityId);
		 String patientId =  request.getParameter("patientId");
		 pstmt = con.prepareStatement("Select IBAEHIS.bl_bill_settlement_proc.get_outstanding_yn(?,?) outst from dual ");
		 pstmt.setString(1, facilityId);
		 pstmt.setString(2, patientId);
		   rst = pstmt.executeQuery();
		   if(rst != null && rst.next()){
			   retValue = rst.getString("outst");
		   }
		    
		    
		    out.println(retValue);
		    System.err.println("retValue"+retValue);
		    con.commit();
	}
		   catch (SQLException e) {
			
			e.printStackTrace();
		}
	finally{
		ConnectionManager.returnConnection(con);
	}
		 %>   
