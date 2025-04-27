var pharmIvRxWADetailsScroller;
$(document).ready(function() {
    setTimeout(function() {
        assignPharmIvRxWithoutAdtDetailsScroller();
    }, 500);
    readyIvRxWithoutAdtDetailsControls();
	if(document.rxDetailsIvRxWaViewForm.infuse_over_unit_sch.value != "null" && document.rxDetailsIvRxWaViewForm.infuse_over_unit_sch.value != "") {
		$("#ivRxInfusionDpList").data("kendoDropDownList").value(document.rxDetailsIvRxWaViewForm.infuse_over_unit_sch.value);
	}
		$("#ivRxStartDate").attr("readonly", true);
});


function assignPharmIvRxWithoutAdtDetailsScroller() {
    pharmIvRxWADetailsScroller = new IScroll('#pharmIvRxWAScroller', {
        scrollX: true,
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
    if (pharmIvRxWADetailsScroller != null) {
        pharmIvRxWADetailsScroller.refresh();
    }
}

function readyIvRxWithoutAdtDetailsControls() {
    $('textarea').each(function(index) {
        $(this).bind('touchmove', function(event) {
            event.stopPropagation();
        });
    });
    $('#ivRxEndDate').prop('disabled', true);
    //Infusion Rate
    $('#ivRxInfusionRate').on('input', function(event) {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
    $("#ivRxInfusionRate").focusout(function() {
        var infusionRate = $("#ivRxInfusionRate").val();
        if (infusionRate == null || infusionRate == 0) {
            $("#ivRxInfusionRate").val();
        } else {
            var volumeUnit = $("#ivRxVolumeUnit").val();
            var rate = document.rxDetailsIvRxWaViewForm.ivRxInfusionRate;
            var duration = $("#ivRxDurationForRepeat").val();
            validateRate(rate, volumeUnit, duration);
        }
    });
    // End

    //Volume  
    $('#ivRxVolumeUnit').on('input', function(event) {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $("#ivRxVolumeUnit").focusout(function() {
        var volumeUnit = $("#ivRxVolumeUnit").val();

        if (volumeUnit == null || volumeUnit == 0) {
            showToastMsg("Volume cannot be blank or zero");
            $("#ivRxVolumeUnit").val();
        } else {
            var volumeUnit = $("#ivRxVolumeUnit").val();
            var rate = document.rxDetailsIvRxWaViewForm.ivRxInfusionRate;
            var duration = $("#ivRxDurationForRepeat").val();
            validateRate(rate, volumeUnit, duration);
        }
    });
    //End

    //Duration for Repeat
    $('#ivRxDurationForRepeat').on('input', function(event) {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $("#ivRxDurationForRepeat").focusout(function() {
        var duration = $("#ivRxDurationForRepeat").val();
        if (duration == null || duration == 0) {
            showToastMsg("Duration cannot be blank or zero");
            $("#ivRxDurationForRepeat").val();
        }
        if (duration != null && duration > 168) {
            showToastMsg("Duration cannot be greater than 168 hours");
            $("#ivRxDurationForRepeat").val();
        } else {		
            var duration = $("#ivRxDurationForRepeat").val();
            var INFUSION_PERIOD_VALUE = $("#ivRxInfusionOverHrs").val();
            var InfusionRateUnit = $("#ivRxInfusionDpList").val();
            var INFUSION_PERIOD_VALUE_MIN = $("#ivRxInfusionOverMins").val();
            var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value;
            strtEndDateTime();            
            validateDuration(duration, INFUSION_PERIOD_VALUE, InfusionRateUnit, INFUSION_PERIOD_VALUE_MIN, iv_calc_infuse_by);
        }
    });
    //End

    //Infusion Over
    $('#ivRxInfusionOverHrs').on('input', function(event) {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $("#ivRxInfusionOverHrs").focusout(function() {
        var infusionOverHrs = $("#ivRxInfusionOverHrs").val();
		var infusionOverMins = $("#ivRxInfusionOverMins").val();
      if(infusionOverHrs == null || infusionOverHrs == 0 && (infusionOverMins == 0 || infusionOverMins == null || infusionOverMins == "")) {
            showToastMsg("Infusion Over cannot be blank or zero");
            $("#ivRxInfusionOverHrs").val(1);
        }
        if (infusionOverHrs != null && infusionOverHrs > 25) {
            showToastMsg("Infusion over cannot be greater than 24 hours");
            $("#ivRxInfusionOverHrs").val();
        } else {
            var infusionOverHrs = $("#ivRxInfusionOverHrs").val();
            var volume = $("#ivRxVolumeUnit").val();
            var INF_RATE = $("#ivRxInfusionRate").val();
            var infusionOverStr = ""; 
            calculateRate(infusionOverHrs, volume, INF_RATE, infusionOverStr);
        }
    });

    $('#ivRxInfusionOverMins').on('input', function(event) {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $("#ivRxInfusionOverMins").focusout(function() {
        var infusionOverMins = $("#ivRxInfusionOverMins").val();
        if (infusionOverMins == null || infusionOverMins == "") {
            $("#ivRxInfusionOverMins").val(0);
        }
        if (infusionOverMins != null && infusionOverMins > 59) {
            showToastMsg("Minute entered is invalid.It sholud be between 0 and 59");          
        } else {
            var infusionOverMns = $("#ivRxInfusionOverHrs").val();
            var volume = $("#ivRxVolumeUnit").val();
            var INF_RATE = $("#ivRxInfusionRate").val();
            var infusionOverStr = ""; //"["+ 12+" Hrs "+ 56 + " Mins]";
            calculateRate(infusionOverMns, volume, INF_RATE, infusionOverStr);
        }
    });
    //End

    //Strat date and end date
    $("#ivRxStartDate ").kendoDateTimePicker({
        format: "dd/MM/yyyy HH:mm",
        timeFormat: "HH:mm" //24 hours format
    });
    var startDatepicker = $("#ivRxStartDate").data("kendoDateTimePicker");
    startDatepicker.value(document.rxDetailsIvRxWaViewForm.start_date.value);
    $("#ivRxEndDate ").kendoDateTimePicker({
        format: "dd/MM/yyyy HH:mm",
        timeFormat: "HH:mm" //24 hours format
    });
    var endDatepicker = $("#ivRxEndDate").data("kendoDateTimePicker");
    endDatepicker.value(document.rxDetailsIvRxWaViewForm.end_date.value);
    //	 End  

    //Infusion dp list		  
    var infusionDpList = [{
        id: "H",
        description: "Hour(s)"
    }, {
        id: "M",
        description: "Minute(s)"
    }];

    function onInfusionUOMChange() {       	
        var rate = document.rxDetailsIvRxWaViewForm.ivRxInfusionRate;
        var volumeUnit = $("#ivRxVolumeUnit").val();
        var duration = $("#ivRxDurationForRepeat").val();
        validateRate(rate, volumeUnit, duration);
    };
    $("#ivRxInfusionDpList").kendoDropDownList({
        dataSource: infusionDpList,
        dataTextField: "description",
        dataValueField: "id",
        change: onInfusionUOMChange,
    });
    //End   
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
function okClickDialog() {
    $("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
}

function cancelClickDialog() {
    $("#confirmMsg").hide();
}

function closeIvRxDetailsView() {
    $("#confirmMsg").show();
}

function completeIvRxDetailsConfirm() {
	var header_form		= document.PharmBaseForm;
	var volumeUnit = $("#ivRxVolumeUnit").val();
    var rate = document.rxDetailsIvRxWaViewForm.ivRxInfusionRate;
    var duration = $("#ivRxDurationForRepeat").val(); 
            var INFUSION_PERIOD_VALUE = $("#ivRxInfusionOverHrs").val();
            var InfusionRateUnit = $("#ivRxInfusionDpList").val();
            var INFUSION_PERIOD_VALUE_MIN = $("#ivRxInfusionOverMins").val();
            var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value;                     
            if(validateDuration(duration, INFUSION_PERIOD_VALUE, InfusionRateUnit, INFUSION_PERIOD_VALUE_MIN, iv_calc_infuse_by) == false){
	         return ;
	        }	
    var ivRxDurationForRepeat = document.rxDetailsIvRxWaViewForm.ivRxDurationForRepeat.value;
    if (ivRxDurationForRepeat == null || ivRxDurationForRepeat == "") {
        showToastMsg("Enter mandatory fields");
        return;
    }
    var ivRxInfusionRate = document.rxDetailsIvRxWaViewForm.ivRxInfusionRate.value;
    if (ivRxInfusionRate == null || ivRxInfusionRate == "") {
        showToastMsg("Enter mandatory fields");
        return;
    }
    var ivRxVolumeUnit = document.rxDetailsIvRxWaViewForm.ivRxVolumeUnit.value;
    if (ivRxVolumeUnit == null || ivRxVolumeUnit == "") {
        showToastMsg("Enter mandatory fields");
        return;
    } 	
    var ivRxStartDate = document.rxDetailsIvRxWaViewForm.ivRxStartDate.value;
    if (ivRxStartDate == null || ivRxStartDate == "") {
        showToastMsg("Enter mandatory fields");
        return;
    }
    var ivRxEndDate = document.rxDetailsIvRxWaViewForm.ivRxEndDate.value;
    if (ivRxEndDate == null || ivRxEndDate == "") {
        showToastMsg("End date cannot be null");
        return;
    }	
	if (duration == 0) {
        showToastMsg("Duration cannot be blank or zero");
        return;
    }
	
	if (duration != null && duration > 168) {
            showToastMsg("Duration cannot be greater than 168 hours");
            return;
        } 

   if (ivRxInfusionRate == 0) {
        showToastMsg("Infusion rate cannot be blank or zero");
        return;
    }
	
	if (ivRxVolumeUnit == 0) {
        showToastMsg("Volume cannot be blank or zero");
        return;
    }		
    var infusionOverHrs = $("#ivRxInfusionOverHrs").val();
    var infusionOverMins = $("#ivRxInfusionOverMins").val();
    if (infusionOverHrs == 0 && infusionOverMins == 0) {
        showToastMsg("Infusion over cannot be blank or zero");
		return;
    }
	
	if ( (infusionOverHrs >=24 && infusionOverMins >0) || infusionOverHrs >24) {
		    showToastMsg("Infusion over cannot be greater than 24 hours");           
			return;
        } 
	   
    if (infusionOverMins != null && infusionOverMins > 59) {
            showToastMsg("Minute entered is invalid.It sholud be between 0 and 59"); 
            return;			
        }	
	var FLUID_CODE = document.rxDetailsIvRxWaViewForm.FLUID_CODE.value;
	var infuseOverUnit = $("#ivRxInfusionDpList").val();
	var volumeUnit = $("#ivRxVolumeUnit").val();
	var infusion_over = document.rxDetailsIvRxWaViewForm.infusion_over_insert_value.value;
	var SELECT = "N";
	var mfr_yn = document.rxDetailsIvRxWaViewForm.mfr_yn.value;	
	var mfr_remarks = encodeURIComponent(document.rxDetailsIvRxWaViewForm.ivRxDrugRemarks.value, "UTF-8");
	var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value;
	var disp_locn_code = document.rxDetailsIvRxWaViewForm.disp_locn_code.value;
	var disp_locn_type = document.rxDetailsIvRxWaViewForm.disp_locn_type.value;
	var facility_id = document.rxDetailsIvRxWaViewForm.facility_id.value;
	var take_home_medication = document.rxDetailsIvRxWaViewForm.take_home_medication.value;
	var infuse_over_unit	= "H";
	var room_num = header_form.room_num.value;
	var bed_num = header_form.bed_num.value;
	var priority	= header_form.priority.value;
	var height		= header_form.height.value;
	var weight		= header_form.weight.value;
	var height_unit	= header_form.height_unit.value;
	if (height_unit == "")
		height_unit	= "Cms";
	var weight_unit	= header_form.weight_unit.value;
	if (weight_unit == "")
		weight_unit	= "Kgs";
	var bsa			= header_form.bsa.value;
	var bmi			= header_form.bmi.value;
	var bsa_unit	= "BSA";
	var allergic_yn ="N";
	allergic_yn= header_form.allergic_yn.value ;	
	var buildMAR_yn = "N";
	if(document.rxDetailsIvRxWaViewForm.buildMarChk.checked)
		buildMAR_yn = "Y";
	var bean_id = document.rxDetailsIvRxWaViewForm.bean_id.value;
	var bean_name = document.rxDetailsIvRxWaViewForm.bean_name.value;
	var mode = document.rxDetailsIvRxWaViewForm.mode.value;
	var patient_id = document.rxDetailsIvRxWaViewForm.patient_id.value;
	var encounter_id = document.rxDetailsIvRxWaViewForm.encounter_id.value;
	var start_date1 = document.rxDetailsIvRxWaViewForm.start_date.value;
	var patient_class = header_form.act_patient_class.value;
	var locn_code = document.rxDetailsIvRxWaViewForm.locn_code.value;
	var pract_name = document.rxDetailsIvRxWaViewForm.pract_name.value;
	if(pract_name!=null && pract_name!="")
		pract_name = encodeURIComponent(pract_name);
	var sys_date = header_form.sys_date.value;
	if(mfr_yn != "Y" && !validateRate1(document.rxDetailsIvRxWaViewForm.ivRxInfusionRate,document.rxDetailsIvRxWaViewForm.ivRxVolumeUnit,document.rxDetailsIvRxWaViewForm.infusion_over_insert_value,document.rxDetailsIvRxWaViewForm.ivRxDurationForRepeat,document.rxDetailsIvRxWaViewForm.ivRxInfusionDpList,document.rxDetailsIvRxWaViewForm.infusion_over_insert_value, iv_calc_infuse_by)){
		return false;
	}
	else{
		SELECT = 'Y'; 
	}		
	var xmlStr		= "<root><SEARCH ";
	xmlStr			+= " FLUID_CODE=\""+ FLUID_CODE + "\" ";
	xmlStr			+= " INF_RATE=\""+ ivRxInfusionRate + "\" ";
	xmlStr			+= " INFUSION_PERIOD_VALUE=\""+ infusion_over + "\" ";
	xmlStr			+= " inf_rate_uom=\""+ infuseOverUnit + "\" ";
	xmlStr          += " INFUSION_PERIOD_VALUE_HRS=\"" + infusionOverHrs + "\" ";
    xmlStr          += " INFUSION_PERIOD_VALUE_MIN=\"" + infusionOverMins + "\" ";
	xmlStr			+= " START_DATE=\""+ ivRxStartDate + "\" ";	
	xmlStr			+= " END_DATE=\""+ ivRxEndDate + "\" ";	
	xmlStr			+= " volume=\""+ volumeUnit + "\" ";
	xmlStr			+= " mfr_yn=\""+ mfr_yn + "\" ";
	xmlStr			+= " DURATION=\""+ ivRxDurationForRepeat + "\" ";	
	xmlStr			+= " DURN_VALUE=\""+ ivRxDurationForRepeat + "\" ";	
	xmlStr			+= " SELECT=\""+ SELECT + "\" ";	
	xmlStr			+= " mfr_remarks=\""+ mfr_remarks + "\" ";
	xmlStr			+= " DISP_LOCN_CODE=\""+ disp_locn_code + "\" ";
	xmlStr			+= " DISP_LOCN_TYPE=\""+ disp_locn_type + "\" ";
	xmlStr			+= " PER_FACILITY_ID=\""+ facility_id + "\" ";
	xmlStr			+= " INFUSE_OVER_UNIT=\""+ infuse_over_unit + "\" ";
	xmlStr			+= " priority=\""+ priority + "\" ";
	xmlStr			+= " height=\""+ height + "\" ";
	xmlStr			+= " height_uom=\""+ height_unit + "\" ";
	xmlStr			+= " weight=\""+ weight + "\" ";
	xmlStr			+= " weight_uom=\""+ weight_unit + "\" ";
	xmlStr			+= " bsa=\""+ bsa + "\" ";
	xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";
	xmlStr			+= " bmi=\""+ bmi + "\" ";
	xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";
	xmlStr			+= " take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr			+= " ROOM_NUM=\""+ room_num + "\" ";
	xmlStr			+= " BED_NUM=\""+ bed_num + "\" ";
	xmlStr			+=  " /></root>";
	var qryString	= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&validate=completeIVRxDetails&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date1+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&patient_class="+patient_class+"&sys_date="+sys_date;	
	submitXML(qryString, xmlStr);
	$("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
	setTimeout(function() {
		$("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
		function(res) {                    
        });
	}, 1000);
}

function validateRate1(rate,volume,infuse_over,duration,InfusionRateUnit,infusion_period_value, iv_calc_infuse_by){
	var temp = "0";
	var calDuration = duration.value;
	if(InfusionRateUnit.value == "M")
		calDuration = calDuration * 60;

	if(rate.value != null && rate.value != "" && parseFloat(rate.value) != 0 ){
		temp = parseFloat(volume.value)/parseFloat(rate.value);
		if(iv_calc_infuse_by=='I' && InfusionRateUnit.value == "M") //if block added for AAKH-SCF-0119 [IN:049629]
			temp = temp/60;
		temp = Math.round(temp*100)/100;
	}
	
	if(iv_calc_infuse_by!='I' && parseInt(rate.value) > parseInt(volume.value)) {
		var msg = "Infusion rate cannot be greater than volume";
		showToastMsg(msg);
		//rate.focus();
		rate.select();
		return false;
	}	
		return true;
}
function allowValidNumber(fld, e, maxInt, deci) {
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
                    $("#rxDosageByVal").val(fld.value);
                }
            }
        } else if (count > maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');            
            if ((objectValue.charAt(maxInt)) != '.') {
                if (dotOccurance == -1 && parseInt(deci) > 0) {
                    fld.value = objectValue.substring(0, maxInt) + ".";
                    $("#ivRxInfusionRate").val(fld.value);
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
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1) return false; // Not a valid key
    else if (key == "-" && fldValue.indexOf(key) != -1) {
        if (fldValue.indexOf(key) != 1)
            return false
    }
    return true;
}

function validateRate(rate, volume1, duration) {
    var infusionOverStr = ""; //"["+ 12+" Hrs "+ 56 + " Mins]";
    var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value
    if (parseFloat(rate.value) > 0 && rate.value != "") {
        var infusion_value = rate.value;
        var volume = volume1;
        var unit = document.rxDetailsIvRxWaViewForm.ivRxInfusionDpList.value;
        if (unit == "H") {
            infusion_value = volume * 60 / infusion_value;
        } else {
            infusion_value = volume / infusion_value;
        }
        infusion_value = infusion_value / 60;
        infusion_value = Math.round(infusion_value * 100) / 100;
        HrsMinStr = getHrsMinStr(infusion_value, unit);
		document.rxDetailsIvRxWaViewForm.infusion_over_insert_value.value = infusion_value;
        infusionOverStr = HrsMinStr;
        hrs = HrsMinStr.substring(1, HrsMinStr.indexOf("H") - 1);
        min = HrsMinStr.substring(HrsMinStr.indexOf("H") + 4, HrsMinStr.indexOf("M") - 1);
        document.rxDetailsIvRxWaViewForm.ivRxInfusionOverHrs.value = Math.floor(hrs);
        document.rxDetailsIvRxWaViewForm.ivRxInfusionOverMins.value = Math.round(min);
        if (duration > 0 && parseFloat(infusion_value) > duration && iv_calc_infuse_by != 'I') {
            showToastMsg("Duration cannot be less than Infuse over");
            $("#ivRxVolumeUnit").val();
            $("#ivRxInfusionOverHrs").val();
            $("#ivRxInfusionOverMins").val();
            return false;
        }
    }
}

function calculateRate(obj, volume1, infusion_rate, infusionOverStr) {
    var Infovr = parseFloat(obj);
    var unit = document.rxDetailsIvRxWaViewForm.ivRxInfusionDpList.value;
    var volume = volume1;
    var infusion_period_value = document.rxDetailsIvRxWaViewForm.ivRxInfusionOverHrs.value;
    var infusion_period_value_min = document.rxDetailsIvRxWaViewForm.ivRxInfusionOverMins.value;
    var duration = document.rxDetailsIvRxWaViewForm.ivRxDurationForRepeat.value;
    if (((parseFloat(infusion_period_value) != 0 && infusion_period_value != "") || (parseFloat(infusion_period_value_min) != 0 && infusion_period_value_min != "")) && volume != "" && parseFloat(volume) != 0) {
        if (infusion_period_value_min < 60) {
            var InfuseOverInMin = getInfuseOverInMin(infusion_period_value, infusion_period_value_min);
            var InfuseOverInHr = parseFloat(InfuseOverInMin / 60);
            var total_hr = duration;
            total_hr = parseInt(total_hr) * 60;
            if (total_hr != 0 && parseFloat(total_hr) < parseFloat(InfuseOverInMin)) {
                var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value;
                if (iv_calc_infuse_by != 'I')
                    showToastMsg("Duration cannot be less than Infuse over");
                $("#ivRxInfusionOverHrs").val();
                $("#ivRxInfusionOverMins").val();
                return false;
            }
            InfuseOverInHr = Math.round(InfuseOverInHr * 100) / 100;
            if (volume == "" || volume == 0) {
                showToastMsg("Volume cannot be blank or zero");                
                return false;
            } else {
                if (unit == "H")
                    var infusion_value = (volume) * 60 / (InfuseOverInMin);
                else
                    var infusion_value = (volume) / (InfuseOverInMin);
				document.rxDetailsIvRxWaViewForm.infusion_over_insert_value.value = InfuseOverInHr;                
                infusion_value = Math.round(infusion_value * 100) / 100;                
                $("#ivRxInfusionRate").val(infusion_value);                
            }
        }
    } else {
        showToastMsg("Infusion over cannot be blank or zero");
        return false;
    }
}

function validateDuration(duration, infuse_over, infusionRateUnit, infusion_period_value_min, iv_calc_infuse_by) {
    var total_hr = duration;
    if (infusionRateUnit == 'M')
        total_hr = parseFloat(total_hr) * 60;
    else
    if (parseFloat(infuse_over) > parseInt(duration)) {
        showToastMsg("Duration cannot be less than Infuse over");
        return false;
    } else if (parseInt(infuse_over) > 24 && iv_calc_infuse_by != 'I') {
        showToastMsg("Infusion over cannot be greater than 24 hours");
        return false;
    } else {
        var total_hr = duration;
        total_hr = parseInt(total_hr) * 60;
        infuseOver = getInfuseOverInMin(infuse_over, infusion_period_value_min);
        if (total_hr > 0 && parseInt(total_hr) < parseInt(infuseOver)) {
            showToastMsg("Duration cannot be less than Infuse over");
            return false;
        }
    }
}

function strtEndDateTime() {
    var form = document.rxDetailsIvRxWaViewForm;
    var fld_code = "234"; 
    if (fld_code != "") {
        duration = eval("form.ivRxDurationForRepeat").value;
        end_dateObj = eval("form.ivRxEndDate");
        end_dateVal = eval("form.ivRxEndDate").value;
        strt_date = eval("form.ivRxStartDate");        
        durn_unit = "H";       
        chkDurationAD(duration);
    }
}

function chkDurationAD(obj) {
    var frmObj = document.rxDetailsIvRxWaViewForm;
    var start_date_chk = eval("frmObj.ivRxStartDate").value;
    var locale = document.rxDetailsIvRxWaViewForm.language_id.value;
    if (start_date_chk != "") {
        var back_date = document.rxDetailsIvRxWaViewForm.back_date.value;
        var future_date = document.rxDetailsIvRxWaViewForm.future_date.value;
        var end_date = eval("frmObj.ivRxEndDate").value;
        if (validDate(start_date_chk, "DMYHM", locale)) {
            if (future_date != null && future_date != 'null' && future_date != "0" && future_date != "") {
                if (!isBefore(start_date_chk, future_date, "DMYHM", locale)) {
                    showToastMsg("Current start date does not satisfy the parameter range");
                    var startDatepicker = $("#ivRxStartDate").data("kendoDateTimePicker");
                    startDatepicker.value(new Date());
                    return false;
                }
            }
            if (back_date != null && back_date != 'null' && back_date != "0" && back_date != "") {
                if (!isAfter(start_date_chk, back_date, "DMYHM", locale)) {
                    showToastMsg("Current start date does not satisfy the parameter range");
                    var startDatepicker = $("#ivRxStartDate").data("kendoDateTimePicker");
                    startDatepicker.value(new Date());
                    return false;
                }
            }
        } else {
            showToastMsg("Invalid date time format");
            var startDatepicker = $("#ivRxStartDate").data("kendoDateTimePicker");
            startDatepicker.value(new Date());
            return false;
        }
    } else {
        showToastMsg("Start date cannot be blank");
        var startDatepicker = $("#ivRxStartDate").data("kendoDateTimePicker");
        startDatepicker.value(new Date());
        return false;
    }
    var fields = new Array();
    var names = new Array();
    fields[0] = eval("frmObj.ivRxStartDate");
    names[0] = "Start Date";
    var cont_flag = false;
    var durn_unit = "H";
    if (checkFlds(fields, names)) {
        if (obj != "0" && obj != "") {
            cont_flag = true;
            durn_value = obj;
        }
        if (obj == undefined) {
            durn_value = 0;
        }
        if (cont_flag) {
            var iv_calc_infuse_by = document.rxDetailsIvRxWaViewForm.iv_calc_infuse_by.value;
            if (iv_calc_infuse_by == 'I') {
                var durnHrs = eval("frmObj.ivRxInfusionOverHrs").value;
                var durnMins = eval("frmObj.ivRxInfusionOverMins").value;
                if (trimString(durnHrs) == "")
                    durnHrs = '0';
                if (trimString(durnMins) == "")
                    durnMins = '0';
                durn_unit = "M";
                durn_value = (parseInt(durnHrs) * 60) + parseInt(durnMins)
            }
            var start_date = eval("frmObj.ivRxStartDate").value;
            var bean_id = frmObj.bean_id.value;
            var bean_name = frmObj.bean_name.value;
            var qryString = bean_id + "&bean_name=" + bean_name + "&validate=POPULATEENDDATEAD&start_date=" + start_date + "&durn_value=" + durn_value + "&durn_unit=" + durn_unit;
            submitXML(qryString, "");
        }
    } else {
        return false;
    }
}

function setEndDate(end_date, obj) {
    document.rxDetailsIvRxWaViewForm.ivRxEndDate.value = end_date;
}

function getInfuseOverInMin(hr, mi) {
    if (hr == "")
        hr = 0;
    if (mi == "")
        mi = 0;
    tot = parseFloat(hr * 60) + parseFloat(mi);
    return tot;
}

function getHrsMinStr(HMvalue, HMunit) {
    hrs = Math.floor(HMvalue);
    HMvalue = HMvalue * 60;
    min = HMvalue % 60;
    return ('[' + Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]');
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

function checkFlds(fields, names) {
    var errors = "";
    for (var i = 0; i < fields.length; i++) {
        if (trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        } else errors = errors + "APP-000001 " + names[i] + " " + "Cannot be blank" + " " + "\n";
    }
    if (errors.length != 0) {
        alert(errors);
        return false;
    }
    return true;
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
function mandateRemarks(){
	
}

//common for calling TEMP JSP for Validations
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

    xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/prescriptionIvRxWaValidation.jsp?bean_id=" + qryString, false);
    xmlHttpObj.send(xmlDoc);
    return true;
}

/*orientation change */
    if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',orientationChangeIVRXWithoutAdd, false);
	}
    function orientationChangeIVRXWithoutAdd() {
    	setTimeout(function() {
    	    if (Math.abs(window.orientation) === 90) {
       	 	 pharmIvRxWADetailsScroller.refresh();
    	    } else {
       	 	 pharmIvRxWADetailsScroller.refresh();
    	    } 	 
        }, 1500);
    }
