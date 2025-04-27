function create() {
	//f_query_add_mod.location.href = "../../eSM/jsp/AddModifyCreateUserDesktop.jsp" ;
	//f_query_add_mod1.location.href = "../../eSM/jsp/AddModifyCreateUserDesktopResult.jsp" ;
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyCreateUserDesktopFrame.jsp" ;
}

function reset() 
{
		 f_query_add_mod.document.location.reload();
}


function query()
{
	f_query_add_mod.location.href ="../../eSM/jsp/CreateDesktopQueryCriteria.jsp?function=modify";	

}

function apply() {
	if(f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form!=null){
		var fields = new Array (f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Desktop_code,
						f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Desktop_name
					    );
	 var names = new Array (getLabel("Common.code.label","Common")
                          ,getLabel("Common.name.label","Common")    );

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Contents_types.disabled=false;			
			f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Contents_types.disabled=true;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.function_name.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.function_name.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.Desktop_code.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Desktop_code.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.Desktop_name.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Desktop_name.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.eff_status.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.eff_status.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.Contents_types.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Contents_types.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.module_id.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.module_id.value;
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.Function_id.value=f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Function_id.value;
			f_query_add_mod.document.forms[0].action="../../servlet/eSM.MenuHeaderServlet";
			f_query_add_mod.document.forms[0].target="messageFrame";"
			f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.CreateDesktop_form1.submit() ;
			
	
	}
	
}
else
	{
	messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=";

	}
}

	function Getvalues(obj)
{
	var Module_Name=obj.name;
	var module_id=obj.value;
	removeitems(document.forms[0].Function_id);
 
   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'></form></BODY></HTML>";
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.document.form1.submit();
}  

 function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

function onSuccess() {
	f_query_add_mod.location.reload();

}
var temp="";
var temp1="";


function checkvalue(Obj,i)
{
	if(Obj.checked){
		Obj.value="Y";		
	}else{
		Obj.value="N";	
	}

}
function check_eff(obj){
	if(obj.checked){
		obj.value="E";
	}else{
		obj.value="D";
	}
}

