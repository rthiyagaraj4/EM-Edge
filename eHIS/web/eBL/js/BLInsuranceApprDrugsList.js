/*
Sr No     Version        Incident			SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1          V220525							GHL-CRF-0632     		Mohanapriya
-----------------------------------------------------------------------------------
*/
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var invalidCode = "";

function populateValues()
{
	var localeName = document.ind_serv_cancel.localeName.value;
	var order_category = document.ind_serv_cancel.order_category.value
	var clickedTab = "SEARCH";
	qry_string = "order_category="+order_category+"&clickedTab="+clickedTab+"&mode=1";	
	
	if(order_category!="")
		parent.indirect_serv_cancel.location.href = "../jsp/IndirectServCancel.jsp?"+qry_string
	else
		parent.indirect_serv_cancel.location.href = "../../eCommon/html/blank.html"
}

function assignResult(_result, _message, _flag)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
}


function assignResult(_result,_message, _flag, invCode)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}

function reset()
{
	indirectServCancelFrame.location.reload();
	indirect_serv_cancel.location.href = "../../eCommon/html/blank.html";
}

function checkIsValidForProceed()
{
	var url = indirect_serv_cancel.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function apply() 
{	
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID","BL");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}

    var formObj = indirect_serv_cancel.document.indirect_order_status;
	eval(formApply(indirect_serv_cancel.document.indirect_order_status, "../../eBL/jsp/IndirectServSubmit.jsp"));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ messageGlobal;	   
	if(resultGlobal){
	  onSuccess();
	}
}


function onSuccess() 
{
}

function submitPrevNext(from, to){
	document.indirect_order_status.from.value = from;
	document.indirect_order_status.to.value = to; 
	document.indirect_order_status.submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

function checkAll(obj){

	var frm = parent.ApprovedDrugsCriteriaFrame.document.forms[0];
	
	var billingGrp = frm.billingGrp.value;
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policyType = frm.policyType.value;

	if(billingGrp == "" || payerGroup == "" || payer == "" || policyType == ""){
		alert(getMessage("ALL_MANDATORY_FIELDS","common"));
		if(obj.checked)
			obj.checked = false;
		else
			obj.checked = true;
		return false;
	}

	if(obj.checked == true)
		obj.value = "Y";
	else
		obj.value="N";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","BLInsuranceApprDrugsValidate.jsp?checkAll="+obj.value,false);
	xmlHttp.open("POST","BLInsuranceApprDrugsValidate.jsp?drugCode=X&form_mode=ApprAllDrugs&ApprAllYN="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
	
	var clickedTab = "";
	var mode = document.forms[0].mode.value;
	var qry_string = "clickedTab="+clickedTab+"&mode="+mode+"&selectAllYN="+obj.value;	
	parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?"+qry_string;	
}

function checkApprValue(obj,drug_code,form_mode, drug_desc){
	
	var frm = parent.ApprovedDrugsCriteriaFrame.document.forms[0];
	
	var billingGrp = frm.billingGrp.value;
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policyType = frm.policyType.value;
	
	if(billingGrp == "" || payerGroup == "" || payer == "" || policyType == ""){
		alert(getMessage("ALL_MANDATORY_FIELDS","common"));
		if(obj.checked)
			obj.checked = false;
		else
			obj.checked = true;
		return false;
	}

	if(obj.checked == true)
		obj.value = "Y";
	else
		obj.value="N";

	var drugCode = drug_code.value;
	var drugDesc = encodeURIComponent(drug_desc.value);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","BLInsuranceApprDrugsValidate.jsp?drugCode="+drugCode+"&form_mode="+form_mode+"&apprYN="+ obj.value+"&drugDesc="+drugDesc,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
}

function chkApprAndPatClass(obj,drug_code,form_mode, drug_desc, index){	
	var frm = parent.ApprovedDrugsCriteriaFrame.document.forms[0];
	
	var billingGrp = frm.billingGrp.value;
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policyType = frm.policyType.value;
	
	if(billingGrp == "" || payerGroup == "" || payer == "" || policyType == ""){
		alert(getMessage("ALL_MANDATORY_FIELDS","common"));
		if(obj.checked)
			obj.checked = false;
		else
			obj.checked = true;
		return false;
	}
	
	if (obj.checked == true) {
		obj.value = "Y";
		if (form_mode == "ALL") {
			document.getElementById('chkIPPatClass_'+index).checked = true;
			document.getElementById('chkDCPatClass_'+index).checked = true;
			document.getElementById('chkOPPatClass_'+index).checked = true;
			document.getElementById('chkEMPatClass_'+index).checked = true;
			document.getElementById('chkIPPatClass_'+index).value = "Y";
			document.getElementById('chkDCPatClass_'+index).value = "Y";
			document.getElementById('chkOPPatClass_'+index).value = "Y";
			document.getElementById('chkEMPatClass_'+index).value = "Y";
		}
	} else {
		obj.value = "N";
		if (form_mode == "ALL") {
			document.getElementById('chkIPPatClass_'+index).checked = false;
			document.getElementById('chkDCPatClass_'+index).checked = false;
			document.getElementById('chkOPPatClass_'+index).checked = false;
			document.getElementById('chkEMPatClass_'+index).checked = false;
			document.getElementById('chkIPPatClass_'+index).value = "N";
			document.getElementById('chkDCPatClass_'+index).value = "N";
			document.getElementById('chkOPPatClass_'+index).value = "N";
			document.getElementById('chkEMPatClass_'+index).value = "N";
			
		} else if (form_mode == "IP" || form_mode == "DC" || form_mode == "OP" || form_mode == "EM"){
			document.getElementById('chkAllPatClass_'+index).checked = false;
			document.getElementById('chkAllPatClass_'+index).value = "N";
		}
	}
	
	var drugCode = drug_code.value;
	var drugDesc = encodeURIComponent(drug_desc.value);
	var apprYN = document.getElementById('apprChk_'+index).value;
	var apprAllYN = document.getElementById('apprAll').value;
	var IPYN = document.getElementById('chkIPPatClass_'+index).value;
	var DCYN = document.getElementById('chkDCPatClass_'+index).value;
	var OPYN = document.getElementById('chkOPPatClass_'+index).value;
	var EMYN = document.getElementById('chkEMPatClass_'+index).value;
	var ALLYN = document.getElementById('chkAllPatClass_'+index).value;

	var url = "BLInsuranceApprDrugsValidate.jsp?drugCode="+drugCode+"&drugDesc="+drugDesc+"&form_mode="+form_mode+"&apprYN="+apprYN+"&apprAllYN="+apprAllYN+"&IPYN="+IPYN+"&DCYN="+ DCYN+"&OPYN="+OPYN+"&EMYN="+EMYN+"&ALLYN="+ALLYN;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
	
	if(form_mode == 'ApprAllDrugs'){
		var clickedTab = "";
		var mode = document.forms[0].mode.value;
		var qry_string = "clickedTab="+clickedTab+"&mode="+mode+"&selectAllYN="+obj.value;	
		parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?"+qry_string;		
	}
}

function loadSelRowsToSession(){
	var drugCode = "";
	var drugDesc = "";
	var apprYN = "";
	var apprAllYN = "";
	var IPYN = "";
	var DCYN = "";
	var OPYN = "";
	var EMYN = "";
	var ALLYN = "";
	var form_mode = "";
	
	var url = "BLInsuranceApprDrugsValidate.jsp?calledFrm=Q&drugCode="+drugCode+"&drugDesc="+drugDesc+"&form_mode="+form_mode+"&apprYN="+apprYN+"&apprAllYN="+apprAllYN+"&IPYN="+IPYN+"&DCYN="+ DCYN+"&OPYN="+OPYN+"&EMYN="+EMYN+"&ALLYN="+ALLYN;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
}
