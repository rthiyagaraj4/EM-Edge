var selectPkgRecs=[];
var storeVal="";
function convertToUppercase(event) {
    // Get the character code
    var charCode = event.which || event.keyCode;

    // If the input is a lowercase letter, convert it to uppercase
    if (charCode >= 97 && charCode <= 122) {
        // Convert to uppercase
        var uppercaseCharCode = charCode - 32;

        // Prevent the default action of inserting the character
        event.preventDefault();

        // Get the input element
        var input = event.target;

        // Get the current selection start and end
        var selectionStart = input.selectionStart;
        var selectionEnd = input.selectionEnd;

        // Replace the selected text with the uppercase character
        input.value = input.value.substring(0, selectionStart) + String.fromCharCode(uppercaseCharCode) + input.value.substring(selectionEnd);

        // Move the cursor to the next position
        input.setSelectionRange(selectionStart + 1, selectionStart + 1);
    }
}
function checkLength(input) {
    if (input.value.length > input.maxLength) {
        input.value = input.value.slice(0, input.maxLength);
    }
}
function CheckForSpecCharsAllNotAlwSpc_local(event)
{
   // var strCheck = '~`!@#$%^&()=+[]{}\\|;:,<>?\'\".'; @%!&*!)
	 var strCheck = '~`!@#$%^&()=+[]{}|\\;:,<>?\"';
	  var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
		return false ;
}

function isAlphaNumeric(Obj){
	 var strCheck = '~`!@#$%^&()=+[]{}|\\;:,<>?\"';
	if(Obj.value!=''){
		var str = Obj.value;
		for (i=0;i<str.length;i++){
			if (strCheck.indexOf(str.charAt(i)) != -1) 
			{
				let message = getMessage("SPL_CHAR_NOT_ALLOWED", "MP").trim();
				alert(`${message}`);
				Obj.value="";
				Obj.focus();
				return false;  
			}
		}
		//return true;
	}
}
/**the Above function is copied from AddModifyPatFinDetails.js for similar validations***/
function checkForEpisodeType(Obj){
	
	var episodeType = document.getElementById("episode_Type").value;
	
	if(episodeType == 'S'){
		if (Obj.tagName == "SELECT") {
			Obj.value = 'S';
		} else if (Obj.type == "text"){
			Obj.value = "";
		}
		let message = getMessage("BL9142", "BL").trim();
		alert(`${message}`);
		return false;
	}
	return true;	
}
function callPatValidation(obj)
{
	var patient_id = obj.value;
	if(patient_id!=""){
		 $.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="+patient_id,
			 dataType:"text",
			 async:false,
	         success: function(data){
	        	 var response = data.trim();
	        	 if(response == "N"){
	     			let message = getMessage("INVALID_PATIENT", "MP").trim();
					alert(`${message}`);
	     			obj.value = "";
	     			document.getElementById("encounter_Id").value = "";
	     			document.getElementById("patient_Name").value = "";
	     		}else{
	     			getPatientDetail(patient_id);
	     			getEpisodeIdVisitId();
	     		}		
	        	
	         },
	         error: function(error){
	             alert(error);
	         }
		 });
	}
	return true;
}
function getPatientDetail(patientId){
	var episodeType = document.getElementById("episode_Type").value;
	//var patientId = document.getElementById("patientId").value;
	var facility_id= document.getElementById("facility_id").value; 
	var locale = 'en';
	if(patientId != null && patientId != ""){
		 var param = "facility_id="+facility_id+"&episodeType="+episodeType+"&search_text="+patientId+"&locale=en&searchBy=PI&called_for=PAT_ID_LKUP&search_criteria=S&strWhereColumnType=VARCHAR2";
		 $.ajax({
	         type: "GET",
	         url:"../../eBL/jsp/BLCommonLookupAjax.jsp?",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
	        	 var data = JSON.parse(response);
	        	 document.getElementById("patient_Name").value = data[0].description;
	         },
	         error: function(){
	             alert("Error while getting EpisodeIdVisitId!");
	         }
		 });
	}else{
		 document.getElementById("encounter_Id").value = "";
	}
}
	
function getEpisodeIdVisitId(){
	var episodeType = document.getElementById("episode_Type").value;
	var patientId = document.getElementById("patient_Id").value;
	var facility_id= document.getElementById("facility_id").value; 
	var loginUser = document.getElementById("login_user").value; 
	var locale = 'en';
	var encounterId = "";

	if(patientId != null && patientId != ""){
		 var param = "facility_id="+facility_id+"&episodeType="+episodeType+"&patientId="+patientId;
		 $.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=getEpisodeIdVisitId",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
	        		 var data1 = JSON.parse($.trim(response));
	        		 if(data1.encID != "" && data1.encID != "undefined" &&data1.encID != undefined){
	        			 document.getElementById("encounter_Id").value = data1.encID;
						 checkForCurrIPMessage(episodeType, patientId, facility_id, data1.encID, loginUser);
		        	 }else if( data1.p_sys_message_id != "" ){
		        		 let message = getMessage(data1.p_sys_message_id, "BL").trim();
							alert(`${message}`);
		        	 }else if( $.trim(data1.p_error_text) != ""){
		        		 alert(data1.p_error_text);
		        	 }
	         },
	         error: function(){
	             alert("Error while getting EpisodeIdVisitId!");
	         }
		 });
	}else{
		 document.getElementById("encounter_Id").value = "";
	}
}

function checkForCurrIPMessage(episodeType, patientId, facility_id, encounterId, loginUser){
	
	var episode_id;
	var visit_id;
	if(encounterId != "" && encounterId.length > 8 ){
		episode_id = encounterId.slice(0,8);
		visit_id = encounterId.slice(8,encounterId.length);
	}else{
		episode_id = encounterId;
		visit_id = 0;
	}
	
	 var params = 'facilityId='+facility_id+
		'&episodeType='+episodeType+
		'&patientId='+patientId+
		'&episodeId='+episode_id+
		'&visitId='+visit_id+
		'&loginUser='+loginUser;

	 //to check and display if patient is current in-Patient
	 $.ajax({
		type:"POST",
		url:"../jsp/BillReceiptAjax.jsp?calledFrom=validateCashCounter",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			//Dont delete the commented part, it ll be required for later
			if(data.errorId != ''){
				let message = getMessage(data.errorId, "BL").trim();
				alert(`${message}`);
				$('#searchDiv input[type="text"], #searchDiv input[type="hidden"]').val('');
				return false;
			}
			if(status && data.errorText != ''){
				alert(data.errorText);
				$('#searchDiv input[type="text"], #searchDiv input[type="hidden"]').val('');
				return false;
			}

			if(data.ipFlag == 'Y'){
				let message = getMessage("BL00942", "BL").trim();
				alert(`${message}`);
			}
		},
		 error: function(data){
			 alert("Error while checking current in-Patient !");	 
		  }
	});
}

function getFinancialDetails(){
	$('#modifyFinancialDetails').find('#searchData').attr('disabled',true);
	var episodeId = "";
	var visitId = "";
	var count = 0;
	var episodeType = document.getElementById("episode_Type").value;
	var patientId = document.getElementById("patient_Id").value;
	var encounterId = document.getElementById("encounter_Id").value;
	var facility_id = document.getElementById("facility_id").value;
	var patientName = document.getElementById("patient_Name").value;
	var postDischargeFlag = "N";

	if(episodeType == "" || episodeType == "S"){
		let message = getMessage("BL9142", "BL").trim();
		alert(`${message}`);
		$('#modifyFinancialDetails').find('#searchData').removeAttr('disabled');
		return false;
	}
	if(patientId == ""){
		let message = getMessage("BL00261", "BL").trim();
		alert(`${message}`);
		$('#modifyFinancialDetails').find('#searchData').removeAttr('disabled');
		return false;
	}
	if(encounterId == "" && episodeType!="R"){
		let message = getMessage("BL6518", "BLEXT").trim();
		alert(`${message}`);
		$('#modifyFinancialDetails').find('#searchData').removeAttr('disabled');
		return false;
	}
	if(encounterId != "" && encounterId.length > 8 ){
			episodeId = encounterId.slice(0,8);
			visitId = encounterId.slice(8,encounterId.length);
	}else{
		episodeId = encounterId;
		visitId = 0;
	}
	
	if(episodeType == "O") moduleId = "OP";
	if(episodeType == "E") moduleId = "AE";
	if(episodeType == "I") moduleId = "IP";
	if(episodeType == "D") moduleId = "DC";
	if(episodeType == "R") moduleId = "MP";
		
	$('#primaryBlngGrp input[type="text"], #primaryBlngGrp input[type="button"]').attr('disabled','disabled');
	$('#payerDtls input[type="text"], #payerDtls input[type="button"]').attr('disabled','disabled');
	$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
	$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);
	$('#modifyFinancialDetails').find('#pkgDtls').attr('disabled',true);
	$('#nonInsDtls input[type="text"], #nonInsDtls input[type="button"]').attr('disabled','disabled');
	$('#ccdetails input[type="text"], #ccdetails input[type="button"]').attr('disabled','disabled');
	$('#modifyFinancialDetails').find('#finRemarks').attr('disabled','disabled');
	$('#modifyFinancialDetails').find('button').attr('disabled','disabled');
	$('#modifyFinancialDetails').find('#patiendIdLov').attr('disabled','');
	$('#modifyFinancialDetails').find('#encounterIdLov').attr('disabled','');
  	$('#modifyFinancialDetails').find('#patiendIdLov').removeAttr('disabled');
	$('#modifyFinancialDetails').find('#encounterIdLov').removeAttr('disabled');
	$('#pkgCodeStr').val('');
	$('#pkgSeqNoStr').val('');	
	$('#pkgAssocFlagStr').val(''); 
	$('#pkgDescStr').val('');
	$('#existPkgRec').val('');
	$('#modifyFinancialDetails').find('#Authorized').removeAttr('disabled');
	closeAuthPopup();
	closePkgPopup();
	closePopup();
	//to close popup if opened on researching
	document.getElementById("episodeType").value = episodeType;
	document.getElementById("patientId").value = patientId;
	document.getElementById("patientName").value = patientName;
	document.getElementById("encounterId").value = encounterId;
	document.getElementById("moduleId").value = moduleId;
	document.getElementById("authUserId").value = "";
	
	var patFinDetailsList;
	$.ajax({
		type:"GET",
		url:"../../servlet/eBL.BLModifyFinancialDetailsServlet",
		data:"action=getFinancialDetails"+
			"&patientId="+patientId+
			"&episodeId="+episodeId+
			"&episodeType="+episodeType+
			"&visitId="+visitId+
			"&facility_id="+facility_id+			
			"&locale="+$('#locale').val(),
		dataType:"text",
		async:false,
		success: function(data){
			data = JSON.parse(data);
			console.log(data);
			var financialDetailList = "";
			
			patFinDetailsList=data.patFinDetailsList;
			if(patFinDetailsList.length>0){
				for(var i = 0;i<patFinDetailsList.length;i++){
					//Clear any previously queried data
					$('#primaryBlngGrp input[type="text"], #primaryBlngGrp input[type="hidden"]').val('');
					$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
					$('#ccdetails input[type="text"], #ccdetails input[type="hidden"]').val('');
					$('#tableBody').empty();
					$('#blngGrpDesc').val('');
    	    		$('#custDesc').val('');
    	    	    $('#policyTypeDesc').val('');
					
					document.getElementById("slmtInd").value=patFinDetailsList[i].settlementInd;
					document.getElementById("creditAuthRefReqd").value=patFinDetailsList[i].creditAuthReqd; //CreditAuthReqdYN
					document.getElementById("priBlngGrpCat").value=patFinDetailsList[i].primaryBlngCat;
					document.getElementById("priBlgGrpCatDesc").value=patFinDetailsList[i].primaryBlngCatDesc;
					document.getElementById("priBlngGrpDesc").value=patFinDetailsList[i].primaryBlngGrpDesc;
					document.getElementById("priBlngGrpId").value=patFinDetailsList[i].primaryBlngGrp;
					document.getElementById("capRefSrcYN").value=patFinDetailsList[i].capRefSrc;
					document.getElementById("priRefSrc").value=patFinDetailsList[i].priRefSrcDesc;
					document.getElementById("secRefSrc").value=patFinDetailsList[i].secRefSrcDesc;
					document.getElementById("priRefSrcCode").value=patFinDetailsList[i].priRefCodeMain;
					document.getElementById("secRefSrcCode").value=patFinDetailsList[i].secRefCode;
					document.getElementById("admRecFlag").value=patFinDetailsList[i].admRecFlag;
					document.getElementById("primaryRefSrcMandYN").value=patFinDetailsList[i].primaryRefCodeMandYn;
					document.getElementById("secRefSrcMandYN").value=patFinDetailsList[i].secRefCodeMandYn;
					if(patFinDetailsList[i].settlementInd=="R" ){
						document.getElementById("custGrp").value=patFinDetailsList[i].priCustGrpDesc;
						document.getElementById("custGrpId").value=patFinDetailsList[i].priCustGrpCode;
						document.getElementById("customer").value=patFinDetailsList[i].priCustCodeDesc;
						document.getElementById("customerId").value=patFinDetailsList[i].priCustCode;
					}else if(patFinDetailsList[i].settlementInd=="X" && patFinDetailsList[i].admRecFlag=="2"){
						document.getElementById("nonInsBlngGrp").value=patFinDetailsList[i].nonInsBlngGrpDesc;
						document.getElementById("nonInsBlngGrpId").value=patFinDetailsList[i].nonInsBlngGrp;
						document.getElementById("nonInsRefSrc").value=patFinDetailsList[i].nonInsRefMainDesc;
						document.getElementById("nonInsScRefSrc").value=patFinDetailsList[i].nonInsRefSecDesc;
						document.getElementById("nonInsRefSrcId").value=patFinDetailsList[i].nonInsRefMain;
						document.getElementById("nonInsScRefSrcId").value=patFinDetailsList[i].nonInsRefSec;						
						
						document.getElementById("NonInsCustGrp").value=patFinDetailsList[i].nonInsCustGrpDesc;
						document.getElementById("NonInsCustGrpId").value=patFinDetailsList[i].nonInsCustGrp;
						document.getElementById("NonInsCust").value=patFinDetailsList[i].nonInsCustCodeDesc;
						document.getElementById("NonInsCustId").value=patFinDetailsList[i].nonInsCustCode;
						
						document.getElementById("nonInsSlmtInd").value=patFinDetailsList[i].nonInsSlmtInd;
						document.getElementById("nonInsAdmRecFlag").value=patFinDetailsList[i].nonInsAdmRecFlag;
						document.getElementById("nonInsCapRefSrcYN").value=patFinDetailsList[i].nonInscapRefSrc;
						document.getElementById("nonInsPrimaryRefSrcMandYN").value=patFinDetailsList[i].nonInspriRefCodeMandYn;
						document.getElementById("nonInsSecRefSrcMandYN").value=patFinDetailsList[i].nonInssecRefCodeMandYn;
						document.getElementById("nonInsCreditAuthRefReqd").value=patFinDetailsList[i].nonInsCreditAuthReqd;
					}
					
					if((patFinDetailsList[i].creditAuthReqd=="Y" && patFinDetailsList[i].settlementInd=="C") ||(patFinDetailsList[i].nonInsCreditAuthReqd=="Y" ) || patFinDetailsList[i].settlementInd=="R"){
						document.getElementById("dcmntRef").value=patFinDetailsList[i].creditDocRef;
						document.getElementById("docStartDate").value=patFinDetailsList[i].creditStartDt;
						document.getElementById("docEndDate").value=patFinDetailsList[i].creditEndDt;
					}
					document.getElementById("postDiscFlag").value=patFinDetailsList[i].postDiscFlag;
					postDischargeFlag = patFinDetailsList[i].postDiscFlag;
					document.getElementById("currentSeqNo").value=patFinDetailsList[i].currentSeqNo;
					document.getElementById("visitStatus").value=patFinDetailsList[i].visitStatus;
					document.getElementById("episodeStatus").value=patFinDetailsList[i].episodeStatus;
					document.getElementById("totAdmnDepAmt").value=patFinDetailsList[i].totAdmnDepAmt;
					document.getElementById("isSpecClinicRelated").value=patFinDetailsList[i].isSpecClinicRelated;
					document.getElementById("bedCatCode").value=patFinDetailsList[i].bedCatCode;
					document.getElementById("errorDesc").value=patFinDetailsList[i].errorDesc;
					
					document.getElementById("finRemarks").value=patFinDetailsList[i].fin_remarks;					
					if(patFinDetailsList[i].settlementInd=="X" && patFinDetailsList[i].admRecFlag == '2'){
						financialDetailList = data.financialDetailList;
					}
				}
				 $.ajax({ 
        	         type: "POST",
        	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp",
        	         data: "called_for=getVisitAdmnRegDateTime&facility_id="+facility_id+"&patientId="+patientId+"&episodeType="+episodeType+"&encounterID="+encounterId,
        	         dataType:"text",
        	 		 async:false,
        	         success: function(data){
        	        	 var returnValue = JSON.parse($.trim(data));
        	        	 document.getElementById("visit_regn_date_time").value = returnValue.encounterDateTime;	
        	        	 document.getElementById("amtDeciPt").value = returnValue.noOfDecimal;	
         	        	 //amtDeciPt noOfDecimal
        	         },
					 error: function(){
						alert("Error calling getVisitAdmnRegDateTime !");
					 }
        		});
			}else{
				let message = getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "common").trim();
				alert(`${message}`);
				$('#modifyFinancialDetails').find('#searchData').removeAttr('disabled');
				$('#modifyFinancialDetails').find('#Authorized').attr('disabled','disabled');
				return false;
			}
			if(financialDetailList.length > 0){
				$('#tableBody').empty();
				for(var i = 0;i<financialDetailList.length;i++){
					var dynamicRow = `
			            <div class="row" id="row_`+i+`" onclick="getDesc(`+i+`);"> 
			            	<div class="cell">
			            		<input type="checkbox" class="row-checkbox" id="selectPayer_`+i+`"  name="selectPayer_`+i+`"  disabled/>
			            	</div>
			                <div class="cell">
								<input type="text" id="priority_`+i+`" name="priority_`+i+`" value="`+financialDetailList[i].priority+`" disabled readonly class="gridInputs" onblur="validatePriority(this)" onKeyPress="return(ChkNumberInput(this,event,0));return CheckForSpecChars(event);lockbackSpace();"/>
								<input type="hidden" id="adj_rule_ind_`+i+`" name="adj_rule_ind_`+i+`" value="" disabled/>
								<input type="hidden" id="adj_perc_amt_ind_`+i+`" name="adj_perc_amt_ind_`+i+`" value="" disabled/>
								<input type="hidden" id="adj_perc_amt_value_`+i+`" name="adj_perc_amt_value_`+i+`" value="" disabled/>
								<input type="hidden" id="pmnt_diff_adj_int_`+i+`" name="pmnt_diff_adj_int_`+i+`" value="" disabled/>
								<input type="hidden" id="drg_pmnt_diff_adj_int_`+i+`" name="drg_pmnt_diff_adj_int_`+i+`" value="" disabled/>
								<input type="hidden" id="spl_srv_pmnt_diff_adj_int_`+i+`" name="spl_srv_pmnt_diff_adj_int_`+i+`" value="" disabled/>
								
							</div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="blngGrpCatg_`+i+`" name="blngGrpCatg_`+i+`" value="`+financialDetailList[i].blng_grp_catg+`" disabled readonly onchange="if(this.value!=''){blngGrpCatLookup(this);}else{clearRemainingColumnValues(this,'2');}" class="gridInputs"/>	
									<button class="gridSerachIcon" type="button" onclick="blngGrpCatLookup(this)" id="blngGrpCatgLov_`+i+`"disabled>
										<span class="mdi mdi-magnify"></span>
									</button>
									<input type="hidden" id="blngGrpCatgDesc_`+i+`" name="blngGrpCatgDesc_`+i+`" value="" disabled/>
								</div>
			                </div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="blngGrpId_`+i+`" name="blngGrpId_`+i+`" value="`+financialDetailList[i].blng_grp_id+`" disabled readonly onchange="if(this.value!=''){blngGrpIdLookup(this);}else{clearRemainingColumnValues(this,'3');}" class="gridInputs"/>	
									<button class="gridSerachIcon" type="button" onclick="blngGrpIdLookup(this)" id="blngGrpIdLov_`+i+`" disabled>
										<span class="mdi mdi-magnify"></span>
									</button>
									<input type="hidden" id="blngGrpDesc_`+i+`" name="blngGrpDesc_`+i+`" value="`+financialDetailList[i].blng_group_desc+`" disabled/>
									<input type="hidden" id="settlement_ind_`+i+`" name="settlement_ind_`+i+`" value="X" disabled/>
									<input type="hidden" id="adm_rec_flag_`+i+`" name="adm_rec_flag_`+i+`" value="2" disabled/>
									<input type="hidden" id="ref_source_main_mand_yn_`+i+`" name="ref_source_main_mand_yn_`+i+`" value="`+financialDetailList[i].priRefCSrcMandGridYN+`" disabled/>
									<input type="hidden" id="ref_source_sub_mand_yn_`+i+`" name="ref_source_sub_mand_yn_`+i+`" value="`+financialDetailList[i].secRefCSrcMandGridYN+`" disabled/>
									<input type="hidden" id="package_yn_`+i+`" name="package_yn_`+i+`" value="" disabled/>
									<input type="hidden" id="capture_ref_source_dtl_yn_`+i+`" name="capture_ref_source_dtl_yn_`+i+`" value="`+financialDetailList[i].capRefSrcGrid+`" disabled/>
								</div>
			                </div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="custGroupCode_`+i+`" name="custGroupCode_`+i+`" value="`+financialDetailList[i].cust_group_code+`" disabled readonly onchange="if(this.value!=''){custGrpCodeLookup(this);}else{clearRemainingColumnValues(this,'4');}" class="gridInputs"/>
									<button class="gridSerachIcon" type="button" onclick="custGrpCodeLookup(this)" id="custGrpCodeLov_`+i+`" disabled>
										<span class="mdi mdi-magnify"></span>
									</button>
									<input type="hidden" id="custGroupDesc_`+i+`" name="custGroupDesc_`+i+`" value="`+financialDetailList[i].blng_group_desc+`" disabled/>
								</div>
			                </div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="custCode_`+i+`" name="custCode_`+i+`" value="`+financialDetailList[i].cust_code+`" disabled readonly onchange="if(this.value!=''){custCodeLookup(this);}else{clearRemainingColumnValues(this,'5');}"  class="gridInputs"/>
									<button class="gridSerachIcon" type="button" onclick="custCodeLookup(this)" id="custCodeLov_`+i+`" disabled>
										<span class="mdi mdi-magnify"></span>
									</button>
									<input type="hidden" id="custDesc_`+i+`" name="custDesc_`+i+`" value="`+financialDetailList[i].cust_name+`" disabled/>	
								</div>
			                </div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="policyTypeCode_`+i+`" name="policyTypeCode_`+i+`" value="`+financialDetailList[i].policy_type_code+`" disabled readonly onchange="if(this.value!=''){policyTypeCodeLookup(this);}else{clearRemainingColumnValues(this,'6');}"  class="gridInputs"/>
									<button class="gridSerachIcon" type="button" onclick="policyTypeCodeLookup(this)" id="policyTypeCodeLov_`+i+`" disabled>
										<span class="mdi mdi-magnify"></span>
									</button>
									<input type="hidden" id="policyTypeDesc_`+i+`" name="policyTypeDesc_`+i+`" value="`+financialDetailList[i].policy_type_desc+`" disabled/>
									<input type="hidden" id="policy_limit_type_`+i+`" name="policy_limit_type_`+i+`" value="`+financialDetailList[i].policy_limit_type+`" disabled/>
									<input type="hidden" id="approved_days_limit_type_`+i+`" name="approved_days_limit_type_`+i+`" value="`+financialDetailList[i].approved_amt_limit_type+`" disabled/>
									<input type="hidden" id="approved_amt_limit_type_`+i+`" name="approved_amt_limit_type_`+i+`" value="`+financialDetailList[i].approved_days_limit_type+`" disabled/>
									<input type="hidden" id="cred_auth_req_yn_`+i+`" name="cred_auth_req_yn_`+i+`" value="`+financialDetailList[i].cred_auth_req_yn+`" disabled/>
									<input type="hidden" id="policy_approved_by_`+i+`" name="policy_approved_by_`+i+`" value="`+financialDetailList[i].policy_approved_by+`" />
									<input type="hidden" id="policyClaimCode_`+i+`" name="policyClaimCode_`+i+`" value="" >
								</div>	
			                </div> 
			                <div class="cell">
							<div style="width:150px;">
								<input type="text" id="policyNumber_`+i+`" name="policyNumber_`+i+`" value="`+financialDetailList[i].policy_number+`" disabled readonly onBlur="if(this.value != '' ){return isAlphaNumeric(this);return ValidatePolicyNo(this);}" class="gridInputs" maxlength='30' size="23" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event);' />
							</div>
			                </div> 
			                <div class="cell" >
								<input type="date" id="policyStartDate_`+i+`" name="policyStartDate_`+i+`" value="`+financialDetailList[i].policy_start_date+`" class="gridDate" size='12' maxlength='10' disabled readonly onBlur="if(this.value != '' ){validatePolicyStartDate(this,'fieldLevel');}"/>	
			                </div> 
			                <div class="cell" >
								<input type="date" id="policyExpiryDate_`+i+`" name="policyExpiryDate_`+i+`" value="`+financialDetailList[i].policy_expiry_date+`" class="gridDate" size='12' maxlength='10' disabled readonly onBlur="if(this.value!=''){validatePolicyEndDate(this,'fieldLevel');policyEffectiveDatesDefaulted(this);}"/>
							</div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="creditAuthRef_`+i+`" name="creditAuthRef_`+i+`" value="`+financialDetailList[i].credit_auth_ref+`" class="gridInputs" disabled readonly/>
								</div>
							</div>
			                <div class="cell">
								<input type="date" id="creditAuthDate_`+i+`" name="creditAuthDate_`+i+`" value="`+financialDetailList[i].credit_auth_date+`" class="gridDate" size='12' maxlength='10' disabled readonly onBlur="if(this.value!=''){validateCreditAuthDate(this,'fieldLevel')}"/>
							</div> 
			                <div class="cell">
								<input type="date" id="effectiveFrom_`+i+`" name="effectiveFrom_`+i+`" value="`+financialDetailList[i].effective_from+`" class="gridDate" size='12' maxlength='10' disabled readonly onBlur="if(this.value!=''){validateEffectiveFromDate(this,'fieldLevel');dfltPolicyEffToDate(this);}"/>
							</div> 
			                <div class="cell">
								<input type="date" id="effectiveTo_`+i+`" name="effectiveTo_`+i+`" value="`+financialDetailList[i].effective_to+`" class="gridDate" size='12' maxlength='10' disabled readonly onBlur="if(this.value!=''){validateEffectiveToDate(this,'fieldLevel');}"/>
							</div> 
			                <div class="cell">
								<input type="text" id="approvedAmt_`+i+`" name="approvedAmt_`+i+`" maxlength='10' size="15"  value="`+financialDetailList[i].approved_amt+`" class="gridInputs" disabled readonly onKeyPress="return(ChkNumberInput(this,event,2));return CheckForAmtInput(event,this);lockbackSpace();" onBlur="if(this.value!=''){putDecimal(this,17,`+document.getElementById("amtDeciPt").value+`);}"/>
							</div> 
			                <div class="cell">
								<input type="text" id="approvedDays_`+i+`" maxlength='4' size="4" name="approvedDays_`+i+`" value="`+financialDetailList[i].approved_days+`" class="gridInputs" disabled readonly onKeyPress="return(ChkNumberInput(this,event,0));return CheckForSpecChars(event);lockbackSpace();" onBlur="if(this.value!=''){validateEffToApprDays(this,'fieldLevel');}"/>
							</div> 
			                <div class="cell" >
								<div style="width:150px;">
									<input type="text" id="referralSourceCodeMain_`+i+`" name="referralSourceCodeMain_`+i+`" value="`+financialDetailList[i].referral_source_code_main+`" class="gridInputs" disabled readonly onBlur="if(this.value!=''){primaryRefSourceLookup(this);}else{updateRefSrcBlur('PrimaryRefSrcGrid',this);}"/>
									<button class="gridSerachIcon" type="button" id="primaryRefSourceLov_`+i+`" disabled onclick="primaryRefSourceLookup(this)">
										<span class="mdi mdi-magnify"></span>
									</button>
								</div>
							</div> 
			                <div class="cell">
								<div style="width:150px;">
									<input type="text" id="referralSourceCodeSub_`+i+`" name="referralSourceCodeSub_`+i+`" value="`+financialDetailList[i].referral_source_code_sub+`" class="gridInputs" disabled readonly onBlur="if(this.value!=''){SecRefSourceLookup(this);}else{updateRefSrcBlur('SecRefSrcGrid',this);}"/>
									<button class="gridSerachIcon" type="button" id="SecRefSourceLov_`+i+`" disabled  onclick="SecRefSourceLookup(this)">
										<span class="mdi mdi-magnify"></span>
									</button>
								</div>
							</div> 
			            </div>`;
						count++;
						$('#tableBody').append(dynamicRow);
				}
				document.getElementById("totalRowsIns").value = count;
				document.getElementById("blngGrpDesc").value = financialDetailList[0].blng_group_desc;
				document.getElementById("custDesc").value = financialDetailList[0].cust_name;
				document.getElementById("policyTypeDesc").value = financialDetailList[0].policy_type_desc;
				
			}else{
				$('#tableBody').empty();
			}
		},
		error: function(data){
				alert(data);
				return false;
		}
	});
	if(postDischargeFlag == "Y"){
		let message = getMessage("BL7065", "BL").trim();
		alert(`${message}`); 
		document.getElementById("postDischrgFlag").value ="Y";
	}
		$('#modifyFinancialDetails').find('#searchData').removeAttr('disabled');
}

function getDesc(row){
	document.getElementById("blngGrpDesc").value = document.getElementById("blngGrpDesc_"+row).value;
	document.getElementById("custDesc").value = document.getElementById("custDesc_"+row).value;
	document.getElementById("policyTypeDesc").value = document.getElementById("policyTypeDesc_"+row).value;
}
function addNewRow(){
	var i = $("#tableBody .row").length; 
	var priSlmtInd =  $('#slmtInd').val();
	var priAdmRecFlag = $('#admRecFlag').val();
	if(priSlmtInd == "X" && priAdmRecFlag == '2' ){
	
		var newRow = `
	        <div class="row" id="row_`+i+`" onclick="getDesc(`+i+`);"> 
	        	<div class="cell">
	        		<input type="checkbox" class="row-checkbox" id="selectPayer_`+i+`"   name="selectPayer_`+i+`" />
	        	</div>
	            <div class="cell">
					<input type="text" id="priority_`+i+`" name="priority_`+i+`" value="" class="gridInputs" onblur="validatePriority(this)" onKeyPress="return(ChkNumberInput(this,event,0));return CheckForSpecChars(event);lockbackSpace();"/>
					<input type="hidden" id="adj_rule_ind_`+i+`" name="adj_rule_ind_`+i+`" value="" />
					<input type="hidden" id="adj_perc_amt_ind_`+i+`" name="adj_perc_amt_ind_`+i+`" value="" />
					<input type="hidden" id="adj_perc_amt_value_`+i+`" name="adj_perc_amt_value_`+i+`" value="" />
					<input type="hidden" id="pmnt_diff_adj_int_`+i+`" name="pmnt_diff_adj_int_`+i+`" value="" />
					<input type="hidden" id="drg_pmnt_diff_adj_int_`+i+`" name="drg_pmnt_diff_adj_int_`+i+`" value="" />
					<input type="hidden" id="spl_srv_pmnt_diff_adj_int_`+i+`" name="spl_srv_pmnt_diff_adj_int_`+i+`" value="" />
				</div> 
	            <div class="cell">
					<div style="width:150px;">
						<input type="text" id="blngGrpCatg_`+i+`" name="blngGrpCatg_`+i+`" value="" onchange="if(this.value!=''){blngGrpCatLookup(this);}else{clearRemainingColumnValues(this,'2');}" class="gridInputs"/>	
						<button class="gridSerachIcon" type="button" onclick="blngGrpCatLookup(this)" id="blngGrpCatgLov_`+i+`">
							<span class="mdi mdi-magnify"></span>
						</button>
						<input type="hidden" id="blngGrpCatgDesc_`+i+`" name="blngGrpCatgDesc_`+i+`" value=""/>
					</div>
	            </div> 
	            <div class="cell">
					<div style="width:150px;">
						<input type="text" id="blngGrpId_`+i+`" name="blngGrpId_`+i+`" value="" onchange="if(this.value!=''){blngGrpIdLookup(this);}else{clearRemainingColumnValues(this,'3');}" class="gridInputs" />	
						<button class="gridSerachIcon" type="button" onclick="blngGrpIdLookup(this)" id="blngGrpIdLov_`+i+`">
								<span class="mdi mdi-magnify"></span>
							</button>
						<input type="hidden" id="blngGrpDesc_`+i+`" name="blngGrpDesc_`+i+`" value="" />
						<input type="hidden" id="settlement_ind_`+i+`" name="settlement_ind_`+i+`" value="X" />
						<input type="hidden" id="adm_rec_flag_`+i+`" name="adm_rec_flag_`+i+`" value="2" />
						<input type="hidden" id="ref_source_main_mand_yn_`+i+`" name="ref_source_main_mand_yn_`+i+`" value="" />
						<input type="hidden" id="ref_source_sub_mand_yn_`+i+`" name="ref_source_sub_mand_yn_`+i+`" value="" />
						<input type="hidden" id="package_yn_`+i+`" name="package_yn_`+i+`" value="" />
						<input type="hidden" id="capture_ref_source_dtl_yn_`+i+`" name="capture_ref_source_dtl_yn_`+i+`" value="" />
					</div>
					
	            </div> 
	            <div class="cell">
					<div style="width:150px;">
						<input type="text" id="custGroupCode_`+i+`" name="custGroupCode_`+i+`" value="" onchange="if(this.value!=''){custGrpCodeLookup(this);}else{clearRemainingColumnValues(this,'4');}" class="gridInputs"/>	
						<button class="gridSerachIcon" type="button" onclick="custGrpCodeLookup(this)" id="custGrpCodeLov_`+i+`">
							<span class="mdi mdi-magnify"></span>
						</button>
						<input type="hidden" id="custGroupDesc_`+i+`" name="custGroupDesc_`+i+`" value="" />
					</div>
				</div> 
	            <div class="cell">
					<div style="width:150px;">
						<input type="text" id="custCode_`+i+`" name="custCode_`+i+`" value="" onchange="if(this.value!=''){custCodeLookup(this);}else{clearRemainingColumnValues(this,'5');}" class="gridInputs"/>
						<button class="gridSerachIcon" type="button" onclick="custCodeLookup(this)" id="custCodeLov_`+i+`">
							<span class="mdi mdi-magnify"></span>
						</button>
						<input type="hidden" id="custDesc_`+i+`" name="custDesc_`+i+`" value="" />	
					</div>
	            </div> 
	            <div class="cell">
		            <div style="width:150px;">
						<input type="text" id="policyTypeCode_`+i+`" name="policyTypeCode_`+i+`" value="" onchange="if(this.value!=''){policyTypeCodeLookup(this);}else{clearRemainingColumnValues(this,'6');}" class="gridInputs"  />
						<button class="gridSerachIcon" type="button" onclick="policyTypeCodeLookup(this)" id="policyTypeCodeLov_`+i+`">
							<span class="mdi mdi-magnify"></span>
						</button>
						<input type="hidden" id="policyTypeDesc_`+i+`" name="policyTypeDesc_`+i+`" value="" />
						<input type="hidden" id="policy_limit_type_`+i+`" name="policy_limit_type_`+i+`" value=""/>
						<input type="hidden" id="approved_days_limit_type_`+i+`" name="approved_days_limit_type_`+i+`" value="" />
						<input type="hidden" id="approved_amt_limit_type_`+i+`" name="approved_amt_limit_type_`+i+`" value=""/>
						<input type="hidden" id="cred_auth_req_yn_`+i+`" name="cred_auth_req_yn_`+i+`" value=""/>
						<input type="hidden" id="policy_approved_by_`+i+`" name="policy_approved_by_`+i+`" value='' />
						<input type="hidden" id="policyClaimCode_`+i+`" name="policyClaimCode_`+i+`" value="" >
					</div>	
	            </div> 
	            <div class="cell">
				<div style="width:150px;">
					<input type="text" id="policyNumber_`+i+`" name="policyNumber_`+i+`" value="" onBlur="if(this.value != '' ){return isAlphaNumeric(this);return ValidatePolicyNo(this);}" class="gridInputs" maxlength='30' size="23" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event);' />
				</div>
	            </div> 
	            <div class="cell">
					<input type="date" id="policyStartDate_`+i+`" name="policyStartDate_`+i+`" value="" class="gridDate" size='12' maxlength='10' onBlur="if(this.value != ''){validatePolicyStartDate(this,'fieldLevel');}"/>	
	            </div> 
	            <div class="cell">
					<input type="date" id="policyExpiryDate_`+i+`"  name="policyExpiryDate_`+i+`" value="" class="gridDate" size='12' maxlength='10' onBlur="if(this.value!=''){validatePolicyEndDate(this,'fieldLevel');policyEffectiveDatesDefaulted(this);}" />
				</div> 
	            <div class="cell">
					<div style="width:150px;">
						<input type="text" id="creditAuthRef_`+i+`"  name="creditAuthRef_`+i+`" value="" class="gridInputs" />
					</div>
				</div> 
	            <div class="cell">
					<input type="date" id="creditAuthDate_`+i+`" name="creditAuthDate_`+i+`" value="" class="gridDate" size='12' maxlength='10' onBlur="if(this.value!=''){validateCreditAuthDate(this,'fieldLevel')}"/>
				</div>  
	            <div class="cell">
					<input type="date" id="effectiveFrom_`+i+`" name="effectiveFrom_`+i+`" value="" class="gridDate" size='12' maxlength='10' onBlur="if(this.value!=''){validateEffectiveFromDate(this,'fieldLevel');dfltPolicyEffToDate(this);}" />
				</div> 
	            <div class="cell">
					<input type="date" id="effectiveTo_`+i+`" name="effectiveTo_`+i+`" value="" class="gridDate" size='12' maxlength='10' onBlur="if(this.value!=''){validateEffectiveToDate(this,'fieldLevel');}"/>
				</div> 
	            <div class="cell">
					<input type="text" id="approvedAmt_`+i+`" name="approvedAmt_`+i+`" maxlength='10' size="15" value="" class="gridInputs" onKeyPress="return(ChkNumberInput(this,event,2));return CheckForAmtInput(event,this);lockbackSpace();" onBlur="if(this.value!=''){putDecimal(this,17,`+document.getElementById("amtDeciPt").value+`);}"/>
				</div> 
	            <div class="cell">
					<input type="text" id="approvedDays_`+i+`" name="approvedDays_`+i+`" maxlength='4' size="4" value="" class="gridInputs" onKeyPress="return(ChkNumberInput(this,event,0));return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value != ''){validateEffToApprDays(this,'fieldLevel');}"/>
				</div> 
	            <div class="cell">
	            <div style="width:150px;">
					<input type="text" id="referralSourceCodeMain_`+i+`" name="referralSourceCodeMain_`+i+`" value="" class="gridInputs" onBlur="if(this.value!=''){primaryRefSourceLookup(this);}else{updateRefSrcBlur('PrimaryRefSrcGrid',this);}" />
					<button class="gridSerachIcon" type="button" id="primaryRefSourceLov_`+i+`" onclick="primaryRefSourceLookup(this)">
						<span class="mdi mdi-magnify"></span>
					</button>
					</div>
				</div> 
	            <div class="cell">
		            <div style="width:150px;">
						<input type="text" id="referralSourceCodeSub_`+i+`" name="referralSourceCodeSub_`+i+`" value="" class="gridInputs" onBlur="if(this.value!=''){SecRefSourceLookup(this);}else{updateRefSrcBlur('SecRefSrcGrid',this);}"/>
						<button class="gridSerachIcon" type="button" id="SecRefSourceLov_`+i+`" onclick="SecRefSourceLookup(this)">
							<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div> 
	        </div>`;
		//alert(dynamicRow);
		$('#tableBody').append(newRow);
		
			var priBlngGrpCat = $('#priBlngGrpCat').val();
			var priBlgGrpCatDesc = $('#priBlgGrpCatDesc').val();
			var priBlngGrpId = $('#priBlngGrpId').val();
			var priBlngGrpDesc = $('#priBlngGrpDesc').val();
			var priRefSrcCode =$('#priRefSrcCode').val();
			var priRefSrc = $('#priRefSrc').val();
			var secRefSrcCode  = $('#secRefSrcCode').val();
			var secRefSrc = $('#secRefSrc').val();
			var capRefSrcYN = $('#capRefSrcYN').val();
			var primaryRefSrcMandYN = $('#primaryRefSrcMandYN').val();
			var secRefSrcMandYN = $('#secRefSrcMandYN').val();
			var slmtInd = $('#slmtInd').val();
			var admRecFlag = $('#admRecFlag').val();
			
			$('#blngGrpCatg_'+i).val(priBlngGrpCat);
			$('#blngGrpCatgDesc_'+i).val(priBlgGrpCatDesc);
			$('#blngGrpId_'+i).val(priBlngGrpId);
			$('#blngGrpDesc_'+i).val(priBlngGrpDesc);
						
			$('#capture_ref_source_dtl_yn_'+i).val(capRefSrcYN);
			$('#ref_source_main_mand_yn_'+i).val(primaryRefSrcMandYN);
			$('#ref_source_sub_mand_yn_'+i).val(secRefSrcMandYN);
			$('#settlement_ind_'+i).val(slmtInd);
			$('#adm_rec_flag_'+i).val(admRecFlag);
			
			if(capRefSrcYN == 'Y'){
				$('#referralSourceCodeMain_'+i).val(priRefSrcCode);
				$('#referralSourceCodeSub_'+i).val(secRefSrcCode);
				}
			i++;
			$('#totalRowsIns').val(i);
	}
}

function resetTheOrder(){
	 $('.row').each(function(index){
		 $(this).prop('id','row_'+index+'');
		 $(this).attr('onclick','getDesc('+index+');');
		 $(this).find('input').each(function(){
			 var id = $(this).attr('id');
			 var lastIndex = id.lastIndexOf('_');
			 var part1 = id.substring(0, lastIndex);
			 var newID = part1+'_'+index;
		       $(this).attr('id',newID);
		       $(this).attr('name',newID);
		        
		 });
		 $(this).find('button').each(function(){
			 var id = $(this).attr('id');
			 var lastIndex = id.lastIndexOf('_');
			 var part1 = id.substring(0, lastIndex);
			 var newID = part1+'_'+index;
		       $(this).attr('id',newID);
		        
		 });
	});
}

function validateUser(){
		closeAuthPopup();
	   document.getElementById('authPopup').style.display = 'block';
       centerPopup();
	 $.ajax({
         type: "GET",
         url: "FinancialDtlsAuthScreen.jsp",
         data: "patientid="+document.getElementById('patientId').value+"&facility_id="+document.getElementById('facility_id').value,
         success: function(response){
        	$("#authPopup").html(response);
         },
         error: function(){
             alert("Error calling FinancialDtlsAuthScreen JSP file!");
         }
	 });
	
}

function isValidUser(){
	 var user = document.getElementById('user_id');
	 var pass_wd = document.getElementById("passwrd");
	 var rmks=document.getElementById('remark');
	 var patientid=document.getElementById('patientid').value;
	 var episodeType = document.getElementById("episodeType").value;
	 var encounterId = document.getElementById("encounterId").value; 
	 var facility_id=document.getElementById('facility_id').value;
	
	 if(user.value == "")
		{
			 let message = getMessage("BL9112", "BL").trim();
	 		alert(`${message}`);
			user.focus();
			return false;
		}
	 
		if(pass_wd.value=="")  
		{
			let message = getMessage("BL9541", "BL").trim();
			alert(`${message}`);
			pass_wd.focus();
			return false;
		}
		if(rmks.value=="")
		{
			let message = getMessage("BL9306", "BL").trim();
		 	alert(`${message}`);
			rmks.focus();
			return false;
		}
		
		var param = "usr_id="+user.value+"&pass_wd="+pass_wd.value+"&rmks="+rmks.value+"&called_for=validateUSer"+"&facility_id="+facility_id+ "&patientid="+patientid+"&episodeType="+episodeType+"&encounterId="+encounterId;
		
	$.ajax({
         type: "POST",
         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp",
         data: param,
         dataType:"text",
 		 async:false,
         success: function(data){
        	 var data1 = JSON.parse($.trim(data));
        	 if(data1.Success=="Y"){
        		 $('#authUserId').val(user.value);					//authUserId
        		$('#modifyFinancialDetails').find('input').removeAttr('readonly');
        		$('#patient_Name').attr('readonly', 'readonly');
        		if($('#slmtInd').val()=="X" && $('#admRecFlag').val()=='2' ){
        			$('#modifyFinancialDetails').find('input').removeAttr('disabled');
        			$('#modifyFinancialDetails').find('button').removeAttr('disabled');
        			$('#payerDtls').find('button').removeAttr('disabled');
        			$('#payerDtls').find('row-checkbox').removeAttr('disabled');
        			var total=$('#payerDtls').find('#totalRowsIns').val();
        			$('#blngGrpDesc').attr('disabled', 'disabled');
    	    		$('#custDesc').attr('disabled', 'disabled');
    	    		$('#policyTypeDesc').attr('disabled', 'disabled'); 
    	    		
        			for(var i=0;i<total;i++){
        				if( $('#capture_ref_source_dtl_yn_'+i).val()=="Y"){
        					$('#primaryRefSourceLov_'+i).removeAttr('disabled');
    	            		$('#referralSourceCodeMain_'+i).removeAttr('disabled');
    	            		$('#referralSourceCodeSub_'+i).removeAttr('disabled');
    	        			$('#SecRefSourceLov_'+i).removeAttr('disabled');
    	            	}else{
    	            		$('#primaryRefSourceLov_'+i).attr('disabled', 'disabled');
        					$('#referralSourceCodeMain_'+i).attr('disabled', 'disabled');
    	        			$('#referralSourceCodeSub_'+i).attr('disabled', 'disabled');
    	        			$('#SecRefSourceLov_'+i).attr('disabled', 'disabled');
    	            		}
        				if($('#cred_auth_req_yn_'+i).val()=="Y"){
        					$('#creditAuthRef_'+i).removeAttr('disabled');
                    		$('#creditAuthDate_'+i).removeAttr('disabled');
                    	}else{
                			$('#creditAuthRef_'+i).attr('disabled', 'disabled');
                    		$('#creditAuthDate_'+i).attr('disabled', 'disabled');
        				}
        				
        				//policy validation 
        				if($('#policy_limit_type_'+i).val()=='U'){
        					$('#approvedDays_'+i).val('');
        					$('#approvedDays_'+i).attr('disabled', 'disabled');
        					$('#approvedAmt_'+i).val('');
        					$('#approvedAmt_'+i).attr('disabled', 'disabled');
        				}else{
        					//$('#approved_days_limit_type_'+i).val('');
        					$('#approvedDays_'+i).removeAttr('disabled');
        					//$('#approved_amt_limit_type_'+i).val('');
        					$('#approvedAmt_'+i).removeAttr('disabled');
        				}
        			}
        		}
        		
        		$('#modifyFinancialDetails').find('#Authorized').attr('disabled',true);
        		$('#modifyFinancialDetails').find('#pricatSearch').attr('disabled',false);
        		$('#modifyFinancialDetails').find('#priblngSearch').attr('disabled',false);
        		$('#modifyFinancialDetails').find('#priBlgGrpCatDesc').attr('disabled',false);
        		$('#modifyFinancialDetails').find('#priBlngGrpDesc').attr('disabled',false);
        		$('#modifyFinancialDetails').find('#priBlngGrpCat').attr('disabled',false);
        		$('#modifyFinancialDetails').find('#priBlngGrpId').attr('disabled',false);
        		
        		if($('#capRefSrcYN').val()=="Y"){
        			$('#priRefSrcIcon').removeAttr('disabled');
            		$('#secRefSrcIcon').removeAttr('disabled');
            		$('#priRefSrc').removeAttr('disabled');
            		$('#secRefSrc').removeAttr('disabled');
            		$('#priRefSrcCode').removeAttr('disabled');
            		$('#secRefSrcCode').removeAttr('disabled');
            	}else{
        			$('#priRefSrcIcon').attr('disabled', 'disabled');
            		$('#secRefSrcIcon').attr('disabled', 'disabled');
            		$('#priRefSrc').attr('disabled', 'disabled');
            		$('#secRefSrc').attr('disabled', 'disabled');
            		$('#priRefSrcCode').attr('disabled', 'disabled');
            		$('#secRefSrcCode').attr('disabled', 'disabled');
            	}
        		
        		if($('#slmtInd').val()=="R"){
        			$('#custGrpId').removeAttr('disabled');
            		$('#custGrp').removeAttr('disabled');
            		$('#cusGrpIcn').removeAttr('disabled');
            		$('#customer').removeAttr('disabled');
            		$('#customerId').removeAttr('disabled');
            		$('#customerIcn').removeAttr('disabled');
        		} else{
        			$('#custGrpId').attr('disabled', 'disabled');
            		$('#custGrp').attr('disabled', 'disabled');
            		$('#cusGrpIcn').attr('disabled', 'disabled');
            		$('#customer').attr('disabled', 'disabled');
            		$('#customerId').attr('disabled', 'disabled');
            		$('#customerIcn').attr('disabled', 'disabled');
        		}
        		
        		if($('#creditAuthRefReqd').val()=="Y" || $('#nonInsCreditAuthRefReqd').val()=="Y" || $('#nonInsSlmtInd').val()=="R" || $('#slmtInd').val()=="R"){
        			$('#ccdetails').find('input').removeAttr("disabled");
        		}else{
        			$('#ccdetails').find('input').attr('disabled','disabled');
        		}
				
				$('#modifyFinancialDetails').find('#finRemarks').attr('disabled',false);
        		
        		
        		if($('#slmtInd').val()=="C" || $('#slmtInd').val()=="R"){
        			$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
            		$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);
            	}
        		
        		if($('#nonInsCapRefSrcYN').val()=="Y"){
        			$('#nonInsRefSrc').removeAttr('disabled');
            		$('#nonInsScRefSrc').removeAttr('disabled');
            		$('#nonInsRefIcn').removeAttr('disabled');
            		$('#nonInsSecRefIcn').removeAttr('disabled');
            		$('#nonInsRefSrcId').removeAttr('disabled');
            		$('#nonInsScRefSrcId').removeAttr('disabled');
            	}else{
        			$('#nonInsRefIcn').attr('disabled', 'disabled');
            		$('#nonInsSecRefIcn').attr('disabled', 'disabled');
            		$('#nonInsRefSrc').attr('disabled', 'disabled');
            		$('#nonInsScRefSrc').attr('disabled', 'disabled');
            		$('#nonInsRefSrcId').attr('disabled', 'disabled');
            		$('#nonInsScRefSrcId').attr('disabled', 'disabled');
            	}
        		
        		if($('#nonInsSlmtInd').val()=="R"){
        			$('#NonInsCustGrp').removeAttr('disabled');
            		$('#nonInsCusGrpIcn').removeAttr('disabled');
            		$('#NonInsCust').removeAttr('disabled');
            		$('#nonInsCusIcn').removeAttr('disabled');
            		$('#NonInsCustGrpId').removeAttr('disabled');
            		$('#NonInsCustId').removeAttr('disabled');
            	} else{ 
        			$('#NonInsCustGrp').attr('disabled', 'disabled');
            		$('#nonInsCusGrpIcn').attr('disabled', 'disabled');
            		$('#NonInsCust').attr('disabled', 'disabled');
            		$('#nonInsCusIcn').attr('disabled', 'disabled');
            		$('#NonInsCustGrpId').attr('disabled', 'disabled');
            		$('#NonInsCustId').attr('disabled', 'disabled');
            	}
        	
        		if(document.getElementById("postDischrgFlag").value=="N"){
        			$.ajax({ 
           	         type: "POST",
           	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp",
           	         data: "called_for=pkgEnable&patientid="+patientid,
           	         dataType:"text",
           	 		 async:false,
           	         success: function(data){
           	        	 var isEnabled = JSON.parse($.trim(data));
           	        	if(isEnabled.Value=="Y"){
           	        		 $('#modifyFinancialDetails').find('#pkgDtls').attr('disabled',false);
           	        	 }else{
           	        		 $('#modifyFinancialDetails').find('#pkgDtls').attr('disabled',true);
           	        	 }
           	         }
        			});
        		}else{
        			$('#modifyFinancialDetails').find('#pkgDtls').attr('disabled',true);
        		}
    			closeAuthPopup();
        	 }else{
        		 if(data1.p_error_text!="" && data1.p_error_text!= undefined){
        			 alert(data1.p_error_text);
        		 }
        		 else if(data1.p_sys_message_id!="" && data1.p_sys_message_id!= undefined){ 
        			 if(data1.p_sys_message_id=="BL1233"){
        				 let message = getMessage("BL1233", "BL").trim();
						 alert(`${message}`);
        				 pass_wd.value="";
        				 pass_wd.focus();
        			 }else if(data1.p_sys_message_id=="BL1232"){
        				 let message = getMessage("BL1232", "BL").trim();
						 alert(`${message}`);
        				 pass_wd.value="";
        				 pass_wd.focus();
        			 }else if(data1.p_sys_message_id=="BL2095"){
						 let message = getMessage("BL2095", "BL").trim();
						 alert(`${message}`);
        				 user.value="";
        				 user.focus();
					 }else{
						 let message = getMessage(data1.p_sys_message_id, "BL").trim();
						 alert(`${message}`);
        				return false; 
        					
					 }
        		}
        	}
        		
         },
         error: function(){
             alert("Error calling BLModifyFinDtlsAjax JSP file!");
         }
	 });
		
}

function validateUserId(userId){
	
	var facility_id = document.getElementById('facility_id').value;
	var param = "usr_id="+userId.value+"&facility_id="+facility_id+"&called_for=validateUserId";
	
	$.ajax({ 
        type: "Get",
        url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp",
        data: param,
        dataType:"text",
		async:false,
        success: function(data){
			 var response = JSON.parse($.trim(data));
			 if(response.err_out != ''){
				 let message = getMessage(response.err_out, "BL").trim();
				 alert(`${message}`);
				 userId.value="";
				 userId.focus();
			 }
        }
	});
}

function validatePassword(password){
	
	var facility_id = document.getElementById('facility_id').value;
	var usr_id = document.getElementById('user_id').value;
	var param = "usr_id="+usr_id+"&pass_wd="+password.value+"&facility_id="+facility_id+"&called_for=validateUserPassword";
	
	$.ajax({ 
        type: "Get",
        url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp",
        data: param,
        dataType:"text",
		 async:false,
        success: function(data){
	       	var response = JSON.parse($.trim(data));
	        if(response.message_text != ''){
	       		alert(response.message_text);
	       		password.value = '';
	       		return;
	     	}else if(response.err_out != ''){
	       		let message = getMessage(response.err_out, "BL").trim();
				alert(`${message}`);
				password.value="";
				password.focus();
	        }
        }
	});
}

function onApply(){
	var form= $("#modifyFinancialDetails");
	var episode_id = "";
	var visit_id = "";
	var episodeType = document.getElementById("episodeType").value;
	var patientId = document.getElementById("patientId").value;
	var facility_id= document.getElementById("facility_id").value; 
	var encounterId = document.getElementById("encounterId").value; 
	var authUserId = document.getElementById("authUserId").value; 
	var priBlngGrpDesc = document.getElementById("priBlngGrpDesc").value; 
	
	if(priBlngGrpDesc == ""){
		let message = getMessage("BL9116", "BL").trim();
   		alert(`${message}`);
		return false;
	}
	if($('#priBlngGrpId').val()==""){
		let message = getMessage("BL9116", "BL").trim();
   		alert(`${message}`);
		return false;
	}//added to validate primary blng mandatory on apply
	
	if(authUserId == ""){
		let message = getMessage("BL9136", "BL").trim();
   		alert(`${message}`);
		return false;
	}
	
	if(encounterId != "" && encounterId.length > 8 ){
		episode_id = encounterId.slice(0,8);
		visit_id = encounterId.slice(8,encounterId.length);
	}else{
		episode_id = encounterId;
		visit_id = 0;
	}
	
	var rowCount = $('.row').length;

	$('#totalRowsIns').val(rowCount);
	var slmtInd = $('#slmtInd').val();
	var admRecFlag = $('#admRecFlag').val();
	
	//First Validate Primary Billing Group
	var validateYN = validatePrimaryBlngGrpSection();
	if(validateYN){
		//if Primary Billing Group Is Insurance then validate Insurance & Non Insurance Section
		if(slmtInd == 'X' && admRecFlag == '2'){
			validateYN =  validateInsuranceSection();
		}	
		if(validateYN){
			//proc_package_check before calling main procedure
			$.ajax({
				 type: "GET",
		         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?",
		         data:"called_for=procPackageCheck"+
					"&patientId="+patientId+
					"&episode_id="+episode_id+
					"&facility_id="+facility_id+
					"&visit_id="+visit_id+
					"&episodeType="+episodeType,
				 dataType:"text",
				 async:false,
		        success: function (data){
		        	var data1 = JSON.parse($.trim(data));
		        	console.log(data1.Value);
		        	$('#packageChk').val(data1.Value);
		        	if(data1.Value == "Y"){
		        		let message = getMessage("BL6354", "BLEXT").trim();
		        		if(confirm(`${message}`)){
		        			billExistCheck(episode_id,visit_id);
		        		}else{
		        			return false;
		        		}
		        	}else{
		        		billExistCheck(episode_id,visit_id);
		        	}

		        },
		        error: function(data){
					alert("Error while checking package:: "+data);
					return false;
		        }
		    });
		}else{
			return false;
		}
		
	}else{
		return false;
	}
	
		
			    
}
function billExistCheck(episode_id,visit_id){
	/*-------------Check Discount level & Bill exist check -----------------*/
	$.ajax({
        type: "GET",
        url:  "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?",
        data: "called_for=billExistCheck"+
			"&patientId="+$('#patient_Id').val()+
			"&episode_id="+episode_id+
			"&facility_id="+$('#facility_id').val()+
			"&visit_id="+visit_id+
			"&episodeType="+$('#episode_Type').val()+
			"&priBlngGrpId="+$('#priBlngGrpId').val()+
			"&customerId="+$('#customerId').val()+
			"&nonInsBlngGrp="+$('#nonInsBlngGrp').val()+
			"&NonInsCustId="+$('#NonInsCustId').val()+
			"&login_user="+$('#login_user').val(),
        success: function (data){
	        var result = JSON.parse($.trim(data));
	    	console.log(result);
	    	if(result.message_text != ""){
	    		alert(result.message_text);
	    		return false;
	    	}else if(result.err_out != ""){
	    		let message = getMessage(result.err_out, "BL").trim();
	    		if(message == null || message == undefined || message == "" ){
	    			message = getMessage(result.err_out, "BLEXT").trim();
	    		}
        		alert(`${message}`);
        		return false;
	    	}else if(result.cnfm_alert != ""){
	    		let message = getMessage(result.cnfm_alert, "BL").trim();
	    		if(message == null || message == undefined || message == "" ){
	    			message = getMessage(result.cnfm_alert, "BLEXT").trim();
	    		}
        		if(confirm(`${message}`)){
        			finalSave(episode_id,visit_id);
        		}else{
        			return false;
        		}
	    	}else{
	    		finalSave(episode_id,visit_id);
	    	}

        },
        error: function(data){
			alert("Error while checking bill exist:: "+data);
			return false;
        }
    });
}

function finalSave(episode_id,visit_id){
	var form= $("#modifyFinancialDetails");
	/*-------Final Save call --------------*/
	let message = getMessage("CHANGE_BILLING_GROUP", "common").trim();
	if(confirm(`${message}`)){
		$.ajax({
	        type: form.attr('method'),
	        url:  "../../servlet/eBL.BLModifyFinancialDetailsServlet",
	        data: form.serialize()+"&episode_id="+episode_id+"&visit_id="+visit_id,
	        success: function (data){
		        var result = $.trim(data);
		    	console.log(result);
		    	var array = result.split("~");
		    	var success = array[0];
		    	var sys_message_id = array[1];
		    	var error_text = array[2];
		    	if(success == 'Y'){
		    		let message = getMessage(sys_message_id, "BLEXT").trim();
		    		alert(`${message}`);
					reloadWithSessionUpdate();
			        //location.reload();
		    	}else{
		    		if(error_text != ""){
		    			alert(error_text);
		    		}else if(sys_message_id != ""){
		    			let message = getMessage(sys_message_id, "BL").trim();
			    		if(message == null || message == undefined || message == "" ){
			    			message = getMessage(sys_message_id, "BLEXT").trim();
			    		}
			    		alert(`${message}`);
		    		}
		    		return false;
		    	}
		    	
	
	        },
	        error: function(data){
				alert(data);
				return false;
	        }
	    });
	}else{
		return false;
	}
}

//validate_primary_blng_grp_section() -> if this is true then call ->validate insurance_section()-> if this returns true then call  -> validate_non_ins_blng_grp_section()

function validatePrimaryBlngGrpSection(){
	var blngGrpID = $('#priBlngGrpId').val();
	var priBlngGrpDesc = $('#priBlngGrpDesc').val();
	var capRefSrcYN = $('#capRefSrcYN').val();
	var primaryRefSrcMandYN = $('#primaryRefSrcMandYN').val();
	var secRefSrcMandYN = $('#secRefSrcMandYN').val();
	var creditAuthRefReqd = $('#creditAuthRefReqd').val();
	
	if(blngGrpID == null || blngGrpID == "" || blngGrpID == undefined){
		let message = getMessage("BL9301", "BL").trim();
		alert(`${message}`);
		return false;
	}
	if(capRefSrcYN == 'Y'){
		if(primaryRefSrcMandYN == 'Y' && $('#priRefSrcCode').val() == ""){
			let message = getMessage("BL9816", "BL").trim();
			let label = getLabel("Common.for.label", "common").trim();
			let description = priBlngGrpDesc.trim();

			alert(`${message} ${label} ${description}`);
			return false;
		}
		if(secRefSrcMandYN == 'Y' && $('#secRefSrcCode').val() == ""){
			let message = getMessage("BL9817", "BL").trim();
			let label = getLabel("Common.for.label", "common").trim();
			let description = priBlngGrpDesc.trim();
			
			alert(`${message} ${label} ${description}`);
			return false;
		}
	}
	if($('#slmtInd').val() == 'R'){
		if($('#custGrpId').val() == '' || $('#custGrpId').val() == null || $('#custGrpId').val() == undefined){
			let message = getMessage("BL6278", "BL").trim();
			alert(`${message}`);
			return false;
		}
		if($('#customerId').val() == '' || $('#customerId').val() == null || $('#customerId').val() == undefined){
			let message = getMessage("BL9102", "BL").trim();
			alert(`${message}`);
			return false;
		}
	}
	if(creditAuthRefReqd == "Y" && !($('#slmtInd').val() == 'X' && $('#admRecFlag').val() == '2')){
		if($('#dcmntRef').val() == ""){
			let message = getMessage("BL9302", "BL").trim();
			alert(`${message}`);
			return false;
		}
		if($('#docStartDate').val() == ""){
			let message = getMessage("BL1531", "BL").trim();
			alert(`${message}`);
			return false;
		}
		if($('#docEndDate').val() == ""){
			let message = getMessage("BL1532", "BL").trim();
			alert(`${message}`);
			return false;
		}
	}
	return true;	
}
function validateInsuranceSection(){
	var flag = true;
	if($('#totalRowsIns').val() == 0){
		let message = getMessage("BL9574", "BL").trim();
		alert(`${message}`);
		
		return false;
	}
	var validationMessage = "";
	var arrPriority = [];
	var arrBlngGrpId = [];
	var arrPayer = [];
	var arrPolicyTypeCode = [];
	var arrPolicyNo = [];
	$('.row').each(function(index){
		 var priority = $(this).find('#priority_'+index).val();
		 let row_label = "in Row "+(index+1);
		 if(priority == ""){
			 let message = getMessage("BL9325", "BL").trim();
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
		 }
		 arrPriority[index] = priority;
		 if($(this).find('#blngGrpId_'+index).val() == ""){
			 let message = getMessage("BL9301", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
			}
		 arrBlngGrpId[index] = $(this).find('#blngGrpId_'+index).val() ;
		 if($(this).find('#custGroupCode_'+index).val() == ""){
			let message = getMessage("BL6278", "BL").trim();			 
			validationMessage = validationMessage + `${message} ${row_label}\n`;
		 }
		 
		 arrPayer[index] = $(this).find('#custCode_'+index).val();
		 if($(this).find('#custCode_'+index).val() == ""){
			 let message = getMessage("BL9102", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
			}
		 
		 arrPolicyTypeCode[index] = $(this).find('#policyTypeCode_'+index).val();
		 if($(this).find('#policyTypeCode_'+index).val() == ""){
			let message = getMessage("BL9103", "BL").trim();			 
			validationMessage = validationMessage + `${message} ${row_label}\n`;
			}
		 
		 arrPolicyNo[index] = $(this).find('#policyNumber_'+index).val();
		 if($(this).find('#policyNumber_'+index).val() == ""){
			 let message = getMessage("BL9104", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
		}
		 
		 if($(this).find('#policyStartDate_'+index).val() == ""){
			let message = getMessage("BL9324", "BL").trim();			 
			validationMessage = validationMessage + `${message} ${row_label}\n`;
		}
		 
		 if($(this).find('#policyExpiryDate_'+index).val() == ""){
			 let message = getMessage("BL9105", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
			}
		 
		 if($(this).find('#effectiveFrom_'+index).val() == ""){
			let message = getMessage("BL9565", "BL").trim();			 
			validationMessage = validationMessage + `${message} ${row_label}\n`;
			}
		
		 if($(this).find('#effectiveTo_'+index).val() == ""){
			let message = getMessage("BL9566", "BL").trim();			 
			validationMessage = validationMessage + `${message} ${row_label}\n`;
		    }

		 var cred_auth_req_yn = $(this).find('#cred_auth_req_yn_'+index).val();
		 var creditAuthRef = $(this).find('#creditAuthRef_'+index).val();
		 var creditAuthDate = $(this).find('#creditAuthDate_'+index).val();
		 
		 if(cred_auth_req_yn == 'Y' && creditAuthRef == ""){
			 let message = getMessage("BL8148", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
		}
		 if(cred_auth_req_yn == 'Y' && creditAuthDate == ""){
			 let message = getMessage("BL9562", "BL").trim();			 
			 validationMessage = validationMessage + `${message} ${row_label}\n`;
		}
		 
		 var policy_limit_type = $(this).find('#policy_limit_type_'+index).val();
		 var approved_days_limit_type = $(this).find('#approved_days_limit_type_'+index).val();
		 var approvedAmt = $(this).find('#approvedAmt_'+index).val();
		 var approved_amt_limit_type = $(this).find('#approved_amt_limit_type_'+index).val();
		 var approvedDays = $(this).find('#approvedDays_'+index).val();
		
		 if(policy_limit_type == 'R'){
			 if(approved_days_limit_type == 'R' && approvedAmt == ""){
				 let message = getMessage("BL9564", "BL").trim();			 
				 validationMessage = validationMessage + `${message} ${row_label}\n`;
				}
			 
			 if(approved_amt_limit_type == 'R' ){
				 let message="";
				 if(approvedDays == ""){
					message = getMessage("BL9563", "BL").trim();		//8605	 
				 }else if(approvedDays=="0" ){
					 message = getMessage("BL9008", "BL").trim();		//8605	 
				 }
				 if(message!="")
					 validationMessage = validationMessage + `${message} ${row_label}\n`;
			 }
		 }		  
		 
		 var capture_ref_source_dtl_yn = $(this).find('#capture_ref_source_dtl_yn_'+index).val();
		 var ref_source_main_mand_yn = $(this).find('#ref_source_main_mand_yn_'+index).val();
		 var referralSourceCodeMain = $(this).find('#referralSourceCodeMain_'+index).val();		 
		 var ref_source_sub_mand_yn = $(this).find('#ref_source_sub_mand_yn_'+index).val();
		 var referralSourceCodeSub = $(this).find('#referralSourceCodeSub_'+index).val();
		 
		 if(capture_ref_source_dtl_yn == 'Y'){
			 if(ref_source_main_mand_yn == 'Y' && referralSourceCodeMain == ''){
				 let message = getMessage("BL9816", "BL").trim();
				 let label = getLabel("Common.for.label", "common").trim();
				 validationMessage = validationMessage + `${message} ${label} ${row_label}\n`;
			}if(ref_source_sub_mand_yn == 'Y' && referralSourceCodeSub == ''){
				 let message = getMessage("BL9817", "BL").trim();
				 let label = getLabel("Common.for.label", "common").trim();
				 validationMessage = validationMessage + `${message} ${label} ${row_label}\n`;
			 }
		 }
		 validationMessage = validationMessage + dateChecks(index);
	});
	if(validationMessage != ""){
		alert(validationMessage);
		flag = false;
		return false;
	}
	var found1Priority = arrPriority.find(element => element == '1');
	if(found1Priority == undefined){
		 let message = getMessage("BL9834", "BL").trim();			 
		 alert(`${message}`);
		 flag = false;
	}else{
		var priority1Indx = arrPriority.indexOf('1');
		 if($('#priority_'+priority1Indx).val() == "1" && $('#priBlngGrpId').val() != $('#blngGrpId_'+priority1Indx).val()){
			 let message = getMessage("BL9838", "BL").trim();			 
			 alert(`${message}`);
			 flag = false;
		 }
	}
	var priBlngGrpId = $('#priBlngGrpId').val();
	var priBlngGrpFound = arrBlngGrpId.find(element => element == priBlngGrpId);
	if(priBlngGrpFound == undefined){
		alert("No payer is available for primary biling group");
		flag = false;
	}
	
	if(flag){
		flag = chkSamePayerPolicy();
	}
	
	if(flag){
		flag = validateNonInsBlngGrpSection();
	}
	return flag;
}

function dateChecks(index){
	 var retVal = "";
	
	 retVal = retVal + validatePolicyStartDate(document.getElementById("policyStartDate_"+index),"saveLevel") ;
	 //alert("After validatePolicyStartDate "+retVal);
	 retVal = retVal + validatePolicyEndDate(document.getElementById("policyExpiryDate_"+index),"saveLevel") ;
	 //alert("After validatePolicyEndDate "+retVal);
	 retVal = retVal + validateCreditAuthDate(document.getElementById("creditAuthDate_"+index),"saveLevel");
	 retVal = retVal + validateEffectiveFromDate(document.getElementById("effectiveFrom_"+index),"saveLevel") ;
	 //alert("After validateEffectiveFromDate "+retVal);
	 retVal = retVal + validateEffectiveToDate(document.getElementById("effectiveTo_"+index),"saveLevel") ;
	 //alert("After validateEffectiveToDate "+retVal);
	 if(retVal == ""){
		 retVal = validateEffToApprDays(document.getElementById("approvedDays_"+index),"saveLevel");
	 }
	return retVal;
}

function chkSamePayerPolicy(){
	var rtn_total_records = $('#totalRowsIns').val();
	for(var i = 0;i < rtn_total_records ; i++ ){
		var payer_var1 = $('#custCode_'+i).val();
	    var policy_var1 = $('#policyTypeCode_'+i).val();
		var blng_grp1 = $('#blngGrpId_'+i).val();
		var priority1 = $('#priority_'+i).val();

		var policy_no1 = $('#policyNumber_'+i).val();
		var pol_start_date_arr1 = $('#policyStartDate_'+i).val();
		var pol_exp_date_arr1 = $('#policyExpiryDate_'+i).val();
		var policy_eff_frm_date1 = $('#effectiveFrom_'+i).val();
		var policy_eff_to_date1 = $('#effectiveTo_'+i).val();
		var j = i;
		while(!((j+1) > rtn_total_records)){
			j++;
			var payer_var2 = $('#custCode_'+j).val();
			var policy_var2 = $('#policyTypeCode_'+j).val();
			var blng_grp2 = $('#blngGrpId_'+j).val();
			var priority2 = $('#priority_'+j).val();

			var policy_no2 = $('#policyNumber_'+j).val();
			var pol_start_date_arr2 = $('#policyStartDate_'+j).val();
			var pol_exp_date_arr2 = $('#policyExpiryDate_'+j).val();
			var policy_eff_frm_date2 = $('#effectiveFrom_'+j).val();
			var policy_eff_to_date2 = $('#effectiveTo_'+j).val();
			
			if(payer_var1 == payer_var2)
			{
				if(policy_var1 == policy_var2)
				{
					if(policy_no1 == policy_no2)
					{
						if(compareDates(policy_eff_to_date1,policy_eff_frm_date2))
						{
							if(priority1 > priority2);
							{
								let message = getMessage("BL7425", "BL").trim();			 
								alert(`${message}`);
								return false;
							}
						}
						else
						{
							if(priority1 > priority2)
							{
								let message = getMessage("BL7425", "BL").trim();			 
								alert(`${message}`);
								return false;
							}
						}
					}
				}
			}
		}
	}
	return true;
}

function validateNonInsBlngGrpSection(){
	
	var nonInsBlngGrp = $('#nonInsBlngGrp').val();
	var nonInsCapRefSrcYN = $('#nonInsCapRefSrcYN').val();
	var nonInsPrimaryRefSrcMandYN = $('#nonInsPrimaryRefSrcMandYN').val();
	var nonInsSecRefSrcMandYN = $('#nonInsSecRefSrcMandYN').val();
	var nonInsCreditAuthRefReqd = $('#nonInsCreditAuthRefReqd').val();
	let label = getLabel("Common.for.label", "common").trim();
	let description = getLabel("eBL.NON_INS_BILLING_GROUP.label", "eBL").trim();
	
	if(nonInsBlngGrp == null || nonInsBlngGrp == "" || nonInsBlngGrp == undefined){
		let message = getMessage("BL9106", "BL").trim();			 
		 alert(`${message}`);	
		return false;
	}
	if($('#nonInsBlngGrp').val() == $('#priBlngGrpId').val()){
		let message = getMessage("BL8146", "BL").trim();			 
		alert(`${message}`);	
		return false;
	}
	
	if(nonInsCapRefSrcYN == 'Y'){
		if(nonInsPrimaryRefSrcMandYN == 'Y' && $('#nonInsRefSrcId').val() == ""){
			let message = getMessage("BL9816", "BL").trim();
			alert(`${message} ${label} ${description}`);
			return false;
		}
		if(nonInsSecRefSrcMandYN == 'Y' && $('#nonInsScRefSrcId').val() == ""){
			let message = getMessage("BL9817", "BL").trim();
			alert(`${message} ${label} ${description}`);
			return false;
		}
	}
	if($('#nonInsSlmtInd').val() == 'R'){
		if($('#NonInsCustGrpId').val() == '' || $('#NonInsCustGrpId').val() == null || $('#NonInsCustGrpId').val() == undefined){
			let message = getMessage("BL6278", "BL").trim();
			alert(`${message} ${label} ${description}`);
			return false;
		}
		if($('#NonInsCustId').val() == '' || $('#NonInsCustId').val() == null || $('#NonInsCustId').val() == undefined){
			let message = getMessage("BL9102", "BL").trim();
			alert(`${message} ${label} ${description}`);
			return false;
		}
	}
	if(nonInsCreditAuthRefReqd == 'Y'){
		if($('#dcmntRef').val() == ""){
			let message = getMessage("BL9302", "BL").trim();
			alert(`${message}`);
			return false;
		}
		if($('#docStartDate').val() == ""){
			let message = getMessage("BL1531", "BL").trim();
			alert(`${message}`);
			return false;
		}
		if($('#docEndDate').val() == ""){
			let message = getMessage("BL1532", "BL").trim();
			alert(`${message}`);
			return false;
		}
	}
	
	return true;
}

function resetEntireForm(){
	// implement form reset logic here
	reloadWithSessionUpdate();
}

function patiendIdLookup(obj){
	closePopup();
	 document.getElementById('popup').style.display = 'block';
    centerPopup();
	var title = "Search Patient";		
	var called_for = 'PAT_ID_LKUP';
	var column_sizes = "50%,50%";
	var column_descriptions = encodeURI('Patient ID'+','+'Patient Name');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "patient_id";
	var searchFieldID ='patient_Id,patient_Name';
	var facility_id = document.getElementById('facility_id').value;
	
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&facility_id="+facility_id);
	$.ajax({
         type: "GET",
         url: "BLCommonLookup.jsp",
         data: param,
         success: function(response){
             $("#popup").html(response);
           },
         error: function(){
             alert("Error including JSP file!");
         }
	 });
}
function encounterIdLookup(obj){
	closePopup();
	var patient_id = document.getElementById("patient_Id").value;
	if(obj.value==''){
		if(patient_id==""){
			let message = getMessage("BL6103", "BL").trim();
			alert(`${message}`);
			return false;
		} 
	}
	
	var episode_type = document.getElementById('episode_Type').value;
	if(episode_type=="R"){
		return false;
	}

    document.getElementById('popup').style.display = 'block';
    centerPopup();
   
    var facility_id = document.getElementById('facility_id').value;
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&facility_id="+facility_id;
	
	var title = "Encounter ID";		
	var called_for = 'ENC_ID_LKUP';
	var column_sizes = "50%,50%";
	var column_descriptions = encodeURI('Encounter ID'+','+'Patient ID');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "ENCOUNTER_ID"+","+"patient_id";
	var searchFieldID ='encounter_Id,patient_Id';
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}		
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery);
	 $.ajax({
         type: "GET",
         url: "BLCommonLookup.jsp",
         data: param,
         success: function(response){
             $("#popup").html(response);
             setTimeout(onloadfunc,1000);
         },
         error: function(){
             alert("Error including JSP file!");
         }
	 });
}

function clearPkgValues(idx){
	if($('#pkgCode_'+idx).val()==''){
		$('#seqNo_'+idx).val('');
		$('#pkgdesc_'+idx).val('');
		$('#selectPkg_'+idx).val('N');
	}
}

function clearValues(val){
	if(val=='priBlngGrpCat'){
			
			$('#primaryBlngGrp input[type="text"], #primaryBlngGrp input[type="hidden"]').val('');
			$('#payerDtls input[type="text"],#payerDtls input[type="date"], #payerDtls input[type="hidden"]').val('');
			$('#tableBody').empty();
			$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
			$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);		
			
			$('#blngGrpDesc').val('');
			$('#custDesc').val('');
		    $('#policyTypeDesc').val('');
		    $('#priBlgGrpCatDesc').val('');
			
			$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
			$('#nonInsDtls').find('input, button').attr('disabled',true);	
			
			$('#ccdetails input[type="text"], #ccdetails input[type="date"]').val('');
			('#ccdetails').find('input').attr('disabled',true);	
	}else if(val=='priBlgGrpCatDesc'){
		if($('#priBlgGrpCatDesc').val()==''){

			$('#primaryBlngGrp input[type="text"], #primaryBlngGrp input[type="hidden"]').val('');
			$('#payerDtls input[type="text"],#payerDtls input[type="date"], #payerDtls input[type="hidden"]').val('');
			$('#tableBody').empty();
			$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
			$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);				

			$('#blngGrpDesc').val('');
			$('#custDesc').val('');
			$('#policyTypeDesc').val('');
			
			$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
			$('#nonInsDtls').find('input, button').attr('disabled',true);			
			
			$('#ccdetails input[type="text"], #ccdetails input[type="date"]').val('');
			$('#ccdetails').find('input').attr('disabled',true);			
		}
	 }
	else if(val=='priBlngGrpId'){
			$('#primaryBlngGrp input[type="text"]:not(#priBlgGrpCatDesc,#priBlngGrpCat), #primaryBlngGrp input[type="hidden"]').val('');
			$('#primaryBlngGrp').find('input:not(#priBlgGrpCatDesc, #priBlngGrpCat, #priBlngGrpId, #priBlngGrpDesc), button:not(#pricatSearch, #priblngSearch)').attr('disabled', true);
			$('#payerDtls input[type="text"],#payerDtls input[type="date"], #payerDtls input[type="hidden"]').val('');
			$('#tableBody').empty();
			$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
			$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);	
			$('#blngGrpDesc').val('');
			$('#custDesc').val('');
			$('#policyTypeDesc').val('');

			$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
			$('#nonInsDtls').find('input, button').attr('disabled',true);
			
			$('#ccdetails input[type="text"], #ccdetails input[type="date"]').val('');
			$('#ccdetails').find('input').attr('disabled',true);			
						
	 }else if(val=='priBlngGrpDesc'){
			$('#primaryBlngGrp input[type="text"]:not(#priBlgGrpCatDesc,#priBlngGrpCat), #primaryBlngGrp input[type="hidden"]').val('');
			$('#primaryBlngGrp').find('input:not(#priBlgGrpCatDesc, #priBlngGrpCat, #priBlngGrpId, #priBlngGrpDesc), button:not(#pricatSearch, #priblngSearch)').attr('disabled', true);
			$('#payerDtls input[type="text"],#payerDtls input[type="date"], #payerDtls input[type="hidden"]').val('');
			$('#tableBody').empty();
			$('#modifyFinancialDetails').find('#remove-selected-rows').attr('disabled',true);
			$('#modifyFinancialDetails').find('#addRw').attr('disabled',true);
			$('#blngGrpDesc').val('');
			$('#custDesc').val('');
			$('#policyTypeDesc').val('');
			
			$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
			$('#nonInsDtls').find('input, button').attr('disabled',true);
			
			$('#ccdetails input[type="text"], #ccdetails input[type="date"]').val('');
			$('#ccdetails').find('input').attr('disabled',true);			
	 }else if(val=='custGrp' || val=='custGrpId'){
		 $('#custGrpId').val('');
		 $('#custGrp').val('');
		 $('#customer').val('');
		 $('#customerId').val('');
	 }else if(val=='customer' || val=='customerId'){
		 $('#customer').val('');
		 $('#customerId').val('');
		 
	 }else if(val=='nonInsBlngGrp' || val=='nonInsBlngGrpId'){
		$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
		$('#nonInsDtls').find('input:not(#nonInsBlngGrp, #nonInsBlngGrpId), button:not(#nonInsBlngGrpBttn)').attr('disabled', true);
		
		$('#ccdetails input[type="text"], #ccdetails input[type="date"]').val('');
		$('#ccdetails').find('input').attr('disabled',true);
	 }
	 else if(val=='NonInsCustGrp' || val=='NonInsCustGrpId'){
		 	 $('#NonInsCustGrpId').val('');
		 	 $('#NonInsCustGrp').val('');
			 $('#NonInsCust').val('');
			 $('#NonInsCustId').val('');
		
	 }else if(val=='NonInsCust' || val=='NonInsCustId'){
		 	 $('#NonInsCustId').val('');
			 $('#NonInsCust').val('');
		
	 }else if(val=='priRefSrc' || val=='priRefSrcCode'){ 
		 $('#priRefSrcCode').val(''); 
		 $('#priRefSrc').val('');
	 }else if(val=='SecRefSrc' || val=='secRefSrcCode'){
		 $('#secRefSrcCode').val('');
		 $('#secRefSrc').val('');		 
	 }else if(val=='nonInsRefSrcId' || val=='nonInsRefSrc'){
		 $('#nonInsRefSrcId').val('');
		 $('#nonInsRefSrc').val('');
	 }else if(val=='nonInsScRefSrc' || val=='nonInsScRefSrcId'){
		 $('#nonInsScRefSrcId').val('');
		 $('#nonInsScRefSrc').val('');
	 }
	//MM00292083	
}

function nonInsBlngGrpLov(obj,From){
	closePopup();
    document.getElementById('popup').style.display = 'block';
    centerPopup();
   var episode_type = document.getElementById('episodeType').value;
   var patient_id = document.getElementById("patientId").value;
   var facility_id = document.getElementById('facility_id').value;
   var encounterId = document.getElementById("encounterId").value;
   var authUser = "ALPHAMC";
   var episodeId = "";
   var visitId = "";
   if(encounterId != "" && encounterId.length > 8 ){
		episodeId = encounterId.slice(0,8);
		visitId = encounterId.slice(8,encounterId.length);
   }else{
		episodeId = encounterId;
		visitId = 0;
   }
   
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&authUser="+authUser+"&encounterId="+encounterId+"&visitId="+visitId+"&facility_id="+facility_id;
	
	var title = "Non Insurance Billing Group";		
	var called_for = 'NON_INS_BLNG_GRP_ID';
	var column_sizes = "50%,50%";
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code,description";
	var searchFieldID = 'nonInsBlngGrpId,nonInsBlngGrp';
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}		
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
            setTimeout(onloadfunc,1000);
         },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}

function blngGrpCatLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
    var facility_id = document.getElementById('facility_id').value;
    
	var title = "Billing Group Category";	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'BILLING_CATG_LOOKUP';
	var searchFieldID = "blngGrpCatg_"+index+","+"blngGrpCatgDesc_"+index;
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}
	
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
	}else if(From == '2'){
		searchOpt='desc';
	}else{
		searchOpt='code';
	}
	
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&facility_id="+facility_id+"&searchOpt="+searchOpt);
	$.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
	
}

function blngGrpIdLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var blngGrpCatg = document.getElementById("blngGrpCatg_"+index).value;
	var priority = $('#priority_'+index).val();
	var priBlngGrpId = $('#priBlngGrpId').val();
	
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
    var patient_id = document.getElementById("patientId").value;
    var encounterId = document.getElementById("encounterId").value;
    var facility_id = document.getElementById('facility_id').value;
    var episodeId = "";
    var visitId = "";
	if(encounterId != "" && encounterId.length > 8 ){
		episodeId = encounterId.slice(0,8);
		visitId = encounterId.slice(8,encounterId.length);
	}else{
		episodeId = encounterId;
		visitId = 0;
	}
	var authUser = document.getElementById("login_user").value;
	var settlement_ind = "X";
	var adm_rec_flag = "2";
	
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&episodeId="+episodeId+"&visitId="+visitId+"&blngGrpCatg="+blngGrpCatg+"&authUser="+authUser+"&settlement_ind="+settlement_ind+"&adm_rec_flag="+adm_rec_flag+"&facility_id="+facility_id;
    
    var title = "Billing Group";		
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'INS_BLNG_GRP_ID';
	var searchFieldID = "blngGrpId_"+index+","+"blngGrpDesc_"+index;
		
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
	}else if(From == '2'){
		searchOpt='desc';
	}else{
		searchOpt='code';
	}	
	var param = ("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
            setTimeout(onloadfunc,1000);
         },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
	
	
}

function PrimaryBlngGrpCatLkp(obj,From){
	closePopup();
	if(obj.value == ""){
		$('#priBlgGrpCatDesc').val('');
		$('#priBlngGrpCat').val('');
	}

       document.getElementById('popup').style.display = 'block';
       centerPopup();
    var episode_type = document.getElementById('episodeType').value;
    var facility_id = document.getElementById('facility_id').value;
    if(document.getElementById('priBlngGrpDesc').value!=""){
    	document.getElementById('priBlngGrpDesc').value="";
    	document.getElementById('priBlngGrpId').value="";
		clearValues('priBlngGrpDesc');    	
    }
 
	var title = "Billing Group Category";	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'PRI_BILLING_CATG_LOOKUP';
	var searchFieldID = "priBlngGrpCat,priBlgGrpCatDesc";
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}		
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&facility_id="+facility_id+"&searchOpt="+searchOpt);
	$.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
             $("#popup").html(response);
             setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
	
	
}
function PrimaryBlngGrpIdLkp(obj,From){
	closePopup();

    document.getElementById('popup').style.display = 'block';
    centerPopup();
        
    var episode_type = document.getElementById('episodeType').value;
    var patient_id = document.getElementById("patientId").value;
    var encounterId = document.getElementById("encounterId").value;
    var facility_id = document.getElementById('facility_id').value;
    var episodeId = "";
    var visitId = "";
	if(encounterId != "" && encounterId.length > 8 ){
		episodeId = encounterId.slice(0,8);
		visitId = encounterId.slice(8,encounterId.length);
	}else{
		episodeId = encounterId;
		visitId = 0;
	}
	var blngGrpCatg = document.getElementById("priBlngGrpCat").value;
	var authUser = document.getElementById("login_user").value;
	var settlement_ind = "";
	
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&episodeId="+episodeId+"&visitId="+visitId+"&blngGrpCatg="+blngGrpCatg+"&authUser="+authUser+"&settlement_ind="+settlement_ind+"&facility_id="+facility_id;
	var title = "Billing Group";		
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'PRI_BLNG_GRP_ID';
	var searchFieldID = "priBlngGrpId,priBlngGrpDesc";
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
	
	
}

function custGroupLookup(obj,From){
	closePopup();
	var blngGrpId = document.getElementById("priBlngGrpId").value;
	if(blngGrpId == undefined || blngGrpId == "" || blngGrpId == null){
		//alert("Please Select Billing Group Id")
		let message = getMessage("BL9301", "BL").trim();
		alert(`${message}`);
		return false;
	}
	
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
	var patient_id = document.getElementById("patientId").value;
	var facility_id = document.getElementById('facility_id').value;
	var locale=document.getElementById('locale').value;
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&facility_id="+facility_id+"&locale="+locale;
	
	var title = "Customer Group";
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'CustomerGroup';
	var searchFieldID = "custGrpId"+","+"custGrp";
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
            setTimeout(onloadfunc,1000);
           /* if(searchMainScreenVal != ""){
            	search();
            }*/
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}


function custLookup(obj,From){
	closePopup();
	var cust_grp_code = document.getElementById("custGrpId").value;
	if(cust_grp_code == undefined || cust_grp_code == "" || cust_grp_code == null){
		let message = getMessage("BL8587", "BL").trim();
		alert(`${message}`);
		return false;
	}

    document.getElementById('popup').style.display = 'block';
    centerPopup();
   	var locale = document.getElementById('locale').value;
	var episode_type = document.getElementById('episodeType').value;
	var module_id = document.getElementById('moduleId').value;
	var patient_id = document.getElementById("patientId").value;
	var blngGrpId = document.getElementById("priBlngGrpId").value;
	var settlement_ind = document.getElementById("slmtInd").value;
	var adm_rec_flag = document.getElementById("admRecFlag").value;
	var nd_package_yn = document.getElementById("package_yn").value;
	var facility_id = document.getElementById('facility_id').value;

	var paramForQuery = "episodeType="+episode_type+"&module_id="+module_id+"&patient_id="+patient_id+"&blngGrpId="+blngGrpId+"&cust_grp_code="+cust_grp_code+"&settlement_ind="+settlement_ind+"&adm_rec_flag="+adm_rec_flag+"&nd_package_yn="+nd_package_yn+"&facility_id="+facility_id+"&locale="+locale;

	var title = "Customer";	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'Customer';
	var searchFieldID = "customerId"+","+"customer";
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
		
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
           /* if(searchMainScreenVal != ""){
            	search();
            }*/
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}

function onloadfunc(){
		if(document.getElementById('searchOpt').value != "")
			document.getElementById('searchBy').value = document.getElementById('searchOpt').value;
		 if(($('#called_for').val()=='PAT_ID_LKUP' && $('#searchMainScreenVal').val()!='') || $('#called_for').val()!='PAT_ID_LKUP'){
			$('#modifyFinancialDetails').find('#Srch').click();
			// const myTimeout = setTimeout( $('#modifyFinancialDetails').find('#Srch').click(), 100000);
		 }
	}
function nonInsCustGroupLookup(obj,From){
	closePopup();
	var blngGrpId = document.getElementById("nonInsBlngGrpId").value;
	if(blngGrpId == undefined || blngGrpId == "" || blngGrpId == null){
		let message = getMessage("BL9301", "BL").trim();
		alert(`${message}`);
		return false;
	}
	
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
	var patient_id = document.getElementById("patientId").value;
	var facility_id = document.getElementById('facility_id').value;
	var locale=document.getElementById('locale').value;
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&facility_id="+facility_id+"&locale="+locale;
	
	var title = "Customer Group Code";
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'CustomerGroup';
	var searchFieldID = "NonInsCustGrpId,NonInsCustGrp";
	
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
           /* if(searchMainScreenVal != ""){
            	search();
            }*/
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}


function nonInsCustLookup(obj,From){
	closePopup();
	var cust_grp_code = document.getElementById("NonInsCustGrpId").value;
	if(cust_grp_code == undefined || cust_grp_code == "" || cust_grp_code == null){
		let message = getMessage("BL8587", "BL").trim();
		alert(`${message}`);
		return false;
	}

    document.getElementById('popup').style.display = 'block';
    centerPopup();
   	var locale = document.getElementById('locale').value;
	var episode_type = document.getElementById('episodeType').value;
	
	var locale = document.getElementById('locale').value;
	var episode_type = document.getElementById('episodeType').value;
	var module_id = document.getElementById('moduleId').value;
	var patient_id = document.getElementById("patientId").value;
	var blngGrpId = document.getElementById("nonInsBlngGrpId").value;
	var settlement_ind = document.getElementById("nonInsSlmtInd").value;
	var adm_rec_flag = document.getElementById("nonInsAdmRecFlag").value;
	var nd_package_yn = document.getElementById("package_yn").value;
	var facility_id = document.getElementById('facility_id').value;

	var paramForQuery = "episodeType="+episode_type+"&module_id="+module_id+"&patient_id="+patient_id+"&blngGrpId="+blngGrpId+"&cust_grp_code="+cust_grp_code+"&settlement_ind="+settlement_ind+"&adm_rec_flag="+adm_rec_flag+"&nd_package_yn="+nd_package_yn+"&facility_id="+facility_id+"&locale="+locale;
	
	var title = "Customer";	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'Customer';
	var searchFieldID = "NonInsCustId"+","+"NonInsCust";

	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}

	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
           /* if(searchMainScreenVal != ""){
            	search();
            }*/
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}

function custGrpCodeLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	if(blngGrpId == undefined || blngGrpId == "" || blngGrpId == null){
		let message = getMessage("BL9301", "BL").trim();
		alert(`${message}`);
		return false;
	}
	
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
	var patient_id = document.getElementById("patientId").value;
	var facility_id = document.getElementById('facility_id').value;
	
	var paramForQuery = "episode_type="+episode_type+"&patient_id="+patient_id+"&facility_id="+facility_id;
	
	var title = "Customer Group";
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = $('#custGroupCode_'+index).val();
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'CUST_GRP_CODE';
	var searchFieldID = "custGroupCode_"+index+","+"custGroupDesc_"+index;
	
	var From = '1';
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
	}else if(From=='2'){
		searchOpt='desc';
	}
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
         /*   if(searchMainScreenVal != ""){
            	search();
            }*/
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}

function custCodeLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var cust_grp_code = document.getElementById("custGroupCode_"+index).value;
	if(cust_grp_code == undefined || cust_grp_code == "" || cust_grp_code == null){
		let message = getMessage("BL8587", "BL").trim();
		alert(`${message}`);
		return false;
	}
	
    document.getElementById('popup').style.display = 'block';
    centerPopup();
		
	var episode_type = document.getElementById('episodeType').value;
	var module_id = document.getElementById('moduleId').value;
	var patient_id = document.getElementById("patientId").value;
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var nd_package_yn = document.getElementById("package_yn_"+index).value;
	var facility_id = document.getElementById('facility_id').value;
	var priority = document.getElementById('priority_'+index).value;
	var paramForQuery = "episode_type="+episode_type+"&module_id="+module_id+"&patient_id="+patient_id+"&blngGrpId="+blngGrpId+"&cust_grp_code="+cust_grp_code+"&settlement_ind="+settlement_ind+"&adm_rec_flag="+adm_rec_flag+"&nd_package_yn="+nd_package_yn+"&facility_id="+facility_id+"&priority="+priority;
	
	var title = "Customer";	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = $('#custCode_'+index).val();
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+','+'description';
	var called_for = 'CUST_CODE';
	var searchFieldID = "custCode_"+index+","+"custDesc_"+index;
	
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
	}else if(From == '2'){
		searchOpt='desc';
	}else{
		searchOpt='code';
	}
	
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
            $("#popup").html(response);
          /*  if(searchMainScreenVal != ""){
            	search();
            }*/
            setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
}

function policyTypeCodeLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var cust_code = document.getElementById("custCode_"+index).value;
	if(cust_code == undefined || cust_code == "" || cust_code == null){
		let message = getMessage("BL00104", "BL").trim();
		alert(`${message}`);
		return false;
	}

    document.getElementById('popup').style.display = 'block';
    centerPopup();
        
    var episode_type = document.getElementById('episodeType').value;
	var cust_grp_code = document.getElementById("custGroupCode_"+index).value;
	var facility_id = document.getElementById('facility_id').value;
	
	var paramForQuery = "episode_type="+episode_type+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&facility_id="+facility_id;
									    	
	var title = "Policy Type";		
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = $('#policyTypeCode_'+index).val();
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'POLICY_TYPE_CODE';
	var searchFieldID = "policyTypeCode_"+index+","+"policyTypeDesc_"+index;
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}
	
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
	}else if(From == '2'){
		searchOpt='desc';
	}else{
		searchOpt='code';
	}
	
	var sql = "";			
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
        type: "GET",
        url: "BLCommonLookup.jsp",
        data: param,
        success: function(response){
       	 //alert("1");
            $("#popup").html(response);
            /*if(searchMainScreenVal != ""){
            	search();
            }*/
			setTimeout(onloadfunc,1000);
        },
        error: function(){
            alert("Error including JSP file!");
        }
	 });
	
}

function primaryRefSourceLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	document.getElementById('popup').style.display = 'block';
	centerPopup();
       
    var episode_type = document.getElementById('episodeType').value;
	
	var paramForQuery = "episode_type="+episode_type;
									    	
	var title = getLabel("Common.referralsource.label","common");		
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'Primary_Ref_Source_LOV';
	var searchFieldID = "referralSourceCodeMain_"+index;
	/*if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}*/
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
		//strWhereColumn="code";
	}else if(From == '2'){
		searchOpt='desc';
		//strWhereColumn="description";
	}else{
		searchOpt='code';
		//strWhereColumn="code";
	}
	var sql = "";			
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
       type: "GET",
       url: "BLCommonLookup.jsp",
       data: param,
       success: function(response){
           $("#popup").html(response);
          /* if(searchMainScreenVal != ""){
        	   search();
           }*/
           setTimeout(onloadfunc,1000);
       },
       error: function(){
           alert("Error including JSP file!");
       }
	 });
	
}

function SecRefSourceLookup(obj){
	closePopup();
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	document.getElementById('popup').style.display = 'block';
	centerPopup();
	       
	var episode_type = document.getElementById('episodeType').value;
	
	var paramForQuery = "episode_type="+episode_type;
									    	
	var title = getLabel("Common.referralsource.label","common");
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = 'Sec_Ref_Source_LOV';
	var searchFieldID = "referralSourceCodeSub_"+index;
	
	var searchOpt = ''; var From = '1'; // As ins grid doesnt have desc, we always send code as search key
	if(From == '1'){
		searchOpt='code';
		//strWhereColumn="code";
	}else if(From == '2'){
		searchOpt='desc';
		//strWhereColumn="description";
	}else{
		searchOpt='code';
		//strWhereColumn="code";
	}
			
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
	   type: "GET",
	   url: "BLCommonLookup.jsp",
	   data: param,
	   success: function(response){
	       $("#popup").html(response);
	     /*  if(searchMainScreenVal != ""){
	    	   search();
           }*/
	       setTimeout(onloadfunc,1000);
	   },
	   error: function(){
	       alert("Error including JSP file!");
	   }
	 });
	
}


function PrimaryRefSrcLkp(obj,From){
	closePopup();
    document.getElementById('popup').style.display = 'block';
    centerPopup();
    var episode_type = document.getElementById('episodeType').value;
	
	var paramForQuery = "episode_type="+episode_type;
									    	
	var title = getLabel("Common.referralsource.label","common");
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = '';
	var searchFieldID = '';
	if(obj.id == 'nonInsRefSrc'){
		searchFieldID = "nonInsRefSrcId,nonInsRefSrc";
		called_for = 'NonInsPrimaryRefSRCLkup';
	}else{
		searchFieldID = "priRefSrcCode,priRefSrc";
		called_for = 'PrimaryRefSRCLkup';
	}
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
		//strWhereColumn="referral_code";
	}else if(From=='2'){
		searchOpt='desc';
		//strWhereColumn="long_desc";
	}
	/*if(episode_type=='R'){ nonInsRefSrc nonInsRefSrcId nonInsScRefSrc nonInsScRefSrcId
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}*/
	var sql = "";			
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
       type: "GET",
       url: "BLCommonLookup.jsp",
       data: param,
       success: function(response){
      	 //alert("1");
           $("#popup").html(response);
           setTimeout(onloadfunc,1000);
          // alert("3");
       },
       error: function(){
           alert("Error including JSP file!");
       }
	 });
	
}

function SecRefSrcLkp(obj,From){
	closePopup();
    document.getElementById('popup').style.display = 'block';
    centerPopup();
	var episode_type = document.getElementById('episodeType').value;
	
	var paramForQuery = "episode_type="+episode_type;
									    	
	var title = getLabel("Common.referralsource.label","common");	
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Code'+','+'Description');
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	var strWhereColumn = "code"+","+"description";
	var called_for = '';
	//var searchFieldID = "secRefSrcCode,secRefSrc";
	var searchFieldID = '';
	if(obj.id == 'nonInsScRefSrc'){
		searchFieldID = "nonInsScRefSrcId,nonInsScRefSrc";
		called_for = 'NonInsSecRefSRCLkup';
	}else{
		searchFieldID = "secRefSrcCode,secRefSrc";
		called_for = 'SecRefSRCLkup';
	}
	var searchOpt='';
	if(From=='1'){
		searchOpt='code';
		//strWhereColumn="referral_code";
	}else if(From=='2'){
		searchOpt='desc';
		//strWhereColumn="long_desc";
	}
	/*if(episode_type=='R'){ nonInsRefSrc nonInsRefSrcId nonInsScRefSrc nonInsScRefSrcId
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}*/
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&col_show_hide="+col_show_hide+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery+"&searchOpt="+searchOpt);
	 $.ajax({
	   type: "GET",
	   url: "BLCommonLookup.jsp",
	   data: param,
	   success: function(response){
	       $("#popup").html(response);
	       setTimeout(onloadfunc,1000);
	   },
	   error: function(){
	       alert("Error including JSP file!");
	   }
	 });
	
}

function centerPopup() {
	var popup = document.getElementById('popup');
    const windowHeight = window.innerHeight;
    const windowWidth = window.innerWidth;
    const popupHeight = popup.offsetHeight;
    const popupWidth = popup.offsetWidth;
    const topOffset = (windowHeight - popupHeight) / 2;
    const leftOffset = (windowWidth - popupWidth) / 2;

    popup.style.top = topOffset + 'px';
    popup.style.left = leftOffset + 'px';
}

function centerAuthPopup() {
	var popup = document.getElementById('authPopup');
    const windowHeight = window.innerHeight;
    const windowWidth = window.innerWidth;
    const popupHeight = popup.offsetHeight;
    const popupWidth = popup.offsetWidth;
    const topOffset = (windowHeight - popupHeight) / 2;
    const leftOffset = (windowWidth - popupWidth) / 2;
    popup.style.top = topOffset + 'px';
    popup.style.left = leftOffset + 'px';
}

function centerPkgPopup() {
	var pkglkup = document.getElementById('pkglkup');
    const windowHeight = window.innerHeight;
    const windowWidth = window.innerWidth;
    const popupHeight = pkglkup.offsetHeight;
    const popupWidth = pkglkup.offsetWidth;
    const topOffset = (windowHeight - popupHeight) / 2;
    const leftOffset = (windowWidth - popupWidth) / 2;

    pkglkup.style.top = topOffset + 'px';
    pkglkup.style.left = leftOffset + 'px';
}

function pkgBlngClsEligiblity(idx){
	 var episode_type = document.getElementById('episodeType').value;
	 var patient_id = document.getElementById("patientId").value;
	 var encounterId = document.getElementById("encounterId").value;
	 var facility_id = document.getElementById('facility_id').value;
	 var locale = document.getElementById('locale').value;

	var pkgCode = document.getElementById("pkgCode_"+idx).value;
	var pkgSeqNo = document.getElementById("seqNo_"+idx).value;
	var selPkg =document.getElementById("selectPkg_"+idx).value;
	var admDateTime= document.getElementById("visit_regn_date_time").value;
	var blngGrpId = document.getElementById('priBlngGrpId').value;
	//seqNo_ pkgCode_ pkgdesc_ selectPkg_ pkgCode pkgSeqNo admDateTime blngGrpId
	//alert(pkgCode+" "+pkgSeqNo+" "+admDateTime+" "+blngGrpId)
	 var episodeId = "";
	 var visitId = "";
     if(encounterId != "" && encounterId.length > 8 ){
			episodeId = encounterId.slice(0,8);
			visitId = encounterId.slice(8,encounterId.length);
		}else{
			episodeId = encounterId;
			visitId = 0;
		}
	var paramForQuery="episodeType="+episode_type+"&patientId="+patient_id+"&episodeId="+episodeId+"&visitId="+visitId+"&facility_id="+facility_id+"&locale="+locale+"&pkgCode="+pkgCode+"&pkgSeqNo="+pkgSeqNo+"&admDateTime="+admDateTime+"&blngGrpId="+blngGrpId+"&pkgIdx="+idx+"&selPkg="+selPkg;
	 closeAuthPopup();
	$.ajax({
		   type: "GET",
		   url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=getBlngClsEligiblity",
		   data: paramForQuery,
		   success: function(response){
		      // $("#pkglkup").html(response);authPopup
			   var respData = JSON.parse($.trim(response));
			   if(respData.showReqPage=="Y"){
				   document.getElementById('authPopup').style.display = 'block';
				//  document.getElementById('lookup-headercontainer').style.width= '100%';
				   centerAuthPopup();
				   $.ajax({
					   type: "GET",
					   url: "BLBlngClassEligilityForPkg.jsp",
					   data: paramForQuery,
					   success: function(response){
					       $("#authPopup").html(response);
					   },
					   error: function(){
					       alert("Error including JSP file!");
					   }
					 });
			   }
			  /* if(respData.assoc_yn=="Y"){
				   document.getElementById("selectPkg_"+idx).checked=true;
			   }else{
				   document.getElementById("selectPkg_"+idx).checked=false;
			   }*/
			   if(respData.error_text!="" && respData.error_text!="undefined" && respData.error_text!=undefined){
				   alert(respData.error_text)
				    return false;
			  }
			   if(respData.error_message_id!="" && respData.error_message_id!="undefined" && respData.error_message_id!=undefined){
				   let message = getMessage(respData.error_message_id, "BL").trim();
				   if(message == undefined || message == "" || message == "undefined"){
					   message = getMessage(respData.error_message_id, "BLEXT").trim();
				   }
					alert(`${message}`);
					return false;
			   }
			   if(respData.assoc_yn=='N'){
				   document.getElementById("selectPkg_"+idx).checked=false;
				   document.getElementById("selectPkg_"+idx).value="N";
			   }else{
				   document.getElementById("selectPkg_"+idx).checked=true;
				   document.getElementById("selectPkg_"+idx).value="Y";
			   }
		   },
		   error: function(){
		       alert("Error including JSP file!");
		   }
		 });
	
}

function pkgDtlsLkp(obj,idx){
	closePkgPopup();
	document.getElementById('pkglkup').style.display = 'block';
	centerPkgPopup();
		 var episode_type = document.getElementById('episodeType').value;
		 var patient_id = document.getElementById("patientId").value;
		 var encounterId = document.getElementById("encounterId").value;
		 var facility_id = document.getElementById('facility_id').value;
		 var locale = document.getElementById('locale').value;
		 var episodeId = "";
		 var visitId = "";
	     if(encounterId != "" && encounterId.length > 8 ){
				episodeId = encounterId.slice(0,8);
				visitId = encounterId.slice(8,encounterId.length);
			}else{
				episodeId = encounterId;
				visitId = 0;
			}
		var totalRec=$('#pkgTotalRows').val();
		var seqNoString="";
		for(var q=0;q<totalRec;q++){
			var seqNoStng=$('#seqNo_'+q).val();
			if(seqNoStng != ""){
				if(q==0){
					seqNoString=seqNoStng;
				}
				else{
					seqNoString=seqNoString+","+seqNoStng;
				}
			}
		}
		var paramForQuery="episodeType="+episode_type+"&patientId="+patient_id+"&episodeId="+episodeId+"&visitId="+visitId+"&facility_id="+facility_id+"&locale="+locale+"&seqNoString="+seqNoString;
		
	var title = "Subscribed Package for an Approval";		
	var column_sizes = escape("50%,50%");
	var column_descriptions = encodeURI('Select'+','+'Package SeqNo'+','+'Pkg Code'+','+'Package Description');
	var searchMainScreenVal = obj.value;
	var strWhereColumnType = "VARCHAR2";
	//var strWhereColumn = "pkgCode_"+idx+","+"pkgdesc_"+idx+","+"seqNo_"+idx;
	var strWhereColumn ="PACKAGE_CODE";
	var called_for = 'PKG_DTLS_LKUP';
	var searchFieldID = "pkgCode_"+idx+","+"pkgdesc_"+idx+","+"seqNo_"+idx;
	//alert("pkg-"+paramForQuery)
	var param = encodeURI("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&searchMainScreenVal="+searchMainScreenVal+"&strWhereColumnType="+strWhereColumnType+"&strWhereColumn="+strWhereColumn+"&called_for="+called_for+"&searchFieldID="+searchFieldID+"&"+paramForQuery);
	 $.ajax({
	   type: "GET",
	   url: "BLSubsPkgLookup.jsp",
	   data: param,
	   success: function(response){
	       $("#pkglkup").html(response);
	   },
	   error: function(){
	       alert("Error including JSP file!");
	   }
	 });
	
}

function searchPkg(){
	 var search_text = document.getElementById('searchText').value;
	     var seqNoString = document.getElementById('seqNoString').value;
	   
	    var searchMainScreenVal =  search_text;
		var strWhereColumnType =  document.getElementById("strWhereColnTyp").value;
		var strWhereColumn =  document.getElementById("strWhereColmn").value;
		var called_for = document.getElementById("calledfor").value;
		var paramForQuery = decodeURI(document.getElementById("paramForQry").value);
		var searchFieldID=document.getElementById("searchField").value;
		var facility_id = document.getElementById('facility').value;
		if(facility_id=="" ||facility_id==null){
			facility_id="";
		}
		var locale = document.getElementById('locale').value;
		
	$.ajax({
		type:"GET",
		url:"../../eBL/jsp/BLCommonLookupAjax.jsp?search_text=" + encodeURIComponent(search_text),
		data:"called_for="+called_for+
			"&search_text="+search_text+
			"&search_criteria=C"+
			"&strWhereColumnType="+strWhereColumnType+
			"&strWhereColumn="+strWhereColumn+
			"&seqNoString="+seqNoString+
			"&searchFieldID="+searchFieldID+
			"&"+paramForQuery+
			"&facility_id="+facility_id+
			"&locale="+locale,
		dataType:"text",
		async:false,
		success: function(data){
			//alert("after getting Result: " +data);
			var searchData = JSON.parse(data);
			//alert(searchData);
			if(searchData != ""){
				displayPackages(searchData);
			}else{
				//alert("No Data Found");
				let message = getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "common").trim();
				alert(`${message}`);
				return false;
			}
		},
		error: function(data){
				alert(data);
				return false;
		}
	});
}

function displayPackages(searchData){
	var called_for = document.getElementById("calledfor").value;
	var resultsDiv = document.getElementById('pkgLkupResult');
	resultsDiv.innerHTML = ''; // Clear previous results
    // Create header row
   var columnDescription = decodeURI(document.getElementById('columndescriptions').value);
  
   var array = columnDescription.split(',');
   var headerRow = document.createElement('div');
   headerRow.classList.add('result-row', 'header-row');
   //alert(array[1]);
   var headerDiv = '';
   
   for(var i = 0;i<array.length;i++){
	   headerDiv = headerDiv + '<div class="result-cell" align="center">'+array[i]+'</div>';
   }
   // headerRow.innerHTML = '<div class="result-cell">Code</div><div class="result-cell">Description</div>';
   headerRow.innerHTML = headerDiv;
   resultsDiv.appendChild(headerRow);
   var data="";
   var m=0;
    // Create table-like rows for search results
    searchData.forEach(function(item) {
        var row = document.createElement('div');
        row.classList.add('result-row');
        var rowColumnsData = '';
        console.log(item);
       	rowColumnsData=rowColumnsData+`<div  class="result-cell" align="center"><input type="checkbox" class="row-checkbox" id="select`+m+`"  name="select`+m+`" onclick='selectpkg(this,`+m+`)'></div>`;
    	
        if(item.seqno != "null"){
        	rowColumnsData = rowColumnsData + `<div class="result-cell" align="center">`+item.seqno+`<input type='hidden'  id="seq`+m+`" value='`+item.seqno+`'></div>`;
        }
		
        if(item.code != "null"){
        	rowColumnsData = rowColumnsData + `<div class="result-cell" align="center">`+item.code+`<input type='hidden'  id="code`+m+`" value='`+item.code+`'></div>`;
        }
        if(item.description != "null"){
        	rowColumnsData = rowColumnsData + `<div class="result-cell" align="center">`+item.description+`<input type='hidden'  id="desc`+m+`" value="`+item.description+`"></div>`;
        }
       
        row.innerHTML = rowColumnsData;
       /* row.addEventListener('click', function() {
        	//selectPackage(item.code, item.description,item.seqno);
        	//selectRow();
        	$('select'+m).val()="Y"
        });*/
        resultsDiv.appendChild(row);
        m++;
    });
   /* if(searchData.length == "1"){
    	selectPackage(searchData[0].code, searchData[0].description,searchData[0].seqno);
     }*/
}

function selectpkg(val,idx){
	if(val.checked){
		document.getElementById("select"+idx).value="Y";
		//document.getElementById("selectRec").value=document.getElementById("selectRec").value+"~"+idx;
		selectPkgRecs.push(idx);
		var returned=[];
		returned=ArrNoDupe(selectPkgRecs);
		selectPkgRecs=[];
		selectPkgRecs=returned;
	}else{
		document.getElementById("select"+idx).value="N";
		//document.getElementById("selectRec").value=document.getElementById("selectRec").value+"~"+idx;
		selectPkgRecs.splice(idx,1);
	}
	
	document.getElementById("selectRec").value=selectPkgRecs;
}

//To find duplication in array
function ArrNoDupe(a) {
    var temp = {};
    for (var i = 0; i < a.length; i++)
        temp[a[i]] = true;
    var r = [];
    for (var k in temp)
        r.push(k.toString());
    return r;
}

function loadSelectedpackages(){
	var selectedData=document.getElementById("selectRec").value;
	var dataArr=selectedData.split(",");
	
	for(var j=0;j<dataArr.length;j++){ //2 0-1
		var totRw=document.getElementById('pkgTotalRows').value;
		var idx=dataArr[j];
		if(j<(dataArr.length-1)){
			 var added=addPkgDtls();
		 }
		var i= --totRw;
		 document.getElementById('seqNo_'+i).value =$('#seq'+idx).val();
		 document.getElementById('pkgCode_'+i).value =$('#code'+idx).val();
		 document.getElementById('pkgdesc_'+i).value =$('#desc'+idx).val();
	}
	document.getElementById("selectRec").value="";
	selectPkgRecs=[];
	closePkgPopup();
}

function selectPackage(code, description,seqno) {
	var called_for = document.getElementById("calledfor").value;
	var searchFieldID = document.getElementById("searchField").value;
	//alert(searchFieldID);
	 var array = searchFieldID.split(',');
	 if(array.length >1){
		 document.getElementById(array[0]).value = code;
		 document.getElementById(array[1]).value = description;
		 document.getElementById(array[2]).value = seqno;
			
	 }
	 //getting the index value by splitting the searchFieldID
	 var idArray = array[0].split('_');
	 var index = idArray[1];
	 //After selecting the code validation will call
  //var resultsDiv = document.getElementById('popup-results');
	var resultsDiv ="";
	resultsDiv = document.getElementById('pkgLkupResult');
    resultsDiv.innerHTML = ''; // Clear previous results
    closePkgPopup();
}
function closePopup() {
	 closeAuthPopup();
	document.getElementById('popup').style.display = 'none';
    $("#popup").empty();

}

function closeAuthPopup() {
    document.getElementById('authPopup').style.display = 'none';
    $("#authPopup").empty();
}


function closePkgPopup(){
	  document.getElementById('pkglkup').style.display = 'none';
    $("#pkglkup").empty();
   
}

function associatePkg(){
	closePopup();
	 var episode_type = document.getElementById('episodeType').value;
	 var patient_id = document.getElementById("patientId").value;
	 var encounterId = document.getElementById("encounterId").value;
	 var facility_id = document.getElementById('facility_id').value;
	 var pkgTotalRows=$('#totalPkgRecs').val();
	 
	var pkgCodeStr=$('#pkgCodeStr').val();
	var pkgSeqNoStr=$('#pkgSeqNoStr').val();	
	var pkgAssocFlagStr=$('#pkgAssocFlagStr').val(); 
	var pkgDescStr=$('#pkgDescStr').val(); 
	var existPkgRec=$('#existPkgRec').val();
	var existTotPkgRec=$('#existTotalPkgRecs').val();
	
	 var episodeId = "";
	 var visitId = "";
     if(encounterId != "" && encounterId.length > 8 ){
			episodeId = encounterId.slice(0,8);
			visitId = encounterId.slice(8,encounterId.length);
		}else{
			episodeId = encounterId;
			visitId = 0;
		}
	var params="episodeType="+episode_type+"&patientId="+patient_id+"&episodeId="+episodeId+"&visitId="+visitId+"&facility_id="+facility_id+"&pkgCodeStr="+pkgCodeStr+"&pkgSeqNoStr="+pkgSeqNoStr+"&pkgAssocFlagStr="+pkgAssocFlagStr+"&pkgDescStr="+pkgDescStr+"&existPkgRec="+existPkgRec+"&existTotPkgRec="+existTotPkgRec;

	    document.getElementById('popup').style.display = 'block';
		centerPopup();
	 $.ajax({
	     type: "GET",
	     url: "../../eBL/jsp/PackageEncAssociation.jsp",
	     data: params,
	     success: function(response){
	    	$("#popup").html(response);
	     },
	     error: function(){
	         alert("Error calling PackageEncAssociation JSP file!");
	     }
	 });
}

function addPkgDtls(){
	var i=document.getElementById('pkgTotalRows').value;
	//var i=totalRows;
	var dynamicRow = `
        <div class="row" id="row_`+i+`" "> 
        	<div class="cell">
        		<input class="gridInputs" type="text" id="seqNo_`+i+`" name="seqNo_`+i+`" value="" disabled readonly/>
			</div> 
            <div class="cell" >
            <div width:150px;>
				<input class="gridInputs"  type="text" id="pkgCode_`+i+`" name="pkgCode_`+i+`"  onchange="clearPkgValues(`+i+`);" />
				<button class="gridSerachIcon" type="button" onclick="pkgDtlsLkp(pkgCode_`+i+`,`+i+`)" id="pkgicon`+i+`">
					<span class="mdi mdi-magnify"></span>
				</button>
				</div>
			</div> 
            <div class="cell">
				<input type="text" class="gridInputs"  id="pkgdesc_`+i+`" name="pkgdesc_`+i+`" value="" disabled />
			 </div> 
             <div class="cell"  align="center">
        		<input type="checkbox" class="row-checkbox" id="selectPkg_`+i+`" name="selectPkg_`+i+`" onclick="selectPkg(this,`+i+`)" value="N" />
        	</div>
               </div>`;
		//alert(dynamicRow);
		
		$('#tableDtls').append(dynamicRow);
		++i;
		//alert("i "+i)
		document.getElementById('pkgTotalRows').value=i;
		//alert("tabele "+document.getElementById('pkgTotalRows').value)
		return true;

}

//10883961 -MM00291797
function disableField(epiType){
	if(epiType.value=='R'){
		document.getElementById('encounterId').disabled=true;
		//document.getElementById('encIcon').disabled=true;
	}else{
		document.getElementById('encounterId').disabled=false;
		//document.getElementById('encIcon').disabled=false;
	}
	$('#searchDiv input[type="text"], #searchDiv input[type="hidden"]').val('');
}
function clearRemainingColumnValues(obj,startingColumnIndex){
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
  //alert("In clearRemainingColumnValues");
	
  // Get the starting column
  var startingColumn = $("#tableBody #row_"+index+" .cell").eq(startingColumnIndex);
  
  // Get the remaining columns after the starting column
  var remainingColumns = startingColumn.nextAll();
  // Loop through remaining columns
  if(startingColumnIndex=='2' || startingColumnIndex=='3'){
	  $('#blngGrpDesc').val('');
	  $('#custDesc').val('');
	  $('#policyTypeDesc').val('');
  }else if(startingColumnIndex=='4' || startingColumnIndex=='5'){
	  //$('#blngGrpDesc').val('');
	  $('#custDesc').val('');
	  $('#policyTypeDesc').val('');
  }else if(startingColumnIndex=='6'){
	  $('#policyTypeDesc').val('');
  }
 
  remainingColumns.each(function(index){
    $(this).find("input").each(function(index){
    	console.log($(this).attr('id')+", "+$(this).val());
		if(($(this).attr('id') != ('referralSourceCodeMain_'+index)) && ($(this).attr('id') != ('referralSourceCodeSub_'+index)))
			$(this).val('');
    });
    $(this).find("hidden").each(function(index){
    	console.log($(this).attr('id')+", "+$(this).val());
		if(($(this).attr('id') != ('referralSourceCodeMain_'+index)) && ($(this).attr('id') != ('referralSourceCodeSub_'+index)))
			$(this).val('');
    });
    $(this).find('input[type="date"]').val('');
    	
  });
}
function validatePriority(obj){
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var priblngGrpId = $('#priBlngGrpId').val();
	var blngGrpId = $('#blngGrpId_'+index).val();
	var gridTotRows = $('#totalRowsIns').val();
	if(obj.value == ""){
		//alert("APP-BL9325 Priority cannot be blank");
		let message = getMessage("BL9325", "BL").trim();
		alert(`${message}`);
		return false;
	}
	if(obj.value != ""){
		if(obj.value == 0 || obj.value == "0"){
			//alert("APP-BL9833 Priority cannot be zero");
			let message = getMessage("BL9833", "BL").trim();
			alert(`${message}`);
			obj.value = "";
			return false;
		}
		for(var i=0;i<gridTotRows;i++){
			if(obj.value == $('#priority_'+i).val() && index != i){
				//alert("APP-BL9573 Duplicate Value found for Priority");
				let message = getMessage("BL9573", "BL").trim();
				alert(`${message}`);
				obj.value = "";
				return false;
			}
		}
	}
	if(obj.value == "1"){
		if(priblngGrpId != blngGrpId){
			alert("Priority 1 payer should be there always against the Primary Insurance Billing group only.");
			//let message = getMessage("BL9838", "BL").trim();
			//alert(`${message}`);
			 obj.value = "";
			 return false;
		}
	}
}
function ValidatePolicyNo(obj){
	var row = obj.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index in ValidatePolicyNo:', index);
    }
	
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	if(blngGrpId != ""){
		if(obj.value == '' && (settlement_ind == 'X' && adm_rec_flag == '2')){
			//alert("Policy Number Should Not Be NULL.");BL9104
			let message = getMessage("BL9104", "BL").trim();
			if (document.activeElement == document.body)
				alert(`${message}`);
			return;
		}
	}
}

function validateDate(datePicker) {
    var enteredDate = datePicker.value;
    // Regular expression for yyyy-mm-dd format
    var regex = /^\d{4}-\d{2}-\d{2}$/;
	if(enteredDate != ""){
	    if (!regex.test(enteredDate)) {
	    	console.log("Entered date is not valid: " + enteredDate);
	    	/*let message = getMessage("INVALID_DATE_FMT", "SM").trim();
			alert(`${message}`);*/
	        //datePicker.value = ""; // Clears the input value
	        return false;
	    }else{
	    	console.log("Entered date is valid: " + enteredDate);
	    	return true;
	    } 
	    
	}else{
		console.log("Entered date is blank: " + enteredDate);
	    return true;
	}
}

function creditDocDatesValid(obj){
	if(validateDate(obj)){
		var docStartDate=document.getElementById("docStartDate").value;
		var docEndDate=document.getElementById("docEndDate").value;
		var encounter_date = document.getElementById("visit_regn_date_time").value;
		var currDate = new Date();
		var currentDate = currDate.getFullYear()+'-'+(currDate.getMonth()+1)+'-'+currDate.getDate();
		var episode_Type = document.getElementById("episode_Type").value;
		
		if(docStartDate!='' || docEndDate!=''){
			if(docStartDate!=''){
				/*let year = d.getFullYear();
			let mon = d.getMonth();*/
				if(compareDates(docStartDate,currentDate)){
					let message = getMessage("BL9876", "BL").trim();
					if (document.activeElement == document.body)
						alert(`${message}`);
					document.getElementById("docStartDate").value = "";
					return;
				}
			}
			if(docEndDate!=''){
				if(episode_Type != "R"){					//For External Patient , There is no check with Encounter date in 2T 
					if(compareDates(encounter_date,docEndDate)){
						let message = getMessage("BL9877", "BL").trim();
						if (document.activeElement == document.body)
							alert(`${message}`);
						document.getElementById("docEndDate").value = "";
						return;
					}
				}
			 }
			if(docStartDate!='' && docEndDate!=''){
				 if(compareDates(docStartDate,docEndDate)){
					let message = getMessage("BL9876", "BL").trim();
					if (document.activeElement == document.body)
						alert(`${message}`);
					document.getElementById("docEndDate").value = "";
					return;
				}
		 }
			
		}
		
	
	}else{
		let message = getMessage("INVALID_DATE_FMT", "SM").trim();
		if (document.activeElement == document.body)
			alert(`${message}`);
		obj.value = "";
		return;
	}
}

function compareDates(fromDate,toDate){
	
	if(fromDate != "" && toDate != ""){
		var starr = fromDate.split("-");
		var enarr = toDate.split("-");
		var startdt = new Date();
		var enddt = new Date();
		//alert("starr: "+starr);
		//alert("enarr: "+enarr);
		startdt.setFullYear(starr[0], starr[1]-1, starr[2]);
		enddt.setFullYear(enarr[0], enarr[1]-1, enarr[2]);
		//alert("startdt: "+startdt);
		//alert("enddt: "+enddt);
		var currentDate = new Date();
		if(startdt > enddt)
		{
			return true;
		}
		
	}
	return false;
}

function compareInBetweenDates(fromDate,inDate,toDate){
	
	if(fromDate != "" && toDate != "" && inDate){
		var starr = fromDate.split("-");
		var enarr = toDate.split("-");
		var inarr = inDate.split("-");
		var startdt = new Date();
		var enddt = new Date();
		var indt = new Date();
		//alert("starr: "+starr);
		//alert("enarr: "+enarr);
		startdt.setFullYear(starr[0], starr[1]-1, starr[2]);
		enddt.setFullYear(enarr[0], enarr[1]-1, enarr[2]);
		indt.setFullYear(inarr[0], inarr[1]-1, inarr[2]);
		//alert("startdt: "+startdt);
		//alert("enddt: "+enddt);
		//alert("indt: "+indt);
		var currentDate = new Date();
		
		if((startdt <= indt) && (indt <= enddt))
		{
			return true;
		}
		
	}
	return false;
}

function validatePolicyStartDate(policyStartDate,event){
	//alert(policyStartDate.value);
	//alert(index);
	var row = policyStartDate.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	var encounter_date_trunc = document.getElementById("visit_regn_date_time").value;
	//alert(encounter_date_trunc);
	var policySrtDate = policyStartDate.value;
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var policyTypeCode= document.getElementById("policyTypeCode_"+index).value;
	var policyExpDate = document.getElementById("policyExpiryDate_"+index).value;
	var episode_Type = document.getElementById("episode_Type").value;
	
	if(validateDate(policyStartDate)){
		if(policyExpDate != ""){
			if(compareDates(policySrtDate,policyExpDate)){
				//alert("Policy Start Date should be less than or equal to Policy Expiry Date");
				let message = getMessage("BL8216", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//policyStartDate.value = "";
					return;
				}else 
					validateMessage = validateMessage +`${message} ${row_label}\n`;
				
			}
		}
		//For External Patient , There is no check with Encounter date in 2T 
		if(episode_Type != "R"){
			if(compareDates(policySrtDate,encounter_date_trunc)){
				//alert("Policy Start Date Should be Less than or Equal to the Encounter Date");
				let message = getMessage("BL9880", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//policyStartDate.value = "";
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
			}
		}
	}else{
		let message = getMessage("INVALID_DATE_FMT", "SM").trim();
		if(event == "fieldLevel"){
			if (document.activeElement == document.body)
				alert(`${message}`);
			//policyStartDate.value = "";
			return;
		}else 
			validateMessage = validateMessage + `${message} ${row_label}\n`;
	}
	if(event == "fieldLevel"){
		return;
	}else 
		return validateMessage;
}

function validatePolicyEndDate(policyExpiryDate,event){
	var row = policyExpiryDate.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index:', index);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	var policyExpDate = policyExpiryDate.value;
	var encounter_date_trunc = document.getElementById("visit_regn_date_time").value;
	//alert("encounter_date_trunc: "+encounter_date_trunc);
	//alert("policyExpiryDate.value "+policyExpiryDate.value);
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	var policySrtDate = document.getElementById("policyStartDate_"+index).value;
	var effective_from_date = document.getElementById("effectiveFrom_"+index);
	var effective_to_date = document.getElementById("effectiveTo_"+index);
	var episode_Type = document.getElementById("episode_Type").value;
	
	if(validateDate(policyExpiryDate)){
		if(policySrtDate != ""){
			if(compareDates(policySrtDate,policyExpDate)){
				//alert("Policy Expiry Date should be greater than or equal to Policy Start Date");
				let message = getMessage("BL8217", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//policyExpiryDate.value = "";
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
			}
		}else{
			//alert("Policy Start Date cannot be blank");
			let message = getMessage("BL9324", "BL").trim();
			//policyExpiryDate.value = "";
			if(event == "fieldLevel"){
				if (document.activeElement == document.body)
					alert(`${message}`);
				//policyExpiryDate.value = "";
				return;
			}/*else 
				validateMessage = validateMessage + `${message} ${row_label}\n`;*/
			
		}
		//For External Patient , There is no check with Encounter date in 2T 
		if(episode_Type != "R"){
			if(compareDates(encounter_date_trunc,policyExpDate)){
				//alert("Encounter date should be between Policy Start and End Date");
				let message = getMessage("BL8223", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//policyExpiryDate.value = "";
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
			}
		}
		if(effective_from_date.value != "" && effective_to_date.value != "" && event == "fieldLevel"){
			if(!compareInBetweenDates(effective_from_date.value,effective_to_date.value,policyExpDate)){
				//alert("Policy Effective To Date should be between Policy Effective From and Policy End Date");
				let message = getMessage("BL8221", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//policyExpiryDate.value = "";
					return;
				}else 
					validateMessage = validateMessage +`${message} ${row_label}\n`;
			}
		}
	}else{
		let message = getMessage("INVALID_DATE_FMT", "SM").trim();
		if(event == "fieldLevel"){
			if (document.activeElement == document.body)
				alert(`${message}`);
			//policyExpiryDate.value = "";
			return;
		}else 
			validateMessage =  validateMessage + `${message} ${row_label}\n`;
	
	}
	if(event == "fieldLevel"){
		//return;
	}else 
		return validateMessage;

}
function validateEffectiveFromDate(effectiveFromDate,event){
	var row = effectiveFromDate.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index in validateEffectiveFromDate:', index);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	var effFrmDate = effectiveFromDate.value;
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	var policySrtDate = document.getElementById("policyStartDate_"+index).value;
	var policyExpDate = document.getElementById("policyExpiryDate_"+index).value;
	var encounter_date_trunc = document.getElementById("visit_regn_date_time").value;
	var effective_to_date = document.getElementById("effectiveTo_"+index);
	if(effective_to_date.value == "") effective_to_date.value = policyExpDate;
	
	//alert(encounter_date_trunc);
	if(validateDate(effectiveFromDate)){
		if(policySrtDate != ""  && policyExpDate != ""){
			//if(compareDates(policySrtDate,effFrmDate)){
			if(!compareInBetweenDates(policySrtDate,effFrmDate,policyExpDate)){
				//alert("Policy Effective From Date should be between Policy Start and End Date");
				let message = getMessage("BL8220", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//effectiveFromDate.value = "";
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
			}
		}else{
			if(policySrtDate == ""){
				//alert("Policy Start Date cannot be blank");
				let message = getMessage("BL9324", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//effectiveFromDate.value = "";
					return;
				}/*else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;*/
			}
			if(policyExpDate == ""){
				//alert("Policy End Date cannot be blank");
				let message = getMessage("BL9105", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//effectiveFromDate.value = "";
					return;
				}/*else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;*/
			}
		}
		
	}else{
		let message = getMessage("INVALID_DATE_FMT", "SM").trim();
		if(event == "fieldLevel"){
			if (document.activeElement == document.body)
				alert(`${message}`);
			//effectiveFromDate.value = "";
			return;
		}else 
			validateMessage = validateMessage + `${message} ${row_label}\n`;
	}
	if(event == "fieldLevel"){
		return;
	}else 
		return validateMessage;
}
function validateEffectiveToDate(effectiveToDate,event){
	var row = effectiveToDate.closest('.row');
	var index ;
	if (row) {
        // Get the index of the row within the table
         index = Array.from(row.parentNode.children).indexOf(row);
        console.log('Row index in validateEffectiveToDate:', index);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	var effToDate = effectiveToDate.value;
	var settlement_ind = document.getElementById("settlement_ind_"+index).value;
	var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	var blngGrpId = document.getElementById("blngGrpId_"+index).value;
	var policySrtDate = document.getElementById("policyStartDate_"+index).value;
	var policyExpDate = document.getElementById("policyExpiryDate_"+index).value;
	var effFrmDate = document.getElementById("effectiveFrom_"+index).value;
	var encounter_date_trunc = document.getElementById("visit_regn_date_time").value;
	var episode_Type = document.getElementById("episode_Type").value;
	
	//alert(encounter_date_trunc);
	if(validateDate(effectiveToDate)){
		if(policySrtDate == ""){
			//alert("Policy Start Date cannot be blank");
			let message = getMessage("BL9324", "BL").trim();
			if(event == "fieldLevel"){
				if (document.activeElement == document.body)
					alert(`${message}`);
				//effectiveToDate.value = "";
				return;
			}/*else 
				validateMessage = validateMessage + `${message} ${row_label}\n`;*/
		}
		if(policyExpDate == ""){
			//alert("Policy End Date cannot be blank");
			let message = getMessage("BL9105", "BL").trim();
			if(event == "fieldLevel"){
				if (document.activeElement == document.body)
					alert(`${message}`);
				//effectiveToDate.value = "";
				return;
			}/*else 
				validateMessage = validateMessage + `${message} ${row_label}\n`;*/
		}
		if(effFrmDate != ""){
			if(effFrmDate != "" && effToDate != ""){
				if(!compareInBetweenDates(effFrmDate,effToDate,policyExpDate)){
					//alert("Policy Effective To Date should be between Policy Effective From and Policy End Date");
					let message = getMessage("BL8221", "BL").trim();
					if(event == "fieldLevel"){
						if(document.activeElement == document.body)
							alert(`${message}`);
						//effectiveToDate.value = "";
						return;
					}else 
						validateMessage = validateMessage + `${message} ${row_label}\n`;
				}
			}
			if(compareDates(effFrmDate,effToDate)){
				//alert("Effective To Date should be greater than Effective From Date");
				let message = getMessage("BL6311", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					//effectiveToDate.value = "";
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
			}
		}else{
			//alert("Policy Effective From Date cannot be blank");
			let message = getMessage("BL9565", "BL").trim();
			if(event == "fieldLevel"){
				if(document.activeElement == document.body)
					alert(`${message}`);
				//effectiveToDate.value = "";
				return;
			}/*else 
				validateMessage = validateMessage + `${message} ${row_label}\n`;*/
		}
		if($('#policy_limit_type_'+index).val() == 'R' && $('#approved_days_limit_type_'+index).val() == 'R' && $('#approvedDays_'+index).val() != ''){
			var credit_apprd_days = $('#approvedDays_'+index).val();
			var updatedEffToDate = addDays(effFrmDate , credit_apprd_days);
			if(compareDates(effToDate,updatedEffToDate)){
				let message = getMessage("BL00280", "BL").trim();
				if(event == "fieldLevel"){
					if (document.activeElement == document.body)
						alert(`${message}`);
					return;
				}else 
					validateMessage = validateMessage + `${message} ${row_label}\n`;
				
				effectiveToDate.value = updatedEffToDate;
			}
		}
		//For External Patient , There is no check with Encounter date in 2T 
		if(episode_Type != "R"){
			if(encounter_date_trunc != ""){
				//if(compareDates(effFrmDate,encounter_date_trunc)){
				if(!compareInBetweenDates(effFrmDate,encounter_date_trunc,effectiveToDate.value)){
					//alert("Encounter date should be between Policy Effective From and To Date");
					let message = getMessage("BL8222", "BL").trim();
					if(event == "fieldLevel"){
						if (document.activeElement == document.body)
							alert(`${message}`);
						//effectiveFromDate.value = "";
						return;
					}else 
						validateMessage = validateMessage + `${message} ${row_label}\n`;
				}	
			}
		}
	}else{
		let message = getMessage("INVALID_DATE_FMT", "SM").trim();
		if(event == "fieldLevel"){
			if (document.activeElement == document.body)
				alert(`${message}`);
			//effectiveToDate.value = "";
			return;
		}else 
			validateMessage = validateMessage + `${message} ${row_label}\n`;
	}
	if(event == "fieldLevel"){
		return;
	}else 
		return validateMessage;
}

function policyEffectiveDatesDefaulted(policyExpiryDate){
	var row = policyExpiryDate.closest('.row');
	var index ;
	if (row) {
         index = Array.from(row.parentNode.children).indexOf(row);
    }
	var policyExpDate = policyExpiryDate.value;
	var encounter_date_trunc = document.getElementById("visit_regn_date_time").value;
	//alert("encounter_date_trunc: "+encounter_date_trunc);
	//alert("policyExpiryDate.value "+policyExpiryDate.value);
	var policySrtDate = document.getElementById("policyStartDate_"+index).value;
	var effective_from_date = document.getElementById("effectiveFrom_"+index);
	var effective_to_date = document.getElementById("effectiveTo_"+index);
	
	if(policySrtDate != "" && policyExpDate!=''){
		//alert("assigning effectives dates");
		if(effective_from_date.value == "" ){
			effective_from_date.value = encounter_date_trunc;
		}
		if(document.getElementById("approvedDays_"+index).value != "" && effective_to_date.value == ""){
			//alert("approvedDays_: "+document.getElementById("approvedDays_"+index).value)
			var addedDate = addDays(effective_from_date.value , document.getElementById("approvedDays_"+index).value);
			//alert(addedDate);
			effective_to_date.value = addedDate;
		}else{
			//alert("policyExpDate: "+policyExpDate);
				effective_to_date.value = policyExpDate;
		}
	}
}

function dfltPolicyEffToDate(effectiveFromDate){
	var row = effectiveFromDate.closest('.row');
	var index ;
	if (row) {
         index = Array.from(row.parentNode.children).indexOf(row);
    }
	
	var effFrmDate = effectiveFromDate.value;
	var effectiveToDate = document.getElementById("effectiveTo_"+index);
	var credit_apprd_days = $('#approvedDays_'+index).val();
	if($('#policy_limit_type_'+index).val() == "R" && $('#approved_days_limit_type_'+index).val() == "R")
	{
		if(effFrmDate != "" )
		{
			if(credit_apprd_days != ""){
				var updatedEffToDate = addDays(effFrmDate , credit_apprd_days);
				$("#effectiveTo_"+index).val(updatedEffToDate);
				validateEffectiveToDate(effectiveToDate,"fieldLevel");
			}
			if(effectiveToDate.value != "" && validateDate(effectiveFromDate) && validateDate(effectiveToDate) && compareDates(effectiveToDate.value,effFrmDate)){
				var approvedDays = parseFloat(calculateDays(effFrmDate,effectiveToDate.value));
				$('#approvedDays_'+index).val(approvedDays);
			}
		}
	}
}
function validateEffToApprDays(approvedDays,event){
	var row = approvedDays.closest('.row');
	var index ;
	if (row) {
         index = Array.from(row.parentNode.children).indexOf(row);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	var policy_eff_frm_date = document.getElementById("effectiveFrom_"+index).value;
	var policy_eff_to_date = document.getElementById("effectiveTo_"+index).value;
	var policy_limit_type = $('#policy_limit_type_'+index).val();
	var approved_days_limit_type = $('#approved_days_limit_type_'+index).val();
	var credit_apprd_days = approvedDays.value;
	if(policy_limit_type == "R" && approved_days_limit_type == "R")
	{
		if(policy_eff_frm_date != "" && policy_eff_to_date != "" && credit_apprd_days !="")
		{
			var no_of_days = calculateDays(policy_eff_frm_date,policy_eff_to_date);
			if(credit_apprd_days >  no_of_days)
			{
				let message = getMessage("BL0029", "BL").trim();
				if(event == "fieldLevel"){
					if(document.activeElement == document.body)
						alert(`${message}`);
					//document.getElementById("approvedDays_"+index).value = '';
					return ;
				}else{
					validateMessage = validateMessage + `${message} ${row_label}\n`;
					return validateMessage;
				}
			}
			else
			{
				if(event == "fieldLevel"){
					var updatedEffToDate = addDays(policy_eff_frm_date , credit_apprd_days);
					document.getElementById("effectiveTo_"+index).value = updatedEffToDate;
				}else
					return "";
			}
		}
	}
	if(event == "fieldLevel"){
		return;
	}else 
		return validateMessage;
}

function validateCreditAuthDate(credit_auth_date,event)
{
	var row = credit_auth_date.closest('.row');
	var index ;
	if (row) {
         index = Array.from(row.parentNode.children).indexOf(row);
    }
	var validateMessage = "";
	let row_label = "in Row "+(index+1);
	if(credit_auth_date.value != "")
	{
		if(validateDate(credit_auth_date))
		{
			if(event == "fieldLevel"){
				return;
			}else 
				return validateMessage;
		}
		else
		{
			let message = getMessage("INVALID_DATE_FMT", "SM").trim();
			if(event == "fieldLevel"){
				if(document.activeElement == document.body)
				alert(`${message}`);
				//effectiveToDate.value = "";
				return;
			}else 
				validateMessage = validateMessage + `${message} ${row_label}\n`;
		}
	}
	else
	{
		if(event == "fieldLevel"){
			return;
		}else 
			return validateMessage;
	}
}
function addDays(inputDate,daysToAdd) {
    // Parse the input date into a Date object
    var date = new Date(inputDate);
    
    // parsetoInt the number of days to add
    daysToAdd = parseInt(daysToAdd);
    
    // Add the days
    date.setDate(date.getDate() + daysToAdd);
 
    // Format the result
    var year = date.getFullYear();
    var month = String(date.getMonth() + 1).padStart(2, '0');
    var day = String(date.getDate()).padStart(2, '0');
    var result = year + '-' + month + '-' + day;
    
    return result;
    // Display the result
    //document.getElementById("result").innerText = result;
}
function calculateDays(fromDate,toDate) {
    // Get the input values
    var startDate = new Date(fromDate);
    var endDate = new Date(toDate);

    // Calculate the difference in milliseconds
    var timeDifference = endDate.getTime() - startDate.getTime();

    // Convert milliseconds to days
    var daysDifference = timeDifference / (1000 * 3600 * 24);

    // return the result
    return daysDifference;
}
/*PrimaryRefSrcGrid SecRefSrcGrid PrimaryRefSrc SecRefSRCLkup*/
function  updateRefSrcBlur(calledFrm,obj){
	
	var slmtInd = $('#slmtInd').val();
	 var admRecFlag = $('#admRecFlag').val();
	 var priBlngGrpId = $('#priBlngGrpId').val();
	 if(slmtInd == 'X' && admRecFlag == '2'){
		 var gridTotRows = $('#totalRowsIns').val();
		 //alert(gridTotRows)
		 var row ;
		 if(calledFrm=='PrimaryRefSrcGrid'){
			 row = obj.closest('.row');
				var idx ;
				if (row) {
			        // Get the index of the row within the table
					idx = Array.from(row.parentNode.children).indexOf(row);
			        console.log('Row index:', idx);
			    }
			 for(var i=0;i<=gridTotRows;i++){
				 if($('#blngGrpId_'+i).val()==$('#blngGrpId_'+idx).val()){
					$('#referralSourceCodeMain_'+i).val('');
				}
			 }
			 if(priBlngGrpId!=''){
				 if(priBlngGrpId==$('#blngGrpId_'+idx).val()){
					 	 $('#priRefSrc').val('');
						 $('#priRefSrcCode').val('');
						 for(var i=0;i<=gridTotRows;i++){
							 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
								$('#referralSourceCodeMain_'+i).val('');
							}
						 }
					}
				
				 }
		 }else if(calledFrm=='SecRefSrcGrid'){
			 row = obj.closest('.row');
			 var idx ;
				if (row) {
			        // Get the index of the row within the table
					idx = Array.from(row.parentNode.children).indexOf(row);
			        console.log('Row index:', idx);
			    }
			 for(var i=0;i<=gridTotRows;i++){
				 if($('#blngGrpId_'+idx).val()==$('#blngGrpId_'+i).val()){
					$('#referralSourceCodeSub_'+i).val('');
				}
			 }
			 if(priBlngGrpId!=''){
			   if(priBlngGrpId==$('#blngGrpId_'+idx).val()){
				 	$('#secRefSrc').val('');
					 $('#secRefSrcCode').val('');
					 for(var i=0;i<gridTotRows;i++){
						 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
							$('#referralSourceCodeSub_'+i).val('');
						}
					 }
				}
			 }
		 }else if(calledFrm=='PrimaryRefSrc'){
			 if(priBlngGrpId!=''){
				 for(var i=0;i<gridTotRows;i++){
					 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
						 $('#referralSourceCodeMain_'+i).val('');
					}
				 }
			 }
		 }else if(calledFrm=='SecRefSrc'){
			 if(priBlngGrpId!=''){
				 for(var i=0;i<gridTotRows;i++){
					 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
						 $('#referralSourceCodeSub_'+i).val('');
					 }
			 }
		 }
	 }	

	}
}
//saved pkg data in main.jsp hidden params as on close we are clearing popup values
function savePkgDtls(){  
	var pkgTotalRows=$('#pkgTotalRows').val();
	var prevPkgAsscRows=$('#prevPkgAsscRows').val();
	$('#existTotalPkgRecs').val(prevPkgAsscRows);
	$('#totalPkgRecs').val(pkgTotalRows);
	if(pkgTotalRows=='0'){
		alert("No data available to be saved");
		return false;
	}
	
	var pkgCode="";
	var pkgSeqno="";
	var pkgAssYN="";
	var pkgDesc="";
	var pkgExisYN="";
	$('#pkgCodeStr').val('');
	$('#pkgSeqNoStr').val('');	
	$('#pkgAssocFlagStr').val(''); 
	$('#pkgDescStr').val('');
	$('#existPkgRec').val('');
	var cnt=0;
	for(var i=0;i<pkgTotalRows;i++){
		if($('#pkgCode_'+i).val()!=''){
			pkgCode=pkgCode+$('#pkgCode_'+i).val()+"|";
			
			if($('#pkgdesc_'+i).val()!=''){
				pkgDesc=pkgDesc+$('#pkgdesc_'+i).val()+"|";
			}else{
				pkgDesc=pkgDesc+" "+"|";
			}
			if($('#seqNo_'+i).val()!=''){
				pkgSeqno=pkgSeqno+$('#seqNo_'+i).val()+"|";
			}else{
				pkgSeqno=pkgSeqno+" "+"|";
			}
			if($('#selectPkg_'+i).val()!=''){
				pkgAssYN=pkgAssYN+$('#selectPkg_'+i).val()+"|";
			}else{
				pkgAssYN=pkgAssYN+"N"+"|";
			}
			
			if($('#existPkg'+i).val()=='Y' ){
				pkgExisYN=pkgExisYN+$('#existPkg'+i).val()+"|";
			}else{
				pkgExisYN=pkgExisYN+"N"+"|";
			}
			cnt++;
		}
	}
	$('#totalPkgRecs').val(cnt);
	if(pkgCode==''){
		let message = getMessage("BL0842", "BL").trim();
		alert(`${message}`);
		return false;
	}
//	alert(pkgExisYN)
	$('#pkgCodeStr').val(pkgCode);
	$('#pkgSeqNoStr').val(pkgSeqno);	
	$('#pkgAssocFlagStr').val(pkgAssYN); 
	$('#pkgDescStr').val(pkgDesc);
	$('#existPkgRec').val(pkgExisYN);
	
	closePopup();
}
//pkgcode associate checkbox
function selectPkg(pkgCheck,idx){
	if($('#pkgCode_'+idx).val()!=''){
		if(pkgCheck.checked){
			$('#selectPkg_'+idx).val('Y');
			pkgCheck.checked=true;
		}else{
			$('#selectPkg_'+idx).val('N');
    		pkgCheck.checked=false;
		}
		
		var isValid=pkgBlngClsEligiblity(idx);
		if(isValid == 'true' || isValid == true){
			$('#selectPkg_'+idx).val('Y');
			pkgCheck.checked=true;
    	}else{
    		$('#selectPkg_'+idx).val('N');
    		pkgCheck.checked=false;
    	}
	}
	//alert($('#selectPkg_'+idx).val())
}

function clearPatDtls(patient){
	if(patient.value==''){
		$('#patientId').val('');
		$('#patient_Name').val('');
		$('#encounter_Id').val('');
	}
}

function reloadWithSessionUpdate(){
	var param = "";
	$.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=reloadWithSessionUpdate",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
				 var data1 = JSON.parse($.trim(response));
				 if(data1.Success == "Y")
					location.reload();
	         },
	         error: function(){
	             alert("Error while getting EpisodeIdVisitId!");
	         }
		 });
	
}

function selectRecs(obj){
	document.getElementById('storeVal').value=obj.value;
}

function validateReqSelected(){
	var param = $('#queryStrng').val();
	param+="&storeVal="+document.getElementById('storeVal').value+"&login_user="+$('#login_user').val();
	var pkgIdx=$('#pkgIdx').val();
	if(document.getElementById('storeVal').value!=''){
		$.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=ValidateRequest",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
				 var data1 = JSON.parse($.trim(response));
				 if(data1.error != "" && data1.error != "undefined" && data1.error != undefined){
					// alert(data1.error)
					 let message ;
					if(getMessage(data1.error, "BL").trim()!=''){
						message=getMessage(data1.error, "BL").trim();
					}else if(getMessage(data1.error, "BLEXT").trim()!=''){
						message=getMessage(data1.error, "BLEXT").trim();
					}else{
						message=data1.error;
					}
					 closeAuthPopup();
					alert(`${message}`);
					document.getElementById("pkgCode_"+pkgIdx).value="";
				   document.getElementById("seqNo_"+pkgIdx).value="";
				   document.getElementById("pkgdesc_"+pkgIdx).value="";
		    	   document.getElementById("selectPkg_"+pkgIdx).checked=false;
				   document.getElementById("selectPkg_"+pkgIdx).value="N";
				   return false;
				 }else{
					 document.getElementById("selectPkg_"+pkgIdx).checked=true;
					  document.getElementById("selectPkg_"+pkgIdx).value="Y";
					 closeAuthPopup();
				 }
	         },
	         error: function(){
	             alert("Error while getting ValidateRequest!");
	         }
		 });
	}else{
		 document.getElementById("selectPkg_"+pkgIdx).checked=true;
		  document.getElementById("selectPkg_"+pkgIdx).value="Y";
		 closeAuthPopup();
	}	
}
/*
function validateApprovaldtls(){
	 var policy_limit_type = $(this).find('#policy_limit_type_'+index).val();
	 var approved_days_limit_type = $(this).find('#approved_days_limit_type_'+index).val();
	 var approvedAmt = $(this).find('#approvedAmt_'+index).val();
	 var approved_amt_limit_type = $(this).find('#approved_amt_limit_type_'+index).val();
	 var approvedDays = $(this).find('#approvedDays_'+index).val();
	 var effectiveFrom =  $(this).find('#effectiveFrom_'+index).val()
	var effectiveTo =  $(this).find('#effectiveTo_'+index).val()
	var episodeType =  document.getElementById("episodeType").value;
	 var param="policy_limit_type="+policy_limit_type+"&approved_days_limit_type="+approved_days_limit_type+"&approved_amt_limit_type="+approved_amt_limit_type+"&episodeType="+episodeType
	 $.ajax({
         type: "GET",
         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=ValidateRequest",
         data: param,
         dataType:"text",
         async:false,
         success: function(response){
			 var data1 = JSON.parse($.trim(response));
			 if(data1.error != "" && data1.error != "undefined" && data1.error != undefined){
			 }
				
         },
         error: function(){
             alert("Error while getting ValidateRequest!");
         }
	 });
}*/

function CheckForAmtInput(event,appAmt) {
	var strCheck = '1234567890.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
   
}
