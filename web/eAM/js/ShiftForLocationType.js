//parent.frames[1].frames[1]... is changed as parent.frames[2].frames[1]....

var show_list = false;
var message = "";
var show_facility = false;
var show_shift = false;

function create() 
{
	f_query.location.href = "../../eAM/jsp/ShiftForLocationTypeFrameset.jsp?mode=1";
	
}
function edit() 
{
}
function query() 
{
	
	f_query.location.href ="../../eAM/jsp/ShiftForLocationTypeQueryCriteria.jsp?function=service";
}
function checkIsValidForProceed()
  {
     var url = f_query.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply() 
{
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	var frmObj = f_query.f_query_add_mod_list.document.frm_list;
    var curr_val="";
    var change_insert="";
if(frmObj)
{	
	var operation = frmObj.operation.value;
	var noOfRecords = frmObj.noOfRecords.value;
	for(i=0; i<=noOfRecords; i++) {
	    var prev_select = eval("frmObj.prev_select" + i).value;
	    if(eval("frmObj.select" + i).checked == true) {
	        eval("frmObj.select" + i).value = "E";
	        curr_val = "checked";
	        if(curr_val != prev_select)
	            change_insert = "true";
	    } else {
	        eval("frmObj.select" + i).value = "D";
	        curr_val = "";
	        if(curr_val != prev_select)
	            change_insert = "true";
	    }
	}

	var i;
	if(operation == 'showshifts')
	{
		   if(change_insert!="true")
		  { 
			        var message=getMessage('NO_CHANGE_TO_SAVE','common');
					 frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		  }
		  else
			frmObj.submit();
				
	}
	else
	{
		 if(change_insert!="true")
		  { 
			        var message=getMessage('NO_CHANGE_TO_SAVE','common');
					 frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		  }
		  else
			frmObj.submit();
	}
}
else
	{
	//  var message="APP-AM0029 Apply is not a valid operation here";
	 var message=getMessage("AM0100","AM");
	  frames[2].location.href  = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	
}
function onSuccess() 
{
	
parent.frames[2].frames[1].frames[2].location.href="../../eCommon/html/blank.html";
if(parent.frames[2].frames[1].frames[1].document.forms[0].name=="frm_shift_by_shift")
{
		parent.frames[2].frames[1].frames[1].document.forms[0].shift_code.value="" ;
		parent.frames[2].frames[1].frames[1].document.forms[0].shift_indicator.value="" ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_nonworking_days.value="" ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_holidays.value=""  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_working_days.value=""  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].durn_hh.value=""  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].durn_mm.value=""  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].locn_type.value=""  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].shift_indicator.readonly=true ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_nonworking_days.readonly=true ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_holidays.readonly=true  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_working_days.readonly=true ;
		parent.frames[2].frames[1].frames[1].document.forms[0].durn_hh.readonly=true ;
		parent.frames[2].frames[1].frames[1].document.forms[0].durn_mm.readonly=true ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_nonworking_days.checked=false ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_holidays.checked=false  ;
		parent.frames[2].frames[1].frames[1].document.forms[0].appl_for_working_days.checked=false ;
}else
	{
		parent.frames[2].frames[1].frames[1].document.forms[0].reset();
	}
}
function reset() 
{
	
	//if(f_query.document.forms[0])
		   f_query.document.location.reload();
}


function showFacility()
{
	parent.f_query_add_mod_select.location.href="../../eAM/jsp/ShiftForLocationByFacility.jsp";
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_facility = true;
	show_shift = false;
	message = "";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
function showShift()
{
	parent.f_query_add_mod_select.location.href="../../eAM/jsp/ShiftForLocationByShift.jsp";
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_facility = false;
	show_shift = true;
	message = "";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
function selectShift(target)
{
	var frmObj = parent.f_query_add_mod_select.frm_shift_by_shift;
	var shift_code = target.value;
	var locn_type = frmObj.locn_type.value;
	parent.f_query_add_mod_select.location.href="../../eAM/jsp/ShiftForLocationByShift.jsp?shift_code="+shift_code+"&locn_type="+locn_type;
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_facility = false;
	show_shift = true;
}
function showShiftsList()
{
	var msg11="";
        parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg11;
	var fields = new Array (document.frm_shift_by_facility.locn_type, document.frm_shift_by_facility.facility);

	var names = new Array (getLabel("Common.locationtype.label","Common")
 , getLabel("Common.facility.label","Common")
 );	

	if(parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
		{	
			var locn_type = document.frm_shift_by_facility.locn_type.value;
			var facility = document.frm_shift_by_facility.facility.value;
			message = "";
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				parent.f_query_add_mod_list.location.href="../../eAM/jsp/ShiftForLocationShowShifts.jsp?locn_type="+locn_type+"&facility="+facility;

			show_list = true;
		}
}
function showFacilitiesList()
{
	var msg11="";
        parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg11;
	var fields = new Array (document.frm_shift_by_shift.shift_code, document.frm_shift_by_shift.locn_type);

	var names = new Array ( getLabel("Common.SHIFT.label","Common")
 , getLabel("Common.locationtype.label","Common")
 );	
	if(parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
		{

		var shift_code = document.frm_shift_by_shift.shift_code.value;
		var shift_indicator = document.frm_shift_by_shift.shift_indicator.value;
		var appl_for_working_days = document.frm_shift_by_shift.appl_for_working_days.value;
		var appl_for_nonworking_days = document.frm_shift_by_shift.appl_for_nonworking_days.value;
		var appl_for_holidays = document.frm_shift_by_shift.appl_for_holidays.value;
		var durn_hh = document.frm_shift_by_shift.durn_hh.value;
		var durn_mm = document.frm_shift_by_shift.durn_mm.value;
		var locn_type = document.frm_shift_by_shift.locn_type.value;

		message = "";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	
	parent.f_query_add_mod_list.location.href="../../eAM/jsp/ShiftForLocationShowFacilities.jsp?shift_code="+shift_code+"&shift_indicator="+shift_indicator+"&appl_for_working_days="+appl_for_working_days+"&appl_for_nonworking_days"+appl_for_nonworking_days+"&appl_for_holidays="+appl_for_holidays+"&durn_hh="+durn_hh+"&durn_mm="+durn_mm+"&locn_type="+locn_type;

		show_list = true;
		}
}
function checkActiveApplicable(target)
{
	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}
}

function checkActive(target)
{
	var nameStr = 'db_action';
	var frmObj = f_query_add_mod_list.document.frm_list;
	var name = target.name;
	var len = name.length;
	var index = name.substr(nameStr.length,len);
	if(target.checked == false)
	{
		//target.value = "I";
		eval("frmObj.curr_db_action"+index).value = "I";
		target.checked = false;
	}
	else
	{
		//target.value = "U";
		eval("frmObj.curr_db_action"+index).value = "U";
		target.checked = true;
	}
}


function locationval()
{

	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";

}
function facilityval()
{

	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
}
function locationtypeval()
{
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
}
