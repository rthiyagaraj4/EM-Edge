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
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='javascript' src='../../eXH/js/ElementSegmentConfiguaration.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<form name="APPL_ELEMENT_SEGMENT_RESULTS" id="APPL_ELEMENT_SEGMENT_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "CONFIGUARATION";
			Connection conn = null;


			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"10");
//				request.setAttribute(XHQueryRender.maxRec,"21");
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
	//		System.out.println("ElmntSgmnt arrCol.get(0) : "+arrCol.get(0));

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
	<td class='COLUMNHEADER' width='25%'><fmt:message key="eXH.ConfigName.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='50%'><fmt:message key="eXH.ConfigType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.DataSourceType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SysDefStr.Label" bundle="${xh_labels}"/></td> 
</tr>
	<%
	//System.out.println("arrRow.size() : "+arrRow.size());
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
	<a href='#' onClick='funModify(this)' config_type='<%=arrCol.get(0)+""%>'		config_id='<%=arrCol.get(1)+""%>'
	query_text='<%=java.net.URLEncoder.encode((String)arrCol.get(2))+""%>' sysdef_str='<%=java.net.URLEncoder.encode((String)arrCol.get(3))+""%>'
		datasrc_type='<%=arrCol.get(4)+""%>' config_name='<%=arrCol.get(5)+""%>'
		stnd_code='<%=arrCol.get(6)+""%>'
		profile_id='<%=arrCol.get(7)+""%>'
		profile_desc='<%=arrCol.get(8)+""%>'
		stnd_desc='<%=arrCol.get(9)+""%>'> 
	<%=arrCol.get(5)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left">
	<%=arrCol.get(0)+""%>
	</td>
	<td <%=strTDClass%> align="center">
	<%
	out.println(XHDBAdapter.checkNull((String)arrCol.get(4)));
	%>
	</td>
	<td <%=strTDClass%> align="center">
	<%
	out.println(arrCol.get(3));
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
	<input type='hidden' name='config_id' id='config_id' value=''>
	<input type='hidden' name='config_name' id='config_name' value=''>
	<input type='hidden' name='config_type' id='config_type' value=''>
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='sysdef_str' id='sysdef_str' value=''>
	<input type='hidden' name='query_text' id='query_text' value=''>
	<input type='hidden' name='datasrc_type' id='datasrc_type' value=''>
	<input type='hidden' name='stnd_code' id='stnd_code' value=''>
	<input type='hidden' name='stnd_desc' id='stnd_desc' value=''>
	<input type='hidden' name='profile_id' id='profile_id' value=''>
	<input type='hidden' name='profile_desc' id='profile_desc' value=''>

	</form>
    </html>


