<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String calling_func	=	request.getParameter("called_from");
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
<%
 if(calling_func.equals("generic_atc")) {
%>
<td align="right" class="white"> 
	<input type="button" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class="BUTTON" onClick="parent.callSelection()" disabled id="select" name="select"><input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="BUTTON" onClick="parent.parent.parent.document.getElementById('dialog_tag').close();">
</td>
<%
}
if (calling_func.equals("atc")) { 
%>
	<td align="center" class="white"> 
		<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="BUTTON" onClick="window.close();">
	</td>
<%	}	else if (calling_func.equals("generic")) { %>
	<td align="right" class="white"> 
		<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="BUTTON" onClick="window.close();">&nbsp;&nbsp;&nbsp;
	</td>
<%	}	
	else if (calling_func.equals("refill")) { %>
	<td align="right" class="white"> 
		<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="BUTTON" onClick="parent.parent.parent.document.getElementById('dialog_tag').close();">&nbsp;&nbsp;&nbsp;
	</td>
<%	}	%>
</tr>
</table>
</body>
</html>

