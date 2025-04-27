<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<body>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<table border="0" width="100%" align="center">
		<tr>
			<td width="5%" bgcolor="YELLOW" align="center">&nbsp;</td>
			<td width="95%" class="label"><fmt:message key="eST.MultipleBatchesExist.label" bundle="${st_labels}"/></td>
		</tr>
	</table>
</body>
</html>
