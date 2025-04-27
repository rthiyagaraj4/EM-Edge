<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/PhRepFormdd7.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<% 
	String patient_id	=	request.getParameter("patient_id");	
	if(patient_id!=null){ 
	%>
	<title><fmt:message key="Common.Prescription.label" bundle="${common_labels}"/></title>
	<%	}	%>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	String rows			=	"";

	if(patient_id==null){
		rows	=	"42,115,*,17,50";
       
	}
	else {
		rows	=	"0,*,17";
	}
	
%>

<% if(patient_id==null) { %>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<% } %>
	<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no"  src="../../ePH/jsp/PhRepFormdd7Criteria.jsp?patient_id=<%=patient_id%>" style="height:22vh;width:100vw"></iframe>
	<iframe name="f_query_results" id="f_query_results" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:58vh;width:100vw"></iframe>
	<iframe name="f_query_status" id="f_query_status" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

</html>

