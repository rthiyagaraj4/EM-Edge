<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String windowTitle 	= request.getParameter("windowTitle");
	windowTitle 		= (windowTitle  == null)?"":windowTitle ;
%>
<html>
<head>
<title><%=windowTitle%></title>
</head>
<!-- <frameset rows='*'> -->
	<!--<frame name='ser_details' id='ser_details' src='../../eOR/jsp/OrderEntryPreview.jsp' frameborder=0 noresize scrolling='auto'>-->
	<iframe name='ser_details' id='ser_details' src='../../eOR/jsp/OrderEntryPreviewTemp.jsp' frameborder=0 noresize scrolling='auto' style='height:98vh;width:100vw'></iframe>
	
<!-- </frameset> -->
</html>
<%	
	}catch(Exception e)
	{
		//out.println("Exception Preview"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181		
	}				
%>




