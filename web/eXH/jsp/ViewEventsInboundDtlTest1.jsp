<!DOCTYPE html>
<html>
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css' type='text/css'></link>
<!-- these style setting are used for table scroll -->
<style>
	div {float: left}
	.testSty
	{		   
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}
</style>
<%

String msg_status,facility,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause;
      
String orderBy;
String statusColor="../../eXH/images/black_square.jpg";
String sstatusColor="../../eXH/images/blue_square.jpg";     
String status;
String mstatus;
String msg_id1 = null;
String msg_dt1 = null;
String externalAccNoFrom = null;
String externalAccNoTo = null;
String interface_module = null;
String purge_status = null;
String protocol_link_id = null;
String sub_module = null;
String tableNameSuffix= "";
String eventStatus = "";
String maxRecords = "24";
String msgOrder = "ASC";

msg_status = null;
facility = null;
msg_id2 = null;
msg_dt2 = null;
order = null;
orderBy = null;	
tabValue = null;
pat_id = null;
merg_pat_id = null;
episode_type = null;
episode_id = null;
visit_id = null;
action_typ = null;
last_processed_date = null;
not_req_rsn = null;
addid = null;
addeddate = null;
addedwsno = null;
modfid = null;
modifieddate = null;
modifiedwsno = null;
msg_date = null;
applnname = null;
eventtype = null;
whereClause = null;

Properties p = (Properties) session.getValue("jdbc");
String loggedUser = p.getProperty("login_user");

%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script Language="JavaScript" src="../../eXH/js/ViewEventsOutbound.js"></script>
<script Language="JavaScript" src="../../eXH/js/ViewEvents.js"></script>
<SCRIPT language='javascript' src='../js/menu.js'></SCRIPT>

<Script Language='JavaScript'>
function GetMultiLine(sStr)
{	
	var s = sStr;
	s = s.replace(/function\(\){/, '');
	s = s.replace(/\*\/}/, '');
	s = s.replace(/\//, '', -1);
	s = s.replace(/\*/, '', -1);
	return s;
}
//function func1
function  func1(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
		msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,srlNo,msgStatus)
{	  
   	  var url='&accessionNumber='+accessionNumber+
				'&externalAccessNumber='+externalAccessionNumber+
				'&applicationId='+applicationId+
				'&applicationName='+applicationName+
				'&facilityId='+facilityId+
				'&facilityName='+facilityName+
				'&msgId='+msgId+
				'&eventType='+eventType+
				'&reason='+reason+
				'&purge_status='+purge_status+
				'&interface_module='+interface_module+
				'&sub_module='+sub_module+
				'&protocol_link_id='+protocol_link_id+
				'&mode=Q'+
				'&srlNo='+srlNo+
				'&msgStatus='+msgStatus;	 
	  
	  this.document.forms[0].action="../../eXH/jsp/ViewEventsOutboundFooter.jsp?"+url;
	  this.document.forms[0].target = "messageFrame";
	  this.document.forms[0].submit();
}
//function funSubmit
function funSubmit()
{
	var act = '../../eXH/jsp/ViewEventsInboundDtlTest1.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="f_query_add_mod";
	this.document.forms[0].submit();
}
//function funModify
function funModify(obj)
{
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';
}
//function changeMe
function changeMe(msgId) 
{	
   document.getElementById(msgId).style.color = "green";
}
//function doChanges
function doChanges() 
{
   this.document.forms[0].action="../../eXH/jsp/ViewEventsInboundDtlTest1.jsp";
   this.document.forms[0].target = "f_query_add_mod";
   this.document.forms[0].submit();
		  
   window.event.target.style.color = "green";
   window.event.target.style.font = "bold";
   window.event.target.style.fontSize = "15px";
} 
//function funAction
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//function callForOrderBy
function callForOrderBy(obj,order)
{
	if(order=='A') obj=obj+'  asc';
	if(order=='D') obj=obj+'  desc';
	var url='&orderBy='+obj+'&order='+order;

	this.document.forms[0].action="../../eXH/jsp/ViewEventsInboundDtlTest1.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}
//function validatecheckbox
function validatecheckbox(obj)
{
	if(obj.checked==true)
	{
		var faciln="All";
		var facil="*";
		var appln=obj.getAttribute("APPLICATION_NAME");
		var applnn=obj.getAttribute("APPLICATION_ID");
		var msgid=obj.getAttribute("MESSAGE_ID");
		var prot_id=obj.getAttribute("PROTOCOL_LINK_ID");
		var event_type=obj.getAttribute("EVENT_TYPE");
		var facility_id=obj.getAttribute("FACILITY");
		var url="../../eXH/jsp/ReviewApplMessage_Menu.jsp?mode=Q&facility_name="+faciln+"&fac="+facil+"&application_name="+appln+"	&msgid="+msgid+"&application_id="+applnn+"&protocol_link_id="+prot_id+"&event_type="+event_type+"&facility_id="+facility_id;
		mywindow = window.open(url,"ReviewApplicationMessage","fullscreen=no,height=750,width=1150,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");
		mywindow.moveTo(0,0);
	}
}
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown ='lockKey()' onMouseDown='CodeArrest()'>
<form name="VIEW_EVENTS(INBOUND)" id="VIEW_EVENTS(INBOUND)" method="POST" action=''  >
<%

boolean boolToggle =  true;	
String strTDClass = "";
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id")); // Used in ViewEventsOutboundHeader when Edit Query is clicked.

Connection conn = null;
try
{	
	msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));	 	
	facility = XHDBAdapter.checkNull(request.getParameter("facility")); 	 
	msg_id1 = XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
	msg_id2 =XHDBAdapter.checkNull(request.getParameter("msg_id2"));  	 
	msg_dt1 = XHDBAdapter.checkNull(request.getParameter("msg_dt1"));
	msg_dt2 = XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
	orderBy = XHDBAdapter.checkNull(request.getParameter("orderBy"));	
	order = XHDBAdapter.checkNull(request.getParameter("order"));
	tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
	eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));	
	applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));
	externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
	externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
	interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));
	sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
	purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
	protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	 
	pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
	merg_pat_id = XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
	episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
	action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
	last_processed_date = XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
	not_req_rsn = XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
	addid = XHDBAdapter.checkNull(request.getParameter("addid"));
	addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
	addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
	modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
	modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));
	modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
	eventStatus= XHDBAdapter.checkNull(request.getParameter("event_status"));	
	String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
	String protocol_link_name = XHDBAdapter.checkNull(request.getParameter("protocol_link_name"));
//	String dispMode = XHDBAdapter.checkNull(request.getParameter("dispMode"));

	String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE LOGIN_NAME='"+loggedUser+"'"; 
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToReload = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	try
	{
		conn = ConnectionManager.getConnection(request);
		authRS = conn.createStatement().executeQuery(authSql);
		if(authRS.next())
		{		
			String strAutReload = authRS.getString("reload_yn");			
			String strAutCommExp = authRS.getString("comm_exception_yn");
			String strXlsAuth = authRS.getString("write_to_excel");
			String strAudit = authRS.getString("audit_yn");
			String strView = authRS.getString("view_yn");
			
			if(strAutReload != null && strAutReload.equalsIgnoreCase("Y")) authToReload = true;			
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

	/*********IMPORTANT*********** 
	****	This code to be used when Interface Domain is required in the table name *****
	****	Eg:- As of now table name is like XH_EVENT_APPL_MESSAGE, if the interface domain is
	also added this becomes as XH_XH_EVENT_APPL_MESSAGE *****		 
	if(interface_module != null && !interface_module.equalsIgnoreCase(""))
	{		
	tableNameSuffix = interface_module + "_"+ sub_module;
	}
	else
	{
	tableNameSuffix = sub_module;
	}
	*/	


	boolean flag = false;	
	whereClause =" WHERE  ";

	//facility
	if((facility != null) && !(facility.equals("")))			
	{
		whereClause =whereClause + " X.FACILITY_ID = NVL('#facility',X.FACILITY_ID)";
		flag=true;
	} 
	//application_id
	if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
	{
		whereClause =whereClause + " AND X.APPLICATION_ID = NVL('#applnname',X.APPLICATION_ID)";
	} 

	if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
	{
		whereClause =whereClause + " X.APPLICATION_ID = NVL('#applnname',X.APPLICATION_ID)";
		flag=true;
	}
	// srl no
	if((flag==true) && (srlNo != null) && (!(srlNo.equals(""))))			
	{
		whereClause =whereClause +" AND X.SRL_NO = NVL('#srlNo',SRL_NO)";	
	} 

	if((flag==false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
		whereClause =whereClause +"  X.SRL_NO = NVL('#srlNo',SRL_NO)";
		flag=true;
	} 
	//eventtype
	if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " AND X.EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
	} 

	if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " X.EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
		flag=true;
	}
/*	//eventstatus
	if((flag == true) && (eventStatus != null) && (!(eventStatus.equals(""))))			
	{
		whereClause =whereClause + " AND X.EVENT_STATUS = NVL('#eventStatus',EVENT_STATUS)";
	} 

	if((flag == false) && (eventStatus != null) && (!(eventStatus.equals(""))))			
	{
		whereClause =whereClause + " X.EVENT_STATUS = NVL('#eventStatus',EVENT_STATUS)";
		flag=true;
	}
*/
	if((flag==true) && (msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" AND X.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND X.MESSAGE_STATUS = NVL('#msg_status',X.MESSAGE_STATUS)";
		}
	} 

	if((flag==false) && (msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" X.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" X.MESSAGE_STATUS = NVL('#msg_status',X.MESSAGE_STATUS)";
		}
		flag=true;
	} 
	//msg_id1
	if((flag == true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
	{
		if((msg_id2 != null) && ((msg_id2.equals("")))) 
		{
			whereClause = whereClause +" AND X.message_id >="+ 	
								"  nvl(lpad('#msg_id1',20),message_id)";
		}
		else
		{
			whereClause =whereClause +" AND X.message_id BETWEEN"+ 	
								"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
		}
	} 

	if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
	{
		if((msg_id2 != null) && ((msg_id2.equals("")))) 
		{
			whereClause = whereClause +" X.message_id >="+ 	
							"  nvl(lpad('#msg_id1',20),message_id)";
		}
		else
		{
			whereClause = whereClause +" X.message_id BETWEEN"+ 	
							"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
			flag = true;
		}
	} 

	//msg_id2
	if((flag == true) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
	{
		if((msg_id1 != null) && (!(msg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND X.message_id <"+ 	
								"  nvl(lpad('#msg_id2',20),message_id)";
		}
	} 

	if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
	{
		if((msg_id1 != null) && (!(msg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" X.message_id <"+ 	
							"  nvl(lpad('#msg_id2',20),message_id)";
		}
		flag = true;
	} 

	//msg_dt
	String messageDateFrom = msg_dt1;
	String messageDateTo = msg_dt2;
	// Converting the message date from thai to english locale
	if("th".equalsIgnoreCase(locale) && ((msg_dt1 != null) && (!(msg_dt1.equals("")))))
	{
		messageDateFrom = com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
		if(!("".equals(msg_dt2)))
		{
			messageDateTo = com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
		}
	}

	if((flag == true) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
	{
		
		whereClause = whereClause + " AND TO_DATE(X.MESSAGE_RECEIVED_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(X.MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(X.MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
	} 

	if((flag == false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
	{
		whereClause =whereClause + " TO_DATE(X.MESSAGE_RECEIVED_DATE) BETWEEN "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(X.MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(X.MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		flag=true;
	}
	
	//msg_dt2 
	if((flag == true) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
	{
		if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
		else
		{
			whereClause = whereClause +" AND TO_DATE(MESSAGE_RECEIVED_DATE) <=  "+  								
							" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		}
	} 

	if((flag == false) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
	{
		if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
		else
		{
			whereClause = whereClause +" TO_DATE(MESSAGE_RECEIVED_DATE) <=  "+  								
							" TO_DATE(NVL('#msg_dt2',TO_CHAR(MESSAGE_RECEIVED_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		}
		flag=true;
	}

	//External accession number From attribute
	if((flag == true) && (externalAccNoFrom != null) && (!(externalAccNoFrom.equals(""))))			
	{
		if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
		{
			whereClause = whereClause + " AND EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
		}
		else
		{
			whereClause = whereClause + " AND EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
		}
	}
	if((flag == false) && (externalAccNoFrom != null) && (!externalAccNoFrom.equals("")) )
	{
		if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
		{
			whereClause = whereClause + " EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
		}
		else
		{
			whereClause = whereClause + " EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
		}
		flag = true;
	}
	
	//External accession number To attribute
	if((flag == true) && ((externalAccNoTo != null) && !externalAccNoTo.equals(""))
						&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))			
	{		
		whereClause = whereClause + " AND EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";		
	}
	if((flag == false) && ((externalAccNoTo != null) && !externalAccNoTo.equals(""))
						&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))
	{		
		whereClause = whereClause + " EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";
		flag = true;
	}
	if((flag==true) && (protocol_link_id != null) && (!(protocol_link_id.equals(""))))			
	{
		whereClause = whereClause + " AND X.protocol_link_id = nvl('#protocol_link_id',X.protocol_link_id) ";
	}
	if((flag == false) && (protocol_link_id != null) && (!protocol_link_id.equals("")) )
	{
		whereClause = whereClause + " X.protocol_link_id = nvl('#protocol_link_id',X.protocol_link_id) ";
		flag = true;
	}

	//patient_id
	if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
	{
		whereClause = whereClause +" AND  X.PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
	} 

	if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
	{
		whereClause = whereClause +" X.PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
		flag=true;
	} 

	//merge_patient_id
	if((flag==true) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
	{
		whereClause =whereClause +"AND (NVL(X.MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
									"MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
	} 
	if((flag==false) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
	{
		whereClause =whereClause +" (NVL(X.MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
				   "MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
		flag=true;
	} 

	//episode_type
	if((flag==true) && (episode_type != null) && (!(episode_type.equals(""))))			
	{
		whereClause =whereClause +"AND X.EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
	} 

	if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
	{
		whereClause =whereClause +" X.EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
	} 

	//episode_id
	if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
	{
		whereClause =whereClause +" AND X.EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
	} 

	if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
	{
		whereClause =whereClause +" X.EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
		flag=true;
	} 

	//visit_id
	if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
	{
		whereClause =whereClause +"  AND X.VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
	} 

	if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
	{
		whereClause =whereClause +" X.VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
		flag=true;
	} 

	//action type
	if(action_typ != null)
	{
		action_typ=action_typ.trim();	
	}
	if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
	{
		whereClause = whereClause +"  AND X.ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
	} 

	if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
	{
		whereClause = whereClause +" X.ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
		flag=true;
	} 
	if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
	{
		whereClause = whereClause + " AND TO_CHAR(X.LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
				"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
	} 

	if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
	{

		whereClause = whereClause + " TO_CHAR(X.LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
									"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
		flag=true;
	} 

	//not_required_reason
	if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
	{
		whereClause = whereClause +" AND   X.NOT_REQ_REASON= NVL('#not_req_rsn'"+ 		 	
							",NOT_REQ_REASON)";
	} 

	if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
	{

		whereClause = whereClause +" X.NOT_REQ_REASON= NVL('#not_req_rsn',NOT_REQ_REASON)";
		flag=true;
	}  

	//addid   
	if((flag==true) && (addid != null) && (!(addid.equals(""))))			
	{
		whereClause = whereClause +" AND (X.ADDED_BY_ID= NVL('#addid',X.ADDED_BY_ID))";
	} 

	if((flag==false) && (addid != null) && (!(addid.equals(""))))			
	{
		whereClause = whereClause +" (X.ADDED_BY_ID= NVL('#addid',X.ADDED_BY_ID))"; 		 	
		flag=true;
	}  

	//addeddate
	if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
	{
		whereClause = whereClause +" AND  trunc(X.ADDED_DATE)=to_date(NVL('#addeddate',X.ADDED_DATE),'dd/mm/yyyy')";
	} 

	if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
	{
		whereClause = whereClause +" trunc(X.ADDED_DATE) = to_date(NVL('#addeddate',to_char(X.ADDED_DATE,'dd/mm/yyyy'))"; 		 	
		flag=true;
	}  

	//addedwsno
	if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
	{

		whereClause = whereClause +" AND X.ADDED_AT_WS_NO=NVL('#addedwsno',ADDED_AT_WS_NO)";
	} 

	if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
	{

		whereClause = whereClause +" X.ADDED_AT_WS_NO=NVL('#addedwsno',ADDED_AT_WS_NO)";
		flag=true;
	}  

	//modfied id
	if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
	{
		whereClause = whereClause +" AND X.MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
	} 
	if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
	{
		whereClause = whereClause +" X.MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
		flag=true;
	}  
	//modifieddate
	if((flag==true) && (modifieddate != null) && (!(modifieddate.equals(""))))			
	{
		whereClause = whereClause +" AND TO_CHAR(X.MODIFIED_DATE,'dd/mm/yyyy')=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
	} 
	if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
	{
		whereClause = whereClause +" TO_CHAR(X.MODIFIED_DATE,'dd/mm/yyyy')=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
		flag=true;
	}  

	// modifiedwsno
	if((flag==true) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
		whereClause = whereClause +" AND X.MODIFIED_AT_WS_NO=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
	} 

	if((flag == false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
		whereClause = whereClause +" X.MODIFIED_AT_WS_NO=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
		flag = true;
	} 
	if(orderBy == null || orderBy.equals(""))
	{
		orderBy = "1";
	}

	if(whereClause.length() <= 8)
	{
		whereClause = " WHERE X.APPLICATION_ID=Y.APPLICATION_ID AND Y.LANGUAGE_ID=NVL('en',Y.LANGUAGE_ID) AND X.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
	}

	else
	{
		whereClause = whereClause +" AND X.APPLICATION_ID=Y.APPLICATION_ID AND Y.LANGUAGE_ID=NVL('en',Y.LANGUAGE_ID) AND X.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
	}

	// Constructing the table or view name to be used for querying records.
	if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_INBOUND_MESSAGE_vw X";
	}
	else
	{
		tableNameSuffix = sub_module+"_INBOUND_MESSAGE_VW X";
	}
	
//	request.setAttribute(XHQueryRender.strQueryId,tableNameSuffix);
	request.setAttribute(XHQueryRender.strQueryId,"VIEW_INBOUND_EVENTS");
	request.setAttribute("tableName",tableNameSuffix);

	if((order != null) && (order.equals("A"))) 
	{
		order = "D";
		msgOrder = "DESC";
	}
	else 
	{
		order = "A";
		msgOrder = "ASC";
	}

	request.setAttribute(XHQueryRender.col,"38");
	request.setAttribute(XHQueryRender.maxRec,maxRecords);
	request.setAttribute(XHQueryRender.whereClause,whereClause);
	
//	if(conn == null) conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
	
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 

	String strPrevious =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
	strPrevious =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
	strPrevious = " ";
	}
	if (boolNext== true)
	{
	strNext  =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
	strNext  = " ";
	}
%>

<input type='hidden' name='msg_status' id='msg_status' value='<%= msg_status %>'>
<input type='hidden' name='action_type' id='action_type' value=''>
<input type='hidden' name='facility' id='facility' value='<%=facility %>'>
<input type='hidden' name='msg_id1' id='msg_id1' value='<%=msg_id1 %>'>
<input type='hidden' name='msg_id2' id='msg_id2' value='<%=msg_id2 %>'>
<input type='hidden' name='msg_dt1' id='msg_dt1' value='<%=msg_dt1 %>'>
<input type='hidden' name='msg_dt2' id='msg_dt2' value='<%=msg_dt2 %>'>
<input type='hidden' name='orderBy' id='orderBy' value='<%=orderBy %>'>
<input type='hidden' name='order' id='order' value='<%=order %>'>
<input type='hidden' name='action_typ' id='action_typ' value='<%=action_typ %>'>
<input type='hidden' name='applnname' id='applnname' value='<%=applnname %>'>
<input type='hidden' name='eventtype' id='eventtype' value='<%=eventtype %>'>
<input type='hidden' name='whereClause' id='whereClause' value='<%=java.net.URLEncoder.encode(whereClause) %>'>
<input type='hidden' name='externalAccNoFrom' id='externalAccNoFrom' value='<%=externalAccNoFrom %>'>
<input type='hidden' name='externalAccNoTo' id='externalAccNoTo' value='<%=externalAccNoTo %>'>
<input type='hidden' name='interface_module' id='interface_module' value='<%=interface_module %>'>
<input type='hidden' name='purge_status' id='purge_status' value='<%=purge_status %>'>
<input type='hidden' name='protocol_link_id' id='protocol_link_id' value='<%=protocol_link_id %>'>
<input type='hidden' name='tableNameSuffix' id='tableNameSuffix' value="'<%=tableNameSuffix%>">
<input type='hidden' name='interface_module' id='interface_module' value="'<%=interface_module%>">
<input type='hidden' name='sub_module' id='sub_module' value="<%=sub_module%>">
<input type='hidden' name='protocol_link_name' id='protocol_link_name' value="<%=protocol_link_name%>">
<input type='hidden' name='pat_id' id='pat_id' value='<%=pat_id%>'>
<input type='hidden' name='merg_pat_id' id='merg_pat_id' value='<%=merg_pat_id %>'>
<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type %>'>
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id %>'>
<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id %>'>
<input type='hidden' name='addid' id='addid' value='<%=addid %>'>
<input type='hidden' name='addeddate' id='addeddate' value='<%=addeddate %>'>
<input type='hidden' name='addedwsno' id='addedwsno' value='<%=addedwsno %>'>
<input type='hidden' name='modfid' id='modfid' value='<%=modfid %>'>
<input type='hidden' name='modifieddate' id='modifieddate' value='<%=modifieddate %>'>
<input type='hidden' name='modifiedwsno' id='modifiedwsno' value='<%=modifiedwsno %>'>
<input type='hidden' name='last_processed_date' id='last_processed_date' value='<%=last_processed_date %>'>
<input type='hidden' name='not_req_rsn' id='not_req_rsn' value='<%=not_req_rsn %>'>
<input type='hidden' name='event_status' id='event_status' value='<%=eventStatus%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>

<input type='hidden' name='MESSAGE_STATUS' id='MESSAGE_STATUS' >
<input type='hidden' name='APPLICATION_ID' id='APPLICATION_ID' >
<input type='hidden' name='APPLICATION_NAME' id='APPLICATION_NAME' >
<input type='hidden' name='MESSAGE_ID' id='MESSAGE_ID' >
<input type='hidden' name='MESSAGE_RECEIVED_DATE' id='MESSAGE_RECEIVED_DATE'>
<input type='hidden' name='PROCESS_ID' id='PROCESS_ID' >
<input type='hidden' name='CLIENT_ID' id='CLIENT_ID' >
<input type='hidden' name='RD_ORDER_YN' id='RD_ORDER_YN' >
<input type='hidden' name='ADDED_DATE' id='ADDED_DATE'>
<input type='hidden' name='MODIFIED_DATE' id='MODIFIED_DATE' >
<input type='hidden' name='mode' id='mode' value="Q">
<input type='hidden' name='comm_mode' id='comm_mode' value='inbound'>
<input type='hidden' name='reloadAut' id='reloadAut' id="reloadAut" value='<%=authToReload%>'>
<input type='hidden' name='commExpAut' id='commExpAut' id="commExpAut" value='<%=authToVwCommErr%>'>
<input type='hidden' name='audtiAut' id='audtiAut' id="audtiAut" value='<%=authToAudit%>'>
<input type='hidden' name='write2XL' id='write2XL' id="write2XL" value='<%=xlsAuth%>'>
<input type='hidden' name='viewAuth' id='viewAuth' id="viewAuth" value='<%=viewAuth%>'>
	

<%	
	if(arrRow.size()==0)
	{	
%>	
	<script>
		alert(getMessage('XH1021','XH'));
		editQuery();
	</script>
		
	<%
	}		
	else
	{
	%>


<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center border=1>
	<tr>
	<td colspan="2" class="COLUMNHEADER" align="center"><fmt:message key="eXH.InboundEvents.label" bundle="${xh_labels}"/></td>
	</tr>
	<tr>
		<td align="left" class="CAGROUP" >
			<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="editQuery();" TITLE="Edit query criteria">
				<fmt:message key="eXH.EditQuery.Label" bundle="${xh_labels}"/>
			</A>
		<% if(authToReload){ %>
			<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="refreshResults('ViewEventsInboundDtlTest1');" TITLE="Refresh Events">
			Refresh
			</A>
		<% } %>
		</td>
		<td align="right" class="CAGROUP" > 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
		</td>
	</tr>
</table>
<div id="left_child">
<table id="table1" cellspacing=0 cellpadding=3 border=1>
	<tr>		
		<td class='COLUMNHEADER'>
		<a id='a001' title="Message Status" href="javascript:callForOrderBy('X.MESSAGE_STATUS','<%=order%>');" onclick=''>
		<font color=white>#</font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('lpad(X.MESSAGE_ID,20) <%=msgOrder%>,X.SRL_NO','<%=order%>');" onclick=''>
		<font color=white><fmt:message key="eXH.MsgIDSno.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('Y.APPLICATION_NAME','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="Common.Application.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.EVENT_TYPE','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.Event.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.MESSAGE_RECEIVED_DATE','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.FACILITY_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.PROTOCOL_LINK_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.PATIENT_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
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
%>
<tr>

<%	
	status =((String)arrCol.get(12)).equals("null")?"":(String)arrCol.get(12);	
	status=status.trim();
	if(status.equals("S"))  statusColor="../../eXH/images/green_square.jpg" ;
	if(status.equals("N"))  statusColor="../../eXH/images/black_square.jpg" ;
	if(status.equals("E"))  statusColor="../../eXH/images/red_square.jpg" ;
	if(status.equals("A"))  statusColor="../../eXH/images/yello_square.jpg" ;

	mstatus =((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);	
	mstatus=mstatus.trim();
	if(mstatus.equals("S"))  sstatusColor="../../eXH/images/yello_square.jpg" ;
	else if(mstatus.equals("L"))  sstatusColor="../../eXH/images/green_square.jpg" ;
	else if(mstatus.equals("A"))  sstatusColor="../../eXH/images/darkgreen.jpg" ;
	else if(mstatus.equals("R"))  sstatusColor="../../eXH/images/black_square.jpg" ;
	else if(mstatus.equals("F"))  sstatusColor="../../eXH/images/pink_square.jpg" ;
	else if(mstatus.equals("E"))  sstatusColor="../../eXH/images/red_square.jpg" ;
	else sstatusColor="../../eXH/images/blue_square.jpg";


String startDate="";
String Last_Processed_date="";

startDate = ((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
if(!startDate.equals("")) 
	startDate =com.ehis.util.DateUtils.convertDate(startDate,"DMYHMS","en",locale);
//	startDate = startDate;


Last_Processed_date	= ((String)arrCol.get(11)).equals("null")?"":(String)arrCol.get(11);
if(!Last_Processed_date.equals("")) 
	Last_Processed_date  = com.ehis.util.DateUtils.convertDate(Last_Processed_date,"DMYHMS","en",locale);
//	Last_Processed_date = Last_Processed_date;

String endDate = "";
String Added_Date = "";
endDate=((String)arrCol.get(8)).equals("null")?"":(String)arrCol.get(8);
if(!endDate.equals("")) 
	Added_Date =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
//	Added_Date =endDate;

String endDate1="";
String Modified_Date="";
endDate1=((String)arrCol.get(9)).equals("null")?"":(String)arrCol.get(9);
if(!endDate1.equals("")) 
	Modified_Date =com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);
//	Modified_Date = endDate1;

//String s1=((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
//String s2=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1);
//String s3=((String)arrCol.get(15)).equals("null")?"":(String)arrCol.get(15);
//String s5=((String)arrCol.get(24)).equals("null")?"":(String)arrCol.get(24);
/*String ss="Message Id     : "+s1 +"                                                             "+
	      "Application      : "+s2 +"                                        "+
	      "Event              : "+s3 +"                                                     "+
	      "Message Date : "+Last_Processed_date+"                                    "+
	      "Facility             : "+s5;
*/
%>

<!---Message Status-->
<td nowrap <%=strTDClass%> align="center"><font size=1>&nbsp;<img src='<%=sstatusColor%>' height=10></td>

<!---Message Id-->
<td  nowrap <%=strTDClass%> id='mes<%=j%>' onMouseOver=this.style.cursor='hand' onClick='changeMe("mes"+<%=j%>)' onMouseDown="buildMenuList(	'<%=arrCol.get(22) %>',
							'<%= arrCol.get(14) %>',
							'<%= arrCol.get(1)%>',
							'<%= arrCol.get(2)%>',
							'<%= arrCol.get(24)%>',
							'<%= XHDBAdapter.checkNull((String)arrCol.get(35))%>',
							'<%= arrCol.get(3)%>',
							'<%= arrCol.get(15)%>',
							'',
							'<%=purge_status %>',
							'<%= tableNameSuffix%>',
							'<%= sub_module%>',
							'<%= arrCol.get(23)%>',
							'<%="R"%>',
							'<%= arrCol.get(36)%>',
							'<%= XHDBAdapter.checkNullNoTrim((String)arrCol.get(0))%>',
							'<%= XHUtil.getEventName(XHDBAdapter.checkNull((String)arrCol.get(15)))%>','<%= j %>'); ">
<font size=1 color="blue">&nbsp;<%=((String)arrCol.get(3)).equals("null")?"":arrCol.get(3)%> /
					<%=((String)arrCol.get(36)).equals("null")?"":arrCol.get(36)%></td>

<!---Application-->
<td  nowrap <%=strTDClass%>><font size=1>&nbsp;<%=((String)arrCol.get(2)).equals("null")?"":arrCol.get(2)%></td>

<!---Event-->
<td nowrap  <%=strTDClass%>><font size=1>&nbsp;<%=((String)arrCol.get(15)).equals("null")?"":arrCol.get(15)%></a>
</td>

<!---Message Date-->
<td nowrap <%=strTDClass%> ><font size=1>&nbsp;<%=startDate%></td> 

<!---Facility-->
<td nowrap <%=strTDClass%> > <font size=1>&nbsp;<%=((String)arrCol.get(24)).equals("null")?"":arrCol.get(24)%></td>

<!---Protocol Link ID-->
<td nowrap  <%=strTDClass%>> <font size=1>&nbsp;<%=((String)arrCol.get(37)).equals("null")?"":arrCol.get(37)%></td>

<!---Patient ID-->
<td nowrap <%=strTDClass%>><font size=1>&nbsp;<%=((String)arrCol.get(17)).equals("null")?"":arrCol.get(17)%></td>
	</tr>
	<%}%>
</table>
</div>
<div id="right_child" class="testSty" style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;">
<table id="table2" cellspacing=0 cellpadding=3 border=1>
	<tr>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.EPISODE_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.EPISODE_TYPE','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.VISIT_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.ACCESSION_NUM','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AccessionNumber.Label" bundle="${xh_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER' style="display:none;">
		<a id='a001' href="javascript:callForOrderBy('X.EXT_ACCESSION_NUM','<%=order%>');"onclick=''>
		<font color=white>Ext.Accession Number</font>
		</td>		
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.ACTION_TYPE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.LAST_PROC_DATE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.LastProcessedDate.Label" bundle="${xh_labels}"/></font>
		</td>		
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.ADDED_BY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.ADDED_DATE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></font>
		</td>
	    <td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.ADDED_AT_WS_NO','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.MODIFIED_BY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.MODIFIED_DATE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></font>
		</td>
		<td NOWRAP class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('X.MODIFIED_AT_WS_NO','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>

	</tr>
 <!--------------------------------------------------------------------------------------------------------->
 <%	
	boolToggle =  true;
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
%>
<tr>

<%	
	status =((String)arrCol.get(12)).equals("null")?"":(String)arrCol.get(12);	
	status=status.trim();
	if(status.equals("S"))  statusColor="../../eXH/images/green_square.jpg" ;
	if(status.equals("N"))  statusColor="../../eXH/images/black_square.jpg" ;
	if(status.equals("E"))  statusColor="../../eXH/images/red_square.jpg" ;
	if(status.equals("A"))  statusColor="../../eXH/images/yello_square.jpg" ;

	mstatus =((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);	
	mstatus=mstatus.trim();
	if(mstatus.equals("S"))  sstatusColor="../../eXH/images/green_square.jpg" ;
	else if(mstatus.equals("L"))  sstatusColor="../../eXH/images/green_square.jpg" ;
	else if(mstatus.equals("A"))  sstatusColor="../../eXH/images/yello_square.jpg" ;
	else if(mstatus.equals("R"))  sstatusColor="../../eXH/images/black_square.jpg" ;
	else if(mstatus.equals("F"))  sstatusColor="../../eXH/images/pink_square.jpg" ;
	else if(mstatus.equals("E"))  sstatusColor="../../eXH/images/red_square.jpg" ;
	else sstatusColor="../../eXH/images/blue_square.jpg";


String startDate="";
String Last_Processed_date="";

startDate=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
if(!startDate.equals("")) 
	//startDate =com.ehis.util.DateUtils.convertDate(startDate,"DMYHMS","en",locale);

Last_Processed_date	= ((String)arrCol.get(11)).equals("null")?"":(String)arrCol.get(11);
if(!Last_Processed_date.equals("")) 
	//Last_Processed_date  = com.ehis.util.DateUtils.convertDate(Last_Processed_date,"DMYHMS","en",locale);
	Last_Processed_date = Last_Processed_date;

String endDate = "";
String Added_Date = "";
endDate=((String)arrCol.get(8)).equals("null")?"":(String)arrCol.get(8);
if(!endDate.equals("")) 
	Added_Date =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
//	Added_Date = endDate;

String endDate1="";
String Modified_Date="";
endDate1=((String)arrCol.get(9)).equals("null")?"":(String)arrCol.get(9);
if(!endDate1.equals("")) 
	Modified_Date =com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);
//	Modified_Date =endDate1;

//String s1=((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
//String s2=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1);
//String s3=((String)arrCol.get(15)).equals("null")?"":(String)arrCol.get(15);
//String s5=((String)arrCol.get(24)).equals("null")?"":(String)arrCol.get(24);
/*	String ss="Message Id     : "+s1 +"                                                             "+
	      "Application      : "+s2 +"                                        "+
	      "Event              : "+s3 +"                                                     "+
	      "Message Date : "+Last_Processed_date+"                                    "+
	      "Facility             : "+s5; */


%>
<!---Episode ID-->
<td nowrap  <%=strTDClass%> ><font size=1>&nbsp;<%=((String)arrCol.get(20)).equals("null")?"":arrCol.get(20)%></td>

<!---Episode Type-->
<td nowrap <%=strTDClass%>> <font size=1>&nbsp;<%=((String)arrCol.get(19)).equals("null")?"":arrCol.get(19)%></td>

<!---Visit ID-->
<td  nowrap <%=strTDClass%>><font size=1>&nbsp;<%=((String)arrCol.get(21)).equals("null")?"":arrCol.get(21)%></td>

<!---Accession Number-->
<td  nowrap <%=strTDClass%>> <font size=1>&nbsp;<%=((String)arrCol.get(22)).equals("null")?"":arrCol.get(22)%></td>

<!---External Accession Number-->
<td nowrap  <%=strTDClass%> style="display:none;"> 
   <a href="javascript:getOutboundDetails('<%=((String)arrCol.get(14)).equals("null")?"":arrCol.get(14)%>')">
	<font size=1>&nbsp;<%=((String)arrCol.get(14)).equals("null")?"":arrCol.get(14)%></a>
</td>

<!---Action Type-->
<td nowrap <%=strTDClass%>> <font size=1>&nbsp;<%=((String)arrCol.get(10)).equals("null")?"":arrCol.get(10)%></td>

<!---Last Processed date-->
<td nowrap  <%=strTDClass%> > <font size=1>&nbsp;<%=Last_Processed_date%></td>
			
<!---Added ID-->
<td nowrap <%=strTDClass%> align="left"> <font size=1>&nbsp;<%=((String)arrCol.get(25)).equals("null")?"":arrCol.get(25)%></td>
	
<!---Added Date-->
<td nowrap <%=strTDClass%> align="left" ><font size=1>&nbsp;<%=Added_Date%></td>

<!---Added WS No-->
<td nowrap <%=strTDClass%> align="left"> <font size=1>&nbsp;<%=((String)arrCol.get(28)).equals("null")?"":arrCol.get(28)%></td>

<!---Modified Id-->
<td  nowrap <%=strTDClass%> > <font size=1>&nbsp;<%=((String)arrCol.get(27)).equals("null")?"":arrCol.get(27)%></td>

<!---Modified Date-->
<td nowrap <%=strTDClass%> > <font size=1>&nbsp;<%=Modified_Date%></td>

<!---Modified WS No-->
<td nowrap <%=strTDClass%> > <font size=1>&nbsp;<%=((String)arrCol.get(16)).equals("null")?"":arrCol.get(16)%></td>

</tr>

	<% } 
	%>
</tr>
		</table>
</div>
	

<SCRIPT>
	parent.messageFrame.location.href = "../../eXH/jsp/ViewEventsOutboundFooter.jsp?commType=inbound";
</SCRIPT>
<%
	}
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
	if(resultsQry!=null) resultsQry.clear();
	}
	catch(Exception e1)
	{
		out.println("Error="+e1);
		e1.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
%>
</table>

  

</form>
</html>


