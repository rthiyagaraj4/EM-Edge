<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,,java.net.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%
 
  String sql_query = request.getParameter("sql_query"); 
  //System.out.println("request sql: "+sql_query);			 
  String from = request.getParameter("from") ;
  String to = request.getParameter("to") ;

  String facility=request.getParameter("facility"); if(facility==null) facility="";
  String facility_name=request.getParameter("facility_name");  if(facility_name==null) facility_name="";
  String comm_client=request.getParameter("comm_client"); if(comm_client==null) comm_client="";
  //System.out.println(" sql_query  outbound(1):"+sql_query );  
  if( sql_query==null){
 
 sql_query="SELECT X.PROCESS_STATUS PROCESS_STATUS,X.APPLICATION_ID APPLICATION_ID,TO_CHAR(X.START_DATE_TIME,'DD/MM/YYYY HH:MI:SS') START_DATE_TIME,X.TOTAL_MESSAGES TOTAL_MESSAGES,"+
   " TO_CHAR(X.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH:MI:SS')LAST_COMM_DATE_TIME,X.LAST_OUTBOUND_RETRIES LAST_OUTBOUND_RETRIES,"+
" X.LAST_MESSAGE_ID LAST_MESSAGE_ID,X.PROCESS_ID PROCESS_ID,Y.APPLICATION_NAME APPLICATION_NAME"+
" FROM XH_COMM_PROCESS X,XH_APPLICATION_LANG_VW Y "+
" WHERE X.CLIENT_ID='"+comm_client+"' AND X.PROCESS_TYPE='O' "+
" AND X.FACILITY_ID='"+facility+"' AND X.APPLICATION_ID=Y.APPLICATION_ID AND Y.LANGUAGE_ID='"+locale+"'"+ 
" AND (X.APPLICATION_ID,X.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "+
" WHERE CLIENT_ID='"+comm_client+"' AND PROCESS_TYPE ='O' GROUP BY  APPLICATION_ID) "+
" UNION "+
" SELECT NULL PROCESS_STATUS, X.APPLICATION_ID APPLICATION_ID,TO_CHAR(NULL) START_DATE_TIME,NULL TOTAL_MESSAGES,"+
" TO_CHAR(NULL)LAST_COMM_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,NULL LAST_MESSAGE_ID,NULL "+   "PROCESS_ID,Z.APPLICATION_NAME APPLICATION_NAME"+
" FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y,XH_APPLICATION_LANG_VW Z  "+
" WHERE X.IN_USE_YN='Y'AND Y.OUTBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID='"+comm_client+"' "+
" AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='O' AND X.APPLICATION_ID=Z.APPLICATION_ID AND Z.LANGUAGE_ID='"+locale+"'"+  "AND X.FACILITY_ID=NVL('"+facility+"',X.FACILITY_ID)"+
" AND	(X.APPLICATION_ID, '"+comm_client+"') NOT IN (SELECT APPLICATION_ID, CLIENT_ID FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='O')";
//System.out.println(" sql_query :"+sql_query ); 
}
  int p_rec_cnt	= 0;
%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function openLink
function openLink(obj)
{

var facil=this.document.forms[0].facility.value;
var faciln=this.document.forms[0].facility_name.value;
var comm_c=this.document.forms[0].comm_client.value;
this.document.forms[0].appl_Id.value=obj.getAttribute('appl_Id');
this.document.forms[0].appl_Name.value=obj.getAttribute('appl_Name');
var appln=this.document.forms[0].appl_Id.value;
var proc=this.document.forms[0].comm_type.value;
var applname=this.document.forms[0].appl_Name.value;
var url="../../eXH/jsp/ReviewCommProcessPopup.jsp?facility_name="+faciln+"&fac="+facil+"&com="+comm_c+"&appli="+appln+"&appln_name="+applname+"&proc1="+proc;
window.open(url,"ReviewCommunicationProcess","fullscreen=no,height=600,width=900,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");
parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';

}
//function validatecheck
function validatecheck(obj)
{
	
	this.document.forms[0].appl_Id.value=obj.getAttribute('appl_Id');
	this.document.forms[0].process_id.value=obj.getAttribute('process_id');
	this.document.forms[0].process_status.value=obj.getAttribute('process_status');
	this.document.forms[0].action ='../../eXH/jsp/ReviewCommProcessFooter.jsp';
	this.document.forms[0].target='f_query_btn';
	this.document.forms[0].submit();

}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<%  
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 13	 ;
	else	end = Integer.parseInt( to ) ;   

	Connection con = null;
	Statement pstmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
      con =  ConnectionManager.getConnection(request);

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
<form name="review_communprocess_outbound_form" id="review_communprocess_outbound_form">

<input type="hidden" name="facility" id="facility" value='<%=facility%>'/>
<input type="hidden" name="facility_name" id="facility_name" value='<%=facility_name%>'/>
<input type="hidden" name="comm_client" id="comm_client" value='<%=comm_client%>'/>
<input type="hidden" name="comm_type" id="comm_type" value='O'/>
<input type="hidden" name="appl_Id" id="appl_Id" id="appl_Id" />
<input type="hidden" name="appl_Name" id="appl_Name" id="appl_Name" />
<input type="hidden" name="st_date_time" id="st_date_time" id="st_date_time" value=''/>
<input type="hidden" name="tot_msg" id="tot_msg" id="tot_msg" value=''/>
<input type="hidden" name="last_comm" id="last_comm" id="last_comm" value=''/>
<input type="hidden" name="retries" id="retries" id="retries" value=''/>
<input type="hidden" name="last_msg_id" id="last_msg_id" id="last_msg_id" value=''/>
<input type="hidden" name="process_id" id="process_id"/>
<input type="hidden" name="process_status" id="process_status"/>
<input type="hidden" name="mode" id="mode" value="W"/>		

<table align='right'>
	<tr>
	<td>
	<%  
	if ( !(start <= 1) )
	out.println("<A HREF='../../eXH/jsp/ReviewCommProcessOutbound.jsp?facility="+facility+"&comm_client="+comm_client+
	"&from="+(start-13)+"&to="+(end-13)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+ "text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels")+"</A>");

	if ( !( (start+13) > maxRecord ) )
	out.println("<A HREF='../../eXH/jsp/ReviewCommProcessOutbound.jsp?facility="+facility+"&comm_client="+comm_client+
	"&from="+(start+13)+"&to="+(end+13)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+
	"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels")+"</A>"); 
	%>
</td>
</tr>
</table>
</p>
<br><br>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER'width='2%'></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.ProcessID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.StartDateTimee.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.TotalMessages.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.LastCommnTime.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Retries.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.LastMessageID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/></td>
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

String imgsrc="../../eCommon/images/dark_blue_square.jpg";
String PROCESS_STATUS=rs.getString("PROCESS_STATUS"); if(PROCESS_STATUS==null)  PROCESS_STATUS="";
String APPLICATION_ID=rs.getString("APPLICATION_ID"); if(APPLICATION_ID==null)  APPLICATION_ID="";

String START_DATE_TIME=""; 
String processDate="";
processDate=rs.getString("START_DATE_TIME")==null?"":rs.getString("START_DATE_TIME");
if(!processDate.equals("")) START_DATE_TIME =com.ehis.util.DateUtils.convertDate(processDate,"DMYHMS","en",locale);

int  TOTAL_MESSAGES=rs.getInt("TOTAL_MESSAGES"); 

String endDate="";
String LAST_COMM_DATE_TIME="";
endDate=rs.getString("LAST_COMM_DATE_TIME")==null?"":rs.getString("LAST_COMM_DATE_TIME");
if(!endDate.equals("")) LAST_COMM_DATE_TIME =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);

int LAST_OUTBOUND_RETRIES=rs.getInt("LAST_OUTBOUND_RETRIES"); 
String LAST_MESSAGE_ID=rs.getString("LAST_MESSAGE_ID"); if(LAST_MESSAGE_ID==null)  LAST_MESSAGE_ID="";
String PROCESS_ID=rs.getString("PROCESS_ID"); if(PROCESS_ID==null)  PROCESS_ID="";
String APPLICATION_NAME=rs.getString("APPLICATION_NAME");  if(APPLICATION_NAME==null)  APPLICATION_NAME="";

if(PROCESS_STATUS.equalsIgnoreCase("A")) imgsrc="../../eCommon/images/green_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("C")) imgsrc="../../eCommon/images/red_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("S")) imgsrc="../../eCommon/images/pink_square.jpg";
if(PROCESS_STATUS.equalsIgnoreCase("W")) imgsrc="../../eCommon/images/yello_square.jpg";
%>
<tr>
<td nowrap class='<%=strTDClass%>' ><img src='<%=imgsrc%>' width=15 height=15 ></td>
<td nowrap class='<%=strTDClass%>'>
<a id="link" href='#' onClick='openLink(this)'
appl_Id='<%=APPLICATION_ID%>' st_date_time='<%=START_DATE_TIME%>' tot_msg='<%=TOTAL_MESSAGES%>' last_comm='<%=LAST_COMM_DATE_TIME%>' retries='<%=LAST_OUTBOUND_RETRIES%>' last_msg_id='<%=LAST_MESSAGE_ID%>' process_id='<%=PROCESS_ID%>' process_status='<%=PROCESS_STATUS%>' appl_Name='<%=APPLICATION_NAME%>' >
&nbsp;<%=APPLICATION_NAME%>
</a>
</b>
</td>
<td nowrap class='<%=strTDClass%>' >&nbsp;<%=PROCESS_ID%></td>
<td nowrap class='<%=strTDClass%>' >&nbsp;<%=START_DATE_TIME%></td>
<td nowrap class='<%=strTDClass%>'>&nbsp;<%=TOTAL_MESSAGES%></td>
<td nowrap class='<%=strTDClass%>'>&nbsp;<%=LAST_COMM_DATE_TIME%></td>
<td nowrap class='<%=strTDClass%>'>&nbsp;<%=LAST_OUTBOUND_RETRIES%></td>
<td nowrap class='<%=strTDClass%>'>&nbsp;<%=LAST_MESSAGE_ID%></td>
<td nowrap class='<%=strTDClass%>' align=center><input type=radio name=c1 id=c1 onClick="validatecheck(this)"
appl_Id='<%=APPLICATION_ID%>' st_date_time='<%=START_DATE_TIME%>' tot_msg='<%=TOTAL_MESSAGES%>' last_comm='<%=LAST_COMM_DATE_TIME%>' retries='<%=LAST_OUTBOUND_RETRIES%>' last_msg_id='<%=LAST_MESSAGE_ID%>' process_id='<%=PROCESS_ID%>' process_status='<%=PROCESS_STATUS%>' appl_Name='<%=APPLICATION_NAME%>'></td>
<%
i++;
p_rec_cnt++;
}//endwhile         

%>
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

<%    
}
if(rs!=null)	rs.close();
if(pstmt!=null)	pstmt.close();
}catch(Exception e)
	{
		e.toString();
		out.println(e.toString());
		e.printStackTrace(System.err);
     }
	finally   
	{
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    }  
%>
</form>
</body>
</html>

