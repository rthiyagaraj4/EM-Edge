/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/ 
var function_id	= "PH_DISP_LOCN" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;

function create() {
	
	f_query_add_mod.location.href="../../ePH/jsp/DispenseLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DispenseLocationQueryCriteria.jsp?function_id="+function_id ;
}

function  setOtherDetails(frmobj){
  if(frmobj.ALLO_DISP_SHEET){
		if(frmobj.ALLO_DISP_SHEET.checked == false)
			frmobj.ALLO_DISP_SHEET.value = "N";
		else
			frmobj.ALLO_DISP_SHEET.value = "Y";
	}
	
	if(frmobj.DELI_DISP_SHEET){
		if(frmobj.DELI_DISP_SHEET.checked == false)
			frmobj.DELI_DISP_SHEET.value = "N";
		else
			frmobj.DELI_DISP_SHEET.value = "Y";
	}

	if(	frmobj.ALLO_DISP_LABEL){
		if(frmobj.ALLO_DISP_LABEL.checked == false)
			frmobj.ALLO_DISP_LABEL.value = "N";
		else
			frmobj.ALLO_DISP_LABEL.value = "Y";
	}

	if(frmobj.DELI_DISP_LABEL){
		if(frmobj.DELI_DISP_LABEL.checked == false)
			frmobj.DELI_DISP_LABEL.value = "N";
		else
			frmobj.DELI_DISP_LABEL.value = "Y";
	}
		
	if(frmobj.ALLO_DRUG_LABEL){
		if(frmobj.ALLO_DRUG_LABEL.checked == false)
			frmobj.ALLO_DRUG_LABEL.value = "N";
		else
			frmobj.ALLO_DRUG_LABEL.value = "Y";
	}
	
	if(	frmobj.DELI_DRUG_LABEL){
		if(frmobj.DELI_DRUG_LABEL.checked == false)
			frmobj.DELI_DRUG_LABEL.value = "N";
		else
			frmobj.DELI_DRUG_LABEL.value = "Y";
	}
}

function apply() {
	
	if ( !checkIsValidForProceed( "dispenselocationaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var frmobj			= f_query_add_mod.document.formDispenseLocation;
	var continue_flag	= false;

	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";

	if (frmobj.DISP_DRUG_CLASS_G.checked || frmobj.DISP_DRUG_CLASS_N.checked || frmobj.DISP_DRUG_CLASS_C.checked )
		continue_flag = true;

	setOtherDetails(frmobj);

	var STinstalled	= frmobj.ST_INSTALLED.value;
	var mode		= frmobj.mode.value;

	if( mode == MODE_INSERT ) {
		//alert("--- MODE_INSERT---");
		if (frmobj.LINK_EXIST_STORE.checked) {
			var fields	= new Array ( frmobj.STORE_CODE, frmobj.DISP_LOCN_TYPE);
			var names	= new Array ( getLabel("Common.StoreCode.label","Common"),  getLabel("Common.type.label","Common"));
		}
		else {
			var fields	= new Array ( frmobj.DISP_LOCN_CODE, frmobj.LONG_DESC, frmobj.SHORT_DESC, frmobj.DISP_LOCN_TYPE,frmobj.working_hour_from,frmobj.working_hour_to);
			var names	= new Array ( getLabel("ePH.DispenseLocationCode.label","PH"), getLabel("Common.longdescription.label","Common"), getLabel("Common.shortdescription.label","Common"), getLabel("Common.type.label","Common"),getLabel("Common.fromtime.label","Common"),getLabel("Common.totime.label","Common") );
		}

		if (continue_flag) {
			if (frmobj.DISP_LOCN_TYPE.value == "P" && frmobj.ALLOW_MED_RETURN.checked && frmobj.RETURN_WITHIN.value == "") {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("MEDICATION_RETURN_DAYS_CANNOT_BE_BLANK","PH")+"...";
			}
			else if( frmobj.FILL_PROCESS_UNIT!=null ) { 
				if(frmobj.DISP_LOCN_TYPE.value == "P" && (frmobj.FILL_PROCESS_UNIT.value == "H" || frmobj.FILL_PROCESS_UNIT.value == "D") && frmobj.FILL_PROCESS.value == "") {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("FILLPROCESS_FILLPERIOD_CANNOT_BE_BLANK","PH")+"...";
				}
				else{
					if ( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) ) {
						if(!(frmobj.IP_SQENCE_NO_FROM == undefined) && !(frmobj.IP_SQENCE_NO_TO == undefined)){
							if(validateOverlapRange(frmobj)==false){
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
								return;
							}
						}
						eval( formApply(frmobj, PH_CONTROLLER) ) ;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						create();
				    }
				}
			}
			else { 
				if ( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) ) {
					if(!(frmobj.IP_SQENCE_NO_FROM == undefined) && !(frmobj.IP_SQENCE_NO_TO == undefined)){
						if(validateOverlapRange(frmobj)==false){
						//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							return;
						}
					}
					eval( formApply(frmobj, PH_CONTROLLER) ) ;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					create();
				}
			}
		}
		else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_DISP_DRUG_CLS_SHLD_BE_SELECTED","PH");
	}

	if( mode == MODE_MODIFY ) {
		var fields	= new Array ( frmobj.LONG_DESC, frmobj.SHORT_DESC);
		var names	= new Array ( getLabel("Common.longdescription.label","Common"), getLabel("Common.shortdescription.label","Common"));

		if (continue_flag) {
			if(frmobj.ALLOW_MED_RETURN !=undefined){
				if (frmobj.DISP_LOCN_TYPE.value == "P" && frmobj.ALLOW_MED_RETURN.checked && frmobj.RETURN_WITHIN.value == "") {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("MEDICATION_RETURN_DAYS_CANNOT_BE_BLANK","PH");
				}
				else if(frmobj.FILL_PROCESS_UNIT!=undefined && frmobj.DISP_LOCN_TYPE.value == "P" && (frmobj.FILL_PROCESS_UNIT.value == "H" || frmobj.FILL_PROCESS_UNIT.value == "D") && frmobj.FILL_PROCESS.value=="" )  {					
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("FILLPROCESS_FILLPERIOD_CANNOT_BE_BLANK","PH");
				}
				else {
					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
						if(!(frmobj.IP_SQENCE_NO_FROM == undefined) && !(frmobj.IP_SQENCE_NO_TO == undefined)){
							if(validateOverlapRange(frmobj)==false){
							//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
								return;
							}
						}
						var disp_location_code = frmobj.DISP_LOCN_CODE.value;
						eval( formApply(frmobj, PH_CONTROLLER) ) ;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						f_query_add_mod.location.href="../../ePH/jsp/DispenseLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+disp_location_code;
					}
				}
			}
			else {
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
					if(!(frmobj.IP_SQENCE_NO_FROM == undefined) && !(frmobj.IP_SQENCE_NO_TO == undefined)){
						if(validateOverlapRange(frmobj)==false){
						//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							return;
						}
					}
					var disp_location_code = frmobj.DISP_LOCN_CODE.value;
					//alert( formApply(frmobj, PH_CONTROLLER) ) ;
					eval( formApply(frmobj, PH_CONTROLLER) ) ;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					f_query_add_mod.location.href="../../ePH/jsp/DispenseLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+disp_location_code;
				}
			}
		}
		else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_DISP_DRUG_CLS_SHLD_BE_SELECTED","PH");
	}
}

function reset() {
	if ( checkIsValidForProceed( "dispenselocationquerycriteria" ) )
		f_query_add_mod.document.query_form.reset();

	else if ( checkIsValidForProceed( "dispenselocationaddmodify" ) ) {
		var frmobj	= f_query_add_mod.document.formDispenseLocation;
		var def_fill_stage = frmobj.DEF_FILL_STAGE.value;
		
		frmobj.reset();
		if (frmobj.FILL_PROCESS_UNIT){
			if(frmobj.FILL_PROCESS_UNIT.value =="H" || frmobj.FILL_PROCESS_UNIT.value =="D"){
				frmobj.FILL_PROCESS.disabled = false;
			}
			else if(frmobj.FILL_PROCESS_UNIT.value =="P"){
				frmobj.FILL_PROCESS.value = "";
				frmobj.FILL_PROCESS.disabled = true;
			}
		}
		if(frmobj.PRINT_DISP_SHEET){
			if (frmobj.PRINT_DISP_SHEET.checked == false || frmobj.EFF_STATUS.checked == false) {
				frmobj.ALLO_DISP_SHEET.disabled=true;
				frmobj.DELI_DISP_SHEET.disabled=true;
			}
			else{
				frmobj.ALLO_DISP_SHEET.disabled=false;
				frmobj.DELI_DISP_SHEET.disabled=false;
			}
		}

		if(frmobj.DISP_BILL_STAGE){
			if(frmobj.DISP_BILL_STAGE.value=="X" || frmobj.EFF_STATUS.checked == false)
				frmobj.DISP_CASH_COLL_STAGE.disabled=true;
			else
				frmobj.DISP_CASH_COLL_STAGE.disabled=false;
		}

		if (frmobj.FILLING_CHK_BOX) {
		
			if (frmobj.FILLING_CHK_BOX.checked == false)
				populateFillStage(frmobj.FILLING_STAGE, '1');
			else
				populateFillStage(frmobj.FILLING_STAGE, '2');

			frmobj.FILLING_STAGE.value		= def_fill_stage;
			frmobj.FILLING_STAGE.disabled	= false;
		}
		if (frmobj.REGN_CHK_BOX){
			if (frmobj.REGN_CHK_BOX.checked){
				frmobj.PRINT_PRES.disabled	= false;
				frmobj.ISSUE_TOKEN.disabled	= false;
				frmobj.REGN_CHK_BOX.value = 'Y';
				
			}
			else{
				frmobj.PRINT_PRES.disabled	= true;
				frmobj.ISSUE_TOKEN.disabled	= true;		
				frmobj.REGN_CHK_BOX.value = 'N';
				f_query_add_mod.document.getElementById('PREPMEDICATION').style.display = "none";//added for Bru-HIMS-CRF-142 [IN:030195]
			}


		}
		if (frmobj.PRINT_PRES)
		{
			if (frmobj.PRINT_PRES.checked){
			 frmobj.PRINT_PRES.value = 'Y';
			 frmobj.PRINT_PRES.disabled	= false;
			}
		}
		if (frmobj.ISSUE_TOKEN){
			if (frmobj.ISSUE_TOKEN.checked){
				 frmobj.ISSUE_TOKEN.value = 'Y';
				 frmobj.ISSUE_TOKEN.disabled	= false;
			}
		}
//added for Bru-HIMS-CRF-142 [IN:030195]-start
		if(frmobj.PAT_ARRIVAL){
			if(frmobj.PAT_ARRIVAL.checked){
				frmobj.PAT_ARRIVAL.value="Y";
				frmobj.ACTUAL_TOKEN.disabled	= false;
			}
			else{
				frmobj.PAT_ARRIVAL.value="N";
				frmobj.ACTUAL_TOKEN.disabled	= true;
			}
		}
//added for Bru-HIMS-CRF-142 [IN:030195]-end
		if(frmobj.PHARM_VERFN){
			if (def_fill_stage == 'A' || def_fill_stage == 'X')
				populateData(frmobj.PHARM_VERFN, 'X');
			else
				populateData(frmobj.PHARM_VERFN, 'B');
		
			frmobj.PHARM_VERFN.value	= frmobj.DEF_PHARM_VERFN.value;
		}

		if (frmobj.ALLOW_MED_RETURN){
			if (frmobj.ALLOW_MED_RETURN.checked){
				frmobj.return_mandate.style="display";
				frmobj.return_mandate.style.visibility	= "visible";
				frmobj.RETURN_WITHIN.disabled			= false;
			}
			else {
				frmobj.return_mandate.style.display		= "none";
				frmobj.return_mandate.style.visibility	= "hidden";
				frmobj.RETURN_WITHIN.disabled			= true;
			}
		}
		if (frmobj.DIRECT_DISP_ALLOWED_YN){
			
			if (frmobj.mode.value == "2") {		
				if (!frmobj.DIRECT_DISP_ALLOWED_YN.checked){  //direct dispensing check box is unchecked
					if (frmobj.DELI_DISP_LABEL && frmobj.DELI_DISP_SHEET){
						frmobj.DELI_DISP_SHEET.value			= "N";
						frmobj.DELI_DISP_SHEET.disabled			= true;
						frmobj.DELI_DISP_SHEET.checked			= false;
						frmobj.DELI_DISP_LABEL.value			= "N";
						frmobj.DELI_DISP_LABEL.disabled			= true;
						frmobj.DELI_DISP_LABEL.checked			= false;					
					}
				}
				else{						//direct dispensing check box is checked
				   if(frmobj.DELI_DISP_LABEL && frmobj.DELI_DISP_SHEET){
					if(frmobj.PARAM_FCLTY_DISP_FLAG.value == 'Y'){ //when print dispensesheet in parameter for facility flag is checked
						frmobj.DELI_DISP_SHEET.value = frmobj.H_DELI_DISP_SHEET_VAL.value;
						frmobj.DELI_DISP_SHEET.disabled = false;
						if (frmobj.H_DELI_DISP_SHEET_VAL.value == 'Y'){	
						  frmobj.DELI_DISP_SHEET.checked = true;			
						}
						else 
							frmobj.DELI_DISP_SHEET.checked = false;
					}
					else{ // when print dispense sheet in parameter for facility flag is unchecked
					frmobj.DELI_DISP_SHEET.value = "N";
					frmobj.DELI_DISP_SHEET.disabled = true;
					frmobj.DELI_DISP_SHEET.checked = false;
					}

					frmobj.DELI_DISP_LABEL.value = frmobj.H_DELI_DISP_LABEL_VAL.value;
					frmobj.DELI_DISP_LABEL.disabled = false;
					if (frmobj.H_DELI_DISP_LABEL_VAL.value == 'Y')
					{
						frmobj.DELI_DISP_LABEL.checked = true;
                    }else
						frmobj.DELI_DISP_LABEL.checked = false;				
				}//if frmobj.DELI_DISP_LABEL&&frmobj.DELI_DISP_SHEET
				} //else
			} //mode ==if
	  }
		
    	if ( frmobj.mode.value == MODE_INSERT ) {
			setDisabled(frmobj.LINK_EXIST_STORE, frmobj);
			f_query_add_mod.document.getElementById('pharm_links').style.display		= "none";
			f_query_add_mod.document.getElementById('outpatientTable').style.display	= "none";
			f_query_add_mod.document.getElementById('inpatientTable').style.display	= "none";
			f_query_add_mod.document.getElementById('otherdetailsTable').style.display = "none";
			f_query_add_mod.document.getElementById('DispenseDetailTable').style.display = "none";
		}
	}
}

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function validNumber(obj) {
	if (obj.value != "")
		CheckNum(obj);
}

function setDisabled(obj, frmobj) {
	if (frmobj == null)
		frmobj= document.formDispenseLocation ;
    var display_delivery_bin =frmobj.display_delivery_bin.value;
	if (obj.name == "LINK_EXIST_STORE" && obj.checked == false) {
		frmobj.st_mandate.style.display					= "none";
		frmobj.st_mandate.style.visibility				= "hidden";
		frmobj.disp_mandate.style="display";
		frmobj.disp_mandate.style.visibility				= "visible";
		frmobj.longdesc_mandate.style="display";
		frmobj.longdesc_mandate.style.visibility			= "visible";
		frmobj.shortdesc_mandate.style="display";
		frmobj.shortdesc_mandate.style.visibility			= "visible";
		frmobj.STORE_CODE.value			= "";
		frmobj.STORE_CODE.disabled		= true;
		frmobj.STORE_SEARCH.disabled		= true;
		frmobj.DISP_LOCN_CODE.value		= "";
		frmobj.DISP_LOCN_CODE.disabled	= false;
		frmobj.LONG_DESC.value			= "";
		frmobj.LONG_DESC.disabled		= false;
		frmobj.SHORT_DESC.value			= "";
		frmobj.SHORT_DESC.disabled		= false;
	}
	else if (obj.name == "LINK_EXIST_STORE" && obj.checked == true) {
		frmobj.st_mandate.style="display";
		frmobj.st_mandate.style.visibility				= "visible";
		frmobj.disp_mandate.style.display					= "none";
		frmobj.disp_mandate.style.visibility				= "hidden";
		frmobj.longdesc_mandate.style.display				= "none";
		frmobj.longdesc_mandate.style.visibility			= "hidden";
		frmobj.shortdesc_mandate.style.display			= "none";
		frmobj.shortdesc_mandate.style.visibility			= "hidden";
		frmobj.DISP_LOCN_CODE.disabled	= true;
		frmobj.DISP_LOCN_CODE.value		= "";
		frmobj.LONG_DESC.disabled		= true;
		frmobj.LONG_DESC.value			= "";
		frmobj.SHORT_DESC.disabled		= true;
		frmobj.SHORT_DESC.value			= "";
		frmobj.STORE_CODE.value			= "";
		frmobj.STORE_CODE.disabled		= false;
		frmobj.STORE_SEARCH.disabled		= false;
	}
	else if (obj.name == "EFF_STATUS" && obj.checked == true) {
		frmobj.EFF_STATUS.value = "E";
	}
	else if (obj.name == "EFF_STATUS" && obj.checked == false) {
		frmobj.EFF_STATUS.value = "D";
	}
	else if (obj.name == "DISP_DRUG_CLASS_G" && obj.checked == true) {
		frmobj.DISP_DRUG_CLASS_G.value = "Y";
	}
	else if (obj.name == "DISP_DRUG_CLASS_G" && obj.checked == false) {
		frmobj.DISP_DRUG_CLASS_G.value = "N";
	}
	else if (obj.name == "DISP_DRUG_CLASS_N" && obj.checked == true) {
		frmobj.DISP_DRUG_CLASS_N.value = "Y";
	}
	else if (obj.name == "DISP_DRUG_CLASS_N" && obj.checked == false) {
		frmobj.DISP_DRUG_CLASS_N.value = "N";
	}
	else if (obj.name == "DISP_DRUG_CLASS_C" && obj.checked == true) {
		frmobj.DISP_DRUG_CLASS_C.value = "Y";
	}
	else if (obj.name == "DISP_DRUG_CLASS_C" && obj.checked == false) {
		frmobj.DISP_DRUG_CLASS_C.value = "N";
	}
	else if (obj.name == "REGN_CHK_BOX" && obj.checked == true) {
		
		frmobj.REGN_CHK_BOX.value	= "Y";
		frmobj.PRINT_PRES.value		= "N";
		frmobj.ISSUE_TOKEN.value	= "N";
		frmobj.PRINT_PRES.checked	= false;
		frmobj.ISSUE_TOKEN.checked	= false;
		frmobj.PRINT_PRES.disabled	= false;
		frmobj.ISSUE_TOKEN.disabled	= false;
	}
	else if (obj.name == "REGN_CHK_BOX" && obj.checked == false) {
		frmobj.REGN_CHK_BOX.value	= "N";
		frmobj.PRINT_PRES.value		= "N";
		frmobj.ISSUE_TOKEN.value	= "N";
		frmobj.PRINT_PRES.checked	= false;
		frmobj.ISSUE_TOKEN.checked	= false;
		frmobj.PRINT_PRES.disabled	= true;
		frmobj.ISSUE_TOKEN.disabled	= true;
		//added for Bru-HIMS-CRF-142 [IN:030195]-start

		if(display_delivery_bin=="true"){//Added if condition for TH-KW-CRF-0020.9
		   document.getElementById('PREPMEDICATION').style="display";
		   document.getElementById('PREPMEDICATION').style.visibility	= "visible";
		}else{
		   document.getElementById('PREPMEDICATION').style.display		= "none";
		   document.getElementById('PREPMEDICATION').style.visibility	= "hidden";
		}
		frmobj.PAT_ARRIVAL.value	= "N";
		frmobj.ACTUAL_TOKEN.value	= "N";
		//frmobj.TOKEN_NO_LABEL.value	= "N";
		frmobj.ACTUAL_TOKEN.disabled	= true;
		frmobj.PAT_ARRIVAL.checked	= false;
		frmobj.ACTUAL_TOKEN.checked	= false;
		//frmobj.TOKEN_NO_LABEL.checked = false;
		if(display_delivery_bin=="false"){//Added if condition Alone for TH-KW-CRF-0020.9
		   frmobj.STORAGE_LOCN.checked = false;
		}
		//added for Bru-HIMS-CRF-142 [IN:030195]-end
	}
	else if (obj.name == "PRINT_PRES" && obj.checked == false) {
		frmobj.PRINT_PRES.value		= "N";
	}
	else if (obj.name == "PRINT_PRES" && obj.checked == true) {
		frmobj.PRINT_PRES.value		= "Y";
	}
	else if (obj.name == "ISSUE_TOKEN" && obj.checked == false) {
		frmobj.ISSUE_TOKEN.value	= "N";
        //added for Bru-HIMS-CRF-142 [IN:030195]-start
		if(display_delivery_bin=="true"){//Added if condition for TH-KW-CRF-0020.9
		   document.getElementById('PREPMEDICATION').style="display";
		   document.getElementById('PREPMEDICATION').style.visibility	= "visible";
		}else{
		   document.getElementById('PREPMEDICATION').style.display		= "none";
		   document.getElementById('PREPMEDICATION').style.visibility	= "hidden";
		}
		document.getElementById('REG_PAT_LB').style.visibility	= "hidden";//Adding start for TH-KW-CRF-0020.9
		document.getElementById('REG_PAT_TX').style.visibility	= "hidden";
		document.getElementById('PAT_ARRIVAL_LB').style.visibility	= "hidden";
		document.getElementById('PAT_ARRIVAL_TX').style.visibility	= "hidden";//Adding end for TH-KW-CRF-0020.9
		
		//added for Bru-HIMS-CRF-142 [IN:030195]-end
	}
	else if (obj.name == "ISSUE_TOKEN" && obj.checked == true) {
		frmobj.ISSUE_TOKEN.value	= "Y";
      //added for Bru-HIMS-CRF-142 [IN:030195]-start
		document.getElementById('PREPMEDICATION').style="display";
		document.getElementById('PREPMEDICATION').style.visibility	= "visible";
		document.getElementById('REG_PAT_LB').style.visibility	= "visible";//Adding start for TH-KW-CRF-0020.9
		document.getElementById('REG_PAT_TX').style.visibility	= "visible";
		document.getElementById('PAT_ARRIVAL_LB').style.visibility	= "visible";
		document.getElementById('PAT_ARRIVAL_TX').style.visibility	= "visible";//Adding end for TH-KW-CRF-0020.9
		//added for Bru-HIMS-CRF-142 [IN:030195]-end
	}
	else if (obj.name == "FILLING_CHK_BOX" && obj.checked == false) {
		frmobj.FILLING_CHK_BOX.value = "N";
		populateFillStage(frmobj.FILLING_STAGE, '1');
		populateData(frmobj.PHARM_VERFN, 'X');
		frmobj.FILLING_STAGE.disabled	= true;
	}
	else if (obj.name == "FILLING_CHK_BOX" && obj.checked == true) {
		frmobj.FILLING_CHK_BOX.value = "Y";
		populateFillStage(frmobj.FILLING_STAGE, '2');
		populateData(frmobj.PHARM_VERFN, 'B');
		frmobj.FILLING_STAGE.disabled	= false;
	}
	else if (obj.name == "DELIVERY_CHK_BOX" && obj.checked == false) {
		frmobj.DELIVERY_CHK_BOX.value	= "N";
	}
	else if (obj.name == "DELIVERY_CHK_BOX" && obj.checked == true) {
		frmobj.DELIVERY_CHK_BOX.value	= "Y";
	}
	else if (obj.name == "PRINT_DISP_SHEET" && obj.checked == false) {
		
		frmobj.PRINT_DISP_SHEET.value	= "N";
		frmobj.ALLO_DISP_SHEET.checked=false;
		frmobj.ALLO_DISP_SHEET.value="N";
		frmobj.ALLO_DISP_SHEET.disabled=true;
		frmobj.DELI_DISP_SHEET.checked=false;
		frmobj.DELI_DISP_SHEET.value="N";
		frmobj.DELI_DISP_SHEET.disabled=true;
	}
	else if (obj.name == "PRINT_DISP_SHEET" && obj.checked == true) {
		
		frmobj.PRINT_DISP_SHEET.value	= "Y";
		frmobj.ALLO_DISP_SHEET.checked=true;
		frmobj.ALLO_DISP_SHEET.value="Y";
		frmobj.ALLO_DISP_SHEET.disabled=false;
		frmobj.DELI_DISP_SHEET.checked=true;
		frmobj.DELI_DISP_SHEET.value="Y";
		frmobj.DELI_DISP_SHEET.disabled=false;
	}
	else if (obj.name == "PRINT_BAL_MED_SHEET" && obj.checked == false) {
		frmobj.PRINT_BAL_MED_SHEET.value	= "N";
	}
	else if (obj.name == "PRINT_BAL_MED_SHEET" && obj.checked == true) {
		frmobj.PRINT_BAL_MED_SHEET.value	= "Y";
	}
	else if (obj.name == "ALLOW_MED_RETURN" && obj.checked == false) {
		frmobj.return_mandate.style.display		= "none";
		frmobj.return_mandate.style.visibility	= "hidden";
		frmobj.ALLOW_MED_RETURN.value	= "N";
		frmobj.RETURN_WITHIN.value		= "";
		frmobj.RETURN_WITHIN.disabled	= true;
	}
	else if (obj.name == "ALLOW_MED_RETURN" && obj.checked == true) {
		frmobj.return_mandate.style="display";
		frmobj.return_mandate.style.visibility	= "visible";
		frmobj.ALLOW_MED_RETURN.value	= "Y";
		frmobj.RETURN_WITHIN.disabled	= false;
		//frmobj.RETURN_WITHIN.focus();
	}
	else if (obj.name == "VERIFY" && obj.checked == true) {
		frmobj.VERIFY.value = "Y";
	}
	else if (obj.name == "VERIFY" && obj.checked == false) {
		frmobj.VERIFY.value = "N";
	}
	else if (obj.name == "DELIVERY" && obj.checked == true) {
		frmobj.DELIVERY.value = "Y";
	}
	else if (obj.name == "DELIVERY" && obj.checked == false) {
		frmobj.DELIVERY.value = "N";
	}
	else if (obj.name == "ADMIX_PREP_ALWD" && obj.checked == true) {
		frmobj.ADMIX_PREP_ALWD.value = "Y";
	}
	else if (obj.name == "ADMIX_PREP_ALWD" && obj.checked == false) {
		frmobj.ADMIX_PREP_ALWD.value = "N";
	}
	else if(obj.name == "ALLO_DISP_SHEET" ){
		if(obj.checked == false)
			frmobj.ALLO_DISP_SHEET.value = "N";
		else
			frmobj.ALLO_DISP_SHEET.value = "Y";
	}
	else if(obj.name == "DELI_DISP_SHEET" ){
		if(obj.checked == false)
			frmobj.DELI_DISP_SHEET.value = "N";
		else
			frmobj.DELI_DISP_SHEET.value = "Y";
	}
	else if(obj.name == "ALLO_DISP_LABEL" ){
		if(obj.checked == false)
			frmobj.ALLO_DISP_LABEL.value = "N";
		else
			frmobj.ALLO_DISP_LABEL.value = "Y";
	}
	else if(obj.name == "DELI_DISP_LABEL" ){
		if(obj.checked == false)
			frmobj.DELI_DISP_LABEL.value = "N";
		else
			frmobj.DELI_DISP_LABEL.value = "Y";
	}
	else if(obj.name == "ALLO_DRUG_LABEL" ){
		if(obj.checked == false)
			frmobj.ALLO_DRUG_LABEL.value = "N";
		else
			frmobj.ALLO_DRUG_LABEL.value = "Y";
	}
	else if(obj.name == "DELI_DRUG_LABEL" ){
		if(obj.checked == false)
			frmobj.DELI_DRUG_LABEL.value = "N";
		else
			frmobj.DELI_DRUG_LABEL.value = "Y";
	}
	else if (obj.name == "DIRECT_DISP_ALLOWED_YN"){
		if (!obj.checked){
			if (frmobj.DELI_DISP_LABEL && frmobj.DELI_DISP_SHEET){
				frmobj.DELI_DISP_LABEL.value = "N";
				frmobj.DELI_DISP_LABEL.disabled = true;
				frmobj.DELI_DISP_LABEL.checked = false;

				frmobj.DELI_DISP_SHEET.value = "N";
				frmobj.DELI_DISP_SHEET.disabled = true;
				frmobj.DELI_DISP_SHEET.checked = false;
			}
		}
		else{	
			if (frmobj.DELI_DISP_LABEL && frmobj.DELI_DISP_SHEET){
				if (frmobj.PARAM_FCLTY_DISP_FLAG.value == 'Y'){
					frmobj.DELI_DISP_SHEET.value = "Y";
					frmobj.DELI_DISP_SHEET.disabled = false;
					frmobj.DELI_DISP_SHEET.checked = true;			
				}
				else{
					frmobj.DELI_DISP_SHEET.value = "N";
					frmobj.DELI_DISP_SHEET.disabled = true;
					frmobj.DELI_DISP_SHEET.checked = false;
				}
				frmobj.DELI_DISP_LABEL.value = "Y";
				frmobj.DELI_DISP_LABEL.disabled = false;
				frmobj.DELI_DISP_LABEL.checked = true;
			}
		}
	}
	else if (obj.name == "CURRENT_DISP_LOC"){//Added for HSA-CRF-0113 [IN:048166] Start
		if(!obj.checked) {
			frmobj.defBMSDispLoc.disabled		= false;
			frmobj.CURRENT_DISP_LOC.value		= "N";
		}
		else {
			frmobj.defBMSDispLoc.value		= "";
			frmobj.defBMSDispLoc.disabled		= true;
			frmobj.CURRENT_DISP_LOC.value		= "Y";
		}
	}//Added for HSA-CRF-0113 [IN:048166] End
	/*else if(display_delivery_bin=="true")
		 
	{
		document.getElementById("DELIVERYBIN").style.display          ="inline";
		document.getElementById("PREPMEDICATION").style="display";
		document.getElementById("PREPMEDICATION").style.visibility	= "visible";
	}*/
}

function showSelect(objval) {
//	alert("objval>>"+objval);
	if (objval == "P") {
		document.getElementById('PharmacyTable').style="display";
		document.getElementById('PharmacyTable').style.visibility = "visible";
		document.getElementById('DISP_LOCN_CATEGORY').style="display";
		document.getElementById('DISP_LOCN_CATEGORY').style.visibility = "visible";
		document.getElementById('MANDATE_CATEGORY').style="display";
		document.getElementById('MANDATE_CATEGORY').style.visibility= "visible";
	
		if (document.formDispenseLocation.IP_INSTALLED.value == "Y"){
			document.formDispenseLocation.DISP_LOCN_CATEGORY.value	= "B";
		}
		else {
			document.formDispenseLocation.DISP_LOCN_CATEGORY.value	= "O";
			disableLinks("O");
		}

		document.getElementById('STAGE_LABEL_ID').style="display";
		document.getElementById('STAGE_LABEL_ID').style.visibility			= "visible";
		document.getElementById('DISP_STAGE').style="display";
		document.getElementById('DISP_STAGE').style.visibility				= "visible";
		document.getElementById('MANDATE_STAGE').style="display";
		document.getElementById('MANDATE_STAGE').style.visibility				= "visible";
		document.getElementById('disp_level_td').style.visibility				= "visible";
		document.getElementById('disp_level').style.visibility				= "visible";
		document.getElementById('disp_level').value							= "O";

		var IPinstalled = document.formDispenseLocation.IP_INSTALLED.value;
		if ( IPinstalled == "Y") {
			document.getElementById('pharm_links').style="display";
			document.getElementById('pharm_links').style.visibility	= "visible";
			document.getElementById('OP_Pharm_link').style="display";
			document.getElementById('OP_Pharm_link').style.visibility	= "visible";

			if (document.getElementById("IP_Pharm_link")) {
				document.getElementById("IP_Pharm_link").style="display";
				document.getElementById("IP_Pharm_link").style.visibility	= "visible";
			}
			if (document.getElementById('IP_Pharm')) {
				document.getElementById('IP_Pharm').style="display";
				document.getElementById('IP_Pharm').style.visibility		= "visible";
	
			}
			//document.getElementById("OP_Pharm").style="display";
			//document.getElementById("OP_Pharm").style.visibility		= "visible";

			//document.getElementById("OP_Pharm").src="../../ePH/images/Outpatient Pharmacy_click.gif";
			//document.getElementById("IP_Pharm").src="../../ePH/images/Inpatient Pharmacy.gif";
		
			document.getElementById("OP_Pharm_link").click();
		}
	}
	else if(objval == "" || objval == null){
	//	document.getElementById("BillingInterfaceTable").style.display		= "none";
		//document.getElementById("BillingInterfaceTable").style.visibility		= "hidden";
		
	}
	else {

	//	document.getElementById("PharmacyTable").style.display = "none";
	//	document.getElementById("otherdetailsTable").style.display	 =	"none";
		//document.getElementById("BillingInterfaceTable").style="display";
	//	document.getElementById("BillingInterfaceTable").style.visibility		= "visible";
		document.getElementById('PharmacyTable').style="display";
		document.getElementById('PharmacyTable').style.visibility		= "hidden";
		document.getElementById('otherdetailsTable').style="display";
		document.getElementById('otherdetailsTable').style.visibility	 =	"hidden";
		document.getElementById('DISP_LOCN_CATEGORY').style="display";
		document.getElementById('catgSelect').style.visibility		= "hidden";
		document.getElementById('MANDATE_CATEGORY').style="display";
		document.getElementById('MANDATE_CATEGORY').style.visibility	= "hidden";

		disableLinks("X");

		document.getElementById('STAGE_LABEL_ID').style="display";
		document.getElementById('STAGE_LABEL_ID').style.visibility			= "hidden";
		document.getElementById('DISP_STAGE').style="display";
		document.getElementById('DISP_STAGE').style.visibility				= "hidden";
		document.getElementById('MANDATE_STAGE').style="display";
		document.getElementById('MANDATE_STAGE').style.visibility				= "hidden";
		document.getElementById('disp_level_td').style.visibility				= "hidden";
		document.getElementById('disp_level').style.visibility				= "hidden";
		document.getElementById('disp_level').value							= "";
	}
}

function disableLinks(objval) {
	
    //alert(objval);
	document.formDispenseLocation.pharmacyType.value = objval;	
	var IPinstalled = document.formDispenseLocation.IP_INSTALLED.value;

	if (objval == "O") {
		document.getElementById('pharm_links').style="display";
		document.getElementById('pharm_links').style.visibility	= "visible";
		document.getElementById('OP_Pharm_lin').style="display";
		document.getElementById('OP_Pharm_link').style="display";
		if (document.getElementById('IP_Pharm_link')) {
			document.getElementById('IP_Pharm_lin').style.display	= "none";
			
		}
	
	/*	if (document.getElementById("IP_Pharm")) {
			document.getElementById("IP_Pharm").style.display			= "none";
			
		} */
	
		document.getElementById('disp_level').style.visibility	= "visible";
	
		document.getElementById('OP_Pharm_link').click();

	}
	else if (objval == "I" && IPinstalled == "Y") {
		document.getElementById("pharm_links").style="display";
		document.getElementById("pharm_links").style.visibility	= "visible";
		document.getElementById("IP_Pharm_link").style="display";
		document.getElementById("IP_Pharm_lin").style="display";
		
		if (document.getElementById("OP_Pharm_link")) {
		document.getElementById("OP_Pharm_lin").style.display	= "none";
		}
	/*	if (document.getElementById("OP_Pharm")) {
			document.getElementById("OP_Pharm").style.display			= "none";
			
		} */
		
		
		
		document.getElementById('disp_level').style.visibility	= "visible";
		document.getElementById('disp_level').value				= "P";
	
		document.getElementById('IP_Pharm_link').click();
	}
	else if (objval == "B" && IPinstalled == "Y") {
		document.getElementById("pharm_links").style="display";
		document.getElementById('pharm_links').style.visibility	= "visible";
		document.getElementById("OP_Pharm_link").style="display";
		document.getElementById("OP_Pharm_lin").style="display";
		
			document.getElementById("IP_Pharm_link").style="display";
			document.getElementById("IP_Pharm_lin").style="display";
	
	
		document.getElementById("disp_level").value				= "O";
		
		
		document.getElementById("OP_Pharm_link").click();
	}
	else if (objval == "X") {
		document.getElementById("pharm_links").style.display			= "none";
		document.getElementById("pharm_links").style.visibility		= "hidden";
		document.getElementById("OP_Pharm_link").style.display		= "none";
		document.getElementById("OP_Pharm_link").style.visibility		= "hidden";
		if (document.getElementById("IP_Pharm_link")) {
			document.getElementById("IP_Pharm_link").style.display		= "none";
			document.getElementById("IP_Pharm_link").style.visibility		= "hidden";
		}
		/*if (document.getElementById("IP_Pharm")) {
			document.getElementById("IP_Pharm").style.display				= "none";
			document.getElementById("IP_Pharm").style.visibility			= "hidden";
		}*/
		document.getElementById("OP_Pharm_link").style.display				= "none";
		document.getElementById("OP_Pharm_link").style.visibility			= "hidden";
		document.getElementById("outpatientTable").style.display		= "none";
		document.getElementById("outpatientTable").style.visibility	= "hidden";
		if (document.getElementById("inpatientTable")) {
			document.getElementById("inpatientTable").style.display		= "none";
			document.getElementById("inpatientTable").style.visibility	= "hidden";
		}
	}
}

function validateForGreaterValue(preValue, obj, mode) {
	objVal = obj.value == "" ? "" : parseInt(obj.value);
	if (mode == 1) {
		if (obj.name == "IP_FILL_DISP_PRD" && document.formDispenseLocation.IP_FILL_DISP_PRD_UNIT.value == "D"){ /* if block alone added for SRR20056-CRF-0663 */
			objVal = 24*(objVal);
		}
		else if (obj.name != "IP_FILL_DISP_PRD" && document.formDispenseLocation.FILL_PROCESS_UNIT.value == "D"){
			objVal = 24*(objVal);
		}
	}
	if (obj.name != "IP_FILL_DISP_PRD"){ /* if (obj.name != "ip_fill_disp_prd") added for SRR20056-CRF-0663 */
		if (mode != 0) {
			if (objVal == "" && preValue != "") {
				//alert(getMessage("SHOULD_NOT_BE_BLANK","Common"));
				var msg1	= getMessage("CAN_NOT_BE_BLANK","Common")
					if(mode==1)
						msg1		= msg1.replace('$', getLabel("ePH.FillPeriod.label","PH"));
					if(mode==2)
						msg1		= msg1.replace('$', getLabel("ePH.NumberofDaysToReturnMedication.label","PH"));
				
				obj.value="";//Edge Having issue as it is going in loop	
				alert(msg1);
				
				//obj.focus();
				return false;
			}
		}
	}
	if (objVal > parseInt(preValue)) {
		var msg	= getMessage("PH_ENT_VAL_GREATER_EXIST_VAL","PH");

		if (obj.name == "RETURN_WITHIN")
			msg	= msg.replace('&', getLabel("ePH.NumberofDaysToReturnMedication.label","PH"));
		else if (obj.name == "MAX_RETURN_STOCK")
			msg	= msg.replace('&', getLabel("ePH.MaxDrugsRetentionPeriodBeforeReturn.label","PH"));
		else if (obj.name == "FILL_PROCESS"){
			msg	= msg.replace('&', getLabel("ePH.IPFillPeriod.label","PH"));			
			document.formDispenseLocation.FILL_PROCESS_UNIT.options[0].selected=true;
		}
		else if (obj.name == "EXCLUDE_ORDERS")
			msg	= msg.replace('&', getLabel("ePH.DurationToExcludeNewOrdersPlaced.label","PH"));
		else if (obj.name == "IP_FILL_DISP_PRD"){ /* else if (obj.name == "ip_fill_disp_prd")block added for SRR20056-CRF-0663 */
			msg	= msg.replace('&', ( getLabel("ePH.FillPeriod.label","PH")+': ' +getLabel("ePH.FillWithoutFillList.label","PH")));		
			document.formDispenseLocation.IP_FILL_DISP_PRD_UNIT.options[0].selected=true;
		}
		alert(msg);
		obj.value="";
		//obj.focus();
		return false;
	}
}

function CheckTime(obj) {
	var timefield = obj;
	if(obj.value!="") {
	if (tmchk(obj) == false) {
		alert(getMessage("INVALID_TIME","PH"));
		timefield.value = ""; //Edge Having issue as it is going in loop
		timefield.select();
		timefield.focus();
		return false;
	}
	else {
		appendzero(obj);
		comparetime();
		return true;
	}
	}
}

function tmchk(obj1) {

	var strTime;
	var strHr;
	var strMi;
    var timefield = obj1;
	var strTimeArray = new Array();

	strTime = timefield.value;
	if (strTime.length == 0) return true;

	strTimeArray = strTime.split(":");
	if (strTimeArray.length != 2) {
	return false;
	}
	else {
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
	}
	if (strHr.length > 2) return false;
	if (strMi.length > 2) return false;
	if (isNaN(strHr) == true) return false;
	if (isNaN(strMi) == true) return false;
	if (strHr < 0 || strHr > 23) return false;
	if (strMi < 0 || strMi > 59) return false;
}

async function searchCode( target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var sql_string			= document.formDispenseLocation.select_store_code_sql.value;
	dataNameArray[0] = "FACILITY_ID" ;
	dataValueArray[0] = document.formDispenseLocation.facility_id.value;
	dataTypeArray[0] = STRING ;
	var sql_ph_disp_locn_select5 = "SELECT A.STORE_CODE CODE, B.LONG_DESC DESCRIPTION FROM ST_STORE A,MM_STORE_LANG_VW B WHERE A.STORE_TYPE_FLAG='P' AND A.MEDICAL_ITEM_YN ='Y' AND UPPER(B.FACILITY_ID) LIKE UPPER(?) AND B.STORE_CODE = A.STORE_CODE AND UPPER(A.STORE_CODE) LIKE UPPER(?) AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND B.LANGUAGE_ID = '"+document.formDispenseLocation.language_id.value+"' ";//15977 START
	//argumentArray[0] = document.formDispenseLocation.SQL_PH_DISP_LOCN_SELECT5.value+"'"+document.formDispenseLocation.language_id.value+"'";
	argumentArray[0] = sql_ph_disp_locn_select5; //15977 END    
	argumentArray[1] = dataNameArray ; 
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formDispenseLocation.STORE_CODE.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray =await CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
	var str =unescape(retArray);
  	var arr = str.split(",");

	if(retArray != null && retArray != "" )  {
 		target.value = arr[0] ; /* if code need to be returned */
		document.formDispenseLocation.DISP_LOCN_CODE.value=arr[0] ;
		document.formDispenseLocation.disp_locn_code.value=arr[0] ;
		validateCode(document.formDispenseLocation.STORE_CODE);
 		target.focus();
	}
}

function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}

function Modify(obj) {
	var disp_location_code = obj.cells[0].innerText;
	document.location.href="../../ePH/jsp/DispenseLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+disp_location_code;
}

function validateCode ( obj ) {
	if (obj.value != '') {
		var objname		= obj.name ;

		var bean_id		= document.formDispenseLocation.bean_id.value ;
		var bean_name	= document.formDispenseLocation.bean_name.value ;



		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr += obj.name+"=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if (objname == "DISP_LOCN_CODE")
			xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=DISP_LOCN_CODE" + "&object=" + objname, false ) ;
		else if (objname == "STORE_CODE")
			xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=STORE_CODE" + "&object=" + objname, false ) ;


		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	else if(obj.value == '' && obj.name=="STORE_CODE"){
		document.formDispenseLocation.DISP_LOCN_CODE.value="";
	}
}

function callalert(obj) {
	alert(getMessage("CODE_ALREADY_EXISTS",'Common'));
	if(obj=="DISP_LOCN_CODE")
		document.formDispenseLocation.DISP_LOCN_CODE.focus();
	else
		document.formDispenseLocation.STORE_CODE.focus();
}

function toggleEditingFill(objVal) {
	if (objVal == "P") {
		document.formDispenseLocation.FILL_PROCESS.value	= "";
		document.formDispenseLocation.FILL_PROCESS.disabled	= true;
		document.formDispenseLocation.ip_fill_mandate.style.display		= "none";
		document.formDispenseLocation.ip_fill_mandate.style.visibility	= "hidden";
	}
	else {
		document.formDispenseLocation.FILL_PROCESS.disabled	= false;
		document.formDispenseLocation.FILL_PROCESS.focus();
		document.formDispenseLocation.ip_fill_mandate.style="display";
		document.formDispenseLocation.ip_fill_mandate.style.visibility	= "visible";
	}
}
/* added for SRR20056-CRF-0663 ----------------START*/
function toggleEditingFillDISP_PRD(objVal) {
	if (objVal == "P") {
		document.formDispenseLocation.IP_FILL_DISP_PRD.value	= "";
		document.formDispenseLocation.IP_FILL_DISP_PRD.disabled	= true;
	}
	else {
		document.formDispenseLocation.IP_FILL_DISP_PRD.disabled	= false;
		document.formDispenseLocation.IP_FILL_DISP_PRD.focus();
	}
}
/* added for SRR20056-CRF-0663 ----------------END*/
function assignDescs(objval) {
	var descs = objval.split('|');
	if (descs.length == 3) {
		document.formDispenseLocation.DISP_LOCN_CODE.value	= descs[0];
		document.formDispenseLocation.SHORT_DESC.value		= descs[1];
		document.formDispenseLocation.LONG_DESC.value		= descs[2];
	}
}

function populateFillStage(obj, val) {
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("FILLING_STAGE");
	}

	if(val == '1') {
		var opt	= document.createElement('OPTION');
		opt.value =	"X";
		opt.text = getLabel("Common.notapplicable.label","Common");
		obj.add(opt);
	}

	else if(val == '2') {
		var opt	= document.createElement('OPTION');
		opt.value =	"B";
		opt.text = getLabel("ePH.BeforeAllocation.label","PH");
		obj.add(opt);

		var opt	= document.createElement('OPTION');
		opt.value =	"A";
		opt.text = getLabel("ePH.AfterAllocation.label","PH");
		obj.add(opt);
	}
}

function populateData(obj, objval) {
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("PHARM_VERFN");
	}

	if(objval == 'B') {
		var opt	= document.createElement('OPTION');
		opt.value =	"F";
		opt.text =getLabel("ePH.SeparateBeforeFill.label","PH");
		obj.add(opt);

		var opt	= document.createElement('OPTION');
		opt.value =	"C";
		opt.text = getLabel("ePH.CombinedWithAllocation.label","PH");
		obj.add(opt);
	}

	else if(objval == 'A' || objval == 'X') {
		var opt	= document.createElement('OPTION');
		opt.value =	"B";
		opt.text = getLabel("ePH.SeparateBeforeAllocation.label","PH");
		obj.add(opt);

		var opt	= document.createElement('OPTION');
		opt.value =	"C";
		opt.text = getLabel("ePH.CombinedWithAllocation.label","PH");
		obj.add(opt);
	}
}

function changeCursor(obj) {
	obj.style.cursor = "pointer" ;
}


function beforePost(xmlStr) {
//	alert(xmlStr);
}
function chktimefld()
{
  
  var formObj=document.formDispenseLocation;
  if(formObj.working_hour_from.value=="" && formObj.working_hour_to.value!="")
	{ 
	  alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
      //formObj.working_hour_from.focus();
   }
}
function comparetime() {
	var formObj=document.formDispenseLocation;
	//alert("in function"+formObj.name);
	var obj1=formObj.working_hour_from.value;
	var obj2=formObj.working_hour_to.value;
	
	var strHr;
	var strMi;
	
	var strHr1;
	var strMi1;
	
	var timefield = obj1;
	var strTimeArray = new Array();

	var timefield1 = obj2;
	var strTimeArray1 = new Array();
	
   if(obj1!="" && obj2 !=""){	
		
	strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];

    strTimeArray = timefield1.split(":");
		strHr1 = strTimeArray[0];
		strMi1 = strTimeArray[1];
		//alert("in compare"+strHr+"----"+strHr1);
		if(strHr > strHr1){ 
		alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
		formObj.working_hour_to.focus();
		return false;
		}
		if(strHr == strHr1){
			     if(strMi > strMi1){ 
				  alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
				  formObj.working_hour_to.focus();
				 return false;
				 }
	    }
	}
}

function CheckBillStage(obj)
{
	//added for SRR20056-SCF-7639 ICN027720 -start
	if(obj.name == 'DISP_BILL_STAGE')
		cashCollStageobj=document.formDispenseLocation.DISP_CASH_COLL_STAGE;
	else
		cashCollStageobj =document.formDispenseLocation.DISP_CASH_COLL_STAGE_OP;
	////added for SRR20056-SCF-7639 ICN027720 -END
	if((obj.value=='A')||(obj.value=='D'))
		cashCollStageobj.disabled	= false;
	else if(obj.value=='X')
	{
		cashCollStageobj.value='X';
		cashCollStageobj.disabled	= true;
	}
}
function showtimings(objval) {
	if (objval == "P") {
		document.getElementById("time_links").style="display";
    document.getElementById("time_links").style.visibility	= "visible";
		document.formDispenseLocation.working_hour_from.focus();

	}
	else 
	{   document.getElementById("time_links").style.display	= "none";
		document.getElementById("time_links").style.visibility	= "hidden";}
}
function  appedzero(obj){
	var from_val	=	obj.value;
	var frm_hrs		=	new Array();
	if(!from_val=="" && !from_val==null)
	{
	frm_hrs=from_val.split(":");
	var strHr;
	var strMi;
	strHr = frm_hrs[0];
	strMi = frm_hrs[1];
	if(!strHr=="" && !strHr==null)
		if(strHr.length==1) {  strHr	=	"0"+ strHr; }
	if(!strMi=="" && !strMi==null)
		if(strMi.length==1) {  strMi	=	"0"+ strMi; }
	obj.value=strHr+":"+strMi;
	}
}
function validate(obj){
	if(CheckTime(obj) == false){
		obj.value=""; 
		obj.select();
		obj.focus();}
	else{
	appedzero(obj);
	comparetime();
	}
}


async function searchReasonCode( target ) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	argumentArray[0] =document.formDispenseremarks.SQL_PH_DISP_LOCN_SELECT11.value+"'"+document.formDispenseremarks.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	
	retArray =await CommonLookup( getLabel("ePH.ReasonCodes.label","PH"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" )  {
			
 		document.formDispenseremarks.reason_code.value=arr[0] ;
		document.formDispenseremarks.remarks.value=arr[1] ;
		var bean_id 	=	"DispenseLocationBean" ;
		var bean_name 	= "ePH.DispenseLocationBean";
		xmlStr			= "<root><SEARCH " ;
		xmlStr += "remarks=\""+ encodeURIComponent( arr[0]) +"\" " ;
		xmlStr += "remarks_desc=\""+ encodeURIComponent( arr[1]) +"\" " ;
		xmlStr 			+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=saveRemark", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
			eval( responseText ) ;
		
	}
}



async function callremarks(){

	var dialogHeight	= "200px" ;
	var dialogWidth		= "600px" ;
	var dialogTop		= "250" ;
	var dialogLeft		= "203" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
   var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:no" ;
   var arguments	= "";
   bean_id				= document.formDispenseLocation.bean_id.value;
 	bean_name			= document.formDispenseLocation.bean_name.value;
	disp_locn_code		= document.formDispenseLocation.disp_locn_code.value;
	

	var retVal =await window.showModalDialog("../../ePH/jsp/DispenseLocationRemarks.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&disp_locn_code="+disp_locn_code,arguments,features);

}

async function callViewRanges(){

   var dialogHeight	= "12" ;
	var dialogWidth		= "30" ;
	var dialogTop		= "250" ;
	var dialogLeft		= "203" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";

   var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:yes" ;
   var arguments	= "";
   bean_id				= document.formDispenseLocation.bean_id.value;
 	bean_name			= document.formDispenseLocation.bean_name.value;
	disp_locn_code		= document.formDispenseLocation.disp_locn_code.value;
	

	var retVal =await window.showModalDialog("../../ePH/jsp/ViewDailySequenceNumberRanges.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&disp_locn_code="+disp_locn_code,arguments,features);

}



function assignRemarksDescs(objval) {
	

		var va=decodeURIComponent(objval,"UTF-8");
		var strCheck = new Array("+");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(va.indexOf(strCheck[i]) != -1 ){
			while(va.indexOf(strCheck[i]) != -1){
				va = va.replace(strCheck[i]," ");
			}
			i++;
		}
	}
	
		
		document.formDispenseremarks.remarks_desc.value=va;
			
	}


function saveRemarks(){
			var bean_id 	=	"DispenseLocationBean" ;
		var bean_name 	= "ePH.DispenseLocationBean";
if(document.formDispenseremarks.reason_code.value!=""){
		xmlStr			= "<root><SEARCH " ;
		xmlStr += "remarks=\""+  encodeURIComponent(document.formDispenseremarks.reason_code.value) +"\" " ;
		xmlStr += "remarks_desc=\""+ encodeURIComponent(document.formDispenseremarks.remarks.value) +"\" " ;
		xmlStr 			+=" /></root>" ;
		
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=saveRemarks", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
}
parent.document.getElementById('dialog_tag').close();  
}
/* Commented b'z not used (while SRR20056-CRF-0663)
function isNumeric1(obj)
{
	var str=obj.value;
	
	var chk="1234567890";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				 alert(getMessage("NUM_ALLOWED", "SM"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
}
*/

function isGreater()
{
var IP_SQENCE_NO_TO =parseInt(document.formDispenseLocation.IP_SQENCE_NO_TO.value);
var IP_SQENCE_NO_FROM = parseInt(document.formDispenseLocation.IP_SQENCE_NO_FROM.value);
if(IP_SQENCE_NO_TO < IP_SQENCE_NO_FROM)
	{
	alert(getMessage("DAILY_SEQUENCE_RANGE_TO_SHOULD_BE_GREATER_THAN_FROM","PH"));
	document.formDispenseLocation.IP_SQENCE_NO_TO.focus();
	document.formDispenseLocation.IP_SQENCE_NO_TO.select();
	return false;
	}

	return true;
}

function validateOverlapRange (frmobj) {
	
		var bean_id		= frmobj.bean_id.value ;
		var bean_name	= frmobj.bean_name.value ;

		var IP_SQE_NO_FROM	= trimString(frmobj.IP_SQENCE_NO_FROM.value);
		var IP_SQE_NO_TO	= trimString(frmobj.IP_SQENCE_NO_TO.value);
		var DISP_LOCN_CODE	= trimString(frmobj.DISP_LOCN_CODE.value);

		
		if((IP_SQE_NO_FROM == null || IP_SQE_NO_FROM =="") && (IP_SQE_NO_TO!=null && IP_SQE_NO_TO!=""))
		{
			
		//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("DAILY_SEQUENCE_RANGE_FROM_BLANK","PH");
			alert(getMessage("DAILY_SEQUENCE_RANGE_FROM_BLANK","PH"));
			
			frmobj.IP_SQENCE_NO_FROM.focus();
			return false;
		}
		if((IP_SQE_NO_TO == null || IP_SQE_NO_TO=="") && (IP_SQE_NO_FROM!=null && IP_SQE_NO_FROM!=""))
		{
			alert(getMessage("DAILY_SEQUENCE_RANGE_TO_BLANK","PH"));
			frmobj.IP_SQENCE_NO_TO.focus();
			return false;
		} 

if((IP_SQE_NO_FROM!=null && IP_SQE_NO_FROM!="") && (IP_SQE_NO_TO!=null && IP_SQE_NO_TO!=""))
	{
		if(Math.abs(IP_SQE_NO_TO) <= Math.abs(IP_SQE_NO_FROM))
			{
				alert(getMessage("DAILY_SEQUENCE_RANGE_TO_SHOULD_BE_GREATER_THAN_FROM","PH"));
				frmobj.IP_SQENCE_NO_TO.focus();
				frmobj.IP_SQENCE_NO_TO.select();
				return false ;
			}
	}


		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=IP_DAILY_SQENCE_NO&IP_SQE_NO_FROM="+IP_SQE_NO_FROM+"&IP_SQE_NO_TO="+IP_SQE_NO_TO+"&DISP_LOCN_CODE="+DISP_LOCN_CODE, false ) ;

		xmlHttp.send( xmlDoc ) ;
		
		responseText=xmlHttp.responseText ;
	
		return (eval( responseText )) ;
	}

	function callconform()
	{
		var msg = getMessage("DEFINED_SEQUENCE_RANGE_OVERLAP_YN","PH");
		var cof=confirm(msg);
		
		if(cof)
		{
		return true;
		}
		else
		{
		frames[1].document.formDispenseLocation.IP_SQENCE_NO_FROM.value="";
		frames[1].document.formDispenseLocation.IP_SQENCE_NO_TO.value="";
		return false;
		}
	}

 function  appendzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }else if(strHr.length>2){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }else if(strMi.length>2){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
	
}
//To check zeros
function checkIsNotZero(obj, appendObj){
	 if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)
		    return true;
     else {
        if ( obj.value.length > 0 && obj.value==0){
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+" " + appendObj);
			obj.select();
			obj.focus();
			return false;
		}
	}
}

function selectAll(obj){
	var	rows_num	=	document.forms[0].rows_count.value
	var select_all	=	obj.value
	var report_id=	'';
	var list_name	=	'';	
	for (i =0;i< rows_num; i++){
		if ((eval("document.forms[0].op_alloc_"+i) != undefined)&&(eval("document.forms[0].op_alloc_"+i).disabled == false)){
			eval("document.forms[0].op_alloc_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'OP_A';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].op_fill_"+i) != undefined)&&(eval("document.forms[0].op_fill_"+i).disabled == false)){
			eval("document.forms[0].op_fill_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'OP_F';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].op_deliver_"+i) != undefined)&&(eval("document.forms[0].op_deliver_"+i).disabled == false)){
			eval("document.forms[0].op_deliver_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'OP_D';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].op_allstages_"+i) != undefined)&&(eval("document.forms[0].op_allstages_"+i).disabled == false)){
			eval("document.forms[0].op_allstages_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'OP_AS';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].ip_fill_fp_"+i) != undefined)&&(eval("document.forms[0].ip_fill_fp_"+i).disabled == false)){
			eval("document.forms[0].ip_fill_fp_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'IP_FP';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].ip_fill_with_fill_"+i) != undefined)&&(eval("document.forms[0].ip_fill_with_fill_"+i).disabled == false)){
			eval("document.forms[0].ip_fill_with_fill_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'IP_AF';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].ip_fill_without_fill_"+i) != undefined)&&(eval("document.forms[0].ip_fill_without_fill_"+i).disabled == false)){
			eval("document.forms[0].ip_fill_without_fill_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'IP_F';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].ip_deliver_with_fill_"+i) != undefined)&&(eval("document.forms[0].ip_deliver_with_fill_"+i).disabled == false)){
			eval("document.forms[0].ip_deliver_with_fill_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'IP_DF';	
			checkList(obj,list_name,report_id);
		}
		if ((eval("document.forms[0].ip_deliver_without_fill_"+i) != undefined)&&(eval("document.forms[0].ip_deliver_without_fill_"+i).disabled == false)){
			eval("document.forms[0].ip_deliver_without_fill_"+i).value = select_all;
			report_id =eval("document.forms[0].report_id_"+i).value;
			list_name	= 'IP_D';	
			checkList(obj,list_name,report_id);
		}
	}//for	
}

async function callonlineSetup(){
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "78vw" ;
	var dialogTop		= "100" ;
	var dialogLeft		= "100" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="yes";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:yes" ;
	var arguments	= "";
	bean_id				= document.formDispenseLocation.bean_id.value;
	bean_name			= document.formDispenseLocation.bean_name.value;
	disp_locn_code		= document.formDispenseLocation.disp_locn_code.value;
	var mode			= document.formDispenseLocation.mode.value;
	var allocate_legend	= document.formDispenseLocation.h_allocate_legend.value;
	var fill_legend		= document.formDispenseLocation.h_fill_legend.value;
	var delivery_legend	= document.formDispenseLocation.h_delivery_legend.value;
	var pharmacyType	= '';
	if (mode == '1')
		pharmacyType = document.formDispenseLocation.pharmacyType.value;
	else
		pharmacyType = '';
	var retVal =await window.showModalDialog("../../ePH/jsp/DispenseLocationOnlinePrintSetup.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&disp_locn_code="+disp_locn_code+"&allocate_legend="+allocate_legend+"&fill_legend="+fill_legend+"&delivery_legend="+delivery_legend+"&mode="+mode+"&pharmacyType="+pharmacyType,arguments,features);
}

function setOnlineSetuptoBean(action_type) {
	var bean_id							=	document.forms[0].bean_id.value ;
	var bean_name						=	document.forms[0].bean_name.value ;
	var select_all						=	document.forms[0].select_all.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlAppend	=	"";

	xmlAppend += "select_all"+"=\""+select_all+"\" " ;

	xmlStr ="<root><SEARCH " ;	
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&action_type="+action_type+ "&validate=onlineprintlist_ok_cancel", false);

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	parent.document.getElementById('dialog_tag').close();
	//return true;
}
	
function checkList(obj,list_name,report_id){

	var bean_id				=	document.forms[0].bean_id.value ;
	var bean_name				=	document.forms[0].bean_name.value ;
	var changed_value			=	obj.value ;

	var xmlAppend				=	"";
	xmlAppend += "report_id"+"=\""+report_id+"\" " ;
	xmlAppend += "list_name"+"=\""+list_name+"\" " ;	
	xmlAppend += "changed_value"+"=\""+changed_value+"\" " ;	
	var  xmlStr ="<root><SEARCH " ;
	xmlStr = xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DispenseLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=onlineprintlist", false);
	  
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

}
// added for Bru_HIMS-CRF-142(30195) -start
function validatePat() {
	
	
	if (document.formDispenseLocation.PAT_ARRIVAL.checked == true) {
		document.formDispenseLocation.PAT_ARRIVAL.value="Y";
		document.formDispenseLocation.ACTUAL_TOKEN.disabled	= false;
	}
	else if (document.formDispenseLocation.PAT_ARRIVAL.checked == false) {
		document.formDispenseLocation.PAT_ARRIVAL.value="N";
		document.formDispenseLocation.ACTUAL_TOKEN.value="N";
		document.formDispenseLocation.ACTUAL_TOKEN.checked=false;
		document.formDispenseLocation.ACTUAL_TOKEN.disabled		= true;
	}
}

function ValidateGenTkn(obj){
	if(obj.checked){
		document.formDispenseLocation.ACTUAL_TOKEN.value="Y";
	}
	else{
		document.formDispenseLocation.ACTUAL_TOKEN.value="N";
    }
}

function ValidateStgLoc(obj){
	if(obj.checked){
		document.formDispenseLocation.STORAGE_LOCN.value="Y";
	}
	else{
		document.formDispenseLocation.STORAGE_LOCN.value="N";
    }
}
//added for Bru_HIMS-CRF-142(30195) - end
//Added for NMC-JD-CRF-0008 start
function validateExtDisp(obj){

	if(obj.checked){
		
		document.formDispenseLocation.DIRECT_DISP_ALLOWED_YN.checked=false;
		document.formDispenseLocation.DIRECT_DISP_ALLOWED_YN.disabled=true;
		}
	else{
		document.formDispenseLocation.DIRECT_DISP_ALLOWED_YN.disabled=false;
	}
	
}
function onLoadValidation(){
	if(document.formDispenseLocation.EXT_DISP_YN.checked){
		document.formDispenseLocation.DIRECT_DISP_ALLOWED_YN.checked=false;
		document.formDispenseLocation.DIRECT_DISP_ALLOWED_YN.disabled=true;
		
	}
	
	
}
//Added for NMC-JD-CRF-0008 end
