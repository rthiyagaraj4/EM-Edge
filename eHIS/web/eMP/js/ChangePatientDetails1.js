
function get_patient_id()
{
	var patient_id_back = PatientSearch();

    if((patient_id_back != null))
    {   
        patient_id_back = unescape(patient_id_back)
        document.ChangePatDtlForm.family_link_no.value=patient_id_back;
        document.ChangePatDtlForm.family_link_no.focus();
    }
    else document.ChangePatDtlForm.family_link_no.focus();
}

function tab_click1(Object)
{
	if(Object=='#kin')
	 if(document.getElementById("next_contact_name")!=null && document.getElementById("next_contact_name").disabled==false) 
	 document.getElementById("next_contact_name").focus();
	 else
		 document.getElementById("kin").scrollIntoView();
	if(Object=='#kin1')
		if(document.getElementById("first_contact_name")!=null &&
		document.getElementById("first_contact_name").disabled==false)
		document.getElementById("first_contact_name").focus();
	   else
		   document.getElementById("kin1").scrollIntoView();
	if(Object=='#empyr')
		if(document.getElementById("organization_name")!=null &&
		document.getElementById("organization_name").disabled==false)
		document.getElementById("organization_name").focus();
	  else
		  document.getElementById("empyr").scrollIntoView();
}


function checkCurPatient(obj)
{
	sendToServer(4);
	if(document.getElementById("family_link_no").value=="")
	{
	document.getElementById("rel").style.visibility='hidden';
	}
	else
	{
	document.getElementById("rel").style.visibility='visible';
	}
}

function changestatus()
{ 

    
	document.ChangePatDtlForm.legal[0].disabled=false;
	document.ChangePatDtlForm.legal[1].disabled=false;
	document.ChangePatDtlForm.nationality_code.value='';
	document.ChangePatDtlForm.nationality_desc.value='';
	document.ChangePatDtlForm.race_code.value='';
	document.ChangePatDtlForm.race_desc.value='';	

	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
	var isForm60Available	= document.ChangePatDtlForm.isForm60Available.value;
	var CalledFromFunction	=  document.ChangePatDtlForm.CalledFromFunction.value;
	var isForm60Validation	=  document.ChangePatDtlForm.isForm60Validation.value;
	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/


	if(document.ChangePatDtlForm.citizen[0].checked==true) {
		document.ChangePatDtlForm.citizen_yn.value='Y';
		document.ChangePatDtlForm.legal_yn.value='Y';
		if(document.ChangePatDtlForm.national_id_no)
			document.ChangePatDtlForm.national_id_no.disabled = false;

		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			//document.ChangePatDtlForm.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
			document.ChangePatDtlForm.formno60.disabled=false;

			//document.ChangePatDtlForm.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
			if(document.ChangePatDtlForm.formno60.value=="N")
				document.ChangePatDtlForm.alt_id3_no.disabled=false;
			//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
			/*document.ChangePatDtlForm.alt_id3_reqd_yn.value="Y";
			document.getElementById("alt3_gif").style.visibility='visible';*/
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/


	} else	{
		document.ChangePatDtlForm.citizen_yn.value='N';	

    /*Below line added for this SCF BSP-SCF-0043*/  
	  if(document.ChangePatDtlForm.citizen[1].checked==true) {		
		if(document.ChangePatDtlForm.national_id_no){
		document.ChangePatDtlForm.national_id_no.value="";
		document.ChangePatDtlForm.national_id_no.disabled = true;
		}
	 }	  
	 //End BSP-SCF-0043 
		
			/*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
					if(document.ChangePatDtlForm.alt_id1_man_non_ctz && document.ChangePatDtlForm.alt_id1_man_non_ctz.value=="true") { 
					  if(document.forms[0].alt1_gif){
					     document.ChangePatDtlForm.alt_id1_reqd_yn.value='Y'; 
					     document.forms[0].alt1_gif.style.visibility='visible';
					  }
					  if(document.forms[0].alt1_exp_date1){
					     document.ChangePatDtlForm.alt_date1_reqd_yn.value='Y';
					     document.forms[0].alt1_exp_date1.style.visibility='visible';
					  }						
					}//End GHL-CRF-0332 [IN:042060] 
				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
				/*isNatIdOrAltIdMandVisaType added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
				//Maheshwaran added isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
			if((document.ChangePatDtlForm.isNatIdOrAltId1MandRes && document.ChangePatDtlForm.isNatIdOrAltId1MandRes.value=="true") || (document.ChangePatDtlForm.isNatIdOrAltIdMandVisaType.value=="true") || (document.ChangePatDtlForm.isNatIdAltIdMandVisaType.value=="true")){
			getVisibleMandNatAltIds();
				}



				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/

		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
			
			/*document.ChangePatDtlForm.formno60.value="N";
			document.ChangePatDtlForm.formno60.disabled=true;

			document.ChangePatDtlForm.alt_id3_no.value="";
			document.ChangePatDtlForm.alt_id3_no.disabled=true;*/

			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/
			document.ChangePatDtlForm.alt_id3_reqd_yn.value="N";
			document.getElementById("alt3_gif").style.visibility='hidden';
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
	}
}

function changestatdis() {
	
	

	document.ChangePatDtlForm.legal[0].disabled=true;  
	document.ChangePatDtlForm.legal[1].disabled=true;	


	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
	var isForm60Available	= document.ChangePatDtlForm.isForm60Available.value;
	var CalledFromFunction	=  document.ChangePatDtlForm.CalledFromFunction.value;
	var isForm60Validation	=  document.ChangePatDtlForm.isForm60Validation.value;
	/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
	
	if(document.ChangePatDtlForm.citizen[0].checked==true) {
		document.ChangePatDtlForm.legal[0].checked=true;
		document.ChangePatDtlForm.citizen_yn.value='Y';
		document.ChangePatDtlForm.legal_yn.value='Y';
		
		//added for this CRF BSP-SCF-0043
		
		var changeallowed=document.ChangePatDtlForm.id_change_allowed_for_series.value;
		var id_type_series=document.ChangePatDtlForm.id_type_series.value;
		var national_id_number=document.ChangePatDtlForm.national_id_number.value;
		var user_accescount=document.ChangePatDtlForm.user_accescount.value;
		
        		
		
		if(changeallowed=="A" || id_type_series==changeallowed){
			    if(document.ChangePatDtlForm.national_id_number && document.ChangePatDtlForm.national_id_number.value!="" && parseInt(user_accescount)==0)
				{	
					if(document.ChangePatDtlForm.national_id_no)document.ChangePatDtlForm.national_id_no.disabled = true;
					
				}else{
				
					if(document.ChangePatDtlForm.national_id_no)document.ChangePatDtlForm.national_id_no.disabled = false;
					
				}	
		}else if (document.ChangePatDtlForm.national_id_number && document.ChangePatDtlForm.national_id_number.value=="") {  
		        if(document.ChangePatDtlForm.national_id_no)document.ChangePatDtlForm.national_id_no.disabled = true;
		}else{
		       if(document.ChangePatDtlForm.national_id_no)document.ChangePatDtlForm.national_id_no.disabled = true;
		}
		
		//BSP-SCF-0043

		document.ChangePatDtlForm.nationality_code.value=document.ChangePatDtlForm.dflt_nationality_code.value;	
		document.ChangePatDtlForm.nationality_desc.value=document.ChangePatDtlForm.dflt_nationality_desc.value;
		document.ChangePatDtlForm.race_code.value =  document.ChangePatDtlForm.default_race_code.value;
		document.ChangePatDtlForm.race_desc.value =  document.ChangePatDtlForm.default_race_desc.value;	
		/*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
					if(document.ChangePatDtlForm.alt_id1_man_non_ctz && document.ChangePatDtlForm.alt_id1_man_non_ctz.value=="true") { 
					  if(document.forms[0].alt1_gif){
					     document.ChangePatDtlForm.alt_id1_reqd_yn.value='N'; 
					     document.forms[0].alt1_gif.style.visibility='hidden';
					  }
					  if(document.forms[0].alt1_exp_date1){
					     document.ChangePatDtlForm.alt_date1_reqd_yn.value='N';
					     document.forms[0].alt1_exp_date1.style.visibility='hidden';
					  }						
					}//End GHL-CRF-0332 [IN:042060] 
				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
				/*isNatIdOrAltIdMandVisaType added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
				//Maheshwaran added isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
					if((document.forms[0].isNatIdOrAltId1MandRes && document.ChangePatDtlForm.isNatIdOrAltId1MandRes.value=="true") || (document.ChangePatDtlForm.isNatIdOrAltIdMandVisaType.value=="true") || (document.ChangePatDtlForm.isNatIdAltIdMandVisaType.value=="true")){
						getVisibleMandNatAltIds();
				}
				/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/

					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
						//document.ChangePatDtlForm.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						document.ChangePatDtlForm.formno60.disabled=false;
						//document.ChangePatDtlForm.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						if(document.ChangePatDtlForm.formno60.value=="N")
							document.ChangePatDtlForm.alt_id3_no.disabled=false;
						//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
						/*document.ChangePatDtlForm.alt_id3_reqd_yn.value="Y";
						document.getElementById("alt3_gif").style.visibility='visible';*/
					}
					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/

		
	} else { 
		document.ChangePatDtlForm.citizen_yn.value='N';		

		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
		if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
			/*document.ChangePatDtlForm.formno60.value="N";
			document.ChangePatDtlForm.formno60.disabled=true;

			document.ChangePatDtlForm.alt_id3_no.value="";
			document.ChangePatDtlForm.alt_id3_no.disabled=true;*/
			/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/

			document.ChangePatDtlForm.alt_id3_reqd_yn.value="N";
			document.getElementById("alt3_gif").style.visibility='hidden';
		}
		/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
	}
}

function select_val()
{
	if(document.ChangePatDtlForm.legal[0].checked==true)
		document.ChangePatDtlForm.legal_yn.value='Y';
	else
		document.ChangePatDtlForm.legal_yn.value='N';
}
function ChangeInitCase(obj) 
{
	var name=obj.value;
	var spltval = name.split(" ") ;
	var temp_name = ""
	for(var i=0;i<spltval.length;i++)
	{
		var length= obj.value.length;
		var letter = spltval[i].substring(0,length-(length-1));
		var rest = spltval[i].substring(1,length);
		letter=letter.toUpperCase();
		rest=rest.toLowerCase();
		var  namenow= letter.concat(rest);
		temp_name+= namenow+" "
	}
	obj.value= temp_name.substring(0,temp_name.length-1);
}
function assignEmpValue() 
{
	if(document.forms[0].dflt_alt_id1_in_emp_id_yn.value=='Y')
	{
		document.getElementById("patient_employee_id").value = document.forms[0].empyr_eid.value;
	}
}
function assignEmpID(obj)
{
	if(obj.value != '') {
		document.forms[0].empyr_eid.value = obj.value;
		document.forms[0].empyr_eid.readOnly = true;
	}
	else {
		document.forms[0].empyr_eid.value = '';
		document.forms[0].empyr_eid.readOnly = false;
	}
}
