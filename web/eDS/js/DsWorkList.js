function reset() {
	  var formObj = parent.content.f_query_rep.WorkListForm;
	  formObj.reset();
	  //location.reload();
	 }

function run(){

	var flag =checkNull();
		if(flag==true){

			var formObj=parent.content.f_query_rep.WorkListForm;
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

			var kitchenAreaFrom = formObj.kitchenAreaFrom.value;
			var kitchenAreaTo = formObj.kitchenAreaTo.value;

			var mealTypeFrom = formObj.mealTypeFrom.value;
			var mealTypeTo = formObj.mealTypeTo.value;

			var WardCodeFrom = formObj.WardCodeFrom.value;
			var WardCodeTo = formObj.WardCodeTo.value;

			var DietTypeFrom = formObj.DietTypeFrom.value;
			var DietTypeTo = formObj.DietTypeTo.value;

			var MealClassFrom = formObj.MealClassFrom.value;
			var MealClassTo = formObj.MealClassTo.value;

			var ItemTypeFrom = formObj.ItemTypeFrom.value;
			var ItemTypeTo = formObj.ItemTypeTo.value;

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
			"&locale="+locale+"&param1="+fromDate+"&p_kitchen_code="+kitchen+"&param3="+mealTypeFrom+"&param5="+WardCodeFrom+"&param6="+WardCodeTo+"&param7="+DietTypeFrom+"&param8="+DietTypeTo+"&param9="+MealClassFrom+"&param10="+MealClassTo+"&param13="+kitchenAreaFrom+"&param14="+kitchenAreaTo+"&param4="+mealTypeTo+
			"&param11="+ItemTypeFrom+"&param12="+ItemTypeTo;
			formObj.submit();
		}

}



function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.WorkListForm;

 	var kitchen=formObj.Kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	var fromDate=formObj.DsDate.value;
 	var from_label=getLabel("Common.date.label","Common");

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