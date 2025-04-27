<!DOCTYPE html>

<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String from				= request.getParameter("from");

	
	if(from==null) from		= "1";
	String to				= request.getParameter("to");
	if(to==null) to			= "7";
	String check_box_name	= request.getParameter("check_box_name");
	if(check_box_name==null) check_box_name = "";
	String form_name		= request.getParameter("form_name");
	
	if(form_name==null) form_name = "";
	String total_size		= "";
	
	//if(from==null || from.equals("1"))
		total_size			= request.getParameter("total_size");
	if(total_size==null) total_size = "0";

	int start				= Integer.parseInt(from);
	int end					= Integer.parseInt(to);
	int total_records		= Integer.parseInt(total_size);
	
	

//out.println("from"+from);
//out.println("start"+start);
//out.println("end"+end);
//out.println("total_records"+total_records);
%>
<%--<table border="0" cellpadding="0" cellspacing="0" width="100%" id='result_scroll'>--%>
<div align='right'>
	<%--<table align='right'>
		<tr>
			<td> --%>

			<% 
				if ( !(start <= 1) )  
		  			out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-7)+"', '"+(end-7)+"', '"+check_box_name+"', '"+form_name+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");
 				if( !( (start+7) > total_records)) 
 					out.println("<A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+7)+"', '"+(end+7)+"', '"+check_box_name+"','"+form_name+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

				out.println("&nbsp;&nbsp;");
			%>

		<%--	</td>
		</tr>
	</table>--%>
</div>
<%--</table>--%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

