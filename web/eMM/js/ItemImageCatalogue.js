var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

async function deleterecord() {
	if( f_query_add_mod.document.formItemImageCatalogue==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num="; 
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.document.formItemImageCatalogue;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	var result = await confirmDelete();
	if (result == "Yes") {
		f_query_add_mod.document.formItemImageCatalogue.mode.value = MODE_DELETE;
		apply();
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("OPER_CANCELLED", "ST");
	}
}

function create() 
	{
		f_query_add_mod.location.href	=	"../../eMM/jsp/AddModifyItemImageCatalogue.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
	}
function query() 
	{
		f_query_add_mod.location.href	=	"../../eMM/jsp/ItemImageCatalogueQueryCriteria.jsp?function_id="+ function_id ;
	}
function apply() 
	{
		var formObj	=	f_query_add_mod.document.formItemImageCatalogue ;
		if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
		var fields	=	new Array	(formObj.item_code,formObj.file_name);
		var names	=	new Array	("Item","Image/Catalogue File Name");
	
		var errorPage	= "../../eCommon/jsp/error.jsp" ;	
		var blankObject 	= null ;
	
		blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
		if(blankObject==true)
		{
			responseText=formApply(formObj, MM_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage+"?err_num="+ message ;
				if( result ) 
					onSuccess() ;
		}
		else
		{
			return;
		}

}

function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}

function reset() 
{
	if(f_query_add_mod.document.formItemImageCatalogue!=null)
	{
	var mode	=	f_query_add_mod.document.formItemImageCatalogue.mode.value;

	if( mode == MODE_INSERT ) {
	create();
	}else{
		f_query_add_mod.document.formItemImageCatalogue.reset();
		}
	}
	//Added by Sakti Sankar for reset of Query Criteria page
	if(f_query_add_mod.document.query_form != null){
		f_query_add_mod.document.query_form.reset();
	}
}

function onSuccess() 
{
	var mode	=	f_query_add_mod.document.formItemImageCatalogue.mode.value;
	if( mode == MODE_INSERT ) 
	{
		f_query_add_mod.document.formItemImageCatalogue.item_desc.disabled=false; 
	f_query_add_mod.document.formItemImageCatalogue.item_search.disabled=false;
		formReset();
	}
	else {
		create();
			
	}
}

function formReset () 
{
	if(f_query_add_mod.document.formItemImageCatalogue!=null)
	{
	f_query_add_mod.document.formItemImageCatalogue.reset();
	f_query_add_mod.FocusFirstElement();
	}
		
	if(f_query_add_mod.document.formItemImageCatalogue!=null)
		f_query_add_mod.document.formItemImageCatalogue.reset();
}

function Modify(obj)
{
	var code1				=	obj.cells[0].innerText; //item_code
	var code2				=	obj.cells[1].innerText; //short_desc
	var code3				=	obj.cells[2].innerText; //serial_no
	var code4				=	obj.cells[3].innerText; //image_file_name

	document.location.href	=	"../../eMM/jsp/AddModifyItemImageCatalogue.jsp?function_id="+parent.function_id+"&mode="+MODE_MODIFY+"&item_code="+code1+"&srl_no="+code3+"&file_name="+code4+"&short_desc="+code2;

}

async function searchItem(objCode,objDesc) 
{
	//alert("2");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.formItemImageCatalogue.SQL_MM_ITEM_LOOKUP_FOR_ITEM_IMAGE.value+"'"+document.forms[0].p_language_id.value+"'";
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
	
	//retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if((returnedValues != null) && (returnedValues != ""  ) ) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readonly=true;		
		document.formItemImageCatalogue.item_code.disabled=true; //Item Desc text box has to be disabled once we had selected the item
		document.formItemImageCatalogue.item_search.disabled=true;

	} 
}

async function confirmDelete() {
	
	var TitleLabel = "Confirm Delete";
	var TransactionLabel = "Delete Item?";
	var retVal = "";
	var dialogHeight = "30vh";
	var dialogWidth = "30vw";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/ConfirmTransactionDynamicForm.jsp?TransactionLabel="+TransactionLabel+"&TitleLabel="+TitleLabel;
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
