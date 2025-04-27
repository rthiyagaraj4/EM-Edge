<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>

<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String defaultval = "";
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
<script language="javascript" src="../../eXH/js/DataGroupIdDetails.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
/*
//function onSelectDataGroup
function onSelectDataGroup(obj)
{
	document.forms[0].action="../../eXH/jsp/.jsp?message_type="+obj.value;
	document.forms[0].submit();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String application_id=""; 
String facility_id=""; 
String mesg_type_id=""; 
String event_type_id=""; 
String segment_type_id="";
String protocol_link_id="";

String dg_code="";
String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";


String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	dg_code=request.getParameter("dg_code");
	defaultval=request.getParameter("dg_code");
	
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
	//language_id=request.getParameter("lang_id");
}

application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
protocol_link_id	=	request.getParameter("protocol_link_id");

%>

<form name="Datagroupdetails_setup_form" id="Datagroupdetails_setup_form" target='messageFrame' method='post' action='../../servlet/eXH.DataGroupDetailsAddModifyServlet'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>

<tr>
<td class=label >Data</td> 

<td class='fields'>
<%
try
{
con=ConnectionManager.getConnection();
//String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP WHERE //LANGUAGE_ID='"+locale+"' ORDER BY 2";
String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>

<tr>
<td class=label >Application ID</td>
<td align=left><input type=text id="application_name"  name =application_name value='<%=application_name%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ApplicationSearch value='?'    onClick="searchApplication();">
<input type="hidden" name="application_id" id="application_id" value="<%=application_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label >Facility ID</td>
<td align=left><input type=text id="facility_name"  name =facility_name size=25 value='<%=facility_name%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=FacilitySearch value='?'    onClick="searchFacility()">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label >Message Type</td>
<td align=left><input type=text id="mesg_type"  name =mesg_type size=25 value='<%=mesg_type%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=MessageTypeSearch value='?'    onClick="searchMessageType()">
<input type="hidden" name="mesg_type_id" id="mesg_type_id" value="<%=mesg_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label >Event Type</td>
<td align=left><input type=text id="event_type"  name =event_type size=25 value='<%=event_type%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=EventTypeSearch value='?'    onClick="searchEventType()">
<input type="hidden" name="event_type_id" id="event_type_id" value="<%=event_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label >Segment Type</td>
<td align=left><input type=text id="segment_type"  name =segment_type size=25 value='<%=segment_type%>'  > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()">
<input type="hidden" name="segment_type_id" id="segment_type_id" value="<%=segment_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label >Protocol Link ID</td>
<td align=left><input type=text id="protocol_linkName"  name =protocol_linkName size=25 value='<%=protocol_linkName%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ProtocolLinkSearch value='?'    onClick="searchProtocolLink()">
<input type="hidden" name="protocol_link_id" id="protocol_link_id" value="<%=protocol_link_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>
	
	<%
	}
catch(Exception e1){
		System.out.println("(DataGroupDetailsSelectMaster.jsp:Excetion-1)"+e1.toString());
}
finally{

		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
}
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 

