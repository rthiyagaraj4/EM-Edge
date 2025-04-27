


function run()
{
	var flag = AttendMealCheckNull();
	if(!checkTODate())
		return false;
	if(flag==true)
	{
		var formObj = parent.content.f_query_rep.AttendMealList;

		var p_module_id = formObj.p_module_id.value;
		var p_report_id = formObj.p_report_id.value;
		var p_facility_id = formObj.p_facility_id.value;
		var p_user_name = formObj.p_user_name.value;
		var p_language_id = formObj.p_language_id.value;
		var facility_id = formObj.facility_id.value;
		var locale = formObj.locale.value;
		var report_id = formObj.report_id.value;

		var kitchen = formObj.kitchen.value;
		var fromDate = formObj.dateFrom.value;
		var toDate = formObj.dateTo.value;
		var wardCFrom = formObj.wardCodeFrom.value;
		var wardCTo = formObj.wardCodeTo.value;
		var mealClassFrom = formObj.mealClassFrom.value;
		var mealClassTo = formObj.mealClassTo.value;
		var dietTypeFrom = formObj.dietTypeFrom.value;
		var dietTypeTo = formObj.dietTypeTo.value;

// start MMS-QH-CRF-0190
		var param ="p_module_id="+p_module_id+
							"&p_report_id="+p_report_id+
							"&p_facility_id="+p_facility_id+
							"&p_user_name="+p_user_name+
							"&facility_id="+facility_id+
							"&locale="+locale+
							"&PARAM5="+fromDate+
							"&PARAM6="+toDate+
							"&p_kitchen_code="+kitchen+
							"&PARAM1="+wardCFrom+
							"&PARAM2="+wardCTo+
							"&mealClassFrom="+mealClassFrom+
							"&mealClassTo="+mealClassTo+
							"&dietTypeFrom="+dietTypeFrom+
							"&dietTypeTo="+dietTypeTo;
		formObj.action= "../../eCommon/jsp/report_options.jsp?"+param;
// end MMS-QH-CRF-0190
		formObj.submit();
	}
}

function AttendMealCheckNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.AttendMealList;
 	//alert("formObj--"+formObj);

 	var kitchen=formObj.kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	var fromDate=formObj.dateFrom.value;
 	var from_label=getLabel("Common.from.label","Common");

 	var toDate=formObj.dateTo.value;
 	var to_label=getLabel("Common.to.label","Common");

 	if(fromDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",from_label)+"<br>";
 	}
 	if(toDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",to_label)+"<br>";
 	}
 	if(kitchen=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
 	//alert("error"+error);
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
}
// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset(){
 var formObj = parent.content.f_query_rep.AttendMealList;
	  formObj.reset();
	//parent.frames[1].location.reload();
}
//added by N Munisekhar on 12-June-2013 against [IN39996]
	function checkTODate()
	{
 		var formObj=parent.content.f_query_rep.AttendMealList;
		var fromDate= formObj.dateFrom.value;
		var toDate= formObj.dateTo.value;
	
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
	//End of  [IN39996]
