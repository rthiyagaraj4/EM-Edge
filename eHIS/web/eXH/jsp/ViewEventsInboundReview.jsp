<!DOCTYPE html>
<html> 
<head>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
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
String url="";
String applicationid="";
String whereClause;
String msg_id = null;
String facilityid="";
String srlno="";																						  
String tableNameSuffix=""; 
String url1="";


Connection conn = null; 

String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order; 
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,pmode,eventStatus;
							  
String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
String orderBy;
String reviewFlag="false";

HashMap resultsQry=new HashMap();
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
String action_type=null;

String interface_module=null;
String sub_module = null;
pmode=null;
String externalAccNoFrom = null;
String externalAccNoTo = null;
String purge_status = null;
String protocol_link_id = null;



loggedUser = p.getProperty("login_user");
boolean flag =false;

try
{	 
	msg_id	= XHDBAdapter.checkNull(request.getParameter("msgID"));

	purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
	sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module")); 
	 	  
	action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
	 	 srlno	= XHDBAdapter.checkNull(request.getParameter("srlNo"));
	 applicationid	= XHDBAdapter.checkNull(request.getParameter("applicationID"));
	 facilityid	= XHDBAdapter.checkNull(request.getParameter("facilityID"));


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
	protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
	pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));
	//String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
	whereClause = XHDBAdapter.checkNull(request.getParameter("wherecaluse"));    
	String reloadflag="false";
	 if(orderBy.equals("1") || orderBy==null || orderBy.equals(""))
	{
		orderBy="1,3,9";
	}
 	try 
	{
		conn = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{
		System.out.println("(ViewEventsInboundReview.jsp:error) :"+e);
	}
	

	String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE LOGIN_NAME='"+loggedUser+"'"; 
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToReload = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	try
	{
		
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



	if(purge_status != null && !purge_status.equals(""))
	{
		tableNameSuffix = sub_module+"_"+purge_status+"_INBOUND_MESSAGE_vw X";
	}
	else
	{
		tableNameSuffix = sub_module+"_INBOUND_MESSAGE_VW X";
	}

 

	if(whereClause.equals("")||whereClause==null)
	{

        /*    if(msg_id==null || msg_id.equals("") )
      		{
				 request.setAttribute("applicationID","");
                 request.setAttribute("facilityID","");
                 request.setAttribute("srlNo",""); 
      		}
      		else
      		{
				  request.setAttribute("applicationID",applicationid);
				  request.setAttribute("facilityID",facilityid);
				  request.setAttribute("srlNo",srlno); 
			}*/

		whereClause =" WHERE ";
	if((facility != null) && !(facility.equals("")))			
	{
		whereClause =whereClause + " X.FACILITY_ID = NVL('"+facility+"',X.FACILITY_ID)";
		flag=true;
	} 
	//application_id
	if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
	{
		whereClause =whereClause + " AND X.APPLICATION_ID = NVL('"+applnname+"',X.APPLICATION_ID)";
	} 

	if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
	{
		whereClause =whereClause + " X.APPLICATION_ID = NVL('"+applnname+"',X.APPLICATION_ID)";
		flag=true;
	}
	// srl no
	/*if((flag==true) && (srlNo != null) && (!(srlNo.equals(""))))			
	{
		whereClause =whereClause +" AND X.SRL_NO = NVL('"+srlNo+"',SRL_NO)";	
	} 
 
	if((flag==false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
		whereClause =whereClause +"  X.SRL_NO = NVL('"+srlNo+"',SRL_NO)";
		flag=true; 
	} */
	//eventtype
	if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " AND X.EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)";
	} 

	if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " X.EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)";
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
			whereClause =whereClause +" AND X.MESSAGE_STATUS = NVL('"+msg_status+"',X.MESSAGE_STATUS)";
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
			whereClause =whereClause +" X.MESSAGE_STATUS = NVL('"+msg_status+"',X.MESSAGE_STATUS)";
		}
		flag=true;
	} 
	//msg_id1
	if((flag == true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
	{
		if((msg_id2 != null) && ((msg_id2.equals("")))) 
		{
			whereClause = whereClause +" AND X.message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),message_id)";
		}
		else
		{
			whereClause =whereClause +" AND X.message_id BETWEEN"+ 	
								"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
		}
	} 

	if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
	{
		if((msg_id2 != null) && ((msg_id2.equals("")))) 
		{
			whereClause = whereClause +" X.message_id >="+ 	
							"  nvl(lpad('"+msg_id1+"',20),message_id)";
		}
		else
		{
			whereClause = whereClause +" X.message_id BETWEEN"+ 	
							"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
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
								"  nvl(lpad('"+msg_id2+"',20),message_id)";
		}
	} 

	if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
	{
		if((msg_id1 != null) && (!(msg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" X.message_id <"+ 	
							"  nvl(lpad('"+msg_id2+"',20),message_id)";
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
		whereClause = whereClause + " AND X.protocol_link_id = nvl('"+protocol_link_id+"',X.protocol_link_id) ";
	}
	if((flag == false) && (protocol_link_id != null) && (!protocol_link_id.equals("")) )
	{
		whereClause = whereClause + " X.protocol_link_id = nvl('"+protocol_link_id+"',X.protocol_link_id) ";
		flag = true;
	}

	//patient_id
	if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
	{
		whereClause =whereClause +" AND  X.PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
	} 

	if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
	{
		whereClause =whereClause +" X.PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
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
		whereClause =whereClause +"AND X.EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
	} 

	if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
	{
		whereClause =whereClause +" X.EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
	} 

	//episode_id
	if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
	{
		whereClause =whereClause +" AND X.EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
	} 

	if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
	{
		whereClause =whereClause +" X.EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
		flag=true;
	} 

	//visit_id
	if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
	{
		whereClause =whereClause +"  AND X.VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
	} 

	if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
	{
		whereClause =whereClause +" X.VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
		flag=true;
	} 

	//action type 
	if(action_typ != null)
	{ 
		action_typ=action_typ.trim();	
	}
	if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
	{
		whereClause = whereClause +"  AND X.ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
	} 

	if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
	{
		whereClause = whereClause +" X.ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
		flag=true;
	} 
	/*if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
	{
		whereClause = whereClause + " AND TO_CHAR(X.LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
				"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
	} 

	if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
	{

		whereClause = whereClause + " TO_CHAR(X.LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
									"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
		flag=true;
	} */

	//not_required_reason
	if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
	{
		whereClause = whereClause +" AND   X.NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
							",NOT_REQ_REASON)";
	} 

	if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
	{

		whereClause = whereClause +" X.NOT_REQ_REASON= NVL('"+not_req_rsn+"',NOT_REQ_REASON)";
		flag=true;
	}  

	//addid   
	if((flag==true) && (addid != null) && (!(addid.equals(""))))			
	{
		whereClause = whereClause +" AND (X.ADDED_BY_ID= NVL('"+addid+"',X.ADDED_BY_ID))";
	} 

	if((flag==false) && (addid != null) && (!(addid.equals(""))))			
	{
		whereClause = whereClause +" (X.ADDED_BY_ID= NVL('"+addid+"',X.ADDED_BY_ID))"; 		 	
		flag=true;
	}  

	//addeddate
	if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
	{
		whereClause = whereClause +" AND  trunc(X.ADDED_DATE)=to_date(NVL('"+addeddate+"',X.ADDED_DATE),'dd/mm/yyyy')";
	} 

	if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
	{
		whereClause = whereClause +" trunc(X.ADDED_DATE) = to_date(NVL('"+addeddate+"',to_char(X.ADDED_DATE,'dd/mm/yyyy'))"; 		 	
		flag=true;
	}  

	//addedwsno
	if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
	{

		whereClause = whereClause +" AND X.ADDED_AT_WS_NO=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
	} 

	if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
	{

		whereClause = whereClause +" X.ADDED_AT_WS_NO=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
		flag=true;
	}  
 
	//modfied id
	if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
	{
		whereClause = whereClause +" AND X.MODIFIED_BY_ID=NVL('"+modfid+"',MODIFIED_BY_ID)";
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
		whereClause = whereClause +"  X.MODIFIED_AT_WS_NO=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
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
  request.setAttribute("tableName",tableNameSuffix); 
  request.setAttribute("qry_id","VIEW_INBOUND_EVENTS");   
  request.setAttribute("whereClause",whereClause); 
  request.setAttribute("maxRec","1"); 
   XHViewInboundControllerElementBean	xhBean =
  XHViewInboundControllerElementBean.getBean(XHViewInboundControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
			if(msg_id==null || msg_id.equals("") )
      		{
				
      			 resultsQry  = xhBean.getResultSet(); 
      		}
      		else
      		{
			
				  resultsQry  = xhBean.getPositionMsgRecord(msg_id+srlno+applicationid+facilityid);

      		}
   
    
 
	}
	else 
	{


		 request.setAttribute("tableName",tableNameSuffix); 
  request.setAttribute("qry_id","VIEW_INBOUND_EVENTS");   
  request.setAttribute("whereClause",whereClause); 
  request.setAttribute("maxRec","1"); 
  XHViewInboundControllerElementBean	xhBean =
  XHViewInboundControllerElementBean.getBean(XHViewInboundControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);

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
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);parent.window.close();</script>");
 }  
else{ 
for (int j=0; j<arrRow.size();j++)
{
			arrCol = (ArrayList)arrRow.get(j);
			String applicationID=arrCol.get(1)+"";
			String facilityID=arrCol.get(24)+"";
			String eventType=(String)arrCol.get(15);
			String protocol_link_id1=(String)arrCol.get(23);
			String msgID=(String)arrCol.get(3);
			String srlNo1= XHDBAdapter.checkNull((String)arrCol.get(36));

			String facilityName=XHDBAdapter.checkNull((String)arrCol.get(35));
			String applicationName=XHDBAdapter.checkNull((String)arrCol.get(2));
			String msgStatus=XHDBAdapter.checkNullNoTrim((String)arrCol.get(0));
			posi=arrCol.get(37)+"";  
			
		   if(msgStatus!="S" && authToReload==true) 
			{
			   reloadflag="true";
			}
 
			  if(authToVwCommErr==true)
			 { 
				reviewFlag="true";
			 }


			url1="applicationID="+applicationID+
				"&facilityID="+facilityID+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode=I&sub_module="+sub_module+
				"&srlNo="+srlNo1+ 
				"&protocol_link_id="+protocol_link_id1+
				"&purge_status="+purge_status+"&even_type="+eventType+"&posi="+posi+"&msgStatus="+msgStatus+"&ReloadOP="+reloadflag+"&reYN=Y"+"&whereClause="+java.net.URLEncoder.encode(whereClause);  	 
     
	        url ="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?appl_name="+applicationID+"&facility="+facilityID+"&sub_module="+sub_module+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&commMode=I&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en&whereClause="+java.net.URLEncoder.encode(whereClause); 
  } 
}
if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear(); 

if(reviewFlag.equals("true"))
{  
	%>  
<iframe name='f_query_' id='f_query_' src='../../eXH/jsp/ViewEventInboundNextPreviousPage.jsp?<%=url1%>&action_type=Q&pagechange=N' frameborder=0 noresize scrolling='no' style='height:3vh;width:100vw'></iframe>
<iframe name='resultsFrame' id='resultsFrame' src='../../eXH/jsp/ViewEventInboundExceptionsHeaderMain.jsp?<%=url1%>&action_type=Q' scrolling="no" frameborder="0" noresize style='height:77vh;width:100vw'></iframe> 
		<iframe name='auditlogFrame' id='auditlogFrame'	 src='<%=url%>' frameborder=1 noresize scrolling='no' style='height:20vh;width:100vw'></iframe> 
<%  
} 
else
{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);parent.window.close();</script>");
} 
} 
catch(Exception e1)
{
	System.out.println("Error in calling getconnection method of dooperate method of ViewEventsInboundReview.jsp:"+e1.toString());
	e1.printStackTrace(System.err);
} 
finally
{
	ConnectionManager.returnConnection(conn);  
}
 
%>
</html>  

