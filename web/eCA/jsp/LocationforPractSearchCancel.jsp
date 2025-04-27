<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCA/js/LocationforPract.js" language="javascript"></script>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function closew()
{
parent.window.close();
}
</script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<div align='right'>
<table  cellpadding='3' cellspacing='0' align='center'width='100%' >
<tr>
    <td colspan=4 align=right>
	<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()' class='button'>
	</td>
</tr>
</table>
</div>
</body>
</html>


