<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>


</head>
<!-- <body topmargin="0"> -->
<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
<table border="0" cellpadding="0" cellspacing="0" width="99%" align="center" id="bottom_tb">
<tr>
<td id="msg" class="white" style="color:red" align="left" width="55%">&nbsp;</td>
<td id="page_links" class="white"  align="left" width="45%">&nbsp;</td>
</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="99%" align="center" id="bottom_tb">
<tr>
<td id="curr_page" class="white" align="left" width="18%" style="display:none"><b><fmt:message key="ePH.CurrentPageNo.label" bundle="${ph_labels}"/>:</b></td>
<td id="curr_pageno" class="white"  align="left" width="10%" style="display:none"><b>&nbsp;1</b></td> 
<td align="right"  class="white" width="72%">
	<input type="button" class="BUTTON" name="record" id="record" value="Record" onClick="javascript:parent.navigation(parent.f_atcmodify_all.document.ATCClassification_ModifyAll,'record')"><input type="reset" class="BUTTON" name="reset" id="reset"  value="Reset" onClick="parent.clickHiddenButton()"><input type="button" class="BUTTON" name="cancel" id="cancel" value="Cancel" onClick="parent.callClose()">
	</td> 
</tr>
</table>
</body>
</html>

