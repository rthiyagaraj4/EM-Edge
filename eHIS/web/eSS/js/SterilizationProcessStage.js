/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/SterilizationProcessStageAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/SterilizationProcessStageQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
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
    arrLegends[2]           =  getLabel("Common.shortdescription.label","Common"); 

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
        /*resetDuplicateClass(formObj,arrPKFieldNames);
        var blankObj  =   checkSSFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (blankObj){
            eval(formApply(formObj,SS_CONTROLLER));

            if( result) {

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
			eval(formApply(formObj,SS_CONTROLLER));
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
        var frmobj = f_query_add_mod.document.forms[0];
		var errorPage	=	"../../eCommon/jsp/error.jsp";
        var obj=f_query_add_mod.document.formSterilizationProcessStage;

      
		var fields = new Array (formObj.code_0, formObj.long_desc_0, formObj.short_desc_0);
		var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),	getLabel("Common.shortdescription.label","Common"));
			if(checkSSFields( fields, names, messageFrame,errorPage)) 
			{
				eval(formApply(formObj,SS_CONTROLLER));
				messageFrame.location.href = errorPage+"?err_num="+ message;
				if( result )
				{
					onSuccess();
				}
			}
	
    }

}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("sterilizationprocessstagequery")==-1) )
        return true;
    else
        return false;
}

function reset() {
	if (f_query_add_mod.document.formSterilizationProcessStage != null) {
        f_query_add_mod.document.location.reload();
		f_query_add_mod.FocusFirstElement();
	} 
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formSterilizationProcessStage.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var processStageCode=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/SterilizationProcessStageAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&process_stage_code="+processStageCode;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.f_query_add_mod.document.formSterilizationProcessStage;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
