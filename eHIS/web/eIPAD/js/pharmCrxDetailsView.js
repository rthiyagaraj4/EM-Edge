//var ivrxWithAddCalcBy = $("#drugCount").val(); // defined length of additives
var PrescribingBase="S";
var freqArray = [];
var durnArray = [];
durnArray.push({code:'D',desp:'Day(s)'}); 
durnArray.push({code:'W',desp:'Week(s)'});
durnArray.push({code:'L',desp:'Month(s)'});
durnArray.push({code:'Y',desp:'Year(s)'});

var formobj = document.formCRXPrescriptionDetails;

//console.log("durnArray: "+durnArray.length);

var rec_no;
 $("#freq_value_crx").kendoDropDownList({
        valuePrimitive: true,
        change: freqChange,
    });

   $("#durn_desc_crx").kendoDropDownList({
        valuePrimitive: true,
        change: validateDuration,
    });		
	
var dosageUnit = $("#dosageUOM").kendoDropDownList({
});	

document.getElementById("dosageUOM").selectedIndex = "0";

var reqQtyUnit = $("#req_qty_UOM").kendoDropDownList({
	valuePrimitive: true,
	optionLabel: "SELECT"
});	

document.getElementById("req_qty_UOM").selectedIndex = "0";

var final_prod_qty_uom = $("#final_prod_qty_uom").kendoDropDownList({
	valuePrimitive: true,
	optionLabel: "SELECT"
});	

document.getElementById("final_prod_qty_uom").selectedIndex = "0";

var pharmCRxDetailsScroller_Strength;
var pharmCRxDetailsScroller_Ratio;
var pharmCRxDetailsScroller_Percentage;
var pharmCRxAdminScroller;

function assignPharmCRxDetailsScroller_Strength() {
    pharmCRxDetailsScroller_Strength = new IScroll('#CRx_strength', {
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
    if (pharmCRxDetailsScroller_Strength != null) {
        pharmCRxDetailsScroller_Strength.refresh();
    }
}

function assignPharmCRxDetailsScroller_Ratio() {
	pharmCRxDetailsScroller_Ratio = new IScroll('#CRx_ratio', {
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
    if (pharmCRxDetailsScroller_Ratio != null) {
        pharmCRxDetailsScroller_Ratio.refresh();
    }
}

function assignPharmCRxDetailsScroller_Percentage() {	
    pharmCRxDetailsScroller_Percentage = new IScroll('#CRx_Percentage', {
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
    if (pharmCRxDetailsScroller_Percentage != null) {
        pharmCRxDetailsScroller_Percentage.refresh();
    }
}

function openDrugDetailsTab() {
    $("#CRxDrug").show();
    $("#CRxAdmin").hide();
    $("#CRxDrug").css("color", "#096b93");
    $("#CRxAdminTab").css({
        "color": "#313844",
        "border-bottom": "none"
    });

    $("#CRxDrugTab").css({
        "color": "#096b93",
        "border-bottom": "#2a8fbd 2px solid"
    });	
}
function openAdminDetailsTab() {
        $("#CRxDrug").hide();
        $("#CRxAdmin").show();
        $("#CRxDrugTab").css({
            "color": "#313844",
            "border-bottom": "none"
        });
        $("#CRxAdminTab").css({
            "color": "#096b93",
            "border-bottom": "#2a8fbd 2px solid"
        });
       /* if (pharmCRxAdminScroller != null) {
            pharmCRxAdminScroller.refresh();
        } */
}

function clearDrugDetails(count) {
    var ddl = $("#req_qty_UOM").data("kendoDropDownList");
    if (ddl)
        ddl.select(-1);
    ddl = $("#final_prod_qty_uom").data("kendoDropDownList");
    if (ddl)
        ddl.select(-1);
    ddl = $("#final_prod_qty").data("kendoDropDownList");
    if (ddl)
        ddl.select(-1);
    var PresByBase = formobj.prescribingBy.value;

    if (PresByBase != "S") {
        ddl = $("#dosageUOM").data("kendoDropDownList");
        if (ddl)
            ddl.select(-1);
    }
    document.getElementById("final_prod_qty").value = "";
    document.getElementById("final_prod_qty_P").value = "";
    $("#total_ratio_display").html('');
    $("#total_qty_display").html('');
    $("#total_qty_percent_display").html('');
	
    for (var i = 0; i < count; i++) {
        document.getElementById("strengthQty_" + i).value = "";
        document.getElementById("ratio_value_" + i).value = "";
        document.getElementById("ratio_req_qty_" + i).value = "";
        document.getElementById("ratio_derived_qty_" + i).value = "";
        document.getElementById("percent_ratio" + i).value = "";
        document.getElementById("req_qty_p" + i).value = "";
        document.getElementById("derived_qty_p" + i).value = "";
        document.getElementById("drugRemTextarea_R" + i).value = "";
        document.getElementById("drugRemTextarea_P" + i).value = "";
        document.getElementById("drugRemTextarea_S" + i).value = "";
	document.getElementById("baseDrug"+i).enabled = true;
	document.getElementById("baseDrug"+i).checked = false;	
    }
}


function closeCrxDetailsView() {
	operationFlag = true;
    $("#confirmMsg").show();
	$("#typeOfHWcheckWithAdd").val("");
	$("#typeOfHWcheckInter").val("");	
}

function okClickDialog() {
    $("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
}

function cancelClickDialog() {
    $("#confirmMsg").hide();
}

function showToastMsg(content) {
//	console.log("show toast msg");
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

function completeCRxDetailsConfirm(){	
	 var formobj = document.formCRXPrescriptionDetails;
	 var drugCount=formobj.allDrugs_count.value;

    var PresByBase="S";
	PresByBase=formobj.prescribingBy.value;	
	if(PresByBase==""){
		PresByBase="S";
	}

	if(PresByBase=="P" || PresByBase=="R"  ){
	for(var t=0;t<parseInt(drugCount); t++){
		
			 calculateDerivedQuantity(t,PresByBase);
			//result_factor
	}
	}
	if(checkForInsert()){		
		release();
	}	
}

function checkForAvaliable(pos,value){

	var formobj = document.formCRXPrescriptionDetails;
	var drugCount=formobj.allDrugs_count.value;
	var absoluteQty = value + parseInt(parseInt(pos)-parseInt(1));	
	if(pos<= parseInt(drugCount)){		
	var  Currvalue=   encodeURIComponent(document.getElementById(absoluteQty).value, "UTF-8");		
	return Currvalue;		
	}else{		
		return "";
	}	
	return "";
}

function getAllUserEnterValues(currentID){	
	var currentArray=[];
	var drugCount=formobj.allDrugs_count.value;
	
	for(var intex=0;intex<10;intex++)
			{
				if(intex<parseInt(drugCount)){
				//	console.log("currentID+intex::"+currentID+intex);
			var  Currvalue=    document.getElementById(currentID+intex).value;
			currentArray[intex]= Currvalue;
		}else{
			currentArray[intex]= "";
		}	
		}	
	return  currentArray;
}

function getAllUserEnterValuesBaseDrug(currentID){
	
	
	
		
		
	var currentArray=[];
	var drugCount=formobj.allDrugs_count.value;
	
	for(var intex=0;intex<10;intex++)
			{
		if(intex<parseInt(drugCount)){
				//	console.log("currentID+intex::"+currentID+intex);
		if($("#baseDrug"+intex).is(":checked")){
               // alert("Checkbox is checked.");
			
				currentArray[intex]= "Y";
            }
            else if($("#baseDrug"+intex).is(":not(:checked)")){
             
		       currentArray[intex]= "N";
		}
		
			
			
		}else{
			currentArray[intex]= "N";
		}	
		}	
	return  currentArray;
	
}

function checkForEmptyoverRideReasons(currentID,overrideId){	
		
	var retStat=true;

	var formobj = document.formCRXPrescriptionDetails;
	var drugCount=formobj.allDrugs_count.value;
	 
	for(var t=0;t<parseInt(drugCount); t++){
		
			var overValue = currentID + parseInt(parseInt(t));
			var overReasony_n = overrideId + parseInt(parseInt(t));
		//	console.log("overReasony_n overReasony_n overReasony_n::"+overReasony_n);
			var overValueIsFound=document.getElementById(overReasony_n).value;
			
			if(overValueIsFound=="Y"){
			var  Currvalue=    document.getElementById(overValue).value;
			if (trimCheck(Currvalue) == "" || parseFloat(Currvalue) == 0 ){		
			//showToastMsg(" dosage cannot be blank or Zero");
             retStat = false;
		     return retStat;
			}
		}			
	}	
	return retStat;
}



function getAllUserOverrriderValues(currentID,overrideId){
	
	var currentArray=[];
	var drugCount=formobj.allDrugs_count.value;
	
	for(var intex=0;intex<10;intex++)
		{
	//		console.log("currentID::"+currentID+intex);
			if(intex<parseInt(drugCount)){
				var isOverriderIsfound= document.getElementById(overrideId+intex).value;
				if(isOverriderIsfound=="Y"){
					var  Currvalue=    document.getElementById(currentID+intex).value;
					currentArray[intex]= Currvalue;
				}else{
					currentArray[intex]= "";
				}
				}else{
					currentArray[intex]= "";
				}
		}
	
	return	currentArray;
	
}

function getAlldummyValues(){
	var currentArray=[];
	for(var intex=0;intex<=10;intex++)
			{				
			    var  Currvalue=    "";
				currentArray[intex]= Currvalue;
			}
	return  currentArray;
}


function checkForEmpty(value){
	
	var retStat=true;
	var formobj = document.formCRXPrescriptionDetails;
	var drugCount=formobj.allDrugs_count.value;
	for(var t=0;t<parseInt(drugCount); t++){
			var absoluteQty = value + parseInt(parseInt(t));
		//	console.log("absoluteQty::"+absoluteQty);
			var  Currvalue=    document.getElementById(absoluteQty).value;
			if (trimCheck(Currvalue) == "" || parseFloat(Currvalue) == 0 ){		
		     showToastMsg(" Dosage cannot be blank or zero");
             retStat = false;
		     return retStat;
		}
	}	
	return retStat;
}


function checkForEmptyPrecentage(value){
	
	var retStat=true;
	var formobj = document.formCRXPrescriptionDetails;
	var drugCount=formobj.allDrugs_count.value;
	for(var t=0;t<parseInt(drugCount); t++){
		var baseDrugValue=document.getElementById("baseDrug"+t).value;
		
	//	console.log("base drug values::"+baseDrugValue);
		
		  if($("#baseDrug"+t).is(":checked")){
               // alert("Checkbox is checked.");
				retStat=true;
            }
            else if($("#baseDrug"+t).is(":not(:checked)")){
             var absoluteQty = value + parseInt(parseInt(t));
		//	console.log("absoluteQty::"+absoluteQty);
			var  Currvalue=    document.getElementById(absoluteQty).value;
			if (trimCheck(Currvalue) == "" || parseFloat(Currvalue) == 0 ){		
		     showToastMsg(" Dosage cannot be blank or zero");
             retStat = false;
		     return retStat;
			   
            }
			
		
			
		}
	}	
	return retStat;
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


function checkForInsert(){
		var retStat=true;
		var frmAdminObj = document.formCRXPrescriptionDetails;
		var frmobj = document.formCRXPrescriptionDetails;	
		var dosage_check = frmAdminObj.dosage_value.value;
		var dosageUOM_check = frmAdminObj.dosageUOM.value;
		var freq_check = frmAdminObj.freq_value_crx.value;
		var drun_check = frmAdminObj.duration_details.value;
		var drunUnit_check = frmAdminObj.durn_desc_crx.value;
		var start_check = frmAdminObj.crxStartDate.value;
		var end_check = frmAdminObj.crxEndDate.value;
		var PresByBase="S";
		
		PresByBase=frmobj.prescribingBy.value;
	
		
			if(PresByBase=="S"){				
				retStat =  checkForEmpty("strengthQty_");
			if(!retStat){
				  showToastMsg("Quantity cannot be blank or zero");
				 return  retStat;
			 }
			 
				
			}
				
			else if(PresByBase=="P"){
			 retStat = 	checkForEmptyPrecentage("percent_ratio");			 
			    if(!retStat){
				  showToastMsg("Percentage cannot be blank or zero");		 
				 return  retStat;
			    }			
			
			    var final_prod_qty = frmAdminObj.final_prod_qty_P.value;
			    var final_prod_qty_uom = frmAdminObj.final_prod_qty_uom.value;		 
			 
			    if (trimCheck(final_prod_qty) == "" || parseFloat(final_prod_qty) == 0 ){		
			     showToastMsg("Required final product quantity cannot be blank or Zero");
        		     retStat = false;
		             return  retStat;
			    } 
		
		        else if (trimCheck(final_prod_qty_uom) == "" || parseFloat(final_prod_qty_uom) == 0 ){		
			     showToastMsg("Required final product quantity UOM cannot be blank");
             	 retStat = false;		
		         return  retStat;
		        }					
		    }else if(PresByBase=="R"){					
		     retStat =   checkForEmpty("ratio_value_");
			    if(!retStat){
				  showToastMsg("Ratio cannot be blank or zero");				 
				  return  retStat; 
			    }			 
			
		        var final_prod_qty = frmAdminObj.final_prod_qty.value;
		        var req_qty_UOM = frmAdminObj.req_qty_UOM.value;
			 
		        if (trimCheck(final_prod_qty) == "" || parseFloat(final_prod_qty) == 0 ){		
		         showToastMsg("Required final product quantity cannot be blank or zero");
                 retStat = false;		
			     return  retStat;
		        }  		
		        else if (trimCheck(req_qty_UOM) == "" || parseFloat(req_qty_UOM) == 0 ){		
		         showToastMsg("Required final product quantity UOM cannot be blank");
                 retStat = false;	
			     return  retStat;
		        }			 
		    }else{				
	     	    retStat = 	checkForEmpty("strengthQty_");					
				if(!retStat){
				  showToastMsg("Quantity cannot be blank or zero");				 
				  return  retStat;
			    }		
		    }
		    if(PresByBase==""){
			  PresByBase="S";
		    }
		    retStat =  checkForEmptyoverRideReasons("txtDuplicateDrug_"+PresByBase,"DuplicateDrug_"+PresByBase);
			if(!retStat){
				showToastMsg("Over-ridden reason cannot be blank");
				return  retStat;
			}
			retStat =  checkForEmptyoverRideReasons("txtAllergyOverride_"+PresByBase,"AllergyOverride_"+PresByBase);
			if(!retStat){
				showToastMsg("Over-ridden reason cannot be blank");
				return  retStat;
			}
			retStat =  checkForEmptyoverRideReasons("txtBeyondDosage_"+PresByBase,"BeyondDosage_"+PresByBase);
			if(!retStat){
				showToastMsg("Over-ridden reason cannot be blank");
				return  retStat;		 
			}	

		    if(PresByBase=="R" ){	 
	          var result_factor="";
	          result_factor=frmobj.result_factor.value;
	        //  console.log("result favtors ::"+result_factor);
				
		      if(result_factor=="N"){
		        showToastMsg("UOM not defined for the selected drug. Choose a different drug");	
		        retStat=false;
		        return  retStat;
		      }	 
		   }else if(PresByBase=="P"){
			  var result_factor="";
	          result_factor=frmobj.result_factor.value;
	      //    console.log("result favtors ::"+result_factor);
			
		      if(result_factor=="N"){
		        showToastMsg("UOM not defined for the selected drug. Choose a different drug");	
		        retStat=false;
		        return  retStat;
		      }	
		    }
			
		if (trimCheck(dosage_check) == "" || parseFloat(dosage_check) == 0 ){
			showToastMsg(" Dosage cannot be blank or zero");
			retStat = false;
		return  retStat;
		}else if (trimCheck(dosageUOM_check) == "" || parseFloat(dosageUOM_check) == 0 ){
			showToastMsg(" Dosage type cannot be blank or zero");
			retStat = false;
		return  retStat;
		}else if (trimCheck(freq_check) == "" || parseFloat(freq_check) == 0 ){
			showToastMsg(" Frequency cannot be blank");
			retStat = false;
		return  retStat;
		}else if (trimCheck(drun_check) == "" || parseFloat(drun_check) == 0 ){
			showToastMsg(" Duration cannot be blank or zero");
			retStat = false;
		return  retStat;
		}else if (trimCheck(drunUnit_check) == "" || parseFloat(drunUnit_check) == 0 ){
			showToastMsg(" Duration unit cannot be blank");
			retStat = false;
		return  retStat;
		}else if (trimCheck(start_check) == "" || parseFloat(start_check) == 0 ){
			showToastMsg("Start date cannot be blank");
			retStat = false;
		return  retStat;
		}else if (trimCheck(end_check) == "" || parseFloat(end_check) == 0 ){
			showToastMsg("End date cannot be blank");
			retStat = false;
		  return  retStat;
		}
		
		return  retStat;
}

function release(){
	
	 var headerForm = document.PharmBaseForm;	 
	 
	 var frmobj = document.formCRXPrescriptionDetails;
	 
	 var  bl_install_yn=  headerForm.bl_install_yn.value;
	 var  bl_disp_charge_dtl_in_rx_yn=  headerForm.bl_disp_charge_dtl_in_rx_yn.value;
	 var blError;
	 
	 var bean_id = frmObj.bean_id_CRX.value;
	 var bean_name = frmObj.bean_name_CRX.value;	
			
			if(bl_install_yn=="Y" && bl_disp_charge_dtl_in_rx_yn=="Y"){
				blError = false;
				//getBLErrorDrugs();
				if(blError){
					return false;
				}
			}
			var PresByBase="S";
			
			/*
			for(inum=0;inum<3;inum++)
			{
				if(frmobj.pres_by[inum].checked)
						PresByBase=frmobj.pres_by[inum].value;	
			}
			*/
			
			/*
			if(PresByBase=='P')  //checking Base drug selection while Percentage base
			{
				
				var tmpBaseDrug="";
				for(ino=1;ino<10;ino++)
				{				
					if(frmobj.baseDrug[ino].checked)
						tmpBaseDrug=frmobj.baseDrug[ino].value;
				}
				
				if(tmpBaseDrug=="")
				{
					alert(getMessage("PH_SEL_BASE_DRUG","PH"));
					return false;
				}
			}
			*/
			var priority		= headerForm.priority.value;
			var patient_id		= headerForm.patient_id.value;
			var encounter_id	= headerForm.encounter_id.value;
			var freq_code		= frmobj.freq_value_crx.value;
			var durn_value		= frmobj.duration_details.value;
			//var durn_type		= frmobj.durn_type.value;
			var durn_type		= frmobj.durn_desc_crx.value;
			var start_date		= frmobj.crxStartDate.value;
			var end_date		= frmobj.crxEndDate.value;	
            var totalRatio      = document.getElementById("total_ratio_display").innerHTML;			
            var totalRatioQuantity      = document.getElementById("total_qty_display").innerHTML;
            var totalPercentQuantity    = document.getElementById("total_qty_percent_display").innerHTML;
           			
			
			PresByBase=frmobj.prescribingBy.value;			
				
				var orders;
				if(PresByBase=="S"){				
					orders="strengthQty_";						
				}else if(PresByBase=="P"){					
					orders="percent_ratio";					
				}else if(PresByBase=="R"){					
					orders="ratio_req_qty_";	
				}else{					
					orders="strengthQty_";	
					PresByBase="S";					
				}
			
			var ord_qty1		= checkForAvaliable(1,orders);
			var ord_qty2		= checkForAvaliable(2,orders);
			var ord_qty3		= checkForAvaliable(3,orders);
			var ord_qty4		= checkForAvaliable(4,orders);
			var ord_qty5		= checkForAvaliable(5,orders);
			var ord_qty6		= checkForAvaliable(6,orders);
			var ord_qty7		= checkForAvaliable(7,orders);
			var ord_qty8		= checkForAvaliable(8,orders);
			var ord_qty9		= checkForAvaliable(9,orders);
			var ord_qty10		= checkForAvaliable(10,orders);		
			
			var drug_code1		= checkForAvaliable(1,"drug_code_");
			var drug_code2		= checkForAvaliable(2,"drug_code_");
			var drug_code3		= checkForAvaliable(3,"drug_code_");
			var drug_code4		= checkForAvaliable(4,"drug_code_");
			var drug_code5		= checkForAvaliable(5,"drug_code_");
			var drug_code6		= checkForAvaliable(6,"drug_code_");
			var drug_code7		= checkForAvaliable(7,"drug_code_");;
			var drug_code8		= checkForAvaliable(8,"drug_code_");
			var drug_code9		= checkForAvaliable(9,"drug_code_");
			var drug_code10		= checkForAvaliable(10,"drug_code_");	
			
			//Added for  ML-BRU-CRF-072[Inc:29938] Start		
			
			var DrugIndicationRemarks1=checkForAvaliable(1,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks2=checkForAvaliable(2,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks3=checkForAvaliable(3,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks4=checkForAvaliable(4,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks5=checkForAvaliable(5,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks6=checkForAvaliable(6,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks7=checkForAvaliable(7,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks8=checkForAvaliable(8,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks9=checkForAvaliable(9,"txtDrugIndi_"+PresByBase);
			var DrugIndicationRemarks10=checkForAvaliable(10,"txtDrugIndi_"+PresByBase);
			//Added for  ML-BRU-CRF-072[Inc:29938] End
		

			var RP=new Array(10);
			var reqQty=new Array(10);
			var ordQty=new Array(10);
			var ordQtyUOM=new Array(10);
			var drugRemark= new Array(10);
			var baseDrug = new Array(10);
			
			//overrrideReason
			
			var currentRxOver =new Array(10);
			var allergyOver= new Array(10);
			var doseOver= new Array(10);
			
			
			var narcotic_yn = "N" ;
			
			/*
			for(intex=1;intex<=10;intex++)
			{
				RP[intex-1]= eval("frmobj.percent_ratio"+intex).value;
				reqQty[intex-1]= eval("frmobj.req_qty"+intex).value;
				ordQty[intex-1]= eval("frmobj.orderQty"+intex).value;
				ordQtyUOM[intex-1]= eval("frmobj.orderQtyUOM"+intex).value;
				drug_class= eval("frmobj.drug_class"+intex).value;
				if(drug_class == "N")
					narcotic_yn = "Y";
			}
			*/
			
		
		
			
			//for strenght:
			
		//	console.log("PresByBase::"+PresByBase);
			
			if(PresByBase=="S"){
				
			RP=getAlldummyValues();
			reqQty=getAlldummyValues();
			ordQty=getAllUserEnterValues("strengthQty_");
			ordQtyUOM =getAlldummyValues();
			currentRxOver=getAllUserOverrriderValues("txtDuplicateDrug_"+PresByBase,"DuplicateDrug_"+PresByBase);
			allergyOver=getAllUserOverrriderValues("txtAllergyOverride_"+PresByBase,"AllergyOverride_"+PresByBase);
			doseOver=getAllUserOverrriderValues("txtBeyondDosage_"+PresByBase,"BeyondDosage_"+PresByBase);
			drugRemark=getAllUserEnterValues("drugRemTextarea_"+PresByBase);
				
			}else  if(PresByBase=="R"){
			//for ratios:
			RP=getAllUserEnterValues("ratio_value_");
			//ratio_value_0
			reqQty=getAllUserEnterValues("ratio_req_qty_");
//			ratio_req_qty_0
			ordQty=getAllUserEnterValues("ratio_derived_qty_");
//			ratio_derived_qty_0
            		ordQtyUOM =getAlldummyValues();
			currentRxOver=getAllUserOverrriderValues("txtDuplicateDrug_"+PresByBase,"DuplicateDrug_"+PresByBase);
			allergyOver=getAllUserOverrriderValues("txtAllergyOverride_"+PresByBase,"AllergyOverride_"+PresByBase);
			doseOver=getAllUserOverrriderValues("txtBeyondDosage_"+PresByBase,"BeyondDosage_"+PresByBase);
			drugRemark=getAllUserEnterValues("drugRemTextarea_"+PresByBase);
			
				}else if(PresByBase=="P"){
		    RP=getAllUserEnterValues("percent_ratio");
			//ratio_value_0
			reqQty=getAllUserEnterValues("req_qty_p");
//			ratio_req_qty_0
			ordQty=getAllUserEnterValues("derived_qty_p");
//			ratio_derived_qty_0

            baseDrug=getAllUserEnterValuesBaseDrug("baseDrug");

            ordQtyUOM =getAlldummyValues();
			currentRxOver=getAllUserOverrriderValues("txtDuplicateDrug_"+PresByBase,"DuplicateDrug_"+PresByBase);
			allergyOver=getAllUserOverrriderValues("txtAllergyOverride_"+PresByBase,"AllergyOverride_"+PresByBase);
			doseOver=getAllUserOverrriderValues("txtBeyondDosage_"+PresByBase,"BeyondDosage_"+PresByBase);
			drugRemark=getAllUserEnterValues("drugRemTextarea_"+PresByBase);
			
			}else{
				
			RP=getAlldummyValues();
			reqQty=getAlldummyValues();
			ordQty=getAllUserEnterValues("strengthQty_");
			ordQtyUOM =getAlldummyValues();
				
			}
			
			
			
			//currentRx =getAllUserEnterValues("drugRemTextarea");
			
			var dosage          = frmobj.dosage_value.value;
			var buildMAR_yn     = frmobj.buildMAR_yn.value;
			var mode            = frmobj.mode.value;			
		
			var totalQty        = "";
			if(PresByBase=="P"){		
				totalQty= document.getElementById("final_prod_qty_P").value;
			}else if (PresByBase=='R'){
				totalQty= document.getElementById("final_prod_qty").value;
			}
			
			var dosage_uom;		
			if(PresByBase=='P'){		
				dosage_uom= document.getElementById("final_prod_qty_uom").value;
			}else if(PresByBase=='R'){		
				dosage_uom= document.getElementById("req_qty_UOM").value;
			}							
			else{
				//dosage_uom	= frmobj.uom.options[frmobj.uom.selectedIndex].value;				
				  dosage_uom  =  frmobj.dosageUOM.value;
			}
			
			var patient_class	=	headerForm.act_patient_class.value;			
			var allergic_yn ="N";	

			var discharge_yn  = headerForm.disch_med_mar_appl_yn.value;
			allergic_yn =headerForm.allergic_yn.value;

			var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " patient_id=\""+ patient_id + "\" ";
			xmlStr			+= " encounter_id=\""+ encounter_id + "\" ";
			xmlStr			+= " freq_code=\""+ freq_code + "\" ";
			xmlStr			+= " durn_value=\""+ durn_value + "\" ";
			xmlStr			+= " durn_type=\""+ durn_type + "\" ";
			xmlStr			+= " start_date=\""+ start_date + "\" ";
			xmlStr			+= " end_date=\""+ end_date + "\" ";
			xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
			xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";	
			xmlStr			+= " discharge_yn=\""+ discharge_yn + "\" ";
			//Added for  ML-BRU-CRF-072[Inc:29938] Start
			xmlStr			+= " DrugIndicationRemarks1=\""+ DrugIndicationRemarks1 + "\" ";
			xmlStr			+= " DrugIndicationRemarks2=\""+ DrugIndicationRemarks2 + "\" ";
			xmlStr			+= " DrugIndicationRemarks3=\""+ DrugIndicationRemarks3 + "\" ";
			xmlStr			+= " DrugIndicationRemarks4=\""+ DrugIndicationRemarks4 + "\" ";
			xmlStr			+= " DrugIndicationRemarks5=\""+ DrugIndicationRemarks5 + "\" ";
			xmlStr			+= " DrugIndicationRemarks6=\""+ DrugIndicationRemarks6 + "\" ";
			xmlStr			+= " DrugIndicationRemarks7=\""+ DrugIndicationRemarks7 + "\" ";
			xmlStr			+= " DrugIndicationRemarks8=\""+ DrugIndicationRemarks8 + "\" ";
			xmlStr			+= " DrugIndicationRemarks9=\""+ DrugIndicationRemarks9 + "\" ";
			xmlStr			+= " DrugIndicationRemarks10=\""+ DrugIndicationRemarks10 + "\" ";
			//Added for  ML-BRU-CRF-072[Inc:29938] End
			xmlStr			+= " priority=\""+ priority + "\" ";
			xmlStr			+=  " /></root>";

	//var bean_id = frmObj.bean_id_CRX.value;
	// var bean_name = frmObj.bean_name_CRX.value;
	 
			//var bean_id		=	"DUMMY";
			//var bean_name	=	"DUMMY";
			//var mode		= MODE_INSERT;	
			var rpString="";
			var reqQtyString="";
			var ordQtyString="";
			var ordQtyUOMString="";
			var drugRemarks="";
			var CurrentOverRemarks="";
            var AllerygOverRemarks="";
            var DosageOverRemarks="";
var baseDrugSelect="";
			for(intex=1;intex<=10;intex++)
			{
				rpString += "&RP"+intex+"="+RP[intex-1];
				reqQtyString += "&reqQty"+intex+"="+reqQty[intex-1];
				ordQtyString += "&ordQty"+intex+"="+ordQty[intex-1];
				ordQtyUOMString += "&ordQtyUOM"+intex+"="+ordQtyUOM[intex-1];
				drugRemarks += "&drugRemark"+intex+"="+drugRemark[intex-1];
				baseDrugSelect  += "&baseDrug"+intex+"="+baseDrug[intex-1];
				
				CurrentOverRemarks += "&currentRemark"+intex+"="+currentRxOver[intex-1];
				AllerygOverRemarks += "&allerygRemark"+intex+"="+allergyOver[intex-1];
				DosageOverRemarks += "&doseRemark"+intex+"="+doseOver[intex-1];
				
			}
			var qryString		
			= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&freq_code="+freq_code+"&validate=RELEASE&patient_id="+patient_id+"&encounter_id="+encounter_id+"&start_date="+start_date+"&end_date="+end_date+"&durn_value="+durn_value+"&durn_type="+durn_type+"&ord_qty1="+ord_qty1+"&ord_qty2="+ord_qty2+"&ord_qty3="+ord_qty3+"&ord_qty4="+ord_qty4+"&ord_qty5="+ord_qty5+"&ord_qty6="+ord_qty6+"&ord_qty7="+ord_qty7+"&ord_qty8="+ord_qty8+"&ord_qty9="+ord_qty9+"&ord_qty10="+ord_qty10+"&drug_code1="+drug_code1+"&drug_code2="+drug_code2+"&drug_code3="+drug_code3+"&drug_code4="+drug_code4+"&drug_code5="+drug_code5+"&drug_code6="+drug_code6+"&drug_code7="+drug_code7+"&drug_code8="+drug_code8+"&drug_code9="+drug_code9+"&drug_code10="+drug_code10+rpString+reqQtyString+ordQtyString+ordQtyUOMString+drugRemarks+CurrentOverRemarks+AllerygOverRemarks+DosageOverRemarks+baseDrugSelect+"&dosage="+dosage+"&dosage_uom="+dosage_uom+"&discharge_yn="+discharge_yn+"&PresByBase="+PresByBase+"&totalQty="+totalQty+"&narcotic_yn="+narcotic_yn+"&priority="+priority+"&DrugIndicationRemarks1="+DrugIndicationRemarks1+"&DrugIndicationRemarks2="+DrugIndicationRemarks2+"&DrugIndicationRemarks3="+DrugIndicationRemarks3+"&DrugIndicationRemarks4="+DrugIndicationRemarks4+"&DrugIndicationRemarks5="+DrugIndicationRemarks5+"&DrugIndicationRemarks6="+DrugIndicationRemarks6+"&DrugIndicationRemarks7="+DrugIndicationRemarks7+"&DrugIndicationRemarks8="+DrugIndicationRemarks8+"&DrugIndicationRemarks9="+DrugIndicationRemarks9+"&DrugIndicationRemarks10="+DrugIndicationRemarks10+"&totalRatio="+totalRatio+"&totalRatioQuantity="+totalRatioQuantity+"&totalPercentQuantity="+totalPercentQuantity;
			submitXML(qryString, xmlStr);//Added DrugIndicationRemarks1 to DrugIndicationRemarks10 for  ML-BRU-CRF-072[Inc:29938]
			/*
			if (result) {

			
				if(patient_class=='OP' || patient_class=='EM'){
					var xmlStr 			="<root><SEARCH /></root>";
					var xmlDoc			= new ActiveXObject( "Microsoft.XMLDom" ) ;
					var xmlHttp			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
					iv_bean_name	= "ePH.IVPrescriptionBean";
					xmlHttp.open("POST","PrescriptionCompValidate.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&validate=GET_TRNGROUPREF",false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;
					responseText=trimString(responseText);

					if(responseText != undefined && responseText!=null && responseText !=""){
						var dialogHeight	="15" ;
						var dialogWidth	="30";
						var dialogTop	= "300" ;
						var dialogLeft	= "300" ;
						var center			= "1" ;
						var status			="no";
						var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "";
						retVal = window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
					}
				}

				parent.parent.f_header.document.prescription_header_form
				var narcotic_aprvl_form_req_yn=parent.parent.f_header.document.prescription_header_form.narcotic_aprvl_form_req_yn.value;
				var print_narcotic_form_by_default=parent.parent.f_header.document.prescription_header_form.print_narcotic_form_by_default.value;
//alert("==narcotic_yn==="+narcotic_yn+"==narcotic_aprvl_form_req_yn=="+narcotic_aprvl_form_req_yn+"==print_narcotic_form_by_default=="+print_narcotic_form_by_default);
				if(narcotic_yn == "N"){
					narcotic_aprvl_form_req_yn = "";
					print_narcotic_form_by_default="";
				}
				var dialogHeight	="12" ;
				var dialogWidth	="30";
				var dialogTop	= "300" ;
				var dialogLeft	= "300" ;
				var center			= "1" ;
				var status			="no";
				var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "";
				if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || narcotic_aprvl_form_req_yn=="Y")//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
					retVal = window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=COMP"+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
//alert("retVal =1111comp11111== "+retVal);	
				if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
					var xmlStr ="<root><SEARCH ";
					xmlStr += " patient_id=\""+ patient_id + "\" ";
					xmlStr += " encounter_id=\""+ encounter_id + "\" ";
					xmlStr += " patient_class =\"" + patient_class + "\" " ;
					if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else if for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
						xmlStr+=" prescriptionPrint=\""+ retVal[0] + "\" ";
						xmlStr+=" NarcoticPrint=\""+ retVal[1] + "\" ";
					}
					else if(print_ord_sht_rule_ind =='S')
						xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
					/*if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) {
							xmlStr+= "print_yn='Y'" ;
					} else {
							xmlStr+= "print_yn='N'" ;
					}*/
					/*
					xmlStr +=" /></root>";
				
					var temp_jsp="PrescriptionCompValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,true);
					xmlHttp.send(xmlDoc);
				}
				if(mode == "RENEW_ORDER" ){
				   window.close()
				}else{
					reloadPage();
				}
			}
			
			*/
/*			else if(flag=="INSUFFICIENT_STOCK") {
					iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
					iv_bean_name	= "ePH.IVPrescriptionBean";

				var dialogHeight	= "12";
				var dialogWidth		= "45";
				var dialogTop		= "250";
				var dialogLeft		= "40";
				var center			= "0";
				var status			= "no";
				var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments		= "";
				retVal 				= window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&called_from=COMP",arguments,features);
			}
			*/
	$("#confirmMsg").hide();
    $("#RxOrderPlaceDiv").show();
    $("#RxOrderFieldsDiv").hide();
	
	
	
      	$("#orderDetailsView").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
            setTimeout(function() {
                $("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp',
                    function(res) {});
            }, 1000);
	
	
	
	
}

/*var btnCloseClicked = false;

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

function closeCrxDetailsView() {
	btnCloseClicked = true;
    $("#confirmMsg").show();
}*/







/* Assign Details - First time triggered */
function assignDosageDetails(drug_code,drug_desc,strength,strength_uom,strength_uom_need,dosage,dosage_uom,form_desc,stock_uom,pres_base_uom,pres_base_uom_need,external_prod_id,perform_ext_db_checks,drug_class, generic_id, generic_name){	

   // console.log("assignDosageDetails called"+drug_desc); 
    
    
    
	var frmObj		  =   document.formCRXPrescriptionDetails;
	var addedDrugList =   frmObj.allDrugs.value;
		
	addedDrugList = addedDrugList.replace(/,\s*$/, "");	
	var arrayDrugList = addedDrugList.split(",");
	
	var frmObj_drug_code = "drug_code_" + rec_no;
	var frmObj_drug_name = "drug_name" + rec_no;
	var frmObj_drug_class = "drug_class" + rec_no;
	var frmObj_external_prod_id = "external_prod_id" + rec_no;	
	var frmObj_Perform_ext_db_checks_YN = "Perform_ext_db_checks_YN" + rec_no;
	
    var frmObj_strength_uom         = 	"strength_uom" + rec_no;
    var frmObj_strength_uom_need    = 	"strength_uom_need" + rec_no;
    var frmObj_pres_base_uom        = 	"pres_base_uom" + rec_no;
    var frmObj_pres_base_uom_need   = 	"pres_base_uom_need" + rec_no;
    var frmObj_generic_id           = 	"generic_id" + rec_no;
    var frmObj_generic_name         = 	"generic_name" + rec_no;
	
	
	var drug_obj					=	document.getElementById(frmObj_drug_code);
	var drug_code_obj				=	document.getElementById(frmObj_drug_name);
    var external_prod_id_obj		=	document.getElementById(frmObj_external_prod_id);
    var Perform_ext_db_checks_obj	=	document.getElementById(frmObj_Perform_ext_db_checks_YN);
	var drug_class_obj			    =	document.getElementById(frmObj_drug_class);
	
	drug_obj.value					=	decodeURIComponent(drug_desc,"UTF-8") ;
	drug_code_obj.value				=   drug_code;	
	drug_class_obj.value            =   drug_class;
	external_prod_id_obj.value		=	external_prod_id;
	Perform_ext_db_checks_obj.value	=	perform_ext_db_checks;
   
   /*for tap to enter remarks
   var drug_db_interface_yn     = frmObj.drug_db_interface_yn.value;

	/*if(external_prod_id!="" && drug_db_interface_yn=="Y"){
		drug_info_obj	=	eval("document.getElementById("drug_info_")"+rec_no);
		drug_info_obj.style.visibility="visible";
	}*/

	/*if(drug_obj != null && drug_obj.value != ""){
		eval("document.prescription_compdetail_form.edl_info_"+rec_no).style.visibility="visible";
	}*/

    document.getElementById(frmObj_strength_uom).value=strength_uom;
    document.getElementById(frmObj_strength_uom_need).value=strength_uom_need;
    document.getElementById(frmObj_pres_base_uom).value=pres_base_uom;
    document.getElementById(frmObj_pres_base_uom_need).value=pres_base_uom_need;
    document.getElementById(frmObj_generic_id).value=generic_id;
    document.getElementById(frmObj_generic_name).value=generic_name;

	/*if(strength!="" && strength!="0") { 
		strength_obj.innerText	=strength+" "+strength_uom_need;//strength_uom//Modified for CRF--0749
	}*/
	//form_obj.innerText		=form_desc;
	//stockuom_obj.innerText	=pres_base_uom_need;//pres_base_uom;//Modified for CRF--0749
	//remarks_obj.style.visibility='visible';
	//drugInd_obj.style.visibility='visible';
	if(PrescribingBase=="S"){
		if(strength_uom != "" && strength_uom != undefined){
			var len = frmObj.uom.options.length;
			/*for(var i=0;i<len;i++) {
				frmObj.remove("uom") ;
			}*/
			for(var i =1;i<=10 ;i++){

				if(	document.getElementById("strength_uom"+i).value !="" ){
					var len1 = frmObj.uom.options.length;
					foundflag= false;
					for(var k=0;k<len1;k++) {
							var tempUOMVal=frmObj.uom.options[k].value;//text Modified crf-749;		
								
							if(tempUOMVal==(document.getElementById("strength_uom"+i)).value)
						    {
								foundflag=true;
								break;
							}
					}					
					if(!foundflag)
					{
						var textValue = document.getElementById("strength_uom"+i).value;
						var textDesc = (document.getElementById("strength_uom_uom_need"+i).value)+"            ";
						
						$("#dosageUOM").getKendoDropDownList().dataSource.insert({
                          value: textValue,
                          text: textDesc
                        });
						
						$("#dosageUOM").data("kendoDropDownList").select(0);
					}
				}
			}
			}else{ 
			var drug_count =0;
			var str_count = 0;

			for(dcno=1;dcno<=10;dcno++)
			{
				if(document.getElementById("strength_uom"+dcno).value !="") drug_count+=1;
			}

			for(dcno=1;dcno<=10;dcno++)
			{
				if(document.getElementById("strength_uom"+dcno).value !="") str_count+=1;
			}

			/*if(drug_count>1 && str_count =="0" ){
				var len =frmObj.uom.options.length;
				for(var i=0;i<len;i++) {
					frmObj.uom.remove("uom") ;
				}
				for(var i =1;i<=10 ;i++){
					if( document.getElementById("pres_base_uom"+i).value !=""){
						var len1 = frmObj.uom.options.length;
						foundflag=false;
						for(var k=0;k<len1;k++) {
							var tempUOMVal= frmObj.uom.options[k].value;//text Modified for crf-749;							
							if(tempUOMVal==document.getElementById("pres_base_uom"+i).value)
						    {
								foundflag=true;
								break;
							}
						}
						if(!foundflag)
						{
							var element = document.createElement('OPTION') ;
							//element.value		=  rec_no Modified for CRF-0749;
							element.value		=  document.getElementById("pres_base_uom"+i).value;
							element.text		=  (document.getElementById("pres_base_uom_need"+i).value)+"            ";
							frmObj.uom.add(element);
							frmObj.uom.selectedIndex= 0 ;
						}
					}
				}
			 }*/
		}
	}
	//getRemarks(rec_no,'N');
}

/* build mar */
function setBuildMAR(buildMARDefaulting){
//	console.log("Build MAR check is done for the first drug");
	var buildMAR_checked=buildMARDefaulting.substring(0,1);
	var buildMAR_enabled=buildMARDefaulting.substring(1,2);
	var frmObj = document.formCRXPrescriptionDetails;
	
	if(buildMAR_checked=="C"){
		frmObj.buildMAR_yn.checked=true;
		frmObj.buildMAR_yn.value="Y";
	}
	else{
		frmObj.buildMAR_yn.checked=false;
		frmObj.buildMAR_yn.value="N";
	}
	
	if(buildMAR_enabled=="E"){
		frmObj.buildMAR_yn.disabled=false;
	}
	else{
		frmObj.buildMAR_yn.disabled=true;
	}
	
}

/* populate duration desctiption */


function populateDurationDesc(){
	var headerForm      =   document.PharmBaseForm;
	var frmObj          =   document.formCRXPrescriptionDetails;
	var freq_code		=	 frmObj.freq_value_crx.value;
	
//	console.log("frq coder::"+freq_code);
	
	var patient_class	=	headerForm.act_patient_class.value;;
	
	if(patient_class=="IP"){
		if(headerForm.take_home_medication.value=="Y")
			patient_class="OP";
	}

	var qryString	= frmObj.bean_id_CRX.value+"&bean_name="+frmObj.bean_name_CRX.value+"&validate=populateDurationDesc&freq_code="+freq_code+"&patient_id="+headerForm.patient_id.value+"&encounter_id="+headerForm.encounter_id.value+"&patient_class="+patient_class;
	submitXML(qryString, "");
}

function populateEndDate(){
	    var headerForm      =   document.PharmBaseForm;
		var frmObj			   =  document.formCRXPrescriptionDetails;
		
		var freq_nature		=	document.getElementById("freq_nature").value;

		var start_date		=	document.getElementById("START_DATES").value;
		var durn_value		=	document.getElementById("durn_value").value;
		var repeat_durn_type=	$("#durn_desc_crx").data("kendoDropDownList").value();
		
		if(durn_value==""){
			durn_value=1;
		}
	//	console.log("freq_nature: "+freq_nature+",start_date:"+start_date+",durn_value: "+durn_value+ ",repeat_durn_type: " +repeat_durn_type);

		if(repeat_durn_type=="")
			repeat_durn_type="D";				
		
		var bean_id = frmObj.bean_id_CRX.value;
	    var bean_name = frmObj.bean_name_CRX.value;	
		
		
		if(trimString(start_date)!="" && durn_value!="" && durn_value!="0") {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&patient_id="+headerForm.patient_id.value+"&encounter_id="+headerForm.encounter_id.value+"&durn_value="+durn_value+"&durn_unit="+repeat_durn_type+"&freq_nature="+freq_nature;
			submitXML(qryString, "");
		}
}

function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn){
	//console.log("assignDurnDesc called: repeat_value: "+repeat_value+ ",repeat_durn_type :" +repeat_durn_type+ ",freq_nature:" +freq_nature+ ",interval_value:" +interval_value+ ",durn_desc:" +durn_desc+ ",schedule_yn:" +schedule_yn);
	var frmObj = document.formCRXPrescriptionDetails;	
	var frmObj_durn_details  =  frmObj.duration_details;
    var frmObj_freq_nature = frmObj.freq_nature; 	
   
    var durnUOMDpList = $("#durn_desc_crx").data("kendoDropDownList");
	//document.getElementById("duration_details").value	= "1";
	
	if(repeat_durn_type!=null && repeat_durn_type!="null" && repeat_durn_type!="") {
		document.getElementById("durn_type").value	= repeat_durn_type;
	}  
	else {
		document.getElementById("durn_value").value = "1";		
		document.getElementById("durn_type").value = "D";	
	}
	
	$("#durn_desc_crx").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: durnArray,
        change: validateDuration,
    });
	
	if(repeat_durn_type=="H"){
		var obj = new commonObj();
		obj.code = repeat_durn_type;
        obj.desp = "Hour(s)";
        durnArray.push(obj);
		if (durnUOMDpList) {
           $("#durn_desc_crx").getKendoDropDownList().dataSource.data(durnArray);
        }
	} 
	else if(repeat_durn_type=="M"){
		var obj = new commonObj();
		obj.code = repeat_durn_type;
        obj.desp = "Minute(s)";
        durnArray.push(obj);
		
		if (durnUOMDpList) {
           $("#durn_desc_crx").getKendoDropDownList().dataSource.data(durnArray);
        } 
	}
	
	frmObj_freq_nature.value	=	freq_nature;
	$("#durn_desc_crx").data("kendoDropDownList").select(0);
	
	populateEndDate();
}


function drunSelection(drun){
	if(drun=="" || drun==null){
		$("#durn_desc_crx").data("kendoDropDownList").select(0);
		
	}else{
			$("#durn_desc_crx").data("kendoDropDownList").value(drun);
	}

}

function validateDuration(){		
		var flag           = false;
		var headerForm     = document.PharmBaseForm;
		var frmObj         = document.formCRXPrescriptionDetails;
        var duration_value = frmObj.duration_details.value;		
		
		document.getElementById("durn_value").value = duration_value;
		
		if(parseInt(duration_value)==0 || duration_value =="") {
			showToastMsg("Prescription duartion cannot be blank or zero"); 
			return false;
		}
		
		var discharge_yn   = headerForm.take_home_medication.value;
		var patient_class  = headerForm.patient_class.value;;
		//var durn_type_desc = frmObj.durn_type.value;
		//buttonForm = parent.f_compound_button.formIVPrescriptionButtons;
		
		
		var objValue=duration_value;
		var durn_type_desc = $("#durn_desc_crx").data("kendoDropDownList").value();
		
		if(durn_type_desc=="W")
				objValue=parseInt(objValue)*7;
		else if(durn_type_desc=="L")
				objValue=parseInt(objValue)*30;
		else if(durn_type_desc=="Y")
				objValue=parseInt(objValue)*365;
		else if(durn_type_desc=="H")
				objValue=Math.ceil(parseInt(objValue)/24);
		else if(durn_type_desc=="M")
				objValue=Math.ceil(parseInt(objValue)/(24*60));
			
		populateEndDate();
		
		var max_durn_for_ip_pres = headerForm.max_durn_for_ip_pres.value;
		var max_durn_for_op_pres = headerForm.max_durn_for_op_pres.value;
		var max_durn_for_dm_pres = headerForm.max_durn_for_dm_pres.value;
		
		var disp_durn = ""; 

		if(discharge_yn == "Y" && parseInt(objValue) > parseInt(max_durn_for_dm_pres)){
			disp_durn = parseInt(max_durn_for_dm_pres);
			flag = true;
		}
		else{
			if(patient_class == "IP" && parseInt(objValue) > parseInt(max_durn_for_ip_pres)){
				disp_durn = parseInt(max_durn_for_ip_pres);
				flag = true;
			}
			if(patient_class == "OP" && parseInt(objValue) > parseInt(max_durn_for_op_pres)){
				disp_durn = parseInt(max_durn_for_op_pres);
				flag = true;
			}
		}

		if(flag){
			showToastMsg("Duration exceeds maximum allowed period - " + disp_durn + " days");
			document.getElementById("duration_details").value = disp_durn;
			$("#durn_desc_crx").data("kendoDropDownList").value("D");
			validateDuration();
		}
		
}

function trimString(inString) {
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



function setEndDate(end_date) {
    $("#current_end").val(end_date);
	document.getElementById("crxEndDate").value = end_date;
	document.getElementById("end_date_fluid").value = end_date;
}

function dosageChange(obj){
	document.getElementById("dosage_detail").value = obj.value;
	//ValidateDosage();
	
	var frmObj = document.formCRXPrescriptionDetails; 	
    var addedDrugList =   frmObj.allDrugs.value;	
    addedDrugList = addedDrugList.replace(/,\s*$/, "");	
    var arrayDrugList = addedDrugList.split(",");
  //  console.log("arrayDrugList: "+arrayDrugList.length);
	
	var dosage=frmObj.dosage_value.value;
	var frequency=document.getElementById("freq_value_crx").value;
	
	if(arrayDrugList.length >=2){
		if(dosage == '' || dosage == '0'){
			frequency.selectedIndex=0;
			showToastMsg("Dosage cannot be blank or zero");
			return false;
		}
	}
	return
}

/* Global access */
var headerForm = document.PharmBaseForm;
var formObj = document.formCRXPrescriptionDetails; 	
var bean_id = formObj.bean_id_CRX.value;
var bean_name = formObj.bean_name_CRX.value;	

var drugCodes = formObj.drug_code_1.value;
var patient_id = formObj.patient_id.value;
var encounter_id = formObj.encounter_id.value;
var allDrugs = formObj.allDrugs.value;
var drug_db_interface_yn = "";
var drug_db_dosecheck_yn = "";
var drug_db_duptherapy_yn = "";
var drug_db_interact_check_yn = "";
var drug_db_contraind_check_yn = "";
var drug_db_allergy_check_yn = "";
var drug_db_product_id = "";
var Trade_Codes = "";
var Trade_Names = "";
var adr_count = "";
var pract_id = formObj.pract_id.value;
var resp_id = formObj.resp_id.value;
var act_patient_class = headerForm.act_patient_class.value;
var priority = headerForm.priority.value;
var source_code = headerForm.source_code.value;
var discharge_yn = "";
var startdate = ""; 


if(START_DATES=="" || START_DATES==undefined){
  startdate = formObj.start_date_fluid.value;
  //console.log("startdate on first time:"+startdate);
}
else{
  startdate = formObj.START_DATES.value;	
  //console.log("startdate on second time:"+startdate);
}

var enddate = formObj.end_date_fluid.value;
var recno = "1";

var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " drugCodes=\""+ allDrugs + "\" ";
			xmlStr			+= " patient_id=\""+ patient_id + "\" ";
			xmlStr			+= " encounter_id=\""+ encounter_id + "\" "; 
			xmlStr			+= " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
			xmlStr			+= " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr			+= " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr			+= " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr			+= " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr			+= " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr			+= " drug_db_product_id=\""+ drug_db_product_id + "\" ";
			xmlStr			+= " Trade_Codes=\""+ Trade_Codes + "\" ";
			xmlStr			+= " Trade_Names=\""+ Trade_Names + "\" ";
			xmlStr			+= " adr_count=\""+ adr_count + "\" ";
			xmlStr			+= " pract_id=\""+ pract_id + "\" ";
			xmlStr			+= " resp_id=\""+ resp_id + "\" ";
			xmlStr			+= " act_patient_class=\""+ act_patient_class + "\" ";    // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " priority=\""+ priority + "\" ";					// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " source_code=\""+ source_code + "\" ";				// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " take_home_medication=\""+ discharge_yn + "\" ";	 // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr 			+= " startdate=\""+ startdate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr 			+= " enddate=\""+ enddate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr			+= " recno=\""+ recno + "\" ";
			xmlStr			+=  " /></root>";	

		   //window.prompt("suri",xmlStr);

		//	submitXML(qryString, xmlStr);
			 var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODE";
			 submitXML(qryString, xmlStr,"");	

			 
/* Strength field calculations */ 

function updateOrderQuantiyInStrengthMode(content,orderQtyUOM,rowValue)
{
	var frmObj = document.formCRXPrescriptionDetails;
	
	//var strengthValue = "orderQty_" + rowValue;
    //var strengthUOM = "orderQtyUOM_" + rowValue;  
	var absoluteQty = "strengthQty_" + rowValue;
	
    var enteredValue=document.getElementById(absoluteQty).value;
	
	var orderQty=Math.ceil(parseFloat(enteredValue)/parseFloat(content));

//	console.log("orderQty : "+orderQty);
	
	document.getElementById("strengthQty_"+rowValue).value = orderQty;
	
	//document.getElementById("orderQtyUOM_"+rowValue).value = orderQtyUOM;
}

function calculateOrderQuantiyInStrengthMode(rowValue)
{
	var headerFrm = document.PharmBaseForm;
	var frmObj = document.formCRXPrescriptionDetails; 
	
	var enteredStrengthValue =	document.getElementById("strengthQty_"+rowValue).value;
		
	if(parseInt(enteredStrengthValue)==0 || enteredStrengthValue =="") {
		showToastMsg("Quantity cannot be blank or zero"); 
		return false;
	}
	
	
	
	var bean_id = frmObj.bean_id_CRX.value;
	var bean_name = frmObj.bean_name_CRX.value;	
	var formObj_drug_code = "drug_code_" + rowValue;
	var drugCode=document.getElementById(formObj_drug_code).value;	

	var qryString =bean_id+"&bean_name="+bean_name+"&validate=CALC_ORDER_QTY&rownumber="+rowValue+"&drugCode="+drugCode;
	submitXML(qryString,"");	
}

function assignPresBaseUOM()
{ 
	var drug_count =0;
	var str_count = 0;
	var frmObj		  =   document.formCRXPrescriptionDetails;
	
	for(dcno=1;dcno<=10;dcno++)
	{
		if(document.getElementById("drug_code"+dcno).value !="") 
			drug_count+=1;
	}
	for(dcno=1;dcno<=10;dcno++)
	{
		if(document.getElementById("strength_uom_"+dcno).value !="") 
			str_count+=1;
	}

	/*if(drug_count>1 && str_count == 0 ){
		var len = frmObj.uom.options.length;
		
		//console.log("len: "+len);
		
		for(var i=0;i<len;i++) {
			document.prescription_compdetail_form.uom.remove("uom") ;
		}
		for(var i =1;i<=10 ;i++){
			if(	eval("document.prescription_compdetail_form.pres_base_uom"+i).value !=""){
				var len1 =document.prescription_compdetail_form.uom.options.length;
				foundflag=false;
				for(var k=0;k<len1;k++) {
					var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value ;							
					if(tempUOMVal==(eval("document.prescription_compdetail_form.pres_base_uom"+i).value))
					{
						foundflag=true;
						break;
					}
				}
				if(!foundflag)
				{
					var element = document.createElement('OPTION') ;
					//element.value		=  i ; Modified for CRF-0749;
							element.value		=(eval("document.prescription_compdetail_form.pres_base_uom"+i).value);
					element.text		=  (eval("document.prescription_compdetail_form.pres_base_uom_need"+i).value)+"            ";
					frmObj.uom.add(element);
					frmObj.uom.selectedIndex= 0 ;
				}
			}
		}
	 }
	 else
	{
		if(drug_count>1)
		{
			var len =document.prescription_compdetail_form.uom.options.length;
			for(var i=0;i<len;i++) {
				document.prescription_compdetail_form.uom.remove("uom") ;
			}
		}
		 for(var j=1;j<=10;j++) {
			if(	eval("document.prescription_compdetail_form.strength_uom"+j).value !=""){
				var len1 =document.prescription_compdetail_form.uom.options.length;
				foundflag=false;
				for(var k=0;k<len1;k++) {
					var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value ;							
					if(tempUOMVal==(eval("document.prescription_compdetail_form.strength_uom"+j).value))
					{
						foundflag=true;
						break;
					}
				}
				if(!foundflag)
				{
					var element = document.createElement('OPTION') ;
					//element.value		=  i;  Modified for CRF-0749;
					element.value		=  (eval("document.prescription_compdetail_form.strength_uom"+j).value)
					element.text		=  (eval("document.prescription_compdetail_form.strength_uom_need"+j).value)+"            ";
					frmObj.uom.add(element);
					frmObj.uom.selectedIndex= 0 ;
				}
			}
		}
	}*/
}


/* ratio percentage calc */

function setCalculatedDerivedQuantity(equVal,factor,rowvalue,contentInPresBaseUOM,orderQtyUOM,type){
	var reqQtyValue = "";
	var derqtyObj ="";
	var result="";
	if(type == "R"){
		reqQtyValue= document.getElementById("ratio_req_qty_"+rowvalue).value;
		derqtyObj= document.getElementById("ratio_derived_qty_"+rowvalue).value;
		if(factor=="M"){
			result=(parseFloat(reqQtyValue)*parseFloat(equVal)).toFixed(2);
		}
		if(factor=="D"){
			result=(parseFloat(reqQtyValue)/parseFloat(equVal)).toFixed(2);
		}
		
		if(isNaN(Number(result))){
			result="";
		}
		
		if (isNaN(Number(derqtyObj))){
			document.getElementById("ratio_derived_qty_"+rowvalue).value = "";
		}else{
			document.getElementById("ratio_derived_qty_"+rowvalue).value = result;
		}
		
	}else if(type == "P"){
		reqQtyValue= document.getElementById("req_qty_p"+rowvalue).value;
		derqtyObj= document.getElementById("derived_qty_p"+rowvalue).value;
		if (isNaN(Number(derqtyObj))){
			document.getElementById("derived_qty_p"+rowvalue).value = "";
		}
		if(factor=="M"){
			result=(parseFloat(reqQtyValue)*parseFloat(equVal)).toFixed(2);
		}
		if(factor=="D"){
			result=(parseFloat(reqQtyValue)/parseFloat(equVal)).toFixed(2);
		}
		if(isNaN(Number(result))){
			result="";
		}
		if(isNaN(derqtyObj)){
			document.getElementById("derived_qty_p"+rowvalue).value = "";
		}
		else{
			document.getElementById("derived_qty_p"+rowvalue).value = result;
		}
	}

	var ord_qty = Math.ceil(result/parseFloat(contentInPresBaseUOM));
	
	document.getElementById("equvalentUOM_conversion_value"+rowvalue).value=equVal;
	document.getElementById("equvalentUOM_conversion_factor"+rowvalue).value=factor;
	document.getElementById("contentInPresBaseUOM"+rowvalue).value=contentInPresBaseUOM;
	document.getElementById("orderQty"+rowvalue).value=ord_qty;
	document.getElementById("orderQtyUOM"+rowvalue).value=orderQtyUOM;
}

function setDerivedQuantity(factor,rowvalue,type){
	var frmObj = document.formCRXPrescriptionDetails; 
	var drugobj= document.getElementById("drug_name"+rowvalue); 
	var bean_id = frmObj.bean_id_CRX.value;
	var bean_name = frmObj.bean_name_CRX.value;
	//dropdown value
	var finalUOM = "";
	if(type == 'R'){
		finalUOM = frmObj.req_qty_UOM.value;
	}else{
		finalUOM = frmObj.final_prod_qty_uom.value; 
	}
	frmObj.result_factor.value=factor;
	
	if(factor=="N")
	{
        showToastMsg("UOM not defined for the selected drug. Choose a different drug");
		drugobj.value="";	
		return false;
	}
	else{
		var drugUom= document.getElementById("pres_base_uom"+rowvalue).value;	
		var drugCode= document.getElementById("drug_code_"+rowvalue).value;
		
		var qryString = bean_id+"&bean_name="+bean_name+"&validate=CALC_DERIVED_QTY&finalUOM="+finalUOM+"&drugUOM="+drugUom+"&rownumber="+rowvalue+"&drugCode="+drugCode+"&factor="+factor+"&type="+type;
		submitXML(qryString,"");
		
	}
}

function calculateDerivedQuantity(rowvalue,type){	
	var headerFrm = document.PharmBaseForm;
	var frmObj = document.formCRXPrescriptionDetails; 
	
	var prevEquValue         = document.getElementById("equvalentUOM_conversion_value"+rowvalue).value;
	var prevEquFactor        = document.getElementById("equvalentUOM_conversion_factor"+rowvalue).value;
	var contentInPresBaseUOM = document.getElementById("contentInPresBaseUOM"+rowvalue).value;
	var orderQty             = document.getElementById("ratio_req_qty_"+rowvalue).value;
	var orderQtyUOM          = document.getElementById("orderQtyUOM"+rowvalue).value;
	
	if(prevEquValue==""||orderQty==""){
		var bean_id = frmObj.bean_id_CRX.value;
		var bean_name = frmObj.bean_name_CRX.value;
		
		var finalUOM = "";
		if(type == 'R'){
			finalUOM = frmObj.req_qty_UOM.value;
		}else{
			finalUOM = frmObj.final_prod_qty_uom.value; 
		}
	    var qryString = bean_id+"&bean_name="+bean_name+"&validate=EQUIVALENT_UOM&finalUOM="+finalUOM+"&rownumber="+rowvalue+"&type="+type;
	    submitXML(qryString,"");
	}
	else{
		setCalculatedDerivedQuantity(prevEquValue,prevEquFactor,rowvalue,contentInPresBaseUOM,orderQtyUOM,type);
	}
}


function setRatioValues(){
	var all_ratio_values=getAllUserEnterValues("ratio_value_");
		all_ratio_values = all_ratio_values.filter(function(n){ return n != "" }); 

		  
		  for(var i = all_ratio_values.length-parseInt(1); i >=0; i--){
		    if(all_ratio_values[i]==0){	
			  all_ratio_values.splice(i,1); 
		    }
	      }
		  
		  if(all_ratio_values.length == 1){
			document.getElementById("total_ratio_display").innerHTML = all_ratio_values[0];  
		  }
		  else{
			var completedList = all_ratio_values.join(" : ");
            document.getElementById("total_ratio_display").innerHTML = completedList;			
		  }
}

//final calculation of ratio and percentage
function percentageRatioCalculation(rownum,fromwhere,type){
	var headerFrm = document.PharmBaseForm;
	var frmObj = document.formCRXPrescriptionDetails;
	var finalProdQtyObj = "";
	if(type == 'R'){
		finalProdQtyObj= document.getElementById("final_prod_qty").value;
	}else if(type == 'P'){
		finalProdQtyObj= document.getElementById("final_prod_qty_P").value;
	}
	if(finalProdQtyObj == "" || finalProdQtyObj == undefined || finalProdQtyObj == null){
		showToastMsg("Enter final product quantity");
		//$("#ratio_value_"+rownum).val('');
		return false;
	} 
	
	var firstFieldRatiocheck="";
	
	if(type == 'R'){
	   firstFieldRatiocheck = document.getElementById("ratio_value_0").value;	
	}
	else if(type == 'P'){
	   firstFieldRatiocheck = document.getElementById("percent_ratio0").value;	
	}
	 
    	
	var percent_ratio="";
	var drugObj="";
	
	if(rownum != "o"){
	   if(PrescribingBase=='R'){  
		var sumOfRatio=0;
		
		for(var i=0; i<arrayDrugList.length;i++){
			var ratioVal = document.getElementById("ratio_value_"+i).value;
			
			if(ratioVal == "")
			   document.getElementById("ratio_value_"+i).value = 0;
		   
			if(ratioVal != ""){				
				sumOfRatio=sumOfRatio+parseInt(document.getElementById("ratio_value_"+i).value);
			}
		}
	
		perRatio = parseInt(finalProdQtyObj)/sumOfRatio;
		for (var i=0; i<arrayDrugList.length;i++){
			var test = document.getElementById("ratio_value_"+i).value;
			if(document.getElementById("ratio_value_"+i).value !="" && document.getElementById("ratio_value_"+i).value != "0"){
				document.getElementById("ratio_req_qty_"+i).value = (perRatio*parseInt(document.getElementById("ratio_value_"+i).value)).toFixed(2);	
				calculateDerivedQuantity(i,type);
			}
			else{
				document.getElementById("ratio_req_qty_"+i).value="";
				document.getElementById("ratio_derived_qty_"+i).value="";
				document.getElementById("orderQty"+i).value="";
				document.getElementById("orderQtyUOM"+i).value="";
			}
		}

		  
setRatioValues();		  
		  document.getElementById("total_qty_display").innerHTML = finalProdQtyObj;
	}else if(PrescribingBase=='P'){
		for (var i=0; i<arrayDrugList.length;i++){
			if(document.getElementById("percent_ratio"+i).value !=""){
				document.getElementById("req_qty_p"+i).value = (parseInt(finalProdQtyObj)* parseFloat(document.getElementById("percent_ratio"+i).value)/100).toFixed(2);
				calculateDerivedQuantity(i,type);
			}
			else{
				document.getElementById("req_qty_p"+i).value="";
				document.getElementById("derived_qty_p"+i).value="";
				document.getElementById("orderQty"+i).value="";
				document.getElementById("orderQtyUOM"+i).value="";
			}
		}
		var sumOfQty=0;	
		var baseDrugValue;
		for(var i=0; i<arrayDrugList.length;i++){
			var perVal = document.getElementById("percent_ratio"+i).value;
			if(perVal == "")
				document.getElementById("percent_ratio"+i).value = 0;
			if(perVal != ""){
				sumOfQty=sumOfQty+parseFloat(document.getElementById("req_qty_p"+i).value);				
			}
			if(document.getElementById("baseDrug"+i).checked)
					baseDrugValue=document.getElementById("baseDrug"+i).value;
		}	
		if(baseDrugValue== " "){
			if(sumOfQty>parseInt(finalProdQtyObj)){	
				showToastMsg("Total quantity value exceeds the final product quantity value");
				percent_ratio.value="";
				document.getElementById("percent_ratio"+rownum).value="";
				document.getElementById("req_qty_p"+rownum).value="";
				document.getElementById("derived_qty_p"+rownum).value="";
				document.getElementById("orderQty"+rownum).value="";
				document.getElementById("orderQtyUOM"+rownum).value="";
				return false;
			}			
		}
		else{ //base selected
			var tempSumOfQty=0;
			for(var i=0; i<arrayDrugList.length;i++){
				if(i==baseDrugValue)
					continue;
				if(document.getElementById("req_qty_p"+i).value !="")
					tempSumOfQty=tempSumOfQty + parseFloat(document.getElementById("req_qty_p"+i).value);				
			}						
			var baseQty=parseInt(finalProdQtyObj)-tempSumOfQty;
			if(baseQty>0){
				document.getElementById("req_qty_p"+baseDrugValue).value=baseQty.toFixed(2);
				calculateDerivedQuantity(baseDrugValue,type);
				sumOfQty=baseQty+tempSumOfQty;	
			}
			else{
				if(!isNaN(baseQty)){
					showToastMsg("Total quantity value exceeds the final product quantity value");
					percent_ratio.value="";	
					document.getElementById("percent_ratio"+rownum).value="";		
					document.getElementById("req_qty_p"+rownum).value="";
					document.getElementById("derived_qty_p"+rownum).value="";
					document.getElementById("orderQty"+rownum).value="";
					document.getElementById("orderQtyUOM"+rownum).value="";
				}
				return false;
			}
		}
		
		document.getElementById("total_qty_percent_display").innerHTML = finalProdQtyObj;
		
		return true;
	}
	else{
		return false;		
	}
   }
   else if( rownum == 'o'){
	   if(PrescribingBase=='R' && firstFieldRatiocheck != ""){
		var sumOfRatio=0;
		for(var i=0; i<arrayDrugList.length;i++){
			var ratioVal = document.getElementById("ratio_value_"+i).value;
			if(ratioVal == "")
			   document.getElementById("ratio_value_"+i).value = 0;
			if(ratioVal != ""){				
				sumOfRatio=sumOfRatio+parseInt(document.getElementById("ratio_value_"+i).value);
			}
		}
		perRatio = parseInt(finalProdQtyObj)/sumOfRatio;
		var calculatedReqQty="";
		for (var i=0; i<arrayDrugList.length;i++){
			if(document.getElementById("ratio_value_"+i).value !=""){
				calculatedReqQty = (perRatio*parseInt(document.getElementById("ratio_value_"+i).value)).toFixed(2);
				if(isNaN(Number(calculatedReqQty))){
			      document.getElementById("ratio_req_qty_"+i).value = "";
		        }
				else{
				  document.getElementById("ratio_req_qty_"+i).value = calculatedReqQty;
				  calculateDerivedQuantity(i,type);
				}
			}
			else{
				document.getElementById("req_qty"+i).value="";
				document.getElementById("ratio_derived_qty_"+i).value="";
				document.getElementById("orderQty"+i).value="";
				document.getElementById("orderQtyUOM"+i).value="";
			}
		}
        var all_ratio_values=getAllUserEnterValues("ratio_value_");
		all_ratio_values = all_ratio_values.filter(function(n){ return n != "" }); 
          for(var i=0; i<all_ratio_values.length;i++ ){ 
            if(all_ratio_values[i]==0)
            all_ratio_values.splice(i,1); 
          } 
		  if(all_ratio_values.length < 2){
			document.getElementById("total_ratio_display").innerHTML = all_ratio_values[0];  
		  }
		  else{
			var completedList = all_ratio_values.join(" : ");
            document.getElementById("total_ratio_display").innerHTML = completedList;			
		  }
		  document.getElementById("total_qty_display").innerHTML = finalProdQtyObj;
	}else if(PrescribingBase=='P'){
		for (var i=0; i<arrayDrugList.length;i++){
			if(document.getElementById("percent_ratio"+i).value !=""){
				document.getElementById("req_qty_p"+i).value = (parseInt(finalProdQtyObj)* parseFloat(document.getElementById("percent_ratio"+i).value)/100).toFixed(2);
				calculateDerivedQuantity(i,type);
			}
			else{
				document.getElementById("req_qty_p"+i).value="";
				document.getElementById("derived_qty_p"+i).value="";
				document.getElementById("orderQty"+i).value="";
				document.getElementById("orderQtyUOM"+i).value="";
			}
		}
		var sumOfQty=0;	
		var baseDrugValue="";
		for(var i=0; i<arrayDrugList.length;i++){
			var perVal = document.getElementById("percent_ratio"+i).value;
			if(perVal != ""){
				sumOfQty=sumOfQty+parseFloat(document.getElementById("req_qty_p"+i).value);				
			}
			//if(i == arrayDrugList.length) continue;
			if(document.getElementById("baseDrug"+i).checked)
					baseDrugValue=document.getElementById("baseDrug"+i).value;
		}	
		if(baseDrugValue==""){
			if(sumOfQty>parseInt(finalProdQtyObj)){
				//percent_ratio.value="";
				document.getElementById("req_qty_p"+i).value="";
				document.getElementById("derived_qty_p"+i).value="";
				document.getElementById("orderQty"+i).value="";
				document.getElementById("orderQtyUOM"+i).value="";
				return false;
			}			
		}
		else{ //base selected
			var tempSumOfQty=0;
			for(var i=0; i<arrayDrugList.length;i++){
				//if(i==baseDrugValue)
					//continue;
				if(document.getElementById("req_qty_p"+i).value !="")
					tempSumOfQty=tempSumOfQty + parseFloat(document.getElementById("req_qty_p"+i).value);				
			}						
			var baseQty=parseInt(finalProdQtyObj)-tempSumOfQty;
			if(baseQty>0){
				document.getElementById("req_qty_p"+baseDrugValue).value=baseQty.toFixed(2);
				calculateDerivedQuantity(baseDrugValue,type);
				sumOfQty=baseQty+tempSumOfQty;			
			}
			else{
				if(!isNaN(baseQty)){
					percent_ratio.value="";
					percent_ratio.value="";
					document.getElementById("req_qty_p"+i).value="";
					document.getElementById("derived_qty_p"+i).value="";
					document.getElementById("orderQty"+i).value="";
					document.getElementById("orderQtyUOM"+i).value="";
				}
				return false;
			}
		}
		document.getElementById("total_qty_percent_display").innerHTML = finalProdQtyObj;
		return true;
	}
	else{
		return false;		
	}  
   }
   else{
	   if(type == 'R'){
		document.getElementById("total_qty_display").innerHTML = finalProdQtyObj;   
	   }   
	   else if(type == 'P'){
		document.getElementById("total_qty_percent_display").innerHTML = finalProdQtyObj;   
	   }   
   }
}
var previouslySelected="";
function selectBaseDrug(selectedObj){
	var frmObj = document.formCRXPrescriptionDetails;
	var rownum=selectedObj.value;
	var perc_ratio;
	for(var i=0; i<arrayDrugList.length;i++){
		document.getElementById("baseDrug"+i).checked = false;
	}
	document.getElementById("baseDrug"+rownum).checked = true;
	for(var i=0; i<arrayDrugList.length;i++){
		perc_ratio=eval("frmObj.percent_ratio"+i);
		perc_ratio.disabled=false;		
		if(i==parseInt(rownum)){
			if(percentageRatioCalculation(rownum,'','P')){				
				perc_ratio.value="";
				perc_ratio.disabled=true;
				previouslySelected=i;
			}
			else{
				selectedObj.checked=false;
				perc_ratio.disabled=false;
				if(previouslySelected!=""){	
					eval("frmObj.all.baseDrugId"+previouslySelected).checked=true;						
				}
			}
		}		
	}	
}
function commonObj() {
    this.code = "";
    this.desp = "";
}

function freqChange() {
	//console.log("called freq change");
	
	var headerFrm = document.PharmBaseForm;
	var frmObj = document.formCRXPrescriptionDetails; 
	
	var  freqType =	$("#freq_value_crx").data("kendoDropDownList").value();
	
	document.getElementById("freq_nature").value = freqType;
	
    /*var freq_code = $("#frequencyList").data("kendoDropDownList").value();
    var headerFrm = document.PharmBaseForm;
    var frmObj = document.formIVPBDrugDetails;
	
    var patient_class = headerFrm.patient_class.value;
    if (patient_class == "IP") {
        if (headerFrm.take_home_medication.value == "Y")
            patient_class = "OP";
    }
    if (frmObj != "" && frmObj != undefined) {
        var bean_id = frmObj.bean_id.value;
        var bean_name = frmObj.bean_name.value;
        var drug_code = frmObj.drug_code_.value;
        frmObj = "onload";
    } else {
        if (document.formIVPrescriptionAdminDetail != undefined) {
            frmObj = "";
            var bean_id = frmObj.bean_id.value;
            var bean_name = frmObj.bean_name.value;
            var drug_code = frmObj.drug_code_.value;
        } else {
            var bean_id = frmObj.bean_id.value;
            var bean_name = frmObj.bean_name.value;
            var drug_code = frmObj.drug_code_.value;
        }
    }
    var qryString = bean_id + "&bean_name=" + bean_name + "&validate=populateDurationDesc&drug_code=" + drug_code + "&freq_code=" + freq_code + "&formObj=" + frmObj;
    submitXML(qryString, "");
    */
}

function clearFrequencyList() {
    freqArray = [];
    $("#freq_value_crx").kendoDropDownList({
        valuePrimitive: true,
        change: freqChange,
    });
    var ddl = $("#freq_value_crx").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]);   
}

function addFrequencyListCrx(code, desc) {
	//console.log("frequency called");
    
	var obj = new commonObj();
    obj.code = code;
    obj.desp = desc;
    freqArray.push(obj);
	for(var i=0;i<freqArray.length;i++){
	//  console.log("freqArray: "+freqArray[i]);	
	}
	//defaultFreq()
}

function defaultFreq(sec) 
{
    $("#freq_value_crx").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: freqArray,
        change: freqChange,
		optionLabel: "SELECT"
    });
    $("#freq_value_crx").data("kendoDropDownList").value(sec);
	
}

function onChangeStartDate(){
   var value = $("#crxStartDate").data("kendoDateTimePicker").value();
   
   if(value != null){
    var startDate = kendo.toString($("#crxStartDate").data("kendoDateTimePicker").value(), 'dd/MM/yyyy');
    var startTime = kendo.toString($("#crxStartDate").data("kendoDateTimePicker").value(), 'HH:mm');
          
    var combinedDateTime = startDate + " " + startTime;
    document.getElementById("start_date_fluid").value = combinedDateTime;
    document.getElementById("START_DATES").value = combinedDateTime; 	
    populateEndDate();
   }
   else{
	setEndDate("");   
   }
}


$("#crxStartDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm", //24 hours format
    change: onChangeStartDate
});


$("#crxStartDate").attr("readonly","readonly");

$("#crxEndDate").kendoDateTimePicker({
    format: "dd/MM/yyyy HH:mm",
    timeFormat: "HH:mm", //24 hours format
});
var startDatepicker = $("#crxStartDate").data("kendoDateTimePicker");
var endDatepicker = $("#crxEndDate").data("kendoDateTimePicker");

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


/*function isBefore(fromDate, toDate, format, locale) {
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
    
    var frmAdminObj = document.formCRXPrescriptionDetails;

    var start_date_chk = frmAdminObj.start_date_fluid.value;
    if (start_date_chk != "") {
        var back_date = frmAdminObj.back_date.value;

        var future_date = frmAdminObj.future_date.value
        if (validDate(start_date_chk, "DMYHM", locale)) {
            if (future_date != null && future_date != 'null' && future_date != "0" && future_date != "") { //newly added future_date!="" for incident 33048
                if (isBefore(start_date_chk, future_date, "DMYHM", locale)) {
                    populateEndDate();
                } else { 
                    showToastMsg1("Current start date does not satisfy the parameter range");
                    //obj.focus();
                    return false;
                }
            }

            if (back_date != null && back_date != 'null' && back_date != "0" && back_date != "") { //newly added back_date!="" for incident 33048
                if (isAfter(start_date_chk, back_date, "DMYHM", locale)) {
                    populateEndDate();
                } else {                    
                    showToastMsg1("Current start date does not satisfy the parameter range");
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
        var startDatepicker = $("#crxStartDate").data("kendoDateTimePicker");
        startDatepicker.value(document.formCRXPrescriptionDetails.start_date_fluid.value);        
        return false;
    }
}*/



function submitXML(qryString, xmlStr, eval_yn) {
//	console.log("submit xml called: "+qryString+ "xmlStr: " +xmlStr);
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
	xmlHttpObj.open("POST", "eIPAD/jsp/chartwidgets/pharmacy/PrescriptionCrxValidation.jsp?bean_id=" + qryString, false);
    xmlHttpObj.send(xmlDoc);
    return true;
}




/* input validations */
var frmObj		  =   document.formCRXPrescriptionDetails;
var addedDrugList =   frmObj.allDrugs.value;	
addedDrugList = addedDrugList.replace(/,\s*$/, "");	
var arrayDrugList = addedDrugList.split(",");
//console.log("arrayDrugList: "+arrayDrugList.length);

for(var i=0;i<=arrayDrugList.length;i++){
    
	$('#strengthQty_'+i).on('input', function(event) {
      //this.value = this.value.replace(/[%]/g, '');
      this.value = this.value.replace(/[^0-9]/g,'');
    });    
   
    $('#ratio_value_'+i).on('input', function(event) {
      this.value = this.value.replace(/[^0-9]/g,'');
    });
	
	$('#ratio_req_qty_'+i).on('input', function(event) {
      this.value = this.value.replace(/[^0-9.]/g,'');
    });
	
	$('#ratio_derived_qty_'+i).on('input', function(event) {
      this.value = this.value.replace(/[^0-9.]/g,'');
    });  
   
}
	
    $('#dosage_value').on('input', function(event) {
      this.value = this.value.replace(/[^0-9]/g,'');
    });
   
    $('#duration_details').on('input', function(event) {
      this.value = this.value.replace(/[^0-9]/g,'');
    });

    $('#final_prod_qty').on('input', function(event) {
      this.value = this.value.replace(/[^0-9]/g,'');
    });	
	
	$('#final_prod_qty_P').on('input', function(event) {
      this.value = this.value.replace(/[^0-9]/g,'');
    });	
	
function onRatio() {
    var header_form = document.PharmBaseForm;	
    $("#CRxRatioLabel").addClass('ivrxTabsDescOnActive');
    $("#CRxStrengthLabel").removeClass('ivrxTabsDescOnActive');
    $("#CRxPercentLabel").removeClass('ivrxTabsDescOnActive');

    $("#CRxRatioOption").addClass('ivrxTabsOnActive');
    $("#CRxStrengthOption").removeClass('ivrxTabsOnActive');
    $("#CRxPercentOption").removeClass('ivrxTabsOnActive');

    $('#CRx_ratio').show();
    $('#CRx_strength').hide();
    $('#CRx_Percentage').hide();
    frmObj.prescribingBy.value = "R";

    PrescribingBase = "R";
    
	var ddl = $("#dosageUOM").data("kendoDropDownList");
	var obj;
	var dosageInfoArray = [];
	
	var setDefalutDoseUom="";
	var drugCount = frmObj.allDrugs_count.value;
	 
	for (var i = 0; i < parseInt(drugCount); i++) {	  
		var current_qty_R = document.getElementById("current_qty_R"+i).value;
		if(current_qty_R=="0"){	
			setDefalutDoseUom="Each";
		}
    }
	for(var j= 0; j<drugCount; j++ ){
		document.getElementById("percent_ratio"+j).disabled = false;
	}
	if(setDefalutDoseUom=="Each"){
		dosageInfoArray = [];
		ddl.dataSource.data([]);
		obj = new commonObj();
        obj.code = "EACH";
        obj.desp = "EACH";
		dosageInfoArray.push(obj);
		
		$("#dosageUOM").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: dosageInfoArray
        });
	}
	
	document.getElementById("total_ratio").value = "";
	
    $("#total_ratio").css("display", "inline-block");
    $("#total_qty").css("display", "inline-block");
    $("#total_qty_percent").css("display", "none");

}

function onStrength() {
    var header_form = document.PharmBaseForm;
    $("#CRxStrengthLabel").addClass('ivrxTabsDescOnActive');
    $("#CRxRatioLabel").removeClass('ivrxTabsDescOnActive');
    $("#CRxPercentLabel").removeClass('ivrxTabsDescOnActive');

    $("#CRxStrengthOption").addClass('ivrxTabsOnActive');
    $("#CRxRatioOption").removeClass('ivrxTabsOnActive');
    $("#CRxPercentOption").removeClass('ivrxTabsOnActive');

    $('#CRx_strength').show();
    $('#CRx_ratio').hide();
    $('#CRx_Percentage').hide();

    frmObj.prescribingBy.value = "S";
    PrescribingBase = "S";

    var ddl = $("#dosageUOM").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]);

    var arrayDosageValue = frmObj.DosageValue.value.split(",");
    var arrayDosageText = frmObj.DosageText.value.split(",");
    var obj;
    var dosageInfoArray = [];
    for (var i = 0; i < arrayDosageText.length; i++) {
        obj = new commonObj();
        obj.code = arrayDosageValue[i];
        obj.desp = arrayDosageText[i];
        dosageInfoArray.push(obj);
    }

    $("#dosageUOM").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: dosageInfoArray
    });
	
	var setDefalutDoseUom="";
	var drugCount = frmObj.allDrugs_count.value;
	 
	 //if(dosageInfoArray.length==0){
	for (var i = parseInt(drugCount)-parseInt(1); i >=0; i--) {
		var current_qty_S = document.getElementById("current_qty_S"+i).value;
		//console.log("current_qty_S:: "+current_qty_S);
		if(current_qty_S=="0"){	
			setDefalutDoseUom="Each";
			dosageInfoArray.splice(i, 1);
		}
	}
	for(var j= 0; j<drugCount; j++ ){
		document.getElementById("percent_ratio"+j).disabled = false;
	}
	 //if(dosageInfoArray.length==0){
	 if(setDefalutDoseUom=="Each"){
		//dosageInfoArray = [];
		ddl.dataSource.data([]);
		obj = new commonObj();
        obj.code = "EACH";
        obj.desp = "EACH";
		dosageInfoArray.push(obj);
		
		
	}
	 if(setDefalutDoseUom=="Each"){
		 
		 if(dosageInfoArray.length>1){
			 dosageInfoArray.splice(parseInt(dosageInfoArray.length)-parseInt(1), 1);
		 }
	 }
	 $("#dosageUOM").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: dosageInfoArray
    });
    $("#total_ratio").css("display", "none");
    $("#total_qty").css("display", "none");
    $("#total_qty_percent").css("display", "none");

}


function onPercentage() {
    var header_form = document.PharmBaseForm;
    $("#CRxPercentLabel").addClass('ivrxTabsDescOnActive');
    $("#CRxRatioLabel").removeClass('ivrxTabsDescOnActive');
    $("#CRxStrengthLabel").removeClass('ivrxTabsDescOnActive');

    $("#CRxStrengthOption").removeClass('ivrxTabsOnActive');
    $("#CRxRatioOption").removeClass('ivrxTabsOnActive');
    $("#CRxPercentOption").addClass('ivrxTabsOnActive');

    $('#CRx_Percentage').show();
    $('#CRx_ratio').hide();
    $('#CRx_strength').hide();
    frmObj.prescribingBy.value = "P";
    PrescribingBase = "P";
	
	var ddl = $("#dosageUOM").data("kendoDropDownList");
	var obj;
	var dosageInfoArray = [];
	
	var setDefalutDoseUom="";
	var drugCount = frmObj.allDrugs_count.value;
	 
	for (var i = 0; i < parseInt(drugCount); i++) {	  
		var current_qty_P = document.getElementById("current_qty_P"+i).value;
		if(current_qty_P=="0"){	
			setDefalutDoseUom="Each";
		}
    }
	
	if(setDefalutDoseUom=="Each"){
		dosageInfoArray = [];
		ddl.dataSource.data([]);
		obj = new commonObj();
        obj.code = "EACH";
        obj.desp = "EACH";
		
		dosageInfoArray.push(obj);
		$("#dosageUOM").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: dosageInfoArray
        });
	}
	
	document.getElementById("total_qty_percent").value = "";
	
    $("#total_ratio").css("display", "none");
		$("#total_qty").css("display", "none");
		$("#total_qty_percent").css("display", "inline-block");
}

$(document).ready(function() {
    var path;
    var header_form = document.PharmBaseForm;

    openDrugDetailsTab();
    setTimeout(function() {
        assignPharmCRxDetailsScroller_Strength();
        //assignPharmIvRxAdminScroller();
        assignPharmCRxDetailsScroller_Ratio();
        assignPharmCRxDetailsScroller_Percentage();
		populateDurationDesc();
		 populateEndDate();
        $("#CRxAdmin").hide();
    }, 250);


    var PresByBase = "S";
    PresByBase = formObj.prescribingBy.value;

    if (PresByBase == "P") {
        onPercentage();

        if (pharmCRxDetailsScroller_Percentage != null) {
            pharmCRxDetailsScroller_Percentage.refresh();
        }

    } else if (PresByBase == "R") {

        onRatio();

        if (pharmCRxDetailsScroller_Ratio != null) {
            pharmCRxDetailsScroller_Ratio.refresh();
        }
		setRatioValues();
    } else {
        onStrength();
        if (pharmCRxDetailsScroller_Strength != null) {
            pharmCRxDetailsScroller_Strength.refresh();
        }
    }

    $('#CRxRatio').click(function(e) {
        onRatio();
        var drugCount = formObj.allDrugs_count.value;
        clearDrugDetails(drugCount);
        pharmCRxDetailsScroller_Ratio.refresh();
    });

    $('#CRxStrength').click(function(e) {
        onStrength();
        var drugCount = formObj.allDrugs_count.value;
        clearDrugDetails(drugCount);
        pharmCRxDetailsScroller_Strength.refresh();
    });

    $('#CRxPercentage').click(function(e) {
        onPercentage();
		for(var j= 0; j<drugCount; j++ ){
		document.getElementById("percent_ratio"+j).disabled = false;
	}
        var drugCount = formObj.allDrugs_count.value;
        clearDrugDetails(drugCount);
        pharmCRxDetailsScroller_Percentage.refresh();
    });

    $('textarea').each(function(index) {
        $(this).bind('touchmove', function(event) {
            event.stopPropagation();
        });
    });

    setTimeout(function() {

        var current_freq_code = $("#current_freq_code").val();
        defaultFreq(current_freq_code);
        var current_drun_code = $("#current_drun_code").val();
        drunSelection(current_drun_code);
        var current_dosage_uom = $("#current_dosage_uom").val();


        var PresByBase = "S";
        PresByBase = formObj.prescribingBy.value;

        if (PresByBase == "S") {
            selectUOM(current_dosage_uom);
        } else if (PresByBase == "P") {
            selectedFinalQut("P", current_dosage_uom);
        } else if (PresByBase == "R") {
            selectedFinalQut("R", current_dosage_uom);
        } else {
            selectUOM(current_dosage_uom);
        }
        validateDuration();

        var current_start = $("#current_start").val();
        var current_end = $("#current_end").val();

        $("#crxStartDate").data("kendoDateTimePicker").value(current_start);
        $("#crxEndDate").data("kendoDateTimePicker").value(current_end);

    }, 250);
});

function selectedFinalQut(qty, uom) {
    var frmObj = document.formCRXPrescriptionDetails;

    if (qty == "R") {
        $("#req_qty_UOM").data("kendoDropDownList").value(uom);
    } else {
        $("#final_prod_qty_uom").data("kendoDropDownList").value(uom);
    }


    var finalUOM = "";
    var finalUOMText = "";
    if (qty == 'R') {
        finalUOM = frmObj.req_qty_UOM.value;
        finalUOMText = frmObj.req_qty_UOM.options[frmObj.req_qty_UOM.selectedIndex].text;
    } else if (qty == 'P') {
        finalUOM = frmObj.final_prod_qty_uom.value;
        finalUOMText = frmObj.final_prod_qty_uom.options[frmObj.final_prod_qty_uom.selectedIndex].text;
		var addedDrugList =   frmObj.allDrugs.value;	
		/*for(var i=0;i<arrayDrugList.length;i++){	
			$("#stock_display_unit_"+i).text(finalUOM); //62700
		}*/
    }

    var ddl = $("#dosageUOM").data("kendoDropDownList");

    if (ddl)
        ddl.dataSource.data([]);

    var dosageInfoArray = [];

    var obj = new commonObj();

    obj.code = finalUOM;
    obj.desp = finalUOMText;
    dosageInfoArray.push(obj);

    $("#dosageUOM").kendoDropDownList({
        dataTextField: "desp",
        dataValueField: "code",
        dataSource: dosageInfoArray
    });
    //$("dosageUOM").data("kendoDropDownList").select(0);	
    //$("#stock_display_unit").text(finalUOM); // TO DO //62700
}

function selectUOM(uom){
	if(uom!=""){	
		 $("#dosageUOM").data("kendoDropDownList").value(uom);
	}	
}

function validateUOMRatioPercent(type,sel){
	var frmObj=document.formCRXPrescriptionDetails;
	var bean_id = frmObj.bean_id_CRX.value;
	var bean_name = frmObj.bean_name_CRX.value;
	//dropdown value
	var finalUOM = "";
	var finalUOMText="";
	var UOMText_P="";
	var UOMText_R="";
	if(type == 'R'){
		finalUOM = frmObj.req_qty_UOM.value;		
		finalUOMText=frmObj.req_qty_UOM.options[frmObj.req_qty_UOM.selectedIndex].text;
		UOMText_R = sel.options[sel.selectedIndex].text;
	}else if( type == 'P') {
		finalUOM = frmObj.final_prod_qty_uom.value;
		finalUOMText=frmObj.final_prod_qty_uom.options[frmObj.final_prod_qty_uom.selectedIndex].text;
		UOMText_P = sel.options[sel.selectedIndex].text;
	}	
	var ddl = $("#dosageUOM").data("kendoDropDownList");
    if (ddl)
        ddl.dataSource.data([]); 			
		 
	var dosageInfoArray = [];
			
	var obj = new commonObj();
			
	obj.code = finalUOM;
	obj.desp = finalUOMText;
	dosageInfoArray.push(obj);
		
	$("#dosageUOM").kendoDropDownList({
		dataTextField: "desp",
		dataValueField: "code",
		dataSource: dosageInfoArray
    });
	for(var i=0;i<arrayDrugList.length;i++){
		if(type == 'R'){
			$("#ratioQty_UOM_"+i).text(UOMText_R);
		}else if(type == 'P'){
			$("#stock_display_unit_P"+i).text(UOMText_P);	
		}
		var qryString = bean_id+"&bean_name="+bean_name+"&validate=EQUIVALENT_UOM&finalUOM="+finalUOM+"&rownumber="+i+"&type="+type;
		submitXML(qryString,"");	
	}
}
function percentageRatioValidation(obj){	
	if(PrescribingBase=='R'){
		return allowValidNumber(obj,event,2,0);
	}
	else if(PrescribingBase=='P'){
		return allowValidNumber(obj,event,2,2);
	}
	else{
		return false;
	}
}
function allowValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45)//-
	{
		return false;
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
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
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
			return false;
	}
    return true;
}

/*orientation change*/
    if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',orientationChangeCRx, false);
	}
    function orientationChangeCRx() {
    	setTimeout(function() {
    	    if (Math.abs(window.orientation) === 90) {
       	 	 pharmCRxDetailsScroller_Strength.refresh();
			 pharmCRxDetailsScroller_Ratio.refresh();
			 pharmCRxDetailsScroller_Percentage.refresh();
    	    } else {
       	 	 pharmCRxDetailsScroller_Strength.refresh();
			 pharmCRxDetailsScroller_Ratio.refresh();
			 pharmCRxDetailsScroller_Percentage.refresh();
    	    } 	 
        }, 1500);
    }
