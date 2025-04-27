function create() {
    MultiFactorDeductRuleMainFrame.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleMainFrame.jsp?mode=insert";
}

function reset() {
   MultiFactorDeductRuleMainFrame.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleMainFrame.jsp?mode=insert";
}

function query() {
    commontoolbarFrame.document.forms[0].apply.disabled = true;
    MultiFactorDeductRuleMainFrame.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleQueryCriteria.jsp";
}

function onSuccess() {
    MultiFactorDeductRuleMainFrame.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleMainFrame.jsp?mode=insert";
}

function changeEpsdEnc(obj) {
	
    var epsdEnc = document.getElementById('episode_' + obj).value;
    var patClass = document.getElementById('ptClass_' + obj);

    if (epsdEnc == 'E') {
		
        patClass.length = 0;
		
        var opt = document.createElement("option");
        opt.value = 'O';
        opt.innerText = 'OP';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'E';
        opt.innerText = 'EM';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'R';
        opt.innerText = 'EX';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = '*';
        opt.innerText = 'ALL';
        patClass.appendChild(opt);

	}
	else if(epsdEnc == 'N'){
		
        patClass.length = 0;
		
        var opt = document.createElement("option");
        opt.value = 'I';
        opt.innerText = 'IP';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'D';
        opt.innerText = 'DC';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = '*';
        opt.innerText = 'ALL';
        patClass.appendChild(opt);

    } 
	else if (epsdEnc == 'A') {
		
        patClass.length = 0;
		
        var opt = document.createElement("option");
        opt.value = '*';
        opt.innerText = 'ALL';
        patClass.appendChild(opt);

    } else {
		
        patClass.length = 0;

        var opt = document.createElement("option");
        opt.value = '';
        opt.innerText = 'Select';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'O';
        opt.innerText = 'OP';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'I';
        opt.innerText = 'IP';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'D';
        opt.innerText = 'DC';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'E';
        opt.innerText = 'EM';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = 'R';
        opt.innerText = 'EX';
        patClass.appendChild(opt);

        opt = document.createElement("option");
        opt.value = '*';
        opt.innerText = 'ALL';
        patClass.appendChild(opt);
        
    }
}

async function callCommonValidation(sqlSelect, obj, code, index) {
	//alert("5");
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    switch (sqlSelect) {
        case 1:
            {
                sql = "select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
                title = 'Speciality';
                break;
            }
        case 2:
            {
				var payer_group_code = document.getElementById("payer_group_code_"+index).value;
        	//	var cust_code = document.forms[0].payer_group_code.value;
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where Cust_Code In ( SELECT cust_code " +
                "FROM bl_cust_by_cust_group " +
                "WHERE cust_group_code = " +
                "DECODE ('" +
                payer_group_code +
                "', " +
                "'**', cust_group_code, '" +
                payer_group_code +
                "')) " +
                "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
        case 3:
            {
                sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                "cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                "where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                "And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";

                title = 'Payer Group';
                break;
            }
        case 4:
			{
				var cust_group_code = document.getElementById("payer_group_code_"+index).value;
				var cust_code = document.getElementById("payer_code_"+index).value;
				
				sql="SELECT description,code from ( select a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+		  "' AND (b.cust_group_code =  '"+cust_group_code+"' OR b.cust_group_code = '**') AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
						" AND a.policy_type_code = b.policy_type_code "+
						" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
						" union  Select 'All Policy','**' From Dual)" +
						" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";
				
				title = 'Policy';
                break;
            }
		case 5:
			{
			
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; 
                
				title = 'Package Group';
                break;
            } //V230210

    }
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = arr[1];
        code.value = arr[0];
    }
}


function fnClearCode(obj,index,obj1){		
	if(obj1 == 1){
		payer = document.getElementById("payer_desc_"+index);
		payer_code = document.getElementById("payer_code_"+index); 
		policy_type = document.getElementById("policy_type_desc_"+index);
		policy_type_code = document.getElementById("policy_type_code_"+index);
		obj.value = '';
		payer.value = '';
		payer_code.value = '';
		policy_type.value = '';
		policy_type_code.value = '';	
	}
	else if(obj1 == 2){
		policy_type = document.getElementById("policy_type_desc_"+index);
		policy_type_code = document.getElementById("policy_type_code_"+index);
		obj.value = '';
		policy_type.value = '';
		policy_type_code.value = '';	
	}
	else{
		obj.value = '';
	}
}

function checkForSpecChars(event) {
    var strCheck = '1234567890.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForNumberDecimal(obj) {
	var index = document.getElementById("rowCount").value;
	var patCopay = document.getElementById("patCopay_"+index).name;
	var decArr = obj.value.split('.');
	if(isNaN(decArr[0]))
	{
		alert(getMessage('BL8532', 'BL'));
		obj.value = ''; 
		return false;
	}
	if((parseInt(decArr[0])<0 || parseInt(decArr[0])>100 ) && patCopay==obj.name)
	{
		alert(getMessage('BL8539', 'BL'));
		obj.value = '';
		return false;
	}
    if (decArr.length > 2) {
        alert(getMessage("NUM_ALLOWED", "SM"));
        obj.value = '';
        return false;
    }

    if (decArr.length == 2) {
        if (decArr[0].length < 1 && decArr[1].length < 1) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
        if (decArr[1].length > 2) {
            alert('Only Two Numbers are allowed beyond Decimal');
            obj.value = '';
            return false;
        }
    }
}

//V221113
function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
	
	var startdt = new Date();
    var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	
	if(startDate.value == ""){
		alert(getMessage('BL8504', 'BL'));
        endDate.value = '';
		return false;
	}
	
	if (startDate.value.length > 0 && endDate.value.length > 0) {
        if(startdt > enddt) {
            alert(getMessage('BL1344', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

//V221113
function compareCurrent_StartDates(startDate){
	var starr = startDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt > startdt){
		alert(getMessage('PH_FROM_DATE_GREATER_EQUAL_CURRENT_DATE', 'PH')); 
        startDate.value = '';
		return false;
	}
}

//V221113
function effFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);  //V221115
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareCurrent_StartDates(startDt);
			if(valid_status == true || valid_status == "true"){
				valid_status = compareDates(startDt, endDt);
			}
		}	
	}
}

//V221113
function effToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);   //V221115
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
		}	
	}
}


function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }

}


function apply() {
	//alert("1");
	if (parent.frames[2].MultiFactorDeductRuleMainFrame.DrugDiagnosisCategoryDetailsPage != undefined) {
	//alert("2");
		var mode = parent.frames[2].MultiFactorDeductRuleMainFrame.MultiFactorDeductRuleTab.document.frmMultiFactorDeductRuleTab.mode.value;
		if(mode == "insert" || mode == "modify"){
			//alert("3");
			var last_link = parent.frames[2].MultiFactorDeductRuleMainFrame.MultiFactorDeductRuleTab.document.frmMultiFactorDeductRuleTab.last_link.value;
			var deduct_Cat = parent.frames[2].MultiFactorDeductRuleMainFrame.MultiFactorDeductRuleTab.document.frmMultiFactorDeductRuleTab.deduct_Cat.value; 
			if(deduct_Cat != "" && deduct_Cat != null){
				//alert("4");
				last_link = deduct_Cat;
			}
			if(last_link == "DrugCategoryDetails"){
				//alert("5");
				var frmObj = parent.frames[2].MultiFactorDeductRuleMainFrame.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.forms[0];
				var pageInfo = frmObj.pageInfo.value;
				var episodetype = getLabel("eBL.EpisodeEncounter.label", "bl");  
				var patClass = getLabel("Common.type.label", "common");  //V230210
			    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
				var payerLbl = getLabel("eBL.PAYER.label", "bl");
				var policyLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
			    var drugCategory = getLabel("ePH.DrugCategory.label", "bl");
				var patCopay = getLabel("eBL.PatCopay.label", "bl");
			    var amtLimit = getLabel("eBL.PatAmtLimit.label", "bl");
				var eff_From = getLabel("eBL.EffFromDate.label", "bl");
				 
				var index = frmObj.rowCount.value;
				var parentDoc = frmObj.document;
				
				for(var i = 1; i <= index; i++){
					//alert("6");
					var epsdEnc = parentDoc.getElementById("episode_"+i);
					var pat_Class = parentDoc.getElementById("ptClass_"+i);
					var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i);
					var payer_desc = parentDoc.getElementById("payer_desc_"+i);
					var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i);
					var drug_category = parentDoc.getElementById("drug_category_"+i);
					var pat_Copay = parentDoc.getElementById("patCopay_"+i);
					var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i);
					var effFrom = parentDoc.getElementById("effFrom_"+i);
					 
					var fieldsTop = new Array(epsdEnc,pat_Class,
							payer_group_desc, payer_desc,
							policy_type_desc, drug_category,
							pat_Copay, patLimitAmt, effFrom);
					
					var namesTop = new Array(episodetype, patClass , payerGrpLbl, payerLbl, policyLbl, drugCategory,
							patCopay, amtLimit, eff_From);
					
					var msgFrame = messageFrame;

					validForm = checkFieldsofMst(fieldsTop, namesTop, msgFrame);
					if(validForm == false){
						//alert("7");
						return false;
					}	
				}
				
			    if(validForm == true)
				{	
			//alert("8");
					 var mode = frmObj.mode.value;
					 xmlString = formXMLStringMain(frmObj); 					 
					 updation = formValidation(xmlString, pageInfo);
					 frmObj.target = 'messageFrame';
					 frmObj.method = "post";
					 frmObj.action = "../../servlet/eBL.MultiFactorDeductRuleMasterServlet?mode=" + mode;
					 frmObj.submit();  
				 }	 				
			}else if(last_link == "DiagnosisCategoryDetails"){
				//alert("9");
				var frmObj = parent.frames[2].MultiFactorDeductRuleMainFrame.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.forms[0];
				var pageInfo = frmObj.pageInfo.value;				
				var episodetype = getLabel("eBL.EpisodeEncounter.label", "bl");  
				var patClass = getLabel("Common.type.label", "common");  //V230210
			    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
				var payerLbl = getLabel("eBL.PAYER.label", "bl");
				var policyLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
			    var diagCat = getLabel("eBL.DiagnosisCategory.label", "bl");
				var patCopay = getLabel("eBL.PatCopay.label", "bl");
			    var amtLimit = getLabel("eBL.PatAmtLimit.label", "bl");
				var eff_From = getLabel("eBL.EffFromDate.label", "bl");
				 
				var index = frmObj.rowCount.value;
				var parentDoc = frmObj.document;
				
				for(var i = 1; i <= index; i++){
					//alert("10");
					
					var epsdEnc = parentDoc.getElementById("episode_"+i);
					var pat_Class = parentDoc.getElementById("ptClass_"+i);
					var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i);
					var payer_desc = parentDoc.getElementById("payer_desc_"+i);
					var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i);
					var diag_category = parentDoc.getElementById("diag_category_"+i);
					var pat_Copay = parentDoc.getElementById("patCopay_"+i);
					var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i);
					var effFrom = parentDoc.getElementById("effFrom_"+i);
					 
					var fieldsTop = new Array(epsdEnc,pat_Class,
							payer_group_desc, payer_desc,
							policy_type_desc, diag_category,
							pat_Copay, patLimitAmt, effFrom);
					
					var namesTop = new Array(episodetype, patClass , payerGrpLbl, payerLbl, policyLbl, diagCat,
							patCopay, amtLimit, eff_From);
					
					var msgFrame = messageFrame;

					validForm = checkFieldsofMst(fieldsTop, namesTop, msgFrame);
					if(validForm == false){
						return false;
					}	
				}
				
				if(validForm == true)
				{
					//alert("11");
					 var mode = frmObj.mode.value;
					 xmlString = formXMLStringMain(frmObj);
					 updation = formValidation(xmlString, pageInfo);
					 frmObj.target = 'messageFrame';
					 frmObj.method = "post";
					 frmObj.action = "../../servlet/eBL.MultiFactorDeductRuleMasterServlet?mode=" + mode;
					 frmObj.submit();  
				 }	 				
			}  /* V230210 starts */
			else if(last_link == "ServicesAndItemsCategoryDetails"){
				//alert("12");
				var frmObj = parent.frames[2].MultiFactorDeductRuleMainFrame.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.forms[0];
				var pageInfo = frmObj.pageInfo.value;				
				var episodetype = getLabel("eBL.EpisodeEncounter.label", "bl");  
				var patClass = getLabel("Common.type.label", "common");
			    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
				var payerLbl = getLabel("eBL.PAYER.label", "bl");
				var policyLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
			    var clinicCat = getLabel("Common.category1.label", "common");
				var clinicProcUnit = getLabel("eBL.Clinic_Proc_unit.label","bl");
				var serviceDtls = getLabel("eBL.Servicedtls.label", "bl");
				var ref = getLabel("Common.referral.label", "common");
				var patCopay = getLabel("eBL.PatCopay.label", "bl");
			    var amtLimit = getLabel("eBL.PatAmtLimit.label", "bl");
				var eff_From = getLabel("eBL.EffFromDate.label", "bl");
				 
				var index = frmObj.rowCount.value;
				var parentDoc = frmObj.document;
				
				for(var i = 1; i <= index; i++){
					//alert("13");
					var epsdEnc = parentDoc.getElementById("episode_"+i);
					var pat_Class = parentDoc.getElementById("ptClass_"+i);
					var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i);
					var payer_desc = parentDoc.getElementById("payer_desc_"+i);
					var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i);
					var clinic_category = parentDoc.getElementById("clinic_category_"+i);
					var clinic_proc_unit = parentDoc.getElementById("clinic_"+i);
					var service_Dtls = parentDoc.getElementById("service_dtls_desc_"+i);
					var referral = parentDoc.getElementById("referral_"+i);
					var pat_Copay = parentDoc.getElementById("patCopay_"+i);
					var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i);
					var effFrom = parentDoc.getElementById("effFrom_"+i);
					 
					var fieldsTop = new Array(epsdEnc,pat_Class,
							payer_group_desc, payer_desc,
							policy_type_desc, clinic_category,
							clinic_proc_unit, service_Dtls,
							referral, pat_Copay, patLimitAmt, effFrom);
					
					var namesTop = new Array(episodetype, patClass , payerGrpLbl, payerLbl, policyLbl, clinicCat,
							clinicProcUnit, serviceDtls, ref, patCopay, amtLimit, eff_From);
					
					var msgFrame = messageFrame;

					validForm = checkFieldsofMst(fieldsTop, namesTop, msgFrame);
					if(validForm == false){
						return false;
					}	
				}
				
				if(validForm == true)
				{
					//alert("14");
					 var mode = frmObj.mode.value;
					 xmlString = formXMLStringMain(frmObj);
					 updation = formValidation(xmlString, pageInfo);
					 frmObj.target = 'messageFrame';
					 frmObj.method = "post";
					 frmObj.action = "../../servlet/eBL.MultiFactorDeductRuleMasterServlet?mode=" + mode;
					 frmObj.submit();  
				 }	 				
			} /* V230210 ends */
		}
	}
}


function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
    }
	
	return xmlStr;
}



function formValidation(xmlStr, last_link, event) {
	
	var temp_jsp = "../../eBL/jsp/MultiFactorDeductRulePersistence.jsp?func_mode=" + last_link;
    if (event != null && event == "delete")
        temp_jsp = "../../eBL/jsp/MultiFactorDeductRulePersistence.jsp?func_mode=" + last_link +
        "&event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    
   /* var responseText = xmlHttp.responseText;
	eval(responseText);
    return true; */
	if (xmlHttp.status === 200) {
        var responseText = xmlHttp.responseText;
        console.log(responseText);
        return true;
    } else {
        console.error("Request failed with status:", xmlHttp.status);
        console.error("Response text:", xmlHttp.responseText);
        return false;
    }
}


function chkForMandFields(called_frm, index){ 
	
	var payerGroup = document.getElementById("payer_group_code_"+index).value;
	var payer = document.getElementById("payer_code_"+index).value;
	var policy = document.getElementById("policy_type_code_"+index).value;
	
	if(called_frm == "P"){
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}		
	}	

	if(called_frm == "PL"){
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}

		if(payer == ""){
			alert(getMessage("BL0746","BL"));
			return false;
		}
	}

	if(called_frm == "D"){
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}

		if(payer == ""){
			alert(getMessage("BL0746","BL"));
			return false;
		}
		
		if(policy == ""){
			alert(getMessage("BL9103","BL"));
			return false;
		}
		
	}

	return true;	
}


function fnEnableDisablePayer_PayerPolicy(type, obj1, obj2, obj3, index) {
	
	var pageInfo=document.getElementById('pageInfo').value;
	payer_group = document.getElementById(obj1);
	payer = document.getElementById(obj2);
	policy_type = document.getElementById(obj3);
	if (payer_group.value == "") {
		payer.value = '';
		policy_type.value = '';
    }
}

//V221128
function fnShowMainTabDetails(object)
{
	link = object;
	
	var last_link = document.forms[0].last_link.value;
	var deduct_Cat = document.forms[0].deduct_Cat.value;
	var result = true;
	
	if(deduct_Cat != null && deduct_Cat != ""){
		
		var hdrfrmobj = "";
		var mode = "";
		last_link = deduct_Cat;
		if(deduct_Cat == 'DiagnosisCategoryDetails' && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
			
			hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRuleDiagnosisCategory; 
			mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRuleDiagnosisCategory.mode.value;
			result = validateDiagCat(hdrfrmobj);
			if(result){
				if(hdrfrmobj != null && hdrfrmobj != undefined){
					var xmlString = formXMLStringMain(hdrfrmobj);
					var updation = formValidation(xmlString, last_link);
				//	alert(xmlString);
					document.forms[0].deduct_Cat.value = link;
				}
			}
		
		}else if(deduct_Cat == "DrugCategoryDetails" && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
			
			hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRule;
			mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRule.mode.value;
			result = validateDrugCat(hdrfrmobj);
			if(result){
				if(hdrfrmobj != null && hdrfrmobj != undefined){
					var xmlString = formXMLStringMain(hdrfrmobj);
					var updation = formValidation(xmlString, last_link);
				//	alert(xmlString);
					document.forms[0].deduct_Cat.value = link;
				}	
			}
			
		} /* V230210 starts */
		else if(deduct_Cat == "ServicesAndItemsCategoryDetails" && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
			
			hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory;
			mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory.mode.value;
			result = validateServicesAndItemsCat(hdrfrmobj);
			if(result){
				if(hdrfrmobj != null && hdrfrmobj != undefined){
					var xmlString = formXMLStringMain(hdrfrmobj);
					var updation = formValidation(xmlString, last_link);
				//	alert(xmlString);
					document.forms[0].deduct_Cat.value = link;
				}	
			} 
			
		} /* V230210 ends */
	}else{	
		if (last_link != "") {
			
			var hdrfrmobj = "";
			var mode = "";
		
			if(last_link == 'DiagnosisCategoryDetails' && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
				
				hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRuleDiagnosisCategory; 
				mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRuleDiagnosisCategory.mode.value;
				result = validateDiagCat(hdrfrmobj);
				if(result){
					if(hdrfrmobj != null && hdrfrmobj != undefined){
						var xmlString = formXMLStringMain(hdrfrmobj);
						var updation = formValidation(xmlString, last_link);
					//	alert(xmlString);
					}
				}
			}else if(last_link == "DrugCategoryDetails" && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
				
				hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRule;
				mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactorDeductRule.mode.value;
				result = validateDrugCat(hdrfrmobj);
				if(result){
					if(hdrfrmobj != null && hdrfrmobj != undefined){
						var xmlString = formXMLStringMain(hdrfrmobj);
						var updation = formValidation(xmlString, last_link);
					//	alert(xmlString);
					}
				}
			
			}  /* V230210 starts */
			else if(last_link == "ServicesAndItemsCategoryDetails" && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){
				
				hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory;
				mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory.mode.value;
				result = validateServicesAndItemsCat(hdrfrmobj);
				if(result){
					if(hdrfrmobj != null && hdrfrmobj != undefined){
						var xmlString = formXMLStringMain(hdrfrmobj);
						var updation = formValidation(xmlString, last_link);
					//	alert(xmlString);
					}
				}
			
			} /* V230210 ends */
		}
	}	
	if((deduct_Cat != null && deduct_Cat != "") && deduct_Cat == link)
		mode = "modify";
	else
		mode = "insert";
	
	if(result){
		if (link == "DiagnosisCategoryDetails"){
		
			changeMainTabClass(link, parent.MultiFactorDeductRuleTab);
			parent.frames[1].CategoryDtls.location.href = "../../eBL/jsp/BLMulFactDedRuleDiagCatDtls.jsp?mode="
					+ mode;
			document.forms[0].last_link.value = link;
		
		}else if(link == 'DrugCategoryDetails'){
		
			var frmObj = parent.frames[1].frames[0].document.forms[0];
		//	var mode = parent.frames[1].frames[0].document.forms[0].mode.value;
			var index = parent.frames[1].frames[0].document.forms[0].rowCount.value;
			if(last_link == "DiagnosisCategoryDetails") //V230210
				result = validateDiagCat(frmObj);
			else if(last_link == "ServicesAndItemsCategoryDetails")  //V230210
				result = validateServicesAndItemsCat(frmObj);    //V230210
			
			if(result){
			changeMainTabClass(link, parent.MultiFactorDeductRuleTab);
			parent.frames[1].CategoryDtls.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetails.jsp?mode="
				+ mode;
			document.forms[0].last_link.value = link;
			}
		}  /* V230210 starts  */
		else if(link == 'ServicesAndItemsCategoryDetails'){
		
			var frmObj = parent.frames[1].frames[0].document.forms[0];
			var index = parent.frames[1].frames[0].document.forms[0].rowCount.value;
			if(last_link == "DiagnosisCategoryDetails")
				result = validateDiagCat(frmObj);
			else if(last_link == "DrugCategoryDetails")
				result = validateDrugCat(frmObj);
			
			if(result){
			changeMainTabClass(link, parent.MultiFactorDeductRuleTab);
			parent.frames[1].CategoryDtls.location.href = "../../eBL/jsp/BLMFDRServicesAndItemsCatDtls.jsp?mode="
				+ mode;
			document.forms[0].last_link.value = link;
			}
		} /* V230210 ends  */
	}
}

//V221128
function changeMainTabClass(tabObj, tabFrame) {
	
	if (tabFrame.document.forms[0] != null) {
		prevTabObj = tabFrame.document.forms[0].prevTabObj.value;
		if (prevTabObj != null && prevTabObj != "") {
			eval(tabFrame.document.getElementById('prevTabObj')).className = "tabA"
			eval(tabFrame.document.getElementById('prevTabObj') + "span").className = "tabAspan"
		}
		eval(tabFrame.document.getElement('tabObj')).className = "tabClicked"
		eval(tabFrame.document.getElement('tabObj') + "span").className = "tabSpanclicked"
		tabFrame.document.forms[0].prevTabObj.value = tabObj
	}
}

//V221128
function addRowNew(){
	
	var frm = parent.frames[0].document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'DrugCategoryDetails'){
		addRow('DrugCategoryDetailsPage');
	}else if(pageInfo == 'DiagnosisCategoryDetails'){
		addRow('DiagnosisCategoryDetailsPage');
	}  /* V230210 starts */
	else if(pageInfo == 'ServicesAndItemsCategoryDetails'){  
		addRow('ServicesAndItemsCategoryDetails');
	}   /* V230210 ends */
}

function validateDrugCat(formObj){
	
	var index = parseInt(formObj.rowCount.value);
//	var parentDoc = formObj.document;

	for(var i = 1; i <= index; i++){
		
	/*	var epsdEnc = parentDoc.getElementById("episode_"+i).value;
		var pat_Class = parentDoc.getElementById("ptClass_"+i).value;
		var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i).value;
		var payer_desc = parentDoc.getElementById("payer_desc_"+i).value;
		var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i).value;
		var drug_category = parentDoc.getElementById("drug_category_"+i).value;
		var pat_Copay = parentDoc.getElementById("patCopay_"+i).value;
		var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i).value;
		var effFrom = parentDoc.getElementById("effFrom_"+i).value; */
		var epsdEnc = document.getElementById("episode_" + i) ? document.getElementById("episode_" + i).value : "";
        var pat_Class = document.getElementById("ptClass_" + i) ? document.getElementById("ptClass_" + i).value : "";
        var payer_group_desc = document.getElementById("payer_group_desc_" + i) ? document.getElementById("payer_group_desc_" + i).value : "";
        var payer_desc = document.getElementById("payer_desc_" + i) ? document.getElementById("payer_desc_" + i).value : "";
        var policy_type_desc = document.getElementById("policy_type_desc_" + i) ? document.getElementById("policy_type_desc_" + i).value : "";
        var drug_category = document.getElementById("drug_category" + i) ? document.getElementById("drug_category" + i).value : "";
        var pat_Copay = document.getElementById("patCopay_" + i) ? document.getElementById("patCopay_" + i).value : "";
        var patLimitAmt = document.getElementById("patLimitAmt_" + i) ? document.getElementById("patLimitAmt_" + i).value : "";
        var effFrom = document.getElementById("effFrom_" + i) ? document.getElementById("effFrom_" + i).value : "";
		
		var fieldsTop = new Array(epsdEnc,pat_Class,
							payer_group_desc, payer_desc,
							policy_type_desc, drug_category,
							pat_Copay, patLimitAmt, effFrom);
							
		var flag = checkAllMandFields(fieldsTop);
		if(flag){
		if(epsdEnc == "" || payer_group_desc=="" || payer_desc == "" || policy_type_desc == "" || drug_category == "" || pat_Copay == "" || patLimitAmt == "" || effFrom == ""){
			alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
			return false;
		}
		}
	}	
return true;	
}

function validateDiagCat(formObj){
	
	var index = parseInt(formObj.rowCount.value);
	var parentDoc = document;

	for(var i = 1; i <= index; i++){
		
	/*	var epsdEnc = parentDoc.getElementById("episode_"+i).value;
		var pat_Class = parentDoc.getElementById("ptClass_"+i).value;
		var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i).value;
		var payer_desc = parentDoc.getElementById("payer_desc_"+i).value;
		var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i).value;
		var diag_category = parentDoc.getElementById("diag_category_"+i).value;
		var pat_Copay = parentDoc.getElementById("patCopay_"+i).value;
		var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i).value;
		var effFrom = parentDoc.getElementById("effFrom_"+i).value;  */
		var epsdEnc = parentDoc.getElementById("episode_" + i) ? parentDoc.getElementById("episode_" + i).value : "";
        var pat_Class = parentDoc.getElementById("ptClass_" + i) ? parentDoc.getElementById("ptClass_" + i).value : "";
        var payer_group_desc = parentDoc.getElementById("payer_group_desc_" + i) ? parentDoc.getElementById("payer_group_desc_" + i).value : "";
        var payer_desc = parentDoc.getElementById("payer_desc_" + i) ? parentDoc.getElementById("payer_desc_" + i).value : "";
        var policy_type_desc = parentDoc.getElementById("policy_type_desc_" + i) ? parentDoc.getElementById("policy_type_desc_" + i).value : "";
        var diag_category = parentDoc.getElementById("diag_category_" + i) ? parentDoc.getElementById("diag_category_" + i).value : "";
        var pat_Copay = parentDoc.getElementById("patCopay_" + i) ? parentDoc.getElementById("patCopay_" + i).value : "";
        var patLimitAmt = parentDoc.getElementById("patLimitAmt_" + i) ? parentDoc.getElementById("patLimitAmt_" + i).value : "";
        var effFrom = parentDoc.getElementById("effFrom_" + i) ? parentDoc.getElementById("effFrom_" + i).value : "";

		
		var fieldsTop = new Array(epsdEnc,pat_Class,
							payer_group_desc, payer_desc,
							policy_type_desc, diag_category,
							pat_Copay, patLimitAmt, effFrom);
							
		var flag = checkAllMandFields(fieldsTop);
		if(flag){
		if(epsdEnc == "" || payer_group_desc=="" || payer_desc == "" || policy_type_desc == "" || diag_category == "" || pat_Copay == "" || patLimitAmt == "" || effFrom == ""){
			alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
			return false;
		}
		}
	}	
return true;	
}

/* V230210 starts */
function validateServicesAndItemsCat(formObj){
	
	var index = parseInt(formObj.rowCount.value);
//	var parentDoc = formObj.document;

	for(var i = 1; i <= index; i++){
		
		var payer_group_desc = document.getElementById("payer_group_desc_"+i).value ? document.getElementById("payer_group_desc_"+i).value:"";
		var payer_desc = document.getElementById("payer_desc_"+i).value ? document.getElementById("payer_desc_"+i).value:"";
		var policy_type_desc = document.getElementById("policy_type_desc_"+i).value ? document.getElementById("policy_type_desc_"+i).value:"";
		var clinic_cat = document.getElementById("clinic_category_"+i).value ? document.getElementById("clinic_category_"+i).value :"";
		var service_dtls_desc = document.getElementById("service_dtls_desc_"+i).value ? document.getElementById("service_dtls_desc_"+i).value :"";
		var referral = document.getElementById("referral_"+i).value ? document.getElementById("referral_"+i).value :"";		
		var pat_Copay = document.getElementById("patCopay_"+i).value ? document.getElementById("patCopay_"+i).value :"";
		var patLimitAmt = document.getElementById("patLimitAmt_"+i).value ? document.getElementById("patLimitAmt_"+i).value :"";
		var effFrom = document.getElementById("effFrom_"+i).value ? document.getElementById("effFrom_"+i).value :"";
		
		var fieldsTop = new Array(payer_group_desc, payer_desc,
							policy_type_desc, clinic_cat,
							service_dtls_desc, referral, 
							pat_Copay, patLimitAmt, effFrom);
							
		var flag = checkAllMandFields(fieldsTop);
		if(flag){
		if(payer_group_desc=="" || payer_desc == "" || policy_type_desc == "" || clinic_cat == "" || service_dtls_desc == "" || referral == "" || pat_Copay == "" || patLimitAmt == "" || effFrom == ""){
			alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
			return false;
		}
		}
	}
	

return true;

}
/* V230210 ends */


function checkAllMandFields(fieldsTop){
	for(var i = 0; i < fieldsTop.length; i++){
		
		if(!(fieldsTop[i] == "" || fieldsTop[i] == null)){
			return true;
		}
	}
	return false;
}

function fnLoadTabDtls(){
	
	var last_link = document.forms[0].last_link.value;
	var mode = document.forms[0].mode.value;
	var params = document.forms[0].params.value;
	var deduct_Cat = document.forms[0].deduct_Cat.value;
	
	if(deduct_Cat != null && deduct_Cat != ""){
		
		if(deduct_Cat == "DrugCategoryDetails"){
			
			changeMainTabClass(deduct_Cat, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetails.jsp?mode="+ mode+"&params="+params;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
			
			
		}else if(deduct_Cat == "DiagnosisCategoryDetails"){
			
			changeMainTabClass(deduct_Cat, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMulFactDedRuleDiagCatDtls.jsp?mode="+ mode+"&params="+params;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
		}  /* V230210 starts */
		else if(deduct_Cat == "ServicesAndItemsCategoryDetails"){
			
			changeMainTabClass(deduct_Cat, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMFDRServicesAndItemsCatDtls.jsp?mode="+ mode+"&params="+params;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
		} /* V230210 ends */
		else{
			changeMainTabClass(deduct_Cat, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMulFactDedRuleDiagCatDtls.jsp?mode="+ mode+"&params="+params;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
		}
	}else{ 
		
		if(last_link =='DiagnosisCategoryDetails' || last_link == '' || last_link == null)
		{
			changeMainTabClass(last_link, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMulFactDedRuleDiagCatDtls.jsp?mode="+ mode;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp?mode="+ mode;
		}    /* V230210 starts */
		else if(last_link =='DrugCategoryDetails' || last_link == '' || last_link == null){
			changeMainTabClass(last_link, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetails.jsp?mode="+ mode;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
		}   
		else{
			changeMainTabClass(last_link, parent.MultiFactorDeductRuleTab);
			parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.location.href = "../../eBL/jsp/BLMFDRServicesAndItemsCatDtls.jsp?mode="+ mode;
			parent.DrugDiagnosisCategoryDetailsPage.CategoryBtn.location.href = "../../eBL/jsp/BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp";
		}    /* V230210 ends */			
	}
	
}

/* V230210 starts */
function checkForReferralCategory(ref, clinicCat, ind){
	
	var parentDoc = parent.CategoryDtls.document;
	var epsdEnc = '';
	var payer_group_desc = '';
	var payer_desc = '';
	var policy_type_desc = '';
	var clinic_category = ''; 
	var referral = '';
	var serviceDtls = '';
	var clinic_proc_unit = '';
	var clinic_proc_code = '';
	var clinic_proc_desc = '';
	var inclExclCriteria = '';
	var eff_from = '';
	var eff_to = '';
	var flag = 1;
	
	
	var epsdEnc1 = parentDoc.getElementById("episode_"+ind).value;
	var payer_group_desc1 = parentDoc.getElementById("payer_group_desc_"+ind).value;
	var payer_desc1 = parentDoc.getElementById("payer_desc_"+ind).value;
	var policy_type_desc1 = parentDoc.getElementById("policy_type_desc_"+ind).value;
	var clinic_Cat1 = parentDoc.getElementById("clinic_category_"+ind).value;
	var ref1 = parentDoc.getElementById("referral_"+ind).value;
	var service_dtls1 = parentDoc.getElementById("service_dtls_desc_"+ind).value;
	var clinic_proc_unit1 = parentDoc.getElementById("clinic_"+ind).value;
	var clinic_proc_code1 = parentDoc.getElementById("clinic_code_"+ind).value;
//	var clinic_proc_desc1 = parentDoc.getElementById("clinic_desc_"+ind).value;
	var eff_from1 = parentDoc.getElementById("effFrom_"+ind).value;
	for(var i = 1; i < ind; i++){
		
		epsdEnc = parentDoc.getElementById("episode_"+i).value;
		payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i).value;
		payer_desc = parentDoc.getElementById("payer_desc_"+i).value;
		policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i).value;	
		serviceDtls = parentDoc.getElementById("service_dtls_desc_"+i).value;
		clinic_category = parentDoc.getElementById("clinic_category_"+i).value;
		referral = parentDoc.getElementById("referral_"+i).value;
		eff_from = parentDoc.getElementById("effFrom_"+i).value;
		eff_to = parentDoc.getElementById("effTo_"+i).value;
		clinic_proc_unit = parentDoc.getElementById("clinic_"+i).value;
		clinic_proc_code = parentDoc.getElementById("clinic_code_"+i).value;
//		clinic_proc_desc = parentDoc.getElementById("clinic_desc_"+i).value;
	
		
		if(epsdEnc == epsdEnc1){	
			if(payer_group_desc == payer_group_desc1){
				if(payer_desc == payer_desc1){
					if(policy_type_desc == policy_type_desc1){
						if(clinic_proc_unit == clinic_proc_unit1 && clinic_proc_code == clinic_proc_code1 ){
							if(clinic_category == clinicCat.value && referral == ref.value){
								if(eff_to != ''){
									if((eff_from1 >= eff_from) && (eff_from1 <= eff_to)){
										alert(getMessage('BL0980', 'BLEXT'));
										break;										
										
									}
								}else{
									if(eff_from1 == eff_from){	
										alert(getMessage('BL0980', 'BLEXT'));
										break;
										}
								}							
							}
						}
					}
				}
			}
		}
	}		
	
}


async function callBGDesc(sqlSelect, drop, obj, code, obj1) {
	
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	var page_info = document.getElementById('pageInfo').value;
	var i = document.forms[0].rowCount.value;
	var clinic_category = document.getElementById("clinic_category_"+i).value;
	var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
   
    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                
                if (cn == 'C') {
					sql = "Select description, code from (select a.short_desc description,a.clinic_code code from OP_CLINIC_LANG_VW a, op_clinic b WHERE a.LANGUAGE_ID = '" +
                        locale +
                        "' AND a.FACILITY_ID = '" +
                        facility_id +
						"' AND NVL(a.EFF_STATUS,'D') = 'E' AND a.CARE_LOCN_TYPE_IND = 'C' and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and b.category = '" +
						clinic_category +
						"' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    
					title = 'Clinic';
                } else if (cn == 'P') {
                    sql = "Select description, code from (select a.short_desc description,a.clinic_code code from OP_CLINIC_LANG_VW a, op_clinic b WHERE a.LANGUAGE_ID = '" +
                        locale +
                        "' AND a.FACILITY_ID = '" +
                        facility_id +
						"' AND NVL(a.EFF_STATUS,'D') = 'E' AND a.CARE_LOCN_TYPE_IND = 'E' and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and b.category = '" +
						clinic_category +
						"' Union Select 'All Procedure Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    
                    title = 'Procedure Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Procedure Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Procedure Unit';
                }

                break;
            }
    }
	
	argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
	if(code.value != ""){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}else{ 
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
	}
	argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues =await  CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = '';
        code.value = '';
    }	
}

function clearClinic(obj) {
	
    var clinicCode = 'clinic_code_' + obj;
    var clinicDesc = 'clinic_desc_' + obj;
    var clinicNurs = 'clinic_' + obj;
	var clinNursVal = document.getElementById(clinicNurs);
    var clinicBut = 'clinic_but_' + obj;
	document.getElementById(clinicDesc).disabled = false;
    document.getElementById(clinicCode).readonly = false;
	document.getElementById(clinicCode).value = '';
    document.getElementById(clinicDesc).value = '';
	document.getElementById(clinicBut).disabled = false;
    if (clinNursVal.value == 'A') {
		
        document.getElementById(clinicDesc).value = 'All Clinic/ Procedure Unit'; 
        document.getElementById(clinicCode).value = '**';
		document.getElementById(clinicDesc).disabled = true;
        document.getElementById(clinicCode).readonly = true;
        document.getElementById(clinicBut).disabled = true;
    }
}



/* V230210 ends */
