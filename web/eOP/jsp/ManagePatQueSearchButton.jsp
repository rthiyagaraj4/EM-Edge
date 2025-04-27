<!DOCTYPE html>
<!--
This file was developed by venkatesh.S on 04/Feb/2013 against Bru-HIMS-CRF-179 [IN030297]
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*" %>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
	<script  language='javascript' src="../../eXH/js/ExternalApplication.js"></script>
<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 End-->
<script language='javascript' src='../../eOP/js/ManageSPatQueue.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

         <html>
		<head>
		</head>
		<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='WaitListMgmtForm' id='WaitListMgmtForm' >
		<table name='waitMgmtTable1' id='waitMgmtTable1'  width="-10px" align='right' cellpadding='0' cellspacing='0' border='0'>

			<tr>	
<td class='button'><input type='button' class='Button' name="refresh" id="refresh" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="refresh_records()">&nbsp;<input type='button' class='Button' name="cleardata" id="cleardata" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearfields()"></td>
		</tr>
	</table>
		</form>
		</body>
		</html>

			

