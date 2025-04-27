function addRow(obj){
	
	if(obj == 'ServicesAndItemsCategoryDetails'){
		var tbl = parent.CategoryDtls.document.getElementById('MultiFactDedRuleServicesAndItems');
		var index = tbl.rows.length - 1;
		//var prevIndex = index - 1;
		var prevIndex = index;
		var parentDoc = parent.CategoryDtls.document;
		var epsdEnc = parentDoc.getElementById("episode_"+prevIndex).value;
		var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+prevIndex).value;
		var payer_desc = parentDoc.getElementById("payer_desc_"+prevIndex).value;
		var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+prevIndex).value;
		var payer_group_code = parentDoc.getElementById("payer_group_code_"+prevIndex).value;
		var payer_code = parentDoc.getElementById("payer_code_"+prevIndex).value;
		var policy_type_code = parentDoc.getElementById("policy_type_code_"+prevIndex).value;
		var clinic_category = parentDoc.getElementById("clinic_category_"+prevIndex).value;
		var clinic_proc_cat = parentDoc.getElementById("clinic_"+prevIndex).value;
		var clinic_proc_code = parentDoc.getElementById("clinic_code_"+prevIndex).value;
		var clinic_proc_desc = parentDoc.getElementById("clinic_desc_"+prevIndex).value;
		var incl_excl_criteria = parentDoc.getElementById("incl_excl_criteria_"+prevIndex).value;
		var service_dtls_desc = parentDoc.getElementById("service_dtls_desc_"+prevIndex).value;
		var referral = parentDoc.getElementById("referral_"+prevIndex).value;				
		var patCopay = parentDoc.getElementById("patCopay_"+prevIndex).value;
		var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+prevIndex).value;
		var effFrom = parentDoc.getElementById("effFrom_"+prevIndex).value;
		var clinicCat_code_desp = parentDoc.getElementById("clinicCat_code_desp").value;		
		var clinicCat_array = clinicCat_code_desp.split("||");
		var startDate = '';
		var endDate = '';
		
		if(epsdEnc.length<1 || payer_group_desc.length<1 || payer_desc.length<1 || policy_type_desc.length<1 || clinic_category.length<1 || clinic_proc_cat.length<1 || clinic_proc_code.length<1 || clinic_proc_desc.length<1 || incl_excl_criteria<1 || service_dtls_desc.length<1 || referral.length<1 || patCopay.length<1 || patLimitAmt.length<1 || effFrom.length<1 ) {
			alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
			return false;
		}  

		var newRow = tbl.insertRow();

		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='episode_"+index+"' name='episode_"+index+"' id='episode_"+index+"' onchange='changeEpsdEnc("+index+");' disabled> "+
			"<option value='E'>Episode</option> "+
		"</select> "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 

		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='ptClass_"+index+"' name='ptClass_"+index+"' id='ptClass_"+index+"' disabled> "+
			"<option value='O'>OP</option> "+
		"</select> "+
		"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		
		//V221113
		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<input type='text' name='payer_group_desc_"+index+"' id='payer_group_desc_"+index+"' id='payer_group_desc_"+index+"' size='10' value='"+payer_group_desc+"' onblur='if(this.value.length > 0){ callCommonValidationMFDR(3,payer_group_desc_"+index+",payer_group_code_"+index+","+index+");}else{fnClearCode(payer_group_code_"+index+","+index+",1)}' disabled>  "+
		"<input type='hidden' name='payer_group_code_"+index+"' id='payer_group_code_"+index+"' id='payer_group_code_"+index+"' value='"+payer_group_code+"' >  "+
		"<input type='button' class='button' value='?'  "+
		"onClick='callCommonValidationMFDR(3,payer_group_desc_"+index+",payer_group_code_"+index+","+index+");' tabindex='2' disabled>  "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		//V221113
		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<input type='text' name='payer_desc_"+index+"' id='payer_desc_"+index+"' id='payer_desc_"+index+"' size='10' value='"+payer_desc+"' onblur='if(this.value.length > 0){ callCommonValidationMFDR(2,payer_desc_"+index+",payer_code_"+index+","+index+");}else{fnClearCode(payer_code_"+index+","+index+",2)}' disabled>  "+
		"<input type='hidden' name='payer_code_"+index+"' id='payer_code_"+index+"' id='payer_code_"+index+"' value='"+payer_code+"' >  "+
		"<input type='button' class='button' value='?'  "+
		"onClick='callCommonValidationMFDR(2,payer_desc_"+index+",payer_code_"+index+","+index+");' tabindex='2' disabled>  "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		//V221113
		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<input type='text' name='policy_type_desc_"+index+"' id='policy_type_desc_"+index+"' id='policy_type_desc_"+index+"' size='10' value='"+policy_type_desc+"' onblur='if(this.value.length > 0){ callCommonValidationMFDR(4,policy_type_desc_"+index+",policy_type_code_"+index+","+index+");}else{fnClearCode(policy_type_code_"+index+","+index+",3)}' disabled>  "+
		"<input type='hidden' name='policy_type_code_"+index+"' id='policy_type_code_"+index+"' id='policy_type_code_"+index+"' value='"+policy_type_code+"' >  "+
		"<input type='button' class='button' value='?'  "+
		"onClick='callCommonValidationMFDR(4,policy_type_desc_"+index+",policy_type_code_"+index+","+index+");' tabindex='2' disabled>  "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		var newCell = newRow.insertCell();
		var temp="<td class='fields' nowrap> "+
		"<select id='clinic_category_"+index+"' name='clinic_category_"+index+"' id='clinic_category_"+index+"' onchange='clearClinicProc("+index+");'> "+
		"<option value='' selected>Select</option> ";		
		for(var x = 0; x < clinicCat_array.length-1; x++){
			var clinicCat = clinicCat_array[x].split("~");
			temp=temp+"<option value='"+clinicCat[0]+"'>"+clinicCat[1]+"</option>"
		}
		newCell.innerHTML=temp+"</select> "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 



		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<select name='clinic_"+index+"' id='clinic_"+index+"' id='clinic_"+index+"' onchange='clearClinicProc("+index+");'> "+
						"<option value='C'>Clinic</option> "+  
						"<option value='P'>Procedure Unit</option> "+
						"<option value='A'>All</option> "+
					"</select> "+"/ "+
					"<input type='text' name='clinic_code_"+index+"' id='clinic_code_"+index+"' id='clinic_code_"+index+"' size='4' value='' onblur='if(this.value.length > 0){ callClinicProcValidation(1,clinic_"+index+",clinic_desc_"+index+",clinic_code_"+index+");}else{fnClearCode(clinic_code_"+index+")}' >  "+
					"<input type='text' name='clinic_desc_"+index+"' id='clinic_desc_"+index+"' id='clinic_desc_"+index+"' size='20' value='' onblur='if(this.value.length > 0){ callClinicProcValidation(1,clinic_"+index+",clinic_desc_"+index+",clinic_code_"+index+");}else{fnClearCode(clinic_code_"+index+"); }' >  "+
					"<input type='button' class='button' id='clinic_but_"+index+"' value='?'  "+
					"onClick='callClinicProcValidation(1,clinic_"+index+",clinic_desc_"+index+",clinic_code_"+index+")' tabindex='2'>  "+							
					"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		
		

		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='incl_excl_criteria_"+index+"' name='incl_excl_criteria_"+index+"' id='incl_excl_criteria_"+index+"' > "+
			"<option value='PG'>Package Group</option> "+
		"</select> "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap = "nowrap"; 

		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<input type='text' name='service_dtls_desc_"+index+"' id='service_dtls_desc_"+index+"' id='service_dtls_desc_"+index+"' size='10' maxlength='5' value='' onblur='if(this.value.length > 0){ callCommonValidationMFDR(5,service_dtls_desc_"+index+",service_dtls_code_"+index+","+index+");}else{fnClearCode(service_dtls_code_"+index+","+index+",3)}' >  "+
		"<input type='hidden' name='service_dtls_code_"+index+"' id='service_dtls_code_"+index+"' id='service_dtls_code_"+index+"' >  "+
		"<input type='button' class='button' value='?'  "+
		"onClick='callCommonValidationMFDR(5,service_dtls_desc_"+index+",service_dtls_code_"+index+","+index+");' tabindex='2'>  "+
		"</td> ";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap";

		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<select name='referral_"+index+"' id='referral_"+index+"' id='referral_"+index+"' > "+
						"<option value=''>Select</option> "+
						"<option value='Y'>Referral</option> "+  
						"<option value='N'>Non-Referral</option> "+
						"<option value='B'>Both</option> "+
					"</select> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 	
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='patCopay_"+index+"' name='patCopay_"+index+"' id='patCopay_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='5'> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='patLimitAmt_"+index+"' name='patLimitAmt_"+index+"' id='patLimitAmt_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='10'> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<select name='AmtMode_"+index+"' id='AmtMode_"+index+"'> "+
						"<option value='N'>Net</option> "+  
						"<option value='G'>Gross</option> "+
					"</select> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 	
		
		//V230801
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
				"<input type='checkbox' id='across_enc_YN_"+index+"' name='across_enc_YN_"+index+"' id='across_enc_YN_"+index+"' value=''> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 

		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='effFrom_"+index+"' name='effFrom_"+index+"' id='effFrom_"+index+"' value='' maxlength='10' size='10' onblur='effFromDateValidation(this, effFrom_"+index+",effTo_"+index+");checkForReferralCategory(referral_"+index+",clinic_category_"+index+","+index+")' > "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendarLocal(1,"+index+")' /> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 

		//V221113
		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='effTo_"+index+"' name='effTo_"+index+"' id='effTo_"+index+"' value='' maxlength='10' size='10' onblur='effToDateValidation(this, effFrom_"+index+",effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendarLocal(2,"+index+")'  /> "+
					"<input type='hidden' name='rowStatus_"+index+"' id='rowStatus_"+index+"' value='I'> "+
					"<input type='hidden' name='rowNumber_"+index+"' id='rowNumber_"+index+"' value='"+index+"'> "+
				"</td>";
		newCell.className = 'fields'; 
		newCell.style.nowrap="nowrap"; 

		

		parent.CategoryDtls.document.forms[0].rowCount.value = index;  
		
	}
	
}

