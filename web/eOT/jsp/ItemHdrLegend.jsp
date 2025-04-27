<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 </head>
    <body >
		<form>
			<table border="1" cellpadding=3  cellspacing="0" width="100%">
				<tr> 
					<td align='left' class='columnHeader'>
						<fmt:message key="eOT.Items.label" bundle="${ot_labels}"/>
					</td>
				</tr>
			</table>
	  </form>
   </body>
</html>

