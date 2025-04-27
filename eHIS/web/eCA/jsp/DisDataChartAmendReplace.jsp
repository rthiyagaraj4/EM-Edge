<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCA/js/DisDataCharting.js'></SCRIPT>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<title> Select </title>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form>
<div align=center>
<br>
<table width='80%' height='50%' cellpadding=0 cellspacing=0 border=0 align=center>
<tr>
	<td class=label align=right>
		<input type=radio id="amRe" name="amdRep" id="amdRep" value='A' checked><fmt:message key="eCA.MarkedforError.label" bundle="${ca_labels}"/>&nbsp;&nbsp;
	</td>
	<td class=label>
		&nbsp;&nbsp;<input type=radio id="amRe1" name="amdRep" id="amdRep" value='R'><fmt:message key="Common.Replace.label" bundle="${common_labels}"/>
	</td>
</tr>
</table><br><br>
	<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='returnVal()'>&nbsp;&nbsp;
		&nbsp;&nbsp;<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick='returnValCan()' >

</div>
</form>
</body>
</html>

