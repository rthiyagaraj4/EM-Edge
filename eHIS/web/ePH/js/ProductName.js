// Created on 04 August 2009 =====Shyampriya====

var message = "" ;
var result = false ;
var global_product_code = "";

function create()
	{
		f_query_add_mod.location.href	=	"../../ePH/jsp/ProductNameAddModify.jsp?mode="+MODE_INSERT;
	}


function query() 
	{
		f_query_add_mod.location.href	=	"../../ePH/jsp/ProductNameQueryCriteria.jsp?mode="+MODE_MODIFY;
	}

function reset()
	{
		var obj = f_query_add_mod.document.forms[0];
		obj.reset();
	}

function assignResult( _result, _message, _flag )
	{
		result		 = _result ;
		message		 = _message ;
		flag		 = _flag ;
	}

function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) ) //insert mode
				return true;
		else
				return false;
}	

function onSuccess() 
	{ 
		var obj	= f_query_add_mod.document.ProductNameForm;
		var mode = obj.mode.value;
		 if( mode == MODE_INSERT )
			 {
	 			obj.reset();
			 }
		 if(mode == MODE_MODIFY)
			{
				f_query_add_mod.location.href	=	"../../ePH/jsp/ProductNameAddModify.jsp?mode="+MODE_MODIFY+"&product_code="+global_product_code;
			}
	}

  function apply()
	{
		var url = f_query_add_mod.location.href;
		message="";
	
		var error_page					=	"../../eCommon/jsp/MstCodeError.jsp";	
		if (! checkIsValidForProceed()) 
			{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
			} 
 
		 var formObj					= f_query_add_mod.document.ProductNameForm;
		 var product_code			= formObj.product_code.value;
   	     var long_desc					= formObj.long_desc.value;
		 var short_desc				= formObj.short_desc.value;
		 var admixture_type			= formObj.admixture_type.value;
		 var remarks					= formObj.remarks.value;
		 var eff_status					= formObj.eff_status.value;
		 var mode						= formObj.mode.value;
		 	
		if(mode==MODE_INSERT)
		{
				var fields = new Array ( formObj.product_code,formObj.long_desc,formObj.short_desc);	
				 var names= new Array( "Product Name Code","Long Description","Short Description");

				  if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
					{
						eval(formApply( formObj, PH_CONTROLLER )) ;
						
						if( result) {
							               messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
											onSuccess();
										}
						else
									{
											messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
											formObj.product_code.select();
											formObj.product_code.focus();
									}
					}
		}

		else
		{
			 var fields = new Array ( formObj.long_desc,formObj.short_desc);	
			 var names= new Array( "Long Description","Short Description");

				  if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
					{
						global_product_code = formObj.product_code.value;
						eval( formApply(formObj,PH_CONTROLLER ) ) ;
						 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						if( result ) {
										onSuccess();		
										}					
					}
		}

		
 }

function ModifyRow(obj) {
		
	var product_code = obj.cells[0].innerText;
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/ProductNameAddModify.jsp?mode="+MODE_MODIFY+"&product_code="+product_code;
}


function ChkSplChars(obj)
{
	var str=obj.value;
	
	var chk="1234567890_*abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				  alert(getMessage("CANNOT_BE_SPECIAL_CHAR", "Common"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
}

function checkMaxLength(obj)
{
	var val = "";
	val = obj.value;	
	if(obj.value.length > 250) {
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
			msg = msg.replace("#",250);
			alert(msg);
			obj.value = val.substring(0,250);
		
	}
}


function AllowFormat()
	{
	   var key = window.event.keyCode;
		if(key == 34 ) //do not allow double quotes
			{  
				return false;
			}
	}
