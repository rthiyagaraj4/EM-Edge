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

function changeLocn(obj){
	document.list_appt_form.P_LOCATION_CODE_FROM.value="";
	document.list_appt_form.P_FM_LOCN_CODE.value="";
	document.list_appt_form.P_LOCATION_CODE_TO.value="";
	document.list_appt_form.P_TO_LOCN_CODE.value="";
}

function searchLocn(obj,target_code,target_desc){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var tit="";
	var sql="";
	var facilityid = document.forms[0].P_FACILITY_ID.value;
	var locale=document.forms[0].locale.value;
	var p_location_type1=document.forms[0].P_LOCN_TYPE.value;

	tit=getLabel("Common.Location.label","Common");
	sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and level_of_care_ind = 'A' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
	
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
		target_code.value=arr[0];
	}else
	{
	target_desc.value="";
	target_code.value="";
	}
}

function searchService(obj,target_code,target_desc){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var tit="";
	var sql="";
	var facilityid = document.forms[0].P_FACILITY_ID.value;
	var locale=document.forms[0].locale.value;
	var p_location_type1=document.forms[0].P_LOCN_TYPE.value;

	tit=getLabel("Common.service.label","Common");
	sql="select service_code code,short_desc description from am_service_lang_vw where language_id='"+locale+"' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	
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
		target_code.value=arr[0];
	}else
	{
	target_desc.value="";
	target_code.value="";
	}
}

function setreferral(){
var p_referral_type=document.forms[0].p_ref_type.value;
var ref_src_fm=document.forms[0].P_FM_REF_SOURCE;
	 while(ref_src_fm.options.length>1) ref_src_fm.options.remove(1);
var ref_src_to=document.forms[0].P_TO_REF_SOURCE;
	 while(ref_src_to.options.length>1) ref_src_to.options.remove(1);
	/*var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].referral_src_fm.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].referral_src_to.add(opt1);*/
	if(p_referral_type!=''){
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH referral_type=\""+p_referral_type+"\" steps='14' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}

}


function run()
{
var fields = new Array(frames[1].document.list_appt_form.P_FM_VISIT_DATE,frames[1].document.list_appt_form.P_TO_VISIT_DATE);
var fmpr=getLabel("Common.from.label","common")+" "+getLabel("Common.Period.label","common");
var topr=getLabel("Common.to.label","common")+" "+getLabel("Common.Period.label","common");
var names = new Array(fmpr,topr);
if(frames[1].checkFields( fields, names, messageFrame))
{
	frames[1].document.list_appt_form.submit() ;
}
}

 function reset() {
  //frames[1].document.forms[0].reset();
  frames[1].location.reload();
  //frames[2].document.location.href='../../eCommon/html/blank.html';
}
