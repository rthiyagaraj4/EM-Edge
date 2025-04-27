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

function CheckForSpecChar(event){ 
    var strCheck = ' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function setPriority(obj)   
{
	/*five_level_triage_appl_yn Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014*/
	var five_level_triage_appl_yn	= document.forms[0].five_level_triage_appl_yn.value;
	if(five_level_triage_appl_yn!='Y'){
		if(obj.checked == true)
			 {
			    remVal(document.forms[0].treat_area);
			    remVal(document.forms[0].priority11);
				
			 /*Below line adde d for this CRF AAKH-CRF-0010 [IN038535]*/		
			if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
			     if(document.forms[0].practitioner_desc){
			      document.forms[0].practitioner_desc.value = "";
			      document.forms[0].practitioner_desc.disabled = true;
			  }
			  if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
				
				
			   if(obj.name == 'priorityR')
				 {
			      document.forms[0].priorityY.checked=false;
		  		  document.forms[0].priorityG.checked=false;
				  document.forms[0].priorityY.disabled=true;
			      document.forms[0].priorityG.disabled=true;
		          document.forms[0].hddpriority.value ='R';
				  document.forms[0].bed_bay_no.value = "";
		
		
				  /*if (document.forms[0].treat_area=='')
				  {
		              document.forms[0].bed_button.disabled = true;
				      document.forms[0].bed_bay_no.disabled = true;
				  } 
				  else{
					  document.forms[0].bed_button.disabled = false;
				      document.forms[0].bed_bay_no.disabled = false;
				  }*/
				 
				 }
				 if(obj.name== 'priorityY')
				 {
		          document.forms[0].priorityR.checked=false;
		  		  document.forms[0].priorityG.checked=false;
				  document.forms[0].priorityR.disabled=true;
			      document.forms[0].priorityG.disabled=true;
				  document.forms[0].hddpriority.value ='Y';
				  document.forms[0].bed_bay_no.value = "";
				  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
				 }
				 if(obj.name== 'priorityG')
				 {
		
				  document.forms[0].priorityR.checked=false;
		  		  document.forms[0].priorityY.checked=false;
			      document.forms[0].priorityR.disabled=true;
			      document.forms[0].priorityY.disabled=true;
				  document.forms[0].hddpriority.value ='G';
				  document.forms[0].bed_bay_no.value = "";
				  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
				 }
				
				//Added by Ajay Hatwate for ML-MMOH-CRF-2069
					if(document.forms[0].isSecondaryTriageQueueNum.value == 'true' && document.forms[0].queue_secondary_triage.value == "Y"){
						if( (document.forms[0].hddpriority.value == document.forms[0].queue_appl_priority_zone.value) ){
							document.forms[0].queue_no1.disabled = false;
							if(document.forms[0].queue_num_mandatory.value == 'Y'){
								var queue_no_mand_img = document.getElementById("queue_no_mand_img");
								queue_no_mand_img.style.visibility = 'visible';
							}
						}else{
							document.forms[0].queue_no1.disabled = true;
							if(document.forms[0].queue_num_mandatory.value == 'Y'){
							var queue_no_mand_img = document.getElementById("queue_no_mand_img");
							queue_no_mand_img.style.visibility = 'hidden';
						}
					}
				}
				 
		    }
			else if(obj.checked == false)
			{
				remVal(document.forms[0].treat_area);
			    remVal(document.forms[0].priority11);
               			
			 /*Below line adde d for this CRF AAKH-CRF-0010 [IN038535]*/	
			if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
			     if(document.forms[0].practitioner_desc){
			      document.forms[0].practitioner_desc.value = "";
			      document.forms[0].practitioner_desc.disabled = true;
			  }
			  if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
				
				if(obj.name== 'priorityR')
				 {
				
			      document.forms[0].priorityY.disabled=false;
			      document.forms[0].priorityG.disabled=false;
				  document.forms[0].hddpriority.value ='U';
				  document.forms[0].bed_bay_no.value = "";
				  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
				  
		
				  }
				 if(obj.name== 'priorityY')
				 {
			      document.forms[0].priorityR.disabled=false;
			      document.forms[0].priorityG.disabled=false;
				  document.forms[0].hddpriority.value ='U';
				  document.forms[0].bed_bay_no.value = "";
		  		  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
				 }
				 if(obj.name== 'priorityG')
				 {
			      document.forms[0].priorityR.disabled=false;
			      document.forms[0].priorityY.disabled=false;
				  document.forms[0].hddpriority.value ='U';
				  document.forms[0].bed_bay_no.value = "";
				   document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
				 }
				 
				 	//Added by Ajay Hatwate for ML-MMOH-CRF-2069
					if(document.forms[0].isSecondaryTriageQueueNum.value == 'true' && document.forms[0].queue_secondary_triage.value == "Y"){
							document.forms[0].queue_no1.disabled = true;
							if(document.forms[0].queue_num_mandatory.value == 'Y'){
							var queue_no_mand_img = document.getElementById("queue_no_mand_img");
							queue_no_mand_img.style.visibility = 'hidden';
							}
					}
				 
				 
		    }
        //Added By Shanmukh for MMS-DM-CRF-0147
			if(obj.name=="Priority_Zone_Type"){
				remVal(document.forms[0].treat_area);
				remVal(document.forms[0].priority11);
				if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
			     if(document.forms[0].practitioner_desc){
			      document.forms[0].practitioner_desc.value = "";
			      document.forms[0].practitioner_desc.disabled = true;
			  }
			  if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
			  
			  document.forms[0].bed_bay_no.value = "";
			  if(obj.name=="Priority_Zone_Type" && obj.value==""){
				  document.forms[0].bed_bay_no.value = "";
				  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
			  }
			  if(document.forms[0].treat_area.value==""){
				  document.forms[0].bed_bay_no.value = "";
				  document.forms[0].bed_button.disabled = true;
				  document.forms[0].bed_bay_no.disabled = true;
			  }
				document.forms[0].hddpriority.value =obj.value;
				
				
				}
				
				
			
		}else{
			
			document.forms[0].hddpriority.value = obj;
		    remVal(document.forms[0].treat_area);
		    remVal(document.forms[0].priority11);
			 /*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/	
			if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
			     if(document.forms[0].practitioner_desc){
			      document.forms[0].practitioner_desc.value = "";
			      document.forms[0].practitioner_desc.disabled = true;
			  }
			  if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
			
			if(obj!='R'){
				document.forms[0].bed_bay_no.value = "";
				document.forms[0].bed_button.disabled = true;
				document.forms[0].bed_bay_no.disabled = true;
			}
		}
}
function setDisaster(obj)
{
	if (obj.checked == true)
	{
		document.forms[0].Disaster_YN.value='Y';
		document.forms[0].disaster_area1.disabled = false;
		document.forms[0].disaster.disabled = false;
		document.forms[0].disaster_type.disabled = false;
		document.forms[0].disaster_category.disabled = false;//Added by Ajay Hatwate for ML-MMOH-CRF-2111
		document.forms[0].Disaster_Reference.disabled = false;
	}
	else if (obj.checked == false)
	{
		document.forms[0].Disaster_YN.value='N';
		//Modified by Sangeetha for ML-MMOH-CRF-0644 incident [IN:064480]
		document.forms[0].disaster_area1.disabled = true;
		document.forms[0].disaster.disabled = true;	
		document.forms[0].disaster_type.value="";
		document.forms[0].disaster_type.disabled = true;	
		document.forms[0].disaster_category.value="";//Added by Ajay Hatwate for ML-MMOH-CRF-2111
		document.forms[0].disaster_category.disabled = true;//Added by Ajay Hatwate for ML-MMOH-CRF-2111	
		document.forms[0].Disaster_Reference.value = "";	
		document.forms[0].Disaster_Reference.disabled = true;	
		//Added by Sangeetha for ML-MMOH-CRF-0644 incident [IN:064480]
		document.forms[0].disaster_area.value="";
		document.forms[0].disaster_area1.value = "";

	}
}
function remVal1(obj)
{ 
	while(obj.options.length >=1)
	{
		obj.remove(0);
	}
}
function remVal(obj)
{
	
	while(obj.options.length > 1)
	{
		obj.remove(1);		
	}
	
}
function setMechInj(){
	//remVal1(document.forms[0].injury);
    // remVal1(document.forms[0].mechan_injury);
	 var injury = document.forms[0].injury;
   /* var mechan_injury = document.forms[0].mechan_injury;
	 var opt		=	document.createElement('OPTION'); 
		opt.text	=	'          ----- Select -----       ';
		opt.value	=	'';
	 mechan_injury.add(opt);
	 var opt1		=	document.createElement('OPTION'); 
		opt1.text	=	'          ----- Select -----       ';
		opt1.value	=	'';
     injury.add(opt1); */
	 /*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
	 var repDb		= document.forms[0].RepDb.value;
	 var facilityId = document.forms[0].facility_id.value;
	 /*End*/
	 var called_from_ca = document.forms[0].called_from_ca.value;
	 var mechaInjflagNew = "Y";
     var oscc_yn	      = document.forms[0].oscc_yn.value;
	 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='mechaInjflagNew' id='mechaInjflagNew' value='"+mechaInjflagNew+"'><input type='hidden' name='oscc_yn' id='oscc_yn' value='"+oscc_yn+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></BODY></HTML>";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

		 if(called_from_ca!='Y') {
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.visit_form.submit();	     
			 } else {
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.visit_form.submit();	
			 }
}


function setMechInj1(obj){
		 var injury = document.forms[0].injury;
		 while(document.forms[0].mechan_injury.options.length > 1)
		{
			document.forms[0].mechan_injury.remove(1);
		}
		 //var tarumaFlag = document.forms[0].CaseofTrauma.checked;//Commented by Thamizh selvi for ML-MMOH-CRF-0645
	 //if(tarumaFlag){
		 var called_from_ca = document.forms[0].called_from_ca.value;
		 var mechaInjflagNew = "Y";
		 var oscc_yn	      = document.forms[0].oscc_yn.value;
		 /*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
		 var repDb		= document.forms[0].RepDb.value;
		 var facilityId = document.forms[0].facility_id.value;
		 /*End*/
		 //remVal(document.forms[0].mechan_injury);
		var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='mechaInjflagNew' id='mechaInjflagNew' value='"+mechaInjflagNew+"'><input type='hidden' name='oscc_yn' id='oscc_yn' value='"+oscc_yn+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></BODY></HTML>";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		if(called_from_ca!='Y') {
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.visit_form.submit();	     
		} else {
			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.visit_form.submit();	
		}
	// }else{
		// remVal(document.forms[0].mechan_injury);
	// }
}

function remVal(obj)
{
	while(obj.options.length > 1)
	{
		obj.remove(1);
	}
}
function setInjury(obj)
	{
	
   
	
	var called_from_ca = document.forms[0].called_from_ca.value;
	if(obj.value!='')
	     { 
			 patient_id		      = document.forms[0].patient_id.value;
			 var category	      = document.forms[0].mechan_injury.value;
			 var mech_injr_subcat_code      = document.forms[0].mech_injr_subcat_code.value;
			 if(document.forms[0].injury.length >= 1)
				remVal(document.forms[0].injury);
			 if(document.forms[0].mech_sub_code!=null)
			 var mech_sub_code	  = document.forms[0].mech_sub_code.value;
			 var mechaInjflag = "Y";
             //remVal(document.forms[0].mech_sub_code);
			/*var optlength = document.forms[0].injury.options.length;
			for (var i=0; i<optlength; i++)
			{
				document.forms[0].injury.options.remove("injury");

			}

			var opt		=	document.createElement('OPTION'); 
			opt.text	=	'     ----- Select -----    ';
			opt.value	=	'';
			document.forms[0].injury.add(opt); */

			/*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
			var repDb		= document.forms[0].RepDb.value;
			var facilityId = document.forms[0].facility_id.value;
			/*End*/

			 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='category' id='category' value='"+category+"'><input type='hidden' name='mech_sub_code' id='mech_sub_code' value='"+mech_sub_code+"'><input type='hidden' name='mechaInjflag' id='mechaInjflag' value='"+mechaInjflag+"'><input type='hidden' name='mech_injr_subcat_code' id='mech_injr_subcat_code' value='"+mech_injr_subcat_code+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></BODY></HTML>";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			 
			
			 if(called_from_ca!='Y') {
       // change this for AECurrentEmergency
      //  parent.parent.messageFrame.document.write(HTMLVal);
			//	parent.parent.messageFrame.document.visit_form.submit();
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.visit_form.submit();	     
			 } else {
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.visit_form.submit();	
			 }
			
		 }
		else
		{
		 	 document.forms[0].mechan_injury.value	= '';
			 remVal(document.forms[0].injury);
		}
}

//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
function SpCharChkForMotorVecRegNo(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
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
	  if(document.forms[0].isMLCAppl.value == 'false'){
	  document.getElementById('mand5').style.visibility='visible';
	  if(document.forms[0].tick_mlc_if_oscc_checked_yn.value == 'Y'){
	  document.forms[0].mlc_case_yn.checked=true;
	  document.forms[0].mlc_case_yn.disabled=true;
	  document.forms[0].police_rep_no1.disabled=false;
	  document.forms[0].police_stat_detail.disabled=false;
	  document.forms[0].police_rep_no1.focus();
	  }
	  document.forms[0].oscc_yn.value='Y';
	  }else if (document.forms[0].isMLCAppl.value == 'true'){
		  document.getElementById('mand5').style.visibility='visible';
		  document.forms[0].oscc_yn.value='Y';
		  if(document.forms[0].tick_mlc_if_oscc_checked_yn.value == 'Y'){
		  document.forms[0].mlc_case_yn.checked=true;
		  document.forms[0].mlc_case_yn.value='Y';
		  document.forms[0].outside_mlc_dtls.disabled=false;
		  document.forms[0].police_rep_no1.disabled=false;
		  document.forms[0].police_rep_no1.focus();
		  document.forms[0].police_stat_detail.disabled=false;
		  document.forms[0].mlc_death.disabled=false;
		  document.forms[0].date_of_mlc_capture.disabled=false;
		  document.forms[0].date_of_mlc_capture.value=getCurrentDate("DMYHMS","en");
		  document.forms[0].mlc_remarks.disabled=false;
	  }
  }
  }
  else if (obj.checked == false)
  {
	  if(document.forms[0].isMLCAppl.value == 'false'){
	  document.getElementById('mand5').style.visibility="hidden";
	  document.forms[0].mlc_case_yn.checked=false;
	  document.forms[0].mlc_case_yn.disabled=false;
      document.forms[0].police_rep_no1.value="";
      document.forms[0].police_stat_detail.value="";
	  document.forms[0].police_rep_no1.disabled=true;
	  document.forms[0].police_stat_detail.disabled=true;
	  document.forms[0].oscc_yn.value='N';
	  }else  if(document.forms[0].isMLCAppl.value == 'true'){

		  document.getElementById('mand5').style.visibility="hidden";
		  document.forms[0].oscc_yn.value='N';
		  document.forms[0].mlc_case_yn.checked=false;
		  document.forms[0].mlc_case_yn.disabled=false;
		  document.forms[0].mlc_case_yn.value='N';
	      document.forms[0].police_rep_no1.value="";
	      document.forms[0].police_stat_detail.value="";
		  document.forms[0].police_rep_no1.disabled=true;
		  document.forms[0].police_stat_detail.disabled=true;
		  document.forms[0].mlc_death.disabled=true;
		  document.forms[0].mlc_death.checked=false;
		  document.forms[0].mlc_death.value='N';
		  document.forms[0].date_of_mlc_capture.disabled=true;
		  document.forms[0].date_of_mlc_capture.value='';
		  document.forms[0].outside_mlc_dtls.value='';
		  document.forms[0].outside_mlc_dtls.disabled=true;
		  document.forms[0].mlc_remarks.value='';
		  document.forms[0].mlc_remarks.disabled=true;  
  }
} 
} 
function chkMlcValue(obj)
{

  if (obj.checked == true)
  { 
	  document.forms[0].mlc_case_yn.value='Y';
	  document.forms[0].police_rep_no1.disabled=false;
	  document.forms[0].police_stat_detail.disabled=false;
	  if(document.forms[0].isMLCAppl.value == 'true'){
		  document.forms[0].mlc_death.disabled=false;
		  document.forms[0].outside_mlc_dtls.disabled=false;
		  document.forms[0].date_of_mlc_capture.disabled=false;
		  document.forms[0].mlc_remarks.disabled=false;
		  document.forms[0].date_of_mlc_capture.value=getCurrentDate("DMYHMS","en");
	  }
	 // document.forms[0].police_rep_no1.focus();
	 
  }
  else if (obj.checked == false)
  {	  
	  document.forms[0].mlc_case_yn.value='N';
	  document.forms[0].police_rep_no1.value="";
      document.forms[0].police_stat_detail.value="";
	  document.forms[0].police_rep_no1.disabled=true;
	  document.forms[0].police_stat_detail.disabled=true;
	  if(document.forms[0].isMLCAppl.value == 'true'){
		  document.forms[0].mlc_death.value="N";
		  document.forms[0].mlc_death.disabled=true;
		  document.forms[0].mlc_death.checked=false;
		  document.forms[0].outside_mlc_dtls.value="";
		  document.forms[0].outside_mlc_dtls.disabled=true;
		  document.forms[0].date_of_mlc_capture.value="";
		  document.forms[0].date_of_mlc_capture.disabled=true;
		  document.forms[0].mlc_remarks.value="";
		  document.forms[0].mlc_remarks.disabled=true;
	}
  }
}





function checkPregnantDate(obj)
{
    var dat = obj;
    if(dat.value != '')
    {
        if(CheckDate(dat))
        {
			var dob = document.forms[0].hdddob.value;
			var lmp = convertDate(document.forms[0].lmp_date.value,"DMY",localeName,"en");
            var sys = document.forms[0].sysdate.value;
			 var called_from_ca = document.forms[0].called_from_ca.value;
		 var msgframe ='';
		 if(called_from_ca!='Y') 
			 msgframe = parent.parent.frames[2];
		  else msgframe = top.content.messageFrame;
		  pregnantDateCheck(lmp,sys,dob,msgframe)
        }else
		{
		 document.forms[0].lmp_date.value="";
		}
      
	}
}

function pregnantDateCheck(from,to,bod,messageFrame)
	{
    var fromarray;
    var toarray;
	var toarray1;
	var bodarray;
    var fromdate = from;
    var todate = to;
	var dobdate = bod;
    var msg='';
    if(fromdate.length > 0 && todate.length > 0  && dobdate.length > 0)
    {
			fromarray = fromdate.split("/");
           	var a=todate.split(" ")
	            splitdate=a[0];
					
	        var splitdate1 = a[0].split("/")
            var todt  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
			bodarray = dobdate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var bdt = new Date(bodarray[2],bodarray[1],bodarray[0]);
           if(Date.parse(fromdt)< Date.parse(todt)) 
           {
				if(Date.parse(fromdt) < Date.parse(bdt))
                {
				alert(getMessage("LMP_DATE_GT_DOB","AE"));
				parent.frames[2].document.getElementById('nmdesig').innerHTML="";
    	        parent.frames[2].document.getElementById('nmdesig1').innerHTML="";
					document.forms[0].lmp_date.value="";;
				document.forms[0].lmp_date.focus();
				document.forms[0].lmp_date.select();
				return false;
				}
            }
			    return true;
    }
}

function apply1(){
    parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = true;
	setTimeout("apply();", 1500);
}

function apply()
{
	/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
	var isReconfirmCOTAppl = parent.f_query_add_mod.document.AESecondaryTriage_form.isReconfirmCOTAppl.value;
	var reconf_cot_param = parent.f_query_add_mod.document.AESecondaryTriage_form.reconf_cot_param.value;
	var cot_chk = "";

	if(parent.f_query_add_mod.document.getElementById("trauma"))
		cot_chk = parent.f_query_add_mod.document.getElementById("trauma").checked;
	else if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma)
		cot_chk = parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked;
    
	if(isReconfirmCOTAppl == "true" && reconf_cot_param == 'Y' && cot_chk == false){
		showReconfCot();
	}
	/*End ML-MMOH-CRF-1409*/

	var isCaseDtlsRadioBtnAppl = parent.f_query_add_mod.document.AESecondaryTriage_form.isCaseDtlsRadioBtnAppl.value;//Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645

	/*Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start*/
	var isMechInjLabelChngAppl = parent.f_query_add_mod.document.AESecondaryTriage_form.isMechInjLabelChngAppl.value;
	var mechOfInjLablName = getLabel("Common.MechanismofInjury.label","Common");
	if(isMechInjLabelChngAppl == "true")
		mechOfInjLablName = getLabel("eAE.MechOfMainInj.label","AE")		
	/*End*/
	var sex=parent.f_query_add_mod.document.AESecondaryTriage_form.sex.value;
    var min_age_for_lmp=parent.f_query_add_mod.document.AESecondaryTriage_form.min_age_for_lmp.value;
    var year_value=parent.f_query_add_mod.document.AESecondaryTriage_form.year_value.value;
		
	 /* Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
	 var five_level_triage_appl_yn	=parent.f_query_add_mod.document.AESecondaryTriage_form.five_level_triage_appl_yn.value;
	 if(five_level_triage_appl_yn=='Y' && parent.f_query_add_mod.document.AESecondaryTriage_form.prioritynew!=null){
		
		 var prioritynew	= parent.f_query_add_mod.document.AESecondaryTriage_form.prioritynew.value;
		 if(prioritynew==""){
			 	var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$',getLabel("Common.PriorityZone.label","Common"));
				alert(err);
				parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
				return false;
		 }
	 }
	 /*--Added by K V Shanmukh on 6th-Apr-2018 against ML-MMOH-CRF-0656 Start-->*/
	 var isSecTrgBackDateTimeAppl=parent.f_query_add_mod.document.AESecondaryTriage_form.isSecTrgBackDateTimeAppl.value;
	 if(isSecTrgBackDateTimeAppl=="true"){ 
	 var triage_record_date_time=parent.f_query_add_mod.document.AESecondaryTriage_form.triage_record_date_time.value;
	 if(triage_record_date_time==""){
		 var err = getMessage('CAN_NOT_BE_BLANK','Common');
		 var err1=getLabel("eAE.Triage.label","AE")+" "+getLabel("Common.datetime.label",'Common');
		 err=err.replace('$',err1);
		 alert(err);
		 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
				return false;
	 }
	 }
	 var caseTypeYn = parent.f_query_add_mod.document.AESecondaryTriage_form.caseTypeYn.value;
	 var caseTypeMandYn = parent.f_query_add_mod.document.AESecondaryTriage_form.caseTypeMandYn.value;
	
	 if(caseTypeYn == "Y" && caseTypeMandYn == "Y"){
		 var case_type = parent.f_query_add_mod.document.AESecondaryTriage_form.case_type.value;
		 if(case_type == ""){
			 var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$',getLabel("eAE.CaseType.label","AE"));
				alert(err);
				parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
				return false;
		 }
	 }
	 
	 
	 //Added By Shanmukh for MMS-DM-CRF-0147
	var isPriorityZoneAppl=parent.f_query_add_mod.document.forms[0].isPriorityZoneAppl.value;
	if(isPriorityZoneAppl=="true" && parent.f_query_add_mod.document.forms[0].Priority_Zone_Type.value!=null){
		var Priority_Zone_Type=parent.f_query_add_mod.document.forms[0].Priority_Zone_Type.value;
		if(Priority_Zone_Type==""){
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$',getLabel("Common.PriorityZone.label","Common"));
			alert(err);
			parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
			return false;
		}
	}
	 /*End*/
	
	/* Added by Ajay Hatwate for ML-MMOH-CRf-2069 */ 
	
	var isSecTriageQueueAppl=parent.f_query_add_mod.document.forms[0].isSecondaryTriageQueueNum.value;	
	var queue_secondary_triage=parent.f_query_add_mod.document.forms[0].queue_secondary_triage.value;	
	if(isSecTriageQueueAppl=="true" && queue_secondary_triage == "Y"){
		var isSecTriageQueueNoMand=parent.f_query_add_mod.document.forms[0].queue_num_mandatory.value;
		var queue_no=parent.f_query_add_mod.document.forms[0].queue_no1.value;
		var hddpriority = parent.f_query_add_mod.document.forms[0].hddpriority.value;
		var queue_appl_priority_zone = parent.f_query_add_mod.document.forms[0].queue_appl_priority_zone.value;
				
		if(queue_no == "" && isSecTriageQueueNoMand !="Y"){
			parent.f_query_add_mod.document.forms[0].queue_no1.value = "";
			parent.f_query_add_mod.document.forms[0].queue_no.value = "";
		}
		
		if(queue_no == "" && isSecTriageQueueNoMand =="Y" && hddpriority == queue_appl_priority_zone){
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$',getLabel("Common.QueueNo.label","Common"));
			alert(err);
			parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
			return false;
		}
	}
	/* End of ML-MMOH-Czrf-2069 */
	
	
	 /* Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
	 
	  /*Below line adde d for this CRF AAKH-CRF-0010 [IN038535]*/	
						
			if(five_level_triage_appl_yn=='Y' && parent.f_query_add_mod.document.AESecondaryTriage_form.prev_pract_id && parent.f_query_add_mod.document.AESecondaryTriage_form.prev_pract_id.value!="" && parent.f_query_add_mod.document.AESecondaryTriage_form.practitioner_desc&&parent.f_query_add_mod.document.AESecondaryTriage_form.practitioner_desc.value==""){
						 var err = getMessage('PRACT_ALREADY_CAPTURED','AE');
				       
				         alert(err);
				        parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
				      return false;
			}	
	//End  AAKH-CRF-0010 [IN038535]
	 
	 
 var flag = "Y";
 parent.f_query_add_mod.document.AESecondaryTriage_form.referral_id.disabled=false;
  var called_from_ca = parent.f_query_add_mod.document.AESecondaryTriage_form.called_from_ca.value;
  var count=0;
  if(parent.f_query_add_mod.document.AESecondaryTriage_form.disaster_area1!=null){	
   if(parent.f_query_add_mod.document.AESecondaryTriage_form.disaster_area1.value=='')
        parent.f_query_add_mod.document.AESecondaryTriage_form.disaster_area.value='';
  }
   if(parent.f_query_add_mod.document.AESecondaryTriage_form.complaint_desc!=null){	
   if(parent.f_query_add_mod.document.AESecondaryTriage_form.complaint_desc.value=='')
        parent.f_query_add_mod.document.AESecondaryTriage_form.complaint_code.value='';
  }


if(sex=='F')
{
		if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val!=null)
		{
		if(year_value>=min_age_for_lmp)
		{
		if((parent.f_query_add_mod.document.AESecondaryTriage_form.mand2.style.visibility=='visible')&&(parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date.value==''))
		{
		count=1;
		}
		}
}
		} else
		{
		}

		if (parent.f_query_add_mod.document.AESecondaryTriage_form.att_given.checked==true){parent.f_query_add_mod.document.AESecondaryTriage_form.att_given.value='Y'}
		else parent.f_query_add_mod.document.AESecondaryTriage_form.att_given.value='N';

	   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pediatric_status!=null){	
		if (parent.f_query_add_mod.document.AESecondaryTriage_form.pediatric_status.value=='true')
		{		
		if (parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age.checked==true){parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age.value='Y'; parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age.disabled = false;}
		else parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age.value='N';
		if (parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date.checked==true){parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date.value='Y'; parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date.disabled = false;}
		else parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date.value='N';
		if (parent.f_query_add_mod.document.AESecondaryTriage_form.menarche.checked==true){parent.f_query_add_mod.document.AESecondaryTriage_form.menarche.value='Y'; parent.f_query_add_mod.document.AESecondaryTriage_form.menarche.disabled = false;}
		else parent.f_query_add_mod.document.AESecondaryTriage_form.menarche.value='N';
		}
  }
 if(parent.f_query_add_mod.document.AESecondaryTriage_form.Disaster_YN.value=='on')
       parent.f_query_add_mod.document.AESecondaryTriage_form.Disaster_YN.value='Y';

/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
if(isCaseDtlsRadioBtnAppl == "true"){
	if(parent.f_query_add_mod.document.getElementById("medical").checked==true)
		  parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.value='Y';
	else
		  parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.value='N';
}else{/*End*/
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked==true)
		  parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.value='Y';
	  else
		  parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.value='N';
	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked==true)
		  parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='Y';
	  else
		  parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='N';

	if(parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.checked==true)
		  parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.value='Y';
	  else
		  parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.value='N';

	if(parent.f_query_add_mod.document.AESecondaryTriage_form.surgical_yn.checked==true)
		  parent.f_query_add_mod.document.AESecondaryTriage_form.surgical_yn.value='Y';
	  else
		  parent.f_query_add_mod.document.AESecondaryTriage_form.surgical_yn.value='N';	
}
	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
   if(parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.checked==true)
       parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.value='Y';
   else
      parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.value='N';

  if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val!=null)
      parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.disabled=false;
 
    if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
    	if(parent.f_query_add_mod.document.AESecondaryTriage_form.lmpdate1!=null)
    	parent.f_query_add_mod.document.AESecondaryTriage_form.lmpdate1.disabled=false;
    }
    else
    {
    	if(parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date!=null)
	      parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date.disabled=false;
    }
  
   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val !=null)
	{
      if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.checked==true)
		{
         parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value='Y';
		 parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.disabled=false;
	
		 }
       else
	     parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value='N';
    }
	 
if(parent.f_query_add_mod.document.AESecondaryTriage_form.height !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.height.disabled = false;
	}
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.weight !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.weight.disabled = false;
	}
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.circumference !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.circumference.disabled = false;
	}
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.immun_date.disabled = false;
	}
	
	   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
	    	if(parent.f_query_add_mod.document.AESecondaryTriage_form.lmpdate1!=null){
	    	parent.f_query_add_mod.document.AESecondaryTriage_form.lmpdate1.disabled=true;
	    	}
	    }
	    else
	    {
	    	if(parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date!=null)
	    		{
		      parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date.disabled=false;
	    		}
	    }
	   
	
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.growth_age.disabled = false;
	}
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val !=null)
	{
	parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.disabled = false;
	}

if(isCaseDtlsRadioBtnAppl != "true"){//Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645
	 if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked==true)
			 parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='Y';
			 
	 else
			  parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='N';
}

 parent.f_query_add_mod.document.AESecondaryTriage_form.police_rep_no1.disabled=false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.police_stat_detail.disabled=false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.disaster_area1.disabled=false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.disabled=false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.ambulatory_status.disabled = false;
 //parent.f_query_add_mod.document.AESecondaryTriage_form.symptom_val.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.mechan_injury.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.injury.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.vehicle_invol.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.vehicle_invol1.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.protective_device.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.affected_site.disabled = false;
 if(isCaseDtlsRadioBtnAppl != "true"){//Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645
	 parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.disabled=false;
	 parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.disabled = false;
 }
 parent.f_query_add_mod.document.AESecondaryTriage_form.police_rep_no1.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.immunization_stat.disabled = false;
 parent.f_query_add_mod.document.AESecondaryTriage_form.att_given.disabled = false;
 if(five_level_triage_appl_yn!="Y"){//Modified By Shanmukh for MMS-DM-CRF-0147
	 if(isPriorityZoneAppl=="false"){
	 parent.f_query_add_mod.document.AESecondaryTriage_form.priorityR.disabled = false;
	 parent.f_query_add_mod.document.AESecondaryTriage_form.priorityY.disabled = false;
	 parent.f_query_add_mod.document.AESecondaryTriage_form.priorityG.disabled = false;}
	 parent.f_query_add_mod.document.AESecondaryTriage_form.treat_area.disabled = false;
 }

if((parent.f_query_add_mod.document.AESecondaryTriage_form.menarche!=null) &&(parent.f_query_add_mod.document.AESecondaryTriage_form.lmp_date!=null)&& (parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val!=null))
	{
	
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.all.menarche.checked==true && parent.f_query_add_mod.document.AESecondaryTriage_form.all.pregnant_at_present_yn_val.checked==true)
	    {	
			/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
			if(isCaseDtlsRadioBtnAppl == "true"){
				
				if(parent.f_query_add_mod.document.getElementById("trauma").checked && count==1){
					   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
						   var fields = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident,parent.f_query_add_mod.document.forms[0].place_of_accident,parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmpdate1,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
							 var names = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));
					   }
					   else{
					 var fields = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident,parent.f_query_add_mod.document.forms[0].place_of_accident,parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
					 var names = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));
					   }
				}else if(parent.f_query_add_mod.document.getElementById("trauma").checked){
					 var fields = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident,parent.f_query_add_mod.document.forms[0].place_of_accident,parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
					 var names = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.PregnantatPresent.label","AE"));
				}else if(parent.f_query_add_mod.document.getElementById("oscc").checked && count==1){
					var fields = new Array (parent.f_query_add_mod.document.forms[0].osccType,parent.f_query_add_mod.document.forms[0].lmp_date,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
					var names = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));
				}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
					var fields = new Array (parent.f_query_add_mod.document.forms[0].osccType,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
					var names = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.PregnantatPresent.label","AE"));
				}else{
					 var flag = "N";
					 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();	
				}
			
			}else{/*End*/
		
				 if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
				  {			     
					 if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val,parent.f_query_add_mod.document.forms[0].lmpdate1);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"),getLabel("eAE.LMPDate.label","AE"));	
					 }else{
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val,parent.f_query_add_mod.document.forms[0].lmp_date);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"),getLabel("eAE.LMPDate.label","AE"));				      
                                         }

				  }
				else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
				  {			 	                 
						 
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));				      

				  }

				  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && count==1)
				  {	
					   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmpdate1,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					   }else{
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmp_date,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					   }
				  }
				  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
				  { 	
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (mechOfInjLablName,getLabel("eAE.PregnantatPresent.label","AE"));	
				  }

				  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
				  {			
					  if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
					  var fields = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmpdate1,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					  }else{
						 var fields = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					  }
					  }
				 
				  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
				  {			  
						 var fields = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
				  }

				 else if(count==1) {
					 if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
					 var fields = new Array ( parent.f_query_add_mod.document.forms[0].lmpdate1,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
					 var names = new Array (getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					 }else{
						 var fields = new Array ( parent.f_query_add_mod.document.forms[0].lmp_date,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
						 var names = new Array (getLabel("eAE.LMPDate.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));	
					 }
					 } 
				 else {
					 var flag = "N";
					  parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
						 
				 } 

				 
				 var messageFrame= '';
				 if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
				  else messageFrame= top.content.messageFrame;
				   if(flag!="N")
					{
				  if(parent.f_query_add_mod.checkFields(fields, names, messageFrame))
				   {
					 if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
					  {
						BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
					  }else{
						if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								  {	
							
								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
								 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
								 {	
								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
								 var names1 = new Array (mechOfInjLablName);	
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								 {
									 
								 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
								 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
								 }
								 else {
								 } 
								 var messageFrame= '';
								if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
								else messageFrame= top.content.messageFrame;
							if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
							 {
							  parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
							 }
					  }
				   }
					}
			}
		 }
		 else
		{
			
			if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
            {
				          
				/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
				if(isCaseDtlsRadioBtnAppl == "true"){
						
						if(parent.f_query_add_mod.document.getElementById("trauma").checked){
							 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident,parent.f_query_add_mod.document.forms[0].place_of_accident,parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
							 var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
						}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
							var fields1 = new Array (parent.f_query_add_mod.document.forms[0].osccType);
							var names1 = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
						}else{
							var flag = "N";
							if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !=""){
								BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
							}else{
								parent.f_query_add_mod.document.AESecondaryTriage_form.submit();}
						 } 
				
				}else{/*End*/
						if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						  {	
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
						 {
							 	
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
						 var names1 = new Array (mechOfInjLablName);	
						 }
						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						 {
							 
						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						 else {
						   var flag = "N";
							if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                             {
                           BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
                           }else{
 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();}
						 } 
					 if (flag=='Y')
					 {
						 var messageFrame= '';
		                if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		                else messageFrame= top.content.messageFrame;
					    if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					    {
BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
					   }
					 }
				}
            }else{

				/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
				if(isCaseDtlsRadioBtnAppl == "true"){
						if(parent.f_query_add_mod.document.getElementById("trauma").checked && count==1 ){
							if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury, parent.f_query_add_mod.document.forms[0].lmpdate1);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							}else{
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury, parent.f_query_add_mod.document.forms[0].lmp_date);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							}
						}else if(parent.f_query_add_mod.document.getElementById("trauma").checked){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
						}else if(parent.f_query_add_mod.document.getElementById("oscc").checked && count==1 ){
							   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType, parent.f_query_add_mod.document.forms[0].lmpdate1);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							   }else{
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType, parent.f_query_add_mod.document.forms[0].lmp_date);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							   }
						}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
						}else{
							if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !=""){
								BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
							}else if((parent.f_query_add_mod.document.AESecondaryTriage_form.all.pregnant_at_present_yn_val.checked==true)&&(count==1)){
								 if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].lmpdate1);
				               var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));	
								 }else{
				               var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].lmp_date);
				               var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));
								 }
						    }else{
							  var flag = "N";
                              parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
						   }
						 }

				}else{/*End*/
				          if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
						  {    	        
				        	  if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
                      	 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].lmpdate, parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
				         var names1 = new Array (getLabel("eAE.LMPDate.label","AE"),mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));
				        	  }else{
                      	 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].lmp_date, parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].pregnant_at_present_yn_val);
				         var names1 = new Array (getLabel("eAE.LMPDate.label","AE"),mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.PregnantatPresent.label","AE"));
				        	  }
						  }		 

                        else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						  {	
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && count==1)
						 {
						if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
						   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmpdate1);
						   var names1 = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"));
						}else{
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmp_date);
						 var names1 = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"));	
						}
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
						 {	
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
						 var names1 = new Array (mechOfInjLablName);	
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
						 {
						if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date);
							 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"));
						}else{
						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"));	
						}
						 }
                          else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						 {
							  
						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						 else {
							 if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                             {
BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
                           }else if((parent.f_query_add_mod.document.AESecondaryTriage_form.all.pregnant_at_present_yn_val.checked==true)&&(count==1)){
                        	   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].lmpdate1);
				               var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));
                        	   }else{
				               var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].lmp_date);
				               var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));				
                        	   }
						     }else
							   
						   {
							  var flag = "N";
                              parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
						   }

						 } 

					}
					if (flag=='Y')
					 {
					var messageFrame= '';
		            if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		            else messageFrame= top.content.messageFrame;
					if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					 {
			            parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
					 }
				 }

			}
		 }
	}
		else
	    {  

			 if((parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val!=null))
			{
             if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.checked==true)
                {

					/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/					
					if(isCaseDtlsRadioBtnAppl == "true"){
				
						if(parent.f_query_add_mod.document.getElementById("trauma").checked && count==1 ){
							   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury, parent.f_query_add_mod.document.forms[0].lmpdate1);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							   }else{
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury, parent.f_query_add_mod.document.forms[0].lmp_date);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							   }
						}else if(parent.f_query_add_mod.document.getElementById("trauma").checked){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
							var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
						}else if(parent.f_query_add_mod.document.getElementById("oscc").checked && count==1 ){
							if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType, parent.f_query_add_mod.document.forms[0].lmpdate1);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;

							}else{
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType, parent.f_query_add_mod.document.forms[0].lmp_date);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"), getLabel("eAE.LMPDate.label","AE"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							}
						}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
							var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
							var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
						}else{
							 var flag = "N";
							 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();	
						}
					}else{/*End*/
						if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
						  {	
							   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
								   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmpdate1);
								   var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"));	
							   }else{
								   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date);
								   var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"));
							   }
						 }

						  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						  {	
						   var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
						   var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && count==1 )
						 {
							   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmpdate1);
							 var names1 = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"));	
							   }else{
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].lmp_date);
						 var names1 = new Array (mechOfInjLablName,getLabel("eAE.LMPDate.label","AE"));	
							   }
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
						 {	
						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
						 var names1 = new Array (mechOfInjLablName);	
						 }
						 
						  else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked && count==1)
						 {
							  if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
								  var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmp_date);
								  var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE")); 
							  }else{
								  var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury,parent.f_query_add_mod.document.forms[0].lmpdate1);
								  var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"),getLabel("eAE.LMPDate.label","AE"));
							  }
						 }

						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						 {
							 
						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						  else if(count==1){
							   if(parent.f_query_add_mod.document.AESecondaryTriage_form.pregnant_at_present_yn_val.value=="Y" && parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value=="Y"){
							  var fields1 = new Array (parent.f_query_add_mod.document.forms[0].lmpdate1);
								 var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));
							   }else{
						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].lmp_date);
						 var names1 = new Array (getLabel("eAE.LMPDate.label","AE"));
							   }
						 }
						 else {							 
								   var flag = "N";
									parent.f_query_add_mod.document.AESecondaryTriage_form.submit();

								 }
					}
				

		       var messageFrame1='';
		      if(called_from_ca!='Y') messageFrame1=parent.parent.messageFrame;
			  else messageFrame1=top.content.messageFrame;
			  if(flag!='N')
					{

              if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame1))
					{

					  if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                       {
							BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
                       }else{
							if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						  {

						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
						 {
							 

						 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
						 var names1 = new Array (mechOfInjLablName);	
						 }
						 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
						 {

						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
						 }
						 else {
							 
						   var flag = "N";
 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();

						 }
                     if (flag=='Y')
					 {
						 var messageFrame= '';
		                if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		                else messageFrame= top.content.messageFrame;
					if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					 {
			              parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
					 }
					 }
					   }
                    }
					}
		    	}
               else
				{

				    if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                    {
						/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
						if(isCaseDtlsRadioBtnAppl == "true"){
				
								if(parent.f_query_add_mod.document.getElementById("trauma").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
									var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
									var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else{
									 var flag = "N";
									 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();	
								}
						}else{/*End*/
							if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
							  {
							  

							 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
							 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false; //Added by Suji keerthi
							 }
							 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
							 {

							 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
							 var names1 = new Array (mechOfInjLablName);	
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false; //Added by Suji keerthi
							 }
							 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
							 {

							 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
							 var names1 = new Array (mechOfInjLablName);
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false; //Added by Suji keerthi
							 }
							 else {

								  var flag = "N";
								  BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
							 }
						}
					 if (flag=='Y')
					 {					

						 var messageFrame= '';
		                 if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		                 else messageFrame= top.content.messageFrame;
					     if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					     {
					   		BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
						 }
					 }
                    }else{
						/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/					
						if(isCaseDtlsRadioBtnAppl == "true"){
				
								if(parent.f_query_add_mod.document.getElementById("trauma").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
									var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
									var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else{
									 var flag = "N";
									 parent.f_query_add_mod.document.AESecondaryTriage_form.submit();	
								}
						}else{/*End*/
								 if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								  {
													

								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
								 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));
								 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
								 {
														 

								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
								 var names1 = new Array (mechOfInjLablName);
								 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								 {
														 

								 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
								 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
								 }
								 else {
														

									  var flag = "N";
									  parent.f_query_add_mod.document.AESecondaryTriage_form.action="../../servlet/eAE.AESecondaryTriageServlet"
									  parent.f_query_add_mod.document.AESecondaryTriage_form.method = "post";
									  parent.f_query_add_mod.document.AESecondaryTriage_form.target = "messageFrame";
								      parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
								 }
						}
					 if (flag=='Y')
					 {
						 					 

						var messageFrame= '';
		                if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		                else messageFrame= top.content.messageFrame;
					    if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					   {

				       parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
					   }
				     }
					}
			    }
			}
			else
				{
									 

				    if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                    {
                     					 
						/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/					
						if(isCaseDtlsRadioBtnAppl == "true"){
				
								if(parent.f_query_add_mod.document.getElementById("trauma").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
									var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));	
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
									var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
									var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
									parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								}else{
									 var flag = "N";
									 BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
								}
						}else{/*End*/

							if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
							  {
											 

							 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
							 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							 }
							 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
							 {
													 

								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
							 var names1 = new Array (mechOfInjLablName);	
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
							 }

							 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
							 {
													 

							 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
							 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
							 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;

							 }
	//add
							 else{
													 
								  var flag = "N";
								   BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
							   }
						}
					if (flag=='Y')
					 {
					var messageFrame= '';
		            if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		            else messageFrame= top.content.messageFrame;
					if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					 {
 BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
					 }
				  } //end
				 } 
                  else{
						 					 

				       if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value !="")
                       {
							BedValidation(parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value);
					   }else{
						   
						   /*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/					
						   if(isCaseDtlsRadioBtnAppl == "true"){
					
									if(parent.f_query_add_mod.document.getElementById("trauma").checked){
										var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].date_time_accident, parent.f_query_add_mod.document.forms[0].place_of_accident, parent.f_query_add_mod.document.forms[0].mechan_injury, parent.f_query_add_mod.document.forms[0].injury);
										var names1 = new Array (getLabel("eAE.DateTimeOfOccurrence.label","AE"), getLabel("eAE.PlaceOfOccurrence.label","AE"), mechOfInjLablName, getLabel("eAE.MechaofSubInjury.label","AE"));
										parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
									}else if(parent.f_query_add_mod.document.getElementById("oscc").checked){
										var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].osccType);
										var names1  = new Array (getLabel("Common.oscc.label","Common")+" "+getLabel("Common.type.label","Common"));
										parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
									}else{
										 var flag = "N";
									}
							}else{/*End*/

								if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked && parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								  {
												

								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury,parent.f_query_add_mod.document.forms[0].injury);
								 var names1 = new Array (mechOfInjLablName,getLabel("eAE.MechaofSubInjury.label","AE"));	
								 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked)
								 {
														 

								 var fields1 = new Array ( parent.f_query_add_mod.document.forms[0].mechan_injury);
								 var names1 = new Array (mechOfInjLablName);	
								 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
								 }
								 else if (parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.checked)
								 {
														 

						 var fields1 = new Array (parent.f_query_add_mod.document.forms[0].injury);
						 var names1 = new Array (getLabel("eAE.MechaofSubInjury.label","AE"));	
						 parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
						 }
                         else{
							 					 

							  var flag = "N";

									   //parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
								   }
							}
					if (flag=='Y')
					 {
											 
					var messageFrame= '';
		            if(called_from_ca!='Y')messageFrame= parent.parent.messageFrame;
		            else messageFrame= top.content.messageFrame;
					if(parent.f_query_add_mod.checkFields( fields1, names1, messageFrame))
					 {

			            parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
					 }
				  } //end
					  else{
					    parent.f_query_add_mod.document.AESecondaryTriage_form.submit();
					    }
					   }

					 }
			    }
					} parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.disabled = false; /*modified by Afruddin on 13-Apr-20 for SKR-SCF-1326 IN072673*/
}


function BedValidation(bed)
{
	 var selection_mode = "triage";
    if (parent.f_query_add_mod.document.AESecondaryTriage_form.bed_bay_no.value == "")
    {
	return;
	}else
		{
		var facility_id			= parent.f_query_add_mod.document.AESecondaryTriage_form.facility_id.value;
		var temp = (parent.f_query_add_mod.document.AESecondaryTriage_form.treat_area.value).split("$$");
		var treatment_area = temp[0];/*modified by Rameswar on 16-Mar-16 for IN59662*/
        var clinic =parent.f_query_add_mod.document.AESecondaryTriage_form.clinic_code.value;
		var patient_id = parent.f_query_add_mod.document.AESecondaryTriage_form.patient_id.value;
		var caInstalled = parent.f_query_add_mod.document.AESecondaryTriage_form.called_from_ca.value;
		if (bed != "" && clinic != "" && treatment_area != "")
		{
			
			var HTMLValue	= "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEBedValidGI.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ManagePatGITreatArea'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='caInstalled' id='caInstalled' value='"+caInstalled+"'><input type='Hidden' name='selection_mode' id='selection_mode' value='"+selection_mode+"'><input type='Hidden' name='calledFrom' id='calledFrom' value='bedValidY'></form></body></html>"
	
			if (caInstalled=='Y')
				{
					parent.parent.messageFrame.document.write(HTMLValue);
					parent.parent.messageFrame.document.dummy_form.submit();
				}
				else
				{
					parent.messageFrame.document.write(HTMLValue);
					parent.messageFrame.document.dummy_form.submit();
				}
		}
	
	}
}
function resetpage() 
{
	if(parent.frames[2].document.forms[0]==null)
	{
		var treatment_area_code	=	parent.frames[2].document.forms[0].treat_code.value;
		var encounter_id		=	parent.frames[2].document.forms[0].encounter_id.value;
		var called_from_ca	=	parent.frames[2].document.forms[0].called_from_ca.value;
		var brought_dead		=	parent.frames[2].document.forms[0].brought_dead.value;
		var bed_no				=	parent.frames[2].document.forms[0].bed_no.value;
		var priority_zone		=	parent.frames[2].document.forms[0].priority_zone.value;
        var patient_id			=	parent.frames[2].document.forms[0].patient_id.value;
		var clinic_code			=	parent.frames[2].document.forms[0].clinic_code.value;

		var query_string		=	"clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&encounter_id="+encounter_id+"&called_from_ca="+called_from_ca+"&brought_dead="+brought_dead+"&bed_no="+bed_no+"&priority_zone="+priority_zone+"&patient_id="+patient_id+"&modify_flag=N";
	}
	else
	{
             var query_string		=parent.frames[3].document.forms[0].query_string.value;
   }
		
        parent.f_query_add_mod.location.href="../../eAE/jsp/AESecondaryTriage.jsp?"+query_string;

		parent.view.location.href="../../eAE/jsp/ViewSecondaryTriage.jsp?"+query_string;

		parent.TriageButtonsFrame.location.href="../../eAE/jsp/SecondaryTriageButtons.jsp?"+query_string;
		
		
	if (called_from_ca=='Y')
	{
		 parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	else{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	
} 


function close_func() 
{
	parent.window.close() ;
} 
/* FUNCTION FOR POPULATING VALUES IN TREATMENT AREA AND PRIORITY LIST BOXES BASED 
                ON THE VALUE OF PRIORITY ZONE CHECK BOX VALUE*/
function setTreatment(obj)
{
 var called_from_ca = document.forms[0].called_from_ca.value;
 var modify_flag = document.forms[0].modify_flag.value;
 var repDb		= document.forms[0].RepDb.value;//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
	if (obj.value!='')
	{
	 document.forms[0].treat_code.value="";
	 var obj1 = document.forms[0].hddpriority.value;
	 var clinic_code = document.forms[0].clinic_code.value;	
	 var priority	= document.forms[0].hddpriority.value;
     var facility_id	= document.forms[0].facility_id.value;
	 var treat_code= document.forms[0].treat_code.value;
	 var pat_priority=document.forms[0].pat_priority.value;
	 var gender=document.forms[0].gender.value;
	 
	 /* Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
	 var p_zone_order_no_new	= "";
	 var five_level_triage_appl_yn	= document.forms[0].five_level_triage_appl_yn.value;
	 if(five_level_triage_appl_yn=='Y'){
		 p_zone_order_no_new	= document.getElementById("priority_zone_order_by_"+obj.value).value;
	 }
	 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
	 
	if (modify_flag!= 'Y')
	{ 
	}
	 if(obj1!='')
	     { 
		   
	 		 priority = obj1;

			
			 patient_id		  = document.forms[0].patient_id.value;
			 var treatmentflag1 = "Y";
	
			 /* Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014*/
			// var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='treatmentflag1' id='treatmentflag1' value='"+treatmentflag1+"'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='treat_code' id='treat_code' value='"+treat_code+"'><input type='hidden' name='pat_priority' id='pat_priority' value='"+pat_priority+"'> <input type='hidden' name='gender' id='gender' value='"+gender+"'></form></BODY></HTML>";
			 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='priority' id='priority' value='"+priority+"'><input type='hidden' name='treatmentflag1' id='treatmentflag1' value='"+treatmentflag1+"'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='treat_code' id='treat_code' value='"+treat_code+"'><input type='hidden' name='pat_priority' id='pat_priority' value='"+pat_priority+"'> <input type='hidden' name='gender' id='gender' value='"+gender+"'> <input type='hidden' name='p_zone_order_no_new' id='p_zone_order_no_new' value='"+p_zone_order_no_new+"'> <input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='"+five_level_triage_appl_yn+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'> </form></BODY></HTML>";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			if(called_from_ca!='Y') {
		     parent.messageFrame.document.write(HTMLVal);
			 parent.messageFrame.document.visit_form.submit();
			} else {
					parent.messageFrame.document.write(HTMLVal);
					parent.messageFrame.document.visit_form.submit();
			}
		 }
		else
		{     if(document.forms[0].visit_type!=null)
		 	 document.forms[0].visit_type_code.value	= '';
		}
	}
	else
		{    if(document.forms[0].visit_type!=null)
		 	 document.forms[0].visit_type_code.value	= '';
		}

}
function checkPregnant(obj)
{
	var min_age_for_lmp=parent.f_query_add_mod.document.AESecondaryTriage_form.min_age_for_lmp.value;
	var year_value=parent.f_query_add_mod.document.AESecondaryTriage_form.year_value.value;
	var invokeMenstrualHistYN=parent.f_query_add_mod.document.AESecondaryTriage_form.invokeMenstrualHistYN.value;//added by krishna Pranay regarding ML-MMOH-CRF-1759.1

	//added by krishna Pranay regarding ML-MMOH-CRF-1759.1 start
	if(obj.checked == true && invokeMenstrualHistYN =="Y")
	{
      document.getElementById("mensHistHyperLinkDisplay").style.display = "inline";// Example label for viewing
      document.getElementById("lmp_calendar1").disabled =true;
      document.getElementById("lmpdate1").disabled =true;
      document.getElementById("mand2").style.display = "none";
      document.getElementById('lmpdate').value = ""; // Corrected ID to 'lmpdate'
      document.getElementById('nmdesig').innerHTML = "";
      document.getElementById('nmdesig1').innerHTML = "";
      document.getElementById('eddesig').innerHTML = "";
      document.getElementById('lmplabel').style.visibility='hidden';
  	document.getElementById('lmpdate').style.visibility='hidden';
	document.getElementById('lmpdate1').style.display = "inline";
	document.getElementById('lmplabel1').style.display = "inline";
	document.getElementById('lmp_calendar1').style.display = "inline";
	document.getElementById('lmp_calendar').style.visibility='hidden';
	document.getElementById('Lmpinputfield').style.display = "inline";

	}
	else if(obj.checked == false && invokeMenstrualHistYN =="Y")
	{// Replace the outdated line with modern syntax
        document.getElementById("mensHistHyperLinkDisplay").style.display = "none";
        document.getElementById("lmp_date").disabled =false;
        document.getElementById("lmp_calendar").disabled =false;
        document.getElementById("mand2").style.display = "inline";
        document.getElementById('lmplabel').style.visibility='visible';
      	document.getElementById('lmpdate').style.visibility='visible';
    	document.getElementById('lmpdate1').style.display = "none";
    	document.getElementById('lmplabel1').style.display = "none";
    	document.getElementById('lmp_calendar1').style.display = "none";
    	document.getElementById('lmp_calendar').style.visibility='visible';
    	document.getElementById('Lmpinputfield').style.display = "none";


        

	}
	//added by krishna Pranay regarding ML-MMOH-CRF-1759.1 end
	
	if (obj.checked == true)
	{
	            
		document.forms[0].pregnant_at_present_yn_val.value='Y';

		if(parseInt(year_value) >= parseInt(min_age_for_lmp))
		{
                 
			     document.forms[0].mand2.style.visibility='visible';
				 
		}
		else
		{

                 document.forms[0].mand2.style.visibility='hidden';
		}

	}
	else
    {
		document.forms[0].pregnant_at_present_yn_val.value='N';
		document.forms[0].mand2.style.visibility='hidden';
	}
}

   /** Added from AESecondaryTriage.jsp **/
	// To Make RTA Enabled or Disabled
	function doDate1(obj) 
	{
		var fromdate;
		var todate;
		todate  = document.forms[0].sysdate.value;
		fromdate = obj.value;

	if(fromdate!=null &&todate!=null)
		{
		 if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage("AE_LMP_DATE_CHECK","AE"));
            document.forms[0].lmp_date.value="";
			document.forms[0].lmp_date.focus();
		    document.getElementById('nmdesig').innerHTML=""
		    document.getElementById('nmdesig1').innerHTML="";		
			return false;
			}
		 }
		}
	}
	function checktrauma() {
		if(document.forms[0].CaseofTrauma.checked==true)
		{
		   document.forms[0].CaseofTrauma_val.value='Y';
		   document.getElementById('mand4').style.visibility='visible';
	    }
		else
		{
		  document.forms[0].CaseofTrauma_val.value='N';
		  document.getElementById('mand4').style.visibility='hidden';
		  //remVal(document.forms[0].mechan_injury);
		  remVal(document.forms[0].injury);
		}
	}

//Commented for involking help 
/*function lockKey()
	 {
	    if(event.keyCode == 93)
		    getMessage("WELCOME","Common");
	 }

	 */

	 function BroughtDead(obj)
	{
		if(obj.value=="Y")
		{
			document.forms[0].ambulatory_status.value='';
			document.forms[0].ambulatory_status.disabled = true;
			document.forms[0].responsiveness_val.disabled = true;
			document.forms[0].symptom_val.disabled = true;
		}
		else
		{
			document.forms[0].ambulatory_status.disabled = false;
			document.forms[0].responsiveness_val.disabled = false;
			document.forms[0].symptom_val.disabled = false;
		}
	}
/* code for menstral history validation  in pediatric details table menstral check box is checked  then pregnent at present checkbox will be enabled if it is checked then lmp date will becomes mandatory */
	function checkmenstrual(obj)
	{
		if((document.forms[0].pregnant_at_present_yn_val!=null) && (document.forms[0].lmp_date!=null))
		{
		if(obj.name=="menarche"){
			if(!(document.getElementById('menarche').value=null))
			   if(document.forms[0].menarche.checked==true)
				{
   				  document.forms[0].pregnant_at_present_yn_val.disabled=false;
			   }
			  else
			  { 
				  document.forms[0].pregnant_at_present_yn_val.checked=false;
				  document.forms[0].pregnant_at_present_yn_val.disabled=true;
				  document.forms[0].lmp_date.value="";
  				  document.forms[0].lmp_date.disabled=true;
				  document.getElementById('lmp_calendar').disabled=true;
				  document.forms[0].mand2.style.visibility='hidden';
				  parent.frames[2].document.getElementById('nmdesig').innerHTML="";
				  parent.frames[2].document.getElementById('nmdesig1').innerHTML="";

		  }
		}else{
				if(!(document.getElementById('pregnant_at_present_yn_val').value=null))
				   if(document.forms[0].pregnant_at_present_yn_val.checked==true)
					{
						document.forms[0].lmp_date.disabled=false;
						document.getElementById('lmp_calendar').disabled=false;
						document.forms[0].mand2.style.visibility='visible';

					}else
					{
						document.forms[0].lmp_date.value="";
						document.forms[0].lmp_date.disabled=true;
						document.getElementById('lmp_calendar').disabled=true;
						document.forms[0].mand2.style.visibility='hidden';
						parent.frames[2].document.getElementById('nmdesig').innerHTML="";
				        parent.frames[2].document.getElementById('nmdesig1').innerHTML="";
						document.getElementById('eddesig').innerHTML=""

					}
		}
		}
	} 
async function searchComplaintType(obj,target){

	            var locale         = document.forms[0].locale.value;
                var retVal         = new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";
				if(target.name=='complaint_desc'){
					tit=getLabel("Common.PresentingProblem.label","common");
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
				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                 {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					
					target.value=arr[1];
					if(target.name == 'complaint_desc')
					{
						document.forms[0].complaint_code.value= arr[0];
						document.forms[0].complaint_desc.value= arr[1];	
						
						
					}
			    }
			   else
		       {
				  document.forms[0].complaint_code.value="";
				 target.value="";
				 return;
			   }
}

async function searchDisasterArea(obj,target)
     {
		        var locale         = document.forms[0].locale.value;
                var retVal         = new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";				
					if(target.name == 'disaster_area1'){
						
					tit=getLabel("eAE.DisasterArea.label","AE");
                   
				   sql="select res_town_code code,long_desc description from mp_res_town_lang_vw where LANGUAGE_ID ='"+locale+"' and upper(res_town_code)like upper(?) and upper(long_desc) like upper(?) and eff_status = 'E' order by 2";
					}
				argumentArray[0] = sql;
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
					if(target.name == 'disaster_area1')
					{
						document.forms[0].disaster_area.value= arr[0];
						document.forms[0].disaster_area1.value= arr[1];	
						document.forms[0].disaster_area1.disabled=false;
						
					}
			    }
			   else
		       {
				 document.forms[0].disaster_area.value= "";
				 target.value="";
				 return;
			   }
	}
  function calculateEDD()
  {
	  if(document.getElementById('lmp_date')) {
		if(document.getElementById('lmp_date').value == null || document.getElementById('lmp_date').value == "" || document.getElementById('lmp_date').value == null || document.getElementById('lmp_date').value == ""||document.getElementById('pregnant_at_present_yn_val').checked==false){
		document.getElementById('eddesig').innerHTML=""	
		return;
		}
		var todate  = document.forms[0].sysdate.value;
		var fromdate = convertDate(document.getElementById('lmp_date').value,"DMY",localeName,"en");
	    if(fromdate!=null &&todate!=null)
		{
		 if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			document.getElementById('eddesig').innerHTML='';
			return false;
			}
			else{
               	from=fromdate;
				
				var splitdate  =from.split("/")
				var edd         = new Date(splitdate[2],splitdate[1]-1,splitdate[0]);
				edd.setTime(edd.getTime()+1000 * 60 * 60 * 24 * parseInt(7));
				edd.setMonth(edd.getMonth()+eval(09))
			       	var date= ""+edd.getDate()+"";
			
				var month= ""+parseInt(edd.getMonth()+1)+"";
				var hours= ""+edd.getHours()+"";
				var minutes= ""+edd.getMinutes()+"";
				if(date.length == 1)
					date="0"+date;
				if(month.length == 1)
					month="0"+month;
				if(hours.length == 1)
					hours="0"+hours;
				if(minutes.length == 1)
					minutes="0"+minutes;
				var finalDt="";

				finalDt += date + "/";
				finalDt += month + "/";
				finalDt += edd.getYear();
		    	var eddDate1    = convertDate(finalDt,"DMY","en",localeName);
				document.getElementById('eddesig').innerHTML=eddDate1;


				
		  }
		 }
		}
	  }
  }
	function calculateNoOfDays()
	{
		if(document.getElementById('lmp_date')) {
		if(document.getElementById('lmp_date').value == null || document.getElementById('lmp_date').value == "" || document.getElementById('lmp_date').value == null || document.getElementById('lmp_date').value == ""||document.getElementById('pregnant_at_present_yn_val').checked==false)
			return;

		var from = convertDate(document.getElementById('lmp_date').value,"DMY",localeName,"en");
		var to   = document.getElementById('visit_date_time').value;	
		
		var a=  from.split(" ")
		splitdate=a[0];
        var splitdate1 =splitdate.split("/")
		
		var dateFrom  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
    
		a=  to.split(" ")
		splitdate=a[0]; 
		splitdate1 =splitdate.split("/")
		var dateTo  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
		
		var toMilliSeconds=dateTo.getTime();
		
      
		var fromMilliSeconds=dateFrom.getTime();
	
			var MinMilli = 1000 * 60;
            var HrMilli = MinMilli * 60;
            var DAY = HrMilli * 24;

		var week =(Math.floor(((toMilliSeconds-fromMilliSeconds)/DAY))/7);

		var weeks =Math.floor(week);
		var days =  (Math.round(((toMilliSeconds-fromMilliSeconds)/DAY))%7);
		if(weeks<0 ||days<0)
		{
			return false;
		}
		document.getElementById('nmdesig').innerHTML=weeks;
		document.getElementById('nmdesig1').innerHTML=days;
		return;
		}
  	}

 function chkhwc(obj)
 {
 if(document.forms[0].growth_age!=null)
	 {
	 if(document.forms[0].growth_age.checked==true)
	 {
       document.forms[0].height.disabled=false;
	   document.forms[0].weight.disabled=false;
	   document.forms[0].circumference.disabled=false;
	 }
	 else
	 {
		 document.forms[0].height.disabled=true;
		 document.forms[0].weight.disabled=true;
		 document.forms[0].circumference.disabled=true;
		 document.forms[0].height.value="";
		 document.forms[0].weight.value="";
		 document.forms[0].circumference.value="";
	 }
	 }
 }

  async function callBedAvailChart()
	{
		var retVal	= 	new String();
		var Val		= 	new String();
		var dialogHeight= "60vh" ;
		var dialogWidth	= "60vw" ;
		var dialogTop	= "10" ;
		var status		= "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var treatment_area_code = document.forms[0].treat_area.value;
		var spitarr=treatment_area_code.split("$$"); //Added by Shanmukh
		treatment_area_code=spitarr[0];
		
        var clinic_code = document.forms[0].clinic_code.value;
		var bed_no = trimString(document.forms[0].bed_bay_no.value);
		var patient_id = document.forms[0].patient_id.value;
		var priority_zone =document.forms[0].hddpriority.value
		var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&bed_no="+bed_no+"&call_function=AssignTrmtArea&bed_status=V&priority_zone="+priority_zone;
		retVal =await  window.showModalDialog(url,arguments,features);

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

  function checkForValidBed(bed)
	{
	  if (document.forms[0].bed_bay_no.value == "" || document.forms[0].treat_area.value=="")
		{			return;
		
		}else{
			var selection_mode      = "triage";
			var facility_id			= document.forms[0].facility_id.value;
			var treatment_area      = document.forms[0].treat_area.value;
			var clinic              = document.forms[0].clinic_code.value;
			var patient_id          = document.forms[0].patient_id.value;
			var called_from_ca      = document.forms[0].called_from_ca.value;
			var caInstalled          = document.forms[0].called_from_ca.value;
			if (bed != "" && clinic != "" && treatment_area != "")
			{
			
				var HTMLValue	= "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEBedValidGI.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ManagePatGITreatArea'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='called_from_ca' id='called_from_ca' value='"+called_from_ca+"'><input type='Hidden' name='caInstalled' id='caInstalled' value='"+caInstalled+"'><input type='Hidden' name='selection_mode' id='selection_mode' value='"+selection_mode+"'></form></body></html>"
				if (called_from_ca=='Y')
				{
					parent.parent.messageFrame.document.write(HTMLValue);
					parent.parent.messageFrame.document.dummy_form.submit();
				}
				else
				{
					parent.messageFrame.document.write(HTMLValue);
					parent.messageFrame.document.dummy_form.submit();
				}
		  }
	  }
	
	}

	function checkMaxLen(obj){
		if (obj.value.length>250){
			var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
			//error = error.replace("$",getLabel("eAE.TriageDetails.label","AE")); Monday, February 15, 2010 19299 Venkat S;
			//error = error.replace("$",getLabel("Common.TriageDetails.label","Common")); 
			error = error.replace("$",getLabel("Common.remarks.label","Common")); // Tuesday, March 30, 2010 20405.
			error = error.replace("#","250");
			alert(error)
			obj.focus(); 
		}
	}

	function clearBed()
	{
		var treatment_area = document.forms[0].treat_area.value;  
		var spitarr=treatment_area.split("$$"); 
		//document.forms[0].treat_area.value=spitarr[0];
		document.forms[0].open_to_all_prac_for_clinic_yn.value=spitarr[1];
		
		var modify_flag = document.forms[0].modify_flag.value;
		 if (treatment_area=='')
		 {
			  document.forms[0].bed_bay_no.value = "";
			  document.forms[0].bed_button.disabled = true;
			  document.forms[0].bed_bay_no.disabled = true;
			  
			  /*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
			  if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
			  if(document.forms[0].practitioner_desc){
			  document.forms[0].practitioner_desc.value = "";
			  document.forms[0].practitioner_desc.disabled = true;
			  }
			  if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
			  
		 }
		 else{

			 if (modify_flag=='Y')
			 {
				  document.forms[0].bed_button.disabled = true;
			      document.forms[0].bed_bay_no.disabled = true;
			 }
			 else{

			  
			  
			  /*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
			  if(document.forms[0].diabled_pract && document.forms[0].diabled_pract.value!=""){
			         document.forms[0].bed_button.disabled = true;
			         document.forms[0].bed_bay_no.disabled = true;
			        if(document.forms[0].practitioner_desc)document.forms[0].practitioner_desc.disabled = true;
			        if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = true;
			  }else{
			       document.forms[0].bed_button.disabled = false;
			       document.forms[0].bed_bay_no.disabled = false;
			     if(document.forms[0].practitioner_desc)document.forms[0].practitioner_desc.disabled = false;
			     if(document.forms[0].pract_button)document.forms[0].pract_button.disabled = false;				 
			}		  
			  
			  }
		 }
	}
 function clearBed1(){
	 
	  document.forms[0].bed_bay_no.value="";
	  //CRF AAKH-CRF-0010 [IN038535]
	  if(document.forms[0].attend_pract_id)document.forms[0].attend_pract_id.value = "";
	  if(document.forms[0].practitioner_desc)document.forms[0].practitioner_desc.value = "";
 }
	/** Tab Function Added on 03/02/2005 **/

	function AEScrollIntoView(tabidx)
    {
		if(tabidx == 1)
		{
			document.getElementById('tab1').scrollIntoView();
			if(document.getElementById('treat_area'))
			{
				if(document.getElementById('treat_area').disabled==false)
					document.getElementById('treat_area').focus();
			}
		}
		else if(tabidx == 2)
		{
			document.getElementById('tab2').scrollIntoView();
			if(document.getElementById('immobilization'))
			{
				if(document.getElementById('immobilization').disabled==false)
					document.getElementById('immobilization').focus();
			}
		}
		else if(tabidx == 3)
		{
			document.getElementById('tabCA').scrollIntoView();
			showCAChart();
		}
	}
/*function tab_click1(objName)
	{
		   if(objName=="tab1")
			{
				document.getElementById('tab1').scrollIntoView();
			}
		   if(objName=="tab2")
			{
				document.getElementById('tab2').scrollIntoView();
			}
			 if(objName=="tabCA")
			{
				showCAChart();
			}
	}*/

/** Visit WithIn 24Hrs.  Added on 04/02/2005 **/
async function showLastVisitDetails(val)
{
	if(val == "LastVisit24")
	{
	  // var encounter_id		= document.forms[0].last_encounter_id.value; 
	  //removed this one for PE_EXE Wednesday, May 05, 2010 venkats

	   var patient_id      = document.forms[0].patient_id.value;
	   var retVal		   =  new String();
	   var dialogHeight	   = "18" ;
	   var dialogWidth	   = "45" ;

	   /*Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652*/
	   var isDiagDtlsSectionAppl = document.forms[0].isDiagDtlsSectionAppl.value;
	   var encounter_id			 = document.forms[0].encounter_id.value; 
	   var calledFrom			 = "SecondaryTriage";

	   if (isDiagDtlsSectionAppl == "true")
       {
		    dialogHeight	= "25vh" ;
		    dialogWidth		= "50vw" ;
	   }
	   /*End ML-MMOH-CRF-0652*/

	   var features		   = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	   var lastVisit24HrFlag ="Y";
	   var arguments	= "" ;
	  // retVal = window.showModalDialog("../../eAE/jsp/AERegisterAttnLastVisitFrameSet.jsp?encounter_id="+encounter_id+"&lastVisit24HrFlag="+lastVisit24HrFlag+"&patient_id="+patient_id,arguments,features);
	   retVal =await window.showModalDialog("../../eAE/jsp/AERegisterAttnLastVisitFrameSet.jsp?curr_encounter_id="+encounter_id+"&calledFrom="+calledFrom+"&lastVisit24HrFlag="+lastVisit24HrFlag+"&patient_id="+patient_id,arguments,features);
   }
   return retVal;
}

/** Previous Encounter  Added on 04/02/2005 **/
async function showPrevEncounter()
{
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var dialogWidth = "100vw" ;
	var	dialogHeight = "35vh";
	var dialogTop = "190" ;
	var status = "no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+" ; scroll=no; status:" + status;
     retVal = 
	 await window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id+"&encounterID="+encounter_id,arguments,features);
}
async function recAllergyDet()
{
	var patient_id = document.forms[0].patient_id.value;
	var params =  document.forms[0].query_string.value;
	//var dialogHeight= "35" ;
	var dialogHeight= "90vh" ;
	//var dialogWidth	= "62" ;
	var dialogWidth	= "90vw" ;
	var dialogTop ="5";
	var dialogLeft = '5' ;
	var status = "no";
	var arguments	= "" ;
	var tit="";

	tit=encodeURIComponent(getLabel("Common.AllergyDetails.label","Common"));
	var features	= "dialogHeight:" + dialogHeight + ";dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    retVal = await top.window.showModalDialog("../../eMR/jsp/RecordPatientAdverseEvent2.jsp?modal_yn=Y&patient_class=EM&patient_id="+patient_id+"&"+params+"&title="+tit,arguments,features);
   // retVal = 	 window.showModalDialog("../../eMR/jsp/RecordPatientAdverseEvent2.jsp?modal_yn=Y&patient_id="+patient_id+"&"+params+"&title="+tit,arguments,features);


}
/**** Added form ViweSecondaryTriage.jsp ****/
function  loadJsp(encounter_id,recd,inc,max)
	{
	    for(var j=0;j<=max-1;j++)
	 	{
			 /* eval('document.getElementById("tddata")'+j).style.backgroundColor='#D8D8D8';*/
	    	eval('document.getElementById("tddata' + j + '").style.backgroundColor="#D8D8D8";');
        }
      /*  eval('document.getElementById("tddata")'+inc).style.backgroundColor='#FFCCFF';*/
	    eval('document.getElementById("tddata' + inc + '").style.backgroundColor="#FFCCFF";');
        var patient_id			=	document.forms[0].patient_id.value;
		var clinic_type			=	document.forms[0].clinic_type.value;
		var clinic_code			=	document.forms[0].clinic_code.value;
		var treatment_area_code	=	document.forms[0].treatment_area_code.value;
		var priority_zone	=	document.forms[0].priority_zone.value;
		var bed_no	=	document.forms[0].bed_no.value;
		var brought_dead = document.forms[0].brought_dead.value;
		var called_from_ca = document.forms[0].called_from_ca.value;
		var fbc_yn = document.forms[0].fbc_yn.value;
		var function_id			=	parent.frames[2].document.forms[0].function_id.value;
		var query_string		=	"patient_id="+patient_id+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&encounter_id="+encounter_id+"&priority_zone="+priority_zone+"&fbc_yn="+fbc_yn+"&rec_date_time="+recd+"&bed_no="+bed_no+"&brought_dead="+brought_dead+"&";
		query_string2  = document.forms[0].queryString.value;
		query_string = query_string+query_string2;
		parent.frames[2].location.href="../../eAE/jsp/AESecondaryTriage.jsp?modify_flag=Y&"+query_string; 
		if(function_id=='query')
		{
		}	 
		else
		{
			parent.TriageButtonsFrame.SecondaryTriageButtonsForm.Record.disabled=true;
		}
	}

function chkOrderCat3(obj)
	{
     if (obj.checked == true)
     {
		document.forms[0].fbc.value=document.forms[0].order_catalog_code3.value;
		document.forms[0].fbc_yn.value='Y';
     }
     else{
	    document.forms[0].fbc.value='';
		document.forms[0].fbc_yn.value='N';

         }
}

async function showCAChart() 
{
	var location_code = document.forms[0].clinic_code.value;
	var patient_id = document.forms[0].patient_id.value;
	var query_string = document.forms[0].params.value;
	var function_id=document.forms[0].function_id.value;
	var modifyYN = document.forms[0].modifyYN.value;
	//alert('modifyYN-->'+modifyYN);
	//var rec_date_time = document.forms[0].rec_date_time.value;
	var rec_date_time = convertDate(document.forms[0].rec_date_time.value,"DMYHMS","en",localeName);
	//alert('rec_date_time-->'+rec_date_time);
	if (rec_date_time=='')
	{
		//rec_date_time = document.forms[0].sys_date_time1.value;
		rec_date_time = convertDate(document.forms[0].sys_date_time1.value,"DMYHM","en",localeName)
	}
	var dialogHeight= "83vh" ;
	var dialogWidth	= "45vw" ;
	var dialogTop ="180";
	var dialogLeft = '210' ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + ";dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    retVal = await top.window.showModalDialog("../../eCA/jsp/ChartRecording.jsp?modifyYN="+modifyYN+"&patient_id="+patient_id+"&function_from=SECONDARY_TRIAGE&patient_class=EM&location_code="+location_code+"&p_start_date_time="+rec_date_time+"&episode_id="+document.forms[0].encounter_id.value+"&encounter_id="+document.forms[0].encounter_id.value+"&facility_id="+document.forms[0].facility_id.value+"&function_id="+function_id,arguments,features);
//alert(retVal)
//parent.frames[2].location.reload();
		//alert(parent.frames[2].document.location.href);
       var query_string = parent.frames[2].document.forms[0].params.value;
        //parent.f_query_add_mod.location.href="../../eAE/jsp/AESecondaryTriage.jsp?"+query_string; //Commented by Dharma against HSA-SCF-0273 [IN:056357]  on Aug 5th 2015 
		
	
}

function onMMove(obj,e,treat,user)
	{
		var page_name = document.forms[0].page_name.value;//Added by santhosh for ML-MMOH-SCF-2384
		var treat1 =treat;
		var user1 =user;
		if(treat=!""){
		obj.style.left=e.x+20;
    //		obj.style.top=e.y; Added by santhosh for ML-MMOH-SCF-2384
		if(page_name==null || page_name=="null" || page_name==""){
			obj.style.top=e.y+105;
		} else {
			obj.style.top=e.y+30;	
		}
		
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;

		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top' style='word-wrap:break-word;width:80px;'>"+treat1+"/"+user1+"</td></tr></table>";
		}
		else
			return false;
	}

function onMOut(obj)
	{
		if(treat=!""){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
	}
	function DummyRef(){
	}


function searchPatient(obj)
{
	 /*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
	 var repDb		= document.forms[0].RepDb.value;
	 var facilityId = document.forms[0].facility_id.value;
	 /*End*/
	 	 if(document.forms[0].referral_id.value!='')
           {
	         if(obj.value!='')	
	         {	
				 // var params =document.forms[0].params.value;
			     var secondaryTriFlag = "Y";
				 var called_from_ca = document.forms[0].called_from_ca.value;
				 var referral_id =document.forms[0].referral_id.value;
				 var patient_id =document.forms[0].patient_id.value;
                 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='form1' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'?<input type='hidden' name='referral_id' id='referral_id' value='"+referral_id+"'><input type='hidden' name='secondaryTriFlag' id='secondaryTriFlag' value='"+secondaryTriFlag+"'><input type='hidden' name='referral_id' id='referral_id' value='"+referral_id+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></BODY></HTML>";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		  		if(called_from_ca!='Y') {
						parent.messageFrame.document.write(HTMLVal);
						parent.messageFrame.document.form1.submit();	  
				} else {
						parent.messageFrame.document.write(HTMLVal);
						parent.messageFrame.document.form1.submit();	
			    }
		      }
	        }
}


async function getReferralID()
{
	var retVal;
	var dialogTop       = "85";
	var dialogHeight    = "39vh" ;
	var dialogWidth     = "65w" ;    
	var arguments       = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
	var arguments   = "" ;
	var assign_care_locn_code =  document.forms[0].clinic_code.value;
	var speciality_code =  document.forms[0].speciality_code.value;
	oth_params = "p_patient_id="+document.getElementById('patient_id').value+"&p_referral_id="+document.getElementById("referral_id").value;
	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_code="+assign_care_locn_code+"&p_calling_function=CHG_REG_DTLS&p_select=YES&p_speciality_code="+speciality_code+"&p_reg_patient=YES&"+oth_params;
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal==null){ retVal="";
	
	document.forms[0].referral_id.value= retVal;
	document.forms[0].referral_id.focus();
	return false;
	}
	else
	{
	document.forms[0].referral_id.value= retVal;
	document.forms[0].referral_id.focus();
	return false;
	}
}

function doDate(obj)
	{
	  if(obj.value != '') 
	  {
		if(!validDate(obj.value,'DMYHM',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			obj.select();
		}
		else
		{
			if((!isBeforeNow(obj.value,'DMYHM',localeName)))
			{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
		document.forms[0].date_time_accident.value="";
		//document.forms[0].date_time_accident.select();
			}
		}
	  }
    }
	
/*--Added by K V Shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->*/
function triageRecordDate(obj)
    {
		var secTrgRecDateTimeList=document.forms[0].secTrgRecDateTimeList.value;
		var secTrgRecDateTimeArr = document.forms[0].secTrgRecDateTimeList.value.split("^");
		if(obj.value != '') {
		 
		if(!validDate(obj.value,'DMYHMS',localeName)) {
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			obj.value="";
			obj.select();
		}else {
			if((!isBeforeNow(obj.value,'DMYHMS',localeName))) {
				alert(getMessage("AE_SEC_TRG_DATE_SYS",'AE') );
				obj.value="";
				obj.select();
			}else if(isBefore(obj.value,secTrgRecDateTimeArr[0],'DMYHMS',localeName)){
						
						alert(getMessage("AE_SEC_TRG_DATE",'AE'));
						obj.value="";
						obj.select();
			}else{
				for(var i=0;i<secTrgRecDateTimeArr.length;i++ ){
				 if(secTrgRecDateTimeArr[i] == obj.value){
					if(i==0){
						alert(getMessage("AE_SEC_TRG_DATE",'AE'));
						obj.value="";
						obj.select(); break;
						}else{
							alert(getMessage("AE_SEC_TRG_DATE_EXISTS",'AE'));
							obj.value="";
							obj.select(); break;
						}
					}
				}
			}
			
		}
	 }

	  document.forms[0].triage_record_date_time.value=obj.value;
	  document.forms[0].triage_record_date_time1.value=obj.value;
    }

/*END*/	
	

async function ChiefComplaints_type()
	{
		var retVal;
		var dialogTop       = "5";
		var dialogHeight    = "80vh" ;
		var dialogWidth = "80vw" ;    
		var arguments   = "" ;
		var center = "1" ;
		var status="no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
		var arguments   = "" ;
		var encounter_id=parent.f_query_add_mod.document.AESecondaryTriage_form.encounter_id.value;
		var url = "../../eAE/jsp/AEPatChiefComplaint.jsp?encounter_id="+encounter_id+"&open_in_modal=Y&displayFrames=YES";
		retVal = await window.showModalDialog(url,arguments,features);
	}
	
	
/*Senthil added AAKH-CRF-0010 [IN038535]*/	
function beforeGetPractitioner(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value=='')
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].attend_pract_id.value="";
			 return;
			}
			/*var prev_pract=document.forms[0].prev_pract_name.value;
			var present_pract=document.forms[0].practitioner_desc.value;
			if(present_pract!="" && prev_pract ==present_pract)
	        {	
		     return;
	        }*/
			aegetPractitioner(obj,target_name);
}
function aegetPractitioner(obj,target)
{  
	var	clinic_code		=	document.forms[0].clinic_code.value;
	var treatment_area_code=document.forms[0].treat_area.value;	
	if(treatment_area_code.indexOf('$$')!= -1){
	var temp=treatment_area_code.split("$$");
	treatment_area_code=temp[0];
	}
			
	var open_to_all_pract_yn = document.forms[0].open_to_all_pract_yn.value;
	//var open_to_all_prac_for_clinic_yn = document.forms[0].open_to_all_prac_for_clinic_yn.value;
	var speciality_code = document.forms[0].speciality_code.value;
	var locale=document.forms[0].locale.value;
	var open_to_all_prac_for_clinic_yn ="";
	var open_to_all_practioners_of_clinic= "";
	var open_to_all_pract_of_treatment_area="";
	var practitioner_type = "";
	
	
	
    open_to_all_pract_of_treatment_area=document.forms[0].open_to_all_prac_for_clinic_yn.value;
    open_to_all_prac_for_clinic_yn=document.forms[0].open_to_all_prac_for_clinic_yn.value;
	open_to_all_practioners_of_clinic = document.forms[0].open_to_all_pract_yn.value;  

	var facility_id			=	document.forms[0].facility_id.value;
	var FirstSql="";
	var SecondSql="";
	var tit="";
	var practitionerName="";
	var practitionerValue="";
		
	target.value=trimString(target.value);
	practitionerName=target.name;
	practitionerValue=target.value;

 
	

	if(document.forms[0].practitioner_id.value == '*ALL')
	{
		document.forms[0].practitioner_id.value = "";
		//document.forms[0].practitioner_desc.value = "";	 Thursday, February 04, 2010
	}

	if(clinic_code!="") {
       if(treatment_area_code!="") {
		if(open_to_all_pract_of_treatment_area=='N'){ 
			if(open_to_all_pract_yn=='N'){
                  document.forms[0].pract_for_workDay_check.value ="Y";
			}
		 }
       }
	}
		   
 
	getPractitioner(obj, target, facility_id, speciality_code,practitioner_type,"Q1",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
	//return; 
	
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~"); 
		document.forms[0].attend_pract_id.value=arr[0];
		// document.forms[0].prev_pract_id.value=arr[0];	
		document.forms[0].practitioner_desc.value=unescape(arr[1]);	
	   
		
	}
	else
	{
		document.forms[0].attend_pract_id.value="";
		document.forms[0].practitioner_desc.value="";	
	   // document.forms[0].prev_pract_name.value="";
		
	}

}

//End AAKH-CRF-0010 [IN038535]
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 Start*/
function FnNotApplicable(){
	alert(getMessage("FUNC_NOT_APPLICABLE","CA"));
}

async function FnProceedRegisterPatientReferral(encounter_id,patient_id){
	var dialogHeight	= '90vh';
	var dialogWidth	= '90vw';
	var dialogTop		= '60';
	var arguments		= ''  ;
	var action_url = "../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter_id+"&Transaction_type=CO&patient_id="+patient_id+"&Module=OP&function_id=RegPatRefFromAEAssessment"; 
	var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;";
	retVal =await top.window.showModalDialog(action_url,arguments,features);
}

async function FnProceedCARecordChart(patient_id,date_time,Chart_Id,episode_id,encounter_id,facility_id){
	var retVal =    new String();
	var dialogHeight= "70vh";
	var dialogWidth = "70vw" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;   
	var action_url	= '../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=AE&p_start_date_time=&Chart_Id='+Chart_Id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id; //Added function_from as AE for IN047838
	
	retVal =await window.showModalDialog(action_url,arguments,features);
}

async function FnProceedClicnicalNotes(patient_id,episode_id,patient_class,function_id,event_class,accession_num,encounter_id,facility_id,USERID){
	var retVal =    new String();
	var dialogHeight= "70vh";
	var dialogWidth = "70vw" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;  
	var title = getLabel('Common.record.label','Common')+ " "+getLabel('Common.ClinicalNotes.label','Common');
	var action_url		=  "../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=CLINICAL_NOTES&title="+title+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close=N&encounter_id="+encounter_id+"&facility_id="+facility_id+"&performed_by_ql="+USERID;
	retVal =await top.window.showModalDialog(action_url,arguments,features);
}

/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 End*/

/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
function enableMandatory(){
	
	/*Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start*/
	var isCaseDtlsRadioBtnAppl = document.forms[0].isCaseDtlsRadioBtnAppl.value;
	if(isCaseDtlsRadioBtnAppl != "true"){/*End*/

			if(document.forms[0].CaseofTrauma.checked==true)
			{		  
			   document.getElementById('mand4').style.visibility='visible';
			}
			else if(document.forms[0].CaseofTrauma.checked==false)
			{		  
			  document.getElementById('mand4').style.visibility='hidden';
			  remVal(document.forms[0].injury);
			}
			if (document.forms[0].oscc_yn.checked == true)
			{
			  document.getElementById('mand5').style.visibility='visible';
			  if( document.forms[0].modify_flag.value !='Y'){
				  //alert('OnLoad mlc disabled 1');
				if(document.forms[0].tick_mlc_if_oscc_checked_yn.value == "Y"){ //Adde by Ajay Hatwate for ML-MMOH-CRF-2103
					document.forms[0].mlc_case_yn.disabled=true;	 
				}
			  }
			}  
			else if (document.forms[0].oscc_yn.checked == false)
			{
			  document.getElementById('mand5').style.visibility="hidden";
			  if( document.forms[0].modify_flag.value !='Y'){
				 document.forms[0].mlc_case_yn.disabled=false;
			  }
			}
	}
	//Added by Ajay Hatwate for ML-MMOH-CRF-2069
	var isSecondaryTriageQueueNum = document.forms[0].isSecondaryTriageQueueNum.value;
	if(isSecondaryTriageQueueNum == "true"){
		var queue_num_mandatory = document.forms[0].queue_num_mandatory.value;
		var hddpriority = document.forms[0].hddpriority.value;
		var queue_appl_priority_zone = document.forms[0].queue_appl_priority_zone.value;
		var queue_secondary_triage = document.forms[0].queue_secondary_triage.value;
		if(queue_num_mandatory == "Y" && hddpriority == queue_appl_priority_zone && queue_secondary_triage == "Y"){
			document.getElementById("queue_no_mand_img").style.visibility = "visible";
		}
	}	
	//End of ML-MMOH-CRF-2069
}
/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

/*Below line added for this CRF ML-MMOH-CRF-0654*/
function setTransMode(obj)
{
	/*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
	 var repDb		= document.forms[0].RepDb.value;
	 var facilityId = document.forms[0].facility_id.value;
	 /*End*/
	var called_from_ca = document.forms[0].called_from_ca.value;
	 if(obj.value!="")
	     {    
	 		  var patient_id		  = document.forms[0].patient_id.value;
			  var transport_mode	  = document.forms[0].transport_mode.value;
			  var modify_flag         = document.forms[0].modify_flag.value
			  if(document.forms[0].modify_flag && document.forms[0].modify_flag.value=="Y"){ 
			  document.forms[0].transport_mode.disabled=true;
			  }
			  var mode_of_arrival = document.forms[0].mode_of_arrival_code.value;
			  
			  if(document.forms[0].modify_flag && document.forms[0].modify_flag.value=="Y" && mode_of_arrival==""){
			  document.forms[0].mode_of_arrival.disabled=true;
			  }			  
			  var transportmodeflag ="ModeOfTransfer";
			  			 
			 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='transport_mode' id='transport_mode' value='"+transport_mode+"'><input type='hidden' name='transportmodeflag' id='transportmodeflag' value='"+transportmodeflag+"'><input type='hidden' name='mode_of_arrival' id='mode_of_arrival' value='"+mode_of_arrival+"'><input type='hidden' name='modify_flag' id='modify_flag' value='"+modify_flag+"'><input type='hidden' name='repDb' id='repDb' value='"+repDb+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></BODY></HTML>";	//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1		 				   
			  
			 
			 if(called_from_ca!="Y"){
				   parent.parent.messageFrame.document.write(HTMLVal);			 
				   parent.parent.messageFrame.visit_form.submit();	
             }else{
				   parent.messageFrame.document.write(HTMLVal);			 
				   parent.messageFrame.visit_form.submit();			 
			 }			 
		 }
	 else
		 {  		 	 
			  if(document.forms[0].modify_flag && document.forms[0].modify_flag.value=="Y") {
				  document.forms[0].transport_mode.disabled=true;
				  document.forms[0].mode_of_arrival.disabled=true;
			  }
  			
		 }
}
//End this CRF ML-MMOH-CRF-0654
/*Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start*/
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
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "block";

		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.disabled=false;
		document.forms[0].police_rep_no1.value="";
		document.forms[0].police_stat_detail.value="";
		document.forms[0].police_rep_no1.disabled=true;
		document.forms[0].police_stat_detail.disabled=true;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.disabled=false;
			document.forms[0].police_rep_no1.disabled=true;
			document.forms[0].police_stat_detail.disabled=true;
			document.forms[0].mlc_death.disabled=true;
			document.forms[0].outside_mlc_dtls.disabled=true;
			document.forms[0].date_of_mlc_capture.disabled=true;
			document.forms[0].mlc_remarks.disabled=true;
			document.forms[0].mlc_case_yn.value="N";
			document.forms[0].police_rep_no1.value="";
			document.forms[0].police_stat_detail.value="";
			document.forms[0].date_of_mlc_capture.value="";
			document.forms[0].outside_mlc_dtls.value="";
			document.forms[0].mlc_death.value="N";
			document.forms[0].mlc_remarks.value="";
		}

		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}else if(caseDtl == "oscc"){
		
		//document.forms[0].mlc_case_yn.checked=true;
		if(document.forms[0].isMLCAppl.value == 'false'){
			if(document.forms[0].tick_mlc_if_oscc_checked_yn.value == 'Y'){
			document.forms[0].mlc_case_yn.checked=true;
			document.forms[0].mlc_case_yn.disabled=true;
			document.forms[0].police_rep_no1.disabled=false;
			document.forms[0].police_stat_detail.disabled=false;
			document.forms[0].police_rep_no1.focus();
			}
		}else{
			if(document.forms[0].tick_mlc_if_oscc_checked_yn.value == 'Y'){
				document.forms[0].mlc_case_yn.checked=true;
				document.forms[0].police_rep_no1.disabled=false;
				document.forms[0].police_stat_detail.disabled=false;
				document.forms[0].mlc_death.disabled=false;
				document.forms[0].outside_mlc_dtls.disabled=false;
				document.forms[0].date_of_mlc_capture.disabled=false;
				document.forms[0].date_of_mlc_capture.value=getCurrentDate("DMYHMS","en");
				document.forms[0].mlc_remarks.disabled=false;
				document.forms[0].police_rep_no1.focus();
			}
		}
		document.forms[0].oscc_yn.value='Y';
		
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
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display		= "none";
		
		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
		
	}else if(caseDtl == "medical"){
		
		document.forms[0].medical_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		remVal(document.forms[0].injury);
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].oscc_yn.value='N';

		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.disabled=false;
		document.forms[0].police_rep_no1.value="";
		document.forms[0].police_stat_detail.value="";
		document.forms[0].police_rep_no1.disabled=true;
		document.forms[0].police_stat_detail.disabled=true;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.disabled=false;
			document.forms[0].police_rep_no1.disabled=true;
			document.forms[0].police_stat_detail.disabled=true;
			document.forms[0].mlc_death.disabled=true;
			document.forms[0].outside_mlc_dtls.disabled=true;
			document.forms[0].date_of_mlc_capture.disabled=true;
			document.forms[0].mlc_remarks.disabled=true;
			document.forms[0].mlc_case_yn.value="N";
			document.forms[0].police_rep_no1.value="";
			document.forms[0].police_stat_detail.value="";
			document.forms[0].date_of_mlc_capture.value="";
			document.forms[0].outside_mlc_dtls.value="";
			document.forms[0].mlc_death.value="N";
			document.forms[0].mlc_remarks.value="";
		}

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "none";
		
		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}else if(caseDtl == "surgical"){
		
		document.forms[0].surgical_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		remVal(document.forms[0].injury);
		document.forms[0].medical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].oscc_yn.value='N';

		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.disabled=false;
		document.forms[0].police_rep_no1.value="";
		document.forms[0].police_stat_detail.value="";
		document.forms[0].police_rep_no1.disabled=true;
		document.forms[0].police_stat_detail.disabled=true;
    		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.disabled=false;
			document.forms[0].police_rep_no1.disabled=true;
			document.forms[0].police_stat_detail.disabled=true;
			document.forms[0].mlc_death.disabled=true;
			document.forms[0].outside_mlc_dtls.disabled=true;
			document.forms[0].date_of_mlc_capture.disabled=true;
			document.forms[0].mlc_remarks.disabled=true;
			document.forms[0].mlc_case_yn.value="N";
			document.forms[0].police_rep_no1.value="";
			document.forms[0].police_stat_detail.value="";
			document.forms[0].date_of_mlc_capture.value="";
			document.forms[0].outside_mlc_dtls.value="";
			document.forms[0].mlc_death.value="N";
			document.forms[0].mlc_remarks.value="";
		}

		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility							= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display		= "none";

		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}else if(caseDtl == "OandG"){
		
		document.forms[0].OandG_yn.value='Y';

		document.forms[0].CaseofTrauma_val.value='N';
		document.getElementById('mand4').style.visibility='hidden';
		document.getElementById('mand5').style.visibility='hidden';
		document.getElementById('placeOfOccurImg').style.visibility='hidden';
		document.getElementById('dateOfOccurImg').style.visibility='hidden';
		remVal(document.forms[0].injury);
		document.forms[0].surgical_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].oscc_yn.value='N';

		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].mlc_case_yn.checked=false;
		document.forms[0].mlc_case_yn.disabled=false;
		document.forms[0].police_rep_no1.value="";
		document.forms[0].police_stat_detail.value="";
		document.forms[0].police_rep_no1.disabled=true;
		document.forms[0].police_stat_detail.disabled=true;
		}else{
			document.forms[0].mlc_case_yn.checked=false;
			document.forms[0].mlc_case_yn.disabled=false;
			document.forms[0].police_rep_no1.disabled=true;
			document.forms[0].police_stat_detail.disabled=true;
			document.forms[0].mlc_death.disabled=true;
			document.forms[0].outside_mlc_dtls.disabled=true;
			document.forms[0].date_of_mlc_capture.disabled=true;
			document.forms[0].mlc_remarks.disabled=true;
			document.forms[0].mlc_case_yn.value="N";
			document.forms[0].police_rep_no1.value="";
			document.forms[0].police_stat_detail.value="";
			document.forms[0].date_of_mlc_capture.value="";
			document.forms[0].outside_mlc_dtls.value="";
			document.forms[0].mlc_death.value="N";
			document.forms[0].mlc_remarks.value="";
		}
		
		document.forms[0].accidentdatetime.value	= '';
		document.forms[0].place_of_accident.value	= '';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "none";

		document.forms[0].injury.value			= "";
		document.forms[0].mechan_injury.value	= "";
	
	}
}
function onLoadCaseDtlsChk(){
	
	var modifyFlag = document.forms[0].modify_flag.value;
	if(document.forms[0].OandG_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display		= "none";
	}else if(document.forms[0].surgical_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display		= "none";
	}else if(document.forms[0].medical_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "none";
	}else if(document.forms[0].oscc_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "visible";
		document.forms[0].osccType.style.visibility									= "visible";
		if(modifyFlag != "Y")
			document.forms[0].osccTypeMandImg.style.visibility						= "visible";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display		= "none";
		var mechInjSubCatCode	= document.forms[0].mech_injr_subcat_code.value;
		var mechInjrCode		= document.forms[0].mech_injr_code.value;
		for(var i=0;i<document.forms[0].osccType.options.length;i++ ){
			var osccTypeArr = document.forms[0].osccType.options[i].value.split(",");
			if(osccTypeArr[0] == mechInjrCode && osccTypeArr[1] == mechInjSubCatCode)
				document.forms[0].osccType.options[i].selected = true;
		}
	}else if(document.forms[0].CaseofTrauma_val.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "block";
		if(modifyFlag != "Y"){
			document.getElementById('mand4').style.visibility='visible';
			document.getElementById('mand5').style.visibility='visible';
			document.getElementById('placeOfOccurImg').style.visibility='visible';
			document.getElementById('dateOfOccurImg').style.visibility='visible';
		}
	}
}
function CheckSpecCharOnKeyPress(event){ 
    var strCheck = ' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1) return false; 
	return true ;
}
/*End*/

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
		if(parent.f_query_add_mod.document.getElementById("trauma"))
		{
			parent.f_query_add_mod.document.getElementById("trauma").checked = true;
			checkCaseOfTraumaButton(parent.f_query_add_mod.document.getElementById("trauma"));
		}
		else if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma)
		{
			parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked = true;
			checkCaseOfTrauma();
		}
	}
}

function checkCaseOfTrauma() {
	if(parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma.checked==true)
	{
	   parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='Y';
	   parent.f_query_add_mod.document.AESecondaryTriage_form.mand4.style.visibility='visible';
	}
	else
	{
	  parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='N';
	  parent.f_query_add_mod.document.AESecondaryTriage_form.mand4.style.visibility='hidden';
	  remVal(parent.f_query_add_mod.document.AESecondaryTriage_form.injury);
	}
}

function checkCaseOfTraumaButton(obj){
	var caseDtl = obj.id;
	parent.f_query_add_mod.document.AESecondaryTriage_form.mand4.style.visibility='hidden';
	if(caseDtl == "trauma"){
		parent.f_query_add_mod.document.AESecondaryTriage_form.CaseofTrauma_val.value='Y';
		parent.f_query_add_mod.document.AESecondaryTriage_form.mand4.style.visibility='visible';
		parent.f_query_add_mod.document.AESecondaryTriage_form.mand5.style.visibility='visible';
		parent.f_query_add_mod.document.AESecondaryTriage_form.placeOfOccurImg.style.visibility='visible';
		parent.f_query_add_mod.document.AESecondaryTriage_form.dateOfOccurImg.style.visibility='visible';
		parent.f_query_add_mod.document.AESecondaryTriage_form.oscc_yn.value='N';
		parent.f_query_add_mod.document.AESecondaryTriage_form.medical_yn.value='N';
		parent.f_query_add_mod.document.AESecondaryTriage_form.surgical_yn.value='N';
		parent.f_query_add_mod.document.AESecondaryTriage_form.OandG_yn.value='N';
		parent.f_query_add_mod.document.AESecondaryTriage_form.osccType.value = '';
		parent.f_query_add_mod.document.getElementById("osccTypeLabel").style.visibility = "hidden";
		parent.f_query_add_mod.document.AESecondaryTriage_form.osccType.style.visibility = "hidden";
		parent.f_query_add_mod.document.AESecondaryTriage_form.osccTypeMandImg.style.visibility = "hidden";
		parent.f_query_add_mod.document.getElementById("placeOfOccMechInjFieldsDisplay").style.display	= "block";
		parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.checked=false;
		parent.f_query_add_mod.document.AESecondaryTriage_form.mlc_case_yn.disabled=false;
		parent.f_query_add_mod.document.AESecondaryTriage_form.police_rep_no1.value="";
		parent.f_query_add_mod.document.AESecondaryTriage_form.police_stat_detail.value="";
		parent.f_query_add_mod.document.AESecondaryTriage_form.police_rep_no1.disabled=true;
		parent.f_query_add_mod.document.AESecondaryTriage_form.police_stat_detail.disabled=true;
		parent.f_query_add_mod.document.AESecondaryTriage_form.injury.value	= "";
		parent.f_query_add_mod.document.AESecondaryTriage_form.mechan_injury.value	= "";
	}
}
/*End ML-MMOH-CRF-1409*/
//Added by Ajay Hatwate for GHL-CRF-0650
function validateMlcCapture(obj){
	var fromDate = document.forms[0].visit_adm_date_time.value;
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
//Added by Ajay Hatwate for ML-MMOH-CRF-2111
function setDisasterType(obj)
{
	 if(obj.value!='')
	     { 
			 var disaster_category_flag = "Y";
			 var disaster_category_code  = document.forms[0].disaster_category.value;
			 var HTMLVal = "<HTML><head><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><BODY onKeyDown = 'lockKey()'><form name='disaster_type_form' id='disaster_type_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='disaster_category_code' id='disaster_category_code' value='"+disaster_category_code+"'><input type='hidden' name='disaster_category_flag' id='disaster_category_flag' value='"+disaster_category_flag+"'><input type='hidden' name='checkFlag' id='checkFlag' value='AE_SEC_TRIAGE'></form></BODY></HTML>"; 
			 parent.messageFrame.document.write(HTMLVal);
			 parent.messageFrame.disaster_type_form.submit();
		 }
}

//Added by Ajay Hatwate for ML-MMOH-CRF-2069
function validateQueueNo(obj){
	if(obj.value != ""){
		var q_num = parseInt(obj.value, 10);
			if (q_num > 0) {
			
			var queue_max_num_allowed 	 = parseInt(parent.f_query_add_mod.document.AESecondaryTriage_form.queue_max_num_allowed.value);
			if(obj.value.length > queue_max_num_allowed){
				var error = getMessage('MAX_QUEUE_DIGIT_ALLOWED', 'AE');//'Maximum Number of Digits allowed for Queue Number is $'; //getMessage('QUEUE_NO_DUPLICATE','AE');
				error = error.replace('$', queue_max_num_allowed);	
				alert(error);
		    	obj.value = "";
			}else{
			var queue_no  = obj.value;
			var encounter_id = document.forms[0].encounter_id.value;
			var facility_id = document.forms[0].facility_id.value;
			var sec_triage_queue_no_appl = document.forms[0].isSecondaryTriageQueueNum.value;			
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH queue_no=\""+queue_no+"\" encounter_id=\""+encounter_id+"\" action='VALIDATE_SEC_TRIAGE_QUEUE_NO' /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			if(responseText != "0"){
				var error = getMessage('QUEUE_NO_DUPLICATE','AE');
		    	alert(error);
		    	obj.value = '';
			}else{
				document.forms[0].queue_no.value = obj.value;
			}
		  }
	    } else {
	    	var error = getMessage('MIN_VALUE_1','AE');
	    	alert(error);
	    	obj.value = '';
	    }
	}
}
	
async function callSecQueueAudit(){
	
	var dialogHeight = "16vh";
	var dialogWidth  = "40vw";
	var dialogTop    = "50";
	var status 		 = "no";
	var arguments 	 = "" ;			
	var patient 	 = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var features 	 = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var jsp_name;
	jsp_name 		 = "../../eAE/jsp/ViewSecTriageQueueAuditTrail.jsp?patient_id=" + patient + "&encounter_id="+encounter_id;			
	retVal 			 =await window.showModalDialog(jsp_name,arguments,features);
}


//Added by Krishna Pranay ML-MMOH-CRF-1759.1 start

async function viewMenstrualHistoryDtl(function_id, encounter_id, patient_id,patient_gender,year_value)
{
	var calledForm = "PAS_TRANSCATION_INVOKING";
	var dialogTop	= "65";
	var dialogHeight= "35vh" ; 
	var dialogWidth	= "80vw" ;	
	var status		= "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCA/jsp/CAMenstrualHistoryDtlMain.jsp?function_id="+function_id+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&Sex="+patient_gender+"&Age="+year_value+"&called_form="+calledForm,arguments,features);
	if (retVal) {
        // Assign values to individual variables
		var lmpDate = retVal.lmpDate;
		var gestationPoaWeek = retVal.gestationPoaWeek;
        var gestationPoaDays = retVal.gestationPoaDays;
        var eddDate = retVal.eddDate;
        var lmpDeliveryMiscarrageType = retVal.lmpDeliveryMiscarrageType;
        var lmpDeliveryMiscarrageDate = retVal.lmpDeliveryMiscarrageDate;
        var error_remarks = retVal.error_remarks;
        if((lmpDeliveryMiscarrageType!="" && lmpDeliveryMiscarrageDate!="") || (error_remarks!=undefined && error_remarks!="")){
        	document.getElementById("lmp_date").disabled =false;
             document.getElementById("lmp_calendar").disabled =false;
             document.getElementById("mand2").style.display = "none";
             document.forms[0].pregnant_at_present_yn_val.checked=false;
              document.forms[0].pregnant_at_present_yn_val.disabled =false;
              document.getElementById('lmpdate').value = ""; // Corrected ID to 'lmpdate'
              document.getElementById('nmdesig').innerHTML = "";
              document.getElementById('nmdesig1').innerHTML = "";
              document.getElementById('eddesig').innerHTML = "";
              document.getElementById("mensHistHyperLinkDisplay").style.display = "none";
              document.getElementById('lmplabel').style.visibility='visible';
            document.getElementById('lmpdate').style.visibility='visible';
          	document.getElementById('lmpdate1').style.display = "none";
          	document.getElementById('lmplabel1').style.display = "none";
          	document.getElementById('lmp_calendar1').style.display = "none";
          	document.getElementById('lmp_calendar').style.visibility='visible';
        	document.getElementById('Lmpinputfield').style.display = "none";
        	document.getElementById('lmplabel').style.display="inline";
          	document.getElementById('lmp_calendar').style.display='inline';
        	document.getElementById("lmp_date").style.display='inline';


       }
        else{
        	document.getElementById("lmpdate1").disabled =true;
            document.getElementById("lmp_calendar1").disabled =true;
            document.forms[0].pregnant_at_present_yn_val.checked=true;
             document.forms[0].pregnant_at_present_yn_val.disabled =true;
             document.getElementById('lmpdate1').value =lmpDate; // Corrected ID to 'lmpdate'
             document.getElementById('lmpdate2').value =lmpDate; // Corrected ID to 'lmpdate'
             document.getElementById('nmdesig').innerHTML =gestationPoaWeek;
             document.getElementById('nmdesig1').innerHTML = gestationPoaDays;
             document.getElementById('eddesig').innerHTML =eddDate;
             document.getElementById("mensHistHyperLinkDisplay").style.display = "inline";
             document.getElementById("mensHistHyperLinkDisplay").innerHTML = "View/Modify Menstrual History Details";
         	document.getElementById('lmpdate1').style.display = "inline";
         	document.getElementById('lmplabel1').style.display = "inline";
         	document.getElementById('lmp_calendar1').style.display = "inline";
          	document.getElementById('lmp_calendar').style.display='none';
        	document.getElementById('Lmpinputfield').style.display = "inline";
        	document.getElementById("lmp_date").disabled =true;
        	document.getElementById("lmp_date").style.display='none';
            document.getElementById("lmp_calendar").disabled =true;
            document.getElementById("mand2").style.display = "none";
            document.getElementById('lmplabel').style.display="none";


        }

    } 
}


async function menstHistDtl(patient_id, facility_id)
{
	var dialogHeight= "15vh" ;
    var dialogWidth = "100vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlResultView.jsp?patient_id="+patient_id+"&facility_id="+facility_id,arguments,features);
}s


function calculateEDD1()
{
	  if(document.getElementById('lmpdate1')) {
		if(document.getElementById('lmpdate1').value == null || document.getElementById('lmpdate1').value == "" || document.getElementById('lmpdate1').value == null || document.getElementById('lmpdate1').value == ""||document.getElementById('pregnant_at_present_yn_val').checked==false){
		document.getElementById('eddesig').innerHTML=""	
		return;
		}
		var todate  = document.forms[0].sysdate.value;
		var fromdate = convertDate(document.getElementById('lmpdate1').value,"DMY",localeName,"en");
	    if(fromdate!=null &&todate!=null)
		{
		 if(fromdate.length > 0 && todate.length > 0 ) {
          fromarray = fromdate.split("/");
          toarray = todate.split("/");
          var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
          var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
          if(Date.parse(todt) < Date.parse(fromdt)) {
			document.getElementById('eddesig').innerHTML='';
			return false;
			}
			else{
             	from=fromdate;
				
				var splitdate  =from.split("/")
				var edd         = new Date(splitdate[2],splitdate[1]-1,splitdate[0]);
				edd.setTime(edd.getTime()+1000 * 60 * 60 * 24 * parseInt(7));
				edd.setMonth(edd.getMonth()+eval(09))
			       	var date= ""+edd.getDate()+"";
			
				var month= ""+parseInt(edd.getMonth()+1)+"";
				var hours= ""+edd.getHours()+"";
				var minutes= ""+edd.getMinutes()+"";
				if(date.length == 1)
					date="0"+date;
				if(month.length == 1)
					month="0"+month;
				if(hours.length == 1)
					hours="0"+hours;
				if(minutes.length == 1)
					minutes="0"+minutes;
				var finalDt="";

				finalDt += date + "/";
				finalDt += month + "/";
				finalDt += edd.getYear();
		    	var eddDate1    = convertDate(finalDt,"DMY","en",localeName);
				document.getElementById('eddesig').innerHTML=eddDate1;


				
		  }
		 }
		}
	  }
}
	function calculateNoOfDays1()
	{
		if(document.getElementById('lmpdate1')) {
		if(document.getElementById('lmpdate1').value == null || document.getElementById('lmpdate1').value == "" || document.getElementById('lmpdate1').value == null || document.getElementById('lmpdate1').value == ""||document.getElementById('pregnant_at_present_yn_val').checked==false)
			return;

		var from = convertDate(document.getElementById('lmpdate1').value,"DMY",localeName,"en");
		var to   = document.getElementById('visit_date_time').value;	
		
		var a=  from.split(" ")
		splitdate=a[0];
      var splitdate1 =splitdate.split("/")
		
		var dateFrom  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
  
		a=  to.split(" ")
		splitdate=a[0]; 
		splitdate1 =splitdate.split("/")
		var dateTo  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
		
		var toMilliSeconds=dateTo.getTime();
		
    
		var fromMilliSeconds=dateFrom.getTime();
	
			var MinMilli = 1000 * 60;
          var HrMilli = MinMilli * 60;
          var DAY = HrMilli * 24;

		var week =(Math.floor(((toMilliSeconds-fromMilliSeconds)/DAY))/7);

		var weeks =Math.floor(week);
		var days =  (Math.round(((toMilliSeconds-fromMilliSeconds)/DAY))%7);
		if(weeks<0 ||days<0)
		{
			return false;
		}
		document.getElementById('nmdesig').innerHTML=weeks;
		document.getElementById('nmdesig1').innerHTML=days;
		return;
		}
	}
//Added by Krishna Pranay ML-MMOH-CRF-1759.1 end

