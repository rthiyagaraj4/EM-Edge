function submitForm() {
		var frm=document.forms[0];
		
		var fields = new Array (frm.kitchen_Code,frm.meal_Type);
		var kitchenCode=getLabel("eOT.Kitchen.Label","ot");
		var mealType=getLabel("eOT.MealType.Label","ot");

		var kitchen = frm.kitchen_Code.value;
		var meal_type = frm.meal_Type.value;
		var servDate = frm.servDate.value;
		var names = new Array ( kitchenCode,mealType);
		if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
			{	
				parent.query_result.location.href="../../eDS/jsp/MealStatisticsQueryResult.jsp?kitchen_code="+kitchen+"&meal_Type="+meal_type+"&serv_Date="+servDate;
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
}

 function reset(){
		f_query_add_mod.location.href="../../eDS/jsp/MealStatisticsQuery.jsp";
}
