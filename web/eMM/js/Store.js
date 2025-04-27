var function_id = "";
var result		= false;
var flag		= "";
var message		= "";

function create() 
{
	f_query_add_mod.location.href = "../../eMM/jsp/AddModifyStore.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query()
{
	f_query_add_mod.location.href = "../../eMM/jsp/StoreQueryCriteria.jsp?function_id="+function_id;
}


function apply()
{
	var formObj = f_query_add_mod.document.formMasterCode;
if(formObj==undefined){
		messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	  
	if(formObj.external_yn.checked==true)
	{
	  
	
	var fields	=	new Array	(	formObj.store_code
									,formObj.long_desc
									,formObj.short_desc
									 
								);
	var names =		new Array	(	getLabel("Common.StoreCode.label","Common")
									,getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common")
									 
								);
	}
	else
	{
	 
		var fields	=	new Array	(	formObj.store_code
									,formObj.long_desc
									,formObj.short_desc
									,formObj.dept_code
									 
								);
		var names =		new Array	(	getLabel("Common.StoreCode.label","Common")
									,getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common")
									,getLabel("Common.department.label","Common")
									 
								);
		
		f_query_add_mod.document.getElementById("span2").style.visibility="visible";

	}
   
	if (formObj.external_yn.checked==true && formObj.external.value=="Y")
	{	
	 
		fields[3]	=	formObj.cust_code;
		names[3]	=getLabel("Common.Customer.label","Common");
	}
	
	if (formObj.external_yn.checked==true && formObj.dept_code.value!="")
	{
		
		var message_item =getMessage("STORE_EITHER_EXT_DEPT","MM");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
		return;
	}

		var errorPage	= "../../eCommon/jsp/error.jsp" ;	
		var blankObj 	= null ;
		
		blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
		
		if(blankObject==true)
		{
			var responseText=formApply(formObj, MM_CONTROLLER);

			eval(responseText) ;
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
	f_query_add_mod.document.formMasterCode.reset();
	f_query_add_mod.FocusFirstElement();
	}

	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function toUpper(obj) 
{
	obj.value				=	obj.value.toUpperCase();
}


var prev_dept_code="";
function showCheck()
{
	
	var check_ext="";
	if(document.formMasterCode.external_yn.checked==true && document.formMasterCode.external.value=="Y")
	check_ext='Y';
	else
	check_ext='N';

	if ( check_ext=="Y")
		{
		
		document.getElementById("tb1").style.visibility="visible";
		document.getElementById("span1").style.visibility="visible";
		document.getElementById("img1").style.visibility="visible";
		document.getElementById("tb1").options[0].selected=true;
		
		}
	else{
			document.getElementById("tb1").style.visibility="hidden";
			document.getElementById("span1").style.visibility="hidden";
			document.getElementById("img1").style.visibility="hidden";
		}
// added by manish on Saturday, December 27, 2003.
	if (document.formMasterCode.external_yn.checked) {
		document.getElementById("span2").style.visibility="hidden";
		document.formMasterCode.dept_code.disabled=true;
		prev_dept_code=document.formMasterCode.dept_code.value;
		document.formMasterCode.dept_code.value="";
	}
	else{
		document.getElementById("span2").style.visibility="visible";
		document.formMasterCode.dept_code.disabled=false;
		document.formMasterCode.dept_code.value=prev_dept_code;
	}
// ends added by manish
}


function Modify(obj)
{

	var code1				=	obj.cells[0].innerText;

	document.location.href	=	"../../eMM/jsp/AddModifyStore.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&store_code="+code1;//+"&long_desc="+code2+"&short_desc="+code3+"&dept_code="+code4+"&cust_code="+code5+"&store_incharge_name="+code6+"&store_incharge_title="+code7+"&store_location="+code8+"&external_yn="+code9+"&eff_status="+code10;
}

function onloadshowCheck()
{
	
	var check_ext="";
	if(document.formMasterCode.external_yn.checked==true  && document.formMasterCode.external.value=="Y")
	check_ext='Y';
	else
	check_ext='N';

	if ( check_ext=="Y")
		{
		
		document.getElementById("tb1").style.visibility="visible";
		document.getElementById("span1").style.visibility="visible";
		document.getElementById("img1").style.visibility="visible";
		
		
		}
	else{
			document.getElementById("tb1").style.visibility="hidden";
			document.getElementById("span1").style.visibility="hidden";
			document.getElementById("img1").style.visibility="hidden";
		}
}

// Added The Function To Restrict the User To paste Only Prescribed No Of  Characters  
//Added by Rabbani on 30/11/11
function checkMaxLengthPaste(obj,maxlength)
{


                var len; 
                var txt = clipboardData.getData("Text"); 
                txt = obj.value + txt 
                len = parseInt(txt.length); 
                if ( len >  maxlength ) 
                { 
                        event.returnValue=false; 
                        txt = txt.substring(0, maxlength);                
                        obj.value = txt;                           
                        
                } 
          
    
}
