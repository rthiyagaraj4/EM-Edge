<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page import="ecommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></title>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
String longDesc = java.net.URLDecoder.decode(request.getParameter("longDesc"));
%>
<style>
textarea {
  resize: none;
}
</style>
<body onload ="document.forms[0].closeWindow.focus();" scrolling='no' onKeyDown='lockKey()'>

<form name="frmlngDescription" id="frmlngDescription">
	<center>
		<table border='0' cellpadding='0' cellspacing='0' width="100%" height='100%' align=center>
			<tr>
				<td align="center" class="label">
					<B><U><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></U></B><br><br>
					<textarea name="longDescription" rows=15 cols=58 readonly><%=longDesc%></textarea></td>
					 </tr>
					<tr>
					<td align='right' border='0'> 
					<input type="button" name="closeWindow" id="closeWindow" class="Button" onclick="parent.document.getElementById('dialog_tag').close()" value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>   ' >
				</td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>

