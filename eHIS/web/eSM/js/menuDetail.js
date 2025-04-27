var temp;

function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/addmenuDetail.jsp?menu="+temp ;
}

function apply() {

  if(f_query_add_mod.document.forms[0]!=null)
  {
		var fields = new Array ( f_query_add_mod.document.forms[0].Menu);
		var names  = new Array ( getLabel("Common.menu.label","Common")	 );

		temp = f_query_add_mod.document.forms[0].Menu.value;
		f_query_add_mod.hiddenlistassign();
		if(f_query_add_mod.document.forms[0].hiddenlist.value == ''){
			alert(f_query_add_mod.getMessage('ATLEAST_ONE_MENU','SM'));
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
			}
		else
		{
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
				f_query_add_mod.document.menu_detail_form.submit();
				create();
			}
		}
  }else
  {
	  frames[0].location.reload();
	  return false;

  }
}

function reset() {

menu=f_query_add_mod.document.forms[0].Menu.value
module=f_query_add_mod.document.forms[0].Module.value
f_query_add_mod.location.href="../../eSM/jsp/addmenuDetail.jsp?menu="+menu+"&module="+module;
}

function onSuccess() {

}
