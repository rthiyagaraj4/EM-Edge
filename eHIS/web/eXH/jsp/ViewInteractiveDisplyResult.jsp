<!DOCTYPE html>
<html>
<head>
<script language="JavaScript">
function refresh()
{
	  this.document.forms[0].action='../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp';
	  this.document.forms[0].target='f_query_add_mod';
	  this.document.forms[0].submit();
}
</script>
</head>

<BODY CLASS="MESSAGE"   onLoad="refresh();">
<form name="" id="" method="" action=''  >
<p align="left">

<br>
<br>
	<%
		String  msg_id1,msg_dt1,msg_id2,msg_dt2,msg_status,facility,orderBy,order,reason,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,purge_status;
 			msg_id1=null;
			msg_dt1=null;
			msg_id2=null;
			msg_dt2=null;
			msg_status=null;
			facility=null;
			reason=null;
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
			applnname=null;
			eventtype=null;
			purge_status=null;
			String interface_module = null;
			String sub_module = null;
			String protocol_link_id = null;
			String event_status = null;

			String   result=(String)request.getParameter( "message" );	
				orderBy =request.getParameter("orderBy");
			    order=request.getParameter("order");
		        msg_status=request.getParameter("msg_status");
				facility      =request.getParameter("facility"); 
                msg_id1 =request.getParameter("msg_id1"); 
 	   		    msg_id2 =request.getParameter("msg_id2");  
				msg_dt1 =request.getParameter("msg_dt1"); 
 			    msg_dt2 =request.getParameter("msg_dt2"); 
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
				purge_status=request.getParameter("purge_status");
				interface_module=request.getParameter("interface_module");
				sub_module=request.getParameter("sub_module");
				protocol_link_id=request.getParameter("protocol_link_id");
				event_status = request.getParameter("event_status");
				
	%>

<script language="JavaScript">
  alert('<%=result%>');
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</p>
     <input type='hidden' name='msg_status' id='msg_status' value=<%= msg_status %> >
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='facility' id='facility' value=<%=facility %>>
	<input type='hidden' name='msg_id1' id='msg_id1' value=<%=msg_id1 %>>
	<input type='hidden' name='msg_dt1' id='msg_dt1' value=<%=msg_dt1 %>>
	<input type='hidden' name='msg_id2' id='msg_id2' value=<%=msg_id2 %>>
	<input type='hidden' name='msg_dt2' id='msg_dt2' value=<%=msg_dt2 %>>
	<input type='hidden' name='orderBy' id='orderBy' value=<%=orderBy %>>
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
   <input type='hidden' name='purge_status' id='purge_status' value=<%=purge_status%>>
   <input type='hidden' name='comm_mode' id='comm_mode' value='Outbound'>
   <input type='hidden' name='interface_module' id='interface_module' value=<%=interface_module%>>
   <input type='hidden' name='sub_module' id='sub_module' value=<%=sub_module%>>
   <input type='hidden' name='protocol_link_id' id='protocol_link_id' value=<%=protocol_link_id%>>
   <input type='hidden' name='event_status' id='event_status' value=<%=event_status%>>

</form>
</BODY>
</html>

