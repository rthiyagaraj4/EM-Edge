
var mode; //Record or Modify

//Combo box datasource
var diagSetDataSrc;
var diagClassDataSrc;
var diagComplaintsDataSrc;
var diagAccuracyDataSrc;
var diagAnatomicalDataSrc;
var diagApplSideDataSrc;

//Combo & MultiSelect Objects
var diagSetCombo;
var diagClassCombo; //values depend on diagnosisSetId
var diagComplaintMulSel; //values depend on diagnosisSetId 
var diagAccuracyCombo; 
var diagAnatomicalCombo; //value depends on Anatomical Site selection OralCavity/Others
var diagApplSideCombo; //values Left-L, Right-R, Both-B, Not Applicable-N

// Date objects and date picker objects
var patDOB;
var today;
var onsetDTPicker;
var asOnDPicker;

var modifyPrimDiagnosis = false; //This variable is used in modify usecase to track whether currently modified diagnosis is a Primary Diagnosis


function cancelTransaction(){
	var cspath = path + "/mobile/chartsummary/ChartWidgetsView";
	window.parent.document.getElementById('ChartSummaryIframe').src = cspath;
}

function openComplaintsFrame(){
	$("#DiagnosisSwitch").removeClass("flipButtonActiveTheme").addClass("flipButtonInActiveTheme");
	$("#ComplaintsSwitch").removeClass("flipButtonInActiveTheme").addClass("flipButtonActiveTheme");
	var targpath = path + "/mobile/chartsummary/RecordComplaintView";
	window.parent.document.getElementById('ChartSummaryIframe').src = targpath;
}

function StringToDate(string){
	var d = new Date();
	//var str='01/07/2013 11:18:13';
	var datenum,month,year;
	var hr=0, min=0, sec=0;
	var datetimearr = string.split(" ");
	if(datetimearr[0]){
		var datearr = datetimearr[0].split("/");
		if(datearr[0])
			datenum = parseInt(datearr[0]);
		if(datearr[1])
			month = parseInt(datearr[1]);
		if(datearr[2])
			year = parseInt(datearr[2]);
	}
	if(datetimearr[1]){
		var timearr = datetimearr[1].split(":");
		if(timearr[0])
			hr = parseInt(timearr[0]);
		if(timearr[1])
			min = parseInt(timearr[1]);
		if(timearr[2])
			sec = parseInt(timearr[2]);
	}
	
	d.setDate(datenum);
	d.setMonth(month-1);
	d.setFullYear(year);
	//if(hr!=0)
	d.setHours(hr);
	//if(min!=0)
	d.setMinutes(min);
	//if(sec!=0)
	d.setSeconds(sec);
	return d;
}

function twoDigits(num){
	if(num<10)
		num = "0" + num;
	return num;
}

function DMYHMSToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45:06
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes()) + ":" + twoDigits(d.getSeconds());
	return stringDate;
}

function DMYHMToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes());
	return stringDate;
}

function DMYToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear());
	return stringDate;
}

function showHideAllOtherFields(){
	if(diagSetCombo.selectedIndex >= 0){
		showLoadAllOtherFields();
		document.getElementById("hdnDiagSet").value = diagSetCombo.value();
	}
	else{
		diagSetCombo.value("");
		document.getElementById("hdnDiagSet").value = "";
		hideUnLoadAllOtherFields();
	}
}

function showHideAllOtherFieldsForModify(){
	if(diagSetCombo.selectedIndex >= 0){
		showLoadAllOtherFieldsForModify();
		document.getElementById("hdnDiagSet").value = diagSetCombo.value();
	}
	else{
		diagSetCombo.value("");
		document.getElementById("hdnDiagSet").value = "";
		hideUnLoadAllOtherFields();
	}
}

function validate(field){
	var result=true;
	if($(field).attr("id") == "AsOnDate"){
		result = validateAsOnDate(field);
	}
	if($(field).attr("id") == "OnsetDate"){
		result = validateOnsetDate(field);
	}

	if(result){
		hideWarningDialog(field);
	}
	else{
		showWarningDialog(field);
	}
	return result;
}

function validateOnsetDate(field){
	var calendar = $("#OnsetDate").data("kendoDateTimePicker");
	var selected = calendar.value();
	if(selected>=patDOB && selected<=today){
		return true;
	}
	else{
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		calendar.value(today);
		return false;
		
	}
}

function validateAsOnDate(field){
	var onsetCal = $("#OnsetDate").data("kendoDateTimePicker");
	var onsetDate = onsetCal.value();
	//since activeSinceDate contains only date and no time we set onset date's time to O,else if both dates are same the validation will not pass
	onsetDate.setHours(0);
	onsetDate.setMinutes(0);
	onsetDate.setSeconds(0);
	var activeSinceCal = $("#AsOnDate").data("kendoDatePicker");
	var activeSinceDate = activeSinceCal.value();
	if(activeSinceDate<=today && activeSinceDate>=onsetDate){
		return true;
	}
	else{
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		activeSinceCal.value(today);
		return false;
	}
}

function setWarningMessage(field,errmsg){
	var id= $(field).attr("id");
	$("#"+id+"_WarningMsg").html(errmsg);
}

function showWarningDialog(field){
	var id= $(field).attr("id");
	$("#"+id+"_Warning").show();
	$("#"+id+"_Warning").bind('click',function(){
		$(this).hide();
	});
	//hide after 5 secs
	setTimeout(function() {
		$("#"+id+"_Warning").hide();
	}, 5000);
	
}

function hideWarningDialog(field){
	var id= $(field).attr("id");
	$("#"+id+"_Warning").hide();
}

function validateAndRecordDiagnosis(){
	var mandatoryValPassed = true;
	var diagCodeValPassed = true;
	var primDiagValPassed = true;
	var onsetDateValPassed = true;
	var asOnDateValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","#44484A");
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	
	
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_EXISTS&DiagCode="+$("#hdnDiagCode").val()+"&DiagSetId="+$("#hdnDiagSet").val(), function(data){
		result = data.validationResult;
		var diagCodefield = document.getElementById("hdnDiagCode");
		if(result==0){
			var errMsg = $(diagCodefield).data("errmsg1");
			setWarningMessage(diagCodefield,errMsg);
			showWarningDialog(diagCodefield);
			diagCodeValPassed = false;
		}
		diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
		var index = diagClassCombo.select();
		//if(){
			
			if(selDiagType == 'PD' && index >= 0){
				var selDiagType = diagClassDataSrc.diagClassificationList[index].type;
				$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_PRIMEXISTS&DiagSetId="+$("#hdnDiagSet").val(), function(data){
					result = data.validationResult;
					var diagClassField = document.getElementById("cmbDiagClass");
					if(result==0){
						var errMsg = $(diagClassField).data("errmsg1");
						setWarningMessage(diagClassField,errMsg);
						showWarningDialog(diagClassField);
						diagClassCombo.value("");
						primDiagValPassed = false;
						
					}
					else{
						asOnDateValPassed = validate($("#AsOnDate"));
						if(asOnDateValPassed){
							hideWarningDialog($("#AsOnDate"));
						}
						else{
							showWarningDialog($("#AsOnDate"));
						}
						onsetDateValPassed = validate($("#OnsetDate"));
						if(onsetDateValPassed){
							hideWarningDialog($("#OnsetDate"));
						}
						else{
							showWarningDialog($("#OnsetDate"));
						}
						if(mandatoryValPassed && diagCodeValPassed && primDiagValPassed && asOnDateValPassed && onsetDateValPassed){
							var calendar;
							var selected;
							calendar = $("#OnsetDate").data("kendoDateTimePicker");
							selected = calendar.value();
							$("#hdnOnsetDateTime").val(DMYHMToString(selected));
							calendar = $("#AsOnDate").data("kendoDatePicker");
							selected = calendar.value();
							$("#hdnAsOnDate").val(DMYToString(selected));
							$('#frmRecordDiag').submit();
						}
					}
				});
			}
			else{
				asOnDateValPassed = validate($("#AsOnDate"));
				if(asOnDateValPassed){
					hideWarningDialog($("#AsOnDate"));
				}
				else{
					showWarningDialog($("#AsOnDate"));
				}
				onsetDateValPassed = validate($("#OnsetDate"));
				if(onsetDateValPassed){
					hideWarningDialog($("#OnsetDate"));
				}
				else{
					showWarningDialog($("#OnsetDate"));
				}
				if(mandatoryValPassed && diagCodeValPassed && asOnDateValPassed && onsetDateValPassed){
					var calendar;
					var selected;
					calendar = $("#OnsetDate").data("kendoDateTimePicker");
					selected = calendar.value();
					$("#hdnOnsetDateTime").val(DMYHMToString(selected));
					calendar = $("#AsOnDate").data("kendoDatePicker");
					selected = calendar.value();
					$("#hdnAsOnDate").val(DMYToString(selected));
					$('#frmRecordDiag').submit();
				}
			}
		//}
		
	});
}

function validateAndModifyDiagnosis(){
	var mandatoryValPassed = true;
	//var diagCodeValPassed = true;
	var primDiagValPassed = true;
	//var onsetDateValPassed = true;
	var asOnDateValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","#44484A");
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
	var index = diagClassCombo.select();
	//if(){
		
		if(selDiagType == 'PD'  && !modifyPrimDiagnosis && index >= 0){
			var selDiagType = diagClassDataSrc.diagClassificationList[index].type;
			$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_PRIMEXISTS&DiagSetId="+$("#hdnDiagSet").val(), function(data){
				result = data.validationResult;
				var diagClassField = document.getElementById("cmbDiagClass");
				if(result==0){
					var errMsg = $(diagClassField).data("errmsg1");
					setWarningMessage(diagClassField,errMsg);
					showWarningDialog(diagClassField);
					diagClassCombo.value("");
					primDiagValPassed = false;
					
				}else{
					asOnDateValPassed = validate($("#AsOnDate"));
					if(asOnDateValPassed){
						hideWarningDialog($("#AsOnDate"));
					}
					else{
						showWarningDialog($("#AsOnDate"));
					}
					if(mandatoryValPassed && primDiagValPassed && asOnDateValPassed){
						$('#frmModifyDiag').submit();
					}
				
				}
			});
		}
		else{
			asOnDateValPassed = validate($("#AsOnDate"));
			if(asOnDateValPassed){
				hideWarningDialog($("#AsOnDate"));
			}
			else{
				showWarningDialog($("#AsOnDate"));
			}
			if(mandatoryValPassed && asOnDateValPassed){
				$('#frmModifyDiag').submit();
			}
		}
	//}
}

function validateDuplicatePrimaryDiag(field){
	diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
	var index = diagClassCombo.select();
	if(mode == "RECORD"){
		if(index >= 0){
			var selDiagType = diagClassDataSrc.diagClassificationList[index].type;
			if(selDiagType == 'PD'){
				$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_PRIMEXISTS&DiagSetId="+$("#hdnDiagSet").val(), function(data){
					result = data.validationResult;
					if(result==0){
						var errMsg = $(field).data("errmsg1");
						setWarningMessage(field,errMsg);
						showWarningDialog(field);
						diagClassCombo.value("");
						//return false;
					}
				}); 
			}
		}
	}
	//In modify case, If the selected diagnosis is Primary then we would not need this validation
	//since a PD can be chosen again
	else{
		if(index >= 0 && !modifyPrimDiagnosis){
			var selDiagType = diagClassDataSrc.diagClassificationList[index].type;
			if(selDiagType == 'PD'){
				$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_PRIMEXISTS&DiagSetId="+$("#hdnDiagSet").val(), function(data){
					result = data.validationResult;
					if(result==0){
						var errMsg = $(field).data("errmsg1");
						setWarningMessage(field,errMsg);
						showWarningDialog(field);
						diagClassCombo.value("");
						//return false;
					}
				}); 
			}
		}
	}
	//alert(diagClassCombo.value());
}

function showLoadAllOtherFields(){
	clearAllOtherFields();
	$("#RDAllOtherFields").show();
	
	diagSetCombo = $("#cmbDiagSet").data("kendoComboBox");
	var applFields = diagSetDataSrc.diagnosisSetList[diagSetCombo.selectedIndex].applicableFields;
	
	//Check if free text is allowed for diagnosis description. Allow 'txtDiagDesc' for modification to enter *OTH diagnosis
	var freeText = diagSetDataSrc.diagnosisSetList[diagSetCombo.selectedIndex].freeTextDiagnosis;
	if(freeText){
		$("#txtDiagDesc").removeAttr('readonly');
		
	}
	else{
		$("#txtDiagDesc").attr('readonly','readonly');
		$("#txtDiagDesc").change(function() {
			diagCodeOthers();
		});
	}
	//Format of CSV: priority=nature=severity=onset_type=factors=notification=enc_stage
	var applFieldsArr = applFields.split("=");
	if(applFieldsArr[0] == "Y"){
		$("#PriorityFieldWrap").show();
		$('#PrioritySlidePointer').sliderGenericControl();
	}
	else{
		$("#PriorityFieldWrap").hide();
		$("#hdnPriority").val('');
	}
	if(applFieldsArr[1] == "Y"){
		$("#NatureFieldWrap").show();
		$('#NatureSlidePointer').sliderGenericControl();
	}
	else{
		$("#NatureFieldWrap").hide();
		$("#hdnNature").val('');
	}
	if(applFieldsArr[2] == "Y"){
		$("#SeverityFieldWrap").show();
		$('#SeveritySlidePointer').sliderGenericControl();
	}
	else{
		$("#SeverityFieldWrap").hide();
		$("#hdnSeverity").val('');
	}
	if(applFieldsArr[3] == "Y"){
		$("#OnsetTypeFieldWrap").show();
		$('#OnsetTypeSlidePointer').sliderGenericControl();
	}
	else{
		$("#OnsetTypeFieldWrap").hide();
		$("#hdnOnsetType").val('');
	}
	if(applFieldsArr[6] == "Y"){
		$("#EncounterStageFieldWrap").show();
		$('#EncStageSlidePointer').sliderGenericControl();
	}
	else{
		$("#EncounterStageFieldWrap").hide();
		$("#hdnEncStage").val('');
	}
	$('#AnatomicalSlidePointer').sliderGenericControl();
	
	scrollRefresh();
	populateDiagnosisClassCombo();
	populateDiagnosisComplCombo();

}
function showLoadAllOtherFieldsForModify(){
	$("#RDAllOtherFields").show();
	
	diagSetCombo = $("#cmbDiagSet").data("kendoComboBox");
	var applFields = diagSetDataSrc.diagnosisSetList[diagSetCombo.selectedIndex].applicableFields;
	
	//Format of CSV: priority=nature=severity=onset_type=factors=notification=enc_stage
	var applFieldsArr = applFields.split("=");
	if(applFieldsArr[0] == "Y"){
		$("#PriorityFieldWrap").show();
		$('#PrioritySlidePointer').sliderGenericControl();
	}
	else{
		$("#PriorityFieldWrap").hide();
		//$("#hdnPriority").val('');
	}
	if(applFieldsArr[1] == "Y"){
		$("#NatureFieldWrap").show();
		$('#NatureSlidePointer').sliderGenericControl();
	}
	else{
		$("#NatureFieldWrap").hide();
		//$("#hdnNature").val('');
	}
	if(applFieldsArr[2] == "Y"){
		$("#SeverityFieldWrap").show();
		$('#SeveritySlidePointer').sliderGenericControl();
	}
	else{
		$("#SeverityFieldWrap").hide();
		//$("#hdnSeverity").val('');
	}
	if(applFieldsArr[3] == "Y"){
		$("#OnsetTypeFieldWrap").show();
		$('#OnsetTypeSlidePointer').sliderGenericControl();
	}
	else{
		$("#OnsetTypeFieldWrap").hide();
		//$("#hdnOnsetType").val('');
	}
	if(applFieldsArr[6] == "Y"){
		$("#EncounterStageFieldWrap").show();
		$('#EncStageSlidePointer').sliderGenericControl();
	}
	else{
		$("#EncounterStageFieldWrap").hide();
		//$("#hdnEncStage").val('');
	}
	$('#AnatomicalSlidePointer').sliderGenericControl();
	
	scrollRefresh();
	populateDiagnosisClassCombo();
	populateDiagnosisComplComboForModify();
	
}
function hideUnLoadAllOtherFields(){
	$("#RDAllOtherFields").hide();
	
	clearAllOtherFields();
	
}
function clearAllOtherFields(){
	//Diagnosis code and description
	$("#hdnDiagCode").val('');
	$("#DiagCodeField").empty();
	/* $("#hdnDiagDesc").val(''); */
	$("#txtDiagDesc").val('');
	
	//Combo & Multiselect
	diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
	diagComplaintMulSel = $("#mulComplaints").data("kendoMultiSelect");
	diagAccuracyCombo = $("#cmbAccuracy").data("kendoComboBox");
	diagAnatomicalCombo = $("#cmbAnatSite").data("kendoComboBox");
	diagApplSideCombo = $("#cmbApplSide").data("kendoComboBox");
	diagClassCombo.value('');
	diagComplaintMulSel.value('');
	diagAccuracyCombo.value('');
	diagAnatomicalCombo.value('');
	diagApplSideCombo.value('');
	
	//Sliders
	$("#hdnEncStage").val('A').trigger("change");
	$("#hdnNature").val('A').trigger("change");
	$("#hdnSeverity").val('D').trigger("change");
	$("#hdnPriority").val('N').trigger("change");
	$("#hdnOnsetType").val('N').trigger("change");
	$("#hdnAnatomicalSite").val('O').trigger("change");
	
	$("#txtRemarks").val("");
}


function populateDiagnosisClassCombo(){
	var diagClassUrl = path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_CLASS&DiagSetId="+diagSetCombo.value();
	diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_CLASS&DiagSetId="+diagSetCombo.value(),function(data){
		diagClassDataSrc = data;
		diagClassCombo.setDataSource(diagClassDataSrc.diagClassificationList);
		//In Modify usecase check if selected diag is already a primary diagnosis, If yes, then a primary diagnosis is allowed to be chosen without any validation
		if(mode == "MODIFY"){
			var existVal = $("#hdnDiagClass").val();
			diagClassCombo.value(existVal);
			var index = diagClassCombo.select();
			if(index>=0){
				var selDiagType = diagClassDataSrc.diagClassificationList[index].type;
				if(selDiagType == 'PD'){
					modifyPrimDiagnosis = true;
				}
			}
		}
		
	});
}

function populateDiagnosisComplCombo(){
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_COMPL&DiagSetId="+diagSetCombo.value(),function(data){
		diagComplaintMulSel = $("#mulComplaints").data("kendoMultiSelect");
		diagComplaintsDataSrc = data;
		diagComplaintMulSel.setDataSource(diagComplaintsDataSrc.complaintsList);
	});
}

function populateDiagnosisComplComboForModify(){
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_COMPLEXIST&DiagSetId="+diagSetCombo.value()+"&DiagCode="+$("#hdnDiagCode").val()+"&OccurSrlNo="+$("#hdnOccurSrlNo").val(),function(data){
		diagComplaintMulSel = $("#mulComplaints").data("kendoMultiSelect");
		diagComplaintsDataSrc = data;
		diagComplaintMulSel.setDataSource(diagComplaintsDataSrc.complaintsList);
		diagComplaintMulSel.value(diagComplaintsDataSrc.selectedComplaints);
		var value = diagComplaintMulSel.value();
        var complStr = "";
        for(var i=0; i<value.length;i++){
        	complStr = complStr+value[i]+"$";
        }
        $("#hdnDiagCompl").val(complStr);
	});
}

function populateAnatomicalCombo(){
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_ANAT&OralCavity="+$("#hdnAnatomicalSite").val(),function(data){
		diagAnatomicalCombo = $("#cmbAnatSite").data("kendoComboBox");
		diagAnatomicalDataSrc = data;
		diagAnatomicalCombo.setDataSource(diagAnatomicalDataSrc.diagAnatomicalSiteList);
	});
}

function populateDiagAccuracyCombo(){
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_ACC", function(data){
		diagAccuracyDataSrc = data;
		diagAccuracyCombo.setDataSource(diagAccuracyDataSrc.diagAccuracyList);
		if(mode == "RECORD" && diagAccuracyDataSrc.defaultValue){
			 //set the default value
			diagAccuracyCombo.value(diagAccuracyDataSrc.defaultValue);
			document.getElementById("hdnDiagAcc").value = diagAccuracyDataSrc.defaultValue;
			var selected = diagAccuracyCombo.select();
			var accInd = diagAccuracyDataSrc.diagAccuracyList[selected].accInd;
			$("#hdnDiagAccInd").val(accInd);
		}
		else{
			//set the existing value
			var selDiagAcc = document.getElementById("hdnDiagAcc").value;
			diagAccuracyCombo.value(selDiagAcc);
		}
		
	});
}

function populateDiagSetCombo(){
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAGNOSIS_SET", function(data){
		 diagSetDataSrc = data;
		 //alert(JSON.stringify(diagAccuracyDataSrc));
		 diagSetCombo.setDataSource(diagSetDataSrc.diagnosisSetList);
		 if(mode == "RECORD"){
			 //set the default diagnosis set value
			 if(diagSetDataSrc.defaultValue){
				 diagSetCombo.value(diagSetDataSrc.defaultValue);
				 document.getElementById("hdnDiagSet").value = diagSetDataSrc.defaultValue;
			 }
			 showHideAllOtherFields();
		 }
		 else{
			 //set the selected diagnosis set value
			 var selDiagSet = document.getElementById("hdnDiagSet").value;
			 diagSetCombo.value(selDiagSet);
			 diagSetCombo.readonly(true);
			 showHideAllOtherFieldsForModify();
		 }
		 	
		
	});
}

//when the value inside description box is changed manually, then the diagnosis code becomes *OTH
function diagCodeOthers(){
	$("#hdnDiagCode").val('*OTH');
	$("#DiagCodeField").html('*OTH');
	/* $("#hdnDiagDesc").val(desc); 
	$("#txtDiagDesc").text(desc);*/
}

function showDiagnosisSfs(){
	showMezzaineWindow();
	$('#sfs').css("display","block");
	$("#dvMez").data("popid","sfs");
	var sfspath = path+"/mobile/chartsummary/ProblemsDiagnosisSFS?SfsType=DIAGNOSIS&TermSetId="+diagSetCombo.value();
	document.getElementById("sfsFrame").src = sfspath;
}

function showMezzaineWindow()
{
	$('#dvMez').css("display","block");
	setTimeout(function() {
		$("#dvMez").on("click",closeMezzaineWindow);
	}, 500);
}

function closeMezzaineWindow()
{
	$('#dvMez').css("display","none");
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").data("popid","");
	$("#dvMez").off();
};

function sfsCancel()
{
	closeMezzaineWindow();
	$('#sfs').css("display","none");
	$("#dvMez").data("popid","");
	document.getElementById("sfsFrame").src = "";
}

function authorizeUser(){
    //datastring = $("#problemsDiagnosisForm").serialize();
    var pwd = $("#SensitiveDataPwd").val();
    //alert(datastring);
    $.ajax({
            type:'POST', 
            url: path+"/mobile/chartsummary/AuthorizeSensitiveDiagnosis", 
            data: {"SensitiveDataPwd":pwd},
            success: function(response) {
                //alert("Success " + response);
				var trimResponse = $.trim(response);
                if(trimResponse.valueOf()=='SUCCESS'){
                	parent.closeAuthorizePrompt();
                	selectDiagnosis();
                }
                else{
                	parent.showPwdValError();
                }
			},
			error: function (xhr, ajaxOptions, thrownError) {
				parent.showPwdValError();
			}
			//end ajax options
    });//end ajax
    return false;
}

function openAuthorizePrompt(){
	parent.openAuthorizePrompt();
}

function selectDiagnosis(){
	var code = $('#sfsFrame').contents().find('#hdnSelectedDiagCode').val();
	var desc = $('#sfsFrame').contents().find('#hdnSelectedDiagDesc').val();
	$("#hdnDiagCode").val(code);
	$("#DiagCodeField").html(code);
	/* $("#hdnDiagDesc").val(desc); */
	//$("#txtDiagDesc").text(desc);
	$("#txtDiagDesc").val(desc);
	sfsCancel();
}
function openDiagnosisFrame(){
	$("#DiagnosisSwitch").removeClass("flipButtonInActiveTheme").addClass("flipButtonActiveTheme");
	$("#ComplaintsSwitch").removeClass("flipButtonActiveTheme").addClass("flipButtonInActiveTheme");
	var targpath = path + "/mobile/chartsummary/RecordDiagnosisView";
	window.parent.document.getElementById('ChartSummaryIframe').src = targpath;
	
}


function selectComplaint(){
	var code = $('#sfsFrame').contents().find('#hdnSelectedComplCode').val();
	var desc = $('#sfsFrame').contents().find('#hdnSelectedComplText').val();
	$("#hdnComplCode").val(code);
	$("#ComplCodeField").html(code);
	$("#txtComplDesc").val(desc);
	sfsCancel();
}
function showComplaintSfs(){
	showMezzaineWindow();
	$('#sfs').css("display","block");
	$("#dvMez").data("popid","sfs");
	var sfspath = path+"/mobile/chartsummary/ProblemsDiagnosisSFS?SfsType=COMPLAINT";
	document.getElementById("sfsFrame").src = sfspath;
}

function validateAndRecordComplaint(){
	var mandatoryValPassed = true;
	var complCodeValPassed = true;
	var onsetDateValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","#44484A");
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=COMPL_EXISTS&ComplaintCode="+$('#hdnComplCode').val(), function(data){
		result = data.validationResult;
		var complCodefield = document.getElementById("hdnComplCode");
		if(result==0){
			var errMsg = $(complCodefield).data("errmsg1");
			setWarningMessage(complCodefield,errMsg);
			showWarningDialog(complCodefield);
			complCodeValPassed = false;
		}
		onsetDateValPassed = validate($("#OnsetDate"));
		if(mandatoryValPassed && complCodeValPassed && onsetDateValPassed){
			var calendar;
			var selected;
			calendar = $("#OnsetDate").data("kendoDateTimePicker");
			selected = calendar.value();
			$("#hdnOnsetDateTime").val(DMYHMToString(selected));
			//alert("validations passed");
			$("#frmRecordCompl").submit();
		}
	});
}

function validateAndModifyComplaint(){
	var mandatoryValPassed = true;
	//var complCodeValPassed = true;
	var onsetDateValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","#44484A");
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	onsetDateValPassed = validate($("#OnsetDate"));
	if(mandatoryValPassed && onsetDateValPassed){
		//alert("validations passed");
		$("#frmModifyCompl").submit();
	}

}

function markAsError(chkObj){
	var objId = $(chkObj).attr("id");
	var checkVal = $(chkObj).prop("checked");
	if(checkVal){
		$("#ErrorRemarksFieldWrap").show();
		//$("#txtErrRemarks").data("mandatory","true");
		$("#txtErrRemarks").attr('data-mandatory', 'true');
		$("#hdnErrorYN").val("Y");
		scrollRefresh();
	}
	else{
		$("#ErrorRemarksFieldWrap").hide();
		$("#txtErrRemarks").attr('data-mandatory', 'false');
		$("#hdnErrorYN").val("N");
		scrollRefresh();
	}
}
function disableScroll(){
	if(diagTransactMainScroll!=null){
		diagTransactMainScroll.disable();
	}
}
function enableScroll(){
	if(diagTransactMainScroll!=null){
		diagTransactMainScroll.enable();
	}
}