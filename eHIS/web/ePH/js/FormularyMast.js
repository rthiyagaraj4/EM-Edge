var function_id	= "" ; 
var result		= false ;
var message		= "" ;
var flag		= "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/FormularySearchQueryFrame.jsp?mode="+MODE_INSERT;	
}

function query() {
    f_query_add_mod.location.href="../../ePH/jsp/FormularyQueryCriteria.jsp" ;
}

function reset() {
	 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();

		var formarray ="";
		var called_from="";
		if(f_query_add_mod.FormularyQuerySearchFrame){
			if(f_query_add_mod.FormularyQuerySearchFrame.document.formulary_drug_search){
			formarray = f_query_add_mod.FormularyQuerySearchFrame.document.formulary_drug_search;
			called_from = formarray.called_from.value;
			}
		}


		
		if(url.indexOf("formularysearchqueryframe")!=-1 && called_from!="modify"){
			f_query_add_mod.location.href="../../ePH/jsp/FormularySearchQueryFrame.jsp?mode="+MODE_INSERT;
		}
		else if(url.indexOf("formularyquerycriteria")!=-1){
			f_query_add_mod.location.href="../../ePH/jsp/FormularyQueryCriteria.jsp";
		
		}
		else if(url.indexOf("formularysearchqueryframe")!=-1){
			
		
		var formulary_code = formarray.formulary_code.value;
		var formulary_desc = formarray.formulary_desc.value;
		var formulary_type = formarray.billing_type.value;
		formulary_desc = encodeURIComponent(formulary_desc,"UTF-8");
		var enable_status = formarray.enable_status.value;

		f_query_add_mod.location.href="../../ePH/jsp/FormularySearchQueryFrame.jsp?called_from=modify&formulary_code="+formulary_code+"&formulary_desc="+formulary_desc+"&formulary_type="+formulary_type+"&enable_status="+enable_status;
		}

		
}


 function apply(){

		f_query_add_mod.FormularyQuerySearchFrame.document.formulary_drug_search.mode.value=MODE_INSERT;
		var formarray  =f_query_add_mod.FormularyQuerySearchFrame.document.formulary_drug_search;
	
		var formulary_code = formarray.formulary_code.value;
		var formulary_desc = formarray.formulary_desc.value;

		if(f_query_add_mod.FormularyQueryResult.document.FormularyDrugSearchResult==undefined){
			formarray.formulary_apply_proceed.value="";
		}else{
			record_count_flag = f_query_add_mod.FormularyQueryResult.document.FormularyDrugSearchResult.record_count_flag.value;
			
			if(record_count_flag=="false" || record_count_flag==false)
				formarray.formulary_apply_proceed.value="";
			else
				formarray.formulary_apply_proceed.value="Y";
		}
		var blng_grp_cunt = formarray.blng_grp_cunt.value;
			var blng_flag = false;
			for(i=0;i<parseInt(blng_grp_cunt);i++){
				
				 if(eval("formarray.Billing_group_"+i).disabled==false){
					if(eval("formarray.Billing_group_"+i).checked==true){
						blng_flag = true;
						break;
					}
				 }
			} 
			if(blng_flag==false)
				formarray.blng_grp_mand.value="";
			else
				formarray.blng_grp_mand.value="Y"; 

			if(formarray.enable_status.checked==true)
				formarray.enable_status.value = "E";
			else
				formarray.enable_status.value = "D";


			if(formarray.enable_status.value == "D"){
				formarray.blng_grp_mand.value="Y"; 
				
				for(i=0;i<parseInt(blng_grp_cunt);i++){
				
				 if(eval("formarray.Billing_group_"+i).disabled==false){
					if(eval("formarray.Billing_group_"+i).checked==true){
						eval("formarray.Billing_group_"+i).checked = false;
						saveBlgGroupID(eval("formarray.Billing_group_"+i));
					}
				 }
			}

			}


			var fields	= new Array(formarray.formulary_code, formarray.formulary_desc,formarray.formulary_apply_proceed,formarray.blng_grp_mand);
			var names	= new Array(getLabel("ePH.FormularyCode.label","ph"),getLabel("ePH.FormularyDescription.label","ph"),getLabel("ePH.AtleastOneFormularyItemSelected.label","ph")			,getLabel("ePH.AtleastOneFormularyBlngGrpSelected.label","ph"));
	
		if(checkFieldsofMst(fields, names, messageFrame)) {
	
	

			eval(formApply(formarray,PH_CONTROLLER ));
			
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		

			if( result ) {
				onSuccess();		
			}
	}
	
}

function checkDuplicate(obj){
	if(obj.value!=""){
	var bean_id			= "FormularyBillingGroupBean";
	var bean_name       = "ePH.FormularyBillingGroupBean";
	var xmlStr ="<root><SEARCH ";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	
	xmlStr+= "formulary_code =\"" +obj.value+ "\" " ;	

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "FormularyValidation.jsp?called_from=checkDuplicate", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	}

}
function duplicateFormularyAlert(){
		alert(getMessage("PH_FORMULARY_CODE_ALREADY_EXISTS","PH"));
		document.formulary_drug_search.formulary_code.focus();
		 return false;
}
function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/FormularySearchQueryFrame.jsp?mode="+MODE_INSERT;

}
function assignResult( _result, _message, _flag ) {

	result	= _result ;
	message	= _message ;
    flag	= _flag ;
}


function getItemType(obj)
{   
	if(obj.value=="D")
		{
		document.getElementById("item_generic_name").style.display="inline";
		document.getElementById("item_tech_name").style.display="none";
		document.getElementById("drug_form_name").style.display="inline";
		}
	else if(obj.value="M")
		{
		document.getElementById("item_tech_name").style.display="inline";
	    document.getElementById("item_generic_name").style.display="none";
	  
	    document.getElementById("drug_form_name").style.display="none";
        }
}

function getBillingType(obj)
{

	var bean_id			= "FormularyBillingGroupBean";
	var bean_name       = "ePH.FormularyBillingGroupBean";
	var xmlStr ="<root><SEARCH ";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	
	xmlStr+= "billing_type =\"" +obj.value+ "\" " ;	

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "FormularyValidation.jsp?called_from=setBillingGrp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	
}

function getGenericSearch(obj)
{
	var a=document.getElementById("generic_name").value;
	document.getElementById("item_technical_name").value="";
}

function getItemSearch(obj)
{
	var b=document.getElementById("item_technical_name").value;
	document.getElementById("generic_name").value="";
}

function searchItemTech(objCode,objDesc) {

	//var oldobjDesc = decodeURIComponent(objDesc.value,"UTF-8"); 
	
 	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

    var language_id  = document.formulary_drug_search.language_id.value;

    argumentArray[0] = document.formulary_drug_search.SQL_MM_ITEM_TECH_NAME.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("eMM.ItemTechName.label","eMM"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}
	
 		
}

function searchGenericName(objCode,objDesc)
{
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    var language_id  = document.forms[0].language_id.value;
    
    argumentArray[0] = document.formulary_drug_search.SQL_PH_DRUG_SEARCH_GENERIC.value+"'"+language_id+"'";
    
    argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	
	argumentArray[7] = CODE_DESC;
	
	returnedValues = CommonLookup( getLabel("Common.GenericNameLookup.label","Common"), argumentArray );

	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		clearFormNameList();

		var bean_id			= "FormularyBillingGroupBean";
		var bean_name       = "ePH.FormularyBillingGroupBean";
		var xmlStr ="<root><SEARCH ";	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
		xmlStr += "generic_id=\""+objCode.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "FormularyValidation.jsp?called_from=getFormNames", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}

}



function changeForm(obj){

		
		clearStrengthList();
		var generic_id = document.formulary_drug_search.generic_id.value;
		var form_name = document.formulary_drug_search.form_name.value;
		if(form_name!=""){
		var bean_id			= "FormularyBillingGroupBean";
		var bean_name       = "ePH.FormularyBillingGroupBean";
		var xmlStr ="<root><SEARCH ";	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
		xmlStr += "generic_id=\""+generic_id +"\" " ;
		xmlStr += "form_code=\""+obj.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "FormularyValidation.jsp?called_from=getStrengthValues", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		}
}

function saveBlgGroupID(obj){

		
		if(obj.checked==true){
		 checked_yn = "Y";
		}else{
		 checked_yn = "N";
		}
		var bean_id			= "FormularyBillingGroupBean";
		var bean_name       = "ePH.FormularyBillingGroupBean";
		var xmlStr ="<root><SEARCH ";	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
		xmlStr += "checked_yn=\""+checked_yn +"\" " ;
		xmlStr += "blg_grp_id=\""+obj.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "FormularyValidation.jsp?called_from=saveBlgGroupID", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);

	}


function addFormNameList(code,desc){
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.formulary_drug_search.form_name.add(element);
}

function clearFormNameList(){

	var len =document.formulary_drug_search.form_name.options.length;

	for(var i=0;i<len;i++) {
		if(document.formulary_drug_search.form_name.value!="")
		document.formulary_drug_search.form_name.remove("form_name") ;
	}
	clearStrengthList();
}

function addStrengthValueList(code,desc){
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	 
	document.formulary_drug_search.strength.add(element);
}

function clearStrengthList(){
	var len =document.formulary_drug_search.strength.options.length;
	for(var i=0;i<len;i++) {
		if(document.formulary_drug_search.strength.value!="")
		document.formulary_drug_search.strength.remove("strength") ;
	}
}
function changeStrength(obj){

}
async function getItemSearchList(called_from){

	var formObj		   = document.formulary_drug_search;
	var strength_value = formObj.strength.value;
	var form_code      = formObj.form_name.value;
	var generic_id     = formObj.generic_id.value;
	var generic_name   = formObj.generic_name.value;
	var item_type	   = formObj.item_type.value;


	var formulary_code = formObj.formulary_code.value;
	var formulary_desc = formObj.formulary_desc.value;
	

	

	var strength_txt ="";
	var form_name_txt="";

	 if(item_type=="D" && called_from!="modify"){
		 strength_txt   = formObj.strength.options[formObj.strength.selectedIndex].innerText;
		 form_name_txt  = formObj.form_name.options[formObj.form_name.selectedIndex].innerText;
		 
		 if(formObj.strength.value==""){
			alert(getMessage("PH_FORMULARY_CANT_BE_BLANK","PH"));
			 return false;
		 }
		 if(formObj.form_name.value==""){
			alert(getMessage("PH_FORMULARY_CANT_BE_BLANK","PH"));
			return false;
		 }
	 }else{
		generic_id = formObj.item_tech_code.value;
		form_code = "";
		generic_name = formObj.item_tech_desc.value;
		strength_value= "";
		 
	 }

	 if(formulary_code==""){
		   alert(getMessage("PH_FORMULARY_CANT_BE_BLANK","PH"));
		   return false;
	 }
	 if(formulary_desc==""){
		   alert(getMessage("PH_FORMULARY_CANT_BE_BLANK","PH"));
		   return false;
	 }

	var dialogHeight= "35vh" ;
	var dialogWidth	= "83vw" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = "";

	if(called_from!="modify"){
	retVal = await window.showModalDialog("../../ePH/jsp/FormularySearchItemList.jsp?generic_id="+generic_id+"&form_code="+form_code+"&strength_value="+strength_value+"&generic_name="+encodeURIComponent(generic_name,"UTF-8")+"&item_type="+item_type+"&strength_txt="+strength_txt+"&form_name_txt="+encodeURIComponent(form_name_txt,"UTF-8")+"&formulary_desc="+formulary_desc,arguments,features);
	}


	if(retVal!="" && retVal != null && called_from!="modify") {
			var refill_vals	=	retVal.split("~");

			if(refill_vals[0]=='A') {

				parent.FormularyQueryResult.location.href = "../../ePH/jsp/FormularyQueryItemResult.jsp?generic_id="+generic_id+"&generic_name="+generic_name;

			}
	}else if(called_from=="modify"){

				parent.FormularyQueryResult.location.href = "../../ePH/jsp/FormularyQueryItemResult.jsp?called_from="+called_from;
	} 

}

function save(generic_id,generic_name,save_type,formulary_type){


		var formObj		   = document.formulary_item_search_list;
		var bean_id			= "FormularyBillingGroupBean";
		var bean_name       = "ePH.FormularyBillingGroupBean";
		var xmlStr ="<root><SEARCH ";	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
		
		var total_rec = formObj.total_rec.value;
		var generic_name_key = formObj.generic_name_key.value;
		var item_type = formObj.item_type.value;
		var form_code = formObj.form_code.value;
		var exit_flag = false;
		var pref_flag = false;
		for(i=1; i<parseInt(total_rec); i++){
			preference = eval("formObj.preference_item_"+i+".value");
			if(preference!="")
			{
				pref_flag = true;
				break;
			}
		}
		if(pref_flag==false){
			alert(getMessage("PH_FORMULARY_PREFERENCE_CANT_BE_BLANK","PH"));
			return false;
		}
//		var strength_txt = formObj.strength_txt.value;
			for(i=1; i<parseInt(total_rec); i++){
				  preference = eval("formObj.preference_item_"+i+".value");
				  if(exit_flag==true)
					  break;
				  for(j=i+1;j<parseInt(total_rec); j++){
					preference1 = eval("formObj.preference_item_"+j+".value");

					if(preference1!="" && preference!="" && preference1==preference){
						alert(getMessage("PH_FORMULARY_CANT_BE_DUPLICATE","PH"));
						exit_flag = true;
						break;
					}
				  }
				  
			}
			if(exit_flag==true)
				return false;
				
			for(i=1; i<parseInt(total_rec); i++){
				xmlStr+= "item_desc_"+i+"=\"" + eval("formObj.item_desc_"+i+".value") + "\" " ;
				xmlStr+= "form_code_"+i+"=\"" +form_code+ "\" " ;
				xmlStr+= "form_name_"+i+"=\"" + encodeURIComponent(eval("formObj.form_name_"+i+".value"),"UTF-8") + "\" " ;
				xmlStr+= "strength_"+i+"=\"" + eval("formObj.strength_"+i+".value") + "\" " ;
				xmlStr+= "strength_uom_"+i+"=\"" + eval("formObj.strength_uom_"+i+".value") + "\" " ;
				xmlStr+= "strength_txt_"+i+"=\"" + eval("formObj.strength_txt_"+i+".value") + "\" " ;
				xmlStr+= "route_code_"+i+"=\"" + eval("formObj.route_code_"+i+".value") + "\" " ;
				xmlStr+= "route_"+i+"=\"" + eval("formObj.route_"+i+".value") + "\" " ;
				xmlStr+= "item_code_"+i+"=\"" + eval("formObj.item_code_"+i+".value") + "\" " ;
				xmlStr+= "unit_price_"+i+"=\"" + eval("formObj.unit_price_"+i+".value") + "\" " ;
				xmlStr+= "preference_item_"+i+"=\"" + eval("formObj.preference_item_"+i+".value") + "\" " ;
			}

		
		xmlStr+= "generic_id=\"" +generic_id + "\" " ;
		xmlStr+= "generic_name=\"" +generic_name + "\" " ;
		xmlStr+= "generic_name_key=\"" +encodeURIComponent(generic_name_key,"UTF-8")+ "\" " ;
		xmlStr+= "item_type=\"" +item_type+ "\" " ;
		xmlStr+= "form_code=\"" +form_code+ "\" " ;
	//	xmlStr+= "strength_txt=\"" +strength_txt+ "\" " ;
		xmlStr+= "total_rec=\"" +total_rec+ "\" " ;
		xmlStr+="save_type=\"" +save_type+ "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="FormularyValidation.jsp?called_from=saveSelectedItem";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);


}
function closeWindow(save_type,generic_id)
{
window.returnValue = save_type+"~"+generic_id;
window.close();
}
 
function changePreference(obj,row){
	eval("document.getElementById("preference_item_")"+row).value=obj.value;
}

function getClearvalue()
{
	 document.getElementById("formularycode").value="";
	 document.getElementById("formulary_desc").value="";
	 document.getElementById("generic_name").value="";
	 document.getElementById("item_tech_desc").value="";
}

function FormularyCodeCheck(obj){
	if(!CheckChars(obj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}


function billingGroupsearch(objCode,objDesc)
{
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

    
    argumentArray[0] = "SELECT BLNG_GRP_ID CODE, SHORT_DESC description FROM BL_BLNG_GRP WHERE BLNG_GRP_ID LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)";
    
    argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	
	argumentArray[7] = CODE_DESC;
	
	returnedValues = CommonLookup( getLabel("ePH.BillingGroup.label","ph"), argumentArray );

	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}

}

function getFormularyDetails(formulary_code,formulary_desc,formulary_type,enable_status){
	
	  parent.f_query_add_mod.location.href="../../ePH/jsp/FormularySearchQueryFrame.jsp?called_from=modify&formulary_code="+formulary_code+"&formulary_desc="+formulary_desc+"&formulary_type="+formulary_type+"&enable_status="+enable_status;
}

async function getSelectedItemList(generic_name_key,called_from,item_type,formulary_desc){

	var dialogHeight= "35vh" ;
	var dialogWidth	= "83vw" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	
	retVal = await window.showModalDialog("../../ePH/jsp/FormularySearchItemList.jsp?generic_name_key="+encodeURIComponent(generic_name_key,"UTF-8")+"&called_from="+called_from+"&item_type="+item_type+"&formulary_desc="+formulary_desc,arguments,features);
	
	var scrollTop = document.body.scrollTop;  //added for GHL-SCF-1548


	
	if(retVal != null && retVal!="") {

			var refill_vals	= retVal.split("~");

			if(refill_vals[0]!='') {
				parent.FormularyQueryResult.location.href = "../../ePH/jsp/FormularyQueryItemResult.jsp?called_from="+called_from+"&scrollTop="+scrollTop;
			}
	} 
}
async function viewFormularyBlngGrpItemDtls(){

var dialogHeight= "35vh" ;
	var dialogWidth	= "83vw" ;
	var dialogTop = "169" ;
	var center = "1" ;
	//var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = "";
	retVal = await window.showModalDialog("../../ePH/jsp/FormularyItemViewScreen.jsp",arguments,features);
}
function filterFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();

  div = document.getElementById("myDropdown");
  a = div.getElementsByTagName("a");
  for (i = 0; i < a.length; i++) {
    txtValue = a[i].textContent || a[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}
