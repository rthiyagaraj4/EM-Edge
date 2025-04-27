<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		//patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
	<center>
	<form name='IPConsultationListToolbarForm' id='IPConsultationListToolbarForm'  method=post>
	<p align='left'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
			<tr>
			<td class='label' width='25%'>&nbsp;</td> <td class='label' width='25%' ><b>Total</b></td><td class='label' width='25%'><input type='text' size=10 maxlength='10' name='' id='' onblur =""><input type='text' size=10 maxlength='10' name='' id='' onblur =""><input type='text' size=10 maxlength='10' name='' id='' onblur =""></td> <td class='fields' width='25%'></td>
			</tr>
			<tr>
				<td class='label' width='25%'></td><td class='label' width='25%'></td><td class='label' width='25%'></td>
				<td class='label' width='25%' align='right'>
					<input type='BUTTON' class='BUTTON' name='Modify' id='Modify' value='Modify' onClick="modify();" style="display" >
					<input type='BUTTON' class='BUTTON' name='Accept' id='Accept' id value='Accept' onClick="AcceptCharge(this);" style="display" >
					<input type='BUTTON' class='BUTTON' name='Cancel' id='Cancel' id value='Cancel' onClick="closeChargeWin();" style="display" >
										
				</td>
			</tr>
		</table>
	</p>
	</form>
	</center>
</body>
</html>

