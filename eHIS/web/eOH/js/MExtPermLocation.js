/*
	Developer   : Muraleedhar
	Created On  : 01/10/2009
*/

function create()
{
	f_query_add_mod.location.href='../../eOH/jsp/MExtPermLocationAddModify.jsp?mode=insert';
}

function apply(){
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].extPermLoc_code,f_query_add_mod.document.forms[0].extPermLoc_desc);
		var code_title=getLabel("eOH.ExternalPerformingLocationCode.Label","OH");
		var description_title = getLabel("eOH.ExternalPerformingLocationDesc.Label","OH");

		var names = new Array (code_title,description_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var fields1 = new Array (f_query_add_mod.document.forms[0].extPermLoc_code);
			var names1 = new Array ( code_title);
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
		f_query_add_mod.location.href='../../eOH/jsp/MExtPermLocationAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
    //f_query_add_mod.location.reload();
	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MExtPermLocationQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MExtPermLocationQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}

