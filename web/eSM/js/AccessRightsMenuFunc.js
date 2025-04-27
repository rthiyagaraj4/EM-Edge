function apply()
{
	frames[1].document.f_query_add_mod1.document.forms[0].submit;
	var fields = new Array ( 
			frames[1].document.f_query_add_mod1.document.forms[0].Menu
				);	
				
	var names = new Array ( getLabel("Common.menu.label","Common")
			      );	
	if( frames[1].document.f_query_add_mod1.checkFieldsofMst( fields, names, messageFrame) )
	{		
		frames[1].document.function_frame.document.forms[0].submit() ;
				setTimeout('aaa()',1000);
	}	
	
}

function clearVal()
{
	parent.frames[1].location.href= "../../eCommon/html/blank.html";
}

function  PopVal()
{

	if( parent.frames[0].document.AccessRightsMenu_form.Menu.value.length > 0 )
	{		
		var errors = "";
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;

		var menuVal   = parent.frames[0].document.AccessRightsMenu_form.Menu.value;
		var moduleVal = parent.frames[0].document.AccessRightsMenu_form.module.value; 
		var funcVal   = parent.frames[0].document.AccessRightsMenu_form.functionName.value; 
		var menuId    = parent.frames[0].document.AccessRightsMenu_form.Menu.value; 
			
		parent.frames[1].location.href= "../../eSM/jsp/AccessRightsMenuQueryForm.jsp?&menuId="+menuId+"&menuVal="+menuVal+"&moduleVal="+moduleVal+"&funcVal="+funcVal;		
	}
	else
	{
		var errors=parent.frames[0].getMessage("CAN_NOT_BE_BLANK",'Common');
		errors = errors.replace("$",getLabel("Common.menu.label","Common"));
		errors = errors+ "<br>";
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
	}
}

function reset() 
{
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
}

function onSuccess() {



}

function aaa()
{
	
	var  Menu=frames[1].frames[0].document.forms[0].Menu.value;
	var  module=frames[1].frames[0].document.forms[0].module.value;
	var  function_name=frames[1].frames[0].document.forms[0].functionName.value;
	frames[1].frames[1].location.href='../../eSM/jsp/AccessRightsMenuQueryForm.jsp?menuId='+Menu+'&moduleVal='+module+'&funcVal='+function_name;		

}
