/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/BookingRightsAddModify.jsp?mode=insert';
}

function apply()
{	
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);

	if(frm.name=='query_form' || frm.name=='QueryResult')
{
	//alert('This Operation is not allowed Here');
	//return;
	commontoolbarFrame.location.reload();
}
else
	{
	var fields = new Array (f_query_add_mod.document.forms[0].appl_user_id);
	var names = new Array ( "Login ID");
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/BookingRightsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BookingRightsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("BookingRights.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BookingRightsQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/BookingRightsQueryCriteria.jsp';
	
}



function bookScheduleYN()
{
	if(document.forms[0].book_schedule_yn.checked==true)
		document.forms[0].book_schedule_yn.value="Y";
	else
		document.forms[0].book_schedule_yn.value="N";
}
function transferScheduleYN()
{
	if(document.forms[0].transfer_schedule_yn.checked==true)
		document.forms[0].transfer_schedule_yn.value="Y";
	else
		document.forms[0].transfer_schedule_yn.value="N";
}

function cancelScheduleYN()
{
	if(document.forms[0].cancel_schedule_yn.checked==true)
		document.forms[0].cancel_schedule_yn.value="Y";
	else
		document.forms[0].cancel_schedule_yn.value="N";
}
//Added by lakshmi against MO-CRF-20058

function overbookingAllowedYN()
{
	if(document.forms[0].overbooking_allowed_yn.checked==true)
		document.forms[0].overbooking_allowed_yn.value="Y";
	else
		document.forms[0].overbooking_allowed_yn.value="N";
}

function overrideSpecialityRestriction()
{
	if(document.forms[0].overide_splty_restriction_yn.checked==true)
		document.forms[0].overide_splty_restriction_yn.value="Y";
	else
		document.forms[0].overide_splty_restriction_yn.value="N";
}

function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

async function callLoginUser(){
	var formobj=document.forms[0];
	var facility_id=formobj.facility_id.value;
	var obj=formobj.appl_user_id;
	var target=formobj.appl_user_name;
	var tit=getLabel("Common.user.label","common");
	var sql="SELECT A.USER_ID CODE, A.USERNAME DESCRIPTION FROM SY_USER A WHERE FACILITY_ID = '"+facility_id+"' AND UPPER(A.USERNAME) LIKE UPPER(?) AND UPPER(A.USER_ID) LIKE UPPER(?) ORDER BY 2";
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1"; 
	argumentArray[5] = trimString(obj.value);
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray);
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		arr=ret1.split(",");
		target.value=arr[0];
		obj.value=arr[1];
		
		
		}else{
			nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
	target.value='';
	obj.value='';
	}
}

/*

function callLoginUser()
{
	var column_sizes = escape("60%,40%");
	//var code = getLabel("Common.code.label","common_labels");
	//var descritpion = getLabel("Common.description.label","common_labels");
	//var column_descriptions = escape(code,descritpion);


	//var column_descriptions = escape("Code,Description");
	var column_descriptions = getLabel('Common.code.label','common')+','+getLabel('Common.description.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);
	
	var facility_id=document.forms[0].facility_id.value;
	//alert(facility_id);
	var sql=escape("SELECT USER_ID USERID,USERNAME USER_NAME FROM SY_USER WHERE FACILITY_ID = '"+facility_id+"' ");
//	var title='User Search';
	var title=getLabel("Common.user.label","common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].appl_user_id.value = arr[0];
			document.forms[0].appl_user_name.value = arr[1];	
		}
	else
		{
			document.forms[0].appl_user_id.value = '';
			document.forms[0].appl_user_name.value = '';
		}
}*/

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

//Added on 9/16/2010 for crf by Lakshmi
function restrictBkgDisplayToSelf()
{
	if(document.forms[0].restrict_bkg_display_to_self.checked==true)
		document.forms[0].restrict_bkg_display_to_self.value="Y";
	else
		document.forms[0].restrict_bkg_display_to_self.value="N";
}
