<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>

<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence1.js" ></script>
<script Language="JavaScript" >

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload="hide();">
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" target='messageFrame' method="POST" action='../../eXH/jsp/ProfilDervationQueryRecord.jsp' > 
<%
	String application_id = request.getParameter("application_id");
	String element_id = request.getParameter("element_id");
//System.out.println("element_id31"+element_id);
	%>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr> 
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.DerivationType.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select class='select' name=derivation_type onchange='changeTexts("myImage","myImage1","table1");'  >
	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<option value='IF' ><fmt:message key="eXH.IF.Label" bundle="${xh_labels}"/></option>
	<option value='AE' ><fmt:message key="eXH.AE.Label" bundle="${xh_labels}"/></option>
	<option value='LTRIM' ><fmt:message key="eXH.LTRIM.Label" bundle="${xh_labels}"/></option>
	<option value='RTRIM' ><fmt:message key="eXH.RTRIM.Label" bundle="${xh_labels}"/></option>
    <option value='TRIM' ><fmt:message key="eXH.TRIM.Label" bundle="${xh_labels}"/></option>
    <option value='SUBSTR' ><fmt:message key="eXH.SUBSTR.Label" bundle="${xh_labels}"/></option>
    <option value='REPLACE' ><fmt:message key="eXH.REPLACE.Label" bundle="${xh_labels}"/></option>
    <option value='BETWEEN' ><fmt:message key="eXH.Between.Label" bundle="${xh_labels}"/></option>
	<option value='NOT BETWEEN' ><fmt:message key="eXH.NotBetween.Label" bundle="${xh_labels}"/></option>
	<option value='IN' ><fmt:message key="eXH.IN.Label" bundle="${xh_labels}"/></option>
	<option value='NOT IN' ><fmt:message key="eXH.NotIN.Label" bundle="${xh_labels}"/></option>
	<option value='LIKE' ><fmt:message key="eXH.Like.Label" bundle="${xh_labels}"/></option>
	<option value='NOT LIKE' ><fmt:message key="eXH.NotLike.Label" bundle="${xh_labels}"/></option>
	<option value='PREFIX' ><fmt:message key="eXH.Prefix.Label" bundle="${xh_labels}"/></option>
	<option value='SUFFIX' ><fmt:message key="eXH.Suffix.Label" bundle="${xh_labels}"/></option>
	<option value='PRESUFFIX' ><fmt:message key="eXH.PreSuffix.Label" bundle="${xh_labels}"/></option>
	<option value='USER_DEF_FORMAT' ><fmt:message key="eXH.UserDefinedFormat.Label" bundle="${xh_labels}"/></option>
	<option value='<>' ><fmt:message key="eXH.<>.Label" bundle="${xh_labels}"/></option>
	<option value='=' ><fmt:message key="eXH.=.Label" bundle="${xh_labels}"/></option>
	<option value='<' ><fmt:message key="eXH.<.Label" bundle="${xh_labels}"/></option>
	<option value='>' ><fmt:message key="eXH.>.Label" bundle="${xh_labels}"/></option>
    <option value='<=' ><fmt:message key="eXH.<=.Label" bundle="${xh_labels}"/></option>
    <option value='>=' ><fmt:message key="eXH.>=.Label" bundle="${xh_labels}"/></option>
    <option value='IS NULL' ><fmt:message key="eXH.ISNULL.Label" bundle="${xh_labels}"/></option>
    <option value='IS NOT NULL'><fmt:message key="eXH.ISNOTNULL.Label" bundle="${xh_labels}"/></option>
</select>	<img name="myImage13" src='../../eCommon/images/mandatory.gif'  align=middle >
</td>
	<td class=label width='10%'><fmt:message key="eXH.CondExpr.Label" bundle="${xh_labels}"/></td>
	<td align=left><!--<input type=text name=cond_exprsn size=10 value='' 
	onBlur=="TextFocus(ocument.DATAELEMENTCROSSREF.execution_order);" >--><input type=text name=cond_exprsn size=10 value='' > </td>
</tr>
<tr>
	<td class=label width='10%'><fmt:message key="eXH.ExpectedValue.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=expected_value size=10 value='' ><input type='hidden' name='expectedvalue' id='expectedvalue' value=''><img name="myImage" src='../../eCommon/images/empty.gif'  align=middle></td>
	<td class=label width='10%'><fmt:message key="eXH.ExecOrder.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=execution_order size=10 value='' onKeyPress='return CheckForSpecCharsforID(event);' ><img name="myImage3" src='../../eCommon/images/mandatory.gif'  align=middle ></td>
</tr> 
<tr>
<td>
<table id="table1" style="display:none;">
	<tr>
	<td class=label label id="Expected_value_id"  width='10%'><fmt:message key="eXH.ExpectedValue2.Label" bundle="${xh_labels}"/></td></label>	
	</tr>
</table>
</td>	
<td align=left><input type=text name=expected_value2 size=10 value='' ><input type='hidden' name='expectedvalue2' id='expectedvalue2' value=''>	<img name="myImage1" src='../../eCommon/images/empty.gif'  align=middle></td>
	<td class=label  width='10%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td><td align=left><input type=text name=Position_value size=10 value=''> <img name="myImage3" src='../../eCommon/images/mandatory.gif'  align=middle >
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center id='insertoper' style='display:inline'>
<tr>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record('I')">
<input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancel("myImage1","table1");'></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='102%' align=center id='modifyoper' style='display:none'>
<tr>
<td colspan=8 align=right ><input class='button' type='button'  name='modify' id='modify' value='<fmt:message key="eXH.Modify.Label" bundle="${xh_labels}"/>' onClick="record('U')"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>

<%
/*
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

*/
	%>
<input type='hidden' name='actualmode' id='actualmode' value=''>	
<input type='hidden' name='rowid' id='rowid' value=''>
<input type='hidden' name='application_id' id='application_id' value='<%=application_id%>' >
<input type='hidden' name='element_id' id='element_id' value='<%=element_id%>'>
</form>
</body>
</html>


