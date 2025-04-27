<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% 
String locale = ((String)session.getAttribute("LOCALE"));
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function callSort   
function callSort(obj) 
{ 
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	 
   this.document.forms[0].orderbycolumns.value=obj;
 
   this.document.forms[0].action='../../eXH/jsp/ViewMsgReviewAuditLog.jsp';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();
}
//function funShow
function funShow(obj)
{
	this.document.forms[0].STATUS_TEXT.value = obj.getAttribute('STATUS_TEXT');
	this.document.forms[0].MESSAGE_TEXT.value = obj.getAttribute('MESSAGE_TEXT');	
		
	var act = '../../eXH/jsp/ViewMsgAuditLogMsgstatus.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
}
//function funSubmit
function funSubmit()
{
	var act = '../../eXH/jsp/ViewMsgReviewAuditLog.jsp?';
	this.document.forms[0].action = act;
	document.forms[0].sortMode.value="A";
	this.document.forms[0].target='auditlogFrame';
	this.document.forms[0].submit();	
}
//function funAction
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	//parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	funSubmit();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' method="post">
<%
boolean boolToggle =  true;	
String strTDClass = "";
String purge_status = request.getParameter("purge_status");
String moduleID = request.getParameter("sub_module");
String tableName = "APPL_MSG_AUDIT_VW";

String qry_id = "VIEWAUDITLOG";

if(purge_status != null && purge_status.equalsIgnoreCase("OFFLINE"))
{
	qry_id = "VIEWAUDITLOGOFFLINE";
	tableName = "OFFLINE_" + tableName;
}
else if(purge_status != null && purge_status.equalsIgnoreCase("PURGE"))
{
	qry_id = "VIEWAUDITLOGPURGE";
	tableName = "PURGE_" + tableName;
}

tableName = moduleID + "_" + tableName;

Connection conn = null;
try
{
	request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.col,"12");
	request.setAttribute("tableName", tableName);
	request.setAttribute(XHQueryRender.maxRec,"3");
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
	String appl_name = request.getParameter("appl_name"); 
	String facility = request.getParameter("facility");
	String event_type = request.getParameter("event_type");
	String msg_type = request.getParameter("msg_type"); 
	String status = request.getParameter("status"); 
	String msg_id = request.getParameter("msg_id");
	String amsg_dt1 = request.getParameter("amsg_dt1");
	String amsg_dt2 = request.getParameter("amsg_dt2");
	String mode = request.getParameter("sortMode");	
	String commMode = request.getParameter("commMode");


//System.out.println("facility"+facility+"appl_name :"+appl_name+"msg_type :"+msg_type+"status :"+status+"amsg_dt1 :"+amsg_dt1+"amsg_dt2 :"+amsg_dt2+"commMode :"+commMode);


%>


<form name="viewmsg_audit_logdtl_form" id="viewmsg_audit_logdtl_form">

<input type="hidden" name=appl_name id=appl_name value='<%=appl_name%>' />
<input type="hidden" name=facility id=facility value='<%=facility%>' />
<input type="hidden" name=event_type id=event_type value='<%=event_type%>' />
<input type="hidden" name=msg_type id=msg_type value='<%=msg_type%>' />
<input type="hidden" name=status id=status value='<%=status%>' />
<input type="hidden" name=msg_id id=msg_id value='<%=msg_id%>' />
<input type="hidden" name=amsg_dt1 id=amsg_dt1 value='<%=amsg_dt1%>' />
<input type="hidden" name=amsg_dt2 id=amsg_dt2 value='<%=amsg_dt2%>' />
<input type="hidden" name="action_type" id="action_type" value='S'/>

<input type="hidden" name="MESSAGEID" id="MESSAGEID" id=" MESSAGEID" value=""/>
<input type="hidden" name="FACILITYID" id="FACILITYID" id="FACILITYID" value=""/>
<input type="hidden" name="FACILITYNAME" id="FACILITYNAME" id="FACILITYNAME" value=""/>
<input type="hidden" name="PROCESSDATETIME" id="PROCESSDATETIME" id="PROCESSDATETIME" value=""/>
<input type="hidden" name="EVENTTYPE" id="EVENTTYPE" id="EVENTTYPE" value=""/>
<input type="hidden" name="PROCESSID" id="PROCESSID" id="PROCESSID" value=""/>
<input type="hidden" name="PROCESSEDBY" id="PROCESSEDBY" id="PROCESSEDBY" value=""/>
<input type="hidden" name="ENDDATETIME" id="ENDDATETIME" id="ENDDATETIME" value=""/>
<input type="hidden" name="COMMRETRIES" id="COMMRETRIES" id="COMMRETRIES" value=""/>
<input type="hidden" name="MSGSTATUS" id="MSGSTATUS" id="MSGSTATUS" value=""/>
<input type="hidden" name="STATUS_TEXT" id="STATUS_TEXT" id="STATUS_TEXT" value=""/>
<input type="hidden" name="MESSAGE_TEXT" id="MESSAGE_TEXT" id="MESSAGE_TEXT" value=""/>
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=''/>
<input type="hidden" name="sortMode" id="sortMode" id="sortMode2"/>
<input type="hidden" name="sortMode1" id="sortMode1" id="sortMode1" value='<%=mode%>'/>
<input type="hidden" name="locale" id="locale" id="locale" value='<%=locale%>'/>
<input type="hidden" name="purge_status" id="purge_status" id="purge_status" value='<%=purge_status%>'/>
<input type="hidden" name="commMode" id="commMode" id="commMode" value='<%=commMode%>'/>

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td class='COLUMNHEADER' colspan="10" align="center"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>

</tr>

<%
if(arrRow.size()==0)
{
%>
<tr>
<td colspan="7" align="left" class="CAGROUP"> 
<script>
//alert(getMessage('XH0082'));
document.write(getMessage('XH0082','XH'));
//window.close();
</script>
</td>
</tr>

<% } else { %>

<tr>
	
	<td colspan="10" align="right" class="CAGROUP"> 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><u><%=strPrevious%></u></A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'><u><%=strNext%></u></A>
	</td>
	
	</tr>
 
<tr>
	<td class='COLUMNHEADER' nowrap align="center"><a name='MESSAGE_ID' id='MESSAGE_ID' href="javascript:callSort('MESSAGE_ID');" ><font color=white><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></font></td> 
	<td class='COLUMNHEADER' nowrap align="center"><a name='FACILITY_ID' id='FACILITY_ID'  href="javascript:callSort('FACILITY_ID');" ><font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font></td>
	<td class='COLUMNHEADER' nowrap align="center"><a name='STATUS' id='STATUS'  href="javascript:callSort('STATUS');" ><font color=white><fmt:message key="Common.action.label" bundle="${common_labels}"/></font></td>
   	<td class='COLUMNHEADER'  nowrap align="center"><a name='PROCESS_DATE_TIME' id='PROCESS_DATE_TIME' href="javascript:callSort('PROCESS_DATE_TIME');" ><font color=white><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></font></td>
	<td class='COLUMNHEADER' nowrap align="center"><a name='PROCESSED_BY' id='PROCESSED_BY'  href="javascript:callSort('PROCESSED_BY');" ><font color=white><fmt:message key="Common.action.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/></font></td>
	<td class='COLUMNHEADER' nowrap align="center"><a name='EVENT_TYPE' id='EVENT_TYPE'  href="javascript:callSort('EVENT_TYPE');" ><font color=white><fmt:message key="Common.Event.label" bundle="${common_labels}"/></font></td>		
	<td class='COLUMNHEADER' nowrap align="center"><a name='STATUS' id='STATUS'  href="javascript:callSort('STATUS');" ><font color=white><fmt:message key="Common.Old.label" bundle="${common_labels}"/> <fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></font></td>
	<%if(commMode != null && commMode.equals("O")){%>
	<td class='COLUMNHEADER' nowrap align="center"><a name='END_DATE_TIME' id='END_DATE_TIME'  href="javascript:callSort('END_DATE_TIME');" ><font color=white><fmt:message key="eXH.OldCommDateTime.Label" bundle="${xh_labels}"/> </font></td>
	<td class='COLUMNHEADER' nowrap align="center"><a name='COMM_RETRIES' id='COMM_RETRIES'  href="javascript:callSort('COMM_RETRIES');" ><font color=white><fmt:message key="eXH.Retries.Label" bundle="${xh_labels}"/></font></td>
<%}%>
	<td class='COLUMNHEADER' nowrap align="center"><a id='PROCESS_ID' id='PROCESS_ID'  href="javascript:callSort('PROCESS_ID');" ><font color=white><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></font></td>    
	
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

String msgid = ((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);

String status_msg="";
String int_status="";
status_msg=(String)arrCol.get(9);
if(status_msg.equalsIgnoreCase("S")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.TransferSuccessful.Label","xh_labels");
	int_status = "Successful";
}
else if(status_msg.equalsIgnoreCase("F"))
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.TransferFailed.Label","xh_labels");
	int_status = "Failed";
}
else if(status_msg.equalsIgnoreCase("R")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
	int_status = "Rejected";
}
else if(status_msg.equalsIgnoreCase("A")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Acknowledged.Label","xh_labels");
	int_status = "Accepted";
}
else if(status_msg.equalsIgnoreCase("") || status_msg.equalsIgnoreCase("null")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	int_status = "Pending";
}
else if(status_msg.equalsIgnoreCase("E")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	int_status = "Error";
}
else if(status_msg.equalsIgnoreCase("L")) 
{
//	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	int_status = "Loaded";
}

String processDate="";
String strProcessDate="";
processDate=((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
if(!processDate.equals("")) 
{
//	strProcessDate = com.ehis.util.DateUtils.convertDate(processDate,"DMYHMS","en",locale);
	strProcessDate = processDate;
}

String endDate="";
String strendDate="";
endDate=((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);
if(!endDate.equals("")) 
{
//	strendDate = com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
	strendDate = endDate;
}

%>
<tr>
<td <%=strTDClass%> align="center">
	<font size=1>
	<%---<a href='#' onClick='funShow(this)' 
				MESSAGEID='<%=arrCol.get(0)+""%>' FACILITYID='<%=arrCol.get(1)+""%>'  
				FACILITYNAME='<%=arrCol.get(2)+""%>' PROCESSDATETIME='<%=arrCol.get(3)+""%>' 
				EVENTTYPE='<%=arrCol.get(4)+""%>' PROCESSID='<%=arrCol.get(5)+""%>'  
				PROCESSEDBY='<%=arrCol.get(6)+""%>' ENDDATETIME='<%=arrCol.get(7)+""%>'
				COMMRETRIES='<%=arrCol.get(8)+""%>' MSGSTATUS ='<%=arrCol.get(9)+""%>' 
				MESSAGE_TEXT ='<%=arrCol.get(11)+""%>'STATUS_TEXT ='<%=arrCol.get(10)+""%>'>----%>
		<%=msgid%>
	</a>
	</font>
</td>
<td <%=strTDClass%> nowrap>&nbsp;<font size=1><%=((String)arrCol.get(2)).equals("null")?"":arrCol.get(2)%></font></td>
<td <%=strTDClass%> nowrap>&nbsp;<font size=1><%=""+arrCol.get(10)%></font></td>
<td <%=strTDClass%> nowrap>&nbsp;<font size=1><%=""+strProcessDate%></font></td>
<td <%=strTDClass%> nowrap>&nbsp;<font size=1><%=((String)arrCol.get(6)).equals("null")?"":arrCol.get(6)%></font></td>
<td <%=strTDClass%> nowrap align="center">&nbsp;<font size=1><%=((String)arrCol.get(4)).equals("null")?"":arrCol.get(4)%></font></td>
<td <%=strTDClass%> nowrap>&nbsp;<font size=1><%=""+int_status%></font></td>
<%if(commMode != null && commMode.equals("O")){%>
	<td <%=strTDClass%>>&nbsp;<font size=1><%=""+strendDate%></font></td>
	<td <%=strTDClass%> align="center">&nbsp;<font size=1><%=((String)arrCol.get(8)).equals("null")?"":arrCol.get(8)%></font></td>
<%}%>
<td <%=strTDClass%> nowrap align="center">&nbsp;<font size=1><%=((String)arrCol.get(5)).equals("null")?"":arrCol.get(5)%></font></td>
</tr>
<%
}
}
if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear();
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

</form>	
</BODY>
</HTML>

