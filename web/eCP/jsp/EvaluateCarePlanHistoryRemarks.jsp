<!DOCTYPE html>
<html>
<head>
<title>Evaluation Remarks</title>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String remarks=request.getParameter("remarks");
%>
<body OnMouseDown='CodeArrest()'>
<form name='eval_cp_remarks' id='eval_cp_remarks'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr>
<td align=left class="label">&nbsp;&nbsp;&nbsp;</td>
<td align=left class="label">&nbsp;&nbsp;</td>
</tr>
<tr>
<td align=left>&nbsp;&nbsp;&nbsp;<textarea name='eval_remarks' rows='4' cols='70' value="" readonly><%=remarks%></textarea></td>
<td align=left class="label">&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td align=left class="label">&nbsp;&nbsp;&nbsp;</td>
<td align=left class="label">&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td colspan=2 align="right">
<input type=button class='button' name="close" id="close" value="Close" onclick="wincls();">&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>
</form>
</body>
</html>

