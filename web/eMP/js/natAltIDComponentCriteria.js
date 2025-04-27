
function enabledFields(obj)
{
	if(document.forms[0].other_alt_type.selectedIndex!=0)
		document.forms[0].other_alt_Id.disabled = false;
	else
		document.forms[0].other_alt_Id.disabled = true;
}
// End of the function for enabling the fields
// Function for validating ID's and populate the values
function validateID(obj,nat_id_check_digit_id)
{
	var id = new String();
	var step =""; 
	var mr_transaction = "";
	if(document.forms[0].h_accept_oth_alt_id_yn.value=="Y")
	{
		var oth_id_type =document.forms[0].other_alt_type.value;
		var alert_reqd_yn = document.forms[0].alert_reqd_yn.value;	
	}
	
	//Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records
	if(document.forms[0].h_accept_oth_alt_id_yn.value == "Y")
	{
		mr_transaction = document.forms[0].mr_transaction.value;
	}
	if (obj.name=="national_id_no")
	{
			if ( !CheckSplCharsNatID(obj) )
			{
				return false;
			}
			if ( (nat_id_check_digit_id=='M11') && ( (ind = obj.value.indexOf('X')) != -1) )
			{
				if (ind < 12)           // X can be entered only at 13th position
				{
					msg = getMessage('INVALID_NAT_ID','MP');
					msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
					//obj.select();
					obj.value = '';
					obj.focus();
					alert(msg);
					return false;
				}
			}
	}	
		//Addition ends
	id = trimString(obj.value);
	if (obj.name=="national_id_no")
		step ="N";
	else if (obj.name=="alt_id1_no") 
		step ="A1";
	else if (obj.name=="alt_id2_no") 
		step ="A2";
	else if (obj.name=="alt_id3_no") 
		step ="A3";
	else if (obj.name=="alt_id4_no") 
		step ="A4";
	else if (obj.name=="other_alt_Id") 
		step ="A5";
	
	if(id.length != 0)
	{
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH id=\""+id+"\" alert_reqd_yn=\""+alert_reqd_yn+"\" mr_transaction=\""+mr_transaction+"\" oth_id_type=\""+oth_id_type+"\" step=\""+step+"\" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eMP/jsp/natAltIDComponentCriteriaValues.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseTxt = trimString(responseText);	
		responseTxt = responseTxt.replace(/<script.*>/,"");
		responseTxt = responseTxt.replace(/<script>/,"");
		responseTxt = responseTxt.replace(/<\/script>/,"");
		eval(responseTxt); 
		// for smart card	
		if( document.getElementById("txtSmartcard_path").value!=''){
			var fn_id="";
			try{
				fn_id=document.getElementById("functionId").value;
			}catch(exception){
				try{
					fn_id=document.getElementById("function_id").value;
				}catch(exception){
					fn_id="BKNG";
				}
			}
			try{
				
				if(document.getElementById("cld_frm_pat_regn").value=='Y'){
					fn_id="POPFROM";
				}
			}catch(exception){
			}
			document.getElementById("txtSmartcard_fn").value=fn_id;
			
			if(fn_id=="VISIT_REGISTRATION"){
				document.getElementById("pat_id1").value=document.getElementById("txtSmartcard_pat_id").value;
			}else if(fn_id=="BKNG"){
				//document.getElementById("patient_id").value=document.getElementById("txtSmartcard_pat_id").value;
				try{ //added in KL on 10th march 2017 for medical rep
				document.getElementById("patient_id").value=document.getElementById("txtSmartcard_pat_id").value;
				}catch(exception){
					document.getElementById("PatientId").value=document.getElementById("txtSmartcard_pat_id").value;
				}
			}else{
				try{ //added in KL on 10th march 2017 for medical rep
				document.getElementById("patientid").value=document.getElementById("txtSmartcard_pat_id").value;
				}catch(exception){
					document.getElementById("PatientId").value=document.getElementById("txtSmartcard_pat_id").value;
				}
			}
			

			if(document.getElementById("txtSmartcard_path").value!=''){
				if(document.getElementById("txtSmartcard_dup").value=="D"){
				}else{
					document.getElementById("txtSmartcard_dup").value="1";	
				}
				
			}
				
			
		}// for smart card

		//lnk Inc: 48147 - Assigning Patient id and enabling updatePatient link based on sitespecific param
		if(fn_id=="VISIT_REGISTRATION"){
				document.getElementById("pat_id1").value=document.getElementById("txtSmartcard_pat_id").value;
			}else if(fn_id=="BKNG"){
				//document.getElementById("patient_id").value=document.getElementById("txtSmartcard_pat_id").value;
				try{ //added in KL on 10th march 2017 for medical rep
				document.getElementById("patient_id").value=document.getElementById("txtSmartcard_pat_id").value;
				}catch(exception){
					document.getElementById("PatientId").value=document.getElementById("txtSmartcard_pat_id").value;
				}
			}else{
				try{ //added in KL on 10th march 2017 for medical rep
				document.getElementById("patientid").value=document.getElementById("txtSmartcard_pat_id").value;
				}catch(exception){
					document.getElementById("PatientId").value=document.getElementById("txtSmartcard_pat_id").value;
				}
			}
		var isSiteSpe_change_pat_dtls;
		try{
			isSiteSpe_change_pat_dtls=parent.parent.frames[1].frames[1].document.forms[0].isSiteSpe_change_pat_dtls.value;
		}catch(exception){
			isSiteSpe_change_pat_dtls='false';
		}
		if(isSiteSpe_change_pat_dtls=="true"){ 
			if(parent.parent.frames[1].frames[1].document.forms[0].pat_id1.value!=""){
				parent.parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="visible";
			}else if(parent.parent.frames[1].frames[1].document.forms[0].referal_id1!=null){
				parent.parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="visible";
			}else{
				parent.parent.frames[1].frames[1].document.getElementById("Update_pat").style.visibility="hidden";
			}
		
		}
	}

	//Added by Ashwin K for AAKH-CRF-0150

	if (obj.name=="national_id_no" &&  document.getElementById("AddVisit_EmiratesID_edit"))
	{
	$("#national_id_no").prop('disabled', true);
	$('#AddVisit_EmiratesID_edit').prop('checked', false);
	$("#M_btn2").prop('disabled', false);

	}
	//Ended by Ashwin K for AAKH-CRF-0150
}
function CheckForCharsNatID(event){
	
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForAlphaCharsNatID(event){	

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckSplCharsNatID(Obj){
		
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
        var str = Obj.value;
        var specCharsExist = true;
		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		
		//strCheck = '0123456789X';
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.value = '';
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
    }

	function CheckForSpeclChars(event){
	
	var alt_id1_accept_alphanumeric_yn = document.forms[0].alt_id1_accept_alphanumeric.value;
    var strCheck = '';
	if (alt_id1_accept_alphanumeric_yn=='Y')
	{
		strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	}
	else
	{
		strCheck = '0123456789';
	}   
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

//below code change done for SRR20056-SCF-12671
function altID234Validations(event){	
	var alt_id1_accept_alphanumeric_yn = document.forms[0].alt_id1_accept_alphanumeric.value;
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
