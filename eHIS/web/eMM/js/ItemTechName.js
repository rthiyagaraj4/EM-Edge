function create() 
{
	f_query_add_mod.location.href = "../../eMM/jsp/AddModifyItemTechName.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query()
{
	f_query_add_mod.location.href = "../../eMM/jsp/ItemTechNameQueryCriteria.jsp?function_id="+function_id;
} 
function CheckForSpecChars(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
    if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
    return true ;
   
}

function apply()
{
	var formObj = f_query_add_mod.document.formAddModifyItemTechName;
	if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
		return;
	}

	var fields = new Array(formObj.Item_Tech_Name_code, formObj.Item_Tech_long_desc,formObj.Item_Tech_short_desc);

	var names = new Array(getLabel("eMM.ItemTechCode.label","MM"), getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));

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

function formReset () 
{
	if(f_query_add_mod.document.formAddModifyItemTechName!=null)
	{
		f_query_add_mod.document.formAddModifyItemTechName.reset();
		f_query_add_mod.FocusFirstElement();
	}  
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() 
{
	var mode	=	f_query_add_mod.document.formAddModifyItemTechName.mode.value;
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
	if(f_query_add_mod.document.formAddModifyItemTechName!=null)
	{
		f_query_add_mod.document.formAddModifyItemTechName.reset();
		f_query_add_mod.FocusFirstElement();
	}  
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function Modify(obj)
{	 
	var item_Tech_Code				=	obj.cells[0].innerText;	 
	document.location.href	=	"../../eMM/jsp/AddModifyItemTechName.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&item_Tech_Code="+item_Tech_Code;
}

function checkenabledisable()
{
//alert("enabledisable-"+f_query_add_mod.document.formAddModifyItemTechName.Item_Tech_enabled.value);
	if(document.getElementById('Item_Tech_enabled').checked!=true)
	{
		//alert("checkd");
		alert("Item_Tech_Name_code--"+document.getElementById('Item_Tech_Name_code').value);
	}	
}

/*added for GHL-CRF-0548.1*/
function checkLength(){
	var formObj = document.formAddModifyItemTechName;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.Item_Tech_Remarks, 120)) {
		return false;
	}
	return true;
}