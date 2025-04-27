<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><fmt:message key="ePH.ExternalDrugSearch.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
	String params = request.getQueryString() ;
%>
<iframe name="f_external_search_criteria" id="f_external_search_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DrugMasterExtDrugSearchCriteria.jsp?<%=params%>" style="height:6vh;width:100vw"></iframe><iframe name="f_external_search_result" id="f_external_search_result" FRAMEBORDER="0" SCROLLING="no" NORESIZE  SRC="../../eCommon/html/blank.html" style="height:90vh;width:100vw"></iframe><iframe name="f_button" id="f_button" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="no" style="height:4vh;width:100vw"></iframe>
</HTML>

