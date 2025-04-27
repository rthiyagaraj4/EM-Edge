<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%

//HttpSession httpSession = request.getSession(false);
//Properties p = (Properties)httpSession.getValue("jdbc");
String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";
//java.util.Locale loc = new java.util.Locale(locale);
//java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
String strTitle="";
//strTitle=(String) bl_labels.getString("eBL.PRV_ENCOUNTER_FIN_DETAILS.label");
strTitle=request.getParameter("title");
if(strTitle==null) strTitle="";

%>
<HTML>
<head>
   <title>
        <%=strTitle%>
   </title>
</head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
		String params = request.getQueryString();
//		System.out.println("params:"+params);
%>

	  <iframe name='' id=''	src='../../eBL/jsp/BLPreviousEncounterDtls.jsp?<%=params%>'  frameborder=0 noresize scrolling='auto' style='height:46vh;width:99vw'></iframe>
			<iframe name='' id=''	src='../../eBL/jsp/BLPreviousPatFinDtls.jsp?<%=params%>'  frameborder=0 noresize scrolling='auto' style='height:33vh;width:99vw'></iframe>
			<iframe SRC="../../eBL/jsp/BLPreviousEncounterBtn.jsp"	  name="" id="" frameborder=0 noresize scrolling='no' style='height:8vh;width:99vw'></iframe>
			<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:99vw'></iframe>
	   	
</HTML>

