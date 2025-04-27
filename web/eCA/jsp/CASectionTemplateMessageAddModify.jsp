<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
30/09/2013	IN043577		Vijayakumar K		Alpha-CA-by entering special Characters at Hint message in Section template getting Internal Server Error 
15/04/2014	IN048161		Chowminya			Special character is not allowed in the prompt field of the section template	
28/05/2015	IN054269		Vijayakumar K		28/05/2015	Dinesh T	GHL-SCF-894 [IN:054269] 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCA/js/SectionTemplate.js"></script>
		<script language="Javascript" src="../../eCA/js/CASectionTemplateMessage.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<style>
textarea {
  resize: none;
}
</style>
	<body onKeyDown="lockKey()">
	<form name="CASectionTemplateMessageAddModifyForm" id="CASectionTemplateMessageAddModifyForm" method='post' action='../../servlet/eCA.CASectionTemplateMessageServlet'>
	<table  border='0' width='100%' cellpadding='3' cellspacing='0' align='center' >
	<%
	String message_val = "";
	String comp_id = request.getParameter("comp_id") == null?"":request.getParameter("comp_id");
	String section_code = request.getParameter("section_code") == null?"":request.getParameter("section_code");
	String label_type = request.getParameter("label_type") == null?"":request.getParameter("label_type");
	%>
	<tr>
		<td class='label' width='20%'><fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
		<td class='fields' width='50%'>
		<!-- IN043577 starts reverted for IN048161-->
		<!-- IN054269 starts -->
		<!--<textarea name='MessageVal' value="" rows="2" maxlength="100" cols="40" onkeyPress="return CheckForSpecCharsNoCaps(event);" onchange='charTextarea(this,100)' onkeyup='chopText(this,100)' onblur='chekForQuotes(this)'> <% //=java.net.URLDecoder.decode(message_val)%></textarea>-->
		<textarea name='MessageVal' id='MessageVal' value="" rows="2" maxlength="100" cols="40" onkeyPress="return CheckForSpecCharsNoCaps(event);" onchange='charTextarea(this,100)' onkeyup='chopText(this,100)' onblur='chekForQuotes(this)'><%=java.net.URLDecoder.decode(message_val)%></textarea>
		<!-- IN054269 ends -->
		<!--<textarea name='MessageVal' value="" rows="2" maxlength="100" cols="40" onkeyPress="return CheckForSpecialCharactersOnKeyPress(event);" onchange='charTextarea(this,100)' onkeyup='chopText(this,100)' onblur='chekForQuotes(this);CheckForSpecialCharactersOnBlur(this);'> <%=java.net.URLDecoder.decode(message_val)%></textarea> -->
		<!-- IN043577 ends -->
		</td>
		<td colspan=2></td>	
	</tr>
	<tr>
		<td colspan=3></td>	
		<td  width='25%' align='right'>
		<input type='button'  name='record' id='record' onclick='RecordVal()' class='BUTTON' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"><input type='button'  name='clear' id='clear' onclick="clearform()" class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
		</td>
</tr>
</table>
<input type='hidden' name='comp_id' id='comp_id' value="<%=comp_id%>">
<input type='hidden' name='section_code' id='section_code' value="<%=section_code%>">
<input type='hidden' name='label_type' id='label_type' value="<%=label_type%>">
<input type='hidden' name='label_desc' id='label_desc' value="">


</form>
</body>
</html>

