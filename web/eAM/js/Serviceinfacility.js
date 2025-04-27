function create()
{
	frames[1].location.href="../../eAM/jsp/md_addModifyServiceinfacilityMain.jsp?facilityId="+facId;
}
function query()
{
	frames[1].location.href ="../../eAM/jsp/ServiceinfacilityQueryCriteria.jsp?function=Serviceinfacility";
}
function checkIsValidForProceed()
  {
     var url = frames[1].location.href;
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
 var msg=getMessage('NO_CHANGE_TO_SAVE','Common');	
if(f_query_add_mod_query.document.f_query_add_mod_result.document.forms[0].totalvalues.value.length ==0)
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	else
	{
		f_query_add_mod_query.document.f_query_add_mod_result.document.forms[0].action='../../servlet/eAM.ServiceinfacilityServlet'
		f_query_add_mod_query.document.f_query_add_mod_result.document.forms[0].method='post';
		f_query_add_mod_query.document.f_query_add_mod_result.document.forms[0].target='messageFrame';
		f_query_add_mod_query.document.f_query_add_mod_result.document.forms[0].submit();
	}
}

var facId='';
function onSuccess()
{
	facId=f_query_add_mod_query.document.f_query_add_mod_query.document.forms[0].operating_facility_id.value
	frames[1].location.href="../../eAM/jsp/md_addModifyServiceinfacilityMain.jsp?facilityId="+facId;
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

	if(parent.frames[2].document.f_query_add_mod_query.document.forms[0])
	parent.frames[2].document.f_query_add_mod_query.document.location.reload();
	//parent.frames[2].document.frames[1].document.forms[0].reset();
	else if(parent.frames[2].document.f_query_add_mod_query.document.f_query_add_mod_result)
		//parent.frames[2].document.frames[1].location.reload();
			f_query_add_mod_query.location.reload();
	

}

function PopulateList()
{
	var selected = serviceinfacilityQuery_form.dept_code;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opfacilityid = serviceinfacilityQuery_form.operating_facility_id.value;
	if (opfacilityid != null && opfacilityid != "")
	{
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/md_ServiceinfacilityDeptPopulate.jsp'><input type='hidden' name='operating_facility_id' id='operating_facility_id' value='"+opfacilityid+"'></form></body></html>";
		parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.frames[3].document.querydept.submit();
	}
	else
	{
		var opt=parent.frames[0].document.createElement("Option");
		opt.text="   ----- "+getLabel("Common.defaultSelect.label","Common")+" -----   "
		opt.value="";
		parent.frames[0].document.getElementById('dept_code').add(opt);
	}
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

function chkMandatory()
{
	var facility_id=serviceinfacilityQuery_form.operating_facility_id.value;
	var dept_code=serviceinfacilityQuery_form.dept_code.value;
		
var fields = new Array (serviceinfacilityQuery_form.operating_facility_id,
						serviceinfacilityQuery_form.dept_code
					    );
	var names = new Array (
						getLabel("Common.facility.label","Common")
,getLabel("Common.acctdept.label","Common")

					      );

		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}

var temp='';
function changeValue(Obj,Obj1,Obj3)
{
var arr = new Array();
arr = Obj.value.split("$");
	if(Obj1.checked)
	{
		arr[1]="E";
	}
	else
		arr[1]="D";
	
	Obj.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+Obj1.name+"~"
	temp+=Obj.value;
	Obj3.value =temp;
}

	


