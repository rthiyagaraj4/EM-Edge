/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
var isCreate = "N";
var isQuery = "N";
var isApplied = "N";

//var mode = "1";
function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/AntibioticAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	isCreate = "Y";
	isQuery = "N";
}

function query()
{
	f_query_add_mod.location.href='../../eOR/jsp/AntibioticQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
	isQuery = "Y";
	isCreate = "N";
}

function reset()
{
	if(isCreate == "Y")
	{	
		f_query_add_mod.location.href='../../eOR/jsp/AntibioticAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
		message = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		isCreate = "Y";
		isQuery = "N";	
	}
	else
	{
		if(isQuery == "Y")
		{
		if(checkIsValidForReset())
			{
				var wholeString = f_query_add_mod.frmAntibiotic.wholeString.value;
				var wholeStringArray = wholeString.split("$");
				var mode = wholeStringArray[0];
				var antibiotic_code = wholeStringArray[1];
				var long_description = wholeStringArray[2];
				var short_description = wholeStringArray[3];
				var seq_no = wholeStringArray[4];

				f_query_add_mod.location.href = "../../eOR/jsp/AntibioticAddModify.jsp?mode="+mode+"&"+"antibiotic_code="+antibiotic_code+"&"+"long_description="+long_description+"&"+"short_description="+short_description+"&"+"seq_no="+seq_no;
			}
			else
			{
				f_query_add_mod.location.href = "../../eOR/jsp/AntibioticQueryCriteria.jsp?function_id="+function_id;	
			}
		}
	}
}
function deleterecord()
{
}
function apply() 
{
	//alert("inside apply");
	if (! checkIsValidForProceed() )
    {
			message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}	
	//else
	//{
		//if(f_query_add_mod.f_query_add_mod.document.frmAntibiotic)
		//	var frmObj = f_query_add_mod.f_query_add_mod.document.frmAntibiotic;
		//else
			var frmObj = f_query_add_mod.document.frmAntibiotic;
		
		//var mode = f_query_add_mod.document.frmAddModify.mode.value;

		//alert(mode);
		if(frmObj.mode.value == MODE_INSERT)
		{
			var frmObj = f_query_add_mod.document.frmAntibiotic;
			var noOfRecords = frmObj.noOfRecords.value;
			if(eval("frmObj.code"+0).value != '' && eval("frmObj.long_desc"+0).value != '' && eval("frmObj.short_desc"+0).value != '' && eval("frmObj.seq_no"+0).value != '')
			{	
				frmObj.mode.value = "1";
				//mode = frmObj.mode.value;
				eval( formApply( frmObj,OR_CONTROLLER) );
				if( result ) 
				{
					//onSuccess();
					//alert("Before   " + message);
					//message = getMessage(message);
					if(message == "DUPLICATE_CODE_EXISTS)
					{
						message = getMessage(message,"common");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					}
					else
					{
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						f_query_add_mod.location.href='../../eOR/jsp/AntibioticAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
					}
					return true ;
				/*}else
				{
					//alert(message);
					message = getMessage(message);
					//alert(message);
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return false ;	
				}*/
				isCreate = "Y";
				isQuery = "N";	
				}
			}
			else
			{
				message = getMessage("ATLEAST_ONE_RECORD_ENTERED","common");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return;
			}
		}
		else
		{
			//var frmObj = f_query_add_mod.f_query_add_mod.document.frmAntibiotic;
			var	fields = new Array (frmObj.long_desc,frmObj.short_desc,frmObj.seq_no);
			var	names =	new	Array (getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.SequenceNo.label","Common"));	
			if(!f_query_add_mod.checkFieldsofMst(fields,names, messageFrame))
				return ;
			var mode = frmObj.mode.value;
			var antibiotic_code = frmObj.code.value;
			var long_desc = frmObj.long_desc.value;
			var short_desc = frmObj.short_desc.value;
			var seq_no = frmObj.seq_no.value;

			frmObj.mode.value = "2";
			//mode = frmObj.mode.value;
			eval(formApply( frmObj,OR_CONTROLLER) );
			if( result ) 
			{	
				//onSuccess();
				
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				f_query_add_mod.location.href="../../eOR/jsp/AntibioticAddModify.jsp?mode="+mode+"&antibiotic_code="+antibiotic_code+"&long_description="+long_desc+"&short_description="+short_desc+"&seq_no="+seq_no;
				isQuery = "Y";
				isCreate = "N";
				return true ;
			}else
			{
	
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;	
			}
		}
	
	//}
}
function onSuccess()
{
	//if(isCreate == "N" && isQuery == "Y")
	//	f_query_add_mod.location.href="../../eOR/jsp/AntibioticAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+function_id ;
	//else
		f_query_add_mod.location.href="../../eOR/jsp/AntibioticAddModify.jsp?mode="+mode+"&function_id="+function_id ;
	
	isCreate = "Y";
	isQuery = "N";
}
function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	  return true;
	 else
	  return false;
}

function checkIsValidForReset()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("addmodify.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}

function CheckForNumbers(target)
{
	//alert("inside checkfor nu.");
	var frmObj = document.frmAntibiotic;
	if ( trimCheck(target.value) && isNaN(target.value) == false && target.value >0)
	{
		//alert((target.name).length);
		//alert((target.name).charAt((target.name).length-1));
		//var len = (target.name).charAt((target.name).length-1);
		//alert(eval("frmObj.eff_status"+len).value);
		//eval("frmObj.eff_status"+len).focus();
		//message	= "";
		//parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return true;
	}
	else
	{
		if(target.value == "0")
		{
			message = getMessage("SEQ_NO_NOT_ZERO","OR");
			
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			target.value="";
		}
		else
		{
			if(target.value == "")
			{
				message	= "";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return true;
			}
			else
			{
				message	= getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM");
				
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				target.focus();
				target.value="";
			}
		}
	}
}

function checkActive(target)
{
	
	if(target.checked == false)
	{
		target.value = "D";
		target.checked = false;
	}
	else
	{
		target.value = "E";
		target.checked = true;
	}
	
}

function checkForSpecial(target)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  
	if(strCheck.indexOf(key) == -1) 
	{
		message		 = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM");
		
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		target.focus();
		target.value="";
	}	
	else
	{
		message = "";
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
}

function checkIsValidForReset()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("addmodify.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}
