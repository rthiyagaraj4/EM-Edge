function submitForm() {
		var frm=document.forms[0];
		
		//var fields = new Array (frm.kitchen_Code,frm.nursing_Unit);//Commented Against 57812
		var fields = new Array (frm.kitchen_Code);//Added Against 57812
		var kitchenCode=getLabel("eOT.Kitchen.Label","ot");
		var wardCode=getLabel("eOT.WardCode.Label","ot");

		var kitchen = frm.kitchen_Code.value;
		var nursingUnit = frm.nursing_Unit.value;
		var servDate = frm.servDate.value;
		//var names = new Array ( kitchenCode,wardCode);//Commented Against 57812
		var names = new Array ( kitchenCode);//Added Against 57812
		
		if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
			{	
				parent.query_result.location.href="../../eDS/jsp/MealCensusQueryResult.jsp?kitchen_code="+kitchen+"&ward_code="+nursingUnit+"&serv_Date="+servDate;			
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
	var conDate=convertDate(sysDate,'DMY','en',locale) ;
	document.forms[0].servDate.value = conDate;
}
async function showDetailRecord(obj){
	var enc = 'encounterHdn'+obj;
	var mealtype = 'mealTypeHdn'+obj;
	var servingDate = 'servingDate'+obj;
	
	var encounterId = document.getElementById(enc).value;
	var meal_Type = document.getElementById(mealtype).value;
	var serving_Date = document.getElementById(servingDate).value;
	
	var formObj = document.forms[0];
	var parameters = "encounter_id="+encounterId+"&meal_type="+meal_Type+"&serving_Date="+serving_Date;
	  var dialogHeight= "30" ;
	  var dialogWidth = "40" ;
	  var dialogTop = "10" ;
	  var status = "no";
	  var arguments = "" ;
	  var features = "dialogHeight:" + dialogHeight +  "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	  var retVal = await window.showModalDialog("../../eDS/jsp/MealCensusPopup.jsp?"+parameters,arguments,features);

}

function query() {
		f_query_add_mod.location.href="../../eDS/jsp/MealCensusQuery.jsp";
}	

 function reset(){
		f_query_add_mod.location.href="../../eDS/jsp/MealCensusQuery.jsp";
}

//Added Against ML-MMOH-CRF-1063 Starts Here
var scrollValue=0;
var reorder = '';
var anchorID =''; 

function callOrderBy(object,kitchenCode,wardCode,servDate){	
	var url='&orderBy='+object+'&reOrder='+reOrder+'&anchorID='+anchorID+'&kitchen_code='+kitchenCode+'&ward_code='+wardCode+'&serv_Date='+servDate;	  
	parent.query_result.location.href='MealCensusQueryResult.jsp?'+url;
}       	
	
function changeColor(object)
{
	anchorID=object.id;		
	if(object.style.color=='white')
  {
	reOrder='1';		
	object.style.color='pink';
	return;
  }
	if(object.style.color=='pink')
  {
	reOrder='2';
	object.style.color='yellow';
	return;
  }
	if(object.style.color=='yellow')
  {
	reOrder='1';
	object.style.color='pink';
	return;
  }
}
//Added Against ML-MMOH-CRF-1063 Ends Here
