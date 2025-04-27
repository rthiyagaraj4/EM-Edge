//Created for KDAH-CRF-0350

function submitForm() {
		var frm=document.forms[0];
		var servDate = frm.servDate.value;
		var error="";		
		if(servDate == ""){		
                        error=getMessage("DS_SERVDAT_NOT_BLANK","DS");		    
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			parent.query_result.location.href="../../eCommon/html/blank.html";
			alert(error);			
		}else{		
		var PatientClass=getLabel("Common.patientclass.label","common");
		var patient_Class = frm.Patient_Class.value;
	    var kitchenCode = frm.kitchenCode.value;
	    var MealType = frm.MealType.value;
	    var DietCategory = frm.DietCategory.value;
	    var MealClass = frm.MealClass.value;
	    var DietType = frm.DietType.value;
		parent.query_result.location.href="../../eDS/jsp/KitchenOrderTicketQueryResult.jsp?patient_Class="+patient_Class+"&serv_Date="+servDate+"&kitchenCode="+kitchenCode+"&MealType="+MealType+"&DietCategory="+DietCategory+"&MealClass="+MealClass+"&DietType="+DietType;
			}
}

function submitForm1(){

	var frm=document.forms[0];
	var servDate = frm.servDate.value;
	var error="";		
	if(servDate == "")
	{		
		error=getMessage("DS_SERVDAT_NOT_BLANK","DS");		    
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.query_result.location.href="../../eCommon/html/blank.html";
		alert(error);
		return false;	
		}else{		
		var patient_Class = frm.Patient_Class.value;
		var kitchenCode = frm.kitchenCode.value;
		var MealType = frm.MealType.value;
		var DietCategory = frm.DietCategory.value;
		var MealClass = frm.MealClass.value;
		var DietType = frm.DietType.value;
		var p_facility_id = frm.p_facility_id.value;
		var p_user_name = frm.p_user_name.value;
		var p_report_id = frm.p_report_id.value;
		var p_module_id = frm.p_module_id.value;	
			
		var params = "p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_serving_date="+servDate+"&p_kitchen_code="+kitchenCode+"&p_meal_type="+MealType+"&p_order_type="+patient_Class+"&p_diet_cat_code="+DietCategory+"&p_meal_class="+MealClass+"&p_diet_type="+DietType;		
		frm.action="../../eCommon/jsp/report_options.jsp?"+params;		
		frm.submit();	
		}		
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
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

function getSysDate(){
	var locale = document.getElementById("locale").value
	var currentTime = new Date()
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;
	sysDate = day+"/"+month+"/"+year;
	document.forms[0].servDate.value = sysDate;
	document.forms[0].currentDate.value = sysDate;
}

function reset(){
	f_query_add_mod.location.href="../../eDS/jsp/KitchenOrderTicketQuery.jsp";
}

function callclear()
{
	var formObj = document.forms[0];
	formObj.HLongRefWdId.value="";
	formObj.wardDesc.value="";
	formObj.wardClinic_code.value="";
}

//Added Against Start ML-MMOH-CRF-1006-US4
function changeMealType(){
	var patient_class=document.getElementById("Patient_Class").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getMealTypeForCat&patient_class="+patient_class;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var dum = retVal_arr[i].split(":::");
		var meal_type_code= dum[0];
		var meal_type_desc= dum[1];
		if(meal_type_desc!=undefined)
		selObj += "<OPTION value='" + meal_type_code + "'>" + meal_type_desc + "</OPTION>";
	}
	var selectStart = "<select id='MealType' name='MealType' id='MealType'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select>";
	selObj= selObj + selectEnd;
	document.getElementById("MealTypeTD").innerHTML = selObj;
}

function changeDietType(){
	var patient_class=document.getElementById("Patient_Class").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getDietTypeValues&patient_class="+patient_class;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var dum = retVal_arr[i].split(":::");
		var diet_type_code= dum[0];
		var diet_type_desc= dum[1];
		if(diet_type_desc!=undefined)
		selObj += "<OPTION value='" + diet_type_code + "'>" + diet_type_desc + "</OPTION>";
	}
	var selectStart = "<select id='DietType' name='DietType' id='DietType'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select>";
	selObj= selObj + selectEnd;
	document.getElementById("dietTypeTD").innerHTML = selObj;
}
//Added Against End ML-MMOH-CRF-1006-US4

