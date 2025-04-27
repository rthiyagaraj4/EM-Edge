 //saved on 25/01.2016
function run() {
	var frmObject = f_query_add_mod.document.formPhStatDrugInfoCriteria;
	if(f_query_add_mod.document.formPhStatDrugInfoCriteria) {
		var fields = "";
		var names = "";
		if(frmObject.report_for.value == "ADR"){
			fields= new Array (frmObject.p_dt_from,frmObject.p_dt_to);
			names = new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		else{
			fields= new Array (frmObject.p_dt_from,frmObject.p_dt_to,frmObject.report_by);
			names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.ReportBy.label","Common"));
		}
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhStatDrugInfoCriteria.p_dt_from, f_query_add_mod.document.formPhStatDrugInfoCriteria.p_dt_to, messageFrame ) ) {//dt_from to p_dt_from AND dt_to to p_dt_to Added for DateConversion identification
				  //Added for DateConversion identification-Start
						var locale=frmObject.p_language_id.value;
						frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
						frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
						var opt;
						var result = [];
						var status_append = "";
						var status_append1 = "";
						var inc = 0;
						var inc1 = 0;
						var status = "";
						var validation = "N";
						if(frmObject.report_for.value == "DIE"){
							if(frmObject.report_by.value == "RC"){
								status = frmObject.req_catg.options;
								frmObject.p_report_id.value  = "PHDIESRC";
							}
							else if(frmObject.report_by.value == "SR"){
								status = frmObject.Source.options;
								frmObject.p_report_id.value  = "PHDIESOURCE";
							}							
							else if(frmObject.report_by.value == "IS"){
								status = frmObject.info_source_dtl.options;
								frmObject.p_report_id.value  = "PHSTDIEINF";
							}
						}
						else{
							frmObject.p_report_id.value  = "PHSTADV";
						}
							
						for (var i=0; i<status.length; i++) {
						    opt = status[i];
						    if (opt.selected) {
						      result.push(opt.value);
						    }
						    if(opt.value != "ALL"){
						    	if(inc1>0)
									status_append1 = status_append1.concat(","+"'"+opt.value+"'");
								else{
									status_append1 = status_append1.concat("'"+opt.value+"'");
									inc1++;
								}
							}
						}
						for(var j=0; j < result.length ; j++){
							
							if(result.length > 1 && result[j] == "")
								validation = "Y";
							if(result[j] == ""){
								
								if(frmObject.report_by.value == "RC")
									status_append = "and a.req_cat_code in (select req_cat_code from ph_drug_req_enq_lang_vw where  eff_status ='E'  and  language_id =:p_language_id and  rownum between 1 and 25  ";
								else if(frmObject.report_by.value == "IS")
									status_append = "and a.INFO_CAT_CODE in (select INFO_CAT_CODE from PH_DRUG_INFO_ENQ_hdr_lang_vw where  eff_status ='E'  and  language_id =:p_language_id and  rownum between 1 and 25";
								else if(frmObject.report_by.value == "SR")
									status_append = "('WF','PC','OF','EF'";
								else
									status_append = status_append;	
								break;
							}
							else{
								validation = validation.concat("Y");
								if(inc>0){
									status_append = status_append.concat(","+"'"+result[j]+"'");
								}
								else{
									if(frmObject.report_by.value == "RC")
										status_append = "and a.req_cat_code in";
									else if(frmObject.report_by.value == "IS")
										status_append = "And a.info_cat_code in";
									
									/*else if(frmObject.report_by.value == "SR")
										status_append = "and  decode(source_of_request,:p_facility_id,01,'*P',02,'*F',03,source_of_request,04) in";*/
									status_append = status_append.concat("('"+result[j]+"'");
								}
								inc++;
							}
							
						}
						if(validation == "Y"){	messageFrame.document.location.href = '../../eCommon/jsp/error.jsp?err_num='+getMessage("PH_MULTIPLE_SELECTION", "PH"); return;}
						if(inc>25){
							var msg = getMessage("PH_MAX_FORM_SELECT_ALLOWED", "PH");
							msg = msg.replace('40','25');
							messageFrame.document.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							return false;
						}
						if(status_append != "")
							status_append = status_append.concat(")");
						frmObject.p_where.value = status_append;
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhStatDrugInfoCriteria.submit();
			}
		}
	}
}

function reset() {
    f_query_add_mod.formPhStatDrugInfoCriteria.reset();
	f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = true;
	f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = true;
	f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = true;
	f_query_add_mod.document.formPhStatDrugInfoCriteria.report_by.disabled = false;
	f_query_add_mod.document.formPhStatDrugInfoCriteria.reportby_img.style.visibility = 'visible';
	f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = false;
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function disableLocation(val)
{
	if(val==""){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = true;
	}
	else if(val=="RC"){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = false;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.value = "";
	}
		
	else if(val=="SR"){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = false;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = true;
	
	}
	else if(val=="IS"){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = false;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.value = "";
	}
	else if(val=="ADR"){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.report_by.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.disabled = true;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.Source.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.info_source_dtl.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.report_by.value = "";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.reportby_img.style.visibility = 'hidden';
	}
	else if(val=="DIE"){
		f_query_add_mod.document.formPhStatDrugInfoCriteria.report_by.disabled = false;
		f_query_add_mod.document.formPhStatDrugInfoCriteria.reportby_img.style.visibility = 'visible';
		f_query_add_mod.document.formPhStatDrugInfoCriteria.report_by.value = "RC";
		f_query_add_mod.document.formPhStatDrugInfoCriteria.req_catg.disabled = false;
	}
	
		
		
	

}
