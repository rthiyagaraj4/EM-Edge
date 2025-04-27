

var function_id='';
var message='';
var result;
/*****************************************************************/
function apply(){
	
	var frmObj=frames[1].document.forms[0];
	
	var fields = new Array (frmObj.cancel_leave_reason);			    
	var names = new Array (getLabel("Common.reason.label","Common"));		
	if(checkFields( fields, names, messageFrame))
	{
	  frmObj.submit();
	}
	
}
/*****************************************************************/
function checkIsValidForProceed(){
	var url = frameQueryResult.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/******************************************************************/
function onSuccess(){
	var frmObj=frameRecordStaffUnavailabilityCriteria.document.forms[0];
	frmObj.reset();
	frameRecordStaffUnavailabilityCriteria.location.href='../../eRS/jsp/RecordStaffUnavailabilityCriteria.jsp?callmode=M';
}
/******************************************************************/
function reset(){
	frames[1].location.href='../../eRS/jsp/RecordStaffUnavailabilityCriteria.jsp?callmode=M';
	frames[2].location.href='../../eCommon/jsp/error.jsp';
}
/************************************************************************/
function listStaff(target ) { 
	var frmObj=parent.frameRecordStaffUnavailabilityCriteria.document.forms[0];

	var url='../../eRS/jsp/SearchStaff.jsp?mode=call';
	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog(url,arguments,features);
	if(retVals !=null){
		target.value=retVals[0];
		frmObj.staff_name.value=retVals[1];
		frmObj.role_type.value=retVals[2];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eRS/jsp/RecordStaffUnavailabilityGetStaffDetails.jsp?role_type="+retVals[2]+"&staff_id="+retVals[0], false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		alert(responseText);
		eval(responseText);
		
	}
}
/***********************************************************************/
function addDesc(staff,position){
	
	
	var frmObj=parent.frameRecordStaffUnavailabilityCriteria.document.forms[0];
	if((staff=='')||(staff==null))
		staff='-';
	if((position=='')||(position==null))
		position='-';
	frmObj.staff_type.value=staff;
	frmObj.position.value=position;
}
/***********************************************************************/
function display(staf_name, role,position,staf_type){
	
	var frmObj=parent.frameRecordStaffUnavailabilityCriteria.document.forms[0];
	
	var role_type=frmObj.role_type.value;
	var staff_name=frmObj.staff_name.value;
	var position_desc=frmObj.position.value;
	var staff_type=frmObj.staff_type.value;
	if(role_type=='P')
		role.innerText='   Practitioner';
	else if(role_type=='O')
		role.innerText='   Other Staff';
	staf_name.innerText='    '+staff_name;
	position.innerText='   '+position_desc;
	staf_type.innerText='   '+staff_type;
}
/*****************************************************************/
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}
/***********************************************************************/
function checkDateRange(obj){
	var frmObj=document.forms[0];
	var fromDate = frmObj.from_date;
	var toDate = frmObj.to_date;
	if(!doDateCheck(fromDate,toDate,parent.messageFrame)){
		obj.select();
		obj.focus();
	}
}
/*************************************************************/
function checkFromDate(){
	var frmObj=document.forms[0];
	var from =frmObj.from_date;
	var today = frmObj.sys_date;
	var fromdate = from.value;
	var todaydate = today.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt =parent.frames[1].getMessage("FROM_DATE_LESS_SYSDATE","RS") ; 
			//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			alert(invaldt);
			from.select();
			from.focus();
		}
		var toDate = frmObj.to_date;
		if(toDate.value != ''){
			if(!doDateCheck(from,toDate,parent.messageFrame)){
				frmObj.to_date.select();
				frmObj.to_date.focus();
			}
		}
	}
}
/*************************************************************/
function checkToDate(){
	var frmObj=document.forms[0];
	var to =frmObj.to_date;
	var today = frmObj.sys_date;
	var todate = to.value;
	var todaydate = today.value;
	var toarray;
	var todayarray;
	if(todate.length > 0 && todaydate.length > 0){
		toarray = todate.split("/");
		todayarray = todaydate.split("/");
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var todaydt = new Date(todayarray[2],todayarray[1],todayarray[0]);
		if(Date.parse(todaydt) > Date.parse(todt)){
			var invaldt =parent.frames[1].getMessage("TO_DATE_LESS_SYSDATE","RS") ; 
			//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			alert(invaldt);
			to.select();
			to.focus();
		}else{
			var fromDate = frmObj.from_date;
			if(fromDate.value != ''){
				if(!doDateCheck(fromDate,to,parent.messageFrame)){
					frmObj.to_date.select();
					frmObj.to_date.focus();
				}
			}
		}
	}
}
/*************************************************************/
function on_close()
{
  window.returnValue='CnlLC';
  window.close();
}
/***********************************************************************/
function on_apply()
{	
  var formObj=document.form_ManageWorkScheduleCancelLeave;


  if(trimString(formObj.cancel_leave_reason.value)=="")
      {

		alert(getMessage("REASON_BLANK","RS"));
		
        return false;
       }
	   
		 
	   var conf="";
	  
	   
	   
		if(formObj.cancel_leave_YN.value == 'Y')
			{
			 formObj.submit();
			 formObj.cancel_leave_YN.value == 'N';
			
			 conf = confirm(getMessage('CANCEL_LEAVE_ALLOCATE','RS'));
				
		
				if(conf)
				{
				
				   window.returnValue='CnlL';
				   window.close();
				}else
				{
					window.returnValue='CnlLC';
					window.close();
				}
			}
}



function chk_value()
{
	var Chk_YN=document.form_ManageWorkScheduleCancelLeave.cancel_leave_YN.value;

if(Chk_YN=='N')
document.form_ManageWorkScheduleCancelLeave.cancel_leave_YN.value='Y';
else
document.form_ManageWorkScheduleCancelLeave.cancel_leave_YN.value='N';
}




/*************************************************************************************/

