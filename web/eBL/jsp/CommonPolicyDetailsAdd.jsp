<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eBL/js/CommonPolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/CommonPolicyDefinition.js"></script>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function addRowNew(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	//alert('Befor Crash')
	if(pageInfo == 'inclExclCoverage'){
		//alert('InclExcl')
		addRow('InclExcl')
	}
	else if(pageInfo == 'preApproval'){
		//alert('PreApproval')
		addRow('PreApproval')
	}
	else if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}

function save(){
	
	var pageFrom = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
	if(pageFrom == 'inclExclCoverage'){
		var table_id = parent.PolicyDetailsPage.document.getElementById('PolicyInclExcl');
		var totRows = table_id.rows.length;
		totRows = totRows-2;
		for(prevIndex=1;prevIndex<=totRows;prevIndex++){
			var epsdEnc = parent.PolicyDetailsPage.document.getElementById("episode_"+prevIndex).value;
			var patClass = parent.PolicyDetailsPage.document.getElementById("ptClass_"+prevIndex).value;
			var ageGroup = parent.PolicyDetailsPage.document.getElementById("hdn_age_group_"+prevIndex).value;
			var genderCat = parent.PolicyDetailsPage.document.getElementById("gender_"+prevIndex).value;
			var clinicNurs = parent.PolicyDetailsPage.document.getElementById("clinic_"+prevIndex).value;
			var clnCode = parent.PolicyDetailsPage.document.getElementById("clinic_code_"+prevIndex).value;
			var incExcCriteria = parent.PolicyDetailsPage.document.getElementById("incExCriteria_"+prevIndex).value;
			var effFromDate = parent.PolicyDetailsPage.document.getElementById("effFrom_"+prevIndex).value;
			var specCode = parent.PolicyDetailsPage.document.getElementById("spec_code_"+prevIndex).value;
			var prevBillCode  = parent.PolicyDetailsPage.document.getElementById("bg_code_"+prevIndex).value;
			var delFlagC = parent.PolicyDetailsPage.document.getElementById("delFlag"+prevIndex);
			
			if(!(delFlagC.checked)){
				if(epsdEnc.length<1 && patClass.length<1 && ageGroup.length<1 && genderCat.length<1 && clnCode.length<1 && specCode.length<1 && prevBillCode.length<1) {
					
				}
				else if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || specCode.length<1 || prevBillCode.length<1 || effFromDate.length<1) {
					alert("Please enter all mandatory fields for Row Number "+prevIndex);
					return false;
				}
			}		
		}
	}
	else if(pageFrom == 'preApproval'){
		var table_id = parent.PolicyDetailsPage.document.getElementById('PolicyPreApproval');
		var totRows = table_id.rows.length;
		totRows = totRows-1;
		for(prevIndex=1;prevIndex<=totRows;prevIndex++){
			var epsdEnc = parent.PolicyDetailsPage.document.getElementById("episode_"+prevIndex).value;
			var patClass = parent.PolicyDetailsPage.document.getElementById("ptClass_"+prevIndex).value;
			var ageGroup = parent.PolicyDetailsPage.document.getElementById("hdn_age_group_"+prevIndex).value;
			var genderCat = parent.PolicyDetailsPage.document.getElementById("gender_"+prevIndex).value;
			var clinicNurs = parent.PolicyDetailsPage.document.getElementById("clinic_"+prevIndex).value;
			var clnCode = parent.PolicyDetailsPage.document.getElementById("clinic_code_"+prevIndex).value;
			var incExcCriteria = parent.PolicyDetailsPage.document.getElementById("type_"+prevIndex).value;
			var effFromDate = parent.PolicyDetailsPage.document.getElementById("effFrom_"+prevIndex).value;
			var specCode = parent.PolicyDetailsPage.document.getElementById("spec_code_"+prevIndex).value;
			var prevBillCode  = parent.PolicyDetailsPage.document.getElementById("bg_code_"+prevIndex).value;
			var delFlag = parent.PolicyDetailsPage.document.getElementById("delFlag"+prevIndex);
			
			if(!delFlag.checked){
				if(epsdEnc.length<1 && patClass.length<1 && ageGroup.length<1 && genderCat.length<1 && clnCode.length<1 && specCode.length<1 && prevBillCode.length<1) {
					
				}
				else if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || specCode.length<1 || prevBillCode.length<1 || effFromDate.length<1) {
					alert("Please enter all mandatory fields for Row Number "+prevIndex);
					return false;
				}
			}
			
		}
	}
	var frmObj = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
	var key = frmObj.priorityKey.value;
	var facility_id = frmObj.servFacilityId.value;
	var payerGroup = frmObj.payerGroup.value;
	var payer = frmObj.payer.value;
	var policy = frmObj.policy.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,"serviceCoverage",key);
	
	frmObj = parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
	var prevtab = frmObj.prevTab.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,prevtab,key);
	
	frmObj = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frmObj.pageInfo.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,pageInfo,key);
	
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=compareBeans&facility_id="+facility_id+"&payerGroup="+payerGroup+
					"&payer="+payer+"&policy="+policy+"&key="+key;		
	
	var frmObj1 = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
	var polcyOrEnc = frmObj1.prevEncValues.value;
	if(polcyOrEnc.length>0){
		temp_jsp = temp_jsp+"&hdnpatientId="+frmObj1.hdnpatientId.value+
		"&hdnvisitId="+frmObj1.hdnvisitId.value+
		"&hdnacctSeq="+frmObj1.hdnacctSeq.value+
		"&hdnpriority="+frmObj1.hdnpriority.value+
		"&hdnepisodeType="+frmObj1.hdnepisodeType.value+
		"&hdnepisodeId="+frmObj1.hdnepisodeId.value+
		"&hdnpolicyNo="+frmObj1.hdnpolicyNo.value+
		"&plcyOrEnctr=encounter";
	}
	else{
		temp_jsp = temp_jsp+"&plcyOrEnctr=policy";
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	//alert(responseText);
	window.close();
}
</script>
</head>
<body>
<form>
<table width='95%'>
<tr>
<td width='75%' align='left'>
	
</td>
<td align='right' width='9%'>
<input type='button' class="BUTTON" value='Lookup' onClick='fnShowPolicyDetailReport();'>
</td>
<td align='right'  width='5%'>
<!-- <input type='button' class='BUTTON' value='Remove' onclick='removeSelectedRow()'> -->

<input type='button' class='BUTTON' value='Add' onclick='addRowNew()'></td>

<td align='left' width='11%'>
<input type='button' class='BUTTON' value='Save All' onclick='save()'></td>
</tr>
</table>
</form>
</body>
</html>

