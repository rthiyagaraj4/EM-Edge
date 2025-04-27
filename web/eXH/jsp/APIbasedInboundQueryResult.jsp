<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
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
<form name="APIBasedHeaderResult" id="APIBasedHeaderResult" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
//			String qry_id = "APIBASEDINBOUND";

			String qry_id = "INBOUNDHEADER";
			
			Connection conn = null;
//			String dgcode = "";
			String whereClause = "WHERE  ";
/*
			whereClause	=	whereClause+"A.APPLICATION_ID=C.APPLICATION_ID AND "+
			"A.FACILITY_ID=D.FACILITY_ID AND A.EVENT_TYPE=E.EVENT_TYPE "+
			"AND A.SEGMENT_ID=F.SEGMENT_TYPE AND A.INBOUND_API=B.API_CODE AND "+
			"D.language_id='en' ";
*/
//			System.out.println("APIResult "+whereClause);
			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				//System.out.println("(APIbasedInboundQueryResult:qry id) : "+qry_id);
				request.setAttribute(XHQueryRender.col,"13");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
	<td colspan="7" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.SegmentName.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="eXH.ExecNature.Label" bundle="${xh_labels}"/></td>

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
//		System.out.println("API Rslt arrCol.get(12) : "+arrCol.get(11));
//		System.out.println("APi elmnt_id : "+XHDBAdapter.checkNull((String)arrCol.get(6)));
	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' application_id='<%=arrCol.get(0)+""%>' 
	application_name='<%=arrCol.get(1)+""%>' 
	facility_id='<%=arrCol.get(2)+""%>'	facility_name='<%=arrCol.get(3)+""%>' event_type_id='<%=arrCol.get(4)+""%>' event_type='<%=arrCol.get(5)+""%>' segment_type_id='<%=arrCol.get(6)+""%>' segment_type='<%=arrCol.get(7)+""%>' inboundapi_id='<%=arrCol.get(8)+""%>' inboundapi_name='<%=arrCol.get(9)+""%>' 
	exec_nature='<%=XHDBAdapter.checkNull((String)arrCol.get(10))+""%>' 	profile_id='<%=XHDBAdapter.checkNull((String)arrCol.get(11))+""%>'
	profile_desc='<%=XHDBAdapter.checkNull((String)arrCol.get(12))+""%>'

	>
	<%=arrCol.get(1)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(3) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(5) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(7) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(9) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(12) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(10)) %>
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


	<input type='hidden' name='application_id' id='application_id' value=''>
	<input type='hidden' name='facility_id' id='facility_id' value=''>
	<input type='hidden' name='event_type_id' id='event_type_id' value=''>
	<input type='hidden' name='segment_type_id' id='segment_type_id' value=''>
	<input type='hidden' name='inboundapi_id' id='inboundapi_id' value=''>
	<input type='hidden' name='arg_serial_no' id='arg_serial_no' value=''>
	<input type='hidden' name='arg_id' id='arg_id' value=''>
	<input type='hidden' name='arg_name' id='arg_name' value=''>
	<input type='hidden' name='element_pos' id='element_pos' value=''>
	<input type='hidden' name='element_val' id='element_val' value=''>
	<input type='hidden' name='application_name' id='application_name' value=''>
	<input type='hidden' name='facility_name' id='facility_name' value=''>
	<input type='hidden' name='event_type' id='event_type' value=''>
	<input type='hidden' name='segment_type' id='segment_type' value=''>
	<input type='hidden' name='inboundapi_name' id='inboundapi_name' value=''> 
	<input type='hidden' name='exec_nature' id='exec_nature' value=''> 
	<input type='hidden' name='profile_id' id='profile_id' value=''> 
	<input type='hidden' name='profile_desc' id='profile_desc' value=''> 

</form>
</html>


