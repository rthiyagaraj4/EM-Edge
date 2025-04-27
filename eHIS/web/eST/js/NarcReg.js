var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";

function reset() 
{
	formObj=f_query_add_mod.document.NarcRegCriteria;
	
	formObj.reset();

}

function checkMonYear() {
	formObj = f_query_add_mod.document.NarcRegCriteria;
	var p_from_year = formObj.p_from_year.value;
	var p_to_year = formObj.p_to_year.value;
	var p_from_month = formObj.p_from_month.value;
	var p_to_month = formObj.p_to_month.value;
	var curr_proc_year = formObj.curr_proc_year.value;
	var curr_proc_month = formObj.curr_proc_month.value;
	var fromPeriod = parseFloat(formatNumber(p_from_year, 4) + formatNumber(p_from_month, 2));
	var toPeriod = parseFloat(formatNumber(p_to_year, 4) + formatNumber(p_to_month, 2));
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	if ((formObj.p_from_year.value.length != 4) || (formObj.p_from_year.value.length != 4)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-SM0038 Invalid Year. Enter Year in 'YYYY' Format";;
		return false;
	} else {
		if ((formObj.p_from_month.value > 12) || (formObj.p_from_month.value > 12) || (formObj.p_from_month.value < 1) || (formObj.p_from_month.value < 1)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-SM0038 Invalid Month. Enter between  '1 to 12'";
			return false;
		} else {
			if (fromPeriod > toPeriod) {
				var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
				stMessage = stMessage.replace(/@/g, "Month/Year");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
				return false;
			} else {
				if (toPeriod > currPeriod) {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("CANNOT_BE_GT_CURR_PERIOD", "ST");
					return false;
				}
			}
		}
	}
	return true;
}
function formatNumber(number, length) {
	var returnNumber = "" + number;
	if (isNaN(returnNumber)) {
		returnNumber = "0";
	}
	var numberLength = length - returnNumber.length;
	for (i = 0; i < numberLength; i++) {
		returnNumber = "0" + returnNumber;
	}
	return returnNumber;
}


/*function checkDateMonYear(){

   formObj=f_query_add_mod.document.NarcRegCriteria;
   if (formObj.p_from_year.value.length != 4 || formObj.p_to_year.value.length != 4 ) 
   {
	   messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-SM0038 Invalid Year. Enter Year in 'YYYY' Format";//Invalid Year Format";
	   return false;
   }
   if (formObj.p_from_month.value > 12 || formObj.p_to_month.value > 12 )
   {
	   alert();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-SM0038 Invalid Month. Enter between  '1 to 12'";//Invalid Month Format";
	 return false;   
   }
 
	  var pmonthfrm=formObj.p_from_month.value;
	  var pmonthto=formObj.p_to_month.value;
	   if(formObj.p_from_month.value > 0 && formObj.p_from_month.value < 10 &&pmonthfrm.length < 2){
			var fm_month = "0"+formObj.p_from_month.value;
		}
		if(formObj.p_to_month.value > 0 && formObj.p_to_month.value < 10 &&pmonthto.length < 2){
			var to_month = "0"+formObj.p_to_month.value;
		}
		else{
			var fm_month = formObj.p_from_month.value;
		}
          var tomonth=formObj.p_to_month.value;
            var frmmonth =formObj.p_from_month.value
            tomonth = formObj.p_to_year.value+tomonth;
             frmmonth =formObj.p_from_year.value+frmmonth;
	//alert(frmmonth+tomonth);
	if(frmmonth <= tomonth  ){
		 
		return true;
	}else{
			
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"APP-ST0123 From Month/Year can not be Greater than The To Month/Year";//Should be Less than Current month";
			 return false;
		}
	
  
   return true;
}*/

function run()
{       
    var formObj=f_query_add_mod.document.NarcRegCriteria;	
	var fields = new Array ( formObj.p_str_code,formObj.p_item_code,formObj.p_from_month,formObj.p_from_year,formObj.p_to_month,formObj.p_to_year);
	var names = new Array ( "Store","Item","From Month","From Year","To Month","To Year");
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	var blankObj	=	null;
	blankObject		=	checkSTFields( fields, names, messageFrame,errorPage);
	
			
	if(blankObject){
		var p_from_year = formObj.p_from_year.value;
		var p_to_year = formObj.p_to_year.value;
		var p_from_month = formObj.p_from_month.value;
		var p_to_month = formObj.p_to_month.value;
		if((p_from_year.length>0) || (p_to_year.length>0) || (p_from_month.length>0) ||(p_to_month.length>0) )
		{ 		
		if(checkMonYear())		
		{
		formObj.submit();
		 return;
		}
		}else 
		{
		formObj.submit();	
}
}
}

async function searchCodeStore( obj) {
var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	} 
}

async function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}


function callItemSearchScreen () {
	var search_string="";
search_string=document.getElementById("p_item_code").value;


	var store_code=document.getElementById("p_str_code").value;
	var category ="A";
	var sole_source ="A";
	var ps_item ="A";
	var mfg_item ="A";
	var expiry ="A";
	var consignment ="A";
//	var havingqty="Y";
/* Added on 09/21/2007 by Ram
		chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores.
		 If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it.
		 */
	var chkitemstorecmb ="N";
	//here specifically we can add the item_class as narcotics
	var item_class ="";
	var retVal=callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment,chkitemstorecmb,"");
	if(retVal==undefined || retVal==null)
     document.getElementById("p_item_code").value="";
    
	if(retVal!=null)
	{	
	
		document.getElementById("p_item_code").value=retVal[0];
	
         if(store_code=="")
           document.getElementById("p_str_code").value=retVal[20];
	
	}

}
//Added by Rabbani #Inc no:31929 on 27/03/2012 Starts
function Pfrmmnth(){
formObj =  document.NarcRegCriteria;
	var p_from_month = formObj.p_from_month.value;
	var p_to_month = formObj.p_to_month.value;
	 
	if(p_from_month < 1 || p_from_month > 12){
	alert(getMessage("INVALID_MONTH_FMT", "SM"));
	
	setTimeout(function() {
		//document.getElementById('shift_hours').focus(); // Focus on the
		formObj.p_from_month.select();
		formObj.p_from_month.focus();												// field after alert
	}, 0);
	
	
	return;
	}
}
function Ptomnth(){
formObj =  document.NarcRegCriteria;
	var p_to_month = formObj.p_to_month.value;
	if(p_to_month < 1 || p_to_month > 12){
	alert(getMessage("INVALID_MONTH_FMT", "SM"));
	setTimeout(function() {
		//document.getElementById('shift_hours').focus(); // Focus on the
		formObj.p_to_month.select();
		formObj.p_to_month.focus();												// field after alert
	}, 0);
	
	return;
	}

}
function Pfrmyear(){
        formObj =  document.NarcRegCriteria;
	    var p_from_year = formObj.p_from_year.value;
		 if(p_from_year == 0 || p_from_year == 00 || p_from_year == 000 || p_from_year == 0000 ){
		alert(getMessage("INVALID_YEAR_FORMAT", "SM"));
		setTimeout(function() {
			//document.getElementById('shift_hours').focus(); // Focus on the
			 formObj.p_from_year.select();
			 formObj.p_from_year.focus();											// field after alert
		}, 0);

	   return;
	  } 
}
function Ptoyear(){
        formObj =  document.NarcRegCriteria;
	    var p_to_year = formObj.p_to_year.value;
		 if(p_to_year == 0 || p_to_year == 00 || p_to_year == 000 || p_to_year == 0000 ){
		alert(getMessage("INVALID_YEAR_FORMAT", "SM"));
		setTimeout(function() {
			//document.getElementById('shift_hours').focus(); // Focus on the
			formObj.p_to_year.select();
		    formObj.p_to_year.focus();										// field after alert
		}, 0);
		
		
	   return;
	  } 
}
//ends


