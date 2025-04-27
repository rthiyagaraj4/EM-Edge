<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			
			String facility_id = (String)session.getAttribute("facility_id");

%>
	<iframe name='BLDischargeClearCancelCriteria' id='BLDischargeClearCancelCriteria' src='../../eBL/jsp/BLDischClearCancelQuery.jsp' frameborder=1 noresize scrolling="no" style='height:20vh;width:100vw'></iframe> 			
		<iframe name='BLDischargeClearCancelResult' id='BLDischargeClearCancelResult' src='../../eCommon/html/blank.html' frameborder=1 noresize style='height:75vh;width:100vw'></iframe>
		<iframe name='BLDischargeClearCancelBtn' id='BLDischargeClearCancelBtn' src='../../eCommon/html/blank.html' frameborder=1 noresize scrolling="no" style='height:5vh;width:100vw'></iframe>
</HTML>

