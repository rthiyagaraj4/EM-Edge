<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
	<tr>
		<td >
			<input type="button" align="left" name='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' value="Search" class="button" >
			<input type="Reset" align="left"  value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button">
			<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closew()' class='button'>
		</td>
	</tr>
</table>
</div>
</body>
</html>


