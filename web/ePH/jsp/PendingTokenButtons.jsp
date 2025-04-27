<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8 "  %>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="token_buttons" id="token_buttons" >
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">       
	<tr>
		<td class="white" width="93%"  ></td>
		<td class="white"  >
		<input type="button" tabIndex = "0" class="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick="window.close()">
		</td>
	</tr>
	</table>
</body>
<SCRIPT>
document.token_buttons.btnOK.focus();
</SCRIPT>
</html>

