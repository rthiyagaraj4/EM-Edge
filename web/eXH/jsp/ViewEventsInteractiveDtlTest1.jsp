<!DOCTYPE html>
<html>
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,java.sql.*,java.net.*,java.util.*,java.lang.String,java.util.ArrayList,eXH.XHDBAdapter,eXH.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>										  
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<style>
	div {float: left}
	/*
	.testSty 																		  
	{ 
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
		width: auto;
		white-space: nowrap;
	}
	*/
	.left_child{
		width:1365px;
		overflow-x:scroll;
	 }
</style>
<% 
		Statement s=null;																			    
		ResultSet r=null;
		String res_txt=null;
		String status=null;
		Properties p = (Properties) session.getValue("jdbc");
		String loggedUser = p.getProperty("login_user");

		String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
		String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
		//String applicationName="";
		//String facilityName="";
		String orderBy;
		String function_id=XHDBAdapter.checkNull(request.getParameter("function_id"));
		String tableNameSuffix= "";
		msg_status=null;
		facility=null;									    
		msg_id1=null;						    							  
		msg_dt1=null;
		msg_id2=null;
		msg_dt2=null;
		order=null; 
		orderBy=null;	
		tabValue=null;
		//statusColor=null;
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
		String externalAccNo = null;
		String purge_status = null;
		String protocol_link_ID = null;
%>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="javascript" src="../../eXH/js/Viewtreeimage.js"></script>

 
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script>
<Script Language='JavaScript'> 
//function funSubmit
function funSubmit()
{
	parent.f_query_add_mod.VIEW_EVENTS.action = '../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp';
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
   document.getElementById('msgId').style.color = "green";
}
//function doChanges
function doChanges() 
{
   this.document.forms[0].action="../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp";
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

	if (obj=="Message_ID")
	{		
		if(order == 'A') obj = "MESSAGE_DATE ASC, "+ obj + ' asc';													     
		if(order == 'D') obj = "MESSAGE_DATE DESC, "+ obj + ' desc';		
	}
	else
	{
		if(order == 'A') obj =  obj + ' asc,'+"MESSAGE_DATE ASC";													     
		if(order == 'D') obj =  obj + ' desc,'+"MESSAGE_DATE DESC";	
	}
	
	var url = '&orderBy=' + obj + '&order=' + order;
	this.document.forms[0].action="../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
	parent.frames[2].document.href='../../eCommon/html/blank.html';							   
}


function  func1(message_id,application_id,  facility_id,request_date,  event_type, patient_id, merged_patient_id, episode_type, encounter_id, accession_num, ext_accession_num,   profile_id,Reason,Process_id,added_at_ws_no)
{

}


 
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  
<body onLoad='funonload()' >
<form name="VIEW_EVENTS" id="VIEW_EVENTS" method="POST" action=''  >
<%
  boolean boolToggle =  true;	
  String strTDClass = "";
  Connection conn = null;
  	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;
	
  try
  {   
	 action_type=request.getParameter("action_type");
  	 msg_status=request.getParameter("msg_status");
	 facility =request.getParameter("facility"); 
     msg_id1 =request.getParameter("msg_id1"); 
 	 msg_id2 =request.getParameter("msg_id2");  
     msg_dt1 =request.getParameter("msg_dt1"); 
 	 msg_dt2 =request.getParameter("msg_dt2"); 				 
	 orderBy =request.getParameter("orderBy");
     order=request.getParameter("order");
     tabValue=request.getParameter("tabValue");
     pat_id=request.getParameter("pat_id");
     merg_pat_id=request.getParameter("merg_pat_id");
     episode_type=request.getParameter("episode_type");
     episode_id=request.getParameter("episode_id");
     visit_id=request.getParameter("visit_id"); 
     action_typ=request.getParameter("action_typ");
	 last_processed_date=request.getParameter("last_processed_date");
	 not_req_rsn=request.getParameter("not_req_rsn");
	 addid=request.getParameter("addid");
	 addeddate=request.getParameter("addeddate");
	 addedwsno=request.getParameter("addedwsno");
	 modfid=request.getParameter("modfid");
	 modifieddate=request.getParameter("modifieddate");
	 modifiedwsno=request.getParameter("modifiedwsno");
	 msg_date=request.getParameter("msg_date");
	 eventtype=request.getParameter("eventtype");
	 applnname=request.getParameter("applnname");
	 interface_module = request.getParameter("interface_module");
	 sub_module = request.getParameter("sub_module");
									 
	 eventStatus= request.getParameter("event_status");												  
	 externalAccNo = request.getParameter("externalAccNo");
	 purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
	 protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
	 pmode=request.getParameter("pmode");	
    whereClause=XHDBAdapter.checkNull(request.getParameter("wherecaluse"));
	
	
try
{
	conn = ConnectionManager.getConnection(request);
}
catch(Exception e)
{
	System.out.println("Errors in Connection "+e); 
}
  String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE LOGIN_NAME='"+loggedUser+"'"; 
	
	ResultSet authRS = null;



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

	 tableNameSuffix="";
	 if(pmode!=null)
	 {
	        if(pmode.equalsIgnoreCase("F"))
	        {
               if(locale.equalsIgnoreCase("th"))
				{
			      msg_dt1=com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			      msg_dt2=com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
			      addeddate=com.ehis.util.DateUtils.convertDate(addeddate,"DMY","th","en");
                  modifieddate=com.ehis.util.DateUtils.convertDate(modifieddate,"DMY","th","en");
		          msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");
		         }
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
	 }																					   


	System.out.println(" VIEWXHINTERACTIVE tableNameSuffix ::: "+tableNameSuffix);
	
	if(whereClause.equals("") || whereClause==null)
	{
	 boolean flag =false;	
	 whereClause =" ";																			   
	 //facility																							 
	 if((facility != null ) && (!(facility.equals(""))))			
	 {
	 	 whereClause =whereClause +"And  a.FACILITY_ID = NVL('#facility',a.FACILITY_ID)";
		 flag=true;
 	 } 
	 //application_id
	 if((applnname != null) && (!(applnname.equals(""))))			
	 {
	   	 whereClause =whereClause + " AND a.APPLICATION_ID IN (NVL('#applnname',a.APPLICATION_ID),'*A')";
 	 } 
	
	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
	 	  whereClause =whereClause + " AND a.EVENT_TYPE = NVL('#eventtype',a.EVENT_TYPE)";
 	} 

	if((msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND TO_NUMBER(a.message_id) >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),a.message_id)";
			}
			else															 
			{
				whereClause =whereClause +" AND TO_NUMBER(a.message_id) BETWEEN"+ 	
								"  nvl('"+msg_id1+"',a.message_id) AND nvl('"+msg_id2+"',a.message_id)";
			}
		} 
		
		if((msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND TO_NUMBER(a.message_id) <"+ 	
								"  nvl('"+msg_id2+"',a.message_id)";
			}																					 
		} 

	if((episode_type != null) && (!(episode_type.equals(""))))			
	{
		whereClause =whereClause +"AND a.EPISODE_TYPE= NVL('#episode_type' ,a.EPISODE_TYPE)";
	} 																							  
				
	if((episode_id != null) && (!(episode_id.equals(""))))			
	{
	   whereClause =whereClause +" AND a.EPISODE_ID = NVL('#episode_id',a.EPISODE_ID)";
	} 
		
	if(action_typ != null)
	{
		action_typ=action_typ.trim();	
	}
	 if((action_typ != null) && (!(action_typ.equals(""))))		
	 {
	 	whereClause =whereClause +"  AND a.ACTION_TYPE = NVL('#action_typ',a.ACTION_TYPE) ";
	 } 
			  
	 if( (addid != null) && (!(addid.equals(""))))			
	 {
	 	whereClause =whereClause +" AND (a.ADDED_BY_ID= NVL('#addid',a.ADDED_BY_ID))";
	 } 
	
	 if((addeddate != null) && (!(addeddate.equals(""))))			
	 {
		whereClause =whereClause +" AND  TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy')"+ 	
	                                                   "=NVL('#addeddate',TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy'))";
 	 }

	if((pat_id != null) && (!(pat_id.equals(""))))			
	{
		whereClause = whereClause + " AND  a.patient_id = NVL('#pat_id' ,a.patient_id)";
	}

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

		if((msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(a.MESSAGE_DATE) < = "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 

	if((addedwsno != null) && (!(addedwsno.equals(""))))			
	{
					
		whereClause =whereClause +" AND a.ADDED_AT_WS_NO"+ 			         
					 "=NVL('#addedwsno',a.ADDED_AT_WS_NO)";
	} 

	if((modfid != null) && (!(modfid.equals(""))))			
	{
			whereClause =whereClause +" AND a.MODIFIED_BY_ID=NVL('#modfid',a.MODIFIED_BY_ID)";
				
 	} 

	if((modifieddate != null) && (!(modifieddate.equals(""))))			
	{
			whereClause =whereClause +" AND TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy')"+ 
																	"=NVL('#modifieddate',TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy'))";
				
 	} 

	if((modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
				whereClause =whereClause +" AND a.MODIFIED_AT_WS_NO"+ 
																		"=NVL('#modifiedwsno',a.MODIFIED_AT_WS_NO)";
	
 	}
	
	System.out.println(" ::: orderBy ::: "+orderBy);
	
	if(whereClause.length()<=7)
	{
		if(orderBy.equals("")||orderBy==null)
		{
					whereClause="";
		}
		else
		{
		   whereClause=whereClause+" order  By " +orderBy;	 
		}
	}
			
    else
	{
		 whereClause=whereClause +" order  By " +orderBy;
	}

	if((order != null) && (order.equals("A")))
	{
		order="D";
	}
	else
	{
		order="A";
	}
	}	 
	else
	{
	}

	System.out.println(" VIEWXHINTERACTIVE Where Clause ::: "+whereClause);
	     request.setAttribute(XHQueryRender.strQueryId,"VIEWXHINTERACTIVE");		

	request.setAttribute("tableNameSuffix",tableNameSuffix); 

 
	//System.out.println("whereClause :"+whereClause); 			  
	request.setAttribute(XHQueryRender.col,"33"); 
	request.setAttribute(XHQueryRender.maxRec,"20");
    request.setAttribute(XHQueryRender.whereClause,whereClause);
    HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
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
		    	if(arrRow.size()==0){
			%>	
	<script>
	//	parent.f_query_footer.location.href='../../eCommon/html/blank.html';
		alert(getMessage('XH1021','XH'));
		history.go(-1);
		/*var function_id=parent.document.getElementById("function_id").value;
		parent.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';	   */

	</script>
																			   
		
	<%
				}
else
	{
	%> 

<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
<tr>
	<td colspan="27" class="COLUMNHEADER" align='center'><fmt:message key="eXH.InterActiveInterface.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>	   
<td align="left" class="CAGROUP">
		<A class='linkClass1'   style='cursor:pointer' onClick="editQuery();" TITLE="Edit Query"> 
			EditQuery
		</A>
		<A class='linkClass1'  style='cursor:pointer' onClick="refreshResults('ViewEventsInteractiveDtlTest1');" TITLE="Refresh Events">
			Refresh
		</A>
		</td>
	<!--<td align="left" class="CAGROUP">													  
		<A class='label' style='cursor:pointer' onClick="editQuery();" TITLE="Edit query criteria">
			<fmt:message key="eXH.EditQuery.Label" bundle="${xh_labels}"/>
		</A>
	</td>-->
	<td align="right" class="CAGROUP" > 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
	</td>
</tr>
</table>

	<div id="left_child" class="left_child">
<table id="table1" cellspacing=0 cellpadding=3 border=1 width="100%" style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:block;">	
	
		
	   	<tr>
	    <td class='COLUMNHEADER' nowrap>
			<font color=white>$</font>
		</td>								    
		<!---MESSAGE_ID0----> 
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('Message_ID','<%=order%>');" onclick=''>
		<font color=white><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></font>
		</td>
		<!---APPLICATION_ID3--->
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('APPLICATION_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="Common.Application.label" bundle="${common_labels}"/></font>
		</td>
		 <!----FACILITY_ID4----->
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('FACILITY_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font>
		</td>
			<!-----2----->
		<!--	<td class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ACK_Message_ID','<%=order%>');" onclick=''>
		<font color=white><fmt:message key="eXH.AckMessageid.Label" bundle="${xh_labels}"/></font>
		</td>---->
        <!-----EVENT_TYPE6----->

		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('EVENT_TYPE','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.Event.label" bundle="${common_labels}"/></font>
		</td>
        <!----PGM_ID------>
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('PGM_ID','<%=order%>');" onclick=''>
		<font color=white><fmt:message key="Common.Program.label" bundle="${common_labels}"/></font>
		</td> 
        <!------PROFILE_ID13---->
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('PROFILE_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.Profile.Label" bundle="${xh_labels}"/></font>
		</td>
	    <!------ACCESSION_NUM11---->
        <td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('ACCESSION_NUM','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AccessionNumber.Label" bundle="${xh_labels}"/></font>
		</td>
        <!------EXT_ACCESSION_NUM12---->
		<td class='COLUMNHEADER' nowrap>
		<a id='a001' href="javascript:callForOrderBy('EXT_ACCESSION_NUM','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ExternalAccessionNumber.Label" bundle="${xh_labels}"/></font>
		</td>
		<!------PATIENT_ID7---->
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('PATIENT_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
		</td>
        <!-----ENCOUNTER_ID10----->
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ENCOUNTER_ID','<%=order%>');"onclick='' >
		<font color=white><fmt:message key="eXH.encounterid.Label" bundle="${xh_labels}"/></font>
		</td>
        <!-----ADDED_BY_ID14----->
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ADDED_BY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----ADDED_DATE15----->
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ADDED_DATE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}"/></font>
		</td>
	
		<!----MODIFIED_BY_ID16------>
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('MODIFIED_BY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----MODIFIED_DATE17----->
		<td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('MODIFIED_DATE','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----ADDED_AT_WS_NO18----->
		 <td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ADDED_AT_WS_NO','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----ADDED_FACILITY_ID19-----> 
		
		 <td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('ADDED_FACILITY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.AddedFacility.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----MODIFIED_AT_WS_NO20----->
		<td  nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('MODIFIED_AT_WS_NO','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}"/></font>
		</td>
		<!-----MODIFIED_FACILITY_ID21----->
		 <td nowrap class='COLUMNHEADER'>
		<a id='a001' href="javascript:callForOrderBy('MODIFIED_FACILITY_ID','<%=order%>');"onclick=''>
		<font color=white><fmt:message key="eXH.ModifiedFacilityID.Label" bundle="${xh_labels}"/></font>
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

		/*String s1=((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);
		String s2=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(2);
		String s3=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(5);
		String s5=((String)arrCol.get(2)).equals("null")?"":(String)arrCol.get(3);*/
		
	
		
		 String strResQuery="";

		String statusColor="../../eXH/images/green_square.jpg"; 
	   try
	   {
			s= conn.createStatement();


			
			    if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				

				 if(purge_status.equals(""))
				 {
				   strResQuery = "XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+XHDBAdapter.checkNull((String)arrCol.get(0))+"' ";		  
				 }
				 else
				 {
					strResQuery = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN where MESSAGE_ID='"+XHDBAdapter.checkNull((String)arrCol.get(0))+"'";
				 }
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }	

			 // Modified by Gopinath for ML-MMOH-SCF-2469 on 06/07/2023
			  //String resQuery="select RESPONSE_TEXT from "+strResQuery;
			  String resQuery="select RESPONSE_TEXT,STATUS from "+strResQuery;
			  r = s.executeQuery(resQuery);
			  while(r.next()) 
			 {
				res_txt=XHDBAdapter.checkNull(XHIdentify.returnvalue(r.getClob(1)));
				status=XHDBAdapter.checkNull(r.getString(2));
			 }    
			 
			 if(s!=null)s.close();
			 if(r!=null)r.close();

		}
		catch(Exception e)																				  
		{
			System.out.println("Exceptiong in ViewEventsInteractiveDtlTest1.jsp"+e);
		}

		// Modified by Gopinath for ML-MMOH-SCF-2469 on 06/07/2023
		/*if(res_txt==null||res_txt.equals("")||res_txt.equals(" "))
		{
		statusColor = "../../eXH/images/blue_square.jpg" ;	 
		}

		if(res_txt.length()>0)
		{
		 statusColor = "../../eXH/images/yello_square.jpg" ;	 
		}
		else
			{
		  statusColor = "../../eXH/images/blue_square.jpg" ;	
		}*/
		
		if (!res_txt.equals("") && status.equals("S")) {
			statusColor = "../../eXH/images/green_square.jpg";
		} else if (!res_txt.equals("") && (status.equals("F") || status.equals("W") || status.equals("E"))) {
			statusColor = "../../eXH/images/red_square.jpg";
		} else if (!res_txt.equals("") && status.equals("N")) {
			statusColor = "../../eXH/images/blue_square.jpg";
		} else {
			statusColor = "../../eXH/images/blue_square.jpg";
		}
		// Modification completed for ML-MMOH-SCF-2469
		
%>


<tr id="testID" >
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<img src='<%=statusColor%>' height=10 ></td>
        <!----Messsge Id------> 
		<td nowrap  <%=strTDClass%>  id='mes<%=  j %>'  align="left"  onClick='changeMe("mes"+ <%=  j %>)'  onMouseDown="buildIIMenuList('<%= arrCol.get(10) %>',
											'<%= arrCol.get(11) %>', '<%= arrCol.get(2)%>','<%=XHDBAdapter.checkNull(arrCol.get(30)+"")%>','<%=XHDBAdapter.checkNull(arrCol.get(31)+"")%>',
											'<%= arrCol.get(3) %>','<%= arrCol.get(0) %>',
											'<%= arrCol.get(5) %>',
											'<%= arrCol.get(27) %>',							    
											'<%= interface_module %>',
											'<%= sub_module %>',
											'<%= arrCol.get(29) %>',
											'<%= arrCol.get(22)%>',									'<%=(String)arrCol.get(6)%>','<%=(String)arrCol.get(8)%>','<%=(String)arrCol.get(12)%>','<%= (String)arrCol.get(28) %>','<%= (String)arrCol.get(17) %>','<%=j+""%>');">  
<font size=1 color="blue">&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(0))%>	</font> 
		</td>  
		<!------Applictaion----> 
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(2))%></td>
		<!-----Facility----->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(3))%></td>
	
		<!-----Event type----->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(5))%></td>
		<!----PGM_id------>
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(24))%></td>
		<!---profile------->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(12))%></td>
		<!------ACC.no---->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(10))%></td>
		<!------ex.acc---->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(11))%></td>
		
		<!-- Added by Sethu -->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(6))%></td>

		<!----encounterid------>
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(9))%></td>
		<!-------added--->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(13))%></td>
		<!-----addeddat----->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(14))%></td>
		<!---------->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(15))%></td>
		<!---------->
		<td nowrap  <%=strTDClass%> align="center"><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(16))%></td>
		<!---------->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(17))%></td>


		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(18))%></td>
		<!---------->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(19))%></td>
		<!---------->
		<td nowrap  <%=strTDClass%> align="center" ><font size=1 >&nbsp;<%=XHDBAdapter.checkNull((String)arrCol.get(20))%></td>


	</tr>
	<%}%>																		    
</table>
</div>
 
 
<table width="100%" id="indicatorTable">
	<tr><td></td></tr>
	</table>
		<input type='hidden' name='purge_status' id='purge_status' id='purge_status'  value='<%=purge_status%>'> 
		<input type='hidden' name='msg_status' id='msg_status' value=<%= msg_status %> >
		<input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>
		<input type='hidden' name='temp' id='temp' value='<%=temp%>'>
		<input type='hidden' name='facility' id='facility' value=<%=facility %>>
		<input type='hidden' name='msg_id1' id='msg_id1' value=<%=msg_id1 %>>
		<input type='hidden' name='msg_dt1' id='msg_dt1' value=<%=msg_dt1 %>>
		<input type='hidden' name='msg_id2' id='msg_id2' value=<%=msg_id2 %>>
		<input type='hidden' name='msg_dt2' id='msg_dt2' value=<%=msg_dt2 %>>
		<input type='hidden' name='orderBy' id='orderBy' id='orderBy' value=<%=orderBy %>>
		<input type='hidden' name='order' id='order' value=<%=order %>>
		<input type='hidden' name='pat_id' id='pat_id' value=<%=pat_id %>>
		<input type='hidden' name='merg_pat_id' id='merg_pat_id' value=<%=merg_pat_id %>>		  
		<input type='hidden' name='episode_type' id='episode_type' value=<%=episode_type %>>
		<input type='hidden' name='episode_id' id='episode_id' value=<%=episode_id %>>
		<input type='hidden' name='visit_id' id='visit_id' value=<%=visit_id %>>
		<input type='hidden' name='action_typ' id='action_typ' value=<%=action_typ %>>
		<input type='hidden' name='last_processed_date' id='last_processed_date' value=<%=last_processed_date %>>
		<input type='hidden' name='not_req_rsn' id='not_req_rsn' value=<%=not_req_rsn %>>
		<input type='hidden' name='addid' id='addid' value=<%=addid %>>
		<input type='hidden' name='addeddate' id='addeddate' value=<%=addeddate %>>
		<input type='hidden' name='addedwsno' id='addedwsno' value=<%=addedwsno %>>
		<input type='hidden' name='modfid' id='modfid' value=<%=modfid %>>
		<input type='hidden' name='modifieddate' id='modifieddate' value=<%=modifieddate %>>
		<input type='hidden' name='modifiedwsno' id='modifiedwsno' value=<%=modifiedwsno %>>
		<input type='hidden' name='msg_date' id='msg_date' value=<%=msg_date %>>
		<input type='hidden' name='applnname' id='applnname' value=<%=applnname %>>
		<input type='hidden' name='eventtype' id='eventtype' value=<%=eventtype %>>
			  
		<input type='hidden' name='event_status' id='event_status' value='<%=eventStatus%>'>		 
		<input type='hidden' name='externalAccNo' id='externalAccNo' value='<%=externalAccNo%>'>
		<input type='hidden' name='interface_module' id='interface_module' value='<%=interface_module%>'>
		<input type='hidden' name='tableNameSuffix' id='tableNameSuffix' value='<%=tableNameSuffix%>'>
		<input type='hidden' name='sub_module' id='sub_module' value='<%=sub_module%>'>
		<input type='hidden' name='comm_mode' id='comm_mode' value='Outbound'>
		<input type='hidden' name='rebuildAut' id='rebuildAut' id="rebuildAut" value='<%=authToRebuild%>'>			   
       <input type='hidden' name='replayAut' id='replayAut' id="replayAut" value='<%=authToReplay%>'>
       <input type='hidden' name='commExpAut' id='commExpAut' id="commExpAut" value='<%=authToVwCommErr%>'>
        <input type='hidden' name='audtiAut' id='audtiAut' id="audtiAut" value='<%=authToAudit%>'>
		<input type='hidden' name='viewAuth' id='viewAuth' id="viewAuth" value='<%=viewAuth%>'>
		<input type='hidden' name='protocol_link_id' id='protocol_link_id' id="protocol_link_id" value='<%=protocol_link_ID%>'>
		 <input type='hidden' name='pmode' id='pmode' id="pmode" value='<%=pmode%>'>   
			 <input type='hidden' name='function_id' id='function_id' id="function_id" value='<%=function_id%>'>   		
</form>
<%
		}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
  }catch(Exception e1)
			{
			 out.println("(ViewEventsInteractiveDt1.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
	%>
</html>


