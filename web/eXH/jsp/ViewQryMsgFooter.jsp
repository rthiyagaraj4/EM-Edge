<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>	
<HEAD>
<style type = 'text/css'>
TD.COLUMNHEADER {
   BACKGROUND-COLOR: #404040;
   COLOR: white ;
   FONT-SIZE: 8pt;   
   font-weight: bolder; 
   PADDING-LEFT:7px;
   PADDING-RIGHT:7px
}
  </STYLE>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eXH/js/Validate.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/messages.js'></script>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="view_qry_msgfooter_form" id="view_qry_msgfooter_form">

<%
    
	
	
	
	
	Connection connection = null;
	String Msq_txt = "";
	String Query_txt="";
	String applicationId = "";
	String facilityId = "";
	String queryid = "";
	String eventType = "";
	String ProtocolID = "";
	String Statustext=""; 
	String appl_msg=""; 
    applicationId = request.getParameter("application_Id");
	facilityId = request.getParameter("Facility_Id");
	queryid = request.getParameter("qryid"); 
    //String msg_id=request.getParameter("Msg_Id");
	ProtocolID = request.getParameter("protocol_link_id");
    eventType = request.getParameter("Even_type");
	//Query_Option=request.getParameter("Query_Option"); 
	Statustext=java.net.URLDecoder.decode(request.getParameter("STATUSTEXT"));
	appl_msg=java.net.URLDecoder.decode(request.getParameter("application_Msg"));
	//String err_msg=java.net.URLDecoder.decode(request.getParameter("Error_msg"));
	String qapplname=request.getParameter("qapplname");
	String faciname=request.getParameter("faciname");
	//int count=0;
	//String event_name="";
 //  	String protocol_mode="Q"; 
//	CallableStatement  oraclecallablestatement = null;
	//System.out.println("queryid 69:"+queryid);

%>

<%
boolean boolToggle =  true;	
String strTDClass = "";
String qry_id = "VIEWADMINQUERYPROCESS";
Connection conn = null;
try
{ 
  String tableNameSuffix=""; 
  String whereClause="";
 /* whereClause ="XH_APPLICATION_QRY_MSG_VW A WHERE  A.FACILITY_ID =d.FACILITY_ID and "+
		  " A.APPLICATION_ID=NVL('"+applicationId+"',A.APPLICATION_ID) AND "+
          " A.FACILITY_ID=NVL('"+facilityId+"',A.FACILITY_ID) "+
                 // " QUERY_STATUS=NVL('#qstatus',QUERY_STATUS) "+
		  //" AND TO_DATE(A.QUERY_DATE) BETWEEN TO_DATE(NVL('"+qmsg_dt1+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') AND TO_DATE(NVL('"+qmsg_dt2+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')
		  "and A.APPLICATION_ID=B.APPLICATION_ID AND A.QUERY_ID=c.QUERY_ID AND A.QUERY_ID BETWEEN  nvl('"+queryid+"',A.QUERY_ID) AND nvl('"+queryid+"',A.QUERY_ID) AND A.protocol_link_id = nvl('"+ProtocolID+"',A.protocol_link_id) AND A.EVENT_TYPE = NVL('"+eventType+"',A.EVENT_TYPE) ";  */

//System.out.println("queryid 145:"+queryid);
 whereClause ="XH_APPLICATION_QRY_MSG_VW A WHERE    a.FACILITY_ID = d.facility_id AND  A.APPLICATION_ID=NVL('"+applicationId+"',A.APPLICATION_ID) AND   A.FACILITY_ID=NVL('"+facilityId+"',A.FACILITY_ID) AND "+
	 //TO_DATE(A.QUERY_DATE) BETWEEN TO_DATE(NVL('"+qmsg_dt1+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') AND /TO_DATE(NVL('"+qmsg_dt2+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
 " A.APPLICATION_ID=B.APPLICATION_ID AND A.QUERY_ID BETWEEN  nvl('"+queryid+"',A.QUERY_ID) AND nvl('"+queryid+"',A.QUERY_ID) AND A.protocol_link_id = nvl('"+ProtocolID+"',A.protocol_link_id) AND A.EVENT_TYPE = NVL('"+eventType+"',A.EVENT_TYPE)  ";  
//out.println("whereClause :"+whereClause);
   /*request.setAttribute("tableName",tableNameSuffix); 
 
  //System.out.println("QueryOption"+QueryOption);  
  request.setAttribute(XHQueryRender.strQueryId,qry_id); 
  request.setAttribute(XHQueryRender.whereClause,whereClause);
  request.setAttribute(XHQueryRender.col,"28"); 
  request.setAttribute(XHQueryRender.maxRec,"3");
  conn = ConnectionManager.getConnection(request);
  HashMap resultsQry = XHQueryRender.getResults(request,session,conn,QueryOption);
  ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
  ArrayList arrCol = null; 
  boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
  boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); */
  String posi=XHDBAdapter.checkNull(request.getParameter("posi")); 
    String QueryOption=request.getParameter("Query_Option");
  request.setAttribute("tableName",tableNameSuffix); 
  //System.out.println("QueryOption"+QueryOption);
  request.setAttribute("qry_id",qry_id);  
  request.setAttribute("whereClause",whereClause);
  request.setAttribute("maxRec","3"); 
  request.setAttribute("qryid",queryid); 
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
  HashMap resultsQry  = xhBean.getPositionRecord(posi);
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
<input  type="hidden" name=qostatus value='P' />
<%
if(arrRow.size()==0)
{
%>
<script>
alert(getMessage('XH1021','XH'));
</script>
<% } else { %>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<td class='COLUMNHEADER' colspan="10" align="center"><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></td>
 
</tr>

</table>  
<div id="right_child"  scrolling='no'>
<table id="table2" cellspacing=0 cellpadding=3 border=0 scrolling='no' width='100%'>
<tr>

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

String mstatus=((String)arrCol.get(27)).equals("null")?"":(String)arrCol.get(27);	

 String statusColor="";
	String status =((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);	
		status=status.trim();
	if(status.equals("S"))  statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Processed.Label","xh_labels");
	else if(status.equals("R"))  statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels") ;
	else if(status.equals("E"))  statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ProcessingError.Label","XH_labels") ;
	else if(status.equals(" "))  statusColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.received.label","common_labels") ; 
	else
		statusColor="" ;

%> 
<tr>
<td width='5%'>
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td class="label" nowrap ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><%=arrCol.get(23)+""%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(24))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(25))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td> 
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(26))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.ProcessStartTime.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(8))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.ProcessEndTime.Label" bundle="${xh_labels}"/></td> 
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(9))%></B></td>
</tr>

<tr>
<td class="label" nowrap><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>   
<td nowrap class="label"><B><font color='black'><%if(mstatus.equalsIgnoreCase("S"))
	{%><fmt:message key="eXH.Sucessfull.Label" bundle="${xh_labels}"/><%}else if(mstatus.equalsIgnoreCase("E")){%><fmt:message key="eXH.TransmissionError.Label" bundle="${xh_labels}"/><%}else if(mstatus.equalsIgnoreCase("A")){ %>
 <fmt:message key="Common.Accept.label" bundle="${common_labels}"/><%}else if(mstatus.equalsIgnoreCase("R")){ %>
 <fmt:message key="Common.Rejected.label" bundle="${common_labels}"/><%}else{}%></font></B></td>
</tr>
<tr>  
<td class="label" nowrap><fmt:message key="eXH.QueryStatus.Label" bundle="${xh_labels}"/></td>  
<td nowrap class="label"><B><font color='black'><%=""+statusColor%></font></B></td>
</tr>
 




</table>
</div>
</td>

<td width='5%' >
<div>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='25%'  border=0>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.QueryID.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><%=arrCol.get(1)+""%></B></td>
</tR>
<tr>
<td class="label" nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(4))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.QueryDate.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(3))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(5))%></B></td>

</tr>
<tr>
<td class="label" nowrap ><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></td>
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(6))%></B></td>
</tr>
<tr>
<td class="label" nowrap ><fmt:message key="eXH.AccessionNumber.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(20))%></B></td>
</tr>
<tr>
<td class="label" nowrap>&nbsp;</td>   
<td nowrap class="label"><B>&nbsp;</B></td>
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
<td  nowrap ><B><%=arrCol.get(10)+""%></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><%=arrCol.get(13)+""%></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(15))%></B></td> 
</tr> 
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(11))%></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></td>
<td  nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(14))%></B></td> 
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></td>
<td nowrap ><B><%=""+XHDBAdapter.checkNull((String)arrCol.get(17))%></B></td> 
</tr>
<tr>
<td class="label" nowrap>&nbsp;</td>   
<td nowrap class="label"><B>&nbsp;</B></td>
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

</table>
</div>

<table cellspacing=0 cellpadding=3 width='100%' align=center>

<%
String msgid="";
   try 	
	{
		if(connection==null) connection = ConnectionManager.getConnection();
		String sql="SELECT b.MESSAGE_TEXT,b.MESSAGE_ID,a.QUERY_TEXT,c.event_name FROM xh_application_query a,xh_application_message b,xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) "
						+ " AND a.QUERY_ID=NVL('"+queryid+"',a.QUERY_ID)"
						+ " AND a.EVENT_TYPE=NVL('"+eventType+"',a.EVENT_TYPE) "
						+ " AND a.FACILITY_ID=NVL('"+facilityId+"',a.FACILITY_ID ) and a.QUERY_ID=b.QUERY_ID and a.EVENT_TYPE=c.EVENT_TYPE";
         //System.out.println("Review Sql :"+sql);
	    Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		while(rs.next())
		{ 
			Msq_txt= XHDBAdapter.checkNull(rs.getString(1));
			msgid= XHDBAdapter.checkNull(rs.getString(2));
			Query_txt=XHDBAdapter.checkNull(rs.getString(3));
			
		}
		if(rs!=null) rs.close();
       if(stmt!=null) stmt.close(); 
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
		
      }
%>
<tr>
	<td class=label ><fmt:message key="eXH.QueryText.Label" bundle="${xh_labels}"/></td> 
	<td ><textarea rows=7 cols=95 readOnly><%=Query_txt.toString().trim().equals("null")?"":Query_txt.toString().trim()%>
	</textarea></td>
</tr>
	<tr>
	<td class=label ><fmt:message key="Common.Response.label" bundle="${common_labels}"/> <fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
	<td  class='fields'><textarea rows=7 cols=95 readOnly><%=Msq_txt%></textarea></td>
</tr> 
<tr>
<td class=label ><fmt:message key="eXH.Exceptions.Label" bundle="${xh_labels}"/> <fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
	<td  class='fields'><textarea rows=3 cols=95 readOnly><%=request.getParameter("application_Msg").toString().trim().equals("null")?"":java.net.URLDecoder.decode(request.getParameter("application_Msg").toString().trim())%>
	</textarea></td>
	</tr>
<tr>
	<td class=label ><fmt:message key="eXH.StatusText.Label" bundle="${xh_labels}"/></td><td colspan=1 class='fields'><textarea rows=3 cols=95 readOnly><%=request.getParameter("STATUSTEXT").equals("null")?"":java.net.URLDecoder.decode(request.getParameter("STATUSTEXT"))%></textarea></td>
</tr>
<%---<tr>
<td class=label >Error Text</td><td colspan=1 class='fields'><textarea rows=2 cols=55><%=request.getParameter("Error_msg").equals("null")?"":java.net.URLDecoder.decode(request.getParameter("Error_msg"))%>
	</textarea></td>
</tr>----%>

<!----<td align='right'><input type='button' style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" value='Message Viewer' width='25%' onclick='goToView()'>
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='Close' onClick='windowclose()'></td>----->
<input type=hidden id='applicationId' name='applicationId' id='applicationId' value='<%=applicationId%>'>
<input type=hidden id='facilityId' name='facilityId' id='facilityId' value='<%=facilityId%>'>
<input type=hidden id='msgId' name='msgId' id='msgId' value='<%=msgid%>'>
<input type=hidden id='eventType' name='eventType' id='eventType' value='<%=eventType%>'>
<input type=hidden id='ProtocolID' name='ProtocolID' id='ProtocolID' value='<%=ProtocolID%>'>
<input type=hidden id='qapplname' name='qapplname' id='qapplname' value='<%=qapplname%>'>
<input type=hidden id='faciname' name='faciname' id='faciname' value='<%=faciname%>'>
</table>




<%
 try{
	
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
 %>
<script>
async function goToView()
{
	var arguments  =new Array();
	var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
    /*arguments[0]=document.forms[0].application_id.value;
	arguments[1]=document.forms[0].Facility_id.value;
	arguments[2]=document.forms[0].eventype.value;
	arguments[3]=document.forms[0].protocollinkid.value;
    arguments[4]=document.forms[0].msg_id.value;*/
    
    var url="../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&eventype="+this.document.forms[0].event_type.value+"&protocollinkid="+this.document.forms[0].Protocollink_id.value+"&msg_id="+this.document.forms[0].QUERYID.value;



	await window.showModalDialog(url,arguments,features);  
// window.open(url,null,"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");

 

}

function windowclose()
{
	parent.window.close();
}
</script>
</form>
</body>
</html>  

