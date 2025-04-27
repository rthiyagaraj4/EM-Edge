<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,java.net.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
String process_id="";
String processtype="";
String appl=request.getParameter("appli");
String appln_name=request.getParameter("appln_name");
String facility=request.getParameter("fac");
String facility_name=request.getParameter("facility_name");
String commu_client=request.getParameter("com");
String proc=request.getParameter("proc1");
if(proc.equalsIgnoreCase("I")) processtype="Inbound";
if(proc.equalsIgnoreCase("O")) processtype="Outbound";

String sql_query = request.getParameter("sql_query"); 
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
if( sql_query==null){
  sql_query="SELECT PROCESS_ID,TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH:MI:SS')START_DATE_TIME,"+
 " TO_CHAR(STOP_DATE_TIME,'DD/MM/YYYY HH:MI:SS')STOP_DATE_TIME,TO_CHAR(LAST_COMM_DATE_TIME,'DD/MM/YYYY HH:MI:SS')LAST_COMM_DATE_TIME,"+
"LAST_OUTBOUND_RETRIES,LAST_MESSAGE_ID,TOTAL_MESSAGES,STARTED_BY_ID,STOPPED_BY_ID,PROCESS_STATUS "+
"FROM XH_COMM_PROCESS WHERE APPLICATION_ID=NVL('"+appl+"',APPLICATION_ID) AND FACILITY_ID=NVL('"+facility+"',FACILITY_ID)"+
 " AND CLIENT_ID=NVL('"+commu_client+"',CLIENT_ID)"+
"AND PROCESS_TYPE=NVL('"+proc+"',PROCESS_TYPE) ORDER BY START_DATE_TIME DESC ";    
  }
 int p_rec_cnt	= 0;
String mode=request.getParameter("mode");
String sql="SELECT MAX(PROCESS_ID) FROM XH_COMM_PROCESS WHERE APPLICATION_ID='"+appl+"' AND  CLIENT_ID='"+commu_client+"' AND FACILITY_ID='"+facility+"' AND PROCESS_TYPE ='"+proc+"'";
Connection con = null;
Statement pstmt=null,pstmt1=null;
ResultSet rs=null;
con =  ConnectionManager.getConnection(request);
CallableStatement ostmt = null; 
String sts="",message_text2="";
if(mode!=null)
{
try{
    pstmt1=con.createStatement();
    rs = pstmt1.executeQuery(sql); 
    while(rs.next())
    {
     process_id=rs.getString(1);
   }
   if(rs!=null) rs.close();
   if(pstmt1!=null) pstmt1.close();
    ostmt =con.prepareCall("{ call xhcomm.reset_process(?,?,?) }" ); 
	ostmt.setString(1,process_id);
	ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
	ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
	ostmt.execute(); 
	sts =ostmt.getString(2);
	message_text2 = ostmt.getString(3);
	if(sts.equals("0"))
	{
		con.commit();
	 } else {
			con.rollback();
			}

	ostmt.close();
    }catch(Exception e ){System.out.println(" exception review comm process ");e.printStackTrace(System.err);}	
}
%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function RefreshMethod
function RefreshMethod()
{

this.document.review_commprocess_popup_form.action = '../../eXH/jsp/ReviewCommProcessPopup.jsp';
this.document.review_commprocess_popup_form.submit();

}
//function resetMethod
function resetMethod()
{
   this.document.review_commprocess_popup_form.mode.value='I';
   this.document.review_commprocess_popup_form.action = '../../eXH/jsp/ReviewCommProcessPopup.jsp';
   this.document.review_commprocess_popup_form.submit();
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="review_commprocess_popup_form" id="review_commprocess_popup_form" >
<input type="hidden" name="appli" id="appli" value='<%=appl%>'/>
<input type="hidden" name="appln_name" id="appln_name" value='<%=appln_name%>'/>
<input type="hidden" name="fac" id="fac" value='<%=facility%>'/>
<input type="hidden" name="facility_name" id="facility_name" value='<%=facility_name%>'/>
<input type="hidden" name="com" id="com" value='<%=commu_client%>'/>
<input type="hidden" name="proc1" id="proc1" value='<%=proc%>'/>
<input type="hidden" name="mode" id="mode" />
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 
</tr>
<tr>
<td class=label ><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name=applval id=applval value='<%=appln_name%>' size=40></td>
<td class=label ><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text size=20 value='<%=facility_name%>'>
</td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.ProcessType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name=proc_type id=proc_type value='<%=processtype%>' size=10></td>
<td class=label ><fmt:message key="eXH.CommunicationClient.Label" bundle="${xh_labels}"/></td><td class='fields'>
<input type=text size=15 value='<%=commu_client%>'>
</td>
</tr>
<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 
</tr>
</table>
<%  
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 13 ;
	else	end = Integer.parseInt( to ) ;   

	
	int maxRecord = 0;

	try
	{
	  String sql2=sql_query;
		 pstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		 rs = pstmt.executeQuery(sql2); 
		 rs.last();
		 maxRecord=rs.getRow();
		 rs.beforeFirst();
		 if (maxRecord==0)
	    {
        %>
	     <script>
alert(getMessage('XH1021','XH'));
         </script>
         <%
	      }
	   else
	   {
		%>
		
      <p>
<table align='right'>
	<tr>
	<td>
	<%  
	if ( !(start <= 1) )
	out.println("<A  "+ "HREF='../../eXH/jsp/ReviewCommProcessPopup.jsp?facility_name="+facility_name+"&fac="+facility+"&com="+commu_client+"&appli="+appl+""+"&proc1="+proc+"&from="+(start-13)+"&to="+(end-13)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" "+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels")+"</A>");

	if ( !( (start+13) > maxRecord ) )
	out.println("<A "+  "HREF='../../eXH/jsp/ReviewCommProcessPopup.jsp?facility_name="+facility_name+"&fac="+facility+"&com="+commu_client+"&appli="+appl+""+"&proc1="+proc+"&from="+(start+13)+"&to="+(end+13)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" "+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels")+"</A>"); 
	%>

</td>
</tr>
</table>
</p>
<br><br>

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER' width='2%'></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.ProcessID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.StartDateTimee.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.StopDateTime.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.LastCommnTime.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.LastOutboundRetries.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.LastMessageID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.TotalMessages.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.StartedbyID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.StoppedbyID.Label" bundle="${xh_labels}"/></td>
</tr>
<% 
if ( start != 1 )
for( int j=1; j<start; i++,j++ )
{
   rs.next() ;
}
String strTDClass = "" ;
while ( rs!=null && rs.next() && i<=end )
 {
	 if ( i % 2 == 0 )
		  	strTDClass = "QRYEVEN" ;
	 else
		  	strTDClass = "QRYODD" ;

int PROCESS_ID=rs.getInt("PROCESS_ID");

String START_DATE_TIME=""; 
String processDate="";
processDate=rs.getString("START_DATE_TIME")==null?"":rs.getString("START_DATE_TIME");
if(!processDate.equals("")) START_DATE_TIME =com.ehis.util.DateUtils.convertDate(processDate,"DMYHMS","en",locale);
String endDate1="";
String STOP_DATE_TIME="";
endDate1=rs.getString("STOP_DATE_TIME")==null?"":rs.getString("STOP_DATE_TIME");
if(!endDate1.equals("")) STOP_DATE_TIME =com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);

String endDate="";
String LAST_COMM_DATE_TIME="";
endDate=rs.getString("LAST_COMM_DATE_TIME")==null?"":rs.getString("LAST_COMM_DATE_TIME");
if(!endDate.equals("")) LAST_COMM_DATE_TIME =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);

int LAST_OUTBOUND_RETRIES=rs.getInt("LAST_OUTBOUND_RETRIES"); 
String LAST_MESSAGE_ID=rs.getString("LAST_MESSAGE_ID"); if(LAST_MESSAGE_ID==null)  LAST_MESSAGE_ID="";
int TOTAL_MESSAGES=rs.getInt("TOTAL_MESSAGES");
String STARTED_BY_ID=rs.getString("STARTED_BY_ID"); if(STARTED_BY_ID==null)  STARTED_BY_ID="";
String STOPPED_BY_ID=rs.getString("STOPPED_BY_ID"); if(STOPPED_BY_ID==null)  STOPPED_BY_ID="";
String PROCESS_STATUS=rs.getString("PROCESS_STATUS"); if(PROCESS_STATUS==null)  PROCESS_STATUS="";
String imgsrc="imgsrc="+"../../eCommon/images/dark_blue_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("A")) imgsrc="../../eCommon/images/green_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("C")) imgsrc="../../eCommon/images/red_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("S")) imgsrc="../../eCommon/images/pink_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("W")) imgsrc="../../eCommon/images/yello_square.jpg";
%>
<tr>
<td nowrap class='<%=strTDClass%>'><img src='<%=imgsrc%>' width=15 height=15/></td>
<td nowrap class='<%=strTDClass%>'><%=PROCESS_ID%></td>
<td nowrap class='<%=strTDClass%>'><%=START_DATE_TIME%></td>
<td nowrap class='<%=strTDClass%>'><%=STOP_DATE_TIME%></td>
<td nowrap class='<%=strTDClass%>'><%=LAST_COMM_DATE_TIME%></td>
<td nowrap class='<%=strTDClass%>'><%=LAST_OUTBOUND_RETRIES%></td>
<td nowrap class='<%=strTDClass%>'><%=LAST_MESSAGE_ID%></td>
<td nowrap class='<%=strTDClass%>'><%=TOTAL_MESSAGES%></td>
<td nowrap class='<%=strTDClass%>'><%=STARTED_BY_ID%></td>
<td nowrap class='<%=strTDClass%>'><%=STOPPED_BY_ID%></td>

<%
i++;
p_rec_cnt++;
}//endwhile %>        
</tr>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
<td width='20%'  class=label><img src='../../eCommon/images/dark_blue_square.jpg' width=40 height=15 > <fmt:message key="eXH.NoAction.Label" bundle="${xh_labels}"/></td>
<td width='20%'  class=label><img src='../../eCommon/images/yello_square.jpg' width=40 height=15 > <fmt:message key="eXH.WarmingUp.Label" bundle="${xh_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/green_square.jpg' width=40 height=15 > <fmt:message key="Common.Active.label" bundle="${common_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/pink_square.jpg' width=40 height=15 > <fmt:message key="eXH.AbouttoStop.Label" bundle="${xh_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/red_square.jpg' width=40 height=15 > <fmt:message key="eXH.Completed.Label" bundle="${xh_labels}"/></td> 
</tr>
</table>
</table>
<%}

%>

<%    
if(rs!=null) rs.close();
if(pstmt!=null)	pstmt.close();
}catch(Exception e)
	{
		e.toString();
		out.println(e.toString()); 
     }
	finally   
	{
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    }  
%>
<table align=right>
<tr>
<td colspan=4><input class='BUTTON' type="button"  name=reset id=reset value='<fmt:message key="eXH.Reset.Label" bundle="${xh_labels}"/>' onClick="resetMethod();"><input class='BUTTON' type="button"  name=reset id=reset value='<fmt:message key="eXH.Refresh.Label" bundle="${xh_labels}"/>' onClick="RefreshMethod();"><input class='BUTTON' type="button"  name=reset id=reset value='<fmt:message key="eXH.Close.Label" bundle="${xh_labels}"/>' onClick="window.close();"></td>
</tr>
</table>
</form>
</body>
</html>

