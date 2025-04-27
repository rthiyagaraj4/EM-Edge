<!DOCTYPE html>
<html>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<% 
 String message =request.getParameter("message");

%>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
function callFirst()
{
	alert('<%=message%>');
	data_element_form1.action='../eXH/jsp/OfflineGatewayScheduling.jsp';
	data_element_form1.target="f_query_header";
	data_element_form1.submit();
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  onLoad="callFirst();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="data_element_form1" id="data_element_form1">
<p align="left">
</p>
</form>
</BODY>
</html>

