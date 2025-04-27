// Added/Modified by Nanda - 11/8/2002
// Depending upon the Button clicked, Call the respective JSP File
function callFunction(obj)
{
	 clinic_code			= document.forms[0].clinic_code.value;
	 clinic_type			= document.forms[0].clinic_type.value;
	 clinic_desc			= document.forms[0].clinic_desc.value;
	 
     patient_id				= document.forms[0].patient_id.value;
     treatment_area_code	= document.forms[0].treatment_area_code.value;
	 encounter_id			= document.forms[0].encounter_id.value;
	 queue_status			= document.forms[0].queue_status.value;
	 treatment_area_desc	= document.forms[0].treatment_area_desc.value;
	 orig_tmt_area_code	= document.forms[0].orig_tmt_area_code.value;
		query_string = document.forms[0].queryString.value

		if(obj.name=='ae_details')
		 {	
			parent.frames[3].location.href = '../../eAE/jsp/AETriageDetails.jsp?clinic_code='+clinic_code+'&clinic_type='+clinic_type+'&patient_id='+patient_id+'&treatment_area_code='+treatment_area_code+'&encounter_id='+encounter_id+'&queue_status='+queue_status+'&treatment_area_desc='+escape(treatment_area_desc)+'&clinic_desc='+escape(clinic_desc)+'&'+query_string;
		 } 
        else if(obj.name=='triage')
		 {	
			parent.frames[3].location.href = '../../eAE/jsp/AETriageDetailsMain.jsp?clinic_code='+clinic_code+'&clinic_type='+clinic_type+'&patient_id='+patient_id+'&orig_tmt_area_code='+orig_tmt_area_code+'&treatment_area_code='+treatment_area_code+'&encounter_id='+encounter_id+'&queue_status='+queue_status+'&treatment_area_desc='+escape(treatment_area_desc)+'&clinic_desc='+escape(clinic_desc)+'&call_function=TRIAGE'+'&'+query_string;;
		 } 
 } // End of callFunction

// For Triage Details
 function reseting()
 {
	 parent.frames[3].document.forms[0].reset();
	 top.messageframe.document.forms[0].reset();
 }

 function onSuccess() 
 {
	 document.location.reload();
 }


 // For Triage Result Function
 function resetingTriageResult()
 {
		treatment_area_desc	= document.forms[0].treatment_area_desc.value;
		clinic_desc			= document.forms[0].clinic_desc.value;
		clinic_code			= document.forms[0].location_code.value;
		treatment_area_code = document.forms[0].treatment_area_code.value;
		orig_tmt_area_code	= document.forms[0].orig_tmt_area_code.value;
		encounter_id		= document.forms[0].encounter_id.value;
		queue_status		= document.forms[0].queue_status.value;
		patient_id			= document.forms[0].patient_id.value;
		CA						= document.forms[0].hdnCA.value ;
		parent.frames[1].location.href="../../eAE/jsp/AETriageDetailsResult.jsp?operation=INSERT&CA="+CA+"&Patient_ID="+patient_id+"&queue_status="+queue_status+"&encounter_id="+encounter_id+"&orig_tmt_area_code="+orig_tmt_area_code+"&treatment_area_code="+treatment_area_code+"&clinic_code="+clinic_code+"&treatment_area_desc="+escape(treatment_area_desc)+"&clinic_desc="+escape(clinic_desc);
 }

 // For Triage Result Function, when clicking the dates
 function callDate(start_date_time,encounter_id,treatment_area_code,orig_tmt_area_code)
 {
		//treatment_area_code = document.forms[0].treatment_area_code.value;
		query_string = document.forms[0].queryString.value
		clinic_code = document.forms[0].clinic_code.value;
		parent.frames[1].location.href="../../eAE/jsp/AETriageDetailsResult.jsp?treatment_area_code="+treatment_area_code+"&clinic_code="+clinic_code+"&triage_start_date_time="+start_date_time+"&encounter_id="+encounter_id+"&orig_tmt_area_code="+orig_tmt_area_code+"&operation=UPDATE&"+query_string;
 }
 
 function AECheckNum(Obj)
 {
	if (CheckNum(Obj))
	{
		putDecimal(Obj,5,2);
	}
 }


// For Triage Function
function recordTriage()
{
           parent.f_query_add_mod.ae_triage_details_form.document.forms[0].submit();
}

// For Triage Result
function summa()
{
		if(parent.frames[1].document.forms[0].mode.value=="INSERT")
		{	
				var fields = new Array (parent.frames[1].document.forms[0].start_date_time,
										parent.frames[1].document.forms[0].end_date_time,
										parent.frames[1].document.forms[0].priority
										);
        
				var names = new Array (getLabel("Common.startdatetime.label","Common"),getLabel("Common.enddatetime.label","Common"),getLabel("Common.priority.label","Common"));	
				if(parent.frames[1].checkFields( fields, names, parent.parent.messageframe))
				 {
					if(trimCheck(parent.frames[1].document.forms[0].nurse.value)==false &&
					trimCheck(parent.frames[1].document.forms[0].physician.value)==false)
					{
					parent.parent.messageframe.location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("AE_NUR_PHY_BLANK",'AE');
					}
					else
					 {
					 parent.frames[1].document.forms[0].submit();
					 }
				 }
		} // end of insert

}
function recordTriageResult()
{
		if(parent.frames[1].document.forms[0].mode.value=="INSERT")
		{	
			var fields = "";
			var names = "";
				if(trimCheck(parent.frames[1].document.forms[0].physician.value) || trimCheck(parent.frames[1].document.forms[0].nurse.value)) {
					var fields = new Array (parent.frames[1].document.forms[0].start_date_time,
										parent.frames[1].document.forms[0].end_date_time,
										parent.frames[1].document.forms[0].priority
									);
						var names = new Array (getLabel("Common.startdatetime.label","Common"),getLabel("Common.enddatetime.label","Common"),getLabel("Common.priority.label","Common"));	
				}
				else {
					if(trimCheck(parent.frames[1].document.forms[0].physician.value)) {
						var fields = new Array (parent.frames[1].document.forms[0].start_date_time,
										parent.frames[1].document.forms[0].end_date_time,
										parent.frames[1].document.forms[0].priority,
										parent.frames[1].document.forms[0].physician
									);
						var names = new Array (getLabel("Common.startdatetime.label","Common"),getLabel("Common.enddatetime.label","Common"),getLabel("Common.priority.label","Common"),"Both Physician and Nurse");	
					}
					else {
						var fields = new Array (parent.frames[1].document.forms[0].start_date_time,
										parent.frames[1].document.forms[0].end_date_time,
										parent.frames[1].document.forms[0].priority,
										parent.frames[1].document.forms[0].nurse
									);
						var names = new Array (getLabel("Common.startdatetime.label","Common"),getLabel("Common.enddatetime.label","Common"),getLabel("Common.priority.label","Common"),"Both Physician and Nurse");	
					}
				}
				//alert(parent.parent.parent.parent.frames[5].name)
				if(parent.frames[1].checkFields( fields, names, top.messageframe))
				{
					
					var priority = parent.frames[1].document.forms[0].priority.value.split("|");
					var priority_ind = '';
					parent.frames[1].document.forms[0].priority_val.value = priority[0];
					parent.frames[1].document.forms[0].priority_ind.value = priority[1];
					switch (parent.frames[1].document.forms[0].priority_ind.value)
					{   
						case '1' :	priority_ind = 'R';break;   
						case '2' :	priority_ind = 'E';break;
						case '3' :	priority_ind = 'U';break;
						case '4' :	priority_ind = 'S';break;
						case '5' :	priority_ind = 'N';break;
					}
					parent.frames[1].document.forms[0].priority_ind.value = priority_ind;
					//alert(parent.frames[1].document.forms[0].priority_val.value+"|"+parent.frames[1].document.forms[0].priority_ind.value);
					parent.frames[1].document.forms[0].recording.disabled = true;
					parent.frames[1].document.forms[0].submit();
				}
		} // end of insert
}  // end of recordTriageResult

// For Incident Remarks Details
async function callIncidentRemarks()
{
       var retVal;
	   var dialogHeight = "12vh" ;
	   var dialogWidth  = "24vw" ;
	   var dialogTop    = "230";
	   var dialogLeft   = "230";
	   var arguments	= document.forms[0].incident_Remarks_val.value;
	   var disabled;
	   if(arguments==null || arguments=='') 
		   arguments='';
	   var disabledField= document.forms[0].disabledField.value;
	   if(disabledField=="YES")
		 disabled = 'readOnly';
	   var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	   retVal =await window.showModalDialog("../../eAE/jsp/AERegisterMLCDetails.jsp?call_from=IR&disabled="+disabled,arguments,features);

	   if(!((retVal==null) || (retVal=='')) )
		{
		   document.forms[0].incident_Remarks_val.value=retVal;
		}
}  

  
   function changeCase(obj)
   {
	  obj.value=obj.value.toUpperCase();
   }
    
	 function chkValue(obj)
     {
		  if(obj.checked==true)
		   {
				obj.checked=true;
				obj.value='Y';
		   }
		  else
		   {
				obj.checked=false;
				obj.value='N';
		   }
   }

// Function to check the Date and Time is valid or not
function checkTiming(obj)
{

	if (obj.value.length==14 && (obj.value.substring(13,14)==':'))
	{
		obj.value=obj.value + '00';
	}

    if(obj.value!='')
	 {
		if(monthcheck(obj)==false || doDateTimeChk(obj) == false)
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
			obj.focus();
		}
		else
		{ 
/*			alert(document.forms[0].visit_adm_date_time.value);
			alert(document.forms[0].start_date_time.value);
			alert(document.forms[0].start_date_time.value);
			alert(document.forms[0].sysdate.value);
*/
	
			if(ValidateDateTime(document.forms[0].visit_adm_date_time,document.forms[0].start_date_time,'V')==false)
			{
					obj.focus();
			}
			else if(ValidateDateTime(document.forms[0].start_date_time,document.forms[0].sysdate,'V')==false)
			{
				    obj.focus();
			}
			else
			{
				if(document.forms[0].end_date_time.value!='')	
				{
					if(ValidateDateTime(document.forms[0].start_date_time,document.forms[0].end_date_time,'S')==false)
					{
					    obj.focus();
					}
				}	
			} 
		}
	 } // end of obj.value
}

// for the End Date Time
function checkEndTiming(obj)
{

	if (obj.value.length==14 && (obj.value.substring(13,14)==':'))
	{
		obj.value=obj.value + '00';
	}

    if(obj.value!='')
	 {
		if(monthcheck(obj)==false || doDateTimeChk(obj) == false) 
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
			obj.focus();
		}
		else
		{
          if(document.forms[0].start_date_time.value!='')
			{  
				if(ValidateDateTime(document.forms[0].start_date_time,document.forms[0].end_date_time,'E')==false)
			    {
				    obj.focus();
			    }
				else if(ValidateDateTime(document.forms[0].end_date_time,document.forms[0].sysdate,'E')==false)
				{
				    obj.focus();
				}
			}
           else 
					document.forms[0].start_date_time.focus();
  		} 
	 } // end of obj.value
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

// Function to check the From Date is lesser than to Date
function ValidateDateTime (from,to,mess)
{
	fromobj = from;

	from	= from.value;
	to		= to.value;
//alert(Date.parse(from) );
//alert(Date.parse(to) );

  if (Date.parse(from) && Date.parse(to))
  {
	var a=  from.split(" ");
	splitdate=a[0];
	splittime=a[1];
	var splitdate1 =a[0].split("/");
	var splittime1= a[1].split(":");

	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1];

	splitdate1 =a[0].split("/");
	splittime1= a[1].split(":");
    
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));
    
	if(Date.parse(to_date) < Date.parse(from_date))
	{
		//msgframe.location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT")
		       if(mess=='V')
				{
					alert(getMessage("AE_TRIAGE_START_DATE_TIME",'AE'));
					document.forms[0].start_date_time.focus();
					document.forms[0].end_date_time.disabled=true;
					return false;
				}
			   else if(mess=='T')
		        {
					alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
					document.forms[0].start_date_time.focus();
					document.forms[0].end_date_time.disabled=true;
					return false;
				}
			   else if(mess=='E')
		        {
					alert(getMessage("AE_TRIAGE_END_DATE_TIME",'AE'));
					document.forms[0].end_date_time.focus();
					document.forms[0].start_date_time.disabled=true;
					return false;
				}
			   else 
		        {
					alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
					document.forms[0].end_date_time.focus();
					document.forms[0].start_date_time.disabled=true;
					return false;
				}
	}
	else
	{
		document.forms[0].start_date_time.disabled=false;
		document.forms[0].end_date_time.disabled=false;
		return true;
	}
  }
  else
	{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			
			if (mess=='V' || mess=='T')
			{
				document.forms[0].start_date_time.focus();
			}
			else
			{
				document.forms[0].end_date_time.focus();
			}

			return false;
	}
}

function setDoneDuring(obj)
{
	if(obj.checked == true)
	{
			document.forms[0].done_during_val.readOnly = false;
	}
	else
	{
			document.forms[0].done_during_val.readOnly = true;
			document.forms[0].done_during_val.value = '';
	}
}

function CheckSysdate(from,to,obj) {
  if(obj.value!='')
	 {
		if(CheckDate(obj)==true) {
			ValidateSysDate(from,to,obj);
		}
	 }
}
function ValidateSysDate(from,to,obj)
{
	from	= from.value;
	to		= to.value;

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1];
	var splitdate1 =a[0].split("/");
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
    a=  to.split(" ");
	splitdate=a[0];
	splittime=a[1];

	splitdate1 =a[0].split("/");
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
    if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage("AE_LMP_DATE_CHECK",'AE'));
		obj.select();
		obj.focus();
		return false;
	}
	else
		return true;
}

async function TriagepopulatePractitioners()
{
	var	clinic_code			=	document.forms[0].location_code.value;
	var practitioner_id		=	document.forms[0].practitioner_id.value;
	var treatment_area_code	=	document.forms[0].treatment_area_code.value;
	var open_to_all_pract_yn=   document.forms[0].open_to_all_pract_yn.value;
	var open_to_all_prac_for_clinic_yn = document.forms[0].open_to_all_prac_for_clinic_yn.value;

	if (open_to_all_pract_yn=='Y')
	{
		open_to_all_prac_for_clinic_yn = 'Y';
	}
	
	var facility_id			=	document.forms[0].facilityId.value;

/*	alert('clinic_code ' + clinic_code);
	alert('practitioner_id ' + practitioner_id);
	alert('treatment_area_code ' + treatment_area_code);
	alert('open_to_all_pract_yn ' + open_to_all_pract_yn);
	alert('open_to_all_prac_for_clinic_yn ' + open_to_all_prac_for_clinic_yn);
*/
	var sql="";
/* */
		if(open_to_all_pract_yn=="Y")
			{
				if(open_to_all_prac_for_clinic_yn=="Y")
				{
					sql	=	" Select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id = `"+facility_id+"` and eff_status = `E` and pract_type in (`MD`, `SG`, `PS`, `DN`) ";

				}
				else if(treatment_area_code.length==0)
				{
					sql	=	" select distinct practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and eff_status = `E` and pract_type = in (`MD`, `SG`, `PS`, `DN`) ";
				}
				else
				{
					sql	=	" select practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and treatment_area_code = `"+treatment_area_code+"` and eff_status = `E` and pract_type in (`MD`, `SG`, `PS`, `DN`) ";
				}
			}

			else
			{
				if(open_to_all_prac_for_clinic_yn=="Y")
				{
//					sql	=	" Select practitioner_id, practitioner_short_name as practitioner_name from op_pract_for_clinic_vw where facility_id = `"+facility_id+"` and clinic_code =`"+clinic_code+"` and em_visit_type_appl_yn =`Y` and eff_status = `E` ";

					sql = "select  distinct op_pfc.practitioner_id practitioner_id, am_practitioner.practitioner_name from op_clinic oc ,sm_facility_param fcl_param, op_pract_for_clinic op_pfc, am_practitioner am_practitioner  where op_pfc.facility_id=fcl_param.facility_id and op_pfc.clinic_code=oc.clinic_code and op_pfc.facility_id=oc.facility_id and op_pfc.practitioner_id=am_practitioner.practitioner_id and op_pfc.facility_id = `"+facility_id+"` and op_pfc.clinic_code= `"+clinic_code+"` and op_pfc.em_visit_type_appl_yn =`Y` and op_pfc.eff_status = `E` and am_practitioner.pract_type in (`MD`, `SG`, `PS`, `DN`) ";
				}
				else if(treatment_area_code.length==0)
				{
					sql	=	" select distinct practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and eff_status = `E` and pract_type in (`MD`, `SG`, `PS`, `DN`)";
				}
				else
				{
					sql	=	" select practitioner_id, practitioner_name from ae_pract_for_tmt_area_vw where facility_id = `"+facility_id+"` and clinic_code = `"+clinic_code+"` and treatment_area_code = `"+treatment_area_code+"` and eff_status = `E`  and pract_type in (`MD`, `SG`, `PS`, `DN`) ";

				}
			}
//alert(sql);

	var target				= document.forms[0].physician_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "10vh" ;
	var dialogWidth			= "40vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc="";
	var tit="";

	search_code="practitioner_id";
	search_desc="practitioner_name";
	tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("::");
			document.forms[0].physician_desc.value=arr[0];
			document.forms[0].physician.value=arr[1];
			//document.forms[0].practitioner_desc.focus();
		}
		else
		{
			document.forms[0].physician_desc.value="";
			document.forms[0].physician.value="";
		}
	}
	else
	{
		//target.focus();
	}

}
function TriagecallCheckMaxLen(obj,noOfChars,Legend)
{
	if(CheckMaxLen(Legend,obj,noOfChars,parent.parent.messageframe)==false)
	{
		
	//	parent.frames[2].document.getElementById("tab2").scrollIntoView();
		obj.focus();
		return false;
	}
	else
	{
		top.messageframe.location.href='../../eCommon/jsp/error.jsp';
		return true;
	}
}
