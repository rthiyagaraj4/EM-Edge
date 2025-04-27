var LocalErrors = "";
async function callApply() 
{	
	
	/*Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622 Start*/
	var isReviseBkgAftrConfrmAppl = f_query_add_mod.document.booking_form.isReviseBkgAftrConfrmAppl.value;
	var confAlertMsg = getMessage("BOOKING_CANCEL_REVISE","IP");
	if(isReviseBkgAftrConfrmAppl == "true")
		confAlertMsg = getMessage("CONFIRM_BOOKING","IP");
	/*End*/
	var tmpVal = f_query_add_mod.document.booking_form.gifval.value;
	//var tmpVal = parent.frames[1].document.booking_form.gifval.value;
	var fields=new Array();
	var names = new Array();
	var p = 0;
	var blur = false;	
	
	//if(parent.frames[1].document.booking_form.call_function.value == 'OT')
	if(f_query_add_mod.document.booking_form.call_function.value == 'OT')
	{
		fields[p]= f_query_add_mod.document.booking_form.ot_date_time; //parent.frames[1].document.booking_form.ot_date_time;
		names[p] = getLabel("eIP.ProcedureSurgeryDateTime.label","IP");
		p++;
	}

	fields[p]= f_query_add_mod.document.booking_form.pref_adm_date; //parent.frames[1].document.booking_form.pref_adm_date;
	names[p] = getLabel("eIP.PrefAdmDateTime.label","IP");
	p++;

	fields[p]= f_query_add_mod.document.booking_form.med_service_grp; //parent.frames[1].document.booking_form.med_service_grp;
	names[p] = getLabel("eIP.MedicalServiceGroup.label","IP");
	p++;
	//if(parent.frames[1].document.booking_form.gifpop.style.visibility == 'visible')
	if(f_query_add_mod.document.booking_form.gifpop.style.visibility == 'visible')	
	{
		fields[p]= f_query_add_mod.document.booking_form.booking_ref_no; //parent.frames[1].document.booking_form.booking_ref_no;
		names[p] = getLabel("Common.BookingRefNo.label","Common");
		p++;
	}

	//if(parent.frames[1].document.booking_form.allowed_booking_type.value == "R")
	if(f_query_add_mod.document.booking_form.allowed_booking_type.value == "R")	
	{
		fields[p]= f_query_add_mod.document.booking_form.referral_id; //parent.frames[1].document.booking_form.referral_id;
		names[p] = getLabel("Common.referralid.label","Common");
		p++;
	}

	if(tmpVal != "Y")
	{
		fields[p]= f_query_add_mod.document.booking_form.patient_id; //parent.frames[1].document.booking_form.patient_id;
		names[p] = getLabel("Common.patientId.label","Common");
		p++;
	}
	//if(parent.frames[1].document.booking_form.name_prefix_reqd_yn != null && parent.frames[1].document.booking_form.name_prefix_reqd_yn.value == 'Y' )
	if(f_query_add_mod.document.booking_form.name_prefix_reqd_yn != null && f_query_add_mod.document.booking_form.name_prefix_reqd_yn.value == 'Y' )	
	{
		/*if(f_query_add_mod.document.booking_form.name_prefix1 != null && f_query_add_mod.document.booking_form.name_prefix1.disabled == false)
		{
			fields[p]=f_query_add_mod.document.booking_form.name_prefix1;
			names[p]=f_query_add_mod.document.booking_form.Name_Prefix_Prompt.value;
			p++;
		}*/

		//if(parent.frames[1].document.booking_form.name_prefix != null && parent.frames[1].document.booking_form.name_prefix.disabled == false)
		if(f_query_add_mod.document.booking_form.name_prefix != null )
		{
			fields[p]= f_query_add_mod.document.booking_form.name_prefix; //parent.frames[1].document.booking_form.name_prefix;
			names[p]= f_query_add_mod.document.booking_form.Name_Prefix_Prompt.value; //parent.frames[1].document.booking_form.Name_Prefix_Prompt.value;
			p++;
		}
	}

	if(f_query_add_mod.document.booking_form.first_name_reqd_yn !=null && f_query_add_mod.document.booking_form.first_name_reqd_yn.value =='Y' )
	{
		if(f_query_add_mod.document.booking_form.first_name != null && f_query_add_mod.document.booking_form.first_name.disabled == false)
		{
			if(f_query_add_mod.document.booking_form.first_name.value == "") {
				if(f_query_add_mod.document.booking_form.dflt_patient_name.value) {
					f_query_add_mod.document.booking_form.first_name.value = f_query_add_mod.document.booking_form.dflt_patient_name.value;
					f_query_add_mod.document.booking_form.first_name.onblur();
				} else	{				
					fields[p]=f_query_add_mod.document.booking_form.first_name;
					names[p]=f_query_add_mod.document.booking_form.First_Name_Prompt.value;
					p++;
				}
			}			
		}
	}

	if(f_query_add_mod.document.booking_form.second_name_reqd_yn !=null && f_query_add_mod.document.booking_form.second_name_reqd_yn.value =='Y' )	
	{
		if( f_query_add_mod.document.booking_form.second_name != null && f_query_add_mod.document.booking_form.second_name.disabled ==false)		
		{
			if(f_query_add_mod.document.booking_form.second_name.value == "") {
				if(f_query_add_mod.document.booking_form.dflt_patient_name.value){
					f_query_add_mod.document.booking_form.second_name.value = f_query_add_mod.document.booking_form.dflt_patient_name.value;
					f_query_add_mod.document.booking_form.second_name.onblur();
				 } else {			
					fields[p]=f_query_add_mod.document.booking_form.second_name;
					names[p]=f_query_add_mod.document.booking_form.Second_Name_Prompt.value;
					p++;		
			   }
			}
		}
	}

	if(f_query_add_mod.document.booking_form.third_name_reqd_yn !=null && f_query_add_mod.document.booking_form.third_name_reqd_yn.value =='Y' )	
	{
		if(f_query_add_mod.document.booking_form.third_name != null && f_query_add_mod.document.booking_form.third_name.disabled ==false)		
		{
			if(f_query_add_mod.document.booking_form.third_name.value == "") {
				if(f_query_add_mod.document.booking_form.dflt_patient_name.value) {
					f_query_add_mod.document.booking_form.third_name.value = f_query_add_mod.document.booking_form.dflt_patient_name.value;
					f_query_add_mod.document.booking_form.third_name.onblur();
			     } else {			
					fields[p]=f_query_add_mod.document.booking_form.third_name;
					names[p]=f_query_add_mod.document.booking_form.Third_Name_Prompt.value;
					p++;
				 }	
			}
		}
	}

	if(f_query_add_mod.document.booking_form.family_name_reqd_yn !=null && f_query_add_mod.document.booking_form.family_name_reqd_yn.value =='Y' )	
	{
		if(f_query_add_mod.document.booking_form.family_name != null && f_query_add_mod.document.booking_form.family_name.disabled ==false)
		{
			if(f_query_add_mod.document.booking_form.family_name.value == "") {
				if(f_query_add_mod.document.booking_form.dflt_patient_name.value) {
					f_query_add_mod.document.booking_form.family_name.value = f_query_add_mod.document.booking_form.dflt_patient_name.value;
					f_query_add_mod.document.booking_form.family_name.onblur();
			     } else {			
					fields[p]=f_query_add_mod.document.booking_form.family_name;
					names[p]=f_query_add_mod.document.booking_form.Family_Name_Prompt.value;
					p++;
				 }
			}
		}
	}

	if(f_query_add_mod.document.booking_form.name_suffix_reqd_yn !=null && f_query_add_mod.document.booking_form.name_suffix_reqd_yn.value =='Y' )
	//if(parent.frames[1].document.booking_form.name_suffix_reqd_yn !=null && parent.frames[1].document.booking_form.name_suffix_reqd_yn.value =='Y' )
	{
		/*if(f_query_add_mod.document.booking_form.name_suffix1 != null && f_query_add_mod.document.booking_form.name_suffix1.disabled ==false)
		{
			fields[p]=f_query_add_mod.document.booking_form.name_suffix1;
			names[p]=f_query_add_mod.document.booking_form.Name_Suffix_Prompt.value;
			p++;
		}*/

		if(f_query_add_mod.document.booking_form.name_suffix != null )
		//if(parent.frames[1].document.booking_form.name_suffix != null && parent.frames[1].document.booking_form.name_suffix.disabled ==false)
		{
			fields[p]= f_query_add_mod.document.booking_form.name_suffix; //parent.frames[1].document.booking_form.name_suffix;
			names[p]= f_query_add_mod.document.booking_form.Name_Suffix_Prompt.value; //parent.frames[1].document.booking_form.Name_Suffix_Prompt.value;
			p++;
		}
	}

	/************************************************/

	if(f_query_add_mod.document.booking_form.name_prefix_oth != null)
	//if(parent.frames[1].document.booking_form.name_prefix_oth != null)
	{
		if(f_query_add_mod.document.booking_form.name_prefix_oth.style.visibility == 'visible' )
		//if(parent.frames[1].document.booking_form.name_prefix_oth.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.name_prefix_oth_lang != null && f_query_add_mod.document.booking_form.name_prefix_oth_lang.disabled ==false)
			//if(parent.frames[1].document.booking_form.name_prefix_oth_lang != null && parent.frames[1].document.booking_form.name_prefix_oth_lang.disabled ==false)
			{
				fields[p]=f_query_add_mod.document.booking_form.name_prefix_oth_prompt;//parent.frames[1].document.booking_form.name_prefix_oth_prompt;
				names[p]=f_query_add_mod.document.booking_form.name_prefix_oth_lang.value;//parent.frames[1].document.booking_form.name_prefix_oth_lang.value;
				p++;
			}
		}
	}


	if(f_query_add_mod.document.booking_form.first_oth_name_reqd_yn != null)
	//if(parent.frames[1].document.booking_form.first_oth_name_reqd_yn != null)
	{
		if(f_query_add_mod.document.booking_form.first_oth_name_reqd_yn.style.visibility == 'visible' )
		//if(parent.frames[1].document.booking_form.first_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.first_name_oth_lang != null && f_query_add_mod.document.booking_form.first_name_oth_lang.disabled ==false)
			//if(parent.frames[1].document.booking_form.first_name_oth_lang != null && parent.frames[1].document.booking_form.first_name_oth_lang.disabled ==false)
			{
				fields[p]=f_query_add_mod.document.booking_form.first_name_oth_prompt; //parent.frames[1].document.booking_form.first_name_oth_prompt;
				names[p]=f_query_add_mod.document.booking_form.first_name_oth_lang.value; //parent.frames[1].document.booking_form.first_name_oth_lang.value;
				p++;
			}
		}
	}

	if(f_query_add_mod.document.booking_form.second_oth_name_reqd_yn != null)
	//if(parent.frames[1].document.booking_form.second_oth_name_reqd_yn != null)
	{
		if(f_query_add_mod.document.booking_form.second_oth_name_reqd_yn.style.visibility == 'visible' )
		//if(parent.frames[1].document.booking_form.second_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.second_name_oth_lang != null && f_query_add_mod.document.booking_form.second_name_oth_lang.disabled ==false)
			//if(parent.frames[1].document.booking_form.second_name_oth_lang != null && parent.frames[1].document.booking_form.second_name_oth_lang.disabled ==false)
			{
				fields[p]= f_query_add_mod.document.booking_form.second_name_oth_prompt; //parent.frames[1].document.booking_form.second_name_oth_prompt;
				names[p]= f_query_add_mod.document.booking_form.second_name_oth_lang.value;//parent.frames[1].document.booking_form.second_name_oth_prompt;
				p++;
			}
		}
	}

	if(f_query_add_mod.document.booking_form.third_oth_name_reqd_yn != null)
	{
		if(f_query_add_mod.document.booking_form.third_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.third_name_oth_lang != null && f_query_add_mod.document.booking_form.third_name_oth_lang.disabled ==false)
			{
				fields[p]=f_query_add_mod.document.booking_form.third_name_oth_prompt;
				names[p]=f_query_add_mod.document.booking_form.third_name_oth_lang.value;
				p++;
			}
		}
	}

	if(f_query_add_mod.document.booking_form.family_oth_name_reqd_yn != null)
	{
		if(f_query_add_mod.document.booking_form.family_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.family_name_oth_lang != null && f_query_add_mod.document.booking_form.family_name_oth_lang.disabled ==false)
			{
				fields[p]=f_query_add_mod.document.booking_form.family_name_oth_prompt;
				names[p]=f_query_add_mod.document.booking_form.family_name_oth_lang.value;
				p++;
			}
		}
	}


	if(f_query_add_mod.document.booking_form.name_suffix_oth != null)
	{
		if(f_query_add_mod.document.booking_form.name_suffix_oth.style.visibility == 'visible' )
		{
			if(f_query_add_mod.document.booking_form.name_suffix_oth_lang != null && f_query_add_mod.document.booking_form.name_suffix_oth_lang.disabled ==false)
			{
				fields[p]=f_query_add_mod.document.booking_form.name_suffix_oth_prompt;
				names[p]=f_query_add_mod.document.booking_form.name_suffix_oth_lang.value;
				p++;
			}
		}
	}

	if(f_query_add_mod.document.booking_form.sex !=null && f_query_add_mod.document.booking_form.sex.value =="")
	{
		fields[p]=f_query_add_mod.document.booking_form.sex;
		names[p]=getLabel("Common.gender.label","Common");
  		p++;
	}
	
	if(f_query_add_mod.document.booking_form.date_of_birth !=null && f_query_add_mod.document.booking_form.date_of_birth.value =="")
	{
		fields[p]=f_query_add_mod.document.booking_form.date_of_birth;
		names[p]= getLabel("Common.birthDate.label","Common");
		p++;
	}

	if(f_query_add_mod.document.booking_form.nationality_desc !=null &&
	  f_query_add_mod.document.booking_form.nationality_desc.value =="")
	{
		fields[p]=f_query_add_mod.document.booking_form.nationality_desc;
		names[p] = getLabel("Common.nationality.label","Common");
		p++;
	}
	
	/*
	if(f_query_add_mod.document.booking_form.citizen_yn[0].checked)
	{
		if(f_query_add_mod.document.booking_form.race_code !=null &&
		  f_query_add_mod.document.booking_form.race_code.value =="")
		{
			fields[p]=f_query_add_mod.document.booking_form.race_code;
			names[p] = getLabel("Common.race.label","Common");
			p++;
		}
	}
	*/

  // For 17676 
	if(f_query_add_mod.document.booking_form.race_required_yn.value == 'Y')
	{
	  	if(f_query_add_mod.document.booking_form.race_code !=null &&
			  f_query_add_mod.document.booking_form.race_code.value =="")
			{
				fields[p]=f_query_add_mod.document.booking_form.race_code;
				names[p] = getLabel("Common.race.label","Common");
				p++;
			}
	  }
	
	/* Added for IN:046495 by Dharma on 20th Jan 2014 Start*/
	if(f_query_add_mod.document.booking_form.alt_id1_reqd_yn.value == 'Y' && f_query_add_mod.document.booking_form.alt_id1_man_non_ctz && f_query_add_mod.document.booking_form.alt_id1_man_non_ctz.value=="true" )	{
		if(f_query_add_mod.document.booking_form.alt1_gif.style.visibility == 'visible') {
				fields[p]=f_query_add_mod.booking_form.alt_id1_no;
				names[p]=f_query_add_mod.booking_form.alt_id1_desc.value; 
				p++;
		}		 
	}
	
	if(f_query_add_mod.document.booking_form.alt_date1_reqd_yn.value == 'Y' && f_query_add_mod.document.booking_form.alt_id1_man_non_ctz && f_query_add_mod.document.booking_form.alt_id1_man_non_ctz.value=="true" )	{
		if(f_query_add_mod.document.booking_form.alt1_exp_date1.style.visibility == 'visible') {
				fields[p]=f_query_add_mod.booking_form.alt_id1_exp_date;
				names[p]=getLabel("Common.expiryDate.label","Common"); 
				p++;
		}		 
	}
			
		/* Added for IN:046495 by Dharma on 20th Jan 2014 End*/

	fields[p]= f_query_add_mod.document.booking_form.Splcode_desc;
	names[p] = getLabel("Common.speciality.label","Common");
	p++;

	fields[p]=f_query_add_mod.document.booking_form.practid_desc;
	names[p]=getLabel("Common.practitioner.label","Common");
	p++;


	/* Tuesday, February 16, 2010 19363
	if(blur == true)
	{
		//alert('adfasdf'+f_query_add_mod.document.location.href);
		if(f_query_add_mod.document.booking_form.first_name != null)
			f_query_add_mod.document.booking_form.first_name.onblur();
		else if(f_query_add_mod.document.booking_form.second_name != null)
			f_query_add_mod.document.booking_form.second_name.onblur();
		else if(f_query_add_mod.document.booking_form.third_name != null)
			f_query_add_mod.document.booking_form.third_name.onblur();
		else if(f_query_add_mod.document.booking_form.family_name != null)
			f_query_add_mod.document.booking_form.family_name.onblur();
			
	} end 19363
	*/ 


	// this code is written for validating patient prefix and suffix with the gender.
	var pat_prefix=true;
	var pat_suffix=true;
	LocalErrors = "";

	if (f_query_add_mod.document.booking_form.name_prefix != null && f_query_add_mod.document.booking_form.name_prefix.value.length != 0 && f_query_add_mod.document.booking_form.sex.value != '') 
	{
		pat_prefix=checkPatSexLocal();
		
	}

	if (f_query_add_mod.document.booking_form.name_suffix != null && f_query_add_mod.document.booking_form.name_suffix.value.length != 0 && f_query_add_mod.document.booking_form.sex.value != '') 
	{
		pat_suffix=checkPatSuffixSexLocal();				
	}
	
		
	if(pat_prefix==false || pat_suffix ==false)
	{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
		return false;
	}
	
	var maxAge = true
	if(f_query_add_mod.document.booking_form.date_of_birth !=null && f_query_add_mod.document.booking_form.date_of_birth.value !="")
	{
		maxAge = checkMaxAge();
	}
	if(maxAge == false )
	{
		
		if(f_query_add_mod.document.booking_form.call_function.value=="CA_Task_IP_Booking" || f_query_add_mod.document.booking_form.call_function.value=="CA_Clinician_IP_Booking" || f_query_add_mod.document.booking_form.call_function.value=="OT")
		{
			alert(LocalErrors);
			window.close();
		}else
		{
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
		}
		return false;
	}
	
	if(f_query_add_mod.document.booking_form.call_function.value=="CA_Task_IP_Booking" || f_query_add_mod.document.booking_form.call_function.value=="CA_Clinician_IP_Booking")
	{
		
		if(f_query_add_mod.checkFieldsForCA( fields, names, messageFrame))
		{

			if (f_query_add_mod.document.booking_form.bl_success.value=='N')
			{
				if(f_query_add_mod.document.booking_form.isBlInstalled.value == 'Y' && f_query_add_mod.document.booking_form.iscapture_fin_dtls_yn.value == 'Y')
				{
						//parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");

						messageFrame.location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");	
						return false;
				}
			}
			//Added by Mallikarjuna Reddy on 6/6/2003 
			if(f_query_add_mod.document.booking_form.confirm_yn.value == "Y")
			{
				var p = confirm(confAlertMsg);//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
				if(p)
					f_query_add_mod.document.booking_form.confirm_yn.value = "Y"; 
				else
					f_query_add_mod.document.booking_form.confirm_yn.value = "N"; 
				
			}
				
			enableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=false;
			f_query_add_mod.document.booking_form.patient_id.disabled= false;
			
			f_query_add_mod.document.booking_form.referral_id.disabled= false;	
			f_query_add_mod.document.booking_form.action = "../../servlet/eIP.BookingServlet";
			f_query_add_mod.document.booking_form.submit();
			disableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=true;
			f_query_add_mod.document.booking_form.patient_id.disabled= true;
		}
	}
	//Added by vinay on 11/3/2004 
	else if(f_query_add_mod.document.booking_form.call_function.value=="OA_IP_Booking")
	{
		if(f_query_add_mod.checkFieldsForOA( fields, names, messageFrame))
		{
			if (f_query_add_mod.document.booking_form.bl_success.value=='N')
			{
				if(f_query_add_mod.document.booking_form.isBlInstalled.value == 'Y' && f_query_add_mod.document.booking_form.iscapture_fin_dtls_yn.value == 'Y')
				{
						//parent.frames[2].location.href='../../eCommon/jsp/error.jsp?home_required_yn=N&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
					
						messageFrame.location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
						return false;
				}
			}
			if(f_query_add_mod.document.booking_form.confirm_yn.value == "Y")
			{
				var p = confirm(confAlertMsg);//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
				if(p)
					f_query_add_mod.document.booking_form.confirm_yn.value = "Y"; 
				else
					f_query_add_mod.document.booking_form.confirm_yn.value = "N"; 
				
			}
			
			enableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=false;
			f_query_add_mod.document.booking_form.patient_id.disabled= false;
			
			f_query_add_mod.document.booking_form.referral_id.disabled= false;		
			f_query_add_mod.document.booking_form.action = "../../servlet/eIP.BookingServlet";
			f_query_add_mod.document.booking_form.submit();
			disableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=true;
			f_query_add_mod.document.booking_form.patient_id.disabled= true;
		}
	} 
	else if(f_query_add_mod.document.booking_form.is_op_pending_referral_booking.value=="Y")
	{
			
		if(checkFieldsForPendingBooking( fields, names, messageFrame))
		{
			if (f_query_add_mod.document.booking_form.bl_success.value=='N')
			{
				if(f_query_add_mod.document.booking_form.isBlInstalled.value == 'Y' && f_query_add_mod.document.booking_form.iscapture_fin_dtls_yn.value == 'Y')
				{
						messageFrame.location.href='../../eCommon/jsp/error.jsp?home_required_yn=N&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
						//parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
						return false;
				}
			}
			if(f_query_add_mod.document.booking_form.confirm_yn.value == "Y")
			{
				var p = confirm(confAlertMsg);//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
				if(p)
					f_query_add_mod.document.booking_form.confirm_yn.value = "Y"; 
				else
					f_query_add_mod.document.booking_form.confirm_yn.value = "N"; 
				
			}
			
			enableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=false;
			f_query_add_mod.document.booking_form.patient_id.disabled= false;

			f_query_add_mod.document.booking_form.referral_id.disabled= false;		
			f_query_add_mod.document.booking_form.action = "../../servlet/eIP.BookingServlet";
			f_query_add_mod.document.booking_form.submit();
			disableNatId1();
			f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=true;
			f_query_add_mod.document.booking_form.patient_id.disabled= true;
		}	
	}
	else
	{	
		if(f_query_add_mod.document.booking_form.call_function.value == 'OT' )
		{
			if(checkFieldsForOT(fields, names, messageFrame))
			{
				
				if (f_query_add_mod.document.booking_form.bl_success.value=='N')
				{
					if(f_query_add_mod.document.booking_form.isBlInstalled.value == 'Y' && f_query_add_mod.document.booking_form.iscapture_fin_dtls_yn.value == 'Y')
					{
							messageFrame.location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&access=NYNNN&err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
							return false;
					}
				}

					
				if(f_query_add_mod.document.booking_form.confirm_yn.value == "Y")
				{
					var p = confirm(confAlertMsg);//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
					if(p)
						f_query_add_mod.document.booking_form.confirm_yn.value = "Y"; 
					else
						f_query_add_mod.document.booking_form.confirm_yn.value = "N"; 
					
				}
				enableNatId1();
				f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=false;
				f_query_add_mod.document.booking_form.patient_id.disabled= false;

				f_query_add_mod.document.booking_form.referral_id.disabled= false;		
				f_query_add_mod.document.booking_form.action = "../../servlet/eIP.BookingServlet";
				f_query_add_mod.document.booking_form.submit();
				disableNatId1();
				f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=true;
				f_query_add_mod.document.booking_form.patient_id.disabled= true;
					
			}	
			
		}				
		else
		{
			if(checkFields( fields, names, messageFrame))
			{	
				if (f_query_add_mod.document.booking_form.bl_success.value=='N')
				{	
					if(f_query_add_mod.document.booking_form.isBlInstalled.value == 'Y' && f_query_add_mod.document.booking_form.iscapture_fin_dtls_yn.value == 'Y')
					{
						messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
						return false;
					}
				}

				if(f_query_add_mod.document.booking_form.confirm_yn.value == "Y")
				{
					var p = confirm(confAlertMsg);//Modified by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
					if(p)
						f_query_add_mod.document.booking_form.confirm_yn.value = "Y"; 
					else
						f_query_add_mod.document.booking_form.confirm_yn.value = "N"; 
					
				}
				
				enableNatId1();
				f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=false;
				f_query_add_mod.document.booking_form.patient_id.disabled= false;
				f_query_add_mod.document.booking_form.referral_id.disabled= false;	
				
				f_query_add_mod.putPatientName(f_query_add_mod.document.booking_form.first_name);
				f_query_add_mod.putLocalLangPatientName();
				f_query_add_mod.document.booking_form.action = "../../servlet/eIP.BookingServlet";
				f_query_add_mod.document.booking_form.submit();
				disableNatId1();
				f_query_add_mod.document.booking_form.exp_days_of_stay.disabled=true;
				f_query_add_mod.document.booking_form.patient_id.disabled= true;
			}	
		}
	}
}

function confirm_click(obj)
{
	if(obj.checked==true)
	{
		document.getElementById('bed_detail').style.visibility="visible"
		
	}
	else
	{
		document.getElementById('bed_detail').style.visibility="hidden"
		
	}
}
function serviceLookupBlur(facilityID)
{

	if(document.forms[0].service_desc_hid.value != document.forms[0].service_desc.value)
	{
		if(document.forms[0].service_desc.value != "")
		 serviceLookup(facilityID);
	}

}
async function serviceLookup(facilityID)
{
	var target					= document.forms[0].service_desc;
	var sql						= "";
	var facilityID				= facilityID;
	var nurs_unit_cd			= document.forms[0].nursing_unit.value;
	var tit						= getLabel("Common.service.label","Common");
	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var locale					= document.forms[0].locale.value;

	sql = " select service_code code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 ) service_short_desc description from ip_nurs_unit_for_service where facility_id = '"+facilityID+"' and nursing_unit_code = '"+nurs_unit_cd+"' AND upper(service_code) like upper(?) and upper(am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 )) like upper(?) union select service_code code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 ) service_short_desc description from IP_NURSING_UNIT where facility_id ='"+facilityID+"' and nursing_unit_code = '"+nurs_unit_cd+"' and upper(service_code) like upper(?) and upper(am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 )) like upper(?) ";			
	
	dataNameArray[0]	= "service_code" ;
	dataValueArray[0]	= document.forms[0].service_desc.value;
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "service_short_desc" ;
	dataValueArray[1]	= document.forms[0].service_desc.value;
	dataTypeArray[1]	= STRING;	
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "3,4";
	argumentArray[5]	= document.forms[0].service_desc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
					
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].service_desc.value=arr[1];
		document.forms[0].service_code.value=arr[0];
		document.forms[0].service_desc_hid.value = document.forms[0].service_desc.value
	
	}
	

}

function ClearNursingUnitDtls()
{
	parent.frames[1].document.booking_form.bed_no.value='';
	parent.frames[1].document.booking_form.room_no.value='';
}

function bedclassLookupBlur()
{
	if(document.forms[0].bed_class_desc.value == "")
	{
		document.forms[0].bed_no.value = "";		document.forms[0].room_no.value = "";
	}
	if(document.forms[0].bed_class_desc_hid.value != document.forms[0].bed_class_desc.value)
	{
		if(document.forms[0].bed_class_desc.value != "")
		 bedclassLookup()
	}
}

async function bedclassLookup()
{
	var target					= document.forms[0].bed_class_desc;
	var sql						= "";
	
	var tit						= getLabel("Common.BedClass.label","common");
	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var locale					= document.forms[0].locale.value;

	sql = " select bed_class_code code,short_desc description from IP_BED_CLASS_LANG_VW where eff_status='E' and language_id = '"+locale+"' and upper(bed_class_code) like upper(?) and upper(short_desc) like upper(?) ";			
					
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= document.forms[0].bed_class_desc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
					
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].bed_class_desc.value=arr[1];
		document.forms[0].bed_class_code.value=arr[0];
		document.forms[0].bed_class_desc_hid.value = document.forms[0].bed_class_desc.value
	
	}
	else
	{
		document.forms[0].bed_no.value  = "";
		document.forms[0].room_no.value ="";
	}
}



function NursingUnitLookupBlur(Facility_ID,Login_User,Operator_Station_ID)
{
	if(document.forms[0].nursing_unit_desc.value=='')
	{
		delete_values(document.getElementById("service_desc"));
		if(document.forms[0].confirm_yn.value == "Y")
		{
			delete_values(document.getElementById('bed_type_desc'));
			delete_values(document.getElementById('bed_class_desc'));
			document.forms[0].bed_no.value = "";

			document.forms[0].bed_avail_chart.disabled = false;
			document.forms[0].bed_no.value = '';
			document.forms[0].room_no.value = '';
			// Below code add for the for this incident 17333
			document.forms[0].override.checked = false;
			document.forms[0].override.disabled = true;
		}
		document.forms[0].nursing_unit.value='';

	}
	var oldValFlag = false;
	if(document.forms[0].nurs_unit_desc_hid.value != document.forms[0].nursing_unit_desc.value)
		oldValFlag = true;

	if(oldValFlag)
	{
		
		if(document.forms[0].nursing_unit_desc.value != "")
			NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID)
		else
		{	
			document.forms[0].service_code.value = "";
			document.forms[0].service_desc.value = "";
		}
	}
}

function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
			var nursingunit = self.document.forms[0].nursing_unit.value;
			var to_bed_no	= self.document.forms[0].old_bed_no.value;
			var bedno		= self.document.forms[0].bed_no.value;
			var create_booking_with_conf_yn = self.document.forms[0].create_booking_with_conf_yn.value;
			var deactivate_pseudo_bed_yn = self.document.forms[0].deactivate_pseudo_bed_yn.value;
			var from_date	=	convertDate(self.document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");
			var to_date		=	convertDate(self.document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en");
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Booking_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'><input type='hidden' name='bedClass' id='bedClass' value='"+document.forms[0].bed_class_code.value+"'><input type='hidden' name='from_date' id='from_date' value='"+from_date+"'><input type='hidden' name='to_date' id='to_date' value='"+to_date+"'><input type='hidden' name='create_booking_with_conf_yn' id='create_booking_with_conf_yn' value='"+create_booking_with_conf_yn+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
			//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.dum_form.submit();
		}
	}
}

async function openBedChart(ref)
{	

	if(document.forms[0].med_service_grp.value=='' && parent.frames[1].document.booking_form.call_function.value == 'OT')
	{
		var msg =   getMessage("CAN_NOT_BE_BLANK","Common");
		msg		=	msg.replace("$",getLabel("eIP.MedicalServiceGroup.label","IP"));
		parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&access=NYNNN&err_num='+msg;
		document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.value='';
		return false;
	}
	if(document.forms[0].Splcode_desc.value != "" && document.forms[0].pref_adm_date.value!="")
	{

			var nursingunit = "";
			var practitionerid = "";
			var specialitycode = "";
			var bedclasscode  = "";
			var bedtypecode  = "";
			var med_service_grp  = "";
			var admission_date_time = "";
			var exp_discharge_date = "";

			if(document.forms[0].nursing_unit_desc.value != "")
				nursingunit = document.forms[0].nursing_unit.value;
			if(document.forms[0].practid_desc.value != "")
				practitionerid = document.forms[0].practid.value;
			if(document.forms[0].Splcode_desc.value != "")
				specialitycode = document.forms[0].Splcode.value;

			if(document.forms[0].bed_class_code.value != "")
				bedclasscode = document.forms[0].bed_class_code.value;
			if(document.forms[0].bed_type_desc.value != "")
				bedtypecode = document.forms[0].bed_type_desc.value;
			if(document.forms[0].med_service_grp.value != "")
				med_service_grp = document.forms[0].med_service_grp.value;
			if(document.forms[0].pref_adm_date.value != "")
				admission_date_time = document.forms[0].pref_adm_date.value;
			if(document.forms[0].exp_discharge_date.value != "")
				exp_discharge_date = document.forms[0].exp_discharge_date.value;

			var gender = document.forms[0].sex.value;
			var agevalue = document.forms[0].b_age.value+"Y"+document.forms[0].b_months.value+"M";
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
			var retVal = 	new String();
			var dialogHeight= "75vh" ;
			var dialogWidth	= "73vw" ;
			var dialogTop	= "0";
			var status = "no";
			var arguments	= "" ;
			var wherecondn = "CREATE_BOOKING_YN";
			var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			var func_name = document.forms[0].call_function.value;

			
			
			if(nursingunit!=null&&nursingunit!="")
			{
		
		
				// retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?create_booking_admission_date_time="+admission_date_time+"&exp_discharge_date="+exp_discharge_date+"&enable_bed_date=Y&wherecondn="+wherecondn+"&disable_field=NursingUnitSpecialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&call_function="+func_name+"&med_service_grp="+med_service_grp,arguments,features);
			}
			else
			{
				retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?create_booking_admission_date_time="+admission_date_time+"&exp_discharge_date="+exp_discharge_date+"&enable_bed_date=Y&wherecondn="+wherecondn+"&disable_field=specialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&call_function="+func_name+"&med_service_grp="+med_service_grp,arguments,features);
			}
			
			
			if (retVal != null)
			{
				var arr = retVal.split("^");
				
				if (arr.length > 2)
				{
					var arr1 = arr[1].split("/");
					parent.frames[1].document.forms[0].nursing_unit_desc.value=arr[9];
					parent.frames[1].document.forms[0].nursing_unit.value=arr[0];
					if(bedclasscode != arr[3] || bedclasscode == "" || bedtypecode == "")	
						populateBedType(arr[3], arr[2],"Bed_Avaibility_Chart_Validation");					
					parent.frames[1].document.forms[0].bed_no.value = arr1[0];
					parent.frames[1].document.forms[0].room_no.value = arr[4];
					parent.frames[1].document.forms[0].override.disabled=false;	
					parent.frames[1].document.forms[0].room_no.focus();
					parent.frames[1].document.forms[0].bed_class_desc.value = arr[3];
				}
				else
				{
					parent.frames[1].document.forms[0].nursing_unit.value=arr[0];
					if (arr.length == 2)
						parent.frames[1].document.forms[0].nursing_unit_desc.value = arr[1];
				}
			}
	}
	else
	{
		if(document.forms[0].Splcode_desc.value == "")
		{
			alert(getMessage("SPLTY_NOTNULL","IP"));
			document.forms[0].Splcode_desc.focus();
		}
		else if(document.forms[0].pref_adm_date.value=="")
		{
			alert(getMessage("PREF_ADMN_DATE_NOTNULL","IP"));
			if( document.forms[0].pref_adm_date.readOnly == false && document.forms[0].pref_adm_date.disabled == false )
			{
				document.forms[0].pref_adm_date.focus();
			}

		}
	}
}

function changeOVRVal(obj)
{
	if(obj.checked==true)
	document.forms[0].override_yn.value="Y";
	else
	document.forms[0].override_yn.value="N";
}
function Control_NursingUnit()
{
	if(document.forms[0].confirm_yn.value == "Y")
	{
		document.forms[0].override.disabled	= true;
		if(document.forms[0].bed_no.value !="")
		{
			document.forms[0].bno.value		=	document.forms[0].bed_no.value;
			document.forms[0].rno.value		=	document.forms[0].room_no.value;
			document.forms[0].nunitcode.value		=	document.forms[0].nursing_unit.value;

			document.forms[0].bed_class_desc.disabled	= true;
			document.forms[0].bed_class_lookup.disabled	= true;
			document.forms[0].nursing_unit_desc.disabled	= true;
			document.forms[0].nursing_unit_lookup.disabled=true;
			document.forms[0].room_no.disabled	= true;
			document.forms[0].override.disabled	= true;
			document.forms[0].bed_avail_chart.disabled = true;
		}
	}
}
async function bookAppoint()
{
	var P_patient_id = document.forms[0].patient_id.value;		
	var P_locn_code = document.forms[0].clinic_location.value;		
	var P_practitioner_id = document.forms[0].practid.value;	
	var ref_code = document.forms[0].referral_id.value;	
	var to_specialty_code = document.forms[0].Splcode.value;
	var server_date = document.forms[0].pref_adm_date.value;
	var tmp_val = server_date.split(" ");
	server_date = tmp_val[0];
	server_time = tmp_val[1];
	var P_locn_type = "C";
		
	var dialogHeight= "70vh" ;
	var dialogTop = "90" ;
	var dialogWidth	= "50vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var h="i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&location_code="+P_locn_code+"&referral_id="+ref_code+"&specialty_code="+to_specialty_code+"&recall_date="+server_date+"&locn_type="+P_locn_type+"&ca_mode=ca_mode&DirectIP=Y&callingMode=IP&title=Book Appointment";
	retVal = await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+h+"&title=Book Appointment",arguments,features);
	
	if (retVal != null)
	{
		var returnVal = retVal.split("^");
		var mode = returnVal[0];
		h = returnVal[1];

		if (mode=="1")
		{
			retVal = await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h+"&title=Book Appointment",arguments,features);
			
			if(retVal != null)
			{
				var tmpVal = retVal.split("*");
				document.forms[0].ot_date_time.value = server_date + " " +tmpVal[1];
				document.forms[0].appt_ref.value = tmpVal[0];
			}	
		}
		else if (mode=="2")
		{
			retVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h+"&title=Book Appointment",arguments,features);
			if (retVal=="OP")
				bookAppoint();
		}
		else if (mode=="3")
		{
			retVal = window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h+"&title=Book Appointment",arguments,features);
			if (retVal=="OP")
				bookAppoint();
		}
	}
}
function procChange()
{
	var sStyle = document.forms[0].sStyle.value;
	var source_type = "LOCATION";
	var procedure = parent.frames[1].document.forms[0].surg_proc.value;
	parent.frames[1].document.forms[0].clinic_location.disabled = false;
	var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetch' id='fetch' method='post' action='../../eIP/jsp/FetchValForBooking.jsp'><input type='hidden' name='source_type' id='source_type' value='"+source_type+"'><input type='hidden' name='procedure' id='procedure' value='"+procedure+"'>";
	HTMLVal = HTMLVal+"</form></body></html>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.fetch.submit();
}

function locChange()
{
	if((document.forms[0].clinic_location.value != "") &&(parent.frames[1].document.forms[0].book_appt.disabled = true))
	parent.frames[1].document.forms[0].book_appt.disabled = false;
	else
	parent.frames[1].document.forms[0].book_appt.disabled = true;
}

//============= function added by Ranjani ======================
//=============== For reason code look up =============
async function ReasonLookup()
{
	
		var tit				= getLabel("Common.ReasonforAdmission.label","Common");
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var locale			= document.forms[0].locale.value;

		//sql=" select complaint_code code,complaint_desc description from AM_COMPLAINT_LANG_VW where language_id = '"+locale+"' and eff_status like ? and  upper(complaint_code) like upper(?) and upper(complaint_desc)  like upper(?)" ;	   
		sql=" select complaint_code code,am_get_desc.AM_COMPLAINT(complaint_code,'"+locale+"',1) description from AM_COMPLAINT where eff_status like ? and  upper(complaint_code) like upper(?) and upper(complaint_desc)  like upper(?)" ;	   
			
		dataNameArray[0] = "eff_status" ;
		dataValueArray[0]= "E";
		dataTypeArray[0] = STRING;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3";
		argumentArray[5] = document.forms[0].chief_complaint.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		retVal = await CommonLookup( tit, argumentArray );

		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			
			document.forms[0].chief_complaint.value=arr[1];
			document.forms[0].complaintcode.value=arr[0];
			document.forms[0].chief_complaint_hid.value = document.forms[0].chief_complaint.value
		}
		else
		{
			document.forms[0].chief_complaint.value="";
			document.forms[0].complaintcode.value="";
		}
}

function ReasonLookupBlur()
{
	var oldValFlag = false;
	if(document.forms[0].chief_complaint_hid.value != document.forms[0].chief_complaint.value)
		oldValFlag = true;
	if(oldValFlag)
	{	if(document.forms[0].chief_complaint.value!="")
		ReasonLookup();
	}
}
function getPractID(obj,target)
{
	
	if(document.forms[0].practid_desc.value=='')
	document.forms[0].practid.value='';

	if((document.forms[0].Splcode_desc.value != "") ||(document.forms[0].Splcode.value != ""))
		{
			var practName_FName="";
			var practName_FValue="";
			var practId_FName="";
			
			practName_FName=target.name;
			practName_FValue=target.value;
			practId_FName=document.forms[0].practid.name;
			var splty = document.forms[0].Splcode.value;
			var facility_id = document.forms[0].faclity_id.value;
			var sql2="";
	       locale=document.forms[0].locale.value;
			/*sql = "select A.FACILITY_ID, A.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, A.SPECIALTY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM AM_PRACT_ALL_SPLTY_VW A WHERE  A.FACILITY_ID = '"+facility_id+"' AND A.SPECIALTY_CODE = '"+splty+"' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR   UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND 1 = 1";

			sql2 = "select A.FACILITY_ID, A.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, A.SPECIALTY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM AM_PRACT_ALL_SPLTY_VW A WHERE  A.FACILITY_ID = '"+facility_id+"' AND A.SPECIALTY_CODE = '"+splty+"' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and   UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND 1 = 1";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " sql=\"" +escape(sql)+ "\"";
			xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + splty+ "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";
			
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);	*/

			getPractitioner(obj,target,facility_id,splty,"","Q1");



			
		}else
		{	
			var msg = getMessage('CAN_NOT_BE_BLANK',"Common");
			msg = msg.replace('$',getLabel("Common.speciality.label","Common"));

			if(msg != "")
				parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"";
			
		}

}
function getPractIDBlur(obj,target)
{
	var speciality = document.forms[0].Splcode.value;
	var facility_id = document.forms[0].faclity_id.value;
	
	

	if(document.forms[0].practid_desc.value=='')
	document.forms[0].practid.value='';
	
	var oldValFlag = false;
	if(document.forms[0].practid_desc_hid.value != document.forms[0].practid_desc.value)
		oldValFlag = true;
	if(oldValFlag)
	{
		if(document.forms[0].practid_desc.value!="")
		{
			getPractID(obj,target,speciality )
			//getPractitioner(obj,target,facility_id,speciality);
		}
		else
		{
			document.forms[0].team_id.value="";
			document.forms[0].team_id.disabled=true;
		}
	}
}

function PractLookupRetVal(retVal,objName)
{

	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];
		document.forms[0].practid_desc_hid.value = document.forms[0].practid_desc.value
		document.forms[0].team_id.disabled=false;
		PopulateMedicalTeam1();
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].practid_desc.value="";
		document.forms[0].team_id.disabled=true;
		document.forms[0].team_id.value="";
	}

}

function disableNatId1(callobj)
{

	if(parent.frames[1])
		varBodyFrame = "parent.frames[1]";
	else
		varBodyFrame = "parent.frames[2].frames[1]";

	if((parent.frames[1].name == "menucontent") && (parent.frames[2].name == "content") && (parent.frames[2].frames[1].name == "f_query_add_mod"))
		varBodyFrame = "f_query_add_mod";

	if(parent.frames[2].frames[1].document.forms[0].birth_place && parent.frames[2].frames[1].document.forms[0].birth_place.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].birth_place.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].ethnic_group && parent.frames[2].frames[1].document.forms[0].ethnic_group.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].ethnic_group.disabled = true;
	}

	if(parent.frames[2].frames[1].document.forms[0].place_of_birth && parent.frames[2].frames[1].document.forms[0].place_of_birth.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].place_of_birth.disabled = true;
	}
	/*
	if(eval(varBodyFrame+".document.getElementById("race_code")") != null)
	{
		eval(varBodyFrame+".document.getElementById("race_code")").disabled = true;
	}
	*/
	if(parent.frames[2].frames[1].document.forms[0].race_desc && parent.frames[2].frames[1].document.forms[0].race_desc.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].race_desc.disabled = true;
		parent.frames[2].frames[1].document.forms[0].race_desc_id.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].patient_name && parent.frames[2].frames[1].document.forms[0].patient_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].patient_name.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_prefix1 && parent.frames[2].frames[1].document.forms[0].name_prefix1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix1.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_prefix && parent.frames[2].frames[1].document.forms[0].name_prefix.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].first_name && parent.frames[2].frames[1].document.forms[0].first_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].first_name.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].second_name && parent.frames[2].frames[1].document.forms[0].second_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].second_name.disabled = true
	}
	if(parent.frames[2].frames[1].document.forms[0].third_name && parent.frames[2].frames[1].document.forms[0].third_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].third_name.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].family_name && parent.frames[2].frames[1].document.forms[0].family_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].family_name.disabled = true;
	}
	/*Wednesday, January 12, 2011 , IN025850*/
	if(parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang && parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].first_name_oth_lang && parent.frames[2].frames[1].document.forms[0].first_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].first_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].second_name_oth_lang && parent.frames[2].frames[1].document.forms[0].second_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].second_name_oth_lang.disabled = false
	}
	if(parent.frames[2].frames[1].document.forms[0].third_name_oth_lang && parent.frames[2].frames[1].document.forms[0].third_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].third_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].family_name_oth_lang && parent.frames[2].frames[1].document.forms[0].family_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].family_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang && parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang.disabled = false;
	}
	/**/
	if(parent.frames[2].frames[1].document.forms[0].name_suffix1 && parent.frames[2].frames[1].document.forms[0].name_suffix1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix1.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_suffix && parent.frames[2].frames[1].document.forms[0].name_suffix.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].sex && parent.frames[2].frames[1].document.forms[0].sex.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].sex.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].date_of_birth && parent.frames[2].frames[1].document.forms[0].date_of_birth.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].date_of_birth.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_age && parent.frames[2].frames[1].document.forms[0].b_age.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_age.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_months && parent.frames[2].frames[1].document.forms[0].b_months.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_months.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_days && parent.frames[2].frames[1].document.forms[0].b_days.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_days.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].dob && parent.frames[2].frames[1].document.forms[0].dob.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].dob.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].nationality_code1 && parent.frames[2].frames[1].document.forms[0].nationality_code1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].nationality_code1.disabled = true
	}
	if(parent.frames[2].frames[1].document.forms[0].citizen_yn[0] && parent.frames[2].frames[1].document.forms[0].citizen_yn[0].value != null)
	{
		parent.frames[2].frames[1].document.forms[0].citizen_yn[0].disabled = true;		
	}
	if(parent.frames[2].frames[1].document.forms[0].citizen_yn[1] && parent.frames[2].frames[1].document.forms[0].citizen_yn[1].value != null)
	{
		parent.frames[2].frames[1].document.forms[0].citizen_yn[1].disabled = true;				
	}
	if(parent.frames[2].frames[1].document.forms[0].national_id_no && parent.frames[2].frames[1].document.forms[0].national_id_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].national_id_no.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id1_no && parent.frames[2].frames[1].document.forms[0].alt_id1_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id1_no.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id2_no && parent.frames[2].frames[1].document.forms[0].alt_id2_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id2_no.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id3_no && parent.frames[2].frames[1].document.forms[0].alt_id3_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id3_no.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id4_no && parent.frames[2].frames[1].document.forms[0].alt_id4_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id4_no.disabled = true;					
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date.disabled = true;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date.disabled = true;					
	}

	if(parent.frames[2].frames[1].document.forms[0].other_alt_type && parent.frames[2].frames[1].document.forms[0].other_alt_type.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].other_alt_type.disabled = true;
	}

	if(parent.frames[2].frames[1].document.forms[0].other_alt_Id && parent.frames[2].frames[1].document.forms[0].other_alt_Id.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].other_alt_Id.disabled = true;
	}

  return true;
}

/// Added by SRIDHAR R On 19 OCT 2004 for clearing Bed No & Room No if BED_TYPE is changed...
function clearBedValues()
{
	document.forms[0].bed_no.value='';
	document.forms[0].room_no.value='';
}

/// Added by SRIDHAR R On 19 OCT 2004 for clearing the options...
function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt=document.createElement("Option");
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value="";
	field.add(opt);
}

/// This function will pass the nursing unit value to BookingValidation.jsp & will populate the service Values based on Nursing Unit. also populates Bed class based on nursing unit.
function PopulateService()
{	
	//delete_values(document.getElementById("service_desc"));
	//delete_values(document.getElementById("bed_class_desc"));
	if(nursingunit != "")/*16586*/
	{
		var nursingunit = self.document.forms[0].nursing_unit.value;
		var create_booking_with_conf_yn = self.document.forms[0].create_booking_with_conf_yn.value;
		var deactivate_pseudo_bed_yn = self.document.forms[0].deactivate_pseudo_bed_yn.value;
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+
	" <input type='hidden' name='nursingUnitCode' id='nursingUnitCode' value='"+nursingunit+"'><input type='hidden' name='criteria' id='criteria' value='PopulateService'><input type='hidden' name='callingfrom' id='callingfrom' value='createBooking'><input type='hidden' name='create_booking_with_conf_yn' id='create_booking_with_conf_yn' value='"+create_booking_with_conf_yn+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}
}


/// This function will pass the BEd Class value to BookingValidation.jsp & will populate the BED TYPE Values based on bed class and nursing unit.. or only based on bed class based on deactivate pseudo bed_yn
function populateBedType(bedClass, bedType,validationType)
{
	self.document.forms[0].bed_class_code.value=bedClass;	
    var nursingUnitCode = self.document.forms[0].nursing_unit.value;
    var service_desc	= self.document.forms[0].service_desc.value;
    var deactivate_pseudo_bed_yn = self.document.forms[0].deactivate_pseudo_bed_yn.value;
	var create_booking_with_conf_yn = self.document.forms[0].create_booking_with_conf_yn.value;
	delete_values(document.getElementById('bed_type_desc'));
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'><input type='hidden' name='bedClass' id='bedClass' value='"+bedClass+"'><input type='hidden' name='nursingUnitCode' id='nursingUnitCode' value='"+nursingUnitCode+"'><input type='hidden' name='service_desc' id='service_desc' value='"+service_desc+"'><input type='hidden' name='bedType' id='bedType' value='"+bedType+"'><input type='hidden' name='criteria' id='criteria' value='PopulateBedType'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'><input type='hidden' name='create_booking_with_conf_yn' id='create_booking_with_conf_yn' value='"+create_booking_with_conf_yn+"'><input type='hidden' name='validationType' id='validationType' value='"+validationType+"'></form></body></html>";

	if(validationType=="Bed_Avaibility_Chart_Validation")
		parent.frames[2].document.write(HTMLVal);
	else
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	
	parent.frames[2].document.dum_form.submit();
}

function bedtypeLookupBlur()
{
	if(document.forms[0].bed_type_desc.value == "")
	{
		document.forms[0].bed_no.value = "";
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
	var tit						= getLabel("Common.bedtype.label","Common");
	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var locale					= document.forms[0].locale.value;

	sql = " select bed_type_code code,short_desc description from IP_BED_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status='E' and upper(bed_type_code) like upper(?) and upper(short_desc) like upper(?) ";			
					
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
	}
	else
	{
		document.forms[0].bed_no.value  ="";
		document.forms[0].room_no.value ="";
	}
}

function gifdelay()
{
	if(unregisteredpatientsbkgyn=="N")
		document.forms[0].gifval.value="Y";
	else
		document.forms[0].gifval.value="N";
}

function localValidations(obj)
{
	// for patient id validaion, which are specific to ip. we have to include here.
	// blank function... called on blur of patientid field.

	if(document.forms[0].patient_id.value!='')
		document.getElementById('OpenBooking').innerHTML = "<a href='javascript:showOpenBooking(document.forms[0].patient_id.value);'>"+getLabel("eIP.ViewOpenBookings.label","IP")+"</a>";
	else
		document.getElementById('OpenBooking').innerHTML = "" ;


}


async function showOpenBooking(patientid)
{
	if(patientid=='')
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg);
	}
	else
	{
		var retVal		= new String();
		var dialogHeight= "30";
		var dialogWidth	= "60";		
		var dialogTop	= "72";
		var center		= "";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=auto; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var title= getLabel("eIP.ViewOpenBookings.label","IP");
		var bkg_grace_period = 	document.forms[0].bkg_grace_period.value
		/* commented for Thursday, December 17, 2009 17368*/
		//retVal = window.showModalDialog("../../eIP/jsp/BookingReferenceLookupResult.jsp?title="+title+"&param=BOOKING&patient_id="+patientid+"&oper_stn_id="+document.forms[0].p_oper_stn_id.value+"&call_function=RCB&ismult_bkg_yn=Y",arguments,features);
		
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH step='Three' patientid=\""+patientid+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		
		if(responseText > 0)
		{
			retVal = await window.showModalDialog("../../eIP/jsp/BookingReferenceLookup.jsp?title="+title+"&param=BOOKING&patient_id="+patientid+"&oper_stn_id="+document.forms[0].p_oper_stn_id.value+"&call_function=RCB&ismult_bkg_yn=Y&&bkg_grace_period="+bkg_grace_period,arguments,features);
		}else
		{
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
			alert(msg);
		}
		
	}
}
function chkfunc(Obj)
{
	var OTv = Obj.value;
}

function ViewRefDetails()
{
	refid = document.forms[0].referral_id.value;
	var retVal		= new String();
	var dialogHeight= "30" ;
	var dialogTop	= "90" ;
	var dialogWidth	= "50" ;
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+refid,arguments,features);
}

// This fucntion is used to check the maximum no of characters fro the field
function checkMaxLimitComp(obj,maxSize)
{	
	if(makeValidString(obj)==false)
	   return false
	else
	{
		if ( obj.value.length >= maxSize )
		{
			alert(getMessage("CH_COMP_EXCD_200_CHARS","IP"));	
			obj.focus();obj.select();
		}
	}
}

// This fucntion is used for validating the number input
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

//Function to check the Entered value 
function Allfunc(obj1,obj2)
{  
	
	document.forms[0].bl_success.value = "N";

	if(obj1.value != '')
	{
		
		if(validDateObj(obj1,"DMYHM",localeName))
		{	
			var greg_obj1 = convertDate(obj1.value,"DMYHM",localeName,"en");
			var greg_obj2 = obj2.value
			if(isAfter(greg_obj1, greg_obj2, "DMYHM", 'en'))
			{
				
				setTimeout('ChangeVal(document.forms[0].pref_adm_date)',20);
				
				obj1.text="";
				dateCal(obj1);
				
				
				/*var dayOfWeek = getDayOfWeekAsLongText(greg_obj1,"DMYHM", 'en');
				if(dayOfWeek!=null || dayOfWeek!='')
					document.forms[0].all.DayVal.innerHTML="<b>"+dayOfWeek+"</b>";
				else
					document.forms[0].all.DayVal.innerText='';*/
	  
			}
			else
			{
				alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
				
				if(document.forms[0].call_function.value == "OT")
				{
					document.forms[0].pref_adm_date.value = '';
					document.forms[0].pre_op_days.focus();
				}
				else
				{
					if( document.forms[0].pref_adm_date.readOnly == false && document.forms[0].pref_adm_date.disabled == false )
					{
						document.forms[0].pref_adm_date.value = '';
						document.forms[0].pref_adm_date.focus();
						//document.forms[0].pref_adm_date.select();
						
					}

				}
			}
		}
		else
		{
			document.getElementById('DayVal').innerText='';
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			//obj1.focus()
			return;
		}
	}	
	else
		document.getElementById('DayVal').innerText=''; 

	if(document.forms[0].pref_adm_date.value!="")
	{
		if(document.forms[0].bed_no!=null && document.forms[0].room_no!=null)
		{
			if(document.forms[0].bed_no.value!="")
			{
				alert(getMessage("REMOVE_BED","IP"));
				document.forms[0].bed_no.value="";
				document.forms[0].room_no.value="";
			}		
		}
	}
	
	

}

// This function is used to chk the value should not be less than 0	
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
		CheckNum(obj);
}

// This function is used for validating the preffered admission date
/*function ValidateprefDateTime(from,to)
{	
	var a = from.split(" ")
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
		alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
		document.forms[0].pref_adm_date.focus();
		document.forms[0].pref_adm_date.select();
		return false
	 }
	 else
		return true;
}	*/


function AMValFunc(obj)
{
	if(document.booking_form.pref_adm_date.value.length != 0)
		ChangeVal(obj);	
}

// function to populate the day of the entered pref adm Date***/
function dateCal(obj)
{
	var greg_obj1 = convertDate(obj.value,"DMYHM",localeName,"en");
	var dayOfWeek = getDayOfWeek(greg_obj1,"DMYHM", 'en');
	var Vdate= parseInt(dayOfWeek);
	/*var to_proceed = true;
	var dateval = obj

	if (to_proceed==true)
	{
		if(obj.length > 0)
	   {
		   dateVal= new Date(obj);
		   var strDateArray = new Array();
		   strDate = obj;
		   strDateArray = strDate.split("/");
		   strDay   = strDateArray[0];
		   strMonth = strDateArray[1];
		   strYear  = strDateArray[2];   

		   Vdate = new Date(strMonth+'/'+ strDay +'/'+ strYear)   
		   if(Vdate != "NaN")
		   {*/	   
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
				}
			   /*document.forms[0].all.DayVal.innerHTML="<b>"+Vdate+"</b>";
			 }  
	   }
	   else
	   {
		   document.forms[0].all.DayVal.innerText='';
	   }
	}*/

	if(Vdate!=null)
	   document.getElementById('DayVal').innerHTML="<b>"+Vdate+"</b>";
	else
		document.getElementById('DayVal').innerText='';
}

function movtab()
{
		//document.forms[0].med_service_grp.focus();
}

//MP related prefix and suffix fields validation

function checkPatSexLocal()  
{

	
   // var arLength = f_query_add_mod.document.getElementById("NamePrefixArray").length;
   var arLength = f_query_add_mod.NamePrefixArray.length;

    var q = 0;
    var res = new Boolean(false);

     while ( q <= arLength  )
	{

             if ( (f_query_add_mod.document.booking_form.name_prefix.value!='')  && ( unescape(f_query_add_mod.NamePrefixArray[q]) == f_query_add_mod.document.booking_form.name_prefix.value ) )
		 {

               if(f_query_add_mod.PrefixSexArray[q] != f_query_add_mod.document.booking_form.sex.value && f_query_add_mod.PrefixSexArray[q] != 'B')
			 {
					
                  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
				  if(localeName=='en')
					{
						msg = msg.replace('$',f_query_add_mod.document.booking_form.name_prefix_prompt.value);
					}else
					{
						msg = msg.replace('$',f_query_add_mod.document.booking_form.name_prefix_oth_prompt.value);
					} 
				 // msg = msg.replace('$',f_query_add_mod.document.booking_form.name_prefix_prompt.value);
				  LocalErrors = LocalErrors +msg  + " <br>";
				  res = false;
			 }
			 else
				 res = true;
		 }
		 q++;
	}
	return res;

}

function checkPatSuffixSexLocal()  
{
	
    var arLength = f_query_add_mod.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
	
		while ( q <= arLength  )
	       {

                  if ( (f_query_add_mod.document.booking_form.name_suffix.value!='')  && ( unescape(f_query_add_mod.NameSuffixArray[q]) == f_query_add_mod.document.booking_form.name_suffix.value ) )
			   {
					  if(f_query_add_mod.SuffixSexArray[q] != f_query_add_mod.document.booking_form.sex.value && f_query_add_mod.SuffixSexArray[q] != 'B')
				   {
						  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
						  if(localeName=='en')
							{

								msg = msg.replace('$',f_query_add_mod.document.booking_form.name_suffix_prompt.value);
							}else
							{
								msg = msg.replace('$',f_query_add_mod.document.booking_form.name_suffix_oth_prompt.value);
							} 
                          //msg = msg.replace('$',f_query_add_mod.document.booking_form.name_suffix_prompt.value);
                          LocalErrors = LocalErrors +msg  + " <br>";
						  res = false;
				   }
				   else
					   res = true;
			   }
			   q++;
		   }
		   return res;
}


function validateBedNo(obj)
{
	
			var call_function = self.frames[1].document.forms[0].call_function.value;
			var nursingunit = self.frames[1].document.forms[0].nursing_unit.value;
			var to_bed_no	= self.frames[1].document.forms[0].old_bed_no.value;
			var bedno		= self.frames[1].document.forms[0].bed_no.value;
			var queryString	= self.frames[1].document.forms[0].qryString.value;
			var create_booking_with_conf_yn =  self.frames[1].document.forms[0].create_booking_with_conf_yn.value;
			var deactivate_pseudo_bed_yn =  self.frames[1].document.forms[0].deactivate_pseudo_bed_yn.value;
			var from_date	=	convertDate(self.frames[1].document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");
			var to_date		=	convertDate(self.frames[1].document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en");
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='validate_bed_no'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'><input type='hidden' name='bedClass' id='bedClass' value='"+self.frames[1].document.forms[0].bed_class_code.value+"'><input type='hidden' name='from_date' id='from_date' value='"+from_date+"'><input type='hidden' name='to_date' id='to_date' value='"+to_date+"'><input type='hidden' name='call_function' id='call_function' value='"+call_function+"'><input type='hidden' name='create_booking_with_conf_yn' id='create_booking_with_conf_yn' value='"+create_booking_with_conf_yn+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
			//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.frames[2].document.dum_form.submit();
			
			if(call_function=="OA_IP_Booking" || call_function=="OT")
			{
				
				self.frames[2].document.write(HTMLVal);
				//self.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				self.frames[2].document.dum_form.submit();
			}
			else
			{
						self.frames[2].document.write(HTMLVal);
						//self.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);						
						self.frames[2].document.dum_form.submit();						
			}
			

		
}

/*function validateNursingUnitSplCodePractID(splCode,nursingUnitCode,practID)
{

			var call_function = parent.frames[1].document.forms[0].call_function.value;
			var p_oper_stn_id = parent.frames[1].document.forms[0].p_oper_stn_id.value;
			var loginUser	  = parent.frames[1].document.forms[0].loginUser.value;			


			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingUnitCode+"'><input type='hidden' name='splCode' id='splCode' value='"+splCode+"'><input type='hidden' name='practID' id='practID' value='"+practID+"'><input type='hidden' name='p_oper_stn_id' id='p_oper_stn_id' value='"+p_oper_stn_id+"'><input type='hidden' name='loginUser' id='loginUser' value='"+loginUser+"'><input type='hidden' name='patientclass' id='patientclass' value='IP'><input type='hidden' name='field4' id='field4' value='"+call_function+"'></form></body></html>";
			
			alert("HTMLVal:"+HTMLVal);

			parent.frames[2].document.write(HTMLVal);		
			parent.frames[2].document.dum_form.submit();
	

}*/

function checkMaxAge()
{
	//max_patient_age
	var age = f_query_add_mod.document.booking_form.b_age.value
	var max_patient_age = f_query_add_mod.document.booking_form.maxPatAge.value
	var months = f_query_add_mod.document.booking_form.b_months.value
	var days = f_query_add_mod.document.booking_form.b_days.value
	var res = new Boolean(false);
	if(parseInt(max_patient_age) < parseInt(age))
	{
		msg = getMessage('MAX_PATIENT_AGE','MP');
		msg = msg.replace('#', '$');
		msg = msg+' '+max_patient_age+' '+ getLabel('Common.Years.label','common');
		LocalErrors = LocalErrors +msg  ;
		f_query_add_mod.document.booking_form.patient_id.value = "";
		f_query_add_mod.document.booking_form.patient_id.onblur();
		res = false;
	}else if(parseInt(age) == parseInt(max_patient_age) && ((parseInt(months) > 0) ||  (parseInt(days) > 0)))
	{
		msg = getMessage('MAX_PATIENT_AGE','MP');
		msg = msg.replace('#', '$');
		msg = msg+' '+max_patient_age+' '+ getLabel('Common.Years.label','common');	
		LocalErrors = LocalErrors +msg  ;
		f_query_add_mod.document.booking_form.patient_id.value = "";
		f_query_add_mod.document.booking_form.patient_id.onblur();
		res = false;
	}else
		res = true

	return res
}
function delayForSubmitForm()
{
}

async function PatInsModalWindow(){//For the CRF - RUT-CRF-013 Patient Instructions - 23396	
	var booking_ref_no=parent.f_query_add_mod.document.booking_form.booking_ref_no.value;
	var patient_id=parent.f_query_add_mod.document.booking_form.patient_id.valuel;
	var nursingunitcode=document.forms[0].nursing_unit.value;
	var features    = "dialogHeight:84vh; dialogWidth:54vw; scroll=no; status:no;";//Changes for RUT-CRF-13.1 IN035825 
	var arguments = '';	
	var removePatInstruction=document.forms[0].removePatInstruction.value;	
	var url="../../eIP/jsp/IPBkgPatientInstructionsMain.jsp?nursing_unit_code="+nursingunitcode+"&from_page=createBooking&patient_id="+patient_id+"&NUInsYN=N&booking_ref_no="+booking_ref_no+"&addInstructionYN=N&removePatInstruction="+removePatInstruction;
	document.forms[0].removePatInstruction.value="N";
	var retVal = await window.showModalDialog(url,arguments,features);
	//Changes for RUT-CRF-13.1 IN035825 - start
	/*if(retVal=="true"){
		document.forms[0].all.NUInstsExist.style.visibility='visible';
	}else{
		document.forms[0].all.NUInstsExist.style.visibility='hidden';
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
//Changes for RUT-CRF-13.1 IN035825 - End			
			



