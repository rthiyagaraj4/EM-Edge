var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var invalidCode	=	"";

function create() 
{
	f_query_criteria.location.href	=	"../../eMM/jsp/TrnRemarksCriteria.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
	f_query_add_mod.location.href	=	"../../eMM/jsp/AddTrnRemarks.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_criteria.location.href	=	"../../eCommon/html/blank.html"; 
	f_query_add_mod.location.href	=	"../../eMM/jsp/TrnRemarksQueryCriteria.jsp?function_id="+function_id ;
}

function deleterecord()
{
	f_query_add_mod.document.FormAddTrnRemarks.mode.value	=	MODE_DELETE;
	apply();
}

function apply() 
{
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();
	var errorPage = "../../eCommon/jsp/error.jsp";
	arrFieldName[0]			=	"trn_remarks_code";
	arrFieldName[1]			=	"remarks_desc";

	arrLegends[0]			=	getLabel("Common.code.label","Common");
	arrLegends[1]			=	getLabel("Common.remarks.label","Common");    

	arrPKFieldNames[0]		=	"trn_remarks_code";

	var formObj				=	f_query_add_mod.document.FormAddTrnRemarks ;
	if(formObj==undefined){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	if(formObj.mode.value==MODE_INSERT)
	{	
		resetDuplicateClass( formObj, arrPKFieldNames );
	
		var	canProceed	=	validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if(canProceed)
		{
			responseText=formApply( f_query_add_mod.document.FormAddTrnRemarks, MM_CONTROLLER ) ;
			eval( responseText) ;
			messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
			else
			{
			if( invalidCode != "null" && invalidCode != "" ){
				var newInvalidCode		=	"";
				var arrInvalidCodes	=	new Array();
				arrInvalidCodes	=	invalidCode.split(";");
				for(i=0; i<arrInvalidCodes.length; i++)
				{
					var arrInvalidCode	=	new Array();
					var strInvalidCode	=	arrInvalidCodes[i];
					arrInvalidCode		=	strInvalidCode.split(":");
					newInvalidCode		=	arrInvalidCode[0]+";";
				}
				invalidCode		=	newInvalidCode.substring(0, newInvalidCode.length-1);
				showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame, errorPage);
				}
				else {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				}
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
	var fields	=	new Array	(	formObj.trn_remarks_code
									,formObj.remarks_desc
									,formObj.module_id
									,formObj.trn_type
									
								);

	var names	=	new Array	(	getLabel("eMM.TransactionRemarksCode.label","MM")
									,getLabel("eMM.TRNRemarksDescription.label","MM")
									,getLabel("Common.ModuleId.label","Common")
									,getLabel("Common.transactiontype.label","Common")
								);
	if(f_query_add_mod.checkMMSTFields( fields, names, messageFrame)) 
	{
		
		eval( formApply( f_query_add_mod.document.FormAddTrnRemarks , MM_CONTROLLER ) ) ;
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
	var mode	=	f_query_add_mod.document.FormAddTrnRemarks.mode.value;
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
	if(f_query_add_mod.document.FormAddTrnRemarks!=null)
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
	document.location.href	=	"../../eMM/jsp/ModifyTrnRemarks.jsp?function_id="+parent.function_id+"&mode="+MODE_MODIFY+"&trn_remarks_code="+code1;//+"&long_desc="+code2+"&short_desc="+code3+"&eff_status="+eff_status;
} 
function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();      
	var formObj			=	f_query_add_mod.document.FormAddTrnRemarks;      
	/**        
	  * specify the primary key columns        
	  */      
	arrPKFieldNames[0]		=	"trn_remarks_code"

	/**        
	  * if more than one columns exists in         
	  * the primary key, then the next columns         
	  * can be given like this        
	  */      
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

function setmoduleid(formObj)
{
	parent.f_query_add_mod.location.href	=	"../../eMM/jsp/AddTrnRemarks.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&mod_id="+formObj.value; 
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}


function putval(fieldname,i,fieldvalue){
	eval("document.FormAddTrnRemarks."+fieldname+i).value = fieldvalue;
}


