<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<!--
Developed by    :Karabi Sarma
Module/Function : Drug Information Enquiry ( Transctions)
-->
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
 String mode=(String)CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
if(mode==null) mode="";

%>

<iframe name='f_query_criteria_search' id='f_query_criteria_search' src="../../ePH/jsp/PhCytoInciReportCriteria.jsp?mode=<%=mode%>"
  frameborder=0 scrolling ="no" noresize style='height:30vh;width:100vw'></iframe>

<iframe name='f_query_report_result' id='f_query_report_result' src='../../eCommon/html/blank.html' frameborder=0
 noresize scrolling ="auto" style='height:70vh;width:100vw'></iframe>
</html>

