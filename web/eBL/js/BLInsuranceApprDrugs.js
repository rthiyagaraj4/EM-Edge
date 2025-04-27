function create()
{
	ApprovedDrugsCriteriaFrame.location.href="../../eBL/jsp/BLInsuranceApprDrugsAddModify.jsp?&mode=add";
}

function reset() {
	ApprovedDrugsCriteriaFrame.location.href="../../eBL/jsp/BLInsuranceApprDrugsAddModify.jsp?&mode=add";
}
function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	ApprovedDrugsCriteriaFrame.location.href='../../eBL/jsp/BLInsuranceApprDrugsQueryCriteria.jsp';
	ApprovedDrugsFrame.location.href = '../../eCommon/html/blank.html';
}

function apply()
{	
	var frm = ApprovedDrugsCriteriaFrame.document.forms[0];
	var billingGrp = frm.billingGrp;
	var payerGroup = frm.payerGroup;
	var payer = frm.payer;
	var policyType = frm.policyType;
	
	var billingGrpLbl = getLabel("eBL.BillingGroup.label", "bl");  
	var payerGroupLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
    var payerLbl = getLabel("eBL.PAYER.label", "bl");
	var policyTypeLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
		 
	var fieldsTop = new Array(billingGrp,payerGroup,payer, policyType);
		
	var namesTop = new Array(billingGrpLbl,payerGroupLbl,payerLbl,policyTypeLbl);
		
	var msgFrame = messageFrame;

	var validate = checkFieldsofMst(fieldsTop, namesTop, msgFrame);
	if(validate == false){
		return false;
	}
	
	
	if(validate){
		var frm=ApprovedDrugsCriteriaFrame.document.forms[0];
		 frm.target = 'messageFrame';
		 frm.method = "post";
		 frm.action = "../../servlet/eBL.BLInsApprDrugsMasterServlet";
		 frm.submit(); 
	} 
}

function onSuccess()
{
	if(ApprovedDrugsCriteriaFrame.document.forms[0].mode.value=="insert") 		
		ApprovedDrugsCriteriaFrame.location.href='../../eBL/jsp/BLInsuranceApprDrugsAddModify.jsp?mode=insert';
	else          
		ApprovedDrugsCriteriaFrame.location.reload();
}

function setCheckValue()
{
	if(document.forms[0].status.checked==true)			document.forms[0].status.value="E";
	else			document.forms[0].status.value="D";
}

function appChk(mode, obj) {
	if (obj.checked == true) {
		obj.value = "Y";
		obj.checked = true;
		if (obj.name == "AllYn") {
			document.forms[0].IpYn.checked = true;
			document.forms[0].DcYn.checked = true;
			document.forms[0].OpYn.checked = true;
			document.forms[0].EmYn.checked = true;
			document.forms[0].IpYn.value = "Y";
			document.forms[0].DcYn.value = "Y";
			document.forms[0].OpYn.value = "Y";
			document.forms[0].EmYn.value = "Y";
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
		} else if (obj.name == "IpYn" || obj.name == "DcYn" || obj.name == "OpYn" || obj.name == "EmYn"){
			document.forms[0].AllYn.checked = false;
			document.forms[0].AllYn.value = "N";
		}
	}
}

function loadInsApprovedDrugsSelDrug(drug_code, drug_desc){
		var clickedTab = "";
		var qry_string = "sel_drug_code="+drug_code+"&sel_drug_desc="+drug_desc;	
		//alert(qry_string);
		parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprForSelectedDrug.jsp?"+qry_string;
}

function loadInsApprovedDrugsList(){
		var clickedTab = "";
		var qry_string = "clickedTab="+clickedTab+"&mode=1";	
		parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?"+qry_string;
}

function chkApprAndPatClassSelDrug(obj,drug_code,form_mode, drug_desc){	
	
	if (obj.checked == true) {
		obj.value = "Y";
		if (form_mode == "ALL") {
			document.getElementById('chkIPPatClass').checked = true;
			document.getElementById('chkDCPatClass').checked = true;
			document.getElementById('chkOPPatClass').checked = true;
			document.getElementById('chkEMPatClass').checked = true;
			document.getElementById('chkIPPatClass').value = "Y";
			document.getElementById('chkDCPatClass').value = "Y";
			document.getElementById('chkOPPatClass').value = "Y";
			document.getElementById('chkEMPatClass').value = "Y";
		}
	} else {
		obj.value = "N";
		if (form_mode == "ALL") {
			document.getElementById('chkIPPatClass').checked = false;
			document.getElementById('chkDCPatClass').checked = false;
			document.getElementById('chkOPPatClass').checked = false;
			document.getElementById('chkEMPatClass').checked = false;
			document.getElementById('chkIPPatClass').value = "N";
			document.getElementById('chkDCPatClass').value = "N";
			document.getElementById('chkOPPatClass').value = "N";
			document.getElementById('chkEMPatClass').value = "N";
			
		} else if (form_mode == "IP" || form_mode == "DC" || form_mode == "OP" || form_mode == "EM"){
			document.getElementById('chkAllPatClass').checked = false;
			document.getElementById('chkAllPatClass').value = "N";
		}
	}
	
	var drugCode = drug_code.value;
	var drugDesc = encodeURIComponent(drug_desc.value);
	var apprYN = document.getElementById('apprChk').value;
	var apprAllYN = "N";
	var IPYN = document.getElementById('chkIPPatClass').value;
	var DCYN = document.getElementById('chkDCPatClass').value;
	var OPYN = document.getElementById('chkOPPatClass').value;
	var EMYN = document.getElementById('chkEMPatClass').value;
	var ALLYN = document.getElementById('chkAllPatClass').value;
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=SetSelApprvdDrugsList&sel_drug_code="+drugCode
					+ "&sel_drug_desc="+encodeURIComponent(drugDesc)+"&apprYN="+apprYN+"&IPYN="+IPYN+"&DCYN="+DCYN+"&OPYN="+OPYN+"&EMYN="+EMYN+"&ALLYN="+ALLYN;

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	
	var retVal = trimString(xmlHttp.responseText);	

	var url = "BLInsuranceApprDrugsValidate.jsp?drugCode="+drugCode+"&drugDesc="+drugDesc+"&form_mode="+form_mode+"&apprYN="+apprYN+"&apprAllYN="+apprAllYN+"&IPYN="+IPYN+"&DCYN="+ DCYN+"&OPYN="+OPYN+"&EMYN="+EMYN+"&ALLYN="+ALLYN;
	
	var xmlDoc = "" ;
	//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
}
