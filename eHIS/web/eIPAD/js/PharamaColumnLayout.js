var draggable = $("#PCT9700").data("kendoDraggable");
var count = 0;
var ordItemsHScroll_S;
var allElement = [];

function assignOrdItemsHScroll_S() {
    ordItemsHScroll_S = new IScroll('#OrdListHWrapper_A', {
        scrollX: true,
        scrollY: false,
        interactiveScrollbars: true,
        click: true,
        useTransition: false,
        hideScrollbar: true,
        scrollbars: true,
        bindToWrapper: true,
        fadeScrollbars: true
    });
    ordItemsHScroll_S.on('scrollStart', function() {
        removeDrag();
	    var ifCartOpened = $("#cartOpened").val();
	        if(ifCartOpened == "Y"){
		        $("#cartOpened").val("N");
                $("#cartView").hide();
                $("#cartWrapper").show();
                $("#cart").show();
	        }
    
    });
    ordItemsHScroll_S.on('scrollEnd', function() {});
}

//var frameHeight = getTotalPageDivHeight() - $('#EMHeader').height() - $('#EMFooter').height();
//$('#ChartFunctionPage').css("height" ,frameHeight );
//$('#ChartSummaryNotesIframe').css("height" ,frameHeight );

function onOriChange() {
    var allItems = [];
    var ordListColWrap = $('#' + "OrdListColWrap_A");
    $('.ordListcol').contents().unwrap();
    $('.single').contents().unwrap();
    var ordListColParent = ordListColWrap.parent();
    var ordListColItems1 = ordListColWrap.children();
    ordListColFormat(ordListColItems1, ordListColWrap);
}
/*$(window).on("orientationchange", function(event) {
	if( /Android/i.test(navigator.userAgent) ) {
setTimeout(function(){
   onOriChange(); 
    assignOrdItemsHScroll_S.refresh();
}, 500);
          }else{
			  //onOriChange();  
			 // assignOrdItemsHScroll_S.refresh(); 
		  }
  // assignOrdItemsHScroll_S();
});*/

function durgCodeCheck(drug) {
    var drugArray = [];
    for (var g = 0; g < allAddedDrug.length; g++) {
        var drugDetails = allAddedDrug[g];
		
		var order = drugDetails instanceof currentDrug; 
		
		//console.log("last_element::"+order);
		
		if(!order){
		
		var orderDetails=drugDetails;
		 drugArray.push(orderDetails.orderId);
		var drugInfo =orderDetails.drugInfo;
		
		for(var t=0;t< drugInfo.length;t++){
		
		var  currentElemDrug=drugInfo[t];
		//console.log("currentElemDrug:: **********"+JSON.stringify(currentElemDrug));
		 if (typeof currentElemDrug.currentid == 'number') {
            currentElemDrug.currentid = currentElemDrug.drugUnique.toString();
        }
		//console.log("currentElemDrug currentElemDrug******"+currentElemDrug.drugUnique);
        drugArray.push(currentElemDrug.drugUnique);
		
		}
		
		
		}else{
		//console.log(JSON.stringify(drugDetails));
		
        if (typeof drugDetails.drugUnique == 'number') {
            drugDetails.drugUnique = drugDetails.drugUnique.toString();
        }
		//console.log("drugUnique******"+drugDetails.drugUnique);
        drugArray.push(drugDetails.drugUnique);
		
		
		}
		
		
    }
	
	//console.log("drug ida drugArray drugArray"+JSON.stringify(drugArray)+"=========="+drug);
    return (drugArray.indexOf(drug) > -1);
}

function reArrageValues(ordListColItems) {
    var overAllHeight = $("#OrdItemscroller_A").outerHeight();
    ordListColItems.each(function() {
        var htmls = $(this).find("div");
        var element = $(this).find(".ordDraggable_A");
        $(element).attr('data-layerHeight', overAllHeight);
        var divCurrentsId = $(element).attr('data-currentid');
        var divHeight = $("#" + divCurrentsId).outerHeight();
        $(element).attr('data-divHeight', divHeight);
    });
}

function calculateAllowing() {
    this.height;
    this.allowing;
    this.remaingHeight;
}

function isAllowingLimit(ordListColItems) {
    var fullAllobject = new calculateAllowing();
    var fullHeight = 0;
    var allowCount = 0;
    var items = 0;
    ordListColItems.each(function() {
        var element = $(this).find(".ordDraggable_A");
        var divCurrentsId = $(element).attr('data-currentid');
        var dataLayerHeight = $(element).attr('data-layerHeight');
        var dataDivHeight = $(element).attr('data-divHeight');
        fullHeight = parseInt(dataDivHeight) + parseInt(fullHeight);
        items = items + 1;
        var spacing = parseInt(fullHeight) + parseInt(items) * parseInt(4);
        if (dataLayerHeight >= spacing) {
            allowCount = allowCount + 1;
            fullAllobject.height = fullHeight;
            fullAllobject.allowing = allowCount;
            fullAllobject.remaingHeight = parseInt(dataLayerHeight) - parseInt(fullHeight);
        } else {
            fullAllobject.height = fullHeight;
            fullAllobject.allowing = allowCount;
            fullAllobject.remaingHeight = parseInt(dataLayerHeight) - parseInt(fullHeight);
            return fullAllobject;
        }
    });
    return fullAllobject;
}
//Function that gives a columnar view to the orders list
function retainValue() {
    this.wholeHtml = [];
    this.previousCount = "";
}

function ordListColFormat(ordListColItems1, ordListColWrap) {
    var ordListColItems = ordListColItems1;
    reArrageValues(ordListColItems);
    sets = [];
    while (ordListColItems.length > 0) {
        var reps = isAllowingLimit(ordListColItems);
        var rows1 = reps.allowing;
        sets.push(ordListColItems.splice(0, rows1));
    }
    sets.forEach(function(set, i) {
        $set = $(set);
        $set.addClass('ordListColItem');
        $setLi = $('<li class="ordListcol"></li>');
        $setList = $('<ul class="single" style="padding-left: 0px; margin-top: 0px;" ></ul>');
        $setList.append($set);
        $setLi.append($setList);
        ordListColWrap.append($setLi);
    });
}

function draggableOnDragStart(e) {
    
	var ifCartOpened = $("#cartOpened").val();
	if(ifCartOpened == "Y"){
	   $("#cartOpened").val("N");
       $("#cartView").toggle();
       $("#cartWrapper").show();
       $("#cart").show();
	}
	
	$(e.currentTarget).addClass("cstFieldDullRx");
    $("#cartWrapper").hide();
    $("#cartExpandWrapper").show();
    $("#cartCountOnExpand").text(getCountOfCart());
    $("#shoppingCartText").text("Drop item here to add to cart");
}

function droptargetOnDragLeave(e) {
    ordItemsHScroll_S.options.momentum = false;
    $("#shoppingCartText").text("Try Again");
    $("#shoppingCartText").removeClass("shoppingCartText").addClass("shoppingCartTextOnLeave");
    $("#cartExpandWrapper").hide();
    $("#cartWrapper").show();
}

function droptargetOnDragEnter(e) {
    ordItemsHScroll_S.options.momentum = true;
    $("#shoppingCartText").text("Drop now !");
    $("#shoppingCartText").removeClass("shoppingCartText").addClass("shoppingCartTextOnLeave");
    $("#cartCountOnExpand").text(getCountOfCart());
}

function createCheckBox(DrugCode) {
    var checker = "";
    for (var t = 1; t < parseInt(allAddedDrug.length) + parseInt(1); t++) {
        var addCheck = "ck" + DrugCode + ",";
        checker += addCheck;
    }
    checker = checker.substr(0, checker.length - 1);
    return checker;
}
function order(){

    this.orderId = "";
    this.drugInfo=[];

}
function hideAllRealtedDrugs(elem) {
    var drugNameUniqueCode = elem.draggable.element.data("drugcodeunique");
    $("div[data-currentid]").each(function(index, value) {
        var drugCodeUnique = $(this).attr('data-drugcodeunique');
        var divId = $(this).attr('data-currentid');
        if (drugNameUniqueCode == drugCodeUnique) {
            var dragger = $("#" + divId).data("kendoDraggable");
            if (dragger != undefined) {
                $("#" + divId).data("kendoDraggable").destroy();
                $("#" + divId).addClass("cstFieldDullRx");
            }
        }
        $(this).attr("data-role", "draggable");
    });
}

function previousOrder(allDrugs,allDrugsUnique,elem){
	
	var validationPath = path + '/mobile/charts/pharmacy/PharmValidationJSONServlet?mode=VALIDATE_ADDTOCART';
	var drugs=allDrugs.split(',');
	var order_id =elem.draggable.element.data("orderid");
	var drugsUnique=allDrugsUnique.split(',');
	var orders =new order();
	orders.orderId=order_id;
	var drugTypeCode;
	for (var i = 0; i < drugs.length; i++) {
		var durgFromOrder=drugs[i];
		var durgFromOrderUnique=drugsUnique[i];	
		var currentDr = new currentDrug();
		var currentid = elem.draggable.element.data("currentid");
		var drugName = elem.draggable.element.data("drugname");
		var drugcode = durgFromOrder+"_T";
		drugTypeCode = elem.draggable.element.data("drugtypecode");
		var orderId = elem.draggable.element.data("orderid");
		var ivrxIsPresent = elem.draggable.element.data("ivrxispresent");
		var drugcodeunique = durgFromOrderUnique;
		var PharmPrescriptionMode = $("input[name=PharmPrescriptionMode]").val();
		currentDrug.PharmPrescriptionMode = PharmPrescriptionMode;
		var OrderTypeCodes = "";
		var tradecodes = elem.draggable.element.data("tradecodes");
		var tradename = elem.draggable.element.data("tradename");
		var rxpos = elem.draggable.element.data("rxpos");
		var prior = elem.draggable.element.data("priority");
		currentDr.drugname = drugName;
		currentDr.order_id=order_id;    	
		//	if(drugTypeCode=="Rx"){		
			//	currentDr.drugCode = durgFromOrder;
		//}else{
			
			if(tradecodes==undefined || tradecodes=="" ){
				
		currentDr.drugCode = durgFromOrderUnique+"_T";		
		
			}else{
				
			currentDr.drugCode = durgFromOrderUnique+"_"+tradecodes;			
			}
		//}
		currentDr.drugUnique = drugcodeunique;	
		var DrugCode = durgFromOrderUnique;
		
		
	
		if(drugTypeCode=="Rx"){
			DrugCode = durgFromOrder;
			currentDr.DrugCode = durgFromOrder;
		}else{
			DrugCode = durgFromOrder;
			currentDr.DrugCode = durgFromOrder;
		}	
		// currentDr.DrugCode = DrugCode;
		var OrderTypeCode = OrderTypeCodes;
		currentDr.OrderTypeCode = OrderTypeCode;
		var OrderCatCode = "PH";
		currentDr.OrderCatCode = OrderCatCode;
		currentDr.drug_type = drugTypeCode;
	    currentDr.orderFrom = "po";
		currentDr.rxPos = rxpos;
	
		var TradeCodes = tradecodes;
		currentDr.TradeCodes = TradeCodes;
		var TradeNames = tradename;
		currentDr.TradeNames = TradeNames;
		var Priority = prior;
		currentDr.Priority = Priority;
		currentDr.checkboxValues = "";
		var take_home_medication = $("input[name=take_home_medication]").val();
		currentDr.take_home_medication = take_home_medication;
		var order_set_code = $("input[name=order_set_code]").val();
		currentDr.order_set_code = order_set_code;
		var drug_db_interface_yn = $("input[name=drug_db_interface_yn]").val();
		currentDr.drug_db_interface_yn = drug_db_interface_yn;
		var act_patient_class = $("input[name=act_patient_class]").val();
		currentDr.act_patient_class = act_patient_class;
		var home_leave_yn_val = $("input[name=home_leave_yn_val]").val();
		currentDr.home_leave_yn_val = home_leave_yn_val;
		var location_type = $("input[name=location_type]").val();
		currentDr.location_type = location_type;
		var location_code = $("input[name=location_code]").val();
		currentDr.location_code = location_code;
		var height = $("#height").val();
		var weight = $("#weight").val();
		currentDr.height = height;
		currentDr.weight = weight;
		var PharmPrescriptionMode = $("#PharmPrescriptionMode").val()
		currentDr.PharmPrescriptionMode = PharmPrescriptionMode;
		//for validation
		var previligegroupdrugordering_yn = elem.draggable.element.data("previligegroupdrugordering_yn");
		var diagnosis_found_yn = elem.draggable.element.data("diagnosis_found_yn");
		var appl_for_age_grp_yn = elem.draggable.element.data("appl_for_age_grp_yn");
		var call_staus = "load";
		var in_formulary = elem.draggable.element.data("in_formulary");
		var drug_class = elem.draggable.element.data("drug_class");
		currentDr.in_formulary = in_formulary;
		currentDr.drug_class = drug_class;
	   	orders.drugInfo.push(currentDr);
}


if(drugTypeCode=="IVD" || drugTypeCode=="IVPB"){
     var drugInfo =orders.drugInfo;
     for(var t=1;t< drugInfo.length;t++){
		var curreDrug=drugInfo[t];
		allAddedDrug.push(curreDrug);
     }
     allAddedDrug.push(orders);

}else{
	
	 var drugInfo =orders.drugInfo;
		
		for(var t=0;t< drugInfo.length;t++){
		
		var curreDrug=drugInfo[t];
		
		allAddedDrug.push(curreDrug);
		
		}
allAddedDrug.push(orders);
}

//console.log("allAddedDrug allAddedDrug"+JSON.stringify(allAddedDrug)+"ends::");



    var checkboxValues = createCheckBox(DrugCode);
    var last_element = allAddedDrug[allAddedDrug.length - 1];
    last_element.checkboxValues = checkboxValues;
    var take_medication_yn_dis = $("input[name=take_medication_yn_dis]").val();
    /*if (take_medication_yn_dis != "disabled") {
        errorMessageLoad("discharge medication", "0", "Do you want to treat this as patient's discharge medication?", "trueClickDialog(this)", "cancelClickDialog(this)", "discharge_medication");
    }*/
    if (previligegroupdrugordering_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("previligegroupdrugordering_yn", 1, "You do not have sufficient privileges to order this drug. Please contact your administrator.  ", "okClickDrugPrev", "no", "previligegroupDrug");
    }
    var diag_size = $("input[name=diag_size]").val();
    var allow_without_diag = $("input[name=allow_without_diag]").val();

    /*if (allow_without_diag == "N" && parseInt(diag_size) == 0) {
        call_staus = "not_load";
        errorMessageLoad("allow_without_diag", 1, "You must record a diagnosis before placing pharmacy orders for this patient", "okClick", "no", "allow_without_diag");
    }*/
    if (appl_for_age_grp_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("appl_for_age_grp_yn", 1, "This drug is not applicable for the patient's age group and cannot be prescribed", "okClickAge", "no", "Age group Not Allowed");
    }
    if (diagnosis_found_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("diagnosis_found_yn", 1, "Required diagnosis for prescribing the drug is not found", "okClickPrescribingDrugPrev", "no", "Required diagnosis for prescribing the drug is not found");
    }
    if (call_staus == "load") {
        $.getJSON(validationPath, {
                DrugCode: DrugCode,
                OrderTypeCode: OrderTypeCodes,
                OrderCatCode: OrderCatCode,
                check_box_value: checkboxValues,
                TradeCodes: TradeCodes,
                TradeNames: TradeNames,
                Priority: Priority,
                take_home_medication: take_home_medication,
                order_set_code: order_set_code,
                drug_db_interface_yn: drug_db_interface_yn,
                act_patient_class: act_patient_class,
                home_leave_yn_val: home_leave_yn_val,
                location_type: location_type,
                location_code: location_code,
                source_code: location_code,
                height: height,
                weight: weight,
                in_formulary: in_formulary,
                drug_class: drug_class,
                PharmPrescriptionMode: PharmPrescriptionMode,
                drugTypeCode:drugTypeCode,
                ivrxIsPresent:ivrxIsPresent,
                orderId:orderId
            })
            .done(function(json) {
            	//console.log(json);
                var result = json.validationResult;
                var res = json.validationResult;
                var errorItems = json.errorItems;
                var errorItemsSize = errorItems.length;
                for (var e = 0; e < errorItemsSize; e++) {
                    var errorMess = errorItems[e];
                    if (errorMess) {
					var errorDetails = errorMess.errorDetails;
					var severity_level;
                    var significant_level;
					var interaction_desc;
					var probability;
					
					
                        var errorMessageId = errorMess.errorMessageId;
                        var errorMessage = errorMess.errorMessage;
                        if (res == 2) {
                            if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY" || errorMessageId == "HEIGHTWEIGHT_MANDATORY" || errorMessageId == "WEIGHT_MANDATORY")) {							
							if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY")) {
							$("#height_mandatory").val("Y");
							$("#ht_mandatory").show();							
							}
							else if (errorMessageId && (errorMessageId == "HEIGHTWEIGHT_MANDATORY")) {
							$("#height_weight_mandatory").val("Y");
							$("#ht_mandatory").show();
							$("#wt_mandatory").show();
							}
							else if (errorMessageId && (errorMessageId == "WEIGHT_MANDATORY")) {
							$("#weight_mandatory").val("Y");
							$("#wt_mandatory").show();
							}							
                                errorMessageLoad(errorMessageId, res, "Please provide height and weight as this is mandatory to place the order", "closeHWPopupOK(this)", "no", "HeightandWeight");
                            };
                        } else if (res == 1) {
                            if (errorMessageId && errorMessageId == "STOCK_UNAVAILABLE") {
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickStock", "no", "STOCK_UNAVAILABLE");
                            }
							
							if (errorMessageId && errorMessageId == "EXCEPTION_OCCURED") {
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickException", "no", "EXCEPTION_OCCURED");
                            }
							
							
                            if (errorMessageId && errorMessageId == "DRUG_INTERACTION") {
                            	if(errorDetails){
                            		 severity_level = errorDetails.severity_level;	
                            		 significant_level = errorDetails.significant_level;	
                            		 interaction_desc = errorDetails.interaction_desc;
                            		 probability = errorDetails.probability;
                            	}
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrug", "no", "DRUG_INTERACTION",severity_level,significant_level, interaction_desc, probability);
                                drugInteractionLevel = "1_not";
                            }
                            if (errorMessageId && errorMessageId == "DUPLICATE_DRUG"  ||errorMessageId =="DUPLICATE_ITEM" ) {
                                drugDupStatus = res;
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrugDup", "no", "DUPLICATE_DRUG");
                            }

                            if (errorMessageId && errorMessageId == "ADDITIVE_ALREADY_SELECTED") {
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickAlreadySelected", "no", "ADDITIVE_ALREADY_SELECTED");
                            }

                        } else if (res == 0) {
                            if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY" || errorMessageId == "HEIGHTWEIGHT_MANDATORY" || errorMessageId == "WEIGHT_MANDATORY")) {
                                errorMessageLoad(errorMessageId, res, "Please provide height and weight as this is mandatory to place the order", "closeHWPopupOK(this)", "no", "HeightandWeight");
                            }
                            if (errorMessageId && errorMessageId == "DRUG_INTERACTION" ) {
                            	if(errorDetails){
                            		severity_level = errorDetails.severity_level;	
		                    		significant_level = errorDetails.significant_level;	
		                    		interaction_desc = errorDetails.interaction_desc;
		                    		probability = errorDetails.probability;
                            	}
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrug", "no", "DRUG_INTERACTION",severity_level,significant_level, interaction_desc, probability);
                                drugInteractionLevel = "0_yes";
                            }
                            if (errorMessageId && errorMessageId == "DUPLICATE_DRUG" ||errorMessageId =="DUPLICATE_ITEM") {
                                drugDupStatus = res;
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrugDup", "no", "DUPLICATE_DRUG");
                            }
							
                        }
                    }
                }
                showAllAlerts();
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');				
				var ifCartOpened = $("#cartOpened").val();
	            if(ifCartOpened == "Y"){
		            loadAlldata();
	            }
				$("#enter_height").val($("#height").val());
				$("#enter_weight").val($("#weight").val());
            })
        .fail(function(jqxhr, textStatus, error) {
            var err = textStatus + ", " + error;
        });
    }
    if (call_staus == "not_load") {       
        showAllAlerts();
    }

}




function addBeforeValidation(elem) {

    hideAllRealtedDrugs(elem);
    var validationPath = path + '/mobile/charts/pharmacy/PharmValidationJSONServlet?mode=VALIDATE_ADDTOCART';
    var currentDr = new currentDrug();
    var currentid = elem.draggable.element.data("currentid");
    var drugName = elem.draggable.element.data("drugname");
    var drugcode = elem.draggable.element.data("drugcode");
    var drugTypeCode = elem.draggable.element.data("drugtypecode");
    var orderId = elem.draggable.element.data("orderid");
    var ivrxIsPresent = elem.draggable.element.data("ivrxispresent");
    var drugcodeunique = elem.draggable.element.data("drugcodeunique");
    var PharmPrescriptionMode = $("input[name=PharmPrescriptionMode]").val();
    currentDrug.PharmPrescriptionMode = PharmPrescriptionMode;
    var OrderTypeCodes = "";
    var tradecodes = elem.draggable.element.data("tradecodes");
    var tradename = elem.draggable.element.data("tradename");
    var prior = elem.draggable.element.data("priority");
    currentDr.drugname = drugName;
    currentDr.drugCode = currentid;
    currentDr.order_id="0";
    currentDr.drugUnique = drugcodeunique;
    var DrugCode = drugcode;
    currentDr.DrugCode = DrugCode;
    var OrderTypeCode = OrderTypeCodes;
    currentDr.OrderTypeCode = OrderTypeCode;
    var OrderCatCode = "PH";
    currentDr.OrderCatCode = OrderCatCode;
    var TradeCodes = tradecodes;
    currentDr.TradeCodes = TradeCodes;
    var TradeNames = tradename;
    currentDr.TradeNames = TradeNames;
    var Priority = prior;
    currentDr.Priority = Priority;
    currentDr.checkboxValues = checkboxValues;
    var take_home_medication = $("input[name=take_home_medication]").val();
    currentDr.take_home_medication = take_home_medication;
    var order_set_code = $("input[name=order_set_code]").val();
    currentDr.order_set_code = order_set_code;
    var drug_db_interface_yn = $("input[name=drug_db_interface_yn]").val();
    currentDr.drug_db_interface_yn = drug_db_interface_yn;
    var act_patient_class = $("input[name=act_patient_class]").val();
    currentDr.act_patient_class = act_patient_class;
    var home_leave_yn_val = $("input[name=home_leave_yn_val]").val();
    currentDr.home_leave_yn_val = home_leave_yn_val;
    var location_type = $("input[name=location_type]").val();
    currentDr.location_type = location_type;
    var location_code = $("input[name=location_code]").val();
    currentDr.location_code = location_code;
    var height = $("#height").val();
    var weight = $("#weight").val();
    currentDr.height = height;
    currentDr.weight = weight;
    var PharmPrescriptionMode = $("#PharmPrescriptionMode").val()
    currentDr.PharmPrescriptionMode = PharmPrescriptionMode;
    //for validation
    var previligegroupdrugordering_yn = elem.draggable.element.data("previligegroupdrugordering_yn");
    var diagnosis_found_yn = elem.draggable.element.data("diagnosis_found_yn");
    var appl_for_age_grp_yn = elem.draggable.element.data("appl_for_age_grp_yn");
    var call_staus = "load";
    var in_formulary = elem.draggable.element.data("in_formulary");
    var drug_class = elem.draggable.element.data("drug_class");
    currentDr.in_formulary = in_formulary;
    currentDr.drug_class = drug_class;
    allAddedDrug.push(currentDr);

	

    var checkboxValues = createCheckBox(DrugCode);
    var last_element = allAddedDrug[allAddedDrug.length - 1];
	//console.log("type as::"+typeof(last_element));
	
	var a = last_element instanceof errorItem; 
	
	//console.log("aaaa"+a);
	
	
    last_element.checkboxValues = checkboxValues;
    var take_medication_yn_dis = $("input[name=take_medication_yn_dis]").val();
    /*if (take_medication_yn_dis != "disabled") {
        errorMessageLoad("discharge medication", "0", "Do you want to treat this as patient's discharge medication?", "trueClickDialog(this)", "cancelClickDialog(this)", "discharge_medication");
    }*/
    if (previligegroupdrugordering_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("previligegroupdrugordering_yn", 1, "You do not have sufficient privileges to order this drug. Please contact your administrator.  ", "okClickDrugPrev", "no", "previligegroupDrug");
    }
    var diag_size = $("input[name=diag_size]").val();
    var allow_without_diag = $("input[name=allow_without_diag]").val();

    /*if (allow_without_diag == "N" && parseInt(diag_size) == 0) {
        call_staus = "not_load";
        errorMessageLoad("allow_without_diag", 1, "You must record a diagnosis before placing pharmacy orders for this patient", "okClick", "no", "allow_without_diag");
    }*/
    if (appl_for_age_grp_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("appl_for_age_grp_yn", 1, "This drug is not applicable for the patient's age group and cannot be prescribed", "okClickAge", "no", "Age group Not Allowed");
    }
    if (diagnosis_found_yn == "N") {
        call_staus = "not_load";
        errorMessageLoad("diagnosis_found_yn", 1, "Required diagnosis for prescribing the drug is not found", "okClickPrescribingDrugPrev", "no", "Required diagnosis for prescribing the drug is not found");
    }
    if (call_staus == "load") {
        $.getJSON(validationPath, {
                DrugCode: DrugCode,
                OrderTypeCode: OrderTypeCodes,
                OrderCatCode: OrderCatCode,
                check_box_value: checkboxValues,
                TradeCodes: TradeCodes,
                TradeNames: TradeNames,
                Priority: Priority,
                take_home_medication: take_home_medication,
                order_set_code: order_set_code,
                drug_db_interface_yn: drug_db_interface_yn,
                act_patient_class: act_patient_class,
                home_leave_yn_val: home_leave_yn_val,
                location_type: location_type,
                location_code: location_code,
                height: height,
                weight: weight,
                in_formulary: in_formulary,
                drug_class: drug_class,
                PharmPrescriptionMode: PharmPrescriptionMode,
                drugTypeCode:drugTypeCode,
                ivrxIsPresent:ivrxIsPresent,
                orderId:orderId
            })
            .done(function(json) {
            	//console.log(json);
                var result = json.validationResult;
                var res = json.validationResult;
                var errorItems = json.errorItems;
                var errorItemsSize = errorItems.length;
                for (var e = 0; e < errorItemsSize; e++) {
                    var errorMess = errorItems[e];
                    if (errorMess) {
					var errorDetails = errorMess.errorDetails;
					var severity_level;
                    var significant_level;
					var interaction_desc;
					var probability;	

                        var errorMessageId = errorMess.errorMessageId;
                        var errorMessage = errorMess.errorMessage;
                        if (res == 2) {
                            if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY" || errorMessageId == "HEIGHTWEIGHT_MANDATORY" || errorMessageId == "WEIGHT_MANDATORY")) {							
							if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY")) {
							$("#height_mandatory").val("Y");
							$("#ht_mandatory").show();							
							}
							else if (errorMessageId && (errorMessageId == "HEIGHTWEIGHT_MANDATORY")) {
							$("#height_weight_mandatory").val("Y");
							$("#ht_mandatory").show();
							$("#wt_mandatory").show();
							}
							else if (errorMessageId && (errorMessageId == "WEIGHT_MANDATORY")) {
							$("#weight_mandatory").val("Y");
							$("#wt_mandatory").show();
							}							
                                errorMessageLoad(errorMessageId, res, "Please provide height and weight as this is mandatory to place the order", "closeHWPopupOK(this)", "no", "HeightandWeight");
                            };
                        } else if (res == 1) {
                            if (errorMessageId && errorMessageId == "STOCK_UNAVAILABLE") {
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickStock", "no", "STOCK_UNAVAILABLE");
                            }
                            if (errorMessageId && errorMessageId == "DRUG_INTERACTION") {
                            	if(errorDetails){
                            		 severity_level = errorDetails.severity_level;	
                            		 significant_level = errorDetails.significant_level;	
                            		 interaction_desc = errorDetails.interaction_desc;
                            		 probability = errorDetails.probability;
                            	}
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrug", "no", "DRUG_INTERACTION",severity_level,significant_level, interaction_desc, probability);
                                drugInteractionLevel = "1_not";
                            }
                            if (errorMessageId && errorMessageId == "DUPLICATE_DRUG" ||errorMessageId =="DUPLICATE_ITEM") {
                                drugDupStatus = res;
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrugDup", "no", "DUPLICATE_DRUG");
                            }

                            if (errorMessageId && errorMessageId == "ADDITIVE_ALREADY_SELECTED") {
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickAlreadySelected", "no", "ADDITIVE_ALREADY_SELECTED");
                            }

                        } else if (res == 0) {
                            if (errorMessageId && (errorMessageId == "HEIGHT_MANDATORY" || errorMessageId == "HEIGHTWEIGHT_MANDATORY" || errorMessageId == "WEIGHT_MANDATORY")) {
                                errorMessageLoad(errorMessageId, res, "Please provide height and weight as this is mandatory to place the order", "closeHWPopupOK(this)", "no", "HeightandWeight");
                            }
                            if (errorMessageId && errorMessageId == "DRUG_INTERACTION") {
                            	if(errorDetails){
                            		severity_level = errorDetails.severity_level;	
		                    		significant_level = errorDetails.significant_level;	
		                    		interaction_desc = errorDetails.interaction_desc;
		                    		probability = errorDetails.probability;
                            	}
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrug", "no", "DRUG_INTERACTION",severity_level,significant_level, interaction_desc, probability);
                                drugInteractionLevel = "0_yes";
                            }
                            if (errorMessageId && errorMessageId == "DUPLICATE_DRUG"  ||errorMessageId =="DUPLICATE_ITEM") {
                                drugDupStatus = res;
                                errorMessageLoad(errorMessageId, res, errorMessage, "okClickDrugDup", "no", "DUPLICATE_DRUG");
                            }
                        }
                    }
                }
                showAllAlerts();
				$("#completePlaceOrdersConfirm").removeClass('completePlaceOrdersDisable');				
				var ifCartOpened = $("#cartOpened").val();
	            if(ifCartOpened == "Y"){
		            loadAlldata();
	            }
				$("#enter_height").val($("#height").val());
				$("#enter_weight").val($("#weight").val());
            })
        .fail(function(jqxhr, textStatus, error) {
            var err = textStatus + ", " + error;
        });
    }
    if (call_staus == "not_load") {       
        showAllAlerts();
    }
}



function DrugInteraction_Documentation(probability){
	var documentation = "";
	if(probability != null && probability == "E")
	 documentation = "Established";
	else if(probability != null && probability == "P")
	 documentation = "Probable";
	else if(probability != null && probability == "S")
	 documentation = "Suspected";
	else if(probability != null && probability == "O")
	 documentation = "Possible";
	else if(probability != null && probability == "U")
	 documentation = "Unlikely";
	 return  documentation;
}

function DrugInterSeverity(severity_level){
	var severity = "";
	if(severity_level != null && severity_level == "L")
	 severity = "Minor";
	else if(severity_level != null && severity_level == "M")
	 severity = "Moderate";
	else if(severity_level != null && severity_level == "H")
	 severity = "Major";	
	 return  severity;
}

function droptargetOnDrop(e) {
    currentElement = e;
    ordItemsHScroll_S.enable();
	var previosOrderAllDrugs= String(e.draggable.element.data("drugcodesall"));
	var previosOrderUniqueAllDrugs= String(e.draggable.element.data("druguniqueall"));	
	var previosOrder=e.draggable.element.data("previous");
	var drugtypecodes = e.draggable.element.data("drugtypecode");	
	if(previosOrder=="po"){
		if(drugtypecodes=="IVD"|| drugtypecodes=="IVWA"|| drugtypecodes=="IVPB"){
			previousOrder(previosOrderAllDrugs,previosOrderUniqueAllDrugs,e);
			}
		else{
			previousOrder(previosOrderAllDrugs,previosOrderUniqueAllDrugs,e);
			}
	}else{
		addBeforeValidation(e);
	}   
    e.draggable.element.addClass("cstFieldDullRx");
    e.draggable.destroy();
    ordItemsHScroll_S.options.momentum = true;
    count = count + 1;
    $("#cartExpandWrapper").hide();
    $("#cartWrapper").show();
    $("#cartCount").text(getCountOfCart());
    $("#countDisplay").text(getCountOfCart());
}

function draggableOnDragEnd(e) {
	ordItemsHScroll_S.enable();
    $(e.currentTarget).removeClass("cstFieldDullRx");
    $("#cartExpandWrapper").hide();
    $("#cartWrapper").show();
}

function removeDrag() {
    $("div[data-currentid]").each(function(index, value) {
        var divId = $(this).attr('data-currentid');
        $(this).children().toggleClass("disabled");
    });
}

function addDrag() {
    $("div[data-currentid]").each(function(index, value) {
        var divId = $(this).attr('data-currentid');
        $(this).attr("data-role", "draggable");
    });
}

function createDragAndDrop(cur) {
    var divId = $(cur).attr('data-currentid');
    $("#" + divId).removeClass("cstFieldDullRx");
    $("#" + divId).kendoDraggable({
        holdToDrag: true,
        hold: function(e) {
        	ordItemsHScroll_S.disable();
        },
        hint: function(element) {
            return element.clone();
        },
        dragstart: draggableOnDragStart,
        dragend: draggableOnDragEnd
    });
    $("#" + divId).data("kendoDraggable")
        .userEvents
        .minHold = 65;
}
function checkForStock() {   
    $("div[data-currentid]").each(function(index, value) {
        var divId = $(this).attr('data-currentid');
        var stock_yn = $(this).attr('data-stock_yn');
        var allow_yn = $(this).attr('data-allow_yn');
        var avl_qty = $(this).attr('data-avl_qty');
        var dragger = $("#" + divId).data("kendoDraggable");       
        checkAndAddDrag(stock_yn, allow_yn, dragger, divId);
    });
}

function checkAndAddDrag(stock_yn, allow_yn, dragger, divId) {
    if (allow_yn == "N" && stock_yn == "N") {
        if (dragger != undefined) {
            $("#" + divId).data("kendoDraggable").destroy();
            $("#" + divId).addClass("cstFieldDullRx");
        }
    }}

function dragAndDrop() {
    $("div[data-currentid]").each(function(index, value) {
        var divId = $(this).attr('data-currentid');
        var durgCodeUnique = $(this).attr('data-drugcodeunique');
		   var drugtypecode = $(this).attr('data-drugtypecode');
		   var durgCodeContains = durgCodeCheck(durgCodeUnique);  
		   if(drugtypecode=="CRx"){
			   $(this).addClass("cstFieldDullRx");
			   
		   }else{
			   
		 if (durgCodeContains == false) {
            createDragAndDrop(this);
        } else {
            $(this).addClass("cstFieldDullRx");
        }
	 }
            
        
    });

    checkForStock();
    $("#dropBasket").kendoDropTarget({
        dragenter: droptargetOnDragEnter,
        dragleave: droptargetOnDragLeave,
        drop: droptargetOnDrop
    });
    
}

if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',
				myOrientResizeFunctionPharmacy, false);
	}
    function myOrientResizeFunctionPharmacy() {
    	setTimeout(function() {
    	var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
    	
    	if (orient == "landscape") {
    		onOriChange();  
       	 	ordItemsHScroll_S.refresh(); 
    	
    	} else {
    		onOriChange();  
       	 	ordItemsHScroll_S.refresh(); 
    	}
    	 
    }, 1000);
    }
   // myOrientResizeFunction();