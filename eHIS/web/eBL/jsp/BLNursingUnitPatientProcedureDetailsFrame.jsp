<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%
		String params = request.getQueryString();
//		System.err.println("params in BLNursingUnitPatientProcedureDetailsFrame:"+params);
%>
<TITLE>
Procedure Details
</TITLE>
<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
		<iframe name='BLNursingUnitPatientProcedureDetailsFrame' id='BLNursingUnitPatientProcedureDetailsFrame'	src='../../eCA/jsp/ProcedureList.jsp?<%=params%>'  frameborder=0 scrolling='no'style="height:95vh;width:100vw" noresize></iframe>
		
</HTML>

