<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String from				= request.getParameter("from");

	
	if(from==null) from		= "1";
	String to				= request.getParameter("to");
	if(to==null) to			= "30";
	String check_box_name	= request.getParameter("check_box_name");
	if(check_box_name==null) check_box_name = "";
	String form_name		= request.getParameter("form_name");
	String called_from				= request.getParameter("called_from");
	String order_category				= request.getParameter("order_category");
	String qryString		= request.getParameter("qryString")==null?"":request.getParameter("qryString");
	//qryString = qryString+"&called_from="+called_from+"&order_category="+order_category;	
	System.out.println("18 ResultScrollingSingleContinuous.jsp qryString============"+qryString);
	if (qryString.indexOf("&from") != -1)
	{
		qryString = qryString.substring(0, qryString.indexOf("&from"));
	}
	
	if(form_name==null) form_name = "";
	String total_size		= "";
	
	total_size			= request.getParameter("total_size");
	if(total_size==null) total_size = "0";

	int start				= Integer.parseInt(from);
	int end					= Integer.parseInt(to);
	int total_records		= Integer.parseInt(total_size);
	
	%>

<div align='right'>
	

			<% 
				if ( !(start <= 1) )  
		  			out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-30)+"', '"+(end-30)+"', '"+check_box_name+"', '"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A> ");
 				if( !( (start+30) > total_records)) 
 					out.println(" <A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+30)+"', '"+(end+30)+"', '"+check_box_name+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

				out.println("&nbsp;&nbsp;");
			%>

		
</div>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

