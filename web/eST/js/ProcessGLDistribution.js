 function reset() {
	f_query_add_mod.formProcessGLDistribution.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
}

function apply() {
	var formObj=f_query_add_mod.formProcessGLDistribution;
	var responseText=formApply(formObj,ST_CONTROLLER);
	eval(responseText);
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	messageFrame.location.href = errorPage+"?err_num="+ message;
	if( result )
		onSuccess();
}