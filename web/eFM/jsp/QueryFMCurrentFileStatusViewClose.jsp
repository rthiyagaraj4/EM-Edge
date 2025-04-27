<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>	
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <head>

 <BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>

<table align="right" >
	<tr>  
	<td class='button'><input type='button' class='button' name='close' id='close' value='Close' onClick='parent.window.close();'>
	</td>
	</tr>
</table>
</body>
</html>

