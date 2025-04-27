function statusChange(){
	var claim_status = document.getElementById('claim_status').value;
	
	var queryString = getParameterList();

	if(claim_status == "E"){
		parent.frames[1].location.href = "../../eBL/jsp/RCMStatusInError.jsp?claim_status="+claim_status+queryString;
	}
	else if (claim_status == "D" || claim_status == "R" || claim_status == "G" ) {
		parent.frames[1].location.href = "../../eBL/jsp/RCMClaimsSearchResult.jsp?claim_status="+claim_status+queryString;
		parent.frames[2].location.href = "../../eBL/jsp/RCMClaimsQueryBtn.jsp?claim_status="
				+ claim_status;
	}
}

function getParameterList(){
	
	var facility_id = document.getElementById('facility_id').value;
	if(facility_id == null) facility_id = "";
	var patient_id = document.getElementById('patient_id').value;
	if(patient_id == null) patient_id = "";
	var episode_type = document.getElementById('episode_type').value;
	if(episode_type == null) episode_type = "A";
	var encounter_id = document.getElementById('encounter_id').value;
	if(encounter_id == null) encounter_id = "";
	var spec_nursing_unit_code = document.getElementById('spec_nursing_unit_code').value;
	if(spec_nursing_unit_code == null) spec_nursing_unit_code = "";
	
	var payer_grp_code = document.getElementById('payer_grp_code').value;
	if(payer_grp_code == null) payer_grp_code = "";
	var payer_code = document.getElementById('payer_code').value;
	if(payer_code == null) payer_code = "";
	var policy_type_code = document.getElementById('policy_type_code').value;
	if(policy_type_code == null) policy_type_code = "";
	
	var enc_frm_date = document.getElementById('enc_frm_date').value;
	if(enc_frm_date == null) enc_frm_date = "";
	var enc_to_date = document.getElementById('enc_to_date').value;
	if(enc_to_date == null) enc_to_date = "";
	var doc_gen_from = document.getElementById('doc_gen_from').value;
	if(doc_gen_from == null) doc_gen_from = "";
	var doc_gen_to = document.getElementById('doc_gen_to').value;
	if(doc_gen_to == null) doc_gen_to = "";
	
	var claim_number = document.getElementById('claim_number').value;
	if(claim_number == null) claim_number = "";
	var ins_status = document.getElementById('ins_status').value;
	if(ins_status == null) ins_status = "";
	
	var past_recs_days = document.getElementById('past_recs_days').value;
	if(past_recs_days == null) past_recs_days = "0";
	
	var query_string = "&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&spec_nursing_unit_code="+spec_nursing_unit_code+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&enc_frm_date="+enc_frm_date+"&enc_to_date="+enc_to_date+"&doc_gen_from="+doc_gen_from+"&doc_gen_to="+doc_gen_to+"&claim_number="+claim_number+"&ins_status="+ins_status+"&past_recs_days="+past_recs_days;
	
	return query_string;	
}

function updateSelection(obj,chkbox){
	if(obj.checked)
		chkbox.value = "Y";
	else
		chkbox.value = "N"
}

function selectAllRecs(){
	var total_records = document.getElementById('total_records').value;
	var selectAll = document.getElementById('selectAll').checked;

	for(var i=1;i<=total_records;i++){
		if(selectAll){
			document.getElementById('chkbox_'+i).checked = true;
			document.getElementById('chkbox_'+i).value = "Y";
		}
		else{
			document.getElementById('chkbox_'+i).checked = false;
			document.getElementById('chkbox_'+i).value = "N";
		}
	}
}

function generateDocs(){
	
	var total_records = parent.frames[1].document.getElementById('total_records').value;
	var count = 0;
	
	for(var i=1;i<=total_records;i++){
		if(parent.frames[1].document.getElementById('chkbox_'+i).checked)
			count++;
	}
	
	if(count == 0){
		alert(getMessage("BL9802","BL"));
		return false;
	}
	
	frmObj1=parent.frames[1].document.forms[0];
	
	frmObj1.target = 'messageFrame';
	frmObj1.method = 'post';
	frmObj1.action = "../../servlet/eBL.RCMClaimsMgmtServlet";
	frmObj1.submit();	
}

function viewInsFeedback(){
	var val = document.forms[0].patFile.value;
	alert(val);
	parent.frames[1].location.href = "../../eBL/jsp/RCMInsFeedbackDtls.jsp";
}

function loadButtonPage() {
	var claim_status = document.getElementById('claim_status').value;
	var queryString = document.getElementById('queryString').value;
	if (claim_status == "E") { // In error
		parent.frames[2].location.href = "../../eBL/jsp/RCMClaimsQueryBtn.jsp?"+queryString;
	} else if (claim_status == "D") { // Doc Generated/ To be Reviewed
		parent.parent.frames[2].location.href = "../../eBL/jsp/RCMClaimsQueryBtn.jsp?"+queryString;
	} else if (claim_status == "R") { // Review & Approve
		parent.frames[2].location.href = "../../eBL/jsp/RCMClaimsQueryBtn.jsp?"+queryString;
	} else if (claim_status == "G") { // Generate Claim
		parent.frames[2].location.href = "../../eBL/jsp/RCMClaimsQueryBtn.jsp?"+queryString;
	}
}

function loadServDtls(idx) {
	var rcm_id = document.getElementById("rcm_id"+idx).value;
	var claim_status=document.getElementById("claim_status").value;
	var queryString = document.getElementById('queryString').value;
	parent.frames[1].location.href = "../../eBL/jsp/RCMBillDtls.jsp?rcm_id="+rcm_id+"&claim_status="+claim_status+"&"+queryString;
}

function highlightRow(obj, qryClass) {
	var frm = document.payerresult;
	var rowClicked = frm.rowClicked.value;
	if (rowClicked != obj) {

		if (rowClicked.length > 0) {
			$('#row' + rowClicked + ' td').each(function() {
				$(this).attr('class', 'label');
			});

			$('#row' + rowClicked + ' td span').each(function() {
				$(this).attr('class', 'LABEL');
			});
		}

		$('#row' + obj + ' td').each(function() {
			$(this).attr('class', 'LocalYellow');
		});

		$('#row' + obj + ' td span').each(function() {
			$(this).attr('class', 'SpanYellow');
		});

		frm.checkpayer.value = document.getElementById("chkbox_" + obj).value;
		frm.payergrpdesc.value = document.getElementById("payer_grp_desc"
				+ obj).value;
		frm.payerdesc.value = document.getElementById("payer_desc" + obj).value;
		frm.policytypecode.value = document.getElementById("policy_type_code"
				+ obj).value;
		frm.civilid.value = document.getElementById("civil_id" + obj).value;
		frm.patientid.value = document.getElementById("patient_id" + obj).value;
		frm.patientname.value = document.getElementById("patient_name" + obj).value;
		frm.episodeType.value = document.getElementById("episode_type" + obj).value;
		frm.episodeId.value = document.getElementById("episode_id" + obj).value;
		frm.visitadmdate.value = document
				.getElementById("visit_adm_date" + obj).value;
		frm.checkoutdischdate.value = document
				.getElementById("checkout_disch_date" + obj).value;
		frm.netbillamount.value = document.getElementById("net_bill_amount"
				+ obj).value;
		frm.claimstatus.value = document.getElementById("claim_status_" + obj).value;
		frm.claimstatusdate.value = document.getElementById("claim_status_date"
				+ obj).value;
		frm.folder.value = document.getElementById("folder" + obj).value;
	}
	frm.rowClicked.value = obj;
	loadServDtls(obj);
}

function regeneratePDF() {
	
	var form = parent.RCMQueryResultFrame.RCMClaimsPayerResult.payerresult;
	var total_records = form.document.getElementById('total_records').value;
	var count = 0;
	for(var i=1;i<=total_records;i++){
		if(form.document.getElementById('chkbox_'+i).checked)
			count++;
	}
	
	if(count == 0){
		alert(getMessage("BL9802","BL"));
		return false;
	}
	frmObj1=parent.frames[1].frames[0].document.forms[0];
	
	frmObj1.target = 'messageFrame';
	frmObj1.method = 'post';
	frmObj1.action = "../../servlet/eBL.RCMClaimsMgmtServlet?btn_clicked=regeneratePDF";
	frmObj1.submit();	
}

function generateClaim(){
	var form = parent.RCMQueryResultFrame.RCMClaimsPayerResult.payerresult;
	
	var total_records = form.document.getElementById('total_records').value;
	var count = 0;
	for(var i=1;i<=total_records;i++){
		if(form.document.getElementById('chkbox_'+i).checked)
			count++;
	}
	
	if(count == 0){
		alert(getMessage("BL9802","BL"));
		return false;
	}
	frmObj1=parent.frames[1].frames[0].document.forms[0];
	
	frmObj1.target = 'messageFrame';
	frmObj1.method = 'post';
	frmObj1.action = "../../servlet/eBL.RCMClaimsMgmtServlet?btn_clicked=generateClaim";
	frmObj1.submit();
}

function reviewAppCall() {
	var form = parent.RCMQueryResultFrame.RCMClaimsPayerResult.payerresult;
	var total_records = form.document.getElementById('total_records').value;
	var count = 0;
	for(var i=1;i<=total_records;i++){
		if(form.document.getElementById('chkbox_'+i).checked)
			count++;
	}
	
	if(count == 0){
		alert(getMessage("BL9802","BL"));
		return false;
	}
	frmObj1=parent.frames[1].frames[0].document.forms[0];
	
	frmObj1.target = 'messageFrame';
	frmObj1.method = 'post';
	frmObj1.action = "../../servlet/eBL.RCMClaimsMgmtServlet?btn_clicked=review";
	frmObj1.submit();
}

function revertStatus() {
	var form = parent.RCMQueryResultFrame.RCMClaimsPayerResult.payerresult;
	var total_records = form.document.getElementById('total_records').value;
	var count = 0;
	for(var i=1;i<=total_records;i++){
		if(form.document.getElementById('chkbox_'+i).checked)
			count++;
	}
	
	if(count == 0){
		alert(getMessage("BL9802","BL"));
		return false;
	}
	frmObj1=parent.frames[1].frames[0].document.forms[0];
	
	frmObj1.target = 'messageFrame';
	frmObj1.method = 'post';
	frmObj1.action = "../../servlet/eBL.RCMClaimsMgmtServlet?btn_clicked=revertStatus";
	frmObj1.submit();
}

function folderClick(idx){
	var dataval="";
	var rcmid=document.getElementById('rcm_id'+idx).value;
	$.ajax({
			type:"GET",
			url:"../jsp/RCMClaimsAjax.jsp?functionMode=SinglePDF",
			data:"&rcmid="+rcmid,
			dataType:"text",
			async:false,
			success: function(data){
				dataval=$.trim(data);
				dataval="file:"+dataval;
			},
			 error: function(data){
				alert("error");
		     }
		});
		if(dataval!=''){
			window.open(dataval,'_blank');
		}
}
