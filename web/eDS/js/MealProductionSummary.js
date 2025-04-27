//ML-MMOH-CRF-0680 for Meal Production Summary 
function run()
{  
		var frm=f_query_rep.document.forms[0];
	 	var isMenuType=frm.isMenuType.value;		
		var kitchen = getLabel("eOT.Kitchen.Label","ot");
		var p_facility_id = frm.p_facility_id.value;
		var facility_id = frm.facility_id.value;
		var p_user_name = frm.p_user_name.value;
		var p_module_id = frm.p_module_id.value;
		var p_report_id = frm.p_report_id.value;
		var p_language_id = frm.p_language_id.value;
		var p_order_type = frm.OrderType.value;
		var P_KITCHEN_CODE = frm.kitchen.value;
		var converDate = frm.servingDate.value;
		var PARAM1 = frm.servingDate.value;
		var sysdate=getCurrentDate("DMH",'en');
		var datepattrn = frm.datepattrn.value;
		var locale = frm.locale.value;
		var p_meal_class = frm.mealClass.value;
		var p_meal_type = frm.mealType.value;
		var p_diet_type = frm.dietType.value;
        	if(isMenuType == "true"){
			var p_menu_type = frm.menu_type.value;
		}
		else{
			var p_menu_type = "";
		}
		if(isMenuType == "true"){
			if(p_menu_type.length<1){
			alert(getMessage("DS_MENU_TYPE","DS"));
			return false;
			}
	    }
       
		/*if((P_KITCHEN_CODE.length<1) &&((p_order_type == "")||(p_order_type == "IP")||(p_order_type == "OP")||(p_order_type == "EM"))){
		 //alert(kitchen+" cannot be empty");
		// return false;
			
		}else if((p_order_type == "ST")&&(P_KITCHEN_CODE.length<1)){
		}*/
		if(PARAM1.length<1){
			alert(getMessage("DS_PROD_DATE","DS"));
			return false;
		}
	    if(PARAM1 < sysdate){
			alert(getMessage("DS_MEAL_PROD","DS"));
			return false;
		}
		
		frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_order_type="+p_order_type+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_meal_class="+p_meal_class+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_menu_type="+p_menu_type;
		frm.submit();
		
}


function reset()
{
	location.reload();
}

function setFieldToUpperCase(obj)
{
		obj.value = obj.value.toUpperCase();
		return obj;
}

function checkAlpha(event)
{
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);
		if (strCheck.indexOf(key) != -1) return false;
		return true ;
}

function onSuccess()
{
		
		var params = document.forms[0].params.value;
		commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?&'+params;
		at_tab_frame.location.reload();
}

function checkDateValidate(da1)
{
	if(CheckDate(da1)==true)
	{
			var today = new Date();
			var mon = today.getMonth()+1;
			var da = today.getDate()+"/"+mon+"/"+today.getYear();
			if(da1.value!="" && da!="")
			{
				var chkDtVal = chkDt1Dt2(da,da1.value);
				if(!chkDtVal){
					var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArray = msg.split("#");
					var theatre_label = getLabel("eOT.ServingDate.Label","OT");
					var current_label = getLabel("Common.CurrentDate.label","common");
					alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
					return false;
				}
			}
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

function isValidDate(obj)
{
		if(obj.value!=""){
			var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);

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

function cal_error (str_message,obj) 
{
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
}

function chkDt1Dt2(d1,d2)
{
		var d1Arr = d1.split("/");
		var d2Arr = d2.split("/");
		if(parseInt(d2Arr[2])<parseInt(d1Arr[2])){
			return false;
		}
		else if(parseInt(d2Arr[2])==parseInt(d1Arr[2])){
			if(parseInt(d2Arr[1])<parseInt(d1Arr[1])){
					return false;
			}
			else if(parseInt(d2Arr[1])==parseInt(d1Arr[1])){
				if(parseInt(d2Arr[0])<parseInt(d1Arr[0])){
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
function enableDisableField()
{
	var OrderType=document.getElementById("OrderType").value;
	if(OrderType=="OP"||OrderType=="EM"){
		
		 document.getElementById("mealClass").disabled = true;	 
	     document.getElementById("mealClass").value = "";	
	}
	else if(OrderType == "IP" || OrderType =="ST" || OrderType == ""){
		document.getElementById("mealClass").disabled = false;	 
	}
	
}
function enableKitchen(){
	var OrderType=document.getElementById("OrderType").value;
	if(OrderType == "ST"){
		document.getElementById("kitchen").disabled = true;	
		document.getElementById("kitchen").value ="";
	}
	else if (OrderType == ""||OrderType=="OP"||OrderType=="EM"|| OrderType =="IP"){
		document.getElementById("kitchen").disabled = false;	
	}
}
