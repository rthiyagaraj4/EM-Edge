<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
30-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eBL/js/BLAutoBillGenJobStatus.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.out.println("BLAutoBillGenJobStatusMain.jsp ---> " + params);
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style="height:6vh;width:100vw"></iframe>
			<iframe name='BLAutoBillGenJobStatusReport' id='BLAutoBillGenJobStatusReport' 	src='../../eBL/jsp/BLAutoBillGenJobStatusReport.jsp?' frameborder=0 scrolling='' noresize style="height:82vh;width:100vw"></iframe>
			<iframe name='BLAutoBillGenJobStatusBtn' id='BLAutoBillGenJobStatusBtn' 	src='../../eBL/jsp/BLAutoBillGenJobStatusBtn.jsp' frameborder=0 scrolling='' noresize style="height:5vh;width:100vw"></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style="height:7vh;width:100vw"></iframe>
		
</HTML>

