<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/DataGroupId.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="DATAGRPID_RESULTS" id="DATAGRPID_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			 
			// ???
			String qry_id = "DATAGROUPID";
			Connection conn = null;
 

			try
			{
				
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
//				request.setAttribute(XHQueryRender.col,"2");
				request.setAttribute(XHQueryRender.col,"7");
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
	<td colspan="4" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
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
	<a href='#' onClick='funModify(this)' dg_code='<%=arrCol.get(0)+""%>' dg_desc='<%=arrCol.get(1)+""%>' standard_code='<%=arrCol.get(2)+""%>'
	standard_desc='<%=arrCol.get(3)+""%>' application_id='<%=arrCol.get(4)+""%>'
	application_name='<%=arrCol.get(5)+""%>' protocol_mode='<%=arrCol.get(6)%>' > 
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=arrCol.get(1)+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XHDBAdapter.checkNull((String)arrCol.get(3))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XHDBAdapter.checkNull((String)arrCol.get(5))+""%>
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
    <input type='hidden' name='rule' id='rule' value='U' > 
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='dg_code' id='dg_code' value=''>
	<input type='hidden' name='dg_desc' id='dg_desc' value=''>

	<input type='hidden' name='standard_code' id='standard_code' value=''>
	<input type='hidden' name='standard_desc' id='standard_desc' value=''>
	<input type='hidden' name='application_id' id='application_id' value=''>
	<input type='hidden' name='application_name' id='application_name' value=''>
	<input type='hidden' name='comm_mode' id='comm_mode' value=''>
</form>
</html>


