<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language='JavaScript'>
// function funSubmit
function funSubmit()
{
	var act = '../../eXH/jsp/CommunicationSettingsForClientQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
	
}
// function funModify
function funModify(obj)
{
    this.document.forms[0].client_id.value = obj.getAttribute('client_id');
	var act = '../../eXH/jsp/CommunicationClientMaster.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
// function funAction
function funAction(typ)
{ 
	this.document.forms[0].action_type.value = typ;
	funSubmit();
}
// 
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
				    
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="CLIENT_COMMUNICATION_RESULTS" id="CLIENT_COMMUNICATION_RESULTS" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			String qry_id = "CLIENT_COMMUNICATION";
			Connection conn = null;
			String inboundYN = "";
			String outboundYN = "";

			try
			{
				String comm_type = request.getParameter("comm_type");

				// setting the communication type as per the database columns
				if(comm_type != null && comm_type.equalsIgnoreCase("I"))
				{
					inboundYN = "Y";
					outboundYN = "";
				}
				else if(comm_type != null && comm_type.equalsIgnoreCase("O"))
				{
					inboundYN = "";
					outboundYN = "Y";
				}
				else
				{
					inboundYN = "";
					outboundYN = "";
				}
				request.setAttribute("OUTBOUND_YN",outboundYN);
				request.setAttribute("INBOUND_YN",inboundYN);

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				request.setAttribute(XHQueryRender.col,"4");
				request.setAttribute(XHQueryRender.maxRec,"20");
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
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center >
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
history.go(-1);
</script>

<% } else { %>
	<tr>
	<td class="CAGROUP" >&nbsp;</td>
	<td colspan="2" align="right" class="CAGROUP">&nbsp; 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'width='70%'><fmt:message key="eXH.Client.Label" bundle="${xh_labels}"/></td>
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
	<a href='#' onClick='funModify(this)' client_id='<%=arrCol.get(0)+""%>' > 
	<%=arrCol.get(1)+""%>
	</a>
	</b>
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
		out.println("(CommunicationSettingsForClientQueryResult:Exception) "+e1);
		e1.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>


	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='client_id' id='client_id' value=''>
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type="hidden" name=locale id=locale value='<%=locale%>'/>
</form>
</html>


