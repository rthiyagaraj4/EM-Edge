<!DOCTYPE html>
<!-- Same taken from (eHIS/OP/jsp)  Revise Visit Function from OP Module -->
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MOInternalReport.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0'  width='100%' align='center'>
			<tr>
				  <td  class='COMMON_TOOLBAR' align ='left'  ><input type='button' name='Home' id='Home' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels")%>' onClick='window.close()'  class='button'></td>
			</tr>
</table>
</div>
</body>
</html>


