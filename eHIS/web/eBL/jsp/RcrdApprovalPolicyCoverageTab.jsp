<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
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
			parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/RcrdApprovalCoverageTabDetails.jsp?prevTab=Outpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
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
			parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/RcrdApprovalCoverageTabDetails.jsp?prevTab=Inpatient&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
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
			parent.ServiceCoverageTabDetails.location.href = '../../eBL/jsp/RcrdApprovalCoverageTabDetails.jsp?prevTab=External&mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&patinetId='+patientId+
							'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
		}
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class="tablistitem" title='<fmt:message key="eBL.OutpatientEmergency.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('Outpatient')" class="tabClicked" id="Outpatient">
					<span class="tabSpanclicked" id="Outpatientspan">
						<fmt:message key="eBL.OutpatientEmergency.label" bundle="${bl_labels}"/>
						</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.InpatientDayCare.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('Inpatient')" class="tabA" id="Inpatient" >
					<span class="tabAspan" id="Inpatientspan">					
					<fmt:message key="eBL.InpatientDayCare.label" bundle="${bl_labels}"/>					
					</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.external.label" bundle="${common_labels}"/>'>
				<a onclick="fnShowMainTabDetails('External')" class="tabA" id="External" >
					<span class="tabAspan" id="Externalspan">					
					<fmt:message key="Common.external.label" bundle="${common_labels}"/>					
					</span></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>

</body>
</html>

