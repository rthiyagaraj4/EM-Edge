<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
---------------------------------------------------------------------------------------------------------------
*/
%>

<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>                                
	<head>                                
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>                               
<%
	
	String params=request.getQueryString();
	String source =  "../../ePH/jsp/MedicationReconciliationTabs.jsp?"+params;
	String rowsSize = "20%,*";
%>

	
		<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="<%=source%>"style="height:20vh;width:100vw"></iframe>
		<iframe name="f_query_result1" id="f_query_result1" frameborder="0" scrolling="yes" noresize src="../../eCommon/html/blank.html"style="height:80vh;width:100vw"></iframe>						
	
</html>

