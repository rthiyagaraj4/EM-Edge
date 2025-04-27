var function_id = "";
var result		= false;
var flag		= "";
var message		= "";

function create() 
{
	f_query_add_mod.location.href = "../../eMM/jsp/AddModifyStoreGroup.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query()
{
	f_query_add_mod.location.href = "../../eMM/jsp/StoreGroupQueryCriteria.jsp?function_id="+function_id;
}  

function apply()
{
	var formObj = f_query_add_mod.document.formAddModifyStoreGroup;
	if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
		return;
	}

	var fields = new Array(formObj.store_group_code, formObj.store_group_long_desc,formObj.store_group_short_desc);

	var names = new Array(getLabel("eMM.StoreGroupCode.label","MM"), getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));

	var errorPage	= "../../eCommon/jsp/error.jsp" ;	
	var blankObject 	= null ;
	blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
	if(blankObject==true)
	{
		var responseText=formApply(formObj, MM_CONTROLLER);	
		eval(responseText) ;
		messageFrame.location.href = errorPage+"?err_num="+ message ;
			if( result ) 
				onSuccess() ;
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
	formReset() ;
}

function onSuccess() 
{
	var mode	=	f_query_add_mod.document.formAddModifyStoreGroup.mode.value;
	if( mode == MODE_INSERT ) 
	{
		formReset();
	}
	else 
	{
		f_query_add_mod.document.location.reload();
	}
}
function formReset () 
{
	if(f_query_add_mod.document.formAddModifyStoreGroup!=null)
	{
		f_query_add_mod.document.formAddModifyStoreGroup.reset();
		f_query_add_mod.FocusFirstElement();
	}  
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function Modify(obj)
{	 
	var store_group_code				=	obj.cells[0].innerText;	 
	document.location.href	=	"../../eMM/jsp/AddModifyStoreGroup.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&store_group_code="+store_group_code;
}

function LTrim(obj) {
	var str =  obj.value;
 for (var i=0; ((str.charAt(i)<=" ")&&(str.charAt(i)!="")); i++);
 obj.value = str.substring(i,str.length);
}
function RTrim(obj) {
	var str =  obj.value;
 for (var i=str.length-1; ((str.charAt(i)<=" ")&&(str.charAt(i)!="")); i--);
 obj.value =  str.substring(0,i+1);
}

