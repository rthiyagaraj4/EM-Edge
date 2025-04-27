
/* 
	Developer   : Sridevi Joshi
	Created On  : 04/06/07
 */

function create(){
	f_query_add_mod.location.href='../../eOH/jsp/MComplicationsAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].complication_code,f_query_add_mod.document.forms[0].complication_desc);
		var complication_code_title=getLabel("eOH.ComplicationCode.Label","OH");
		var complication_desc_title = getLabel("Common.description.label","Common");

		var names = new Array ( complication_code_title,complication_desc_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var fields1 = new Array (f_query_add_mod.document.forms[0].complication_code);
			var names1 = new Array ( complication_code_title);
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
			if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
			{
				f_query_add_mod.document.forms[0].submit();
			}
		}
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MComplicationsAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
	//f_query_add_mod.location.reload();
	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MComplicationsQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
	
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MComplicationsQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}

