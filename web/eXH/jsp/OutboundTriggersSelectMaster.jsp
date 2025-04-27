<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,java.sql.DatabaseMetaData,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<%  
// String selected = "selected";
// String disabled = "disabled";
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
<script language="javascript" src="../../eXH/js/OutboundTriggers.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

function clearFacId(){
//	alert("Table Changed");
}

var disabled = true;

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%

String facility_id=""; 
String event_type_id=""; 
String facility_type="";

String trig_name="";
String trig_event="";
String trig_type="";
String trig_cond="";
String event_type=""; 
String facility_name=""; 
String insert_stat="";

String table_id="";
String table_name="";
String entity_name="";

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	trig_name=request.getParameter("trig_name");
	trig_event=request.getParameter("trig_event");
	trig_type=request.getParameter("trig_type");
	trig_cond=request.getParameter("trig_cond");
//		//System.out.println("trig_cond : "+trig_cond);
	event_type=request.getParameter("event_type");
	facility_name=request.getParameter("facility_name");
	insert_stat=request.getParameter("insert_stat");
}

facility_id			=	request.getParameter("facility_id");
event_type_id		=	request.getParameter("event_type_id");
table_name			=   request.getParameter("table_name");
entity_name			=   request.getParameter("entity_name");
table_id			=	request.getParameter("table_id");
facility_type		=	request.getParameter("facility_type");

%>

<form name="outbound_trig_form" id="outbound_trig_form" target='messageFrame' method='post' action='../../servlet/eXH.OutboundTriggersAddModifyServlet'>
<table cellspacing=0 cellpadding=3 width='102%' align=center >
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='40%'></td>
	<td width='10%'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.TriggerName.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=trig_name size=30 maxlength=27 value='<%=XHDBAdapter.checkNull(trig_name)%>'   <%=mode.equals("U")?"readonly":""%> > <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.TriggerEvent.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=trig_event size=25 value='<%=trig_event%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.TriggeringTable.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="table_name"  name =table_name value='<%=XHDBAdapter.checkNull(table_name)%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=TableSearch value='?'    onClick="searchTables();" onchange='clearFacId();'>
<input type="hidden" name="table_id" id="table_id" value="<%=table_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="eXH.TriggerType.Label" bundle="${xh_labels}"/></td>
<td align=left>
<select class='select' name='trig_type' id='trig_type'  "+disabled+" >
            <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			<option value='S' <%=trig_type.equals("S")?"selected":""%>><fmt:message key="eXH.Statement.Label" bundle="${xh_labels}"/></option>
			<option value='R' <%=trig_type.equals("R")?"selected":""%>><fmt:message key="eXH.Row.Label" bundle="${xh_labels}"/></option>
</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="eXH.TriggeringCondition.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="trig_cond"  name =trig_cond size=25 value="<%=XHDBAdapter.checkNull(trig_cond)%>"> </td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td colspan=2 align=left>
	<input type="text" name="event_type_id" id="event_type_id" size='5'onBlur='searchEventType()' value="<%=XHDBAdapter.checkNull(event_type_id)%>">
	<input type=text id="event_type"  name =event_type size=25 value='<%=event_type%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=EventTypeSearch value='?'    onClick="searchEventType()">
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td align=left>
<select class='select' name='facility_type' id='facility_type'  "+disabled+" > 
         	<option value='S' <%=XHDBAdapter.checkNull(facility_type).equals("S")?"selected":""%>><fmt:message key="eXH.SMPARAM.Label" bundle="${xh_labels}"/> </option>
			<option value='N' <%=XHDBAdapter.checkNull(facility_type).equals("N")?"selected":""%>><fmt:message key="eXH.NewFacility.Label" bundle="${xh_labels}"/> </option>
</select> </td>

<td > 
<input type="text" name="facility_id" id="facility_id" size='5' onBlur='searchFacility()' value="<%=XHDBAdapter.checkNull(facility_id)%>">
<input type=text id="facility_name"  name =facility_name size=25 value='<%=facility_name%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=FacilitySearch value='?' onClick="searchFacility()">
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.InsertingStatement.Label" bundle="${xh_labels}"/></td>
<td colspan=3>
<textarea name='insert_stat' rows=10 cols=60 ><%=XHDBAdapter.checkNull(insert_stat)%> </textarea> <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>	
</tr>

<tr><td colspan=3 class='BUTTON'>
<input class='button' type="button" name='generate_butt' id='generate_butt' value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>'   <%=mode.equals("I")?"disabled":""%> onClick='funGenerate()'>

</td>
<td> </td>
</tr>

<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='40%'></td>
	<td width='10%'></td>
</tr>
</table>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'> 
<input type="hidden" name="gen_flag" id="gen_flag" value=''>

</form>
</BODY>
</HTML> 

