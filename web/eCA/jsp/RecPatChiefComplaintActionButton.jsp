<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
	<head>
	<%

		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onKeyDown='lockKey()'>
	<form name='RecPatChiefComplaintActionButtonForm' id='RecPatChiefComplaintActionButtonForm'>
	<table border=0 cellpadding='3' cellspacing=0 width='75%' align='center' >
	<tr><td width='75%' colspan =3 >
		<td ><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='recordButton' class='button' onclick='apply()'></input>
		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='clearButton' class='button' onclick='Clearpage()'></input>
		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' name='cancelButton' class='button' onclick='cancel_page()'></input></td>
	</tr>
	</table>
	</form>
</body>
</html>

