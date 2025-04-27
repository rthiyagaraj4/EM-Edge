<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.* " %>

<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<html>
<head>
<%
	
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
 <script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
 <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<!-- <BODY> -->
<body> 
<TABLE cellpadding="2" cellspacing="0" width="100%"  align="center" border="1">
<tr>
<td align="right"style="BACKGROUND-COLOR:#FFFFCC">   
<a href="javascript:DefaultOverrideReasonForAll();" title="Deafult OverrideReason"><fmt:message key="ePH.DefaultOverrideReasonForAll.label" bundle="${ph_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="button" type="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="returnoverridereason('OK');">
<input class="button" type="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="returnoverridereason('CANCEL');">
</td>
</tr>
</table>
</BODY>
</HTML>

