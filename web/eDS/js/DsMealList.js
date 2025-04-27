function reset() {
	  var formObj = parent.content.f_query_rep.MealListForm;
	  formObj.reset();
	  //location.reload();
	 }

function run(){

	var flag =checkNull();
		if(flag==true){

			var formObj=parent.content.f_query_rep.MealListForm;
			//alert(formObj.p_module_id.value);

			var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var fromDate=convertDate(formObj.DsDate.value,"DMY",locale,"en");
			var kitchen = formObj.Kitchen.value;
			var mealTypeFrom = formObj.mealTypeFrom.value;


			var WardCodeFrom = formObj.WardCodeFrom.value;
			var WardCodeTo = formObj.WardCodeTo.value;

			var DietTypeFrom = formObj.DietTypeFrom.value;
			var DietTypeTo = formObj.DietTypeTo.value;

			var MealClassFrom = formObj.MealClassFrom.value;
			var MealClassTo = formObj.MealClassTo.value;

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_language_id="+p_language_id+"&facility_id="+facility_id+
			"&locale="+locale+"&param1="+fromDate+"&p_kitchen_code="+kitchen+"&param4="+mealTypeFrom+"&param7="+WardCodeFrom+"&param8="+WardCodeTo+"&param2="+DietTypeFrom+"&param3="+DietTypeTo+"&param5="+MealClassFrom+"&param6="+MealClassTo;
			formObj.submit();
		}

}
function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.MealListForm;

 	var fromDate=formObj.DsDate.value;
 	var from_label=getLabel("Common.date.label","Common");

	var kitchen=formObj.Kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	if(fromDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",from_label)+"<br>";
 	}

 	if(kitchen=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
 	//alert("error"+error);
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
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