var isCreate="false";
var isQuery="false";
var isApply="false";
var position_code="";
var position_desc="";
var grade_code="";
var grade_short_desc="";
var role_type="";
var staff_type="";
var position_expl_text="";
var eff_status="";
var operation_fun="";
var operation="";

function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyPosition.jsp?mode=1" ;
	isCreate="true";
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/PositionQueryCriteria.jsp?function=service";
	isQuery="true";
	isCreate="false";
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

//	var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var frmobj=f_query_add_mod.document.form_AddModifyPosition ;
	var operation=frmobj.operation_type.value;
	//alert(f_query_add_mod.document.form_AddModifyPosition.position_expl_text.value.length);
		
	if(operation=="insert")
		{
		
			operation_fun = "insert";
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			var fields = new Array (frmobj.position_code,
				                frmobj.position_desc,frmobj.role_type
							);
			    
			var names = new Array (	getLabel("Common.code.label","Common"),
									getLabel("Common.description.label","Common"),
									getLabel("Common.RoleType.label","Common"));
			
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
			if((f_query_add_mod.document.form_AddModifyPosition.position_expl_text.value.length) >4000)
			{				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-002428 Explanatory Text cannot exceed 4000 characters" ;
			} else
				frmobj.submit();
			}		
	}
	else
	{
		operation_fun = "modify";
		
	 position_code=f_query_add_mod.document.form_AddModifyPosition.position_code.value;
	 position_desc=f_query_add_mod.document.form_AddModifyPosition.position_desc.value;	
	 role_type=f_query_add_mod.document.form_AddModifyPosition.role_type.value;
	 
	 staff_type=f_query_add_mod.document.form_AddModifyPosition.staff_type.value;
	 position_expl_text=encodeURIComponent(f_query_add_mod.document.form_AddModifyPosition.position_expl_text.value);
	 eff_status=f_query_add_mod.document.form_AddModifyPosition.eff_status.value;
		var fields = new Array (frmobj.position_code,
				                frmobj.position_desc,frmobj.role_type
							);
			    
		var names = new Array (getLabel("Common.code.label","Common"),
									getLabel("Common.description.label","Common"),
									getLabel("Common.RoleType.label","Common"));
				 
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{		
			// role_type="E";
			//alert("VISIBLE"+ f_query_add_mod.document.form_AddModifyPosition.role_type.disabled);
			 f_query_add_mod.document.form_AddModifyPosition.role_type.disabled=false;
			 f_query_add_mod.document.form_AddModifyPosition.staff_type.disabled=false;
			 f_query_add_mod.document.form_AddModifyPosition.grade_code.disabled=false;
			 if((f_query_add_mod.document.form_AddModifyPosition.position_expl_text.value.length) >4000)
			{				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-002428 Explanatory Text cannot exceed 4000 characters" ;
			} else
			f_query_add_mod.document.form_AddModifyPosition.submit();
		}
	
	}
	isApply="true";
}
function reset()

	{
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.location.reload();
	}	


	function checkActive(target)
{

	if(target.checked == false)
	{
		target.value = "D";
		target.checked = false;
	}
	else
	{
		target.value = "E";
		target.checked = true;
	}

}

function onSuccess() 
{
	 
	if (operation_fun=="insert")
		{
			
			f_query_add_mod.location.href="../../eAM/jsp/addModifyPosition.jsp?mode=1";

		}
	else
		{
		 grade_code=f_query_add_mod.document.form_AddModifyPosition.grade_code.value;
		 grade_short_desc=f_query_add_mod.document.form_AddModifyPosition.grade_short_desc.value;
			
			//f_query_add_mod.location.href = "../../eAM/jsp/addModifyPosition.jsp?mode=2&position_code="+position_code+"&position_desc="+position_desc+"&role_type="+role_type+"&staff_type="+staff_type+"&position_expl_text="+position_expl_text+"&eff_status="+eff_status+"&grade_short_desc="+grade_short_desc+"&grade_code="+grade_code;
			f_query_add_mod.location.href = "../../eAM/jsp/addModifyPosition.jsp?mode=2&position_code="+position_code+"&position_desc="+position_desc+"&role_type="+role_type+"&staff_type="+staff_type+"&eff_status="+eff_status+"&grade_short_desc="+grade_short_desc+"&grade_code="+grade_code;
		}
}
			
