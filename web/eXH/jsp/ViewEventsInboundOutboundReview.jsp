<!DOCTYPE html>
<html> 
<head>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*,java.util.regex.Pattern" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale="en";
Properties p = (Properties) session.getValue("jdbc"); 
String loggedUser = p.getProperty("login_user");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
 
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<title><fmt:message key="eXH.MessageReview.Label" bundle="${xh_labels}"/></title> 

<% 																				   		   
String statusColor="../../eXH/images/black_square.jpg";
String sstatusColor="../../eXH/images/blue_square.jpg";     						 

String msg_id;																					   





String url="";
String url1="";

String rebuildflag="false"; 
String replayflag="false";
String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
String status;									  
String orderBy;
String tableNameSuffix= "";

msg_status=null;
facility=null;									    
msg_id=null;						    											    
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
HashMap resultsQry=new HashMap(); 

String interface_module=null;
String sub_module = null;
pmode=null;
String externalAccNoFrom = null;
String externalAccNoTo = null;
String purge_status = null;
String protocol_link_ID = null;

boolean msgProcessed = false;
loggedUser = p.getProperty("login_user");

String reviewFlag="false";

Connection conn = null;

try
{   
	msg_id	= XHDBAdapter.checkNull(request.getParameter("msgID"));
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
	eventStatus= XHDBAdapter.checkNull(request.getParameter("event_status")); 
	whereClause=XHDBAdapter.checkNull(request.getParameter("wherecaluse"));
	externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
	externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
	purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
	protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
	pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));


       

	 if(orderBy.equals("1") || orderBy==null || orderBy.equals(""))
	{
		orderBy="1,3,9";
	} 
    try{
		conn = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{ 
		System.out.println("(ViewEventsInboundReview.jsp:error) :"+e);
	}
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

String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
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


    if(whereClause.equals("") || whereClause==null)
	{
 	boolean flag =false;	
	whereClause =" WHERE ";


 
		//facility	
	if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " amv.FACILITY_ID = NVL('"+facility+"',amv.FACILITY_ID)";
			flag=true;
		} 

		//application_id
		if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND amv.APPLICATION_ID = NVL('"+applnname+"',amv.APPLICATION_ID) ";
		} 

		if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " amv.APPLICATION_ID = NVL('"+applnname+"',amv.APPLICATION_ID) ";
			flag=true;
		} 

		//eventtype
		if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " AND EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE) ";
		} 

		if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE) ";
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
				whereClause = whereClause + " AND EVENT_STATUS = NVL('"+eventStatus+"',EVENT_STATUS) ";
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
				whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('"+msg_status+"',MESSAGE_STATUS)";
		} 

		if((flag==false) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" MESSAGE_STATUS = "+						
								"NVL('"+msg_status+"',MESSAGE_STATUS)";
			flag=true;
		} 

		//msg_id1
		if((flag == true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),message_id)";
			}
			else
			{
				whereClause =whereClause +" AND message_id BETWEEN"+ 	
								"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
			}
		} 

		if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),message_id)";
			}
			else
			{
				whereClause = whereClause +" message_id BETWEEN"+ 	
									"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
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
								"  nvl('"+msg_id2+"',message_id)";
			}
		} 

		if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" message_id <"+ 	
								"  nvl('"+msg_id2+"',message_id)";
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
								" TO_DATE(NVL('"+msg_dt2+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
			flag=true;
		}

		//patient_id
		if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND  PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
		} 

		if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
		{
			whereClause =whereClause +" PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
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
			whereClause =whereClause +" AND EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
		} 

		if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
		} 

		//episode_id
		if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" AND EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
		} 

		if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
			flag=true;
		}  

		//visit_id
		if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause =whereClause +"  AND VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
		} 

		if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause = whereClause +" VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
			flag=true;
		} 

		//action type
		if(action_typ != null)
		{
			action_typ=action_typ.trim();	
		}
		if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +"  AND ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
		} 

		if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +" ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
			flag=true;
		} 
	/*	if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " AND TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
		} 

		if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
			flag=true;
		} */

		//not_required_reason
		if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" AND   NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
								",NOT_REQ_REASON)";
		} 

		if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
								",NOT_REQ_REASON) ";
			flag=true;
		}  

		//addid   
		if((flag==true) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" AND (ADDED_BY_ID= NVL('"+addid+"',ADDED_BY_ID))";
		} 

		if((flag==false) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" (ADDED_BY_ID= NVL('"+addid+"',ADDED_BY_ID))"; 		 	
			flag=true;
		}  

		//addeddate
		if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" AND  TO_CHAR(ADDED_DATE,'dd/mm/yyyy')"+ 	
								"=NVL('"+addeddate+"',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))";
		} 

		if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" TO_CHAR(ADDED_DATE,'dd/mm/yyyy') =NVL('"+addeddate+"',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))"; 		 	
			flag=true;
		}  

		//addedwsno
		if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" AND ADDED_AT_WS_NO"+ 			         
								"=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
		} 

		if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" ADDED_AT_WS_NO"+
									"=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
			flag=true;
		}  

		//modfied id
		if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_BY_ID=NVL('"+modfid+"',MODIFIED_BY_ID)";
		} 
		if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" MODIFIED_BY_ID=NVL('"+modfid+"',MODIFIED_BY_ID)";
			flag=true;
		}  
		//modifieddate
		if((flag==true) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" AND TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('"+modifieddate+"',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
		} 
		if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('"+modifieddate+"',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
			flag=true;
		}  

		// modifiedwsno
		if((flag==true) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_AT_WS_NO"+ 
								"=NVL('"+modifiedwsno+"',MODIFIED_AT_WS_NO)";
		} 

		if((flag == false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause = whereClause +"  MODIFIED_AT_WS_NO=NVL('"+modifiedwsno+"',MODIFIED_AT_WS_NO)";
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
			if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
	else
	{
		tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
		request.setAttribute("tableName",tableNameSuffix);    
		//request.setAttribute("action_type",""); 
		request.setAttribute("qry_id","VIEW_GENERAL_EVENTS");   
		request.setAttribute("whereClause",whereClause);   
		request.setAttribute("maxRec","1"); 
		XHViewQueryControllerElementBean	xhBean =
		XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
		xhBean.action(request,conn);  
			if(msg_id==null || msg_id.equals("") )
      		{
      			resultsQry  = xhBean.getResultSet(); 
      		}
      		else
      		{
				resultsQry  = xhBean.getPositionMsgRecord(msg_id);

      		}
			    
		
		
		
	}
	else
	{
			if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
	else
	{
		tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
	}
		request.setAttribute("tableName",tableNameSuffix);    
		//request.setAttribute("action_type","Q");  
		request.setAttribute("qry_id","VIEW_GENERAL_EVENTS");   
		request.setAttribute("whereClause",whereClause);   
		request.setAttribute("maxRec","1");   
		XHViewQueryControllerElementBean	xhBean =
		XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
		xhBean.action(request,conn);  

		//System.out.println("enaga error 672");
		if(posi.equals("")||posi==null) 
		{ 
			resultsQry  = xhBean.getResultSet(); 
		}
		else 
	   {
		 resultsQry  = xhBean.getPositionRecord(posi);
	}


															  
		 
		
		 
	   }
		ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
		ArrayList arrCol=new ArrayList(); 
		if(arrRow.size()==0) 
		{    
		 %>	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);parent.window.close();</script>
		<%} 
		else 
		{   
																			  
			//System.out.println("enaga error");
		  for (int j=0; j<arrRow.size();j++)
		 {

  			    arrCol = (ArrayList)arrRow.get(j);
				String applicationID=XHDBAdapter.checkNull(arrCol.get(0)+"");
				String facilityID=XHDBAdapter.checkNull(arrCol.get(8)+"");
				String eventType=XHDBAdapter.checkNull((String)arrCol.get(4));
				String protocol_link_id1=XHDBAdapter.checkNull((String)arrCol.get(25));
				String msgID=XHDBAdapter.checkNull((String)arrCol.get(2));


				String srlNo1="";
				 pat_id=XHDBAdapter.checkNull((String)arrCol.get(5));
                 episode_type=XHDBAdapter.checkNull((String)arrCol.get(9)); 
				String facilityName=XHDBAdapter.checkNull((String)arrCol.get(7));
				String applicationName=XHDBAdapter.checkNull((String)arrCol.get(1));
			    posi=arrCol.get(29)+"";   
				
				String accessionNumber=XHDBAdapter.checkNull((String)arrCol.get(12)); 
				 episode_id=XHDBAdapter.checkNull((String)arrCol.get(10)); 
				 visit_id=XHDBAdapter.checkNull((String)arrCol.get(11)); 
				String queryDate = "";
				String Message_Date = "";
				msgProcessed = false;
				sstatusColor = "../../eXH/images/blue_square.jpg";
				statusColor="../../eXH/images/blue_square.jpg";
				status =((String)arrCol.get(16)).equals("null")?"":(String)arrCol.get(16);
					String msgStatus=XHDBAdapter.checkNullNoTrim((String)arrCol.get(24));
				status=status.trim();		
				if(status.equalsIgnoreCase("S"))  
				{			
					statusColor="../../eXH/images/green_square.jpg" ;
					msgProcessed = true;
				}
				if(status.equalsIgnoreCase("N"))  statusColor="../../eXH/images/black_square.jpg";
				if(status.equalsIgnoreCase("E"))  
				{
					statusColor="../../eXH/images/red_square.jpg" ;
					msgProcessed = true;
				}
				if(status.equalsIgnoreCase("A"))  statusColor = "../../eXH/images/yello_square.jpg" ;
				if(status.equalsIgnoreCase(""))  statusColor = "../../eXH/images/blue_square.jpg" ;

 	           queryDate = ((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
				if(!queryDate.equals("")) 
				{
					queryDate = com.ehis.util.DateUtils.convertDate(queryDate,"DMYHMS","en",locale);			
					Message_Date = XHUtil.convertToDate(queryDate,"dd/MM/yyyy hh:mm:ss");			
				} 

                 if(msgProcessed==true && authToRebuild==true)
			   {
					rebuildflag="true"; 
               }
				if(msgProcessed==true && authToReplay==true)
			   {
					replayflag="true"; 
               }
			   if(msgStatus.equals("") || msgStatus.equals(" ") || msgStatus==null)
			 {
				replayflag="false"; 
			 }

             if(applicationID!="*A" && msgProcessed==true && authToVwCommErr==true )
			 {
				reviewFlag="true";
			 }
			    
							    
			    url1="applicationID="+applicationID+
								"&facilityID="+facilityID+
								"&msgID="+msgID+
								"&facilityName="+facilityName+ 
								"&applicationName="+applicationName+
								"&protocolMode=O&sub_module="+sub_module+
								"&srlNo="+srlNo1+
								"&protocol_link_id="+protocol_link_id1+			 				"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+posi+"&msgStatus="+msgStatus+"&accessionNumber="+accessionNumber+"&msgDate="+Message_Date+"&pat_id="+pat_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&RebuildOP="+rebuildflag+"&ReplayOP="+replayflag+"&reYN=Y"+"&whereClause="+java.net.URLEncoder.encode(whereClause); 	 
         		 url    ="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?appl_name="+applicationID+"&facility="+facilityID+"&sub_module="+sub_module+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&commMode=O&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";
		  }
												 
             if(reviewFlag.equals("true"))
			{  
%>  
<div  id='eventExceptionFrameset'>	 		    
	<iframe name='f_query_' id='f_query_' src='../../eXH/jsp/ViewEventNextPreviousPage.jsp?<%=url1%>&action_type=Q&pagechange=N' frameborder=0 noresize scrolling='no' style="width:98vw; height:3vh"></iframe>
	<iframe name='resultsFrame' id='resultsFrame' src='../../eXH/jsp/ViewEventExceptionsHeaderReviewMain.jsp?<%=url1%>&action_type=Q' scrolling="no" frameborder="0" noresize style="width:98vw; height:80vh"></iframe> 
	 
	<%---<frame name='resultsFrame' id='resultsFrame' src='../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?<%=url1%>&action_type=A' scrolling="no" frameborder="0" noresize>---%>
	<iframe name='auditlogFrame' id='auditlogFrame'	 src='<%=url%>' frameborder=1 noresize scrolling='no' style="width:98vw; height:15vh"> </iframe>
</div>  
<%    																			   
			}
			else 													    
			{
			%>	
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));			 
			history.go(-1);
			parent.window.close();
			</script>
		<%
			} 
	} 
	if(resultsQry!=null)  resultsQry.clear();  
	if(arrCol!=null) arrCol.clear(); 
	if(arrRow!=null)  arrRow.clear();
}
catch(Exception e1)
{
	System.out.println("Error in calling getconnection method of dooperate method of ViewEventsInboundOutboundReview.jsp:"+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>

  




</html>  

