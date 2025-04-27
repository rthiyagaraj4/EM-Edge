function fnShowMainTabDetails(object){

	if(object == 'Outpatient'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var auth = parent.ServiceCoverageTabDetails.document.forms[0].auth.value;
		document.getElementById('Outpatient').className = "tabClicked";
		document.getElementById('Outpatientspan').className = "tabSpanclicked";
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";	
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/EncounterServiceCoverageTabDetails.jsp?prevTab=Outpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
									'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
	}
	else if(object == 'Inpatient'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var auth = parent.ServiceCoverageTabDetails.document.forms[0].auth.value;
		document.getElementById('Inpatient').className = "tabClicked";
		document.getElementById('Inpatientspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/EncounterServiceCoverageTabDetails.jsp?prevTab=Inpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
							'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
	}
	else if(object == 'External'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var patientId = parent.ServiceCoverageTabDetails.document.forms[0].patientId.value;
		
		var visitId = parent.ServiceCoverageTabDetails.document.forms[0].visitId.value;
		var acctSeq = parent.ServiceCoverageTabDetails.document.forms[0].acctSeq.value;
		var priority = parent.ServiceCoverageTabDetails.document.forms[0].priority.value;
		var policyNo = parent.ServiceCoverageTabDetails.document.forms[0].policyNo.value;
		var episodeType = parent.ServiceCoverageTabDetails.document.forms[0].episodeType.value;
		var episodeId = parent.ServiceCoverageTabDetails.document.forms[0].episodeId.value;
		var auth = parent.ServiceCoverageTabDetails.document.forms[0].auth.value;
		document.getElementById('External').className = "tabClicked";
		document.getElementById('Externalspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";	
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/EncounterServiceCoverageTabDetails.jsp?prevTab=External&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
	}
	else if(object == 'inclExclCoverage'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'preApproval'){
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
			var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
			var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
			
			var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
			var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
			var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
			var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;
			var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
			var auth = parent.PolicyDetailsPage.document.forms[0].auth.value;
			document.getElementById('inclExclCoverage').className = "tabClicked";
			document.getElementById('inclExclCoveragespan').className = "tabSpanclicked";
			document.getElementById('preApproval').className = "tabA";
			document.getElementById('preApprovalspan').className = "tabAspan";	
			getXMLString('preApproval');
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/EncounterPolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+'&startDate='+startDate+'&endDate='+endDate+
													'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
		}
		
	}
	else if(object == 'preApproval'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'inclExclCoverage'){
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			var patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;
			var startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;
			var endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;
			
			var visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;
			var acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;
			var priority = parent.PolicyDetailsPage.document.forms[0].priority.value;
			var episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;
			var episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;
			var auth = parent.PolicyDetailsPage.document.forms[0].auth.value;
			document.getElementById('preApproval').className = "tabClicked";
			document.getElementById('preApprovalspan').className = "tabSpanclicked";
			document.getElementById('inclExclCoverage').className = "tabA";
			document.getElementById('inclExclCoveragespan').className = "tabAspan";	
			getXMLString('inclExclCoverage');
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/EncounterPolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+'&startDate='+startDate+'&endDate='+endDate+
													'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
		}		
	}
}

function getXMLString(last_link)	
{
	if(last_link == "Outpatient")
	{
		
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"Outpatient");
		
		
		
	}
	else if(last_link == "Inpatient")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"Inpatient");
		
	}
	else if(last_link == "External")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"External");
	}
	else if(last_link == "inclExclCoverage")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"inclExclCoverage");	
	}
	
	else if(last_link == "preApproval")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"preApproval");	
	}


	var excln_form = "";
	
	
	
}
