<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eBL/js/BLDischClear.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='BLDischClearTabs' id='BLDischClearTabs' src='../../eBL/jsp/BLDischClearTab.jsp' frameborder=1  noresize scrolling="no" style='height:4vh;width:100vw'></iframe>
	<iframe name='BLDischClearBody' id='BLDischClearBody' src='../../eCommon/html/blank.html' frameborder=1 noresize scrolling="no" style='height:96vh;width:100vw'></iframe>
</HTML>

