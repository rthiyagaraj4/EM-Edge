<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/PhRepPrintCompPrescription.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<% 

	String patient_id	=	request.getParameter("patient_id");	
	if(patient_id!=null){ 
	%>
	<title><fmt:message key="ePH.Prescription.label" bundle="${ph_labels}"/></title>
	<%	}	%>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	String rows			=	"";

	if(patient_id==null){
		rows	=	"42,95,*,17,50";
	}
	else {
		rows	=	"0,*,17";
	}
	
%>
<frameset rows="<%=rows%>">
<% if(patient_id==null) { %>
	<frame name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>">
<% } %>
	<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhRepPrintCompPrescriptionQueryCriteria.jsp?patient_id=<%=patient_id%>">
	<frame name="f_query_results" id="f_query_results" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
	<frame name="f_query_status" id="f_query_status" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">
	<frame name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>
</html>

