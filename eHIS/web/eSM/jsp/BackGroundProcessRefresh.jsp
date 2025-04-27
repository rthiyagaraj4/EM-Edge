<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%
	      request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script>
		function Refreshme()
		{
			parent.frames[0].location.reload();
			parent.frames[2].location.href='BackGroundProcessAddModify.jsp';
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";}
		</script>
	</head> 
	<body onKeyDown = 'lockKey()'>
	<table border=0 cellspacing=0 cellpadding=0 align=right>
		<tr><td class=BODYCOLORFILLED><input type=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>' class=button onclick='Refreshme()'>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
	</table>
	</body>
</html>



