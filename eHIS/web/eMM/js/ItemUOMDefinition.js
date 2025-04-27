/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/ 
var	function_id	=	"" ;
var result=false;

function create()
 {

	f_query_add_mod.location.href = "../../eMM/jsp/AddModifyItemUOMDefinition.jsp?&mode="+MODE_INSERT; 
 }

function query(){
   f_query_add_mod.location.href ="../../eMM/jsp/ItemUOMDefinitionQueryCriteria.jsp?&mode="+MODE_MODIFY ;
 }

function apply(){
	var error_page = "../../eCommon/jsp/error.jsp";	
	var formObj = f_query_add_mod.document.ItemUOM_form;
	if(formObj==undefined){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var mode	=	f_query_add_mod.document.ItemUOM_form.mode.value;
	
	var fields	=	new Array	(formObj.item_code,formObj.conversion,formObj.uom_code,formObj.equom_qty,formObj.equom_code);
	var names =		new Array	(getLabel("Common.item.label","Common"),getLabel("eST.BaseUOMQuantity.label","ST"),getLabel("eST.BaseUOMCode.label","ST"),getLabel("eST.EquivalentUOMQuantity.label","ST"),getLabel("eST.EquivalentUOMCode.label","ST"));	
	
	var	canProceed	=f_query_add_mod.checkFields(fields,names,messageFrame);
	if(canProceed){
		var uomselect	= f_query_add_mod.document.ItemUOM_form.uom_code.value;
		var equomselect = f_query_add_mod.document.ItemUOM_form.equom_code.value;
		var conversion = f_query_add_mod.document.ItemUOM_form.conversion.value;

		if(uomselect == equomselect && eval(conversion) > 1){
			f_query_add_mod.document.ItemUOM_form.conversion.select();
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= "+getMessage("CONV_FACTOR_NOT_GREATER_THAN_ONE","MM");
			return;
		}
	
		var responseText=formApply( f_query_add_mod.document.ItemUOM_form, MM_CONTROLLER ) ;
		eval(responseText);
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
		
		if( result ){
			onSuccess();
		}

	
	}
 }
  
function onSuccess(){


	var mode	=	f_query_add_mod.document.ItemUOM_form.mode.value;
	if( mode == MODE_INSERT ) 
	{
	f_query_add_mod.location.href = "../../eMM/jsp/AddModifyItemUOMDefinition.jsp?&mode="+MODE_INSERT;
	}
	
	}

function assignResult( _result, _message, _flag ){
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}

function reset(){
	if(f_query_add_mod.document.ItemUOM_form!=null){
		if(f_query_add_mod.document.ItemUOM_form.mode.value==1){
			f_query_add_mod.document.ItemUOM_form.reset();
			f_query_add_mod.document.ItemUOM_form.item_search.disabled = false;
			f_query_add_mod.document.ItemUOM_form.conversion.readOnly = false;
			f_query_add_mod.document.ItemUOM_form.item_desc.disabled = false;
			//f_query_add_mod.document.ItemUOM_form.uom_desc.disabled = false;
			f_query_add_mod.document.ItemUOM_form.item_desc.focus();
		}else{
		
		var obj=f_query_add_mod.document.ItemUOM_form;
		f_query_add_mod.document.location.href	=	"../../eMM/jsp/AddModifyItemUOMDefinition.jsp?mode="+obj.mode.value+"&item_code="+obj.item_code.value+"&item_desc="+obj.item_desc.value+"&uom_desc="+obj.uom_desc.value+"&equom_code="+obj.equom_code.value+"&conversion="+obj.conversion.value+"&uom_code="+obj.uom_code.value;
			//f_query_add_mod.document.ItemUOM_form.reset();
		
		}
	}
}

async function searchItem(objCode,objDesc) 
{
	//alert("3");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql_mm_item_uom_lookup = "SELECT b.item_code code,long_desc description FROM mm_item_lang_vw mm_item , st_item b WHERE eff_status = 'E'   /*AND sole_source_yn = 'N' */ AND mm_item.item_code = b.item_code AND b.item_code LIKE UPPER(?)  AND  UPPER(long_desc) LIKE UPPER(?)  AND language_id = '"+document.forms[0].p_language_id.value+"' ";//15977 start 
	//argumentArray[0] = document.ItemUOM_form.SQL_MM_ITEM_UOM_LOOKUP.value+"'"+document.forms[0].p_language_id.value+"'";
	argumentArray[0] = sql_mm_item_uom_lookup; //15977 end  
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";

	if(objDesc.readOnly){
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objDesc.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
	
//	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if((returnedValues != null) && (returnedValues != ""  ) ) {
		//alert("returnedValues");
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readonly=true;		
		document.ItemUOM_form.item_desc.disabled=true; //Item Desc text box has to be disabled once we had selected the item
		document.ItemUOM_form.item_search.disabled=true;
	var xmlStr ="<root><SEARCH /></root>";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../eMM/jsp/ItemUOMValidate.jsp?item_code="+arr[0], false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	responseText = trimString(responseText)
	//alert(responseText);
	eval(responseText);
	//alert(eval(responseText));
	} 
}

function check_eff_status(obj){
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
}

function Modify(obj){
	var item_code				=	obj.cells[0].innerText;
	var item_desc				=	obj.cells[1].innerText;
	var uom_code				=	obj.cells[2].innerText;
	var uom_desc				=	obj.cells[3].innerText;
	var equom_code				=	obj.cells[4].innerText;
	var equom_desc				=	obj.cells[5].innerText;
	var conversion				=	obj.cells[6].innerText;
	var eff_status				=	obj.cells[7].innerText;
			/**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(item_desc,"UTF-8")' in the next line code
			*/
	document.location.href	=	"../../eMM/jsp/AddModifyItemUOMDefinition.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&item_code="+item_code+"&item_desc="+encodeURIComponent(item_desc,"UTF-8")+"&uom_code="+uom_code+"&uom_desc="+uom_desc+"&equom_code="+equom_code+"&equom_desc="+equom_desc+"&conversion="+conversion+"&eff_status="+eff_status;
	
}
function assignValue(obj){
	if(obj.checked==true)
		obj.value="E";
	else
		obj.value="D";
}

			/** @Name - Priya
			* @Date - 05/04/2010
			* @Inc# - 20495
			* @Desc - Modified the function as the Equivalent quantity field is getting enabled in the query mode even if the uoms are different
			*/
function defaultOne(val){
	
	var formObj = document.ItemUOM_form;
	var mode	=	formObj.mode.value;
	if(mode == MODE_MODIFY  || val == 'Y'){
		if(formObj.uom_code.value!=""){
		if(formObj.equom_code.value==formObj.uom_code.value){
			formObj.conversion.value = 1;
			formObj.conversion.readOnly = true;
			formObj.equom_qty.value = 1;
			formObj.equom_qty.readOnly = true;
		}else{
			formObj.conversion.readOnly = false;
			formObj.equom_qty.readOnly = false;
		}
		}
	}
}
