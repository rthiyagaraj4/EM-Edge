<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eOH/js/PeriodontalChart.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="equipment_form" id="equipment_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.OperationTypesServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td class=label align=right>
		<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/>
	</td>
	<td align=left>
		<input type="text" name="oper_type" id="oper_type" value="" size=4 maxlength=4  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label align=right>
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class=field>
		<input type="text" name="long_desc" id="long_desc" value=""  size=30 maxlength=30 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label align=right>
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td align=field><input type="text" name="short_desc" id="short_desc" value=""   size='15' maxlength='15' >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label align=right>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td  class=field>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='' >
	</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%//=mode%>'>
<input type=hidden name=oper_type1 value="">
<input type=hidden name=long_desc1 value="">
<input type=hidden name=short_desc1 value="">
<input type='hidden' name='locale' id='locale' value="">
</form>
</body>
</html>


