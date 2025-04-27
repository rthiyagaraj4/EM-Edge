
/* 
	Developer		: Sridevi Joshi
	Completed On	: 02/05/07
	Modified On		: 07/06/07 
*/

function create(){
	f_query_add_mod.location.href='../../eOH/jsp/MSpltyConditionsAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];

	if(frm == null){
		commontoolbarFrame.location.reload();
	}
    else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].condition_code,f_query_add_mod.document.forms[0].condition_desc,f_query_add_mod.document.forms[0].splty_module_id,f_query_add_mod.document.forms[0].condition_type);
		var conditioncode_title=getLabel("eOH.ConditionCode.Label","OH");
		var conditiondesc_title = getLabel("Common.description.label","Common");
		var spltymoduleid_title = getLabel("eOH.SpecialityModuleId.Label","OH");
		var conditiontype_title = getLabel("eOH.ConditionType.Label","OH");
		var effstatus_title = getLabel("Common.enabled.label","Common");
		var names = new Array ( conditioncode_title,conditiondesc_title,spltymoduleid_title,conditiontype_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var fields1 = new Array (f_query_add_mod.document.forms[0].condition_code);
			var names1 = new Array ( conditioncode_title);

			var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
			if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
			{
				f_query_add_mod.document.forms[0].submit();
			}
		}
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MSpltyConditionsAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
//	if(f_query_add_mod.document.forms[0].mode.value=="insert")
//		f_query_add_mod.location.href='../../eOH/jsp/MSpltyConditionsAddModify.jsp?mode=insert';	
//	else
         //f_query_add_mod.location.reload();

	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MSpltyConditionsQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MSpltyConditionsQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}

function addOption(obj,text,value,selected) {
	var treatmentobj = document.forms[0].condition_type;
	if (obj!=null && obj.options!=null) {
		treatmentobj.options[treatmentobj.options.length] = new Option(text, value, false, selected);
	}
}

function AssignDBValue(){
	var obj = document.forms[0];
	var mode = document.forms[0].mode.value;
	if(mode == "modify"){
		if(obj.splty_module_id.DB_VALUE == "" ){
			obj.splty_module_id.value = "";
		}
		else{
			obj.splty_module_id.value = obj.splty_module_id.DB_VALUE
		}

		if(obj.condition_type.DB_VALUE == "" ){
			obj.condition_type.value = "";
		}
		else{
			obj.condition_type.value = obj.condition_type.DB_VALUE
		}
		
	}
}

function addTreatmentTypesList(obj,value,desc) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  value ;
	element.text 	= desc ;
	obj.add(element);	
} // End of addCategoryList


function clearTreatmentTypesList( target_search_obj ) {
	var formObj = document.forms[0];	
	var len = target_search_obj.options.length;
	for(var i=0;i<len;i++){
		eval("target_search_obj.remove(\"category_procedure_text\")") ;
	}
	var tp 		= getLabel("Common.defaultSelect.label","Common"); 
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	target_search_obj.add(opt) ;
} // End of clearCategoryList


function populateConditionTypes(obj){
	var formObj = document.forms[0];
	var	condition_type_obj = formObj.condition_type;
	var	splty_module_id = formObj.splty_module_id.value;
	if(obj!=null && obj!=""){
		//Clear the Existing (if any) List of Treatment Types
		clearTreatmentTypesList(condition_type_obj);

		// get the Treatment Types for the selected Splty Module Id
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "splty_module_id="+splty_module_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateConditionTypes&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		// add the list of Treatment Types for the selected Splty Module Id
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				addTreatmentTypesList(condition_type_obj,code_desc_arr[0],code_desc_arr[1]);
			}
		}
	}
}


