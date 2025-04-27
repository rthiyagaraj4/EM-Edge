function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyNursUnitPhysLocn.jsp?param=create" ;
}

function query()
{
	f_query_add_mod.location.href = "../../eIP/jsp/NursUnitPhysLocnQueryCriteria.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) && (url.indexOf("reset")==-1))
        return true;
    else
        return false;
  }
function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.physical_location.function_name.value == 'insert')
	{
	var fields = new Array(
				f_query_add_mod.document.physical_location.nursing_unit,
	 	     	f_query_add_mod.document.physical_location.building,
				f_query_add_mod.document.physical_location.floor
			      );

	var names = new Array (	getLabel('Common.nursingUnit.label','common'),
				getLabel('Common.building.label','common'),
				getLabel('Common.floor.label','common') )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{    
		
	f_query_add_mod.document.physical_location.submit();
	}
}
else{
messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
f_query_add_mod.document.physical_location.submit();
}
}
function onSuccess() {
		/*if(f_query_add_mod.document.forms[0].function_name.value == 'delete')
			f_query_add_mod.location.href='../../eCommon/html/blank.html' 
		else*/
		f_query_add_mod.document.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0].name == "query_form")
		f_query_add_mod.document.forms[0].reset();	
		
	if(f_query_add_mod.document.forms[0].name =="physical_location"){
		f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.document.physical_location.function_name.value =="insert")
		f_query_add_mod.document.forms[0].nursing_unit.focus();
		ClearList(f_query_add_mod.document.physical_location.floor)
		}
}

function deleterecord()
{
	if(f_query_add_mod.document.physical_location.function_name.value != 'insert')
	{   
		f_query_add_mod.document.physical_location.function_name.value='delete';
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','common')))
		{
		f_query_add_mod.document.physical_location.submit();
		//f_query_add_mod.document.forms[0].reset();	
		f_query_add_mod.location.href="../../eCommon/html/blank.html";
			return true;
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}

function validate(Obj)
{
	var HTMLVal = new String();
	var u=Obj.value;
	if(Obj.value !=null || Obj.value !="")
	{
	HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/ServerValidation.jsp'><input type='hidden' name='building_code' id='building_code' value='"+u+"'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
	}
	else
	{
	var len=parent.frames[1].document.forms[0].floor.length;
	var i=1;
	while(i<len)
		{
		len=parent.frames[1].document.forms[0].floor.length
		parent.frames[1].document.forms[0].floor.remove(i)
		}
	}
}

function ClearList(object)
{
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.createElement('option');
    element.text= "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
    element.value="";
		for(i=1;i<length;i++)
            object.remove(1);
}

//functions moved from AddModifyNursUnitPhysLocn.jsp

function focusTxt()
{
	physical_location.nursing_unit.focus();
}	

//This is an empty implementation to be given for the nursing unit select item
function popDynamicValues(Obj) { }

