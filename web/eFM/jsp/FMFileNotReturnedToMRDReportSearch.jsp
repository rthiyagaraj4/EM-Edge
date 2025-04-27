<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	24/06/2001
	 Module Name 	   :	FM\File Code report
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.*"  contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src="../../eFM/js/FMFileNotReturnedToMRD.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="ReportSearch" id="ReportSearch" action="" method="post" target="messageFrame">
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code');" onKeyDown = 'lockKey();'>
<BR>
<div align="left">
<table border="0" cellpadding="0" cellspacing="0"  align='center'>
<tr>
	  <td width='10%' >&nbsp;</td>
      <td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
      <td class='fields'><select name="code" id="code" onChange="codeCheck(this.value);" >
	   <option value=' ' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------</option>
	   <option value='D' ><fmt:message key="Common.ByDate.label" bundle="${common_labels}"/></option>
	   <option value='F' ><fmt:message key="eFM.CurrentFSLocationIdentity.label" bundle="${fm_labels}"/></option>
	   </select></td>
	   <td width='10%' >&nbsp;</td></tr>
 </tr>
</table>
</div>
</form>
</body>
 </html>

