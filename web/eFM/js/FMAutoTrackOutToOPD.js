function apply()
{
	parent.frames[2].frames[1].document.forms[0].submit();	
}

function onSuccess()
{
	parent.frames[2].frames[1].location.reload();
}

function reset()
{
	parent.frames[2].frames[1].location.reload();
}

function refresh(LocnVal)
{
	var obj = parent.frames[1].document.forms[0]

	if(LocnVal != "")
	{
		var recLocnArr = LocnVal.split("|");
		var LocnCode = recLocnArr[0];	
		var LocnIden = recLocnArr[1];
		var LocnMRyn = recLocnArr[2];

		obj.iss_locn_code.value = LocnCode;
		obj.iss_locn_iden.value = LocnIden;
		obj.iss_locn_mryn.value = LocnMRyn;		
	}
	else
	{
		obj.iss_locn_code.value = "";
		obj.iss_locn_iden.value = "";
		obj.iss_locn_mryn.value = "";
	} 
}

function TrackoutFiles()
{
	parent.parent.frames[2].commontoolbarFrame.location.href = '../../eCommon/html/process.html';

	var Obj = parent.frames[1].document.forms[0]	

	var fields = new Array ( Obj.iss_locn_code, Obj.appt_date );
	var names = new Array ( getLabel("eFM.FSLocation.label","FM"), getLabel("Common.apptdate.label","common") );

	if(parent.frames[1].checkFields( fields, names, parent.messageFrame)) 
	{
	
		if(parent.frames[1].CheckString(getLabel("Common.locationcode.label","common"),Obj.from_clinic, Obj.to_clinic, parent.messageFrame ) )
		{		
		//alert(parent.frames[1].document.forms[0].action);
			/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start*/
			var start_time	= Obj.start_time.value;
			var end_time	= Obj.end_time.value;
			if(start_time!="" || end_time!=""){
				if(start_time=="" || end_time==""){
					var error	=  getMessage('START_END_TIME_CANNOT_BE_BLANK','FM');
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error+"&err_value=0";
					return false;
				}
			}
			/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End*/
		
			Obj.trackout.disabled=true;
			Obj.locn.disabled=true;
			Obj.locn1.disabled=true;
			parent.frames[1].document.forms[0].action="../../servlet/eFM.FMAutoTrackOutToOPDServlet";
			parent.frames[1].document.forms[0].target="messageFrame";
			parent.frames[1].document.forms[0].submit();
		}else
		{//alert("test1");	
		Obj.trackout.disabled=false;
		Obj.locn.disabled=false;
		Obj.locn1.disabled=false;
		}
	}
}

function ValidateOPDDate(from,today)
{
	if(today != "" && from.value !="" )
    {
		var fromarray;
		var toarray;
		var reportedarray;
		var fromdate =from.value ;
		var todate =today ;
		
		if (!isAfterNow(fromdate,"DMY",localeName))
		{
			var msg=getMessage("APPT_DATE_NOT_LESS_CURRDATE","FM");
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			from.focus();
			from.select();
			return false;
		}
		/*if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				//var msg ="APP-FM0041 Appointment Date can not be Less than System Date"
				var msg=getMessage("APPT_DATE_NOT_LESS_CURRDATE","FM");
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				from.focus();
				from.select();
				return false;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?' ;
				return true;
			}
		}*/
	 }
	 else
	 {
			//var msg ="APP-000001 Appointment Date cannot be blank..."
			var msg=getMessage("APPT_DATE_CANNOT_BLANK","FM");
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			from.focus();
			from.select();
			return false;
	 }
}

function changeVal(obj)
	{
		document.forms[0].P_LOCATION_TYPE.value=obj.value;
		document.forms[0].from_clinic.value='';
		document.forms[0].to_clinic.value='';
		if(obj.value != null)
		{
			if(document.forms[0].from_clinic.disabled == true)
				document.forms[0].from_clinic.disabled = false;
			if(document.forms[0].locn.disabled == true)
				document.forms[0].locn.disabled = false;
			if(document.forms[0].to_clinic.disabled == true)
				document.forms[0].to_clinic.disabled = false;
			if(document.forms[0].locn1.disabled == true)
				document.forms[0].locn1.disabled = false;
		}
	}

/*function searchCode(obj,target,obj1)
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
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
			
		var facility=obj1.value;
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"`  and language_id=`"+localeName+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=`"+p_location_type1+"` ";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}
		if(obj.name=="locn1")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=`"+p_location_type1+"`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A`"
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}

		if(obj.name=="service"||obj.name=="service1")
		{
			tit=getLabel("Common.service.label","common");
			sql="select service_code,short_desc from am_service_lang_vw where language_id=`"+localeName+"` ";
			search_code="SERVICE_CODE";
			search_desc= "SHORT_DESC"
		}
		if(obj.name=="speciality"||obj.name=="speciality1")
		{
			tit=getLabel("Common.speciality.label","common");
			sql="select speciality_code,short_desc from am_speciality_lang_vw language_id=`"+localeName+"` ";
			search_code="SPECIALITY_CODE";
			search_desc= "SHORT_DESC"
		}
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
	}*/


	async function searchCode(obj,target,obj1) 
	{   
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var search_code="";
		var search_desc="";
		var tit="";
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
		/*Added eff_status='E' in below Query by Senthil on 14-Oct-2011 [IN029281]*/	
		var facility=obj1.value;
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}
		if(obj.name=="locn1")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)"
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}

		if(obj.name=="service"||obj.name=="service1")
		{
			tit=getLabel("Common.service.label","common");
			sql="select service_code code,short_desc description from am_service_lang_vw where language_id='"+localeName+"'  and upper(service_code) like upper(?) and upper(short_desc) like upper(?)";
			search_code="SERVICE_CODE";
			search_desc= "SHORT_DESC"
		}
		if(obj.name=="speciality"||obj.name=="speciality1")
		{
			tit=getLabel("Common.speciality.label","common");
			sql="select speciality_code code,short_desc description from am_speciality_lang_vw language_id='"+localeName+"' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?)";
			search_code="SPECIALITY_CODE";
			search_desc= "SHORT_DESC"
		}
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		//argumentArray[6] = DESC_LINK  ;
		argumentArray[6] = CODE_LINK  ;
		//argumentArray[7] = DESC_CODE ;
		argumentArray[7] = CODE_DESC ;

		retVal = await CommonLookup( tit, argumentArray );

		/*if(retVal != null && retVal != "" )
		{
			target.value=retVal;
		}
		else
			target.focus();*/

		var arr=new Array();

		if(retVal != null && retVal != "" ) {	
			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			target.value=arr[0];
		}
		else
		{
			target.value="";
		}
	}

function EnableDisableCheck(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}

function searchCodeTrackedout(target,facility_id,target_name)
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
				sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facility_id+"` ";
				search_code="APPL_USER_ID";
				search_desc= "APPL_USER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

			if (retVal!=null){
			if (!(unescape(retVal) == null))
			{
				arr=unescape(retVal).split("::");
				target_name.value=arr[0];
				target.value=arr[1];
			}
			}
			else
			{
				target.value="";
				target_name.value="";
			}
		}


function doOnlineReportPrintingTrackout(error_msg,error_val,login_facility_id,login_user_id,from_clinic,to_clinic,p_fm_pract_id,p_to_pract_id,appt_date2,fs_locn_code)
	{
 	
	 
	 var flag="Auto Track out to OPD";
	  
	    HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMGeneratePullListConfirm.jsp'><input name='login_facility_id' id='login_facility_id' type='hidden' value='"+login_facility_id+"'><input name='login_user_id' id='login_user_id' type='hidden' value='"+login_user_id+"'><input name='from_clinic' id='from_clinic' type='hidden' value='"+from_clinic+"'><input name='to_clinic' id='to_clinic' type='hidden' value='"+to_clinic+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='appt_date2' id='appt_date2' type='hidden' value='"+appt_date2+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'></form></BODY></HTML>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.form1.submit();

	
	if(error_val==1)
		{
	parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+error_msg+"&err_value=1";
		}
 
  if(error_val==0)
		{
	parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+error_msg+"&err_value=0";
		}
  parent.frames[1].document.forms[0].trackout.disabled=false;
  
  }  

