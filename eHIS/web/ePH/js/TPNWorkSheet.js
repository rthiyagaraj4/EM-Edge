var function_id		= "PH_TPN_WORKSHEET";
var result			= false;
var message			= "";
var flag			= "";
var target_obj		= "";
var record_values	= new Array();
var allow_rec_ws	= "Y";
var precipAlertAtRcrd = "";

function callCancel() {
	window.returnValue = 'NO';
	window.close();
}

function assignAtRcrd(precipAlerts){
	precipAlertAtRcrd = precipAlerts;
}

function callRecordWS(pres_qty) {
	var frmObj			=	parent.f_query_add_mod.document.formTPNWorkSheetDetails;	
	var rec_cnt			=	parseInt(frmObj.row_count.value);
	var labelText		=	'';
	var batchId			=	'';
	var expDate			=	'';
	var allocUom		=	'';
	var issueUom		=	'';
	var allow_record_worksheet    =	'';
    var qty				= parent.frames[1].document.forms[0].fluid_volume.value
	var ordered_volume_overage = parent.frames[1].document.forms[0].ordered_volume_overage.value;
    var allow_record_worksheet = true;
	var error_confirm		   = true;
	if(parseInt(qty)<=0){
		alert(getMessage("PREP_VOL_LES_PRES_VOL","PH"));
		return false;
	}
	if(parseInt(qty)>parseInt(ordered_volume_overage)){
		error_confirm		   = true;
        allow_record_worksheet = confirm(getLabel("ePH.Prepvolisdiffthanordvolyouwanttocont.label","PH"))				
	}
	else{
//		alert("Preparation volume is less than prescrbed volume, possible chance of precipitation..");
		alert(getMessage("PREP_VOL_LES_PRES_VOL","PH"));
		
	/*	for(var i=3;i<=9;i++){
			if(eval("frmObj.ISSUE_QTY_"+i).value != ''){
				checkPrecipitation(eval("frmObj.ISSUE_QTY_"+i),frmObj.order_id.value,i,frmObj);
//					break;
			}
		}*/

		var bean_id					= frmObj.bean_id.value;
		var bean_name				= frmObj.bean_name.value;
		var ovrge_ordrd_volume		= document.formTPNWorkSheetButtons.ordered_volume_overage.value;

		var item_code_obj			= "";
		var cp_obj					= "";
		var order_qty_obj			= "";
		var const_generic_code_obj	= "";
		var alloc_qty_obj			= "";
		var alloc_qty_uom_obj		= "";
		var issue_qty_obj			= "";
		error_confirm				= true;

		var xmlStr ="<root><SEARCH " ;
		for(var i=3;i<=9;i++){
			item_code_obj			= eval("frmObj.ITEM_"+i);
			order_qty_obj			= eval("frmObj.OVERAGE_ORDER_QTY_"+i);
			const_generic_code_obj	= eval("frmObj.CONST_GENERIC_CODE_"+i);
			alloc_qty_obj			= eval("frmObj.ALLOC_QTY_"+i);
			alloc_qty_uom_obj		= eval("frmObj.ALLOC_QTY_UM_"+i);
			issue_qty_obj			= eval("frmObj.ISSUE_QTY_"+i);

			if(item_code_obj != undefined){
				xmlStr += item_code_obj.name+"=\""+ item_code_obj.value +"\" " ;
				xmlStr += order_qty_obj.name+"=\""+ order_qty_obj.value +"\" " ;
				xmlStr += const_generic_code_obj.name+"=\""+ const_generic_code_obj.value +"\" " ;
				xmlStr += alloc_qty_obj.name+"=\""+ alloc_qty_obj.value +"\" " ;
				xmlStr += alloc_qty_uom_obj.name+"=\""+ alloc_qty_uom_obj.value +"\" " ;
				xmlStr += issue_qty_obj.name+"=\""+ issue_qty_obj.value +"\" " ;
			}
		}

		xmlStr +=" /></root>" ;
//alert('xmlStr ---|'+xmlStr);

		var xmlDoc				= "";
		var xmlHttp				= new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=checkPrecipateAtRecord&bean_id="+bean_id+"&bean_name="+bean_name+"&ovrge_ordrd_volume="+ovrge_ordrd_volume, false);

		xmlHttp.send(xmlDoc);
		responseText			= xmlHttp.responseText;
//alert('responseText at 89 ----|'+responseText);
		eval(responseText);

		if(precipAlertAtRcrd.length >0){
			var precip_indi   = "";
			var precip_from	  = "";
			var precip_to	  = "";
			var precip_alert  = "";
			var show_alert	  = "";
			var precip_msgs = 	precipAlertAtRcrd.split("||");
			
			for(var i=0;i<precip_msgs.length;i++){
				precip_indi   = '';
				show_alert	  = '';
				error_confirm = true;
				var const_message = precip_msgs[0].split("$");
					precip_indi	  = const_message[0];
					precip_from	  = const_message[1];
					precip_to	  = const_message[2];
					precip_alert  = const_message[3];
					show_alert	  = precip_from+" , "+precip_to+" : "+precip_alert;

					if(precip_indi == 'W' || precip_indi == 'N'){
				//		alert(precip_mesg);
						error_confirm = confirm(show_alert);
						if(error_confirm == false){
//									eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+sel_const_no).focus();
						}
					}else if(precip_indi == 'E'){
						alert(show_alert);
						error_confirm = false;
				//		error_confirm = confirm(precip_mesg);
						//if(error_confirm == false){
//									eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+sel_const_no).focus();
						//}
					}
			}

		}
	}
	if(allow_record_worksheet){
		for (var i=0; i<rec_cnt; i++) {
			batchId=eval("parent.f_query_add_mod.document.getElementById("BATCH_")"+i+".innerText")
			if (batchId!=''){
				labelText+='BATCH_'+i+"="+batchId+'&';
			}
			expDate		=	eval("parent.f_query_add_mod.document.getElementById("EXPIRY_DATE_")"+i+".innerText");
			if (expDate!='')
			{
				labelText+='EXPIRY_DATE_'+i+"="+expDate+'&';
			}
			allocUom	=	eval("parent.f_query_add_mod.document.getElementById("ALLOC_QTY_UOM")"+i+".innerText")
			if (allocUom!='')
			{
				labelText+='ALLOC_QTY_UOM'+i+"="+allocUom+'&';
			}
			issueUom	=	eval("parent.f_query_add_mod.document.getElementById("QTY_UOM")"+i+".innerText")
			if (issueUom!='')
			{
				labelText+='QTY_UOM'+i+"="+issueUom+'&';
			}
		}
		billing_interface_yn        = parent.messageFrame.document.formTPNWorkSheetButtons.billing_interface_yn.value ;
		if(billing_interface_yn=='Y'){
		   tot_groos_pat_payable_str   = parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value ;
		   tot_gross_charge_amount_str = parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value ;
		   if(error_confirm){
			recordTPN('YES',labelText,billing_interface_yn,tot_groos_pat_payable_str,tot_gross_charge_amount_str);
		   }else{
//				alert('Precipitation Error Occured, check again..');
				alert(getMessage("PRECEP_ERR_CHK_AGN","PH"));
		   }
		}else{
			if(error_confirm){
				recordTPN('YES',labelText,billing_interface_yn); 
			}else{
//				alert('Precipitation Error Occured, check again..');
				alert(getMessage("PRECEP_ERR_CHK_AGN","PH"));
			}
		}
		
  }
}

function callFinalize() {
}

function checkIsNotZero(obj, appendObj, row_num) {
	var frmObj		= document.formTPNWorkSheetDetails;
	var group_code  = eval("frmObj.CONST_GROUP_CODE_"+row_num).value;

	if (obj.value == "0") {		
		alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
		obj.focus();
		return true;
	}else{
		//checkSplChars(obj, row_num);
		if(group_code != 'FL'){
			validNumber(obj, row_num);
		}else{
			var row_count	= document.formTPNWorkSheetDetails.row_count.value;
			var value		=	"";
			var IssueQty	=	0;
			for(k=0;k<row_count;k++){
				value=eval("frmObj.ISSUE_QTY_"+k+".value");
				if(value!=""){
					IssueQty	=	IssueQty+parseFloat(value);
				}
			}

			parent.frames[1].document.forms[0].fluid_volume.value	=	roundTwoDigits(IssueQty);	
			tot_osmo_val = parent.frames[1].document.forms[0].osmolarity_volume.value;
			var osmo_val_lt	= 0;
				osmo_val_lt	= (tot_osmo_val * 1000) / IssueQty ;
//			alert('osmo_val_lt at 84 --- '+osmo_val_lt);
			osmo_val_lt = roundTwoDigits(osmo_val_lt);
			parent.frames[1].document.forms[0].osmolarity_volume_per_ltr.value	=	osmo_val_lt;
		}
	}
}

function checkSplChars(obj, row_num) {
	if(!CheckChars(obj)) {
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return true;
	}
	else{
		validNumber(obj, row_num);
	}
}

function validNumber(obj, row_num) {

	if (obj.value != "") {
		if (CheckNum(obj)) {
			var frmObj		= document.formTPNWorkSheetDetails;
			obj				= eval("frmObj.ISSUE_QTY_"+row_num);
			obj1			= eval("frmObj.AVAIL_QTY_"+row_num);
			obj2			= eval("frmObj.ALLOC_QTY_"+row_num);
			aloc_uom		= eval("document.getElementById("ALLOC_QTY_UOM")"+row_num);
            isq				= parseInt(Math.ceil(obj.value));
			aq				= parseInt(obj1.value);
		
			if ( isq > aq ) {
				alert(getMessage("ISSUE_QTY_NOT_GREATER_ORDERED_QTY","PH"));
			     obj.focus();
				return false;
			}else {
				var value		=	"";
				var IssueQty	=	0;
				var j			=	parseInt(frmObj.row_count.value);
				var groupCode	=	eval("frmObj.CONST_GROUP_CODE_"+row_num+".value");
				var cp			=	eval("frmObj.concentration_percent_"+row_num+".value");
		
				var iss_qty = eval("frmObj.ISSUE_QTY_"+row_num).value;
				var osm_val = eval("frmObj.osmolar_value_"+row_num).value;
				var item_osm_val = roundTwoDigits((osm_val * iss_qty) / 1000) ;
				if(item_osm_val == '0.0') {
					item_osm_val="";
				}
				//		 eval("frmObj.osmolar_value_"+row_num).value = item_osm_val;
				eval("document.getElementById("osmolar_value_lb_")"+row_num).innerText = item_osm_val;

				var tot_osmo_val	= 0;
				for(k=0;k<j;k++){
					//		 		alert(eval("document.getElementById("osmolar_value_lb_")"+k+".innerText"));
					//				osmo_val = eval("frmObj.osmolar_value_"+k).value;
					osmo_val = eval("document.getElementById("osmolar_value_lb_")"+k+".innerText");
					if(osmo_val == ''){
						osmo_val = 0
					}
					tot_osmo_val = tot_osmo_val+parseFloat(osmo_val);
				}
				tot_osmo_val = roundTwoDigits(tot_osmo_val);
				parent.frames[1].document.forms[0].osmolarity_volume.value	=	tot_osmo_val;

				for(k=0;k<j;k++)
				{	 value=eval("frmObj.ISSUE_QTY_"+k+".value");
					 if(value!=""){
						IssueQty	=	IssueQty+parseFloat(value);
					 }
				}
//				tot_osmo_val = parent.frames[2].document.forms[0].osmolarity_volume.value;
				var osmo_val_lt	= 0;
					osmo_val_lt	= (tot_osmo_val * 1000) / IssueQty ;
				//alert('osmo_val_lt at 84 --- '+osmo_val_lt);
				osmo_val_lt = roundTwoDigits(osmo_val_lt);
				parent.frames[1].document.forms[0].osmolarity_volume_per_ltr.value	=	osmo_val_lt;


				var QTY_UOM		=	eval("document.getElementById("QTY_UOM")"+row_num+".innerText;");
				parent.frames[1].document.forms[0].fluid_volume.value	=	roundTwoDigits(IssueQty);	
				
				if(parent.frames[1].document.getElementById("fluid_uom").innerText==''){
					parent.frames[1].document.getElementById("fluid_uom").innerText	=	QTY_UOM;
				}

				if (groupCode!='EL' && cp!='' && cp!=null && cp!="0"){
//					Obj1			=	eval("frmObj.ALLOC_QTY_"+row_num);
					presc_base_unit =   frmObj.presc_base_unit.value;
			
					issue_uom			=   eval("document.getElementById("QTY_UOM")"+row_num);
					issued_stock_uom	=	eval("frmObj.issued_stock_uom_"+row_num);

					if(presc_base_unit == issued_stock_uom.value){
						eval("frmObj.Eqvl_value_"+row_num+".value='1'");
					}else{	
						check1UOM(issued_stock_uom.value,presc_base_unit,row_num);
					}

					var Eqvl_value	=	parseFloat(eval("frmObj.Eqvl_value_"+row_num+".value"));

					    cp			=	parseFloat(eval("frmObj.concentration_percent_"+row_num+".value"))
					    isquantity	=	parseFloat(eval("frmObj.ISSUE_QTY_"+row_num+".value"))

				//	var alloc_qty	=   parseInt(Math.ceil(((cp/100)*(isquantity))*(Eqvl_value)));
					var alloc_qty	=   parseInt(Math.ceil((cp/100)*(isquantity)));
					var allocUOM	=   eval("document.getElementById("ALLOC_QTY_UOM_")"+row_num+".innerText;");
					var issueUOM	=   eval("document.getElementById("QTY_UOM")"+row_num+".innerText;");

					validateVariationPer1(row_num,alloc_qty,Eqvl_value);

				}
				else if(groupCode=='EL' && cp!='' && cp!=null && cp!="0")
				{
					var frmObj		= document.formTPNWorkSheetDetails;
					var order_id	= frmObj.order_id.value;
					CalPresQty(obj,order_id,row_num);
				}		
			}		  
		}
	}
}

function searchItem(target, generic_code, order_id, locn_code) {
	var frmObj		= document.formTPNWorkSheetDetails;
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	target_obj		= target;
	var xmlDoc		= "";
	var xmlHttp		= new XMLHttpRequest();

	xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&generic_code="+generic_code+"&order_id="+order_id+"&locn_code="+locn_code+"&func_mode=item_search", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

async function callBatchSearchWindow(item_code, store_code) {
	var includeZeroStockBatches	= "N";
	var includeExpiredBatches	= "N";
	var includeSuspendedBatches	= "N";
	var searchFunction			= "Y";
	var multipleSelect			= "Y";
	var dialogHeight			= "30vh";
	var dialogWidth				= "60vw";
	var dialogTop				= "100";
	var dialogLeft				= "200";
	var center					= "0";
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments				= "";
	retVal = await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect='N'", arguments, features);
	return retVal;
}

async function checkItem(item_list, locn_code, mode) {
	item_list = item_list.substring(1, (item_list.length-1))
	var items = item_list.split(",");
	if(mode == "1") {
		alert('No item');
	}
	if(mode == "2") {
		var retVal	= callBatchSearchWindow(item_list, locn_code);
		if (retVal)
			setValues(retVal);
	}
	if(mode == "3") {
		var dialogHeight	= "40vh";
		var dialogWidth		= "60vw";
		var dialogTop		= "200";
		var dialogLeft		= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		var retVal			= await window.showModalDialog("../../ePH/jsp/TPNWorkSheetChooseItem.jsp?item_list="+item_list,arguments,features);

		if(retVal) {
			retVal = callBatchSearchWindow(retVal, locn_code);

			if (retVal)
				setValues(retVal);
		}
	}
}

function defaultOthers(no,obj) {
	if (obj.value != "") {
		batch_id		= obj.value;
		item_no			= obj.selectedIndex;
		vals			= record_values[no];
		var expiry_date	= "";
		var issue_qty	= "";

		if(item_no%2==0){
			expiry_date	= vals[item_no+1];
			issue_qty	= vals[item_no+2];
		}
		else{
			expiry_date	= vals[item_no];
			issue_qty	= vals[item_no+1];
		}

		var frmObj		= document.formTPNWorkSheetDetails;
		obj				= eval("frmObj.EXPIRY_DATE_"+no);
		obj.value 		= expiry_date;
		obj				= eval("frmObj.CONST_GENERIC_CODE_"+no);
		generic_code	= obj.value;
		obj				= eval("frmObj.CONST_GROUP_CODE_"+no);
		group_code		= obj.value;
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var store_code	= frmObj.locn_code.value;
		var order_id	= frmObj.order_id.value;
		var xmlDoc		= "";
		var xmlHttp		= new XMLHttpRequest();
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=batch_dtl&batch_id="+batch_id+"&generic_code="+generic_code+"&store_code="+store_code+"&order_id="+ order_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&group_code="+group_code, false);
		xmlHttp.send(xmlDoc);
		responseText	= xmlHttp.responseText;
		eval(responseText);
	}else {
		var frmObj		= document.formTPNWorkSheetDetails;
		obj				= eval("frmObj.EXPIRY_DATE_"+no);
		obj.value 		= "";
		obj				= eval("document.getElementById("QTY_UOM")"+no);
		obj.innerText	= "";
		obj				= eval("document.getElementById("order_uom")"+no);
		obj.value		= "";
		obj				= eval("document.getElementById("ALLOC_QTY_UOM")"+no);
		obj.innerText	= "";
		obj				= eval("frmObj.AVAIL_QTY_"+no);
		obj.value 		= "";
		obj				= eval("frmObj.ISSUE_QTY_"+no);
		obj.value		= "";
		obj				= eval("frmObj.ALLOC_QTY_"+no);
		obj.value		= "";
	}
}

function displayQty(stock_uom,issue_qty,no) {	
     
	var frmObj		= document.formTPNWorkSheetDetails;
	obj				= eval("document.getElementById("QTY_UOM")"+no);
	obj.innerText	= stock_uom;
	obj				= eval("document.getElementById("order_uom")"+no);
	obj.value		= stock_uom;
	obj				= eval("document.getElementById("ALLOC_QTY_UOM")"+no);
	obj.innerText	= eval("document.getElementById("ALLOC_QTY_UOM_")"+no+".innerText");	
	obj.title		= "Equivalent Ordered Qty : " + issue_qty;
	obj.focus();
}

function clearList(docObj) {
	var len = docObj.options.length;
	for(var k=0; k<len; k++) {
		docObj.remove('BATCH_ID');
	}
	var tp = "--Select--" ;
	var opt = eval(document.createElement("OPTION")) ;
	opt.text = tp ;
	opt.value = "" ;
	docObj.add(opt);
}

function recordTPN(return_val,labelText,billing_interface_yn,tot_groos_pat_payable_str,tot_gross_charge_amount_str) {
	
	var frmObj				= parent.f_query_add_mod.document.formTPNWorkSheetDetails;
	//var overage_volume		= parent.commontoolbarFrame.document.formTPNWorkSheetHeader.overage_volume.value;
    var overage_volume		= frmObj.overage_volume.value;
	//var overage_volume_uom	= parent.commontoolbarFrame.document.getElementById("overage_uom").innerText;
    var overage_volume_uom	=parent.f_query_add_mod.document.getElementById("overage_uom").innerText;
	var osmolarity_volume	= parent.messageFrame.document.formTPNWorkSheetButtons.osmolarity_volume_per_ltr.value;

	var xmlDoc	= "";
	var xmlHttp = new XMLHttpRequest();
	var frmObjs = new Array();

	if(frmObj.name == null)
		frmObjs = frmObj;
	else
		frmObjs[0] = frmObj;

	var xmlStr ="<root><SEARCH ";
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++) {
			
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else
				{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;

			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
		}
	}
	//xmlStr+= "overage_volume  =\"" + overage_volume + "\" " ;
	xmlStr+= "overage_volume_uom  =\"" + overage_volume_uom + "\" " ;
	xmlStr+= "osmolarity_volume  =\"" + osmolarity_volume + "\" " ;
	xmlStr +=" /></root>";	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","TPNWorkSheetValidate.jsp?func_mode=rec_worksheet&"+labelText,false);
	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;
	eval(responseText);

	if(allow_rec_ws == "Y"){
		if(billing_interface_yn=='Y'){
           return_val =return_val+"::"+billing_interface_yn+"::"+tot_groos_pat_payable_str+"::"+tot_gross_charge_amount_str;
		}else{
			return_val =return_val+"::"+billing_interface_yn;
		}
		window.returnValue = return_val;
		window.close();
	}
}

function setValues(retVal,no) {
	
		var record				= retVal.split("`");	
		var item_values			= new Array();
		var pos					= 1;
		var frmObj				= document.formTPNWorkSheetDetails;	
		var i					= 0; 		
		var batch_id			= record[i];
		var item_code			= record[i+1];
		var item_name			= record[i+2];
		var store_code			= record[i+3];
		var store_desc			= record[i+4];
		var expiry_date			= record[i+6];
		var bin_locn_code		= record[i+7];
		var bin_locn_desc		= record[i+8];
		var trade_id			= record[i+9];
		var trade_desc			= record[i+10];
		var	manufacturer_code	= record[i+13];
		var manufacturer_desc	= record[i+14];
		var avail_qty			= record[i+15];	
		item_values[pos++]		= expiry_date;
		item_values[pos++]		= avail_qty;		
		record_values[no]		= item_values;
		
}

function assignItemCode(mode) {
	if (mode == "1") {
		var formObj = document.formTPNWorkSheetChooseItem.item_code;
		if (formObj.value=="") {
			alert(getLabel("ePH.ItemSelectionismandatory.label","PH"));
			return false;
		}
		else {
			window.returnValue = formObj.value;
			window.close();
		}
	}
	else if (mode == "2") {
		window.returnValue = "";
		window.close();
	}
}
function assignval(item,locn_code,no)
 {  
	
	var frmObj		= document.formTPNWorkSheetDetails;
	var row_count	=	parseInt(frmObj.row_count.value);
	var value		=	"";
	var k			=	0;
	var val			=   '';
	if(item != ''){
		val	= item.value;
	}else{
		val = eval("frmObj.ITEM_"+no).value;
	}

	if(val!=''){
		 retVal		= callBatchSearchWindow(val, locn_code);
		 if(retVal!=null && retVal!=''){
			    var record				=	new Array();
			    record					=	retVal.split("`");

				var batch_id			= record[0];
				var item_code			= record[1];
				var item_name			= record[2];
				var store_code			= record[3];
				var store_desc			= record[4];				
				var expiry_date			= record[6];
				var bin_locn_code		= record[7];
				var bin_locn_desc		= record[8];
				var trade_id			= record[9];
				var trade_desc			= record[10];
				var	manufacturer_code	= record[13];
				var manufacturer_desc	= record[14];
				var avail_qty			= record[15];				
	
	            
               

				obj						=	eval("document.getElementById("BATCH_")"+no)
				obj.innerText			=	" "+batch_id;
				obj						=	eval("document.getElementById("EXPIRY_DATE_")"+no)
				obj.innerText			=	expiry_date;
				eval("frmObj.AVAIL_QTY_"+no+".value="+avail_qty);

				eval("frmObj.Eqvl_value_"+no+".value=''");   //				frmObj.Eqvl_value.value	=	'';
				if (retVal){
					setValues(retVal,no);
				}
					
				obj						=	eval("frmObj.bin_locn_code_"+no)
				obj.value				=	bin_locn_code;
				obj						=	eval("frmObj.trade_id_"+no);
				obj.value				=	trade_id
				var groupCode			=	eval("frmObj.CONST_GROUP_CODE_"+no+".value");
				setConcenPer(val,no);

         if(frmObj.tpn_change_mmoh.value== true || frmObj.tpn_change_mmoh.value =="true"){
                     if (groupCode!='EL' && groupCode!='FL'){
							doCalculationForIssueQty(frmObj,no,groupCode);
						}	
						 if (groupCode!='EL' && groupCode!='FL'){
							defaultOthers1(no,batch_id);
						}	

				/*if (groupCode =='FL' || groupCode == 'EL'){
					fld_qty_uom = eval("document.getElementById("QTY_UOM")"+no);
						fld_qty_uom.innerText = frmObj.presc_base_unit.value;
						if(groupCode =='FL'){
							var stockUOMObj		=   eval("frmObj.issued_stock_uom_"+no);
								if(stockUOMObj.value == fld_qty_uom.innerText){
									eval("frmObj.Eqvl_value_"+no+".value='1'");
								}else{
									check1UOM(stockUOMObj.value,fld_qty_uom.innerText,no);	
								}
							}

						eval("frmObj.ISSUE_QTY_"+no).focus();
				}*/

	   }else{	
		   if (groupCode!='EL' && groupCode!='FL'){
					doCalculation(frmObj,no);
					defaultOthers1(no,batch_id);
				}		

				if (groupCode =='FL' || groupCode == 'EL'){
					fld_qty_uom = eval("document.getElementById("QTY_UOM")"+no);
					fld_qty_uom.innerText = frmObj.presc_base_unit.value;
					if(groupCode =='FL'){
						var stockUOMObj		=   eval("frmObj.issued_stock_uom_"+no);
							if(stockUOMObj.value == fld_qty_uom.innerText){
								eval("frmObj.Eqvl_value_"+no+".value='1'");
							}else{
								check1UOM(stockUOMObj.value,fld_qty_uom.innerText,no);	
							}
						}

					eval("frmObj.ISSUE_QTY_"+no).focus();
				}
			}
		 }else{
			 eval("frmObj.ITEM_"+no+".selectedIndex=0");

		 }		
		 var iss_qty = eval("frmObj.ISSUE_QTY_"+no).value;
		 var osm_val = eval("frmObj.osmolar_value_"+no).value;
		 
		 var item_osm_val = 0;
	     if(iss_qty != ""){
			 item_osm_val = roundTwoDigits((osm_val * iss_qty) / 1000) ;
	 		 if(item_osm_val == '0.0') {item_osm_val="";}
//	 		 eval("frmObj.osmolar_value_"+no).value = item_osm_val;
			 eval("document.getElementById("osmolar_value_lb_")"+no).innerText = item_osm_val;
		 }
		eval("frmObj.dflt_item_search_"+no).style.visibility = "hidden";
	 }else{
		
		eval("document.getElementById("BATCH_")"+no+".innerText=''");
		eval("document.getElementById("EXPIRY_DATE_")"+no+".innerText=''");
		eval("document.getElementById("QTY_UOM")"+no+".innerText=''");
		eval("frmObj.ISSUE_QTY_"+no+".value=''");
		eval("document.getElementById("ALLOC_QTY_UOM")"+no+".innerText=''");
		eval("frmObj.ALLOC_QTY_"+no+".value=''");
		eval("document.getElementById("item_limits_")"+no+".innerText=''");
		eval("document.getElementById("osmolar_value_lb_")"+no+".innerText=''");
		eval("frmObj.osmolar_value_"+no+".value=''");
		var IssueQty	=	0;

		for(k=0;k<row_count;k++){
			value	=	eval("frmObj.ISSUE_QTY_"+k+".value");
			if(value!=""){
				IssueQty	=	IssueQty+parseFloat(value);
			}
		}

		parent.frames[1].document.forms[0].fluid_volume.value	=	roundTwoDigits(IssueQty);		
	 }
	
	 for(k=0;k<row_count;k++){
		value	=	eval("frmObj.ISSUE_QTY_"+k+".value");
		if(value!=""){
			document.formTPNWorkSheetDetails.overage_volume.readOnly	=	true;
			//parent.commontoolbarFrame.formTPNWorkSheetHeader.overage_volume.readOnly	=	true;
			break;
		}
	}
		 var tot_osmo_val	= 0;
//		 var osmo_val		= '';
		 for(k=0;k<row_count;k++){
//		 		alert(eval("document.getElementById("osmolar_value_lb_")"+k+".innerText"));
//				osmo_val = eval("frmObj.osmolar_value_"+k).value;
				osmo_val = eval("document.getElementById("osmolar_value_lb_")"+k+".innerText");
				if(osmo_val == ''){osmo_val = 0}
				tot_osmo_val = tot_osmo_val+parseFloat(osmo_val);
		 }
			//alert('tot_osmo_val --- '+tot_osmo_val);
			parent.frames[1].document.forms[0].osmolarity_volume.value	=	roundTwoDigits(tot_osmo_val);
			var fluid_vol = parent.frames[1].document.forms[0].fluid_volume.value;
			var osmo_val_lt	= 0;
			if(fluid_vol != '' && fluid_vol != '0')
				osmo_val_lt	= (tot_osmo_val * 1000) / fluid_vol ;
//			alert('osmo_val_lt --- '+osmo_val_lt);
			osmo_val_lt = roundTwoDigits(osmo_val_lt);
			parent.frames[1].document.forms[0].osmolarity_volume_per_ltr.value	=	osmo_val_lt;
}
function doCalculation(frmObj,no){

	var presBaseUOM		=	document.formTPNWorkSheetDetails.presc_base_unit.value;
    var tpn_change_mmoh		=	document.formTPNWorkSheetDetails.tpn_change_mmoh.value;
	var issueObj		=	eval("frmObj.ISSUE_QTY_"+no);
	var issueUOMObj		=	eval("document.getElementById("QTY_UOM")"+no);
	var stockUOMObj		=   eval("frmObj.issued_stock_uom_"+no);
	var avlQtyObj		=	eval("frmObj.AVAIL_QTY_"+no);
      
	var Eqvl_value		=	"";
	var ALLOC_QTY_UOM	=	eval("document.getElementById("ALLOC_QTY_UOM_")"+no+".innerText");
		ALLOC_QTY_UOM	=	ALLOC_QTY_UOM.toUpperCase();
	if(presBaseUOM == stockUOMObj.value){
		eval("frmObj.Eqvl_value_"+no+".value='1'") 
		//frmObj.Eqvl_value.value	=	"1";
		Eqvl_value				=	"1";
	}else{	
		
		check1UOM(stockUOMObj.value,presBaseUOM,no);
		Eqvl_value				=	eval("frmObj.Eqvl_value_"+no+".value");
		avlQtyObj.value			=   parseInt(avlQtyObj.value) * parseInt(Eqvl_value);
    }
	
		var cp	=	eval("frmObj.concentration_percent_"+no+".value");

		if (cp!='' && cp!=null && cp!="0" && Eqvl_value!=''){
			var concenPer	=	parseFloat(eval("frmObj.concentration_percent_"+no+".value"));

//			var orQty		=   parseFloat(eval("frmObj.ORDER_QTY_"+no+".value"));
			var orQty		=   parseFloat(eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value"));

//			var calValue	=   ((100/concenPer)*orQty/Eqvl_value);//*(Eqvl_value/orQty);
			var calValue	=   "";
			if(orQty != "0"){
				calValue	=   ((100/concenPer)*orQty);//*(Eqvl_value/orQty);
			}
			issueObj.value	= roundTwoDigits(calValue);	
				//Math.round(calValue);
			issueUOMObj.innerText = presBaseUOM;
			issueObj.focus();
		}else {
			alert(getMessage("PH_TPN_EQUIV_NOT_DEFINED","PH"));
			eval("frmObj.ITEM_"+no+".selectedIndex=0");
			eval("document.getElementById("BATCH_")"+no+".innerText=''");
			eval("document.getElementById("EXPIRY_DATE_")"+no+".innerText=''");
			eval("document.getElementById("QTY_UOM")"+no+".innerText=''");
			eval("frmObj.ISSUE_QTY_"+no+".value=''");
			eval("document.getElementById("ALLOC_QTY_UOM")"+no+".innerText=''");
			eval("frmObj.ALLOC_QTY_"+no+".value=''");
			issueObj.focus();
		}
		
}
function setConcenPer(item,no){
	
		var frmObj		= document.formTPNWorkSheetDetails;
		obj				= eval("frmObj.CONST_GENERIC_CODE_"+no);
		generic_code	= obj.value;		
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var store_code	= frmObj.locn_code.value;
		var order_id	= frmObj.order_id.value;
		var xmlDoc		= "";
		var xmlHttp		= new XMLHttpRequest();
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=concenPer&generic_code="+generic_code+"&item_code="+item+"&num="+no+"&bean_id="+bean_id+"&bean_name="+bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;		
		eval(responseText);
}
function defaultOthers1(no,batch_id) {
	
		if (batch_id != "") {
		item_no			= 1;
		vals			= record_values[no];
		var expiry_date	= "";
		var issue_qty	= "";
		if(item_no%2==0){
			expiry_date	= vals[item_no+1];
			issue_qty	= vals[item_no+2];
		}
		else{
			expiry_date	= vals[item_no];
			issue_qty	= vals[item_no+1];
		}
   
		var frmObj		= document.formTPNWorkSheetDetails;
		obj				= eval("frmObj.CONST_GENERIC_CODE_"+no);
		generic_code	= obj.value;
		obj				= eval("frmObj.CONST_GROUP_CODE_"+no);
		group_code		= obj.value;
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var store_code	= frmObj.locn_code.value;
		var order_id	= frmObj.order_id.value;
		var stock_uom =  eval("document.getElementById("QTY_UOM")"+no+".innerText")
		var issuQty= eval("frmObj.ISSUE_QTY_"+no+".value")
		obj				= eval("document.getElementById("order_uom")"+no);
		obj.value		= stock_uom;
		
	} 
	else {
		var frmObj		= document.formTPNWorkSheetDetails;
		obj				= eval("document.getElementById("QTY_UOM")"+no);
		obj.innerText	= "";
		obj				= eval("document.getElementById("order_uom")"+no);
		obj.value		= "";
		obj				= eval("document.getElementById("ALLOC_QTY_UOM")"+no);
		obj.innerText	= "";
		obj				= eval("frmObj.AVAIL_QTY_"+no);
		obj.value 		= "";
		obj				= eval("frmObj.ISSUE_QTY_"+no);
		obj.value		= "";
		obj				= eval("frmObj.ALLOC_QTY_"+no);
		obj.value		= "";
	}

}

function populateIssueQty(obj,orderid,no,mode)
{

		var frmObj				= document.formTPNWorkSheetDetails;
		if (mode == 'overrage'){
			frmObj				=  parent.f_query_add_mod.formTPNWorkSheetDetails;
		}

		var groupCode			=	eval("frmObj.CONST_GROUP_CODE_"+no+".value");
		var tpn_change_mmoh		=	document.formTPNWorkSheetDetails.tpn_change_mmoh.value;
		if(frmObj.tpn_change_mmoh.value== true || frmObj.tpn_change_mmoh.value =="true"){
			doCalculationForIssueQty(frmObj,no,groupCode)

		}else{
		var order_id			= order_id;
		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;
		var order_id			= orderid;
		var row_count			= frmObj.row_count.value;
		var item_code			= obj.value;
		var ALLOC_QTY_UOM		= "";
		var concentration_percent=eval("frmObj.concentration_percent_"+no+".value");
//		var ORDER_QTY			= eval("frmObj.ORDER_QTY_"+no+".value");
		var ORDER_QTY			= eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");		
		var CONST_GENERIC_CODE	= eval("frmObj.CONST_GENERIC_CODE_"+no+".value");
		var ALLOC_QTY_UOM		= eval("frmObj.ALLOC_QTY_UM_"+no+".value");
		var xmlDoc				= "";
		var xmlHttp				= new XMLHttpRequest();
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=Issue_Qty&row_count="+row_count+"&order_id="+ order_id+"&bean_id="+bean_id+"&no="+no+"&ALLOC_QTY_UOM="+ALLOC_QTY_UOM+"&ALLOC_QTY_UOM="+ALLOC_QTY_UOM+"&ORDER_QTY="+ORDER_QTY+"&CONST_GENERIC_CODE="+CONST_GENERIC_CODE+"&concentration_percent="+concentration_percent+"&item_code="+item_code+"&bean_name="+bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText			= xmlHttp.responseText;
		//alert('responseText ---- '+responseText);
		eval(responseText);
		if(eval("frmObj.ISSUE_QTY_"+no+".disabled") == false){
			eval("frmObj.ISSUE_QTY_"+no+".focus()");
		}else{
			var obj =eval("frmObj.ISSUE_QTY_"+no); 
			checkIsNotZero(obj, 'Issue Quantity', no);
		}
		
		var CONST_GROUP_CODE			= eval("frmObj.CONST_GROUP_CODE_"+no+".value");
		var presBaseUOM		=	frmObj.presc_base_unit.value;
		var stockUOMObj		=   eval("frmObj.issued_stock_uom_"+no);
		check1UOM(stockUOMObj.value,presBaseUOM,no);
		CalPresQty(obj,orderid,no);
//		checkPrecipitation(obj,orderid,no);
		}
}		
function CalPresQty(obj,orderid,no)
{
	
		var frmObj				= document.formTPNWorkSheetDetails;
		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;
		var order_id			= orderid;
		var row_count			= frmObj.row_count.value;

		var Issue_Qty			= obj.value;
		var item_code			= eval("frmObj.ITEM_"+no+".value");
		var concentration_percent=eval("frmObj.concentration_percent_"+no+".value");
//		var ORDER_QTY			= eval("frmObj.ORDER_QTY_"+no+".value");
		var ORDER_QTY			= eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");
		var CONST_GENERIC_CODE	= eval("frmObj.CONST_GENERIC_CODE_"+no+".value");
		var ALLOC_QTY_UOM		= eval("frmObj.ALLOC_QTY_UM_"+no+".value");

		var item_code_obj			= "";
		var cp_obj					= "";
		var order_qty_obj			= "";
		var const_generic_code_obj	= "";
		var alloc_qty_uom_obj		= "";
		var issue_qty_obj			= "";

		var xmlStr ="<root><SEARCH " ;
		for(var i=3;i<=9;i++){
			item_code_obj			= eval("frmObj.ITEM_"+i);
			cp_obj					= eval("frmObj.concentration_percent_"+i);
//			order_qty_obj			= eval("frmObj.ORDER_QTY_"+i);
			order_qty_obj			= eval("frmObj.OVERAGE_ORDER_QTY_"+i);

			const_generic_code_obj	= eval("frmObj.CONST_GENERIC_CODE_"+i);
			alloc_qty_uom_obj		= eval("frmObj.ALLOC_QTY_UM_"+i);
			issue_qty_obj			= eval("frmObj.ISSUE_QTY_"+i);

			if(item_code_obj != undefined){
				
				xmlStr += item_code_obj.name+"=\""+ item_code_obj.value +"\" " ;
				xmlStr += cp_obj.name+"=\""+ cp_obj.value +"\" " ;
				xmlStr += order_qty_obj.name+"=\""+ order_qty_obj.value +"\" " ;
				xmlStr += const_generic_code_obj.name+"=\""+ const_generic_code_obj.value +"\" " ;
				xmlStr += alloc_qty_uom_obj.name+"=\""+ alloc_qty_uom_obj.value +"\" " ;
				xmlStr += issue_qty_obj.name+"=\""+ issue_qty_obj.value +"\" " ;
			}
		}

	//	xmlStr+= "Ordering_Facility =\"" + Ordering_Facility + "\" " ;
		xmlStr +=" /></root>" ;

		var xmlDoc				= "";
		var xmlHttp				= new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=Presc_Qty&row_count="+row_count+"&order_id="+ order_id+"&bean_id="+bean_id+"&no="+no+"&ALLOC_QTY_UOM="+ALLOC_QTY_UOM+"&ORDER_QTY="+ORDER_QTY+"&calculate_for=PrescribeQty&CONST_GENERIC_CODE="+CONST_GENERIC_CODE+"&Issue_Qty="+Issue_Qty+"&concentration_percent="+concentration_percent+"&item_code="+item_code+"&bean_name="+bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText			= xmlHttp.responseText;
//alert('responseText ----|'+responseText);
		eval(responseText);
}
function validateVariationPer(row_num,srlNo){
	
	var frmObj			=	document.formTPNWorkSheetDetails;
	var varPer			=	eval("parseFloat(frmObj.manufacture_var_percentage"+row_num+".value);");	
//	var PresQty			=	eval("parseInt(frmObj.ORDER_QTY_"+row_num+".value);");
	var PresQty			=	eval("parseInt(frmObj.OVERAGE_ORDER_QTY_"+row_num+".value);");
	var issuQty			=	eval("parseInt(frmObj.ALLOC_QTY_"+row_num+".value);");
	var PrassQtyRange	=	Math.ceil(((varPer / 100)*PresQty ));
	var alrtmsg			=	"";
	var min				=	(PresQty-PrassQtyRange);
	var max				=	(PresQty+PrassQtyRange);
	if ((issuQty<min) || (issuQty >max))
	{   alrtmsg			=getLabel("ePH.AlloactedQuatityfor.label","PH")+eval("document.getElementById("CONST_GENERIC_NAME_")"+row_num+".innerText")+getLabel("ePH.Shouldfallwithin.label","PH");
		alrtmsg			=alrtmsg+" "+min+" - "+max;
		alert(alrtmsg);
		eval("frmObj.ISSUE_QTY_"+row_num+".focus()");
		
	}	
	eval("document.getElementById("item_limits_")"+row_num).innerText =  "( "+min+" ~ "+max+" )";
}
function validateVariationPer1(row_num,allocQty,Eqvl_value){
			
	var frmObj= document.formTPNWorkSheetDetails;//ALLOC_QTY_UOM_
	if(allocQty!='')
	{
		var alloc		=	eval("document.getElementById("ALLOC_QTY_UOM_")"+row_num+".innerText");
		var obj			=	eval("document.getElementById("ALLOC_QTY_UOM")"+row_num);
		obj.innerText	=	alloc;
		eval("frmObj.ALLOC_QTY_"+row_num+".value="+allocQty);
		var varPer		=	eval("parseFloat(frmObj.manufacture_var_percentage"+row_num+".value);");
		
		if(varPer!="0" && varPer!=null && varPer!="null" && varPer!="" && varPer!="undefined")
		{
			var Eqvl_value1		=	parseFloat(Eqvl_value);
//			var PresQty			=	eval("parseInt(frmObj.ORDER_QTY_"+row_num+".value);");
			var PresQty			=	eval("parseInt(frmObj.OVERAGE_ORDER_QTY_"+row_num+".value);");

			var issuQty			=	eval("parseInt(frmObj.ALLOC_QTY_"+row_num+".value);");
			var PrassQtyRange	=	Math.ceil(((varPer / 100)*PresQty ));
			var alrtmsg			=	"";
			var min				=	(PresQty-PrassQtyRange);
			var max				=	(PresQty+PrassQtyRange);

			if ((issuQty<min) || (issuQty >max))
			{   alrtmsg			=	getLabel("ePH.AlloactedQuatityfor.label","PH")+eval("document.getElementById("CONST_GENERIC_NAME_")"+row_num+".innerText")+getLabel("ePH.Shouldfallwithin.label","PH");
					alrtmsg		=	alrtmsg+" "+min+" - "+max;
					alert(alrtmsg);
					eval("frmObj.ISSUE_QTY_"+row_num+".focus()");
					eval("document.getElementById("ALLOC_QTY_UOM")"+row_num+".innerText=''");
					eval("document.getElementById("ALLOC_QTY_")"+row_num+".value=''");
			}
			eval("document.getElementById("item_limits_")"+row_num).innerText = "( "+min+" ~ "+max+" )";
		}		
	}else{
		alert(getMessage("PH_TPN_EQUIV_NOT_DEFINED","PH"));
		eval("document.getElementById("ALLOC_QTY_UOM")"+row_num+".innerText=''");
		eval("document.getElementById("ALLOC_QTY_")"+row_num+".value=''");
	}
	
}

function check1UOM(issueUOM,allocUOM,row_num){

		var frmObj		= document.formTPNWorkSheetDetails;
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var order_id	= frmObj.order_id.value;
		var xmlDoc		= "";
		var xmlHttp		= new XMLHttpRequest();
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=check1UOM&issueUOM="+issueUOM+"&allocUOM="+ allocUOM+"&bean_id="+bean_id+"&bean_name="+bean_name+"&row_num="+row_num, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;

		eval(responseText);	
}

function setAllocValues(row_num,aloc_value){

	var frmObj				= document.formTPNWorkSheetDetails;
	if(aloc_value == 0){
		var grp_code = eval("frmObj.CONST_GROUP_CODE_"+row_num).value;
		if(grp_code == 'EL'){
			eval("document.getElementById("ALLOC_QTY_UOM")"+row_num).innerText='';	
			eval("frmObj.ALLOC_QTY_"+row_num).value = "";
		}
	}else{
		eval("document.getElementById("ALLOC_QTY_UOM")"+row_num).innerText=eval("document.getElementById("ALLOC_QTY_UOM_")"+row_num).innerText;	
		eval("frmObj.ALLOC_QTY_"+row_num).value = aloc_value;
	}
	/*if(parent.commontoolbarFrame.formTPNWorkSheetHeader.overage_volume.readOnly != true){
		parent.commontoolbarFrame.formTPNWorkSheetHeader.overage_volume.readOnly	=	true;
	}*/
	if(frmObj.overage_volume.readOnly != true){
		frmObj.overage_volume.readOnly	=	true;
	}
}

function calOvrgeOrdQty(obj){
	formObj					= parent.f_query_add_mod.formTPNWorkSheetDetails;
	var row_count			= formObj.row_count.value;
	var order_id			= formObj.order_id.value;	
	var item_obj			= "";	
	var order_qty			= "";
	var new_order_qty		= "";
	var order_volume		= formObj.ordered_volume.value;
	var overage_value		= obj.value;
	var overage_ord_volume  = order_volume;
	
	if(overage_value != ''){
		overage_ord_volume  = parseInt(order_volume) + parseInt(overage_value);
	}

	parent.messageFrame.formTPNWorkSheetButtons.ordered_volume_overage.value = overage_ord_volume;
	
	if(overage_value != '0' || overage_value != ''){
		for(i=0; i<row_count; i++){
			order_qty			=  eval("formObj.ORDER_QTY_"+i).value;		
			const_generic_code	=  eval("formObj.CONST_GENERIC_CODE_"+i).value
	
			if(const_generic_code != 'FLUID'){
				if(order_qty != ''){
					new_order_qty		=  roundTwoDigits(parseFloat(order_qty)+((parseFloat(order_qty)/parseFloat(order_volume))*overage_value));
//					alert('new_order_qty --- '+new_order_qty);
					eval("formObj.OVERAGE_ORDER_QTY_"+i).value	= new_order_qty;
				}
			}
	
		}
	}
}

  async function showOvrRsn(tpn_override_reason){
		var dialogHeight	= '30vh' ;
		var dialogWidth 	= '40vw' ;
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		await window.showModalDialog("../../ePH/jsp/TPNConstGenericOverrideReason.jsp?mode=dispensing"+"&tpn_override_reason="+tpn_override_reason,arguments,features);
  }

  async function showRemarks(remarks){
    var retVal;
	var dialogHeight	= '30vh' ;
	var dialogWidth 	= '50vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/TPNConstGenericRemarks.jsp?hdg_name="+hdg_name+ "&remarks=" +remarks,arguments,features);
  
  }

 function roundTwoDigits(a) // the function is modified to return 4 decimal degits
 {

			return a.toFixed(4);
}

function showToolTip(obj,data){
   obj.title = data;
}

function showPhCaAlert(phsp_calc_message){
	var allow_ph_ca = true;
		allow_ph_ca = confirm(phsp_calc_message);
		if (allow_ph_ca == false){
			allow_rec_ws = "N";
		}else if(allow_ph_ca == true){
			allow_rec_ws = "Y";
		}
}

function GetBillingDetails(rec_no){
	  
	    var formobj					= document.formTPNWorkSheetDetails;
	    var item_code				= eval("document.formTPNWorkSheetDetails.ITEM_"+rec_no+".value");
		var billing_interface_yn    = parent.messageFrame.document.formTPNWorkSheetButtons.billing_interface_yn.value;
        var issue_qty				= eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+rec_no+".value");

		if(item_code!=''&& billing_interface_yn=='Y' && issue_qty!=''){
				var patient_id				= formobj.patient_id.value;	  
				var issue_qty				= eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+rec_no+".value");
		//trade;batchid,exp_date,bin_loc,req_qty 
				var trade_id				= eval("document.formTPNWorkSheetDetails.trade_id_"+rec_no+".value");
				var batch_id				= eval("document.getElementById("BATCH_")"+rec_no+".innerText");
				var exp_date				= eval("document.getElementById("EXPIRY_DATE_")"+rec_no+".innerText");
				var bin_loc_code			= eval("document.formTPNWorkSheetDetails.bin_locn_code_"+rec_no+".value");
				var Store_code				= formobj.locn_code.value;
				var order_id				= formobj.order_id.value;
				var dischargeIND				= formobj.dischargeIND.value;
				var tot_gross_charge_amount = parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value;
				var tot_groos_pat_payable   = parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value;
                var old_gross_charge_amount = eval("document.formTPNWorkSheetDetails.gross_charge_amount_"+rec_no+".value");
				var old_groos_pat_payable   = eval("document.formTPNWorkSheetDetails.groos_pat_payable_"+rec_no+".value");

				var xmlDoc="" ;
				var xmlHttp    = new XMLHttpRequest();

				var xmlStr ="<root><SEARCH ";
				xmlStr += " patient_id=\"" + patient_id + "\"";
				xmlStr += " item_code=\"" + item_code + "\"";
				xmlStr += " issue_qty=\"" + issue_qty + "\"";
				xmlStr += " trade_id=\"" + trade_id + "\"";
				xmlStr += " batch_id=\"" + batch_id + "\"";
				xmlStr += " exp_date=\"" + exp_date + "\"";
				xmlStr += " bin_loc_code=\"" + bin_loc_code + "\"";
				xmlStr += " Store_code=\"" + Store_code + "\"";
				xmlStr += " order_id=\"" + order_id + "\"";
				xmlStr += " rec_no=\"" + rec_no + "\"";	
				xmlStr += " tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\"";
				xmlStr += " tot_groos_pat_payable=\"" + tot_groos_pat_payable + "\"";	
				xmlStr += " old_gross_charge_amount=\"" + old_gross_charge_amount + "\"";
				xmlStr += " old_groos_pat_payable=\"" + old_groos_pat_payable + "\"";
				xmlStr += " dischargeIND=\"" + dischargeIND + "\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST","TPNWorkSheetValidate.jsp?func_mode=GET_BL_DET",false);
				xmlHttp.send( xmlDoc ) ;
	
				eval(xmlHttp.responseText);
		}else{
			if(billing_interface_yn=='Y'){
				eval("document.getElementById("td_groos_pat_payable_str_")"+rec_no).innerHTML	    ="";
				eval("document.getElementById("td_gross_charge_amount_str_")"+rec_no).innerHTML	="";

				var temp1= eval("document.formTPNWorkSheetDetails.gross_charge_amount_"+rec_no);
				
				var temp2 =eval("document.formTPNWorkSheetDetails.groos_pat_payable_"+rec_no);
				
				reCalculteTotals(rec_no,temp1.value,temp2.value);
				temp2.value   = "";
				temp1.value   = "";
			}
		}
}

function reCalculteTotals(rec_no,old_gross_charge_amount,old_groos_pat_payable){
                var tot_gross_charge_amount  = parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value;
				var tot_groos_pat_payable    = parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value;

               // var old_gross_charge_amount  = eval("document.formTPNWorkSheetDetails.gross_charge_amount_"+rec_no+".value");
				//var old_groos_pat_payable    = eval("document.formTPNWorkSheetDetails.groos_pat_payable_"+rec_no+".value");

                var decimal_format_string    = document.formTPNWorkSheetDetails.decimal_format_string.value;


                var xmlDoc="" ;
				var xmlHttp    = new XMLHttpRequest();
				
				var xmlStr ="<root><SEARCH ";				
				xmlStr += " tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\"";
				xmlStr += " tot_groos_pat_payable=\"" + tot_groos_pat_payable + "\"";	
				xmlStr += " old_gross_charge_amount=\"" + old_gross_charge_amount + "\"";
				xmlStr += " old_groos_pat_payable=\"" + old_groos_pat_payable + "\"";
                xmlStr += " decimal_format_string=\"" + decimal_format_string + "\"";  
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","TPNWorkSheetValidate.jsp?func_mode=RE_CAL_BL_DET",false);
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);


}

function setBillingAmounts(rec_no,groos_pat_payable,gross_charge_amount,err_msg,tot_groos_pat_payable_str,tot_gross_charge_amount_str,decimal_format_string){

    var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
	var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
	
	if(err_msg==''){

		eval("document.getElementById("td_groos_pat_payable_str_")"+rec_no).innerHTML	="<label style='font-size:10;color:black'>"+gross_charge_amount+"</label>";

		eval("document.getElementById("td_gross_charge_amount_str_")"+rec_no).innerHTML	="<label style='font-size:10;color:black'>"+groos_pat_payable+"</label>";


		var temp1 = eval("document.formTPNWorkSheetDetails.gross_charge_amount_"+rec_no);
		    temp1.value =  groos_pat_payable;
		var temp2 = eval("document.formTPNWorkSheetDetails.groos_pat_payable_"+rec_no) ;
		    temp2.value  =gross_charge_amount;

			document.formTPNWorkSheetDetails.decimal_format_string.value  =decimal_format_string;

      
	

	    parent.messageFrame.document.getElementById("td_total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_groos_pat_payable_str+"</label>";

        parent.messageFrame.document.getElementById("td_patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_gross_charge_amount_str+"</label>";


		parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value   = tot_groos_pat_payable_str;

		parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value = tot_gross_charge_amount_str;

	}else{
		eval("document.getElementById("td_groos_pat_payable_str_")"+rec_no).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>"+getLabel("Common.Error.label","Common")+"</label>";
		eval("document.getElementById("td_gross_charge_amount_str_")"+rec_no).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>"+getLabel("Common.Error.label","Common")+"</label>";

		 parent.messageFrame.document.getElementById("td_total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_gross_charge_amount_str+"</label>";

         parent.messageFrame.document.getElementById("td_patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_groos_pat_payable_str+"</label>";
	
		 parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value   = tot_groos_pat_payable_str;	
		 parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value = tot_gross_charge_amount_str;
		if(gross_charge_amount=='')
		{
			eval("document.formTPNWorkSheetDetails.gross_charge_amount_"+rec_no+".value=0.00");
		}
		if(groos_pat_payable=='')
		{
		 eval("document.formTPNWorkSheetDetails.groos_pat_payable_"+rec_no+".value=0.00");
		}
		
	}
}

function setREcalcultedBillDet(tot_gross_charge_amount_str,tot_groos_pat_payable_str){
    
	 
	 var tot_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
	 var pat_payable = getLabel("ePH.TotalPayableAmount.label","PH");

     if(tot_gross_charge_amount_str!=''&& tot_groos_pat_payable_str !=''){
		  parent.messageFrame.document.getElementById("td_total_payable").innerHTML	="<label >"+tot_payable+"      : "+tot_groos_pat_payable_str+"</label>";

		  parent.messageFrame.document.getElementById("td_patient_payable").innerHTML	="<label >"+pat_payable+"       : "+tot_gross_charge_amount_str+"</label>";


		 parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value   = tot_groos_pat_payable_str;
		 parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value = tot_gross_charge_amount_str;
	 }else{
          parent.messageFrame.document.getElementById("td_total_payable").innerHTML	="";
		  parent.messageFrame.document.getElementById("td_patient_payable").innerHTML	="";

		 parent.messageFrame.document.formTPNWorkSheetButtons.total_payable.value   = "";
		 parent.messageFrame.document.formTPNWorkSheetButtons.patient_payable.value = "";
	 }
		
}

async function showPrecipitaionInfo(const_generic_code){
	var bean_id		= document.forms[0].bean_id.value;
	var bean_name	= document.forms[0].bean_name.value;
	var dialogHeight	= '34vh' ;
	var dialogWidth 	= '65vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	await window.showModalDialog("../../ePH/jsp/TPNPrecipitationInfo.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&const_generic_code="+const_generic_code,arguments,features);
}

function checkPrecipitation(obj,no){

		var frmObj				= "";
		/*if(recrdFrm != undefined){
			frmObj		= recrdFrm;
			calledFrom	= "record";
		}else{*/
			frmObj = document.formTPNWorkSheetDetails;
//		}

		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;

		var Issue_Qty			= obj.value;
		var item_code			= eval("frmObj.ITEM_"+no+".value");
//		var concentration_percent=eval("frmObj.concentration_percent_"+no+".value");
//		var ORDER_QTY			= eval("frmObj.ORDER_QTY_"+no+".value");
		var ORDER_QTY			= eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");
		var CONST_GENERIC_CODE	= eval("frmObj.CONST_GENERIC_CODE_"+no+".value");
		var ALLOC_QTY           = eval("frmObj.ALLOC_QTY_"+no+".value");
		var ALLOC_QTY_UOM		= eval("frmObj.ALLOC_QTY_UM_"+no+".value");

		var ovrge_ordrd_volume	= parent.messageFrame.formTPNWorkSheetButtons.ordered_volume_overage.value;

		var item_code_obj			= "";
		var cp_obj					= "";
		var order_qty_obj			= "";
		var const_generic_code_obj	= "";
		var alloc_qty_obj			= "";
		var alloc_qty_uom_obj		= "";
		var issue_qty_obj			= "";

	if(ALLOC_QTY != '' & Issue_Qty != '' && Issue_Qty != '0'){

		var xmlStr ="<root><SEARCH " ;
		for(var i=3;i<=9;i++){
			item_code_obj			= eval("frmObj.ITEM_"+i);
//			cp_obj					= eval("frmObj.concentration_percent_"+i);
//			order_qty_obj			= eval("frmObj.ORDER_QTY_"+i);
			order_qty_obj			= eval("frmObj.OVERAGE_ORDER_QTY_"+i);

			const_generic_code_obj	= eval("frmObj.CONST_GENERIC_CODE_"+i);
			alloc_qty_obj			= eval("frmObj.ALLOC_QTY_"+i);
			alloc_qty_uom_obj		= eval("frmObj.ALLOC_QTY_UM_"+i);
			issue_qty_obj			= eval("frmObj.ISSUE_QTY_"+i);

			if(item_code_obj != undefined){
				
				xmlStr += item_code_obj.name+"=\""+ item_code_obj.value +"\" " ;
//				xmlStr += cp_obj.name+"=\""+ cp_obj.value +"\" " ;
				xmlStr += order_qty_obj.name+"=\""+ order_qty_obj.value +"\" " ;
				xmlStr += const_generic_code_obj.name+"=\""+ const_generic_code_obj.value +"\" " ;
				xmlStr += alloc_qty_obj.name+"=\""+ alloc_qty_obj.value +"\" " ;
				xmlStr += alloc_qty_uom_obj.name+"=\""+ alloc_qty_uom_obj.value +"\" " ;
				xmlStr += issue_qty_obj.name+"=\""+ issue_qty_obj.value +"\" " ;
			}
		}

	//	xmlStr+= "Ordering_Facility =\"" + Ordering_Facility + "\" " ;
		xmlStr +=" /></root>" ;
//alert('xmlStr ---|'+xmlStr);

		var xmlDoc				= "";
		var xmlHttp				= new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "TPNWorkSheetValidate.jsp?func_mode=checkPrecipate&bean_id="+bean_id+"&no="+no+"&ALLOC_QTY="+ALLOC_QTY+"&ALLOC_QTY_UOM="+ALLOC_QTY_UOM+"&ORDER_QTY="+ORDER_QTY+"&CONST_GENERIC_CODE="+CONST_GENERIC_CODE+"&Issue_Qty="+Issue_Qty+"&item_code="+item_code+"&bean_name="+bean_name+"&ovrge_ordrd_volume="+ovrge_ordrd_volume, false);

		//+"&concentration_percent="+concentration_percent

		xmlHttp.send(xmlDoc);
		responseText			= xmlHttp.responseText;
//alert('responseText ----|'+responseText);
		eval(responseText);
	}
}

function showPrecipMessage(precip_mesg,sel_const_no){
//alert('precip_mesg ---|'+precip_mesg);
	var error_confirm = true;
	var precip_indi   = "";
	var precip_from	  = "";
	var precip_to	  = "";
	var precip_alert  = "";
	var show_alert	  = "";
	var precip_msgs = 	precip_mesg.split("||");
	
	for(var i=0;i<precip_msgs.length;i++){
		precip_indi   = '';
		show_alert	  = '';
		error_confirm = true;
		var const_message = precip_msgs[0].split("$");
			precip_indi	  = const_message[0];
			precip_from	  = const_message[1];
			precip_to	  = const_message[2];
			precip_alert  = const_message[3];
			show_alert	  = precip_from+" , "+precip_to+" : "+precip_alert;

			if(precip_indi == 'W' || precip_indi == 'N'){
		//		alert(precip_mesg);
				error_confirm = confirm(show_alert);
				if(error_confirm == false){
					eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+sel_const_no).focus();
				}
			}else if(precip_indi == 'E'){
				alert(show_alert);
		//		error_confirm = confirm(precip_mesg);
				//if(error_confirm == false){
					eval("document.formTPNWorkSheetDetails.ISSUE_QTY_"+sel_const_no).focus();
				//}
			}
	}
}

function checkForTPNItemSelect(obj,iCount)
{
	if(obj.value != '')
	{
		if(eval("document.formTPNWorkSheetDetails.ITEM_"+iCount).value == '')
		{

			//PH_SEL_ITEM in O: messages.java this id should be included.
			alert(getMessage("PH_SEL_ITEM","PH"));
			obj.value = '';
			obj.focus();
		}
	}
}
function doCalculationForIssueQty(frmObj,no,group_code){//Adding start for ML-MMOH-CRF-1201

	var presBaseUOM		=	document.formTPNWorkSheetDetails.presc_base_unit.value;
    var tpn_change_mmoh		=	document.formTPNWorkSheetDetails.tpn_change_mmoh.value;
	var issueObj		=	eval("frmObj.ISSUE_QTY_"+no);
	var issueUOMObj		=	eval("document.getElementById("QTY_UOM")"+no);
	var stockUOMObj		=   eval("frmObj.issued_stock_uom_"+no);
	var avlQtyObj		=	eval("frmObj.AVAIL_QTY_"+no);
      
	var Eqvl_value		=	"";
	var ALLOC_QTY_UOM	=	eval("document.getElementById("ALLOC_QTY_UOM_")"+no+".innerText");
		ALLOC_QTY_UOM	=	ALLOC_QTY_UOM.toUpperCase();
	if(presBaseUOM == stockUOMObj.value){
		eval("frmObj.Eqvl_value_"+no+".value='1'") 
		Eqvl_value				=	"1";
	}else{	
		
		check1UOM(stockUOMObj.value,presBaseUOM,no);
		Eqvl_value				=	eval("frmObj.Eqvl_value_"+no+".value");
		avlQtyObj.value			=   parseInt(avlQtyObj.value) * parseInt(Eqvl_value);
    }

	 if(Eqvl_value==''){
			alert(getMessage("PH_TPN_EQUIV_NOT_DEFINED","PH"));
			eval("frmObj.ITEM_"+no+".selectedIndex=0");
			eval("document.getElementById("BATCH_")"+no+".innerText=''");
			eval("document.getElementById("EXPIRY_DATE_")"+no+".innerText=''");
			eval("document.getElementById("QTY_UOM")"+no+".innerText=''");
			eval("frmObj.ISSUE_QTY_"+no+".value=''");
			eval("document.getElementById("ALLOC_QTY_UOM")"+no+".innerText=''");
			eval("frmObj.ALLOC_QTY_"+no+".value=''");
			issueObj.focus();
	  }else{//Adding start for ML-MMOH-CRF-1201
			 if(group_code == 'MN' && (frmObj.tpn_change_mmoh.value== true || frmObj.tpn_change_mmoh.value =="true")){
				var order_qty       =   eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");
				var item_concenPer	=	eval("frmObj.item_concentration_percent_"+no+".value");
			    var item_volume     =   eval("frmObj.item_volume_"+no+".value");
                   calValue	= (order_qty*item_volume)/item_concenPer ; 
				   issueObj.value	= roundTwoDigits(calValue);	
				   issueUOMObj.innerText = presBaseUOM;
				   issueObj.focus();
			  }else if (group_code == 'EL')
			  {
                 var order_qty       =   eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");
				 var item_concenPer	=	eval("frmObj.item_concentration_percent_"+no+".value");
                   calValue	= order_qty/item_concenPer ; 
				   issueObj.value	= roundTwoDigits(calValue);	
				   issueUOMObj.innerText = presBaseUOM;
				   issueObj.focus();
			  }else{
                 var order_qty       =   eval("frmObj.OVERAGE_ORDER_QTY_"+no+".value");
                   calValue	= order_qty ; 
				   issueObj.value	= calValue;	
				   issueUOMObj.innerText = presBaseUOM;
				   issueObj.focus();
			   }

    }
}//Addding end for ML-MMOH-CRF-1201
