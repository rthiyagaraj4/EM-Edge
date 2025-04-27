async function callCommonValidation(sqlSelect, obj, code) {
	//alert("10");
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    
    switch (sqlSelect) {
        case 1:
        {
            var cust_code = document.forms[0].payergrpCode.value;
            
            sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
            "Where Cust_Code In ( SELECT cust_code " +
            "FROM bl_cust_by_cust_group " +
            "WHERE cust_group_code = " +
            "DECODE ('" +
            cust_code +
            "', " +
            "'**', cust_group_code, '" +
            cust_code +
            "')) " +
            "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
            facility_id +
            "') " +
            "and nvl(patient_flag,'N')  ='Y' " +
            "and nvl(pat_com_flag,'N')='N' " +
            "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
            "and upper(language_id) = upper('" +
            locale +
            "')) where upper(description) like upper(?) and upper(code) like upper(?) ";

            title = 'Payer';
            break;
        }
        case 2:
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
            "') ) where upper(description) like upper(?) and upper(code) like upper(?) " +
            " order by 2";

            title = 'Payer Group';
            break;
        }
        case 3:
        {
            sql = "select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '" +
            facility_id +
            "' and upper(language_id) = upper('" +
            locale +
            "') and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
            title = 'Policy';
            break;
        }
			
		case 4:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"') where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
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

    returnedValues = await CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
		
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
		
		if(sqlSelect == 4)
		{
			var cnt=1;//chkStatus(code);
			if(cnt>0) {
				document.forms[0].payerGroup1.disabled=true;
				document.forms[0].payerGroup2_btn.disabled=true;
				document.forms[0].payerGroup1_btn.disabled=true;
				document.forms[0].policyType_btn.disabled=true;
				document.forms[0].policyType.disabled=true;
				document.forms[0].payerGroup2.disabled=true;
			} else {
				document.forms[0].payerGroup1.disabled=false;
				document.forms[0].payerGroup2_btn.disabled=false;
				document.forms[0].payerGroup1_btn.disabled=false;
				document.forms[0].policyType_btn.disabled=false;
				document.forms[0].policyType.disabled=false;
				document.forms[0].payerGroup2.disabled=false;
			}
		}
    } else {
        obj.value = '';
        code.value = '';
    }
}


/*function onSuccess()
{

	if(MultiPkgDiscCreate.document.forms[0].mode.value=="insert") 	
	{
		MultiPkgDiscCreate.location.href='../../eBL/jsp/MultiPkgDiscCreate.jsp?mode=insert';
	}
	
			
commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?menu_id=EBL_DFLT&module_id=BL&function_id=EBL_MULTI_PKG_DISC&function_name=Multi Package Discount&function_type=F&access=YYYNN';
			
	

}
*/


function reset() {
	/*if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MultiPkgDiscCreate.jsp") != -1){


				 if(MultiPkgDiscCreate.document.location.href.indexOf("MultiPkgDiscMain.jsp") != -1)
					  return false;
				 else
					 	 MultiPkgDiscCreate.document.forms[0].reset();
					 
					 
		MultiPkgDiscCreate.document.forms[0].multipkgdisc.value="0";
	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MultiPkgDiscQueryCriteria.jsp") != -1)
	{
		 MultiPkgDiscCreate.document.forms[0].reset();
	}*/
	
	PolicyAppQueryCriteria.location.reload();
	PolicyAppQueryResult.location.href = "../../eCommon/html/blank.html";
}

function query()
{
	PolicyAppQueryCriteria.location.href='../../eBL/jsp/PolicyAppQueryCriteria.jsp';
	PolicyAppQueryResult.location.href = "../../eCommon/html/blank.html";
}
function search(obj)
{
	var payerGrpCode=parent.PolicyAppQueryCriteria.document.forms[0].payerGrpCode.value;
	if(payerGrpCode.length <= 0) {
		alert(getMessage("BL6277","BL"));
		return;
	}
	var policyTypeCode=parent.PolicyAppQueryCriteria.document.forms[0].policyTypeCode.value;
	var payerCode=parent.PolicyAppQueryCriteria.document.forms[0].payerCode.value;
	var applicalbleTo=parent.PolicyAppQueryCriteria.document.forms[0].applicalbleTo.value;
	
	var fromRcrd="", toRcrd=""; 
	
	var params=payerGrpCode="&payerGrpCode=" + payerGrpCode 
						+ "&policyTypeCode=" +policyTypeCode+ "&payerCode=" + payerCode
						+ "&applicalbleTo=" + applicalbleTo+"&mode=search";
	if(obj == "reload") {
		if(parent.PolicyAppQueryResult.document.forms[0].fromRcrd != undefined) {
			fromRcrd = parent.PolicyAppQueryResult.document.forms[0].fromRcrd.value;//Added V191022-Aravindh/NMC-JD-CRF-0010.2
			toRcrd	 = parent.PolicyAppQueryResult.document.forms[0].toRcrd.value;//Added V191022-Aravindh/NMC-JD-CRF-0010.2
		}
		params = params + "&fromRcrd="+fromRcrd+"&toRcrd="+toRcrd;
	}
	//alert(params);
	parent.PolicyAppQueryResult.location.href= "../../eBL/jsp/PolicyAppQueryResult.jsp?params=" + params;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

function apply() {
	var rsltFormObj = PolicyAppQueryResult.document.policyQryResultfrm;
	var xmlString = formXMLStringMain(rsltFormObj);
	var updation = formValidation(xmlString, "APPLY");
	if(updation == true) {
		PolicyAppQueryResult.document.forms[0].target = 'messageFrame';
		PolicyAppQueryResult.document.forms[0].method = 'post';
		PolicyAppQueryResult.document.forms[0].action = "../../servlet/eBL.PolicyApprovalServlet";
		PolicyAppQueryResult.document.forms[0].submit();
		reset();
	}
}


function formXMLStringMain(frmObj) {
	var xmlStr = "";
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
		xmlStr = "<root><SEARCH ";
		if (true) {
			var arrObj = frmObj.elements;
			for ( var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					val = arrObj[i].checked;
					if (val == true || val == "true") {
						val = "Y";
					} else {
						val = "N";
					}
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
							val += arrObj[i].options[j].value + "~";
					}
					val = val.substring(0, val.lastIndexOf('~'));
					if (arrObj[i].name != null && arrObj[i].name != "")
						;
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) + "\" ";
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

function formValidation(xmlStr, last_link) {
	var temp_jsp = "PolicyApprovalValidation.jsp?func_mode=" + last_link;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	return true;
}

/*function onSuccess()
{

	if(PolicyAppQueryResult.document.forms[0].mode.value=="insert") 	
	{
		PolicyAppQueryResult.location.href='../../eCommon/html/blank.html';
	}

}*/

function focusObject() {
	document.forms[0].elements[0].focus();
}

function addOrderByCol() {
	var i = 0;
	var from = document.getElementById('orderbycols');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycolumns');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i])
			from.options[i].selected = true;
		i++;
	}
}

function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById('orderbycolumns');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycols');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j])
			from.options[j].selected = true;
		j++;
	}
}

function SelectAll() {
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex = 0;
	while (i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected = true;
		i++;
	}
}

function execQuery() {
	if (document.getElementById("orderbycolumns").options.length > 0) {
		SelectAll();
		document.multiPkgCreate.submit();
	} else {
		alert(getMessage('ORDERBY_NOT_BLANK', 'Common'));
	}
}

function clearPolicyFields(obj){
	obj.value = '';
}

async function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)
{		
//alert("billGrpLkup 1 "+empty_chk);
	if(empty_chk=='Y' && billGrp_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var target			= document.forms[0].billingGrp;		
	var title			= getLabel("eBL.BillingGroup.label","BL");

	var sql1="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";	
   	argArray[5] = target.value;	    
	argArray[6] = DESC_LINK;	
	argArray[7] = DESC_CODE;
	
	retArray = await CommonLookup( title, argArray );	
	var ret1=unescape(retArray);
	var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					retArray[0]="";	
					retArray[1]="";	
				}	

	if(retArray != null && retArray !="") {					
		billGrp_id.value=arr[0];
		billGrp_desc.value=arr[1];								
	} else {
		//billGrp_id.value="";
		//billGrp_desc.value="";	
		
			billGrp_id.value = arr[0]; 
			billGrp_desc.value = arr[1];
	}
	
}

async function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)
{		
//alert("inside payerlookup"+pyrGrp_desc);
	if(empty_chk=='Y' && pyrGrp_desc.value=='')
	{
		pyrGrp_code.value="";
		return false;
	}

	var locale  = document.forms[0].locale.value;	
	var target			= document.forms[0].payerGroup;		
	var title			= getLabel("eBL.PAYER_GROUP.label","BL");

	var sql1="select cust_group_code code,short_desc description from ar_cust_group_lang_vw  where  language_id='"+locale+"' and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";		
   	argArray[5] = target.value;   
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;
	
	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retArray);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="") {	
	//alert("inside if");
		pyrGrp_code.value=arr[0];
		pyrGrp_desc.value=arr[1];
	} else {
		//alert("inside else");
		//pyrGrp_code.value="";
		//pyrGrp_desc.value="";	
		 pyrGrp_code.value = arr[0]; 
			pyrGrp_desc.value = arr[1]; 
			
			
	}
	
}

async function payerlkup(payer_desc,payer_code,empty_chk)
{			
//alert("show1");
	if(empty_chk=='Y' && payer_desc.value=='')
	{
		payer_code.value="";
		return false;
	}
	
	var target			= document.forms[0].payer;	
	
	var title			= encodeURIComponent(getLabel("Common.Payer.label","common"));
	var locale  = document.forms[0].locale.value;

	var cust_group_code=document.forms[0].payerGrpCode.value;
	var sql1="select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = '"+locale+"'   and cust_group_code = '"+cust_group_code+"' and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1";
		
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;					
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;
	
	retArray = await CommonLookup( title, argArray );	
	var ret1=unescape(retArray);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}	
	
	if(retArray != null && retArray !="") {		
//alert("inside if");	
		payer_code.value=arr[0];
		payer_desc.value=arr[1];								
	} else {
		//alert("inside else");
		payer_code.value = arr[0]; 
			payer_desc.value = arr[1]; 	
	}
}

async function policyLkup(policy_desc,policy_code,empty_chk)
{		
//alert("plicy");
	if(empty_chk=='Y' && policy_desc.value=='')
	{
		policy_code.value="";
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].policyType;		
	var title			= getLabel("eBL.POLICY.label","BL");

	var cust_group_code= document.forms[0].payerGrpCode.value;
	var cust_code= document.forms[0].payerCode.value;
	
	var sql1=" select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+
		" AND b.cust_group_code =  '"+cust_group_code+"'  AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
		" AND a.policy_type_code = b.policy_type_code "+
		" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
		" AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 ";

	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";	
   	argArray[5] = target.value;	
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = await CommonLookup( title, argArray );		
var ret1=unescape(retArray);
	//alert("ret12"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}	
	if(retArray != null && retArray !="") {					
		policy_code.value=arr[0];
		policy_desc.value=arr[1];								
	} else {
		//policy_code.value="";
		//policy_desc.value="";	
		//alert("inside else");
		policy_code.value = arr[0]; 
			policy_desc.value = arr[1];
	}
}

function checkAll(obj) {
	var fromRcrd = document.getElementById("fromRcrd").value;
	var toRcrd = document.getElementById("toRcrd").value;
	var nonApprvdPlcyErrMsg = "";
	var frmObj = document.forms[0];
	if (document.getElementById('chkAll').checked == true) {
		for ( var i = fromRcrd-1; i < toRcrd; i++) {
			if (document.getElementById("chk_" + i) != undefined
					&& document.getElementById("chk_" + i) != 'undefined'
					&& document.getElementById("chk_" + i) != null
					&& document.getElementById("chk_" + i) != 'null') {
				//document.getElementById("chk_" + i).checked = true;
				var status = true;
				status = doUserAuthenticationValidationPayerApprove(document.getElementById("chk_" + i), i, "all");
				if(status == true) {
					document.getElementById("chk_" + i).checked = true;
				} else {
					if(nonApprvdPlcyErrMsg != "") {
						nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + ", ";
					}
					var policy_type_desc= eval("frmObj.policyDesc_"+i);
					nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + policy_type_desc.value;
				}
			}
		}
		if(nonApprvdPlcyErrMsg != "") {
			alert(getMessage("BL0838","BL")+". "+nonApprvdPlcyErrMsg);
		}
		chkIndividualItem();
	} else {
		for ( var i = fromRcrd-1; i < toRcrd; i++) {
			if (document.getElementById("chk_" + i) != undefined
					&& document.getElementById("chk_" + i) != 'undefined'
					&& document.getElementById("chk_" + i) != null
					&& document.getElementById("chk_" + i) != 'null') {
				//document.getElementById("chk_" + i).checked = false;
				var status = true;
				status = doUserAuthenticationValidationPayerApprove(document.getElementById("chk_" + i), i, "all");
				if(status == true) {
					document.getElementById("chk_" + i).checked = false;
				} else {
					if(nonApprvdPlcyErrMsg != "") {
						nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + ", ";
					}
					var policy_type_desc= eval("frmObj.policyDesc_"+i);
					nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + policy_type_desc.value;
				}
			}
		}
		if(nonApprvdPlcyErrMsg != "") {
			alert(getMessage("BL0838","BL")+". "+nonApprvdPlcyErrMsg);
		}
		chkIndividualItem();
	}
}

function chkIndividualItem() {
	var fromRcrd = document.getElementById("fromRcrd").value;
	var toRcrd = document.getElementById("toRcrd").value;
	var flag = 0;
	for(var i = fromRcrd-1 ; i < toRcrd ; i++) {
		if (document.getElementById("chk_" + i) != undefined
				&& document.getElementById("chk_" + i) != 'undefined'
				&& document.getElementById("chk_" + i) != null
				&& document.getElementById("chk_" + i) != 'null') {
			if(document.getElementById("chk_"+i).checked == true) {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
		}
	}
	
	if(flag == 0) {
		document.getElementById('chkAll').checked = false;
	} else {
		document.getElementById('chkAll').checked = true;
	}
}

function doUserAuthenticationValidationPayerApprove(obj, selectedIndex, type) {
	var frmObj = document.forms[0];

	var payerCode = eval("frmObj.custGrp_"+selectedIndex);
	var payer = eval("frmObj.cust_"+selectedIndex);
	var policy = eval("frmObj.policy_"+selectedIndex);
	
    var temp_jsp = "../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=POLICY_DEFN_APPROVE";
    
    if (payerCode != undefined && payerCode != null) {
        temp_jsp += "&payerCode=" + payerCode.value;
    }
    if (payer != undefined && payer != null) {
        temp_jsp += "&payer=" + payer.value;
    }
    if (policy != undefined && policy != null) {
        temp_jsp += "&policy=" + policy.value;
    }
    
    var xmlString = formXMLStringMain(frmObj);
    var updation = formPayerValidation(xmlString, temp_jsp);
    
    if(updation == true) {
    	frmObj.validUserApprvUnApprv.value = "true";
    } else {
    	frmObj.validUserApprvUnApprv.value = "false";
    }
    
	if(frmObj.validUserApprvUnApprv.value != "true") {
    	if(type == "ind") {
			obj.checked = !obj.checked;
			alert(getMessage('BL0838', 'BL'));
		} else {
			return false;
			//obj.checked = false;
		}
    }
	return true;
}

function formPayerValidation(xmlStr, temp_jsp) {
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = xmlHttp.responseText;
    /*
     * If the given users authentication returns true then string @@@SUCCESS@@@
     * will be present in the response HTML else string @@@FAILED@@@ will be
     * present
     */
    if (responseText.indexOf('@@@SUCCESS@@@') == -1) { // If success string is
        // not found return false
        return false;
    } else {
        return true;
    }
}

//Added V191016-Aravindh/NMC-JD-CRF-0010.2/showPolicyDef
async function showPolicyDef(payergroupCode, payerCode, policyCode, polStartDate, polEndDate){
	//alert("function");
	var url = '../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=modify&calledForm=policyApproval&payergroupCode='+payergroupCode+'&payerCode='+payerCode+
				'&policyCode='+policyCode+'&startDate='+polStartDate+'&endDate='+polEndDate;
	var arguments = "";
	
	var dialogHeight = "1200px";//40
    var dialogWidth = "1600px";//90
    var dialogTop = "10px";//20
    var scroll = "yes";
    var center = "1";
    var status = "no";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" +
				 dialogWidth + "; center: " + center + "; status: " + status +
				 "; dialogTop :" + dialogTop + "; scroll: " + scroll;
	
	var title=encodeURIComponent(getLabel("eBL.POLICY_DTL.label","BL"));
	url = url + "&title="+title;
	
	//var retModalVal = "";
	retModalVal = await window.showModalDialog(url, arguments, features);
	
	//if(retModalVal == 1) {
		search("reload");
	//}
}
