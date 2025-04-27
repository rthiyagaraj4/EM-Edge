<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
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
<script language="javascript" src="../../eXH/js/DataGroupId.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

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
String filter_rule_type="";
String srl_no="";
String comm_mode=request.getParameter("comm_mode");
String exceptions="";
String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type"); 
	segment_type=request.getParameter("segment_type");
	filter_rule_type=request.getParameter("filter_rule_type");
	srl_no=request.getParameter("srl_no");
	protocol_link_id	 =	XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
//		System.out.println("protocol_link_id : "+protocol_link_id);
	//language_id=request.getParameter("lang_id");
}

dg_code				=   request.getParameter("dg_code");
//	System.out.println("DataGroupDetailsAddModify DG Code : "+dg_code);
application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");


//System.out.println("dg_code :"+dg_code);
%>

<form name="Datagroupdetails_setup_form" id="Datagroupdetails_setup_form" target='messageFrame' method='post' action='../../servlet/eXH.DataGroupDetailsAddModifyServlet'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>

<tr>

<%
if(mode.equals("I"))
{
	try
    {
       if(con==null) con = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of DataGroupDetailsAddModify.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	
   String sql = "SELECT PROTOCOL_LINK_ID from xh_protocol_link where DATA_GROUP_ID='"+dg_code+"' ";
 ///  System.out.println("(DataGroupDetailsAddModify.jsp:sqlProtocolLinkQuery)  :"+sql);
   PreparedStatement pstmt = null;
   ResultSet rset = null;
   try
     {  
	   pstmt = con.prepareStatement(sql);
	   rset = pstmt.executeQuery();
	   while(rset.next())
	   {
			protocol_link_id=rset.getString(1);
            //System.out.println("DataGroupDetailsAddModify.jsp  protocol_link_id :"+protocol_link_id);
  
       } 
	   if(pstmt!=null) pstmt.close();
	   if(rset!=null)rset.close();
     }
	catch(Exception exp)
     {
	   System.out.println("Error in DataGroupDetailsAddModify.jsp  :"+exp.toString());
	   exp.printStackTrace(System.err);
	 }
}

%>
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>   
<td align=left>
<input type="hidden" name="facility_id" id="facility_id" value="<%=XHDBAdapter.checkNull(facility_id)%>" onBlur="searchFacility()" size='10'>
<input type=text id="facility_name"  name =facility_name size=40 value='<%=XHDBAdapter.checkNull(facility_name)%>'  onBlur="searchFacility()"> <input class="button" type="button"  name=FacilitySearch id=FacilitySearch value='?'    onClick="searchFacility()">
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>
 
<tr>
<td class=label ><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type="hidden" name="mesg_type_id" id="mesg_type_id" value="<%=XHDBAdapter.checkNull(mesg_type_id)%>" onBlur="searchMessageType()" size='10'>
<input type=text id="mesg_type"  name =mesg_type size=40 value='<%=XHDBAdapter.checkNull(mesg_type)%>'  onBlur="searchMessageType()"> <input class="button" type="button"  name=MessageTypeSearch id=MessageTypeSearch value='?'    onClick="searchMessageType()">
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type="hidden" name="event_type_id" id="event_type_id" value="<%=XHDBAdapter.checkNull(event_type_id)%>"  size='10'>
<input type=text id="event_type"  disabled name =event_type size=40 value='<%=XHDBAdapter.checkNull(event_type)%>' onBlur="searchEventType(document.forms[0].mesg_type_id)"  > <input class="button" type="button"  name=EventTypeSearch id=EventTypeSearch value='?'    onClick="searchEventType(document.forms[0].mesg_type_id)" disabled> <img src='../../eCommon/images/mandatory.gif' align=middle><input type=hidden name=event_name id=event_name value='<%=XHDBAdapter.checkNull(event_type)%>'> </td>
<td> </td><td> </td>
</tr> 
<input type="hidden" name="segment_type_id" id="segment_type_id" value="ALL"  size='10'>
<%---<tr>
<td class=label ><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type="hidden" name="segment_type_id" id="segment_type_id" value="<%=XHDBAdapter.checkNull(segment_type_id)%>" onblur='searchSegmentType()' size='10'>
<input type=text id="segment_type"  name =segment_type size=40 value='<%=XHDBAdapter.checkNull(segment_type)%>'   onBlur="searchSegmentType()" > <input class="button" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()">
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>---%>

<tr>
	<td class=label ><fmt:message key="eXH.FilterRules.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'>
	<select name ='filter_rule_type'  >
		<option value=''>----------Select--------</option>
		<option value='R' <%=filter_rule_type.equals("R")?"selected":""%>><fmt:message key="eXH.Restricted.Label" bundle="${xh_labels}"/></option>
		<option value='U' <%=filter_rule_type.equals("U")?"selected":""%>><fmt:message key="eXH.Unrestricted.Label" bundle="${xh_labels}"/></option>
		</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
		<td> </td><td> </td>
</tr>

<tr>
	<td width='20%'></td> 
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type="hidden" name="dg_code" id="dg_code" value='<%=dg_code%>'>
<input type="hidden" name="protocol_link_id" id="protocol_link_id" value='<%=protocol_link_id%>'>
<input type="hidden" name="srl_no" id="srl_no" value='<%=srl_no%>'>
<input type="hidden" name="comm_mode" id="comm_mode" value='<%=comm_mode%>'>
<input type="hidden" name="locale" id="locale" value='<%=locale%>'> 

</form>
</BODY>
</HTML> 

