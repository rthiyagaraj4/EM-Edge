<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXB.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));
%>	

<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
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
String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
String statusColor="../../eXH/images/black_square.jpg";
String sstatusColor="../../eXH/images/blue_square.jpg";     
String status;									  
String mstatus;
String orderBy;
String tableNameSuffix= "";
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id")); // Used in ViewEventsOutboundHeader when Edit Query is clicked.
msg_status=null;
facility=null;									    
msg_id1=null;						    
msg_dt1=null;
msg_id2=null;
msg_dt2=null;
order=null;
orderBy=null;	
tabValue=null;
pat_id=null;
merg_pat_id=null;
episode_type=null;
episode_id=null;
visit_id=null;
action_typ=null;
last_processed_date=null;
not_req_rsn=null;
addid=null;
addeddate=null;
addedwsno=null;
modfid=null;
modifieddate=null;
modifiedwsno=null;
msg_date=null;
applnname=null;
eventtype=null;
eventStatus=null;
whereClause=null;
String action_type=null;
String temp=null;
String interface_module=null;
String sub_module = null;
pmode=null;
String externalAccNoFrom = null;
String externalAccNoTo = null;
String purge_status = null; 
String protocol_link_ID = null;
String maxRecords = "24";
String Rule=XHDBAdapter.checkNull(request.getParameter("Rule"));
boolean msgProcessed = false;

Properties p = (Properties) session.getValue("jdbc");
String loggedUser = p.getProperty("login_user");

%>

<script language='javascript' src="../../eCommon/js/common.js"></script>
<script Language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXB/js/XHAjaxUtil.js"></script>
<script Language="javascript" src="../../eXB/js/ViewEventsOutbound.js"></script>
<script Language="javascript" src="../../eXB/js/ViewEvents.js"></script>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script>
<Script Language='javascript'>

//function funSubmit
function funSubmit()
{
	parent.f_query_add_mod.VIEW_EVENTS.action = '../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp';
	parent.f_query_add_mod.VIEW_EVENTS.target="f_query_add_mod";
	parent.f_query_add_mod.VIEW_EVENTS.submit();
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
	this.document.forms[0].action="../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp";
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();

	window.event.target.style.color = "green";
	window.event.target.style.font = "bold";
	window.event.target.style.fontSize = "15px";
} 
//function funAction
function funAction(typ)
{  
	parent.f_query_add_mod.VIEW_EVENTS.action_type.value = typ;
	funSubmit();

}
//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

//function func1
function  func1(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
					msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,
					msgProcessed,msgStatus,eventStatus,msgDate,patID,episodeID,episodeType,visitID)
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
			'&Rule=Y'+
			'&msgProcessed='+msgProcessed+
			'&msgStatus='+msgStatus+
			'&eventStatus='+eventStatus+
			'&msgDate='+msgDate+
			'pat_id='+patID+
			'episode_id='+episodeID+'&episode_type='+episodeType+'&visit_id='+visitID;				
	
	this.document.forms[0].action="../../eXB/jsp/ViewEventsOutboundFooter.jsp?"+url;
	this.document.forms[0].target = "messageFrame";
	this.document.forms[0].submit();
}

</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown ='lockKey()' onMouseDown='CodeArrest()'>
<form name="VIEW_EVENTS" id="VIEW_EVENTS" method="POST" action='../../eXB/jsp/ViewEventsOutboundHeader.jsp'>
<%
System.out.println("test123");
boolean boolToggle =  true;	
String strTDClass = "";
Connection conn = null;
try
{   
	action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
	msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
	facility = XHDBAdapter.checkNull(request.getParameter("facility")); 
	msg_id1	= XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
	msg_id2	= XHDBAdapter.checkNull(request.getParameter("msg_id2"));  
	msg_dt1	= XHDBAdapter.checkNull(request.getParameter("msg_dt1")); 
	msg_dt2	= XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
	orderBy	= XHDBAdapter.checkNull(request.getParameter("orderBy"));
	order = XHDBAdapter.checkNull(request.getParameter("order"));
	tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
	pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
	merg_pat_id	= XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
	episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
	action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
	last_processed_date	= XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
	not_req_rsn	= XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
	addid = XHDBAdapter.checkNull(request.getParameter("addid"));
	addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
	addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
	modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
	modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));	
	modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
	msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
	eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
	applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));	
	interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));	
	sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));	
	eventStatus= request.getParameter("event_status");
	externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
	externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
	purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
	protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
	pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));
	String protocol_link_name = XHDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	String dispMode = XHDBAdapter.checkNull(request.getParameter("dispMode"));

	System.out.println("protocol_link_name "+protocol_link_name);
	
	String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	String Inv_No = "";
	String Inv_Date = "";
	String Amount = "";
	String Visit_Date = "";
	String Patient_Name = "";
	String Patient_Type = "";
	String Card_ID = "";
	String Card_Iss_Date = "";

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
		System.out.println("sub_module.... "+sub_module);
		tableNameSuffix = sub_module;
	}
*/	
	if(pmode!=null)
	{
		if(pmode.equalsIgnoreCase("F"))
		{
			if(locale.equalsIgnoreCase("th"))
			{
			//	msg_dt1=com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			//	msg_dt2=com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
				addeddate=com.ehis.util.DateUtils.convertDate(addeddate,"DMY","th","en");
				modifieddate=com.ehis.util.DateUtils.convertDate(modifieddate,"DMY","th","en");
				msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");		  
			}
		}			
	}
	boolean flag =false;	
	whereClause =" WHERE "; // Not using for eBilling 
	String whereClause1 =  "";
	/*",SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)-1),  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)-1) ,  A.PATIENT_ID HN,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)-1),   SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)-1) ,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)-1) ,      SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)-1) ,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)-1), SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)-1) , SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  FROM XB_EVENT_APPL_MESSAGE_XL_VW A "; */

	whereClause1 = whereClause1+"  WHERE  EVENT_TYPE = NVL('EB1',EVENT_TYPE) AND EVENT_STATUS = NVL('S',EVENT_STATUS) AND MESSAGE_STATUS = NVL('H',MESSAGE_STATUS)  ORDER BY 1,3,9";

    System.out.println("whereClause1 : "+whereClause1);

	try
	{  
		//facility	
		if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " amv.FACILITY_ID = NVL('#facility',amv.FACILITY_ID)";
			flag=true;
		} 

		//application_id
		if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND amv.APPLICATION_ID = NVL('#applnname',amv.APPLICATION_ID) ";
		} 

		if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " amv.APPLICATION_ID = NVL('#applnname',amv.APPLICATION_ID) ";
			flag=true;
		} 

		//eventtype
		if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " AND EVENT_TYPE = NVL('#eventtype',EVENT_TYPE) ";
		} 

		if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " EVENT_TYPE = NVL('#eventtype',EVENT_TYPE) ";
			flag=true;
		} 

		//eventStatus
		if((flag==true) && (eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " AND EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " AND EVENT_STATUS = NVL('#event_status',EVENT_STATUS) ";
			}
		} 

		if((flag==false) && (eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " EVENT_STATUS = NVL('"+eventStatus+"',EVENT_STATUS)";
			}
			flag=true;
		} 

		//msgstatus
		if((flag==true) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" AND MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('#msg_status',MESSAGE_STATUS)";
		} 

		if((flag==false) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" MESSAGE_STATUS = "+						
								"NVL('#msg_status',MESSAGE_STATUS)";
			flag=true;
		} 

		//msg_id1
		if((flag == true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND message_id >="+ 	
								"  nvl(lpad('#msg_id1',20),message_id)";
			}
			else
			{
				whereClause =whereClause +" AND message_id BETWEEN"+ 	
								"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
			}
		} 

		if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" message_id >="+ 	
								"  nvl(lpad('#msg_id1',20),message_id)";
			}
			else
			{
				whereClause = whereClause +" message_id BETWEEN"+ 	
									"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
				flag = true;
			}
		} 

		//msg_id2
		if((flag == true) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND message_id <"+ 	
								"  nvl('#msg_id2',message_id)";
			}
		} 

		if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" message_id <"+ 	
								"  nvl('#msg_id2',message_id)";
			}
			flag  =true;
		} 

		//msg_dt1

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
			whereClause =whereClause +" AND TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 

		if((flag==false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +"  TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
								" TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			flag=true;
		}
		
		//msg_dt2
		if((flag==true) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 

		if((flag==false) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" TO_DATE(MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('#msg_dt2',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
			flag=true;
		}

		//patient_id
		if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND  PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
		} 

		if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
		{
			whereClause =whereClause +" PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
			flag=true;
		} 

		//merge_patient_id
		if((flag==true) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
		} 
		if((flag==false) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
			flag=true;
		} 											 

		//episode_type
		if((flag==true) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" AND EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
		} 

		if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
		} 

		//episode_id
		if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" AND EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
		} 

		if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
			flag=true;
		} 

		//visit_id
		if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause =whereClause +"  AND VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
		} 

		if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause = whereClause +" VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
			flag=true;
		} 

		//action type
		if(action_typ != null)
		{
			action_typ=action_typ.trim();	
		}
		if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +"  AND ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
		} 

		if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +" ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
			flag=true;
		} 
		if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " AND TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
		} 																						   

		if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
			flag=true;
		} 

		//not_required_reason
		if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" AND   NOT_REQ_REASON= NVL('#not_req_rsn'"+ 		 	
								",NOT_REQ_REASON)";
		} 

		if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" NOT_REQ_REASON= NVL('#not_req_rsn'"+ 		 	
								",NOT_REQ_REASON) ";
			flag=true;
		}  

		//addid   													  
		if((flag==true) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" AND (ADDED_BY_ID= NVL('#addid',ADDED_BY_ID))";
		} 

		if((flag==false) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" (ADDED_BY_ID= NVL('#addid',ADDED_BY_ID))"; 		 	
			flag=true;
		}  

		//addeddate
		if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" AND  TO_CHAR(ADDED_DATE,'dd/mm/yyyy')"+ 	
								"=NVL('#addeddate',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))";
		} 

		if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" TO_CHAR(ADDED_DATE,'dd/mm/yyyy') =NVL('#addeddate',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))"; 		 	
			flag=true;
		}  

		//addedwsno
		if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" AND ADDED_AT_WS_NO"+ 			         
								"=NVL('#addedwsno',ADDED_AT_WS_NO)";
		} 

		if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" ADDED_AT_WS_NO"+
									"=NVL('#addedwsno',ADDED_AT_WS_NO)";
			flag=true;																	  
		}  
																										 
		//modfied id
		if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
		} 
		if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
			flag=true;
		}  
		//modifieddate
		if((flag==true) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" AND TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
		} 
		if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
			flag=true;
		}  

		// modifiedwsno
		if((flag==true) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_AT_WS_NO"+ 
								"=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
		} 

		if((flag == false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause = whereClause +"  MODIFIED_AT_WS_NO=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
			flag = true;
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
		if((flag==true) && (externalAccNoTo != null) && (!(externalAccNoTo.equals("")))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))			
		{
			whereClause = whereClause + " AND EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";		
		}
		if((flag == false) && (externalAccNoTo != null) && (!externalAccNoTo.equals(""))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))
		{
			whereClause = whereClause + " EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";
			flag = true;
		}

		//Protocol link id
		if((flag==true) && (protocol_link_ID != null) && (!(protocol_link_ID.equals(""))))			
		{
			whereClause = whereClause + " AND AMV.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
		}
		if((flag == false) && (protocol_link_ID != null) && (!protocol_link_ID.equals("")) )
		{
			whereClause = whereClause + " AMV.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
			flag = true;
		}
		System.out.println("orderBy "+orderBy);
		if(whereClause.length() <= 7)
		{
			whereClause = "";
			if(orderBy != null && !orderBy.equals(""))
			{
				whereClause = whereClause +" WHERE AMV.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
			}
		}
		else
		{
			whereClause = whereClause +" AND AMV.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
		}
		
	//	System.out.println("whereClause "+whereClause);
		
		if((order != null) && (order.equals("A")))
		{
			order="D";
		}
		else
		{
			order="A";
		}	

		// Constructing the table or view name to be used for querying records.
		if(purge_status != null && !purge_status.equals(""))
		{
			tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
		else
		{
			tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
	}
	catch(Exception exp)												   
	{
		exp.printStackTrace(System.err);
	}

//	request.setAttribute(XHQueryRender.strQueryId,"VIEW_GENERAL_EVENTS"); eBilling
	request.setAttribute(XHQueryRender.strQueryId,"VIEW_GENERAL_EVENTS_EBILL");
	request.setAttribute("tableName",tableNameSuffix);
//	request.setAttribute(XHQueryRender.col,"27"); eBilling
    request.setAttribute(XHQueryRender.col,"51");
	request.setAttribute(XHQueryRender.maxRec,maxRecords);
//	request.setAttribute(XHQueryRender.whereClause,whereClause);	Commented for eBilling
	request.setAttribute(XHQueryRender.whereClause,whereClause1);	
//	conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);	
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	System.out.println("test1234");

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
		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
 	%>

<input type='hidden' name='msg_status' id='msg_status' value='<%=msg_status%>' >
<input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>
<input type='hidden' name='temp' id='temp' value='<%=temp%>'>
<input type='hidden' name='facility' id='facility' value='<%=facility %>'>
<input type='hidden' name='msg_id1' id='msg_id1' value='<%=msg_id1 %>'>
<input type='hidden' name='msg_dt1' id='msg_dt1' value='<%=msg_dt1 %>'>
<input type='hidden' name='msg_id2' id='msg_id2' value='<%=msg_id2 %>'>
<input type='hidden' name='msg_dt2' id='msg_dt2' value='<%=msg_dt2 %>'>
<input type='hidden' name='orderBy' id='orderBy' value='<%=orderBy %>'> 
<input type='hidden' name='order' id='order' value='<%=order%>'>
<input type='hidden' name='merg_pat_id' id='merg_pat_id' value='<%=merg_pat_id %>'>
<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type %>'>
<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id %>'>
<input type='hidden' name='action_typ' id='action_typ' value='<%=action_typ %>'>
<input type='hidden' name='last_processed_date' id='last_processed_date' value='<%=last_processed_date %>'>
<input type='hidden' name='not_req_rsn' id='not_req_rsn' value='<%=not_req_rsn %>'>
<input type='hidden' name='addid' id='addid' value='<%=addid %>'>
<input type='hidden' name='addeddate' id='addeddate' value='<%=addeddate %>'>
<input type='hidden' name='addedwsno' id='addedwsno' value='<%=addedwsno %>'>
<input type='hidden' name='modfid' id='modfid' value='<%=modfid %>'>
<input type='hidden' name='modifieddate' id='modifieddate' value='<%=modifieddate %>'>
<input type='hidden' name='modifiedwsno' id='modifiedwsno' value='<%=modifiedwsno %>'>
<input type='hidden' name='msg_date' id='msg_date' value='<%=msg_date %>'>
<input type='hidden' name='applnname' id='applnname' value='<%=applnname %>'>
<input type='hidden' name='eventtype' id='eventtype' value='<%=eventtype %>'>
<input type='hidden' name='whereClause' id='whereClause' value='<%=java.net.URLEncoder.encode(whereClause) %>'>
<input type='hidden' name='purge_status' id='purge_status' value='<%=purge_status%>'>
<input type='hidden' name='event_status' id='event_status' value='<%=eventStatus%>'>
<input type='hidden' name='externalAccNoFrom' id='externalAccNoFrom' value='<%=externalAccNoFrom%>'>
<input type='hidden' name='externalAccNoTo' id='externalAccNoTo' value='<%=externalAccNoTo%>'>
<input type='hidden' name='interface_module' id='interface_module' value='<%=interface_module%>'>
<input type='hidden' name='tableNameSuffix' id='tableNameSuffix' value='<%=tableNameSuffix%>'>
<input type='hidden' name='sub_module' id='sub_module' value='<%=sub_module%>'>
<input type='hidden' name='comm_mode' id='comm_mode' value='Outbound'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='rebuildAut' id='rebuildAut' id="rebuildAut" value='<%=authToRebuild%>'>
<input type='hidden' name='replayAut' id='replayAut' id="replayAut" value='<%=authToReplay%>'>
<input type='hidden' name='commExpAut' id='commExpAut' id="commExpAut" value='<%=authToVwCommErr%>'>
<input type='hidden' name='audtiAut' id='audtiAut' id="audtiAut" value='<%=authToAudit%>'>
<input type='hidden' name='viewAuth' id='viewAuth' id="viewAuth" value='<%=viewAuth%>'>
<input type='hidden' name='dispMode' id='dispMode' id="dispMode" value='<%=dispMode%>'>
<input type='hidden' name='protocol_link_id' id='protocol_link_id' id="protocol_link_id" value='<%=protocol_link_ID%>'>
<input type='hidden' name='protocol_link_name' id='protocol_link_name' id="protocol_link_name" value='<%=protocol_link_name%>'>

<%
if(arrRow.size()==0){
%>	

<script>	
	alert(getMessage('XH1021','XH'));
	editQuery(); // calling header page with the query criteria in the request object
</script>

<%
}  
else{
%>

<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan="2" align="center" class="COLUMNHEADER"><fmt:message key="eXH.OutboundEvents.label" bundle="${xh_labels}"/></td>
</tr>
<tr>	   
	<td align="left" class="CAGROUP">
		<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="editQuery();" TITLE="Edit Query">
			EditQuery
		</A>
	<% if(authToRebuild || authToReplay){ %>
		<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="refreshResults('ViewEventsOutboundDtlTest1');" TITLE="Refresh Events">
			Refresh
		</A>
	<% } %>
	</td>
	<td align="right" class="CAGROUP"> 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
	</td>
</tr>
</table>

<div id="left_child" style="display:none;">
<table id="table1" cellspacing=0 cellpadding=3 border=1>	
	<tr>
		<td class='COLUMNHEADER' title="Select">
		          <font color=white>Select</font> </td>	
		</td>

		<td class='COLUMNHEADER' title="Event Status">
			&nbsp; $ &nbsp;
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' title="Message Status" href="javascript:callForOrderBy('MESSAGE_STATUS_DESC','<%=order%>');" onclick=''>
			<font color=white>
			&nbsp; # &nbsp; 
			</font>
		</td> 
<!--		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('lpad(Message_ID,20)','<%=order%>');" onclick=''>
			<font color=white><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('application_name','<%=order%>');"onclick=''>
			<font color=white><fmt:message key="Common.Application.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('EVENT_TYPE','<%=order%>');"onclick='' >
			<font color=white><fmt:message key="Common.Event.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('MESSAGE_DATE','<%=order%>');"onclick='' >
			<font color=white><fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('FACILITY_NAME','<%=order%>');"onclick='' >
			<font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('protocol_link_ID','<%=order%>');"onclick=''><font color=white>Gateway</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('PATIENT_ID','<%=order%>');"onclick='' >
			<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
		</td> -->

		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('lpad(INV_NO,20)','<%=order%>');" onclick=''>
			<font color=white>Invoice Number</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('INV_DATE','<%=order%>');"onclick=''>
			<font color=white>Invoice Date</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('AMOUNT','<%=order%>');"onclick='' >
			<font color=white>Amount</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('VISIT_DATE','<%=order%>');"onclick='' >
			<font color=white>Visit Date</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('PATIENT_NAME','<%=order%>');"onclick='' >
			<font color=white>Patient Name</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('PATIENT_TYPE','<%=order%>');"onclick=''><font color=white>Patient Type</font>
		</td>
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('CARD_ID','<%=order%>');"onclick='' >
			<font color=white>Card ID</font>
		</td> 
		<td class='COLUMNHEADER'>
			<a id='a001' href="javascript:callForOrderBy('CARD_ISS_DATE','<%=order%>');"onclick='' >
			<font color=white>Card Issue Date</font>
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
        String episode_typ = "";
		String enabled_yn = "";
		String policy_dsc = "";

	%>
	<tr>
	<td  <%=strTDClass%> align="left" >
		<input type=checkbox name='' id='' value='' >
	</td>
	<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<img src='../../eXH/images/blue_square.jpg' height=10 ></td>
	<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<img src='../../eXH/images/blue_square.jpg' height=10 ></td>
	
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(41))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(42))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(43))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(44))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(45))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(46))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(47))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(48))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=XBDBAdapter.checkNull((String)arrCol.get(49))+""%>
	</td>
	</tr>
</table>
</div>
	
<SCRIPT>
	document.getElementById("left_child").style.display = "block";
	document.getElementById("right_child").style.display = "block";
	parent.messageFrame.location.href = "../../eXB/jsp/ViewEventsOutboundFooter.jsp?commType=outbound"; 
</SCRIPT>
	
	<%
		}
	}
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
	if(resultsQry!=null) resultsQry.clear();
}
catch(Exception e1)
{
	out.println("(ViewEventsOutboundDt1Test1.jsp:Exception) "+e1);
	e1.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>

</form>
</html>


