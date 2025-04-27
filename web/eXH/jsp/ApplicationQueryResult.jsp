<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />		
<meta charset="utf-8">

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/DomainApplication.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="ApplicationRslt" id="ApplicationRslt" method="POST" action=''  >

	<% 

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APPLICATION";
			Connection conn = null;


			try
			{
				
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"5");
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous";
				String strNext  = "Next";
				if (boolPrevious == true)
				{
					strPrevious = "Previous";
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next";
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
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
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
	<a href='#' onClick='funModify(this)' appl_id='<%=arrCol.get(0)+""%>' appl_name='<%=arrCol.get(1)+""%>' facility='<%=arrCol.get(2)+""%>'  enabled='<%=arrCol.get(3)+""%>' field_seperator='<%=arrCol.get(4)+""%>'>
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(1) %>
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
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='appl_id' id='appl_id' value=''>
	<input type='hidden' name='appl_name' id='appl_name' value=''>
	<input type='hidden' name='facility' id='facility' value=''>
	<input type='hidden' name='field_seperator' id='field_seperator' value=''>
	<input type='hidden' name='enabled' id='enabled' value=''>
	<input type='hidden' name='lang_id' id='lang_id' value=''>
</form>
</html>


