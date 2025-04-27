/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/ServiceLocationAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/ServiceLocationQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}


			
function apply() {

    formObj =   f_query_add_mod.document.forms[0];

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "code_";
    arrFieldName[1]         =   "long_desc_";
    arrFieldName[2]         =   "short_desc_";

    arrLegends[0]           =   getLabel("Common.code.label","Common");
    arrLegends[1]           =   getLabel("Common.longdescription.label","Common");
    arrLegends[2]           =   getLabel("Common.shortdescription.label","Common");

    var arrPKFieldNames     =   new Array();
    arrPKFieldNames[0]      =   "code_";
	
	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }

    var mode = formObj.mode.value;

    if( mode == MODE_INSERT )
    {
       /* resetDuplicateClass(formObj,arrPKFieldNames);
        var blankObj  =   checkSSFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (blankObj){
            eval(formApply(formObj,SS_CONTROLLER));

            if( result ) {

                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
                onSuccess();
            }
            if( invalidCode != "null" && invalidCode != "" ){
                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+":-"+invalidCode;
                showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
                }
        }
        else
        {
            return false;
        }*/

		var validateResult = validateSSMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if(validateResult) {
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			if( result ) {
				onSuccess();
			}				
			if( invalidCode != "null" && invalidCode != "" ){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+":-"+invalidCode;
				return; //Added By Sakti Sankar against Inc#28682

				//Commented by Sakti Sankar against inc#28682 
				//showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame); 
			}
			else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}
		}
    }

   if( mode == MODE_MODIFY )
    {
		var frmobj = f_query_add_mod.document.formServiceLocation;
		var errorPage	=	"../../eCommon/jsp/error.jsp";

		var fields = new Array (formObj.code_0, formObj.long_desc_0, formObj.short_desc_0);
		var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
		
		if (checkSSFields( fields, names, messageFrame))
		{
			responseText = formApply(frmobj,SS_CONTROLLER);
			eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}
    }

    }



function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("servicelocationquery")==-1) )
        return true;
    else
        return false;
}


function isInArray(_array, _value) {
	var found	=	false;
	for (index=0;index<_array.length ;index++ ) 
		if(_array[index]==_value){
			found=true;
			break;
		}
	return found;
}

function reset() {
	if (f_query_add_mod.document.formServiceLocation!=null) {
       f_query_add_mod.document.location.reload();
  	   f_query_add_mod.FocusFirstElement();
	}
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formServiceLocation.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else 
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var service_location_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/ServiceLocationAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&service_location_code="+service_location_code;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.f_query_add_mod.document.formServiceLocation;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
