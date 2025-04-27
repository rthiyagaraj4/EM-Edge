<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="previeworder_buttons" id="previeworder_buttons" >
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">       
	<tr>
		<td  class="white">
		<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.window.close()">
		</td>
	</tr>
	</table>
</body>
</html>


