function search() {
	//alert("In Search Lov");
    var search_text = document.getElementById('searchText').value;
    var search_criteria = document.getElementById('searchCriteria').value;
    //var searchBy = document.getElementById('searchBy').value;
    var searchMainScreenVal =  document.getElementById("searchMainScreenVal").value;
	var strWhereColumnType =  document.getElementById("strWhereColumnType").value;
	var strWhereColumn =  document.getElementById("strWhereColumn").value;
	var called_for = document.getElementById("called_for").value;
	var paramForQuery = decodeURI(document.getElementById("paramForQuery").value);
	var searchFieldID=document.getElementById("searchFieldID").value;
	var searchBy = document.getElementById('searchBy').value;
	var facility_id = document.getElementById('facility_id').value;
	if(facility_id=="" ||facility_id==null){
		facility_id="";
	}
	var locale = document.getElementById('locale').value;
	
	 if(called_for=="PAT_ID_LKUP"){
		 if(search_text==''){
			 let message = getMessage("SEARCH_TEXT_BLANK", "common").trim();
				alert(`${message}`);
				return false;
			 //{"SEARCH_TEXT_BLANK","APP-000073 Search Text cannot be blank..."}
		 }
	 }
	//alert(searchBy) 
	//alert(strWhereColumn)
	/*if(called_for=="PAT_ID_LKUP"){
		var searchBy = document.getElementById('searchBy').value;
	}else{
		var searchBy = document.querySelector("input[name=searchBy]:checked").value;
	}*/
	
	//setting the where column according to user choice
	var array = strWhereColumn.split(',');
	if(searchBy == "code")
		strWhereColumn = array[0];
	else if(searchBy == "desc")
		strWhereColumn = array[1];
	//alert(strWhereColumn)
   /* //check if search text is blank then assign search value of parent screen
	if(search_text != "")
	  search_text = search_text;
	else if(searchMainScreenVal != "")
		search_text = searchMainScreenVal;
	*/
    $.ajax({
		type:"GET",
		url:"../../eBL/jsp/BLCommonLookupAjax.jsp?search_text=" + encodeURIComponent(search_text),
		data:"called_for="+called_for+
			"&search_text="+search_text+
			"&search_criteria="+search_criteria+
			"&strWhereColumnType="+strWhereColumnType+
			"&strWhereColumn="+strWhereColumn+
			"&searchBy="+searchBy+
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
				displaySearchResults(searchData);
			}else{
				//alert("No Data Found");
				let message = getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "common").trim();
				alert(`${message}`);
				
				var array = searchFieldID.split(',');
				 if(array.length >1){
					 document.getElementById(array[0]).value = '';
					 document.getElementById(array[1]).value = '';
				 }//to clear field values 
				return false;
			}
		},
		error: function(data){
				alert(data);
				return false;
		}
	});
    
}

function displaySearchResults(searchData) {
	var called_for = document.getElementById("called_for").value;
	//alert(called_for)
	var resultsDiv ="";
	 if(called_for=="PKG_DTLS_LKUP"){
		 resultsDiv = document.getElementById('pkgLkupResult');
	 }else{
		 resultsDiv =document.getElementById('popup-results');
	 }
	//pkgLkupResult
    
   resultsDiv.innerHTML = ''; // Clear previous results
    // Create header row
   var columnDescription = decodeURI(document.getElementById('column_descriptions').value);
  // alert(document.getElementById('column_descriptions').value)
   var array = columnDescription.split(',');
   var headerRow = document.createElement('div');
   headerRow.classList.add('result-row', 'header-row');
   //alert(array[1]);
   var headerDiv = '';
 //  alert(array.length)
   for(var i = 0;i<array.length;i++){
	   headerDiv = headerDiv + '<div class="result-cell">'+array[i]+'</div>';
   }
   // headerRow.innerHTML = '<div class="result-cell">Code</div><div class="result-cell">Description</div>';
   headerRow.innerHTML = headerDiv;
   resultsDiv.appendChild(headerRow);
   var data="";
    // Create table-like rows for search results
    searchData.forEach(function(item) {
        var row = document.createElement('div');
        row.classList.add('result-row');
        var rowColumnsData = '';
       // alert(item);
        console.log(item);
       
       // alert(called_for)
        if(called_for=="PKG_DTLS_LKUP"){
        	if(item.seqno != "null"){
        		rowColumnsData = rowColumnsData + '<div class="result-cell">'+item.seqno+'</div>';
        		//data=item.seqno;
        	}
		}
        if(item.code != "null"){
        	rowColumnsData = rowColumnsData + '<div class="result-cell">'+item.code+'</div>';
        }
        if(item.description != "null"){
        	rowColumnsData = rowColumnsData + '<div class="result-cell">'+item.description+'</div>';
        }
       
        row.innerHTML = rowColumnsData;
        row.addEventListener('click', function() {
        	 if(called_for=="PKG_DTLS_LKUP"){
        		// alert(item.seqno)
        		   selectResult(item.code, item.description,item.seqno);
        	 }else{
        		   selectResult(item.code, item.description,'');
        	 }
         
        });
        resultsDiv.appendChild(row);
    });
	resultsDiv.style.display = 'block';
    if(searchData.length == "1"){
    	 if(called_for=="PKG_DTLS_LKUP"){
    			selectResult(searchData[0].code, searchData[0].description,searchData[0].seqno);
    	}else{
    			selectResult(searchData[0].code, searchData[0].description,'');
    	 }
     }
}

function selectResult(code, description,data) {
	var selectedVal = "";
	//alert("code: "+code+", description: "+description);
	if(code != "null" && description != "null"){
		selectedVal = code + ' - ' + description;
	}else if(code != "null"){
		selectedVal = code;
	}else if(description != "null"){
		selectedVal = description;
	}
	var called_for = document.getElementById("called_for").value;
	var searchFieldID = document.getElementById("searchFieldID").value;
	//alert(searchFieldID);
	 var array = searchFieldID.split(',');
	 if(array.length >1){
		 document.getElementById(array[0]).value = code;
		 document.getElementById(array[1]).value = description;
		 if(called_for=="PKG_DTLS_LKUP"){
			// alert(data)
			 if(data!="")
				 document.getElementById(array[2]).value = data;
			}
	 }else{
		 if(called_for == "ENC_ID_LKUP")
			 document.getElementById(array[0]).value = selectedVal;
		 else
			 document.getElementById(array[0]).value = code;
	 }
	 //getting the index value by splitting the searchFieldID
	 var idArray = array[0].split('_');
	 var index = idArray[1];
	 //After selecting the code validation will call
  if(called_for == "PRI_BLNG_GRP_ID"){
  		 //getting the index value by splitting the searchFieldID
	  	validatePriBillingGrpId(code);
  	 }
  if(called_for == "NON_INS_BLNG_GRP_ID"){ 
		 //getting the index value by splitting the searchFieldID
		validatePriBillingGrpId(code);
	 }
	 if(called_for == "BILLING_CATG_LOOKUP"){
		 clearRemainingColumnValues(document.getElementById("blngGrpCatg_"+index),'2');
	 }
	 if(called_for == "INS_BLNG_GRP_ID"){
		 validatingBillingGrpId(index,code);
	 }
	 if(called_for == "CUST_GRP_CODE"){
		 clearRemainingColumnValues(document.getElementById("custGroupCode_"+index),'4');
	 }
	 if(called_for == "CUST_CODE"){
		 clearRemainingColumnValues(document.getElementById("custCode_"+index),'5');
		 var validate = validateCustCode(code,document.getElementById("custCode_"+index));
	 }
	 if(called_for == "POLICY_TYPE_CODE"){
		 clearRemainingColumnValues(document.getElementById("policyTypeCode_"+index),'6');
		 validatePolicyTypeCode(index,code);
	 }
	
	 if(called_for == "ENC_ID_LKUP"){
		 getPatientDetail(description);
	 }
	 //alert(called_for)
	 var slmtInd = $('#slmtInd').val();
	 var admRecFlag = $('#admRecFlag').val();
	 //alert(slmtInd)
	 //alert(admRecFlag)
	 if(slmtInd == 'X' && admRecFlag == '2'){
		 if(called_for == "Primary_Ref_Source_LOV"){
			 updateRefSrc("PrimaryRefSrcGrid",code,description,index);
		 }else if(called_for == "Sec_Ref_Source_LOV"){
			 updateRefSrc("SecRefSrcGrid",code,description,index);
		 }else if(called_for == "PrimaryRefSRCLkup"){
			// alert("inside PrimaryRefSRCLkup")
			 updateRefSrc("PrimaryRefSrc",code,description,0);
		 }else if(called_for == "SecRefSRCLkup"){
			 updateRefSrc("SecRefSrc",code,description,0);
		 }
	 }
	/* 
	 * 
	 * SecRefSRCLkup
	 PrimaryRefSRCLkup*/
	 if(called_for=="PAT_ID_LKUP"){
//alert("getEpisodeIdVisitId")
		var facility_id= document.getElementById("facility_id").value; 
		var patientId= document.getElementById("patient_Id").value; 
		var episodeType= document.getElementById("episode_Type").value;
		var loginUser = document.getElementById("login_user").value; 		
	//	callPatValidation(patientId);
		 var param="facility_id="+facility_id+"&episodeType="+episodeType+"&patientId="+patientId;
		
		 $.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=getEpisodeIdVisitId",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
	        		 var data1 = JSON.parse($.trim(response));
	        		 if(data1.encID!="" && data1.encID!="undefined" &&data1.encID!=undefined){
	        			 document.getElementById("encounter_Id").value=data1.encID;
						 
						  checkForCurrIPMessage(episodeType, patientId, facility_id, data1.encID, loginUser);
						 
		        	 }else if( data1.p_sys_message_id!="" ){
						 let message = getMessage(data1.p_sys_message_id, "BL").trim();
						alert(`${message}`);
		        	 }else if( $.trim(data1.p_error_text)!=""){
		        		 alert(data1.p_error_text);
		        	 }
	         },
	         error: function(){
	             alert("Error including JSP file!");
	         }
		 });
	 }
	//var resultsDiv = document.getElementById('popup-results');
	var resultsDiv ="";
	 if(called_for=="PKG_DTLS_LKUP"){
		 resultsDiv = document.getElementById('pkgLkupResult');
	 }else{
		 resultsDiv =document.getElementById('popup-results');
	 }
    resultsDiv.innerHTML = ''; // Clear previous results
    if(called_for=="PKG_DTLS_LKUP"){
    	closePkgPopup();
		}else{
			closePopup();
		} 
}


function validatingBillingGrpId(index,blngGrpId){
	//alert("In validatingBillingGrpId");
	var paramForQuery = decodeURI(document.getElementById("paramForQuery").value);
	var facility_id = document.getElementById('facility_id').value;
	var called_for = "validate_billing_grp_id";
	 $.ajax({
         type: "GET",
         url: "../../eBL/jsp/BLCommonLookupAjax.jsp?",
         data:"called_for="+called_for+
			"&blngGrpId="+blngGrpId+
			"&"+paramForQuery+
			"&facility_id="+facility_id+
			"&locale=en",
		 dataType:"text",
		 async:false,
         success: function(response){
        	 var data = $.trim(response);
        	 var array = data.split('~');
        	 
        	 if(array[9].trim() != ""){
				 alert(array[9]);
				 return;
        	}else if(array[7] != "" && array[7] != "0"){
        		let message = getMessage(array[7], "BL").trim();
        		alert(`${message}`);
        		alert(array[7]); 
        		 return;
        	 }else{
        		 //if Billing group Id changed then clear the remaining Column values
        		clearRemainingColumnValues(document.getElementById("blngGrpId_"+index),'3');
	    		document.getElementById("settlement_ind_"+index).value = array[0].trim();
	    		document.getElementById("adm_rec_flag_"+index).value = array[1].trim();
	    		document.getElementById("ref_source_main_mand_yn_"+index).value = array[2].trim();
	    		document.getElementById("ref_source_sub_mand_yn_"+index).value = array[3].trim();
	    		document.getElementById("package_yn_"+index).value = array[4].trim();
	    		document.getElementById("capture_ref_source_dtl_yn_"+index).value = array[5].trim();
	    		//document.getElementById("visit_regn_date_time").value = array[6].trim();
	    		//based on the capture_ref_source_dtl_yn value disable /Enable Primary & Secondary REf source
	    		if(array[5].trim() == "Y"){
	        		$('#primaryRefSourceLov_'+index).attr('onclick', 'primaryRefSourceLookup(referralSourceCodeMain_'+index+','+index+')');
	        		$('#SecRefSourceLov_'+index).attr('onclick', 'SecRefSourceLookup(referralSourceCodeSub_'+index+','+index+')');
	        		$('#referralSourceCodeMain_'+index).attr('disabled', 'disabled');
	        		$('#referralSourceCodeSub_'+index).attr('disabled', 'disabled');
	        		$('#referralSourceCodeMain_'+index).val('');
	        		$('#referralSourceCodeSub_'+index).val('');
	    		}else{
	    			$('#primaryRefSourceLov_'+index).removeAttr('onclick');
	        		$('#SecRefSourceLov_'+index).removeAttr('onclick');
	    			$('#referralSourceCodeMain_'+index).removeAttr("disabled");
	    			$('#referralSourceCodeSub_'+index).removeAttr("disabled");
	    		}
	    		//alert("settlement_ind: "+array[0].trim());
	    		var priBlngGrp = document.getElementById("settlement_ind_"+index).value;
	    		var adm_rec_flag = document.getElementById("adm_rec_flag_"+index).value;
	    		var priority = document.getElementById("priority_"+index).value;
	    		//primary billing group is Cash or Credit (except Insurance), the non insurance section should be cleared and made disabled. Only if primary Billing group is Insurance, non-ins section should be enabled for entry
	    		if(priBlngGrp == 'C'){
	        		$('#nonInsBlngGrp').attr('disabled', 'disabled');
	        		$('#nonInsBlngGrpBttn').attr('disabled', 'disabled');
	        		$('#dcmntRef').attr('disabled', 'disabled');
	        		$('#docStartDate').attr('disabled', 'disabled');
	        		$('#docEndDate').attr('disabled', 'disabled');
	        		
	        		$('#nonInsBlngGrp').val('');
	        		$('#dcmntRef').val('');
	        		$('#docStartDate').val('');
	        		$('#docEndDate').val('');
	    		}else if(priority == "1" && priBlngGrp == 'X' && adm_rec_flag == "2"){
	    			$('#nonInsBlngGrp').removeAttr("disabled");
	        		$('#nonInsBlngGrpBttn').removeAttr("disabled");
	        		$('#dcmntRef').removeAttr("disabled");
	        		$('#docStartDate').removeAttr("disabled");
	        		$('#docEndDate').removeAttr("disabled");
	        		
	    		}
	    		if(priBlngGrp == 'R'){
	    			$('#policyTypeCode_'+index).attr('disabled', 'disabled');
	        		$('#policyTypeCodeLov_'+index).attr('disabled', 'disabled');
	        		$('#policyNumber_'+index).attr('disabled', 'disabled');
	        		$('#policyStartDate_'+index).attr('disabled', 'disabled');
	        		$('#policyExpiryDate_'+index).attr('disabled', 'disabled');
	        		$('#effectiveFrom_'+index).attr('disabled', 'disabled');
	        		$('#effectiveTo_'+index).attr('disabled', 'disabled');
	        		$('#approvedAmt_'+index).attr('disabled', 'disabled');
	        		$('#approvedDays_'+index).attr('disabled', 'disabled');
	        		$('#priority_'+index).attr('disabled', 'disabled');
	        		
	    			$('#nonInsBlngGrp').attr('disabled', 'disabled');
	        		$('#nonInsBlngGrpBttn').attr('disabled', 'disabled');
	        		$('#dcmntRef').attr('disabled', 'disabled');
	        		$('#docStartDate').attr('disabled', 'disabled');
	        		$('#docEndDate').attr('disabled', 'disabled');
	        		
	        		
	        		$('#policyTypeCode_'+index).val('');
	        		$('#policyNumber_'+index).val('');
	        		$('#policyStartDate_'+index).val('');
	        		$('#policyExpiryDate_'+index).val('');
	        		$('#effectiveFrom_'+index).val('');
	        		$('#effectiveTo_'+index).val('');
	        		$('#approvedAmt_'+index).val('');
	        		$('#approvedDays_'+index).val('');
	        		$('#priority_'+index).val('');
	        		
	        		$('#nonInsBlngGrp').val('');
	        		$('#dcmntRef').val('');
	        		$('#docStartDate').val('');
	        		$('#docEndDate').val('');
	    		}else{
	    			$('#policyTypeCode_'+index).removeAttr("disabled");
	    			$('#policyTypeCodeLov_'+index).removeAttr("disabled");
	    			$('#policyNumber_'+index).removeAttr("disabled");
	    			$('#policyStartDate_'+index).removeAttr("disabled");
	    			$('#policyExpiryDate_'+index).removeAttr("disabled");
	    			$('#effectiveFrom_'+index).removeAttr("disabled");
	    			$('#effectiveTo_'+index).removeAttr("disabled");
	    			$('#approvedAmt_'+index).removeAttr("disabled");
	    			$('#approvedDays_'+index).removeAttr("disabled");
	    			$('#priority_'+index).removeAttr("disabled");
	    			
	        		$('#nonInsBlngGrp').removeAttr("disabled");
	        		$('#nonInsBlngGrpBttn').removeAttr("disabled");
	        		$('#dcmntRef').removeAttr("disabled");
	        		$('#docStartDate').removeAttr("disabled");
	        		$('#docEndDate').removeAttr("disabled");
	    		}
        	}
         },
         error: function(error){
             alert(error);
         }
	 });
}


function validatePriBillingGrpId(blngGrpId){
	//alert("In validatePriBillingGrpId");
	var paramForQuery = decodeURI(document.getElementById("paramForQuery").value);
	var locale = document.getElementById('locale').value;
	var called_from = document.getElementById("called_for").value;
	var called_for;
	var flag = false;
	if(called_from=="PRI_BLNG_GRP_ID"){ //PRI_BLNG_GRP_ID NON_INS_BLNG_GRP_ID
		called_for = "BlngGrpIdValidation";
	}else{
		called_for = "NIBlngGrpIdValidation";
		flag = true;
	}
	
	var facility_id = document.getElementById('facility_id').value;
	if(facility_id=="" ||facility_id==null){
		facility_id="GH";
	}
	//validate Primary Billing Group ID
	if(called_from == "PRI_BLNG_GRP_ID"){
		 $.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLCommonLookupAjax.jsp?",
	         data:"called_for=validate_PRI_BLNG_GRP_ID"+
				"&blngGrpId="+blngGrpId+
				"&"+paramForQuery+
				"&facility_id="+facility_id+
				"&locale="+locale,
			 dataType:"text",
			 async:false,
	         success: function(response){
	        	 var data = $.trim(response);
	        	 var array = data.split('~');
	        	 //alert(array);
	        	 if(array[1].trim() != ""){
					 alert(array[1].trim());
					 flag = false;
					 $('#priBlngGrpId').val('');
					 $('#priBlngGrpDesc').val('');
					 return;
	        	}else if(array[0].trim() != "" && array[0].trim() != "0"){
	        		let message = getMessage(array[0].trim(), "BL").trim();
	        		if(message == null || message == undefined || message == "" ){
		    			message = getMessage(array[0].trim(), "BLEXT").trim();
		    		}
	        		alert(`${message}`);
	        		flag = false;
	        		$('#priBlngGrpId').val('');
					$('#priBlngGrpDesc').val('');
	        		return;
	        	 }else if(array[2].trim() != "" && array[2].trim() != "0"){
	        		let message = getMessage(array[2].trim(), "BL").trim();
	        		if(message == null || message == undefined || message == "" || message == "undefined"){
		    			message = getMessage(array[2].trim(), "BLEXT").trim();
		    		}
	        		alert(`${message}`);
	        		flag = true;
	        	 }else{
	        		 flag = true;
	        	 }
	         },
	         error: function(error){
	             alert(error);
	         }
		 });
	}
	if(flag){
		//alert("In flag true");
	 $.ajax({
         type: "GET",
         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?",
         data:"called_for="+called_for+
			"&blngGrpId="+blngGrpId+
			"&"+paramForQuery+
			"&facility_id="+facility_id+
			"&blngGrpId="+blngGrpId+
			"&locale=en",
		 dataType:"text",
		 async:false,
         success: function(data){
        	 var data1 = JSON.parse($.trim(data));
			 console.log(data1);
        	 if(called_from=="PRI_BLNG_GRP_ID"){
             	 if(data1.settlement_ind == "C" || data1.settlement_ind == "R" || (data1.settlement_ind=="X" && data1.adm_rec_flag == "1")){
            		$('#tableBody').empty();
            		$('#payerDtls').find('input').val('');
            		$('#payerDtls').find('input').attr('disabled',true);
    	    		$('#payerDtls').find('searchIcon').attr('disabled',true);
					$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
					$('#nonInsDtls').find('input, button').attr('disabled',true);
    	    		$('#nonInsRefIcn').attr('disabled', 'disabled');
	        		$('#nonInsSecRefIcn').attr('disabled', 'disabled');
					$('#custGrpId').val('');
					$('#custGrp').val('');
					$('#customer').val('');
					$('#customerId').val('');
						        		
    	    		/*//$('#nonInsDtls').find('searchIcon').attr('disabled',true);
    	    		$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').val('');
    	    		$('#nonInsDtls input[type="text"], #nonInsDtls input[type="hidden"]').attr('disabled',true);
    	    		*/
    	    		$('#remove-selected-rows').attr('disabled', 'disabled');
    	    		$('#addRw').attr('disabled', 'disabled');
    	    		
    	    		$('#blngGrpDesc').val('');
    	    		$('#custDesc').val('');
    	    	    $('#policyTypeDesc').val('');
     	    		$('#blngGrpDesc').attr('disabled', 'disabled');
    	    		$('#custDesc').attr('disabled', 'disabled');
    	    		$('#policyTypeDesc').attr('disabled', 'disabled');
    	    		
    	    		if(data1.capture_ref_source_dtl_yn == "Y"){
    	    			/*$('#priRefSrcIcon').attr('onclick', 'PrimaryRefSrcLkp(priRefSrc)');
    	        		$('#secRefSrcIcon').attr('onclick', 'SecRefSourceLookup(secRefSrc)');
    	        	*/	//alert("281")
    	        		$('#priRefSrcIcon').removeAttr("disabled"); 
    	    			$('#secRefSrcIcon').removeAttr("disabled");
    	        		$('#priRefSrc').removeAttr("disabled"); 
    	    			$('#secRefSrc').removeAttr("disabled");
    	    			$('#priRefSrcCode').removeAttr("disabled");
                		$('#secRefSrcCode').removeAttr("disabled");
                		/*priBlngGrpCat priBlngGrpId priRefSrcCode secRefSrcCode custGrpId customerId
						nonInsBlngGrpId nonInsRefSrcId nonInsScRefSrcId NonInsCustGrpId NonInsCustId
					
    	    			*///alert("286")
    	        	}else{
    	        		/*$('#priRefSrcIcon').removeAttr('onclick');
    	        		$('#secRefSrcIcon').removeAttr('onclick');
    	        		*/
    	        		$('#priRefSrc').val('');
    	        		$('#secRefSrc').val('');
    	        		$('#priRefSrcCode').val('');
    	        		$('#secRefSrcCode').val('');
    	        		$('#priRefSrcIcon').attr('disabled', 'disabled');
    	        		$('#secRefSrcIcon').attr('disabled', 'disabled');
    	        		$('#priRefSrc').attr('disabled', 'disabled');
    	        		$('#secRefSrc').attr('disabled', 'disabled');
    	        		$('#priRefSrcCode').attr('disabled', 'disabled');
                		$('#secRefSrcCode').attr('disabled', 'disabled');
    	        	}
    	    		//alert(data1.settlement_ind)
    	    		if(data1.settlement_ind == "R" || (data1.settlement_ind=="X" && data1.adm_rec_flag == "1")){
    	    			$('#custGrp').removeAttr("disabled"); 
    	    			$('#custGrpId').removeAttr("disabled"); 
    	    			$('#cusGrpIcn').removeAttr("disabled");
    	        		$('#customer').removeAttr("disabled"); 
    	    			$('#customerId').removeAttr("disabled"); 
    	    			$('#customerIcn').removeAttr("disabled");  
    	    		}else{
    	    			$('#custGrp').attr('disabled', 'disabled');
    	    			$('#custGrpId').attr('disabled', 'disabled');
    	    			$('#cusGrpIcn').attr('disabled', 'disabled');
    	        		$('#customer').attr('disabled', 'disabled');
    	    			$('#customerId').attr('disabled', 'disabled');
    	    			$('#customerIcn').attr('disabled', 'disabled');
    	    		}
            	 }else{
            		// alert($('#nonInsBlngGrp').val())
            		 //alert(data1.nonInsBlngId)
            		
					$('#nonInsBlngGrpId').removeAttr("disabled");
            		$('#nonInsBlngGrp').removeAttr("disabled");
         			$('#nonInsBlngGrpBttn').removeAttr("disabled");
         			$('#remove-selected-rows').removeAttr("disabled");
    	    		$('#addRw').removeAttr("disabled");
    	    		/*$('#NonInsCustGrp').removeAttr("disabled");
    				$('#nonInscusGrp').removeAttr("disabled");
    				$('#nonInscusIcn').removeAttr("disabled");
    				$('#NonInsCust').removeAttr("disabled");
         			*/ //customer details
    	    	//	alert(data1.capture_ref_source_dtl_yn)
					$('#custGrpId').val('');
    	    		$('#custGrp').val('');
    	    	    $('#customerId').val('');
					$('#customer').val('');
     	    		$('#custGrpId').attr('disabled', 'disabled');
    	    		$('#custGrp').attr('disabled', 'disabled');
    	    		$('#customerId').attr('disabled', 'disabled');
					$('#customer').attr('customer', 'customer');
					$('#cusGrpIcn').attr('disabled', 'disabled');
    	    		$('#customerIcn').attr('disabled', 'disabled');
					
    	    		$('#blngGrpDesc').attr('disabled', 'disabled');
    	    		$('#custDesc').attr('disabled', 'disabled');
    	    		$('#policyTypeDesc').attr('disabled', 'disabled');
    	    		if(data1.capture_ref_source_dtl_yn=="Y"){
    	    			$('#priRefSrcIcon').removeAttr("disabled"); 
    	    			$('#secRefSrcIcon').removeAttr("disabled");
    	        		$('#priRefSrc').removeAttr("disabled"); 
    	    			$('#secRefSrc').removeAttr("disabled");
    	    			$('#priRefSrcCode').removeAttr("disabled");
                		$('#secRefSrcCode').removeAttr("disabled");
    	     			$('#nonInsRefIcn').removeAttr("disabled");
    	     			$('#nonInsScRefSrc').removeAttr("disabled");
    	     			$('#nonInsSecRefIcn').removeAttr("disabled");
    	     			$('#nonInsRefSrc').removeAttr("disabled");
    	     			$('#nonInsRefSrcId').removeAttr("disabled");
    	     			$('#nonInsScRefSrcId').removeAttr("disabled");
    	     		/*	$('#noinsref').attr('onclick', 'PrimaryRefSrcLkp(priRefSrc)');
    	        		$('#noinsSecref').attr('onclick', 'SecRefSourceLookup(secRefSrc)');
    	        	*/}else{
    	        		$('#nonInsRefSrc').val('');
    	        		$('#nonInsRefSrcId').val('');
    	        		$('#nonInsScRefSrc').val('');
    	        		$('#nonInsScRefSrcId').val('');
    	        		
    	        		$('#nonInsRefSrc').attr('disabled', 'disabled');
    	        		$('#nonInsRefIcn').attr('disabled', 'disabled');
    	        		$('#nonInsRefSrcId').attr('disabled', 'disabled');
            			$('#nonInsScRefSrcId').attr('disabled', 'disabled');
            			$('#nonInsScRefSrc').attr('disabled', 'disabled');
            			$('#nonInsSecRefIcn').attr('disabled', 'disabled');
            			$('#priRefSrcIcon').attr('disabled', 'disabled');
    	        		$('#secRefSrcIcon').attr('disabled', 'disabled');
    	        		$('#priRefSrc').attr('disabled', 'disabled');
    	        		$('#secRefSrc').attr('disabled', 'disabled');
    	        		$('#priRefSrcCode').attr('disabled', 'disabled');
                		$('#secRefSrcCode').attr('disabled', 'disabled');
            			/*$('#noinsref').removeAttr('onclick');
    	        		$('#noinsSecref').removeAttr('onclick');*/
         			}
					
    	    		if(data1.nonInsBlngId!="" && data1.settlement_ind=="X"){
              			$('#nonInsBlngGrpId').val(data1.nonInsBlngId);
              			$('#nonInsBlngGrp').val(data1.NIBlngGrpdesc);
              			 $('#nonInsSlmtInd').val(data1.nisettlement_ind);
                     	 $('#nonInsAdmRecFlag').val(data1.niadm_rec_flag);
                     	 $('#nonInsCapRefSrcYN').val(data1.nicapture_ref_source_dtl_yn);
                     	 $('#nonInsPrimaryRefSrcMandYN').val(data1.niref_source_main_mand_yn);
                     	 $('#nonInsSecRefSrcMandYN').val(data1.niref_source_sub_mand_yn);
                     	 $('#nonInsCreditAuthRefReqd').val(data1.nicredit_doc_ref_reqd_yn);
						 
                     	if(data1.nisettlement_ind=="R"){ 
                     		$('#NonInsCustGrp').removeAttr("disabled"); 
        	    			$('#NonInsCustGrpId').removeAttr("disabled"); 
        	    			$('#nonInsCusGrpIcn').removeAttr("disabled");
        	        		$('#NonInsCust').removeAttr("disabled"); 
        	    			$('#NonInsCustId').removeAttr("disabled"); 
        	    			$('#nonInsCusIcn').removeAttr("disabled"); 
        	    		}else{
        	    			$('#NonInsCustGrp').attr('disabled', 'disabled');
        	    			$('#NonInsCustGrpId').attr('disabled', 'disabled');
        	    			$('#nonInsCusGrpIcn').attr('disabled', 'disabled');
        	        		$('#NonInsCust').attr('disabled', 'disabled');
        	    			$('#NonInsCustId').attr('disabled', 'disabled');
        	    			$('#nonInsCusIcn').attr('disabled', 'disabled');
        	    		}
                   }
    	    		if(data1.nonInsBlngId=="" && data1.settlement_ind=="X"){
    	    			$('#NonInsCustGrp').attr('disabled', 'disabled');
    	    			$('#NonInsCustGrpId').attr('disabled', 'disabled');
    	    			$('#nonInsCusGrpIcn').attr('disabled', 'disabled');
    	        		$('#NonInsCust').attr('disabled', 'disabled');
    	    			$('#NonInsCustId').attr('disabled', 'disabled');
    	    			$('#nonInsCusIcn').attr('disabled', 'disabled');
    	    			$('#nonInsRefIcn').attr('disabled', 'disabled');
    	     			$('#nonInsScRefSrc').attr('disabled', 'disabled');
    	     			$('#nonInsSecRefIcn').attr('disabled', 'disabled');
    	     			$('#nonInsRefSrc').attr('disabled', 'disabled');
    	    		}
            	 }    
            	 if((data1.credit_doc_ref_reqd_yn=="Y" && !(data1.settlement_ind=="X" && data1.adm_rec_flag == "2")) || data1.nicredit_doc_ref_reqd_yn=="Y"){
            		$('#ccdetails').find('input').val('');
         			$('#ccdetails').find('input').removeAttr("disabled");
         		}else{
					$('#ccdetails').find('input').val('');
					$('#ccdetails').find('input').attr('disabled',true);
         		} 
            	 
            	 $('#slmtInd').val(data1.settlement_ind);
            	 $('#admRecFlag').val(data1.adm_rec_flag);
            	 $('#capRefSrcYN').val(data1.capture_ref_source_dtl_yn);
            	 $('#primaryRefSrcMandYN').val(data1.ref_source_main_mand_yn);
            	 $('#secRefSrcMandYN').val(data1.ref_source_sub_mand_yn);
            	 if(data1.settlement_ind=="C" || data1.settlement_ind=="R" || (data1.settlement_ind=="X" && data1.adm_rec_flag == "1")){
            		 $('#creditAuthRefReqd').val(data1.credit_doc_ref_reqd_yn);
            	 }else if(data1.settlement_ind=="X" && data1.adm_rec_flag == "2"){
            		 $('#nonInsCreditAuthRefReqd').val(data1.nicredit_doc_ref_reqd_yn);
            	 }
        		
             }else{ //else part on non-ins blng grp selection
            	 if(data1.nisettlement_ind=="C" || data1.nisettlement_ind=="R"){ 
            		/*$('#nonInsDtls').find('input').val('');
    	    		$('#nonInsDtls').find('input').attr('disabled',true);
    	    		$('#nonInsDtls').find('searchIcon').attr('disabled',true);
    	    		$('#remove-selected-rows').attr('disabled', 'disabled');
    	    		$('#addRw').attr('disabled', 'disabled');
    	    	*/	if(data1.nicapture_ref_source_dtl_yn=="Y"){
    	    			/*$('#priRefSrcIcon').attr('onclick', 'PrimaryRefSrcLkp(priRefSrc)');
    	        		$('#secRefSrcIcon').attr('onclick', 'SecRefSourceLookup(secRefSrc)');
    	        	*/	//alert("281")
    	        		$('#nonInsRefIcn').removeAttr("disabled"); 
    	    			$('#nonInsSecRefIcn').removeAttr("disabled");
    	        		$('#nonInsRefSrc').removeAttr("disabled"); 
    	    			$('#nonInsScRefSrc').removeAttr("disabled"); 
    	    			$('#nonInsRefSrcId').removeAttr("disabled"); 
    	        		$('#nonInsScRefSrcId').removeAttr("disabled"); 
    	    			//alert("286")
    	        	}else{
    	        		/*$('#priRefSrcIcon').removeAttr('onclick');
    	        		$('#secRefSrcIcon').removeAttr('onclick');
    	        		*/
    	        		$('#nonInsRefSrc').val('');
    	        		$('#nonInsRefSrcId').val('');
    	        		$('#nonInsScRefSrc').val('');
    	        		$('#nonInsScRefSrcId').val('');
         				
    	        		$('#nonInsRefIcn').attr('disabled', 'disabled');
    	        		$('#nonInsSecRefIcn').attr('disabled', 'disabled');
    	        		$('#nonInsRefSrc').attr('disabled', 'disabled');
    	        		$('#nonInsScRefSrc').attr('disabled', 'disabled');
    	        		$('#nonInsRefSrcId').attr('disabled', 'disabled');
    	        		$('#nonInsScRefSrcId').attr('disabled', 'disabled');
    	        	}
					if(data1.nisettlement_ind=="R"){ 
						$('#NonInsCustGrp').removeAttr("disabled"); 
						$('#NonInsCustGrpId').removeAttr("disabled"); 
						$('#nonInsCusGrpIcn').removeAttr("disabled");
						$('#NonInsCust').removeAttr("disabled"); 
						$('#NonInsCustId').removeAttr("disabled"); 
						$('#nonInsCusIcn').removeAttr("disabled"); 
					}else{
						$('#NonInsCustGrp').attr('disabled', 'disabled');
						$('#NonInsCustGrpId').attr('disabled', 'disabled');
						$('#nonInsCusGrpIcn').attr('disabled', 'disabled');
						$('#NonInsCust').attr('disabled', 'disabled');
						$('#NonInsCustId').attr('disabled', 'disabled');
						$('#nonInsCusIcn').attr('disabled', 'disabled');
					}
					if(data1.nonInsBlngId=="" && data1.settlement_ind=="X"){
						$('#NonInsCustGrp').attr('disabled', 'disabled');
						$('#NonInsCustGrpId').attr('disabled', 'disabled');
						$('#nonInsCusGrpIcn').attr('disabled', 'disabled');
						$('#NonInsCust').attr('disabled', 'disabled');
						$('#NonInsCustId').attr('disabled', 'disabled');
						$('#nonInsCusIcn').attr('disabled', 'disabled');
						$('#nonInsRefIcn').attr('disabled', 'disabled');
						$('#nonInsScRefSrc').attr('disabled', 'disabled');
						$('#nonInsSecRefIcn').attr('disabled', 'disabled');
						$('#nonInsRefSrc').attr('disabled', 'disabled');
					}
            	 }
            	 
            	 if(data1.nicredit_doc_ref_reqd_yn=="Y" || data1.nisettlement_ind=="R"){
            		$('#ccdetails').find('input').val('');
          			$('#ccdetails').find('input').removeAttr("disabled");
          		 }
            	 $('#nonInsSlmtInd').val(data1.nisettlement_ind);
            	 $('#nonInsAdmRecFlag').val(data1.niadm_rec_flag);
            	 $('#nonInsCapRefSrcYN').val(data1.nicapture_ref_source_dtl_yn);
            	 $('#nonInsPrimaryRefSrcMandYN').val(data1.niref_source_main_mand_yn);
            	 $('#nonInsSecRefSrcMandYN').val(data1.niref_source_sub_mand_yn);
            	 $('#nonInsCreditAuthRefReqd').val(data1.nicredit_doc_ref_reqd_yn);
             }
         },
         error: function(error){
             alert(error);
         }
	 });
	}
}

function validateCustCode(custCode,obj){

	var paramForQuery = decodeURI(document.getElementById("paramForQuery").value);
	
	var facility_id = document.getElementById('facility_id').value;
	var locale = document.getElementById('locale').value;
	var visit_regn_date_time = document.getElementById('visit_regn_date_time').value;
	var called_for = "validate_cust_code";
	
	 $.ajax({
	    type: "GET",
	    url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?",
	    data:"called_for="+called_for+
			"&cust_code="+custCode+
			"&"+paramForQuery+
			"&facility_id="+facility_id+
			"&locale="+locale+
			"&visit_regn_date_time="+visit_regn_date_time,
		 dataType:"text",
		 async:false,
	    success: function(data){
	       	var response = JSON.parse($.trim(data));

	        if(response.message_text != ''){
	       		alert(response.message_text);	
				obj.value = "";
	       		return;
	     	}else if(response.err_out != ''){
	       		let message = getMessage(response.err_out, "BL").trim();
				alert(`${message}`);
				obj.value = "";
				return;
	        }
        },
	    error: function(error){
	        alert(error);
	    }
	});
}

function validatePolicyTypeCode(index,policy_type_code){

	var facility_id = document.getElementById('facility_id').value;
	var locale = document.getElementById('locale').value;
	var moduleId = document.getElementById('moduleId').value;
	var episode_type = document.getElementById('episodeType').value;
	var cust_group_code = document.getElementById('custGroupCode_'+index).value;
	var cust_code = document.getElementById('custCode_'+index).value;
	
	var param = "episode_type="+episode_type+"&facility_id="+facility_id+"&cust_group_code="+encodeURIComponent(cust_group_code)+"&cust_code="+encodeURIComponent(cust_code)+"&policy_type_code="+encodeURIComponent(policy_type_code)+"&called_from=cust_pol_change";
	var url = "../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
	
	 $.ajax({
	    type: "GET",
	    url: url,
	    data: param,
		 async:false,
	    success: function(data){
	   	 var array = data.trim().split('/');
			//alert(array);
			//R,R,R,N,N,I,N
			if(array != ""){
				var policy_limit_type = array[0];
    			var approved_amt_limit_type = array[1];
    			var approved_days_limit_type = array[2];
    			var cred_auth_req_yn = array[3];
    			var policy_approved_by = array[7];
				$('#policy_limit_type_'+index).val(policy_limit_type);
	    		$('#approved_days_limit_type_'+index).val(approved_amt_limit_type);
	    		$('#approved_amt_limit_type_'+index).val(approved_days_limit_type);
	    		$('#cred_auth_req_yn_'+index).val(cred_auth_req_yn);
	    		$('#policy_approved_by_'+index).val(policy_approved_by);
	    		if(policy_limit_type == "R"){
	    			//alert("Approved fields is enabled");
	    			if(approved_amt_limit_type == "R"){
	    				$('#approvedAmt_'+index).removeAttr("disabled");
	    			}else{
	    				$('#approvedAmt_'+index).attr('disabled', 'disabled');
	    				$('#approvedAmt_'+index).val('');
	    			}
	    			if(approved_days_limit_type == "R"){
	    				$('#approvedDays_'+index).removeAttr("disabled");
	    			}else{
	    				$('#approvedDays_'+index).attr('disabled', 'disabled');
	    				$('#approvedDays_'+index).val('');
	    			}
	    		}else{
	    			//alert("Approved fields is disabled");
	    			$('#approvedAmt_'+index).attr('disabled', 'disabled');
    				$('#approvedAmt_'+index).val('');
	    			$('#approvedDays_'+index).attr('disabled', 'disabled');
    				$('#approvedDays_'+index).val('');
	    		}
	    		
	    		if(cred_auth_req_yn == "Y"){
	    			$('#creditAuthRef_'+index).removeAttr("disabled");
	    			$('#creditAuthDate_'+index).removeAttr("disabled");
	    		}else{
	    			$('#creditAuthRef_'+index).attr('disabled', 'disabled');
    				$('#creditAuthRef_'+index).val('');
	    			$('#creditAuthDate_'+index).attr('disabled', 'disabled');
    				$('#creditAuthDate_'+index).val('');
	    		}

				dfltPolicyDateAndApprAmt(facility_id, locale, moduleId, episode_type, cust_group_code, cust_code, policy_type_code, index);
			}
			
			
	    },
	    error: function(error){
	        alert(error);
	    }
	});
}

function dfltPolicyDateAndApprAmt(facility_id, locale, moduleId, episode_type, cust_group_code, cust_code, policy_type_code, index){
	var param = "strModuleId="+moduleId+"&cust_group_code="+cust_group_code+"&cust_code="+cust_code+"&policy_type_code="+policy_type_code+"&facilityId="+facility_id+"&locale="+locale;

	$.ajax({
	         type: "GET",
	         url: "../../eBL/jsp/BLModifyFinDtlsAjax.jsp?called_for=dfltPolicyDateAndApprAmt",
	         data: param,
	         dataType:"text",
	         async:false,
	         success: function(response){
				 var data1 = JSON.parse($.trim(response));
				 if(data1.Value != ""){

					 var response = data1.Value.substring(data1.Value.indexOf("!")+1,data1.Value.length);
					 var actual=response.split("~");					 

					 if(actual[0]!=null && actual[0] !='undefined')
						document.getElementById('policyStartDate_'+index).value = actual[0];
				 
					  if(actual[1]!=null && actual[1] !='undefined')
						document.getElementById('policyExpiryDate_'+index).value 	= actual[1];
				  
					  if(actual[2]!=null && actual[2] !='undefined')
						document.getElementById('approvedDays_'+index).value = actual[2];
				  
					  if(actual[3]!=null && actual[3] !='undefined')
						document.getElementById('approvedAmt_'+index).value 	= actual[3];
				 }
	         },
	         error: function(){
	             alert("Error while getting dfltPolicyDateAndApprAmt!");
	         }
	});
}
/*PrimaryRefSrcGrid SecRefSrcGrid PrimaryRefSrc SecRefSRCLkup*/
function  updateRefSrc(calledFrm,code,description,idx){
	var slmtInd = $('#slmtInd').val();
	 var admRecFlag = $('#admRecFlag').val();
	 var priBlngGrpId = $('#priBlngGrpId').val();
	 var priBlngGrpCat = $('#priBlngGrpCat').val();

	//alert(priBlngGrpId)
	 if(slmtInd == 'X' && admRecFlag == '2'){
		 var gridTotRows = $('#totalRowsIns').val();
		 //alert(gridTotRows)
		 if(calledFrm=='PrimaryRefSrcGrid'){
			 for(var i=0;i<gridTotRows;i++){
				 if($('#blngGrpId_'+i).val()==$('#blngGrpId_'+idx).val()){
					$('#referralSourceCodeMain_'+i).val(code);
				}
			 }
			 if(priBlngGrpId!=''){
				 if(priBlngGrpId==$('#blngGrpId_'+idx).val()){
					 	 $('#priRefSrc').val(description);
						 $('#priRefSrcCode').val(code);
						 for(var i=0;i<gridTotRows;i++){
							 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
								$('#referralSourceCodeMain_'+i).val(code);
							}
						 }
					}
				
				 }
		 }else if(calledFrm=='SecRefSrcGrid'){
			 for(var i=0;i<gridTotRows;i++){
				 if($('#blngGrpId_'+idx).val()==$('#blngGrpId_'+i).val()){
					$('#referralSourceCodeSub_'+i).val(code);
				}
			 }
			 if(priBlngGrpId!=''){
			   if(priBlngGrpId==$('#blngGrpId_'+idx).val()){
				 	$('#secRefSrc').val(description);
					 $('#secRefSrcCode').val(code);
					 for(var i=0;i<gridTotRows;i++){
						 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
							$('#referralSourceCodeSub_'+i).val(code);
						}
					 }
				}
			 }
		 }else if(calledFrm=='PrimaryRefSrc'){
			 if(priBlngGrpId!=''){
				 for(var i=0;i<gridTotRows;i++){
					 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
						 $('#referralSourceCodeMain_'+i).val(code);
					}
				 }
			 }
		 }else if(calledFrm=='SecRefSrc'){
			 if(priBlngGrpId!=''){
				 for(var i=0;i<gridTotRows;i++){
					 if(priBlngGrpId==$('#blngGrpId_'+i).val()){
						 $('#referralSourceCodeSub_'+i).val(code);
					 }
			 }
		 }
	 }	
}
}

