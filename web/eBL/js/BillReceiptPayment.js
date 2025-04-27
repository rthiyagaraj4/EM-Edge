$(document).ready(function(){
		
		
		$('#resizeBtnPayment').click(function(){
			var defValue = $(this).attr('defValue');
			if(defValue =='shrink'){
				$(this).attr('defValue','expand');
				$(this).attr('src','../../eOT/images/ShowMore.gif');
				$('#paymentMainDiv').hide();
				var paymentBtn = $(parent.BillReceiptExisOrderSearch.document).find('#resizeBtnSearch');
				$(paymentBtn).attr('defValue','shrink');
				$(paymentBtn).attr('src','../../eOT/images/ShowLess.gif');
				$(parent.BillReceiptExisOrderSearch.document).find('#searchCriteriaDiv').show();
				//$(parent.document).find('#BL_mainFrame').attr('rows',$(parent.document).find('#allFramesExisting').val());
				parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('allFramesExisting').value;
			}
			else{
				$(this).attr('defValue','shrink');
				$(this).attr('src','../../eOT/images/ShowLess.gif');
				$(parent.BillReceiptExisOrderSearch.document).find('#searchCriteriaDiv').hide();
				var paymentBtn = $(parent.BillReceiptExisOrderSearch.document).find('#resizeBtnSearch');
				$(paymentBtn).attr('defValue','expand');
				$(paymentBtn).attr('src','../../eOT/images/ShowMore.gif');
				$('#paymentMainDiv').show();
				//$(parent.document).find('#BL_mainFrame').attr('rows',$(parent.document).find('#hideSearchCriteria').val());
				parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('hideSearchCriteria').value;
			}
		});
		
		$('#clearBtn').click(function(){
			$('#paymentSummaryTable tr:first-child').siblings().remove();
			$('#overAllOutStanding').val($('#hdnOverAllOutStanding').val());
			resetTempletes('CA');
			defaultButtons();
		});
		// Below Event is Triggered when the payment Mode is changed
		$('#paymentMode').change(function(){
			var mode = $(this).val();
			if(mode != ''){
				if (mode == 'CA'){
					$('#cardTemplate').hide();
					$('#ddTemplate').hide();
					$('#chequeTemplate').hide();
					$('#cashTemplate').show();
					$('#cashAddBtn').val('Add');
				}
				else if(mode == 'CC'){
					$('#cardTemplate').show();
					$('#cashTemplate').hide();
					$('#chequeTemplate').hide();
					$('#ddTemplate').hide();
					$('#cardAddBtn').val('Add');
				}
				else if(mode == 'DD'){
					$('#cardTemplate').hide();
					$('#cashTemplate').hide();
					$('#chequeTemplate').hide();
					$('#ddTemplate').show();
					$('#ddAddBtn').val('Add');
				}
				else if(mode == 'CQ'){
					$('#cardTemplate').hide();
					$('#cashTemplate').hide();
					$('#chequeTemplate').show();
					$('#ddTemplate').hide();
					$('#chequeAddBtn').val('Add');
				}
			}
			else{
				
			}

			$('#paymentButton').show();
			
		});
		
		// Below Event is Triggered when user wants to view the payment summary
		$('#previewBtn').click(function(){
			$('#paymentMainDiv').hide();
			$('#paymentButton').hide();
			$('#cardTemplate').hide();
			$('#cashTemplate').hide();
			$('#chequeTemplate').hide();
			$('#ddTemplate').hide();
			$('paymentMainDiv').hide();
			$('#paymentSummary').show();
			
		});
		
		// Below Event is Triggered when user wants to go back from payment summary
		$('#backFromPreview').click(function(){
			$('#paymentMainDiv').show();
			$('#paymentButton').show();
			$('paymentMainDiv').show();
			$('#paymentSummary').hide();
			$('#paymentMode').change();
		});
		
		// Below Event is Triggered when user want to a settlement tro Cash mode
		$('#cashAddBtn').click(function(){
			var paymentData = {};
			
			var amtColl = parseFloat($('#cash_given').val()) - parseFloat($('#cash_return').val());
			paymentData.amountCollected =   roundToTwo(amtColl);
			paymentData.slmtType = 'Cash';
			paymentData.cashGiven = $('#cash_given').val();
			paymentData.outStandingAmount = '';
			paymentData.date = '';
			paymentData.cardNo = '';
			paymentData.cardValue = '';
			paymentData.cardType = '';
			paymentData.issueAuthority = '';
			paymentData.issueBranch = '';
			paymentData.apprCode = '';
			paymentData.cashReturned = $('#cash_return').val();
			paymentData.payerName = $('#payername').val();
			paymentData.payerRef = $('#recrefidno').val();


			
			if(paymentData.cashGiven == ''){
				alert('Amount is mandatory');
				return false;
			}
			
			if(paymentData.cashGiven == '0'){
				alert('Amount cannot be zero');
				return false;
			}
			
			//resetTempletes('CC');
			addPaymentEntry(paymentData,$('#cashAddBtn').val());
		});
		
		// Below Event is Triggered when user want to a settlement tro card mode
		$('#cardAddBtn').click(function(){
			var paymentData = {};
			
			paymentData.amountCollected =  $('#cardAmount').val();
			paymentData.slmtType = 'Card';
			paymentData.cashGiven = $('#cardAmount').val();
			paymentData.outStandingAmount = '';
			paymentData.date = '';
			paymentData.cardType = $('#cardType').val();
			paymentData.cardNo = $('#cardNo').val();
			paymentData.cardValue = '';
			paymentData.issueAuthority = $('#issuingAuthority').val();
			paymentData.issueBranch = $('#issuingBranch').val();
			paymentData.apprCode = $('#apprAuthCode').val();
			paymentData.cashReturned = '';
			paymentData.payerName = $('#cardHolderName').val();
			paymentData.payerRef = '';
			paymentData.fromMonth = $('#validityFromMonth').val();
			paymentData.toMonth = $('#validityToMonth').val();
			paymentData.fromYear = $('#validityFromYear').val();
			paymentData.toYear = $('#validityToYear').val();
			if(paymentData.cashGiven == ''){
				alert('Amount is mandatory');
				return false;
			}
			if(paymentData.cashGiven == '0'){
				alert('Amount cannot be zero');
				return false;
			}
			//resetTempletes('CA');
			addPaymentEntry(paymentData,$('#cardAddBtn').val());
		});
		
		// Below Event is Triggered when user want to a settlement tro DD mode
		$('#ddAddBtn').click(function(){
			var paymentData = {};
			
			paymentData.amountCollected =  $('#ddAmount').val();
			paymentData.slmtType = 'DD';
			paymentData.cashGiven = $('#ddAmount').val();
			paymentData.outStandingAmount = '';
			//alert( $('#ddDate').val())
			paymentData.date = $('#ddDate').val();
			paymentData.cardType = '';
			paymentData.cardNo = '';
			paymentData.cardValue = '';
			paymentData.issueAuthority = '';
			paymentData.issueBranch = '';
			paymentData.apprCode = '';
			paymentData.cashReturned = '';
			paymentData.payerName = $('#ddPayername').val();
			paymentData.payerRef = $('#ddNo').val();
			if(paymentData.cashGiven == ''){
				alert('Amount is mandatory');
				return false;
			}
			if(paymentData.cashGiven == '0'){
				alert('Amount cannot be zero');
				return false;
			}
			//resetTempletes('DD');
			addPaymentEntry(paymentData,$('#ddAddBtn').val());
		});
		
		// Below Event is Triggered when user want to a settlement tro Cheque mode
		$('#chequeAddBtn').click(function(){
			var paymentData = {};
			
			paymentData.amountCollected =  $('#chequeAmount').val();
			paymentData.slmtType = 'Cheque';
			paymentData.cashGiven = $('#chequeAmount').val();
			paymentData.outStandingAmount = '';
			paymentData.date = $('#chequeDate').val();
			paymentData.cardType = '';
			paymentData.cardNo = '';
			paymentData.cardValue = '';
			paymentData.issueAuthority = '';
			paymentData.issueBranch = '';
			paymentData.apprCode = '';
			paymentData.cashReturned = '';
			paymentData.payerName = $('#chequePayername').val();
			paymentData.payerRef = $('#chequeNo').val();
			paymentData.fromMonth = '';
			paymentData.toMonth = '';
			paymentData.fromYear = '';
			paymentData.toYear = '';
			if(paymentData.cashGiven == ''){
				alert('Amount is mandatory');
				return false;
			}
			if(paymentData.cashGiven == '0'){
				alert('Amount cannot be zero');
				return false;
			}
			//resetTempletes('CQ');
			addPaymentEntry(paymentData,$('#chequeAddBtn').val());
		});
		
		$('#saveBtn').click(function(){
			var overAllOutStanding = $('#overAllOutStanding').val();
			if(overAllOutStanding == '0' || overAllOutStanding == '0.00'){
				alert('Bill Generation and Receipt Generation yet to be Developed');
			} 
			else{
				alert('Plese Settle the Outstanding Amount');
				return false;
			}
		});
	});
	
	//Function used to clear all text fields
	function resetTempletes(obj){
		$('#cashTemplate input[type="text"]').each(function(){
			$(this).val('');
		});
		$('#cardTemplate input[type="text"]').each(function(){
			$(this).val('');
		});
		$('#ddTemplate input[type="text"]').each(function(){
			$(this).val('');
		});
		$('#chequeTemplate input[type="text"]').each(function(){
			$(this).val('');
		});

	}
	function CheckForSpecChars_local(event)
	{
	    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-. ';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;
	}
	
	//Function used to insert or update the summary table row
	function checkForNumberDecimal(obj) {
		var decArr = obj.value.split('.');
		if(decArr.length>2){
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value = '';
			return false;
		}
	   
		if(decArr.length == 2){
			if(decArr[0].length<1 && decArr[1].length<1){
				alert(getMessage("NUM_ALLOWED", "SM"));
				obj.value = '';
				return false;

			}
			if(decArr[1].length>2){
				alert('Only Two Numbers are allowed beyond Decimal');
				obj.value = '';
				return false;

			}
		}
		
		return true;
	}
	
	function addPaymentEntry(paymentData,btnVal){

		var cnt = window.rowCount;
		var selectedRow = $('#checkedData').val();	
		
		var overAllAmount = $('#overAllOutStanding').val();
		var newOverallAmt = '';
		//alert(paymentData.amountCollected)
		newOverallAmt = parseFloat(overAllAmount) - parseFloat(paymentData.amountCollected);
		newOverallAmt = roundToTwo(newOverallAmt);
		if(newOverallAmt<0){
			alert('Amount Exceeded the OverAll payment');
			return false;
		}
		$('#overAllOutStanding').val(newOverallAmt);
		if(selectedRow!='' && $('#slmttype'+selectedRow).text() != '' && btnVal!= 'Add'){
			defaultButtons();
			
			$('#billslmtamt'+selectedRow).text(paymentData.amountCollected);
			$('#cash_given'+selectedRow).text(paymentData.cashGiven);
			$('#outstanding_amount'+selectedRow).text(paymentData.outStandingAmount);
			$('#cash_return'+selectedRow).text(paymentData.cashReturned);
			$('#instref'+selectedRow).text(paymentData.payerRef);
			$('#instdate'+selectedRow).text(paymentData.date);
			$('#cardType'+selectedRow).text(paymentData.cardType);
			$('#cardNo'+selectedRow).text(paymentData.cardNo);
			if(paymentData.slmtType == 'Card'){
				$('#cardVal'+selectedRow).text(paymentData.fromMonth+"/"+paymentData.fromYear+" - "+paymentData.toMonth+"/"+paymentData.toYear);
			}
			else{
				$('#cardVal'+selectedRow).text(paymentData.cardValue);
			}
			$('#issAuthority'+selectedRow).text(paymentData.issAuthority);
			$('#issBranch'+selectedRow).text(paymentData.issueBranch);
			$('#apprCode'+selectedRow).text(paymentData.apprCode);
			$('#payerName'+selectedRow).text(paymentData.payerName);
			
			$('#tdFromMonth'+selectedRow).val(paymentData.fromMonth);
			$('#tdFromYear'+selectedRow).val(paymentData.fromYear);
			$('#tdToMonth'+selectedRow).val(paymentData.toMonth);
			$('#tdToYear'+selectedRow).val(paymentData.toYear);
		}
		else{
			

			

			var trData = "<tr id='tr"+cnt+"' index='"+cnt+"'> "+
			"<td class='fields' > "+
				"<input type='checkbox' name='selected_row"+cnt+"' id='selected_row"+cnt+"' id='selected_row"+cnt+"' onclick='updateTemplates("+cnt+")'>"+
			"</td> "+
			"<td class='label' id='billslmtamt"+cnt+"'> "+
				paymentData.amountCollected+
			"</td> "+
			"<td class='label' id='slmttype"+cnt+"'> "+
				paymentData.slmtType+
			"</td> "+
			"<td class='label' id='cash_given"+cnt+"' style='display:none;'> "+
				paymentData.cashGiven+
			"</td> "+
			"<td class='label' id='outstanding_amount"+cnt+"' style='display:none;'> "+
				paymentData.outStandingAmount+	
			"</td> "+
			"<td class='label' id='cash_return"+cnt+"' style='display:none;'> "+
				paymentData.cashReturned +
			"</td> "+

			"<td class='label' id='instref"+cnt+"' > "+
				paymentData.payerRef+
			"</td> "+
			"<td class='label' id='instdate"+cnt+"' style='display:none;'> "+
				paymentData.date+
			"</td> "+
			"<td class='label' id='cardType"+cnt+"' style='display:none;'> "+
				paymentData.cardType+
			"</td> "+
			"<td class='label' id='cardNo"+cnt+"' style='display:none;'> "+
				paymentData.cardNo+
			"</td> ";

					if(paymentData.slmtType == 'Card'){
						trData = trData + "<td class='label' id='cardVal"+cnt+"' style='display:none;'> "+
							paymentData.fromMonth+"/"+paymentData.fromYear+" - "+paymentData.toMonth+"/"+paymentData.toYear+
						"</td> ";
					}
					else{
						trData = trData + "<td class='label' id='cardVal"+cnt+"' style='display:none;'> "+
										paymentData.cardValue+
										"</td> ";
					}
					
					trData = trData +	
						"<td class='label' id='issAuthority"+cnt+"' style='display:none;'> "+
							paymentData.issueAuthority+
						"</td> "+
						"<td class='label' id='issBranch"+cnt+"' style='display:none;'> "+
							paymentData.issueBranch+
						"</td> "+
						"<td class='label' id='apprCode"+cnt+"' style='display:none;'> "+
							paymentData.apprCode+
						"</td> " +
						"<td class='label' id='payerName"+cnt+"'> "+
							paymentData.payerName+
						"</td> "+
						"<td  id='removeBtn"+cnt+"'> "+
							"<a href='javascript:removeEntry("+cnt+")' class='myButton'>Remove</a>"+
						"</td> "+
						"<input type='hidden' name='tdFromMonth"+cnt+"' id='tdFromMonth"+cnt+"' id='tdFromMonth"+cnt+"' value='"+paymentData.fromMonth+"'>" +
						"<input type='hidden' name='tdFromYear"+cnt+"' id='tdFromYear"+cnt+"' id='tdFromYear"+cnt+"' value='"+paymentData.fromYear+"'>" +
						"<input type='hidden' name='tdToMonth"+cnt+"' id='tdToMonth"+cnt+"' id='tdToMonth"+cnt+"' value='"+paymentData.toMonth+"'>" +
						"<input type='hidden' name='tdToYear"+cnt+"' id='tdToYear"+cnt+"' id='tdToYear"+cnt+"' value='"+paymentData.toYear+"'>" +
					"</tr>";
			$('#paymentSummaryTable').append(trData);
			window.rowCount = parseInt(cnt)+1;
		}
		alert('border');
		$('#paymentSummaryTable td:empty').html('&nbsp;');
		resetTempletes('CA');
	}
	
	//Function used to remove the added entry
	function removeEntry(cnt){
		var paymentData = getPaymentData(cnt);
		var oldOutStanding = $('#overAllOutStanding').val();
		var newOutStanding = parseFloat(oldOutStanding) + parseFloat(paymentData.amountCollected);
		newOutStanding = roundToTwo(newOutStanding);
		$('#overAllOutStanding').val(newOutStanding);
		$('#tr'+cnt).remove();
		$('#backFromPreview').click();
	}
	//Function used to remove the added entry
	//Function used to populate the Templates with the table row data from summary
	function updateTemplates(cnt){
		var paymentData = getPaymentData(cnt);
		$('#checkedData').val(cnt);
		$('#selected_row'+cnt).prop('checked',false);
		if(paymentData.slmtType == 'Cash'){
			$('#cash_given').val(paymentData.cashGiven);
			$('#cash_return').val(paymentData.cashReturned);
			$('#payername').val(paymentData.payerName);
			$('#recrefidno').val(paymentData.payerRef);
			$('#paymentMode').val('CA');
			$('#backFromPreview').click();
			$('#cashAddBtn').val('Update');
		}
		else if(paymentData.slmtType == 'Card'){
			$('#cardType').val(paymentData.cardType);
			$('#cardNo').val(paymentData.cardNo);
			$('#cardHolderName').val(paymentData.payerName);
			$('#issuingAuthority').val(paymentData.issueAuthority);
			$('#issuingBranch').val(paymentData.issueBranch);
			$('#apprAuthCode').val(paymentData.apprCode);
			$('#validityFromMonth').val(paymentData.fromMonth);
			$('#validityFromYear').val(paymentData.fromYear);
			$('#validityToMonth').val(paymentData.toMonth);
			$('#validityToYear').val(paymentData.toYear);
			$('#cardAmount').val(paymentData.cashGiven);
			$('#paymentMode').val('CC');
			$('#backFromPreview').click();
			$('#cardAddBtn').val('Update');
		}
		else if(paymentData.slmtType == 'DD'){
			$('#ddAmount').val(paymentData.cashGiven);
			$('#ddDate').val(paymentData.date);
			$('#ddPayername').val(paymentData.payerName);
			$('#ddNo').val(paymentData.payerRef);

			$('#paymentMode').val('DD');
			$('#backFromPreview').click();
			$('#ddAddBtn').val('Update');
		}
		else if(paymentData.slmtType == 'Cheque'){
			$('#chequeAmount').val(paymentData.cashGiven);
			$('#chequeDate').val(paymentData.date);
			$('#chequePayername').val(paymentData.payerName);
			$('#chequeNo').val(paymentData.payerRef);
			
			$('#paymentMode').val('CQ');
			$('#backFromPreview').click();
			$('#chequeAddBtn').val('Update');
		}
		var oldOutStanding = $('#overAllOutStanding').val();
		var newOutStanding = parseFloat(oldOutStanding) + parseFloat(paymentData.amountCollected);
		newOutStanding = roundToTwo(newOutStanding);
		$('#overAllOutStanding').val(newOutStanding);
		$('#paymentMode').prop('disabled',true);
		$('#previewBtn').prop('disabled',true);
	}
	
	//Function used to store payemnt row level data to a json object
	function getPaymentData(cnt){
		var paymentData = {};
		paymentData.amountCollected =  $.trim($('#billslmtamt'+cnt).text());
		paymentData.slmtType = $.trim($('#slmttype'+cnt).text());
		paymentData.cashGiven = $.trim($('#cash_given'+cnt).text());
		paymentData.outStandingAmount = '';
		paymentData.date = $.trim($('#instdate'+cnt).text());
		paymentData.cardType = $.trim($('#cardType'+cnt).text());
		paymentData.cardNo = $.trim($('#cardNo'+cnt).text());
		paymentData.cardValue = $.trim($('#cardVal'+cnt).text());
		paymentData.issueAuthority = $.trim($('#issAuthority'+cnt).text());
		paymentData.issueBranch = $.trim($('#issBranch'+cnt).text());
		paymentData.apprCode = $.trim($('#apprCode'+cnt).text());
		paymentData.cashReturned = $.trim($('#cash_return'+cnt).text());

			paymentData.payerName = $.trim($('#payerName'+cnt).text());
			
		paymentData.payerRef = $.trim($('#instref'+cnt).text());
		paymentData.fromMonth = $.trim($('#tdFromMonth'+cnt).val());
		paymentData.toMonth = $.trim($('#tdToMonth'+cnt).val());
		paymentData.fromYear = $.trim($('#tdFromYear'+cnt).val());
		paymentData.toYear = $.trim($('#tdToYear'+cnt).val());
		//alert(paymentData.fromMonth)
		//alert(paymentData.toMonth)
		//alert(paymentData.fromYear)
		//alert(paymentData.toYear)
		return paymentData;
	}
	
	function computeCashreturn(){
		var cash_given = $('#cash_given').val();
		var overAllAmount = $('#overAllOutStanding').val();
		if(overAllAmount<=0){
			alert('Settlement Amount already matched');
			$('#cash_given').val('');
			return false;
		}
		//alert(cash_given+','+overAllAmount)
		if(parseFloat(cash_given)>parseFloat(overAllAmount)){
			//alert('greater')
			var return_amt = parseFloat($('#cash_given').val()) - parseFloat($('#overAllOutStanding').val());
			return_amt = roundToTwo(return_amt);
			$('#cash_return').val(return_amt);
		}
		else{
			$('#cash_return').val(0);
		}
	}
	
	function defaultButtons(){
		$('#cashAddBtn').val('Add');
		$('#cardAddBtn').val('Add');
		$('#ddAddBtn').val('Add');
		$('#chequeAddBtn').val('Add');

		$('#paymentMode').prop('disabled',false);
		$('#previewBtn').prop('disabled',false);
	}

