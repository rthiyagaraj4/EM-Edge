<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>		
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script language='javascript' src='../../eCA/js/PersonalisePatListDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
	</head>
	<body onKeyDown='lockKey()'>
		<form name='PersonalisePatListToolbarForm' id='PersonalisePatListToolbarForm'>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
				<tr>
					<td align='right'>
						<input type="button" class="BUTTON" id = "Remove" name="remove" id="remove" onclick='removePatList()' value='Remove'>
						<input type="button" class="BUTTON" name="Clear" id="Clear"  value='Clear' onclick='resetPatList()'>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

