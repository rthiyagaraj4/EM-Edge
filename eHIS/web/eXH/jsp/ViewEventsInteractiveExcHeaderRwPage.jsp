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
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID")); 
String messageText = "";
String messageResponse="";															 
String errMsg = "", acknowledgeText = ""; //Added for XH_INTERFACE_ADMINISTER_ISSUE [IN:064353]
String statusTxt = "";
String sqlQuery = "";
String tableNameSuffix="XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+) ";
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 		   
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	


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

			if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				 System.out.println("HERE");

				 if(purge_status.equals(""))
				 {
				   tableNameSuffix = "XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";		  
				 }																				 
				 else
				 {
					tableNameSuffix = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";
				 }
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }
	
	String posi=XHDBAdapter.checkNull(request.getParameter("posi")); 
	request.setAttribute("tableNameSuffix",tableNameSuffix); 
	request.setAttribute("qry_id","VIEWXHINTERACTIVE");    
	request.setAttribute("whereClause",whereClause);   
	request.setAttribute("maxRec","1"); 					   
	XHViewInteractiveControllerElementBean	xhBean =
	XHViewInteractiveControllerElementBean.getBean(XHViewInteractiveControllerElementBean.strBeanName,request,session);
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
		//XHDBAdapter.checkNull((String)arrCol.get(12))/
%>
<tr> 
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td class="label" nowrap ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>  <td nowrap class="label"><B><font color='black'><%=XHDBAdapter.checkNull((String)arrCol.get(2))%></font></B></td>
</tr> 
<tr>
<td class="label" nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td> 
<td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(3))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 
<td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(5))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td> 
<td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(29))%></font></B></td>
</tr>
<tr>  
<td class="label" nowrap > 
		<fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/>
		</td>  
		<td nowrap class="label"><B><font color='black'><%=XHDBAdapter.checkNull((String)arrCol.get(0))%></font></B></td>
	  </tr>
	  <tr>
       <td class="label" nowrap>
		<fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/>
		</td>		
        <td nowrap class="label"><B><font color='black'><%=XHDBAdapter.checkNull((String)arrCol.get(22))%></font></B></td>
</tr>
 </table> 
</div> 
</td> 
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td class="label" nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td> 
		 <td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(6))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>  
       <td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(8))%></font></B></td>
</tr>
<tr>
<td class="label" nowrap><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></td> 
       <td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(28))%></font></B></td>
</tr> 
<tr>
<td class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td> 
       <td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(9))%></font></B></td>
</tr>
<tr>   
<td class="label" nowrap><fmt:message key="eXH.MergedPatientID.Label" bundle="${xh_labels}"/></td>  
      <td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(14))%></font></B></td>
	  </tr>
	 <tr>
<td  class="label" nowrap><fmt:message key="eXH.trx_no.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=XHDBAdapter.checkNull((String)arrCol.get(21))%></font></B></td> 
</tr>
</table>
</div> 
</td>
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=arrCol.get(13)+""%></font></B></td>   
</tr>
<tr>
<td  class="label"nowrap ><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(14))%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=((String)arrCol.get(20)).equals("null")?"":arrCol.get(17)%></font></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=((String)arrCol.get(21)).equals("null")?"":arrCol.get(15)%></font></B></td> 
</tr>
<tr>
<td  class="label" nowrap ><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><font color='black'><%=""+XHDBAdapter.checkNull((String)arrCol.get(16))%></font></B>
</td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap class="label"><B><font color='black'><%=((String)arrCol.get(19)).equals("null")?"":arrCol.get(19)%></font></B></td> 
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
	
	String strResQuery="XH_INTERACTIVE_INTEGRATION";
		   if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				 System.out.println("HERE");

				 if(purge_status.equals(""))
				 {
				   strResQuery = "XH_INTERACTIVE_INTEGRATION ";		  
				 }																				 
				 else
				 {
					strResQuery = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN ";
				 }
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }
			 // Column ACKNOWLEDGMENT_TEXT Added for XH_INTERFACE_ADMINISTER_ISSUE [IN:064353]
	sqlQuery = "SELECT REQUEST_TEXT,RESPONSE_TEXT,REJEACTED_REASON,ERROR_TEXT, ACKNOWLEDGMENT_TEXT  FROM "+strResQuery+
						"WHERE APPLICATION_ID='"+applicationID+"'"+
						" AND FACILITY_ID='"+facilityID+"'"+
						" AND MESSAGE_ID='"+msgID+"'";
	

	
 
	//dbConn = ConnectionManager.getConnection();
	stmt = dbConn.createStatement();
																  
	rs = stmt.executeQuery(sqlQuery);

	if(rs.next())
	{
			messageText = rs.getString(1);
			messageResponse= rs.getString(2);
			statusTxt = rs.getString(3);
			errMsg = rs.getString(4);
			acknowledgeText = rs.getString(5); //Added for XH_INTERFACE_ADMINISTER_ISSUE [IN:064353]
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
	<td class=label><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="5" COLS="105"><%= XHDBAdapter.checkNull(messageText) %></TEXTAREA></td>
</tr>


<tr>
	<td class=label> <fmt:message key="Common.Response.label" bundle="${common_labels}"/> <fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
</tr> 
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="5" COLS="105"><%= XHDBAdapter.checkNull(messageResponse) %></TEXTAREA></td>
</tr>
<!--Added for XH_INTERFACE_ADMINISTER_ISSUE [IN:064353]-->
<tr>
	<td class=label> <fmt:message key="Common.Acknowledgement.label" bundle="${common_labels}"/> <fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
</tr> 
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="2" COLS="105"><%= XHDBAdapter.checkNull(acknowledgeText) %></TEXTAREA></td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/> <fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
</tr> 
<tr>
	<td class='fields' width="80%"><TEXTAREA NAME="" ROWS="2" COLS="105"><%= XHDBAdapter.checkNull(statusTxt) %></TEXTAREA></td>
</tr>


<tr> 
	<td class=label><fmt:message key="eXH.Exceptions.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="2" COLS="105"><%= XHDBAdapter.checkNull(errMsg) %></TEXTAREA></td>
</tr>

</table>





</BODY>
</HTML>

