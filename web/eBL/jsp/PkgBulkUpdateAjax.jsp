<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page is used to communicate with Database for Ajax Calls--%>
<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
request.setCharacterEncoding("UTF-8");
String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
try {
	
	String locale			= (String)session.getAttribute("LOCALE");
	String userId = (String)session.getAttribute("login_user");
	String facilityId		= (String) session.getValue( "facility_id" );
	System.err.println(func_mode);
	 if("chkPkgUpdAccess".equals(func_mode)){
		 PkgPriceDisountBC priceDiscBC = new PkgPriceDisountBC();
		 String access = priceDiscBC.checkBulkUpdateAccess(userId, facilityId);
		 out.println(access);
	 }
}
catch (Exception e) {
	System.err.println("Exception from PkgBulkUpdateAjax :"+e);
}
%>
