 function run() {
	var frmObject = f_query_add_mod.document.formPhTherapeuticDrugStatCriteria;
	if(f_query_add_mod.document.formPhTherapeuticDrugStatCriteria) {
		var fields= new Array (frmObject.p_generic_name,frmObject.p_dt_from,frmObject.p_dt_to);
		var names= new Array (getLabel("Common.GenericName.label","Common"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhTherapeuticDrugStatCriteria.p_dt_from, f_query_add_mod.document.formPhTherapeuticDrugStatCriteria.p_dt_to, messageFrame ) ) {
			 {
				var locale=frmObject.p_language_id.value;
							frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
							frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
                        f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhTherapeuticDrugStatCriteria.submit();
				}
			}
		}
	}
}

function reset() {
    f_query_add_mod.formPhTherapeuticDrugStatCriteria.reset();
	f_query_add_mod.formPhTherapeuticDrugStatCriteria.p_facility_code.focus();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
async function callGenericSearch(obj) {
	var formObj = parent.f_query_add_mod.document.formPhTherapeuticDrugStatCriteria;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.forms[0].sql_ph_generic_name_select_lookup.value;
	dataNameArray  [0]="LANGUAGE_ID";
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
            var ret1=unescape(returnedValues);
            var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	 		obj.value = arr[1];
			formObj.P_GENERIC_CODE.value = arr[0];
	} 
}
