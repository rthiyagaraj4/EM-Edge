function reset()
{

	f_term_code_set.document.location.href = "../../eMR/jsp/TerminologyCodeTermSet.jsp";
	f_term_result_header.document.location.href = "../../eMR/jsp/TerminologyCodeResultHeader.jsp";
	f_term_code_result.document.location.href = "../../eCommon/html/blank.html";
	f_term_add_modify.document.location.href = "../../eMR/jsp/TerminologyCodeAddModify.jsp";
	f_term_selected_frms.f_term_disp_lvl.document.location.href = "../../eMR/jsp/TerminologyCodeDisplayLevels.jsp";
	f_term_selected_frms.f_term_selected_values.document.location.href = "../../eCommon/html/blank.html";
	messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function apply()
{	
	
	var codelevel = f_term_add_modify.document.term_code_addmodify.codelevel.value;	if(f_term_code_set.document.frm_terminology_code.terminology_set.value=="")
	{
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.TerminologySet.label","Common"));

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		return false ;
	}
	/*
	if(f_term_add_modify.document.term_code_addmodify.term_code.value=="")
	{
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$',getLabel("Common.code.label","Common"));

	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  f_term_add_modify.document.term_code_addmodify.term_code.focus();
	  return false ;
	}
	if(f_term_add_modify.document.term_code_addmodify.term_code.value=="null" || f_term_add_modify.document.term_code_addmodify.term_code.value=="NULL")
	{
		var msg="Term Code can not be null";
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  f_term_add_modify.document.term_code_addmodify.term_code.focus();
	  return false ;
	}
	if(f_term_add_modify.document.term_code_addmodify.short_desc.value=="")
	{
	  var msg = getMessage('SHORT_DESC_NOT_BLANK','MP');
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  f_term_add_modify.document.term_code_addmodify.short_desc.focus();
	  return false ;
	}
	if(f_term_add_modify.document.term_code_addmodify.proc_diag.value=="")
	{
	  var msg=getMessage("CAN_NOT_BE_BLANK","Common");
	  msg = msg.replace('$',getLabel("Common.type.label","Common"));
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  f_term_add_modify.document.term_code_addmodify.proc_diag.focus();
	  return false ;
	}
	if(f_term_add_modify.document.term_code_addmodify.long_desc.value=="")
	{
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.longdescription.label","Common"));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		return false ;
	}
*/

var	fields = new Array ( f_term_add_modify.document.term_code_addmodify.term_code,
			f_term_add_modify.document.term_code_addmodify.proc_diag,
			f_term_add_modify.document.term_code_addmodify.short_desc,
			f_term_add_modify.document.term_code_addmodify.long_desc
			);

	var	names =	new Array (getLabel("Common.code.label","Common"), getLabel("Common.type.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.longdescription.label","Common")
		);
	var disp_type="M";
      var specfield=new Array( f_term_add_modify.document.term_code_addmodify.term_code);
	   var specname=new Array(getLabel("Common.code.label","Common"));
      var error_jsp="../../eCommon/jsp/MstCodeError.jsp";

    
        if(f_term_add_modify.checkFieldsofMst( fields, names, messageFrame))
	{
			if(f_term_add_modify.document.term_code_addmodify.mode.value=="Modify")
	{
		f_term_add_modify.document.term_code_addmodify.proc_diag.disabled = false;
		f_term_add_modify.document.term_code_addmodify.sensitive.disabled = false;
		f_term_add_modify.document.term_code_addmodify.notifiable.disabled = false;
		f_term_add_modify.document.term_code_addmodify.selectable.disabled=false;
		f_term_add_modify.document.term_code_addmodify.submit();
		
	}
	else
	{
		

		if(codelevel!="1")
		f_term_add_modify.document.term_code_addmodify.part_term_code.value = f_term_add_modify.document.term_code_addmodify.termcode.value;
		else if(codelevel=="1")
			f_term_add_modify.document.term_code_addmodify.part_term_code.value = f_term_add_modify.document.term_code_addmodify.term_code.value;

f_term_add_modify.document.term_code_addmodify.submit();

		f_term_add_modify.document.term_code_addmodify.term_code.value="";
		f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;
		f_term_add_modify.document.term_code_addmodify.short_desc.value="";
		f_term_add_modify.document.term_code_addmodify.short_desc.readOnly=false;
		f_term_add_modify.document.term_code_addmodify.long_desc.value="";
		f_term_add_modify.document.term_code_addmodify.read_only.value = "";
		f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;
		f_term_add_modify.document.term_code_addmodify.selectable.checked=false;
		f_term_add_modify.document.term_code_addmodify.active.checked=false;
		f_term_add_modify.document.term_code_addmodify.potential.checked=false;
		f_term_add_modify.document.term_code_addmodify.wellness.checked=false;
		if(f_term_add_modify.document.term_code_addmodify.multi_desc) // added by mujafar for ML-MMOH-CRF-1281
		f_term_add_modify.document.term_code_addmodify.multi_desc.checked=false;
		f_term_add_modify.document.term_code_addmodify.sensitive.checked=false;
        //below line Added for incident [IN:037216]		
		if(f_term_add_modify.document.term_code_addmodify.sensitive&&!f_term_add_modify.document.term_code_addmodify.sensitive.checked){
		if(f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code) // added by mujafar for ML-MMOH-CRF-1281 against existing issue
		f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.disabled=true;
		}
		if(f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code)
		f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.value=""; // Newly Added for this CRF[BRU-HIMS-CRF-19.1] 
		f_term_add_modify.document.term_code_addmodify.notifiable.checked=false;
		f_term_add_modify.document.term_code_addmodify.code_indicator.value="";
		f_term_add_modify.document.term_code_addmodify.proc_diag.value="";
		f_term_add_modify.document.term_code_addmodify.part_term_code.value = "";
		f_term_add_modify.document.term_code_addmodify.mode.value = "";
		f_term_add_modify.document.term_code_addmodify.term_code.maxLength = f_term_add_modify.document.term_code_addmodify.term_code.size
	}
			

          
		 
        }
	
		
		
		//f_term_add_modify.document.term_code_addmodify.submit();
		
		
}
function onSuccess()
{
	f_term_add_modify.document.term_code_addmodify.termcode.value="";
	var termsetid = f_term_add_modify.document.term_code_addmodify.termsetid.value;
	var codelevel = f_term_add_modify.document.term_code_addmodify.codelevel.value;
	var diag_spec_yn = f_term_code_set.document.frm_terminology_code.diag_spec_yn.value;
	var proc_spec_yn = f_term_code_set.document.frm_terminology_code.proc_spec_yn.value;
	if(codelevel=="1")
	{
		var termcode = f_term_code_result.document.term_code_result.termsetid.value;
		f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
	}
	else
	{
		var termcode = f_term_code_result.document.term_code_result.termcode1.value;
		f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
	}
	if(f_term_code_result.document.term_code_result.className.value == "className")
		className = "className";
	else
		className = "";
	var htmlresvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_result' id='dynamic_result' method='post' action='../../eMR/jsp/TerminologyCodeResult.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='codelevel' id='codelevel' value='"+codelevel+"'><input type='hidden' name='termcode' id='termcode' value='"+termcode+"'><input type='hidden' name='className' id='className' value='"+className+"'><input type='hidden' name='diag_spec_yn' id='diag_spec_yn' value='"+diag_spec_yn+"'><input type='hidden' name='proc_spec_yn' id='proc_spec_yn' value='"+proc_spec_yn+"'></form></body></html>"
	f_term_code_result.document.write(htmlresvalue);
	f_term_code_result.document.dynamic_result.submit();
	if(f_term_add_modify.document.term_code_addmodify.mode.value=="Modify"){
		f_term_add_modify.document.location.reload();
	}
	/*else
	{
	
	f_term_code_set.document.location.href = "../../eMR/jsp/TerminologyCodeTermSet.jsp";
	f_term_result_header.document.location.href = "../../eMR/jsp/TerminologyCodeResultHeader.jsp";
	f_term_code_result.document.location.href = "../../eCommon/html/blank.html";
	f_term_add_modify.document.location.href = "../../eMR/jsp/TerminologyCodeAddModify.jsp";
	f_term_selected_frms.f_term_disp_lvl.document.location.href = "../../eMR/jsp/TerminologyCodeDisplayLevels.jsp";
	f_term_selected_frms.f_term_selected_values.document.location.href = "../../eCommon/html/blank.html";
	//messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";

	}*/
}

