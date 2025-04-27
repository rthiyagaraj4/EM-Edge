

var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function create() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/AddModifyParameter.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function apply() 
{
	//Default Batch ID for Non Expiry Items
	var formObj	=	f_query_add_mod.document.formParameter ;
	var fields	=	new Array	(formObj.dflt_batch_id, formObj.dflt_trade_id);
	var names	=	new Array	(getLabel("eMM.DefaultTradeIDifTradeIDisNotApplicable.label","MM"), getLabel("eMM.DefaultTradeIDifTradeIDisNotApplicable.label","MM"));
	//if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	//{
		//alert ( formApply( f_query_add_mod.document.formMasterCode ) ) ; 
		/*eval( formApply( f_query_add_mod.document.formMasterCode, MM_CONTROLLER ) ) ;
		messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) 
		{
			onSuccess();
		}*/
	var errorPage	= "../../eCommon/jsp/error.jsp" ;	
	var blankObj 	= null ;
	blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
		
	if(blankObject==true) {
			eval(formApply(formObj, MM_CONTROLLER)) ;
			//alert("after"+message);
			messageFrame.location.href = errorPage+"?err_num="+ message ;
			if( result ) {
					onSuccess() ;
				}
		}
		else
		{
				//blankObject.focus() ;
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
	var mode	=	f_query_add_mod.document.formParameter.mode.value;
	if( mode == MODE_INSERT ) 
	{
		formReset();
	}
	else
		f_query_add_mod.document.location.reload();
}

function formReset () 
{
	f_query_add_mod.location.reload();
//	f_query_add_mod.document.formParameter.reset();
//	f_query_add_mod.FocusFirstElement();
}

async function auditTrailLogs(){
	await window.showModalDialog("../../eMM/jsp/ParameterAuditLogFrame.jsp?", "", "dialogHeight:900vh; dialogWidth:800vw; center:0; status: no; dialogLeft :100; dialogTop :150; scroll: yes");
}