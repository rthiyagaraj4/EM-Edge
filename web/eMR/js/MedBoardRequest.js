var LocalErrors = "";

function reset()
{
	parent.content.frames[2].document.forms[0].reload();
}

function apply()
{
	
	var call_function =  parent.content.frames[3].document.forms[0].call_function.value
	var fields = new Array();
	var names = new Array();
	var i=0;
	var blur = false;

	if(parent.content.frames[2].document.forms[0].name_prefix_reqd_yn != null && parent.content.frames[2].document.forms[0].name_prefix_reqd_yn.value == 'Y' )
	{
		if(parent.content.frames[2].document.forms[0].name_prefix != null && parent.content.frames[2].document.forms[0].name_prefix.disabled == false)
		{
			fields[i]=parent.content.frames[2].document.forms[0].name_prefix;
			names[i]=parent.content.frames[2].document.forms[0].Name_Prefix_Prompt.value;
			i++;
		}
	}


	if(parent.content.frames[2].document.forms[0].first_name_reqd_yn !=null && parent.content.frames[2].document.forms[0].first_name_reqd_yn.value =='Y' )
	{
		if(parent.content.frames[2].document.forms[0].first_name != null && parent.content.frames[2].document.forms[0].first_name.disabled == false)
		{
			if(parent.content.frames[2].document.forms[0].first_name.value == "")
				parent.content.frames[2].document.forms[0].first_name.value = parent.content.frames[2].document.forms[0].dflt_patient_name.value;

				blur = true;
			}
		}

	if(parent.content.frames[2].document.forms[0].second_name_reqd_yn !=null && parent.content.frames[2].document.forms[0].second_name_reqd_yn.value =='Y' )
	{
		if( parent.content.frames[2].document.forms[0].second_name != null && parent.content.frames[2].document.forms[0].second_name.disabled ==false)
		{
			if(parent.content.frames[2].document.forms[0].second_name.value == "")
			parent.content.frames[2].document.forms[0].second_name.value = parent.content.frames[2].document.forms[0].dflt_patient_name.value;

			blur = true;
		}
	}

	if(parent.content.frames[2].document.forms[0].third_name_reqd_yn !=null && parent.content.frames[2].document.forms[0].third_name_reqd_yn.value =='Y' )
	{
		if(parent.content.frames[2].document.forms[0].third_name != null && parent.content.frames[2].document.forms[0].third_name.disabled ==false)
		{
			if(parent.content.frames[2].document.forms[0].third_name.value == "")
			parent.content.frames[2].document.forms[0].third_name.value = parent.content.frames[2].document.forms[0].dflt_patient_name.value;

			blur = true;

		}
	}

	if(parent.content.frames[2].document.forms[0].family_name_reqd_yn !=null && parent.content.frames[2].document.forms[0].family_name_reqd_yn.value =='Y' )
	{
		if(parent.content.frames[2].document.forms[0].family_name != null && parent.content.frames[2].document.forms[0].family_name.disabled ==false)
		{
			if(parent.content.frames[2].document.forms[0].family_name.value == "")
			parent.content.frames[2].document.forms[0].family_name.value = parent.content.frames[2].document.forms[0].dflt_patient_name.value;

			blur = true;

		}
	}

	if(parent.content.frames[2].document.forms[0].name_suffix_reqd_yn !=null && parent.content.frames[2].document.forms[0].name_suffix_reqd_yn.value =='Y' )
	{
		if(parent.content.frames[2].document.forms[0].name_suffix != null && parent.content.frames[2].document.forms[0].name_suffix.disabled ==false)
		{
			fields[i]=parent.content.frames[2].document.forms[0].name_suffix;
			names[i]=parent.content.frames[2].document.forms[0].Name_Suffix_Prompt.value;
			i++;
		}
	}

	if(parent.content.frames[2].document.forms[0].name_prefix_oth != null)
	{
		if(parent.content.frames[2].document.forms[0].name_prefix_oth.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].name_suffix != null && parent.content.frames[2].document.forms[0].name_suffix.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].name_suffix;
				names[i]=parent.content.frames[2].document.forms[0].Name_Suffix_Prompt.value;
				i++;
			}
		}
	}


	if(parent.content.frames[2].document.forms[0].name_prefix_oth != null)
	{
		if(parent.content.frames[2].document.forms[0].name_prefix_oth.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].name_prefix_oth_lang != null && parent.content.frames[2].document.forms[0].name_prefix_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].name_prefix_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].name_prefix_oth_lang.value;
				i++;
			}
		}
	}


	if(parent.content.frames[2].document.forms[0].first_oth_name_reqd_yn != null)
	{
		if(parent.content.frames[2].document.forms[0].first_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].first_name_oth_lang != null && parent.content.frames[2].document.forms[0].first_name_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].first_name_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].first_name_oth_lang.value;
				i++;
			}
		}
	}

	if(parent.content.frames[2].document.forms[0].second_oth_name_reqd_yn != null)
	{
		if(parent.content.frames[2].document.forms[0].second_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].second_name_oth_lang != null && parent.content.frames[2].document.forms[0].second_name_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].second_name_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].second_name_oth_lang.value;
				i++;
			}
		}
	}

	if(parent.content.frames[2].document.forms[0].third_oth_name_reqd_yn != null)
	{
		if(parent.content.frames[2].document.forms[0].third_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].third_name_oth_lang != null && parent.content.frames[2].document.forms[0].third_name_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].third_name_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].third_name_oth_lang.value;
				i++;
			}
		}
	}

	if(parent.content.frames[2].document.forms[0].family_oth_name_reqd_yn != null)
	{
		if(parent.content.frames[2].document.forms[0].family_oth_name_reqd_yn.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].family_name_oth_lang != null && parent.content.frames[2].document.forms[0].family_name_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].family_name_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].family_name_oth_lang.value;
				i++;
			}
		}
	}


	if(parent.content.frames[2].document.forms[0].name_suffix_oth != null)
	{
		if(parent.content.frames[2].document.forms[0].name_suffix_oth.style.visibility == 'visible' )
		{
			if(parent.content.frames[2].document.forms[0].name_suffix_oth_lang != null && parent.content.frames[2].document.forms[0].name_suffix_oth_lang.disabled ==false)
			{
				fields[i]=parent.content.frames[2].document.forms[0].name_suffix_oth_prompt;
				names[i]=parent.content.frames[2].document.forms[0].name_suffix_oth_lang.value;
				i++;
			}
		}
	}


	fields[i] =parent.content.frames[2].document.forms[0].sex;
	names[i] =getLabel("Common.gender.label","Common");
	i++;	

	fields[i] =parent.content.frames[2].document.forms[0].date_of_birth;
	names[i] =getLabel("Common.birthDate.label","Common");
	i++;

	fields[i] =parent.content.frames[2].document.forms[0].nationality_desc;
	names[i] =getLabel("Common.nationality.label","Common");
	i++;
	
	if(parent.content.frames[2].document.forms[0].race_required_yn!=null)
	{		
			if(parent.content.frames[2].document.forms[0].race_required_yn.value == 'Y')
			{
				fields[i] =parent.content.frames[2].document.forms[0].race_code;
				names[i] =getLabel("Common.race.label","Common");
				i++;

			}
	}
	else
	{
			fields[i] =parent.content.frames[2].document.forms[0].race_code;
			names[i] =getLabel("Common.race.label","Common");
			i++;
	}

	/*		
	fields[i] =parent.content.frames[2].document.forms[0].race_code;
	names[i] =getLabel("Common.race.label","Common");
	i++;
	*/

	fields[i] =parent.content.frames[3].document.forms[0].appl_type;
	names[i] =getLabel("eMR.ApplicationType.label","MR");
	i++;

	fields[i] =parent.content.frames[3].document.forms[0].appln_date;
	names[i] =getLabel("eMR.ApplicationDateTime.label","MR");
	i++;

	fields[i] =parent.content.frames[3].document.forms[0].board_type;
	names[i] =getLabel("eMR.TypeofMedicalBoard.label","MR");
	i++;

	if(parent.content.frames[3].document.forms[0].req_type.value != "")
	{
		fields[i] =parent.content.frames[3].document.forms[0].requestor_desc;
		names[i] =getLabel("Common.Requestor.label","Common");
		i++;
	}

	if(parent.content.frames[3].document.forms[0].relationship_type.value == "4")
	{
		fields[i] =parent.content.frames[3].document.forms[0].relationship;
		names[i] =getLabel("Common.relationship.label","Common");
		i++;
	}

	var medrep_pay_int_mode = parent.content.frames[3].document.forms[0].medrep_pay_int_mode.value;
	if(medrep_pay_int_mode == "X")
	{
		if(parent.content.frames[3].document.forms[0].charges_appllicable.value == "Y")
		{
			if(parent.content.frames[3].document.forms[0].amount.value != "" || parent.content.frames[3].document.forms[0].recp_no.value != "" || parent.content.frames[3].document.forms[0].amount.value != "")
			{
				if(parent.content.frames[3].document.forms[0].amount.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].amount;
					names[i] =getLabel("Common.amount.label","Common");
					i++;
				}

				if(parent.content.frames[3].document.forms[0].recp_no.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].recp_no;
					names[i] =getLabel("Common.receiptno.label","Common");
					i++;
				}

				if(parent.content.frames[3].document.forms[0].recp_dat.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].recp_dat;
					names[i] =getLabel("Common.receiptdate.label","Common");
					i++;
				}
			}
		}

		if(parent.content.frames[3].document.forms[0].additional_charges.value == "Y")
		{
			if(parent.content.frames[3].document.forms[0].add_amount.value != "" || parent.content.frames[3].document.forms[0].add_recp_no.value != "" || parent.content.frames[3].document.forms[0].add_recp_dat.value != "")
			{
				if(parent.content.frames[3].document.forms[0].add_amount.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].add_amount;
					names[i] =getLabel("eMR.AdditionalAmount.label","MR");
					i++;
				}

				if(parent.content.frames[3].document.forms[0].add_recp_no.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].add_recp_no;
					names[i] =getLabel("eMR.AdditionalReceiptNo.label","MR");
					i++;
				}

				if(parent.content.frames[3].document.forms[0].add_recp_dat.value == "")
				{
					fields[i] =parent.content.frames[3].document.forms[0].add_recp_dat;
					names[i] =getLabel("eMR.AdditionalReceiptDate.label","MR");
					i++;
				}
			}
		}
	}
	else if(medrep_pay_int_mode == "B")
	{
		if(parent.content.frames[3].document.forms[0].charges_appllicable.value == "Y" && parent.content.frames[3].document.forms[0].amount.value == "")
		{
			fields[i] =parent.content.frames[3].document.forms[0].amount;
			names[i] =getLabel("Common.amount.label","Common");
			i++;
		}

		if(parent.content.frames[3].document.forms[0].additional_charges.value == "Y" && parent.content.frames[3].document.forms[0].add_amount.value == "")
		{
			fields[i] =parent.content.frames[3].document.forms[0].add_amount;
			names[i] =getLabel("eMR.AdditionalAmount.label","MR");
			i++;
		}
	}

	if(blur == true)
	{
		if(parent.content.frames[2].document.forms[0].first_name != null)
			parent.content.frames[2].document.forms[0].first_name.onblur();
		else if(parent.content.frames[2].document.forms[0].second_name != null)
			parent.content.frames[2].document.forms[0].second_name.onblur();
		else if(parent.content.frames[2].document.forms[0].third_name != null)
			parent.content.frames[2].document.forms[0].third_name.onblur();
		else if(parent.content.frames[2].document.forms[0].family_name != null)
			parent.content.frames[2].document.forms[0].family_name.onblur();
	}

	
	// this code is written for validating patient prefix and suffix with the gender.
			var pat_prefix=true;
			var pat_suffix=true;
			LocalErrors = "";

			if (parent.content.frames[2].document.forms[0].name_prefix != null && parent.content.frames[2].document.forms[0].name_prefix.value.length != 0 && parent.content.frames[2].document.forms[0].sex.value != '') 
			{
				pat_prefix=checkPatSex();
				
			}

			if (parent.content.frames[2].document.forms[0].name_suffix != null && parent.content.frames[2].document.forms[0].name_suffix.value.length != 0 && parent.content.frames[2].document.forms[0].sex.value != '') 
			{
				pat_suffix=checkPatSuffixSex();				
			}
			
				
			if(pat_prefix==false || pat_suffix ==false)
			{
				alert(LocalErrors);
				parent.content.frames[0].location.reload();
				return ;
			}

	var messageFrame = parent.content.messageFrame;
	if(checkMandatory( fields, names)) 
	{

		var relationship_type = parent.parent.frames[2].frames[3].document.forms[0].relationship_type.value;
		var req_type = parent.parent.frames[2].frames[3].document.forms[0].req_type.value;

		if(relationship_type == '' && req_type == '')
		{
			alert(getMessage('REQ_REAL_IS_MANDATORY','MR'));
			parent.content.frames[0].location.reload(); // reloading tool bar..	
			return;
		}

		for(var j=0;j<parent.content.frames[2].document.forms[0].elements.length;j++)
		{
			parent.content.frames[2].document.forms[0].elements[j].disabled = false; 
		}

		//Assigning the Patient Details to current form objects...
		//i.e from MedBoardReqDetailForm to MedBoardReqDetailTabsForm...

		parent.content.frames[3].document.forms[0].patient_id.value 	= parent.content.frames[2].document.forms[0].patient_id.value;

		parent.content.frames[3].document.forms[0].patient_name.value= parent.content.frames[2].document.forms[0].patient_name.value;

		if(parent.content.frames[2].document.forms[0].name_prefix1)
		{
			parent.content.frames[3].document.forms[0].name_prefix1.value= 				parent.content.frames[2].document.forms[0].name_prefix1.value;
		}
		else if(parent.content.frames[2].document.forms[0].name_prefix)
		{
			parent.content.frames[3].document.forms[0].name_prefix1.value= 				parent.content.frames[2].document.forms[0].name_prefix.value;
		}


		if(parent.content.frames[2].document.forms[0].family_name)
		{
			parent.content.frames[3].document.forms[0].family_name.value = parent.content.frames[2].document.forms[0].family_name.value;
		}

		if(parent.content.frames[2].document.forms[0].first_name)
		{
			parent.content.frames[3].document.forms[0].first_name.value 	= 	parent.content.frames[2].document.forms[0].first_name.value;
		}

		if(parent.content.frames[2].document.forms[0].second_name)
		{
			parent.content.frames[3].document.forms[0].second_name.value = 	parent.content.frames[2].document.forms[0].second_name.value;
		}

		if(parent.content.frames[2].document.forms[0].third_name)
		{
			parent.content.frames[3].document.forms[0].third_name.value 	= parent.content.frames[2].document.forms[0].third_name.value;
		}
		if(parent.content.frames[2].document.forms[0].family_name)
		{
			parent.content.frames[3].document.forms[0].family_name.value 	= parent.content.frames[2].document.forms[0].family_name.value;
		}

		if(parent.content.frames[2].document.forms[0].name_suffix1)
		{
			parent.content.frames[3].document.forms[0].name_suffix1.value	= parent.content.frames[2].document.forms[0].name_suffix1.value;
		}
		else if(parent.content.frames[2].document.forms[0].name_suffix)
		{
			parent.content.frames[3].document.forms[0].name_suffix1.value	= parent.content.frames[2].document.forms[0].name_suffix.value;
		}

		if(parent.content.frames[2].document.forms[0].name_prefix_oth_lang)
		{
			parent.content.frames[3].document.forms[0].name_prefix_oth_lang.value	= parent.content.frames[2].document.forms[0].name_prefix_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].name_suffix_oth_lang)
		{
			parent.content.frames[3].document.forms[0].name_suffix_oth_lang.value	= parent.content.frames[2].document.forms[0].name_suffix_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].first_name_oth_lang)
		{
			parent.content.frames[3].document.forms[0].first_name_oth_lang.value	= parent.content.frames[2].document.forms[0].first_name_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].second_name_oth_lang)
		{
			parent.content.frames[3].document.forms[0].second_name_oth_lang.value	= parent.content.frames[2].document.forms[0].second_name_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].third_name_oth_lang)
		{
			parent.content.frames[3].document.forms[0].third_name_oth_lang.value	= parent.content.frames[2].document.forms[0].third_name_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].family_name_oth_lang)
		{
			parent.content.frames[3].document.forms[0].family_name_oth_lang.value	= parent.content.frames[2].document.forms[0].family_name_oth_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].patient_name_local_lang)
		{
			parent.content.frames[3].document.forms[0].patient_name_local_lang.value	= parent.content.frames[2].document.forms[0].patient_name_local_lang.value;
		}

		if(parent.content.frames[2].document.forms[0].patient_name)
		{
			parent.content.frames[3].document.forms[0].patient_name.value	= parent.content.frames[2].document.forms[0].patient_name.value;
		}

		if(parent.content.frames[2].document.forms[0].patient_name_long)
		{			
			parent.content.frames[3].document.forms[0].patient_name_long.value	= parent.content.frames[2].document.forms[0].patient_name_long.value;			
		}

		if(parent.content.frames[2].document.forms[0].patient_name_loc_lang_long)
		{			
			parent.content.frames[3].document.forms[0].patient_name_loc_lang_long.value	= parent.content.frames[2].document.forms[0].patient_name_loc_lang_long.value;			
		}


		parent.content.frames[3].document.forms[0].sex.value 		= parent.content.frames[2].document.forms[0].sex.value;
		
		
		//parent.content.frames[3].document.forms[0].date_of_birth.value = parent.content.frames[2].document.forms[0].date_of_birth.value;

		parent.content.frames[3].document.forms[0].date_of_birth.value = convertDate(parent.content.frames[2].document.forms[0].date_of_birth.value,'DMY',localeName,'en'); 

		parent.content.frames[3].document.forms[0].Birth_place_code.value 	= parent.content.frames[2].document.forms[0].Birth_place_code.value;

		if((parent.content.frames[2].document.forms[0].Birth_place_code.value == null) || (parent.content.frames[2].document.forms[0].Birth_place_code.value == ""))
		{	
			parent.content.frames[3].document.forms[0].birth_place.value = parent.content.frames[2].document.forms[0].place_of_birth.value;
		}
		else
		{
			parent.content.frames[3].document.forms[0].birth_place.value = parent.content.frames[2].document.forms[0].birth_place.value;
		}

		parent.content.frames[3].document.forms[0].nationality_code1.value = parent.content.frames[2].document.forms[0].nationality_code1.value;
		
		parent.content.frames[3].document.forms[0].nationality_desc.value	= parent.content.frames[2].document.forms[0].nationality_desc.value;

		parent.content.frames[3].document.forms[0].national_id_no.value 	= parent.content.frames[2].document.forms[0].national_id_no.value;

		if(parent.content.frames[2].document.forms[0].alt_id1_no)
		{
			parent.content.frames[3].document.forms[0].alt_id1_no.value 	= parent.content.frames[2].document.forms[0].alt_id1_no.value;
		}
		if(parent.content.frames[2].document.forms[0].alt_id2_no)
		{
			parent.content.frames[3].document.forms[0].alt_id2_no.value 	= parent.content.frames[2].document.forms[0].alt_id2_no.value;
		}
		if(parent.content.frames[2].document.forms[0].alt_id3_no)
		{
			parent.content.frames[3].document.forms[0].alt_id3_no.value 	= parent.content.frames[2].document.forms[0].alt_id3_no.value;
		}
		if(parent.content.frames[2].document.forms[0].alt_id4_no)
		{
			parent.content.frames[3].document.forms[0].alt_id4_no.value 	= parent.content.frames[2].document.forms[0].alt_id4_no.value;
		}
		

		if(parent.content.frames[2].document.forms[0].alt_id1_exp_date)
		{
			//parent.content.frames[3].document.forms[0].alt_id1_exp_date.value 	= parent.content.frames[2].document.forms[0].alt_id1_exp_date.value;
			if(parent.content.frames[2].document.forms[0].alt_id1_exp_date.value!='')
				parent.content.frames[3].document.forms[0].alt_id1_exp_date.value 	=			convertDate(parent.content.frames[2].document.forms[0].alt_id1_exp_date.value,'DMY',localeName,'en'); 
		}

		if(parent.content.frames[2].document.forms[0].alt_id2_exp_date)
		{
			//parent.content.frames[3].document.forms[0].alt_id2_exp_date.value 	= parent.content.frames[2].document.forms[0].alt_id2_exp_date.value;
		
			if(parent.content.frames[2].document.forms[0].alt_id2_exp_date.value!='')
				parent.content.frames[3].document.forms[0].alt_id2_exp_date.value 	=			convertDate(parent.content.frames[2].document.forms[0].alt_id2_exp_date.value,'DMY',localeName,'en'); 
		}
		if(parent.content.frames[2].document.forms[0].alt_id3_exp_date)
		{	
			//parent.content.frames[3].document.forms[0].alt_id3_exp_date.value = parent.content.frames[2].document.forms[0].alt_id3_exp_date.value;
			
			if(parent.content.frames[2].document.forms[0].alt_id3_exp_date.value!='')		
				parent.content.frames[3].document.forms[0].alt_id3_exp_date.value =			convertDate(parent.content.frames[2].document.forms[0].alt_id3_exp_date.value,'DMY',localeName,'en'); 
		}
		if(parent.content.frames[2].document.forms[0].alt_id4_exp_date)
		{
			//parent.content.frames[3].document.forms[0].alt_id4_exp_date.value = parent.content.frames[2].document.forms[0].alt_id4_exp_date.value;
			if(parent.content.frames[2].document.forms[0].alt_id4_exp_date.value!='')		
				parent.content.frames[3].document.forms[0].alt_id4_exp_date.value =			convertDate(parent.content.frames[2].document.forms[0].alt_id4_exp_date.value,'DMY',localeName,'en'); 
		}

		if(parent.content.frames[2].document.forms[0].other_alt_type)
		{
			parent.content.frames[3].document.forms[0].other_alt_type.value = parent.content.frames[2].document.forms[0].other_alt_type.value;
		}

		if(parent.content.frames[2].document.forms[0].other_alt_Id)
		{
			parent.content.frames[3].document.forms[0].other_alt_Id.value = parent.content.frames[2].document.forms[0].other_alt_Id.value;
		}

		parent.content.frames[3].document.forms[0].race_code.value	=	parent.content.frames[2].document.forms[0].race_code.value;

		parent.content.frames[3].document.forms[0].ethnic_group.value = parent.content.frames[2].document.forms[0].ethnic_group.value;

		if(parent.content.frames[2].document.forms[0].citizen_yn[0].checked == true)
			parent.content.frames[3].document.forms[0].citizen_yn.value = "Y";
		else	
			parent.content.frames[3].document.forms[0].citizen_yn.value = "N";

		if(parent.content.frames[2].document.forms[0].legal_yn[0].checked == true)
			parent.content.frames[3].document.forms[0].legal_yn.value = "Y";
		else
			parent.content.frames[3].document.forms[0].legal_yn.value = "N";

		parent.content.frames[3].document.forms[0].addr_line1.value	=	parent.content.frames[2].document.forms[0].addr_line1.value;
		
		parent.content.frames[3].document.forms[0].addr_line2.value	=	parent.content.frames[2].document.forms[0].addr_line2.value;

		parent.content.frames[3].document.forms[0].addr_line3.value	=	parent.content.frames[2].document.forms[0].addr_line3.value;

		parent.content.frames[3].document.forms[0].addr_line4.value	=	parent.content.frames[2].document.forms[0].addr_line4.value;

		parent.content.frames[3].document.forms[0].res_town_code.value	=	parent.content.frames[2].document.forms[0].res_town_code.value;
		
		parent.content.frames[3].document.forms[0].res_town_desc.value	=	parent.content.frames[2].document.forms[0].res_town_desc.value;

		parent.content.frames[3].document.forms[0].res_area_code.value	=	parent.content.frames[2].document.forms[0].res_area_code.value;
		
		parent.content.frames[3].document.forms[0].res_area_desc.value	=	parent.content.frames[2].document.forms[0].res_area_desc.value;

		parent.content.frames[3].document.forms[0].region_code.value	=	parent.content.frames[2].document.forms[0].region_code.value;
		
		parent.content.frames[3].document.forms[0].region_desc.value	=	parent.content.frames[2].document.forms[0].region_desc.value;		

		parent.content.frames[3].document.forms[0].postal_code.value	=	parent.content.frames[2].document.forms[0].postal_code.value;

		parent.content.frames[3].document.forms[0].country_desc.value	=parent.content.frames[2].document.forms[0].country_desc.value;

		parent.content.frames[3].document.forms[0].country_code.value	=parent.content.frames[2].document.forms[0].country_code.value;

		parent.content.frames[3].document.forms[0].contact1_name.value	=parent.content.frames[2].document.forms[0].contact1_name.value;

		parent.content.frames[3].document.forms[0].addr2_type.value	=	parent.content.frames[2].document.forms[0].addr2_type.value;

		parent.content.frames[3].document.forms[0].mail_addr_line1.value	=	parent.content.frames[2].document.forms[0].mail_addr_line1.value;

		parent.content.frames[3].document.forms[0].mail_addr_line2.value	=	parent.content.frames[2].document.forms[0].mail_addr_line2.value;

		parent.content.frames[3].document.forms[0].mail_addr_line3.value	=	parent.content.frames[2].document.forms[0].mail_addr_line3.value;

		parent.content.frames[3].document.forms[0].mail_addr_line4.value	=	parent.content.frames[2].document.forms[0].mail_addr_line4.value;

		parent.content.frames[3].document.forms[0].mail_res_town_code.value	=	parent.content.frames[2].document.forms[0].mail_res_town_code.value;
		
		parent.content.frames[3].document.forms[0].mail_res_town_desc.value	=	parent.content.frames[2].document.forms[0].mail_res_town_desc.value;

		parent.content.frames[3].document.forms[0].mail_res_area_code.value	=	parent.content.frames[2].document.forms[0].mail_res_area_code.value;
		
		parent.content.frames[3].document.forms[0].mail_res_area_desc.value	=	parent.content.frames[2].document.forms[0].mail_res_area_desc.value;

		parent.content.frames[3].document.forms[0].mail_postal_code.value=parent.content.frames[2].document.forms[0].mail_postal_code.value;

		parent.content.frames[3].document.forms[0].mail_region_code.value=parent.content.frames[2].document.forms[0].mail_region_code.value;
		parent.content.frames[3].document.forms[0].mail_region_desc.value=parent.content.frames[2].document.forms[0].mail_region_desc.value;
		parent.content.frames[3].document.forms[0].mail_country_code.value=parent.content.frames[2].document.forms[0].mail_country_code.value;
		parent.content.frames[3].document.forms[0].mail_country_desc.value=parent.content.frames[2].document.forms[0].mail_country_desc.value;

		parent.content.frames[3].document.forms[0].contact2_name.value=parent.content.frames[2].document.forms[0].contact2_name.value;
		parent.content.frames[3].document.forms[0].contact1_no.value=parent.content.frames[2].document.forms[0].contact1_no.value;	parent.content.frames[3].document.forms[0].contact2_no.value=parent.content.frames[2].document.forms[0].contact2_no.value;
		parent.content.frames[3].document.forms[0].email.value=parent.content.frames[2].document.forms[0].email.value;
		
		/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		parent.content.frames[3].document.forms[0].alt_addr_line1.value		=	parent.content.frames[2].document.forms[0].alt_addr_line1.value;
		parent.content.frames[3].document.forms[0].alt_addr_line2.value		=	parent.content.frames[2].document.forms[0].alt_addr_line2.value;
		parent.content.frames[3].document.forms[0].alt_addr_line3.value		=	parent.content.frames[2].document.forms[0].alt_addr_line3.value;
		parent.content.frames[3].document.forms[0].alt_addr_line4.value		=	parent.content.frames[2].document.forms[0].alt_addr_line4.value;
		parent.content.frames[3].document.forms[0].alt_town_code.value		=	parent.content.frames[2].document.forms[0].alt_town_code.value;
		parent.content.frames[3].document.forms[0].alt_region_code.value	=	parent.content.frames[2].document.forms[0].alt_region_code.value;
		parent.content.frames[3].document.forms[0].alt_area_code.value		=	parent.content.frames[2].document.forms[0].alt_area_code.value;
		parent.content.frames[3].document.forms[0].alt_postal_code.value	=	parent.content.frames[2].document.forms[0].alt_postal_code.value;
		parent.content.frames[3].document.forms[0].alt_country_code.value	=	parent.content.frames[2].document.forms[0].alt_country_code.value;
		/*End*/

		/*
			var val = '';
			for(var i=0;i<parent.content.frames[3].document.forms[0].elements.length;i++)
			{
			val += parent.content.frames[3].document.forms[0].elements[i].name+" : "+parent.content.frames[3].document.forms[0].elements[i].value+" | " ;
			}
			alert(val);
		*/
		for(var j=0;j<parent.content.frames[3].document.forms[0].elements.length;j++)
		{
			parent.content.frames[3].document.forms[0].elements[j].disabled = false; 
		}
		
		parent.content.frames[3].document.forms[0].action = "../../servlet/eMR.MedBoardRequestServlet";
		parent.content.frames[3].document.forms[0].submit();
	}

	parent.content.frames[0].location.reload(); // reloading tool bar..
	
}

function onLocalSuccess()
{
	parent.parent.frames[2].location.href="../eMR/jsp/MedicalBoard.jsp?module_id=MR&function_id=MEDICAL_BOARD_REQUEST&function_name="+getLabel('eMR.MedicalBoard.label','MR')+"&function_type=F&access=NYNNN";
}

function checkMandatory( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(!CheckVal(fields[i].value)) 
		{
			errors = errors + getMessage("SHOULD_NOT_BE_BLANK","Common");
			errors = errors.replace('{1}',new Array(names[i]));
			errors = errors + "\n";
			//errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"\n";
		}
	}
	
	if ( errors.length != 0 ) 
	{
		alert(errors) ;
		return false ;
	}
	return true ;
}


function CheckVal(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

// Medical Board..
//Request for medical Board..........

async function callModalWindow(req_id, call_func, pat_id, appointment_date, med_board_type, enc_id,appt_ref_no)
	{
		if(call_func == 'MEDICAL_BOARD_APPT' )
		{
			getApptDetails(req_id, call_func, pat_id, appointment_date );
		}
		else
		{
			var called_from = parent.frames[1].document.forms[0].called_from.value;
			var jsp_name	= "";
			var dialogHeight= "";
			var dialogWidth= "";

			if(call_func == 'MEDICAL_BOARD_STATUS' || call_func == 'FORWARD_MEDICAL_BOARD' || call_func == 'PREPARE_MEDICAL_BOARD' || call_func == 'RECEIVE_MEDICAL_BOARD' || call_func == 'MEDICAL_BOARD_INT_APPT' || call_func == 'DELIVER_MEDICAL_BOARD' )
			{
				jsp_name	= "MedBoardTransactionsFrames.jsp";
				if(call_func == 'MEDICAL_BOARD_INT_APPT' || call_func == 'DELIVER_MEDICAL_BOARD')
				{
					dialogHeight= "94vh";	
					dialogWidth	= "90vw";		
				}
				else
				{
					dialogHeight= "92vh";	
					dialogWidth	= "90vw";		
				}

			}
			else if(call_func == 'MEDICAL_BOARD_FORMATION')
			{
				jsp_name	= "MedBoardRequestFormation.jsp";
				dialogHeight= "92vh";	
				dialogWidth	= "90vw";		
			}
			else
			{
				jsp_name	= "MedRecRequestRecordMain.jsp";
				dialogHeight= "92vh";	
				dialogWidth	= "90vw";		
			}
			
			if(call_func == 'PREPARE_MEDICAL_BOARD')
			{
				if(appt_ref_no != '')
				{
					if(pat_id !='' && enc_id !='')
					{
						
						//return;
					}
					else
					{
						alert(getMessage('PATIENT_NOT_REGISTERED','MR')); 
						return;
					}
				}
				else
				{
					alert(getMessage('APPT_NOT_GIVEN','MR')); 
					return ;
				}
			}

			//var dialogWidth	= "50";		
			var dialogTop	= "0vh";
			var retVal		= new String();
			var center		= "1" ;
			var status		= "no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;

			if(called_from == 'CA')
			{
				if(call_func == 'PREPARE_MEDICAL_REPORT' || call_func == 'PREPARE_MEDICAL_BOARD')
				{
					retVal			=await window.open("../../eMR/jsp/"+jsp_name+"?call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"",'MR','height=500,width=790,top=59,left=0,resizable=no,toolbar=no,menubar=no');
				}
			}
			else
			{
				retVal			=await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"",arguments,features);
			}
		}
/*
		if(called_from == 'CA')
			parent.frames[1].document.forms[0].search.onclick();
		else
*/
			parent.frames[2].document.location.reload();
	}
	
	//function getApptDetaisl added by kishore on 3/30/2005
async function getApptDetails(req_id, call_func, pat_id, appt_date)
	{
		var retVal		= 	new String();
		var dialogHeight= "33vh" ;
		var dialogWidth = "50vw" ;
		var dialogTop 	= "60";
		var center		= "1" ;
		var status		= "no";

		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;


		var P_practitioner_id,P_practitioner_id,P_patient_id,P_locn_code,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode;
		var referral_id = "N" ;

		var parameters	= "i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+"&request_id="+req_id+"&appt_date="+appt_date+"&callingMode=MR ";

		retVal =await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+parameters,arguments,features);
		
		if(retVal != null && retVal != "")
		{
			var Val = retVal.split("^");
			var mode = Val[0];
			parameters = Val[1];

			if (mode=="1")
			{
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"))+" ";
				returnVal =await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+parameters,arguments,features);
				
			}
			else if (mode=="2")
			{
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"))+" ";
				returnVal =await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+parameters,arguments,features);
				
			}
			else if (mode=="3")
			{
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"))+" ";
				returnVal =await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+parameters,arguments,features);
			}
		
			if(returnVal != null && returnVal != "")
			{
				if(returnVal=="MR")
				{
					getApptDetails(req_id, call_func, pat_id, appt_date)
				}
				else if(returnVal != null && returnVal != "")
				{
					var result = returnVal.split("*");
					if(result[0] != "MR")
					{
						var ApptNo		= result[0];
						eval(document.getElementById("apptLabel")+i).innerText	= ApptNo;
						parent.frames[0].document.forms[0].Refresh.onclick();
					}
				}
			}
		}
	}



//MP related prefix and suffix fields validation
function checkPatSex()  
{

   // var arLength = f_query_add_mod.document.getElementById("NamePrefixArray").length;
   var arLength = parent.content.frames[2].NamePrefixArray.length;

    var q = 0;
    var res = new Boolean(false);

     while ( q <= arLength  )
	{

             if ( (parent.content.frames[2].document.forms[0].name_prefix.value!='')  && ( unescape(parent.content.frames[2].NamePrefixArray[q]) == parent.content.frames[2].document.forms[0].name_prefix.value ) )
		 {

               if(parent.content.frames[2].PrefixSexArray[q] != parent.content.frames[2].document.forms[0].sex.value && parent.content.frames[2].PrefixSexArray[q] != 'B')
			 {
					
                  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');

					if(localeName=='en')
					{

						msg = msg.replace('$',parent.content.frames[2].document.forms[0].name_prefix_prompt.value);
					}else
					{
						msg = msg.replace('$',parent.content.frames[2].document.forms[0].name_prefix_oth_prompt.value);
					} 
				  LocalErrors = LocalErrors +msg  + '\n';
				  res = false;
			 }
			 else
				 res = true;
		 }
		 q++;
	}
	return res;

}

function checkPatSuffixSex()  
{

    var arLength = parent.content.frames[2].NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
	
		while ( q <= arLength  )
	       {

                  if ( (parent.content.frames[2].document.forms[0].name_suffix.value!='')  && ( unescape(parent.content.frames[2].NameSuffixArray[q]) == parent.content.frames[2].document.forms[0].name_suffix.value ) )
			   {
					  if(parent.content.frames[2].SuffixSexArray[q] != parent.content.frames[2].document.forms[0].sex.value && parent.content.frames[2].SuffixSexArray[q] != 'B')
				   {
						  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
							
							if(localeName=='en')
							{

								msg = msg.replace('$',parent.content.frames[2].document.forms[0].name_suffix_prompt.value);
							}else
							{
								msg = msg.replace('$',parent.content.frames[2].document.forms[0].name_suffix_oth_prompt.value);
							} 

                         // msg = msg.replace('$',parent.content.frames[2].document.forms[0].name_suffix_prompt.value);
                          LocalErrors = LocalErrors +msg;
						  res = false;
				   }
				   else
					   res = true;
			   }
			   q++;
		   }
		   return res;
}





