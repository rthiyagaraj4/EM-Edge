<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_ok_button = request.getParameter("p_ok_button");
	//out.println(" p_ok_button"+ p_ok_button);
	if(p_ok_button==null) p_ok_button = "";
	// When OK Button is not need then parameter value will be passed as NO.
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<table border="0" cellpadding="0" cellspacing="0" width="100%" id='test'>
<tr>
	<td class="LABEL" align="left" width="10%">
		<font size='1'>
			<a href="#" onClick="showTable()">
				<img src="../../eOR/images/table.gif" title='Insert Table'></img>
			</a>
 			<a href='#' onClick='addTable()' style="visibility:hidden" id="add_table">
				<img src='../../eOR/images/AddTable.gif' title='Add Row' style="visibility:hidden" id="add_table_gif"></img>
			</a>
 			<a href='#' onClick='deleteTable()' style="visibility:hidden" id="delete_table">
				<img src='../../eOR/images/DeleteTable.gif' title='Delete Row' style="visibility:hidden" id="delete_table_gif"></img>
			</a>
			<a href="#" onClick="previewEditor()">
				<img src="../../eOR/images/print-Preview.gif" title='Preview'></img>
			</a>		
		</font>
	</td>
</tr>
</table>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
				<td width='100%' id='t'></td>
			</td>
		</tr>
	</table>
</div>

