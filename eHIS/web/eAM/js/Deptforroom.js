 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addmodifyDeptforroom.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/DeptforroomQueryCriteria.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields=new Array();

	if (f_query_add_mod.document.DeptRoom_form.function_name.value == "insert")
	{
		fields[0]= f_query_add_mod.document.DeptRoom_form.facility.options[f_query_add_mod.document.DeptRoom_form.facility.options.selectedIndex]
		fields[1]= f_query_add_mod.document.DeptRoom_form.room.options[f_query_add_mod.document.DeptRoom_form.room.options.selectedIndex]
		fields[2]= f_query_add_mod.document.DeptRoom_form.department.options[f_query_add_mod.document.DeptRoom_form.department.options.selectedIndex]

	}

	var names = new Array (getLabel("Common.facility.label",'Common'),getLabel("Common.room.label",'Common'),
										getLabel("Common.acctdept.label",'Common'));

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.DeptRoom_form.submit();
			var fn_status = f_query_add_mod.document.DeptRoom_form.function_name.value ;
			if(fn_status == "insert")  {}

	}
}

var facId="";
function onSuccess() {
if(f_query_add_mod.document.DeptRoom_form.function_name.value =="insert")
	{
/////////////////Added by Manish Anand on 01-07-2002///////////////
	
	facId = f_query_add_mod.document.DeptRoom_form.facility.value;
	f_query_add_mod.location.href = "../../eAM/jsp/addmodifyDeptforroom.jsp?facilityId="+facId
///////////////////////////////////////////////////////////////////
	/*f_query_add_mod.document.DeptRoom_form.room.options[0].selected	=true ;
	f_query_add_mod.document.DeptRoom_form.department.options[0].selected	=true ;
	f_query_add_mod.document.DeptRoom_form.service.options[0].selected	=true ;*/
	}
	else
	f_query_add_mod.location.reload();
}

function reset() 
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(f_query_add_mod.document.forms[0].name == "DeptRoom_form")
	{
		if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
		{
			//if(f_query_add_mod.document.forms[0])
			f_query_add_mod.location.reload();
		}
		else
		{
			//f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.location.reload();
		}
	}
	if(f_query_add_mod.document.forms[0].name == "query_form")
		{f_query_add_mod.document.location.reload(); ;}
	//	{f_query_add_mod.document.query_form.reset() ;}
}
function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

//	alert("length:-"+length);

var element = f_query_add_mod.document.DeptRoom_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";
   

	
        for(i=1;i<length;i++)
            object.remove(1);
   

}
