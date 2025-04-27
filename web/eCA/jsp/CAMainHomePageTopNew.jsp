<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null) || (session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript src='../../eCA/js/CAMainCommonTasks.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<table class='TABLECOMMON'> 
<%
	String locale		=	"";
	Properties p		= (Properties)session.getValue("jdbc");
	
	locale	= (String) p.getProperty("LOCALE");
%>
	
	<tr>
		<td class='LABELRIGHT'>&nbsp;<!--<fmt:message key="eCA.MyTaskList.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eCA.Detailsason.label" bundle="${ca_labels}"/>&nbsp;<%=com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale)%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href='javascript:refresh();'><u><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></u></A>--></td>
	</tr>
	</table> 
</form>
</BODY>
</HTML>

