function submitForm()
{	
	var function_id = parent.Transfer_frame.document.RefPatientDtls_form.call_function.value;
	//alert("function_id---->"+function_id);
	//alert("refrral type--->"+parent.frames[1].document.RefPatientDtls_form.referral_type.value);
	//alert("function_id--->"+parent.frames[1].document.RefPatientDtls_form.func_id.value );


	document.forms[0].action="../../servlet/eMP.RegisterReferralsServlet";
	document.forms[0].target='Dummy_frame';
	

	if(function_id == "ReferralPatientDetails")
	{
		// Mandatory Fileds for Health care added by Sridhar R on 14 JUNE 2004
		var fields = new Array();	
		if(parent.Transfer_frame.document.RefPatientDtls_form.referral_type.value == 'E')
		{		
			fields[0] = parent.Transfer_frame.document.RefPatientDtls_form.referral_type;
			fields[1] = parent.Transfer_frame.document.RefPatientDtls_form.hcare_setting_type;
			fields[2] = parent.Transfer_frame.document.RefPatientDtls_form.priority;
			fields[3] = parent.Transfer_frame.document.RefPatientDtls_form.referred_to;
			fields[4] = parent.Transfer_frame.document.RefPatientDtls_form.speciality;
			fields[5] = parent.Transfer_frame.document.RefPatientDtls_form.location0;

			var names = new Array (	getLabel("Common.referraltype.label","Common"),getLabel("Common.HealthcareSettingType.label","Common"),getLabel("Common.priority.label","Common"),getLabel("Common.ReferredTo.label","Common"),getLabel("Common.speciality.label","Common"),getLabel("Common.locationtype.label","Common"));
		}
		else if(parent.Transfer_frame.document.RefPatientDtls_form.referral_type.value == 'X')
		{	
			fields[0] = parent.Transfer_frame.document.RefPatientDtls_form.referral_type;
			fields[1] = parent.Transfer_frame.document.RefPatientDtls_form.hcare_setting_type;
			fields[2] = parent.Transfer_frame.document.RefPatientDtls_form.priority;
			fields[3] = parent.Transfer_frame.document.RefPatientDtls_form.referred_to;
			//fields[4] = parent.frames[1].document.RefPatientDtls_form.speciality;
			
			var names = new Array (	getLabel("Common.referraltype.label","Common"),getLabel("Common.HealthcareSettingType.label","Common"),getLabel("Common.priority.label","Common"),getLabel("Common.ReferredTo.label","Common"));	
		}
		else
		{	
		var index=0;//Bru-HIMS-CRF-354
			fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.referral_type;
			fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.hcare_setting_type;
			fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.priority;
			fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.referred_to;
			fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.speciality;
			
			if(parent.Transfer_frame.document.RefPatientDtls_form.location0.disabled == false)
				fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.location0;
				
				/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538] */
				if(parent.frames[1].document.RefPatientDtls_form.Bedside.checked == true){				
				    fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.frm_pract_name;	
                    fields[index++] = parent.Transfer_frame.document.RefPatientDtls_form.preferred_date;					
				}
				//End Bru-HIMS-CRF-354 [IN:038538]

			//var names = new Array (	getLabel("Common.referraltype.label","Common"),getLabel("Common.HealthcareSettingType.label","Common"),getLabel("Common.priority.label","Common"),getLabel("Common.ReferredSource.label","Common"),getLabel("Common.speciality.label","Common"),getLabel("Common.locationtype.label","Common"));
			var index=0;//Bru-HIMS-CRF-354
			var names = new Array();
			names[index++] = getLabel("Common.referraltype.label","Common");
			names[index++] = getLabel("Common.HealthcareSettingType.label","Common");
			names[index++] = getLabel("Common.priority.label","Common");
			names[index++] = getLabel("Common.ReferredTo.label","Common");
			names[index++] = getLabel("Common.speciality.label","Common");
			
			if(parent.Transfer_frame.document.RefPatientDtls_form.location0.disabled == false)
				names[index++] = getLabel("Common.locationtype.label","Common");
				
		  /*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538] */
		if(parent.Transfer_frame.document.RefPatientDtls_form.Bedside.checked == true){				 
			   names[index++] = getLabel("eMP.ReferraltoPractioner.label","eMP");
			   names[index++] = getLabel("Common.PreferredDate.label","Common");
				
			}
				//End Bru-HIMS-CRF-354 [IN:038538]	
				
				
		}
		
		if(checkFields1( fields, names))
		{
			if(parent.Transfer_frame.document.RefPatientDtls_form.hcare_setting_type.disabled == true )
			parent.Transfer_frame.document.RefPatientDtls_form.hcare_setting_type.disabled = false;

			if(parent.Transfer_frame.document.RefPatientDtls_form.Bedside.checked == true)
			{
				var datefield = new Array();	
//				datefield[0] = parent.frames[1].document.RefPatientDtls_form.practitioner;
				datefield[0] = parent.Transfer_frame.document.RefPatientDtls_form.preferred_date;
				var dateName = new Array (getLabel("Common.PreferredDate.label","Common"));	

				if(checkFields1( datefield, dateName))
				{
					for(var i=0; i<parent.Transfer_frame.document.RefPatientDtls_form.length;i++)
					{
						if( parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled ==true)
						{
							parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled =false;
						}
					}
					document.forms[0].submit();	
				}
			}
			else
			{
				var locnfield = new Array(parent.Transfer_frame.document.RefPatientDtls_form.location0);	
				var locnName = new Array (getLabel("Common.locationtype.label","Common"));	
	
	
				if(parent.Transfer_frame.document.RefPatientDtls_form.referral_type.value != 'L')
				{
					for(var i=0; i<parent.Transfer_frame.document.RefPatientDtls_form.length;i++)
					{
						if(parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled == true)
						{
							parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled =false;
						}
					}							
					document.forms[0].submit();	
				}
				else
				{
					if(checkFields1( locnfield, locnName))
					{
						for(var i=0; i<parent.Transfer_frame.document.RefPatientDtls_form.length;i++)
						{
							if( parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled ==true)
							{
								parent.Transfer_frame.document.RefPatientDtls_form.elements[i].disabled =false;
							}
						}
						document.forms[0].submit();	
					}
				}
			}
			if(parent.Transfer_frame.document.RefPatientDtls_form.invokedModule.value == 'CA')
			parent.Transfer_frame.document.RefPatientDtls_form.closebtn.disabled = true;
		}
	}
	

	if(parent.Transfer_frame.document.RefPatientDtls_form.func_id.value == "PRACT_FOR_BEDSIDE_REFERRAL")
	{
		var fields = new Array();	
		fields[0] = parent.Transfer_frame.document.RefPatientDtls_form.practid;
		var names = new Array (	getLabel("Common.practitioner.label","common"));	

		if(checkFields1( fields, names))
		{
			document.forms[0].action="../../servlet/eMP.RegisterReferralsServlet";
			document.forms[0].submit();	
		}
	}
	else if(function_id == "BedSideReferral")
	{
		var fields = new Array();	
		fields[0] = parent.Transfer_frame.document.RefPatientDtls_form.BedSideDate;
		var names = new Array ();
		names[0]=getLabel("eIP.BedsideReferralSeenDate.label","IP");
        /*Below line added for this CRF HSA-CRF-146.1*/
		
	    if(parent.Transfer_frame.document.RefPatientDtls_form.allow_muti_bedside_review_yn && parent.Transfer_frame.document.RefPatientDtls_form.allow_muti_bedside_review_yn.value=="Y"){
		fields[1]=parent.Transfer_frame.document.RefPatientDtls_form.bedside_ref_review_status;
		names[1]=getLabel("Common.status.label","Common");
		}       	   
        //End HSA-CRF-146.1  
        //Below line added for this CRF ML-MMOH-CRF-0566		
		if(parent.Transfer_frame.document.RefPatientDtls_form.referralRegister && parent.Transfer_frame.document.RefPatientDtls_form.referralRegister.value=="true"){
		if(document.getElementById('ref_reg_id') && document.getElementById('ref_reg_id').style.visibility == "visible"){
		var bedside_status=parent.Transfer_frame.document.RefPatientDtls_form.bedside_ref_review_status.value;
		if(bedside_status=="S"){
			 fields[2]=parent.Transfer_frame.document.RefPatientDtls_form.referral_reg_id;
			 names[2]=getLabel("Common.ReasonforCancel.label","Common");          
		}else if(bedside_status=="X"){
			 fields[2]=parent.Transfer_frame.document.RefPatientDtls_form.referral_reg_id;
			 names[2]=getLabel("Common.ReasonforRejection.label","Common");
			  
		}   		  
   }
}
		//End this CRF ML-MMOH-CRF-0566		

		if(checkFields1( fields, names))
		{
			document.forms[0].action="../../servlet/eMP.RegisterReferralsServlet";
			document.forms[0].submit();	
		}
	}
}


async function onSuccess(refid,locncode,locntype,patientid) 
{ 
    alert("inside oncSuccess refpatient details 191");
	var features    = "dialogHeight:8; dialogWidth:35; scroll=no; status:no";
	var arguments = '';
	var message =getMessage("REFERRAL_BOOKED","common") ;
	var retVal = await window.showModalDialog('../../eOP/jsp/print_confirm_frame.jsp?call_from=REFERRAL&referral_id='+refid+'&locn_type='+locntype+'&message='+message,arguments,features);
	//parent.window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

async function callBedAvailChart()
{
	var retVal = 	new String();
	var dialogHeight= "700px";
	var dialogWidth = "1200px";
	var dialogTop	= "72";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await  window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp",arguments,features);
}

function cancel()
{
     alert("inside cancel");
	//window.parent.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function checkFields1( fields, names)
{
	var errors = "";
	for(var i=0;i<fields.length;i++ ) 
	{
		if(trimCheck1(fields[i].value)) 
		{	}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	
	if ( errors.length != 0 ) 
	{
		alert(errors) ;
		return false ;
	}
	return true ;
}


function trimCheck1(inString)
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


function validateDateTime(obj,val)
{
	if(obj.value != '')
	{
		if(!self.doDateTimeChk(obj)){
				var msg = self.getMessage("INVALID_DATE_TIME","SM");
				alert(msg);
				obj.focus();
		}
		else if(val == 'D')
		{
				self.document.RefPatientDtls_form.block_until_date.value = '';
				fr = self.document.RefPatientDtls_form.sysdatetime;
				to = self.document.RefPatientDtls_form.discharge_date_time;
				if(ValidateDischargeDate(fr,to,'D')){
					alert(self.getMessage('DIS_DATE_LT_EXCEEDED',"IP"))
					obj.focus();
				}
		}
		else if(val == 'B')
		{
			fr = self.document.RefPatientDtls_form.discharge_date_time;
			to = self.document.RefPatientDtls_form.block_until_date;
				if(ValidateDischargeDate(fr,to,'O')){
					alert(self.getMessage('BLK_DT_GREATER_DIS_DT',"IP"))
					obj.focus();
				}
		}


	}
}

function callValidate(obj)
{
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/DischargeValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value='"+obj+"'><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Discharge_form'><input type='hidden' name='field5' id='field5' value=''></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.forms[0].submit();
}

function ValidateDischargeDate(from,to,val)
{

	from = from.value;
	to		= to.value;
	var maxhrs = 0;
	var maxdays	= 0;
	var mon = 0;

	if(val == 'D')
		maxdays = self.document.RefPatientDtls_form.disdatechkdays.value;
	else if(val == 'B')
		maxhrs = parent.frames[1].document.RefPatientDtls_form.dischargeafterhrs.value;

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])+eval(maxhrs);
	mon = eval(splitdate1[1]) - 1; // because in the date constructor, months must be specified in the range  0 - 11
	 var from_date  =new Date(splitdate1[2], mon, splitdate1[0], hrs,splittime1[1])
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var days = eval(maxdays)+eval(splitdate1[0]);
	 mon = eval(splitdate1[1]) - 1;
	 var to_date  =new Date(splitdate1[2], mon,days, splittime1[0], splittime1[1])
	 if(val == 'N' || val == 'B'){
		 if(Date.parse(to_date) <= Date.parse(from_date))
			return true;
		 else
			 return false;
	 }
	 else if(Date.parse(to_date) >= Date.parse(from_date))
		return false;
	 else
		return true;
}

async function rem_callFunctions(val)
{	
	var jsp_name = "../../eCommon/blank.html";
	if(val == 'SD')
		jsp_name = "../../eIP/jsp/CurrentEncounterMain.jsp?p_fr_function=IP&encounterId="+self.document.forms[0].encounter_id.value+"&patientId="+self.document.forms[0].patient_id.value;
	else if(val == 'DA')
		jsp_name = "../../eIP/jsp/CancelDischargeAdviceMain.jsp?p_fr_function=IP&encounterId="+self.document.forms[0].encounter_id.value+"&patientId="+self.document.forms[0].patient_id.value+"&callfrom=IP&from_function=PD";
	else if(val == 'DD')
		jsp_name = "../../eCA/jsp/PatProblemMain.jsp?Context=IP_Q&stage_desc=Discharge&stage_code=D&Clinic_Code="+self.document.forms[0].nursing_unit_code.value+"&Patient_Id="+self.document.forms[0].patient_id.value+"&Encounter_Id="+self.document.forms[0].encounter_id.value+"&Practitioner_Id="+self.document.forms[0].practitioner_id.value;

	var retVal = 	new String();
	var dialogHeight= "65vh" ;
	var dialogWidth	= "70vw" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}

