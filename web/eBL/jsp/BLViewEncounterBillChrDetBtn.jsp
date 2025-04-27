<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<script>
	function close_window()
	{
			//parent.window.close();
			const dialogTag = parent.parent.document.getElementById('dialog_tag');    
			dialogTag.close();
	}
	 
	 
</script>

	
<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	<FORM name='' id='' action="" method='post'>
	  <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	    <TR>

		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>
		<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class='button' onClick='close_window()'></td>
		
</TR>
</TABLE>
</BODY>
</FORM>
</HTML>

