<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.util.*,java.net.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String rule=request.getParameter("Rule");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencebasicelement.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencebasicelementID.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReference.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function deleterecord(mode)
{
	//var act='../../servlet/eXH.XHDataElementCrossRefElementIDServlet'
//this.document.forms[0].action = act;


document.forms[0].target='messageFrame'
  document.forms[0].actualmode.value=mode;
  document.forms[0].submit(); 

}
function hide()
{

	/*if (document.forms[0].expectedvalue2.value==""||document.forms[0].expectedvalue2.value==null)
	{
	document.getElementById("table1").disabled = true;
document.getElementById("hiderefr").style.visibility = '';
	}
	else
	{
document.getElementById("hiderefr").style.visibility = '';
	document.getElementById("table1").style.display='';
	}*/
}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload="hide();">
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF"  method="POST" action='../../servlet/eXH.XHDataElementCrossRefElementIDServlet' > 
<%
	String application_id = XHDBAdapter.checkNull(request.getParameter("application_id"));
String element_id=URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("element_id")),"utf-8");
	
String derivation_type = XHDBAdapter.checkNull(request.getParameter("derivation_type"));
String condition_exp1_val =XHDBAdapter.checkNull(request.getParameter("condition_exp1_val"));
String expected_value = XHDBAdapter.checkNull(request.getParameter("expected_value"));
String execution_order = XHDBAdapter.checkNull(request.getParameter("execution_order"));
String expected_value2 = XHDBAdapter.checkNull(request.getParameter("expected_value2"));
String position =XHDBAdapter.checkNull(request.getParameter("position"));
//System.out.println("element_id6451"+element_id+"application_id"+application_id+"derivation_type"+derivation_type+"condition_exp1_val"+condition_exp1_val+"expected_value"+expected_value+"execution_order"+execution_order+"expected_value2"+expected_value2+"position"+position);
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
<input type=text name=derivation_type1 size=10 value='<%=derivation_type%>' disabled>
<input type=hidden name=derivation_type size=10 value='<%=derivation_type%>' >
</td>
	<td class=label width='10%'><fmt:message key="eXH.CondExpr.Label" bundle="${xh_labels}"/></td>
	<td align=left><!--<input type=text name=cond_exprsn size=10 value='' 
	onBlur=="TextFocus(ocument.DATAELEMENTCROSSREF.execution_order);" >--><input type=text name=cond_exprsn size=10 value='<%=condition_exp1_val%>' disabled> </td>
</tr>
<tr>
	<td class=label width='10%'><fmt:message key="eXH.ExpectedValue.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=expected_value size=10 value='<%=expected_value%>' disabled><input type='hidden' name='expectedvalue' id='expectedvalue' value='<%=expected_value%>'></td>
	<td class=label width='10%'><fmt:message key="eXH.ExecOrder.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=execution_order size=10 value='<%=execution_order%>' onKeyPress='return CheckForSpecCharsforID(event);' disabled></td>
</tr>
<tr>


	<td class=label  id="Expected_value_id"  ><fmt:message key="eXH.ExpectedValue2.Label" bundle="${xh_labels}"/></label>	</td>

	<td align=left><input type=text name=expected_value2 size=10 value='<%=expected_value2%>' disabled >	<input type='hidden' name='expectedvalue2' id='expectedvalue2' value='<%=expected_value2%>'></td>

	<td class=label  width='10%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td><td align=left><input type=text name=Position_value size=10 value='<%=position%>' disabled> 
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center >
<tr>
<td colspan=6 align=right ><input class='button' type='button'  name='Delete' id='Delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick="deleterecord('D')"></td>
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


