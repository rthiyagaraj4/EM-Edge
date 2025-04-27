function reset() {	
	if(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form){
	   f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_group_by.value='N';
	   f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.reset() ;
	}
}

function run(){ 
/*Below line Added for this SCF SRR20056-9516 */
	var fields= new Array(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_age_range,f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_fm_date1,f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_to_date1);
	var names=new Array (getLabel("Common.AgeRange.label","MR"),getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common"));

	if(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form){
		 if(f_query_add_mod.checkFields( fields, names, messageFrame)){
			  if(chkGrtr(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_fm_date1,
					f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_to_date1)==true)		
                       					 
					 f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_fm_date.value=convertDate(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_fm_date1.value,"DMY",f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.locale.value,"en");	
							
                      f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_to_date.value=convertDate(f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.p_to_date1.value,"DMY",f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.locale.value,"en");					   
						
						f_query_add_mod.document.AEStatByTreatmentAreaDiagnosisAgeRange_form.submit() ;
							}
        }								
}

async function searchCode(obj,target)
{	
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid =document.forms[0].p_facility_id.value;
    var p_usr =document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;

		tit=getLabel("Common.Location.label","Common");

	sql="select clinic_code code, short_desc description from OP_clinic where Facility_id = '"+p_faclid+"' and  LEVEL_OF_CARE_IND ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	

	var retVal=await CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else{
	var result = retVal[0].split(",")[0];
	target.value=result;
	}
}

function doDate(obj)
{
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	if(obj.value!='')
	{
		if(!validDateObj(obj,'DMY',localeName))
		{
			obj.select();
		}
		else
		{
			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
				obj.select();
				return false ;
				}
		}
	}
}

async function nursCode(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid = document.forms[0].p_facility_id.value;	
    var p_usr = document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;
    var p_fr_locn_code = document.forms[0].p_locn_code.value;

    //title="Nursing Unit";
	tit=getLabel("Common.treatmentarea.label","Common");

if(p_fr_locn_code!="")
	{
		sql="select TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and clinic_code= '"+p_fr_locn_code+"'  and facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";
	}
	else
		sql="select distinct TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and  facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	

	var retVal=await CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else{
	var result = retVal[0].split(",")[0];
	target.value=result;
	}
}

async function call_Diagnosis(obj)
{ 
	var dialogTop	  = "50";
	var dialogHeight  = "75vh" ;
	var dialogWidth   = "75vw" ;
	var features    ="dialogTop:"+dialogTop+"px;dialogHeight:" + dialogHeight + "%; dialogWidth:" + dialogWidth +"%;status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;	
	var term_set   = document.forms[0].p_term_set_id.value;
	var encounter_id	= '';
	if(term_set==''){
		var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Diagnosis Set')+ "\n" ;
		alert(error);
		document.forms[0].p_term_set_id.focus();
	}else{		
		var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?term_set_id="+term_set+"&p_diag_code="+diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=";
			
		var retVal = await window.showModalDialog(params,arguments,features);
		if (!(retVal == null))
		{
			 var retdata;
			 retdata = retVal.split("/")  ;		 
			 objname=obj.name;
			
			 eval("document.forms[0]."+ objname+".value=retdata[0]");	
		}
	}
}

function groupbytreat(obj)
{	
	if(obj.checked)
		obj.value='Y';
	else
		obj.value='N';

	if(obj.value=='Y') // 22678
	{
		document.forms[0].p_report_id.value='AESTDAGP'
	}else
	{
		document.forms[0].p_report_id.value='AESTADAR'
	}
	
}

function chkGrtr(obj1,obj2)
{		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function cleardiagcode()
{
	document.forms[0].p_fm_term_code.value='';
	document.forms[0].p_to_term_code.value='';
}
