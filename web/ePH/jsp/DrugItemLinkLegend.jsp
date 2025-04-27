<!DOCTYPE html>
 <!-- 
Developed by	: P.Sudhakaran.
Module/Function : Drug Item Link (Master)
-->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<%
String source=request.getParameter("source");

%> 

<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/DrugItemLink.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	
<%
	if(source!=null && source.equals("matchingRecord")){
%>
	<tr><td colspan="4" class="LEGEND">&nbsp;</td></tr>
	<tr><td width="30%" class="LEGEND"><font color="#CC3300"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></font></td><td width="20%" class="LEGEND"><font color="#6666CC"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></font></td><td width="30%" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class="button" onclick="Apply();">&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onclick="parent.window.close()" width="40%"></td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
<%
}else if(source!=null && source.equals("close")){
%>
	<tr><td colspan="4" class="LEGEND">&nbsp;</td></tr>
	<tr><td width="30%"></td><td width="20%"></td><td width="30%"  class="LEGEND">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onclick="parent.window.close()" width="40%" >&nbsp;&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="LEGEND">&nbsp;&nbsp;</td></tr>
<%
}else{
%>
	<tr><td colspan="4" class="label">&nbsp;</td></tr>
	<tr><td width="30%" class="LEGEND"><font color="#CC3300"><fmt:message key="ePH.InverntoryDescription.label" bundle="${ph_labels}"/></font></td><td width="20%" class="LEGEND"><font color="#6666CC"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></font></td><td width="30%"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onclick="parent.window.close()" width="40%" >&nbsp;&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="label">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="label">&nbsp;&nbsp;</td></tr>
	<tr><td colspan="4" class="label">&nbsp;&nbsp;</td></tr>
<%
}
%>
</table>
</body>
</html>

