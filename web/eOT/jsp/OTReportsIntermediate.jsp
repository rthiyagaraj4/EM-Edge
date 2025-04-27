<!DOCTYPE html>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript">
function callReportPage()
{
	document.OTReportsInterForm.submit();
}

</script>
<%
String params = request.getParameter("reportParams");
String temp_param="";
String temp_name="";
String temp_value="";
int i=0;
%>
<html>
<body>
<form name="OTReportsInterForm" id="OTReportsInterForm" action="../../eCommon/jsp/report_options.jsp">
<%
	StringTokenizer st = new StringTokenizer(params,"#");
	while (st.hasMoreTokens()) {
		temp_param=st.nextToken();
		temp_param=temp_param.trim();
		temp_value=request.getParameter(temp_param).trim();
		//System.out.println("temp_param  "+temp_param);
		//System.out.println("temp_value  "+temp_value);
		out.println("<input type='hidden' name='"+temp_param+"' id='"+temp_param+"' value='"+temp_value+"'>");
}
%>
</form>
</body>
</html>

<script>
callReportPage();
</script>

