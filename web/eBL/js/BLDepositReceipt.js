function checkAlpha(event){
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}
function checkFrNumber(obj){
	
	if(isNaN(obj.value)){
		alert(getMessage('BL8532','BL'));
		obj.select();
		document.forms[0].cash_return.value="";
		//$('#cash_return').val('');
		
	}
} 


function checkForNumber(obj){
	if(isNaN(obj.value)){
		alert(getMessage('BL8532','BL'));
		obj.select();
	}
	
}
function ChkNumberInputDeposit(fld, e, deci,recref)
{
	//alert(deci);
	if (parseInt(deci)>0)
		{
		if(recref=='F')
			{
   var strCheck = '.0123456789-';
			}		
		else
			{
			var strCheck = '.0123456789';
			}
		}
   else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code


if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}

async function originaldocnum()
{
	
	var formObj=document.EnterReceiptRefundForm;
	var patient_id=formObj.patient_id.value;
	var episode_id=formObj.episode_id.value;
	var episode_type=formObj.episode_type.value;
	var encounter_id=formObj.encounter_id.value;
	var visit_id=formObj.visit_id.value;
	var recpt_nature_code=formObj.receipt_nature_code.value
	
	if(recpt_nature_code=='')
		{
		
		alert(getMessage("BL00001","BL"));
		return false;
		}
	
	var url="../../eBL/jsp/BLOriginalDocNumber.jsp?patient_id="+patient_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&recpt_nature_code="+recpt_nature_code;
	
	var dialogHeight= "30vh" ;
	var dialogWidth	= "65vw" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=no; center:yes";
	var retVal =await window.showModalDialog(url,null,features);  
	var stlmt_amnt=formObj.stlmt_amount.value;
	if(retVal=='undefined' || retVal==undefined)
		{
		//formObj.stlmt_amount.value =stlmt_amnt;
		}
	else
		{
		
		var parts = retVal.split(',');
		for (var i = 0; i < parts.length; i++) {
		    parts[i] = parts[i].replace(/^\s+|\s+$/g, '');  // Trim leading and trailing spaces
		}
		var cleanedRetVal = parts.join(',');
		
		var ret1=unescape(cleanedRetVal);
		
			 	var arr=ret1.split(",");
			 	if(arr[1]==undefined) 
		 		{
			 		arr[0]="";	
			 		arr[1]="";	
		 		}
		//var arr=retVal.split(",");
		var docTypeCode=arr[0];
		var orgDocNumber=arr[1];
		var srno=arr[2];
		var outstamt=arr[3];
		var recpt_type_code=arr[4];
		var recpt_desc=arr[5];
		var deposit_type=arr[6];
		var remarks=arr[7];
		var bookingRefNum = arr[8];
	//	alert(deposit_type);
		$("#stlmt_amount").val(outstamt);
		$("#doc_number").val(docTypeCode);
		$("#doc_num").val(orgDocNumber);
		$("#documnumber").val(srno);
		$("#receipt_type_code").val(recpt_type_code);
		$('#receipt_desc').val(recpt_desc);
		$('#dep_type').val(deposit_type);
		$('#reference').val(bookingRefNum);

		 $('#dep_type').attr('disabled','disabled');
		 $('#dep_type').attr('readonly', 'true');
		 $('#receipt_type_code').attr('readonly', 'true');
		 $('#receipt_desc').attr('readonly', 'true');
		$('#rec_type').attr('disabled','disabled');
		
		$("#orgdoc_amt").val(outstamt);
		
		$("#orgdoc_type").val(docTypeCode);
		$("#orgdoc_num").val(orgDocNumber);
		$("#orgdoc_srno").val(srno);
		$("#remarks").val(remarks);

		 $('#receipt_nature_code').attr('readonly', 'readonly');
		 $('#receipt_nature').attr('readonly', 'readonly');
		 $('#receiptNatureBtn').attr('disabled', 'disabled');
		/*alert(docTypeCode);
		alert(orgDocNumber);
		alert(srno);
		alert(outstamt);*/

		}


}

function stlmt_amountcheck()
{
	
	if($("#reqcheck").val()=='Y')
		{
		var reqAmt=parent.frames[1].document.forms[0].reqamount.value;
		var stlmtAmount=parent.frames[1].document.forms[0].stlmt_amount.value;
		if(parseFloat(stlmtAmount) != parseFloat(reqAmt))
	{
		alert(getMessage("BL1536","BL"));
		parent.frames[1].document.forms[0].stlmt_amount.value='';
		return;
	}
		}
	
	if($('#rec_ref').val()=="F")
			{
		var orgdoc_amt=	$('#orgdoc_amt').val();
		var stlmtamt=$('#stlmt_amount').val();	
	
		if($('#doc_number').val()!="")
		{
	
		if(parseFloat(Math.abs(stlmtamt)) > parseFloat(Math.abs(orgdoc_amt))){
			alert(getMessage("BL7085","BL"));			
			$('#stlmt_amount').val('');
			return false;
		}
		}
	
		if( stlmtamt>0)
		{
		alert(getMessage("BL9863","BL"));
		$('#stlmt_amount').val('');
		return false;
		}
			
			}
	
	
}

function deptypecheck()
{
	if ($("#receipt_nature_code").val() == "AD" && $("#dep_type").val() == "S") 
	{

	$("#reference").removeAttr("disabled");

	}

	else
	{
		$("#reference").attr("disabled","disabled");
		$("#reference").val('');
	}
	
}

function recref()

{
		
	if($("#receipt_nature_code").val()!='' && $('#rec_ref').val()=="F")
		{
		
		
		
		if(($("#receipt_nature_code").val()!="AD" ) && ($("#receipt_nature_code").val()!="RD") && ($("#receipt_nature_code").val()!="MI"))
				
			{
			alert(getMessage("BL2200","BL"));

			$("#receipt_nature_code").val('');
			$("#receipt_nature").val('');
			return false;
			

			}
		}
	
	
	var deptype = document.getElementById('dep_type');
	
	
	
	if($("#receipt_nature_code").val()!= "AD")
		{
		$("#dep_type option[value*='S']").remove();
		}
	else
		{
	
		deptype.length = 0;
		var opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Not Applicable';
		deptype.appendChild(opt);

		
		
		
		opt = document.createElement("option");
		opt.value = 'S';
		opt.innerText = 'Deposit Against SUrgery';
		deptype.appendChild(opt);
		

		
		//$('#dep_type').html("<option value='S'>Deposit Against Surgery</option>")
		//$("#dep_type option[value*='S']").append();
		}
	
	// Added by Manivel N on 16-08-22 for TH-KW-CRF-0156
	if($("#rec_ref").val() == "R"){
		defaultReceipttype('rcptnature');
	}
	
	if ($("#rec_ref").val() == "R" && $("#receipt_nature_code").val() == "AD" && $("#episode_type").val()!="R" ) {

		//	added by Vijay for bill generation patient deposit collection  	
		
		if($('#called_from').val()=='bill_generation')
			{
			$('#depest').hide();
			}
		// ends---
		
		else
			{
		
		$("#depest").show();
		$('#request_id').hide();
		$('#reqlabel').hide();
			}
	}

	
	
	
	else if ($("#receipt_nature_code").val() == "AD"
			&& $("#dep_type").val() == "S") {
		$("#reference").removeAttr("disabled");

	} else if ($("#rec_ref").val() == "F"
			&& ($("#receipt_nature_code").val() == "BI" || $(
					"#receipt_nature_code").val() == "DC")) {
		$("#totalbillamt").show();
		$("#billpaidamt").show();
		$("#totamt").show();
		$("#paidamt").show();

	}

	else if ($("#receipt_nature_code").val() == "CU") {
		
		$('#customerid').show();
		$('#cus_id').show();
		$("#cusmandatory").show();
	}

	else {
		//alert('else');
		$("#totalbillamt").hide();
		$("#billpaidamt").hide();
		$("#totamt").hide();
		$("#paidamt").hide();
		$("#customer_code").attr("disabled", "disabled");
		$("#customer_name").attr("disabled", "disabled");
		$("#reference").attr("disabled", "disabled");
		$("#depest").hide();
		
	}
	/*if ($("#rec_ref").val() == "R" && $("#receipt_nature_code").val() == "AD"
			&& $("#depcount").val() == 0 && $("#depreturn").val() > 0)

	{
		alert("fn called check");
		$("#dep_type").val("A");
		$("#dep_type option[value*='K']").prop('disabled',true);
		$("#dep_type option[value*='S']").prop('disabled',true);
		$("#dep_type option[value*='N']").prop('disabled',true);
		$("#dep_type option[value*='T']").prop('disabled',true);
		$("#dep_type option[value*='O']").prop('disabled',true);

		$("#stlmt_amount").val($("#depreturn").val());
	} 
	else 
	{
			$("#dep_type").val("N");
			$("#dep_type option[value*='K']").prop('disabled',true);
			//$("#dep_type option[value*='S']").prop('disabled',true);
			$("#dep_type option[value*='A']").prop('disabled',true);
			$("#dep_type option[value*='T']").prop('disabled',true);
			$("#dep_type option[value*='O']").prop('disabled',true);

	}*/
	if($("#episode_type").val()=="O" || $("#episode_type").val()=="R" || $("#episode_type").val()=="E")
	{
	/*		$("#dep_type option[value*='K']").prop('disabled',true);
	//$("#dep_type option[value*='S']").prop('disabled',true);
	//$("#dep_type option[value*='N']").prop('disabled',true);
	$("#dep_type option[value*='T']").prop('disabled',true);
	$("#dep_type option[value*='O']").prop('disabled',true);
	$("#dep_type option[value*='A']").prop('disabled',true);*/
		$("#dep_type option[value*='K']").remove();
		$("#dep_type option[value*='T']").remove();
		$("#dep_type option[value*='O']").remove();
		$("#dep_type option[value*='A']").remove();

		
		
		
	$("#dep_type").val("N");
	
	
	}       
	
	  
	else if($("#episode_type").val()=="I" || $("#episode_type").val()=="D")
		
	{
		if($("#receipt_nature_code").val()!="AD" && $("#receipt_nature_code").val()!="PD")
			{
/*			$("#dep_type option[value*='K']").prop('disabled',true);
			//$("#dep_type option[value*='S']").prop('disabled',true);
			//$("#dep_type option[value*='N']").prop('disabled',true);
			$("#dep_type option[value*='T']").prop('disabled',true);
			$("#dep_type option[value*='O']").prop('disabled',true);
			$("#dep_type option[value*='A']").prop('disabled',true);*/
			$("#dep_type option[value*='K']").remove();
			$("#dep_type option[value*='T']").remove();
			$("#dep_type option[value*='O']").remove();
			$("#dep_type option[value*='A']").remove();

			$("#dep_type").val("N");
			
			}
		else
			{
			//$("#reference").removeAttr("disabled");
			
		/*	$("#dep_type option[value*='K']").removeAttr("disabled");
			//$("#dep_type option[value*='S']").prop('disabled',true);
			//$("#dep_type option[value*='N']").prop('disabled',true);
			$("#dep_type option[value*='T']").removeAttr("disabled");
			$("#dep_type option[value*='O']").removeAttr("disabled");
			$("#dep_type option[value*='A']").removeAttr("disabled");*/
						$("#dep_type").val("N");

				deptype.length = 0;
		var opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Not Applicable';
		deptype.appendChild(opt);

		

		
		
		
		opt = document.createElement("option");
		opt.value = 'A';
		opt.innerText = 'Admission Deposit';
		deptype.appendChild(opt);
		
		opt = document.createElement("option");
		opt.value = 'O';
		opt.innerText = 'Other Deposit';
		deptype.appendChild(opt);
		
		opt = document.createElement("option");
		opt.value = 'T';
		opt.innerText = 'Transfer Deposit';
		deptype.appendChild(opt);
		
		opt = document.createElement("option");
		opt.value = 'S';
		opt.innerText = 'Deposit Against Surgery';
		deptype.appendChild(opt);
		
			
			

			
			}
	
	}
	
	
		if($("#patient_id").val()=="" && $("#receipt_nature_code").val()!= "MI")
		{
		alert(getMessage("BL2195","BL"));
		 parent.frames[1].document.getElementById("receipt_nature_code").value='';
		 parent.frames[1].document.getElementById("receipt_nature").value='';

		}

}

function rectypecheck() {
	//alert("rectypecheck");

	if ($('#receipt_nature_code').val() == '') {
			alert(getMessage("BL00001", "BL"));
		return false; // for TH-KW-CRF-0156
	}

	else {
		
		if($('#cusid').val()=="SHALM")
		{
				actcode_dep();
		}
	}
	return true;
}
function remark() 
{
	
		var formObj = document.EnterReceiptRefundForm;
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var visit_id = formObj.visit_id.value;
	var receipt_nature_code = formObj.receipt_nature_code.value;
	var recpt_refund_ind = formObj.recpt_refund_ind.value;
	var receipt_type_code = formObj.receipt_type_code.value;
	var stlmt_amount = formObj.stlmt_amount.value;
	var doc_number = formObj.doc_number.value;
	var doc_num = formObj.doc_num.value;
	var documnumber = formObj.documnumber.value;

	$
			.ajax({
				type : 'POST',
				url : "../jsp/BlDepositremarks.jsp?&func_mode=remarksdisplay&facility_id="
						+ facility_id
						+ "&episode_id="
						+ episode_id
						+ "&episode_type="
						+ episode_type
						+ "&locale="
						+ locale
						+ "&patient_id="
						+ patient_id
						+ "&visit_id="
						+ visit_id
						+ "&receipt_nature_code="
						+ receipt_nature_code
						+ "&recpt_refund_ind="
						+ recpt_refund_ind
						+ "&receipt_type_code="
						+ receipt_type_code
						+ "&stlmt_amount="
						+ stlmt_amount
						+ "&doc_number="
						+ doc_number
						+ "&doc_num="
						+ doc_num
						+ "&documnumber="
						+ documnumber,
				// data:$(formObj).serialize(),
				async : false,
				dataType : "text",
				success : function(data) {	
						formObj.remarks.value = trimString(data);
					}
			});
}

async function callCommonLookupCode(obj, code, sqlSelect, codeDesc, commonCode) {

//	parent.frames[1].document.forms[0].stlmt_amount.value='';
	//alert("d");
	
	var formObj = document.EnterReceiptRefundForm;
	var locale = formObj.locale.value;
	var facility_id = formObj.facility_id.value
	var rcptNatcode = formObj.receipt_nature_code.value;
	var recTypCode= formObj.receipt_type_code.value;
	var patient_id = formObj.patient_id.value;
	var acc_entity_code = 'ZZ';
	var recpt_refund_ind = formObj.recpt_refund_ind.value;

	var rcpt_ip_allowed_yn = formObj.rcpt_ip_allowed_yn.value;

	var rcpt_op_allowed_yn = formObj.rcpt_op_allowed_yn.value;

	var rcpt_ref_allowed_yn = formObj.rcpt_ref_allowed_yn.value;

	var rfnd_ip_allowed_yn = formObj.rfnd_ip_allowed_yn.value;

	var rfnd_op_allowed_yn = formObj.rfnd_op_allowed_yn.value;

	var rfnd_ref_allowed_yn = formObj.rfnd_ref_allowed_yn.value;

	var rfnd_allowed_yn = formObj.rfnd_allowed_yn.value;

	var rcpt_allowed_yn = formObj.rcpt_allowed_yn.value;


	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = '';
	var title = '';
	var codeval = '';
	
	// Added by Manivel for TH-KW-CRF-0156
	if (sqlSelect == 1) {
		if(!rectypecheck())
			return false;
	}
	
	switch (sqlSelect) {

	case 1: {
		sql = " Select code,description from (SELECT   DISTINCT receipt_type_code code,  long_desc description FROM bl_receipt_type_lang_vw WHERE receipt_type_code = NVL (NULL, receipt_type_code) AND language_id = ('"
				+ locale
				+ "') AND acc_entity_code IN ( SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = ('"
				+ facility_id
				+ "')) AND receipt_type_code IN ( SELECT receipt_type_code FROM bl_receipt_type_lang_vw  WHERE recpt_nature_code = ('"
				+ rcptNatcode
				+ "') AND language_id = ('"
				+ locale
				+ "') AND NVL	 (status, 'X') != 'S')) where upper(code) like upper(?)  and upper(description) like upper(?) order by 2 ";
		title = 'Receipt Type';
		break;
	}
	case 2: {
		sql = "Select code,description from (SELECT A.DOC_TYPE_CODE code ,B.SHORT_DESC description FROM BL_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND   UPPER(LANGUAGE_ID) = UPPER('"
				+ locale
				+ "') AND A.ACC_ENTITY_CODE = 'ZZ' and a.operating_facility_id = '"
				+ facility_id
				+ "'  and ((a.ENTITY_OR_FACILITY_BASED= 'F' and substr(a.doc_type_code,1,2)= '"
				+ facility_id
				+ "' ) or (a.ENTITY_OR_FACILITY_BASED= 'E' and  A.ACC_ENTITY_CODE =  'ZZ')) AND ((A.TRX_TYPE_CODE = '5' AND '"
				+ recpt_refund_ind
				+ "' = 'R' AND ('"
				+ rcpt_op_allowed_yn
				+ "' = 'Y' OR '"
				+ rcpt_ip_allowed_yn
				+ "' = 'Y' OR '"
				+ rcpt_ref_allowed_yn
				+ "'  = 'Y') AND	'"
				+ rcpt_allowed_yn
				+ "' = 'Y') OR (A.TRX_TYPE_CODE = '6' AND '"
				+ recpt_refund_ind
				+ "' = 'F' AND ('"
				+ rfnd_op_allowed_yn
				+ "' = 'Y'  OR '"
				+ rfnd_ip_allowed_yn
				+ "' = 'Y'  OR '"
				+ rfnd_ref_allowed_yn
				+ "' = 'Y') AND '"
				+ rfnd_allowed_yn
				+ "' = 'Y'))) where upper(code) like upper(?)  and upper(description) like upper(?) order by 1";
		title = 'Document No';
		break;

	}
	case 3: {
		sql = "Select code,description from (SELECT DISTINCT a.action_reason_code  Code  , a.action_reason_desc description FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND UPPER (language_id) = UPPER ('"
				+ locale
				+ "') AND b.action_type = 'DT'AND NVL (b.active_yn, 'N') = 'Y' )  where upper(code) like upper(?)  and upper(description) like upper(?) order by 2";
		title = 'Reason';
		break;
	}

	case 4: {
		sql = "SELECT code , description FROM (select cust_code,Short_name from ar_customer_lang_vw where nvl(status,'X') != 'S' AND UPPER(LANGUAGE_ID) = UPPER(:PARAMETER.P_LANGUAGE_ID) and acc_entity_code in ( select acc_entity_code from sy_acc_entity where acc_entity_id = '"
				+ facility_id
				+ "')) where upper(code) like upper(?)  and upper(description) like upper(?)order by 2";
		title = 'Customer Code';
		break;
	}

	case 5: {
		sql = "select code,description  from (SELECT recpt_nature_code code ,long_desc description "
				+ "FROM bl_receipt_nature_lang_vw WHERE recpt_nature_code IN "
				+ "( SELECT 'AD' FROM DUAL UNION SELECT 'MI' FROM DUAL UNION SELECT 'PR' FROM DUAL UNION SELECT 'RD' FROM DUAL "
				+ "UNION SELECT 'AR' FROM bl_parameters WHERE operating_facility_id = '"
				+ facility_id
				+ "' AND NVL (rcpt_ar_tfr_amt_in_bl_yn, 'N') = 'Y' "
				+ "UNION SELECT 'HC' FROM bl_parameters WHERE operating_facility_id = '"
				+ facility_id
				+ "' AND NVL (hcard_in_use_yn, 'N') = 'Y' "
				//+ "UNION  SELECT 'PK' FROM bl_parameters WHERE operating_facility_id = '"
				//+ facility_id
				//+ "' AND NVL (package_enabled_yn, 'N') = 'Y' "
				+ "UNION SELECT 'PD' FROM DUAL where bl_chk_module_status('PK') = 'VALID' "
				
				+ "UNION  SELECT 'CU' FROM DUAL where bl_chk_module_status('AR') = 'VALID' and '"
				+ patient_id
				+ "' IS NULL"
				+ ")  AND UPPER (language_id) = UPPER ('"
				+ locale
				+ "') ) where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1";
		title = 'Receipt Nature';
			break;
	}

	case 6: {
		sql = "SELECT code , description from (SELECT dept_code code , short_desc description from sy_dept_LANG_VW where nvl(status,'x') != 'S' AND UPPER(LANGUAGE_ID) = UPPER('"
				+ locale
				+ "') and operating_facility_id = '"
				+ facility_id
				+ "') where upper(code) like upper(?)  and upper(description) like upper(?) order by 1";
		title = 'Accounting Departments';
		break;

	}
	case 7: {
		sql = "SELECT code , description from (SELECT REQUEST_ID  code, Amount||'  -Amount' description From MR_REPORT_REQUEST_HDR a Where a.facility_id = '"+facility_id+"' "
				+" and nvl(patient_id,'X') = nvl('"+patient_id+"','X') And a.REQUEST_STATUS > 0 And ((CHARGES_APPL_YN='Y' and AMOUNT > 0 And RECEIPT_DATE is null) Or (ADDL_CHARGES_YN   = 'Y' and  ADDL_AMOUNT > 0 and ADDL_RECEIPT_DATE is null))) where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1 ";
		title = "Request Id";
	
		break;
		
	
	}
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if (codeDesc == '1') {
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
	} else if (codeDesc == '2') {
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = CODE_DESC;
	}
	returnedValues = await CommonLookup(title, argumentArray);
	// retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[1];
		code.value = arr[0];
		codeval = code.value;
	} else {
		//obj.value = '';
		//code.value = '';
		 obj.value = arr[1]; 
			code.value = arr[0]; 
	}

	if (sqlSelect == 1) {
		rectypecheck();
		//actcode_dep();
		reqidshow(codeval);
		remark();

	}
	if (sqlSelect == 2) {
		obj.value = '';

	}
	if (sqlSelect == 5) {
		recref();

	}

	if (sqlSelect == 7) {
		
		var check=obj.value;
		check=check.slice(0,-9);
		
		parent.frames[1].document.forms[0].stlmt_amount.value=check;
		parent.frames[1].document.forms[0].reqamount.value=check;
		obj.value='';
	}

		//alert("rcptNatcode / sqlSelect :: "+rcptNatcode +"/"+  sqlSelect);
	 if($('#cusid').val()=="KDAH" || ($('#cusid').val()=="AMS"))
	{
		
	
	
	if(rcptNatcode=='MI'){
	//	alert("check for spl agency");
		
		if(sqlSelect==1)
		{
			//alert("recTypCode="+recTypCode);
			recTypCode=returnedValues[0];
			//alert("recTypCode="+recTypCode);
			$.ajax({
				type:"POST",
				url:"../jsp/SpecialAgenDepCheck.jsp?recTypCode="+recTypCode+"&rcptNatcode="+rcptNatcode,						
				dataType:"text",
				async:false,
				success: function(data){
						//alert("data"+data);
						var dataArr = $.trim(data).split("::"); 
						var splAgnDepChk=dataArr[2];
					//alert("splcheck "+splAgnDepChk);
					if(splAgnDepChk=='Y'){
						
						
						$("#splAgnDep").show();
						document.forms[0].splAgnDepChkYN.value='Y';
						
					}
					else{
						$("#splAgnDep").hide();
						document.forms[0].splAgnDepChkYN.value='N';
					}
					//alert("splAgnDepChkYN  :::::::"+document.forms[0].splAgnDepChkYN.value);
					
				},
				 error: function(data){
					 alert("error:: "+data);
			     }
			});
		
		}
		
	}
			
	if(sqlSelect==5)
	{
		rcptNatcode=code.value;
		if(rcptNatcode != 'MI'){
			
			$("#splAgnDep").hide();
		}
		else if(rcptNatcode=='MI'){
						
				//alert("recTypCode="+recTypCode);
				//alert("rcptNatcode="+rcptNatcode);
				
				$.ajax({
					type:"POST",
					url:"../jsp/SpecialAgenDepCheck.jsp?recTypCode="+recTypCode+"&rcptNatcode="+rcptNatcode,						
					dataType:"text",
					async:false,
					success: function(data){
						//	alert("data"+data);
							var dataArr = $.trim(data).split("::"); 
							var splAgnDepChk=dataArr[2];
					//	alert("splcheck "+splAgnDepChk);
						if(splAgnDepChk=='Y'){
							
							$("#splAgnDep").show();
							document.forms[0].splAgnDepChkYN.value='Y';
							
						}
						else{
							$("#splAgnDep").hide();
							document.forms[0].splAgnDepChkYN.value='N';
						}
					//	alert("splAgnDepChkYN  :::::::"+document.forms[0].splAgnDepChkYN.value);
						
					},
					 error: function(data){
						 alert("error:: "+data);
				     }
				});
			
			}
			
		
	}
		
}
	 
}
function fnClearCode(obj) {
	obj.value = '';
	
	// Added for TH-KW-CRF-0156. When nature code/desc is cleared then by default receipt type to be cleared 
	if(obj.id == 'receipt_nature_code' || obj.id == 'receipt_nature'){
		document.forms[0].receipt_type_code.value = '';
		document.forms[0].receipt_desc.value ='';
	}
}

function reqidshow(codeval) {

	/*alert("fn check"+codeval); alert('queryvalue:'+parent.frames[1].document.forms[0].misc_rcpt_type.value);
	alert('query value::'+$("#medrep_pay_int_mode").val());*/

	if ($("#medrep_pay_int_mode").val() == "B"
			&& $("#receipt_nature_code").val() == "MI"
			&& $("#rec_ref").val() == "R"
			&& $("#misc_rcpt_type").val() == codeval) {
		$('#reqlabel').show();
		$('#request_id').show();
		$("#reqcheck").val("Y");
	//	stlmt_amountcheck();
	}
	else
		{
		$("#reqcheck").val("N");
		$('#request_id').hide();
		$('#reqlabel').hide();
		
		}
}

function showCalendar_loc(Val1, Val2) {
	if (Val2.disabled == true) {
		return false;
	} else {

		return showCalendar(Val1, null, null);
	}
}

function actcode_dep() {

	//alert('procedure call check');
	var formObj = document.EnterReceiptRefundForm;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var visit_id = formObj.visit_id.value;
	var receipt_nature_code = formObj.receipt_nature_code.value;
	var receipt_type_code = formObj.receipt_type_code.value;
	$.ajax({
		type : 'POST',
		url : "../jsp/BlDepositremarks.jsp?func_mode=actcode&facility_id="
				+ facility_id + "&episode_id=" + episode_id + "&episode_type="
				+ episode_type + "&patient_id=" + patient_id + "&visit_id="
				+ visit_id + "&receipt_nature_code=" + receipt_nature_code
				+ "&receipt_type_code=" + receipt_type_code,
		async : false,
		dataType : "text",
		success : function(data) {
			var dataArr = $.trim(data).split("::");
			var error_id = dataArr[2];
			var error_text=dataArr[3];
			//alert('error_id'+error_id)
			//alert('error_text'+error_text);
			if (dataArr[0] == '') {
				if(error_id==null||error_id=='null')
					{
					
					alert(error_text);
					}
				else
					{
				alert(getMessage(error_id, "BL"));
				formObj.ext_acc_code.value = '';
				formObj.dept_desc.value = dataArr[1];
					}
			} else {
				formObj.ext_acc_code.value = dataArr[0];
				formObj.dept_desc.value = dataArr[1];
			}
		}
	});

}
/*	function depdefault() {
		if ($("#rec_ref").val() == "R"
				&& $("#receipt_nature_code").val() == "AD"
				&& $("#depcount").val() == "" && $("#depreturn").val() > 0)

		{
			//alert('if');
			$("#dep_type").val("A");

		}

		else {
			//alert('else');
			$("#dep_type").val("N");

		}

	}*/


function chkDtGreaterThanSysDate(entered_date,sys_date) 
{
	
	//alert("entered_date/sys_date::"+entered_date+"/"+sys_date);
	if((CheckDate(entered_date)))
	{

		var enteredDateArray; var sysDateArray;
		var enteredDate = entered_date.value ;
		var sysDate = sys_date.value;
	//alert("dates  "+enteredDate+"/"+sysDate);
		if(enteredDate.length > 0 && sysDate.length > 0 ) 
		{
			
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
				var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
				
			//	alert("enteredDateArray[2]/[1]/[0] "+enteredDateArray[2]+"/"+(enteredDateArray[1]-1)+"/"+(enteredDateArray[0]-1));
			

			if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)) 
			{
				//alert("Entered date cannot be Less than sys date");
				alert(getMessage("BL8147",'BL'));
//				entered_date.focus();
//				entered_date.select();

				return false;
			}
			else if(Date.parse(sysDateObject) < (Date.parse(enteredDateObject))) 
			{
				//alert("more");
				return true;
			}
			else 
			{
				//alert("else");
				return false;
			}
		}	
		return true;
	}
	else
	{
		return(false);
	}
	
}
function compareDates(startDate,endDate){
	var starr = startDate.value.split("/");
	var enarr = endDate.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	if(startDate.value.length>0 && endDate.value.length>0){
		if(startdt>enddt){
			alert(getMessage('BL8508','BL'));
			endDate.value = '';
		}
	}
}
function validDateChk(obj)
{	
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
	if(validDate(obj.value,'DMY',locale))
	{
		return true;
	}
	else{
		alert(getMessage("INVALID_DATE_FMT","SM"));
		obj.select();
		return false;
		}
	}
	else
	{
		return true;
	}
}


/*function requestidfn(click_event)
{

	alert('fn called');
	var formObj = document.EnterReceiptRefundForm;
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_id = formObj.patient_id.value;

	var target	= document.forms[0].dept_desc;
	if(click_event == 'B')
	{
		if(document.forms[0].dept_desc.value == "")
		{
			document.forms[0].dept_desc.value = "";
			document.forms[0].ext_acc_dept_code.value = "";
			return;
		}
	}
	var retVal			= new String();	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";

	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;

	var title=getLabel("Common.requestid.label","common");
	title=encodeURIComponent(title);	

	var column_sizes = escape("30%,70%");
	
	var code=getLabel("eBL.requestid.label","BL");
	code=encodeURIComponent(code);	
	
	var desc=getLabel("Common.amount.label","common");
	desc=encodeURIComponent(desc);

	var column_descriptions = code+","+desc;
	var message = '';
	
	sql="SELECT code , description from (SELECT REQUEST_ID  code, Amount description From MR_REPORT_REQUEST_HDR a Where a.facility_id = '"+facility_id+"' and nvl(patient_id,'X') = nvl('"+patient_id+"','X') And a.REQUEST_STATUS > 0 And ((CHARGES_APPL_YN='Y' and AMOUNT > 0 And RECEIPT_DATE is null) Or (ADDL_CHARGES_YN   = 'Y' and  ADDL_AMOUNT > 0 and ADDL_RECEIPT_DATE is null))) where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1 ";		

	sql = escape(sql);		
	
	alert('sql'+sql);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
	
	var arr=new Array();
	if(retVal == null || retVal == "undefined" || retVal == undefined) retVal="";
	if (retVal != "")
	{
		var retVal=unescape(retVal);		 
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			document.forms[0].reqid.value=arr[0];				
			document.forms[0].stlmt_amount.value=arr[1];				  
		}
	}
	else
	{
		document.forms[0].reqid.value="";				
		document.forms[0].stlmt_amount.value="";				  

	}
}

function requestidfn(stlmt_amount,reqid)
{		
	var formObj = document.EnterReceiptRefundForm;
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var visit_id = formObj.visit_id.value;
	
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Request Id";		

	var column_sizes = escape("50%,50%");
	var targetVal = formObj.reqid.value;
	var column_descriptions = 'Request ID'+','+'Amount';
	var sql="";	
	var doc_type_code='';
	
/*	if( $('#from_bill_number_code').val()!='' || $('#to_bill_number_code').val()!='')
	{
		if($('#from_bill_number_code').val()!='') doc_type_code=$('#from_bill_number_code').val();
		if($('#to_bill_number_code').val()!='') doc_type_code=$('#to_bill_number_code').val();
	}
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY&target="+targetVal+"&reqid="+targetVal+"&facilityId="+$('#facility_id').val();
	param += "&patient_id="+$('#patient_id').val() ;
	


	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=reqidlookup&"+param,arguments,features);
	retVal = unescape(retVal)
	 alert(retVal)
	if(retVal != undefined && retVal !="undefined")
	{			
		alert('if');
		var retArray = retVal.split("^~^");
		 formObj.reqid.value=retArray[1];
		 formObj.stlmt_amount.value=retArray[0];								
	}
	else
	{
		alert('else');
		formObj.reqid.value="";
		 formObj.stlmt_amount.value="";
	// return retVal;
	// alert("bill look up");
	/*
	 * if(empty_chk=='Y' && bill_number_desc.value=='') { return false; } var
	 * locale = document.forms[0].locale.value; var facility_id =
	 * document.forms[0].facility_id.value;
	 * 
	 * var target = document.forms[0].from_bill_number; var retVal = new
	 * String(); var dialogTop = "40"; var dialogHeight = "10" ; var dialogWidth =
	 * "40" ; var features = "dialogTop:"+dialogTop+"dialogHeight:" +
	 * dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ; var
	 * arguments = "" ; var search_desc = ""; var title =
	 * getLabel("eBL.FromBillNumber.label","COMMON"); var
	 * episode_typ=document.forms[0].episode_type.value; //
	 * alert("episode_typ"+episode_typ); // var sql1="SELECT DISTINCT
	 * G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM
	 * IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID
	 * ='"+facility_id+"' ";// AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND
	 * UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') ";
	 * 
	 * //var sql1="SELECT doc_type_code , doc_num FROM bl_bill_hdr WHERE NVL
	 * (bill_status, '$') <> 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND
	 * episode_type = '"+episode_typ+"' and upper(doc_type_code) like upper(?)
	 * and upper(doc_num) like upper(?) order by 2 ";//WHERE NVL (bill_status,
	 * '$') <> 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND episode_type =
	 * '"+episode_typ"' "; var sql1="SELECT doc_type_code code, doc_num
	 * description FROM bl_bill_hdr where upper(doc_type_code) like upper(?) and
	 * upper(doc_num) like upper(?) order by 1 ";//WHERE NVL (bill_status, '$') <>
	 * 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND episode_type =
	 * '"+episode_typ"' ";
	 * 
	 * var argArray = new Array(); var namesArray = new Array(); var valuesArray =
	 * new Array(); var datatypesArray = new Array(); argArray[0] = sql1;
	 * argArray[1] = namesArray; argArray[2] = valuesArray; argArray[3] =
	 * datatypesArray; argArray[4] = "1,2"; argArray[5] =
	 * bill_number_desc.value; argArray[6] = DESC_LINK; argArray[7] = DESC_CODE;
	 * retArray = CommonLookup( title, argArray ); // alert("retArray
	 * :"+retArray); //retArray=unescape(retArray);
	 
	
}
}*/

async function defaultReceipttype(obj){
	var rcptnature = document.forms[0].receipt_nature.value;
	var rcptdesc =document.forms[0].receipt_nature_code.value;
	var formObj = document.EnterReceiptRefundForm;
	var locale = formObj.locale.value;
	var facilityId = document.forms[0].facility_id.value;
	if(obj == 'rcptnature'){
		if(rcptnature.length>0)
		{			
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultReceipttype&rcptdesc="+rcptdesc+"&facility_id="+facilityId+"&language_id="+locale;					
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);
			
			if(responseText != 'N' && responseText.length>0){	
				var retArr = responseText.split(":::");
				document.forms[0].receipt_type_code.value = retArr[0]=='0'?'':retArr[0];
				document.forms[0].receipt_desc.value = retArr[1]=='0'?'':retArr[1];
				await callCommonLookupCode(document.forms[0].receipt_desc,document.forms[0].receipt_type_code,1,1); // Added by manivel for TH-KW-CRF-0156
			}
			else
			{
				if($('#rec_ref').val()=='F')
				{
					if($('#doc_number').val()=='')
					{
						document.forms[0].receipt_type_code.value = '';
						document.forms[0].receipt_desc.value ='';
					}
				}
				else
				{
					document.forms[0].receipt_type_code.value = '';
					document.forms[0].receipt_desc.value ='';
				}
			}
		}
	}
}

function isValidDateTime(obj){	
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var dateTimeObj = obj.value;
		var dateTimeArr = dateTimeObj.split(" ");
		if(dateTimeArr.length != 2)  flag=false;
		var str_date = dateTimeArr[0];
		var str_time = dateTimeArr[1];

		if(!(checkDt1(str_date))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}

		if(!(isValidTime(str_time))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function checkDt1(date1)
{
	if (date1.value != undefined)
	{
		date1 = date1.value;
	}
	else
	{
		date1=date1;
	}
    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]
        
        if(date1d.length != 2) return false;
        if(date1m.length != 2) return false;
        if(date1y.length != 4) return false;

		if (isNaN(date1d)==true) return false;
		if (isNaN(date1m)==true) return false;
		if (isNaN(date1y)==true) return false;

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1m<=12)
        {

            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {
                retval= false
            }

            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
            {
                retval= false
            }
            if ((date1y.length <4) || (date1y.length >4))
            {
                retval= false
            }
            if (date1m == 2) {
                if (date1d< 1) return false;

                if (LeapYear(date1yy) == true) {
                    if (date1d> 29) return false;
                }
                else {
                    if (date1d > 28) return false;
                }
            }

            if (isNaN(date1d)==true) retval = false;
            if (isNaN(date1m)==true) retval = false;
            if (isNaN(date1yy)==true) retval = false;
        }
        else
        {
            retval= false;
        }
    }
    else
    {
        retval= false;
    }
    return retval;
}

function isValidTime(time1)
{
	if (time1.value != undefined)
	{
		time1 = time1.value;
	}
	else
	{
		time1=time1;
	}
   time1=trimString(time1); 
   var retval=true;
   var strCheck = ':0123456789';
    for(var i=0;i<=time1.length;i++) {
        if (strCheck.indexOf(time1.charAt(i)) == -1){
            retval = false;
            break;
        }
    }			
    if (retval)
    {		
       var time1arr=new Array()
       time1arr=time1.split(":")
            if(time1arr.length==2)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2)
				{
					 retval=false;
				}

                time1hr=eval(time1hr)
                time1min=eval(time1min)

                if(time1hr<=23)
                {
                    if(time1min>59)
                    {
                            retval=false;                      
                    }                   
                }
                else
                        retval=false;
            }
            else{						
                retval=false;
			}
        
    }			
    return retval;
}

function cal_error (str_message,obj) {
//	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}
