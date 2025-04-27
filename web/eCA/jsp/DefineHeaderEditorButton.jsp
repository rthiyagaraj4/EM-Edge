<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/DefineHeader.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name ="editorButtonForm">
	<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
	<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" id='test'>
		<tr>
		<td class="LABEL" align="left" width="10%">
			<font size='1'>
			<a href="#" onClick="">
				<img src="../../eOR/images/table.gif" title='Insert Table'></img>
			</a>
 			<a href='#' onClick='' style="visibility:hidden" id="add_table">
				<img src='../../eOR/images/AddTable.gif' title='Add Row' style="visibility:hidden" id="add_table_gif"></img>
			</a>
 			<a href='#' onClick='' style="visibility:hidden" id="delete_table">
				<img src='../../eOR/images/DeleteTable.gif' title='Delete Row' style="visibility:hidden" id="delete_table_gif"></img>
			</a>
			<a href="#" onClick="">
				<img src="../../eOR/images/print-Preview.gif" title='Preview'></img>
			</a>
			<a href="#" onClick="">
				<img src="../../eCommon/images/enabled.gif" title='OK'></img>
			</a>
			</font>
		</td>
		</tr>
		</table>
	</td>
	</tr>
	<tr>
		<td colspan="3" class='fields'>
			<textarea rows="0" cols="25" name="RTEText" style="visibility:hidden"></textarea>
		</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=request.getParameter("mode")%>">
	<input type="hidden" name="header_type" id="header_type" value="<%=request.getParameter("header_type")%>">
	<input type="hidden" name="header_id" id="header_id" value="<%=request.getParameter("header_id")%>">
	<input type="hidden" name="long_desc" id="long_desc" value="<%=request.getParameter("long_desc")%>">
	<input type="hidden" name="short_desc" id="short_desc" value="<%=request.getParameter("short_desc")%>">
	<input type="hidden" name="eff_status" id="eff_status" value="<%=request.getParameter("eff_status")%>">
</form>
</body>
</html>

