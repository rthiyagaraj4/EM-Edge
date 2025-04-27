<!DOCTYPE html>
<%   
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           	created
27/12/2012    IN035950      Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
											more appealing. Keeping the display of information more clear and visible.					
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 	request.setCharacterEncoding("UTF-8");	
session.removeValue("allStyles");
%>
