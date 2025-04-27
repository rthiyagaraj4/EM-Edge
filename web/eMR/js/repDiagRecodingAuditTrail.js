function reset()
{
    f_query_add_mod.document.location.reload();
}


function run()
{
	error='';
    var  patient_id=parent.frames[2].frames[1].document.forms[0].p_patient_id.value;
	var recodedfromdate=parent.frames[2].frames[1].document.forms[0].p_fm_admn_date.value;
	var recodedtodate=parent.frames[2].frames[1].document.forms[0].p_to_admn_date.value;
	var original_set=parent.frames[2].frames[1].document.forms[0].original_set.value;
	var p_diag_code=parent.frames[2].frames[1].document.forms[0].p_diag_code.value;

	parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';
   	p_location_code=parent.frames[2].frames[1].document.forms[0].p_location_code.value;
	p_location=parent.frames[2].frames[1].document.forms[0].p_location.value;
	if(parent.frames[2].frames[1].document.forms[0].p_location.value=='')
		p_location_code='';
	else
		p_location_code=parent.frames[2].frames[1].document.forms[0].p_location_code.value;
   
	var fields = new Array();
	var names  = new Array();
		if(recodedfromdate=="" || recodedtodate=="")	
		{
			fields[0]=recodedfromdate;
			names[0] = getLabel("eMR.EncPeriod.label","MR");
			if(original_set !="" && p_diag_code == "")
			{
				fields[1]=p_diag_code;
				names[1]=getLabel("eMR.OriginalCode.label","MR");
			}
		}
		else if(original_set !="" && p_diag_code == "")
		{
			fields[0]=p_diag_code;
			names[0]=getLabel("eMR.OriginalCode.label","MR");
			
		}
		if (checkFields(fields, names, messageFrame) )
		{
			//f_query_add_mod.document.AuditTrail.submit() ;
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].submit() ;
		}
		
															
}
	
async function callDiagnosis(obj,target)
{	var dialogTop	  = "50";
	var dialogHeight  = "80vh" ;
	var dialogWidth   = "70vw" ;
	var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	var encounter_id	= '';
	
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=";   
	
	var retVal = await window.showModalDialog(params,arguments,features);
	
	
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=obj.name;
		
		if(target.name=="diag_button"||obj.name=="p_diag_code")
		{
			document.forms[0].p_diag_code.value=retdata[0];
		}else if(target.name=="diag_button1"||obj.name=="mr_diagnosis_code1")
		{
			document.forms[0].mr_diagnosis_code1.value=retdata[0];
		}
    }

}

async function funPatient1()
{

	var patid= await PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	document.forms[0].p_patient_id.value = patid;
}
async function searchCode_new11()
{
	    var val_txt=document.forms[0].location_desc.value
		var facility_id     = document.forms[0].p_facility_id.value;
		var p_location    = document.forms[0].p_location.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	
		
       	
		if(p_location=="C")
	    {
		    tit=getLabel("Common.clinic.label","Common");
			//sql="select clinic_code code,short_desc description  from op_clinic where facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(clinic_code ) like upper(?)";
			sql="select clinic_code code,short_desc description  from op_clinic_lang_vw WHERE    language_id='"+localeName+"' AND   facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(clinic_code ) like upper(?)";
			
		}
		else
	    {
			tit=getLabel("Common.nursingUnit.label","Common");
			//sql="select nursing_unit_code code,short_desc description  from ip_nursing_unit where facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(nursing_unit_code ) like upper(?)";
			sql="select nursing_unit_code code,short_desc description  from ip_nursing_unit_lang_vw where language_id='"+localeName+"' AND facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(nursing_unit_code ) like upper(?)";
			
		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = val_txt;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit,argumentArray);
		
		if(retVal != null && retVal != "" )
                {
			var ret1=unescape(retVal);
			
			arr=ret1.split(",");
			document.forms[0].location_desc.value=arr[1];
			document.forms[0].p_location_code.value=arr[0];
		}
}
function clear_desc1()
{
	
	document.forms[0].location_desc.value='';
	var sel=document.forms[0].p_location.value;
	if(sel=="" || sel==null)
	{
	 document.forms[0].location_desc.disabled=true;
	 document.forms[0].location.disabled=true;
	}
	else
	{
	 document.forms[0].location_desc.disabled=false;
	 document.forms[0].location.disabled=false;
	}
	document.forms[0].p_location_code.value='';


}

async function callSearch2(obj,target)
{
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
       	tit=getLabel("eMR.RecodedBy.label","MR");
		//sql="Select appl_user_id code,appl_user_name description from sm_appl_user where  upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";
		sql="Select appl_user_id code,appl_user_name description from sm_appl_user_lang_vw where  language_id='"+localeName+"' AND upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit,argumentArray);
	
		if(retVal != null && retVal != "" )
	    {
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			document.forms[0].p_recoded_by.value=arr[0];
		}
}

