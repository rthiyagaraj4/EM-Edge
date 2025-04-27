<!DOCTYPE html>

<html>

<%@page import="eBT.*"  contentType="text/html; charset=UTF-8"%>
<head>

<%	request.setCharacterEncoding("UTF-8");	%>


<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='label' align='right'> 		
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='window.close()'>&nbsp;
		</td>
	</tr>
</table>
</form>
</body>
</html>

