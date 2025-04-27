// After the insertion and modification is carried out the following function is called from the servlet to reload the initial page.This happens only in case of insert mode.
var specialtyForClinc= new Array();
specialtyForClinc[0]	=	'';

function onSuccess() 
 {
  	 f_query_add_mod.location.reload();
 }


// The following function called on click of the create button in common toolbar
function create()
{
    f_query_add_mod.location.href ="../../eAE/jsp/addModifyPractforTreatmentArea.jsp" ;
}


// The following function called on click of the query button for query mode 
function query() 
 {
	 f_query_add_mod.location.href ="../../eAE/jsp/PractforTreatmentAreaQueryCriteria.jsp" ;
 }


// The following function called on click of the delete button for deleting record
function deleterecord()
{	 
//	alert("3");
	if(f_query_add_mod.document.pract_treatment_area_form!=null){
	if(f_query_add_mod.document.pract_treatment_area_form.mode.value!="INSERT")
	 {	
		if(confirm(frames[1].getMessage('DELETE_RECORD','Common')))
		{
		f_query_add_mod.document.forms[0].mode.value='delete';
		f_query_add_mod.document.forms[0].submit();
		f_query_add_mod.location.href = '../../eAE/jsp/addModifyPractforTreatmentArea.jsp?mode=insert' ;
		}else
         messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	 }
	 else
	 {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	 }
}else{
           frames[0].location.reload();
}
}


// The following function called on click of the reset button 
function reset() 
  {
	 // alert("1"+ parent.frames[1].frames[1].document.forms[0]);
	// if( parent.frames[1].frames[1].document.forms[0] =null)
	//{
	//	 alert(f_query_add_mod.location);
    //   parent.frames[1].frames[1].location.reload();
	//}
	f_query_add_mod.location.reload();
  
  }
 // This function is called for showing  and checking the validation of the location href for the f_query_add_mod frame
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

  // This function is for the apply button when the form is submitted to the servlet
function apply() 
 { 
	


  if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	 
   var fields = new Array (f_query_add_mod.document.pract_treatment_area_form.clinic_code,
		 f_query_add_mod.document.pract_treatment_area_form.treatment_area_code,
		 f_query_add_mod.document.pract_treatment_area_form.practitioner_desc);
        
	//var names = new Array ("Clinic","Treatment Area","Practitioner");	
	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.treatmentarea.label","Common"),getLabel("Common.practitioner.label","Common"));	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		var clinicval=f_query_add_mod.document.forms[0].clinic_code.value;
		var clinicarr=clinicval.split("$");

		
		f_query_add_mod.document.forms[0].clinic_code_val.value			= clinicarr[0];
		f_query_add_mod.document.forms[0].treatment_area_code_val.value = f_query_add_mod.document.forms[0].treatment_area_code.value;
		f_query_add_mod.document.forms[0].practitioner_id_val.value		= f_query_add_mod.document.forms[0].practitioner_id.value;
		f_query_add_mod.document.pract_treatment_area_form.submit();
				
				
	 }
}

  function chkValue(obj)
   {
	  if(obj.checked==true)
       {
				obj.checked=true;
				obj.value='E';
       }
      else
       {
				obj.checked=false;
				obj.value='D';
       }
   }

   function popTreatmentCode(obj)
   {
	        document.forms[0].practitioner_desc.disabled=true;
			document.forms[0].pract_button.disabled=true;
			var clinic_code;
			var objarr;
	   if(obj.value!='')
	   {
		   var objvalue=obj.value;
			objarr=objvalue.split("$");
			clinic_code=objarr[0];
		   	var treatment_area_code = document.forms[0].treatment_area_code;
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);

			document.forms[0].practitioner_desc.disabled=true;
			document.forms[0].pract_button.disabled=true;

			document.forms[0].practitioner_id.value = "";
			document.forms[0].practitioner_desc.value = "";
			var treatment = document.forms[0].treatment_area_code_val.value;
			var practitioner =  document.forms[0].practitioner_id_val.value;

			var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/PopulateTreatmentArea.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +clinic_code+ "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment+"'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+practitioner+"'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.frames[2].document.form1.submit();
			parent.frames[2].document.forms[0].submit();
	   }
   else
	   {
		   	var treatment_area_code = document.forms[0].treatment_area_code;
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);
			document.forms[0].practitioner_id.value = "";
			document.forms[0].practitioner_desc.value = "";
	   }

   }

 

	  function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
	  }


  function beforeGetPractitioner(obj,target_name)
{
	
	target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 
			
			 return;
			}

			aegetPractitioner(obj,target_name);
}


async function aegetPractitioner(obj,target)
{
   
	var	clinic_code		=	document.forms[0].clinic_code.value;
	
	var clinicarr=clinic_code.split("$");

	var clinic_code=clinicarr[0];
	var opentoallpractyn=clinicarr[1];

	var treatment_area_code=document.forms[0].treatment_area_code.value;
	var specialty_code=specialtyForClinc[document.forms[0].clinic_code.selectedIndex];
	var facility_id		=	document.forms[0].facilityId.value;
	var FirstSql="";
	var SecondSql="";
	var tit="";
	var open_to_all_prac_for_clinic_yn="";
	var open_to_all_pract_yn="";
    var practitioner_type="";

	var practitionerName="";
	var practitionerValue="";
		
	target.value=trimString(target.value);
	practitionerName=target.name;
	practitionerValue=target.value;	

	/*FirstSql="select a.practitioner_id,a.practitioner_name,a.pract_type_desc practitioner_type,decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title,a.gender,a.primary_splty_short_desc primary_specialty from am_practitioner_vw a , am_pract_for_facility b, op_clinic c	where a.eff_status='E' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and c.facility_id = b.facility_id and c.clinic_code = '"+clinic+"' and  (c.speciality_code = a.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = a.practitioner_id )) and b.practitioner_id = a.practitioner_id and b.eff_status = 'E' 	and b.facility_id= '"+facility_id+"' and upper(c.speciality_code) like upper(nvl(?,c.speciality_code))and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) ORDER BY 2 ";
	SecondSql="select a.practitioner_id,a.practitioner_name,a.pract_type_desc practitioner_type,decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title,a.gender,a.primary_splty_short_desc primary_specialty from am_practitioner_vw a , am_pract_for_facility b, op_clinic c	where a.eff_status='E' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and c.facility_id = b.facility_id and c.clinic_code = '"+clinic+"' and  (c.speciality_code = a.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = a.practitioner_id )) 	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E' 	and b.facility_id= '"+facility_id+"' and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) ORDER BY 2";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\""	;
	xmlStr += " practName_FValue=\"" + practitionerValue + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +specialty_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;   
	responseText = trimString(responseText);
	eval(responseText);	*/
	
	await getPractitioner(obj,target,facility_id,specialty_code,practitioner_type,"Q3",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn)
	return; 
	
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practitioner_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].practitioner_desc.value="";			
	}
}
function practionerenable()
{
 if(document.forms[0].treatment_area_code.value==null ||document.forms[0].treatment_area_code.value=="")
	{
     document.forms[0].practitioner_desc.disabled=true;
	 document.forms[0].pract_button.disabled=true;
    }
else
	{
	    document.forms[0].practitioner_desc.disabled=false;
	    document.forms[0].pract_button.disabled=false;
   }
    document.forms[0].practitioner_desc.value="";
} 

