<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHReturnArray" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
XHReturnArray arr=new XHReturnArray();	  
    String appl_name = request.getParameter("appl_name");
	String appdes = request.getParameter("appdes");

	String facility_name = request.getParameter("facility_name");
	String facdes = request.getParameter("facdes");

	String msg_type = request.getParameter("msg_type");
	String msgdes = request.getParameter("msgdes");

	String event_type = request.getParameter("event_type");
	String eventdes = request.getParameter("eventdes");

	String msg_id = request.getParameter("msg_id");
	String msg_date = request.getParameter("msg_date");
	//	msg_status	patient_id
    String client_id = request.getParameter("client_id");
	String mode = request.getParameter("mode");

	String msg_status = request.getParameter("msg_status");
	//System.out.println("msg_status :"+msg_status);
	
	String patient_id = request.getParameter("patient_id");
	//System.out.println("patient_id :"+patient_id);


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
	ostmt.setString(1,facility_name);
	ostmt.setString(2,appl_name);
	ostmt.setString(3,msg_id);
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


String  msgsql="";

if(mode.equals("FT"))
{
	
 msgsql="SELECT  INBOUND_MESSAGE_TEXT ,MESSAGE_STATUS"+
" FROM xh_inbound_message "+
" WHERE APPLICATION_ID=NVL('"+appl_name+"',APPLICATION_ID)"+
" AND CLIENT_ID=NVL('"+client_id+"',CLIENT_ID)"+
" AND TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')) "+
" AND MESSAGE_ID=NVL('"+msg_id+"',MESSAGE_ID)";
//" AND NVL(MESSAGE_STATUS,'')=NVL('"+msg_status+"',MESSAGE_STATUS)";
//" AND MESSAGE_STATUS=NVL('"+msg_status+"',MESSAGE_STATUS)";

}

else{
if (msg_status.equals("")){
msgsql="SELECT  MESSAGE_TEXT , message_status"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+appl_name+"',application_id)"+
" AND facility_id = NVL('"+facility_name+"',facility_id)"+
" AND message_type= NVL('"+msg_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND message_id = NVL('"+msg_id+"',message_id) ";
//" AND message_status = NVL('A',message_status)";
}
else
	{

	   msgsql="SELECT  MESSAGE_TEXT , message_status"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+appl_name+"',application_id)"+
" AND facility_id = NVL('"+facility_name+"',facility_id)"+
" AND message_type= NVL('"+msg_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND message_status = NVL('"+msg_status+"',message_status)";
	
	}


	     

}

String curr_user_id=(String)session.getValue("login_user");
String usrsql="Select VIEW_YN, REPLAY_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
ResultSet rs=null;
Statement stmt=null;
stmt=con.createStatement();
rs=stmt.executeQuery(msgsql);

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
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(viewflag==null) viewflag="";
if(replayflag==null) replayflag="";

}	catch (Exception e) {e.printStackTrace(System.err) ;}
    finally{ConnectionManager.returnConnection(con); }
	
if(msgstatus==null) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
int_msgstatus="Pending";
if(msgstatus!=null){ 
if(msgstatus.equalsIgnoreCase("S")) //int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Sucessfull.Label","xh_labels");
int_msgstatus="Successful";
if(msgstatus.equalsIgnoreCase("R")) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Rejected.Label","xh_labels");
int_msgstatus="Rejected";
if(msgstatus.equalsIgnoreCase("F")) //int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Failure.Label","xh_labels");
int_msgstatus="Failure";
if(msgstatus.equalsIgnoreCase("A")) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.All.Label","xh_labels");
int_msgstatus="All";
}

String segment[][]=null;
String segment1[][]=null;
String temp[][]=null;

HashMap hasmap=null;
if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);

if(hasmap!=null){ segment=(String[][])hasmap.get("segment");
 if(segment!=null){
 temp=new String[segment.length][2];
for(int i=1;i<segment.length;i++)
{
   if(segment[i][0].equals(segment[i-1][0]))
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
temp[segment.length-1][0]=segment[segment.length-1][0];
temp[segment.length-1][1]=segment[segment.length-1][1];
session.putValue("SegmentValues",temp);  
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
%>


<body onLoad="load()">
<form name="menu_treetext" id="menu_treetext" >
<input type="hidden" name="viewflag" id="viewflag"  value="<%=viewflag%>"/>
<input type="hidden" name="replayflag" id="replayflag" value="<%=replayflag%>"/>
<input type="hidden" name="mode_insert" id="mode_insert"/>


<input type="hidden" name="appl_name" id="appl_name"  value="<%=appl_name%>"/>
<input type="hidden" name="appdes" id="appdes" value="<%=appdes%>"/>
<input type="hidden" name="facility_name" id="facility_name"  value="<%=facility_name%>"/>
<input type="hidden" name="facdes" id="facdes" value="<%=facdes%>"/>
<input type="hidden" name="msg_id" id="msg_id"  value="<%=msg_id%>"/>
<input type="hidden" name="event_type" id="event_type" value="<%=event_type%>"/>
<input type="hidden" name="eventdes" id="eventdes" value="<%=eventdes%>"/>
<input type="hidden" name="msg_type" id="msg_type" value="<%=msg_type%>"/>
<input type="hidden" name="msgdes" id="msgdes" value="<%=msgdes%>"/>
<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>


<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>
<tr></tr>
<tr></tr>
<tr><td class='fields'><textarea rows=27 cols=92><%=msgtext%></textarea></td></tr>
<tr>
<td><input class='button' id="Close" type="button" name='Close' id='Close' value='Close' onClick="funClose()">
<td id="d1" style="display:block" ><input class='button' id="viewbtton" type="button" name='auditlog' id='auditlog' value='Audit Log' onClick="goToAuditLog('<%=appl_name%>','<%=appdes%>','<%=facility_name %>','<%=facdes %>','<%=msg_id%>','<%=event_type %>','<%=eventdes %>')"><input class='button' id="replaybtton" type="button"  name='query' id='query' value='Query' disabled  onClick=''><input class='button'  id="viewbtton1" type="button" name='views' id='views' value='View' onClick="goToView()"><input class='button' id="replaybtton1" type="button"  name='replays' id='replays' value='Replay' onClick='replayMethod();'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status &nbsp;&nbsp;<input type="text"  name="message_status" id="message_status" id="message_status" size=25 value='<%=int_msgstatus%>'>
<td id="d2" style="display:none" ><input class='button' id="viewbtton" type="button" name='auditlog' id='auditlog' value='View' onClick="goToView()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status&nbsp;&nbsp;<input type="text"  name="message_status" id="message_status" id="message_status" size=25 value='<%=int_msgstatus%>'>
</td>
</tr>
</table>				    
</form>
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
function funClose()
{
	window.close();
}


function load()
{
alert()
if(this.document.forms[0].viewflag.value=='Y') this.document.forms[0].views.disabled=false;
else this.document.forms[0].views.disabled=true;


if(this.document.forms[0].replayflag.value=='Y') this.document.forms[0].replays.disabled=false;
else this.document.forms[0].replays.disabled=true;

if(this.document.forms[0].mode.value=='FT')
{
 var ww=document.getElementById("d1");
 var www=document.getElementById("d2");
 ww.style.display="none";
 www.style.display="block";
}

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
    
	await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp",arguments,features);  
}
//**************************************************************************************************
function replayMethod()
{
   this.document.menu_treetext.mode_insert.value='R';
   this.document.menu_treetext.action = '../../eXH/jsp/ReviewApplMessageMenuMessageText.jsp';
   this.document.menu_treetext.submit();
}
//********************************************************************************************************

function goToView()
{	 
	var dialogHeight = "50";
	var dialogWidth  = "50";
	var dialogTop    = "50";
	var dialogLeft   = "50";
	var features1     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
    var url="../../eXH/jsp/ViewSegments.jsp";
 	window.open(url,null,"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");



}
//********************************************************************************************************
</script>

