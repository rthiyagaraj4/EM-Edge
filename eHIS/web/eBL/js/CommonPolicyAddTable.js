function addRow(obj){
	if( obj == 'InclExcl'){
		//alert('Here')
		var tbl = parent.PolicyDetailsPage.document.getElementById('PolicyInclExcl');
		var startDate = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].startDate.value;
		var endDate = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].endDate.value;
		var index = tbl.rows.length - 1;
		var prevIndex = index - 1;
		
		var parentDoc = parent.PolicyDetailsPage.document;
		var epsdEnc = parentDoc.getElementById("episode_"+prevIndex).value;
		var patClass = parentDoc.getElementById("ptClass_"+prevIndex).value;
		var ageGroup = parentDoc.getElementById("hdn_age_group_"+prevIndex).value;
		var genderCat = parentDoc.getElementById("gender_"+prevIndex).value;
		var clinicNurs = parentDoc.getElementById("clinic_"+prevIndex).value;
		var clnCode = parentDoc.getElementById("clinic_code_"+prevIndex).value;
		var incExcCriteria = parentDoc.getElementById("incExCriteria_"+prevIndex).value;
		var effFromDate = parentDoc.getElementById("effFrom_"+prevIndex).value;
		var specCode = parentDoc.getElementById("spec_code_"+prevIndex).value;
		var prevBillCode  = parentDoc.getElementById("bg_code_"+prevIndex).value;

		if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || effFromDate.length<1 || specCode.length<1 || prevBillCode.length<1) {
			alert("Please enter all mandatory fields");
			return false;
		}
		var siteId = parentDoc.forms[0].siteId.value;
		var inclExclDesc = parent.PolicyDetailsPage.document.forms[0].inclExclDesc.value;
		var inclExclCode = parent.PolicyDetailsPage.document.forms[0].inclExclCode.value;
		var inclExclDescArr = inclExclDesc.split(":::");
		var inclExclCodeArr = inclExclCode.split(":::");
		var newRow = tbl.insertRow();
		var newCell = newRow.insertCell(0);
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='episode_"+index+"' name='episode_"+index+"' id='episode_"+index+"' onchange='changeEpsdEnc("+index+");'> "+
			"<option value=''>Select</option> "+
			"<option value='E'>Episode</option> "+
			"<option value='N'>Encounter</option> "+		
			"<option value='A'>All</option> "+
		"</select> "+
		"</td> ";
		newCell.style.nowrap="nowrap"; 
		//alert(index);
		//alert(prevBillCodeObj);
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='ptClass_"+index+"' name='ptClass_"+index+"' id='ptClass_"+index+"'> "+
			"<option value=''>Select</option> "+
			"<option value='OP'>OP</option> "+
			"<option value='IP'>IP</option> "+
			"<option value='DC'>DC</option> "+
			"<option value='XT'>EX</option> "+
			"<option value='EM'>EM</option> "+
			"<option value='**'>All</option> "+
		"</select> "+
	"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = "<td class='fields' nowrap> "+
			"<input type='text' name='age_group_"+index+"' id='age_group_"+index+"' id='age_group_"+index+"' length='15' onblur='if(this.value.length>0){ callCommonValidation(5,this,hdn_age_group_"+index+");}'> "+
			"<input type='hidden' name='hdn_age_group_"+index+"' id='hdn_age_group_"+index+"' id='hdn_age_group_"+index+"' > "+
			"<input type='button' id='age_but_"+index+"' value='?' onclick='callCommonValidation(5,age_group_"+index+",hdn_age_group_"+index+")'> "+
		"</td> ";
		newCell.style.nowrap="nowrap"; 
			
		newCell = newRow.insertCell();	
		newCell.innerHTML = "<td class='fields' nowrap> "+
			"<select id='gender_"+index+"' name='gender_"+index+"' id='gender_"+index+"'> "+
				"<option value=''>Select</option> "+
				"<option value='M'>Male</option> "+
				"<option value='F'>Female</option> "+
				"<option value='A'>Both</option> "+
			"</select> "+
			"</td> ";
		newCell.style.nowrap="nowrap"; 
		

		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='clinic_"+index+"' name='clinic_"+index+"' id='clinic_"+index+"' onchange='clearClinic("+index+")'> "+
			"<option value='C'>Clinic</option> "+
			"<option value='N'>Nursing Unit</option> "+
			"<option value='A'>All</option> "+
		"</select> "+
	"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='clinic_code_"+index+"' name='clinic_code_"+index+"' id='clinic_code_"+index+"' size='4'> "+
					"<input type='text' id='clinic_desc_"+index+"' name='clinic_desc_"+index+"' id='clinic_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callBGDesc(1,clinic_"+index+",this,clinic_code_"+index+");}'> "+
					"<input type='button' id='clinic_but_"+index+"' value='?' onclick='callBGDesc(1,clinic_"+index+",clinic_desc_"+index+",clinic_code_"+index+")'> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='spec_code_"+index+"' name='spec_code_"+index+"' id='spec_code_"+index+"' size='5'> "+
					"<input type='text' id='spec_desc_"+index+"' name='spec_desc_"+index+"' id='spec_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callCommonValidationSpec(spec_desc_"+index+",spec_code_"+index+",clinic_"+index+",clinic_code_"+index+");}'> "+
					"<input type='button' id='spec_but_"+index+"' value='?' onclick='callCommonValidationSpec(spec_desc_"+index+",spec_code_"+index+",clinic_"+index+",clinic_code_"+index+")'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		var inclExclHtml = "<td class='fields' nowrap> "+
							"<Select name='incExCriteria_"+index+"' id='incExCriteria_"+index+"' id='incExCriteria_"+index+"' onchange='clearBill("+index+")'> ";
		
		for(var x=0;x<inclExclCodeArr.length;x++){
			inclExclHtml = inclExclHtml+"<option value='"+inclExclCodeArr[x]+"'>"+inclExclDescArr[x]+"</option> ";
		}
		inclExclHtml = inclExclHtml+"</select> "+
							"</td> ";
		newCell.innerHTML = inclExclHtml;
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='bg_code_"+index+"' name='bg_code_"+index+"' id='bg_code_"+index+"' size='12'> "+
					"<input type='text' id='bg_desc_"+index+"' name='bg_desc_"+index+"' id='bg_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callBGDesc(2,incExCriteria_"+index+",bg_desc_"+index+",bg_code_"+index+");}'> "+
					"<input type='button' id='bg_but_"+index+"' value='?' onclick='callBGDesc(2,incExCriteria_"+index+",bg_desc_"+index+",bg_code_"+index+")'> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='checkbox' id='bg_chk_"+index+"' name='bg_chk_"+index+"' id='bg_chk_"+index+"'> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<Select name='incExInd_"+index+"' id='incExInd_"+index+"' onchange='changeInclExclInd("+index+");'> "+
						"<option value='I'>Include</option> "+
						"<option value='E'>Exclude</option> "+
					"</Select> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		/* Added V181003-Aravindh/AAKH-CRF-0107/Starts */
		var siteSpecRefPrice = parent.PolicyDetailsPage.document.getElementById("siteSpecRefPrice").value;
		if(siteSpecRefPrice == "true" || siteSpecRefPrice == true) {
			newCell = newRow.insertCell();	
			newCell.innerHTML = 
					"<td class='fields' nowrap> "+
						"<input type='checkbox' name='coverRefPrice_"+index+"' id='coverRefPrice_"+index+"' id='coverRefPrice_"+index+"' onclick='unCheckAllLineLvlRefChkBox(\"line\")'>"+
					"</td> ";
			newCell.style.nowrap="nowrap"; 
		}
		/* Added V181003-Aravindh/AAKH-CRF-0107/Ends */
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='checkbox' id='incExChk_"+index+"' name='incExChk_"+index+"' id='incExChk_"+index+"'> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		var InclBasis = "<td class='fields' nowrap> "+
						"<Select name='incBasis_"+index+"' id='incBasis_"+index+"'> "+
						"<option value=''>Select</option> "+
						"<option value='P'>Percentage</option> "+
						"<option value='R'>Rate</option> ";
		if(siteId !='ALKA'){
			InclBasis += "<option value='F'>Fixed</option> ";
		}
		InclBasis += "</Select> "+
				"</td>";
		newCell.innerHTML = InclBasis;
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' id='value_"+index+"' name='value_"+index+"' id='value_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='checkbox' id='valueChk1_"+index+"' name='valueChk1_"+index+"' id='valueChk1_"+index+"'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='checkbox' id='valueChk3_"+index+"' name='valueChk3_"+index+"' id='valueChk3_"+index+"'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap > "+
					"<input type='checkbox' id='valueChk4_"+index+"' name='valueChk4_"+index+"' id='valueChk4_"+index+"'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' id='servItemQty_"+index+"' name='servItemQty_"+index+"' id='servItemQty_"+index+"' onkeypress='return checkAlpha(event)' size='10' maxlength='10' onblur='checkForNumber(this)'> "+
				"</td> ";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 		
				"<td class='fields' nowrap> "+
					"<input type='text' id='amtPerVisit_"+index+"' name='amtPerVisit_"+index+"' id='amtPerVisit_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='amtPerIPDay_"+index+"' name='amtPerIPDay_"+index+"' id='amtPerIPDay_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
					"&nbsp;&nbsp;<select name='AmtMode_"+index+"' id='AmtMode_"+index+"'> "+
						"<option value='G'>Gross</option> "+
						"<option value='N'>Net</option> "+
					"</select> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='patCopay_"+index+"' name='patCopay_"+index+"' id='patCopay_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='5'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 

		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='patLimitAmt_"+index+"' name='patLimitAmt_"+index+"' id='patLimitAmt_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='10'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='noOfDays_"+index+"' name='noOfDays_"+index+"' id='noOfDays_"+index+"' onkeypress='return checkAlpha(event)' size='10' maxlength='5' onblur='checkForNumber(this)'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();
		var chk = 'serviceLmt_'+index;
		var link = 'serviceLink_'+index;
		newCell.innerHTML = "<td class='fields' nowrap > "+					
					"<input type='checkbox' id='serviceLmt_"+index+"' name='serviceLmt_"+index+"' id='serviceLmt_"+index+"'  onclick='enableDisableLink("+index+");'> "+
					"<a href='javascript:showService("+index+")' id='serviceLink_"+index+"' name='serviceLink_"+index+"' style='visibility: hidden;'>Dtls</a> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='effFrom_"+index+"' name='effFrom_"+index+"' id='effFrom_"+index+"' value='"+startDate+"' size='10' onblur='isValidDate(this);checkDateFrom(effFrom_"+index+");compareDates(effFrom_"+index+",effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendarLocal(1,"+index+")' /> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='effTo_"+index+"' name='effTo_"+index+"' id='effTo_"+index+"' value='"+endDate+"' size='10' onblur='isValidDate(this);checkDateFrom(effTo_"+index+");compareDates(effFrom_"+index+",effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendarLocal(2,"+index+")' /> "+
					"<input type='hidden' name='rowStatus"+index+"' id='rowStatus"+index+"' value='I'> "+
					"<input type='hidden' name='rowNumber"+index+"' id='rowNumber"+index+"' value='"+index+"'> "+
					"<input type='hidden' name='effectiveDate"+index+"' id='effectiveDate"+index+"' value='"+startDate+"'> "+
				"</td>";
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();
		newCell.innerHTML =				"<td class='fields' nowrap> "+
		"<input type='checkbox' id='delFlag"+index+"' id='delFlag"+index+"' name='delFlag"+index+"' id='delFlag"+index+"'> "+
		"</td>";
		newCell.style.nowrap="nowrap"; 
		
		parent.PolicyDetailsPage.document.forms[0].inclRowCount.value = index;
		//alert(document.forms[0].inclRowCount.value);
		//Added hidden effectiveDate for AAKH SCF 0172
	}
	else if( obj == 'PreApprovalPopup'){
		var tbl = parent.PolicyDetailsPage.document.getElementById('PolicyPreApprovalPopup');
		var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
		var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
		var criteria = parent.PolicyDetailsPage.document.forms[0].criteria.value;
		var inclExclDesc = parent.PolicyDetailsPage.document.forms[0].inclExclDesc.value;
		var inclExclCode = parent.PolicyDetailsPage.document.forms[0].inclExclCode.value;
		var inclExclDescArr = inclExclDesc.split(":::");
		var inclExclCodeArr = inclExclCode.split(":::");
		var index = tbl.rows.length;
		
		var prevIndex = index - 1;
		var parentDoc = parent.PolicyDetailsPage.document;
		var incExcCriteria = parentDoc.getElementById("pop_incExCriteria_"+prevIndex).value;
		var effFromDate = parentDoc.getElementById("pop_effFrom_"+prevIndex).value;
		var prevBillCode  = parentDoc.getElementById("pop_bg_code_"+prevIndex).value;

		if(incExcCriteria.length<1 || effFromDate.length<1 || prevBillCode.length<1) {
			alert("Please enter all mandatory fields");
			return false;
		}
		var siteId = parentDoc.forms[0].siteId.value;
		var newRow = tbl.insertRow();
		var newCell = newRow.insertCell();
		var inclExclHtml = "<td class='fields' nowrap> "+
		"<Select id='pop_incExCriteria_"+index+"' name='pop_incExCriteria_"+index+"' id='pop_incExCriteria_"+index+"' onchange='clearBillPop("+index+")'> ";

		for(var x=0;x<inclExclCodeArr.length;x++){
		inclExclHtml = inclExclHtml+"<option value='"+inclExclCodeArr[x]+"'>"+inclExclDescArr[x]+"</option> ";
		}
		inclExclHtml = inclExclHtml+"</select> "+
				"</td> ";
		newCell.innerHTML = inclExclHtml;
				
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='pop_bg_code_"+index+"' name='pop_bg_code_"+index+"' id='pop_bg_code_"+index+"' size='12'> "+
					"<input type='text' id='pop_bg_desc_"+index+"' name='pop_bg_desc_"+index+"' id='pop_bg_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callBlngServPopup(2,pop_incExCriteria_"+index+",pop_bg_desc_"+index+",pop_bg_code_"+index+");}'> "+
					"<input type='button' id='pop_bg_but_"+index+"' value='?' onclick='callBlngServPopup(2,pop_incExCriteria_"+index+",pop_bg_desc_"+index+",pop_bg_code_"+index+")'> "+
				"</td> ";

		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<Select name='pop_incExInd_"+index+"' id='pop_incExInd_"+index+"'  onchange='changeInclExclIndPop("+index+");'> "+
						"<option value='I'>Include</option> "+
						"<option value='E'>Exclude</option> "+
					"</Select> "+
				"</td> ";

		newCell = newRow.insertCell();	
		var InclBasis = "<td class='fields' nowrap> "+
						"<Select name='pop_incBasis_"+index+"' id='pop_incBasis_"+index+"'> "+
						"<option value=''>Select</option> "+
						"<option value='P'>Percentage</option> "+
						"<option value='R'>Rate</option> ";
		if(siteId !='ALKA'){
			InclBasis += "<option value='F'>Fixed</option> ";
		}
		InclBasis += "</Select> "+
					"</td>";
		newCell.innerHTML = InclBasis;
					
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_value_"+index+"' name='pop_value_"+index+"' id='pop_value_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
				"</td>";
		
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_servItemQty_"+index+"' name='pop_servItemQty_"+index+"' id='pop_servItemQty_"+index+"' onkeypress='return checkAlpha(event)' size='10' maxlength='10' onblur='checkForNumber(this)'> "+
				"</td> ";
		newCell = newRow.insertCell();	
		newCell.innerHTML = 		
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_amtPerVisit_"+index+"' name='pop_amtPerVisit_"+index+"' id='pop_amtPerVisit_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
				"</td>";
		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_amtPerIPDay_"+index+"' name='pop_amtPerIPDay_"+index+"' id='pop_amtPerIPDay_"+index+"' onkeypress='return checkForSpecChars(event)' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
					"&nbsp;&nbsp;<select name='AmtMode_"+index+"' id='AmtMode_"+index+"'> "+
						"<option value='G'>Gross</option> "+
						"<option value='N'>Net</option> "+
					"</select> "+
				"</td>";

		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_patCopay_"+index+"' name='pop_patCopay_"+index+"' id='pop_patCopay_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='5'> "+
				"</td>";

		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_patLimitAmt_"+index+"' name='pop_patLimitAmt_"+index+"' id='pop_patLimitAmt_"+index+"' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this)' size='10' maxlength='10'> "+
				"</td>";

		newCell = newRow.insertCell();	
		newCell.innerHTML = 	
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_noOfDays_"+index+"' name='pop_noOfDays_"+index+"' id='pop_noOfDays_"+index+"'' onkeypress='return checkAlpha(event)' size='10' maxlength='5' onblur='checkForNumber(this)'> "+
				"</td>";
		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_effFrom_"+index+"' name='pop_effFrom_"+index+"' id='pop_effFrom_"+index+"' size='10' value='"+startDate+"' onblur='isValidDate(this);checkDateFrom(pop_effFrom_"+index+");compareDates(pop_effFrom_"+index+",pop_effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendarLocal(1,"+index+")' /> "+
				"</td>";
		newCell = newRow.insertCell();	
		newCell.innerHTML =
				"<td class='fields' nowrap> "+
					"<input type='text' id='pop_effTo_"+index+"' name='pop_effTo_"+index+"' id='pop_effTo_"+index+"' size='10' value='"+endDate+"' onblur='isValidDate(this);checkDateFrom(pop_effTo_"+index+");compareDates(pop_effFrom_"+index+",pop_effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendarLocal(2,"+index+")' /> "+
					"<input type='hidden' name='pop_rowStatus"+index+"' id='pop_rowStatus"+index+"' value='I'> "+
					"<input type='hidden' name='pop_effectiveDate"+index+"' id='pop_effectiveDate"+index+"' value='"+startDate+"'> "+
				"</td>";
		newCell = newRow.insertCell();
		newCell.innerHTML =				"<td class='fields' nowrap> "+
		"<input type='checkbox' id='pop_delFlag"+index+"' id='pop_delFlag"+index+"' name='pop_delFlag"+index+"' id='pop_delFlag"+index+"'> "+
		"</td>";
		
		parent.PolicyDetailsPage.document.forms[0].inclRowCount.value = index;
		//Added hidden pop_effectiveDate for AAKH SCF 0172
	}
	else if( obj == 'PreApproval'){
		var tbl = parent.PolicyDetailsPage.document.getElementById('PolicyPreApproval');
		var index = tbl.rows.length;
		var startDate = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].startDate.value;
		var endDate = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].endDate.value;
		var inclExclDesc = parent.PolicyDetailsPage.document.forms[0].inclExclDesc.value;
		var inclExclCode = parent.PolicyDetailsPage.document.forms[0].inclExclCode.value;
		var inclExclDescArr = inclExclDesc.split(":::");
		var inclExclCodeArr = inclExclCode.split(":::");
		//alert(index);
		var prevIndex = index - 1;
		var parentDoc = parent.PolicyDetailsPage.document;
		var epsdEnc = parentDoc.getElementById("episode_"+prevIndex).value;
		var patClass = parentDoc.getElementById("ptClass_"+prevIndex).value;
		var ageGroup = parentDoc.getElementById("hdn_age_group_"+prevIndex).value;
		var genderCat = parentDoc.getElementById("gender_"+prevIndex).value;
		var clinicNurs = parentDoc.getElementById("clinic_"+prevIndex).value;
		var clnCode = parentDoc.getElementById("clinic_code_"+prevIndex).value;
		var incExcCriteria = parentDoc.getElementById("type_"+prevIndex).value;
		var effFromDate = parentDoc.getElementById("effFrom_"+prevIndex).value;
		var specCode = parentDoc.getElementById("spec_code_"+prevIndex).value;
		var prevBillCode  = parentDoc.getElementById("bg_code_"+prevIndex).value;

		if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || effFromDate.length<1 || specCode.length<1 || prevBillCode.length<1) {
			alert("Please enter all mandatory fields");
			return false;
		}
		
		var newRow = tbl.insertRow();
		var newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<select id='episode_"+index+"' name='episode_"+index+"' id='episode_"+index+"' onchange='changeEpsdEnc("+index+");'> "+
			"<option value=''>Select</option> "+
			"<option value='E'>Episode</option> "+
			"<option value='N'>Encounter</option> "+	
			"<option value='A'>All</option> "+
		"</select> "+
	"</td> ";

		newCell = newRow.insertCell();		
		
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<select id='ptClass_"+index+"' name='ptClass_"+index+"' id='ptClass_"+index+"'> "+
						"<option value=''>Select</option> "+
						"<option value='OP'>OP</option> "+
						"<option value='IP'>IP</option> "+
						"<option value='DC'>DC</option> "+
						"<option value='XT'>EX</option> "+
						"<option value='EM'>EM</option> "+
						"<option value='**'>All</option> "+
					"</select> "+
				"</td>";
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = "<td class='fields' nowrap> "+
		"<input type='text' name='age_group_"+index+"' id='age_group_"+index+"' id='age_group_"+index+"' length='15' onblur='if(this.value.length>0){ callCommonValidation(5,this,hdn_age_group_"+index+");}'> "+
		"<input type='hidden' name='hdn_age_group_"+index+"' id='hdn_age_group_"+index+"' id='hdn_age_group_"+index+"' > "+
		"<input type='button' id='age_but_"+index+"' value='?' onclick='callCommonValidation(5,age_group_"+index+",hdn_age_group_"+index+")'> "+

			"</td> ";
			
		newCell = newRow.insertCell();	
		newCell.innerHTML = "<td class='fields' nowrap> "+
			"<select id='gender_"+index+"' name='gender_"+index+"' id='gender_"+index+"'> "+
				"<option value=''>Select</option> "+
				"<option value='M'>Male</option> "+
				"<option value='F'>Female</option> "+
				"<option value='A'>Both</option> "+
			"</select> "+
			"</td> ";


		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<select id='clinic_"+index+"' name='clinic_"+index+"' id='clinic_"+index+"' onchange='clearClinic("+index+")'> "+
						"<option value='C'>Clinic</option> "+
						"<option value='N'>Nursing Unit</option> "+
						"<option value='A'>All</option> "+
					"</select> "+
				"</td> ";
		
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='clinic_code_"+index+"' name='clinic_code_"+index+"' id='clinic_code_"+index+"' size='4'> "+
					"<input type='text' id='clinic_desc_"+index+"' name='clinic_desc_"+index+"' id='clinic_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callBGDesc(1,clinic_"+index+",this,clinic_code_"+index+");}'> "+
					"<input type='button' id='clinic_but_"+index+"' value='?' onclick='callBGDesc(1,clinic_"+index+",clinic_desc_"+index+",clinic_code_"+index+")'> "+
				"</td> ";
		newCell = newRow.insertCell();	
		
		newCell.innerHTML = 
				"<td class='fields' nowrap> "+
					"<input type='text' readonly id='spec_code_"+index+"' name='spec_code_"+index+"' id='spec_code_"+index+"' size='5'> "+
					"<input type='text' id='spec_desc_"+index+"' name='spec_desc_"+index+"' id='spec_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callCommonValidationSpec(spec_desc_"+index+",spec_code_"+index+",clinic_"+index+",clinic_code_"+index+");}'> "+
					"<input type='button' id='spec_but_"+index+"' value='?' onclick='callCommonValidationSpec(spec_desc_"+index+",spec_code_"+index+",clinic_"+index+",clinic_code_"+index+")'> "+
				"</td>";
		newCell = newRow.insertCell();	
		
		var inclExclHtml = "<td class='fields' nowrap> "+
			"<Select id='type_"+index+"' name='type_"+index+"' id='type_"+index+"' onchange='clearBill("+index+")'> ";

			for(var x=0;x<inclExclCodeArr.length;x++){
			inclExclHtml = inclExclHtml+"<option value='"+inclExclCodeArr[x]+"'>"+inclExclDescArr[x]+"</option> ";
			}
			inclExclHtml = inclExclHtml+"</select> "+
					"</td> ";
			newCell.innerHTML = inclExclHtml;
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<input type='text' readonly id='bg_code_"+index+"' name='bg_code_"+index+"' id='bg_code_"+index+"' size='12' value=''> "+
					"<input type='text' id='bg_desc_"+index+"' name='bg_desc_"+index+"' id='bg_desc_"+index+"' size='20' onblur='if(this.value.length>0){ callBGDesc(2,type_"+index+",bg_desc_"+index+",bg_code_"+index+");}'> "+
					"<input type='button' id='bg_but_"+index+"' value='?' onclick='callBGDesc(2,type_"+index+",bg_desc_"+index+",bg_code_"+index+")'> "+		
		"</td>";
		
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<input type='text' id='preAppAmt_"+index+"' onkeypress='return checkForSpecChars(event)' name='preAppAmt_"+index+"' id='preAppAmt_"+index+"' size='10' maxlength='10' onblur='checkForNumberDecimal(this)'> "+
					"&nbsp;&nbsp;<select name='AmtMode_"+index+"' id='AmtMode_"+index+"'> "+
						"<option value='G'>Gross</option> "+
						"<option value='N'>Net</option> "+
					"</select> "+
				"</td>";
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<input type='text' id='preAppQty_"+index+"' onkeypress='return checkAlpha(event)' name='preAppQty_"+index+"' id='preAppQty_"+index+"' size='10' maxlength='10' onblur='checkForNumber(this)'> "+
				"</td>";
		
		newCell = newRow.insertCell();
		var chk = 'serviceLmt_'+index;
		var link = 'serviceLink_'+index;
		newCell.innerHTML = "<td class='fields' nowrap> "+					
					"<input type='checkbox' id='serviceLmt_"+index+"' name='serviceLmt_"+index+"' id='serviceLmt_"+index+"'  > "+
				"</td>";
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<input type='text' id='effFrom_"+index+"' name='effFrom_"+index+"' id='effFrom_"+index+"' value='"+startDate+"' size='10' onblur='isValidDate(this);checkDateFrom(effFrom_"+index+");compareDates(effFrom_"+index+",effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendarLocal(1,"+index+")'; /> "+
				"</td>";
		
		newCell = newRow.insertCell();
		newCell.innerHTML = "<td class='fields' nowrap> "+
					"<input type='text' id='effTo_"+index+"' name='effTo_"+index+"' id='effTo_"+index+"' value='"+endDate+"' size='10' onblur='isValidDate(this);checkDateFrom(effTo_"+index+");compareDates(effFrom_"+index+",effTo_"+index+");'> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendarLocal(2,"+index+");' /> "+
					"<input type='hidden' name='rowStatus"+index+"' id='rowStatus"+index+"' value='I'> "+
					"</td>";
		
		newCell = newRow.insertCell();
		newCell.innerHTML =				"<td class='fields' nowrap> "+
		"<input type='checkbox' id='delFlag"+index+"' id='delFlag"+index+"' name='delFlag"+index+"' id='delFlag"+index+"'> "+
		"</td>";
		parent.PolicyDetailsPage.document.forms[0].inclRowCount.value = index;
		//alert(document.forms[0].inclRowCount.value);
		
	}
}

function removeRow(obj){
	if( obj == 'InclExcl'){
		frmObj = parent.PolicyDetailsPage.document.forms[0];
		var pageInfo = frmObj.pageInfo.value;
		xmlString=formXMLStringMain(frmObj);
		//updation=deleteFormValidation(xmlString,pageInfo);
		
		var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
		var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
		var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
		var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
		var startDate = ''//parent.PolicyInfoFrame.document.forms[0].startDate.value;
		var endDate = ''//parent.PolicyInfoFrame.document.forms[0].endDate.value;
		var priorityKey = parent.PolicyDetailsPage.document.forms[0].priorityKey.value;
		var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
		var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
		var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
		var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
		var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;		
		var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
		var policyNo = parent.PolicyDetailsPage.document.forms[0].policyNo.value;
		var policyEncounter = parent.PolicyDetailsPage.document.forms[0].policyEncounter.value;
		var facility_id = parent.PolicyDetailsPage.document.forms[0].facility_id.value;
		/*document.getElementById('inclExclCoverage').className = "tabClicked";
		document.getElementById('inclExclCoveragespan').className = "tabSpanclicked";
		document.getElementById('preApproval').className = "tabA";
		document.getElementById('preApprovalspan').className = "tabAspan";	*/
		//getXMLString('preApproval');
		updation=deleteFormValidation(xmlString,pageInfo,priorityKey);
		parent.PolicyDetailsPage.location.href = '../../eBL/jsp/CommonPolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
												'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
												'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if( obj == 'PreApproval'){
		frmObj = parent.PolicyDetailsPage.document.forms[0];
		var pageInfo = frmObj.pageInfo.value;
		xmlString=formXMLStringMain(frmObj);
		//updation=deleteFormValidation(xmlString,pageInfo);
		
		var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
		var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
		var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
		var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
		var startDate = ''//parent.PolicyInfoFrame.document.forms[0].startDate.value;
		var endDate = ''//parent.PolicyInfoFrame.document.forms[0].endDate.value;
		var priorityKey = parent.PolicyDetailsPage.document.forms[0].priorityKey.value;
		var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
		var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
		var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
		var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
		var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;		
		var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
		var policyNo = parent.PolicyDetailsPage.document.forms[0].policyNo.value;
		var policyEncounter = parent.PolicyDetailsPage.document.forms[0].policyEncounter.value;
		var facility_id = parent.PolicyDetailsPage.document.forms[0].facility_id.value;
		/*document.getElementById('preApproval').className = "tabClicked";
		document.getElementById('preApprovalspan').className = "tabSpanclicked";
		document.getElementById('inclExclCoverage').className = "tabA";
		document.getElementById('inclExclCoveragespan').className = "tabAspan";	*/
		updation=deleteFormValidation(xmlString,pageInfo,priorityKey);
		parent.PolicyDetailsPage.location.href = '../../eBL/jsp/CommonPolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if( obj == 'PreApprovalPopup'){
		frmObj = parent.PolicyDetailsPage.document.forms[0];
		var pageInfo = frmObj.pageInfo.value;
		xmlString=formXMLStringMain(frmObj);
		//updation=deleteFormValidation(xmlString,"popup");
		
		var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
		var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
		var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
		var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
		var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
		var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
		var rowNumber = parent.PolicyDetailsPage.document.forms[0].rowNumber.value;
		var criteria = parent.PolicyDetailsPage.document.forms[0].criteria.value;
		var patClass = parent.PolicyDetailsPage.document.forms[0].patClass.value;
		var blngCode = parent.PolicyDetailsPage.document.forms[0].blngCode.value;
		var encEpsd = parent.PolicyDetailsPage.document.forms[0].encEpsd.value;
		var gender = parent.PolicyDetailsPage.document.forms[0].gender.value;
		var ageGroup = parent.PolicyDetailsPage.document.forms[0].ageGroup.value;
		var clinicNursInd = parent.PolicyDetailsPage.document.forms[0].clinicNursInd.value;	
		var clinicNursCode = parent.PolicyDetailsPage.document.forms[0].clinicNursCode.value;
		var spltyCode = parent.PolicyDetailsPage.document.forms[0].spltyCode.value;
		
		var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
		var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
		var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
		var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;	
		var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;
		var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
		
		var policyEncounter =  parent.PolicyDetailsPage.document.forms[0].policyEncounter.value;
		var facility_id =  parent.PolicyDetailsPage.document.forms[0].facility_id.value;
		var priorityKey = parent.PolicyDetailsPage.document.forms[0].priorityKey.value;
		updation=deleteFormValidation(xmlString,"popup",priorityKey);
		parent.PolicyDetailsPage.location.href = "../../eBL/jsp/CommonPolicyPreApprovalPopup.jsp?rowNumber="+rowNumber+"&criteria="+criteria+"&patClass="+patClass+"&blngCode="+blngCode+
		"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyEncounter='+policyEncounter+'&facility_id='+facility_id+
		"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;

	}
}

function deleteFormValidation(xmlStr,last_link,key)
{	
	//last_link = 'BILL_PRINT_FMT';
	//alert('last_link->'+last_link);
	//alert('event->'+event);
	//alert('xmlStr->'+xmlStr);
	var temp_jsp="CommonPolicyDeletePersistence.jsp?func_mode="+last_link+"&key="+key;


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		//alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	//alert('before');
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	//alert('after');
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

