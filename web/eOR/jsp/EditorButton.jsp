<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/9/2011	  IN27550		Dinesh T	 Changed the lines to solve the preview window issue which goes																	 behind the editor screen in the refusal in the Record Refusal																	 function
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
---------------------------------------------------------------------------------------------------------------
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String p_ok_button = request.getParameter("p_ok_button");
	//out.println(" p_ok_button"+ p_ok_button);
	if(p_ok_button==null) p_ok_button = "";
	// When OK Button is not need then parameter value will be passed as NO.

%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
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
		<%  if(p_ok_button.equals("")) { %>
			<a href="#" onClick="storeEditor()">
				<img src="../../eCommon/images/enabled.gif" title='OK'></img>
			</a>
		 <% } %> 
		</font>
	</td>
</tr>
</table>
<!--IN27550,starts-->
<script>
if(top.opener) //Added Condition Chowminya to handle top.opener.document is null error,IN29559
{
	if(top.opener.document.getElementById("refusal_text"))
	{
		top.opener.document.getElementById("refusal_text").innerHTML="<a class='gridLink' href='javascript:showRefusalDesc()'>"+getLabel("eOR.RefusalText.label","OR")+"</a>";
	}
}
</script>
<!--IN27550,ends-->
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
				<td width='100%' id='t'></td>
			</td>
		</tr>
	</table>
</div>

