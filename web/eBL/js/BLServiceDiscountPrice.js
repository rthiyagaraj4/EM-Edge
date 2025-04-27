/*Added by Rajesh Varadharajan - Contains JS fns related to Price Discount Add / Modify Screen
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-JU-SCF-0164		           Mohana Priya K
2	     	 V210310	        14525			MMS-JU-SCF-0164	           	   Mohana Priya K
3	     	 V210426	        16330			MMS-ME-SCF-0020-TF         	   Mohana Priya K
4	     	 V210519/V210601	18821			MMS-ME-SCF-0020-TP         	   MuthukumarN
5	     	 V210613			18821			MMS-ME-SCF-0020-TP         	   MuthukumarN
6	     	 V210623			20216			MMS-ME-SCF-0028-TF         	   MuthukumarN
7			 V211109			7871			MMS-QH-CRF-0128				   Manivel Natarajan
8			 V211115			25887			PMG2021-MMS-CRF-0004.1		   Nandhini M
9			 V160522						    MMS-QH-CRF-0128.4			   Nandhini M
10           V230410			40151			MOHE-SCF-0214-TF			   Mohanapriya
*/

var PHISflag = false; //added for PMG2021-MMS-CRF-0004.1 V211115

async function addRow(obj){
	if( obj == 'pricedtlbulk'){	
		var tbl = document.getElementById('Multipricebulkupd');
		var index = tbl.rows.length - 1;
		var prevIndex = index - 1;
		var parentDoc = document;
		var disabled = parent.frames[0].document.getElementById('disabled').value;
		var dateDisabled="";
		var dateReadonly= "";
		var rateIndDisabled = ""; 
		var setupAmendPrice="Y";
		var materialItemYN=parent.BLServiceDiscPrice.frmDiscPriceCreate.querySelector('#retValPH').value;
		var servInd = parent.BLServiceDiscPrice.document.getElementById('service_ind').value;
		
		var publicchk_disabled="";
		var price_ind_bot_disabled = "";
		var siteSpecNMC_disable="N";
		
		if(servInd == "PG")
			publicchk_disabled = "disabled";
		
		var newRow = tbl.insertRow();		
		var newCell = newRow.insertCell(); 
		newCell.className = 'fields';
		newCell.setAttribute('nowrap','');
		newCell.width="10%";								
		newCell.innerHTML = 
						"<input type='text' name='billing_class"+index+"'  id='billing_class"+index+"' size='20' maxlength='20' value='' onKeypress='validatedtls();'  onblur='if(this.value.length>0){  callCommonValidationDtls(1,billing_desc"+index+",billing_class"+index+","+index+"); } else{ fnClearCode(billing_class"+index+"); }'>&nbsp;"+						
						"<input type='button' class='button'  name='billing_class_btn"+index+"' id='billing_class_btn"+index+"' value='?' onClick='if(validatedtls()){ callCommonValidationDtls(1,billing_desc"+index+",billing_class"+index+","+index+");}' tabindex='2'>&nbsp;<img src='../../eCommon/images/mandatory.gif'>"+
						"<input type='hidden' name='billing_desc"+index+"' id='billing_desc"+index+"' value='' >" +						
						"<input type='hidden' name='billingdesc"+index+"'  id='billingdesc"+index+"' value='' >" +
						"<input type='hidden' name='billingclass"+index+"'  id='billingclass"+index+"' value='' >" +
						"<input type='hidden' name='rowMode_"+index+"'  id='rowMode_"+index+"' value='add' >" +
						"<input type='hidden' name='patCatCode_"+index+"'  id='patCatCode_"+index+"' value='' >";


		newCell.className = 'fields';
		newCell.setAttribute('nowrap',''); 
		newCell = newRow.insertCell();
		newCell.width="10%";
		newCell.innerHTML = 	
							"<select name='price_ind_bot"+index+"'  id='price_ind_bot"+index+"' onChange='if(validatedtls()){priceindbot(this,"+index+");}'>"+
							"<option value=''>Select</option> "+
							"<option value='R' "+publicchk_disabled+">Rate</option> "+
							"<option value='F'>Factor</option> "+      					
						"</select>" +
						"<input type='hidden' name='priceindbot"+index+"'  id='priceindbot"+index+"' value='' >&nbsp;"+
						"<img src='../../eCommon/images/mandatory.gif'>";
					 
		newCell.className = 'fields';
		newCell.setAttribute('nowrap','');
		newCell = newRow.insertCell();
		newCell.width="20%";		
		newCell.innerHTML = 
					"<input type='text' name='effFromDate"+index+"'  id='effFromDate"+index+"' size='10' maxlength='10' onBlur='isValidDate(this,\"EF\","+index+");checkDates("+index+");callValidateDate("+index+")' value=''/>&nbsp;"+
					"<img src='../../eCommon/images/CommonCalendar.gif'  id='effFromDate_ctrl"+index+"' onClick='if(validatedtls()){return showCalendar(\"effFromDate"+index+"\");}' />&nbsp;" +
					"<img src='../../eCommon/images/mandatory.gif'>&nbsp;"+
					"<input type='hidden' name='effFrmDate"+index+"'  id='effFrmDate"+index+"' value='' >&nbsp;";
		newCell.className = 'fields';
		newCell.setAttribute('nowrap','');
		newCell = newRow.insertCell();	
		newCell.width="20%";			
			newCell.innerHTML = 
			"<input type='text' name='effToDate"+index+"' id='effToDate"+index+"' size='10' maxlength='10' onBlur='isValidDate(this,\"ET\","+index+");checkDates("+index+");' value=''/>&nbsp;"+
			"<img src='../../eCommon/images/CommonCalendar.gif'  id='effToDate_ctrl"+index+"' onClick='if(validatedtls()){return showCalendar(\"effToDate"+index+"\");}' />"+
			"<input type='hidden' name='efftodate"+index+"' id='efftodate"+index+"'  value='' >&nbsp;";
			newCell.className = 'fields';
			newCell.setAttribute('nowrap','');
			newCell = newRow.insertCell();
			newCell.width="10%";		
		newCell.innerHTML = 
		"<input type='text' name='discPer_ip"+index+"'  id='discPer_ip"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"ip\");}else{ fnClearCode(discPer_ip"+index+"); }' size='10' maxlength='10'  value='' />"+
		"<input type='hidden' name='discPerip"+index+"' id='discPerip"+index+"' value='' >&nbsp;";
			newCell.className = 'fields';
			newCell.setAttribute('nowrap',''); 
			newCell = newRow.insertCell();
		newCell.width="10%";
		newCell.style="padding-left:0px";
		newCell.innerHTML = 
		"<input type='text' name='discPer_op"+index+"'  id='discPer_op"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"op\");}else{ fnClearCode(discPer_op"+index+"); }' size='10' maxlength='10' value='' />"+
		"<input type='hidden' name='discPerop"+index+"'  id='discPerop"+index+"' value='' >&nbsp;";
			newCell.className = 'fields';
			newCell.setAttribute('nowrap',''); 
			newCell = newRow.insertCell();
			newCell.width="10%";
		newCell.innerHTML = 
		"<input type='text'name='discPer_em"+index+"' id='discPer_em"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"em\");}else{ fnClearCode(discPer_em"+index+"); }' size='10' maxlength='10' value='' />"+
		"<input type='hidden' name='discPerem"+index+"'  id='discPerem"+index+"' value='' >&nbsp;";
			newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell();
					newCell.width="10%";
			newCell.innerHTML = 
			"<input type='text' name='discPer_ex"+index+"'  id='discPer_ex"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"ex\");}else{ fnClearCode(discPer_ex"+index+");}' size='10' maxlength='10' value='' />"+
			"<input type='hidden' name='discPerex"+index+"'  id='discPerex"+index+"' value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell();
					newCell.width="10%";		
			newCell.innerHTML = 
			"<input type='text'  name='discPer_dc"+index+"'  id='discPer_dc"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"dc\");}else{fnClearCode(discPer_dc"+index+");}' size='10' maxlength='10'  value='' />"+
			"<input type='hidden' name='discPerdc"+index+"' id='discPerdc"+index+"' value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell(); 
					newCell.width="10%";
			newCell.innerHTML = 
			"<select name='applicability"+index+"' id='applicability"+index+"' onChange='if(validatedtls()){applicabilitychg(this,"+index+");}'>"+
			"<option value=''>Select</option> "+
			"<option value='G' selected>Gross</option> "+   
			"<option value='N'>Net</option> "+ 
      				"</select>"+
					"<input type='hidden' name='Applicability"+index+"'  id='Applicability"+index+"' value='' >&nbsp;"+
					"<img src='../../eCommon/images/mandatory.gif'>";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();
					newCell.width="10%";
			newCell.innerHTML = 
			"<input type='text' name='base_qty"+index+"' id='base_qty"+index+"'  onkeypress='return checkForNumChars(event)' onblur='if(validatedtls()){checkForNumber(this,"+index+");}else{ fnClearCode(base_qty"+index+");}' size='10' maxlength='10' value='' />"+
			"<input type='hidden' name='baseqty"+index+"' id='baseqty"+index+"'  value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();						
					newCell.width="5%";
					var pubChkStr = 
	      				"<input type='checkbox' name='public_chk"+index+"'  id='public_chk"+index+"' onclick='if(validatedtls()){fnPublicChk(this,"+index+");}' value='' >"+
						"<input type='hidden' name='publicchk"+index+"' id='publicchk"+index+"'  value='' >&nbsp;";
					
					if(materialItemYN=="Y"){
						pubChkStr = pubChkStr + "<img id ='isPublicMandEnableYN_"+index+"' src='../../eCommon/images/mandatory.gif' style='visibility:visible'>";
					} else {
						pubChkStr = pubChkStr + "<img id ='isPublicMandEnableYN_"+index+"' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>";						
					}
						
					newCell.innerHTML = pubChkStr;
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();
					
					if(materialItemYN=="Y"){
						newCell.width="10%";
			newCell.innerHTML = 
			"<select name='rateBasisInd"+index+"' id='rateBasisInd"+index+"' onChange='if(validatedtls()){rateBasisInd(this,"+index+");}'>"+
						"<option value=''>Select</option> "+
						"<option value='B'>Base Price</option> "+   
						"<option value='C'>Average Cost</option> "+ 
						"<option value='V'>Computed Value</option> "+
					"</select>"+					
					"<img id ='isBasisEnableYN_"+index+"' src='../../eCommon/images/mandatory.gif' style='visibility:visible'>"+
					
						"<input type='hidden' name='rate_Basis_Ind"+index+"'  id='rate_Basis_Ind"+index+"' value='' >&nbsp;";
					}
					else{
						newCell.width="10%";
						newCell.innerHTML = 
			"<select name='rateBasisInd"+index+"' id='rateBasisInd"+index+"' onChange='if(validatedtls()){rateBasisInd(this,"+index+");}'>"+
						"<option value=''>Select</option> "+
						"<option value='B'>Base Price</option> "+   
						"<option value='C'>Average Cost</option> "+ 
						"<option value='V'>Computed Value</option> "+
					"</select>"+	
					"<img id ='isBasisEnableYN_"+index+"' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>"+					
						"<input type='hidden' name='rate_Basis_Ind"+index+"'  id='rate_Basis_Ind"+index+"' value='' >&nbsp;";
					}
						
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();
					newCell.width="10%";
				newCell.innerHTML = 
				"<input type='text' name='min_charge"+index+"' id='min_charge"+index+"'  onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"mc\");}else{fnClearCode(min_charge"+index+");}' size='10' maxlength='10' value='' />"+
				"<input type='hidden' name='mincharge"+index+"' id='mincharge"+index+"'  value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();
					newCell.width="10%";
				newCell.innerHTML = 
				"<input type='text' name='max_charge"+index+"' id='max_charge"+index+"'  onkeypress='return checkForSpecChars(event)' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"maxc\");}else{fnClearCode(max_charge"+index+");}' size='10' maxlength='10' value=''/>"+
				"<input type='hidden' name='maxcharge"+index+"' id='maxcharge"+index+"'  value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell();
					newCell.width="10%";
				newCell.innerHTML = 
      				"<input type='checkbox' name='checkCostAvl"+index+"'  id='checkCostAvl"+index+"' onclick= 'if(validatedtls()){fnChkChkBox(this,"+index+");}' value='' />" +
					"<input type='hidden' name='checkcostavl_"+index+"'  id='checkcostavl_"+index+"' value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap',''); 
					newCell = newRow.insertCell();
					newCell.width="10%";
					
			newCell.innerHTML = 
			"<select name='cost_ind"+index+"' id='cost_ind"+index+"'  onchange='if(validatedtls()){costind(this,"+index+");}'>"+
      				    "<option value=''>Select</option> "+
						"<option value='A'>Amount</option> "+   
						"<option value='P'>Percentage</option> "+	
      				"</select>"+
					"<input type='hidden' name='costind"+index+"'  id='costind"+index+"' value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell();
					newCell.width="10%";
			newCell.innerHTML = 
			"<input type='text' name='cost_amt"+index+"'   id='cost_amt"+index+"' size='10' maxlength='10' onblur='if(validatedtls()){checkForNumberDecimal(this,"+index+",\"ca\");}else{fnClearCode(cost_amt"+index+");}' value='' />"+
			"<input type='hidden' name='costamt"+index+"'  id='costamt"+index+"' value='' >&nbsp;";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					newCell = newRow.insertCell();
					newCell.width="5%";
				newCell.innerHTML = 
      				"<input type='checkbox' name='apply_discount"+index+"'  id='apply_discount"+index+"' onclick='fnApplyDiscPrice(this,"+index+");' value='N'/>&nbsp;"+
      				"<a href='#' disabled onclick='showDisc("+index+")' class='"+disabled+"' name='dtls"+index+"' id='dtls"+index+"' value=''>Dtls</a>"+					
					"<input type='hidden' name='applydiscount"+index+"' id='applydiscount"+index+"'  value='N'/>"+
					"<input type='hidden' name='discStringForBlngClass_"+index+"' id='discStringForBlngClass_"+index+"'  value=''/>"+
					"<input type='hidden' name='discString"+index+"'  id='discString"+index+"' value=''/>"+					
					"<input type='hidden' name='indexSelected' id='indexSelected' value=''/>"+
					"<input type='hidden' name='isDiscountSavedYN_"+index+"'  id='isDiscountSavedYN_"+index+"' value='Y'/>"+	
					"<input type='hidden' name='isDiscSavedYN"+index+"'  id='isDiscSavedYN"+index+"' value=''/>";
					newCell.className = 'fields';
					newCell.setAttribute('nowrap','');
					
					parent.BLMultiPricedtls.document.forms[0].inclRowCnt.value = index;
	}
}
function addModify()
{
	var lastRowIndex=document.getElementById("lastRowIndex").value;
	var isDiscInsMod = document.getElementById("isDiscInsMod_"+lastRowIndex).value;
	var addBtn=document.getElementById("discBulkAdd").value;

	if(isDiscInsMod=="M"){
		parent.BLMultiDiscPrice.document.getElementById('discBulkAdd').disabled = true;	
		return true;
	}
	else{
		parent.BLMultiDiscPrice.document.getElementById('discBulkAdd').disabled = false;
		addRowDisc("discBulkAdd");		
	}	
}
function addRowDisc(obj){
	
	if( obj == 'discBulkAdd'){
		
		var tbl = document.getElementById('Multidiscbulkupd');
		var index = tbl.rows.length - 1;
		var prevIndex = index - 1;
		var parentDoc = document;
		//console.log(document.forms[0]);
	//	var disabled = document.forms[0].disabled.value;
		
		//var isDiscInsMod = parent.BLMultiDiscPrice.document.getElementById("isDiscInsMod").value;
		//var isDiscInsMod = document.forms[0].isDiscInsMod.value;
		
		var pat_cat_code = document.forms[0].pat_cat_code.value;
		var selBlngClass = document.forms[0].selBlngClass.value;	
		var noofdecimal = document.forms[0].noofdecimal.value;	

		var isServiceDiscountEnabledYN = document.forms[0].isServiceDiscountEnabledYN.value;	

		var ro_discValIP = "readonly";
		var ro_discValOP = "readonly";
		var ro_discValEM = "readonly";
		var ro_discValEX = "readonly";
		var ro_discValDC = "readonly";
		
		if(pat_cat_code == "I" || selBlngClass == "**") ro_discValIP = "";
		if(pat_cat_code == "O" || selBlngClass == "**") ro_discValOP = "";
		if(pat_cat_code == "E" || selBlngClass == "**") ro_discValEM = "";
		if(pat_cat_code == "X" || selBlngClass == "**") ro_discValEX = "";
		if(pat_cat_code == "D" || selBlngClass == "**") ro_discValDC = "";
		
		document.getElementById("lastRowIndex").value=prevIndex+1;
		
		var newRow = tbl.insertRow();
		
		var newCell = newRow.insertCell();  
		/*if(BillingClass.length<1 || FactorRate.length<1 || IP_amt.length<1 || OP_amt.length<1 || EM_amt.length<1 || EX_amt.length<1 || DC_amt.length<1 || Applicability.length<1 || BASE_QTY.length<1 || Public.length<1 ||Basis.length<1 ||MIN_CHARGE.length<1 || MAX_CHARGE.length<1 || ChkCostAvl.length<1 || CostIndicator.length<1 || CostAmt.length<1 || Disc.length<1 ) {
			alert("Please enter all mandatory fields");
			return false; 
		}*/			
		/*	newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+	
			"<select name='discInd"+index+"' id='discInd"+index+"' id='discInd"+index+"' onchange='addData(this,"+index+",\"discInd\")'>"+
      					"<option value=''>Select</option>"+
      						"<option value='A'>Amount </option>"+						
      						"<option value='P'>Percentage</option>"+
							"<img src='../../eCommon/images/mandatory.gif'>"+
      				"</select>"+
						"<input type='hidden' name='disc_Ind"+index+"' id='disc_Ind"+index+"' id='disc_Ind"+index+"' value='' >"+
      			"</td>";*/
		newCell.innerHTML = "<td width='20%' nowrap class='fields'>" + 
	    "<select name='discInd" + index + "' id='discInd" + index + "' onchange='addData(this," + index + ",\"discInd\")'>" +
	        "<option value=''>Select</option>" +
	        "<option value='A'>Amount</option>" +
	        "<option value='P'>Percentage</option>" +
	    "</select>" +
	    "<img src='../../eCommon/images/mandatory.gif' alt='Mandatory' style='margin-left: 5px; vertical-align: middle;'>" +
	    "<input type='hidden' name='disc_Ind" + index + "' id='disc_Ind" + index + "' value=''>" +
	"</td>";

		newCell.className = 'fields';
		newCell.style.nowrap="nowrap";
		
		if(isServiceDiscountEnabledYN == "Y"){		
			newCell = newRow.insertCell();		
			newCell.innerHTML = "<td nowrap class='fields'> "+
			"<input type='text' name='discUptoHrs"+index+"' id='discUptoHrs"+index+"' onkeypress='return ChkNumberInput(this,event,\"0\")' size='15' maxlength='3' value='' />";
			newCell.className = 'fields';
			newCell.style.nowrap="nowrap"; 
			
			newCell = newRow.insertCell();			
			newCell.innerHTML = "<td nowrap class='fields'> "+
			"<input type='text' name='discUptoPercAmt"+index+"' id='discUptoPercAmt"+index+"' onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\")' size='15' maxlength='15' value='' onblur='valDiscUptoPercAmt(this,document.forms[0].discInd"+index+")' />";
			newCell.className = 'fields';
			newCell.style.nowrap="nowrap";
		}

		newCell = newRow.insertCell();			
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text' name='discPer_ip"+index+"' id='discPer_ip"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,"+index+",\"IP\")) addData(this,"+index+",\"IP\")}' size='15' maxlength='15' value='' "+ro_discValIP+" />"+
		"<input type='hidden' name='ip_per"+index+"' id='ip_per"+index+"' value=''>"+
		"<input type='hidden' name='disc_Ind"+index+"' id='disc_Ind"+index+"' value=''>"+
		"</td>";
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();	
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text' name='discPer_op"+index+"' id='discPer_op"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,"+index+",\"OP\")) addData(this,"+index+",\"OP\")}' size='15' maxlength='15' value='' "+ro_discValOP+" />"+
		"<input type='hidden' name='op_per"+index+"' id='op_per"+index+"' value=''>"+
		"</td>";
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text'name='discPer_em"+index+"' id='discPer_em"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,"+index+",\"EM\")) addData(this,"+index+",\"EM\")}' size='15' maxlength='15' value='' "+ro_discValEM+" />"+
		"<input type='hidden' name='EM_per"+index+"' id='EM_per"+index+"' value=''>"+
		"</td>";
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text' name='discPer_ex"+index+"' id='discPer_ex"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,"+index+",\"EX\")) addData(this,"+index+",\"EX\")}' size='15' maxlength='15' value=''  "+ro_discValEX+" />"+
		"<input type='hidden' name='EX_per"+index+"' id='EX_per"+index+"' value=''>"+
		"</td>";
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text'  name='discPer_dc"+index+"' id='discPer_dc"+index+"' onkeypress='return checkForSpecChars(event)' onblur='if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,"+index+",\"DC\")) addData(this,"+index+",\"DC\")}' size='15' maxlength='15'  value='' "+ro_discValDC+" />"+
		"<input type='hidden' name='DC_per"+index+"' id='DC_per"+index+"' value=''>"+
		"</td>";
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<select name='discAppl"+index+"' id='discAppl"+index+"' onchange='addData(this,"+index+",\"discAppl\")'>"+
					"<option value=''>Select</option>"+
						"<option value='T'>Total Amount </option>"+
						"<option value='P'>Payable Amount</option>"+
						"<option value='X'>Payer</option>"+
						"<option value='C'>Patient</option>"+							
				"</select>"+
				"<img src='../../eCommon/images/mandatory.gif'>"+
				"<input type='hidden' name='disc_appl"+index+"' id='disc_appl"+index+"' value=''>"+
				"</td>";
				
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap";
		
		newCell = newRow.insertCell();		
		newCell.innerHTML = "<td width='20%' nowrap class='fields'> "+
		"<input type='text' name='discFromDate"+index+"' id='discFromDate"+index+"' size='15' maxlength='15' onBlur='if(isValidDate(this)){if(validateDiscDate("+index+")) addData(this,\""+index+"\",\"discfromdate\")}' value=''/>"+
		"<img src='../../eCommon/images/CommonCalendar.gif'  id='discFromDate_ctrl"+index+"' onClick='return showCalendar(\"discFromDate"+index+"\");' />&nbsp;" +
		"<img src='../../eCommon/images/mandatory.gif'>&nbsp;"+
		"<input type='hidden' name='discFrmDate"+index+"' id='discFrmDate"+index+"' value=''>"+
		"</td>"; 
		
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap"; 
		
		newCell = newRow.insertCell();				
		var temp_str = "<td width='20%' nowrap class='fields'> "+
		"<input type='text' name='disToDate"+index+"' id='disToDate"+index+"' size='15' maxlength='15' onBlur='if(isValidDate(this)){if(validateDiscDate("+index+")) addData(this,"+index+",\"discToDate\")}' value=''/>"+
		" <img src='../../eCommon/images/CommonCalendar.gif'  id='discToDate_ctrl' onClick='return showCalendar(\"disToDate"+index+"\");' />"+
		"<input type='hidden' name='discToDate"+index+"' id='discToDate"+index+"' value=''>"+
		"<input type='hidden' name='discDtls"+index+"' id='discDtls"+index+"' value=''>"+
		"<input type='hidden' name='isDiscInsMod_"+index+"' id='isDiscInsMod_"+index+"' value='I'>";

		if(isServiceDiscountEnabledYN == "N"){	
			temp_str = temp_str + "<input type='hidden' name='discUptoHrs"+index+"' id='discUptoHrs"+index+"' value=''>";
			temp_str = temp_str + "<input type='hidden' name='discUptoPercAmt"+index+"' id='discUptoPercAmt"+index+"' value=''>";
		}

		temp_str = temp_str + "</td>";		
		newCell.innerHTML = temp_str;
		newCell.className = 'fields';
		newCell.style.nowrap="nowrap";
				
		parent.BLMultiDiscPrice.document.forms[0].inclRowCount.value = index;
	}
}
//added against MMS-QH-CRF-0128.4 starts
 function modifyDisc(idx)
{
	var mode= parent.BLMultiDiscPrice.document.getElementById("mode").value;
	//var addBtn= parent.BLMultiDiscPrice.document.getElementById("discBulkAdd").value;
	if(mode=="loaddisc")
	{
	parent.BLMultiDiscPrice.document.getElementById('discBulkAdd').disabled = true;	
	}
	else{
		addRowDisc(idx);
	}
} 
function alrdSelect(index){
	var previndx=document.forms[0].prevClicked.value;
	if(previndx==index){
		return false;
	}else{
		return true;
	}
}
function showDisc(index){
	var discStringForBlngClass = document.getElementById("discStringForBlngClass_"+index).value;
	var dtlsED=document.getElementById("apply_discount"+index).value;
	var selBlngClass = document.getElementById("billing_class"+index).value;

	if(selBlngClass == ''){
		alert("Billing Class cannot be blank");
		document.getElementById("billing_class"+index).focus();
		return false;
	}
	//alert(discStringForBlngClass);
	if(dtlsED=='Y'){
		if(discStringForBlngClass.length>0){
			parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp?mode=loaddisc&discstr='+discStringForBlngClass+"&selBlngClass="+selBlngClass;
		}else{
			parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp?mode=dtls'+"&selBlngClass="+selBlngClass;
		}
	}
}

function showDiscMod(index){
	var discStringForBlngClass = document.getElementById("discStringForBlngClass_"+index).value;
	var selBlngClass = document.getElementById("billing_class"+index).value;
	document.getElementById("indexSelected").value=index;
	if(selBlngClass == ''){
		alert("Billing Class cannot be blank");
		document.getElementById("billing_class"+index).focus();
		return false;
	}
	if(discStringForBlngClass.length>0){
		parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp?mode=loaddisc&discstr='+discStringForBlngClass+"&selBlngClass="+selBlngClass;
	}else{
		parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp?mode=dtls'+"&selBlngClass="+selBlngClass;
	}
}
function saveDiscDtls(){
	document.forms[0].discBulkSave.disabled=true;
	var lastRowIndex=document.getElementById("lastRowIndex").value;
	//added against MMS-QH-CRF-0128.4
	var priceIdx=parent.BLMultiPricedtls.document.getElementById("indexSelected").value;

	parent.BLMultiPricedtls.document.getElementById("discString"+priceIdx).value="";
	var discStringForBlngClass = "";
	for(var i=1;i<=lastRowIndex;i++){
		var disc_Ind= document.getElementById("disc_Ind"+i).value;
		if(disc_Ind == "") disc_Ind = " ";
		var ip_per= document.getElementById("ip_per"+i).value;
		if(ip_per == "") ip_per = " ";
		var op_per= document.getElementById("op_per"+i).value;
		if(op_per == "") op_per = " ";
		var EM_per= document.getElementById("EM_per"+i).value;
		if(EM_per == "") EM_per = " ";
		var EX_per= document.getElementById("EX_per"+i).value;
		if(EX_per == "") EX_per = " ";
		var DC_per= document.getElementById("DC_per"+i).value;
		if(DC_per == "") DC_per = " ";		
		var disc_appl= document.getElementById("disc_appl"+i).value;
		if(disc_appl == "") disc_appl = " ";
		var discFrmDate= document.getElementById("discFrmDate"+i).value;
		if(discFrmDate == "") discFrmDate = " ";
		var discToDate= document.getElementById("disToDate"+i).value;
		if(discToDate == "") discToDate = " ";
		var isDiscInsMod = document.getElementById("isDiscInsMod_"+i).value;
		if(isDiscInsMod == "") isDiscInsMod = "I";	//128.4
		//alert("discToDate-"+discToDate);
		var discUptoHrs = document.getElementById("discUptoHrs"+i).value;
		if(discUptoHrs == "") discUptoHrs = " ";
				//alert("discUptoHrs:"+discUptoHrs);
		var discUptoPercAmt = document.getElementById("discUptoPercAmt"+i).value;
		if(discUptoPercAmt == "") discUptoPercAmt = " ";
				//alert("discUptoPercAmt:"+discUptoPercAmt);
		document.getElementById("discDtls"+i).value=disc_Ind+"::"+ip_per+"::"+op_per+"::"+EM_per+"::"+EX_per+"::"+DC_per+"::"+disc_appl+"::"+discFrmDate+"::"+discToDate+"::"+isDiscInsMod+"::"+discUptoHrs+"::"+discUptoPercAmt+"::"+",";

		parent.BLMultiPricedtls.document.getElementById("discString"+priceIdx).value+=document.getElementById("discDtls"+i).value;

		//parent.BLMultiPricedtls.document.getElementById("discStringForBlngClass_"+priceIdx).value += document.getElementById("discDtls"+i).value;
		discStringForBlngClass = discStringForBlngClass + document.getElementById("discDtls"+i).value;
		
		//discstr=discdtls;
	}
	parent.BLMultiPricedtls.document.getElementById("isDiscSavedYN"+priceIdx).value="Y";//128.4
	parent.BLMultiPricedtls.document.getElementById("discStringForBlngClass_"+priceIdx).value = discStringForBlngClass;
	//alert("483==>"+parent.BLMultiPricedtls.document.getElementById("discStringForBlngClass_"+priceIdx).value);
	parent.BLMultiDiscPrice.location.href="../../eCommon/html/blank.html"; //128.4
}

function checkForNull(obj){
	if(obj!=""){
		return obj;
	}
	
}

function servOnChange(val)
	{
		document.getElementById('service_ind').value=val.value;
	}
	
//V211109
function checkPGSelection(){
	var servInd = parent.BLServiceDiscPrice.document.getElementById('service_ind');
	servInd = servInd.options[servInd.selectedIndex].value;
	var priceInd = parent.BLServiceDiscPrice.document.getElementById('price_ind');
	var priceIndValue = priceInd.options[priceInd.selectedIndex].value;
	var frm2 = parent.BLMultiPricedtls.Pricedtlsbulkadd;
	var inclRowCnt = parent.BLMultiPricedtls.Pricedtlsbulkadd.inclRowCnt.value;	

	for(var j=1;j<=inclRowCnt;j++){
		var temp = "price_ind_bot"+j;
		
		var price_ind_bot = parent.BLMultiPricedtls.document.getElementById('price_ind_bot'+j);
		//alert("price_ind_bot:"+price_ind_bot);
		if(servInd == 'PG' && ( priceIndValue != 'B' && priceIndValue != 'C')){
			for(var i=0; i < priceInd.length; i++)
			{
				if(priceInd.options[i].value == 'S' || priceInd.options[i].value == 'P')
					priceInd.options[i].disabled = true;
			}
			priceInd.value = '';

			for(var i=0; i < price_ind_bot.length; i++)
			{
				if(price_ind_bot.options[i].value == 'R')
					price_ind_bot.options[i].disabled = true;
			}
			price_ind_bot.value = '';
		} else {
			for(var i=0; i < priceInd.length; i++)
			{
				if(priceInd.options[i].value == 'S' || priceInd.options[i].value == 'P')
					priceInd.options[i].disabled = false;
			}
			priceInd.value = '';
			
			for(var i=0; i < price_ind_bot.length; i++)
			{
				if(price_ind_bot.options[i].value == 'R')
					price_ind_bot.options[i].disabled = false;
			}
			price_ind_bot.value = '';
		}
	}
}	
	
function clearBGDesc(obj){
		
	var frm = parent.BLServiceDiscPrice.frmDiscPriceCreate;	
	var isPkgGrpEnabledYN = document.getElementById('isPkgGrpEnabledYN').value;	
	
	if(obj == 'servInd'){
		var serv_ind=document.getElementById('service_ind').value;
		frm.service_code.value = '';
		frm.service_desc.value = '';
		
		//V211109
		if(isPkgGrpEnabledYN)
			checkPGSelection();		
		
	}
	else if(obj = 'priceInd'){
		var service_code=document.getElementById('service_code').value;
		
		if(service_code==''){
			alert("Please Select Service Code");
			document.getElementById('price_ind').value='Y';
			document.forms[0].service_code.focus();
			return false;
			
		}
		//defaultCostIndicator(); //V21022022
		frm.price_code.value = '';
		frm.price_desc.value = '';
		frm.cust_grp_code.value = '';
		frm.cust_code.value = '';
		frm.cust_desc.value = '';
		frm.cust_grp_desc.value = '';
		frm.policy_code.value = '';
		frm.policy_desc.value = '';

		//V211109
		var servInd = document.getElementById('service_ind');
		servInd = servInd.options[servInd.selectedIndex].value;
		var priceInd = document.getElementById('price_ind');
		priceInd = priceInd.options[priceInd.selectedIndex].value;
		parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#service_ind").value = servInd; //V21022022
		parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_ind").value = priceInd; //V21022022	
		
		if(servInd == 'PG' && ( priceInd != 'B' && priceInd != 'C')){
			alert("Selected Price Indicator is not applicable for Package Group");
			document.getElementById('price_ind').value = '';
			parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_ind").value='';//V21022022
			return false;
		} // V211109
			
			if('C'!=(document.getElementById('price_ind').value)){
			document.getElementById('price_code').disabled = false;
			document.getElementById('price_code_btn').disabled = false;
			document.getElementById('price_desc').disabled = false;
			
			document.getElementById('cust_grp_code').disabled = true;
			document.getElementById('cust_grp_code_btn').disabled = true;
			document.getElementById('cust_grp_desc').disabled = true;
			document.getElementById('cust_code').disabled = true;
			document.getElementById('custBtn').disabled = true;
			document.getElementById('cust_desc').disabled = true;
			
			document.getElementById('policy_code').disabled = true;
			document.getElementById('policy_code_btn').disabled = true;
			document.getElementById('policy_desc').disabled = true;
		}
		else{
			document.getElementById('price_code').disabled = true;
			document.getElementById('price_code_btn').disabled = true;
			document.getElementById('price_desc').disabled = true;
			
			document.getElementById('cust_grp_code').disabled = false;
			document.getElementById('cust_grp_code_btn').disabled = false;
			document.getElementById('cust_grp_desc').disabled = false;
			document.getElementById('cust_code').disabled = false;
			document.getElementById('custBtn').disabled = false;
			document.getElementById('cust_desc').disabled = false;
			
			document.getElementById('policy_code').disabled = false;
			document.getElementById('policy_code_btn').disabled = false;
			document.getElementById('policy_desc').disabled = false;
		}
	}	
}
async function callCommonValidation(sqlSelect,obj,code,called){
	//alert("6");
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	var cust_grp_code ="";
	var price_code="";
	var cust_code="";
	var price_ind= document.forms[0].price_ind.value;
	if(price_ind!='' && price_ind=='C')
	{
		cust_code = document.forms[0].cust_code.value;
		
	}
	else{
		cust_code = document.forms[0].price_code.value;
	}
	cust_grp_code = document.forms[0].cust_grp_code.value;
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var code1='';
	var obj1='';
	switch(sqlSelect){			
	case 1:
	{
		code1 =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#cust_grp_code").value;
		obj1  =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#cust_grp_desc").value;
			
		sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
		"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
		"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
		"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
		"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
		" order by 2";
		
		
		title = 'Customer Group';
		break;
	}
	case 2:
	{		
			if(cust_grp_code==""||cust_grp_code=="null"){
			
				alert("Please Enter Cust Group Code");
				document.forms[0].cust_grp_code.focus();
				return true;
			} 
			else if(cust_code==""||cust_code=="null"){				
					alert("Please Enter Cust Code");
					document.forms[0].cust_code.focus();
					return true;
			}

		sql="SELECT description, code FROM (SELECT DISTINCT a.long_desc description, a.policy_type_code code FROM bl_ins_policy_types_lang_lvvw a,  bl_ins_policy_type_hdr_lvvw b WHERE NVL (a.status, 'A') != 'S' AND a.operating_facility_id = '"+facility_id+"' AND UPPER (a.language_id) = UPPER ('"+locale+"') AND a.operating_facility_id = b.operating_facility_id AND a.policy_type_code = b.policy_type_code AND ( b.cust_group_code = NVL ('"+cust_grp_code+"', b.cust_group_code) OR ('"+cust_grp_code+"' = '**' AND 1 = 1) ) AND ( b.cust_code = NVL ('"+cust_code+"', b.cust_code) OR ('"+cust_code+"' = '**' AND 1 = 1))) WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?) ORDER BY 2 ";//Added against V210601

		title = 'Policy';
		break;
	}	
	case 3:
	{
		sql="Select description, code from (SELECT Short_Desc DESCRIPTION, Blng_Class_Code CODE  FROM BL_BLNG_CLASS_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Billing Class','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Class';
		break;
	}			
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		
		code.value = arr[0];	
		
		obj1 = arr[1];
		code1 = arr[0];	
	}
	else
	{
		obj.value = '';
		code.value = '';	
		obj1.value = '';
		code1.value = '';		
		//obj.value = returnedValues[1];
	}
}
async function callCommonValidationDtls(sqlSelect,obj,code,i){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	var cust_grp_code ="";
	var cust_code="";
	
	//Added against MMS-ME-SCF-0010 Ends
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var code1='';
	var obj1='';
	switch(sqlSelect){			
		
	case 1:
	{
		code1 =document.getElementById("billingclass"+i);
		obj1  =document.getElementById("billingdesc"+i);
		//sql="Select description, code from (SELECT Short_Desc DESCRIPTION, Blng_Class_Code CODE  FROM BL_BLNG_CLASS_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Billing Class','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Class';
		sql="BLINTERNALREP_7::blsql::"+locale+"::";//V230410
		break;
	}			
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		
		code.value = arr[0];	
		
		obj1.value = arr[1];
		code1.value = arr[0];
		patientCategory(i);
		
		
	}
	else
	{
		obj.value = arr[1];;
		code.value = arr[0];;	
		obj1.value = arr[1];;
		code1.value = arr[0];;		
		//obj.value = returnedValues[1];
	}
}
 function callValidateDate(index){
	var frm2 = parent.BLMultiPricedtls.Pricedtlsbulkadd;
	var count = frm2.querySelector("#inclRowCnt").value;
	var isNotDupl=false;
	
	if(frm2.querySelector("#billing_class"+index).value!='')
	{
		if(count>1)
		{
			for(var i=1;i<=count;i++)
			{
				if(index != i){
					if(document.getElementById('effFromDate'+index).value==document.getElementById('effFromDate'+i).value)
					{
						if(frm2.querySelector("#billing_class"+index).value==frm2.querySelector("#billing_class"+i).value)
						{ 
							isNotDupl=true;
						}
					}
				}
			} 
		}
	}
	else{
		alert("Billing Class cannot be blank");
		frm2.querySelector("#billing_class"+index).select();
		return false;
	}
	if(isNotDupl){
		alert("Duplicate Record Exists, Same Billing Class Exist");
		//document.getElementById('billing_class'+index).value='';
		frm2.querySelector("#effFromDate"+index).focus();
		return false;
	}else{
		//alert("else==>")
		//pricearr.push(val.value);
	}
} 
 

async function callCommonValidationCode(sqlSelect,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	//V210613
	var cust_grp_code = document.forms[0].cust_grp_code.value;
	var cust_code ='';
	//V210613
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var code1='';
	var obj1='';
	
	switch(sqlSelect){			
		case 1:
		{
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Customer Group';
			break;
		}
		case 2:
		{
			code1 =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#policy_code");
			obj1  =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#policy_desc");
			
			cust_code = document.forms[0].price_code.value;

	sql="SELECT description, code FROM (SELECT DISTINCT a.long_desc description, a.policy_type_code code FROM bl_ins_policy_types_lang_lvvw a, bl_ins_policy_type_hdr_lvvw b WHERE NVL (a.status, 'A') != 'S' AND a.operating_facility_id = '"+facility_id+"' AND UPPER (a.language_id) = UPPER ('"+locale+"') AND a.operating_facility_id = b.operating_facility_id AND a.policy_type_code = b.policy_type_code AND ( b.cust_group_code = NVL ('"+cust_grp_code+"', b.cust_group_code) OR ('"+cust_grp_code+"' = '**' AND 1 = 1) ) AND ( b.cust_code = NVL ('"+cust_code+"', b.cust_code) OR ('"+cust_code+"' = '**' AND 1 = 1))) WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?) ORDER BY 2 ";//Added against V210613

			title = 'Policy';
			break;
		}
		
		case 3:
		{
			code1 =document.getElementById("billingclass");
			obj1  =document.getElementById("billingdesc");
			
			sql="Select description, code from (SELECT Short_Desc DESCRIPTION, Blng_Class_Code CODE  FROM BL_BLNG_CLASS_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Billing Class','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Class';
			break;
		}
	case 4:
		{
			code1 =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#cust_code");
			obj1  =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#cust_desc");
			
			cust_code = document.forms[0].cust_code.value;
			if(cust_grp_code==""||cust_grp_code=="null"){				
					alert("Please Enter Cust Group Code");
					document.forms[0].cust_grp_code.focus();
					return true;
			}
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
			"Where Cust_Code In ( SELECT cust_code "+
            "FROM bl_cust_by_cust_group "+
            "WHERE cust_group_code = "+
             "DECODE ('"+cust_grp_code+"', "+
                     "'**', cust_group_code, '"+ cust_grp_code+
                            "')) "+
			"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
			"and nvl(patient_flag,'N')  ='Y' "+
			"and nvl(pat_com_flag,'N')='N' "+
			"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
			"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'CustCode';
			break;
		}		
	}

	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues =await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		code.value = arr[0];	
		obj1.value = arr[1];
		code1.value = arr[0];
	}
	else
	{
		obj.value = '';
		code.value = '';
		
		obj1.value = '';
		code1.value = '';		
		//obj.value = returnedValues[1];
	}
}
function callCommonValidationCodeDtls(sqlSelect,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	var cust_grp_code = document.forms[0].cust_grp_code.value;
	var cust_code ='';
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var code1='';
	var obj1='';
	
	switch(sqlSelect){			
		case 1:
		{
			code1 =document.getElementById("billingclass").value;
			obj1  =document.getElementById("billingdesc").value;
			
			sql="Select description, code from (SELECT Short_Desc DESCRIPTION, Blng_Class_Code CODE  FROM BL_BLNG_CLASS_lang_vw WHERE LANGUAGE_ID='"+locale+"' Union Select 'All Billing Class','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Class';
			break;
		}
	}	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
		obj1 = returnedValues[1];
		code1 = returnedValues[0];
	}
	else
	{
		obj.value = '';
		code.value = '';
		
		obj1.value = '';
		code1.value = '';		
		//obj.value = returnedValues[1];
	}
}
//added by nandhini for MMS-QH-CRF-128.4 Starts
 function changeFieldColor(obj){
	var prevClicked = document.forms[0].prevClicked.value;

	if(prevClicked.length>0){
		document.getElementById('billing_class'+prevClicked).className =  "fields";
		document.getElementById('price_ind_bot'+prevClicked).className =  "fields";
		document.getElementById('effFromDate'+prevClicked).className =  "fields";
		document.getElementById('effToDate'+prevClicked).className =  "fields";
		document.getElementById('discPer_ip'+prevClicked).className =  "fields";
		document.getElementById('discPer_op'+prevClicked).className =  "fields";
		document.getElementById('discPer_em'+prevClicked).className =  "fields";
		document.getElementById('discPer_ex'+prevClicked).className =  "fields";
		document.getElementById('discPer_dc'+prevClicked).className =  "fields";
		document.getElementById('applicability'+prevClicked).className =  "fields";
		document.getElementById('base_qty'+prevClicked).className =  "fields";
		document.getElementById('public_chk'+prevClicked).className =  "fields";
		document.getElementById('rateBasisInd'+prevClicked).className =  "fields";
		document.getElementById('min_charge'+prevClicked).className =  "fields";
		document.getElementById('max_charge'+prevClicked).className =  "fields";
		document.getElementById('checkCostAvl'+prevClicked).className =  "fields";
		document.getElementById('cost_ind'+prevClicked).className =  "fields";
		document.getElementById('cost_amt'+prevClicked).className =  "fields";
		document.getElementById('apply_discount'+prevClicked).className =  "fields";
	}
		//alert("967");		
		document.getElementById("indexSelected").value=obj;
		//alert("1005==>"+document.getElementById("indexSelected").value);
		document.getElementById('blng_class'+obj).className =  "YELLOW";
		document.getElementById('rateFactor'+obj).className =  "YELLOW";
		document.getElementById('effectiveFrmDate'+obj).className =  "YELLOW";
		document.getElementById('effectivetoDate'+obj).className =  "YELLOW";
		document.getElementById('disc_ip'+obj).className =  "YELLOW";
		document.getElementById('disc_op'+obj).className =  "YELLOW";
		//alert("975");
		document.getElementById('disc_em'+obj).className =  "YELLOW";
		document.getElementById('disc_ex'+obj).className =  "YELLOW";
		document.getElementById('disc_dc'+obj).className =  "YELLOW";
		document.getElementById('applblty'+obj).className =  "YELLOW";
		document.getElementById('base_quanty'+obj).className =  "YELLOW";
		document.getElementById('public_check'+obj).className =  "YELLOW";
		document.getElementById('rtbasisInd'+obj).className =  "YELLOW";
		document.getElementById('mini_chrg'+obj).className =  "YELLOW";
		document.getElementById('max_chrg'+obj).className =  "YELLOW";
		document.getElementById('costAval'+obj).className =  "YELLOW";
		document.getElementById('cost_indicator'+obj).className =  "YELLOW";
		document.getElementById('cost_amount'+obj).className =  "YELLOW";
		document.getElementById('apply_dis'+obj).className =  "YELLOW";
		document.forms[0].prevClicked.value = obj;
		//alert("988==>"+document.forms[0].prevClicked.value);
} 

function showDiscAvailable(index)
{
	var showdtls= document.getElementById("apply_discount"+index).value;
	if(showdtls=="Y"){
		showDisc(index);
	}
}
//added by nandhini for MMS-QH-CRF-128.4 ends
function fnClearCode(obj){
	obj.value = '';	
}

function isValidDate(obj,called,index){
	
	if(called=="ET")
	{
		if(document.getElementById('effFromDate'+index).value == ''){
		alert("Effective From Date cannot be blank");
		document.getElementById('effFromDate'+index).focus();
		return false;
	}
	}
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}
	
	return true;
}

function callBGDesc(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	var criteria = document.getElementById("service_ind").value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var flag='false';
	var frm = document.frmDiscPriceCreate;

	switch(sqlSelect){			
		case 1:
		{
			if(criteria == 'B'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';						
			}
			else if(criteria == 'BSG'){
				sql ="Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			} 
			else if(criteria == 'PG') { 
				sql = "Select description, code from (select short_desc description,package_serv_group_code code from bl_pkg_grp_hdr_lang_vw where nvl(discount_applicable_yn,'N') = 'Y' and upper(language_id) = upper('"+locale+"') and OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package Group';
			}
			else{
				alert('Please Select Service Indicator');
				drop.focus();
				return false;
			}
			break;
		}		
		case 2:
		{
			var cn = drop.value;
			if(cn == 'S'){
				sql="Select description, code from (select facility_name description,facility_id code from sm_facility_param WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Standard';
			}
			else if(cn == 'B'){
				sql = "Select description, code from (SELECT short_desc DESCRIPTION, blng_grp_id CODE  FROM bl_blng_grp_lang_vw WHERE upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Group';
			}	
			else if(cn == 'C'){
				sql = "Select description, code from (SELECT Short_Name DESCRIPTION, Cust_code CODE  FROM ar_customer_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND  acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Customer';
			}
			else if(cn == 'P'){
				sql = "Select description, code from (SELECT Short_Desc DESCRIPTION, Price_Class_Code CODE  FROM bl_price_class_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Price Class';
			}
			else{
				alert('Please Select Price Indicator');
				drop.focus();
				return false;
			}
			break;
		}	
	}
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
		flag='true';
	}
else
	{
		obj.value = '';
		code.value = '';		
		//obj.value = returnedValues[1];
	}

}
//added for PMG2021-MMS-CRF-0004.1 ends V211115

async function callBGDescCode(sqlSelect,drop,obj,code){
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityid.value;
	var criteria = document.getElementById("service_ind").value;//V210623
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var obj1 ="";
	var code1="";
	switch(sqlSelect){			
		case 1:
		{
			code1 =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#service_code").value;
			obj1  =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#service_desc").value;

			if(criteria == 'B'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'PG'){ //Loop added for V211109
				sql = "Select description, code from (select short_desc description,package_serv_group_code code from bl_pkg_grp_hdr_lang_vw where nvl(discount_applicable_yn,'N') = 'Y' and upper(language_id) = upper('"+locale+"') and OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package Group';				
			}
			else{
				alert('Please Select Service Indicator');
				drop.focus();
				return false;
			}
			break;
		}
		
		case 2:
		{
			code1 =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_code").value;
			obj1  =parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_desc").value;
			
			var cn = drop.value;
			if(cn == 'S'){
				sql="Select description, code from (select facility_name description,facility_id code from sm_facility_param WHERE LANGUAGE_ID = '"+locale+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Standard';
			}
			else if(cn == 'B'){
				sql = "Select description, code from (SELECT short_desc DESCRIPTION, blng_grp_id CODE  FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID='"+locale+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Group';
			}	
			else if(cn == 'C'){
				sql = "Select description, code from (SELECT Short_Name DESCRIPTION, Cust_code CODE  FROM ar_customer_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND  acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Customer';
			}
			else if(cn == 'P'){
				sql = "Select description, code from (SELECT Short_Desc DESCRIPTION, Price_Class_Code CODE  FROM bl_price_class_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Price Class';
			}
			else{
				alert('Please Select Price Indicator');
				drop.focus();
				return false;
			}
			break;
		}			
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',') ;
		}
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
		obj1 = returnedValues[1];
		code1 = returnedValues[0];
	}
else
	{
		obj.value = '';
		code.value = '';	
		obj1= '';
		code1 ='';
		//obj.value = returnedValues[1];
	}
}	

function fnChkChkBox(obj,idx){
	var frm = parent.BLServiceDiscPrice.frmDiscPriceCreate;
	var servInd = frm.document.getElementById('service_ind').value;
	var priceInd = frm.document.getElementById('price_ind').value;

	if(document.getElementById('checkCostAvl'+idx).checked && servInd=='B' && priceInd=='S')
	{
		document.getElementById('cost_ind'+idx).disabled = false;
		document.getElementById('cost_amt'+idx).readOnly = false;
		document.getElementById('checkcostavl_'+idx).value = "Y";
	}
	else
	{
		document.getElementById('cost_ind'+idx).disabled = true;
		document.getElementById('cost_amt'+idx).readOnly = true;
		document.getElementById('cost_ind'+idx).value='';
		document.getElementById('cost_amt'+idx).value='';
		document.getElementById('checkcostavl_'+idx).value = "N";
	}
}

function fnApplyDisc(){
	if(document.getElementById('apply_discount').checked)
	{
		if(document.getElementById('mode').value != "modify") {
			document.getElementById('discInd').disabled = false;
			document.getElementById('discFromDate').readOnly = false;
			document.getElementById('discToDate_ctrl').disabled = false;
			document.getElementById('discToDate').readOnly = false;
			document.getElementById('discFromDate_ctrl').disabled = false;
			document.getElementById('discPer_ip').readOnly = false;
			document.getElementById('discPer_op').readOnly = false;
			document.getElementById('discPer_em').readOnly = false;
			document.getElementById('discPer_ex').readOnly = false;
			document.getElementById('discPer_dc').readOnly = false;
			document.getElementById("discAppl").disabled = false;
			document.getElementById('enable').disabled = false;
			if(document.getElementById('mode').value == 'modify'){
				document.getElementById('discFromDate_ctrl').disabled = true;
				document.getElementById('discToDate_ctrl').disabled = true;
			}
		}
	}
	else{
		document.getElementById('discInd').disabled = true;
		document.getElementById('discFromDate').readOnly = true;
		document.getElementById('discFromDate_ctrl').disabled = true;
		/*document.getElementById('discToDate').readOnly = true;
		document.getElementById('discToDate_ctrl').disabled = true;*/	//Commented V190830-Aravindh/PMG2019-NMC-JD-CRF-0002
		document.getElementById('discPer_ip').readOnly = true;
		document.getElementById('discPer_op').readOnly = true;
		document.getElementById('discPer_em').readOnly = true;
		document.getElementById('discPer_ex').readOnly = true;
		document.getElementById('discPer_dc').readOnly = true;
		document.getElementById("discAppl").disabled = true;
		document.getElementById('enable').disabled = true;
		
		document.getElementById('discInd').value = '';	
		document.getElementById('discFromDate').value = '';
		document.getElementById('discToDate').value = '';
		document.getElementById('discPer_ip').value = '';
		document.getElementById('discPer_op').value = '';
		document.getElementById('discPer_em').value = '';
		document.getElementById('discPer_ex').value = '';
		document.getElementById('discPer_dc').value = '';
		document.getElementById("discAppl").value = '';
	}
}

//V211109

function addData(obj,ind,called){
	if(called=='IP'){
		document.getElementById('ip_per'+ind).value=obj.value;
	}
	else if(called=='OP'){
		document.getElementById('op_per'+ind).value=obj.value;
	}
	else if(called=='DC'){
		document.getElementById('DC_per'+ind).value=obj.value;
	}
	else if(called=='EM'){
		document.getElementById('EM_per'+ind).value=obj.value;
	}
	else if(called=='EX'){
		document.getElementById('EX_per'+ind).value=obj.value;
	}
	else if(called=='discAppl'){
		document.getElementById('disc_appl'+ind).value=obj.value;
		document.getElementById('discAppl'+ind).value=obj.value;
	}
	else if(called=='discInd'){
		document.getElementById('disc_Ind'+ind).value=obj.value;
		document.getElementById('discInd'+ind).value=obj.value;
	}	
	else if(called=='discfromdate'){
		document.getElementById('discFrmDate'+ind).value=obj.value;
	}
	else if(called=='discToDate'){
		document.getElementById('discToDate'+ind).value=obj.value;
	}
}

function fnDiscInd(obj,index){
	document.getElementById('discDtls'+index).value+="&discInd="+obj.value;
	
}

function fnRecord(){
	var frm = parent.BLServiceDiscPrice.frmDiscPriceCreate;
	var frm2 = parent.BLMultiPricedtls.Pricedtlsbulkadd;
	var params="";
	//var inclRowCnt = frm2.querySelector("#inclRowCnt").value;
	var inclRowCnt = frm2.querySelector("#inclRowCnt").value;
	//var showdtls= frm2.querySelector("#apply_discount"+inclRowCnt).value;
	var showdtls= frm2.querySelector("#apply_discount"+inclRowCnt).value;
	//var isDiscSavedYN=frm2.querySelector("#isDiscSavedYN"+inclRowCnt).value;
	var isDiscSavedYN=frm2.querySelector("#isDiscSavedYN"+inclRowCnt).value; //added by nandhini for MMS-QH-CRF-128.4 starts
	if(isDiscSavedYN=="N" && showdtls=="Y"){
		alert("Please Save Discount Details");
		return false;
	}
	//added by nandhini for MMS-QH-CRF-128.4 ends
	if(validateHeader()){
	
		for(i=1;i<=inclRowCnt;i++){
			var isDiscApplicableYN = frm2.querySelector("#applydiscount"+i).value;
			var discStringForBlngClass = frm2.querySelector("#discStringForBlngClass_"+i).value;
			var applicability = frm2.querySelector("#applicability"+i).value;		

		
			var billing_class = frm2.querySelector("#billing_class"+i);
			var price_ind_bot = frm2.querySelector("#price_ind_bot"+i);
			var effFromDate = frm2.querySelector("#effFromDate"+i);
			var discPer_ip = frm2.querySelector("#discPer_ip"+i);
			var discPer_op = frm2.querySelector("#discPer_op"+i);
			var discPer_em = frm2.querySelector("#discPer_em"+i);
			var discPer_ex = frm2.querySelector("#discPer_ex"+i);
			var discPer_dc = frm2.querySelector("#discPer_dc"+i);
			var patCatCode = frm2.querySelector("#patCatCode_"+i).value.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			var base_qty = frm2.querySelector("#base_qty"+i);		
			var public_chk = frm2.querySelector("#public_chk"+i);		
			var rateBasisInd = frm2.querySelector("#rate_Basis_Ind"+i);
			var retValPH = parent.BLServiceDiscPrice.frmDiscPriceCreate.retValPH.value;
			
			if(billing_class.value == ''){
				alert("Billing Class Cannot be blank");
				setTimeout(function () {
				    billing_class.focus();
				}, 10);
				//billing_class.value = "";
				//billing_class.focus();
				return false;
			}
			
			if(price_ind_bot.value == ''){
				alert("Please Select Rate/Factor");	
				setTimeout(function () {
				    price_ind_bot.focus();
				}, 10);
				//price_ind_bot.value = "";				
				//price_ind_bot.focus();
				return false;
			}
			
			if(effFromDate.value == ''){
				alert("Effective From Date Cannot be blank");
				setTimeout(function () {
				    effFromDate.focus();
				}, 10);
				//effFromDate.value = "";
				//effFromDate.focus();
				return false;
			}	

			if(billing_class.value == '**' ) {
				if(discPer_ip.value == '' && discPer_op.value == '' && discPer_em.value == '' && discPer_ex.value == '' && discPer_dc.value == '') {
					alert("One of the Amount should be entered for the Billing Class selected");
					return false;
				}
			}
			
			if(billing_class.value != '') {
				if(patCatCode == 'I' && discPer_ip.value == ''){
					alert("IP value cannot be blank");
					setTimeout(function () {
				    discPer_ip.focus();
				}, 10);
					//discPer_ip.value = "";
					//discPer_ip.focus();
					return false;				
				}

				if(patCatCode == 'O' && discPer_op.value == ''){
					alert("OP value cannot be blank");
					setTimeout(function () {
				    discPer_op.focus();
				}, 10);
					//discPer_op.value = "";
					//discPer_op.focus();
					return false;				
				}

				if(patCatCode == 'E' && discPer_em.value == ''){
					alert("EM value cannot be blank");
					setTimeout(function () {
				    discPer_em.focus();
				}, 10);
					//discPer_em.value = '';
					//discPer_em.focus();
					return false;				
				}

				if(patCatCode == 'X' && discPer_ex.value == ''){
					alert("EX value cannot be blank");
					setTimeout(function () {
				    discPer_ex.focus();
				}, 10);
					//discPer_ex.value = "";
					//discPer_ex.focus();
					return false;				
				}

				if(patCatCode == 'D' && discPer_dc.value == ''){
					alert("DC value cannot be blank");
					setTimeout(function () {
				    discPer_dc.focus();
				}, 10);
					//discPer_dc.value = "";
					//discPer_dc.focus();
					return false;				
				}				
			}
			
			if(isDiscApplicableYN == "Y" && discStringForBlngClass == "")
			{
				alert("Please define discount for the selected billing class");
				return false;
			}
			
			if(applicability == ""){
				alert("Please Enter Applicability");
				return false;
			}
			
			if(base_qty.value == ""){
				alert("Please Enter Base Quantity");
				// base_qty.focus();
				return false;
			}		
			
			if(retValPH == "Y"){
				
				if(public_chk.checked == false){
					alert("Public flag should be selected");
					return false;				
				}

				if(rateBasisInd.value == ""){
					alert("Basis Indicator cannot be blank");
					rateBasisInd.focus();
					return false;
				}
			}
			
			// Added for V211109 by Manivel Starts
			var minCharge = frm2.querySelector("#min_charge"+i).value;
			var rateFactor = frm2.querySelector("#price_ind_bot"+i).value;

			if(rateFactor == "R" && (minCharge == "" || minCharge == null)) {
				frm2.querySelector("#min_charge"+i).focus();
				alert(getMessage('BL00699','BL'));
				return false;
			}		
			// Added for V211109 by Manivel Ends				
			
		}

		var i=1;
		for(i=1;i<=inclRowCnt;i++){			
			params+= "&effFrmDte"+i+"="+ frm2.querySelector("#effFromDate"+i).value 	+
					"&efftodte"+i+"="+ frm2.querySelector("#effToDate"+i).value  	+
					"&discip"+i+"="+ frm2.querySelector("#discPer_ip"+i).value  	+
					"&discop"+i+"="+ frm2.querySelector("#discPer_op"+i).value  	+
					"&discem"+i+"="+ frm2.querySelector("#discPer_em"+i).value  	+
					"&discex"+i+"="+ frm2.querySelector("#discPer_ex"+i).value  	+
					"&discdc"+i+"="+ frm2.querySelector("#discPer_dc"+i).value  	+
					"&Applicab"+i+"="+ frm2.querySelector("#applicability"+i).value	+
					"&baseqnty"+i+"="+ frm2.querySelector("#base_qty"+i).value 		+
					"&publick"+i+"="+ frm2.querySelector("#public_chk"+i).value 	+	
					"&ratebase"+i+"="+ frm2.querySelector("#rateBasisInd"+i).value+
					"&minchar"+i+"="+ frm2.querySelector("#min_charge"+i).value 	+	
					"&maxchar"+i+"="+ frm2.querySelector("#max_charge"+i).value		+
					"&checkcost"+i+"="+ frm2.querySelector("#checkCostAvl"+i).value	+
					"&costindic"+i+"="+ frm2.querySelector("#cost_ind"+i).value 		+
					"&costamnt"+i+"="+ frm2.querySelector("#cost_amt"+i).value		+
					"&applydiscount"+i+"="+ frm2.querySelector("#applydiscount"+i).value	+
					"&priceind"+i+"="+ frm2.querySelector("#priceindbot"+i).value	+
					"&billingclass"+i+"="+ frm2.querySelector("#billing_class"+i).value +
					"&rowMode_"+i+"="+ frm2.querySelector("#rowMode_"+i).value +
					"&discStringForBlngClass"+i+"="+ frm2.querySelector("#discStringForBlngClass_"+i).value;
		}
		
		var facility = frm.querySelector("#facility").value;
		var service_ind = frm.querySelector("#service_ind").value;
		var service_code = frm.querySelector("#service_code").value;
		var service_desc = frm.querySelector("#service_desc").value;
		var price_ind   = frm.querySelector("#price_ind").value;
		var price_code = frm.querySelector("#price_code").value;
		var cust_grp_code = frm.querySelector("#cust_grp_code").value;
		var cust_grp_desc = frm.querySelector("#cust_grp_desc").value;
		var cust_code 		= frm.querySelector("#cust_code").value;
		var policy_code    = frm.querySelector("#policy_code").value;
		var policy_desc 	= frm.querySelector("#policy_desc").value;
		var mode 	= frm.querySelector("#mode").value;
		var inclRowCnt = frm2.querySelector("#inclRowCnt").value;
		
		var servhdr="&facility="+facility+"&service_ind="+service_ind+
					"&service_code="+service_code+"&cust_grp_code="+cust_grp_code+
					"&service_desc="+service_desc+"&cust_grp_desc="+cust_grp_desc+
					"&price_ind="+price_ind+"&cust_code="+cust_code+
					"&price_code="+price_code+"&policy_code="+policy_code+"&policy_desc="+policy_desc+'&inclRowCnt='+inclRowCnt;
		
		params+=servhdr;
		//alert("Final params to servlet==>"+params);
		frm2.action = "../../servlet/eBL.BLServiceDiscPriceCreateRecordServlet?mode="+mode+params;
		frm2.target = 'messageFrame1';
		frm2.submit();
		//BLMultiPricedtls.Pricedtlsbulkadd.target = 'messageFrame';
		//BLMultiPricedtls.Pricedtlsbulkadd.submit();
	
	}
}

function checkForSpecChars(event) {
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForNumberDecimal(obj,idx,called) {
	var BillingClass=parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#billing_class"+idx).value;
	var priceInd=parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_ind_bot"+idx).value;
	var effFromDate=parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#effFromDate"+idx).value;
	var patCatCode=parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#patCatCode_"+idx).value;	

	if(BillingClass==""){
		alert("Billing Class cannot be blank");
		parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#billing_class"+idx).focus();
		return false;
	}
	else if(priceInd==""){
		alert("Please Select Rate/Factor");
		parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#price_ind_bot"+idx).focus();
		return false;
	}
	else if(effFromDate==""){
		alert("Effective From Date cannot be blank");		
		parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#effFromDate"+idx).focus();
		return false;
	}
	var decArr = obj.value.split('.');
	if(decArr.length>2){
		alert(getMessage("NUM_ALLOWED", "SM"));
		obj.value = '';
		return false;
	}
	
	if(decArr == '0'){
		obj.value = '';
		return false;
	}
	if(decArr.length == 2){
		if(decArr[0].length<1 && decArr[1].length<1){
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value = '';
			return false;
		}
		else if(decArr[1].length>2){
			alert('Only Two Numbers are allowed beyond Decimal');
			obj.value = '';
			return false;
		}
	}
	
	if(called=='ip'){
		if(patCatCode == "I" && document.getElementById("discPer_ip"+idx).value == ''){
			alert("IP value cannot be blank");
			document.getElementById("discPer_ip"+idx).focus();
			document.getElementById("discPerip"+idx).value = "";
			return false;
		}
		document.getElementById("discPer_ip"+idx).value=obj.value;
		document.getElementById("discPerip"+idx).value=obj.value;				
	}else if(called=='op'){
		if(patCatCode == "O" && document.getElementById("discPer_op"+idx).value == ''){
			alert("OP value cannot be blank");
			document.getElementById("discPer_op"+idx).focus();
			document.getElementById("discPerop"+idx).value = "";
			return false;
		}				
		document.getElementById("discPer_op"+idx).value=obj.value;
		document.getElementById("discPerop"+idx).value=obj.value;
	}else if(called=='em'){
		if(patCatCode == "E" && document.getElementById("discPer_em"+idx).value == ''){
			alert("EM value cannot be blank");
			/*setTimeout(function () {
				document.getElementById("discPer_em"+idx).focus();
			}, 10);*/
			document.getElementById("discPer_em"+idx).focus();
			document.getElementById("discPerem"+idx).value = "";
			return false;
		}				
		document.getElementById("discPer_em"+idx).value=obj.value;
		document.getElementById("discPerem"+idx).value=obj.value; 
	}else if(called=='ex'){
		if(patCatCode == "X" && document.getElementById("discPer_ex"+idx).value == ''){
			alert("EX value cannot be blank");
			document.getElementById("discPer_ex"+idx).focus();
			document.getElementById("discPerex"+idx).value = "";
			return false;
		}				
		document.getElementById("discPer_ex"+idx).value=obj.value;
		document.getElementById("discPerex"+idx).value=obj.value;
	}else if(called=='dc'){
		if(patCatCode == "D" && document.getElementById("discPer_dc"+idx).value == ''){
			alert("DC value cannot be blank");
			document.getElementById("discPer_dc"+idx).focus();
			document.getElementById("discPerdc"+idx).value = "";
			return false;
		}				
		document.getElementById("discPer_dc"+idx).value=obj.value;
		document.getElementById("discPerdc"+idx).value=obj.value;
	}else if(called=='mc'){
		document.getElementById("min_charge"+idx).value=obj.value;
		document.getElementById("mincharge"+idx).value=obj.value;
	}else if(called=='maxc'){
		document.getElementById("max_charge"+idx).value=obj.value;
		document.getElementById("maxcharge"+idx).value=obj.value;
	}else if(called=='ca'){
		document.getElementById("cost_amt"+idx).value=obj.value;
		document.getElementById("costamt"+idx).value=obj.value;
	}
	return true;
}

function checkForNumber(obj,idx) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		 document.getElementById("baseqty"+idx).value=obj.value;
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
			document.getElementById("baseqty"+idx).value='';
            return false;
        } else {
			alert("Base Quantity cannot be blank");
			document.getElementById("baseqty"+idx).value='';
			//obj.focus();
			return false;
		}
    }
}

function checkForNumChars(event) {
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function fnCancel(){
	window.close();
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

//Added V190904-Aravindh/PMG-NMC-JD-CRF-0002/compareDates
function compareDates(from,to,messageFrame,messageId) {
	if (from.value != undefined) {
		from = from.value;
	}

	if (to.value != undefined) {
		to = to.value;
	}
	
    var fromarray; var toarray;
    var fromdate = from ;
    var todate = to ;
	//var arr = new Array(todate,fromdate);
    if(fromdate.length > 0 && todate.length > 0 ) {
        fromarray = fromdate.split("/");
        toarray = todate.split("/");
        var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
        var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
        
        if(Date.parse(todt) < Date.parse(fromdt)) {
			//var error = "APP-BL0863 Discount service period should be within the Billing service period";
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+messageId ;
            return false;
        } else if(Date.parse(todt) <= Date.parse(fromdt)) {
        	return true;
        }
    }
	return true;
}

function checkForDiscountEntry(){
	var mode = document.frmDiscPriceCreate.mode.value;
	if(mode != "modify" && !document.frmDiscPriceCreate.apply_discount.checked){
		document.getElementById('discInd').disabled = true;
		document.getElementById('discFromDate').readOnly = true;
		document.getElementById('discFromDate_ctrl').disabled = true;	
		document.getElementById('discToDate').readOnly = true;
		document.getElementById('discToDate_ctrl').disabled = true;			
		document.getElementById('discPer_ip').readOnly = true;
		document.getElementById('discPer_op').readOnly = true;
		document.getElementById('discPer_em').readOnly = true;
		document.getElementById('discPer_ex').readOnly = true;
		document.getElementById('discPer_dc').readOnly = true;
		document.getElementById("discAppl").disabled = true;
		document.getElementById('enable').disabled = true;
	}	
}

function validatedtls(idx)
{
	var facility=parent.BLServiceDiscPrice.frmDiscPriceCreate.facility.value;
	var price_ind=parent.BLServiceDiscPrice.frmDiscPriceCreate.price_ind.value;
	var service_ind=parent.BLServiceDiscPrice.frmDiscPriceCreate.service_ind.value;
	var service_code=parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;
	var price_code=parent.BLServiceDiscPrice.frmDiscPriceCreate.price_code.value;
	var cust_group_code=parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_grp_code.value;
	var cust_code=parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_code.value;
	var Policy_code=parent.BLServiceDiscPrice.frmDiscPriceCreate.policy_code.value;
	var frm=parent.BLMultiPricedtls.Pricedtlsbulkadd;
	//alert("1563,BillingClass===>"+BillingClass);
	
	if((service_ind!="" && service_ind=="A" )|| service_ind=="null" || service_ind==null){
		alert("Please Select Service Indicator");
		frm.querySelector("#billingclass"+idx).value="";
		parent.BLServiceDiscPrice.frmDiscPriceCreate.service_ind.focus();
		return false;
	}
	 else if(service_code==""|| service_code=="null"||service_code==null){
		alert("Please Select Service Code");
		parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.focus();
		return false;
	}
	else if(price_ind=="" || price_ind=="null" || price_ind==null){
		alert("Please Select Price Indicator");
		parent.BLServiceDiscPrice.frmDiscPriceCreate.price_ind.focus();
		return false;
	}
	else if(price_ind!="" || price_ind!="null" || price_ind!=null){
		if(price_ind!='C'){
			if(price_code==''|| price_code=="null" || price_code==null){
				alert("Please Select Price Code ");
				parent.BLServiceDiscPrice.frmDiscPriceCreate.price_code.focus();
				return false;
			}else{
			return true;
			}
		}else{
			if(cust_group_code==''|| cust_group_code=="null" || cust_group_code==null){
				alert("Please Select Cust Group Code ");
				parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_grp_code.focus();
				return false;
			}
			else if(cust_code==''|| cust_code=="null" || cust_code==null){
				parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_code.focus();				
				alert("Please Select Cust Code ");
				return false;
			}
			else if(Policy_code ==''|| Policy_code=="null" || Policy_code==null){
				parent.BLServiceDiscPrice.frmDiscPriceCreate.policy_code.focus();						
				alert("Please Select Policy Code ");
				return false;
			}else{
			return true;
			}
		}
	}
	else{
		return true;
	}
}

function checkDates(index){
	var locale = $('#locale').val();
	var effFromDate=document.getElementById("effFromDate"+index);
	var effToDate=document.getElementById("effToDate"+index);
	var price_ind_bot=document.getElementById("priceindbot"+index).value;
	//alert("price_ind_bot==>"+price_ind_bot);
	if(price_ind_bot=="")
	{
		alert("Please Select Rate/Factor");
		document.getElementById("effFromDate"+index).value='';
		parent.BLServiceDiscPrice.frmDiscPriceCreate.priceindbot.focus();
		return false;
	}
	if(effFromDate.value!=''){	
		if(!isAfterNow(effFromDate.value,'DMY',locale))
		 {
			 alert("Effective From Date Should be Greater than the System Date");
			 document.getElementById('effFromDate'+index).value="";
			 effFromDate.focus();
			 return false;
		 }
	}
	if(effToDate.value!=''){
		if((effFromDate.value=='')){
			alert("Effective From Date cannot be blank");
			effFromDate.focus();
			return false;
		}
	}
	if(effFromDate.value!='' && effToDate.value!=''){	
		if(!isBefore(effFromDate.value,effToDate.value,'DMY',locale))
		 {
			 alert("Effective To Date Cannot be Less than the Effective From Date");
			 document.getElementById('effToDate'+index).value="";
			document.getElementById('effToDate'+index).focus();
			 return false;
		 } 
	}
}
function discdate(index){
	var lastRowIndex = parent.BLMultiDiscPrice.document.getElementById("lastRowIndex").value;
	//alert("lastRowIndex==>"+lastRowIndex);
	var dseffecTO=parent.BLMultiDiscPrice.document.getElementById("disToDate"+lastRowIndex).value;
	//alert("dseffecTO==>"+dseffecTO);
	var dseffecFrom=parent.BLMultiDiscPrice.document.getElementById("discFromDate"+lastRowIndex).value;
	//alert("dseffecFrom==>"+dseffecFrom);
	var priceEffecTo = parent.BLMultiPricedtls.document.getElementById("effToDate"+index).value;
	//alert("priceEffecTo==>"+priceEffecTo);
	var locale=parent.BLMultiPricedtls.document.getElementById("locale").value;
	  if((priceEffecTo != null || priceEffecTo != "" || priceEffecTo!="null") && (priceEffecTo<=dseffecFrom))
	{
		alert("Price Period Doesn't Cover the whole Discount Period");
		//parent.BLMultiPricedtls.document.getElementById("effToDate"+index).focus();
		return false;
	} 
	/*if(priceEffecTo != null || priceEffecTo != "" || priceEffecTo!="null")	
	{
		alert("inside 1897");
	 if((isBefore(priceEffecTo,dseffecFrom,'DMY',locale)))
		{
			alert("1895"+dseffecFrom);	
		    alert("Price Period Doesn't Cover the whole Discount Period");
	
		} 
	}*/
	if(priceEffecTo!=null && dseffecTO=="" ){
		//alert("1877,dseffecTO==>"+dseffecTO);
		//alert("1878,priceEffecTo==>"+priceEffecTo);
		parent.BLMultiDiscPrice.document.getElementById("disToDate"+lastRowIndex).value = parent.BLMultiPricedtls.document.getElementById("effToDate"+index).value;
		//alert(parent.BLMultiDiscPrice.document.getElementById("disToDate"+lastRowIndex).value);
	}
	
}
function localTrimString(sInString) {
	if(sInString != ""){
		return sInString.replace(/[\[\]']+/g,'');
	}
	return "";
}

function patientCategory(index)
{	
	var billing_class = document.getElementById("billing_class"+index).value;
	var URL = "../../eBL/jsp/BLServiceDiscPriceValidation.jsp?billing_class="+billing_class+"&functionMode=patientCategory";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", URL, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	retVal = retVal.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	if(retVal != '') {
		document.getElementById("patCatCode_"+index).value = retVal;
	
		if(retVal =='D')
		{
			document.getElementById("discPer_dc"+index).readOnly=false;
			//document.getElementById("discPer_dc"+index).value = '';
			
			document.getElementById("discPer_ip"+index).readOnly=true;
			document.getElementById("discPer_ip"+index).value = '';
			document.getElementById("discPer_op"+index).readOnly=true;
			document.getElementById("discPer_op"+index).value = '';
			document.getElementById("discPer_em"+index).readOnly=true;
			document.getElementById("discPer_em"+index).value = '';
			document.getElementById("discPer_ex"+index).readOnly=true;
			document.getElementById("discPer_ex"+index).value = '';		
		}
		else if(retVal =='I')
		{
			document.getElementById("discPer_ip"+index).readOnly=false;		
			document.getElementById("discPer_op"+index).readOnly=true;
			document.getElementById("discPer_op"+index).value = '';
			document.getElementById("discPer_em"+index).readOnly=true;
			document.getElementById("discPer_em"+index).value = '';
			document.getElementById("discPer_ex"+index).readOnly=true;
			document.getElementById("discPer_ex"+index).value = '';
			document.getElementById("discPer_dc"+index).readOnly=true;
			document.getElementById("discPer_dc"+index).value = '';
		}
		else if(retVal == 'O')
		{
			document.getElementById("discPer_op"+index).readOnly=false;
			//document.getElementById("discPer_op"+index).value = '';
			
			document.getElementById("discPer_ip"+index).readOnly=true;
			document.getElementById("discPer_ip"+index).value = '';
			document.getElementById("discPer_em"+index).readOnly=true;
			document.getElementById("discPer_em"+index).value = '';
			document.getElementById("discPer_ex"+index).readOnly=true;
			document.getElementById("discPer_ex"+index).value = '';
			document.getElementById("discPer_dc"+index).readOnly=true;
			document.getElementById("discPer_dc"+index).value = '';
		}else if(retVal == 'E')
		{
			document.getElementById("discPer_em"+index).readOnly=false;
			//document.getElementById("discPer_em"+index).value = '';
			
			document.getElementById("discPer_ip"+index).readOnly=true;
			document.getElementById("discPer_ip"+index).value = '';
			document.getElementById("discPer_op"+index).readOnly=true;
			document.getElementById("discPer_op"+index).value = '';
			document.getElementById("discPer_ex"+index).readOnly=true;
			document.getElementById("discPer_ex"+index).value = '';
			document.getElementById("discPer_dc"+index).readOnly=true;
			document.getElementById("discPer_dc"+index).value = '';
		} else if(retVal == 'R')
		{
			document.getElementById("discPer_ex"+index).readOnly=false;
			//document.getElementById("discPer_ex"+index).value = '';
			
			document.getElementById("discPer_ip"+index).readOnly=true;
			document.getElementById("discPer_ip"+index).value = '';
			document.getElementById("discPer_op"+index).readOnly=true;
			document.getElementById("discPer_op"+index).value = '';
			document.getElementById("discPer_em"+index).readOnly=true;
			document.getElementById("discPer_em"+index).value = '';
			document.getElementById("discPer_dc"+index).readOnly=true;
			document.getElementById("discPer_dc"+index).value = '';
		}
		else if(billing_class = '**')
		{
			document.getElementById("discPer_ip"+index).readOnly=false;
			document.getElementById("discPer_ip"+index).value = '';
			document.getElementById("discPer_op"+index).readOnly=false;
			document.getElementById("discPer_op"+index).value = '';
			document.getElementById("discPer_em"+index).readOnly=false;
			document.getElementById("discPer_em"+index).value = '';
			document.getElementById("discPer_ex"+index).readOnly=false;
			document.getElementById("discPer_ex"+index).value = '';
			document.getElementById("discPer_dc"+index).readOnly=false;
			document.getElementById("discPer_dc"+index).value = '';
		}
	} else{
		document.getElementById("patCatCode_"+index).value = '';
	}
}

function validateHeader()
{
	var facility = parent.BLServiceDiscPrice.frmDiscPriceCreate.facility.value;
	var price_ind = parent.BLServiceDiscPrice.frmDiscPriceCreate.price_ind.value;
	var service_ind = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_ind.value;
	var service_code = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;
	var price_code = parent.BLServiceDiscPrice.frmDiscPriceCreate.price_code.value;
	var cust_group_code = parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_grp_code.value;
	var cust_code = parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_code.value;
	var policy_code = parent.BLServiceDiscPrice.frmDiscPriceCreate.policy_code.value;
	
	if((service_ind!="" && service_ind == "A" )|| service_ind == "null" || service_ind == null){
		alert("Please Select Service Indicator");
		parent.BLServiceDiscPrice.frmDiscPriceCreate.service_ind.focus();
		return false;
	}
	else if(service_code == "" || service_code == "null" || service_code == null){
		alert("Please Select Service Code");
		parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.focus();
		return false;
	}
	else if(price_ind == "" || price_ind == "null" || price_ind == null){
		alert("Please Select Price Indicator");
		parent.BLServiceDiscPrice.frmDiscPriceCreate.price_ind.focus();
		return false;
	}
	else if(price_ind != "" || price_ind != "null" || price_ind != null){
		if(price_ind!='C'){
			if(price_code == '' || price_code == "null" || price_code == null){
				alert("Please Select Price Code");
				parent.BLServiceDiscPrice.frmDiscPriceCreate.price_code.focus();
				return false;
			}else{
			return true;
			}
		}else{
			if(cust_group_code == '' || cust_group_code == "null" || cust_group_code == null){
				alert("Please Select Cust Group Code");
				parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_grp_code.focus();
				return false;
			}
			else if(cust_code == ''|| cust_code == "null" || cust_code == null){
				parent.BLServiceDiscPrice.frmDiscPriceCreate.cust_code.focus();				
				alert("Please Select Cust Code");
				return false;
			}
			else if(policy_code == '' || policy_code == "null" || policy_code == null){
				parent.BLServiceDiscPrice.frmDiscPriceCreate.policy_code.focus();						
				alert("Please Select Policy Code");
				return false;
			}
			else{
				return true;
			}
		}
	}
	else{
		return true;
	}
	return true;
}

function checkForNumberDecimalDisc(obj) {

	var decArr = obj.value.split('.');
	if(decArr.length>2){
		alert(getMessage("NUM_ALLOWED", "SM"));
		obj.value = '';
		return false;
	}
	
	if(decArr == '0'){
		obj.value = '';
		return false;
	}
	if(decArr.length == 2){
		if(decArr[0].length<1 && decArr[1].length<1){
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value = '';
			return false;
		}
		else if(decArr[1].length>2){
			alert('Only Two Numbers are allowed beyond Decimal');
			obj.value = '';
			return false;
		}
	}

	return true;
}

