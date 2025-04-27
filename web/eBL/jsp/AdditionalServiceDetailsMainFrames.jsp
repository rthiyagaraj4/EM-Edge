<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		//String params = request.getQueryString();//checklist
%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
	<iframe name='additionalServiceDetailsSearch' id='additionalServiceDetailsSearch' src='AdditionalServiceDetailsSearch.jsp'  frameborder=0 scrolling='no' noresize style='height:27vh;width:98vw'></iframe>
	<iframe name='progressFrame' id='progressFrame' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize style='height:0vh;width:98vw'></iframe> 
	<iframe name='additionalServicePriceDetailsTraverse' id='additionalServicePriceDetailsTraverse' src='../../eCommon/html/blank.html'  frameborder=0  scrolling='no' noresize style='height:6vh;width:98vw'></iframe> 
	<iframe name='additionalServicePriceDetails' id='additionalServicePriceDetails' src='../../eCommon/html/blank.html' frameborder=0  noresize  style='height:30vh;width:98vw'></iframe>
	<iframe name='additionalServiceDiscountDetails' id='additionalServiceDiscountDetails' src='../../eCommon/html/blank.html' frameborder=0  noresize  style='height:23vh;width:98vw'></iframe>
	<iframe name='additionalServiceDiscountDetailsAdd' id='additionalServiceDiscountDetailsAdd' src='../../eCommon/html/blank.html' frameborder=0  noresize  style='height:5vh;width:98vw'></iframe>
</HTML>

