 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyfloorinfacility.jsp" ;
}

/*function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}*/

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/floorinfacilityQueryCriteria.jsp?function=floorcode" ;
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
	var fields = new Array ( f_query_add_mod.document.floor_form.facility,
				f_query_add_mod.document.floor_form.bldng_code,
				 f_query_add_mod.document.floor_form.floor_code,
				 f_query_add_mod.document.floor_form.long_desc,
				 f_query_add_mod.document.floor_form.short_desc
			       );

	var names = new Array (getLabel("Common.facility.label",'Common'),
		getLabel("Common.building.label",'Common'),
	            getLabel("Common.FloorCode.label",'Common'),
				getLabel("Common.longdescription.label",'Common'),
				getLabel("Common.shortdescription.label",'Common'));

//////////Added by Manish Anand on 01-07-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.floor_form.floor_code);
	var spNames = new Array ("Floor Code");
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.floor_form.submit();
			var fn_status = f_query_add_mod.document.floor_form.function_name.value ;
			if(fn_status == "insert")  {}

	}
}

var facID='';
function onSuccess() {


	//facID=f_query_add_mod.document.forms[0].facility.value;
	//f_query_add_mod.location.href = "../../eAM/jsp/addModifyfloorinfacility.jsp?operating_facility_id="+facID ;
	if(f_query_add_mod.document.floor_form.function_name.value =="insert")
	{
	f_query_add_mod.document.forms[0].bldng_code.value="";
	f_query_add_mod.document.forms[0].floor_code.value="";
	f_query_add_mod.document.forms[0].long_desc.value="";
	f_query_add_mod.document.forms[0].short_desc.value="";
	}else
	{
		f_query_add_mod.location.reload();
	}
	

	//var err= getMessage("RECORD_INSERTED","SM");
	//parent.frames[1].frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
}

function reset()
{

//f_query_add_mod.location.reload();
	if(f_query_add_mod.document.forms[0])
	{
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();

	}

}
