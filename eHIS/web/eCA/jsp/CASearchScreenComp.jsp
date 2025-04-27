<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sex=request.getParameter("Sex")==null?"":request.getParameter("Sex");
String dob=request.getParameter("Dob")==null?"":request.getParameter("Dob");
String p_code_indicator=request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");

%>
	<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 	<script>
		 	function closew()
			  {
			  	  window.parent.parent.returnValue=document.forms[0].elements(2).value
				  window.parent.parent.close();
  			}
			function checkForValidDiagCode()
			{

				//alert('<%=sex%>' +' ' + '<%=dob%>');
				var HTMLVal = "<html><body onKeyDown='lockKey()'>";
				HTMLVal += "<form name = 'CheckValidDiagForm' method='post' action = '../../eCA/jsp/ValidatePatProblemDiagCode.jsp'>";
				HTMLVal += "<input type='hidden' name = 'diag_code' value='" + document.forms[0].cde.value + "'>";
				HTMLVal += "<input type='hidden' name = 'diag_scheme' value='" + document.forms[0].diag_scheme.value + "'>";
				HTMLVal += "<input type='hidden' name = 'Dob' value='<%=dob%>'>";
				HTMLVal += "<input type='hidden' name = 'Sex' value='<%=sex%>'>";
				HTMLVal += "<input type='hidden' name = 'p_code_indicator' value='<%=p_code_indicator%>'>";
				HTMLVal += "</form></body>";
				HTMLVal += "</html>";
				//alert(HTMLVal);
				window.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				window.parent.messageFrame.document.CheckValidDiagForm.submit();
			}
		 	</script>
	</head>	
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=0 cellpadding=0 width='100%' id='t'  border=0 name='t' id='t'>
		<tr>
		<form name=f>
			<td width='50%'>
				<input type='text' name='diagcode' id='diagcode' size=100>
			</td>
			<td align='right'>
				<input type='button' name='select' id='select'  class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick='<%=((sex.equals("")||dob.equals(""))?"closew()":"checkForValidDiagCode()")%>'  disabled  >
			</td>
			<input type='hidden' name='cde' id='cde'  >
			<input type='hidden' name='diag_scheme' id='diag_scheme'  >
		</form>
	</table>
	</body>	
	
</html>

