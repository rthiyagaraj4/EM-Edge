function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyRhesusFactor.jsp" ;
} 

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/RhesusFactorqueryCriteria.jsp";
}

function apply() {

	var fields = new Array (	f_query_add_mod.document.RhesusFactor_form.rhesus_factor_code,
					f_query_add_mod.document.RhesusFactor_form.long_desc,
					f_query_add_mod.document.RhesusFactor_form.short_desc
				);

	var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")

				);
	var field = new Array (	f_query_add_mod.document.RhesusFactor_form.rhesus_factor_code	);

	var name = new Array ( getLabel("Common.code.label","Common")	);




		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.RhesusFactor_form.submit();
				var fn_status = f_query_add_mod.document.RhesusFactor_form.function_name.value ;
			}
		}
	}


function SpecialCharCheck( fields, names, messageFrame,disp_type,error_jsp) {
        var errors = "" ;
        for( var i=0; i<fields.length; i++ ) {
            if(CheckChars(fields[i])) {
            }
            else{
                if (disp_type=="A")
				{
					errors += getMessage('CANNOT_BE_SPECIAL_CHAR','common');
					errors = errors.replace('APP-002452','APP-002452'+ names[i]);
				}
                else if(disp_type=="M")
				{
					errors += getMessage('CANNOT_BE_SPECIAL_CHAR','common');
					errors = errors.replace('APP-002452','APP-002452'+ names[i]);
				}
            }
        }
        if ( errors.length != 0 ) {
            var loc_route = error_jsp+"?err_num="+errors;
            if (disp_type=="M")messageFrame.document.location.href=loc_route;
            else if (disp_type=="A")alert(errors);
            return false ;
        }
        return true ;
    }
    
    function CheckChars(Obj){
            var str = Obj.value;
            var specCharsExist = true;
            for (u=0;u<str.length;u++){
                if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42) ||(str.charCodeAt(u)==43) || (str.charCodeAt(u)==45));
                else{
                    specCharsExist = false;
                    break;
                }
            }
            return specCharsExist;
        }

function reset() 
{
	if(query_procedure_criteria.document.procedure_criteria)
	   query_procedure_criteria.document.procedure_criteria.reset();
	query_procedure_result.location.href = '../../eCommon/html/blank.html';
}

function submitPage()
{
	var procedure_code = document.procedure_criteria.procedure_code.value;
	var procedure_desc = document.procedure_criteria.procedure_desc.value;
	var mr_procedure_set = document.procedure_criteria.mr_procedure_set.value;
	/*if (procedure_code=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK","Common");
		error= error.replace('$',getLabel("Common.ProcedureCode.label","Common"));
		alert(error);
		return;
	}*/
	var error_msg="";
	if(mr_procedure_set==""){
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("eMR.ProcedureCodeScheme.label","MR"));
		error_msg=error_msg+msg+"\n";
	}
	if (procedure_code==""){
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.ProcedureCode.label","Common"));
		error_msg=error_msg+msg;
	}
	if(error_msg==""){
		parent.frames[2].location.href = "../../eMR/jsp/QueryProcedureResult.jsp?procedure_code="+procedure_code; //+"&procedure_desc="+procedure_desc
	}else{
		alert(error_msg)
		return;
	}
}

async function getProcedureDetails()
{

	var dialogTop   = "56vh"; 
	var dialogHeight  = "85vh" ;
	var dialogWidth = "60vw" ;
	//var features    ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	
	var proc_code	= document.procedure_criteria.proc_code.value;
	var proc_desc  = document.procedure_criteria.proc_desc.value;
	var procedure_set  = document.procedure_criteria.mr_procedure_set.value;
	var params      ="";
	/*var params  = "../../eMR/jsp/MRSearchProcedureMain.jsp?s_scheme=";
	params     += proc_code+"&s_scheme_desc=Procedure Code";   
	alert(params)*/
		if(procedure_set==""){
			var msg=getMessage("CAN_NOT_BE_BLANK","Common");
			msg= msg.replace('$',getLabel("eMR.ProcedureCodeScheme.label","MR"));
			alert(msg);
			document.forms[0].mr_procedure_set.focus();
			return;
		}else{
			 params       = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+procedure_set+"&term_set_id="+procedure_set;
		}
		var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null)){
		 var vals=retVal.split("||")  ;
         document.procedure_criteria.procedure_code.value = vals[0];
         document.procedure_criteria.procedure_desc.value = vals[1];
    }
}

function clearAll()
{
	parent.query_procedure_result.location.href = '../../eCommon/html/blank.html';
}

function getProcedureDesc()
{
	document.forms[0].procedure_desc.value="";
	var val1 = document.forms[0].procedure_code.value;
	var name = document.forms[0].proc_code.value;
	if(val1!='')
    {

        var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMR/jsp/QueryDiagnosisPopulateDesc.jsp'>"+
                            " <input type='hidden' name='scheme' id='scheme' value=\""+name+"\">"+
                            " <input type='hidden' name='code' id='code' value=\""+val1+"\">"+
                            " <input type='hidden' name='status' id='status' value=\"QUERY_PROC\">"+                            
                     
                            " </form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.dum_form.submit();

    }

}
function clearProcCode(){
	document.forms[0].procedure_code.value="";
	document.forms[0].procedure_desc.value="";
	var qry_result_fromObj=parent.query_procedure_result.document.forms[0];
	if(qry_result_fromObj && qry_result_fromObj.name=="QUERY_PROC_RESULT_FROM"){
			parent.query_procedure_result.location.href='../../eCommon/html/blank.html';
	}
}

