/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201010                         MMS-KH-SCF-108         Ram Kumar S
2            V201013                         MMS-KH-SCF-108         Ram Kumar S
3            V201125             8504        KDAH-SCF-0681          Ram Kumar S/MuthuN
4            V201125             8942        AMS-SCF-0924           Ram Kumar S/MuthuN
5         	 V201210             9968        MMS-KH-SCF-51.1        Ram Kumar S
6         	 V210119            13000        MMS-QF-SCF-0613        Ram Kumar S
7			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
8			 V220331  						 GHL-SCF-1635			Nandhini M
9			 V220419						NMC-JD-CRF-0150.1		Nandhini M
10			 V220323	    	27763		 MMS-ME-SCF-0052 		Mohana Priya K
11			 V220615	    	30742		 KDAH-SCF-0769 		Mohana Priya K
12			V220824		31032	Package Definition - Query PK details 	Mohana Priya K
*/



//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
var submitParams	= "";
var submitParamsMain	= "";
//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20

//Added for PAckage Definition   
function selectTabForPkg(tabObj, index) {   
	if (index == "1") {
		prevTabObj = parent.parent.PkgDefTabFrame.document.frmPkgDefTab.prevTabObj.value;
		if (prevTabObj != null && prevTabObj != "") {
			eval(parent.parent.PkgDefTabFrame.document.getElementById('prevTabObj')).className = "tabA";
			eval(parent.parent.PkgDefTabFrame.document.getElementById('prevTabObj')+ "span").className = "tabAspan";
		}
		eval(parent.parent.PkgDefTabFrame.document.getElementById('tabObj')).className = "tabClicked";
		eval(parent.parent.PkgDefTabFrame.document.getElementById('tabObj') + "span").className = "tabSpanclicked";
		parent.parent.PkgDefTabFrame.document.frmPkgDefTab.prevTabObj.value = tabObj;
	} else {
		prevTabObj = document.frmPkgDefTab.prevTabObj.value;
		if (prevTabObj != null && prevTabObj != "") {
			eval(document.getElementById('prevTabObj')).className = "tabA";
			eval(document.getElementById('prevTabObj') + "span").className = "tabAspan";
		}
		eval(document.getElementById('tabObj')).className = "tabClicked";
		eval(document.getElementById('tabObj') + "span").className = "tabSpanclicked";
		document.frmPkgDefTab.prevTabObj.value = tabObj;
	}
}
//Added V180122-Gayathri/MMS-DM-CRF-0118
function ruleCodeLookup(obj,index){
	var formObj = document.frmPkgDefBaseDate;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "VAT Percentage";
	var locale = formObj.locale.value;
	var facility_id = formObj.facility_id.value;

	/* commented against MMS-ME-SCF-0017
		argumentArray[0] = "select a.rule_code code, a.short_desc description from bl_addl_charge_rule_lang_vw a, bl_addl_charge_rule b where a.facility_id='"
		+facility_id
		+ "' and a.facility_id = b.facility_id and   a.language_id ='"
		+ locale
		+"' and a.rule_type_ind = 'M' AND a.rule_code = b.rule_code "
		+" AND (A.EFF_DATE_TO>=TRUNC(SYSDATE) OR A.EFF_DATE_TO IS NULL) AND (A.EFF_DATE_FROM<=SYSDATE) "
		+" and upper(a.rule_code) like upper(?) and upper(a.short_desc) like upper(?)";*/

	//Added against MMS-ME-SCF-0017 on 26-Jun-20 by MuthuN
	argumentArray[0] = "select a.rule_code code, a.short_desc description from bl_addl_charge_rule_lang_vw a, bl_addl_charge_rule b where a.facility_id='"
		+facility_id
		+ "' and a.facility_id = b.facility_id and   a.language_id ='"
		+ locale
		+"' and a.rule_type_ind = 'M' AND a.rule_code = b.rule_code "
		+" AND (A.EFF_DATE_TO>=TRUNC(SYSDATE) OR A.EFF_DATE_TO IS NULL) "
		+" and upper(a.rule_code) like upper(?) and upper(a.short_desc) like upper(?)";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argumentArray);
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {	
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {	
		//Modified against Incident No - ATE-BL-MMS-73588 for VAT Effective Date Validation  By Ram kumar S
			var fromDate=eval("formObj.fromDate_" + index).value;
			var newStatus=checkVATeffDate(retArray[0],facility_id,fromDate);
			var n1 = newStatus.indexOf("~");
			var res1 = newStatus.substr(n1+1);
			res1 = res1.split("~");
			if(res1[0]=="E"){
				alert("APP-BL6310 Date range should be between From and To date of Rule Code Defined in Addl Charge Rule");
				eval("document.forms[0].VATpercent" + index).value = ""; 
			}else if(res1[0]=="S"){
				eval("document.forms[0].VATpercent" + index).value = retArray[0]; 
			//eval("document.forms[0].glSmryDisc_temp" + index).value = retArray[0];
			}
			// Ends here Incident No - ATE-BL-MMS-73588 By Ram kumar S
		}
		else {
		eval("document.forms[0].VATpercent" + index).value = "";		
	}
	} else {
		eval("document.forms[0].VATpercent" + index).value = "";		
	}
}

/* This function is added by Ram kumar S against Incident No - ATE-BL-MMS-73588*/
function checkVATeffDate(ruleCode,facId,fromdate){
	var xmlStr = "<root><SEARCH ";
	xmlStr += " /></root>";
	var status1="";
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST", "PkgDefValidation.jsp?func_mode=chk_VAT_Eff_Date&ruleCode="+ruleCode+"&facId="+facId+"&fromdate="+fromdate, false);
	xmlHttp.send(xmlDoc);
	var status = trimString(xmlHttp.responseText);*/
			$.ajax({
			url: "PkgDefValidation.jsp?func_mode=chk_VAT_Eff_Date&ruleCode="+ruleCode+"&facId="+facId+"&fromdate="+fromdate,
			type: 'POST',
			data : { xmlStr: xmlStr },
			success: function(result) {
				status1=trimString(result);
                  },
			async:   false
			});
		return status1;
}

function enableRuleCode(obj,index){
	if (obj.checked) {
		obj.value="Y";
		document.getElementById("VATpercent"+index).removeAttribute('disabled');
		document.getElementById("VATpercent_temp"+index).removeAttribute('disabled');
	}
	else{
		obj.value="N";
		document.getElementById("VATpercent"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent_temp"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent"+index).value="";
	}
}
function enableRuleCode_Cust(obj,index){
	if (obj.checked) {
		obj.value="Y";
		document.getElementById("VATpercent"+index).removeAttribute('disabled');
		document.getElementById("VATpercent_temp"+index).removeAttribute('disabled');
		document.getElementById("ruleCoverageInd"+index).removeAttribute('disabled');
	}
	else{
		obj.value="N";
		document.getElementById("VATpercent"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent_temp"+index).setAttribute('disabled', 'disabled');
		document.getElementById("ruleCoverageInd"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent"+index).value="";
		document.getElementById("ruleCoverageInd"+index).value="";
	}
}

function showMainTabDetails(obj) {
	link = obj;
	var result = true;
	var last_link = document.forms[0].last_link.value;
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	if (last_link != "") {
		var headerFrmObj = "";
		var frmObj = "";
		var formObj='';
		var current_form = "";
		var excln_form = "";
		var funcMode = "";
		var mode = "";

		if (last_link == 'PACKAGE'
				&& parent.PkgDefDetailMainFrame.PkgDefHeader != null) {
			headerFrmObj = parent.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader;
			mode = parent.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.mode.value;
			var packageCode = eval("headerFrmObj.packageCode").value;

			if (headerFrmObj != null && headerFrmObj != undefined) {
				var xmlString = formXMLStringMain(headerFrmObj);
				var updation = formValidation(xmlString, last_link);
			}
			frmObj = parent.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate
			if (frmObj != null && frmObj != undefined) {

				var xmlString = formXMLStringMain(frmObj);
				var updation = formValidation(xmlString, "PACKAGE_DATE");
			}
			if (parent.PkgDefDetailMainFrame.PkgDefDetailFrame.length > 0) {
				// commented by ram 0n july23 and added new line
				// frmObj =
				// parent.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[0]
				frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
						.frames[1]
				formObj=parent.PkgDefDetailMainFrame.PkgDefDetailFrame
						.frames[0]

				if (frmObj != null && frmObj != undefined) {

					if (eval("frmObj").name == "basePriceDtl") {

						// cghanfed frames[0] to frames[1] by ram july23
						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[1].document.frmPkgDefBasePrice
						funcMode = "PACKAGE_PRICE";
					} else if (eval("frmObj").name == "rate_based_dtl") {

						// changed frane ref frames[0] to frames[1] by ram
						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[1].document.rate_based_dtl

						result = validateRateForm(
								frmObj,
								parent.PkgDefDetailMainFrame.PkgDefDetailFrame
										.frames[2].document.srvLimit_rate_based_dtl,
								packageCode);
						funcMode = "RATE_BASED";
					} else if (eval("frmObj").name == "ChargeBasedDtl") {

						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[1].document.frmPkgDefChargeBased
						funcMode = "CHARGE_BASED";
					}
					
					else if (eval("formObj").name == "ass_child_pack_dtl") {

						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[0].document.frmChildPackdtls
						funcMode = "CHILD_PACK";
					}
					if (result) {

						var xmlString = formXMLString(frmObj, funcMode,
								"maintab", packageCode);

						var updation = formValidation(xmlString, funcMode);
					}
				}
				// if(result &&
				// parent.PkgDefDetailMainFrame.PkgDefDetailFrame.length >2){
				// commented by ram and added new
				if (result
						&& parent.PkgDefDetailMainFrame.PkgDefDetailFrame.length > 3) {
					if (funcMode == "CHARGE_BASED") { // added if condition
														// for charge based
														// frames bcoz only
														// 5frames insted of 6
														// by ram

						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[3]
					} else {

						// changed frame ref frames[2] to frames[4] by ram
						frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
								.frames[4]
					}
					var fromName = eval("frmObj").name
					fromName = trimString(fromName);
					if (frmObj != null && frmObj != undefined) {
						if (fromName == "srvLimit_rate_based_dtl") {

							funcMode = "SRVLIMIT_RATE_BASED";
							frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
									.frames[4].document.srvLimit_rate_based_dtl
						} else if (eval("frmObj").name == "ChargeBasedExCln") {

							funcMode = "CHARGE_BASED_ITEM";
							frmObj = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
									.frames[3].document.frmPkgDefChargeBasedExcln

						}
						if (frmObj != null && frmObj != undefined) {
							var xmlString = formXMLString(frmObj, funcMode,
									"maintab", packageCode);
							var updation = formValidation(xmlString, funcMode);
						}
					}
				}
			}
			current_form = "parent."
			excln_form = "parent."
		} else if (last_link == 'CUSTOMER'
				&& parent.PkgDefDetailMainFrame.PkgDefCustHeader != null) {
			headerFrmObj = parent.PkgDefDetailMainFrame.PkgDefCustHeader.document.frmPkgDefCustHeader;
			mode = headerFrmObj.mode.value;
			var packageCode = eval("headerFrmObj.packageCode").value;
			var result = true;
			var updation = true;

			frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDtlsFrame.cust_dtls.document.cust_dtls
			if (frmObj != null && frmObj != "undefined") {

				result = validateCustomers(frmObj);
				if (result)
					updation = formValidation(formCustXMLStringMain(frmObj),
							"CUSTOMER");
			}

			if (parent.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl != null) {
				frmObj = parent.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl
				if (frmObj != null && frmObj != "undefined") {

					result = validateCustPackageDates(frmObj,
							parseInt(frmObj.totalRecords.value));
					if (result)
						updation = formValidation(
								formCustXMLStringMain(frmObj), "custPeriod");
				}
			}
			if (result
					&& parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.length > 0) {
				// frmObj =
				// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[0].document.forms[0]
				// added new line by ram
				frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
						.frames[1].document.forms[0]
				if (frmObj != null && frmObj != "undefined") {
					if (eval("frmObj").name == "cust_base_price_dtl") {
						// changed frame ref in 2 lines by ram
						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[0]
						// to
						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[1]
						frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
								.frames[1].document.cust_base_price_dtl
						result = validateCustPackagePrice(
								"parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[0].document.cust_base_price_dtl",
								parseInt(parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
										.frames[1].document.cust_base_price_dtl.totalRecords.value));
						funcMode = "CUST_PRICE";
					} else if (eval("frmObj").name == "cust_rate_based_dtl") {

						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[0]
						// ref cjhanged to
						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[1]
						// by ram
						frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
								.frames[1].document.cust_rate_based_dtl

						result = validateCustRateForm(frmObj, '', packageCode);
						funcMode = "CUST_RATE_BASED";
					} else if (eval("frmObj").name == "cust_charge_based_dtl") {
						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[0]
						// ref cjhanged to
						// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[1]
						// by ram
						frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
								.frames[1].document.cust_charge_based_dtl
						result = validateCustChargeBased(
								parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
										.frames[1].document.cust_charge_based_dtl,
								parseInt(parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
										.frames[1].document.cust_charge_based_dtl.totalRecords.value))
						funcMode = "CUST_CHARGE_BASED";
					}

					if (result)
						updation = formValidation(
								formCustXMLStringMain(frmObj), funcMode);
				}
				frmObj = "";
				if (result
						&& parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.length > 3) {

					// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[2]
					// ref changed to
					// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[4]
					// by ram
					frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
							.frames[4].document.forms[0]
					if (frmObj != null && frmObj != "undefined") {
						if (eval("frmObj").name == "cust_srvLimit_rate_based_dtl") {
							funcMode = "CUST_SRVLIMIT_RATE_BASED";

							// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[2]
							// ref changed to
							// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[4]
							// and frames[0] to framews(1) by ram
							frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
									.frames[4].document.cust_srvLimit_rate_based_dtl

							result = validateCustRateForm(
									parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
											.frames[1].document.cust_rate_based_dtl,
									parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
											.frames[4].document.cust_srvLimit_rate_based_dtl,
									packageCode);
						} else if (eval("frmObj").name == "cust_charge_based_excl_dtl") {
							funcMode = "CUST_CHARGE_BASED_ITEM";
							// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[2]
							// ref changed to
							// parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame.frames[4]
							// by ram
							frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
									.frames[4].document.cust_charge_based_excl_dtl
							result = validateCustChargeBasedItems(
									parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
											.frames[4].document.cust_charge_based_excl_dtl,
									parseInt(parent.PkgDefDetailMainFrame.PkgDefCustDetailFrame
											.frames[4].document.cust_charge_based_excl_dtl.totalRecords.value))
						}

						// var
						// xmlString=formXMLString(frmObj,funcMode,"maintab",packageCode);

						if (result)
							updation = formValidation(
									formCustXMLStringMain(frmObj), funcMode);
					}
				}
			}
			current_form = "parent.";
			excln_form = "parent.";
		}
		//Added By Shikha For GHL-CRF-0520.1
		else if (last_link == 'BILLINGGROUP'&& parent.PkgDefDetailMainFrame.PkgDefBlngGrpHeader != null) {
			headerFrmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader;
			mode = headerFrmObj.mode.value;
			var packageCode = eval("headerFrmObj.packageCode").value;
			var result = true;
			var updation = true;
			//alert(parent.name);
			frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDtlsFrame.blng_grp_dtls.document.blng_grp_dtls;
			if (frmObj != null && frmObj != "undefined") {
				result = validateBillingGroups(frmObj);
			//	alert(result);
				if (result)
					updation = formValidation(formBlngGrpXMLStringMain(frmObj),"BILLINGGROUP");
			}

			if (parent.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl != null) {
				frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
				if (frmObj != null && frmObj != "undefined") {
					result = validateBlngGrpPackageDates(frmObj,
							parseInt(frmObj.totalRecords.value));
					if (result)
						updation = formValidation(formBlngGrpXMLStringMain(frmObj), "blngGrpPeriod");
				}
			}

			if (result && parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.length > 0) {
				frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[1].document.forms[0];
				if (frmObj != null && frmObj != "undefined") {
					if (eval("frmObj").name == "blng_grp_base_price_dtl") {
						frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[1].document.blng_grp_base_price_dtl;
						result = validateBlngGrpPackagePrice(
								"parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[0].document.blng_grp_base_price_dtl",
								parseInt(parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
										.frames[1].document.blng_grp_base_price_dtl.totalRecords.value));
						funcMode = "BLNG_GRP_PRICE";
					} else if (eval("frmObj").name == "blng_grp_rate_based_dtl") {
						frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[1].document.blng_grp_rate_based_dtl;

						result = validateBlngGrpRateForm(frmObj, '', packageCode);
						funcMode = "BLNG_GRP_RATE_BASED";
					} else if (eval("frmObj").name == "blng_grp_charge_based_dtl") {
						frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[1].document.blng_grp_charge_based_dtl;
						result = validateBlngGrpChargeBased(
								parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
										.frames[1].document.blng_grp_charge_based_dtl,
								parseInt(parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
										.frames[1].document.blng_grp_charge_based_dtl.totalRecords.value));
						funcMode = "BLNG_GRP_CHARGE_BASED";
					}

					if (result)
						updation = formValidation(formBlngGrpXMLStringMain(frmObj), funcMode);
				}
				frmObj = "";
				if (result && parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.length > 3) {
					frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[4].document.forms[0];
					if (frmObj != null && frmObj != "undefined") {
						if (eval("frmObj").name == "blng_grp_srvLimit_rate_based_dtl") {
							funcMode = "BLNG_GRP_SRVLIMIT_RATE_BASED";
							frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[4].document.blng_grp_srvLimit_rate_based_dtl;

							result = validateBlngGrpRateForm(
									parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
											.frames[1].document.blng_grp_rate_based_dtl,
									parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
											.frames[4].document.blng_grp_srvLimit_rate_based_dtl,
									packageCode);
						} else if (eval("frmObj").name == "blng_grp_charge_based_excl_dtl") {
							funcMode = "BLNG_GRP_CHARGE_BASED_ITEM";
							frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
									.frames[4].document.blng_grp_charge_based_excl_dtl;
							result = validateBlngGrpChargeBasedItems(
									parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
											.frames[4].document.blng_grp_charge_based_excl_dtl,
									parseInt(parent.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame
		
											.frames[4].document.blng_grp_charge_based_excl_dtl.totalRecords.value));
						}

						if (result)
							updation = formValidation(formBlngGrpXMLStringMain(frmObj), funcMode);
					}
				}
			}
			current_form = "parent.";
			excln_form = "parent.";
		}//Ended By Shikha For GHL-CRF-0520.1
		else if (last_link == 'DISCOUNT'
				&& parent.PkgDefDetailMainFrame.PkgDefDiscountHeader != null) {
			headerFrmObj = parent.PkgDefDetailMainFrame.PkgDefDiscountHeader.document.discount_hdr;
			mode = headerFrmObj.mode.value;
			var packageCode = eval("headerFrmObj.packageCode").value;
			var result = true;
			var updation = true;

			frmObj = parent.PkgDefDetailMainFrame.PkgDefCustDiscountFrame.cust_discount_dtl.document.cust_discount_dtl;
			if (frmObj != null && frmObj != "undefined") {

				result = validateDiscountForm(frmObj);
				if (result)
					updation = formValidation(
							formDiscountXMLStringMain(frmObj), "cust_discount");
			}
			if (result) {
				if (parent.PkgDefDetailMainFrame.PkgDefBlngGrpDiscountFrame.blng_grp_discount_dtl != null) {

					frmObj = parent.PkgDefDetailMainFrame.PkgDefBlngGrpDiscountFrame.blng_grp_discount_dtl.document.blng_grp_discount_dtl;
					if (frmObj != null && frmObj != "undefined") {
						result = validateDiscountForm(frmObj);
						if (result)
							updation = formValidation(
									formDiscountXMLStringMain(frmObj),
									"blng_grp_discount");
					}
				}
			}
		}
	}
	// else
	// document.forms[0].last_link.value = link
	if (result) {
		/*
		 * if(last_link == "PACKAGE") {
		 * 
		 * alert(parent.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader) }
		 */

		if (link == "PACKAGE") {
			changeMainTabClass(link, parent.PkgDefMainTab)
			parent.PkgDefDetailMainFrame.location.href = "../../eBL/jsp/PkgDefFrame.jsp?from=PACKAGE&mode="
					+ mode
					+ "&packageCode="
					+ packageCode
					+ "&authorized="
					+ authorized + "&pkgApprovedYN=" + pkgApprovedYN;
		} else if (link == "CUSTOMER") {
			var packageCode = parent.frames[1].frames[0].document.forms[0].packageCode.value
			var longDesc = parent.frames[1].frames[0].document.forms[0].longDesc.value
			var effFromDate = parent.frames[1].frames[0].document.forms[0].effFromDate.value
			var effToDate = parent.frames[1].frames[0].document.forms[0].effToDate.value
			var mode = parent.frames[1].frames[0].document.forms[0].mode.value
			var copyFrm_pkgCode = parent.frames[1].frames[0].document.forms[0].copyFrm_pkgCode.value
			var orderAssociated = parent.frames[1].frames[0].document.forms[0].orderAssociated.value
			var noofdecimal = parent.frames[1].frames[0].document.forms[0].noofdecimal.value
			var acrossEncounters = parent.frames[1].frames[0].document.forms[0].acrossEncounters.value;
			var allow_masterChild_package = "N";
			allow_masterChild_package=parent.frames[1].frames[0].document.forms[0].allow_masterChild_package_map.value;
			var IpYn = "N";
			var DcYn = "N";
			var OpYn = "N";
			var EmYn = "N";
			var mast_pack="N";
			
			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			var AllYn = "N";			
			var currFrm = parent.frames[1].frames[0].document.forms[0];
			if(currFrm.IpYn.type == 'hidden'){
				if (currFrm.IpYn.value == 'Y'){
					IpYn = "Y";
				}	
			}
			else if(currFrm.IpYn.type == 'checkbox'){
				if (currFrm.IpYn.checked){
					IpYn = "Y";
				}					
			}
			
			if(currFrm.DcYn.type == 'hidden'){
				if (currFrm.DcYn.value == 'Y'){
					DcYn = "Y";
				}
			}
			else if(currFrm.DcYn.type == 'checkbox'){
				if (currFrm.DcYn.checked){
					DcYn = "Y";
				}
			}
			
			if(currFrm.OpYn.type == 'hidden'){
				if (currFrm.OpYn.value == 'Y'){
					OpYn = "Y";
				}
			}
			else if(currFrm.OpYn.type == 'checkbox'){
				if (currFrm.OpYn.checked){
					OpYn = "Y";
				}
			}

			if(currFrm.EmYn.type == 'hidden'){
				if (currFrm.EmYn.value == 'Y'){
					EmYn = "Y";
				}
			}
			else if(currFrm.EmYn.type == 'checkbox'){
				if (currFrm.EmYn.checked){
					EmYn = "Y";
				}
			}
			
			if(currFrm.AllYn.type == 'hidden'){
				if (currFrm.AllYn.value == 'Y'){
					AllYn = "Y";
				}
			}
			else if(currFrm.AllYn.type == 'checkbox'){
				if (currFrm.AllYn.checked){
					AllYn = "Y";
				}
			}
      //Added V190325 Gayathri/KDAH-CRF-0503/Starts
      	if(allow_masterChild_package=='Y'){
			if(currFrm.isMasterPackYN.type == 'hidden'){
      		//			if(currFrm.mast_pack.type == 'hidden'){
				//if (currFrm.mast_pack.value == 'Y'){
				if (currFrm.isMasterPackYN.value == 'Y'){					
					mast_pack = "Y";
				}
			}
			else if(currFrm.isMasterPackYN.type == 'checkbox'){
				if (currFrm.isMasterPackYN.checked){
					mast_pack = "Y";
				}
				else{
					mast_pack = "N";
				}
			}
			}			
			/*if (parent.frames[1].frames[0].document.forms[0].IpYn.checked)
				IpYn = "Y";
			if (parent.frames[1].frames[0].document.forms[0].DcYn.checked)
				DcYn = "Y";
			if (parent.frames[1].frames[0].document.forms[0].OpYn.checked)
				OpYn = "Y";
			if (parent.frames[1].frames[0].document.forms[0].EmYn.checked)
				EmYn = "Y";*/
			
			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			if (orderAssociated == null || orderAssociated == "")
				orderAssociated = "N";
			var qryStr = "packageCode=" + packageCode + "&effFromDate="
					+ encodeURIComponent(effFromDate) + "&effToDate="
					+ encodeURIComponent(effToDate) + "&mode=" + mode
					+ "&orderAssociated=" + orderAssociated + "&noofdecimal="
					+ noofdecimal + "&from=CUSTOMER&IpYn=" + IpYn + "&DcYn="
					+ DcYn + "&OpYn=" + OpYn + "&EmYn=" + EmYn+"&AllYn="+AllYn
					+ "&copyFrm_pkgCode=" + copyFrm_pkgCode + "&authorized="
					+ authorized + "&pkgApprovedYN=" + pkgApprovedYN
					+ "&acrossEncounters=" + acrossEncounters + "&longDesc="
					+ encodeURIComponent(longDesc)+ "&mast_pack="+ mast_pack+"&allow_masterChild_package="+allow_masterChild_package; //modified for GHL-SCF-1635
					
			if (packageCode == "" || longDesc == "" || effFromDate == "") {
				alert("Please enter Package code, description and effective from date");
				result = false;
			} else {
				changeMainTabClass(link, parent.PkgDefMainTab)
				parent.PkgDefDetailMainFrame.location.href = "../../eBL/jsp/PkgDefFrame.jsp?"
						+ qryStr;
			}

		}  else if (link == "BILLINGGROUP") {
			//alert('billing grp 2');
			var packageCode = parent.frames[1].frames[0].document.forms[0].packageCode.value;
			var longDesc = parent.frames[1].frames[0].document.forms[0].longDesc.value;
			var effFromDate = parent.frames[1].frames[0].document.forms[0].effFromDate.value;
			var effToDate = parent.frames[1].frames[0].document.forms[0].effToDate.value;
			var mode = parent.frames[1].frames[0].document.forms[0].mode.value;
			var copyFrm_pkgCode = parent.frames[1].frames[0].document.forms[0].copyFrm_pkgCode.value;
			var orderAssociated = parent.frames[1].frames[0].document.forms[0].orderAssociated.value;
			var noofdecimal = parent.frames[1].frames[0].document.forms[0].noofdecimal.value;
			var acrossEncounters = parent.frames[1].frames[0].document.forms[0].acrossEncounters.value;
			var allow_masterChild_package = "N";
			allow_masterChild_package=parent.frames[1].frames[0].document.forms[0].allow_masterChild_package_map.value;
			var IpYn = "N";
			var DcYn = "N";
			var OpYn = "N";
			var EmYn = "N";
			var mast_pack="N";
			
			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			var AllYn = "N";
			
			var currFrm = parent.frames[1].frames[0].document.forms[0];
			if(currFrm.IpYn.type == 'hidden'){
				if (currFrm.IpYn.value == 'Y'){
					IpYn = "Y";
				}	
			}
			else if(currFrm.IpYn.type == 'checkbox'){
				if (currFrm.IpYn.checked){
					IpYn = "Y";
				}					
			}
			
			if(currFrm.DcYn.type == 'hidden'){
				if (currFrm.DcYn.value == 'Y'){
					DcYn = "Y";
				}
			}
			else if(currFrm.DcYn.type == 'checkbox'){
				if (currFrm.DcYn.checked){
					DcYn = "Y";
				}
			}
			
			if(currFrm.OpYn.type == 'hidden'){
				if (currFrm.OpYn.value == 'Y'){
					OpYn = "Y";
				}
			}
			else if(currFrm.OpYn.type == 'checkbox'){
				if (currFrm.OpYn.checked){
					OpYn = "Y";
				}
			}

			if(currFrm.EmYn.type == 'hidden'){
				if (currFrm.EmYn.value == 'Y'){
					EmYn = "Y";
				}
			}
			else if(currFrm.EmYn.type == 'checkbox'){
				if (currFrm.EmYn.checked){
					EmYn = "Y";
				}
			}
			
			if(currFrm.AllYn.type == 'hidden'){
				if (currFrm.AllYn.value == 'Y'){
					AllYn = "Y";
				}
			}
			else if(currFrm.AllYn.type == 'checkbox'){
				if (currFrm.AllYn.checked){
					AllYn = "Y";
				}
			}
      //Added V190325 Gayathri/KDAH-CRF-0503/Starts
      	if(allow_masterChild_package=='Y'){
			if(currFrm.isMasterPackYN.type == 'hidden'){
				if (currFrm.isMasterPackYN.value == 'Y'){
					mast_pack = "Y";
				}
			}
			else if(currFrm.isMasterPackYN.type == 'checkbox'){
				if (currFrm.isMasterPackYN.checked){
					mast_pack = "Y";
				}
				else{
					mast_pack = "N";
				}
			}
			}						
			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			if (orderAssociated == null || orderAssociated == "")
				orderAssociated = "N";
			var qryStr = "packageCode=" + packageCode + "&effFromDate="
					+ encodeURIComponent(effFromDate) + "&effToDate="
					+ encodeURIComponent(effToDate) + "&mode=" + mode
					+ "&orderAssociated=" + orderAssociated + "&noofdecimal="
					+ noofdecimal + "&from=BILLINGGROUP&IpYn=" + IpYn + "&DcYn="
					+ DcYn + "&OpYn=" + OpYn + "&EmYn=" + EmYn+"&AllYn="+AllYn
					+ "&copyFrm_pkgCode=" + copyFrm_pkgCode + "&authorized="
					+ authorized + "&pkgApprovedYN=" + pkgApprovedYN
					+ "&acrossEncounters=" + acrossEncounters + "&longDesc="
					+ encodeURIComponent(longDesc)+ "&mast_pack="+ mast_pack+"&allow_masterChild_package="+allow_masterChild_package; //modified for GHL-SCF-1635
			//alert('here');
			if (packageCode == "" || longDesc == "" || effFromDate == "") {
				alert("Please enter Package code, description and effective from date");
				result = false;
			} else {							
				changeMainTabClass(link, parent.PkgDefMainTab)
				parent.PkgDefDetailMainFrame.location.href = "../../eBL/jsp/PkgDefFrame.jsp?"
						+ qryStr;
			}

		}else if (link == 'DISCOUNT') {
			var packageCode = headerFrmObj.packageCode.value
			var longDesc = headerFrmObj.longDesc.value
			var effFromDate = headerFrmObj.effFromDate.value
			var effToDate = headerFrmObj.effToDate.value
			var mode = headerFrmObj.mode.value
			var copyFrm_pkgCode = headerFrmObj.copyFrm_pkgCode.value
			var orderAssociated = headerFrmObj.orderAssociated.value
			var acrossEncounters = headerFrmObj.acrossEncounters.value
			var noofdecimal = headerFrmObj.noofdecimal.value
			var IpYn = "N";
			var DcYn = "N";
			var OpYn = "N";
			var EmYn = "N";
			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			var AllYn = "N";
			
			if(headerFrmObj.IpYn.type == 'hidden'){
				if (headerFrmObj.IpYn.value == 'Y'){
					IpYn = "Y";
				}	
			}
			else if(headerFrmObj.IpYn.type == 'checkbox'){
				if (headerFrmObj.IpYn.checked){
					IpYn = "Y";
				}					
			}
			
			if(headerFrmObj.DcYn.type == 'hidden'){
				if (headerFrmObj.DcYn.value == 'Y'){
					DcYn = "Y";
				}
			}
			else if(headerFrmObj.DcYn.type == 'checkbox'){
				if (headerFrmObj.DcYn.checked){
					DcYn = "Y";
				}
			}
			
			if(headerFrmObj.OpYn.type == 'hidden'){
				if (headerFrmObj.OpYn.value == 'Y'){
					OpYn = "Y";
				}
			}
			else if(headerFrmObj.OpYn.type == 'checkbox'){
				if (headerFrmObj.OpYn.checked){
					OpYn = "Y";
				}
			}

			if(headerFrmObj.EmYn.type == 'hidden'){
				if (headerFrmObj.EmYn.value == 'Y'){
					EmYn = "Y";
				}
			}
			else if(headerFrmObj.EmYn.type == 'checkbox'){
				if (headerFrmObj.EmYn.checked){
					EmYn = "Y";
				}
			}
			
			if(headerFrmObj.AllYn.type == 'hidden'){
				if (headerFrmObj.AllYn.value == 'Y'){
					AllYn = "Y";
				}
			}
			else if(headerFrmObj.AllYn.type == 'checkbox'){
				if (headerFrmObj.AllYn.checked){
					AllYn = "Y";
				}
			}
			/*if (headerFrmObj.IpYn != null && headerFrmObj.IpYn.checked)
				IpYn = "Y";
			if (headerFrmObj.DcYn != null && headerFrmObj.DcYn.checked)
				DcYn = "Y";
			if (headerFrmObj.DcYn != null && headerFrmObj.OpYn.checked)
				OpYn = "Y";
			if (headerFrmObj.DcYn != null && headerFrmObj.EmYn.checked)
				EmYn = "Y";*/

			/*Modified by Rajesh V for MMS-DM-SCF-0518*/
			if (orderAssociated == null || orderAssociated == "")
				orderAssociated = "N";
			if (acrossEncounters == null || acrossEncounters == "")
				acrossEncounters = "N";
			var qryStr = "packageCode=" + packageCode + "&effFromDate="
					+ encodeURIComponent(effFromDate) + "&effToDate="
					+ encodeURIComponent(effToDate) + "&mode=" + mode
					+ "&orderAssociated=" + orderAssociated + "&noofdecimal="
					+ noofdecimal + "&from=DISCOUNT&IpYn=" + IpYn + "&DcYn="
					+ DcYn + "&OpYn=" + OpYn + "&EmYn=" + EmYn
					+ "&AllYn="+AllYn
					+ "&copyFrm_pkgCode=" + copyFrm_pkgCode + "&authorized="
					+ authorized + "&pkgApprovedYN=" + pkgApprovedYN
					+ "&acrossEncounters=" + acrossEncounters + "&longDesc="
					+ encodeURIComponent(longDesc); //modified for GHL-SCF-1635
			if (packageCode == "" || longDesc == "" || effFromDate == "") {
				alert("Please enter Package code, description and effective from date");
				result = false;
			} else {
				changeMainTabClass(link, parent.PkgDefMainTab)
				parent.PkgDefDetailMainFrame.location.href = "../../eBL/jsp/PkgDefFrame.jsp?"
						+ qryStr;
			}
		}
		if (result) {
			document.forms[0].last_link.value = link;
		} else {
			document.forms[0].last_link.value = last_link;
		}
	} else {
		document.forms[0].last_link.value = last_link;
	}
}

/*Added for MMS-JU-SCF-0151 PALANINARAYANAN starts */
function formXMLStringMainPkgSub(frmObj) {
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
		var xmlStr = "<root><SEARCH ";
		if (true) {
			var arrObj = frmObj.elements;
			for ( var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";
				} else if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != "")
							xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
									+ "\" ";
					}
				} else if (arrObj[i].type == "select-multiple") {
					for ( var j = 0; j < arrObj[i].options.length; j++) {
						if (arrObj[i].options[j].selected)
							val += arrObj[i].options[j].value + "~"
					}
					val = val.substring(0, val.lastIndexOf('~'))
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";
				} else {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";
				}
			}
		}
		xmlStr += " /></root>";
	}
  return xmlStr;
}
/*Added for MMS-JU-SCF-0151 PALANINARAYANAN ENDs */

/*Added against V220824*/
function checkSpecl( val ) {
    var result = "" ;
    var ch = "" ;

    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
		 val = val.replace("\n","\"");
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" ,"%") ;
    var chChars = new Array( "%3C", "%3E", "%26", "\%22", "%27", "%25" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    return result ;
}
function formXMLStringMain(frmObj) {
	submitParamsMain	= "";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
	var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/						
					//submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
					//submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
					//submitParamsMain	+= arrObj[i].name+"="+(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
				submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824-modified checkSpl(val) to checkSpecl(val)
				//submitParamsMain	+= arrObj[i].name+"="+checkSpldescrp(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
				//alert("submitParamsMain===>"+submitParamsMain);
				}
			}
		}
	}
		xmlStr += " /></root>";
	}
	return xmlStr;
}

function reset() {
		/*Modified by Gayathri for GHL-ICN*/
		PkgDefFrame.document.location.reload();
		if(PkgDefFrame.PkgDefMainTab!=null ){
		if(PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab!=null){
		PkgDefFrame.document.location.reload();
		}
		}
}

/*
 * function create() { if(chkStatus() == "N") { //alert("User can only query the
 * data, no creation acess."); alert(getMessage("BL8662",'BL')); } else {
 * commontoolbarFrame.document.forms[0].apply.disabled=false;
 * PkgDefFrame.location.href="../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1"; }
 * 
 *  }
 */

function create() {
	PkgDefFrame.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1";
}

function query() {
	PkgDefFrame.location.href = "../../eBL/jsp/PkgDefQueryCriteria.jsp"
}

/*
 * Karthik added the below Scripts to add link for Partial Deposit - Starts
 * MMS-CRF-0023
 */

async function openLinkScreen(index, modifyStatus) {
	var blgClsCode = eval("document.frmPkgDefBasePrice.blgClsCode_" + index).value;
	var pkgPrice = eval("document.frmPkgDefBasePrice.price_" + index).value;
	var partialDeposit = eval("document.frmPkgDefBasePrice.partialDeposit_"
			+ index).checked;
	var acrossEncounterEnabled = parent.parent.PkgDefHeader.document.forms[0].acrossEncounters.checked;

	if (partialDeposit && acrossEncounterEnabled) {
		if (blgClsCode.value != '') {
			var effFromDate = parent.parent.PkgDefHeader.document.forms[0].effFromDate.value;
			var packageCode = parent.parent.PkgDefHeader.document.forms[0].packageCode.value;
			var dialogUrl = "../../eBL/jsp/PkgDefBasePricePartialDepositFrame.jsp?blgClsCode="
					+ blgClsCode
					+ "&packageCode="
					+ packageCode
					+ "&effFromDate="
					+ effFromDate
					+ "&pkgPrice="
					+ pkgPrice
					+ "&modifystatus=" + modifyStatus;
			var dialogFeatures = "dialogHeight:" + "20" + "; dialogWidth:"
					+ "50" + " ; scroll=false; ";
			var returnVal = await window.showModalDialog(dialogUrl, null,
					dialogFeatures);
			if (returnVal != null) {
				var returnTextArr = returnVal.split("|");

				if (returnTextArr[0] == 'A') {
					eval("document.frmPkgDefBasePrice.minDepAmtind_" + index).value = returnTextArr[0];
				} else if (returnTextArr[0] == 'P') {
					eval("document.frmPkgDefBasePrice.minDepAmtind_" + index).value = 'R';
				} else {// 48042
					eval("document.frmPkgDefBasePrice.minDepAmtind_" + index).value = '';
				}
				eval("document.frmPkgDefBasePrice.minDepAmt_" + index).value = returnTextArr[1];
				eval("document.frmPkgDefBasePrice.minDepAmt_" + index).disabled = true;
				eval("document.frmPkgDefBasePrice.minDepAmtind_" + index).disabled = true;
			}
		} else {
			alert("Billing Class code should be provided");
		}
	}
}
/*
 * Karthik added the below Scripts to add link for Partial Deposit - Ends
 * MMS-CRF-0023
 */

// For adding multiple price range for package
function addRow(tableID, tabId, from) {
	var mode = "";
	var table = "";
	var rowCount = "";
	var index = "";
	var row = "";
	if (tabId == "PACKAGE_DATE") {	
	mode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		table = eval("parent.baseDateDtl.document.getElementById('" + tableID
				+ "')");
		var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		var result = true;
		var from = parent.baseDateDtl.document.forms[0].from.value;
		var glSmryYN = parent.baseDateDtl.document.forms[0].glSmryYN.value;
		var VATapplicable = parent.baseDateDtl.document.forms[0].VATapplicable.value;
		
		var glSmry = "";
		var glSmryDesc = "";
		var glSmryDisc = "";
		var glSmryDiscDesc = "";
		var VATapp="";
		var disableGLPost = "";
		var VATappchecked="";
	
		rowCount = table.rows.length;
		if (rowCount > 1)
			result = validatePackageDates(
					"parent.baseDateDtl.document.forms[0]", rowCount - 1);
		if (result) {
			index = rowCount - 1;
			row = eval(
					"parent.baseDateDtl.document.getElementById('" + tableID
							+ "')").insertRow(rowCount);			
				
			if (index != "0") {
				glSmry = eval("parent.baseDateDtl.document.forms[0].glSmry"
						+ (parseInt(index) - 1)).value
				glSmryDesc = eval("parent.baseDateDtl.document.forms[0].glSmryDesc"
						+ (parseInt(index) - 1)).value
				glSmryDisc = eval("parent.baseDateDtl.document.forms[0].glSmryDisc"
						+ (parseInt(index) - 1)).value
				glSmryDiscDesc = eval("parent.baseDateDtl.document.forms[0].glSmryDiscDesc"
						+ (parseInt(index) - 1)).value
			} else {
				glSmry = "";
				glSmryDesc = "";
				glSmryDisc = "";
				glSmryDiscDesc = "";

			}
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			if(VATapplicable=="Y"){
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			}
			cell1.innerHTML = "<input type='text' name='fromDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=\"showBasePrice(this,'"
					+ from
					+ "','"
					+ index
					+ "');dateKeyChange(this,this,'document.getElementById('toDate_')"
					+ index
					+ "','"
					+ index
					+ "','fromDate','document.getElementById('fromDatePrev_')"
					+ index
					+ "');\" ><img id = 'fromDate_img_"
					+ index
					+ "' name='fromDate_img_"
					+ index
					+ "'	  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar('fromDate_"
					+ index
					+ "');\"   /><img src='../../eCommon/images/mandatory.gif'/>";
			cell2.innerHTML = "<input type='text' name='toDate_"
					+ index
					+ "' id='toDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=pkgValidateDate(this,'document.getElementById('fromDate_"
					+ index
					+ "',this,'"
					+ index
					+ "','toDate') ><img id = 'toDate_img_"
					+ index
					+ "' name='toDate_img_"
					+ index
					+ "' src='../../eCommon/images/CommonCalendar.gif' onClick=showCalendar('toDate_"
					+ index + "'); > <input type='hidden' name='fromDatePrev_"
					+ index + "' id='fromDatePrev_" + index + "'  />";
			cell3.innerHTML = "<input type='text' name='pkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callPkgPriceClass(this,'code','PRICE_CLASS','"
					+ index
					+ "')\"  > <input type='text' name='pkgPriceClsDesc_"
					+ index
					+ "' size='10' maxlength=\"10\"  onBlur=\"callPkgPriceClass(this,'desc','PRICE_CLASS','"
					+ index
					+ "')\" ><input type='button' class='button' name='pkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callPkgPriceClass('','','PRICE_CLASS','"
					+ index + "')\"  tabindex='0'/>";
			cell4.innerHTML = "<input type='text' name='oPkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callPkgPriceClass(this,'code','OUT_PRICE_CLASS','"
					+ index
					+ "')\"  /><input type='text' name='oPkgPriceClsDesc_"
					+ index
					+ "' size='10' maxlength=\"10\" onBlur=\"callPkgPriceClass(this,'desc','OUT_PRICE_CLASS','"
					+ index
					+ "')\" /><input type='button' class='button' name='OPkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callPkgPriceClass('','','OUT_PRICE_CLASS','"
					+ index + "')\" tabindex='0'/>";
			if (glSmryYN == "N") {
				disableGLPost = "disabled";
			} else {
				disableGLPost = "";
			}
			cell5.innerHTML = "<input type='text' name='glSmry"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmry
					+ "' "
					+ disableGLPost
					+ " onBlur='glSmryCodeLookUp(glSmryDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDesc
					+ "' onBlur='glSmryDescLookUp(this,glSmry"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmry_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryLookUp"
					+ index + "' value='?' onClick='glSmryLookUp(glSmryDesc"
					+ index + ",glSmry" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			cell6.innerHTML = "<input type='text' name='glSmryDisc"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmryDisc
					+ "' "
					+ disableGLPost
					+ " onBlur='glSmryDiscCodeLookUp(glSmryDiscDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDiscDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDiscDesc
					+ "' onBlur='glSmryDiscDescLookUp(this,glSmryDisc"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmryDisc_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDiscDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryDiscLookUp"
					+ index
					+ "' value='?' onClick='glSmryDiscLookUp(glSmryDiscDesc"
					+ index + ",glSmryDisc" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			if(VATapplicable=="Y"){
		
			cell7.innerHTML = "<input type='checkbox' name='VATapp"
				+ index
				+ "' id='VATapp"
				+index
				+ "' value='"
				+VATapp
				+ "'"
				+ " onClick='enableRuleCode(VATapp"
				+index
				+ ",\""
				+ index
				+ "\")'" 
				+"/>";
			
			cell8.innerHTML = "<input type='text' name='VATpercent"
				+ index
				+ "' id='VATpercent"
				+index
				+ "' size='15' maxlength='15' value='"
				+ "'"
				+ " onBlur='ruleCodeLookup(VATpercent"
				+ index
				+ ",\""
				+ index
				+ "\")' disabled /><input type='button' class='button' name='VATpercent_temp"
				+index
				+"' id='VATpercent_temp"
				+index
				+"'value='?' onClick='ruleCodeLookup(VATpercent"
				+index
				+",\""
				+ index
				+ "\")' disabled/>";
			
			cell9.innerHTML = "<input type='radio'  name='select_0' id='select_0' id='select_"
				+ index
				+ "' value=\"N\" onClick=\"showBasePrice(this,'"
				+ from
				+ "','"
				+ index
				+ "')\"/> <input type='hidden' name='flag_"
				+ index 
				+ "' value=\"insert\" />";
			
			
			
			}
			else{
				
				
				cell7.innerHTML = "<input type='radio'  name='select_0' id='select_0' id='select_"
					+ index
					+ "' value=\"N\" onClick=\"showBasePrice(this,'"
					+ from
					+ "','"
					+ index
					+ "')\"/> <input type='hidden' name='flag_"
					+ index 
					+ "' value=\"insert\" />";
				
				
				
				
			}
			parent.baseDateDtl.document.frmPkgDefBaseDate.totRec.value = rowCount;
		}
		// Karthik added code here MMS-QF-SCF-0545 14/9/2016
		parent.baseDateDtl.document.frmPkgDefBaseDate.new_date_added.value = "Y";
		parent.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value = "N";
		parent.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "N";
		parent.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "N";
		parent.basePriceBtn.document.frmChargeBasedBtn.pkgDefAddBtn.disabled = true;
	} else if (tabId == "PACKAGE_PRICE") {
		mode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		table = eval("parent.basePriceDtl.document.getElementById('" + tableID
				+ "')");

		var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		var result = true;

		rowCount = table.rows.length;
		var blank = '';
		
		/* Added V06042018-Aravindh/GHL-SCF-1107/starts */
		var siteSpecPrtlDep = parent.parent.frames[3].frames[1].document.forms[0].siteSpecPrtlDep.value;
		var strChargeLogicVal = parent.parent.frames[3].frames[1].document.forms[0].strChargeLogic.value;
		/* Added V06042018-Aravindh/GHL-SCF-1107/ends */

		if (rowCount > 1)
			result = validatePackagePrice(
					"parent.basePriceDtl.document.forms[0]", rowCount - 1);
		if (result) {
			index = rowCount - 1;
			row = eval(
					"parent.basePriceDtl.document.getElementById('" + tableID
							+ "')").insertRow(rowCount);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);// Added by muthu for Factor for
											// service rate issue for KDAH on
											// 21-6-12
			var cell12 = row.insertCell(11);// Added by muthu for Report CRF
											// issue for KDAH on 28-6-12

			// var cell7=row.insertCell(6);

			cell1.innerHTML = "<input type='text' name='blgClsCode_"
					+ index
					+ "' size='3' maxlength=\"2\" onBlur=\"callBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",this,'"
					+ index
					+ "','code')\"><input type='text' name='blgClsDesc_"
					+ index
					+ "' size='15' maxlength='30'  onBlur=\"callBlgCls(this,document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "','desc')\"><input type='button' class='button' name='blgCls_"
					+ index
					+ "' value='?' onClick=\"callBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "')\" tabindex='0'\><img src='../../eCommon/images/mandatory.gif'>";
			cell2.innerHTML = "<select name='indicator_" + index
					+ "'    onChange=\"indiValidation(this,'" + index
					+ "')\"	><option value='R' >"
					+ getLabel('Common.Price.label', 'Common')
					+ "</option><option value='F'>"
					+ getLabel('eBL.FACTOR.label', 'BL') + "</option></select>";
			cell3.innerHTML = "<input type='text' name='price_"
					+ index
					+ "' size='12' maxlength='13' onBlur='validateBaePrice(this,\""
					+ noofdecimal
					+ "\",\"BL8526\",\""
					+ index
					+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/><input type='hidden' name='flag_"
					+ index + "' value='insert' onBlur=''>";
			cell4.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' size='2' disabled onkeypress=\" return (allowValidNumber1(this,event));\"  />";
			cell5.innerHTML = "<select name='roundInd_" + index
					+ "' disabled>	<option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			cell6.innerHTML = "<input type='checkbox' name='deposit_" + index
					+ "' value='' onClick =\"checkDeposit(this,'" + index
					+ "')\" />";
			// Karthik modified the below code to add link MMS-CRF-0023
			/* cell7.innerHTML = "<input type='checkbox' name='partialDeposit_"
					+ index
					+ "'  value='' disabled onClick =\"checkPartialDeposit(this,'"
					+ index + "')\" /> <a name='depositLink_" + index
					+ "' id='depositLink_" + index
					+ "' href='#' onClick ='openLinkScreen(" + index
					+ ",\"\");' > Link </a> "; */
			
			/* Added V06042018-Aravindh/GHL-SCF-1107/modified the above code as below by Aravindh - starts */
			if(siteSpecPrtlDep == true || siteSpecPrtlDep == "true" || strChargeLogicVal == "Y") {
				cell7.innerHTML = "<input type='checkbox' name='partialDeposit_"
					+ index
					+ "'  value='' disabled onClick =\"checkPartialDeposit(this,'"
					+ index + "')\" />";
				if(strChargeLogicVal == "Y") {
					cell7.innerHTML += "<a name='depositLink_" + index
					+ "' id='depositLink_" + index
					+ "' href='#' onClick ='openLinkScreen(" + index
					+ ",\"\");' > Link </a> "; 
				}
			} else {
				cell7.innerHTML = "<input type='checkbox' name='partialDeposit_"
					+ index
					+ "'  value='' disabled />";
			}
			/* Added V06042018-Aravindh/GHL-SCF-1107/modified the above code as below by Aravindh - ends */
			
			cell8.innerHTML = "<select  name='minDepAmtind_" + index
					+ "'	 disabled  onChange='validateInd(this,\"" + index
					+ "\",\"minDepAmt_\")'><option value='' >--"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "--</option><option value='A'  >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option></select>";
			cell9.innerHTML = "<input type='text' name='minDepAmt_"
					+ index
					+ "' value='' size='13' maxlength=\"13\"  disabled  onKeyPress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal
					+ "\")' onBlur='validForAmtPerUnltd(document.forms[0].minDepAmtind_"
					+ index + ",this,\"" + index + "\",\"PACKAGE_PRICE\",\""
					+ noofdecimal + "\")'  />";
			cell10.innerHTML = "<input type='checkbox' name='factorAppl_"
					+ index
					+ "' value='N' disabled  onclick=\"factorAppl(this,'"
					+ index + "')\" />";
			// Added by muthu for Factor for service rate issue for KDAH on
			// 21-6-12

			cell11.innerHTML = "<input type='text' name='factorforServiceRate"
					+ index + "' maxlength='20' size='10' value=''\" />";
			// Added by muthu for Report CRF issue for KDAH on 21-6-12

			cell12.innerHTML = "<input type='button' class='button' name='callReportPkg"
					+ index
					+ "'  value='R' onclick=\"callReportPkgBase(this,'"
					+ index + "')\" />";

			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = rowCount;
			parent.basePriceDtl.document.forms[0].totRec.value = rowCount;
		}

	} else if (tabId == "RATE_BASED") {
		/*
		 * table =
		 * eval("parent.rate_based_dtl.document.getElementById('"+tableID+"')");
		 * rowCount = table.rows.length; index = rowCount-1;
		 */
		var formObj = parent.rate_based_dtl.document.rate_based_dtl;

		var siteSpecf = formObj.siteSpecf.value; //sarathkumar InclHmeMedi
		var dailyLimitSiteSpec = formObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = formObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = formObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = formObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = formObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = formObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = formObj.totalRecords.value;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		var servGrpLmtFldDisabled = formObj.servGrpLmtFldDisabled.value;
		var servGrpLmtBy = formObj.servGrpLmtBy.value;
		var servGrpLimitSiteSpec = formObj.servGrpLimitSiteSpec.value;
		rowCount = parseInt(totalRecords) + 1;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		// index = parseInt(rowCount)-1;
		index = parseInt(totalRecords);
		var message = "";
		var obj;
		var order_associated = formObj.order_associated.value;
		if (order_associated == "Y") {
			if (eval("formObj.service_code" + (parseInt(index) - 1)) != null
					&& eval("formObj.service_code" + (parseInt(index) - 1)).value != "") {
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8562", 'BL');
					obj = eval("formObj.catalog_desc" + (parseInt(index) - 1));
				}
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value != ""
						&& eval("formObj.qty_limit" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8538", 'BL');
					obj = eval("formObj.qty_limit" + (parseInt(index) - 1));
				}
				// messageFrame.location.href =
				// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if (message != "") {
					alert(message);
					obj.focus();
					return false
				}
			}
		}

		// row=eval("parent.rate_based_dtl.document.getElementById('"+tableID+"')").insertRow(rowCount);
		row = eval(
				"parent.rate_based_dtl.document.getElementById('" + tableID
						+ "')").insertRow();
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14);
		var cell16 = row.insertCell(15);
		var cell17 = row.insertCell(16);
		var cell18 = row.insertCell(17);
		var cell19 = row.insertCell(18); //sarathkumar InclHmeMedi
		var cell20 = row.insertCell(19); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell21 = row.insertCell(20); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell22 = row.insertCell(21); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var cell23 = row.insertCell(22); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		var typeHTML = "";
		var indHTML = "";
		var ordCatDisabled = "disabled";
		noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		if (order_associated == "Y") {
			ordCatDisabled = "";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onServiceTypeChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value=''U'>"
					+ getLabel('Common.UserDefined.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		} else {
			ordCatDisabled = "disabled";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onServiceTypeChange(this,\"" + index
					+ "\")'><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;

		cell2.innerHTML = "<input  type='hidden' name='service_code"
				+ index
				+ "' value=''><input type='text'  name='service_desc"
				+ index
				+ "' size='10' maxlength='10' onBlur='before_serviceLookUp(this,service_code"
				+ index
				+ ",type"
				+ index
				+ ",\""
				+ index
				+ "\"); IncludeHomeMedicationCheck(service_code"+ index + ",type"+ index + ",\""+ index + "\");' value=''><INPUT type='hidden' name='service_desc_temp" //sarathkumar InclHmeMedi//Added V190404-Dhananjay/MMS-DM-CRF-0129
				+ index
				+ "' value=''><input type='button' name='service_button"
				+ index
				+ "' class='button' value='?' onClick='serviceLookUp(service_desc"
				+ index + ",service_code" + index + ",type" + index + ",\""
				+ index + "\"); IncludeHomeMedicationCheck(service_code"+ index + ",type"+ index + ",\""+ index + "\");'/>";  //sarathkumar InclHmeMedi//Added V190404-Dhananjay/MMS-DM-CRF-0129

		cell3.innerHTML = "<input  type='hidden' name='catalog_code"
				+ index
				+ "' value=''><input type='text' name = 'catalog_desc"
				+ index
				+ "'  "
				+ ordCatDisabled
				+ " size='10' maxlength='10' onBlur='before_catalogLookUp(this,catalog_code"
				+ index + ",service_code" + index + ",\"" + index
				+ "\")' value=''><INPUT type='hidden' name='catalog_desc_temp"
				+ index + "' value=''><input type=button name='catalog_button"
				+ index + "'  " + ordCatDisabled
				+ " class=button  value=? onClick='catalogLookUp(catalog_desc"
				+ index + ",catalog_code" + index + ",service_code" + index
				+ ",\"" + index + "\")'/>";

		cell4.innerHTML = indHTML;

		cell5.innerHTML = "<input type='text' name='factorOrRate"
				+ index
				+ "' size='12' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
				+ noofdecimal
				+ "\",\"BL8665\");' onkeypress='return allowValidNumber1(this,event)';/>";

		cell6.innerHTML = "<input type='text' name='qty_limit" + index
				+ "' disabled size='8' onBlur='chkQtyLimit(this,\"" + index
				+ "\");' onkeypress='return ChkNumberInput(this,event,\""
				+ noofdecimal + "\")'/>";
		cell7.innerHTML = "<select  name='amt_limit_ind"
				+ index
				+ "' onChange='validateInd(this,\""
				+ index
				+ "\",\"perAmt_limit\",\"factor_appl\",\"qty_limit\");changeSplitReqd(this,\"amt_limit\",\""
				+ index + "\",\""+dailyLimitSiteSpec+"\",dailyLmtIndicator"+ index + ")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option><option value='U' >"
				+ getLabel('eBL.UNLIMITED.label', 'BL') + "</option></select>";
		cell8.innerHTML = "<input type='text' name='perAmt_limit"
				+ index
				+ "' size='8' maxlength='13'  onBlur='validForAmtPerUnltd(document.forms[0].amt_limit_ind"
				+ index
				+ ",this,\""
				+ index
				+ "\",\"\",\""
				+ noofdecimal
				+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\")'; />";

		cell9.innerHTML = "<input type='text' name='roundTo"
				+ index
				+ "' size='6'   onkeypress=\" return (allowValidNumber1(this,event));\"  value='' />";
		cell10.innerHTML = "<select name='roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		// cell9.innerHTML="<input type='checkbox' disabled
		// name='unlimited"+index+"' id='unlimited"+index+"' onClick='chkUnlimited(this,\""+index+"\")'
		// value='N'/>";
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 		
		var optionTxt1 = "";
		if (servGrpLmtBy != "*") {				
			if (servGrpLmtBy == "B" ) {				
				optionTxt1 += "<option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option><option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option></select>";
			} else if (servGrpLmtBy == "G" ) {
				optionTxt1 +="</option><option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option>";
			} else if (servGrpLmtBy == "S" ) {
				optionTxt1 +="<option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option>";
			}
		}		
		if (servGrpLimitSiteSpec == "true" && order_associated=="N") {
			servGrpLmtFldDisabled = " enabled ";
		}
		cell11.innerHTML = "<select name='serv_grp_limit_ind" + index
		+ "' id='serv_grp_limit_ind" + index
		+ "' "+servGrpLmtFldDisabled
		+">"
		+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt1+"</select>";
		//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		//sarathkumar InclHmeMedi
		if(siteSpecf == 'true'){
			cell12.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='N' disabled onclick='checkInclHomeMedi(this);'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
		}
		else{
			cell12.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		/* Modified V190626-Aravindh/MMS-DM-CRF-0129.1/if-else */
		if(dailyLimitSiteSpec == "true") {
			/*cell12.innerHTML = "<input type='checkbox' name='dailyLmtChkBx" + index
			+ "' id='dailyLmtChkBx" + index
			+ "' onclick = 'dailyLmtChkBxClick(this,"+ index +",document.rate_based_dtl)' value='N' disabled />";*/
			var optionTxt = "";
			if("G" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			
			var ordCatDisabled1 = "";
			if(order_associated == "Y") {
				ordCatDisabled1 = " disabled ";
			}
			
			cell13.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.rate_based_dtl)' "+ ordCatDisabled1 +" >"
			+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell13.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell14.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
			cell14.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			/*cell13.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";*/
			cell15.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
			/*cell13.innerHTML += "<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";*/
		} else {
			cell13.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell13.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell14.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell14.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell15.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		cell16.innerHTML = "<input type='checkbox' disabled name='replace"
				+ index + "' onClick='chkReplace(this,\"" + index
				+ "\")' value='N' />";
		cell17.innerHTML = "<input type='checkbox'  disabled name='refund"
				+ index + "' onClick='chkRefund(this,\"" + index
				+ "\")' value='N' />";
		cell18.innerHTML = "<input type='checkbox'  disabled  name='autoRefund"
				+ index + "' onClick='chkautoRefund(this,\"refundAmt" + index
				+ "\")' value=\"N\"/>";
		cell19.innerHTML = "<input type='checkbox'  name='factor_appl" + index
				+ "' onClick='factorAppl(this,\"" + index
				+ "\")' disabled value='N'/>";
		cell20.innerHTML = "<input type='radio' name='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"
				+ index
				+ "')\" disabled /><input type='hidden' name='closePkg"
				+ index + "' value=\"N\" disabled />";
		cell21.innerHTML = "<input type='checkbox'  disabled name='service_limit"
				+ index
				+ "' onClick='chkServiceLimit(this,\""
				+ index
				+ "\")' value='N'/>";
		cell22.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell23.innerHTML = "<input type='checkbox'  name='deleteService"
				+ index + "' onClick='chkDeleteService(this,\"" + index
				+ "\")' value='N'/>";
		formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		// added for common validation
		parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = rowCount;
	} else if (tabId == "SRVLIMIT_RATE_BASED") {
		/*
		 * table =
		 * eval("parent.frames[2].document.getElementById('"+tableID+"')");
		 * rowCount = table.rows.length; index = rowCount-1;
		 */
		// commented line and added new line by ram
		// var
		// srvLimitFormObj=parent.frames[2].document.srvLimit_rate_based_dtl;
		var srvLimitFormObj = parent.frames[4].document.srvLimit_rate_based_dtl;
		var siteSpecf = srvLimitFormObj.siteSpecf.value;//sarathkumar InclHmeMedi
		var dailyLimitSiteSpec = srvLimitFormObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = srvLimitFormObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = srvLimitFormObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = srvLimitFormObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = srvLimitFormObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = srvLimitFormObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var parDailyLmtInd = srvLimitFormObj.parDailyLmtInd.value;//Added V190731-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = srvLimitFormObj.totalRecords.value;
		rowCount = parseInt(totalRecords) + 1
		// index = parseInt(rowCount)-1;
		index = parseInt(totalRecords);
		var message = "";
		var prevIndex = parseInt(index) - 1;
		var obj;
		if (eval("srvLimitFormObj.srvLimit_service_code" + prevIndex).value != ""
				&& (eval("srvLimitFormObj.exludeService" + prevIndex).value == "N" || eval("srvLimitFormObj.exludeService"
						+ prevIndex).value == "")) {
			if (eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex).value == ""
					&& eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).value == "") {
				message = getMessage("BL8555", 'BL');
				if (eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).disabled)
					obj = eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex);
				else
					obj = eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex);
			}
			/*
			 * if(eval("srvLimitFormObj.srvLimit_type"+prevIndex).value=="C" &&
			 * eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex).value==""){
			 * alert('here 1') message=getMessage("BL8561",'BL');
			 * obj=eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex); }else
			 * if(eval("srvLimitFormObj.srvLimit_type"+prevIndex).value=="S" &&
			 * eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex).value=="" &&
			 * eval("srvLimitFormObj.srvLimit_qty_limit"+prevIndex).value==""){
			 * alert('here 2') message=getMessage("BL8555",'BL');
			 * if(eval("srvLimitFormObj.srvLimit_qty_limit"+prevIndex).disabled)
			 * obj=eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex); else
			 * obj=eval("srvLimitFormObj.srvLimit_qty_limit"+prevIndex); }
			 */
			if (message != "") {
				// messageFrame.location.href =
				// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				alert(message);
				obj.focus();
				return false
			}
		}

		// row=eval("parent.frames[2].document.getElementById('"+tableID+"')").insertRow(rowCount);

		// row=eval("parent.frames[2].document.getElementById('"+tableID+"')").insertRow();
		// commented line and new line added by ram
		row = eval(
				"parent.frames[4].document.getElementById('" + tableID + "')")
				.insertRow();

		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14); //sarathkumar InclHmeMedi
		var cell16 = row.insertCell(15); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell17 = row.insertCell(16); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell18 = row.insertCell(17); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var typeHTML = "";
		var parent_type = srvLimitFormObj.parent_type.value;
		noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		if (parent_type == "G") {
			typeHTML = "<select NAME='srvLimit_type" + index
					+ "' onChange='onSrvLimitServiceTypeChange(this,\"" + index
					+ "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else if (parent_type == "P") {
			typeHTML = "<select NAME='srvLimit_type" + index
					+ "' onChange='onSrvLimitServiceTypeChange(this,\"" + index
					+ "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='T'>"
					+ getLabel('eBL.SalesCategory.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else {
			typeHTML = "<select NAME='srvLimit_type" + index
					+ "' onChange='onSrvLimitServiceTypeChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;
		cell2.innerHTML = "<input  type='text' name='srvLimit_service_code"
				+ index
				+ "' value='' size='10' onBlur='srvLimitCodeLookUp(srvLimit_service_desc"
				+ index
				+ ",this,srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\"); IncludeHomeMedicationCheck(srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");'><input type='text' name = 'srvLimit_service_desc" //Added V190404-Dhananjay/MMS-DM-CRF-0129
				+ index
				+ "' size='10' maxlength='10' onBlur='before_srvLimitServiceLookUp(this,srvLimit_service_code"
				+ index
				+ ",srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\"); IncludeHomeMedicationCheck(srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");' value=''><INPUT type='hidden' name='srvLimit_service_code_temp" //Added V190404-Dhananjay/MMS-DM-CRF-0129
				+ index
				+ "' value=''><INPUT type='hidden' name='srvLimit_service_desc_temp"
				+ index
				+ "' value=''><input type='button' name='srvLimit_service_button"
				+ index
				+ "' class='button' value='?' onclick='srvLimitServiceLookUp(srvLimit_service_desc"
				+ index + ",srvLimit_service_code" + index + ",srvLimit_type"
				+ index + ",\"" + index + "\"); IncludeHomeMedicationCheck(srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");' />"; //Added V190404-Dhananjay/MMS-DM-CRF-0129
		cell3.innerHTML = "<input type='checkbox' name='exludeService" + index
				+ "' onClick='chkExludeService(this,\"" + index
				+ "\");changeSplitReqd(this,\"exclude\",\"" + index
				+ "\"); IncludeHomeMedicationExclude(this,srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");' value='N' />";
		cell4.innerHTML = "<input type='text' name='srvLimit_qty_limit"
				+ index
				+ "' disabled size='8' onBlur='chkSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber1_temp(this,event,\"2\");'  value='' />";
		cell5.innerHTML = "<select  name='srvLimit_amt_limit_ind"
				+ index
				+ "' onChange='validateInd(this,\""
				+ index
				+ "\",\"srvLimit_amt_limit\",\"srvLimit_factor_appl\",\"srvLimit_qty_limit\")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option></select>";
		cell6.innerHTML = "<input type='text' name='srvLimit_amt_limit"
				+ index
				+ "'  disabled size='6' maxlength='13'  onBlur='chkSrvLimitAmtLimit(this,\""
				+ index
				+ "\",\""
				+ noofdecimal
				+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\");'  value='' />";
		cell7.innerHTML = "<input type='text' name='srvLimit_roundTo"
				+ index
				+ "' size='6'   onkeypress=\" return (allowValidNumber1(this,event));\"  value='' />";
		cell8.innerHTML = "<select name='srvLimit_roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		
		//sarathkumar InclHmeMedi
		if(siteSpecf == 'true'){
		cell9.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
		+ "' id='includeHomeMedication" + index
		+ "'    value='N' disabled onclick='checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,\"rateexclude\",\""+ index + "\");' ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		else{
			cell9.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		/* Modified V190626-Aravindh/MMS-DM-CRF-0129.1/if-else */
		if(dailyLimitSiteSpec == "true") {
			/*cell10.innerHTML = "<input type='checkbox' name='dailyLmtChkBx" + index
			+ "' id='dailyLmtChkBx" + index
			+ "' onclick = 'dailyLmtChkBxClick(this,"+ index +",document.rate_based_dtl)' value='N' disabled />";*/
			var optionTxt = "";
			if("G" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			cell10.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.srvLimit_rate_based_dtl)'>"
			+"<option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell11.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+" readOnly />";
			cell11.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell11.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			cell12.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+" readOnly />";
			/*cell12.innerHTML += "<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";*/
		} else {
			cell10.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell11.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell11.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell12.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		
		cell13.innerHTML = "<input type='checkbox' name='srvLimit_replace"
				+ index
				+ "' disabled  onClick='srvLimitChkReplace(this,\""
				+ index
				+ "\")' value=\"N\"/><a style =\"display:none\" name='srvLimit_replace_dtls"
				+ index + "' href='#' onClick='srvLimitShowReplaceDtls(\""
				+ index + "\")'>" + getLabel('eBL.Dtls.label', 'BL')
				+ "</a><input type=\"hidden\" name=\"srvLimit_replaceSrv_code" 
				+ index
				+ "\" id=\"srvLimit_replaceSrv_code" 
				+ index
				+ "\" ><input type=\"hidden\" name=\"srvLimit_replaceSrv_desc"
				+ index + "\" id=\"srvLimit_replaceSrv_desc"
				+ index + "\" />";
		cell14.innerHTML = "<input type='checkbox' name='srvLimit_refund"
				+ index
				+ "' id='srvLimit_refund"
				+ index
				+ "' disabled onClick='srvLimitChkRefund(this,\""
				+ index
				+ "\")' value=\"N\"/><input type='text' name='srvLimit_refundAmt"
				+ index
				+ "' id='srvLimit_refundAmt"
				+ index
				+ "' value=''  style =\"display:none\" onBlur='return validPercentageForRefund(this,\"srvLimit_autoRefund"
				+ index
				+ "\")' onkeypress='return ChkNumberInput(this,event,\""
				+ noofdecimal + "\")' size='2' maxlength='4' >";
		cell15.innerHTML = "<input type='checkbox'  disabled  name='srvLimit_autoRefund"
				+ index
				+ "' id='srvLimit_autoRefund"
				+ index
				+ "' onClick='chkautoRefund(this,\"srvLimit_refundAmt"
				+ index + "\")' value=\"N\"/>";
		cell16.innerHTML = "<input type='checkbox' disabled  name='srvLimit_factor_appl"
				+ index
				+ "' id='srvLimit_factor_appl"
				+ index
				+ "' onClick='srvLimitFactorAppl(this,\""
				+ index
				+ "\")' value='N'/>";
		cell17.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell18.innerHTML = "<input type='checkbox'  name='srvLimit_deleteService"
				+ index
				+ "' id='srvLimit_deleteService"
				+ index
				+ "' onClick='chkSrvLimitDeleteService(this,\""
				+ index
				+ "\")' value='N'/>";
		srvLimitFormObj.totalRecords.value = parseInt(srvLimitFormObj.totalRecords.value) + 1;
		// added for common validation
		parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value = rowCount;
	} else if (tabId == "CHARGE_BASED") {
		var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		var siteSpecf = document.getElementById("siteSpecf").value;
		
		// mode = parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		table = eval("parent.ChargeBasedDtl.document.getElementById('"
				+ tableID + "')");
		rowCount = table.rows.length;
		result = true;
		if (rowCount > 1) {
			result = validateChargeBased(
					"parent.ChargeBasedDtl.document.forms[0]", rowCount - 1)
		}
		if (result) {

			index = rowCount - 1;
			var i = 1;
			row = eval(
					"parent.ChargeBasedDtl.document.getElementById('" + tableID
							+ "')").insertRow(rowCount);
			/*
			 * var col_no=document.col_no.value;
			 * 
			 * alert("col_no="+col_no); for(var i=0;i<col_no;i++){
			 * row.insertCell(0).innerHTML="" }
			 */
			var typeHTML = "";
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);// MuthuN against 28192
			var cell12 = row.insertCell(11);// SplitReqd
			var cell13 = row.insertCell(12); //sarathkumar InclHmeMedi
			typeHTML = "<select NAME='charge_type" + index
					+ "' id='charge_type" + index
					+ "' onChange='onSrvLimitServiceTypeChange1(this,\""
					+ index + "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'BL')
					+ "</option></select>";// MuthuN against 28192
			cell1.innerHTML = typeHTML;// MuthuN against 28192
			cell2.innerHTML = "<input type='text' name = 'cbCode_"
					+ index
					+ "' id = 'cbCode_"
					+ index
					+ "' size='10' maxlength='10' onBlur='callLookup(this,this,document.forms[0].cbDesc_"
					+ index
					+ ",\"CHARGE_BASED\",\""
					+ index
					+ "\"); IncludeHomeMedicationCheck(cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");' /><input type='hidden' name = 'cbCodePrev_"
					+ index
					+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
					+ index
					+ "' value ='' /><input type='text' name='cbDesc_"
					+ index
					+ "' id='cbDesc_"
					+ index
					+ "' size='30' maxlength='100'  value=''   onBlur='callLookup(this,document.forms[0].cbCode_"
					+ index
					+ ",this,\"CHARGE_BASED\",\""
					+ index
					+ "\"); IncludeHomeMedicationCheck(cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");' /><input type='button' class='button' name='serviceLookUp_"
					+ index
					+ "' value='?' onClick='callServices(document.forms[0].cbCode_"
					+ index + ",document.forms[0].cbDesc_" + index
					+ ",\"CHARGE_BASED\",charge_type" + index + ",\"" + index
					+ "\"); IncludeHomeMedicationCheck(cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");' />";
			cell3.innerHTML = "<select  name='amt_limit_ind"
					+ index
					+ "' onChange='validateInd(this,\""
					+ index
					+ "\",\"perAmt_limit\",\"factor_appl\");changeSplitReqd(this,\"amt_limit\",\""
					+ index + "\")'><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='P' >"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='U' >"
					+ getLabel('eBL.UNLIMITED.label', 'BL')
					+ "</option></select>";
			cell4.innerHTML = "<input type='text' name='perAmt_limit"
					+ index
					+ "' size='5' maxlength='13'  onBlur='validForAmtPerUnltd(document.forms[0].amt_limit_ind"
					+ index
					+ ",this,\""
					+ index
					+ "\",\"CHARGE_BASED\",\""
					+ noofdecimal
					+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")'; />";
			cell5.innerHTML = "<input type='checkbox' name='srvLmt_"
					+ index
					+ "' value=\"N\"   onclick=\"showLmtDetails(this,'"
					+ index
					+ "')\"/><a style =\"display:none\" id='srvLmtDtls_"
					+ index
					+ "' href='javascript:loadChargeBasedServiceLimit(document.forms[0].cbCode_"
					+ index + ".value,\"" + index + "\")'>"
					+ getLabel('eBL.Dtls.label', 'BL') + "</a>";
			cell6.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' size='3'   onkeypress=\" return (allowValidNumber1(this,event));\"   value='' />";
			cell7.innerHTML = "<select name='roundInd_" + index
					+ "' ><option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			
			if(siteSpecf == 'true'){
				//sarathkumar InclHmeMedi
				cell8.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this);' ><input type='hidden' name='enableDisParam"+index+"' id='enableDisParam"+index+"' id='enableDisParam"+index+"' value='Y'>";
			}
			else{
				//sarathkumar InclHmeMedi
				cell8.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			
			
			
			cell9.innerHTML = "<input type='checkbox'   name='refund_"
					+ index
					+ "' onClick='chkRefundCB(this,\""
					+ index
					+ "\")' value='N' /><input type='text' name='refundAmt_"
					+ index
					+ "' id='refundAmt_"
					+ index
					+ "' style =\"display:none\" onBlur='return validPercentageForRefundCust(this,\"autoRefund_"
					+ index
					+ "\")' onkeypress='return ChkNumberInput(this,event,\"2\")' size='2' maxlength='4' >";
			cell10.innerHTML = "<input type='checkbox'   name='autoRefund_"
					+ index + "' onClick='chkautoRefund(this,\"refundAmt_"
					+ index + "\")' value=\"N\"/>";
			cell11.innerHTML = "<input type='checkbox'  name='factor_appl"
					+ index + "' onClick='factorAppl(this,\"" + index
					+ "\")' DISABLED value=\"N\"/>";
			cell12.innerHTML = "<input type='checkbox' name='split_reqd"
					+ index + "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			cell13.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkDeleteService(this,'" + index
					+ "')\"/>";
			/*
			 * cell1.innerHTML="<input type='text' name = 'cbCode_"+index+"' id =
			 * 'cbCode_"+index+"' size='10' maxlength='10'
			 * onBlur='callLookup(this,this,document.forms[0].cbDesc_"+index+",\"CHARGE_BASED\",\""+index+"\");' /><input
			 * type='hidden' name = 'cbCodePrev_"+index+"' value ='' /><input
			 * type='hidden' name = 'cbDescPrev_"+index+"' value ='' /><input * type='text' name='cbDesc_"+index+"' id='cbDesc_"+index+"' id='cbDesc_"+index+"'
			 * size='30' maxlength='100' value=''
			 * onBlur='callLookup(this,document.forms[0].cbCode_"+index+",this,\"CHARGE_BASED\",\""+index+"\");' /><input * type='button' class='button' name='serviceLookUp_"+index+"' id='serviceLookUp_"+index+"'
			 * value='?'
			 * onClick=callServices(document.forms[0].cbCode_"+index+",document.forms[0].cbDesc_"+index+",'CHARGE_BASED',\""+index+"\")
			 * />"; cell2.innerHTML="<select name='amt_limit_ind"+index+"' id='amt_limit_ind"+index+"'
			 * onChange='validateInd(this,\""+index+"\",\"perAmt_limit\",\"factor_appl\")'><option
			 * value='A' >"+getLabel('Common.amount.label','Common')+"</option><option
			 * value='P' >"+getLabel('Common.Percent.label','Common')+"</option><option
			 * value='U' >"+getLabel('eBL.UNLIMITED.label','BL')+"</option></select>";
			 * cell3.innerHTML="<input type='text' name='perAmt_limit"+index+"' id='perAmt_limit"+index+"'
			 * size='5' maxlength='13'
			 * onBlur='validForAmtPerUnltd(document.forms[0].amt_limit_ind"+index+",this,\""+index+"\",\"CHARGE_BASED\",\""+noofdecimal+"\")'
			 * onkeypress='return
			 * allowValidNumber(this,event,\"10\",\""+noofdecimal+"\")'; />";
			 * cell4.innerHTML="<input type='checkbox' name='srvLmt_"+index+"' id='srvLmt_"+index+"'
			 * value=\"N\" onclick=\"showLmtDetails(this,'"+index+"')\"/><a
			 * style =\"display:none\" id='srvLmtDtls_"+index+"'
			 * href='javascript:loadChargeBasedServiceLimit(document.forms[0].cbCode_"+index+".value,\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL'
			 * )+"</a>"; cell5.innerHTML="<input type='text'
			 * name='roundTo_"+index+"' id='roundTo_"+index+"' size='3' onkeypress=\" return
			 * (allowValidNumber1(this,event));\" value='' />";
			 * cell6.innerHTML="<select name='roundInd_"+index+"' id='roundInd_"+index+"' ><option
			 * value='U' >"+getLabel('Common.Up.label','Common')+"</option><option
			 * value='D' >"+getLabel('eBL.DOWN.label','BL')+"</option></select>";
			 * cell7.innerHTML="<input type='checkbox' name='refund_"+index+"' id='refund_"+index+"'
			 * onClick='chkRefundCB(this,\""+index+"\")' value='N' /><input * type='text' name='refundAmt_"+index+"' id='refundAmt_"+index+"' id='refundAmt_"+index+"'
			 * style =\"display:none\" onBlur='return
			 * validPercentageForRefundCust(this,\"autoRefund_"+index+"\")'
			 * onkeypress='return ChkNumberInput(this,event,\"2\")' size='2'
			 * maxlength='4' >"; cell8.innerHTML="<input type='checkbox'
			 * name='autoRefund_"+index+"' id='autoRefund_"+index+"'
			 * onClick='chkautoRefund(this,\"refundAmt_"+index+"\")'
			 * value=\"N\"/>"; cell9.innerHTML="<input type='checkbox'
			 * name='factor_appl"+index+"' id='factor_appl"+index+"'
			 * onClick='factorAppl(this,\""+index+"\")' DISABLED value=\"N\"/>";
			 * cell10.innerHTML="<input type='checkbox'
			 * name='delCode_"+index+"' id='delCode_"+index+"' value=''
			 * onclick=\"chkDeleteService(this,'"+index+"')\"/>";
			 */
			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = rowCount;
		}
	} else if (tabId == "CHARGE_BASED_ITEM") {
		var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value
		var siteSpecf = document.getElementById("siteSpecf").value
		table = eval("parent.ChargeBasedExCln.document.getElementById('"
				+ tableID + "')");
		rowCount = table.rows.length;
		var result = true;
		if (rowCount > 1) {
			result = validateChargeBasedItems(parent.ChargeBasedExCln.document
					.forms[0], rowCount - 1)
		}
		if (result) {
			index = rowCount - 1;
			var i = 1;
			row = eval(
					"parent.ChargeBasedExCln.document.getElementById('"
							+ tableID + "')").insertRow(rowCount);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6); //sarathkumar InclHmeMedi
			cell1.innerHTML ="<input type='hidden' name = 'charge_type"
				+ index
				+ "' id ='charge_type"+ index + "' value = 'M' /><input type='text' name = 'cbCode_"
				+ index
				+ "' id = 'cbCode_"
				+ index
				+ "' size='10' maxlength='10' onBlur='callServices(document.forms[0].cbCode_"
				+ index + ",document.forms[0].cbDesc_" + index
				+ ",\"CHARGE_BASED_ITEM\",\"\" ,\"" + index + "\");IncludeHomeMedicationCheck(cbCode_"+ index +",charge_type"+ index + ",\""+ index + "\");' /><input type='hidden' name = 'cbCodePrev_"
				+ index
				+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
				+ index
				+ "' value =''/><input type='text' name='cbDesc_"
				+ index
				+ "' id='cbDesc_"
				+ index
				+ "' size='30' maxlength='100'  value=''   onBlur='callServices(document.forms[0].cbCode_"
				+ index + ",document.forms[0].cbDesc_" + index
				+ ",\"CHARGE_BASED_ITEM\",\"\" ,\"" + index + "\");IncludeHomeMedicationCheck(cbCode_"+ index +",charge_type"+ index + ",\""+ index + "\");' /><input type='button' class='button' name='serviceLookUp_"
				+ index
				+ "' value='?' onClick='callServices(document.forms[0].cbCode_"
				+ index + ",document.forms[0].cbDesc_" + index
				+ ",\"CHARGE_BASED_ITEM\",\"\" ,\"" + index + "\");IncludeHomeMedicationCheck(cbCode_"+ index +",charge_type"+ index + ",\""+ index + "\");' />";
			cell2.innerHTML = "<input type='checkbox' name='inEx_" + index
					+ "' value='N'  onclick='excludeItem(this,\"" + index
					+ "\");changeSplitReqd(this,\"exclude\",\"" + index
					+ "\");IncludeHomeMedicationExclude(this,cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");'/>";
			cell3.innerHTML = "<input type='text' name='quantityLimit_"
					+ index
					+ "' size='15' maxlength='15'  value='' onkeypress=' return allowValidNumber1(this,event,\"2\");'/>";
			cell4.innerHTML = "<input type='text' name='amountLimit_"
					+ index
					+ "' size='13' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
					+ noofdecimal
					+ "\",\"BL8540\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/>";
			// cell5.innerHTML="<input type='checkbox'
			// name='factorAppl_"+index+"' id='factorAppl_"+index+"'
			// onClick='factorAppl(this,\""+index+"\")' value=\"N\"/>";
			
			//sarathkumar InclHmeMedi
			if(siteSpecf == 'true'){
				//sarathkumar InclHmeMedi
				cell5.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,\"chargeexclude\",\""+ index + "\");'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y' >";
			}
			else{
				//sarathkumar InclHmeMedi
				cell5.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			
			
			cell6.innerHTML = "<input type='checkbox' name='split_reqd" + index
					+ "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			cell7.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkDeleteService(this,'" + index
					+ "')\"/>";
			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value = rowCount;
			parent.ChargeBasedExCln.document.forms[0].totalRecords.value = rowCount;
		}
	} 
	else if (tabId == "CHILD_PACK") {
		
		var formObj = parent.ass_child_pack_dtl.document.frmChildPackdtls;
	
		var totalRecords = formObj.totRec.value;
		rowCount = parseInt(totalRecords) + 1;
	 index = parseInt(totalRecords);
		var message = "";
		var obj;
		var result=true;

if (rowCount > 1)
			result = validateChildPackage(
					eval("parent.ass_child_pack_dtl.document.forms[0]"), rowCount - 1);
					
	
if(result){
		row=eval("parent.ass_child_pack_dtl.document.getElementById('"+tableID+"')").insertRow(rowCount);
		
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		
		var typeHTML = "";
		var indHTML = "";
		

		cell1.innerHTML =  "<input  type='text' name='childPackCode_"
				+ index
				+ "' value='' size='4' onBlur=\"child_pkgCode(document.forms[0].childPackCode_"
				+ index 
				+ ",document.forms[0].childPackDesc_" 
				+ index
				+ ",'"
				+ index
				+ "')\" ><input type='text' name = 'childPackDesc_"
				+ index
				+ "' size='15' maxlength='13' value='' onBlur=\"child_pkgCodeLookup(document.forms[0].childPackCode_"
				+ index 
				+ ",document.forms[0].childPackDesc_" 
				+ index
				+ ",'"
				+ index
				+ "')\"><input type='button' name='childPack_"
				+ index
				+ "' class='button' value='?' onclick=\"child_pkgCodeLookup(document.forms[0].childPackCode_"
				+ index 
				+ ",document.forms[0].childPackDesc_" 
				+ index
				+ ",'"
				+ index
				+ "')\"/><img src='../../eCommon/images/mandatory.gif'/>";


		cell2.innerHTML =  "<input type='text' name='fromDate_"
					+ index
					+ "' size='15' maxlength='12' onBlur=\"childPackdetails(this,document.forms[0].fromDate_"
					+ index 
					+ ",'','toDate')\" ><img id = 'fromDate_img_"
					+ index
					+ "' name='fromDate_img_"
					+ index
					+ "'	  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar('fromDate_"
					+ index
					+ "');\"   /><img src='../../eCommon/images/mandatory.gif'/>";

		cell3.innerHTML =   "<input type='text' name='toDate_"
					+ index
					+ "' size='15' maxlength='12' onBlur=\"childPackdetails(this,document.forms[0].fromDate_"
					+ index 
					+ ",document.forms[0].toDate_"
					+ index 
					+ ",'"
					+ index
					+ "','toDate')\"><img id = 'toDate_img_"
					+ index
					+ "' name='toDate_img_"
					+ index
					+ "'	  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar('toDate_"
					+ index
					+ "');\"   />";


		
		formObj.totRec.value = parseInt(formObj.totRec.value) + 1;
		parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = rowCount;
	}
	}
	else if (tabId == "CUSTOMER") {
		var formObj = parent.cust_dtls.document.cust_dtls;
		var totalRecords = formObj.totalRecords.value;
		var noofdecimal = formObj.noofdecimal.value;
		rowCount = parseInt(totalRecords) + 1
		index = parseInt(totalRecords);

		var result = true;
		result = validateCustomers(formObj);
		if (result) {
			row = eval(
					"parent.cust_dtls.document.getElementById('" + tableID
							+ "')").insertRow();
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);

			cell1.innerHTML = "<input  type='text' name='cust_grp_code"
					+ index
					+ "' value='' size='10' onBlur='custGrpCodeLookUp(cust_grp_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name = 'cust_grp_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custGrpDescLookUp(this,cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value'' /><INPUT type='hidden' name='cust_grp_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='cust_grp_desc_temp"
					+ index
					+ "' value=''><input type='button' name='cust_grp_button"
					+ index
					+ "' class='button' value='?' onclick='custGrpLookUp(cust_grp_desc"
					+ index + ",cust_grp_code" + index + ",\"" + index
					+ "\")'/>";
			cell2.innerHTML = "<input  type='text' name='cust_code"
					+ index
					+ "' value='' size='10' onBlur='custCodeLookUp(cust_desc"
					+ index
					+ ",this,cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'cust_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custDescLookUp(this,cust_code"
					+ index
					+ ",cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='cust_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='cust_desc_temp"
					+ index
					+ "' value=''><input type='button' name='cust_button"
					+ index
					+ "' class='button' value='?' onclick='custLookUp(cust_desc"
					+ index + ",cust_code" + index + ",cust_grp_code" + index
					+ ",\"" + index
					+ "\");'/><input type='hidden' name='oldKey" + index
					+ "' value=''>";

			cell3.innerHTML = "<input type='text'  name='pkg_valid_days"
					+ index
					+ "' size='4' maxlength='4' onBlur='return chkCustValidDays(this);'  onKeyPress='return(ChkNumberInput(this,event,"
					+ noofdecimal + "))' value=''/>";
			// cell4.innerHTML="<input type='checkbox' name='del_cust"+index+"' id='del_cust"+index+"'
			// onClick='chkDeleteCust(this,\""+index+"\")' value='N'/>";
			cell4.innerHTML = "<a name='select" + index
					+ "' href='#' onClick='showCustPeriod(this,\"" + index
					+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
			// parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value
			// = rowCount;
		}
	} else if (tabId == "CUST_PERIOD") {
		var formObj = parent.cust_period_dtl.document.cust_period_dtl
		var totalRecords = formObj.totalRecords.value;
		var VATapplicable = parent.cust_period_dtl.document.forms[0].VATapplicable.value;
		// rowCount=parseInt(totalRecords)+1
		index = parseInt(totalRecords);
		table = eval("parent.cust_period_dtl.document.getElementById('"
				+ tableID + "')");
		var result = true;
		var glSmryYN = parent.cust_period_dtl.document.forms[0].glSmryYN.value;
		var glSmry = "";
		var glSmryDesc = "";
		var glSmryDisc = "";
		var glSmryDiscDesc = "";
		var disableGLPost = "";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		var VATpercent = "";
		var VATapp = "";
		var defSelect = "";
		var asperpolicy = "";
		var patCoverage = "";
		var payerCoverage = "";
		var VATappchecked="";
		var ruleCoverageInd="";
		var VATruleCoverage="";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		if (index > 0)
			result = validateCustPackageDates(parent.cust_period_dtl.document
					.forms[0], parseInt(totalRecords));

		if (result) {
			row = eval(
					"parent.cust_period_dtl.document.getElementById('"
							+ tableID + "')").insertRow();
			if (index != "0") {
				glSmry = eval("parent.cust_period_dtl.document.forms[0].glSmry"
						+ (parseInt(index) - 1)).value
				glSmryDesc = eval("parent.cust_period_dtl.document.forms[0].glSmryDesc"
						+ (parseInt(index) - 1)).value
				glSmryDisc = eval("parent.cust_period_dtl.document.forms[0].glSmryDisc"
						+ (parseInt(index) - 1)).value
				glSmryDiscDesc = eval("parent.cust_period_dtl.document.forms[0].glSmryDiscDesc"
						+ (parseInt(index) - 1)).value
			} else {
				glSmry = "";
				glSmryDesc = "";
				glSmryDisc = "";
				glSmryDiscDesc = "";
			}
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			if(VATapplicable=="Y"){
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);
			var cell12 = row.insertCell(11);
			}
		//	var cell9 = row.insertCell(8);
			// sarath added function showCustBasePrice(this,'"+index+ "');
			// MMS-QF-SCF-0545 CustomerLevel...
			cell1.innerHTML = "<input type='text' name='fromDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=\"custValidateDate(this,this,toDate_"
					+ index
					+ ",'"
					+ index
					+ "');showCustBasePrice(this,'"
					+ index
					+ "');\" ><img id = 'fromDate_img_"
					+ index
					+ "' name='fromDate_img_"
					+ index
					+ "'	  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar('fromDate_"
					+ index
					+ "');\"   /><img src='../../eCommon/images/mandatory.gif'/><input type='hidden' name='oldPeriodKey"
					+ index + "' value=''>";
			cell2.innerHTML = "<input type='text' name='toDate_"
					+ index
					+ "' id='toDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=custValidateDate(this,fromDate_"
					+ index
					+ ",this,'"
					+ index
					+ "') ><img id = 'toDate_img_"
					+ index
					+ "' name='toDate_img_"
					+ index
					+ "' src='../../eCommon/images/CommonCalendar.gif' onClick=showCalendar('toDate_"
					+ index + "'); >";
			cell3.innerHTML = "<input type='text' name='pkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callCustPriceClass(this,'code','PRICE_CLASS','"
					+ index
					+ "')\"  > <input type='text' name='pkgPriceClsDesc_"
					+ index
					+ "' size='8' maxlength=\"10\"  onBlur=\"callCustPriceClass(this,'desc','PRICE_CLASS','"
					+ index
					+ "')\" ><input type='button' class='button' name='pkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callCustPriceClass('','','PRICE_CLASS','"
					+ index + "')\"  tabindex='0'/>";
			cell4.innerHTML = "<input type='text' name='oPkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callCustPriceClass(this,'code','OUT_PRICE_CLASS','"
					+ index
					+ "')\"  /> <input type='text' name='oPkgPriceClsDesc_"
					+ index
					+ "' size='10' maxlength=\"10\" onBlur=\"callCustPriceClass(this,'desc','OUT_PRICE_CLASS','"
					+ index
					+ "')\" /><input type='button' class='button' name='OPkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callCustPriceClass('','','OUT_PRICE_CLASS','"
					+ index + "')\" tabindex='0'/>";
			if (glSmryYN == "N") {
				disableGLPost = "disabled";
			} else {
				disableGLPost = "";
			}
			cell5.innerHTML = "<input type='text' name='glSmry"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmry
					+ "' "
					+ disableGLPost
					+ " onBlur='custGlSmryCodeLookUp(glSmryDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDesc
					+ "' onBlur='custGlSmryDescLookUp(this,glSmry"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmry_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryLookUp"
					+ index
					+ "' value='?' onClick='custGlSmryLookUp(glSmryDesc"
					+ index + ",glSmry" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			cell6.innerHTML = "<input type='text' name='glSmryDisc"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmryDisc
					+ "' "
					+ disableGLPost
					+ " onBlur='custGlSmryDiscCodeLookUp(glSmryDiscDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDiscDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDiscDesc
					+ "' onBlur='custGlSmryDiscDescLookUp(this,glSmryDisc"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmryDisc_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDiscDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryDiscLookUp"
					+ index
					+ "' value='?' onClick='custGlSmryDiscLookUp(glSmryDiscDesc"
					+ index + ",glSmryDisc" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			// Added by muthu against 31860 on 5/3/2012 Starts here
			cell7.innerHTML = "<input type='checkbox' name='CopyBase' id='CopyBase' value='' onClick =\"CopyBaseChk()\" />";
			cell8.innerHTML = "<input type='checkbox' name='ReplaceBase' id='ReplaceBase' value='' onClick =\"ReplaceBaseChk()\" />";
			if(VATapplicable=="Y")
		{
			cell9.innerHTML = "<input type='checkbox' name='VATapp"
				+ index
				+ "' id='VATapp"
				+index
				+ "' value='"
				+ "'"
				+ " onClick='enableRuleCode_Cust(VATapp"
				+index
				+ ",\""
				+ index
				+ "\")'" 
				+"/>";
			
			cell10.innerHTML = "<input type='text' name='VATpercent"
				+ index
				+ "' id='VATpercent"
				+index
				+ "' size='6' maxlength='6' value='"
				+ "'"
				+ " onBlur='ruleCodeLookup_cust(VATpercent"
				+ index
				+ ",\""
				+ index
				+ "\")' disabled/><input type='button' class='button' name='VATpercent_temp"
				+index
				+"' id='VATpercent_temp"
				+index
				+"'value='?' onClick='ruleCodeLookup_cust(VATpercent"
				+index
				+",\""
				+ index
				+ "\")'disabled/>";
			cell11.innerHTML ="<select  name='ruleCoverageInd" + index
				+ "' disabled >	 <option value='' >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='S'  >"
				+ getLabel('eBL.AS_PER_POLICY.label', 'BL')
				+ "</option><option value='C'>"
				+ getLabel('eBL.PATIENT_COVERAGE.label', 'BL')
				+ "</option><option value='P'>"
				+ getLabel('eBL.PAYER_COVERAGE.label', 'BL')
				+ "</option></select>";
			// Added by muthu against 31860 on 5/3/2012 Starts here
			cell12.innerHTML = "<a name='select" + index
					+ "' href='#' onClick='showCustBasePrice(this,\"" + index
					+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
		}
		else{
			
			
			cell9.innerHTML = "<a name='select" + index
			+ "' href='#' onClick='showCustBasePrice(this,\"" + index
			+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
			
			
			
		}
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;

			/*
			 * cell5.innerHTML="<input type='radio' name='select_0' id='select_0' value=\"N\"
			 * onClick=\"showCustBasePrice(this,'"+index+"')\"/> <input * type='hidden' name='flag_"+index+"' id='flag_"+index+"' value=\"insert\" />";
			 */
		}
		// sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
		document.getElementById("custDefAddBtn").disabled = true;
		parent.cust_period_dtl.document.cust_period_dtl.CUST_NEW_DATE_CHK.value = "Y";
		// sarath added MMS-QF-SCF-0545 CustomerLevel Ending..
	} else if (tabId == "CUST_PRICE") {
		var formObj = parent.cust_base_price_dtl.document.cust_base_price_dtl
		var totalRecords = formObj.totalRecords.value;
		// rowCount=parseInt(totalRecords)+1
		index = parseInt(totalRecords);
		table = eval("parent.cust_base_price_dtl.document.getElementById('"
				+ tableID + "')");
		var result = true;
		if (index > 0)
			result = validateCustPackagePrice(
					"parent.cust_base_price_dtl.document.forms[0]",
					parseInt(totalRecords));
		if (result) {

			row = eval(
					"parent.cust_base_price_dtl.document.getElementById('"
							+ tableID + "')").insertRow();
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			// var cell6=row.insertCell(5);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);// Added by muthu for Factor for
											// service rate issue for KDAH on
											// 21-6-12
			var cell12 = row.insertCell(11);// Added by muthu for Factor for
											// service rate issue for KDAH on
											// 21-6-12

			cell1.innerHTML = "<input type='text' name='blgClsCode_"
					+ index
					+ "' size='3' maxlength=\"2\" onBlur=\"callCustBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",this,'"
					+ index
					+ "','code')\"><input type='text' name='blgClsDesc_"
					+ index
					+ "' size='15' maxlength='30'  onBlur=\"callCustBlgCls(this,document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "','desc')\"><input type='button' class='button' name='blgCls_"
					+ index
					+ "' value='?' onClick=\"callCustBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "')\" tabindex='0' \><img src='../../eCommon/images/mandatory.gif'>";
			cell2.innerHTML = "<select name='indicator_" + index
					+ "'    onChange=\"custIndiValidation(this,'" + index
					+ "')\"	><option value='R' >"
					+ getLabel('Common.Price.label', 'Common')
					+ "</option><option value='F'>"
					+ getLabel('eBL.FACTOR.label', 'BL') + "</option></select>";
			cell3.innerHTML = "<input type='text' name='price_"
					+ index
					+ "' size='13' maxlength='13' onBlur='validateCustBaePrice(this,\""
					+ noofdecimal
					+ "\",\"BL8526\",\""
					+ index
					+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/>";
			cell4.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' disabled size='2' maxlength=\"2\"  onkeypress=\" return (allowValidNumber(this,event));\"  />";
			cell5.innerHTML = "<select name='roundInd_" + index
					+ "' disabled >	<option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			cell6.innerHTML = "<input type='checkbox' name='deposit_" + index
					+ "' value='' onClick =\"checkCustDeposit(this,'" + index
					+ "')\" />";
			cell7.innerHTML = "<input type='checkbox' name='partialDeposit_"
					+ index
					+ "'  value='' disabled onClick =\"checkCustPartialDeposit(this,'"
					+ index + "')\" />";
			cell8.innerHTML = "<select  name='minDepAmtind_" + index
					+ "'	 disabled  onChange='validateInd(this,\"" + index
					+ "\",\"minDepAmt_\")'><option value='' >--"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "--</option><option value='A'  >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option></select>";
			cell9.innerHTML = "<input type='text' name='minDepAmt_"
					+ index
					+ "' value='' size='13' maxlength=\"13\"  disabled  onKeyPress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal
					+ "\")' onBlur='custValidForAmtPerUnltd(document.forms[0].minDepAmtind_"
					+ index + ",this,\"" + index + "\",\"CUST_PRICE\",\""
					+ noofdecimal + "\")'  />";
			cell10.innerHTML = "<input type='checkbox' name='factorAppl_"
					+ index
					+ "' value='N' disabled  /><input type='hidden' name='statToModify_"
					+ index + "' value=''/>";
			// Added by muthu for Factor for service rate issue for KDAH on
			// 21-6-12
			cell11.innerHTML = "<input type='text' name='factorforServiceRate"
					+ index + "' axlength='20' size='10' value=''\" />";
			// Added by muthu for Factor for service rate issue for KDAH on
			// 21-6-12
			cell12.innerHTML = "<input type='button' class='button' name='callReportPkg"
					+ index
					+ "'  value='R' onclick=\"callReportCustBase(this,'"
					+ index + "')\" />";
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	} else if (tabId == "CUST_RATE_BASED") {
		/*
		 * table =
		 * eval("parent.rate_based_dtl.document.getElementById('"+tableID+"')");
		 * rowCount = table.rows.length; index = rowCount-1;
		 */

		var formObj = parent.cust_rate_based_dtl.document.cust_rate_based_dtl;
		var siteSpecf = formObj.siteId.value;
		var dailyLimitSiteSpec = formObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = formObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = formObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = formObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = formObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = formObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = formObj.totalRecords.value;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		var servGrpLmtFldDisabled = formObj.servGrpLmtFldDisabled.value;
		var servGrpLmtBy = formObj.servGrpLmtBy.value;
		var servGrpLimitSiteSpec = formObj.servGrpLimitSiteSpec.value;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		// rowCount=parseInt(totalRecords)+1
		// index = parseInt(rowCount)-1;
		index = parseInt(totalRecords);
		var message = "";
		var obj;
		var order_associated = formObj.order_associated.value;
		if (order_associated == "Y") {
			if (eval("formObj.service_code" + (parseInt(index) - 1)) != null
					&& eval("formObj.service_code" + (parseInt(index) - 1)).value != "") {
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8562", 'BL');
					obj = eval("formObj.catalog_desc" + (parseInt(index) - 1));
				}
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value != ""
						&& eval("formObj.qty_limit" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8538", 'BL');
					obj = eval("formObj.qty_limit" + (parseInt(index) - 1));
				}
				// messageFrame.location.href =
				// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if (message != "") {
					alert(message);
					obj.focus();
					return false
				}
			}
		}

		// row=eval("parent.rate_based_dtl.document.getElementById('"+tableID+"')").insertRow(rowCount);
		row = eval(
				"parent.cust_rate_based_dtl.document.getElementById('"
						+ tableID + "')").insertRow();
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14);
		var cell16 = row.insertCell(15);
		var cell17 = row.insertCell(16);
		var cell18 = row.insertCell(17);
		var cell19 = row.insertCell(18);
		var cell20 = row.insertCell(19); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell21 = row.insertCell(20); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell22 = row.insertCell(21); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var cell23 = row.insertCell(22); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 

		var typeHTML = "";
		var indHTML = "";
		var ordCatDisabled = "disabled";
		noofdecimal = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.noofdecimal.value
		if (order_associated == "Y") {
			ordCatDisabled = "";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onCustServiceTypeChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onCustIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value=''U'>"
					+ getLabel('Common.UserDefined.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		} else {
			ordCatDisabled = "disabled";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onCustServiceTypeChange(this,\"" + index
					+ "\")'><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onCustIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;

		cell2.innerHTML = "<input  type='hidden' name='service_code"
				+ index
				+ "' value=''><input type='text'  name='service_desc"
				+ index
				+ "' size='10' maxlength='10' onBlur='before_custServiceLookUp(this,service_code"
				+ index
				+ ",type"
				+ index
				+ ",\""
				+ index
				+ "\")' value=''><INPUT type='hidden' name='service_desc_temp"
				+ index
				+ "' value=''><input type='button' name='service_button"
				+ index
				+ "' class='button' value='?' onClick='custServiceLookUp(document.forms[0].service_desc"
				+ index + ",service_code" + index + ",type" + index + ",\""
				+ index + "\")'/><input type='hidden' name='oldSrvKey" + index
				+ "' value=''>";

		cell3.innerHTML = "<input  type='hidden' name='catalog_code"
				+ index
				+ "' value=''><input type='text' name = 'catalog_desc"
				+ index
				+ "'  "
				+ ordCatDisabled
				+ " size='10' maxlength='10' onBlur='before_custCatalogLookUp(this,catalog_code"
				+ index
				+ ",service_code"
				+ index
				+ ",\""
				+ index
				+ "\")' value=''><INPUT type='hidden' name='catalog_desc_temp"
				+ index
				+ "' value=''><input type=button name='catalog_button"
				+ index
				+ "'  "
				+ ordCatDisabled
				+ " class=button  value=? onClick='custCatalogLookUp(catalog_desc"
				+ index + ",catalog_code" + index + ",service_code" + index
				+ ",\"" + index + "\")'/>";

		cell4.innerHTML = indHTML;

		cell5.innerHTML = "<input type='text' name='factorOrRate"
				+ index
				+ "' size='12' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
				+ noofdecimal
				+ "\",\"BL8665\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\")';/>";

		cell6.innerHTML = "<input type='text' name='qty_limit" + index
				+ "' disabled size='8' onBlur='chkCustQtyLimit(this,\"" + index
				+ "\");' onkeypress='return allowValidNumber(this,event,\""
				+ noofdecimal + "\")'/>";
		cell7.innerHTML = "<select  name='amt_limit_ind" + index
				+ "' onChange='validateCustInd(this,\"" + index
				+ "\");changeSplitReqd(this,\"amt_limit\",\"" + index
				+ "\",\""+dailyLimitSiteSpec+"\",dailyLmtIndicator"+ index + ")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option><option value='U' >"
				+ getLabel('eBL.UNLIMITED.label', 'BL') + "</option></select>";
		cell8.innerHTML = "<input type='text' name='perAmt_limit"
				+ index
				+ "' size='8' maxlength='13'  onBlur='custValidForAmtPerUnltd(document.forms[0].amt_limit_ind"
				+ index
				+ ",this,\""
				+ index
				+ "\",\"\",\""
				+ noofdecimal
				+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\")'; />";

		cell9.innerHTML = "<input type='text' name='roundTo"
				+ index
				+ "' size='6' maxlength=\"3\"  \  onkeypress=\" return allowValidNumber(this,event,'"
				+ noofdecimal + "');\" value=''  />";
		cell10.innerHTML = "<select name='roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		// cell9.innerHTML="<input type='checkbox' disabled
		// name='unlimited"+index+"' id='unlimited"+index+"'
		// onClick='chkCustUnlimited(this,\""+index+"\")' value='N'/>";
		//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		var optionTxt1 = "";
		if (servGrpLmtBy != "*") {				
			if (servGrpLmtBy == "B" ) {				
				optionTxt1 += "<option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option><option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option></select>";
			} else if (servGrpLmtBy == "G" ) {
				optionTxt1 +="</option><option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option>";
			} else if (servGrpLmtBy == "S" ) {
				optionTxt1 +="<option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option>";
			}
		}			
		if (servGrpLimitSiteSpec == "true" && order_associated=="N") {
			servGrpLmtFldDisabled = " enabled ";
		}
		cell11.innerHTML = "<select name='serv_grp_limit_ind" + index
		+ "' id='serv_grp_limit_ind" + index
		+ "' "+servGrpLmtFldDisabled
		+">"
		+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt1+"</select>";		
    //Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		
		if(siteSpecf == 'true'){
			cell12.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='N' disabled onclick='checkInclHomeMedi(this);'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
		}
		else{
			cell12.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/if-else */
		if(dailyLimitSiteSpec == "true") {
			/*cell12.innerHTML = "<input type='checkbox' name='dailyLmtChkBx" + index
			+ "' id='dailyLmtChkBx" + index
			+ "' onclick = 'dailyLmtChkBxClick(this,"+ index +",document.cust_rate_based_dtl)' value='N' disabled />";*/
			var optionTxt = "";
			if("G" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			
			var ordCatDisabled1 = "";
			if(order_associated == "Y") {
				ordCatDisabled1 = " disabled ";
			}
			
			cell13.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.cust_rate_based_dtl)' "+ordCatDisabled1+" >"
			+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell13.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell14.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
			cell14.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			/*cell13.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";*/
			cell15.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
			/*cell13.innerHTML += "<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";*/
		} else {
			cell13.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell13.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell14.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell14.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell15.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		cell16.innerHTML = "<input type='checkbox' disabled name='replace"
				+ index + "' onClick='chkCustReplace(this,\"" + index
				+ "\")' value='N' />";
		cell17.innerHTML = "<input type='checkbox'  disabled name='refund"
				+ index + "' onClick='chkCustRefund(this,\"" + index
				+ "\")' value='N' />";
		cell18.innerHTML = "<input type='checkbox'  disabled  name='autoRefund"
				+ index + "' onClick='chkCustAutoRefund(this,\"refundAmt"
				+ index + "\")' value=\"N\"/>";
		cell19.innerHTML = "<input type='checkbox'  disabled name='factor_appl"
				+ index + "' onClick='custFactorAppl(this,\"" + index
				+ "\")' value='N'/>";
		cell20.innerHTML = "<input type='radio' name='closePkg' id='closePkg' onClick=\"custAssignClosePkgVal(this,'"
				+ index
				+ "')\"/ disabled><input type='hidden' name='closePkg"
				+ index + "' value=\"N\" disabled />";
		// cell16.innerHTML="<input type='checkbox' disabled
		// name='service_limit"+index+"' id='service_limit"+index+"'
		// onClick='chkCustServiceLimit(this,\""+index+"\")' value='N'/>";
		cell21.innerHTML = "<a id='service_limit_dtls" + index
				+ "' href='#' onClick='custServiceLimitDtls(\"" + index
				+ "\")' disabled>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
		cell22.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell23.innerHTML = "<input type='checkbox'  name='deleteService"
				+ index + "' onClick='chkCustDeleteService(this,\"" + index
				+ "\")' value='N'/>";
		formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		// added for common validation
		// parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value
		// = rowCount;
	} else if (tabId == "CUST_SRVLIMIT_RATE_BASED") {
		/*
		 * table =
		 * eval("parent.frames[2].document.getElementById('"+tableID+"')");
		 * rowCount = table.rows.length; index = rowCount-1;
		 */
		// frame ref changed parent.frames[2] to parent.frames[4] by ram
		var srvLimitFormObj = parent.frames[4].document.cust_srvLimit_rate_based_dtl;
		var siteSpecf = srvLimitFormObj.siteId.value; 
		var dailyLimitSiteSpec = srvLimitFormObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = srvLimitFormObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = srvLimitFormObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = srvLimitFormObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = srvLimitFormObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = srvLimitFormObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var parDailyLmtInd = srvLimitFormObj.parDailyLmtInd.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = srvLimitFormObj.totalRecords.value;
		// rowCount=parseInt(totalRecords)+1
		// index = parseInt(rowCount)-1;
		index = parseInt(totalRecords);
		var message = "";
		var prevIndex = parseInt(index) - 1;
		var obj;
		if (eval("srvLimitFormObj.srvLimit_service_code" + prevIndex).value != ""
				&& (eval("srvLimitFormObj.exludeService" + prevIndex).value == "N" || eval("srvLimitFormObj.exludeService"
						+ prevIndex).value == "")) {
			/*
			 * if(eval("srvLimitFormObj.srvLimit_type"+prevIndex).value=="C" &&
			 * eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex).value==""){
			 * message=getMessage("BL8561",'BL');
			 * obj=eval("srvLimitFormObj.srvLimit_amt_limit"+prevIndex); }else
			 * if(eval("srvLimitFormObj.srvLimit_type"+prevIndex).value=="S" &&)
			 */

			if (eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex).value == ""
					&& eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).value == "") {
				message = getMessage("BL8555", 'BL');
				if (eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).disabled)
					obj = eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex);
				else
					obj = eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex);
			}
			if (message != "") {
				// messageFrame.location.href =
				// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				alert(message);
				obj.focus();
				return false
			}
		}

		// row=eval("parent.frames[2].document.getElementById('"+tableID+"')").insertRow(rowCount);
		// row=eval("parent.frames[2].document.getElementById('"+tableID+"')").insertRow();
		// commented and added new line by ram
		row = eval(
				"parent.frames[4].document.getElementById('" + tableID + "')")
				.insertRow();

		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14);
		var cell16 = row.insertCell(15); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell17 = row.insertCell(16); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell18 = row.insertCell(17); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var typeHTML = "";
		var parent_type = srvLimitFormObj.parent_type.value;
		noofdecimal = srvLimitFormObj.noofdecimal.value
		if (parent_type == "G") {
			typeHTML = "<select  NAME='srvLimit_type" + index
					+ "' onChange='onCustSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else if (parent_type == "P") {
			typeHTML = "<select NAME='srvLimit_type" + index
					+ "' onChange='onCustSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='T'>"
					+ getLabel('eBL.SalesCategory.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else {
			typeHTML = "<select  NAME='srvLimit_type" + index
					+ "' onChange='onCustSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;
		cell2.innerHTML = "<input  type='text' name='srvLimit_service_code"
				+ index
				+ "' value='' size='10' onBlur='custSrvLimitCodeLookUp(srvLimit_service_desc"
				+ index
				+ ",this,srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\");'><input type='text' name = 'srvLimit_service_desc"
				+ index
				+ "' size='10' maxlength='10' onBlur='before_custSrvLimitServiceLookUp(this,srvLimit_service_code"
				+ index
				+ ",srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\");' value=''><INPUT type='hidden' name='srvLimit_service_code_temp"
				+ index
				+ "' value=''><INPUT type='hidden' name='srvLimit_service_desc_temp"
				+ index
				+ "' value=''><input type='button' name='srvLimit_service_button"
				+ index
				+ "' class='button' value='?' onclick='custSrvLimitServiceLookUp(srvLimit_service_desc"
				+ index + ",srvLimit_service_code" + index + ",srvLimit_type"
				+ index + ",\"" + index + "\");' />";
		cell3.innerHTML = "<input type='checkbox' name='exludeService" + index
				+ "' onClick='chkCustExludeService(this,\"" + index
				+ "\");changeSplitReqd(this,\"exclude\",\"" + index
				+ "\");IncludeHomeMedicationcustExclude(this,srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");' value='N' />";
		cell4.innerHTML = "<input type='text' name='srvLimit_qty_limit"
				+ index
				+ "' disabled size='5' onBlur='chkCustSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber(this,event,\""
				+ noofdecimal + "\");'  value='' />";
		cell5.innerHTML = "<select  name='srvLimit_amt_limit_ind" + index
				+ "' onChange='validateCustInd(this,\"" + index
				+ "\")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option></select>";
		cell6.innerHTML = "<input type='text' name='srvLimit_amt_limit"
				+ index
				+ "'  disabled size='5' maxlength='13'  onBlur='chkCustSrvLimitAmtLimit(this,\""
				+ index
				+ "\",\""
				+ noofdecimal
				+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\");'  value='' />";
		cell7.innerHTML = "<input type='text' name='srvLimit_roundTo"
				+ index
				+ "' size='3' maxlength=\"3\"  \  onkeypress=\" return (allowValidNumber(this,event));\"  value='' />";
		cell8.innerHTML = "<select name='srvLimit_roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		
		if(siteSpecf == 'true'){
			cell9.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='N' disabled onclick='checkInclHomeMedi(this);IncludeHomeMedicationUnchkExclude(this,\"custrateexclude\",\""+ index + "\");'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
		}
		else{
			cell9.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/if-else */
		if(dailyLimitSiteSpec == "true") {
			/*cell10.innerHTML = "<input type='checkbox' name='dailyLmtChkBx" + index
			+ "' id='dailyLmtChkBx" + index
			+ "' onclick = 'dailyLmtChkBxClick(this,"+ index +",document.cust_srvLimit_rate_based_dtl)' value='N' disabled />";*/
			var optionTxt = "";
			if("G" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			cell10.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.cust_srvLimit_rate_based_dtl)'>"
			+"<option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell11.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+" readOnly />";
			cell11.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			/*cell11.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";*/
			cell12.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+" readOnly />";
			/*cell11.innerHTML += "<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";*/
		} else {
			cell10.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell11.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell11.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell12.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		cell13.innerHTML = "<input type='checkbox' name='srvLimit_replace"
				+ index
				+ "' onClick='custSrvLimitChkReplace(this,\""
				+ index
				+ "\")' value=\"N\"/><input type=\"hidden\" name=\"srvLimit_replaceSrv_code"
				+ index
				+ "\" id=\"srvLimit_replaceSrv_code"
				+ index
				+ "\" ><input type=\"hidden\" name=\"srvLimit_replaceSrv_desc"
				+ index + "\" id=\"srvLimit_replaceSrv_desc"
				+ index + "\" />";
		cell14.innerHTML = "<input type='checkbox' name='srvLimit_refund"
				+ index + "' id='srvLimit_refund"
				+ index + "' onClick='custSrvLimitChkRefund(this,\"" + index
				+ "\")' value=\"N\"/>";
		cell15.innerHTML = "<input type='checkbox'  disabled  name='srvLimit_autoRefund"
				+ index
				+ "' id='srvLimit_autoRefund"
				+ index
				+ "' onClick='chkCustAutoRefund(this,\"srvLimit_refundAmt"
				+ index + "\")' value=\"N\"/>";
		cell16.innerHTML = "<input type='checkbox'  disabled name='srvLimit_factor_appl"
				+ index
				+ "' id='srvLimit_factor_appl"
				+ index
				+ "' onClick='custSrvLimitFactorAppl(this,\""
				+ index
				+ "\")' value='N'/>";
		cell17.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell18.innerHTML = "<input type='checkbox'  name='srvLimit_deleteService"
				+ index
				+ "' onClick='chkCustSrvLimitDeleteService(this,\""
				+ index + "\")' value='N'/>";
		srvLimitFormObj.totalRecords.value = parseInt(srvLimitFormObj.totalRecords.value) + 1;
		// added for common validation
		// parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value
		// = rowCount;
	} else if (tabId == "CUST_CHARGE_BASED") {
		var formObj = parent.cust_charge_based_dtl.document.cust_charge_based_dtl;
		var totalRecords = formObj.totalRecords.value;
		var siteSpecf = formObj.siteId.value; 
		// rowCount=parseInt(totalRecords)+2
		index = parseInt(totalRecords);
		var noofdecimal = formObj.noofdecimal.value
		table = eval("parent.cust_charge_based_dtl.document.getElementById('"
				+ tableID + "')");

		result = true;
		if (index > 0) {
			result = validateCustChargeBased(
					parent.cust_charge_based_dtl.document.forms[0],
					parseInt(totalRecords))
		}
		if (result) {
			// index = rowCount-1;
			// var i =1;
			row = eval(
					"parent.cust_charge_based_dtl.document.getElementById('"
							+ tableID + "')").insertRow();

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);// MuthuN against 28192
			var cell12 = row.insertCell(11);// Split reqd
				var cell13=row.insertCell(12);//Split reqd
			typeHTML = "<select NAME='charge_type"
					+ index
					+ "' onChange='onSrvLimitServiceTypeChange_custcharge(this,\""
					+ index + "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'BL')
					+ "</option></select>";// MuthuN against 28192
			cell1.innerHTML = typeHTML;// MuthuN against 28192
			cell2.innerHTML = "<input type='text' name = 'cbCode_"
					+ index
					+ "' id = 'cbCode_"
					+ index
					+ "' size='10' maxlength='10' onBlur='custCallLookup(this,this,document.forms[0].cbDesc_"
					+ index
					+ ",\"CUST_CHARGE_BASED\",\""
					+ index
					+ "\");' /><input type='hidden' name = 'cbCodePrev_"
					+ index
					+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
					+ index
					+ "' value ='' /><input type='text' name='cbDesc_"
					+ index
					+ "' id='cbDesc_"
					+ index
					+ "' size='10' maxlength='100'  value=''   onBlur='custCallLookup(this,document.forms[0].cbCode_"
					+ index
					+ ",this,\"CUST_CHARGE_BASED\",\""
					+ index
					+ "\");' /><input type='button' class='button' name='serviceLookUp_"
					+ index
					+ "' value='?' onClick=custCallServices(document.forms[0].cbCode_"
					+ index + ",document.forms[0].cbDesc_" + index
					+ ",'CUST_CHARGE_BASED',charge_type" + index + ",\""
					+ index + "\") /><input type='hidden' name='oldSrvKey"
					+ index + "' value=''>";
			cell3.innerHTML = "<select  name='amt_limit_ind" + index
					+ "' onChange='validateCustInd(this,\"" + index
					+ "\");changeSplitReqd(this,\"amt_limit\",\"" + index
					+ "\")'><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='P' >"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='U' >"
					+ getLabel('eBL.UNLIMITED.label', 'BL')
					+ "</option></select>";
			cell4.innerHTML = "<input type='text' name='perAmt_limit"
					+ index
					+ "' size='5' maxlength='13'  onBlur='custValidForAmtPerUnltd(amt_limit_ind"
					+ index
					+ ",this,\""
					+ index
					+ "\",\"CUST_CHARGE_BASED\",\""
					+ noofdecimal
					+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")'; />";
			cell5.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' size='3' maxlength=\"3\"  \  onkeypress=\" return (allowValidNumber(this,event));\"  value='' />";
			cell6.innerHTML = "<select name='roundInd_" + index
					+ "' ><option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			
			if(siteSpecf == 'true'){
				cell7.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this);'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
			}
			else{
				cell7.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			
			cell8.innerHTML = "<input type='checkbox'   name='refund_" + index
					+ "' onClick='chkCustRefundCB(this,\"" + index
					+ "\")' value='N' />";
			cell9.innerHTML = "<input type='checkbox' size ='10'   name='autoRefund_"
					+ index
					+ "' onClick='chkCustAutoRefund(this,\"refundAmt_"
					+ index + "\")' value=\"N\"/>";
			cell10.innerHTML = "<input type='checkbox' name='factor_appl"
					+ index + "' onClick='custFactorAppl(this,\"" + index
					+ "\")' DISABLED value=\"N\"/>";

			// Newly Added by Muthu against 28192 on 8/24/2012
			cell11.innerHTML = "<input type='checkbox' name='srvLmt_"
					+ index
					+ "' value=\"N\"   onclick=\"showLmtDetails(this,'"
					+ index
					+ "')\"/><a style =\"display:none\" id='srvLmtDtls_"
					+ index
					+ "' href='javascript:loadCustChargeBasedServiceLimit(document.forms[0].cbCode_"
					+ index + ".value,\"" + index + "\")'>"
					+ getLabel('eBL.Dtls.label', 'BL') + "</a>";
			// Newly Added by Muthu against 28192 on 8/24/2012
			cell12.innerHTML = "<input type='checkbox' name='split_reqd"
					+ index + "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			cell13.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkCustDeleteService(this,'"
					+ index + "')\"/>";
			/*
			 * cell1.innerHTML="<input type='text' name = 'cbCode_"+index+"' id =
			 * 'cbCode_"+index+"' size='10' maxlength='10'
			 * onBlur='custCallLookup(this,this,document.forms[0].cbDesc_"+index+",\"CUST_CHARGE_BASED\",\""+index+"\");' /><input
			 * type='hidden' name = 'cbCodePrev_"+index+"' value ='' /><input
			 * type='hidden' name = 'cbDescPrev_"+index+"' value ='' /><input * type='text' name='cbDesc_"+index+"' id='cbDesc_"+index+"' id='cbDesc_"+index+"'
			 * size='30' maxlength='100' value=''
			 * onBlur='custCallLookup(this,document.forms[0].cbCode_"+index+",this,\"CUST_CHARGE_BASED\",\""+index+"\");' /><input * type='button' class='button' name='serviceLookUp_"+index+"' id='serviceLookUp_"+index+"'
			 * value='?'
			 * onClick=custCallServices(document.forms[0].cbCode_"+index+",document.forms[0].cbDesc_"+index+",'CUST_CHARGE_BASED',\""+index+"\") /><input * type='hidden' name='oldSrvKey"+index+"' id='oldSrvKey"+index+"' value=''>";
			 * cell2.innerHTML="<select name='amt_limit_ind"+index+"' id='amt_limit_ind"+index+"'
			 * onChange='validateCustInd(this,\""+index+"\")'><option value='A'
			 * >"+getLabel('Common.amount.label','Common')+"</option><option
			 * value='P' >"+getLabel('Common.Percent.label','Common')+"</option><option
			 * value='U' >"+getLabel('eBL.UNLIMITED.label','BL')+"</option></select>";
			 * cell3.innerHTML="<input type='text' name='perAmt_limit"+index+"' id='perAmt_limit"+index+"'
			 * size='5' maxlength='13'
			 * onBlur='custValidForAmtPerUnltd(amt_limit_ind"+index+",this,\""+index+"\",\"CUST_CHARGE_BASED\",\""+noofdecimal+"\")'
			 * onkeypress='return
			 * allowValidNumber(this,event,\"10\",\""+noofdecimal+"\")'; />";
			 * cell4.innerHTML="<input type='text' name='roundTo_"+index+"' id='roundTo_"+index+"'
			 * size='3' maxlength=\"3\" \ onkeypress=\" return
			 * (allowValidNumber(this,event));\" value='' />"; cell5.innerHTML="<select * name='roundInd_"+index+"' id='roundInd_"+index+"' ><option value='U'
			 * >"+getLabel('Common.Up.label','Common')+"</option><option
			 * value='D' >"+getLabel('eBL.DOWN.label','BL')+"</option></select>";
			 * cell6.innerHTML="<input type='checkbox' name='refund_"+index+"' id='refund_"+index+"'
			 * onClick='chkCustRefundCB(this,\""+index+"\")' value='N' />";
			 * cell7.innerHTML="<input type='checkbox'
			 * name='autoRefund_"+index+"' id='autoRefund_"+index+"'
			 * onClick='chkCustAutoRefund(this,\"refundAmt_"+index+"\")'
			 * value=\"N\"/>"; cell8.innerHTML="<input type='checkbox'
			 * name='factor_appl"+index+"' id='factor_appl"+index+"'
			 * onClick='custFactorAppl(this,\""+index+"\")' DISABLED
			 * value=\"N\"/>"; cell9.innerHTML="<a id='srvLmtDtls_"+index+"'
			 * href='#'
			 * onClick='loadCustChargeBasedServiceLimit(document.forms[0].cbCode_"+index+".value,\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL'
			 * )+"</a>"; cell10.innerHTML="<input type='checkbox'
			 * name='delCode_"+index+"' id='delCode_"+index+"' value=''
			 * onclick=\"chkCustDeleteService(this,'"+index+"')\"/>";
			 */
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
			// parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value
			// = rowCount;
		}
	} else if (tabId == "CUST_CHARGE_BASED_ITEM") {
		var formObj = parent.frames[4].document.cust_charge_based_excl_dtl; // frames
																			// refframes[2]
																			// changed
																			// frames[4]
																			// by
																			// ram
		var totalRecords = formObj.totalRecords.value;
		index = parseInt(totalRecords);
		var noofdecimal = formObj.noofdecimal.value
		var siteSpecf = formObj.siteId.value; 
		table = eval("parent.cust_charge_based_excl.document.getElementById('"
				+ tableID + "')");
		// rowCount = table.rows.length;
		var result = true;
		if (index > 0) {
			result = validateCustChargeBasedItems(
					parent.cust_charge_based_excl.document.forms[0],
					parseInt(totalRecords))
		}
		if (result) {
			row = eval(
					"parent.cust_charge_based_excl.document.getElementById('"
							+ tableID + "')").insertRow();

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
				var cell7 = row.insertCell(6);
			
			cell1.innerHTML = "<input type='hidden' name = 'charge_type"
				+ index
				+ "' id ='charge_type"+ index + "' value = 'M' /><input type='text' name = 'cbCode_"
					+ index
					+ "' id = 'cbCode_"
					+ index
					+ "' size='10' maxlength='10' onBlur='custCallLookup(this,this,document.forms[0].cbDesc_"
					+ index
					+ ",\"CUST_CHARGE_BASED_ITEM\",\""
					+ index
					+ "\");' /><input type='hidden' name = 'cbCodePrev_"
					+ index
					+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
					+ index
					+ "' value ='' /><input type='text' name='cbDesc_"
					+ index
					+ "' id='cbDesc_"
					+ index
					+ "' size='30' maxlength='100'  value=''   onBlur='custCallLookup(this,document.forms[0].cbCode_"
					+ index
					+ ",this,\"CUST_CHARGE_BASED_ITEM\",\""
					+ index
					+ "\");' /><input type='button' class='button' name='serviceLookUp_"
					+ index
					+ "' value='?' onClick=custCallServices(document.forms[0].cbCode_"
					+ index + ",document.forms[0].cbDesc_" + index
					+ ",'CUST_CHARGE_BASED_ITEM',charge_type" + index + ",\"" + index + "\") />";
			cell2.innerHTML = "<input type='checkbox' name='inEx_" + index
					+ "' value='N'  onclick='custExcludeItem(this,\"" + index
					+ "\");changeSplitReqd(this,\"exclude\",\"" + index
					+ "\");IncludeHomeMedicationcustExclude(this,cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");'/>";
			cell3.innerHTML = "<input type='text' name='quantityLimit_"
					+ index
					+ "' size='15' maxlength='15'  value='' onkeypress=' return allowValidNumber(this,event,\""
					+ noofdecimal + "\");'/>";
			cell4.innerHTML = "<input type='text' name='amountLimit_"
					+ index
					+ "' size='13' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
					+ noofdecimal
					+ "\",\"BL8540\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/>";
			// cell5.innerHTML="<input type='checkbox'
			// name='factorAppl_"+index+"' id='factorAppl_"+index+"'
			// onClick='factorAppl(this,\""+index+"\")' value=\"N\"/>";
			cell5.innerHTML = "<input type='checkbox' name='split_reqd" + index
					+ "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			
			
			
			
			
			if(siteSpecf == 'true'){
				cell6.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this);IncludeHomeMedicationUnchkExclude(this,\"custchargeexclude\",\""+ index + "\");'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
			}
			else{
				cell6.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			cell7.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkCustDeleteService(this,'"
					+ index + "')\"/>";
			// parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value
			// = rowCount;
			// parent.ChargeBasedExCln.document.forms[0].totalRecords.value =
			// rowCount;
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	} else if (tabId == "blng_grp_discount") {
		var formObj = parent.blng_grp_discount_dtl.document.blng_grp_discount_dtl;
		var SiteAgeSpecialty=formObj.SiteAgeSpecialty.value;
		var totalRecords = formObj.totalRecords.value;
		var noofdecimal = formObj.noofdecimal.value;
		rowCount = parseInt(totalRecords) + 1
		index = parseInt(totalRecords);
		var result = true;
		result = validateDiscountForm(formObj);
		if (result) {
			row = eval(
					"parent.blng_grp_discount_dtl.document.getElementById('"
							+ tableID + "')").insertRow();
			//GHL-CRF-0502 Starts
			var cell1 = row.insertCell();
			var cell2 = row.insertCell();
			if(SiteAgeSpecialty=='true'){
				var cell3 = row.insertCell();
				var cell4 = row.insertCell();
				var cell5 = row.insertCell();
				var cell6 = row.insertCell();
				var cell7 = row.insertCell();			
				var cell8 = row.insertCell();
				var cell9 = row.insertCell();
			}else{
				var cell3 = row.insertCell();
				var cell4 = row.insertCell();
				var cell5 = row.insertCell();			
				var cell6 = row.insertCell();
				var cell7 = row.insertCell();
			}
			//GHL-CRF-0502 Ends

			cell1.innerHTML = "<input  type='text' name='blng_grp_code"
					+ index
					+ "' value='' size='10' onBlur='blngGrpCodeLookUp(blng_grp_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\");'><input type='text' name = 'blng_grp_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='blngGrpDescLookUp(this,blng_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='blng_grp_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_grp_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_grp_button"
					+ index
					+ "' class='button' value='?' onclick='blngGrpLookUp(blng_grp_desc"
					+ index + ",blng_grp_code" + index + ",\"" + index
					+ "\")'><input type='hidden' name='oldKey" + index
					+ "' value=''>"
			cell2.innerHTML = "<input  type='text' name='blng_class_code"
					+ index
					+ "' value='' size='10' onBlur='blngClassCodeLookUp(blng_class_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'><input type='text' name = 'blng_class_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='blngClassDescLookUp(this,blng_class_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='blng_class_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_class_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_class_button"
					+ index
					+ "' class='button' value='?' onclick='blngClassLookUp(blng_class_desc"
					+ index + ",blng_class_code" + index + ",\"" + index
					+ "\")'>";			

			//GHL-CRF-0502 Starts
			if(SiteAgeSpecialty=='true'){
			cell3.innerHTML = "<input  type='text' name='age_group_code"
					+ index
					+ "' value='' size='10' onBlur='AgeGrpBLCodeLookUp(hdn_age_group"
					+ index
					+ ",this,"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'hdn_age_group"
					+ index
					+ "' size='10' maxlength='10' onBlur='AgeGrpBLDescLookUp(this,age_group_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='age_group_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='hdn_age_group_temp"
					+ index
					+ "' value=''><input type='button' name='age_button"
					+ index
					+ "' class='button' value='?' onclick='AgeGrpBLLookUp(hdn_age_group"
					+ index + ",age_group_code"
					+ index
					+ ",\"" + index + "\");'/>";			

			cell4.innerHTML = "<input  type='text' name='specialty_code"
					+ index
					+ "' value='' size='10' onBlur='specialtyCodeBLLookUp(specialty_desc"
					+ index
					+ ",this,"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'specialty_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='specialtyDescBLLookUp(this,specialty_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='specialty_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='specialty_desc_temp"
					+ index
					+ "' value=''><input type='button' name='specialty_button"
					+ index
					+ "' class='button' value='?' onclick='specialtyBLLookUp(specialty_desc"
					+ index + ",specialty_code"
					+ index
					+ ",\"" + index + "\");'/>";
			cell5.innerHTML = "<input type='text' name='eff_from_date"
					+ index
					+ "' id='eff_from_date"
					+ index
					+ "' size='10' maxlength='10'  value='' onBlur='validateDiscountDate(this,this,eff_to_date"
					+ index
					+ ",\""
					+ index
					+ "\");'><img id = 'eff_from_date_img_"
					+ index
					+ "' name='eff_from_date_img_"
					+ index
					+ "'	  src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_from_date"
					+ index + "\");'  />";
			cell6.innerHTML = "<input type='text' name='eff_to_date"
					+ index
					+ "'  id='eff_to_date"
					+ index
					+ "' size='10' maxlength='10'  value=''  onBlur='validateDiscountDate(this,eff_from_date"
					+ index
					+ ",this,\""
					+ index
					+ "\");' ><img id = 'eff_to_Date_img_"
					+ index
					+ "' name='eff_to_Date_img_"
					+ index
					+ "'	src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_to_date"
					+ index + "\");' >";
			cell7.innerHTML = "<select name='discount_type" + index
					+ "' onChange='chkDisountType(this,\"" + index
					+ "\")' ><option value='R' selected>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option></select>";
			cell8.innerHTML = "<input type='text' name='discount" + index
					+ "'   size='5' onBlur='chkDiscountAmt(this,\"" + index
					+ "\");' onkeypress='return ChkNumberInput(this,event,\""
					+ noofdecimal + "\") ;' value=''/>";
			cell9.innerHTML = "<input type='checkbox'  name='deleteDiscount"
					+ index + "' onClick='chkDeleteDiscount(this,\"" + index
					+ "\")' value='N'/>";
			}else{
			cell3.innerHTML = "<input type='text' name='eff_from_date"
					+ index
					+ "' id='eff_from_date"
					+ index
					+ "' size='10' maxlength='10'  value='' onBlur='validateDiscountDate(this,this,eff_to_date"
					+ index
					+ ",\""
					+ index
					+ "\");'><img id = 'eff_from_date_img_"
					+ index
					+ "' name='eff_from_date_img_"
					+ index
					+ "'	  src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_from_date"
					+ index + "\");'  />";
			cell4.innerHTML = "<input type='text' name='eff_to_date"
					+ index
					+ "'  id='eff_to_date"
					+ index
					+ "' size='10' maxlength='10'  value=''  onBlur='validateDiscountDate(this,eff_from_date"
					+ index
					+ ",this,\""
					+ index
					+ "\");' ><img id = 'eff_to_Date_img_"
					+ index
					+ "' name='eff_to_Date_img_"
					+ index
					+ "'	src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_to_date"
					+ index + "\");' >";
			cell5.innerHTML = "<select name='discount_type" + index
					+ "' onChange='chkDisountType(this,\"" + index
					+ "\")' ><option value='R' selected>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option></select>";
			cell6.innerHTML = "<input type='text' name='discount" + index
					+ "'   size='5' onBlur='chkDiscountAmt(this,\"" + index
					+ "\");' onkeypress='return ChkNumberInput(this,event,\""
					+ noofdecimal + "\") ;' value=''/>";
			cell7.innerHTML = "<input type='checkbox'  name='deleteDiscount"
					+ index + "' onClick='chkDeleteDiscount(this,\"" + index
					+ "\")' value='N'/>";
			}
			//GHL-CRF-0502 Ends
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	}
	else if (tabId == "cust_discount") {
		
		var formObj = parent.cust_discount_dtl.document.cust_discount_dtl;
		var SiteAgeSpecialty=formObj.SiteAgeSpecialty.value;
		var siteAutoApplyPkgDiscYN=formObj.siteAutoApplyPkgDiscYN.value;
		
    //MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020
		var PkgByPolicy=formObj.PkgByPolicy.value;
		var newPkg=formObj.newPkg.value;
    //MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
		var totalRecords = formObj.totalRecords.value;
		var noofdecimal = formObj.noofdecimal.value;
		rowCount = parseInt(totalRecords) + 1
		// index = parseInt(rowCount)-1;
		index = parseInt(totalRecords);
		var result = true;
		result = validateDiscountForm(formObj);
	
		if (result) {
			// row=eval("parent.customers_dtl.document.getElementById('"+tableID+"')").insertRow(rowCount);
			row = eval(
					"parent.cust_discount_dtl.document.getElementById('"
							+ tableID + "')").insertRow();
			
			//GHL-CRF-0502 Starts
			var cell1 = row.insertCell();
			var cell2 = row.insertCell();
			//var cell3 = row.insertCell();// COMMENTED FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
			//ADDED FOR MMS-QH-CRF-128.1-US2 PALANI NARAYANAN STARTS
if(SiteAgeSpecialty=='true'){
				
    				var cell3 = row.insertCell();
    				var cell4 = row.insertCell();
    				var cell5 = row.insertCell();
    				var cell6 = row.insertCell();
    				var cell7 = row.insertCell();
    				var cell8 = row.insertCell();
    				var cell9 = row.insertCell();
    				var cell10 = row.insertCell();
    				//var cell11 = row.insertCell();
					}
					else if(siteAutoApplyPkgDiscYN=='true'&& PkgByPolicy=='Y'){
					var cell3 = row.insertCell();
    				var cell4 = row.insertCell();
    				var cell5 = row.insertCell();
    				var cell6 = row.insertCell();
    				var cell7 = row.insertCell();
    				var cell8 = row.insertCell();
    				var cell9 = row.insertCell();
    				//var cell10 = row.insertCell();
						
					}
				else
					{
					var cell3 = row.insertCell();	
  					var cell4 = row.insertCell();
  					var cell5 = row.insertCell();
  					var cell6 = row.insertCell();
  					var cell7 = row.insertCell();
  					var cell8 = row.insertCell();
  					//var cell9 = row.insertCell();
  					//var cell10 = row.insertCell();
  					//var cell11 = row.insertCell();
					}
		
			
			
			cell1.innerHTML = "<input  type='text' name='cust_grp_code"
					+ index
					+ "' value='' size='10' onBlur='custGrpCodeDisLookUp(cust_grp_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name = 'cust_grp_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custGrpDescDisLookUp(this,cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value'' /><INPUT type='hidden' name='cust_grp_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='cust_grp_desc_temp"
					+ index
					+ "' value=''><input type='button' name='cust_grp_button"
					+ index
					+ "' class='button' value='?' onclick='custGrpDisLookUp(cust_grp_desc"
					+ index + ",cust_grp_code" + index + ",\"" + index
					+ "\")'/><input type='hidden' name='oldKey" + index
					+ "' value=''>";
			cell2.innerHTML = "<input  type='text' name='cust_code"
					+ index
					+ "' value='' size='10' onBlur='custCodeDisLookUp(cust_desc"
					+ index
					+ ",this,cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'cust_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custDescDisLookUp(this,cust_code"
					+ index
					+ ",cust_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='cust_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='cust_desc_temp"
					+ index
					+ "' value=''><input type='button' name='cust_button"
					+ index
					+ "' class='button' value='?' onclick='custDisLookUp(cust_desc"
					+ index + ",cust_code" + index + ",cust_grp_code" + index
					+ ",\"" + index + "\");'/>";				
					
					if(SiteAgeSpecialty=='true'){
						

						

				cell3.innerHTML = "<input  type='text' name='blng_class_code"
					+ index
					+ "' value='' size='10' onBlur='custBlngClassCodeLookUp(blng_class_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'><input type='text' name = 'blng_class_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custBlngClassDescLookUp(this,blng_class_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='blng_class_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_class_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_class_button"
					+ index
					+ "' class='button' value='?' onclick='custBlngClassLookUp(blng_class_desc"
					+ index + ",blng_class_code" + index + ",\"" + index
					+ "\")'/>";
				
			cell4.innerHTML = "<input  type='text' name='age_group_code"
					+ index
					+ "' value='' size='10' onBlur='AgeGroupCodeLookUp(hdn_age_group"
					+ index
					+ ",this,"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'hdn_age_group"
					+ index
					+ "' size='10' maxlength='10' onBlur='AgeGroupDescLookUp(this,age_group_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='age_group_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='hdn_age_group_temp"
					+ index
					+ "' value=''><input type='button' name='age_button"
					+ index
					+ "' class='button' value='?' onclick='AgeGroupLookUp(hdn_age_group"
					+ index + ",age_group_code"
					+ index
					+ ",\"" + index + "\");'/>";			

			cell5.innerHTML = "<input  type='text' name='specialty_code"
					+ index
					+ "' value='' size='10' onBlur='specialtyCodeLookUp(specialty_desc"
					+ index
					+ ",this,"
					+ index
					+ ",\""
					+ index
					+ "\")'><input type='text' name = 'specialty_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='specialtyDescLookUp(this,specialty_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='specialty_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='specialty_desc_temp"
					+ index
					+ "' value=''><input type='button' name='specialty_button"
					+ index
					+ "' class='button' value='?' onclick='specialtyLookUp(specialty_desc"
					+ index + ",specialty_code"
					+ index
					+ ",\"" + index + "\");'/>";

			cell6.innerHTML = "<input type='text' name='eff_from_date"
					+ index
					+ "' id='eff_from_date"
					+ index
					+ "' size='10' maxlength='10'  value='' onBlur='validateDiscountDate(this,this,eff_to_date"
					+ index
					+ ",\""
					+ index
					+ "\");'><img id = 'eff_from_date_img_"
					+ index
					+ "' name='eff_from_date_img_"
					+ index
					+ "'	  src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_from_date"
					+ index + "\");'  />";
			cell7.innerHTML = "<input type='text' name='eff_to_date"
					+ index
					+ "'  id='eff_to_date"
					+ index
					+ "' size='10' maxlength='10'  value=''  onBlur='validateDiscountDate(this,eff_from_date"
					+ index
					+ ",this,\""
					+ index
					+ "\");' ><img id = 'eff_to_date_img_"
					+ index
					+ "' name='eff_to_date_img_"
					+ index
					+ "'	src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_to_date"
					+ index + "\");' >";
			cell8.innerHTML = "<select name='discount_type" + index
					+ "' onChange='chkDisountType(this,\"" + index
					+ "\")' ><option value='R' selected>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option></select>";
			cell9.innerHTML = "<input type='text' name='discount" + index
					+ "'   size='5' onBlur='chkDiscountAmt(this,\"" + index
					+ "\");' onkeypress='return ChkNumberInput(this,event,\""
					+ noofdecimal + "\")' value=''/>";
			cell10.innerHTML = "<input type='checkbox'  name='deleteDiscount"
					+ index + "' onClick='chkDeleteDiscount(this,\"" + index
					+ "\")' value='N'/>";
			}
			else  if(siteAutoApplyPkgDiscYN=='true' && PkgByPolicy=='Y'){
			
				cell3.innerHTML = "<input  type='text' name='poly_code"
						+ index
						+ "' value='**' size='10' onBlur='polyCodeDisLookUp(poly_desc"
						+ index
						+ ",this,\""
						+ index
						+ "\")'><input type='text' name = 'poly_desc"
						+ index
						+ "' size='10' maxlength='10' onBlur='polyDescDisLookUp(this,poly_code"
						+ index
						+ ",\""
						+ index
						+ "\")' value='All Policies'><INPUT type='hidden' name='poly_code_temp"
						+ index
						+ "' value=''><INPUT type='hidden' name='poly_desc_temp"
						+ index
						+ "' value=''><input type='button' name='poly_button"
						+ index
						+ "' class='button' value='?' onclick='custpolyDisLookUp(poly_desc"
						+ index + ",poly_code" + index + ",cust_grp_code" + index
						+ ",\"" + index + "\")'/>";
				

				cell4.innerHTML = "<input  type='text' name='blng_class_code"
					+ index
					+ "' value='' size='10' onBlur='custBlngClassCodeLookUp(blng_class_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'><input type='text' name = 'blng_class_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custBlngClassDescLookUp(this,blng_class_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='blng_class_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_class_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_class_button"
					+ index
					+ "' class='button' value='?' onclick='custBlngClassLookUp(blng_class_desc"
					+ index + ",blng_class_code" + index + ",\"" + index
					+ "\")'/>";
		

			cell5.innerHTML = "<input type='text' name='eff_from_date"
					+ index
					+ "' id='eff_from_date"
					+ index
					+ "' size='10' maxlength='10'  value='' onBlur='validateDiscountDate(this,this,eff_to_date"
					+ index
					+ ",\""
					+ index
					+ "\");'><img id = 'eff_from_date_img_"
					+ index
					+ "' name='eff_from_date_img_"
					+ index
					+ "'	  src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_from_date"
					+ index + "\");'  />";
			cell6.innerHTML = "<input type='text' name='eff_to_date"
					+ index
					+ "'  id='eff_to_date"
					+ index
					+ "' size='10' maxlength='10'  value=''  onBlur='validateDiscountDate(this,eff_from_date"
					+ index
					+ ",this,\""
					+ index
					+ "\");' ><img id = 'eff_to_date_img_"
					+ index
					+ "' name='eff_to_date_img_"
					+ index
					+ "'	src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_to_date"
					+ index + "\");' >";
			cell7.innerHTML = "<select name='discount_type" + index
					+ "' onChange='chkDisountType(this,\"" + index
					+ "\")' ><option value='R' selected>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option></select>";
			cell8.innerHTML = "<input type='text' name='discount" + index
					+ "'   size='5' onBlur='chkDiscountAmt(this,\"" + index
					+ "\");' onkeypress='return ChkNumberInput(this,event,\""
					+ noofdecimal + "\")' value=''/>";
			cell9.innerHTML = "<input type='checkbox'  name='deleteDiscount"
					+ index + "' onClick='chkDeleteDiscount(this,\"" + index
					+ "\")' value='N'/>";
			}
			
			else{				
				cell3.innerHTML = "<input  type='text' name='blng_class_code"
					+ index
					+ "' value='' size='10' onBlur='custBlngClassCodeLookUp(blng_class_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'><input type='text' name = 'blng_class_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='custBlngClassDescLookUp(this,blng_class_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value=''><INPUT type='hidden' name='blng_class_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_class_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_class_button"
					+ index
					+ "' class='button' value='?' onclick='custBlngClassLookUp(blng_class_desc"
					+ index + ",blng_class_code" + index + ",\"" + index
					+ "\")'/>";
				

				

				cell4.innerHTML = "<input type='text' name='eff_from_date"
						+ index
						+ "' id='eff_from_date"
						+ index
						+ "' size='10' maxlength='10'  value='' onBlur='validateDiscountDate(this,this,eff_to_date"
						+ index
						+ ",\""
						+ index
						+ "\");'><img id = 'eff_from_date_img_"
						+ index
						+ "' name='eff_from_date_img_"
						+ index
						+ "'	  src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_from_date"
						+ index + "\");'  />";
				cell5.innerHTML = "<input type='text' name='eff_to_date"
						+ index
						+ "'  id='eff_to_date"
						+ index
						+ "' size='10' maxlength='10'  value=''  onBlur='validateDiscountDate(this,eff_from_date"
						+ index
						+ ",this,\""
						+ index
						+ "\");' ><img id = 'eff_to_date_img_"
						+ index
						+ "' name='eff_to_date_img_"
						+ index
						+ "'	src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"eff_to_date"
						+ index + "\");' >";
				cell6.innerHTML = "<select name='discount_type" + index
						+ "' onChange='chkDisountType(this,\"" + index
						+ "\")' ><option value='R' selected>"
						+ getLabel('Common.Percent.label', 'Common')
						+ "</option><option value='A' >"
						+ getLabel('Common.amount.label', 'Common')
						+ "</option></select>";
				cell7.innerHTML = "<input type='text' name='discount" + index
						+ "'   size='5' onBlur='chkDiscountAmt(this,\"" + index
						+ "\");' onkeypress='return ChkNumberInput(this,event,\""
						+ noofdecimal + "\")' value=''/>";
				cell8.innerHTML = "<input type='checkbox'  name='deleteDiscount"
						+ index + "' onClick='chkDeleteDiscount(this,\"" + index
						+ "\")' value='N'/>";
			}		
			
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1; //ADED FOR MMS-QH-128.1 10/7/2020_73392
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
		}
	}
	//Added By Shikha For GHL-CRF-0520.1
	else if (tabId == "BILLINGGROUP") {
		var formObj = parent.blng_grp_dtls.document.blng_grp_dtls;
		
		var totalRecords = formObj.totalRecords.value;
		var noofdecimal = formObj.noofdecimal.value;
		rowCount = parseInt(totalRecords) + 1
		index = parseInt(totalRecords);

		var result = true;		
		result = validateBillingGroups(formObj);		
		if (result) {
			
			row = eval("parent.blng_grp_dtls.document.getElementById('" + tableID+ "')").insertRow();
			
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);			
  			
			cell1.innerHTML = "<input  type='text' name='blng_grp_code"
					+ index
					+ "' value='' size='10' onBlur='blngGrpCodeLookUp(blng_grp_desc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name = 'blng_grp_desc"
					+ index
					+ "' size='10' maxlength='10' onBlur='blngGrpDescLookUp(this,blng_grp_code"
					+ index
					+ ",\""
					+ index
					+ "\")' value'' /><INPUT type='hidden' name='blng_grp_code_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='blng_grp_desc_temp"
					+ index
					+ "' value=''><input type='button' name='blng_grp_button"
					+ index
					+ "' class='button' value='?' onclick='blngGrpLookUp(blng_grp_desc"
					+ index + ",blng_grp_code" + index + ",\"" + index
					+ "\")'/><input type='hidden' name='oldKey" + index
						+ "' value=''>";
	
			cell2.innerHTML = "<input type='text'  name='pkg_valid_days"
					+ index
					+ "' size='4' maxlength='4' onBlur='return chkBlngGrpValidDays(this);'  onKeyPress='return(ChkNumberInput(this,event,"
					+ noofdecimal + "))' value=''/>";
			
			cell3.innerHTML = "<a name='select" + index
					+ "' href='#' onClick='showBlngGrpPeriod(this,\"" + index
					+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
			
		}
	
	} else if (tabId == "BLNG_GRP_PERIOD") {
		var formObj = parent.blng_grp_period_dtl.document.blng_grp_period_dtl;
		var totalRecords = formObj.totalRecords.value;
		var VATapplicable = parent.blng_grp_period_dtl.document.forms[0].VATapplicable.value;
		index = parseInt(totalRecords);
		table = eval("parent.blng_grp_period_dtl.document.getElementById('"+ tableID + "')");
		var result = true;
		var glSmryYN = parent.blng_grp_period_dtl.document.forms[0].glSmryYN.value;
		var glSmry = "";
		var glSmryDesc = "";
		var glSmryDisc = "";
		var glSmryDiscDesc = "";
		var disableGLPost = "";
		var VATpercent = "";
		var VATapp = "";
		var defSelect = "";
		var asperpolicy = "";
		var patCoverage = "";
		var payerCoverage = "";
		var VATappchecked="";
		var ruleCoverageInd="";
		var VATruleCoverage="";
		if (index > 0)
			result = validateBlngGrpPackageDates(parent.blng_grp_period_dtl.document.forms[0], parseInt(totalRecords));

		if (result) {
			row = eval(
					"parent.blng_grp_period_dtl.document.getElementById('"
							+ tableID + "')").insertRow();
			if (index != "0") {
				glSmry = eval("parent.blng_grp_period_dtl.document.forms[0].glSmry"
						+ (parseInt(index) - 1)).value
				glSmryDesc = eval("parent.blng_grp_period_dtl.document.forms[0].glSmryDesc"
						+ (parseInt(index) - 1)).value
				glSmryDisc = eval("parent.blng_grp_period_dtl.document.forms[0].glSmryDisc"
						+ (parseInt(index) - 1)).value
				glSmryDiscDesc = eval("parent.blng_grp_period_dtl.document.forms[0].glSmryDiscDesc"
						+ (parseInt(index) - 1)).value
			} else {
				glSmry = "";
				glSmryDesc = "";
				glSmryDisc = "";
				glSmryDiscDesc = "";
			}
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			if(VATapplicable=="Y"){
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);
			var cell12 = row.insertCell(11);
			}
			cell1.innerHTML = "<input type='text' name='fromDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=\"blngGrpValidateDate(this,this,toDate_"
					+ index
					+ ",'"
					+ index
					+ "');showBlngGrpBasePrice(this,'"
					+ index
					+ "');\" ><img id = 'fromDate_img_"
					+ index
					+ "' name='fromDate_img_"
					+ index
					+ "'	  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar('fromDate_"
					+ index
					+ "');\"   /><img src='../../eCommon/images/mandatory.gif'/><input type='hidden' name='oldPeriodKey"
					+ index + "' value=''>";
			cell2.innerHTML = "<input type='text' name='toDate_"
					+ index
					+ "' id='toDate_"
					+ index
					+ "' size='10' maxlength='10' onBlur=blngGrpValidateDate(this,fromDate_"
					+ index
					+ ",this,'"
					+ index
					+ "') ><img id = 'toDate_img_"
					+ index
					+ "' name='toDate_img_"
					+ index
					+ "' src='../../eCommon/images/CommonCalendar.gif' onClick=showCalendar('toDate_"
					+ index + "'); >";
			cell3.innerHTML = "<input type='text' name='pkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callBlngGrpPriceClass(this,'code','PRICE_CLASS','"
					+ index
					+ "')\"  > <input type='text' name='pkgPriceClsDesc_"
					+ index
					+ "' size='8' maxlength=\"10\"  onBlur=\"callBlngGrpPriceClass(this,'desc','PRICE_CLASS','"
					+ index
					+ "')\" ><input type='button' class='button' name='pkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callBlngGrpPriceClass('','','PRICE_CLASS','"
					+ index + "')\"  tabindex='0'/>";
			cell4.innerHTML = "<input type='text' name='oPkgPriceClsCode_"
					+ index
					+ "' size='8' maxlength=\"8\" onBlur=\"callBlngGrpPriceClass(this,'code','OUT_PRICE_CLASS','"
					+ index
					+ "')\"  /> <input type='text' name='oPkgPriceClsDesc_"
					+ index
					+ "' size='10' maxlength=\"10\" onBlur=\"callBlngGrpPriceClass(this,'desc','OUT_PRICE_CLASS','"
					+ index
					+ "')\" /><input type='button' class='button' name='OPkgPriceCls_"
					+ index
					+ "' value='?' onClick=\"callBlngGrpPriceClass('','','OUT_PRICE_CLASS','"
					+ index + "')\" tabindex='0'/>";
			if (glSmryYN == "N") {
				disableGLPost = "disabled";
			} else {
				disableGLPost = "";
			}
			cell5.innerHTML = "<input type='text' name='glSmry"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmry
					+ "' "
					+ disableGLPost
					+ " onBlur='blngGrpGlSmryCodeLookUp(glSmryDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDesc
					+ "' onBlur='blngGrpGlSmryDescLookUp(this,glSmry"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmry_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryLookUp"
					+ index
					+ "' value='?' onClick='blngGrpGlSmryLookUp(glSmryDesc"
					+ index + ",glSmry" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			cell6.innerHTML = "<input type='text' name='glSmryDisc"
					+ index
					+ "' size='5' maxlength='5' value='"
					+ glSmryDisc
					+ "' "
					+ disableGLPost
					+ " onBlur='blngGrpGlSmryDiscCodeLookUp(glSmryDiscDesc"
					+ index
					+ ",this,\""
					+ index
					+ "\")'/><input type='text' name='glSmryDiscDesc"
					+ index
					+ "' size='15' maxlength='15' "
					+ disableGLPost
					+ " value='"
					+ glSmryDiscDesc
					+ "' onBlur='blngGrpGlSmryDiscDescLookUp(this,glSmryDisc"
					+ index
					+ ",\""
					+ index
					+ "\")'/><INPUT type='hidden' name='glSmryDisc_temp"
					+ index
					+ "' value=''><INPUT type='hidden' name='glSmryDiscDesc_temp"
					+ index
					+ "' value=''><input type='button' class='button' name='glSmryDiscLookUp"
					+ index
					+ "' value='?' onClick='blngGrpGlSmryDiscLookUp(glSmryDiscDesc"
					+ index + ",glSmryDisc" + index + ",\"" + index + "\");'  "
					+ disableGLPost + "/>";
			cell7.innerHTML = "<input type='checkbox' name='CopyBase' id='CopyBase' value='' onClick =\"CopyBaseChk()\" />";
			cell8.innerHTML = "<input type='checkbox' name='ReplaceBase' id='ReplaceBase' value='' onClick =\"ReplaceBaseChk()\" />";
			if(VATapplicable=="Y")
			{
				cell9.innerHTML = "<input type='checkbox' name='VATapp"
				+ index
				+ "' id='VATapp"
				+index
				+ "' value='"
				+ "'"
				+ " onClick='enableRuleCode_BlngGrp(VATapp"
				+index
				+ ",\""
				+ index
				+ "\")'" 
				+"/>";
			
			cell10.innerHTML = "<input type='text' name='VATpercent"
				+ index
				+ "' id='VATpercent"
				+index
				+ "' size='6' maxlength='6' value='"
				+ "'"
				+ " onBlur='ruleCodeLookup_BlngGrp(VATpercent"
				+ index
				+ ",\""
				+ index
				+ "\")' disabled/><input type='button' class='button' name='VATpercent_temp"
				+index
				+"' id='VATpercent_temp"
				+index
				+"'value='?' onClick='ruleCodeLookup_BlngGrp(VATpercent"
				+index
				+",\""
				+ index
				+ "\")'disabled/>";
			cell11.innerHTML ="<select  name='ruleCoverageInd" + index
				+ "' disabled >	 <option value='' >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='S'  >"
				+ getLabel('eBL.AS_PER_POLICY.label', 'BL')
				+ "</option><option value='C'>"
				+ getLabel('eBL.PATIENT_COVERAGE.label', 'BL')
				+ "</option><option value='P'>"
				+ getLabel('eBL.PAYER_COVERAGE.label', 'BL')
				+ "</option></select>";

			cell12.innerHTML = "<a name='select" + index
					+ "' href='#' onClick='showBlngGrpBasePrice(this,\"" + index
					+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
		}
		else{
			cell9.innerHTML = "<a name='select" + index
			+ "' href='#' onClick='showBlngGrpBasePrice(this,\"" + index
			+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";			
		}
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
		document.getElementById("blngGrpDefAddBtn").disabled = true;
		parent.blng_grp_period_dtl.document.blng_grp_period_dtl.BLNG_GRP_NEW_DATE_CHK.value = "Y";
	} else if (tabId == "BLNG_GRP_PRICE") {
		var formObj = parent.blng_grp_base_price_dtl.document.blng_grp_base_price_dtl;
		var totalRecords = formObj.totalRecords.value;
		index = parseInt(totalRecords);
		table = eval("parent.blng_grp_base_price_dtl.document.getElementById('"+ tableID + "')");
		var result = true;
		if (index > 0)
			result = validateBlngGrpPackagePrice("parent.blng_grp_base_price_dtl.document.forms[0]",parseInt(totalRecords));
		if (result) {
			row = eval("parent.blng_grp_base_price_dtl.document.getElementById('"+ tableID + "')").insertRow();
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);
			var cell12 = row.insertCell(11);
			cell1.innerHTML = "<input type='text' name='blgClsCode_"
					+ index
					+ "' size='3' maxlength=\"2\" onBlur=\"callBlngGrpBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",this,'"
					+ index
					+ "','code')\"><input type='text' name='blgClsDesc_"
					+ index
					+ "' size='15' maxlength='30'  onBlur=\"callBlngGrpBlgCls(this,document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "','desc')\"><input type='button' class='button' name='blgCls_"
					+ index
					+ "' value='?' onClick=\"callBlngGrpBlgCls(document.forms[0].blgClsDesc_"
					+ index
					+ ",document.forms[0].blgClsCode_"
					+ index
					+ ",'"
					+ index
					+ "')\" tabindex='0' \><img src='../../eCommon/images/mandatory.gif'>";
			cell2.innerHTML = "<select name='indicator_" + index
					+ "'    onChange=\"blngGrpIndiValidation(this,'" + index
					+ "')\"	><option value='R' >"
					+ getLabel('Common.Price.label', 'Common')
					+ "</option><option value='F'>"
					+ getLabel('eBL.FACTOR.label', 'BL') + "</option></select>";
			cell3.innerHTML = "<input type='text' name='price_"
					+ index
					+ "' size='13' maxlength='13' onBlur='validateBlngGrpBaePrice(this,\""
					+ noofdecimal
					+ "\",\"BL8526\",\""
					+ index
					+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/>";
			cell4.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' disabled size='2' maxlength=\"2\"  onkeypress=\" return (allowValidNumber(this,event));\"  />";
			cell5.innerHTML = "<select name='roundInd_" + index
					+ "' disabled >	<option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			cell6.innerHTML = "<input type='checkbox' name='deposit_" + index
					+ "' value='' onClick =\"checkBlngGrpDeposit(this,'" + index
					+ "')\" />";
			cell7.innerHTML = "<input type='checkbox' name='partialDeposit_"
					+ index
					+ "'  value='' disabled onClick =\"checkBlngGrpPartialDeposit(this,'"
					+ index + "')\" />";
			cell8.innerHTML = "<select  name='minDepAmtind_" + index
					+ "'	 disabled  onChange='validateInd(this,\"" + index
					+ "\",\"minDepAmt_\")'><option value='' >--"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "--</option><option value='A'  >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option></select>";
			cell9.innerHTML = "<input type='text' name='minDepAmt_"
					+ index
					+ "' value='' size='13' maxlength=\"13\"  disabled  onKeyPress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal
					+ "\")' onBlur='blngGrpValidForAmtPerUnltd(document.forms[0].minDepAmtind_"
					+ index + ",this,\"" + index + "\",\"BLNG_GRP_PRICE\",\""
					+ noofdecimal + "\")'  />";
			cell10.innerHTML = "<input type='checkbox' name='factorAppl_"
					+ index
					+ "' value='N' disabled  /><input type='hidden' name='statToModify_"
					+ index + "' value=''/>";
			cell11.innerHTML = "<input type='text' name='factorforServiceRate"
					+ index + "' axlength='20' size='10' value=''\" />";

			cell12.innerHTML = "<input type='button' class='button' name='callReportPkg"
					+ index
					+ "'  value='R' onclick=\"callReportBlngGrpBase(this,'"
					+ index + "')\" />";
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	} else if (tabId == "BLNG_GRP_RATE_BASED") {
		var formObj = parent.blng_grp_rate_based_dtl.document.blng_grp_rate_based_dtl;
		var siteSpecf = formObj.siteId.value;
		var dailyLimitSiteSpec = formObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = formObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = formObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = formObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = formObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = formObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = formObj.totalRecords.value;
		index = parseInt(totalRecords);
		var message = "";
		var obj;
		var order_associated = formObj.order_associated.value;
		if (order_associated == "Y") {
			if (eval("formObj.service_code" + (parseInt(index) - 1)) != null
					&& eval("formObj.service_code" + (parseInt(index) - 1)).value != "") {
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8562", 'BL');
					obj = eval("formObj.catalog_desc" + (parseInt(index) - 1));
				}
				if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value != ""
						&& eval("formObj.qty_limit" + (parseInt(index) - 1)).value == "") {
					message = getMessage("BL8538", 'BL');
					obj = eval("formObj.qty_limit" + (parseInt(index) - 1));
				}
				
				if (message != "") {
					alert(message);
					obj.focus();
					return false;
				}
			}
		}

		row = eval("parent.blng_grp_rate_based_dtl.document.getElementById('"+ tableID + "')").insertRow();
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14);
		var cell16 = row.insertCell(15);
		var cell17 = row.insertCell(16);
		var cell18 = row.insertCell(17);
		var cell19 = row.insertCell(18);
		var cell20 = row.insertCell(19); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell21 = row.insertCell(20); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell22 = row.insertCell(21); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		
		var typeHTML = "";
		var indHTML = "";
		var ordCatDisabled = "disabled";
		noofdecimal = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.noofdecimal.value
		if (order_associated == "Y") {
			ordCatDisabled = "";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onBlngGrpServiceTypeChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onBlngGrpIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value=''U'>"
					+ getLabel('Common.UserDefined.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		} else {
			ordCatDisabled = "disabled";
			typeHTML = "<select  NAME='type" + index
					+ "' onChange='onBlngGrpServiceTypeChange(this,\"" + index
					+ "\")'><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
			indHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onBlngGrpIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;

		cell2.innerHTML = "<input  type='hidden' name='service_code"
				+ index
				+ "' value=''><input type='text'  name='service_desc"
				+ index
				+ "' size='10' maxlength='10' onBlur='before_blngGrpServiceLookUp(this,service_code"
				+ index
				+ ",type"
				+ index
				+ ",\""
				+ index
				+ "\")' value=''><INPUT type='hidden' name='service_desc_temp"
				+ index
				+ "' value=''><input type='button' name='service_button"
				+ index
				+ "' class='button' value='?' onClick='blngGrpServiceLookUp(document.forms[0].service_desc"
				+ index + ",service_code" + index + ",type" + index + ",\""
				+ index + "\")'/><input type='hidden' name='oldSrvKey" + index
				+ "' value=''>";

		cell3.innerHTML = "<input  type='hidden' name='catalog_code"
				+ index
				+ "' value=''><input type='text' name = 'catalog_desc"
				+ index
				+ "'  "
				+ ordCatDisabled
				+ " size='10' maxlength='10' onBlur='before_blngGrpCatalogLookUp(this,catalog_code"
				+ index
				+ ",service_code"
				+ index
				+ ",\""
				+ index
				+ "\")' value=''><INPUT type='hidden' name='catalog_desc_temp"
				+ index
				+ "' value=''><input type=button name='catalog_button"
				+ index
				+ "'  "
				+ ordCatDisabled
				+ " class=button  value=? onClick='blngGrpCatalogLookUp(catalog_desc"
				+ index + ",catalog_code" + index + ",service_code" + index
				+ ",\"" + index + "\")'/>";

		cell4.innerHTML = indHTML;

		cell5.innerHTML = "<input type='text' name='factorOrRate"
				+ index
				+ "' size='12' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
				+ noofdecimal
				+ "\",\"BL8665\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\")';/>";

		cell6.innerHTML = "<input type='text' name='qty_limit" + index
				+ "' disabled size='8' onBlur='chkBlngGrpQtyLimit(this,\"" + index
				+ "\");' onkeypress='return allowValidNumber(this,event,\""
				+ noofdecimal + "\")'/>";
		cell7.innerHTML = "<select  name='amt_limit_ind" + index
				+ "' onChange='validateBlngGrpInd(this,\"" + index
				+ "\");changeSplitReqd(this,\"amt_limit\",\"" + index
				+ "\",\""+dailyLimitSiteSpec+"\",dailyLmtIndicator"+ index + ")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option><option value='U' >"
				+ getLabel('eBL.UNLIMITED.label', 'BL') + "</option></select>";
		cell8.innerHTML = "<input type='text' name='perAmt_limit"
				+ index
				+ "' size='8' maxlength='13'  onBlur='blngGrpValidForAmtPerUnltd(document.forms[0].amt_limit_ind"
				+ index
				+ ",this,\""
				+ index
				+ "\",\"\",\""
				+ noofdecimal
				+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\")'; />";

		cell9.innerHTML = "<input type='text' name='roundTo"
				+ index
				+ "' size='6' maxlength=\"3\"  \  onkeypress=\" return allowValidNumber(this,event,'"
				+ noofdecimal + "');\" value=''  />";
		cell10.innerHTML = "<select name='roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		
		if(siteSpecf == 'true'){
			cell11.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='N' disabled onclick='checkInclHomeMedi(this);'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
		}
		else{
			cell11.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		
		if(dailyLimitSiteSpec == "true") {
			var optionTxt = "";
			if("G" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == dailyPkgLmt || "B" == dailyPkgLmt) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			
			var ordCatDisabled1 = "";
			if(order_associated == "Y") {
				ordCatDisabled1 = " disabled ";
			}
			
			cell12.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.blng_grp_rate_based_dtl)' "+ordCatDisabled1+" >"
			+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell12.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell13.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
			cell13.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			cell14.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+ordCatDisabled1+" readOnly />";
		} else {
			cell12.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell12.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell13.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell13.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell14.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		cell15.innerHTML = "<input type='checkbox' disabled name='replace"
				+ index + "' onClick='chkBlngGrpReplace(this,\"" + index
				+ "\")' value='N' />";
		cell16.innerHTML = "<input type='checkbox'  disabled name='refund"
				+ index + "' onClick='chkBlngGrpRefund(this,\"" + index
				+ "\")' value='N' />";
		cell17.innerHTML = "<input type='checkbox'  disabled  name='autoRefund"
				+ index + "' onClick='chkBlngGrpAutoRefund(this,\"refundAmt"
				+ index + "\")' value=\"N\"/>";
		cell18.innerHTML = "<input type='checkbox'  disabled name='factor_appl"
				+ index + "' onClick='blngGrpFactorAppl(this,\"" + index
				+ "\")' value='N'/>";
		cell19.innerHTML = "<input type='radio' name='closePkg' id='closePkg' onClick=\"blngGrpAssignClosePkgVal(this,'"
				+ index
				+ "')\"/ disabled><input type='hidden' name='closePkg"
				+ index + "' value=\"N\" disabled />";
		cell20.innerHTML = "<a id='service_limit_dtls" + index
				+ "' href='#' onClick='blngGrpServiceLimitDtls(\"" + index
				+ "\")' disabled>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";
		cell21.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell22.innerHTML = "<input type='checkbox'  name='deleteService"
				+ index + "' onClick='chkBlngGrpDeleteService(this,\"" + index
				+ "\")' value='N'/>";
		formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;		
	} else if (tabId == "BLNG_GRP_SRVLIMIT_RATE_BASED") {
		var srvLimitFormObj = parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl;
		var siteSpecf = srvLimitFormObj.siteId.value; // shikha
		var dailyLimitSiteSpec = srvLimitFormObj.dailyLimitSiteSpec.value;//Added V190320-Aravindh/MMS-DM-CRF-0129
		var amtFldDisabled = srvLimitFormObj.amtFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var qtyFldDisabled = srvLimitFormObj.qtyFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var indicatorFldDisabled = srvLimitFormObj.indicatorFldDisabled.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyPkgLmt = srvLimitFormObj.dailyPkgLmt.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var dailyLmtChkYN = srvLimitFormObj.dailyLmtChkYN.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var parDailyLmtInd = srvLimitFormObj.parDailyLmtInd.value;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var totalRecords = srvLimitFormObj.totalRecords.value;
		index = parseInt(totalRecords);
		var message = "";
		var prevIndex = parseInt(index) - 1;
		var obj;
		if (eval("srvLimitFormObj.srvLimit_service_code" + prevIndex).value != ""
				&& (eval("srvLimitFormObj.exludeService" + prevIndex).value == "N" || eval("srvLimitFormObj.exludeService"
						+ prevIndex).value == "")) {

			if (eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex).value == ""
					&& eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).value == "") {
				message = getMessage("BL8555", 'BL');
				if (eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex).disabled)
					obj = eval("srvLimitFormObj.srvLimit_amt_limit" + prevIndex);
				else
					obj = eval("srvLimitFormObj.srvLimit_qty_limit" + prevIndex);
			}
			if (message != "") {
				alert(message);
				obj.focus();
				return false;
			}
		}

		row = eval("parent.frames[4].document.getElementById('" + tableID + "')").insertRow();
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);
		var cell10 = row.insertCell(9);
		var cell11 = row.insertCell(10);
		var cell12 = row.insertCell(11);
		var cell13 = row.insertCell(12);
		var cell14 = row.insertCell(13);
		var cell15 = row.insertCell(14);
		var cell16 = row.insertCell(15); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell17 = row.insertCell(16); //Added V190320-Aravindh/MMS-DM-CRF-0129
		var cell18 = row.insertCell(17); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
		var typeHTML = "";
		var parent_type = srvLimitFormObj.parent_type.value;
		noofdecimal = srvLimitFormObj.noofdecimal.value
		if (parent_type == "G") {
			typeHTML = "<select  NAME='srvLimit_type" + index
					+ "' onChange='onBlngGrpSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else if (parent_type == "P") {
			typeHTML = "<select NAME='srvLimit_type" + index
					+ "' onChange='onBlngGrpSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='C'>"
					+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
					+ "</option><option value='G'>"
					+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
					+ "</option><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'Common')
					+ "</option><option value='T'>"
					+ getLabel('eBL.SalesCategory.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PackageGrouping.label', 'BL')
					+ "</option></select>";
		} else {
			typeHTML = "<select  NAME='srvLimit_type" + index
					+ "' onChange='onBlngGrpSrvLimitServiceTypeChange(this,\""
					+ index + "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option></select>";
		}

		cell1.innerHTML = typeHTML;
		cell2.innerHTML = "<input  type='text' name='srvLimit_service_code"
				+ index
				+ "' value='' size='10' onBlur='blngGrpSrvLimitCodeLookUp(srvLimit_service_desc"
				+ index
				+ ",this,srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\");'><input type='text' name = 'srvLimit_service_desc"
				+ index
				+ "' size='10' maxlength='10' onBlur='before_blngGrpSrvLimitServiceLookUp(this,srvLimit_service_code"
				+ index
				+ ",srvLimit_type"
				+ index
				+ ",\""
				+ index
				+ "\");' value=''><INPUT type='hidden' name='srvLimit_service_code_temp"
				+ index
				+ "' value=''><INPUT type='hidden' name='srvLimit_service_desc_temp"
				+ index
				+ "' value=''><input type='button' name='srvLimit_service_button"
				+ index
				+ "' class='button' value='?' onclick='blngGrpSrvLimitServiceLookUp(srvLimit_service_desc"
				+ index + ",srvLimit_service_code" + index + ",srvLimit_type"
				+ index + ",\"" + index + "\");' />";
		cell3.innerHTML = "<input type='checkbox' name='exludeService" + index
				+ "' onClick='chkBlngGrpExludeService(this,\"" + index
				+ "\");changeSplitReqd(this,\"exclude\",\"" + index
				+ "\");IncludeHomeMedicationBlngGrpExclude(this,srvLimit_service_code"+ index + ",srvLimit_type"+ index + ",\""+ index + "\");' value='N' />";
		cell4.innerHTML = "<input type='text' name='srvLimit_qty_limit"
				+ index
				+ "' disabled size='5' onBlur='chkBlngGrpSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber(this,event,\""
				+ noofdecimal + "\");'  value='' />";
		cell5.innerHTML = "<select  name='srvLimit_amt_limit_ind" + index
				+ "' onChange='validateBlngGrpInd(this,\"" + index
				+ "\")'><option value='' selected >--"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "--</option><option value='A' >"
				+ getLabel('Common.amount.label', 'Common')
				+ "</option><option value='P' >"
				+ getLabel('Common.Percent.label', 'Common')
				+ "</option></select>";
		cell6.innerHTML = "<input type='text' name='srvLimit_amt_limit"
				+ index
				+ "'  disabled size='5' maxlength='13'  onBlur='chkBlngGrpSrvLimitAmtLimit(this,\""
				+ index
				+ "\",\""
				+ noofdecimal
				+ "\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
				+ noofdecimal + "\");'  value='' />";
		cell7.innerHTML = "<input type='text' name='srvLimit_roundTo"
				+ index
				+ "' size='3' maxlength=\"3\"  \  onkeypress=\" return (allowValidNumber(this,event));\"  value='' />";
		cell8.innerHTML = "<select name='srvLimit_roundInd" + index
				+ "' ><option value='U' >"
				+ getLabel('Common.Up.label', 'Common')
				+ "</option><option value='D' >"
				+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
		
		if(siteSpecf == 'true'){
			cell9.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='N' disabled onclick='checkInclHomeMedi(this);IncludeHomeMedicationUnchkExclude(this,\"blnggrprateexclude\",\""+ index + "\");'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
		}
		else{
			cell9.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
			+ "' id='includeHomeMedication" + index
			+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
		}
		
		if(dailyLimitSiteSpec == "true") {
			var optionTxt = "";
			if("G" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='G'>"+getLabel('Common.Group.label', 'COMMON')+"</option>";
			} if("I" == parDailyLmtInd || "B" == parDailyLmtInd) {
				optionTxt += "<option value='I'>"+getLabel('eBL.PIPD.label', 'BL')+"</option>";
			}
			cell10.innerHTML = "<select name='dailyLmtIndicator" + index
			+ "' id='dailyLmtIndicator" + index
			+ "' "+indicatorFldDisabled
			+" onchange = 'dailyLmtIndicatorOnChange(this,"+ index +",document.blng_grp_srvLimit_rate_based_dtl)'>"
			+"<option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt+"</select>";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = '"+dailyLmtChkYN+"' />";
			cell11.innerHTML = "<input type='text' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,\""+noofdecimal+"\",\"BL8540\");'" 
			+ " onkeypress='return allowValidNumber(this,event,10,\""+noofdecimal+"\");' "+amtFldDisabled+indicatorFldDisabled+" readOnly />";
			cell11.innerHTML += "&nbsp;<select name='dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index + amtFldDisabled+indicatorFldDisabled+ordCatDisabled1
			+ "' disabled ><option value='G'>"+getLabel('eBL.Gross.label', 'BL')+"</option>"
			+ "<option value='N'>"+getLabel('eBL.Net.label', 'BL')+"</option></select>";
			cell12.innerHTML = "<input type='text' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
			+ " onkeypress='return allowValidNumber(this,event,10,0);' "+qtyFldDisabled+indicatorFldDisabled+" readOnly />";
		} else {
			cell10.innerHTML = "<input type='hidden' name = 'dailyLmtChkBx" + index
			+ "' id = 'dailyLmtChkBx" + index
			+ "' value = 'N' />";
			cell10.innerHTML += "<input type='hidden' name = 'dailyLmtIndicator" + index
			+ "' id = 'dailyLmtIndicator" + index
			+ "' value = '' />";
			cell11.innerHTML = "<input type='hidden' name = 'dailyLmtAmt" + index
			+ "' id = 'dailyLmtAmt" + index
			+ "' value = '' />";
			cell11.innerHTML += "<input type='hidden' name = 'dailyLmtGrossNetList" + index
			+ "' id='dailyLmtGrossNetList" + index
			+ "' value = '' />";
			cell12.innerHTML = "<input type='hidden' name = 'dailyLmtQty" + index
			+ "' id = 'dailyLmtQty" + index
			+ "' value = '' />";
		}
		
		cell13.innerHTML = "<input type='checkbox' name='srvLimit_replace"
				+ index
				+ "' onClick='blngGrpSrvLimitChkReplace(this,\""
				+ index
				+ "\")' value=\"N\"/><input type=\"hidden\" name=\"srvLimit_replaceSrv_code"
				+ index
				+ "\" id=\"srvLimit_replaceSrv_code"
				+ index
				+ "\" ><input type=\"hidden\" name=\"srvLimit_replaceSrv_desc"
				+ index + "\" id=\"srvLimit_replaceSrv_desc"
				+ index + "\" />";
		cell14.innerHTML = "<input type='checkbox' name='srvLimit_refund"
				+ index + "' id='srvLimit_refund"
				+ index + "' onClick='blngGrpSrvLimitChkRefund(this,\"" + index
				+ "\")' value=\"N\"/>";
		cell15.innerHTML = "<input type='checkbox'  disabled  name='srvLimit_autoRefund"
				+ index
				+ "' id='srvLimit_autoRefund"
				+ index
				+ "' onClick='chkBlngGrpAutoRefund(this,\"srvLimit_refundAmt"
				+ index + "\")' value=\"N\"/>";
		cell16.innerHTML = "<input type='checkbox'  disabled name='srvLimit_factor_appl"
				+ index
				+ "' id='srvLimit_factor_appl"
				+ index
				+ "' onClick='blngGrpSrvLimitFactorAppl(this,\""
				+ index
				+ "\")' value='N'/>";
		cell17.innerHTML = "<input type='checkbox' name='split_reqd" + index
				+ "' id='split_reqd" + index
				+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
		cell18.innerHTML = "<input type='checkbox'  name='srvLimit_deleteService"
				+ index
				+ "' id='srvLimit_deleteService"
				+ index
				+ "' onClick='chkBlngGrpSrvLimitDeleteService(this,\""
				+ index + "\")' value='N'/>";
		srvLimitFormObj.totalRecords.value = parseInt(srvLimitFormObj.totalRecords.value) + 1;		
	} else if (tabId == "BLNG_GRP_CHARGE_BASED") {
		var formObj = parent.blng_grp_charge_based_dtl.document.blng_grp_charge_based_dtl;
		var totalRecords = formObj.totalRecords.value;
		var siteSpecf = formObj.siteId.value; 
		index = parseInt(totalRecords);
		var noofdecimal = formObj.noofdecimal.value;
		table = eval("parent.blng_grp_charge_based_dtl.document.getElementById('"+ tableID + "')");

		result = true;
		if (index > 0) {
			result = validateBlngGrpChargeBased(parent.blng_grp_charge_based_dtl.document.forms[0],parseInt(totalRecords));
		}
		if (result) {
			row = eval("parent.blng_grp_charge_based_dtl.document.getElementById('"+ tableID + "')").insertRow();

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);// MuthuN against 28192
			var cell12 = row.insertCell(11);// Split reqd
			var cell13=row.insertCell(12);//Split reqd
			typeHTML = "<select NAME='charge_type"
					+ index
					+ "' onChange='onSrvLimitServiceTypeChange_blngGrpcharge(this,\""
					+ index + "\")'><option value='S'>"
					+ getLabel('Common.BillingService.label', 'Common')
					+ "</option><option value='M'>"
					+ getLabel('Common.item.label', 'BL')
					+ "</option></select>";// MuthuN against 28192
			cell1.innerHTML = typeHTML;// MuthuN against 28192
			cell2.innerHTML = "<input type='text' name = 'cbCode_"
					+ index
					+ "' id = 'cbCode_"
					+ index
					+ "' size='10' maxlength='10' onBlur='blngGrpCallLookup(this,this,document.forms[0].cbDesc_"
					+ index
					+ ",\"BLNG_GRP_CHARGE_BASED\",\""
					+ index
					+ "\");' /><input type='hidden' name = 'cbCodePrev_"
					+ index
					+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
					+ index
					+ "' value ='' /><input type='text' name='cbDesc_"
					+ index
					+ "' id='cbDesc_"
					+ index
					+ "' size='10' maxlength='100'  value=''   onBlur='blngGrpCallLookup(this,document.forms[0].cbCode_"
					+ index
					+ ",this,\"BLNG_GRP_CHARGE_BASED\",\""
					+ index
					+ "\");' /><input type='button' class='button' name='serviceLookUp_"
					+ index
					+ "' value='?' onClick=blngGrpCallServices(document.forms[0].cbCode_"
					+ index + ",document.forms[0].cbDesc_" + index
					+ ",'BLNG_GRP_CHARGE_BASED',charge_type" + index + ",\""
					+ index + "\") /><input type='hidden' name='oldSrvKey"
					+ index + "' value=''>";
			cell3.innerHTML = "<select  name='amt_limit_ind" + index
					+ "' onChange='validateBlngGrpInd(this,\"" + index
					+ "\");changeSplitReqd(this,\"amt_limit\",\"" + index
					+ "\")'><option value='A' >"
					+ getLabel('Common.amount.label', 'Common')
					+ "</option><option value='P' >"
					+ getLabel('Common.Percent.label', 'Common')
					+ "</option><option value='U' >"
					+ getLabel('eBL.UNLIMITED.label', 'BL')
					+ "</option></select>";
			cell4.innerHTML = "<input type='text' name='perAmt_limit"
					+ index
					+ "' size='5' maxlength='13'  onBlur='blngGrpValidForAmtPerUnltd(amt_limit_ind"
					+ index
					+ ",this,\""
					+ index
					+ "\",\"BLNG_GRP_CHARGE_BASED\",\""
					+ noofdecimal
					+ "\")' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")'; />";
			cell5.innerHTML = "<input type='text' name='roundTo_"
					+ index
					+ "' size='3' maxlength=\"3\"  \  onkeypress=\" return (allowValidNumber(this,event));\"  value='' />";
			cell6.innerHTML = "<select name='roundInd_" + index
					+ "' id='roundInd_" + index
					+ "' ><option value='U' >"
					+ getLabel('Common.Up.label', 'Common')
					+ "</option><option value='D' >"
					+ getLabel('eBL.DOWN.label', 'BL') + "</option></select>";
			
			if(siteSpecf == 'true'){
				cell7.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this);'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
			}
			else{
				cell7.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			
			cell8.innerHTML = "<input type='checkbox'   name='refund_" + index
					+ "' onClick='chkBlngGrpRefundCB(this,\"" + index
					+ "\")' value='N' />";
			cell9.innerHTML = "<input type='checkbox' size ='10'   name='autoRefund_"
					+ index
					+ "' onClick='chkBlngGrpAutoRefund(this,\"refundAmt_"
					+ index + "\")' value=\"N\"/>";
			cell10.innerHTML = "<input type='checkbox' name='factor_appl"
					+ index + "' onClick='blngGrpFactorAppl(this,\"" + index
					+ "\")' DISABLED value=\"N\"/>";

			cell11.innerHTML = "<input type='checkbox' name='srvLmt_"
					+ index
					+ "' value=\"N\"   onclick=\"showLmtDetails(this,'"
					+ index
					+ "')\"/><a style =\"display:none\" id='srvLmtDtls_"
					+ index
					+ "' href='javascript:loadBlngGrpChargeBasedServiceLimit(document.forms[0].cbCode_"
					+ index + ".value,\"" + index + "\")'>"
					+ getLabel('eBL.Dtls.label', 'BL') + "</a>";
			cell12.innerHTML = "<input type='checkbox' name='split_reqd"
					+ index + "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			cell13.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkBlngGrpDeleteService(this,'"
					+ index + "')\"/>";			
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	} else if (tabId == "BLNG_GRP_CHARGE_BASED_ITEM") {
		var formObj = parent.frames[4].document.blng_grp_charge_based_excl_dtl; 
		var totalRecords = formObj.totalRecords.value;
		index = parseInt(totalRecords);
		var noofdecimal = formObj.noofdecimal.value
		var siteSpecf = formObj.siteId.value; 
		table = eval("parent.blng_grp_charge_based_excl.document.getElementById('"+ tableID + "')");
		var result = true;
		if (index > 0) {
			result = validateBlngGrpChargeBasedItems(parent.blng_grp_charge_based_excl.document.forms[0],parseInt(totalRecords));
		}
		if (result) {
			row = eval("parent.blng_grp_charge_based_excl.document.getElementById('"+ tableID + "')").insertRow();

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			
			cell1.innerHTML = "<input type='hidden' name = 'charge_type"
				+ index
				+ "' id ='charge_type"+ index + "' value = 'M' /><input type='text' name = 'cbCode_"
					+ index
					+ "' id = 'cbCode_"
					+ index
					+ "' size='10' maxlength='10' onBlur='blngGrpCallLookup(this,this,document.forms[0].cbDesc_"
					+ index
					+ ",\"BLNG_GRP_CHARGE_BASED_ITEM\",\""
					+ index
					+ "\");' /><input type='hidden' name = 'cbCodePrev_"
					+ index
					+ "' value ='' /><input type='hidden' name = 'cbDescPrev_"
					+ index
					+ "' value ='' /><input type='text' name='cbDesc_"
					+ index
					+ "' id='cbDesc_"
					+ index
					+ "' size='30' maxlength='100'  value=''   onBlur='blngGrpCallLookup(this,document.forms[0].cbCode_"
					+ index
					+ ",this,\"BLNG_GRP_CHARGE_BASED_ITEM\",\""
					+ index
					+ "\");' /><input type='button' class='button' name='serviceLookUp_"
					+ index
					+ "' value='?' onClick=blngGrpCallServices(document.forms[0].cbCode_"
					+ index + ",document.forms[0].cbDesc_" + index
					+ ",'BLNG_GRP_CHARGE_BASED_ITEM',charge_type" + index + ",\"" + index + "\") />";
			cell2.innerHTML = "<input type='checkbox' name='inEx_" + index
					+ "' value='N'  onclick='blngGrpExcludeItem(this,\"" + index
					+ "\");changeSplitReqd(this,\"exclude\",\"" + index
					+ "\");IncludeHomeMedicationBlngGrpExclude(this,cbCode_"+ index + ",charge_type"+ index + ",\""+ index + "\");'/>";
			cell3.innerHTML = "<input type='text' name='quantityLimit_"
					+ index
					+ "' size='15' maxlength='15'  value='' onkeypress=' return allowValidNumber(this,event,\""
					+ noofdecimal + "\");'/>";
			cell4.innerHTML = "<input type='text' name='amountLimit_"
					+ index
					+ "' size='13' maxlength='13' onBlur='checkForNegetiveNumber(this,\""
					+ noofdecimal
					+ "\",\"BL8540\");' onkeypress='return allowValidNumber(this,event,\"10\",\""
					+ noofdecimal + "\")';/>";
			cell5.innerHTML = "<input type='checkbox' name='split_reqd" + index
					+ "' id='split_reqd" + index
					+ "'  checked  value='Y'  onclick='checkSplitReqd(this);'>";
			
			if(siteSpecf == 'true'){
				cell6.innerHTML = "<input type='checkbox' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='N' disabled onclick='checkInclHomeMedi(this);IncludeHomeMedicationUnchkExclude(this,\"blngGrpchargeexclude\",\""+ index + "\");'><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'  >";
			}
			else{
				cell6.innerHTML = "<input type='hidden' name='includeHomeMedication" + index
				+ "' id='includeHomeMedication" + index
				+ "'    value='Y' disabled ><input type='hidden' name='enableDisParam"+index+" ' id='enableDisParam"+index+" ' id='enableDisParam"+index+"' value='Y'>";
			}
			cell7.innerHTML = "<input type='checkbox' name='delCode_" + index
					+ "' value=''   onclick=\"chkBlngGrpDeleteService(this,'"
					+ index + "')\"/>";
			formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
		}
	}
	//Ended By Shikha For GHL-CRF-0520.1
}

// Function for duplicate service/item check
function checkForDuplicate(functionId, item, index) {
	var total_records = 0;
	if ((functionId == "CHARGE_BASED") || (functionId == "RATE_BASED")
			|| (functionId == "PACKAGE_PRICE")) {
		total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
	} else if (functionId == "CUSTOMER" || functionId == "CUST_PRICE"
			|| functionId == "CUST_RATE_BASED"
			|| functionId == "CUST_SRVLIMIT_RATE_BASED"
			|| functionId == "CUST_CHARGE_BASED"
			|| functionId == "CUST_CHARGE_BASED_ITEM"
			|| functionId == "blng_grp_discount"
			|| functionId == "cust_discount"
			//Added By Shikha For GHL-CRF-0520.1
			|| functionId == "BILLINGGROUP" 
			|| functionId == "BLNG_GRP_PRICE"
			|| functionId == "BLNG_GRP_RATE_BASED"
			|| functionId == "BLNG_GRP_SRVLIMIT_RATE_BASED"
			|| functionId == "BLNG_GRP_CHARGE_BASED"
			|| functionId == "BLNG_GRP_CHARGE_BASED_ITEM") {//Ended By Shikha For GHL-CRF-0520.1
		total_records = document.forms[0].totalRecords.value;
	} else {
		total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
	}
	if (total_records > 1) {
		var xmlStr = "<root><SEARCH ";
		for ( var i = 0; i < total_records; i++) {
			if (functionId == "RATE_BASED" || functionId == "CUST_RATE_BASED" || functionId == "BLNG_GRP_RATE_BASED") { //Modified By Shikha For GHL-CRF-0520.1
				if (eval("document.forms[0].service_code" + i) != undefined) {
					xmlStr += "code_" + i + "=\""
							+ eval("document.forms[0].service_code" + i).value
							+ "\" ";
				}
			} else if (functionId == "SRVLIMIT_RATE_BASED"
					|| functionId == "CUST_SRVLIMIT_RATE_BASED" 
					|| functionId == "BLNG_GRP_SRVLIMIT_RATE_BASED" ) { //Modified By Shikha For GHL-CRF-0520.1
				if (eval("document.forms[0].srvLimit_service_code" + i) != undefined)
					xmlStr += "code_"
							+ i
							+ "=\""
							+ eval("document.forms[0].srvLimit_service_code"
									+ i).value + "\" ";
			} else if (functionId == "CUSTOMER") {
				if (eval("document.forms[0].cust_grp_code" + i) != null
						&& eval("document.forms[0].cust_grp_code" + i) != undefined
						&& eval("document.forms[0].cust_code" + i) != null
						&& eval("document.forms[0].cust_code" + i) != undefined)
					xmlStr += "code_" + i + "=\""
							+ eval("document.forms[0].cust_grp_code" + i).value
							+ "~~"
							+ eval("document.forms[0].cust_code" + i).value
							+ "\" ";
			} else if (functionId == "PACKAGE_PRICE"
					|| functionId == "CUST_PRICE"
					|| functionId == "BLNG_GRP_PRICE") { //Modified By Shikha For GHL-CRF-0520.1
				if (eval("document.forms[0].blgClsCode_" + i) != undefined)
					xmlStr += "code_" + i + "=\""
							+ eval("document.forms[0].blgClsCode_" + i).value
							+ "\" ";

			} else if (functionId == "blng_grp_discount") {
				if (eval("document.forms[0].blng_grp_code" + i) != null 
						&& eval("document.forms[0].blng_class_code" + i) != undefined
						&& eval("document.forms[0].eff_from_date" + i) != null)
					xmlStr += "code_"
							+ i
							+ "=\""
							+ eval("document.forms[0].blng_grp_code" + i).value
							+ "~~"
							+ eval("document.forms[0].blng_class_code" + i).value
							+ "~~";
					if(document.forms[0].SiteAgeSpecialty.value == "true" || document.forms[0].SiteAgeSpecialty.value == true) {
						xmlStr += eval("document.forms[0].age_group_code" + i).value
								+ "~~"
								+ eval("document.forms[0].specialty_code" + i).value
								+ "~~";
					}
					xmlStr += eval("document.forms[0].eff_from_date" + i).value
							+ "\" ";
			}  
			//Added By Shikha For GHL-CRF-0520.1
			else if (functionId == "BILLINGGROUP") {
				if (eval("document.forms[0].blng_grp_code" + i) != null
						&& eval("document.forms[0].blng_grp_code" + i) != undefined)
					xmlStr += "code_" + i + "=\""
							+ eval("document.forms[0].blng_grp_code" + i).value
							+ "\" ";
			} else {
				if (eval("document.forms[0].cbCode_" + i) != undefined)
					xmlStr += "code_" + i + "=\""
							+ eval("document.forms[0].cbCode_" + i).value
							+ "\" ";
			}

		}
		xmlStr += "item=\"" + item + "\" ";
		xmlStr += "functionId=\"" + functionId + "\" ";
		xmlStr += "index=\"" + index + "\" ";
		xmlStr += "total_records=\"" + total_records + "\" ";
		xmlStr += " /></root>";

		var updation = formValidation(xmlStr, "DUPLICATE_CHECK");
	} else if (functionId == "CHARGE_BASED") {

		loadChargeBasedServiceLimit(document.forms[0].cbCode_0.value, index)
	}
}
// Duplicate Alert if the serveice/item duplicates
function duplicateAlert(index, functionId) {
	// clearRow(document.forms[0],index);

	if (functionId == "PACKAGE_PRICE" || functionId == "CUST_PRICE" || functionId == "BLNG_GRP_PRICE"  //Modified By Shikha For GHL-CRF-0520.1
			|| functionId == "blng_grp_discount"
			|| functionId == "cust_discount") {
		alert(getMessage("DUPLICATE_CODE_EXISTS", "Common"));

	} else if (functionId == "RATE_BASED" || functionId == "CUST_RATE_BASED"  || functionId == "BLNG_GRP_RATE_BASED") { //Modified By Shikha For GHL-CRF-0520.1

		alert(getMessage("BL8563", "BL"));
		eval("document.forms[0].service_desc" + index).value = "";
		eval("document.forms[0].service_code" + index).value = "";

	} else if (functionId == "SRVLIMIT_RATE_BASED"
			|| functionId == "CUST_SRVLIMIT_RATE_BASED"
			|| functionId == "BLNG_GRP_SRVLIMIT_RATE_BASED"	) { //Modified By Shikha For GHL-CRF-0520.1
		alert(getMessage("BL8563", "BL"));
		eval("document.forms[0].srvLimit_service_code" + index).value = "";
		eval("document.forms[0].srvLimit_service_desc" + index).value = "";
		// alert(getMessage("BL8563","BL"));

	} else {

		if (functionId == "CHARGE_BASED_ITEM"
				|| functionId == "CUST_CHARGE_BASED_ITEM"
				|| functionId == "BLNG_GRP_CHARGE_BASED_ITEM") { //Modified By Shikha For GHL-CRF-0520.1
			eval("document.forms[0].cbCode_" + index).value = "";
			eval("document.forms[0].cbDesc_" + index).value = "";
			alert(getMessage("BL8567", "BL"));
		} else if (functionId == "CUSTOMER") {
			alert(getMessage("BL8600", "BL"));
		} else if (functionId == "BILLINGGROUP") {
			alert(getMessage("BL6501", "BL"));
		}else {
			eval("document.forms[0].cbCode_" + index).value = "";
			eval("document.forms[0].cbDesc_" + index).value = "";
			alert(getMessage("BL8563", "BL"));
		}

	}
	clearRow(document.forms[0], index);
}
// Auto Order Catalog
// function checkForOrderAssociated()
function initializeHdrFlds() {
	if (document.frmPkgDefHeader.mode.value != "modify")
		document.forms[0].packageCode.focus();
	// if((document.forms[0].OpYn.value=="Y") &&
	// document.forms[0].EmYn.value=="N" && document.forms[0].IpYn.value=="N" &&
	// document.forms[0].DcYn.value=="N")
	// if(document.forms[0].OpYn.value=="Y" || document.forms[0].EmYn.value=="Y"
	// && document.forms[0].IpYn.value=="Y" &&
	// document.forms[0].DcYn.value=="Y")
	//
	// {
	document.getElementById("autocheck").style.display = "inline";
	document.getElementById("autocheck1").style.display = "inline";

	// }
	// else
	// {
	// document.getElementById("autocheck").style.display = "none";
	// document.getElementById("autocheck1").style.display = "none";
	// document.forms[0].orderAssociated.checked = false;
	// document.forms[0].orderAssociated.value = "N";
	// }

	if (document.frmPkgDefHeader.applicalbleTo.value == "A"
			|| document.frmPkgDefHeader.applicalbleTo.value == "") {
		if (document.frmPkgDefTab != null) {
			parent.frames[0].document.getElementById("CUSTOMER").disabled = true;
		}
	}

}

// Function OnCheck of orderAssociated
function orderAssociatedCheck(obj, mode) {
	//Added by Nandhini against NMC-JD-CRF-0150.1
/*	var acrossEncounters = document.forms[0].acrossEncounters.value;
	if (mode == "modify") {
		if (obj.checked) {
			obj.checked = false;
		} else
			obj.checked = true;
	} else {
		if (obj.checked) {
			obj.value = "Y";
			// Modified by muthu against 31103 on 5/3/2012 Starts here
			if (obj.value == "Y" && acrossEncounters != "Y") {
				document.forms[0].validDays.value = "1";
				// document.forms[0].validDays.readOnly = true;
			}
			// Modified by muthu against 31103 on 5/3/2012 Starts here
			
			//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated/Starts
			if(parent.PkgDefDetailFrame.rate_based_dtl != undefined && parent.PkgDefDetailFrame.rate_based_dtl != null) {
				if(parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl != undefined 
						&& parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl != null) {
					if(parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl.dailyLimitSiteSpec.value == 'true') {
						var formObj=parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl;
						for(var cnt = 0; cnt < formObj.totalRecords.value; cnt++) {
							eval("formObj.dailyLmtChkBx"+cnt).checked = false;
							
							eval("formObj.dailyLmtChkBx"+cnt).value = '';
							eval("formObj.dailyLmtAmt"+cnt).value = '';
							eval("formObj.dailyLmtGrossNetList"+cnt).value = '';
							
							eval("formObj.dailyLmtChkBx"+cnt).disabled = true;
							eval("formObj.dailyLmtAmt"+cnt).disabled = true;
							eval("formObj.dailyLmtGrossNetList"+cnt).disabled = true;
						}
					}
				}
			}
			//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated/Ends
		} else {
			obj.value = "N";
		}
	}
	*/
	var acrossEncounters = document.forms[0].acrossEncounters;
	var pkgAcrossEnctrYN=document.forms[0].pkgAcrossEnctrYN.value;
	//alert(obj.checked)
	//alert(obj.value)
	if (mode == "modify") {
		if (obj.checked) {
			obj.value = "Y";
			obj.checked = true;
			acrossEncounters.disabled=false;
			
			//31072
			document.forms[0].IpYn.disabled = true;
			document.forms[0].DcYn.disabled = true;
			document.forms[0].EmYn.disabled = true;
			document.forms[0].AllYn.disabled = true;
		} else{
			obj.value = "N";
			obj.checked = false;
			acrossEncounters.value="N";
			acrossEncounters.checked=false;
			acrossEncounters.disabled=true;
			
			//31072
			document.forms[0].IpYn.disabled = false;
			document.forms[0].DcYn.disabled = false;
			document.forms[0].EmYn.disabled = false;
			document.forms[0].AllYn.disabled = false;
		}
		//alert("modify-ordassoc-"+obj.value);
	} else {
		if (obj.checked) {
			obj.value = "Y";
			//31072
			document.forms[0].IpYn.disabled = true;
			document.forms[0].DcYn.disabled = true;
			document.forms[0].EmYn.disabled = true;
			document.forms[0].AllYn.disabled = true;
			if(obj.checked && pkgAcrossEnctrYN == "Y"){
			acrossEncounters.disabled=false;
			}
			// Modified by muthu against 31103 on 5/3/2012 Starts here
			if (obj.value == "Y" && acrossEncounters.value != "Y") {
				document.forms[0].validDays.value = "1";
				// document.forms[0].validDays.readOnly = true;
			}
			// Modified by muthu against 31103 on 5/3/2012 Starts here
			
			//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated/Starts
			if(parent.PkgDefDetailFrame.rate_based_dtl != undefined && parent.PkgDefDetailFrame.rate_based_dtl != null) {
				if(parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl != undefined 
						&& parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl != null) {
					if(parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl.dailyLimitSiteSpec.value == 'true') {
						var formObj=parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl;
						for(var cnt = 0; cnt < formObj.totalRecords.value; cnt++) {
							eval("formObj.dailyLmtChkBx"+cnt).checked = false;
							
							eval("formObj.dailyLmtChkBx"+cnt).value = '';
							eval("formObj.dailyLmtAmt"+cnt).value = '';
							eval("formObj.dailyLmtGrossNetList"+cnt).value = '';
							
							eval("formObj.dailyLmtChkBx"+cnt).disabled = true;
							eval("formObj.dailyLmtAmt"+cnt).disabled = true;
							eval("formObj.dailyLmtGrossNetList"+cnt).disabled = true;
						}
					}
				}
			}
			//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated/Ends
		} else {
			obj.value = "N";
			//newly added by Nandhini for NMC-JD-CRF-0150.1
			if(pkgAcrossEnctrYN == "Y"){
			acrossEncounters.value="N";
			acrossEncounters.checked=false;
			acrossEncounters.disabled=true;
			}
			else{			
			acrossEncounters.disabled=false;
			}
			
			//31072
			document.forms[0].IpYn.disabled = false;
			document.forms[0].DcYn.disabled = false;
			document.forms[0].EmYn.disabled = false;
			document.forms[0].AllYn.disabled = false;
		}
	}
}

// Function to get all selected service code
function getServiceCodes(formObj, last_link, source) {
	var total_records = 0;
	var xmlStr = "";
	if (eval(formObj) == undefined) {

		if (parent.length < 4 || parent.frames[3] == undefined)
			formObj = parent.parent.frames[3].frames[0].document.forms[0];
		else
			formObj = parent.frames[3].frames[0].document.forms[0];
	}

	if (source == "apply")
		total_records = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
	else if (source == "maintab")
		total_records = parent.frames[1].frames[0].document.frmPkgDefHeader.total_records.value;
	else {

		if (parent.parent.PkgDefHeader == undefined)
			total_records = parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
		else
			total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
	}
	if (total_records > 0) {
		for ( var i = 0; i < total_records; i++) {
			if (last_link == "SRVLIMIT_RATE_BASED") {
				if (eval("formObj.service_code" + i) != undefined)   //Modified By Vijay For GHL Internal Changes
					{
				
					xmlStr += "code_" + i + "=\""
							+ eval("formObj.service_code" + i).value + "\" ";
						
					}
				} else if (last_link == "CHARGE_BASED_ITEM")
				if (eval("formObj.cbCode_" + i) != undefined)
					xmlStr += "code_" + i + "=\""
							+ eval("formObj.cbCode_" + i).value + "\" ";

		}
		xmlStr += "recordCount=\"" + total_records + "\" ";
		return xmlStr;
	}
}
// Load Blank
function loadBalnk() {
	parent.ChargeBasedExCln.location.href = '../../eCommon/html/blank.html';
	parent.ChargeBasedItemBtn.location.href = '../../eCommon/html/blank.html';
}

// Mandatory Check for Charge based
function validateChargeBased(formObj, totalRec) {
	var message = "";
	for ( var i = 0; i < totalRec; i++) { 
											
		if (eval("formObj.cbCode_" + i) != undefined
				&& eval("formObj.cbCode_" + i).value != "") { 
			if ((eval("formObj.amt_limit_ind" + i).value) != "U") {
				if (eval("formObj.perAmt_limit" + i).value == "") {
					// ert("Please enter amount")
					alert(getMessage("BL8541", "BL"));
					eval("formObj.perAmt_limit" + i).focus();
					return false;
				}
			}
			if (eval("formObj.roundTo_" + i).value == null
					|| eval("formObj.roundTo_" + i).value == ""
					|| eval("formObj.roundTo_" + i).value == "10"
					|| eval("formObj.roundTo_" + i).value == "50"
					|| eval("formObj.roundTo_" + i).value == "100"
					|| eval("formObj.roundTo_" + i).value == "500"
					|| eval("formObj.roundTo_" + i).value == "1000") {
				message = "";
			} else {
				message = getMessage("BL8681", 'BL');
				obj = eval("formObj.roundTo_" + i);
			}
			if (message != "") {
				// messageFrame.location.href =
				// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				alert(message);
				obj.focus();
				return false
			}
		}
	}
	return true;
}

// Mandatory Check for Charge based items
function validateChargeBasedItems(formObj, totalRec) {
	for ( var i = 0; i < totalRec; i++) {
		if ((eval("formObj.cbCode_" + i)) != undefined
				&& (eval("formObj.cbCode_" + i).value) != "") {
			if ((eval("formObj.inEx_" + i).value) == "N") {
				if ((eval("formObj.quantityLimit_" + i).value) == ""
						&& (eval("formObj.amountLimit_" + i).value) == "") {
					// alert("Please enter amount");
					alert(getMessage("BL8541", "BL"));

					eval("formObj.quantityLimit_" + i).focus();
					return false;
				}

			}
		}
	}
	return true;

}

function showLmtDetails(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
		eval(document.getElementById("srvLmtDtls_" + index)).style.display = "inline";
	} else {
		obj.value = "N";
		eval(document.getElementById("srvLmtDtls_" + index)).style.display = "none";
		parent.ChargeBasedExCln.location.href = '../../eCommon/html/blank.html';
		parent.ChargeBasedItemBtn.location.href = '../../eCommon/html/blank.html';
	}

}

/** *************** rate based validations********start***** */
function clearRow(formObj, index) {
	if (formObj.name == "rate_based_dtl") {
		eval("formObj.catalog_code" + index).value = "";
		eval("formObj.catalog_desc" + index).value = "";
		eval("formObj.catalog_desc_temp" + index).value = "";
		eval("formObj.factorOrRate" + index).value = "";
		eval("formObj.qty_limit" + index).value = "";
		eval("formObj.qty_limit" + index).disabled = true;

		eval("formObj.ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.roundTo" + index).value = "";
		eval("formObj.roundInd" + index).selectedIndex = 0;

		eval("formObj.perAmt_limit" + index).value = "";

		eval("formObj.replace" + index).checked = false;
		eval("formObj.refund" + index).checked = false;
		chkReplace(eval("formObj.replace" + index), index);
		chkRefund(eval("formObj.replace" + index), index);
		eval("formObj.replace" + index).disabled = true;
		eval("formObj.refund" + index).disabled = true;
		if (eval("formObj.factor_appl" + index) != undefined) {
			eval("formObj.factor_appl" + index).value = "";
			eval("formObj.factor_appl" + index).checked = false;
			eval("formObj.factor_appl" + index).disabled = true;
		}
		eval("formObj.service_limit" + index).checked = false;
		eval("formObj.service_limit" + index).disabled = true;
		document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
				.cells(20).innerHTML = "<input type='checkbox'   name='service_limit" //sarathkumar InclHmeMedi 1+
				+ index
				+ "' disabled onClick='chkServiceLimit(this,\""
				+ index
				+ "\")' value='N'/>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)
		//Modified by Ram MMS-QH-CRF-170  cells(19)-->cells(20) & V201125

		// commented 2 lines added new by ram
		// parent.frames[2].location.href="../../eCommon/html/blank.html";
		// parent.frames[3].location.href="../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		parent.frames[5].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "srvLimit_rate_based_dtl") {
		eval("formObj.exludeService" + index).value = "";
		eval("formObj.exludeService" + index).checked = false;
		eval("formObj.exludeService" + index).disabled = true;
		eval("formObj.srvLimit_qty_limit" + index).value = "";
		eval("formObj.srvLimit_qty_limit" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.srvLimit_amt_limit_ind" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit" + index).value = "";
		eval("formObj.srvLimit_amt_limit" + index).disabled = true;
		eval("formObj.srvLimit_roundInd" + index).disabled = true;
		eval("formObj.srvLimit_roundTo" + index).value = "";
		eval("formObj.srvLimit_roundTo" + index).disabled = true;
		eval("formObj.srvLimit_factor_appl" + index).value = "";
		if (eval("formObj.srvLimit_factor_appl" + index) != undefined) {
			eval("formObj.srvLimit_factor_appl" + index).checked = false;
			eval("formObj.srvLimit_factor_appl" + index).disabled = true;
		}
	} else if (formObj.name == "frmPkgDefChargeBased") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.perAmt_limit" + index).value = "";
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).value = "";

	} else if (formObj.name == "frmPkgDefChargeBasedExcln") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.inEx_" + index).selectedIndex = 1;
		eval("formObj.quantityLimit_" + index).value = "";
		eval("formObj.amountLimit_" + index).value = "";
	} else if (formObj.name == "frmPkgDefBasePrice") {
		eval("formObj.blgClsCode_" + index).value = "";
		eval("formObj.blgClsDesc_" + index).value = "";
		eval("formObj.indicator_" + index).selectedIndex = 0;
		eval("formObj.price_" + index).value = "";
		eval("formObj.roundTo_" + index).value = "";
		eval("formObj.roundInd_" + index).selectedIndex = 0;
		if (eval("formObj.factorAppl_" + index) != undefined) {
			eval("formObj.factorAppl_" + index).value = "N";
			eval("formObj.factorAppl_" + index).disabled = true;
			eval("formObj.factorAppl_" + index).checked = false;
		}
	} else if (formObj.name == "cust_dtls") {
		eval("formObj.cust_grp_code" + index).value = "";
		eval("formObj.cust_grp_desc" + index).value = "";
		eval("formObj.cust_grp_code_temp" + index).value = "";
		eval("formObj.cust_grp_desc_temp" + index).value = "";
		eval("formObj.cust_code" + index).value = "";
		eval("formObj.cust_desc" + index).value = "";
		eval("formObj.cust_code_temp" + index).value = "";
		eval("formObj.cust_desc_temp" + index).value = "";
		eval("formObj.pkg_valid_days" + index).value = "";
		// eval("formObj.oldKey"+index).value="";

		parent.parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.parent.frames[4].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "cust_base_price_dtl") {
		eval("formObj.blgClsCode_" + index).value = "";
		eval("formObj.blgClsDesc_" + index).value = "";
		eval("formObj.indicator_" + index).selectedIndex = 0;
		eval("formObj.price_" + index).value = "";
		eval("formObj.roundTo_" + index).value = "";
		eval("formObj.roundInd_" + index).selectedIndex = 0;
		if (eval("formObj.factorAppl_" + index) != undefined) {
			eval("formObj.factorAppl_" + index).value = "N";
			eval("formObj.factorAppl_" + index).disabled = true;
			eval("formObj.factorAppl_" + index).checked = false;
		}

	} else if (formObj.name == "cust_rate_based_dtl") {
		eval("formObj.catalog_code" + index).value = "";
		eval("formObj.catalog_desc" + index).value = "";
		eval("formObj.catalog_desc_temp" + index).value = "";
		eval("formObj.factorOrRate" + index).value = "";
		eval("formObj.qty_limit" + index).value = "";
		eval("formObj.qty_limit" + index).disabled = true;

		eval("formObj.ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.roundTo" + index).value = "";
		eval("formObj.roundInd" + index).selectedIndex = 0;

		eval("formObj.perAmt_limit" + index).value = "";
		/*
		 * eval("formObj.amt_percentage"+index).value="";
		 * eval("formObj.amt_limit"+index).value="";
		 */
		/*
		 * eval("formObj.amt_percentage"+index).disabled=true;
		 * eval("formObj.amt_limit"+index).disabled=true;
		 * eval("formObj.unlimited"+index).checked=false;
		 */
		eval("formObj.replace" + index).checked = false;
		eval("formObj.refund" + index).checked = false;
		// eval("formObj.unlimited"+index).disabled=true;
		chkCustReplace(eval("formObj.replace" + index), index);
		chkCustRefund(eval("formObj.replace" + index), index);
		eval("formObj.replace" + index).disabled = true;
		eval("formObj.refund" + index).disabled = true;
		if (eval("formObj.factor_appl" + index) != undefined) {
			eval("formObj.factor_appl" + index).value = "";
			eval("formObj.factor_appl" + index).checked = false;
			eval("formObj.factor_appl" + index).disabled = true;
		}
		// eval("formObj.service_limit"+index).checked=false;
		// eval("formObj.service_limit"+index).disabled=true;
		document.getElementById('cust_rate_based_tbl')
				.rows(parseInt(index) + 2).cells(20).innerHTML = "<a name='service_limit_dtls"
				+ i
				+ "' href='#' onClick='custServiceLimitDtls("
				+ i
				+ ")'  disabled>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)
		//Modified by Ram MMS-QH-CRF-170  cells(19)-->cells(20) & V201125

		/*
		 * parent.frames[2].location.href="../../eCommon/html/blank.html";
		 * parent.frames[3].location.href="../../eCommon/html/blank.html";
		 * COMMENTED AND ADDED NEW LINES BY RAM
		 */
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		parent.frames[5].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "cust_srvLimit_rate_based_dtl") {
		eval("formObj.exludeService" + index).value = "";
		eval("formObj.exludeService" + index).disabled = true;
		eval("formObj.srvLimit_qty_limit" + index).value = "";
		eval("formObj.srvLimit_qty_limit" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit" + index).value = "";
		eval("formObj.srvLimit_amt_limit" + index).disabled = true;
		eval("formObj.srvLimit_factor_appl" + index).value = "";

		if (eval("formObj.srvLimit_factor_appl" + index) != undefined) {
			eval("formObj.srvLimit_factor_appl" + index).checked = false;
			eval("formObj.srvLimit_factor_appl" + index).disabled = true;
		}
	} else if (formObj.name == "cust_charge_based_dtl") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.perAmt_limit" + index).value = "";
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).value = "";

		// parent.frames[2].location.href="../../eCommon/html/blank.html";
		// commented and added new lines RAM
		// parent.frames[3].location.href="../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		parent.frames[5].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "cust_charge_based_excl_dtl") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.inEx_" + index).selectedIndex = 1;
		eval("formObj.quantityLimit_" + index).value = "";
		eval("formObj.amountLimit_" + index).value = "";
	} else if (formObj.name == "cust_discount_dtl") {
		eval("formObj.cust_grp_code" + index).value = "";
		eval("formObj.cust_grp_desc" + index).value = "";
		eval("formObj.cust_code" + index).value = "";
		eval("formObj.cust_desc" + index).value = "";
		eval("formObj.blng_class_code" + index).value = "";
		eval("formObj.blng_class_desc" + index).value = "";
		eval("formObj.eff_from_date" + index).value = "";
		eval("formObj.eff_to_date" + index).value = "";
		eval("formObj.discount_type" + index).selectedIndex = 0;
		eval("formObj.discount" + index).value = "";
	} else if (formObj.name == "cust_discount_dtl") {
		eval("formObj.cust_grp_code" + index).value = "";
		eval("formObj.cust_grp_desc" + index).value = "";
		eval("formObj.cust_grp_code_temp" + index).value = "";
		eval("formObj.cust_grp_desc_temp" + index).value = "";
		eval("formObj.cust_code" + index).value = "";
		eval("formObj.cust_desc" + index).value = "";
		eval("formObj.cust_code_temp" + index).value = "";
		eval("formObj.cust_desc_temp" + index).value = "";
		eval("formObj.blng_class_code" + index).value = "";
		eval("formObj.blng_class_desc" + index).value = "";
		eval("formObj.blng_class_code_temp" + index).value = "";
		eval("formObj.blng_class_desc_temp" + index).value = "";
		eval("formObj.eff_from_date" + index).value = "";
		eval("formObj.eff_to_date" + index).value = "";
		eval("formObj.discount_type" + index).selectedIndex = 0;
		eval("formObj.discount" + index).value = "";
	} else if (formObj.name == "blng_grp_discount_dtl") {
		eval("formObj.blng_grp_code" + index).value = "";
		eval("formObj.blng_grp_desc" + index).value = "";
		eval("formObj.blng_grp_code_temp" + index).value = "";
		eval("formObj.blng_grp_desc_temp" + index).value = "";
		eval("formObj.blng_class_code" + index).value = "";
		eval("formObj.blng_class_desc" + index).value = "";
		eval("formObj.blng_class_code_temp" + index).value = "";
		eval("formObj.blng_class_desc_temp" + index).value = "";
		eval("formObj.eff_from_date" + index).value = "";
		eval("formObj.eff_to_date" + index).value = "";
		eval("formObj.discount_type" + index).selectedIndex = 0;
		eval("formObj.discount" + index).value = "";
	}
	//Added By Shikha For GHL-CRF-0520.1
	else if (formObj.name == "blng_grp_dtls") {
		eval("formObj.blng_grp_code" + index).value = "";
		eval("formObj.blng_grp_desc" + index).value = "";
		eval("formObj.blng_grp_code_temp" + index).value = "";
		eval("formObj.blng_grp_desc_temp" + index).value = "";
		eval("formObj.pkg_valid_days" + index).value = "";
		parent.parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.parent.frames[4].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "blng_grp_base_price_dtl") {
		eval("formObj.blgClsCode_" + index).value = "";
		eval("formObj.blgClsDesc_" + index).value = "";
		eval("formObj.indicator_" + index).selectedIndex = 0;
		eval("formObj.price_" + index).value = "";
		eval("formObj.roundTo_" + index).value = "";
		eval("formObj.roundInd_" + index).selectedIndex = 0;
		if (eval("formObj.factorAppl_" + index) != undefined) {
			eval("formObj.factorAppl_" + index).value = "N";
			eval("formObj.factorAppl_" + index).disabled = true;
			eval("formObj.factorAppl_" + index).checked = false;
		}
	} else if (formObj.name == "blng_grp_rate_based_dtl") {		
		eval("formObj.catalog_code" + index).value = "";
		eval("formObj.catalog_desc" + index).value = "";
		eval("formObj.catalog_desc_temp" + index).value = "";
		eval("formObj.factorOrRate" + index).value = "";
		eval("formObj.qty_limit" + index).value = "";
		eval("formObj.qty_limit" + index).disabled = true;
		eval("formObj.ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.roundTo" + index).value = "";
		eval("formObj.roundInd" + index).selectedIndex = 0;
		eval("formObj.perAmt_limit" + index).value = "";
		eval("formObj.replace" + index).checked = false;
		eval("formObj.refund" + index).checked = false;
		chkBlngGrpReplace(eval("formObj.replace" + index), index);		
		chkBlngGrpRefund(eval("formObj.replace" + index), index);		
		eval("formObj.replace" + index).disabled = true;
		eval("formObj.refund" + index).disabled = true;
		if (eval("formObj.factor_appl" + index) != undefined) {
			eval("formObj.factor_appl" + index).value = "";
			eval("formObj.factor_appl" + index).checked = false;
			eval("formObj.factor_appl" + index).disabled = true;
		}		
		document.getElementById('blng_grp_rate_based_tbl')
				.rows(parseInt(index) + 2).cells(19).innerHTML = "<a name='service_limit_dtls"
				+ i
				+ "' href='#' onClick='blngGrpServiceLimitDtls("
				+ i
				+ ")'  disabled>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)		
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		parent.frames[5].location.href = "../../eCommon/html/blank.html";		
	} else if (formObj.name == "blng_grp_srvLimit_rate_based_dtl") {
		eval("formObj.exludeService" + index).value = "";
		eval("formObj.exludeService" + index).disabled = true;
		eval("formObj.srvLimit_qty_limit" + index).value = "";
		eval("formObj.srvLimit_qty_limit" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit" + index).value = "";
		eval("formObj.srvLimit_amt_limit" + index).disabled = true;
		eval("formObj.srvLimit_factor_appl" + index).value = "";
		if (eval("formObj.srvLimit_factor_appl" + index) != undefined) {
			eval("formObj.srvLimit_factor_appl" + index).checked = false;
			eval("formObj.srvLimit_factor_appl" + index).disabled = true;
		}
	} else if (formObj.name == "blng_grp_charge_based_dtl") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.perAmt_limit" + index).value = "";
		eval("formObj.amt_limit_ind" + index).selectedIndex = 0;
		eval("formObj.amt_limit_ind" + index).value = "";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		parent.frames[5].location.href = "../../eCommon/html/blank.html";
	} else if (formObj.name == "blng_grp_charge_based_excl_dtl") {
		eval("formObj.cbCode_" + index).value = "";
		eval("formObj.cbDesc_" + index).value = "";
		eval("formObj.cbCodePrev_" + index).value = "";
		eval("formObj.cbDescPrev_" + index).value = "";
		eval("formObj.inEx_" + index).selectedIndex = 1;
		eval("formObj.quantityLimit_" + index).value = "";
		eval("formObj.amountLimit_" + index).value = "";
	}
	//Ended By Shikha For GHL-CRF-0520.1
}
function initializeRateForm() {

	formObj = document.rate_based_dtl;
	table = document.getElementById('rate_based_tbl');
	rowCount = table.rows.length;
	index = rowCount - 1;
	mode = formObj.mode.value;
	acrossEncounters = formObj.acrossEncounters.value;
	copyFrm_pkgCode = "";
	from = formObj.from.value;
	if (from == "PACKAGE")
		copyFrm_pkgCode = parent.parent.frames[0].document.frmPkgDefHeader.copyFrm_pkgCode.value;
	// if(mode!="modify" && copyFrm_pkgCode==""){
	if (mode == "insert" && copyFrm_pkgCode == ""
			&& formObj.service_code0.value == "") {

		for ( var i = 0; i < index; i++) {
			if ((eval("formObj.type" + i).value == "G")
					|| (eval("formObj.type" + i).value == "C")) {
				if (eval("formObj.service_code" + i).value == "") {
					eval("formObj.qty_limit" + i).disabled = true;
				}
				document.getElementById('rate_based_tbl').rows(parseInt(i) + 1)
						.cells(3).innerHTML = "<SELECT  NAME='ind" + i
						+ "' onChange='onIndChange(this,\"" + i
						+ "\")'><option value='S'>"
						+ getLabel('Common.Standard.label', 'Common')
						+ "</option><option value='R'>"
						+ getLabel('eBL.AsPerRule.label', 'BL')
						+ "</option><option value='P'>"
						+ getLabel('eBL.PRICE_CLASS.label', 'BL')
						+ "</option></select>";
			} else {
				eval("formObj.qty_limit" + i).disabled = false;
				document.getElementById('rate_based_tbl').rows(parseInt(i) + 1)
						.cells(3).innerHTML = "<SELECT  NAME='ind" + i
						+ "' onChange='onIndChange(this,\"" + i
						+ "\")'><option value='S'>"
						+ getLabel('Common.Standard.label', 'Common')
						+ "</option><option value='R'>"
						+ getLabel('eBL.AsPerRule.label', 'BL')
						+ "</option><option value='U'>"
						+ getLabel('Common.UserDefined.label', 'Common')
						+ "</option><option value='P'>"
						+ getLabel('eBL.PRICE_CLASS.label', 'BL')
						+ "</option></select>";
				if (acrossEncounters == "Y") {
					document.getElementById('rate_based_tbl').rows( //sarathkumar InclHmeMedi +1
							parseInt(i) + 1).cells(19).innerHTML = "<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""
							+ i
							+ "\")'/><input type='hidden' name='closePkg"
							+ i + "' value='N' />";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)
							//Ram Modified From cells(18)->cells(19)
				}
			}
		}
	} else {
		for ( var i = 0; i < index; i++) {
			// if((eval("formObj.type"+i).value=="G") ||
			// (eval("formObj.type"+i).value=="C")){
			if ((eval("formObj.type" + i).value == "G")
					|| (eval("formObj.type" + i).value == "C")
					|| (eval("formObj.type" + i).value == "P")) {
				eval("formObj.replace" + i).value = "N";
				eval("formObj.replace" + i).checked = false;
				eval("formObj.replace" + i).disabled = true;
				eval("formObj.refund" + i).value = "N";
				eval("formObj.refund" + i).checked = false;
				eval("formObj.refund" + i).disabled = true;
				eval("formObj.autoRefund" + i).value = "N";
				eval("formObj.autoRefund" + i).checked = false;
				eval("formObj.autoRefund" + i).disabled = true;
			} else {
				eval("formObj.service_limit" + i).disabled = true;
			} // alert(formObj.order_associated.value)
			if (formObj.order_associated.value == "Y") {
				eval("formObj.perAmt_limit" + i).disabled = true;
				/*
				 * eval("formObj.amt_percentage"+i).disabled=true;
				 * eval("formObj.amt_limit"+i).disabled=true;
				 * eval("formObj.unlimited"+i).disabled=true;
				 */
				eval("formObj.service_limit" + i).disabled = true;

			} else {

				// eval("formObj.perAmt_limit"+i).disabled=false;
				/*
				 * eval("formObj.amt_percentage"+i).disabled=false;
				 * eval("formObj.amt_limit"+i).disabled=false;
				 * eval("formObj.unlimited"+i).disabled=false;
				 */
			}
			if ((formObj.mode.value == "modify" && formObj.authorized.value == "Y")
					&& eval("formObj.amt_limit_ind" + i).value == "A") {

				eval("formObj.perAmt_limit" + i).disabled = false;
				eval("formObj.factor_appl" + i).disabled = false;
			} else if (eval("formObj.amt_limit_ind" + i).value == "U") {
				eval("formObj.qty_limit" + i).value = "";
				eval("formObj.qty_limit" + i).disabled = true;
				eval("formObj.factor_appl" + i).value = "N";
				eval("formObj.factor_appl" + i).checked = false;
				eval("formObj.factor_appl" + i).disabled = true;
				eval("formObj.perAmt_limit" + i).disabled = true;
			} else if (eval("formObj.amt_limit_ind" + i).value == "") {
				eval("formObj.factor_appl" + i).value = "N";
				eval("formObj.factor_appl" + i).checked = false;
				eval("formObj.factor_appl" + i).disabled = true;
				eval("formObj.perAmt_limit" + i).disabled = true;
			} else if (eval("formObj.amt_limit_ind" + i).value == "P") {
				eval("formObj.factor_appl" + i).value = "N";
				eval("formObj.factor_appl" + i).checked = false;
				eval("formObj.factor_appl" + i).disabled = true;
				if (formObj.mode.value == "modify"
						&& formObj.authorized.value == "Y")
					eval("formObj.perAmt_limit" + i).disabled = false;
			}

			/*
			 * if(eval("formObj.amt_percentage"+i).value!=""){
			 * eval("formObj.amt_limit"+i).value="";
			 * eval("formObj.amt_limit"+i).disabled=true;
			 * eval("formObj.factor_appl"+i).value="";
			 * eval("formObj.factor_appl"+i).checked=false;
			 * eval("formObj.factor_appl"+i).disabled=true; }
			 * if(eval("formObj.amt_limit"+i).value!=""){
			 * eval("formObj.amt_percentage"+i).value="";
			 * eval("formObj.amt_percentage"+i).disabled=true;
			 * if(eval("formObj.amt_limit"+i).value>0){
			 * eval("formObj.factor_appl"+i).disabled=false; }else{
			 * eval("formObj.factor_appl"+i).disabled=true; } }else{
			 * eval("formObj.factor_appl"+i).disabled=true; }
			 * if(eval("formObj.unlimited"+i).checked){
			 * 
			 * eval("formObj.qty_limit"+i).value="";
			 * eval("formObj.qty_limit"+i).disabled=true;
			 * eval("formObj.amt_percentage"+i).value="";
			 * eval("formObj.amt_percentage"+i).disabled=true;
			 * eval("formObj.amt_limit"+i).value="";
			 * eval("formObj.amt_limit"+i).disabled=true;
			 * eval("formObj.factor_appl"+i).value="";
			 * eval("formObj.factor_appl"+i).checked=false;
			 * eval("formObj.factor_appl"+i).disabled=true;
			 *  }
			 */
		}
	}
}

function onServiceTypeChange(obj, index) {
    var result = true;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
    var servGrpLimitSiteSpec = eval("document.rate_based_dtl.servGrpLimitSiteSpec").value;
    var servGrpLmtBy  = eval("document.rate_based_dtl.servGrpLmtBy").value;
    var servGrpLmtFldDisabled = eval("document.rate_based_dtl.servGrpLmtFldDisabled").value;
    var order_associated = eval("document.rate_based_dtl.order_associated").value;	 //Added IN73730 by shikha on 19-Aug-2020
    var amt_limit_ind = eval("document.rate_based_dtl.amt_limit_ind"+index).value;	//Added IN73662 by shikha on 21-Aug-2020
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	if (parent.frames[4].document.forms[0] != null) {
		// frame ref parent.frames[2] to parent.frames[4] changed by ram
		result = validateServiceLimitForm(
				parent.frames[4].document.srvLimit_rate_based_dtl,
				parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,
				index,
				'',
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value);
	}
	if (result) {

		clearRow(document.forms[0], index); 
		if (document.rate_based_dtl.acrossEncounters.value == "Y"
				&& obj.value == "S") {
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
					.cells(19).innerHTML = "<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"
					+ index
					+ "')\"/><input type='hidden' name='closePkg"
					+ index + "' value='' />";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)
					//Ram Modified From cells(18)->cells(19)
		} else {
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
					.cells(19).innerHTML = "<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"
					+ index
					+ "')\" disabled/><input type='hidden' name='closePkg"
					+ index + "' value='' />";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)
					//Ram Modified From cells(18)->cells(19)
		}
		eval("document.rate_based_dtl.service_code" + index).value = "";
		eval("document.rate_based_dtl.service_desc" + index).value = "";
		eval("document.rate_based_dtl.service_desc_temp" + index).value = "";
		if (obj.value == "G" || obj.value == "C") {
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
					.cells(3).innerHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";

		} else {
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
					.cells(3).innerHTML = "<SELECT  NAME='ind" + index
					+ "' onChange='onIndChange(this,\"" + index
					+ "\")'><option value='S'>"
					+ getLabel('Common.Standard.label', 'Common')
					+ "</option><option value='R'>"
					+ getLabel('eBL.AsPerRule.label', 'BL')
					+ "</option><option value='U'>"
					+ getLabel('Common.UserDefined.label', 'Common')
					+ "</option><option value='P'>"
					+ getLabel('eBL.PRICE_CLASS.label', 'BL')
					+ "</option></select>";

		}		
		//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		if ((servGrpLimitSiteSpec == "true" && obj.value == "S") || order_associated == "Y" || amt_limit_ind == "U"){//|| servGrpLmtFldDisabled ==' disabled '){					//Modified IN73730 by shikha on 19-Aug-2020
			eval("document.rate_based_dtl.serv_grp_limit_ind" + index).disabled = true;//shikha
			eval("document.rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
		}else if (servGrpLimitSiteSpec == "true" && obj.value != "S"){					
			eval("document.rate_based_dtl.serv_grp_limit_ind" + index).disabled = false;//shikha
			eval("document.rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
			if (servGrpLmtBy != "*") {				
				if (servGrpLmtBy == "B" ) {
					document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='G'>"
					+ getLabel('Common.Group.label', 'Common')
					+ "</option><option value='S'>"
					+ getLabel('eBL.Service.label', 'BL')
					+ "</option></select>";
				} else if (servGrpLmtBy == "G" ) {
					document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='G'>"
					+ getLabel('Common.Group.label', 'Common')
					+ "</option>"
					+ "</select>";
				} else if (servGrpLmtBy == "S" ) {
					document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='S'>"
					+ getLabel('eBL.Service.label', 'BL')
					+ "</option></select>";
				}
			}	
		} 
		//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	}
}

function before_serviceLookUp(service_desc, service_code, service_type, index) {
	var result = true;
	// changed frame ref parent.frames[2] to parent.frames[4]by ram
	if (parent.frames[4].document.forms[0] != null) {

		result = validateServiceLimitForm(
				parent.frames[4].document.srvLimit_rate_based_dtl,
				parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,
				index,
				'',
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value);

	}
	var formObj = document.rate_based_dtl;
	if (result) {

		if (formObj != null) {
			if (eval("formObj.service_desc" + index).value == "") {

				clearRow(formObj, index);
				eval("formObj.service_code" + index).value = "";
				eval("formObj.service_desc_temp" + index).value = "";
			}

			if (eval("formObj.service_desc_temp" + index + ".value") != eval("formObj.service_desc"
					+ index + ".value")) {

				clearRow(formObj, index);

				if (eval("formObj.service_desc" + index).value != "") {
					show_serviceLookUp(service_desc, service_code,
							service_type, index);
				}
			}
		}
	} else {
		return false;
	}
}

function serviceLookUp(service_desc, service_code, service_type, index) {
	var result = true;

	// changed frame ref parent.frames[2] to parent.frames(4 by ram)
	if (parent.frames[4].document.forms[0] != null) {
		result = validateServiceLimitForm(
				parent.frames[4].document.srvLimit_rate_based_dtl,
				parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,
				index,
				'',
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value);
	}

	var formObj = document.rate_based_dtl;
	if (result) {

		if (formObj != null) {
			if (eval("formObj.service_desc" + index).value == "") {
				show_serviceLookUp(service_desc, service_code, service_type,
						index);
			}
		}
	}
}
function show_serviceLookUp(service_desc, service_code, service_type, index) {
	var formObj = document.rate_based_dtl;

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("Common.BillingService.label", "common");
	var local = formObj.locale.value;
	var facility_id=formObj.facilityId.value; //V211130 Modified by Nandhini for KDAH-SCF-0769
	if (service_type.value == "G") {
		argumentArray[0] = "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"
				+ local
				+ "' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("eBL.SERVICE_GROUP.label", "BL");
	} else if (service_type.value == "C") {
		argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
				+ local
				+ "' and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
	} else if (service_type.value == "S") {
		argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
				+ local
				+ "' and status is null and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("Common.BillingService.label", "common");
	} else {
		argumentArray[0] = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
		title = getLabel("eBL.PackageGrouping.label", "BL");
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = service_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		service_desc.value = retVal[1];
		service_code.value = retVal[0];
		eval("formObj.service_desc_temp" + index).value = retVal[1];

		if (formObj.order_associated.value == "Y") {
			eval("formObj.perAmt_limit" + index).disabled = true;

			/*
			 * eval("formObj.amt_percentage"+index).disabled=true;
			 * eval("formObj.amt_limit"+index).disabled=true;
			 * eval("formObj.unlimited"+index).disabled=true;
			 */

		} else {
			// eval("formObj.perAmt_limit"+index).disabled=true;
			/*
			 * eval("formObj.amt_percentage"+index).disabled=false;
			 * eval("formObj.amt_limit"+index).disabled=false;
			 * eval("formObj.unlimited"+index).disabled=false;
			 */
		}
		if (eval("formObj.factor_appl" + index) != undefined) {
			eval("formObj.factor_appl" + index).value = "";
			eval("formObj.factor_appl" + index).checked = false;
			eval("formObj.factor_appl" + index).disabled = false;
		}
		/*
		 * if(eval("formObj.type"+index).value=="G" ||
		 * eval("formObj.type"+index).value=="C"){
		 * eval("formObj.qty_limit"+index).disabled=true; }else{
		 */
		eval("formObj.qty_limit" + index).disabled = false;
		// }

		if (eval("formObj.type" + index).value == "G"
				|| eval("formObj.type" + index).value == "C") {
			eval("formObj.replace" + index).disabled = true;
			eval("formObj.refund" + index).disabled = true;
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
					.cells(19).innerHTML = "<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""
					+ index
					+ "\")' disabled/><input type='hidden' name='closePkg"
					+ index + "' value='N' />";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)
					//Modified cells(17)->cells(18) by Ram

		} else {
			eval("formObj.replace" + index).disabled = false;
			eval("formObj.refund" + index).disabled = false;
			if (formObj.acrossEncounters.value == "Y") {

				document.getElementById('rate_based_tbl').rows( //sarathkumar InclHmeMedi 1+
						parseInt(index) + 1).cells(19).innerHTML = "<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""
						+ index
						+ "\")'/><input type='hidden' name='closePkg"
						+ index + "' value='N' />";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)
						//Modified cells(17)->cells(18) by Ram
			}
		}
		eval("formObj.service_limit" + index).checked = false;
		if (eval("formObj.type" + index).value == "S") {
			eval("formObj.service_limit" + index).disabled = true;
		} else {
			eval("formObj.service_limit" + index).disabled = false;
		}

	} else {
		eval("formObj.service_code" + index).value = "";
		eval("formObj.service_desc" + index).value = "";
		eval("formObj.service_desc_temp" + index).value = "";

		clearRow(formObj, index);
	}
	// Added for duplicate check
	if (service_code.value != null) {
		// checkForDuplicate("RATE_BASED",service_desc.value,index);
		checkForDuplicate("RATE_BASED", service_code.value, index);
	}

}
function before_catalogLookUp(catalog_desc, catalog_code, service_code, index) {
	var formObj = document.rate_based_dtl;
	if (formObj != null) {
		if (eval("formObj.catalog_desc_temp" + index + ".value") != eval("formObj.catalog_desc"
				+ index + ".value")) {
			if (eval("formObj.catalog_desc" + index).value != "")
				show_catalogLookUp(catalog_desc, catalog_code, service_code,
						index);
		}
	}
}

function catalogLookUp(catalog_desc, catalog_code, service_code, index) {
	var formObj = document.rate_based_dtl;
	if (formObj != null) {
		if (eval("formObj.catalog_desc" + index).value == "") {
			show_catalogLookUp(catalog_desc, catalog_code, service_code, index);
		}
	}
}

function show_catalogLookUp(catalog_desc, catalog_code, service_code, index) {

	var formObj = document.rate_based_dtl;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("Common.ordercatalog.label", "common");
	var local = formObj.locale.value;
	argumentArray[0] = "select a.order_catalog_code code,b.short_desc description from bl_order_catalog a, or_order_catalog_lang_vw b where a.order_catalog_code=b.order_catalog_code and a.blng_serv_code='"
			+ service_code.value
			+ "' and b.language_id='"
			+ local
			+ "' and upper(a.order_catalog_code) like upper(?) and upper(b.long_desc) like upper(?)  order by 2  ";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = catalog_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = CommonLookup(title, argumentArray);
	if (retVal != null && retVal != "") {
		catalog_desc.value = retVal[1];
		catalog_code.value = retVal[0];
		eval("formObj.catalog_desc_temp" + index).value = retVal[1];
	} else {
		catalog_desc.value = "";
		catalog_code.value = "";
		eval("formObj.catalog_desc_temp" + index).value = "";
	}
}

function onIndChange(obj, index) {
	eval("document.forms[0].factorOrRate" + index).value = "";

}
function chkFactorRule(obj, ind) {

	/*
	 * if(ind.value=="S" || ind.value=="R" ){ if(obj.value !="" && obj.value<=0){
	 * alert(getMessage("BL6159","BL")); obj.value=""; return false; }
	 *  }
	 */
}
function chkQtyLimit(obj, index) {
	if (obj.value != "" && obj.value < 1) {
		alert(getMessage("BL8538", "BL"));
		obj.value = "";
		return false;
	}
}
function appendZero(obj) {
	if (obj.value == "") {
		obj.value = "0.00";
	} else {
		var dot = obj.value.indexOf(".");
		if (dot == -1) {
			obj.value = obj.value + ".00";
		}
	}
	obj.value = (parseFloat(obj.value)).toFixed(2);// to limit to 2 decimal
													// digits
}
function validPercentage(obj, type) {
	var discPer = parseFloat(obj.value);

	if (discPer > 100.00 || discPer <= 0) {
		if (type == 'P')
			alert(getMessage("BL8664", "BL"));
		else
			alert(getMessage("BL8539", "BL"));
		obj.value = "";
		obj.focus();
		return false;
	}
}
function chkAmtPercent(obj, index) {
	if (obj.value != "" && eval("document.rate_based_dtl") != undefined) {
		// eval("document.rate_based_dtl.amt_limit"+index).value="";
		// eval("document.rate_based_dtl.amt_limit"+index).disabled=true;
		eval("document.rate_based_dtl.factor_appl" + index).value = "";
		eval("document.rate_based_dtl.factor_appl" + index).checked = false;
		eval("document.rate_based_dtl.factor_appl" + index).disabled = true;
	} else { /*
				 * eval("document.rate_based_dtl.amt_limit"+index).disabled=false;
				 * if(eval("document.rate_based_dtl.amt_limit"+index).value==""){
				 * eval("document.rate_based_dtl.factor_appl"+index).value="";
				 * eval("document.rate_based_dtl.factor_appl"+index).checked=false;
				 * eval("document.rate_based_dtl.factor_appl"+index).disabled=true; }
				 */
	}

}
function chkAmt(obj, index) {
	if (eval("document.rate_based_dtl.factor_appl" + index) != undefined) {
		eval("document.rate_based_dtl.factor_appl" + index).value = "";
		eval("document.rate_based_dtl.factor_appl" + index).checked = false;
		eval("document.rate_based_dtl.factor_appl" + index).disabled = true;
	}
	if (obj.value != "") {
		// eval("document.rate_based_dtl.amt_percentage"+index).value="";
		// eval("document.rate_based_dtl.amt_percentage"+index).disabled=true;
		if (obj.value > 0) {
			if (eval("document.rate_based_dtl.factor_appl" + index) != undefined)
				eval("document.rate_based_dtl.factor_appl" + index).disabled = false;
		}
	} else {
		// eval("document.rate_based_dtl.amt_percentage"+index).disabled=false;
	}
}
function chkUnlimited(obj, index) {
	if (eval("document.rate_based_dtl.service_code" + index).value != "") {
		if (obj.value = "U") {
			// obj.value="Y";
			eval("document.rate_based_dtl.qty_limit" + index).value = "";
			eval("document.rate_based_dtl.qty_limit" + index).disabled = true;
			eval("document.rate_based_dtl.perAmt_limit" + index).value = "";
			eval("document.rate_based_dtl.perAmt_limit" + index).disabled = true;
			/*
			 * eval("document.rate_based_dtl.amt_percentage"+index).value="";
			 * eval("document.rate_based_dtl.amt_percentage"+index).disabled=true;
			 * eval("document.rate_based_dtl.amt_limit"+index).value="";
			 * eval("document.rate_based_dtl.amt_limit"+index).disabled=true;
			 */
			eval("document.rate_based_dtl.factor_appl" + index).value = "";
			eval("document.rate_based_dtl.factor_appl" + index).checked = false;
			eval("document.rate_based_dtl.factor_appl" + index).disabled = true;

		} else {
			// obj.value="N";
			eval("document.rate_based_dtl.qty_limit" + index).value = "";
			eval("document.rate_based_dtl.qty_limit" + index).disabled = false;
			if (document.rate_based_dtl.order_associated.value == "N") {
				eval("document.rate_based_dtl.perAmt_limit" + index).value = "";
				eval("document.rate_based_dtl.perAmt_limit" + index).disabled = false;

				/*
				 * eval("document.rate_based_dtl.amt_percentage"+index).value="";
				 * eval("document.rate_based_dtl.amt_percentage"+index).disabled=false;
				 * eval("document.rate_based_dtl.amt_limit"+index).value="";
				 * eval("document.rate_based_dtl.amt_limit"+index).disabled=false;
				 */
			} else if (document.rate_based_dtl.order_associated.value == "Y") {
				eval("document.rate_based_dtl.perAmt_limit" + index).disabled = true;
				/*
				 * eval("document.rate_based_dtl.amt_percentage"+index).disabled=true;
				 * eval("document.rate_based_dtl.amt_limit"+index).disabled=true;
				 */
			}
			eval("document.rate_based_dtl.factor_appl" + index).value = "";
			eval("document.rate_based_dtl.factor_appl" + index).checked = false;
			eval("document.rate_based_dtl.factor_appl" + index).disabled = true;
		}
	}
}

function chkReplace(obj, index) {
	if (obj.checked) {
		document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
				.cells(15).innerHTML = "<input type='checkbox'  checked name='replace"
				+ index
				+ "' value='Y' onClick='chkReplace(this,\""
				+ index
				+ "\")'/><a name='replace_dtls"
				+ index
				+ "' href='#' onClick='showReplaceDtls(\""
				+ index
				+ "\")'>"
				+ getLabel('eBL.Dtls.label', 'BL')
				+ "</a><input type='hidden' name='replaceSrv_code"
				+ index
				+ "' value=''><input type='hidden' name='replaceSrv_desc"
				+ index
				+ "' value=''><input type='hidden' name='replaceSrv_cat_code"
				+ index
				+ "' value=''><input type='hidden' name='replaceSrv_cat_desc"
				+ index + "' value=''>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(13)->cells(14)
				//Modified V201210/cells(14)->cells(15)
		showReplaceDtls(index);
	} else {
		document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
				.cells(15).innerHTML = "<input type='checkbox'  name='replace"
				+ index + "' value='N' onClick='chkReplace(this,\"" + index
				+ "\")'/><input type='hidden' name='replaceSrv_code" + index
				+ "' value=''><input type='hidden' name='replaceSrv_desc"
				+ index
				+ "' value=''><input type='hidden' name='replaceSrv_cat_code"
				+ index
				+ "' value=''><input type='hidden' name='replaceSrv_cat_desc"
				+ index + "' value=''>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(13)->cells(14)
				//Modified V201210/cells(14)->cells(15)

	}
}
async function showReplaceDtls(index) {
	var type = eval("document.rate_based_dtl.type" + index).value;
	var service_code = eval("document.rate_based_dtl.service_code" + index).value;
	var service_desc = eval("document.rate_based_dtl.service_desc" + index).value;
	var order_associated = document.rate_based_dtl.order_associated.value;
	var mode = document.rate_based_dtl.mode.value;
	var authorized = document.rate_based_dtl.authorized.value;
	var pkgApprovedYN = document.rate_based_dtl.pkgApprovedYN.value;
	var catalog_code = "";
	var catalog_desc = "";
	if (order_associated == "Y") {
		var catalog_code = eval("document.rate_based_dtl.catalog_code" + index).value;
		var catalog_desc = eval("document.rate_based_dtl.catalog_desc" + index).value;
	}
	var replaceSrv_code = eval("document.rate_based_dtl.replaceSrv_code"
			+ index).value;
	var replaceSrv_desc = eval("document.rate_based_dtl.replaceSrv_desc"
			+ index).value;
	var replaceSrv_cat_code = "";
	var replaceSrv_cat_desc = "";
	if (order_associated == "Y") {
		var replaceSrv_cat_code = eval("document.rate_based_dtl.replaceSrv_cat_code"
				+ index).value;
		var replaceSrv_cat_desc = eval("document.rate_based_dtl.replaceSrv_cat_desc"
				+ index).value;
	}
	var queryString = "mode=" + mode + "&pkgApprovedYN=" + pkgApprovedYN
			+ "&authorized=" + authorized + "&order_associated="
			+ order_associated + "&type=" + type + "&service_code="
			+ service_code + "&service_desc=" + service_desc + "&catalog_code="
			+ catalog_code + "&catalog_desc=" + catalog_desc
			+ "&replaceSrv_code=" + replaceSrv_code + "&replaceSrv_desc="
			+ replaceSrv_desc + "&replaceSrv_cat_code=" + replaceSrv_cat_code
			+ "&replaceSrv_cat_desc=" + replaceSrv_cat_desc;
	var retVal = new String();
	var dialogHeight = "19";
	var dialogWidth = "30";
	var status = "no";
	var arguments = "";
	var title = getLabel("eBL.replaceableService.label", "BL");
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + " ; scroll=no;  status:" + status;
	retVal =await window.showModalDialog("../../eBL/jsp/PkgDefReplaceableSrv.jsp?"
			+ queryString, arguments, features);
	if (retVal != null) {

		eval("document.rate_based_dtl.replaceSrv_code" + index).value = retVal[0];
		eval("document.rate_based_dtl.replaceSrv_desc" + index).value = retVal[1];
		eval("document.rate_based_dtl.replaceSrv_cat_code" + index).value = retVal[2];
		eval("document.rate_based_dtl.replaceSrv_cat_desc" + index).value = retVal[3];
	}

}
function before_replaceSrvLookUp(service_desc, service_code, service_type) {
	var formObj = document.replaceable_service;
	if (formObj != null) {
		if (formObj.replaceSrv_desc_temp.value != formObj.replaceSrv_desc.value) {

			if (formObj.replaceSrv_desc.value != "") {
				show_replaceSrvLookUp(service_desc, service_code, service_type);
			}
		}
	}

}

function replaceSrvLookUp(service_desc, service_code, service_type) {
	var formObj = document.replaceable_service
	if (formObj != null) {
		if (formObj.replaceSrv_desc.value == "") {
			show_replaceSrvLookUp(service_desc, service_code, service_type);
		}
	}

}
function show_replaceSrvLookUp(service_desc, service_code, service_type) {
	var formObj = document.replaceable_service;

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("Common.BillingService.label", "common");
	var local = formObj.locale.value;
	var parent_service_code = formObj.service_code.value
	if (service_type.value == "G") {
		argumentArray[0] = "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"
				+ local
				+ "' and upper(serv_grp_code)<>upper('"
				+ parent_service_code
				+ "') and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("eBL.SERVICE_GROUP.label", "BL");
	} else if (service_type.value == "C") {
		argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
				+ local
				+ "' and upper(serv_classification_code)<>upper('"
				+ parent_service_code
				+ "') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
	} else {
		argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
				+ local
				+ "' and status is null and upper(blng_serv_code)<>upper('"
				+ parent_service_code
				+ "') and upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title = getLabel("Common.BillingService.label", "common");
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = service_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		service_desc.value = retVal[1];
		service_code.value = retVal[0];
		formObj.replaceSrv_desc_temp.value = retVal[1];

	} else {
		service_desc.value = "";
		service_code.value = "";
		formObj.replaceSrv_desc_temp.value = "";

	}

}

function before_replaceSrvCatLookUp(catalog_desc, catalog_code, service_code) {
	var formObj = document.replaceable_service;
	if (formObj != null) {
		if (formObj.replaceSrv_cat_desc_temp.value != formObj.replaceSrv_cat_desc.value) {
			if (formObj.replaceSrv_cat_desc.value != "")
				show_replaceSrvCatLookUp(catalog_desc, catalog_code,
						service_code);
		}
	}
}

function replaceSrvCatLookUp(catalog_desc, catalog_code, service_code) {
	var formObj = document.replaceable_service;
	if (formObj != null) {
		if (formObj.replaceSrv_cat_desc.value == "") {
			show_replaceSrvCatLookUp(catalog_desc, catalog_code, service_code);
		}
	}
}

function show_replaceSrvCatLookUp(catalog_desc, catalog_code, service_code) {
	var formObj = document.replaceable_service;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("Common.ordercatalog.label", "common");
	var local = formObj.locale.value;
	argumentArray[0] = "select a.order_catalog_code code,b.long_desc description from bl_order_catalog a, or_order_catalog_lang_vw b where a.order_catalog_code=b.order_catalog_code and a.blng_serv_code='"
			+ service_code.value
			+ "' and b.language_id='"
			+ local
			+ "' and upper(a.order_catalog_code) like upper(?) and upper(b.long_desc) like upper(?)  order by 2  ";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = catalog_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = CommonLookup(title, argumentArray);
	if (retVal != null && retVal != "") {
		catalog_desc.value = retVal[1];
		catalog_code.value = retVal[0];
		formObj.replaceSrv_cat_desc_temp.value = retVal[1];
	} else {
		catalog_desc.value = "";
		catalog_code.value = "";
		formObj.replaceSrv_cat_desc_temp.value = "";
	}
}
function chkRefund(obj, index) {
	var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value

	if (obj.checked) {
		obj.value = "Y";
		document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
				.cells(16).innerHTML = "<input type='checkbox' name='refund"
				+ index
				+ "' checked value='Y' onClick='chkRefund(this,\""
				+ index
				+ "\")'/><input type='text' name='refundAmt"
				+ index
				+ "' value='' onBlur='return validPercentageForRefund(this,\"autoRefund"
				+ index
				+ "\")' onkeypress='return ChkNumberInput(this,event,\""
				+ noofdecimal + "\")' size='2' maxlength='4' >";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(14)->cells(15)
				//Modified V201210/cells(15)->cells(16)
		eval("document.forms[0].autoRefund" + index).disabled = false;

	} else {
		obj.value = "N";
		document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
				.cells(16).innerHTML = "<input type='checkbox' name='refund"
				+ index + "'  value='N' onClick='chkRefund(this,\"" + index
				+ "\")'/>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(14)->cells(15)
				//Modified V201210/cells(16)->cells(17)
		eval("document.forms[0].autoRefund" + index).checked = false;
		eval("document.forms[0].autoRefund" + index).value = "N";
		eval("document.forms[0].autoRefund" + index).disabled = true;
	}
}
function chkRefundAmt(obj, index) {
	if (obj.value == "" || obj.value == "0" || obj.value == 0) {
		alert(getMessage("BL8545", 'BL'));
		obj.value = "";
		obj.focus();
	}
}
function factorAppl(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}

function saveReplaceableVals() {
	var retVal = new Array();
	retVal[0] = document.replaceable_service.replaceSrv_code.value;
	retVal[1] = document.replaceable_service.replaceSrv_desc.value;
	retVal[2] = document.replaceable_service.replaceSrv_cat_code.value;
	retVal[3] = document.replaceable_service.replaceSrv_cat_desc.value;
	window.returnValue = retVal;
	window.close();
}
function chkServiceLimit(obj, index) {
	var result = true;
	var from = document.forms[0].from.value;
	var fromDate = '';
	
	var new_date_added=parent.parent.frames[1].frames[0].document.forms[0].new_date_added.value;
	fromDate=document.forms[0].fromDate.value;
														// GHL-SCF-1086
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	var fromDateVals = document.forms[0].fromDateVals.value;
	var new_date_added = document.getElementById("new_added_date").value; // Added By Vijay For GHL-SCf
	var dailyLmtIndicator = eval("document.rate_based_dtl.dailyLmtIndicator"+index).value;//Added V190731-Aravindh/MMS-DM-CRF-0129.1

	if (parent.frames[4].document.forms[0] != null) {
		result = validateServiceLimitForm(
				parent.frames[4].document.srvLimit_rate_based_dtl,
				parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,
				index,
				'',
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value);
	}

	if (result) {
		if (obj.checked) {
			obj.value = "Y";
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
					.cells(20).innerHTML = "<input type='checkbox'  checked name='service_limit"
					+ index
					+ "' onClick='chkServiceLimit(this,\""
					+ index
					+ "\")' value='Y'/><a name='service_limit_dtls"
					+ index
					+ "' href='#' onClick='serviceLimitDtls(\""
					+ index
					+ "\")'>" + getLabel('eBL.Dtls.label', 'BL') + "</a>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)
			//Modified by Ram MMS-QH-CRF-170  cells(19)-->cells(20) & V201125
			type = eval("document.rate_based_dtl.type" + index).value;
			service_code = eval("document.rate_based_dtl.service_code" + index).value;

			var mode = document.rate_based_dtl.mode.value;
			packageCode = parent.parent.PkgDefHeader.frmPkgDefHeader.packageCode.value;
			copyFrm_pkgCode = "";

			if (from == "PACKAGE")
				copyFrm_pkgCode = parent.parent.PkgDefHeader.frmPkgDefHeader.copyFrm_pkgCode.value;
			parent.frames[3].location.href = "../../eBL/jsp/PkgDefExcludeHdr.jsp?mode="
					+ mode
					+ "&packageCode="
					+ packageCode
					+ "&type="
					+ type
					+ "&service_code="
					+ service_code
					+ "&parent_indx="
					+ index
					+ "&copyFrm_pkgCode="
					+ copyFrm_pkgCode
					+ "&from="
					+ from
					+ "&fromDate="
					+ encodeURIComponent(fromDate)
					+ "&authorized="
					+ authorized
					+ "&pkgApprovedYN="
					+ pkgApprovedYN;
			parent.frames[4].location.href = "../../eBL/jsp/PkgDefExclude.jsp?mode="
					+ mode
					+ "&packageCode="
					+ packageCode
					+ "&type="
					+ type
					+ "&service_code="
					+ service_code
					+ "&parent_indx="
					+ index
					+ "&copyFrm_pkgCode="
					+ copyFrm_pkgCode
					+ "&from="
					+ from
					+ "&fromDate="
					+ encodeURIComponent(fromDate)
					+ "&authorized="
					+ authorized
					+ "&pkgApprovedYN="
					+ pkgApprovedYN + "&new_date_added=" + new_date_added
					+ "&dailyLmtInd="+dailyLmtIndicator;//Modified V190731-Aravindh/MMS-DM-CRF-0129.1/Added dailyLmtInd
			parent.frames[5].location.href = "../../eBL/jsp/PkgDefRateBasedBtn.jsp?table_name=srvLimit_rate_based_tbl&from="
					+ from
					+ "&authorized="
					+ authorized
					+ "&pkgApprovedYN="
					+ pkgApprovedYN;
		} else {
			obj.value = "N";
			document.getElementById('rate_based_tbl').rows(parseInt(index) + 1) //sarathkumar InclHmeMedi 1+
					.cells(20).innerHTML = "<input type='checkbox'   name='service_limit"
					+ index
					+ "' onClick='chkServiceLimit(this,\""
					+ index
					+ "\")' value='N'/>";//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)
			//Modified by Ram MMS-QH-CRF-170  cells(19)-->cells(20) & V201125
			// remove values from bean- chinju.
			parent.frames[3].location.href = "../../eCommon/html/blank.html";
			parent.frames[4].location.href = "../../eCommon/html/blank.html";
			parent.frames[5].location.href = "../../eCommon/html/blank.html";
		}
	}
}
function serviceLimitDtls(index) {
	var result = true;
	var from = document.forms[0].from.value;
	var fromDate ='';// document.forms[0].from_date.value;
	var fromDateVals = document.forms[0].fromDateVals.value;	
	var new_date_added=parent.parent.frames[1].frames[0].document.forms[0].new_date_added.value;
	fromDate=document.forms[0].fromDate.value;

	var dailyLmtIndicator = eval("document.rate_based_dtl.dailyLmtIndicator"+index).value;//Added V190731-Aravindh/MMS-DM-CRF-0129.1
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	// changed frame ref parent.frames[2] to parent.frames(4 by ram)
	if (parent.frames[4].document.forms[0] != null) {
		result = validateServiceLimitForm(
				parent.frames[4].document.srvLimit_rate_based_dtl,
				parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,
				index,
				'',
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value);
	}
	
	if (result) {
		type = eval("document.rate_based_dtl.type" + index).value;
		service_code = eval("document.rate_based_dtl.service_code" + index).value;

		var mode = document.forms[0].mode.value;
		packageCode = parent.parent.PkgDefHeader.frmPkgDefHeader.packageCode.value;
		copyFrm_pkgCode = "";
		if (from == "PACKAGE")
			copyFrm_pkgCode = parent.parent.PkgDefHeader.frmPkgDefHeader.copyFrm_pkgCode.value;

		parent.frames[3].location.href = "../../eBL/jsp/PkgDefExcludeHdr.jsp?mode="
				+ mode
				+ "&packageCode="
				+ packageCode
				+ "&type="
				+ type
				+ "&service_code="
				+ service_code
				+ "&parent_indx="
				+ index
				+ "&copyFrm_pkgCode="
				+ copyFrm_pkgCode
				+ "&from="
				+ from
				+ "&fromDate="
				+ encodeURIComponent(fromDate)
				+ "&authorized="
				+ authorized + "&pkgApprovedYN=" + pkgApprovedYN;
		parent.frames[4].location.href = "../../eBL/jsp/PkgDefExclude.jsp?mode="
				+ mode
				+ "&packageCode="
				+ packageCode
				+ "&type="
				+ type
				+ "&service_code="
				+ service_code
				+ "&parent_indx="
				+ index
				+ "&copyFrm_pkgCode="
				+ copyFrm_pkgCode
				+ "&from="
				+ from
				+ "&fromDate="
				+ encodeURIComponent(fromDate)
				+ "&authorized="
				+ authorized
				+ "&pkgApprovedYN="
				+ pkgApprovedYN
				+ "&new_date_added=" 
				+ new_date_added // Added By Vijay For GHL-SCf
				+ "&dailyLmtInd="+dailyLmtIndicator;//Modified V190731-Aravindh/MMS-DM-CRF-0129.1/Added dailyLmtInd

		parent.frames[5].location.href = "../../eBL/jsp/PkgDefRateBasedBtn.jsp?table_name=srvLimit_rate_based_tbl&from="
				+ from
				+ "&authorized="
				+ authorized
				+ "&pkgApprovedYN="
				+ pkgApprovedYN + "&mode=" + mode;
	}
}

function chkDeleteService(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}
function deleteRow(table_name, cellCount, from) {
	var frameObj = "";
	var tempJsp = "";
	var packageCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
	var copyFrm_pkgCode = "";
	if (from == "PACKAGE")
		copyFrm_pkgCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.copyFrm_pkgCode.value;
	var mode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
	var orderAssociated = parent.parent.PkgDefHeader.document.frmPkgDefHeader.orderAssociated.value;
	var acrossEncounters = parent.parent.PkgDefHeader.document.frmPkgDefHeader.acrossEncounters.value;
	var authorized = parent.parent.PkgDefHeader.document.frmPkgDefHeader.authorized.value;
	var pkgApprovedYN = parent.parent.PkgDefHeader.document.frmPkgDefHeader.pkgApprovedYN.value;
	if (table_name == "rate_based_tbl") {
		frameObj = parent.rate_based_dtl;
		table = frameObj.document.getElementById('rate_based_tbl');
		var fromDate = frameObj.document.forms[0].fromDate.value
		func_mode = "RATE_BASED";
		tempJsp = '../../eBL/jsp/PkgDefRateFrame.jsp?packageCode='
				+ packageCode + '&mode=' + mode + '&orderAssociated='
				+ orderAssociated + '&copyFrm_pkgCode=' + copyFrm_pkgCode
				+ "&from=" + from + "&fromDate=" + encodeURIComponent(fromDate)
				+ '&acrossEncounters=' + acrossEncounters + '&authorized='
				+ authorized + '&pkgApprovedYN=' + pkgApprovedYN;

	} else if (table_name == "srvLimit_rate_based_tbl") {
		// frameObj=parent.frames[2]; commented this line and added new line by
		// ram
		frameObj = parent.frames[4];

		table = frameObj.document.getElementById('srvLimit_rate_based_tbl');
		func_mode = "SRVLIMIT_RATE_BASED";
		var service_code = frameObj.document.forms[0].parent_service_code.value;
		var parent_indx = frameObj.document.forms[0].parent_indx.value;
		var parent_type = frameObj.document.forms[0].parent_type.value;
		var fromDate = frameObj.document.forms[0].fromDate.value;
		
		var dailyLmtIndicator = eval("parent.frames[4].document.srvLimit_rate_based_dtl.parDailyLmtInd").value;//Added V191001-Aravindh/MMS-DM-CRF-0129.1/IN071211

		tempJsp = "../../eBL/jsp/PkgDefExclude.jsp?mode=" + mode
				+ "&packageCode=" + packageCode + "&type=" + parent_type
				+ "&service_code=" + service_code + "&parent_indx="
				+ parent_indx + "&copyFrm_pkgCode=" + copyFrm_pkgCode
				+ "&from=" + from + "&fromDate=" + encodeURIComponent(fromDate)
				+ "&authorized=" + authorized + "&pkgApprovedYN="
				+ pkgApprovedYN
				+ "&dailyLmtInd="+dailyLmtIndicator;//Added V191001-Aravindh/MMS-DM-CRF-0129.1/IN071211

		/*
		 * tempJsp='../../eBL/jsp/PkgDefExcludeMain.jsp?packageCode='+packageCode+'&mode='+mode+'&orderAssociated='+orderAssociated+'&copyFrm_pkgCode='+copyFrm_pkgCode+"&from="+from
		 * +"&fromDate="+encodeURIComponent(fromDate)+'&acrossEncounters='+acrossEncounters+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN ;
		 */
	} else if (table_name == "pkgCbased") {
		frameObj = parent.ChargeBasedDtl;
		table = frameObj.document.getElementById('pkgCbased');
		var fromDate = frameObj.document.forms[0].fromDate.value

		func_mode = "CHARGE_BASED";
		tempJsp = '../../eBL/jsp/PkgDefChargeBasedMain.jsp?packageCode='
				+ packageCode + '&mode=' + mode + '&copyFrm_pkgCode='
				+ copyFrm_pkgCode + '&modeChk=delete&from=' + from
				+ '&fromDate=' + encodeURIComponent(fromDate) + '&authorized='
				+ authorized + '&pkgApprovedYN=' + pkgApprovedYN;

	} else if (table_name == "pkgCbasedItem") {
		// frameObj=parent.frames[2];commented and add new line ram
		frameObj = parent.frames[3];
		table = frameObj.document.getElementById('pkgCbasedItem');
		func_mode = "CHARGE_BASED_ITEM";
		var serviceCode = frameObj.document.forms[0].serviceCode.value
		var fromDate = frameObj.document.forms[0].fromDate.value
		tempJsp = '../../eBL/jsp/PkgDefChargeBasedExclusion.jsp?packageCode='
				+ packageCode + '&serviceCode=' + serviceCode + '&mode=' + mode
				+ '&copyFrm_pkgCode=' + copyFrm_pkgCode
				+ '&modeChk=delete&from=' + from + '&fromDate='
				+ encodeURIComponent(fromDate) + '&authorized=' + authorized
				+ '&pkgApprovedYN=' + pkgApprovedYN;
	}
	rowCount = table.rows.length;
	currentrowCount = rowCount
	// Modified by NMuthu on 10-4-2012 against 32308 - Starts Here
	if ((table_name == "rate_based_tbl") || (table_name == "pkgCbased")
			|| (table_name == "pkgCbasedItem")) {
		for ( var i = 1; i < rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[cellCount].childNodes[0];
			if (null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	} else {
		for ( var i = 0; i < rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[cellCount].childNodes[0];
			if (null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	}
	// Modified by NMuthu on 10-4-2012 against 32308 - Ends Here

	rowCount = table.rows.length;
	callSetBeanAfterDeletion(from, func_mode, frameObj, tempJsp, rowCount,
			currentrowCount, mode)
}

function callSetBeanAfterDeletion(from, func_mode, frameObj, tempJsp, rowCount,
		currentrowCount, mode) {
	var total_records = rowCount - 1
	if (rowCount < currentrowCount) {
		var formObj = eval(frameObj).document.forms[0];
		var event = "";
		if (mode == "modify")
			event = "delete";
		if (func_mode == "CHARGE_BASED") {
			if (parent.frames[2].document.frmPkgDefChargeBasedExcln != undefined)
				setBeanAfterDeletion("CHARGE_BASED_ITEM",
						parent.frames[2].document.frmPkgDefChargeBasedExcln,
						event);
		} else if (func_mode == "RATE_BASED") {

			if (parent.frames[4].document.srvLimit_rate_based_dtl != undefined) {
				// frame ref changed
				// parent.frames[2].document.srvLimit_rate_based_dtl to
				// parent.frames[4].document.srvLimit_rate_based_dtl
				setBeanAfterDeletion("SRVLIMIT_RATE_BASED",
						parent.frames[4].document.srvLimit_rate_based_dtl,
						event)
			}
		}
		setBeanAfterDeletion(func_mode, formObj, event);
		if (func_mode == "RATE_BASED") {

			// formObj = parent.frames[2].document.forms[0] commented and added
			// new line ram
			formObj = parent.frames[4].document.forms[0]

			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = total_records;
			// parent.frames[0].document.forms[0].totalRecords.value=total_records;
			// commented by ram and added new line
			parent.frames[1].document.forms[0].totalRecords.value = total_records;
			parent.location.href = tempJsp;

			if (formObj != undefined)
				setBeanAfterDeletion("SRVLIMIT_RATE_BASED", formObj, event)
				// frames ref changed parent.frames[2] and parent.frames[2] to
				// parent.frames[4] and parent.frames[5] by ram
			parent.frames[4].location.href = '../../eCommon/html/blank.html';
			parent.frames[5].location.href = '../../eCommon/html/blank.html';
		} else if (func_mode == "CHARGE_BASED") {

			// formObj = parent.frames[2].document.forms[0] commented by ram and
			// added new line
			formObj = parent.frames[3].document.forms[0]
			parent.location.href = tempJsp;
			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = total_records;

			if (func_mode == "CHARGE_BASED") {
				if (formObj != undefined)
					setBeanAfterDeletion("CHARGE_BASED_ITEM", formObj, event);
			}
			// else setBeanAfterDeletion("SRVLIMIT_RATE_BASED",formObj)

			parent.frames[2].location.href = '../../eCommon/html/blank.html';
			parent.frames[3].location.href = '../../eCommon/html/blank.html';

		} else {
			if (from == "CUSTOMER")
				parent.parent.frames[4].frames[2].location.href = tempJsp;
			else {

				if (from == "CHAR_BASE_ITEM_DELETE")
					parent.parent.frames[3].frames[3].location.href = tempJsp;
				else
					// parent.parent.frames[3].frames[2].location.href=tempJsp;
					// commentd added new line by ram
					parent.parent.frames[3].frames[4].location.href = tempJsp;
			}
			parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value = total_records;
		}
	}
}

function setBeanAfterDeletion(func_mode, frmObj, event) {
	var xmlString = "";
	packageCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
	// curDate =
	// parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value;
	if (func_mode == "SRVLIMIT_RATE_BASED" || func_mode == "CHARGE_BASED_ITEM") {

		if (frmObj != undefined)
			xmlString = formXMLString(frmObj, func_mode, "excln", packageCode);
	} else
		xmlString = formXMLString(frmObj, func_mode, "tab", packageCode);

	var updation = formValidation(xmlString, func_mode, event);
}
function onSrvLimitServiceTypeChange(obj, index) {
	clearRow(document.srvLimit_rate_based_dtl, index);
	/*
	 * if(obj.value=="C"){
	 * eval("document.srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).value="";
	 * eval("document.srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).disabled=true;
	 * }else{
	 * if(eval("document.srvLimit_rate_based_dtl.srvLimit_service_code"+index).value
	 * !=""){
	 * eval("document.srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).value="";
	 * eval("document.srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).disabled=false; } }
	 */
	eval("document.srvLimit_rate_based_dtl.srvLimit_service_code" + index).value = "";
	eval("document.srvLimit_rate_based_dtl.srvLimit_service_desc" + index).value = "";
	eval("document.srvLimit_rate_based_dtl.srvLimit_service_desc_temp" + index).value = "";
	eval("document.srvLimit_rate_based_dtl.srvLimit_replace" + index).disabled = true;
	eval("document.srvLimit_rate_based_dtl.srvLimit_refund" + index).disabled = true;
	eval("document.srvLimit_rate_based_dtl.srvLimit_autoRefund" + index).disabled = true;
}
//V220615
function srvLimitCodeLookUp(service_desc, service_code, service_type, index) {

	var formObj = document.srvLimit_rate_based_dtl;
	if (formObj != null) {
		if (eval("formObj.srvLimit_service_code_temp" + index + ".value") != eval("formObj.srvLimit_service_code"
				+ index + ".value")) {
			if (eval("formObj.srvLimit_service_code" + index).value != "") {
				var argumentArray = new Array();
				var dataNameArray = new Array();
				var dataValueArray = new Array();
				var dataTypeArray = new Array();
				var title = getLabel("Common.BillingService.label", "common");
				var locale = formObj.locale.value;
				var parent_type = formObj.parent_type.value;
				var parent_service_code = formObj.parent_service_code.value;
				var parent_service_ind = formObj.parent_service_ind.value; //V220615
				if (service_type.value == "C") {
					argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
							+ locale
							+ "' and upper(substr(serv_classification_code,1,2)) = upper('"
							+ parent_service_code
							+ "') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
					title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
				} else {
					if (parent_type == "G") {
						if (service_type.value == "S") {
							argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
									+ locale
									+ "' and status is null and upper(substr(blng_serv_code,1,2)) = upper('"
									+ parent_service_code
									+ "')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
							title = getLabel("Common.BillingService.label", "common");

							}
							else if (service_type.value == "M") {
								argumentArray[0] = "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"
										+ locale
										+ "' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
								title = getLabel("Common.item.label", "common");
							}

							else if (service_type.value == "P") {
								argumentArray[0] = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
								title = getLabel("eBL.PackageGrouping.label", "BL"); //V211130
							}
					}else if (parent_type == "P") {
						if (service_type.value == "M") {
							argumentArray[0] = "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"
									+ locale
									+ "' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
							title = getLabel("Common.item.label", "common");
						} else if (service_type.value == "S") {
							argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
									+ locale
									+ "' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"
									+ parent_service_code
									+ "')) or (upper('"
									+ parent_service_ind
									+ "') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
							title = getLabel("Common.BillingService.label", "common");
						} else if (service_type.value == "C") {
							argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
									+ locale
									+ "' and upper(substr(serv_classification_code,1,2)) = upper('"
									+ parent_service_code
									+ "') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
							title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
						} else if (service_type.value == 'G') {
							argumentArray[0] = "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"
									+ locale
									+ "' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
							title = getLabel("eBL.SERVICE_GROUP.label", "BL");
						} else if (service_type.value == 'T') {
							argumentArray[0] = "select SALE_CATEGORY_CODE code,short_desc description from BL_ST_ITEM_SALE_CATG_HDR where upper(SALE_CATEGORY_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
							title = getLabel("eBL.SalesCategory.label", "BL");
						} else if (service_type.value == "P") {
							argumentArray[0] = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
							title = getLabel("eBL.PackageGrouping.label", "BL");
						}
					} else if (parent_type == "C") {
						argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
								+ locale
								+ "' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"
								+ parent_service_code
								+ "')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
						title = getLabel("Common.BillingService.label", "common");
					} 
				}
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				argumentArray[4] = "1,2";
				argumentArray[5] = service_code.value;
				argumentArray[6] = CODE_LINK;
				argumentArray[7] = CODE_DESC;
				retVal = CommonLookup(title, argumentArray);
				if (retVal != null && retVal != "") {
					service_desc.value = retVal[1];
					service_code.value = retVal[0];
					eval("formObj.srvLimit_service_code_temp" + index).value = retVal[0];
					eval("formObj.srvLimit_service_desc_temp" + index).value = retVal[1];
					// eval("formObj.srvLimit_amt_limit"+index).disabled=false;
					eval("formObj.srvLimit_factor_appl" + index).value = "";
					eval("formObj.srvLimit_factor_appl" + index).checked = false;
					eval("formObj.srvLimit_factor_appl" + index).disabled = false;
					eval("formObj.exludeService" + index).disabled = false;
					eval("formObj.srvLimit_roundInd" + index).disabled = false;
					eval("formObj.srvLimit_roundTo" + index).value = "";
					eval("formObj.srvLimit_roundTo" + index).disabled = false;
					eval("formObj.srvLimit_qty_limit" + index).disabled = false;
					eval("formObj.srvLimit_amt_limit_ind" + index).disabled = false;
					eval("formObj.srvLimit_amt_limit_ind" + index).selectedIndex = 0;
					// }
					// alert(eval("formObj.srvLimit_type"+index).value)
					if (eval("formObj.srvLimit_type" + index).value == "C") {
						eval("formObj.srvLimit_replace" + index).disabled = true;
						eval("formObj.srvLimit_refund" + index).disabled = true;
					} else {
						eval("formObj.srvLimit_replace" + index).disabled = false;
						eval("formObj.srvLimit_refund" + index).disabled = false;
					}

				} else {
					service_desc.value = "";
					service_code.value = "";
					eval("formObj.srvLimit_service_code_temp" + index).value = "";
					eval("formObj.srvLimit_service_desc_temp" + index).value = "";
				}
			}
		}
	}
}//V220615

function before_srvLimitServiceLookUp(service_desc, service_code, service_type,
		index) {
	var formObj = document.srvLimit_rate_based_dtl;
	if (formObj != null) {
		if (eval("formObj.srvLimit_service_desc_temp" + index + ".value") != eval("formObj.srvLimit_service_desc"
				+ index + ".value")) {

			clearRow(formObj, index);
			if (eval("formObj.srvLimit_service_desc" + index).value != "")
				show_srvLimitServiceLookUp(service_desc, service_code,
						service_type, index);
		}
	}
}
function srvLimitServiceLookUp(service_desc, service_code, service_type, index) {
	var formObj = document.srvLimit_rate_based_dtl;
	if (formObj != null) {
		if (eval("formObj.srvLimit_service_desc" + index).value == "") {
			show_srvLimitServiceLookUp(service_desc, service_code,
					service_type, index);
		}
	}
}
function show_srvLimitServiceLookUp(service_desc, service_code, service_type,
		index) {
	var formObj = document.srvLimit_rate_based_dtl;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("Common.BillingService.label", "common");
	var locale = formObj.locale.value;
	var facility_id=formObj.facility_id.value; //V211130
	var parent_type = formObj.parent_type.value;
	var parent_service_code = formObj.parent_service_code.value;
	var parent_service_ind = formObj.parent_service_ind.value;

	/*
	 * if(service_type.value=="C"){ argumentArray[0] = "select
	 * serv_classification_code code,short_Desc description from
	 * BL_SERV_CLASSIFICATION_LANG_VW where language_id='"+locale+"' and
	 * upper(substr(serv_classification_code,1,2)) =
	 * upper('"+parent_service_code+"') and upper(serv_classification_code) like
	 * upper(?) and upper(short_desc) like upper(?) order by 2 ";
	 * title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL"); }else{
	 * if(parent_type=="G"){ argumentArray[0] = "select blng_serv_code
	 * code,short_Desc description from BL_BLNG_SERV_LANG_VW where
	 * language_id='"+locale+"' and upper(substr(blng_serv_code,1,2)) =
	 * upper('"+parent_service_code+"') and upper(blng_serv_code) like upper(?)
	 * and upper(short_desc) like upper(?) order by 2 "; }else if
	 * (parent_type=="C"){ argumentArray[0] = "select blng_serv_code
	 * code,short_Desc description from BL_BLNG_SERV_LANG_VW where
	 * language_id='"+locale+"' and upper(substr(blng_serv_code,1,4)) =
	 * upper('"+parent_service_code+"') and upper(blng_serv_code) like upper(?)
	 * and upper(short_desc) like upper(?) order by 2 "; }
	 * title=getLabel("Common.BillingService.label","common"); }
	 */

	if (service_type.value == "C") {
		// argumentArray[0] = "select serv_classification_code code,short_Desc
		// description from BL_SERV_CLASSIFICATION_LANG_VW where
		// language_id='"+locale+"' and
		// upper(substr(serv_classification_code,1,2)) =
		// upper('"+parent_service_code+"') and upper(serv_classification_code)
		// like upper(?) and upper(short_desc) like upper(?) order by 2 ";

		// Above is commented by lakshmi against the lookup issue and modified
		// as below
		argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
				+ locale
				+ "' and ((upper(substr(serv_classification_code,1,2)) = upper('"
				+ parent_service_code
				+ "')) or (upper('"
				+ parent_service_ind
				+ "') ='P')) and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
		title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
	} else {
		if (parent_type == "G") {
			if (service_type.value == "S") {
				// argumentArray[0] = "select blng_serv_code code,short_Desc
				// description from BL_BLNG_SERV_LANG_VW where
				// language_id='"+locale+"' and
				// upper(substr(blng_serv_code,1,2)) =
				// upper('"+parent_service_code+"') and upper(blng_serv_code)
				// like upper(?) and upper(short_desc) like upper(?) order by 2
				// ";
				// Above is commented by lakshmi against the lookup issue and
				// modified as below
				argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
						+ locale
						+ "' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"
						+ parent_service_code
						+ "')) or (upper('"
						+ parent_service_ind
						+ "') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("Common.BillingService.label", "common");

			}
			// Added By Muthukumar on 18-11-11 against 30025 Issue
			else if (service_type.value == "M") {
				argumentArray[0] = "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"
						+ locale
						+ "' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("Common.item.label", "common");
			}

			// Added By Muthukumar on 22-2-12 against CRF Starts here
			else if (service_type.value == "P") {
				argumentArray[0] = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
				title = getLabel("eBL.PackageGrouping.label", "BL"); //V211130
			}
		}
		// Added Newly 13-3-12
		else if (parent_type == "P") {
			if (service_type.value == "M") {
				argumentArray[0] = "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"
						+ locale
						+ "' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("Common.item.label", "common");
			} else if (service_type.value == "S") {
				// argumentArray[0] = "select blng_serv_code code,short_Desc
				// description from BL_BLNG_SERV_LANG_VW where
				// language_id='"+locale+"' and
				// upper(substr(blng_serv_code,1,2)) =
				// upper('"+parent_service_code+"') and upper(blng_serv_code)
				// like upper(?) and upper(short_desc) like upper(?) order by 2
				// ";
				// Above is commented by lakshmi against the lookup issue and
				// modified as below
				argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
						+ locale
						+ "' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"
						+ parent_service_code
						+ "')) or (upper('"
						+ parent_service_ind
						+ "') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("Common.BillingService.label", "common");
			} else if (service_type.value == "C") {
				argumentArray[0] = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
						+ locale
						+ "' and upper(substr(serv_classification_code,1,2)) = upper('"
						+ parent_service_code
						+ "') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
			} else if (service_type.value == 'G') {
				argumentArray[0] = "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"
						+ locale
						+ "' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title = getLabel("eBL.SERVICE_GROUP.label", "BL");
			} else if (service_type.value == 'T') {
				argumentArray[0] = "select SALE_CATEGORY_CODE code,short_desc description from BL_ST_ITEM_SALE_CATG_HDR where upper(SALE_CATEGORY_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
				title = getLabel("eBL.SalesCategory.label", "BL");
			} else if (service_type.value == "P") {
				argumentArray[0] = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
				title = getLabel("eBL.PackageGrouping.label", "BL");
			}
			// Added By Muthukumar on 22-2-12 against CRF Ends here
		} else if (parent_type == "C") {
			argumentArray[0] = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
					+ locale
					+ "' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"
					+ parent_service_code
					+ "')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			title = getLabel("Common.BillingService.label", "common");
		}
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = service_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = CommonLookup(title, argumentArray);
	if (retVal != null && retVal != "") {
		service_desc.value = retVal[1];
		service_code.value = retVal[0];
		eval("formObj.srvLimit_service_code_temp" + index).value = retVal[0];
		eval("formObj.srvLimit_service_desc_temp" + index).value = retVal[1];
		// eval("formObj.srvLimit_amt_limit"+index).disabled=false;
		eval("formObj.srvLimit_factor_appl" + index).value = "";
		eval("formObj.srvLimit_factor_appl" + index).checked = false;
		eval("formObj.srvLimit_factor_appl" + index).disabled = true;
		eval("formObj.srvLimit_roundInd" + index).disabled = false;
		eval("formObj.srvLimit_roundTo" + index).value = "";
		eval("formObj.srvLimit_roundTo" + index).disabled = false;
		/*
		 * if(eval("formObj.srvLimit_type"+index).value=="C"){
		 * eval("formObj.srvLimit_qty_limit"+index).disabled=true; }else{
		 */
		eval("formObj.srvLimit_qty_limit" + index).disabled = false;
		eval("formObj.srvLimit_amt_limit_ind" + index).disabled = false;
		eval("formObj.srvLimit_amt_limit_ind" + index).selectedIndex = 0;

		// }
		eval("formObj.exludeService" + index).disabled = false;
		if (eval("formObj.srvLimit_type" + index).value == "C") {
			eval("formObj.srvLimit_replace" + index).disabled = true;
			eval("formObj.srvLimit_refund" + index).disabled = true;
		} else {
			eval("formObj.srvLimit_replace" + index).disabled = false;
			eval("formObj.srvLimit_refund" + index).disabled = false;
		}

	} else {
		service_desc.value = "";
		service_code.value = "";
		eval("formObj.srvLimit_service_code_temp" + index).value = "";
		eval("formObj.srvLimit_service_desc_temp" + index).value = "";

		clearRow(formObj, index);
	}
	// Added for duplicate check
	if (service_code.value != null) {
		checkForDuplicate("SRVLIMIT_RATE_BASED", service_code.value, index);

	}

}
function chkExludeService(obj, index) {
	var formObj = document.srvLimit_rate_based_dtl;
	if (obj.checked) {
		obj.value = "Y";
		eval("formObj.srvLimit_qty_limit" + index).value = "";
		eval("formObj.srvLimit_qty_limit" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit" + index).value = "";
		eval("formObj.srvLimit_amt_limit" + index).disabled = true;
		eval("formObj.srvLimit_factor_appl" + index).value = "";
		eval("formObj.srvLimit_factor_appl" + index).checked = false;
		eval("formObj.srvLimit_factor_appl" + index).disabled = true;
		eval("formObj.srvLimit_roundTo" + index).value = "";
		eval("formObj.srvLimit_roundTo" + index).disabled = true;
		eval("formObj.srvLimit_roundInd" + index).selectedIndex = 0;
		eval("formObj.srvLimit_roundInd" + index).disabled = true;
		eval("formObj.srvLimit_autoRefund" + index).value = "N";
		eval("formObj.srvLimit_autoRefund" + index).checked = false;
		eval("formObj.srvLimit_autoRefund" + index).disabled = true;
		eval("formObj.srvLimit_amt_limit_ind" + index).disabled = true;
		if (eval("formObj.srvLimit_type" + index).value == "S") {
			eval("formObj.srvLimit_replace" + index).value = "N";
			eval("formObj.srvLimit_replace" + index).checked = false;
			eval("formObj.srvLimit_replace" + index).disabled = true;
			eval(document.getElementById("srvLimit_replace_dtls" + index)).style.display = 'none';
			eval("formObj.srvLimit_replaceSrv_code" + index).value = "";
			eval("formObj.srvLimit_replaceSrv_desc" + index).value = "";
			eval("formObj.srvLimit_refund" + index).value = "N";
			eval("formObj.srvLimit_refund" + index).checked = false;
			eval("formObj.srvLimit_refund" + index).disabled = true;
			eval("formObj.srvLimit_refundAmt" + index).value = "";
			eval("formObj.srvLimit_refundAmt" + index).style.display = 'none';

		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
		if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
			eval("formObj.dailyLmtChkBx"+index).disabled = true;
			eval("formObj.dailyLmtChkBx"+index).checked = false;
			eval("formObj.dailyLmtChkBx"+index).value = "N";
			dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.srvLimit_rate_based_dtl);
			eval("formObj.dailyLmtIndicator"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtIndicator"+index).value = "*";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtAmt"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtAmt"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtQty"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtQty"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	} else {
		obj.value = "N";
		eval("formObj.srvLimit_amt_limit_ind" + index).disabled = false;
		eval("formObj.srvLimit_amt_limit"+index).disabled=false; //added by vijay for 91 crf
		eval("formObj.srvLimit_qty_limit" + index).disabled = false;
		eval("formObj.srvLimit_factor_appl" + index).value = "";
		eval("formObj.srvLimit_factor_appl" + index).checked = false;
		eval("formObj.srvLimit_factor_appl" + index).disabled = false;
		// eval("formObj.srvLimit_factor_appl"+index).disabled=false;
		// eval("formObj.srvLimit_factor_appl"+index).value="N";
		// eval("formObj.srvLimit_factor_appl"+index).checked=false;
		eval("formObj.srvLimit_roundTo" + index).disabled = false;
		eval("formObj.srvLimit_roundInd" + index).disabled = false;
		if (eval("formObj.srvLimit_type" + index).value == "S") {
			eval("formObj.srvLimit_replace" + index).disabled = false;
			eval("formObj.srvLimit_refund" + index).disabled = false;
			eval("formObj.srvLimit_autoRefund" + index).disabled = false;
			eval("formObj.srvLimit_autoRefund" + index).value = "N";

		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
		if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
			eval("formObj.dailyLmtChkBx"+index).disabled = false;
			eval("formObj.dailyLmtChkBx"+index).checked = false;
			eval("formObj.dailyLmtChkBx"+index).value = "N";
			dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.srvLimit_rate_based_dtl);
			/* Added V190626-Aravindh/MMS-DM-CRF-0129.1/Starts */
			eval("formObj.dailyLmtIndicator"+index).disabled = false;
			eval("formObj.dailyLmtIndicator"+index).value = "*";
			if(eval("formObj.amtFldDisabled").value != " disabled ") {
				eval("formObj.dailyLmtAmt"+index).disabled = false;
				eval("formObj.dailyLmtAmt"+index).value = "";
			} 
			if(eval("formObj.qtyFldDisabled").value != " disabled ") {
				eval("formObj.dailyLmtQty"+index).disabled = false;
				eval("formObj.dailyLmtQty"+index).value = "";
			}
			/* Added V190626-Aravindh/MMS-DM-CRF-0129.1/Ends */
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	}
}
function chkSrvLimitQtyLimit(obj) {
	if (obj.value != "" && obj.value < 1) {
		alert(getMessage("BL8538", "BL"));
		obj.value = "";
		return false;
	}
}

function chkSrvLimitAmtLimit(obj, index, noofdecimal) {
	var formObj = document.srvLimit_rate_based_dtl;

	if (obj.value != "") {
		if (eval("formObj.srvLimit_amt_limit_ind" + index).value == "A") {
			checkForNegetiveNumber(obj, noofdecimal, "BL8540")
			if (obj.value > 0) {
				eval("formObj.srvLimit_factor_appl" + index).value = "";
				eval("formObj.srvLimit_factor_appl" + index).checked = false;
				eval("formObj.srvLimit_factor_appl" + index).disabled = false;
			} else {
				eval("formObj.srvLimit_factor_appl" + index).value = "";
				eval("formObj.srvLimit_factor_appl" + index).checked = false;
				eval("formObj.srvLimit_factor_appl" + index).disabled = true;
			}
		} else if (eval("formObj.srvLimit_amt_limit_ind" + index).value == "P") {
			validPercentage(obj);
		}
	}
}
function srvLimitFactorAppl(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}

function chkSrvLimitDeleteService(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}

function putdeci(object, noofdecimal) {
	var decimal = "";
	decimal = noofdecimal;
	if (object.value != '') {
		// var decimal=parent.PkgDefHeader.document.forms[0].noofdecimal.value;
		putDecimal(object, 17, decimal);
	}
}
function allowValidNumber1_temp(obj, event, noofdecimal) {
	if (allowValidNumber(obj, event, noofdecimal))
		return true;
	else
		return false
		// ChkNumberInput(obj,event,parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value));

}
function validateServiceLimitForm(srvLimitFormObj, packageCode, index, source) {

	// var srvLimitFormObj=parent.frames[2].document.srvLimit_rate_based_dtl;
	// var
	// packageCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
	if (srvLimitFormObj.parent_indx.value != index) {
		var totalRecords = srvLimitFormObj.totalRecords.value;
		var obj;
		var message = "";
		for ( var i = 0; i < parseInt(totalRecords); i++) {

			if (eval("srvLimitFormObj.srvLimit_service_code" + i).value != ""
					&& (eval("srvLimitFormObj.exludeService" + i).value == "" || eval("srvLimitFormObj.exludeService"
							+ i).value == "N")) {
				/*
				 * if(eval("srvLimitFormObj.srvLimit_type"+i).value=="C" &&
				 * eval("srvLimitFormObj.srvLimit_amt_limit"+i).value==""){
				 * message=getMessage("BL8561",'BL');
				 * obj=eval("srvLimitFormObj.srvLimit_amt_limit"+i); }else
				 */
				// Added by Muthukumar against 31573 on 5/3/2012 Starts Here
				if (eval("srvLimitFormObj.srvLimit_amt_limit_ind" + i) != null
						&& eval("srvLimitFormObj.srvLimit_amt_limit_ind" + i).value != "") {
					if ((eval("srvLimitFormObj.srvLimit_amt_limit" + i).value == "" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"
							+ i).value != "")
							|| (eval("srvLimitFormObj.srvLimit_amt_limit" + i).value != "" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"
									+ i).value == "")) {
						message = getMessage("BL8561", 'BL');
						alert(message);
						eval("formObj.perAmt_limit" + i).focus();
						return false;
					}
				} else
				// Added by Muthukumar against 31573 on 5/3/2012 Ends Here
				// (eval("srvLimitFormObj.srvLimit_type"+i).value=="C"
				// ||eval("srvLimitFormObj.srvLimit_type"+i).value=="S") -
				// commented by Muthukumar against 3157 on 5/3/2012
				if (eval("srvLimitFormObj.srvLimit_amt_limit" + i).value == ""
						&& eval("srvLimitFormObj.srvLimit_qty_limit" + i).value == "") {
					message = getMessage("BL8555", 'BL');
					if (eval("srvLimitFormObj.srvLimit_qty_limit" + i).disabled)
						obj = eval("srvLimitFormObj.srvLimit_amt_limit" + i);
					else
						obj = eval("srvLimitFormObj.srvLimit_qty_limit" + i);
					alert(message);
					obj.focus();
					return false;
				}
				/*
				 * if(eval("srvLimitFormObj.srvLimit_refund"+i).checked &&
				 * (eval("srvLimitFormObj.srvLimit_refundAmt"+i).value=="" )) {
				 * message=getMessage("BL8545",'BL');
				 * obj=eval("srvLimitFormObj.srvLimit_refundAmt"+i);
				 * alert(message) obj.focus(); return false }
				 */

				message = "";
				if (eval("srvLimitFormObj.srvLimit_refund" + i) != null
						&& eval("srvLimitFormObj.srvLimit_refund" + i).checked) {
					if (eval("srvLimitFormObj.srvLimit_refundAmt" + i).value == ""
							|| eval("srvLimitFormObj.srvLimit_refundAmt" + i).value == "Amt") {
						message = getMessage("BL8666", 'BL');
					} else if (parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"
							+ i).value) == 0
							|| parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"
									+ i).value) < 0) {
						message = getMessage("BL8545", 'BL');
					} else if (parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"
							+ i).value) < 1
							|| parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"
									+ i).value) > 100) {
						message = getMessage("BL8653", 'BL');
					}
					if (message != "") {
						alert(message);
						eval("srvLimitFormObj.srvLimit_refundAmt" + i).focus();
						return false
					}
				}
				message = "";
				if (eval("srvLimitFormObj.srvLimit_roundTo" + i).value == null
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == ""
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == "10"
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == "50"
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == "100"
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == "500"
						|| eval("srvLimitFormObj.srvLimit_roundTo" + i).value == "1000") {
					message = "";
				} else {
					message = getMessage("BL8681", 'BL');
					obj = eval("srvLimitFormObj.srvLimit_roundTo" + i);
				}
				if (message != "") {
					alert(message)
					obj.focus();
					return false
				}
			}
		}
		if (source != "apply") {

			var xmlString = formXMLString(srvLimitFormObj,
					"SRVLIMIT_RATE_BASED", "excln", packageCode);
			var updation = formValidation(xmlString, "SRVLIMIT_RATE_BASED");
		}
		return true;
	} else {
		return true;
	}

}
function validateRateForm(formObj, srvLimitFormObj, packageCode) {
	var totalRecords = formObj.totalRecords.value;
	// var messageFrame=parent.parent.frames[2];
	var obj;
	var message = "";
	var order_associated = formObj.order_associated.value;
	var result = true;
	var acrossEncounters = formObj.acrossEncounters.value;
	var closePkgChk = true;
	var serviceExists = false;

	if (srvLimitFormObj != null) {
		result = validateServiceLimitForm(srvLimitFormObj, packageCode, "",
				'apply');
	}
	if (result) {
		if (order_associated == "Y") {
			for ( var i = 0; i < parseInt(totalRecords); i++) {
				// for(var i=0;i<parseInt(totalRecords);i++){
				if (eval("formObj.service_code" + i) != null
						&& eval("formObj.service_code" + i).value != "") {
					if (eval("formObj.catalog_code" + i).value == "") {
						message = getMessage("BL8562", 'BL');

						alert(message);
						return false;
						// obj=eval("formObj.catalog_code"+i);
					}
					if (eval("formObj.catalog_code" + i).value != ""
							&& eval("formObj.qty_limit" + i).value == "") {
						message = getMessage("BL8538", 'BL');
						// obj=eval("formObj.qty_limit"+i);
						alert(message);
						return false;
					}
					/*
					 * if(message!=""){ alert(message);
					 * //messageFrame.location.href =
					 * "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					 * //obj.focus(); return false }
					 */
				}
				// }
			}
		}
		message = "";
		for ( var i = 0; i < parseInt(totalRecords); i++) {
			if (eval("formObj.service_code" + i) != null
					&& eval("formObj.service_code" + i).value != "") {
				if (eval("formObj.refund" + i) != null
						&& eval("formObj.refund" + i).checked) {

					if (eval("formObj.refundAmt" + i).value == ""
							|| eval("formObj.refundAmt" + i).value == "Amt") {
						message = getMessage("BL8666", 'BL');
					} else if (parseInt(eval("formObj.refundAmt" + i).value) == 0
							|| parseInt(eval("formObj.refundAmt" + i).value) < 0) {
						message = getMessage("BL8545", 'BL');
					} else if (parseInt(eval("formObj.refundAmt" + i).value) < 1
							|| parseInt(eval("formObj.refundAmt" + i).value) > 100) {
						message = getMessage("BL8653", 'BL');
					}
					if (message != "") {
						alert(message);
						eval("formObj.refundAmt" + i).focus();
						return false
					}
				}
				if (eval("formObj.amt_limit_ind" + i) != null
						&& eval("formObj.amt_limit_ind" + i).value != ""
						&& eval("formObj.amt_limit_ind" + i).value != "U"
						&& (eval("formObj.perAmt_limit" + i).value == "")) {
					message = getMessage("BL8561", 'BL');
					alert(message);
					eval("formObj.perAmt_limit" + i).focus();
					return false
				}
				if (eval("formObj.roundTo" + i).value == null
						|| eval("formObj.roundTo" + i).value == ""
						|| eval("formObj.roundTo" + i).value == "10"
						|| eval("formObj.roundTo" + i).value == "50"
						|| eval("formObj.roundTo" + i).value == "100"
						|| eval("formObj.roundTo" + i).value == "500"
						|| eval("formObj.roundTo" + i).value == "1000") {
					message = "";
				} else {
					message = getMessage("BL8681", 'BL');
					obj = eval("formObj.roundTo" + i);
				}

				if (message != "") {
					// messageFrame.location.href =
					// "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					alert(message);
					obj.focus();
					return false
				}
			}
		}
		message = "";

		if (acrossEncounters == "Y") {
			closePkgChk = false;

			for ( var i = 0; i < parseInt(totalRecords); i++) {
				if (eval("formObj.service_code" + i) != null
						&& eval("formObj.service_code" + i).value != "") {
					serviceExists = true;
					if (eval("formObj.closePkg" + i + ".value") == "Y") {
						closePkgChk = true;
						break;
					}
				}
			}
		}

		if (serviceExists && !closePkgChk) {
			alert(getMessage("BL8678", 'BL'));
			return false;
		}

		return true;
	} else
		return false;
}
function validateChildPackage(formObj,totalRec){
	
	var flag = true;

	
	for ( var i = 0; i < totalRec; i++) {
	
		if ((eval("formObj.childPackCode_" + i) != undefined && eval("formObj.childPackCode_" + i).value == "")) {
			alert("Atleast One Entry for Child Package Must be Provided");
			if(parent.PkgDefBaseDateMain != null && parent.PkgDefBaseDateMain != undefined ){
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.child_package_tab_checked.value = "N";
		}
		return false;
		}
		
		else if ((eval("formObj.fromDate_" + i) != undefined && eval("formObj.fromDate_" + i).value == "")) {
			alert("From Date Cannot be Null");
			if(parent.PkgDefBaseDateMain != null && parent.PkgDefBaseDateMain != undefined ){
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.child_package_tab_checked.value = "N";
		}
		return false;
		}
	/*	else if ((eval("formObj.toDate_" + i) != undefined && eval("formObj.toDate_" + i).value == "")) {
			alert("To Date cannot Be Null");
			if(parent.PkgDefBaseDateMain != null && parent.PkgDefBaseDateMain != undefined ){
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.child_package_tab_checked.value = "N";
		}
		return false;
		}*/
	
	}
	return flag;
	
	
	
}
function chkAcrossEncounters(obj) {
	if (obj.checked) {
		obj.value = "Y";
		if (document.frmPkgDefHeader.mode.value == "insert") {
			// document.frmPkgDefHeader.validDays.value="";--------- Commented
			// by lakshmi 18/10/2011
		} else {
			document.frmPkgDefHeader.validDays.disabled = false;
			document.frmPkgDefHeader.oldValidDays.value = document.frmPkgDefHeader.validDays.value
			// document.frmPkgDefHeader.validDays.value=""; --------- Commented
			// by lakshmi 12/10/2011
		}
	} else
		obj.value = "N";
}
function chkValidDays(obj, mode) {
	if (mode != "insert") {
		if (obj.value <= 0) {
			alert(getMessage("BL8569", "BL"));
			// obj.value = document.frmPkgDefHeader.oldValidDays.value;
			obj.value = "";
			obj.focus();
		} else if (obj.value == "") {
			alert(getMessage("BL8571", "BL"));
			obj.focus();
		}
		/*
		 * Commented against incident 43585 on 04/10/2013 else if(obj.value<parseInt(document.frmPkgDefHeader.oldValidDays.value)) {
		 * alert('Valid Days should be greater than
		 * '+document.frmPkgDefHeader.oldValidDays.value); obj.value = "";
		 * obj.focus(); }
		 */
	}

}

function chkApplTo(obj) {

	if (obj.value == "A" || obj.value == "") {
		parent.parent.frames[0].document.getElementById("CUSTOMER").disabled = true;
	} else {
		parent.parent.frames[0].document.getElementById("CUSTOMER").disabled = false;

	}
}
//Added V190325 Gayathri/KDAH-CRF-0503/Starts
function chkMasterpack(obj) {

	if(obj.checked == true){
		obj.value='Y';
		parent.frames[2].document.forms[0].document.getElementById("CHILD_PACK").disabled = false;
	}
	else{
		obj.value='N';
		parent.frames[2].document.forms[0].document.getElementById("CHILD_PACK").disabled = true;
	}

}
function chkMasterpack1(){	
	if(document.forms[0].allow_masterChild_package_map.value == 'Y'){
		if(document.forms[0].isMasterPackYN.value== 'Y'){
		document.getElementById("CHILD_PACK").disabled = false;
		}
		else{
			document.getElementById("CHILD_PACK").disabled = true;
		}
	}/*add for incident 73603 */
	
	if(document.forms[0].siteAutoApplyPkgDiscYN.value == 'true'){		
		var mode=parent.parent.frames[0].document.forms[0].mode.value;
		if(mode!="modify")
		{
		if(document.forms[0].newPkg.value == 'Y'){			
		parent.parent.frames[0].document.getElementById("DISCOUNT").disabled = true;
		}
		else{		
			parent.parent.frames[0].document.getElementById("DISCOUNT").disabled = false;			
		}/*add for incident 73603 */
		}
	}
}

function chkmas(){
	if(document.forms[0].allow_masterChild_package_map.value == 'Y'){
	
	if(parent.frames[0].document.forms[0].mast_pack.checked){
	
	parent.frames[2].document.forms[0].document.getElementById("CHILD_PACK").disabled = false;
	
	}
	else{
		
		parent.frames[2].document.forms[0].document.getElementById("CHILD_PACK").disabled = true;
		
	}
	}
}
//Added V190325 Gayathri/KDAH-CRF-0503/Ends
async function copyPkg() {
	var queryString = "copyFrm_pkgCode="
			+ document.frmPkgDefHeader.copyFrm_pkgCode.value
			+ "&copyFrm_pkgDesc="
			+ document.frmPkgDefHeader.copyFrm_pkgDesc.value
			+ "&copyTo_pkgCode=" + document.frmPkgDefHeader.packageCode.value
			+ "&copyTo_longDesc=" + document.frmPkgDefHeader.longDesc.value
			+ "&copyTo_shortDesc=" + document.frmPkgDefHeader.shortDesc.value
			+ "&copyTo_effFromDate="
			+ document.frmPkgDefHeader.effFromDate.value;
	var retVal = new String();
	var dialogHeight = "13";
	var dialogWidth = "30";
	var status = "no";
	var arguments = "";
	var title = getLabel("eBL.CopyPackage.label", "BL");
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + " ; scroll=no;  status:" + status;
	retVal =await window.showModalDialog("../../eBL/jsp/PkgDefCopyPkg.jsp?"
			+ queryString, arguments, features);
	if (retVal != null) {
		document.frmPkgDefHeader.copyFrm_pkgCode.value = retVal[0];
		document.frmPkgDefHeader.copyFrm_pkgDesc.value = retVal[1];
		document.frmPkgDefHeader.packageCode.value = retVal[2];
		document.frmPkgDefHeader.longDesc.value = retVal[3];
		document.frmPkgDefHeader.shortDesc.value = retVal[4];
		document.frmPkgDefHeader.effFromDate.value = retVal[5];
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.fromDate_0.value = retVal[5];
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.fromDatePrev_0.value = retVal[5];
		parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value = retVal[5];
		parent.PkgDefTabFrame.document.frmPkgDefTab.index.value = 0;
	}

}
function copyFrm_pkgCodeLookUp(pkg_desc, pkg_code) {
	var formObj = document.copy_pkg;
	if (formObj != null) {
		if (formObj.copyFrm_pkgCode_temp.value != formObj.copyFrm_pkgCode.value) {
			if (formObj.copyFrm_pkgCode.value != "") {
				var argumentArray = new Array();
				var dataNameArray = new Array();
				var dataValueArray = new Array();
				var dataTypeArray = new Array();
				var title = getLabel("eBL.CopyPackage.label", "BL");
				var locale = formObj.locale.value;
				argumentArray[0] = "select package_code code , short_desc  description from bl_package_lang_vw where language_id='"
						+ locale
						+ "' and upper(package_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				argumentArray[4] = "1,2";
				argumentArray[5] = pkg_code.value;
				argumentArray[6] = CODE_LINK;
				argumentArray[7] = CODE_DESC;
				retVal = CommonLookup(title, argumentArray);
				if (retVal != null && retVal != "") {
					pkg_desc.value = retVal[1];
					pkg_code.value = retVal[0];
					formObj.copyFrm_pkgCode_temp.value = retVal[0];
					formObj.copyFrm_pkgDesc_temp.value = retVal[1];
				} else {
					pkg_desc.value = "";
					pkg_code.value = "";
					formObj.copyFrm_pkgCode_temp.value = "";
					formObj.copyFrm_pkgDesc_temp.value = "";
				}
			}
		}
	}

}
function copyFrm_pkgDescLookUp(pkg_desc, pkg_code) {
	var formObj = document.copy_pkg;
	if (formObj != null) {
		if (formObj.copyFrm_pkgDesc_temp.value != formObj.copyFrm_pkgDesc.value) {
			if (formObj.copyFrm_pkgDesc.value != "")

				show_copyPkgLookUp(pkg_desc, pkg_code);
		}
	}
}
function copyFrm_PkgLookUp(pkg_desc, pkg_code) {
	var formObj = document.copy_pkg;
	if (formObj != null) {
		if (formObj.copyFrm_pkgDesc.value == "") {
			show_copyPkgLookUp(pkg_desc, pkg_code);
		}
	}
}
function show_copyPkgLookUp(pkg_desc, pkg_code) {
	var formObj = document.copy_pkg;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("eBL.PACKAGE_DTL.label", "BL");
	var locale = formObj.locale.value;
	argumentArray[0] = "select package_code code , short_desc  description from bl_package_lang_vw where language_id='"
			+ locale
			+ "' and upper(package_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = pkg_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = CommonLookup(title, argumentArray);
	if (retVal != null && retVal != "") {
		pkg_desc.value = retVal[1];
		pkg_code.value = retVal[0];
		formObj.copyFrm_pkgCode_temp.value = retVal[0];
		formObj.copyFrm_pkgDesc_temp.value = retVal[1];
	} else {
		pkg_desc.value = "";
		pkg_code.value = "";
		formObj.copyFrm_pkgCode_temp.value = "";
		formObj.copyFrm_pkgDesc_temp.value = "";
	}
}
function saveCopyPkg() {
	var formObj = document.copy_pkg;
	var err_mess = "";
	if (formObj.copyFrm_pkgCode.value == "") {
		err_mess = getMessage("BL8501", "BL") + "\n";
	}
	if (formObj.copyFrm_pkgDesc.value == "") {
		err_mess += getMessage("BL8502", "BL") + "\n";
	}
	if (formObj.copyTo_pkgCode.value == "") {
		err_mess += getMessage("BL8501", "BL") + "\n";
	}

	if (formObj.copyTo_shortDesc.value == "") {
		err_mess += getMessage("BL8502", "BL") + "\n";
	}

	if (formObj.copyTo_longDesc.value == "") {
		err_mess += getMessage("BL8503", "BL") + "\n";
	}

	if (formObj.copyTo_effFromDate.value == "") {
		err_mess += getMessage("BL8504", "BL") + "\n";
	}

	if (err_mess == "") {
		/* putting into bean */

		var xmlStr = "<root><SEARCH ";
		xmlStr += "packageCode=\"" + document.copy_pkg.copyTo_pkgCode.value
				+ "\" ";
		xmlStr += "copyFrm_pkgCode=\""
				+ document.copy_pkg.copyFrm_pkgCode.value + "\" ";
		xmlStr += "fromDate=\"" + document.copy_pkg.copyTo_effFromDate.value
				+ "\" ";
		xmlStr += "facilityId=\"" + document.copy_pkg.facilityId.value + "\" ";
		xmlStr += " /></root>";
		var updation = formValidation(xmlStr, "COPY_VALUES");
		var retVal = new Array();
		retVal[0] = document.copy_pkg.copyFrm_pkgCode.value;
		retVal[1] = document.copy_pkg.copyFrm_pkgDesc.value;
		retVal[2] = document.copy_pkg.copyTo_pkgCode.value;
		retVal[3] = document.copy_pkg.copyTo_longDesc.value;
		retVal[4] = document.copy_pkg.copyTo_shortDesc.value;
		retVal[5] = document.copy_pkg.copyTo_effFromDate.value;
		window.returnValue = retVal;
		window.close();
	} else {
		alert(err_mess);
	}
}

/** *************** rate based validations********end***** */
// For switching tabs - maintaining values
function showTabDetail(obj, flag, from, index) {	
	link = obj;
	var headerFrmObj = "";
	var frameObj = ""
	var current_form = ""
	var excln_form = ""
	var totRec = "";
	if (index == "" || index == undefined) {

		headerFrmObj = parent.PkgDefHeader.document.frmPkgDefHeader
		frameObj = parent.frames[3]

	} else {
		headerFrmObj = parent.parent.PkgDefHeader.document.frmPkgDefHeader;
		frameObj = parent.parent.frames[3]
		current_form = "parent."
		excln_form = "parent."
	}
	var authorized = eval("headerFrmObj.authorized").value;
	var pkgApprovedYN = eval("headerFrmObj.pkgApprovedYN").value;
	fromDate = document.forms[0].fromDate.value;
	if (fromDate == null || fromDate == "")
		fromDate = parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.fromDate_0.value;
	var excln_link = "";

	if (eval("headerFrmObj.current_form1").value != "")
		current_form = current_form + eval("headerFrmObj.current_form1").value;
	else
		current_form = "";
	if (eval("headerFrmObj.current_form2").value != "")
		excln_form = excln_form + eval("headerFrmObj.current_form2").value;
	else
		excln_form = "";

	var result = true;
	var last_link = eval("headerFrmObj.last_link").value;

	// Karthik added code here MMS-QF-SCF-0545 Starts
	if (obj == 'PACKAGE_PRICE') {
		if (parent.PkgDefBaseDateMain != null
				&& parent.PkgDefBaseDateMain != undefined)
			parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value = "Y";
	
//	alert(parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value);
	}
	if (obj == 'RATE_BASED') {
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "Y";
	}
	if (obj == 'CHARGE_BASED') {
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "Y";
	}
	if (obj == 'CHILD_PACK') {
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.child_package_tab_checked.value = "Y";
	}
	// Karthik added code here MMS-QF-SCF-0545 Ends

	if (last_link == "CHARGE_BASED") {
		excln_link = "CHARGE_BASED_ITEM";

		// result
		// =validateChargeBased(eval("frameObj.frames[0].document.frmPkgDefChargeBased"),eval("headerFrmObj.total_records").value)
		// commented line and added new line by ram
		result = validateChargeBased(
				eval("frameObj.frames[1].document.frmPkgDefChargeBased"),
				eval("headerFrmObj.total_records").value)
		if (result) {
			// alert(result);
			if (eval("frameObj.frames[3].document.frmPkgDefChargeBasedExcln") != undefined)
				result = validateChargeBasedItems(
						eval("frameObj.frames[3].document.frmPkgDefChargeBasedExcln"),
						eval("headerFrmObj.total_records_excln").value)
		}
	} else if (last_link == "RATE_BASED") {
		excln_link = "SRVLIMIT_RATE_BASED";
		// COMMENTED BY RAM AND ADDED NEW LINE
		// //result=validateRateForm(eval("frameObj.frames[0].document.rate_based_dtl"),eval("frameObj.frames[2].document.srvLimit_rate_based_dtl"),eval("headerFrmObj.packageCode").value);
		result = validateRateForm(
				eval("frameObj.frames[1].document.rate_based_dtl"),
				eval("frameObj.frames[4].document.srvLimit_rate_based_dtl"),
				eval("headerFrmObj.packageCode").value);
	}
	else if (last_link == "CHILD_PACK") {
		
		result = validateChildPackage(
					eval("frameObj.frames[0].document.forms[0]"),eval("frameObj.frames[0].document.forms[0]").totRec);
	} 
	
	
	else if (last_link == "PACKAGE_PRICE") {
		var frmBasePriceObj = "";
		if (index == "" || index == undefined) {
			// commented by ram july23-10 and added new lins
			// totRec =
			// eval("parent.frames[3].frames[0].document.forms[0].totRec").value
			// frmBasePriceObj =
			// "parent.frames[3].frames[0].document.frmPkgDefBasePrice";
			// alert("parent.frames[3].frames[1].document.forms[0]
			// "+parent.frames[3].frames[1].document.forms[0].name);
			totRec = eval("parent.frames[3].frames[1].document.forms[0].totRec").value
			frmBasePriceObj = "parent.frames[3].frames[1].document.frmPkgDefBasePrice";
		} else {
			totRec = eval("parent.parent.PkgDefDetailFrame.basePriceDtl.document.forms[0].totRec").value
			frmBasePriceObj = "parent.parent.PkgDefDetailFrame.basePriceDtl.document.frmPkgDefBasePrice";

		}
		result = validatePackagePrice(frmBasePriceObj, totRec);

	}
	else if (last_link == "CHILD_PACK") {
		result = validateChildPackages(
				eval("frameObj.frames[0].document.ass_child_pack_dtl"),
				eval("headerFrmObj.packageCode").value);
	}
	
	
	if (result) {
		var packageCode = eval("headerFrmObj.packageCode").value;
		var copyFrm_pkgCode = "";
		if (from == "PACKAGE")
			copyFrm_pkgCode = eval("headerFrmObj.copyFrm_pkgCode").value;

		var orderAssociated = eval("headerFrmObj.orderAssociated").value;
		var mode = eval("headerFrmObj.mode").value;
		var frmObj = eval(excln_form)

		if (frmObj != null && frmObj != "undefined" && from != "DATE_CNG") {
			var xmlString = formXMLString(frmObj, excln_link, "tab",
					packageCode);

			var updation = formValidation(xmlString, excln_link);

		}

		frmObj = eval(current_form);
		if (frmObj != null && frmObj != "undefined" && from != "DATE_CNG") {
			var xmlString = formXMLString(frmObj, last_link, "tab", packageCode);
			var updation = formValidation(xmlString, last_link);
		}
		/*alert('val '+parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value);*/
		
		if (link == "PACKAGE_PRICE") {				
			if (flag == '1' && !(packageCode == null || packageCode == "")
					&& !(fromDate == null || fromDate == "")) {
				if (index == "" || index == undefined) {
					selectTabForPkg(obj);
				} else {
					selectTabForPkg(obj, "1");
				}

				eval("frameObj").location.href = '../../eBL/jsp/PkgDefBasePriceMain.jsp?packageCode='
						+ packageCode
						+ '&mode='
						+ mode
						+ '&from='
						+ from
						+ '&authorized='
						+ authorized
						+ '&pkgApprovedYN='
						+ pkgApprovedYN
						+ '&fromDate='
						+ encodeURIComponent(fromDate);
			} else {
				if (packageCode == null || packageCode == "")
					alert(getMessage("BL8501", 'BL'));
				else if (fromDate == null || fromDate == "")
					alert(getMessage("BL8643", 'BL'));
			}
		} else if (link == "CHARGE_BASED") {

			var orderAssociated = eval("headerFrmObj.orderAssociated").value;
			if (flag == '1' && !(packageCode == null || packageCode == "")
					&& !(fromDate == null || fromDate == "")) {
				if (orderAssociated == "Y") {
					alert(getMessage("BL8578", 'BL'));
				} else {
					selectTabForPkg(obj);

					var totRec = parent.frames[1].frames[0].document.forms[0].totRec.value;
					var fromDateVals = "";
					for ( var i = 0; i < totRec; i++) {
						fromDateVals = fromDateVals
								+ eval("parent.frames[1].frames[0].document.forms[0].fromDate_"
										+ i).value + "|";
					}
					eval("frameObj").location.href = '../../eBL/jsp/PkgDefChargeBasedMain.jsp?packageCode='
							+ packageCode
							+ '&mode='
							+ mode
							+ '&copyFrm_pkgCode='
							+ copyFrm_pkgCode
							+ '&authorized='
							+ authorized
							+ '&pkgApprovedYN='
							+ pkgApprovedYN
							+ '&fromDate='
							+ encodeURIComponent(fromDate)
							+ "&fromDateVals="
							+ encodeURIComponent(fromDateVals);
				}
			} else {
				if (packageCode == null || packageCode == "")
					alert(getMessage("BL8501", 'BL'));
				else if (fromDate == null || fromDate == "")
					alert(getMessage("BL8643", 'BL'));
			}
		} else if (link == "RATE_BASED") {

			// if(from == "PACKAGE")
			// {
			var acrossEncounters = eval("headerFrmObj.acrossEncounters").value;

			if (flag == '1' && !(packageCode == null || packageCode == "")
					&& !(fromDate == null || fromDate == "")) {
				selectTabForPkg(obj);

				var totRec = parent.frames[1].frames[0].document.forms[0].totRec.value;
				var fromDateVals = "";
				for ( var i = 0; i < totRec; i++) {
					fromDateVals = fromDateVals
							+ eval("parent.frames[1].frames[0].document.forms[0].fromDate_"
									+ i).value + "|";
				}
				eval("frameObj").location.href = '../../eBL/jsp/PkgDefRateFrame.jsp?packageCode='
						+ packageCode
						+ '&mode='
						+ mode
						+ '&orderAssociated='
						+ orderAssociated
						+ '&copyFrm_pkgCode='
						+ copyFrm_pkgCode
						+ "&from="
						+ from
						+ '&acrossEncounters='
						+ acrossEncounters
						+ '&authorized='
						+ authorized
						+ '&pkgApprovedYN='
						+ pkgApprovedYN
						+ '&fromDate='
						+ encodeURIComponent(fromDate)
						+ "&fromDateVals="
						+ encodeURIComponent(fromDateVals);
			} else {
				if (packageCode == null || packageCode == "")
					alert(getMessage("BL8501", 'BL'));
				else if (fromDate == null || fromDate == "")
					alert(getMessage("BL8643", 'BL'));
			}
			
		}
	//Added V190325 Gayathri/KDAH-CRF-0503
		else if (link == "CHILD_PACK") {
		
			var acrossEncounters = eval("headerFrmObj.acrossEncounters").value;
			var mast_packagae = eval("headerFrmObj.mast_pack").value;
			if (flag == '1' && !(packageCode == null || packageCode == "")
					&& !(fromDate == null || fromDate == "")) {
				selectTabForPkg(obj);

				var totRec = parent.frames[1].frames[0].document.forms[0].totRec.value;
				var fromDateVals = "";
				for ( var i = 0; i < totRec; i++) {
					fromDateVals = fromDateVals
							+ eval("parent.frames[1].frames[0].document.forms[0].fromDate_"
									+ i).value + "|";
				}
				eval("frameObj").location.href = '../../eBL/jsp/AsscosiateChildPackFrame.jsp?packageCode='
						+ packageCode
						+ '&mode='
						+ mode
						+ '&orderAssociated='
						+ orderAssociated
						+ '&copyFrm_pkgCode='
						+ copyFrm_pkgCode
						+ "&from="
						+ from
						+ '&acrossEncounters='
						+ acrossEncounters
						+ '&authorized='
						+ authorized
						+ '&pkgApprovedYN='
						+ pkgApprovedYN
						+ '&fromDate='
						+ encodeURIComponent(fromDate)
						+ "&fromDateVals="
						+ encodeURIComponent(fromDateVals);
			} else {
				if (packageCode == null || packageCode == "")
					alert(getMessage("BL8501", 'BL'));
				else if (fromDate == null || fromDate == "")
					alert(getMessage("BL8643", 'BL'));
			}
			//Added V190325 Gayathri/KDAH-CRF-0503/Ends
		}
	}
}
// Function to load Charge based limit page
function loadChargeBasedServiceLimit(value, index) {
	var frmObj = parent.ChargeBasedExCln.document.forms[0];
	var packageCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
	// var
	// curDate=parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value;
	// var
	// copyFrm_pkgCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.copyFrm_pkgCode.value;
	var fromDate = document.forms[0].fromDate.value;
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	var totRec = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
	var mode = parent.parent.PkgDefHeader.document.forms[0].mode.value
	if (frmObj != null && frmObj != undefined) {
		var xmlString = formXMLString(frmObj, "CHARGE_BASED_ITEM", "excln",
				packageCode);
		var updation = formValidation(xmlString, "CHARGE_BASED_ITEM");
	}
	var srvLmtChk = eval("document.forms[0].srvLmt_" + index).value;
	if (value == null || value == "") {
		alert(getMessage("BL8559", 'BL'));
		parent.ChargeBasedExCln.location.href = '../../eCommon/html/blank.html';
	} else if (srvLmtChk == "Y") {
		// parent.ChargeBasedExCln.location.href='../../eBL/jsp/PkgDefChargeBasedExclusion.jsp?packageCode='+packageCode+'&serviceCode='+value+'&mode='+mode+'&copyFrm_pkgCode='+copyFrm_pkgCode;
		copyFrm_pkgCode = parent.parent.PkgDefHeader.frmPkgDefHeader.copyFrm_pkgCode.value;
		parent.ChargeBasedExCln.location.href = '../../eBL/jsp/PkgDefChargeBasedExclusion.jsp?packageCode='
				+ packageCode
				+ '&serviceCode='
				+ value
				+ '&authorized='
				+ authorized
				+ '&pkgApprovedYN='
				+ pkgApprovedYN
				+ '&mode='
				+ mode
				+ '&fromDate='
				+ encodeURIComponent(fromDate)
				+ "&copyFrm_pkgCode=" + copyFrm_pkgCode;
		parent.ChargeBasedItemBtn.location.href = '../../eBL/jsp/PkgDefChargeBasedBtn.jsp?packageCode='
				+ packageCode
				+ '&table_name=pkgCbasedItem&func_mode=CHARGE_BASED_ITEM&authorized='
				+ authorized
				+ '&pkgApprovedYN='
				+ pkgApprovedYN
				+ '&mode='
				+ mode

	} else {
		loadBalnk();
	}
}
function callLookup(obj, code, desc, functionId, index) {
	var prevCode = eval("document.forms[0].cbCodePrev_" + index)
	var prevDesc = eval("document.forms[0].cbDescPrev_" + index)
	var flag = false;

	if (obj.value == "")
		clearRow(document.forms[0], index);

	else {
		if (prevCode.value != "" && code.value != prevCode.value) {
			desc.value = ""
			prevCode.value = "";
			flag = true;
		} else if (prevDesc.value != "" && desc.value != prevDesc.value) {
			code.value = "";
			prevDesc.value = "";
			flag = true;
		}
		if (code.value == "" || desc.value == "" || flag){
			// callServices(code,desc,functionId,index)
			
			if(functionId=='CHARGE_BASED_ITEM'){
				callServices(code, desc, functionId, '', index)
			}
			else
				{
				callServices(code, desc, functionId, eval("document.forms[0].charge_type"+index), index)
				
				}
		}
	}
}

function makeReadOnly(obj, des, source, index) {
	if (obj.value != null && obj.value != "") {
		eval(des).value = "";
		eval(des).disabled = true;
		if (source == "per") {
			validPercentage(this)
			if (eval("document.forms[0].factor_appl" + index).value == "Y")
				eval("document.forms[0].factor_appl" + index).value = "N"
			eval("document.forms[0].factor_appl" + index).disabled = false
		} else
			eval("document.forms[0].factor_appl" + index).disabled = true;
	} else {
		eval(des).disabled = false;
	}
	// return true;
}
// Updating current form while switching tabs
function updateCurrentForm(last_link, form_name1, form_name2, formObject,
		totRec) {
	eval(formObject).last_link.value = last_link;
	eval(formObject).current_form1.value = form_name1;
	eval(formObject).current_form2.value = form_name2;
	eval(formObject).total_records.value = totRec;
	// eval(formObject).form_modify.value="N";
}

function updateNoofExcln(totRec, mode) {
	if (mode == 1) {
		parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value = totRec;
		// :"+parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value)
	} else
		parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value = totRec;
}

// forming XML String while switching tabs
function formXMLString(curr_form, last_link, source, packageCode) {
	var frmObj = "";
	// var packageCode="";
	var total_records = "";
	var facilityId = "";
	var locale = "";
	var mode = "";
	if (source == "apply") {
		total_records = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
		facilityId = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
		if (last_link == "CHARGE_BASED_ITEM"
				|| last_link == "SRVLIMIT_RATE_BASED")
			total_records = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;

	} else if (source == "tab") {
		if (parent.PkgDefHeader == undefined) {
			total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
			facilityId = parent.parent.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
			// locale=parent.parent.PkgDefHeader.document.frmPkgDefHeader.locale.value;
			// mode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		} else {
			total_records = parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
			facilityId = parent.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
			// locale=parent.PkgDefHeader.document.frmPkgDefHeader.locale.value;
			// mode=parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		}

	} else if (source == "excln") {
		if (parent.parent.PkgDefHeader == undefined)
			total_records = parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
		else
			total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
	} else if (source == "maintab") {
		total_records = parent.parent.PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
		facilityId = parent.parent.PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
	}

	submitParams	= "";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20

	frmObj = curr_form;
	if (frmObj != null && frmObj != undefined && frmObj.length > 0) {
		var xmlStr = "<root><SEARCH ";
		if (true) {
			var arrObj = frmObj.elements;			
			for ( var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/
					//submitParams	+= arrObj[i].name +"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					submitParams	+= arrObj[i].name +"="+checkSpl(val)+"\" ";//added by Nandhini against GHL-SCF-1635
					//alert("9061==>"+submitParams);
					}
				} else if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
						if (arrObj[i].name != null && arrObj[i].name != ""){
						/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
									+ "\" ";*/
						//submitParams	+= arrObj[i].name +"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
						submitParams	+= arrObj[i].name +"="+checkSpl(val)+"\" ";//added by Nandhini against GHL-SCF-1635
						//alert("9069==>"+submitParams);
						}
					}
				} else if (arrObj[i].type == "select-multiple") {
					for ( var j = 0; j < arrObj[i].options.length; j++) {
						if (arrObj[i].options[j].selected)
							val += arrObj[i].options[j].value + "~"
					}
					val = val.substring(0, val.lastIndexOf('~'))
					if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/
					submitParams	+= arrObj[i].name +"="+checkSpl(val)+"\" ";//added by Nandhini against GHL-SCF-1635
					//submitParams	+= arrObj[i].name +"="+(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					}
				} else {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/								
					submitParams	+= arrObj[i].name +"="+checkSpl(val)+"\" ";//added by Nandhini against GHL-SCF-1635
					//submitParams	+= arrObj[i].name +"="+checkSpldescrp(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					}
				}
			}
		}		
		/*
		 * if(last_link != "CHARGE_BASED_ITEM") { xmlStr+= "total_records=\"" +
		 * total_records + "\" " ; } else {
		 * //packageCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
		 * total_records=document.frmPkgDefChargeBased.total_records_cbi.value;
		 * //alert("total_records:"+total_records) xmlStr+= "total_records=\"" +
		 * total_records + "\" " ; }
		 */
		/*
		 * if(last_link == "CHARGE_BASED_ITEM") { if(source=="excln") {
		 * total_records=document.frmPkgDefChargeBased.total_records_cbi.value; }
		 * else {
		 * total_records=parent.frames[2].frames[0].document.frmPkgDefChargeBased.total_records_cbi.value;
		 *  } }
		 */
		// if(source!="apply")
		// {
		if (last_link == "CHARGE_BASED_ITEM") {
			var frmObject = "";
			if (source != "apply") {
				if (source == "maintab") {
					// frames ref changed charge based detail frames moved to
					// frames[1] by ram
					// frmObject =
					// parent.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[0].document.frmPkgDefChargeBased
					frmObject = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
							.frames[1].document.frmPkgDefChargeBased
				} else {
					if (document.frmPkgDefChargeBased == undefined){
						
						//frmObject = parent.frames[1].document.frmPkgDefChargeBased;  commented by Vijay (Refers to wrong frame hence frmObj is undefined )
						frmObject=parent.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased;
					}
					else
						frmObject = document.frmPkgDefChargeBased;
				}
			} else {
				frmObject = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased;
			}
			xmlStr += getServiceCodes(frmObject, last_link, source);
		}
		if (last_link == "SRVLIMIT_RATE_BASED") {

			var frmObject = "";
			if (source != "apply") {
				if (source == "maintab") {
					// changed frames[0] to frames[1] by ram
					frmObject = parent.PkgDefDetailMainFrame.PkgDefDetailFrame
							.frames[1].document.rate_based_dtl
				} else {
					// frmObject = parent.frames[0].document.rate_based_dtl
					// commented by ram added line

					//Modified By Vijay for GHL Internal Changes
					if (document.rate_based_dtl == undefined)
						{
						if(parent.PkgDefDetailFrame==undefined || parent.PkgDefDetailFrame=='undefined')
						{
							frmObject=parent.parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl
						}
						else{
						frmObject = parent.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl
						}
						}
					else
						{
						frmObject=document.rate_based_dtl;					
						}
				}
			} else {
				frmObject = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame
						.frames[1].document.rate_based_dtl;
			}
			xmlStr += getServiceCodes(frmObject, last_link, source);
		}

		// }

		xmlStr += "total_records=\"" + total_records + "\" ";
		xmlStr += "packageCode=\"" + packageCode + "\" ";
		xmlStr += "facilityId=\"" + facilityId + "\" ";
		// xmlStr+= "curDate=\"" + curDate + "\" " ;
		// xmlStr+= "mode=\"" + mode + "\" " ;
		xmlStr += " /></root>";
	}	
	return xmlStr;
}

// XML String passing for validation
function formValidation(xmlStr, last_link, event, calledFrom) // Newly Added
																// Parameter
																// "CalledFrom"
																// By Vijay For
																// GHL-SCF-1086
{
		var newMainParams=""; //V201010 added
	/*CHANGED FOR MMS-JU-SCF-0151 PALANINARAYANAN*/
	var temp_jsp = "../../eBL/jsp/PkgDefValidation.jsp?func_mode=" + last_link;
	if (event != null && event == "delete")
		temp_jsp = "../../eBL/jsp/PkgDefValidation.jsp?func_mode=" + last_link + "&event="
				+ event;

	/* Added By Vijay A.P. for GHL-SCF-1086 */
	if (last_link == 'SRVLIMIT_RATE_BASED' && calledFrom == 'apply') {
		// '+parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[4].document.srvLimit_rate_based_dtl.document.getElementById('from_date').value);
		var totRec = parent.frames[2].PkgDefFrame.frames[1].PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.document
				.getElementById('totRec').value
		totRec = totRec - 1;

		var fromDateNew = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[4].document.getElementById('fromDate').value;
				//document.srvLimit_rate_based_dtl.document
				//.getElementById('fromDate').value;
		var newDate = parent.frames[2].PkgDefFrame.frames[1].PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.document
				.getElementById('fromDate_' + totRec).value;

		temp_jsp += "&fromDateNew=" + fromDateNew + "&newDate=" + newDate;
	}
	
	
	/* *** ends *** */
	//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
	if(submitParamsMain!=""){
		//newMainParams	= newMainParams + "&" +submitParamsMain; //V201010 Modified
		newMainParams	= newMainParams + "\" "+submitParamsMain; //added by Nandhini against GHL-SCF-1635
		//alert("9272==>"+newMainParams);
	}
	if(submitParams!=""){
		
		//newMainParams	= newMainParams + "&" +submitParams; //V201010 Modified
		newMainParams	= newMainParams + "\" "+submitParams; //added by Nandhini against GHL-SCF-1635
		
	}
	//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20-6-12
	//var xmlDoc = new ActiveXObject("MSXML2.DOMDocument.6.0");
	/*var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	//var xmlHttp = new ActiveXObject("MSXML2.XMLHTTP");	
	var xmlHttp = new XMLHttpRequest();
    //xmlDoc.async = false;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);	
	xmlHttp.send(xmlDoc);	
	var responseText = xmlHttp.responseText;*/
//09-10-2020 MMS-KH-SCF-0108 Starts
	/* $.ajax({  
           type: 'POST',// type should be POST
           url: temp_jsp,
		   data:{"xmlStr": xmlStr, "newMainParams": newMainParams},
		   contentType: "text/html; charset=utf-8",
           dataType: "text",
           success: function(response){
			   alert("success "+response);
            eval(response);
           }
        });
		//V201010 Starts
		$.post(temp_jsp,
			{ xmlStr: xmlStr, newMainParams: newMainParams },
			function(data){
			eval(data);
		}
		);	
		//V201010 Ends
		*/	
		//V210119 Starts		
		$.ajax({
			type: 'POST',
			url: temp_jsp,
			data : { xmlStr: xmlStr, newMainParams: newMainParams },
			success: function(result) {
				if(result.indexOf('<!DOCTYPE html>')!=-1)
				{
					result = result.replace(/<!DOCTYPE html>/gi, "");
					result= trimString(result);
				}
				eval(result);
                  },
			async:   false
			});
		//V210119 Ends
		
		//setTimeout(function(){ return true; }, 6000);  //V201013 Added //Commented on 23-10-2020 against MMS-KH-SCF-0051.1 -PALANINARAYANAN

	
}
//09-10-2020 MMS-KH-SCF-0108 Ends

// for Date validation
function pkgValidateDate(obj, fromDateObj, toDate, index, from) {
	var fromDate = eval(fromDateObj).value;
	var toDate = eval(toDate).value;
	var locale = document.forms[0].locale.value;
	var totRec = document.forms[0].totRec.value;
	var pakEffDate = parent.parent.PkgDefHeader.document.forms[0].effFromDate.value;
	var flag = false;
	if (obj.value != "") {
		if (!(pakEffDate == null || pakEffDate == "" || fromDate == null || fromDate == "")) {
			if (validDateChk(obj)) {
				flag = true;
				if (!(fromDate == null || fromDate == "" || toDate == null || toDate == "")) {
					if ((!isBefore(fromDate, toDate, 'DMY', locale))) {
						alert(getMessage("BL4115", 'BL'));
						obj.value = "";
						obj.focus();
						flag = false;
					} else {
						// return false;
					}
				}
				if (flag && pakEffDate != "" && obj.value != ""
						&& (!(isAfter(obj.value, pakEffDate, 'DMY', locale)))) {
					// alert("Date should be greater than or equal to than
					// package effective from date")
					alert(getMessage("BL8512", 'BL'));

					flag = false;
					obj.value = "";
					obj.focus();
				}
				pakEffDate = parent.parent.PkgDefHeader.document.forms[0].effToDate.value;
				if (flag && pakEffDate != "" && obj.value != ""
						&& (!(isAfter(pakEffDate, obj.value, 'DMY', locale)))) {
					// alert("Date should be less than package effective to
					// date")
					alert(getMessage("BL8517", 'BL'));
					flag = false;
					obj.value = "";
					obj.focus();
				}
				if (flag && obj.value != "" && (index > 0 || totRec > 1))
					flag = overLapCheck(totRec, obj, index)
			} else
				flag = false
		} else {
			obj.value = "";
			if (pakEffDate == null || pakEffDate == "") {
				parent.parent.PkgDefHeader.document.forms[0].effFromDate
						.focus();
				alert(getMessage("BL8504", 'BL'))
			} else if (fromDate == null || fromDate == "") {
				eval(fromDateObj).focus();
				alert(getMessage("BL8643", 'BL'))
			}
			flag = false;
		}
	}
	return flag;
}

function overLapCheck(totRec, obj, index) {
	locale = document.forms[0].locale.value
	var fromCurDate = eval("document.forms[0].fromDate_" + index).value
	var toCurDate = eval("document.forms[0].toDate_" + index).value
	var flag = true
	for ( var i = 0; i < totRec; i++) {
		if (i != index) {
			fromDate = eval("document.forms[0].fromDate_" + i).value
			toDate = eval("document.forms[0].toDate_" + i).value
			// fromDate: "+fromDate + "toDate :"+toDate)
			if (fromDate != null && fromDate != "" && toDate != null
					&& toDate != "") {
				if (isBetween(fromDate, toDate, obj.value, 'DMY', locale)) {
					alert(getMessage("BL8514", 'BL'));
					obj.value = "";
					obj.focus();
					flag = false;

				} else if (fromCurDate != null && fromCurDate != ""
						&& toCurDate != null && toCurDate != "") {
					if (isBefore(fromCurDate, fromDate, 'DMY', locale)
							&& isAfter(toCurDate, toDate, 'DMY', locale)) {
						alert(getMessage("BL8514", 'BL'));
						obj.value = "";
						obj.focus();
						flag = false;
					}
				}
			} else if (fromDate != null && fromDate != ""
					&& fromCurDate != null && fromCurDate != "") {
				if (fromDate == fromCurDate) {
					alert(getMessage("BL8514", 'BL'));
					obj.value = "";
					return false; // sarath added MMS-QF-SCF-0545 To void Date
									// Loop
					obj.focus();
					flag = false;
				}
			}
		}
	}
	return flag;
}

// Validation for latest date

function validteForlatestDate(obj, val2) {
	val1 = obj.value;
	if (isBefore(val1, val2, 'DMY', document.forms[0].locale.value)) {
		alert("Please enter a date below allowed date :" + val2);
		obj.value = "";
		obj.focus();
		return false
	} else
		return true
}
// For Clearing the bean by putting package code
function clearBean(val) {
	var xmlStr = "<root><SEARCH ";
	xmlStr += "packageCode=\"" + val + "\" ";
	xmlStr += " /></root>";
	var updation = formValidation(xmlStr, "CLEAR_BEAN");
}

function showCalendar_eff(Val1) {
	return showCalendar(Val1);
}

function validDateChk(obj, chkVal) {
	var locale = document.forms[0].locale.value;
	if (obj.value != "") {
	if (validDate(obj.value, 'DMY', locale)) {
		var frmObj = "";
		if (chkVal == undefined || chkVal != "1") {
			if (parent.PkgDefBaseDateMain != undefined)
				frmObj = parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate;
			else
				frmObj = parent.baseDateDtl.document.frmPkgDefBaseDate;

			if (eval("frmObj.fromDate_0.value==''")) {
				eval("frmObj.fromDate_0").value = obj.value;
				eval("frmObj.fromDatePrev_0").value = obj.value;
			}

			if (parent.PkgDefTabFrame != undefined)
				frmObj = parent.PkgDefTabFrame.document.frmPkgDefTab;
			else
				frmObj = parent.parent.PkgDefTabFrame.document.frmPkgDefTab;

			if (eval("frmObj.fromDate.value==''"))
				eval("frmObj.fromDate").value = obj.value;
		}
		return true;
	} else {
		alert(getMessage("INVALID_DATE_FMT", "SM"));
		obj.value = "";
		obj.focus();
		return false;
	}
	} else {
		return true;
	}
}

function toFromdateChk(obj) {
	if (!(obj.value == "")) {
		var locale = document.forms[0].locale.value;
		var from_date = document.forms[0].effFromDate.value;
		var to_date = document.forms[0].effToDate.value;
		if (validDateChk(obj, '1')) {

			if (from_date == null || from_date == "") {
				alert(getMessage("BL8504", 'BL'));
				return false;
			} else if ((!isBefore(from_date, to_date, 'DMY', locale))) {
				alert(getMessage("BL4115", 'BL'));
				obj.select();
			} else {
				return false;
			}
		}
	} else {
		return false;
	}
}

function CheckForSpecChars_loc(event, obj) {
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (obj.value.length == 0) {
		if ('_'.indexOf(key) != -1)
			return false;
	}

	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}

function check_months(obj) {
	if (obj.value != "") {
		if (obj.value < 0 || obj.value > 11) {
			alert(getMessage("MONTHS_CHECK", 'Common'));
			obj.value = "";
			obj.focus();
		}
	}
}

function check_days(obj) {
	if (obj.value != "") {
		if (obj.value < 0 || obj.value > 30) {
			alert(getMessage("BL8645", 'BL'));
			obj.value = "";
			obj.focus();
		}
	}
}

function appChk(mode, obj) {
	var pkgAcrossEnctrYN=document.forms[0].pkgAcrossEnctrYN.value;
	//alert("pkgAcrossEnctrYN "+pkgAcrossEnctrYN)
	if (obj.checked == true) {
		obj.value = "Y";
		obj.checked = true;
		if (obj.name == "AllYn") {
			document.forms[0].IpYn.checked = true;
			document.forms[0].DcYn.checked = true;
			document.forms[0].OpYn.checked = true;
			document.forms[0].EmYn.checked = true;
			/**
			 * *************Added by Ram to update checkbox
			 * values***********************
			 */
			document.forms[0].IpYn.value = "Y";
			document.forms[0].DcYn.value = "Y";
			document.forms[0].OpYn.value = "Y";
			document.forms[0].EmYn.value = "Y";
			
			document.forms[0].orderAssociated.value = "N";
			document.forms[0].orderAssociated.checked = false;
			document.forms[0].orderAssociated.disabled = true;
			if(pkgAcrossEnctrYN== "Y"){
			document.forms[0].acrossEncounters.value = "N";
			document.forms[0].acrossEncounters.checked = false;
			document.forms[0].acrossEncounters.disabled = true;
			}
			/** *************End***************** */
		}else if (obj.name == "OpYn" && document.forms[0].IpYn.value != "Y" && document.forms[0].DcYn.value != "Y" && document.forms[0].EmYn.value != "Y") { //Added by Nandhini against NMC-JD-CRF-0150.1
			//alert("8588")
			document.forms[0].orderAssociated.disabled = false;
		}
		//31072
		else if(document.forms[0].OpYn.value != "Y" && document.forms[0].IpYn.value != "Y" && document.forms[0].DcYn.value != "Y" && document.forms[0].EmYn.value != "Y"){
			//alert("9615");
			document.forms[0].orderAssociated.disabled = false;
		}
		else{
			document.forms[0].orderAssociated.value = "N";
			document.forms[0].orderAssociated.checked = false;
			document.forms[0].orderAssociated.disabled = true;
			if(pkgAcrossEnctrYN== "Y"){
			document.forms[0].acrossEncounters.value = "N";
			document.forms[0].acrossEncounters.checked = false;
			document.forms[0].acrossEncounters.disabled = true;
			}
		} 
		
	} else {
		obj.checked = false;
		obj.value = "N";
		if (obj.name == "AllYn") {
			document.forms[0].IpYn.checked = false;
			document.forms[0].DcYn.checked = false;
			document.forms[0].OpYn.checked = false;
			document.forms[0].EmYn.checked = false;
			
			document.forms[0].IpYn.value = "N";
			document.forms[0].DcYn.value = "N";
			document.forms[0].OpYn.value = "N";
			document.forms[0].EmYn.value = "N";
			
			//31072
			document.forms[0].orderAssociated.disabled = false;
			
		}else if (obj.name == "OpYn" ) { //Added by Nandhini against NMC-JD-CRF-0150.1 //31191		
			if(document.forms[0].OpYn.value != "Y" && pkgAcrossEnctrYN== "Y" && (document.forms[0].IpYn.value == "Y" || document.forms[0].DcYn.value == "Y" || document.forms[0].EmYn.value == "Y" || document.forms[0].AllYn.value == "Y")){
				//alert("9663");
				document.forms[0].orderAssociated.disabled = true; //31072
				document.forms[0].orderAssociated.value = "N";
				document.forms[0].orderAssociated.checked = false;
				document.forms[0].acrossEncounters.disabled = true;
				document.forms[0].acrossEncounters.value = "N";
				document.forms[0].acrossEncounters.checked = false;
				//31072
				document.forms[0].IpYn.disabled = false;
				document.forms[0].DcYn.disabled = false;
				document.forms[0].EmYn.disabled = false;
				document.forms[0].AllYn.disabled = false;
			}
			else if(document.forms[0].OpYn.value != "Y" && (document.forms[0].IpYn.value == "Y" || document.forms[0].DcYn.value == "Y" || document.forms[0].EmYn.value == "Y" || document.forms[0].AllYn.value == "Y")){
				//alert("9692");
				document.forms[0].orderAssociated.disabled = true; 
				document.forms[0].orderAssociated.value = "N";
				document.forms[0].orderAssociated.checked = false;
				
				document.forms[0].IpYn.disabled = false;
				document.forms[0].DcYn.disabled = false;
				document.forms[0].EmYn.disabled = false;
				document.forms[0].AllYn.disabled = false;
				
			}
			else{ //31191
			//alert("9664");
				document.forms[0].orderAssociated.disabled = false; //31072
				document.forms[0].orderAssociated.value = "N";
				document.forms[0].orderAssociated.checked = false;
				if(pkgAcrossEnctrYN== "Y"){
				document.forms[0].acrossEncounters.disabled = true;
				document.forms[0].acrossEncounters.value = "N";
				document.forms[0].acrossEncounters.checked = false;
				}
				//31072
				document.forms[0].IpYn.disabled = false;
				document.forms[0].DcYn.disabled = false;
				document.forms[0].EmYn.disabled = false;
				document.forms[0].AllYn.disabled = false;
			}			
		}
		else {
			//alert("9661");
			document.forms[0].AllYn.checked = false;
			//31191
			document.forms[0].AllYn.value='N';
			if((mode == "insert" || mode == "modify") && (document.forms[0].OpYn.value == "Y" && document.forms[0].AllYn.value != "Y" &&  document.forms[0].IpYn.value != "Y" && document.forms[0].DcYn.value != "Y" &&  document.forms[0].EmYn.value != "Y" )){
			document.forms[0].orderAssociated.disabled = false; 
			}
			else if(document.forms[0].OpYn.value != "Y" && document.forms[0].AllYn.value != "Y" &&  document.forms[0].IpYn.value != "Y" && document.forms[0].DcYn.value != "Y" &&  document.forms[0].EmYn.value != "Y"){
				document.forms[0].orderAssociated.disabled = false; 
			}
			else{
				document.forms[0].orderAssociated.disabled = true; //31191
			}
		}

	}
	// Added for Auto Order Catalog check
	// if((document.forms[0].OpYn.checked) && !(document.forms[0].EmYn.checked
	// || document.forms[0].IpYn.checked || document.forms[0].DcYn.checked))
	// if(document.forms[0].OpYn.checked || document.forms[0].EmYn.checked ||
	// document.forms[0].IpYn.checked || document.forms[0].DcYn.checked)
	// {
	document.getElementById("autocheck").style.display = "inline";
	document.getElementById("autocheck1").style.display = "inline";
	// }
	// else
	// {
	// document.getElementById("autocheck").style.display = "none";
	// document.getElementById("autocheck1").style.display = "none";
	// document.forms[0].orderAssociated.value = "N";
	// document.forms[0].orderAssociated.checked = false;
	// //document.forms[0].validDays.value = ""; --------- Commented by lakshmi
	// 12/10/2011
	// }
}

function apply() {
	if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame != undefined) {
		var authorized = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.authorized.value;
		var mode = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.mode.value;
		var isUserCanAcess = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.isUserCanAcess.value;
		var pkgApprovedYN = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.pkgApprovedYN.value;
		if (((authorized == "N" && mode == "insert")
				|| (authorized == "Y" && mode == "modify") || (mode == "modify" && pkgApprovedYN == "N"))
				&& (isUserCanAcess == "Y")) {
			var last_tab = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.last_link.value;
			var last_link = ""
			var packageCode = ""
			var err_mess = "";
			if (last_tab == 'PACKAGE') {
				packageCode = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
				last_link = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.last_link.value;
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].IpYn.checked)
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
							.forms[0].IpYn.value = "Y";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].DcYn.checked)
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
							.forms[0].DcYn.value = "Y";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].OpYn.checked)
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
							.forms[0].OpYn.value = "Y";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].EmYn.checked)
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
							.forms[0].EmYn.value = "Y";
							
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].orderAssociated.checked){
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].orderAssociated.value = "Y"; 
						}//Added by Nandhini against NMC-JD-CRF-0150.1
				var frmObj = "";
				var current_form = "";
				var excln_form = "";
				var result = true;
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].packageCode.value == "") {
					err_mess = getMessage("BL8501", "BL") + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].shortDesc.value == "") {
					err_mess += getMessage("BL8502", "BL") + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].longDesc.value == "") {
					err_mess += getMessage("BL8503", "BL") + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].effFromDate.value == "") {
					err_mess += getMessage("BL8504", "BL") + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].applicalbleTo.value == "") {
					err_mess += getMessage("BL8586", "BL") + "<br>";
				}
				var mAY = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].minAgeInYrs.value;
				var mAM = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].minAgeInMths.value;
				var mDS = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].minAgeInDays.value;
				if (!((mAY != "" && mAY > 0) || (mAM != "" && mAM > 0) || (mDS != "" && mDS > 0))) {
					err_mess += getMessage("BL8505", "BL") + "<br>";
				}
				var epAll = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].AllYn;
				var epIp = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].IpYn;
				var epDC = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].DcYn;
				var epOP = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].OpYn;
				var epEm = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].EmYn;
				if (!((epAll.checked) || (epIp.checked) || (epDC.checked)
						|| (epOP.checked) || (epEm.checked))) {
					err_mess += "Please Select any one Episode Type" + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].applSexInd.value == "") {
					err_mess += getMessage("BL8506", "BL") + "<br>";
				}
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
						.forms[0].validDays.value == "") {
					err_mess += getMessage("BL8571", "BL") + "<br>";
				}
				if (err_mess != "") {
					parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
							+ err_mess;
				} else {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader;
					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {
						var xmlString = formXMLStringMain(frmObj);
						var updation = formValidation(xmlString, "PACKAGE");
					}
					frmObj = "";
					if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl != undefined) {
						frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate;
					}
					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {
						result = validatePackageDates(
								"parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate",
								eval("parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.document.forms[0].totRec").value);
						if (result) {
							var xmlString = formXMLString(frmObj,
									"PACKAGE_DATE", "apply", packageCode);
							var updation = formValidation(xmlString,
									"PACKAGE_DATE");
						}
					}
					frmObj = "";
					/* For base price */
					if (last_link == "PACKAGE_PRICE" && result) {
						if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl != undefined) {
							frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.frmPkgDefBasePrice;
						}
						if (frmObj != "" && frmObj != null
								&& frmObj != undefined && result) {
							result = validatePackagePrice(
									"parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.frmPkgDefBasePrice",
									eval("parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.frmPkgDefBasePrice.document.forms[0].totRec").value);
							if (result) {
								var xmlString = formXMLString(frmObj,
										"PACKAGE_PRICE", "apply", packageCode);
								var updation = formValidation(xmlString,
										"PACKAGE_PRICE");
							}
						}
					}
					if(last_link == "CHILD_PACK" && result){
						if (parent.frames[2].frames[1].frames[1].frames[3].frames[0]!= undefined) {
						frmObj = parent.frames[2].frames[1].frames[1].frames[3].frames[0].document.frmChildPackdtls;
						}
						if (frmObj != "" && frmObj != null
								&& frmObj != undefined && result) {
								if(parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
							.forms[0].mast_pack.value == 'Y'){
						result = validateChildPackage(
									frmObj,
									eval("parent.frames[2].frames[1].frames[1].frames[3].frames[0].document.frmChildPackdtls.totRec").value);
								
								}
								}
					}
					/* End */
					if (last_link == "CHARGE_BASED") {
						excln_link = "CHARGE_BASED_ITEM";
						current_form = "parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased";
						excln_form = "parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedExCln.document.frmPkgDefChargeBasedExcln";
					}
					if (last_link == "RATE_BASED" && result) {
						excln_link = "SRVLIMIT_RATE_BASED";
						current_form = "parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl";
						excln_form = "parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[4].document.srvLimit_rate_based_dtl";
						// rate based validation

						// commented and added new line
						// //result=validateRateForm(parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl,parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[2].document.forms[0],packageCode);
						result = validateRateForm(
								parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.rate_based_dtl.document.rate_based_dtl,
								parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame
										.frames[4].document.forms[0],
								packageCode);
					}
					if (last_link == "CHILD_PACK" && result) {
					//	current_form = "parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ass_child_pack_dtl.document.ass_child_pack_dtl";
					current_form="parent.frames[2].frames[1].frames[1].frames[3].ass_child_pack_dtl.document.frmChildPackdtls";
						excln_form = "";
						//return false;						
					}
					if (result) {
						frmObj = eval(excln_form)
						if (frmObj != null && frmObj != "undefined" && result) {
							var xmlString = formXMLString(frmObj, excln_link,
									"apply", packageCode);
							// var
							// updation=formValidation(xmlString,excln_link); //
							// Vijay for GHL-SCF-1086
							var updation = formValidation(xmlString,
									excln_link, null, "apply");
						}
						frmObj = eval(current_form);
						if (frmObj != null && frmObj != "undefined" && result) {
							var xmlString = formXMLString(frmObj, last_link,
									"apply", packageCode);
							var updation = formValidation(xmlString, last_link);
						}
						var basePriceValFlag = "";
						// Karthik added code here MMS-QF-SCF-0545
						// sarath jan/10/2017 added code to make as siteSpecific
						// MMS-QF-SCF-0545					
						
						if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.SiteSpecific.value == "Y") {
							if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.new_date_added.value == "Y") {
								/*
								 * if(parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.rate_based_dtl==undefined &&
								 * parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl==undefined){
								 * err_mess += 'Please Verify Package Services
								 * (Rate Based) and (Charge Based) Details
								 * before Apply'; }
								 */

							var rateBasedTabChecked = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value;
							var chargeBasedTabChecked = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value;
							var casePriceTabChecked = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value;

							var orderAssociateds = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.orderAssociated.value;	
							
							if(casePriceTabChecked=='N')
							{
								err_mess="Package Base Price is mandatory.";
							}
							
							if(rateBasedTabChecked=='N' && casePriceTabChecked=='N' && chargeBasedTabChecked=='N')
							{								
								err_mess="Package Base Price is mandatory.";
							}
							
							else if(rateBasedTabChecked=='N' && casePriceTabChecked=='Y' && chargeBasedTabChecked=='Y')
							{
								var totRecRteBsd="";								
								if(last_link=='CHARGE_BASED')
								{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased.listSizeRateBased.value;
									if(totRecRteBsd>0)
									{
										err_mess="Please Verify Package Services (Rate Based) Details before Apply.";
									}
								}
								else if(last_link=='PACKAGE_PRICE')
								{									
									totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.forms[0].totalRecordsRateBased.value;
									if(totRecRteBsd>0)
									{										
										err_mess="Please Verify Package Services (Rate Based) Details before Apply.";
									}									
								}								
							}
							else if(rateBasedTabChecked=='N' && casePriceTabChecked=='Y' && chargeBasedTabChecked=='N')
							{							
								var totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.forms[0].totalRecordsRateBased.value;
								var totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.forms[0].totalRecordsChargeBased.value;
								
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Package Services (Rate Based) Details before Apply";
								}
								
								else if(totRecChgBsd>0)
								{									
									if(orderAssociateds != 'Y' )
									{		
										err_mess="Please Verify (Charge Based) Details before Apply";
									}
								}							
							}
							else if(rateBasedTabChecked=='Y' && casePriceTabChecked=='Y' && chargeBasedTabChecked=='N')
							{								
								var totRecChgBsd="";								
								if(last_link=='PACKAGE_PRICE')
								{	
									
									totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.forms[0].totalRecordsChargeBased.value;
									
									if(orderAssociateds != 'Y'  && totRecChgBsd>0)
									{								
										err_mess="Please Verify (Charge Based) Details before Apply";
									}
								}
								else if(last_link=='RATE_BASED')
								{
									totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.rate_based_dtl.document.forms[0].totRecChargeBased.value;
									
									if(orderAssociateds != 'Y'  && totRecChgBsd>0)
									{								
										err_mess="Please Verify (Charge Based) Details before Apply";
									}
								}
							}
							
							else if(rateBasedTabChecked=='N' && casePriceTabChecked=='Y' && chargeBasedTabChecked=='Y')
							{								
								var totRecRteBsd="";
								if(last_link=='PACKAGE_PRICE')
								{
									totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.basePriceDtl.document.forms[0].totalRecordsRateBased.value;
								
									if(totRecRteBsd>0)
									{
										err_mess="Please Verify Package Services (Rate Based) Details before Apply";
									}							
								}
								else if(last_link=='CHARGE_BASED')
								{
									totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased.listSizeRateBased.value;
									
									if(totRecRteBsd>0)
									{
										err_mess="Please Verify Package Services (Rate Based) Details before Apply";
									}									
								}							
							}							
						}	
						}
						if(parent.frames[2].frames[1].frames[1].frames[0].document.frmPkgDefHeader.allow_masterChild_package_map.value == "Y"){
						if(parent.frames[2].frames[1].frames[1].frames[0].document.frmPkgDefHeader.mast_pack.checked){							
							var caseChildPackTabChecked = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.child_package_tab_checked.value;
						
									if(caseChildPackTabChecked=='N'){				
										alert("Please verify Associate Child Package Tab");
										result=false;								
									}							
						}						
						}
						//23-10-2020 changed for MMS-KH-SCF-0051.1 -PALANINARAYANAN
						setTimeout(function(){  		
						if (err_mess == "" && result) {
							parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
									.forms[0].target = 'messageFrame';
							parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
									.forms[0].method = 'post';
							parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
									.forms[0].action = "../../servlet/eBL.PkgDefServlet";
							parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
									.forms[0].submit();
						} else {
							parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
									+ err_mess;
						}
					}, 3000);//23-10-2020 changed for MMS-KH-SCF-0051.1 -PALANINARAYANAN
					} else {
						parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
					}
				}
			} else if (last_tab == 'CUSTOMER') {
				last_link = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value;
				packageCode = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
				var result = true;
				var updation = true;
				var frmObj = "";
				var current_form;
				var excln_form;
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDtlsFrame.cust_dtls != undefined
						&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDtlsFrame.cust_dtls != null) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDtlsFrame.cust_dtls.document.cust_dtls
					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {
						result = validateCustomers(frmObj);
						if (result) {
							updation = formValidation(
									formCustXMLStringMain(frmObj), "CUSTOMER");
						}
					}
				}
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl != null
						&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl != undefined
						&& result) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl
					if (frmObj != null && frmObj != "undefined") {
						result = validateCustPackageDates(frmObj,
								parseInt(frmObj.totalRecords.value));
						if (result)
							updation = formValidation(
									formCustXMLStringMain(frmObj), "custPeriod");
					}
				}
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl != undefined
						&& result) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.cust_base_price_dtl;
					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {
						// sarath added MMS-QF-SCF-0545 added apply..
						result = validateCustPackagePrice(
								"parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.cust_base_price_dtl",
								parseInt(frmObj.totalRecords.value), "apply");

						if (result) {
							updation = formValidation(
									formCustXMLStringMain(frmObj), "CUST_PRICE");
						}
					}
				}
				/* End */
				if (last_link == "CUST_CHARGE_BASED" && result) {
					excln_link = "CUST_CHARGE_BASED_ITEM";
					current_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_charge_based_dtl.document.cust_charge_based_dtl
					result = validateCustChargeBased(current_form,
							current_form.totalRecords.value)
					if (result) {
						excln_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_charge_based_excl.document.cust_charge_based_excl_dtl
						if (excln_form != undefined && excln_form != "")
							result = validateCustChargeBasedItems(excln_form,
									excln_form.totalRecords.value)
					}
				}
				if (last_link == "CUST_RATE_BASED" && result) {
					excln_link = "CUST_SRVLIMIT_RATE_BASED";
					// frame ref changed PkgDefCustDetailFrame.frames[0] to
					// PkgDefCustDetailFrame.frames[1] by ram
					current_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame
							.frames[1].document.cust_rate_based_dtl
					// frame ref changed PkgDefCustDetailFrame.frames[2] to
					// PkgDefCustDetailFrame.frames[3] by ram
					excln_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame
							.frames[4].document.cust_srvLimit_rate_based_dtl
					result = validateCustRateForm(current_form, excln_form,
							packageCode);
				}
				frmObj = "";
				if (result) {
					frmObj = excln_form
					if (frmObj != null && frmObj != "undefined") {
						updation = formValidation(
								formCustXMLStringMain(frmObj), excln_link);
					}
					frmObj = current_form;
					if (frmObj != null && frmObj != "undefined") {
						updation = formValidation(
								formCustXMLStringMain(frmObj), last_link);
					}

					// sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
					// sarath jan/10/2017 added code to make as siteSpecific
					// MMS-QF-SCF-0545
					if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl.SiteSpecific.value == "Y") {

					if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl.CUST_NEW_DATE_CHK.value == "Y") {
						var CUST_PRICE_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustTabFrame.document.cust_tab.CUST_PRICE_CHK.value;
						var CUST_RATE_BASED_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustTabFrame.document.cust_tab.CUST_RATE_BASED_CHK.value;
						var CUST_CHARGE_BASED_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustTabFrame.document.cust_tab.CUST_CHARGE_BASED_CHK.value;
						var orderAssociated = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document.frmPkgDefCustHeader.orderAssociated.value;

						if(CUST_PRICE_CHK=='N')
						{
							err_mess="Customer Base Price is mandatory. ";
						}						
						
						if(CUST_PRICE_CHK=='N' && CUST_RATE_BASED_CHK=='N' && CUST_CHARGE_BASED_CHK=='N')
						{
							err_mess='Customer Base Price is mandatory.';			
						}						
						
						else if(CUST_RATE_BASED_CHK=='N' && CUST_PRICE_CHK=='Y' && CUST_CHARGE_BASED_CHK=='Y')
						{							
							var totRecRteBsd="";							
							if(last_link=='CUST_CHARGE_BASED')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_charge_based_dtl.document.forms[0].custRateBasedRcdSize.value;
							
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Customer Services (Rate Based) Details before Apply.";
								}
							}
							else if(last_link=='CUST_PRICE')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.forms[0].custRateBasedRcdSize.value;
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Customer Services (Rate Based) Details before Apply.";
								}								
							}
						}
						else if(CUST_RATE_BASED_CHK=='N' && CUST_PRICE_CHK=='Y' && CUST_CHARGE_BASED_CHK=='N')
						{
							var totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.forms[0].custRateBasedRcdSize.value;
							var totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.forms[0].custChgBasedRcdSize.value;
							
							if(totRecRteBsd>0)
							{
								err_mess="Please Verify Customer Services (Rate Based) Details before Apply";
							}
							
							else if(totRecChgBsd>0)
							{								
								if(orderAssociated != 'Y' )
								{		
									err_mess="Please Verify Customer Services (Charge Based) Details before Apply";
								}
							}						
						}
						else if(CUST_RATE_BASED_CHK=='Y' && CUST_PRICE_CHK=='Y' && CUST_CHARGE_BASED_CHK=='N')
						{							
							var totRecChgBsd="";							
							if(last_link=='CUST_PRICE')
							{								
								totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.forms[0].custRateBasedRcdSize.value;
								
								if(orderAssociated != 'Y'  && totRecChgBsd>0)
								{							
									err_mess="Please Verify Customer Services (Charge Based) Details before Apply";
								}
							}
							else if(last_link=='CUST_RATE_BASED')
							{							
								totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_rate_based_dtl.document.forms[0].custChgBasedRcdSize.value;						
								if(orderAssociated != 'Y'  && totRecChgBsd>0)
								{							
									err_mess="Please Verify Customer Services (Charge Based) Details before Apply";
								}
							}
						}
						
						else if(CUST_RATE_BASED_CHK=='N' && CUST_PRICE_CHK=='Y' && CUST_CHARGE_BASED_CHK=='Y')
						{
							var totRecRteBsd="";
							if(last_link=='CUST_PRICE')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document.forms[0].custRateBasedRcdSize.value;
							if(totRecRteBsd>0)
								{
									err_mess="Please Verify Customer Services (Rate Based) Details before Apply";
								}						
							}
							else if(last_link=='CHARGE_BASED')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_charge_based_dtl.document.forms[0].custRateBasedRcdSize.value;
								if(totRecRteBsd>0)
								{
								err_mess="Please Verify Customer Services (Rate Based) Details before Apply";
								}								
							}						
						}						
					}
					}// sarath added MMS-QF-SCF-0545 CustomerLevel Ending..
					if (err_mess == "" && result) {
						parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document
								.forms[0].target = 'messageFrame';
						parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document
								.forms[0].method = 'post';
						parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document
								.forms[0].action = "../../servlet/eBL.PkgDefServlet";
						parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document
								.forms[0].submit();
					} else {
						// sarath added MMS-QF-SCF-0545 Added to display
						parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
								+ err_mess;
					}
				} else {
					parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
				}
			} else if (last_tab == 'DISCOUNT') {
				packageCode = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document.discount_hdr.packageCode.value;
				var result = true;
				var updation = true;
				var frmObj = "";
				var current_form;
				var excln_form;
				frmObj = "";

				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDiscountFrame.cust_discount_dtl != undefined
						&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDiscountFrame.cust_discount_dtl != null) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDiscountFrame.cust_discount_dtl.document.cust_discount_dtl
					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {
						result = validateDiscountForm(frmObj);

						if (result) {
							updation = formValidation(
									formDiscountXMLStringMain(frmObj),
									"cust_discount");
						}
					}
				}
				frmObj = "";
				if (result) {
					if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDiscountFrame.blng_grp_discount_dtl != null
							&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDiscountFrame.blng_grp_discount_dtl != undefined) {
						frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDiscountFrame.blng_grp_discount_dtl.document.blng_grp_discount_dtl
						if (frmObj != null && frmObj != "undefined") {
							result = validateDiscountForm(frmObj);

							if (result)
								updation = formValidation(
										formDiscountXMLStringMain(frmObj),
										"blng_grp_discount");
						}
					}
				}
				frmObj = "";

				if (result) {
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document
							.forms[0].target = 'messageFrame';
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document
							.forms[0].method = 'post';
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document
							.forms[0].action = "../../servlet/eBL.PkgDefServlet";
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document
							.forms[0].submit();
				} else {
					parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='
				}
			}
			//Added By Shikha For GHL-CRF-0520.1
      else if (last_tab == 'BILLINGGROUP') {
				
				last_link = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value;
				packageCode = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;
				var result = true;
				var updation = true;
				var frmObj = "";
				var current_form;
				var excln_form;
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDtlsFrame.blng_grp_dtls != undefined
						&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDtlsFrame.blng_grp_dtls != null) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDtlsFrame.blng_grp_dtls.document.blng_grp_dtls;

					if (frmObj != "" && frmObj != null && frmObj != undefined
							&& result) {						
						result = validateBillingGroups(frmObj);
						if (result) {
							updation = formValidation(formBlngGrpXMLStringMain(frmObj), "BILLINGGROUP");
						}
					}
				}
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl != null
						&& parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl != undefined
						&& result) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
					if (frmObj != null && frmObj != "undefined") {
						result = validateBlngGrpPackageDates(frmObj,parseInt(frmObj.totalRecords.value));
						if (result)
							updation = formValidation(formBlngGrpXMLStringMain(frmObj), "blngGrpPeriod");
					}
				}
				frmObj = "";
				if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl != undefined
						&& result) {
					frmObj = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.blng_grp_base_price_dtl;
					if (frmObj != "" && frmObj != null && frmObj != undefined && result) {
						result = validateBlngGrpPackagePrice(
								"parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.blng_grp_base_price_dtl",
								parseInt(frmObj.totalRecords.value), "apply");
						if (result) {
							updation = formValidation(
									formBlngGrpXMLStringMain(frmObj), "BLNG_GRP_PRICE");
						}
					}
				}

				if (last_link == "BLNG_GRP_CHARGE_BASED" && result) {
					excln_link = "BLNG_GRP_CHARGE_BASED_ITEM";
					current_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_charge_based_dtl.document.blng_grp_charge_based_dtl;
					result = validateBlngGrpChargeBased(current_form,current_form.totalRecords.value);
					if (result) {
						excln_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_charge_based_excl.document.blng_grp_charge_based_excl_dtl;
						if (excln_form != undefined && excln_form != "")
							result = validateBlngGrpChargeBasedItems(excln_form,excln_form.totalRecords.value);
					}
				}
				if (last_link == "BLNG_GRP_RATE_BASED" && result) {
					excln_link = "BLNG_GRP_SRVLIMIT_RATE_BASED";
					current_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[1].document.blng_grp_rate_based_dtl;
					excln_form = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.frames[4].document.blng_grp_srvLimit_rate_based_dtl;
					result = validateBlngGrpRateForm(current_form, excln_form,packageCode);
				}
				frmObj = "";
				if (result) {
					frmObj = excln_form
					if (frmObj != null && frmObj != "undefined") {
						updation = formValidation(
								formBlngGrpXMLStringMain(frmObj), excln_link);
					}
					frmObj = current_form;
					if (frmObj != null && frmObj != "undefined") {
						updation = formValidation(
								formBlngGrpXMLStringMain(frmObj), last_link);
					}
					if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl.SiteSpecific.value == "Y") {
						if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl.BLNG_GRP_NEW_DATE_CHK.value == "Y") {
							var BLNG_GRP_PRICE_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpTabFrame.document.blng_grp_tab.BLNG_GRP_PRICE_CHK.value;
							var BLNG_GRP_RATE_BASED_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpTabFrame.document.blng_grp_tab.BLNG_GRP_RATE_BASED_CHK.value;
							var BLNG_GRP_CHARGE_BASED_CHK = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpTabFrame.document.blng_grp_tab.BLNG_GRP_CHARGE_BASED_CHK.value;
							var orderAssociated = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.orderAssociated.value;

						if(BLNG_GRP_PRICE_CHK=='N')
						{
							err_mess="Billing Group Base Price is mandatory. ";
						}						
						if(BLNG_GRP_PRICE_CHK=='N' && BLNG_GRP_RATE_BASED_CHK=='N' && BLNG_GRP_CHARGE_BASED_CHK=='N')
						{
							err_mess='Billing Group Base Price is mandatory.';
						}						
						else if(BLNG_GRP_RATE_BASED_CHK=='N' && BLNG_GRP_PRICE_CHK=='Y' && BLNG_GRP_CHARGE_BASED_CHK=='Y')
						{	
							var totRecRteBsd="";							
							if(last_link=='BLNG_GRP_CHARGE_BASED')
							{
							totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_charge_based_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;
							
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Rate Based) Details before Apply.";
								}
							}
							else if(last_link=='BLNG_GRP_PRICE')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Rate Based) Details before Apply.";
								}
							}
						}
						else if(BLNG_GRP_RATE_BASED_CHK=='N' && BLNG_GRP_PRICE_CHK=='Y' && BLNG_GRP_CHARGE_BASED_CHK=='N')
						{
							var totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;
							var totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.forms[0].blngGrpChgBasedRcdSize.value;
							
							if(totRecRteBsd>0)
							{
								err_mess="Please Verify Billing Group Services (Rate Based) Details before Apply";
							}
							
							else if(totRecChgBsd>0)
							{
								
								if(orderAssociated != 'Y' )
								{		
									err_mess="Please Verify Billing Group Services (Charge Based) Details before Apply";
								}
							}
						
						}
						else if(BLNG_GRP_RATE_BASED_CHK=='Y' && BLNG_GRP_PRICE_CHK=='Y' && BLNG_GRP_CHARGE_BASED_CHK=='N')
						{
							var totRecChgBsd="";
							if(last_link=='BLNG_GRP_PRICE')
							{
								totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;								
								if(orderAssociated != 'Y'  && totRecChgBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Charge Based) Details before Apply";
								}
							}
							else if(last_link=='BLNG_GRP_RATE_BASED')
							{							
								totRecChgBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_rate_based_dtl.document.forms[0].blngGrpChgBasedRcdSize.value;						
								if(orderAssociated != 'Y'  && totRecChgBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Charge Based) Details before Apply";
								}
							}
						}
						else if(BLNG_GRP_RATE_BASED_CHK=='N' && BLNG_GRP_PRICE_CHK=='Y' && BLNG_GRP_CHARGE_BASED_CHK=='Y')
						{
							var totRecRteBsd="";
							if(last_link=='BLNG_GRP_PRICE')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Rate Based) Details before Apply";
								}						
							}
							else if(last_link=='CHARGE_BASED')
							{
								totRecRteBsd=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_charge_based_dtl.document.forms[0].blngGrpRateBasedRcdSize.value;
								if(totRecRteBsd>0)
								{
									err_mess="Please Verify Billing Group Services (Rate Based) Details before Apply";
								}
							}				
						}
					}
				}
				if (err_mess == "" && result) {				
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.forms[0].target = 'messageFrame';
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.forms[0].method = 'post';
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.forms[0].action = "../../servlet/eBL.PkgDefServlet";
					parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.forms[0].submit();
				} else {
						parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='+ err_mess;
				}
			} else {
					parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num=';
			}		
      }//Ended By Shikha For GHL-CRF-0520.1
			} else
			parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num=';
	} else
		parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num=';
}

function onSuccess() {
	last_tab = parent.frames[2].PkgDefFrame.PkgDefMainTab.document.frmPkgDefTab.last_link.value;
	if (last_tab == 'PACKAGE') {
		if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document
				.forms[0].mode.value == "insert") {
			// PkgDefFrame.location.href="../../eBL/jsp/PkgDefFrame.jsp?mode=insert";
			PkgDefFrame.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1";
		} else {
			PkgDefFrame.document.location.reload();
		}
	} else if (last_tab == 'CUSTOMER') {
		if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustHeader.document
				.forms[0].mode.value == "insert") {
			// PkgDefFrame.location.href="../../eBL/jsp/PkgDefFrame.jsp?mode=insert";
			PkgDefFrame.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1";
		} else {
			PkgDefFrame.document.location.reload();
		}
	} else if (last_tab == 'DISCOUNT') {
		if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDiscountHeader.document
				.forms[0].mode.value == "insert") {
			// PkgDefFrame.location.href="../../eBL/jsp/PkgDefFrame.jsp?mode=insert";
			PkgDefFrame.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1";
		} else {
			PkgDefFrame.document.location.reload();
		}
	}
	//Added By Shikha For GHL-CRF-0520.1
	else if (last_tab == 'BILLINGGROUP') {
		if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpHeader.document.forms[0].mode.value == "insert") {
			PkgDefFrame.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=insert&from=PACKAGE&level=1";
		} else {
			PkgDefFrame.document.location.reload();
		}
	}//Ended By Shikha For GHL-CRF-0520.1
}

// valid number check
function allowValidNumber1(obj, event, mode) {
	var noofdecimal = "";
	// if(mode=='2')
	noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value;
	// else
	// noofdecimal =
	// parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value;
	if (allowValidNumber(obj, event, 10, noofdecimal))
		return true;
	else
		return false;
		// ChkNumberInput(obj,event,parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value));
}

// to Default from date if it is null
/*
 * function defaultFromDate() { if(document.forms[0].fromDate_0.value == null ||
 * document.forms[0].fromDate_0.value == "") {
 * document.forms[0].fromDate_0.value=parent.parent.PkgDefHeader.document.frmPkgDefHeader.effFromDate.value;
 * document.forms[0].fromDatePrev_0.value=parent.parent.PkgDefHeader.document.frmPkgDefHeader.effFromDate.value; }
 *  }
 */

// Common lookup for for Charge based
function callServices(code, desc, functionId, charge_type, index, sql)
// function callServices(code,desc,functionId,index,sql)
{
	var prevCode = eval("document.forms[0].cbCodePrev_" + index)
	var prevDesc = eval("document.forms[0].cbDescPrev_" + index)
	if (code.value == "" || desc.value == "") {
		var locale = document.forms[0].locale.value;
		var sql = "";
		var value = code.value;
		/*
		 * var argArray = new Array(); var namesArray = new Array(); var
		 * valuesArray = new Array(); var datatypesArray = new Array();
		 */
		if (desc.value != "")
			value = desc.value;
		if (charge_type.value == "M") {
			sql = "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"
					+ locale
					+ "' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			title = getLabel("Common.item.label", "common");
		} else if (charge_type.value == "S") {
			sql = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
					+ locale
				 +"' and status is null AND RATE_ENTRY_BY_USER_FLAG = 'C' AND UPPER (blng_serv_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY 2  ";
			title = getLabel("Common.BillingService.label", "common");
		}
		/*
		 * else if(functionId=="CHARGE_BASED") { sql="select blng_serv_code
		 * code, short_desc description from bl_blng_serv_lang_vw where
		 * rate_entry_by_user_flag='C' and language_id= '"+locale+"' and status
		 * is null and upper(blng_serv_code) like upper(?) and upper(short_desc)
		 * like upper(?)"; }
		 */
		else if (functionId == "CHARGE_BASED_ITEM") {
			sql = "SELECT a.item_code code, c.long_desc description FROM bl_st_item a,  mm_item_lang_vw c WHERE a.sale_category_code in (select  sale_category_code  from  bl_st_item_sale_catg_dtl where blng_serv_code = '"
					+ document.forms[0].serviceCode.value
					+ "') and a.item_code = c.item_code AND c.language_id = '"
					+ locale
					+ "' and upper(a.item_code) like upper(?) and upper(long_desc) like upper(?)";
			title = getLabel("Common.service.label", "common");
		}
		// sql="SELECT a.item_code code, c.long_desc description FROM bl_st_item
		// a, bl_st_item_sale_catg_dtl b, mm_item_lang_vw c WHERE
		// a.sale_category_code = b.sale_category_code AND a.item_code =
		// c.item_code AND c.language_id = '"+locale+"' AND b.blng_serv_code =
		// '"+document.forms[0].serviceCode.value+"' and upper(a.item_code) like
		// upper(?) and upper(long_desc) like upper(?)";
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;
		retArray = CommonLookup(title, argArray);
		if (retArray != undefined && retArray != null) {
			if (retArray[0] != undefined && retArray[1] != undefined) {
				code.value = retArray[0];
				desc.value = retArray[1];
				prevCode.value = retArray[0];
				prevDesc.value = retArray[1];
				// Below code is added by MuthuN for service limit restriction -
				// item alone
				// eval("formObj.srvLmt_"+index).disabled=true;
				
				if(functionId=='CHARGE_BASED'){
				if (charge_type.value == "S") {
					eval("document.forms[0].srvLmt_" + index).disabled = false;
				} else {
					eval("document.forms[0].srvLmt_" + index).disabled = true;
				}
			}
				// newly added
			} else {
				code.value = "";
				desc.value = "";
				prevCode.value = "";
				prevDesc.value = "";
			}
		} else {
			clearRow(document.forms[0], index);
		}
		if (code.value != "")
			checkForDuplicate(functionId, code.value, index);
	}
}
// Unlimited check for Charge based
function checkUnlimited(obj, index) {
	if (obj.checked) {
		eval("document.forms[0].amountLimit_" + index).readOnly = true;
		eval("document.forms[0].amountLimitPer_" + index).readOnly = true;
		eval("document.forms[0].amountLimit_" + index).value = "";
		eval("document.forms[0].amountLimitPer_" + index).value = "";
		obj.value = "Y";
	} else {
		eval("document.forms[0].amountLimit_" + index).readOnly = false;
		eval("document.forms[0].amountLimitPer_" + index).readOnly = false;
		obj.value = "N";
	}
}

// Exclusion inclusion for Charge based
function excludeItem(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
		eval("document.forms[0].amountLimit_" + index).disabled = true;
		eval("document.forms[0].quantityLimit_" + index).disabled = true;
		eval("document.forms[0].amountLimit_" + index).value = "";
		eval("document.forms[0].quantityLimit_" + index).value = "";
	} else {
		obj.value = "N";
		eval("document.forms[0].amountLimit_" + index).disabled = false;
		eval("document.forms[0].quantityLimit_" + index).disabled = false;
	}
	/*
	 * if(obj.value == "E") {
	 * eval("document.forms[0].amountLimit_"+index).readOnly=true;
	 * eval("document.forms[0].quantityLimit_"+index).readOnly=true;
	 * eval("document.forms[0].amountLimit_"+index).value="";
	 * eval("document.forms[0].quantityLimit_"+index).value="";
	 *  } else { eval("document.forms[0].amountLimit_"+index).readOnly=false;
	 * eval("document.forms[0].quantityLimit_"+index).readOnly=false; }
	 */
}

/*
 * function formXMLStringForBLClassDates(blClsCode,index,from) { var xmlStr ="<root><SEARCH ";
 * formObj="document.forms[0]"; //alert("blClsCode"+blClsCode) total_records =
 * parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
 * //alert("total_records:"+total_records) var chkNoRec = 0; var sIndex = "";
 * for(var i=0; i<total_records; i++) { if(eval(formObj+".blgClsCode_"+i).value ==
 * blClsCode) {
 * 
 * 
 * xmlStr+= "fromDate_"+chkNoRec+"=\"" + eval(formObj+".fromDate_"+i).value +
 * "\" " ; xmlStr+= "toDate_"+chkNoRec+"=\"" + eval(formObj+".toDate_"+i).value +
 * "\" " ; xmlStr+= "rIndex_"+chkNoRec+"=\"" + i+ "\" " ; if(i== index) sIndex =
 * chkNoRec; chkNoRec = chkNoRec+1; }
 *  } if(chkNoRec >1) { xmlStr+= "index=\"" + index + "\" " ; xmlStr+=
 * "total_records=\"" + chkNoRec + "\" " ; xmlStr+= "from=\"" + from + "\" " ;
 * xmlStr+= "sIndex=\"" + sIndex + "\" " ; xmlStr +=" /></root>";
 * //alert("xmlStr:"+xmlStr); var
 * updation=formValidation(xmlStr,"VALIDATE_OVERLAP");
 *  } //alert("xmlStr:"+xmlStr);
 *  }
 */

function overLap(index, from) {
	alert(getMessage("BL8514", 'BL'));
	if (from == "toDate") {
		eval("document.forms[0].toDate_" + index).value = "";
		eval("document.forms[0].toDate_" + index).focus();
	} else {
		eval("document.forms[0].fromDate_" + index).value = "";
		eval("document.forms[0].fromDate_" + index).focus();
	}
}

function validatePackagePrice(formObj, totalRec) {
	var flag = true;
	if ((eval(formObj + ".blgClsCode_0") != undefined && eval(formObj
			+ ".blgClsCode_0").value == '')) {// Karthik added code here
												// MMS-QF-SCF-0545
		alert("Atleast One Entry for Package Base Price Must be Provided");
		if(parent.PkgDefBaseDateMain != null && parent.PkgDefBaseDateMain != undefined ){//&& parent.PkgDefBaseDateMain !="null" || parent.PkgDefBaseDateMain !="undefined" || parent.PkgDefBaseDateMain !='undefined'){
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.rate_based_tab_checked.value = "N";
		parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.charge_based_tab_checked.value = "N";
		}
		return false;
	}
	for ( var i = 0; i < totalRec; i++) { 
		if ((eval(formObj + ".blgClsCode_" + i) != undefined && eval(formObj
				+ ".blgClsCode_" + i).value != "")
				|| (eval(formObj + ".price_" + i) != undefined && eval(formObj
						+ ".price_" + i).value != "")) {
			if (eval(formObj + ".blgClsCode_" + i) != undefined
					&& eval(formObj + ".blgClsCode_" + i).value != "") {
				if (eval(formObj + ".price_" + i) != undefined
						&& eval(formObj + ".price_" + i).value != "")
					flag = true;
				else {
					alert(getMessage("BL8527", 'BL'));
					eval(formObj + ".price_" + i).focus();
					return false;
				}

				if (eval(formObj + ".partialDeposit_" + i) != undefined) {// 48333
																			// alert
																			// when
																			// Partial
																			// Deposit
																			// is
																			// checked
																			// and
																			// minimum
																			// amount
																			// not
																			// entered
					if (eval(formObj + ".partialDeposit_" + i).value == 'Y'
							&& eval(formObj + ".minDepAmt_" + i).value == '') {
						alert(getMessage("BL8624", 'BL'));
						eval(formObj + ".minDepAmt_" + i).focus();
						return false;
					}
				}

				var message = "";
				if (eval(formObj + ".roundTo_" + i).value == null
						|| eval(formObj + ".roundTo_" + i).value == ""
						|| eval(formObj + ".roundTo_" + i).value == "10"
						|| eval(formObj + ".roundTo_" + i).value == "50"
						|| eval(formObj + ".roundTo_" + i).value == "100"
						|| eval(formObj + ".roundTo_" + i).value == "500"
						|| eval(formObj + ".roundTo_" + i).value == "1000") {
					message = "";
				} else {
					message = getMessage("BL8681", 'BL');
					obj = eval(formObj + ".roundTo_" + i);
					alert(message);
					obj.focus();
					return false
				}
			} else {
				alert(getMessage("BL9300", 'BL'));
				eval(formObj + ".blgClsCode_" + i).focus();
				return false;
			}
		}
	}
	return flag;
}

function callBlgCls(blDesc, blCode, index, from) {
	if (from == "code" && blCode.value == "")
		clearRow(document.frmPkgDefBasePrice, index);
	else if (from == "desc" && blDesc.value == "")
		clearRow(document.frmPkgDefBasePrice, index);

	else if (blCode.value == "" || blDesc.value == "") {
		var value = blCode.value;
		if (blDesc.value != null && blDesc.value != "")
			value = blDesc.value;
		var sql = "";
		var link = "DESC_LINK"
		var odr = "DESC_CODE"
		var episodeAssociated = "";
		var str = "";
		if (parent.parent.PkgDefHeader.document.frmPkgDefHeader.IpYn.checked) {
			str = " and ( B.PATIENT_CATEGORY_CODE = 'I'";
		}
		if (parent.parent.PkgDefHeader.document.frmPkgDefHeader.DcYn.checked) {
			if (str == "")
				str = "and ( B.PATIENT_CATEGORY_CODE = 'D'"
			else
				str = str + " or B.PATIENT_CATEGORY_CODE = 'D' ";
		}
		if (parent.parent.PkgDefHeader.document.frmPkgDefHeader.OpYn.checked) {
			if (str == "")
				str = "and ( B.PATIENT_CATEGORY_CODE = 'O' "
			else
				str = str + " or B.PATIENT_CATEGORY_CODE = 'O' ";
		}
		if (parent.parent.PkgDefHeader.document.frmPkgDefHeader.EmYn.checked) {
			if (str == "")
				str = "and ( B.PATIENT_CATEGORY_CODE = 'E' ";
			else
				str = str + " or B.PATIENT_CATEGORY_CODE = 'E' "
		}
		if (str != "")
			str = str + ") ";
		var ordAsociated = parent.parent.PkgDefHeader.document.frmPkgDefHeader.orderAssociated.value;

		sql = "select code, description from  (select '**' code, 'All Billing Classes' description from dual union all  select A.BLNG_CLASS_CODE code, A.short_DESC description from BL_BLNG_CLASS_LANG_VW A, BL_BLNG_CLASS B where a.BLNG_CLASS_CODE = B.BLNG_CLASS_CODE "
				+ str
				+ " and A.LANGUAGE_ID = '"
				+ document.forms[0].locale.value
				+ "' and nvl(B.STATUS,'X') != 'S' ) where  upper(code) like upper(?) and upper(description) like upper(?)";

		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		var title = getLabel("Common.BillingClass.label", "common");
		var local = document.forms[0].locale.value;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		retVal = CommonLookup(title, argumentArray);
		if (retVal != null && retVal != "") {
			blDesc.value = retVal[1];
			blCode.value = retVal[0];
			checkForDuplicate("PACKAGE_PRICE", retVal[0], index);
			if (blCode.value == "**")
				eval("document.forms[0].indicator_" + index).selectedIndex = 0;
		} else {
			blDesc.value = "";
			blCode.value = "";
		}
	}
}

/* Indicator validation */
function indiValidation(obj, index) {
	var flag = false;
	eval("document.forms[0].price_" + index).value = "";
	eval("document.forms[0].roundTo_" + index).value = "";
	eval("document.forms[0].roundInd_" + index).selectedIndex = 0;
	eval("document.forms[0].minDepAmt_" + index).value = "";
	var total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
	if (eval("document.forms[0].blgClsCode_" + index).value == "**")
		flag = false;
	else {
		if (obj.value == "F") {
			if (index == 0 && total_records == 1) {
				// alert("Cannot given the factore bze price for all class id
				// not defined")
				alert(getMessage("BL8583", 'BL'));
				flag = false;
			} else {
				for ( var i = 0; i < total_records; i++) {
					if (eval("document.forms[0].blgClsCode_" + i).value == "**"
							&& i != index) {
						flag = true;
						break;
					}
				}
			}
		} else
			flag = false;
	}
	if (flag == true)
		eval("document.forms[0].factorAppl_" + index).disabled = false;
	else {
		eval("document.forms[0].indicator_" + index).selectedIndex = 0;
		if (eval("document.forms[0].factorAppl_" + index) != undefined)
			eval("document.forms[0].factorAppl_" + index).disabled = true;
	}
	if (obj.value == "F") {
		eval("document.forms[0].roundTo_" + index).disabled = false;
		eval("document.forms[0].roundInd_" + index).disabled = false;
	} else {
		eval("document.forms[0].roundTo_" + index).disabled = true;
		eval("document.forms[0].roundInd_" + index).disabled = true;
	}
}

function validForAmtPerUnltd(obj1, obj2, index, serv, noofdecimal) {
	// var noOfDecimel =
	// parent.PkgDefHeader.document.forms[0].noofdecimal.value;
	if (obj2.value != "") {
		if (obj1.value == "A") {
			// putdeci(obj2,"2");
			checkForNegetiveNumber(obj2, noofdecimal, "BL8540")
			if (serv != "CHARGE_BASED" && serv != "PACKAGE_PRICE")
				chkAmt(obj2, index);
			else if (serv == "PACKAGE_PRICE")
				validateWithPkgPrice(obj2, index);
		} else if (obj1.value == "P" || obj1.value == "R") {
			validPercentage(obj2);
			if (serv != "CHARGE_BASED" && serv != "PACKAGE_PRICE")
				chkAmtPercent(obj2, index);
		} else if (obj1.value == "U") {
			obj2.value = "";
			obj2.disabled = true;
			if (serv != "CHARGE_BASED")
				chkUnlimited(obj2, index)
		}
	} else {
	}
}

function validateInd(obj, index, amt_lmt, factorAppl, qty_lmt) {
    var frmObj = eval("document.forms[0]." + amt_lmt + index);
    var frmObjFAppl = eval("document.forms[0]." + factorAppl + index);
    var frmObjQtyLmt = "";
	
	if (qty_lmt != null && qty_lmt != undefined && qty_lmt != "")
		frmObjQtyLmt = eval("document.forms[0]." + qty_lmt + index);
	else
		frmObjQtyLmt = "";

	frmObj.value = "";
	if (obj.value == "U" || obj.value == "") {
		frmObj.disabled = true;
		if (frmObjFAppl != undefined) {
			frmObjFAppl.value = "N";
			frmObjFAppl.checked = false;
			frmObjFAppl.disabled = true;
		}
		if (frmObjQtyLmt != "" && obj.value == "U") {
			frmObjQtyLmt.value = "";
			frmObjQtyLmt.disabled = true;
		} else
			frmObjQtyLmt.disabled = false;
	} else if (obj.value == "A") {
		frmObj.disabled = false;
		if (frmObjFAppl != undefined) {
			frmObjFAppl.value = "N";
			frmObjFAppl.checked = false;
			frmObjFAppl.disabled = false;
		}
		if (frmObjQtyLmt != "")
			frmObjQtyLmt.disabled = false;
	} else if (obj.value == "R" || obj.value == "P") {
		frmObj.disabled = false;
		if (frmObjFAppl != undefined) {
			frmObjFAppl.value = "N";
			frmObjFAppl.checked = false;
			frmObjFAppl.disabled = true;
		}
		if (frmObjQtyLmt != "") {
			// frmObjQtyLmt.value=""; Commented, so that Qty will not be cleared
			frmObjQtyLmt.disabled = false;
		}
	}

	var formName=document.forms[0].name;
	if(formName =="rate_based_dtl"){
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
    var servGrpLimitSiteSpec = eval("document.rate_based_dtl.servGrpLimitSiteSpec").value;
    var servGrpLmtBy  = eval("document.rate_based_dtl.servGrpLmtBy").value;
    var servGrpLmtFldDisabled = eval("document.rate_based_dtl.servGrpLmtFldDisabled").value;
    var order_associated = eval("document.rate_based_dtl.order_associated").value; //Added IN73730 by shikha on 19-Aug-2020
    var type = eval("document.rate_based_dtl.type"+index).value; //Added IN73662 by shikha on 21-Aug-2020
  //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		
	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	if((servGrpLimitSiteSpec== "true" &&  obj.value == "U")|| order_associated == "Y" || type == "S") { //servGrpLmtFldDisabled ==' disabled ') {				//Modified IN73730 by shikha on 19-Aug-2020
		document.getElementById("serv_grp_limit_ind"+index).setAttribute('disabled', 'disabled');
		document.getElementById("serv_grp_limit_ind"+index).value="";
	} else if(servGrpLimitSiteSpec== "true" && obj.value != "U") {					
		document.getElementById("serv_grp_limit_ind"+index).removeAttribute('disabled');
		if (servGrpLmtBy != "*") {
			if (servGrpLmtBy == "B" ) {
				document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
				+"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='G'>"
				+ getLabel('Common.Group.label', 'Common')
				+ "</option><option value='S'>"
				+ getLabel('eBL.Service.label', 'BL')
				+ "</option></select>";
			} else if (servGrpLmtBy == "G" ) {
				document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"+
				"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='G'>"
				+ getLabel('Common.Group.label', 'Common')
				+ "</option>"
				+ "</select>";
			} else if (servGrpLmtBy == "S" ) {
				document.getElementById('rate_based_tbl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
				+"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='S'>"
				+ getLabel('eBL.Service.label', 'BL')
				+ "</option></select>";
			}
		}	
	}//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	}

}

function srvLimitChkRefund(obj, index) {
	var noofdecimal = document.forms[0].noofdecimal.value
	if (obj.checked) {
		obj.value = "Y";
		eval(document.getElementById("srvLimit_refundAmt" + index)).style.display = 'inline';
		eval("document.forms[0].srvLimit_autoRefund" + index).disabled = false;

		// document.getElementById('srvLimit_rate_based_tbl').rows(parseInt(index)+1).cells(6).innerHTML
		// ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"' checked
		// value='Y' onClick='srvLimitChkRefund(this,\""+index+"\")'/><input // type='text' name='refundAmt"+index+"' id='refundAmt"+index+"' value='Amt'
		// onBlur='putdeci(this,\""+noofdecimal+"\")';srvLimitChkRefundAmt(this,\""+index+"\")'
		// onkeypress='return allowValidNumber1(this,event,\"2\")' size='5' >";
	} else {
		obj.value = "N";
		eval("document.forms[0].srvLimit_refundAmt" + index).value = "";
		eval(document.getElementById("srvLimit_refundAmt" + index)).style.display = 'none';
		eval("document.forms[0].srvLimit_autoRefund" + index).value = "N";
		eval("document.forms[0].srvLimit_autoRefund" + index).checked = false;
		eval("document.forms[0].srvLimit_autoRefund" + index).disabled = true;
	}
}

function srvLimitChkRefundAmt(obj, index) {
	if (obj.value == "" || obj.value == "0" || obj.value == 0
			|| obj.value == "Amt") {
		alert(getMessage("BL8545", 'BL'));
		obj.value = "";
		obj.focus();
	}
}

function srvLimitChkReplace(obj, index) {
	if (obj.checked) {
		obj.value = "Y";
		eval(document.getElementById("srvLimit_replace_dtls" + index)).style.display = 'inline';
		srvLimitShowReplaceDtls(index);
	} else {
		obj.value = "N";
		eval(document.getElementById("srvLimit_replace_dtls"+ index)).style.display = 'none';
	}
}

async function srvLimitShowReplaceDtls(index) {
	var type = eval("document.srvLimit_rate_based_dtl.srvLimit_type" + index).value;
	var service_code = eval("document.srvLimit_rate_based_dtl.srvLimit_service_code"
			+ index).value;
	var service_desc = eval("document.srvLimit_rate_based_dtl.srvLimit_service_desc"
			+ index).value;
	var catalog_code = "";
	var catalog_desc = "";
	var order_associated = "N";
	var mode = document.forms[0].mode.value;
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	/*
	 * if(order_associated=="Y"){ var
	 * catalog_code=eval("document.rate_based_dtl.catalog_code"+index).value;
	 * var
	 * catalog_desc=eval("document.rate_based_dtl.catalog_desc"+index).value; }
	 */
	var replaceSrv_code = eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"
			+ index).value;
	var replaceSrv_desc = eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"
			+ index).value;
	var replaceSrv_cat_code = "";
	var replaceSrv_cat_desc = "";
	var queryString = "mode=" + mode + "&authorized=" + authorized
			+ "&pkgApprovedYN=" + pkgApprovedYN + "&order_associated="
			+ order_associated + "&type=" + type + "&service_code="
			+ service_code + "&service_desc=" + service_desc + "&catalog_code="
			+ catalog_code + "&catalog_desc=" + catalog_desc
			+ "&replaceSrv_code=" + replaceSrv_code + "&replaceSrv_desc="
			+ replaceSrv_desc + "&replaceSrv_cat_code=" + replaceSrv_cat_code
			+ "&replaceSrv_cat_desc=" + replaceSrv_cat_desc;
	var retVal = new String();
	var dialogHeight = "19";
	var dialogWidth = "30";
	var status = "no";
	var arguments = "";
	var title = getLabel("eBL.replaceableService.label", "BL");
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + " ; scroll=no;  status:" + status;
	retVal =await window.showModalDialog("../../eBL/jsp/PkgDefReplaceableSrv.jsp?"
			+ queryString, arguments, features);
	if (retVal != null) {

		eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"
				+ index).value = retVal[0];
		eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"
				+ index).value = retVal[1];
		// eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_cat_code"+index).value=retVal[2];
		// eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_cat_desc"+index).value=retVal[3];
	}
}

function validatePackageDates(formObj, totalRec) {
	var VATappl=eval(formObj+".VATapplicable").value;
	var flag = true;
	for ( var i = 0; i < totalRec; i++) {
		flag = !((eval(formObj + ".toDate_" + i) == undefined || (eval(formObj
				+ ".toDate_" + i).value) == "")
				&& (eval(formObj + ".pkgPriceClsCode_" + i) == undefined || (eval(formObj
						+ ".pkgPriceClsCode_" + i).value) == "")
				&& (eval(formObj + ".oPkgPriceClsCode_" + i) == undefined || (eval(formObj
						+ ".oPkgPriceClsCode_" + i).value) == "") && (eval(formObj
				+ ".glSmry" + i) == undefined || (eval(formObj + ".glSmry" + i).value) == ""));
		if (eval(formObj + ".fromDate_" + i) == undefined
				|| (eval(formObj + ".fromDate_" + i).value) == "" && flag) {
			alert(getMessage("BL8643", 'BL'));
			eval(formObj + ".fromDate_" + i).focus();
			return false;
		}
	if((eval(formObj+".fromDate_"+i) !=undefined && (eval(formObj+".fromDate_"+i).value) !="")&& eval(formObj+".glSmryYN") !=undefined && (eval(formObj+".glSmryYN").value=="Y" || eval(formObj+".glSmryYN").value=="" )&& (eval(formObj+".glSmry"+i).value==""  || eval(formObj+".glSmryDesc"+i).value==""))
	{
		alert(getMessage("BL8636", 'BL'));
		eval(formObj + ".glSmry" + i).value = "";
		eval(formObj + ".glSmry" + i).focus();
		return false;
	}

	if((eval(formObj+".fromDate_"+i) !=undefined && (eval(formObj+".fromDate_"+i).value) !="")&& eval(formObj+".glSmryYN") !=undefined &&(eval(formObj+".glSmryYN").value=="Y" || eval(formObj+".glSmryYN").value=="" ) && (eval(formObj+".glSmry"+i).value!=""  || eval(formObj+".glSmryDesc"+i).value!="") && (eval(formObj+".glSmryDisc"+i).value==""  || eval(formObj+".glSmryDiscDesc"+i).value==""))
	{
		alert(getMessage("BL8636", 'BL'));
		eval(formObj + ".glSmryDisc" + i).value = "";
		eval(formObj + ".glSmryDisc" + i).focus();
		return false;
	}
if(VATappl=="Y"){
	if((eval(formObj+".fromDate_"+i) !=undefined && (eval(formObj+".fromDate_"+i).value) !="")&& eval(formObj+".glSmryYN") !=undefined && (eval(formObj+".glSmryYN").value=="Y" || eval(formObj+".glSmryYN").value=="" )&& (eval(formObj+".glSmry"+i).value!=""  || eval(formObj+".glSmryDesc"+i).value!="")&& (eval(formObj+".glSmryDisc"+i).value!=""  || eval(formObj+".glSmryDiscDesc"+i).value!="")&& (eval(formObj+".VATapp"+i).value=="Y")&& (eval(formObj+".VATpercent"+i).value==""))
	{
		alert(getMessage("BLSS0072", 'BL'));
		eval(formObj + ".VATpercent" + i).value = "";		
		return false;
	}
	}
	}
	return true;
}

function callPkgPriceClass(obj, from, type, index) {
	var str = "";
	var value = "";
	if (obj != "" && obj.value != null && obj.value != undefined
			&& obj.value != "") {
		value = obj.value;
	}
	if ((from != "" && obj.value != "") || (from == "")) {
		var sql = "select price_class_code code, short_desc description from bl_price_class_lang_vw where language_id='"
				+ document.forms[0].locale.value
				+ "' and nvl(status,'X') <> 'S' and upper(price_class_code) like upper(?) and upper(short_desc) like upper(?)";
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		var pClsCode = eval("document.forms[0].pkgPriceClsCode_" + index);
		var pClsDesc = eval("document.forms[0].pkgPriceClsDesc_" + index);
		var title = getLabel("eBL.PACKAGE_PRICE_CLASS.label", "BL");
		if (type == "OUT_PRICE_CLASS") {
			title = getLabel("eBL.OUTSIDE_PACKAGE_PRICE_CLASS.label", "BL");
			pClsCode = eval("document.forms[0].oPkgPriceClsCode_" + index);
			pClsDesc = eval("document.forms[0].oPkgPriceClsDesc_" + index);
		}
		var local = document.forms[0].locale.value;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = CODE_DESC;
		retVal = CommonLookup(title, argumentArray);
		if (retVal != null && retVal != "") {
			pClsDesc.value = retVal[1];
			pClsCode.value = retVal[0];
		} else {
			pClsDesc.value = "";
			pClsCode.value = "";
		}
	}
}

function showBasePrice(obj, from, index) // Include code for charge based and rate based
{
	$("#select_" + index).prop('checked', true);
	var value = eval("document.forms[0].fromDate_" + index).value;
	var packageCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;
	// var copyFrm_pkgCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.copyFrm_pkgCode.value;
	var totRec = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
	var mode = parent.parent.PkgDefHeader.document.forms[0].mode.value

	if (parent.parent.PkgDefDetailFrame.basePriceDtl != undefined) {
		var frmObj = parent.parent.PkgDefDetailFrame.basePriceDtl.document
				.forms[0];
		if (frmObj != null && frmObj != undefined) {
			var xmlString = formXMLString(frmObj, "PACKAGE_PRICE", "tab",
					packageCode);
			var updation = formValidation(xmlString, "PACKAGE_PRICE");
		}
	} else if (parent.parent.PkgDefDetailFrame.ChargeBasedDtl != undefined) {
		var frmObj = parent.parent.PkgDefDetailFrame.ChargeBasedDtl.document
				.forms[0];
		if (frmObj != null && frmObj != undefined) {
			var xmlString = formXMLString(frmObj, "CHARGE_BASED", "tab",
					packageCode);
			var updation = formValidation(xmlString, "CHARGE_BASED");
		}
		if (parent.parent.PkgDefDetailFrame.length > 2) {
			if (parent.parent.PkgDefDetailFrame.ChargeBasedExCln != undefined) {
				var frmObj = parent.parent.PkgDefDetailFrame.ChargeBasedExCln.document
						.forms[0];
				if (frmObj != null && frmObj != undefined) {
					var xmlString = formXMLString(frmObj, "CHARGE_BASED_ITEM",
							"excln", packageCode);
					var updation = formValidation(xmlString,
							"CHARGE_BASED_ITEM");
				}
			}
		}
	} else if (parent.parent.PkgDefDetailFrame.rate_based_dtl != undefined) {
		var frmObj = parent.parent.PkgDefDetailFrame.rate_based_dtl.document
				.forms[0];
		if (frmObj != null && frmObj != undefined) {
			var xmlString = formXMLString(frmObj, "RATE_BASED", "tab",
					packageCode);
			var updation = formValidation(xmlString, "RATE_BASED");
		}
		if (parent.parent.PkgDefDetailFrame.length > 2) {
			if (parent.parent.PkgDefDetailFrame.srvLimit_rate_based_dtl != undefined) {
				var frmObj = parent.parent.PkgDefDetailFrame.srvLimit_rate_based_dtl.document
						.forms[0];
				if (frmObj != null && frmObj != undefined) {
					var xmlString = formXMLString(frmObj,
							"SRVLIMIT_RATE_BASED", "excln", packageCode);
					var updation = formValidation(xmlString,
							"SRVLIMIT_RATE_BASED");
				}
			}
		}
	}
	if (value == null || value == "") {
		alert("Please enter from date");
		obj.checked = false
		// parent.parent.PkgDefDetailFrame.location.href='../../eCommon/html/blank.html';
	} else {
		document.forms[0].fromDate.value = value;
		parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value = value;
		parent.parent.PkgDefTabFrame.document.frmPkgDefTab.index.value = index;
		showTabDetail('PACKAGE_PRICE', '1', "DATE_CNG", index)
	}	
}

function chkautoRefund(obj, refundAmtObj) {
	if (eval("document.forms[0]." + refundAmtObj).value == "") {
		obj.checked = false;
		obj.value = "N";
	} else if (obj.checked)
		obj.value = "Y";
	else
		obj.value = "N";
}

function assignClosePkgVal(obj, index) {
	/*
	 * Commented by muthu against 32906 on 20-6-12 if(obj.checked)
	 * eval("document.forms[0].closePkg"+i).value= "Y"; else
	 * eval("document.forms[0].closePkg"+i).value= "N";
	 */
	// Below Code is Added by MuthuN against 32906 on 20-6-12
	var totalRecords = formObj.totalRecords.value;
	for (i = 0; i < totalRecords; i++) {
		if (i == index) {
			eval("document.forms[0].closePkg" + i).value = "Y";
		} else {
			eval("document.forms[0].closePkg" + i).value = "N";
		}
	}
}

function chkRefundCB(obj, index) {
	var noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value

	if (obj.checked) {
		obj.value = "Y";
		eval("document.forms[0].autoRefund_" + index).disabled = false;
		eval(document.getElementById("refundAmt_" + index)).style.display = "inline";

	} else {
		obj.value = "N";
		eval("document.forms[0].autoRefund_" + index).value = "N";
		eval("document.forms[0].autoRefund_" + index).checked = false;
		eval("document.forms[0].autoRefund_" + index).disabled = true;
		eval(document.getElementById("refundAmt_" + index)).value = "";
		eval(document.getElementById("refundAmt_" + index)).style.display = "none";
	}
}

// Karthik modified the below code for Validating add link MMS-CRF-0023
function checkPartialDeposit(obj, index) {
	if (obj.checked) {
		eval("document.forms[0].minDepAmtind_" + index).disabled = false;
		// eval("document.forms[0].minDepAmt_"+index).disabled = false;

		obj.value = "Y";
	} else {
		eval("document.forms[0].minDepAmt_" + index).value = "";
		eval("document.forms[0].minDepAmtind_" + index).value = "";
		eval("document.forms[0].minDepAmtind_" + index).selectedIndex = 0;
		eval("document.forms[0].minDepAmt_" + index).disabled = true;
		eval("document.forms[0].minDepAmtind_" + index).disabled = true;
		obj.value = "N";
	}
}
// Karthik modified the below code to add link MMS-CRF-0023

function checkDeposit(obj, index) {
	if (obj.checked) {
		eval("document.forms[0].partialDeposit_" + index).disabled = false;
		obj.value = "Y";
	} else {
		obj.value = "N";
		eval("document.forms[0].partialDeposit_" + index).value = "N";
		eval("document.forms[0].partialDeposit_" + index).checked = false;
		eval("document.forms[0].partialDeposit_" + index).disabled = true;
		eval("document.forms[0].minDepAmt_" + index).value = "";
		eval("document.forms[0].minDepAmt_" + index).disabled = true;
		eval("document.forms[0].minDepAmtind_" + index).value = "";
		eval("document.forms[0].minDepAmtind_" + index).selectedIndex = 0;
		eval("document.forms[0].minDepAmtind_" + index).disabled = true;
	}
}

function checkForApproval(obj, loggedInUser, toDate) {
	if (obj.checked) {
		obj.value = "Y";
		document.forms[0].approvedBy.value = loggedInUser;
		document.forms[0].approvedDate.value = toDate;
		// document.forms[0].approvedDate.value = "";
		// document.forms[0].approvedDate.readOnly = false;
		// document.forms[0].approvedDateCal.disabled = false;
	} else {
		obj.value = "N";
		document.forms[0].approvedBy.value = "";
		document.forms[0].approvedDate.value = "";
		// document.forms[0].approvedDate.readOnly = true;
		// document.forms[0].approvedDateCal.disabled = true;
	}
}

function glSmryCodeLookUp(glSmryDesc, glSmry, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmry_temp" + index + ".value") != eval("formObj.glSmry"
				+ index + ".value")) {
			if (eval("formObj.glSmry" + index).value != "") {
				var argumentArray = new Array();
				var dataNameArray = new Array();
				var dataValueArray = new Array();
				var dataTypeArray = new Array();
				var title = getLabel("eBL.AccountingCode.label", "BL");
				var locale = formObj.locale.value;
				var facility_id = formObj.facility_id.value;

				argumentArray[0] = "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"
						+ locale
						+ "')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"
						+ facility_id
						+ "') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				argumentArray[4] = "1,2";
				argumentArray[5] = glSmry.value;
				argumentArray[6] = DESC_LINK;
				argumentArray[7] = CODE_DESC;
				retArray = CommonLookup(title, argumentArray);
				if (retArray != 'undefined' && retArray != undefined
						&& retArray != null) {
					if (retArray[0] + "" != "undefined"
							&& retArray[0] + "" != "") {
						eval("document.forms[0].glSmry" + index).value = retArray[0];
						eval("document.forms[0].glSmry_temp" + index).value = retArray[0];
					}
					if (retArray[1] + "" != "undefined"
							&& retArray[1] + "" != "") {
						eval("document.forms[0].glSmryDesc" + index).value = retArray[1];
						eval("document.forms[0].glSmryDesc_temp" + index).value = retArray[1];
					}
				} else {
					eval("document.forms[0].glSmry" + index).value = "";
					eval("document.forms[0].glSmryDesc" + index).value = ""
					eval("formObj.glSmry_temp" + index).value = "";
					eval("formObj.glSmryDesc_temp" + index).value = "";
				}
			}
		}
	}
}

function glSmryDescLookUp(glSmryDesc, glSmry, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmryDesc_temp" + index + ".value") != eval("formObj.glSmryDesc"
				+ index + ".value")) {
			if (eval("formObj.glSmryDesc" + index).value != "")
				show_glSmryLookUp(glSmryDesc, glSmry, index);
		}
	}
}

function glSmryLookUp(glSmryDesc, glSmry, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmryDesc" + index).value == "") {
			show_glSmryLookUp(glSmryDesc, glSmry, index);
		}
	}
}

function show_glSmryLookUp(glSmryDesc, glSmry, index) {
	var formObj = document.frmPkgDefBaseDate;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("eBL.AccountingCode.label", "BL");
	var locale = formObj.locale.value;
	var facility_id = formObj.facility_id.value;

	argumentArray[0] = "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"
			+ locale
			+ "')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"
			+ facility_id
			+ "') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = glSmryDesc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argumentArray);

	if (retArray != 'undefined' && retArray != undefined && retArray != null) {
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {
			eval("document.forms[0].glSmry" + index).value = retArray[0];
			eval("document.forms[0].glSmry_temp" + index).value = retArray[0];
		}
		if (retArray[1] + "" != "undefined" && retArray[1] + "" != "") {
			eval("document.forms[0].glSmryDesc" + index).value = retArray[1];
			eval("document.forms[0].glSmryDesc_temp" + index).value = retArray[1];
		}
	} else {
		eval("document.forms[0].glSmry" + index).value = "";
		eval("document.forms[0].glSmryDesc" + index).value = ""
		eval("formObj.glSmry_temp" + index).value = "";
		eval("formObj.glSmryDesc_temp" + index).value = "";
	}
}

/* Check for special character on Blur of alpha numeric field */
function specialCharCheck(obj) {
	if (obj.value != "") {
		if (CheckChars(obj)) {
			// clearBean(obj.value);
			// parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.packageCode.value=obj.value;
		} else {
			alert(getMessage("BL8510", 'BL'));
			obj.value = "";
			obj.focus();
		}
	}
}

/* Check for special character on Blur of numeric field */
function numberCheck(obj, type, mode) {
	if (obj.value != "") {
		if (CheckNum(obj)) {
			if (type == "M")
				check_months(obj)
			else if (type == "D")
				check_days(obj)
			else if (type == "V")
				chkValidDays(obj, mode)
			else if (type == "P")
				return validPercentage(obj, type)
		}
	}
}

function dateKeyChange(obj, obj1, obj2, index, from, prevDate, packageCode) {
	packageCode = parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value
	if (pkgValidateDate(obj, obj1, obj2, index, from)) {
		var prevDateVal = eval(prevDate).value
		if (prevDateVal == null || prevDateVal == "")
			eval(prevDate).value = obj.value;
		if (prevDateVal != "" && obj.value != prevDateVal) {
			curIndex = parent.parent.PkgDefTabFrame.document.frmPkgDefTab.index.value
			if (curIndex == index
					&& parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value == prevDateVal)
				parent.parent.PkgDefTabFrame.document.frmPkgDefTab.fromDate.value = obj.value

			var xmlStr = "<root><SEARCH ";
			xmlStr += "packageCode=\"" + packageCode + "\" ";
			xmlStr += "prevDate=\"" + prevDateVal + "\" ";
			xmlStr += "fromDate=\"" + obj.value + "\" ";
			xmlStr += " /></root>";
			var updation = formValidation(xmlStr, "DATE_KEY_CHANGE");
			if (parent.parent.PkgDefDetailFrame.basePriceDtl != undefined) {
				var frmObj = parent.parent.PkgDefDetailFrame.basePriceDtl.document
						.forms[0];
				if (frmObj != null && frmObj != undefined) {
					parent.parent.PkgDefDetailFrame.basePriceDtl.document
							.forms[0].fromDate.value = obj.value;
				}
			} else if (parent.parent.PkgDefDetailFrame.ChargeBasedDtl != undefined) {
				var frmObj = parent.parent.PkgDefDetailFrame.ChargeBasedDtl.document
						.forms[0];
				if (frmObj != null && frmObj != undefined) {
					parent.parent.PkgDefDetailFrame.ChargeBasedDtl.document
							.forms[0].fromDate.value = obj.value;
				}
				if (parent.parent.PkgDefDetailFrame.length > 2) {
					if (parent.parent.PkgDefDetailFrame.ChargeBasedExCln != undefined) {
						var frmObj = parent.parent.PkgDefDetailFrame.ChargeBasedExCln.document
								.forms[0];
						if (frmObj != null && frmObj != undefined) {
							parent.parent.PkgDefDetailFrame.ChargeBasedExCln.document
									.forms[0].fromDate.value = obj.value
						}
					}

				}
			} else if (parent.parent.PkgDefDetailFrame.rate_based_dtl != undefined) {
				var frmObj = parent.parent.PkgDefDetailFrame.rate_based_dtl.document
						.forms[0];
				if (frmObj != null && frmObj != undefined) {
					parent.parent.PkgDefDetailFrame.rate_based_dtl.document
							.forms[0].fromDate.value = obj.value;
				}
				if (parent.parent.PkgDefDetailFrame.length > 2) {
					if (parent.parent.PkgDefDetailFrame.srvLimit_rate_based_dtl != undefined) {
						var frmObj = parent.parent.PkgDefDetailFrame.srvLimit_rate_based_dtl.document
								.forms[0];
						if (frmObj != null && frmObj != undefined) {
							parent.parent.PkgDefDetailFrame.srvLimit_rate_based_dtl.document
									.forms[0].fromDate.value = obj.value;
						}
					}
				}
			}
		}
		eval(prevDate).value = obj.value;
	}
}

function chkStatus() {
	var xmlStr = "<root><SEARCH ";
	xmlStr += " /></root>";
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST", "PkgDefValidation.jsp?func_mode=CHECK_STATUS", false);
	xmlHttp.send(xmlDoc);
	var status = trimString(xmlHttp.responseText);
	$.post("PkgDefValidation.jsp?func_mode=CHECK_STATUS",
			{ xmlStr: xmlStr},
			function(data){
			return(trimString(data));
		}
		);*/
	//V210119 Starts
	$.ajax({
			type: 'POST',
			url: "PkgDefValidation.jsp?func_mode=CHECK_STATUS",
			data : { xmlStr: xmlStr },
			success: function(data) {
				return(trimString(data));
                  },
			async:   false
			});	
	//V210119 Ends	
		
	//return (status);	
}

function validPercentageForRefund(obj, autoRefundAmtObj) {
	var refundRate = parseFloat(obj.value);
	if (obj.value == "" || obj.value == '0') {
		eval("document.forms[0]." + autoRefundAmtObj).value = "N";
		eval("document.forms[0]." + autoRefundAmtObj).checked = false;
	}
	if (refundRate > 100.00 || refundRate < 1) {
		alert(getMessage("BL8653", "BL"));
		obj.value = "";
		eval("document.forms[0]." + autoRefundAmtObj).value = "N";
		eval("document.forms[0]." + autoRefundAmtObj).checked = false;
		obj.focus();
		return false;
	}
}

function checkForNegetiveNumber(obj, noofdecimal, msg) {
	if (obj.value < 0) {
		alert(getMessage(msg, "BL"));
		obj.value = "";
		obj.focus();
	} else {
		putdeci(obj, noofdecimal);
	}
}

// Authorize user for modification
async function authUser(packageCode) {
	

	var dialogHeight = "400px";
	var dialogWidth = "700px";
	var dialogTop = "10px";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop;
	var arguments = "";
	retVal = await window.showModalDialog("../../eBL/jsp/PkgDefAuthoriseMain.jsp?mode=s",arguments, features);
	if (retVal != undefined) {
		if (retVal.length > 0) {
			if (retVal[0] == "Y") {
				document.forms[0].modify.disabled = true;
				//	var param = document.forms[0].strAllParam.value
				parent.parent.location.href = "../../eBL/jsp/PkgDefDetailMainFrame.jsp?authorized=Y&mode=modify&packageCode="+ packageCode;
			}
		}
	}
}

function retModal(obj) {
	//if(called_frm == "")
	//{
	var returnArray = new Array("N")
	parent.window.returnValue = returnArray;
	parent.window.close();
	//}
}

function call_pass_valid() {
	var user = document.forms[0].user.value;
	var err_msg = document.forms[0].err_msg.value; //V220323
	var remarks = document.forms[0].remarks.value;
	var valid_user_rec_found_YN = document.forms[0].valid_user_rec_found_YN.value;
	
	if(err_msg!=""){
		alert(getMessage(err_msg,'BL'));
		return false;
	}else{
		var returnArray = new Array("Y", "Y", remarks, user);
			parent.window.returnValue = returnArray;
			parent.window.close();
			return true;
	} //V220323
}

function confirmPasswdchk(obj) {
	var usr_id = document.forms[0].user_id;
	var pass_wd = document.forms[0].passwd;
	var rmks = document.forms[0].remarks;
	if (usr_id.value == "") {
		alert(getMessage("BL9112", "BL"));
		usr_id.focus();
		return false;
	}
	if (pass_wd.value == "") {
		alert(getMessage("BL9113", "BL"));
		pass_wd.focus();
		return false;
	}
	if (rmks.value == "") {
		alert(getMessage("BL9306", "BL"));
		rmks.focus();
		return false;
	}
	var HTMLVal = "<html><body><form name='PkgDefConfirmPassWdForm' id='PkgDefConfirmPassWdForm' method='post' action='../../eBL/jsp/PkgDefConfirmPassWd.jsp'>"
			+ "<input type='hidden' name='usr_id' id='usr_id' value='"
			+ usr_id.value
			+ "'>"
			+ "<input type='hidden' name='pass_wd' id='pass_wd' value='"
			+ pass_wd.value
			+ "'>"
			+ "<input type='hidden' name='remarks' id='remarks' value='"
			+ rmks.value
			+ "'>"
			+ "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"
			+ "</form></body></html>";
	parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.frames[1].document.PkgDefConfirmPassWdForm.submit();
}

function pkgDefLoaded() {
	chkStatus()
}

function validateWithPkgPrice(obj, index) {
	var pkgPrice = eval("document.forms[0].price_" + index).value
	var pkgPriceInd = eval("document.forms[0].indicator_" + index).value
	var minDepAmt = obj.value;
	if (pkgPriceInd == "R" && (parseFloat(minDepAmt) > parseFloat(pkgPrice))) {
		alert("Minimun deposit should be less than or equal to Package price");
		obj.value = "";
		obj.focus();
		//alert(getMessage("BL9306","BL"));
	}
}

function validateBaePrice(obj, noofdecimal, msg, index) {
	checkForNegetiveNumber(obj, noofdecimal, msg)
	if (obj != null && obj.value != "") {
		if (eval("document.forms[0].minDepAmtind_" + index).value == "A")
			validateWithPkgPrice(eval("document.forms[0].minDepAmt_" + index),
					index)
	} else {
		eval("document.forms[0].roundTo_" + index).value = "";
		eval("document.forms[0].roundInd_" + index).selectedIndex = 0;
		eval("document.forms[0].minDepAmt_" + index).value = "";
	}
}

function alignHeading() {
	if (parent.rate_based_hdr_frame.document.getElementById("tableheader") != null) {
		parent.rate_based_hdr_frame.document.getElementById("tableheader").width = eval(parent
				.frames[1].document.getElementById("rate_based_tbl").offsetWidth);
		for (j = 0; j < parent.frames[1].document.getElementById("rate_based_tbl").rows[1].cells.length; j++) {

			var wid = eval(parent.frames[1].document.getElementById("rate_based_tbl").rows[1]
					.cells[j].offsetWidth);

			if (parent.rate_based_hdr_frame.document.getElementById("tableheader").rows[0]
					.cells[j] != null) {

				parent.rate_based_hdr_frame.document.getElementById("tableheader").rows[0]
						.cells[j].width = wid;
			}
		}
	}
}

function moveFrame() {
	var temp = document.body.scrollLeft;
	scrollValue = temp;

	if (parent.rate_based_hdr_frame.location.href.indexOf(".jsp") != -1) {
		parent.rate_based_hdr_frame.document.body.scrollLeft = temp;
	}
}

function changeMainTabClass(tabObj, tabFrame) {
	if (tabFrame.document.forms[0] != null) {
		prevTabObj = tabFrame.document.forms[0].prevTabObj.value;
		if (prevTabObj != null && prevTabObj != "") {
			eval(tabFrame.document.getElementById('prevTabObj')).className = "tabA"
			eval(tabFrame.document.getElementById('prevTabObj') + "span").className = "tabAspan"
		}
		eval(tabFrame.document.getElementById('tabObj')).className = "tabClicked"
		eval(tabFrame.document.getElementById('tabObj' + "span").className = "tabSpanclicked"
		tabFrame.document.forms[0].prevTabObj.value = tabObj
	}
}

function glSmryDiscCodeLookUp(glSmryDiscDesc, glSmryDisc, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmryDisc_temp" + index + ".value") != eval("formObj.glSmryDisc"
				+ index + ".value")) {
			if (eval("formObj.glSmryDisc" + index).value != "") {
				var argumentArray = new Array();
				var dataNameArray = new Array();
				var dataValueArray = new Array();
				var dataTypeArray = new Array();
				var title = getLabel("eBL.AccountingCode.label", "BL");
				var locale = formObj.locale.value;
				var facility_id = formObj.facility_id.value;

				argumentArray[0] = "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"
						+ locale
						+ "')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"
						+ facility_id
						+ "') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				argumentArray[4] = "1,2";
				argumentArray[5] = glSmryDisc.value;
				argumentArray[6] = DESC_LINK;
				argumentArray[7] = CODE_DESC;
				retArray = CommonLookup(title, argumentArray);
				if (retArray != 'undefined' && retArray != undefined
						&& retArray != null) {
					if (retArray[0] + "" != "undefined"
							&& retArray[0] + "" != "") {
						eval("document.forms[0].glSmryDisc" + index).value = retArray[0];
						eval("document.forms[0].glSmryDisc_temp" + index).value = retArray[0];
					}
					if (retArray[1] + "" != "undefined"
							&& retArray[1] + "" != "") {
						eval("document.forms[0].glSmryDiscDesc" + index).value = retArray[1];
						eval("document.forms[0].glSmryDiscDesc_temp" + index).value = retArray[1];
					}

				} else {
					eval("document.forms[0].glSmryDisc" + index).value = "";
					eval("document.forms[0].glSmryDiscDesc" + index).value = ""
					eval("formObj.glSmryDisc_temp" + index).value = "";
					eval("formObj.glSmryDiscDesc_temp" + index).value = "";
				}
			}
		}
	}
}

function glSmryDiscDescLookUp(glSmryDiscDesc, glSmryDisc, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmryDiscDesc_temp" + index + ".value") != eval("formObj.glSmryDiscDesc"
				+ index + ".value")) {
			if (eval("formObj.glSmryDiscDesc" + index).value != "")
				show_glSmryDiscLookUp(glSmryDiscDesc, glSmryDisc, index);
		}
	}
}

function glSmryDiscLookUp(glSmryDiscDesc, glSmryDisc, index) {
	var formObj = document.frmPkgDefBaseDate;
	if (formObj != null) {
		if (eval("formObj.glSmryDiscDesc" + index).value == "") {
			show_glSmryDiscLookUp(glSmryDiscDesc, glSmryDisc, index);
		}
	}
}

function show_glSmryDiscLookUp(glSmryDiscDesc, glSmryDisc, index) {
	var formObj = document.frmPkgDefBaseDate;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = getLabel("eBL.AccountingCode.label", "BL");
	var locale = formObj.locale.value;
	var facility_id = formObj.facility_id.value;

	argumentArray[0] = "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"
			+ locale
			+ "')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"
			+ facility_id
			+ "') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = glSmryDiscDesc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argumentArray);

	if (retArray != 'undefined' && retArray != undefined && retArray != null) {
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {
			eval("document.forms[0].glSmryDisc" + index).value = retArray[0];
			eval("document.forms[0].glSmryDisc_temp" + index).value = retArray[0];
		}
		if (retArray[1] + "" != "undefined" && retArray[1] + "" != "") {
			eval("document.forms[0].glSmryDiscDesc" + index).value = retArray[1];
			eval("document.forms[0].glSmryDiscDesc_temp" + index).value = retArray[1];
		}

	} else {
		eval("document.forms[0].glSmryDisc" + index).value = "";
		eval("document.forms[0].glSmryDiscDesc" + index).value = ""
		eval("formObj.glSmryDisc_temp" + index).value = "";
		eval("formObj.glSmryDiscDesc_temp" + index).value = "";
	}
}

//Added Newly By Nmuthu on 11-4-2012 against 32308 - Starts here
function alignHeading_Exclude() {
	if (parent.srvLimit_rate_based_hdr.document.getElementById("tableheader") != null) {
		parent.srvLimit_rate_based_hdr.document.getElementById("tableheader").width = eval(parent
				.frames[4].document.getElementById("srvLimit_rate_based_tbl").offsetWidth);

		for (j = 0; j < parent.frames[4].document.getElementById("srvLimit_rate_based_tbl")
				.rows(0).cells.length; j++) {
			var wid = eval(parent.frames[4].document.getElementById("srvLimit_rate_based_tbl")
					.rows(0).cells(j).offsetWidth);
			if (parent.srvLimit_rate_based_hdr.document.getElementById("tableheader").rows(0)
					.cells(j) != null) {
				parent.srvLimit_rate_based_hdr.document.getElementById("tableheader").rows(0)
						.cells(j).width = wid;				
			}
		}
	}
}

function moveFrame_Exclude() {
	var temp = document.body.scrollLeft;
	scrollValue = temp;

	if (parent.srvLimit_rate_based_hdr.location.href.indexOf(".jsp") != -1) {
		parent.srvLimit_rate_based_hdr.document.body.scrollLeft = temp;
	}
}
//Added Newly By Nmuthu on 11-4-2012 against 32308 - Ends here	

async function callReportCustBase(obj, index) {
	var P_PACKAGE_CODE = parent.parent.frames[0].document.forms[0].packageCode.value;
	//var P_BLNG_CLASS =parent.frames[1].document.forms[0].blgClsCode.value;
	var P_BLNG_CLASS = eval("parent.frames[1].document.forms[0].blgClsCode_"
			+ index).value;
	var P_EFF_FROM_DT = parent.frames[1].document.forms[0].fromDate.value;
	var p_facility_id = parent.parent.frames[0].document.forms[0].facilityId.value;
	var P_CUST_CODE = parent.frames[1].document.forms[0].cust_code.value;
	var P_CUST_GRP_CODE = parent.frames[1].document.forms[0].cust_grp_code.value;
	var dialogHeight = "11";
	var dialogWidth = "25";
	var arguments = "";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + "; status:no";
	var url = "../../eBL/jsp/BLPkgDefCustBaseReport.jsp";
	url = url + "?&facilityId=" + p_facility_id + "&packageCode="
			+ P_PACKAGE_CODE + "&fromDate=" + P_EFF_FROM_DT + "&blgClsCode="
			+ P_BLNG_CLASS + "&cust_code=" + P_CUST_CODE + "&cust_grp_code="
			+ P_CUST_GRP_CODE + "&p_report_id=BLPKGCUS";
	retVal =await window.showModalDialog(url, arguments, features);
}

async function callReportPkgBase(obj, index) {
	var P_PACKAGE_CODE = parent.parent.frames[0].document.forms[0].packageCode.value;
	//var P_BLNG_CLASS =document.forms[0].blgClsCode.value;	
	var P_BLNG_CLASS = eval("document.forms[0].blgClsCode_" + index).value;
	var P_EFF_FROM_DT = parent.frames[1].document.forms[0].fromDate.value;
	var p_facility_id = parent.parent.frames[0].document.forms[0].facilityId.value;
	var dialogHeight = "11";
	var dialogWidth = "25";
	var arguments = "";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + "; status:no";
	var url = "../../eBL/jsp/BLPkgDefBaseReport.jsp";
	url = url + "?&facilityId=" + p_facility_id + "&packageCode="
			+ P_PACKAGE_CODE + "&fromDate=" + P_EFF_FROM_DT + "&blgClsCode="
			+ P_BLNG_CLASS + "&p_report_id=BLPKGDEF";
	retVal =await window.showModalDialog(url, arguments, features);
}

function PkgCustBaseRun() {
	BLReportOptionsForm.submit();
	window.close();
}

//newly added on 02-07-12
function alignHeading_BasePrice() {
	if (parent.basePriceHdrFrame != undefined) //Karthik Added to stop existing script error
		if (parent.basePriceHdrFrame.document.getElementById("tableheader") != null) {
			parent.basePriceHdrFrame.document.getElementById("tableheader").width = eval(parent.basePriceDtlFrame.document.getElementById("pkgPrice").offsetWidth);
			for (j = 0; j < parent.basePriceDtlFrame.document.getElementById("pkgPrice")
					.rows(0).cells.length; j++) {
				var wid = eval(parent.basePriceDtlFrame.document.getElementById("pkgPrice")
						.rows(0).cells(j).offsetWidth);
				if (parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
						.cells(j) != null) {
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(j).width = wid;
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(0).width = '196';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(1).width = '90';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(2).width = '90';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(3).width = '80';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(4).width = '115';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(5).width = '80';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(6).width = '120';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(7).width = '80';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(8).width = '120';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(9).width = '120';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(10).width = '80';
					parent.basePriceHdrFrame.document.getElementById("tableheader").rows(0)
							.cells(11).width = '30';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(0).width = '190';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(1).width = '90';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(2).width = '85';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(3).width = '80';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(4).width = '115';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(5).width = '80';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(6).width = '115';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(7).width = '80';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(8).width = '115';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(9).width = '115';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(10).width = '80';
					parent.basePriceDtlFrame.document.getElementById("pkgPrice").rows(0)
							.cells(11).width = '30';
				}
			}
		}
}

//Newly Added by MuthuN against 28192 on 2-8-12 - SKR-CRF-031 Starts Here
function onSrvLimitServiceTypeChange1(obj, index) {
	eval("document.frmPkgDefChargeBased.cbCode_" + index).value = "";
	eval("document.frmPkgDefChargeBased.cbDesc_" + index).value = "";
	eval("document.frmPkgDefChargeBased.amt_limit_ind" + index).enable = true;
}

function onSrvLimitServiceTypeChange_custcharge(obj, index) {
	eval("document.cust_charge_based_dtl.cbCode_" + index).value = "";
	eval("document.cust_charge_based_dtl.cbDesc_" + index).value = "";
	eval("document.cust_charge_based_dtl.amt_limit_ind" + index).enable = true;
}
//Newly Added by MuthuN against 28192 on 2-8-12 - SKR-CRF-031 - Ends Here

//Added by Rajesh V - Split Reqd
function checkSplitReqd(obj) {
	if (obj.checked) {
		obj.value = 'Y';
	} else {
		obj.value = 'N';
	}
}

function changeSplitReqd(obj, called_from, indx, dailyLimitSiteSpec, dailyLmtIndicator) {	
	var val;
	if (called_from == "amt_limit") {
		val = obj.value;
		if (val == "U" && dailyLimitSiteSpec != "true") {//Added V190406-Aravindh/MMS-DM-CRF-0129/if condition included dailyLimitSiteSpec
			document.getElementById("split_reqd" + indx).disabled = true;
			document.getElementById("split_reqd" + indx).checked = false;
			document.getElementById("split_reqd" + indx).value = "N";
		} else if(val != "" && dailyLimitSiteSpec == "true" && dailyLmtIndicator.value != "*") {//Added V190406-Aravindh/MMS-DM-CRF-0129/else if condition included
			document.getElementById("split_reqd" + indx).disabled = true;
			document.getElementById("split_reqd" + indx).checked = true;
			document.getElementById("split_reqd" + indx).value = "Y";
		} else {
			document.getElementById("split_reqd" + indx).disabled = false;
			document.getElementById("split_reqd" + indx).checked = false;
			document.getElementById("split_reqd" + indx).value = "N";
		}
	} else if (called_from == "exclude") {
		if (obj.checked) {
			document.getElementById("split_reqd" + indx).disabled = true;
			document.getElementById("split_reqd" + indx).checked = false;
			document.getElementById("split_reqd" + indx).value = "N";
		} else {
			document.getElementById("split_reqd" + indx).disabled = false;
		}
	}
}
//Added by Rajesh V - Split Reqd
function duplicateCheck(obj,mode){
	if(mode=="insert"){		
		var xmlStr = "<root><SEARCH ";
	 	xmlStr += " /></root>";
		var status ="";
		/*var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST", "PkgDefValidation.jsp?func_mode=duplicatePackageCodeCheck&packageCode="+obj.value, false);
		xmlHttp.send(xmlDoc);
		$.post("PkgDefValidation.jsp?func_mode=duplicatePackageCodeCheck&packageCode="+obj.value,
			{ xmlStr: xmlStr},
			function(data){
			status =(trimString(data));
		}
		);*/
		//V210119 Starts
		$.ajax({
			type: 'POST',
			url: "PkgDefValidation.jsp?func_mode=duplicatePackageCodeCheck&packageCode="+obj.value,
			data : { xmlStr: xmlStr },
			success: function(data) {
				status =(trimString(data));
                  },
			async:   false
			});
		//V210119 Ends
		
		//var status = trimString(xmlHttp.responseText);
		if(status > 0){
			alert(getMessage("BL3150", "BL"));
			$(obj).val('');
			obj.focus();
			return false
		}else{
			return true
		}
	 }
}

//sarathkumar InclHmeMedi 
function IncludeHomeMedicationCheck(code, type, index){
	var service_code = code.value;
	var type = type.value
	  var AllYn= parent.parent.PkgDefHeader.frmPkgDefHeader.document.forms[0].AllYn.value;
		var IpYn= parent.parent.PkgDefHeader.frmPkgDefHeader.document.forms[0].IpYn.value;
		var DcYn= parent.parent.PkgDefHeader.frmPkgDefHeader.document.forms[0].DcYn.value;
		var OpYn= parent.parent.PkgDefHeader.frmPkgDefHeader.document.forms[0].OpYn.value;
		var EmYn= parent.parent.PkgDefHeader.frmPkgDefHeader.document.forms[0].EmYn.value;
		
	if(IpYn == 'Y' || DcYn == 'Y'){		
		$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+service_code+"&type="+type,
		async:false,
		dataType:"json",
		success : function(data){
			reqId=$.trim(data.includeHomeMedicationAllYN);
		}
		});
		if(reqId == 'Y'){
			document.getElementById("includeHomeMedication"+index).disabled = false;
			document.getElementById("enableDisParam"+index).value = 'Y';
		}else{
			document.getElementById("includeHomeMedication"+index).disabled = true;
			document.getElementById("includeHomeMedication"+index).checked=false;  
			document.getElementById("enableDisParam"+index).value = 'N';
		}
	}
	else{	
			document.getElementById("includeHomeMedication"+index).disabled = true;
			document.getElementById("enableDisParam"+index).value = 'N';
	}
}

//sarathkumar InclHmeMedi 
function includeHomeMedicationEnable(){ 	
	   var AllYn= parent.parent.PkgDefHeader.document.getElementById('AllYn').value;
		var IpYn= parent.parent.PkgDefHeader.document.getElementById('IpYn').value;
		var DcYn= parent.parent.PkgDefHeader.document.getElementById('DcYn').value;
		var OpYn= parent.parent.PkgDefHeader.document.getElementById('OpYn').value;
		var EmYn= parent.parent.PkgDefHeader.document.getElementById('EmYn').value;
		var totrec = $('#totalRecords').val();
		var i=0; 
		
		if(!(IpYn == 'Y' || DcYn == 'Y')){
				for(i=0; i<totrec; i++){
					document.getElementById("includeHomeMedication"+i).disabled = true;
					document.getElementById("enableDisParam"+i).value = 'N';
				} 
		    }
}

function includeHomeMedicationMainYn(obj,mode) { //saraa
	if (mode == "modify") {
		if (obj.checked) {
			obj.checked = false;
		} else
			obj.checked = true;
	} else {
		if (obj.checked) {
			obj.value = "Y";
		} else {
			obj.value = "N";
		}
	}
}

//sarathkumar InclHmeMedi 
function checkInclHomeMedi(obj) {
	if (obj.checked) {
		obj.value = 'Y';
	} else {
		obj.value = 'N';
	}
}

//sarathkumar InclHmeMedi 
function IncludeHomeMedicationExclude(obj,code,type,indx){
	var siteSpecf = document.getElementById("siteSpecf").value;
	if(siteSpecf== 'true'){
	if (obj.checked) {
		document.getElementById("includeHomeMedication" + indx).disabled = true;
		document.getElementById("includeHomeMedication" + indx).checked = false;
		document.getElementById("includeHomeMedication" + indx).value = "N";
		document.getElementById("enableDisParam"+indx).value = 'N';
	} else {
		document.getElementById("includeHomeMedication" + indx).disabled = false;
		document.getElementById("enableDisParam"+indx).value = 'Y';
		IncludeHomeMedicationCheck(code, type, indx);
	}
}
}

//sarathkumar InclHmeMedi 
function IncludeHomeMedicationUnchkExclude(obj, called_from, indx){
	if(called_from == "rateexclude"){
		if(obj.checked){
			//document.getElementById("exludeService" + indx).disabled = true;
			document.getElementById("exludeService" + indx).checked = false;
			document.getElementById("exludeService" + indx).value = "N";
		}
		else{
			document.getElementById("exludeService" + indx).disabled = false;
		}
	}
	if(called_from == "chargeexclude"){
		if(obj.checked){
		//	document.getElementById("inEx_" + indx).disabled = true;
			document.getElementById("inEx_" + indx).checked = false;
			document.getElementById("inEx_" + indx).value = "N";
		}
		else{
			document.getElementById("inEx_" + indx).disabled = false;
		}
	}
	if(called_from == "custrateexclude"){
		if(obj.checked){
		//	document.getElementById("exludeService" + indx).disabled = true;
			document.getElementById("exludeService" + indx).checked = false;
			document.getElementById("exludeService" + indx).value = "N";
		}
		else{
			document.getElementById("exludeService" + indx).disabled = false;
		}
	}
	if(called_from == "custchargeexclude"){
		if(obj.checked){
		//	document.getElementById("inEx_" + indx).disabled = true;
			document.getElementById("inEx_" + indx).checked = false;
			document.getElementById("inEx_" + indx).value = "N";
		}
		else{
			document.getElementById("inEx_" + indx).disabled = false;
		}
	}	
}

function chkExludeServiceonload(){
	var formObj=document.srvLimit_rate_based_dtl;
	var	mode = formObj.mode.value;
	var totrec= document.forms[0].totalRecords.value;
	var i=0; 
	if(mode=='modify'){
				for(i=0; i<totrec; i++){
			if(document.getElementById("exludeService" + i).checked == true){
			eval("formObj.includeHomeMedication"+i).disabled=true;
		}else{
			eval("formObj.includeHomeMedication"+i).disabled=false;
		}
		}
	}
}

function chkChargeExludeServiceonload(){
	var formObj=document.frmPkgDefChargeBasedExcln;
	var	mode = formObj.mode.value;
	var totrec= document.forms[0].totalRecords.value;
	var i=0; 
	if(mode=='modify'){
				for(i=0; i<totrec; i++){
			if(document.getElementById("inEx_" + i).checked == true){
			eval("formObj.includeHomeMedication"+i).disabled=true;
		}else{
			eval("formObj.includeHomeMedication"+i).disabled=false;
		}
		}
	}
}

function child_pkgCode(code,desc,index){	
	if (desc == 'undefined' && desc == undefined && desc == null) {		
		desc.value="";
	}

	var formObj = parent.ass_child_pack_dtl.document.frmChildPackdtls;
	var headerFrmObj='';
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "Child Package";
	var locale = formObj.locale.value;
	var op_yn='';
	var ip_yn='';
	var em_yn='';
	var dc_yn='';
	var min_age_yrs='',min_age_mnths='',min_age_days='';
	var max_age_yrs='',max_age_mnths='',max_aga_days='';
	var applSexInd='',across_enc='',cash_credit='',order_catalog='',facility_id='',packageCode='';
	headerFrmObj =parent.parent.frames[0].document.forms[0];
	//mode = parent.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.mode.value;
	if (headerFrmObj != null && headerFrmObj != undefined) {
		min_age_yrs=headerFrmObj.minAgeInYrs.value;
		min_age_mnths=headerFrmObj.minAgeInMths.value;
		min_age_days=headerFrmObj.minAgeInDays.value;
		max_age_yrs=headerFrmObj.maxAgeInYrs.value;
		max_age_mnths=headerFrmObj.maxAgeInMths.value;
		max_aga_days=headerFrmObj.maxAgeInDays.value;
		op_yn=headerFrmObj.OpYn.value;
		ip_yn=headerFrmObj.IpYn.value;
		em_yn=headerFrmObj.EmYn.value;
		dc_yn=headerFrmObj.DcYn.value;
		applSexInd=headerFrmObj.applSexInd.value;
		across_enc=headerFrmObj.acrossEncounters.value;
		cash_credit=headerFrmObj.applicalbleTo.value;
		order_catalog=headerFrmObj.orderAssociated.value;
		facility_id=headerFrmObj.facilityId.value;
		packageCode=headerFrmObj.packageCode.value;		
	}
	var sql="SELECT package_code code,short_desc description  FROM bl_package a where nvl(IS_MASTER_PKG_YN,'N') = 'N' and package_code != '"+packageCode+"'  AND  BLPACKAGE.VALIDATE_MASTER_CHILD_PACKAGE('"+facility_id+"','"+op_yn+"','"+em_yn+"','"+ip_yn+"','"+dc_yn+"','"+min_age_yrs+"','"+min_age_mnths+"', '"+min_age_days+"','"+max_age_yrs+"','"+max_age_mnths+"','"+max_aga_days+"','"+applSexInd+"', '"+across_enc+"','"+order_catalog+"','"+cash_credit+"',package_code ) = 'Y' AND NOT EXISTS (SELECT 1 FROM bl_package_child_dtl b WHERE b.link_package_code = a.package_code AND b.operating_facility_id = a.operating_facility_id  AND NVL  (b.eff_to_date, TRUNC (SYSDATE)) >= TRUNC (SYSDATE)) AND UPPER (package_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?)";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;
	retArray = CommonLookup(title, argumentArray);
	
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {	
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {	
			eval("document.forms[0].childPackCode_"+index).value = retArray[0];
			eval("document.forms[0].childPackDesc_"+index).value = retArray[1];
		}
		else {
		eval("document.forms[0].childPackCode_"+index).value = "";
		eval("document.forms[0].childPackDesc_"+index).value = "";
	}
	} else {
		eval("document.forms[0].childPackCode_"+index).value = "";
		eval("document.forms[0].childPackDesc_"+index).value = "";
	}
}

function child_pkgCodeLookup(code,desc,index){	
	if (desc == 'undefined' && desc == undefined && desc == null) {		
		desc.value="";
	}

	var formObj = parent.ass_child_pack_dtl.document.frmChildPackdtls;
	var headerFrmObj='';
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "Child Package";
	var locale = formObj.locale.value;
	var op_yn='';
	var ip_yn='';
	var em_yn='';
	var dc_yn='';
	var min_age_yrs='',min_age_mnths='',min_age_days='';
	var max_age_yrs='',max_age_mnths='',max_aga_days='';
	var applSexInd='',across_enc='',cash_credit='',order_catalog='',facility_id='',packageCode='';
	headerFrmObj =parent.parent.frames[0].document.forms[0];
	//mode = parent.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.mode.value;
	if (headerFrmObj != null && headerFrmObj != undefined) {
		min_age_yrs=headerFrmObj.minAgeInYrs.value;
		min_age_mnths=headerFrmObj.minAgeInMths.value;
		min_age_days=headerFrmObj.minAgeInDays.value;
		max_age_yrs=headerFrmObj.maxAgeInYrs.value;
		max_age_mnths=headerFrmObj.maxAgeInMths.value;
		max_aga_days=headerFrmObj.maxAgeInDays.value;
		op_yn=headerFrmObj.OpYn.value;
		ip_yn=headerFrmObj.IpYn.value;
		em_yn=headerFrmObj.EmYn.value;
		dc_yn=headerFrmObj.DcYn.value;
		applSexInd=headerFrmObj.applSexInd.value;
		across_enc=headerFrmObj.acrossEncounters.value;
		cash_credit=headerFrmObj.applicalbleTo.value;
		order_catalog=headerFrmObj.orderAssociated.value;
		facility_id=headerFrmObj.facilityId.value;
		packageCode=headerFrmObj.packageCode.value;
	}
	var sql="SELECT package_code code,short_desc description  FROM bl_package a where nvl(IS_MASTER_PKG_YN,'N') = 'N' and package_code != '"+packageCode+"'  AND  BLPACKAGE.VALIDATE_MASTER_CHILD_PACKAGE('"+facility_id+"','"+op_yn+"','"+em_yn+"','"+ip_yn+"','"+dc_yn+"','"+min_age_yrs+"','"+min_age_mnths+"', '"+min_age_days+"','"+max_age_yrs+"','"+max_age_mnths+"','"+max_aga_days+"','"+applSexInd+"', '"+across_enc+"','"+order_catalog+"','"+cash_credit+"',package_code ) = 'Y' AND NOT EXISTS (SELECT 1 FROM bl_package_child_dtl b WHERE b.link_package_code = a.package_code AND b.operating_facility_id = a.operating_facility_id ) AND UPPER (package_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?)";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retArray = CommonLookup(title, argumentArray);
	
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {
			eval("document.forms[0].childPackCode_"+index).value = retArray[0];
			eval("document.forms[0].childPackDesc_"+index).value = retArray[1]; 
		}
		else {
		eval("document.forms[0].childPackCode_"+index).value = "";
		eval("document.forms[0].childPackDesc_"+index).value = "";		
	}
	} else {
		eval("document.forms[0].childPackCode_"+index).value = "";
		eval("document.forms[0].childPackDesc_"+index).value = "";		
	}	
}

function childPackdetails(obj, fromDateObj, toDate, index, from){
	var fromDate="";
	var ToDateObj="";
	var toDate="";

	if(from == "fromDate")
	{
		 fromDate = obj.value;		
	}
	else {
		fromDate = eval(fromDateObj).value;
	}
	 if(from == "toDate"){
		ToDateObj=obj.value;
		toDate=obj.value;	
	}

	var locale = document.forms[0].locale.value;
	var totRec = document.forms[0].totRec.value;
	var pakEffDate = parent.parent.PkgDefHeader.document.forms[0].effFromDate.value;
	var pakEffToDate = parent.parent.PkgDefHeader.document.forms[0].effToDate.value;
	var flag = false;
	if (obj.value != "") {		
		if (!(pakEffDate == null || pakEffDate == "" || fromDate == null || fromDate == "")) {				
		if (validDate(obj.value, 'DMY', locale)) {			
			var frmObj = "";				
			flag = true;				
			if (!(fromDate == null || fromDate == "" || toDate == null || toDate == "")) {
				if ((!isBefore(fromDate, toDate, 'DMY', locale))) {					
						alert(getMessage("BL4115", 'BL'));
						obj.value = "";
						obj.focus();
						flag = false;
					} else {
						// return false;
					}
				}
				
				if (flag && pakEffDate != "" && obj.value != ""
						&& (!(isAfter(obj.value, pakEffDate, 'DMY', locale)))) {
					//alert("Effective From Date Cannot Be Greater Than Package Effective From Date");
					alert(getMessage("BL0822", 'BL'));
					flag = false;
					obj.value = "";
					obj.focus();
				}
				pakEffDate = parent.parent.PkgDefHeader.document.forms[0].effToDate.value;
				// alert((!(isAfter(pakEffDate,obj.value,'DMY',locale))))
				if (flag && pakEffDate != "" && fromDate!= ""
						&& (! (isAfter(pakEffDate, fromDate, 'DMY', locale)))) {
				//	alert("Effective From Date Cannot Be Greater Than Package Effective To Date");
					alert(getMessage("BL0830", 'BL'));
					flag = false;
					obj.value = "";
					obj.focus();
				}
			
				if (flag && pakEffToDate != "" && toDate != ""
						&& (!(isAfter(pakEffToDate, toDate, 'DMY', locale)))) {
					
					alert(getMessage("BL8517", 'BL'));
					flag = false;
					obj.value = "";
					obj.focus();
				}
		  } else {
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value = "";
			obj.focus();
				flag = false
			return false;
		}
		}		
		else {
			if(from == "fromDate"){
			obj.value = "";
			if (pakEffDate == null || pakEffDate == "") {
				parent.parent.PkgDefHeader.document.forms[0].effFromDate
						.focus();
				alert(getMessage("BL8504", 'BL'))
			} else if (fromDate == null || fromDate == "") {
				eval(fromDateObj).focus();
				alert(getMessage("BL8643", 'BL'))
			}
			flag = false;
		}
		}
	}
	return flag;
}

//Added V190320-Aravindh/MMS-DM-CRF-0129
function dailyLmtChkBxClick(obj, selectedObjNum, formName) {
	var formObj=formName;
	if(obj.checked == true) {
		obj.value = "Y";
		eval("formObj.dailyLmtAmt"+selectedObjNum).disabled = false;
		eval("formObj.dailyLmtGrossNetList"+selectedObjNum).disabled = false;		
		eval("formObj.split_reqd" + selectedObjNum).disabled = false;
	} else {
		obj.value = "N";
		eval("formObj.dailyLmtAmt"+selectedObjNum).value = '';
		eval("formObj.dailyLmtGrossNetList"+selectedObjNum).value = 'G';		
		eval("formObj.dailyLmtAmt"+selectedObjNum).disabled = true;
		eval("formObj.dailyLmtGrossNetList"+selectedObjNum).disabled = true;
		
		if(eval("formObj.amt_limit_ind"+selectedObjNum) != undefined) {
			var amtLmtInd = eval("formObj.amt_limit_ind"+selectedObjNum).value;		
			if(amtLmtInd == "U") {
				eval("formObj.split_reqd" + selectedObjNum).disabled = true;
				eval("formObj.split_reqd" + selectedObjNum).checked = false;
				eval("formObj.split_reqd" + selectedObjNum).value = "N";
			}
		}
	}
}

//Added V190404-Dhananjay/MMS-DM-CRF-0129
function dailyLmtChkBxClickPharma(code, type, index){
	var service_code = code.value;
	var type = type.value;
	var reqId = "N";
	var order_associated = document.getElementById("order_associated").value;
	var policyParam = 'calledFrom=rate_based_dtl' +'&type=' +type+'&service_code=' + service_code;
	$.ajax({
	type:'GET',
	url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
    data: policyParam,
    dataType: "json",
    async: false,
	success : function(data){
	reqId=data.dailyLimitYN;
	}});
	 //Added V190405-Dhananjay/MMS-DM-CRF-0129
	if(reqId != 'R') { 
		if(reqId == 'N' || order_associated  == 'Y') {
			document.getElementById("dailyLmtChkBx"+index).disabled = true;
			document.getElementById("dailyLmtChkBx"+index).value = 'N';
			document.getElementById("dailyLmtChkBx"+index).checked=false; 
			document.getElementById("dailyLmtAmt"+index).disabled = true;
			document.getElementById("dailyLmtAmt"+index).value = "";
			document.getElementById("dailyLmtGrossNetList"+index).disabled = true;
			document.getElementById("dailyLmtGrossNetList"+index).value = "G";
		} else {
			document.getElementById("dailyLmtChkBx"+index).disabled = false;
			//document.getElementById("dailyLmtAmt"+index).disabled = false;
			//document.getElementById("dailyLmtGrossNetList"+index).disabled = false;
		}
	}
}

function dailyLmtIndicatorOnChange(obj, selectedObjNum, formName) {
	var formObj=formName;	
	if(obj.value != "*") {
		eval("formObj.split_reqd" + selectedObjNum).disabled = true;
		eval("formObj.split_reqd" + selectedObjNum).checked = true;
		eval("formObj.split_reqd" + selectedObjNum).value = "Y";
		eval("formObj.dailyLmtAmt"+selectedObjNum).readOnly = false;
		eval("formObj.dailyLmtAmt"+selectedObjNum).value = "";
		eval("formObj.dailyLmtQty"+selectedObjNum).readOnly = false;
		eval("formObj.dailyLmtQty"+selectedObjNum).value = "";
		var dailyLmtAmtFld = eval("formObj.dailyLmtAmt"+selectedObjNum).disabled;
		if(dailyLmtAmtFld != true) {
			eval("formObj.dailyLmtGrossNetList"+selectedObjNum).disabled = false;
			eval("formObj.dailyLmtGrossNetList"+selectedObjNum).value = "G";
		}
	} else {
		eval("formObj.dailyLmtAmt"+selectedObjNum).readOnly = true;
		eval("formObj.dailyLmtAmt"+selectedObjNum).value = "";
		eval("formObj.dailyLmtQty"+selectedObjNum).readOnly = true;
		eval("formObj.dailyLmtQty"+selectedObjNum).value = "";
		eval("formObj.dailyLmtGrossNetList"+selectedObjNum).disabled = true;
		eval("formObj.dailyLmtGrossNetList"+selectedObjNum).value = "G";
		
		if(eval("formObj.amt_limit_ind"+selectedObjNum) != undefined) {
			var amtLmtInd = eval("formObj.amt_limit_ind"+selectedObjNum).value;		
			if(amtLmtInd == "U") {
				eval("formObj.split_reqd" + selectedObjNum).disabled = true;
				eval("formObj.split_reqd" + selectedObjNum).checked = false;
				eval("formObj.split_reqd" + selectedObjNum).value = "N";
			}
		}
	}
}

//Added By Shikha For GHL-CRF-0520.1
function onSrvLimitServiceTypeChange_blngGrpcharge(obj, index) {
	eval("document.blng_grp_charge_based_dtl.cbCode_" + index).value = "";
	eval("document.blng_grp_charge_based_dtl.cbDesc_" + index).value = "";
	eval("document.blng_grp_charge_based_dtl.amt_limit_ind" + index).enable = true;
}

async function callReportBlngGrpBase(obj, index) {
	var P_PACKAGE_CODE = parent.parent.frames[0].document.forms[0].packageCode.value;
	var P_BLNG_CLASS = eval("parent.frames[1].document.forms[0].blgClsCode_"+ index).value;
	var P_EFF_FROM_DT = parent.frames[1].document.forms[0].fromDate.value;
	var p_facility_id = parent.parent.frames[0].document.forms[0].facilityId.value;
	var P_BLNG_GRP_CODE = parent.frames[1].document.forms[0].blng_grp_code.value;
	var dialogHeight = "11";
	var dialogWidth = "25";
	var arguments = "";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"+ dialogWidth + "; status:no";
	var url = "../../eBL/jsp/BLPkgDefBlngGrpBaseReport.jsp";
	url = url + "?&facilityId=" + p_facility_id + "&packageCode="
			+ P_PACKAGE_CODE + "&fromDate=" + P_EFF_FROM_DT + "&blgClsCode="
			+ P_BLNG_CLASS +  "&blng_grp_code=" + P_BLNG_GRP_CODE + "&p_report_id=BLPKGCUS";
	retVal =await window.showModalDialog(url, arguments, features);
}

function PkgBlngGrpBaseRun() {
	BLReportOptionsForm.submit();
	window.close();
}

function enableRuleCode_BlngGrp(obj,index){
	if (obj.checked) {
		obj.value="Y";
		document.getElementById("VATpercent"+index).removeAttribute('disabled');
		document.getElementById("VATpercent_temp"+index).removeAttribute('disabled');
		document.getElementById("ruleCoverageInd"+index).removeAttribute('disabled');
	}
	else{
		obj.value="N";
		document.getElementById("VATpercent"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent_temp"+index).setAttribute('disabled', 'disabled');
		document.getElementById("ruleCoverageInd"+index).setAttribute('disabled', 'disabled');
		document.getElementById("VATpercent"+index).value="";
		document.getElementById("ruleCoverageInd"+index).value="";	
	}	
}
//Ended By Shikha For GHL-CRF-0520.1

