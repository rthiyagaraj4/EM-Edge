var invalidCode = "";
var function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function create() 
{
	f_query_add_mod.location.href	=	"../../ePO/jsp/AddPurchaseUnit.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_add_mod.location.href	=	"../../ePO/jsp/PurchaseUnitQueryCriteria.jsp?function_id="+function_id;
}

function apply()
{
	var arrPKFieldNames     =   new Array();
	arrPKFieldNames[0]      =   "unit_code_";

	var formObj = f_query_add_mod.document.formPurchaseUnit; 
	if(formObj==undefined){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var errorPage	= "../../eCommon/jsp/error.jsp" ;	

	var blankObj 	= null ;
		var formObj = f_query_add_mod.document.formPurchaseUnit ;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var obj=null;
		
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames =	new Array();
		arrFieldName[0] =	"unit_code_";
		arrFieldName[1] =	"long_desc_";
		arrFieldName[2] =	"short_desc_";
		//arrLegends[0]	= getLabel("eST.MasterType.label","ST");
		arrLegends[1]	= getLabel("Common.longdescription.label","Common");
		arrLegends[2]	= getLabel("Common.shortdescription.label","Common");   
		arrPKFieldNames[0] = "unit_code_";
	//	resetDuplicateClass( formObj, arrPKFieldNames);
		if(formObj.mode.value==MODE_INSERT)
		{
			var validateResult = validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
			if(validateResult)
			{
				eval(formApply(formObj,PO_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_value=0&err_num="+ message;
		
				if( result )
				{
					onSuccess();
				}
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

	
		
	else
	{

		var formObj = f_query_add_mod.document.formPurchaseUnit
	if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
		var fields	=	new Array	(formObj.long_desc_0
									,formObj.short_desc_0
								);
	
		var names	=	new Array	(getLabel("Common.longdescription.label","Common")
									,getLabel("Common.shortdescription.label","Common")
								);
		var errorPage	= "../../eCommon/jsp/error.jsp" ;	
		var blankObject 	= null ;
		blankObject  = checkPOFields( fields, names, messageFrame,errorPage) ;

		if(blankObject==true)
		{

			if (formObj.mode.value == MODE_MODIFY)
			{
				eval(formApply(formObj,PO_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				

				if( result )
				{
					onSuccess();
				}
				return;
			}
		}

	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
	if( _invalidCode==null)
		 _invalidCode="";
	invalidCode = _invalidCode;
}


function reset() 
{
	formReset() ;
}

function onSuccess() 
{
	if( f_query_add_mod )
	{
		var mode	=	f_query_add_mod.document.formPurchaseUnit.mode.value;
		if( mode == MODE_INSERT ) 
		{
			formReset();
			
		}
	}
	else 
	{
		f_query_add_mod.document.location.reload();
	}
}

function formReset () 
{
	
	if(!(f_query_add_mod==null))
	{
		f_query_add_mod.location.reload();
		
	}

	if(f_query_add_mod.document.query_form!=null)
	{
		f_query_add_mod.document.query_form.reset();
		f_query_add_mod.FocusFirstElement();
	}
	
	if(f_query_add_mod.document.formPurchaseUnit!=null)
	{
		f_query_add_mod.document.formPurchaseUnit.reset();
		f_query_add_mod.FocusFirstElement();
	}


		
}

function Modify(obj,eff_status)
{
	var code1				=	obj.cells[0].innerText;
	var code2				=	obj.cells[1].innerText;
	var code3				=	obj.cells[2].innerText;
	document.location.href	=	"../../ePO/jsp/ModifyPurchaseUnit.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&unit_code="+code1+"&long_desc="+code2+"&short_desc="+code3+"&eff_status="+eff_status;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
   // var formObj = parent.parent.f_query_add_mod.master_type_detail.document.formMasterType;
    var formObj = parent.f_query_add_mod.document.formPurchaseUnit;
    arrPKFieldNames[0] = "unit_code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}