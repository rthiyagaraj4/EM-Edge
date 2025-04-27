/**
 *	FileName	: Department.js
 *	Version	    : 3	
 *	Modified On	: 19-2-2005
 */



var prefix_facility_yn = new Array ();
var dept_code_length = new Array ();

var i = 1;
function change()
{
 if (Department_form.eff_status.checked == true)
	Department_form.eff_status.value="E";
 else
	Department_form.eff_status.value="D";
}

function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyDepartment.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/DepartmentqueryCriteria.jsp";
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

function apply() {
	
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (f_query_add_mod.document.Department_form.acc_entity,
							f_query_add_mod.document.Department_form.dept_code,
							f_query_add_mod.document.Department_form.long_desc,
							f_query_add_mod.document.Department_form.short_desc

				    );

	var names = new Array ( getLabel("Common.AccountingEntity.label","Common")
							,getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common")
					      );



//////////Added by Manish Anand on 30-06-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.Department_form.dept_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (f_query_add_mod.document.Department_form.function_name.value=='insert')
			{
				prefixReqd = prefix_facility_yn[f_query_add_mod.document.getElementById('acc_entity').selectedIndex];
				if (prefixReqd=="N")
				{
					f_query_add_mod.document.Department_form.submit();
					var fn_status = f_query_add_mod.document.Department_form.function_name.value ;
				}
				else
				{
					if (f_query_add_mod.document.Department_form.dept_code.value.substring(0,2) == f_query_add_mod.document.Department_form.facilityID.value)
					{
						f_query_add_mod.document.Department_form.submit();
						var fn_status = f_query_add_mod.document.Department_form.function_name.value ;
					}
					else
					{
						var msg = f_query_add_mod.getMessage("INVALID_DEPT_CODE","AM");
						frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+'"'+f_query_add_mod.document.Department_form.facilityID.value+'"';
					}
				}
			}
			else
			{
				f_query_add_mod.document.Department_form.submit();
				var fn_status = f_query_add_mod.document.Department_form.function_name.value ;
			}

		}

}

function onSuccess() {
	if(f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.location.reload();
	}
}

function reset() {
	if(f_query_add_mod.document.forms[0]) 
	{
		f_query_add_mod.document.location.reload();
		if (f_query_add_mod.document.forms[0].acc_entity)
			if (f_query_add_mod.document.forms[0].acc_entity.type=='select-one')
				if (f_query_add_mod.document.forms[0].acc_entity.length>2)
					f_query_add_mod.document.forms[0].acc_entity.value="";
	}
}

function getPrefixFacility()
{
	if(f_query_add_mod.document.forms[0].acc_entity)
	{
	if (f_query_add_mod.document.forms[0].acc_entity.value.length!=0)
	{
		f_query_add_mod.document.forms[0].dept_code.maxLength=dept_code_length[f_query_add_mod.document.getElementById('acc_entity').selectedIndex];
		prefixReqd = prefix_facility_yn[f_query_add_mod.document.getElementById('acc_entity').selectedIndex];
		if (prefixReqd == "Y")
			if (f_query_add_mod.document.forms[0].dept_code.value == '')
				f_query_add_mod.document.forms[0].dept_code.value = f_query_add_mod.document.forms[0].facilityID.value;
	}
	}
}

