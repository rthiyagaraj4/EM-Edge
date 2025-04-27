<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<body onLoad='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
	<form name='CusrDet' id='CusrDet' method='post' action=''>		
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>
			<td width="100%" class='button' align='right' colspan='2'><input type='button' name='close_button' id='close_button' onClick='parent.parent.document.getElementById("dialog_tag").close();' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" align='right'></td>	
		</tr>
	</table>
	</form>
	</body>

</html>



