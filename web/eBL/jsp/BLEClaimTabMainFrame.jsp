<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%
		String params = request.getQueryString();
%>
<html>
<head>
</head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String validInsUser = request.getParameter("validInsUser");
		String validFrontUser = request.getParameter("validFrontUser");
		String apprvSts_AAKHYN = request.getParameter("apprvSts_AAKHYN");//V230425
		String PreAuthEclaimYN = request.getParameter("PreAuthEclaimYN");//V230814
		String function_id = request.getParameter("function_id");
		if(function_id==null || function_id.equals("")) function_id="";
		System.err.println("BLEClaimTabMainFrame.jsp, params "+params+", function_id "+function_id);
		//params="PreAuthEclaimYN= params "+PreAuthEclaimYN;
		//System.err.println("params "+params);
		
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<iframe name='search_frame' id='search_frame'	src='BLEClaimQueryCriteria.jsp?<%=params%>&validInsUser=<%=validInsUser%>&validFrontUser=<%=validFrontUser%>&apprvSts_AAKHYN=<%=apprvSts_AAKHYN%>&function_id=<%=function_id%>'   frameborder=0  style='height:30vh;width:100vw'></iframe>
		<iframe name='payer_frame' id='payer_frame' 	src='../../eCommon/html/blank.html' frameborder=0  style='height:35vh;width:100vw'></iframe>
		<iframe name='statusFrame' id='statusFrame' 	src='../../eCommon/html/blank.html' frameborder=0  style='height:35vh;width:100vw'></iframe>
</html>

