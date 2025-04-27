<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
<script>
function f1()
{
	//var mode=document.forms[0].mode.value;
	//if(mode=='update')
	eval("parent.frames[2].document.DiscrPanelQueryResult_form"+<%=associateDiagBean.clearAll()%>);
		
}
</script>
</head>


<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="contrsystempop()" >
<%
	Connection con=null;
	//PreparedStatement pstmt=null;
		
	String long_desc="";
	String short_desc="";

	con =	ConnectionManager.getConnection(request);
	String source=request.getParameter("source");
	
	%>


<form name='ClinicalRepMastAssociate_form' id='ClinicalRepMastAssociate_form'  method='post' target='messageFrame'>
<%
	if (source.equals("U"))
	{
%>
<table border='0' cellpadding='0' cellspacing='0'  width='102%' align='left'>
<tr>
    
		<td class=label align='right' width='25%'>&nbsp;&nbsp;Contr System</td>
		
		<td align=left>&nbsp;&nbsp;<select name='contr_system' id='contr_system' onChange="displayContributingEvents();">
		<option value="">-----------Select------------</option>
		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<tr>
	    <td  class=label align=right>Event Code</td>
		<td>&nbsp;
		<input type="text" name="event_code" id="event_code" size="10" maxlength="20" value="" onblur=''><input type="button" value="?" class="button" onClick="callEvent()" name='search' id='search'  >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' name='mand2'></img>
		</td>
</tr>
<tr><td  class=label align=right><b>Description</b></td>
		<td>&nbsp;</td>
</tr>
<tr>
	<td  align='right' class='label' >Long </td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='long_desc' id='long_desc' value=""   size="60" maxlength="60" onBlur="makeValidString(this)"" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td  align='right' class='label'>Short</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='short_desc' id='short_desc' value=""  size="30" maxlength="30"  onBlur="makeValidString(this)" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

</table>
<%}
else
{%>
<table border='0' cellpadding='0' cellspacing='0'  width='102%' align='left'>
<tr>
    
		<td class=label align='right' width='25%'>&nbsp;&nbsp;Contr System</td>
		
		<td align=left>&nbsp;&nbsp;<select name='contr_system' id='contr_system' onChange="displayContributingEvents();">
		<option value="">-----------Select------------</option>
		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>
<tr>
	    <td  class=label align=right>Event Code</td>
		<td>&nbsp;
		<input type="text" name="event" id="event" size="1" maxlength="1" value="$" disabled><input type="text" name="event_code" id="event_code" size="10" maxlength="20" value="" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' name='mand2'></img>
		</td>
</tr>
</tr>
<tr><td  class=label align=right><b>Description</b></td>
		<td>&nbsp;</td>
</tr>
<tr>
	<td  align='right' class='label' >Long </td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='long_desc' id='long_desc' value=""   size="60" maxlength="60" onBlur="makeValidString(this)"" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td  align='right' class='label'>Short</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='short_desc' id='short_desc' value=""  size="30" maxlength="30"  onBlur="makeValidString(this)" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

</table>
	<%}
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
	%>
     
<input type='hidden' name='contr_system1' id='contr_system1' value=''>
<input type='hidden' name='event_code1' id='event_code1' value=''>
<input type='hidden' name='long_desc1' id='long_desc1' value='<%=long_desc%>'>
<input type='hidden' name='short_desc1' id='short_desc1' value='<%=short_desc%>'>
</form>

</body>
</html>

