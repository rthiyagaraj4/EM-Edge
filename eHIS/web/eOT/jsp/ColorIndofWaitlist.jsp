<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<style>

		TD.label1{
		BACKGROUND-COLOR:RED;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

</style>         
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='waitlistcsh' id='waitlistcsh'>
<table cellpadding="3" cellspacing="0" width="20%" align="left" border="0">
<tr>
<td  class='label1' width='13%' color='red'>&nbsp;
</td>
<td class='white' nowrap>
		<label nowrap style="font-size:14;font-weight:normal">
		<fmt:message key="eOT.WaitlistWarning.Label" bundle="${ot_labels}"/>
		</label>
</td>
</tr>
</table>
</form>
</body>
<html>

