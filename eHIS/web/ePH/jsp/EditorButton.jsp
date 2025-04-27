<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
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
			<a href="#" onClick="storeEditor('Preview')">
				<img src="../../eOR/images/print-Preview.gif" title='Preview'></img>
			</a>
			<a href="#" onClick="storeEditor('Save')">
				<img src="../../eCommon/images/enabled.gif" title='OK'></img>
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
