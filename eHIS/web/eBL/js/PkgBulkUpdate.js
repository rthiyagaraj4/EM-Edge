/*
 *  Added by Rajesh V for MMS-CRF-0125
 *  Contains all script related functions for Package Price Revision Discount
 * */
/*
---------------------------------------------------------------------------------------------
SNo			Version			TFS ID			CRF/SCF     			Developer Name
---------------------------------------------------------------------------------------------
1           V210624         19511           MMS-DM-CRF-118.9        Nandhini M
2           V220811         34800           MMS-DM-SCF-0829         Manivel N
---------------------------------------------------------------------------------------------
*/

async function fnLookUp(){
	var lookup = parent.lookup.document;
	var priceType = $(lookup).find('#priceType').val();
	var pageId = $(lookup).find('#pageId').val();
	var dialogHeight= "34" ;
	var dialogWidth	= "84" ;
													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;	
	var pageSource = '';
	if(pageId == 'Price'){
		pageSource = '../../eBL/jsp/PkgPriceRevisionLookup.jsp?pageId=Discount&priceType='+priceType;
	}
	else if(pageId == 'Discount'){
		pageSource = '../../eBL/jsp/PkgDiscountRevisionLookup.jsp?pageId=Price&priceType='+priceType;
	}
	var retVal =await window.showModalDialog(pageSource,arguments,features);
}

/*Header Functions*/
function create()
{	
	BulkUpdateFrame.location.href="../../eBL/jsp/PkgBulkUpdMainFrame.jsp"; 
}


function reset() {
	//PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert";
	BulkUpdateFrame.location.reload();
}


function onSuccess()
{
	BulkUpdateFrame.location.href="../../eBL/jsp/PkgBulkUpdMainFrame.jsp";
}
//Added against V210624 starts
function priceTypeCall(rowValue)
{	
	document.getElementById('RuleCoverage'+rowValue).disabled=true;
	document.getElementById('VATpercent'+rowValue).disabled=true;
	document.getElementById('VATpercent_temp'+rowValue).disabled=true;
}

function PkgPriceInd(rowVal)
{
	var pkgPrice=document.getElementById("pkgPrice"+rowVal);
	if(pkgPrice.value=='R'){
		document.getElementById('pkgCode'+rowVal).disabled=true;
		document.getElementById('pkgDesc'+rowVal).disabled=true;
		document.getElementById('blngClass'+rowVal).disabled=true;
		document.getElementById('blngClassBtn'+rowVal).disabled=true;
		document.getElementById('currentPrice'+rowVal).disabled=true;
		document.getElementById('revisedPrice'+rowVal).disabled=true;
		document.getElementById('revisedType'+rowVal).disabled=true;
		}
	else{
		document.getElementById('pkgCode'+rowVal).disabled=false;
		document.getElementById('pkgDesc'+rowVal).disabled=false;
		document.getElementById('blngClass'+rowVal).disabled=false;
		document.getElementById('blngClassBtn'+rowVal).disabled=false;
		document.getElementById('currentPrice'+rowVal).disabled=false;
		document.getElementById('revisedPrice'+rowVal).disabled=false;
		document.getElementById('revisedType'+rowVal).disabled=false;	
	}
}

function VatOptionInd(rowVal)
{
	var VAT=document.getElementById("VAT"+rowVal);
	if(VAT.value=='N'){
		document.getElementById('VATapp'+rowVal).checked=false; //added by Nandhini against 21280 starts
		document.getElementById('VATpercent'+rowVal).value="";
		document.getElementById('VATpercent_temp'+rowVal).value="";	
		document.getElementById('RuleCoverage'+rowVal).value="";			
		document.getElementById('VATapp'+rowVal).disabled=true;
		document.getElementById('VATpercent'+rowVal).disabled=true;
		document.getElementById('VATpercent_temp'+rowVal).disabled=true;
		document.getElementById('RuleCoverage'+rowVal).disabled=true;//added by Nandhini against 21280 ends	
		
	}
	else{
		document.getElementById('VATapp'+rowVal).disabled=false;
		/*document.getElementById('VATpercent'+rowVal).disabled=false;
		document.getElementById('VATpercent_temp'+rowVal).disabled=false;
		document.getElementById('RuleCoverage'+rowVal).disabled=false;*/ //commented against 21058
	}
}

function PkgPriceVal(rowValue)
{	
	var pkgPrice=document.getElementById("pkgPrice"+rowValue);
	if(pkgPrice.value=='R'){
		document.getElementById('pkgPriceType'+rowValue).disabled=true;
		document.getElementById('pkgPriceOrAmt'+rowValue).disabled=true;
		document.getElementById('priceMarkUpDown'+rowValue).disabled=true;
		document.getElementById('priceRoundOff'+rowValue).disabled=true;
		document.getElementById('priceRndMarkUpDown'+rowValue).disabled=true;
	}
	else{
		document.getElementById('pkgPriceType'+rowValue).disabled=false;
		document.getElementById('pkgPriceOrAmt'+rowValue).disabled=false;
		document.getElementById('priceMarkUpDown'+rowValue).disabled=false;
		document.getElementById('priceRoundOff'+rowValue).disabled=false;
		document.getElementById('priceRndMarkUpDown'+rowValue).disabled=false;
	}	
	
}
//Added by Nandhini against V210624 starts
function VatCheckBox(rowValue)
{
	var VAT=document.getElementById("VAT"+rowValue);
	var priceType = $('#priceType').val();	
	if((VAT.value=='E') && (document.getElementById('VATapp'+rowValue).checked==true || document.getElementById('VATapp'+rowValue).checked=='true')&& (priceType == 'S')){
	//document.getElementById('RuleCoverage'+rowValue).disabled=false; //commented against 21436
	document.getElementById('VATpercent_temp'+rowValue).disabled=false;
	document.getElementById('VATpercent'+rowValue).disabled=false;
	}
	//added against 21436
	else if((VAT.value=='E') && (document.getElementById('VATapp'+rowValue).checked==true || document.getElementById('VATapp'+rowValue).checked=='true')&& (priceType == 'C')){
	document.getElementById('RuleCoverage'+rowValue).disabled=false; 
	document.getElementById('VATpercent_temp'+rowValue).disabled=false;
	document.getElementById('VATpercent'+rowValue).disabled=false;
	}
	else{
		document.getElementById('RuleCoverage'+rowValue).disabled=true;
		document.getElementById('VATpercent_temp'+rowValue).disabled=true;
		document.getElementById('VATpercent'+rowValue).disabled=true;
	}
}
function VatBoxInd(rowVal)
{
	var VAT=document.getElementById("VAT"+rowVal);
	var priceType = $('#priceType').val();	
	if((VAT.value=='E') && (document.getElementById('VATapp'+rowVal).checked==true || document.getElementById('VATapp'+rowVal).checked=='true')&& (priceType == 'S')){
	//document.getElementById('RuleCoverage'+rowVal).disabled=false;
	document.getElementById('VATpercent_temp'+rowVal).disabled=false;
	document.getElementById('VATpercent'+rowVal).disabled=false;
	}
	//added against 21436
	else if((VAT.value=='E') && (document.getElementById('VATapp'+rowVal).checked==true || document.getElementById('VATapp'+rowVal).checked=='true')&& (priceType == 'C')){
	document.getElementById('RuleCoverage'+rowVal).disabled=false; 
	document.getElementById('VATpercent_temp'+rowVal).disabled=false;
	document.getElementById('VATpercent'+rowVal).disabled=false;
	}
	/*else{
		document.getElementById('RuleCoverage'+rowVal).disabled=true;
		document.getElementById('VATpercent_temp'+rowVal).disabled=true;
		document.getElementById('VATpercent'+rowVal).disabled=true;
	}*/
	else if(VAT.value=='N'){
		document.getElementById('VATapp'+rowVal).value="";//added by Nandhini against 21280 starts
		document.getElementById('VATpercent'+rowVal).value="";
		document.getElementById('VATpercent_temp'+rowVal).value="";	
		document.getElementById('RuleCoverage'+rowVal).value="";
		document.getElementById('VATapp'+rowVal).disabled=true;
		document.getElementById('VATpercent_temp'+rowVal).disabled=true;
		document.getElementById('VATpercent'+rowVal).disabled=true;
		document.getElementById('RuleCoverage'+rowVal).disabled=true;	//added by Nandhini against 21280 ends
	}
	else{
		document.getElementById('RuleCoverage'+rowVal).disabled=true;
		document.getElementById('VATpercent_temp'+rowVal).disabled=true;
		document.getElementById('VATpercent'+rowVal).disabled=true;
	}
}
//Added by Nandhini against V210624 ends.
function VatOption(rowValue)
{
	var VAT=document.getElementById("VAT"+rowValue);
	if(VAT.value=='N'){
		document.getElementById('VATapp'+rowValue).value="";//added by Nandhini against 21280 starts
		document.getElementById('VATpercent'+rowValue).value="";
		document.getElementById('VATpercent_temp'+rowValue).value="";	
		document.getElementById('RuleCoverage'+rowValue).value="";
		document.getElementById('VATapp'+rowValue).disabled=true;
		document.getElementById('VATpercent_temp'+rowValue).disabled=true;
		document.getElementById('VATpercent'+rowValue).disabled=true;
		document.getElementById('RuleCoverage'+rowValue).disabled=true;	//added by Nandhini against 21280 ends
	}	
	else{
		document.getElementById('VATapp'+rowValue).disabled=false;
		
	}
}

async function ruleCodeLookup(obj,index){
	var formObj = document.forms[0];
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "VAT Rule"; //added against 21436
	var locale = formObj.locale.value;
	var facility_id = formObj.facilityId.value;

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
	retArray = await CommonLookup(title, argumentArray);
	var ret1=unescape(retArray);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {	
	
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {	
		//alert("retArray[0]"+retArray[0]);
		//Modified against Incident No - ATE-BL-MMS-73588 for VAT Effective Date Validation  By Ram kumar S
	/*		var fromDate=eval("formObj.fromDate_" + index).value;
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
			*/
			eval("document.forms[0].VATpercent" + index).value = arr[0]; 
		}
		else {	
		eval("document.forms[0].VATpercent" + index).value = ""; 		
	}
	} else {
		eval("document.forms[0].VATpercent" + index).value = "";		
	}
}
//Added against V210624 ends

async function apply(){
	var mainfrmObj = BulkUpdateFrame.search.searchFrm;
	var login_user = mainfrmObj.login_user.value;
	var priceType  = getLabel("eBL.StdCustPrice.label","bl");
	var updateType  = getLabel("eBL.BulkUpdPkgPrice.label","bl");
	var packageCode  = getLabel("eBL.PackageCode.Label","bl");
	var fieldsTop  = new Array (mainfrmObj.priceType,mainfrmObj.updateType,mainfrmObj.pkgCode);
	var namesTop = new Array ( priceType,updateType,packageCode);
	if(checkFieldsofMst( fieldsTop, namesTop, messageFrame)) {
		var lookupData = BulkUpdateFrame.lookUpData.document.forms[0];		
		var pageId = lookupData.pageId.value;
		var BulkUpdateYN = '';
		if(pageId == 'Bulk'){
			BulkUpdateYN = 'Y';
			var trLength = '';
			var dtlDoc = BulkUpdateFrame.bulkUpdate.document;
			var dtlFrm = dtlDoc.forms[0];
			var tbl = dtlDoc.getElementById('bulkUpdateTbl');
			var index = tbl.rows.length-1;
			
			var lastRow = tbl.rows[index].rowValue;
			if(isNaN(lastRow)){
				trLength = '1';
			}
			else{
				trLength = lastRow;						
			}
			dtlFrm.lastRowIndex.value = trLength;	
			
		//	var chkval = bulkUpdMandCheck();
			for(var i = 1; i<=trLength;i++){
				if(dtlDoc.getElementById('pkgPriceType'+i) != null){ //V220811 added the missing code for validation
					if(dtlDoc.getElementById('pkgPriceType'+i).value == '' && dtlDoc.getElementById('pkgPriceOrAmt'+i).value == '' && dtlDoc.getElementById('effFrom'+i).value == '' ){
						
					}
					else
					{
						//Added against V210624 starts bulk
						if(dtlDoc.getElementById('pkgPrice'+i).value == ''){
							alert('Package Price is mandatory');
							dtlDoc.getElementById('pkgPrice'+i).focus();
							commontoolbarFrame.location.reload();
							return false;					
						}
						else if(dtlDoc.getElementById('VAT'+i).value == ''){
							alert('VAT is mandatory');
							dtlDoc.getElementById('VAT'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
						else if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E' && dtlDoc.getElementById('pkgPriceType'+i).value == '' ){
							alert('Package Price Type is mandatory');
							dtlDoc.getElementById('pkgPriceType'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}				
						else if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E'&& dtlDoc.getElementById('pkgPriceOrAmt'+i).value == '' ){
							alert('Percentage / Amt is mandatory');
							dtlDoc.getElementById('pkgPriceOrAmt'+i).select();	
							commontoolbarFrame.location.reload();
							return false;
						}
						else if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E'&& dtlDoc.getElementById('priceMarkUpDown'+i).value == '' ){
							alert('Mark Up / Down is mandatory');
							dtlDoc.getElementById('priceMarkUpDown'+i).focus();	
							commontoolbarFrame.location.reload();
							return false;
						}
						else if(dtlDoc.getElementById('effFrom'+i).value == '' ){
							alert('Effective From is mandatory');
							dtlDoc.getElementById('effFrom'+i).select();
							commontoolbarFrame.location.reload();
							return false;
						}
						else if(dtlDoc.getElementById('priceRoundOff'+i).value.length > 0 && dtlDoc.getElementById('priceRndMarkUpDown'+i).value == ''){
							alert('Please Enter Rounding Indicatory');
							dtlDoc.getElementById('priceRndMarkUpDown'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}	
						var priceTypeind=mainfrmObj.priceType.value;
						if((dtlDoc.getElementById('VATapp'+i).checked==true || dtlDoc.getElementById('VATapp'+i).checked=='true') && dtlDoc.getElementById('VAT'+i).value == 'E' &&  dtlDoc.getElementById('VATpercent'+i).value == ''){
							alert('VAT Rule is mandatory');
							dtlDoc.getElementById('VATpercent'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
						else if((dtlDoc.getElementById('VAT'+i).value == 'E') && (priceTypeind == 'C') && (dtlDoc.getElementById('RuleCoverage'+i).value == '')){
							alert('RuleCoverage is mandatory');
							//dtlDoc.getElementById('RuleCoverage'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						} //commented against 21436			
						//Added against V210624 ends	
					}						
				}				
			}			
			getXMLString('PriceBulk');			
			dtlDoc = BulkUpdateFrame.lookUpData.document;
			dtlFrm = dtlDoc.forms[0];
			tbl = dtlDoc.getElementById('bulkUpdateTbl');
			index = tbl.rows.length-1;
			lastRow = tbl.rows[index].rowValue;
			if(isNaN(lastRow)){
				trLength = '1';
			}
			else{
				trLength = lastRow;						
			}
			dtlFrm.lastRowIndex.value = trLength;		
			
			for(var i = 1; i<=trLength;i++){
				if(dtlDoc.getElementById('pkgDiscType'+i) != null){
					if(dtlDoc.getElementById('pkgDiscType'+i).value == '' && dtlDoc.getElementById('discPriceOrAmt'+i).value == '' && dtlDoc.getElementById('effFrom'+i).value == '' ){
						
					}
					else{
						if(dtlDoc.getElementById('pkgDiscType'+i).value == '' ){
							alert('Package Price Type is mandatory');
							dtlDoc.getElementById('pkgDiscType'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
						if(dtlDoc.getElementById('discPriceOrAmt'+i).value == '' ){
							alert('Percentage / Amt is mandatory');
							dtlDoc.getElementById('discPriceOrAmt'+i).select();	
							commontoolbarFrame.location.reload();
							return false;
						}
						/*if(dtlDoc.getElementById('discMarkUpDown'+i).value == 'N' ){
							alert('Mark Up / Down is mandatory');
							dtlDoc.getElementById('discMarkUpDown'+i).focus();	
							commontoolbarFrame.location.reload();
							return false;
						}*/
						if(dtlDoc.getElementById('effFrom'+i).value == '' ){
							alert('Effective From is mandatory');
							dtlDoc.getElementById('effFrom'+i).select();
							commontoolbarFrame.location.reload();
							return false;
						}
						if(dtlDoc.getElementById('discRoundOff'+i).value.length > 0 && dtlDoc.getElementById('discRndMarkUpDown'+i).value == 'N'){
							alert('Please enter Rounding Indicatory');
							dtlDoc.getElementById('discRndMarkUpDown'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
					}
					
				}
			}
			
			getXMLString('DiscountBulk');
				
			getXMLString('Header');
		}
		else if(pageId == 'Price'){
			BulkUpdateYN = 'N';
			var trLength = '';
			var srchType = mainfrmObj.srchType.value;
			var dtlDoc = BulkUpdateFrame.lookup.document;
			var dtlFrm = dtlDoc.forms[0];
			var tbl = dtlDoc.getElementById('priceRevisionTbl');
			var index = tbl.rows.length-1;
			
			var lastRow = tbl.rows[index].rowValue;
			//alert(lastRow)
			if(isNaN(lastRow)){
				trLength = '1';
			}
			else{
				trLength = lastRow;						
			}
			/*Validation of Form before Apply*/
			for(var i=1;i<=trLength;i++){
				if(dtlDoc.getElementById('pkgCode'+i) != null && dtlDoc.getElementById('pkgCode'+i).value != ''){
					
					if(srchType == 'C'){
						if(dtlDoc.getElementById('custGrp'+i).value == ''){
							alert('Customer Group is a mandatory field');
							dtlDoc.getElementById('custGrp'+i).select();
							commontoolbarFrame.location.reload();
							return false;
						}
						if(dtlDoc.getElementById('cust'+i).value == ''){
							alert('Customer is a mandatory field');
							dtlDoc.getElementById('cust'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
					}
					//Added against V210624 starts ind
					if(dtlDoc.getElementById('pkgPrice'+i).value == ''){
						alert('package price is a mandatory field');
						dtlDoc.getElementById('pkgPrice'+i).focus();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('VAT'+i).value == ''){
							alert('VAT is mandatory');
							dtlDoc.getElementById('VAT'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
					}
					//Added against V210624 ends
					if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E'&& dtlDoc.getElementById('blngClass'+i).value == ''){
						alert('Billing Class is a mandatory field');
						dtlDoc.getElementById('blngClass'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E'&& dtlDoc.getElementById('revisedPrice'+i).value == ''){
						alert('Revised Price is a mandatory field');
						dtlDoc.getElementById('revisedPrice'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('pkgPrice'+i).value == 'I' && dtlDoc.getElementById('VAT'+i).value == 'E'&& dtlDoc.getElementById('revisedType'+i).value == ''){
						alert('Revised Type is a mandatory field');
						dtlDoc.getElementById('revisedType'+i).focus();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('effFrom'+i).value == ''){
						alert('Effective From is a mandatory field');
						dtlDoc.getElementById('effFrom'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
					//Added against V210624 starts ind
					var priceType=mainfrmObj.priceType.value;
										
				if((dtlDoc.getElementById('VATapp'+i).checked==true || dtlDoc.getElementById('VATapp'+i).checked=='true') && dtlDoc.getElementById('VAT'+i).value == 'E' &&  dtlDoc.getElementById('VATpercent'+i).value == ''){
						alert('VAT Rule is mandatory');
						dtlDoc.getElementById('VATpercent'+i).focus();
						commontoolbarFrame.location.reload();
						return false;
					}
				else if((dtlDoc.getElementById('VAT'+i).value == 'E') && (priceType == 'C') && dtlDoc.getElementById('RuleCoverage'+i).value == ''){
						alert('RuleCoverage is mandatory');
						//dtlDoc.getElementById('RuleCoverage'+i).focus();
						commontoolbarFrame.location.reload();
						return false;
					}
					//Added against V210624 ends ind
				}
				
			}
			dtlFrm.lastRowIndex.value = trLength;		
			getXMLString('PriceMain');
		}
		else if(pageId == 'Discount'){
			BulkUpdateYN = 'N';
			var trLength = '';
			var srchType = mainfrmObj.srchType.value;
			var dtlDoc = BulkUpdateFrame.lookup.document;
			var dtlFrm = dtlDoc.forms[0];
			var tbl = dtlDoc.getElementById('priceRevisionTbl');
			var index = tbl.rows.length-1;
			
			var lastRow = tbl.rows[index].rowValue;
			//alert(lastRow)
			if(isNaN(lastRow)){
				trLength = '1';
			}
			else{
				trLength = lastRow;						
			}
			/*Validation of Form before Apply*/
			for(var i=1;i<=trLength;i++){
				if(dtlDoc.getElementById('pkgCode'+i) != null && dtlDoc.getElementById('pkgCode'+i).value != ''){
					
					if(srchType == 'C'){
						if(dtlDoc.getElementById('custGrp'+i).value == ''){
							alert('Customer Group is a mandatory field');
							dtlDoc.getElementById('custGrp'+i).select();
							commontoolbarFrame.location.reload();
							return false;
						}
						if(dtlDoc.getElementById('cust'+i).value == ''){
							alert('Customer is a mandatory field');
							dtlDoc.getElementById('cust'+i).focus();
							commontoolbarFrame.location.reload();
							return false;
						}
					}
					else{
						if(dtlDoc.getElementById('blngGroup'+i).value == ''){
							alert('Billing Group is a mandatory field');
							dtlDoc.getElementById('blngGroup'+i).select();
							commontoolbarFrame.location.reload();
							return false;
						}
					}
					
					if(dtlDoc.getElementById('blngClass'+i).value == ''){
						alert('Billing Class is a mandatory field');
						dtlDoc.getElementById('blngClass'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('revisedValue'+i).value == ''){
						alert('Revised Price is a mandatory field');
						dtlDoc.getElementById('revisedValue'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('revisedType'+i).value == ''){
						alert('Revised Type is a mandatory field');
						dtlDoc.getElementById('revisedType'+i).focus();
						commontoolbarFrame.location.reload();
						return false;
					}
					if(dtlDoc.getElementById('effFrom'+i).value == ''){
						alert('Effective From is a mandatory field');
						dtlDoc.getElementById('effFrom'+i).select();
						commontoolbarFrame.location.reload();
						return false;
					}
				}
				
			}
			dtlFrm.lastRowIndex.value = trLength;		
			getXMLString('DiscountMain');			
		}
		
		var retVal = checkAuthorize(pageId,login_user);
		//alert('retVal for Privilege->'+retVal);
		
		if(retVal == 'false'){
			commontoolbarFrame.location.reload();
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=User Authentication Failed&err_value=2';
			return false;
		}
		else if(retVal == 'nochanges'){
			commontoolbarFrame.location.reload();
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=No Changes made&err_value=2';
			return false;
		}
		//Ajax Call to Insert
		$.ajax({
			type:"POST",
			url:"../../servlet/eBL.PkgBulkUpdateServlet",
			data:"insertUpd=I&bulkUpdate="+BulkUpdateYN,
			dataType:"json",
			async:true,
			success: function(data){
				if(data.status == 'Y'){
					if(data.rowsInserted<1){
						commontoolbarFrame.location.reload();
						messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=Nothing to Save&err_value=2';
						return;
					}
					else{
						if(data.count>0){
							var dialogHeight = "34" ;
							var dialogWidth	= "84" ;
																			   
							var status="no";
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
							var arguments	= "" ;	
							var pageSource = '../../eBL/jsp/BLPkgOverLapRecords.jsp?session_id='+data.session_id+
											'&pgm_date='+data.pgm_date;					
							var retVal = window.showModalDialog(pageSource,arguments,features);
							if(retVal == 'Y'){
								populateUpdReq(data);
							}
							else{
								//alert('Message to be shown');
								commontoolbarFrame.location.reload();
								messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=Job has not Submitted&err_value=2';
								return;
							}
						}
						else{
							populateUpdReq(data);
						}
					}					
				}
				else{
					//alert(data.error)
					commontoolbarFrame.location.reload();
					messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+data.error+'&err_value=2';
					return;
				}
				
			},
			 error: function(data){

		      }
		});
		//Ajax Call to Insert
	}
}


//start-added for MMS CRF 125- pradeepa 

async function userPrivilegeCheck(login_user,price_mod,disc_mod){
//alert('In userPrivilegeCheck>>'+login_user+','+price_mod+"/"+disc_mod);
var userPriv="false";
var update_pkg="";
if(price_mod=="Y" && disc_mod=="N"){	
	update_pkg="PKG_PRIC_BULK_UPDATE";	
}

if(price_mod=="N" && disc_mod=="Y"){
	update_pkg="PKG_DISC_BULK_UPDATE";	
}
else if(price_mod=="Y" && disc_mod=="Y"){
	var authPrice=doUserAuthenticationValidation(login_user,"PKG_PRIC_BULK_UPDATE");
	//alert("authPrice>>"+authPrice);
	var authDisc=doUserAuthenticationValidation(login_user,"PKG_DISC_BULK_UPDATE");
	//alert("authDisc>>"+authDisc);
	if(authPrice==true && authDisc==true){
		userPriv="true";
	}
	else{
		var dialogHeight= "14" ;
		var dialogWidth	= "22" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;			

		var retVal =await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp",arguments,features);		

		
	var doAuth=true;
if(retVal==null || retVal[3] == undefined){
	doAuth=false;
}
else{	
	var successfulUser=retVal[3];
}		
		
if(doAuth){	
		if(doUserAuthenticationValidation(successfulUser,"PKG_PRIC_BULK_UPDATE")==true && doUserAuthenticationValidation(successfulUser,"PKG_DISC_BULK_UPDATE")==true){
			
			var authPrice=true;
			var authDisc=true;
			
		}else{
			alert("User "+successfulUser+" dont have permissions to update Package Price/Discount details");
			var authPrice=false;
			var authDisc=false;
		}	
}	

	
	}

	if(authPrice==false || authDisc==false){		
		 userPriv="false";
	}
	else{		
		userPriv="true";
	}
	
}


if((price_mod=="Y" && disc_mod=="N")||(price_mod=="N" && disc_mod=="Y")){
if(doUserAuthenticationValidation(login_user,update_pkg)==true)
{
//alert("doUserAuthenticationValidation 1");
userPriv="true";

}else{

var dialogHeight= "14" ;
var dialogWidth	= "22" ;
var dialogTop = "225" ;
var center = "1" ;														   
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;			

var retVal =await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp",arguments,features);

var doAuth=true;
if(retVal==null || retVal[3] == undefined){
	doAuth=false;
}
else{	
	var successfulUser=retVal[3];
}		
		
if(doAuth){

if(doUserAuthenticationValidation(successfulUser,update_pkg)==true){
	userPriv="true";
}else{
	if(update_pkg=="PKG_DISC_BULK_UPDATE"){
		alert("User "+successfulUser+" dont have permissions to update Package Discount details");
	}
	else if(update_pkg=="PKG_PRIC_BULK_UPDATE"){
		alert("User "+successfulUser+" dont have permissions to update Package Price details");
	}
	
	userPriv="false";
}
}

}

}
//alert("before returning>>>>"+userPriv);

return userPriv;
}


function doUserAuthenticationValidation(successfulUser,update_pkg) {
//	alert("doUserAuthenticationValidation main");
//	alert("successfulUser"+successfulUser);
//	alert("update_pkg"+update_pkg);
	
	$.ajax({
		type:"POST",
		url:"../jsp/UserAuthenticationPayerPolicyValidation.jsp",
		data:"successfulUser="+successfulUser+"&calledFromPage="+update_pkg,
		dataType:"text",
		async:false,
		success: function(data){
			//alert(data)
			retVal = $.trim(data);
		},
		 error: function(data){
			 alert(data)
	     }
	});
	
	//alert("retVal$$$$ "+retVal);
	if(retVal.indexOf('@@@SUCCESS@@@')==-1){ //If success string is not found return false
		return false;
	}else{		
		return true;	
	}
	
//	var frmObj=document.forms[0];

//	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage="+update_pkg;
//	if(successfulUser!=null){		
//		temp_jsp+="&successfulUser="+successfulUser;
//	}
//	var xmlString=formXMLStringMain(frmObj);
//	alert("xmlString"+xmlString);
//	var updation=formUserValidation(xmlString,temp_jsp);	
//	return updation;
}


//end- added for MMS CRF 125- Pradeepa 

function populateUpdReq(data){
	//alert('here')
	var mainfrmObj = BulkUpdateFrame.search.searchFrm;
	mainfrmObj.target='messageFrame';
	mainfrmObj.method="post";
	mainfrmObj.action="../../servlet/eBL.PkgBulkUpdateServlet?insertUpd=U"+
						"&session_id="+data.session_id+
						"&pgm_date="+data.pgm_date;
	//alert('submit');
	mainfrmObj.submit();	
}

/*Header Functions*/

/*Authorization Functions*/
function checkAuthorize(pageId,login_user){
	var retVal = '';
	$.ajax({
		type:"POST",
		url:"../jsp/PkgPriceRevisionPersistence.jsp",
		data:"func_mode=getPriceDiscMod&pageId="+pageId,
		dataType:"text",
		async:false,
		success: function(data){
			//alert(data)
			retVal = $.trim(data);
		},
		 error: function(data){
			 alert(data)
	     }
	});
	
	var retValArr = retVal.split(':::');
	var status = '';
	if(retValArr[0] == 'N' && retValArr[1]=='N'){
		status = 'nochanges';
	}
	else{
		status = userPrivilegeCheck(login_user,retValArr[0],retValArr[1]);
	}

	/*$.ajax({
		type:"POST",
		url:"../jsp/PkgBulkUpdateAjax.jsp",
		data:"func_mode=chkPkgUpdAccess",
		dataType:"text",
		async:false,
		success: function(data){
			//alert(data)
			retVal = $.trim(data);
		},
		 error: function(data){
			 alert(data)
	     }
	});
	//alert(retVal)
	if(retVal != 'Y'){
		alert("User dont have Permission to update");
		var dialogHeight= "14" ;
		var dialogWidth	= "22" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;			
		
		var retValArr = window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?called_frm=PKG_BULK_UPD_ACCESS",arguments,features);
		//alert(retValArr)
		if(retValArr != undefined && retValArr.length>0 && retValArr[0]=="Y"){
			retVal = retValArr[0];
		}
	}*/
	
	//alert(retVal);
	return status;
}
/*Authorization Functions*/

/*Table Addition & Removal Functions*/
function fnRemove(){
	var lookup = parent.lookup.document;
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');

	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '0';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
	}
	for(var i=1;i<=rowVal;i++){
		if($(lookup).find('#removeChk'+i).prop('checked')){
			$(lookup).find('#tr'+i).remove();
		}
	}
	
	lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	//alert($(lastRow).attr('rowValue'))
	if(!isNaN($(lastRow).attr('rowValue'))){
		//alert('Executing')
		var trCnt = 0;
		$(lookup).find('#priceRevisionTbl tr').each(function(){
			//alert('l')
			if(!isNaN($(this).attr('rowValue'))){
				
				trCnt++;
				//alert(trCnt)
				var val = $(this).attr('rowValue');
				$(lookup).find('#tdSn'+val).text(trCnt);
			}
		});
	}
}

function fnBulkRemove(){
	//var lookup = parent.lookup.document;
	var lastRow = $('#bulkUpdateTbl tr:last');

	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '0';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
	}
	//alert(rowVal)
	for(var i=1;i<=rowVal;i++){
		if($('#bulkRemove'+i).prop('checked')){
			$('#tr'+i).remove();
		}
	}
}

function moveData(pageId,rowId){
	var lookup = parent.lookup.document;
	var pageId = $(lookup).find('#pageId').val();
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	var priceType = $(lookup).find('#priceType').val();
	var rowCount;
	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal;
	var today = getToday();
	var locale = 'en';
	if(pageId == 'Price'){
		rowCount = $(lookup).find('#priceRevisionTbl tr').length;
		var pkgCode = $.trim( $('#pkgCode'+rowId).text());
		var pkgDesc = $.trim( $('#pkgDesc'+rowId).val());
		var custGroup = $.trim( $('#hideCustGrp'+rowId).text());
		var cust = $.trim( $('#hideCust'+rowId).text());
		var blngClass = $.trim( $('#blngClassCode'+rowId).text());
		var currentPrice = $.trim( $('#currPrice'+rowId).text());
		var currentType = $.trim( $('#currentType'+rowId).text());
		var effectiveFrom = $.trim( $('#effFrom'+rowId).text());
		var effectiveTo = $.trim( $('#effTo'+rowId).text());
		if(currentType == 'F'){
			alert('Factor cannot be changed from this screen');
			return false;
		}
		var status = checkForDuplicate(pageId,pkgCode,'',blngClass,custGroup,cust,effectiveFrom);
		if(!status){
			alert('Record already added');
			return false;
		}
		//Commented as there is not need to check back date
		/*if(today!="" && ((isBeforeNow(effectiveFrom,'DMY',locale))))
		{
			effectiveFrom = '';	
		}*/
		trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
						"<td class='label' nowrap id='tdSn"+rowVal+"'> "+
							rowCount+
						"</td> "+
						//Added against V210624 starts
						"<td class='fields' nowrap> "+
						"<select name='pkgPrice"+rowVal+"' id='pkgPrice"+rowVal+"' onchange='PkgPriceInd("+rowVal+")'>"+
							"<option value=''>Select</option> "+
							"<option value='R'>Retain package Price</option> "+
							"<option value='I'>Revise package Price</option> "+				
						"</select> "+
						"</td> "+
						"<td class='fields' nowrap > "+
						"<select name='VAT"+rowVal+"' id='VAT"+rowVal+"' onchange='VatOptionInd("+rowVal+")'>"+
							"<option value=''>Select</option> "+
							"<option value='N'>Retain VAT</option> "+
							"<option value='E'>Revise VAT</option> "+						
						"</select> "+
						"</td> "+
						//Added against V210624 ends
						"<td class='fields' nowrap> "+
							"<input type='text' size='10' readonly name='pkgCode"+rowVal+"' id='pkgCode"+rowVal+"' value='"+pkgCode+"' >"+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<input type='text' size='15' readonly name='pkgDesc"+rowVal+"' id='pkgDesc"+rowVal+"' value='"+pkgDesc+"' > "+
							"&nbsp; <input type='button' disabled class='button' id='pkgLkpBtn"+rowVal+"' name='pkgLkpBtn"+rowVal+"' value='?' > "+
							"&nbsp;<span class='LABEL' style='font-weight: normal; color: blue; cursor: pointer;' onclick='showDiscount("+rowVal+")'>Discount</span> "+
						"</td> ";
						
						if(priceType == 'S'){
							trVal = trVal + "<td class='fields' nowrap style='display:none;' id='hideCustGrpTd"+rowVal+"'> "+
								"<input type='text' size='10' readonly name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='"+custGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
								"&nbsp; <input type='button' disabled class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
							"</td> "+
							"<td class='fields' nowrap style='display:none;' id='hideCustTd"+rowVal+"'> "+
								"<input type='text' size='10' readonly name='cust"+rowVal+"' id='cust"+rowVal+"' value='"+cust+"'  onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
								"&nbsp; <input type='button' disabled class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
							"</td> ";
						}
						else if(priceType == 'C'){
							trVal = trVal + "<td class='fields' nowrap> "+
								"<input type='text' size='10' readonly name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='"+custGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
								"&nbsp; <input type='button' disabled class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
							"</td> "+
							"<td class='fields' nowrap> "+
								"<input type='text' size='10' readonly name='cust"+rowVal+"' id='cust"+rowVal+"' value='"+cust+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
								"&nbsp; <input type='button' disabled class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
							"</td> ";
						}
						
						trVal = trVal + "<td class='fields' nowrap> "+
						"<input type='text' size='10' readonly name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='"+blngClass+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",1,1); }'> "+
							"&nbsp; <input type='button' disabled class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",1,1);'> "+
						"</td> "+
						
						"<td class='fields' nowrap> "+
							"<input type='text' size='10' maxlength='13' readonly name='currentPrice"+rowVal+"' id='currentPrice"+rowVal+"' value='"+currentPrice+"' onkeypress='return checkForSpecChars(event)' >"+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<Select name='currentType"+rowVal+"' id='currentType"+rowVal+"' disabled > "+
								"<option value=''>Select</option> "+
								"<option value='R'>Price</option> "+
								"<option value='F'>Factor</option> "+
							"</Select> "+
						"</td> "+
						
						"<td class='fields' nowrap> "+
							"<input type='text' size='10' name='revisedPrice"+rowVal+"' maxlength='13' id='revisedPrice"+rowVal+"' value='' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType"+rowVal+",this)'>"+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<Select name='revisedType"+rowVal+"' id='revisedType"+rowVal+"' onchange='checkForPerc(this,revisedPrice"+rowVal+")'> "+
								"<option value=''>Select</option> "+
								"<option value='P'>Percentage</option> "+
								"<option value='A'>Amount</option> "+
							"</Select> "+
						"</td> "+
						//Added against V210624 & 21058 starts
						"<td class='fields' nowrap> "+
							"<input type='checkbox' name='VATapp"+rowVal+"'  id='VATapp"+rowVal+"' onclick='VatBoxInd("+rowVal+")'/> "+
						"</td> ";
						//added by nandhini against 21058 starts
						if(priceType == 'S'||priceType == 'C'){
						trVal = trVal +"<td class='fields' nowrap> "+
							"<input type='text' name='VATpercent"+rowVal+"'  id='VATpercent"+rowVal+"' size='10' maxlength='10'/ disabled> "+
							"<input type='button' class='button' align='left' name='VATpercent_temp"+rowVal+"' id='VATpercent_temp"+rowVal+"' value='?'"+rowVal+" onClick='ruleCodeLookup(VATpercent"+rowVal+","+rowVal+");'/ disabled> "+
						"</td>";
						}
						else{
							trVal = trVal +"<td class='fields' nowrap> "+
							"<input type='text' name='VATpercent"+rowVal+"'  id='VATpercent"+rowVal+"' size='10' maxlength='10'/> "+
							"<input type='button' class='button' align='left' name='VATpercent_temp"+rowVal+"' id='VATpercent_temp"+rowVal+"' value='?'"+rowVal+" onClick='ruleCodeLookup(VATpercent"+rowVal+","+rowVal+");'/> "+
						"</td>";
						}
						//added by nandhini against 21058 ends
						if(priceType == 'S'||priceType == 'C'){
							trVal = trVal +"<td class='fields' nowrap> "+
							"<select name='RuleCoverage"+rowVal+"' id='RuleCoverage"+rowVal+"' disabled> "+
								"<option value=''>Select</option> "+
								"<option value='S'>As Per Policy</option> "+
								"<option value='C'>Patient Coverage</option> "+	
								"<option value='P'>Payer Coverage</option> "+						
							"</select> "+
							"</td>";
						}
						else{
							trVal = trVal +"<td class='fields' nowrap> "+
							"<select name='RuleCoverage"+rowVal+"' id='RuleCoverage"+rowVal+"'> "+
							"<option value=''>Select</option> "+
							"<option value='S'>As Per Policy</option> "+
							"<option value='C'>Patient Coverage</option> "+	
							"<option value='P'>Payer Coverage</option> "+					
						"</select> "+
						"</td>";
						}
					//Added against V210624 and 21280 ends
						trVal = trVal +"<td class='fields' nowrap> "+
							"<input type='text' id='effFrom"+rowVal+"' name='effFrom"+rowVal+"' value='"+effectiveFrom+"' size='10' onblur='validateDiscountDate(this,this,effTo"+rowVal+","+rowVal+");' > "+
							"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+rowVal+"' onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
						"</td>"+
						"<td class='fields' nowrap> "+
							"<input type='text' id='effTo"+rowVal+"' name='effTo"+rowVal+"' value='"+effectiveTo+"' size='10' onblur='validateDiscountDate(this,effFrom"+rowVal+",this,"+rowVal+");'> "+
							"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+rowVal+"' onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
						"</td>"+
						"<td class='fields' nowrap> "+
							"<input type='checkbox' id='removeChk"+rowVal+"' name='removeChk"+rowVal+"'> "+
						"</td> "+
						" <input type='hidden' id='status"+rowVal+"' name='status"+rowVal+"'	value='U'> "+
					"</tr>";
		$(lookup).find('#priceRevisionTbl  tr:last').after(trVal);
		$(lookup).find('#currentType'+rowVal).val(currentType);
		
	}
	else if(pageId == 'Discount'){
		rowCount = $(lookup).find('#priceRevisionTbl tr').length - 2;
		var pkgCode = $.trim( $('#pkgCode'+rowId).text());
		var pkgDesc = $.trim( $('#pkgDesc'+rowId).val());
		var custGroup = $.trim( $('#hideCustGrp'+rowId).text());
		var cust = $.trim( $('#hideCust'+rowId).text());
		var blngClass = $.trim( $('#blngClassCode'+rowId).text());
		var blngGroup = $.trim( $('#blngGroup'+rowId).text());
		var currentPrice = $.trim( $('#currPrice'+rowId).text());
		var currentType = $.trim( $('#currType'+rowId).text());
		var effectiveFrom = $.trim( $('#effFrom'+rowId).text());
		var effectiveTo = $.trim( $('#effTo'+rowId).text());
		
		var status = checkForDuplicate(pageId,pkgCode,blngGroup,blngClass,custGroup,cust,effectiveFrom);
		if(!status){
			alert('Record already added');
			return false;
		}
		//Commented as there is not need to check back date
		/*if(today!="" && (!(isAfter(effectiveFrom,today,'DMY',locale))))
		{
			effectiveFrom = '';	
		}*/ 
		trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
		"<td class='label' nowrap id='tdSn"+rowVal+"'> "+
			rowCount+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' readonly name='pkgCode"+rowVal+"' id='pkgCode"+rowVal+"' value='"+pkgCode+"' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='15' readonly name='pkgDesc"+rowVal+"' id='pkgDesc"+rowVal+"' value='"+pkgDesc+"' > "+
			"&nbsp; <input type='button' disabled class='button' id='pkgLkpBtn"+rowVal+"' name='pkgLkpBtn"+rowVal+"' value='?' > "+
		"</td> ";
		
		if(priceType == 'S'){
			trVal = trVal + "<td class='fields' nowrap> "+
				"<input type='text' size='10' readonly name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='"+blngGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' readonly name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='"+blngClass+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' disabled class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
				"</td> "+
			
			"<td class='fields' nowrap style='display:none;' id='hideCustGrpTd"+rowVal+"'> "+
				"<input type='text' size='10' readonly name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='"+custGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap style='display:none;' id='hideCustTd"+rowVal+"'> "+
				"<input type='text' size='10' readonly name='cust"+rowVal+"' id='cust"+rowVal+"' value='"+cust+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}
		else if(priceType == 'C'){
			trVal = trVal + "<td class='fields' nowrap style='display:none;' id='hideBlngGrpTd"+rowVal+"'> "+
				"<input type='text' size='10' readonly name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='"+blngGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' readonly name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='"+blngClass+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' disabled class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
				"</td> "+
			
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' readonly name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='"+custGroup+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' readonly name='cust"+rowVal+"' id='cust"+rowVal+"' value='"+cust+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' disabled class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}
		trVal = trVal + "<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' readonly name='currentValue"+rowVal+"' id='currentValue"+rowVal+"' value='"+currentPrice+"' onkeypress='return checkForSpecChars(event)' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='currentType"+rowVal+"' id='currentType"+rowVal+"' disabled > "+
				"<option value=''>Select</option> "+
				"<option value='R'>Percentage</option> "+
				"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' name='revisedValue"+rowVal+"' id='revisedValue"+rowVal+"' value='' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType"+rowVal+",this)'>"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='revisedType"+rowVal+"' id='revisedType"+rowVal+"' onchange='checkForPerc(this,revisedValue"+rowVal+")'> "+
				"<option value=''>Select</option> "+
				"<option value='P'>Percentage</option> "+
				"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effFrom"+rowVal+"' name='effFrom"+rowVal+"' value='"+effectiveFrom+"' size='10' onblur='validateDiscountDate(this,this,effTo"+rowVal+","+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+rowVal+"'  onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effTo"+rowVal+"' name='effTo"+rowVal+"' value='"+effectiveTo+"' size='10' onblur='validateDiscountDate(this,effFrom"+rowVal+",this,"+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+rowVal+"' onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='checkbox' id='removeChk"+rowVal+"' name='removeChk"+rowVal+"'> "+
		"</td> "+
		" <input type='hidden' id='status"+rowVal+"' name='status"+rowVal+"'	value='U'> "+
	"</tr>";
	$(lookup).find('#priceRevisionTbl  tr:last').after(trVal);
	$(lookup).find('#currentType'+rowVal).val(currentType);
	}
}

function addNewDiscount(){
	var lookup = parent.lookup.document;
	var pageId = $(lookup).find('#pageId').val();
	var priceType = $('#priceType').val();
	var lastRow = $('#priceRevisionTbl tr:last');
	var totalRecords;
	var bool = true;
	var insert = true;
	if(isNaN($(lastRow).attr('rowValue'))){
		totalRecords = 0;
		rowVal = '1';
		bool = false;
	}
	else{
		
		rowVal = $(lastRow).attr('rowValue');
		totalRecords = rowVal;
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	//alert(totalRecords)
	var lookUpData = parent.lookUpData.document;

	var custGrp	= $.trim($('#sCustGrpCode').val());
	var cust	= $.trim($('#sCustCode').val());
	var blngClass	= $.trim($('#sBlngClassCode').val());
	var pkgCode	= $.trim($('#sPkgCode').val());
	//alert(custGrp+','+cust+','+blngClass+','+pkgCode)
	if(bool){
		for(var i=1; i<= totalRecords; i++){
			var custGrpCur = $.trim($('#custGrp'+i).val());
			var custCur	= $.trim($('#cust'+i).val());
			var blngClassCur = $.trim($('#blngClass'+i).val());
			var pkgCodeCur	= $.trim($('#pkgCode'+i).val());
			//alert(custGrpCur+','+custCur+','+blngClassCur+','+pkgCodeCur)
			if(custGrp==custGrpCur && cust == custCur && blngClass==blngClassCur && pkgCode == pkgCodeCur){
				insert = false;
				//alert('setting insert to false')
			}			
		}
	}
	//alert(insert)
	var searchDoc = parent.search.document;
	//var hdrPkgCode = $(searchDoc).find('#pkgCode').val();
	var hdrPkgDesc = $(searchDoc).find('#srchPkgDesc').val();
	if(insert){
		var rowCount = $('#priceRevisionTbl tr').length - 2;
		trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
		"<td class='label' nowrap id='tdSn"+rowVal+"'> "+
			rowCount+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' readonly name='pkgCode"+rowVal+"' id='pkgCode"+rowVal+"' value='"+pkgCode+"' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='15' readonly name='pkgDesc"+rowVal+"' id='pkgDesc"+rowVal+"' value='"+hdrPkgDesc+"' > "+
			"&nbsp; <input type='button' disabled class='button' id='pkgLkpBtn"+rowVal+"' name='pkgLkpBtn"+rowVal+"' value='?' > "+
		"</td> ";
		
		
		if(priceType == 'S'){
			trVal = trVal + "<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='"+blngClass+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap style='display:none;' id='hideCustGrpTd"+rowVal+"' > "+
				"<input type='text' size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			"<td class='fields' nowrap style='display:none;' id='hideCustTd"+rowVal+"'> "+
				"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",2,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}
		else if(priceType == 'C'){
			trVal = trVal+ "<td class='fields' nowrap style='display:none;' id='hideBlngGrpTd"+rowVal+"'> "+
				"<input type='text' size='10' name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='"+blngClass+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='"+custGrp+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='"+cust+"' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}

		
		trVal = trVal+"<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' name='currentValue"+rowVal+"' id='currentValue"+rowVal+"' value='' readonly onkeypress='return checkForSpecChars(event)' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='currentType"+rowVal+"' id='currentType"+rowVal+"' disabled> "+
			"<option value=''>Select</option> "+
			"<option value='R'>Percentage</option> "+
			"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' name='revisedValue"+rowVal+"' id='revisedValue"+rowVal+"' value='' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType"+rowVal+",this)'>"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='revisedType"+rowVal+"' id='revisedType"+rowVal+"' onchange='checkForPerc(this,revisedValue"+rowVal+")'> "+
				"<option value=''>Select</option> "+
				"<option value='P'>Percentage</option> "+
				"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effFrom"+rowVal+"' name='effFrom"+rowVal+"' value='' size='10'  onblur='validateDiscountDate(this,this,effTo"+rowVal+","+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+rowVal+"' onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effTo"+rowVal+"' name='effTo"+rowVal+"' value='' size='10' onblur='validateDiscountDate(this,effFrom"+rowVal+",this,"+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+rowVal+"' onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='checkbox' id='removeChk"+rowVal+"' name='removeChk"+rowVal+"'> "+
		"</td> "+
		" <input type='hidden' id='status"+rowVal+"' name='status"+rowVal+"'	value='I'> "+
		"</tr>";
		$(lookup).find('#priceRevisionTbl  tr:last').after(trVal);
		$('#pkgCode'+rowVal).focus();
	}
	var rowVal = '';
	var trVal;
}

function fnAdd(){
	var lookup = parent.lookup.document;
	var pageId = $(lookup).find('#pageId').val();
	var priceType = $(lookup).find('#priceType').val();
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	var rowCount;
	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal;
	var searchDoc = parent.search.document;
	var hdrPkgCode = $(searchDoc).find('#srchPkgCode').val();
	var hdrPkgDesc = $(searchDoc).find('#srchPkgDesc').val();
	if(pageId == 'Price'){
		rowCount = $(lookup).find('#priceRevisionTbl tr').length;
		trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
				"<td class='label' nowrap id='tdSn"+rowVal+"'> "+
					rowCount+
				"</td> "+
				//Added against V210624 starts
				"<td class='fields' nowrap> "+
				"<select name='pkgPrice"+rowVal+"' id='pkgPrice"+rowVal+"' onchange='PkgPriceInd("+rowVal+")'>"+
					"<option value=''>Select</option> "+
					"<option value='R'>Retain package Price</option> "+
					"<option value='I'>Revise package Price</option> "+				
				"</select> "+
				"</td> "+
				"<td class='fields' nowrap > "+
				"<select name='VAT"+rowVal+"' id='VAT"+rowVal+"' onchange='VatOptionInd("+rowVal+")'>"+
					"<option value=''>Select</option> "+
					"<option value='N'>Retain VAT</option> "+
					"<option value='E'>Revise VAT</option> "+						
				"</select> "+
				"</td> "+
				//Added against V210624 ends
				"<td class='fields' nowrap> "+
						"<input type='text' size='10' name='pkgCode"+rowVal+"' id='pkgCode"+rowVal+"' value='"+hdrPkgCode+"' readonly >"+
					"</td> "+
					"<td class='fields' nowrap> "+
						"<input type='text' size='15' readonly  name='pkgDesc"+rowVal+"' id='pkgDesc"+rowVal+"' value='"+hdrPkgDesc+"' > "+
						"&nbsp; <input type='button' class='button' disabled id='pkgLkpBtn"+rowVal+"' name='pkgLkpBtn"+rowVal+"' value='?' > "+
						"&nbsp;<span class='LABEL' style='font-weight: normal; color: blue; cursor: pointer;' onclick='showDiscount("+rowVal+")'>Discount</span> "+
					"</td> ";
		if(priceType == 'S'){
			trVal = trVal + "<td class='fields' nowrap style='display:none;' id='hideCustGrpTd"+rowVal+"' > "+
					"<input type='text'  size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
					"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
				"</td> "+
				"<td class='fields' nowrap style='display:none;' id='hideCustTd"+rowVal+"'> "+
				"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
				"</td> ";
		}
		else if(priceType == 'C'){
			trVal = trVal + "<td class='fields' nowrap> "+
					"<input type='text' size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
					"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
				"</td> "+
				"<td class='fields' nowrap> "+
					"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
					"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
				"</td> ";
			}						
			trVal = trVal +	"<td class='fields' nowrap> "+
						"<input type='text' size='10' name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",1,1); }'> "+
							"&nbsp; <input type='button' class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",1,1);'> "+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<input type='text' size='10' maxlength='13' name='currentPrice"+rowVal+"' id='currentPrice"+rowVal+"' value='' readonly onkeypress='return checkForSpecChars(event)' >"+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<Select name='currentType"+rowVal+"' id='currentType"+rowVal+"' disabled> "+
							"<option value=''>Select</option> "+
							"<option value='R'>Price</option> "+
							"<option value='F'>Factor</option> "+
							"</Select> "+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<input type='text' size='10' maxlength='13' name='revisedPrice"+rowVal+"' id='revisedPrice"+rowVal+"' value='' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType"+rowVal+",this)'>"+
						"</td> "+
						"<td class='fields' nowrap> "+
							"<Select name='revisedType"+rowVal+"' id='revisedType"+rowVal+"' onchange='checkForPerc(this,revisedPrice"+rowVal+")'> "+
								"<option value=''>Select</option> "+
								"<option value='P'>Percentage</option> "+
								"<option value='A'>Amount</option> "+
							"</Select> "+
						"</td> "+
					//Added against V210624 & 21058 starts
						"<td class='fields' nowrap> "+
							"<input type='checkbox' name='VATapp"+rowVal+"'  id='VATapp"+rowVal+"' onclick='VatBoxInd("+rowVal+")'/> "+
						"</td> ";
						//added by nandhini against 21058 starts
						if(priceType == 'S'|| priceType == 'C'){
						trVal = trVal +"<td class='fields' nowrap> "+
							"<input type='text' name='VATpercent"+rowVal+"'  id='VATpercent"+rowVal+"' size='10' maxlength='10'/ disabled> "+
							"<input type='button' class='button' align='left' name='VATpercent_temp"+rowVal+"' id='VATpercent_temp"+rowVal+"' value='?'"+rowVal+" onClick='ruleCodeLookup(VATpercent"+rowVal+","+rowVal+");'/ disabled> "+
						"</td>";
						}
						else{
							trVal = trVal +"<td class='fields' nowrap> "+
							"<input type='text' name='VATpercent"+rowVal+"'  id='VATpercent"+rowVal+"' size='10' maxlength='10'/> "+
							"<input type='button' class='button' align='left' name='VATpercent_temp"+rowVal+"' id='VATpercent_temp"+rowVal+"' value='?'"+rowVal+" onClick='ruleCodeLookup(VATpercent"+rowVal+","+rowVal+");'/> "+
						"</td>";
						}
						//added by nandhini against 21058 ends
					if(priceType == 'S'|| priceType == 'C'){
						trVal = trVal +"<td class='fields' nowrap> "+
						"<select name='RuleCoverage"+rowVal+"' id='RuleCoverage"+rowVal+"' disabled> "+
							"<option value=''>Select</option> "+
							"<option value='S'>As Per Policy</option> "+
							"<option value='C'>Patient Coverage</option> "+	
							"<option value='P'>Payer Coverage</option> "+						
						"</select> "+
						"</td>";
					}
					else{
						trVal = trVal +"<td class='fields' nowrap> "+
						"<select name='RuleCoverage"+rowVal+"' id='RuleCoverage"+rowVal+"'> "+
						"<option value=''>Select</option> "+
						"<option value='S'>As Per Policy</option> "+
						"<option value='C'>Patient Coverage</option> "+	
						"<option value='P'>Payer Coverage</option> "+					
					"</select> "+
					"</td>";
					}
				//Added against V210624 and 21280 ends
					trVal = trVal +"<td class='fields' nowrap> "+
						"<input type='text' id='effFrom"+rowVal+"' name='effFrom"+rowVal+"' value='' size='10'   onblur='validateDiscountDate(this,this,effTo"+rowVal+","+rowVal+");'> "+
						"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+rowVal+"' onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
						"</td>"+
						"<td class='fields' nowrap> "+
							"<input type='text' id='effTo"+rowVal+"' name='effTo"+rowVal+"' value='' size='10' onblur='validateDiscountDate(this,effFrom"+rowVal+",this,"+rowVal+");'> "+
							"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+rowVal+"' onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
						"</td>"+
						"<td class='fields' nowrap> "+
							"<input type='checkbox' id='removeChk"+rowVal+"' name='removeChk"+rowVal+"'> "+
						"</td> "+
						" <input type='hidden' id='status"+rowVal+"' name='status"+rowVal+"'	value='I'> "+
					"</tr>";
		$(lookup).find('#priceRevisionTbl  tr:last').after(trVal);		
	}
	else if(pageId == 'Discount'){
		rowCount = $(lookup).find('#priceRevisionTbl tr').length - 2;
		trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
		"<td class='label' nowrap id='tdSn"+rowVal+"'> "+
			rowCount+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' name='pkgCode"+rowVal+"' id='pkgCode"+rowVal+"' readonly value='"+hdrPkgCode+"' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='15' name='pkgDesc"+rowVal+"' id='pkgDesc"+rowVal+"' readonly value='"+hdrPkgDesc+"' > "+
			"&nbsp; <input type='button' class='button' disabled id='pkgLkpBtn"+rowVal+"' name='pkgLkpBtn"+rowVal+"' value='?' > "+
		"</td> ";		
		if(priceType == 'S'){
			trVal = trVal + "<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap style='display:none;' id='hideCustGrpTd"+rowVal+"' > "+
				"<input type='text' size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			"<td class='fields' nowrap style='display:none;' id='hideCustTd"+rowVal+"'> "+
				"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",2,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}
		else if(priceType == 'C'){
			trVal = trVal+ "<td class='fields' nowrap style='display:none;' id='hideBlngGrpTd"+rowVal+"'> "+
				"<input type='text' size='10' name='blngGroup"+rowVal+"' id='blngGroup"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngGroup"+rowVal+",5,1); }'> "+
				"&nbsp; <input type='button' class='button' id='blngGroupBtn"+rowVal+"' name='blngGroupBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngGroup"+rowVal+",5,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='blngClass"+rowVal+"' id='blngClass"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(blngClass"+rowVal+",6,1); }'> "+
					"&nbsp; <input type='button' class='button' id='blngClassBtn"+rowVal+"' name='blngClassBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(blngClass"+rowVal+",6,1);'> "+
			"</td> "+
			
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='custGrp"+rowVal+"' id='custGrp"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(custGrp"+rowVal+",2,1); }'> "+
				"&nbsp; <input type='button' class='button' id='custGrpLkpBtn"+rowVal+"' name='custGrpLkpBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(custGrp"+rowVal+",2,1);'> "+
			"</td> "+
			"<td class='fields' nowrap> "+
				"<input type='text' size='10' name='cust"+rowVal+"' id='cust"+rowVal+"' value='' onblur='if(this.value.length>0){ callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+"); }'> "+
				"&nbsp; <input type='button' class='button' id='custBtn"+rowVal+"' name='custBtn"+rowVal+"' value='?' onclick='callCommonLookupWoDesc(cust"+rowVal+",3,1,custGrp"+rowVal+");'> "+
			"</td> ";
		}
		
		trVal = trVal+"<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' name='currentValue"+rowVal+"' id='currentValue"+rowVal+"' value='' readonly onkeypress='return checkForSpecChars(event)' >"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='currentType"+rowVal+"' id='currentType"+rowVal+"' disabled> "+
			"<option value=''>Select</option> "+
			"<option value='R'>Percentage</option> "+
			"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' size='10' maxlength='13' name='revisedValue"+rowVal+"' id='revisedValue"+rowVal+"' value='' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(revisedType"+rowVal+",this)'>"+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<Select name='revisedType"+rowVal+"' id='revisedType"+rowVal+"' onchange='checkForPerc(this,revisedValue"+rowVal+")'> "+
				"<option value=''>Select</option> "+
				"<option value='P'>Percentage</option> "+
				"<option value='A'>Amount</option> "+
			"</Select> "+
		"</td> "+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effFrom"+rowVal+"' name='effFrom"+rowVal+"' value='' size='10'  onblur='validateDiscountDate(this,this,effTo"+rowVal+","+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+rowVal+"' onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='text' id='effTo"+rowVal+"' name='effTo"+rowVal+"' value='' size='10' onblur='validateDiscountDate(this,effFrom"+rowVal+",this,"+rowVal+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+rowVal+"' onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
		"</td>"+
		"<td class='fields' nowrap> "+
			"<input type='checkbox' id='removeChk"+rowVal+"' name='removeChk"+rowVal+"'> "+
		"</td> "+
		" <input type='hidden' id='status"+rowVal+"' name='status"+rowVal+"'	value='I'> "+
	"</tr>";
	$(lookup).find('#priceRevisionTbl  tr:last').after(trVal);
	}
}

function addDiscountBulkUpdate(){
	var lookup = parent.lookUpData.document;
	var lastRow = $(lookup).find('#bulkUpdateTbl tr:last');
	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal;
	trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
				"<td width='20%' nowrap class='label'  > "+					
				"</td> "+
				"<td width='10%' > "+
					"<select name='pkgDiscType"+rowVal+"' id='pkgDiscType"+rowVal+"' onchange='checkForPerc(this,discPriceOrAmt"+rowVal+")'> "+
						"<option value=''>Select</option> "+
						"<option value='P'>Percentage</option> "+
					"</select> "+
				"</td> "+
				"<td width='10%' >	 "+			
					"<input type='text' name='discPriceOrAmt"+rowVal+"' id='discPriceOrAmt"+rowVal+"' size='15'  maxlength='13' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(pkgDiscType"+rowVal+",this)'>&nbsp; "+
				"</td> "+
				"<td width='10%' > "+
					"<select name='discMarkUpDown"+rowVal+"' id='discMarkUpDown1"+rowVal+"'> "+
						"<option value='N'>None</option> "+		
						"<option value='U'>Up</option> "+
						"<option value='D'>Down</option> "+			
					"</select> "+
				"</td> "+
				"<td width='10%' > "+
					"<input type='text' name='discRoundOff"+rowVal+"' id='discRoundOff"+rowVal+"' size='15'  maxlength='5' onkeypress='return checkAlpha(event)' onblur='checkForNumber(this)'>&nbsp; "+
				"</td> "+
				"<td width='10%' > "+
					"<select name='discRndMarkUpDown"+rowVal+"' id='discRndMarkUpDown"+rowVal+"'> "+
						"<option value='N'>None</option> "+	
						"<option value='U'>Up</option> "+
						"<option value='D'>Down</option> "+		
		
					"</select> "+
				"</td> "+
				"<td width='10%' > "+
					"<input type='text' name='effFrom"+rowVal+"'  id='effFrom"+rowVal+"' size='10' maxlength='10' onBlur='validDateLocal(this,1,"+rowVal+");' value='' /> "+
					"<img src='../../eCommon/images/CommonCalendar.gif'  id='dStartDate_ctrl"+rowVal+"'  onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
				"</td> "+
				"<td width='10%' > "+
					"<input type='text' name='effTo"+rowVal+"'  id='effTo"+rowVal+"' size='10' maxlength='10' onBlur='validDateLocal(this,2,"+rowVal+");' value='' /> "+
					"<img src='../../eCommon/images/CommonCalendar.gif' id='dEndDate_ctrl"+rowVal+"'  onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
				"</td> "+
				"<td width='10%' > "+
					"<input type='checkbox' name='bulkRemove"+rowVal+"'  id='bulkRemove"+rowVal+"'  /> "+				
				"</td> "+
			"</tr> ";
	$('#bulkUpdateTbl').append(trVal);
}

function addPriceBulkUpdate(){	
	var lookup = parent.bulkUpdate.document;
	var lastRow = $(lookup).find('#bulkUpdateTbl tr:last');	
	var rowVal = '';
	var priceType=document.getElementById('priceType').value;
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal;
	trVal = "<tr rowValue='"+rowVal+"' id='tr"+rowVal+"'> "+
				"<td width='1%' nowrap class='label'> "+
				"</td>"+
				//Added against V210624 starts				
				"<td width='1%' > "+
					"<select name='pkgPrice"+rowVal+"' id='pkgPrice"+rowVal+"' onchange='PkgPriceVal("+rowVal+")'>"+
						"<option value=''>Select</option> "+
						"<option value='R'>Retain package Price</option> "+
						"<option value='I'>Revise package Price</option> "+						
					"</select> "+
				"</td> "+
				"<td width='1%' > "+
					"<select name='VAT"+rowVal+"' id='VAT"+rowVal+"' onchange='VatOption("+rowVal+")'>"+
						"<option value=''>Select</option> "+
						"<option value='N'>Retain VAT</option> "+
						"<option value='E'>Revise VAT</option> "+						
					"</select> "+
				"</td> "+
				//Added against V210624 ends
				
				"<td width='1%' > "+
					"<select name='pkgPriceType"+rowVal+"' id='pkgPriceType"+rowVal+"' onchange='checkForPerc(this,pkgPriceOrAmt"+rowVal+")'> "+
						"<option value=''>Select</option> "+
						"<option value='P'>Percentage</option> "+						
					"</select> "+
				"</td> "+
				"<td width='1%' >	 "+			
					"<input type='text' name='pkgPriceOrAmt"+rowVal+"' id='pkgPriceOrAmt"+rowVal+"' size='10'  maxlength='15' onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(pkgPriceType"+rowVal+",this)'>&nbsp; "+
				"</td> "+
				"<td width='1%' > "+
					"<select name='priceMarkUpDown"+rowVal+"' id='priceMarkUpDown"+rowVal+"'> "+
						"<option value=''>Select</option> "+
						"<option value='U'>Up</option> "+
						"<option value='D'>Down</option> "+									
					"</select> "+
				"</td> "+
				"<td width='1%' > "+
					"<input type='text' name='priceRoundOff"+rowVal+"' id='priceRoundOff"+rowVal+"' size='10'  maxlength='15' onkeypress='return checkAlpha(event)' onblur='checkForNumber(this)'>&nbsp; "+
				"</td> "+
				"<td width='1%' > "+
					"<select name='priceRndMarkUpDown"+rowVal+"' id='priceRndMarkUpDown"+rowVal+"'> "+
						"<option value=''>Select</option> "+
						"<option value='U'>Up</option> "+
						"<option value='D'>Down</option> "+									
					"</select> "+
				"</td> "+
				//Added against V210624 starts and 21058
				"<td width='1%' > "+
					"<input type='checkbox' name='VATapp"+rowVal+"'  id='VATapp"+rowVal+"' onclick='VatCheckBox("+rowVal+")'/> "+
				"</td> "+
				"<td width='1%' > "+
					"<input type='text' name='VATpercent"+rowVal+"'  id='VATpercent"+rowVal+"' size='10' maxlength='15'/> "+"</td>"+
				"<td>"+"<input type='button' class='button' align='left' name='VATpercent_temp"+rowVal+"' id='VATpercent_temp"+rowVal+"' value='?'"+rowVal+" onClick='ruleCodeLookup(VATpercent"+rowVal+","+rowVal+")'/> "+
				"</td> "+
				"<td width='1%' > "+
					"<select name='RuleCoverage"+rowVal+"' id='RuleCoverage"+rowVal+"'> "+
						"<option value=''>Select</option> "+
						"<option value='S'>As Per Policy</option> "+
						"<option value='C'>Patient Coverage</option> "+	
						"<option value='P'>Payer Coverage</option> "+							
					"</select> "+
				"</td> "+
				//Added against V210624 ends
				"<td width='1%' > "+
					"<input type='text' name='effFrom"+rowVal+"'  id='effFrom"+rowVal+"' size='10' maxlength='15' onBlur='validDateLocal(this,1,"+rowVal+");' value='' /> "+"</td> "+
					"<td>"+"<img src='../../eCommon/images/CommonCalendar.gif'  id='dStartDate_ctrl"+rowVal+"'  onClick='return showCalendarLocal(1,"+rowVal+")' /> "+
				"</td> "+
				"<td width='1%' > "+
					"<input type='text' name='effTo"+rowVal+"'  id='effTo"+rowVal+"' size='10' maxlength='15' onBlur='validDateLocal(this,2,"+rowVal+");' value='' /> "+"</td> "+
					"<td> "+"<img src='../../eCommon/images/CommonCalendar.gif' id='dEndDate_ctrl"+rowVal+"'  onClick='return showCalendarLocal(2,"+rowVal+")' /> "+
				"</td> "+
				"<td width='1%' > "+
					"<input type='checkbox' name='bulkRemove"+rowVal+"'  id='bulkRemove"+rowVal+"'  /> "+				
				"</td> "+				
			"</tr> ";
	$('#bulkUpdateTbl').append(trVal);
	//Added against V210624 and 21436 starts
	if(priceType=='S' || priceType == 'C')
			priceTypeCall(rowVal);
	//Added against V210624 ends
}
/*Table Addition & Removal Functions*/

/*Persistence Helper*/
function getXMLString(last_link)	
{
	if(last_link == "Price")
	{		
		var frmObj = eval("parent.lookup.document.priceRevisionFrm");
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"priceRevision");		
	}
	else if(last_link == "Discount")
	{  
		var frmObj = eval("parent.lookup.document.priceRevisionFrm");
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"discountRevision");
	}
	else if(last_link == "PriceBulk"){
		var frmObj = eval("BulkUpdateFrame.bulkUpdate.document.bulkUpdateFrm");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"priceBulk");
	}
	else if(last_link == "DiscountBulk"){
		var frmObj = eval("BulkUpdateFrame.lookUpData.document.bulkUpdateFrm");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"discountBulk");
	}
	else if(last_link == "PriceMain"){
		var frmObj = eval("BulkUpdateFrame.lookup.document.priceRevisionFrm");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"priceRevision");
	}
	else if(last_link == "DiscountMain"){
		var frmObj = eval("BulkUpdateFrame.lookup.document.priceRevisionFrm");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"discountRevision");
	}
	else if(last_link == "Header"){
		var frmObj = eval("BulkUpdateFrame.search.document.searchFrm");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"persistHeader");
	}
}

function formXMLStringMain(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"Y" + "\" " ;
				}
				else{
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + "N" + "\" " ;
				}
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";	
	}
	return xmlStr;
}

function formValidation(xmlStr,last_link,event)
{	
	//last_link = 'BILL_PRINT_FMT';
	var temp_jsp="../../eBL/jsp/PkgPriceRevisionPersistence.jsp?func_mode="+last_link;
	if(event!=null && event == "delete")
		temp_jsp="../../eBL/jsp/PkgPriceRevisionPersistence.jsp?func_mode="+last_link+"&event="+event;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if (xmlDoc.getElementsByTagName('parseError').errorCode != 0)
	{
		/*alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText); */
		return null;
	}
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	if (xmlDoc.getElementsByTagName('parseError').errorCode != 0)
	{
		/*alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText); */
		return null;
	}
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

/*Persistence Helper*/
function showDiscount(indx){
	var dtlDoc = parent.lookup.document;
	var lookUpData = parent.lookUpData.document;
	var lookuptab = parent.lookupTab.document;
	var pageId = $(dtlDoc).find('#pageId').val();
	var priceType = $(dtlDoc).find('#priceType').val();
	var status = $(dtlDoc).find('#status'+indx).val();
	var blngClassCode = $(dtlDoc).find('#blngClass'+indx).val();
	var blngGrpCode = $(lookUpData).find('#blngGrpCode').val();
	var custGrpCode = $(dtlDoc).find('#custGrp'+indx).val();
	var custCode = $(dtlDoc).find('#cust'+indx).val();
	var pkgCode = $(dtlDoc).find('#pkgCode'+indx).val();
	var revisedPrice = $(dtlDoc).find('#revisedPrice'+indx).val();
	var revisedType = $(dtlDoc).find('#revisedType'+indx).val();
	var effFrom = $(dtlDoc).find('#effFrom'+indx).val();
	if(status == 'I'){
		if(priceType == 'C'){
			if(pkgCode == '' || blngClassCode== '' || custGrpCode == '' || custCode== '' || effFrom==''){
				alert('Please enter mandatory fields before defining Discounts');
				return false;
			}
		}
		else if(priceType == 'S'){
			if(pkgCode == '' || blngClassCode== '' || effFrom==''){
				alert('Please enter mandatory fields before defining Discounts');
				return false;
			}
		}
	}
	
	if(revisedPrice == ''){
		alert('Revised Price is a mandatory field');
		$(dtlDoc).find('#revisedPrice'+indx).select();
		return false;
	}
	if(revisedType == ''){
		alert('Revised Type is a mandatory field');
		$(dtlDoc).find('#revisedType'+indx).focus();
		return false;
	}
		
	$(lookuptab).find('#PackageRevision').attr('class','tabA');
	$(lookuptab).find('#PackageRevisionSpan').attr('class','tabAspan');
	$(lookuptab).find('#DiscountRevision').attr('class','tabClicked');
	$(lookuptab).find('#DiscountRevisionSpan').attr('class','tabSpanclicked');
	var trLength = '';
	var lastRow = $(dtlDoc).find('#priceRevisionTbl tr:last');
	
	if(isNaN($(lastRow).attr('rowValue'))){
		trLength = '1';
	}
	else{
		trLength = $(lastRow).attr('rowValue');						
	}
	$(dtlDoc).find('#lastRowIndex').val(trLength);		
	getXMLString('Price');
	if(status == 'I'){
		dtlDoc.location.href = '../../eBL/jsp/PkgDiscountRevision.jsp?priceType='+priceType+'&addNew=Y'+
								'&sBlngClassCode='+blngClassCode+
								'&sBlngGrpCode='+blngGrpCode+
								'&sCustGrpCode='+custGrpCode+
								'&sCustCode='+custCode+
								'&sPkgCode='+pkgCode;
	}
	else{
		dtlDoc.location.href = '../../eBL/jsp/PkgDiscountRevision.jsp?priceType='+priceType;
	}
	lookUpData.location.href = '../../eBL/jsp/PkgDiscountRevisionLookup.jsp?priceType='+priceType+
				'&blngClassCode='+blngClassCode+
				'&blngGrpCode='+blngGrpCode+
				'&custGrpCode='+custGrpCode+
				'&custCode='+custCode+
				'&pkgCode='+pkgCode;
}

function loadFrames(){
	var priceType = $('#priceType').val();
	var updateType = $('#updateType').val();
	var lookupAdd = parent.lookupAdd.document;
	var lookup = parent.lookup.document;
	var lookupTab = parent.lookupTab.document;
	var bulkUpdate = parent.bulkUpdate.document;
	var lookUpData = parent.lookUpData.document;
	var messageFrame = parent.parent.messageFrame.document;
	var parentDoc = parent.document;
	if(priceType != '' && updateType != ''){
		if(updateType == 'B'){			
			$.ajax({
				type:"POST",
				url:"../../eBL/jsp/PkgBulkUpdClearBean.jsp",
				dataType:"text",
				async:false,
				success: function(data){					
				},
				 error: function(data){
					 alert(data)
			     }
			});
			
			if(priceType == 'C'){
				//$(parentDoc).find('#bulkUpdateFrames').attr('rows','25%,38%,0%,37%,0%,0%');
				parent.document.getElementById("search").style.height="22vh";
				parent.document.getElementById("bulkUpdate").style.height="28vh";
				parent.document.getElementById("lookupTab").style.height="5vh";
				parent.document.getElementById("lookUpData").style.height="32vh";
				parent.document.getElementById("lookup").style.height="28vh";
				parent.document.getElementById("lookupAdd").style.height="6vh";
			}
			else if(priceType=='S'){
				//$(parentDoc).find('#bulkUpdateFrames').attr('rows','25%,38%,0%,37%,0%,0%');
				parent.document.getElementById("search").style.height="22vh";
				parent.document.getElementById("bulkUpdate").style.height="28vh";
				parent.document.getElementById("lookupTab").style.height="5vh";
				parent.document.getElementById("lookUpData").style.height="32vh";
				parent.document.getElementById("lookup").style.height="28vh";
				parent.document.getElementById("lookupAdd").style.height="6vh";
			}
			lookupTab.location.href = '../../eCommon/html/blank.html';
			lookup.location.href = '../../eCommon/html/blank.html';
			lookupAdd.location.href = '../../eCommon/html/blank.html';
			lookUpData.location.href = '../../eBL/jsp/PkgDiscountBulkUpdate.jsp';
			bulkUpdate.location.href = '../../eBL/jsp/PkgBulkUpdate.jsp?priceType='+priceType;
			messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}
		else if(updateType == 'P'){
			var blngClassCode = $('#blngClassCode').val();
			var blngGrpCode = $('#blngGrpCode').val();
			var custGrpCode = $('#custGrpCode').val();
			var custCode = $('#custCode').val();
			var pkgCode = $('#pkgCode').val();
			var policyCode = $('#policyCode').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			
			if(pkgCode == '**'){
				alert('All Packages cannot be selected for Individual price / Discount Revision');
				$('#pkgCode').select();
				return false;
			}
			
			$('#srchPkgCode').val(pkgCode);
			$('#srchPkgDesc').val($('#pkgDesc').val());
			$('#srchType').val(priceType);
			
			$.ajax({
				type:"POST",
				url:"../../eBL/jsp/PkgPriceRevisionPersistence.jsp",
				data:"func_mode=getPkgEffDates&pkgCode="+pkgCode,
				dataType:"text",
				async:false,
				success: function(data){
					retVal = $.trim(data);
					var retValArr = retVal.split(":::");
					$('#pkgEffFrom').val(retValArr[0]);
					$('#pkgEffTo').val(retValArr[1]);
					$('#pkgOpYn').val(retValArr[2]);
					$('#pkgEmYn').val(retValArr[3]);
					$('#pkgIpYn').val(retValArr[4]);
					$('#pkgDcYn').val(retValArr[5]);
				},
				 error: function(data){
					 alert(data)
			     }
			});
			
			
			$.ajax({
				type:"POST",
				url:"../../eBL/jsp/PkgBulkUpdClearBean.jsp",
				dataType:"text",
				async:false,
				success: function(data){					
				},
				 error: function(data){
					 alert(data)
			     }
			});
			if(priceType == 'C'){
				//$(parentDoc).find('#bulkUpdateFrames').attr('rows','25%,0%,5%,32%,32%,6%');
				parent.document.getElementById("search").style.height="22vh";
				parent.document.getElementById("bulkUpdate").style.height="0vh";
				parent.document.getElementById("lookupTab").style.height="5vh";
				parent.document.getElementById("lookUpData").style.height="32vh";
				parent.document.getElementById("lookup").style.height="28vh";
				parent.document.getElementById("lookupAdd").style.height="6vh";
			}
			else if(priceType='S'){
				//$(parentDoc).find('#bulkUpdateFrames').attr('rows','25%,0%,5%,32%,32%,6%');
				parent.document.getElementById("search").style.height="22vh";
				parent.document.getElementById("bulkUpdate").style.height="0vh";
				parent.document.getElementById("lookupTab").style.height="5vh";
				parent.document.getElementById("lookUpData").style.height="32vh";
				parent.document.getElementById("lookup").style.height="28vh";
				parent.document.getElementById("lookupAdd").style.height="6vh";
			}
			lookUpData.location.href = '../../eBL/jsp/PkgPriceRevisionLookup.jsp?priceType='+priceType+
						'&blngClassCode='+blngClassCode+
						'&blngGrpCode='+blngGrpCode+
						'&custGrpCode='+custGrpCode+
						'&custCode='+custCode+
						'&pkgCode='+pkgCode+
						'&policyCode='+policyCode; //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			lookupTab.location.href = '../../eBL/jsp/PkgPriceDiscountTab.jsp';			
			lookup.location.href = '../../eBL/jsp/PkgPriceRevision.jsp?priceType='+priceType;
			lookupAdd.location.href = '../../eBL/jsp/PkgPriceDiscountAdd.jsp';
			bulkUpdate.location.href = '../../eCommon/html/blank.html';
			messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}
	}
	else{
		if(priceType == ''){
			alert('Please Select Std / Customer Price');
			return false;
		}
		if(updateType = ''){
			alert('Please Select Bulk Update / Pkg Price');
			return false;
		}
	}
}

/*Lookup Functions*/
async function callCommonLookupCode(obj,code,sqlSelect,codeDesc,commonCode){
	var locale = $('#locale').val();
	var facility_id = $('#facilityId').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){			
		case 1:
		{
			sql="Select description, code from (select short_desc description, BLNG_CLASS_CODE code from BL_BLNG_CLASS_LANG_VW where language_id = '"+locale+"' "+
				"  and nvl(STATUS,'X') != 'S' union Select 'All Billing Class','ALL' from dual )  where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Class';
			break;
		}
		case 2:
		{
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}
		case 3:
		{
			var cust_code = commonCode.value;
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
			"Where Cust_Code In ( SELECT cust_code "+
            "FROM bl_cust_by_cust_group "+
            "WHERE cust_group_code = "+
             "DECODE ('"+cust_code+"', "+
                     "'**', cust_group_code, '"+ cust_code+
                            "')) "+
			"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
			"and nvl(patient_flag,'N')  ='Y' "+
			"and nvl(pat_com_flag,'N')='N' "+
			"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
			"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'Payer';
			break;
		}
		
		case 4:
		{
			if($(obj).attr('readonly')){
				sql = "Select description,code from (select short_desc description,package_code code from BL_PACKAGE_LANG_VW  where operating_facility_id='"+facility_id+"'    and language_id='"+locale+"' Union Select 'All Package' description, '**' code from dual )   where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			}
			else{
				sql = "Select description,code from (select short_desc description,package_code code from BL_PACKAGE_LANG_VW  where operating_facility_id='"+facility_id+"'    and language_id='"+locale+"' )   where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			}
			
			title = 'Package';
			break;
		}
		
		case 5:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"' "+
			"Union Select 'All Billing Group','ALL' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
		}
		
		case 6:
		{
			sql="Select description, code from (select short_desc description, BLNG_CLASS_CODE code from BL_BLNG_CLASS_LANG_VW where language_id = '"+locale+"' "+
				"  and nvl(STATUS,'X') != 'S' union Select 'All Billing Class - ALL','ALL' from dual union Select 'All Billing Class','**' from dual)  where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Class';
			break;
		}
		
		case 7:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"' "+
			"Union Select 'All Billing Group - ALL','ALL' From Dual  union Select 'All Billing Group','**' from dual) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
		}
		case 8:
		{
			sql="select description, code  from (select short_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') "+
			"Union Select 'All Policies','**' From Dual ) Where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Policy';
			break;
		}
		//Added for ICN:73403  14/7/2020
		case 9:
		{			
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"')  ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
			title = 'Payer Group';
			break;
		}
					
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}

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
	}
	else
	{
	obj.value = arr[1];
	code.value = arr[0];		
	} 


}

 async function callCommonLookupWoDesc(code,sqlSelect,codeDesc,commonCode){
	var locale = $('#locale').val();
	var facility_id = $('#facilityId').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){
			
		case 1:
		{
			var str = '';
			var searchDoc = parent.search.document;
			var opYn = $(searchDoc).find('#pkgOpYn').val();
			var emYn = $(searchDoc).find('#pkgEmYn').val();
			var ipYn = $(searchDoc).find('#pkgIpYn').val();
			var dcYn = $(searchDoc).find('#pkgDcYn').val();
			if(ipYn == 'Y')
			{
				str = " and ( B.PATIENT_CATEGORY_CODE = 'I' ";
			}
			if(dcYn == 'Y')
			{
				if( str == "")
					str = "and ( B.PATIENT_CATEGORY_CODE = 'D' ";
				else
					str =str + " or B.PATIENT_CATEGORY_CODE = 'D' ";
			}
			if(opYn == 'Y')
			{
				if( str == "")
					str = "and ( B.PATIENT_CATEGORY_CODE = 'O' ";
				else
					str =str + " or B.PATIENT_CATEGORY_CODE = 'O' ";
			}
			if(emYn == 'Y')
			{
				if( str == "")
					str = "and ( B.PATIENT_CATEGORY_CODE = 'E' ";
				else
					str =str + " or B.PATIENT_CATEGORY_CODE = 'E' ";
			}
			if( str != "")
				str = str +" ) ";
			
			sql ="select description, code from  (select 'All Billing Classes' description, '**' code from dual union all  select  A.short_DESC description,A.BLNG_CLASS_CODE code from BL_BLNG_CLASS_LANG_VW A, BL_BLNG_CLASS B where a.BLNG_CLASS_CODE = B.BLNG_CLASS_CODE "+str+" and A.LANGUAGE_ID = '"+locale +"' and nvl(B.STATUS,'X') != 'S' ) where  upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Class';
			break;
		}

		case 2:
		{
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}

		case 3:
		{
			var cust_code = commonCode.value;
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
			"Where Cust_Code In ( SELECT cust_code "+
            "FROM bl_cust_by_cust_group "+
            "WHERE cust_group_code = "+
                     "DECODE ('"+cust_code+"', "+
                             "'**', cust_group_code, '"+ cust_code+
                            "')) "+
			"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
			"and nvl(patient_flag,'N')  ='Y' "+
			"and nvl(pat_com_flag,'N')='N' "+
			"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
			"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'Payer';
			break;
		}
		
		case 4:
		{
			sql = "Select description,code from (select short_desc description,package_code code from BL_PACKAGE_LANG_VW  where operating_facility_id='"+facility_id+"'    and language_id='"+locale+"' )   where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Package';
			break;
		}
		
		case 5:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"' and  (status is null or status != 'S') and SETTLEMENT_IND='C' "+
			"Union Select 'All Billing Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
		}
		
		case 6:
		{
			sql="Select description, code from (select short_desc description, BLNG_CLASS_CODE code from BL_BLNG_CLASS_LANG_VW where language_id = '"+locale+"' "+
				"  and nvl(STATUS,'X') != 'S'  union Select 'All Billing Class','**' from dual )  where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Class';
			break;
			
		}
		
		case 7:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"' "+
			"Union Select 'All Billing Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
		}		
					
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	
	returnedValues =  await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		//code.value = returnedValues[0];
		code.value = arr[0];		
	}
	else
	{
		code.value = arr[0];			
	} 


}

function fnClearCode(obj){
	obj.value = '';
}

/*Lookup Functions*/



//Overlap functions


function checkForDuplicate(pageId,pkgCode,blngGroup,blngClass,custGrp,cust,effFrm){
	var status = true;
	var lookup = parent.lookup.document;
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	var	totalRecords=	 $(lastRow).attr('rowValue');
	
	if(pageId == 'Price'){
		for(var i=1; i<= totalRecords; i++){
			var fromDateCur = $.trim($(lookup).find('#effFrom'+i).val());
			var custGrpCur = $.trim($(lookup).find('#custGrp'+i).val());
			var custCur	= $.trim($(lookup).find('#cust'+i).val());
			var blngClassCur = $.trim($(lookup).find('#blngClass'+i).val());
			var pkgCodeCur	= $.trim($(lookup).find('#pkgCode'+i).val());
			if(custGrp == custGrpCur && cust == custCur
				&& blngClass == blngClassCur && pkgCode == pkgCodeCur && effFrm == fromDateCur){				
					status = false;
			}					
		}
	}
	else if(pageId == 'Discount'){
		for(var i=1; i<= totalRecords; i++){
			var fromDateCur = $.trim($(lookup).find('#effFrom'+i).val());
			var custGrpCur = $.trim($(lookup).find('#custGrp'+i).val());
			var custCur	= $.trim($(lookup).find('#cust'+i).val());
			var blngClassCur = $.trim($(lookup).find('#blngClass'+i).val());
			var blngGroupCur = $.trim($(lookup).find('#blngGroup'+i).val());
			var pkgCodeCur	= $.trim($(lookup).find('#pkgCode'+i).val());
			if(custGrp == custGrpCur && cust == custCur && blngClass == blngClassCur 
					&& blngGroup == blngGroupCur && pkgCode == pkgCodeCur && effFrm == fromDateCur){				
					status = false;
			}					
		}
	}
	return status;
}

function chkOverLapDiscountDate(totalRecords,obj,index)
{
	var formObj= document.forms[0];
	locale = formObj.locale.value;	
	
	var lookup = parent.lookup.document;
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	var pageId = $(lookup).find('#pageId').val();
	
	
	var	totalRecords=	 $(lastRow).attr('rowValue');
	//alert(totalRecords)
	if(pageId == 'Price'){
		var fromDate = $.trim($('#effFrom'+index).val());
		var toDate	= $.trim($('#effTo'+index).val());
		var custGrp	= $.trim($('#custGrp'+index).val());
		var cust	= $.trim($('#cust'+index).val());
		var blngClass	= $.trim($('#blngClass'+index).val());
		var pkgCode	= $.trim($('#pkgCode'+index).val());

		//alert(fromDate+','+toDate+','+custGrp+','+cust+','+blngClass+','+blngGroup+','+pkgCode)
		for(var i=1; i<= totalRecords; i++){
			var fromDateCur = $.trim($('#effFrom'+i).val());
			var toDateCur	= $.trim($('#effTo'+i).val());
			var custGrpCur = $.trim($('#custGrp'+i).val());
			var custCur	= $.trim($('#cust'+i).val());
			var blngClassCur = $.trim($('#blngClass'+i).val());
			var pkgCodeCur	= $.trim($('#pkgCode'+i).val());
			//alert(fromDateCur+','+toDateCur+','+custGrpCur+','+custCur+','+blngClassCur+','+blngGroupCur+','+pkgCodeCur)
			if(i != index){
				if(fromDateCur != null && fromDateCur != "" &&toDateCur != null && toDateCur != ""){
					if(custGrp == custGrpCur && cust == custCur
						&& blngClass == blngClassCur && pkgCode == pkgCodeCur){
						if(isBetween(fromDateCur, toDateCur, obj.value, 'DMY', locale)){
							alert('Efefctive Dates are overlapping. please choose a different date');
							obj.select();
							return false;
						}
					}
				}
				else if(fromDateCur != null && fromDateCur != ""){
					if(custGrp == custGrpCur && cust == custCur
							&& blngClass == blngClassCur && pkgCode == pkgCodeCur){
							if(isAfter(obj.value,fromDateCur, 'DMY', locale)){
								alert('Efefctive Dates are overlapping. please choose a different date');
								obj.select();
								return false;
							}
						}
				}
			}

		}
					
	}
	else if(pageId == 'Discount'){
		var fromDate = $.trim($('#effFrom'+index).val());
		var toDate	= $.trim($('#effTo'+index).val());
		var custGrp	= $.trim($('#custGrp'+index).val());
		var cust	= $.trim($('#cust'+index).val());
		var blngClass	= $.trim($('#blngClass'+index).val());
		var blngGroup	= $.trim($('#blngGroup'+index).val());
		var pkgCode	= $.trim($('#pkgCode'+index).val());

		//alert(fromDate+','+toDate+','+custGrp+','+cust+','+blngClass+','+blngGroup+','+pkgCode)
		for(var i=1; i<= totalRecords; i++){
			var fromDateCur = $.trim($('#effFrom'+i).val());
			var toDateCur	= $.trim($('#effTo'+i).val());
			var custGrpCur = $.trim($('#custGrp'+i).val());
			var custCur	= $.trim($('#cust'+i).val());
			var blngClassCur = $.trim($('#blngClass'+i).val());
			var blngGroupCur = $.trim($('#blngGroup'+i).val());
			var pkgCodeCur	= $.trim($('#pkgCode'+i).val());
			//alert(fromDateCur+','+toDateCur+','+custGrpCur+','+custCur+','+blngClassCur+','+blngGroupCur+','+pkgCodeCur)
			if(i != index){
				if(fromDateCur != null && fromDateCur != "" &&toDateCur != null && toDateCur != ""){
					if(custGrp == custGrpCur && cust == custCur
						&& blngClass == blngClassCur && blngGroup == blngGroupCur
						&& pkgCode == pkgCodeCur){
						if(isBetween(fromDateCur, toDateCur, obj.value, 'DMY', locale)){
							alert('Efefctive Dates are overlapping. please choose a different date');
							obj.select();
							return false;
						}
					}
				}
				else if(fromDateCur != null && fromDateCur != ""){
					if(custGrp == custGrpCur && cust == custCur
							&& blngClass == blngClassCur && blngGroup == blngGroupCur
							&& pkgCode == pkgCodeCur){
							if(isAfter(obj.value,fromDateCur, 'DMY', locale)){
								alert('Efefctive Dates are overlapping. please choose a different date');
								obj.select();
								return false;
							}
						}
				}
			}

		}
	}
	
	
	
}


function getToday(){
	var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!

    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 
    var today = dd+'/'+mm+'/'+yyyy;
   return today;
}
//Overlap functions

/*Date Validations*/
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('effFrom'+obj);
	}
	else if(fromTo == 2){
		return showCalendar('effTo'+obj);
	}
	
}

function validDateLocal(obj,type,index){
	var locale = $('#locale').val();
	var flag = false;
	if(obj.value!="")
	{
		if(validDate(obj.value,"DMY",locale))
		{
			
		
			flag =  true;
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			//obj.select();
			obj.value = '';
			return false;
		}
		
		var today = getToday();
		//var backDays = $(parent.search.document).find('#backDays').val();
		//var backDate = minusDate(today,'DMY',locale,backDays,'d');
		if(flag){
			if(type == '1'){
				var fromDate = $('#effFrom'+index).val();
				var toDate = $('#effTo'+index).val();
				
				/*if(today!="" && (!isBefore(backDate,obj.value,'DMY',locale)))
				{
					alert("Effective Date cannot be lesser than "+backDate);
					obj.select();
					return false;		
				}*/ 
				
				if(!(fromDate==null ||  fromDate=="" || toDate==null || toDate=="" ))
				{	
					if((!isBefore(fromDate,toDate,'DMY',locale)))
					{	
						alert("Effective To Date cannot be lesser than Effective From Date");
						$('#effTo'+index).select();
						return false;
					}
				}
			} 
			else if(type == '2'){
				var fromDate = $('#effFrom'+index).val();
				var toDate = $('#effTo'+index).val();

				/*if(today!="" && (!isBefore(backDate,obj.value,'DMY',locale)))
				{
					alert("Effective Date cannot be lesser than "+backDate);
					obj.select();
					return false;		
				}*/ 
				
				if(!(fromDate==null ||  fromDate=="" || toDate==null || toDate=="" ))
				{	
					if((!isBefore(fromDate,toDate,'DMY',locale)))
					{	
						alert("Effective To Date cannot be lesser than Effective From Date");
						$('#effTo'+index).select();
						return false;
					}
				}
			}
		
		}
	}	
}

function validateDiscountDate(obj,fromDateObj,toDateObj,index)
{
	
	var fromDate = eval(fromDateObj).value;
	var toDate	 = eval(toDateObj).value;
	var formObj=document.forms[0]
	var locale=formObj.locale.value;

	var lookup = parent.lookup.document;
	var lastRow = $(lookup).find('#priceRevisionTbl tr:last');
	
	var	totalRecords=	 $(lastRow).attr('rowValue');
	var today = getToday();
	
	
	
	/*var backDays = $(parent.search.document).find('#backDays').val();
	var backDate = minusDate(today,'DMY',locale,backDays,'d');*/
	var flag = true;
	if(obj.value!=""){
		if(validDiscountDateChk(obj)){
			if(!(fromDate==null ||  fromDate=="" || toDate==null || toDate=="" ))
			{	
				if((!isBefore(fromDate,toDate,'DMY',locale)))
				{	
					alert("Effective To Date cannot be lesser than Effective From Date");
					toDateObj.select();
					flag = false;
				}
			}
			
			var searchDoc = parent.search.document;
			var pkgEffFrom = $(searchDoc).find('#pkgEffFrom').val();
			var pkgEffTo = $(searchDoc).find('#pkgEffTo').val();
			
			if(flag && obj.value !="")
			{
				if(pkgEffTo != ""){
					if(!isBetween(pkgEffFrom,pkgEffTo,obj.value,'DMY',locale)){
						alert("Effective Date should be within Package Effective Dates - "+pkgEffFrom+" and "+pkgEffTo);
						obj.value = '';
						obj.focus();
						flag = false;
					}
				}
				else{
					if(!isAfter(obj.value,pkgEffFrom,'DMY',locale)){
						alert("Effective Date should be within Package Effective Dates - "+pkgEffFrom);
						obj.value = '';
						obj.focus();
						flag = false;
					}
				}		
			}
			/*if(flag && obj.value !="" && (index>0 || totalRecords>1))
				chkOverLapDiscountDate(totalRecords,obj,index)*/
		}		
	}
}

function validDiscountDateChk(obj)
{
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
		if(validDate(obj.value,'DMY',locale))
		{		
			return true;
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			//obj.select();
			obj.value = '';
			return false;
		}
	}
	else
	{
		return true;
	}
}

/*Number Validations */
function checkAlpha(event){
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true;
}

function checkForNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkForPerc(type,val){
	if(type.value == 'P'){
		if(val.value>100){
			alert('Percentage cannot be greater than 100');
			val.select();
			return false;
		}
	}
}

function checkForSpecChars(event) {
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true;
}

function checkForNumberDecimal(obj) {
	var searchDoc = parent.search.document;
	var noOfDec = $(searchDoc).find('#noOfDecimal').val();
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
		if(decArr[1].length>noOfDec){
			alert('Only '+noOfDec+' Numbers are allowed beyond Decimal');
			obj.value = '';
			return false;
		}
	}
}

