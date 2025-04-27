/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Java Script functions for StatisticalGroup

function create() {
	f_query_add_mod.location.href="../../eSS/jsp/StatisticalGroupAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/StatisticalGroupQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY ;
}

function apply() {
	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj = f_query_add_mod.document.formStatisticalGroup ;

	var fields = new Array ( formObj.stat_group_code, 
						formObj.long_desc,
						formObj.short_desc
						);

	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),	getLabel("Common.shortdescription.label","Common"));
	
	var errorPage="../../eCommon/jsp/error.jsp";
		 if (f_query_add_mod.checkSSFields( fields, names, messageFrame))
		 {
				eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
				messageFrame.location.href = errorPage+"?err_num="+ message;
				if( result ) 
				{
					onSuccess();
				}
		 }

}


   
  
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("statisticalgroupquery")==-1) )
        return true;
    else
        return false;
}

function reset() {
	if(f_query_add_mod.document.formStatisticalGroup!=null)
		f_query_add_mod.document.formStatisticalGroup.reset();
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}


function onSuccess() {
	var mode = f_query_add_mod.document.formStatisticalGroup.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var stat_group_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/StatisticalGroupAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&stat_group_code="+stat_group_code;
}
