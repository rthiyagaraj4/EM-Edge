<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<%  request.setCharacterEncoding("UTF-8"); %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script>
function CloseWindow() {
	 const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	    dialogTag.close();   
}</script>

<html>
<title></title>
	<head>
	</head>
	<body onKeyDown='lockKey()'>
		<form name='buttonform' id='buttonform'>
		<table cellpadding='0' cellspacing='0' border='0' width='100%'  align=center>
			<tr>
				<td class='button' align="right">
					<input type='button' class='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='CloseWindow();'>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
 
<!--

//-->
</script>
