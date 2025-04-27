
function create()
{
}

function query()
{
	var function_id=window.document.getElementById("function_id").value;
	window.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
	window.messageFrame.location.href='../../eCommon/html/blank.html'
}

function apply()
{
}
																							    
function reset()						    
{
	var function_id=window.document.getElementById("function_id").value;
	window.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;	
	window.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

async function callPatientID(obj,target)
{
	var retVal =  new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Patient Search" ;

	var sql="SELECT SHORT_NAME DESCRIPTION, PATIENT_ID CODE FROM  mp_patient_mast WHERE UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PATIENT_ID) LIKE UPPER(?)  ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}
	else
	{
		target.value="";
		obj.value="";
	}
}

// Used to submit to ViewEventsOutboundHeader.jsp in order to change the query criteria.
function editQuery()
{					   


	document.forms[0].action = "../../eXH/jsp/ViewEventsOutboundHeader.jsp?editquery=Y";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].target = "f_query_add_mod";		     					    
	document.forms[0].submit();													     
}

// Used to submit to ViewEventsOutboundHeader.jsp in order to change the query criteria.
function refreshResults(execObjName)
{	
	document.forms[0].action = "../../eXH/jsp/"+ execObjName +".jsp";		
	document.forms[0].submit();
}

//***************************************Change Communication mode options*******************************************
function onChangeCommMode1()
{
	var comm_mode = document.getElementById("comm_mode").value;
	var msgStatus = document.getElementById("tempMsgStatus").value;
	var tempEventStatus = document.getElementById("tempEventStatus").value;
	var moduleID = document.getElementById("sub_module").value;

	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;
	locale = document.getElementById("locale").value;

	var flag = "false";

	document.getElementById("protocol_link_id").value = "";
	document.getElementById("protocol_link_name").value = "";

	if(comm_mode == "outbound")
	{
		document.getElementById("inEventStatusDiv").style.display="none";
		document.getElementById("outEventStatusDiv").style.display="block";		

		clearMsgStsOptions(document.getElementById("msg_status"));
		
		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);		

		if(msgStatus == " ") document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","common")," ",false, true);
		else document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","common")," ",false, false);

		if(msgStatus == "S") document.getElementById("msg_status").options[2] = new Option(getLabel("eXH.Sucessfull.Label","XH"),"S",false, true);
		else document.getElementById("msg_status").options[2] = new Option(getLabel("eXH.Sucessfull.Label","XH"),"S",false, false);

		if(msgStatus == "E") document.getElementById("msg_status").options[3] = new Option(getLabel("eXH.TransmissionError.Label","XH"),"E",false, true);
		else document.getElementById("msg_status").options[3] = new Option(getLabel("eXH.TransmissionError.Label","XH"),"E",false, false);

		if(msgStatus == "A") document.getElementById("msg_status").options[4] = new Option(getLabel("Common.Accepted.label","common"),"A",false, true);	
		else document.getElementById("msg_status").options[4] = new Option(getLabel("Common.Accepted.label","common"),"A",false, false);	

		if(msgStatus == "R") document.getElementById("msg_status").options[5] = new Option(getLabel("Common.Rejected.label","common"),"R",false, true);
		else document.getElementById("msg_status").options[5] = new Option(getLabel("Common.Rejected.label","common"),"R",false, false);

	//	if(msgStatus == "F") document.getElementById("msg_status").options[4] = new Option("Failed","F",false, true);
	//	else document.getElementById("msg_status").options[4] = new Option("Failed","F",false, false);		

		

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'O' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";

		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));
		
	//	document.getElementById("inMsgStatusDiv").style.display="none";
	//	document.getElementById("outMsgStatusDiv").style.display="block";	  
		
	}
	if(comm_mode == "inbound")
	{
		document.getElementById("outEventStatusDiv").style.display="none";
		document.getElementById("inEventStatusDiv").style.display="block";

		clearMsgStsOptions(document.getElementById("msg_status"));

		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);

	//	if(msgStatus == " ") document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","COMMON")," ",false, true);
	//	else document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","COMMON")," ",false, false);
		if(msgStatus == "S") document.getElementById("msg_status").options[1] = new Option("Received","S",false, true);
		else document.getElementById("msg_status").options[1] = new Option("Received ","S",false, false);
		if(msgStatus == "R") document.getElementById("msg_status").options[2] = new Option(getLabel("Common.Rejected.label","common"),"R",false, true);
		else document.getElementById("msg_status").options[2] = new Option(getLabel("Common.Rejected.label","common"),"R",false, false);
		if(msgStatus == "L") document.getElementById("msg_status").options[3] = new Option("Loaded Successfully","L",false, true);
		else document.getElementById("msg_status").options[3] = new Option("Loaded Successfully","L",false, false);
		if(msgStatus == "E") document.getElementById("msg_status").options[4] = new Option("Error In loading","E",false, true);
		else document.getElementById("msg_status").options[4] = new Option("Error In loading","E",false, false);		

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'I' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";

		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));

	//	document.getElementById("outMsgStatusDiv").style.display="none";
	//	document.getElementById("inMsgStatusDiv").style.display="block";
	}
	if(comm_mode == "InterActive")
	{
		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);
		document.getElementById("msg_status").disabled=true;		    
		document.getElementById("protocol_link_name").disabled=true; 
		document.getElementById("protocol_link_id").disabled=true;  
		document.forms[0].protocolIDSearch.disabled=true; 
		document.getElementById("event_status").disabled=true;  

	}					
	if(tempEventStatus != "" && tempEventStatus != " ")
	{	
		document.getElementById("eventtype").value = tempEventStatus;
	}
}
//

function initSetup()
{
	var comm_mode = document.getElementById("comm_mode").value;
	var msgStatus = document.getElementById("tempMsgStatus").value;
	var tempEventStatus = document.getElementById("tempEventStatus").value;
	var functionID = document.getElementById("function_id").value;

	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;
	locale = document.getElementById("locale").value;
	moduleID = document.getElementById("sub_module").value;


	var flag = "false";								 

	if(comm_mode == "outbound")
	{
		document.getElementById("inEventStatusDiv").style.display="none";
		document.getElementById("outEventStatusDiv").style.display="block";		

		clearMsgStsOptions(document.getElementById("msg_status"));
		
		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);

		if(msgStatus == " ") document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","common")," ",false, true);
		else document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","common")," ",false, false);

		if(msgStatus == "S") document.getElementById("msg_status").options[2] = new Option(getLabel("eXH.Sucessfull.Label","XH"),"S",false, true);
		else document.getElementById("msg_status").options[2] = new Option(getLabel("eXH.Sucessfull.Label","XH"),"S",false, false);

		if(msgStatus == "E") document.getElementById("msg_status").options[3] = new Option(getLabel("eXH.TransmissionError.Label","XH"),"E",false, true);
		else document.getElementById("msg_status").options[3] = new Option(getLabel("eXH.TransmissionError.Label","XH"),"E",false, false);

		if(msgStatus == "A") document.getElementById("msg_status").options[4] = new Option(getLabel("Common.Accepted.label","common"),"A",false, true);	
		else document.getElementById("msg_status").options[4] = new Option(getLabel("Common.Accepted.label","common"),"A",false, false);	

		if(msgStatus == "R") document.getElementById("msg_status").options[5] = new Option(getLabel("Common.Rejected.label","common"),"R",false, true);
		else document.getElementById("msg_status").options[5] = new Option(getLabel("Common.Rejected.label","common"),"R",false, false);						

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'O' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
		
		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));
		
	//	document.getElementById("inMsgStatusDiv").style.display="none";
	//	document.getElementById("outMsgStatusDiv").style.display="block";
		
	}
	if(comm_mode == "inbound")
	{
		document.getElementById("outEventStatusDiv").style.display="none";
		document.getElementById("inEventStatusDiv").style.display="block";

		clearMsgStsOptions(document.getElementById("msg_status"));

		document.getElementById("msg_status").options[0] = new Option("All","",false, false);

	//	if(msgStatus == " ") document.getElementById("msg_status").options[1] = new Option("Pending"," ",false, true);
	//	else document.getElementById("msg_status").options[1] = new Option("Pending"," ",false, false);
		if(msgStatus == "S") document.getElementById("msg_status").options[1] = new Option("Received","S",false, true);
		else document.getElementById("msg_status").options[1] = new Option("Received","S",false, false);
		if(msgStatus == "R") document.getElementById("msg_status").options[2] = new Option(getLabel("Common.Rejected.label","common"),"R",false, true);
		else document.getElementById("msg_status").options[2] = new Option(getLabel("Common.Rejected.label","common"),"R",false, false);
		if(msgStatus == "L") document.getElementById("msg_status").options[3] = new Option("Loaded Successfully","L",false, true);
		else document.getElementById("msg_status").options[3] = new Option("Loaded Successfully","L",false, false);
		if(msgStatus == "E") document.getElementById("msg_status").options[4] = new Option("Error In loading","E",false, true);
		else document.getElementById("msg_status").options[4] = new Option("Error In loading","E",false, false);
		

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'I' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";

		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));

	//	document.getElementById("outMsgStatusDiv").style.display="none";
	//	document.getElementById("inMsgStatusDiv").style.display="block";
	}

	if(comm_mode == "InterActive")
	{
		locale = document.getElementById("locale").value;
		moduleID = document.getElementById("sub_module").value;		


		var functionID = document.getElementById("function_id").value;	  
		applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;	
			var commMode = document.getElementById("comm_mode").value;
	if(commMode == "inbound") commMode = "I";
	else commMode = "O";
		/*document.getElementById("outEventStatusDiv").style.display="none";
		document.getElementById("inEventStatusDiv").style.display="block";

		clearMsgStsOptions(document.getElementById("msg_status"));

		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);
	  	if(msgStatus == " ") document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","COMMON")," ",false, true);
		else document.getElementById("msg_status").options[1] = new Option(getLabel("Common.Pending.label","COMMON")," ",false, false);
		if(msgStatus == "L") document.getElementById("msg_status").options[3] = new Option(getLabel("Common.Accepted.label","common"),"L",false, true);
		else document.getElementById("msg_status").options[2] = new Option(getLabel("Common.Accepted.label","common"),"L",false, false);
		if(msgStatus == "R") document.getElementById("msg_status").options[5] = new Option(getLabel("Common.Rejected.label","common"),"R",false, true);
		else document.getElementById("msg_status").options[3] = new Option(getLabel("Common.Rejected.label","common"),"R",false, false);*/

		document.getElementById("msg_status").options[0] = new Option(getLabel("Common.all.label","common"),"",false, false);
		document.getElementById("msg_status").disabled=true;		    
		document.getElementById("protocol_link_name").disabled=true; 
		document.getElementById("protocol_link_id").disabled=true;  
		document.forms[0].protocolIDSearch.disabled=true; 
		  document.getElementById("event_status").disabled=true;  
		  queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = '"+commMode+"' OR me.communication_type = '*') AND M.APPLICATION_ID = '"+applicationID+"' AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
				" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
			  	eval(sendRequest(queryEventType,'eventtype','All',"both")); 
		  if(functionID =='XH_J_ADMINISTER_INTRC_EVENTS'){

		queryEventType	= "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me	WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type ='"+commMode+"' OR me.communication_type = '*')	  AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'";
		eval(sendRequest(queryEventType,'eventtype','All',"both"));  

	}
														    
	}					 

	if(tempEventStatus != "" && tempEventStatus != " ")
	{	
		document.getElementById("eventtype").value = tempEventStatus;
	}

	if(functionID == 'XI_J_ADMINISTER_EVENTS')
	{
		document.getElementById("sub_module").value = "XI";
	}
	else if(functionID == 'XB_J_ADMINISTER_EVENTS')
	{
		document.getElementById("sub_module").value = "XB";
	}
	else if(functionID == 'XM_J_ADMINISTER_EVENTS')
	{
		document.getElementById("sub_module").value = "XM";
	}
	else if(functionID == 'XS_J_ADMINISTER_EVENTS')
	{
		document.getElementById("sub_module").value = "XS";
	}
	else if(functionID == 'XF_J_ADMINISTER_EVENTS')
	{
		document.getElementById("sub_module").value = "XF";
	}

	document.getElementById("search").focus();

}

function getInboundDetails(extAccNo)
{	
	sub_module = document.forms[0].sub_module.value;
	purge_status = document.forms[0].purge_status.value;
	function_id = document.forms[0].function_id.value;
	if(extAccNo == null || extAccNo == "")
	{
		alert(getMessage('XH1021','XH'));
		return;
	}
	else
	{			
		url = '../../eXH/jsp/ViewEventsInboundDtlTest1.jsp?externalAccNoFrom='+extAccNo+'&externalAccNoTo='+extAccNo+'&sub_module='+sub_module
				+'&purge_status='+purge_status+'&function_id='+function_id;		
		location.href = url;
	}	
}

function getOutboundDetails(extAccNo)
{	
	
	purge_status=document.forms[0].purge_status.value;
	sub_module=document.forms[0].sub_module.value;
	function_id = document.forms[0].function_id.value;
	if(extAccNo == null || extAccNo == "")
	{
		alert(getMessage('XH1021','XH'));
		return;
	}																				 
	else
	{		
		url = 'externalAccNoFrom='+extAccNo+'&externalAccNoTo='+extAccNo+'&sub_module='+sub_module
			+'&purge_status='+purge_status+'&function_id='+function_id;
		
	//	location.href = url;
	//	this.document.VIEW_EVENTS.target = 'f_query_add_mod';		
		document.forms[0].action="../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp?"+url;
		document.forms[0].submit();	 
	}	
}

function popupMenu()
{

}

function clearMsgStsOptions(obj)
{
//	var list_obj	=document.forms[0].sub_module;
	var len =obj.options.length;
	for(var i=0;i<len;i++) 
	{
		obj.remove("msg_status");
	}
}

function buildOBMenuList(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
		msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,msgProcessed,msgStatus,
		eventStatus,msgDate,patID,episodeID,episodeType,visitID,eventName,position)
{
	var messageLabel		= getLabel("Common.Message.label","common");
	var messageViewerLabel	= getLabel("eXH.MessageViewer.Label","xh");
	var auditLabel			= getLabel("Common.AuditLog.label","common");
	var riviewLabel			= getLabel("eXH.MessageReview.Label","xh");
	var rebuildLabel		= getLabel("eXH.Rebuild.Label","xh");
	var replayLabel			= getLabel("eXH.Replay.Label","xh");

	var audtiAut	= document.getElementById("audtiAut").value;
	var rebuildAut	= document.getElementById("rebuildAut").value;
	var replayAut	= document.getElementById("replayAut").value;	
	var commExpAut	= document.getElementById("commExpAut").value;
	var viewAut = document.getElementById("viewAuth").value;

	var flag = false;

	var queueType	= document.getElementById("purge_status").value;
	if(queueType == "") queueType = "online";

	var linkset	= new Array();
	var disabled = "";
	
	if(applicationId == "*A" || msgProcessed == false) 
	{
		var viewMsgLink = '<a href="#" disabled="disable" style="color: gray;">'+messageLabel+'</a>';					

		var msgViewerLink = '<a href="#" disabled="disable" style="color: gray;">'+messageViewerLabel+'</a>';					
	}
	else if(msgProcessed == true)
	{
		var viewMsgLink = '<a href="#" onClick='+'\''+'viewMessage("'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+
					msgId+'","'+eventType+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","Outbound","'+eventName+'","","'+queueType+'");'+'\''+'>'+messageLabel+'</a>';					

		var msgViewerLink = '<a href="#" onClick='+'\''+'messageViewer("'+applicationId+'","'+facilityId+'","'+
					msgId+'","'+eventType+'","'+protocol_link_id+'","Outbound","'+sub_module+'","","'+purge_status+'","'+applicationName+'","'+facilityName+'","'+position+'");'+'\''+'>'+messageViewerLabel+'</a>';					
	}

//	linkset[0] = viewMsgLink;

	auditDetailStr = '<a href="#" onClick='+'\''+'goToAuditLog("'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+eventType+'","'+eventName+'","'+purge_status+'","O","'+sub_module+'");'+'\''+'>'+auditLabel+'</a>';
	commExceptionsStr = '<a href="#" onClick='+'\''+'goToMsgReview("'+applicationId+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+applicationName+'","O","'+sub_module+'","","'+protocol_link_id+'","'+purge_status+'","'+position+'");'+'\''+'>'+riviewLabel+'</a>';

	if(commExpAut == "true" && applicationId != "*A" && msgProcessed == true) 
	{
		linkset[0] = commExceptionsStr;
		flag = true;
	}
	if(viewAut == "true" && flag == true)	linkset[0] += msgViewerLink;
	else if(viewAut == "true") 
	{
		linkset[0] = msgViewerLink;
		flag = true;
	}

	if(audtiAut == "true") 
	{
		var moduleID = document.getElementById("sub_module").value;
		var tabName = "APPL_MSG_AUDIT_VW";
		if(purge_status == "OFFLINE") tabName = "OFFLINE_" + tabName;
		else if(purge_status == "PURGE") tabName = "PURGE_" + tabName;

		tabName = moduleID + "_" + tabName;

		var auditExistsQry = "SELECT 1 FROM "+tabName+" WHERE APPLICATION_ID='"+applicationId+"'"+
								" AND MESSAGE_ID='"+msgId+"' AND FACILITY_ID='"+facilityId+"'"+
								" AND EVENT_TYPE='"+eventType+"'";
	
		var val = parent.f_query_add_mod.getValue(auditExistsQry);
		val = val.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

		if(val == "Y" && flag == true)
		{
			linkset[0] += auditDetailStr;
		}		
		else if(val == "Y")
		{
			linkset[0] = auditDetailStr;
			flag = true;
		}
	}	
	

	if(msgProcessed == true) 
	{	
		if(replayAut == "true" && msgStatus != "" && msgStatus != " ") // checking whether the user is authenticated for replay
		{		
			var replayLink = '<a href="#" onClick='+'\''+'processMsg("'+accessionNumber+'","'+externalAccessionNumber+'","'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+
				'","'+msgId+'","'+eventType+'","'+reason+'","'+purge_status+'","'+interface_module+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","'+msgStatus+'","'+eventStatus+'","'+msgDate+
				'","'+patID+'","'+episodeID+'","'+episodeType+'","'+visitID+'","replay","'+queueType+'");'+'\''+'>'+replayLabel+'</a>';		

			if(flag == true)	
			{
				linkset[0] += replayLink;
			}
			else	
			{
				linkset[0] = replayLink;
				flag = true;
			}
		}
		if(rebuildAut == "true") // checking whether the user is authenticated for rebuild
		{
			var rebuildLink = '<a href="#" onClick='+'\''+'processMsg("'+accessionNumber+'","'+externalAccessionNumber+'","'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+
				'","'+msgId+'","'+eventType+'","'+reason+'","'+purge_status+'","'+interface_module+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","'+msgStatus+'","'+eventStatus+'","'+msgDate+
				'","'+patID+'","'+episodeID+'","'+episodeType+'","'+visitID+'","rebuild","'+queueType+'");'+'\''+'>'+rebuildLabel+'</a>';		

			if(flag == true)
			{
				linkset[0] += rebuildLink;
			}
			else
			{
				flag = true;
				linkset[0] = rebuildLink;
			}
		}		
	}
	
	if(eventStatus == "null") 
	{
		if(rebuildAut == "true") // checking whether the user is authenticated for rebuild
		{
			var rebuildLink = '<a href="#" onClick='+'\''+'processMsg("'+accessionNumber+'","'+externalAccessionNumber+'","'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+
				'","'+msgId+'","'+eventType+'","'+reason+'","'+purge_status+'","'+interface_module+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","'+msgStatus+'","'+eventStatus+'","'+msgDate+
				'","'+patID+'","'+episodeID+'","'+episodeType+'","'+visitID+'","rebuild","'+queueType+'");'+'\''+'>Build</a>';		

			if(flag == true)
			{
				linkset[0] += rebuildLink;
			}
			else
			{
				flag = true;
				linkset[0] = rebuildLink;
			}
		}	
	}
	
	if(linkset.length > 0)
	{
		dispMenu(linkset); // function call to display the menu with the linkset array elements as list items.	
	}
	else
	{
		alert(getMessage("XH0075",'XH'));
	}
}

function buildMenuList(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
		msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,srlNo,msgStatus,eventName,position)
{		
	var messageLabel = getLabel("Common.Message.label","common");;
	var auditLabel = getLabel("Common.AuditLog.label","common");
	var reviewLabel = getLabel("eXH.MessageReview.Label","xh");
	var reloadLabel = getLabel("eXH.Reload.Label","xh");
	var messageViewerLabel = getLabel("eXH.MessageViewer.Label","xh");

	var audtiAut = document.getElementById("audtiAut").value;
	var reloadAut = document.getElementById("reloadAut").value;					    
	var commExpAut = document.getElementById("commExpAut").value;
	var viewAut = document.getElementById("viewAuth").value;

	var flag = false;
	
	var queueType = document.getElementById("purge_status").value;
	if(queueType == "") queueType = "online";

	var linkset=new Array();

//	var viewMsgLink = '<a href="#" onClick='+'\''+'viewMessage("'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+
//				msgId+'","'+eventType+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","Inbound","'+eventName+'","'+srlNo+'","'+queueType+'");'+'\''+'>'+messageLabel+'</a>';					
		
	var msgViewerLink = '<a href="#" onClick='+'\''+'messageViewer("'+applicationId+'","'+facilityId+'","'+
					msgId+'","'+eventType+'","'+protocol_link_id+'","Inbound","'+sub_module+'","'+srlNo+'","'+purge_status+'","'+applicationName+'","'+facilityName+'","'+position+'");'+'\''+'>'+messageViewerLabel+'</a>';						

//	linkset[0] = viewMsgLink;

	auditDetailStr = '<a href="#" onClick='+'\''+'goToAuditLog("'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+eventType+'","'+eventName+'","'+purge_status+'","I","'+sub_module+'");'+'\''+'>'+auditLabel+'</a>';
	commExceptionsStr = '<a href="#" onClick='+'\''+'goToMsgReview("'+applicationId+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+applicationName+'","I","'+sub_module+'","'+srlNo+'","'+protocol_link_id+'","'+purge_status+'","'+position+'");'+'\''+'>'+reviewLabel+'</a>';	

	if(commExpAut == "true") 
	{
		linkset[0] = commExceptionsStr;
		flag = true;
	}
	if(viewAut == "true" && flag == true)	
	{
		linkset[0] += msgViewerLink;
	}
	else if(viewAut == "true")
	{
		linkset[0] = msgViewerLink;
		flag = true;
	}

	if(audtiAut == "true") 
	{
		var moduleID = document.getElementById("sub_module").value;

		var tabName = "APPL_MSG_AUDIT_VW";
		if(purge_status == "OFFLINE") tabName = "OFFLINE_" + tabName;
		else if(purge_status == "PURGE") tabName = "PURGE_" + tabName;

		tabName = moduleID + "_" + tabName;

		var auditExistsQry = "SELECT 1 FROM "+tabName+" WHERE APPLICATION_ID='"+applicationId+"'"+
								" AND MESSAGE_ID='"+msgId+"' AND FACILITY_ID='"+facilityId+"'"+
								" AND EVENT_TYPE='"+eventType+"'";
	
		var val = parent.f_query_add_mod.getValue(auditExistsQry);	
		val = val.replace(/^\s\s*/, '').replace(/\s\s*$/, ''); // performing trim for the value received.

		if(val == "Y" && flag == true)
		{
			linkset[0]+= auditDetailStr;
		}
		else if(val == "Y")
		{
			linkset[0] = auditDetailStr;
			flag = true;
		}
	}
	
	if(msgStatus != "S" && reloadAut == "true") // indicates msg status as null, so reload is not reuired again.
	{			
		var pro = '<a href="#" onClick='+'\''+'process("'+accessionNumber+'","'+externalAccessionNumber+'","'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+
			msgId+'","'+eventType+'","'+reason+'","'+purge_status+'","'+interface_module+'","'+sub_module+'","'+protocol_link_id+'","'+Rule+'","'+srlNo+'","'+msgStatus+'","reload");'+'\''+'>'+reloadLabel+'</a>';		

		if(flag == true) 
		{
			linkset[0] += pro;
		}
		else
		{
			linkset[0] = pro;
			flag = true;
		}
	}	
	 
	if(linkset.length > 0)
	{
		dispMenu(linkset); // function call to display the menu with the linkset array elements as list items.	
	}
	else
	{
		alert(getMessage("XH0075"));
	}
}

function process(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
		msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,srlNo,msgStatus,buttonInvoked)
{	
	var url='&accessionNumber='+accessionNumber+
				'&externalAccessNumber='+externalAccessionNumber+
				'&applicationId='+applicationId+
				'&applicationName='+applicationName+
				'&facilityId='+facilityId+
				'&facilityName='+facilityName+
				'&messageId='+msgId+
				'&eventType='+eventType+
				'&reason='+reason+
				'&purge_status='+purge_status+
				'&interface_module='+interface_module+
				'&sub_module='+sub_module+
				'&protocol_link_id='+protocol_link_id+
				'&mode=Q'+
				'&srlNo='+srlNo+
				'&buttonInvoked='+buttonInvoked;

	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
	
}

//**********************************************************************************************/
async function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName,purge_status,commMode,moduleID)
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

	url = "applicationId="+applicationId+"&applicationName="+applicationName+"&facilityId="+facilityId+
			"&facilityName="+facilityName+"&msgId="+msgId+"&eventType="+eventType+"&eventName="+eventName+"&purge_status="+purge_status+"&commMode="+commMode
			+"&moduleID="+moduleID;

	var dialogHeight = "650px";
	var dialogWidth  = "1400px";
	var dialogTop    = "100";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no;" ;

	await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp?"+url,arguments,features);  
}

//**********************************************************************************************/
/*function goToCommunicationError(applicaionID,facilityId,facilityName,msgID)
{
	var arguments  =new Array();
	arguments[0]="L";
	arguments[1]=facilityId;
	arguments[2]=facilityName;
	arguments[3]="XHTCMMSG";
	arguments[4]=applicaionID;
	arguments[5]=msgID;
	appKey="Application-"+applicaionID+"|Facility-"+facilityId+"|Message Id-"+msgID;
	arguments[6]=appKey;

	var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	
	window.showModalDialog("../../eXH/jsp/ViewServerProcessErrorMain.jsp",arguments,features);  
}
*/

async function goToMsgReview(applicaionID,facilityId,facilityName,msgID,applicationName,protocolMode,sub_module,srlNo,protocol_link_id,purge_status,position)
{
/*	var url = "../../eXH/jsp/ViewEventExceptionsMain.jsp?"+
				"applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+
				"&sub_module="+sub_module+
				"&srlNo="+srlNo+
				"&protocol_link_id="+protocol_link_id+
				"&purge_status="+purge_status;	
*/
	
	var url = "../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?"+
				"applicationID="+applicaionID+
				"&facilityID="+facilityId+
				"&msgID="+msgID+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&protocolMode="+protocolMode+
				"&sub_module="+sub_module+
				"&srlNo="+srlNo+				
				"&purge_status="+purge_status+
				"&posi="+position+"&action_type=&protocolMode="+protocolMode+
				"&applnname="+document.getElementById("applnname").value+
				"&facility="+document.getElementById("facility").value+
				"&msg_id1="+document.getElementById("msg_id1").value+
				"&msg_id2="+document.getElementById("msg_id2").value+
				"&eventtype="+document.getElementById("eventtype").value+
				"&protocol_link_id="+document.getElementById("protocol_link_id").value+
				"&msg_dt1="+document.getElementById("msg_dt1").value+
				"&msg_dt2="+document.getElementById("msg_dt2").value+
				"&posi=1&comm_mode="+document.getElementById("comm_mode").value+
				"&event_status="+document.getElementById("event_status").value+
				"&msg_status="+document.getElementById("msg_status").value+
				"&orderBy="+document.getElementById("orderBy").value+"&order=A&tabValue=";	

	var arguments = new Array();
	var dialogHeight = "650px";
	var dialogWidth  = "1400px";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no" ;
	
	await window.showModalDialog(url,arguments,features); 
}

function processMsg(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,
		msgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,msgStatus,eventStatus,
		msgDate,patID,episodeID,episodeType,visitID,buttonInvoked,queueType)
{		
	var url='&accessionNumber='+accessionNumber+
				'&externalAccessNumber='+externalAccessionNumber+
				'&applicationId='+applicationId+
				'&applicationName='+applicationName+
				'&facilityId='+facilityId+
				'&facilityName='+facilityName+
				'&messageId='+msgId+
				'&eventType='+eventType+
				'&reason='+reason+
				'&purge_status='+purge_status+
				'&interface_module='+interface_module+
				'&sub_module='+sub_module+
				'&protocol_link_id='+protocol_link_id+
				'&mode=Q'+
				'&msg_status='+msgStatus+
				'&event_status='+eventStatus+
				'&msgDate='+msgDate+
				'&pat_id='+patID+
				'&episode_id='+episodeID+
				'&episode_type='+episodeType+
				'&visit_id='+visitID+
				'&buttonInvoked='+buttonInvoked+
				'&purge_status='+queueType;
	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
	
}

async function viewMessage(applicationId,applicationName,facilityId,facilityName,msgId,eventType,sub_module,
					protocol_link_id,Rule,commMode,eventName,srlNo,queueType)
{
	var url='../../eXH/jsp/ReviewApplMessage_Menu.jsp?'+
				'application_id='+applicationId+
				'&application_name='+applicationName+
				'&facility_id='+facilityId+
				'&facility_name='+facilityName+
				'&msgid='+msgId+
				'&event_type='+eventType+
				'&sub_module='+sub_module+
				'&protocol_link_id='+protocol_link_id+
				'&eventName='+eventName+
				'&srlNo='+srlNo+
				'&queueType='+queueType;	

	if(commMode == "Outbound") 
	{
		url = url+'&Rule='+Rule+'&protocol_mode=O';
	}
	else 
	{
		url = url+'&mode=Q&protocol_mode=I';
	}	

	var dialogHeight = "650px";
	var dialogWidth  = "1400px";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no;" ;

	var arguments  = new Array();

	await window.showModalDialog(url,arguments,features);
}

async function messageViewer(applicationId,facilityId,msgId,eventType,protocol_link_id,protocolMode,sub_module,srlNo,purge_status,applicationName,facilityName,position)
{		
	var url = "../../eXH/jsp/ViewSegmentsTreeMain.jsp?"+
			"applicationID="+applicationId+
			"&facilityID="+facilityId+ 
			"&msgID="+msgId+
			"&facilityName="+facilityName+
			"&applicationName="+applicationName+ 
			"&protocolMode="+protocolMode+ 
			"&sub_module="+sub_module+
			"&srlNo="+srlNo+
			"&protocol_link_id="+protocol_link_id+
			"&purge_status="+purge_status+'&even_type='+eventType+'&posi='+position;

	if(protocolMode == "Outbound") 
	{
		url = url+'&protocol_mode=O';
	}
	else 
	{
		url = url+'&protocol_mode=I';
	}

	var dialogHeight = "650px";
	var dialogWidth  = "1400px";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no;" ;

	var arguments  =new Array();

    await window.showModalDialog(url,arguments,features);
}

function changeCursor(obj) {
	obj.style.cursor = "hand";
}
