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
		var mode = parent.ServiceCoverageTabDetails.document.getElementById('mode').value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.getElementById('payerGroup').value;
		var payer = parent.ServiceCoverageTabDetails.document.getElementById('payer').value;
		var policy = parent.ServiceCoverageTabDetails.document.getElementById('policy').value;
		var auth = parent.ServiceCoverageTabDetails.document.getElementById('auth').value;
		document.getElementById('Outpatient').className = "tabClicked";
		document.getElementById('Outpatientspan').className = "tabSpanclicked";
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";	
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/ServiceCoverageTabDetails.jsp?prevTab=Outpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&auth='+auth;
	}
	else if(object == 'Inpatient'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var auth = parent.ServiceCoverageTabDetails.document.forms[0].auth.value;
		document.getElementById('Inpatient').className = "tabClicked";
		document.getElementById('Inpatientspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";
		document.getElementById('External').className = "tabA";
		document.getElementById('Externalspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/ServiceCoverageTabDetails.jsp?prevTab=Inpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&auth='+auth;
	}
	else if(object == 'External'){
		var mode = parent.ServiceCoverageTabDetails.document.forms[0].mode.value;
		var payerGroup = parent.ServiceCoverageTabDetails.document.forms[0].payerGroup.value;
		var payer = parent.ServiceCoverageTabDetails.document.forms[0].payer.value;
		var policy = parent.ServiceCoverageTabDetails.document.forms[0].policy.value;
		var auth = parent.ServiceCoverageTabDetails.document.forms[0].auth.value;
		document.getElementById('External').className = "tabClicked";
		document.getElementById('Externalspan').className = "tabSpanclicked";
		document.getElementById('Outpatient').className = "tabA";
		document.getElementById('Outpatientspan').className = "tabAspan";	
		document.getElementById('Inpatient').className = "tabA";
		document.getElementById('Inpatientspan').className = "tabAspan";
		var prevTab = parent.ServiceCoverageTabDetails.frmServiceTabDetails.prevTab.value;
		getXMLString(prevTab);
		parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/ServiceCoverageTabDetails.jsp?prevTab=External&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&auth='+auth;
	}
	else if(object == 'inclExclCoverage'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'preApproval'){
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			var startDate = parent.PolicyInfoFrame.document.forms[0].startDate.value;
			var endDate = parent.PolicyInfoFrame.document.forms[0].endDate.value;
			var auth = parent.PolicyDetailsPage.document.forms[0].auth.value;
			document.getElementById('inclExclCoverage').className = "tabClicked";
			document.getElementById('inclExclCoveragespan').className = "tabSpanclicked";
			document.getElementById('preApproval').className = "tabA";
			document.getElementById('preApprovalspan').className = "tabAspan";	
			getXMLString('preApproval');
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/PolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&auth='+auth;
		}				
	}
	else if(object == 'preApproval'){
		var pageInfo = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;
		if(pageInfo == 'inclExclCoverage'){
			var mode = parent.PolicyDetailsPage.document.forms[0].mode.value;
			var payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;
			var payer = parent.PolicyDetailsPage.document.forms[0].payer.value;
			var policy = parent.PolicyDetailsPage.document.forms[0].policy.value;
			var startDate = parent.PolicyInfoFrame.document.forms[0].startDate.value;
			var endDate = parent.PolicyInfoFrame.document.forms[0].endDate.value;
			var auth = parent.PolicyDetailsPage.document.forms[0].auth.value;
			document.getElementById('preApproval').className = "tabClicked";
			document.getElementById('preApprovalspan').className = "tabSpanclicked";
			document.getElementById('inclExclCoverage').className = "tabA";
			document.getElementById('inclExclCoveragespan').className = "tabAspan";	
			getXMLString('inclExclCoverage');
			parent.PolicyDetailsPage.location.href = '../../eBL/jsp/PolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&auth='+auth;
		}				
	}
}

function getXMLString(last_link)	
{
	if(last_link == "Outpatient")
	{
		
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Outpatient");
		
		
		
	}
	else if(last_link == "Inpatient")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Inpatient");
		
	}
	else if(last_link == "External")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
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
