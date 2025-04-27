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
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/APIBasedInbound.js'></script> 
<!-- <script language='javascript' src='../../eXH/js/DataGroupId.js'></script> -->
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="APPL_RESULTS" id="APPL_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APIBASEDINBOUND";
			Connection conn = null;
			String dgcode = "";
			String whereClause = "WHERE  ";
/*			
			whereClause	=	whereClause+"A.DATA_GROUP_ID=B.DATA_GROUP_ID AND "+
			"A.APPLICATION_ID=C.APPLICATION_ID and A.FACILITY_ID=D.FACILITY_ID AND "+
			"A.PROTOCOL_LINK_ID=E.PROTOCOL_LINK_ID and A.MESSAGE_TYPE=F.MESSAGE_TYPE AND "+
			"A.EVENT_TYPE=G.EVENT_TYPE AND A.SEGMENT_TYPE=H.SEGMENT_TYPE AND "+
			"D.LANGUAGE_ID='en' ";
*/
			whereClause	=	whereClause+"A.APPLICATION_ID=C.APPLICATION_ID AND "+
			"A.FACILITY_ID=D.FACILITY_ID AND A.EVENT_TYPE=E.EVENT_TYPE "+
			"AND A.SEGMENT_ID=F.SEGMENT_TYPE AND A.INBOUND_API=B.API_CODE AND "+
			"D.language_id='en' ";

			
			try
			{
				dgcode=request.getParameter("dgcode");
				//System.out.println("DG Dtls Qry Rslt : "+dgcode);

				if(!(dgcode.equals(" ")))			
				{					
//					dgcode = data_group_det.getAttribute();
		  whereClause =whereClause + " AND A.DATA_GROUP_ID = NVL('#dgcode',A.DATA_GROUP_ID)";
		// 	  flag=true;
 				} 

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"14");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
				}
				else
				{
					strNext  = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('XH1021','XH'));
</script>

<% } else { %>
	<tr>
	<td colspan="4" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<!--
<tr>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.Data.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.FacilityId.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.ProtocolLinkId.Label" bundle="${xh_labels}"/></td>
	
</tr>

-->

<tr>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.Application_Id.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.Facility_Id.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.Event_Type.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.Segment_Type.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.ArgSerialNo.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.ArgID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.ArgName.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.ElementPos.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.ElementVal.Label" bundle="${xh_labels}"/></td>
</tr>




	<%
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' dg_code='<%=arrCol.get(0)+""%>'
	application_id='<%=arrCol.get(1)+""%>' facility_id='<%=arrCol.get(2)+""%>'
	protocol_link_id='<%=arrCol.get(3)+""%>' mesg_type_id='<%=arrCol.get(4)+""%>' event_type_id='<%=arrCol.get(5)+""%>' segment_type_id='<%=arrCol.get(6)+""%>'
	dg_desc='<%=arrCol.get(7)+""%>'
	application_name='<%=arrCol.get(8)+""%>'
	facility_name='<%=arrCol.get(9)+""%>'
	protocol_linkName='<%=arrCol.get(10)+""%>'
	mesg_type='<%=arrCol.get(11)+""%>'
	event_type='<%=arrCol.get(12)+""%>'
	segment_type='<%=arrCol.get(13)+""%>'>
	<%=arrCol.get(7)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(8) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(9) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(10) %>
	</td>

	</tr>
	<%
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>

	<input type='hidden' name='inboundapi_id' id='inboundapi_id' value=''>
	<input type='hidden' name='inboundapi_name' id='inboundapi_name' value=''>
	<input type='hidden' name='arg_serial_no' id='arg_serial_no' value=''>
	<input type='hidden' name='arg_id' id='arg_id' value=''>
	<input type='hidden' name='arg_name' id='arg_name' value=''>
	<input type='hidden' name='element_pos' id='element_pos' value=''>
	<input type='hidden' name='element_val' id='element_val' value=''>

<!--
	<input type='hidden' name='dg_code' id='dg_code' value=''>
	<input type='hidden' name='application_id' id='application_id' value=''>
	<input type='hidden' name='facility_id' id='facility_id' value=''>
	<input type='hidden' name='protocol_link_id' id='protocol_link_id' value=''>
	<input type='hidden' name='mesg_type_id' id='mesg_type_id' value=''>
	<input type='hidden' name='event_type_id' id='event_type_id' value=''>
	<input type='hidden' name='segment_type_id' id='segment_type_id' value=''>
	<input type='hidden' name='dg_desc' id='dg_desc' value=''>
	<input type='hidden' name='application_name' id='application_name' value=''>
	<input type='hidden' name='facility_name' id='facility_name' value=''>
	<input type='hidden' name='protocol_linkName' id='protocol_linkName' value=''>
	<input type='hidden' name='mesg_type' id='mesg_type' value=''>
	<input type='hidden' name='event_type' id='event_type' value=''>
	<input type='hidden' name='segment_type' id='segment_type' value=''>
	<input type='hidden' name='dgcode' id='dgcode' value=<%=dgcode%>>

	-->
</form>
</html>


