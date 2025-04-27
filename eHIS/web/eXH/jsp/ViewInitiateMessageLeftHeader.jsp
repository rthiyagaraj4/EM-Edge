<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->													    
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.XHReturnArray,java.util.*,java.sql.*"%>
<head>
 <%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<BODY>																				   
<form name="view_segment_form" id="view_segment_form">
<table cellspacing=0 cellpadding=3 border=1 width='100%'  > 
<tr> 
<td colspan="3" class="COLUMNHEADER" align=center><fmt:message key="Common.query.label" bundle="${common_labels}"/></td>
</tr>
</table>
</form>
</BODY>
</html>																    							  

