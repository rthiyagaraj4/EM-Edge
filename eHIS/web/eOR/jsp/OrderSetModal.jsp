<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
04/09/2017	IN065021		Dinesh T		04/09/2017		Ramesh G		Unable to update comments
------------------------------------------------------------------------------------------------------------------------------
*/

%>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html> 
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

<script>
function doInit(){

	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	var index 	= -1;
	if ((val != '')||("undefined" != val))
		document.getElementById("Cmts").value = val ; 
	
}

function doClose()	
{
	window.returnValue = document.getElementById("Cmts").value;	
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
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
	if(document.getElementById("Cmts").value.length > 0) {
		window.returnValue = document.getElementById("Cmts").value;
	}else
	window.returnValue ='';	
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function chkLength(Obj,len)
{
	if(Obj.value.length > parseInt(len))
	{
		alert('APP-SM0045-Comments Text cannot exceed '+len+' characters ');
		Obj.focus();
	}

}
</script>



<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>

</head>
<body onload='' onUnload ='closeWin()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<!--  style='background-color:#E2E3F0;'  -->
<%

String msgTxt = request.getParameter("currCmntsTxt");
String detailPageMode= request.getParameter("detailPageMode");
String eff_status= request.getParameter("eff_status");
String l_dis_comments = request.getParameter("dis_comments")==null?"":request.getParameter("dis_comments");//IN065021
String l_called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
String valid = request.getParameter("valid")==null?"":request.getParameter("valid");

if(msgTxt == null || msgTxt.equals("null")) msgTxt =" "; else msgTxt = msgTxt.trim();
if(detailPageMode == null || detailPageMode.equals("null")) detailPageMode =" "; else detailPageMode = detailPageMode.trim();
if(eff_status == null || eff_status.equals("null")) eff_status =""; else eff_status = eff_status.trim();


//String strReadOnly = "";//IN065021
String l_str_disabled = "";//IN065021

//IN065021, starts
/*if((!detailPageMode.equalsIgnoreCase("A") && !msgTxt.trim().equalsIgnoreCase("")) || eff_status.equalsIgnoreCase("D") ){
	strReadOnly = "readOnly";
}*/

if(("orderset_by_dosage_type_dtl_form".equals(l_called_from) || "orderset_dosage_age_dtl_form".equals(l_called_from)) && "Y".equals(valid))
{
	l_str_disabled = "disabled";
}

if(l_dis_comments.equals("Y"))
{
	l_str_disabled = "disabled";
}
//IN065021, ends	
%>

<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>

	<tr><td class='label'></td></tr>

	<tr>
		<!--<td  class='label'><textarea name="Cmts" rows="5" cols="58" onkeypress="checkMaxLimit(this,255)" onBlur="chkLength(this,500);"><%=msgTxt%></textarea></td> --><!--strReadOnly has been removed--><!--IN065021-->
		<td  class='label'><textarea name="Cmts" id="Cmts" rows="5" cols="58" onkeypress="checkMaxLimit(this,255)" <%=l_str_disabled%> onBlur="chkLength(this,500);"><%=msgTxt%></textarea></td><!--IN065021-->
	</tr>
<tr><td class='Button'><input type='Button' class='Button' name='OK' id='OK' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='doClose()'></td></tr>	
</table>
</body>
</html>

