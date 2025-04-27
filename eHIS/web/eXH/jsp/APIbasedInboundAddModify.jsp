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
<script Language="JavaScript"  src="../../eXH/js/APIBasedInbound.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script Language="JavaScript" >
//function record
function record(val)
{
	this.document.forms[0].actualmode.value = val;
	this.document.forms[0].submit();
		
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%

String inboundapi_name=""; 
String application_id=""; 
String application_name=""; 
String facility_name=""; 
String event_type=""; 
String arg_serial_no=""; 
String arg_id=""; 
String arg_name=""; 
String element_pos=""; 
String element_id="";
String element_val=""; 
String stnd_code="";

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	inboundapi_name=request.getParameter("inboundapi_name");
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	event_type=request.getParameter("event_type");
	arg_serial_no=request.getParameter("arg_serial_no");
	arg_id=request.getParameter("arg_id");
	arg_name=request.getParameter("arg_name");
	element_pos=request.getParameter("element_pos");
	element_val=request.getParameter("element_val");
	//System.out.println("Modify element_val : "+element_val);
	//language_id=request.getParameter("lang_id");
}

	element_id = request.getParameter("element_id");

%>
<form name="APIbased_Inb_AddMod" id="APIbased_Inb_AddMod" method="POST" action='' > 
<%
	application_id = request.getParameter("application_id");
%>

<table cellspacing=0 cellpadding=3 width='101%' align=center>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.SerialNo.Label" bundle="${xh_labels}"/></td>
<!--
<td class=label ><fmt:message key="eXH.ArgSerialNo.Label" bundle="${xh_labels}"/></td> -->
<td align=left><input type=text id="arg_serial_no"  name =arg_serial_no size=25 value='<%=arg_serial_no%>'></td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ArgID.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="arg_id"  name =arg_id size=25 value='<%=arg_id%>'> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ArgName.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="arg_name"  name =arg_name size=25 value='<%=arg_name%>'> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.Standardcode.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="stnd_code"  name=stnd_code size=25 value='<%=stnd_code%>' readonly> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label >Profile </td>
<td class='fields'><input type=text name=profile_id size=25
title='Profile Id' ></td>
	<td> </td> <td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="eXH.ElementPos.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="element_pos"  name =element_pos value='<%=element_pos%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElementSearch value='?'    onClick="searchElement();">
<input type="hidden" name="element_id" id="element_id" value="<%=element_id%>"></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ElementVal.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="element_val"  name =element_val size=25 value='<%=XHDBAdapter.checkNull(element_val)%>'> </td>
<td> </td> <td> </td>
</tr>


</table>

<table cellspacing=0 cellpadding=3 width='101%' border=0 align=center id='insertoper' style='display:none'>
<tr>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record('I')">
<input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancel()"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center id='modifyoper' style='display:none'>
<tr>
<td colspan=8 align=right ><input class='button' type='button'  name='modify' id='modify' value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' onClick="record('U')"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>

<%
%>

<input type='hidden' name='actualmode' id='actualmode' value=''>	
<input type='hidden' name='rowid' id='rowid' value=''>
<input type='hidden' name='application_id' id='application_id' value='<%=application_id%>' >
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>


</form>
</body>
</html>


