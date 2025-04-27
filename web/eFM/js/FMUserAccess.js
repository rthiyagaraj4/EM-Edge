function create()
{
	frames[1].location.href = '../../eFM/jsp/FMUserAccessAddMod.jsp?operation=insert';
	frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function query()
{
	frames[1].location.href = '../../eFM/jsp/FMUserAccessQueryCriteria.jsp?';
	frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';

}

function checkIsValidForProceed()
{
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("accessquery")==-1) )
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
	var check_select =0;
	for(i=0;i<f_query_add_mod.document.fm_user_access_form.elements.length;i++)
	{
		if(	f_query_add_mod.document.fm_user_access_form.elements[i].type=="checkbox" && f_query_add_mod.document.fm_user_access_form.elements[i].name !="access_all")
		{
			if(f_query_add_mod.document.fm_user_access_form.elements[i].checked==true)
				check_select=check_select+1;
		}
	}	
	if( f_query_add_mod.document.fm_user_access_form.access_all.checked==false)
	{
		var fields = new Array ( f_query_add_mod.document.fm_user_access_form.user1,
				f_query_add_mod.document.fm_user_access_form.storage_location);
		var names = new Array ( getLabel("Common.user.label","common"), getLabel('eFM.FSLocation.label','FM') );
	}
	else
	{
		var fields = new Array (f_query_add_mod.document.fm_user_access_form.user1);
		var names = new Array ( getLabel("Common.user.label","common") );
	}
	var all_locn =f_query_add_mod.document.fm_user_access_form.all_fs_locn_codes.value;
	if (f_query_add_mod.document.fm_user_access_form.access_all.checked==true || f_query_add_mod.document.fm_user_access_form.storage_location.value=='*ALL')
	{
		if(f_query_add_mod.document.fm_user_access_form.locn_identity.value !="AID")
		{	
			if(all_locn=="" || all_locn==null)
			{	
				check_select=0;
				var msg =getMessage("FS_LOCN_NOT_DEFN","FM");
				frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
			}else
		{
		check_select=check_select+1;
		}

	}else 
		{
		check_select=check_select+1;
		}
	}	

	if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame))
	{
		if(check_select > 0)
		{			
			f_query_add_mod.document.forms[0].assign_fs_locn.disabled=false;
			f_query_add_mod.document.forms[0].change_fs_locn.disabled=false;
			f_query_add_mod.document.forms[0].change_return_date_yn.disabled=false;
			f_query_add_mod.document.forms[0].deficiency_check_yn.disabled=false;
			f_query_add_mod.document.forms[0].track_out_to_opd_yn.disabled=false;
			f_query_add_mod.document.forms[0].track_out_to_ipw_yn.disabled=false;
			f_query_add_mod.document.forms[0].receive_file_yn.disabled=false;
			f_query_add_mod.document.forms[0].confirm_receipt_yn.disabled=false;
			f_query_add_mod.document.forms[0].return_file_yn.disabled=false;
			f_query_add_mod.document.forms[0].transfer_file_yn.disabled=false;
			f_query_add_mod.document.forms[0].file_lost_found_yn.disabled=false;
			f_query_add_mod.document.forms[0].req_yn.disabled=false;
			f_query_add_mod.document.forms[0].req_across_facilities_yn.disabled=false;
			f_query_add_mod.document.forms[0].manual_request_yn.disabled=false;
			f_query_add_mod.document.forms[0].cancel_request_yn.disabled=false;
			f_query_add_mod.document.forms[0].iss_yn.disabled=false;
			f_query_add_mod.document.forms[0].iss_across_facilities_yn.disabled=false;
			f_query_add_mod.document.forms[0].CREATE_FILE_VOLUME_YN.disabled=false;

			frames[1].document.forms[0].submit();

		}
		else
		{
			if(all_locn=="" || all_locn==null)
			{	
			var msg =getMessage("FS_LOCN_NOT_DEFN","FM");
			}else
			{
			var msg =getMessage("ATLEAST_ONE_RIGHTS","FM");
			}
			frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		}

	}
}

function reset()
{
	   if(f_query_add_mod.document.location.href.indexOf("FMUserAccessQueryResult.jsp") != -1)
			return false;
	   else {	

			if(f_query_add_mod.document.forms[0].name == "fm_user_access_form")
			{
				if(f_query_add_mod.document.fm_user_access_form.mode.value =="insert")
				{
					f_query_add_mod.document.forms[0].reset();
					f_query_add_mod.document.forms[0].storage_location.disabled=false;
					f_query_add_mod.document.forms[0].storage_location.value="";

					f_query_add_mod.document.forms[0].assign_fs_locn.checked=false;
					f_query_add_mod.document.forms[0].assign_fs_locn.disabled=false;

					f_query_add_mod.document.forms[0].change_fs_locn.checked=false;
					f_query_add_mod.document.forms[0].change_fs_locn.disabled=false;

					f_query_add_mod.document.forms[0].change_return_date_yn.checked=false;
					f_query_add_mod.document.forms[0].change_return_date_yn.disabled=false;

					f_query_add_mod.document.forms[0].deficiency_check_yn.checked=false;
					f_query_add_mod.document.forms[0].deficiency_check_yn.disabled=false;

					f_query_add_mod.document.forms[0].file_lost_found_yn.checked=false;
					f_query_add_mod.document.forms[0].file_lost_found_yn.disabled=false;

					f_query_add_mod.document.forms[0].track_out_to_opd_yn.checked=false;
					f_query_add_mod.document.forms[0].track_out_to_opd_yn.disabled=false;
				    f_query_add_mod.document.forms[0].track_out_to_ipw_yn.checked=false;
					f_query_add_mod.document.forms[0].track_out_to_ipw_yn.disabled=false;
					
					f_query_add_mod.document.forms[0].receive_file_yn.checked=false;
					f_query_add_mod.document.forms[0].receive_file_yn.disabled=false;

					f_query_add_mod.document.forms[0].return_file_yn.checked=false;
					f_query_add_mod.document.forms[0].return_file_yn.disabled=false;

					f_query_add_mod.document.forms[0].confirm_receipt_yn.checked=false;
					f_query_add_mod.document.forms[0].confirm_receipt_yn.disabled=false;

					f_query_add_mod.document.forms[0].transfer_file_yn.checked=false;
					f_query_add_mod.document.forms[0].transfer_file_yn.disabled=false;

					f_query_add_mod.document.forms[0].req_yn.checked=false;
					f_query_add_mod.document.forms[0].req_yn.disabled=false;

					f_query_add_mod.document.forms[0].req_across_facilities_yn.checked=false;
					f_query_add_mod.document.forms[0].req_across_facilities_yn.disabled=false;

					f_query_add_mod.document.forms[0].manual_request_yn.checked=false;
					f_query_add_mod.document.forms[0].manual_request_yn.disabled=false;

					f_query_add_mod.document.forms[0].cancel_request_yn.checked=false;
					f_query_add_mod.document.forms[0].cancel_request_yn.disabled=false;

					f_query_add_mod.document.forms[0].iss_yn.checked=false;
					f_query_add_mod.document.forms[0].iss_yn.disabled=false;

					f_query_add_mod.document.forms[0].iss_across_facilities_yn.checked=false;
					f_query_add_mod.document.forms[0].iss_across_facilities_yn.disabled=false;

					f_query_add_mod.document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
					f_query_add_mod.document.forms[0].CREATE_FILE_VOLUME_YN.disabled=false;

					
				}
				else
					
				f_query_add_mod.document.forms[0].reset();
			}

			if(f_query_add_mod.document.forms[0].name == "query_form")
			{
				f_query_add_mod.document.query_form.reset() ;
	}
	   }
}

function populate(obj)
{
var storage_location =obj.value;
var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/GetLocIdentity.jsp?storage_location="+storage_location+"'></form></body></html>" ;

	parent.frames[2].document.write(HTMLVal) ;
	parent.frames[2].document.GetLocIdentity.submit() ;

}

function checkbox_all_locn(obj)
{
	if (obj.checked == true)
	{
		obj.value='Y';
		document.fm_user_access_form.storage_location.options[0].selected=true;
		document.fm_user_access_form.storage_location.disabled=true;		
		document.fm_user_access_form.str_loc_img.style.visibility='hidden';		

		parent.frames[1].document.forms[0].assign_fs_locn.checked=false;
		parent.frames[1].document.forms[0].assign_fs_locn.disabled=true;

		parent.frames[1].document.forms[0].change_fs_locn.checked=false;
		parent.frames[1].document.forms[0].change_fs_locn.disabled=true;

		parent.frames[1].document.forms[0].change_return_date_yn.checked=false;
		parent.frames[1].document.forms[0].change_return_date_yn.disabled=true;

		parent.frames[1].document.forms[0].deficiency_check_yn.checked=false;
		parent.frames[1].document.forms[0].deficiency_check_yn.disabled=true;

		parent.frames[1].document.forms[0].file_lost_found_yn.checked=false;
		parent.frames[1].document.forms[0].file_lost_found_yn.disabled=true;

		parent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;
		parent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=true;
       
	   parent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;
		parent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=true;
		
		parent.frames[1].document.forms[0].receive_file_yn.checked=false;
		parent.frames[1].document.forms[0].receive_file_yn.disabled=true;

		parent.frames[1].document.forms[0].return_file_yn.checked=false;
		parent.frames[1].document.forms[0].return_file_yn.disabled=true;

		parent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;
		parent.frames[1].document.forms[0].confirm_receipt_yn.disabled=true;

		parent.frames[1].document.forms[0].transfer_file_yn.checked=false;
		parent.frames[1].document.forms[0].transfer_file_yn.disabled=true;
       parent.frames[1].document.forms[0].transfer_file_yn.value='Y';
		parent.frames[1].document.forms[0].req_yn.checked=false;
		parent.frames[1].document.forms[0].req_yn.disabled=true;

		parent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;
		parent.frames[1].document.forms[0].req_across_facilities_yn.disabled=true;
		
		parent.frames[1].document.forms[0].manual_request_yn.checked=false;
		parent.frames[1].document.forms[0].manual_request_yn.disabled=true;

		parent.frames[1].document.forms[0].cancel_request_yn.checked=false;
		parent.frames[1].document.forms[0].cancel_request_yn.disabled=true;

		parent.frames[1].document.forms[0].iss_yn.checked=false;
		parent.frames[1].document.forms[0].iss_yn.disabled=true;

		parent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;
		parent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=true;

		parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
		parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=true;


	}
	else
	{
		obj.value='N';
		document.fm_user_access_form.storage_location.disabled=false;
		document.fm_user_access_form.str_loc_img.style.visibility='visible';

		parent.frames[1].document.forms[0].assign_fs_locn.checked=false;
		parent.frames[1].document.forms[0].assign_fs_locn.disabled=false;

		parent.frames[1].document.forms[0].change_fs_locn.checked=false;
		parent.frames[1].document.forms[0].change_fs_locn.disabled=false;

		parent.frames[1].document.forms[0].change_return_date_yn.checked=false;
		parent.frames[1].document.forms[0].change_return_date_yn.disabled=false;

		parent.frames[1].document.forms[0].deficiency_check_yn.checked=false;
		parent.frames[1].document.forms[0].deficiency_check_yn.disabled=false;

		parent.frames[1].document.forms[0].file_lost_found_yn.checked=false;
		parent.frames[1].document.forms[0].file_lost_found_yn.disabled=false;

		parent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;
		parent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=false;
      
	    parent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;
		parent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=false;
		
		parent.frames[1].document.forms[0].receive_file_yn.checked=false;
		parent.frames[1].document.forms[0].receive_file_yn.disabled=false;

		parent.frames[1].document.forms[0].return_file_yn.checked=false;
		parent.frames[1].document.forms[0].return_file_yn.disabled=false;

		parent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;
		parent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;

		parent.frames[1].document.forms[0].transfer_file_yn.checked=false;
		parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;

		parent.frames[1].document.forms[0].req_yn.checked=false;
		parent.frames[1].document.forms[0].req_yn.disabled=false;

		parent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;
		parent.frames[1].document.forms[0].req_across_facilities_yn.disabled=false;
		
		parent.frames[1].document.forms[0].manual_request_yn.checked=false;
		parent.frames[1].document.forms[0].manual_request_yn.disabled=false;

		parent.frames[1].document.forms[0].cancel_request_yn.checked=false;
		parent.frames[1].document.forms[0].cancel_request_yn.disabled=false;

		parent.frames[1].document.forms[0].iss_yn.checked=false;
		parent.frames[1].document.forms[0].iss_yn.disabled=false;

		parent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;
		parent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=false;

		parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
		parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=false;
	}

}

function deleterecord()
{
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("accessquery")==-1) )
	{
		if (f_query_add_mod.document.fm_user_access_form.mode.value!= 'insert')
		{
			f_query_add_mod.document.fm_user_access_form.mode.value='delete';
			if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","common")))
			{
				f_query_add_mod.document.fm_user_access_form.submit();
				f_query_add_mod.location.href="../../eCommon/html/blank.html";
				return true;
			}
			else
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
		}
		else
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		}
	}
	else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
        //commontoolbarFrame.location.reload();
		//return false;
	}
}

function PopulateIdentity(obj)
{
	if (obj.value.length>0)
	{
		var storage_location =obj.value;
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='fm_user_access_form' id='fm_user_access_form' method='post' action='../../eFM/jsp/FMUserAccessPopup.jsp?storage_location="+storage_location+"'></form></body></html>" ;

		parent.frames[0].document.write(HTMLVal) ;
		parent.frames[0].document.fm_user_access_form.submit() ;
	}
	else
	{
		parent.frames[1].document.forms[0].req_narration.value='';		
	}

}

function PopulateData(objval) {
	if(objval != '') {
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='fm_user_access_form' id='fm_user_access_form' method='post' action='../../eFM/jsp/FMUserAccessPopup.jsp?locn_code="+objval+"'></form></body></html>" ;

		parent.frames[2].document.write(HTMLVal) ;
		parent.frames[2].document.fm_user_access_form.submit() ;
	}
	else {
		var len = parent.f_query_add_mod.fm_user_access_form.storage_location.length;
		for (var i=0; i<=len; i++) {
			parent.f_query_add_mod.fm_user_access_form.storage_location.remove("storage_location");
		}
		var opt	= parent.frames[1].fm_user_access_form.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "--- "+getLabel('Common.defaultSelect.label','common')+" ---";
		parent.f_query_add_mod.fm_user_access_form.storage_location.add(opt);
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function checkbox_value(obj)
	{
		if (obj.checked == true)
		{
			obj.value='Y';
		}
		else
		{
			obj.value='N';
		}

	}

	function change_issue()
	{

		if(document.fm_user_access_form.iss_yn.checked==true)
		{

		document.fm_user_access_form.iss_across_facilities_yn.disabled=false;
		document.fm_user_access_form.iss_across_facilities_yn.checked=false;
		}
		else
		{
		document.fm_user_access_form.iss_across_facilities_yn.checked=false;
		}


	}

	function change_req()
	{

		if(document.fm_user_access_form.req_yn.checked==true)
		{

		document.fm_user_access_form.req_across_facilities_yn.disabled=false;
		document.fm_user_access_form.req_across_facilities_yn.checked=false;
		}
		else
		{
		document.fm_user_access_form.req_across_facilities_yn.checked=false;
		}
	}

	/*function searchCode(target,facilityid)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
				tit=getLabel("Common.user.label","common");
				sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
				search_code="APPL_USER_ID";
				search_desc= "APPL_USER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);


		var arr=new Array();

		if (!(retVal == null))
		{

			var retVal=unescape(retVal);
		    arr=retVal.split("::");

		    document.forms[0].user1.value=arr[0];
			document.forms[0].user.value=arr[1];

		}
		else
		{			
			document.forms[0].user1.value="";
			document.forms[0].user.value="";
		}
	}*/

	async function searchCode(target,facilityid)
	{
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";		
			
				tit=getLabel("Common.user.label","common");
			//	sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
			//sql="select appl_user_id code, appl_user_name description from SM_FACILITY_FOR_USER_VW where facility_id='"+facilityid+"' and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by 2";

			sql="select a.appl_user_id code, a.appl_user_name description from sm_appl_user a, SM_FACILITY_FOR_USER b where b.facility_id='"+facilityid+"' and a.appl_user_id=b.appl_user_id and a.eff_status='E' and upper(a.appl_user_id) like upper(?) and upper(a.appl_user_name) like upper(?) order by 2";

			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;

			retVal = await CommonLookup( tit, argumentArray );

				
		var arr=new Array();

		if(retVal != null && retVal != "" ) 
		{

			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			if(arr[1]==undefined) { 
				arr[1]="";
				arr[0]="";
			}

		    document.forms[0].user1.value=arr[1];
			document.forms[0].user.value=arr[0];

		}
		else
		{			
			document.forms[0].user1.value="";
			document.forms[0].user.value="";
		}
	}

