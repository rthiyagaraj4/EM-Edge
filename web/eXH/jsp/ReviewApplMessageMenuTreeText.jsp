<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHReturnArray,webbeans.eCommon.*" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>

<head>
<%

String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
String sub_module = request.getParameter("sub_module");

Connection con = null;

// System.out.println("sub_module13"+sub_module);

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src="../../eCommon/js/messages.js"></script>
<script language='javascript' src="../../eXH/js/XHAjaxUtil.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
 
<%
//String rule=request.getParameter("rules");
//String mode=request.getParameter("mode");
String protocol_mode = request.getParameter("protocol_mode");
String queueType = request.getParameter("queueType");
String applicationId = "";
String applicationName = "";
String facilityId = "";
String facilityName = "";						    
String msgId = "";
String eventType = ""; 
String eventName = "";
String msgtext = "";
String protocol_link_id = "";
String Proto_type = "";
// MessageManager mm = new MessageManager();

//Properties p = (Properties) session.getValue("jdbc");	
//String locale  = p.getProperty("LOCALE");

// XHReturnArray arr = new XHReturnArray();

eventName = request.getParameter("eventName");
applicationName = request.getParameter("applicationName");
String srlNo = request.getParameter("srlNo");

if(protocol_mode != null && protocol_mode.equalsIgnoreCase("I"))
{	 
	 applicationId = request.getParameter("applicationId");
	 facilityName = request.getParameter("facilityName");
	 msgId = request.getParameter("msgid");
	 facilityId = request.getParameter("facilityId");
	 eventType = request.getParameter("eventType");
	 protocol_link_id = request.getParameter("protocol_link_id");
}
else if(protocol_mode != null && protocol_mode.equalsIgnoreCase("O"))
{
    applicationId = request.getParameter("applicationId");
    facilityId = request.getParameter("facilityId");
    facilityName = request.getParameter("facilityName");
    msgId = request.getParameter("msgid");
    eventType = request.getParameter("eventType");
    protocol_link_id = request.getParameter("protocol_link_id");
}

String msgstatus = "";
String int_msgstatus = "";
String viewflag = "";
String replayflag = "";
String auditFlag = "";
String mode_insert = request.getParameter("mode_insert");

con = ConnectionManager.getConnection(request);

try
{
	if(mode_insert!=null)
	{
		CallableStatement ostmt = null; 
		String message_text2 = "";		

		ostmt = con.prepareCall("{ call XHMSG.REPLAY(?,?,?,?,?,?) }" ); 
		ostmt.setString(1,facilityId);
		ostmt.setString(2,applicationId);
		ostmt.setString(3,msgId);
		ostmt.setString(4,queueType);
		ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		ostmt.execute();
		message_text2 = ostmt.getString(5);	
		if(message_text2.equals("0"))
		{
			con.commit();
			%>
			<SCRIPT> alert(getMessage('XH1001')); </SCRIPT>
			<%
		}
		else
		{
			con.rollback();
		}
		ostmt.close();
	}

	String sql = "";

	if(protocol_mode != null && protocol_mode.equalsIgnoreCase("I"))
	{
		sql = "SELECT INBOUND_MESSAGE_TEXT,message_status FROM "+sub_module+"_INBOUND_MESSAGE" +
				" WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "+
				" AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"+
				" AND facility_id=NVL('"+facilityId+"',facility_id)"+
				" AND SRL_NO=NVL('"+srlNo+"',SRL_NO)";
	}
	else if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("O"))
	{														  

		/*	sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )"; 
		*/

		if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
		{	
			sql="SELECT MESSAGE_TEXT,message_status FROM XP_EVENT"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
		}
		else
		{
			sql="SELECT MESSAGE_TEXT,message_status FROM "+sub_module+"_APPLICATION_MESSAGE"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
		}
	}

	//System.out.println("(ReviewApplMessageMenuTreeText:msg)Query: "+sql);

	String curr_user_id = (String)session.getValue("login_user");
	String usrsql = "Select VIEW_YN,REPLAY_YN,AUDIT_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
	//System.out.println("usrsql :"+usrsql);

	ResultSet rs = null;
	Statement stmt = null;
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	while(rs.next())
	{ 
		msgtext = rs.getString(1);
		msgstatus = rs.getString(2);
		//System.out.println("msgtext excute time"+msgtext);
	}

	if(rs != null) rs.close();
	rs = stmt.executeQuery(usrsql);

	while(rs.next())
	{ 
		viewflag = rs.getString(1);
		replayflag = rs.getString(2);
		auditFlag = rs.getString(3);
	}
	if(viewflag == null) viewflag = "";
	if(replayflag == null) replayflag = "";
	if(auditFlag == null) auditFlag = "";
	if(rs != null) rs.close();
	if(stmt!= null) stmt.close();
}	
catch (Exception e) 
{
	out.println("error in tree"+e.toString()) ;
	e.printStackTrace(System.err) ;
}
finally 
{

}




if(protocol_mode.equals("I"))
{
	if(msgstatus==null)
	{
		//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
		int_msgstatus="Pending";
	}
	if(msgstatus!=null)
	{ 
		if(msgstatus.equalsIgnoreCase("S"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0062") ;
		//	final java.util.Hashtable mesg = mm.getMessage(con,"XH0062") ;
			int_msgstatus = "Received";
		}
		if(msgstatus.equalsIgnoreCase("L"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0061") ;
			int_msgstatus = "Message Loaded";
		}
		if(msgstatus.equalsIgnoreCase("E"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0063") ;
			int_msgstatus = "Loading Error";
		}
	}
}
else if(protocol_mode.equals("O"))
{
	if(msgstatus==null)
	{	
//		int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
		int_msgstatus="Pending";
	}
	if(msgstatus!=null)
	{ 
		if(msgstatus.equalsIgnoreCase("S"))
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0065") ;
			int_msgstatus = "Successfully sent";
		}
		if(msgstatus.equalsIgnoreCase("R"))
		{	
		//	int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Rejected.Label","xh_labels");
			int_msgstatus="Rejected";
		}
		if(msgstatus.equalsIgnoreCase("F")) 
		{
		//	int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Failure.Label","xh_labels");
			int_msgstatus="Failed";
		}
		if(msgstatus.equalsIgnoreCase("E")) 
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0064") ;
			int_msgstatus = "Error in Sending";
		}
		if(msgstatus.equalsIgnoreCase("A")) 
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0060") ;
			int_msgstatus = "Acknowledgement Received";
		}
    }
 }
/*
	String segment[][]=null;
	String segment1[][]=null;
	String temp[][]=null;
	HashMap hasmap=null;
	System.out.println("jsp :"+msgtext);
	if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);
	if(hasmap!=null){ segment=(String[][])hasmap.get("segment");System.out.println("segment"+segment);
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

	if(segment1!=null)
	{
	session.putValue(temp[i][0],segment1);
	}


	//session.putValue(temp[i][0],segment1);  
	}
	}
	if(hasmap!=null) hasmap.clear();
*/
%>

<body onLoad="load()">
<form name="menu_treetext1" id="menu_treetext1">
<input type="hidden" name="viewflag" id="viewflag" value="<%=viewflag%>"/>
<input type="hidden" name="replayflag" id="replayflag" value="<%=replayflag%>"/>
<input type="hidden" name="auditFlag" id="auditFlag" value="<%=auditFlag%>"/>
<input type="hidden" name="mode_insert" id="mode_insert"/>
<input type="hidden" name="sub_module" id="sub_module" value="<%= sub_module %>"/>
<input type="hidden" name="protocol_mode" id="protocol_mode" value="<%= protocol_mode %>"/>
<input type="hidden" name="applicationName" id="applicationName" value="<%= applicationName %>"/>
<input type="hidden" name="applicationId" id="applicationId" value="<%= applicationId %>"/>
<input type="hidden" name="facilityName" id="facilityName" value="<%= facilityName %>"/>
<input type="hidden" name="msgid" id="msgid" value="<%= msgId %>"/>
<input type="hidden" name="facilityId" id="facilityId" value="<%= facilityId %>"/>
<input type="hidden" name="eventType" id="eventType" value="<%= eventType %>"/>
<input type="hidden" name="protocol_link_id" id="protocol_link_id" value="<%= protocol_link_id %>"/>
<input type="hidden" name="queueType" id="queueType" value="<%= queueType %>"/>


<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>
<tr>
<%

// conn = ConnectionManager.getConnection(request);
ResultSet rs1 = null;
Statement stmt1 = null;
try
{
	stmt1 = con.createStatement();
	String Query = "SELECT protocol_type FROM xh_protocol X,xh_protocol_link Y WHERE X.protocol_id=Y.protocol_id AND Y.protocol_link_id='"+protocol_link_id+"'";
	//System.out.println("Query"+Query);

	rs1=stmt1.executeQuery(Query);
	while(rs1.next())
	{ 
		Proto_type = rs1.getString(1);		
	}
}
catch(Exception e)
{
	e.printStackTrace(System.err) ;
}
finally
{
	if(rs1!=null) rs1.close();
    if(stmt1!=null) stmt1.close();
	ConnectionManager.returnConnection(con) ;
}
/*	session.setAttribute("application_Id",applicationId); 
	session.setAttribute("Facility_Id",facilityId);
	session.setAttribute("Msg_Id",msgId);
	session.setAttribute("Even_type",eventType);
	session.setAttribute("Message_Text",msgtext);
	session.setAttribute("protocol_link_id",protocol_link_id);
*/


%>
</tr>

<tr></tr>
<tr></tr>

<tr><td class='fields'><textarea name="Msg_desc" id="Msg_desc" rows=41 cols=112 readOnly><%=msgtext%></textarea></td></tr>

<tr>
	<td>
	<input type="hidden" name="Protocol_value" id="Protocol_value" value='<%=Proto_type%>'/>
	<input type="hidden" name="rule_txt" id="rule_txt" value='<%=protocol_mode%>' />
	<input class='button' id="viewbtton" type="button" name='auditlog' id='auditlog' value='Audit Log' onClick="goToAuditLog('<%=applicationId%>','<%=applicationName%>','<%=facilityId %>','<%=facilityName %>','<%=msgId%>','<%=eventType %>','<%=eventName %>')"> 
<!--<input class='button' id="replaybtton" type="button"  name='query' id='query' value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' disabled  onClick=''>--->
	<input class='button' id="viewbtton1" type="button" name='views' id='views' value='View' onClick="goToView()"> 
	<input class='button' id="replaybtton1" type="button"  name='replays' id='replays' value='Replay'  onClick='replayMethod();'>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	Status &nbsp;&nbsp;<input type="text"  name="comm_client" id="comm_client" id="comm_client" size=45 value='<%=int_msgstatus%>'>
	<input type="hidden" name="msgStatus" id="msgStatus" id="msgStatus" value="<%= msgstatus %>">
	</td>

</tr>
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
	appID = document.forms[0].applicationId.value;
	facilityID = document.forms[0].facilityId.value;
	msgID = document.forms[0].msgid.value;		

	if(this.document.forms[0].rule_txt.value == 'I')
	{
		document.getElementById("replaybtton1").style.display = "none";
	}
	else
	{
		var msgStatus = this.document.forms[0].msgStatus.value;
		
	//	document.getElementById("replaybtton1").style.display="block";
		if(this.document.forms[0].viewflag.value == 'Y') 
		{
			this.document.forms[0].views.disabled = false;
		}
		else 
		{
			this.document.forms[0].views.disabled = true;
		}
		if(this.document.forms[0].replayflag.value == 'Y' && (msgStatus != 'null')) 
		{				
			this.document.forms[0].replays.disabled = false;
		}
		else 
		{			
			this.document.forms[0].replays.disabled = true;
		}
		if(this.document.forms[0].auditFlag.value == 'Y') 
		{	
			// Checking whether audit history exists or not.
			var auditExistsQry = "SELECT 1 FROM xh_application_message_audit WHERE APPLICATION_ID='"+appID+"'"+
								" AND MESSAGE_ID='"+msgID+"' AND FACILITY_ID='"+facilityID+"'";
	
			var val = getValue(auditExistsQry);	
			val = val.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

			if(val == "Y") // val = Y indicates that audit exists for this message
			{				
				this.document.forms[0].auditlog.disabled = false;
			}
			else 
			{
				this.document.forms[0].auditlog.disabled = true;
			}
		}
		else 
		{
			this.document.forms[0].auditlog.disabled = true;
		}
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

	url = "applicationId="+applicationId+"&applicationName="+applicationName+"&facilityId="+facilityId+"&eventName="+eventName+"&msgId="+msgId+"&eventType="+eventType+"&facilityName="+facilityName;
    
	await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp?"+url,arguments,features);  
}
//**************************************************************************************************
function replayMethod()
{
   this.document.menu_treetext1.mode_insert.value='R';
   this.document.menu_treetext1.action = '../../eXH/jsp/ReviewApplMessageMenuTreeText.jsp';
   this.document.menu_treetext1.submit();
}
//********************************************************************************************************

async function goToView()
{
		//var dialogHeight = "50";
	//var dialogWidth  = "50";
	//var dialogTop    = "50";
	//var dialogLeft   = "50";
	//var features1     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
    //var url="../../eXH/jsp/ViewSegments.jsp";
 //window.open(url,null,"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");
/*var dialogHeight= "50" ;
	var dialogWidth	= "70" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;*/
	
 // window.showModalDialog("../../eXH/jsp/ViewSegmentsTree.jsp",arguments,features);
    var arguments  =new Array();
    await window.showModalDialog('../../eXH/jsp/ViewSegmentsTree.jsp?srlNo=<%=srlNo%>&application_Id=<%=applicationId%>&Facility_Id=<%=facilityId%>&Msg_Id=<%=msgId%>&Even_type=<%=eventType%>&protocol_link_id=<%=protocol_link_id%>&sub_module=<%=sub_module%>&protocol_mode=<%=protocol_mode%>',arguments,features);

 //window.showModalDialog("../../eXH/jsp/ViewSegmentsTree.jsp",arguments,features);
//window.showModalDialog("../../eXH/jsp/ViewSegmentsTree.jsp","Reviewformate",100,100);

} 
//********************************************************************************************************
</script>

