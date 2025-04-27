// This small jQuery plugin  is used to assign the event handler function for the OK button of the confirm dialog 
(function($) {
    $.fn.configureConfirmDialog = function(options) {
        var defaultVal = {
            callBackForTrue: function() {},
        };
        var obj = $.extend(defaultVal, options);
        $(this).find("[data-value='true']").off();
        $(this).find("[data-value='true']").on("click", obj.callBackForTrue);
        return this;
    };

	
}(jQuery));

function hideAllKeyboards() {
    setTimeout(function() {
		if($(document.activeElement))
			$(document.activeElement).blur();
	}, 20);
}

var allAddedDrug = [];
var currentElement;
var drugInteractionLevel = "";
var drugDupStatus;
var result = false;
var message = "";
var flag = "";
var allErrorItems = [];
var legendsScroll;
var legendsScroll1;
var path;
var drugInteractionScroller;


function errorItem() 
{
    this.errorName = "";
    this.errorId = "";
    this.errorMessage = "";
    this.okClickFunctionName = "";
    this.cancelClickFunctionName = "";
    this.information = "";
}

function okCartClickDialog() {
    $("#cartCloseconfirmMsg").hide();
    $("#ChartSummaryBlock").append("<div class='loadingCartItem'></div>");    
    window.location.replace(path + "/eIPAD/jsp/IPad.jsp?ActivePage=IP");
}

function cancelDeleteCartClickDialog() {
    $("#deleteConfirmMsg").hide();
}

function getTotalPageDivHeight(){
var i = $('#divParent').height();
return i;
}




function cancelCartClickDialog() {
    $("#cartCloseconfirmMsg").hide();
}

function closeChartSummary() {
    if (allAddedDrug.length > 0)
        $("#cartCloseconfirmMsg").show();
    else
        okCartClickDialog();
}

function getCountOfCart(){
	
	var countArray=[];
	
	  for (var g = 0; g < allAddedDrug.length; g++) {
        var drugDetails = allAddedDrug[g];
		
		var order = drugDetails instanceof currentDrug; 
		
		//console.log("last_element::"+order);
		
		if(!order){
		
		
		
		}else{
		countArray.push("");
		
		}
		
		
    }
	console.log("allAddedDrug::"+JSON.stringify(allAddedDrug));
	return countArray.length;

}

function currentDrug() {
    this.drugname = "";
    this.drugCode = "";
    this.DrugCode = "";
	this.order_id="";
    this.drugUnique = "";
    this.OrderTypeCode = "";
    this.OrderCatCode = "";
    this.TradeCodes = "";
    this.TradeNames = "";
    this.Priority = "";
    this.checkboxValues = "";
    this.take_home_medication = "";
    this.order_set_code = "";
    this.drug_db_interface_yn = "";
    this.act_patient_class = "";
    this.home_leave_yn_val = "";
    this.location_type = "";
    this.location_code = "";
    this.height = "";
    this.weight = "";
    this.in_formulary = "";
    this.drug_class = "";
	this.drug_type = "";
	this.orderFrom = "";
	this.rxPos = "";
    this.PharmPrescriptionMode = "";
}

var xmlStr = "";

function completePlaceOrders_confirm() {
    if (allAddedDrug.length <= 0) {
        showToastMsg1("Add one or more order items to the pharmacy cart to place pharmacy orders");
        return;
    }

    $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp', function(res) {
        var PHCartErrorExists = $("#PHCartErrorExists").val();
        if (PHCartErrorExists == "true") {
            showToastMsg1("Enter mandatory fields in order to release the pharmacy order");
            return;
        }
	 $("#PageLoadingAnimation").show();
     $("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
	
	var frmobj = document.PharmBaseForm;
        var patient_id = frmobj.patient_id.value;
        var encounter_id = frmobj.episode_id.value;
        var bed_num = frmobj.bed_num.value;
        var room_num = frmobj.room_num.value;
        var height = frmobj.height.value;
        var weight = frmobj.weight.value;
        var bsa = frmobj.bsa.value;
        var bmi = frmobj.bmi.value;
        var height_unit = frmobj.height_unit.value;
        var weight_unit = frmobj.weight_unit.value;
        var bsa_unit = "BSA";
        var priority = "R";        
        var order_date_time = frmobj.sys_date.value;
        var take_home_medication = frmobj.take_home_medication.value;
        var patient_class = frmobj.patient_class.value;
        var allergic_yn = frmobj.allergic_yn.value;
        if (height_unit == "")
            height_unit = "Cms";
        if (weight_unit == "")
            weight_unit = "Kgs";
        var location_type = frmobj.location_type.value;
        var location_code = frmobj.location_code.value;
        var facility_id = frmobj.facility_id.value;
        var attend_pract_id = frmobj.attend_pract_id.value;
        var ord_pract_id = frmobj.pract_id.value;
        var split_based_priority_yn = frmobj.split_based_priority_yn.value;
        var split_based_drug_class_yn = frmobj.split_based_drug_class_yn.value;
        var home_leave_yn_chk = frmobj.home_leave_yn_chk.value;
        var function_from = frmobj.function_from.value;
        var currentStage = frmobj.currentStage.value;
		var ord_date_time	= frmobj.sys_date.value;
		
        var fldString = " patient_class=\"" + patient_class + "\" ";
        fldString += " patient_id=\"" + patient_id + "\" ";
        fldString += " encounter_id=\"" + encounter_id + "\" ";
		fldString += " sched_medn_yn=\"Y\" ";
        fldString += " BED_NUM=\"" + bed_num + "\" ";
        fldString += " ROOM_NUM=\"" + room_num + "\" ";
        fldString += " HEIGHT=\"" + height + "\" ";
        fldString += " WEIGHT=\"" + weight + "\" ";
        fldString += " BSA=\"" + bsa + "\" ";
        fldString += " HEIGHT_UNIT=\"" + height_unit + "\" ";
        fldString += " WEIGHT_UNIT=\"" + weight_unit + "\" ";
        fldString += " BSA_UNIT=\"" + bsa_unit + "\" ";
	    fldString += " bed_num=\"" + bed_num + "\" ";
        fldString += " room_num=\"" + room_num + "\" ";
        fldString += " height=\"" + height + "\" ";
        fldString += " weight=\"" + weight + "\" ";
        fldString += " bsa=\"" + bsa + "\" ";
        fldString += " height_unit=\"" + height_unit + "\" ";
        fldString += " weight_unit=\"" + weight_unit + "\" ";
        fldString += " bsa_unit=\"" + bsa_unit + "\" ";
        fldString += " order_date_time=\"" + order_date_time + "\" ";
        fldString += " PRIORITY=\"" + priority + "\" ";
        fldString += " take_home_medication=\"" + take_home_medication + "\" ";
        fldString += " LOCN_TYPE=\"" + location_type + "\" ";
        fldString += " LOCN_CODE=\"" + location_code + "\" ";
        fldString += " source_type=\"" + location_type + "\" ";
        fldString += " source_code=\"" + location_code + "\" ";
        fldString += " facility_id=\"" + facility_id + "\" ";
        fldString += " attend_pract_id=\"" + attend_pract_id + "\" ";
        fldString += " ord_pract_id=\"" + ord_pract_id + "\" ";
        fldString += " PRACT_ID=\"" + ord_pract_id + "\" ";
        fldString += " allergic_yn=\"" + allergic_yn + "\" ";
        fldString += " BMI=\"" + bmi + "\" ";
        fldString += " bmi=\"" + bmi + "\" ";	
        fldString += " split_based_priority_yn=\"" + split_based_priority_yn + "\" ";
        fldString += " split_based_drug_class_yn=\"" + split_based_drug_class_yn + "\" ";
        fldString += " home_leave_yn_val=\"" + home_leave_yn_chk + "\" ";
        fldString += " function_from=\"" + function_from + "\" ";
        fldString += " currentStage=\"" + currentStage + "\" ";
		fldString += " ord_date_time=\"" + ord_date_time + "\" ";
        xmlStr = baseFormXMLString(frmobj, fldString);
        baseFieldValidation(xmlStr, "formGrouping");
        return;
});
}
function assignResult(_result, _message, _flag) {
    result = _result;
    message = _message;
    flag = _flag;
}

function clearBean() {
    $.ajax({
        url: path + "/mobile/charts/pharmacy/PharmInitServlet",
        type: 'GET',
        data: {
            'numberOfWords': 10
        },
        success: function(data) {
            ordersuccess();
        },
        error: function(request, error) {
            ordersuccess();
        }
    });
}

function ordersuccess() {  
    $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
        function(res) {
        });
    allAddedDrug = [];
    var cartCount = allAddedDrug.length;
   $("#cartCount").text(getCountOfCart());
		$("#countDisplay").text(getCountOfCart());
    dragAndDrop();
    showToastMsg1("Pharmacy order saved successfully.", "Success");
	
	if(allAddedDrug.length == 0){
		$("#cartOpened").val("N");
        $("#cartView").toggle();
        $("#cartWrapper").show();
        $("#cart").show();
	}
	
}

function showToastMsg1(content, type) {
    if (type && type == "Success") {
        $("#transactionMsg").addClass("rxBaseToastContentSuccess");
        $("#imgTransactionMsg").attr("src", path + "/eIPAD/images/PopSuccess.png");
    } else {
        $("#transactionMsg").addClass("rxBaseToastContentError");
        $("#imgTransactionMsg").attr("src", path + "/eIPAD/images/PopError.png");
    }
    $("#rxToastmsg").text(content);
    $("#transactionMsg").show();
    setTimeout(function() {
        $("#transactionMsg").hide();
        $("#transactionMsg").removeClass("rxBaseToastContentSuccess");
    }, 5000);
    $("#transactionMsg").bind('click', function() {
        $(this).hide();
        $("#transactionMsg").removeClass("rxBaseToastContentSuccess");
    });
    hideAllKeyboards();
}

function showToastMsg2(content, type) {  
        $("#transactionMsg2").addClass("rxBaseToastContentError");
        $("#imgTransactionMsg").attr("src", path + "/eIPAD/images/PopError.png");  
    $("#rxToastmsg2").text(content);
    $("#transactionMsg2").show();
    setTimeout(function() {
        $("#transactionMsg2").hide();
        $("#transactionMsg").removeClass("rxBaseToastContentSuccess");
    }, 5000);
    $("#transactionMsg2").bind('click', function() {
        $(this).hide();
        $("#transactionMsg2").removeClass("rxBaseToastContentSuccess");
    });
    hideAllKeyboards();
}

function showRecords(print_ord_sht_rule_ind) {
    var frmobj = document.PharmBaseForm;
    formApply(frmobj);
    if (result) {
        clearBean();
    } 
	else
	{       
		if(message=="INSUFFICIENT_STOCK")		
		{	
			showToastMsg1("Insufficient stock");
			$("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
			function(res) {
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
        }); 
		}
		else
			showToastMsg1("Exception occured while insertion.");
	}
}

function formApply(frmobj) {
	baseFormValidation(xmlStr, "TRANSACTION");
}

function baseFormXMLString(formobj, fldString) {
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
//common for calling TEMP JSP for Validations
function baseFieldValidation(xmlStr, source) {
    var xmlDoc;
    var xmlHttp;
    if (navigator.appName.indexOf("Internet") == -1) {
        xmlHttp = new XMLHttpRequest();
        var xmlDoc = new DOMParser();
        xmlDoc = xmlDoc.parseFromString(xmlStr, "text/xml");
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        xmlDoc = new ActiveXObject("Microsoft.XMLDom");
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    }
    xmlHttp.open("POST", path + '/eIPAD/jsp/chartwidgets/pharmacy/PrescriptionRxValidation.jsp?func_mode=' + source, false);
    xmlHttp.send(xmlDoc);
    responseText = xmlHttp.responseText;
    eval(responseText);
	$("#completePlaceOrdersConfirm").addClass('completePlaceOrdersDisable');	
    return true;
}

function baseFormValidation(xmlStr, source) {
    var xmlDoc;
    var xmlHttp;
    if (navigator.appName.indexOf("Internet") == -1) {
        xmlHttp = new XMLHttpRequest();
        var xmlDoc = new DOMParser();
        xmlDoc = xmlDoc.parseFromString(xmlStr, "text/xml");
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        xmlDoc = new ActiveXObject("Microsoft.XMLDom");
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    }
    xmlHttp.open("POST", path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmTransaction.jsp?func_mode=' + source, false);
    xmlHttp.send(xmlDoc);
    responseText = xmlHttp.responseText;
    eval(responseText);
    return true;
}
function EnableAllRealtedDrugs(elem) {
    var drugNameUniqueCode = elem.draggable.element.data("drugcodeunique");
    $("div[data-currentid]").each(function(index, value) {
        var drugCodeUnique = $(this).attr('data-drugcodeunique');
        var divId = $(this).attr('data-currentid');
        if (drugNameUniqueCode == drugCodeUnique) {
            //console.log("dragger::" + $("#" + divId).data("kendoDraggable"));
            var dragger = $("#" + divId).data("kendoDraggable");
            $("#" + divId).kendoDraggable({
                hint: function(element) {
                    return element.clone();
                },
                dragstart: draggableOnDragStart,
                dragend: draggableOnDragEnd
            });
            $("#" + divId).removeClass("cstFieldDullRx");           
        }
        $(this).attr("data-role", "draggable");
    });
}
function hideAllAlerts() {
    $("#PharmacyCartValidationDialog").hide();
    $("#PharmacyCartValidationDialogDis").hide();
    $("#pharmacyValidationPopUp").hide();
}
function hideAndDestroy(ele) {
    hideAllAlerts();
    EnableAllRealtedDrugs(ele)
    currentElement.draggable.element.removeClass("cstFieldDullRx");
    var darg_id = currentElement.draggable.element.data("currentid");
    $("#" + darg_id).kendoDraggable({
        hint: function(element) {
            return element.clone();
        },
        dragstart: draggableOnDragStart,
        dragend: draggableOnDragEnd
    });

   
   var lastElem=allAddedDrug[allAddedDrug.length-1];
	allAddedDrug.splice(-1, 1);
	
	var order = lastElem instanceof currentDrug; 

		
		if(!order){

			clearDrugByOrderId(lastElem);
	
			
		}
		
		
 $("#cartCount").text(getCountOfCart());
 $("#countDisplay").text(getCountOfCart());
}

function getDrugByOrderId(orderDetails){	
	var order_id=orderDetails.orderId;	
}

function clearDrugByOrderId(orderDetails){

		var order_ids=orderDetails.orderId;
		
		var removeid=[];
		
		 for (var g = 0; g < allAddedDrug.length; g++) {
            var drugDetails = allAddedDrug[g];
			
			//console.log("drugDetails::"+drugDetails);
			
            var order_id = drugDetails.order_id;	
	     
			//console.log("news::"+order_id+"ghilli"+order_ids);
            if (order_id == order_ids ) {				
                //allAddedDrug.splice(g, 1);
				removeid.push(g);
				//break;	
            }
        }
		
		 for (var j = removeid.length-1; j >=0; j--) {
			  var rem = removeid[j];
			 // console.log("clear da"+rem);
			  allAddedDrug.splice(rem, 1);
		 }
		
	
}


function hideAndDestroyOkClick(ele) {
    EnableAllRealtedDrugs(ele)
    currentElement.draggable.element.removeClass("cstFieldDullRx");
    var darg_id = currentElement.draggable.element.data("currentid");
    $("#" + darg_id).kendoDraggable({
        hint: function(element) {
            return element.clone();
        },
        dragstart: draggableOnDragStart,
        dragend: draggableOnDragEnd
    });
    
	var lastElem=allAddedDrug[allAddedDrug.length-1];
	allAddedDrug.splice(-1, 1);
	
	var order = lastElem instanceof currentDrug; 
		
		//console.log("last_element::"+order);
		
		if(!order){
			//oreder case
			//console.log("last_element:: oreder");
			//allAddedDrug.splice(-1, 1);
			clearDrugByOrderId(lastElem);
			//getDrugByOrderId(lastElem);
		
			
		}else{
			//drug case
			//console.log("last_element:: drugs");
		}
	
   $("#cartCount").text(getCountOfCart());
   $("#countDisplay").text(getCountOfCart());
}
function closeHWPopupCAN() 
{
	var baseformobj = document.PharmBaseForm;
	var htWt_check = baseformobj.ht_wt_check.value;
	if(htWt_check == "Y" )
	{
		var countOfI = $("#valueOfSelectedElem").val();		
		var htwt_n = "N";
		baseformobj.ht_wt_check.value = htwt_n;
		$("#ivrxWithAddCalcBy_"+ countOfI).data("kendoDropDownList").value("D");		
	    var dataItem = document.getElementById("ivrxWithAddDosageBy_" + countOfI);   
    if (dataItem.value == "S") {
        $("#doseDetailsWrapper_Strength" + countOfI).show();
        $("#doseDetailsWrapper_Dose" + countOfI).hide();
		
    } else if (dataItem.value == "Q") {        
        $("#doseDetailsWrapper_Dose" + countOfI).show();
        $("#doseDetailsWrapper_Strength" + countOfI).hide();		
		}
		$("#doseDetailsWrapper_OnBodyWt" + countOfI).hide();
        $("#ivWithAdddoseUnitsWrapper" + countOfI).hide();
        $("#enabledOnDosage" + countOfI).show();
        $("#disabledOnBodyWt" + countOfI).hide();
        $("#ivWithAdddoseRemarksField" + countOfI).show();
        $("#hideShowDivider" + countOfI).hide();
		$("#ivWithAddDrugIndications_" + countOfI).show();		
		pharmIvRxDetailsScroller.refresh();	
	}
	else if(htWt_check == "YI")
	{
		var htwt_n = "N";
		baseformobj.ht_wt_check.value = htwt_n;
		$("#ivInterCalcBy").data("kendoDropDownList").value("D");		
        showDosageBY();
		onSelectCalculateBy();
        $("#strenght_quality").show();
        hideAllBnsWeight();
	}
	else
	{
		callForNextAllert();
		hideAndDestroy(currentElement);
		 $("#cartCount").text(getCountOfCart());
         $("#countDisplay").text(getCountOfCart());
		$("#blurSearchResultsList1").hide();
	}
    $("#pharmacyValidationPopUp").hide();
    $("#dvMez").css("display", "none");
    $("#RxBmiValue").html("");
    $("#RxBsaValue").html("");
    $("#enter_height").val("");
    $("#enter_weight").val("");
    $("#wt_mandatory").hide();
    $("#ht_mandatory").hide();
}

function cancelClickDialog() { 
    callForNextAllert();
    $("input[name=take_medication_yn_dis]").val("disabled");
    $("input[name=take_home_medication]").val("N");
    $("#act_patient_class").val("IP");
    $("#PharmacyCartValidationDialogDis").hide();
    $("#dvMez").css("display", "none");
    LoadPreviousOrders("checkPrevFirstTime");
    $("#blurSearchResultsList1").css("display", "none");
}

function callForNextAllert() {
    $("#PharmacyCartValidationDrugMessage").hide();
	 $("#PharmacyCartValidationDrugInteraction").hide();
	 
    clearErrodIdAlert()
    clearLastId();
    setTimeout(function() {
        showAllAlerts();
    }, 1000);
    if (allErrorItems.length == 0) {
        $("#blurSearchResultsList1").css("display", "none");
    }
}
function clearLastId() {
    var allAlerts = allErrorItems.length;
    if (allAlerts > 0) {
        allErrorItems.shift();
    }
}

function clearErrodIdAlert() {
    var allAlerts = allErrorItems.length;
    if (allAlerts > 0) {
        var err = allErrorItems[0];
        var errorId = err.errorId;
        if (errorId == 1) {
            allErrorItems = [];
        }
    }
}
function okPopup(){
 callForNextAllert();
  if (drugInteractionLevel == "1_not") {
        hideAndDestroyOkClick(currentElement);
        drugInteractionLevel = "";
    } else if (drugInteractionLevel == "0_yes") {
        drugInteractionLevel = "";
    }    
   $("#cartCount").text(getCountOfCart());
		$("#countDisplay").text(getCountOfCart());
}

function trueClickDialog() {    
    callForNextAllert();
    $("input[name=take_medication_yn_dis]").val("disabled");
    $("input[name=take_home_medication]").val("Y");
    $("#act_patient_class").val("OP");
    $("#PharmacyCartValidationDialogDis").hide();
    $("#dvMez").css("display", "none");
    LoadPreviousOrders("checkPrevFirstTime");
    $("#blurSearchResultsList1").css("display", "none");
}

function closeHWPopupOK(){  
    $("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');	
	var ifCartOpened = $("#cartOpened").val();
	if(ifCartOpened == "Y"){
		loadAlldata();
	}	
	var baseformobj = document.PharmBaseForm;
	var htWt_check = baseformobj.ht_wt_check.value;
	if(htWt_check == "Y" ||htWt_check=="YI" )
	{
		var enter_height = $("#enter_height").val();
		var enter_weight = $("#enter_weight").val();
		var RxBsaValue = $("#RxBsaValue").value;
		var RxBmiValue = $("#RxBmiValue").value;		
		$("#height").val(enter_height);
	    $("#weight").val(enter_weight);
		$("#bsa").val(RxBsaValue);
		$("#bmi").val(RxBmiValue);		
		$("#pharmacyValidationPopUp").hide();
		$("#dvMez").css("display", "none");
	}	
	else{
    callForNextAllert();
    $("#blurSearchResultsList1").hide();
    $("#pharmacyValidationPopUp").hide();
    $("#dvMez").css("display", "none");
    var last_element = allAddedDrug[allAddedDrug.length - 1];
	var order_id="";
	if( last_element["drugInfo"] !== undefined ) {
    // do something
	order_id=last_element.orderId;
	var drugInfo=last_element.drugInfo;
	last_element=drugInfo[0];
	
	
     }


    var hei = $("#enter_height").val();
    var wei = $("#enter_weight").val();
    $("#height").val(hei);
    $("#weight").val(wei);
    last_element.height = hei;
    last_element.weight = wei;
    var validationPath = path + '/mobile/charts/pharmacy/PharmValidationJSONServlet?mode=VALIDATE_ADDTOCART';
    $.getJSON(validationPath, {
            DrugCode: last_element.DrugCode,
            OrderTypeCode: last_element.OrderTypeCodes,
            OrderCatCode: last_element.OrderCatCode,
            check_box_value: last_element.checkboxValues,
            TradeCodes: last_element.TradeCodes,
            TradeNames: last_element.TradeNames,
            Priority: last_element.Priority,
            take_home_medication: last_element.take_home_medication,
            order_set_code: last_element.order_set_code,
            drug_db_interface_yn: last_element.drug_db_interface_yn,
            act_patient_class: last_element.act_patient_class,
            home_leave_yn_val: last_element.home_leave_yn_val,
            location_type: last_element.location_type,
            location_code: last_element.location_code,
            height: last_element.height,
            weight: last_element.weight,
            in_formulary: last_element.in_formulary,
            drug_class: last_element.drug_class,
			drugTypeCode:last_element.drug_type,	
            ivrxIsPresent:"Y",
            orderId:order_id,
			PharmPrescriptionMode: last_element.PharmPrescriptionMode
        })
        .done(function(json) {
            var result = json.validationResult;
        })
        .fail(function(jqxhr, textStatus, error) {
            var err = textStatus + ", " + error;
        });
	}
};

function loadAlldata() {
    var drugDetails = encodeURIComponent(JSON.stringify(allAddedDrug));
    $("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
    $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
        function(res) {
        });
}
$("#cart").click(function() {
	$("#cartOpened").val("Y");
    loadAlldata();
    $("#cartView").show();
    $("#cart").hide();
    $("#cartWrapper").hide();
    //$("#blurSearchResultsList").show();
});

$("#closeCartView").click(function() {
	$("#cartOpened").val("N");
    $("#cartView").toggle();
    $("#cartWrapper").show();
    $("#cart").show();
    //$("#blurSearchResultsList").hide();
});

$("#rxSearchResults").click(function() {
	var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
});

$("#drugDropDownTicksheet").click(function() {
	var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
});


$("#noticksheetMsg").click(function() {
	var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
});

$("#NoteTypeFilterTxt").click(function(){ 
  var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
});

function okClickAlreadySelected() {
    callForNextAllert();
    hideAndDestroyOkClick(currentElement);
}

function okClickDrugDup() {    
    callForNextAllert();
    if (drugDupStatus == 0) {
		
	} else {
        hideAndDestroyOkClick(currentElement);
    }
    drugDupStatus = "";    
    $("#cartCount").text(getCountOfCart());
	$("#countDisplay").text(getCountOfCart());
}

function okClickDrug() {
    callForNextAllert();
    if (drugInteractionLevel == "1_not") {
        hideAndDestroyOkClick(currentElement);
        drugInteractionLevel = "";
    } else if (drugInteractionLevel == "0_yes") {
        drugInteractionLevel = "";
    }    
   $("#cartCount").text(getCountOfCart());
		$("#countDisplay").text(getCountOfCart());
}
function okClickStock() {
    callForNextAllert(); 
    hideAndDestroyOkClick(currentElement);
}

function okClickException() {
    callForNextAllert(); 
    hideAndDestroyOkClick(currentElement);
}
function okClickAge() {
    callForNextAllert();
    hideAndDestroyOkClick(currentElement);
}
function okClick() {
   /* callForNextAllert(); 
    hideAndDestroyOkClick(currentElement);
    allAddedDrug.splice(-1, 1);
    $("#cartCount").text(allAddedDrug.length);
    $("#countDisplay").text(allAddedDrug.length);*/
	openChartSummaryProblemsView();
}
function openChartSummaryProblemsView(){
	window.location.replace(path+"/setpatientcontext?activePage=chartSummary&setNewPatientContext=N&scrollToWidget=APD"); 
}
function okClickDrugDup1() {
    $("#PharmacyCartValidationDrugDup").hide();
}
function okClickPrescribingDrugPrev() {
    callForNextAllert(); 
    hideAndDestroyOkClick(currentElement);
}
function okClickDrugPrev() {
    callForNextAllert();
    $("#PharmacyCartValidationDrugPrev").hide();
    hideAndDestroyOkClick(currentElement);
}
function selectPharmOrderTab(evt, type) {
    var pharmData = "";
	var ifCartOpened;
    $('.ordListHWrapper').html('');
    $('#NoteTypeFilterTxt').val('');
    $("#drugDropDownTicksheet").hide();
    $("#noticksheetMsg").hide();
	$("#removeSearchClass").hide();
	$("#addSearchClass").show();
	$("#cellblur").addClass('cstFieldDullRx'); 
    switch (type) {
        case "prevOdr":	
            ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }			
            $("#PharmPrescriptionMode").val("PO");
            $("#ivrxSubTypes").hide();
            $("#drugDropDownTicksheet").hide();
			$("#noticksheetsectionsMsg").hide();
            $("#loadticksheetSections").hide();
            $("#drugSearchBox").hide();
            $("#ordersModeType").val("PO");
            LoadPreviousOrders();
            break;
        case "tickSheet":
		    ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
            $("#ivrxSubTypes").hide();
            $("#drugDropDownTicksheet").show(); 
            $("#loadticksheetSections").hide();
            $("#drugSearchBox").hide();
            $("#noticksheetMsg").show();
			$("#PharmPrescriptionMode").val("RX");
            LoadTickSheetSections($("#ticksheetValue").val());
            break;
        case "crxTab":
	
		    ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
            $("#PharmPrescriptionMode").val("CRX");
            $("#ivrxSubTypes").hide();
            $("#drugDropDownTicksheet").hide();
            $("#loadticksheetSections").hide();
			$("#noticksheetsectionsMsg").hide();
            $("#drugSearchBox").show();
            $("#ordersModeType").val("CO");
            //$("#PharmPrescriptionMode").val("CRX");
            break;
        case "rxTab":
		    ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
            $("#PharmPrescriptionMode").val("RX");
            $("#ivrxSubTypes").hide();
            $("#drugDropDownTicksheet").hide();
            $("#loadticksheetSections").hide();
			$("#noticksheetsectionsMsg").hide();
            $("#drugSearchBox").show();
            $("#ordersModeType").val("");
            $("#PharmPrescriptionMode").val("RX");
            break;
        case "ivrxTab":
		    ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
            $("#PharmPrescriptionMode").val("IVD");
            $("#ivrxSubTypes").show();
            $("#drugDropDownTicksheet").hide();
			$("#noticksheetsectionsMsg").hide();
            $("#loadticksheetSections").hide();
            $("#drugSearchBox").show();
            $("#ordersModeType").val("D");
            $("#ivWithAddOption").addClass('ivrxTabsOnActive');
            $("#ivIntermittentOption").removeClass('ivrxTabsOnActive');
            $("#ivWithoutAddOption").removeClass('ivrxTabsOnActive');
            $("#ivWithAddDesc").addClass('ivrxTabsDescOnActive');
            $("#ivIntermittentDesc").removeClass('ivrxTabsDescOnActive');
            $("#ivWithoutAddDesc").removeClass('ivrxTabsDescOnActive');
            break;
    }
};

function filterNoteTypes(evt) {
    var enterTypes = $('#NoteTypeFilterTxt').val();
    if (parseInt(enterTypes.length) < parseInt(3)) {
        $("#cellblur").addClass("cstFieldDullRx");
    } else {
        $("#cellblur").removeClass("cstFieldDullRx");
    }

}
function makeServicesCall() {
    var enterTypes = $('#NoteTypeFilterTxt').val();
    var mode = $('#ordersModeType').val();
    var act_patient_class = $("#act_patient_class").val();
    $("#rxSearchResults").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
    $("#rxSearchResults").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/searchRx.jsp?enterTypes=' + encodeURI(enterTypes) + '&mode=' + mode + '&act_patient_class=' + act_patient_class,
        function(res) {
            var checkForRec = $('#no_record').val();
            if (checkForRec == 'no') { 
                showToastMsg1("No Records found");
                $("#PageLoadingAnimation").hide();
            } else {
                setTimeout(function() {
                    onOriChange();
                    assignOrdItemsHScroll_S();     
                    dragAndDrop();					
                    $('#no_record').val("");
                    $("#PageLoadingAnimation").hide();
                }, 2000);
            }
        }
    );
}

function clearTemplateFilterTxt(evt) {
    var noteTypes = $('#NoteTypeFilterTxt').val();
    if (parseInt(noteTypes.length) < parseInt(3)) {
        evt.stopPropagation();
        return false;
    } else {
        makeServicesCall();
        //$('#NoteTypeFilterTxt').blur(); 
        $("#removeSearchClass").show();
        $("#addSearchClass").hide();
    }
}
function clearSearchFilterTxt(evt) {
    $('#NoteTypeFilterTxt').val('');
	$("#removeSearchClass").hide();
	$("#addSearchClass").show();
	$("#cellblur").addClass('cstFieldDullRx');
}
$('#NoteTypeFilterTxt').on('keyup', function(e) {
    if (e.which != 13) {
        $("#addSearchClass").show();
        $("#removeSearchClass").hide();
        
    }else{
    	$('#NoteTypeFilterTxt').blur(); 
    }

});

//BmiBsaCalculation
function BmiBsaCalculation(heightValue, weightValue) {
    if (heightValue != null && heightValue != 0 && heightValue.length >= 3 && weightValue != null && weightValue != 0 && weightValue.length >= 2) {
        //BMI 
        var BmiValueToConvert = (weightValue / ((heightValue / 100) * (heightValue / 100)));
        var BMIamt = parseFloat(BmiValueToConvert);
        var BmiValue = BMIamt.toFixed(2);
        $("#RxBmiValue").html(BmiValue);

        //BSA
        var BsaValueToConvert = Math.sqrt(heightValue * weightValue / 3600);
        var BSAamt = parseFloat(BsaValueToConvert);
        var BsaValue = BSAamt.toFixed(2);
        $("#RxBsaValue").html(BsaValue);
        $("#heightCheckOk").removeClass('cstFieldDullRxNone');
    } else {
        $("#heightCheckOk").addClass('cstFieldDullRxNone');
    }
}

function selectIvrxMode(mode, modeDesc) {
    $('.ordListHWrapper').html('');
    $('#NoteTypeFilterTxt').val('');
    $("#ordersModeType").val(mode);

    if (modeDesc == "ivWithoutAdd") {
        $("#ivWithAddOption").removeClass('ivrxTabsOnActive');
        $("#ivIntermittentOption").removeClass('ivrxTabsOnActive');
        $("#ivWithoutAddOption").addClass('ivrxTabsOnActive');
        $("#ivWithAddDesc").removeClass('ivrxTabsDescOnActive');
        $("#ivIntermittentDesc").removeClass('ivrxTabsDescOnActive');
        $("#ivWithoutAddDesc").addClass('ivrxTabsDescOnActive');
        $("#PharmPrescriptionMode").val("IVWA");
    } else if (modeDesc == "ivInter") {
        $("#ivWithAddOption").removeClass('ivrxTabsOnActive');
        $("#ivIntermittentOption").addClass('ivrxTabsOnActive');
        $("#ivWithoutAddOption").removeClass('ivrxTabsOnActive');
        $("#ivWithAddDesc").removeClass('ivrxTabsDescOnActive');
        $("#ivIntermittentDesc").addClass('ivrxTabsDescOnActive');
        $("#ivWithoutAddDesc").removeClass('ivrxTabsDescOnActive');
        $("#PharmPrescriptionMode").val("IVPB");
    } else if (modeDesc == "ivWithAdd") {
        $("#ivWithAddOption").addClass('ivrxTabsOnActive');
        $("#ivIntermittentOption").removeClass('ivrxTabsOnActive');
        $("#ivWithoutAddOption").removeClass('ivrxTabsOnActive');
        $("#ivWithAddDesc").addClass('ivrxTabsDescOnActive');
        $("#ivIntermittentDesc").removeClass('ivrxTabsDescOnActive');
        $("#ivWithoutAddDesc").removeClass('ivrxTabsDescOnActive');
        $("#PharmPrescriptionMode").val("IVD");
    }
	
	ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
}

function LoadTickSheetSections(seleDefTickS) {
$("#rxSearchResults").html('');
ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
    $("#loadticksheetSections").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/TickSheetSection.jsp?tick_sheet_id=' + seleDefTickS,
        function(res) 
		{
		if($("#NoRecordsSections").val() == "NO"){		
		 $("#loadticksheetSecParent").hide();
		 $("#drugDropDownTicksheet").css("border-bottom","0px");
           $("#rxSearchResults").append('<div id="noticksheetsectionsMsg" style="display: table;height: 100%;width: 100%" > <div class="pharmEmptyData" >No ticksheet sections found</div></div>');		 
		}
		else{
		$("#loadticksheetSecParent").show();
		}          
            if ($("#noticksheetsectionsMsg").data("no_records") != true)
                $("#loadticksheetSections").css('background-color', '#FFF');
            else
                $("#loadticksheetSections").css('background-color', '#EDF1F3');
        }
    );
}

function LoadPreviousOrders(checkVal){
	var ivrxChk = $("#ivrxCheck").val();
	$("#rxSearchResults").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
    $("#rxSearchResults").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/SearchPrevOrders.jsp?ivrxChk='+ivrxChk,
    function(res){ 
     setTimeout(function() {
          // onOriChange();	
           dragAndDrop();
           assignOrdItemsHScroll_S(); 
    }, 500);
	         
    var checkPrevOrderVal= $('#hdnPrevOrderSize').val();
    if( checkVal == "checkPrevFirstTime" && checkPrevOrderVal == 0){
	        $("#noPrevOreders").hide();
            $("#ivrxSubTypes").hide();
            $("#drugDropDownTicksheet").show(); 
            $("#loadticksheetSections").hide();
            $("#drugSearchBox").hide();
            $("#noticksheetMsg").show();
			$("#PharmPrescriptionMode").val("RX");
			$("#pharmPrevOrder").removeClass('pharmOrderSelectedTab');
            $("#pharmTickSheet").addClass('pharmOrderSelectedTab');
            LoadTickSheetSections($("#ticksheetValue").val());
	}		   
    }		
    );
}

function ticksheetDropdownValChange() {
	if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
    $("#TickSheetMain").show();
    var changedDropDownValue = $("#drugDropDownTicksheet1").data("kendoDropDownList").value();
    $("#ticksheetValue").val(changedDropDownValue);
    LoadTickSheetSections(changedDropDownValue);

};
var ticksheetDropdownVals = $("#drugDropDownTicksheet1").kendoDropDownList({
    change: ticksheetDropdownValChange,
});
function ticksheetDrugTabSelection(code, tickSheetId)
{
	var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        } 
    $(".ticksheetHeaderStyle").removeClass('ticksheetIsActive');
    $("#" + tickSheetId).addClass('ticksheetIsActive');
    $("#loadticksheetSections").show();
    $("#ticksheetCodeValue").val(code);
    var changedDropDownValue = $("#ticksheetValue").val();
    var codeValue = $("#ticksheetCodeValue").val();
    $("#rxSearchResults").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
    $("#rxSearchResults").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/searchTicksheet.jsp?tick_sheet_id=' + changedDropDownValue + '&codeValue=' + codeValue + '',
        function(res) {
    	
    	assignOrdItemsHScroll_S();
        dragAndDrop();
        
            $("#PageLoadingAnimation").hide();
            if ($("#noticksheetitemsMsg").data("no_records") != true) {
                $("#OrdItemscroller_A").css('position', 'absolute');
            } else {
                $("#OrdItemscroller_A").css('position', 'relative');
            }
        }
    );
}


function scrollPopUpContent() {
    drugInteractionScroller = new IScroll('#drugInterScrollableWrap', {
        scrollX: false,
        scrollY: true,
        interactiveScrollbars: true,
        click: true,
        useTransition: false,
        hideScrollbar: true,
        scrollbars: true,
        bindToWrapper: true,
        fadeScrollbars: true
    });
}
function errorItem() {
    this.errorName = "";
    this.errorId = "";
    this.errorMessage = "";
    this.okClickFunctionName = "";
    this.cancelClickFunctionName = "";
    this.information = "";
    this.severity_level= "";
    this.significant_level= "";
    this.probability= "";
}

function errorMessageLoad(errorName, errorId, errorMessage, okClickFunctionName, cancelClickFunctionName, information, severity_level, significant_level, interaction_desc, probability) {
    $("#blurSearchResultsList1").css("display", "block");
    var errorItems = new errorItem();
    errorItems.errorName = errorName;
    errorItems.errorId = errorId;
    errorItems.errorMessage = errorMessage;
    errorItems.okClickFunctionName = okClickFunctionName;
    errorItems.cancelClickFunctionName = cancelClickFunctionName;
    errorItems.information = information;
    errorItems.severity_level = severity_level;
    errorItems.significant_level = significant_level;	
    errorItems.interaction_desc = interaction_desc;
    errorItems.probability = probability;		
    allErrorItems.push(errorItems);
}

function showAllAlerts() {
    var allAlerts = allErrorItems.length;
    if (allAlerts > 0) {
        var err = allErrorItems[0];
        var errorName = err.errorName;
        var errorId = err.errorId;
        var errorMessage = err.errorMessage;
	
        var okClickFunctionName = err.okClickFunctionName;
        var cancelClickFunctionName = err.cancelClickFunctionName;
        var information = err.information;
        if (information == "discharge_medication") {
            $("#PharmacyCartValidationDialogDis").show();
        } else if (information == "HeightandWeight") {
        	$("#blurSearchResultsList1").show();
            $("#heightCheckOk").addClass('cstFieldDullRxNone');
            $("#pharmacyValidationPopUp").show();
            $("#RxBmiValue").html("");
            $("#RxBsaValue").html("");
            $("#enter_height").val("");
            $("#enter_weight").val("");
        }else if (information == "DRUG_INTERACTION"){
        	var severity_level = err.severity_level;
	var significant_level = err.significant_level;
	var interaction_desc = err.interaction_desc;
	var probability = err.probability;
	
	
	//TODO TO Be changed, Height setting logic to be revisited
				var drugDocumentation = DrugInteraction_Documentation(probability);
				var drugSeverity = DrugInterSeverity(severity_level);
				if(interaction_desc.length != null && interaction_desc.length > 100 && interaction_desc.length < 200){
					$("#drugInterScrollableWrap").css("height", "40px");
				}
				else if(interaction_desc.length != null && interaction_desc.length > 200 && interaction_desc.length < 400){						
					$("#drugInterScrollableWrap").css("height", "80px"); 
				}
				else if(interaction_desc.length != null && interaction_desc.length > 400 && interaction_desc.length < 600){			
					$("#drugInterScrollableWrap").css("height", "100px");
				}
				else if(interaction_desc.length != null && interaction_desc.length > 800){		
					$("#drugInterScrollableWrap").css("height", "140px");
					drugInteractionScroller.refresh();
				}
				$("#PharmacyCartValidationDrugInteraction").show();
                $("#DrugInteractionDesc").html(interaction_desc);
				drugInteractionScroller.refresh();
				$("#severity_level").html(drugSeverity);
				$("#significant_level").html(significant_level);
				$("#probability").html(drugDocumentation);
				
			} 	
		
		else {
            $("#PharmacyCartValidationDrugMessage").show();
           $("#PharmaMsg").text(errorMessage);
            $("#drugClick").attr('data-refclick', okClickFunctionName);
            var element = document.getElementById('drugClick');
            if (okClickFunctionName == "okClickDrugPrev") {
                element.onclick = okClickDrugPrev;
            } else if (okClickFunctionName == "okClick") {
                element.onclick = okClick;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } else if (okClickFunctionName == "okClickAge") {
                element.onclick = okClickAge;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } else if (okClickFunctionName == "okClickPrescribingDrugPrev") {
                element.onclick = okClickPrescribingDrugPrev;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } else if (okClickFunctionName == "okClickStock") {
                element.onclick = okClickStock;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } 
            else if (okClickFunctionName == "okClickException") {
                element.onclick = okClickException;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            }

			
			else if (okClickFunctionName == "okClickDrug") {
                element.onclick = okClickDrug;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } else if (okClickFunctionName == "okClickDrugDup") {
                element.onclick = okClickDrugDup;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            } else if (okClickFunctionName == "okClickAlreadySelected") {
                element.onclick = okClickAlreadySelected;
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');
            }
        }
    }
}

$(document).ready(function() {
    path = $("#hdnPath").val();
    $("#ordersModeType").val("");
    $("#cartCloseconfirmMsg").hide();
    $('#NoteTypeFilterTxt').keypress(function(e) {
        var key = e.which;
        if (key == 13) {
            clearTemplateFilterTxt(e);
            return false;
        }
    });
	scrollPopUpContent();
    loadLegends();
    $("#pharmPrevOrder").addClass('pharmOrderSelectedTab');
    $("#PharmPrescriptionMode").val("PO");
    $("#ivrxSubTypes").hide();
    $("#drugDropDownTicksheet").hide();
    $("#loadticksheetSections").hide();
    $("#drugSearchBox").hide();
    $("#ordersModeType").val("PO");
    var diag_size = $("input[name=diag_size]").val();
    var allow_without_diag = $("input[name=allow_without_diag]").val();
    if (allow_without_diag == "N" && parseInt(diag_size) == 0) {
    	$("#PharmAvailableTabs").hide();
        errorMessageLoad("allow_without_diag", 1, "You must record a diagnosis before placing pharmacy orders for this patient", "okClick", "no", "allow_without_diag");
    }else{
    	
    	var take_medication_yn_dis = $("input[name=take_medication_yn_dis]").val();
	    if (take_medication_yn_dis != "disabled") {
	        errorMessageLoad("discharge medication", "0", "Do you want to treat this as patient's discharge medication?", "trueClickDialog(this)", "cancelClickDialog(this)", "discharge_medication");
	    }else{
		
		 LoadPreviousOrders("checkPrevFirstTime");
		
		}
    }
    showAllAlerts();
    $(".pharmOrderTab").on('click', function() {
        $('.pharmOrderTab').removeClass('pharmOrderSelectedTab');
        $(this).addClass('pharmOrderSelectedTab');
    });

    //Height Calculation
    var heightValue = "";
    var weightValue = "";
    $('#enter_height').on('input', function(event) {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
    $('#NoteTypeFilterTxt').on('input', function(event) {
        this.value = this.value.replace(/[%]/g, '');
    });
    // Allow only one dot In Height
    document.getElementById('enter_height').onkeypress = function(e) {
            if (e.keyCode === 46 && this.value.split('.').length === 2) {
                return false;
            }
        }
        //End

    $('#enter_height').keyup(function() {
	 var weight_mandatory = $("#weight_mandatory").val();
     var height_mandatory = $("#height_mandatory").val();
	 var height_weight_mandatory = $("#height_weight_mandatory").val();
        heightValue = $("#enter_height").val();
        weightValue = $("#enter_weight").val();
        if (heightValue.length > 2 && weightValue.length > 1) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
            BmiBsaCalculation(heightValue, weightValue);
        }
		
		if(heightValue.length > 2 && parseInt(heightValue) ==0){
		$("#enter_height").val("");
		}
		
		 if ((weightValue ==null || weightValue == "" || weightValue.length > 1) &&  height_mandatory =="Y" && heightValue.length > 2) {
          
		    $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		 
		}	
		
		
	
		if ( (heightValue ==null || heightValue == "" || heightValue.length > 2 ) && weight_mandatory == "Y" && weightValue.length > 1) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}
		if (  height_weight_mandatory == "Y" && weightValue.length > 1 &&  heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}
    });

    $('#enter_height').focusout(function() {
	    var weight_mandatory = $("#weight_mandatory").val();
        var height_mandatory = $("#height_mandatory").val();
	    var height_weight_mandatory = $("#height_weight_mandatory").val();
        var typeOfHWcheckWithAdd = $("#typeOfHWcheckWithAdd").val();
        var typeOfHWcheckInter = $("#typeOfHWcheckInter").val();
        heightValue = $("#enter_height").val();
        if (heightValue == null || heightValue == 0) {
            $("#RxBmiValue").html("");
            $("#RxBsaValue").html("");
            $("#heightCheckOk").addClass('cstFieldDullRxNone');
        }
	if(heightValue == null && height_mandatory == "Y"){
	  $("#heightCheckOk").addClass('cstFieldDullRxNone');
	    showToastMsg2("Height cannot be blank");
	}
	  
        if (heightValue != null && heightValue != 0 && heightValue.length < 3) {
            if (heightValue.length < 3) {
                if (typeOfHWcheckWithAdd == "IVWITHADDTOAST" || typeOfHWcheckInter == "IVINTER") {
                    showToastMsg2("Height : Minimum number of digits should be 3");
                } else {
                    showToastMsg1("Height : Minimum number of digits should be 3");
                }
            }
            if (heightValue == 0 && heightValue.length >= 3) {
                if (typeOfHWcheckWithAdd == "IVWITHADDTOAST" || typeOfHWcheckInter == "IVINTER") {
                    showToastMsg2("Height cannot be zero");
                    $("#enter_weight").val("");
                } else {
                    showToastMsg1("Height cannot be zero");
                    $("#enter_weight").val("");
                }
            }
            $("#RxBmiValue").html("");
            $("#RxBsaValue").html("");
            $("#heightCheckOk").addClass('cstFieldDullRxNone');
        }
		 if ((weightValue ==null || weightValue == "" || weightValue.length > 1) &&  height_mandatory =="Y" && heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}	
		if ( (heightValue ==null || heightValue == "" || heightValue.length > 2 ) && weight_mandatory == "Y" && weightValue.length > 1) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}
		if (  height_weight_mandatory == "Y" && weightValue.length > 1 &&  heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}
    });
    //End
    //Weight Calculation	
    $('#enter_weight').on('input', function(event) {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
    // Allow only one dot In Weight
    document.getElementById('enter_weight').onkeypress = function(e) {
            if (e.keyCode === 46 && this.value.split('.').length === 2) {
                return false;
            }
        }
        //End

    $('#enter_weight').keyup(function() {
	 var weight_mandatory = $("#weight_mandatory").val();
     var height_mandatory = $("#height_mandatory").val();
	 var height_weight_mandatory = $("#height_weight_mandatory").val();
        heightValue = $("#enter_height").val();
        weightValue = $("#enter_weight").val();
        if ( weightValue.length > 1 && heightValue.length > 2) {
		   $("#heightCheckOk").removeClass('cstFieldDullRxNone');
            BmiBsaCalculation(heightValue, weightValue);
        }
		if(weightValue.length > 1 && parseInt(weightValue) ==0){
		$("#enter_weight").val("");
		}
		   if ((heightValue ==null || heightValue == "" || heightValue.length > 2 ) && weight_mandatory == "Y" && weightValue.length > 1) {
				$("#heightCheckOk").removeClass('cstFieldDullRxNone');
		  
			}	
			
			
			
		   if ((weightValue ==null || weightValue == "" || weightValue.length > 1) &&  height_mandatory =="Y" && heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		   }
		   if (  height_weight_mandatory == "Y" && weightValue.length > 1 &&  heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}
    });

    $('#enter_weight').focusout(function() {
	    var weight_mandatory = $("#weight_mandatory").val();
        var height_mandatory = $("#height_mandatory").val();
	    var height_weight_mandatory = $("#height_weight_mandatory").val();
        var typeOfHWcheckWithAdd = $("#typeOfHWcheckWithAdd").val();
        var typeOfHWcheckInter = $("#typeOfHWcheckInter").val();
        weightValue = $("#enter_weight").val();
        if (weightValue == null || weightValue == 0) {
            $("#RxBmiValue").html("");
            $("#RxBsaValue").html("");
            $("#heightCheckOk").addClass('cstFieldDullRxNone');
        }
		if(weightValue == null && weight_mandatory == "Y"){
	  $("#heightCheckOk").addClass('cstFieldDullRxNone');
	    showToastMsg2("Weight cannot be blank");
	}
	  
        if (weightValue != null && weightValue != 0 && weightValue.length < 2) {
            if (weightValue.length < 2) {
                if (typeOfHWcheckWithAdd == "IVWITHADDTOAST" || typeOfHWcheckInter == "IVINTER") {
                    showToastMsg2("Weight : Minimum number of digits should be 2");
                } else {
                    showToastMsg1("Weight : Minimum number of digits should be 2");
                }
            }
            if (weightValue == 0 && weightValue.length >= 2) {
                if (typeOfHWcheckWithAdd == "IVWITHADDTOAST" || typeOfHWcheckInter == "IVINTER") {
                    showToastMsg2("Height cannot be zero");
                    $("#enter_weight").val("");
                } else {
                    showToastMsg1("Height cannot be zero");
                    $("#enter_weight").val("");
                }
            }
            $("#RxBmiValue").html("");
            $("#RxBsaValue").html("");
            $("#heightCheckOk").addClass('cstFieldDullRxNone');
        }   	
		if ( (heightValue ==null || heightValue == "" || heightValue.length > 2 ) && weight_mandatory == "Y" && weightValue.length > 1) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}    
        if ((weightValue ==null || weightValue == "" || weightValue.length > 1) &&  height_mandatory =="Y" && heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}	
        if (  height_weight_mandatory == "Y" && weightValue.length > 1 &&  heightValue.length > 2) {
            $("#heightCheckOk").removeClass('cstFieldDullRxNone');
		}		
    });
    //end
    $("#cellblur").addClass("cstFieldDullRx");

    $('#NoteTypeFilterTxt').attr("placeholder", "Enter minimum 3 characters to search");
    var enterTypes = "";
});

function showTransactionMessage() {
    $("#transactionMsg").show();
    setTimeout(function() {
        $("#transactionMsg").hide();
    }, 5000);
    $("#transactionMsg").bind('click', function() {
        $(this).hide();
    });
}
function closeToast() {
    $("transactionMsg").hide();
}
function loadLegends() 
{    
    $("#pharBaseLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=pharBaseLegend' , function(res) {});
}

function assignBuildMAR(buildMAR_yn) {
}
