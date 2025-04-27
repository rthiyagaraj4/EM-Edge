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
		String validInsUser = request.getParameter("validInsUser");
		String validFrontUser = request.getParameter("validFrontUser");
		String apprvSts_AAKHYN = request.getParameter("apprvSts_AAKHYN");//V230425
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<iframe name='search_frame' id='search_frame'	src='BLApprStatusTrackSearch.jsp?<%=params%>&validInsUser=<%=validInsUser%>&validFrontUser=<%=validFrontUser%>&apprvSts_AAKHYN=<%=apprvSts_AAKHYN%>'   frameborder=0  style="height:30vh;width:100vw"></iframe>
		<iframe name='result_frame' id='result_frame' 	src='../../eCommon/html/blank.html' frameborder=0  style="height:60vh;width:100vw"></iframe>
		<iframe name='statusFrame' id='statusFrame' 	src='../../eCommon/html/blank.html' frameborder=0  style="height:30vh;width:100vw"></iframe>
		<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize  style="height:0vh;width:100vw"></iframe>
</HTML>

