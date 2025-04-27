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
<script language='javascript' src='../../eXH/js/QueryBasedInbound.js'></script> 
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="APPL_RESULTS" id="APPL_RESULTS" method="POST" action=''  >

	<%
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "QUERYBASEDINBOUND";
			Connection conn = null;
			String dgcode = "";
			String whereClause = "WHERE  ";

			whereClause	=	whereClause+"A.APPLICATION_ID=C.APPLICATION_ID AND "+
			"A.FACILITY_ID=D.FACILITY_ID AND A.EVENT_TYPE=E.EVENT_TYPE "+
			"AND A.SEGMENT_ID=F.SEGMENT_TYPE AND A.INBOUND_API=B.API_CODE AND "+
			"D.language_id='en' ";

			//System.out.println("QueryResult "+whereClause);
			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
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
	<td colspan="10" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.SegmentName.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.SerialNo.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.InsertQuery.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.UpdateQuery.Label" bundle="${xh_labels}"/></td>
	
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
		//System.out.println("API Rslt arrCol.get(12) : "+arrCol.get(11));
		//System.out.println("APi elmnt_id : "+XHDBAdapter.checkNull((String)arrCol.get(6)));
	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' application_id='<%=arrCol.get(0)+""%>' 
	facility_id='<%=arrCol.get(1)+""%>'	event_type_id='<%=arrCol.get(2)+""%>' segment_type_id='<%=arrCol.get(3)+""%>' inboundapi_id='<%=arrCol.get(4)+""%>'	srl_no='<%=arrCol.get(5)+""%>'	insert_Query='<%=XHDBAdapter.checkNull((String)arrCol.get(6))+""%>'
	update_Query='<%=XHDBAdapter.checkNull((String)arrCol.get(7))+""%>'	inboundapi_name='<%=arrCol.get(8)+""%>' application_name='<%=arrCol.get(9)+""%>' facility_name='<%=arrCol.get(10)+""%>' event_type='<%=arrCol.get(11)+""%>'
	segment_type='<%=arrCol.get(12)+""%>'>
	<%=arrCol.get(9)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(10) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(11) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(12) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(8) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(5) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(6)) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(7)) %>
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
	<input type='hidden' name='srl_no' id='srl_no' value=''>
	<input type='hidden' name='insert_Query' id='insert_Query' value=''>
	<input type='hidden' name='update_Query' id='update_Query' value=''>
	<input type='hidden' name='application_name' id='application_name' value=''>
	<input type='hidden' name='facility_name' id='facility_name' value=''>
	<input type='hidden' name='event_type' id='event_type' value=''>
	<input type='hidden' name='segment_type' id='segment_type' value=''>
	<input type='hidden' name='inboundapi_name' id='inboundapi_name' value=''>




<!--

	<input type='hidden' name='dgcode' id='dgcode' value=<%=dgcode%>>

	-->
</form>
</html>


