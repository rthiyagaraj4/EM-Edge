<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String disabled = "disabled";
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
<script language="javascript" src="../../eXH/js/APIBasedInbound.js" ></script> 
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
String segment_type_id="";
String segment_type="";
String inboundapi_id=""; 
String inboundapi_name=""; 
String chkDisp = "none";
String exec_nature="";
String profile_id="";
String profile_desc="";

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	event_type=request.getParameter("event_type");
	inboundapi_name=request.getParameter("inboundapi_name");
	segment_type=request.getParameter("segment_type");

	exec_nature=request.getParameter("exec_nature");
	//System.out.println("Exec Nat : "+exec_nature);
	if(exec_nature.equals("Q")||exec_nature.equals("T")){
		disabled = "";
	}
	
	chkDisp = "block";
	profile_id=request.getParameter("profile_id");
	profile_desc=request.getParameter("profile_desc");
}

application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
inboundapi_id		=	request.getParameter("inboundapi_id");

%>

<form name="APIbased_Inb_Select" id="APIbased_Inb_Select" target='messageFrame' method='post' action='../../servlet/eXH.APIbasedInboundAddModifyServlet'> 
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="application_id"  name =application_id value='<%=XHDBAdapter.checkNull(application_id)%>' size=10 onBlur="searchApplication();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="application_name"  name =application_name value='<%=application_name%>' size=40 <%=mode.equals("U")?"readonly":""%>> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ApplicationSearch value='?'    onClick="searchApplication();" <%=mode.equals("U")?"disabled":""%>>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="facility_id"  name =facility_id value='<%=XHDBAdapter.checkNull(facility_id)%>' size=10 onBlur="searchFacility();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="facility_name"  name =facility_name size=40 value='<%=facility_name%>' <%=mode.equals("U")?"readonly":""%> > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=FacilitySearch value='?'   <%=mode.equals("U")?"disabled":""%> onClick="searchFacility()">
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="event_type_id"  name =event_type_id value='<%=XHDBAdapter.checkNull(event_type_id)%>' size=10 onBlur="searchEventType();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="event_type"  name =event_type size=40 value='<%=event_type%>' <%=mode.equals("U")?"readonly":""%>> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=EventTypeSearch value='?'    onClick="searchEventType()" <%=mode.equals("U")?"disabled":""%>>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<%
	
%>

<tr>
<td class=label ><fmt:message key="eXH.ExecId.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id="segment_type_id"  name =segment_type_id value='<%=XHDBAdapter.checkNull(segment_type_id)%>' size=10 onBlur="searchSegmentType();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="segment_type"  name =segment_type size=40 value='<%=segment_type%>' <%=mode.equals("U")?"readonly":""%> > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()" <%=mode.equals("U")?"disabled":""%>>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id="inboundapi_id"  name =inboundapi_id value='<%=XHDBAdapter.checkNull(inboundapi_id)%>' size=10 onBlur="searchInboundAPI();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="inbound_api"  name =inboundapi_name value='<%=inboundapi_name%>' size=40 <%=mode.equals("U")?"readonly":""%>> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=InboundAPISearch value='?'    onClick="searchInboundAPI();" <%=mode.equals("U")?"disabled":""%>>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="profile_id"  name =profile_id value='<%=XHDBAdapter.checkNull(profile_id)%>' size=10 onBlur="searchProfile();" <%=mode.equals("U")?"readonly":""%>>
<input type=text id="profile_desc"  name =profile_desc value='<%=XHDBAdapter.checkNull(profile_desc)%>' size=40 <%=mode.equals("U")?"readonly":""%>> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ProfileSearch value='?'    onClick="searchProfile();"  <%=mode.equals("U")?"disabled":""%>>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

</table>
	
<div id='button_disp' style="display:<%=chkDisp%>;" >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td colspan=4 class='BUTTON'>

	<input class='button' type="button"  name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' <%=disabled%> onClick='funAdd()'>  
	<input class='button' type="button" name='generate_butt' id='generate_butt' value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>'  disabled onClick='funGenerate()'>
	<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
</td>
</tr>
</table>
</div>	

<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type="hidden" name="exec_nature" id="exec_nature" value='<%=exec_nature%>'>


</form>
</BODY>
</HTML> 

