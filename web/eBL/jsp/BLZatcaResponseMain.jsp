<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eBL/js/BLZatcaResponse.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			System.err.println("=============BLZatcaResponseMain.jsp =============>");
			String params = request.getQueryString() ;
			System.err.println("params in BLZatcaResponseMain.jsp = "+params);
			if(params==null || params.equals("")) params="";
%>
   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0  noresize scrolling="no" style='height:6vh;width:100vw'></iframe>
   <iframe name='BLZatcaResponseSearch' id='BLZatcaResponseSearch' src='../../eBL/jsp/BLZatcaResponseSearch.jsp?<%=params%>' frameborder=0  noresize  scrolling="no" style='height:20vh;width:100vw'></iframe><iframe name='BLZatcaResponseResult' id='BLZatcaResponseResult'		src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:71vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>	  
</HTML>

