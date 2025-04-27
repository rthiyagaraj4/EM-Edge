<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29412     Dinesh T    AMS CRF
-----------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MOHE-SCF-0153
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><fmt:message key="eCA.ViewPatientListbyLocation.label" bundle="${ca_labels}"/></title>
</head>
<%  String locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType"); 

	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
	String ql_ref=request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	String default_yn=request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
%>
		<iframe name='PatCriteriaFr' id='PatCriteriaFr'		src='../../eCA/jsp/PatListByLocationCriteria.jsp?locationType=<%=locationType%>&Summary=<%=Summary%>&ql_ref=<%=ql_ref%>&default_yn=<%=default_yn%>'   frameborder=0 scrolling='auto'  noresize style='height:28vh;width:99vw'></iframe>
		<iframe name='PatResultFr' id='PatResultFr'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:99vw'></iframe>
		<iframe name='colorRefframe' id='colorRefframe' src='../../eCA/jsp/CAPatColorReference.jsp' frameborder=1 scrolling='yes' noresize marginheight=0 marginwidth=0  class='normal' style='height:8vh;width:99vw'></iframe>
		<iframe name='ByLocationLookUp' id='ByLocationLookUp' src='../../eCommon/html/blank.html' frameborder=1 scrolling='no' noresize marginheight=0 marginwidth=0  class='normal' style='height:0vh;width:99vw'></iframe>
		
</html>

