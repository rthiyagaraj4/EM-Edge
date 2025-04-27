
async function showFood(obj,target){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.FoodItem.Label","ot");
	var sql="select A.food_item_code code,A.short_desc description from ds_food_item_lang_vw A where A.eff_status = 'E' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.food_item_code) like upper(?) order by 2";
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[1];
		target.value=arr[0];
	}else{
		target.value="";
		obj.value="";
		}
	}

async function showLookup(obj,target){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.reasonComplaints.Label","ot");
	var sql="select A.COMPLAINT_CODE code,A.short_desc description from DS_COMPLAINTS_LANG_VW A where A.eff_status = 'E' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.COMPLAINT_CODE) like upper(?) order by 2";
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[1];
		target.value=arr[0];
	}else{
		target.value="";
		obj.value="";
		}
	}

function run(){
	var flag =checkNull();
	if(!checkTODate())
		return false;
		if(flag==true){

			var formObj=parent.content.f_query_rep.MealItemRejection;
			var p_module_id = formObj.p_module_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var fromDate=convertDate(formObj.from.value,"DMY",locale,"en");
			var toDate = convertDate(formObj.to.value,"DMY",locale,"en");

			var mealType = formObj.mealType.value;
			var dietType = formObj.dietType.value;
			var foodDes = formObj.foodDes.value;
			var patientId = formObj.patientId.value;
			var reasonDes = formObj.reasonDes.value;
			var groupBy = formObj.groupBy.value;
			var p_report_id="";
			if(groupBy=="A")
			{
			p_report_id="DSRMREGA";
			}
			else if(groupBy=="R"){
			   p_report_id="DSRMREGR";
			}else if(groupBy=="F"){
			  p_report_id="DSRMREGF";
			}else if(groupBy=="P"){
			   p_report_id="DSRMREGP";
			}else if(groupBy=="W"){
			   p_report_id="DSRMREGW";
			}

			var Kitchen = formObj.Kitchen.value;
			formObj.action="../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_facility_id="+p_facility_id+"&p_report_id="+p_report_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+"&locale="+locale+"&param1="+fromDate+"&param2="+toDate+"&param4="+mealType+"&param5="+dietType+"&param7="+foodDes+"&param3="+patientId+"&param8="+reasonDes+"&param9="+groupBy+"&param6="+Kitchen;
			formObj.submit();
		}

}
// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset() {
	 var formObj = parent.content.f_query_rep.MealItemRejection;
	  formObj.reset();
	 //location.reload();
	 }
//added by N Munisekhar on 12-June-2013 against [IN39996]
	function checkTODate()
	{
 		var formObj=parent.content.f_query_rep.MealItemRejection;
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

function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.MealItemRejection;

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
