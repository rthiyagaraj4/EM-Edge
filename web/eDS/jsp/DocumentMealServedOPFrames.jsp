<!DOCTYPE html>
<!--
File Name		: DocumentMealServedOPHeader.jsp
File Description: Document Main/Outer frame: This is to document/acknowledge the placed order .
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script>

//Function : Lauching the Document Page: 
function create()
{
	Docquery_add_mod.location.href='../../eDS/jsp/DocumentMealServedOPHeader.jsp';
}

//Function : For documenting the updated records: 
function apply()
{  
	if( Docquery_add_mod.document.forms[0] == null )
		this.location.reload();
	else
		Docquery_add_mod.apply();
}

//Function : For Showing the Success Message in Message Frame: 
function onSuccess(){	
//parent.f_query_add_mod.location.reload();
	var formObj =document.forms[0];
	var params = formObj.params.value;
	Docresult_add_mod.location.href='../../eCommon/html/blank.html';
	Docquery_add_mod.location.href='../../eDS/jsp/DocumentMealServedOPHeader.jsp';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DS_OPER_COMPLETE","DS");//'Operation Completed Sucessfully';
}

function reset()
{
	Docresult_add_mod.location.href='../../eCommon/html/blank.html';
	Docquery_add_mod.location.href='../../eDS/jsp/DocumentMealServedOPHeader.jsp';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
}
</script>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name='Docquery_add_mod' id='Docquery_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no" style="height:30vh;width:100vw"></iframe>
<iframe name='Docresult_add_mod' id='Docresult_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:55vh;width:100vw'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="no" style="height:9vh;width:100vw"></iframe>

<form name="DocumentMealServedOPForm" id="DocumentMealServedOPForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
</form>

</html>

