<!DOCTYPE html>
<%
/*  							 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created

26/11/2014	IN050580		Nijitha 								MO-CRF-20080
---------------------------------------------------------------------------------------------------------------
*/
%> 
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/CANotesRefferalTracking.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table cellpadding=3 cellspacing=0 width="100%" align=center>
<tr>
	<td class=BODYCOLORFILLED align='center'><input type="button" style='display:none' class=button name='reviewNotes' id = 'reviewNotes' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Reviewed.label","ca_labels")%>" onClick="record()"></td>
	<td class=BODYCOLORFILLED align='center'><input type="button" class=button name='print' id='print' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printData()"></td>
</tr>
</table>
</body>
</html>

