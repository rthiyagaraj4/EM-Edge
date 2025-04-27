<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<iframe name='search_frame' id='search_frame'	src='BLChargePatientSearch.jsp?<%=params%>'  frameborder=0  style='height:41vh;width:100vw'></iframe>
		<iframe name='result_frame' id='result_frame' 	src='../../eCommon/html/blank.html' frameborder=0  style='height:55vh;width:100vw'></iframe>
		<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:0vh;width:100vw'></iframe>
</HTML>


