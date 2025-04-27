var function_id='';
var message='';
var result;
/*****************************************************************/
function apply(){

	var frmObj=frames[1].document.forms[0];
	var frmObj1=frames[2].document.forms[0];
	var call_mode=frmObj.call_mode.value;
	
	var fields = new Array (frmObj.staff_id);			    
	var names = new Array (getLabel("eRS.StaffId.label","RS"));		
	if(frameRecordStaffUnavailabilityCriteria.checkFields( fields, names, messageFrame))
	{
	if (compareLeaveRecords())
	{
		frmObj1.from_date.value = frmObj.from_date.value
		frmObj1.to_date.value = frmObj.to_date.value
		frmObj1.reason.value = frmObj.reason.value
		frmObj1.role_type.value = frmObj.role_type.value
		frmObj1.call_mode.value = frmObj.call_mode.value
		frmObj1.submit();
	}
	


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
	staffCancelLeaveFrame.location.href='../../eCommon/html/blank.html';
}
/******************************************************************/
function reset(){
	frames[1].location.href='../../eRS/jsp/RecordStaffUnavailabilityCriteria.jsp?callmode=M';
	frames[2].location.href='../../eCommon/html/blank.html';
	frames[3].location.href='../../eCommon/jsp/error.jsp';
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
	displayCancelLeaveDtls();
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
			var invaldt =parent.frames[1].getMessage("FROM_DATE_GREATER_SYSDATE","RS") ; 
			//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			alert(invaldt);
			from.select();
			from.focus();
			from.value="";
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
			var invaldt =parent.frames[1].getMessage("TO_DATE_GREATER_SYSDATE","RS") ; 
			//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			alert(invaldt);
			to.select();
			to.focus();
			to.value="";
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
  window.close();
}
/***********************************************************************/
function on_apply()
{	
  var formObj=document.form_RecordStaffUnavailabilityCriteria;
 
  var message="";
  if(formObj.reason.value=="")
      {
        message=getMessage("REASON_BLANK","RS");
		alert(message);
        return false;
       }
           formObj.submit();
}
/*************************************************************************************/
function displayCancelLeaveDtls() // this method is used to display cancel leave details for the particular staff id
{

  
  var staffId =document.forms[0].staff_id.value;
  if(staffId !=null){	
	parent.document.frames[2].location.href="../../eRS/jsp/RecordStaffUnavailabilityCancelLeaveDtls.jsp?staff_id="+staffId;	
	
	}
	}

/*************************************************************************************/
function setCancelLeaveCheck(obj,index){
formObj = "parent.frames[2].document.forms[0].leaveReasonList_";
checkAllObj = parent.frames[2].document.forms[0].checkAll;

if (obj.checked)
{
	obj.value = "Y";
	eval(formObj+index).disabled = false;
}
else
{
	obj.value = "N";
	eval(formObj+index).disabled = true;
	eval(formObj+index).value = '';
	checkAllObj.checked = false;
}


}
/*************************************************************************************/
function setAllCancelLeavechecks(obj,index){
formObj1 = "parent.frames[2].document.forms[0].checkCancelLeave_";
for(i = 0; i< index; i++){
	if (obj.checked)
	{
		obj.value = "Y";
		eval(formObj1+i).checked = true;
		setCancelLeaveCheck(eval(formObj1+i),i);

	}
	else
	{
		obj.value = "N";
		eval(formObj1+i).checked = false;
		setCancelLeaveCheck(eval(formObj1+i),i);
	}	
}
}
/*************************************************************************************/
/*This method is used to validate the fields before apply.or before submitting the form .  */
function compareLeaveRecords(){ 
cancelDatesIndex = frames[2].document.forms[0].totalRows.value;
labelObj = "frames[2].document.forms[0].date_";
checkboxObj = "frames[2].document.forms[0].checkCancelLeave_";
fromDate=frames[1].document.forms[0].from_date; 
toDate=frames[1].document.forms[0].to_date; 
leaveReason=frames[1].document.forms[0].reason; 
cancelLeaveReason="frames[2].document.forms[0].leaveReasonList_"; 
msg = "";
msg1="";
msg2 ="";
msg3 ="";
msg4 ="";
returnMessage ="";
var leaveDateArray;
var toDateArray;
var fromDateArray;

for (i=0;i<cancelDatesIndex ;i++ )
{
	if((eval(checkboxObj+i).checked) && (eval(cancelLeaveReason+i).value ==''))
	{ //"Reason for Cancel Leave cannot be balnk when Cancel is Selected";
	
     messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("REASON_CANCEL_LEAVE_CANNOT_BE_BLANK","RS");
	 return false;

	}
}

if (fromDate.value != '' && toDate.value != '')
{
  if (leaveReason.value == '')
  {
	 // alert("Reason Cannot be blank");	
	  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("REASON_BLANK","RS");
	  return false; 	 
  }
}

if (fromDate.value != '')
{
if (toDate.value == '')
{
	msg1="error";
}
else
{
for (i = 0;i < cancelDatesIndex;i++ )
{
  date = eval(labelObj+i).value;
  checkboxValue = eval(checkboxObj+i).value
  leaveDateArray = date.split("/");
  toDateArray = toDate.value.split("/");
  fromDateArray = fromDate.value.split("/");

  var leavedDateObject = new Date(leaveDateArray[2], (leaveDateArray[1] - 1), leaveDateArray[0]);
  var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
  var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
  if (Date.parse(leavedDateObject) == Date.parse(fromDateObject) && checkboxValue == 'N')
  {
	  msg ="error:";
	  break;
  }
  else if(Date.parse(leavedDateObject) == toDate.value && checkboxValue == 'N')
	{
	  msg ="error:";
	  break;
	}
  else if((Date.parse(leavedDateObject) >= Date.parse(fromDateObject) && Date.parse(leavedDateObject) <= Date.parse(toDateObject)) && checkboxValue == 'N')
	{
	  msg ="error:";
	  break;
	}
	
}
}

if (msg != '')
{
	///"Leave Cannot be recorded as duplicates found";
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("LEAVE_CANNOT_BE_RECORDED","RS");
	frames[1].document.forms[0].from_date.focus();
	return false;
}
else if (msg1 != '')
{
	 //"Leave Period To Cannot be blank";
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("LEAVE_TO_CANNOT_BE_BLANK","RS");	
	frames[1].document.forms[0].to_date.focus();
	return false;
}
}
else if (toDate.value != '')
{
if (fromDate.value == '')
{
	msg3="error";
}
else
{
for (i = 0;i < cancelDatesIndex;i++ )
{
  date = eval(labelObj+i).value;
  checkboxValue = eval(checkboxObj+i).value
  if (date == toDate.value && checkboxValue == 'N')
  {
	  msg2 ="error";
	  break;

  }
}
}

if (msg2 != '')
{
	//alert("Leave Cannot be recorded as duplicates found");
	frames[1].document.forms[0].from_date.focus();
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("LEAVE_CANNOT_BE_RECORDED","RS");
	
	return false;
}
else if (msg3 != '')
{
	//alert("Leave Period From Cannot be blank");
	frames[1].document.forms[0].from_date.focus();
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("LEAVE_FROM_CANNOT_BE_BLANK","RS");
	return false;
}
}
if ((fromDate.value == '') && (toDate.value == ''))
{
	if ((leaveReason.value != ''))
	{
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("LEAVE_FROM_TO_CANNOT_BE_BLANK","RS");
	return false;
	}
}


if ((fromDate.value == '') && (toDate.value == '')&&(leaveReason.value == ''))
{
	
if (cancelDatesIndex > 0)
{
 for (i=0;i<cancelDatesIndex ;i++ )
{
	 
	 
	if((eval(checkboxObj+i).value == 'N')) 
	{
	  returnMessage = "error";
	}
	else
	{
	    returnMessage = "";
		break;
	}
}
}
else 
	 returnMessage = "error";
}

if (returnMessage != '')
{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return false;
}
else
	return true;
	





}
/*************************************************************************************/
