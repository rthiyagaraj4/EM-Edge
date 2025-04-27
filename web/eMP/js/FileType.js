function create()
{
	f_query_add_mod.location.href = "../../eMP/jsp/addModifyFileType.jsp?&source=Insert" ;
}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eMP/jsp/FileTypeQueryCriteria.jsp?function=FileType";
}

function apply()
{
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	var fields = new Array ( f_query_add_mod.document.filetype_form.facility_id,		 
				 f_query_add_mod.document.filetype_form.file_type_code,
				 f_query_add_mod.document.filetype_form.file_type_long_desc,
				 f_query_add_mod.document.filetype_form.file_type_short_desc
				);

	var names = new Array ( getLabel("Common.facility.label","Common"),
				getLabel('Common.filetype.label','common')+" "+ getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common')
				);
	var specialCharfields = new Array (f_query_add_mod.document.filetype_form.file_type_code);
	 var specialChars = new Array ( getLabel('Common.filetype.label','common')+" "+ getLabel('Common.code.label','common'));
	if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{ 	
		f_query_add_mod.document.forms[0].outpatient_chk.disabled = false;
		f_query_add_mod.document.forms[0].inpatient_chk.disabled = false;
		f_query_add_mod.document.forms[0].daycare_chk.disabled = false;
		f_query_add_mod.document.forms[0].emergency_chk.disabled = false;
		f_query_add_mod.document.filetype_form.submit();
	}
	}
}

function chkEnabled(Obj)
{
    var facility_id=	document.forms[0].facility_id.value;
    var file_type_code=	document.forms[0].file_type_code.value;
	var from_where='File_type';	
	if (Obj.checked == true)
	{
		document.forms[0].eff_status.value = 'E';	
	}
	else
	{//Modifed by S.Sathish for SRR20056-SCF-4443 on Friday, May 07, 2010 starts here
		document.forms[0].eff_status.value = 'D';		
		if(document.forms[0].function_name.value == 'modify'){
			var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name=DummyLocation method=post action='../../eMP/jsp/GetCreateFileComponentValues.jsp?fac_id="+facility_id+"&file_type_code="+file_type_code+"&from_where="+from_where+"'> </form></body></html>";
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[2].document.forms[0].submit();		
		}
	//Ends here
	}
}

function chkUnchk(Obj)
{
	if(Obj.name == 'outpatient_chk')
	{
		if(Obj.checked == true)
			document.forms[0].outpatient_chk.value = 'Y';
		else if(Obj.checked == false)
			document.forms[0].outpatient_chk.value = 'N';
	}
	if(Obj.name == 'inpatient_chk')
	{
		if(Obj.checked == true)
			document.forms[0].inpatient_chk.value = 'Y';
		else if(Obj.checked == false)
			document.forms[0].inpatient_chk.value = 'N';
	}
	if(Obj.name == 'daycare_chk')
	{
		if(Obj.checked == true)
			document.forms[0].daycare_chk.value = 'Y';
		else if(Obj.checked == false)
			document.forms[0].daycare_chk.value = 'N';
	}
	if(Obj.name == 'emergency_chk')
	{
		if(Obj.checked == true)
			document.forms[0].emergency_chk.value = 'Y';
		else if(Obj.checked == false)
			document.forms[0].emergency_chk.value = 'N';
	}
}
function onSuccess()
{
    if(f_query_add_mod.document.forms[0])
    {

	f_query_add_mod.location.reload();

    }
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;

}
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

