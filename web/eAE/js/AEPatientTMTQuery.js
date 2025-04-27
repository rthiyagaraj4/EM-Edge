
// Added/Modified by Nanda - 11/8/2002
var treatmentGender			=	new Array();
var clinicType				=	new Array();
var openToAllPractionerYN	=	new Array();
var openToAllPractForClnYN	=	new Array();
var specialtyForClinc	    =	new Array();


treatmentGender[0]			=	'';
clinicType[0]				=	'';
openToAllPractionerYN[0]	=	'';
openToAllPractForClnYN[0]	=	'';

function populateDynamicValues(forField)
{
	var	clinic_code			=	document.forms[0].clinic_code;
	var practitioner_id		=	document.forms[0].practitioner_id;
	var treatment_area_code	=	document.forms[0].treatment_area_code;
	var open_to_all_pract_yn=	openToAllPractionerYN[clinic_code.selectedIndex];
	
	var	frame_name			=	"parent.f_tmt_pat_search.AEPatientTMTSearchFrame";

	if(forField=="TreatmentArea")
	{ 
		document.forms[0].gender.disabled	=	false;
		document.forms[0].gender.value		=	'';

		var optlength = treatment_area_code.options.length;
		for (var i=0; i<optlength; i++)
		{
			treatment_area_code.options.remove("treatment_area_code");
		}

		var opt		=	document.createElement('OPTION'); 
		opt.text	=	'  ----- Select -----  ';
		opt.value	=	'';
		treatment_area_code.add(opt); 

		var HTMLVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
		"</form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.messageFrame.document.AEMPDynamicForm.submit();
	}
	else if( (forField=="Practitioner")  )
	{
		var open_to_all_prac_for_clinic_yn	=	"";
		if(forField=="Practitioner")
		{
			open_to_all_prac_for_clinic_yn	=	openToAllPractForClnYN[treatment_area_code.selectedIndex];
		}
		

		var HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>"+
		"<body class='MESSAGE' onKeyDown = 'lockKey()'><form name='AEMPDynamicForm' id='AEMPDynamicForm' method='post' action='../../eAE/jsp/AEMPDynamicValues.jsp'>"+
		"<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code.value+"'>"+
		"<input type='hidden' name='frame_name' id='frame_name' value='"+frame_name+"'>"+
		"<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment_area_code.value+"'>"+
		"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'>"+
		"<input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='"+open_to_all_prac_for_clinic_yn+"'>"+
		"<input type='hidden' name='pop_mode' id='pop_mode' value='"+forField+"'>"+
		"</form></body></html>";
		if (forField=="AssignTreatmentArea")
		{
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.AEMPDynamicForm.submit();
		}
		else
		{
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.parent.messageFrame.document.AEMPDynamicForm.submit();
		}
	}
 }  

function checkTreatmentGender()
{
	document.forms[0].practitioner_desc.value='';
	document.forms[0].practitioner_id.value='';

	var treatment_area_code =	document.forms[0].treatment_area_code;
	var gender				=	document.forms[0].gender;

	var treatment_gender	=	treatmentGender[treatment_area_code.selectedIndex];

	if(treatment_gender!="")
	{
		gender.value	=	treatment_gender;
		gender.disabled	=	true;
	}
	else
	{
		gender.value	=	treatment_gender;
		gender.disabled	=	false;
	}
}

function showQueryResult()
{
	var practitioner_id	    =   document.forms[0].practitioner_id.value;
	var clinic_code		=	document.forms[0].clinic_code;
	var clinic_type		=	document.forms[0].clinic_type;
	var gender			=	document.forms[0].gender;
	var patient_gender	=	document.forms[0].patient_gender;
	var fields = new Array (document.forms[0].patient_id);
	/*Modified By Dharma for Leap Year Issue on Oct 5th 2015 Start*/
	//var currentdate= convertDate(document.forms[0].sysdate.value,"DMYHM",localeName,"en");
    //var fromdate = convertDate(document.forms[0].patbytrmtroom_datefrom.value,"DMYHM",localeName,"en");
    //var todate = convertDate(document.forms[0].patbytrmtroom_to.value,"DMYHM",localeName,"en");
	var currentdate= document.forms[0].sysdate.value;
    var fromdate = document.forms[0].patbytrmtroom_datefrom.value;
    var todate = document.forms[0].patbytrmtroom_to.value;
	/*Modified By Dharma for Leap Year Issue on Oct 5th 2015 End*/
	var arr = new Array(todate,fromdate,currentdate)
    var fromarray; 
    var toarray;
    var currentdatearray;

	var names = new Array (getLabel("Common.patientId.label","Common"));	
		
	patient_gender.value		=	gender.value;
	clinic_type.value			=	clinicType[clinic_code.selectedIndex];
	document.forms[0].target	=	"AEPatientTMTResultFrame";
	document.forms[0].action	=	"../../eAE/jsp/AEPatientTMTResult.jsp";
	document.forms[0].method	=	"GET";
	var error_jsp="../../eCommon/jsp/error.jsp";
	var sql_query='';
    var andCheck	=	0;   


 
   if (fromdate!='' && todate!='')
		{
			if(isBefore(fromdate,todate,"DMYHM",localeName))
			{

	if( (trimCheck(fromdate) == true) && (trimCheck(todate) == true ) )
		{
	      if(andCheck == 1)
			{
			sql_query	= sql_query + '	and trunc(queue_date) between trunc(to_date(\''+convertDate(fromdate,"DMYHM",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) and trunc(to_date(\''+convertDate(todate,"DMYHM",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) ';
		    }
		 else
			{
			 sql_query	='	and trunc(queue_date) between trunc(to_date(\''+convertDate(fromdate,"DMYHM",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) and trunc(to_date(\''+convertDate(todate,"DMYHM",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) ';
			andCheck == 1;
			}
		}

		else if( (trimCheck(fromdate) == true) )
		{
	      if(andCheck == 1)
		    { 
		
			  sql_query = sql_query + ' and to_char(queue_date,\'dd/mm/yyyy\hh24:mi\') =\''+convertDate(fromdate,"DMYHM",localeName,"en") +'\'';
		     }
		else
		   {
			sql_query = ' and to_char(queue_date,\'dd/mm/yyyy\hh24:mi\') =\''+convertDate(fromdate,"DMYHM",localeName,"en") +'\'';				  
			andCheck == 1;
		   }
		}	

		else if( (trimCheck(todate) == true) )
		{
        if(andCheck == 1)
		{
		
		sql_query = sql_query + ' and to_char(queue_date,\'dd/mm/yyyy\hh24:mi\') =\''+convertDate(todate,"DMYHM",localeName,"en") +'\'';
		}

		else
		{
		
			sql_query = ' and to_char(queue_date,\'dd/mm/yyyy\hh24:mi\') =\''+convertDate(todate,"DMYHM",localeName,"en") +'\'';
		andCheck == 1;
		}
		}
		
		
		
		if(SpecialCharCheck(fields,names,parent.parent.messageFrame,"M",error_jsp))
	      {
			  parent.parent.messageFrame.location.href ="../../eCommon/jsp/error.jsp" ;  
	           document.forms[0].refresh.disabled = true;
	           document.forms[0].submit(); 

	        }
			}
	
			else
			{	
				error=getMessage('TO_DATE_GE_FROM_DATE','SM')
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
    		    parent.frames[1].location.href='../../eCommon/html/blank.html';
		        parent.frames[2].location.href='../../eCommon/html/blank.html';
	            return false;
			}
						
		}
			else
		{
			if(SpecialCharCheck(fields,names,parent.parent.messageFrame,"M",error_jsp))
	      {
				parent.parent.messageFrame.location.href ="../../eCommon/jsp/error.jsp" ;  
	           document.forms[0].refresh.disabled = true;
	           document.forms[0].submit(); 
	        }
	   }
}







async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";

	return_value	=	await PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

function monthcheck(obj) {
	var dt=obj.value;
	var strMonth ;
	var strYear;
	var strDays;
	if( dt.length > 0 ) {
		if (dt.indexOf(" ") > -1) {
		var 	arr = new Array();
		var arr1 = new Array();
		var arrTime = new Array();
		arr = dt.split("/");

		   if (arr.length < 3) return false;
			strDays=arr[0];
			strMonth = arr[1];
			strYear = arr[2];

			arrTime=strYear.split(" ");
			var strYear1=arrTime[0];
			var strTime=arrTime[1];
			var  time=strTime.split(":");
			if (time.length < 2) return false;
			var strHr=time[0];
			var  strMi=time[1];
			if (strYear1.length < 4) return false;
			if (isNaN(strMonth)==true) return false;
	
			if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDays > 31 || strDays < 1)) return false;
	        if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDays > 30 || strDays < 1)) return false;
            if (strMonth == 2) {
			if (strDays < 1) return false;
			if (LeapYear(strYear1) == true) {
			if (strDays > 29) return false;
		}
		else {
				if (strDays > 28) return false;
			}
	}
			if (isNaN(strYear1)==true) return false;
			if (strYear1 < 1900) return false;
			if (strMonth>12 || strMonth<1) return false;
			if (strHr > 23 || strHr<0 )  return false;
			if (strMi > 59 || strMi<0)  return false;
	}else return false;
	}else return true;
	return true;
}


function ValidateDateTime (from,to, obj)
{
	from	= from.value
	to		= to.value

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")
    var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    if(Date.parse(to_date) < Date.parse(from_date))
	{
		if(obj=='V')
			alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
		else
			alert(getMessage("AE_VISIT_DATE_TIME_CK1",'AE'));

			return false
	}
	else
		return true;
}

 function CheckTime(obj,from,to) {
  if(obj.value!='')
	 {
		if(monthcheck(obj)==false) {
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			obj.select();
			obj.focus();
		}
		else
			{
				if(ValidateDateTime(obj,to,'V')==false)
				{
					obj.focus();
				}
				else
				if(ValidateDateTime(from,obj,'S')==false)
				{
					obj.focus();
				}
			} 
     }
}

function ClearFunction()
{
	var treatment_area_code="";
	treatment_area_code=parent.frames[0].document.forms[0].treatment_area_code;

	document.forms[0].refresh.disabled = false;
	parent.frames[0].document.forms[0].reset();
	if (parent.frames[1])
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		parent.frames[2].location.href='../../eCommon/html/blank.html';
	}
        while(treatment_area_code.options.length > 1)
					treatment_area_code.remove(1);
		parent.parent.frames[0].document.forms[0].reset.disabled=false;

		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}

function beforeGetPractitioner2(obj,target_name)
{
	
	target_name.value = trimString(target_name.value);
	
		 if(target_name.value == "")
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 
			
			 return;
			}

			getPractitioner2(obj,target_name);
}

function clear_chk_select1()
		{
document.forms[0].chk_Select1.value="";
        }


function getPractitioner2(obj,target)
{
	var spec_code="";
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var practitioner_type="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	
	var FirstSql="";
	var SecondSql="";
	var facility_id=document.forms[0].facility_id.value;
    var	clinic_code			=	document.forms[0].clinic_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var p_desc	=	document.forms[0].practitioner_desc.value;
	
	

	if (p_desc==null) p_desc = "";
	var open_to_all_pract_yn= "";
	var open_to_all_prac_for_clinic_yn="";
	
	
		if (document.forms[0].clinic_code.value.length>0)
		{
			
			open_to_all_pract_yn=	openToAllPractionerYN[document.forms[0].clinic_code.selectedIndex];
			spec_code=specialtyForClinc[document.forms[0].clinic_code.selectedIndex]	;	

		}
		else
		{
			open_to_all_pract_yn=	"Y";
		}

		
		if (document.forms[0].treatment_area_code.value.length>0)
		{
			open_to_all_prac_for_clinic_yn=	openToAllPractionerYN[document.forms[0].treatment_area_code.selectedIndex];
		}
		else
		{
			open_to_all_prac_for_clinic_yn=	"Y";
		}
       getPractitioner(obj, target, facility_id, spec_code,practitioner_type, "Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);

 /*if(clinic_code!="") {
   if(!treatment_area_code!="") {
		if(open_to_all_prac_for_clinic_yn=='N') { 
		  
		   
		  FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,ae_pract_for_tmt_area_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";		
		
		
		} else  if(open_to_all_pract_yn=='Y') {
		
		FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";
		}
			else {
			
			
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type, a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";
			
			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type, a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			
			}
   }else {  if(open_to_all_pract_yn=='Y') {
   
   FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";
   
   }
			else{
			FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type, a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type, a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E'  and a.facility_id = b.facility_id and b.facility_id= '"+facility_id+"' and b.clinic_code = '"+clinic_code+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";
		
			}
		  }
} else 
        {

        FirstSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";

			SecondSql="select distinct a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1) practitioner_name,a.pract_type_desc practitioner_type,a.job_title job_title,a.gender,a.primary_splty_short_desc primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id))and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+localeName+"',1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ORDER BY 2";
		 
		 }
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +escape(practName_FName)+ "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + escape(spec_code)+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
}
/***********************************/

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (objName=="practitioner_desc")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner_id.value	=	arr[0];
			document.forms[0].practitioner_desc.value		=	arr[1];			
		}
		else
		{
			document.forms[0].practitioner_id.value	=	"";
			document.forms[0].practitioner_desc.value		=	"";			
		}
	}
	
}


function changeCase(obj)
   {
	  obj.value=obj.value.toUpperCase();
   }
function callfocus()
{
	document.forms[0].clinic_code.focus();
}

function onMMove(obj,e,brought_dead,brought_dead_yn)
	{
		
		if(brought_dead_yn=="Y"){
		var brought_dead;
		obj.style.left=e.x+20;
		obj.style.top=e.y;
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;

		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+brought_dead+"</td></tr></table>";
		}
		else
			return false;
	}
function onMOut(obj,brought_dead_yn)
	{
		if(brought_dead_yn=="Y"){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
	}

function doDate(obj){
	if(obj.value!=''){
if(isBeforeNow(obj.value,"DMYHM",localeName))
	return true;
else {
alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
obj.select();
return false ;
	 }
	}
}

