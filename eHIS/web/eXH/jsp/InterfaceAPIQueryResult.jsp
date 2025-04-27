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
<script language='javascript' src='../../eXH/js/InterfaceAPI.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="INTERFACEAPI_RESULTS" id="INTERFACEAPI_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "INTERFACEAPI";
			Connection conn = null;


			try
			{
				
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"4");
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
	<td colspan="3" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.APIType.Label" bundle="${xh_labels}"/></td>
	
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
	<a href='#' onClick='funModify(this)' api_code='<%=arrCol.get(0)+""%>'
	api_desc='<%=arrCol.get(1)+""%>' api_type='<%=arrCol.get(2)+""%>'
	exec_nature='<%=arrCol.get(3)+""%>' 
	>
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(1) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(2) %>
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
	<input type='hidden' name='api_code' id='api_code' value=''>
	<input type='hidden' name='api_desc' id='api_desc' value=''>
	<input type='hidden' name='api_type' id='api_type' value=''>
	<input type='hidden' name='exec_nature' id='exec_nature' value=''>

</form>
</html>


