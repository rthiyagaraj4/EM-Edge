/*Created by Ashwini on 24-May-2017 for ML-MMOH-CRF-0610*/
function callSearchScreen()
{
	var patientid=PatientSearch('','','','','','','Y','','','OTHER');;
	if(patientid !=null)
	document.forms[0].PatientId.value = patientid;
	document.forms[0].PatientId.focus();		 
}

function validatePatientId(obj) 
{
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}
	}
}

function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].to_appt_date.focus();
			document.forms[0].to_appt_date.select();
		}
	}
}

function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function populateLocations(Obj)
{
	if(Obj.value==null || Obj.value==""){
	document.getElementById("b_loc_val").value="";
	document.getElementById("b_loc_val").disabled=true;
	document.getElementById("b_loc_search").disabled=true;
	document.getElementById("b_loc").value="";
	document.getElementById("resourceType_1").value="";
	document.getElementById("resourceType_1").disabled=true;
	document.getElementById("practitioner_name").value="";
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	}else{
	document.getElementById("b_loc_val").value="";
	document.getElementById("b_loc").value="";
	document.getElementById("b_loc_val").disabled=false;
	document.getElementById("b_loc_search").disabled=false;
	}
}

async function open_loc_lookup(){
	var location_type=document.forms[0].location_type.value;
	var speciality_code=document.forms[0].speciality.value;
	var location_val=document.forms[0].b_loc_val.value;

	var dialogTop = "60" ;
	var dialogHeight= "37" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+location_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+location_type+"&speciality_code="+speciality_code+"&function_id=QRY_APPT_PAT",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].b_loc.value=open_all_pract_yn+"$"+code;
		ena_pract(document.forms[0].b_loc);
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc.value="";
		ena_pract(document.forms[0].b_loc);
	}
}

function enable_dsiable_res(Obj)
{
	document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';
	document.getElementById("resourceType1").value=document.getElementById("resourceType_1").value;

	if(Obj.value!='' && Obj.value!='B'){
		
		if(document.forms[0].b_loc.value !='' && document.forms[0].b_loc.value !=null){ 			
			document.getElementById("practitioner_name").disabled=false;
			document.getElementById("search_pract").disabled=false;
			}
		}else{
			document.getElementById("practitioner_name").disabled=true;
			document.getElementById("search_pract").disabled=true;
		}
}

function ena_loc_lookup(obj)
{
	if(obj.value==null || obj.value==''){
		document.forms[0].b_loc.value="";
		ena_pract(document.forms[0].b_loc);
		document.getElementById("resourceType_1").disabled=true;
	}else{
		open_loc_lookup()
	}
}

function ena_pract(Obj) 
{   
	document.getElementById("resourceType_1").value='';
	document.getElementById("practitioner_name").value='';
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	document.getElementById("practitioner").value='';
	document.getElementById("location_code1").value= document.forms[0].b_loc.value;

	if(Obj.value==''){
		document.getElementById("resourceType_1").disabled=true;
	}else{
		document.getElementById("resourceType_1").disabled=false;
	}

}

function serviceLkp(obj,target_code,target_desc,obj2)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var tit="";
	var sql="";

		if(obj.name=="service"||obj.name=="service1" || obj.name=="p_fm_service_code" || obj.name=="p_to_service_code")
			{
				tit=getLabel("Common.service.label","Common");
				sql="select service_code code,short_desc description from am_service_lang_vw where language_id='"+locale+"' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";	
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
					target_desc.value=arr[0];
					target_code.value=arr[1];
					obj2.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
	
}

function onBlurServLkp(obj,target_code,target_desc,obj2)
{
	if((obj.value==null || obj.value=='') && obj.name =='p_fm_service_code'){
		document.forms[0].service_frm.value="";
	}else if((obj.value==null || obj.value=='') && obj.name =='p_to_service_code'){
		document.forms[0].service_to.value="";
	}else{
		serviceLkp(obj,target_code,target_desc,obj2);
	}
}

function searchResult()
{
	
	var from				= document.forms[0].frm_appt_date.value ;
	var to					= document.forms[0].to_appt_date.value ;
	var patientid		    = document.forms[0].PatientId.value;
	var speciality		    = document.forms[0].speciality.value;
	var location_type	    = document.forms[0].location_type.value;
	var resourceType_1	    = document.forms[0].resourceType_1.value;
	var practitioner		= document.forms[0].practitioner.value;
	var frm_service_code	= document.forms[0].service_frm.value;
	var to_service_code		= document.forms[0].service_to.value;
	var loc_value		    = document.forms[0].b_loc.value;
	var b_loc_id			= "";
	if(loc_value!="")
	{
		var b_loc_id_arr	= loc_value.split("$");
		b_loc_id			= b_loc_id_arr[1];
	}

	if(patientid == "")
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.patientId.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);		
	}
	else
	{
		var callvalue = parent.frames[2].document.location.href='../../eOA/jsp/ApptHistoryResult.jsp?from='+from+'&to='+to+'&patientid='+patientid+'&speciality='+speciality+'&location_type='+location_type+'&loc_value='+b_loc_id+'&resourceType_1='+resourceType_1+'&practitioner='+practitioner+'&frm_service_code='+frm_service_code+'&to_service_code='+to_service_code;	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
	}
									
}

function fnSetvalue(type)
{
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}

function run()
{
	var from				= searchFrame.document.Appt_history_form.frm_appt_date.value ;
	var speciality		    = searchFrame.document.Appt_history_form.speciality.value;
	var location_type	    = searchFrame.document.Appt_history_form.location_type.value;
	var resourceType_1	    = searchFrame.document.Appt_history_form.resourceType_1.value;
	var practitioner		= searchFrame.document.Appt_history_form.practitioner.value;
	var frm_service_code	= searchFrame.document.Appt_history_form.service_frm.value;
	var to_service_code		= searchFrame.document.Appt_history_form.service_to.value;
	var patientid			= searchFrame.document.Appt_history_form.PatientId.value;
	var loc_value		    = searchFrame.document.Appt_history_form.b_loc.value;
	var b_loc_id			= "";
	if(loc_value!="")
	{
		var b_loc_id_arr	= loc_value.split("$");
		b_loc_id			= b_loc_id_arr[1];
	}
	searchFrame.document.Appt_history_form.from_appt_date.value = from;
	searchFrame.document.Appt_history_form.p_speciality_code.value = speciality;
	searchFrame.document.Appt_history_form.p_patient_id.value = patientid;
	searchFrame.document.Appt_history_form.p_location_type.value = location_type;
	searchFrame.document.Appt_history_form.p_location.value = b_loc_id;
	searchFrame.document.Appt_history_form.p_resource_type.value = resourceType_1;
	searchFrame.document.Appt_history_form.p_resource_id.value = practitioner;
	searchFrame.document.Appt_history_form.from_service_code.value = frm_service_code;
	searchFrame.document.Appt_history_form.to_service_code.value = to_service_code;
	if(patientid == "")
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.patientId.label","Common"));	
		alert(error);		
	}
	else
		searchFrame.document.Appt_history_form.submit() ;
}

//End ML-MMOH-CRF-0610
