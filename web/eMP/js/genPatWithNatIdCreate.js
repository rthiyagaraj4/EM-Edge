async function PatSearch(){
	var patientid= await PatientSearch('','','','','','','','','','VIEW');
	document.generatePatIdForm.patientId.value = unescape(patientid);
	if( document.generatePatIdForm.patientId.value == 'undefined')
	document.generatePatIdForm.patientId.value = '';
	document.generatePatIdForm.patientId.focus();
}
function changeCase(Obj) {
	Obj.value =Obj.value.toUpperCase();
}

function reset(){

		f_query_add_mod.document.generatePatIdForm.patientId.value="";
		f_query_add_mod.document.generatePatIdForm.nationalId.value="";
		f_query_add_mod.document.generatePatIdForm.nationalId.disabled=true;
		f_query_add_mod.document.generatePatIdForm.nat_id_gif.style.visibility="hidden";
	
}

function apply(){

		var nat_id_prompt	= f_query_add_mod.document.generatePatIdForm.nat_id_prompt.value;
		var patient_id	= f_query_add_mod.document.generatePatIdForm.patientId.value;
		var nat_id	= f_query_add_mod.document.generatePatIdForm.nationalId.value;
		var error			= "";
		if(patient_id==""){
			error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",getLabel('Common.patientId.label','Common'));
			alert(error);
			commontoolbarFrame.document.location.reload();
			f_query_add_mod.document.generatePatIdForm.patientId.focus();
			return false;
		}

		if(nat_id==""){
			error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",nat_id_prompt);
			alert(error);
			commontoolbarFrame.document.location.reload();
			f_query_add_mod.document.generatePatIdForm.nationalId.focus();
			return false;
		}

		f_query_add_mod.document.generatePatIdForm.submit();
}





function getPatientStatus( patientId) {

	if(patientId!=""){
		 var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			//xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		 xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eMP/jsp/getPatientStatus_chkNationalId.jsp?patientId="+patientId+"&action=chk_valid_patient&national_id_chk=Y", false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send("");
		var xmlText = xmlHttp.responseText
		xmlText = xmlText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
		
		 var pat_status	= TrimStr(xmlText);
		 var ErrorMessage	= "";
		 if(pat_status!=""){
			  var nat_id_prompt= document.generatePatIdForm.nat_id_prompt.value;

			  if (pat_status=="SUSPENDED"){  
				 ErrorMessage= getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="DECEASED"){
				 ErrorMessage= getMessage('PAT_DECEASED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="SECURED"){
				 ErrorMessage= getMessage('SECURED_NOT_ALLOWED','COMMON'); 
			  }else if (pat_status=="INACTIVE"){
				 ErrorMessage= getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="BLACKLISTED_PATIENT"){
				 ErrorMessage= getMessage('BLACKLISTED_PATIENT','MP'); 
			  }else if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }else if(pat_status.indexOf("PATIENT_MERGED_VALID") > -1){
				 var valid_patient_id	= pat_status.split("$");
				  if(pat_status.length>0){
					  ErrorMessage	= getMessage('PATIENT_MERGED_VALID','MP');
					  ErrorMessage	= ErrorMessage.replace("#",valid_patient_id[1]);
				  }
			  }else if(pat_status=="NATIONAL_ID_EXISTS"){
				  	  ErrorMessage	= getMessage('NATIONAL_ID_EXISTS','MP');
					  ErrorMessage	= ErrorMessage.replace("#",nat_id_prompt);
			  }else if(pat_status=="NRIC_FOR_NONCITIZEN"){
					 ErrorMessage	= getMessage('NRIC_FOR_NONCITIZEN','MP');
					 ErrorMessage	= ErrorMessage.replace("$",nat_id_prompt);
			  }else if(pat_status=="CAN_NOT_MERGE_UNKNOWN_PATIENT"){
					 ErrorMessage	= getMessage('CAN_NOT_MERGE_UNKNOWN_PATIENT','MP');
			  }
			  if(ErrorMessage!=''){
				alert(ErrorMessage);
				document.generatePatIdForm.patientId.value = '';
				document.generatePatIdForm.patientId.focus();
			  }
		 }else{
			document.generatePatIdForm.nationalId.disabled=false;
			document.generatePatIdForm.nat_id_gif.style.visibility="visible";
		 }
	}else{
			document.generatePatIdForm.nationalId.disabled=true;
			document.generatePatIdForm.nat_id_gif.style.visibility="hidden";
			document.generatePatIdForm.nationalId.value = '';
	}
}


/*On Key Press functions Start*/

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
/*On Key Press functions End*/


/*On Onblur functions Start*/

function validateNationality(nationalId,nat_id_accept_alphanumeric_yn,invoke_routine,invoke_routine_name,nat_id_check_digit_id,nat_id_chk_len,nat_id_length){


	if ( nationalId.value.length > 0 ) {	
		var ind	= -1;
		if ( !CheckSplCharsNatID(nationalId,nat_id_accept_alphanumeric_yn) ){
			nationalId.value="";
			return false;
		}
		var nat_id_prompt	= document.generatePatIdForm.nat_id_prompt.value;

		if ( (nat_id_check_digit_id=='M11') && ( (ind = nationalId.value.indexOf('X')) != -1) )	{
			if (ind < 12) {
				var msg = getMessage('INVALID_NAT_ID','MP');
				msg = msg.replace("#",nat_id_prompt);
				nationalId.focus();
				nationalId.value="";
				alert(msg);
				return false;
			}
		}

		if(nat_id_chk_len=="Y"){
			if(nationalId.value.length!=nat_id_length){
				var msg = getMessage("NAT_ID_CHARS",'MP');
				msg		= msg.replace("@",nat_id_length);
				msg		= msg.replace("#",nat_id_prompt);
				nationalId.value="";
				nationalId.focus();
				
				alert(msg);
				return false;
			}
		}


		var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			xmlHttp = "";
		xmlHttp.open("POST", "../../eMP/jsp/getPatientStatus_chkNationalId.jsp?nationalId="+nationalId.value+"&action=chk_national_id&invoke_routine="+invoke_routine+"&invoke_routine_name="+invoke_routine_name+"&nat_id_check_digit_id="+nat_id_check_digit_id+"", false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send("");
		var xmlText = xmlHttp.responseText
		xmlText = xmlText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
		 var nationalIdStatus	= TrimStr(xmlText);
		 var ErrorMessage		= "";
		 if(nationalIdStatus!=""){
			 if (nationalIdStatus=="DUP_NAT_ID"){  
					ErrorMessage= getMessage('DUP_NAT_ID','MP'); 
			 }else{
					ErrorMessage= getMessage(nationalIdStatus,'MP'); 
			 }
					ErrorMessage = ErrorMessage.replace('#',nat_id_prompt);
					ErrorMessage = ErrorMessage.replace('National ID',nat_id_prompt);
					alert(ErrorMessage);
					nationalId.focus();
					nationalId.value="";
					return false;
		 }

	}
}

function CheckSplCharsNatID(Obj,nat_id_accept_alphanumeric_yn){
        var str = Obj.value;
        var specCharsExist = true;

		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		
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
/*On Onblur functions End*/

function onSuccess(){
	f_query_add_mod.location.reload() ;
}