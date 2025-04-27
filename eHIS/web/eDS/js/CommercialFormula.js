

function getCommFormList(){
	var formObj = parent.frames[1].document.forms[0];
	var commFormulakitchenValue = formObj.Kitchen.value;
	var facility_id = document.getElementById("p_facility_id").value;
	/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlstr = "<root><SEARCH  /></root>";
  var xmlHttp = new XMLHttpRequest()
	var xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
  //xmldoc.loadXML(xmlstr);
	xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=getCommFormList&commFormulakitchenValue="+commFormulakitchenValue+"&facility_id="+facility_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal!=''){
		var retValArr = retVal.split("???");
		var kitchenArea = "";
		var primary_id =   formObj.kitchenAreaFrom;
		var secondary_id = formObj.kitchenAreaTo;
		var listOption1	= document.createElement('OPTION');
		var listOption2	= document.createElement('OPTION');
		var msg = "----select----"
		listOption1.text = msg;
		listOption2.text = msg;
		listOption1.value= "";
		listOption2.value= "";

		if(retValArr!=''){
			for(var i=0; i<retValArr.length; i++){
				kitchenArea = retValArr[i].split(":::");
				var listOption1	= document.createElement('option');
				var listOption2	= document.createElement('option');
				var msg = "----select----"
				listOption1.text = msg;
				listOption2.text = msg;
				listOption1.value= "";
				listOption2.value= "";

				listOption1.value = kitchenArea[1];
				listOption1.text = kitchenArea[0];

				listOption2.value = kitchenArea[1];
				listOption2.text  = kitchenArea[0];
				primary_id.add(listOption1);
				secondary_id.add(listOption2);
			}
		}
	}
}
// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset(){
	  var formObj = parent.content.f_query_rep.CommercialFormulaList;
	  formObj.reset();
	 }

async function showLookup(mode){
	var formObj = parent.frames[1].document.forms[0];
	var itemCodeTo= formObj.itemCodeTo.value;
	var itemCodeFrom=formObj.itemCodeFrom.value;
	var itemCodeHiddenFrom=formObj.itemCodeHiddenFrom;
	var itemCodeHiddenTo=formObj.itemCodeHiddenTo;

	var locale = document.getElementById("language_id").value;


	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql = "SELECT C.COMM_FORMULA_CODE CODE,C.SHORT_DESC DESCRIPTION FROM DS_COMM_FORMULA_LANG_VW C WHERE C.LANGUAGE_ID = '"+locale+"' AND  UPPER(C.SHORT_DESC) LIKE UPPER(?) AND UPPER(C.COMM_FORMULA_CODE) LIKE UPPER(?) AND C.EFF_STATUS ='E'";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";

	if(mode=="Primary_Food_ItemCode"){
		argumentArray[5] = itemCodeFrom;
	}
	else if(mode == "Secondary_Food_ItemCode"){
		argumentArray[5]=itemCodeTo;
	}
	// Link Description
	argumentArray[6] = DESC_LINK;
	//Display Order
	argumentArray[7] = DESC_CODE;

	// Lookup will return code and description - retArr hold it
	var retVal = await CommonLookup("Commercial Formula Attendant List", argumentArray);

	if(retVal!=null && retVal != ""){
		retVal=unescape(retVal);
		var retArr=retVal.split(",");

		if(mode=="Secondary_Food_ItemCode"){
			formObj.itemCodeTo.value=retArr[1];
			itemCodeHiddenTo.value=retArr[0];
		}
		else if(mode == "Primary_Food_ItemCode"){
			formObj.itemCodeFrom.value=retArr[1];
			itemCodeHiddenFrom.value=retArr[0];
		}
	}
}


function getLookupDetail(mode){
	var formObj = parent.frames[1].document.forms[0];
	var itemCodeFrom = formObj.itemCodeFrom;
	var itemCodeTo = formObj.itemCodeTo;
	if(mode == "lookUp_From"){
		if(itemCodeFrom != ""){
			showLookup('Primary_Food_ItemCode');
		}
	}else if(mode == "lookUp_To"){
		if(itemCodeTo != ""){
			showLookup('Secondary_Food_ItemCode');
		}
	}
}


function run(){

	var flag =checkNull();
	if(!checkTODate())
		return false;
		
		if(flag==true){

			var formObj=parent.content.f_query_rep.CommercialFormulaList;
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

			var fromDate = formObj.from.value;
			var toDate = formObj.to.value;
			var kitchen = formObj.Kitchen.value;
			var kitchenAreaFrom = formObj.kitchenAreaFrom.value;
			var kitchenAreaTo = formObj.kitchenAreaTo.value;
			var itemCodeHiddenFrom = formObj.itemCodeHiddenFrom.value;
			var itemCodeHiddenTo = formObj.itemCodeHiddenTo.value;
			var mealTypeFrom = formObj.mealTypeFrom.value;
			var mealTypeTo = formObj.mealTypeTo.value;

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
			"&locale="+locale+"&PARAM1="+fromDate+"&PARAM8="+toDate+"&P_KITCHEN_CODE="+kitchen+"&PARAM2="+kitchenAreaFrom+"&PARAM3="+kitchenAreaTo+"&PARAM4="+itemCodeHiddenFrom+"&PARAM5="+itemCodeHiddenTo+
			"&PARAM6="+mealTypeFrom+"&PARAM7="+mealTypeTo;
			formObj.submit();
		}

}

function localTrimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}
/*
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
}*/

//added by N Munisekhar on 12-June-2013 against [IN39996]
	function checkTODate()
	{
 		var formObj=parent.content.f_query_rep.CommercialFormulaList;
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
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.CommercialFormulaList;
 	var kitchen=formObj.Kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

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
 	if(kitchen=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
 	//alert("error"+error);
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
 }
