<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*" %>
<HTML>
<HEAD>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%!
	String p_module_id		= "RS" ;
	String p_report_id		= "RSBGRADE" ;
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../js/repGradeList.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repGradeList" id="form_repGradeList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
<th align='left'> Report Criteria
</th>
<tr>
<td width="100%" class="Border" align='center'>
<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
<tr>
<td align="left" width="35%">&nbsp;</td>
<td class="label"  align="left"  width="20%">From</td>
<td class="label" align="left"  width="40%">To</td>
</tr>
<tr>
<td align="right" class="label" width="20%">Grade &nbsp;</td>
<td  width="30%">
<input type=text  name='from_grade_desc' id='from_grade_desc' value="" size="4" maxlength="4" onblur="searchGrade(from_grade_desc)"><input type='button' name='grade1' id='grade1' value='?' class='button' onclick="searchGrade(from_grade_desc)"><input type="hidden" name="from_grade_code" id="from_grade_code" value="">
</td>
<td width="50%">
<input type=text  name='to_grade_desc' id='to_grade_desc' value="" size="4" maxlength="4" onblur="searchGrade(to_grade_desc)"><input type='button' name='grade2' id='grade2' value='?' class='button' onclick='searchGrade(to_grade_desc)'><input type="hidden" name="to_grade_code" id="to_grade_code" value="">
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td align='right' width='30%'  class="label">Nature &nbsp; </td>
<td width='20%' align="left">
<select name='p_nature' id='p_nature'>
<option value="B">Both
<option value="E">Enabled
<option value="D">Disabled
</select>
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td align="right" width='30%' class="label">
Order By &nbsp;
</td>
<td width='20%' align="left">
<select name='p_order_by' id='p_order_by'>
<option value='1'>Grade Code
<option value='2'>Grade Desc
</select>
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=session.getValue("facility_id")%>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=session.getValue("login_user")%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id %>">
</form>
</body>
</html>

