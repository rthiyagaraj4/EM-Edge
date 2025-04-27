function run() {
	var frmObject = f_query_add_mod.document.formListOfBalanceMedCriteria;
	if (f_query_add_mod.document.formListOfBalanceMedCriteria) {
		locale = frmObject.p_language_id.value;
		var fields = new Array(frmObject.p_facility,
		frmObject.p_disp_locn_code, frmObject.p_nxt_date_disp);
		var names = new Array(getLabel("Common.FacilityName.label", "Common"),getLabel("ePH.DispenseLocation.label", "PH"), getLabel("ePH.CollectionDate.label", "PH"));
		if (checkFields(fields, names, messageFrame)) {
			frmObject.p_nxt_date.value=convertDate(frmObject.p_nxt_date_disp.value,'DMY',locale,"en");
			if(isAfterNow(frmObject.p_nxt_date_disp.value,'DMY',locale)){
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				frmObject.submit();
			}
			else{
				alert(getMessage("COLL_GRT_SYSDATE", "PH"));
				frmObject.p_nxt_date_disp.select();
			}
		}
	}
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formListOfBalanceMedCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			return false;
		}
	}
	else {
		obj.value = convertDate(obj, 'DMY', locale, 'en');
	}
}

function reset() {
	f_query_add_mod.formListOfBalanceMedCriteria.reset();
	messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
}


function populateDispLocn(facility_id){

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest(); 
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "facility_id =\"" + facility_id + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=getDispLocByFacilityId",false ) ; 
	xmlHttp.send( xmlDoc ) ; 
	responseText=xmlHttp.responseText ;
	eval( responseText );

}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= decodeURIComponent(desc) ;
	document.formListOfBalanceMedCriteria.p_disp_locn_code.add(element);
}

function clearList(){
	var len			= document.formListOfBalanceMedCriteria.p_disp_locn_code.options.length;
	for(var i=0;i<len;i++) {
		document.formListOfBalanceMedCriteria.p_disp_locn_code.remove("p_disp_locn_code") ;
	}

	var tp = "   --- Select ---     " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formListOfBalanceMedCriteria.p_disp_locn_code.add(opt);
}
