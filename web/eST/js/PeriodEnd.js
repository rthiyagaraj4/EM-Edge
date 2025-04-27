 function reset() {
	f_query_add_mod.formPeriodEnd.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function apply() {
	var formObj=f_query_add_mod.formPeriodEnd;
	var responseText=formApply(formObj,ST_CONTROLLER);
	eval(responseText);
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	messageFrame.location.href = errorPage+"?err_num="+ message;
	if( result )
		onSuccess();
}