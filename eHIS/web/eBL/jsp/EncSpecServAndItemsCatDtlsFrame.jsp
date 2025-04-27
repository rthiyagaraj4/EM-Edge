<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230228							MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eBL.*,eBL.Common.*,eCommon.Common.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%
	String params = request.getQueryString();
	System.err.println("Params in rule frame:"+params);
	String rowS = "90%, 10%";
	String facility_id = (String)session.getAttribute("facility_id");
	
%>

<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src='../../eBL/js/EncounterSpecPolicyDefnSrch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<iframe name='CategoryDtls' id='CategoryDtls'	src='EncSpecMFDRUpdDtls.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:90vh;width:100vw'></iframe>
		<iframe name='CategoryBtn' id='CategoryBtn'	src='EncSpecMFDRUpdAddBtn.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:10vh;width:100vw'></iframe> 
		
	

</HTML>

