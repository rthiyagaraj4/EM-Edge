<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
 <%@page contentType="text/html; charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PrescriptionTest.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<table border="0" width="100%" height="90%" cellspacing="0" cellpadding="0" >
 <tr><td width="35%" class="white"> 
  <table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0" >
		<tr valign="TOP" ><td class="white" width="10%"><b><font size="3" color="#53BC50"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></font></b></td><td class="white" width="10%"></td><td class="white" width="10%"></td></tr>
  </table>
</td>
<td width="65%" class="white"> 
</td>
</tr>
 </table>
<div name="rxtiplayer" id="rxtiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="rxtiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
<tr><td width="100%" id="t"></td></tr>
</table>
</div>
</body>
</form>
</html>


