<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
	/*
	----------------------------------------------------------------------------------------------------------------
	 Date       Edit History   	Name       	Rev.Date   	Rev.By    	Description
	----------------------------------------------------------------------------------------------------------------
	?          	100           	?          	?			? 			created
	28/05/2015	IN052230		Karthi L							Order Management-Missing specimens-Dispatch Slip	 
	10/01/2018  IN061893		Kamalakannan G  10/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	-----------------------------------------------------------------------------------------------------------------
	 */
%>
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
	if(to==null) to			= "7";
	String check_box_name	= request.getParameter("check_box_name");
	if(check_box_name==null) check_box_name = "";
	String form_name		= request.getParameter("form_name");
	 /*Added by kishore kumar N on 30-Oct-09  for CRF 15741*/
	String qryString		= request.getParameter("qryString")==null?"":request.getParameter("qryString");
	String option			= request.getParameter("option")==null?"":request.getParameter("option"); //IN052230
	if (qryString.indexOf("&from") != -1)
	{
		qryString = qryString.substring(0, qryString.indexOf("&from"));
	}
	/*ends here.*/
	if(form_name==null) form_name = "";
	String total_size		= "";
	
	//if(from==null || from.equals("1"))
		total_size			= request.getParameter("total_size");
	if(total_size==null) total_size = "0";
	int limitTo	= Integer.parseInt(request.getParameter("limitTo")==null||"".equals(request.getParameter("limitTo"))?"7":request.getParameter("limitTo"));//IN061893

	int start				= Integer.parseInt(from);
	int end					= Integer.parseInt(to);
	int total_records		= Integer.parseInt(total_size);
	
	//System.out.println("from"+from+"=="+"to"+to);
	//System.out.println("start"+start+"=="+"end"+end);

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

			<% // IN052230 - Start
				if(option.equalsIgnoreCase("S")){
					if ( !(start <= 1) )  
			  			out.println("<A class='gridLink' HREF=\"javascript:displayDispatchSlipRecords('"+(start-7)+"', '"+(end-7)+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");
	 				if( !( (start+7) > total_records)) 
	 					out.println("<A  class='gridLink' HREF=\"javascript:displayDispatchSlipRecords('"+(start+7)+"', '"+(end+7)+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				}
				else { //IN052230 - End
					if ( !(start <= 1) )  
			  			//out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-7)+"', '"+(end-7)+"', '"+check_box_name+"', '"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");commented for IN061893
						out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-limitTo)+"', '"+(end-limitTo)+"', '"+check_box_name+"', '"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");// added for IN061893
	 				if( !( (start+7) > total_records)) 
	 					//out.println("<A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+7)+"', '"+(end+7)+"', '"+check_box_name+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");commented for IN061893
					out.println("<A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+limitTo)+"', '"+(end+limitTo)+"', '"+check_box_name+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");// added for IN061893
				} //IN052230 
				out.println("&nbsp;&nbsp;");
			%>

		<%--	</td>
		</tr>
	</table>--%>
</div>
<%--</table>--%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

