var invalidCode = "";
var function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function create() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/BinLocationFrameset.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_add_mod.location.href	=	"../../eMM/jsp/BinLocationQueryCriteria.jsp?function_id="+function_id;
}

function apply()
{

	var arrPKFieldNames     =   new Array();
	arrPKFieldNames[0]      =   "code_";

	if( f_query_add_mod.bin_location_detail )
	{
//added by manish on Wednesday, October 22, 2003
	var errorPage	= "../../eCommon/jsp/error.jsp" ;	

	var blankObj 	= null ;
	var formObjStore = f_query_add_mod.bin_location_store.document.formBinLocation_store;
	var fields = new Array ( formObjStore.store_code);
	var names = new Array (getLabel("Common.Store.label","Common"));

	var blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;

	if(blankObject!=true){
		return;
	}
		f_query_add_mod.bin_location_detail.document.formBinLocation.store_code.value=f_query_add_mod.bin_location_store.document.formBinLocation_store.store_code.value

		var formObj = f_query_add_mod.bin_location_detail.document.formBinLocation ;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var obj=null;
		
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames =	new Array();
		arrFieldName[0] =	"code_";
		arrFieldName[1] =	"long_desc_";
		arrFieldName[2] =	"short_desc_";
		arrLegends[0]	= getLabel("eMM.BinLocationCode.label","MM");
		arrLegends[1]	= getLabel("Common.longdescription.label","Common");
		arrLegends[2]	= getLabel("Common.shortdescription.label","Common");   
		arrPKFieldNames[0] = "code_";

		resetDuplicateClass( formObj, arrPKFieldNames);

		if(formObj.mode.value==MODE_INSERT)
		{
			var validateResult = validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
			if(validateResult)
			{
				eval(formApply(formObj,MM_CONTROLLER));
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

	}
		
	else
	{
		
		var formObj = f_query_add_mod.document.formBinLocation
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
		blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;

		if(blankObject==true)
		{

			if (formObj.mode.value == MODE_MODIFY)
			{
			
				eval(formApply(formObj,MM_CONTROLLER));
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
	if( f_query_add_mod.bin_location_detail )
	{
		var mode	=	f_query_add_mod.bin_location_detail.document.formBinLocation.mode.value;
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
	
	if(!(f_query_add_mod.bin_location_detail==null))
	{
		f_query_add_mod.location.reload();
		
	}

	if(f_query_add_mod.document.query_form!=null)
	{
		f_query_add_mod.document.query_form.reset();
		f_query_add_mod.FocusFirstElement();
	}
	
	if(f_query_add_mod.document.formBinLocation!=null)
	{
		f_query_add_mod.document.formBinLocation.reset();
		f_query_add_mod.FocusFirstElement();
	}


		
}

function Modify(obj,eff_status,store_code)
{
	
	var code1				=	obj.cells[0].innerText;
	var code2				=	obj.cells[1].innerText;
	var code3				=	obj.cells[2].innerText;
	
	
	document.location.href	=	"../../eMM/jsp/ModifyBinLocation.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&binlocation_code="+code1+"&long_desc="+code2+"&short_desc="+code3+"&store_code="+store_code+"&eff_status="+eff_status;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.parent.f_query_add_mod.bin_location_detail.document.formBinLocation;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}