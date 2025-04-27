var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";
var request_flag = "N";
var item_flag = "N";
var fm_retVal = "";


function reset(){
	f_query_add_mod.location.reload();
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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
		document.forms[0].document.getElementById("id_item_desc").innerHTML = arr[1];//Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532
	}
	enable_Batch_Button();
}

async function searchCodeStore(obj) {
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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
		document.forms[0].document.getElementById("id_store_desc").innerHTML = arr[1];//Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532
	}
	
}



function run(){       
		var formObj=  f_query_add_mod.document.formItemLabelCriteriaByBatch;

		
				if(formObj.all_batch_search.checked == false && formObj.fm_expiry_date.value == "" && formObj.fm_batch_id.value == "") {
					var doIt= confirm('Do you want to print All Labels?');
					if(doIt){
						formObj.all_batch_search.checked = true;
						formObj.batch_search_from.disabled = true;
						formObj.all_batch_search.value = 'A';
						//formObj.submit();
					}
					else{
					return false;
					}
				}

			var arrayObject = new Array(formObj.P_no_labels);
			var names = new Array(getLabel("eST.NoofCopies.label","ST"));
			var blankObject = checkFields1(arrayObject, names, messageFrame);

			if (blankObject == true)
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			    f_query_add_mod.document.forms[0].target="messageFrame";
				formObj.submit();		
	}
function checkFields1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else{
			var msg_1=getLabel("Common.Cannotbeblank.label", "Common");
			errors +=" APP-000001 "+  names[i] +"   "+msg_1 + "<br>" ;
		}
    }
    if ( errors.length != 0 ) {
        
		/*var expand_value;
		var type_value;
		var buttonobj_value;
buttonobj_value=parent.parent.frames[0].document.forms[0].home;
parent.parent.parent.frames[1].expand_val.expandState=0;
if(parent.parent.parent.frames[1].expand_val.expandState=="0")
		{
		parent.parent.parent.frames[1].expand(buttonobj_value,type_value,"cm");
		}
		var expand =parent.parent.parent.frames[1].expand_val.expandState;*/
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
       return false ;
		//alert(parent.parent.parent.frames[1].type_val.value);

//	if(parent.parent.frames[0].document.forms[0].home.value=="")
    }
    return true ;
}

function enable_Batch_Button() {
	document.formItemLabelCriteriaByBatch.batch_search_from.disabled = false;
}


function disable_Batch_Button() {
	if(document.formItemLabelCriteriaByBatch.all_batch_search.checked == true) {	
	document.formItemLabelCriteriaByBatch.all_batch_search.value = 'A';
	document.formItemLabelCriteriaByBatch.batch_search_from.disabled = true;
	document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_bl").innerHTML = "";
	document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_bt").innerHTML = "";
	document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_el").innerHTML = "";
	document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_et").innerHTML = "";
	document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_2").innerHTML = "";
	}
	else {
		document.formItemLabelCriteriaByBatch.all_batch_search.value = 'I';
		document.formItemLabelCriteriaByBatch.batch_search_from.disabled = false;
	}
}

function callBatchSearch() {

	var formObj = document.formItemLabelCriteriaByBatch;

	formObj.all_batch_search.checked = false;
	formObj.all_batch_search.value = 'I';

	var fromitemcode = document.formItemLabelCriteriaByBatch.p_fm_item_code.value;
		var store_code = document.formItemLabelCriteriaByBatch.p_fr_str_code.value
		var item_code =  document.formItemLabelCriteriaByBatch.p_fm_item_code.value
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var batch_retval = "";
		batch_retval = callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		
		if (batch_retval == null) {
			return;
		}
		var arr_vals = new Array();
		if (batch_retval.length > 0) {
			arr_vals = batch_retval.split("`");
			for (var i = 0; i < 16; i++) {
				var fm_batch_id = arr_vals[0];
				var fm_item_code = arr_vals[1];
				var fm_item_desc = arr_vals[2];
				var fm_store_code = arr_vals[3];
				var fm_store_desc = arr_vals[4];
			//fm_trade_id_applicable_yn=arr_vals[5];
				var fm_expiry_date = arr_vals[6];
				var fm_bin_location_code = arr_vals[7];
				var fm_bin_desc = arr_vals[8];
				var fm_trade_id = arr_vals[9];
				var fm_trade_name = arr_vals[10];
				var fm_qty_on_hand = arr_vals[11];
				var fm_nod = arr_vals[12];
				var fm_manufacturer_id = arr_vals[13];
				var fm_manufacturer_name = arr_vals[14];
				var fm_avail_qty = arr_vals[15];
				var fm_expiry_yn = arr_vals[16];

			}
		}
		if (batch_retval != "") {
			var temp_exp_date_label;
			temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");

			document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_bl").innerHTML = getLabel("Common.BatchID.label", "Common");
			document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_bt").innerHTML = ""+"<b>" + fm_batch_id + "</b>";
			document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;"+"<b>" + fm_expiry_date + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") +  "&nbsp;&nbsp;"+"<b>"+fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;";
			document.formItemLabelCriteriaByBatch.document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") +"&nbsp;&nbsp;"+ "<b>" + fm_bin_desc + "</b>";
			
			
			document.formItemLabelCriteriaByBatch.fm_expiry_date.value = fm_expiry_date;
			document.formItemLabelCriteriaByBatch.fm_batch_id.value = fm_batch_id;
			
								
		}
		
}
//Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532 beg
function clearDesc(){
	if(document.forms[0].p_fr_str_code.value==""){
    document.getElementById("id_store_desc").innerHTML ="";
	}
	if(document.forms[0].p_fm_item_code.value==""){
    document.getElementById("id_item_desc").innerHTML ="";
	}
}
//Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532 end

