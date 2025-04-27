<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<head>

<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<%
		String params = request.getQueryString();
//		System.out.println("params:"+params);
		String function_name=request.getParameter("function_name");
	%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?function_name=<%=function_name%>&<%=java.net.URLEncoder.encode(params,"UTF-8")%>  frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
 <iframe name='charge_det_main' id='charge_det_main' 	src='BLChargeDtlMenuFrame.jsp' frameborder=0  scrolling='no' noresize style='height:275vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>


