function create() 
{

f_query_add_mod.location.href = "../../eMR/jsp/addModifyMRASAScore.jsp" ;

} 

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/MRASAScorequeryCriteria.jsp";
}

 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function apply() {
 
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var fields = new Array (	f_query_add_mod.document.MRASAScore_form.asa_score_code,
					f_query_add_mod.document.MRASAScore_form.patient_physical_status
					);

	var names = new Array ( getLabel("Common.Class.label","Common")+" "+getLabel("Common.code.label","Common"),
				getLabel("Common.patient.label","Common")+" "+getLabel("Common.PhysicalStatus.label","Common")
				);

	var field = new Array (	f_query_add_mod.document.MRASAScore_form.asa_score_code	);

	var name = new Array ( getLabel("Common.Class.label","Common")+""+getLabel("Common.code.label","Common"));




		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{  
			if (SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.MRASAScore_form.submit();
				var fn_status = f_query_add_mod.document.MRASAScore_form.function_name.value ;
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


    
    
function onSuccess() {
/*
if(f_query_add_mod.document.RhesusFactor_form.function_name.value=="insert")
{

	f_query_add_mod.document.RhesusFactor_form.asa_score_code.value	= "" ;
	f_query_add_mod.document.RhesusFactor_form.short_desc.value	= "" ;
	f_query_add_mod.document.RhesusFactor_form.patient_physical_status.value	= "" ;
	f_query_add_mod.document.RhesusFactor_form.eff_status.value	= "E" ;
	f_query_add_mod.document.RhesusFactor_form.eff_status.checked	= true ;
}
*/
f_query_add_mod.location.reload();
}

function reset() {
/*
			if(f_query_add_mod.document.forms[0].name == "RhesusFactor_form") 
				f_query_add_mod.document.RhesusFactor_form.reset() ;
		    else if(f_query_add_mod.document.forms[0].name == "query_form" )
				f_query_add_mod.document.location.reload();
			else f_query_add_mod.document.query_form.reset() ;
*/
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.forms[0].reset();

		   }


	function change() {
      	 if (MRASAScore_form.eff_status.checked == true)
      	 	MRASAScore_form.eff_status.value="E";
      	 else
      		MRASAScore_form.eff_status.value="D";
      	}
      	
	 

