<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
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


<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'> 
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
String inboundAckMsg = "";  
String eventTableName = "XH_EVENT"; 
String tableNameSuffix="";
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
try
{
	dbConn = ConnectionManager.getConnection();
}
catch(Exception e)
{
	System.out.println("ViewEventInboundExceptionsHeader.jsp DBConnection exception e"+e); 
}
try 
{ 
if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_INBOUND_MESSAGE_vw X";
	}
	else
	{
		tableNameSuffix = sub_module+"_INBOUND_MESSAGE_VW X"; 
	}

  String posi=XHDBAdapter.checkNull(request.getParameter("posi"));  

  request.setAttribute("tableName",tableNameSuffix);  
   
  request.setAttribute("qry_id","VIEW_INBOUND_EVENTS");   
  request.setAttribute("whereClause",whereClause);  
 request.setAttribute("maxRec","1");   
  //request.setAttribute(XHViewQueryControllerElementBean.maxRec,1);   
  XHViewInboundControllerElementBean	xhBean =
  XHViewInboundControllerElementBean.getBean(XHViewInboundControllerElementBean.strBeanName,request,session);
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
String sstatusColor="";
    String  mstatus =((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);	
	mstatus=mstatus.trim();
	if(mstatus.equals("S"))  sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.received.label","common_labels");
	else if(mstatus.equals("L"))   sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.LoadedSuccessfully.Label","xh_labels");
	else if(mstatus.equals("A"))  sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.LoadedSuccessfully.Label","xh_labels");
	else if(mstatus.equals("R"))  sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
	else if(mstatus.equals("F"))  sstatusColor="" ;
	else if(mstatus.equals("E"))  sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ErrorInLoading.Label","xh_labels");
	else sstatusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");  


 
		String endDate1="";
		String Modified_Date="";
		String Last_Processed_date	= ((String)arrCol.get(11)).equals("null")?"":(String)arrCol.get(11);
		endDate1=((String)arrCol.get(22)).equals("null")?"":(String)arrCol.get(22);
		if(!endDate1.equals("")) 
			//Modified_Date =com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);
			Modified_Date =endDate1;
		String endDate=((String)arrCol.get(19)).equals("null")?"":(String)arrCol.get(19); 
		String Added_Date="";
		if(!endDate.equals("")) 
			//Added_Date =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
			Added_Date = endDate;
		String Message_Date=""; 
		String	queryDate = ((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
		if(!queryDate.equals("")) 
			//Message_Date = com.ehis.util.DateUtils.convertDate(queryDate,"DMYHMS","en",locale);
			Message_Date = queryDate;
			Message_Date = XHUtil.convertToDate(queryDate,"dd/MM/yyyy hh:mm:ss");		
		String startDate=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
		if(!startDate.equals("")) 
		startDate =XHUtil.convertToDate(startDate,"dd/MM/yyyy hh:mm:ss");
%>

<div id="right_child"  scrolling='no'>
<table id="table2" cellspacing=0 cellpadding=3 border=0 scrolling='no'>
<tr>
<td width='5%'>  
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td class="label" nowrap ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><font color='black' size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(2))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(35))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(15))%></font></B></td> 
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td> 
<td  nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(38))%></font></B></td>  
</tr>  
<tr> 
<td class="label" nowrap ><fmt:message key="eXH.MsgIDSno.Label" bundle="${xh_labels}"/></td>   
		<td nowrap ><B><font color='black' size=1.8pt><%=((String)arrCol.get(3)).equals("null")?"":arrCol.get(3)%> /
					<%=((String)arrCol.get(36)).equals("null")?"":arrCol.get(36)%></font></B></td>
	  </tr>
	  <tr>
       <td class="label" nowrap ><fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/>
		</td>		
        <td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(4))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>   
<td nowrap class="label"><B><font color='black' size=1.8pt><%=sstatusColor%></font></B></td>
</tr>
     
</table>  
</div>
</td> 
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>  
<td  nowrap ><B><font color='black' size=1.8pt><%=XHDBAdapter.checkNull((String)arrCol.get(17))+""%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(20))%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(21))%></font></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
<td nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(19))%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=""+XHDBAdapter.checkNull((String)arrCol.get(10))%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.LastProcessedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black' size=1.8pt><font color='black'><%=(Last_Processed_date)%></font></B></td> 
</tr> 
<tr>
<td class="label" nowrap>&nbsp;</td>   
<td nowrap class="label"><B>&nbsp;</B></td>
</tr>
</table>
</div> 
</td> 
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=arrCol.get(25)+""%></font></B></td>  
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=arrCol.get(8)+""%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=((String)arrCol.get(28)).equals("null")?"":arrCol.get(28)%></font></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black' size=1.8pt><%=((String)arrCol.get(27)).equals("null")?"":arrCol.get(27)%></font></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><font color='black' size=1.8pt><%=arrCol.get(9)+""%></font></B></td> 
</tr>  
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><font color='black' size=1.8pt><%=((String)arrCol.get(23)).equals("null")?"":arrCol.get(16)%></font></B></td> 
</tr>
<tr>
<td class="label" nowrap>&nbsp;</td>   
<td nowrap class="label"><B>&nbsp;</B></td>
</tr>
</table>
</div> 
</td>
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
	if(purge_status != null && !(purge_status.trim()).equalsIgnoreCase(""))
	{		
		purge_status = "_" + purge_status;

		if(purge_status.equalsIgnoreCase("_PURGE")) eventTableName = sub_module + purge_status + "_events";
		else eventTableName = sub_module+purge_status + "_event";
	}
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
	<td class=label><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="11" COLS="100"><%= XHDBAdapter.checkNull(messageText) %></TEXTAREA></td>
</tr>
 
<% if(protocolMode.equalsIgnoreCase("I")){ %>
<tr>
	<td class=label><fmt:message key="eXH.Acknowlegment.Label" bundle="${xh_labels}"/></td> 
</tr>
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="3" COLS="100"><%= XHDBAdapter.checkNull(inboundAckMsg) %></TEXTAREA></td>
</tr>
<%}%>
<% if(protocolMode.equalsIgnoreCase("O")){ %>
<tr>
	<td class=label><fmt:message key="Common.Negative.label" bundle="${common_labels}"/> <fmt:message key="eXH.Acknowlegment.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields' width="80%"><TEXTAREA NAME="" ROWS="5" COLS="100"><%= XHDBAdapter.checkNull(statusTxt) %></TEXTAREA></td>
</tr>
<%}%>

<tr>
	<td class=label><fmt:message key="eXH.Exceptions.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="3" COLS="100"><%= XHDBAdapter.checkNull(errMsg) %></TEXTAREA></td>
</tr>

</table>

</BODY>
</HTML> 

