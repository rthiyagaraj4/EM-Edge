  var function_id = "PH_" ;
var result1		= false ;
var message		= "" ;
var flag		= "" ;
var invalidCode	= "";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/WsDispLocnAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/WsDispLocnQueryCriteria.jsp?function_id="+function_id;
}

function deleterecord() {

	if ( !checkIsValidForProceed( "wsdisplocnaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else {

		if (f_query_add_mod.document.Dispense_Location.mode.value == MODE_MODIFY) {
			f_query_add_mod.document.Dispense_Location.mode.value = MODE_DELETE;
			if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
				apply();
			else {
				f_query_add_mod.document.Dispense_Location.mode.value = MODE_MODIFY;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
}

function apply() {
	if ( !checkIsValidForProceed( "wsdisplocnaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	var formObj = f_query_add_mod.document.Dispense_Location;
	var arrFieldName	= new Array();
	var arrLegends		= new Array();

	arrFieldName[0]		= "WS_NO";
	arrLegends[0]		= "Workstation No";

	var arrPKFieldNames	= new Array();
	arrPKFieldNames[0]	= "WS_NO";

	var mode = formObj.mode.value;

	if( mode == MODE_INSERT ) {
		
		
	
		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
		var blankObj 	= null ;
		var fields		= new Array ( formObj.DISP_LOCN_CODE);
		var names		= new Array ( getLabel("ePH.DispenseLocation.label","PH"));
		
//		blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
//		blankObject  = checkFieldsofMst( fields, names, messageFrame, errorPage) ;
//		alert('at 67 == '+blankObject);
//		if(blankObject==null) {
		if(checkFieldsofMst( fields, names, messageFrame, errorPage)) {

			resetDuplicateClass(formObj, arrPKFieldNames);
			var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);

			if (result) {
				for(var i=0; i<formObj.length;i++){
					if(formObj[i].type == "checkbox"){
						if(formObj[i].checked == true){
							if(formObj[i-1].value == ""){
							var alrt=getMessage("PH_WORK_STATION_BLANK","PH");

							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+alrt;
							formObj[i-1].focus();
							formObj[i-1].className = "DUPLICATE";
							return false;
						
							}
						}
					}
				}
				//alert("Here");
				//alert(formApply(formObj,PH_CONTROLLER));
				eval(formApply(formObj, PH_CONTROLLER));
				
				if( result1 ) {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					onSuccess();
				}
				if( invalidCode != "null" && invalidCode != "" ) {
				var value="";
				var invalCode="";
				//alert(invalidCode);
				var inval=invalidCode;
				//alert("Code ="+inval);
				var incode=inval.split(",");
				for(i=0; i<incode.length;i++)
				{

					var inc=incode[i].split(":");
					for(j=0;j<inc.length;j++)
					{

						var val=inc[2];
						var inval1=inc[1]+":"+inc[2];

					}

					if(i==incode.length-1)
					{
						invalCode += inval1;
						value+=val;

					}
					else
					{
						invalCode += inval1+",";
						value += val+",";

					}

					invalidCode=value;

				}
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message+":-"+value;
					showDuplicates(formObj, arrPKFieldNames, invalidCode,0,messageFrame);
					return false;
				}
			}
		}
		else {

	//		blankObject.focus() ;
		}
   	}

	if( mode == MODE_MODIFY ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}

	if( mode == MODE_DELETE ) {
		//alert(	formApply( formObj, PH_CONTROLLER ));
		eval( formApply( formObj, PH_CONTROLLER ) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result1 ) {
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
		}
	}
}

function reset() {
	var url = f_query_add_mod.location.href;

	if ( (url.indexOf("WsDispLocnQueryCriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	
	url = url.toLowerCase();
	//f_query_add_mod.document.Dispense_Location.reset();
	//alert('In Reset');
	if (f_query_add_mod.document.Dispense_Location!=undefined)
	{

		var mode=f_query_add_mod.document.Dispense_Location.mode.value;
		//alert("Mode ="+mode);
		if(f_query_add_mod.document.Dispense_Location.mode.value == MODE_INSERT){
			
		formObj =   f_query_add_mod.document.Dispense_Location;
		var arrPKFieldNames     =   new Array();
		arrPKFieldNames[0]      =   "WS_NO";
		
            	resetDuplicateClass(formObj,arrPKFieldNames);
		f_query_add_mod.document.Dispense_Location.reset();

		//formReset() ;
	}
	else(f_query_add_mod.document.Dispense_Location.mode.value == MODE_MODIFY)
	{

		f_query_add_mod.document.Dispense_Location.reset();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	}
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
}

function onSuccess() {
	   f_query_add_mod.document.Dispense_Location.reset();
}

function assignResult( _result, _message, _flag, _invalidCode) {
	result1 	= _result ;
	message		= _message ;
	flag		= _flag ;
	invalidCode = _invalidCode ;
	//alert(result1 + ', ' + message + ', ' + flag + ', ' + invalidCode);
}

function Modify(obj) {
	var DISP_LOCN_CODE=obj.cells[0].innerText;
	var DISP_LOCN_DESC=obj.cells[1].innerText;
	var WS_No=obj.cells[2].innerText;
	document.location.href="../../ePH/jsp/WsDispLocnAddModify.jsp?mode="+MODE_MODIFY+"&WS_NO="+WS_No+"&DISP_LOCN_CODE="+DISP_LOCN_CODE+"&DISP_LOCN_DESC="+DISP_LOCN_DESC;
}

function check(objval, objnum)	{

	
	var obj = eval("document.Dispense_Location.eff_status"+objnum);
	
	
	if (objval != '')
		obj.checked=true;
	else
		obj.checked=false;
}

function resetColorCode(obj) {
	var arrPKFieldNames	=	new Array();
	arrPKFieldNames[0]	=	"WS_NO";
	resetDuplicateClass( parent.f_query_add_mod.document.Dispense_Location, arrPKFieldNames, 0, obj );
}

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}


/*		 for(var i=0; i<formObj.length;i++){
			if(formObj[i].type == "checkbox"){
				 if(formObj[i].checked == true){
					if(formObj[i-1].value == ""){
						var alrt=getMessage("PH_WORK_STATION_BLANK");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+alrt;
						formObj[i-1].focus();
						formObj[i-1].className = "DUPLICATE";
						return false;
					}
				 }
		  	}
		}
*/
function CheckSpecChars1(event){	
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*.-';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		//return (event.keyCode -= 32);
	changeToUpper();
	return true ;
	}

