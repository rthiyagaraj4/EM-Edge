
function create(){
	f_query_add_mod.location.href='../../eOH/jsp/MSpltyTreatmentProcAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].splty_module_id,f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_category_code);
		var trmt_code_title=getLabel("eOH.TreatmentProcedure.Label","OH");
		//var order_catalog_code_title = getLabel("eOH.OrderCatalogue.Label","OH");
		var specialitymoduleid_title = getLabel("eOH.SpecialityModuleId.Label","OH");
		var trmtcategorycode_title = getLabel("eOH.TreatmentCategoryCode.Label","OH");

		var names = new Array (specialitymoduleid_title,trmt_code_title,trmtcategorycode_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MSpltyTreatmentProcAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
//	if(f_query_add_mod.document.forms[0].mode.value=="insert")
//		f_query_add_mod.location.href='../../eOH/jsp/MTreatmentCategoriesAddModify.jsp?mode=insert';	
//	else
         //f_query_add_mod.location.reload();

	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MSpltyTreatmentProcQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MSpltyTreatmentProcQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
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

		if(obj.trmt_category_code.DB_VALUE == "" ){
			obj.trmt_category_code.value = "";
		}
		else{
			obj.trmt_category_code.value = obj.trmt_category_code.DB_VALUE
		}
		if(obj.trmt_code.DB_VALUE == "" ){
			obj.trmt_code.value = "";
		}
		else{
			obj.trmt_code.value = obj.trmt_code.DB_VALUE
		}
		if(obj.order_catalog_code.DB_VALUE == "" ){
			obj.order_catalog_code.value = "";
		}
		else{
			obj.order_catalog_code.value = obj.order_catalog_code.DB_VALUE
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


function populateTreatmentCodes(obj){
	var formObj = document.forms[0];
	var	trmt_category_code_obj = formObj.trmt_category_code;
	var	splty_module_id = formObj.splty_module_id.value;
	if(obj!=null && obj!=""){
		//Clear the Existing (if any) List of Treatment Types
		clearTreatmentTypesList(trmt_category_code_obj);

		// get the Treatment Types for the selected Splty Module Id
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "splty_module_id="+splty_module_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateTreatmentCodes&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		// add the list of Treatment Types for the selected Splty Module Id
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				addTreatmentTypesList(trmt_category_code_obj,code_desc_arr[0],code_desc_arr[1]);
			}
		}
	}
}
