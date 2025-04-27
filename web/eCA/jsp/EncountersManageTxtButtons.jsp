<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script language='javascript' src='../../eCA/js/Encounters.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->
		
		
	</head>
	<body onKeyDown="lockKey()">
		<form name='encManageTxtBtnForm' id='encManageTxtBtnForm'>
			<table width='100%'>
				<tr>
					<td class='gridNumericData' align='right'>
						<input type='button' class='button' name='CloseBtn' id='CloseBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeManageWin();' align='right'></input>
					</td>
				</tr>
			</table>	
			<input type='hidden' name='forRetValue' id='forRetValue' value=''>
		</form>
	</body>
</html>

