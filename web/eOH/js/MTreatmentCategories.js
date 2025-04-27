
/* 
	Developer		: Sridevi Joshi
	Completed On	: 10/05/07
	Modified On		: 07/06/07 
*/
function create(){
	f_query_add_mod.location.href='../../eOH/jsp/MTreatmentCategoriesAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}																  
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].trmt_category_code,f_query_add_mod.document.forms[0].trmt_category_desc,f_query_add_mod.document.forms[0].splty_module_id,f_query_add_mod.document.forms[0].trmt_category_type);
		var code_title=getLabel("eOH.TreatmentCategoryCode.Label","OH");
		var trmt_category_desc_title = getLabel("Common.description.label","Common");
		var specialitymoduleid_title = getLabel("eOH.SpecialityModuleId.Label","OH");
		var trmtcategorytype_title = getLabel("eOH.TreatmentCategoryType.Label","OH");

		var names = new Array ( code_title,trmt_category_desc_title,specialitymoduleid_title,trmtcategorytype_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var fields1 = new Array (f_query_add_mod.document.forms[0].trmt_category_code);
			var names1 = new Array ( code_title);
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
		f_query_add_mod.location.href='../../eOH/jsp/MTreatmentCategoriesAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
    //f_query_add_mod.location.reload();
	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MTreatmentCategoriesQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MTreatmentCategoriesQueryCriteria.jsp';
}

function setCheckValue(obj){
	if(obj == "denture_removable"){//Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
		if(document.forms[0].denture_removable.checked==true)
			document.forms[0].denture_removable.value="Y";
		else
			document.forms[0].denture_removable.value="N";
			document.forms[0].denture_removable1.value="N";
		
	}
	else{
		if(document.forms[0].eff_status.checked==true)
			document.forms[0].eff_status.value="E";
		else
			document.forms[0].eff_status.value="D";
	}
}

function addOption(obj,text,value,selected) {
	var treatmentobj = document.forms[0].trmt_category_type;
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

		if(obj.trmt_category_type.DB_VALUE == "" ){
			obj.trmt_category_type.value = "";
		}
		else{
			obj.trmt_category_type.value = obj.trmt_category_type.DB_VALUE
		}
	}

	// To get Denture_removable for any category for Denture added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=getDentureRemovable&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal); 
	if(retVal.length > 0 && document.getElementById("denture_removable") != null){
		if(parseInt(retVal) > 0 && document.getElementById("denture_removable").checked==false){
			document.getElementById("denture_removable").disabled=true;
		}
		else{
			//document.getElementById("denture_removable").disabled=false;
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


function populateTreatmentTypes(obj){
	var formObj = document.MTreatmentCategoriesForm;
	var	trmt_category_type_obj = formObj.trmt_category_type;
	var	splty_module_id = formObj.splty_module_id.value;
	if(obj!=null && obj!=""){
		//Clear the Existing (if any) List of Treatment Types
		clearTreatmentTypesList(trmt_category_type_obj);

		// get the Treatment Types for the selected Splty Module Id
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "splty_module_id="+splty_module_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateTreatmentTypes&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		// add the list of Treatment Types for the selected Splty Module Id
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				addTreatmentTypesList(trmt_category_type_obj,code_desc_arr[0],code_desc_arr[1]);
			}
		}
	}
}


function setOptionValue(obj){//Added by Sridevi Joshi on 2/8/2010 for IN010871(SRR20056-CRF-0478)
	var trmt_cat = obj.value;
	var checked = "";
	var checked_val = "N";
	var formObj = document.forms[0];
	var mode = formObj.mode.value;
	var trmt_category_code = formObj.trmt_category_code.value;
	if(trmt_cat == "DENTURE"){

		// To get Denture_removable for any category for Denture added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "trmt_cat_code="+trmt_category_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=getDentureRemovableYN&"+params,false);
		xmlHttp.send(xmlDoc);
		var den_rem = trimString(xmlHttp.responseText);
		den_rem = localTrimString(den_rem); 

		if(den_rem == "Y"){
			checked = "checked"
			checked_val = "Y";
		}


		document.getElementById("denture_removable_label").innerHTML = "Removable";
		//document.getElementById("denture_removable").innerHTML = "<input type='checkbox' name='denture_removable' id='denture_removable' onClick=setCheckValue('denture_removable'); value=''>";
		document.getElementById("denture_removable_field").innerHTML = "<input type='checkbox' name='denture_removable' id='denture_removable' onClick=setCheckValue('denture_removable'); value='"+checked_val+"' "+checked+">";

		
		// To get Denture_removable for any category for Denture added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=getDentureRemovable&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal); 
		if(retVal.length > 0 && document.getElementById("denture_removable") != null){
			if(parseInt(retVal) > 0 && den_rem != "Y"){
				document.getElementById("denture_removable").disabled=true;
			}
			else{
				//document.getElementById("denture_removable").disabled=false;
			}
		}

		if(document.getElementById("denture_removable").checked == true){
			formObj.denture_removable1.value = "Y";
		}
	
	}
	else{
		formObj.denture_removable1.value = "N";
		document.getElementById("denture_removable_label").innerHTML ="";
		document.getElementById("denture_removable_field").innerHTML ="";
	}
}

