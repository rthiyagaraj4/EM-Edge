<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
<style>
TR.DISPHEADER 
{
	background-color:#D5E3E6;
    color: black;
}
TABLE.DISPHEADER 
{
    
	/*background-color:#D5E3E6;*/
    color: black;
}
</style>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name='CAMainCustomizeButton' id='CAMainCustomizeButton' action=""  method='post' >
<table cellpadding='3' cellspacing='0' width="100%" height='32px' class='DISPHEADER'>
	<tr>
		<td class="button"><input type='button' class='white' value='Update' width='25%' onclick='updateIcons()'><input type="button" class='white' name="Cancel" id="Cancel" width='25%' value=' <fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="cancelIcons()"></td>
	</tr>
</table>

</form>
</body>
<script>
	function updateIcons()
	{
		parent.frames[0].CAMainCustomizeToolbarDtl.action = "../../servlet/eCA.CAMainCustomizeToolbarServlet?<%=request.getQueryString()%>"
        parent.frames[0].CAMainCustomizeToolbarDtl.submit();
	}
	
	function cancelIcons()
	{
		//window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close(); 
			
	}
</script>

</html>

