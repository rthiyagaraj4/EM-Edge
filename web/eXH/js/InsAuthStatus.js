/*
Added By Niveditha for  MOHE-CRF-0026.3
*/

function reset()
{
	if(window.f_query_header.document.forms[0])
	{
	window.f_query_header.document.forms[0].reset();
	window.InsuranceAuthorizationStatusCriteriaFrame.location.href="../../eXH/jsp/InsuranceAuthorizationStatusCriteria.jsp";
	window.InsuranceAuthorizationStatusResultFrame.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";
	}
	
	if(InsuranceAuthorizationStatusCriteriaFrame.document.forms[0])
		InsuranceAuthorizationStatusCriteriaFrame.document.forms[0].reset();

	InsuranceAuthorizationStatusCriteriaFrame.location.reload();
}

function resetCriteria()
{
	parent.InsuranceAuthorizationStatusCriteriaFrame.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	
}

function closeWindow()
{
	parent.window.close();
}


function selectedRecord(obj){
	if(obj.checked){
		            obj.checked=true;
					obj.value="Y";
					}
			else{
					obj.checked=false;
					obj.value="N";
					document.getElementById("selectAll").checked=false;
					document.getElementById("selectAll").value="N";
					}
}

function callSearch()
{
   	if(window.event.keyCode==13)
	{	
   		SearchChart('jsp');
	}
}

function SearchChart(flag){

	if(flag=='jsp')	{
	
		var patient_id = document.InsuranceAuthorizationStatusCriteriaFrame.Patient_Id.value;
		var encounter_id = document.InsuranceAuthorizationStatusCriteriaFrame.encounter_id.value;
		var fromDate_search=document.InsuranceAuthorizationStatusCriteriaFrame.TRANSFUSE_ST_DATE_TIME.value;
		var toDate_search=document.InsuranceAuthorizationStatusCriteriaFrame.TRANSFUSE_EN_DATE_TIME.value;
		if (fromDate_search == "") {
            alert("Encounter From Date Cannot Be Blank.");
            return false;
        }   
		if (toDate_search == "") {
            alert("Encounter To Date Cannot Be Blank.");
            return false;
        }
        
		var locale = document.InsuranceAuthorizationStatusCriteriaFrame.locale.value;
		var max_days=daysBetween(fromDate_search,toDate_search,"DMY",document.InsuranceAuthorizationStatusCriteriaFrame.locale.value);
		if(max_days>7){
		var errors=getMessage('DATE_MORE_THAN_7_DAYS','XH');
			alert(errors);
			document.InsuranceAuthorizationStatusCriteriaFrame.fromDate_search.focus();
			return false;
		}
		
		var episode_type=document.InsuranceAuthorizationStatusCriteriaFrame.EpisodeType.value;
		var disp_location=document.InsuranceAuthorizationStatusCriteriaFrame.disp_location.value;
		var auth_status=document.InsuranceAuthorizationStatusCriteriaFrame.auth_status.value;

		parent.InsuranceAuthorizationStatusResultFrame.location.href="../jsp/InsuranceAuthorizationStatusResult.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&fromDate_search="+fromDate_search+"&toDate_search="+toDate_search+"&episode_type="+episode_type+"&disp_location="+disp_location+"&auth_status="+auth_status;	
		
	}	
}

function patname() {
	var patient_id = document.InsuranceAuthorizationStatusCriteriaFrame.Patient_Id.value;
	parent.InsuranceAuthorizationStatusCriteriaFrame.location.href="../jsp/InsuranceAuthorizationStatusCriteria.jsp?patient_id="+patient_id;		
}

//for patient lookup
function callPatientSearch(target){
	var patient_id = PatientSearch();	
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}	
}

function errorCall(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	return false;
}

function searchEncounterId(target){
	var encounter_id = EncounterSearch();	
	if (typeof(encounter_id)=="string"){
		target.value = encounter_id;
	}
}

function insertRecords(){
	var compSelected = 0, rowIndex = 0, checkBoxName = "secChk", compName = "", insertPatientId = "", insertEncounterId = "", insertOrderId = "", insertDispNo = "", insertDrugCode = "", insertorderLineNum = "", insertobjdispqtyvalue = "", insertobjdispuomcodevalue = "", insertobjpatclassvalue = "", insertobjbasepricevalue = "", insertStatus = "N";
	var objdispuomcode = "", compStr = "", recCount = 0, compDesc = "", compDataStr = "";
	var count = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.count.value;
	
	if(parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm != null)
	{		
		var els = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.elements;
		for (var i = 0, len = els.length; i < len; ++i){
		        	if (els[i].checked == true){
						
		        		compSelected = 1;
		        		
		        		compName = els[i].name;		        		
		        		compStr = compName.substring(checkBoxName.length);
		        		rowIndex = parseInt(compStr);		        				        		
						
		        		var objpatid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_id_value"+rowIndex);
						
		        		var objencounterid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.encounter_id_value"+rowIndex);
						
						var objorderid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_id_value"+rowIndex);
						
						var objdispno = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_no_value"+rowIndex);
						
						var objdrugcode = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.drug_code_value"+rowIndex);
						
						var objorderlinenum = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_line_num_value"+rowIndex);
						
						var objdispqty = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_qty_value"+rowIndex);
						
						var objdispuomcode = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_uom_code_value"+rowIndex);
						
						var objpatclass = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_class_value"+rowIndex);					
						
						var objbaseprice = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.base_price_value"+rowIndex);

						insertPatientId = objpatid.value;
						insertEncounterId = objencounterid.value;
						insertOrderId = objorderid.value;
		        		insertDispNo = objdispno.value;
		        		insertDrugCode = objdrugcode.value;
		        		insertorderLineNum = objorderlinenum.value;
		        		insertobjdispqtyvalue = objdispqty.value;
		        		insertobjdispuomcodevalue = objdispuomcode.value;
		        		insertobjpatclassvalue = objpatclass.value;
		        		insertobjbasepricevalue = objbaseprice.value;
						//P_PATIENT_ID~P_ENCOUNTER_ID~P_ORDER_ID~P_DISP_ID~P_ITEM_SEQUENCE~P_DRUG_CODE~P_STATUS~P_DISPENSE_QTY~P_DISPENSE_UOM~P_UNIT_PRICE_VALUE#

		        		compDataStr = compDataStr + insertPatientId + "~" + insertEncounterId + "~" + insertOrderId + "~" + insertDispNo + "~" + insertorderLineNum + "~" + insertDrugCode + "~" + insertStatus + "~" + insertobjdispqtyvalue + "~" + insertobjdispuomcodevalue+ "~" + insertobjbasepricevalue;
						
		        		compDataStr = compDataStr + "#";	
	
		        		recCount++;	        		
		        	}
		}if (compSelected == 0){
				alert("NO RECORDS HAVE BEEN SELECTED");
				return false;
		}
		else
		{		

			var errorMsg="", error_value= 1;
			
			var p_facility_id = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.facilityId.value;
			var p_disp_data = compDataStr;
			var p_loginuserid = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.login_user.value;
			var p_workstationno = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.strClientIpAddress.value;
			var responsePayerTransactions = PayerAuthorization('PHPREAUTH',p_facility_id,p_disp_data,p_loginuserid, p_workstationno);
			var responsePayerTransactions = "S";
			var fields = responsePayerTransactions.split('$!^');
			
			var responseCode = fields[0];

			if(responseCode=="S"){	 	
				errorMsg= getMessage('RECORD_INS_AUTH_Y_CHECK', 'XH');
				alert(errorMsg);
				parent.parent.messageFrame.location.href ='../../eXH/jsp/NewProcedureMessage.jsp?err_num='+errorMsg+"&err_value="+error_value;
			}else{
				errorMsg= getMessage('RECORD_INS_AUTH_N_CHECK', 'XH');	
				alert(errorMsg);
				parent.parent.messageFrame.location.href ='../../eXH/jsp/NewProcedureMessage.jsp?err_num='+errorMsg+"&err_value="+error_value;
			}
		}
	}
	else 
	{ 
		alert("NO RECORDS HAVE BEEN SELECTED");
		return false;
	}
}

function statusRecords(){

	var compSelected = 0, rowIndex = 0, checkBoxName = "secChk", compName = "", insertPatientId = "", insertEncounterId = "", insertOrderId = "", insertDispNo = "", insertDrugCode = "", insertorderLineNum = "", insertobjdispqtyvalue = "", insertobjdispuomcodevalue = "", insertobjpatclassvalue = "", insertobjbasepricevalue = "", insertStatus = "N", insertobjobjclaimidvalue = "", insertobjauthstatusvalue = "";
	var objdispuomcode = "", compStr = "", recCount = 0, compDesc = "", compDataStr = "";
	var count = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.count.value;
	
	if(parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm != null)
	{		
		var els = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.elements;
		for (var i = 0, len = els.length; i < len; ++i){
		        	if (els[i].checked == true){
						
		        		compSelected = 1;
		        		
		        		compName = els[i].name;		        		
		        		compStr = compName.substring(checkBoxName.length);
		        		rowIndex = parseInt(compStr);		        				        		
						
		        		var objpatid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_id_value"+rowIndex);
						
		        		var objencounterid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.encounter_id_value"+rowIndex);
						
						var objorderid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_id_value"+rowIndex);
						
						var objdispno = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_no_value"+rowIndex);
						
						var objdrugcode = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.drug_code_value"+rowIndex);
						
						var objorderlinenum = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_line_num_value"+rowIndex);
						
						var objdispqty = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_qty_value"+rowIndex);
						
						var objdispuomcode = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_uom_code_value"+rowIndex);
						
						var objpatclass = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_class_value"+rowIndex);					
						
						var objbaseprice = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.base_price_value"+rowIndex);
						
						var objauthstatus = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.auth_status_value"+rowIndex);
						
						var objclaimid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.claim_id_value"+rowIndex);

						insertPatientId = objpatid.value;
						insertEncounterId = objencounterid.value;
						insertOrderId = objorderid.value;
		        		insertDispNo = objdispno.value;
		        		insertDrugCode = objdrugcode.value;
		        		insertorderLineNum = objorderlinenum.value;
		        		insertobjdispqtyvalue = objdispqty.value;
		        		insertobjdispuomcodevalue = objdispuomcode.value;
		        		insertobjpatclassvalue = objpatclass.value;
		        		insertobjbasepricevalue = objbaseprice.value;
		        		insertobjauthstatusvalue = objauthstatus.value;
		        		insertobjobjclaimidvalue = objclaimid.value;

		        		compDataStr = compDataStr + insertPatientId + "~" + insertEncounterId + "~" + insertOrderId + "~" + insertDispNo + "~" + insertorderLineNum + "~" + insertDrugCode + "~" + insertStatus + "~" + insertobjdispqtyvalue + "~" + insertobjdispuomcodevalue+ "~" + insertobjbasepricevalue + "~" + insertobjauthstatusvalue + "~" + insertobjobjclaimidvalue;
						
		        		compDataStr = compDataStr + "#";	

		        		recCount++;	        		
		        	}
		}if (compSelected == 0){
				alert("NO RECORDS HAVE BEEN SELECTED");
				return false;
		}
		else
		{		
			
			var errorMsg="", error_value= 1;

			var p_facility_id = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.facilityId.value;
			var p_disp_data = compDataStr;
			var p_loginuserid = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.login_user.value;
			var p_workstationno = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.strClientIpAddress.value;

			var responsePayerTransactions = PayerAuthorization('PHSTATUS',p_facility_id,p_disp_data,p_loginuserid, p_workstationno);
			var fields = responsePayerTransactions.split('$!^');
			var responseCode = fields[0];

			if(responseCode=="S"){	 	
				errorMsg= getMessage('RECORD_INS_AUTH_STATUS_Y_CHECK', 'XH');
				alert(errorMsg);
				parent.parent.messageFrame.location.href ='../../eXH/jsp/NewProcedureMessage.jsp?err_num='+errorMsg+"&err_value="+error_value;
			}else{
				errorMsg= getMessage('RECORD_INS_AUTH_STATUS_N_CHECK', 'XH');	
				alert(errorMsg);
				parent.parent.messageFrame.location.href ='../../eXH/jsp/NewProcedureMessage.jsp?err_num='+errorMsg+"&err_value="+error_value;
			}
		}
	}
	else 
	{ 
		alert("NO RECORDS HAVE BEEN SELECTED");
		return false;
	}

	
}

function generatebill(){	

	var responseMsg="", data1=true, compSelected = 0, rowIndex = 0, checkBoxName = "secChk", compName = "";
	var insertPatientId = "", insertEncounterId = "", insertDispNo = "", insertDrugCode = "", insertOrderLineNo = "", insertobjdispqtyvalue = "", insertobjorderidvalue = "", insertobjpatclassvalue = "", insertobjauthstatusvalue = "",insertobjapprovedamountvalue = "", insertobjobjapprovalnovalue = "";
	var compStr = "", recCount = 0, dataElements = "";
	
	if(parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm != null)
	{		
		var els = parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.elements;
		for (var i = 0, len = els.length; i < len; ++i) {
		        	if (els[i].checked == true){
						
		        		compSelected = 1;
		        		
		        		compName = els[i].name;		        		
		        		compStr = compName.substring(checkBoxName.length);
		        		rowIndex = parseInt(compStr);		        				        		
						
		        		var objpatid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_id_value"+rowIndex);
						
		        		var objencounterid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.encounter_id_value"+rowIndex);
						
						var objdispno = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_no_value"+rowIndex);
						
						var objdrugcode = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.drug_code_value"+rowIndex);
						
						var objorderlineno = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_line_num_value"+rowIndex);
						
						var objdispqty = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.disp_qty_value"+rowIndex);
						
						var objorderid = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.order_id_value"+rowIndex);
						
						var objpatclass = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.patient_class_value"+rowIndex);	
						
						var objauthstatus = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.auth_status_value"+rowIndex);	
						
						var objapprovedamount = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.approved_amount_value"+rowIndex);
						
						var objapprovalno = eval("parent.InsuranceAuthorizationStatusResultFrame.document.InsuranceAuthorizationStatusResultForm.approval_no_value"+rowIndex);			
						

						insertPatientId = objpatid.value;
						insertEncounterId = objencounterid.value;
		        		insertDispNo = objdispno.value;
		        		insertDrugCode = objdrugcode.value;
		        		insertOrderLineNo = objorderlineno.value;
		        		insertobjdispqtyvalue = objdispqty.value;
		        		insertobjorderidvalue = objorderid.value;
						insertobjpatclassvalue = objpatclass.value;
						insertobjauthstatusvalue = objauthstatus.value;
						insertobjapprovedamountvalue = objapprovedamount.value;
						insertobjobjapprovalnovalue = objapprovalno.value;

		        		dataElements = dataElements + insertPatientId + "~" + insertEncounterId + "~" + insertDispNo + "~" + insertDrugCode + "~" + insertOrderLineNo+ "~" + insertobjdispqtyvalue + "~" + insertobjorderidvalue+ "~" + insertobjpatclassvalue+ "~" + insertobjauthstatusvalue+ "~" + insertobjapprovedamountvalue+ "~" + insertobjobjapprovalnovalue;
				
						dataElements = dataElements + "#";	 

		        		recCount++;		  

		        	}		  
		}if (compSelected == 0){
			alert("NO RECORDS HAVE BEEN SELECTED");
			return false;
		}
		else		
		{		
			$.ajax({
				url: '../../servlet/eXH.InsAuthStatusGenerateBill',
				type: 'GET',
				cache: false,
				data: {
						callType: 'GenerateBill',
						dataElements: dataElements	
				},
				success: function (data1) {
					responseMsg = data1;
					var fields = responseMsg.split('#');
					var errortext = fields[0]; 					
					var errorstatus = fields[1];

					if(errorstatus=="E"){
						alert("The Bill is not generated - "+errortext+"\n"+"The Error Status - "+errorstatus);
					}else{
						alert("The Bill is generated - "+errortext+"\n"+"The Status - "+errorstatus);
					}
					
				},
				dataType: 'text',
				async: false
			});	
		}
	}
	else 
	{ 
		alert("NO RECORDS HAVE BEEN SELECTED");
		return false;
	}

}
