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

function create(){
		
		f_query_add_mod.location.href='../../eOR/jsp/OrderTypeAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

function query()
{
		f_query_add_mod.location.href='../../eOR/jsp/OrderTypeQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

function reset()
{
	if(f_query_add_mod.document.order_type_form) {
		f_query_add_mod.document.order_type_form.reset();
	}
	else if(f_query_add_mod.document.forms[0]!=null)
		f_query_add_mod.document.forms[0].reset();
	else{
				frames[0].location.reload();
				return false;
		}
	
}
  
function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var	formObj	= f_query_add_mod.document.order_type_form ;
    var	fields = new Array ( formObj.order_type_code
						,formObj.long_desc
						,formObj.short_desc
						,formObj.order_category_code
						);
		
	  var	names =	new	Array (getLabel("Common.code.label","Common")
				,getLabel("Common.longdescription.label","Common")
				,getLabel("Common.shortdescription.label","Common")
				,getLabel("Common.OrderCategory.label","Common")
				);

	  if(f_query_add_mod.checkFieldsofMst(	fields,	names, messageFrame)) {
		
		  var flds=new Array(formObj.order_type_code);
		  var name=new Array(getLabel("Common.code.label","Common"));
	  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		 // Set the value to the hidden fields
	 	 f_query_add_mod.document.order_type_form.frequency.value	= f_query_add_mod.document.order_type_form.freq_applicable_yn.value;
		 f_query_add_mod.document.order_type_form.softStop.value	= f_query_add_mod.document.order_type_form.soft_stop_yn.value;
		 f_query_add_mod.document.order_type_form.contOrder.value	= f_query_add_mod.document.order_type_form.cont_order_yn.value;
		 if(formObj.eff_status_yn.checked==true)
		 	 formObj.eff_status_yn.value	= "E";
		 else
			 formObj.eff_status_yn.value	= "D";
		
		 eval(formApply(f_query_add_mod.document.order_type_form,OR_CONTROLLER)) ;
		 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		 //console.log("apply success message"+message);
		 if(result) {
		 	 onSuccess();
			 
 		 }
	 }
}
}
function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function onSuccess() {
	var mode = f_query_add_mod.document.order_type_form.mode.value;
	formReload();

}

function formReload() {
	f_query_add_mod.location.reload();
}

function change(obj)
{
   if(obj.checked==true)
   {
	   if(obj.name=="eff_status_yn")
         obj.value = "E";
       else
		 obj.value = "Y";
   }
   else
   {
	   if(obj.name=="eff_status_yn")
		 obj.value = "D";
       else
		 obj.value = "N";
   }
}


function getInstallValue(obj)
{
	var val =	obj.value.split("::");

	if(val[0]=="LB" || val[0]=="RD" || val[0]=="OT")
	{
    var bean_id		= document.order_type_form.bean_id.value;
	var bean_name	= document.order_type_form.bean_name.value;
	var order_type_code	= document.order_type_form.order_type_code.value;

	var order_category = val[0];
		var xmlStr ="<root><SEARCH ";
		xmlStr += " ORDER_CATEGORY=\""+ order_category + "\" ";		
		xmlStr += " order_type_code=\""+ order_type_code + "\" ";		
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " CLASS_NAME=\"OrderType\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderTypeAddModifyFetchInstall.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
	}

}

function chkInstl(val)
{
	if(val=="Y")
	{
		    document.order_type_form.regn_reqd_yn.checked	= false;
			document.order_type_form.regn_reqd_yn.disabled	= true;
	}
}


function getOrderCategory(obj)
{

 if(obj.value!=null && obj.value!='')
	{
		  var val =	obj.value.split("::");

	//	  alert("@@@Ord_cat : "+val[0]);
		 // For Registration check
			
		 if(val[0]=="PH" || val[0]=="MR" || val[0]=="CS")
		 {
 	   		if(document.order_type_form.regn_reqd_yn)
			 {
				document.order_type_form.regn_reqd_yn.value		= "N";
				document.order_type_form.regn_reqd_yn.checked	= false;
				document.order_type_form.regn_reqd_yn.disabled	= true;
			 }
			 document.getElementById("default_auto").style.display	= 'none';
			 document.getElementById("auto_report").style.display	= 'none';
		 }else if(val[0]=="RD" || val[0]=="PC" || val[0] == "RX" || val[0] == "DS")
		 {
			//document.getElementById("default_auto").style.visibility	= 'visible';
			//document.getElementById("auto_report").style.visibility	= 'visible';
			document.order_type_form.regn_reqd_yn.value		= "Y";
			document.order_type_form.regn_reqd_yn.checked	= false;
			document.order_type_form.regn_reqd_yn.disabled	= false;
			document.getElementById("default_auto").style.display	= 'inline';
			document.getElementById("auto_report").style.display	= 'inline';
			
		
		 }
		else
		{
			 if(document.order_type_form.regn_reqd_yn)
			 {
				document.order_type_form.regn_reqd_yn.value		= "Y";
				document.order_type_form.regn_reqd_yn.checked	= true;
				document.order_type_form.regn_reqd_yn.disabled	= false;
			 }
			// document.getElementById("default_auto").style.visibility	= 'hidden';
			 //document.getElementById("auto_report").style.visibility	= 'hidden';
			 document.getElementById("default_auto").style.display	= 'none';
			 document.getElementById("auto_report").style.display	= 'none';
		}

		// Till here for Registration
		  document.order_type_form.order_category.value				= val[0];
		  document.order_type_form.soft_stop_applicable_yn.value	= val[3];
		  document.order_type_form.soft_stop_update_yn.value		= val[4];
		  document.order_type_form.cont_order_applicable_yn.value	= val[5];
		  document.order_type_form.cont_order_update_yn.value		= val[6];
		  // stored it in the hidden fields , used when changed the freq
		  if(val[1]	=="Y" || val[2]	== "Y")	// freq_applicable_yn || freq_update_allow_yn
		  {
			 document.getElementById("timing_order").style.visibility	= 'visible';
			 // For Frequency Checks

			  if(document.order_type_form.freq_applicable_yn)
				{
				   if(val[1] == "Y" && val[2] == "Y")
					{
						document.order_type_form.freq_applicable_yn.value		=	"Y";
						document.order_type_form.freq_applicable_yn.checked		= true;
						document.order_type_form.freq_applicable_yn.disabled	= false;
					}
					else
					{
						if( val[2] == "Y")
						{
							if(val[1] == "Y")
							{
								document.order_type_form.freq_applicable_yn.checked	= true;
							}
							else
							{
								document.order_type_form.freq_applicable_yn.checked	= false;
							}
							document.order_type_form.freq_applicable_yn.value	 =	val[1]; // freq_applicable_yn
							document.order_type_form.freq_applicable_yn.disabled = false;
						}
						else
						{
							if(val[1] == "Y")
							{
								document.order_type_form.freq_applicable_yn.checked	= true;
							}
							else
							{
								document.order_type_form.freq_applicable_yn.checked	= false;
							}
								document.order_type_form.freq_applicable_yn.value	=	val[1]; // freq_applicable_yn
								document.order_type_form.freq_applicable_yn.disabled= true;
						}
					}
				}
				// till here frequency
			if(val[1] == "Y")
			  {
				  if(document.order_type_form.soft_stop_applicable_yn.value == "Y" ||	document.order_type_form.soft_stop_update_yn.value == "Y") // soft_stop_applicable_yn || soft_stop_update_allow_yn
				  {
				 	 displaySoftAndContinous();
					 softAndContinous();
				  }
			      else
			      {
				    	hideSoftAndContinous();
			      }
  			      // For continous order
			      if(val[5] == "Y" ||	val[6] == "Y")
			 	 {
			 	  	  displayDefaultContinous();
			 		  defaultContinous();
 			 	 }
			     else
			     {
			 	 	  hideDefaultContinous();
			     }
              }
			  else
			  {
				  	hideSoftAndContinous();
					hideDefaultContinous();
			  }

			}
			else if(val[3] == "N" && val[5]	== "N")
			{
					hideSoftAndContinous();
					hideDefaultContinous();
					document.getElementById("timing_order").style.visibility	= 'hidden';
					document.order_type_form.freq_applicable_yn.value =	"N";
			}
		 }
		 else
		 {
			 document.getElementById("timing_order").style.visibility	= 'hidden';
			 document.order_type_form.freq_applicable_yn.value =	'N';
			 hideSoftAndContinous();
			 hideDefaultContinous();
		 }
}


function hideSoftStop(obj)
{
	if(obj.checked)
	{
	   if(document.order_type_form.soft_stop_applicable_yn.value == "Y" ||	document.order_type_form.soft_stop_update_yn.value == "Y") // soft_stop_applicable_yn || soft_stop_update_allow_yn
		{
		   displaySoftAndContinous();
		   softAndContinous();
        }

		if(document.order_type_form.cont_order_applicable_yn.value == "Y" ||	document.order_type_form.cont_order_update_yn.value == "Y") // cont_applicable_yn || cont_stop_update_allow_yn
		{
		   displayDefaultContinous();
		   defaultContinous();
		}

	}
	else
	{
		 hideSoftAndContinous();
		 hideDefaultContinous();
	}
}

function hideSoftAndContinous()
{
	if(document.getElementById("soft_stop_yn"))
		{
			document.getElementById("soft_stop").style.visibility			= 'hidden'
			document.order_type_form.soft_stop_yn.value		= "N";
			document.order_type_form.soft_stop_yn.checked	= false;
			document.order_type_form.soft_stop_yn.disabled	= true;
		}
}

function displayDefaultContinous()
{
		if(document.getElementById("default_order"))
			document.getElementById("default_order").style.visibility		= 'visible'

		if(document.getElementById("cont_order_yn"))
		{
			document.getElementById("continous_order").style.visibility	= 'visible'
		}
}

function displaySoftAndContinous()
{
	if(document.getElementById("soft_stop_yn"))
	{
			document.getElementById("soft_stop").style.visibility		= 'visible'
	}
}

function hideDefaultContinous()
{
	if(document.getElementById("default_order"))
			document.getElementById("default_order").style.visibility = 'hidden'

	if(document.getElementById("continous_order"))
	{
			document.getElementById("continous_order").style.visibility	= 'hidden'
			document.order_type_form.cont_order_yn.value	= "N";
			document.order_type_form.cont_order_yn.checked	= false;
			document.order_type_form.cont_order_yn.disabled	= true;
	}
}



function softAndContinous()
{
	if(document.order_type_form.freq_applicable_yn.value=="Y" &&  document.order_type_form.soft_stop_update_yn.value=="Y")
	{
		if(document.order_type_form.soft_stop_yn)
		{
			if(document.order_type_form.soft_stop_update_yn.value=="Y")  // val[4]
			{
				if(document.order_type_form.soft_stop_applicable_yn.value=="Y")
				{
					document.order_type_form.soft_stop_yn.checked	= true;
				}
				else
				{
					document.order_type_form.soft_stop_yn.checked	= false;
				}
				document.order_type_form.soft_stop_yn.disabled	= false;
			}
			else
			{
				if(document.order_type_form.soft_stop_applicable_yn.value=="Y")
				{
					document.order_type_form.soft_stop_yn.checked	= true;
				}
				else
				{
					document.order_type_form.soft_stop_yn.checked	= false;
				}

				document.order_type_form.soft_stop_yn.disabled	= true;
			}

			document.order_type_form.soft_stop_yn.value	= document.order_type_form.soft_stop_applicable_yn.value;
		}
	}
	else
	{
		if(document.order_type_form.soft_stop_yn)
		{
			if(document.order_type_form.soft_stop_update_yn.value=="Y")  // val[4]
			{
				if(document.order_type_form.soft_stop_applicable_yn.value=="Y")
				{
					document.order_type_form.soft_stop_yn.checked	= true;
				}
				else
				{
					document.order_type_form.soft_stop_yn.checked	= false;
				}
				document.order_type_form.soft_stop_yn.value		= document.order_type_form.soft_stop_applicable_yn.value;
				document.order_type_form.soft_stop_yn.disabled	= false;
			}
			else
			{
				if(document.order_type_form.soft_stop_applicable_yn.value=="Y")
				{
					document.order_type_form.soft_stop_yn.checked	= true;
				}
				else
				{
					document.order_type_form.soft_stop_yn.checked	= false;
				}
				document.order_type_form.soft_stop_yn.value	= document.order_type_form.soft_stop_applicable_yn.value;
				document.order_type_form.soft_stop_yn.disabled	= true;
			}
		}
	}
}

function defaultContinous()
{
	if(document.order_type_form.freq_applicable_yn.value=="N" &&  document.order_type_form.cont_order_update_yn.value=="N")
	{
		if(document.order_type_form.cont_order_yn)
		{
			if(document.order_type_form.cont_order_update_yn.value=="Y")  // val[4]
			{
				if(document.order_type_form.cont_order_applicable_yn.value=="Y")
				{
					document.order_type_form.cont_order_yn.checked=true;
				}
				else
				{
					document.order_type_form.cont_order_yn.checked=false;
				}

				document.order_type_form.cont_order_yn.disabled=false;
			}
			else
			{
				if(document.order_type_form.cont_order_applicable_yn.value=="Y")
				{
					document.order_type_form.cont_order_yn.checked=true;
				}
				else
				{
					document.order_type_form.cont_order_yn.checked=false;
				}

				document.order_type_form.cont_order_yn.disabled=true;
			}

			document.order_type_form.cont_order_yn.value=document.order_type_form.cont_order_applicable_yn.value;
		}
	}
	else
	{
		if(document.order_type_form.cont_order_yn)
		{
			if(document.order_type_form.cont_order_update_yn.value=="Y")  // val[4]
			{
				if(document.order_type_form.cont_order_applicable_yn.value=="Y")
				{
					document.order_type_form.cont_order_yn.checked=true;
				}
				else
				{
					document.order_type_form.cont_order_yn.checked=false;
				}
				document.order_type_form.cont_order_yn.value=document.order_type_form.cont_order_applicable_yn.value;
				document.order_type_form.cont_order_yn.disabled=false;
			}
			else
			{
				if(document.order_type_form.cont_order_applicable_yn.value=="Y")
				{
					document.order_type_form.cont_order_yn.checked=true;
				}
				else
				{
					document.order_type_form.cont_order_yn.checked=false;
				}
				document.order_type_form.cont_order_yn.value=document.order_type_form.cont_order_applicable_yn.value;
				document.order_type_form.cont_order_yn.disabled=true;
			}
		}
	}
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		//console.log("checkIsValidForProceed url"+url);
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/**************functions used for "Auto Close Period"***************************/
function CheckSpecCharsCols(event){
    var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function checkPositiveNumber(obj) {  
   var obj_value = obj.value;    // checks for positive number greater than zero
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){
		if(obj_value > 0){
			return true;
		}else{
			obj.value= ""
			obj.focus();
			var message  = getMessage('INVALID_POSITIVE_NUMBER','common');
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}
	}else{
		return true;
	}
}


/**************end of functions used for "Auto Close Period"***************************/
