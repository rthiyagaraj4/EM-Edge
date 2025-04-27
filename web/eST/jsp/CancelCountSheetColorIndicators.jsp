<!DOCTYPE html>
<html>
<body>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<table border="0" width="100%" align="center">
		<tr>
			<td width="25%" bgcolor="" align="center"><font color="Blue">Not Updated</font></td>
			<td width="25%" bgcolor="RED" align="center"><font color="white">No Batch Details</font></td>
			<td width="25%" bgcolor="ORANGE" align="center"><font color="white">Partially Updated</font></td>
			<td width="25%" bgcolor="GREEN" align="center"><font color="white">Fully Updated</font></td>
		</tr>
	</table>
</body>
</html>
