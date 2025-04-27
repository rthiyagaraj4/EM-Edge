<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager,eXH.*,java.net.URLEncoder,java.util.*" %> 
<%@ page contentType="text/html;charset=UTF-8" %>


<HEAD>

<%
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>

<style>		
	.testSty
	{
		width:expression(document.getElementById("hiddenTable").clientWidth-document.getElementById("left_child").clientWidth);		
	}
</style>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/messages.js" ></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewDebugInformation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<table width="100%" id="hiddenTable"><tr><td></td></tr></table>

<%
Connection dbConn = null;
Statement stmt = null;
ResultSet rs = null;

String whereClause = "";
String [] pgmList = null;
String [] clientList = null;
String fromDate = null;
String toDate = null;
String strClient = null;
String strPGM = null;
StringBuffer tempBuf = null;
String strTDClass = "";

boolean boolToggle =  true;	
boolean flag = false;

try
{
	fromDate = XHDBAdapter.checkNull(request.getParameter("fromDate"));
	toDate = XHDBAdapter.checkNull(request.getParameter("toDate"));
	pgmList = request.getParameterValues("pgmID");
	clientList = request.getParameterValues("clientID");	

	tempBuf = new StringBuffer();
	for(int i=0;i<pgmList.length;i++)
	{	
		tempBuf = tempBuf.append("'"+pgmList[i]+"',");		
	}

	strPGM = tempBuf.toString();	
	strPGM = strPGM.substring(0,strPGM.length()-1);	
	tempBuf.delete(0,tempBuf.length());
	
	for(int i=0;i<clientList.length;i++)
	{		
		tempBuf = tempBuf.append("'"+clientList[i]+"',");
	}
	strClient = tempBuf.toString();
	strClient = strClient.substring(0,strClient.length()-1);
	tempBuf.delete(0,tempBuf.length());

	//System.out.println("PGM LIST "+strPGM);
	//System.out.println("CLIENT LIST "+strClient);

	if(strPGM != null && !strPGM.equals("''"))
	{
		flag = true;
		whereClause = whereClause+" WHERE pgm_id IN ("+strPGM+")";
	}
	
	if(strClient != null && !strClient.equals("") && !strClient.equals("'ALL'"))
	{
		if(flag) whereClause = whereClause+" AND machineid IN ("+strClient+")";
		else whereClause = whereClause+" WHERE machineid IN ("+strClient+")";
	}

	if(fromDate != null && !fromDate.equals(""))
	{
		if(flag) 
		{
			if(toDate != null && !toDate.equals(""))
			{
				whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
			}
			else
			{
				whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS'))";
			}
		}
		else 
		{
			if(toDate != null && !toDate.equals(""))
			{
				whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
			}
			else
			{
				whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS'))";
			}
		}
	}

	//System.out.println("whereClause "+whereClause);

	request.setAttribute(XHQueryRender.strQueryId,"VIEW_TRACE_EVENTS");	
	request.setAttribute(XHQueryRender.col,"4");
	request.setAttribute(XHQueryRender.maxRec,"10");
	request.setAttribute(XHQueryRender.whereClause,whereClause);	
	dbConn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,dbConn);	
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	//String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	//String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	String strPrevious = "Previous";
	String strNext  = "Next";

	if (boolPrevious == true)
	{
//		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		strPrevious = "Previous";
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
//		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		strNext = "Next";
	}
	else
	{
		strNext  = " ";
	}	
%>
<FORM name="debugResultsForm" id="debugResultsForm" ID="debugResultsForm" method="post">
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('XH1021'));
</script>

<% } else { %>
	<TABLE WIDTH="100%">
		<TR>
			<TD align="right" class="CAGROUP" > 
			<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
			<A class='label'  onClick="funAction('N')" style='cursor:pointer'><%=strNext %></A>
			</TD>
		</TR>
	</TABLE>
	<TABLE CELLSPACING="0" CELLPADDING="4" BORDER="1" >
	<TR>
		<TD class='COLUMNHEADER' WIDTH="20%">PGM ID</TD>
		<TD class='COLUMNHEADER' WIDTH="15%">Machine Name</TD>
		<TD class='COLUMNHEADER' WIDTH="10%">Transaction Date</TD>
		<TD class='COLUMNHEADER' WIDTH="55%">Text</TD>
	</TR>
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
	<TR>
		<TD <%=strTDClass%>><%= XHDBAdapter.checkNull((String)arrCol.get(0))%></TD>
		<TD <%=strTDClass%>><%= XHDBAdapter.checkNull((String)arrCol.get(3))%></TD>
		<TD <%=strTDClass%>><%= XHDBAdapter.checkNull((String)arrCol.get(2))%></TD>
		<TD <%=strTDClass%> NOWRAP>
			<a href="#" onClick="return showText('<%=URLEncoder.encode(XHDBAdapter.checkNull((String)arrCol.get(1)))%>')">
			<%= XHDBAdapter.checkNull((String)arrCol.get(1))%></a>
		</TD>
	</TR>
<%
	}
}
%>
</TABLE>
<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	try
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}
%>

</BODY>
<INPUT TYPE="hidden" name="action_type" id="action_type" ID="action_type" VALUE="">
<INPUT TYPE="hidden" name="sortMode" id="sortMode" ID="sortMode" VALUE="">
<INPUT TYPE="hidden" name="pgmID" id="pgmID" ID="pgmID" VALUE="<%=pgmList%>">
<INPUT TYPE="hidden" name="clientID" id="clientID" ID="clientID" VALUE="<%=clientList%>">
<INPUT TYPE="hidden" name="strPGM" id="strPGM" ID="strPGM" VALUE="<%=strPGM%>">
<INPUT TYPE="hidden" name="strClient" id="strClient" ID="strClient" VALUE="<%=strClient%>">
<INPUT TYPE="hidden" name="fromDate" id="fromDate" ID="fromDate" VALUE="<%=fromDate%>">
<INPUT TYPE="hidden" name="toDate" id="toDate" ID="toDate" VALUE="<%=toDate%>">
<INPUT TYPE="hidden" name="mode" id="mode" ID="mode" VALUE="test">
</FORM>

</HEAD>
</HTML>

