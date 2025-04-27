<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/DataGroupId.js'></script> 
<!--
<script language='javascript' src='../../eXH/js/DataGroupIdDetails.js'></script> 
-->
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="DATAGRPDTL_RESULTS" id="DATAGRPDTL_RESULTS" method="POST" action=''  > 

	<%
 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "DATAGROUPDETAILS";
			Connection conn = null;
			String dgcode = "";
			String whereClause = "WHERE  ";
			
			whereClause	=	whereClause+"A.DATA_GROUP_ID=B.DATA_GROUP_ID AND 			A.APPLICATION_ID=C.APPLICATION_ID and A.FACILITY_ID=D.FACILITY_ID AND A.MESSAGE_TYPE=F.MESSAGE_TYPE AND A.EVENT_TYPE=E.EVENT_TYPE and A.EVENT_TYPE=G.EVENT_TYPE AND A.SEGMENT_TYPE=H.SEGMENT_TYPE 	AND			D.LANGUAGE_ID='en' ";
			
			try
			{
				dgcode=request.getParameter("dgcode");
				

				if(!(dgcode.equals(" ")))			
				{					
				  whereClause =whereClause + " AND A.DATA_GROUP_ID = NVL('#dgcode',A.DATA_GROUP_ID)";
 				} 

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"15");
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
					strPrevious =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
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
<table border=1 cellspacing=0 cellpadding=4 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('XH1021','XH'));
</script>

<% } else { %>
	<tr>
	<td colspan="6" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
<!--	<td class='COLUMNHEADER'  width='5%'>Serial No</td> -->
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<!---<td class='COLUMNHEADER'  width='25%'>Segment Type</td>-->
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.FilterRules.Label" bundle="${xh_labels}"/></td>	
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
		
		String filtr_rule = "";
		if(arrCol.get(13).equals("R")){
		    filtr_rule = "Restricted";
		}
		else if(arrCol.get(13).equals("U")){
		    filtr_rule = "Un-Restricted";
		}

	%>
	<tr>
<!--	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' srl_no='<%=arrCol.get(0)+""%>' dg_code='<%=arrCol.get(1)+""%>'	application_id='<%=arrCol.get(2)+""%>' facility_id='<%=arrCol.get(3)+""%>'	mesg_type_id='<%=arrCol.get(4)+""%>' event_type_id='<%=arrCol.get(5)+""%>' segment_type_id='<%=arrCol.get(6)+""%>'
	dg_desc='<%=arrCol.get(7)+""%>'	application_name='<%=arrCol.get(8)+""%>'
	facility_name='<%=arrCol.get(9)+""%>'	mesg_type='<%=arrCol.get(10)+""%>'
	event_type='<%=arrCol.get(11)+""%>'	segment_type='<%=arrCol.get(12)+""%>'
	filter_rule_type='<%=arrCol.get(13)+""%>' protocol_link_id='<%=XHDBAdapter.checkNull((String)arrCol.get(14))+""%>'>
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td> -->
		<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' srl_no='<%=arrCol.get(0)+""%>' dg_code='<%=arrCol.get(1)+""%>'	application_id='<%=arrCol.get(2)+""%>' facility_id='<%=arrCol.get(3)+""%>'	mesg_type_id='<%=arrCol.get(4)+""%>' event_type_id='<%=arrCol.get(5)+""%>' segment_type_id='<%=arrCol.get(6)+""%>'
	dg_desc='<%=arrCol.get(7)+""%>'	application_name='<%=arrCol.get(8)+""%>'
	facility_name='<%=arrCol.get(9)+""%>'	mesg_type='<%=arrCol.get(10)+""%>'
	event_type='<%=arrCol.get(11)+""%>'	segment_type='<%=arrCol.get(12)+""%>'
	filter_rule_type='<%=arrCol.get(13)+""%>' protocol_link_id='<%=XHDBAdapter.checkNull((String)arrCol.get(14))+""%>'>
	<%=arrCol.get(9) +""%>
	</a>
	</b>
	</td>
<!--	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(9) %>
	</td> -->
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(10) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(11) %>
	</td>
	<%---<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(12) %>----%>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=filtr_rule%>
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
	<input type='hidden' name='srl_no' id='srl_no' value=''>
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
	<input type='hidden' name='filter_rule_type' id='filter_rule_type' value=''>	
	<input type='hidden' name='dgcode' id='dgcode' value=<%=dgcode%>>

	
</form>
</html>


