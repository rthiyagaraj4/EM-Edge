<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>  
<%@ page import="java.sql.*,java.util.*,eXB.*,webbeans.eCommon.ConnectionManager,eXB.XBDBAdapter,eXH.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src='../../eXB/js/XBExportFiles.js' ></script>
<script Language="JavaScript"  src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="EXPORTFILES_RESULTS" id="EXPORTFILES_RESULTS" method="POST" action=''  >

	<%
//          String module_desc = "";
			boolean boolToggle =  true;	
			String strTDClass = "";

			String qry_id = "EXPORTFILES";
			Connection conn = null;
			StringBuilder whereClause = new StringBuilder();
			String event_type = "";
			String sent_file_id = "";
			String sent_date = "";

			try
			{
				event_type	= XBDBAdapter.checkNull(request.getParameter("event_type"));
				sent_file_id = XBDBAdapter.checkNull(request.getParameter("sent_file_id"));
				sent_date = XBDBAdapter.checkNull(request.getParameter("sent_date"));
				String facilityID = XBDBAdapter.checkNull(request.getParameter("facilityID"));
				String referrenceNo = XBDBAdapter.checkNull(request.getParameter("referrenceNo"));
				String replyFileID = XBDBAdapter.checkNull(request.getParameter("replyFileID"));
				String replyDate = XBDBAdapter.checkNull(request.getParameter("replyDate"));				

				whereClause.append("WHERE A.EVENT_TYPE=B.EVENT_TYPE ");

				if(!XHUtil.isStrEmpty(event_type))
				{
					whereClause.append(" AND A.EVENT_TYPE = NVL('"+event_type+"',A.EVENT_TYPE)");
				}
				if(!XHUtil.isStrEmpty(sent_file_id))
				{
					whereClause.append(" AND UPPER(SENT_FILE_ID) like UPPER(NVL('"+sent_file_id+"',SENT_FILE_ID))||'%'  ");
				}
				if(!XHUtil.isStrEmpty(sent_date))
				{
					whereClause.append(" AND to_char(SENT_DATE,'DD/MM/YYYY') = to_char(to_date(NVL('"+sent_date+"',SENT_DATE),'dd/mm/yyyy'),'DD/MM/YYYY')  ");
				}
				if(!XHUtil.isStrEmpty(facilityID))
				{
					whereClause.append(" AND operating_facility_id = '");
					whereClause.append(facilityID);
					whereClause.append("'");
				}
				if(!XHUtil.isStrEmpty(referrenceNo))
				{
					whereClause.append(" AND doc_ref_num = '");
					whereClause.append(referrenceNo);
					whereClause.append("'");
				}
				if(!XHUtil.isStrEmpty(replyFileID))
				{
					whereClause.append(" AND reply_file_id = '");
					whereClause.append(replyFileID);
					whereClause.append("'");
				}
				if(!XHUtil.isStrEmpty(replyDate))
				{
					whereClause.append(" AND to_char(reply_date,'DD/MM/YYYY') = to_char(to_date(NVL('");
					whereClause.append(replyDate);
					whereClause.append("',reply_date),'dd/mm/yyyy'),'DD/MM/YYYY')  ");
				}

				request.setAttribute(XBQueryRender.strQueryId,qry_id);
				request.setAttribute(XBQueryRender.col,"8");
			    request.setAttribute(XHQueryRender.whereClause,whereClause.toString());
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XBQueryRender.getResults(request,session,conn);
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
					strNext = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
	alert(getMessage("XH1021","XH"));history.go(-1);
</script>

<% } else { %>
	<tr>
	<td colspan="8" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>
<tr>
	<td class='COLUMNHEADER' width='10%'>Event Type</td>
	<td class='COLUMNHEADER' width='20%'>Event Name</td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.DOC_REF_NO.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'>Sent File ID</td>
	<td class='COLUMNHEADER' width='10%'>Sent Date</td>	
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.REPLY_FILE_ID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.REPLY_DATE.Label" bundle="${xh_labels}"/></td>
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
	<a href='#' onClick='funModify(this)' event_type='<%=arrCol.get(0)+""%>' 
											event_name='<%=arrCol.get(1)+""%>' 
											sent_file_id='<%=arrCol.get(2)+""%>' 
											sent_date='<%=arrCol.get(3)+""%>'
											facilityID='<%=arrCol.get(4)+""%>' 
											referrenceNo='<%=arrCol.get(5)+""%>'
											replyFileID='<%=arrCol.get(6)+""%>' 
											replyDate='<%=arrCol.get(7)+""%>'>
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(1))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(4)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(4))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(5)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(5))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(2)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(2))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(3)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(3))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(6)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(6))+""%>
	</td>
	<td <%=strTDClass%> align="left">
		<%=XBDBAdapter.checkNull((String)arrCol.get(7)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(7))+""%>
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
		out.println("Error= "+e1);
		System.out.println("(XBExportFilesQueryResult.jsp:whereClause) "+whereClause);
		e1.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>

	<input type='hidden' name='mode' id='mode' value='U'>
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='event_type' id='event_type' value=''>
	<input type='hidden' name='event_name' id='event_name' value=''>
	<input type='hidden' name='sent_file_id' id='sent_file_id' value=''>
	<input type='hidden' name='sent_date' id='sent_date' value=''>
	<input type='hidden' name='facilityID' id='facilityID' value=''>
	<input type='hidden' name='referrenceNo' id='referrenceNo' value=''>
	<input type='hidden' name='replyFileID' id='replyFileID' value=''>
	<input type='hidden' name='replyDate' id='replyDate' value=''>

</form>
</html>


