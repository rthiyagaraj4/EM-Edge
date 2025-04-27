<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
28-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
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
		<script language="javascript" src='../../eBL/js/BLAutoBillGen.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<iframe name='BLAutoBillGenSearch' id='BLAutoBillGenSearch'	src='BLAutoBillGenSearch.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style="height:29vh;width:100vw"></iframe>
			<iframe name='BLAutoBillGenDtls' id='BLAutoBillGenDtls' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style="height:65vh;width:100vw"></iframe>
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style="height:0vh;width:100vw"></iframe>
		
</HTML>

