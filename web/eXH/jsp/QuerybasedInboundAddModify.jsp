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
<script Language="JavaScript"  src="../../eXH/js/QueryBasedInbound.js" ></script>
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

String application_id=""; 
String application_name=""; 
String facility_id=""; 
String facility_name=""; 
String event_type_id=""; 
String event_type=""; 
String segment_type_id="";
String segment_type="";
String inboundapi_id=""; 
String inboundapi_name=""; 
String executionOrder="";
String srl_no=""; 
String insert_Query="";
String update_Query=""; 

String stnd_code="";
String stnd_desc="";
String sub_api="";
String profile_id="";
String profile_desc="";


String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	inboundapi_name=request.getParameter("inboundapi_name");
	srl_no=request.getParameter("srl_no");
	insert_Query=request.getParameter("insert_Query");
		//System.out.println("insert qry : "+insert_Query);
	update_Query=request.getParameter("update_Query");
	//language_id=request.getParameter("lang_id");
	//stnd_code=request.getParameter("stnd_code");
	//stnd_desc=request.getParameter("stnd_desc");
	sub_api=request.getParameter("sub_api");
	profile_id=request.getParameter("profile_id");
	profile_desc=request.getParameter("profile_desc");
}

%>
<form name="QueryBasedInbAddMod" id="QueryBasedInbAddMod" target='messageFrame' method="POST" action = '' >

<!-- action='../../servlet/eXH.QuerybasedInboundAddModifyServlet' >  -->
<%
	application_id = request.getParameter("application_id");
		//System.out.println("QrybsdAddmdfy application_id : "+application_id);
	facility_id = request.getParameter("facility_id");
	event_type_id = request.getParameter("event_type_id");
	segment_type_id = request.getParameter("segment_type_id");
	inboundapi_id = request.getParameter("inboundapi_id");
%>

<table cellspacing=0 cellpadding=3 width='101%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<!--
<tr>
<td class=label ><fmt:message key="eXH.SerialNo.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="executionOrder"  name =executionOrder size=25 value='<%=executionOrder%>'> </td>
<td> </td> <td> </td>
</tr>
-->

<tr>
<td class=label ><fmt:message key="eXH.SubAPI.Label" bundle="${xh_labels}"/></td>
<td align=left>
	<input type=text id="sub_api"  name =sub_api value='<%=XHDBAdapter.checkNull(sub_api)%>' size=25 >
</td>
<td> </td><td> </td>
</tr>

<!--
<tr>
<td class=label ><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="profile_id"  name =profile_id value='<%=XHDBAdapter.checkNull(profile_id)%>' size=10 onBlur="searchProfile();">
<input type=text id="profile_desc"  name =profile_desc value='<%=XHDBAdapter.checkNull(profile_desc)%>' size=40 > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ProfileSearch value='?'    onClick="searchProfile();" >
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>
-->

<!--
<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="stnd_code"  name =stnd_code value='<%=XHDBAdapter.checkNull(stnd_code)%>' size=10 onBlur="searchStandard();">
<input type=text id="stnd_desc"  name =stnd_desc value='<%=XHDBAdapter.checkNull(stnd_desc)%>' size=40 > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=StandardSearch value='?'    onClick="searchStandard();" >
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>
-->

<tr>
<td class=label ><fmt:message key="eXH.InsertQuery.Label" bundle="${xh_labels}"/></td>
<td align=left><textarea name=insert_Query cols='50' rows='6' value=''> <%=XHDBAdapter.checkNull(insert_Query)%> </textarea>&nbsp;	<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button" name="insertquery" id="insertquery" value='?' 
		onClick="showQueryInfo(this);"> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.UpdateQuery.Label" bundle="${xh_labels}"/></td>
<td align=left><textarea name=update_Query cols='50' rows='6' value=''> <%=XHDBAdapter.checkNull(update_Query)%> </textarea>&nbsp;	<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button" name="updatequery" id="updatequery" value='?' 
		onClick="showQueryInfo(this);"> </td>
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

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type='hidden' name='actualmode' id='actualmode' value=''>	
<input type='hidden' name='rowid' id='rowid' value=''>
<input type='hidden' name='application_id' id='application_id' value='<%=application_id%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='event_type_id' id='event_type_id' value='<%=event_type_id%>' >
<input type='hidden' name='segment_type_id' id='segment_type_id' value='<%=segment_type_id%>' >
<input type='hidden' name='inboundapi_id' id='inboundapi_id' value='<%=inboundapi_id%>' >

<input type="hidden" name="srl_no" id="srl_no" value='<%=srl_no%>'>

</form>
</body>
</html>


