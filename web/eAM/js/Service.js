/**
 *		FileName	: Service.js
 *		Version	    : 3	
 *		Modified On	: 17-2-2005
 *
 */

//AM_Service_Setup
var temparr = new Array();
			var count = 0;
			var prev=0;
			var prevcol='MENUSUBLEVELCOLOR';
			var sec_hdg_cd=new Array();
			var logic_seq_no=new Array();


//Function to display the create page in Service Setup
function create() 
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyService.jsp" ;
}

//Function to edit
function edit() 
{
	parent.formToolbarFrame.location.href = "formToolbar.html" ;
}

//Function to query the Service Setup
function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/ServiceQueryCriteria.jsp?function=service";
	return true;
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
//Function for transaction in Service Setup
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
    var fields = new Array (f_query_add_mod.document.service_form.service_code,
							f_query_add_mod.document.service_form.long_desc,
							f_query_add_mod.document.service_form.short_desc
						   );
	var names = new Array ( getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common")
					      );

	var spFields = new Array (f_query_add_mod.document.service_form.service_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			f_query_add_mod.document.service_form.submit();

		}
	}


//Function onSuccess
function onSuccess() 
{
	 if(f_query_add_mod.document.service_form.function_name.value == "insert")
	  {
		f_query_add_mod.document.service_form.service_code.value	= "" ;
		f_query_add_mod.document.service_form.short_desc.value		= "" ;
		f_query_add_mod.document.service_form.long_desc.value		= "" ;
		f_query_add_mod.document.service_form.medical_yn1.checked =false;
		f_query_add_mod.document.service_form.ancillary_yn1.checked =false;
		f_query_add_mod.document.service_form.eff_status.checked	= true ;

	//Added by Manish Anand on 30-06-2002
		f_query_add_mod.document.service_form.service_code.select();
		 }
	else
		if(f_query_add_mod.document.service_form.function_name.value == "modify")
			f_query_add_mod.document.location.reload();
}

//Function to reset the widgets
function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();
}




//Function to return to the home page
function goHomePage()
{
		parent.location.href='../../eCommon/jsp/dmenu.jsp';
}

//
function chcol(ro)
{
		document.getElementById('t').rows(prev).cells(0).className=prevcol;
		prevcol=ro.cells(0).className;
		ro.cells(0).className="MENUSELECTEDCOLOR";
		prev=ro.rowIndex;
}

//Function to display menu options
function callJSPs(val)
{
	
	if(val == 'Service')
		parent.frames[1].location.href = '../../eAM/jsp/Service.jsp?module_id=AM&function_id=SERVICE&function_name='+encodeURIComponent(getLabel("Common.service.label","Common"))+'&function_type=F&access=YYYNN';
	if(val == 'SubService')
	parent.frames[1].location.href = '../../eAM/jsp/Subservice.jsp?module_id=AM&function_id=SUBSERVICE&function_name='+encodeURIComponent(getLabel("Common.subservice.label","Common"))+'&function_type=F&access=YYYNN';
	if(val == 'Department')
		parent.frames[1].location.href = '../../eAM/jsp/Department.jsp?module_id=AM&function_id=DEPARTMENT&function_name='+encodeURIComponent(getLabel("eAM.AccountingDepartmentCostCenter.label","am"))+'&function_type=F&access=YYYNN';
	if(val == 'Section')
		parent.frames[1].location.href = '../../eAM/jsp/Section.jsp?module_id=AM&function_id=SECTION&function_name='+encodeURIComponent(getLabel("Common.Section.label","Common"))+'&function_type=F&access=YYYNN';
	if(val == 'DepartmentinFacility')
		parent.frames[1].location.href = '../../eAM/jsp/FacilityDept.jsp?module_id=AM&function_id=FACILITY_DEPT&function_name='+encodeURIComponent(getLabel("eAM.FacilityforAcctDept.label","am"))+'&function_type=F&access=YYYNN';
	if(val == 'SectioninFacility')
		parent.frames[1].location.href = '../../eAM/jsp/FacilitySection.jsp?module_id=AM&function_id=FACILITY_SECTION&function_name='+encodeURIComponent(getLabel("eAM.SectioninFacility.label","am"))+'&function_type=F&access=YYYNN';
	if(val == 'ServiceinFacility')
		parent.frames[1].location.href = '../../eAM/jsp/md_ServiceinFacility.jsp?module_id=AM&function_id=FACILITY_SERVICE&function_name='+encodeURIComponent(getLabel("eAM.ServiceinFacility.label","am"))+'&function_type=F&access=YYYNN';
	if(val == 'Sub-ServiceinFacility')
		parent.frames[1].location.href = '../../eAM/jsp/SubServiceinFacility.jsp?module_id=AM&function_id=SUBSERVICE_IN_FACILITY&function_name='+encodeURIComponent(getLabel("eAM.SubServiceinFacility.label","am"))+'&function_type=F&access=YYYNN';
}
