var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var invalidCode	=	"";

function create() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/MaterialsGroupAdd.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/MaterialsGroupQueryCriteria.jsp?function_id="+function_id ;
}

function deleterecord()
{
	f_query_add_mod.document.formMasterCode.mode.value	=	MODE_DELETE;
	apply();
}

function apply() 
{
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();
	var errorPage = "../../eCommon/jsp/error.jsp";
	arrFieldName[0]			=	"material_group_code";
	arrFieldName[1]			=	"long_desc";
	arrFieldName[2]			=	"short_desc";

	arrLegends[0]			=	getLabel("eMM.MaterialGroupCode.label","MM");
	arrLegends[1]			=	getLabel("eCommon.longdescription.label","Common");
	arrLegends[2]			=	getLabel("eCommon.shortdescription.label","Common");

	arrPKFieldNames[0]		=	"material_group_code";

	var formObj				=	f_query_add_mod.document.formMasterCode ;
	if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	if( formObj.mode.value==MODE_INSERT)
	{	
		resetDuplicateClass( formObj, arrPKFieldNames );

		var	canProceed	=	validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if(canProceed)
		{
			responseText=formApply( f_query_add_mod.document.formMasterCode, MM_CONTROLLER ) ;
			eval( responseText) ;
			messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
			else if(invalidCode!="")
			{
				showDuplicates( formObj, arrPKFieldNames, invalidCode, 0, messageFrame, errorPage );
			}
		}
	}
	else
	{
		applyOnModify(formObj);
	}
}

function applyOnModify(formObj)
{
	var fields	=	new Array	(	formObj.material_group_code
									,formObj.long_desc
									,formObj.short_desc
								);

	var names	=	new Array	(	getLabel("eMM.MaterialGroupCode.label","MM")
									,getLabel("eCommon.longdescription.label","common")
									,getLabel("eCommon.shortdescription.label","common")
								);

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		
		eval( formApply( f_query_add_mod.document.formMasterCode , MM_CONTROLLER ) ) ;
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
		if( result ) 
		{
			onSuccess();
		}
	}
}

function assignResult( _result, _message, _flag, _invalidCode ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
	invalidCode	=	_invalidCode;
}

function reset() 
{
	formReset() ;
}

function onSuccess() 
{
	var mode	=	f_query_add_mod.document.formMasterCode.mode.value;
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
	if(f_query_add_mod.document.formMasterCode!=null)
	{
	f_query_add_mod.location.reload();
	
	}
		
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
	
}

function toUpper(obj) 
{
	obj.value				=	obj.value.toUpperCase();
}

function Modify(obj)
{
	var code1				=	obj.cells[0].innerText;
	
	document.location.href	=	"../../eMM/jsp/MaterialsGroupModify.jsp?function_id="+parent.function_id+"&mode="+MODE_MODIFY+"&material_group_code="+code1;
}
function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();      
	var formObj			=	f_query_add_mod.document.formMasterCode;      
	/**        
	  * specify the primary key columns        
	  */      
	arrPKFieldNames[0]	=	"item_anal_code";      
	
	/**        
	  * if more than one columns exists in         
	  * the primary key, then the next columns         
	  * can be given like this        
	  */      
	//arrPKFieldNames[1]	=	"long_desc";      
	//arrPKFieldNames[2]	=	"short_desc_";      
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
function trimCheck(inString) {
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;
	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}
function makeValidString(txtObj)
{


    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

   if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}
