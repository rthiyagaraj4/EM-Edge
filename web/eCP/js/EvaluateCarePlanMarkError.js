//This file is saved on 18/10/2005


var error_remarks = "";
async function showerror(obj,plan_id,md_plan_id,current_status,patient_id,care_mgr_name)
{
	if(obj.innerText == "X")
	{
		var care_manager_id = parent.eval_cp_criteria.document.eval_cp_crit.care_manager_id.value;
		var term_set_id = parent.eval_cp_criteria.document.eval_cp_crit.eval_diag.value;
		var term_code = parent.eval_cp_criteria.document.eval_cp_crit.diagnosis.value;
		var facilty_id = parent.eval_cp_criteria.document.eval_cp_crit.facilty_id.value;
		var encounter_id = parent.eval_cp_criteria.document.eval_cp_crit.encounter_id.value;
		var from_date = parent.eval_cp_criteria.document.eval_cp_crit.eval_frmdate.value;
		var to_date= parent.eval_cp_criteria.document.eval_cp_crit.eval_todate.value;
		var view_plans= parent.eval_cp_criteria.document.eval_cp_crit.view_plans.value;
		var view_summary= parent.eval_cp_criteria.document.eval_cp_crit.view_summary.value;
		var cp_start_date = eval("document.forms[0].start"+md_plan_id+plan_id+patient_id).value;
		var cp_target_date = eval("document.forms[0].target"+md_plan_id+plan_id+patient_id).value;
		var url = "";
		var encounter_id = document.forms[0].encounter_id.value;
		var dialogHeight = '80vh';
		//var dialogWidth = window.screen.width ;
		var dialogWidth = '90vw' ;
		var dialogTop	= '10';
		var dialogLeft = '0' ;
		var arguments   = "" ;
		url = "../../eCP/jsp/EvaluateCarePlanMarkErrorFrameset.jsp?planid="+plan_id+"&md_plan_id="+md_plan_id+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&care_mgr_name="+care_mgr_name+"&current_status="+current_status;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
		var returnval = await top.window.showModalDialog( url, arguments, features ) ;
		if(returnval=="SUCCESS")
			document.location.href  = "../../eCP/jsp/EvaluateCarePlanActivePlansResult.jsp?p_patient_id="+patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date+"&view_plans="+view_plans+"&view_summary="+view_summary;
	}
}
function showdetail(md_plan_id,care_plan_id,eval_id,mode)
{
	parent.eval_cp_mrk_err_dtl.location.href = "../../eCP/jsp/EvaluateCarePlanFrameset.jsp?planid="+care_plan_id+"&md_plan_id="+md_plan_id+"&eval_id="+eval_id+"&mode="+mode;
}
async function callreason(md_plan_id,care_plan_id,eval_id,mode)
{
	var dialogHeight = '35vh';
	var dialogWidth = '30vw' ;
	var dialogTop	= '10';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	url = "../../eCP/jsp/EvaluateCarePlanMarkErrorReasonFrameset.jsp?md_plan_id="+md_plan_id+"&care_plan_id="+care_plan_id+"&eval_id="+eval_id+"&error_remarks="+error_remarks+"&mode="+mode;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval =await window.showModalDialog( url, arguments, features ) ;
	if(returnval!=undefined)
	{
		if(returnval!="")
		{
			var err_val = returnval.split("||");
			if(err_val[1]=="mrkerror")
				error_remarks = err_val[0];
		}
		if (returnval=="SUCCESS")
		{
			window.returnValue = "SUCCESS";
			window.close();
		}
	}
}
function winclose()
{
	window.returnValue = document.eval_cp_mrk_err_rsn_form.mrk_reason.value+"||"+document.eval_cp_mrk_err_rsn_form.mode.value;
	window.close();
}
function record()
{
	if(document.eval_cp_mrk_err_rsn_form.mrk_reason.value!="")
		document.eval_cp_mrk_err_rsn_form.submit();
	else
		alert(getMessage("REMARKS_NOT_BLANK","CP"));
}
function notallowenter(event)
{
	if(window.event.keyCode==13)
		return false
	var desc = document.eval_cp_mrk_err_rsn_form.mrk_reason.value;
	var len = eval(desc.length);
	if(len>=400)
	{
		document.eval_cp_mrk_err_rsn_form.mrk_reason.readOnly = true;
		return false
	}
}
function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length>=400){
		message=getMessage("CAN_NOT_BE_EXEED","CP");
		alert(message);
		var s1=expltext.substring(0,399);
		obj.value=s1;
		//obj.select();
		obj.focus();
	}
}
