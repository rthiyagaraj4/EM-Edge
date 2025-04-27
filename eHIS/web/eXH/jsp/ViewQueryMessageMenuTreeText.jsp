<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHReturnArray,eXH.XHDBAdapter" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<% 
String mode=(String)session.getAttribute("mode");
String applicationId="";
String applicationName=request.getParameter("applicationName");  
String QueryOption="";
String facilityId="";
String facilityName=request.getParameter("facilityname");
String msgId=XHDBAdapter.checkNull(request.getParameter("msgId"));
String eventType="";
String applicationid=request.getParameter("application_id");
String Facility_id=request.getParameter("Facility_id");
String eventtype=request.getParameter("eventype");
String eventName="";
String protocollinkid=request.getParameter("protocollinkid");

//System.out.println("applicationName :"+applicationName);
 QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));

//XHReturnArray arr=new XHReturnArray();
/*if(mode!=null){        
if(mode.equalsIgnoreCase("A")){
 applicationName=request.getParameter("applicationName");
  facilityName=request.getParameter("facilityName");

 QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));
}}
else{
  applicationName=request.getParameter("applicationName");
  facilityName=request.getParameter("facilityName");
 //msgId=request.getParameter("msgId");
 QueryOption=request.getParameter("Query_Option");
 }*/


String msgtext="";
String msgstatus="";
String int_msgstatus="";
String viewflag="";
String replayflag="";
String mode_insert = request.getParameter("mode_insert");
 Connection con = ConnectionManager.getConnection(request);
 try{

if(mode_insert!=null)
{
	CallableStatement ostmt = null; 
    String message_text2="";
    ostmt = con.prepareCall("{ call XHMSG.REPLAY(?,?,?,?,?) }" ); 
	ostmt.setString(1,facilityId);
	ostmt.setString(2,applicationId);
	ostmt.setString(3,msgId);
  	ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
	ostmt.execute();
	message_text2 = ostmt.getString(4);	

	if(message_text2.equals("0"))
	{
		con.commit();
	 } else {
			con.rollback();
			}
    ostmt.close();
}
String sql="";
if(mode!=null){
if(mode.equalsIgnoreCase("A")){



if(QueryOption.equalsIgnoreCase("P"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";


}
     else if(QueryOption.equalsIgnoreCase("A"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message_ob"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
//System.out.println("2ndithula"+sql);
	}
	else
	{
		sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";


	}

	}

else if(mode.equalsIgnoreCase("D")){
if(QueryOption.equalsIgnoreCase("P"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
}
     else if(QueryOption.equalsIgnoreCase("A"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message_ob"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";

	}
	else if(QueryOption.equals(""))
	{
		sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
	}

	}

}
else{

 /*sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )"; */
/*if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
	{	
	 sql="SELECT MESSAGE_TEXT,message_status FROM XP_EVENT"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
	
	}
	else{

	sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
	
	}*/
}
//System.out.println("sql 152:"+sql);
String curr_user_id=(String)session.getValue("login_user");
String usrsql="Select VIEW_YN, REPLAY_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
ResultSet rs=null;
Statement stmt=null;

stmt=con.createStatement();
rs=stmt.executeQuery(sql);
while(rs.next())
{ 
      msgtext= rs.getString(1);
	  msgstatus=rs.getString(2);
}
if(rs!=null) rs.close();
rs=stmt.executeQuery(usrsql);
while(rs.next())
{ 
      viewflag= rs.getString(1);
	  replayflag=rs.getString(2);
}
if(viewflag==null) viewflag="";
if(replayflag==null) replayflag="";
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
}	catch (Exception e) {
		out.println("error in tree"+e.toString()) ;
		e.printStackTrace(System.err) ;
	}
		finally {
			
			ConnectionManager.returnConnection(con) ;
		}
if(msgstatus==null) 
int_msgstatus="Pending";
if(msgstatus!=null){ 
if(msgstatus.equalsIgnoreCase("S")) int_msgstatus="Successful";
if(msgstatus.equalsIgnoreCase("R")) 
int_msgstatus="Rejected";
if(msgstatus.equalsIgnoreCase("F")) int_msgstatus="Failure";
if(msgstatus.equalsIgnoreCase("A")) 
int_msgstatus="All";
}

/*try
{
String segment[][]=null;
String segment1[][]=null;
String temp[][]=null;

HashMap hasmap=null;
System.out.println("LENGTH----- "+msgtext.length());
if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);

if(hasmap!=null){ segment=(String[][])hasmap.get("segment");
 if(segment!=null){
 temp=new String[segment.length][2];
for(int i=1;i<segment.length;i++)
{
    String segstr="";
	if(segment[i][0].toString().trim()==null)
	{
		segstr="";
	}
	else
	{
		 segstr=XHDBAdapter.checkNull(segment[i][0].toString());
	}

String segnextstr=XHDBAdapter.checkNull(segment[(i-1)][0].toString());
	System.out.println("segment[i][0] :"+segment[i][0]);
   if(segstr.equals(segnextstr))
	{
	  temp[i-1][0]=segment[i-1][0]+""+i+"";
	  temp[i-1][1]=segment[i-1][1];

	}

	else
	{
	  temp[i-1][0]=segment[i-1][0];
	  temp[i-1][1]=segment[i-1][1];

	}

}
if(segment.length!=0){
temp[segment.length-1][0]=segment[segment.length-1][0];
temp[segment.length-1][1]=segment[segment.length-1][1];
session.putValue("SegmentValues",temp);  
}
}
}
if(temp!=null){
}

if(segment!=null){
for(int i=0;i<temp.length;i++)
{
segment1=(String[][])hasmap.get("comp"+i);
session.putValue(temp[i][0],segment1);  
}
}
if(hasmap!=null) hasmap.clear();


}
catch(Exception e)
{
	System.out.println("Exception e :"+e);
}*/
%>
<body onload="load();">
<form name="menu_treetext1" id="menu_treetext1">
<input type="hidden" name="viewflag" id="viewflag"  value="<%=viewflag%>"/>
<input type="hidden" name="replayflag" id="replayflag" value="<%=replayflag%>"/>
<input type="hidden" name="mode_insert" id="mode_insert"/>
<input type="hidden" name="application_id" id="application_id" value='<%=applicationid%>' />
<input type="hidden" name="Facility_id" id="Facility_id" value='<%=Facility_id%>' />
<input type="hidden" name="eventype" id="eventype" value='<%=eventtype%>' />
<input type="hidden" name="protocollinkid" id="protocollinkid" value='<%=protocollinkid%>' />
<input type="hidden" name=msg_id id=msg_id value='<%=msgId%>' />


<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>
<tr></tr>
<tr></tr>
<tr></tr>
<tr><td class='fields'><textarea name=msgtxt rows=41 cols=112 readonly><%=msgtext%></textarea></td></tr>
<td><input class='button' id="viewbtton" type="button" name='auditlog' id='auditlog' value='Audit Log' onClick="goToAuditLog('<%=applicationId%>','<%=applicationName%>','<%=facilityId %>','<%=facilityName %>','<%=msgId%>',	'<%=eventType %>','<%=eventName %>')"> <!--<input class='button' id="replaybtton" type="button"  name='query' id='query' value='Query' disabled  onClick=''>--->
<input class='button' id="viewbtton1" type="button" name='views' id='views' value='View'  onClick='goToView()'  >
<!--<input class='button' id="replaybtton1" type="button"  name='replays' id='replays' value='Replay'  onClick='replayMethod();'>--> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;Status&nbsp;&nbsp;<input type="text"  name="comm_client" id="comm_client" id="comm_client" size=25 value='<%=int_msgstatus%>'>
</td>
</table>
</form name=menu_treetext1>
</body>
</html>

<script>
//**********************************************************************************************/
var dialogHeight = "250";
var dialogWidth  = "250";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
//*********************************************************************************************/
function load()
{


/*if(this.document.forms[0].viewflag.value=='Y') this.document.forms[0].views.disabled=false;
else //this.document.forms[0].views.disabled=true;


//if(this.document.forms[0].replayflag.value=='Y') this.document.forms[0].replays.disabled=false;
//else this.document.forms[0].replays.disabled=true;*/
}
//**************************************************************************************************
async function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)
{
	var arguments  =new Array();
	arguments[0]='L';
	arguments[1]=applicationId;
	arguments[2]=applicationName;
    arguments[3]=facilityId;
	arguments[4]=facilityName;
	arguments[5]=msgId;
    arguments[6]=eventType;
	arguments[7]=eventName;
  await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp?applicationId="+document.forms[0].application_id.value+"&applicationName="+applicationName+"&facilityName="+facilityName+"&facilityId="+document.forms[0].Facility_id.value+"&eventName="+document.forms[0].eventype.value+"&protocollinkid="+document.forms[0].protocollinkid.value+"&msgId="+document.forms[0].msg_id.value,arguments,features);  
}
//**************************************************************************************************
function replayMethod()
{
   this.document.menu_treetext1.mode_insert.value='R';
   this.document.menu_treetext1.action = '../../eXH/jsp/ViewQueryMessageMenuTreeText.jsp';
   this.document.menu_treetext1.submit();
}
//********************************************************************************************************

async function goToView()
{
	var arguments  =new Array();
	var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
    arguments[0]=document.forms[0].application_id.value;
	arguments[1]=document.forms[0].Facility_id.value;
	arguments[2]=document.forms[0].eventype.value;
	arguments[3]=document.forms[0].protocollinkid.valu;
    arguments[4]=document.forms[0].msg_id.value;

    var url="../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id="+document.forms[0].application_id.value+"&Facility_Id="+document.forms[0].Facility_id.value+"&eventype="+document.forms[0].eventype.value+"&protocollinkid="+document.forms[0].protocollinkid.value+"&msg_id="+document.forms[0].msg_id.value;



await window.showModalDialog(url,arguments,features);  
// window.open(url,null,"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");

 

}
//********************************************************************************************************
</script>

