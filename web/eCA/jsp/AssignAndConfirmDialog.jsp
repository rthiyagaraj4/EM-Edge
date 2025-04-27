<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date      	 	  Edit History      Name      					Description
--------------------------------------------------------------------------------------------------------------
?           	  	100           		?         		  			created
02/04/2015		  	IN048704	 		Nijitha S					HSA-CRF-0175	
13/04/2015			IN054965			Nijitha						HSA-CRF-0175
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<title>
		Assign and Confirm
	</title>
</head>
<script>
	function selectAssignOrConfirm(obj)
	{
		document.getElementById("assignorConfirmKey").value=obj.value;
	}
	function confirmationOk()
	{
		returnValue = document.getElementById('assignorConfirmKey').value;
		window.close();
		return returnValue;
	}

	function confirmationCancel()
	{
		window.close();
	}
</script>
	<body>
		<form name='assignAndConfirmForm' id='assignAndConfirmForm'>
			<table width='100%' >
				<tr style='display id='assignAndConfirmHdrRow'>
					<td class='label' align='center'>
						<%=	MessageManager.getMessage(localeName,"PAT_ASSIGN_CONFIRM","CA").get("message")%>
					</td>
				</tr>
				
				<tr id='assignAndConfirmRow'>
					<td class='label'>
						<input type='radio' id = 'assignAndConfirm' name='assignAndConfirm' id='assignAndConfirm' value = 'AC' checked onclick='selectAssignOrConfirm(this)'/><fmt:message key="eCA.assignandconfirmdiag.label" bundle="${ca_labels}"/></br>
						<input type='radio' id = 'assignAndConfirm' name='assignAndConfirm' id='assignAndConfirm' value = 'A' onclick='selectAssignOrConfirm(this)'/><fmt:message key="eCA.assigndiag.label" bundle="${ca_labels}"/>
					</td>
					
				<tr id='okCancelRow'>
					
					<td align='right'>
						<input class='button'  type='button' name = 'confirmYes' value='Ok'  onclick='confirmationOk()'/>
						<input class='button'  type='button' name = 'confirmNo' value='Cancel'  onclick='confirmationCancel()'/>
					</td>
				</tr>
			</table>
		<input name='assignorConfirmKey' id='assignorConfirmKey' type='hidden' value=''/>
		</form>
		<script>
			document.getElementById("assignorConfirmKey").value='AC';
		</script>
	</body>
</html>

