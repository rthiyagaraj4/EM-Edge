

function run(){
	var flag = FoodCheckNull();
	if(flag==true){
		var formObj=parent.content.f_query_rep.NewAdmissionList;
		//alert(formObj.p_module_id.value);

		var p_module_id = formObj.p_module_id.value;
		var p_report_id = formObj.p_report_id.value;
		var p_facility_id = formObj.p_facility_id.value;
		var p_user_name = formObj.p_user_name.value;
		var facility_id = formObj.facility_id.value;
		var locale = formObj.locale.value;
		var datepattrn = formObj.datepattrn.value;
		var report_id = formObj.report_id.value;

		var date = formObj.date.value;
		var kitchen = formObj.kitchen.value;

		parent.content.f_query_rep.NewAdmissionList["P_ADMISSION_DATE"].value = date;
		parent.content.f_query_rep.NewAdmissionList["P_KITCHEN_CODE"].value = kitchen;

		formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
		"&locale="+locale+"&p_admission_date="+date+"&p_kitchen_code="+kitchen;
		formObj.submit();
	}
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;

		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function FoodCheckNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.NewAdmissionList;
 	//alert("formObj--"+formObj);

 	var date=formObj.date.value;
 	var date_label=getLabel("Common.date.label","Common");

 	var kitchen=formObj.kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	if(date=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",date_label)+"<br>";
 	}
 	if(kitchen=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
}
// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset(){
var formObj = parent.content.f_query_rep.NewAdmissionList;
formObj.reset();
	//parent.frames[1].location.reload();
}
