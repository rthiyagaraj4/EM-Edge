<!DOCTYPE html>
<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>

	function doClose()	
	{
		//window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
</script>
</head>
<body onKeyDown='lockKey()'>
<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
<tr>
	<td align='right'><input type='Button' class='Button' name='Ok' id='Ok' value='    Close    ' onclick='doClose()' ></td>
</tr>
</table>
</body>
</html>

