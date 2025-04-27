<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>

<%
	request.setCharacterEncoding("UTF-8");
	String sex=request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String dob=request.getParameter("Dob")==null?"":request.getParameter("Dob");
%>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 	<script>
		 	function closew()
			  {
			  	  window.parent.parent.returnValue=document.forms[0].elements(2).value
				  window.parent.parent.close();
  			}
			function checkForValidDiagCode()
			{
				var HTMLVal = "<html><body onKeyDown='lockKey()'>";
				HTMLVal += "<form name = 'CheckValidDiagForm' method='post' action = '../../eCA/jsp/ValidatePatProblemDiagCode.jsp'>";
				HTMLVal += "<input type='hidden' name = 'diag_code' value='" + document.forms[0].cde.value + "'>";
				HTMLVal += "<input type='hidden' name = 'diag_scheme' value='" + document.forms[0].diag_scheme.value + "'>";
				HTMLVal += "<input type='hidden' name = 'Dob' value='<%=dob%>'>";
				HTMLVal += "<input type='hidden' name = 'Sex' value='<%=sex%>'>";
				HTMLVal += "</form></body>";
				HTMLVal += "</html>";
				window.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				window.parent.messageFrame.document.CheckValidDiagForm.submit();
			}
		 	</script>
	</head>	
	
	<body onKeyDown='lockKey()'>
		<table cellspacing=0 cellpadding=0 width='100%' id='t'  border=0 name='t' id='t'>
		<tr>
		<form name=f>
			<td width='50%'>
				<input type='text' name='diagcode' id='diagcode' size=100>
			</td>
			<td class='button'>
				<input type='button' name='select' id='select'  class='button' value='Select' onClick='<%=((sex.equals("")||dob.equals(""))?"closew()":"checkForValidDiagCode()")%>'  disabled  >
			</td>
			<input type='hidden' name='cde' id='cde'  >
			<input type='hidden' name='diag_scheme' id='diag_scheme'  >
		</form>
	</table>
	</body>	
	
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

