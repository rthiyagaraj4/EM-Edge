<!DOCTYPE html>
 <!-- 
Developed by    : P.Sudhakaran.
Module/Function : Drug Item Link
-->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<title><fmt:message key="ePH.DrugItemLink.label" bundle="${ph_labels}"/></title>
    <%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/DrugItemLink.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="f_tab" id="f_tab" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DrugItemLinkTab.jsp" style="height:3vh;width:100vw"></iframe><iframe name="f_query_add_mod_criteria" id="f_query_add_mod_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source=matching_record" style="height:15vh;width:100vw"></iframe><iframe name="f_query_add_mod_result" id="f_query_add_mod_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:76vh;width:100vw"></iframe><iframe name="f_query_add_mod_legend" id="f_query_add_mod_legend" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DrugItemLinkLegend.jsp?source=close" style="height:6vh;width:100vw"></iframe>
</html>


