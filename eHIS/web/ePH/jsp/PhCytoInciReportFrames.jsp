<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<html>
<HEAD>
<!-- 
	<LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->

<!-- <% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<iframe name='f_query_report_search' id='f_query_report_search' src="../../ePH/jsp/PhCytoInciReportCriteria.jsp"  frameborder=0 scrolling ="no" noresize style='height:30vh;width:100vw'></iframe>

<iframe name='f_query_report_result' id='f_query_report_result' src='../../eCommon/html/blank.html' frameborder=0
 noresize scrolling ="auto" style='height:70vh;width:100vw'></iframe>
</html>

