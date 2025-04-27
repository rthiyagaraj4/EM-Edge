<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<HEAD>

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Properties p = (Properties) session.getValue("jdbc"); 
String loggedUser = p.getProperty("login_user"); 	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel='StyleSheet' href='../../eXH/html/menu.css' type='text/css'></link>
<style>
	div {float: left}  
	.testSty
	{ width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}
</style> 
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script> 
<script language="JavaScript">
//****************************************************************************************
function callSort(obj)
{
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	
   this.document.forms[0].orderbycolumns.value=obj;
      parent.messageFrame.location.href = "../../eCommon/html/blank.html";
 //  parent.f_query_detail.location.href="../../eCommon/html/blank.html";
   this.document.forms[0].action='../../eXH/jsp/ViewQryMsgDtl.jsp';

   this.document.forms[0].target='';
   this.document.forms[0].submit();
}
//****************************************************************************************
function funShow(obj)
{
  //  this.document.forms[0].QUERYTEXT.value = obj.getAttribute('QUERYTEXT');
	this.document.forms[0].STATUSTEXT.value = obj.getAttribute('STATUSTEXT');
	this.document.forms[0].QUERYID.value= obj.getAttribute('QUERYID');
	this.document.forms[0].Application_id.value= obj.getAttribute('Application_id');
    this.document.forms[0].Facility_id.value= obj.getAttribute('Facility_id');
    this.document.forms[0].event_type.value= obj.getAttribute('eventtype');
	this.document.forms[0].Protocollink_id.value= obj.getAttribute('protocollink');
	this.document.forms[0].qapplname.value=obj.getAttribute('Appliname');
	this.document.forms[0].qfacility.value=obj.getAttribute('faciname');
	this.document.forms[0].msg_id.value=obj.getAttribute('msg_id');
 	var appl_msg=escape(obj.getAttribute('Application_Msg'));
	this.document.forms[0].position.value=obj.getAttribute('posi');

    var err_msg=escape(obj.getAttribute('error_msg'));
var commExpAut	= document.getElementById("commExpAut").value;
var viewAuth=this.document.forms[0].viewAuth.value;

    /*this.document.forms[0].qostatus.value;
    this.document.forms[0].qmsg_id1.value;
    this.document.forms[0].qmsg_id2.value;
    this.document.forms[0].sortMode1.value;*/
	var reviewLabel			= "Message Review";
//	var reprocessLabel		= "Reprocess query"; 
 //   var responseLabel       = "Response";
    //var auditLabel       = "Audit Log";
    var messageViewerLabel       = "Message Viewer";

    var linkset	= new Array();
	var disabled = ""; 
//	var responseMsgLink = '<a href="#" onClick='+'\''+'responce();'+'\''+'>'+responseLabel+'</a>';		
	//var reprocessLink   = '<a href="#" onClick='+'\''+'reprocessQuery();'+'\''+'>'+reprocessLabel+'</a>';		
		
	//var auditLink      = '<a href="#" onClick='+'\''+'goToAuditLog("'+this.document.forms[0].Application_id.value+'","'+this.document.forms[0].qapplname.value+'","'+this.document.forms[0].Facility_id.value+'","'+this.document.forms[0].qfacility.value+'","='+this.document.forms[0].QUERYID.value+'","'+this.document.forms[0].event_type.value+'","'+this.document.forms[0].event_type.value+'");'+'\''+'>'+auditLabel+'</a>';				
   

if(commExpAut=="true" && viewAuth=="true")
	{
	var reviewLink      = '<a href="#" onClick='+'\''+'review("'+appl_msg+'","'+err_msg+'");'+'\''+'>'+reviewLabel+'</a>';	 
	var messageLink      = '<a href="#" onClick='+'\''+'goToView();'+'\''+'>'+messageViewerLabel+'</a>';	
     linkset[0] = reviewLink;
	 linkset[0] +=messageLink;
	 dispMenu(linkset);
	}
	
	else if (commExpAut=="true" && viewAuth=="false")
	{

     var messageLink  = '<a href="#" disabled="disable">'+messageViewerLabel+'</a>';
	 var reviewLink      = '<a href="#" onClick='+'\''+'review("'+appl_msg+'","'+err_msg+'");'+'\''+'>'+reviewLabel+'</a>';
		   linkset[0] = reviewLink;
 
 linkset[0] +=messageLink;
dispMenu(linkset);
	}
	else if(commExpAut=="false" && viewAuth=="true")
	{
		
			var messageLink      = '<a href="#" onClick='+'\''+'goToView();'+'\''+'>'+messageViewerLabel+'</a>';
			var reviewLink  = '<a href="#" disabled="disable">'+reviewLabel+'</a>';
       linkset[0]=messageLink;
       linkset[0] += reviewLink;
 dispMenu(linkset);
	}
     else
	{
          alert(getMessage("XH0075"));
	}
     
    /*var audtiAut	= document.getElementById("audtiAut").value;
	var rebuildAut	= document.getElementById("rebuildAut").value;
	var replayAut	= document.getElementById("replayAut").value;
	var commExpAut	= document.getElementById("commExpAut").value;



	var act = "../../eXH/jsp/ViewQryMsgFooter.jsp";
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();*/
}
async function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)
{

	var dialogHeight = "250";
var dialogWidth  = "250";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  ="";

	var arguments  =new Array();
	arguments[0]='L';
	arguments[1]=applicationId;
	arguments[2]=applicationName;
    arguments[3]=facilityId;
	arguments[4]=facilityName;
	arguments[5]=msgId;
    arguments[6]=eventType;
	arguments[7]=eventName;
 await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp?applicationId="+applicationId+"&applicationName="+applicationName+"&facilityName="+facilityName+"&facilityId="+facilityId+"&eventName="+eventName+"&protocollinkid="+this.document.forms[0].Protocollink_id.value+"&msgId="+msgId,arguments,features);  
}
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
   var url="../../eXH/jsp/ViewSegmentsMain.jsp?application_id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&eventype="+this.document.forms[0].event_type.value+"&protocollinkid="+this.document.forms[0].Protocollink_id.value+"&msg_id="+this.document.forms[0].msg_id.value+"&qryid="+this.document.forms[0].QUERYID.value+"&qapplname="+this.document.forms[0].qapplname.value+"&faciname="+this.document.forms[0].qfacility.value+"&purge_status="+this.document.forms[0].purge_status.value;
  /*  var url="../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&eventype="+this.document.forms[0].event_type.value+"&protocollinkid="+this.document.forms[0].Protocollink_id.value+"&msg_id="+this.document.forms[0].QUERYID.value;*/



	await window.showModalDialog(url,arguments,features);  
// window.open(url,null,"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");

 

}

function editQuery1()
{	

	document.forms[0].action="../../eXH/jsp/ViewQryMsgHeader.jsp";

	document.forms[0].editQuery.value='Y';
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].target = "f_query_header";
	document.forms[0].submit();
} 


async function review(appl_msg,err_msg) 
{
  



var dialogHeight = "250";
var dialogWidth  = "250";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  ="";

/*window.showModalDialog("../../eXH/jsp/ViewQryMsgFooter.jsp?application_id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&msg_id="+this.document.forms[0].QUERYID.value+"&Even_type="+this.document.forms[0].event_type.value+"&protocollinkid="+this.document.forms[0].Protocollink_id.value+"&STATUSTEXT="+escape(this.document.forms[0].STATUSTEXT.value)+"&application_Msg="+escape(appl_msg)+"&Error_msg="+escape(err_msg),arguments,features);  */
await window.showModalDialog("../../eXH/jsp/ViewQryMsgFooterMasterMain.jsp?application_Id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&Msg_Id="+this.document.forms[0].msg_id.value+"&qryid="+this.document.forms[0].QUERYID.value+"&Even_type="+this.document.forms[0].event_type.value+"&protocol_link_id="+this.document.forms[0].Protocollink_id.value+"&STATUSTEXT="+escape(this.document.forms[0].STATUSTEXT.value)+"&application_Msg="+escape(appl_msg)+"&Error_msg="+escape(err_msg)+"&qapplname="+this.document.forms[0].qapplname.value+"&faciname="+this.document.forms[0].qfacility.value+"&qmsg_dt1="+this.document.forms[0].qmsg_dt1.value+"&qmsg_dt2="+this.document.forms[0].qmsg_dt2.value+"&msg_status="+document.forms[0].msg_status.value+"&purge_status="+this.document.forms[0].purge_status.value+"&posi="+this.document.forms[0].position.value+"&Query_Option="+this.document.forms[0].qostatus.value,arguments,features); 
/*window.showModalDialog("../../eXH/jsp/ViewQryMsgFooter.jsp?application_Id="+this.document.forms[0].Application_id.value+"&Facility_Id="+this.document.forms[0].Facility_id.value+"&Msg_Id="+this.document.forms[0].QUERYID.value+"&Even_type="+this.document.forms[0].event_type.value+"&protocol_link_id="+this.document.forms[0].Protocollink_id.value+"&STATUSTEXT="+escape(this.document.forms[0].STATUSTEXT.value)+"&application_Msg="+escape(appl_msg)+"&Error_msg="+escape(err_msg)+"&qapplname="+this.document.forms[0].qapplname.value+"&faciname="+this.document.forms[0].qfacility.value+"&qmsg_dt1="+this.docoment.forms[0].qmsg_dt1.value+"&qmsg_dt2="+this.docoment.forms[0].qmsg_dt2.value+"&msg_status="+document.forms[0].msg_status.value,arguments,features);*/
	//var act = "../../eXH/jsp/ViewQryMsgFooter.jsp"; 
	//this.document.forms[0].action = act;
//	this.document.forms[0].target='f_query_detail';  
	//this.document.forms[0].submit(); 
} 
async function responce() 
{
 
var dialogHeight = "250";
var dialogWidth  = "250";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  ="";




var url="../../eXH/jsp/ViewQryMeesageMenu.jsp?application_id="+document.forms[0].Application_id.value+"&Facility_id="+document.forms[0].Facility_id.value+"&msgId="+this.document.forms[0].QUERYID.value+"&mode="+this.document.forms[0].sortMode1.value+"&eventype="+document.forms[0].event_type.value+"&protocollinkid="+document.forms[0].Protocollink_id.value+"&applicationName="+this.document.forms[0].qapplname.value+"&facilityname="+this.document.forms[0].qfacility.value+"&Query_Option="+this.document.forms[0].qostatus.value+"&Query_Status="+this.document.forms[0].qstatus.value; 

await window.showModalDialog("../../eXH/jsp/ViewQryMeesageMenu.jsp?application_id="+document.forms[0].Application_id.value+"&Facility_id="+document.forms[0].Facility_id.value+"&msgId="+this.document.forms[0].QUERYID.value+"&mode="+this.document.forms[0].sortMode1.value+"&eventype="+document.forms[0].event_type.value+"&protocollinkid="+document.forms[0].Protocollink_id.value+"&applicationName="+this.document.forms[0].qapplname.value+"&facilityname="+this.document.forms[0].qfacility.value+"&Query_Option="+this.document.forms[0].qostatus.value+"&Query_Status="+this.document.forms[0].qstatus.value,arguments,features);  
} 
function goSearch()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
		parent.f_query_detail.location.href="../../eCommon/html/blank.html";
		parent.frames[2].location.href="../../eCommon/html/blank.html";

var fields = new Array (  document.forms[0].qostatus);
var names = new Array ("Query Option");

		if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{


	}
	else
	{


if(validDateCheck()&&(Checkcurrdate(this.document.forms[0].qmsg_id1))&&(Checkcurrdate(this.document.forms[0].qmsg_id2)))
	    {

			this.document.forms[0].action='../../eXH/jsp/ViewQryMsgDtl.jsp';
			this.document.forms[0].target='f_query_add_mod';
			this.document.forms[0].action_type.value='S';
			this.document.forms[0].submit();
		} 
	}

parent.commontoolbarFrame.document.location.reload();
}

function reprocessQuery()
{
	if(document.forms[0].qostatus.value=='P' )
	{
		alert("Records Pending For Batch Processing cannot be selected");
	}
	else
	{
		var act ="../../eXH/jsp/Viewqryreprocess.jsp";
		this.document.forms[0].action = act;
		this.document.forms[0].target='messageFrame';
		this.document.forms[0].submit();
	}
}

//******************************************************************************************
function funSubmit()
{
	var act = '../../eXH/jsp/ViewQryMsgDtl.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].sortMode.value="A";
	this.document.forms[0].target='';
	this.document.forms[0].submit(); 
}
//******************************************************************************************
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
//	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	funSubmit();
}

//******************************************************************************************
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY  leftmargin=0 topmargin=0  onKeyDown = 'lockKey()' >

<%
boolean boolToggle =  true;	
String strTDClass = "";

Connection conn = null;
try
{ 
	 HashMap resultsQry=null; 
  String tableNameSuffix="";  
  String whereClause="";
  String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
  String qapplname=request.getParameter("qapplname"); 
  System.out.println("qapplname==>"+ qapplname);
  String qfacility=request.getParameter("qfacility");
  String qstatus=request.getParameter("qstatus"); 
  String qry_id1=XHDBAdapter.checkNull(request.getParameter("qry_id1"));
  String qry_id2=XHDBAdapter.checkNull(request.getParameter("qry_id2"));
  String  eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
  String qmsg_id1=XHDBAdapter.checkNull(request.getParameter("qmsg_id1"));
  String qmsg_id2=XHDBAdapter.checkNull(request.getParameter("qmsg_id2"));
  String orderbycolumns=XHDBAdapter.checkNull(request.getParameter("orderbycolumns")); 
  String mode=XHDBAdapter.checkNull(request.getParameter("sortMode"));
  String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
  String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
  String qmsg_dt1=XHDBAdapter.checkNull(request.getParameter("qmsg_dt1"));
	String qmsg_dt2=XHDBAdapter.checkNull(request.getParameter("qmsg_dt2"));  
String sub_module=XHDBAdapter.checkNull(request.getParameter("sub_module"));
 
 // String qry_id1= XHDBAdapter.checkNull(request.getParameter("qry_id1"));

String qry_id = "VIEWADMINQUERYPROCESS";

String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	try
	{
		conn = ConnectionManager.getConnection(request);
		authRS = conn.createStatement().executeQuery(authSql);
		if(authRS.next())
		{		
			String strAutRebuild = authRS.getString("rebuild_yn");
			String strAutReplay = authRS.getString("replay_yn");
			String strAutCommExp = authRS.getString("comm_exception_yn");
			String strXlsAuth = authRS.getString("write_to_excel");
			String strAudit = authRS.getString("audit_yn");
			String strView = authRS.getString("view_yn");
			
			if(strAutRebuild != null && strAutRebuild.equalsIgnoreCase("Y")) authToRebuild = true;	
			if(strAutReplay != null && strAutReplay.equalsIgnoreCase("Y")) authToReplay = true;	
			if(strAutCommExp != null && strAutCommExp.equalsIgnoreCase("Y")) authToVwCommErr = true;
			if(strXlsAuth != null && strXlsAuth.equalsIgnoreCase("Y")) xlsAuth = true;
			if(strAudit != null && strAudit.equalsIgnoreCase("Y")) authToAudit = true;
			if(strView != null && strView.equalsIgnoreCase("Y")) viewAuth = true;
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		if(authRS != null) authRS.close();
	} 
  whereClause =" WHERE  B.LANGUAGE_ID='"+locale+"' and  a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND TO_DATE(A.QUERY_DATE) BETWEEN TO_DATE(NVL('"+qmsg_dt1+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') AND TO_DATE(NVL('"+qmsg_dt2+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') and A.PROTOCOL_LINK_ID=XP.PROTOCOL_LINK_ID(+) and c.EVENT_TYPE=A.EVENT_TYPE  ";  


  if((qry_id1 != null) && (!(qry_id1.equals(""))))			
	{
		whereClause =whereClause +"AND A.QUERY_ID BETWEEN"+ 	
							"  nvl('"+qry_id1+"',A.QUERY_ID) AND nvl('"+qry_id2+"',A.QUERY_ID)";
	} 
  
		//msg_id2
	if((qry_id1 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND A.QUERY_ID <"+ 	
								"  nvl('"+qry_id2+"',A.QUERY_ID)";
		}
	} 

	if((qry_id2 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" A.QUERY_ID BETWEEN"+ 	
							"  nvl('"+qry_id2+"',A.QUERY_ID)";
		}
	
	} 




    if((protocol_link_id != null) && (!(protocol_link_id.equals(""))))			
	{
		whereClause = whereClause + " AND A.protocol_link_id = nvl('"+protocol_link_id+"',A.protocol_link_id) ";
	}
	if((protocol_link_id != null) && (!protocol_link_id.equals("")) )
	{
		whereClause = whereClause + " A.protocol_link_id = nvl('"+protocol_link_id+"',A.protocol_link_id) ";
	}
    if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		whereClause =whereClause +"AND A.message_id BETWEEN"+ 	
							"  nvl('"+qmsg_id1+"',A.message_id) AND nvl('"+qmsg_id2+"',A.message_id)";
	} 

	

	//msg_id2
	if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND A.message_id <"+ 	
								"  nvl('"+qmsg_id2+"',A.message_id)";
		}
	} 

	if((qmsg_id2 != null) && (!(qmsg_id2.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" A.message_id BETWEEN"+ 	
							"  nvl('"+qmsg_id2+"',A.message_id)";
		}
	
	} 

	//msg_dt

 if((qstatus != null) && (!(qstatus.equals(""))))			
	{
		if(qstatus.equals("C"))
		{
			whereClause =whereClause +" AND A.QUERY_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS)  =NVL('"+qstatus+"',DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS)) ";
		}
	} 

 if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals("P"))
		{
			whereClause =whereClause +" AND A.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND A.MESSAGE_STATUS = NVL('"+msg_status+"',A.MESSAGE_STATUS)";
		}
	} 

if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " AND A.EVENT_TYPE = NVL('"+eventtype+"',A.EVENT_TYPE)";
	} 

/*	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
		
	} */

	if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" A.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" A.MESSAGE_STATUS = NVL('"+msg_status+"',A.MESSAGE_STATUS)";
		}
	
	}
//       
String sort="";
String orderbycolumns1="";
if(orderbycolumns.equals("1"))
	{
	orderbycolumns1=" 1 ";
	}
	else
	{
		orderbycolumns1=orderbycolumns;
	}
	if(mode.equals("A"))
	{
		sort=" ASC ";
	}
	else
	{
		sort=" desc ";
	}
	whereClause=whereClause+" ORDER BY "+orderbycolumns1+sort; 



 if(purge_status != null && !purge_status.equals(""))
	{
	 if(purge_status.equals("purge"))
	 {
		tableNameSuffix =","+sub_module+"_PURGE_APPL_QRY_MSG_VW A";
	 }
	 else if(purge_status.equals("offline"))
	 {
		 	tableNameSuffix = ","+sub_module+"_OFFLINE_APPL_QRY_MSG_VW A";
	 }
	}
	else 
	{ 
		tableNameSuffix = ","+sub_module+"_APPLICATION_QRY_MSG_VW A";
	}
 
  /* request.setAttribute("tableName",tableNameSuffix); 
  String QueryOption=request.getParameter("qostatus");
  //System.out.println("QueryOption"+QueryOption);
  request.setAttribute(XHQueryRender.strQueryId,qry_id);
  request.setAttribute(XHQueryRender.whereClause,whereClause);
  request.setAttribute(XHQueryRender.col,"29"); 
  request.setAttribute(XHQueryRender.maxRec,"20");
  conn = ConnectionManager.getConnection(request);
  HashMap resultsQry = XHQueryRender.getResults(request,session,conn,QueryOption);

  ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
  ArrayList arrCol = null;
  boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
  boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
 String strPrevious =  "Previous";
  String strNext  = "Next"; */

  request.setAttribute("tableName",tableNameSuffix); 
//  System.out.println("QueryOption"+QueryOption);
  String QueryOption=request.getParameter("qostatus");
   if(QueryOption.equals("P"))
  {
		qry_id = "VIEWADMINQUERYPROCESS";
  }
  else if(QueryOption.equals("A"))
  {
		qry_id = "VIEWADMINQUERYINITIATE";
  }
  else
  {
       qry_id = "VIEWADMINQUERYPROCESS";  
  }
  request.setAttribute("qry_id",qry_id);  
  request.setAttribute("whereClause",whereClause);
 request.setAttribute("maxRec","20");  
  //request.setAttribute(XHViewQueryControllerElementBean.maxRec,1);   
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
  resultsQry = xhBean.getResultSet();  
  System.out.println("resultsQry "+resultsQry);

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
<form name="view_query_msgdtl_form" id="view_query_msgdtl_form">
<input  type="hidden" name="qapplname" id="qapplname" value='<%=qapplname%>' />
<input  type="hidden" name="qfacility" id="qfacility" value='<%=qfacility%>' />
<input  type="hidden" name="qstatus"  id="qstatus" value='<%=qstatus%>' />
<input  type="hidden" name="qmsg_id1" id="qmsg_id1" value='<%=qmsg_id1%>' />
<input  type="hidden" name="qmsg_id2" id="qmsg_id2" value='<%=qmsg_id2%>' />
<input  type="hidden" name="qry_id1" id="qry_id1" value='<%=qry_id1%>' />
<input  type="hidden" name="qry_id2" id="qry_id2" value='<%=qry_id2%>' />
<input  type="hidden" name="msg_status" id="msg_status" value='<%=msg_status%>' /> 
<input  type="hidden" name="qostatus"  id="qostatus" value='<%=QueryOption%>' />
<input  type="hidden" name="qmsg_dt1" id="qmsg_dt1" value='<%=qmsg_dt1%>' />
<input  type="hidden" name="qmsg_dt2" id="qmsg_dt2" value='<%=qmsg_dt2%>' />
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=''/>
<input type="hidden" name="sortMode" id="sortMode" id="sortMode2"/>
<input type='hidden' name='viewAuth'  id="viewAuth" value='<%=viewAuth%>'>
<input type="hidden" name="sortMode1"  id="sortMode1" value='<%=mode%>'/>
<input type="hidden" name="purge_status"  id="purge_status" value='<%=purge_status%>'/>
<input type="hidden" name="msg_id"  id="msg_id" value=""/>
<input type="hidden" name="Application_id"  id="Application_id" />
<input type="hidden" name="Facility_id"  id="Facility_id" />
<input type="hidden" name="action_type" id="action_type"  value='S'/>
<input type="hidden" name="position" id="position" />

<input type="hidden" name="event_type"  id="event_type" />
<input type="hidden" name="Protocollink_id"  id="Protocollink_id" />
<input type="hidden" name="QUERYID"  id="QUERYID" value=""/>
<input type="hidden" name="QUERYDATE"  id="QUERYDATE" value=""/> 
<input type="hidden" name="QUERYTYPE"  id="QUERYTYPE" value=""/>
<input type="hidden" name="QUERYPRIORITY"  id="QUERYPRIORITY" value=""/>
<input type="hidden" name="PROCESSID"  id="PROCESSID" value=""/>
<input type="hidden" name="QUERYSTATUS"  id="QUERYSTATUS" value=""/>
<input type="hidden" name="LASTPROCSTARTTIME"  id="LASTPROCSTARTTIME" value=""/>
<input type="hidden" name="LASTPROCENDTIME"  id="LASTPROCENDTIME" value=""/>
<input type="hidden" name="ADDEDBYID"  id="ADDEDBYID" value=""/>
<input type="hidden" name="MODIFIEDBYID"  id="MODIFIEDBYID" value=""/>
<input type="hidden" name="QUERYTEXT"  id="QUERYTEXT" value=""/> 
<input type="hidden" name="STATUSTEXT" id="STATUSTEXT" value=""/>
<input type='hidden' name='commExpAut'  id="commExpAut" value='<%=authToVwCommErr%>'>
<input type='hidden' name='sub_module' id="sub_module" value='<%=sub_module%>'>

<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('XH1021','XH'));history.go(-1);


parent.frames[1].location.href='../../eXH/jsp/ViewQryMsgHeader.jsp?';
</script>

<% } else { %> 

	<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center border=1>
<tr>
<td align="left" class="CAGROUP" >
			<A class='label' style='cursor:pointer' onClick="editQuery1();" TITLE="Edit query criteria">
			 <fmt:message key="eXH.EditQuery.Label" bundle="${xh_labels}"/>
			</A>
		</td>

	<td colspan="6" align="right" class="CAGROUP">
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><u><%= strPrevious %></u></A>
		<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><u><%= strNext %></u></A>
	</td>
</tr> 
</table>  

<div id="left_child">
<table id="table1" cellspacing=0 cellpadding=3 border=1>	
<tr>
<td class='COLUMNHEADER'> 
<a name='QUERY_STATUS' id='QUERY_STATUS'  href="javascript:callSort('QUERY_STATUS');" >
		<font color=white>&nbsp; $ &nbsp;</font></td>
		<td class='COLUMNHEADER'><a name='MESSAGE_STATUS' id='MESSAGE_STATUS' href="javascript:callSort('MESSAGE_STATUS');" >
		<font color=white>&nbsp; # &nbsp;</font> 
		</td> 
		<td class='COLUMNHEADER'>  
		<a name='APPLICATION_ID' id='APPLICATION_ID' href="javascript:callSort('APPLICATION_ID');" >
		<font color=white><fmt:message key="Common.Application.label" bundle="${common_labels}"/></font>
		</td> 
		<td class='COLUMNHEADER'><a name='QUERY_ID' id='QUERY_ID' href="javascript:callSort('QUERY_ID');" >
		<font color=white><fmt:message key="eXH.QueryID.Label" bundle="${xh_labels}"/></font>
		</td> 
	    <td class='COLUMNHEADER'><a name='Facility_id' id='Facility_id' href="javascript:callSort('Facility_id');" >
		<font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font>
		</td> 
        <td class='COLUMNHEADER'><a name='QUERY_DATE' id='QUERY_DATE'  href="javascript:callSort('QUERY_DATE');" >
		<font color=white><fmt:message key="eXH.QueryDate.Label" bundle="${xh_labels}"/></font>
		</td>
		 <td class='COLUMNHEADER' >
		<a name='EVENT_TYPE' id='EVENT_TYPE'  href="javascript:callSort('EVENT_TYPE');" >
		<font color=white><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></font>
		</td>
         <td class='COLUMNHEADER'>
		<a name='QUERY_TYPE' id='QUERY_TYPE' href="javascript:callSort('QUERY_TYPE');" >
		<font color=white><fmt:message key="Common.type.label" bundle="${common_labels}"/></font>
		</td>
        
		
	
		
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
	String sstatusColor="";
	String statusColor="";
	String status =((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);	 
	status=status.trim();
	if(status.equals("S"))  statusColor="../../eXH/images/green_square.jpg" ;
	else if(status.equals("R"))  statusColor="../../eXH/images/black_square.jpg" ;
	else if(status.equals("E"))  statusColor="../../eXH/images/red_square.jpg" ;
	else  statusColor="../../eXH/images/yello_square.jpg" ;

	String mstatus =((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(27);	
	mstatus=mstatus.trim();
	if(mstatus.equals("S"))  sstatusColor="../../eXH/images/green_square.jpg" ;
	else if(mstatus.equals("E"))  sstatusColor="../../eXH/images/red_square.jpg" ;
	else sstatusColor="../../eXH/images/yello_square.jpg"; 

//System.out.println(""+arrCol.get(29));

%>
<tr id="testID" >
<td <%=strTDClass%> align="center">&nbsp;<img src='<%=statusColor%>' height=10></td>
<td <%=strTDClass%> align="center" nowrap>&nbsp;<img src='<%=sstatusColor%>' height=10></td>
<td <%=strTDClass%> align="left" nowrap><font SIZE=1>&nbsp;<%=arrCol.get(0)+""%></td>
<td <%=strTDClass%> align="left" onMouseDown='funShow(this)' QUERYID='<%=arrCol.get(1)+""%>' 
				QUERYDATE='<%=arrCol.get(3)+""%>' 
				QUERYTYPE='<%=arrCol.get(4)+""%>' 
				QUERYPRIORITY='<%=arrCol.get(5)+""%>' 
				PROCESSID='<%=arrCol.get(6)+""%>' 
				QUERYSTATUS='<%=arrCol.get(7)+""%>' 
				LASTPROCSTARTTIME='<%=arrCol.get(8)+""%>' 
				LASTPROCENDTIME='<%=arrCol.get(9)+""%>' 
				ADDEDBYID ='<%=arrCol.get(10)+""%>'
				MODIFIEDBYID ='<%=arrCol.get(11)+""%>'
				STATUSTEXT ='<%=java.net.URLEncoder.encode((String)arrCol.get(12))+""%>'
				Application_id='<%=arrCol.get(0)%>' 
				Facility_id='<%=arrCol.get(2)%>'  eventtype='<%=(String)arrCol.get(19)%>' protocollink='<%=(String)arrCol.get(22)%>' Appliname='<%=(String)arrCol.get(23)%>' faciname='<%=(String)arrCol.get(24)%>' Application_Msg='<%=(String)arrCol.get(25)%>' error_msg='<%=(String)arrCol.get(26)%>' msg_id='<%=(String)arrCol.get(28)%>'
			    posi='<%=arrCol.get(29)+""%>'  
				nowrap><font size=1 color="blue">
<%=arrCol.get(1)+""%> 
</font>
</b>
</td>
<!-- Falicity  -->
<td <%=strTDClass%> align="left" nowrap><font SIZE=1>&nbsp;<%=""+XHDBAdapter.checkNull((String)arrCol.get(2))%></font></td>

<!-- Query Date  -->
<td <%=strTDClass%> align="left" nowrap>&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(3))%></font></td>
<!-- Event Type  -->
<td <%=strTDClass%> nowrap align="center" nowrap>&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(19))%></font></td>
<!-- Type  -->
<td <%=strTDClass%> align="left" nowrap>&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(4))%></font></td>


<!-- Query Text  -->




</tr>

<%
}
%>

</table> 
</div> 
<div id="right_child" class="testSty" scrolling='no'>
<table id="table2" cellspacing=0 cellpadding=3 border=1 scrolling='no'>
		<tr>
		<td class='COLUMNHEADER' nowrap>
		<a name='QUERY_PRIORITY' id='QUERY_PRIORITY'  href="javascript:callSort('QUERY_PRIORITY');" >
		<font color=white><fmt:message key="Common.priority.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a id='PROCESS_ID' id='PROCESS_ID'  href="javascript:callSort('PROCESS_ID');" >
		<font color=white><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='LAST_PROC_START_TIME' id='LAST_PROC_START_TIME'  href="javascript:callSort('LAST_PROC_START_TIME');" >
		<font color=white><fmt:message key="eXH.ProcessStartTime.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='LAST_PROC_END_TIME' id='LAST_PROC_END_TIME'  href="javascript:callSort('LAST_PROC_END_TIME');" >
		<font color=white><fmt:message key="eXH.ProcessEndTime.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='ADDED_BY_ID' id='ADDED_BY_ID'  href="javascript:callSort('ADDED_BY_ID');" >
		<font color=white><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='MODIFIED_BY_ID' id='MODIFIED_BY_ID'  href="javascript:callSort('MODIFIED_BY_ID');" >
		<font color=white><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></font>
		</td>
   <!--     <td class='COLUMNHEADER' nowrap>
		<a name='QUERY_Text' id='QUERY_Text'  href="javascript:callSort('QUERY_Text');" >
		<font color=white>Query Text</font>
		</td>--->
		<td class='COLUMNHEADER' nowrap>
		<a name='STATUS_Text' id='STATUS_Text'  href="javascript:callSort('STATUS_Text');" >
		<font color=white><fmt:message key="eXH.StatusText.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='ADDED_DATE' id='ADDED_DATE'  href="javascript:callSort('A.ADDED_DATE');" >
		<font color=white><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></font>
		</td>
        <td class='COLUMNHEADER' nowrap>
		<a name='MODIFIED_DATE' id='MODIFIED_DATE'  href="javascript:callSort('A.MODIFIED_DATE');" >
		<font color=white><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER' nowrap>
		<a name='ADDED_AT_WS_NO' id='ADDED_AT_WS_NO'  href="javascript:callSort('ADDED_AT_WS_NO');" >
		<font color=white><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>
        <td class='COLUMNHEADER' nowrap>
		<a name='ADDED_FACILITY_ID' id='ADDED_FACILITY_ID'  href="javascript:callSort('ADDED_FACILITY_ID');" >
		<font color=white><fmt:message key="eXH.AddedFacility.Label" bundle="${xh_labels}"/></font>
		</td>
         <td class='COLUMNHEADER' nowrap>
		<a name='MODIFIED_AT_WS_NO' id='MODIFIED_AT_WS_NO'  href="javascript:callSort('MODIFIED_AT_WS_NO');" >
		<font color=white><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>
        <td class='COLUMNHEADER' nowrap>
		<a name='MODIFIED_FACILITY_ID' id='MODIFIED_FACILITY_ID' href="javascript:callSort('MODIFIED_FACILITY_ID');" >
		<font color=white><fmt:message key="eXH.ModifiedFacilityID.Label" bundle="${xh_labels}"/></font>
		</td>
               <td class='COLUMNHEADER' nowrap>
		<a name='ACCESSION_NUMBER' id='ACCESSION_NUMBER'  href="javascript:callSort('ACCESSION_NUMBER');" >
		<font color=white><fmt:message key="eXH.AccessionNumber.Label" bundle="${xh_labels}"/></font>
		</td>
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



%>

<tr>
<!-- Priority  -->
<td <%=strTDClass%> align="left" nowrap>&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(5))%></font></td>

<!-- Process ID  -->
<td <%=strTDClass%> align="left" nowrap>&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(6))%></font></td>
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(8))%></font></td>
<!-- Query Status  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(9))%></font></td>

<!-- Process Start Time  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(10))%></font></td>

<!-- Process End Time  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(11))%></font></td>

<!-- Added Id  -->
<%---<td <%=strTDClass%> nowrap align="center">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(12))%></td>---%>

<!-- Added Date  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(12))%></font></td>

<!-- Modified ID  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(13))%></font></td>

<!-- Modified Date  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(14))%></font></td>

<!-- Added WS No  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(15))%></font></td>

<!-- Added Faiclity ID  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(16))%></font></td>

<!-- Modified WS No  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(17))%></font></td>

<!-- Modified Facility ID  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(18))%></font></td>



<!-- Accession Number  -->
<td <%=strTDClass%> nowrap align="left">&nbsp;<font SIZE=1><%=""+XHDBAdapter.checkNull((String)arrCol.get(20))%></font></td>

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
	ConnectionManager.returnConnection(conn);
}
%>

<SCRIPT>
	parent.messageFrame.location.href = "../../eXH/jsp/ViewQueryEvents.jsp?commType=QueryProcess";
</SCRIPT>

<input type=hidden name='editQuery'  id='editQuery' value='N'> 
</table>
</div>
</form>	
</BODY>
</HTML>

