var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}
function create() {
	f_query_add_mod.location.href="../../eMM/jsp/SupplierAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
		f_query_add_mod.location.href="../../eMM/jsp/SupplierQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	var formObj = f_query_add_mod.document.forms[0]; 
	if(formObj==null){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var fields = new Array ( formObj.supplier_code, formObj.alpha_code,formObj.long_desc,formObj.short_desc);
	var names = new Array ( getLabel("Common.SupplierCode.label","Common"),getLabel("Common.AlphaCode.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	var blankObj	=	null;
	blankObject		=	checkMMFields( fields, names, messageFrame,errorPage);
	if(blankObject==true) {
		responseText= formApply(formObj,MM_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
	
			onSuccess();
		}
	}
	else{
	
	}
	
}

function reset() {
			f_query_add_mod.document.forms[0].reset();
			
}

function onSuccess() {
	var mode = f_query_add_mod.document.forms[0].mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else
	{
	
		create();
	}
		
}

function Modify(obj){
	
	var supplier_code=obj.cells[0].innerText;
	document.location.href="../../eMM/jsp/SupplierAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&supplier_code="+supplier_code;
	

}

function callTextBox ()
{
	
	}

	function isValidNumber(fld, e, maxInt, deci) {
	
	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 0) {
						fld.value = fld.value + ".";
					}else{
						return false;
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							//fld.value = objectValue.substring(0, maxInt);
							return false;
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return false;  // Enter  --  Modified by gangadharan for disable Enter button
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}
// Added By Sakti Sankar against Inc#29965
function isvalidemail()
{
	var formObj = document.SupplierAddQueryCriteriaform.email_id;
var x=formObj.value;
//alert(x);
if(x !="") {
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
 
 document.SupplierAddQueryCriteriaform.email_id.value="";
   document.SupplierAddQueryCriteriaform.email_id.select();
    return false;
  }
}
}
//Added ends

// Added The Function To Restrict the User To paste Only Prescribed No Of  Characters 25/04/2012 -- Sakti Sankar Inc#29965
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
