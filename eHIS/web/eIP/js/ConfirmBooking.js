function create()
{
 f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBooking.jsp" ;
}
 
function chkInsure() 
{
	var patId  = parent.frames[1].document.confirmbooking_form.patient_id.value;
	//var prefDt = parent.frames[1].document.confirmbooking_form.pref_adm_date.value
	var prefDt = convertDate(parent.frames[1].document.revisebooking_form.pref_adm_date.value,"DMYHM",localeName,"en");

	var arr = new Array();
	arr = prefDt.split("/");
	var newPrefDt = arr[2]+"-"+arr[1]+"-"+arr[0];
	var HTMLVal = new String();
	var HTMLVal1 = new String(); 
	if( (patId != "" || patId !=null) && (prefDt != "" || prefDt !=null) ) 
	{
		HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='InsureChk' id='InsureChk' method='post' action='../../eIP/jsp/BookingInsuranceCheck.jsp' messageFrame><input name='patId' id='patId' type='hidden' value='"+patId+"'><input name='prefDt' id='prefDt' type='hidden' value='"+newPrefDt+"'></form></BODY></HTML>";
		messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		messageFrame.document.InsureChk.submit();
	}
	else 
	{
		callApply()
	}
}
 
function apply()
{ 
	/*var retFlag = false;

	if (doOTDateTimeChk2(parent.frames[1].document.confirmbooking_form.ot_date_time))
	retFlag = true;

	if(retFlag)
	{*/
		callApply();
		returnVal(); 
	/*}
	else
	{
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
	}*/
}
 
function  callApply_bl() 
{ 

 
 var fields=new Array();
 
 fields[0]= f_query_add_mod.document.confirmbooking_form.pref_adm_date;
 fields[1]= f_query_add_mod.document.confirmbooking_form.med_service_grp;
 fields[2]= f_query_add_mod.document.confirmbooking_form.sex;
 fields[3]= f_query_add_mod.document.confirmbooking_form.date_of_birth;
 fields[4]= f_query_add_mod.document.confirmbooking_form.practid1;
 fields[5]= f_query_add_mod.document.confirmbooking_form.Splcode;
 
 var names = new Array ( getLabel("eIP.PreferredAdmissionDate.label","IP"),
             getLabel('eIP.MedicalServiceGroup.label','IP'),
    getLabel('Common.gender.label','common'),
    getLabel('Common.birthDate.label','common'),
    getLabel("Common.practitioner.label","Common"),
    getLabel('Common.speciality.label','common')
          );
        var p = 6;
 
 if (!f_query_add_mod.document.confirmbooking_form.booking_ref_no.disabled)
 {
      fields[p]= f_query_add_mod.document.confirmbooking_form.booking_ref_no;
      names[p] = getLabel("Common.BookingRefNo.label","Common");
      p++;
    }
 if (f_query_add_mod.document.confirmbooking_form.fid)
 {
      fields[p]= f_query_add_mod.document.confirmbooking_form.first_name;
      names[p]= f_query_add_mod.document.confirmbooking_form.First_Name_Prompt.value;
      p++;    
 }
 

 if (f_query_add_mod.document.confirmbooking_form.sid)
 {
   fields[p]= f_query_add_mod.document.confirmbooking_form.second_name;
   names[p]= f_query_add_mod.document.confirmbooking_form.Second_Name_Prompt.value;
   p++;    
 }
 
 if (f_query_add_mod.document.confirmbooking_form.tid)
 {
   fields[p]= f_query_add_mod.document.confirmbooking_form.third_name;
   names[p]=  f_query_add_mod.document.confirmbooking_form.Third_Name_Prompt.value;
   p++;    
 }
 
 if (f_query_add_mod.document.confirmbooking_form.faid)
 {
   fields[p]= f_query_add_mod.document.confirmbooking_form.family_name;
   names[p]=  f_query_add_mod.document.confirmbooking_form.Family_Name_Prompt.value;
   p++;    
 }
 
 
 var condition;
 for(var j=0; j<f_query_add_mod.document.confirmbooking_form.elements.length; j++)
 {
  condition+= f_query_add_mod.document.confirmbooking_form.elements[j].name +"="+ f_query_add_mod.document.confirmbooking_form.elements[j].value+"&"
 }
 

  HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../servlet/eIP.ReviseBookingServlet?"+condition+"'</form></body></html>";
  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
  parent.messageFrame.document.dum_form.submit();
  
}
 
function  callApply()  
{    
	/*if(parent.frames[1].document.confirmbooking_form.name_prefix1)
	parent.frames[1].document.confirmbooking_form.name_prefix1.value=document.confirmbooking_form.name_prefix1.value;
	if(parent.frames[1].document.confirmbooking_form.name_suffix1)
	parent.frames[1].document.confirmbooking_form.name_suffix1.value=document.confirmbooking_form.name_suffix1.value;
*/
	if(parent.frames[1].document.confirmbooking_form.name_prefix)
	parent.frames[1].document.confirmbooking_form.name_prefix.value=document.confirmbooking_form.name_prefix.value;
	if(parent.frames[1].document.confirmbooking_form.name_suffix)
	parent.frames[1].document.confirmbooking_form.name_suffix.value=document.confirmbooking_form.name_suffix.value;

	var fields=new Array();

	fields[0]= parent.frames[1].document.confirmbooking_form.pref_adm_date;
	fields[1]= parent.frames[1].document.confirmbooking_form.med_service_grp;
	fields[2]= parent.frames[1].document.confirmbooking_form.sex;
	fields[3]= parent.frames[1].document.confirmbooking_form.date_of_birth;
	queryString =  parent.frames[1].document.confirmbooking_form.queryString.value;
	var names = new Array (getLabel("eIP.PreferredAdmissionDate.label","IP"),
	getLabel('eIP.MedicalServiceGroup.label','IP'),
	getLabel('Common.gender.label','common'),
	getLabel('Common.birthDate.label','common')     );
	var p = 4;


	if (!parent.frames[1].document.confirmbooking_form.booking_ref_no.disabled)
	{
		fields[p]= document.confirmbooking_form.booking_ref_no;
		names[p] =  getLabel("Common.BookingRefNo.label","Common");
		p++;
	}

	if (parent.frames[1].document.confirmbooking_form.fid)
	{
		fields[p]= document.confirmbooking_form.first_name;
		names[p]= document.confirmbooking_form.First_Name_Prompt.value;
		p++;    
	}


	if (parent.frames[1].document.confirmbooking_form.sid)
	{
	fields[p]= document.confirmbooking_form.second_name;
	names[p]= document.confirmbooking_form.Second_Name_Prompt.value;
	p++;    
	}

	if (document.confirmbooking_form.tid)
	{
	fields[p]= document.confirmbooking_form.third_name;
	names[p]= document.confirmbooking_form.Third_Name_Prompt.value;
	p++;    
	}

	if (document.confirmbooking_form.faid)
	{
	fields[p]= document.confirmbooking_form.family_name;
	names[p]= document.confirmbooking_form.Family_Name_Prompt.value;
	p++;    
	}


	if(document.confirmbooking_form.bed_no == null ||
	document.confirmbooking_form.bed_no.value !="")
	{
	fields[p]=document.confirmbooking_form.practid_desc;
	names[p]=getLabel("Common.practitioner.label","Common");
	p++;
	}
//For 17676 
	if(document.confirmbooking_form.race_required_yn.value == 'Y')
	{
		  	if(document.confirmbooking_form.race_code !=null &&
			  document.confirmbooking_form.race_code.value =="")
			{
				fields[p]=document.confirmbooking_form.race_code;
				names[p] = getLabel("Common.race.label","Common");
				p++;
			}
	}
	var messageFrame = parent.frames[2];
	if(checkFields( fields, names, messageFrame))
	{
		var bedNum = document.confirmbooking_form.bed_no.value;
		
		if(bedNum != "")
		{
			var roomNum = document.confirmbooking_form.room_no.value;
			if(roomNum != "")
			{
			    /* below condition added by Venkatesh.S (4008) on 04/June/2012 against ML-BRU-SCF-0227 [IN033111]*/
				if (document.confirmbooking_form.name_prefix != undefined){ 
		        document.confirmbooking_form.name_prefix.disabled=false;}
				/*Fix End for ML-BRU-SCF-0227 [IN033111] */
				document.confirmbooking_form.sex.disabled=false;
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
				document.confirmbooking_form.service.disabled=false;
				document.confirmbooking_form.bed_type_desc.disabled=false;
				document.confirmbooking_form.bed_no.disabled=false;
				document.confirmbooking_form.room_no.disabled=false;
				//document.confirmbooking_form.submit();
			}
			else
			{
				var msg = getMessage("CAN_NOT_BE_BLANK",'common');
				msg = msg.replace('$', getLabel('Common.roomno.label','common'));
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				return false
			}
		}
		else
		{
			/* below condition added by Venkatesh.S (4008) on 04/June/2012 against ML-BRU-SCF-0227 [IN033111]*/
				if (document.confirmbooking_form.name_prefix != undefined){ 
		        document.confirmbooking_form.name_prefix.disabled=false;}
				/*Fix End for ML-BRU-SCF-0227 [IN033111] */
			document.confirmbooking_form.sex.disabled=false;
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
		}

		if(document.confirmbooking_form.bl_success.value=='N')
			{
				if(document.confirmbooking_form.isBlInstalled.value == 'Y' && document.confirmbooking_form.iscapture_fin_dtls_yn.value == 'Y')
				{
						messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
						
						/* below condition added by Venkatesh.S (4008) on 04/June/2012 against ML-BRU-SCF-0227 [IN033111]*/
				         if (document.confirmbooking_form.name_prefix != undefined){ 
		                 document.confirmbooking_form.name_prefix.disabled=false;}
				         /*Fix End for ML-BRU-SCF-0227 [IN033111] */
				        document.confirmbooking_form.sex.disabled=true;

						return false;
						
				}
			}
		enableField();		
		document.confirmbooking_form.action="../../servlet/eIP.ConfirmBookingServlet";
		if(parent.dummyFrame)
		{
			document.confirmbooking_form.target="dummyFrame";
			document.confirmbooking_form.submit();
		}
		else{
			document.confirmbooking_form.submit();
		}
		
		if(document.confirmbooking_form.practid_desc.value != "")
			document.confirmbooking_form.practid_desc.disabled=true;
		if(document.forms[0].bed_no.value !="")
		{
			document.forms[0].bed_no.disabled				= true;
			document.forms[0].Bedcode.disabled				= true;
			document.forms[0].service.disabled				= true;
			document.forms[0].bed_type_desc.disabled		= true;
			document.forms[0].nursing_unit_desc.disabled	= true;
			document.forms[0].nursing_unit_lookup.disabled	= true;
			document.forms[0].room_no.disabled				= true;
			document.forms[0].override.disabled				= true;
			document.forms[0].bed_avail_chart.disabled		= true;
		}
		disableField();
	}
	window.setTimeout("callHomeDisabled()",10);
}

function enableField()
{
	document.confirmbooking_form.sex.disabled = false;
	if(document.confirmbooking_form.name_prefix != null) 
		document.confirmbooking_form.name_prefix.disabled=false;

	if(document.confirmbooking_form.nationality_code1 != null)
		document.confirmbooking_form.nationality_code1.disabled = false;
		document.confirmbooking_form.date_of_birth.disabled=false;
	if(document.confirmbooking_form.name_suffix != null)
		document.confirmbooking_form.name_suffix.disabled=false;

		document.confirmbooking_form.patient_name.disabled=false;
	if(document.confirmbooking_form.alt_id1_no != null)
		document.confirmbooking_form.alt_id1_no.disabled=false;
		document.confirmbooking_form.team_id.disabled=false;
		document.confirmbooking_form.patient_id.disabled=false;
 
		document.confirmbooking_form.pref_adm_date.disabled = false;
		document.confirmbooking_form.exp_days_of_stay.disabled = false;
		document.confirmbooking_form.ot_date_time.disabled = false;
	if(document.confirmbooking_form.nursing_unit_desc != null)
		document.confirmbooking_form.nursing_unit_desc.disabled = false;
	if(document.confirmbooking_form.nursing_unit_lookup != null)
		document.confirmbooking_form.nursing_unit_lookup.disabled = false;
	if(document.confirmbooking_form.service != null)
		document.confirmbooking_form.service.disabled = false;
	if(document.confirmbooking_form.practid_desc != null)
		document.confirmbooking_form.practid_desc.disabled = false;
	if(document.confirmbooking_form.Bedcode != null)
		document.confirmbooking_form.Bedcode.disabled = false;
	if(document.confirmbooking_form.bed_type_desc != null)
		document.confirmbooking_form.bed_type_desc.disabled = false;
 /*Friday, December 11, 2009 SRR20056-SCF-3859 IN016433 Beta re-open (IN017212)*/
	if(document.confirmbooking_form.bed_no != null)
	{
		document.confirmbooking_form.bed_avail_chart.disabled = false;
	}
/**/
}
function disableField()
{
 document.confirmbooking_form.sex.disabled = true;
  if(document.confirmbooking_form.name_prefix != null) 
  document.confirmbooking_form.name_prefix.disabled=true;

 if(document.confirmbooking_form.nationality_code1 != null)
  document.confirmbooking_form.nationality_code1.disabled = true;
 document.confirmbooking_form.date_of_birth.disabled=true;
  if(document.confirmbooking_form.name_suffix != null)
  document.confirmbooking_form.name_suffix.disabled=true;

 document.confirmbooking_form.patient_name.disabled=true;
 if(document.confirmbooking_form.alt_id1_no != null)
  document.confirmbooking_form.alt_id1_no.disabled=true;
 document.confirmbooking_form.team_id.disabled=true;
 document.confirmbooking_form.patient_id.disabled=true;
 
 document.confirmbooking_form.pref_adm_date.disabled = true;
 document.confirmbooking_form.exp_days_of_stay.disabled = true;
 document.confirmbooking_form.ot_date_time.disabled = true;
}
 
function callHomeDisabled()
{
}
function reset()
{ 
 var bkg_lst_ref_no = parent.frames[1].document.forms[0].bkg_lst_ref_no.value;
  parent.frames[1].document.location.href="../../eIP/jsp/AddModifyConfirmBooking.jsp?bkg_lst_ref_no="+bkg_lst_ref_no;
}
 

function onSuccess()
{
	
 window.setTimeout("callHomeDisabled()",100);
}
 

function ChangeVal(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	var obj_value  = obj.value;
	var source_type = "";
	var nursunitcode=  parent.frames[1].document.forms[0].nursing_unit.value;

	if (obj.name == "med_service_grp")
	{
		var strDateArray = new Array();
		var gennum;
		var medcode;
		strDateArray = obj_value.split("#");

		medcode = strDateArray[0];
		gennum  = strDateArray[1];

		if(gennum == "Y")
		{
			parent.frames[1].document.forms[0].generatenumyn.value='Y';
			parent.frames[1].document.forms[0].gifpop.style.visibility="hidden";
		}
		else
		{
			parent.frames[1].document.forms[0].booking_ref_no.value="";
			parent.frames[1].document.forms[0].generatenumyn.value='N';
			parent.frames[1].document.forms[0].gifpop.style.visibility="visible";
		}

		source_type = "VAL_MED_GRP";
		var medservcode= medcode;
	}
	else
	{
		source_type = "VAL_DATE";
	}

	if (obj.name == "pref_adm_date")
	{
		var prefadmdate= obj_value;
		prefadmdate=parent.frames[1].document.forms[0].pref_adm_date.value;
		 prefadmdate = convertDate(prefadmdate,"DMYHM",localeName,"en");
	}

	if (obj.name == "amVal")
	{
		var amVal=parent.frames[1].document.forms[0].amVal.value;
		prefadmdate=parent.frames[1].document.forms[0].pref_adm_date.value;
		 prefadmdate = convertDate(prefadmdate,"DMYHM",localeName,"en");
	}

	if (obj.name == "bed_no")
	{
		var bed_no= obj_value;
		bed_no=parent.frames[1].document.forms[0].bed_no.value
		source_type="CONFIRM_VAL_ROOM_NO";
	}

	if (obj_value != null && obj_value != "")
	{
		var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetchvalforbooking' id='fetchvalforbooking' method='post' action='../../eIP/jsp/FetchValForBooking.jsp'><input type='hidden' name='med_service_grp' id='med_service_grp' value='"+medservcode+"'><input type='hidden' name='source_type' id='source_type' value='"+source_type+"'><input type='hidden' name='pref_adm_date' id='pref_adm_date' value='"+prefadmdate+"'><input type='hidden' name='amVal' id='amVal' value='"+amVal+"'><input type='hidden' name='bed_no' id='bed_no' value='"+bed_no+"'><input type='hidden' name='nursunitcode' id='nursunitcode' value='"+nursunitcode+"'>";
		HTMLVal = HTMLVal+"</form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.fetchvalforbooking.submit();
	}

	if ((obj.name == "bed_no") && (obj_value == null || obj_value == ""))
	{
		parent.frames[1].document.forms[0].pract_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].bed_no.value="";
		parent.frames[1].document.forms[0].room_no.value="";
	}
}
 
function validateDate(obj,val)
{
 var prefDate1 = self.confirmbooking_form.pref_adm_date.value;
 var prefDate = prefDate1 + ' 00:00';
 var OTtime = obj.value.substring(0,10);
 if(obj.value != ''  || obj.value.length > 0)
 {
    if(doDatetimeCheckAlert(prefDate,OTtime))
    {       
      alert(getMessage("INVALID_OT_DATE",'IP'));
      obj.focus();
      obj.select();   
    }
    else
    { 
     if(self.doDateTimeChk(obj))
        {
        
    if(val == 'A')
     {
         var currdate = self.document.confirmbooking_form.currdate;
         if(ValidateDateTime(obj,currdate))
     {
      alert(parent.parent.parent.frames[0].getMessage("FUTURE_DATE_NOT_ALLOWED",'IP'));
      obj.focus();
      obj.select();
    }
     }
  }
       else
  {
   alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"));
   obj.focus();
   obj.select();
  }
  }
 }//E.O.IF
}
 
 
 

function validateDate(obj,val)
{
 var prefDate  = self.confirmbooking_form.pref_adm_date.value;
 var OTtime = obj.value.substring(0,10);
 

 if(obj.value != ''  || obj.value.length > 0)
 {
 
 if(doDatetimeCheckAlert(prefDate,OTtime))
 {
  alert(getMessage("INVALID_OT_DATE",'IP'));
  obj.focus();
  obj.select();
 }
 else
 {
 
  if(self.doDateTimeChk(obj))
  {
   if(val == 'A')
   {
    var currdate = self.document.confirmbooking_form.currdate;
    if(ValidateDateTime(obj,currdate))
    {
     alert(getMessage("FUTURE_DATE_NOT_ALLOWED",'IP'));
     obj.focus();
     obj.select();
    }
   }
  }
  else
  {
   alert(getMessage("INVALID_DATE_TIME","SM"));
   obj.focus();
   obj.select();
  }
    }
 }//E.O.IF
}
 

async function openBedChart(ref)
{ 
 var nursingunit = "";
 var practitionerid = "";
 var specialitycode = "";
 var admission_date_time = "";
 var exp_discharge_date = "";

 if(document.forms[0].pref_adm_date.value =="")
	{
		alert(getMessage("PREF_ADMN_DATE_NOTNULL","IP"));
			document.forms[0].pref_adm_date.focus();
		return false;
	}
 
 
 if(document.confirmbooking_form.nursing_unit_desc.value != "")
  nursingunit = document.confirmbooking_form.nursing_unit.value;
 if(document.confirmbooking_form.practid_desc.value != "")
  practitionerid = document.confirmbooking_form.practid1.value;
 if(document.forms[0].pref_adm_date.value != "")
  admission_date_time = document.forms[0].pref_adm_date.value;	

 if(document.forms[0].exp_discharge_date.value != "")
	exp_discharge_date = document.forms[0].exp_discharge_date.value;

 
 specialitycode = document.confirmbooking_form.Splcode1.value;
  
 var bedclasscode = document.confirmbooking_form.Bedcode.value;
 var bedtypecode = document.forms[0].bed_type_desc.value;
 var gender = document.confirmbooking_form.sex.value;
 var agevalue = document.confirmbooking_form.b_age.value+"Y"+document.confirmbooking_form.b_months.value+"M";
 var age ;
 
 if(agevalue != '')
 {
  var yr = eval(agevalue.indexOf("Y"));
  var mon = eval(agevalue.indexOf("M"));
 
  if(mon>=0 && yr>=0)
  {
   age = agevalue.substring(0,yr);
   agevalue = "Y";
  }
  else if(mon >= 0)
  {
   age = agevalue.substring(0,mon);
   agevalue = "M";
  }
  else
  {
   age = agevalue.substring(0,yr);
   agevalue = "Y";
  }
 }
 /*IN017016*/
 var bed_booking_ref_no =  document.confirmbooking_form.booking_ref_no.value
 var retVal =  new String();
 var dialogHeight= "98vh" ;
 var dialogWidth = "85vw" ;
 var dialogTop = "0vh" ;
 var status = "no";
 var arguments = "" ;
 var wherecondn = "CONFIRM_BOOKING_YN";
 var features = "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

 if(nursingunit!=null && nursingunit!="")
  {
	 retVal = await top.window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?create_booking_admission_date_time="+admission_date_time+"&disable_field=NursingUnitSpecialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&exp_discharge_date="+exp_discharge_date+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&wherecondn="+wherecondn+"&bed_booking_ref_no="+bed_booking_ref_no,arguments,features);
  }
 else
  {
	 retVal = await top.window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?create_booking_admission_date_time="+admission_date_time+"&disable_field=specialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&exp_discharge_date="+exp_discharge_date+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&wherecondn="+wherecondn+"&bed_booking_ref_no="+bed_booking_ref_no,arguments,features);
  }
 
 if (retVal != null)
 {
  var arr = retVal.split("^");
  
  if (arr.length > 2)
  {
	var arr1 = arr[1].split("/");
 
	parent.frames[1].document.forms[0].nursing_unit_desc.value=arr[9];
	parent.frames[1].document.forms[0].nursing_unit.value=arr[0];
	parent.frames[1].document.forms[0].Bedcode.value = arr[3];
	if(bedclasscode != arr[3] || bedclasscode == "" || bedtypecode == "")
	  {
		populateBedType(arr[3], arr[2],"Bed_Avaibility_Chart_Validation");
	  }

	if(parent.frames[1].document.forms[0].bed_no!=null)
	parent.frames[1].document.forms[0].bed_no.disabled = false;
   parent.frames[1].document.forms[0].bed_no.value = arr1[0];
   if(parent.frames[1].document.forms[0].room_no!=null)
	parent.frames[1].document.forms[0].room_no.disabled = false;
   parent.frames[1].document.forms[0].room_no.value = arr[4];

   parent.frames[1].document.forms[0].pract_img.style.visibility="visible";
   /*val = parent.frames[1].document.forms[0].Bedcode.options;
 
   for (i=0; i<val.options.length; i++)
   {
    if(val.options[i].value ==arr[3])
     val.options[i].selected = true ;
   }*/
   
   const selectField = document.getElementById('Bedcode');
   
   for (let option of selectField.options) {
	   option.selected = option.value === arr[3];
   }

   parent.frames[1].document.forms[0].Bedcode.value = arr[3];
   parent.frames[1].document.confirmbooking_form.override.disabled=false;  
   parent.frames[1].document.confirmbooking_form.room_no.focus();
 
  }
  else
  {
   parent.frames[1].document.forms[0].nursing_unit.value=arr[0];
   if (arr.length == 2)
    parent.frames[1].document.forms[0].nursing_unit_desc.value = arr[1];
    //PopulateService();
  }
  if (parent.frames[1].document.forms[0].service.value == '')
  {
   var obj = parent.frames[1].document.forms[0].service;
   var length  = obj.length;
   for(i=0;i<length;i++) { obj.remove(0); }
 
   var xmlDoc = ""
   var xmlHttp = new XMLHttpRequest()
   xmlStr ="<root><SEARCH step='Two' nursingUnitCode=\""+parent.frames[1].document.forms[0].nursing_unit.value+"\" /></root>";
   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
   xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
   xmlHttp.send(xmlDoc)
   responseText=xmlHttp.responseText
   responseText = trimString(responseText)
   eval(responseText)
  }
 }
 
}
 

function doDatetimeCheckAlert(to,from) {
 var fromarray; var toarray;
 var fromdate = from;
 var todate = to;
 if(fromdate.length > 0 && todate.length > 0 ) {
   fromarray = fromdate.split("/");
   toarray = todate.split("/");
   var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
   var todt = new Date(toarray[2],toarray[1],toarray[0]);
   if(Date.parse(todt) < Date.parse(fromdt)) {
    return false;
   }
   else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
 }
return true;
}

function doOTDateTimeChk2(obj)
{
 
 var retval=true
//if(objchk != '')
 if(obj.value != '')
 {
  


  if(!validDateObj(obj,"DMYHM",localeName))
	{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			retval= false;			
			//obj.focus();
	}
 
  if(retval)
  { 
   //var OTdate = objchk; 

	   var flagForOTDate = calcPrefDateForPreparationDay2();
		if(flagForOTDate==false)
			return false;

   var prefdate = document.forms[0].pref_adm_date.value;  
   var greg_OTdate = convertDate(obj.value,"DMYHM",localeName,"en");
		
   if(prefdate.length >1) 
   {
	   var greg_PrefADMdate = convertDate(document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");
		var exp_days_of_stay = parent.frames[1].document.forms[0].exp_days_of_stay.value;
		if(!ValidatePrefOTDateTime(greg_PrefADMdate,greg_OTdate,exp_days_of_stay))
		 retval = false;
			
   } 
   else
   {
    /*alert(getMessage("PREF_ADMN_DATE_NOTNULL",'IP'));   
    document.forms[0].ot_date_time.value = "";
    document.forms[0].pref_adm_date.select();
    document.forms[0].pref_adm_date.focus();*/
   }   
  }
     }
  return retval;
}
 
function ValidatePrefOTDateTime(from,to,exp_days_of_stay)
{ 
	var prefDateTime = from;
	var expDaysofStay;
	if(exp_days_of_stay == '')
		expDaysofStay = 0;
	else
		expDaysofStay = exp_days_of_stay;
	 var a=  from.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 
	 var retval=true
	 
	 var splitdate1 =a[0].split("/")
	 
	 var splittime1= a[1].split(":")
	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 
	 var xmlDoc = ""
	 var xmlHttp = new XMLHttpRequest()
	 xmlStr ="<root><SEARCH step='One' prefDateTime=\""+prefDateTime+"\" expDaysofStay=\""+expDaysofStay+"\" /></root>"
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	 xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	 xmlHttp.send(xmlDoc)
	 responseText=xmlHttp.responseText
	 responseText = trimString(responseText)
	 
	 a = responseText.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 
	 var exp_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 
	
	 if(exp_days_of_stay == '')
	 {
		if((Date.parse(from_date) > Date.parse(to_date)))
		{
			var error = getMessage("CANNOT_LESSER","MP");
			error = error.replace("#", getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
			error = error.replace("$", getLabel("eIP.PrefAdmDateTime.label","IP"));
			alert(error);

			parent.frames[1].document.forms[0].ot_date_time.focus();
			parent.frames[1].document.forms[0].ot_date_time.select();
		
			retval = false;
			return retval
		}
	}
	else
	{
		if((Date.parse(from_date) > Date.parse(to_date)) || (Date.parse(to_date) > Date.parse(exp_date)))
		{
			alert(getMessage("INVALID_OT_DATE",'IP'));
			parent.frames[1].document.forms[0].ot_date_time.focus();
			parent.frames[1].document.forms[0].ot_date_time.select();
		
			retval = false;
			return retval
		}
	}
	 
	return retval
 
  
} 
 
function specialChar(obj,val)
{
 if(obj.value!='')
 {
  var fields1 = new Array(obj);
  var names1 = new Array(obj.name.toUpperCase());
  var messageFrame = ""; var error_page = "";
  if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
  {
   if(val=="Num")
   {
    if(CheckNum(obj))
     {
       return true;
     }
     else 
     {
       obj.focus();
       obj.value='';
       return false;
     }
   }
   else if(val=="Char")
   {
    return true;
   }
 

   return true;
  }
  else
  {
     obj.focus()
     obj.value='';
     return false;
  }
 }
 
}
 

//function added on 09-09-2003 by dhanasekaran
function returnVal()
{
	window.returnValue = 'close';
}
 
async function NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID)
{

	document.forms[0].bed_no.disabled = false;
	document.forms[0].bed_avail_chart.disabled = false;

	var locale			= document.forms[0].locale.value;

	if(document.forms[0].nursing_unit_desc.value == '')
	document.forms[0].nursing_unit.value = '';
	var Facility_ID    = Facility_ID;
	var Login_User    = Login_User;
	var Operator_Station_ID  = Operator_Station_ID;

	var target     = document.forms[0].nursing_unit_desc;
	var sql      = "";

	var retVal   = new String();
	var argumentArray = new Array() ;
	var dataNameArray = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray = new Array() ;
	var appPatClass  = document.forms[0].PatClass.value;

	var nursingUnitCode			= document.forms[0].nursing_unit_desc.value;
	var call_function			= document.forms[0].call_function.value
	var tit						= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&specilaty_code="+document.forms[0].Splcode1.value+"&pract_id="+document.forms[0].practid1.value+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&patientclass=IP&call_function="+call_function+"&med_ser_grp_code="+document.forms[0].med_service_grp.value+"&bkg_type=I";


	/*if(document.forms[0].practid1.value != "")
	{
		sql = "SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, IP_MED_SER_GRP_NURS_UT_TYPE B, IP_NURS_UNIT_FOR_SPECIALTY C, IP_NURSING_UNIT_FOR_PRACT D, AM_OS_USER_LOCN_ACCESS_VW E WHERE  A.LANGUAGE_ID = '"+locale+"' and A.FACILITY_ID = '"+Facility_ID+"'  AND A.EFF_STATUS = 'E' AND B.FACILITY_ID = A.FACILITY_ID AND B.MED_SER_GRP_CODE = '"+document.forms[0].med_service_grp.value+"' AND B.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE AND C.FACILITY_ID = A.FACILITY_ID AND C.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND C.SPECIALTY_CODE = '"+document.forms[0].Splcode1.value+"' AND D.FACILITY_ID = A.FACILITY_ID AND D.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND D.PRACTITIONER_ID = '"+document.forms[0].practid1.value+"' AND E.FACILITY_ID = A.FACILITY_ID  AND E.OPER_STN_ID = '"+Operator_Station_ID+"' AND E.APPL_USER_ID = '"+Login_User+"'  AND E.LOCN_TYPE = 'N' AND E.LOCN_CODE = A.NURSING_UNIT_CODE AND (E.CONFIRM_BOOKING_YN = 'Y' OR E.CREATE_BOOKING_WITH_CONF_YN = 'Y') AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC)  LIKE UPPER(?) ";
		

    
   argumentArray[0] = sql;
   argumentArray[1] ="";//dataNameArray ;
   argumentArray[2] ="";//dataValueArray ;
   argumentArray[3] ="";//dataTypeArray ;
   argumentArray[4] = "1,2";
   argumentArray[5] = document.forms[0].nursing_unit_desc.value;
   argumentArray[6] = DESC_LINK;
   argumentArray[7] = DESC_CODE;
   
  }else
  {
	sql = "SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, IP_MED_SER_GRP_NURS_UT_TYPE B, IP_NURS_UNIT_FOR_SPECIALTY C, AM_OS_USER_LOCN_ACCESS_VW E WHERE   A.LANGUAGE_ID = '"+locale+"' and A.FACILITY_ID = '"+Facility_ID+"' AND A.EFF_STATUS = 'E' AND B.FACILITY_ID = A.FACILITY_ID AND B.MED_SER_GRP_CODE = '"+document.forms[0].med_service_grp.value+"' AND B.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE AND C.FACILITY_ID = A.FACILITY_ID AND C.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND C.SPECIALTY_CODE = '"+document.forms[0].Splcode1.value+"' AND E.FACILITY_ID = A.FACILITY_ID  AND E.OPER_STN_ID = '"+Operator_Station_ID+"' AND E.APPL_USER_ID = '"+Login_User+"'  AND E.LOCN_TYPE = 'N' AND E.LOCN_CODE = A.NURSING_UNIT_CODE AND (E.CONFIRM_BOOKING_YN = 'Y' OR E.CREATE_BOOKING_WITH_CONF_YN = 'Y') AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC)  LIKE UPPER(?) ";

	
	argumentArray[0] = sql;
	argumentArray[1] = "";//dataNameArray ;
	argumentArray[2] = "";//dataValueArray ;
	argumentArray[3] = "";//dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].nursing_unit_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	}*/

 // retVal = await CommonLookup( tit, argumentArray );

	retVal =  await window.showModalDialog(jsp_name,arguments, features);


  if(retVal != null && retVal != "" )
  {
   var ret1=unescape(retVal);
   //arr=ret1.split(",");  
   arr=ret1.split("~");
   document.forms[0].nursing_unit_desc.value=arr[1];
   document.forms[0].nursing_unit.value=arr[0];
   document.forms[0].nurs_unit_desc_hid.value = document.forms[0].nursing_unit_desc.value
  }
  else
  {
   document.forms[0].nursing_unit_desc.value="";
   document.forms[0].nursing_unit.value="";
 
   document.forms[0].bed_no.disabled = true;
   document.forms[0].bed_avail_chart.disabled = true;

   var obj = document.forms[0].service;
   var length  = obj.length;
   for(i=0;i<length;i++) { obj.remove(0); }

   var opt = document.createElement("OPTION");
   opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
   opt.value= '';
   document.forms[0].service.add(opt);
  }

  document.forms[0].bed_no.value = '';
  document.forms[0].room_no.value = '';
  parent.frames[1].document.forms[0].pract_img.style.visibility="hidden";
  PopulateService();
}
 
function NursingUnitLookupBlur(Facility_ID,Login_User,Operator_Station_ID)
{

 if(document.forms[0].nursing_unit_desc.value == '')
	document.forms[0].nursing_unit.value = '';
 //var oldValFlag = true;

 //if(document.forms[0].nurs_unit_desc_hid.value != document.forms[0].nursing_unit_desc.value)
// {
//	oldValFlag = true;
// }
 
// if(oldValFlag)
// {
  if(document.forms[0].nursing_unit_desc.value != "")
  {
	NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID)
  }
  else
  {
   var obj = document.forms[0].service;
   var length  = obj.length;
   for(i=0;i<length;i++) { obj.remove(0); }
   
   var opt = document.createElement("OPTION");
   opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
   opt.value= '';
 
   delete_values(document.getElementById('bed_type_desc'));
   delete_values(document.getElementById('Bedcode'));
 
   document.forms[0].service.add(opt);
   document.forms[0].bed_no.value = '';
   document.forms[0].bed_no.disabled = true;
   document.forms[0].bed_avail_chart.disabled = false;
   document.forms[0].room_no.value = '';
   document.forms[0].nursing_unit.value='';

  }
// }
}
 
function PopulateService(is_default_service)
{
// var decider = onlybedclass;
 //var bedclass_code = bedclass;
//if(decider=="undefined") decider = "";
//if(bedclass_code=="undefined") bedclass_code = "";
 var nursingunit = self.document.forms[0].nursing_unit.value;

 /*
	is_default_service,service_desc,default_service & request_service_desc fields added by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525]  
	*/
	var service_desc	= self.document.forms[0].service.value;
	var default_service	= "Y";
	if(is_default_service!=null || is_default_service!=undefined)
		default_service	= is_default_service;

 if(nursingunit!=null && nursingunit!="")
	{
	    var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='nursingUnitCode' id='nursingUnitCode' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Booking_form'><input type='hidden' name='criteria' id='criteria' value='PopulateService'><input type='hidden' name='option_val' id='option_val' value='retrieve'><input type='hidden' name='request_service_desc' id='request_service_desc' value='"+service_desc+"'><input type='hidden' name='is_default_service' id='is_default_service' value='"+default_service+"'></form></body></html>";
	  if(parent.frames[2].document.body)
		{
		 
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		}
	  if(parent.frames[2].document.dum_form)
		{
		
		parent.frames[2].document.dum_form.submit();
		
		}
	
	}
}

function PopulateMedicalTeam1()
 {
 med_code = document.forms[0].med_service_grp.value.split("#");
 spy_code = document.forms[0].Splcode1.value;
 prt_code = document.forms[0].practid1.value;
 
 var selected = document.forms[0].team_id;
 while ( selected.options.length > 0 )
  selected.remove(selected.options[0]);
 
 var str1 = "" ;
 var str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
 var element = parent.frames[1].document.createElement('OPTION');
 element.text = str2; 
 element.value= str1;
 document.forms[0].team_id.add(element);
 
 var ippractid = document.forms[0].practid1.value;
 var getservice=document.forms[0].practid1.value;
 
 if (ippractid != null && ippractid != "")
 {
  var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='booking'><input type='hidden' name='med_code' id='med_code' value='"+med_code[0]+"'><input type='hidden' name='spy_code' id='spy_code' value='"+spy_code+"'><input type='hidden' name='prt_code' id='prt_code' value='"+prt_code+"'></form></body></html>";
  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
  parent.messageFrame.document.querydept.submit();
 }
}
 
function bedtypeLookupBlur()
{
	if(document.forms[0].bed_type_desc.value == "")
	{
		document.forms[0].bed_no.value  = ""; 
		document.forms[0].room_no.value = "";
	}
	if(document.forms[0].bed_type_desc_hid.value != document.forms[0].bed_type_desc.value)
	{
		if(document.forms[0].bed_type_desc.value != "")
		 bedtypeLookup()
	}
}

async function bedtypeLookup()
{	
	var target					= document.forms[0].bed_type;
	var sql						= "";
	var tit						= getLabel('Common.bedtype.label','common');
	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var locale			= document.forms[0].locale.value;
	sql = "Select BED_TYPE_CODE CODE,short_desc DESCRIPTION from IP_BED_TYPE_LANG_VW where language_id='"+locale+"' and eff_status='E' AND UPPER(bed_type_code) LIKE UPPER(?) AND UPPER(short_desc)  LIKE UPPER(?) ";	

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= document.forms[0].bed_type_desc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].bed_type_desc.value=arr[1];
		document.forms[0].bedtypecode.value=arr[0];
		document.forms[0].bed_type_desc_hid.value = document.forms[0].bed_type_desc.value
		bedtypeLookup()
	}
	else
	{
		document.forms[0].bed_no.value  = "";
		document.forms[0].room_no.value ="";
	}
}

function localValidations(obj)
{
	// for patient id validaion, which are specific to ip. we have to include here.
}

// This fucntion is used for validating the numbers....
function ChkNumberInput1(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';

	   var whichCode = (window.Event) ? e.which : e.keyCode;
		if (whichCode == 13) return true;  // Enter
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

//onchange function of bed type list box..
function ClearNursingUnitDtls()
{
	document.forms[0].bed_no.value='';
	document.forms[0].room_no.value='';
	document.forms[0].bedtypecode.value = document.forms[0].bed_type_desc.value;
}

function populateBedType(bedClass, bedType ,validationType)
{
	delete_values(document.getElementById('bed_type_desc'));
	document.forms[0].bed_no.value = "";
	document.forms[0].room_no.value = "";
	var	nursingUnitCode = document.forms[0].nursing_unit.value;
	var	deactivate_pseudo_bed_yn = document.forms[0].deactivate_pseudo_bed_yn.value;

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+
	" <input type='hidden' name='bedClass' id='bedClass' value='"+bedClass+"'><input type='hidden' name='bedType' id='bedType' value='"+bedType+"'><input type='hidden' name='nursingUnitCode' id='nursingUnitCode' value='"+nursingUnitCode+"'><input type='hidden' name='criteria' id='criteria' value='PopulateBedType'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'><input type='hidden' name='validationType' id='validationType' value='"+validationType+"'></form></body></html>";
	if(parent.frames[2].document.body != null)
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	if(parent.frames[2].document.forms[0])
	parent.frames[2].document.forms[0].submit();
}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt=document.createElement("Option");
	opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value="";
	field.add(opt);
}

// This function is used for checking the practioner id has modified or not.
// if modified, then it will be called the practioner lookup function

function getPractIDBlur(obj,target)
{
	if(document.forms[0].practid_desc.value =='')
	document.forms[0].practid1.value='';
	var oldValFlag = false;
	if(document.forms[0].practid_desc_hid.value != document.forms[0].practid_desc.value)
	{
		oldValFlag = true;
		document.getElementById('pract_img').style.visibility="visible";
	}
	if(oldValFlag)
	{
		if(document.forms[0].practid_desc.value!="")
			getPractID(obj,target)
		else
		{
			document.forms[0].team_id.value="";
			document.forms[0].team_id.disabled=true;
		}
	}
}
// This function is used for setting the practitioner values after lookup

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr										 = retVal.split("~");
		document.forms[0].practid1.value		 = arr[0];
		document.forms[0].practid_desc.value	 = arr[1];
		document.forms[0].practid_desc_hid.value = document.forms[0].practid_desc.value
		document.forms[0].team_id.disabled		 = false;
		PopulateMedicalTeam1();
	}
	else
	{	
		document.forms[0].practid1.value		= "";
		document.forms[0].practid_desc.value	= "";
		document.forms[0].team_id.disabled		= true;
		document.forms[0].team_id.value			= "";  
	}

}
// This function is used for disabling the fields
function PatDetDisab()
{
	
	if (document.confirmbooking_form.patient_id.value)
	{
		document.confirmbooking_form.search.disabled = true ;
	}
		document.confirmbooking_form.patient_name.readOnly = true;
		//if(document.confirmbooking_form.name_prefix1)
		//document.confirmbooking_form.name_prefix1.disabled = true;
		if(document.confirmbooking_form.name_prefix)
		document.confirmbooking_form.name_prefix.disabled = true;
	
		if(document.confirmbooking_form.first_name)
		document.confirmbooking_form.first_name.readOnly = true;
		if(document.confirmbooking_form.second_name)
		document.confirmbooking_form.second_name.readOnly = true;
		if(document.confirmbooking_form.third_name)
		document.confirmbooking_form.third_name.readOnly = true; 
		if(document.confirmbooking_form.family_name)
		document.confirmbooking_form.family_name.readOnly = true ; 
		//if(document.confirmbooking_form.name_suffix1)
		//document.confirmbooking_form.name_suffix1.disabled = true ;
		if(document.confirmbooking_form.name_suffix)
		document.confirmbooking_form.name_suffix.disabled = true ;
	
		document.confirmbooking_form.sex.disabled = true ;
		document.confirmbooking_form.date_of_birth.readOnly = true ;
		 document.forms[0].b_age.readOnly	= true;
		 document.forms[0].b_months.readOnly	= true;
		 document.forms[0].b_days.readOnly	= true;
		document.confirmbooking_form.patient_id.readOnly = true;
		if(document.confirmbooking_form.national_id)
		document.confirmbooking_form.national_id.readOnly = true;
		if(document.confirmbooking_form.alternate_id)
		document.confirmbooking_form.alternate_id.readOnly = true;
		document.getElementById('pract_img').style.visibility="hidden";
		if(document.confirmbooking_form.team_id)
		document.confirmbooking_form.team_id.disabled = true;
		if(document.confirmbooking_form.PatClass.value == "DC")
		{
			document.confirmbooking_form.pref_adm_date.disabled = true;
			document.confirmbooking_form.ambul.disabled = true;
			document.confirmbooking_form.exp_days_of_stay.disabled = true;
			document.confirmbooking_form.ot_date_time.disabled = true;
		}
		else
			document.confirmbooking_form.confirm.focus();
}


/*** Function to check the Entered value ***/
function Allfunc(obj1,obj2)
{
	document.forms[0].bl_success.value = "N";
		if(obj1.value != '')
		{
			//if(doDateTimeChk(obj1))
			if(validDateObj(obj1,"DMYHM",localeName))
		    {
				var greg_obj1 = convertDate(obj1.value,"DMYHM",localeName,"en");
				var greg_obj2 = obj2.value
				if(isAfter(greg_obj1, greg_obj2, "DMYHM", 'en'))
				//if(ValidateprefDateTime(obj1.value,obj2.value))
			    {
					ChangeVal(obj1);
					dateCal(obj1);  
					/*var dayOfWeek = getDayOfWeekAsLongText(greg_obj1,"DMYHM", 'en');
					if(dayOfWeek!=null || dayOfWeek!='')
						document.forms[0].DayVal.innerText=dayOfWeek;
					else
						document.forms[0].DayVal.innerText='';*/
				}
				/*comments removed for IN017263 , Wednesday, December 16, 2009*/
				else
				{
					alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE",'IP'));
					document.forms[0].pref_adm_date.value = "";
					document.getElementById('DayVal').innerText='';
					document.forms[0].pref_adm_date.focus();
				}/**/
			}
			else
			{
				document.getElementById('DayVal').innerText='';
				//alert(getMessage("INVALID_DATE_TIME","SM"))
				//obj1.focus()
				return;
			}
		}  
		else
	    {
			document.getElementById('DayVal').innerText='';
		}

		if(obj1.value!="")
		{
			if(document.forms[0].bed_no!=null && document.forms[0].room_no!=null )
			{
				if(document.forms[0].bed_no.value!="" && document.forms[0].bed_no.disabled==false &&  document.forms[0].room_no.disabled==false)
				{
					alert(getMessage("REMOVE_BED","IP"));
					document.forms[0].bed_no.value="";
					document.forms[0].room_no.value="";
				}			
			}
		}
}

//This function is used for checking the maximum size of the field
function checkMaxLimit1(obj,maxSize)
{	
   if(makeValidString(obj)==false)
	   return false
   else
	{
		if ( obj.value.length >= maxSize )
		{
			alert(getMessage("CH_COMP_EXCD_200_CHARS",'IP'));	
			obj.focus();obj.select();
		}
	}
}
// This function is used for validating the preffered date time
function ValidateprefDateTime(from,to)
{	
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]-1), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]-1), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 if(Date.parse(to_date) > Date.parse(from_date))
	{
		alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE",'IP'));
		document.forms[0].pref_adm_date.focus();
		document.forms[0].pref_adm_date.select();
		return false
	}
	else
		return true;
}	

function AMValFunc(obj)
{
	if(document.confirmbooking_form.pref_adm_date.value.length != 0)
	 	ChangeVal(obj);
}

 
 
 /***function to populate the day of the entered pref adm Date***/
 
 function dateCal(obj)
 {
	var greg_obj1 = convertDate(obj.value,"DMYHM",localeName,"en");
	var dayOfWeek = getDayOfWeek(greg_obj1,"DMYHM", 'en');
	var Vdate= parseInt(dayOfWeek);

	   /*if(obj.value.length > 0)
	   {
		   dateVal= new Date(obj.value);
		   var strDateArray = new Array();
		   strDate = obj.value;
		   strDateArray = strDate.split("/");
		   strDay   = strDateArray[0];
		   strMonth = strDateArray[1];
		   strYear  = strDateArray[2];   

		   Vdate = new Date(strMonth+'/'+ strDay +'/'+ strYear)   
		   if(Vdate != "NaN")
		   {	*/   
			switch(Vdate)
			{
				
				case 1:
				  Vdate=getLabel("Common.mon.label","Common");
				  break;	  
				case 2:
				  Vdate=getLabel("Common.tue.label","Common");
				  break;
				case 3:
				  Vdate=getLabel("Common.wed.label","Common");
				  break;
				case 4:
				  Vdate=getLabel("Common.thu.label","Common");
				  break;
				case 5:
				  Vdate=getLabel("Common.fri.label","Common");
				  break;
				case 6:
				  Vdate=getLabel("Common.sat.label","Common");
				break;  
				case 7:
				  Vdate=getLabel("Common.sun.label","Common");
				  break;
				//}
		   }

		if(Vdate!=null)
			document.getElementById('DayVal').innerText=Vdate;
		else
			document.getElementById('DayVal').innerText='';
		   
	   //}
	   //else{document.forms[0].DayVal.innerText='';}
 }

/***function to disable or enable the Override chkbox***/ 
 
function popDynamicValues(obj)
{
	if (obj.value.length > 0 )
	{
		document.forms[0].bed_no.value='';
		document.forms[0].room_no.value='';
		document.forms[0].bed_no.disabled=false;
	}
	else
	{
		document.forms[0].bed_no.value='';
		document.forms[0].room_no.value='';
		document.forms[0].bed_no.disabled=true;
	}
}
function gifpop()
{         
	document.getElementById('gifpop').style.visibility="hidden";
}
function DisHome()
{
	document.getElementById('pract_img').style.visibility="hidden";
}

function bldFunc(Obj)
{
	if(Obj.checked == true)
		Obj.value="Y";
	else
		Obj.value="N";
}
// This function is used to chk the ambulance date
function doDateTimeAmbchk(obj)
{
	var objchk = obj.value;
	if(objchk != '')
	{
		if(doDateTimeChk(obj))
		{
			var sdate = document.forms[0].sdate2; 
			var obj1="";
			var prefdate = document.forms[0].pref_adm_date.value; 	
			if(prefdate.length >1)	
			{
				if (ValidateDateTime(obj1,sdate))
				{
					alert(getMessage("INVALID_AMB_REQD_DATE",'IP'));
					retval = false;
				}
				else
				{
					if (!ValidateDateTime(obj1,document.forms[0].pref_adm_date))
							alert(getMessage("AMB_REQD_DATE_LT_PREF_DATE",'IP'))
				}
			}	
			else
			{
				alert(getMessage("PREF_ADMN_DATE_NOTNULL",'IP'));
				retval = false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_TIME","SM"))
			obj.focus()
			retval= false;
		}
		return retval
	 }
}

function changeOVRVal(obj)
{
	if(obj.checked==true)
	document.forms[0].override_yn.value="Y";
	else
	document.forms[0].override_yn.value="N";
}

function Control_NursingUnit(is_default_service)
{

	document.forms[0].override.disabled	= true;
	if(document.forms[0].bed_no.value !="")
	{
		document.forms[0].bno.value				=	document.forms[0].bed_no.value;
		document.forms[0].rno.value				=	document.forms[0].room_no.value;
		document.forms[0].nunitcode.value		=	document.forms[0].nursing_unit.value;
		document.forms[0].bclasscode.value		=	document.forms[0].Bedcode.value;  
		document.forms[0].service_hid.value		=	document.forms[0].service.value;  
		
		document.forms[0].bed_no.disabled				= true;
		document.forms[0].Bedcode.disabled				= true;
		document.forms[0].service.disabled				= true;
		document.forms[0].bed_type_desc.disabled		= true;
		document.forms[0].nursing_unit_desc.disabled	= true;
		document.forms[0].nursing_unit_lookup.disabled	= true;
		document.forms[0].room_no.disabled				= true;
		document.forms[0].override.disabled				= true;
		document.forms[0].bed_avail_chart.disabled		= true;
	}
	if(document.forms[0].nursing_unit_desc!=null && document.forms[0].nursing_unit_desc.value!='')
	{
		if(document.forms[0].service.disabled == false && document.forms[0].Bedcode.value =="")/*16430 Thursday, November 19, 2009*/
		{	
			setTimeout('PopulateService("'+is_default_service+'")',100);
		}
		if(document.forms[0].Bedcode.value != "" && document.forms[0].bed_type_desc.value == "")
	    {
			populateBedType(document.forms[0].Bedcode.value);
	    }
		if(document.forms[0].nursing_unit_desc.disabled ==false)
		{
			document.forms[0].bed_no.disabled				= false;
			document.forms[0].bed_avail_chart.disabled				= false;
		}
		

	}
	
	 dateCal(document.forms[0].pref_adm_date);
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) == 0 )
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.focus();
	}
}

function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 && obj.value==0) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO",'common'));
           // obj.select();
          //  obj.focus();
            //return false;
			obj.value = '1';
			return true;
        }
    }
}


function calcDate(obj)
{
	document.forms[0].exp_discharge_date.value='';
	//document.forms[0].ot_date_time.value = '';
	if(document.forms[0].exp_days_of_stay.value!='' && document.forms[0].pref_adm_date.value!='')
	{
		var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
		document.forms[0].exp_discharge_date.value	= expdischargeDate;

		var proc_surg_date_time = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		//if(document.forms[0].pre_op_days.value != '0')
		if(document.forms[0].ot_date_time.value != '')
			document.forms[0].ot_date_time.value	= proc_surg_date_time;	

		doOTDateTimeChk2(document.forms[0].ot_date_time);
	}
}


function tab_click(obj_name)
{
	if(obj_name == 'booking_tab' )
	{
		if(document.getElementById('tab1') != null)
				document.getElementById('tab1').scrollIntoView();

		//document.forms[0].pref_adm_date.focus();
	}
	else if(obj_name == 'findtl_tab' )
	{
		if(document.getElementById('tab1') != null)
			document.getElementById('tab1').scrollIntoView();
		
		if(document.forms[0].pref_adm_date.value == "")
		{
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
			msg	=	msg.replace("{1}",getLabel("eIP.PrefAdmDateTime.label","IP"));
			alert(msg);
		}
		else
		{
				/*var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='bl_form' id='bl_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+" <input type='hidden' name='patient_id' id='patient_id' value='"+document.forms[0].patient_id.value+"'><input type='hidden' name='blng_grp' id='blng_grp' value='"+document.forms[0].billing_group.value+"'><input type='hidden' name='is_tab_click' id='is_tab_click' value='Y'></form></body></html>";
							
				parent.frames[2].document.write(HTMLVal);
				parent.frames[2].document.bl_form.submit();*/

				parent.frames[1].grabFinancialDetails();
		}
		
	}

	
}

async function grabFinancialDetails()
{
	document.forms[0].bl_success.value = "N";//
	var show_hide_blng_class = "HIDE";//
	var patient_id     = document.forms[0].patient_id.value;//
	var package_flag	= document.forms[0].package_flag.value;//
	//var ins_auth_flag	= "Y";
	var upd_pat_flag	= "Y"; //
	var billing_group			= document.forms[0].billing_group;//
	//var billing_group			= parent.frames[2].document.forms[0].billing_group;//
	var bl_future_admn_YN		= document.forms[0].bl_future_admn_YN.value;//
	//var bl_future_admn_YN		= parent.frames[2].document.forms[0].bl_future_admn_YN.value;//
  	var billing_mode			= document.forms[0].billing_mode;//
	var operation				= document.forms[0].bl_operation.value;//
	//var operation				= parent.frames[2].document.forms[0].bl_operation.value;//
	var pkg_bill_type			= document.forms[0].pkg_bill_type;//
	var pkg_bill_no				= document.forms[0].pkg_bill_no;//


	var practitioner_type_ind = "";
	var att_practid				= ""; 
	att_practid				= document.forms[0].att_practid.value; // need to check
	if(att_practid != '') practitioner_type_ind = "P"; //
	var health_card_expired_yn	= document.forms[0].health_card_expired_yn; //
	var Chg_to_Visitor_Grp		= document.forms[0].Chg_to_Visitor_Grp;	//	
	//if(parent.frames[0].document.Select_form.bkg_type.value=='D')
		//parent.frames[2].document.AdmitPatient_form.patient_class_id.value	='DC'
	var calling_module_id		= document.forms[0].patient_class_id.value;//
	var calling_function_id		= "CONFIRMBOOKING";// 
	var nursingUnitCode = "";
	//var admissionType	= document.forms[0].visit_adm_type.value;
	var admissionType	= "";//need to check
	var bedClass		= "";//
	
	var financial_detail_ref_id = "";//
	if(document.forms[0].isBlInstalled.value=="Y")
	{
		if(document.forms[0].referral_id && document.forms[0].referral_id.value != "")
			document.forms[0].financial_detail_ref_id.value = document.forms[0].referral_id.value ;
		financial_detail_ref_id = document.forms[0].financial_detail_ref_id.value;
	}//


	
	var episode="";//
	var record="";//

	var bl_interfaced_yn =  document.forms[0].bl_interface_yn.value;
	if ( (bl_interfaced_yn == null) || (bl_interfaced_yn == '') )
	{
		bl_interfaced_yn = 'N';
	}

	var patientclass = document.forms[0].patient_class_id.value;//


		var greg_pref_adm_date = "";
		if(document.forms[0].pref_adm_date.value!='')
			greg_pref_adm_date = convertDate(document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");

		var qryStr="patientclass="+patientclass+"&operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&show_hide_blng_class="+show_hide_blng_class+"&patient_id="+patient_id+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value;
	
		qryStr += "&pkg_bill_type="+pkg_bill_type.value+"&pkg_bill_no="+pkg_bill_no.value;
		qryStr += "&episode="+episode+"&record="+record;
		qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
		qryStr += "&health_card_expired_yn="+health_card_expired_yn.value+"&Chg_to_Visitor_Grp="+Chg_to_Visitor_Grp.value;
		qryStr += "&bl_interfaced_yn="+bl_interfaced_yn;	
		qryStr += "&bl_future_admn_YN="+bl_future_admn_YN;
		qryStr += "&nursing_unit_code="+nursingUnitCode+"&bed_class_code="+bedClass+"&visit_adm_type="+admissionType;
		qryStr += "&financial_detail_ref_id="+financial_detail_ref_id+"&org_type_ind="+document.forms[0].org_type_ind.value;
		qryStr += "&practitioner_id="+att_practid+"&practitioner_type_ind="+practitioner_type_ind;
		qryStr += "&encounter_date_time="+greg_pref_adm_date;
		
		var returnArray = new Array();

		//alert('the query string which passed to BL module:'+qryStr);
		
		returnArray = await getFinDtl(qryStr);

		if(returnArray.length>0)
		{
			document.forms[0].billing_group.value     = returnArray[0];
			document.forms[0].billing_mode.value      = "Modify"
			document.forms[0].bl_success.value = "Y";
			document.forms[0].bl_operation.value	= "Update";
			tab_click('booking_tab');
			//document.forms[0].pref_adm_date.focus();
		}
		else 
		{
			/*document.forms[0].billing_mode.value		= "Add";
			document.forms[0].bl_operation.value		= "Insert";*/
			document.forms[0].bl_success.value = "N";
			tab_click('booking_tab');
			return false;
		}
}

async function getFinDtl(qryStr)
{
	
	var retVal;
	/*var dialogHeight= "43" ;
	var dialogWidth = "65" ;
	var dialogTop = "71" ;*/
	var dialogTop = "0px";
	var dialogHeight = "90vh";
	var dialogWidth = "90vw";
	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal = await top.window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	return retVal;
}

function displayDefaultValue(obj)
{
	if((obj.value==null || obj.value=="") && obj.name=="pre_op_days")
		obj.value='0';
	else if((obj.value==null || obj.value=="") && obj.name=="exp_days_of_stay")
		obj.value='1';

	if(obj.name=="pre_op_days" && document.forms[0].pre_op_days.value!='0')
	{
		document.forms[0].exp_days_of_stay.value = document.forms[0].pre_op_days.value;
	}

}

function calcPrefDateForPreparationDay1()
{
	
	// this line commentting for IP_17014_ConfirmReviseBooking  document.forms[0].pref_adm_date.value='';
	if(document.forms[0].pre_op_days.value!='' && document.forms[0].ot_date_time.value!='')
	{
		var prefAdmissionDate = minusDate(document.forms[0].ot_date_time.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		document.forms[0].pref_adm_date.value	= prefAdmissionDate;
		
		dateCal(document.forms[0].pref_adm_date);
		
		document.forms[0].exp_discharge_date.value = '';
		if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
			//doOTDateTimeChk2(document.forms[0].ot_date_time);

			var greg_obj = convertDate(document.forms[0].ot_date_time.value,"DMYHM",localeName,"en"); 
			var prefdateobj = document.forms[0].pref_adm_date.value; 
			prefdateobj = convertDate(prefdateobj,"DMYHM",localeName,"en");
			var greg_expect_discharge_date = convertDate(document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en"); 
			var currdate = document.forms[0].sdate2.value; 
			
			var lang_currdate = convertDate(document.forms[0].sdate2.value,"DMYHM","en",localeName); 
			 
				
				//if(isBefore(greg_obj, prefdateobj, "DMYHM", 'en'))
				if(!isAfter(greg_obj,prefdateobj,'DMYHM','en'))
				{		
						
						var err = getMessage("DATE1_LT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.PrefAdmDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						//document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
						var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						document.forms[0].exp_discharge_date.value	= expdischargeDate;
						var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
						document.forms[0].ot_date_time.value	= pro_surg_Date;
						document.forms[0].pre_op_days.focus();
						return false;
				}
				else if(!isAfter( greg_expect_discharge_date,greg_obj, "DMYHM", 'en'))
				{

						var err = getMessage("DATE1_GT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.ExpectedDischargeDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						//document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
						var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						document.forms[0].exp_discharge_date.value	= expdischargeDate;
						var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
						document.forms[0].ot_date_time.value	= pro_surg_Date;
						document.forms[0].pre_op_days.focus();
						return false;
				}	
				//else if(isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				else if(!isAfter(prefdateobj,currdate,'DMYHM','en'))
				{
					alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
					//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
					//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
					document.forms[0].pref_adm_date.value	= lang_currdate; 
					//document.forms[0].ot_date_time.value	= lang_currdate; 
					//document.forms[0].pre_op_days.value		= "0"; 
					document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
					var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
					document.forms[0].exp_discharge_date.value	= expdischargeDate;
					var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
					document.forms[0].ot_date_time.value	= pro_surg_Date;
					document.forms[0].pre_op_days.focus();
					return false;
				}
				else if(!isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				{
					setTimeout('ChangeVal(document.forms[0].pref_adm_date)',20);					
					return false;
				}
				else
					return true;

		}
	}
	/*Below portion commenting for IP_17014_ConfirmReviseBooking*/
	/* else
	{
		var msg = getMessage('GENERAL_CNT_BE_BLANK','IP');
		msg = msg.replace('$',getLabel('eIP.ProcedureSurgeryDateTime.label','IP'));
		alert(msg);
		document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value ;//"0"; 
		document.forms[0].exp_discharge_date.value		= ""; 
		if(document.forms[0].ot_date_time.disabled == false)
		document.forms[0].ot_date_time.focus();
		return true;
	}
	*/
}

function calcPrefDateForPreparationDay2()
{
	  document.forms[0].pref_adm_date.value='';
	
	if(document.forms[0].pre_op_days.value!='' && document.forms[0].ot_date_time.value!='')
	{
		var prefAdmissionDate = minusDate(document.forms[0].ot_date_time.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		document.forms[0].pref_adm_date.value	= prefAdmissionDate;
		
		dateCal(document.forms[0].pref_adm_date);
		
		document.forms[0].exp_discharge_date.value = '';
		if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
			//doOTDateTimeChk2(document.forms[0].ot_date_time);

			var greg_obj = convertDate(document.forms[0].ot_date_time.value,"DMYHM",localeName,"en"); 
			var prefdateobj = document.forms[0].pref_adm_date.value; 
			prefdateobj = convertDate(prefdateobj,"DMYHM",localeName,"en");
			var greg_expect_discharge_date = convertDate(document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en"); 
			var currdate = document.forms[0].sdate2.value; 
			
			var lang_currdate = convertDate(document.forms[0].sdate2.value,"DMYHM","en",localeName); 
			 
				
				//if(isBefore(greg_obj, prefdateobj, "DMYHM", 'en'))
				if(!isAfter(greg_obj,prefdateobj,'DMYHM','en'))
				{		
						
						var err = getMessage("DATE1_LT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.PrefAdmDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						//document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
						var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						document.forms[0].exp_discharge_date.value	= expdischargeDate;
						var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
						document.forms[0].ot_date_time.value	= pro_surg_Date;
						document.forms[0].pre_op_days.focus();
						return false;
				}
				else if(!isAfter( greg_expect_discharge_date,greg_obj, "DMYHM", 'en'))
				{

						var err = getMessage("DATE1_GT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.ExpectedDischargeDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						//document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
						var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						document.forms[0].exp_discharge_date.value	= expdischargeDate;
						var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
						document.forms[0].ot_date_time.value	= pro_surg_Date;
						document.forms[0].pre_op_days.focus();
						return false;
				}	
				//else if(isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				else if(!isAfter(prefdateobj,currdate,'DMYHM','en'))
				{
					alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
					//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
					//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
					document.forms[0].pref_adm_date.value	= lang_currdate; 
					//document.forms[0].ot_date_time.value	= lang_currdate; 
					//document.forms[0].pre_op_days.value		= "0"; 
					document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value;
					var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
					document.forms[0].exp_discharge_date.value	= expdischargeDate;
					var pro_surg_Date = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
					document.forms[0].ot_date_time.value	= pro_surg_Date;
					document.forms[0].pre_op_days.focus();
					return false;
				}
				else if(!isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				{
					setTimeout('ChangeVal(document.forms[0].pref_adm_date)',20);					
					return false;
				}
				else
					return true;

		}
		}
		
	else
	{
		var msg = getMessage('GENERAL_CNT_BE_BLANK','IP');
		msg = msg.replace('$',getLabel('eIP.ProcedureSurgeryDateTime.label','IP'));
		alert(msg);
		document.forms[0].pre_op_days.value		= document.forms[0].pre_op_days_hidden.value ;//"0"; 
		document.forms[0].exp_discharge_date.value		= ""; 
		if(document.forms[0].ot_date_time.disabled == false)
		document.forms[0].ot_date_time.focus();
		return true;
	}
	
}

async function PatInsModalWindow(){//For the CRF - RUT-CRF-013 23396	
	var booking_ref_no=parent.frames[1].document.forms[0].booking_ref_no.value;
	var patient_id=parent.frames[1].document.confirmbooking_form.patient_id.value;
	var nursingunitcode=parent.frames[1].document.forms[0].nursing_unit.value;
	var features    = "dialogHeight:84vh; dialogWidth:54vw; scroll=no; status:no;";
	var arguments = '';	
	var removePatInstruction=parent.frames[1].document.forms[0].removePatInstruction.value;	
	var url="../../eIP/jsp/IPBkgPatientInstructionsMain.jsp?nursing_unit_code="+nursingunitcode+"&from_page=reviseBooking&patient_id="+patient_id+"&NUInsYN=N&booking_ref_no="+booking_ref_no+"&addInstructionYN=N&removePatInstruction="+removePatInstruction;
	parent.frames[1].document.forms[0].removePatInstruction.value="N";
	var retVal = await window.showModalDialog(url,arguments,features);	
	//Changes for RUT-CRF-13.1 IN035825 - start
	/*if(retVal=="true"){
		document.forms[0].NUInstsExist.style.visibility='visible';
	}else{
		document.forms[0].NUInstsExist.style.visibility='hidden';
	}*/
	//Changes for RUT-CRF-13.1 IN035825 - end
}

function removePatInsSession(){
	var nursingunitcode=document.forms[0].nursing_unit.value;
	if(nursingunitcode == ""){	
		document.forms[0].removePatInstruction.value="Y";
		document.getElementById('NUInstsExist').style.visibility='hidden';//Changes for RUT-CRF-13.1 IN035825 
	}
	else{
	document.forms[0].removePatInstruction.value="N";
	
	checkNUPatIns(document.forms[0].nursing_unit.value);//Changes for RUT-CRF-13.1 IN035825 
	}
}

//Changes for RUT-CRF-13.1 IN035825 - start
function checkNUPatIns(NUCode){
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='eight'  nursing_unit_code=\""+NUCode+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
	if (responseText>=1)
	{
		document.getElementById('NUInstsExist').style.visibility='visible';
	}
}
		
function checkPatInstns(){
	var booking_ref_no=parent.frames[1].document.forms[0].booking_ref_no.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='nine'  bookingref=\""+booking_ref_no+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
	if (responseText>=1)
	{
		document.getElementById('NUInstsExist').style.visibility='visible';
	}
}

//Changes for RUT-CRF-13.1 IN035825 - end 

