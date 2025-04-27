function fnShowMainTabDetails(object){
	//var params = document.forms[0].params.value;
	//document.forms[0].last_link.value = object;
	if(object == 'ServicePolicy'){
		document.getElementById('MaterialPolicy').className = "tabA";
		document.getElementById('MaterialPolicyspan').className = "tabAspan";
		document.getElementById('ServicePolicy').className = "tabClicked";
		document.getElementById('ServicePolicyspan').className = "tabSpanclicked"
		parent.PolicyCoverageMain.location.href = '../../eBL/jsp/PolicyCoverageMain.jsp';
	}
	else if(object == 'MaterialPolicy'){
		document.getElementById('MaterialPolicy').className = "tabClicked";
		document.getElementById('MaterialPolicyspan').className = "tabSpanclicked";
		document.getElementById('ServicePolicy').className = "tabA";
		document.getElementById('ServicePolicyspan').className = "tabAspan";		
		parent.PolicyCoverageMain.location.href = '../../eBL/jsp/PolicyCoverageMaterial.jsp';
	}
	else if(object == 'Outpatient'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var priorityKey = parent.ServiceCoverageTabDetails.document.forms[0].priorityKey.value;		
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;		
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var policyEncounter = parent.ServiceCoverageTabDetails.document.forms[0].policyEncounter.value;
		var facility_id = parent.ServiceCoverageTabDetails.document.forms[0].facility_id.value;
		
		document.getElementById('Outpatient').className = "tabClicked";
		document.getElementById('Outpatientspan').className = "tabSpanclicked";
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";	
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab,priorityKey);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/CommonServiceCoverageTabDetails.jsp?prevTab=Outpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&priorityKey='+priorityKey+
				'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
				'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if(object == 'Inpatient'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var priorityKey = parent.ServiceCoverageTabDetails.document.forms[0].priorityKey.value;
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;		
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var policyEncounter = parent.ServiceCoverageTabDetails.document.forms[0].policyEncounter.value;
		var facility_id = parent.ServiceCoverageTabDetails.document.forms[0].facility_id.value;
		document.getElementById('Inpatient').className = "tabClicked";
		document.getElementById('Inpatientspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		
		var frmObj = parent.SercviceCoverage.frmPolicyInfo;
		var xmlString=formXMLStringMain(frmObj);
		updation=formValidation(xmlString,"serviceCoverage",priorityKey);
		
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab,priorityKey);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/CommonServiceCoverageTabDetails.jsp?prevTab=Inpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if(object == 'External'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var priorityKey = parent.ServiceCoverageTabDetails.document.forms[0].priorityKey.value;
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;		
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var policyEncounter = parent.ServiceCoverageTabDetails.document.forms[0].policyEncounter.value;
		var facility_id = parent.ServiceCoverageTabDetails.document.forms[0].facility_id.value;
		document.getElementById('External').className = "tabClicked";
		document.getElementById('Externalspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";	
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";
		
		var frmObj = parent.SercviceCoverage.frmPolicyInfo;
		var xmlString=formXMLStringMain(frmObj);
		updation=formValidation(xmlString,"serviceCoverage",priorityKey);
		
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab,priorityKey);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/CommonServiceCoverageTabDetails.jsp?prevTab=External&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if(object == 'inclExclCoverage'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'preApproval'){
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
						var conf = confirm("Please enter all mandatory fields for Row Number "+prevIndex+". Hit ok to proceed, cancel to stay");
						if(conf == false){
							return false;					
						}
					}
				}
				
			}
			
			
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			//Modified for AAKH SCF - 0172
			var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
			var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
			//Modified for AAKH SCF - 0172
			var priorityKey = parent.PolicyDetailsPage.document.forms[0].priorityKey.value;
			var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
			var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
			var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
			var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
			var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;		
			var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
			var policyNo = parent.PolicyDetailsPage.document.forms[0].policyNo.value;
			var policyEncounter = parent.PolicyDetailsPage.document.forms[0].policyEncounter.value;
			var facility_id = parent.PolicyDetailsPage.document.forms[0].facility_id.value;
			document.getElementById('inclExclCoverage').className = "tabClicked";
			document.getElementById('inclExclCoveragespan').className = "tabSpanclicked";
			document.getElementById('preApproval').className = "tabA";
			document.getElementById('preApprovalspan').className = "tabAspan";			
			
			getXMLString('preApproval',priorityKey);
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/CommonPolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
			'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
			'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
		}
	}
	else if(object == 'preApproval'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'inclExclCoverage'){
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
						var conf = confirm("Please enter all mandatory fields for Row Number "+prevIndex+". Hit ok to proceed, cancel to stay");
						if(conf == false){
							return false;					
						}
						
					}
				}		
			}
			
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			//Modified for AAKH SCF - 0172
			var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
			var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
			//Modified for AAKH SCF - 0172
			var priorityKey = parent.PolicyDetailsPage.document.forms[0].priorityKey.value;
			var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
			var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
			var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
			var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
			var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;		
			var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
			var policyNo = parent.PolicyDetailsPage.document.forms[0].policyNo.value;
			var policyEncounter = parent.PolicyDetailsPage.document.forms[0].policyEncounter.value;
			var facility_id = parent.PolicyDetailsPage.document.forms[0].facility_id.value;
			document.getElementById('preApproval').className = "tabClicked";
			document.getElementById('preApprovalspan').className = "tabSpanclicked";
			document.getElementById('inclExclCoverage').className = "tabA";
			document.getElementById('inclExclCoveragespan').className = "tabAspan";	
			
			var frmObj = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
			var xmlString=formXMLStringMain(frmObj);
			updation=formValidation(xmlString,"serviceCoverage",priorityKey);
			
			getXMLString('inclExclCoverage',priorityKey);
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/CommonPolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
			'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
			'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
		}
	}
}

function getXMLString(last_link,priorityKey)	
{
	if(last_link == "Outpatient")
	{
		
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Outpatient",priorityKey);
		
		
		
	}
	else if(last_link == "Inpatient")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Inpatient",priorityKey);
		
	}
	else if(last_link == "External")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"External",priorityKey);
	}
	else if(last_link == "inclExclCoverage")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"inclExclCoverage",priorityKey);	
	}
	
	else if(last_link == "preApproval")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"preApproval",priorityKey);	
	}


	var excln_form = "";
	
	
	
}
