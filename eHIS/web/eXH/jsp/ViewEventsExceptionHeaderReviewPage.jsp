<!DOCTYPE html>
<HTML>

<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eXH/js/ViewServerProcessErrors.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

<Script>													 
function breakFun()    																		   
{ 

//  document.getElementById("check").style.wordBreak='break-all';  
	
	
}
</script>

<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()' onLoad='breakFun();'>
<%

Connection dbConn = null;
Statement stmt = null; 
ResultSet rs = null;
boolean boolToggle =  true;	
String strTDClass = "";
String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String protocolMode	 = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
//String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
String messageText = "";
String errMsg = "";
String statusTxt = "";
String sqlQuery = "";
String Acc_number="";
String inboundAckMsg = "";
String eventTableName = "XH_EVENT"; 
String tableNameSuffix="";
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
try
{
	dbConn = ConnectionManager.getConnection(request);
}
catch(Exception w)
{
}
//String whereClause=" where message_id='"+msgID+"' "; 
try
{ 
	
	if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
	else
	{
		tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
//System.out.println("whereClause 65:"+whereClause);
  String posi=XHDBAdapter.checkNull(request.getParameter("posi")); 
	request.setAttribute("tableName",tableNameSuffix); 
	request.setAttribute("action_type","Q");  
	request.setAttribute("qry_id","VIEW_GENERAL_EVENTS");    
	request.setAttribute("whereClause",whereClause);  
	request.setAttribute("maxRec","1"); 
	//request.setAttribute(XHViewQueryControllerElementBean.maxRec,1);   
	XHViewQueryControllerElementBean	xhBean =
	XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
	xhBean.action(request,dbConn);
	HashMap resultsQry  = xhBean.getPositionRecord(posi);  
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result");  
  ArrayList arrCol = null;  
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious =  "Previous";
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
	strNext  = "Next";;
  }
  else
  {
	strNext  = " ";
  }

 %>

<%
if(arrRow.size()==0) 
{
%>
<script>
alert(getMessage('XH1021','XH'));
</script>
<% } else { %>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center border=1>
<tr>
<td class='COLUMNHEADER' colspan="10" align="center"><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></td>

</tr>

</table>  
<div id="right_child"  scrolling='no'>
<table id="table2" cellspacing=0 cellpadding=3 border=0 scrolling='no'>

<tr>
<td width='8%'></td>
<td width='8%'></td>
<td width='12%'></td>
</tr>
<%
	
for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j); 

  if(j%2==0)
	{
		strTDClass = "class='QRYEVEN'";
	boolToggle =  false;
	
	}
	else
	{ 
		strTDClass = "class='QRYODD'";
	boolToggle =  true;
 													    
	}		 						   

		String statusColor="";
		String status =((String)arrCol.get(16)).equals("null")?"":(String)arrCol.get(16);
		status=status.trim();		
		if(status.equalsIgnoreCase("S"))  
		{			
		statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.SuccessfullyProcessed.Label","xh_labels");
		}
		if(status.equalsIgnoreCase("N"))  statusColor="";
		if(status.equalsIgnoreCase("E"))   
		{
			statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
		}
		if(status.equalsIgnoreCase("A"))  statusColor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.AbouttoSplit.Label","xh_labels") ;
		if(status.equalsIgnoreCase(""))  statusColor = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Unprocessed.Label","xh_labels"); 
 
		String Last_Processed_date="";
		String mstatus =((String)arrCol.get(24)).equals("null")?"":(String)arrCol.get(24);
		mstatus = mstatus.trim();
		String startDate=((String)arrCol.get(15)).equals("null")?"":(String)arrCol.get(15); 
		if(!startDate.equals("")) 
		//	Last_Processed_date =com.ehis.util.DateUtils.convertDate(startDate,"DMYHMS","en",locale);
		Last_Processed_date =startDate;
		String Message_Date=""; 
		String	queryDate = ((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
		if(!queryDate.equals("")) 
			//Message_Date = com.ehis.util.DateUtils.convertDate(queryDate,"DMYHMS","en",locale);
			Message_Date = queryDate;
			Message_Date = XHUtil.convertToDate(queryDate,"dd/MM/yyyy hh:mm:ss");	
			Acc_number=XHDBAdapter.checkNull((String)arrCol.get(12));
		//XHDBAdapter.checkNull((String)arrCol.get(12))/
%>
<tr> 
<td >												    
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td width='5%'>
</td>
<td width='5%'>
</td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>  <td nowrap ><B><font color='black'  size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(1))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><font color='black'  size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(7))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 
<td nowrap><B><font color='black'  size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(4))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td> 
<td nowrap ><B><font color='black'  size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(26))%></font></B></td>
</tr>
<tr>  
<td class="label" nowrap > 
		<fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/>
		</td>  
		<td nowrap ><B><font color='black'  size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(2))%></font></B></td>
	  </tr>
	  <tr>
       <td class="label" nowrap>
		<fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/>
		</td>		
        <td nowrap ><B><font color='black'  size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(3))%></font></B></td>
</tr>
 									    
  
<tr>
<td class="label" nowrap><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>   
<td nowrap ><B><font color='black'  size=1.8pt><%if(mstatus.equalsIgnoreCase("S"))
	{%><fmt:message key="eXH.Sucessfull.Label" bundle="${xh_labels}"/><%}else if(mstatus.equalsIgnoreCase("E")){%><fmt:message key="eXH.TransmissionError.Label" bundle="${xh_labels}"/><%}else if(mstatus.equalsIgnoreCase("A")){ %>
 <fmt:message key="Common.Accept.label" bundle="${common_labels}"/><%}else if(mstatus.equalsIgnoreCase("R")){ %>
 <fmt:message key="Common.Rejected.label" bundle="${common_labels}"/><%}else{ %><fmt:message key="Common.Pending.label" bundle="${common_labels}"/><%}%></font></B></td>
</tr>
<tr> 
<td class="label" nowrap><fmt:message key="Common.EventStatus.label" bundle="${common_labels}"/></td>  
<td nowrap ><B><font color='black'  size=1.8pt><%=""+statusColor%></font></B></td>
</tr>
 </table>
</div> 
</td> 
<td >
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td width='5%'>
</td>
<td width='5%'>
</td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td> 
		 <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(5))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td> 
       <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(10))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td> 
       <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(11))%></font></B></td>
</tr> 
<tr>
<td class="label" nowrap><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td> 
       <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(9))%></font></B></td>
</tr>
<tr>   
<td class="label" nowrap><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></td>  
      <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(14))%></font></B></td>
	  </tr>
	 <tr>
<td  class="label" nowrap><fmt:message key="eXH.LastProcessedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black' size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(3))%></font></B></td> 
</tr>
<tr>
<td  nowrap>&nbsp;</td>   
<td nowrap ><B>&nbsp;</B></td>
</tr>
<tr>
<td  nowrap>&nbsp;</td>  
<td nowrap ><B>&nbsp;</B></td>
</tr>
</table>
</div> 
</td>
<td>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td width='5%'>
</td>
<td width='5%'>
</td>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=arrCol.get(18)+""%></font></B></td>  
</tr>
<tr>
<td  class="label"nowrap ><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(19))%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=((String)arrCol.get(20)).equals("null")?"":arrCol.get(20)%></font></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=((String)arrCol.get(21)).equals("null")?"":arrCol.get(21)%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap ><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(22))%></font></B>
</td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black'  size=1.8pt><%=((String)arrCol.get(23)).equals("null")?"":arrCol.get(23)%></font></B></td> 
</tr>
<tr>
<td class="label" nowrap>&nbsp;</td>   
<td nowrap ><B>&nbsp;</B></td>
</tr>
<tr>
<td class="label" nowrap>&nbsp;</td>  
<td nowrap ><B>&nbsp;</B></td>
</tr>
</table>
</div>
</td>
</tr>
<%
}
%>
<%

 
}

if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear();
}
catch(Exception e1)
{
	System.out.println("Error in calling getconnection method of dooperate method of ViewQryMsgDtl.jsp:"+e1.toString());
	e1.printStackTrace(System.err);
		
}
finally
{
	//ConnectionManager.returnConnection(conn);
}
%>
</tr>
</table>
</div>


<%
try
{	
	eventTableName=sub_module+purge_status+"_EVENT";
	if(purge_status != null && !(purge_status.trim()).equalsIgnoreCase(""))
	{		
		purge_status = "_" + purge_status;

		if(purge_status.equalsIgnoreCase("_PURGE")) eventTableName = sub_module + purge_status + "_events";
		else eventTableName = sub_module+purge_status + "_event";
	}

//System.out.println("eventTableName 290 :"+eventTableName);


	if(protocolMode.equalsIgnoreCase("I"))
	{
		sqlQuery = "SELECT inbound_message_text,err_msg,message_ack_text FROM "+sub_module+purge_status+"_inbound_message "+
						" WHERE application_id='"+applicationID+"'"+
						" AND facility_id='"+facilityID+"'"+
						" AND message_id='"+msgID+"'"+
						" AND srl_no='"+srlNo+"'";
	}
	else 
	{
		sqlQuery = "SELECT X.message_text message_text,X.status_text status_text,Y.err_msg err_msg FROM "+sub_module+purge_status+"_application_message X,"+eventTableName+" Y "+
						"WHERE X.application_id='"+applicationID+"'"+
						" AND X.application_id=Y.application_id"+
						" AND X.facility_id='"+facilityID+"'"+
						" AND X.facility_id=Y.facility_id"+
						" AND X.message_id='"+msgID+"'"+
						" AND X.message_id=Y.message_id";				     
	}

	//System.out.println("(EventsException:Query) "+sqlQuery);
 
	//dbConn = ConnectionManager.getConnection();
	stmt = dbConn.createStatement();

	rs = stmt.executeQuery(sqlQuery);

	if(rs.next())
	{
		if(protocolMode.equalsIgnoreCase("I"))
		{
			messageText = rs.getString("inbound_message_text");
			inboundAckMsg = rs.getString("message_ack_text");
			errMsg = rs.getString("err_msg");			
		}
		else
		{
			messageText = rs.getString("message_text");
			errMsg = rs.getString("err_msg");
			statusTxt = rs.getString("status_text");

         //System.out.println("messageText 333:"+messageText+"statusTxt :"+statusTxt+"errMsg :"+errMsg);

		}
	}

}
catch(Exception exp)
{
	exp.printStackTrace();
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


 
 

<table cellspacing=0 cellpadding=3 width="100%" align="center">
 <tr>
<td class="label" ><fmt:message key="eXH.ExternalAccessionNumber.Label" bundle="${xh_labels}"/></td> 
</tr> 																						   
<tr>
 <td class='fields' ><TEXTAREA style="resize:none" NAME="" ROWS="3" COLS="100"><%=""+XHDBAdapter.checkNull(Acc_number)%></TEXTAREA></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class='fields'><TEXTAREA style="resize:none; height: 45px;" NAME="" ROWS="5" COLS="100"><%= XHDBAdapter.checkNull(messageText) %></TEXTAREA></td>
</tr>

<% if(protocolMode.equalsIgnoreCase("I")){ %>
<tr>
	<td class=label> <fmt:message key="eXH.Acknowlegment.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields'><TEXTAREA style="resize:none" NAME="" ROWS="6" COLS="100"><%= XHDBAdapter.checkNull(inboundAckMsg) %></TEXTAREA></td>
</tr>
<%}%>
<% if(protocolMode.equalsIgnoreCase("O")){ %>
<tr>
	<td class=label><fmt:message key="eXH.Communication.Label" bundle="${xh_labels}"/> <fmt:message key="eXH.Acknowlegment.Label" bundle="${xh_labels}"/></td>
</tr> 
<tr>
	<td class='fields' width="80%"><TEXTAREA style="resize:none; height: 40px;" NAME="" ROWS="3" COLS="100"><%= XHDBAdapter.checkNull(statusTxt) %></TEXTAREA></td>
</tr>
<%}%>

<tr> 
	<td class=label><fmt:message key="eXH.Processing.Label" bundle="${xh_labels}"/> <fmt:message key="eXH.Exceptions.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields'><TEXTAREA style="resize:none; height: 40px;" NAME="" ROWS="3" COLS="100"><%= XHDBAdapter.checkNull(errMsg) %></TEXTAREA></td>
</tr>

</table>





</BODY>
</HTML>

