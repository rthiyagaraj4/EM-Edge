  
function submitForm()
{


	//parent.f_query_add_mod_detail.document.location.href='../../eXH/html/Left2.html';
parent.f_query_add_mod_detail.document.location.href='../../eXH/jsp/MessageViewer.jsp?Message_text='+document.forms[0].Message_text.value+'&Message_Syn='+document.forms[0].Message_Syn.value+'&Standard_code='+document.forms[0].Standard_Symbols.value+'&Standard_type='+document.forms[0].Standard_type.value;
	parent.f_query_add_mod_detailstext.document.location.href='../../eXH/jsp/ViewTreeText.jsp?Message_text='+this.document.forms[0].Message_text.value+'&Message_Syn='+this.document.forms[0].Message_Syn.value+'&Standard_code='+this.document.forms[0].Standard_Symbols.value+'&Standard_type='+this.document.forms[0].Standard_type.value;
	 
}
function refreshResults(execObjName)
{	
	document.forms[0].action = "../../eXH/jsp/"+ execObjName +".jsp";		
	document.forms[0].submit();
}
function buildIIMenuList(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityName,facilityId,msgId,eventType,reason,interface_module,sub_module,protocol_link_id,msgDate,patID,episodeType,profileid,processid,addedwsno,position )
{	

	var messageLabel		= getLabel("Common.Message.label","common");
	var messageViewerLabel	= getLabel("eXH.MessageViewer.Label","xh");
	var auditLabel			= getLabel("Common.AuditLog.label","common");
	var commLabel			= getLabel("eXH.Exceptions.Label","xh"); 
	var replayLabel			= getLabel("eXH.Replay.Label","xh");
    var reviewLabel         = getLabel("eXH.MessageReview.Label","xh");
	var audtiAut	= document.getElementById("audtiAut").value;
	var rebuildAut	= document.getElementById("rebuildAut").value;
	var replayAut	= document.getElementById("replayAut").value;
	var commExpAut	= document.getElementById("commExpAut").value;										    
	var viewAut     = document.getElementById("viewAuth").value;
	var purge_status=document.getElementById("purge_status").value
	
 
	var linkset	= new Array(); 
	var disabled = "";

	if(applicationId == "*A")  
	{
		var viewMsgLink = '<a href="#" disabled="disable">'+messageLabel+'</a>';					

		var msgViewerLink = '<a href="#" disabled="disable">'+messageViewerLabel+'</a>';					
	}
	else
	{
		//goToMessage(MessageId,applicationId,facilityId,Profileid)
		var viewMsgLink = '<a href="#" onClick='+'\''+'goToMessage("'+msgId+'","'+applicationId+'","'+facilityId+'","'+profileid+'","'+purge_status+'","'+sub_module+'");'+'\''+'>'+messageViewerLabel+'</a>';					

		
	} 														    			  

	linkset[0] = viewMsgLink;												 
	

			
		if(rebuildAut == "true") // checking whether the user is authenticated for rebuild
		{
		//	var rebuildLink = '<a href="#" onClick='+'\''+'Process("'+facilityId+'","'+applicationId+'","'+msgId+'","'+processid+'","'+eventType+'","'+addedwsno+'","rebuild");'+'\''+'>'+rebuildLabel+'</a>';		

		//	linkset[0]+= rebuildLink;
		}
		if(replayAut == "true"  ) // checking whether the user is authenticated for replay
		{
			var replayLink = '<a href="#" onClick='+'\''+'Process("'+facilityId+'","'+applicationId+'","'+msgId+'","'+processid+'","'+eventType+'","'+addedwsno+'","reload","'+purge_status+'","'+sub_module+'");'+'\''+'>'+replayLabel+'</a>';		

			linkset[0]+= replayLink;
		}

	auditDetailStr = '<a href="#" onClick='+'\''+'goToAuditLog("'+applicationId+'","'+applicationName+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+eventType+'","'+purge_status+'","'+sub_module+'");'+'\''+'>'+auditLabel+'</a>';

	
		commExceptionsStr = '<a href="#" onClick='+'\''+'goToCommunicationError("'+facilityId+'","'+facilityName+'","'+purge_status+'","'+sub_module+'");'+'\''+'>'+commLabel+'</a>';
	
	
		
		commExceptionsStr = '<a href="#" onClick='+'\''+'goToMsgReview("'+applicationId+'","'+facilityId+'","'+facilityName+'","'+msgId+'","'+applicationName+'","'+protocol_link_id+'","'+position+'","'+purge_status+'","'+sub_module+'");'+'\''+'>'+reviewLabel+'</a>'; 
		
		//commExceptionsStr = '<a href="#" disabled="disable">'+commLabel+'</a>';																								    


	if(audtiAut == "true") linkset[0]+= auditDetailStr;
	if(commExpAut == "true") linkset[0]+= commExceptionsStr;	

	dispMenu(linkset); // function call to display the menu with the linkset array elements as list items.	
}

function funonload()
{

	parent.frames[2].document.location.href="../../eXH/jsp/ViewEventsInteractiveFooter.jsp"; 
}
function editQuery()
{
																								 
	document.forms[0].action = "../../eXH/jsp/ViewEventsOutboundHeader.jsp?editquery=Y";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].target = "f_query_add_mod";
	document.forms[0].submit(); 
} 
async function goToMsgReview(applicationId,facilityId,facilityName,msgId,applicationName,protocol_link_id,position,purge_status,sub_module)
{

				 
				var url = "../../eXH/jsp/ViewInteractiveReviewPageMain.jsp?"+
				"applicationID="+applicationId+
				"&facilityID="+facilityId+
				"&msgID="+msgId+
				"&facilityName="+facilityName+
				"&applicationName="+applicationName+
				"&posi="+position
	            +"&applnname="+document.getElementById("applnname").value
				+"&facility="+document.getElementById("facility").value+						  
				"&msg_id1="+document.getElementById("msg_id1").value+
				"&msg_id2="+document.getElementById("msg_id2").value+						  
				"&eventtype="+document.getElementById("eventtype").value+
				"&protocol_link_id="+document.getElementById("protocol_link_id").value						   
				+"&msg_dt1="+document.getElementById("msg_dt1").value+
				"&msg_dt2="+document.getElementById("msg_dt2").value+
				"&posi="+position+"&comm_mode="+document.getElementById("comm_mode").value+
				"&event_status="+document.getElementById("event_status").value 
				+"&orderBy="+document.getElementById("orderBy").value+"&purge_status="+document.getElementById("purge_status").value+"&sub_module="+sub_module+"&order=A&tabValue=";	    
				var arguments = new Array();
				var dialogHeight = "45vh";
				var dialogWidth  = "55vw"; 								    
				var dialogTop    = "230";													    
				var dialogLeft   = "230";
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no" ;
				await window.showModalDialog(url,arguments,features); 

							
}

async function goToMessage(MessageId,applicationId,facilityId,Profileid,purge_status,sub_module)
 {
	 var dialogHeight = "45vh";
   var dialogWidth  = "55vw";
   var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

 
	var arguments  =new Array();
	var url;
	arguments[0]='L';
	arguments[1]=MessageId;
	arguments[2]=applicationId;
    arguments[3]=facilityId;
	arguments[4]=Profileid;


 												   
	 
  
	url = "../../eXH/jsp/ReviewApplInteractiveMessage_MenuMain.jsp?msgID="+MessageId+
				"&applicationID="+applicationId+
				"&facilityID="+facilityId+
				"&Profile_id="+Profileid+"&func=Main&purge_status="+document.getElementById("purge_status").value+"&sub_module="+sub_module; 
														   
	await window.showModalDialog(url,arguments,features);
  // window.open(url,null,"fullscreen=no,height=800,width=1000,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no");
} 

async function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,sub_module)
{
var dialogHeight = "45vh";
var dialogWidth  = "55vw";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  =new Array();
arguments[0]='L';
arguments[1]=applicationId;
arguments[2]=applicationName;
arguments[3]=facilityId;
arguments[4]=facilityName;  
arguments[5]=msgId;
arguments[6]=eventType;

    
	await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp?applicationId="+applicationId+"&facilityId="+facilityId+"&applicationName="+applicationName+"&facilityName="+facilityName+"&msgId="+msgId+"&eventType="+eventType+"&commMode=O"+"&sub_module="+sub_module,arguments,features);  
}
 


async function goToCommunicationError(facilityId,facilityName,sub_module)
{
	var dialogHeight = "45vh";
   var dialogWidth  = "55vw";
   var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments  =new Array();
	arguments[0]="L";
    arguments[1]=facilityId;
	arguments[2]=facilityName;
	arguments[3]="XHTCMMSG";
	await window.showModalDialog("../../eXH/jsp/ViewServerProcessInteractiveErrorMain.jsp",arguments,features);  
}
function Process(facilityId,applicationId,messageId,Process_Id,Event_type,addedwsno,buttonInvoked,purge_status,sub_module)
{
	var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var url='&facilityId='+facilityId+'&applicationId='+applicationId+'&messageId='+messageId+'&buttonInvoked='+buttonInvoked+'&Process_Id='+Process_Id+'&Event_type='+Event_type+'&addedwsno='+addedwsno+'&purge_status='+purge_status+'&sub_module='+sub_module;	  
	this.document.forms[0].action='../../servlet/eXH.XHViewEventsInteractiveServlet?'+url;
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
}
