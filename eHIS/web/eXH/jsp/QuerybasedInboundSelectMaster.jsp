<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 										    
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/QueryBasedInbound.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String application_id=""; 
String application_name=""; 
String facility_id=""; 
String facility_name=""; 
String event_type_id=""; 
String event_type=""; 
String inboundapi_id=""; 
String segment_type_id="";
String inboundapi_name=""; 
String segment_type="";
String executionOrder=""; 
String insert_Query="";
String update_Query=""; 
String cond_for_ins_upd="";
String stop_at_cond="";

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
//	inboundapi_id=request.getParameter("inboundapi_id");
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	event_type=request.getParameter("event_type");
	inboundapi_name=request.getParameter("inboundapi_name");
//	segment_type_id=request.getParameter("segment_type_id");
	segment_type=request.getParameter("segment_type");
	executionOrder=request.getParameter("executionOrder");
	insert_Query=request.getParameter("insert_Query");
	update_Query=request.getParameter("update_Query");
	cond_for_ins_upd=request.getParameter("cond_for_ins_upd");
	stop_at_cond=request.getParameter("stop_at_cond");
	//language_id=request.getParameter("lang_id");
}


application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
event_type_id		=	request.getParameter("event_type_id");
inboundapi_id		=	request.getParameter("inboundapi_id");
segment_type_id		=	request.getParameter("segment_type_id");

%>

<form name="Querybasedheaderform" id="Querybasedheaderform" target='messageFrame' method='post' action='../../servlet/eXH.QueryBasedHeaderServlet'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<!--
	<td width='40%'></td>
	<td width='60%'></td>
-->
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="application_name"  name =application_name value='<%=application_name%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ApplicationSearch value='?'    onClick="searchApplication();">
<input type="hidden" name="application_id" id="application_id" value="<%=application_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.FacilityId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="facility_name"  name =facility_name size=25 value='<%=facility_name%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=FacilitySearch value='?'    onClick="searchFacility()">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="event_type"  name =event_type size=25 value='<%=event_type%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=EventTypeSearch value='?'    onClick="searchEventType()">
<input type="hidden" name="event_type_id" id="event_type_id" value="<%=event_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ExecId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="segment_type"  name =segment_type size=25 value='<%=segment_type%>'  > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()">
<input type="hidden" name="segment_type_id" id="segment_type_id" value="<%=segment_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="inbound_api"  name =inboundapi_name value='<%=inboundapi_name%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=InboundAPISearch value='?'    onClick="searchInboundAPI();">
<input type="hidden" name="inboundapi_id" id="inboundapi_id" value="<%=inboundapi_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<!--
<tr>
<td class=label ><fmt:message key="eXH.ExecOrder.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="executionOrder"  name =executionOrder size=25 value='<%=executionOrder%>'> </td>
<td> </td> <td> </td>
</tr>



<tr>
<td class=label ><fmt:message key="eXH.InsertQuery.Label" bundle="${xh_labels}"/></td>
<td align=left><textarea name=insert_Query cols='35' rows='5' value=''> <%=XHDBAdapter.checkNull(insert_Query)%> </textarea> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.UpdateQuery.Label" bundle="${xh_labels}"/></td>
<td align=left><textarea name=update_Query cols='35' rows='5' value=''> <%=XHDBAdapter.checkNull(update_Query)%> </textarea> </td>
<td> </td> <td> </td>
</tr>

-->

<tr><td colspan=4 class='BUTTON'>
<input class='button' type="button"  name='new_butt' id='new_butt' value='New Data Group'
onClick='funNew()'>
<!--
<input class='button' type="button"  name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick='funAdd()'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
-->
</td>
</tr>

<!--
<tr>
<td class=label ><fmt:message key="eXH.CondForInsertUpdt.Label" bundle="${xh_labels}"/></td>
<td align=left><textarea name=cond_for_ins_upd cols='35' rows='5' value=''> <%=XHDBAdapter.checkNull(cond_for_ins_upd)%> </textarea> </td>
<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.StopAtCondFailure.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="stop_at_cond"  name =stop_at_cond size=10 value='<%=XHDBAdapter.checkNull(stop_at_cond)%>'> </td>
<td> </td> <td> </td>
</tr>
-->

<tr>
<!--
	<td width='40%'></td>
	<td width='60%'></td>
-->
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>
</table>
	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 

