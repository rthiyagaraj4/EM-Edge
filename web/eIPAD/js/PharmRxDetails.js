var rxValidation;
var quantityArray;
var return_val = true;

function qualityValue() {
    this.code = "";
    this.desp = "";
}

function rxValidation() {
    this.quantity = "";
    this.quantityArray = [];
    this.strength = "";
    this.strengthArray = [];
}

function allowValidNumber(fld, e, maxInt, deci) {
    var count = fld.value.length; //
    var whichCode = (window.Event) ? e.which : e.keyCode;
    var minusOccurance = fld.value.indexOf('-');
    if (minusOccurance != -1) {
        maxInt++;
    }
    if (whichCode == 45 && count > 0) {
        return false
    }
    if (count >= maxInt) {
        if (count == maxInt) {
            var dotOccurance = fld.value.indexOf('.');
            if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt) && deci > 0) {
                if (whichCode != 46) {
                    fld.value = fld.value + ".";                    
                    $("#rxDosageByVal").val(fld.value);
                }
            }
        } else if (count > maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');     
            if ((objectValue.charAt(maxInt)) != '.') {
                if (dotOccurance == -1 && parseInt(deci) > 0) {
                    fld.value = objectValue.substring(0, maxInt) + ".";
                    $("#rxDosageByVal").val(fld.value);
                    return false;
                }
            }
        }
    }    
    var strCheck = '.0123456789-';
    if (parseInt(deci) == 0) //For Only Nos 0 - 9
        strCheck = '0123456789-';

    var fldvalue = fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true; // Enter
    var pointCount = 0;

    for (var i = 0; i < fldvalue.length; i++) {
        if (fldvalue.charAt(i) == '.') pointCount++;
    }

    if (pointCount > 0 && whichCode == 46) return false;

    var fldValue = fld.value;
    var dotIndex = fldValue.indexOf(".");
    var fldLength = fldValue.length;
    if (dotIndex != -1)
        if (fldLength > (dotIndex + deci)) return false;


    key = String.fromCharCode(whichCode); // Get key value from key code

    if (strCheck.indexOf(key) == -1) return false; // Not a valid key
    else if (key == "-" && fldValue.indexOf(key) != -1) {
        if (fldValue.indexOf(key) != 1)
            return false
    }
    return true;
}
function showBillingDetails(){
	var bl_install_yn	            = $("#bl_install_yn").val();
	var bl_disp_charge_dtl_in_rx_yn	= $("#bl_disp_charge_dtl_in_rx_yn").val();
	var in_formulary_yn             = document.rxDetailsViewForm.in_formulary_yn.value;
	if(bl_install_yn=='Y' && bl_disp_charge_dtl_in_rx_yn=='Y' && in_formulary_yn == 'Y'){
			
		var frmObj_pres_dtl = document.rxDetailsViewForm;
		var drug_code = document.rxDetailsViewForm.drug_code.value;
		var srl_no = document.rxDetailsViewForm.srl_no.value;
		var qty_value = document.rxDetailsViewForm.rxDosageByVal.value;
		var qty_desc_code = document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].value;
		var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value();
		if(dosage_type=='A'){
			qty_value = 1; //Since Order Quantity field is not available in mobility
		}
		var repeat_value = document.rxDetailsViewForm.repeat_value.value;
		var durn_value = document.rxDetailsViewForm.tmp_durn_value.value;
		var interval_value = document.rxDetailsViewForm.interval_value.value;
		var bl_override_excl_incl_ind = document.rxDetailsViewForm.bl_override_excl_incl_ind.value;
		var pat_brought_medn = document.rxDetailsViewForm.brought_by_pat.value;
		var sliding_scale_yn = document.rxDetailsViewForm.sliding_scale_yn.value;
		var take_home_medication = $("input[name=take_home_medication]").val();
		var called_from="ASSIGN_OVERRIDE";
		var episode_type = $("input[name=episode_type]").val();
		var order_Date = $("input[name=sys_date]").val();
		var bl_overriden_action_reason = "";
		var billable_item_yn = document.rxDetailsViewForm.billable_item_yn.value;
		var patient_id = document.rxDetailsViewForm.patient_id.value;
		var encounter_id = document.rxDetailsViewForm.encounter_id.value;
		var fldString = " drug_code=\"" + drug_code + "\" ";
		fldString += " patient_id=\"" + patient_id + "\" ";
		fldString += " encounter_id=\"" + encounter_id + "\" ";
		fldString += " episode_type=\"" + episode_type + "\" ";
		fldString += " srl_no=\"" + srl_no + "\" ";
		fldString += " qty_value=\"" + qty_value + "\" ";
		fldString += " qty_desc_code=\"" + qty_desc_code + "\" ";
		fldString += " dosage_type=\"" + dosage_type + "\" ";
		fldString += " repeat_value=\"" + repeat_value + "\" ";
		fldString += " durn_value=\"" + durn_value + "\" ";
		fldString += " interval_value=\"" + interval_value + "\" ";
		fldString += " bl_override_excl_incl_ind=\"" + bl_override_excl_incl_ind + "\" ";
		fldString += " pat_brought_medn=\"" + pat_brought_medn + "\" ";
		fldString += " sliding_scale_yn=\"" + sliding_scale_yn + "\" ";
		fldString += " billable_item_yn=\"" + billable_item_yn + "\" ";
		fldString += " take_home_medication=\"" + take_home_medication + "\" ";
		fldString += " called_from=\"" + called_from + "\" ";
		fldString += " order_Date=\"" + order_Date + "\" ";
		fldString += " bl_overriden_action_reason=\"" + bl_overriden_action_reason + "\" ";

		
		var xmlStr = formXMLString(frmObj_pres_dtl, fldString);	
		fieldValidation(xmlStr, "getChargeDetails"); 
	}
}
function assignChargeDetails(bl_total_charge_amt, bl_patient_payable_amt, bl_def_excl_incl_ind, bl_approval_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text,bl_override_excl_incl_ind_changed){

	if(bl_error_code=='' && bl_sys_message_id=='' && bl_error_text ==''){
		var bl_override_excl_incl_ind = bl_def_excl_incl_ind;
		//document.rxDetailsViewForm.bl_def_override_excl_incl_ind.value =bl_def_excl_incl_ind;
        
		var bl_total_charge_amt_result = Math.round(bl_total_charge_amt*100)/100;		
		bl_total_charge_amt_result = bl_total_charge_amt_result.toString();
		
		var bl_patient_payable_amt_result = Math.round(bl_total_charge_amt*100)/100;
		bl_patient_payable_amt_result = bl_patient_payable_amt_result.toString();
		
		if(document.rxDetailsViewForm.billable_item_yn.value == "N"){
			document.getElementById("bl_total_charge_amt_detvw").innerHTML ="--";
			document.getElementById("bl_patient_payable_amt_detvw").innerHTML = "--";
		}
		else if(document.rxDetailsViewForm.brought_by_pat!=null && document.rxDetailsViewForm.brought_by_pat!=undefined && document.rxDetailsViewForm.brought_by_pat.checked == true){
			document.getElementById("bl_total_charge_amt_detvw").innerHTML ="--";
			document.getElementById("bl_patient_payable_amt_detvw").innerHTML = "--";
		}
		else if(bl_total_charge_amt_result == "0" && bl_patient_payable_amt_result == "0"){
			document.getElementById("bl_total_charge_amt_detvw").innerHTML = "--";
			document.getElementById("bl_patient_payable_amt_detvw").innerHTML = "--";
		}
	    else{
			document.getElementById("bl_total_charge_amt_detvw").innerHTML = bl_total_charge_amt;
			document.getElementById("bl_patient_payable_amt_detvw").innerHTML = bl_patient_payable_amt;
		}		

	}
}

function clearDrugdetails(sliding_scale_yn){
}

function alertBLErrorDrugs(blErrorDrugs, called_from){
}

$(document).ready(function() {
    var path;
    $("#confirmMsg").hide();
    setTimeout(function() {
        assignPharmRxDetailsScroller();
    }, 500);
    readyRxDetailsControls();
    rxDurationCalculation();
    rxDosageByCalculation();
    populateEndDate();
    rxValidation = new rxValidation();    
    showBillingDetails();
	checkForPRN();
	ValidateAbs(document.rxDetailsViewForm.absol_qty);
});
$("#rxStartDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm" //24 hours format
});

function rxDurationCalculation() {
    $('#rxDurationDetails').on('input', function(event) {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $("#rxDurationDetails").focusout(function() {
        var durationDetails = $("#rxDurationDetails").val();

        if (durationDetails == null || durationDetails == 0) {
            showToastMsg("Duration cannot be zero or blank");
            $("#rxDurationDetails").val(document.rxDetailsViewForm.tmp_durn_value.value);
        }
        validateDuration(this);

        var frmObj_pres_dtl = "";
        frmObj_pres_dtl = document.rxDetailsViewForm;
        var durn_desc = frmObj_pres_dtl.durationDpList;
        durationConversn(durn_desc);
        populateEndDate();
    });
}
function showToastMsg(content) {
    $("#contentRxToastMsg1").text(content);
    $("#transactionMsg1").show();
    setTimeout(function() {
        $("#transactionMsg1").hide();
    }, 5000);
    $("#transactionMsg1").bind('click', function() {
        $(this).hide();
    });
    hideAllKeyboards();
     
}

function rxDosageByCalculation() {
    $('#rxDosageByVal').on('input', function(event) {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
    $("#rxDosageByVal").focusout(function() {
        var dosageValue = $("#rxDosageByVal").val();
        if (dosageValue == null || dosageValue == 0) {
            showToastMsg("Dosage cannot be zero or blank");
            var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value();
            if (dosage_type == "Q")
                $("#rxDosageByVal").val(document.rxDetailsViewForm.tab_qty_value.value);
            else
                $("#rxDosageByVal").val(document.rxDetailsViewForm.strength_value.value);
            lookForChange(document.getElementById("rxDosageByVal"));
        }
    });
}

var btnCloseClicked = false;

function okClickDialog() {
	if(btnCloseClicked) {
		var formobj = document.rxDetailsViewForm;
		var DRUG_CODE = document.rxDetailsViewForm.drug_code.value;
        var SRL_NO = document.rxDetailsViewForm.srl_no.value;
		var freq_chng_durn_desc = document.rxDetailsViewForm.freq_chng_durn_desc.value;
		
		var fldString = " DRUG_CODE=\"" + DRUG_CODE + "\" ";
        fldString += " SRL_NO=\"" + SRL_NO + "\" ";
		fldString += " DURN_VALUE=\"" + formobj.durn_value.value + "\" ";
		fldString += " freq_chng_durn_desc=\"" + freq_chng_durn_desc + "\" ";
		
        var xmlStr = formXMLString(formobj, fldString);	
		fieldValidation(xmlStr, "revertRxDetails"); 
	}
    $("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
}

function cancelClickDialog() {
    $("#confirmMsg").hide();
}

function closeRxDetailsView() {
	btnCloseClicked = true;
    $("#confirmMsg").show();
}

function completeRxDetailsConfirm() {
    var ALLERGY_REMARKS = "";
    if (document.rxDetailsViewForm.txtAllergyOverReason) {
        if (document.rxDetailsViewForm.txtAllergyOverReason.value == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
        ALLERGY_REMARKS = encodeURIComponent(document.rxDetailsViewForm.txtAllergyOverReason.value, "UTF-8");
    }
	 var formobjPrnMandatory = document.rxDetailsViewForm.man_rem_on_prn_freq_yn.value;	 
	 var freq_nature = document.rxDetailsViewForm.freq_nature.value;
	 if(formobjPrnMandatory == "Y" && freq_nature == "P")
	 {
		  if (document.rxDetailsViewForm.prnTextarea.value == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
	 }
	 
	
    var CURRENTRX_REMARKS = "";
    var tempDupDrugOvrRsn = "";
    if (document.getElementById('drugOverrideRsn'))
        tempDupDrugOvrRsn = document.getElementById('drugOverrideRsn').style.display;
    if (tempDupDrugOvrRsn == "inline-block") {
        if (document.rxDetailsViewForm.txtDupDrugOverReason.value == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
        CURRENTRX_REMARKS = encodeURIComponent(document.rxDetailsViewForm.txtDupDrugOverReason.value, "UTF-8");
    }
    var DOSE_REMARKS = "";
    var tempExceedOvrRsn = "";
    if (document.getElementById('exceedOverrideRsn'))
        tempExceedOvrRsn = document.getElementById('exceedOverrideRsn').style.display;
    if (tempExceedOvrRsn == "inline-block") {
        if (document.rxDetailsViewForm.txtExceedOverReason.value == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
        DOSE_REMARKS = encodeURIComponent(document.rxDetailsViewForm.txtExceedOverReason.value, "UTF-8");
    }

    var INTERACTION_REMARKS = "";
	var PRN_REMARKS="";
    if (document.rxDetailsViewForm.interaction_exists.value == "Y") {
        if (document.rxDetailsViewForm.txtDrugInterOverReason.value == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
        INTERACTION_REMARKS = encodeURIComponent(document.rxDetailsViewForm.txtDrugInterOverReason.value, "UTF-8");
    }
    var DRUG_INDICATION = "";
    if (document.rxDetailsViewForm.txtDrugIndications)
        DRUG_INDICATION = encodeURIComponent(document.rxDetailsViewForm.txtDrugIndications.value, "UTF-8");

    var ROUTE_CODE = $("#routeDpList").data("kendoDropDownList").value();
    if (ROUTE_CODE == null || ROUTE_CODE == "") {
        showToastMsg("Enter mandatory fields");
        return;
    }
    var FREQ_CODE = "";
    if (document.rxDetailsViewForm.frequencyDpList.selectedIndex > -1) {
        var FREQ_CODE = document.rxDetailsViewForm.frequencyDpList.options[document.rxDetailsViewForm.frequencyDpList.selectedIndex].value;
        if (FREQ_CODE.indexOf("--- Select Value ---") > -1 || FREQ_CODE == "") {
            showToastMsg("Enter mandatory fields");
            return;
        }
    } else {
        showToastMsg("Enter mandatory fields");
        return;
    }

    var DURN_TYPE = $("#durationDpList").data("kendoDropDownList").value();
    if (DURN_TYPE == null || DURN_TYPE == "") {
        showToastMsg("Enter mandatory fields");
        return;
    }
    

    var frmObj = document.rxDetailsViewForm;
    if (formValidation("modify", frmObj)) {        
        var DRUG_CODE = document.rxDetailsViewForm.drug_code.value;
        var SRL_NO = document.rxDetailsViewForm.srl_no.value;
        var LIMIT_IND = document.rxDetailsViewForm.limit_ind.value;
        var DOSAGE_TYPE = $("#rxDosageBy").data("kendoDropDownList").value();
        var QTY_VALUE = document.rxDetailsViewForm.rxDosageByVal.value;
        var STRENGTH_VALUE = document.rxDetailsViewForm.strength_value.value;
        var TAB_QTY_VALUE = document.rxDetailsViewForm.tab_qty_value.value;
        var DRUG_REMARKS = encodeURIComponent(document.rxDetailsViewForm.drugRemTextarea.value, "UTF-8");

        var SCHEDULED_YN = document.rxDetailsViewForm.scheduled_yn.value;
        var START_DATE = document.rxDetailsViewForm.rxStartDate.value;
        var END_DATE = document.rxDetailsViewForm.rxEndDate.value;
        var SPLIT_DOSE_YN = document.rxDetailsViewForm.split_dose_yn.value;
        var ROWVAL = document.rxDetailsViewForm.rowVal.value;
        var PRIORITY = $("#rxPriority").data("kendoDropDownList").value();
        var BROUGHT_BY_PAT = document.rxDetailsViewForm.brought_by_pat.value;
	    PRN_REMARKS = encodeURIComponent(document.rxDetailsViewForm.prnTextarea.value, "UTF-8");
        var TRADE_NAME = "";
        var TRADE_CODE = "";
        var REPEAT_DURN_TYPE = "";

        var DURN_VALUE = document.rxDetailsViewForm.rxDurationDetails.value;

        if (document.rxDetailsViewForm.tradeNameDpList.selectedIndex > -1) {
            TRADE_NAME = encodeURIComponent(document.rxDetailsViewForm.tradeNameDpList.options[document.rxDetailsViewForm.tradeNameDpList.selectedIndex].text, "UTF-8");
            TRADE_CODE = document.rxDetailsViewForm.tradeNameDpList.options[document.rxDetailsViewForm.tradeNameDpList.selectedIndex].value;
        }
        var BUILDMAR_YN = "N";
        if (document.rxDetailsViewForm.buildMAR_yn.checked)
            BUILDMAR_YN = "Y";

        var fldString = " DRUG_CODE=\"" + DRUG_CODE + "\" ";
        fldString += " SRL_NO=\"" + SRL_NO + "\" ";
        fldString += " LIMIT_IND=\"" + LIMIT_IND + "\" ";
        fldString += " DOSAGE_TYPE=\"" + DOSAGE_TYPE + "\" ";
        fldString += " QTY_VALUE=\"" + QTY_VALUE + "\" ";
        fldString += " STRENGTH_VALUE=\"" + STRENGTH_VALUE + "\" ";
        fldString += " TAB_QTY_VALUE=\"" + TAB_QTY_VALUE + "\" ";
        fldString += " FREQ_CODE=\"" + FREQ_CODE + "\" ";
        fldString += " SCHEDULED_YN=\"" + SCHEDULED_YN + "\" ";
        fldString += " START_DATE=\"" + START_DATE + "\" ";
        fldString += " SPLIT_DOSE_YN=\"" + SPLIT_DOSE_YN + "\" ";
        fldString += " ROWVAL=\"" + ROWVAL + "\" ";
        fldString += " ROUTE_CODE=\"" + ROUTE_CODE + "\" ";
        fldString += " PRIORITY=\"" + PRIORITY + "\" ";
        fldString += " TRADE_NAME=\"" + TRADE_NAME + "\" ";
        fldString += " TRADE_CODE=\"" + TRADE_CODE + "\" ";
        fldString += " BUILDMAR_YN=\"" + BUILDMAR_YN + "\" ";
        fldString += " DURN_VALUE=\"" + DURN_VALUE + "\" ";
        fldString += " REPEAT_DURN_TYPE=\"" + REPEAT_DURN_TYPE + "\" ";
        fldString += " DURN_TYPE=\"" + DURN_TYPE + "\" ";
        fldString += " END_DATE=\"" + END_DATE + "\" ";
        fldString += " BROUGHT_BY_PAT=\"" + BROUGHT_BY_PAT + "\" ";

        fldString += " ALLERGY_REMARKS=\"" + ALLERGY_REMARKS + "\" ";
        fldString += " CURRENTRX_REMARKS=\"" + CURRENTRX_REMARKS + "\" ";
        fldString += " DOSE_REMARKS=\"" + DOSE_REMARKS + "\" ";
	fldString += " PRN_REMARKS=\"" + PRN_REMARKS + "\" ";
        fldString += " INTERACTION_REMARKS=\"" + INTERACTION_REMARKS + "\" ";
        fldString += " DRUG_INDICATION=\"" + DRUG_INDICATION + "\" ";
        fldString += " DRUG_REMARKS=\"" + DRUG_REMARKS + "\" ";
        

        var formobj = document.rxDetailsViewForm;
        var xmlStr = formXMLString(formobj, fldString);
        $("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
        setTimeout(function() {
            $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
                function(res) {                    
                });
        }, 1000);
        return fieldValidation(xmlStr, "completeRxDetails");        
    }
}

function formValidation(oper_mode, frmObj) {
	var hdr_form = document.PharmBaseForm;
    var tot_strength = "";
    var tot_strength_uom = "";
    var qty = document.rxDetailsViewForm.rxDosageByVal.value;
    var repeat_value = document.rxDetailsViewForm.repeat_value.value;
    var duration = document.rxDetailsViewForm.rxDurationDetails.value;
    var strength_uom_code = document.rxDetailsViewForm.strength_uom.value;
    if ($("#rxDosageBy").data("kendoDropDownList").value() == 'Q') {
        if (document.rxDetailsViewForm.strength_value != "") {
            if (document.rxDetailsViewForm.pres_base_uom.value != (document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].value)) {
                if (document.rxDetailsViewForm.conv_factor.value != "") {
                    var val_1 = parseInt(document.rxDetailsViewForm.conv_factor.value);
                    if (val_1 != "") {
                        qty = qty * parseInt(repeat_value) * parseInt(duration);
                        qty = (qty / val_1)
                    }
                }
            }
        }
        var val_1 = parseInt(document.rxDetailsViewForm.strength_per_pres_uom.value);
        var val_2 = parseInt(document.rxDetailsViewForm.strength_per_value_pres_uom.value);
        var strength_value = parseInt(document.rxDetailsViewForm.strength_value.value);
        if (strength_value > 0) {
            var tot_strength = (((val_1 / val_2)) * qty);
            tot_strength_uom = strength_uom_code;
        } else {
            tot_strength = "0";
            tot_strength_uom = "";
        }
    }

    return_val = true;
    var trade_code = "";
    var trade_name = "";
    if (document.rxDetailsViewForm.tradeNameDpList.selectedIndex > -1) {
        trade_code = document.rxDetailsViewForm.tradeNameDpList.options[document.rxDetailsViewForm.tradeNameDpList.selectedIndex].value;
        trade_name = TRADE_NAME = encodeURIComponent(document.rxDetailsViewForm.tradeNameDpList.options[document.rxDetailsViewForm.tradeNameDpList.selectedIndex].text, "UTF-8");
    }
    var buildMAR_yn = "N";
    if (document.rxDetailsViewForm.buildMAR_yn.checked)
        buildMAR_yn = "Y";
    var order_set_code = document.rxDetailsViewForm.order_set_code.value;
    var split_dose_yn_val = document.rxDetailsViewForm.split_dose_yn_val.value;
    var DrugRemarksEntered = document.rxDetailsViewForm.DrugRemarksEntered.value;
    var patient_id = document.rxDetailsViewForm.patient_id.value;
    var encounter_id = document.rxDetailsViewForm.encounter_id.value;
    var bl_incl_excl_override_reason_code = document.rxDetailsViewForm.bl_incl_excl_override_reason_code.value;
    var bl_incl_excl_override_reason_desc = document.rxDetailsViewForm.bl_incl_excl_override_reason_desc.value;
    var bl_def_override_excl_incl_ind = document.rxDetailsViewForm.bl_def_override_excl_incl_ind.value;
    var bl_override_excl_incl_ind = document.rxDetailsViewForm.bl_override_excl_incl_ind.value;
    var bl_override_allowed_yn = document.rxDetailsViewForm.bl_override_allowed_yn.value;
    var DrugIndicationRemarks = encodeURIComponent(document.rxDetailsViewForm.txtDrugIndications.value, "UTF-8");
    var drug_db_interface_yn = document.rxDetailsViewForm.drug_db_interface_yn.value;
    var drug_db_duptherapy_yn = document.rxDetailsViewForm.drug_db_duptherapy_yn.value;
    var preg_remarks = encodeURIComponent(document.rxDetailsViewForm.preg_remarks.value);
    var drug_code = document.rxDetailsViewForm.drug_code.value;
    var srl_no = document.rxDetailsViewForm.srl_no.value;
    var durn_value = document.rxDetailsViewForm.rxDurationDetails.value;
    var frequency = "";
    if (document.rxDetailsViewForm.frequencyDpList.options.length != 0)
        frequency = document.rxDetailsViewForm.frequencyDpList.options[document.rxDetailsViewForm.frequencyDpList.selectedIndex].value;
    var qty_value = document.rxDetailsViewForm.rxDosageByVal.value;
    var ph_version = document.rxDetailsViewForm.ph_version.value;
    var pract_name = document.rxDetailsViewForm.pract_id.value;
    var start_date = document.rxDetailsViewForm.rxStartDate.value;
    var end_date = document.rxDetailsViewForm.rxEndDate.value;
    var consider_stock_for_pres_yn = document.rxDetailsViewForm.consider_stock_for_pres_yn.value;
    var repeat_durn_type = document.rxDetailsViewForm.repeat_durn_type.value;
    var durn_desc = encodeURIComponent($("#durationDpList").data("kendoDropDownList").text(), "UTF-8");
    var interval_value = document.rxDetailsViewForm.interval_value.value;
    var route_code = $("#routeDpList").data("kendoDropDownList").value();
    var route_desc = encodeURIComponent($("#routeDpList").data("kendoDropDownList").text(), "UTF-8");
    var dosage = $("#rxDosageBy").data("kendoDropDownList").value();
    var freq_nature = document.rxDetailsViewForm.freq_nature.value;
    var freq_desc = "";
    if (document.rxDetailsViewForm.frequencyDpList.options.length != 0)
        freq_desc = encodeURIComponent(document.rxDetailsViewForm.frequencyDpList.options[document.rxDetailsViewForm.frequencyDpList.selectedIndex].text, "UTF-8");
    var qty_desc_code = document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].value;
    var or_qty_desc = encodeURIComponent(document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].text, "UTF-8");
    var dose_override = document.rxDetailsViewForm.dose_override.value;
    var qty_desc = encodeURIComponent(document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].text, "UTF-8");
    var or_durn_desc = encodeURIComponent($("#durationDpList").data("kendoDropDownList").text(), "UTF-8");
    var split_dose = document.rxDetailsViewForm.split_dose.value;
    var split_dose_yn = document.rxDetailsViewForm.split_dose_yn.value;
    var authroize_yn_val = document.rxDetailsViewForm.authroize_yn_val.value;
    var no_refill = document.rxDetailsViewForm.no_refill.value;
    var refill_start_date = document.rxDetailsViewForm.refill_start_date.value;
    var refill_end_date = document.rxDetailsViewForm.refill_end_date.value;
    var admin_time = document.rxDetailsViewForm.admin_time.value;
    var admin_qty = document.rxDetailsViewForm.admin_qty.value;
    var dflt_qty_uom = document.rxDetailsViewForm.dflt_qty_uom.value;
    var in_dispensed_uom = document.rxDetailsViewForm.dosageUOMDpList.options[document.rxDetailsViewForm.dosageUOMDpList.selectedIndex].value;
    var in_total_strength = tot_strength;
    var in_total_strength_uom = tot_strength_uom;
    var in_dispensed_qty = parseInt(qty);
    var in_bms_qty = parseInt(qty);
    var sch_over_yn = document.rxDetailsViewForm.sch_over_yn.value;
    var allergy_yn = document.rxDetailsViewForm.allergy_yn.value;
    var limit_ind = document.rxDetailsViewForm.limit_ind.value;
    var current_rx = document.rxDetailsViewForm.current_rx.value;
    var interaction_exists = document.rxDetailsViewForm.interaction_exists.value;
    var pres_base_uom = document.rxDetailsViewForm.pres_base_uom.value;
    var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value();
    var absol_qty = document.rxDetailsViewForm.absol_qty.value;
    var brought_by_pat = document.rxDetailsViewForm.brought_by_pat.value;
    var allow_duplicate = document.rxDetailsViewForm.allow_duplicate.value;
    var patient_class = hdr_form.act_patient_class.value;
    var take_home = document.rxDetailsViewForm.take_home.value;	
	var pat_counseling_reqd = "N";
	if(document.rxDetailsViewForm.patCounsellingReq.checked)
		pat_counseling_reqd = "Y";	
    var disp_locn_code = document.rxDetailsViewForm.disp_locn_code.value;
    var drug_db_dosecheck_yn = document.rxDetailsViewForm.drug_db_dosecheck_yn.value;
    var ext_prod_id = document.rxDetailsViewForm.ext_prod_id.value;
    var stock_uom = document.rxDetailsViewForm.stock_uom.value;
    var priority = $("#rxPriority").data("kendoDropDownList").value();
    var sliding_scale_yn = document.rxDetailsViewForm.sliding_scale_yn.value;
    var scheduled_yn = document.rxDetailsViewForm.scheduled_yn.value;
    var mono_graph = document.rxDetailsViewForm.mono_graph.value;
    var unit_dose = document.rxDetailsViewForm.unit_dose.value;
    var daily_dose = document.rxDetailsViewForm.daily_dose.value;
    var generic_id = document.rxDetailsViewForm.generic_id.value;


    var override_remarks = "Y";
    var checkEnabled = "";
    var totTapperQty = "0";
    var prevTotalTaperQty = "0";
    var tap_lvl_qty = "";
    var approval_yn_val = "";
    var cosign_yn_val = "";
    var allow_refill = "Refill";
    var called_from = "";
    var xmlStr = "<root><SEARCH ";
    xmlStr += "oper_mode=\"" + oper_mode + "\" ";
    xmlStr += "trade_code=\"" + trade_code + "\" ";
    xmlStr += "trade_name=\"" + trade_name + "\" ";
    xmlStr += "buildMAR_yn=\"" + buildMAR_yn + "\" ";
    xmlStr += "split_dose_yn_val=\"" + split_dose_yn_val + "\" ";
    xmlStr += "DrugRemarksEntered=\"" + DrugRemarksEntered + "\" ";
    xmlStr += "patient_id=\"" + patient_id + "\" ";
    xmlStr += "encounter_id=\"" + encounter_id + "\" ";
    xmlStr += "bl_incl_excl_override_reason_code=\"" + bl_incl_excl_override_reason_code + "\" ";
    xmlStr += "bl_incl_excl_override_reason_desc=\"" + bl_incl_excl_override_reason_desc + "\" ";
    xmlStr += "bl_def_override_excl_incl_ind=\"" + bl_def_override_excl_incl_ind + "\" ";
    xmlStr += "bl_override_excl_incl_ind=\"" + bl_override_excl_incl_ind + "\" ";
    xmlStr += "bl_override_allowed_yn=\"" + bl_override_allowed_yn + "\" ";
    xmlStr += "DrugIndicationRemarks=\"" + DrugIndicationRemarks + "\" ";
    xmlStr += "drug_db_interface_yn=\"" + drug_db_interface_yn + "\" ";
    xmlStr += "drug_db_duptherapy_yn=\"" + drug_db_duptherapy_yn + "\" ";
    xmlStr += "preg_remarks=\"" + preg_remarks + "\" ";
    xmlStr += "override_remarks=\"" + override_remarks + "\" ";
    xmlStr += "checkEnabled=\"" + checkEnabled + "\" ";
    xmlStr += "drug_code=\"" + drug_code + "\" ";
    xmlStr += "srl_no=\"" + srl_no + "\" ";
    xmlStr += "durn_value=\"" + durn_value + "\" ";
    xmlStr += "frequency=\"" + frequency + "\" ";
    xmlStr += "qty_value=\"" + qty_value + "\" ";
    xmlStr += "repeat_value=\"" + repeat_value + "\" ";
    xmlStr += "ph_version=\"" + ph_version + "\" ";
    xmlStr += "pract_name=\"" + pract_name + "\" ";
    xmlStr += "start_date=\"" + start_date + "\" ";
    xmlStr += "end_date=\"" + end_date + "\" ";
    xmlStr += "consider_stock_for_pres_yn=\"" + consider_stock_for_pres_yn + "\" ";
    xmlStr += "repeat_durn_type=\"" + repeat_durn_type + "\" ";
    xmlStr += "durn_desc=\"" + durn_desc + "\" ";
    xmlStr += "interval_value=\"" + interval_value + "\" ";
    xmlStr += "route_code=\"" + route_code + "\" ";
    xmlStr += "route_desc=\"" + route_desc + "\" ";
    xmlStr += "dosage=\"" + dosage + "\" ";
    xmlStr += "freq_nature=\"" + freq_nature + "\" ";
    xmlStr += "freq_desc=\"" + freq_desc + "\" ";
    xmlStr += "qty_desc_code=\"" + qty_desc_code + "\" ";
    xmlStr += "or_qty_desc=\"" + or_qty_desc + "\" ";
    xmlStr += "totTapperQty=\"" + totTapperQty + "\" ";
    xmlStr += "prevTotalTaperQty=\"" + prevTotalTaperQty + "\" ";
    xmlStr += "tap_lvl_qty=\"" + tap_lvl_qty + "\" ";
    xmlStr += "dose_override=\"" + dose_override + "\" ";
    xmlStr += "qty_desc=\"" + qty_desc + "\" ";
    xmlStr += "or_durn_desc=\"" + or_durn_desc + "\" ";
    xmlStr += "split_dose=\"" + split_dose + "\" ";
    xmlStr += "split_dose_yn=\"" + split_dose_yn + "\" ";
    xmlStr += "authroize_yn_val=\"" + authroize_yn_val + "\" ";
    xmlStr += "no_refill=\"" + no_refill + "\" ";
    xmlStr += "refill_start_date=\"" + refill_start_date + "\" ";
    xmlStr += "refill_end_date=\"" + refill_end_date + "\" ";
    xmlStr += "admin_time=\"" + admin_time + "\" ";
    xmlStr += "admin_qty=\"" + admin_qty + "\" ";
    xmlStr += "dflt_qty_uom=\"" + dflt_qty_uom + "\" ";
    xmlStr += "in_dispensed_uom=\"" + in_dispensed_uom + "\" ";
    xmlStr += "in_total_strength=\"" + in_total_strength + "\" ";
    xmlStr += "in_total_strength_uom=\"" + in_total_strength_uom + "\" ";
    xmlStr += "in_dispensed_qty=\"" + in_dispensed_qty + "\" ";
    xmlStr += "in_bms_qty=\"" + in_bms_qty + "\" ";
    xmlStr += "sch_over_yn=\"" + sch_over_yn + "\" ";
    xmlStr += "allergy_yn=\"" + allergy_yn + "\" ";
    xmlStr += "limit_ind=\"" + limit_ind + "\" ";
    xmlStr += "current_rx=\"" + current_rx + "\" ";
    xmlStr += "interaction_exists=\"" + interaction_exists + "\" ";
    xmlStr += "pres_base_uom=\"" + pres_base_uom + "\" ";
    xmlStr += "dosage_type=\"" + dosage_type + "\" ";
    xmlStr += "absol_qty=\"" + absol_qty + "\" ";
    xmlStr += "brought_by_pat=\"" + brought_by_pat + "\" ";
    xmlStr += "allow_duplicate=\"" + allow_duplicate + "\" ";
    xmlStr += "patient_class=\"" + patient_class + "\" ";
    xmlStr += "take_home=\"" + take_home + "\" ";
    xmlStr += "pat_counseling_reqd=\"" + pat_counseling_reqd + "\" ";
    xmlStr += "disp_locn_code=\"" + disp_locn_code + "\" ";
    xmlStr += "drug_db_dosecheck_yn=\"" + drug_db_dosecheck_yn + "\" ";
    xmlStr += "ext_prod_id=\"" + ext_prod_id + "\" ";
    xmlStr += "stock_uom=\"" + stock_uom + "\" ";
    xmlStr += "priority=\"" + priority + "\" ";
    xmlStr += "sliding_scale_yn=\"" + sliding_scale_yn + "\" ";
    xmlStr += "scheduled_yn=\"" + scheduled_yn + "\" ";
    xmlStr += "mono_graph=\"" + mono_graph + "\" ";
    xmlStr += "unit_dose=\"" + unit_dose + "\" ";
    xmlStr += "daily_dose=\"" + daily_dose + "\" ";
    xmlStr += "generic_id=\"" + generic_id + "\" ";
    xmlStr += "called_from=\"" + called_from + "\" ";
    var bean_id = document.rxDetailsViewForm.bean_id.value;
    var bean_name = document.rxDetailsViewForm.bean_name.value;
    xmlStr += " bean_id=\"" + bean_id + "\" ";
    xmlStr += " bean_name=\"" + bean_name + "\" ";
    if (document.rxDetailsViewForm.presBean_id != undefined) {
        var presBean_id = document.rxDetailsViewForm.presBean_id.value;
        var presBean_name = document.rxDetailsViewForm.presBean_name.value;
        xmlStr += " presBean_id=\"" + presBean_id + "\" ";
        xmlStr += " presBean_name=\"" + presBean_name + "\" ";
    }
    xmlStr += " /></root>";
    if (navigator.appName.indexOf("Internet") == -1) {
        xmlHttpObj = new XMLHttpRequest();
        var oParser = new DOMParser();
        xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
    } else {
        xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
        xmlDoc = new ActiveXObject("Microsoft.XMLDom");
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    }

    xmlHttpObj.onreadystatechange = function() {
        if (xmlHttpObj.readyState == 4 && xmlHttpObj.status == 200) {
            var responseText = xmlHttpObj.responseText;

            if (responseText.length > 0) {
                if (oper_mode == "delete" || oper_mode == "modify" || oper_mode == "taper" || oper_mode == "tapered")
                    eval(responseText);
            }
        }
    }

    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionRxValidation.jsp?func_mode=InsertRec", false);
    xmlHttpObj.send(xmlDoc);
    return return_val;
}

function alertIntr(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn) {
    return false;
}

function alertNoTaper(error) {
    refresh_screen = false;
    if (error == "greater") {
        showToastMsg("Taper Values should be less than parent values");
    } else if (error == "lesser") {
        showToastMsg("Taper Values should be greater than Parent Values");
    } else if (error == 'changefreq') {
        showToastMsg("Can not prescribe same drug with same frequency nature.");
    } else if (error == 'stat_prn') {
        showToastMsg("stat prn");
    } else {
        showToastMsg("No Changes is being made to Taper Dose");
    }
    return false;
}

function alertNoAvailStock(available_stock, uom) {
    showToastMsg("Insufficient Stock / Expiring item for the prescribed period");
    return_val = false;
}

function duplicateWarning() {
    var msg = "Patient is currently on || medication. Only Stat Dose can be prescribed";
    var all_msg = msg.split("||");
    showToastMsg(all_msg[0] + document.rxDetailsViewForm.generic_name.value + all_msg[1]);
    return_val = false;
}

function alertParentRecord(oper_mode, frm, prev_drun_value) {
    if (oper_mode == "delete")
        showToastMsg("Cannot delete the drug being tapered");
    else {
        showToastMsg("Cannot modify the drug being tapered");

        if (frm != undefined && frm != 'confirm') {
            document.rxDetailsViewForm.rxDurationDetails.value = prev_drun_value;
        }
    }
}

function enableDiscCancelOrders(patient_id, encounter_id, GENERIC_ID, start_date, end_date, frequency, drugCode, srlNo, drug_db_interface_yn, ext_prod_id, status, sliding_scale_yn) {
    //console.log("enableDiscCancelOrders");
}

function deleteOROrderCatalog(drug_code, called_from) {
   // console.log("deleteOROrderCatalog");
}

function readyRxDetailsControls() {
    $('textarea').each(function(index) {
        $(this).bind('touchmove', function(event) {
            event.stopPropagation();
        });
    });

    var priorityVal = $("#hdnpriorityValue").val();
    var routeSelVal = $("#hdnRouteSelValue").val();
    var tradeSelVal = $("#hdnTradeSelValue").val();
    var dosageType = $("#hdnDosageType").val();
    var oriDosageType = $("#hdnOriDosageType").val();
    var buildMarChecked = $("#hdnbuildMarChecked").val();
    var strengthValue = $("#hdnStrengthVal").val();
    var buildMarEnable = $("#hdnbuildMarEnable").val();
    var tradeOptionEnable = $("#hdnTradeOptionEnable").val();
    var startdate = $("#start_date").val();
    //Priotity	 
    //var priorityValue = [{value:"Routine",text:"Routine"}, {value:"Urgent", text:"Urgent"}];

    function onPriorityChange() {
        getBuildMARDefaulting();
        defFreq(this);
    };
    $("#rxPriority").kendoDropDownList({
        //dataSource: priorityValue,
        change: onPriorityChange
    });

    var dropdownlist = $("#rxPriority").data("kendoDropDownList");
    if (priorityVal != "" && priorityVal == "U") {
        dropdownlist.value("U");
    } else if (priorityVal != "" && priorityVal != "R") {
        dropdownlist.value("R");
    }
    //end

    //Route 		 
    function onrouteChange() {

    };
    var route = $("#routeDpList").kendoDropDownList({
        cascade: onrouteChange,
    });
    //end

    //Trade Name  
    if (tradeOptionEnable == "disabled") {
        $('#tradeNameDpList').prop('disabled', true);
    }

    function onTradeChange() {                          				
    };
    var trade = $("#tradeNameDpList").kendoDropDownList({
        change: onTradeChange,
    });
    //end

    //Dosage By 		  
    var dosageSelectedVal = '';
    var dosageTypeVal;
    if (dosageType == "A") {
        dosageTypeVal = [{
            id: "A",
            description: "Absolute"
        }];
        dosageSelectedVal = 0;
    } else if (dosageType == "S") {
        dosageTypeVal = [{
            id: "S",
            description: "Strength"
        }, {
            id: "Q",
            description: "Quantity"
        }];
        dosageSelectedVal = 0;
    } else if (dosageType == "Q") {
        if (oriDosageType == "S") {
            dosageTypeVal = [{
                id: "S",
                description: "Strength"
            }, {
                id: "Q",
                description: "Quantity"
            }];
            dosageSelectedVal = 1;
        } else {
            dosageTypeVal = [{
                id: "Q",
                description: "Quantity"
            }];
            dosageSelectedVal = 0;
        }
    }

    function populateQty() {

        this.form_code = "";
        this.drug_code = "";
        this.pres_base_uom = "";
        this.pres_base_uom_desc = "";
        this.rx_qty_by_pres_base_uom_yn = "";

    }

    function fieldValidationJson(obj, source, control_id) {
        var xmlHttpObj;
        if (navigator.appName.indexOf("Internet") == -1) {
            xmlHttpObj = new XMLHttpRequest();
            var oParser = new DOMParser();
            xmlDoc = oParser.parseFromString(obj, "text/xml");
        } else {
            xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
            xmlDoc = new ActiveXObject("Microsoft.XMLDom");
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        }

        xmlHttpObj.onreadystatechange = function() {
            if (xmlHttpObj.readyState == 4 && xmlHttpObj.status == 200) {
                var responseText = xmlHttpObj.responseText;

                if (responseText.length > 0) {
                    rxValidation[control_id] = responseText;
                    eval(responseText);
                }
            }
        }

        xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionRxValidation.jsp?func_mode=" + source, false);
        xmlHttpObj.send(xmlDoc);
    }

    function onDosageByChange() {
        var rxDosageBy = $("#rxDosageBy").data("kendoDropDownList");
        if (rxDosageBy) {
            var dosage_type = rxDosageBy.value();
            var recomm_dosage_by = document.rxDetailsViewForm.recomm_dosage_by.value;

            if (dosage_type == "A") {} else {
                deleteScheduleLink();
                DisableSchedule1();
                if (dosage_type == "S") {
                    dfltStrnQtyDescList();
                } else {
                    populateQtyDesc2();
                }
                validateQtyDesc(dosage_type, '');
                storeSchedule();
            }
        }
    };

    function populateQtyDesc2() {
        var dose = $("#rxDosageBy").data("kendoDropDownList").value();
        document.rxDetailsViewForm.hdnDosageType.value = $("#rxDosageBy").data("kendoDropDownList").value();

        var qty = new populateQty();

        qty.form_code = $("input[name=form_code]").val();
        qty.drug_code = $("input[name=drug_code]").val();
        qty.pres_base_uom = $("input[name=pres_base_uom]").val();
        qty.pres_base_uom_desc = $("input[name=pres_base_uom_desc]").val();
        qty.rx_qty_by_pres_base_uom_yn = $("input[name=rx_qty_by_pres_base_uom_yn]").val();

        var fldString = " form_code=\"" + qty.form_code + "\" ";
        fldString += " drug_code=\"" + qty.drug_code + "\" ";
        fldString += " pres_base_uom=\"" + qty.pres_base_uom + "\" ";
        fldString += " pres_base_uom_desc=\"" + qty.pres_base_uom_desc + "\" ";
        fldString += " rx_qty_by_pres_base_uom_yn=\"" + qty.rx_qty_by_pres_base_uom_yn + "\" ";

        var formobj = document.rxDetailsViewForm;
        var xmlStr = formXMLString(formobj, fldString);

        fieldValidationJson(xmlStr, "populateQtyDesc", "quantity");
    }

    function dfltStrnQtyDescList() {
        clearQtyDescList();

        var dosageUOMDpList = $("#dosageUOMDpList").data("kendoDropDownList");
        if (dosageUOMDpList) {
            $("#dosageUOMDpList").getKendoDropDownList().dataSource.insert({
                value: document.rxDetailsViewForm.strength_uom.value,
                text: document.rxDetailsViewForm.strength_uom_desc.value
            });
            dosageUOMDpList.value(document.rxDetailsViewForm.strength_uom.value);
        }
    }

    $("#rxDosageBy").kendoDropDownList({
        dataSource: dosageTypeVal,
        dataTextField: "description",
        dataValueField: "id",
        change: onDosageByChange,
    });
    if (dosageSelectedVal != null && dosageSelectedVal != "") {
        var doasgeByDropdownlist = $("#rxDosageBy").data("kendoDropDownList");
        doasgeByDropdownlist.select(dosageSelectedVal);
    }
    //End
    function clearQtyDescList() {
        var ddl = $("#dosageUOMDpList").data("kendoDropDownList");
        if (ddl)
            ddl.dataSource.data([]);
    }
    function addQtyDescList(code, desc) {
        var dosageUOMDpList = $("#dosageUOMDpList").data("kendoDropDownList");
        if (dosageUOMDpList) {
            $("#dosageUOMDpList").getKendoDropDownList().dataSource.insert({
                value: code,
                text: desc
            });
        }
    }
    var trade = $("#dosageUOMDpList").kendoDropDownList({
        change: onDosageUOMChange,
    });

    function setdfltQtyUom(code) {
        var dosage = document.rxDetailsViewForm.hdnDosageType.value;
        var dosageUOMDpList = $("#dosageUOMDpList").data("kendoDropDownList");
        if (dosageUOMDpList) {
            $("#dosageUOMDpList").data("kendoDropDownList").value(code);

            if (document.rxDetailsViewForm.hdnDosageType.value == 'Q') {
                if (document.rxDetailsViewForm.dflt_qty_uom.value == "") {
                    document.rxDetailsViewForm.dflt_qty_uom.value = code;
                }
            } else {
                if (document.rxDetailsViewForm.dflt_qty_uom.value == "") {
                    document.rxDetailsViewForm.dflt_qty_uom.value = code;
                } else if (document.rxDetailsViewForm.hdnDosageType.value == 'A') {
                    document.rxDetailsViewForm.dflt_qty_uom.value = document.rxDetailsViewForm.qty_desc_code.value;
                }
            }
        }
    }
    function dfltQtyDesc() {
        var dosageUOMDpList = $("#dosageUOMDpList").data("kendoDropDownList");
        if (dosageUOMDpList) {
            var dosage_type = document.rxDetailsViewForm.hdnDosageType.value;
            if (dosage_type == "S") {
                dosageUOMDpList.value(document.rxDetailsViewForm.strength_uom.value);
                dosageUOMDpList.enable(true);
            } else if (dosage_type == "Q") {                
                var rx_qty_by_pres_base_uom_yn = document.rxDetailsViewForm.rx_qty_by_pres_base_uom_yn.value;

                if (rx_qty_by_pres_base_uom_yn == "Y")
                    dosageUOMDpList.enable(false);
                else
                    dosageUOMDpList.enable(true);
            } else if (dosage_type == "A") {
                dosageUOMDpList.value(document.rxDetailsViewForm.dflt_qty_uom.value);

                var rx_qty_by_pres_base_uom_yn = frameobj.document.rxDetailsViewForm.rx_qty_by_pres_base_uom_yn.value;
                if (rx_qty_by_pres_base_uom_yn == "Y")
                    dosageUOMDpList.enable(false);
                else
                    dosageUOMDpList.enable(true);
            }
        }
    }

    //Dosage UOM  
    function onDosageUOMChange() {


    }
    var trade = $("#dosageUOMDpList").kendoDropDownList({
        change: onDosageUOMChange,
    });
    //end


    //Frequency Name  
    function onFrequencyChange() {
        //alert($("#frequencyDpList").data("kendoDropDownList").value());                       				
    };
    var trade = $("#frequencyDpList").kendoDropDownList({
        cascade: onFrequencyChange,
    });
    //end

    //duration month 		  
    function onDurationChange() {
        var frmObj_pres_dtl = "";        
        frmObj_pres_dtl = document.rxDetailsViewForm;
        validateDuration(frmObj_pres_dtl.rxDurationDetails);
        populateEndDate();
        durationConversn(frmObj_pres_dtl.durationDpList);
		showBillingDetails();
    };
    var trade = $("#durationDpList").kendoDropDownList({
        cascade: onDurationChange,
    });
    //end

    $("#rxStartDate").change(function() {        
        var locale = document.rxDetailsViewForm.language_id.value;
        chkBackFutureDate(this, locale);        
    });
    $("#rxEndDate").change(function() {        
        var locale = document.rxDetailsViewForm.language_id.value;
        validateEndDate(this, locale);        
    });

    $("#rxEndDate").kendoDateTimePicker({
        format: "dd/MM/yyyy HH:mm",
        timeFormat: "HH:mm" //24 hours format
    });

    //BuildMar checkBox
    if (buildMarChecked == "checked") {
        $('#buildMarChk').prop('checked', true);
    } else {
        $('#buildMarChk').prop('checked', false);
    }
    //BuildMar checkBox Enable OR disable
    if (buildMarEnable == "disabled") {
        $('#buildMarChk').prop('disabled', true);
    } else {
        $('#buildMarChk').prop('disabled', false);
    }

    if (startdate != "" && startdate != null) {        
        document.rxDetailsViewForm.rxStartDate.value = startdate;
    }
}
//Indicator Starts

var flagbilling = "N";
var oldrepeatvalue;

//common for calling TEMP JSP for Validations
function fieldValidation(xmlStr, source) {

    var xmlHttpObj;
    if (navigator.appName.indexOf("Internet") == -1) {
        xmlHttpObj = new XMLHttpRequest();
        var oParser = new DOMParser();
        xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
    } else {
        xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
        xmlDoc = new ActiveXObject("Microsoft.XMLDom");
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    }

    xmlHttpObj.onreadystatechange = function() {
        if (xmlHttpObj.readyState == 4 && xmlHttpObj.status == 200) {
            var responseText = xmlHttpObj.responseText;

            if (responseText.length > 0) {
                eval(responseText);
            }
        }
    }

    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionRxValidation.jsp?func_mode=" + source, false);
    xmlHttpObj.send(xmlDoc);

    return true;
}


function validateDuration(obj, frm, sliding_scale_yn) {
	var hdr_form = document.PharmBaseForm;
    var drnValue = obj.value;
    if (isNaN(drnValue)) {
        showToastMsg("Only number is allowed");
        obj.value = "1";
        //obj.focus();
    }
    var durn_value = parseInt(Math.abs(obj.value));
    var frmObj_pres_dtl = "";
    obj.value = durn_value;
    var order_set_code = ""; 
    if (parseInt(obj.value) == 0 || obj.value == "") {
        obj.value = "1";
        //obj.focus();
    }
    if (!CheckPositiveNumber1(obj))
        return false;

    if (validateMaxRefillDuration('durn', frm, sliding_scale_yn)) {
        if (frm == "confirm") {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        } else if (frm == "release" || sliding_scale_yn == 'Y') {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        } else {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        }

        if (frmObj_pres_dtl.order_set_code != undefined && frmObj_pres_dtl.order_set_code != null)

            order_set_code = frmObj_pres_dtl.order_set_code.value;

        var freq_value = frmObj_pres_dtl.freq_value.value;
        var calculated_value = "";
        var interval_value = frmObj_pres_dtl.interval_value.value;
        var durn_desc = $("#durationDpList").data("kendoDropDownList").value();
        var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
        var freq_nature = frmObj_pres_dtl.freq_nature.value;

        if (freq_nature == "F" && interval_value > 1) {
            if ((durn_value % interval_value) > 0) {
                var rem = durn_value % interval_value;
                var prev_day = durn_value - rem;
                var nxt_day = parseInt(durn_value) - parseInt(rem) + parseInt(interval_value);
                var err_msg = "Duration value can be $ or # or a multiple of %";
                if (prev_day == 0) {
                    err_msg = err_msg.replace('$ or ', "");
                } else
                    err_msg = err_msg.replace('$', prev_day);
                err_msg = err_msg.replace('#', nxt_day);
                err_msg = err_msg.replace('%', interval_value);
                showToastMsg(err_msg);                
                //frmObj_pres_dtl.rxDurationDetails.focus();
            }
        }
        if (freq_value == "0") {
            var calc = parseFloat(obj.value / interval_value);
            calculated_value = Math.ceil(calc);
        } else {
            calculated_value = freq_value;
        }

        frmObj_pres_dtl.calcualted_durn_value.value = calculated_value;

        var durn_value = obj.value;
        var source = "modify";
        if (durn_value != "") {
            var drug_code = frmObj_pres_dtl.drug_code.value;
            var patient_class = hdr_form.act_patient_class.value;
            var srlNo = frmObj_pres_dtl.srl_no.value;
            var freq_chng_durn_desc = $("#durationDpList").data("kendoDropDownList").value();
            var freq_chng_durn_value = frmObj_pres_dtl.rxDurationDetails.value;
            var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
            var fldString = " durn_value=\"" + durn_value + "\" ";
            fldString += " drug_code=\"" + drug_code + "\" ";
            fldString += " patient_class=\"" + patient_class + "\" ";
            fldString += " source=\"" + source + "\" ";
            fldString += " srlNo=\"" + srlNo + "\" ";
            fldString += " frm=\"" + frm + "\" ";
            fldString += " freq_chng_durn_desc=\"" + freq_chng_durn_desc + "\" ";
            fldString += " freq_chng_durn_value=\"" + freq_chng_durn_value + "\" ";
            fldString += " sliding_scale_yn=\"" + sliding_scale_yn + "\" ";
            fldString += " repeat_durn_type=\"" + repeat_durn_type + "\" ";
            fldString += " interval_value=\"" + interval_value + "\" ";
            fldString += " order_set_code=\"" + order_set_code + "\" ";
            var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
            return fieldValidation(xmlStr, "validateDuration");
        }
    } else {
        return false;
    }
    return true;
}

function validateMaxRefillDuration(mode, frm, sliding_scale_yn) {
    if (mode == "refill") {
        var durn_value = document.rxDetailsViewForm.rxDurationDetails.value;
        if (durn_value == "") durn_value = "0";
        durn_value = parseInt(durn_value);
        var max_durn_for_refill_pres = parseInt(document.rxDetailsViewForm.max_durn_for_refill_pres.value);
        var refill = document.rxDetailsViewForm.no_refill.value;
        if (refill == "")
            refill = "0";
        refill = parseInt(refill);
        if ((refill * durn_value) <= max_durn_for_refill_pres) {
            return true;
        } else {
            document.rxDetailsViewForm.no_refill.value = "";
            showToastMsg("Refill duration exceeds the limit");
            //document.rxDetailsViewForm.no_refill.focus();
            return false;
        }
    } else {
        var frmObj_pres_dtl = "";
        if (frm == "confirm" && !(sliding_scale_yn == 'Y')) {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        } else if (frm == "release") {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        } else {
            frmObj_pres_dtl = document.rxDetailsViewForm;
        }
        if (sliding_scale_yn == 'Y') {
            return true;
        }
        var durn_value = frmObj_pres_dtl.rxDurationDetails.value;
        if (durn_value == "") durn_value = "0";
        durn_value = parseInt(durn_value);
        var max_durn_for_refill_pres = parseInt(frmObj_pres_dtl.max_durn_for_refill_pres.value);
        var refill = frmObj_pres_dtl.no_refill.value;

        if (refill == "") refill = "0";
        refill = parseInt(refill);
        if (frmObj_pres_dtl.drug_code.value != "") {
            if ((refill * durn_value) <= max_durn_for_refill_pres) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}

//common for forming XML String
function formXMLString(formobj, fldString) {
    var bean_id = formobj.bean_id.value;
    var bean_name = formobj.bean_name.value;
    if (formobj.presBean_id != undefined) {
        var presBean_id = formobj.presBean_id.value;
        var presBean_name = formobj.presBean_name.value;
    }
    var mode = formobj.mode.value;
    var xmlStr = "<root><SEARCH ";
    xmlStr += " bean_id=\"" + bean_id + "\" ";
    xmlStr += " bean_name=\"" + bean_name + "\" ";
    if (formobj.presBean_id != undefined) {
        xmlStr += " presBean_id=\"" + presBean_id + "\" ";
        xmlStr += " presBean_name=\"" + presBean_name + "\" ";
    }
    xmlStr += " mode=\"" + mode + "\" ";
    xmlStr += fldString;
    xmlStr += " /></root>";
    return xmlStr;
}

function freqChange(obj, flag, sliding_scale_yn, callFrom, pBilling) {
    flagbilling = "Y";
    var in_formulary_yn = document.rxDetailsViewForm.in_formulary_yn.value;
    if (callFrom == undefined || callFrom == null)
        callFrom = "";
    if (rxDetailsViewForm.drug_code.value != "") {
        var ordPriority = $("#rxPriority").data("kendoDropDownList").value();
        var currPriority = "";
        var qty_value = document.rxDetailsViewForm.rxDosageByVal.value;
        if (qty_value == "" || parseFloat(qty_value) == 0) {
            showToastMsg("Refill duration exceeds the limit");
            document.rxDetailsViewForm.rxDosageByVal.value = '0';
            //document.rxDetailsViewForm.rxDosageByVal.focus();
            return false;
        }
		
        populateDurationDesc(obj);
        checkForPRN(obj);
        if (document.rxDetailsViewForm.rxDosageByVal.value == '') {
            document.rxDetailsViewForm.rxDosageByVal.value = '0';
        }
        if (rxDetailsViewForm.allow_duplicate.value != "Y" && callFrom == 'ChangeFreq')
            checkDuplicateDrug(rxDetailsViewForm, obj.value, 'ChangeFreq');
        if (document.rxDetailsViewForm.freq_nature.value == "P" || document.rxDetailsViewForm.freq_nature.value == "O" || document.rxDetailsViewForm.sliding_scale_yn.value == 'Y') {
            if (document.rxDetailsViewForm.freq_nature.value == 'O') {
                document.rxDetailsViewForm.tmp_durn_value.value = '1';
                if (document.rxDetailsViewForm.sliding_scale_yn.value != 'Y') {
                    var external_patient_id = document.rxDetailsViewForm.external_patient_id.value;
                    if (document.rxDetailsViewForm.hdnpriorityValue.value != 'U' && callFrom == 'ChangeFreq' && external_patient_id == "") { //external_patient_id  added for  [IN:040734]
                        document.rxDetailsViewForm.hdnpriorityValue.value = 'U';
                        $("#rxPriority").data('kendoDropDownList').value("U");
                        currPriority = document.rxDetailsViewForm.hdnpriorityValue.value;
                        if (ordPriority != currPriority)
                            getBuildMARDefaulting();
                    }
                }
            } else {
                if (document.rxDetailsViewForm.sliding_scale_yn.value != 'Y') {
                    if (document.rxDetailsViewForm.freq_nature.value != 'O' && callFrom == 'ChangeFreq') {
                        document.rxDetailsViewForm.hdnpriorityValue.value = 'R';
                        $("#rxPriority").data('kendoDropDownList').value("R");
                        currPriority = document.rxDetailsViewForm.hdnpriorityValue.value;
                        if (ordPriority != currPriority)
                            getBuildMARDefaulting();
                    } else if (callFrom == 'ChangeFreq') {
                        document.rxDetailsViewForm.hdnpriorityValue.value = 'U';
                        $("#rxPriority").data('kendoDropDownList').value("U");
                        currPriority = document.rxDetailsViewForm.hdnpriorityValue.value;
                        if (ordPriority != currPriority)
                            getBuildMARDefaulting();
                    }
                }
            }
            document.rxDetailsViewForm.rxDosageByVal.value = Math.abs(qty_value);
            if (flag == "M" && (sliding_scale_yn != undefined && sliding_scale_yn == "Y")) {
                flag = "Y";
            } else {
                deleteScheduleLink();
                DisableSchedule1();
                storeSchedule();
            }           
        } else {
            if (document.rxDetailsViewForm.freq_nature.value != 'O' && callFrom == 'ChangeFreq') {
                document.rxDetailsViewForm.hdnpriorityValue.value = 'R';
                $("#rxPriority").data('kendoDropDownList').value("R");
                currPriority = document.rxDetailsViewForm.hdnpriorityValue.value;
                if (ordPriority != currPriority)
                    getBuildMARDefaulting();
            } else if (callFrom == 'ChangeFreq') {
                document.rxDetailsViewForm.hdnpriorityValue.value = 'U';
                $("#rxPriority").data('kendoDropDownList').value("U");
                currPriority = document.rxDetailsViewForm.hdnpriorityValue.value;
                if (ordPriority != currPriority)
                    getBuildMARDefaulting();
            }
            if (flag == "M") {
                flag = "Y";
            } else {
                deleteScheduleLink();
                DisableSchedule1();
                storeSchedule();
            }            
        }
        if (document.rxDetailsViewForm.tmp_durn_value != undefined) {            
            populateEndDate();
        }
        if (document.rxDetailsViewForm.freq_nature.value == "P" || document.rxDetailsViewForm.freq_nature.value == "O") {
            var durationDpList = $("#durationDpList").data("kendoDropDownList");
            $('#durationDpList').css("opacity", "0.3");
            durationDpList.enable(false);
        } else {
            var durationDpList = $("#durationDpList").data("kendoDropDownList");
            durationDpList.enable(true);
        }
    }
    flagbilling = "N";
}

function populateDurationDesc(obj) {
	var hdr_form = document.PharmBaseForm;
    var freq_code = obj.value;
    var patient_class = hdr_form.act_patient_class.value;  
    var drug_code = document.rxDetailsViewForm.drug_code.value;
    var fldString = " freq_code=\"" + freq_code + "\" ";
    fldString += " patient_class=\"" + patient_class + "\" ";
    fldString += " drug_code=\"" + drug_code + "\" ";
    var formobj = document.rxDetailsViewForm;
    var xmlStr = formXMLString(formobj, fldString);
    return fieldValidation(xmlStr, "populateDurationDesc");
}

function assignDurnDesc(repeat_value, repeat_durn_type, freq_nature, interval_value, durn_desc, freq_value, schedule_yn) 
{
    if (freq_value == "null" || freq_value == null)
        freq_value == "0";
    var split_dose_yn = document.rxDetailsViewForm.split_dose_yn.value;
    document.rxDetailsViewForm.freq_nature.value = freq_nature;
	
    var allow_chk = "Y";

    if (freq_nature == "O" || freq_nature == "P")
        allow_chk = "N";
    if (repeat_durn_type == "null" || repeat_durn_type == null || repeat_durn_type == "")
        repeat_durn_type = "D";

    if (allow_chk == "Y" && schedule_yn == "Y") {
        if (document.rxDetailsViewForm.taper_disable.value == "") {            
            document.rxDetailsViewForm.sch_over_yn.value = "Y";
        }
    } else {
        if (document.rxDetailsViewForm.sliding_scale_yn.value != 'Y') {            
            document.rxDetailsViewForm.split_dose_yn_val.value = 'N';
            document.rxDetailsViewForm.sch_over_yn.value = "Y";
        }
    }    
        if (document.rxDetailsViewForm.refill_yn != undefined && !(document.rxDetailsViewForm.refill_cont_order_yn.value == "Y" && document.rxDetailsViewForm.calling_mode.value != "taper" && document.rxDetailsViewForm.calling_mode.value != "tapered" && document.rxDetailsViewForm.refill_yn.value == "Y" && document.rxDetailsViewForm.refill_yn_from_param.value == "Y") && document.rxDetailsViewForm.no_refill != undefined)
		{                            
                document.rxDetailsViewForm.no_refill.value = '';
                document.rxDetailsViewForm.refill_start_date.value = '';
                document.rxDetailsViewForm.refill_end_date.value = '';
            
        }
    
    document.rxDetailsViewForm.freq_value.value = freq_value;
    document.rxDetailsViewForm.rxDurationDetails.disabled = false;
    var rxdttm = $("#rxEndDate").data("kendoDateTimePicker");
    rxdttm.enable(true);

    if (repeat_durn_type == "L") {
        $("#durationDpList").data("kendoDropDownList").value(repeat_durn_type);
        removeDurnDescList();
        populateDurnDesc(repeat_durn_type);
    }
    if (repeat_durn_type == "W") {
        $("#durationDpList").data("kendoDropDownList").value(repeat_durn_type);
        removeDurnDescList();
        populateDurnDesc(repeat_durn_type);
    }
    if (repeat_durn_type == "D") {
        $("#durationDpList").data("kendoDropDownList").value(repeat_durn_type);
        removeDurnDescList();
        populateDurnDesc(repeat_durn_type);
    }
    if (repeat_durn_type == "H") {
        $("#durationDpList").data("kendoDropDownList").value(repeat_durn_type);
        document.rxDetailsViewForm.calcualted_durn_value.value = "1";
        removeDurnDescList();
        populateDurnDesc(repeat_durn_type);
    }
    if (repeat_durn_type == "M") {
        $("#durationDpList").data("kendoDropDownList").value(repeat_durn_type);
        document.rxDetailsViewForm.calcualted_durn_value.value = "1";
        removeDurnDescList();
        populateDurnDesc(repeat_durn_type);
    }
    if (freq_nature == 'O') {
        if (document.rxDetailsViewForm.in_durn_desc != null) {
            document.rxDetailsViewForm.in_durn_desc.value = "";
            document.rxDetailsViewForm.in_durn_value.value = "";            
            document.rxDetailsViewForm.no_refill.value = "";
            document.rxDetailsViewForm.refill_start_date.value = "";
            document.rxDetailsViewForm.refill_end_date.value = "";
        }
        $("#durationDpList").data("kendoDropDownList").value("D");
        document.rxDetailsViewForm.rxDurationDetails.value = "1";
        validateDuration(document.rxDetailsViewForm.rxDurationDetails);
        document.rxDetailsViewForm.rxDurationDetails.disabled = true;
        var rxdttm = $("#rxEndDate").data("kendoDateTimePicker");
        rxdttm.enable(false);
        document.rxDetailsViewForm.calcualted_durn_value.value = "1";
        interval_value = "1";
        repeat_value = "1";
    } else if (freq_nature == 'P') {
        $("#durationDpList").data("kendoDropDownList").value("D");
        document.rxDetailsViewForm.rxDurationDetails.disabled = false;        
        var rxdttm = $("#rxEndDate").data("kendoDateTimePicker");
        rxdttm.enable(true);
        if (document.rxDetailsViewForm.no_refill != null) {
            document.rxDetailsViewForm.no_refill.value = "";
            document.rxDetailsViewForm.no_refill.disabled = true;
            document.rxDetailsViewForm.refill_start_date.value = "";
            document.rxDetailsViewForm.refill_end_date.value = "";
        }
        interval_value = "1";
        repeat_value = "1";
    }

    document.rxDetailsViewForm.interval_value.value = interval_value;
    document.rxDetailsViewForm.repeat_value.value = repeat_value;
    document.rxDetailsViewForm.repeat_durn_type.value = repeat_durn_type;
    document.rxDetailsViewForm.calcualted_durn_value.value = repeat_value;
    document.rxDetailsViewForm.scheduled_yn.value = schedule_yn;
    populateEndDate();
    if (freq_nature == "F" && interval_value > 1) {
        var durationDpList = $("#durationDpList").data("kendoDropDownList");
        $('#durationDpList').css("opacity", "0.3");
        durationDpList.enable(false);
    }
	showBillingDetails();
}

function removeDurnDescList() {
    var ddl = $("#durationDpList").data("kendoDropDownList");
    ddl.dataSource.data([]);
}

function populateDurnDesc(repeat_durn_type) {
    var formobj = document.rxDetailsViewForm;
    var fldString = " repeat_durn_type=\"" + repeat_durn_type + "\" ";
    var xmlStr = formXMLString(formobj, fldString);
    return fieldValidation(xmlStr, "populateDurnDesc");
}

function addDurnDescList(code, desc) {
    $("#durationDpList").getKendoDropDownList().dataSource.insert({
        value: code,
        text: desc
    });
}

function dfltDurnDesc(repeat_durn_type) {
    var freq_nature = document.rxDetailsViewForm.freq_nature.value;
    if (repeat_durn_type == "L") {
        $("#durationDpList").data("kendoDropDownList").value("L");
    }
    if (repeat_durn_type == "W") {
        $("#durationDpList").data("kendoDropDownList").value("W");
    }
    if (repeat_durn_type == "D") {
        $("#durationDpList").data("kendoDropDownList").value("D");
    }
    if (repeat_durn_type == "H") {
        $("#durationDpList").data("kendoDropDownList").value("H");
        document.rxDetailsViewForm.calcualted_durn_value.value = "1";
    }
    if (repeat_durn_type == "M") {
        $("#durationDpList").data("kendoDropDownList").value("M");
    }
    if (repeat_durn_type == "Y") {
        $("#durationDpList").data("kendoDropDownList").value("Y");
    }

    var interval_value = document.rxDetailsViewForm.interval_value.value;
    if ((freq_nature != "P" || freq_nature != 'O') && !(freq_nature == "F" && interval_value > 1) && document.rxDetailsViewForm.taper_disable == "") {
        var durationDpList = $("#durationDpList").data("kendoDropDownList");
        durationDpList.enable(true);
        //document.rxDetailsViewForm.rxDurationDetails.focus();
    }
    durationConversn(document.rxDetailsViewForm.durationDpList);
}

function checkForPRN(obj) {
	 var formobjPrnMandatory = document.rxDetailsViewForm.man_rem_on_prn_freq_yn.value;
    if (document.rxDetailsViewForm.freq_nature.value == "P") {
		   $("#prnRemarks").show();
        if (document.rxDetailsViewForm.prn_dose != null) {
            document.rxDetailsViewForm.absol_qty.disabled = false;
            var prn_dose = parseInt(document.rxDetailsViewForm.prn_dose.value);
            if (prn_dose > 0)
                document.rxDetailsViewForm.absol_qty.value = document.rxDetailsViewForm.prn_dose.value;

            document.rxDetailsViewForm.absol_qty.style.display = "inline";
        }
		if(formobjPrnMandatory != null && formobjPrnMandatory == "Y")
		{
			   $("#prnMandatory").show();
		}
		else{
			 $("#prnMandatory").hide();
		}
        ValidateAbs(document.rxDetailsViewForm.absol_qty);
    } else {
        if (document.rxDetailsViewForm.hdnDosageType.value != "A") {
			  $("#prnRemarks").hide();
            document.rxDetailsViewForm.absol_qty.style.display = "none";
        } else {
		 $("#prnMandatory").hide();
		 $("#prnRemarks").hide();
		}
    }
}

function ValidateAbs(obj, callFrom, tappered_over) {
    if (CheckPositiveNumber1(obj)) {
        if (obj.value == "" || parseFloat(obj.value) < 1) {
            if (callFrom != 'TAP_LVL_CHANGE') {
                if (callFrom == 'TOT_TAPER') {
                    showToastMsg("Total taper quantity cannot be blank or zero or negative");
                }
                obj.value = "1";
            } else {
                if (callFrom == 'TAP_LVL_CHANGE') {
                    if (tappered_over == 'N' && parseFloat(obj.value) < 1) {
                        showToastMsg("Total level quantity cannot be blank or zero or negative");
                        obj.value = "1";
                    } else
                    if (parseFloat(obj.value) < 1)
                        obj.value = "0";
                    else
                        obj.value = "1";
                } else {
                    obj.value = "0";
                }
            }
        } else
            obj.value = Math.abs(obj.value);
        return;
    } else {
        obj.value = "";
        return false;
    }
}

function DisableSchedule1() {

    var drug_code = document.rxDetailsViewForm.drug_code.value;
    var srl_no = document.rxDetailsViewForm.srl_no.value;
    var calling_mode = document.rxDetailsViewForm.calling_mode.value;
    if (calling_mode == "taper")
        code = drug_code + (parseInt(srl_no));
    else
        code = drug_code + srl_no;
    var fldString = " drug_code=\"" + code + "\" ";
    var formobj = document.rxDetailsViewForm;
    var xmlStr = formXMLString(formobj, fldString);
    fieldValidation(xmlStr, "disableScheduleLink1");
}

function deleteScheduleLink() {
    document.rxDetailsViewForm.frequencyDpList.disabled = false;
    document.rxDetailsViewForm.sch_over_yn.value = "Y";
    document.rxDetailsViewForm.admin_time.value = "";
    document.rxDetailsViewForm.admin_qty.value = "";
    var dosage_type = document.rxDetailsViewForm.dosage_type.value;
    validateQtyDesc(dosage_type, "R");
}

function lookForChange(obj) {
    if (obj != undefined) {
        var init_val = document.rxDetailsViewForm.init_qty.value;
        var curr_val = obj.value;

        if (obj.value != "" && parseFloat(curr_val) != parseFloat(init_val)) {
            document.rxDetailsViewForm.rxDosageByVal.value = Math.abs(curr_val);
            document.rxDetailsViewForm.init_qty.value = curr_val;
            if (document.rxDetailsViewForm.freq_nature.value == "P") {
                deleteScheduleLink();
                DisableSchedule();
            } else {
                deleteScheduleLink();
                DisableSchedule();
                storeSchedule();
                if (!validateDosageLimit("lookForChange")) {
                    return false;
                }
                CheckPositiveNumber1(obj);
                //checkSchedule(obj); 
            }
        }
    }
}

function deleteScheduleLink() {
    var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value();
    validateQtyDesc(dosage_type, "R");
}

function validateQtyDesc(mode, status) {
    document.rxDetailsViewForm.hdnDosageType.value = mode;

    if (mode == "S") {
        if (status != "R") {
            var strength = parseFloat(document.rxDetailsViewForm.hdnStrengthVal.value == null ? "1" : document.rxDetailsViewForm.hdnStrengthVal.value);
            var catalog_qty = parseFloat(document.rxDetailsViewForm.tab_qty_value.value == null ? "1" : document.rxDetailsViewForm.tab_qty_value.value);
            var strength_per_value_pres_uom = parseFloat(document.rxDetailsViewForm.strength_per_value_pres_uom.value == null ? "1" : document.rxDetailsViewForm.strength_per_value_pres_uom.value);
            document.rxDetailsViewForm.dosageUOMDpList.value = document.rxDetailsViewForm.strength_uom.value;

            if (strength_per_value_pres_uom == 0)
                strength_per_value_pres_uom = 1;

            document.rxDetailsViewForm.rxDosageByVal.value = Math.round(((strength * catalog_qty) / strength_per_value_pres_uom) * 100) / 100;
        }
    } else if (mode == "Q") {

        if (status != "R") {
            document.rxDetailsViewForm.rxDosageByVal.value = parseFloat(document.rxDetailsViewForm.tab_qty_value.value);
            document.rxDetailsViewForm.dosageUOMDpList.value = document.rxDetailsViewForm.dflt_qty_uom.value;
        }
    } 
    if (document.rxDetailsViewForm.dosageUOMDpList.value == '') {
        if (document.rxDetailsViewForm.dosageUOMDpList.options.length > 0) {
            document.rxDetailsViewForm.dosageUOMDpList.selectedIndex = 0;
        }
    }
}

function DisableSchedule() {

    var drug_code = document.rxDetailsViewForm.drug_code.value;
    var srl_no = document.rxDetailsViewForm.srl_no.value;
    var calling_mode = document.rxDetailsViewForm.calling_mode.value;

    if (calling_mode == "taper")
        code = drug_code + (parseInt(srl_no) + 1);
    else
        code = drug_code + srl_no;

    var fldString = " drug_code=\"" + code + "\" ";
    var formobj = document.rxDetailsViewForm;
    var xmlStr = formXMLString(formobj, fldString);
    fieldValidation(xmlStr, "disableScheduleLink");
}

function storeSchedule() {
    var drug_code = document.rxDetailsViewForm.drug_code.value;
    var start_date = document.rxDetailsViewForm.start_date.value;
    var split_dose_yn = document.rxDetailsViewForm.split_dose_yn_val.value;
    var qty_value = document.rxDetailsViewForm.rxDosageByVal.value;
    var dose_uom = document.rxDetailsViewForm.dosageUOMDpList.value;
    document.rxDetailsViewForm.init_qty.value = qty_value;

    var qty_uom = document.rxDetailsViewForm.dosageUOMDpList.value;
    if (document.rxDetailsViewForm.sliding_scale_yn != undefined)
        sliding_scale_yn = document.rxDetailsViewForm.sliding_scale_yn.value;
    if (sliding_scale_yn == "Y")
        qty_value = document.rxDetailsViewForm.absol_qty.value;
    var freq_code = "";
    if (document.rxDetailsViewForm.frequencyDpList.options.length != 0)
        freq_code = document.rxDetailsViewForm.frequencyDpList.options[document.rxDetailsViewForm.frequencyDpList.selectedIndex].value;
    var freq_nature = document.rxDetailsViewForm.freq_nature.value;
    var freq_desc = "";
    if (drug_code != "" && document.rxDetailsViewForm.frequencyDpList.options.length != 0)
        freq_desc = encodeURIComponent(document.rxDetailsViewForm.frequencyDpList.options[document.rxDetailsViewForm.frequencyDpList.selectedIndex].text, "UTF-8");

    var srl_no = document.rxDetailsViewForm.srl_no.value;
    var rowVal = document.rxDetailsViewForm.rowVal.value;
    var calling_mode = document.rxDetailsViewForm.calling_mode.value;
    var scheduled_yn = document.rxDetailsViewForm.scheduled_yn.value;
    var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value(); //added for IN24132 --07/10/2010-- priya   

    if (freq_code == "") {
        //document.rxDetailsViewForm.frequency.focus();
        return;
    }
    var fldString = " start_date=\"" + start_date + "\" ";
    fldString += " split_dose_yn=\"" + split_dose_yn + "\" ";
    fldString += " qty_value=\"" + qty_value + "\" ";
    fldString += " freq_code=\"" + freq_code + "\" ";
    fldString += "freq_nature=\"" + freq_nature + "\" ";
    fldString += "freq_desc=\"" + freq_desc + "\" ";
    fldString += " drug_code=\"" + drug_code + "\" ";
    fldString += " srl_no=\"" + srl_no + "\" ";
    fldString += " rowVal=\"" + rowVal + "\" ";
    fldString += " scheduled_yn=\"" + scheduled_yn + "\" ";
    fldString += " qty_uom=\"" + qty_uom + "\" ";
    fldString += " dosage_type=\"" + dosage_type + "\" ";
    fldString += " dose_uom=\"" + dose_uom + "\" ";
    var formobj = document.rxDetailsViewForm;
    var xmlStr = formXMLString(formobj, fldString);
    fieldValidation(xmlStr, "storeSchedule");
    code = drug_code + srl_no;
    var fldString = " drug_code=\"" + code + "\" ";
    fldString += " drug_codeOnly=\"" + drug_code + "\" ";
    fldString += " srl_no=\"" + srl_no + "\" ";
    fldString += " sliding_scale_yn=\"" + sliding_scale_yn + "\" ";
    var xmlStr = formXMLString(formobj, fldString);
    fieldValidation(xmlStr, "makeScheduleLink");
}

function makeScheduleLink(admin_time, admin_qty, total_qty, freq_size, split_chk, calling_mode) {
    var fract_dose_appl_yn = document.rxDetailsViewForm.fract_dose_appl_yn.value;
    if (fract_dose_appl_yn != 'Y')
        total_qty = parseInt(total_qty);

    var legend = "";

    if (split_chk == "true") {
        if (document.rxDetailsViewForm.split_dose_yn_val != null)
            document.rxDetailsViewForm.split_dose_yn_val.value = "Y";
    } else {
        if (document.rxDetailsViewForm.split_dose_yn_val != null)
            document.rxDetailsViewForm.split_dose_yn_val.value = "N";
    }

    if (document.rxDetailsViewForm.sliding_scale_yn.value == 'Y') {
        admin_qty = "";
    }

    if (admin_qty != "" && parseFloat(admin_qty) < 1)
        admin_qty = parseFloat(admin_qty);

    document.rxDetailsViewForm.admin_time.value = admin_time;
    document.rxDetailsViewForm.admin_qty.value = admin_qty;
    var dsg_reason = document.rxDetailsViewForm.dsg_reason.value;
    var dup_reason = document.rxDetailsViewForm.dup_reason.value;
    var con_reason = document.rxDetailsViewForm.con_reason.value;
    var int_reason = document.rxDetailsViewForm.int_reason.value;
    var alg_reason = document.rxDetailsViewForm.alg_reason.value;
    if (calling_mode != 'onLoad' || (calling_mode != 'onLoad' && dsg_reason == "" && dup_reason == "" && con_reason == "" && int_reason == "" && alg_reason == "")) {
        if (!validateDosageLimit(calling_mode)) {
            return false;
        }
    } 
}

function hideScheduleLink() {
    document.rxDetailsViewForm.frequencyDpList.disabled = false;
    if (document.rxDetailsViewForm.qty_reqd_yn.value == 'Y') {
        document.rxDetailsViewForm.rxDosageByVal.disabled = false;
    }
    if ($("#rxDosageBy").data("kendoDropDownList").value() == "Q") {

        var rx_qty_by_pres_base_uom_yn = document.rxDetailsViewForm.rx_qty_by_pres_base_uom_yn.value;
        if (rx_qty_by_pres_base_uom_yn == "Y")
            document.rxDetailsViewForm.dosageUOMDpList.disabled = true;
        else
            document.rxDetailsViewForm.dosageUOMDpList.disabled = false;
    } else if ($("#rxDosageBy").data("kendoDropDownList").value() == "A") {
        if ($("#dosageUOMDpList").data("kendoDropDownList").value() == "")
            document.rxDetailsViewForm.dosageUOMDpList.value = document.rxDetailsViewForm.pres_base_uom.value;

        var rx_qty_by_pres_base_uom_yn = document.rxDetailsViewForm.rx_qty_by_pres_base_uom_yn.value;
        if (rx_qty_by_pres_base_uom_yn == "Y")
            document.rxDetailsViewForm.dosageUOMDpList.disabled = true;
        else
            document.rxDetailsViewForm.dosageUOMDpList.disabled = false;
    } else
        document.rxDetailsViewForm.dosageUOMDpList.disabled = false;
    if (!validateDosageLimit("hideSchedLink")) {
        return false;
    }
}

function trimCheck(inString) {
    if ((inString != 'undefined') && (inString != undefined)) {
        var startPos;
        var ch;
        startPos = 0;
        strlength = inString.length;
        for (var i = 0; i <= strlength; i++) {
            ch = inString.charAt(startPos);
            if ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
                startPos++;
            }
        }
        if (startPos == inString.length) return false;
        else return true;
    }
}

var messageArray = new Array();

function CheckPositiveNumber1(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {} else {
        if (obj.value.length > 0) {
            showToastMsg("Number must be greater than zero");
            obj.select();
            //obj.focus();
            return false
        } else if (obj.value.length == 0)
            obj.value = 0;
    }
    return true;
}

function durationConversn(obj) {
    var durn_value = document.rxDetailsViewForm.rxDurationDetails.value;
    var freq_nature = document.rxDetailsViewForm.freq_nature.value;
    var repeat_durn_type = "";
    var tmp_durn_value = "1";
    if (freq_nature != "P" && freq_nature != 'O') {
        repeat_durn_type = document.rxDetailsViewForm.repeat_durn_type.value;
        if (repeat_durn_type == obj.value) {
            tmp_durn_value = durn_value;
        }
        if (repeat_durn_type == 'M') {
            if (obj.value == 'H') {
                tmp_durn_value = (durn_value * 60);
            } else if (obj.value == 'D') {
                tmp_durn_value = (durn_value * 24 * 60);
            } else if (obj.value == 'W') {
                tmp_durn_value = (durn_value * 7 * 24 * 60);
            } else if (obj.value == 'L') {
                tmp_durn_value = (durn_value * 30 * 24 * 60);
            } else if (obj.value == 'Y') {
                tmp_durn_value = (durn_value * 365 * 24 * 60);
            }
        } else if (repeat_durn_type == 'H') {
            if (obj.value == 'D') {
                tmp_durn_value = (durn_value * 24);
            } else if (obj.value == 'W') {
                tmp_durn_value = (durn_value * 7 * 24);
            } else if (obj.value == 'L') {
                tmp_durn_value = (durn_value * 30 * 24);
            } else if (obj.value == 'Y') {
                tmp_durn_value = (durn_value * 365 * 24);
            }
        } else if (repeat_durn_type == 'D') {
            if (obj.value == 'W') {
                tmp_durn_value = (durn_value * 7);
            } else if (obj.value == 'L') {
                tmp_durn_value = (durn_value * 30);
            } else if (obj.value == 'Y') {
                tmp_durn_value = (durn_value * 365);
            }
        } else if (repeat_durn_type == 'W') {
            if (obj.value == 'L') {
                tmp_durn_value = (durn_value * 4);
            } else if (obj.value == 'Y') {
                tmp_durn_value = (durn_value * 52);
            }
        } else if (repeat_durn_type == 'L') {
            if (obj.value == 'Y') {
                tmp_durn_value = (durn_value * 12);
            }
        }
    } else {
        if (freq_nature == 'O')
            tmp_durn_value = 1;
    }
	document.rxDetailsViewForm.tmp_durn_value.value = tmp_durn_value;
	document.rxDetailsViewForm.tmp_durn_desc.value = document.rxDetailsViewForm.repeat_durn_type.value;
	showBillingDetails();
}

function validateDosageLimit(calling_mode) {

    var ext_prod_id = document.rxDetailsViewForm.ext_prod_id.value;
    var in_formulary_yn = document.rxDetailsViewForm.in_formulary_yn.value;
    var qty_value = document.rxDetailsViewForm.rxDosageByVal.value;

    var patient_id = document.rxDetailsViewForm.patient_id.value;
    var bl_install_yn = document.rxDetailsViewForm.bl_install_yn.value;
    var bl_disp_charge_dtl_in_rx_yn = document.rxDetailsViewForm.bl_disp_charge_dtl_in_rx_yn.value;
    var drug_db_dosecheck_yn = document.rxDetailsViewForm.drug_db_dosecheck_yn.value;

    if (drug_db_dosecheck_yn == 'Y' && (ext_prod_id != '')) {
        //extDosageCheck(calling_mode);
    } else {

        var drug_code = document.rxDetailsViewForm.drug_code.value;
        var dosage_type = $("#rxDosageBy").data("kendoDropDownList").value();
        var srl_no = document.rxDetailsViewForm.srl_no.value;
        var start_date = document.rxDetailsViewForm.start_date.value;
        var generic_id = document.rxDetailsViewForm.generic_id.value;
        var freq_code = document.rxDetailsViewForm.freq_code.value;
        var freq_nature = document.rxDetailsViewForm.freq_nature.value;
        var calc_def_dosage_yn = document.rxDetailsViewForm.calc_def_dosage_yn.value;
        document.rxDetailsViewForm.rxDosageByVal.value = Math.abs(qty_value);

        var repeat_value = "";
        if (oldrepeatvalue == undefined)
            repeat_value = document.rxDetailsViewForm.repeat_value.value;
        else
            repeat_value = oldrepeatvalue;

        if (calling_mode == "taper") {
            srl_no = parseInt(srl_no) + 1;
        }
        var fldString = " patient_id=\"" + patient_id + "\" ";
        fldString += " qty_value=\"" + qty_value + "\" ";
        fldString += " dosage_type=\"" + dosage_type + "\" ";
        fldString += " repeat_value=\"" + repeat_value + "\" ";
        fldString += " drug_code=\"" + drug_code + "\" ";
        fldString += " srl_no=\"" + srl_no + "\" ";
        fldString += " start_date=\"" + start_date + "\" ";
        fldString += " generic_id=\"" + generic_id + "\" ";
        fldString += " freq_code=\"" + freq_code + "\" ";
        fldString += " freq_nature=\"" + freq_nature + "\" ";
        fldString += " calc_def_dosage_yn=\"" + calc_def_dosage_yn + "\" ";
        var formobj = document.rxDetailsViewForm;
        var xmlStr = formXMLString(formobj, fldString);
        fieldValidation(xmlStr, "validateDosageLimit");
    }    
    return;
}


function enableDosageLimit(limit_ind, daily_dose, unit_dose, mono_graph, min_daily_dose, min_unit_dose, dose_unit, srl_no) {

	document.rxDetailsViewForm.limit_ind.value = limit_ind;
	$("#span_beyondDoseLimit").attr("style", "display:inline-block");
	$("#exceedOverrideRsn").attr("style", "display:inline-block;");	
	if(pharmRxDetailsScroller)
		pharmRxDetailsScroller.refresh();
}

function disableDosageLimit(limit_ind, srl_no, drug_code) {
    try {
        if (document.rxDetailsViewForm.current_rx == null) {
            frmObj = document.rxDetailsViewForm;
            var current_rx = frmObj.current_rx.value;
            var allergy_yn = frmObj.allergy_yn.value;
            var interaction_exists = frmObj.interaction_exists.value;
            frmObj.limit_ind.value = "Y";
            if (current_rx == "N" && allergy_yn == "N" && interaction_exists != "Y") {
                frmObj.daily_dose.value = "";
                frmObj.unit_dose.value = "";
                frmObj.mono_graph.value = "";
            }
        } else {
            var current_rx = document.rxDetailsViewForm.current_rx.value;
            var allergy_yn = document.rxDetailsViewForm.allergy_yn.value;
            var interaction_exists = document.rxDetailsViewForm.interaction_exists.value;
            document.rxDetailsViewForm.limit_ind.value = "Y";
            if (current_rx == "N" && allergy_yn == "N" && interaction_exists != "Y") {
                document.rxDetailsViewForm.daily_dose.value = "";
                document.rxDetailsViewForm.unit_dose.value = "";
                document.rxDetailsViewForm.mono_graph.value = "";
            }
        }
	$("#span_beyondDoseLimit").attr("style", "display:none");	
	$("#exceedOverrideRsn").attr("style", "display:none;");	
	}
	catch(e){
	}
	if(pharmRxDetailsScroller)
		pharmRxDetailsScroller.refresh();
}

function populateEndDate(callFrom) {
    if (callFrom == undefined)
        callFrom = "";
    var frmObj_pres_dtl;

    if (document.rxDetailsViewForm != undefined) {
        frmObj_pres_dtl = document.rxDetailsViewForm;
    }

    var freq_nature = frmObj_pres_dtl.freq_nature.value;
    var start_date = frmObj_pres_dtl.rxStartDate.value;
    var durn_value = frmObj_pres_dtl.rxDurationDetails.value;
    var durn_desc = $("#durationDpList").data("kendoDropDownList").value();
    var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
    var drug_code = frmObj_pres_dtl.drug_code.value;
    var srlNo = frmObj_pres_dtl.srl_no.value;
    var def_freq_found = frmObj_pres_dtl.def_freq_found.value;
    var absol_qty = "";
    if (frmObj_pres_dtl.absol_qty != undefined) {
        absol_qty = frmObj_pres_dtl.absol_qty.value;
    }

    repeat_durn_type = durn_desc;
    if (durn_value != '') {
        var fldString = "  start_date=\"" + start_date + "\" ";
        fldString += " durn_value=\"" + durn_value + "\" ";
        fldString += " repeat_durn_type=\"" + repeat_durn_type + "\" ";
        fldString += " freq_nature=\"" + freq_nature + "\" ";
        fldString += " drug_code=\"" + drug_code + "\" ";
        fldString += " srlNo=\"" + srlNo + "\" ";
        fldString += " def_freq_found=\"" + def_freq_found + "\" ";
        fldString += " absol_qty=\"" + absol_qty + "\" ";
        fldString += " callFrom=\"" + callFrom + "\" ";
        var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
        return fieldValidation(xmlStr, "populateEndDate");
    }
}

function populateStartDate(obj, sliding_scale_yn) {
    var source = obj.name;
    var frmObj_pres_dtl = "";
    if (document.rxDetailsViewForm != undefined)
        frmObj_pres_dtl = document.rxDetailsViewForm;

    var sys_date = frmObj_pres_dtl.sys_date.value;
    if (frmObj_pres_dtl.rxStartDate.value == '') {
        frmObj_pres_dtl.rxStartDate.value = sys_date;
    }
    var start_date = frmObj_pres_dtl.rxStartDate.value;
    var fldString = " start_date=\"" + start_date + "\" ";
    fldString += " source=\"" + source + "\" ";
    fldString += " sliding_scale_yn=\"" + sliding_scale_yn + "\" ";

    var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
    return fieldValidation(xmlStr, "populateStartDate");
}

function assignStartDate(source, start_date, future_date, back_date, sliding_scale_yn) {
    var frmObj_pres_dtl = "";
    if (document.rxDetailsViewForm != undefined)
        frmObj_pres_dtl = document.rxDetailsViewForm;

    frmObj_pres_dtl.rxStartDate.value = start_date;

    if (source == "qty_value") {
        frmObj_pres_dtl.rxEndDate.value = start_date;
        populateEndDate();
    } else if (source == "rxDurationDetails") {
        populateEndDate();
    }
}

function validDate(date, format, locale) {
    var dateFlag = true;
    var dateArr;
    var dateArr1;
    if (format == "DMY") {
        dateArr = date.split("/");
        if (dateArr[2] == 0) {
            dateFlag = false;
        }
    } else if (format == "DMYHM") {
        dateArr1 = date.split(" ");
        dateArr = (dateArr1[0]).split("/");
        if (dateArr[2] == 0) {
            dateFlag = false;
        }
    } else if (format == "YY") {
        if (date == 0) {
            dateFlag = false;
        }
    } else if (format == "MY") {
        dateArr = date.split("/");
        if (dateArr[1] == 0) {
            dateFlag = false;
        }
    }
    if (dateFlag) {
        var xhr = getXHR();
        var url = "eIPAD/jsp/chartwidgets/pharmacy/RxDateUtils.jsp?methodName=validDate&format=" + format + "&locale=" + locale + "&date=" + date;

        xhr.open("POST", url, false);
        xhr.setRequestHeader("Content-Type", "text/plain")
        xhr.send("");
        var xmlText = xhr.responseText;
        if (TrimStr(xmlText) == "true") {
            dateFlag = true;
        } else {
            dateFlag = false;
        }
    }
    return dateFlag;
}

function TrimStr(sInString) {
    sInString = sInString.replace(/^\s+/g, ""); // strip leading
    return sInString.replace(/\s+$/g, ""); // strip trailing
}

function getXHR() {
    var request = false;
    try {
        request = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = false;
            }
        }
    }
    if (!request) {
        alert("System Error initializing XMLHttpRequest!");
        return;
    } else return request;
}

function isBefore(fromDate, toDate, format, locale) {
    var xhr = getXHR();
    var url = "eIPAD/jsp/chartwidgets/pharmacy/RxDateUtils.jsp?methodName=isBefore&fromDate=" + fromDate + "&toDate=" + toDate + "&format=" + format + "&locale=" + locale;
    xhr.open("POST", url, false);
    xhr.setRequestHeader("Content-Type", "text/plain")
    xhr.send("");

    var xmlText = xhr.responseText;
    if (TrimStr(xmlText) == "true") {
        return true;
    }
    return false;
}

function isAfter(fromDate, toDate, format, locale) {
    var xhr = getXHR();
    var url = "eIPAD/jsp/chartwidgets/pharmacy/RxDateUtils.jsp?methodName=isAfter&fromDate=" + fromDate + "&toDate=" + toDate + "&format=" + format + "&locale=" + locale;
    xhr.open("POST", url, false);
    xhr.setRequestHeader("Content-Type", "text/plain")
    xhr.send("");

    var xmlText = xhr.responseText;
    if (TrimStr(xmlText) == "true") {
        return true;
    }
    return false;
}

function chkBackFutureDate(obj, locale) {

    locale = document.rxDetailsViewForm.language_id.value;
    if (obj.value != "") {
        var back_date = document.rxDetailsViewForm.back_date.value;
        var future_date = document.rxDetailsViewForm.future_date.value;
        var pregnency_yn = document.rxDetailsViewForm.pregnency_yn.value;

        if (validDate(obj.value, "DMYHM", locale)) {
            if (future_date != null && future_date != 'null' && future_date != "0") {
                if (isBefore(obj.value, future_date, "DMYHM", locale)) {
                    populateEndDate('DATECHANGE');
                } else {
                    showToastMsg("Current start date does not satisfy the parameter range");
                    document.rxDetailsViewForm.rxStartDate.value = document.rxDetailsViewForm.start_date.value;
                    //obj.focus();
                    return false;
                }
            } else {
                populateEndDate('DATECHANGE');
            }
            if (back_date != null && back_date != 'null' && back_date != "0") {
                if (isAfter(obj.value, back_date, "DMYHM", locale)) {
                    populateEndDate('DATECHANGE');
                } else {
                    showToastMsg("Current start date does not satisfy the parameter range");
                    document.rxDetailsViewForm.rxStartDate.value = document.rxDetailsViewForm.start_date.value;
                    //obj.focus();
                    return false;
                }
            } else {
                populateEndDate('DATECHANGE');
            }
        } else {
            showToastMsg("Invalid date time format");
            document.rxDetailsViewForm.rxStartDate.value = document.rxDetailsViewForm.start_date.value;
            //obj.focus();
            return false;
        }
    } else {
        showToastMsg("Start date cannot be blank");
        document.rxDetailsViewForm.rxStartDate.value = document.rxDetailsViewForm.start_date.value;
        return false;
    }
    if (pregnency_yn == "Y") {
        settrimester(obj.value);
    }
}


function validateEndDate(dateObj, locale) {
    if (dateObj.value != "") {
        if (validDate(dateObj.value, "DMYHM", locale)) {
            var start_date = document.rxDetailsViewForm.start_date.value;
            frmObj = document.rxDetailsViewForm;
            var start_date = frmObj.rxStartDate.value;
            if (isBefore(start_date, dateObj.value, "DMYHM", locale)) {

                if ($("#durationDpList").data("kendoDropDownList").value() == 'H')
                    var durn = hoursBetween(start_date, dateObj.value, "DMYHM", locale);
                else if ($("#durationDpList").data("kendoDropDownList").value() == 'M')
                    var durn = minutesBetween(start_date, dateObj.value, "DMYHM", locale);
                else if ($("#durationDpList").data("kendoDropDownList").value() == 'W')
                    var durn = daysBetween(start_date, dateObj.value, "DMYHM", locale) / 7;
                else if ($("#durationDpList").data("kendoDropDownList").value() == 'L')
                    var durn = daysBetween(start_date, dateObj.value, "DMYHM", locale) / 30;
                else if ($("#durationDpList").data("kendoDropDownList").value() == 'Y')
                    var durn = daysBetween(start_date, dateObj.value, "DMYHM", locale) / 365;
                else
                    var durn = daysBetween(start_date, dateObj.value, "DMYHM", locale);
                if (parseInt(durn) > 999) {
                    showToastMsg("Duration cannot be greater than 999");
                    return;
                }

                if (durn > 0) {
                    frmObj.rxDurationDetails.value = durn;
					validateDuration(frmObj.rxDurationDetails);
                    var durn_desc = frmObj.durationDpList;
                    durationConversn(durn_desc);
                    populateEndDate();
                } else {
                    showToastMsg("Start date cannot be greater than end date");
                    populateEndDate();
                }
            } else {
                showToastMsg("Invalid date time format");
                populateEndDate('DATECHANGE');
            }
        } else {
            showToastMsg("Invalid date time format");
            populateEndDate('DATECHANGE');
            return false;
        }
    } else {
        showToastMsg("End date cannot be empty");        
        populateEndDate('DATECHANGE');
        return false;
    }
}

function daysBetween(fromDate, toDate, format, locale) {
    var xhr = getXHR();
    var url = "eIPAD/jsp/chartwidgets/pharmacy/RxDateUtils.jsp?methodName=daysBetween&fromDate=" + fromDate + "&toDate=" + toDate + "&format=" + format + "&locale=" + locale;
    xhr.open("POST", url, false);
    xhr.setRequestHeader("Content-Type", "text/plain");
    xhr.send("");

    var xmlText = trimString(xhr.responseText);
    return (xmlText);
}

function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }
    // get the string
    outString = inString.substring(startPos, endPos + 1);
    if (startPos > endPos) {
        return '';
    } else
        return outString;
}

function assignEndDate(end_date, callFrom) {
    var frmObj_pres_dtl = "";
    if (callFrom == undefined || callFrom == '')
        callFrom = "CHANGEDATE";

    if (document.rxDetailsViewForm != undefined) {
        frmObj_pres_dtl = document.rxDetailsViewForm;
    }

    var tempEnd_date = frmObj_pres_dtl.rxEndDate.value;
    if (callFrom != "ENDDATECHANGE")
        frmObj_pres_dtl.rxEndDate.value = end_date;
    else
        callFrom = "DATECHANGE";

    var tempEnd_date = frmObj_pres_dtl.rxEndDate.value;
    frmObj_pres_dtl.rxEndDate.value = end_date;
    if (tempEnd_date != end_date) {
        checkDuplicateDrug(frmObj_pres_dtl, "", callFrom);
    }    
}

function checkDuplicateDrug(frmObj_pres_dtl, freq_code, calledFrom) {
    var formHdrObj;
    if (freq_code == undefined)
        freq_code = "";

    var start_date = frmObj_pres_dtl.rxStartDate.value;
    var end_date = frmObj_pres_dtl.rxEndDate.value;
    var durn_value = frmObj_pres_dtl.rxDurationDetails.value;
    var drug_code = frmObj_pres_dtl.drug_code.value;
    var srlNo = frmObj_pres_dtl.srl_no.value;
    var allow_duplicate = frmObj_pres_dtl.allow_duplicate.value;
    var patient_id = frmObj_pres_dtl.patient_id.value;
    var drug_db_interface_yn = frmObj_pres_dtl.drug_db_interface_yn.value;
    var drug_db_duptherapy_yn = frmObj_pres_dtl.drug_db_duptherapy_yn.value;

    if (durn_value != '') {
        var fldString = "  start_date=\"" + start_date + "\" ";
        fldString += " end_date=\"" + end_date + "\" ";
        fldString += " durn_value=\"" + durn_value + "\" ";
        fldString += " drug_code=\"" + drug_code + "\" ";
        fldString += " srlNo=\"" + srlNo + "\" ";
        fldString += " patient_id=\"" + patient_id + "\" ";
        fldString += " drug_db_interface_yn=\"" + drug_db_interface_yn + "\" ";
        fldString += " drug_db_duptherapy_yn=\"" + drug_db_duptherapy_yn + "\" ";
        fldString += " allow_duplicate=\"" + allow_duplicate + "\" ";
        fldString += " freq_code=\"" + freq_code + "\" ";
        fldString += " calledFrom=\"" + calledFrom + "\" ";

        var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
        return fieldValidation(xmlStr, "checkDuplicateDrug");
    }
}

function showDuplicateInd(srlNo, currentrx, slidingScale_yn, drug_code, callFrom, allow_duplicate){ 
	var formObj;
		formObj = document.rxDetailsViewForm;	
	if(currentrx == 'Y' || currentrx == 'R'){
		if(formObj!=undefined){
			formObj.current_rx.value='Y';
			if(allow_duplicate!='Y'){ 
				$("#rxPriority").data('kendoDropDownList').value("U");
				if(callFrom == 'DATECHANGE' && (formObj.dup_found.value=='false' || formObj.dup_found.value==false)){
					formObj.dup_found.value=true; 
					$('#rxPriority').prop('disabled', true);
					defFreq(formObj.rxPriority, "DATECHANGE", 'Y');
				}
			}
			else{
				$("#span_duplicateDrug").attr("style", "display:inline-block");
				$("#drugOverrideRsn").attr("style", "display:inline-block;");
				if(slidingScale_yn==undefined || slidingScale_yn=='N'){
					if(callFrom == 'DATECHANGE' && (formObj.dup_found.value=='true' || formObj.dup_found.value==true)){
						$('#rxPriority').prop('disabled', true);
					}
				}				
			}
		}
	}
	else{
		$("#span_duplicateDrug").attr("style", "display:none");
		$("#drugOverrideRsn").attr("style", "display:none;");		
	}
	if(pharmRxDetailsScroller)
		pharmRxDetailsScroller.refresh();
}

function assignDurnvalue(total_durn_value, max_durn_value, chk_for_max_durn_action, prompt_msg, max_durn_type, sliding_scale_yn) {
    var frmObj_pres_dtl = "";
	var hdr_form = document.PharmBaseForm;
    var dtl_all = "";
    var drg_max_durn_value = "";
    var max_durn_desc = "";
    if (max_durn_type == "")
        max_durn_type = "D";

    if (document.rxDetailsViewForm != undefined) {
        frmObj_pres_dtl = document.rxDetailsViewForm;
    }


    var durn_value = parseInt(Math.abs(frmObj_pres_dtl.rxDurationDetails.value));
    frmObj_pres_dtl.rxDurationDetails.value = durn_value;
    var durn_desc = $("#durationDpList").data("kendoDropDownList").value();
    var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
    var temp1 = "";
    if (parseInt(Math.abs(max_durn_value)) == 0 || max_durn_value == '') {
        var pat_class = hdr_form.act_patient_class.value;
        if (pat_class == "OP") {
            max_durn_value = frmObj_pres_dtl.max_durn_for_dm_pres.value;
            chk_for_max_durn_action = frmObj_pres_dtl.chk_for_dm_max_durn_action.value;
            frmObj_pres_dtl.max_durn_value.value = max_durn_value;
            frmObj_pres_dtl.chk_for_max_durn_action.value = chk_for_max_durn_action;
        } else if (pat_class == 'IP') {
            max_durn_value = frmObj_pres_dtl.max_durn_for_ip_pres.value;
            chk_for_max_durn_action = frmObj_pres_dtl.chk_for_ip_max_durn_action.value;
        } else {
            max_durn_value = frmObj_pres_dtl.max_durn_for_op_pres.value;
            chk_for_max_durn_action = frmObj_pres_dtl.chk_for_op_max_durn_action.value;
        }
        frmObj_pres_dtl.max_durn_value.value = max_durn_value;
        frmObj_pres_dtl.chk_for_max_durn_action.value = chk_for_max_durn_action;
    }
    if (repeat_durn_type != durn_desc) {
        if (repeat_durn_type == 'M') {
            if (durn_desc == 'H') {
                durn_value = parseInt(durn_value) * 60;
            } else if (durn_desc == 'D') {
                durn_value = parseInt(durn_value) * (24 * 60);
            } else if (durn_desc == 'W') {
                durn_value = parseInt(durn_value) * (7 * 24 * 60);
            } else if (durn_desc == 'L') {
                durn_value = parseInt(durn_value) * (30 * 24 * 60);
            } else if (durn_desc == 'Y') {
                durn_value = parseInt(durn_value) * (365 * 24 * 60);
            }
        } else if (repeat_durn_type == 'H') {
            if (durn_desc == 'M') {
                durn_value = Math.ceil(parseInt(durn_value) / 60);
            } else if (durn_desc == 'D') {
                durn_value = parseInt(durn_value) * 24;
            } else if (durn_desc == 'W') {
                durn_value = parseInt(durn_value) * 7 * 24;
            } else if (durn_desc == 'L') {
                durn_value = parseInt(durn_value) * 30 * 24;
            } else if (durn_desc == 'Y') {
                durn_value = parseInt(durn_value) * 365 * 24;
            }
        } else if (repeat_durn_type == 'D') {
            if (durn_desc == 'M') {
                durn_value = Math.ceil(parseInt(durn_value) / (24 * 60));
            } else if (durn_desc == 'H') {
                durn_value = Math.ceil(parseInt(durn_value) / 24);
            } else if (durn_desc == 'W') {
                durn_value = parseInt(durn_value) * 7;
            } else if (durn_desc == 'L') {
                durn_value = parseInt(durn_value) * 30;
            } else if (durn_desc == 'Y') {
                durn_value = parseInt(durn_value) * 365;
            }
        } else if (repeat_durn_type == 'W') {
            if (durn_desc == 'M') {
                durn_value = Math.ceil(parseInt(durn_value) / (7 * 24 * 60));
            } else if (durn_desc == 'H') {
                durn_value = Math.ceil(parseInt(durn_value) / (7 * 24));
            } else if (durn_desc == 'D') {
                durn_value = Math.ceil(parseInt(durn_value) / 7);
            } else if (durn_desc == 'L') {
                durn_value = parseInt(durn_value) * 4;
            } else if (durn_desc == 'Y') {
                durn_value = parseInt(durn_value) * 52;
            }
        } else if (repeat_durn_type == 'L') {
            if (durn_desc == 'M') {
                durn_value = Math.ceil(parseInt(durn_value) / (30 * 24 * 60));
            } else if (durn_desc == 'H') {
                durn_value = Math.ceil(parseInt(durn_value) / (30 * 24));
            } else if (durn_desc == 'D') {
                durn_value = Math.ceil(parseInt(durn_value) / 30);
            } else if (durn_desc == 'W') {
                durn_value = parseInt(durn_value) / 4;
            } else if (durn_desc == 'Y') {
                durn_value = parseInt(durn_value) * 12;
            }
        } else if (repeat_durn_type == 'Y') {
            if (durn_desc == 'M') {
                durn_value = Math.ceil(parseInt(durn_value) / (365 * 24 * 60));
            } else if (durn_desc == 'H') {
                durn_value = Math.ceil(parseInt(durn_value) / (365 * 24));
            } else if (durn_desc == 'D') {
                durn_value = Math.ceil(parseInt(durn_value) / 365);
            } else if (durn_desc == 'W') {
                durn_value = parseInt(durn_value) / 52;
            } else if (durn_desc == 'L') {
                durn_value = parseInt(durn_value) / 12;
            }
        }
    }

    drg_max_durn_value = max_durn_value;
    if (max_durn_type != repeat_durn_type) {
        if (max_durn_type == 'M') {
            if (repeat_durn_type == 'H') {
                temp1 = parseInt(max_durn_value) / 60;
            } else if (repeat_durn_type == 'D') {
                temp1 = parseInt(max_durn_value) / (24 * 60);
            } else if (repeat_durn_type == 'W') {
                temp1 = parseInt(max_durn_value) / (7 * 24 * 60);
            } else if (repeat_durn_type == 'L') {
                temp1 = parseInt(max_durn_value) / (30 * 24 * 60);
            } else if (repeat_durn_type == 'Y') {
                temp1 = parseInt(max_durn_value) / (365 * 24 * 60);
            } else
                temp1 = max_durn_value;
        } else if (max_durn_type == 'H') {
            if (repeat_durn_type == 'M') {
                temp1 = parseInt(max_durn_value) * 60;
            } else if (repeat_durn_type == 'D') {
                temp1 = parseInt(max_durn_value) / 24;
            } else if (repeat_durn_type == 'W') {
                temp1 = parseInt(max_durn_value) / (7 * 24);
            } else if (repeat_durn_type == 'L') {
                temp1 = parseInt(max_durn_value) / (30 * 24);
            } else if (repeat_durn_type == 'Y') {
                temp1 = parseInt(max_durn_value) / (365 * 24);
            } else
                temp1 = max_durn_value;
        } else if (max_durn_type == 'W') {
            if (repeat_durn_type == 'M') {
                temp1 = parseInt(max_durn_value) * 7 * 24 * 60;
            } else if (repeat_durn_type == 'H') {
                temp1 = parseInt(max_durn_value) * 7 * 24;
            } else if (repeat_durn_type == 'D') {
                temp1 = parseInt(max_durn_value) * 7;
            } else if (repeat_durn_type == 'L') {
                temp1 = parseInt(max_durn_value) / 4;
            } else if (repeat_durn_type == 'Y') {
                temp1 = parseInt(max_durn_value) / 52;
            } else
                temp1 = max_durn_value;
        } else if (max_durn_type == 'L') {
            if (repeat_durn_type == 'M') {
                temp1 = parseInt(max_durn_value) * 30 * 24 * 60;
            } else if (repeat_durn_type == 'H') {
                temp1 = parseInt(max_durn_value) * 30 * 24;
            } else if (repeat_durn_type == 'D') {
                temp1 = parseInt(max_durn_value) * 30;
            } else if (repeat_durn_type == 'W') {
                temp1 = parseInt(max_durn_value) * 4;
            } else if (repeat_durn_type == 'Y') {
                temp1 = parseInt(max_durn_value) / 12;
            } else
                temp1 = max_durn_value;

        } else if (max_durn_type == 'Y') {
            if (repeat_durn_type == 'M') {
                temp1 = parseInt(max_durn_value) * 365 * 24 * 60;
            } else if (repeat_durn_type == 'H') {
                temp1 = parseInt(max_durn_value) * 365 * 24;
            } else if (repeat_durn_type == 'D') {
                temp1 = parseInt(max_durn_value) * 365;
            } else if (repeat_durn_type == 'W') {
                temp1 = parseInt(max_durn_value) * 52;
            } else if (repeat_durn_type == 'L') {
                temp1 = parseInt(max_durn_value) * 12;
            } else
                temp1 = max_durn_value;
        } else {
            if (repeat_durn_type == 'M') {
                temp1 = parseInt(max_durn_value) * 24 * 60;
            } else if (repeat_durn_type == 'H') {
                temp1 = parseInt(max_durn_value) * 24;
            } else if (repeat_durn_type == 'W') {
                temp1 = parseInt(max_durn_value) / 7;
            } else if (repeat_durn_type == 'L') {
                temp1 = parseInt(max_durn_value) / 30;
            } else if (repeat_durn_type == 'Y') {
                temp1 = parseInt(max_durn_value) / 365;
            } else
                temp1 = max_durn_value;
        }
        drg_max_durn_value = max_durn_value;
        max_durn_value = temp1;
    }

    var durnTypeList = "";
    var durn_type_value = "";
    var durn_type_code = "";
	
	if(max_durn_type == 'M') 
		max_durn_desc = "Minute(s)"; 
	else if(max_durn_type == 'H')
		max_durn_desc = "Hour(s)"; 
	else if(max_durn_type == 'W')
		max_durn_desc = "Week(s)";
	else if(max_durn_type == 'L')
		max_durn_desc = "Month(s)";
	else if(max_durn_type == 'Y')
		max_durn_desc = "Year(s)";
	 else
	   max_durn_desc = "Day(s)";

    var disp_durn = "";
    disp_durn = " - " + drg_max_durn_value + " " + max_durn_desc;
    var ord_auth_reqd_yn = "N";
    if (frmObj_pres_dtl.force_auth_yn != undefined && frmObj_pres_dtl.force_auth_yn.value != "Y") {
        if (durn_value > parseInt(max_durn_value)) {
            if (chk_for_max_durn_action == "R") {
                showToastMsg("Duration exceeds maximum allowed period" + disp_durn);
                frmObj_pres_dtl.rxDurationDetails.value = drg_max_durn_value;
                if ($("#durationDpList").data("kendoDropDownList").value() != max_durn_type) {
                    var len1 = frmObj_pres_dtl.durationDpList.options.length;
                    var durn_found = false;
                    $("#durationDpList").data("kendoDropDownList").value(max_durn_type);
                }
                //if (durn_found)
                    //frmObj_pres_dtl.rxDurationDetails.focus();
                //else
                    //frmObj_pres_dtl.frequencyDpList.focus();
                populateEndDate();
                return false;
            } else if (chk_for_max_durn_action == "W") {
                showToastMsg("Warning - Duration exceeds maximum allowed period" + disp_durn);
                populateStartDate(frmObj_pres_dtl.rxDurationDetails, sliding_scale_yn);
            } else if (chk_for_max_durn_action == "A") {
                ord_auth_reqd_yn = "Y";
                showToastMsg("Duration exceeds maximum allowed period - Requires authorization" + disp_durn);

                var drug_code = frmObj_pres_dtl.drug_code.value;
                var fldString = " ord_authorized_prev_yn=\"" + frmObj_pres_dtl.ord_authorized_prev_yn.value + "\" ";
                fldString += " ord_auth_reqd_yn=\"" + ord_auth_reqd_yn + "\" ";
                fldString += " ord_authorized_yn=\"" + frmObj_pres_dtl.authroize_yn_val.value + "\" ";
                fldString += " srl_no=\"" + frmObj_pres_dtl.srl_no.value + "\" ";
                fldString += " drug_code=\"" + drug_code + "\" ";
                var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
                fieldValidation(xmlStr, "setDurationAction");
                populateStartDate(frmObj_pres_dtl.rxDurationDetails, sliding_scale_yn);
            } else {
                populateStartDate(frmObj_pres_dtl.rxDurationDetails, sliding_scale_yn);
            }
        } else {
            if (frmObj_pres_dtl.sliding_scale_yn.value == 'N') {               
                var drug_code = frmObj_pres_dtl.drug_code.value;
                var fldString = " ord_authorized_prev_yn=\"" + frmObj_pres_dtl.ord_authorized_prev_yn.value + "\" ";
                fldString += " ord_auth_reqd_yn=\"" + frmObj_pres_dtl.ord_auth_reqd_yn.value + "\" ";
                fldString += " ord_authorized_yn=\"" + frmObj_pres_dtl.authroize_yn_val.value + "\" ";
                fldString += " srl_no=\"" + frmObj_pres_dtl.srl_no.value + "\" ";
                fldString += " drug_code=\"" + drug_code + "\" ";
                var xmlStr = formXMLString(frmObj_pres_dtl, fldString);
                fieldValidation(xmlStr, "setDurationAction");
                populateStartDate(frmObj_pres_dtl.rxDurationDetails, sliding_scale_yn);
                //} end of condition ord_auth_reqd_yn
            }
        }
    }
	showBillingDetails();
    return true; //Added for ML-BRU-SCF-0820 [IN:039500]
}

//Indicator Ends


var pharmRxDetailsScroller;

function assignPharmRxDetailsScroller() {
    pharmRxDetailsScroller = new IScroll('#pharmRxScroller', {
        scrollX: false,
        scrollY: true,
        scrollbars: true,
        interactiveScrollbars: true,
        click: false,
        useTransition: false,
        bindToWrapper: true,
        hideScrollbar: true,
        fadeScrollbars: true,
        preventDefaultException: {
            tagName: /.*/
        },
        onBeforeScrollStart: function(e) {
            var target = e.target;
            while (target.nodeType != 1) target = target.parentNode;
            if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
                e.preventDefault();
        }
    });
    if (pharmRxDetailsScroller != null) {
        pharmRxDetailsScroller.refresh();
    }
}

function getBuildMARDefaulting() {
    var formobj = document.rxDetailsViewForm;
	var hdr_form = document.PharmBaseForm;
    var drug_code = formobj.drug_code.value;
    if (drug_code != "") {
        var priority = $("#rxPriority").data("kendoDropDownList").text();
        var patient_Class = hdr_form.act_patient_class.value;
        var Location_Code = "FWA";
        var form_Code = formobj.form_code.value;
        var facility_id = formobj.facility_id.value;
        var fldString = "drug_code=\"" + drug_code + "\" ";
        fldString += " priority=\"" + priority + "\" ";
        fldString += " patient_Class=\"" + patient_Class + "\" ";
        fldString += " location_Code=\"" + Location_Code + "\" ";
        fldString += " form_Code=\"" + form_Code + "\" ";
        fldString += " facility_id=\"" + facility_id + "\" ";

        var xmlStr = formXMLString(formobj, fldString);
        return fieldValidation(xmlStr, "MARDefault");
    }
}

function dfltFreq(default_val, callFreqChange) {
    var frequencyDpList = $("#frequencyDpList").data("kendoDropDownList");
    if (frequencyDpList) {
        frequencyDpList.value(default_val);
        if (callFreqChange == 'Y')
            freqChange(document.rxDetailsViewForm.frequencyDpList, 'Y', 'dfltFreq'); //dfltFreq added for MO-GN-5490 [IN:054620] - [IN:055921]
    }
}

function setBuildMAR(buildMARDefaulting) {
    var buildMAR_checked = buildMARDefaulting.substring(0, 1);
    var buildMAR_enabled = buildMARDefaulting.substring(1, 2);

    var formobj = document.rxDetailsViewForm;
    if (buildMAR_checked == "C") {
        formobj.buildMAR_yn.checked = true;
        formobj.buildMAR_yn.value = "Y";
    } else {
        formobj.buildMAR_yn.checked = false;
        formobj.buildMAR_yn.value = "N";
    }

    if (buildMAR_enabled == "E") {
        formobj.buildMAR_yn.disabled = false;
    } else {
        formobj.buildMAR_yn.disabled = true;
    }
}

function defFreq(priorityObj, callFrom) {
    if (callFrom == undefined) //  added for MO-GN-5490 [IN:054620] - [IN:055921]
        var callFrom = " ";
	var hdr_form = document.PharmBaseForm;
    var priority = priorityObj.value;
    var formobj = document.rxDetailsViewForm;
    if (formobj.drug_code.value != "") {
        var source_type = $("input[name=source_type]").val();
        var source_code = $("input[name=source_code]").val();
        var home_leave_yn_chk = $("input[name=home_leave_yn_chk]").val();
        var take_home_medication = $("input[name=take_home_medication]").val();
        var in_formulary_yn = " ";
        var PRIORITY = $("#rxPriority").data("kendoDropDownList").value();
        var fldString = " priority=\"" + PRIORITY + "\" ";
        fldString += " patient_class=\"" + hdr_form.act_patient_class.value + "\" ";
        fldString += " act_patient_class=\"" + formobj.patient_class.value + "\" ";
        fldString += " calling_mode=\"" + formobj.calling_mode.value + "\" ";
        fldString += " drug_code=\"" + formobj.drug_code.value + "\" ";
        fldString += " freq_code=\"" + formobj.frequencyDpList.value + "\" ";
        fldString += " dup_found=\"" + formobj.dup_found.value + "\" ";
        fldString += " in_formulary_yn=\"" + in_formulary_yn + "\" ";
        fldString += " order_type_code=\"" + formobj.order_type_code.value + "\" ";
        fldString += " srlNo=\"" + formobj.srl_no.value + "\" ";
        fldString += " drug_class=\"" + formobj.drug_class.value + "\" ";
        fldString += " source_type=\"" + source_type + "\" ";
        fldString += " source_code=\"" + source_code + "\" ";
        fldString += " take_home_medication=\"" + take_home_medication + "\" ";
        fldString += " home_leave_yn_val=\"" + home_leave_yn_chk + "\" ";
        fldString += " patient_id=\"" + formobj.patient_id.value + "\" ";
        fldString += " encounter_id=\"" + formobj.encounter_id.value + "\" ";
        fldString += " resp_id=\"" + formobj.resp_id.value + "\" ";
        fldString += " pract_id=\"" + formobj.pract_id.value + "\" ";
        fldString += " callFrom=\"" + callFrom + "\" ";

        var xmlStr = formXMLString(formobj, fldString);
        return fieldValidation(xmlStr, "loadFreqsForPriority");

    }
}

function getActionText(route_code, form_code) {
    var route_code = $("#routeDpList").data("kendoDropDownList").value();
    var formobj = document.rxDetailsViewForm;
    var fldString = " route_code=\"" + route_code + "\" ";
    fldString += " form_code=\"" + form_code + "\" ";

    var xmlStr = formXMLString(formobj, fldString);
    return fieldValidation(xmlStr, "getActiontext");
}

function addFrequencyList(code, desc, default_val) {
    if (desc.indexOf("Select Value") > -1 && code != "") {
        $("#frequencyDpList").getKendoDropDownList().dataSource.insert({
            value: code,
            text: desc
        });
    }
}

function clearFrequencyList() {
    var ddl = $("#frequencyDpList").data("kendoDropDownList");
    ddl.dataSource.data([]);
}

function assignActionText(actionText) {
    $("#rxDrugRouteVal").text(actionText);
}

function alertNoApplicaFreq(priority) {
    if (priority == 'U') {
        showToastMsg("Applicable frequency for urgent priority not defined for the drug");
        $("#rxPriority").data("kendoDropDownList").value("R");
    } else {
        showToastMsg("Applicable frequency for routine priority not defined for the drug");
        //document.rxDetailsViewForm.rxPriority.value = 'Urgent';
        $("#rxPriority").data("kendoDropDownList").value("U");
    }
}

function assignBuildMAR(buildMAR_yn) {
}

/*orientation change*/
    if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',orientationChangeRx, false);
	}
    function orientationChangeRx() {
    	setTimeout(function() {
    	    if (Math.abs(window.orientation) === 90) {
       	 	 pharmRxDetailsScroller.refresh();
    	    } else {
       	 	 pharmRxDetailsScroller.refresh();
    	    } 	 
        }, 1500);
    }
