async function show_window(id) {
	var dob = document.forms[0].dob.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].gender.value;
	var termSetId = eval("document.forms[0].termSetId_"+id).value;
	var practitioner_id = document.forms[0].Practitioner_Id.value;
	var searchtext = eval("document.forms[0].diagprob_code_"+id).value;
	var Encounter_Id = document.forms[0].EncounterId.value;
	var speciality_code = document.forms[0].speciality_code.value;
	var retVal =    new String();
	var dialogHeight= "27.22vh" ;
	var dialogWidth = "44vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	retVal = await window.showModalDialog("TermCodeSearchMainFrame.jsp?&speciality_code="+speciality_code+"&term_set_id="+termSetId+"&practitioner_id="+practitioner_id+"&termsetid="+termSetId+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if(retVal != null)	{
		retcode=retVal ; 
		eval("document.forms[0].diagprob_code_"+id).value = retcode;
		eval("document.forms[0].diagprob_code_"+id).onblur();
	}
}

function getDescription(termCode,id){
	var termSetId	= eval("document.forms[0].termSetId_"+id).value;
	if(termCode!=""){
			termCode	= termCode.toUpperCase();
			var isproceed	= "Y";
			var diagnosisRowCount	= parseInt(document.forms[0].diagnosisRowCount.value);
			for(i=0;i<diagnosisRowCount;i++){
				var chkCode	= eval("document.forms[0].diagprob_code_"+i).value;
				chkCode	= chkCode.toUpperCase();
				eval("document.forms[0].diagprob_code_"+i).value	= chkCode;
				if(id!=i && chkCode==termCode && chkCode!=""){
					isproceed	= "N";
				}
			}
			if(isproceed=="Y"){
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH  action='getTermCodeDesc' termCode=\""+termCode+"\" termSetId=\""+termSetId+"\" /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				if(responseText!=""){
					eval("document.forms[0].diagprob_code_"+id).value	= termCode.toUpperCase();
					eval("document.forms[0].diagprob_desc_"+id).value=responseText;
					if(document.forms[0].termSetCount.value=="1"){
						eval("document.forms[0].chk_"+id).checked	= true;
					}
				}else{
					var errMsg	= getMessage("INVALID_DIAG_CODE","MR");
					alert(errMsg);
					eval("document.forms[0].diagprob_code_"+id).value = "";
					eval("document.forms[0].diagprob_desc_"+id).value = "";
					eval("document.forms[0].diagprob_code_"+id).focus();
					if(document.forms[0].termSetCount.value=="1"){
						eval("document.forms[0].chk_"+id).checked	= false;
					}
				}
			}else{
					var errMsg	= getMessage("DUP_DIAG_PROC","MR");
					alert(errMsg);
					eval("document.forms[0].diagprob_code_"+id).value = "";
					eval("document.forms[0].diagprob_desc_"+id).value = "";
					eval("document.forms[0].diagprob_code_"+id).focus();
					if(document.forms[0].termSetCount.value=="1"){
						eval("document.forms[0].chk_"+id).checked	= false;
					}
			}
	}else{
		eval("document.forms[0].diagprob_desc_"+id).value = "";
	}

}

function chkPrimaryDiag(id){
	var diagnosisRowCount	= parseInt(document.forms[0].diagnosisRowCount.value);
	var selectedDiagCode			= eval("document.forms[0].diag_class_"+id).value;
	if(selectedDiagCode!=""){
		var selectedDiagType			= eval("parent.frames[0].document.forms[0]."+selectedDiagCode).value;
		var isPrimarySelected	= "N";
		for(i=0;i<diagnosisRowCount;i++){
			var chkDiagCode			= eval("document.forms[0].diag_class_"+i).value;
			if(chkDiagCode!=""){
				var chkDiagType		= eval("parent.frames[0].document.forms[0]."+chkDiagCode).value;
				if(id!=i && chkDiagType==selectedDiagType && chkDiagType!="" && chkDiagType=="PD" && selectedDiagType=="PD"){
					isPrimarySelected	= "Y";
				}
			}
		}
		if(isPrimarySelected=="Y"){
			alert(getMessage("PRIM_DIAGS_NOT_ALLOWED","MR"));
			eval("document.forms[0].diag_class_"+id).value ="";
		}
	}
}


function enableDisableFields(id){
	
	var termSetId	= eval("document.forms[0].termSetId_"+id).value;
	eval("document.forms[0].img_diag_class_"+id).style.display="none";
	eval("document.forms[0].img_diagprob_code_"+id).style.display="none";
	eval("document.forms[0].img_poa_indicator_"+id).style.display="none";
	eval("document.forms[0].img_onset_date_"+id).style.display="none";
	var visit_adm_date_time	= document.forms[0].visit_adm_date_time.value;
	if(termSetId!=""){
		eval("document.forms[0].diag_class_"+id).disabled			= false;
		eval("document.forms[0].diagprob_code_"+id).disabled		= false;
		eval("document.forms[0].btn_diagprob_code_"+id).disabled	= false;
		eval("document.forms[0].diagprob_desc_"+id).disabled		= false;
		eval("document.forms[0].poa_indicator_"+id).disabled		= false;
		eval("document.forms[0].onset_date_"+id).disabled			= false;
		eval("document.forms[0].cal_img_onset_date_"+id).disabled		= false;
		eval("document.forms[0].chk_"+id).disabled					= false;
		eval("document.forms[0].chk_reported_"+id).disabled			= false;
		eval("document.forms[0].chk_reported_"+id).checked			= true;
		eval("document.forms[0].chk_"+id).checked					= true;

		eval("document.forms[0].diag_class_"+id).value				= "";
		eval("document.forms[0].diagprob_code_"+id).value			= "";
		eval("document.forms[0].diagprob_desc_"+id).value			= "";
		
		if(eval("document.forms[0].onset_date_"+id).value==""){
			eval("document.forms[0].onset_date_"+id).value				= visit_adm_date_time;
		}

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH  action='getDiagClassification' termSetId=\""+termSetId+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		var data = eval(responseText);
		var count	= data.length;
		eval("document.forms[0].diag_class_"+id).options.length = 0;
		var	val	= "" ;
		var	txt	= "----------"+getLabel("Common.defaultSelect.label","Common")+"----------";
		var element = document.createElement('OPTION');
		element.text = txt; 
		element.value= val;
		eval("document.forms[0].diag_class_"+id).add(element);
		for(i=0;i<count;i++){
			var diagClassCode = data[i].diagClassCode;
			var diagShortDesc = data[i].diagShortDesc;
			element 	= document.createElement("OPTION");
			element.value 	= diagClassCode;
			element.text 	= diagShortDesc ;
			eval("document.forms[0].diag_class_"+id).add(element);
		}
	}else{
		eval("document.forms[0].diag_class_"+id).disabled			= true;
		eval("document.forms[0].diagprob_code_"+id).disabled		= true;
		eval("document.forms[0].btn_diagprob_code_"+id).disabled	= true;
		eval("document.forms[0].diagprob_desc_"+id).disabled		= true;
		eval("document.forms[0].poa_indicator_"+id).disabled		= true;
		eval("document.forms[0].onset_date_"+id).disabled			= true;
		eval("document.forms[0].cal_img_onset_date_"+id).disabled		= true;
		eval("document.forms[0].chk_"+id).disabled					= true;
		eval("document.forms[0].chk_reported_"+id).disabled			= true;
		eval("document.forms[0].diag_class_"+id).value				= "";
		eval("document.forms[0].diagprob_code_"+id).value			= "";
		eval("document.forms[0].diagprob_desc_"+id).value			= "";
		eval("document.forms[0].poa_indicator_"+id).value			= "";
		eval("document.forms[0].onset_date_"+id).value				= "";
		eval("document.forms[0].chk_"+id).checked					= false;
		eval("document.forms[0].chk_reported_"+id).checked			= false;
	}
}

function fnSave(){
	var selectedRows	= "";
	var isProceed		= "Y";
	var error			= "";
	var primaryDiagCount	= 0;
	var diagnosisRowCount	= parseInt(document.forms[0].diagnosisRowCount.value);
	var patientClass	= document.forms[0].patientClass.value;
	for(id=0;id<diagnosisRowCount;id++){
		var termSetId		= eval("document.forms[0].termSetId_"+id).value;
		eval("document.forms[0].img_diag_class_"+id).style.display="none";
		eval("document.forms[0].img_diagprob_code_"+id).style.display="none";
		eval("document.forms[0].img_poa_indicator_"+id).style.display="none";
		eval("document.forms[0].img_onset_date_"+id).style.display="none";
		if(eval("document.forms[0].chk_"+id).checked==true && termSetId!="" && eval("document.forms[0].chk_"+id).disabled==false){
			var diagClass		= eval("document.forms[0].diag_class_"+id).value;
			var termCode		= eval("document.forms[0].diagprob_code_"+id).value;
			var termCodeDesc	= eval("document.forms[0].diagprob_desc_"+id).value;
			var poaIndicator	= eval("document.forms[0].poa_indicator_"+id).value;
			var onSetDate		= eval("document.forms[0].onset_date_"+id).value;


			var reportedYN		= "N";
			//if(diagClass=="" || termCode=="" || (poaIndicator=="" && (patientClass=='IP' || patientClass =='DC')) || onSetDate==""){
			if(diagClass=="" || termCode=="" || (poaIndicator=="" && patientClass=='IP') || onSetDate==""){
				isProceed	= "N";
								
				if(diagClass==""){
					eval("document.forms[0].img_diag_class_"+id).style.display="inline";
				}

				if(termCode==""){
					eval("document.forms[0].img_diagprob_code_"+id).style.display="inline";
				}
			
				//if(poaIndicator=="" && (patientClass=='IP' || patientClass =='DC')){
				if(poaIndicator=="" && patientClass=='IP'){
					eval("document.forms[0].img_poa_indicator_"+id).style.display="inline";
				}

				if(onSetDate==""){
					eval("document.forms[0].img_onset_date_"+id).style.display="inline";
				}
			}

			if(diagClass!=""){
				var diagType	= eval("parent.frames[0].document.forms[0]."+diagClass).value;
				if(diagType=="PD"){
					primaryDiagCount++;
				}
			}
			selectedRows	= selectedRows+eval("document.forms[0].chk_"+id).value+"|~|";
		}
	}
	if(selectedRows==""){
		error =  getMessage("ATLEAST_ONE_SELECTED","Common");
		alert(error);
		return false;
	}else if(isProceed=="N"){
		error =  getMessage("ALL_MANDATORY_FIELDS","Common");
		alert(error);
		return false;
	}else if(primaryDiagCount > 1){
		error =  getMessage("PRIM_DIAGS_NOT_ALLOWED","MR");
		alert(error);
		return false;
	}
	else{
		document.forms[0].selectedRows.value	= selectedRows;
		document.forms[0].Save2.disabled	= true;//Added By Dharma on 30th Dec 2020 against AAKH-SCF-0482
		document.forms[0].submit();
	}
}

function onSuccess(){
	frames[1].location.reload();
}

function chkDateVal(obj){
	if(obj.value!=""){
		if(validDateObj(obj,'DMYHM',localeName)){
			if(isBeforeNow(obj.value,"DMYHM",localeName)){
				return true;
			}else{
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.focus();
				flagVal=false;					
			}
		}else{
			flagVal=false;				
		}
	}
}
