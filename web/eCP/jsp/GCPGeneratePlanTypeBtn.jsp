<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head> 
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
  	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

String preview = (String)request.getParameter("preview")== null ? "" :request.getParameter("preview") ;
String show_back = (String)request.getParameter("show_back")== null ? "" :request.getParameter("show_back") ;
String shw_nothing = (String)request.getParameter("shw_nothing")== null ? "" :request.getParameter("shw_nothing") ;
String fm_name  = (String)request.getParameter("fm_name")== null ? "" :request.getParameter("fm_name") ;

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%if(shw_nothing.equals("Nothing")){%>

<form name='<%=fm_name%>' id='<%=fm_name%>' target='messageFrame' >

</form>

<%}else{%>
<form name='generate_buttn' id='generate_buttn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<%if(preview.equals("true")){%>
	 <tr>
		<td  class='label' align=right>
		<%if(show_back.equals("summary") ){%>
		<input type="button" title='Standard Care Plan' value='<fmt:message key="eCP.Prev.label" bundle="${cp_labels}"/>' class='button' onClick='showPrevious("summary")'>
		&nbsp;&nbsp;
		<input type="button" title='Plan Detail' value='<fmt:message key="eCP.Nex.label" bundle="${cp_labels}"/>' class='button' onClick='callDetailScreen()' >
		&nbsp;&nbsp;&nbsp;&nbsp;
		
		<%}else if(show_back.equals("library")){%>
		<input type="button" title='Plan Summary' value='<fmt:message key="eCP.Prev.label" bundle="${cp_labels}"/>' class='button' onClick='showPrevious("library")'>
		&nbsp;&nbsp;
		<input type="button" title='Record Plan' value='<fmt:message key="eCP.RecordPlan.label" bundle="${cp_labels}"/>' class='button' onClick='PreviewRecord()' >
		&nbsp;&nbsp;&nbsp;
		
		<%}else{%>
		<input type="button" title='Diagnosis/Case Type' value='<fmt:message key="eCP.Prev.label" bundle="${cp_labels}"/>' class='button' onClick='showPrevious("show_lib")'>
		&nbsp;&nbsp;
		<input type="button" title='Plan Summary' value='<fmt:message key="eCP.Nex.label" bundle="${cp_labels}"/>' class='button' onClick='callSummaryScreen()'>
		&nbsp;&nbsp;
		<input type="button" title='Finalize' value='<fmt:message key="Common.Finalize.label" bundle="${common_labels}"/>' class='button' onClick='FinalizePlan()'>
		&nbsp;&nbsp;
		<%}%>
		</td>
	</tr> 
	<%}else {%>
	<tr>
		<td  class='label' align=right>
		<input type="button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='LibClear()'>
		&nbsp;&nbsp;
		<input type="button" title='Standard Care Plan' value='<fmt:message key="eCP.Nex.label" bundle="${cp_labels}"/>' class='button' onClick='showLibrary("")'>&nbsp;&nbsp;&nbsp;&nbsp; 
		</td>
	</tr> 
	<%}%>
</table>

</form>
<%}%>
</body>
</html>

