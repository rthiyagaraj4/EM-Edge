

function run(){

	var flag =checkNull();
	if(!checkTODate())
		return false;
		if(flag==true){

			var formObj=parent.content.f_query_rep.DietTypeMovement;
			var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var fromDate=convertDate(formObj.from.value,"DMY",locale,"en");
			var toDate = convertDate(formObj.to.value,"DMY",locale,"en");
			var wardCode = formObj.wardCode.value;
			var dietTypeFrom = formObj.dietTypeFrom.value;
			var dietTypeTo = formObj.dietTypeTo.value;
			var patientId=formObj.patientId.value;

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
			"&locale="+locale+"&param1="+fromDate+"&param2="+toDate+"&param7="+wardCode+"&param5="+dietTypeFrom+"&param6="+dietTypeTo+"&param3="+patientId;
			formObj.submit();
		}

}


function reset() {
	  var formObj = parent.content.f_query_rep.DietTypeMovement;
	  formObj.reset();

	 }

	  function checkForSpecCharsforID(event)
	{
	    var strCheck = '0123456789/';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);
	    if (strCheck.indexOf(key) == -1) return false;
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
	//added by N Munisekhar on 12-June-2013 against [IN39996]
	function checkTODate()
	{
 		var formObj=parent.content.f_query_rep.DietTypeMovement;
		var fromDate= formObj.from.value;
		var toDate= formObj.to.value;
	
		var d1Arr = fromDate.split("/");
		var d2Arr = toDate.split("/");
		var errMsg = 'To Date should be Greater than or equal to From Date';
		if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){
			alert(errMsg);
			return false;
		}
		else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
			if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
					alert(errMsg);
					return false;
			}
			else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
				if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
					alert(errMsg);
					return false;
				}
				else{
					return true;
				}
			}
			else{
				return true;
			}
		}
		else{
			return true;
		}
	} 
//End of  [IN39996]
function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.DietTypeMovement;


 	var fromDate=formObj.from.value;
 	var from_label=getLabel("Common.from.label","Common");

 	var toDate=formObj.to.value;
 	var to_label=getLabel("Common.to.label","Common");

 	if(fromDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",from_label)+"<br>";
 	}
 	if(toDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",to_label)+"<br>";
 	}

 	//alert("error"+error);
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
 }
async function callSearchScreen()
{
	var patientid = await PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
	document.forms[0].patientId.value = patientid;
	document.forms[0].patientId.focus();
}
