<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{
String Filter_type_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String Filter_code_desc=XHDBAdapter.checkNull(request.getParameter("Filter_group_desc"));
String ApplicationId=XHDBAdapter.checkNull(request.getParameter("applicationId"));
String FacilityId=XHDBAdapter.checkNull(request.getParameter("facilityId"));
String Messagetype=XHDBAdapter.checkNull(request.getParameter("Message_type"));
String EventType=XHDBAdapter.checkNull(request.getParameter("eventType"));
String Protocollink=XHDBAdapter.checkNull(request.getParameter("Protocol_type"));
String Totallevel=XHDBAdapter.checkNull(request.getParameter("Total_level"));
String actmode=XHDBAdapter.checkNull(request.getParameter("act_mode"));


 

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eXH/js/filterlayerrefrence4.js' language='javascript'></script>
<script src='../../eXH/js/filterlayerrefrence.js' language='javascript'></script>

<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload='hide()' >
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" target='messageFrame' method="POST" action='../../eXH/jsp/FilterLayarGroupRecord.jsp' > 
<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
<td class=label ><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
<td align=left><input type=text name=Filter_group_code1 size=15 value='<%=Filter_type_code%>' > <img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="Filter_group_code" id="Filter_group_code" value="<%=Filter_type_code%>"</td>
<td class=label width='10%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=Filter_group_desc size=15 value='<%=Filter_code_desc%>' > </td>
<td class=label width='10%'><fmt:message key="eXH.TotalLevels.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name=Total_level size=15 onKeyPress='return CheckForSpecCharsforID(event);' value='<%=Totallevel%>' ></td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id='Application_type'  name ='Application_type' size='15' onBlur="if(this.value!='')searchApplicationType();else Application_type_id.value='' " value='<%=ApplicationId%>'  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' value='?'    onClick="searchApplicationType()"><img src='../../eCommon/images/mandatory.gif'></td>
<input type="hidden" name="Application_type_id" id="Application_type_id" value="<%=ApplicationId%>">
<td class="label"><fmt:message key="eXH.ProtocolLinkId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="Protocol_link_type"  name ='Protocol_link_type' size='15' onBlur="if(this.value!='')searchProtocolType();else Protocol_Link_id.value='' " value='<%=Protocollink%>'  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' value='?'    onClick="searchProtocolType()"><img src='../../eCommon/images/mandatory.gif'>
</td><input type="hidden" name="Protocol_Link_id" id="Protocol_Link_id" value="<%=Protocollink%>">
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="Facility_type"  name ='Facility_type' size='15' onBlur="if(this.value!='')searchFacilityType();else Facility__id.value='' " value='<%=FacilityId%>'  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='SegmentTypeSearch' id='SegmentTypeSearch'
value='?'    onClick="searchFacilityType()">
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<input type="hidden" name="Facility__id" id="Facility__id" value="<%=FacilityId%>">
</tr> 
<tr>
<td class="label"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="Event_type"  name ='Event_type' size='15' onBlur="if(this.value!='')searchEventType();else Event__id.value='' " value='<%=EventType%>'  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch'
value='?'    onClick="searchEventType()"><img src='../../eCommon/images/mandatory.gif'></td>
<input type="hidden" name="Event__id" id="Event__id" value="<%=EventType%>">

<td class="label"><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text   name ='Message_type' size='15' value='<%=Messagetype%>'  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='SegmentTypeSearch' id='SegmentTypeSearch'
value='?'    onClick="searchMessageType()">
<img src='../../eCommon/images/mandatory.gif' align='middle'><input type="hidden" name="Message__id" id="Message__id" value="<%=Messagetype%>"></td>

<td>
</td>
<td>
</td>

</tr>
<tr>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record()"><input class='button' type='button'  name='deletebutton' id='deletebutton' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick="Delete('D')" ><input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancel();'></td>
</tr>
</table>
<input type='hidden' name='actualmode' id='actualmode' value='<%=actmode%>'>	
<input type='hidden' name='rowid' id='rowid' value=''>
<input type='hidden' name='Application_id' id='Application_id' value='<%=ApplicationId%>'>	
<input type='hidden' name='Facilitysome_id' id='Facilitysome_id' value='<%=FacilityId%>'>
<input type='hidden' name='Protocol_Id' id='Protocol_Id' value='<%=Protocollink%>'>	
<%

}
catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayerGroupFilterLevalAdd.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         
     }    
%>
</form>
</body>
</html>

 

