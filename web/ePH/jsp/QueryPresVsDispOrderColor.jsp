<!DOCTYPE html>
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
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/QueryDispLocnDrugs.js"></script> 
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- added for 28251-->
</head>              
<!-- <body topmargin="0"> -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<TABLE cellspacing="0" cellpadding="0" width="100%" align="center" valign="bottom" border="1">
<br>
<TR>

<td class="white" width="10%" align='center' style='background-color:#CC9933;' >   
		<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="ePH.PartiallyDispensed.label" bundle="${ph_labels}"/></b></label></td>

<td class="white" width="10%" align='center' style='background-color:#990000;' >   
		<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="ePH.FullyDispensed.label" bundle="${ph_labels}"/></b></label></td>
<td class="white" width="10%" align='center' style='background-color:#FF0000;' >   
		<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></b></label></td>
<td class="white" width="10%" align='center' style='background-color:green;' >   
		<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="ePH.InProcess.label" bundle="${ph_labels}"/></b></label></td>
		
</TR>
</TABLE>
</body>
</html>

