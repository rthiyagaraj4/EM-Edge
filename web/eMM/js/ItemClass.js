var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function create() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/AddModifyItemClass.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/ItemClassQueryCriteria.jsp?function_id="+ function_id ;
}

function apply() 
{

	var formObj	=	f_query_add_mod.document.formItemClass ;
if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var fields	=	new Array	(	formObj.item_class_code
									,formObj.long_desc
									,formObj.short_desc
								);

	var names	=	new Array	(	"Code"
									,"Long Description"
									,"Short Description"
								);

	
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
	var mode	=	f_query_add_mod.document.formItemClass.mode.value;
	if( mode == MODE_INSERT ) 
	{
		formReset();
	}
	else
		f_query_add_mod.document.location.reload();
}

function formReset () 
{
	if(f_query_add_mod.document.formItemClass!=null)
	{
	f_query_add_mod.document.formItemClass.reset();
	f_query_add_mod.FocusFirstElement();
	}
		
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function Modify(obj)
{
	var code1				=	obj.cells[0].innerText;

	document.location.href	=	"../../eMM/jsp/AddModifyItemClass.jsp?function_id="+parent.function_id+"&mode="+MODE_MODIFY+"&item_class_code="+code1;

}
