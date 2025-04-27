<!DOCTYPE html>
<html> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
 <% String message =request.getParameter("message");%>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
function callFirst()
{

	review_commprocess_refresh_form.action ='../eXI/jsp/AmendNewinterfaceItemQueryResultPage.jsp';
	review_commprocess_refresh_form.target="f_query_add_mod";
	review_commprocess_refresh_form.submit();

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY CLASS="MESSAGE" onLoad="callFirst();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="review_commprocess_refresh_form" id="review_commprocess_refresh_form">
<p align="left">
<%=message%>
</p> 
</form>
</BODY>
</html>

