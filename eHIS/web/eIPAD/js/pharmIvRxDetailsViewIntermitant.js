var dosageUnit = $("#ivInterDosageUnit").kendoDropDownList({
});
var dosageUnitDetails = $("#ivInterDosageUnitValues").kendoDropDownList({
    change: calculateDosage_By_BSA_or_Weight
});
var frequencyList = $("#frequencyList").kendoDropDownList({

        valuePrimitive: true,
        change: freqChange,

});
var ivInterStartDate = $("#ivInterStartDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm" //24 hours format
});
var ivInterEndDate = $("#ivInterEndDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm" //24 hours format
});
$("#ivInterEndDate").attr("readonly", true);
var startDatepicker = $("#ivInterStartDate").data("kendoDateTimePicker");
startDatepicker.value(document.formIVPBDrugDetails.start_date.value);

$('#body_weight_dose').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});

$('#infusion_over_hrs').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('#infusion_over_mins').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('#INFUSION_VALUE').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
$('#Duration_for_repeat').on('input', function(event) {
    this.value = this.value.replace(/[^0-9.]/g, '');
});
	$('#strength_weight_dose').on('input', function (event) { 
	    this.value = this.value.replace(/[^0-9.]/g, '');
	});	
		
	$('#str_qty_units').on('input', function (event) { 
	    this.value = this.value.replace(/[^0-9.]/g, '');
	});
function CheckNum(obj) {
    $(obj).on('input', function(event) {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
}

function DfltVehicle (dft)
{

$("#ivIntermitantFluidNameValues").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: fulidArray,
        change: changeVehicle,
    });
	
	  $("#ivIntermitantFluidNameValues").data("kendoDropDownList").value(dft);
	
}


function allowValidNumber(fld, e, maxInt, deci) 
{
    var count = fld.value.length; //
    var whichCode = (window.Event) ? e.which : e.keyCode; //ok

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
                    $("#body_weight_dose").val(fld.value);
                }
            }
        } else if (count > maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');            
            if ((objectValue.charAt(maxInt)) != '.') {
                if (dotOccurance == -1 && parseInt(deci) > 0) {
                    fld.value = objectValue.substring(0, maxInt) + ".";
                    $("#body_weight_dose").val(fld.value);
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

var qualityArray = [];
var fulidArray = [];
var freqArray = [];
var drunArray = [];


function commonObj() {
    this.code = "";
    this.desp = "";
}
function okClickDialog() {
    $("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
}

function cancelClickDialog() {
    $("#confirmMsg").hide();
}
function closeRxDetailsView() {
    $("#confirmMsg").show();
}

function clearDatastr(doc, unit) { 
    qualityArray = [];
    var ddl = $("#ivstrenghtRateUnit").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]);
}
function ivSternght(){


var s_header = document.PharmBaseForm;
s_header.rx_qty_by_pres_base_uom_yn.value="Y";

}
function addData(code, desp, doc) {
    var obj = new commonObj();
    obj.code = code;
    obj.desp = desp;
    qualityArray.push(obj);
    var dosageUOMDpList = $("#ivstrenghtRateUnit").data("kendoDropDownList");
    if (dosageUOMDpList) {
        $("#ivstrenghtRateUnit").getKendoDropDownList().dataSource.insert({
            value: code,
            text: desp
        });
    }
}
function setDefaultData(def, doc, unit) { 
    var dosageUOMDpList = $("#ivstrenghtRateUnit").data("kendoDropDownList");
    if (dosageUOMDpList) {
        $("#ivstrenghtRateUnit").data("kendoDropDownList").value(def);
    }
}
function setterClacby(value) {
    $("#calcBy").val(value);
}
function getterClacby() {
    var calBY = $("#calcBy").val();
    return calBY;
}
function hideDosageBY() {
    var dropDown = $("#ivInterDosageBy").data("kendoDropDownList");
    dropDown.enable(false);
}
function showDosageBY() {
    var dropDown = $("#ivInterDosageBy").data("kendoDropDownList");
    dropDown.enable(true);
}
function hideRelatedKendo(ids) {
    var dropDown = $("#" + ids).data("kendoDropDownList");
    dropDown.enable(false);
}
function hideRelatedDateKendo() {
    var dropDown = $("#ivInterEndDate").data("kendoDateTimePicker");
    dropDown.enable(false);
}
function displayDispLocn(ord_disp_location, time_flag) 
{
}
function setBackFutureDate(back_date, future_date) {
}
function clearFrequencyList() {
    freqArray = [];
    $("#frequencyList").kendoDropDownList({
        valuePrimitive: true,
        change: freqChange,
    });
    var ddl = $("#frequencyList").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]);   
}
function addFrequencyList(code, desc, default_val) {
    var obj = new commonObj();
    obj.code = code;
    obj.desp = desc;
    freqArray.push(obj);
}
function dfltFreq(sec) 
{
    $("#frequencyList").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: freqArray,
        change: freqChange,
    });
    $("#frequencyList").data("kendoDropDownList").value(sec);
}
function clearData(obj, mode) 
{
    fulidArray = [];
    $("#ivIntermitantFluidNameValues").kendoDropDownList({
        valuePrimitive: true,
        change: changeVehicle,

    });
    var ddl = $("#ivIntermitantFluidNameValues").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]);
}

function clearDfltVehicle() {
}
function assignDfltVehicle(fluid_code, dflt_drug_desc, volume_of_drug, default_yn, trade_code, trade_name, fluid_adr_count) 
{
    var res = decodeURIComponent(dflt_drug_desc);  
    var obj = new commonObj();
    obj.code = fluid_code;
    obj.desp = res;
    fulidArray.push(obj);
	}


function getHrsMinStr(HMvalue, HMunit) {    
    hrs = Math.floor(HMvalue);
    HMvalue = HMvalue * 60;    
    min = HMvalue % 60;
    return ('[' + Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]');
}
function freqChange(obj, flag, formObj) {
    var freq_code = $("#frequencyList").data("kendoDropDownList").value();
    var f_header = document.PharmBaseForm;
    var s_header = document.formIVPBDrugDetails;
    var patient_class = f_header.patient_class.value;
    if (patient_class == "IP") {
        if (f_header.take_home_medication.value == "Y")
            patient_class = "OP";
    }
    if (s_header != "" && s_header != undefined) {
        var bean_id = s_header.bean_id.value;
        var bean_name = s_header.bean_name.value;
        var drug_code = s_header.DRUG_CODE.value;
        s_header = "onload";
    } else {
        if (document.formIVPrescriptionAdminDetail != undefined) {
            s_header = "";
            var bean_id = s_header.bean_id.value;
            var bean_name = s_header.bean_name.value;
            var drug_code = s_header.DRUG_CODE.value;
        } else {
            var bean_id = s_header.bean_id.value;
            var bean_name = s_header.bean_name.value;
            var drug_code = s_header.DRUG_CODE.value;
        }
    }
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateDurationDesc&drug_code=" + drug_code + "&freq_code=" + freq_code + "&formObj=" + s_header;
    submitXML(qryString, "");
    setSchedule();
}
function overrideImg() {
}

function populateDurnDesc(repeat_durn_type, formObj) {    
    var fObj = document.formIVPBDrugDetails;
    var bean_id = fObj.bean_id.value;
    var bean_name = fObj.bean_name.value;
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateDurnDesc&repeat_durn_type=" + repeat_durn_type + "&formObj=" + formObj;
    submitXML(qryString, "");
}
function addDurnDescList(code, desc, formObj) 
{
    var obj = new commonObj();
    obj.code = code;
    obj.desp = desc;
    drunArray.push(obj);
}
function removeDurnDescList(formObj) 
{    var ddl = $("#ivInterinfusionRateUnit").data("kendoDropDownList");
		if (ddl)
        ddl.dataSource.data([]);
}
function assignEndDate(end_date) {
    var frmAdminObj = document.formIVPBDrugDetails;
    frmAdminObj.ivInterEndDate.value = end_date;    
}
function populateEndDate(formObj) 
{
    var frmObj_pres_dtl = document.formIVPBDrugDetails;
    var freq_nature = $("#frequencyList").data("kendoDropDownList").value();
    var start_date = frmObj_pres_dtl.ivInterStartDate.value;
    var durn_value = frmObj_pres_dtl.Duration_for_repeat.value;
    var durn_desc = $("#ivInterinfusionRateUnit").data("kendoDropDownList").value();
    var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
    repeat_durn_type = durn_desc;
    if (durn_value != '') {
        var bean_id = frmObj_pres_dtl.bean_id.value;
        var bean_name = frmObj_pres_dtl.bean_name.value;
        var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateEndDate&freq_nature=" + freq_nature + "&start_date=" + start_date + "&durn_value=" + durn_value + "&repeat_durn_type=" + repeat_durn_type;
        submitXML(qryString, "");
    }
}


function assignDurnDesc(repeat_value, repeat_durn_type, freq_nature, interval_value, durn_desc, freq_value, schedule_yn, formObj, durn_value, durn_type) 
{
    var fObj = document.formIVPBDrugDetails;
    if (freq_value == "null" || freq_value == null)
        freq_value == "0";
    if (repeat_durn_type == "L") {        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("L");
        removeDurnDescList(formObj);
        populateDurnDesc(repeat_durn_type, formObj);        
    }
    if (repeat_durn_type == "W") {        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("W");
        removeDurnDescList(formObj);
        populateDurnDesc(repeat_durn_type, formObj);        
    }
    if (repeat_durn_type == "D") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("D");     
        removeDurnDescList(formObj);
        populateDurnDesc(repeat_durn_type, formObj);        
    }
    if (repeat_durn_type == "H") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("D");        
        var durn_value = null;
        durn_value = fObj.Duration_for_repeat.value;
        if (durn_value == null || durn_value == "")
            fObj.Duration_for_repeat.value = "1";       

        fObj.calcualted_durn_value.value = "1";
        removeDurnDescList(formObj);
        populateDurnDesc(repeat_durn_type, formObj);

    }
    if (repeat_durn_type == "M") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("D");
        var durn_value = null;
        durn_value = fObj.Duration_for_repeat.value;
        if (durn_value == null || durn_value == "")
            fObj.Duration_for_repeat.value = "1";
        fObj.calcualted_durn_value.value = "1";
        removeDurnDescList(formObj);
        populateDurnDesc(repeat_durn_type, formObj);
    }

    if (freq_nature == 'O') {
        if (fObj.in_durn_desc != null) {
            fObj.in_durn_desc.value = "";
            fObj.in_durn_value.value = "";
        }        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("D");
        fObj.Duration_for_repeat.value = "1";
        fObj.Duration_for_repeat.disabled = true;        
        $('#ivInterEndDate').data('kendoDatePicker').enable(false);
        fObj.calcualted_durn_value.value = "1";
        interval_value = "1";
        repeat_value = "1";
    }
    if (durn_value != undefined && durn_type != undefined) {
        fObj.durn_unit.value = durn_type;
        fObj.DURN_VALUE.value = durn_value;
    }
    fObj.interval_value.value = interval_value;
    fObj.repeat_value.value = repeat_value;
    fObj.freq_nature.value = freq_nature;
    fObj.repeat_durn_type.value = repeat_durn_type;
    fObj.calcualted_durn_value.value = repeat_value;
    fObj.scheduled_yn.value = schedule_yn;
    populateEndDate(formObj);
}

function dfltDurnDesc(repeat_durn_type, freq_nature, formObj) {
    var fObj = document.formIVPBDrugDetails;
    $("#ivInterinfusionRateUnit").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: drunArray,
        change: validateAllDates,
    });
    if (repeat_durn_type == "L") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("L");
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);       
    }
    if (repeat_durn_type == "W") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("W");
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);        
    }
    if (repeat_durn_type == "D") {        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("D");
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);        
    }
    if (repeat_durn_type == "H") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("H");        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);
        fObj.calcualted_durn_value.value = "1";
    }
    if (repeat_durn_type == "M") {
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").value("M");        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);        
    }

    if (freq_nature != "P" || freq_nature != 'O') {        
        $("#ivInterinfusionRateUnit").data("kendoDropDownList").enable(true);
    }
    drunArray = [];
}
function validateAllDates() {
    populateEndDate();
}
function calInfuseOver(call_mode) { 
    var frmDrugObj = document.formIVPBDrugDetails;
    var frmAdminObj = document.PharmBaseForm;
    if (frmDrugObj.iv_fluid_yn.value == "Y") { 
        setCalculatedQty(frmDrugObj.str_qty_units, 'frmCalInfuseOver');
    }
    var volume = frmDrugObj.volume_value.value;
    var infusion_value = frmDrugObj.INFUSION_VALUE.value;

    var infusion_over; //infusion_over added for SRR20056-SCF-7374 Incident No. 27415 to avoid the confusion with infusion_value
    if (volume != "" && volume != "0" && frmDrugObj.INFUSION_VALUE.value != "" && parseFloat(frmDrugObj.INFUSION_VALUE.value) > 0) {

        if (parseInt(frmDrugObj.volume_value.value) < parseInt(frmDrugObj.INFUSION_VALUE.value)) {     
            showToastMsg("Infusion rate cannot be greater than volume");
        }

        var unit = frmDrugObj.infusionRateUnit.value;        
        if (call_mode != undefined && call_mode == "DRUGLOAD") {
            infusion_over = frmDrugObj.infusion_over_hrs.value;
            if (unit == "H") {
                infusion_over = infusion_over * 60;
            }
        } else {
            if (unit == "H") {
                infusion_over = volume * 60 / infusion_value;
            } else {
                infusion_over = volume / infusion_value;
            }
        }
        var dur_val = frmDrugObj.Duration_for_repeat.value;
        if (frmDrugObj.ivInterinfusionRateUnit.value == "H")
            dur_val = dur_val * 60;
        if (frmDrugObj.ivInterinfusionRateUnit.value == "D")
            dur_val = dur_val * 24 * 60;
        if (frmDrugObj.ivInterinfusionRateUnit.value == "W")
            dur_val = dur_val * 7 * 24 * 60;
        if (frmDrugObj.ivInterinfusionRateUnit.value == "L")
            dur_val = dur_val * 30 * 24 * 60;
        if (frmDrugObj.ivInterinfusionRateUnit.value == "Y")
            dur_val = dur_val * 12 * 30 * 24 * 60;
       // console.log("drun valuesss:::" + dur_val);

        infusion_over = infusion_over / 60;
        infusion_over = Math.round(infusion_over * 100) / 100;
        HrsMinStr = getHrsMinStr(infusion_over, unit);
        frmDrugObj.infusion_over_insert_value.value = infusion_over;        
        $("#infuse_over_str").text(HrsMinStr);
        hrs = HrsMinStr.substring(1, HrsMinStr.indexOf("H") - 1);
        min = HrsMinStr.substring(HrsMinStr.indexOf("H") + 4, HrsMinStr.indexOf("M") - 1);
        frmDrugObj.infusion_over_hrs.value = Math.floor(hrs);
        frmDrugObj.infusion_over_mins.value = Math.round(min);
    }   
}


function setInfuseValue(infuse, call_mode) {    
    $("#ivIntermitantFluidNameValues").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: fulidArray,
        change: changeVehicle,
    });
    var frmObj = document.formIVPBDrugDetails;
    var val = infuse.split("::");
    var frmAdminObj = document.formIVPBDrugDetails;
    if (val[0] != "") {
        frmAdminObj.infusion_over_hrs.value = val[0];

        if (val[1] == "H") {            
            frmAdminObj.INFUSION_PERIOD_UOM.value = "H";            
            $("#infusionRateUnit").data("kendoDropDownList").value("H");
            $("#infuse_over_str").text(getHrsMinStr(val[0], 'H'));
        } else if (val[1] == "M") {            
            frmAdminObj.INFUSION_PERIOD_UOM.value = "M";            
            $("#infusionRateUnit").data("kendoDropDownList").value("M");
            $("#infuse_over_str").text(getHrsMinStr(val[0], 'M'));
        }
        frmAdminObj.INFUSION_UOM.value = frmAdminObj.INFUSION_PERIOD_UOM.value;
    }
    freqChange(frmAdminObj.FREQUENCY, "", frmAdminObj);
    if (val[0] != "") {     
        calInfusionRate(); 
        calInfuseOver("DRUGLOAD");
    }
}
function getInfuseOverInMin(hr, mi) {
    if (hr == "")
        hr = 0;
    if (mi == "")
        mi = 0;
    tot = parseFloat(hr * 60) + parseFloat(mi);
    return tot;
}
function calInfusionRate() {
    var frmDrugObj = document.formIVPBDrugDetails;
    var frmAdminObj = document.PharmBaseForm;
    var frmObj = document.formIVPBDrugDetails;
    var volume = frmObj.volume_value.value;
    var infusion_period_value = frmObj.infusion_over_hrs.value;
    var infusion_period_value_min = frmObj.infusion_over_mins.value;
    if (volume != "" && parseFloat(volume) != 0 && ((infusion_period_value != "" && parseFloat(infusion_period_value) != 0) || (infusion_period_value_min != "" && parseFloat(infusion_period_value_min) != 0))) {
        var InfuseOverInMin = getInfuseOverInMin(infusion_period_value, infusion_period_value_min);
        var InfuseOverInHr = parseFloat(InfuseOverInMin / 60);
        InfuseOverInHr = Math.round(InfuseOverInHr * 100) / 100;
        if (frmObj.infusionRateUnit.value == "H")
            var infusion_value = (volume) * 60 / (InfuseOverInMin); //added for SCF-7847 //var infusion_value = (volume)/(InfuseOverInHr); //commeted for SCF-7847
        else
            var infusion_value = (volume) / (InfuseOverInMin);
        frmObj.infusion_over_insert_value.value = InfuseOverInHr;
        infusion_value = Math.round(infusion_value * 100) / 100;
        frmObj.INFUSION_VALUE.value = infusion_value;
        var str = getHrsMinStr(InfuseOverInHr, frmObj.infusionRateUnit.value);
        $("#infuse_over_str").text(str);
        var inf_over = frmObj.infusion_over_hrs.value;
        var infusion_time = frmObj.infusion_over_mins.value;
        var dur_val = frmObj.Duration_for_repeat.value;

        if (frmObj.ivInterinfusionRateUnit.value == "H")
            dur_val = dur_val * 60;
        if (frmObj.ivInterinfusionRateUnit.value == "D")
            dur_val = dur_val * 24 * 60;
        if (frmObj.ivInterinfusionRateUnit.value == "W")
            dur_val = dur_val * 7 * 24 * 60;
        if (frmObj.ivInterinfusionRateUnit.value == "L")
            dur_val = dur_val * 30 * 24 * 60;
        if (frmObj.ivInterinfusionRateUnit.value == "Y")
            dur_val = dur_val * 12 * 30 * 24 * 60;        
        if (parseInt(frmObj.infusion_over_mins.value) > 59) {            
            showToastMsg(" Minute entered is invalid .It should be between 0 and 59");

        } else if ((parseFloat(InfuseOverInMin)) > (parseInt(dur_val))) {
            showToastMsg("Duration cannot be less than Infuse over");            
        }
    }    
    populateEndDate();
}
function setOrderType(orderTypeCode) { 
}
function setFluidVolume(obj) {
    if (obj.value != "0" && obj.value != "") {
        var frmAdminObj = document.formIVPBDrugDetails;
        frmAdminObj.volume_value.value = obj.value;
        frmAdminObj.STOCK_VALUE.value = obj.value;

    } else {
        showToastMsg("Fluid cannot be blank");
       // document.formIVPiggyBackVehicle.volume.focus();
    }
}
function calEndDate() {
    var frmAdminObj = document.formIVPBDrugDetails;
    var frmHeaderObj = document.PharmBaseForm;
    var durn_value = frmAdminObj.Duration_for_repeat.value;
    var start_date = frmAdminObj.ivInterStartDate.value;
    var encounter_id = frmAdminObj.encounter_ids.value;
    var patient_id = frmAdminObj.patient_ids.value;
    var bean_id = frmAdminObj.bean_id.value;
    var bean_name = frmAdminObj.bean_name.value;
    var durn_unit = "H";
    var durn_desc = frmAdminObj.ivInterinfusionRateUnit.value;
    var repeat_durn_type = frmAdminObj.repeat_durn_type.value;
    var freq_nature = frmAdminObj.frequencyList.value;
    repeat_durn_type = durn_desc;
    if (durn_value != "" && start_date != "") {
        var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateEndDate&start_date=" + start_date + "&durn_value=" + durn_value + "&durn_unit=" + durn_unit + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&repeat_durn_type=" + repeat_durn_type + "&freq_nature=" + freq_nature;
        submitXML(qryString, "");
    } else {
        frmAdminObj.ivInterEndDate.value = "";
    }
}
function assignDosageDetails(drug_code, objValue, strength, strength_uom, dosage, dosage_uom, freq_code, allergy_override, dose_override, currentrx_override, sRegRopt, drug_adr_count, pract_id, resp_id, buildMAR_yn, iv_fluid_yn, dur_val) { //iv_fluid_yn parameter added for "SRR20056-SCF-7374 IN27415"
    var frmDrugObj = document.formIVPBDrugDetails;
    var frmAdminObj = document.PharmBaseForm;
    var drugCodeFreq = "";
    frmDrugObj.Duration_for_repeat.value = dur_val;
    calEndDate();
    calInfusionRate();
}


function assignAuthorization(ord_auth_reqd_yn, auth_yn_val, ord_spl_appr_reqd_yn, approval_yn_val, ord_cosign_reqd_yn, cosign_yn_val, consent_reqd_yn) {
}

function dtlsForOverride(generic_id, generic_name, drug_name, limit_ind, allergy_yn, current_rx, drug_code, srl_no, allergy_desc, exceed_dose_desc, dup_drug_desc) {

    var frmDrugObj = document.formIVPBDrugDetails;
    frmDrugObj.generic_id.value = generic_id;
    frmDrugObj.generic_name.value = generic_name;    
    frmDrugObj.limit_ind.value = limit_ind;
    frmDrugObj.allergy_yn.value = allergy_yn;
    frmDrugObj.current_rx.value = current_rx;    
    frmDrugObj.srl_no.value = srl_no;
    frmDrugObj.allergy_desc.value = allergy_desc;
    frmDrugObj.exceed_dose_desc.value = exceed_dose_desc;
    frmDrugObj.dup_drug_desc.value = dup_drug_desc;
}
function calculateDosage_By_BSA_or_Weight(mode) 
{
    var frmObj = document.formIVPBDrugDetails;
    var headerfrmobj = document.PharmBaseForm;
    var baseDoseValue = frmObj.body_weight_dose.value;
    var kg_m2_value = $("#ivInterDosageUnitValues").data("kendoDropDownList").value();
    var weight = headerfrmobj.weight.value;
    var bsa = headerfrmobj.bsa.value;
    if (baseDoseValue != "" && baseDoseValue != "0") {
        totDoseValue = "";
        if (kg_m2_value == "KG") {
            totDoseValue = parseFloat(baseDoseValue) * parseFloat(weight);
        } else {
            totDoseValue = parseFloat(baseDoseValue) * parseFloat(bsa);
        }        
        if (isNaN(totDoseValue)) {         
            frmObj.strength_weight_dose.value = frmObj.STR_VAL.value;
        } else {
            frmObj.strength_weight_dose.value = Math.round(parseFloat(totDoseValue) * 1000) / 1000;            
        }
        var strength_weight_dose = document.getElementById("strength_weight_dose");
        setCalculatedQty(strength_weight_dose);
        DosageLimitCheck(strength_weight_dose);
        setDrugDosageDetails();
    } 
}
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc) {
   // console.log("stock_uom_code::" + stock_uom_code);
    var frmObj = document.formIVPBDrugDetails;
    if (mode == 1) {
        frmObj.volume_value.value = stock_value;
        $("#volume_unit").text(stock_uom_desc);
        frmObj.volume_unit_code.value = stock_uom_code;
		  frmObj.volume_unit_desp.value = stock_uom_desc;
		
		
        $("#inFusion_units").text(stock_uom_desc);

    } else {
        showToastMsg("Equivalent Unit of Measure is not defined");
    }
}
function searchOrdersetPiggyBack(searchBasedOn, order_set_code, patient_class, drug_code, bean_id, bean_name, patient_id, encounter_id) {
    var frmObj = document.PharmBaseForm;
    patient_class = patient_class;
    var source_code = frmObj.source_code.value;
    var drug_db_interface_yn = frmObj.drug_db_interface_yn.value;
    var drug_db_dosecheck_yn = frmObj.drug_db_dosecheck_yn.value;
    var drug_db_duptherapy_yn = frmObj.drug_db_duptherapy_yn.value;
    var drug_db_interact_check_yn = frmObj.drug_db_interact_check_yn.value;
    var drug_db_contraind_check_yn = frmObj.drug_db_contraind_check_yn.value;
    var drug_db_allergy_check_yn = frmObj.drug_db_allergy_check_yn.value;
    var take_home_medication = frmObj.take_home_medication.value;
    var location_type = frmObj.location_type.value;
    var location_code = frmObj.location_code.value;
    var priority = frmObj.priority.value;
    var iv_prep_yn = frmObj.iv_prep_default.value;
    var pract_id = frmObj.pract_id.value;
    var resp_id = frmObj.resp_id.value;

    var act_patient_class = frmObj.actual_patient_class.value; //CRF-0062 
    var xmlStr = "<root><SEARCH act_pat_class =\"" + act_patient_class + "\" /></root>";
    
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=DRUGCODE&drugCodes=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&drug_db_interface_yn=" + drug_db_interface_yn + "&drug_db_dosecheck_yn=" + drug_db_dosecheck_yn + "&drug_db_duptherapy_yn=" + drug_db_duptherapy_yn + "&drug_db_interact_check_yn=" + drug_db_interact_check_yn + "&drug_db_contraind_check_yn=" + drug_db_contraind_check_yn + "&drug_db_allergy_check_yn=" + drug_db_allergy_check_yn + "&location_type=" + location_type + "&location_code=" + location_code + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn + "&take_home_medication=" + take_home_medication + "&order_set_code=" + order_set_code + "&pract_id=" + pract_id + "&resp_id=" + resp_id;   
    submitXML(qryString, xmlStr); // CRF-0062
}
function assignMonoGraphdetails() {
}
function searchIVDrug(frmObj, searchBasedOn, obj, rec_no) {
    var frmObj = document.formIVPBDrugDetails;
    var patient_class = frmObj.patient_class.value;
    var headerFrm = document.PharmBaseForm;
    patient_class = frmObj.patient_class.value;
    var source_code = headerFrm.source_code.value;
    var source_type = headerFrm.source_type.value;
    var drug_db_interface_yn = headerFrm.drug_db_interface_yn.value;
    var drug_db_dosecheck_yn = headerFrm.drug_db_dosecheck_yn.value;
    var drug_db_duptherapy_yn = headerFrm.drug_db_duptherapy_yn.value;
    var dbuildMAR_ynrug_db_interact_check_yn = headerFrm.drug_db_interact_check_yn.value;
    var drug_db_contraind_check_yn = headerFrm.drug_db_contraind_check_yn.value;
    var drug_db_allergy_check_yn = headerFrm.drug_db_allergy_check_yn.value;
    var encounter_id = headerFrm.encounter_id.value;
    var patient_id = headerFrm.patient_id.value;
    var act_patient_class = headerFrm.actual_patient_class.value;
    var discharge_yn = headerFrm.take_home_medication.value;
    var priority = headerFrm.priority.value;

    var location_type = headerFrm.location_type.value;
    var location_code = headerFrm.location_code.value;
    var take_home_medication = headerFrm.take_home_medication.value;
    var date_of_birth = headerFrm.date_of_birth.value;
    var gender = headerFrm.gender.value;
    var pract_id = headerFrm.pract_id.value;
    var resp_id = headerFrm.resp_id.value;    
    var buildMAR_yn = getMAR_app_yn(headerFrm);
    var iv_prep_yn = "";    
    iv_prep_yn = "4";    
    iv_prep_yn = "3";
    var drug_code = frmObj.DRUG_CODE.value;
    var starting_date = headerFrm.ref_sys_date.value;    
    var trade_code = frmObj.TRADE_CODE.value;
    var trade_name = frmObj.TRADE_NAME.value;
    var bean_id = frmObj.bean_id.value;
    var bean_name = frmObj.bean_name.value;

    var xmlStr = "<root><SEARCH act_pat_class =\"" + act_patient_class + "\" /></root>"
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=DRUGCODE&drugCodes=" + drug_code + "&patient_id=" + frmObj.patient_id.value + "&encounter_id=" + frmObj.encounter_id.value + "&drug_db_interface_yn=" + drug_db_interface_yn + "&drug_db_dosecheck_yn=" + drug_db_dosecheck_yn + "&drug_db_duptherapy_yn=" + drug_db_duptherapy_yn + "&drug_db_interact_check_yn=" + drug_db_interact_check_yn + "&drug_db_contraind_check_yn=" + drug_db_contraind_check_yn + "&drug_db_allergy_check_yn=" + drug_db_allergy_check_yn + "&trade_code=" + trade_code + "&trade_name=" + trade_name + "&location_type=" + location_type + "&location_code=" + location_code + "&take_home_medication=" + take_home_medication + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn + "&pract_id=" + pract_id + "&resp_id=" + resp_id + "&buildMAR_yn=" + buildMAR_yn + "&starting_date=" + starting_date;
    submitXML(qryString, xmlStr);     
}


function getMAR_app_yn(headerFormObj) {
    var patient_class = headerFormObj.actual_patient_class.value;
    var take_home_med = headerFormObj.take_home_medication.value;
    var MAR_app_yn = "";
    if (take_home_med == 'Y')
        MAR_app_yn = headerFormObj.disch_med_mar_appl_yn.value;
    else if (patient_class == 'DC')
        MAR_app_yn = headerFormObj.dc_mar_appl_yn.value;
    else if (patient_class == 'EM')
        MAR_app_yn = headerFormObj.em_mar_appl_yn.value;
    else if (patient_class == 'IP')
        MAR_app_yn = headerFormObj.ip_mar_appl_yn.value;
    else if (patient_class == 'OP')
        MAR_app_yn = headerFormObj.op_mar_appl_yn.value;
    return MAR_app_yn;
}


function setSchedule() {
   // deleteSchedule();
    makeAutoSchedule();
}

function deleteSchedule() {
    var frmObj = document.formIVPBDrugDetails;
    var bean_id = frmObj.bean_id.value;
    var bean_name = frmObj.bean_name.value;
    var patient_id = frmObj.patient_id.value;
    var encounter_id = frmObj.encounter_id.value;
    var drug_code = frmObj.drug_code.value;
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=DELETESCHEDULE&drug_code=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id;
    submitXML(qryString, "");
}

function makeAutoSchedule() {  



    var frmObj = document.formIVPBDrugDetails;
    var bean_id = frmObj.bean_id.value;
    var bean_name = frmObj.bean_name.value;
    var patient_id = frmObj.patient_id.value;
    var encounter_id = frmObj.encounter_id.value;
	frmObj.STOCK_VALUE.value = frmObj.STR_VAL.value;
	//debugger;
   //if ($("#frequencyList").data("kendoDropDownList").value() != "") {
        if (frmObj != undefined && (frmObj.iv_fluid_yn.value == "Y" || frmObj.iv_fluid_yn.value == "y")) {
            frmObj.STOCK_VALUE.value = frmObj.STR_VAL.value;
        }
        start_date = frmObj.ivInterStartDate.value;
        qty_value = frmObj.STOCK_VALUE.value;
        freq_code = $("#frequencyList").data("kendoDropDownList").value();
		
        drug_code = frmObj.drug_code.value;
        if (qty_value != "" && qty_value !== "0" && frmObj.freq_nature.value != "I") {
            var qryString = bean_id + "&bean_name=" + bean_name + "&validate=AUTOSCHEDULE&freq_code=" + freq_code + "&start_date=" + start_date + "&qty_value=" + qty_value + "&drug_code=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id;
            submitXML(qryString, "");
        } else if (frmObj.freq_nature.value == "I") {
            //frmObj.btn_schedule.disabled = true;
			var qryString = bean_id + "&bean_name=" + bean_name + "&validate=AUTOSCHEDULE&freq_code=" + freq_code + "&start_date=" + start_date + "&qty_value=" + qty_value + "&drug_code=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id;
            submitXML(qryString, "");
        }else{
			var qryString = bean_id + "&bean_name=" + bean_name + "&validate=AUTOSCHEDULE&freq_code=" + freq_code + "&start_date=" + start_date + "&qty_value=" + qty_value + "&drug_code=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id;
            submitXML(qryString, "");
			
		}
   // }
}

function makeScheduleLink(admin_time, admin_qty, total_qty, freq_size, split_chk, repeat_value) {}

function disableall() {
}
function showRelatedKendo(ids) {
    var dropDown = $("#" + ids).data("kendoDropDownList");
    dropDown.enable(true);
}
function checkForHtWt() {
    var baseformobj = document.PharmBaseForm;
    var weight = baseformobj.weight.value;
    var height = baseformobj.height.value;
    if (weight == "" || height == "" || weight == null || height == null) {
        baseformobj.ht_wt_check.value = "YI";
        $("#pharmacyValidationPopUp").show();
		$("#dvMez").show();
    }
}

function onClacBy() {
    var ivInterCalcBy = $("#ivInterCalcBy").val();
    setterClacby(ivInterCalcBy);
    var getCalBy = getterClacby();
    if (getCalBy == "D") {
        showDosageBY();
        $("#strenght_quality").show();
        hideAllBnsWeight();

    } else {
		checkForHtWt();
        hideDosageBY();
        $("#strenght_quality").hide();
		calculateDosage_By_BSA_or_Weight("");
        showAllBnsWeight();
    }
}
function showAllBnsWeight() {
	
	 $("#typeOfHWcheckInter").val("IVINTER");
    $("#ivRxbodyWt").css("display", "block");
    $("#strengthWrapper").css("display", "none");
    showRelatedKendo("ivInterDosageUnit");
    showRelatedKendo("ivInterDosageUnitValues");

}
function hideAllBnsWeight() {
    $("#ivRxbodyWt").css("display", "none");
    $("#strengthWrapper").css("display", "table");

    $("#ivrxInterBuildMAR").css("padding-bottom", "0px");
    hideRelatedKendo("ivInterDosageUnit");
    hideRelatedKendo("ivInterDosageUnitValues");
}
var calcBy = $("#ivInterCalcBy").kendoDropDownList({
    change: onClacBy,
});

function onDosageBY() {
    var ivInterDosageBy = $("#ivInterDosageBy").val();
    var frmObj = document.formIVPBDrugDetails;
	var header_form = document.PharmBaseForm;
    if (ivInterDosageBy == "Q") {
        var bean_id = frmObj.bean_id.value;        
        var bean_name = frmObj.bean_name.value;
        var pres_base_uom = frmObj.PRES_BASE_UOM.value;
        var form_code = frmObj.FORM_CODE.value;
        var drug_code = frmObj.DRUG_CODE.value;
		 var rx_qty_by_pres_base_uom_yn = header_form.rx_qty_by_pres_base_uom_yn.value;
		
        var qryString = bean_id + "&bean_name=" + bean_name + "&validate=QUANTITY&form_code=" + form_code + "&drug_code=" + drug_code + "&pres_base_uom=" + pres_base_uom + "&rx_qty_by_pres_base_uom_yn="+rx_qty_by_pres_base_uom_yn ;
        submitXML(qryString, "");
        var PRES_QTY_VALUE = frmObj.qty_value.value;
        frmObj.str_qty_units.value = PRES_QTY_VALUE;
        $("#strength_dosage_lable").text("Dose");
        var dropDown = $("#ivstrenghtRateUnit").data("kendoDropDownList");
        dropDown.enable(true);
    } else {
        clearDatastr();
        var ORDERSET_STRENGTH = frmObj.ORDERSET_STRENGTH.value;
        var STRENGTH_UOM_DESC = frmObj.STRENGTH_UOM_DESC.value;
        var STRENGTH_UOM_CODE = frmObj.STRENGTH_UOM_CODE.value;
        addData(STRENGTH_UOM_DESC, STRENGTH_UOM_CODE);
		//console.log("STRENGTH_UOM_DESC:"+STRENGTH_UOM_DESC+"STRENGTH_UOM_CODE::"+STRENGTH_UOM_CODE);
        setDefaultData(STRENGTH_UOM_DESC);
        var STR_VAL = frmObj.drug_strength_value.value;
        frmObj.str_qty_units.value = STR_VAL;
        $("#strength_dosage_lable").text("Strength");
        var dropDown = $("#ivstrenghtRateUnit").data("kendoDropDownList");
        dropDown.enable(false);
    }
	}
var dosageBy = $("#ivInterDosageBy").kendoDropDownList({
    change: onDosageBY,
});
function displayADRimage() {
}
function changeVehicle() {
    var frmObj = document.formIVPBDrugDetails;
    var header_form = document.PharmBaseForm;
    var vehicle_code = $("#ivIntermitantFluidNameValues").data("kendoDropDownList").value();
    var trade_code = $("#ivIntermitantFluidNameValues").data("kendoDropDownList").value();
    if (trade_code == undefined)
        trade_code = "";
    var bean_id = frmObj.bean_id.value;
    var bean_name = frmObj.bean_name.value;
    var priority = header_form.priority.value;
    var location_type = header_form.location_type.value;
    var location_code = header_form.location_code.value;
    var take_home_medication = header_form.take_home_medication.value;
    var pract_id = header_form.pract_id.value;
    var resp_id = header_form.resp_id.value;
    var iv_prep_yn = "";    
    iv_prep_yn = "4";    
    iv_prep_yn = "3";
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=VEHILEDETAILS&drug_code=" + vehicle_code + "&patient_id=" + header_form.patient_id.value + "&encounter_id=" + header_form.encounter_id.value + "&lang_id=" + header_form.language_id.value + "&trade_code=" + trade_code + "&location_type=" + location_type + "&location_code=" + location_code + "&take_home_medication=" + take_home_medication + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn + "&pract_id=" + pract_id + "&resp_id=" + resp_id;
    submitXML(qryString, "");   
}
var fluidType = $("#ivIntermitantFluidNameValues").kendoDropDownList({
    change: changeVehicle,
});
var fluidType = $("#infusionRateUnit").kendoDropDownList({
    change: calInfuseOver,
});
var fluidType = $("#ivInterinfusionRateUnit").kendoDropDownList({   
});
var ivstrenghtRateUnit = $("#ivstrenghtRateUnit").kendoDropDownList({
change:ivSternght
});
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
    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/IVPBValidate.jsp?bean_id=" + qryString, false);
    xmlHttpObj.send(xmlDoc);
    return true;
}
var pharmIvRxDetailsScroller;
var pharmIvRxAdminScroller;
function assignPharmIvRxDetailsScroller() {
    pharmIvRxDetailsScroller = new IScroll('#drugDetailsIvRxScroller', {
        scrollX: false,
        scrollY: true,
        scrollbars: true,
        interactiveScrollbars: true,
        click: true,
        useTransition: false,
        bindToWrapper: true,
        hideScrollbar: true,
        fadeScrollbars: true,
        preventDefaultException: {
            tagName: /^(INPUT|SELECT|TEXTAREA|BUTTON)$/i
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
}
function openAdminDetailsTab() {
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
}
//Banner Indicator Starts

function setCalculatedQty(obj, caldfrm) {
    var frmObj = document.formIVPBDrugDetails;
    if (frmObj == undefined)
        frmObj = parent.f_iv_pb_drug.document.formIVPBDrugDetails;
    if (CheckPositiveNumber(obj)) {

        if ($("#ivInterDosageBy").data("kendoDropDownList").value() == "S") {
            var objVal = obj.value;
            frmObj.BMS_QTY.value = Math.ceil(objVal / frmObj.STR_VAL.value);
            setInfusionPeriod(frmObj.INFUSION_VALUE);
        }
    }
    if (frmObj.iv_fluid_yn.value == "Y" || frmObj.iv_fluid_yn.value == "y") {
        // its a ready to use iv drug, no fluid is required
        if ($("#ivInterDosageBy").val() == "S") {
            strengthValue = frmObj.str_qty_units.value;
            drug_strength_value = frmObj.drug_strength_value.value;
            strengthPerPresUom = frmObj.strength_per_value_pres_uom.value;

            valueInPresBaseUom = strengthValue * strengthPerPresUom / drug_strength_value;
        } else {
           // frmObj.str_qty_units.value = frmObj.str_qty_units.value;
        }

        if (caldfrm != 'frmCalInfuseOver') //this if condition added for 24668
            calInfuseOver();
			}
}
function DosageLimitCheck(obj) {
    if (obj.value == "" || parseInt(obj.value) == 0)
        return false;

    var drug_frmobj = document.formIVPBDrugDetails;
    var header_form = document.PharmBaseForm;
    var mode = drug_frmobj.mode.value;
    var inf_prd_value = drug_frmobj.infusion_over_insert_value.value;
    var durn_value = drug_frmobj.Duration_for_repeat.value;
    durn_value = Math.ceil(durn_value / 24);
    if ((inf_prd_value == '' || inf_prd_value == '0') && (drug_frmobj.drug_code.value != "")) {        
        showToastMsg("Infusion rate Cannot be blank or zero");        
        return false;
    }
    var repeat_value = Math.ceil(parseInt(durn_value) / parseInt(inf_prd_value));

    var external_prod_id = "";
    if (drug_frmobj.external_product_id != undefined) {
        external_prod_id = drug_frmobj.external_product_id.value;
    }
    var drug_db_dosechk_yn = drug_frmobj.drug_db_dosecheck_yn.value;
    var drug_db_interface_yn = drug_frmobj.drug_db_interface_yn.value;
    if (drug_db_interface_yn == "Y") {
        if ((external_prod_id != '') && (drug_db_dosechk_yn == "Y")) {
            ExternalDosageCheck('', 'presc');
            return;
        }
    }
    var iv_bean_id = drug_frmobj.iv_bean_id.value;
    var iv_bean_name = drug_frmobj.iv_bean_name.value;
    var patient_id = header_form.patient_id.value;
    var drug_code = drug_frmobj.drug_code.value;
    var srl_no = drug_frmobj.srl_no.value;
    var qty_value = drug_frmobj.str_qty_units.value;
    var dosage_type = $("#ivInterDosageBy").data("kendoDropDownList").value();

    var xmlStr = "<root><SEARCH ";

    xmlStr += "patient_id =\"" + patient_id + "\" ";
    xmlStr += "drug_code =\"" + drug_code + "\" ";
    xmlStr += "srl_no =\"" + srl_no + "\" ";
    xmlStr += "repeat_value =\"" + repeat_value + "\" ";
    xmlStr += "qty_value =\"" + qty_value + "\" ";
    xmlStr += "dosage_type =\"" + dosage_type + "\" ";
    xmlStr += " /></root>";    
    var qryString = iv_bean_id + "&validate=DosageLimitCheck&bean_name=" + iv_bean_name;
    submitXML(qryString, xmlStr);
}

function setDrugDosageDetails() {
    var bean_id = document.formIVPBDrugDetails.bean_id.value;
    var bean_name = document.formIVPBDrugDetails.bean_name.value;
    var patient_id = document.PharmBaseForm.patient_id.value;
    var encounter_id = document.PharmBaseForm.encounter_id.value;
    var strengthUom = $("#ivstrenghtRateUnit").data("kendoDropDownList").value();
    var drug_dosage = document.formIVPBDrugDetails.str_qty_units.value;
    var dosage_type = $("#ivInterDosageBy").data("kendoDropDownList").value();

    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=SETUOM&strengthUom=" + strengthUom + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&drug_dosage=" + drug_dosage + "&dosage_type=" + dosage_type;
    submitXML(qryString, "");
}

function enableDosageLimit(limit_ind, daily_dose, unit_dose, mono_graph, min_daily_dose, min_unit_dose) {
    $("#span_beyondDoseLimit").attr("style", "display:inline-block");
    $("#ivrxBeyondDosageOvverride").attr("style", "display:table");
    $("#ivIntermitantDrugOveride").show();
    var drug_frmobj = document.formIVPBDrugDetails;
    drug_frmobj.limit_ind.value = limit_ind;
    drug_frmobj.daily_dose.value = daily_dose;
    drug_frmobj.unit_dose.value = unit_dose;
    drug_frmobj.mono_graph.value = unescape(mono_graph);
    drug_frmobj.min_daily_dose.value = min_daily_dose;
    drug_frmobj.min_unit_dose.value = min_unit_dose;
}

function disableDosageLimit() {
    var drug_frmobj = document.formIVPBDrugDetails;
    var current_rx = drug_frmobj.current_rx.value;
    var allergy_yn = drug_frmobj.allergy_yn.value;
    drug_frmobj.limit_ind.value = "Y";
    if (current_rx == "N" && allergy_yn == "N") {
        drug_frmobj.daily_dose.value = "";
        drug_frmobj.unit_dose.value = "";
        drug_frmobj.mono_graph.value = "";
        drug_frmobj.min_daily_dose.value = "";
        drug_frmobj.min_unit_dose.value = "";

        $("#span_beyondDoseLimit").attr("style", "display:none");
        $("#ivrxBeyondDosageOvverride").attr("style", "display:none");
        $("#ivIntermitantDrugOveride").hide();
    }
}

function CheckPositiveNumber(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {} else {
        if (obj.value.length > 0) {
            showToastMsg("Invalid positive number");
            obj.select();
            //obj.focus();
        } else if (obj.value.length == 0)
            obj.value = 0;
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

//Banner Indicator Ends

function completeIvRxDetailsConfirm() {
    releaseRX1();

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
function chkBackFutureDate(obj, locale) {

    var frmAdminObj = document.formIVPBDrugDetails;

    var start_date_chk = frmAdminObj.ivInterStartDate.value;
    if (start_date_chk != "") {
        var back_date = frmAdminObj.back_date.value;

        var future_date = frmAdminObj.future_date.value
        if (validDate(start_date_chk, "DMYHM", locale)) {
            if (future_date != null && future_date != 'null' && future_date != "0" && future_date != "") { //newly added future_date!="" for incident 33048
                if (isBefore(start_date_chk, future_date, "DMYHM", locale)) {
                    populateEndDate();
                } else { 
                    showToastMsg("Current start date does not satisfy the parameter range");
                    //obj.focus();
                    return false;
                }
            }

            if (back_date != null && back_date != 'null' && back_date != "0" && back_date != "") { //newly added back_date!="" for incident 33048
                if (isAfter(start_date_chk, back_date, "DMYHM", locale)) {
                    populateEndDate();
                } else {                    
                    showToastMsg("Current start date does not satisfy the parameter range");
                    //obj.focus();
                    return false;
                }
            }

        } else {            
            showToastMsg("Invalid date time format");            
            //obj.focus();
            return false;
        }
    } else {        
        showToastMsg("Start date cannot be blank");
        var startDatepicker = $("#ivInterStartDate").data("kendoDateTimePicker");
        startDatepicker.value(document.formIVPBDrugDetails.start_date.value);        
        return false;
    }
}


function validateFrequency(adminform) {
    var fObj = adminform;
    var freq_nature = fObj.freq_nature.value;
    var interval_value = fObj.interval_value.value;
    var durn_value = fObj.Duration_for_repeat.value;

    if (freq_nature == "F" && interval_value > 1) {
        if ((durn_value % interval_value) > 0) {
            var rem = durn_value % interval_value;
            var prev_day = parseInt(durn_value) - parseInt(rem);
            var nxt_day = parseInt(durn_value) - parseInt(rem) + parseInt(interval_value);
            var err_msg = "APP-PH611 Duration value can be $ or # or a multiple of %";
            if (prev_day == 0) {
                err_msg = err_msg.replace('$ or ', "");
            } else
                err_msg = err_msg.replace('$', prev_day);
            err_msg = err_msg.replace('#', nxt_day);
            err_msg = err_msg.replace('%', interval_value);
            showToastMsg(err_msg);
            return false;
			}
        fObj.ivInterinfusionRateUnit.disabled = true;
    }
    return true;    
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

function chkMandatoryFlds(calledMode) {
    var retStat = true;

    if (calledMode == "Preview" || calledMode == "Release") {

        var frmObjBase = document.formIVPBDrugDetails;
        var header_form = document.PharmBaseForm;
        var frmAdminObj = frmObjBase;
        var frmObj = frmObjBase;
        var frmObjPiggyBack = frmObjBase;
        var ivInterCalcBy = $("#ivInterCalcBy").val();
        var STRENGTH_UOM ="";				
		var dosage_type = $("#ivInterDosageBy").data("kendoDropDownList").value();		 				
		if(dosage_type!="Q"){
			STRENGTH_UOM = frmObjBase.ivInterDosageUnit.value;		 				
		 }
		else
		 {
		 STRENGTH_UOM ="0";
		 }		 
        var vehicle = frmObjBase.ivIntermitantFluidNameValues.value;
        var START_DATE = frmObjBase.ivInterStartDate.value;
        var END_DATE = frmObjBase.ivInterEndDate.value;
        var FREQUENCY = frmObjBase.frequencyList.value;
        var inf_value = frmAdminObj.INFUSION_VALUE.value;
		var volume_value = frmAdminObj.volume_value.value;
		
		
        if (frmAdminObj.INFUSION_VALUE.value == "" || parseFloat(inf_value) == 0) {
            showToastMsg("Infusion rate cannot be blank or zero");            

            //frmAdminObj.INFUSION_VALUE.focus();
            retStat = false;
        } else if ((frmAdminObj.infusion_over_hrs.value == "" || parseFloat(frmAdminObj.infusion_over_hrs.value) == 0) && (frmAdminObj.infusion_over_mins.value == "" || parseFloat(frmAdminObj.infusion_over_mins.value) == 0)) {
            
            showToastMsg("Infusion over cannot be blank or zero");            
            //frmAdminObj.infusion_over_hrs.focus();
            retStat = false;
        } else if (frmObj.DRUG_CODE.value == "") {
            showToastMsg("Drug cannot be blank...");          
            retStat = false;
        }        
        else if (ivInterCalcBy == "D" && (frmObj.str_qty_units.value == "" || parseFloat(frmObj.str_qty_units.value) == 0)) {
            if(dosage_type =="S"){
            	showToastMsg("Strength cannot be zero or blank");
            }else{
        	showToastMsg("Dose cannot be zero or blank");
            }
            //frmObj.str_qty_units.focus();
            retStat = false;
        } else if (ivInterCalcBy == "B" && (frmObj.body_weight_dose.value == "" || parseFloat(frmObj.body_weight_dose.value) == 0)) 
		{            
            showToastMsg("Dose cannot be zero or blank");         
            //frmObj.body_weight_dose.focus();
            retStat = false;
        } else if (dosage_type!="Q" && STRENGTH_UOM == "") {
            showToastMsg("Strength UOM cannot be blank");            
            retStat = false;
        } else if (trimCheck(vehicle) == "") {
            showToastMsg("Fluid cannot be blank");            
            retStat = false;
        } else if (trimCheck(START_DATE) == "") {            
            showToastMsg("Start date cannot be blank");
            retStat = false;            
        } else if (trimCheck(END_DATE) == "") {
            showToastMsg("Current end date cannot be blank");            
            retStat = false;
        }else if (trimCheck(volume_value) == "" || parseFloat(volume_value) == 0 ){
		
		     showToastMsg("Volume cannot be blank or Zero");
            retStat = false;
		
		} else if (trimCheck(FREQUENCY) == "") {
            showToastMsg("Frequency cannot be blank");
            retStat = false;
        } 
		if (frmAdminObj.limit_ind.value == "N") {
            if (frmAdminObj.txtivInterBeyDosageOveride.value == undefined || frmAdminObj.txtivInterBeyDosageOveride.value == "") {                
                showToastMsg("Beyond dosage limit override reason cannot be empty");
                retStat = false;
            }
        } 
		if (frmAdminObj.current_rx.value == "Y" && frmAdminObj.ext_med_alerts_fired_for_dup_check_yn.value != "Y") {
            if (frmAdminObj.txtivInterDupOveride.value == undefined || frmAdminObj.txtivInterDupOveride.value == "") {                
                showToastMsg("Duplicate drug override reason cannot be empty");
                retStat = false;
            }

        }
		if (frmAdminObj.allergy_yn.value == "Y" && frmAdminObj.ext_med_alerts_fired_for_allergy_check_yn.value != "Y" ) {
			if (frmAdminObj.txtivInterAllergyOveride.value == undefined || frmAdminObj.txtivInterAllergyOveride.value == "") {                
                showToastMsg("Allergy override reason cannot be empty");
                retStat = false;
            }
        } 
		if (parseInt(frmAdminObj.infusion_over_mins.value) > 59) {            
            showToastMsg("Minute entered is invalid .It should be between 0 and 59");            
            retStat = false;
        } else {
            var dur_val = frmAdminObj.Duration_for_repeat.value;
            if (frmAdminObj.ivInterinfusionRateUnit.value == "H")
                dur_val = dur_val * 60;
            if (frmAdminObj.ivInterinfusionRateUnit.value == "D")
                dur_val = dur_val * 24 * 60;
            if (frmAdminObj.ivInterinfusionRateUnit.value == "W")
                dur_val = dur_val * 7 * 24 * 60;
            if (frmAdminObj.ivInterinfusionRateUnit.value == "L")
                dur_val = dur_val * 30 * 24 * 60;
            if (frmAdminObj.ivInterinfusionRateUnit.value == "Y")
                dur_val = dur_val * 12 * 30 * 24 * 60;
            infuseOver = getInfuseOverInMin(frmAdminObj.infusion_over_hrs.value, frmAdminObj.infusion_over_mins.value);
            if (parseInt(dur_val) < parseInt(infuseOver)) {                
                showToastMsg("Duration cannot be less than Infuse over");
                //frmAdminObj.INFUSION_PERIOD_VALUE.focus();
                retStat = false;
            }
        }
    }
    return retStat;    
}
function TrimStr(sInString) {
    sInString = sInString.replace(/^\s+/g, ""); // strip leading
    return sInString.replace(/\s+$/g, ""); // strip trailing
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

function releaseRX1() {

    var frmObjBase = document.formIVPBDrugDetails;
    var header_form = document.PharmBaseForm;
    var pat_class = header_form.patient_class.value;
	var location_code = header_form.location_code.value;
	var take_home_medication =header_form.take_home_medication.value;
    var iv_presc_yn = "";
    header_form.buildMAR_yn.value = frmObjBase.buildMAR_yn.value;
    if (validateFrequency(frmObjBase)) {
        if (chkMandatoryFlds("Release")) {
            var allergic_yn = "N";
            allergic_yn = header_form.allergic_yn.value;
            if (header_form != undefined) {
                var th_medn = "N";
                if (header_form.take_home_medication.value == "y")
                    th_medn = "D";
                var height = header_form.height.value;
                var weight = header_form.weight.value;
                if (header_form != null) {
                    var height_unit = header_form.height_unit.value;
                    if (height_unit == "")
                        height_unit = "Cms";
                    var weight_unit = header_form.weight_unit.value;
                    if (weight_unit == "")
                        weight_unit = "Kgs";
                } else {
                    var height_unit = "";
                    var weight_unit = "";
                }
                var bsa = header_form.bsa.value;
                var bmi = header_form.bmi.value;
                var bsa_unit = "BSA";
                var priority = header_form.priority.value;
                var ord_date_time = header_form.sys_date.value;
            }
            if (frmObjBase.Admixture.checked == true) {
                iv_presc_yn = "I";
            } else
                iv_presc_yn = "N";

            var bean_id = frmObjBase.iv_bean_id.value;
            var bean_name = frmObjBase.iv_bean_name.value;
            var calc_dose_based_on;
            if (frmObjBase.ivInterCalcBy.value == "D")
                calc_dose_based_on = frmObjBase.ivInterCalcBy.value;
            else
                calc_dose_based_on = frmObjBase.ivInterCalcBy.value;
            var calc_dose_value = frmObjBase.body_weight_dose.value;
            var calc_dose_by = frmObjBase.ivInterDosageUnitValues.value;
            var dosage = "";
			var  ivInterDosageBy =frmObjBase.ivInterDosageBy.value;	
            if (calc_dose_based_on == "B") {
                dosage = frmObjBase.strength_weight_dose.value;
            }else{
				if (ivInterDosageBy == "Q") {
					 dosage = frmObjBase.str_qty_units.value;
					
				}
				else if(ivInterDosageBy == "S"){
					dosage = frmObjBase.str_qty_units.value;
					
				}
				 
			}
              
		   frmObjBase.calcualted_durn_value.value="1";
			  
			
			var Strength;
			var dose;
		  if (ivInterDosageBy == "Q") {
		  
		     dose=frmObjBase.str_qty_units.value;
			 
			 
             
			  
            }else if(ivInterDosageBy == "S"){
			
			 Strength = frmObjBase.str_qty_units.value;
			
			}
			   
			   
			   
			
            
            var volume = frmObjBase.volume_value.value;
            var patient_id = frmObjBase.patient_id.value;
            var encounter_id = frmObjBase.encounter_id.value;
            var discharge_yn = header_form.take_home_medication.value;
            var bl_install_yn = header_form.bl_install_yn.value;
            var bl_disp_charge_dtl_in_rx_yn = header_form.bl_disp_charge_dtl_in_rx_yn.value; 
            frmObjBase.ivInterinfusionRateUnit.value = frmObjBase.ivInterinfusionRateUnit.value;
            DrugIndicationRemarks = frmObjBase.Drug_indication.value;
            var sched_medn_yn = "Y";
            var currentrx_remarks = "";
            var dose_remarks = "";
            var allergy_remarks = "";
            if (frmObjBase.txtivInterDupOveride)
                currentrx_remarks = encodeURIComponent(frmObjBase.txtivInterDupOveride.value);
            if (frmObjBase.txtivInterBeyDosageOveride)
                dose_remarks = encodeURIComponent(frmObjBase.txtivInterBeyDosageOveride.value);
            if (frmObjBase.txtivInterAllergyOveride)
                allergy_remarks = encodeURIComponent(frmObjBase.txtivInterAllergyOveride.value);

            var dosagetype = frmObjBase.ivInterDosageBy.value;
            var AUTH_YN_VAL = frmObjBase.AUTH_YN_VAL.value;
            var APPROVAL_YN_VAL = frmObjBase.APPROVAL_YN_VAL.value;
            var COSIGN_YN_VAL = frmObjBase.COSIGN_YN_VAL.value;
            var xmlStr = "<root><SEARCH ";
            xmlStr += " PRIORITY=\"" + priority + "\" ";
            xmlStr += " HEIGHT=\"" + height + "\" ";		
	xmlStr += " sys_date=\"" + header_form.sys_date.value+ "\" ";	
	xmlStr += " language_id=\"" + "en"+ "\" ";
	xmlStr += " back_date=\"" + header_form.back_date.value+ "\" ";
	xmlStr += " BASE_VOLUME=\"" +""+ "\" ";				
	xmlStr += " iv_bean_id=\"" +frmObjBase.iv_bean_id.value+ "\" ";			
	xmlStr += " iv_bean_name=\"" +frmObjBase.iv_bean_name.value+ "\" ";	
	xmlStr += " DRUG_QTY_UOM=\"" +$("#ivstrenghtRateUnit").data("kendoDropDownList").value()+ "\" ";	
	xmlStr += " fluid_remarks=\"" +""+ "\" ";
	xmlStr += "future_date=\"" + header_form.future_date.value+ "\" ";			
	 xmlStr += " HEIGHT_UNIT=\"" + height_unit + "\" ";
            xmlStr += " WEIGHT=\"" + weight + "\" ";
            xmlStr += " WEIGHT_UNIT=\"" + weight_unit + "\" ";
            xmlStr += " BSA=\"" + bsa + "\" ";
            xmlStr += " BSA_UNIT=\"" + bsa_unit + "\" ";
            xmlStr += " IV_PRESC_YN=\"" + iv_presc_yn + "\" ";
            xmlStr += " TH_MEDN=\"" + th_medn + "\" ";
            xmlStr += " allergic_yn=\"" + allergic_yn + "\" ";
            xmlStr += " AUTH_YN_VAL=\"" + AUTH_YN_VAL + "\" ";
            xmlStr += " APPROVAL_YN_VAL=\"" + APPROVAL_YN_VAL + "\" ";
            xmlStr += " COSIGN_YN_VAL=\"" + COSIGN_YN_VAL + "\" ";
            xmlStr += " ord_date_time=\"" + ord_date_time + "\" ";
            xmlStr += " buildMAR_yn=\"" + frmObjBase.buildMAR_yn.value + "\" ";
           xmlStr += " BMI=\"" + bmi + "\" ";
            xmlStr += " DRUG_INDICATION=\"" + encodeURIComponent(DrugIndicationRemarks) + "\" ";
            xmlStr += " ROOM_NUM=\"" + header_form.room_num.value + "\" ";
            xmlStr += " BED_NUM=\"" + header_form.bed_num.value + "\" ";
            xmlStr += " INFUSION_VALUE=\"" + frmObjBase.INFUSION_VALUE.value + "\" ";
            xmlStr += " infusion_time=\"" + $("#infusionRateUnit").data("kendoDropDownList").value() + "\" ";
            xmlStr += " INFUSION_PERIOD_VALUE=\"" + frmObjBase.infusion_over_hrs.value + "\" ";
            xmlStr += " INFUSION_PERIOD_VALUE_MIN=\"" + frmObjBase.infusion_over_mins.value + "\" ";
            xmlStr += " FREQUENCY=\"" + $("#frequencyList").data("kendoDropDownList").value() + "\" ";
            xmlStr += " btn_schedule=\"Schedule\" ";
            xmlStr += " sched_medn_yn=\"" + sched_medn_yn + "\" ";
            xmlStr += " DURN_VALUE=\"" + frmObjBase.Duration_for_repeat.value + "\" ";
            xmlStr += " durn_unit=\"" + $("#ivInterinfusionRateUnit").data("kendoDropDownList").value() + "\" ";
            xmlStr += " START_DATE=\"" + frmObjBase.ivInterStartDate.value + "\" ";
            xmlStr += " END_DATE=\"" + frmObjBase.ivInterEndDate.value + "\" ";
            xmlStr += " bean_id=\"" + bean_id + "\" ";
            xmlStr += " bean_name=\"" + bean_name + "\" ";
           
            xmlStr += " patient_id=\"" + frmObjBase.patient_id.value + "\" ";
            xmlStr += " encounter_id=\"" + frmObjBase.encounter_id.value + "\" ";
            xmlStr += " patient_class=\"" + pat_class + "\" ";
            xmlStr += " facility_id=\"" + frmObjBase.facility_id.value + "\" ";
            xmlStr += " freq_changed_yn=\"" + frmObjBase.freq_changed_yn.value + "\" ";
            xmlStr += " PRACT_ID=\"" + frmObjBase.PRACT_ID.value + "\" ";
            xmlStr += " LOCN_CODE=\"" + frmObjBase.LOCN_CODE.value + "\" ";
            xmlStr += " INFUSION_PERIOD_UOM=\"" + frmObjBase.INFUSION_PERIOD_UOM.value + "\" ";
            xmlStr += " INFUSION_UOM=\"" + frmObjBase.INFUSION_UOM.value + "\" ";
            xmlStr += " DURN_UNIT=\"" + $("#ivInterinfusionRateUnit").data("kendoDropDownList").value() + "\" ";
            xmlStr += " STOCK_VALUE=\"" + frmObjBase.volume_value.value + "\" ";
            xmlStr += " LOCN_TYPE=\"" + frmObjBase.LOCN_TYPE.value + "\" ";
            xmlStr += " EQVL_UOM_CODE=\"" + frmObjBase.volume_unit_code.value + "\" ";
            xmlStr += " STOCK_UOM_CODE=\"" + frmObjBase.volume_unit_code.value + "\" ";
            xmlStr += " mode1=\"" + frmObjBase.mode1.value + "\" ";
            xmlStr += " repeat_value=\"" + frmObjBase.repeat_value.value + "\" ";
            xmlStr += " drug_code=\"" + frmObjBase.drug_code.value + "\" ";
            xmlStr += " infusion_over_insert_value=\"" + frmObjBase.infusion_over_insert_value.value + "\" ";
            xmlStr += " calcualted_durn_value=\"" + frmObjBase.calcualted_durn_value.value + "\" ";
            xmlStr += " interval_value=\"" + frmObjBase.interval_value.value + "\" ";
            xmlStr += " freq_nature=\"" + frmObjBase.freq_nature.value + "\" ";
            xmlStr += " repeat_durn_type=\"" + frmObjBase.repeat_durn_type.value + "\" ";
            xmlStr += " scheduled_yn=\"" + frmObjBase.scheduled_yn.value + "\" ";
           
            xmlStr += " iv_calc_infuse_by=\"" + frmObjBase.iv_calc_infuse_by.value + "\" ";
            xmlStr += " vehicle=\"" + $("#ivIntermitantFluidNameValues").data("kendoDropDownList").value() + "\" ";
            xmlStr += " vehicle_code=\"" + $("#ivIntermitantFluidNameValues").data("kendoDropDownList").value() + "\" ";
            xmlStr += " volume=\"" + frmObjBase.volume_value.value + "\" ";
            xmlStr += " volume_unit=\"" + frmObjBase.volume_unit_code.value + "\" ";
            xmlStr += " volume_desp=\"" + frmObjBase.volume_unit_desp.value + "\" ";
            xmlStr += " ORDER_TYPE_CODE=\"" + frmObjBase.order_type_code.value + "\" ";
            xmlStr += " default_fluid_name=\"" + $("#volume_unit").val() + "\" ";
            xmlStr += " currentrx_remarks=\"" + currentrx_remarks + "\" ";
            xmlStr += " dose_remarks=\"" + dose_remarks + "\" ";
            xmlStr += " allergy_remarks=\"" + allergy_remarks + "\" ";
            xmlStr += " /></root>";
            var qryString = bean_id + "&bean_name=" + bean_name + "&validate=RELEASE&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&dosage=" + dosage + "&volume=" + volume + "&dosage_type=" + dosagetype + "&calc_dose_based_on=" + calc_dose_based_on + "&calc_dose_value=" + calc_dose_value + "&calc_dose_by=" + calc_dose_by + "&pat_class=" + pat_class+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&ivInterDosageBy="+ivInterDosageBy+"&dose="+dose+"&Strength="+Strength;
			
			
            submitXML(qryString, xmlStr);

            $("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
            setTimeout(function() {
                $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
                    function(res) {});
            }, 1000);
        }
    }
}

function alertBLErrorDrugs(blErrorDrugs, called_from) {   
    var bl_alert_msg = "Error During Billing\n";    
    showToastMsg(bl_alert_msg);
    return false;
}

function checkSpl(val) {
    var result = "";
    var ch = "";

    var indVal = 0;
    while ((indVal = val.indexOf('\n', indVal)) != -1) {        
        val = val.replace("\n", "\"");
    }
    var spChars = new Array("<", ">", "&", "\"", "'");
    var chChars = new Array("&lt;", "&gt;", "&amp;", "&quot;", "&apos;");
    for (i = 0; i < val.length; i++) {
        for (j = 0; j < spChars.length; j++) {
            if (val.substring(i, i + 1) == spChars[j]) {
                ch = chChars[j];
                j = spChars.length;
            } else {
                ch = val.substring(i, i + 1);
            }
        }
        result += ch;
    }   
    return result;
}

function buildXMLString(frmObj) {
    var xmlStr = "";
    var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if (frmObj.name == null)
        frmObjs = frmObj;
    else frmObjs[0] = frmObj;

    for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for (var i = 0; i < arrObj.length; i++) {
            var val = "";
            if (arrObj[i].type == "checkbox") {
                if (arrObj[i].checked)
                    val = "Y";
                else
                    val = "N";
                if (arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
            } else if (arrObj[i].type == "radio") {
                if (arrObj[i].checked) {
                    val = arrObj[i].value;
                    if (arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
                }
            } else if (arrObj[i].type == "select-multiple") {
                for (var j = 0; j < arrObj[i].options.length; j++) {
                    if (arrObj[i].options[j].selected)
                        val += arrObj[i].options[j].value + "~"
                }
                val = val.substringing(0, val.lastIndexOf('~'))
                if (arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
            } else {
                val = arrObj[i].value;

                if (arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
            }
        }
    }
    return xmlStr;
}

function onSelectCalculateBy() {	  
	$("#heightCheckOk").addClass('cstFieldDullRxNone');
	var dataItem = document.getElementById("ivInterCalcBy"); 
	if (dataItem.value == "D") {        
		$("#ivIntermitantDIOveride").show(); 
    } else if (dataItem.value == "B") {		
		$("#ivIntermitantDIOveride").hide(); 
	}
}

function callForDefalutLoad(searchBasedOn, order_set_code, patient_class, drug_code, bean_id, bean_name, patient_id, encounter_id,vechile_Code,frq_code){
//console.log("vechile_Code::"+vechile_Code+"ferq::"+frq_code);

 var frmObj = document.PharmBaseForm;
    var patient_class = patient_class;
    var source_code = frmObj.source_code.value;
    var drug_db_interface_yn = frmObj.drug_db_interface_yn.value;
    var drug_db_dosecheck_yn = frmObj.drug_db_dosecheck_yn.value;
    var drug_db_duptherapy_yn = frmObj.drug_db_duptherapy_yn.value;
    var drug_db_interact_check_yn = frmObj.drug_db_interact_check_yn.value;
    var drug_db_contraind_check_yn = frmObj.drug_db_contraind_check_yn.value;
    var drug_db_allergy_check_yn = frmObj.drug_db_allergy_check_yn.value;
    var take_home_medication = frmObj.take_home_medication.value;
    var location_type = frmObj.location_type.value;
    var location_code = frmObj.location_code.value;
    var priority = frmObj.priority.value;
    var iv_prep_yn = frmObj.iv_prep_default.value;
    var pract_id = frmObj.pract_id.value;
    var resp_id = frmObj.resp_id.value;

    var act_patient_class = frmObj.actual_patient_class.value; //CRF-0062 
    var xmlStr = "<root><SEARCH act_pat_class =\"" + act_patient_class + "\" /></root>";
    
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=DEFAULT&drugCodes=" + drug_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&drug_db_interface_yn=" + drug_db_interface_yn + "&drug_db_dosecheck_yn=" + drug_db_dosecheck_yn + "&drug_db_duptherapy_yn=" + drug_db_duptherapy_yn + "&drug_db_interact_check_yn=" + drug_db_interact_check_yn + "&drug_db_contraind_check_yn=" + drug_db_contraind_check_yn + "&drug_db_allergy_check_yn=" + drug_db_allergy_check_yn + "&location_type=" + location_type + "&location_code=" + location_code + "&priority=" + priority + "&iv_prep_yn=" + iv_prep_yn + "&take_home_medication=" + take_home_medication + "&order_set_code=" + order_set_code + "&pract_id=" + pract_id + "&resp_id=" + resp_id+"&vechile_Code="+vechile_Code+"&frq_code="+frq_code;   
    submitXML(qryString, xmlStr);
	
}
function showAdminRate(){
	
}
function mandateRemarks(){
	
}
$(document).ready(function() {
	var drun = $("#ivInterinfusionRateUnit").data("kendoDropDownList").value();
	var frmObj = document.PharmBaseForm;
	populateDurnDesc(drun,frmObj);
	populateEndDate();
	setSchedule()
    hideRelatedDateKendo();
    $('textarea').each(function(index) {
        $(this).bind('touchmove', function(event) {
            event.stopPropagation();
        });
    });
    $("#ivInterStartDate").attr("readonly", true);
	onSelectCalculateBy();
    hideAllBnsWeight();
    var path;
    openDrugDetailsTab();
    setTimeout(function() {
        assignPharmIvRxDetailsScroller();
        //(use this function if scroll required for Admin Details tab) assignPharmIvRxAdminScroller();
    }, 1000);
});

/*orientation change */
    if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',orientationChangeIVRXInter, false);
	}
    function orientationChangeIVRXInter() {
    	setTimeout(function() {
    	    if (Math.abs(window.orientation) === 90) {
       	 	 pharmIvRxDetailsScroller.refresh();
    	    } else {
       	 	 pharmIvRxDetailsScroller.refresh();
    	    } 	 
        }, 1500);
    }
