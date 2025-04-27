<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	\FM\File Lost-Archeived File status
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String patientid	= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
    String facility		= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
%>

<html>
<title><fmt:message key="eFM.AppointmentDetail.label" bundle="${fm_labels}"/></title>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='/eHIS/common/html/ehis.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
 <head>
<iframe name='resultFrame' id='resultFrame'  src='../../eFM/jsp/QueryFMCurrentFileStatusView.jsp?facility=	<%=facility%>&patientid=<%=patientid%>' 	scrolling='auto' frameborder=0 noresize style='height:*%;width:100vw'></iframe>
	<iframe name='closeFrame' id='closeFrame' src='../../eFM/jsp/QueryFMCurrentFileStatusViewClose.jsp' frameborder=0 scrolling='NO' noresize style='height:23%;width:100vw'></iframe>


