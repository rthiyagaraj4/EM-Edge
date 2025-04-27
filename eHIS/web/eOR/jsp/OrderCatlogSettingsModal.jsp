<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<style>
		textarea {
		  	resize: none;
		}
	</style>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function doInit(){

	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	var index 	= -1;
	if ((val != '')||("undefined" != val))
		document.getElementById("msg").value = val ; 
	
}

function doClose()	
{
	/* window.returnValue = document.getElementById("msg").value;
	window.close(); */
	console.log(document.getElementById("msg").value);
	parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=document.getElementById("msg").value;
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();	
}

function checkMaxLimit(obj,maxSize)	
{
	if ( obj.value.length >= maxSize )
	{
		event.returnValue = false;
	}
}

function closeWin()
{
	if(document.getElementById("msg").value.length > 0) {
		 /* window.returnValue = document.getElementById("msg").value; */
		 let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = document.getElementById("msg").value;
	}else{
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = '';
		const dialogTag = parent.document.getElementById('dialog_tag');    
		dialogTag.close();
	}
	 /* window.returnValue ='';
	window.close();  */
		/* let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = '';
	const dialogTag = parent.document.getElementById('dialog_tag');    
	dialogTag.close(); */
}

function chkLength(Obj,len)
{
	if(Obj.value.length > parseInt(len))
	{
		alert('The number of characters cannot exceed '+len);
		Obj.focus();
	}

}
</script>



<title><fmt:message key="eOR.PromptMessage.label" bundle="${or_labels}"/></title>

</head>
<body onload='' onUnload ='closeWin()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"
><!-- style='background-color:#E2E3F0;' -->

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String msgTxt = request.getParameter("currMsgTxt");
// System.out.println("@@@currMsgTxt : "+msgTxt);
String module_id				= 	request.getParameter("module_id");	
if(msgTxt == null) msgTxt = "";


String strReadOnly = "";

if(!module_id.equalsIgnoreCase("OR") && !msgTxt.trim().equalsIgnoreCase("")){
	strReadOnly = "readOnly";
}

%>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>

	<tr><td  class='label' width='10%'></td></tr>

	<tr>
	<td  width='90%' class='label'><textarea name="msg" id="msg" rows="5" cols="60" onkeypress="checkMaxLimit(this,255)" <%=strReadOnly%>      onBlur="chkLength(this,255);makeValidString(this);" ><%=msgTxt%></textarea></td>
	</tr>

</table>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
<tr><td width='100%' align="right"><input type='Button' class='Button' name='OK' id='OK' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'></td></tr>	
</table>
</body>
</html>

