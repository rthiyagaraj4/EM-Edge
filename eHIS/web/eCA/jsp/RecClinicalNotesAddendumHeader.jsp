<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String txtAreaValue = request.getParameter("txtAreaValue")==null?"":request.getParameter("txtAreaValue");
	txtAreaValue = java.net.URLDecoder.decode(txtAreaValue);
%>
<html>
<head>
<title>RecClinicalNotesAddendumHeader.jsp</title>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


</script>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script>
	function callOnLoad()
	{
		document.forms[0].txtAddendum.focus();
	}
</script>
</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="callOnLoad()" class='CONTENT'>  [IN032064]-->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>  <!--  [IN032064] -->
	<form name='RecClinicalNotesAddendumHeaderForm' id='RecClinicalNotesAddendumHeaderForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
		<tr><td class='ITEMSELECT'><b><fmt:message key="eCA.AddYourAddendumBelow.label" bundle="${ca_labels}"/></b></td></tr>
		<!--
		[IN032064] Start
		<tr><td>
			<textarea name="txtAddendum" cols=105 rows=8 maxlength = 4000 onBlur = "checkMaxLimitAddendum(this,4000)" ><%=txtAreaValue%></textarea>
		</td></tr>
		[IN032064] End
		-->
		</table>
	</form>	
</body>
</html>

