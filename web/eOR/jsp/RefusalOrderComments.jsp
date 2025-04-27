<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/RefusalOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<Style> </Style>
<script>
// On load it is called to put the default value .....Violated.
function doInit()
{
	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	var index 	= -1;
	if ((val != '')||("undefined" != val))index = val.indexOf("^^^");
	if (index != -1)
	{
		document.getElementById("comments").value = val.substring(0,index);
		index += "^^^".length;
		var bool = val.substring(index,val.length);
		if (bool.toUpperCase() == 'TRUE')
		{
			document.getElementById("comments").readOnly = true;
		}
		document.getElementById("comments").focus();
	}else{
		if ("undefined" == val) document.getElementById("comments").value = '';
		else document.getElementById("comments").value = val;
		document.getElementById("comments").focus();
	}

}

function doClose()
{
	
	var comments_value = document.getElementById("comments").value
	if(comments_value.length > 499)
		comments_value = comments_value.substring(0,499);
	window.returnValue = comments_value;
	window.close();
	/* let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = comments_value;

	const dialogTag = parent.document.getElementById("dialog_tag");    
	dialogTag.close();   */
}

function closeWin()
{
	if(document.getElementById("comments").value.length > 0)
	{
		var comments_value = document.getElementById("comments").value
		if(comments_value.length > 499)
			comments_value = comments_value.substring(0,499);
			window.returnValue = comments_value;
	}
	else {
		window.returnValue ='';
			/* let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = ""; */

	}
	
	window.close();
}

</script>
<title><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String comments = request.getParameter("comments");
%>
<!--<body onload="doInit()" onUnload ="closeWin()" style="background-color:#E2E3F0;">-->
<body onUnload ="closeWin()"   OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<table width="100%" border="0" cellspacing="0" cellpadding="3" align=center>
	<tr>
		<td class="label" width="10%"></td>
	</tr>
	<tr>
		<td width="90%" class="label"><textarea name="comments" id="comments" rows="5" cols="60" readonly onBlur="makeValidString(this);"  onkeyPress='return checkMaxLimit(this,500)'><%=comments %></textarea></td>
	</tr>
<td class="Button" align='right'>
 	<input type="Button" class="Button" name="Ok" id="Ok" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="doClose()"></td>
 </table>
</body>
</html>

