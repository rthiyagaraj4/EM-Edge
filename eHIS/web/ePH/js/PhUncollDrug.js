  //saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhUncollDrugCriteria;
	if(f_query_add_mod.document.formPhUncollDrugCriteria) {
		var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_disp_loc_code);
		var names= new Array (getLabel("ePH.DispenseDateFrom.label","PH"),getLabel("Common.to.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));
		f_query_add_mod.document.formPhUncollDrugCriteria.dt_from.value = convertDate(f_query_add_mod.document.formPhUncollDrugCriteria.dt_from1.value,'DMY',f_query_add_mod.document.formPhUncollDrugCriteria.p_language_id.value,'en'); // Added for TTM-SCF-0150 [IN:060027]
		f_query_add_mod.document.formPhUncollDrugCriteria.dt_to.value = convertDate(f_query_add_mod.document.formPhUncollDrugCriteria.dt_to1.value,'DMY',f_query_add_mod.document.formPhUncollDrugCriteria.p_language_id.value,'en');	// Added for TTM-SCF-0150 [IN:060027]
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhUncollDrugCriteria.dt_from, f_query_add_mod.document.formPhUncollDrugCriteria.dt_to, messageFrame ) ) {
				if(f_query_add_mod.CheckString("Drug From", f_query_add_mod.document.formPhUncollDrugCriteria.drug_code, f_query_add_mod.document.formPhUncollDrugCriteria.tdrug_code, messageFrame) ) {
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.formPhUncollDrugCriteria.submit();
				}
				
			}
		}
	}
}




function reset() {
    f_query_add_mod.formPhUncollDrugCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formPhUncollDrugCriteria.p_language_id.value;
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}

/*function callDrugSearch(obj,mode) {
  	var arrCodeDesc = DrugSearch("D",obj);
	alert("stringreturn"+ arrCodeDesc);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_code.value = arrCodeDesc[0];
		else if (mode == 2)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_code.value = arrCodeDesc[0];
	    alert(arrCodeDesc[0]); 	
	//	document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
		alert(arrCodeDesc[1]);
	}
} */


async function callDrugSearch(obj,mode) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formPhUncollDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		}
		if (mode == 2)
		{		document.formPhUncollDrugCriteria.tdrug_code.value	=	arrCodeDesc[0];
		}
//		document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}








function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
	to.select();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}



function populateDispLocn(facility_id)
{

	bean_id		=	document.formPhUncollDrugCriteria.bean_id.value;
	bean_name	=	document.formPhUncollDrugCriteria.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PhRepMednOrdersValidation.jsp",false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)

}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.formPhUncollDrugCriteria.p_disp_loc_code.add(element);
}

function clearList()	{
var len			= document.formPhUncollDrugCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<len;i++) {
		document.formPhUncollDrugCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}

	var tp = "            --- Select ---               " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhUncollDrugCriteria.p_disp_loc_code.add(opt);
}
