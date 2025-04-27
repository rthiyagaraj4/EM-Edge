  //saved on 04/11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	if(f_query_add_mod.document.formPhRepDispStatByDrugCriteria) {
		var fields= new Array (frmObject.drug_name, frmObject.P_Report_By);
		var names= new Array (getLabel("Common.DrugName.label","Common"),getLabel("Common.ReportBy.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_from, f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_to, messageFrame )){
				var locale = frmObject.p_language_id.value;
				frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
				frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
				f_query_add_mod.document.formPhRepDispStatByDrugCriteria.drug_name.value="";//Added for MMS_ADHOC_0028
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame"
            			f_query_add_mod.document.formPhRepDispStatByDrugCriteria.submit();
           			f_query_add_mod.document.formPhRepDispStatByDrugCriteria.drug_code.value="";//Added for MMS_ADHOC_0028
  			}
 		}
	}
}

function reset() {
/*	searchFrame.formPhRepDrugsByGenName.reset();*/
    f_query_add_mod.formPhRepDispStatByDrugCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

/*function callResultPage()	{
  var result	=	false;
  frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from_1;
  to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to_1;
  msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame) )		 {
		result	=	true;
	}
	else {
		result  = false;
	}
	alert(result);
	return result;
}*/

async function callDrugSearch(obj) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}