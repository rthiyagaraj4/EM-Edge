
function run(){
	var flag =checkNull();
		if(flag==true){

			var formObj=parent.content.f_query_rep.MenuforDietType;
	     	var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var kitchen = formObj.Kitchen.value;
			var dietTypeFrom=formObj.dietTypeFrom.value;
			var dietTypeTo=formObj.dietTypeTo.value;
			var mealClassFrom=formObj.mealClassFrom.value;
			var mealClassTo=formObj.mealClassTo.value;
			var dayRefCodeFrom=formObj.dayRefCodeFrom.value;
			var dayRefCodeTo=formObj.dayRefCodeTo.value;

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+kitchen+"&param1="+dietTypeFrom+"&param2="+dietTypeTo+"&param3="+mealClassFrom+"&param4="+mealClassTo+"&param5="+dayRefCodeFrom+"&param6="+dayRefCodeTo+"&LOCALE="+p_language_id;
			formObj.submit();
		}

}

function reset() {
	  var formObj = parent.content.f_query_rep.MenuforDietType;
	  formObj.reset();
	  //location.reload();
	 }


function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.MenuforDietType;

 	var kitchen=formObj.Kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	if(kitchen=="") {

 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
 }