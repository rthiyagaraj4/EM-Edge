<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> --> 
	
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>                               

<%
	String source =  "../../ePH/jsp/QueryPatientsBySpecificDrugCriteria.jsp" ;
%>

<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:29vh;width:100vw"></iframe><iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:63vh;width:100vw"></iframe><iframe name="f_query_status" id="f_query_status" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:5vh;width:100vw"></iframe>
</html>

