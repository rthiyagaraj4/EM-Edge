function reset() {
	f_query_add_mod.document.repCancelAppointments.reset() ;
}




function run() 
{
	var fields = new Array( f_query_add_mod.document.repCancelAppointments.p_fm_appt_date,
					f_query_add_mod.document.repCancelAppointments.p_to_appt_date );

var names = new Array(getLabel("eOA.ApptDateFrom.label","OA"), getLabel("eOA.ApptDateTo.label","OA"));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	if( f_query_add_mod.DateCompare_apply( f_query_add_mod.document.repCancelAppointments.p_fm_appt_date, f_query_add_mod.document.repCancelAppointments.p_to_appt_date) ) 
	{
		if( f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_locn_code, f_query_add_mod.document.repCancelAppointments.p_to_locn_code, messageFrame ) ) 
		{
  			if( f_query_add_mod.CheckString( getLabel("Common.SpecialityCode.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_speciality, f_query_add_mod.document.repCancelAppointments.p_to_speciality, messageFrame ) ) 
			{
		  		if( f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_service, f_query_add_mod.document.repCancelAppointments.p_to_service, messageFrame ) ) 
  				{
					if( f_query_add_mod.CheckString( getLabel("Common.resourceid.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_pract_id, f_query_add_mod.document.repCancelAppointments.p_to_pract_id, messageFrame ) ) 
					{
						if( f_query_add_mod.CheckString( getLabel("Common.ReasonforCancellation.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_contact_reason, f_query_add_mod.document.repCancelAppointments.p_to_contact_reason, messageFrame ) ) 
  				{
							if( f_query_add_mod.CheckString( getLabel("Common.cancelledby.label","Common"),f_query_add_mod.document.repCancelAppointments.p_fm_modified_by_id, f_query_add_mod.document.repCancelAppointments.p_to_modified_by_id, messageFrame ) ) 
  				{
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.repCancelAppointments.submit() ;
					}
				}}
		}
			}
		}
	}
	}	
}

function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
document.forms[0].p_fm_locn_code.value='';
document.forms[0].p_to_locn_code.value='';
		} 
  



function practValidate(Obj)
		{
	document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
	document.forms[0].p_fm_pract_id.value='';
		document.forms[0].p_to_pract_id.value='';
		if(Obj.value=='')
		{

			document.forms[0].p_fm_pract_id.value='';
			document.forms[0].p_to_pract_id.value='';
			document.forms[0].p_fm_pract_id.disabled=true;
			document.forms[0].pract_id.disabled=true;
			document.forms[0].pract_id1.disabled=true;
			document.forms[0].p_to_pract_id.disabled=true;
		}
		else
			{
		document.forms[0].p_fm_pract_id.disabled=false;
			document.forms[0].p_to_pract_id.disabled=false;
		document.forms[0].pract_id.disabled=false;
		document.forms[0].pract_id1.disabled=false;
			}
		}

function getResource(Obj)
{
	var carelocn="";
	var resource1 = document.forms[0].p_resource_class1.value;
		var n=document.forms[0].fm_pract_type.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].fm_pract_type.remove("clinic");
		document.forms[0].to_pract_type.remove("clinic");
		
	}
	
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].fm_pract_type.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].to_pract_type.add(opt1);	
	
if(!(resource1 == null || resource1 == ""))
{
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
}


function enablepr(obj)
{
	document.forms[0].p_fm_pract_id.value='';
		
	
}
function enablepr1(obj)
{
	document.forms[0].p_to_pract_id.value='';
	
		
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
			var facilityid =document.forms[0].p_facility_id.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
			var facility=obj1.value;
			var locale=document.forms[0].locale.value;
			if(obj.name=="locn")
			{
				tit=encodeURIComponent(getLabel("Common.Location.label","Common"));

				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+locale+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,CARE_LOCN_TYPE_IND) ";
				search_code="clinic_code";
				search_desc= "long_desc";
				
				
			}
			if(obj.name=="speciality")
			{
				tit=encodeURIComponent(getLabel("Common.speciality.label","Common"));
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc"
			}
			if(obj.name=="service")
			{
				tit=encodeURIComponent(getLabel("Common.service.label","Common"));
				sql="select service_code, short_desc from am_service_lang_vw where language_id=`"+locale+"`";
				search_code="service_code";
				search_desc= "short_desc"
			}
			if(obj.name=="reasoncancel")
			{
				tit=encodeURIComponent(getLabel("Common.ReasonforCancellation.label","Common"));
				sql="select CONTACT_REASON_CODE, CONTACT_REASON from am_contact_reason_lang_vw where language_id=`"+locale+"` ";
				search_code="CONTACT_REASON_CODE";
				search_desc= "CONTACT_REASON"
			}
			if(obj.name=="canceledby")
			{
				tit=encodeURIComponent(getLabel("Common.cancelledby.label","Common"));
				sql="select  appl_user_id,appl_user_name from SM_APPL_USER";
				search_code="appl_user_id";
				search_desc= "appl_user_name"
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/



			async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var facilityid = document.forms[0].p_facility_id.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
			//var facility=obj1.value;
			var locale=document.forms[0].locale.value;

			if(obj.name=="locn" || obj.name=="p_fm_locn_code" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");

				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+locale+"' and level_of_care_ind = 'A' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
				
			}
			if(obj.name=="speciality" || obj.name=="p_fm_speciality" || obj.name=="p_to_speciality")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality_lang_vw where language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
			}
			if(obj.name=="service" || obj.name=="p_fm_service" || obj.name=="p_to_service")
			{
				tit=getLabel("Common.service.label","Common");
				sql="select service_code code, short_desc description from am_service_lang_vw where language_id='"+locale+"'  and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
			
			}
			if(obj.name=="reasoncancel" || obj.name=="p_fm_contact_reason" || obj.name=="p_to_contact_reason")
			{
				tit=getLabel("Common.ReasonforCancellation.label","Common");
				sql="select CONTACT_REASON_CODE code, CONTACT_REASON description from am_contact_reason_lang_vw where language_id='"+locale+"'  and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) order by 2";
				
			}
			if(obj.name=="canceledby" || obj.name=="p_fm_modified_by_id" || obj.name=="p_to_modified_by_id")
			{
				tit=getLabel("Common.cancelledby.label","Common");
				sql="select  appl_user_id code,appl_user_name description from SM_APPL_USER_LANG_vw where language_id='"+locale+"' and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by 2 ";
				
			}

					
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}






	function ValidateDate(obj)
	{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
	}



	function DateCompare_apply(from,to)
	{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}

	}
