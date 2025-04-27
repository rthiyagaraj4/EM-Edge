<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
	<head>	
<% 
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

<script>
	
	function close_win()
	{
		//parent.window.close();
		/* const dialogTag = parent.parent.parent.document.getElementById('dialog_tag');    
		dialogTag.close(); */
		parent.parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.parent.document.querySelectorAll("#dialog_tag").length-1].close();
	}
</script>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<form name='pkg_dtl_btn_form' id='pkg_dtl_btn_form' method='post' action=''   >	
	<table  cellpadding='3' cellspacing='0' width='100%'>	
		<tr>
		<td class="label" width="25%">&nbsp;</td>
		<td class="label" width="25%">&nbsp;</td>
		<td class="label" width="25%">&nbsp;</td>
		<td width="25%"  class='labels'><div align="right">
		<input type='button'  name="close_button" id="close_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class='button' onClick='close_win()'></div></td>
	</tr>         
	</table> 
</form>	 
</body>
</html>

