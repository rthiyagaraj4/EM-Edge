/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
10/01/2018 				 IN061893			Kamalakannan G  	10/01/2018  		Ramesh G 		ML-MMOH-CRF-0545
17/01/2018 				 IN066342			Kamalakannan G  	17/01/2018  		Ramesh G 		ML-MMOH-CRF-0545
17/01/2018 				 IN066341			Kamalakannan G  	17/01/2018  		Ramesh G 		ML-MMOH-CRF-0545
17/01/2018 				 IN066344			Kamalakannan G  	17/01/2018  		Ramesh G 		ML-MMOH-CRF-0545
19/01/2018 				 IN066359			Kamalakannan G  	19/01/2018  		Ramesh G 		ML-MMOH-CRF-0545
--------------------------------------------------------------------------------------------------------------------------------------------
*/
var resultGlobal		= false;//IN66344   
var invalidCode			= null;
var messageGlobal = "" ;
var flagGlobal = true;
function PatientLookup()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	//eval("document.all."+str+".focus();");
	document.getElementById(str).focus();
	return flg;
}
function chkDateTime(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("date_from");
		var to_date = document.getElementById("date_to");
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				chkToDate(from_date,to_date,format,locale);
			}
		}
	}
}
function chkToDate(fromDate,toDate,format,locale)
{	
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); //Date cannot be greater than system date
			//fromDate.select();
			fromDate.value="";
			fromDate.focus();
			return false;
				
		}else
		{ 
		  if( toDate.value != "")
			{
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); //To Date should be greater than or equal to From date
						//toDate.select();
						toDate.value="";
						toDate.focus();
						return false;
					}
				}
				else
				  {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					//toDate.select();
					toDate.value="";
					toDate.focus();
					return false;
				  }
			}
		}
	}else
	{		
		if((toDate.value!=""))
		{
		  if(!isBeforeNow(toDate.value, format, locale))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				//toDate.select();
				toDate.value="";
				toDate.focus();
				return false;
			}
		}
	}
}
function clickAll(obj) {
	var count =eval("parent.resultframe.rejected_order_result.count.value");
	for(var i=0; i<count; i++){
			var test=eval("document.rejected_order_result.select"+i);
			obj.checked==true?(test.type=="checkbox"? (test.checked=true,test.value='Y'):(test.checked=false,test.value='N')):(test.checked=false,test.value='N');
	}
	}
function clearAll() {
	var count =eval("parent.resultframe.rejected_order_result.count.value");
	for(var i=0; i<count; i++){
			var test=eval("parent.resultframe.rejected_order_result.select"+i);
		if(test.checked=true){
			test.checked=false,test.value='N';
		}
	}
	parent.resultframe.rejected_order_result.check_all.checked=false;//IN066342
	}
function populateResult()
{
	var patientId 	= parent.rejectorders.rejectorders.patientId;
	var date_from 	= parent.rejectorders.rejectorders.date_from;
	var date_to   	= parent.rejectorders.rejectorders.date_to;
	var ordcat      = parent.rejectorders.rejectorders.ordcat.value;
	var ca_practitioner_id = parent.rejectorders.rejectorders.ca_practitioner_id.value;
	if(date_from.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","From Date");	
		alert(msg);
		date_from.focus();
		return;
	}
	if(date_to.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","To Date");
		alert(msg);
		date_to.focus();
		return;
	}
	if(date_from.value==""||date_to.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		date_from.value==""?(msg.replace("$","From Date"),fromDate.focus()):(msg.replace("$","To Date"),fromDate.focus());
		alert(msg);
		return;
	}
	if(date_to.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","To Date");
		alert(msg);
		date_to.focus();
		return;
	}
	var params = '?date_from='+date_from.value+'&date_to='+date_to.value+'&patientId='+patientId.value+'&ordcat='+ordcat+'&ca_practitioner_id='+ca_practitioner_id;
	parent.resultframe.location.href = '../../eOR/jsp/RejectedOrdersSearchResult.jsp'+params;
	parent.rejectOrdersButtonFrame.location.href = '../../eOR/jsp/RejectedOrderbtnframeset.jsp'+params;
}
function clearValues()
{
	document.rejectorders.reset();	
	parent.resultframe.location.href="../../eCommon/html/blank.html";
	parent.rejectOrdersButtonFrame.location.href="../../eCommon/html/blank.html";
}
async function Remarks(count)
{
	var remarks=eval("document.rejected_order_result.remarks"+count+".value");
	var rej_pract_name=eval("document.rejected_order_result.rej_pract_name"+count+".value");
	var reject_date_time=eval("document.rejected_order_result.reject_date_time"+count+".value");
	var params = '?remarks='+encodeURIComponent(remarks)+'&rej_pract_name='+rej_pract_name+'&reject_date_time='+reject_date_time;//IN66359 added encodeURIComponent for remarks
	var url     = "../../eOR/jsp/RejectedRemarks.jsp"+params;
    var dialogLeft   = "750px";
    var dialogHeight    = "12vh" ; 
    var dialogWidth = "29vw" ;//IN066359
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogLeft:" + dialogLeft + "; status: no" ;
    var returnval = await window.showModalDialog( url, arguments, features ) ;
    return returnval;
}
function reviewOrder(){
	var count =eval("parent.resultframe.rejected_order_result.count.value");
	var yesCount=0;
	for(var i=0; i<count; i++){
		var checkvalue=eval("parent.resultframe.rejected_order_result.select"+i+".value");
		if(checkvalue=='Y'){
			yesCount=1;
			break;
		}	
	}
		if(yesCount == 0)
		{

			alert(getMessage("REVIEW_ATLEAST_ONE","OR"));//added for IN066341
			return false;
		}
		eval(formApply(parent.resultframe.document.rejected_order_result,OR_CONTROLLER)) ;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+messageGlobal;
}
function clickLine(obj,rec_num){
	var checkboxCount = 0;
	var checkboxValCount = 0;
	if (obj.checked == true) {
		obj.value = 'Y';
		var count =eval("parent.resultframe.rejected_order_result.count.value");	
		for(var i=0; i<count; i++){
			var test=eval("document.rejected_order_result.select"+i);
			if(test.type=="checkbox")
				checkboxCount++;
			if(test.type=="checkbox" && test.value=='Y')
				checkboxValCount++;
		}
		if(checkboxCount==checkboxValCount)
			document.rejected_order_result.check_all.checked=true;
	} else {
		document.rejected_order_result.check_all.checked=false;
		obj.value = 'N';
	}
}
function assignResult(_result , _message, _flag, invCode){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}
function modal_close(){
	parent.window.close();
}
