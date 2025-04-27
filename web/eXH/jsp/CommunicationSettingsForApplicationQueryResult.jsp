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
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='javascript' src='../../eXH/js/CommnSettingsForApplication.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name="APPL_COMMUNICATION_RESULTS" id="APPL_COMMUNICATION_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APPLICATION_COMMUNICATION";
			Connection conn = null;


			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"6");
				request.setAttribute(XHQueryRender.maxRec,"21");
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
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center >
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
</script>

<% } else { %>

	<tr>
	<td colspan="4" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER width='50%'><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER width='25%'><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER width='10%'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER width='10%'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></td>
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
	<a href='#' onClick='funModify(this)' appl_id='<%=arrCol.get(0)+""%>' fac_id='<%=arrCol.get(1)+""%>'> 
	<%=arrCol.get(4)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left">
	<%=arrCol.get(5)+""%>
	</td>


	<td <%=strTDClass%> align="center">
	<%
	out.println(arrCol.get(2).equals("Y")?"<img src='../../eCommon/images/enabled.gif' >":"<img src='../../eCommon/images/disabled.gif'>");
	%>
	</td>

	<td <%=strTDClass%> align="center">
	<%
	out.println(arrCol.get(3).equals("Y")?"<img src='../../eCommon/images/enabled.gif' >":"<img src='../../eCommon/images/disabled.gif'>");
	%>
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
	<input type='hidden' name='appl_name' id='appl_name' value=''>
	<input type='hidden' name='facility' id='facility' value=''>
	<input type='hidden' name='action_type' id='action_type' value=''>
	</form>
    </html>


