<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<script Language="JavaScript"
			src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
					String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css' />

		<script>
function doInit(){
	var val 	= window.dialogArguments;
	while(val.indexOf("~")!=-1)
		val = val.replace("~","'");
	while(val.indexOf("`")!=-1)
		val = val.replace("`","\n");

	document.getElementById("comments").value = val;
	document.getElementById("comments").focus();									   
}

function doClose(){
	this.window.returnValue = document.getElementById("comments").value;
	this.window.close();
}															    
</script>

		<%
			String title_name = request.getParameter("title_name");
			if (title_name == null || title_name == "" || title_name.equals(""))
				title_name = "";
		%>
		<title><%=title_name%>
		</title>
	</head>
	<body onload='doInit()' style='background-color:#E2E3F0;'
		onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table width='100%' border='0' cellspacing='0' cellpadding='0'
			align=center>
			<tr>
				<td align='left' class='label' width='10%'></td>
			</tr>
			<tr>
				<td align='center' width='90%' class='label'>
					&nbsp;&nbsp;
					<textarea name="comments" rows="5" cols="60" readOnly></textarea>
				</td>
			</tr>
		</table>
		<center>
			<input type='Button' class='Button' name='Ok' id='Ok' value='    Ok    '
				onclick='doClose()'>
		</center>
	</body>
</html>

