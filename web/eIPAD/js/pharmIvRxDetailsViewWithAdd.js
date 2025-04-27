var ivrxWithAddCalcBy = $("#drugCount").val(); // defined length of additives
var dosageUnit;
var dosageUnitDetails;
var disabledBodyWtField;
var calcBodyWeight;
var calcIvWithAddDosageUnit;
var calcIvWithAddDosageUnitDetails;
var calcfluidNameIvWithAdd;
var calcInfusionRateIvWithAdd;
var calcIvWithAddDosageStrengthUnit;
var qualityArray = [];
var fulidArray = [];
var freqArray = [];
var drunArray = [];
var errorFound = false;

function commonObj() {
    this.code = "";
    this.desp = "";
}
for (var i = 0; i < ivrxWithAddCalcBy; i++) {
    dosageUnit = $("#ivrxWithAddCalcBy_" + i).kendoDropDownList({        
    });
    calcBodyWeight = $("#bodyWtDoseValues_" + i).kendoDropDownList({
    });
    dosageUnitDetails = $("#ivrxWithAddDosageBy_" + i).kendoDropDownList({
    });
    disabledBodyWtField = $("#disabledOnBodyWt_" + i).kendoDropDownList({
        enable: false
    });
    calcIvWithAddDosageUnit = $("#ivWithAddDosageUnit_" + i).kendoDropDownList({
    });
    calcIvWithAddDosageStrengthUnit = $("#ivWithAddDosageStrengthUnit_" + i).kendoDropDownList({
        enable: false
    });
    calcIvWithAddDosageUnitDetails = $("#ivWithAdddosageUnitDetails_" + i).kendoDropDownList({
    });
    calcfluidNameIvWithAdd = $("#fluidNameIvWithAddValues").kendoDropDownList({
    });
    calcInfusionRateIvWithAdd = $("#ivrxWithAddInfusionRateUnit").kendoDropDownList({
    });
}
var dosageBy = $("#ivrxWithAddInfuseRateUnit").kendoDropDownList({
});
var fluidName = $("#ivrxWithAddIfuseOverDrugUnit").kendoDropDownList({
});
// Numeric check
$('#volume').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('.ivrxWithAddInfuseRateUnit').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('#ivrxDosageBy').on('input', function(event) {
    this.value = this.value.replace(/[^0-9]/g, '');
});
$('.ivRxWithAddInfuseOverInput').on('input', function(event) {
    this.value = this.value.replace(/[^0-9]/g, '');
});
$('.ivrxWithAddDrugUnit').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('.ivrxDoseDrugUnit1').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});

//Infusion over Hrs and Mins
	 $("#INFUSION_PERIOD_VALUE_WA_HRS").focusout(function() {
			var infusionOverHrs = $("#INFUSION_PERIOD_VALUE_WA_HRS").val();
			 var infusionOverMins = $("#INFUSION_PERIOD_VALUE_WA_MINS").val();

			if (infusionOverHrs == null || infusionOverHrs == "") {
				$("#INFUSION_PERIOD_VALUE_WA_HRS").val(00);
			}
			if ( (infusionOverHrs >=24 && infusionOverMins >0) || infusionOverHrs >24) {
				showToastMsg("Infusion over cannot be greater than 24 Hours"); 
				$("#INFUSION_PERIOD_VALUE_WA_MINS").val(00);
			}     
		});

    $("#INFUSION_PERIOD_VALUE_WA_MINS").focusout(function() {	
	    var infusionOverHrs = $("#INFUSION_PERIOD_VALUE_WA_HRS").val();
        var infusionOverMins = $("#INFUSION_PERIOD_VALUE_WA_MINS").val();
        if (infusionOverMins == null || infusionOverMins == "") {
            $("#INFUSION_PERIOD_VALUE_WA_MINS").val(00);
        }
		if ( (infusionOverHrs >=24 && infusionOverMins >0) || infusionOverHrs >24) {
		    showToastMsg("Infusion over cannot be greater than 24 Hours"); 
            $("#INFUSION_PERIOD_VALUE_WA_MINS").val(00);
			return;
        } 		
        if (infusionOverMins != null && infusionOverMins > 59) {
            showToastMsg("Minute entered is invalid.It sholud be between 0 and 59");          
        } 
    });
// End infuse over

// Admin details
var adminDosageUnitDetails = $("#infusionRateUnit").kendoDropDownList({
});
$("#ivrxWithAddAdminStartDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm" //24 hours format
});

$("#ivrxWithAddAdminAdminEndDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm" //24 hours format
});
var startDatepicker = $("#ivrxWithAddAdminStartDate").data("kendoDateTimePicker");
var endDatepicker = $("#ivrxWithAddAdminAdminEndDate").data("kendoDateTimePicker");
var formobj = document.formIVPrescriptionDetails;
var START_DATES = formobj.START_DATES.value;
var END_DATES = formobj.END_DATES.value;

if(START_DATES=="" || START_DATES==undefined){
var startDateVal = formobj.start_date_fluid.value;
startDatepicker.value(startDateVal);
}

if(END_DATES==""|| END_DATES==undefined ){
var endDateVal = formobj.end_date_fluid.value;
endDatepicker.value(endDateVal);
}

function refreshLocation() {
}
function clearDfltVehicle() {
    var formFluid = document.formIVPrescriptionDetails;
    formFluid.volume.value = "";
}
function setBuildMAR() {
}
function setBackFutureDate(back_date, future_date) {  
}
function assignDfltVehicle(fluid_code, dflt_drug_desc, volume_of_drug, default_yn, trade_code, trade_name, fluid_adr_count) 
{
    var res = decodeURIComponent(dflt_drug_desc);
    var obj = new commonObj();
    obj.code = fluid_code;
    obj.desp = res;
    fulidArray.push(obj);
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

function setStockValue(obj) {
    var formFluid = document.formIVPrescriptionDetails;
    if (formFluid.mfr_yn.value != "Y") {
        if (obj.value != "0" && obj.value != "") {
            var frmAdminobj = document.formIVPrescriptionDetails; //Added for SKR-CRF-0035 [IN:037727] -Start
            var iv_calc_infuse_by = frmAdminobj.iv_calc_infuse_by.value;
            if (iv_calc_infuse_by == 'I') {
                var volume = formFluid.volume;
                var orderQty = 1;
                var volumePerUnit = formFluid.volumePerUnit.value;
                var maxTotalVolume = parseInt(volumePerUnit) * parseInt(orderQty);
                var minTotalVolume = parseInt(volumePerUnit) * (parseInt(orderQty) - 1);
                var totalVolume = parseInt(obj.value);
                var msg = "";
                if (parseInt(totalVolume) > parseInt(maxTotalVolume)) {                  
                    totalVolume = maxTotalVolume;
                } else if (parseInt(totalVolume) <= parseInt(minTotalVolume)) {                    
                    totalVolume = minTotalVolume + 1;
                }
                if (msg != "") {
				 showToastMsg(msg);
                    volume.value = totalVolume;
                    return false;
                }
            } 
            formFluid.STOCK_VALUE.value = obj.value;
            setInfuseOverValue();            
            if (frmAdminobj.iv_calc_infuse_by.value == 'I') { 
                var bean_id = frmAdminobj.bean_id.value;
                var bean_name = frmAdminobj.bean_name.value;
                var start_date = frmAdminobj.start_date_fluid.value;
                var durnHrs = frmAdminobj.INFUSION_PERIOD_VALUE.value;
                var durnMins = frmAdminobj.INFUSION_PERIOD_VALUE_MIN.value;
                if (trimString(durnHrs) == "")
                    durnHrs = '0';
                if (trimString(durnMins) == "")
                    durnMins = '0';
                var durn_unit = "M";
                var DURN_VALUE = (parseInt(durnHrs) * 60) + parseInt(durnMins)
                var qryString = bean_id + "&bean_name=" + bean_name + "&validate=POPULATEENDDATEADMIN&start_date=" + start_date + "&durn_value=" + DURN_VALUE + "&durn_unit=" + durn_unit + "&mode=IV_CALC_ADMIN";
                submitXML(qryString, "");
            } 
        } else {
            setInfuseOverValue();
        }
    }
	}

function onSelectCalculateBy(i, source) {   
    var dataItem = document.getElementById("ivrxWithAddCalcBy_" + i);    
    if (dataItem.value == "D") {        
        $("#ivWithAdddoseRemarksField" + i).show();
        $("#doseDetailsWrapper_Strength" + i).show();
        $("#enabledOnDosage" + i).show();
        $("#disabledOnBodyWt" + i).hide();
        $("#doseDetailsWrapper_OnBodyWt" + i).hide();
        $("#ivWithAdddoseUnitsWrapper" + i).hide();
        $("#doseDetailsWrapper_Dose" + i).hide();
        $("#hideShowDivider" + i).hide();
		$("#ivWithAddDrugIndications_"+i).show();
		if(source == "onReady")
			onSelectDosageBy(i, "onReady");
		else
			onSelectDosageBy(i, "onCalByChange");
    } else if (dataItem.value == "B") {
		$("#ivWithAddDrugIndications_"+i).hide();
		checkForHtWt(i);
        $("#doseDetailsWrapper_OnBodyWt" + i).show();
        $("#ivWithAdddoseUnitsWrapper" + i).show();
        $("#enabledOnDosage" + i).hide();
        $("#disabledOnBodyWt" + i).show();
        $("#ivWithAdddoseRemarksField" + i).hide();
        $("#doseDetailsWrapper_Strength" + i).hide();
        $("#doseDetailsWrapper_Dose" + i).hide();
        $("#hideShowDivider" + i).show();
		document.getElementById("CALC_DOSE_VALUE_OnBodyWt"+i).value = document.getElementById("calc_dose_value"+i).value;
		calculateDosage_By_BSA_or_Weight(i);
    }
	if (pharmIvRxDetailsScroller != null) {
        pharmIvRxDetailsScroller.refresh();
    }
}
function checkForHtWt(i)
{
    $("#valueOfSelectedElem").val(i);
	var baseformobj = document.PharmBaseForm;
	var weight = baseformobj.weight.value;
	var height = baseformobj.height.value;
	if(weight == "" || height == "" || weight == null || height == null ){
	   baseformobj.ht_wt_check.value =  "Y";
	  $("#pharmacyValidationPopUp").show();
	 $("#heightCheckOk").addClass('cstFieldDullRxNone');	 
	 $("#typeOfHWcheckWithAdd").val("IVWITHADDTOAST");
	 $("#dvMez").show();
	}
}

function formXMLString(formobj, fldString) {
    var bean_id = formobj.bean_id_IVD.value;
    var bean_name = formobj.bean_name_IVD.value;
    var xmlStr = "<root><SEARCH ";
    xmlStr += " bean_id=\"" + bean_id + "\" ";
    xmlStr += " bean_name=\"" + bean_name + "\" ";
    xmlStr += fldString;
    xmlStr += " /></root>";
    return xmlStr;
}

function onSelectDosageBy(i, source) {
	var header_form = document.PharmBaseForm;
    var dataItem = document.getElementById("ivrxWithAddDosageBy_" + i);   
    if (dataItem.value == "S") {
        $("#doseDetailsWrapper_Strength" + i).show();
        $("#doseDetailsWrapper_Dose" + i).hide();
		if(source == "onchange") {			
			document.getElementById("id_qty_value_" + i).value = document.getElementById("strength_value" + i).value;
		}
		else if(source == "onCalByChange") {
			document.getElementById("id_qty_value_" + i).value = document.getElementById("strength_value" + i).value;
		}
		else if(source == "onReady") {
			
		}		
    } else if (dataItem.value == "Q") {        
        $("#doseDetailsWrapper_Dose" + i).show();
        $("#doseDetailsWrapper_Strength" + i).hide();
		if(source == "onchange") {			
			document.getElementById("CALC_DOSE_VALUE_" + i).value = document.getElementById("pres_qty_value" + i).value;
		}
		else if(source == "onReady") {
			document.getElementById("CALC_DOSE_VALUE_" + i).value = document.getElementById("pres_qty_value" + i).value;
		}
		else if(source == "onCalByChange") {
			document.getElementById("CALC_DOSE_VALUE_" + i).value = document.getElementById("pres_qty_value" + i).value;
		}
		}
}
var pharmIvRxDetailsScroller;
var pharmIvRxAdminScroller;
function assignPharmIvRxDetailsScroller() {
    pharmIvRxDetailsScroller = new IScroll('#drugDetailsIvRxScroller', {
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
    if (pharmIvRxDetailsScroller != null) {
        pharmIvRxDetailsScroller.refresh();
    }
}
function assignPharmIvRxAdminScroller() {
    pharmIvRxAdminScroller = new IScroll('#administrationDetailsIvRxScroller', {
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
    if (pharmIvRxAdminScroller != null) {
        pharmIvRxAdminScroller.refresh();
    }
}
function openDrugDetailsTab() {
    $("#drugDetailsIvRxScroller").show();
    $("#administrationDetailsIvRxScroller").hide();
    $("#IVRxDrugTab").css("color", "#096b93");
    $("#IVRxAdminTab").css({
        "color": "#313844",
        "border-bottom": "none"
    });

    $("#IVRxDrugTab").css({
        "color": "#096b93",
        "border-bottom": "#2a8fbd 2px solid"
    });

    if (pharmIvRxDetailsScroller != null) {
        pharmIvRxDetailsScroller.refresh();
    }
}
function openAdminDetailsTab() {
    var freq_code = $("#fluidNameIvWithAddValues").data("kendoDropDownList").value();
    if (freq_code == "") {
	 showToastMsg("Select a fluid");       
    } else {
        $("#drugDetailsIvRxScroller").hide();
        $("#administrationDetailsIvRxScroller").show();
        $("#IVRxDrugTab").css({
            "color": "#313844",
            "border-bottom": "none"
        });
        $("#IVRxAdminTab").css({
            "color": "#096b93",
            "border-bottom": "#2a8fbd 2px solid"
        });
        if (pharmIvRxAdminScroller != null) {
            pharmIvRxAdminScroller.refresh();
        }
    }
}

function completeIvRxDetailsConfirm() {
     $("#typeOfHWcheckWithAdd").val("");
    if (chkMandatoryFlds("Release")) {
        var header_form = document.PharmBaseForm;
        var frmObj = document.formIVPrescriptionDetails;     
        var patient_class = header_form.act_patient_class.value;
        var ord_date_time = frmObj.sys_date.value;
        var allergic_yn = "N";
        if (frmObj != null) {
            var th_medn = "N";
            if (patient_class == "OP")
                th_medn = "D";
            var height = header_form.height.value;
            var height_unit = header_form.height_unit.value;
            if (height_unit == "")
                height_unit = "Cms";
            var weight = header_form.weight.value;
            var weight_unit = header_form.weight_unit.value;
            if (weight_unit == "")
                weight_unit = "Kgs";
            var bsa = header_form.bsa.value;
            var bsa_unit = "BSA";
            var bmi = header_form.bmi.value;
            var priority = header_form.priority.value;
            if (header_form.allergic_yn.value == "NO")
                allergic_yn = "N";
            else
                allergic_yn = "Y";
        }
        var iv_presc_yn = "N";
        if (frmObj.admixture.value == "Y")
            iv_presc_yn = "I";
        var bean_id = frmObj.bean_id_IVD.value;
        var bean_name = frmObj.bean_name_IVD.value;
        var patient_id = frmObj.patient_id.value;
        var encounter_id = frmObj.encounter_id.value;
        var volume = frmObj.volume.value;
        var buildMAR_yn = "N";
        if (frmObj.build_mar.checked == true)
            buildMAR_yn = "Y";
        var iv_calc_infuse_by = frmObj.iv_calc_infuse_by.value
        var bl_install_yn = frmObj.bl_install_yn.value;
        var bl_disp_charge_dtl_in_rx_yn = frmObj.bl_disp_charge_dtl_in_rx_yn.value;        
        var INFUSION_UOM_DISPLAY = frmObj.STOCK_UOM_CODE.value;
        var xmlStr = "<root><SEARCH ";
        xmlStr += " PRIORITY=\"" + priority + "\" ";
        xmlStr += " HEIGHT=\"" + height + "\" ";
        xmlStr += " HEIGHT_UNIT=\"" + height_unit + "\" ";
        xmlStr += " WEIGHT=\"" + weight + "\" ";
        xmlStr += " WEIGHT_UNIT=\"" + weight_unit + "\" ";
        xmlStr += " BSA=\"" + bsa + "\" ";
        xmlStr += " BMI=\"" + bmi + "\" ";
        xmlStr += " BSA_UNIT=\"" + bsa_unit + "\" ";
        xmlStr += " IV_PRESC_YN=\"" + iv_presc_yn + "\" ";
        xmlStr += " TH_MEDN=\"" + th_medn + "\" ";
        xmlStr += " allergic_yn=\"" + allergic_yn + "\" ";
        xmlStr += " ord_date_time=\"" + ord_date_time + "\" ";
        xmlStr += " ROOM_NUM=\"" + header_form.room_num.value + "\" ";
        xmlStr += " BED_NUM=\"" + header_form.bed_num.value + "\" ";
        xmlStr += " FLUID_CODE=\"" + $("#fluidNameIvWithAddValues").data("kendoDropDownList").value() + "\" ";
        xmlStr += " fluid=\"" + $("#fluidNameIvWithAddValues").data("kendoDropDownList").value() + "\" ";
		xmlStr += " DRUG_DESC=\"" + encodeURIComponent($("#fluidNameIvWithAddValues").data("kendoDropDownList").text(), "UTF-8") + "\" ";
        xmlStr += " VOLUME=\"" + frmObj.volume.value + "\" ";
        xmlStr += " STRENGTH_PER_VALUE_PRES_UOM=\"" + frmObj.volume.value + "\" ";
        xmlStr += " STOCK_VALUE=\"" + frmObj.STOCK_VALUE.value + "\" ";
        var buildMAR_yn = "N";
        if (frmObj.build_mar.checked)
            buildMAR_yn = "Y";
        xmlStr += " buildMAR_yn=\"" + buildMAR_yn + "\" ";
        xmlStr += " ORDER_TYPE_CODE=\"" + frmObj.ORDER_TYPE_CODE.value + "\" ";
        xmlStr += " PRACT_ID=\"" + frmObj.pract_id.value + "\" ";
        xmlStr += " LOCN_TYPE=\"" + frmObj.location_type.value + "\" ";
        xmlStr += " LOCN_CODE=\"" + frmObj.location_code.value + "\" ";
        //Admin Details
        xmlStr += " INFUSION_VALUE=\"" + frmObj.infuse_rate.value + "\" ";
        xmlStr += " lstInfusionRateDurnUnit=\"" + $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value() + "\" ";
        xmlStr += " INFUSION_PERIOD_VALUE=\"" + frmObj.INFUSION_PERIOD_VALUE.value + "\" ";
        xmlStr += " INFUSION_PERIOD_VALUE_MIN=\"" + frmObj.INFUSION_PERIOD_VALUE_MIN.value + "\" ";
        xmlStr += " DURN_VALUE=\"" + frmObj.ivrxDosageBy.value + "\" ";
        xmlStr += " START_DATE=\"" + frmObj.ivrxWithAddAdminStartDate.value + "\" ";
        xmlStr += " END_DATE=\"" + frmObj.ivrxWithAddAdminAdminEndDate.value + "\" ";
        xmlStr += " INFUSION_PERIOD_UOM=\"" + $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value() + "\" ";
        xmlStr += " DURN_UNIT=\"" + $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value() + "\" ";
        xmlStr += " INFUSION_UOM=\"" + $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value() + "\" ";
        xmlStr += " INFUSION_PER_UNIT=\"" + $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value() + "\" ";
        xmlStr += " sys_date=\"" + frmObj.sys_date.value + "\" ";
        xmlStr += " FREQUENCY=\"" + frmObj.FREQUENCY.value + "\" ";
        xmlStr += " freq_desc=\"" + frmObj.freq_desc.value + "\" ";
        xmlStr += " INFUSION_UOM_DISPLAY=\"" + INFUSION_UOM_DISPLAY + "\" ";
        xmlStr += " infusion_over_insert_value=\"" + frmObj.infusion_over_insert_value.value + "\" ";
        xmlStr += " iv_calc_infuse_by=\"" + frmObj.iv_calc_infuse_by.value + "\" ";
        xmlStr += " DURN_TYPE=\"H\" ";        
        var admixture = "N";
        if (frmObj.admixture.checked)
            admixture = "Y";
        xmlStr += " admixture=\"" + admixture + "\" ";

        for (var i = 0; i < ivrxWithAddCalcBy; i++) {
            xmlStr += " DRUG_CODE" + i + "=\"" + document.getElementById("drug_code" + i).value + "\" ";
            xmlStr += " CALC_DOSE_BASED_ON" + i + "=\"" + $("#ivrxWithAddCalcBy_" + i).data("kendoDropDownList").value() + "\" ";
			xmlStr += " DOSAGE_TYPE" + i + "=\"" + $("#ivrxWithAddDosageBy_" + i).data("kendoDropDownList").value() + "\" ";
			xmlStr += " STRENGTH_VALUE" + i + "=\"" + document.getElementById("strength_value" + i).value + "\" ";
			xmlStr += " STRENGTH" + i + "=\"" + document.getElementById("id_qty_value_" + i).value + "\" ";		
			xmlStr += " DRUG_REMARKS" + i + "=\"" +encodeURIComponent( document.getElementById("drugRemTextarea_" + i).value, "UTF-8") + "\" ";
            if ($("#ivrxWithAddCalcBy_" + i).data("kendoDropDownList").value() == "D") {
                if ($("#ivrxWithAddDosageBy_" + i).data("kendoDropDownList").value() == "S") {
                    xmlStr += " OR_QTY_DESC" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").text() + "\" ";
                    xmlStr += " QTY_DESC_CODE" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_UNIT" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_UOM" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " PRES_QTY_UOM" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " Dosage_Uom" + i + "=\"" + $("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_DESC" + i + "=\"" + encodeURIComponent($("#ivWithAddDosageStrengthUnit_" + i).data("kendoDropDownList").text(), "UTF-8") + "\" ";
                    xmlStr += " QTY_VALUE" + i + "=\"" + document.getElementById("id_qty_value_" + i).value + "\" ";
                    } else {
                    xmlStr += " OR_QTY_DESC" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").text() + "\" ";
                    xmlStr += " QTY_DESC_CODE" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_UNIT" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_UOM" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " PRES_QTY_UOM" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " Dosage_Uom" + i + "=\"" + $("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").value() + "\" ";
                    xmlStr += " QTY_DESC" + i + "=\"" + encodeURIComponent($("#ivWithAddDosageUnit_" + i).data("kendoDropDownList").text(), "UTF-8") + "\" ";
                    xmlStr += " QTY_VALUE" + i + "=\"" + document.getElementById("CALC_DOSE_VALUE_" + i).value + "\" ";
                    xmlStr += " PRES_QTY_VALUE" + i + "=\"" + document.getElementById("CALC_DOSE_VALUE_" + i).value + "\" ";
					}
            } else {
                xmlStr += " CALC_DOSE_VALUE" + i + "=\"" + document.getElementById("CALC_DOSE_VALUE_OnBodyWt" + i).value + "\" ";
                xmlStr += " OR_QTY_DESC" + i + "=\"" + $("#bodyWtDoseValues_" + i).data("kendoDropDownList").text() + "\" ";
                xmlStr += " QTY_UNIT" + i + "=\"" + $("#bodyWtDoseValues_" + i).data("kendoDropDownList").value() + "\" ";
                xmlStr += " QTY_UOM" + i + "=\"" + $("#bodyWtDoseValues_" + i).data("kendoDropDownList").value() + "\" ";
                xmlStr += " PRES_QTY_UOM" + i + "=\"" + $("#bodyWtDoseValues_" + i).data("kendoDropDownList").value() + "\" ";
                xmlStr += " Dosage_Uom" + i + "=\"" + $("#bodyWtDoseValues_" + i).data("kendoDropDownList").value() + "\" ";
                 xmlStr += " CALC_DOSE_BY" + i + "=\"" + $("#ivWithAdddosageUnitDetails_" + i).data("kendoDropDownList").value() + "\" ";
                xmlStr += " QTY_VALUE" + i + "=\"" + document.getElementById("ivrxDoseDrugUnit" + i).value + "\" ";
               }
            if (document.getElementById("txtDupDrug_" + i))
                xmlStr += " CURRENTRX_REMARKS" + i + "=\"" + encodeURIComponent(document.getElementById("txtDupDrug_" + i).value, "UTF-8") + "\" ";
            else
                xmlStr += " CURRENTRX_REMARKS" + i + "=\"\" ";
            if (document.getElementById("txtBeyDosLimit_" + i))
                xmlStr += " DOSE_REMARKS" + i + "=\"" + encodeURIComponent(document.getElementById("txtBeyDosLimit_" + i).value, "UTF-8") + "\" ";
            else
                xmlStr += " DOSE_REMARKS" + i + "=\"\" ";
            if (document.getElementById("txtAllergy_" + i))
                xmlStr += " ALLERGY_REMARKS" + i + "=\"" + encodeURIComponent(document.getElementById("txtAllergy_" + i).value, "UTF-8") + "\" ";
            else
                xmlStr += " ALLERGY_REMARKS" + i + "=\"\" ";
			if (document.getElementById("txtDrugIndi_" + i))
				xmlStr += " DRUG_INDICATION" + i + "=\"" + encodeURIComponent(document.getElementById("txtDrugIndi_" + i).value, "UTF-8") + "\" ";
			else
                xmlStr += " DRUG_INDICATION" + i + "=\"\" ";
        }

        xmlStr += " /></root>";
        var qryString = bean_id + "&bean_name=" + bean_name + "&validate=RELEASE" + "&patient_class=" + patient_class + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&volume=" + volume;
        submitXML(qryString, xmlStr);

        $("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
        setTimeout(function() {
            $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
                function(res) {});
        }, 1000);
    }
}

function chkMandatoryFlds(calledMode) {
    var retStat = true;
    var frmObj = document.formIVPrescriptionDetails;
    for (var i = 0; i < ivrxWithAddCalcBy; i++) {
        if (document.getElementById("LIMIT_IND_" + i) != undefined && ((document.getElementById("LIMIT_IND_" + i).value == "N" && document.getElementById("txtBeyDosLimit_" + i).value == "") || (document.getElementById("ALLERGY_YN_" + i).value == "Y" && document.getElementById("txtAllergy_" + i).value == "") || (document.getElementById("CURRENT_RX_" + i).value == "Y" && document.getElementById("txtDupDrug_" + i).value == ""))) {
		 showToastMsg("Over-ridden reason cannot be blank");
            retStat = false;
            break;
        } else {
			if ($("#ivrxWithAddCalcBy_" + i).data("kendoDropDownList").value() == "D") {
				if ($("#ivrxWithAddDosageBy_" + i).data("kendoDropDownList").value() == "S") {
					
					if (trimCheck(document.getElementById("id_qty_value_" + i).value) == "" || parseFloat(document.getElementById("id_qty_value_" + i).value) == 0.0 ) {
						showToastMsg("Strength cannot be blank or Zero");
						retStat = false;
						break;
					}
				}
				else {
					if (trimCheck(document.getElementById("CALC_DOSE_VALUE_" + i).value) == "" || parseFloat(document.getElementById("CALC_DOSE_VALUE_" + i).value) == 0.0) {
						showToastMsg("Dose cannot be blank or Zero");
						retStat = false;
						break;
					}
				}
			}
			else {
				if (trimCheck(document.getElementById("CALC_DOSE_VALUE_OnBodyWt" + i).value) == "" || parseFloat(document.getElementById("CALC_DOSE_VALUE_OnBodyWt" + i).value) ==0.0) {
					showToastMsg("Dose cannot be blank or Zero");
					retStat = false;
						break;
				}
				if (trimCheck(document.getElementById("ivrxDoseDrugUnit" + i).value) == "" || parseFloat(document.getElementById("ivrxDoseDrugUnit" + i).value)==0.0 ) {
					showToastMsg("Dose cannot be blank or Zero");
					retStat = false;
						break;
				}
			}				
            var total_hr = frmObj.ivrxDosageBy.value;
            total_hr = parseFloat(total_hr) * 60;
            var iv_calc_infuse_by = frmObj.iv_calc_infuse_by.value;
            infuseOver = getInfuseOverInMin(frmObj.INFUSION_PERIOD_VALUE.value, frmObj.INFUSION_PERIOD_VALUE_MIN.value);
            if (trimCheck($("#fluidNameIvWithAddValues").data("kendoDropDownList").value()) == "") {
			 showToastMsg("Fluid cannot be blank");
               retStat = false;
                break;
            }
            if (trimCheck(frmObj.ivrxWithAddAdminStartDate.value) == "") {
			 showToastMsg("Start date cannot be blank");
               retStat = false;
                break;
            } else if (trimCheck(frmObj.ivrxWithAddAdminAdminEndDate.value) == "") {
			 showToastMsg("Current end date cannot be blank");
               retStat = false;
                break;
            } else if ((trimCheck(frmObj.INFUSION_PERIOD_VALUE.value) == "" || parseFloat(frmObj.INFUSION_PERIOD_VALUE.value) == 0.0) && (trimCheck(frmObj.INFUSION_PERIOD_VALUE_MIN.value) == "" || parseFloat(frmObj.INFUSION_PERIOD_VALUE_MIN.value) == 0.0)) {
			 showToastMsg("Infuse over cannot be blank or zero");
                retStat = false;
                break;
            } else if (trimCheck(frmObj.infuse_rate.value) == "" || parseFloat(frmObj.infuse_rate.value) == 0.0) {
			 showToastMsg("Infusion rate cannot be blank or zero");
                retStat = false;
                break;
            } else if (trimCheck(frmObj.volume.value) == "" || parseFloat(frmObj.volume.value) == 0.0) {
			 showToastMsg("volume cannot be blank or zero");
                retStat = false;
                break;
            }
            else if (infuseOver > 24 * 60) {
			 showToastMsg("Infuse over cannot be greater than 24 Hours");
                retStat = false;
                break;
            } else if (parseFloat(total_hr) < parseInt(infuseOver) && iv_calc_infuse_by != 'I') {
			 showToastMsg("Duration cannot be less than Infuse over");
               retStat = false;
            } else if (frmObj.INFUSION_PERIOD_VALUE_MIN.value != "") {
                min = frmObj.INFUSION_PERIOD_VALUE_MIN.value;
                if (parseInt(min) > 59) {
				 showToastMsg("Minute entered is invalid .It should be between 0 and 59");
                   retStat = false;
                    break;
                }
            } else {
                var lstInfusionRateDurnUnit = $("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value();
                var total_hr = frmObj.ivrxDosageBy.value;
                total_hr = parseFloat(total_hr) * 60;
                infuseOver = getInfuseOverInMin(frmObj.INFUSION_PERIOD_VALUE.value, frmObj.INFUSION_PERIOD_VALUE_MIN.value);
                if (parseFloat(total_hr) < parseInt(infuseOver)) {
				 showToastMsg("Duration cannot be less than Infuse over");
                    retStat = false;
                    break;
                }
            }
        }
    }    
    return retStat;
}

function getInfuseOverInMin(hr, mi) {
    if (hr == "")
        hr = 0;
    if (mi == "")
        mi = 0;
    tot = parseFloat(hr * 60) + parseFloat(mi);
    return tot;
}
var operationFlag = false;

function okClickDialog() {
	var header_form = document.PharmBaseForm;
	if(operationFlag) {
		header_form.ivrxOperation.value = "New";
	}
	else {
		header_form.ivrxOperation.value = "Update";
	}
    $("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
}

function cancelClickDialog() {
	operationFlag = false;
    $("#confirmMsg").hide();
}

function closeRxDetailsView() {
	operationFlag = true;
    $("#confirmMsg").show();
	$("#typeOfHWcheckWithAdd").val("");
	$("#typeOfHWcheckInter").val("");
	
}
$(document).ready(function() {
    var path;
	var header_form = document.PharmBaseForm;
	for (var i = 0; i < ivrxWithAddCalcBy; i++) {
		var dataItem = document.getElementById("ivrxWithAddCalcBy_" + i);   
		//if(header_form.ivrxOperation.value == "New") {
		//document.formIVPrescriptionDetails.ivrxDosageBy.value = "24";
			chkDuration();
		//}
		if (dataItem.value == "D") {
			onSelectCalculateBy(i, "onReady");
			}
		else if(dataItem.value == "B") {
			onSelectCalculateBy(i, "onReady");
		}
	}
	$("#ivrxWithAddAdminStartDate").attr("readonly", true);
    openDrugDetailsTab();
setTimeout(function() {
        assignPharmIvRxDetailsScroller();
        assignPharmIvRxAdminScroller();
    }, 1000);
});

function fieldValidationIvRx(xmlStr, source) {
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
    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionIvRxWithAdtValidation.jsp?validate=" + source, false);
    xmlHttpObj.send(xmlDoc);
    return true;
}

function calculateDosage_By_BSA_or_Weight(i) {
    var formObj = document.formIVPrescriptionDetails;
    var baseDoseValue = "CALC_DOSE_VALUE_OnBodyWt" + i;
    if (baseDoseValue == 0)
        baseDoseValue = 1;
    var kgm2value = "ivWithAdddosageUnitDetails_" + i;
    var strength_val = "ivrxDoseDrugUnit" + i;
    var strVal = "STR_VAL_" + i;
    var base_Dose_Value = document.getElementById(baseDoseValue).value;
    var kg_m2_value = document.getElementById(kgm2value).value;
    var patient_weight = document.getElementById("weight").value;
    var patient_bsa = document.getElementById("bsa").value;
    if (kg_m2_value == "KG") {
        var totDoseValue = parseFloat(base_Dose_Value) * parseFloat(patient_weight);
        document.getElementById(strength_val).value = totDoseValue;
        if (isNaN(totDoseValue)) {
            document.getElementById(strength_val).value = document.getElementById(strVal).value;
        }
    } else {
        var totDoseValue = parseFloat(base_Dose_Value) * parseFloat(patient_bsa);
        document.getElementById(strength_val).value = Math.round(parseFloat(totDoseValue) * 1000) / 1000;
        if (isNaN(totDoseValue)) {
            document.getElementById(strength_val).value = document.getElementById(strVal).value;
        }
    }
    DosageLimitCheck(document.getElementById("id_qty_value_" + i), i);
}
function submitXML(qryString, xmlStr) {
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
    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionIvRxWithAdtValidation.jsp?bean_id=" + qryString, false);
    xmlHttpObj.send(xmlDoc);
    return true;
}
/* Banner Indicator Starts */
function DosageLimitCheck(obj, i) {
    if (obj.value == "" || parseInt(obj.value) == 0)
        return false;
    var drug_frmobj = document.formIVPrescriptionDetails;
    var header_form = document.PharmBaseForm;
    var mode = drug_frmobj.mode.value;
    var external_prod_id = "";
    if (drug_frmobj.external_product_id != undefined) {
        external_prod_id = drug_frmobj.external_product_id.value;
    }
    var drug_db_dosechk_yn = drug_frmobj.drug_db_dosecheck_yn.value;
    var drug_db_interface_yn = drug_frmobj.drug_db_interface_yn.value;
    if (drug_db_interface_yn == "Y") {
        if ((external_prod_id != '') && (drug_db_dosechk_yn == "Y")) {
            ExternalDosageCheck(mode, 'presc');
            return;
        }
    }
    var bean_id = drug_frmobj.bean_id_IVD.value;
    var bean_name = drug_frmobj.bean_id_IVD.value;
    var patient_id = header_form.patient_id.value;
    var drug_code = document.getElementById("drug_code" + i).value;
    var srl_no = document.getElementById("SRL_NO_" + i).value;
    var qty_value = document.getElementById("id_qty_value_" + i).value;
    var dosage_type = $("#ivrxWithAddDosageBy_" + i).data("kendoDropDownList").value();
    var repeat_value = '1';
    var xmlStr = "<root><SEARCH ";
    xmlStr += "patient_id =\"" + patient_id + "\" ";
    xmlStr += "drug_code =\"" + drug_code + "\" ";
    xmlStr += "srl_no =\"" + srl_no + "\" ";
    xmlStr += "repeat_value =\"" + repeat_value + "\" ";
    xmlStr += "qty_value =\"" + qty_value + "\" ";
    xmlStr += "dosage_type =\"" + dosage_type + "\" ";
    xmlStr += " /></root>"; 
    var qryString = bean_id + "&validate=DosageLimitCheck&bean_name=" + bean_name;
    submitXML(qryString, xmlStr);
}

function enableDosageLimit(limit_ind, daily_dose, unit_dose, mono_graph, min_daily_dose, min_unit_dose, srl_no) {
    var i = parseInt(srl_no);
    i--;
    var drug_frmobj = document.formIVPrescriptionDrugDetails;
    document.getElementById("LIMIT_IND_" + i).value = limit_ind;
    document.getElementById("DAILY_DOSE_" + i).value = daily_dose;
    document.getElementById("UNIT_DOSE_" + i).value = unit_dose;
    document.getElementById("MONO_GRAPH_" + i).value = unescape(mono_graph);
    document.getElementById("MIN_DAILY_DOSE_" + i).value = min_daily_dose;
    document.getElementById("MIN_UNIT_DOSE_" + i).value = min_unit_dose;
    $("#span_beyondDoseLimit_" + i).attr("style", "display:inline-block");
    $("#ivrxBeyondDosageOvverride_" + i).attr("style", "display:table");
}

function disableDosageLimit(srl_no) {
    try {
        var i = parseInt(srl_no);
        i--;
        var drug_frmobj = document.formIVPrescriptionDrugDetails;
        var current_rx = $("#CURRENT_RX_" + i).value;
        var allergy_yn = $("#ALLERGY_YN_" + i).value;
        $("#LIMIT_IND_" + i).value = "Y";
        if (current_rx == "N" && allergy_yn == "N") {
            $("#DAILY_DOSE_" + i).value = "";
            $("#UNIT_DOSE_" + i).value = "";
            $("#MONO_GRAPH_" + i).value = "";
            $("#MIN_DAILY_DOSE_" + i).value = "";
            $("#MIN_UNIT_DOSE_" + i).value = "";
            $("#span_beyondDoseLimit_" + i).attr("style", "display:none");
            $("#ivrxBeyondDosageOvverride_" + i).attr("style", "display:none");
        }
    } catch (e) {}
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

function resetInfuse(obj) {
    var formobj = document.formIVPrescriptionDetails;
    var header_form = document.PharmBaseForm;
    var start_date_chk = formobj.ivrxWithAddAdminStartDate.value;
    var locale = "en";
    if (start_date_chk != "") {
        var back_date = header_form.back_date.value;
        var future_date = header_form.future_date.value;
        if (validDate(start_date_chk, "DMYHM", locale)) {
            if (future_date != null && future_date != 'null' && future_date != "0") {
                if (!isBefore(start_date_chk, future_date, "DMYHM", locale)) {
				 showToastMsg("Current start date does not satisfy the parameter range");
                  //obj.focus();
                    return false;
                }
            }
            if (back_date != null && back_date != 'null' && back_date != "0") {
                if (!isAfter(start_date_chk, back_date, "DMYHM", locale)) {
				 showToastMsg("Current start date does not satisfy the parameter range");
                    //obj.focus();
                    return false;
                }
            }
        } else {
		 showToastMsg("Invalid date time format");
           return false;
        }
    } else {
	 showToastMsg("Start date cannot be blank");
      return false;
    }
    var durn_value = formobj.ivrxDosageBy;
    formobj.ivrxWithAddAdminAdminEndDate = "";
    chkDuration();
}

/* Banner Indicator Ends */
function getHrsMinStr(HMvalue, HMunit) {
    hrs = Math.floor(HMvalue);
    HMvalue = HMvalue * 60;
    min = HMvalue % 60;
    return ('[' + Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]');
}

function setEndDate(end_date, obj) {
    obj = eval(obj);
    obj.value = end_date;
	//if(END_DATES==""|| END_DATES==undefined ){
    endDatepicker.value(end_date);
	//}
}

function chkDuration() {
    var formobj = document.formIVPrescriptionDetails;
    var lstInfusionRateDurnUnit = formobj.infuse_rate_unit.value;
    var total_hr = formobj.infuse_rate.value;
    var InfHr = formobj.INFUSION_PERIOD_VALUE.value;
    var InfMi = formobj.INFUSION_PERIOD_VALUE_MIN.value;
    var durn = formobj.infuse_rate.value;
    var max_durn = formobj.max_duration.value;
    var repeat_durn = formobj.ivrxDosageBy.value;
    InfMi == "" ? "0" : InfMi;
    InfHr == "" ? "0" : InfHr;
    InfHr = parseFloat(InfHr) * 60;
    durn = parseFloat(total_hr) * 60;
    var tot_inf = parseFloat(InfHr) + parseFloat(InfMi);
    var durn_value; 
        durn_value = repeat_durn;
        var durn_unit = "H";
    var bean_id = formobj.bean_id_IVD.value;
    var bean_name = formobj.bean_name_IVD.value;
    var startDateVal = formobj.ivrxWithAddAdminStartDate.value;
    var fldString = "start_date=\"" + startDateVal + "\" ";
    fldString += " durn_value=\"" + durn_value + "\" ";
    fldString += " durn_unit=\"" + durn_unit + "\" ";
    var qryString = bean_id + "&validate=POPULATEENDDATE&bean_name=" + bean_name;
    var xmlStr = formXMLString(formobj, fldString);
    submitXML(qryString, xmlStr);
}

function changeStartDate() {
    var formobj = document.formIVPrescriptionDetails;
    var startDate = formobj.ivrxWithAddAdminStartDate.value;
    var futureDate = formobj.FUTURE_DATE.value;
    var locale = formobj.locale.value;
    if (futureDate != null && futureDate != 'null' && futureDate != "0" && futureDate != "") { 
        if (isBefore(startDate, futureDate, "DMYHM", locale)) {
            formobj.start_date_fluid.value = startDate;
            chkDuration();
        } else {
		 showToastMsg("Current start date does not satisfy the parameter range");
            return false;
        }
    }
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
	 showToastMsg("System error initializing XMLHttpRequest!");
         return;
    } else return request;
}
function TrimStr(sInString) {
    sInString = sInString.replace(/^\s+/g, ""); // strip leading
    return sInString.replace(/\s+$/g, ""); // strip trailing
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
function setInfuseOverValue() {
    var formobj = document.formIVPrescriptionDetails;
    if (formobj.infuse_rate.value != "" && formobj.volume.value != "") {
        var volume = parseFloat(formobj.volume.value); 
		var infusion_value = formobj.INFUSION_VALUE_WITHOUT_ROUND.value;
        var unit = formobj.infuse_rate_unit.value;
        if (infusion_value != "" && parseFloat(infusion_value) != 0) {
            if (unit == "H") {
                infusion_value = parseFloat(volume) * 60 / parseFloat(infusion_value);
            } else {
                infusion_value = parseFloat(volume) / parseFloat(infusion_value);
            }
            infusion_value = infusion_value / 60;
            infusion_value = Math.round(infusion_value * 100) / 100;
            var HrsMinStr = getHrsMinStr(infusion_value, formobj.infuse_rate_unit.value);
            formobj.INFUSION_PERIOD_VALUE.value = infusion_value;
            formobj.infusion_over_insert_value.value = infusion_value;            
            var hrs = HrsMinStr.substring(1, HrsMinStr.indexOf("H") - 1);
            var min = HrsMinStr.substring(HrsMinStr.indexOf("H") + 4, HrsMinStr.indexOf("M") - 1);
            formobj.INFUSION_PERIOD_VALUE.value = Math.floor(hrs);
            formobj.INFUSION_PERIOD_VALUE_MIN.value = Math.round(min);
			$("#infuse_over_str").text('[' + Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]');
            if (parseFloat(infusion_value) > parseFloat(24 * 60)) {
			 showToastMsg("Infuse over cannot be greater than 24 Hours");
                //formobj.INFUSION_PERIOD_VALUE.focus();
                return false;
            }
        }
		setInfuseRateValue("ADMIN");
    }

}

function getHrsMinStr(HMvalue, HMunit) {
    hrs = Math.floor(HMvalue);
    HMvalue = HMvalue * 60;
    min = HMvalue % 60;
    return ('[' + Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]');
}

function resetFluidDetails(STRENGTH_PER_VALUE_PRES_UOM,infuse_over_hrs,infuse_over_mis, BUILD_MAR_YN, PRES_QTY_UOM, start_date_fluid, end_date_fluid, trade_code) {
    var formobj = document.formIVPrescriptionDetails;
    formobj.volume.value = STRENGTH_PER_VALUE_PRES_UOM;
    formobj.total_volume.value = STRENGTH_PER_VALUE_PRES_UOM; 
	formobj.INFUSION_PERIOD_VALUE.value = infuse_over_hrs;
	formobj.INFUSION_PERIOD_VALUE_MIN.value = infuse_over_mis;
}
function setInfuseRateValue(callFrom) {
    var admnFrmObj = document.formIVPrescriptionDetails;
    var fluidFrmObj = document.formIVPrescriptionDetails;
    var volume = fluidFrmObj.volume.value;
    var infusion_period_value = admnFrmObj.INFUSION_PERIOD_VALUE.value;
    var infusion_period_value_min = admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;
	if (infusion_period_value_min != null && infusion_period_value_min > 59) {
            showToastMsg("Minute entered is invalid.It sholud be between 0 and 59"); 
            return;			
        }
	if(infusion_period_value_min=="")infusion_period_value_min=0;
    infusion_period_value_min = parseFloat(infusion_period_value_min);
    var InfuseOverInMin = getInfuseOverInMin(infusion_period_value, infusion_period_value_min);
    var InfuseOverInHr = parseFloat(InfuseOverInMin / 60);
    InfuseOverInHr = Math.round(InfuseOverInHr * 100) / 100;
	var valueinmin = parseFloat(InfuseOverInMin % 60);
    if (volume == "" || volume == 0) {
	 showToastMsg("Fluid volume cannot be blank or Zero");
        //fluidFrmObj.stock_value.focus();
        return false;
    }else if (InfuseOverInMin == 0) {
	 showToastMsg("Infuse Over cannot be blank or zero");       
        return false;
    }else{
        if (admnFrmObj.ivrxWithAddInfusionRateUnit.value == "H")
            var infusion_value = (volume) * 60 / (InfuseOverInMin);
        else
            var infusion_value = (volume) / (InfuseOverInMin);
		admnFrmObj.INFUSION_VALUE_WITHOUT_ROUND.value = infusion_value;
        admnFrmObj.infusion_over_insert_value.value = InfuseOverInHr;
        infusion_value = Math.round(infusion_value * 100) / 100;
        admnFrmObj.infuse_rate.value = infusion_value;
		admnFrmObj.INFUSION_PERIOD_VALUE.value = Math.floor(InfuseOverInHr);
		admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value = Math.round(valueinmin);
        var str = getHrsMinStr(InfuseOverInHr, admnFrmObj.ivrxWithAddInfusionRateUnit.value);
        $("#infuse_over_str").text(str);	
    }
    if (admnFrmObj.iv_calc_infuse_by.value == 'I') { 
        var bean_id = admnFrmObj.bean_id_IVD.value;
        var bean_name = admnFrmObj.bean_name_IVD.value;
        var start_date = admnFrmObj.ivrxWithAddAdminStartDate.value;
        var durnHrs = admnFrmObj.INFUSION_PERIOD_VALUE.value;
        var durnMins = admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;
        if (trimString(durnHrs) == "")
            durnHrs = '0';
        if (trimString(durnMins) == "")
            durnMins = '0';
        var durn_unit = "M";
        var DURN_VALUE = (parseInt(durnHrs) * 60) + parseInt(durnMins);
        var mode = '';
        if (callFrom != 'ADMIN')
            mode = 'IV_CALC';
        if (callFrom == 'LOAD')
            mode = 'IV_CALC_LOAD';
    } 
}
function displayADRimage() {
}
function enableFields() {
}
function changeFluid(obj) {
    var frmObj = document.formIVPrescriptionDetails;
    var frmAdminObj = document.formIVPrescriptionDetails;
    var fluid_code = $("#fluidNameIvWithAddValues").data("kendoDropDownList").value();
    var trade_code = "";
    var header_form = document.PharmBaseForm;
    if (trade_code == undefined)
        trade_code = "";
    var bean_id = frmAdminObj.bean_id_IVD.value;
    var bean_name = frmAdminObj.bean_name_IVD.value;
    var priority = header_form.priority.value;
    var location_type = header_form.location_type.value;
    var location_code = header_form.location_code.value;
    var take_home_medication = header_form.take_home_medication.value;
    var iv_prep_yn = "";
    iv_prep_yn = "1";
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=FLUIDDETAILS&drug_code=" + fluid_code + "&patient_id=" + frmObj.patient_id.value + "&encounter_id=" + frmObj.encounter_id.value + "&lang_id=" + frmObj.language_id.value + "&trade_code=" + trade_code + "&location_type=" + location_type + "&location_code=" + location_code + "&take_home_medication=" + take_home_medication + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn;
    submitXML(qryString, "");
}

function setInfuseValue(infuse, call_mode) {
    var frmObj = document.formIVPrescriptionDetails;
    var val = infuse.split("::");
    var frmAdminObj = document.formIVPrescriptionDetails;
	frmAdminObj.INFUSION_VALUE_WITHOUT_ROUND.value = val[0];
	frmAdminObj.infuse_rate.value = val[0];
    if (val[0] != "") {	
		if (val[1] == "null")
            HrsMinStr = getHrsMinStr(val[0], "H");
        else
            HrsMinStr = getHrsMinStr(val[0], val[1]);
		hrs = HrsMinStr.substring(1, HrsMinStr.indexOf("H") - 1);
        min = HrsMinStr.substring(HrsMinStr.indexOf("H") + 4, HrsMinStr.indexOf("M") - 1);		
		frmAdminObj.INFUSION_PERIOD_VALUE.value = hrs;
		frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value = min;		
        if (parseFloat(min) > 0)
			frmAdminObj.infusion_over_insert_value.value = hrs + "." + Math.ceil(min / 60);
		else
			frmAdminObj.infusion_over_insert_value.value = hrs + ".0";
		$("#infuse_over_str").text(getHrsMinStr(val[0], 'H'));		
		if(val[1] == "null")
			$("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value("H");
		else
			$("#ivrxWithAddInfusionRateUnit").data("kendoDropDownList").value(val[1]);		
		frmAdminObj.INFUSION_PERIOD_UOM.value="H";
		if(val[1] == "M"){
			frmAdminObj.INFUSION_UOM.value="M";
		}
		else{
			frmAdminObj.INFUSION_UOM.value="H";
		} 
    }
    setInfuseRateValue("LOAD");
    setInfuseOverValue();
}

function calInfusionRate() {    
    var frmDrugObj = document.formIVPrescriptionDetails;
    var frmAdminObj = document.PharmBaseForm;
    var frmObj = document.formIVPrescriptionDetails;
    var volume = frmObj.volume.value;
    var infusion_period_value = frmObj.INFUSION_PERIOD_VALUE.value;
    var infusion_period_value_min = frmObj.INFUSION_PERIOD_VALUE_MIN.value;
    if (volume != "" && parseFloat(volume) != 0 && ((infusion_period_value != "" && parseFloat(infusion_period_value) != 0) || (infusion_period_value_min != "" && parseFloat(infusion_period_value_min) != 0))) {
        var InfuseOverInMin = getInfuseOverInMin(infusion_period_value, infusion_period_value_min);
        var InfuseOverInHr = parseFloat(InfuseOverInMin / 60);
        InfuseOverInHr = Math.round(InfuseOverInHr * 100) / 100;
        if (frmObj.ivrxWithAddInfusionRateUnit.value == "H")
            var infusion_value = (volume) * 60 / (InfuseOverInMin); 
        else
            var infusion_value = (volume) / (InfuseOverInMin);
        frmObj.infusion_over_insert_value.value = InfuseOverInHr;
        infusion_value = Math.round(infusion_value * 100) / 100;
        frmObj.infuse_rate.value = infusion_value;
        var str = getHrsMinStr(InfuseOverInHr, frmObj.ivrxWithAddInfusionRateUnit.value);
        $("#infuse_over_str").text(str);
        var inf_over = frmObj.INFUSION_PERIOD_VALUE.value;
        var infusion_time = frmObj.INFUSION_PERIOD_VALUE_MIN.value;
        var dur_val = frmObj.ivrxDosageBy.value;
        if (parseInt(frmObj.INFUSION_PERIOD_VALUE_MIN.value) > 59) {
		 showToastMsg("APP-PH329 Minute entered is invalid .It should be between 0 and 59");          
        } else if ((parseFloat(InfuseOverInMin)) > (parseInt(dur_val))) {
		 showToastMsg("APP-PH013 Duration cannot be less than Infuse over");
            }
		}
    populateEndDate();
}
function freqChange(obj, flag, formObj) {
    var freq_code = $("#fluidNameIvWithAddValues").data("kendoDropDownList").value();
    var f_header = document.PharmBaseForm;
    var s_header = document.formIVPrescriptionDetails;
    var patient_class = f_header.patient_class.value;
    if (patient_class == "IP") {
        if (f_header.take_home_medication.value == "Y")
            patient_class = "OP";
    }

    if (s_header != "" && s_header != undefined) {
        var bean_id = s_header.bean_id.value;
        var bean_name = s_header.bean_name.value;
        var drug_code = s_header.drug_code0.value;
        s_header = "onload";
    } else {
        if (document.formIVPrescriptionAdminDetail != undefined) {
            s_header = "";
            var bean_id = s_header.bean_id.value;
            var bean_name = s_header.bean_name.value;
            var drug_code = s_header.drug_code0.value;
        } else {
            var bean_id = s_header.bean_id.value;
            var bean_name = s_header.bean_name.value;
            var drug_code = s_header.drug_code0.value;
        }
    }
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateDurationDesc&drug_code=" + drug_code + "&freq_code=" + freq_code + "&formObj=" + s_header;
    submitXML(qryString, "");
}

function setOrderType(orderTypeCode) 
{
}
function displayDispLocn() {
}
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc, disp_uom_desc, fluid_stock_uom_desc) { 
    var frmObj = document.formIVPrescriptionDetails;
	if(!stock_value)
		stock_value = "";
    if (stock_uom_desc != "")
        frmObj.volume.value = stock_value;
    else
        frmObj.volume.value = stock_value;
    $("#stock_display").text(stock_uom_desc);
    $("#infusion_uom_display").text(stock_uom_desc);
    frmObj.STOCK_UOM_CODE.value = stock_uom_code;
}

function setOrderType(orderTypeCode) {
    if (document.formIVPrescriptionDetails != undefined) {        
        document.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
    } else {        
        if (parent.parent.f_iv_fluid != undefined)
            parent.parent.f_iv_fluid.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
        else
            parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
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
async function DrugSearchForIV(searchBasedOn, target, order_type_code, drug_codes, bean_id, res_by_service, service_code, patient_class, priority, drugorfluid, iv_medication_type, discharge_yn, source_type, source_code, patient_id, encounter_id, date_of_birth, gender, iv_prep_yn) { 
    var default_text = "";
    returnVal = new String();
    var dialogHeight = "32";
    var dialogWidth = "65";
    var status = "no";
    var dialogUrl = "../../ePH/jsp/DrugNameCommonLookup.jsp?discharge_yn=" + discharge_yn + "&select=" + searchBasedOn + "&default_text=" + escape(default_text) + "&order_type_code=" + order_type_code + "&drug_codes=" + drug_codes + "&identity=MedicationOrder&modalYN=Y&bean_id=" + bean_id + "&res_by_service=" + res_by_service + "&service_code=" + service_code + "&patient_class=" + patient_class + "&priority=" + priority + "&drugorfluid=" + drugorfluid + "&iv_medication_type=" + iv_medication_type + "&source_type=" + source_type + "&source_code=" + source_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&iv_prep_yn=" + iv_prep_yn;
    var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
    returnVal = await window.showModalDialog(dialogUrl, "", dialogFeatures);
    if (returnVal == null || returnVal == "" || returnVal == undefined) {
        return "";
    } else {
        return returnVal.split(":::");
    }
}
function searchIVDrugs(searchBasedOn, obj) {
    var frmObj = document.formIVPrescriptionDetails;
    var headerFrm = document.PharmBaseForm;
    var discharge_yn = headerFrm.take_home_medication.value;
    var priority = headerFrm.priority.value;
    var encounter_id = headerFrm.encounter_id.value;
    var patient_id = headerFrm.patient_id.value;
    var act_patient_class = headerFrm.actual_patient_class.value;
    var source_code = headerFrm.source_code.value;
    var source_type = headerFrm.source_type.value;
    var date_of_birth = headerFrm.date_of_birth.value;
    var gender = headerFrm.gender.value;
    var resp_id = headerFrm.resp_id.value;
    var pract_id = headerFrm.pract_id.value;    
    var patient_class = headerFrm.patient_class.value;
    var starting_date = headerFrm.ref_sys_date.value;
    frmObj.patient_class.value = patient_class;
    var drugCodes = frmObj.drugCodes.value;
    var iv_prep_yn = "";
    if (frmObj.admixture.checked == true)
        iv_prep_yn = "2";
    else
        iv_prep_yn = "1";
    var index = 0;
    Trade_Codes = "";
    Trade_Names = "";
    frmObj.drugCodes.value = drugCodes;
    var bean_id = frmObj.bean_id_IVD.value;
    var bean_name = frmObj.bean_name_IVD.value;
    var location_type = frmObj.location_type.value;
    var location_code = frmObj.location_code.value;
    var xmlStr = "<root><SEARCH act_patient_class=\"" + patient_class + "\" /></root>"; 
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=DRUGCODES&drugCodes=" + drugCodes + "&starting_date=" + starting_date + "&Trade_Codes=" + Trade_Codes + "&Trade_Names=" + Trade_Names + "&location_type=" + location_type + "&location_code=" + location_code + "&take_home_medication=" + discharge_yn + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn + "&selected_drug_codes=" + drugCodes + "&resp_id=" + resp_id + "&pract_id=" + pract_id;
    submitXML(qryString, xmlStr);
}
function populateEndDateAdmin(callFrom) {
    var frmObj = document.formIVPrescriptionDetails;
    var bean_id = frmObj.bean_id_IVD.value;
    var bean_name = frmObj.bean_name_IVD.value;
    var start_date = frmObj.start_date_fluid.value;
    var durnHrs = frmObj.INFUSION_PERIOD_VALUE.value;
    var durnMins = frmObj.INFUSION_PERIOD_VALUE_MIN.value;
    if (trimString(durnHrs) == "")
        durnHrs = '0';
    if (trimString(durnMins) == "")
        durnMins = '0';
    var durn_unit = "M";
    var DURN_VALUE = (parseInt(durnHrs) * 60) + parseInt(durnMins);
    var mode = '';
    if (callFrom != 'ADMIN')
        mode = 'IV_CALC';
    if (callFrom == 'LOAD')
        mode = 'IV_CALC_LOAD';
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=POPULATEENDDATEADMIN&start_date=" + start_date + "&durn_value=" + DURN_VALUE + "&durn_unit=" + durn_unit + "&mode=" + mode;
    submitXML(qryString, "");
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
function mandateRemarks(){
	
}
function allowValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;//
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}
    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');			
            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    $("#body_weight_dose").val(fld.value);
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
					$("#body_weight_dose").val(fld.value);
                    return false;
                }
            }
        }
    }
	 var strCheck = '.0123456789-';
if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';
    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;
    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }
    if (pointCount>0 && whichCode == 46) return false;
    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

/*orientation change*/
    if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',orientationChangeIVRXAdd, false);
	}
    function orientationChangeIVRXAdd() {
    	setTimeout(function() {
    	    if (Math.abs(window.orientation) === 90) {
       	 	 pharmIvRxDetailsScroller.refresh();
    	    } else {
       	 	 pharmIvRxDetailsScroller.refresh();
    	    } 	 
        }, 1500);
    }
