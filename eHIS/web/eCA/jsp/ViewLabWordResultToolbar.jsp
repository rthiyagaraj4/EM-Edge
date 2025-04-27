<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	
<% 	
	request.setCharacterEncoding("UTF-8");	
		
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/procedures.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()' >
	<form name='tool_form' id='tool_form'>
		<table cellpadding=0 cellspacing=0 width="100%">
			    <tr>
					<td align='right'><input type='button' name='close' id='close' onclick="top.window.close()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class='button'>
					</td>
				</tr>
		</table>
	</form>
</body>
</html>

