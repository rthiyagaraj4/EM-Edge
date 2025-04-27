<!DOCTYPE html>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.json.simple.JSONObject"%>  

 
<%
   	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
   			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
   			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

   	Connection con = null;
   	PreparedStatement pstmt = null;
   	Statement stmt = null;
   	ResultSet rs = null;

   	try {

   		String facilityid = (String) session.getValue("facility_id");
   		if (facilityid == null)
   			facilityid = "";
   		con = ConnectionManager.getConnection(request);
   		String patClassQry = BlRepository.getBlKeyValue("GET_PAT_CLASS");
   		String blngClassCode = request.getParameter("blngClassCode");
   		String patClass = "";
   		//System.out.println("blngClassCode >>>>><<<<<< "+blngClassCode);

   		pstmt = con.prepareStatement(patClassQry);
   		pstmt.setString(1, blngClassCode);

   		rs = pstmt.executeQuery();

   		if (rs != null) {
   			while (rs.next()) {
   				patClass = rs.getString(1);
   				out.println(patClass);
   			}
   		}
   		if (rs != null)
   			rs.close();
   		pstmt.close();

   	} catch (Exception e) {
   		System.out
   				.println("Exception in PkgSubscriptionPatClassFinderAjax"
   						+ e);
   	} finally {
   		if (con != null)
   			ConnectionManager.returnConnection(con, request);
   	}
   %>












