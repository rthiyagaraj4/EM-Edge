<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page  contentType="text/html;charset=UTF-8"  language="java" import ="java.sql.*, webbeans.eCommon.*,eCommon.Common.*,java.util.HashMap ,java.net.*,java.util.*"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>	
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCP/js/PositionForIntervention.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function ChangeType(form,target)
{
	var role_type=target.value;
    if(role_type=="role_type")
		document.forms[0].role_type.value='';
	removeitems(form.staff_type);
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'>";
	HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eCP/jsp/PositionForInterventionIntermediate.jsp'>";
	HTMLVal = HTMLVal +"<input name='role_type' id='role_type' type='hidden' value= '"+role_type +"'>";
	HTMLVal = HTMLVal +"</form></BODY></HTML>";
	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.forms[0].submit();
}
function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}
</script>
</head>	
<body  onload='FocusFirstElement()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod>
<table border='0' cellpadding='8' cellspacing='0' align='center' width="98%">
<tr>
	<td align="right" class="label" width="25%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/> &nbsp</td>
	<td align="left">
		<select name='role_type' id='role_type'  onChange='ChangeType(this.form,this)'>
			<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
		</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td>	
	</td>	
	<td>	
	</td>	
</tr>
<tr>
	<td align="right" class="label" width="25%"><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>  &nbsp</td>
	<td align="left">
		<select name="staff_type" id="staff_type">
			<option value='  '>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td>			
	</td>	
	<td>	
	</td>	
</tr>
<tr>
	<td width="25%"  align=right class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/>  &nbsp&nbsp;</td>
	<td><input type=text name="position_desc" id="position_desc" value=""  onChange='clearDetail()' onblur='viewPositionGroup(position_desc);'><input class='button' type=button name="position_button" id="position_button" value="?"  onClick='viewPositionGroup(position_desc);clearDetail()'><img src='../../eCommon/images/mandatory.gif' align="center"></img></td>
	<input type="hidden" name="position_code" id="position_code" value="" >
	<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr><td colspan="5">&nbsp</td></tr>
</table>	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>

