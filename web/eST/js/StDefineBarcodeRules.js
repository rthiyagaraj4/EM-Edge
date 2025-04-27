var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function apply() {
	var formObj = f_query_add_mod.document.formbarcoderule;
	var Options = formObj.barcode_elements;
	var Remove_Options = formObj.all_elements;
	var selObj = "";
	
	for( i=0;i<Options.length;i++) {
	
		if(Options[i].text == "ITEM CODE") {
			formObj.item_yn.value = "Y";
		} else if (Options[i].text == "BATCH ID") {
			formObj.batch_id_yn.value = "Y";
		} else if (Options[i].text == "EXPIRY DATE") {
			formObj.expiry_dt_yn.value = "Y";
		} else if(Options[i].text == "FACILITY ID") {
			formObj.facility_id_yn.value = "Y";
		} else if(Options[i].text == "TRADE ID") {
			formObj.trade_id_yn.value = "Y";
		} else 	if(Options[i].text == "MANUFACTURER ID") {
				formObj.mfg_id_yn.value = "Y";
		}	else if(Options[i].text == "SUPPLIER ID"){
			formObj.supp_id_yn.value = "Y";
		} else if(Options[i].text == "STORE CODE") {
			formObj.store_code_yn.value = "Y";
		} else if(Options[i].text == "BIN LOCATION") {
			formObj.bin_locn_yn.value = "Y";
		} else if(Options[i].text == "MRP") {
			formObj.mrp_yn.value = "Y";
		}
	for( j=0;j<Remove_Options.length;j++) {

		 if(Remove_Options[j].text == "FACILITY ID") {
			formObj.facility_id_yn.value = "N";
		} else if(Remove_Options[j].text == "TRADE ID") {
			formObj.trade_id_yn.value = "N";
		} else 	if(Remove_Options[j].text == "MANUFACTURER ID") {
				formObj.mfg_id_yn.value = "N";
		}	else if(Remove_Options[j].text == "SUPPLIER ID"){
			formObj.supp_id_yn.value = "N";
		} else if(Remove_Options[j].text == "STORE CODE") {
			formObj.store_code_yn.value = "N";
		} else if(Remove_Options[j].text == "BIN LOCATION") {
			formObj.bin_locn_yn.value = "N";
		} else if(Remove_Options[j].text == "MRP") {
			formObj.mrp_yn.value = "N";
		}
		
	}
		
			if(Options[i].text == "BIN LOCATION" || Options[i].text == "MANUFACTURER ID" || Options[i].text == "SUPPLIER ID" || Options[i].text == "MRP" ) {
			selObj = selObj + "-" + Options[i].text.substring(0,2);
		}
		else {
		 selObj = selObj + "-" + Options[i].text.substring(0,1);
		}
			
	}
			
		formObj.barcode_seq.value = selObj.substr(1);
			
			var errorPage = "../../eCommon/jsp/error.jsp";
	
			var resultText = formApply(formObj, ST_CONTROLLER);
			eval(resultText);
			//alert(resultText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
				}
	}
function reset() {
		formObj= f_query_add_mod.document.formbarcoderule;
		f_query_add_mod.document.location.reload();

	if(formObj.barcode_gen_1.checked == true || formObj.barcode_gen_2.checked == true) {
		
		formObj.all_elements.disabled = true;
		formObj.barcode_elements.disabled = true;
		formObj.add.disabled = true;
		formObj.remove.disabled = true;
		formObj.moveup.disabled = true;
		formObj.movedown.disabled = true;

	} 
	else {
		
		formObj.all_elements.disabled = false;
		formObj.barcode_elements.disabled = false;
		formObj.add.disabled = false;
		formObj.remove.disabled = false;
		formObj.moveup.disabled = false;
		formObj.movedown.disabled = false;
		}
} 



function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById("all_elements");
	if (from.options.length > 0 && from.selectedIndex > -1) {
		var to = document.getElementById("barcode_elements");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		var assign_val = element.value;
		
		if(assign_val== "N") {
			element.value = "Y"
		}
	
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i]) {
			from.options[i].selected = true;
		}
		i++;
	}
}
function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById("barcode_elements");
	if (from.options.length > 0 && from.selectedIndex > -1) {
		var to = document.getElementById("all_elements");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		if(element.text == "ITEM CODE" || element.text == "BATCH ID" | element.text == "EXPIRY DATE" ) {
			alert("This Element Is Not Allowed To be Excluded!!");
			return false;
		}
		element.value = from.options[from.selectedIndex].value;
		var assign_val = element.value;
		
		if(assign_val== "Y") {
			element.value = "N"
		}
		
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j]) {
			from.options[j].selected = true;
		}
		j++;
	}
}



function listbox_move(listID, direction) {
    var listbox = document.getElementById(listID);

   
    if (listbox.disabled) {
       
        return;
    }

    var selIndex = listbox.selectedIndex;

    if (selIndex === -1) {
        alert("Please select an option to move.");
        return;
    }

    var increment = (direction === 'up') ? -1 : 1;

    if ((selIndex + increment < 0) || (selIndex + increment) > (listbox.options.length-1)) {
        return;
    }
    var selValue = listbox.options[selIndex].value;
    var selText = listbox.options[selIndex].text;
    listbox.options[selIndex].value = listbox.options[selIndex + increment].value;
    listbox.options[selIndex].text = listbox.options[selIndex + increment].text;

    listbox.options[selIndex + increment].value = selValue;
    listbox.options[selIndex + increment].text = selText;

    listbox.selectedIndex = selIndex + increment;
}



function enabledisable() {
	formObj= document.formbarcoderule;
	//alert(document.formbarcoderule.barcode_gen_1.value);
	
	if(formObj.barcode_gen_1.checked == true || formObj.barcode_gen_2.checked == true) {
		
		formObj.all_elements.disabled = true;
		formObj.barcode_elements.disabled = true;
		formObj.add.disabled = true;
		formObj.remove.disabled = true;
		formObj.moveup.disabled = true;
		formObj.movedown.disabled = true;

	}
	else {
		
		formObj.all_elements.disabled = false;
		formObj.barcode_elements.disabled = false;
		formObj.add.disabled = false;
		formObj.remove.disabled = false;
		formObj.moveup.disabled = false;
		formObj.movedown.disabled = false;
		}
}





