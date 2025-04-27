<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<table border='0' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center'>
	 <tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'><input type='button' name='closeWindow' id='closeWindow' class="button" class='button' onclick="javascript:window.close();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'>
		</td>
	</tr>
	</table>
</BODY>
</HTML>

