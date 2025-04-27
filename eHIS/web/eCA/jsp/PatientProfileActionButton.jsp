<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
        <script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script src="../../eCA/js/PatHighRisk.js" language="javascript"></SCRIPT>

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
	<form name="frmPrint" id="frmPrint">
		<p align="right">
			<input type="button" name="btnPrint" id="btnPrint" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="funPrint();">
			<input type="button" name="btnClose" id="btnClose" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="toCloseTopShowModal();">
		</p>
	</form>

</body>

