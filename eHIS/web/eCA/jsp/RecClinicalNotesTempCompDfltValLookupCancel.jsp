<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  class='CONTENT' onKeyDown="lockKey()">
<form>
<table cellpadding='3' cellspacing='0' border='1' width='100%' align ='center'>
	<tr>
		<td width='105%' colspan='4' align ='right' ><input type='button' name='closeBtn' id='closeBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeWin()' class='button'></td>
	</tr>
</table>			
</form>
</BODY>
</HTML>

