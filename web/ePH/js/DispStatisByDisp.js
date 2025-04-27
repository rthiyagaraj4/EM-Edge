  //saved on 04/11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhDispStatisByDispCriteria;
	var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_drg_stat_dispr_select1").value;
	f_query_add_mod.document.getElementById("sql_ph_drg_stat_dispr_select1").value="";
	if(f_query_add_mod.document.formPhDispStatisByDispCriteria) {
		var fields= new Array (frmObject.p_select_by,frmObject.p_dt_from,frmObject.p_dt_to,frmObject.p_group_by,frmObject.p_report_by);
		var names= new Array (getLabel("ePH.SelectBy.label","PH"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {//dt_from to p_dt_from AND dt_to to p_dt_to Added for DateConversion identification
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDispStatisByDispCriteria.p_dt_from, f_query_add_mod.document.formPhDispStatisByDispCriteria.p_dt_to, messageFrame ) ) {
				if(f_query_add_mod.CheckString(getLabel("ePH.DispenserId.label","PH"), f_query_add_mod.document.formPhDispStatisByDispCriteria.pract_id, f_query_add_mod.document.formPhDispStatisByDispCriteria.tpract_id, messageFrame) ) {
				 //Added for DateConversion identification-Start
				 var locale=frmObject.p_language_id.value;
							frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
							frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhDispStatisByDispCriteria.submit();
				}
				
			}
		}
	}
	f_query_add_mod.document.getElementById("sql_ph_drg_stat_dispr_select1").value = temp_qry_1;
}

function reset() {
    f_query_add_mod.formPhDispStatisByDispCriteria.reset();
	f_query_add_mod.formPhDispStatisByDispCriteria.p_facility_code.focus();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function searchPractitionerName(target, mode) {
	
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	/*dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhDispStatisByDispCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[0]	= "FACILITY_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhDispStatisByDispCriteria.p_facility_code.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhDispStatisByDispCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;*/

	argumentArray[0] = f_query_add_mod.document.getElementById("sql_ph_drg_stat_dispr_select1").value+"'"+f_query_add_mod.document.formPhDispStatisByDispCriteria.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray = await CommonLookup( "Dispenser Search", argumentArray );
	
	if(retArray != null && retArray != "") {

         var ret1=unescape(retArray);
            var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (mode == 1)
			f_query_add_mod.document.formPhDispStatisByDispCriteria.pract_id.value = arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhDispStatisByDispCriteria.tpract_id.value = arr[0];

		target.value = arr[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}
