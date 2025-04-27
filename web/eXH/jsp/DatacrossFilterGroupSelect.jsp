<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML>

<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td class="label"><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="Appliction_type"  name ='Application_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' " value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' value='?'    onClick="searchSegmentType()"><img src='../../eCommon/images/mandatory.gif'></td>
<td class="label">Protocol link</td>
<td align=left><input type=text id="Protocol_link_type"  name ='Protocol_link_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' " value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' value='?'    onClick="searchSegmentType()"><img src='../../eCommon/images/mandatory.gif'></td>
<td></td>
</tr>

<tr>
<td class="label"><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id="Facility_type"  name ='Facility_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' " value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='SegmentTypeSearch' id='SegmentTypeSearch'
value='?'    onClick="searchSegmentType()">
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<td class="label"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="Event_type"  name ='Event_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' " value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch'
value='?'    onClick="searchSegmentType()"><img src='../../eCommon/images/mandatory.gif'></td>
<td></td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.MessageType.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id="Message_type"  name ='Message_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' " value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='SegmentTypeSearch' id='SegmentTypeSearch'
value='?'    onClick="searchSegmentType()">
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<td></td>
<td></td>
</tr>
<tr>
		<td colspan=3></td>
	</tr>

</table>



</form>
</body>
</html>

