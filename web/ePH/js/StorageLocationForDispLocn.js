var result1		=	false;
var function_id =   "PH_STOREAGE_LOCN" ;
var message     =   "" ;
var flag        =   "" ;
var invalidCode =  "";
var globalCode  =   "";
var formObj     =   null;

function create() {
    f_query_add_mod.location.href="../../ePH/jsp/StorageLocationForDispLocnAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query() {
    f_query_add_mod.location.href="../../ePH/jsp/StorageLocationForDispLocnQueryCriteria.jsp?function_id="+function_id ;
}
function beforePost(xmlStr){
//	alert("In tokenSeries function:"+xmlStr)
}
function apply() {

    formObj =   f_query_add_mod.document.formStorageLocation;

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "storage_bin_code";
	arrFieldName[1]         =   "description";
	//arrFieldName[2]       =   "start_serial_no";
   
	arrLegends[0]           =   "Code";
	arrLegends[1]           =   "Description";
	//arrLegends[2]         =   "Start Serial No";
   
    var arrPKFieldNames     =   new Array();

    arrPKFieldNames[0]      =   "storage_bin_code";
  
    if(!proceedOnApply()){
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
    }

    var mode = formObj.mode.value;
      
    if( mode == MODE_INSERT )
    {
//alert(mode);
		resetDuplicateClass(formObj,arrPKFieldNames);
        var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (result){
			var formObj = f_query_add_mod.document.formStorageLocation ;
			var fields = new Array ( formObj.disp_locn_code);
			
			var names = new Array ( "Dispense Location");
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
				var noOfRecords=parseInt(parent.window[2].window[1].document.getElementById("storageLocation_insert").rows.length - 5);
			

			
				for (i=0; i<=noOfRecords; i++ ){		
					if (eval("formObj.eff_status"+i).checked==true){
						break;
					}
					else if (eval("formObj.eff_status"+i).checked==false && (noOfRecords == i)){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","common");
						return ;
					}
				}
				
				eval(formApply(f_query_add_mod.document.formStorageLocation,PH_CONTROLLER));
				if(result1) {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					onSuccess();
					return false;
				}
				var invalidCodeList		=	 "";
				var arrIndividualCodes	=	invalidCode.split(",");
				var lenIndividualCodes	=	arrIndividualCodes.length;
				for(var i=0; i<lenIndividualCodes; i++){	
					var individualCodes	=	arrIndividualCodes[i];
					var arrNextPKCode	=	individualCodes.split(":");
					var nextPKCode		=	arrNextPKCode[1];
					invalidCodeList		+=	nextPKCode + ",";
					
				}

				if(invalidCodeList.length>2)
					invalidCodeList	=	invalidCodeList.substring(0,invalidCodeList.length-1);
				invalidCode		=	invalidCodeList;
				if( invalidCode != "null" && invalidCode != "" ){
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
					return false;
                }
			}
        }
        else{
            return false;
        }
	}
	if( mode == MODE_MODIFY ){
        
		var formObj = f_query_add_mod.document.formStorageLocation ;
		var fields = new Array (formObj.storage_locn_desc);
		var names = new Array ("Dispense Location Storage");
          
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {				
			
				eval(formApply( f_query_add_mod.document.formStorageLocation,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
				if( result1 ) {
					onSuccess();	
					return false;
				}
			    }else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MANDATORY");	
			    }
			
		//}else{
			if (formObj.storage_locn_desc == ""){
				formObj.storage_locn_desc.focus();
			}
		//}
	}
}

function onSuccess() {
    var mode = f_query_add_mod.document.formStorageLocation.mode.value;
    if( mode == MODE_INSERT ) {
        f_query_add_mod.document.formStorageLocation.reset();
		f_query_add_mod.document.formStorageLocation.disp_locn_code.disabled = false;
    }
    else if(mode == MODE_MODIFY ){
		var formObj = f_query_add_mod.document.formStorageLocation ;		
        f_query_add_mod.location.href="../../ePH/jsp/StorageLocationForDispLocnAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+formObj.disp_locn_code.value+"&storage_bin_code="+formObj.storage_bin_code.value;
    }
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;	
	
}

function reset() {

    var url = f_query_add_mod.location.href;
	
    url = url.toLowerCase();

    if ( (url.indexOf("storagelocationfordisplocnquerycriteria")!=-1) ) {
          
        f_query_add_mod.document.query_form.reset();
    }

    else if ( (url.indexOf("storagelocationfordisplocnaddmodify")!=-1) )
    {
		
		//f_query_add_mod.document.formStorageLocation.disp_locn_code.disabled = true;
        if(f_query_add_mod.document.formStorageLocation.mode.value == MODE_INSERT)
        {
            formObj =   f_query_add_mod.document.formStorageLocation;

            var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "storage_bin_code";

            resetDuplicateClass(formObj,arrPKFieldNames);
            f_query_add_mod.document.formStorageLocation.reset();
        }
        else {
            f_query_add_mod.document.formStorageLocation.reset();
        }
    }
}
function toUpper(obj) {
    obj.value=obj.value.toUpperCase();
}

function Modify(obj){
	var disp_locn_code=obj.cells[0].innerText;
	var storage_bin_code=obj.cells[2].innerText;
	var disp_locn_desc=obj.cells[3].innerText;
	document.location.href="../../ePH/jsp/StorageLocationForDispLocnAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+disp_locn_code+"&storage_bin_code="+storage_bin_code+"&disp_locn_desc="+disp_locn_desc;
}

function DispLocnCheck(obj){
	    if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED"));
        obj.focus();
        return false;
    }
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("storagelocationfordisplocnquery")==-1) )
        return true;
    else
        return false;
}

function resetColorCode(obj)
{
    var arrPKFieldNames =   new Array();
    var formObj         =   parent.f_query_add_mod.document.formStorageLocation;
    /**
      * specify the primary key columns
      */
    arrPKFieldNames[0]  =   "storage_bin_code";

    /**
      * if more than one columns exists in
      * the primary key, then the next columns
      * can be given like this
      */
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function onBlurCheck(obj){

	formObj =   parent.f_query_add_mod.document.formStorageLocation;
	//alert(eval("formObj.disp_locn_code"+obj).value)
	if (eval("formObj.storage_bin_code"+obj).value != "" && eval("formObj.description"+obj).value != "" ){
		eval("formObj.eff_status"+obj).checked = true;
	}else{
		eval("formObj.eff_status"+obj).checked = false;
	}
}

function validateSerialNo(obj){
	if (parseFloat(obj.value) ==0){		
		alert(getMessage("VALUE_GREAT_ZERO"));
		obj.select();
		obj.focus();
		return false;
	}
	if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED"));
		obj.select();
        obj.focus();
        return false;
    }
}
function validateForTheValue(obj,existingValue){
	if (parseFloat(obj.value) < parseFloat(existingValue)){
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_LESS_THAN_CURRENT");
		obj.focus();
		obj.select();
		return false;
	}else{
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
}
function getWSNoForList(){
		var formObj =   parent.f_query_add_mod.document.formStorageLocation;
		
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		formObj.disp_locn_code.disabled = true;

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "StorageLocationnForDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+formObj.disp_locn_code.value, false ) ;
		xmlHttp.send( xmlDoc ) ;
//		alert(xmlHttp.responseText)
		eval(xmlHttp.responseText);
}



function SubmitLink(from,to){
	var obj=document.frmStorageLocnForDispLocnQuerytResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.submit();
}

