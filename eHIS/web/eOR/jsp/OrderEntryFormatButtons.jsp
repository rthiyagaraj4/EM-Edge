<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
20/08/2015	IN056822		Ramesh G		?				?				Button OK / CANCEL are not available in Order Entry Format Item.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>

	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String orderFormatHL = request.getParameter("orderFormatHL")==null?"":(String)request.getParameter("orderFormatHL"); //IN056822 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		 <script language='javascript' src='../../eOR/js/OrderEntry1.js' ></script>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="OrderEntryFormatButtons" id="OrderEntryFormatButtons">
		<table width='100%'cellpadding=3 cellspacing=0>
			<tr>
				<td align='right'class='bodycolorfilled' >
					<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='recordOrderFormatValues()' name='ok' id='ok' disabled><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>
' onclick ='removeOrderFormatValues()' name='CANCEL' id='CANCEL' disabled> <!-- Changed disabled for ok and cancel added by selvin for Incident 27383 on 10 june 2011 & 10:48am> -->
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>
<!-- IN056822 Start. -->
<script>
if(parent.OrderFormat){	
	if('H'=='<%=orderFormatHL%>')
		parent.OrderFormat.document.location.href ='OrderEntryOrderFormat.jsp?<%=request.getQueryString()%>';
	else if('L'=='<%=orderFormatHL%>')
		parent.OrderFormat.document.location.href ='OrderEntryOrderFormatTempFrame.jsp?<%=request.getQueryString()%>';
}
</script>
<!-- IN056822 End. -->

