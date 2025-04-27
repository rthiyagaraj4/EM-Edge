

function reset() 
  {
	clear(); 
	f_patientDiagnosisCriteria.document.forms[0].reset() ;	
	
  } 
 
function clear()
{	
		
		f_patientDiagnosisResult.location.href="../../eCommon/html/blank.html" ;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;	
}


function callSearch()
{
		
	var date1 = document.forms[0].onset_date_from;
	var date2 = document.forms[0].onset_date_to;
	var mr_diagnosis_code = document.forms[0].mr_diagnosis_code.value;
	var mr_diagnosis_desc = document.forms[0].mr_diagnosis_desc.value;
//	var mr_diagnosis_type = document.forms[0].mr_diagnosis_type.value;
	var mr_diagnosis_set	= document.forms[0].mr_diagnosis_set.value;
	//var mr_date_from	  = document.forms[0].onset_date_from.value;
	//var mr_date_to		  = document.forms[0].onset_date_to.value;
	var mr_date_from	  = convertDate(document.forms[0].onset_date_from.value,"DMY",localeName,"en");
	var mr_date_to		  = convertDate(document.forms[0].onset_date_to.value,"DMY",localeName,"en");
	var error_msg="";
	if(mr_diagnosis_set==""){
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.DiagnosisCodingScheme.label","Common"));
		error_msg=error_msg+msg+"\n";
	}
	if (mr_diagnosis_code==""){
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.DiagnosisCode.label","Common"));
		error_msg=error_msg+msg;
	}
	if(error_msg==""){
		var	mr_display_active = '';
		if (document.forms[0].mr_display_active.checked==true){
			mr_display_active = 'A';
		}
		parent.frames[2].location.href="../../eMR/jsp/QueryDiagnosisResult.jsp?mr_diagnosis_code="+mr_diagnosis_code+"&mr_diagnosis_desc="+mr_diagnosis_desc+"&mr_display_active="+mr_display_active+"&mr_date_from="+mr_date_from+"&mr_date_to="+mr_date_to;			
	}else{
		alert(error_msg)
		return;
	}
}

function getDiagnosisDesc()
{
	
	document.forms[0].mr_diagnosis_desc.value="";
	var val1				= document.forms[0].mr_diagnosis_code.value;
	var name				= document.forms[0].diag_code.value;
	var term_set_id	= document.forms[0].mr_diagnosis_set.value;

	/*if(name!=null && name=='1')
		term_set_id	=	'ICD10';*/

	if(val1!='')
    {

        var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMR/jsp/QueryDiagnosisPopulateDesc.jsp'>"+
                            " <input type='hidden' name='scheme' id='scheme' value=\""+name+"\">"+
                            " <input type='hidden' name='code' id='code' value=\""+val1+"\">"+ 
							" <input type='hidden' name='term_set_id' id='term_set_id' value=\""+term_set_id+"\">"+ 
                            " </form></body></html>";
		
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.dum_form.submit();

    }

}
function clearDiagCode(){
		document.forms[0].mr_diagnosis_code.value="";
		document.forms[0].mr_diagnosis_desc.value="";
//		var obj_mr_diag_type=document.forms[0].mr_diagnosis_type;
//		obj_mr_diag_type.options.selectedIndex=0;
//		document.forms[0].mr_display_active.checked=false;
//		document.forms[0].onset_date_from.value="";
//		document.forms[0].onset_date_to.value="";
	var qry_result_fromObj=parent.f_patientDiagnosisResult.document.forms[0];
	if(qry_result_fromObj && qry_result_fromObj.name=="QRY_RESULT_DIAG_FROM"){
			parent.f_patientDiagnosisResult.location.href='../../eCommon/html/blank.html';
	}

}
async function callDiagnosis(){
		var dialogTop	  = "56vh";//50
		var dialogHeight  = "85vh" ;//20
		var dialogWidth   = "60vw" ;//50
		var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments   = "" ;
		var diag_code	= document.forms[0].diag_code.value;
		var diag_desc  = document.forms[0].diag_desc.value;
		var title      = "Term Set";
		var encounter_id	= '';
		var term_set_id	=	document.forms[0].mr_diagnosis_set.value;
		var defn_levels	="";
		var display_clos_btn="N";
		/*if(diag_code!=null && diag_code=='1')
		term_set_id	=	'ICD10';*/
		if(term_set_id==""){
			var msg=getMessage("CAN_NOT_BE_BLANK","Common");
			msg= msg.replace('$',getLabel("Common.DiagnosisCodingScheme.label","Common"));
			alert(msg);
			document.forms[0].mr_diagnosis_set.focus();
			return;
		}else{
			 defn_levels	=	eval("document.forms[0]."+term_set_id+"_dfn_level").value;
			//var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
			var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+"&p_diag_code=";		
			params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=&term_set_id="+term_set_id+"&defn_levels="+defn_levels+"&termsetid="+term_set_id+"&display_clos_btn="+display_clos_btn;   
			var retVal = await window.showModalDialog(params,arguments,features);
			if (!(retVal == null)){
				var retdata;
				retdata = retVal.split("/")  ;		 
				document.forms[0].mr_diagnosis_code.value=retdata[0];	
				getDiagnosisDesc();		 
			}
		}
		//document.forms[0].mr_diagnosis_code.focus();
}


// added from QueryDiagnosisResult.jsp

async function call_cafunction(patient_id)
{	
		/*var dialogHeight= "29.4" ;
        var dialogWidth = "50" ;
        var dialogTop = "75";*/

		//modified on 2 june 2008 for issue 4258.
		var dialogHeight= "99vh" ;
        var dialogWidth = "60vw" ;
        var dialogTop = "75";
		//
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
        var arguments   = "" ;
		var params = "../../eCA/jsp/PatProblemList.jsp?patient_id="+patient_id+"&modal_yn=Y";
        var retVal = await window.showModalDialog(params,arguments,features);
		
}

function CompareOnsetFromToDat(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.select();
				to.focus();
			}
		}
	}
}








