 //*******************************************************************
// function reset 
//*******************************************************************
/*function reset()
{
	alert("reset AdministerReviewCommunicationProcess1");
	window.queue_frame.document.location.reload();
	window.action_frame.document.location.reload();
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}*/

//**************************************************************************************/
// function reloadJobQueueFrame
//**************************************************************************************/
function reloadJobQueueFrame(){
//	alert("reloadJobQueueFrame"); 
	parent.queue_frame.document.location.href='../../eXH/jsp/AdminOracleJobProcessList.jsp?functionID='+document.forms[0].functionID.value+'&module_id='+document.forms[0].mainModule_id.value;
//	parent.queue_frame.location.reload();
	parent.action_frame.location.reload(); 
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
 																							 
//**************************************************************************************/		    
// function load
//**************************************************************************************/ 
function load(){																							 
	document.forms[0].ove.style.display="none";
	document.forms[0].hidden_proc_srt_cmd.style.display="none";
	disableAll();
	}
//********************************************************************************/
// function submitForm
//********************************************************************************/
function submitForm(option)
{
		var sbmtFlag = 0;
		
		if(option.name=='submit'){
			var names = new Array();
			var fields=new Array() ;
			fields[0]= document.forms[0].process_id;
			names[0]=getLabel("Common.Process.label","common");
	
			var i=1;
	
			if(document.getElementById("module_disp").style.display=='block'){
				fields[i]=document.forms[0].module_Name;
				names[i]=getLabel("eXH.InterfaceDomain.Label","XH");
				i++;
			}
	
			if(document.getElementById("protocolLink_disp").style.display=='block'){
				fields[i]=document.forms[0].protocol_linkName;
				names[i]=getLabel("eXH.Gateway.Label","XH");
				i++;
			}
	
			if(document.getElementById("eventtype_disp").style.display=='block'){
				fields[i]=document.forms[0].event_type_id;
				names[i]= getLabel("Common.EventType.label","XH");
				i++;
			}

			fields[i]= document.forms[0].proc_date;
			names[i]=getLabel("eXH.NextProcessDateTime.Label","XH");
			i++;

			fields[i]= document.forms[0].interval;
			names[i]=getLabel("Common.Interval(min).label","common");
			i++;

			if(!parent.action_frame.checkFields( fields, names,parent.messageFrame))
			{
				sbmtFlag = 1;
			}

		}
		
		if(sbmtFlag!=1)
		{
			var chk_option=null;
			switch(option.name){
			case 'submit' :
					document.forms[0].action.value='S';
					build_what_internaljob();
					break;	    
			case 'change' :
					document.forms[0].action.value='C';break;	 
			case 'run' :
					document.forms[0].action.value='E';break;	    
			case 'remove' :
					document.forms[0].action.value='R';break;	    
			}
			enableAlways();

			document.forms[0].action="../../servlet/eXH.XHAdminOracleJobProcessServlet";
			document.forms[0].target='messageFrame';
			document.forms[0].ove.disabled = false;
			document.forms[0].ove.click(); 
			parent.frames[2].location.reload();
			
		}
		parent.commontoolbarFrame.location.reload();

}
//**************************************************************************************/
 // function enableAlways
//**************************************************************************************/
function enableAlways(){
	arrObj = document.forms[0].elements;
	for(var j=0;j<arrObj.length;j++) {
		if(arrObj[j].type=="hidden"){
//			alert("hddn elmnt Nm : "+arrObj[j].name);
			arrObj[j].disabled=false;
		}
		else {
			switch(arrObj[j].name){
				case "ove":
				case "hidden_proc_srt_cmd":
				arrObj[j].disabled=false;break;
				 }
		}
	}
}
//*********************************************************************************
// function build_what_internaljob
//*********************************************************************************

function build_what_internaljob(){
	var proc_id = document.forms[0].process_id.value;
	var param=param_build(proc_id);
	this.document.forms[0].param.value = param;
/*
		if (proc_id == 'XHBUILD')
		{ 	
			this.document.forms[0].internal_job.value = 'XHBUILDER.XHCREATOR;';
			this.document.forms[0].job1.value =  this.document.forms[0].job.value;
		}
		else if(proc_id == 'XHGENMESSAGEBUILDER'){
			var modl_id = this.document.forms[0].mod_id.value;
			var evnt_id  = this.document.forms[0].event_type_id.value;
	        var xhgenCreator = "XHGEN_CREATOR.XHCREATOR('"+modl_id+"','"+evnt_id+"');";
			this.document.forms[0].internal_job.value =  xhgenCreator;
			this.document.forms[0].job1.value =  this.document.forms[0].job.value;
		}		
		// Submit XHGEN_CREATOR.XHCREATOR before submiiting XHORATABPRC for Outbound
		else if(proc_id == 'XHORATABPRC'){
//          alert("comm_type : "+this.document.forms[0].comm_type.value); 
			var comm_type = this.document.forms[0].comm_type.value;
			if(comm_type=='O'){
//				alert("Outbound");
				var modl_id = this.document.forms[0].mod_id.value;
				var evnt_id  = this.document.forms[0].event_type_id.value;
				var xhgenCreator = "XHGEN_CREATOR.XHCREATOR('"+modl_id+"','"+evnt_id+"');";
//				alert("xhgenCreator");
				this.document.forms[0].internal_job.value =  xhgenCreator;
				this.document.forms[0].job1.value =  this.document.forms[0].job.value;
			}
		}		
		else{

	
			this.document.forms[0].internal_job.value = "";
			this.document.forms[0].job1.value = "";
		}
		*/
		
//		prcIDCmdObj = this.document.forms[0].hidden_proc_srt_cmd;
//		alert("prcIDCmdObj len : "+prcIDCmdObj.length);
 /* cmmntd on jan 9th
		for(i=0;i<prcIDCmdObj.length;i++){
			if(prcIDCmdObj.options[i].value==proc_id){
				if(proc_id=='XHORATABPRC'){
					document.forms[0].what.value = ""+prcIDCmdObj.options[i].text;
					break;
				}
				else{
					document.forms[0].what.value = ""+prcIDCmdObj.options[i].text+param+";";
					break;
				}
			}
		} // end of for
		*/
}
//*********************************************************************************
// function param_build
//*********************************************************************************
function param_build(proc_id){
	 
	var param_value = ""; 
	
/*	if(proc_id=='XHCREATOR'){
	}
	else
	*/
	if(proc_id=='XHBUILD'||proc_id=='XHLOADER'){
		application_id="('"+this.document.forms[0].application_id.value+"'";
		protLinkId	= ",'"+this.document.forms[0].protocol_link_id.value+"')";
		param_value = application_id+protLinkId;
	}

/*	else if(proc_id=='XHDBSYDN'){
		application_id="('"+this.document.forms[0].application_id.value+"')";
		param_value = application_id;
	} */

/*	else if(proc_id=='XHDBSYCN'){
		protLinkId	= "('"+this.document.forms[0].protocol_link_id.value+"')";
		param_value = protLinkId;
	} */

	else if(proc_id=='XHGNCRTR'){
//		mod_name = "('"+this.document.forms[0].mod_id.value+"'";
		mod_name = "('"+this.document.forms[0].	module_Id.value+"'";
		evnt_type = ",'"+this.document.forms[0].event_type_id.value+"')";
		param_value = mod_name+evnt_type;
	}

	else if(proc_id=='XHPURGE'){
	var appl=this.document.forms[0].application_id.value;
	 var fac=this.document.forms[0].facility_id.value;

	 if(appl=='' || appl==null)
		{
		 appl='*A';
		}
		
		if(fac==''||fac==null)
		{
			fac='*A';
		}
		application_id="('"+appl+"'";
		msg_status = ",'"+this.document.forms[0].msg_status.value+"'";
		fac_id = ",'"+fac+"')";
		param_value = application_id+msg_status+fac_id;
	}
												  
	else if(proc_id=='XHQRYPRC'){
/*		application_id="('"+this.document.forms[0].application_id.value+"'";
		resp_inc = ",'"+this.document.forms[0].resp_inc.value+"')"; */
		mod_id	= "('"+this.document.forms[0].module_Id.value+"'";		
		comm_type	= ",'"+this.document.forms[0].comm_type.value+"'";
		comm_type	=	",'"+this.document.forms[0].comm_mode.value+"'";
		evnt_type	= ",'"+this.document.forms[0].event_type_id.value+"'";
		protLinkId	= ",'"+this.document.forms[0].protocol_link_id.value+"'";
//		resp_inc = ",'"+this.document.forms[0].resp_inc.value+"')";
		resp_inc = ",'*A')";
//		param_value = application_id+resp_inc;
		param_value = mod_id+comm_type+evnt_type+protLinkId+resp_inc;
	}

	else if(proc_id=='XHGENERIC'||proc_id=="XHGENMESSAGEBUILDER"||proc_id=="XHGENMESSAGELOADER"||proc_id=="XHQUERYPROCESSOR"||proc_id=="XHBATCHQUERYCOMMUNICATOR"||proc_id=="XHBATCHEVENTPROCESSOR"||proc_id=="XHDBSYCN"||proc_id=="XHSYCNQR"||proc_id=="XHDBSYDN"||proc_id=="XHSYRSDT"){
//		mod_id	= "('"+this.document.forms[0].mod_id.value+"'";
		mod_id	= "('"+this.document.forms[0].module_Id.value+"'";		
		comm_type	= ",'"+this.document.forms[0].comm_type.value+"'";
		comm_type	=	",'"+this.document.forms[0].comm_mode.value+"'";
		evnt_type	= ",'"+this.document.forms[0].event_type_id.value+"'";
		protLinkId	= ",'"+this.document.forms[0].protocol_link_id.value+"')";
		param_value = mod_id+comm_type+evnt_type+protLinkId;
	}

	else if(proc_id=='XHORATABPRC'){
	
		if(this.document.forms[0].comm_type.value==''){
		
			comm_type	= "('"+this.document.forms[0].comm_type1.value+"'";
		}
		else{						    
			comm_type	= "('"+this.document.forms[0].comm_type.value+"'";
		}
		comm_type =  "('"+this.document.forms[0].comm_mode.value+"'";

		mod_name = ",'"+this.document.forms[0].module_Id.value+"'";		
//		mod_name = ",'"+this.document.forms[0].OTmodule_id.value+"'";
		protLinkId	= ",'"+this.document.forms[0].protocol_link_id.value+"'";
		wht1 = comm_type+mod_name+protLinkId+",'";
//		application_id=",'"+this.document.forms[0].OTapplcation_id.value+"'";
		application_id=",'"+this.document.forms[0].application_id.value+"'";
		fac_id = ",'"+this.document.forms[0].OTfacility_id.value+"'";
		evnt_type= ",'"+this.document.forms[0].event_type_id.value+"')";
		wht2 = "'"+application_id+fac_id+evnt_type;

		this.document.forms[0].wht1.value = wht1;
		this.document.forms[0].wht2.value = wht2;
	}

	else{
		param_value="()";
	}
	return param_value;
}
//*********************************************************************************
// function disableAll
//*********************************************************************************
function disableAll(Obj){

	document.forms[0].proc_date.value="";
	//added on Oct 20
	//document.forms[0].next_proc_time.value="";
	document.forms[0].interval.value="";
	document.forms[0].comm_type.value="";
	document.getElementById("showcalndr").disabled = true;
	arrObj = document.forms[0].elements;

	if(Obj!=null){
		if(Obj.name=='cancel'){
			if(parent.messageFrame){
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
	}
	for(var j=0;j<arrObj.length;j++) {
			if(arrObj[j].type=='text'){
				arrObj[j].value = "";
			}
			switch(arrObj[j].name){
				case "create":
//				case "reset":
					arrObj[j].disabled=false;break;
				default:
					arrObj[j].disabled=true;
			    }
	}
	enableAlways();
}

//********************************************************************************/
// function enableForNew
//********************************************************************************/
function enableForNew(){

	arrObj = document.forms[0].elements;
		for(var j=0;j<arrObj.length;j++) {		if(arrObj[j].name=="process"||arrObj[j].name=="proc_date"||arrObj[j].name=="interval"||arrObj[j].name=="submit"||arrObj[j].name=="refresh"||arrObj[j].name=="application_id"||arrObj[j].name=="appl_name"||arrObj[j].name=="msg_status"||arrObj[j].name=="comm_type"||arrObj[j].name=="event_type_id"||arrObj[j].name=="EventTypeSearch"||arrObj[j].name=="module_Name"||arrObj[j].name=="moduleNameSearch"||arrObj[j].name=="module_Id"||arrObj[j].name=="ApplicationSearch"||arrObj[j].name=="process_id"||arrObj[j].name=="ProcessSearch"||arrObj[j].name=="protocolLinkSearch"||arrObj[j].name=="protocol_link_id"||arrObj[j].name=="protocol_linkName"||arrObj[j].name=="apiSearch"||arrObj[j].name=="api_code"||arrObj[j].name=="api_desc"||arrObj[j].name=="OTmodule_name"||arrObj[j].name=="OTapplcation_name"||arrObj[j].name=="OTfacility_name"||arrObj[j].name=="OTmodule_id"||arrObj[j].name=="OTapplcation_id"||arrObj[j].name=="OTfacility_id"||arrObj[j].name=="mod_id"||arrObj[j].name=="mod_name"){
//			alert("enble : "+arrObj[j].name);
			arrObj[j].disabled=false;
		}
		else{
//			alert("disbl : "+arrObj[j].name);
			arrObj[j].disabled=true;
		}
	}
    document.getElementById("showcalndr").disabled = false;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

//*********************************************************************************
//function check_status_appl
//*********************************************************************************

function check_status_appl()
{
//	alert("check_status_appl");
	var process_id		=	document.forms[0].process_id.value;
	var appl_disp		=	document.getElementById("application_disp");
	var msgstatus_disp	=	document.getElementById("msgstatus_disp");
	var mod_disp		=	document.getElementById("module_disp");
	var comm_disp		=	document.getElementById("commtype_disp");
	var event_disp		=	document.getElementById("eventtype_disp");
	var prtclLink_disp	=	document.getElementById("protocolLink_disp");
	var Oratbl_disp		=   document.getElementById("OracleTblProc_disp");
	var modl_disp		=   document.getElementById("modl_disp");				
	var resp_inc_disp	=	 document.getElementById("resp_inc_disp");
	var facility_disp	=	 document.getElementById("facility_disp");
	
	// ||process_id=='XHDBSYDN'  

appl_disp.style.display='none'; 
msgstatus_disp.style.display='none'; 
mod_disp.style.display='none'; 
//comm_disp.style.display='none'; 
event_disp.style.display='none'; 
prtclLink_disp.style.display='none'; 
Oratbl_disp.style.display='none'; 
modl_disp.style.display='none'; 
resp_inc_disp.style.display='none'; 
facility_disp.style.display='none'; 


	if(process_id=='')
	{		
		appl_disp.style.display='none'; 
		msgstatus_disp.style.display='none';
		mod_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='none';
		prtclLink_disp.style.display='none';
		Oratbl_disp.style.display='none';
		modl_disp.style.display='none';		 
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
	}
	if(process_id=='XHBUILD' ||process_id=='XHLOADER')
	{		
		appl_disp.style.display='block'; 
		msgstatus_disp.style.display='none';
		mod_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='none';
		prtclLink_disp.style.display='block';
		Oratbl_disp.style.display='none';
		modl_disp.style.display='none';		 
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		document.forms[0].application_id.value = "";
		document.forms[0].appl_name.value		=	"";
		document.forms[0].protocol_link_id.value		=  "";
		document.forms[0].protocol_linkName.value  = "";
		//document.forms[0].interval.value = "";
	}

	if(process_id=='XHPURGE')		
	{
		document.forms[0].interval.value = "1440";
		appl_disp.style.display='block';
		msgstatus_disp.style.display='block';
		facility_disp.style.display='block';
		mod_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='none';
		prtclLink_disp.style.display='none';
		Oratbl_disp.style.display='none';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		document.forms[0].application_id.value = "";
		document.forms[0].appl_name.value		=	"";
		document.forms[0].facility_id.value = "";
		document.forms[0].facility_name.value = "";
	}

//	alert(process_id);
	if(process_id=='XHGENERIC'||process_id=="XHGENMESSAGEBUILDER"||process_id=="XHGENMESSAGELOADER"||process_id=="XHQUERYPROCESSOR"||process_id=="XHBATCHQUERYCOMMUNICATOR"||process_id=="XHBATCHEVENTPROCESSOR"||process_id=="XHDBSYCN"||process_id=="XHSYCNQR"||process_id=="XHDBSYDN"||process_id=="XHSYRSDT")		
	{
//		alert(process_id);
		appl_disp.style.display='none';
		msgstatus_disp.style.display='none';
		mod_disp.style.display='none'; 
//		comm_disp.style.display='block';
		event_disp.style.display='block';
		prtclLink_disp.style.display='block';
		Oratbl_disp.style.display='none';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		document.forms[0].protocol_link_id.value		=  "";
		document.forms[0].protocol_linkName.value  = "";
		document.forms[0].module_Id.value = "";
		document.forms[0].module_Name.value = "";
		document.forms[0].event_type_id.value = "";
		//document.forms[0].interval.value = "";
	}
	
	if(process_id=='XHGNCRTR')
	{
		appl_disp.style.display='none';
//		prtclLink_disp.style.display='block';  Commntd by Neelkamal on 25/5/2009
		prtclLink_disp.style.display='none';
		module_disp.style.display='none'; 
		modl_disp.style.display='none';
		event_disp.style.display='block';
		msgstatus_disp.style.display='none';
	//	comm_disp.style.display='none';
		Oratbl_disp.style.display='none';
	//	mod_disp.style.display='none';	Changed on 8/7/2009 for 10.2
		mod_disp.style.display='block';	  
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		document.forms[0].protocol_link_id.value		=  "";
		document.forms[0].protocol_linkName.value  = "";
//		document.forms[0].module_Id.value = "";	Cmmntd on 8/7/09
//		document.forms[0].module_Name.value = "";
//		document.forms[0].event_type_id.value = ""; Cmmntd on 8/7/09
		//document.forms[0].interval.value = "";
	}	

	if(process_id=='XHGENPURGE')	
	{
		appl_disp.style.display='none';
		mod_disp.style.display='block';
		msgstatus_disp.style.display='block';
//		comm_disp.style.display='none';
		event_disp.style.display='block';
		prtclLink_disp.style.display='block';
		Oratbl_disp.style.display='none';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		document.forms[0].protocol_link_id.value		=  "";
		document.forms[0].protocol_linkName.value  = "";
		document.forms[0].module_Id.value = "";
		document.forms[0].module_Name.value = "";
		document.forms[0].event_type_id.value = "";
		//document.forms[0].interval.value = "";
	} 

	if(process_id=='XHORATABPRC')
	{
		Oratbl_disp.style.display='block';
		module_disp.style.display='block';
		application_disp.style.display='block';
		prtclLink_disp.style.display='block';
		event_disp.style.display='block';
//		comm_disp.style.display='block';
//		mod_disp.style.display='none';
//		appl_disp.style.display='none';
		msgstatus_disp.style.display='none';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
//		alert(document.forms[0].protocol_link_id.value);
		document.forms[0].protocol_link_id.value		=  "";
		document.forms[0].protocol_linkName.value  = "";
		document.forms[0].module_Id.value = "";
		document.forms[0].module_Name.value = "";
		document.forms[0].event_type_id.value = "";
		document.forms[0].application_id.value = "";
		document.forms[0].appl_name.value		=	"";
		//document.forms[0].interval.value = "";
	}

/*	if(process_id=='XHDBSYCN'){
		appl_disp.style.display='none';
		mod_disp.style.display='none';
		msgstatus_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='none';
		prtclLink_disp.style.display='block';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		document.forms[0].interval.value = "";
	}
	*/
	if(process_id=='XHSPEVRP'||process_id=='XHSYNCCENTRALQUERY'||process_id=='XHSYNCHRESPDEST'||process_id=='XPINTER')	
	{
		appl_disp.style.display='none';
		mod_disp.style.display='none';
		msgstatus_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='none';
		prtclLink_disp.style.display='none';
		modl_disp.style.display='none';		
		resp_inc_disp.style.display='none';
		facility_disp.style.display='none';
		//document.forms[0].interval.value = "";
	}

	if(process_id=='XHQRYPRC'){
//		appl_disp.style.display='block';
        appl_disp.style.display='none';
		mod_disp.style.display='block';
		msgstatus_disp.style.display='none';
//		comm_disp.style.display='none';
		event_disp.style.display='block';
		prtclLink_disp.style.display='block';
//		resp_inc_disp.style.display='block'; cmmntd for 4.1
		resp_inc_disp.style.display='none';
		modl_disp.style.display='none';		
		facility_disp.style.display='none';
		document.forms[0].application_id.value = "";
		document.forms[0].appl_name.value		=	"";
		//document.forms[0].interval.value = "";
	}
}

//*********************************************************************************
//function getCommMode
//*********************************************************************************

function getCommMode(proc_id) {
		var proc_id	=	proc_id;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+proc_id+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","AdminOracleJobEvntList.jsp?func_mode=getCommMode",false);
		xmlHttp.send(xmlDoc);		
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
}


//*********************************************************************************
//function setCommMode
//*********************************************************************************
function setCommMode(comm_mode,recommended_time_intrvl){
		   
			
this.document.forms[0].comm_type1.value = comm_mode;
		this.document.forms[0].comm_mode.value = comm_mode; 

	 if(recommended_time_intrvl==null||recommended_time_intrvl=='')
	{
		 this.document.forms[0].interval.value="";
		  this.document.forms[0].interval.readOnly=false;
	}
	else
	{
	this.document.forms[0].interval.value=recommended_time_intrvl;


	 this.document.forms[0].interval.readOnly=true;					  

	}
		
}



	   


	 //*********************************************************************************
//function setCommunicationMode
//*********************************************************************************
function setCommunicationMode(comm_mode){
		   

this.document.forms[0].comm_type1.value = comm_mode;
		this.document.forms[0].comm_mode.value = comm_mode; 
		
}




//*********************************************************************************
//function getEvntList
//*********************************************************************************

function getEvntList(process_id,prtclLinkId) {
//function getEvntList(process_id) {  
	
//		var prtcl_link_id	=	prtclLinkId;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		  
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit1=\""+process_id+"\"";
		xmlStr += " base_unit2=\""+prtclLinkId+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","AdminOracleJobEvntList.jsp?func_mode=evntlist",false); 
		xmlHttp.send(xmlDoc);		
		eval(xmlHttp.responseText);	
}

//*********************************************************************************
//function setEvntList
//*********************************************************************************

//function setEvntList(app_id,fac_id,evntIdlist,comm_type,mod_id,app_name,mod_name,evntNameLst,fac_name){
 function setEvntList(evntIdlist,mod_id,mod_name,appl_id,appl_name,faci_id,faci_name){
		var proc_id = document.forms[0].process_id.value;
//function setEvntList(evntIdlist){

//	alert("evntIdlist : "+evntIdlist);
//	alert("mod_id : "+mod_id);
//	if(process_id == XHBATCHQUERYCOMMUNICATOR){
//		this.document.forms[0].mod_id.value = mod_id;
//		this.document.forms[0].mod_name.value = mod_name;
//		this.document.forms[0].OTmodule_id.value = mod_id;
//		this.document.forms[0].module_Id.value = mod_id;
//		this.document.forms[0].module_Name.value = mod_name;
//		this.document.forms[0].module_Id.value = "XH";
//		this.document.forms[0].module_Name.value = "Common Interface";
//		alert(this.document.forms[0].module_Id.value);
//	}
//	alert("evntIdlist : "+evntIdlist);
//	this.document.forms[0].OTfacility_id.value = fac_id;
//	this.document.forms[0].OTfacility_name.value = fac_name;
		if(mod_id!='')
		{
			this.document.forms[0].module_Id.value = mod_id;
			this.document.forms[0].module_Name.value = mod_name;
		}
		if(evntIdlist!='')
		{
			this.document.forms[0].event_type_id.value = evntIdlist;
			this.document.forms[0].event_type_id.readOnly=true; 
		}
		    	
		if(proc_id=='XHORATABPRC')
		{
			document.forms[0].application_id.value=appl_id;
			document.forms[0].appl_name.value=appl_name;   
			document.forms[0].OTfacility_id.value=faci_id;
			document.forms[0].OTfacility_name.value=faci_name;
		}


//	this.document.forms[0].comm_type.value = comm_type;
//	this.document.forms[0].comm_type.disabled = true;	
/*
	this.document.forms[0].OTapplcation_id.value = app_id;
	this.document.forms[0].OTapplcation_name.value = app_name;
	this.document.forms[0].OTmodule_name.value = mod_name;
*/
//	this.document.forms[0].application_id.value = app_id;
//	this.document.forms[0].appl_name.value = app_name;	
}

//********************************************************************************************
//function checkt
//********************************************************************************************
  function checkt(obj)
 {
    var val=obj.value;
	var arr;

		if(val!='')
		{

		  val	=	val.replace('.',":");

		  if((val.length==1) && (!isNaN(val))){
				obj.value="0"+val+":00";
		         obj.focus();
		  }
		  else if((val.length==2) && (!(isNaN(val))&&(val<=24)) ) 
		  {
				obj.value=val+":00";
		         obj.focus();

		  }
		  else
		  {
			arr=val.split(':');
//			alert("arr.length : "+arr.length+" Val : "+arr[0]);
			   if((arr.length>2)||(arr.length==0)) 
			  {
					alert(getMessage('XH1026','XH'));
	//				alert('APP-XH1026 Invalid Time Format(hh:mm)');
					obj.focus();
				    return false;
			  }
			   else
			   {   
				if((!(isNaN(arr[0])))&&(arr[0]<24))
					{ 
			         obj.focus();
					}
				else
				{		
					 alert(getMessage('XH1026','XH'));
 	//				 alert('APP-XH1026 Invalid Time Format(hh:mm)');
			         obj.focus();
					 return false;
				}

				if(arr[1]!=null){
				if((arr[1].length==1) && (!isNaN(arr[1]))){
					 if(arr[0].length==0){
						 obj.value="00:0"+arr[1];
					 }
					 if(arr[0].length==1){
						 obj.value="0"+arr[0]+":0"+arr[1];
					 }
					 else if(arr[0].length==2){
						 obj.value=arr[0]+":0"+arr[1];
					 }
					 obj.focus();
				 }
				else if((arr[1].length==2) && (!(isNaN(arr[1]))&&(arr[1]<=60)) ) 
				{
					 if(arr[0].length==0){
						 obj.value="00:"+arr[1];
					 }
					 if(arr[0].length==1){
						 obj.value="0"+arr[0]+":"+arr[1];
					 }
					 else if(arr[0].length==2){
						 obj.value=arr[0]+":"+arr[1];
					 }
//					 obj.value=arr[0]+":"+arr[1];
					 obj.focus();
				}
				else
				{		
					 alert(getMessage('XH1026','XH'));
 	//				 alert('APP-XH1026 Invalid Time Format(hh:mm)');
			         obj.focus();
					 return false;
				}
			   } // end of arr[1]!=null
			   } // else
		  } // end of else
		} // end of if
}

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

async function searchFacility(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit	= getLabel("Common.facility.label",'Common');
			var tit	= "Facility";

            var target=this.document.forms[0].facility_name;
            var faclty_id=this.document.forms[0].facility_id;
var locale=this.document.forms[0].locale.value;
			
			sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id AND b.LANGUAGE_ID=nvl('"+locale+"',b.LANGUAGE_ID) AND UPPER(b.facility_id) LIKE UPPER(?) AND UPPER(b.facility_name) LIKE UPPER(?) ORDER BY 1 ";

//			sql="SELECT '*A' code,'ALL' description FROM DUAL UNION SELECT a.facility_id code,b.facility_name description FROM XP_PARAM_FOR_FACILITY a,SM_FACILITY_PARAM b WHERE a.facility_id=b.facility_id AND UPPER(b.facility_id) LIKE UPPER(?) AND UPPER(b.facility_name) LIKE UPPER(?) ORDER BY 1 ";

			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
     //     argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                faclty_id.value=arr[0];
            }
            else{
                target.value=tdesc;						     
			//	target.value='ALL';
				//faclty_id.value='*A';
                faclty_id.value=tcode;
            }
}// End of searchFacility


//*********************************************************************************
//function searchProcess
//*********************************************************************************

async function searchProcess(modl_Id){
//	       alert("searchProcess");
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
 			var tit	=getLabel("Common.Process.label",'Common');
				//getLabel("Common.Process.label",'Common');
            var target=this.document.forms[0].process;
            var proc_id=this.document.forms[0].process_id;
			var proc_idVal = proc_id.value;
			var comm_typeVal = trimString(this.document.forms[0].comm_type1.value);
//			alert("comm_typeVal1 : "+comm_typeVal);
			var central_yn = this.document.forms[0].central_yn.value;
			var functionID = this.document.forms[0].functionID.value;
//            alert("central_yn : "+central_yn);

			if(functionID == "XF_J_ADMNREV_SVR_PROCESS")
			{				
				sql = "SELECT proc_id code,long_desc description FROM XH_PROC_ID WHERE UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) AND substr(proc_id,1,2) in ('XF','DF','BL') ORDER BY 1 ";
			}
			else
			{
				sql = "SELECT proc_id code,long_desc description FROM XH_PROC_ID WHERE UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
			}			

/*			if(comm_typeVal!=''){
				if(comm_typeVal =='I' || comm_typeVal =='O' ){
					sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE (PROCESS_GROUP='"+comm_typeVal+"M' OR communication_mode='X' ) AND UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
				}
				else if(comm_typeVal =='R' ){
					if(central_yn=='Y'){
						sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE SUBSTR(PROCESS_GROUP,1,2) ='RC' AND UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
					}
					else if(central_yn=='N' || central_yn=='') {
						sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE SUBSTR(PROCESS_GROUP,1,2) ='RL' AND UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
					}
				}
				else  if(comm_typeVal =='IO' ){
						sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE SUBSTR(PROCESS_GROUP,1,2) ='IO' AND UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
				}
				else  if(comm_typeVal =='Q'  || comm_typeVal=='5.1'){
						sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE PROCESS_GROUP ='"+comm_typeVal+"' AND UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
				}
			*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
//			alert("retVal : "+retVal)
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                proc_id.value=arr[0];
				getCommMode(arr[0]);
// Added by Neelkamal on 22/5/2009
// End of the code added by Neelkamal
            }
            else{
                target.value=tdesc;
                proc_id.value=tcode;
            }
			check_status_appl();
			 
/*			 if(retVal != null && retVal != "" ){
				if(arr[0]=='XHGNCRTR'){
//					alert(arr[0]);
					getEvntList(arr[0]);
//					searchEventName();
				}
			 } */									 

//			}
//			else{
//				alert("else");
//				alert("Select any Process Group");
//				sql="SELECT proc_id code,long_desc description FROM XH_PROC_ID  WHERE communication_mode='N' AND  UPPER(proc_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 1 ";
//			}
			
}// End of searchProcess

//*********************************************************************************
//function searchApplication
//*********************************************************************************

async function searchApplication(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
 			var tit	= getLabel("Common.Application.label",'Common');
            var target=this.document.forms[0].appl_name;
            var appl_id=this.document.forms[0].application_id;
			var appl_idVal = appl_id.value;

			sql="SELECT application_id code,application_name description FROM XH_APPLICATION  WHERE UPPER(application_id) LIKE UPPER(?) AND UPPER(application_name) LIKE UPPER(?)  ORDER BY 1 ";

	/*		if(appl_id.value!=""){
				dataNameArray[0]	= "application_id" ;
				dataValueArray[0]	= appl_id.value;
				dataTypeArray[0]	= STRING ;
			}
    */
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                appl_id.value=arr[0];
            }
            else{
                target.value=tdesc;
//target.value='ALL';
//appl_id.value='*A'
                appl_id.value=tcode;
            }
}// End of searchApplication

//********************************************************************************************
//function searchModuleName
//*******************************************************************************************

async function searchModuleName(){

			this.document.forms[0].event_type_id1.value='';
			this.document.forms[0].event_type_id.value='';
			
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
 			var tit	= getLabel("eXH.InterfaceDomain.Label",'XH');
            var target=this.document.forms[0].module_Name;
            var module_id=this.document.forms[0].module_Id;        
			var process_id=this.document.forms[0].process_id.value;

			sql="SELECT distinct INTERFACE_MODULE_ID code,INTERFACE_DESC description FROM XH_INTERFACE WHERE UPPER(INTERFACE_MODULE_ID) LIKE UPPER(?) AND  UPPER(INTERFACE_DESC) LIKE UPPER(?)   ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                module_id.value=arr[0];
//                alert("process_id : "+process_id);
				if(process_id=='XHGNCRTR') {
//					alert(arr[0]);
					getEvntList(process_id,arr[0]);
//					searchEventName();
				}
			}
            else{
                target.value=tdesc;
                module_id.value=tcode;
            }
}// End of searchModuleName


//********************************************************************************************
//function searchProtocolLinkList
//*******************************************************************************************

async function searchProtocolLinkList(){
//	        alert("searchProtocolLinkList");
			this.document.forms[0].event_type_id1.value='';
			this.document.forms[0].event_type_id.value='';
			// this.document.forms[0].protocol_linkName.value='';
		//	 this.document.forms[0].protocol_link_id.value='';
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var dialogTop = "" ;
			var center = "1" ;
			var status="no";					    
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
 			var tit	= getLabel("eXH.Gateway.Label",'XH');
            var target=this.document.forms[0].protocol_link_id;
            var protocol_linkName=this.document.forms[0].protocol_linkName;
			var OptionText=target.value;
			var searchText = target.value;
			sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND  UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
			var retVal = await top.window.showModalDialog("../../eXH/jsp/AdminoraclejobGatewayLookupFrameSetMaster.jsp?searchText=&protocol_link_id="+this.document.forms[0].protocol_link_id.value+'&commmode='+document.forms[0].comm_mode.value+'&OptionText='+encodeURIComponent(OptionText),arguments,features);
		        
		    var GtwyList = "";
			  if(retVal != undefined ){
				  /* for(i=0;i<retVal.length;i++)
				   {
						if ((retVal[i] != null)&&(retVal[i] != 'undefined')&&(retVal[i] != '')&&(retVal[i] != 'null')) {
//							alert("GtwyList : "+GtwyList);
							if(GtwyList.length>0){
								GtwyList = GtwyList+","+retVal[i];
							}
							else{
								GtwyList = GtwyList+retVal[i];
							}
						}
				   } */
			   protocol_linkName.value = retVal;
			   target.value = retVal;
				  GtwyList=retVal;
			   if(GtwyList.length>0){
				   GtwyList = GtwyList.replace(/,/g,"','");

				 
//				   alert("Aft Repl : "+GtwyList);
				   getEvntList('',GtwyList);
				}
			}
			else
	{
		if(target.value.length>0)
		{
			var GtwyList2=target.value.replace(/,/g,"','");
			getEvntList('',GtwyList2);
		}
		else
		{
			protocol_linkName.value = '';
			target.value = '';
		}
	}

  }// End of searchProtocolLinkList

//********************************************************************************************
//function searchEventName
//*******************************************************************************************

async function searchEventName(){
//	        alert();
		
			var dialogHeight= "70vh" ;
			var dialogWidth	= "60vw" ;
			var dialogTop = "" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
 			var tit	= getLabel("Common.Event.label",'Common');
            var target=this.document.forms[0].event_type_id;
            var event_type_id1=this.document.forms[0].event_type_id1;
			var searchText = target.value;
		
        	sql="SELECT  EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE and COMMUNICATION_TYPE in ('"+document.forms[0].comm_mode.value+"','*') ";

//			WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND  UPPER(EVENT_NAME) LIKE UPPER(?)   ORDER BY 1
		   /* argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ; 									 
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value; 
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;*/ 
        	var retVal = await top.window.showModalDialog("../../eXH/jsp/AdminoraclejobEventLookupFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&protocol_link_id="+this.document.forms[0].protocol_link_id.value+'&commmode='+document.forms[0].comm_mode.value,arguments,features);

  																		    
     																							 
          // /* retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){						   
	            var ret1=unescape(retVal); 
			

               // arr=ret1.split(",");
//                target.value=arr[1];
				target.value=ret1.substring(0,(ret1.length-1));
              event_type_id1.value=ret1.substring(0,(ret1.length-1));
            }
            else{
		
                target.value=searchText;
                event_type_id1.value=searchText;
            }
}// End of searchEventName


//********************************************************************************************
//function searchResult
//*******************************************************************************************
/*function searchResult()
{

	var frmObj	= document.OrderableSearch;
	order_category=frmObj.ordercategory.value;
	type_code=frmObj.typecode.value;
	activity_type=frmObj.activity_type.value;
	
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{
		search_by="C";
	}
		description_code=frmObj.search_criteria.value
		search_text=frmObj.search_text.value;
 		var called_from = frmObj.called_from.value;   
 		var bean_id = frmObj.bean_id.value;  
 		var bean_name = frmObj.bean_name.value;  
		
 
				
	//	var table_name = frmObj.table_name.value;  
 		parent.refusal_resultframe1.location.href = "../../eXH/jsp/AdminoraclejobEventLookupResult.jsp?order_category="+order_category+"&type_code="+type_code+"&activity_type="+activity_type+"&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&bean_id="+bean_id+"&bean_name="+bean_name;

		 

}*/
//********************************************************************************************
//function searchResult
//*******************************************************************************************

function searchResult()
{

	var frmObj	= document.OrderableSearch;
	
	
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{
		search_by="C";
	}
		description_code=frmObj.search_criteria.value
		search_text=frmObj.search_text.value;
 		var called_from = frmObj.called_from.value;   
 		protocol_link_id=frmObj.protocol_link_id.value;

 

 		parent.refusal_resultframe1.location.href = "../../eXH/jsp/AdminoraclejobEventLookupResult.jsp?&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&protocol_link_id="+protocol_link_id+'&commmode='+document.forms[0].comm_mode.value; 
}

//********************************************************************************************
//function searchGatewayResult
//*******************************************************************************************

function searchGatewayResult()
{
    var index = document.forms[0].module_Id.options.selectedIndex;
	interfc_mod_id	= document.forms[0].module_Id.options[index].value;
//	alert("interfc_mod_id : "+interfc_mod_id);
	var frmObj	= document.OrderableSearch;	
	
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else													 
	{													  
		search_by="C";
	}
		description_code=frmObj.search_criteria.value
		search_text=frmObj.search_text.value;
 		var called_from = frmObj.called_from.value;   				  
 		protocol_link_id=frmObj.protocol_link_id.value;

 		parent.refusal_resultframe1.location.href = "../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp?&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&protocol_link_id="+protocol_link_id+'&commmode='+document.forms[0].comm_mode.value+"&interfc_mod_id="+interfc_mod_id+"&search_optiontext="+encodeURIComponent(document.getElementById("search_optiontext").value); 
}
//********************************************************************************************
//function searchProtocolLink																											  
//*******************************************************************************************

async function searchProtocolLink(){
//alert("searchProtocolLink");				    
this.document.forms[0].event_type_id1.value='';
this.document.forms[0].event_type_id.value=''; 
 
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
   			var tit	= getLabel("eXH.Gateway.Label",'XH');
            var target=this.document.forms[0].protocol_linkName;
            var prot_link_id=this.document.forms[0].protocol_link_id;
			var comm_typeVal = this.document.forms[0].comm_type1.value;
			var process_id = this.document.forms[0].process_id.value;
			
//			alert("process_id : "+process_id);
//			alert("comm_typeVal : "+comm_typeVal);

            if(comm_typeVal == 'X'){
				sql="SELECT A.PROTOCOL_LINK_ID code,A.PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK A,XH_PROTOCOL B WHERE A.PROTOCOL_ID=B.PROTOCOL_ID AND B.PROTCOL_MODE IN ('O','I') AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1  ";
			}
			else if(comm_typeVal == 'I' ||  comm_typeVal == 'O')  {
				if(process_id=='XHGENMESSAGEBUILDER'){
					sql="SELECT A.PROTOCOL_LINK_ID code,A.PROTOCOL_LINK_NAME description FROM  XH_PROTOCOL_LINK A,XH_PROTOCOL B WHERE A.PROTOCOL_ID=B.PROTOCOL_ID AND B.PROTCOL_MODE=NVL('"+comm_typeVal+"',B.PROTCOL_MODE) AND UPPER(PROTOCOL_LINK_ID) NOT IN ('IPL1','IPL2','BPL1') AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
				else{
					sql="SELECT A.PROTOCOL_LINK_ID code,A.PROTOCOL_LINK_NAME description FROM  XH_PROTOCOL_LINK A,XH_PROTOCOL B WHERE A.PROTOCOL_ID=B.PROTOCOL_ID AND B.PROTCOL_MODE=NVL('"+comm_typeVal+"',B.PROTCOL_MODE) AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
			}
			else if(comm_typeVal == 'R' ){
				if(process_id=='XHDBSYCN' || process_id== 'XHSYCNQR' || process_id=='XHSYRSDT'){
					sql="SELECT A.PROTOCOL_LINK_ID code,A.PROTOCOL_LINK_NAME description FROM  XH_PROTOCOL_LINK A,XH_PROTOCOL B WHERE A.PROTOCOL_ID=B.PROTOCOL_ID AND B.PROTCOL_MODE='O' AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
				else if (process_id=='XHDBSYDN'){
					sql="SELECT A.PROTOCOL_LINK_ID code,A.PROTOCOL_LINK_NAME description FROM  XH_PROTOCOL_LINK A,XH_PROTOCOL B WHERE A.PROTOCOL_ID=B.PROTOCOL_ID AND B.PROTCOL_MODE='I' AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
			}
			else{
				if(process_id=='XHORATABPRC'){
					sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK WHERE UPPER(PROTOCOL_LINK_ID) IN ('IPL1','IPL2','BPL1') OR  SUBSTR(UPPER(PROTOCOL_LINK_ID),1,2)='OT' AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND  UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
				else{
					sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK           WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND  UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) ORDER BY 1 ";
				}
			}

	/*		if(prot_link_id.value!=""){
				dataNameArray[0]	= "PROTOCOL_LINK_ID" ;
				dataValueArray[0]	= prot_link_id.value;
				dataTypeArray[0]	= STRING ;
			}
      */
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                prot_link_id.value=arr[0];
				getEvntList('',arr[0]);

				if(comm_typeVal=='' || comm_typeVal==null)
				{
					getCommunicationMode(arr[0]);
				}

            }
            else{
                target.value=tdesc;
                prot_link_id.value=tcode; 
            }
			
//			getEvntList(process_id);
			
}// End of searchProtocolLink
//********************************************************************************************
//function getCommunicationMode
//*******************************************************************************************
  function getCommunicationMode(proto_id) {
		var gateway_id	=	proto_id;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+gateway_id+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","AdminOracleJobEvntList.jsp?func_mode=getCommunicationMode",false);
		xmlHttp.send(xmlDoc);		
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
}
//********************************************************************************************
//function resetFormSearch
//********************************************************************************************
function resetFormSearch(frmObj)
{			 
		var qry_str= document.forms[0].qry_str.value;																						  
																					    
															   
 		parent.parent.refusal_searchframe1_master.location.href = "../../eXH/jsp/AdminoraclejobGatewayLookupFrameSetMaster.jsp?searchText=&protocol_link_id=&commmode="+document.forms[0].comm_mode.value+"&OptionText=";
								 
		/*		frmObj.reset();						   			   
				frmObj.search_text.value = "";					  
				n=frmObj.ordercategory.length										    
				clearList("document");
				clearActivityList("document");
				
		for(i=0;i<n;i++)
		{
				var element = document.createElement('OPTION') ;
				element.value=frmObj.ordercategory[i].value;
				element.text=frmObj.ordercategory[i].text;
				if(element.value!="" && element.text!="All")
				frmObj.typecode.add(element);
		}*/

	parent.refusal_resultframe1.location.href = "../../eCommon/html/blank.html";

}
//********************************************************************************************
//function checkDt
//********************************************************************************************
   function checkDt(date1)
        {
            retval=true
            var date1arr=new Array()

            date1arr=date1.split("/")

            if(date1arr.length==3)
            {
                var date1d=date1arr[0]
                var date1m=date1arr[1]
                var date1y=date1arr[2]

                date1d=eval(date1d)
                date1m=eval(date1m)
                date1yy=eval(date1y);

                if(date1m<=12)
                {

                    if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
                    {
                        retval= false
                    }

                    if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
                    {
                        retval= false
                    }
                    if ((date1y.length <4) || (date1y.length >4))
                    {
                        retval= false
                    }
                    if (date1m == 2) {
                        if (date1d< 1) return false;

                        if (LeapYear(date1yy) == true) {
                            if (date1d> 29) return false;
                        }
                        else {
                            if (date1d > 28) return false;
                        }
                    }

                    if (isNaN(date1d)==true) retval = false;
                    if (isNaN(date1m)==true) retval = false;
                    if (isNaN(date1yy)==true) retval = false;
                }
                else
                {
                    retval= false;
                }
            }
            else
            {
                retval= false;
            }
            return retval;
        }

//********************************************************************************************
//function chkTime
//********************************************************************************************

		 function chkTime(time1)
        {
           var retval=true;
           var strCheck = ':0123456789';
            for(var i=0;i<=time1.length;i++) {
                if (strCheck.indexOf(time1.charAt(i)) == -1){
                    retval = false;
                    break;
                }
            }
            if (retval)
            {
                if( (time1.charAt(time1.length-1) )!=":")
                {
                    var time1arr=new Array()
                    time1arr=time1.split(":")

                    if(time1arr.length==2)
                    {
                        var time1hr=time1arr[0]
                        var time1min=time1arr[1]

                        time1hr=eval(time1hr)
                        time1min=eval(time1min)
                        if(time1hr<=23)
                        {
                            if(time1min>59)
                            {
                                    retval=false;
                                    //alert("Invalid Time")
                            }
                        }
                        else
                                retval=false;
                                //alert("Invalid Time")
                    }
                    else
                        retval=false;
                        //alert("Invalid Time")
                }
                else
                        retval=false;
                        //alert("Invalid Time")
            }
            return retval
        }
