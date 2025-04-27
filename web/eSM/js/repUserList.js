function reset() {
	f_query_add_mod.document.forms[0].reset() ;
}

function run() {
	var names=new Array(f_query_add_mod.getLabel("eSM.UserIDFrom.label","eSM"),f_query_add_mod.getLabel("Common.userid.label","Common")+" "+f_query_add_mod.getLabel("Common.to.label","Common"));
	var fields=new Array(f_query_add_mod.document.repUserList.p_from_appl_user_id,f_query_add_mod.document.repUserList.p_to_appl_user_id);
	if(checkFieldsSM(fields,names,messageFrame)){
		if( f_query_add_mod.CheckString1('User ID', f_query_add_mod.document.repUserList.p_from_appl_user_id, f_query_add_mod.document.repUserList.p_to_appl_user_id, messageFrame ))
			f_query_add_mod.document.repUserList.submit() ;
	}

function checkFieldsSM( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(f_query_add_mod.trimCheck(fields[i].value)) {
            fields[i].value = f_query_add_mod.trimString(fields[i].value);
        }
        else {
			errors += f_query_add_mod.getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n"
		}
    }
    if ( errors.length != 0 ) {
        

	alert(errors);
	return false;

    }else{
    return true ;
	}
}	 		
	
}
