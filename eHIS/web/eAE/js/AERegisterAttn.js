// Added/Modified By Nanda 10/23/2002 

function reset() 
{ 
      top.content.frames[0].document.getElementById('reset').disabled = false;
   /* parent.frames[1].frames[1].frames[0].document.forms[0].search.disabled = true;
	  parent.frames[1].frames[1].frames[0].document.forms[0].patient_search.disabled = false;
	  parent.frames[1].frames[1].frames[0].document.forms[0].patient_id.disabled = false;
	  parent.frames[1].frames[1].frames[0].document.forms[0].patient_id.value = '';
  	  parent.frames[1].frames[1].frames[0].document.forms[0].eReg.disabled = false;
	  parent.frames[1].frames[1].frames[0].document.forms[0].referal_id.disabled=false;
	  parent.frames[1].frames[1].frames[0].document.forms[0].ref_id_search.disabled=false; 
	 parent.frames[1].frames[1].frames[0].document.forms[0].patient_id.focus();
	 parent.frames[1].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
	 parent.frames[1].frames[1].frames[2].document.location.href='../../eCommon/html/blank.html';
      parent.frames[1].frames[2].document.location.href='../../eCommon/jsp/error.jsp';**/

// Wednesday, March 17, 2010 Venkats  20093 
	 parent.frames[2].frames[1].frames[0].document.forms[0].search.disabled = false;
	 parent.frames[2].frames[1].frames[0].document.forms[0].patient_search.disabled = false;
	 parent.frames[2].frames[1].frames[0].document.forms[0].patient_id.disabled = false;
	 parent.frames[2].frames[1].frames[0].document.forms[0].patient_id.value = '';
	 parent.frames[2].frames[1].frames[0].document.forms[0].referal_id.value = '';
 	 parent.frames[2].frames[1].frames[0].document.forms[0].eReg.disabled = false;
 	 parent.frames[2].frames[1].frames[0].document.forms[0].referal_id.disabled = false;
 	 parent.frames[2].frames[1].frames[0].document.forms[0].ref_id_search.disabled = false;
	 
	 //IN:48233 - Enabling NationalId field 

	 //Added by Sangeetha on 15/09/2017
	 if(parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_No != null )
	 {
		 parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_No.disabled = false;
		 parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_No.value = '';
	 }
	
	/* Below condition added by venkatesh.s on 02-April-2014 against 48233 */
	 if(parent.frames[2].frames[1].frames[0].document.forms[0].ext_system_interface_yn.value=='Y')
	 {	
		
		 //Added by Sangeetha on 15/09/2017
		 if(parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_No != null )
		 parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_Button.disabled = false;

		 //Added by Ashwin K for AAKH-CRF-0150
		 if(parent.frames[2].frames[1].frames[0].document.forms[0].txtSmart_fn_name.value == '01')
		 {
			parent.frames[2].frames[1].frames[0].document.forms[0].National_Id_No.disabled = true; 
			parent.frames[2].frames[1].frames[0].document.forms[0].EmiratesID_edit.checked = false; 
		 }
		 //Ended by Ashwin K for AAKH-CRF-0150s
		 
	 }
	 
	 // added by munisekhar for MMS-QH-CRF-0162
	 var isSiteSpe_change_pat_dtls=parent.frames[2].frames[1].frames[0].document.forms[0].isSiteSpe_change_pat_dtls.value;
	 var userFunRightsCount=parseInt(parent.frames[2].frames[1].frames[0].document.forms[0].userFunRightsCount.value); //Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	 if(isSiteSpe_change_pat_dtls=="true" && userFunRightsCount > 0)
	 parent.frames[2].frames[1].frames[0].document.getElementById("Update_pat").style.visibility="hidden"; 
     parent.frames[2].frames[1].frames[0].document.forms[0].patient_id.focus();
	 parent.frames[2].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
	 parent.frames[2].frames[1].frames[2].document.location.href='../../eCommon/html/blank.html';
	 parent.frames[2].frames[2].document.location.href='../../eCommon/jsp/error.jsp';
// end comments.

} 
   
function onSuccess()   
{
	
	f_query_add_mod.patientFrame.document.location.reload();
	f_query_add_mod.patientLine.document.location.href='../../eCommon/html/blank.html';
	f_query_add_mod.patientDetailsFrame.document.location.href='../../eCommon/html/blank.html';
}

function callCheckMaxLen(obj,noOfChars,Legend)
{
	if(CheckMaxLen(Legend,obj,noOfChars,parent.parent.messageFrame)==false)
	{
		parent.frames[2].document.getElementById('tab2').scrollIntoView();
		obj.focus();
		return false;
	}
	else
	{
		return true;
	}
}
function AECheckMaxLimit(obj,lab,max)
{
	var errors='';
	if(obj.value.length > max) {
          errors = errors + getMessage("REMARKS_CANNOT_EXCEED","Common"); 
         errors = errors.replace('$',lab);
         errors = errors.replace('#',max);
         errors = errors + "\n" ;
		 alert(errors) ;
		return false;
		obj.focus();
	} else return true;
}
//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
function SpCharChkForMotorVecRegNo(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 
//Added by mano CRF-0644
function CheckForSpecChar(event){ 
    var strCheck = ' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
//end CRF-0644
async function apply()
{  
	/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
	var isReconfirmCOTAppl = f_query_add_mod.patientDetailsFrame.document.forms[0].isReconfirmCOTAppl.value;
	var reconf_cot_param = f_query_add_mod.patientDetailsFrame.document.forms[0].reconf_cot_param.value;
	var cot_chk = "";

	if(f_query_add_mod.patientDetailsFrame.document.getElementById("trauma"))
		cot_chk = f_query_add_mod.patientDetailsFrame.document.getElementById("trauma").checked;
	else if(f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma)
		cot_chk = f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma.checked;

	if(isReconfirmCOTAppl == "true" && reconf_cot_param == 'Y' && cot_chk == false){
		showReconfCot();
	}
	/*End ML-MMOH-CRF-1409*/

	var isCaseDtlsRadioBtnAppl = f_query_add_mod.patientDetailsFrame.document.forms[0].isCaseDtlsRadioBtnAppl.value;//Added by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645 
	var isMechInjLabelChngAppl = f_query_add_mod.patientDetailsFrame.document.forms[0].isMechInjLabelChngAppl.value;//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649
	if(f_query_add_mod.patientDetailsFrame.document.forms[0] != null){
	var downtimepatient=f_query_add_mod.patientDetailsFrame.document.forms[0].downtimePatient.value;
	var frameRef	= eval(f_query_add_mod.patientDetailsFrame.document.forms[0].frameRef.value);//Added by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	//Added By Shanmukh for MMS-DM-CRF-0147
	var isPriorityZoneAppl=f_query_add_mod.patientDetailsFrame.document.forms[0].isPriorityZoneAppl.value;
	if(isPriorityZoneAppl=="true" && f_query_add_mod.patientDetailsFrame.document.forms[0].Priority_Zone_Type.value!=null){
		 f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority.value=f_query_add_mod.patientDetailsFrame.document.forms[0].Priority_Zone_Type.value;
		
	}

	if(downtimepatient=="false"){
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].priority11!=null){
		if (f_query_add_mod.patientDetailsFrame.document.forms[0].priority11.value != null)
		{
			f_query_add_mod.patientDetailsFrame.document.forms[0].priority_no_code.value = f_query_add_mod.patientDetailsFrame.document.forms[0].priority11.value;
		}
	}
	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.checked==true && f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.disabled==true){
       f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.disabled=false;
	}
	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
 	


	/*The following statement assigns the postal code from postals_code temporaty variable*/
	f_query_add_mod.patientDetailsFrame.document.forms[0].brought_dead_yn.disabled=false;
	if (f_query_add_mod.patientDetailsFrame.document.forms[0].brought_dead_yn.checked == true)
       f_query_add_mod.patientDetailsFrame.document.forms[0].brought_dead_yn.value='Y';

	f_query_add_mod.patientDetailsFrame.document.forms[0].postal_code.value = f_query_add_mod.patientDetailsFrame.document.forms[0].postals_code.value; 
	remarks			 = f_query_add_mod.patientDetailsFrame.document.forms[0].arrival_remarks;

	 var returnval = callCheckMaxLen(remarks,2000,getLabel("Common.remarks.label","Common")); 
     if (f_query_add_mod.patientDetailsFrame.document.forms[0].brought_dead_yn.checked == true)
     {
		 var fields = new Array (f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time,
		 f_query_add_mod.patientDetailsFrame.document.forms[0].location,
		 f_query_add_mod.patientDetailsFrame.document.forms[0].visit_type,
		 f_query_add_mod.patientDetailsFrame.document.forms[0].service);
        var names = new Array (getLabel("Common.VisitDateTime.label","Common"),getLabel("Common.Location.label","Common"),getLabel("eAE.RegistrationType.label","AE"),getLabel("Common.service.label","Common"));	
		//Added By Shanmukh for MMS-DM-CRF-0147
		if(isPriorityZoneAppl=="true" && f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority!=null){
			 fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority);
	    	 names.push(getLabel("Common.PriorityZone.label","Common"));
	     }
    		//top.content.frames[0].document.forms[0].apply.disabled = true;
    		frameRef.frames[0].document.forms[0].apply.disabled = true;//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	   
	 } 
	 else
	 {  
	     var fields = new Array (f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time,
		 f_query_add_mod.patientDetailsFrame.document.forms[0].location,
		 f_query_add_mod.patientDetailsFrame.document.forms[0].visit_type,
         f_query_add_mod.patientDetailsFrame.document.forms[0].service);

        var names = new Array (getLabel("Common.VisitDateTime.label","Common"),getLabel("Common.Location.label","Common"),getLabel("eAE.RegistrationType.label","AE"),getLabel("Common.service.label","Common"));
        /*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
	     if(f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority!=null){
	    	 fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority);
	    	 names.push(getLabel("Common.PriorityZone.label","Common"));
	     }
	     /*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
       //Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]  Start 
       /* top.content.frames[0].document.forms[0].apply.disabled = true;
		top.content.frames[0].document.getElementById('reset').disabled = false;*/
		frameRef.frames[0].document.forms[0].apply.disabled = true;
		 if(f_query_add_mod.patientDetailsFrame.document.forms[0].invoke_from.value!="EMER_REGN_NB"){
			frameRef.frames[0].document.getElementById('reset').disabled = false;
		 }
		//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] End
	 }

	 /*Added by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645*/
	 if(isCaseDtlsRadioBtnAppl == "true"){
		if(f_query_add_mod.patientDetailsFrame.document.getElementById("trauma").checked){
			fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].mechan_injury, f_query_add_mod.patientDetailsFrame.document.forms[0].injury, f_query_add_mod.patientDetailsFrame.document.forms[0].accidentdatetime, f_query_add_mod.patientDetailsFrame.document.forms[0].place_of_accident);
			/*Added by Thamizh selvi on 29th Mar 2018 agaisnt ML-MMOH-CRF-0649 Start*/
			if(isMechInjLabelChngAppl == "true")
				names.push(getLabel("eAE.MechOfMainInj.label","AE"), getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"));
			else/*End*/
				names.push(getLabel("Common.MechanismofInjury.label","Common"), getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"));
		}
		if(f_query_add_mod.patientDetailsFrame.document.getElementById("oscc").checked){
			fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].osccType);
			names.push(getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
		}
	 }else{
	 /*End*/
			/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
		 if (f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma.checked ){
			 fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].mechan_injury);
			 /*Added by Thamizh selvi on 29th Mar 2018 agaisnt ML-MMOH-CRF-0649 Start*/
			 if(isMechInjLabelChngAppl == "true")
				names.push(getLabel("eAE.MechOfMainInj.label","AE"));
			 else/*End*/
				names.push(getLabel("Common.MechanismofInjury.label","Common"));
		 }
		 if( f_query_add_mod.patientDetailsFrame.document.forms[0].oscc_yn.checked )
			  {			                   
					  fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].injury);
					  names.push(getLabel("eAE.MechaofSubInjury.label","AE"));				      
			  }
	 }
	//Added by Ashwini on 17-Aug-2017 for GDOH-CRF-0161
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].isLabelChngAppl.value=='true')
		{
	if( f_query_add_mod.patientDetailsFrame.document.forms[0].mv_accident_yn.checked )
		  {			                   
			      fields.push(f_query_add_mod.patientDetailsFrame.document.forms[0].place_of_accident);
				  names.push(getLabel("eAE.PlaceOfAccident.label","AE")+"/"+getLabel("eAE.PickupPlace.label","AE"));				      
		  }
		}

	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
		var errs = f_query_add_mod.patientDetailsFrame.checkFieldsLocal( fields, names, messageFrame)
        if(errs == null)    errs = '';
		

			// below code implemented for icn:19689 date:Thursday, March 11, 2010
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_no)  // Wednesday, March 24, 2010  IN020239 Venkat S
	{
		if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_no.value != "")
		{ 
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_no ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len)
					validate_len_yn=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt)
					nat_id_prompt=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt.value ;

					
				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )
				   isNumber = true
			   else
					isNumber = false

				     if ( nid.length != Nat_Id.maxLength )
						 isNumber = false

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Reg'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
					// messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					// messageFrame.visit_form.submit();
					var qryParam=frames[1].frames[0].document.forms[0].params.value;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=idChk&CalledFrom=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt+"&func_source="+encodeURIComponent(qryParam)
						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
								//Nat_Id.focus();
							}
						}
			}

	}
}

// this block implemented for 20409

if(f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no)  
	{
		if(f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no.value != "")
		{
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len)
					validate_len_yn=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt)
					nat_id_prompt=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt.value ;

				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else			
					isNumber = false

				    if ( nid.length != Nat_Id.maxLength )
						 isNumber = false

			

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Reg'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
					// messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					// messageFrame.visit_form.submit();
					var qryParam=frames[1].frames[0].document.forms[0].params.value;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=idChk&CalledFrom=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt+"&func_source="+encodeURIComponent(qryParam)
						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
								//Nat_Id.focus();
							}
						}
			}

	}
}

if(f_query_add_mod.patientDetailsFrame.document.forms[0].contact2_nat_id_no)  
	{
		if(f_query_add_mod.patientDetailsFrame.document.forms[0].contact2_nat_id_no.value != "")
		{
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=f_query_add_mod.patientDetailsFrame.document.forms[0].contact2_nat_id_no ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len)
					validate_len_yn=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len.value ;
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt)
					nat_id_prompt=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt.value ;

				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else
					isNumber = false

				    if ( nid.length != Nat_Id.maxLength )
						 isNumber = false

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Reg'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
					// messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					// messageFrame.visit_form.submit();
					var qryParam=frames[1].frames[0].document.forms[0].params.value;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=idChk&CalledFrom=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt+"&func_source="+encodeURIComponent(qryParam)
						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",f_query_add_mod.patientDetailsFrame.document.forms[0].contact2_nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
								//Nat_Id.focus();
							}
						}
			}

	}
}	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].isPracApplicable.value=='true'){
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].pract_mand_img.style.visibility == 'visible' &&f_query_add_mod.patientDetailsFrame.document.forms[0].practitioner_desc.value==''){
	var temp_err =getMessage('CAN_NOT_BE_BLANK','Common');
				temp_err ="<br/>"+temp_err.replace('$', getLabel("Common.practitioner.label","Common"));
		errs+=temp_err;
	}
	}//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081

	/*Added by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177 Start*/
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].isAutoPopulateNOKDOBAppl.value == 'true' && f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_birth_date && f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_birth_date.value!="") {
		if (!f_query_add_mod.patientDetailsFrame.isBeforeNow(f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_birth_date.value,"DMY",localeName)){
			var errMsg = f_query_add_mod.patientDetailsFrame.getMessage('DOB_CHECK','Common');
			var repMsg = getLabel('eMP.NOK.label','MP')+" "+getLabel('Common.date.label','common');
			errMsg = errMsg.replace('Date', repMsg);
			errs += errMsg + ' <br>';
		}
	}
	if (f_query_add_mod.patientDetailsFrame.document.forms[0].isAutoPopulateNOKDOBAppl.value == 'true' && f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no.value.length >= 6){
			
		var dob1 = f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_birth_date.value;
		dob1 = dob1.substring(8,10) + dob1.substring(3,5) + dob1.substring(0,2);
			
		if ( (f_query_add_mod.patientDetailsFrame.document.forms[0].natDataSourceId.value=="NRIC") && (f_query_add_mod.patientDetailsFrame.document.forms[0].natInvokeRoutine.value=="Y") &&  (dob1 != f_query_add_mod.patientDetailsFrame.document.forms[0].contact1_new_nat_id_no.value.substring(0,6)) ){
			var natmsg = f_query_add_mod.patientDetailsFrame.getMessage('MISMATCH_NAT_DOB','MP');
			natmsg = natmsg.replace('#', f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt.value);
			errs += natmsg + ' ' + getLabel('Common.in.label','common')+ " " +getLabel('Common.nextofkin.label','common')+' <br>';
		}
	}/*End*/

		if ( f_query_add_mod.patientDetailsFrame.document.forms[0].bl_success.value=="N" &&   f_query_add_mod.patientDetailsFrame.document.forms[0].bl_install_yn.value=="Y" && errs == '')
		{	
			
			   var check = await chkOnSub1();
                if(f_query_add_mod.patientDetailsFrame.document.forms[0].bl_success.value=="N"){
                	errs = getMessage("FINANCIAL_DET_MANDATORY",'MP')+ "<br>";
                }
				

				//top.content.frames[0].document.forms[0].apply.disabled = true;
				if(frameRef.frames[0].document.forms[0])
				frameRef.frames[0].document.forms[0].apply.disabled = true;//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
		}
		else if(f_query_add_mod.patientDetailsFrame.document.forms[0].bl_install_yn.value=="Y" && errs == '')
		{
			if(f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_visit_dttm !=null && (f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_visit_dttm.value!=f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value)) {
				errs = getMessage("CHG_FIN_DTLS_AE",'AE')+ "<br>";
			}
			else if(f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_location_code !=null && (f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_location_code.value!=f_query_add_mod.patientDetailsFrame.document.forms[0].location_code.value)) {
				errs = getMessage("CHG_FIN_DTLS_AE",'AE')+ "<br>";
			} 
			else if(f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_visit_type !=null && (f_query_add_mod.patientDetailsFrame.document.forms[0].dummy_visit_type.value!=f_query_add_mod.patientDetailsFrame.document.forms[0].visit_type.value)) {
				errs = getMessage("CHG_FIN_DTLS_AE",'AE')+ "<br>";
			} 
		}
//Commented the line by Suresh M for IN031623 on 02.03.2012 and moved the logic to the servlet.
		 
 /* Begin: for IN030436,added on 16/01/12 */
//if(f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value !=""){
//f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value = convertDate(f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value,"DMYHM",localeName,"en");
//}
/* End: for IN030436,added on 16/01/12 */
		
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
		var reg_date_time	= f_query_add_mod.patientDetailsFrame.document.forms[0].reg_date_time.value;
		var visit_date_time	= f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value;
		if(reg_date_time!="" && visit_date_time!=""){
			if(!isAfter(visit_date_time,reg_date_time,"DMYHMS",localeName)){ 
				var error = getMessage('REG_DATE_TIME_SHOULD_GR_EQUAL','Common');			
				error = error.replace('$',getLabel("Common.VisitDateTime.label",'Common'));			
				errs += error+ "<br>";
			}
		}
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/

		if(errs == '')
        {
			/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
			if(f_query_add_mod.patientDetailsFrame.document.forms[0].followup_enc)
			{
			f_query_add_mod.patientDetailsFrame.document.forms[0].followup_enc.disabled = false;
			}
			/*End ML-MMOH-CRF-0657*/

		 //Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start
		   /*top.content.frames[0].document.getElementById('reset').disabled = false;
			top.content.frames[0].document.forms[0].apply.disabled = true;*/
			 if(f_query_add_mod.patientDetailsFrame.document.forms[0].invoke_from.value!="EMER_REGN_NB"){
				 if(frameRef.frames[0].document.forms[0])
				frameRef.frames[0].document.getElementById('reset').disabled = false;
			 }
			 if(frameRef.frames[0].document.forms[0])
			frameRef.frames[0].document.forms[0].apply.disabled = true;
			//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] End
			/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
			var isForm60Warning=chkForm60OrPanCardAvail(f_query_add_mod.patientDetailsFrame.document.forms[0].patient_id,f_query_add_mod.patientDetailsFrame.document.forms[0].isForm60Available.value);
			
			//added by Sangeetha on 10/apr/17 for KDAH-CRF-0347
			var validationForPanCardAvail=PanCardAvailCheck(f_query_add_mod.patientDetailsFrame.document.forms[0].patient_id,f_query_add_mod.patientDetailsFrame.document.forms[0].validationForPanCardAvail.value);
			
			if(validationForPanCardAvail == "Y"){
				f_query_add_mod.patientDetailsFrame.document.forms[0].form60_YN.value= "Y";
				alert(getMessage("VALIDATE_PANCARD_MNDT_FORM60",'MP'));
			}else{
				if(validationForPanCardAvail == "N")
					f_query_add_mod.patientDetailsFrame.document.forms[0].form60_YN.value= "N";
				if(isForm60Warning=="Y"){
					alert(getMessage("FORM_60_OR_PAN_CARD",'MP'));
			    }
			}
			/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/



			/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
			if(f_query_add_mod.patientDetailsFrame.document.forms[0].bed_bay_no!=null){
				if(f_query_add_mod.patientDetailsFrame.document.forms[0].bed_bay_no.value!=''){
					checkForValidBed(f_query_add_mod.patientDetailsFrame.document.forms[0].bed_bay_no.value);
				}else{
					f_query_add_mod.patientDetailsFrame.document.forms[0].action = "../../servlet/eAE.AERegisterAttnServlet";
					f_query_add_mod.patientDetailsFrame.document.forms[0].method = "post";
					f_query_add_mod.patientDetailsFrame.document.forms[0].target = "messageFrame";
					f_query_add_mod.patientDetailsFrame.document.forms[0].submit();
			}
			}
			else{
				f_query_add_mod.patientDetailsFrame.document.forms[0].action = "../../servlet/eAE.AERegisterAttnServlet";
				f_query_add_mod.patientDetailsFrame.document.forms[0].method = "post";
				f_query_add_mod.patientDetailsFrame.document.forms[0].target = "messageFrame";
				f_query_add_mod.patientDetailsFrame.document.forms[0].submit();
			}
		}
        else
        {
		

			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;
		//	frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;
		//	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;
			
        }
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].invoke_from.value!="EMER_REGN_NB"){
		top.content.frames[0].location.href=window.tlbrsrc.value;
	}
	setTimeout('disableReset()',100); 
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].invoke_from.value=="EMER_REGN_NB")
	setTimeout('disableToolBarButtons()',200); 


	}else{
	alert(getMessage("DOWNTIME_PATIENT_NOT_ALLOWED",'COMMON'));
	parent.top.content.frames[0].location.reload();
	parent.top.content.frames[1].location.reload();
	}
}else{
	parent.top.content.frames[0].location.reload();
	parent.top.content.frames[1].location.reload();
	parent.top.content.frames[2].location.reload();
}
f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.disabled=true;
/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
if(f_query_add_mod.patientDetailsFrame.document.forms[0].followup_enc)
{
f_query_add_mod.patientDetailsFrame.document.forms[0].followup_enc.disabled = true;
}
}



function disableToolBarButtons(){
	if(parent.frames[0].document.getElementById('home')!=null && parent.parent.frames[0].document.getElementById('reset')!=null){
		parent.parent.frames[0].document.getElementById('home').disabled = true;
		parent.parent.frames[0].document.getElementById('reset').disabled = true;
	}
}



function disableReset()
{

	var frameRef	= eval(f_query_add_mod.patientDetailsFrame.document.forms[0].frameRef.value);//Added by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	var invoke_from	= f_query_add_mod.patientDetailsFrame.document.forms[0].invoke_from.value;
	if(frameRef.frames[0].document.getElementById('reset')!=null && invoke_from!='EMER_REGN_NB')
	frameRef.frames[0].document.getElementById('reset').disabled = false;
}
function checkForValidBed(bed)
	{
    if (f_query_add_mod.patientDetailsFrame.document.forms[0].bed_bay_no.value == "")
     {		

	return;
    
	}else{
		var facility_id	 = f_query_add_mod.patientDetailsFrame.document.forms[0].facilityId.value;
		var treatment_area = f_query_add_mod.patientDetailsFrame.document.forms[0].treat_area.value;


        var clinic = f_query_add_mod.patientDetailsFrame.document.forms[0].location_code.value;
		var patient_id = f_query_add_mod.patientDetailsFrame.document.forms[0].patient_id.value;
		var reg_flag ='Y';
		
		
		if (bed != "" && clinic != "" && treatment_area != "")
		{
			var HTMLValue	= "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEBedValidGI.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ManagePatGITreatArea'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='reg_flag' id='reg_flag' value='"+reg_flag+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></body></html>"
			window.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
			window.frames[2].document.dummy_form.submit();
			// window.frames[2].document.write(HTMLValue);
			// window.frames[2].dummy_form.submit();
		}
	}
	
	}
function checkFieldsLocal( fields, names, messageFrame) 
{
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$', names[i]);
			errors = errors + err+"<br/>";
		}
    }
    return errors ;
}

// added by mujafar for ML-MMOH-CRF-0632 start

function searchPatient1(obj)
{     
  

	
   if(document.forms[0].patient_id1_val.value !="")
   {
	   if(document.forms[0].patient_id1.value == "")
	   {
		   
	if(document.forms[0].contact1_new_nat_id_no)document.forms[0].contact1_new_nat_id_no.value='';
	if(document.forms[0].next_contact_name)document.forms[0].next_contact_name.value = '';
	if(document.forms[0].contact1_birth_date)document.forms[0].contact1_birth_date.value='';
	if(document.forms[0].next_addr_line1)document.forms[0].next_addr_line1.value='';
	if(document.forms[0].next_addr_line2)document.forms[0].next_addr_line2.value='';
	if(document.forms[0].next_addr_line3)document.forms[0].next_addr_line3.value='';
	if(document.forms[0].next_addr_line4)document.forms[0].next_addr_line4.value=''; 
	if(document.forms[0].contact1_res_town_code){document.forms[0].contact1_res_town_code.value='';document.forms[0].n_town.value = '';}
	if(document.forms[0].contact1_res_area_code){document.forms[0].contact1_res_area_code.value='';document.forms[0].n_area.value = '';}
	if(document.forms[0].contact1_region_code){document.forms[0].contact1_region_code.value=''; document.forms[0].n_region.value = '';}
	if(document.forms[0].next_postal_code1){document.forms[0].next_postal_code1.value='';document.forms[0].next_postal_code.value = '';}
	if(document.forms[0].next_country_desc){document.forms[0].next_country_desc.value='';document.forms[0].next_country_code.value = '';}
	if(document.forms[0].next_res_tel_no)document.forms[0].next_res_tel_no.value='';
	if(document.forms[0].contact1_mob_tel_no)document.forms[0].contact1_mob_tel_no.value='';
	if(document.forms[0].contact1_email_id)	document.forms[0].contact1_email_id.value='';

	if(document.forms[0].next_contact_relation)document.forms[0].next_contact_relation.options[0].selected=true; // added by mujafar for ML-MMOH-CRF-0632 START
	if(document.forms[0].next_job_title)document.forms[0].next_job_title.value='';
	if(document.forms[0].next_off_tel_no)document.forms[0].next_off_tel_no.value=''; // added by mujafar for ML-MMOH-CRF-0632 END
    //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
	if(document.forms[0].n_next_addr_line1)document.forms[0].n_next_addr_line1.value='';
	if(document.forms[0].n_ma_addr_line2)document.forms[0].n_ma_addr_line2.value='';
	if(document.forms[0].n_ma_addr_line3)document.forms[0].n_ma_addr_line3.value='';
	if(document.forms[0].n_ma_addr_line4)document.forms[0].n_ma_addr_line4.value=''; 
	if(document.forms[0].n_contact_ma_town_code){document.forms[0].n_contact_ma_town_code.value='';document.forms[0].nkma_town.value = '';}
	if(document.forms[0].n_contact_ma_area_code){document.forms[0].n_contact_ma_area_code.value='';document.forms[0].nkma_area.value = '';}
	if(document.forms[0].n_contac_region_code){document.forms[0].n_contac_region_code.value=''; document.forms[0].contact1_region.value = '';}
	if(document.forms[0].n_ma_postal_code1){document.forms[0].n_ma_postal_code1.value='';document.forms[0].n_ma_postal_code.value = '';}
	if(document.forms[0].nk_ma_country_desc){document.forms[0].nk_ma_country_desc.value='';document.forms[0].nkin_mail_country_code.value = '';}
	if(document.forms[0].ra_contact_name)document.forms[0].ra_contact_name.value='';
	if(document.forms[0].ma_contact_name)document.forms[0].ma_contact_name.value='';
	 //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008	   
	document.forms[0].patient_id1_val.value='';	   
		   
		   
		   
		   
	   }
   }
   
   if(document.forms[0].patient_id1.value!='' && document.forms[0].patient_id1_val.value != document.forms[0].patient_id1.value)
   { 
		

	if(obj!='')
	{
		var sou_value="2";
		parent.parent.frames[2].document.location.href="../../eAE/jsp/AEcommonValidation.jsp?P_Patient_ID="+obj.value+"&sou_value="+sou_value;
	}
	  
	setTimeout('populateData()',1000); 
	 
   }  
}

function PopulatePatData( res_addr_line1,res_addr_line2,res_addr_line3,res_addr_line4,res_town_desc,res_area_desc,res_region_desc,postal_desc,res_country_desc,res_tel_no,res_mob_no,res_mail_id,date_of_birth,res_national_id_no,pat_name,res_town_code,res_area_code,res_region_code,postal_code,res_country_code,ocpn_desc,mail_addr_line1,mail_addr_line2,mail_addr_line3,mail_addr_line4,mail_town_desc,mail_area_desc,mail_region_desc,mail_postal_desc,mail_country_desc,res_contact_name,mail_contact_name,mail_town_code,mail_area_code,mail_region_code,mail_postal_code,mail_country_code,contact3_mode,contact3_no,contact4_mode,contact4_no,contact5_mode,contact5_no) // modified by mujafar for ML-MMOH-CRF-0632 //Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008
{  
	if(document.forms[0].contact1_new_nat_id_no)
		document.forms[0].contact1_new_nat_id_no.value=res_national_id_no;
	if(document.forms[0].next_contact_name)
		document.forms[0].next_contact_name.value = pat_name;
	if(document.forms[0].contact1_birth_date)
		document.forms[0].contact1_birth_date.value=date_of_birth;
	if(document.forms[0].next_addr_line1)
		document.forms[0].next_addr_line1.value=res_addr_line1;
	if(document.forms[0].next_addr_line2)
		document.forms[0].next_addr_line2.value=res_addr_line2;
	if(document.forms[0].next_addr_line3)
		document.forms[0].next_addr_line3.value=res_addr_line3;
	if(document.forms[0].next_addr_line4)
		document.forms[0].next_addr_line4.value=res_addr_line4; 
	if(document.forms[0].contact1_res_town_code)
	{
		document.forms[0].contact1_res_town_code.value=res_town_desc;
		document.forms[0].n_town.value = res_town_code;
	}
	if(document.forms[0].contact1_res_area_code)
	{
		document.forms[0].contact1_res_area_code.value=res_area_desc;
		document.forms[0].n_area.value = res_area_code;
	}
	if(document.forms[0].contact1_region_code)
	{
		document.forms[0].contact1_region_code.value=res_region_desc;
		 document.forms[0].n_region.value = res_region_code;
	}
	if(document.forms[0].next_postal_code1)
	{
		document.forms[0].next_postal_code1.value=postal_desc;
		document.forms[0].next_postal_code.value = postal_code;

	}
	if(document.forms[0].next_country_desc)
	{
		document.forms[0].next_country_desc.value=res_country_desc;
		document.forms[0].next_country_code.value = res_country_code;

	}
	if(document.forms[0].next_res_tel_no)
		document.forms[0].next_res_tel_no.value=res_tel_no;
	if(document.forms[0].contact1_mob_tel_no)
		document.forms[0].contact1_mob_tel_no.value=res_mob_no;
	if(document.forms[0].contact1_email_id)
		document.forms[0].contact1_email_id.value=res_mail_id;
	if(document.forms[0].next_contact_relation)
	document.forms[0].next_contact_relation.options[0].selected=true;
    if(document.forms[0].next_job_title)
	document.forms[0].next_job_title.value=ocpn_desc; // modified by mujafar ML-MMOH-CRF-0632
	if(document.forms[0].next_off_tel_no)
	document.forms[0].next_off_tel_no.value=''; 
	//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
    if(document.forms[0].n_next_addr_line1)
		document.forms[0].n_next_addr_line1.value=mail_addr_line1;
	if(document.forms[0].n_ma_addr_line2)
		document.forms[0].n_ma_addr_line2.value=mail_addr_line2;
	if(document.forms[0].n_ma_addr_line3)
		document.forms[0].n_ma_addr_line3.value=mail_addr_line3;
	if(document.forms[0].n_ma_addr_line4)
		document.forms[0].n_ma_addr_line4.value=mail_addr_line4; 
	if(document.forms[0].n_contact_ma_town_code)
	{
		document.forms[0].n_contact_ma_town_code.value=mail_town_desc;
		document.forms[0].nkma_town.value = mail_town_code;
	}
	if(document.forms[0].n_contact_ma_area_code)
	{
		document.forms[0].n_contact_ma_area_code.value=mail_area_desc;
		document.forms[0].nkma_area.value = mail_area_code;
	}
	if(document.forms[0].n_contac_region_code)
	{
		document.forms[0].n_contac_region_code.value=mail_region_desc;
		 document.forms[0].contact1_region.value = mail_region_code;
	}
	if(document.forms[0].n_ma_postal_code1)
	{
		document.forms[0].n_ma_postal_code1.value=mail_postal_desc;
		document.forms[0].n_ma_postal_code.value = mail_postal_code;

	}
	if(document.forms[0].nk_ma_country_desc)
	{
		document.forms[0].nk_ma_country_desc.value=mail_country_desc;
		document.forms[0].nkin_mail_country_code.value = mail_country_code;

	}
	if(document.forms[0].ra_contact_name)
		document.forms[0].ra_contact_name.value=res_contact_name;
	if(document.forms[0].ma_contact_name)
		document.forms[0].ma_contact_name.value=mail_contact_name;

	if(document.forms[0].nk_contact3_mode)
		document.forms[0].nk_contact3_mode.value=contact3_mode;
	if(document.forms[0].nk_contact3_no)
		document.forms[0].nk_contact3_no.value=contact3_no;

	if(document.forms[0].nk_contact4_mode)
		document.forms[0].nk_contact4_mode.value=contact4_mode;
	if(document.forms[0].nk_contact4_no)
		document.forms[0].nk_contact4_no.value=contact4_no;

	if(document.forms[0].nk_contact5_mode)
		document.forms[0].nk_contact5_mode.value=contact5_mode;
	if(document.forms[0].nk_contact5_no)
		document.forms[0].nk_contact5_no.value=contact5_no;
	//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
	 
	
	
	document.forms[0].patient_id1_val.value=document.forms[0].patient_id1.value;
	
}

function populateData()
{ 
	if(document.forms[0].patient_id1.value!="")
	{
		
		var patientId			= document.forms[0].patient_id1.value;
	if(patientId!=""){ 
		
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PopulatePatientData' /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
	
	}
	
	
}
function callPatientSearch1()
{
	var patientid = PatientSearch('','','','','','','','','','');
	

	if(patientid !=null)
	{

		document.forms[0].patient_id1.value = patientid;
		document.forms[0].patient_id1.focus();
	}
	else
	{
		document.forms[0].patient_id1.value = '';
	}
}
// added by mujafar for ML-MMOH-CRF-0632 END

// For Search Button
function searchPatient(obj)
{       

// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
var max_hrs_for_re_attend=document.forms[0].max_hrs_for_re_attend.value;	
//end CRF  Bru-HIMS-CRF-152 [IN030272]


   if(document.forms[0].patient_id.value!='')
   {  
	   
	  document.forms[0].search.disabled = true;
	  document.forms[0].eReg.disabled = true;
	  document.forms[0].patient_search.disabled = true;
	  document.forms[0].patient_id.disabled = true;
      document.forms[0].ref_id_search.disabled = true;
	  document.forms[0].referal_id.disabled = true;

	  if (document.forms[0].National_Id_No)	{
		  document.forms[0].National_Id_No.disabled = true;
		  if(document.forms[0].National_Id_Button) {
			  document.forms[0].National_Id_Button.disabled = true;
		  }
	  }
	  if(obj.value!='')	
	  {
			var nat_id_prompt = document.forms[0].nat_id_prompt.value;
			var entitlement_by_cat_yn = document.forms[0].entitlement_by_cat_yn.value;
			var p_alt_id2_type = document.forms[0].p_alt_id2_type.value;
			var p_alt_id3_type = document.forms[0].p_alt_id3_type.value;
			var p_alt_id4_type = document.forms[0].p_alt_id4_type.value;
			// Thursday, April 22, 2010 VENKAT S AE-REGN-ATTN

			oper_stn_id = document.forms[0].oper_stn_id.value;
			var referal_id = document.forms[0].referal_id.value;
			var patFlag    = document.forms[0].patFlag.value;
			var fields = new Array (document.forms[0].patient_id); 
        	var names = new Array (getLabel("Common.patientId.label","Common"));	
			var params = document.forms[0].params.value;
		 	var reg_attendance_for_inpat_yn =  document.forms[0].attendance_for_inpat_yn.value;
			var error_jsp="";
			var messageFrame="";
			if(SpecialCharCheck(fields,names,messageFrame,"A",error_jsp))
		    { 
			// below this value (max_hrs_for_re_attend) added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		 	//parent.parent.frames[2].document.location.href="../../eAE/jsp/AERegisterAttnValidations.jsp?P_Patient_ID="+obj.value+"&oper_stn_id="+oper_stn_id+"&max_hrs_for_re_attend="+max_hrs_for_re_attend+"&nat_id_prompt="+nat_id_prompt+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&p_alt_id2_type="+p_alt_id2_type+"&p_alt_id3_type="+p_alt_id3_type+"&p_alt_id4_type="+p_alt_id4_type+"&patFlag="+patFlag+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn+"&params="+escape(params)+"&func_source="+document.getElementById("params").value;
				//if(!parent.parent.frames[2].location.href.includes("PatientRegistrationServlet") )
				
//				var urlsrc='../../eAE';
//				parent.parent.frames[2].document.location.href= urlsrc+"/jsp/AERegisterAttnValidations.jsp?P_Patient_ID="+obj.value+"&oper_stn_id="+oper_stn_id+"&max_hrs_for_re_attend="+max_hrs_for_re_attend+"&nat_id_prompt="+nat_id_prompt+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&p_alt_id2_type="+p_alt_id2_type+"&p_alt_id3_type="+p_alt_id3_type+"&p_alt_id4_type="+p_alt_id4_type+"&patFlag="+patFlag+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn+"&params="+escape(params)+"&func_source="+document.getElementById("params").value+"&frameRef="+document.forms[0].frameRef.value+"&invoke_from="+document.forms[0].invoke_from.value;//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				var currentPath = window.location.pathname;
                var basePath = currentPath.substring(0, currentPath.lastIndexOf("/")); // Get base path
 
                // Build the correct URL based on the base path
                var targetUrl = basePath + "/AERegisterAttnValidations.jsp?P_Patient_ID=" + obj.value + "&oper_stn_id=" + oper_stn_id + "&max_hrs_for_re_attend=" + max_hrs_for_re_attend + "&nat_id_prompt=" + nat_id_prompt + "&entitlement_by_cat_yn=" + entitlement_by_cat_yn + "&p_alt_id2_type=" + p_alt_id2_type + "&p_alt_id3_type=" + p_alt_id3_type + "&p_alt_id4_type=" + p_alt_id4_type + "&patFlag=" + patFlag + "&attendance_for_inpat_yn=" + reg_attendance_for_inpat_yn + "&params=" + escape(params) + "&func_source=" + document.getElementById("params").value + "&frameRef=" + document.forms[0].frameRef.value + "&invoke_from=" + document.forms[0].invoke_from.value;
 
                // Set timeout (e.g., 2000 ms = 2 seconds)
                setTimeout(function() {
                // Perform the redirection after the timeout
                parent.parent.frames[2].document.location.href = targetUrl;
                },0); // Delay is set to 2000 milliseconds (2 seconds)
		
		    }
			else{
				clearing();
			}
	  }
   }  
   if(document.forms[0].referal_id.value!='')
   { 

	  document.forms[0].search.disabled = true;
	  document.forms[0].ref_id_search.disabled = true;
	  document.forms[0].eReg.disabled = true;
	  document.forms[0].referal_id.disabled = true;
	  document.forms[0].patient_search.disabled = true;
	  document.forms[0].patient_id.disabled = true;
	  if (document.forms[0].National_Id_No)  {
		  document.forms[0].National_Id_No.disabled = true;
		  if(document.forms[0].National_Id_Button) {
			  document.forms[0].National_Id_Button.disabled = true;
		  }
	  }
	  var params = document.forms[0].params.value;
	  if(obj.value!='')	
	  {
			var nat_id_prompt = document.forms[0].nat_id_prompt.value;
			var entitlement_by_cat_yn = document.forms[0].entitlement_by_cat_yn.value;
			var p_alt_id2_type = document.forms[0].p_alt_id2_type.value;
			var p_alt_id3_type = document.forms[0].p_alt_id3_type.value;
			var p_alt_id4_type = document.forms[0].p_alt_id4_type.value;
			// Thursday, April 22, 2010 VENKAT S AE-REGN-ATTN

            var patFlag    = document.forms[0].patFlag.value;
			oper_stn_id = document.forms[0].oper_stn_id.value;
			var patient_id = document.forms[0].patient_id.value;

			var fields = new Array (document.forms[0].patient_id);
			var reg_attendance_for_inpat_yn =  document.forms[0].attendance_for_inpat_yn.value;
        	var names = new Array (getLabel("Common.referralid.label","Common"));	
			var error_jsp=""; 
			var messageFrame="";
			
			if(SpecialCharCheck(fields,names,messageFrame,"A",error_jsp))
		  {   

// below this value (max_hrs_for_re_attend) added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]		  
			parent.parent.frames[2].document.location.href="../../eAE/jsp/AERegisterAttnValidations.jsp?P_Patient_ID="+patient_id+"&oper_stn_id="+oper_stn_id+"&max_hrs_for_re_attend="+max_hrs_for_re_attend+"&nat_id_prompt="+nat_id_prompt+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&p_alt_id2_type="+p_alt_id2_type+"&p_alt_id3_type="+p_alt_id3_type+"&p_alt_id4_type="+p_alt_id4_type+"&patFlag="+patFlag+"&frameRef="+document.forms[0].frameRef.value+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn+"&params="+escape(params)+"&referal_id="+obj.value+"&invoke_from="+document.forms[0].invoke_from.value;
		  }
			else
				clearing();
	  }
   }  	

   if(document.forms[0].National_Id_No && document.forms[0].National_Id_No.value!='')
   {  
	  document.forms[0].search.disabled = true;
	  document.forms[0].ref_id_search.disabled = true;
	  document.forms[0].eReg.disabled = true;
	  document.forms[0].referal_id.disabled = true;
	  document.forms[0].patient_search.disabled = true;
	  document.forms[0].patient_id.disabled = true;
	  document.forms[0].National_Id_No.disabled = true;
	  if(document.forms[0].National_Id_Button) {
		 document.forms[0].National_Id_Button.disabled = true;
	  }

	  var params = document.forms[0].params.value;
	 
	  if(obj.value!='')	
	  {
			var nat_id_prompt = document.forms[0].nat_id_prompt.value;
			var entitlement_by_cat_yn = document.forms[0].entitlement_by_cat_yn.value;
			var p_alt_id2_type = document.forms[0].p_alt_id2_type.value;
			var p_alt_id3_type = document.forms[0].p_alt_id3_type.value;
			var p_alt_id4_type = document.forms[0].p_alt_id4_type.value;
			// Thursday, April 22, 2010 VENKAT S AE-REGN-ATTN

            var patFlag    = document.forms[0].patFlag.value;
			oper_stn_id = document.forms[0].oper_stn_id.value;
			var patient_id = document.forms[0].patient_id.value;
			var fields = new Array (document.forms[0].patient_id);
			var reg_attendance_for_inpat_yn =  document.forms[0].attendance_for_inpat_yn.value;

        	var names = new Array (getLabel("eMP.NationalID.label","MP"));	
			var error_jsp="";
			var messageFrame="";
			if(SpecialCharCheck(fields,names,messageFrame,"A",error_jsp))
			{
			// below this value (max_hrs_for_re_attend) added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
					parent.parent.frames[2].document.location.href="../../eAE/jsp/AERegisterAttnValidations.jsp?P_Patient_ID="+patient_id+"&National_Id_No="+document.forms[0].National_Id_No.value+"&National_Id_Flag=Y&oper_stn_id="+oper_stn_id+"&max_hrs_for_re_attend="+max_hrs_for_re_attend+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn+"&patFlag="+patFlag+"&frameRef="+document.forms[0].frameRef.value+"&nat_id_prompt="+nat_id_prompt+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&p_alt_id2_type="+p_alt_id2_type+"&p_alt_id3_type="+p_alt_id3_type+"&p_alt_id4_type="+p_alt_id4_type+"&params="+escape(params)+"&invoke_from="+document.forms[0].invoke_from.value;
			
			
			//parent.parent.frames[2].document.location.href="../../eAE/jsp/AERegisterAttnValidations.jsp?P_Patient_ID="+patient_id+"&National_Id_No="+document.forms[0].National_Id_No.value+"&National_Id_Flag=Y&oper_stn_id="+oper_stn_id+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn+"&patFlag="+patFlag+"&nat_id_prompt="+nat_id_prompt+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&p_alt_id2_type="+p_alt_id2_type+"&p_alt_id3_type="+p_alt_id3_type+"&p_alt_id4_type="+p_alt_id4_type+"&params="+escape(params);
			}
			else
				clearing();
	  }
   }
//Added by Ashwin K for AAKH-CRF-0150 ---tab out of emirates id
   if(document.forms[0].EmiratesID_edit)
	{
	$("#National_Id_No").prop('disabled', true);
	$('#EmiratesID_edit').prop('checked', false);
	$("#M_btn1").prop('disabled', false);
	}
//Ended by Ashwin K for AAKH-CRF-0150
	
}

//Added by Ashwin K for AAKH-CRF-0150
function callPatientSearch_MBtn(contact_no)
{
	var patientid = PatientSearch('','','','','','','Y','','Y','AEreg','','AdvanceTab','','','',contact_no);
	if(patientid !=null)
	{
		document.forms[0].patient_id.value = patientid;
		document.forms[0].patient_id.focus();
	}
	else
	{
		document.forms[0].patient_id.value = '';
	}
}
//Ended by Ashwin K for AAKH-CRF-0150
// For Postal Code
async function callPostalSearch(target)
{

		
	    var retVal =    new String();
		var dialogHeight= "35vh" ;
		var dialogWidth = "50vw" ;
		var status = "no";
		var arguments   = "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";

		tit=encodeURIComponent(getLabel("eMP.postalcode.label","MP"));
		sql="select postal_code, short_desc from mp_postal_code";
		search_code="postal_code"; 
		search_desc= "short_desc"
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
}

async function callCommonPostalSearch(target)
{

		
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		sql="select postal_code code, short_desc description  from mp_postal_code where upper(postal_code) like upper(?) and upper(short_desc) like upper(?)";
		
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eMP.postalcode.label","MP"), argumentArray );

		if(retVal != null && retVal != "" )  
		{
 			target.value = retVal[0] ; /* if code need to be returned */	 		
		} 
}
function setTreat()
{
		if(document.forms[0].five_level_triage_appl_yn.value!='Y'){
			if(document.forms[0].isPriorityZoneAppl.value!="true"){ //Added By Shanmukh for MMS-DM-CRF-0147
			document.forms[0].priorityR.checked = false;
			document.forms[0].priorityY.checked = false;
			document.forms[0].priorityG.checked = false;
			document.forms[0].priorityR.disabled = false;
			document.forms[0].priorityY.disabled = false;
			document.forms[0].priorityG.disabled = false;
			}
			var treat_area	= document.forms[0].treat_area;
			while(treat_area.options.length > 1)
			treat_area.remove(1);
			enableBed(document.forms[0].treat_area);
			var priority11	=  document.forms[0].priority11;
			while(priority11.options.length > 1)
			priority11.remove(1);
		}
}
// To set the Values for the sevice Description and to populate the Visit type
 function setVisit(obj)
	{
	    
		var isAERegisterTypeAutoUpdateAppl = parent.frames[0].document.forms[0].isAERegisterTypeAutoUpdateAppl.value; // added by mujafar for KDAH-CRF-0526 
		var dflt_time_reg_auto_update= parent.frames[0].document.forms[0].dflt_time_reg_auto_update.value;
		var dflt_emer_follow_type_code=parent.frames[0].document.forms[0].dflt_emer_follow_type_code.value;
		
		var visit_type	= document.forms[0].visit_type;
		var visit_status	= parent.frames[0].document.forms[0].visit_status.value;
		var prev_visit_hrs	= parent.frames[0].document.forms[0].prev_visit_hrs.value;
		// Wednesday, April 21, 2010 for PE_EXC venkat s AE-REGN-ATTN
		var to_service_code=document.forms[0].to_service.value;
		while(visit_type.options.length > 1)
		visit_type.remove(1);
		var sub_service	= document.forms[0].sub_service;
		while(sub_service.options.length > 1)
		sub_service.remove(1);
		var service	= document.forms[0].service;
		while(service.options.length > 1)
		service.remove(1);
		if(document.forms[0].location.value==''){
		var opt		=	document.createElement('OPTION'); 
		opt.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		opt.value	=	''; 
		service.add(opt);
		}
		var treat_area	= document.forms[0].treat_area;
		/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
		if(treat_area!=null){
			while(treat_area.options.length >= 1)
			treat_area.remove(0);
			var opt		=	document.createElement('OPTION'); 
			opt.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
			opt.value	=	'';
			treat_area.add(opt); 
		}
		var priority11	=  document.forms[0].priority11;
		/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
		if(priority11!=null){
			while(priority11.options.length > 1)
				priority11.remove(1);
		}
		/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
		if(document.forms[0].bed_bay_no!=null){	
			document.forms[0].bed_bay_no.value='';
		}
		
	    if(obj.value!='')
	     { 
			 var values			= obj.value.split("::");
		     var clinic_code	= values[0];
			 var service_code	= values[1];
			 var service_desc	= values[2];
			 var clinic_type	= values[3];
			 var pract_yn		= values[4];
			 var speciality_code= values[5];
	         if(service_code==null || service_code=="null" ) service_code = "";
			 if(service_desc=="null" || service_desc==null)  service_desc = "";
			 if(clinic_code=="null" || clinic_code=="null")  clinic_code  = "";
			 if(clinic_type=="null" || clinic_type=="null")  clinic_type  = "";
			 if(speciality_code=="null" || speciality_code=="null")  speciality_code  = "";
	   		 patient_id		  = document.forms[0].patient_id.value;
			 var gender         = document.forms[0].hddgender.value;
			 var preVisitFlag = "Y";
			 var serviceflag = "Y";
			 var visitflag = "Y"; 
			 var patValidflag = "Y";
			 var treatmentflag = "Y";
			 var priority = "U"; 
			 document.forms[0].location_code.value			= clinic_code;
			 document.forms[0].location_type.value			= clinic_type;
		     document.forms[0].service_code.value			= service_code;
		     document.forms[0].open_to_all_pract_yn.value	= pract_yn;
			 document.forms[0].speciality_code.value	    = speciality_code;
			 parent.parent.frames[0].document.forms[0].apply.disabled=true;
		     document.forms[0].location.disabled=true;	

            // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='serviceflag' id='serviceflag' value='"+serviceflag+"'><input type='hidden' name='visitflag' id='visitflag' value='"+visitflag+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='preVisitFlag' id='preVisitFlag' value='"+preVisitFlag+"'><input type='hidden' name='referal_service' id='referal_service' value='"+to_service_code+"'><input type='hidden' name='patValidflag' id='patValidflag' value='"+patValidflag+"'><input type='hidden' name='treatmentflag' id='treatmentflag' value='"+treatmentflag+"'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='gender' id='gender' value='"+gender+"'><input type='hidden' name='priorityno' id='priorityno'   value='4'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='patient_age' id='patient_age' value='"+document.forms[0].patient_age.value+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+parent.frames[0].document.forms[0].oper_stn_id.value+"'><input type='hidden' name='sex' id='sex' value='"+document.forms[0].sex.value+"'><input type='hidden' name='visit_status' id='visit_status' value='"+visit_status+"'><input type='hidden' name='prev_visit_hrs' id='prev_visit_hrs' value='"+prev_visit_hrs+"'><input type='hidden' name='CalledFrom' id='CalledFrom' value='register_atten'></form></BODY></HTML>";
            var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='serviceflag' id='serviceflag' value='"+serviceflag+"'><input type='hidden' name='visitflag' id='visitflag' value='"+visitflag+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='preVisitFlag' id='preVisitFlag' value='"+preVisitFlag+"'><input type='hidden' name='referal_service' id='referal_service' value='"+to_service_code+"'><input type='hidden' name='patValidflag' id='patValidflag' value='"+patValidflag+"'><input type='hidden' name='treatmentflag' id='treatmentflag' value='"+treatmentflag+"'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='gender' id='gender' value='"+gender+"'><input type='hidden' name='priorityzone' id='priorityzone'   value='U'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='patient_age' id='patient_age' value='"+document.forms[0].patient_age.value+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+parent.frames[0].document.forms[0].oper_stn_id.value+"'><input type='hidden' name='sex' id='sex' value='"+document.forms[0].sex.value+"'><input type='hidden' name='visit_status' id='visit_status' value='"+visit_status+"'><input type='hidden' name='prev_visit_hrs' id='prev_visit_hrs' value='"+prev_visit_hrs+"'><input type='hidden' name='CalledFrom' id='CalledFrom' value='register_atten'><input type='hidden' name='frameRef' id='frameRef' value='"+document.forms[0].frameRef.value+"'><input type='hidden' name='invoke_from' id='invoke_from' value='"+document.forms[0].invoke_from.value+"'><input type='hidden' name='isAERegisterTypeAutoUpdateAppl' id='isAERegisterTypeAutoUpdateAppl' value='"+isAERegisterTypeAutoUpdateAppl+"'><input type='hidden' name='dflt_time_reg_auto_update' id='dflt_time_reg_auto_update' value='"+dflt_time_reg_auto_update+"'><input type='hidden' name='dflt_emer_follow_type_code' id='dflt_emer_follow_type_code' value='"+dflt_emer_follow_type_code+"'></form></BODY></HTML>";//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
			
		
		  	 parent.parent.messageFrame.document.write(HTMLVal);
			 parent.parent.messageFrame.visit_form.submit();
			
		 }
		 else
		{
		    document.forms[0].service_code.value	 = '';
			document.forms[0].location_code.value	 = '';
			document.forms[0].location_type.value	 = '';
			document.forms[0].visit_type_code.value  = '';
  			document.forms[0].sub_service_code.value = '';
			document.forms[0].visit_type_ind.value   = '';
			document.forms[0].speciality_code.value   = '';

			if(document.forms[0].new_episode_yn)
			{
				document.forms[0].new_episode_yn.value   = '';
				document.forms[0].new_episode_yn.checked = false;
            }

			if(document.forms[0].episode_id)
			{
				document.forms[0].episode_id.value='';
		    }
			if(document.forms[0].episode_visit_no)
			{
				document.forms[0].episode_visit_no.value='';
		    }
		}
	}



//Clear the ListBox Values before Values Populate 
function remVal(obj)
{
	/*Below Condition obj!=null Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
	if(obj!=null){
		while(obj.options.length > 1)
		{
			obj.remove(1);
		}
	}
}
function remVal1(obj)
{	
	while(obj.options.length >= 1)
	{
		obj.remove(0);
	}
}
// To set the sub_service_code and sub_service Description onchange of this function
function setSubService(obj)
{
	if(obj.value!='') 
	     { 
	 		 patient_id		  = document.forms[0].patient_id.value;
			 service_code	  = document.forms[0].service.value;
			 var subserviceflag = "Y";
			// var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='service_code' id='service_code' value='"+service_code+"'><input type='hidden' name='subserviceflag' id='subserviceflag' value='"+subserviceflag+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
			 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='service_code' id='service_code' value='"+service_code+"'><input type='hidden' name='subserviceflag' id='subserviceflag' value='"+subserviceflag+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='frameRef' id='frameRef' value='"+document.forms[0].frameRef.value+"'><input type='hidden' name='invoke_from' id='invoke_from' value='"+document.forms[0].invoke_from.value+"'></form></BODY></HTML>";//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
		     parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			 parent.parent.messageFrame.visit_form.submit();
		 }
	else
		 {
		 	 document.forms[0].visit_type_code.value	= '';
  			 document.forms[0].sub_service_code.value	= '';
		 }
}

function setTrans(obj)
{
	 if(obj.value!='')
	     { 
	 		 patient_id		  = document.forms[0].patient_id.value;
			 transport_mode	  = document.forms[0].transport_mode.value;
			 var transportflag = "Y";
			 //var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='transport_mode' id='transport_mode' value='"+transport_mode+"'><input type='hidden' name='transportflag' id='transportflag' value='"+transportflag+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
			 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='transport_mode' id='transport_mode' value='"+transport_mode+"'><input type='hidden' name='transportflag' id='transportflag' value='"+transportflag+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='frameRef' id='frameRef' value='"+document.forms[0].frameRef.value+"'><input type='hidden' name='invoke_from' id='invoke_from' value='"+document.forms[0].invoke_from.value+"'></form></BODY></HTML>";//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
		    
			 parent.parent.messageFrame.document.write(HTMLVal);
			 parent.parent.messageFrame.visit_form.submit();
		 }
	 else
		 {
		 	 document.forms[0].visit_type_code.value	= '';
  			 document.forms[0].transport_mode.value	= '';
		 }
}
function setTreatment(obj)
{
	 var visit_type	    = document.forms[0].visit_type;
	 var clinictemp     = document.forms[0].location.value;
	 var gender         = document.forms[0].hddgender.value;
	 var priorityno="4";
	if(obj.checked == true && obj!=null)
	{
		remVal(document.forms[0].priority11);
		
	   if(obj.name== 'priorityR')
		 {
	      document.forms[0].priorityY.disabled=true;
	      document.forms[0].priorityG.disabled=true;
		  priorityno="1";
          document.forms[0].hddpriority.value ='R';
		 }
		 if(obj.name== 'priorityY')
		 {
	      document.forms[0].priorityR.disabled=true;
	      document.forms[0].priorityG.disabled=true;
		  priorityno="3";
		  document.forms[0].hddpriority.value ='Y';
		 }
		 if(obj.name== 'priorityG')
		 {
	      document.forms[0].priorityR.disabled=true;
	      document.forms[0].priorityY.disabled=true;
		  priorityno="2";
		  document.forms[0].hddpriority.value ='G';
		 }
	}
	else if(obj.checked == false && obj!=null)
	{
		remVal(document.forms[0].priority11);
		if(obj.name== 'priorityR')
		 {
	      document.forms[0].priorityY.disabled=false;
	      document.forms[0].priorityG.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		  document.forms[0].bed_bay_no.value = "";
		  document.forms[0].bed_bay_no.disabled = true;
		  document.forms[0].bed_button.disabled = true;

		  }
		 if(obj.name== 'priorityY')
		 {
	      document.forms[0].priorityR.disabled=false;
	      document.forms[0].priorityG.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		  document.forms[0].bed_bay_no.value = "";
		  document.forms[0].bed_bay_no.disabled = true;
		  document.forms[0].bed_button.disabled = true;

		 }
		 if(obj.name== 'priorityG')
		 {
	      document.forms[0].priorityR.disabled=false;
	      document.forms[0].priorityY.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		  document.forms[0].bed_bay_no.value = "";
		  document.forms[0].bed_bay_no.disabled = true;
		  document.forms[0].bed_button.disabled = true;

		 }
    }
	if(obj.name=="Priority_Zone_Type"){//Added By Shanmukh for MMS-DM-CRF-0147
	
	
		remVal(document.forms[0].priority11);
		document.forms[0].hddpriority.value = document.forms[0].Priority_Zone_Type.value;
		
	}//END
	 if(document.forms[0].bed_bay_no !=null)
	 document.forms[0].bed_bay_no.value = "";
     var treat_area	= document.forms[0].treat_area;
	 while(treat_area.options.length > 1)
	  treat_area.remove(1);
	 enableBed(document.forms[0].treat_area);
	 var values			= clinictemp.split("::");
	 var clinic_code	= values[0];
	 if(obj.value!='') 
	     { 
	 		 priority          = document.forms[0].hddpriority.value;
			 patient_id		   = document.forms[0].patient_id.value;
			 var treatmentflag = "Y";
			 //var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='treatmentflag' id='treatmentflag' value='"+treatmentflag+"'>              <input type='hidden' name='priorityno' id='priorityno'   value='"+priorityno+"'>   <input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='gender' id='gender' value='"+gender+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
			 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='treatmentflag' id='treatmentflag' value='"+treatmentflag+"'>              <input type='hidden' name='priorityzone' id='priorityzone'   value='"+priority+"'>   <input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='gender' id='gender' value='"+gender+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='frameRef' id='frameRef' value='"+document.forms[0].frameRef.value+"'><input type='hidden' name='invoke_from' id='invoke_from' value='"+document.forms[0].invoke_from.value+"'></form></BODY></HTML>";
			 
		

             parent.parent.messageFrame.document.write(HTMLVal);
			 parent.parent.messageFrame.visit_form.submit();

		 }
}
function enableBed(obj)
{
	if(obj.value!='')
	{ 
		if (document.forms[0].treat_area.value)
		{
			document.forms[0].bed_bay_no.value = "";
			document.forms[0].bed_bay_no.disabled = false;
			document.forms[0].bed_button.disabled = false;


		
		

			
		}
	}
	else 
	{
		    document.forms[0].bed_bay_no.value = "";
			document.forms[0].bed_bay_no.disabled = true;
			document.forms[0].bed_button.disabled = true;
	}
}
function changeCase(obj)
{
	  obj.value=obj.value.toUpperCase();
}
    
	// Function to call the Patient Search
async function callPatientSearch()
{
	var patFlag="";
	var patientid ="";
	if (document.forms[0].register_pat_yn.value=="Y")
	{
		patientid =await PatientSearch('','','','','','','Y','','Y','AEreg','');
		if(patientid !=null)
		{
		patFlag=patientid.charAt(0);
			if(patFlag == 'Y')
			{
			 document.getElementById('patFlag').value=patFlag;
			 var patientid=patientid.substring(1,patientid.length);
			}
			document.getElementById('patient_id').value = patientid;
			document.getElementById('patient_id').focus();
			parent.parent.frames[0].document.getElementById('reset').disabled = false;
			changeCase(document.getElementById('patient_id'));
		    searchPatient(document.getElementById('patient_id'));
			return false;
		}
		else
		{
		document.getElementById('patient_id').value = '';
		parent.parent.frames[0].document.getElementById('reset').disabled = false;
		return false; 
		}
	}
	else{
		patientid =await PatientSearch('','','','','','','Y','','R','AEreg','');
		if(patientid !=null)
		{
		patFlag=patientid.charAt(0);
			if(patFlag == 'Y')
			{
			 document.getElementById('patFlag').value=patFlag;
			 var patientid=patientid.substring(1,patientid.length);
			}
			document.getElementById('patient_id').value = patientid;
			document.getElementById('patient_id').focus();
			parent.parent.frames[0].document.getElementById('reset').disabled = false;
			changeCase(document.getElementById('patient_id'));
		    searchPatient(document.getElementById('patient_id'));
			return false;
		}
		else
		{
		document.getElementById('patient_id').value = '';
		parent.parent.frames[0].document.getElementById('reset').disabled = false;
		return false; 
		}
  }
	parent.parent.frames[0].location.href=parent.parent.tlbrsrc.value;
}

function changeEpisode(obj)
{
     	var obj_value = obj.value;
		if (obj_value == "N")
		 obj.value = "Y";        
		else
		 obj.value = "N";
	     if (obj.value == "Y")
         {
				document.forms[0].old_episode_id.value		      = document.forms[0].episode_id.value;
				document.forms[0].old_episode_visit_no.value	  = document.forms[0].episode_visit_no.value;
				document.forms[0].episode_id.value				  = "";
				document.forms[0].episode_visit_no.value		  = "";
         }
         else
         {
				document.forms[0].episode_id.value				  = document.forms[0].old_episode_id.value;
				document.forms[0].episode_visit_no.value		  = document.forms[0].old_episode_visit_no.value;
         }
    }

// function to show the last visit details
async function showLastVisitDetails(val)
{
	if(val == "LastVisit24")
	{
	  // var encounter_id		= document.forms[0].last_encounter_id.value; venkat s 
       var clinic_code_one = document.forms[0].location.value;
       var clinic_code     = clinic_code_one.split("::");
       clinic_code         = clinic_code[0];
       var patient_id      = document.forms[0].patient_id.value;
       var retVal		   =  new String();
	   var dialogHeight	   = "50vh" ;
	   var dialogWidth	   = "45vw" ;

       var features		   = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
       var lastVisit24HrFlag ="Y";
       var arguments	= "" ;
      // retVal = window.showModalDialog("../../eAE/jsp/AERegisterAttnLastVisitFrameSet.jsp?encounter_id="+encounter_id+"&lastVisit24HrFlag="+lastVisit24HrFlag+"&clinic_code="+clinic_code+"&patient_id="+patient_id+"&func_source="+parent.frames[0].document.forms[0].params.value,arguments,features);
       retVal =await top.window.showModalDialog("../../eAE/jsp/AERegisterAttnLastVisitFrameSet.jsp?lastVisit24HrFlag="+lastVisit24HrFlag+"&clinic_code="+clinic_code+"&patient_id="+patient_id+"&func_source="+parent.frames[0].document.forms[0].params.value,arguments,features);
   }
   return retVal;
}

function populateContactDetails( val){
	

var concat_address_hidden=val;
var arr_concat_vals=concat_address_hidden.split("^^");




			document.forms[0].addr1_type.value					= arr_concat_vals[0];
			document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
			document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
			document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
			document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
			document.forms[0].res_town_code.value			= arr_concat_vals[5]; 
			document.forms[0].res_area_code.value				= arr_concat_vals[6]; 
			document.forms[0].postals_code.value					= arr_concat_vals[7]; 
			document.forms[0].res_region_code.value					= arr_concat_vals[8]; 
			document.forms[0].country_code.value				= arr_concat_vals[9]; 
			document.forms[0].contact1_name.value			= arr_concat_vals[10];
			document.forms[0].invalid1_yn.value				= arr_concat_vals[11];

			document.forms[0].addr2_type.value					= arr_concat_vals[12];
			document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
			document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
			document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
			document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; 
			document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; 
			document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; 
			document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; 

			document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; 
			document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; 

			document.forms[0].contact2_name.value		=  arr_concat_vals[22]; 
			document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; 

			document.forms[0].contact1_no.value		=  arr_concat_vals[24];
			document.forms[0].contact2_no.value		=  arr_concat_vals[25];
			document.forms[0].email.value		=  arr_concat_vals[26];
			document.forms[0].change_address.value  = 'Y';
			document.forms[0].res_town_desc.value =arr_concat_vals[28];
		    document.forms[0].res_area_desc.value =arr_concat_vals[29];
		    document.forms[0].region_desc.value =arr_concat_vals[30];
		    document.forms[0].mail_res_town_desc.value =arr_concat_vals[31];
		    document.forms[0].mail_res_area_desc.value =arr_concat_vals[32];
		    document.forms[0].mail_region_desc.value =arr_concat_vals[33];
		    document.forms[0].country_desc.value =arr_concat_vals[34];
		    document.forms[0].mail_country_desc.value =arr_concat_vals[35];
			document.forms[0].r_postal_code1.value =arr_concat_vals[36];
		    document.forms[0].m_postal_code12.value =arr_concat_vals[37];
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			document.forms[0].alt_addr_line1.value = unescape(arr_concat_vals[38]);
			document.forms[0].alt_addr_line2.value = unescape(arr_concat_vals[39]);
			document.forms[0].alt_addr_line3.value = unescape(arr_concat_vals[40]);
			document.forms[0].alt_addr_line4.value = unescape(arr_concat_vals[41]);
			document.forms[0].alt_town_code.value = unescape(arr_concat_vals[42]);
			document.forms[0].alt_area_code.value = unescape(arr_concat_vals[43]);
			document.forms[0].alt_postal_code.value = unescape(arr_concat_vals[44]);
			document.forms[0].alt_region_code.value = unescape(arr_concat_vals[45]);
			document.forms[0].alt_country_code.value = unescape(arr_concat_vals[46]);
			document.forms[0].alt_town_desc.value = unescape(arr_concat_vals[47]);
			document.forms[0].alt_area_desc.value = unescape(arr_concat_vals[48]);
			document.forms[0].alt_postal_desc.value = unescape(arr_concat_vals[49]);
			document.forms[0].alt_region_desc.value = unescape(arr_concat_vals[50]);
			document.forms[0].alt_country_desc.value = unescape(arr_concat_vals[51]);
			/*End*/

}
// function for contact details
async function Modal_Contact_Details(obj)
{
		var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
		// document.forms[0].call_mp_pat_add_update.value="Y";//for calling the mp Procedure - Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
		var retVal =    new String();
		var dialogHeight= "80vh" ;
		var dialogWidth = "83vw" ;
		/*Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true")
			dialogWidth = "80vw" ;
		/*End*/
		var status = "no";
		var patient_id = document.forms[0].patient_id.value
		var concat_address_hidden=document.forms[0].addr1_type.value					+"^^"
		+document.forms[0].addr_line1.value						+"^^"
		+document.forms[0].addr_line2.value						+"^^"
		+document.forms[0].addr_line3.value						+"^^"
		+document.forms[0].addr_line4.value						+"^^"
		+document.forms[0].res_town_code.value			+"^^"
		+document.forms[0].res_area_code.value				+"^^"
		+document.forms[0].postals_code.value					+"^^"
		+document.forms[0].res_region_code.value					+"^^"
		+document.forms[0].country_code.value				+"^^"
		+document.forms[0].contact1_name.value				+"^^"
		+document.forms[0].invalid1_yn.value				+"^^"
		+document.forms[0].addr2_type.value					+"^^"
		+document.forms[0].mail_addr_line1.value			+"^^"
		+document.forms[0].mail_addr_line2.value			+"^^"
		+document.forms[0].mail_addr_line3.value			+"^^"
		+document.forms[0].mail_addr_line4.value			+"^^"
		+document.forms[0].mail_res_town_code.value	+"^^"
		+document.forms[0].mail_res_area_code.value	+"^^"
		+document.forms[0].mail_postal_code.value	    +"^^"
		+document.forms[0].mail_region_code.value		+"^^"
		+document.forms[0].mail_country_code.value+"^^"
		+document.forms[0].contact2_name.value		+"^^"
		+document.forms[0].invalid2_yn.value +"^^"
		+document.forms[0].contact1_no.value +"^^"
		+document.forms[0].contact2_no.value +"^^"
		+document.forms[0].email.value +"^^"
		+document.forms[0].change_address.value +"^^"
		+document.forms[0].res_town_desc.value +"^^"
		+document.forms[0].res_area_desc.value +"^^"
		+document.forms[0].region_desc.value +"^^"
		+document.forms[0].mail_res_town_desc.value +"^^"
		+document.forms[0].mail_res_area_desc.value +"^^"
		+document.forms[0].mail_region_desc.value +"^^"
		+document.forms[0].country_desc.value +"^^"
		+document.forms[0].mail_country_desc.value+"^^"
		+document.forms[0].r_postal_code1.value+"^^"
		+document.forms[0].m_postal_code12.value ;

		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true"){
			concat_address_hidden = concat_address_hidden +"^^"
			+document.forms[0].alt_addr_line1.value	+"^^"
			+document.forms[0].alt_addr_line2.value	+"^^"
			+document.forms[0].alt_addr_line3.value	+"^^"
			+document.forms[0].alt_addr_line4.value	+"^^"
			+document.forms[0].alt_town_code.value	+"^^"
			+document.forms[0].alt_area_code.value	+"^^"
			+document.forms[0].alt_postal_code.value +"^^"
			+document.forms[0].alt_region_code.value +"^^"
			+document.forms[0].alt_country_code.value +"^^"
			+document.forms[0].alt_town_desc.value +"^^"
			+document.forms[0].alt_area_desc.value +"^^"
			+document.forms[0].alt_postal_desc.value +"^^"
			+document.forms[0].alt_region_desc.value +"^^"
			+document.forms[0].alt_country_desc.value ;
		}/*End*/

		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;  
		
		retVal =await  window.showModalDialog( "../../eMP/jsp/ContactDetailsFrame.jsp?AE_YN=Y&patient_id="+patient_id,arguments,features);

		if(retVal != null)
		{
			document.forms[0].concat_address_hidden.value=retVal;
			var arr_concat_vals=retVal.split("^^");
			document.forms[0].addr1_type.value					= arr_concat_vals[0];//  
			document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
			document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
			document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
			document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
			document.forms[0].res_town_code.value			= arr_concat_vals[5]; //
			document.forms[0].res_area_code.value				= arr_concat_vals[6]; //
			document.forms[0].postals_code.value					= arr_concat_vals[7]; //
			document.forms[0].res_region_code.value					= arr_concat_vals[8]; //
			document.forms[0].country_code.value				= arr_concat_vals[9]; //
			document.forms[0].contact1_name.value			= arr_concat_vals[10]; //
			document.forms[0].invalid1_yn.value				= arr_concat_vals[11]; //

			document.forms[0].addr2_type.value					= arr_concat_vals[12]; //
			document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
			document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
			document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
			document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; //
			document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; //
			document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; //
			document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; //

			document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; //
			document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; //

			document.forms[0].contact2_name.value		=  arr_concat_vals[22]; //
			document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; //

			document.forms[0].contact1_no.value		=  arr_concat_vals[24];
			document.forms[0].contact2_no.value		=  arr_concat_vals[25];
			document.forms[0].email.value		=  arr_concat_vals[26];
			document.forms[0].change_address.value  = 'Y';

			document.forms[0].res_town_desc.value =arr_concat_vals[27];
		   document.forms[0].res_area_desc.value =arr_concat_vals[28];
		   document.forms[0].region_desc.value =arr_concat_vals[29];

		   document.forms[0].mail_res_town_desc.value =arr_concat_vals[30];
		   document.forms[0].mail_res_area_desc.value =arr_concat_vals[31];
		   document.forms[0].mail_region_desc.value =arr_concat_vals[32];
		    document.forms[0].country_desc.value =arr_concat_vals[33];
		   document.forms[0].mail_country_desc.value =arr_concat_vals[34];
		   document.forms[0].r_postal_code1.value =arr_concat_vals[35];
		   document.forms[0].m_postal_code12.value =arr_concat_vals[36];
		   /*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			if(isAlternateAddressAppl == "true"){
				document.forms[0].alt_addr_line1.value		= arr_concat_vals[37];
				document.forms[0].alt_addr_line2.value		= arr_concat_vals[38];
				document.forms[0].alt_addr_line3.value		= arr_concat_vals[39];
				document.forms[0].alt_addr_line4.value		= arr_concat_vals[40];
				document.forms[0].alt_town_code.value		= arr_concat_vals[41];
				document.forms[0].alt_area_code.value		= arr_concat_vals[42];
				document.forms[0].alt_postal_code.value		= arr_concat_vals[43];
				document.forms[0].alt_region_code.value		= arr_concat_vals[44];
				document.forms[0].alt_country_code.value	= arr_concat_vals[45];
				document.forms[0].alt_town_desc.value		= arr_concat_vals[46];
				document.forms[0].alt_area_desc.value		= arr_concat_vals[47];
				document.forms[0].alt_postal_desc.value		= arr_concat_vals[48];
				document.forms[0].alt_region_desc.value		= arr_concat_vals[49];
				document.forms[0].alt_country_desc.value	= arr_concat_vals[50];
			}/*End*/

	}
}

async function Modal_Patient_Valuables(obj)
{
		var retVal =    new String();
		var dialogHeight= "25vh" ;
		var dialogWidth = "55vw" ;
		var status = "no";

		var patient_id = document.forms[0].patient_id.value;
		var patient_valuables_val=document.forms[0].patient_valuables_rcdby.value+"||"+document.forms[0].patient_valuables_chkin_dtm.value+"||"+escape(document.forms[0].patient_valuables_remarks.value);
		var arguments	="";
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		retVal =await window.showModalDialog( "../../eOP/jsp/PatientValuablesMain.jsp?valuble="+patient_valuables_val,arguments,features);
		if(retVal != null)
		{
		var retarr=retVal.split("||");
		document.forms[0].patient_valuables_rcdby.value=retarr[0];
		document.forms[0].patient_valuables_chkin_dtm.value=retarr[1];
		document.forms[0].patient_valuables_remarks.value=retarr[2];
     	}
}

function clearing()
{    
	  parent.parent.frames[0].document.getElementById('reset').disabled = false;
	  document.forms[0].search.disabled = false;
	  document.forms[0].patient_search.disabled = false;
	  document.forms[0].patient_id.disabled = false;
	  document.forms[0].eReg.disabled = false ;
	  document.forms[0].eReg.checked = false ;
      document.forms[0].ref_id_search.disabled = false;
	  document.forms[0].referal_id.disabled = false;
	  document.forms[0].patient_id.value = '';
	  document.forms[0].referal_id.value = '';
	  if(document.forms[0].National_Id_No) {
		document.forms[0].National_Id_No.value = '';
		document.forms[0].National_Id_No.disabled = false;
	  }
	  // added by munisekhar for MMS-QH-CRF-0162
	  var isSiteSpe_change_pat=top.content.frames[1].frames[0].document.forms[0].isSiteSpe_change_pat_dtls.value;
	   var userFunRightsCount=parseInt(top.content.frames[1].frames[0].document.forms[0].userFunRightsCount.value); //Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
      if(isSiteSpe_change_pat=="true" && userFunRightsCount > 0)
	  top.content.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="hidden";
	  if(document.forms[0].National_Id_Button)
		  document.forms[0].National_Id_Button.disabled = false;

	  $("#National_Id_No").prop('disabled', true);//Added by Ashwin K for AAKH-CRF-0150
	  $("#EmiratesID_edit").prop('checked', false);//Added by Ashwin K for AAKH-CRF-0150
	  
	  var bl_install_yn = document.forms[0].bl_install_yn.value;
	  document.forms[0].patient_id.focus();
	  if( parent.frames[1])
		parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	  if( parent.frames[2].document.forms[0])
		parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	  if( parent.parent.frames[2])
		parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';
	  if(bl_install_yn == "Y")
		{ 
		     parent.parent.frames[3].document.location.href='../../eBL/jsp/BLSessionValuesReset.jsp?fin_dtls_reset=Y';
		}

}

function setDoneDuring(obj)
{
	if(obj.checked == true)
	{
			document.forms[0].done_during.readOnly = false;
	}
	else
	{
			document.forms[0].done_during.readOnly = true;
			document.forms[0].done_during.value = '';
	}
}

function AEScrollIntoView(tabidx)
{
	var  p_enc_type;
	if(tabidx == 1)
    {
		document.getElementById('tab1').scrollIntoView();
	    document.forms[0].visit_date_time.focus();
    }
	else if(tabidx == 2)
	{

		document.getElementById('tab2').scrollIntoView();
		document.forms[0].accompany_by.focus();
	}
	else if(tabidx == 3)
	{
		document.getElementById('tab3').scrollIntoView();
		document.forms[0].next_contact_name.focus();
	}
	else if(tabidx == 4)
	{
		document.getElementById('tab3').scrollIntoView();
		document.forms[0].first_contact_name.focus();
	}
	else if(tabidx == 5)
	{
		document.getElementById('tab5').scrollIntoView();
		document.forms[0].organization_name.focus();
	}
	else{
	document.getElementById('financial_tab').scrollIntoView();} 
}

function setEmergency(obj)
{
	if (obj.checked == true)
	{
		document.forms[0].emergency.value='Y';
	}
	else if (obj.checked == false)
	{
		document.forms[0].emergency.value='N';
	}
}

//OnLoad Function............
function setPriorityNew()
{
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='priorityzone' id='priorityzone'   value='U'><input type='hidden' name='serviceflag' id='serviceflag'   value='Y'><input type='hidden' name='func_source' id='func_source'  value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
    parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.visit_form.submit();
}


function setPriority(obj) 
{

	if(obj.checked == true)
	 {
		remVal(document.forms[0].priority11);
		
	   if(obj.name== 'priorityR')
		 {
	      document.forms[0].priorityY.disabled=true;
	      document.forms[0].priorityG.disabled=true;
          document.forms[0].hddpriority.value ='R';
		 }
		 if(obj.name== 'priorityY')
		 {
	      document.forms[0].priorityR.disabled=true;
	      document.forms[0].priorityG.disabled=true;
		  document.forms[0].hddpriority.value ='Y';
		 }
		 if(obj.name== 'priorityG')
		 {
	      document.forms[0].priorityR.disabled=true;
	      document.forms[0].priorityY.disabled=true;
		  document.forms[0].hddpriority.value ='G';
		 }
	}
	else if(obj.checked == false)
	{
		remVal(document.forms[0].priority11);
		if(obj.name== 'priorityR')
		 {
	      document.forms[0].priorityY.disabled=false;
	      document.forms[0].priorityG.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		  }
		 if(obj.name== 'priorityY')
		 {
	      document.forms[0].priorityR.disabled=false;
	      document.forms[0].priorityG.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		 }
		 if(obj.name== 'priorityG')
		 {
	      document.forms[0].priorityR.disabled=false;
	      document.forms[0].priorityY.disabled=false;
		  document.forms[0].hddpriority.value ='U';
		 }
    }

		
}
function broughtDead(obj)
{
	if (obj.checked == true)
	{
	  if(obj.name=='brought_dead_yn')
		{
		document.forms[0].brought_dead_yn.value='Y';
		document.forms[0].brought_dead_ynhdd.value='Y';
//Added for GHL-CRF-0650
		if(document.forms[0].isMLCAppl.value == true ||  document.forms[0].isMLCAppl.value == 'true'){
			if(document.forms[0].mlc_case_yn.checked){
				document.forms[0].mlc_death.checked = true;
				document.forms[0].mlc_death.value = 'Y';
			}
		}//End of GHL-CRF-0650
        }
	}
	else if (obj.checked == false)
	{
		if(obj.name=='brought_dead_yn')
		{
		document.forms[0].brought_dead_yn.value='N';
		document.forms[0].brought_dead_ynhdd.value='N';
			//Added for GHL-CRF-0650
			if(document.forms[0].isMLCAppl.value == true ||  document.forms[0].isMLCAppl.value == 'true'){
				document.forms[0].mlc_death.checked = false;
				document.forms[0].mlc_death.value = 'N';
			}//End of GHL-CRF-0650
		}
	}
}
function mlcCase(obj)
{
	if (obj.checked == true)
	{
	  if(obj.name=='mlc_case_yn')
		{
		document.forms[0].mlc_case_yn.value='Y';
        }
	}
	else if (obj.checked == false)
	{
		if(obj.name=='mlc_case_yn')
		{
		document.forms[0].mlc_case_yn.value='N';
		}
	}
} 
function mvAccident(obj)
{
	if (obj.checked == true)
	{
	  if(obj.name=='mv_accident_yn')
		{
		    document.forms[0].mv_accident_yn.value='Y';
        }
	}
	else if (obj.checked == false)
	{
		if(obj.name=='mv_accident_yn')
		{
			document.forms[0].mv_accident_yn.value='N';
		}
	}
}
 // added by munisekhar for MMS-QH-CRF-0162
	 function ChangePatVisHid(frameRef){
	//var isSiteSpe_change_pat_dtls=document.forms[0].isSiteSpe_change_pat_dtls.value;
	/*var isSiteSpe_change_pat_dtls=top.content.frames[1].frames[0].document.forms[0].isSiteSpe_change_pat_dtls.value;  //Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	var userFunRightsCount=top.content.frames[1].frames[0].document.forms[0].userFunRightsCount.value;

	if(isSiteSpe_change_pat_dtls=="true" && userFunRightsCount > 0){
		if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!="" ){
		top.content.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="visible";
		}
		else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!="" ){
		top.content.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="visible";
		}else{
		top.content.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="hidden";
		}
		}*/
	var isSiteSpe_change_pat_dtls=frameRef.frames[1].frames[0].document.forms[0].isSiteSpe_change_pat_dtls.value;  //Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	var userFunRightsCount=frameRef.frames[1].frames[0].document.forms[0].userFunRightsCount.value;

	if(isSiteSpe_change_pat_dtls=="true" && userFunRightsCount > 0){
		if(frameRef.frames[1].frames[0].document.forms[0].patient_id.value!="" ){
		frameRef.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="visible";
		}
		else if(frameRef.frames[1].frames[0].document.forms[0].referal_id.value!="" ){
		frameRef.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="visible";
		}else{
		frameRef.frames[1].frames[0].document.getElementById('Update_pat').style.visibility="hidden";
		}
		}

		}
// added by munisekhar for MMS-QH-CRF-0162
async function getPatientDetails(patient_id){

	var dialogHeight = '95vh';
	var dialogWidth = '70vw';
	var wintop = '65';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
	var arguments = '';
	var retVal = '';
	//called_from_newborn changed as "N" by Dharma against MMS-DM-SCF-0611 [IN:070200] on 15th Apr 2019
	//var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=Y&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	
	var retVal =await top.window.showModalDialog(param,arguments,features);
	if(retVal == true){
	
	//top.content.frames[1].location.reload();
	
	parent.frames[1].document.location.reload();
	parent.frames[2].document.location.reload();
	}
	//parent.Main_frame.location.reload();
	//parent.patient_sub3.location.href = self.location.href;
	
	if(retVal == undefined || retVal == true) {
		changeToolBar();
	} 
	
}

function changeToolBar() {
			home_required_yn = 'Y';
			parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=AE&function_id=AE_REGISTER_ATTN&function_name=Register Attendance&function_type=F&access=NYNNN&home_required_yn='+home_required_yn;
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}

function setOccOfPerson()
{
	var occ_of_per	= document.forms[0].occ_of_per;
	while(occ_of_per.options.length > 1)
	occ_of_per.remove(1);
	var occ_class =document.getElementById("occ_class").value;
    var occ_classFlag = "Y";
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='occ_class' id='occ_class' value='"+occ_class+"'><input type='hidden' name='occ_classFlag' id='occ_classFlag' value='"+occ_classFlag+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'><input type='hidden' name='frameRef' id='frameRef' value='"+document.forms[0].frameRef.value+"'><input type='hidden' name='invoke_from' id='invoke_from' value='"+document.forms[0].invoke_from.value+"'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.visit_form.submit();
}

function sendToValidation(Val,areaobj,messageFrame)
{
var HTMLVal = new String();
if ( Val == 7 )
{
        if(areaobj.value !='')
        {
            HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/AEServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='7'>";
			
			var mode =areaobj.name

			if( mode=="m_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('m_region').value + "'>";
			if( mode=="m_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('m_area').value + "'>";
			if( mode=="m_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('m_town').value + "'>";
			if( mode=="contact1_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('n_region').value+ "'>";
			//Below added by Suji keerthi for ML-MMOOH-CRF-1527 US008
            if( mode=="n_contac_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('contact1_region').value+ "'>";

			if( mode=="fst_to_no_ma_reg_cod")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('contact2_region').value+ "'>";
			//Ended by Suji keerthi for ML-MMOOH-CRF-1527 US008
			if( mode=="contact2_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('f_region').value + "'>";
			if( mode=="contact3_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById('e_region').value + "'>";
			if( mode=="contact1_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('n_area').value + "'>";
			//Below added by Suji keerthi for ML-MMOOH-CRF-1527 US008
            if( mode=="n_contact_ma_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('nkma_area').value + "'>";

			if( mode=="fst_to_no_ma_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('contact2_res_area').value + "'>";
			//Ended by Suji keerthi for ML-MMOOH-CRF-1527 US008
			if( mode=="contact2_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('f_area').value + "'>";
			if( mode=="contact3_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById('e_area').value + "'>";
			if( mode=="contact1_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('n_town').value + "'>";
			//Below added by Suji keerthi for ML-MMOOH-CRF-1527 US008
            if( mode=="n_contact_ma_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('nkma_town').value + "'>";

			if( mode=="fst_to_no_ma_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('contact2_res_town').value + "'>";
            //Ended by Suji keerthi for ML-MMOOH-CRF-1527 US008
			if( mode=="contact2_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('f_town').value + "'>";
			if( mode=="contact3_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById('e_town').value + "'>";
			if ( mode== "m_postal_code" || mode == "next_postal_code" || mode == "n_ma_postal_code" || mode == "fst_no_ma_pos_cod" || mode=="first_postal_code" || mode=="employ_postal_code") //Modified by Suji keerthi for ML-MMOOH-CRF-1527 US008
				HTMLVal += "<input name='postal_code' id='postal_code' type='hidden' value='"+areaobj.value + "'>";
           
            HTMLVal += "<input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>" ;
		     parent.parent.messageFrame.document.write(HTMLVal);
			 parent.parent.messageFrame.form1.submit();
        }
    }
} // END OF THE FUNCTION
function setDisaster(obj) 
{ 
	if (obj.checked == true)
	{
		document.forms[0].Disaster_YN.value='Y';
		document.forms[0].disaster_area1.disabled = false;
		document.forms[0].disaster.disabled = false;	
		document.forms[0].disaster_type.disabled = false;
	    document.forms[0].disaster_Reference.disabled = false;
	
	}
	else if (obj.checked == false)
	{
		document.forms[0].Disaster_YN.value='N';
		document.forms[0].disaster_area1.value="";
		document.forms[0].disaster_area1.disabled = true;
		document.forms[0].disaster.disabled = true;	
		document.forms[0].disaster_type.value="";
		document.forms[0].disaster_type.disabled = true;
		document.forms[0].disaster_Reference.disabled = true;
		//Added by Sangeetha for ML-MMOH-CRF-0644 incident [IN:064480]
	    document.forms[0].disaster_Reference.value = "";
		document.forms[0].disaster_area.value="";
	}
}
function assignnewfileno(val)
{
	
	if(document.forms[0].new_file_no != null)
	{
	document.forms[0].new_file_no.value=val;
	}
	
}
function setBL(){
 	if(document.forms[0].bl_enter_yn != null)
	{
 		document.forms[0].bl_enter_yn.value='Y';	
	}	
}

function checkingBL()
{	
	var retVal = true;
	if(document.forms[0].bl_enter_yn != null)
	{
  		if(	document.forms[0].bl_enter_yn.value=='Y'){
			retVal = false;
		}
	}
 	return retVal;
}

async function chkOnSub1()
        {
	   /********** added on 9th Dec 2003 for fin detail referral id********/
		var financial_detail_ref_id= f_query_add_mod.patientDetailsFrame.document.forms[0].financial_detail_ref_id.value;
		var financial_detail_org_type=f_query_add_mod.patientDetailsFrame.document.forms[0].org_type.value;
		var referral_id=f_query_add_mod.patientDetailsFrame.document.getElementById('referral_id').value;
		/*********************************************/
            var package_flag="";
            if (f_query_add_mod.patientDetailsFrame.document.forms[0].pkg_sel.value == "Y")
                package_flag="Y";
            else
                package_flag="N";
            var ins_auth_flag="N";
            var upd_pat_flag = "Y";
            var pkg_bill_type			=f_query_add_mod.patientDetailsFrame.document.forms[0].pkg_bill_type.value;
            var pkg_bill_no				=f_query_add_mod.patientDetailsFrame. document.forms[0].pkg_bill_no.value;
            var billing_group				=f_query_add_mod.patientDetailsFrame.document.forms[0].billing_group;

            var billing_mode				=f_query_add_mod.patientDetailsFrame.document.forms[0].billing_mode;

			// Added for Billing Enhancements
			f_query_add_mod.patientDetailsFrame.document.forms[0].bl_success.value = "N";
            var health_card_expired_yn1		= f_query_add_mod.patientDetailsFrame.document.forms[0].health_card_expired_yn1.value;
			var health_card_expired_yn		= f_query_add_mod.patientDetailsFrame.document.forms[0].health_card_expired_yn;

			var calling_module_id	= "AE";
			var calling_function_id = "VISIT_REGISTRATION";

            var patient_id		 = f_query_add_mod.patientDetailsFrame.document.forms[0].patient_id;   var episode = "";
   
            var show_hide_blng_class = "HIDE";
            var record = "";
            var cnt = "<%=reccnt%>";

            if (cnt == 0)
                record = "N";
            else
                record  = "Y";
            
			if(billing_group.value!="" && record == "Y")
				billing_mode.value="Modify";
	
			var operation="";
			if (record == "Y" && billing_group.value!="")
				operation="Update";

			var visit_date_time = f_query_add_mod.patientDetailsFrame.document.forms[0].visit_date_time.value;
			visit_date_time = convertDate(visit_date_time,"DMYHM",localeName,"en");
            
            var clinic_code_one = f_query_add_mod.patientDetailsFrame.document.forms[0].location.value;
            var visit_type_code_one =f_query_add_mod.patientDetailsFrame. document.forms[0].visit_type.value;
            			// MOD#03 Added new parameters for passing to the financial tab
 			var bl_interface_yn = f_query_add_mod.patientDetailsFrame.document.forms[0].bl_interface_yn.value;    
 			var bl_install_yn	= f_query_add_mod.patientDetailsFrame.document.forms[0].bl_install_yn.value;    
 			var facilityId		= f_query_add_mod.patientDetailsFrame.document.forms[0].facilityId.value;   
			
 			var priority		= "";  
 			if(f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority!=null){
 				priority	= f_query_add_mod.patientDetailsFrame.document.forms[0].hddpriority.value;
 			}
			
			
			var brought_dead_yn	= f_query_add_mod.patientDetailsFrame.document.forms[0].brought_dead_ynhdd.value;   
			if (brought_dead_yn=='Y')
             priority ='D';
			var care_locn_type_ind =f_query_add_mod.patientDetailsFrame.document.forms[0].care_locn_type_ind.value; 
            var patient_class ='EM';
 			// End MOD#03

				 var clinic_code = clinic_code_one.split("::");
						clinic_code=clinic_code[0];
				  
				 var visit_type_code = visit_type_code_one.split("::");
				 visit_type_code=visit_type_code[0];
			
			var qryStr="operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value;

            qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;

			qryStr += "&health_card_expired_yn="+health_card_expired_yn1+"&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code;
            
            qryStr +=  "&episode="+episode+"&record="+record+"&patient_id="+patient_id.value+"&show_hide_blng_class="+show_hide_blng_class+"&Chg_to_Visitor_Grp="+f_query_add_mod.patientDetailsFrame.document.forms[0].Chg_to_Visitor_Grp.value;

	        		//MOD#04	Passing to the financial tab
			qryStr += "&bl_interfaced_yn="+bl_interface_yn+ 
			"&bl_install_yn="+bl_install_yn+
			"&facilityId="+facilityId+
			"&priority="+priority+
			"&care_locn_type_ind="+care_locn_type_ind+"&patient_class="+patient_class;
			qryStr += "&practitioner_id=";
			qryStr += "&practitioner_type_ind=";
			// End MOD#04
			// End MOD#04

/********* added on 11/13/2003 for passing financial detail referral id ******/
if(referral_id==""){
qryStr +="&financial_detail_ref_id="+financial_detail_ref_id;
qryStr +="&org_type_ind="+financial_detail_org_type;
}
else{
qryStr +="&financial_detail_ref_id="+referral_id;
qryStr +="&org_type_ind="+financial_detail_org_type;

}
qryStr +="&encounter_date_time="+visit_date_time;
//Added by Shanmukh for MMS-DM-CRF-0147.1
var pat_critical_case_yn="";
if(f_query_add_mod.patientDetailsFrame.document.forms[0].isPriorityZoneAppl.value=="true" && f_query_add_mod.patientDetailsFrame.document.forms[0].pat_critical_case_yn.checked==true){
	pat_critical_case_yn="Y";
}else{
	pat_critical_case_yn="N";
}
qryStr +="&pat_critical_case_yn="+pat_critical_case_yn;

/*f_query_add_mod.patientDetailsFrame.document.forms[0].all.dummy_visit_dttm.value=f_query_add_mod.patientDetailsFrame.document.forms[0].all.visit_date_time.value;
f_query_add_mod.patientDetailsFrame.document.forms[0].all.dummy_location_code.value=f_query_add_mod.patientDetailsFrame.document.forms[0].all.location_code.value;
f_query_add_mod.patientDetailsFrame.document.forms[0].all.dummy_visit_type.value=f_query_add_mod.patientDetailsFrame.document.forms[0].all.visit_type.value;
*/
		f_query_add_mod.patientDetailsFrame.document.getElementById('dummy_visit_dttm').value=f_query_add_mod.patientDetailsFrame.document.getElementById('visit_date_time').value;
		f_query_add_mod.patientDetailsFrame.document.getElementById('dummy_location_code').value=f_query_add_mod.patientDetailsFrame.document.getElementById('location_code').value;
		f_query_add_mod.patientDetailsFrame.document.getElementById('dummy_visit_type').value=f_query_add_mod.patientDetailsFrame.document.getElementById('visit_type').value;

 var returnArray = new Array();
            //returnArray =await getFinDtl(qryStr);
            
            var retVal;
            var dialogHeight= "95vh" ;//39
            var dialogWidth = "65vw" ;//65
            var dialogTop = "85" ;
            var center = "1" ;                                                         
            var status="no";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
            var arguments   = "" ;
            var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
            returnArray =await window.showModalDialog(url,arguments,features);
            
            if(returnArray==null) returnArray="";
            
            
            if(returnArray.length>0)
            {
                billing_group.value         = returnArray[0];
				f_query_add_mod.patientDetailsFrame.document.forms[0].bl_success.value = "Y";
                billing_mode.value          = "Modify"              
              
            }
            else
                return false;                       

            var ln = billing_group.value;
			var blinterface = "<%=bl_interface_yn%>";
            if (ln.length>0)
                if (blinterface=='Y')
					if (f_query_add_mod.patientDetailsFrame.document.forms[0].compute)
						f_query_add_mod.patientDetailsFrame.document.forms[0].compute.disabled=false;
                
                //document.tab_click(document.getElementById("visit_tab"))
        }
    async function getFinDtl(qryStr) 
        {
            var retVal;
            var dialogHeight= "90vh" ;//39
            var dialogWidth = "90vw" ;//65
            var dialogTop = "85" ;
            var center = "1" ;                                                         
            var status="no";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
            var arguments   = "" ;
            var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
            retVal =await top.window.showModalDialog(url,arguments,features);
            if(retVal==null) retVal="";
            return retVal; 
        
        }

   async  function showPackage()
        {           
            var retVal;
            var dialogHeight= "25vh" ;
            var dialogWidth = "55vw" ;
            var dialogTop = "150" ;
            var center = "1" ;                                                         
            var status="no";
            var patient_id = "<%=patient_id%>";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
            var arguments   = "" ;
            var url = "../../eBL/jsp/QueryPackageDetails.jsp?patient_id="+patient_id+"&mode=OP";
            retVal =await window.showModalDialog(url,arguments,features);                        
            if ((retVal!=null) && (retVal!="")) document.forms[0].pkg_sel.value = "Y";
            var returnArray = new Array();
            if ((retVal!=null) && (retVal!=""))
                returnArray = retVal.split(",");
            if(returnArray.length>0)
            {
                f_query_add_mod.patientDetailsFrame.document.forms[0].pkg_bill_type.value = returnArray[0];
                f_query_add_mod.patientDetailsFrame.document.forms[0].pkg_bill_no.value = returnArray[1];
            } 
        }

        function ChkInsurExpiry(policy_type, policy_expiry_date, sys_date) 
        {
            var enteredDateArray; var sysDateArray;
            var enteredDate = policy_expiry_date.value ;
            var sysDate = sys_date.value;

            if(enteredDate.length > 0 && sysDate.length > 0 ) 
            {
                enteredDateArray = enteredDate.split("/");
                sysDateArray = sysDate.split("/");
                var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
                var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);  
                if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)) 
                {
                    var ret; 
                    if (window.confirm('The Insurance Policy of the Patient has expired. Do you want to modify Financial Details?')==true)  
                        ret='Y'; 
                    else 
                        ret='N'; 
                    if (ret=='Y') 
                        chkOnSub(); 
                    else 
                    {
                        parent.top.content.frames[0].document.forms[0].ct_patient_id.value = "";
                        parent.top.content.frames[0].tab_click("checkin_tab");
                    }
                }
                else if(Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) return true;
            }   
        }

/** Added From AERegisterAttnSearch **/
function setFocus()
  {
	   if(document.forms[0].patient_id)
	  {
		   document.forms[0].patient_id.focus();
	  }
  }

  function disReset()
  {
	  parent.parent.frames[0].document.getElementById('reset').disabled = false;
  }
  function ResultRefresh(obj,obj1)
  {

   }


   // function for Referral ID
 async function getReferralID()
        {
            var retVal;
            var dialogTop       = "85";
            var dialogHeight    = "50vh" ;
            var dialogWidth     = "75vw" ;    
            var arguments       = "" ;
            var center = "1" ;
            var status="no";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
            var arguments   = "" ;
            
            oth_params = "&p_patient_id="+document.getElementById("patient_id").value+"&p_referral_id="+document.getElementById("referal_id").value
         //   var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=AE_REGISTER_ATTN&p_select=YES&p_reg_patient=YES"+oth_params
			var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=AE_REGISTER_ATTN&function_id=AE_REGISTER_ATTN&p_select=YES&p_reg_patient=YES"+oth_params
            retVal =await  top.window.showModalDialog(url,arguments,features);
			trimmedRetVal=retVal.replace(/%$/, '').trim();///
            if(trimmedRetVal==null){ trimmedRetVal="";
			
            document.forms[0].referal_id.value= trimmedRetVal;
			document.forms[0].referal_id.focus();
            parent.parent.frames[0].document.getElementById("reset").disabled = false;
			return false;
			}
			else
			{
			document.forms[0].referal_id.value= trimmedRetVal;
			document.forms[0].referal_id.focus();
            parent.parent.frames[0].document.getElementById('reset').disabled = false;
			return false;
			}
            //document.getElementById("search").click()
        }
// Function for Referral Id


async function eRegistration()
{
	
	var retVal =  new String();
	var dialogTop= "0";
	var dialogHeight= "80vh" ;
	var dialogWidth = "90vw" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; overflow: hidden;";
	var arguments = "" ;
	var apply_oth_name = "N"; 
	document.forms[0].search.disabled = true;
	document.forms[0].patient_search.disabled = true;
	retVal =await top.window.showModalDialog("../../eMP/jsp/EmergRegn.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN&func_act=Visitreg&called_from=AE",arguments,features);
		document.forms[0].eReg.checked = false;
		document.forms[0].patient_search.disabled = false;
		document.forms[0].search.disabled = false;
		if(retVal != null)
		{	
		document.forms[0].patFlag.value="Y";
		document.forms[0].patient_id.value= retVal;
		document.forms[0].patient_id.focus();
		changeCase(document.forms[0].patient_id);
		disReset();
		searchPatient(document.forms[0].patient_id);
		}
		
}

function eRegistration1()
{
	parent.parent.parent.frames[1].window.close();
}
/** Added from AERegisterAttnValidations **/
function enableAll()
{
	top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;	
	top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
	top.content.frames[1].frames[0].document.forms[0].referal_id.value='';	
	top.content.frames[1].frames[0].document.forms[0].referal_id.disabled=false;
	if(top.content.frames[1].frames[0].document.forms[0].National_Id_No) {
		top.content.frames[1].frames[0].document.forms[0].National_Id_No.value=''; 
		top.content.frames[1].frames[0].document.forms[0].National_Id_No.disabled=false;
		if(top.content.frames[1].frames[0].document.forms[0].National_Id_Button) {
			top.content.frames[1].frames[0].document.forms[0].National_Id_Button.disabled = false;
		}
	}

	//Added by Ashwin K for AAKH-CRF-0150
	if(top.content.frames[1].frames[0].document.forms[0].EmiratesID_edit) {
	top.content.frames[1].frames[0].document.forms[0].National_Id_Button.disabled = true;
	}
	//Ended by Ashwin K for AAKH-CRF-0150

	top.content.frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;
	top.content.frames[1].frames[0].document.forms[0].search.disabled=false;	
	top.content.frames[1].frames[0].document.forms[0].eReg.disabled= false;	top.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;	
	top.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html'
	top.content.frames[1].frames[2].location.href='../../eCommon/html/blank.html'
}
async function callConfirmBilling()
{	
	
	var retVal;
	var dialogHeight= "15vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eBL/jsp/BLBillingGroupConfirm.jsp",arguments,features);
	return retVal;
}

function setValue()
{ 

	alternate_id_cont_yn = "N";//str;

}

/** Added from AERegisterAttnResult.jsp **/

function disReset() 
  {
	 if(document.forms[0].invoke_from.value!="EMER_REGN_NB")
		  parent.parent.frames[0].document.getElementById('reset').disabled = false;
  }

/*function lockKey()
	 {
	    if(event.keyCode == 93)
		    getMessage("WELCOME","Common");
	 }*/

function tab_click1(objName)
	{
		
		   if(objName=="tab1")
			{
				document.getElementById('tab1').scrollIntoView();
		        document.forms[0].visit_date_time.focus();
			}
		   if(objName=="tab2")
			{
				document.getElementById('tab2').scrollIntoView();
		        document.forms[0].accompany_by.focus();
			}
			if(objName=="#kin")
			{
				document.getElementById('kin').scrollIntoView();
				document.getElementById('next_contact_name').focus();
			}
			if(objName=="#kin1") 
			{

				document.getElementById('kin1').scrollIntoView();
				document.getElementById('first_contact_name').focus();
			}
			if(objName=="#empyr")
			{
				document.getElementById('empyr').scrollIntoView();
				document.getElementById('organization_name').focus();
			}
	}
/**
	SearchLookup for Country.
	@param  - Lookup title,Target fieldname
**/
 async  function searchCountry(obj,target)
	{
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
		if(obj.name=="contry_code" || obj.name=="nk_ma_country_code" || obj.name=="ma_country_code") //Modified by Suji keerthi for ML-MMOH-CRF-1527 US008
		{
			if(target.name=="nationality_desc"){ 
			tit=getLabel("Common.nationality.label","Common");
			sql="Select country_code code,long_desc description from MP_COUNTRY_LANG_VW where language_id='"+localeName+"' and eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
			}
			else{ 
			tit=getLabel("Common.country.label","Common");
			sql="Select country_code code,long_name description from MP_COUNTRY_LANG_VW where  language_id='"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?) order by 2";
			}
		}
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			if(target.name == 'nationality_desc')
				document.forms[0].nationality_code.value= arr[0];
			else if(target.name == 'e_country_desc')
				document.forms[0].e_country_code.value= arr[0];
			else if(target.name == 'first_country_desc')
				document.forms[0].first_country_code.value= arr[0];
			else if(target.name == 'next_country_desc')
				document.forms[0].next_country_code.value= arr[0];
			else if(target.name == 'empyr_country_desc')
				document.forms[0].empyr_country_code.value= arr[0];
			 //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
			else if(target.name == 'nk_ma_country_desc')
				document.forms[0].nkin_mail_country_code.value= arr[0];
			else if(target.name == 'first_mail_country_desc')
				document.forms[0].first_mail_country_code.value= arr[0];
			//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}
		else{
			target.value='';
			}
	}

async function Loc()
{
	var deceased_yn = document.forms[0].deceased_yn.value;
	if (deceased_yn =='Y')
	{
	document.forms[0].brought_dead_yn.value='Y';
	document.forms[0].brought_dead_ynhdd.value='Y';
	document.forms[0].brought_dead_yn.checked = true;
	//document.getElementById("mand2").style.visibility="hidden";
	}
	else{
		//document.getElementById("mand2").style.visibility="visible";
	}
	
	
	document.forms[0].visit_date_time.focus();
	 
	if (document.forms[0].location !=null)
	{
	//remVal1(document.forms[0].service)
	
	var check = await setVisit(document.forms[0].location); //Monday, July 12, 2010 22535 (venkat s)
	}
}

function chksys(obj)
{
	var sysDateSer=obj.value;
	
}
/**
Used to Validate Visit Date Time.
**/
/*function chkFromToTime2(Obj)
{
	var AllowedDate=document.forms[0].AllowedDate.value;
	var sys_date=document.forms[0].sysdate.value;

	var fromFormDate ='';
	if(Obj.value != '') 
	{
		if(!validDate(Obj.value,'DMYHMS',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			Obj.select();
		}
		else
		{
		//fromFormDate = convertDate(Obj.value,"DMYHM",localeName,"en");
		fromFormDate = Obj.value;
	
		var HTMLVal = new String();		
		var flag="refresh_dates";
		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eAE/jsp/DisasterRegistrationPopulate.jsp'><input type='hidden' name='process_id' id='process_id' value='"+flag+"'><input type='hidden' name='AllowedDate' id='AllowedDate' value='"+AllowedDate+"'><input type='hidden'  name='sys_date' id='sys_date' value='"+sys_date+"'></form></BODY></HTML>";
        parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);		 parent.parent.messageFrame.document.form1.submit(); 
     
      
	  
         if((!isBetween(document.forms[0].AllowedDate.value,document.forms[0].sysdate.value,fromFormDate,'DMYHMS',localeName)))
			{
    		alert(getMessage("AE_VISIT_PARAM_DATE_TIME","AE"));
				Obj.select();
			}
		}
	}
}
*/
function chkFromToTime2(Obj) {
    var AllowedDate = document.forms[0].AllowedDate.value;
    var sys_date = document.forms[0].sysdate.value;

    if (Obj.value != '') {
        if (!validDate(Obj.value, 'DMYHMS', localeName)) {
            alert(getMessage("INVALID_DATE_TIME", 'SM'));
            Obj.select();
        } else {
            var fromFormDate = Obj.value;

            // Create HTML content for the form
            var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eAE/jsp/DisasterRegistrationPopulate.jsp'><input type='hidden' name='process_id' id='process_id' value='refresh_dates'><input type='hidden' name='AllowedDate' id='AllowedDate' value='" + AllowedDate + "'><input type='hidden' name='sys_date' id='sys_date' value='" + sys_date + "'></form></body></html>";

            // Insert HTML content into messageFrame
            try {
                var messageFrame = parent.parent.messageFrame;

                if (messageFrame && messageFrame.document) {
                    messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
                    var form1 = messageFrame.document.forms['form1'];

                    if (form1) {
                        form1.submit();
                    } else {
                        console.error('Form1 does not exist in messageFrame.');
                    }
                } else {
                    console.error('MessageFrame or its document is not accessible.');
                }

                // Perform date validation
                if (!isBetween(document.forms[0].AllowedDate.value, document.forms[0].sysdate.value, fromFormDate, 'DMYHMS', localeName)) {
                    alert(getMessage("AE_VISIT_PARAM_DATE_TIME", "AE"));
                    Obj.select();
                }
            } catch (error) {
                console.error('Error in accessing or submitting form in messageFrame:', error);
            }
        }
    }
}

/**
Used to Validate Birth Date.
**/ 
function doDate(obj)
	{
	  if(obj.value != '') 
	  {
		if(!validDate(obj.value,'DMY',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			//obj.select();
			obj.value="";
		}
		else
		{
			if((!isBeforeNow(obj.value,'DMY',localeName)))
			{
				alert(getMessage("DOB_CHECK",'Common'));
				document.forms[0].contact1_birth_date.select();
			}
		}
	  }
    }

function ClearAltID()
{
   document.forms[0].oth_alt_id.value= "";
}
/**
   Used to enable or disable the Occupation Description TextField
   based on the List Item.
**/
function enableocpn()
	{
		if(document.forms[0].occ_of_per.selectedIndex != 0)
		{
			document.forms[0].occu_of_per_desc.value = '';
			document.forms[0].occu_of_per_desc.disabled = true;
		}
		else if (document.forms[0].occ_of_per.selectedIndex == 0)
		{
		    document.forms[0].occu_of_per_desc.disabled = false;
		}
	}

async function callBedAvailChart()
	{
		var retVal	= 	new String();
		var Val		= 	new String();
		var dialogHeight= "77vh" ;
		var dialogWidth	= "50vw" ;
		var dialogTop	= "66" ;
		var status		= "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var treatment_area_code = document.forms[0].treat_area.value;


        var clinic_code = document.forms[0].location_code.value;
		var bed_no = trimString(document.forms[0].bed_bay_no.value);
		var patient_id = document.forms[0].patient_id.value;
		var priority_zone =document.forms[0].hddpriority.value
			

		var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&bed_no="+bed_no+"&call_function=AssignTrmtArea&bed_status=V&priority_zone="+priority_zone;
		retVal =await top.window.showModalDialog(url,arguments,features);
		if(retVal!=null)
		{
			
			Val = retVal.split("^");
			document.forms[0].bed_bay_no.value			= Val[0];
			document.forms[0].bed_bay_no.focus();
			return;
		}
		else
		{
			document.forms[0].bed_bay_no.value			=	"";
			return;
	
		}
	}
async function showPrevEncounter()
{
	var patient_id = document.forms[0].patient_id.value;
	var dialogWidth = "95vw" ;
	var	dialogHeight = "96vh";
	var dialogTop = "190" ;
	var status = "no";
	
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+" ; scroll=no; status:" + status;
     retVal = await top.window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id,arguments,features);
}

/** For Disaster Area **/
async function searchDisasterArea(obj,target)
     {
                var retVal =    new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";				
					if(target.name == 'disaster_area1'){
					tit=getLabel("eAE.DisasterArea.label","AE");
                    
				   sql="select res_town_code code,long_desc description from mp_res_town where upper(res_town_code)like upper(?) and upper(long_desc) like upper(?) and eff_status = 'E' order by 2";
					}
							
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal =await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                 {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					
					target.value=arr[1];
					if(target.name == 'disaster_area1')
					{
						document.forms[0].disaster_area.value= arr[0];
						document.forms[0].disaster_area1.value= arr[1];	
						document.forms[0].disaster_area1.disabled=false;
						
					}
			    }
			   else
		       {
				 target.value="";
				 return;
			   }
	}

 //also added on 8/25/2003 for billing interface
async function chkOnSub()
        {
	   /********** added on 9th Dec 2003 for fin detail referral id********/
		var financial_detail_ref_id=document.forms[0].financial_detail_ref_id.value;
		var financial_detail_org_type=document.forms[0].org_type.value;
		var referral_id=document.getElementById('referral_id').value;
		/*********************************************/
            var package_flag="";
            if (document.forms[0].pkg_sel.value == "Y")
                package_flag="Y";
            else
                package_flag="N";
            var ins_auth_flag="N";
            var upd_pat_flag = "Y";
            var pkg_bill_type			=document.forms[0].pkg_bill_type.value;
            var pkg_bill_no				= document.forms[0].pkg_bill_no.value;
            var billing_group				=document.forms[0].billing_group;
            var billing_mode				=document.forms[0].billing_mode;

			// Added for Billing Enhancements
			document.forms[0].bl_success.value = "N";
            var health_card_expired_yn1		= document.forms[0].health_card_expired_yn1.value;
			var health_card_expired_yn		= document.forms[0].health_card_expired_yn;

			var calling_module_id	= "AE";
			var calling_function_id = "VISIT_REGISTRATION";

            var patient_id		 = document.forms[0].patient_id;    

			var episode = "";
            
            var show_hide_blng_class = "HIDE";
            
            var record = "";
			var reccnt  =     document.forms[0].reccnt.value;
            var cnt = reccnt ;

            if (cnt == 0)
                record = "N";
            else
                record  = "Y";
            
            if(billing_group.value!="" && record == "Y")
				billing_mode.value="Modify";
	
			var operation="";
			if (record == "Y" && billing_group.value!="")
				operation="Update";
            
            var clinic_code_one = document.forms[0].location.value;
            var visit_type_code_one = document.forms[0].visit_type.value;
           	// MOD#03 Added new parameters for passing to the financial tab
 			var bl_interface_yn = document.forms[0].bl_interface_yn.value;    
 			var bl_install_yn	= document.forms[0].bl_install_yn.value;    
 			var facilityId		= document.forms[0].facilityId.value;   
			var priority		= document.forms[0].hddpriority.value;   
			var brought_dead_yn	= document.forms[0].brought_dead_ynhdd.value; 
			if (brought_dead_yn=='Y')
             priority ='D';
			var care_locn_type_ind = document.forms[0].care_locn_type_ind.value; 

			var visit_date_time = document.forms[0].visit_date_time.value;
			visit_date_time = convertDate(visit_date_time,"DMYHM",localeName,"en");
 
 			// End MOD#03

				 var clinic_code = clinic_code_one.split("::");
						clinic_code=clinic_code[0];
				  
				 var visit_type_code = visit_type_code_one.split("::");
				 visit_type_code=visit_type_code[0];
				  var patient_class ='EM';

            var qryStr="operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value;
            
            qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;

			qryStr += "&health_card_expired_yn="+health_card_expired_yn1+"&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code;
            
            qryStr += "&episode="+episode+"&record="+record+"&patient_id="+patient_id.value+"&show_hide_blng_class="+show_hide_blng_class+"&Chg_to_Visitor_Grp="+document.forms[0].Chg_to_Visitor_Grp.value;

	        //MOD#04	Passing to the financial tab
			qryStr += "&bl_interfaced_yn="+bl_interface_yn+ 
			"&bl_install_yn="+bl_install_yn+
			"&facilityId="+facilityId+
			"&priority="+priority+
			"&care_locn_type_ind="+care_locn_type_ind+"&patient_class="+patient_class;
			// End MOD#04

            /********* added on 11/13/2003 for passing financial detail referral id ******/
			if(referral_id==""){
			qryStr +="&financial_detail_ref_id="+financial_detail_ref_id;
			qryStr +="&org_type_ind="+financial_detail_org_type;
			}
			else{
			qryStr +="&financial_detail_ref_id="+referral_id;
			qryStr +="&org_type_ind="+financial_detail_org_type;

			}
			qryStr +="&encounter_date_time="+visit_date_time;
//Added by Shanmukh for MMS-DM-CRF-0147.1
var pat_critical_case_yn="";
if(document.forms[0].isPriorityZoneAppl.value=="true" && document.forms[0].pat_critical_case_yn.checked==true){
	pat_critical_case_yn="Y";
}else{
	pat_critical_case_yn="N";
}
qryStr +="&pat_critical_case_yn="+pat_critical_case_yn;

	/*	document.forms[0].all.dummy_visit_dttm.value=document.forms[0].all.visit_date_time.value;
		document.forms[0].all.dummy_location_code.value=document.forms[0].all.location_code.value;
		document.forms[0].all.dummy_visit_type.value=document.forms[0].all.visit_type.value;
		*/


		document.getElementById('dummy_visit_dttm').value=document.getElementById('visit_date_time').value;
		document.getElementById('dummy_location_code').value=document.getElementById('location_code').value;
		document.getElementById('dummy_visit_type').value=document.getElementById('visit_type').value;
	
       var returnArray = new Array();
            returnArray =await getFinDtl(qryStr);
						document.getElementById('ADDVISIT').style.display = 'inline';
						document.getElementById('ARRIVAL').style.display = 'none';
						document.getElementById('RELATEDCONTACT').style.display = 'none';	
						document.getElementById('NEXT_OF_KIN').style.display = 'none';
						document.getElementById('FIRST_TO_NOTIFY').style.display = 'none';
						document.getElementById('EMP_DETAILS').style.display = 'none';
            if(returnArray.length>0)
            {
                billing_group.value         = returnArray[0];
				document.forms[0].bl_success.value = "Y";
                billing_mode.value          = "Modify"              
               
            }
            else
                return false;                       

            var ln = billing_group.value;
			var bl_interface_yn = document.forms[0].bl_interface_yn.value;  
			var blinterface = bl_interface_yn;
            if (ln.length>0)
                if (blinterface=='Y')
					if (document.forms[0].compute)
						document.forms[0].compute.disabled=false;
        }

async function dispAuth1(outstamt, patient_id)
{
			/*
				  Below code added for Scrum 10638
				*/

	   var patient_id =  patient_id;
		var retVal_BL =    new String();
       	var center='1';
		var dialogTop = "30";
		var dialogHeight = "15vh" ;
		var dialogWidth = '45vw' ;
		var title='Pat Reg Charges'
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"step1=STEP_OTH&function_id=VISIT_REGISTRATION&"+"patient_id="+patient_id;	
		


		retVal_BL= await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDetValidationFrame.jsp?"+param,arguments,features);
		
			if ((retVal_BL == "N")  || (retVal_BL == undefined) ||  (retVal_BL == "undefined"))  
	{
		parent.frames[2].document.forms[0].ct_patient_id.value = "";
		parent.top.content.frames[0].location.reload();
		parent.top.content.frames[1].location.reload();
	}
	else
	{
		//code end  for Scrum 10638
        var retVal =    new String();
        var dialogHeight= "60vh" ;//20
        var dialogWidth = "40vw" ;
        var status = "no";
        var arguments   = "" ;
        var frame_list;
        frame_list =  parent.frames[2].document.forms[0];


        var patient_id=patient_id;
        var outst_amount = outstamt;
		var calling_module_id	= "AE";
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

        retVal = await window.showModalDialog("../../eBL/jsp/dispCreditAuth.jsp?patient_id="+patient_id+"&outst_amt="+outst_amount+"&calling_module_id=AE",arguments,features);

        if (retVal==null) retVal="";
        if ((retVal[0] == "N")  || (retVal[0] == undefined) ||  (retVal[0] == "undefined")) {
            
            parent.frames[2].document.forms[0].ct_patient_id.value = "";
			
			parent.top.content.frames[0].location.reload();
			parent.top.content.frames[1].location.reload();
          
        }
        else
        {
            if(retVal.length>0){
				if(retVal[0]=="Y"){
                var remarks=frame_list.remarks;				
                var user_id=frame_list.user_id;
                remarks.value=retVal[2];
                user_id.value=retVal[3];
                frame_list.upd_user_flag.value = "Y";
				}
			}
        }
	}
}

async function show_patwindowReferral(q_clinic_code,q_appt_ref_no,referral_id)
{  
	var retVal =    new String();
    var dialogHeight= "50vh" ;
    var dialogWidth = "50vw" ;
	var val ='x';
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments   = "" ;
    q_add_params = ""
       if(referral_id != '')
         q_add_params = "&p_referral_id="+referral_id+"" ; 
         
    retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?q_appt_ref_no="+q_appt_ref_no+"&function_id=&func_act=REF_SEARCH&q_clinic_code="+q_clinic_code+q_add_params,arguments,features);
	if (retVal != null && retVal !='undefined')
	{
		if (retVal != 'C')
		{ 
		    ChangePatVisHid(eval('parent'));// added by munisekhar for MMS-QH-CRF-0162
			return retVal;
		}
		else{
		return val;
		}
	}
	else {
		return val;
		}
}

function CheckMaxLen(lab,obj,max,messageFrame) {
	
        if(obj.value.length > max) {
		   var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		   msg = msg.replace("$",lab);
		   msg = msg.replace("#",max);
		   messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+ msg
            return false;
        } else return true;
}

function validateNationalID(Nat_Id,nat_id_check_digit_id,validate_len_yn,nat_id_prompt)
{
var Nat_IdName = Nat_Id.name;
	var isNumber = new Boolean();
	isNumber = true;
    var ind = -1;

	if ( Nat_Id.value.length > 0 )
	{
		if ( (ind = Nat_Id.value.indexOf('X')) != -1)
		{
			if (ind < 12)           // X can be entered only at 13th position
			{
				msg = getMessage('INVALID_NAT_ID','MP');
				msg = msg.replace("#",nat_id_prompt);
				Nat_Id.focus();
				alert(msg);
				return false;
			}
		}
	}

	if ( isNumber )
	{
	   var nid = new String();
       nid = trimString(Nat_Id.value);
       Nat_Id.value = nid;

       if(validate_len_yn == "Y")
       if ( nid.length == Nat_Id.maxLength )   isNumber = true
       else
        {
            isNumber = false

        }

		if(isNumber && Nat_Id.value!='')
		{
          var NatIdFlag = "Y"; 
		 // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Reg'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
		// messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		// messageFrame.visit_form.submit();

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="callfunc=idChk&CalledFrom=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt+"&func_source="+frames[1].frames[0].document.forms[0].params.value
			var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var retVal=trimString(xmlHttp.responseText);
			
			if(retVal=='N')
			{
				 var msg = getMessage("INVALID_NAT_ID","MP");
				 msg = msg.replace('#',nat_id_prompt);
				alert(msg);
				return false;
			}
			else
				return true;

		}
		else
		{
		    
			if ( Nat_Id.value != '' )
			{
				var val = getMessage("NAT_ID_CHARS",'MP');
				val = val.replace("@",document.forms[0].nat_id_no.maxLength);
				val = val.replace("#",nat_id_prompt)
				alert(val)
				Nat_Id.focus();
			}
		}
	}


//var Nat_Id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_no ;
	//			var nat_id_check_digit_id=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_check_digit_id.value ;
		//		var validate_len_yn=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_chk_len.value ;
			//	var nat_id_prompt=f_query_add_mod.patientDetailsFrame.document.forms[0].nat_id_prompt.value ;

				//validateNationalID(nat_id_no,nat_id_check_digit_id,nat_id_chk_len,nat_id_prompt);
				


		/*	var Nat_IdName = Nat_Id.name;
			var isNumber = new Boolean();
			isNumber = true;
			var ind = -1;

			if ( Nat_Id.value.length > 0 )
			{
				if ( (ind = Nat_Id.value.indexOf('X')) != -1)
				{
					if (ind < 12)           // X can be entered only at 13th position
					{
						msg = getMessage('INVALID_NAT_ID','MP');
						msg = msg.replace("#",nat_id_prompt);
						Nat_Id.focus();
						alert(msg)
							top.content.frames[0].document.getElementById('apply').disabled = true;
							top.content.frames[0].document.getElementById('apply').disabled = false;
						return false;
					}
				}
			}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else
				{
					isNumber = false

				}

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 // var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Reg'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'><input type='hidden' name='func_source' id='func_source' value='"+frames[1].frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
					// messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					// messageFrame.visit_form.submit();
					var qryParam=parent.frames[0].document.forms[0].params.value
			

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=idChk&CalledFrom=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt+"&func_source="+encodeURIComponent(qryParam)
						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 
							 if(nat_id_prompt!=""||nat_id_prompt!='')
							{
							 msg = msg.replace('#',nat_id_prompt);
							}
							else
							{
							 msg = msg.replace('#',"nat_id_prompt");
							}
							document.forms[0].nat_id_no.focus();
						   document.forms[0].nat_id_no.value='';
							alert(msg);
							top.content.frames[0].document.getElementById('apply').disabled = true;
							top.content.frames[0].document.getElementById('apply').disabled = false;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",document.forms[0].nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								alert(val);
								Nat_Id.focus();
								top.content.frames[0].document.getElementById('apply').disabled = true;
								top.content.frames[0].document.getElementById('apply').disabled = false;
							}
						}
			}*/

}

function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForAlphaCharsNatID(event){

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

// code added for 20409

function CheckSplCharsNatID(Obj){
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
        var str = Obj.value;
        var specCharsExist = true;

		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
    }

async function searchPresentingProblem(obj,target){
                var locale         = document.forms[0].locale.value;
                var retVal         = new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";                              
				if(target.name=='presentingproblem_desc'){
					tit=getLabel("Common.PresentingProblem.label","common");
					
					/*Below line added for this CRF GDOH-CRF-0129*/
					 var isReferral      = document.forms[0].isReferral.value;
					 if(isReferral=="true")	tit=getLabel("Common.Referralfrom.label","Common");
	                //End this CRF GDOH-CRF-0129
					
					sql="select COMPLAINT_CODE code,COMPLAINT_DESC description from am_complaint  where   upper(COMPLAINT_CODE)like upper(?) and upper(COMPLAINT_DESC) like upper(?) and eff_status = 'E' order by 2";
				}
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal =await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                 {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					
					target.value=arr[1];
					if(target.name == 'presentingproblem_desc')
					{
						document.forms[0].presentingproblem_code.value= arr[0];
						document.forms[0].presentingproblem_desc.value= arr[1];	
						/*Below line added for this CRF GDOH-CRF-0129*/
						if(document.forms[0].isReferral && document.forms[0].isReferral.value=="true"){						
						  document.forms[0].assigncare_locacode.value=arr[0];
						  document.forms[0].assigncare_loctype_ind.value="P";						
						}
						//End this GDOH-CRF-0129
						
					}
			    }
			   else
		       {
				 target.value="";
				 return;
			   }
}


function OnSearch()
{
    if((document.forms[0].patient_id.value== "" ) && (document.forms[0].referal_id.value== "" ))
	{
	  var errors = '';
	  errors = errors + getMessage("SPECIFY_ANY_CRITERIA","Common"); 
      errors = errors.replace('$',getLabel("Common.patientId.label","Common"));
      errors = errors.replace('#',getLabel("Common.referralid.label","Common"));
      errors = errors + "\n" ;
	  alert(errors);

	}else if (document.forms[0].patient_id.value!='' && document.forms[0].referal_id.value=="")
	{  //above condtion added for this incident 52345
		changeCase(document.forms[0].patient_id);
		parent.parent.frames[0].document.getElementById('reset').disabled = false;
		searchPatient(document.forms[0].patient_id);

	}else if (document.forms[0].referal_id.value!='')
	{
		
		changeCase(document.forms[0].referal_id);
		parent.parent.frames[0].document.getElementById('reset').disabled = false;
		searchPatient(document.forms[0].referal_id);

	}

}

			
				 // Below code added for Scrum 10638
				
async function funPatRegCharges(patient_id)
{
	var patient_id =  patient_id;
		var retVal_BL =    new String();

		var center='1';
		var dialogTop = "30";
		var dialogHeight = "15vh" ;
		var dialogWidth = '45vw' ;
		var title='Pat Reg Charges'
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"step1=STEP_OTH&function_id=VISIT_REGISTRATION&"+"patient_id="+patient_id;	
		


		retVal_BL= await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDetValidationFrame.jsp?"+param,arguments,features);
		
			if ((retVal_BL == "N")  || (retVal_BL == undefined) ||  (retVal_BL == "undefined"))  
	{
		parent.frames[2].document.forms[0].ct_patient_id.value = "";
		parent.top.content.frames[0].location.reload();
		parent.top.content.frames[1].location.reload();
	}
}

//Added by Sangeetha for KDAH-CRF-0347 on 13/apr/17
function PanCardAvailCheck(obj,isPanCardAvailable){
	var patientId			= obj.value;
	if(isPanCardAvailable=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PanCardAvailCheck' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText;
	}
}

/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
function chkForm60OrPanCardAvail(obj,isForm60Available){
	var patientId			= obj.value;
	if(isForm60Available=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='chkForm60OrPanCardAvail' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText;
	}
}
/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/
/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
function beforeGetPractitioneratVisit(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value=='')
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 return;
			}
			
			aegetPractitioneratVisit(obj,target_name);
}
function aegetPractitioneratVisit(obj,target)
{
	target.value = trimString(target.value);
			 
	var	clinic_code		=	document.forms[0].location_code.value;
	var treatment_area_code=document.forms[0].treat_area.value;
	
	var speciality_code = document.forms[0].speciality_code.value;
	var locale=document.forms[0].locale.value;
	
	var open_to_all_practioners_of_clinic= "";
	var open_to_all_pract_of_treatment_area="";
	var practitioner_type = "";
	
    

	var facility_id			=	document.forms[0].facilityId.value;
	var method_name			="searchPrac"
	var sql					="SELECT a.open_to_all_prac_for_clinic_yn, b.OPEN_TO_ALL_PRACT_YN   FROM ae_tmt_area_for_clinic a,OP_CLINIC_lang_vw b  WHERE a.facility_id= '"+facility_id+"'   AND a.facility_id=b.facility_id    AND a.clinic_code=b.clinic_code    AND a.clinic_code='"+clinic_code+"'  AND a.treatment_area_code = '"+treatment_area_code+"' and b.LANGUAGE_ID='"+locale+"'"; 

	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH" ;
	xmlStr += " method_name=\"" + method_name + "\""	;
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eIP/jsp/IPintermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var retVal  = trimString(responseText);
	
	
	if(retVal !="")
	  {
		var arr1=retVal.split("$");
		var open_to_all_prac_for_clinic_yn=arr1[0];
		var open_to_all_pract_yn=arr1[1];
	  } 
	

	getPractitioner(obj, target, facility_id, speciality_code,practitioner_type,"Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
	
		
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{ 
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practitioner_desc.value=unescape(arr[1]);	
		document.forms[0].prev_pract_name.value=unescape(arr[1]);	
		
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].practitioner_desc.value="";	
		document.forms[0].prev_pract_name.value="";
		
	}

}
/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/

/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
function checktrauma() {
		if(document.forms[0].CaseofTrauma.checked==true)
		{
		   document.forms[0].CaseofTrauma_val.value='Y';
		   document.getElementById('mand4').style.visibility='visible';
		   remVal(document.forms[0].injury);
	    }
		else
		{
		  document.forms[0].CaseofTrauma_val.value='N';
		  document.getElementById('mand4').style.visibility='hidden';
		  //remVal(document.forms[0].mechan_injury);
		  remVal(document.forms[0].injury);
		}

	}
function setMechInj1(obj){
		 var injury = document.forms[0].injury;
		 while(document.forms[0].mechan_injury.options.length > 1)
		{
			document.forms[0].mechan_injury.remove(1);
		}
		 //var tarumaFlag = document.forms[0].CaseofTrauma.checked;//Commented by Thamizh selvi for ML-MMOH-CRF-0645
	
		 var mechaInjflagNew = "Y";
		 var oscc_yn	      = document.forms[0].oscc_yn.value;
		 
		var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form1' id='visit_form1' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='mechaInjflagNew' id='mechaInjflagNew' value='"+mechaInjflagNew+"'><input type='hidden' name='oscc_yn' id='oscc_yn' value='"+oscc_yn+"'><input type='hidden' name='called_function' id='called_function' value='REGISTER_ATTEN'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
		
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.visit_form1.submit();
		
}
function chkOsccValue(obj)
{
	remVal1(document.forms[0].injury);
     remVal1(document.forms[0].mechan_injury);
	 var injury = document.forms[0].injury;
     var mechan_injury = document.forms[0].mechan_injury;
	 var opt		=	document.createElement('OPTION'); 
		opt.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		opt.value	=	'';
	 mechan_injury.add(opt); 
	 var opt1		=	document.createElement('OPTION'); 
		opt1.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		opt1.value	=	'';
     injury.add(opt1);
 if (obj.checked == true)
  {
	  document.getElementById('mand5').style.visibility='visible';
	  document.forms[0].oscc_yn.value='Y';
	  if(document.forms[0].isMLCAppl.value == 'true'){
	  document.forms[0].mlc_case_yn.checked=true;
		  document.forms[0].mlc_case_yn.disabled=false;
		  document.forms[0].mlc_case_yn.value ='Y';
		  
		  document.getElementById('mlc_death').disabled = false;
		  document.getElementById('police_rep_no').disabled = false;
		  document.getElementById('police_stn_dtls').disabled = false;
		  document.getElementById('outside_mlc_dtls').disabled = false;
		  document.getElementById('date_of_mlc_capture').disabled = false;
		  document.getElementById('date_of_mlc_capture').value = getCurrentDate("DMYHMS","en");
		  document.getElementById('mlc_remarks').disabled = false;
			
			if(document.getElementById('brought_dead_yn').checked){
				document.getElementById('mlc_death').checked = true;
			}
	  }else{
		  document.forms[0].mlc_case_yn.checked=true;
	  document.forms[0].mlc_case_yn.disabled=true;
	  document.forms[0].mlc_case_yn.value ='Y';
	  }
	  
	}  
  else if (obj.checked == false)
  {
	  if(document.forms[0].isMLCAppl.value == 'true'){
		  document.forms[0].mlc_case_yn.checked=false;
		  document.forms[0].mlc_case_yn.disabled=false;
		  document.forms[0].mlc_case_yn.value ='N';
		  document.getElementById('mlc_death').disabled = true;
		  document.getElementById('mlc_death').checked = false;
		  document.getElementById('mlc_death').value = 'N';
		  document.getElementById('police_rep_no').disabled = true;
		  document.getElementById('police_rep_no').value = '';
		  document.getElementById('police_stn_dtls').disabled = true;
		  document.getElementById('police_stn_dtls').value = '';
		  document.getElementById('outside_mlc_dtls').disabled = true;
		  document.getElementById('outside_mlc_dtls').value = '';
		  document.getElementById('date_of_mlc_capture').disabled = true;
		  document.getElementById('date_of_mlc_capture').value = '';
		  document.getElementById('mlc_remarks').disabled = true;
		  document.getElementById('mlc_remarks').value = '';
	  }else{
	  document.getElementById('mand5').style.visibility="hidden";
	  document.forms[0].oscc_yn.value='N';
	  document.forms[0].mlc_case_yn.checked=false;
	  document.forms[0].mlc_case_yn.disabled=false;
      document.forms[0].mlc_case_yn.value ='N';
	  }
  }
} 
function setMechInj(){
	
	 var injury = document.forms[0].injury;
   	 
	 var mechaInjflagNew = "Y";
     var oscc_yn	     = document.forms[0].oscc_yn.value;

	 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='mechaInjflagNew' id='mechaInjflagNew' value='"+mechaInjflagNew+"'><input type='hidden' name='called_function' id='called_function' value='REGISTER_ATTEN'><input type='hidden' name='oscc_yn' id='oscc_yn' value='"+oscc_yn+"'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'></form></BODY></HTML>";
			
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.visit_form.submit();
			
}
function chkMedicalValue(obj)
{
 if (obj.checked == true)
  {
	  document.forms[0].medical_yn.checked=true;
	  document.forms[0].medical_yn.value='Y';
  }
  else if (obj.checked == false)
  {
	  document.forms[0].medical_yn.checked=false;
	  document.forms[0].medical_yn.value='N';
  }
}
function chkSurgValue(obj)
{
 if (obj.checked == true)
  {
	  document.forms[0].surgical_yn.checked=true;
	  document.forms[0].surgical_yn.value='Y';
  }
  else if (obj.checked == false)
  {
	  document.forms[0].surgical_yn.checked=false;
	  document.forms[0].surgical_yn.value='N';
  }
}
function setInjury(obj)
	{
		
	if(obj.value!='')
	     { 
			 patient_id		      = document.forms[0].patient_id.value;
			 var category	      = document.forms[0].mechan_injury.value;
			 var mech_injr_subcat_code   ='';
			 if(document.forms[0].injury.length >= 1)
				remVal(document.forms[0].injury);
			 if(document.forms[0].mech_sub_code!=null)
			 var mech_sub_code	  = document.forms[0].mech_sub_code.value;
			 var mechaInjflag = "Y";
            

			 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='category' id='category' value='"+category+"'><input type='hidden' name='mech_sub_code' id='mech_sub_code' value='"+mech_sub_code+"'><input type='hidden' name='mechaInjflag' id='mechaInjflag' value='"+mechaInjflag+"'><input type='hidden' name='mech_injr_subcat_code' id='mech_injr_subcat_code' value='"+mech_injr_subcat_code+"'><input type='hidden' name='called_function' id='called_function' value='REGISTER_ATTEN'><input type='hidden' name='func_source' id='func_source' value='"+parent.frames[0].document.forms[0].params.value+"'>	</form></BODY></HTML>";
			 
			 parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			 parent.parent.messageFrame.visit_form.submit();
						
		 }
		else
		{
		 	 document.forms[0].mechan_injury.value	= '';
			 remVal(document.forms[0].injury);
		}
}
/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

/*Below line added for this CRF ML-MMOH-CRF-0629*/
async function priorityZoneRed()
{        
	
  if(document.forms[0].priorityR&&document.forms[0].priorityR.checked){ 
		var retVal	= new String();
		var dialogHeight= "15vh";
		var dialogWidth = "25vw";
		var dialogTop	= "200";
		var center = "1" ;
		var status="no";
		var arguments	= "" ;

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ;  status:" + status  + "; dialogTop :" + dialogTop ;
		var callurl="../../eAE/jsp/AEPriorityZoneRedFrameSet.jsp";
		retVal =await window.showModalDialog(callurl,arguments,features);	
       
       	if(retVal=="Yes"){
		 document.forms[0].priorityZone.value="Y"; 
		}else{
		 document.forms[0].priorityZone.value="N";  
		}
    }else{
	     document.forms[0].priorityZone.value="N";  
	}
	}
/*End this CRF ML-MMOH-CRF-0629*/

//Added by Ashwini on 17-Aug-2017 for GDOH-CRF-0161
function placeOfAccidentMandatory() {
		if(document.forms[0].mv_accident_yn.checked==true)
		{
		   document.getElementById('poa_mand').style.visibility='visible';
	    }
		else
		{
		   document.getElementById('poa_mand').style.visibility='hidden';
		}

	}

/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
async function showFollowUpEncounters(pat_id)
{
	var retVal			= new String();
    var dialogHeight	= "22vh" ;
    var dialogWidth		= "40vw" ;
	var arguments		= "" ;
    params				= "pat_id="+pat_id ;
    var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";scroll=auto; status=no" ;
         
    retVal =await window.showModalDialog("../../eAE/jsp/FollowUpEncounters.jsp?"+params,arguments,features);

	if (retVal == null || retVal == 'undefined')
	{
		retVal = "";
	}
	return retVal;
}

function followUpCount(pat_id)
{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH pat_id=\""+pat_id+"\" action='validateFollowUp' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/AEIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var followUpCountYN	= trimString(responseText);
	return followUpCountYN;
}

function linkFollowUpEncounters(patient_id)
{
	var enconterId = showFollowUpEncounters(patient_id);
	if(!(enconterId == "" || enconterId == null))
	{
		document.forms[0].followup_enc.value = enconterId;
		document.forms[0].followup_enc_remove.style.visibility='visible';
	}
}

function delinkFollowUpEncounters()
{
	document.forms[0].followup_enc.value = "";
	document.forms[0].followup_enc_remove.style.visibility='hidden';
}
/*End ML-MMOH-CRF-0657*/

/*Added by Thamizh selvi on 20th Mar 2018 against ML-MMOH-CRF-0645 Start*/
function caseDetailsOnChange(obj){
	
	var caseDtl = obj.id;
	document.getElementById('mand4').style.visibility='hidden';
	if(caseDtl == "trauma"){
		
		document.forms[0].CaseofTrauma_val.value='Y';
		document.getElementById('mand4').style.visibility='visible';
		document.getElementById('mand5').style.visibility='visible';
		document.getElementById('placeOfOccurImg').style.visibility='visible';
		document.getElementById('dateOfOccurImg').style.visibility='visible';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].osccType.value = '';

		setMechInj1(obj);
		remVal(document.forms[0].mechan_injury);
		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		document.getElementById("placeOfOccFieldsDisplay").style.display		= "block";
		document.getElementById("MechInjFieldsDisplay").style.display			= "block";

		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.value="N";
		document.forms[0].mlc_case_yn.disabled=false;
}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.value="N";
			document.getElementById('mlc_death').disabled = true;
			document.getElementById('police_rep_no').disabled = true;
			document.getElementById('police_stn_dtls').disabled = true;
			document.getElementById('outside_mlc_dtls').disabled = true;
			document.getElementById('date_of_mlc_capture').disabled = true;
			document.getElementById('date_of_mlc_capture').value = "";
			document.getElementById('mlc_remarks').disabled = true;	
		}
	
	}else if(caseDtl == "oscc"){
		
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=true;
		document.forms[0].mlc_case_yn.value="Y";
		document.forms[0].mlc_case_yn.disabled=true;
		document.forms[0].oscc_yn.value='Y';
}else{
			document.forms[0].oscc_yn.value='Y';
			document.forms[0].mlc_case_yn.checked=true;
			document.forms[0].mlc_case_yn.value="Y";
			document.forms[0].mlc_case_yn.disabled=false;
			document.forms[0].mlc_death.disabled = false;
			document.forms[0].police_rep_no.disabled = false;
			document.forms[0].police_stn_dtls.disabled = false;
			document.forms[0].outside_mlc_dtls.disabled = false;
			document.forms[0].date_of_mlc_capture.disabled = false;
			document.forms[0].date_of_mlc_capture.value = getCurrentDate("DMYHMS","en");
			document.forms[0].mlc_remarks.disabled = false;
			
			if(document.forms[0].brought_dead_yn.checked){
				document.forms[0].mlc_death.checked = true;
			}
		}
		
		document.forms[0].CaseofTrauma_val.value='N';
		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		remVal(document.forms[0].injury);
  	    document.forms[0].medical_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';

		document.getElementById("osccTypeLabel").style.visibility					= "visible";
		document.forms[0].osccType.style.visibility									= "visible";
		document.forms[0].osccTypeMandImg.style.visibility							= "visible";
		document.getElementById("placeOfOccFieldsDisplay").style.display			= "none";
		document.getElementById("MechInjFieldsDisplay").style.display				= "none";
		
		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
		
	}else if(caseDtl == "medical"){
		
		document.forms[0].medical_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		remVal(document.forms[0].injury);
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';

		document.getElementById('mand5').style.visibility="hidden";
		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.value="N";
		document.forms[0].mlc_case_yn.disabled=false;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.value="N";
			document.getElementById('mlc_death').disabled = true;
			document.getElementById('police_rep_no').disabled = true;
			document.getElementById('police_stn_dtls').disabled = true;
			document.getElementById('outside_mlc_dtls').disabled = true;
			document.getElementById('date_of_mlc_capture').disabled = true;
			document.getElementById('date_of_mlc_capture').value = "";
			document.getElementById('mlc_remarks').disabled = true;	
		}

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		document.getElementById("placeOfOccFieldsDisplay").style.display		= "none";
		document.getElementById("MechInjFieldsDisplay").style.display			= "none";
	
		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";

	}else if(caseDtl == "surgical"){
		
		document.forms[0].surgical_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		remVal(document.forms[0].injury);
		document.forms[0].medical_yn.value='N';
		document.forms[0].OandG_yn.value='N';

		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		//Added for GHL-CRF-0650
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.value="N";
		document.forms[0].mlc_case_yn.disabled=false;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.value="N";
			document.getElementById('mlc_death').disabled = true;
			document.getElementById('police_rep_no').disabled = true;
			document.getElementById('police_stn_dtls').disabled = true;
			document.getElementById('outside_mlc_dtls').disabled = true;
			document.getElementById('date_of_mlc_capture').disabled = true;
			document.getElementById('date_of_mlc_capture').value = "";
			document.getElementById('mlc_remarks').disabled = true;	
		}

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility							= "hidden";
		document.getElementById("placeOfOccFieldsDisplay").style.display			= "none";
		document.getElementById("MechInjFieldsDisplay").style.display				= "none";

		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}else if(caseDtl == "OandG"){
		
		document.forms[0].OandG_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		remVal(document.forms[0].injury);
		document.forms[0].surgical_yn.value='N';
		document.forms[0].medical_yn.value='N';

		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		//Added for GHL-CRF-0650
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.value="N";
		document.forms[0].mlc_case_yn.disabled=false;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.value="N";
			document.getElementById('mlc_death').disabled = true;
			document.getElementById('police_rep_no').disabled = true;
			document.getElementById('police_stn_dtls').disabled = true;
			document.getElementById('outside_mlc_dtls').disabled = true;
			document.getElementById('date_of_mlc_capture').disabled = true;
			document.getElementById('date_of_mlc_capture').value = "";
			document.getElementById('mlc_remarks').disabled = true;	
		}

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		document.getElementById("placeOfOccFieldsDisplay").style.display		= "none";
		document.getElementById("MechInjFieldsDisplay").style.display			= "none";

		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}
}
/*End*/
//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
function copyDetails(Val) { 
	
	//Below Added on 24/07/2020 for populating values from Related contacts,Next of kin(Residence) to Related contacts,Next of kin(Mailing)---->(Copy Residence Address)
	if(Val == 1)
    {
        if(document.getElementById('n_next_addr_line1') != null)
		    document.getElementById('n_next_addr_line1').value = document.getElementById('next_addr_line1').value;

		if(document.getElementById('n_ma_addr_line2') != null)
		    document.getElementById('n_ma_addr_line2').value = document.getElementById('next_addr_line2').value;

		if(document.getElementById('n_ma_addr_line3') != null)
		    document.getElementById('n_ma_addr_line3').value = document.getElementById('next_addr_line3').value;

		if(document.getElementById('n_ma_addr_line4') != null)
		    document.getElementById('n_ma_addr_line4').value = document.getElementById('next_addr_line4').value;

		 if(document.forms[0].n_ma_addr_line2 != null)
		    document.forms[0].n_ma_addr_line2.value = document.forms[0].next_addr_line2.value;

		 if(document.forms[0].n_ma_addr_line3 != null)
		    document.forms[0].n_ma_addr_line3.value = document.forms[0].next_addr_line3.value;

		 if(document.forms[0].n_ma_addr_line4 != null)
			document.forms[0].n_ma_addr_line4.value = document.forms[0].next_addr_line4.value;
		


		if(document.getElementById('n_contact_ma_town_code') != null)
		    document.getElementById('n_contact_ma_town_code').value = document.getElementById('contact1_res_town_code').value;

		if(document.getElementById('nkma_town') != null)
            document.getElementById('nkma_town').value = document.getElementById('n_town').value;

		if(document.getElementById('n_contac_region_code') != null)
		    document.getElementById('n_contac_region_code').value = document.getElementById('contact1_region_code').value;

		if(document.getElementById('contact1_region') != null)
            document.getElementById('contact1_region').value = document.getElementById('n_region').value;

		if(document.getElementById('n_contact_ma_area_code') != null)
		    document.getElementById('n_contact_ma_area_code').value = document.getElementById('contact1_res_area_code').value;

		if(document.getElementById('nkma_area') != null)
            document.getElementById('nkma_area').value = document.getElementById('n_area').value;

		if(document.getElementById('n_ma_postal_code') != null)
		    document.getElementById('n_ma_postal_code').value = document.getElementById('next_postal_code').value;

		if(document.getElementById('n_ma_postal_code1') != null)
	        document.getElementById('n_ma_postal_code1').value = document.getElementById('next_postal_code1').value;
		
		if(document.getElementById('nkin_mail_country_code') != null)
		    document.getElementById('nkin_mail_country_code').value = document.getElementById('next_country_code').value;
		
		if(document.getElementById('nk_ma_country_desc') != null)
			document.getElementById('nk_ma_country_desc').value = document.getElementById('next_country_desc').value;
     
	    if(document.getElementById('ma_contact_name') != null)
		   document.getElementById('ma_contact_name').value = document.getElementById('ra_contact_name').value;

	}
	//Ended for populating values from Related contacts(Residence) to Related contacts(Mailing)---->(Copy Residence Address)
	//Below Added on 24/07/2020 for populating values from First To Notify(Residence & Mailing) to Next of kin fields---->(Copy First To Notify)
	if(Val == 2)
	{
       /* if(document.getElementById("next_addr_line1") != null)
		    document.getElementById("next_addr_line1").value = document.getElementById("first_addr_line1").value;

		 if(document.getElementById("next_addr_line2") != null)
		    document.getElementById("next_addr_line2").value = document.getElementById("first_addr_line2").value;

		 if(document.getElementById("next_addr_line3") != null)
		    document.getElementById("next_addr_line3").value = document.getElementById("first_addr_line3").value;

		 if(document.getElementById("next_addr_line4") != null)
		    document.getElementById("next_addr_line4").value = document.getElementById("first_addr_line4").value;*/
		 if(document.forms[0].next_addr_line1 != null)
			document.forms[0].next_addr_line1.value = document.forms[0].first_addr_line1.value;
		
		if(document.forms[0].next_addr_line2 != null)
			document.forms[0].next_addr_line2.value = document.forms[0].first_addr_line2.value;
		
		if(document.forms[0].next_addr_line3 != null)
			document.forms[0].next_addr_line3.value = document.forms[0].first_addr_line3.value;
		
		if(document.forms[0].next_addr_line4 != null)
			document.forms[0].next_addr_line4.value = document.forms[0].first_addr_line4.value;
		
        
		 if(document.getElementById("contact1_res_town_code") != null)
		    document.getElementById("contact1_res_town_code").value = document.getElementById("contact2_res_town_code").value;

		 if(document.getElementById("n_town") != null)
            document.getElementById("n_town").value = document.getElementById("f_town").value;

		 if(document.getElementById("contact1_region_code") != null)
		    document.getElementById("contact1_region_code").value = document.getElementById("contact2_region_code").value;

		 if(document.getElementById("n_region") != null)
            document.getElementById("n_region").value = document.getElementById("f_region").value;

		 if(document.getElementById("contact1_res_area_code") != null)
		    document.getElementById("contact1_res_area_code").value = document.getElementById("contact2_res_area_code").value;

		 if(document.getElementById("n_area") != null)
            document.getElementById("n_area").value = document.getElementById("f_area").value;

		 if(document.getElementById("next_postal_code") != null)
		    document.getElementById("next_postal_code").value = document.getElementById("first_postal_code").value; 

		 if(document.getElementById("next_postal_code1") != null)
			document.getElementById("next_postal_code1").value = document.getElementById("first_postal_code1").value;

		if(document.getElementById("next_country_code") != null)
		    document.getElementById("next_country_code").value = document.getElementById("first_country_code").value;
		
		if(document.getElementById("next_country_desc") != null)
			document.getElementById("next_country_desc").value = document.getElementById("first_country_desc").value;

		if(document.getElementById("ra_contact_name") != null)
		   document.getElementById("ra_contact_name").value = document.getElementById("fton_ra_contact_name").value;


		/*if(document.getElementById("n_next_addr_line1") != null)
		    document.getElementById("n_next_addr_line1").value = document.getElementById("fton_mail_addr_line1").value;

		 if(document.getElementById("n_ma_addr_line2") != null)
		    document.getElementById("n_ma_addr_line2").value = document.getElementById("fton_mail_addr_line2").value;

		 if(document.getElementById("n_ma_addr_line3") != null)
		    document.getElementById("n_ma_addr_line3").value = document.getElementById("fton_mail_addr_line3").value;
		 
		 if(document.getElementById("n_ma_addr_line4") != null)
		    document.getElementById("n_ma_addr_line4").value = document.getElementById("fton_mail_addr_line4").value;
		 */
		
		if(document.forms[0].n_next_addr_line1 != null)
		    document.forms[0].n_next_addr_line1.value = document.forms[0].fton_mail_addr_line1.value;

		 if(document.forms[0].n_ma_addr_line2 != null)
		    document.forms[0].n_ma_addr_line2.value = document.forms[0].fton_mail_addr_line2.value;

		 if(document.forms[0].n_ma_addr_line3 != null)
		    document.forms[0].n_ma_addr_line3.value = document.forms[0].fton_mail_addr_line3.value;

		 if(document.forms[0].n_ma_addr_line4 != null)
			document.forms[0].n_ma_addr_line4.value = document.forms[0].fton_mail_addr_line4.value;
        
		 if(document.getElementById("n_contact_ma_town_code") != null)
		    document.getElementById("n_contact_ma_town_code").value = document.getElementById("fst_to_no_ma_town_code").value;

		 if(document.getElementById("nkma_town") != null)
            document.getElementById("nkma_town").value = document.getElementById("contact2_res_town").value;

		 if(document.getElementById("n_contac_region_code") != null)
		    document.getElementById("n_contac_region_code").value = document.getElementById("fst_to_no_ma_reg_cod").value;

		 if(document.getElementById("contact1_region") != null)
            document.getElementById("contact1_region").value = document.getElementById("contact2_region").value;

		 if(document.getElementById("n_contact_ma_area_code") != null)
		    document.getElementById("n_contact_ma_area_code").value = document.getElementById("fst_to_no_ma_area_code").value;

		  if(document.getElementById("nkma_area") != null)
            document.getElementById("nkma_area").value = document.getElementById("contact2_res_area").value;

		 if(document.getElementById("n_ma_postal_code") != null)
		    document.getElementById("n_ma_postal_code").value = document.getElementById("fst_no_ma_pos_cod").value;

		 if(document.getElementById("n_ma_postal_code1") != null)
		    document.getElementById("n_ma_postal_code1").value = document.getElementById("fst_no_ma_pos_cod1").value;

		if(document.getElementById("nkin_mail_country_code") != null)
		    document.getElementById("nkin_mail_country_code").value = document.getElementById("first_mail_country_code").value;
		
		if(document.getElementById("nk_ma_country_desc") != null)
			document.getElementById("nk_ma_country_desc").value = document.getElementById("first_mail_country_desc").value;
     
	    if(document.getElementById("ma_contact_name") != null)
		   document.getElementById("ma_contact_name").value = document.getElementById("fton_ma_contact_name").value;
	}
	//Ended for populating values from First To Notify(Residence & Mailing) to Next of kin fields---->(Copy First To Notify)
	//Below Added on 24/07/2020 for populating values from Related contacts,First To Notify(Residence) to Related contacts,First To Notify(Mailing)---->(Copy Residence Address)
	if(Val == 3)
    {
        /*if(document.getElementById("fton_mail_addr_line1") != null)
		    document.getElementById("fton_mail_addr_line1").value = document.getElementById("first_addr_line1").value;

		if(document.getElementById("fton_mail_addr_line2") != null)
		    document.getElementById("fton_mail_addr_line2").value = document.getElementById("first_addr_line2").value;

		if(document.getElementById("fton_mail_addr_line3") != null)
		    document.getElementById("fton_mail_addr_line3").value = document.getElementById("first_addr_line3").value;

		if(document.getElementById("fton_mail_addr_line4") != null)
		    document.getElementById("fton_mail_addr_line4").value = document.getElementById("first_addr_line4").value;*/
		if(document.forms[0].fton_mail_addr_line1 != null)
			document.forms[0].fton_mail_addr_line1.value = document.forms[0].first_addr_line1.value;
		
		if(document.forms[0].fton_mail_addr_line2 != null)
			document.forms[0].fton_mail_addr_line2.value = document.forms[0].first_addr_line2.value;
		
		if(document.forms[0].fton_mail_addr_line3 != null)
			document.forms[0].fton_mail_addr_line3.value = document.forms[0].first_addr_line3.value;
		
		if(document.forms[0].fton_mail_addr_line4 != null)
			document.forms[0].fton_mail_addr_line4.value = document.forms[0].first_addr_line4.value;
		

		if(document.getElementById("fst_to_no_ma_town_code") != null)
		    document.getElementById("fst_to_no_ma_town_code").value = document.getElementById("contact2_res_town_code").value;

		if(document.getElementById("contact2_res_town") != null)
            document.getElementById("contact2_res_town").value = document.getElementById("f_town").value;

		if(document.getElementById("fst_to_no_ma_reg_cod") != null)
		    document.getElementById("fst_to_no_ma_reg_cod").value = document.getElementById("contact2_region_code").value;

		if(document.getElementById("contact2_region") != null)
            document.getElementById("contact2_region").value = document.getElementById("f_region").value;

		if(document.getElementById("fst_to_no_ma_area_code") != null)
		    document.getElementById("fst_to_no_ma_area_code").value = document.getElementById("contact2_res_area_code").value;

		if(document.getElementById("contact2_res_area") != null)
            document.getElementById("contact2_res_area").value = document.getElementById("f_area").value;

		if(document.getElementById("fst_no_ma_pos_cod") != null)
		    document.getElementById("fst_no_ma_pos_cod").value = document.getElementById("first_postal_code").value;

		if(document.getElementById("fst_no_ma_pos_cod1") != null)
	        document.getElementById("fst_no_ma_pos_cod1").value = document.getElementById("first_postal_code1").value;
		
		if(document.getElementById("first_mail_country_code") != null)
		    document.getElementById("first_mail_country_code").value = document.getElementById("first_country_code").value;
		
		if(document.getElementById("first_mail_country_desc") != null)
			document.getElementById("first_mail_country_desc").value = document.getElementById("first_country_desc").value;
     
	    if(document.getElementById("fton_ma_contact_name") != null)
		   document.getElementById("fton_ma_contact_name").value = document.getElementById("fton_ra_contact_name").value;

	}
	//Ended for populating values from Related contacts(Residence) to Related contacts(Mailing)---->(Copy Residence Address)
	//Below Added on 24/07/2020 for populating values from Next of kin(Residence & Mailing) to First To Notify fields---->(Copy Next of Kin)
	if(Val == 4)
	{
       /* if(document.getElementById("first_addr_line1") != null)
		    document.getElementById("first_addr_line1").value = document.getElementById("next_addr_line1").value;

		 if(document.getElementById("first_addr_line2") != null)
		    document.getElementById("first_addr_line2").value = document.getElementById("next_addr_line2").value;

		 if(document.getElementById("first_addr_line3") != null)
		    document.getElementById("first_addr_line3").value = document.getElementById("next_addr_line3").value;

		 if(document.getElementById("first_addr_line4") != null)
		    document.getElementById("first_addr_line4").value = document.getElementById("next_addr_line4").value;*/
		 if(document.forms[0].first_addr_line1 != null)
			document.forms[0].first_addr_line1.value = document.forms[0].next_addr_line1.value;
		
		if(document.forms[0].first_addr_line2 != null)
			document.forms[0].first_addr_line2.value = document.forms[0].next_addr_line2.value;
		
		if(document.forms[0].first_addr_line3 != null)
			document.forms[0].first_addr_line3.value = document.forms[0].next_addr_line3.value;
		
		if(document.forms[0].first_addr_line4 != null)
			document.forms[0].first_addr_line4.value = document.forms[0].next_addr_line4.value;
		
        
		 if(document.getElementById("contact2_res_town_code") != null)
		    document.getElementById("contact2_res_town_code").value = document.getElementById("contact1_res_town_code").value;

		 if(document.getElementById("f_town") != null)
            document.getElementById("f_town").value = document.getElementById("n_town").value;

		 if(document.getElementById("contact2_region_code") != null)
		    document.getElementById("contact2_region_code").value = document.getElementById("contact1_region_code").value;

		  if(document.getElementById("f_region") != null)
            document.getElementById("f_region").value = document.getElementById("n_region").value;

		 if(document.getElementById("contact2_res_area_code") != null)
		    document.getElementById("contact2_res_area_code").value = document.getElementById("contact1_res_area_code").value;

		  if(document.getElementById("f_area") != null)
            document.getElementById("f_area").value = document.getElementById("n_area").value;

		 if(document.getElementById("first_postal_code") != null)
		    document.getElementById("first_postal_code").value = document.getElementById("next_postal_code").value;

		 if(document.getElementById("first_postal_code1") != null)
		    document.getElementById("first_postal_code1").value = document.getElementById("next_postal_code1").value;
		
		if(document.getElementById("first_country_code") != null)
		    document.getElementById("first_country_code").value = document.getElementById("next_country_code").value;
		
		if(document.getElementById("first_country_desc") != null)
			document.getElementById("first_country_desc").value = document.getElementById("next_country_desc").value;

		if(document.getElementById("fton_ra_contact_name") != null)
		   document.getElementById("fton_ra_contact_name").value = document.getElementById("ra_contact_name").value;


        /* if(document.getElementById("fton_mail_addr_line1") != null)
		    document.getElementById("fton_mail_addr_line1").value = document.getElementById("n_next_addr_line1").value;

		 if(document.getElementById("fton_mail_addr_line2") != null)
		    document.getElementById("fton_mail_addr_line2").value = document.getElementById("n_ma_addr_line2").value;

		 if(document.getElementById("fton_mail_addr_line3") != null)
		    document.getElementById("fton_mail_addr_line3").value = document.getElementById("n_ma_addr_line3").value;

		 if(document.getElementById("fton_mail_addr_line4") != null)
		    document.getElementById("fton_mail_addr_line4").value = document.getElementById("n_ma_addr_line4").value;*/

        
		 if(document.getElementById("fst_to_no_ma_town_code") != null)
		    document.getElementById("fst_to_no_ma_town_code").value = document.getElementById("n_contact_ma_town_code").value;

		 if(document.getElementById("contact2_res_town") != null)
            document.getElementById("contact2_res_town").value = document.getElementById("nkma_town").value;

		 if(document.getElementById("fst_to_no_ma_reg_cod") != null)
		    document.getElementById("fst_to_no_ma_reg_cod").value = document.getElementById("n_contac_region_code").value;

		  if(document.getElementById("contact2_region") != null)
            document.getElementById("contact2_region").value = document.getElementById("contact1_region").value;

		 if(document.getElementById("fst_to_no_ma_area_code") != null)
		    document.getElementById("fst_to_no_ma_area_code").value = document.getElementById("n_contact_ma_area_code").value;

		 if(document.getElementById("contact2_res_area") != null)
            document.getElementById("contact2_res_area").value = document.getElementById("nkma_area").value;

		 if(document.getElementById("fst_no_ma_pos_cod") != null)
		    document.getElementById("fst_no_ma_pos_cod").value = document.getElementById("n_ma_postal_code").value;

		 if(document.getElementById("fst_no_ma_pos_cod1") != null)
		    document.getElementById("fst_no_ma_pos_cod1").value = document.getElementById("n_ma_postal_code1").value;
		
		if(document.getElementById("first_mail_country_code") != null)
		    document.getElementById("first_mail_country_code").value = document.getElementById("nkin_mail_country_code").value;
		
		if(document.getElementById("first_mail_country_desc") != null)
			document.getElementById("first_mail_country_desc").value = document.getElementById("nk_ma_country_desc").value;
     
	    if(document.getElementById("fton_ma_contact_name") != null)
		   document.getElementById("fton_ma_contact_name").value = document.getElementById("ma_contact_name").value;
	}
	//Ended for populating values from Next of kin(Residence & Mailing) to First To Notify fields---->(Copy Next of Kin)
}

function enableContactNo(obj)   {
	if ( obj == document.getElementById('nk_contact3_mode') )
    {
   		document.getElementById('nk_contact3_no').value = "";
		if ( document.getElementById('nk_contact3_mode').value != '' )
        {    
		document.getElementById('nk_contact3_no').disabled = false;
		document.getElementById('nk_contact3_no').focus();
		}
        if ( document.getElementById('nk_contact3_mode').value == '')
        {
           	document.getElementById('nk_contact3_no').disabled = true;
            document.getElementById('nk_contact3_no').value = ''
			document.getElementById('nk_contact4_mode').focus();
	   }
    }

	if(obj == document.getElementById('nk_contact4_mode'))
    {
		document.getElementById('nk_contact4_no').value = "";
		if(document.getElementById('nk_contact4_mode').value != '')
		{ 
		   document.getElementById('nk_contact4_no').disabled = false;
		    document.getElementById('nk_contact4_no').focus();
		}
        else if(document.getElementById('nk_contact4_mode').value == '')
        {
			document.getElementById('nk_contact4_no').disabled = true;
			document.getElementById('nk_contact4_no').value = ''
			document.getElementById('nk_contact5_mode').focus();
        }
    }

	 if(obj == document.getElementById('nk_contact5_mode'))
    {
		document.getElementById('nk_contact5_no').value = "";
		if(document.getElementById('nk_contact5_mode').value != '')
		{
            document.getElementById('nk_contact5_no').disabled = false;
			document.getElementById('nk_contact5_no').focus();
		}
        else if(document.getElementById('nk_contact5_mode').value == '')
        {
            document.getElementById('nk_contact5_no').disabled = true;
            document.getElementById('nk_contact5_no').value = '';
        }
    }

	if ( obj == document.getElementById('fton_contact3_mode') )
    {
   		document.getElementById('fton_contact3_no').value = "";
		if ( document.getElementById('fton_contact3_mode').value != '' )
        {    
		document.getElementById('fton_contact3_no').disabled = false;
		document.getElementById('fton_contact3_no').focus();
		}
        if ( document.getElementById('fton_contact3_mode').value == '')
        {
           	document.getElementById('fton_contact3_no').disabled = true;
            document.getElementById('fton_contact3_no').value = ''
			document.getElementById('fton_contact4_mode').focus();
	   }
    }

	if(obj == document.getElementById('fton_contact4_mode'))
    {
		document.getElementById('fton_contact4_no').value = "";
		if(document.getElementById('fton_contact4_mode').value != '')
		{ 
		   document.getElementById('fton_contact4_no').disabled = false;
		    document.getElementById('fton_contact4_no').focus();
		}
        else if(document.getElementById('fton_contact4_mode').value == '')
        {
			document.getElementById('fton_contact4_no').disabled = true;
			document.getElementById('fton_contact4_no').value = ''
			document.getElementById('fton_contact5_mode').focus();
        }
    }

	 if(obj == document.getElementById('fton_contact5_mode'))
    {
		document.getElementById('fton_contact5_no').value = "";
		if(document.getElementById('fton_contact5_mode').value != '')
		{
            document.getElementById('fton_contact5_no').disabled = false;
			document.getElementById('fton_contact5_no').focus();
		}
        else if(document.getElementById('fton_contact5_mode').value == '')
        {
            document.getElementById('fton_contact5_no').disabled = true;
            document.getElementById('fton_contact5_no').value = '';
        }
    }
}

//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008

/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
function showReconfCot()
{
	var retVal;
	var cot_yn = confirm(getMessage("CASE_OF_TRAUMA_YN","AE"));

	if (cot_yn == true) {
	retVal = "Y";
	} else {
	retVal = "N";
	}
	
	if(retVal == "Y")
	{
		if(f_query_add_mod.patientDetailsFrame.document.getElementById("trauma"))
		{
			f_query_add_mod.patientDetailsFrame.document.getElementById("trauma").checked = true;
			checkCaseOfTraumaButton(f_query_add_mod.patientDetailsFrame.document.getElementById("trauma"));
		}
		else if(f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma)
		{
			f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma.checked = true;
			checkCaseOfTrauma();
		}
	}
}

function checkCaseOfTrauma() {
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma.checked==true)
	{
	   f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma_val.value='Y';
	   f_query_add_mod.patientDetailsFrame.document.forms[0].mand4.style.visibility='visible';
	   remVal(f_query_add_mod.patientDetailsFrame.document.forms[0].injury);
	}
	else
	{
	  f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma_val.value='N';
	  f_query_add_mod.patientDetailsFrame.document.forms[0].mand4.style.visibility='hidden';
	  remVal(f_query_add_mod.patientDetailsFrame.document.forms[0].injury);
	}
}

function checkCaseOfTraumaButton(obj){
	var caseDtl = obj.id;
	f_query_add_mod.patientDetailsFrame.document.forms[0].mand4.style.visibility='hidden';
	if(caseDtl == "trauma"){
		f_query_add_mod.patientDetailsFrame.document.forms[0].CaseofTrauma_val.value='Y';
		f_query_add_mod.patientDetailsFrame.document.forms[0].mand4.style.visibility='visible';
		f_query_add_mod.patientDetailsFrame.document.forms[0].mand5.style.visibility='visible';
		f_query_add_mod.patientDetailsFrame.document.forms[0].placeOfOccurImg.style.visibility='visible';
		f_query_add_mod.patientDetailsFrame.document.forms[0].dateOfOccurImg.style.visibility='visible';
		f_query_add_mod.patientDetailsFrame.document.forms[0].oscc_yn.value='N';
		f_query_add_mod.patientDetailsFrame.document.forms[0].medical_yn.value='N';
		f_query_add_mod.patientDetailsFrame.document.forms[0].surgical_yn.value='N';
		f_query_add_mod.patientDetailsFrame.document.forms[0].OandG_yn.value='N';
		f_query_add_mod.patientDetailsFrame.document.forms[0].osccType.value = '';
		f_query_add_mod.patientDetailsFrame.document.getElementById("osccTypeLabel").style.visibility = "hidden";
		f_query_add_mod.patientDetailsFrame.document.forms[0].osccType.style.visibility	= "hidden";
		f_query_add_mod.patientDetailsFrame.document.forms[0].osccTypeMandImg.style.visibility = "hidden";
		f_query_add_mod.patientDetailsFrame.document.getElementById("placeOfOccFieldsDisplay").style.display = "block";
		f_query_add_mod.patientDetailsFrame.document.getElementById("MechInjFieldsDisplay").style.display = "block";
		f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.checked=false;
		f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.value="N";
		f_query_add_mod.patientDetailsFrame.document.forms[0].mlc_case_yn.disabled=false;
	}
}
/*End ML-MMOH-CRF-1409*/
/* START GHL-CRF-0650 */
function enableOthMlcFlds(obj){
	if(obj.checked){
	obj.value = 'Y';

	document.getElementById('mlc_death').disabled = false;
	document.getElementById('police_rep_no').disabled = false;
	document.getElementById('police_stn_dtls').disabled = false;
	document.getElementById('outside_mlc_dtls').disabled = false;
	document.getElementById('date_of_mlc_capture').disabled = false;
	document.getElementById('date_of_mlc_capture').value = getCurrentDate("DMYHMS","en");
	document.getElementById('mlc_remarks').disabled = false;
	
	if(document.getElementById('brought_dead_yn').checked){
		document.getElementById('mlc_death').checked = true;
		document.getElementById('mlc_death').value = 'Y';
	}
	
	}else{
		obj.value = 'N';
		document.getElementById('mlc_death').disabled = true;
		document.getElementById('mlc_death').value = 'N';
		document.getElementById('mlc_death').checked = false;
		
		document.getElementById('police_rep_no').disabled = true;
		document.getElementById('police_rep_no').value = '';
		document.getElementById('police_stn_dtls').disabled = true;
		document.getElementById('police_stn_dtls').value = '';
		document.getElementById('outside_mlc_dtls').disabled = true;
		document.getElementById('outside_mlc_dtls').value = '';
		document.getElementById('date_of_mlc_capture').disabled = true;
		document.getElementById('date_of_mlc_capture').value = '';
		document.getElementById('mlc_remarks').disabled = true;	
		document.getElementById('mlc_remarks').value = '';	
	}
}

function validateMlcCapture(obj){
	var fromDate = document.getElementById('visit_date_time').value;
	var toDate = getCurrentDate("DMYHMS","en");
	if(obj.value!=''){
		if(!isBetween(fromDate, toDate, obj.value, "DMYHMS", "en")){
			obj.value = "";
			alert(getMessage("MLC_CAPTURE_DATE_CANNOT_FUTURE",'AE'));
			obj.select();
		}
	}
}

function updateSelf(Obj){
	if(Obj.checked){
		Obj.value = 'Y';
	}else{
		Obj.value = 'N';
	}
}
function maxLengthPaste(field,maxChars)
{
      event.returnValue=false;
      if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);  
	    return false;
      }
      event.returnValue=true;
}
/* END GHL-CRF-0650 */



async function shoModalCall(patient_id){
	
	if(confirm(message)){
		pat_ID = patient_id;
		var dialogTop   = '-13px'; //65
		var dialogHeight    = '94vh' ; //44
		var dialogWidth = '75vw' ;//65
		var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no';
		var arguments = '' ;
		var retVal = '';
		var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID='+patient_id;
		retVal = await top.window.showModalDialog(url,arguments,features);
		 if (retVal) {
             if (top.content.frames[1].frames[0].document.forms[0].National_Id_No.value != '') {
                 top.content.frames[1].frames[0].document.forms[0].patient_id.value = patient_id;
                 if (top.content.frames[1].frames[0].document.forms[0].patient_id.value != '')
                     top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
                 else if (top.content.frames[1].frames[0].document.forms[0].referal_id.value != '')
                     top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();
             } else {
                 if (top.content.frames[1].frames[0].document.forms[0].patient_id.value != '')
                     top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
                 else if (top.content.frames[1].frames[0].document.forms[0].referal_id.value != '')
                     top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();
             }
         } else {
             top.content.frames[1].frames[0].document.forms[0].patient_id.value = '';
             top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
         }
     
	}
	else{
		top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
		top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
	}
}

