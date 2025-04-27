function reset() {
	  var formObj = parent.content.f_query_rep.CommercialFormulaDistributionList;
	  formObj.reset();
	  //location.reload();
	 }
async function getLookupDetail(obj,target){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.CommercialFormula.Label","ot");
	var sql="SELECT C.COMM_FORMULA_CODE CODE,C.SHORT_DESC DESCRIPTION FROM DS_COMM_FORMULA_LANG_VW C WHERE C.LANGUAGE_ID = '"+locale+"' AND  UPPER(C.SHORT_DESC) LIKE UPPER(?) AND UPPER(C.COMM_FORMULA_CODE) LIKE UPPER(?) AND C.EFF_STATUS ='E'";
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

			var formObj=parent.content.f_query_rep.CommercialFormulaDistributionList;
			//alert(formObj.p_module_id.value);

			var p_module_id = formObj.p_module_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var fromDate=convertDate(formObj.from.value,"DMY",locale,"en");
			var toDate=convertDate(formObj.to.value,"DMY",locale,"en");

			var kitchen = formObj.Kitchen.value;
			var kitchenAreaFrom = formObj.kitchenAreaFrom.value;
			var kitchenAreaTo = formObj.kitchenAreaTo.value;
      
      // commented by marwan for EDGE work - sending code instead of decription
			// var itemCodeHiddenFrom = formObj.itemCodeHiddenFrom.value;
			// var itemCodeHiddenTo = formObj.itemCodeHiddenTo.value;
      var itemCodeFrom = formObj.itemCodeFrom.value;
			var itemCodeTo = formObj.itemCodeTo.value;
      
			var mealTypeFrom = formObj.mealTypeFrom.value;
			var mealTypeTo = formObj.mealTypeTo.value;
			var WardCodeFrom = formObj.WardCodeFrom.value;
			var WardCodeTo = formObj.WardCodeTo.value;
			var Reporttype = formObj.Reporttype.value;


			var p_report_id = "";
			var report_id = "";

			if(Reporttype=="S")
			{
			p_report_id="DSRCFDST";
			report_id="DSRCFDST";
			}
			else
			{
			p_report_id="DSRCFKAL";
			report_id="DSRCFKAL";
			}

			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
			"&locale="+locale+"&param1="+fromDate+"&param10="+toDate+"&p_kitchen_code="+kitchen+"&param2="+kitchenAreaFrom+"&param3="+kitchenAreaTo+"&param6="+itemCodeFrom+"&param7="+itemCodeTo+
			"&param4="+mealTypeFrom+"&param5="+mealTypeTo+"&param8="+WardCodeFrom+"&param9="+WardCodeTo+"&Reporttype="+Reporttype;
			formObj.submit();
		}

}
function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.CommercialFormulaDistributionList;

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

	//IN::39996
 function checkTODate()
	{
 		var formObj=parent.content.f_query_rep.CommercialFormulaDistributionList;
		var fromDate= formObj.from.value;
		var toDate= formObj.to.value;
	
		var d1Arr = fromDate.split("/");
		var d2Arr = toDate.split("/");
		var errMsg = ' To Date should be Greater than or equal to From Date';
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
