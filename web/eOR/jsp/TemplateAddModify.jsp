<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%

%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/OrMessages.js"></script> -->
	<script language="JavaScript" src="../js/Template.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="templateAddModifyForm" id="templateAddModifyForm">
		<table cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
				<td align="right" width="39%" class="label"> Prompt &nbsp</td>
				<td align="left" width="61%"> <input type=text name="templatePrompt" id="templatePrompt" value=""> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
			<tr>
				<td align="right" width="39%" class="label"> Row Position &nbsp</td>
				<td align="left" width="61%"> <input type=text name="templateRowPosition" id="templateRowPosition" value=""> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>

			<tr>
				<td align="right" width="39%" class="label"> Column Position &nbsp</td>
				<td align="left" width="61%"> <input type=text name="templateColumnPosition" id="templateColumnPosition" value=""> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>

			<tr>
				<td align="right" width="39%" class="label"> Column Span &nbsp</td>
				<td align="left" width="61%"> <input type=text name="templateColumnSpan" id="templateColumnSpan" value=""> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>

			<tr>
				<td align="right" width="39%" class="label"> Label Position &nbsp</td>
				<td align="left" width="61%"> 
					<select name="templateLabelSelect" id="templateLabelSelect" onchange="">
						<option selected> Left </option>
						<option> Top </option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
			<tr>
				<td align="right" width="39%"> <input type=button class=button value=" Add " onclick=""> </td>
				<td align="left" width="61%"><input type=button class=button value="Clear" onclick="javascript:clearAll()"> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
		</table>
	</form>
</body>
</html>

