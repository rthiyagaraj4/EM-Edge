/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formProcessGLDistribution.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function apply() {
	var formObj=f_query_add_mod.formProcessGLDistribution;
	var responseText=formApply(formObj,SS_CONTROLLER);
	//eval(responseText);
	//console.log(responseText);
	// Extract the message (assuming it's always in the format we saw in ie)
    var message = "";
    var match = responseText.match(/"([^"]+)"/);  // Extract the first string inside double quotes

    if (match && match[1]) {
        message = match[1];  // Extract the error message
    }

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	//messageFrame.location.href = errorPage+"?err_num="+ message;
	 messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message);

	if( result )
		onSuccess();
}
