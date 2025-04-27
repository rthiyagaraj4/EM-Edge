var dialogHeight = "250";
var dialogWidth  = "250";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

async function goToMessage(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName,protocol_link_id,sub_module)
{
	var arguments  =new Array();
	var url;
	arguments[0]='L';
	arguments[1]=applicationId;
	arguments[2]=applicationName;
	arguments[3]=facilityId;
	arguments[4]=facilityName;
	arguments[5]=msgId;
	arguments[6]=eventType;
	arguments[7]=eventName;
	arguments[8]=protocol_link_id;
	var Rule=document.getElementById("Rule").value;
	var mode=document.getElementById("mode").value;

	url = "../../eXH/jsp/ReviewApplMessage_Menu.jsp?"+
			"application_id="+applicationId+
			"&application_name="+applicationName+
			"&facility_id="+facilityId+
			"&facility_name="+facilityName+
			"&event_type="+eventType+
			"&msgid="+msgId+
			"&protocol_link_id="+protocol_link_id+
			"&sub_module="+sub_module;

	if(mode == "null")
	{
		url=url+"&Rule="+Rule;
	}
	else
	{
		url = url+"&mode="+mode;
	}	 

	await window.showModalDialog(url,arguments,features);  
}

//**********************************************************************************************/
async function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)
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

	await window.showModalDialog("../../eXH/jsp/ViewMessageAuditLogMain.jsp",arguments,features);  
}
//**********************************************************************************************/
async function goToDebugLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)
{
	var arguments  =new Array();
	arguments[0]="L";
	arguments[1]=applicationId;
	arguments[2]=applicationName; 
	arguments[3]=facilityId;
	arguments[4]=facilityName;
	arguments[5]=eventType;
	arguments[6]=eventName;
	arguments[7]=msgId;

	await window.showModalDialog("../../eXH/jsp/ViewDebugInformationMain.jsp",arguments,features);  
}
//**********************************************************************************************/
async function goToServerError(applicaionID,facilityId,facilityName,msgID)
{
	var arguments  =new Array();
	arguments[0]="L";
	arguments[1]=facilityId;
	arguments[2]=facilityName;
	arguments[3]=" ";
	arguments[4]=applicaionID;
	arguments[5]=msgID;

	await window.showModalDialog("../../eXH/jsp/ViewServerProcessErrorMain.jsp",arguments,features);  
}
//**********************************************************************************************/
async function goToCommunicationError(applicaionID,facilityId,facilityName,msgID)
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
	
	await window.showModalDialog("../../eXH/jsp/ViewServerProcessErrorMain.jsp",arguments,features);  
}
/**********************************************************************************************/
function Process(facilityId,applicationId,messageId,buttonInvoked,purge_status,subModule)
{
	var url='&facilityId='+facilityId+'&applicationId='+applicationId+'&messageId='+messageId+'&buttonInvoked='+buttonInvoked+'&purge_status='+purge_status+'&sub_module='+subModule;

	this.document.forms[0].action='../../servlet/eXH.XHViewEventsOutboundServlet?'+url;
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
}

//function callSort
function callSort(obj)
{
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	
   this.document.forms[0].orderbycolumns.value=obj;
   parent.f_query_detail.location.href="../../eCommon/html/blank.html";
   this.document.forms[0].action='../../eXH/jsp/ViewServerProcessErrorsDtlTest.jsp?';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();

}
//function funShow
function funShow(obj)
{
	this.document.forms[0].Appl_msg.value = obj.getAttribute('Appl_msg');
	this.document.forms[0].Err_msg.value = obj.getAttribute('Err_msg');
	this.document.forms[0].Appl_key.value = obj.getAttribute('Appl_key');
	var act = '../../eXH/jsp/ViewServerProcessErrorsFooter.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
	
}
//function funSubmit
function funSubmit()
{
	var act = '../../eXH/jsp/ViewServerProcessErrorsDtlTest.jsp?';
	this.document.forms[0].action = act;
	document.forms[0].sortMode.value="A";
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
}
//function funAction
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	funSubmit();

}
