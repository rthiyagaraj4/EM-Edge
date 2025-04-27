
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ShiftRows.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/js/CommonMessages.js"></script> -->
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCA/js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
		String curr_value = request.getParameter("curr_row_num");
	%>
		<form name='dsaf' id='dsaf' onSubmit="return false">
			<table cellpadding='3' cellspacing='0' border='0' align='center' width='100%'>
			<br>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class='label'>
					<fmt:message key="eCA.ShiftthisRowby.label" bundle="${ca_labels}"/>&nbsp;
					<input type='text' name="shift_by" id="shift_by" value="" size='1' maxlength='1' onKeyPress="return allow_Valid_Number(this,event,1,4);">
					<img src='../../eCommon/images/mandatory.gif'></img>&nbsp;(1-9)
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td > 
					<input type='button' class='button' name='forward' id='forward' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")%>" onClick='subForm(this)'>&nbsp;
					<input type='button' class='button' name='backward' id='backward' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Backward.label","ca_labels")%>" onClick='subForm(this)'>&nbsp;
					<input type='button' class='button' name='cancel' id='cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='CloseWin()'>
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			</table>
			<input type='hidden' name='curr_value' id='curr_value' value="<%=curr_value%>">
		</form>
	</body>
</html>

