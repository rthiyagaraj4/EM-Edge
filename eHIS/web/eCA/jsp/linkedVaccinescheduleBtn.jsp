<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
 <SCRIPT LANGUAGE="JavaScript">
 <!--
	function returnSelectedVal()
	{
		var val = parent.linkVaccinationFrame.document.getElementById("selectedChkValue").value;		
		var retVal;
		if(val != '')
		{	
			retVal = val.split("`~");			
			window.returnValue = retVal;
		}		
		window.close();
	}
 //-->
 </SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=color_form >
<table width='25%' align='right'>
		<tr>				
			<td ><input type='button' name='btnOk' id='btnOk' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='returnSelectedVal()'>&nbsp;&nbsp;<input type='button' onclick='window.close();' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'></td>
		</tr>
</table>
</form>
</body>
</html>

