function reset()
	{
		f_query_select.document.forms[0].reset();
	}
function allowPositiveNumber() 
	{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key<48 )||(key>58)) 
			{
				return false;
			}
	}
function searchstaff()
{
	var frmobj=parent.f_query_select.document.form_StaffLicenseExpiry;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	 var role_type=frmobj.role_type.value;
	 var staff_type=frmobj.staff_type.value;
	 var staff_id=frmobj.staff_id.value;
	 var staff_name=frmobj.staff_name.value;
	 var expiring_within=frmobj.expiring_within.value;
	if(expiring_within=="")
	{
		var message=getMessage("EXPIRING_DAYS","RS");
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}
	else
	{
	
	 parent.f_query_details.location.href="../../eRS/jsp/StaffLicenseExpiryResult.jsp?role_type="+role_type+"&staff_type="+staff_type+"&staff_id="+staff_id+"&staff_name="+staff_name+"&expiring_within="+expiring_within;
	
	}
}
function ViewStaffDetails(target)
{
	
	var formObj=parent.f_query_select.document.form_StaffLicenseExpiry;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	 var role_type=formObj.role_type.value;
	 var staff_id=formObj.staff_id.value;
	 var staff_name=formObj.staff_name.value;
	 var staff_type=formObj.staff_type.value;
	var url="../../eRS/jsp/SearchStaff.jsp?p_staff_id="+staff_id+"&p_role_type="+role_type+"&p_staff_type="+staff_type+"&p_staff_name="+staff_name+"&mode=call";
	

	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var retVal   = window.showModalDialog( url, arguments, features ) ;
	if(retVal != null )  {
	target.value = retVal[0] ;
	formObj.staff_name.value = retVal[1];
	}

}
