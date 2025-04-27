<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<!-- <title>
		Long Description
	</title> -->

 <%
 request.setCharacterEncoding("UTF-8");

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
String longDesc = java.net.URLDecoder.decode(request.getParameter("longDesc"));
String calledFrom = request.getParameter("calledFrom")==null ? "" : request.getParameter("calledFrom");
if(calledFrom.equals("charting"))
{
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</title>");
}
else
{
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</title>");
}

%>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload ="document.forms[0].closeWindow.focus();" scroll=no >

<form name="frmlngDescription" id="frmlngDescription">
	<center>
		<table border='1' cellpadding='0' cellspacing='0' width="100%" height='100%' align=center>
			<tr>
				<td align="center" class="label">
					<%if(!calledFrom.equals("charting")){%>
					<B><U><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></U></B><br><br>
					<%
						}
						else
						{
							out.println("<B><U>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</U></B><br><br>");	
						}
					%>
					<textarea name="longDescription" rows=14 cols=40 readonly><%=longDesc%></textarea><br>
					<input type="button" name="closeWindow" id="closeWindow" class="button" onclick="javascript:window.close();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'>
				</td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>

