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
 																						   

String msg_id;
String url="";																						  
String url1="";
String rebuildflag="false"; 
String replayflag="false";
String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
	  
String orderBy;
String tableNameSuffix="XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";

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
		orderBy="1";
	} 
    try{
		conn = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{ 
		System.out.println("error :"+e);
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
	whereClause =" ";


 
		//facility	
	if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " a.FACILITY_ID = NVL('"+facility+"',a.FACILITY_ID)";
			flag=true;
		} 

		//application_id
		if((applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND a.APPLICATION_ID = NVL('"+applnname+"',a.APPLICATION_ID) ";
		} 

		/*if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " a.APPLICATION_ID = NVL('"+applnname+"',a.APPLICATION_ID) ";
			flag=true;
		} 
*/
		//eventtype
		if((eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " AND a.EVENT_TYPE = NVL('"+eventtype+"',a.EVENT_TYPE) ";
		} 

	/*	if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " a.EVENT_TYPE = NVL('"+eventtype+"',a.EVENT_TYPE) ";
			flag=true;
		} 
*/
		//eventStatus
		if((eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " AND a.EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " AND a.EVENT_STATUS = NVL('"+eventStatus+"',a.EVENT_STATUS) ";
			}
		} 

		/*if((flag==false) && (eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " a.EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " a.EVENT_STATUS = NVL('"+eventStatus+"',a.EVENT_STATUS)";
			}
			flag=true;
		}  */

		//msgstatus
		if((msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" AND a.MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" AND a.MESSAGE_STATUS = "+"NVL('"+msg_status+"',a.MESSAGE_STATUS)";
		} 

	/*	if((flag==false) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" a.MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" a.MESSAGE_STATUS = "+						
								"NVL('"+msg_status+"',a.MESSAGE_STATUS)";
			flag=true;
		} */

		//msg_id1
		if((msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND a.message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),a.message_id)";
			}
			else
			{
				whereClause =whereClause +" AND a.message_id BETWEEN"+ 	
								"  nvl('"+msg_id1+"',a.message_id) AND nvl('"+msg_id2+"',a.message_id)";
			}
		} 

		/*if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			  
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" a.message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),a.message_id)";
			}
			else
			{
				whereClause = whereClause +" a.message_id BETWEEN"+ 	
									"  nvl('"+msg_id1+"',a.message_id) AND nvl('"+msg_id2+"',a.message_id)";
				flag = true;
			}
		} */

		//msg_id2
		if((msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND a.message_id <"+ 	
								"  nvl('"+msg_id2+"',a.message_id)";
			}
		} 

		/*if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" a.message_id <"+ 	
								"  nvl('"+msg_id2+"',a.message_id)";
			}
			flag  =true;
		} */

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

		if((msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +" AND TO_DATE(a.MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 

		/*if((flag==false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +"  TO_DATE(a.MESSAGE_DATE) BETWEEN  "+  	
								" TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			flag=true;
		}*/
		
		//msg_dt2
		if((msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(a.MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 
																		    
	/*	if((flag==false) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			 
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{

System.out.println("whereClause :"+whereClause);

				whereClause =whereClause+" and TO_DATE(a.MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+msg_dt2+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
			flag=true;
		}
*/
		//patient_id
		if((pat_id != null) && (!(pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND  a.PATIENT_ID= NVL('"+pat_id+"' ,a.PATIENT_ID)";
		} 

		/*if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
		{
			whereClause =whereClause +" a.PATIENT_ID= NVL('"+pat_id+"' ,a.PATIENT_ID)";
			flag=true;
		} */

		//merge_patient_id
		if((merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND (NVL(a.MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"a.MERGED_PATIENT_ID = NVL('',a.MERGED_PATIENT_ID))";
		} 
		/*if((flag==false) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" (NVL(a.MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"a.MERGED_PATIENT_ID = NVL('',a.MERGED_PATIENT_ID))";
			flag=true;
		} */

		//episode_type
		if((episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" AND a.EPISODE_TYPE= NVL('"+episode_type+"' ,a.EPISODE_TYPE)";
		} 

		/*if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" a.EPISODE_TYPE= NVL('"+episode_type+"' ,a.EPISODE_TYPE)";
		} */

		//episode_id
		if((episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" AND a.EPISODE_ID = NVL('"+episode_id+"',a.EPISODE_ID)";
		} 

	/*	if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" a.EPISODE_ID = NVL('"+episode_id+"',a.EPISODE_ID)";
			flag=true;
		}  */

		//visit_id
		if((visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause =whereClause +"  AND a.VISIT_ID= NVL('"+visit_id+"' ,a.VISIT_ID)";
		} 

		/*if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause = whereClause +" a.VISIT_ID= NVL('"+visit_id+"' ,a.VISIT_ID)";
			flag=true;
		} */

		//action type
		if(action_typ != null)
		{
			action_typ=action_typ.trim();	
		}
		if((action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +"  AND a.ACTION_TYPE = NVL('"+action_typ+"',a.ACTION_TYPE) ";
		} 

		/*if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +" a.ACTION_TYPE = NVL('"+action_typ+"',a.ACTION_TYPE) ";
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
		if( (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" AND   a.NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
								",a.NOT_REQ_REASON)";
		} 

	/*	if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" a.NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
								",a.NOT_REQ_REASON) ";
			flag=true;
		}  */

		//addid   
		if((addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" AND (a.ADDED_BY_ID= NVL('"+addid+"',a.ADDED_BY_ID))";
		} 

	/*	if((flag==false) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" (a.ADDED_BY_ID= NVL('"+addid+"',a.ADDED_BY_ID))"; 		 	
			flag=true;
		}  
*/
		//addeddate
		if((addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" AND  TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy')"+ 	
								"=NVL('"+addeddate+"',TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy'))";
		} 

	/*	if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy') =NVL('"+addeddate+"',TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy'))"; 		 	
			flag=true;
		}  */

		//addedwsno
		if((addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" AND a.ADDED_AT_WS_NO"+ 			         
								"=NVL('"+addedwsno+"',a.ADDED_AT_WS_NO)";
		} 

	/*	if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" a.ADDED_AT_WS_NO"+
									"=NVL('"+addedwsno+"',a.ADDED_AT_WS_NO)";
			flag=true;
		}  */

		//modfied id
		if( (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" AND a.MODIFIED_BY_ID=NVL('"+modfid+"',a.MODIFIED_BY_ID)";
		} 
	/*	if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" a.MODIFIED_BY_ID=NVL('"+modfid+"',a.MODIFIED_BY_ID)";
			flag=true;
		}  */
		//modifieddate 
		if((modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" AND TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('"+modifieddate+"',TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy'))";
		} 
	/*	if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('"+modifieddate+"',TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy'))";
			flag=true;
		}  */

		// modifiedwsno
		if((modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause =whereClause +" AND a.MODIFIED_AT_WS_NO"+ 
								"=NVL('"+modifiedwsno+"',a.MODIFIED_AT_WS_NO)";
		} 

		/*if((flag == false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause = whereClause +"  a.MODIFIED_AT_WS_NO=NVL('"+modifiedwsno+"',a.MODIFIED_AT_WS_NO)";
			flag = true;
		} */
		//External accession number From attribute
		if((externalAccNoFrom != null) && (!(externalAccNoFrom.equals(""))))			
		{
			if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
			{
				whereClause = whereClause + " AND a.EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
			}
			else
			{
				whereClause = whereClause + " AND a.EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
			}
		}
		/*if((flag == false) && (externalAccNoFrom != null) && (!externalAccNoFrom.equals("")) )
		{
			if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
			{
				whereClause = whereClause + " a.EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
			}
			else
			{
				whereClause = whereClause + " a.EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
			}
			flag = true;
		}*/

		//External accession number To attribute
		if((externalAccNoTo != null) && (!(externalAccNoTo.equals("")))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))			
		{
			whereClause = whereClause + " AND a.EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";		
		}
	/*	if((flag == false) && (externalAccNoTo != null) && (!externalAccNoTo.equals(""))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))
		{
			whereClause = whereClause + " a.EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";
			flag = true;
		}*/

		//Protocol link id
		if((protocol_link_ID != null) && (!(protocol_link_ID.equals(""))))			
		{
			whereClause = whereClause + " AND a.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
		}
	/*	if((flag == false) && (protocol_link_ID != null) && (!protocol_link_ID.equals("")) )
		{
			whereClause = whereClause + " a.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
			flag = true;
		}*/
		if(whereClause.length() <= 7)
		{
			whereClause = ""; 
			if(orderBy != null && !orderBy.equals(""))
			{
				whereClause = whereClause +" order By " +orderBy;
			}
		}
		else
		{
			whereClause = whereClause +" order By " +orderBy;
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
			 if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
										    

				 if(purge_status.equals(""))
				 {
				   tableNameSuffix = "XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";		  
				 }
				 else
				 {
					tableNameSuffix = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";
				 }
																  
				// request.setAttribute("purge_status","Y");	   			   			  
			 }	

		  
		request.setAttribute("qry_id","VIEWXHINTERACTIVE");				    
		request.setAttribute("tableNameSuffix",tableNameSuffix);				 		   
		request.setAttribute("whereClause",whereClause);   
		request.setAttribute("maxRec","1"); 
		XHViewInteractiveControllerElementBean	xhBean =
		XHViewInteractiveControllerElementBean.getBean(XHViewInteractiveControllerElementBean.strBeanName,request,session);
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
		 if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
										    

				 if(purge_status.equals(""))
				 {
				   tableNameSuffix = "XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";		  
				 }
				 else
				 {
					tableNameSuffix = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";
				 }
																  
				// request.setAttribute("purge_status","Y");	   			   			  
			 }	

			 
		request.setAttribute("qry_id","VIEWXHINTERACTIVE");				    
		request.setAttribute("tableNameSuffix",tableNameSuffix);				 		   
		request.setAttribute("whereClause",whereClause);   
		request.setAttribute("maxRec","1"); 
		XHViewInteractiveControllerElementBean	xhBean =
		XHViewInteractiveControllerElementBean.getBean(XHViewInteractiveControllerElementBean.strBeanName,request,session);
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
		 	//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);parent.window.close();</script>");
		} 
		else 
		{   
		  for (int j=0; j<arrRow.size();j++)
		 {

  			    arrCol = (ArrayList)arrRow.get(j);
				String applicationID=XHDBAdapter.checkNull(arrCol.get(2)+"");
				String facilityID=XHDBAdapter.checkNull(arrCol.get(3)+"");
				String eventType=XHDBAdapter.checkNull((String)arrCol.get(5));
				String protocol_link_id1=XHDBAdapter.checkNull((String)arrCol.get(30));
				String msgID=XHDBAdapter.checkNull((String)arrCol.get(0));
				String srlNo1="";
				 pat_id=XHDBAdapter.checkNull((String)arrCol.get(6));
                 episode_type=XHDBAdapter.checkNull((String)arrCol.get(8)); 
				String facilityName=XHDBAdapter.checkNull((String)arrCol.get(31));
				String applicationName=XHDBAdapter.checkNull((String)arrCol.get(30));
			    posi=arrCol.get(32)+"";    
				String queryDate = "";
				String Profile_id=XHDBAdapter.checkNull((String)arrCol.get(12));
				String Message_Date = "";
				msgProcessed = false;
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
			  

             if(applicationID!="*A" && msgProcessed==true && authToVwCommErr==true )
			 {
				reviewFlag="true";
			 }
			    
			
			    url1="applicationID="+applicationID+
								"&facilityID="+facilityID+
								"&msgID="+msgID+
								"&facilityName="+facilityName+ 
								"&applicationName="+applicationName+
								"&protocolMode=O"+
								"&srlNo="+srlNo1+
								"&protocol_link_id="+protocol_link_id1+			 				"&even_type="+eventType+"&Profile_id="+Profile_id+"&purge_status="+purge_status+"&sub_module="+sub_module+"&posi="+posi+"&RebuildOP=true&ReplayOP=true&reYN=Y"+"&whereClause="+java.net.URLEncoder.encode(whereClause); 	 
         		 url    ="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?appl_name="+applicationID+"&facility="+facilityID+"&msg_id="+msgID+"&event_type="+eventType+"&purge_status="+purge_status+"&sub_module="+sub_module+"&commMode=O&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";
		  }		

		System.out.println(" ::: ViewInteractiveReviewPage ::: APPLNNAME : "+applnname );
		  
		  if (applnname.equals("ECLAIMS"))
		  	url = "";
		  
           
%>  																			  		    
	<iframe name='f_query_' id='f_query_' src='../../eXH/jsp/ViewEventInteractiveNextPrevious.jsp?<%=url1%>&action_type=Q&pagechange=N' frameborder=0 noresize scrolling='no'style='height:3vh;width:100vw'></iframe>  
		<iframe name='resultsFrame' id='resultsFrame' src='../../eXH/jsp/ViewEventInteractiveExcHeaderRwMain.jsp?<%=url1%>&action_type=Q' scrolling="no" frameborder="0" noresizestyle='height:82vh;width:100vw'></iframe>  
		<iframe name='auditlogFrame' id='auditlogFrame'	 src='<%=url%>' frameborder=1 noresize scrolling='no' style='height:15vh;width:100vw'></iframe> 
<%   
			
	} 																				    
	if(resultsQry!=null)  resultsQry.clear();  												 
	if(arrCol!=null) arrCol.clear(); 																     
	if(arrRow!=null)  arrRow.clear();
}																						    
catch(Exception e1)
{
	System.out.println("Error in calling getconnection method of dooperate method of						   ViewEventsInboundOutboundReview.jsp:"+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>

  




</html>  

