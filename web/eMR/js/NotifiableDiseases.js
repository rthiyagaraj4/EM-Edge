
function create() 
{
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyNotifialeDiseases.jsp" ;
} 
function edit() 
{
formToolbarFrame.location.href = "formToolbar.html" ;
}
function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/NotifiableDiseasesCriteria.jsp";
}
 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	/*---purpose of below line---*/
	//if this "url" has any 'q' and 'b' character, return false otherwise true.
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}



function apply() {
 
 
 //When we are beeing  in create mode scrrn at the time if we click apply button  this method  "checkIsValidForProceed()" will return "true" otherwise "false".
	if (! (checkIsValidForProceed()) ) 
    { 
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var fields = new Array (	f_query_add_mod.document.Notifiable_Diseases_form.notify_dis_code,
					f_query_add_mod.document.Notifiable_Diseases_form.long_desc,
					f_query_add_mod.document.Notifiable_Diseases_form.short_desc
				);

	var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")
				);
	var field = new Array (	f_query_add_mod.document.Notifiable_Diseases_form.notify_dis_code	);

	var name = new Array ( getLabel("Common.code.label","Common"));




		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.Notifiable_Diseases_form.submit();
				var fn_status = f_query_add_mod.document.Notifiable_Diseases_form.function_name.value ;
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
		
		
function onSuccess() 
{
f_query_add_mod.location.reload();

}
function reset() 
		{
		
if(f_query_add_mod.document.forms[0])
f_query_add_mod.document.forms[0].reset();
}


	function change() {
      	 if (Notifiable_Diseases_form.eff_status.checked == true)
      	 	Notifiable_Diseases_form.eff_status.value="E";
      	 else
      		Notifiable_Diseases_form.eff_status.value="D";
      	}
