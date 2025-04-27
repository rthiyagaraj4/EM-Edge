function checkFieldsofMst( fields, names, messageFrame,errorvalue) {

	
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
    }
    if ( errors.length != 0 ) {
		if(errorvalue==1)
		 messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
        return false ;

    }
    return true ;
}