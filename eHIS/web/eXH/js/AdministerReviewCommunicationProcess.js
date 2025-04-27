 //*******************************************************************
// function reset 
//*******************************************************************

 
function reset()
{ 
	window.queue_frame.document.location.reload();
	window.action_frame.document.location.reload();
	window.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
//*************************************************************************************
//**************************************************************************************/
	var mesg_repository = new Array();
	var proc_srt_cmd=new Array();
	mesg_repository["APP06-XH"] = "APP06-XH Enter Valid Interval";
	mesg_repository["APP07-XH"] = "APP07-XH Enter a Non Zero Interval";
//**************************************************************************************/
// function reloadJobQueueFrame
//**************************************************************************************/
function reloadJobQueueFrame(){
	parent.queue_frame.location.reload();
}
//**************************************************************************************/		  
//**************************************************************************************/
var arr = new Array();
var arr1=new Array();
//**************************************************************************************/
// function load
//**************************************************************************************/
function load(){
	document.forms[0].ove.style.display="none";
	document.forms[0].hidden_proc_srt_cmd.style.display="none";
//	disableAll();
}

//**************************************************************************************/
// function enableForNew
//**************************************************************************************/
function enableForNew(){
	arrObj = document.forms[0].elements;	
		for(var j=0;j<arrObj.length;j++) {
		if(arrObj[j].name=="process"||arrObj[j].name=="proc_date"||arrObj[j].name=="interval"||arrObj[j].name=="submit"||arrObj[j].name=="refresh"||arrObj[j].name=="appl_name")
			arrObj[j].disabled=false;
		else {
				arrObj[j].disabled=true;

		    }
	}
}
//**************************************************************************************/
// function enableAlways
//**************************************************************************************/
function enableAlways(){
	arrObj = document.forms[0].elements;
	for(var j=0;j<arrObj.length;j++) {
		if(arrObj[j].type=="hidden")
			arrObj[j].disabled=false;
		else {
			switch(arrObj[j].name){
				case "ove":
				case "hidden_proc_srt_cmd":
				arrObj[j].disabled=false;break;
				 }
			 }
     	}
}

//**************************************************************************************/
// function disableAll
//**************************************************************************************/
function disableAll(){
	arrObj = document.forms[0].elements;

	document.forms[0].proc_date.value="";
	document.forms[0].interval.value="";
	
	for(var j=0;j<arrObj.length;j++) {
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
//**************************************************************************************/
// function disableChkBox
//**************************************************************************************/
function disableChkBox(){

}
//**************************************************************************************/
// function checkObject
//**************************************************************************************/
function checkObject(str){
	var obj = arr[str];
	try
	{
		obj.checked = true;
	}
	catch(e)
	{
	}
}
 //**************************************************************************************/
// function formDisable
//**************************************************************************************/
 /*function formDisable(){
	var arrObj = document.forms[0].elements;
	for(var j=0;j<arrObj.length;j++){
		if(arrObj[j].type=="checkbox" || arrObj[j].type=="button" || arrObj[j].type=="text" || arrObj[j].type=="select-multiple") 
			arrObj[j].disabled=true;
	}
	
 }
 */
//**************************************************************************************/
var select_option;
//**************************************************************************************/
// function sendParam
//**************************************************************************************/
function sendParam(obj)
{

//	alert("sendParam");
//	alert("frmNam : "+parent.frames[2].document.forms[0].name);
	parent.frames[2].document.forms[0].refresh.disabled = false;
	parent.frames[2].document.forms[0].submit.disabled = false;
	parent.frames[2].document.forms[0].change.disabled = true;
	parent.frames[2].document.forms[0].run.disabled = true;
	parent.frames[2].document.forms[0].remove.disabled = true;
 parent.frames[2].document.getElementById("protocolLink_disp").style.display='none';
parent.frames[2].document.getElementById("application_disp").style.display='none';
parent.frames[2].document.getElementById("msgstatus_disp").style.display='none';
parent.frames[2].document.getElementById("modl_disp").style.display='none';
parent.frames[2].document.getElementById("module_disp").style.display='none'; 

parent.frames[2].document.getElementById("eventtype_disp").style.display='none';
parent.frames[2].document.getElementById("OracleTblProc_disp").style.display='none';
parent.frames[2].document.getElementById("facility_disp").style.display='none';
parent.frames[2].document.getElementById("resp_inc_disp").style.display='none';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	var job = obj.getAttribute("job");
	var what = obj.getAttribute("what");
	var interval = obj.getAttribute("interval");
	var formObj=parent.action_frame.AdminOracleJobProcessActionForm;
	select_option=obj.getAttribute("select_option");
	var last_date = obj.getAttribute("last_date");
	var next_date = obj.getAttribute("next_date");
//	alert("next_date : "+next_date);

	var long_desc = obj.getAttribute("long_desc");
//	alert("err_msg : "+err_msg);

/*
	alert("sendPrm job : "+job);
	alert("sendPrm what : "+what);
*/

	formObj.job.value=job;
	
	formObj.interval.value=interval;
//    formObj.proc_date.value=last_date;
	formObj.proc_date.value=next_date.substring(0,16);

	var index=what.indexOf('(');
	var appl;
	if(index!=-1){
	               appl=what.substring(index+2,what.length-3);
	       }
	else appl="";
//	alert("sendPrm appl whtVal : "+appl);
	enableRowClick();
	formObj.process_id.value = select_option;
	formObj.processID.value = select_option;	
	formObj.process.value=long_desc;
// cmmntd on jan 9th 	formObj.what.value=what;
/*  if(err_msg!=''){
		showServerErr(err_msg);
  } */
}
//*******************************************************************************************
//function showServerErr
//*******************************************************************************************

async function showServerErr(obj)
{	
		//	var proc_id = obj.getAttribute("select_option");
	//		alert("proc_id : "+proc_id);
	//		var err_msg = obj.getAttribute("err_msg");
			var proc_id = obj;
	//		var url     = "../../eXH/jsp/AdministerDataProcessServErr.jsp?err_msg="+err_msg+"&proc_id="+proc_id;
		//	var url     = "../../eXH/jsp/AdministerDataProcessServErr.jsp?proc_id="+proc_id;
			var url     = "../../eXH/jsp/AdminQueryExceptionPage.jsp?proc_id="+proc_id;		   

			
			var dialogTop   = "350";			     
			var dialogHeight= "71vh" ;
			var dialogWidth = "75vw" ;											 
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
       	    await window.showModalDialog( url, arguments, features ) ;
}
//*******************************************************************************************
//function setServerError
//*******************************************************************************************

function setServerError(error)
{
	var error = unescape(error);
	for(var i = 0; i < error.length; i++)
	{
		error = error.replace('+'," ");
	}
	document.forms[0].err_msg.value = error;
}
//************************  **************************************************************/
// function enableRowClick
//**************************************************************************************/
function enableRowClick(){
	var formObj=parent.action_frame.AdminOracleJobProcessActionForm;
	arrObj = formObj.elements;
	      for(var j=0;j<arrObj.length;j++) {
			switch(arrObj[j].name){
			case "change":
			case "run":
			case "remove":
//			case "process":
			case "proc_date":
			case "interval":
			case "appl_name":
			case "refresh":
//            case "next_proc_time":
//			case "reset":
					arrObj[j].disabled=false;break;
			default: arrObj[j].disabled=true;
			         break;
	        }		 
	}
	parent.action_frame.document.getElementById("showcalndr").disabled = false;

}

function showErrors(obj)
{		
	var linkset = new Array();	
	showExceptions = '<a href="#" onClick='+'\''+'showServerErr("'+obj.getAttribute('select_option')+'");'+'\''+'>Query Exceptions</a>';
	purgeExceptions = '<a href="#" onClick='+'\''+'showExcel("N","'+obj.getAttribute('select_option')+'","purge");'+'\''+'>Purge</a>';
	write2XL = '<a href="#" onClick='+'\''+'showExcel("N","'+obj.getAttribute('select_option')+'","result");'+'\''+'>Download Excel</a>';
	run = '<a href="#" onClick='+'\''+'runProcess("'+obj.getAttribute('select_option')+'","'+obj.getAttribute('run_job')+'","'+escape(obj.getAttribute('what'))+'","'+obj.getAttribute('interval')+'","'+obj.getAttribute('proc_date')+'");'+'\''+'>Run</a>';
	
	linkset[0] = showExceptions;
	linkset[0] += purgeExceptions;
	linkset[0] += write2XL;
	linkset[0] += run;
	dispMenu(linkset);
}

function showExcel(flag,obj,action)
{			

	   var flagch=true;
	if(action=="purge")
	{

			var i=window.confirm(getMessage("DELETE_RECORD","common"));
			if(i==true)
			{
				flagch=true;
			}											    
			else
			{
			    flagch=false;
			}
	}
										   
															 

	 if(flagch)
	{
      this.document.forms[0].method = 'POST';
	  this.document.forms[0].action='../../servlet/eXH.AdminOraJobExcepToXLServlet?flag='+flag+'&proc_id='+obj+'&action='+action;  
	  this.document.forms[0].submit();
	}
	
}										      

function runProcess(select_option,run_job,what,interval,next_process)
{		
	document.forms[0].job.value=run_job;
	document.forms[0].interval.value=interval;
	document.forms[0].process_id.value=select_option;		       
	document.forms[0].what.value=what;  			   
	document.forms[0].proc_date.value=next_process; 
	document.forms[0].actionduplicate.value='E'; 
	//document.forms[0].action.value='R';	    
	document.forms[0].method='get';	//post		    
	document.forms[0].target='messageFrame'; 
	document.forms[0].action='../../servlet/eXH.XHAdminOracleJobProcessServlet?action=R';  
	this.document.forms[0].submit();
}

function validateFromDate(obj,toDate)
{
	fromDate = obj.value;
	toDate = toDate.value;	

	if(fromDate != '')
	{
		var flag = validDate(fromDate,'DMYHMS','en');	

		if(flag == true)
		{				
			flag = isAfterNow(fromDate,'DMYHMS','en');				
			if(flag != true)
			{
				flag = true;
				if(toDate != '')
				{
					flag = isAfter(fromDate,document.forms[0].toDate.value,'DMYHMS','en');						
					if(flag != true)
					{
						flag = true;
					}
					else flag = false;
				}
			}
			else
			{
				flag = false;
			}
		}
		if(flag == false) 
		{
			alert("Invalid");
			obj.focus();
		}
	}	
}

function validateToDate(fromDate,obj)
{
	fromDate = fromDate.value;
	toDate = obj.value;	

	if(toDate != '')
	{
		var flag = validDate(toDate,'DMYHMS','en');	

		if(flag == true)
		{				
			flag = isAfterNow(toDate,'DMYHMS','en');				
			if(flag != true)
			{
				flag = true;
				if(fromDate != '')
				{
					flag = isAfter(document.forms[0].fromDate.value,toDate,'DMYHMS','en');						
					if(flag != true)
					{
						flag = true;
					}
					else flag = false;
				}
			}
			else
			{
				flag = false;
			}
		}
		if(flag == false)
		{
			alert("Invalid");
			obj.focus();
		}
	}	
}
