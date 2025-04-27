


/*Called onLoad of the header page containf event type ind,event type,allergen*/


function disable()
{
	 
	if(document.forms[0].mode.value=="record"){
		var exp_val = document.forms[0].exposure1.value;
		if(exp_val=="1" || exp_val=="2" || exp_val=="3" || exp_val=="4")
			document.forms[0].route_exp.options[exp_val].selected = true;
		else if(exp_val=="U")
			document.forms[0].route_exp.options[5].selected = true;

		var source_info = document.forms[0].source_of_info.value;

		if(source_info=="P")
			document.forms[0].pat_obser.checked=true;
		else if(source_info=="A")
			document.forms[0].aller_test.checked=true;
		else if(source_info=="S")
			document.forms[0].Staff_obser.checked=true;

		if(document.forms[0].certainity.value=="Definitive")
		{
			document.forms[0].definit.checked=true;
			document.forms[0].probable.checked=false;
			document.forms[0].definit.disabled=false;
			document.forms[0].probable.disabled=false;
		}else if(document.forms[0].certainity.value=="Probable")
		{
			document.forms[0].probable.checked=true;
			document.forms[0].definit.checked=false;
		}

		if(document.forms[0].adv_event_type_ind_code.value=="01" )
		{

			document.forms[0].adv_event_ind.checked=true;
			document.forms[0].adv_event_ind_one.checked=false;
			document.forms[0].adv_event_ind_two.checked=false;
			document.forms[0].adv_event_ind_three.checked=false;
		}else if(document.forms[0].adv_event_type_ind_code.value=="02")
		{
			document.forms[0].adv_event_ind.checked=false;
			document.forms[0].adv_event_ind_one.checked=true;
			document.forms[0].adv_event_ind_two.checked=false;
			document.forms[0].adv_event_ind_three.checked=false;
		}else if(document.forms[0].adv_event_type_ind_code.value=="03")
		{
			document.forms[0].adv_event_ind.checked=false;
			document.forms[0].adv_event_ind_one.checked=false;
			document.forms[0].adv_event_ind_two.checked=true;
			document.forms[0].adv_event_ind_three.checked=false;
		}else if(document.forms[0].adv_event_type_ind_code.value=="04")
		{
			document.forms[0].adv_event_ind.checked=false;
			document.forms[0].adv_event_ind_one.checked=false;
			document.forms[0].adv_event_ind_two.checked=false;
			document.forms[0].adv_event_ind_three.checked=true;
		}
		document.forms[0].onset_date.disabled=true;
		document.forms[0].diagnosis.disabled=true;
		document.forms[0].cause_diag_search.disabled=true;

	
			document.forms[0].adv_event_ind.disabled=true;
			
		
	}
	if(document.forms[0].mode.value =="modify")
	{
		if(document.forms[0].certainity.value=="Definitive")
		{
			document.forms[0].definit.checked=true;
			document.forms[0].probable.checked=false;
			document.forms[0].definit.disabled=true;
			document.forms[0].probable.disabled=true;

		}else if(document.forms[0].certainity.value=="Probable")
		{
			document.forms[0].probable.checked=true;
			document.forms[0].definit.checked=false;
			document.forms[0].definit.disabled=true;
			document.forms[0].probable.disabled=true;
		}
			document.forms[0].diagnosis.disabled=true;
			document.forms[0].cause_diag_search.disabled=true;
			document.forms[0].date_time.disabled=true;
			document.forms[0].all.date_time_cal.disabled=true;
			document.forms[0].adv_event_ind.disabled=true;
			
			var PatientId=document.forms[0].PatientId.value;
			var causative_code=document.forms[0].causative_code.value;

			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH causative_code=\""+causative_code+"\" PatientId=\""+PatientId+"\" steps='5'/></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			document.forms[0].onset_date.disabled=true;
			
	}
	else if(document.forms[0].mode.value=="insert")
	{   
	    parent.frames[3].document.forms[0].allergyAlertby.disabled=false;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].cal2.disabled=false;
		load_event_type('01');
	}
	
}
	function ok_values()
{

	document.forms[0].submit();
}


/*Enabling and disabling of adv event type based on adv event type ind selected */
function populate_event_type(obj,maxlength)
{
	
	var adv_evnt_ind=obj.value;
	document.forms[0].adv_evnt_ind.value=obj.value;
	if(adv_evnt_ind !="")
	{
		document.forms[0].adv_event_type.disabled=false;
	}else
	{
		document.forms[0].adv_event_type.disabled=true;
		parent.frames[4].document.forms[0].cause_subs.innerHTML="<textarea name='cause_sub'  maxlength='25' rows='1' style='resize: none;' cols='85' value='' >";
		document.forms[0].allergen.value="";
		document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
	}
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH ADV_EVENT_TYPE_IND=\""+adv_evnt_ind+"\" steps='2'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)	
}

/*population of adv event type based on adv event type ind selected onload*/
function load_event_type(obj)
{
	var isOthAllergenAppl = parent.frames[3].document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751
	var adv_evnt_ind=obj;
	var allergy_conf_reqd_yn=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;//Added for the CRF - RUT-CRF-0064
	
	document.forms[0].adv_evnt_ind.value=obj;
	/*Added for the CRF RUT-CRF-0064 -- Begin*/
	if(allergy_conf_reqd_yn=='Y'){
		var AllergyConfirmYN=parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value;
		if(AllergyConfirmYN=='Y'){
			parent.frames[3].document.forms[0].no_known_allergy.checked=false;
			parent.frames[3].document.forms[0].no_known_allergy.disabled=true;
		}else{
			parent.frames[3].document.forms[0].no_known_allergy.checked=true;
			parent.frames[3].document.forms[0].no_known_allergy.disabled=true;
		}
	}
	/*Added for the CRF RUT-CRF-0064 -- End*/
	if(adv_evnt_ind !="")
	{
		//modified for SCR 3896	PMG20089-CRF-0083 on 16-09-2008
		if(parent.frames[3].document.forms[0].known_allergy.value==0 || allergy_conf_reqd_yn=='Y')//Condition modified for the CRF - RUT- CRF- 0064
		{
			if(parent.frames[3].document.forms[0].no_known_allergy.checked==true)
			{
			parent.frames[3].document.forms[0].allergyAlertby.disabled=true
			parent.frames[3].document.forms[0].onset_date.disabled=true
			parent.frames[3].document.forms[0].adv_event_type.disabled=true
			parent.frames[3].document.forms[0].eventdtlsID.disabled=true
			parent.frames[3].document.forms[0].cal2.disabled=true
			parent.frames[3].document.forms[0].adv_event_ind.disabled=true;
			parent.frames[3].document.forms[0].adv_event_ind_one.disabled=true;
			parent.frames[3].document.forms[0].adv_event_ind_two.disabled=true;
			parent.frames[3].document.forms[0].adv_event_ind_three.disabled=true;
			parent.frames[3].document.forms[0].allergen.disabled=true;
			/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true")
				parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			/*End*/
			parent.frames[3].document.forms[0].cause_sub.disabled=true;
			parent.frames[3].document.forms[0].estimated_duration.disabled=true;
			parent.frames[3].document.forms[0].b_days.disabled=true;
			parent.frames[3].document.forms[0].b_months.disabled=true;
			parent.frames[3].document.forms[0].b_age.disabled=true;

			parent.frames[4].document.forms[0].add_reaction.disabled=true;
			
			parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
			parent.frames[5].document.forms[0].definit.disabled=true;
			parent.frames[5].document.forms[0].probable.disabled=true;
			parent.frames[5].document.forms[0].diagnosis.disabled=true;
			parent.frames[5].document.forms[0].route_exp.disabled=true;
			parent.frames[5].document.forms[0].pat_obser.disabled=true;
			parent.frames[5].document.forms[0].aller_test.disabled=true;
			parent.frames[5].document.forms[0].Staff_obser.disabled=true;
			parent.frames[5].document.forms[0].allergy_test_res.disabled=true;
			parent.frames[5].document.forms[0].treat_advice.disabled=true;
			parent.frames[5].document.forms[0].remarks.disabled=true;
			parent.frames[5].document.forms[0].active.disabled=true;
			parent.frames[5].document.forms[0].date_time.disabled=true;
			}else
			{	
				
				if(parent.frames[4].document.forms[0] != null){
				parent.frames[4].document.forms[0].add_reaction.disabled=true;
				parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
				}
			}
		}
		else
		{
			if(parent.frames[4].document.forms[0]!= null)
			{
					
				parent.frames[4].document.forms[0].add_reaction.disabled=true;
				parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
			}
				document.forms[0].adv_event_type.disabled=false;
		
		}
		
	}else
	{
		
		document.forms[0].adv_event_type.disabled=true;
		parent.frames[4].document.forms[0].all.cause_subs.innerHTML="<textarea name='cause_sub'  maxlength='25' style='resize: none;'rows='1' cols='85' value='' >";
		document.forms[0].allergen.value="";
		document.forms[0].allergen.disabled=true;
		/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			document.forms[0].allergen_free_text.value="";
			document.forms[0].allergen_free_text.disabled=true;
		}/*End*/
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[4].document.forms[0].reac_caused.disabled=true;
	}
	
	/*var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()*/
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH ADV_EVENT_TYPE_IND=\""+adv_evnt_ind+"\" steps='2'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)	
}
	
	// Added Recusive function to avoid script error for IN023609 on 03.08.2010 by Suresh M
	function setReactionDate(){ 
		if(parent.frames[4].document.forms[0]){
			if(parent.frames[4].document.forms[0].count_val.value==""){
				var countvalue=parent.frames[4].document.forms[0].count_val.value;
				for (var i=0;i<=countvalue-1 ;i++ ){
					eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[1]+""+sysdate_time;
				}
			}
			if(parent.frames[4].document.forms[0].oth_reaction_counter.value==""){
				var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
				for (var i=0;i<=oth_reaction_counter-1 ;i++ ){
					eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[1]+""+sysdate_time;
				}
			 }
		 }else{			 
			setTimeout('setReactionDate()',10);
		 }
	}

/*Enabling and disabling of allergen look up based on adv event type selected and also
changing the causitive sub innerhtml dynamically*/
	

function populate_allergen(obj)
{	
	var isOthAllergenAppl = document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751
	var adv_evnt_code1=obj.value;
	// Added By Sridhar Reddy on 01/03/2010
	var onSetDate = parent.frames[3].document.forms[0].onset_date.value
    onSetDate = onSetDate.substring(0,10);
	var retVal = "A^"+onSetDate+"^D^ ^ ^P^ ^ ^ ";	
	parent.frames[3].document.forms[0].retVal.value = retVal;
	parent.frames[3].document.forms[0].reactCodes3.value = "";
	if(retVal != "")
		{
			mode ="insert";
/**/	var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
		var sysdate_time		= sysdate.substring(10,16);
		parent.frames[3].document.forms[0].changeonsetflag.value = "N";
		arr=retVal.split("^")
		parent.frames[3].document.forms[0].event_status.value=arr[0];
		if(arr[0] != 'E')
		{
			if(arr[1]=="dd"){
				parent.frames[3].document.forms[0].since_date.value="";
			}else{
				parent.frames[3].document.forms[0].since_date.value=arr[1];
			}
			 parent.frames[3].document.forms[0].event_certainty.value=arr[2];
			 parent.frames[3].document.forms[0].event_diag.value=arr[3];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[4];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[5];
			 parent.frames[3].document.forms[0].event_observation.value=arr[6];
			 parent.frames[3].document.forms[0].event_advice.value=arr[7];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[8];
			/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] , to change reaction date and onset date as per Active Since Date*/
			 setReactionDate();		
		 
			/*oth_reaction_counter*/
		}
		else
		{

			  parent.frames[3].document.forms[0].event_err_remark.value=arr[1];
			  if(arr[1]=="dd"){
				  parent.frames[3].document.forms[0].since_date.value="";
			  }else{
				  parent.frames[3].document.forms[0].since_date.value=arr[2];
			  }
			
			 parent.frames[3].document.forms[0].event_certainty.value=arr[3];
			 parent.frames[3].document.forms[0].event_diag.value=arr[4];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[5];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[6];
			 parent.frames[3].document.forms[0].event_observation.value=arr[7];
			 parent.frames[3].document.forms[0].event_advice.value=arr[8];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[9];
			 //parent.frames[3].document.forms[0].onset_date.value=arr[1]+""+onset_datetime
			 if(parent.frames[4].document.forms[0].count_val)
				{
					var countvalue=parent.frames[4].document.forms[0].count_val.value;
					for (var i=0;i<=countvalue-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[2]+""+sysdate_time;
					}
				}
				if(parent.frames[4].document.forms[0].oth_reaction_counter)
				{
					var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
					for (var i=0;i<=oth_reaction_counter-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[2]+""+sysdate_time;
					}
				}
			 
		}
/**/

	if(arr[0] != 'A')
	{
		parent.frames[4].document.getElementById("add_resc").style.visibility='hidden';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;			
	}
	else
	{
		if(mode != "insert")
		{
			if(parent.frames[4].document.getElementById("add_resc"))

			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
		}
		
		if(arr[1] != "" && arr[1]!='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#9999FF';
		}else if(arr[1]=='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#BD6981';
	}
}



	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH details = \""+encodeURIComponent(retVal)+"\" steps='9'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}
	//End
	
	if(adv_evnt_code1 !="")
	{	
		
		parent.frames[3].document.forms[0].allergen.disabled=false;
		parent.frames[3].document.forms[0].allergen.value="";
		/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
		var advEventCodeSplit = adv_evnt_code1.split('|');
		var advEventCode	  = advEventCodeSplit[0];
		if(isOthAllergenAppl == "true"){ 
			if(advEventCode != "DA"){
				parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
				parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'visible';
				parent.frames[3].document.forms[0].allergen_free_text.value="";
				parent.frames[3].document.forms[0].allergen_free_text.disabled=false;
			}else{
				parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
				parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'hidden';
				parent.frames[3].document.forms[0].allergen_free_text.value="";
				parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			}
		}/*End*/
		parent.frames[3].document.forms[0].allergyAlertby.value="N";//added  for [IN:046096] 
		parent.frames[3].document.forms[0].drug_search.disabled=false;
		parent.frames[3].document.forms[0].react_values.value="";
		if(parent.frames[4].document.forms[0] != null){
		parent.frames[4].document.forms[0].allergen.disabled=false;
		parent.frames[4].document.forms[0].allergen.value="";
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
		parent.frames[3].document.forms[0].allergen_id.value = "";
		if(isOthAllergenAppl == "true"){
			if(advEventCode != "DA"){
				parent.frames[4].document.forms[0].allergen_free_text.value="";
				parent.frames[4].document.forms[0].allergen_free_text.disabled=false;
			}else{
				parent.frames[4].document.forms[0].allergen_free_text.value = "";
				parent.frames[4].document.forms[0].allergen_free_text.disabled = true;
			}
		}/*End*/
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		}
		parent.Headerpage.document.search_form.onset_date.value=parent.Headerpage.document.search_form.sysDate.value;
		parent.Headerpage.document.search_form.b_days.value="";
		parent.Headerpage.document.search_form.b_months.value="";
		parent.Headerpage.document.search_form.b_age.value="";
		
		if(parent.frames[4].document.forms[0]!=null)
		{
					
			if(parent.frames[3].document.forms[0].allergen.value=="" || parent.frames[3].document.forms[0].allergen_free_text.value=="")//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
				{
				
			parent.frames[4].document.forms[0].add_reaction.disabled=true;
			
			parent.frames[4].document.forms[0].add_reaction_search.disabled
				=true;
			parent.Headerpage.document.search_form.estimated_duration.checked=false;
			parent.Headerpage.document.search_form.estimated_duration.value="N";
			parent.frames[3].document.forms[0].onset_date.disable=false
			
			parent.Headerpage.document.search_form.onset_date.value=parent.Headerpage.document.search_form.sysDate.value;
			parent.Headerpage.document.search_form.b_days.disabled=true;
			parent.Headerpage.document.search_form.b_days.value="";
			parent.Headerpage.document.search_form.b_months.disabled=true;
			parent.Headerpage.document.search_form.b_months.value="";
			parent.Headerpage.document.search_form.b_age.disabled=true;
			parent.Headerpage.document.search_form.b_age.value="";
			parent.Headerpage.document.getElementById("clock").style.visibility="hidden";
			
			}
			
			var PatientId=	parent.frames[3].document.forms[0].PatientId.value;
			var Encounter_Id=	parent.frames[3].document.forms[0].Encounter_Id.value
			var allergen=parent.frames[3].document.forms[0].allergen.value
			
	/*Below line added for this CRF Bru-HIMS-CRF-133*/
	  var isPatientEncMovement=parent.frames[3].document.forms[0].isPatientEncMovement.value;
      var Sydate=parent.frames[3].document.forms[0].Sydate.value;
	  var p_queue_date=parent.frames[3].document.forms[0].p_queue_date.value;
	  var p_queue_status=parent.frames[3].document.forms[0].p_queue_status.value;
	//End Bru-HIMS-CRF-133
			setTimeout('EventFrame()',50);
		/*Below line modified for this CRF Bru-HIMS-CRF-133*/	
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&allergen_blank="+parent.frames[3].document.forms[0].allergen.value+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
		parent.frames[4].document.forms[0].add_reaction.disabled=true;

			parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
			setTimeout('EventFrameDisable()',50);

			

		}
		

	}else
	{
		
		clear_page();
		
	}
	adv_evnt_code1=adv_evnt_code1.split('|');
	var adv_evnt_code=adv_evnt_code1[0];
	if(adv_evnt_code=="DA")
	{
		parent.frames[3].document.getElementById('cause_subs').innerHTML='<input type="text" name="cause_sub" id="cause_sub" maxlength="100"   size="28" disabled value="" onblur="open_cause_subs_lup()" onkeypress="return CheckForSpecChars_spec(event);" onkeyup="return checkMaxLength(this);"><input type="button" class="button" name="cause_sub_search" id="cause_sub_search" disabled value="?" onclick="open_cause_subs_lup()"><img id="Causative_sub" align="center"  style="visibility:hidden"  src="../../eCommon/images/mandatory.gif"></img>';		//parent.frames[3].document.forms[0].all.cause_subs.innerHTML="<input type='text' name='cause_sub' id='cause_sub' maxlength='100' size='28' disabled value='' onblur='open_cause_subs_lup()' onkeypress='return CheckForSpecChars_spec(event);' onkeyup='return checkMaxLength(this);'><input type='button' class='button' name='cause_sub_search' id='cause_sub_search' disabled value='?' onclick='open_cause_subs_lup()'>";
	}else

	{
		parent.frames[3].document.getElementById('cause_subs').innerHTML='<textarea name="cause_sub"  maxlength="100" style="resize: none;" rows="1" cols="25" value="" onkeypress="return CheckForSpecChars_spec(event);" onkeyup="return checkMaxLength(this);" disabled></textarea><img  id="Causative_sub" align="center" style="visibility:hidden" src="../../eCommon/images/mandatory.gif"></img>';
	}
}
function EventFrameDisable(){
	if(parent.frames[4].document.forms[0]!= null){
	       parent.frames[4].document.forms[0].add_reaction.disabled=true;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
	}
}

/*Function called on click of allergen and based on adv event type is not drug or not its respective lookup's r called*/
function open_lookup(obj)
{ 
	//Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1
	var facility_id = document.forms[0].facility_id.value;
	var isExtGenericAppl = document.forms[0].isExtGenericAppl.value;
	var sPhInstalled_YN = document.forms[0].sPhInstalled_YN.value;
	var adv_evnt_code1=document.forms[0].adv_event_type.value;
	adv_evnt_code1=adv_evnt_code1.split('|');
	var adv_evnt_code=adv_evnt_code1[0];	
	
	if(adv_evnt_code=="DA")
	{
		/*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr = "<root><SEARCH facility_id=\""+facility_id+"\" action='getDrugCnt'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var drug_cnt = trimString(responseText);

		if(drug_cnt > 0 && sPhInstalled_YN == "Y" && isExtGenericAppl == "true")
		{
			callAllergenSearch(obj);
		}else
		{
			callGenericSearch(obj);
		}
		/*End GHL-CRF-0614.1*/
	}else
	{
		callotherSearch(obj);
	}

	

}

/*LookUp called on click of Allergen search if adv event type is not drug*/
async function callotherSearch(obj)
{      
	
		var adv_evnt_code1=document.forms[0].adv_event_type.value;
		adv_evnt_code1=adv_evnt_code1.split('|');
		var adv_evnt_code=adv_evnt_code1[0];
		var adv_evnt_val= document.forms[0].adv_evnt_ind.value;
		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var isOthAllergenAppl = document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751
		
		//var sql="select b.ALLERGEN_CODE code ,b.LONG_DESC description  from  MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b, MR_ADV_EVENT_TYPE c where a.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and c.ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"' and b.language_id='"+locale+"' and upper(b.ALLERGEN_CODE) like upper(?) and upper(b.LONG_DESC) like upper(?)   Order by b.LONG_DESC ";
		
		//Commented by Ashwini on 28-Apr-2021 for MOHE-SCF-0025
		//var sql="select b.ALLERGEN_CODE code ,b.LONG_DESC description  from  MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b, MR_ADV_EVENT_TYPE c where a.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and c.ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"' and b.language_id='"+locale+"' and b.ADV_EVENT_TYPE_IND=a.ADV_EVENT_TYPE_IND  and c.ADV_EVENT_TYPE_CODE = b.ADV_EVENT_TYPE_CODE and upper(b.ALLERGEN_CODE) like upper(?) and upper(b.LONG_DESC) like upper(?)   Order by b.LONG_DESC ";

		var sql = "SELECT b.allergen_code code, b.long_desc description FROM mr_adv_event_type_ind a, mr_allergen_lang_vw b, mr_adv_event_type c WHERE a.adv_event_type_ind = '"+adv_evnt_val+"' AND c.adv_event_type_code = '"+adv_evnt_code+"' AND b.language_id = '"+locale+"' AND b.adv_event_type_ind = a.adv_event_type_ind AND c.adv_event_type_code = b.adv_event_type_code AND UPPER (b.allergen_code) LIKE UPPER (?) AND UPPER (b.long_desc) LIKE UPPER (?) ORDER BY b.long_desc " ;

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].allergen.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;  
		/*Added by Thamizh selvi on 19th Dec 2017 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			argumentArray[10] = "C";
			argumentArray[11] = "DefaultSearchCriteria";
		}/*End*/
        		
		retVal = await CommonLookup( getLabel("eMR.Allergen.label","MR"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{     
			var retVal=unescape(retVal);              
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			
			document.forms[0].allergen.value=desc;
			document.forms[0].allergen_id.value=code;
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true"){
				document.forms[0].allergen_free_text.value="";
				document.forms[0].allergen_free_text.disabled=true;
				document.forms[0].free_txt_mand.style.visibility='hidden';
			}/*End*/
			if(parent.frames[4].document.forms[0]!=null)
			{
				parent.frames[4].document.forms[0].add_reaction.disabled=false;
				parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
			}
			document.forms[0].cause_sub.value="";
			document.forms[0].cause_sub.disabled=false;
			
		}else
		{
			document.forms[0].allergen.value="";
			document.forms[0].allergen_id.value="";
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true"){
				document.forms[0].allergen_free_text.value="";
				document.forms[0].allergen_free_text.disabled=false;
				document.forms[0].free_txt_mand.style.visibility='visible';
			}/*End*/
			parent.frames[4].document.forms[0].reaction_value.value="";
			
			if(parent.frames[4].document.forms[0]!=null)
			{
				parent.frames[4].document.forms[0].add_reaction.disabled=true;
				parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
			}
			document.forms[0].cause_sub.value="";
			document.forms[0].cause_sub.disabled=true;
		}
		
}

/*LookUp called on click of Allergen search if adv event type is drug*/

async function callGenericSearch(obj)
{


		var adv_evnt_code1=document.forms[0].adv_event_type.value;
		adv_evnt_code1=adv_evnt_code1.split('|');
		var adv_evnt_code=adv_evnt_code1[0];
		var adv_evnt_val= document.forms[0].adv_evnt_ind.value;
		var locale=document.forms[0].locale.value;

		var isOthAllergenAppl = document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		// Below EFF_STATUS='E' Condition Added for Against SCF RUT-SCF-0105 [IN:032249]
		//var sql="select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW WHERE EFF_STATUS='E'UNION select ALLERGEN_CODE code, LONG_DESC || '**' description  from  MR_ALLERGEN_LANG_VW  where ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and LANGUAGE_ID='"+locale+"' and ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"'AND EFF_STATUS='E') where upper(code) like upper(?) and upper(ltrim(description,'*')) like upper(?) ";
		//Below SQL is changed to remove ** for against TTM-SCF-0107 - Start

		var sPhInstalled_YN=document.forms[0].sPhInstalled_YN.value;
		var sql ="";
		
		//Commented by Ashwini on 28-Apr-2021 for MOHE-SCF-0025
		//if(sPhInstalled_YN == "Y")
			//sql="SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW WHERE upper(generic_id) like upper(?) AND upper(ltrim(generic_name,'*')) like upper(?) AND EFF_STATUS='E' AND language_id = '"+locale+"'";
		//else
			//sql = "select ALLERGEN_CODE code, LONG_DESC description  from  MR_ALLERGEN_LANG_VW  where upper(ALLERGEN_CODE) like upper(?) AND upper(ltrim(LONG_DESC,'*')) like upper(?) AND ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and LANGUAGE_ID='"+locale+"' and ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"'AND EFF_STATUS='E' ";

		if(sPhInstalled_YN == "Y")
			sql = "SELECT generic_id code, generic_name description FROM ph_generic_name_lang_vw WHERE UPPER (generic_id) LIKE UPPER (?) AND UPPER (LTRIM (generic_name)) LIKE UPPER (?) AND eff_status = 'E' AND language_id = '"+locale+"' " ;
		else
			sql = "SELECT allergen_code code, long_desc description FROM mr_allergen_lang_vw WHERE UPPER (allergen_code) LIKE UPPER (?) AND UPPER (LTRIM (long_desc)) LIKE UPPER (?) AND adv_event_type_ind = '"+adv_evnt_val+"' AND language_id = '"+locale+"' AND adv_event_type_code = '"+adv_evnt_code+"' AND eff_status = 'E' " ;

		//Modified against TTM-SCF-0107 - end

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].allergen.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ;       
		/*Added by Thamizh selvi on 19th Dec 2017 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			argumentArray[10] = "C";
			argumentArray[11] = "DefaultSearchCriteria";
		}/*End*/
		retVal = await CommonLookup(getLabel("Common.GenericNameLookup.label","Common"), argumentArray );
        
		
	
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null"){

			var retVal=unescape(retVal);
		   	 arr=retVal.split(",");
	         var arr_desc=arr[1];
//Modified against TTM-SCF-0107 - Commented the below extraction as "**" is not appended in the above query.
/*if(arr_desc.indexOf("**") !=-1)
{
	arr_desc=arr_desc.substring(0,arr_desc.length-2);
}else
{
}*/
		    document.forms[0].allergen.value=arr_desc;
			document.forms[0].allergen_id.value=arr[0];
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true"){
				document.forms[0].allergen_free_text.value="";
				document.forms[0].allergen_free_text.disabled=true;
				document.forms[0].free_txt_mand.style.visibility='hidden';
			}/*End*/
			document.forms[0].cause_sub.disabled=false;
			document.forms[0].cause_sub_search.disabled=false;
			
			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
		}else{
			document.forms[0].allergen.value="";
			document.forms[0].allergen_id.value="";
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true"){
				if(adv_evnt_code != "DA"){
					document.forms[0].allergen_free_text.value="";
					document.forms[0].allergen_free_text.disabled=false;
					document.forms[0].free_txt_mand.style.visibility='visible';
				}else{
					document.forms[0].allergen_free_text.value="";
					document.forms[0].allergen_free_text.disabled=true;
					document.forms[0].free_txt_mand.style.visibility='hidden';
				}
			}/*End*/
			document.forms[0].cause_sub.value="";
			document.forms[0].cause_sub.disabled=true;
			document.forms[0].cause_sub_search.disabled=true;
			
			parent.frames[4].document.forms[0].add_reaction.disabled=true;
			
			parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		}
	
	}	


/*Called on change of radio button from def to pro or viceversa*/
function change_val(obj)
{
	var sel_va=obj.value;
	if(sel_va =="D")
	{
		document.forms[0].probable.checked=false;
	}else{
		document.forms[0].definit.checked=false;
	}
}

function change_val_status(obj)
{
var sel_val=obj.value;
if(sel_val=="A")
{
	document.forms[0].active.checked=true;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=false;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=false;
	
	parent.frames[5].document.getElementById("error_reason").style.display='none';
	parent.frames[5].document.getElementById("error_reason").style.visibility='hidden';
	document.forms[0].status1.value="A";


}else if (sel_val=="R")
{
	document.forms[0].active.checked=false;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=true;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=false;
	parent.frames[5].document.getElementById("error_reason").style.display='none';
	parent.frames[5].document.getElementById("error_reason").style.visibility='hidden';
	document.forms[0].status1.value="R";
	if(parent.frames[3].document.forms[0].mode.value=="record")
	{
	}
}else if (sel_val=="E")
{
	document.forms[0].active.checked=false;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=false;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=true;
	parent.frames[5].document.getElementById("error_reason").style.display='Inline';
	parent.frames[5].document.getElementById("error_reason").style.visibility='visible';
	document.forms[0].status1.value="E";
	if(parent.frames[3].document.forms[0].mode.value=="record")
	{
		////10/23/2008 8:25 PM
parent.frames[4].document.forms[0].add_resc.style.visibility	='hidden';
	
	}
}
}
function change_val_status1(obj)
{
var sel_val=obj.value;
if(sel_val=="A")
{
	document.forms[0].active.checked=true;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=false;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=false;
	
	document.getElementById("error_reason").style.display='none';
	document.getElementById("error_reason").style.visibility='hidden';
	document.forms[0].status1.value="A";
	document.getElementById("modify_date").value=document.getElementById("reaction_date1").value;

}else if (sel_val=="R")
{
	document.forms[0].active.checked=false;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=true;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=false;
document.getElementById("error_reason").style.display='none';
	document.getElementById("error_reason").style.visibility='hidden';
	document.forms[0].status1.value="R";
	document.getElementById("modify_date").value=document.getElementById("sysdate").value;
	
	if(document.forms[0].mode.value=="record")
	{
		
		document.forms[0].status1.style.visibility='visible';
	}
}else if (sel_val=="E")
{
	document.forms[0].active.checked=false;
	if(document.forms[0].resolve!=null)
		document.forms[0].resolve.checked=false;
	if(document.forms[0].inerror!=null)
		document.forms[0].inerror.checked=true;
	document.getElementById("error_reason").style.display='Inline';
	document.getElementById("error_reason").style.visibility='visible';
	document.forms[0].status1.value="E";
	document.getElementById("modify_date").value=document.getElementById("sysdate").value;

	if(document.forms[0].mode.value=="record")
	{

document.forms[0].status1.style.visibility='visible';
	
	}
}
}

function change_val_allergy(obj)
{	
	var isOthAllergenAppl = parent.frames[3].document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751
	var sel_val=obj.value;
	var blank=" ";

	var PatientId=	parent.frames[3].document.forms[0].PatientId.value;
	var Encounter_Id=	parent.frames[3].document.forms[0].Encounter_Id.value
	
	if(sel_val=="01")
	{ 
		document.forms[0].adv_event_ind.checked=true;
		document.forms[0].adv_event_ind_one.checked=false;
		document.forms[0].adv_event_ind_two.checked=false;
		document.forms[0].adv_event_ind_three.checked=false; 
		document.forms[0].adv_evnt_ind.value='01';
		document.forms[0].allergen.value='';
		document.forms[0].cause_sub.value='';
		document.forms[0].estimated_duration.checked=false;
		parent.frames[3].document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].cal2.disabled=false;
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */ 
		parent.frames[3].document.forms[0].onset[0].checked=true;
		parent.frames[3].document.forms[0].comments.value="";
		/*end ML-MMOH-CRF-0366 */
		parent.frames[4].document.forms[0].add_reaction.value='';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){ 
			document.forms[0].allergen_free_text.value='';
			parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
			parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'visible';
		}/*End*/
		enable_dmy();
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;

	}else if (sel_val=="02")
	{
		document.forms[0].adv_event_ind_one.checked=true;
		document.forms[0].adv_event_ind.checked=false;
		document.forms[0].adv_event_ind_two.checked=false;
		document.forms[0].adv_event_ind_three.checked=false;
		document.forms[0].adv_evnt_ind.value='02';
		document.forms[0].allergen.value='';
		document.forms[0].cause_sub.value='';
		document.forms[0].estimated_duration.checked=false;
		parent.frames[3].document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].cal2.disabled=false;
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		parent.frames[3].document.forms[0].onset[0].checked=true;
		parent.frames[3].document.forms[0].comments.value="";
		/*end ML-MMOH-CRF-0366 */
		parent.frames[4].document.forms[0].add_reaction.value='';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){ 
			document.forms[0].allergen_free_text.value='';
			parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
			parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'visible';
		}/*End*/
		enable_dmy();
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;
	}else if (sel_val=="03")
	{
		document.forms[0].adv_event_ind_two.checked=true;
		document.forms[0].adv_event_ind_one.checked=false;
		document.forms[0].adv_event_ind.checked=false;
		document.forms[0].adv_event_ind_three.checked=false;
		document.forms[0].adv_evnt_ind.value='03';
		document.forms[0].allergen.value='';
		document.forms[0].cause_sub.value='';
		document.forms[0].estimated_duration.checked=false;
		parent.frames[3].document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].cal2.disabled=false;
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		parent.frames[3].document.forms[0].onset[0].checked=true;
		parent.frames[3].document.forms[0].comments.value="";
		/*end ML-MMOH-CRF-0366 */
		parent.frames[4].document.forms[0].add_reaction.value='';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){ 
			document.forms[0].allergen_free_text.value='';
			parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
			parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'visible';
		}/*End*/
		enable_dmy();
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;
	}else if (sel_val=="04")
	{
		document.forms[0].adv_event_ind_three.checked=true;
		document.forms[0].adv_event_ind_one.checked=false;
		document.forms[0].adv_event_ind_two.checked=false;
		document.forms[0].adv_event_ind.checked=false;
		document.forms[0].adv_evnt_ind.value='04';
		document.forms[0].allergen.value='';
		document.forms[0].cause_sub.value='';
		document.forms[0].estimated_duration.checked=false;
		parent.frames[3].document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].drug_search.disabled=true;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].all.cal2.disabled=false;
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		parent.frames[3].document.forms[0].onset[0].checked=true;
		parent.frames[3].document.forms[0].comments.value="";
		/*end ML-MMOH-CRF-0366 */
		parent.frames[4].document.forms[0].add_reaction.value='';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){ 
			document.forms[0].allergen_free_text.value='';
			parent.frames[3].document.forms[0].allergen_free_text.disabled=true;
			parent.frames[3].document.forms[0].adv_code_allerg.style.visibility = 'visible';
			parent.frames[3].document.forms[0].free_txt_mand.style.visibility = 'visible';
		}/*End*/
		enable_dmy();
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;
	}
	var adv_evnt_ind= document.forms[0].adv_evnt_ind.value;
	//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	//var xmlHttp = new XMLHttpRequest()
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH ADV_EVENT_TYPE_IND=\""+adv_evnt_ind+"\" steps='2'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)	
}

/*Called on selection of allergen to enable and disable reaction button*/

function enable_reaction(obj)

{  
	var isOthAllergenAppl = document.search_form.isOthAllergenAppl.value;//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
	if(obj.value !="")
	{
			var PatientId=document.search_form.PatientId.value;
			var allergen=obj.value.split("|");
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			var causative_code = "";
			if(isOthAllergenAppl == "true"){
				if(obj.name == "allergen_free_text")
					causative_code = "Oth";
				else 
					causative_code=document.search_form.allergen_id.value;
			}else{/*End*/
				causative_code=document.search_form.allergen_id.value;
			}
			var adv_ind="";
			
			if(document.search_form.adv_event_ind.checked==true)
			{
				adv_ind="01";
			}else if (document.search_form.adv_event_ind_one.checked==true)
			{
				adv_ind="02"; 
			}else if (document.search_form.adv_event_ind_two.checked==true)
			{
				adv_ind="03";
			}else if (document.search_form.adv_event_ind_three.checked==true)
			{
				adv_ind="04";
			}
			var adv_type1=document.search_form.adv_event_type.value;
			adv_type1=adv_type1.split("|");
			var adv_type=adv_type1[0];
            
			/*to chk if any record already exists for the combination of pat_id,ind,type,causitive_code(allergen)*/

			/*var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
			var xmlHttp = new XMLHttpRequest()*/
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH causative_code=\""+causative_code+"\" PatientId=\""+PatientId+"\" adv_ind =\""+adv_ind+"\" adv_type=\""+adv_type+"\" steps='5'/></root>"
			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			
			if(parent.frames[3].document.forms[0].mode.value =="insert")
			{   
				if(parent.frames[3].document.forms[0].flag_val.value =="Y")
				{   
					alert(getMessage("COMBINATION_NOT_ALLOWED","MR"));
					document.search_form.allergen.value="";
					obj.focus();
					parent.frames[4].document.forms[0].add_reaction.disabled=true;
					parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
					/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
					document.search_form.allergen_id.value="";
					parent.frames[4].document.forms[0].reaction_value.value="";
					parent.frames[4].document.forms[0].react_code_final.value="";
					parent.frames[3].document.forms[0].react_values.value="";
					if(isOthAllergenAppl == "true"){
						if(adv_type != "DA"){
							document.search_form.allergen_free_text.value="";
							document.search_form.allergen_free_text.disabled=false;
							document.search_form.free_txt_mand.style.visibility='visible';
						}else{
							document.search_form.allergen_free_text.value="";
							document.search_form.allergen_free_text.disabled=true;
							document.search_form.free_txt_mand.style.visibility='hidden';
						}
					}/*End*/
				}
			}

	}else
	{
		
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		
		parent.frames[4].document.forms[0].reaction_value.value="";
		parent.frames[4].document.forms[0].react_code_final.value="";
		parent.frames[3].document.forms[0].react_values.value="";
		
	}
	
	
	
	

	
}

/*Called on click of Reaction Button*/

async function callreactionSearch()
{   
	
	var i = '0';
	var reac_desc;
	var event_done="onClick";
	var flag='';
	var reac_code_val_prev='';
	var adv_event_ind='';
	var adv_event_type='';
	var react_val=parent.frames[3].document.forms[0].react_values.value;

	var mode=parent.frames[3].document.forms[0].mode.value;
	var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	var allergen;
	var oth_reaction=document.forms[0].oth_reaction.value;
	var status=document.forms[0].status.value;
	var reaction_date;
	var count_val=parent.frames[4].document.forms[0].count_val.value;
	var onset_date1=parent.frames[4].document.forms[0].onset_date1.value;
	var adv_event_type_ind_code1=parent.frames[4].document.forms[0].adv_event_type_ind_code1.value;
	var adv_reac_code=parent.frames[4].document.forms[0].adv_reac_code.value;
	var oth_reaction_counter = parent.frames[4].document.forms[0].oth_reaction_counter.value;	
	var oldreactionvalue_count=parent.frames[4].document.forms[0].oldreactionvalue_count.value;	    
	var final_total ='';
	var final_total_temp ='';
	var final_total_oth ='';
	var severity ;
	var Site_Of_Reac ;
	/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] ,to display reaction date as active since date , same added in query criteria*/
	 /*Below line added for this CRF Bru-HIMS-CRF-133*/
	  var isPatientEncMovement=parent.frames[3].document.forms[0].isPatientEncMovement.value;
      var Sydate=parent.frames[3].document.forms[0].Sydate.value;
	  var p_queue_date=parent.frames[3].document.forms[0].p_queue_date.value;
	  var p_queue_status=parent.frames[3].document.forms[0].p_queue_status.value;
	//End Bru-HIMS-CRF-133

	var isOthAllergenAppl = parent.frames[3].document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751

	if(mode =="insert")
	{
		if(parent.frames[3].document.forms[0].since_date.value == "")
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].onset_date.value;
			var	addReactionDate1	= addReactionDate.substring(0,16);
		}
		else
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].since_date.value;
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}
	}else
	{
		if(parent.frames[3].document.forms[0].since_date.value == "")
		{
			var	addReactionDate		= convertDate(parent.frames[3].document.forms[0].reaction_date.value,"DMY","en",localeName);
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}
		else
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].since_date.value;
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}	
	}
	if(mode =="insert")
	{	
		if(count_val != 0){  
			for(var i = 0 ; i<= count_val-1 ; i++)
			{ 
				/*Wednesday, December 23, 2009 , to check reaction date mandatory*/
				if(eval("parent.frames[4].document.forms[0].reaction_date"+i+".value") == "")
				{
					var error1;
					error1=getMessage("CAN_NOT_BE_BLANK","common");
					error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error1);
					return false;
				}else
				{   
					var code = parent.frames[4].document.forms[0]["reaction_code" + i].value;
						var a = parent.frames[4].document.forms[0]["reac_desc" + i].value;
           var b = parent.frames[4].document.forms[0]["reaction_date" + i].value;
				var c = parent.frames[4].document.forms[0]["severity" + i].value;

						if(c == "")
						c="~";
					var d = eval("parent.frames[4].document.forms[0].Site_Of_Reac"+i+".value")
					if(d == "")	
					d="~";
					
				//	final_total += a+"^"+b+"^"+c+"^"+d+"!";
				    
					final_total += code+"^"+a+"^"+b+"^"+c+"^"+d+"!";
					
				}
				
			}
		}
		if(oth_reaction_counter != 0){
			
			for(var i = 0 ; i<= oth_reaction_counter-1 ; i++)
			{
				/*Wednesday, December 23, 2009 , to check reaction date mandatory*/
				if (parent.frames[4].document.forms[0]["other_reaction_date" + i].value === "") 
  // Your code here


				{
					var error2;
					error2=getMessage("CAN_NOT_BE_BLANK","common");
					error2=error2.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error2);
					return false;
				}
				else
				{
					var e = parent.frames[4].document.forms[0]["oth_reac_desc" + i].value;
					var f = parent.frames[4].document.forms[0]["other_reaction_date" + i].value;
					var g = parent.frames[4].document.forms[0]["severity_oth" + i].value;
						if(g == "")
						g="~";
					var h = parent.frames[4].document.forms[0]["Site_Of_Reac_oth" + i].value;
					if(h == "")	
					h="~";
					
					final_total_oth += e+"^"+f+"^"+g+"^"+h+"!";
				}
				
			}
		}
		
	}
	var final_total_record="";
	var final_total_oth_record="";
	
	if(mode=="record"){
       /*get the previous Reaction added by Senthil on 16-08-2011*/	
		var oldreactionvalue_count=parent.frames[4].document.forms[0].oldreactionvalue_count.value;		
		if(oldreactionvalue_count!=0){
		var reactcode="";
		for(var m=0; m<=oldreactionvalue_count-1;m++){
		     reactcode += parent.frames[4].document.forms[0]["adv_reac_event_code" + m].value + "`";
		 
		}
	      reactcode=reactcode.substring(0,reactcode.length-1);		 
		}		
		if(count_val != 0){		   
			for(var i = 0 ; i<= count_val-1 ; i++)
			{ 		   
				if(eval("parent.frames[4].document.forms[0].reaction_date"+i+".value") == "")
				{
					var error1;
					error1=getMessage("CAN_NOT_BE_BLANK","common");
					error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error1);
					return false;
				}else
				{   
				   var code = parent.frames[4].document.forms[0]["reaction_code" + i].value;
					var a = parent.frames[4].document.forms[0]["reac_desc" + i].value;
					var b = parent.frames[4].document.forms[0]["reaction_date" + i].value;
					var c = parent.frames[4].document.forms[0]["severity" + i].value;
						if(c == "")
						c="~";
					var d = eval("parent.frames[4].document.forms[0].Site_Of_Reac"+i+".value")
					if(d == "")	
					d="~";					
					final_total_record +=code+"^"+a+"^"+b+"^"+c+"^"+d+"!";	
                    			
				}
				
			}
		}
		 if(oth_reaction_counter != 0){
			
			for(var i = 0 ; i<= oth_reaction_counter-1 ; i++)
			{
				if (parent.frames[4].document.forms[0]["other_reaction_date" + i].value === "")
				{
					var error2;
					error2=getMessage("CAN_NOT_BE_BLANK","common");
					error2=error2.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error2);
					return false;
				}else
				{
					var e = parent.frames[4].document.forms[0]["oth_reac_desc" + i].value;
					var f = parent.frames[4].document.forms[0]["other_reaction_date" + i].value;
					var g = parent.frames[4].document.forms[0]["severity_oth" + i].value;
						if(g == "")
						g="~";
					var h = parent.frames[4].document.forms[0]["Site_Of_Reac_oth" + i].value;
					if(h == "")	
					h="~";
					
					final_total_oth_record += e+"^"+f+"^"+g+"^"+h+"!";
				}
				
			}
		}
			

	}

	
	
	if(mode =="insert"){
		/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			if(parent.frames[3].document.forms[0].allergen_id.value == "" && parent.frames[3].document.forms[0].allergen_free_text.value != "")
				allergen = "Oth";
			else
				allergen=parent.frames[3].document.forms[0].allergen_id.value;
		}else{/*End*/
			allergen=parent.frames[3].document.forms[0].allergen_id.value;
		}
	}else{
		allergen=parent.frames[3].document.forms[0].causative_code.value;
		reac_code_val_prev=parent.frames[1].document.forms[0].final_reac_code_val.value;		
		adv_event_ind=parent.frames[1].document.forms[0].adv_event_type_ind_code.value;
		adv_event_type=parent.frames[3].document.forms[0].adv_event_type_code.value;
		
		
	}
	var patient_id=parent.frames[3].document.forms[0].PatientId.value;
	var Encounter_Id=parent.frames[3].document.forms[0].Encounter_Id.value;
	var reactCodes3 = parent.frames[3].document.forms[0].reactCodes3.value;
	
	var dialogHeight= "85vh" ;
	var dialogTop = "15" ;
	var dialogWidth	= "85vw" ;
	var status1 = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status1  + "; dialogTop :" + dialogTop ;
	var callurl="../../eMR/jsp/RecordPatientAdverseEvent3.jsp?mode="+mode+"&allergen="+allergen+"&react_val="+react_val+"&flag="+flag+"&patient_id="+patient_id+"&adv_event_ind="+adv_event_ind+"&adv_event_type="+adv_event_type+"&oth_reaction="+encodeURIComponent(oth_reaction)+"&event_done="+event_done+"&status="+status+"&reactCodes3="+reactCodes3+"&reactcode="+reactcode+"&oldreactionvalue_count="+oldreactionvalue_count+" "; 
	
	if(mode=="record"){
	       reac_code_val_prev=reactcode;
	 }	   
		   
	var retVal = new String();
	retVal = await window.showModalDialog(callurl,arguments,features);  	
	if(retVal !=undefined && retVal!="")
	{ 
		parent.frames[3].document.forms[0].react_values.value=retVal;
		var reactCodes3Split = retVal.split('`');
		parent.frames[3].document.forms[0].reactCodes3.value=reactCodes3Split[0];
		/*var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
		var xmlHttp = new XMLHttpRequest()	*/	
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH retVal=\""+retVal+"\" allergen=\""+allergen+"\" reac_code_val_prev=\""+reac_code_val_prev+"\" patient_id=\""+patient_id+"\" adv_event_ind=\""+adv_event_ind+"\" adv_event_type=\""+adv_event_type+"\" final_total=\""+final_total+"\" steps='8'/></root>"	
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")		
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText);
      
//Painting of reaction part happens over hre

		if(parent.parent.workAreaFrame!=null)
		{
			
			
			parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,6%,1%,10%,5%,0%,5%";//Modified for the CRF - RUT-CRF-0064
			/*parent.document.getElementById('resultpage').style.height = "30vh";
			parent.document.getElementById('resultpage1').style.height = "10vh";
			parent.document.getElementById('staticcolorpage').style.height = "3vh";
			parent.document.getElementById('Headerpage').style.height = "25vh";
			parent.document.getElementById('reaction_details_page').style.height = "10vh";
			parent.document.getElementById('detail_view').style.height = "0vh";
			parent.document.getElementById('submitframe').style.height = "10vh";
			parent.document.getElementById('messageFrame').style.height = "6vh";*/
		
		}
		else
		{
				
			
			//parent.document.getElementById("allergy_recording").rows='15%,6%,1%,11%,5%,0%,5%,2%';//Modified for the CRF - RUT-CRF-0064
			
			parent.document.getElementById('resultpage').style.height = "26vh";
			parent.document.getElementById('resultpage1').style.height = "15vh";
			parent.document.getElementById('staticcolorpage').style.height = "1vh";
			parent.document.getElementById('Headerpage').style.height = "29vh";
			parent.document.getElementById('reaction_details_page').style.height = "12vh";
			parent.document.getElementById('detail_view').style.height = "0vh";
			parent.document.getElementById('detail_view').style.display = "none";
			parent.document.getElementById('submitframe').style.height = "4vh";
			parent.document.getElementById('messageFrame').style.height = "6vh";
			
		}   
			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;			

		if(parent.parent.workAreaFrame!=null)
			parent.parent.workAreaFrame.document.getElementById("reaction_details_page").style.visibility='visible';
		else
			parent.document.getElementById("reaction_details_page").style.visibility='visible';
		

		var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	    

		var reac_desc_val=parent.frames[4].document.forms[0].reaction_value.value;
		
		var PatientId=parent.frames[3].document.forms[0].PatientId.value;
       
		if(parent.frames[3].document.forms[0].mode.value =="insert")
		{   			
			var	causative_code=parent.frames[3].document.forms[0].allergen_id.value;
			
			/*Below line modified for this CRF Bru-HIMS-CRF-133*/
			
			var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?final_total_oth="+final_total_oth+"&final_total="+final_total+"&mode=insert&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&causative_code="+causative_code+"&adv_event_type_code="+adv_event_type+"&Encounter_Id="+Encounter_Id+"&status="+status+"&reaction_date_disply="+encodeURIComponent(addReactionDate1)+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
		 
			var url6="../../eMR/jsp/RecordPatientAdverseEvent9.jsp"
	
		}else
		{   
			var final_total=final_total_record;
			var final_total_oth=final_total_oth_record;				
			var	causative_code=parent.frames[3].document.forms[0].causative_code.value;
			
             /*Below line modified for this CRF Bru-HIMS-CRF-133*/			
			var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?final_total_oth="+final_total_oth+"&final_total="+final_total+"&mode=record&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&status="+status+"&onset_date="+encodeURIComponent(onset_date1)+"&adv_event_type_ind_code="+adv_event_type_ind_code1+"&adding_react_yn=Y&reaction_date_disply="+encodeURIComponent(addReactionDate1)+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
			
			var url6="../../eMR/jsp/RecordPatientAdverseEvent9.jsp";
		  	
		
		}   
		   
			parent.frames[4].location.href=url;			
			parent.frames[6].location.href=url6;
			
		}else
		{ 
		
			if(parent.frames[3].document.forms[0].mode.value =="insert")
				{ 
	
					
				if(parent.parent.workAreaFrame!=null)
					{
					
						parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,6%,1%,11%,5%,0%,5%";//Modified for the CRF - RUT-CRF-0064
					}
				else
					
					{ 
						
							/*Thursday, August 27, 2009  */
					//parent.document.getElementById("allergy_recording").rows="7.4%,6%,1%,7%,5%,0%,5%,2%";
					//parent.document.getElementById("allergy_recording").rows="10%,6%,1%,11%,5%,0%,5%,2%";
					parent.document.getElementById('resultpage').style.height = "26vh";
					parent.document.getElementById('resultpage1').style.height = "15vh";
					parent.document.getElementById('staticcolorpage').style.height = "3vh";
					parent.document.getElementById('Headerpage').style.height = "29vh";
					parent.document.getElementById('reaction_details_page').style.height = "5vh";
					parent.document.getElementById('detail_view').style.height = "0vh";
					parent.document.getElementById('detail_view').style.display = "none";
					parent.document.getElementById('submitframe').style.height = "4vh";
					parent.document.getElementById('messageFrame').style.height = "6vh";
					parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
					if(parent.frames[4].document.getElementById("add_reac") != null)
					parent.frames[4].document.getElementById("add_resc").style.visibility='visible';
					//parent.frames[3].document.forms[0].react_values.value="";
					}
				
			
				//parent.frames[3].document.forms[0].react_values.value=parent.frames[4].document.forms[0].react_code_final.value;
		 
		if(retVal!=undefined){
			  parent.frames[4].document.forms[0].react_code_final.value = "";
			  parent.frames[4].document.forms[0].reac_desc_val.value = "";
			  parent.frames[3].document.forms[0].reactCodes3.value="";
			  parent.frames[3].document.forms[0].react_values.value="";
			  parent.frames[6].document.forms[0].markerror.style.visibility='visible';
		}
		// Ends
		      var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	     	  var reac_desc_val=parent.frames[4].document.forms[0].reac_desc_val.value;
			  var PatientId=parent.frames[3].document.forms[0].PatientId.value;
  			  var	causative_code=parent.frames[3].document.forms[0].allergen_id.value;		 

				//var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode='"+parent.frames[3].document.forms[0].mode.value+"&adv_event_type_code="+adv_event_type+"&onset_date="+encodeURIComponent(onset_date1)+"&adv_event_type_ind_code="+adv_event_type_ind_code1+" ";
				var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?final_total_oth="+final_total_oth+"&final_total="+final_total+"&mode=insert&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&causative_code="+causative_code+"&adv_event_type_code="+adv_event_type+"&Encounter_Id="+Encounter_Id+"&status="+status+"&reaction_date_disply="+encodeURIComponent(addReactionDate1)+" ";
				parent.frames[4].location.href=url;
				}else{ 				
				if(parent.parent.workAreaFrame!=null){				
				  parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,15%,20%,0,5%";	
				}else{					
				  parent.document.getElementById("allergy_recording").rows="7%,6%,1%,11%,5%,0%,5%,2%";				
				}
				  parent.frames[4].document.forms[0].add_reaction.disabled=false;
				  parent.frames[4].document.forms[0].add_reaction_search.disabled=false;	
				
         		/*Clear the Record when Uncheck the checkbox in lookup windows*/		
		       if(retVal!=undefined && retVal==""){			  
			     parent.frames[4].document.forms[0].reac_desc_val.value = "";
			     parent.frames[3].document.forms[0].reactCodes3.value="";
			     parent.frames[3].document.forms[0].react_values.value="";
			     parent.frames[6].document.forms[0].markerror.style.visibility='visible';
		      }

				var PatientId=parent.frames[3].document.forms[0].PatientId.value;
				var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
				var reac_desc_val=parent.frames[4].document.forms[0].reac_desc_val.value;
				var	causative_code=parent.frames[3].document.forms[0].causative_code.value;
				var	otr_reaction=parent.frames[4].document.forms[0].otr_reaction.value;
				
				var final_total=final_total_record;
				var final_total_oth=final_total_oth_record;
	
				//var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=record&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&status="+status+"&onset_date="+encodeURIComponent(onset_date1)+"&adv_event_type_ind_code="+adv_event_type_ind_code1+"&otr_reaction="+encodeURIComponent(otr_reaction)+" ";

				var	causative_code=parent.frames[3].document.forms[0].causative_code.value;

				var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?final_total_oth="+final_total_oth+"&final_total="+final_total+"&mode=record&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&status="+status+"&onset_date="+encodeURIComponent(onset_date1)+"&adv_event_type_ind_code="+adv_event_type_ind_code1+"&adding_react_yn=N&reaction_date_disply="+encodeURIComponent(addReactionDate1)+"&otr_reaction="+encodeURIComponent(otr_reaction)+"";
							
				parent.frames[4].location.href=url;

		}
	}	
}

/*Called onclick of Source Of Info hre dynamically the labels r getting changed*/
function change_val_two(obj)
{
	var sel_va=obj.value;

	if(sel_va =="P")
	{
		document.forms[0].Staff_obser.checked=false;
		document.forms[0].aller_test.checked=false;
		
		document.getElementById("aller_test_results").innerText=getLabel("eMR.PatientObservation.label","MR");
	}else if(sel_va =="A"){
		document.forms[0].Staff_obser.checked=false;
		document.forms[0].pat_obser.checked=false;
		
		document.getElementById("aller_test_results").innerText=getLabel("eMR.AllergyTestResult.label","MR");

	}else if(sel_va =="S")
	{
		document.forms[0].aller_test.checked=false;
		document.forms[0].pat_obser.checked=false;
		
		document.getElementById("aller_test_results").innerText=getLabel("eMR.StaffObservation.label","MR");

	}
}

/*Called on click of Select all in Reaction search*/
function selectAll_S(obj){
	/*len=document.getElementById("check_box").length;*/
	len=document.getElementById("count_reac").value;

	var reactCnt = "";
	if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				document.getElementById("checkBox"+i).checked=true;
				/*Wednesday, January 19, 2011 , added to select only 10 reactions*/
				if(document.getElementById("checkBox"+i).checked==true)
				{
					eval("parent.frames[1].document.forms[0].reaction_code_index"+i).value="Y";
					reactCnt  +=eval("parent.frames[1].document.forms[0].reaction_code_index"+i).value;
					if(reactCnt.length > 20)
					{
						alert(getMessage('ONLY_TWENTY_SEL_ALLOWED','MR'));
						eval("parent.frames[1].document.forms[0].checkBox"+i).checked=false;
						eval("parent.frames[1].document.forms[0].reaction_code_index"+i).value="N";
						obj.checked = false;
						return false;
					}
				}
				/*end*/
			}
		}else{
			for (i=0;i<len;i++){
				if(document.getElementById("checkBox"+i).disabled==false)
				{
					document.getElementById("checkBox"+i).checked=false;
				}
			}
		}
	}else{
		if (obj.checked){
			document.getElementById("checkBox").checked=true;
		}else{
			if(document.getElementById("checkBox").disabled ==false)	
			{
				document.getElementById("checkBox").checked=false;
			}
		}
	}
}


/* for scrolling purpose in reaction search */
function scrollTitle()
{
  var x = document.body.scrollTop;

  if(x == 0){
   if(document.getElementById("head0"))
   {
	   document.getElementById("head0").style.position='static';
	   document.getElementById("head0").style.posTop  = 0;
   }
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;

   }else{
	if(document.getElementById("head0"))
    {
	   document.getElementById("head0").style.position='static';
	   document.getElementById("head0").style.posTop  = x-5;
    }
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-5;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-5;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-5;
	
	 }

}

/*10/11/2008*/
function DateChk(from,to) 
{
	
	

	if(from.value != "" && to.value != "")
	{
		//var flg1 = validDateObj(from,"DMYHMS","en"); Commented by Rameswar on 01-Oct-15
		var flg1 = validDateObj(from,"DMYHMS",localeName);//Added by Rameswar on 01-Oct-15 for Leap Year Issue
		var flg2 = validDateObj(to,"DMYHMS",localeName);

		if( flg1 && flg2 )
		{
			
			
			var greg_fromdate =convertDate(from.value,"DMYHMS",localeName,"en");
			var greg_todate = convertDate(to.value,"DMYHMS",localeName,"en");
			var dob			= document.forms[0].Dob.value;
			var bdate = convertDate(document.forms[0].Dob.value,"DMY",localeName,"en");
			var dateObj1    = document.forms[0].onset_date.value;
			var dateObj     =dateObj1.substring(0,10);
			var greg_todate1 = convertDate(dateObj,"DMY",localeName,"en");

			
			if(!isBefore(bdate,greg_todate1,'DMY',"en"))// DateUtils.js //localeName is changed to en by Rameswar on 17-Nov-15 for Leap Year Issue
			{ 
				var msg = getMessage("ONSET_DT_BT_DOB_AND_CURR","MR");
				alert(msg);
				to.value='';
				to.focus();
				if(document.forms[0].estimated_duration.checked == true){
						document.forms[0].b_days.value = '0';
						document.forms[0].b_months.value='0';
						document.forms[0].b_age.value='0';
				}
			}
			else if(!isAfter(greg_fromdate,greg_todate,'DMYHMS',"en"))//localeName is changed to en by Rameswar on 17-Nov-15 for Leap Year Issue
			{ 
				var msg = getMessage("ONSET_DT_BT_DOB_AND_CURR","MR");
				alert(msg);
				to.value='';
				to.focus();
				if(document.forms[0].estimated_duration.checked == true){
						document.forms[0].b_days.value = '0';
						document.forms[0].b_months.value='0';
						document.forms[0].b_age.value='0';
				}
			}
		}
	}	
	else if(from.value != "" )
	{
		document.forms[0].onset_date.value = from.value;
	}
	else
	{
		document.forms[0].onset_date.value=document.forms[0].currentdateTime.value
	}
}

/*10/11/2008*/


function validateDate(obj){

if(obj.value!="")
	{
	if(!validDateObj(obj,"DMYHMS",localeName))
		{
			obj.value="";
			//obj.focus();
			return ;
		}

		// Added By Sridhar Reddy on 01/03/2010 
		var onSetDate = obj.value
		onSetDate = onSetDate.substring(0,10);
		var retVal = "A^"+onSetDate+"^D^ ^ ^P^ ^ ^ ";	
		if(retVal != "")
		{
			mode ="insert";
/**/
		var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
		var sysdate_time		= sysdate.substring(10,16);
		parent.frames[3].document.forms[0].changeonsetflag.value = "N";
		arr=retVal.split("^")
		parent.frames[3].document.forms[0].event_status.value=arr[0];
		if(arr[0] != 'E')
		{
			if(arr[1]=="dd"){
				parent.frames[3].document.forms[0].since_date.value="";
			}else{
				parent.frames[3].document.forms[0].since_date.value=arr[1];
			}
			 parent.frames[3].document.forms[0].event_certainty.value=arr[2];
			 parent.frames[3].document.forms[0].event_diag.value=arr[3];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[4];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[5];
			 parent.frames[3].document.forms[0].event_observation.value=arr[6];
			 parent.frames[3].document.forms[0].event_advice.value=arr[7];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[8];
			/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] , to change reaction date and onset date as per Active Since Date*/
			 
				if(parent.frames[4].document.forms[0].count_val)
				{
					var countvalue=parent.frames[4].document.forms[0].count_val.value;
					for (var i=0;i<=countvalue-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[1]+""+sysdate_time;
					}
				}
				if(parent.frames[4].document.forms[0].oth_reaction_counter)
				{
					var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
					for (var i=0;i<=oth_reaction_counter-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[1]+""+sysdate_time;
					}
				}
			
			/*oth_reaction_counter*/
		}
		else
		{

			  parent.frames[3].document.forms[0].event_err_remark.value=arr[1];
			  if(arr[1]=="dd"){
				  parent.frames[3].document.forms[0].since_date.value="";
			  }else{
				  parent.frames[3].document.forms[0].since_date.value=arr[2];
			  }
			
			 parent.frames[3].document.forms[0].event_certainty.value=arr[3];
			 parent.frames[3].document.forms[0].event_diag.value=arr[4];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[5];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[6];
			 parent.frames[3].document.forms[0].event_observation.value=arr[7];
			 parent.frames[3].document.forms[0].event_advice.value=arr[8];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[9];
			 //parent.frames[3].document.forms[0].onset_date.value=arr[1]+""+onset_datetime
			 if(parent.frames[4].document.forms[0].count_val)
				{
					var countvalue=parent.frames[4].document.forms[0].count_val.value;
					for (var i=0;i<=countvalue-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[2]+""+sysdate_time;
					}
				}
				if(parent.frames[4].document.forms[0].oth_reaction_counter)
				{
					var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
					for (var i=0;i<=oth_reaction_counter-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[2]+""+sysdate_time;
					}
				}
			 
		}
/**/

	if(arr[0] != 'A')
	{
		parent.frames[4].document.getElementById("add_resc").style.visibility='hidden';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;			
	}
	else
	{
		if(mode != "insert")
		{
			if(parent.frames[4].document.getElementById("add_resc"))

			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
		}
		
		if(arr[1] != "" && arr[1]!='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#9999FF';
		}else if(arr[1]=='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#BD6981';
	}
}



	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH details = \""+encodeURIComponent(retVal)+"\" steps='9'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}
	// Edd
	}
}


function CompareRegnDate1(obj,sys_date_time)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = document.forms[0].sysdate.value;
		var date_time = document.forms[0].date_time.value;
	
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(document.forms[0].Dob!=null){
		var Dob =document.forms[0].Dob.value
		var greg_todate1 = convertDate(date_time,"DMY",localeName,"en");
		var bdate = convertDate(Dob,"DMY",localeName,"en");
	    var onset_date = document.forms[0].onset_date.value
			onset_date = onset_date.substring(0,10)
        var onset_date1 = convertDate(onset_date,"DMY",localeName,"en");
        var since_date1 = convertDate(document.forms[0].since_date1.value,"DMY",localeName,"en");
		if(!isBeforeNow(obj.value,'DMY',localeName))
		{
				var error=getMessage("MRDATE1_GT_DATE2","MR");
				error= error.replace('$',getLabel("Common.since.label","Common")+" "+getLabel("Common.date.label","Common"));
				error= error.replace('#',getLabel("Common.CurrentDate.label","Common"));
				alert(error);
				obj.value=document.forms[0].since_date1.value;
				obj.select();	
				return false;
		}
			
			if(!isBefore(bdate,greg_todate1,'DMY',localeName))// DateUtils.js
			{
				//var msg = getMessage("ONSET_DT_BT_DOB_AND_CURR","MR");
				var msg = getMessage("SINCE_DT_BT_DOB_AND_CURR","MR");
				
				alert(msg);
				obj.value=document.forms[0].since_date1.value;
				obj.focus();
				return false;
				/*if(document.forms[0].estimated_duration.checked == true){
						document.forms[0].b_days.value = '0';
						document.forms[0].b_months.value='0';
						document.forms[0].b_age.value='0';
				}*/
			}
			/*Wednesday, December 16, 2009 , modified for SRR20056-CRF-0303.1 [IN015407] , to check Active Since Date should not be less than OnSet Date*/
			if(!isBefore(onset_date1,obj2,'DMY',localeName))
			{
				var error=getMessage("MRDATE1_LT_DATE2","MR");
				error= error.replace('$',getLabel("Common.since.label","Common")+" "+getLabel("Common.date.label","Common"));
				error= error.replace('#',getLabel("Common.onsetdate.label","Common"));
				alert(error);
				obj.value=document.forms[0].since_date1.value;
				obj.select();	
				return false;
			}
			/*Wednesday, December 16, 2009*/
			/*else if(!isAfter(greg_fromdate,greg_todate,'DMYHMS',localeName))
			{
				var msg = getMessage("ONSET_DT_BT_DOB_AND_CURR","MR");
				alert(msg);
				to.value='';
				to.focus();
				if(document.forms[0].estimated_duration.checked == true){
						document.forms[0].b_days.value = '0';
						document.forms[0].b_months.value='0';
						document.forms[0].b_age.value='0';
				}
			}*/
			var onset_date=document.forms[0].onset_date.value;

			var onset_date_greg=convertDate(onset_date,"DMY",localeName,"en");


			if(obj.value!="" && onset_date_greg!="" )
			{
			
				if(isBefore(onset_date_greg,obj2,'DMY',localeName)==false)
				{
				var error=getMessage("MRDATE1_LT_DATE2","MR");
				error= error.replace('$',getLabel("eMR.StatusDate.label","MR"));
				error= error.replace('#',getLabel("Common.onsetdate.label","Common"));
				alert(error);
				obj.value="";
				obj.select();	
				return false;
			}
			
			
		}
		}	
	}
}



function CompareRegnDate2(obj,sys_date_time)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = sys_date_time.value;
	
		var obj2=convertDate(obj.value,"DMYHM",localeName,"en");
		

			if(!isBeforeNow(obj.value,'DMYHM',localeName))
			{
				var error=getMessage("MRDATE1_GT_DATE2","MR");
				error= error.replace('$',getLabel("eMR.ReactionDateTime.label","MR"));
				error= error.replace('#',getLabel("Common.CurrentDateTime.label","Common"));
				alert(error);
				obj.value="";
				obj.select();	
				return false;
			}
			/*Wednesday, December 23, 2009 , modified for SRR20056-CRF-0303.1 [IN015407] , to check Reaction  Date should not be less than Active Since Date*/
			var obj3 = obj2.substring(0,10);
			var onset_date = parent.frames[3].document.forms[0].onset_date.value
			onset_date = onset_date.substring(0,10)
			var onset_date1 = convertDate(onset_date,"DMY",localeName,"en");
			var since_date = convertDate(parent.frames[3].document.forms[0].since_date.value,"DMY",localeName,"en");
			var reaction_date = parent.frames[3].document.forms[0].reaction_date.value;
			if(since_date == '')
				since_date	= reaction_date;
			var event_status = parent.frames[3].document.forms[0].event_status.value
			if(event_status == 'R' || event_status == 'E')
				onset_date1	= since_date;
			if(!isBefore(since_date,obj3,'DMY',localeName))
			{
				var error=getMessage("MRDATE1_LT_DATE2","MR");
				error= error.replace('$',getLabel("Common.ReactionDate.label","Common"));
				error= error.replace('#',getLabel("Common.since.label","Common")+" "+getLabel("Common.date.label","Common"));
				alert(error);
				obj.value ='';
				return false;
			}
			
			/*Wednesday, December 23, 2009*/
			
	}
}

/****** End of date ********/


/*called on click of individual chk box in reaction search*/
function react_chkbox(obj,ind)
{ 
if (obj.checked==false){
	document.getElementById("selectall").checked=false;
}
	var count_reac=parent.frames[1].document.forms[0].count_reac.value;
	var cnt=parent.frames[1].document.forms[0].count_reac.value;
	var flag=true;
	var reactCnt  =	"";
	var checkedRec = "";
	var reac_code = "";
	if (obj.checked==false){
	eval("parent.frames[1].document.forms[0].reaction_code_index"+ind).value="N";
	}
	else
	{
		for (ind=0;ind<=cnt-1;ind++)
		{
			eval("parent.frames[1].document.forms[0].reaction_code_index"+ind).value="Y";
			/*Wednesday, January 19, 2011 , added to select only 10 reactions*/
			if(eval("parent.frames[1].document.forms[0].checkBox"+ind).checked==true)
			{
			reactCnt  +=eval("parent.frames[1].document.forms[0].reaction_code_index"+ind).value;
			reac_code	= eval("parent.frames[1].document.forms[0].reaction_code"+ind).value;
			checkedRec=checkedRec+reac_code+"@";
			parent.frames[0].document.forms[0].checkedRec.value = checkedRec;
			}
			if(reactCnt.length > 20)
			{
				alert(getMessage('ONLY_TWENTY_SEL_ALLOWED','MR'));
				eval("parent.frames[1].document.forms[0].checkBox"+ind).checked=false;
				eval("parent.frames[1].document.forms[0].reaction_code_index"+ind).value="N";
				return false;
			}
			/*end*/
		}
		
	}
	
	for (var i=1;i<=cnt-1;i++)
	{
		if(eval("parent.frames[1].document.forms[0].checkBox0").checked==true)
		{
		//eval("parent.frames[1].document.forms[0].checkBox"+i).disabled=true;
		//eval("parent.frames[1].document.forms[0].checkBox"+i).checked=false;
		//flag=false;
		}else
		{
		//eval("parent.frames[1].document.forms[0].checkBox"+i).disabled=false;
		//flag=true;
		}
	}


}


/*Called on close of selecting the reaction values*/
function pass_results()
{   
	var count_reac=parent.frames[1].document.forms[0].count_reac.value;			
	var reac_code="";
	var next_str="";
	var oth_reaction="";
	var proceedFlag = "false"
	var checkedFlag = "false"
	parent.frames[0].document.forms[0].search_text.value="";
	//window.parent.frames[4].document.getElementById("add_reaction").value="";
var count_reac=parent.frames[1].document.forms[0].count_reac.value;		
	if(parent.frames[2].document.forms[0].old_other_reaction.value!='' && parent.frames[2].document.forms[0].other_reaction.value!='')
		oth_reaction = parent.frames[2].document.forms[0].old_other_reaction.value+"||"+trimString(parent.frames[2].document.forms[0].other_reaction.value);/*Tuesday, March 01, 2011 SRR20056-SCF-6991 [IN:026684] ,trimString() added */
	else if(parent.frames[2].document.forms[0].old_other_reaction.value!='')
		oth_reaction=parent.frames[2].document.forms[0].old_other_reaction.value;
	else
		oth_reaction=trimString(parent.frames[2].document.forms[0].other_reaction.value);/*Tuesday, March 01, 2011 SRR20056-SCF-6991 [IN:026684] ,trimString() added */
	
if(parent.frames[2].document.forms[0].ret_value)
{   
		for(var i=0;i<count_reac;i++)
		{
			if(eval("parent.frames[1].document.forms[0].reaction_code_index"+i).value=="Y")
				{
				eval("parent.frames[1].document.forms[0].checkBox"+i).checked=true;
				
				}				
		}
}
if(parent.frames[2].document.forms[0].ret_value != "")
{
 /*Avoid the duplicate Reaction added by Senthil on 16-08-2011 Incident No:[027716]*/
     var oldreactionvalue_count=parent.frames[0].document.forms[0].oldreactionvalue_count.value;  
     var reactioncode=parent.frames[0].document.forms[0].reactcode.value;  
     var oldreactioncode=new Array();
     oldreactioncode=reactioncode.split("`"); 
	for(var i=0;i<count_reac;i++)
	{   var reactionFlag =false;
	    if(eval("parent.frames[1].document.forms[0].checkBox"+i+".checked"))
		{ 			
			checkedFlag = "true"
			eval("parent.frames[1].document.forms[0].checkBox"+i).value='E';
			var reac_code=eval("parent.frames[1].document.forms[0].reaction_code"+i+".value");         			
            if(oldreactionvalue_count!=0){
			for(var m=0; m<=oldreactioncode.length-1; m++){	
                  var reactcode1=oldreactioncode[m];            				 
			      if(reac_code==reactcode1){			  
			        reactionFlag=true;
			      }
			  }
			}
           if(reactionFlag){            
			 alert(getMessage("REACTION_ALREADY_EXIST","MR"));
             return false;			 
            }else{       		
			next_str=next_str+reac_code+"@";           	  			
			parent.frames[1].document.forms[0].finalval.value=next_str;	
         	}	
		} 			
	}

	if(checkedFlag=="false"){  
		parent.frames[1].document.forms[0].finalval.value=""; 		
	}
	
	var event_done=parent.frames[1].document.forms[0].event_done.value;
	if(event_done=="onClick")
	{       
	if(parent.frames[2].document.forms[0].other_reaction.disabled==false)
	{  
		if(oth_reaction !="" && parent.frames[1].document.forms[0].finalval.value !="")	
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;						
				old_val=old_val.substring(0,old_val.length-2);				
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value;
				
			}
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"`"+oth_reaction;
		}else if(parent.frames[1].document.forms[0].finalval.value !="" && oth_reaction =="")
		{   
		parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"`"+"$";
		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction !="")
		{
			parent.frames[1].document.forms[0].finalval.value="$"+"`"+oth_reaction;
		}		

	}else
	{   
		if(parent.frames[1].document.forms[0].finalval.value !="" &&  oth_reaction =="")
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[2].document.forms[0].finalval.value+old_val;
			}
		parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value;
		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction !="")
			{
			
			parent.frames[1].document.forms[0].finalval.value="$"+"`"+oth_reaction;
			}else if(parent.frames[1].document.forms[0].finalval.value !="" && oth_reaction !="")
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"`"+oth_reaction;
				
			}
		}
		
	}
	}else
	{
		
		if(parent.frames[2].document.forms[0].other_reaction.disabled==false)
	{
		if(oth_reaction !="" && parent.frames[1].document.forms[0].finalval.value !="")	
		{

		
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length-2);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;
			}
			parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"`"+oth_reaction;
		}else if(parent.frames[1].document.forms[0].finalval.value !="" && oth_reaction =="")
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length-2);
			parent.frames[1].document.forms[0].finalval.value=old_val + parent.frames[1].document.forms[0].finalval.value;

			}
		  parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"`"+"$";

		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction !="")
		{
			/*var old_val="$";
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				 old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length-2);
			parent.frames[1].document.forms[0].finalval.value=old_val + parent.frames[1].document.forms[0].finalval.value;
			}
			if(old_val =="$")
			{*/
			parent.frames[1].document.forms[0].finalval.value="$"+"`"+oth_reaction;
			/*}else
			{
			parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+"*"+oth_reaction;
			}*/
		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction =="")
		{
				
			var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
			parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;
		}

	}else
	{
		if(parent.frames[1].document.forms[0].finalval.value !="" &&  oth_reaction =="")
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;
				
			}
		parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value;
		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction !="")
			{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;
			}
			
			}else if(parent.frames[1].document.forms[0].finalval.value !="" && oth_reaction !="")
		{
			if(parent.frames[1].document.forms[0].react_val.value !="")
			{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
			parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;	
	
		
			}
		}else if(parent.frames[1].document.forms[0].finalval.value =="" && oth_reaction =="")
		{
				var old_val=parent.frames[1].document.forms[0].react_val.value;
				old_val=old_val.substring(0,old_val.length);
				parent.frames[1].document.forms[0].finalval.value=parent.frames[1].document.forms[0].finalval.value+old_val;
		}
	}

	}
}      		
		
		//parent.window.returnValue=parent.frames[1].document.forms[0].finalval.value;
        parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = parent.frames[1].document.forms[0].finalval.value;
		parent.frames[1].document.forms[0].finalval.value = "";
		parent.parent.document.getElementById('dialog_tag').close();
		//parent.window.close();	
		
	
}

function clear_detail()
{
	document.forms[0].cause_sub.value="";
	document.forms[0].route_exp.value="";
	document.forms[0].severity.value="";
	document.forms[0].reaction_date.value="";
	document.forms[0].other_reaction.value="";
	document.forms[0].Site_Of_Reac.value="";
	document.forms[0].allergy_test_res.value="";
	document.forms[0].treat_advice.value="";
	document.forms[0].remarks.value="";
	document.forms[0].react_values.value="";
}

function default_value()
{

		if(document.forms[0].mode.value=='modify')
		{
			
			parent.frames[3].document.forms[0].cause_sub.value=document.forms[0].causitive_sub.value;
			document.forms[0].treat_advice.value=document.forms[0].treat_advice1.value;
			document.forms[0].remarks.value=document.forms[0].remarks1.value;
			document.forms[0].allergy_test_res.value=document.forms[0].allergy_test_res1.value;
			parent.frames[5].document.forms[0].route_exp.value=document.forms[0].exposure1.value;
			
		
			parent.frames[3].document.forms[0].cause_sub.disabled=true;
			parent.frames[5].document.forms[0].treat_advice.disabled=true;
			parent.frames[5].document.forms[0].remarks.disabled=true;
			parent.frames[5].document.forms[0].allergy_test_res.disabled=true;
			parent.frames[5].document.forms[0].route_exp.disabled=true;
		
		var certainity=document.forms[0].certainity.value="D";

		if(certainity =="D")
		{
		document.forms[0].definit.checked=true;
		document.forms[0].probable.checked=false;
		}else
		{
			document.forms[0].probable.checked=true;
			document.forms[0].definit.checked=false;
		}
	


		var source_of_info= document.forms[0].source_of_info.value;
		if(source_of_info=="P")
		{
			parent.frames[5].document.forms[0].pat_obser.checked=true;
			parent.frames[5].document.forms[0].aller_test.checked=false;
			parent.frames[5].document.forms[0].Staff_obser.checked=false;
			parent.frames[5].document.getElementById("aller_test_results").innerText=getLabel("eMR.PatientObservation.label","MR");

		}else if(source_of_info=="A")
		{
			parent.frames[5].document.forms[0].aller_test.checked=true;
			parent.frames[5].document.forms[0].Staff_obser.checked=false;
			parent.frames[5].document.forms[0].pat_obser.checked=false;
			parent.frames[5].document.getElementById("aller_test_results").innerText=getLabel("eMR.AllergyTestResult.label","MR");
		}else if(source_of_info=="S")
		{
			parent.frames[5].document.forms[0].Staff_obser.checked=true;
			parent.frames[5].document.forms[0].aller_test.checked=false;
			parent.frames[5].document.forms[0].pat_obser.checked=false;
			parent.frames[5].document.getElementById("aller_test_results").innerText=getLabel("eMR.StaffObservation.label","MR");
		}
		

			parent.frames[5].document.forms[0].pat_obser.disabled=true;
			parent.frames[5].document.forms[0].aller_test.disabled=true;
			parent.frames[5].document.forms[0].Staff_obser.disabled=true;	parent.frames[2].document.forms[0].react_values.value=document.forms[0].react_values1.value;

		var PatientId=document.forms[0].PatientId.value;
		var adv_event_dtl_srl_no=document.forms[0].adv_event_dtl_srl_no.value;
		var	reaction_date1=document.forms[0].reaction_date1.value;
		var	causative_code=document.forms[0].causative_code.value;

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH adv_event_dtl_srl_no=\""+adv_event_dtl_srl_no+"\"  reaction_date1=\""+encodeURIComponent(reaction_date1)+"\"  PatientId=\""+PatientId+"\"  causative_code=\""+causative_code+"\"   steps='7'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) 
		parent.frames[5].document.forms[0].record.disabled=true;

	}else if(document.forms[0].mode.value=='record')
	{
		
		document.forms[0].resolve.disabled=false;
		document.forms[0].inerror.disabled=false;
		document.forms[0].diagnosis.disabled=true;
		document.forms[0].cause_diag_search.disabled=true;
		
	}

}

/*Called Onclick of Clear button to reload the page*/
function clear_page()
{
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='CLEAR_ALL_SESSION_VALUES'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc) 
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
	parent.frames[6].document.forms[0].markerror.style.visibility='hidden';
	parent.frames[6].document.forms[0].record.style.visibility='visible';

	if(parent.parent.workAreaFrame!=null){



		
		parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="5%,6%,1%,10%,5%,0%,5%";

	}
	else
	{
		
		setTimeout('loadFrameMRC()',50)
		
	}

	var PatientId=	parent.frames[3].document.forms[0].PatientId.value;
	var Encounter_Id=	parent.frames[3].document.forms[0].Encounter_Id.value;
	var allergy_conf_reqd_yn=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value; //Added for the CRF - RUT-CRF-0064
   /*Below line added for this CRF Bru-HIMS-CRF-133*/
	  var isPatientEncMovement=parent.frames[3].document.forms[0].isPatientEncMovement.value;
      var Sydate=parent.frames[3].document.forms[0].Sydate.value;
	  var p_queue_date=parent.frames[3].document.forms[0].p_queue_date.value;
	  var p_queue_status=parent.frames[3].document.forms[0].p_queue_status.value;
	 
	  var sPhInstalled_YN=parent.frames[3].document.forms[0].sPhInstalled_YN.value;/*Added By Rameswar on 1st June 2015 Against AAKH-SCF-0198 IN055068*/
	 
	//End Bru-HIMS-CRF-133
   /*Below line modified for this CRF Bru-HIMS-CRF-133*/	
//	parent.frames[3].location.href="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;//parameter included for the CRF - RUT-CRF-0064
	
	parent.frames[3].location.href="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status+"&sPhInstalled_YN="+sPhInstalled_YN;/*
	Modified By Rameswar on 1st June 2015 Against AAKH-SCF-0198 IN055068*/

//setTimeout('EventFrame()',50);
	
		parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;
	
	parent.frames[5].location.href="../../eMR/jsp/RecordPatientAdverseEventadddetail.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id;
	if(parent.parent.workAreaFrame!=null){
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}else{
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
	}

}

function EventFrame()
{
	
	var PatientId=	parent.frames[3].document.forms[0].PatientId.value;
	var Encounter_Id=	parent.frames[3].document.forms[0].Encounter_Id.value;
	 /*Below line added for this CRF Bru-HIMS-CRF-133*/
	  var isPatientEncMovement=parent.frames[3].document.forms[0].isPatientEncMovement.value;
          var Sydate=parent.frames[3].document.forms[0].Sydate.value;
	  var p_queue_date=parent.frames[3].document.forms[0].p_queue_date.value;
	  var p_queue_status=parent.frames[3].document.forms[0].p_queue_status.value;
	//End Bru-HIMS-CRF-133
	
	
	parent.frames[4].location.href="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
}

function OkClick()
{
	var tosubmit=true;
	var mode=document.forms[0].mode.value;
var status="";

if(document.forms[0].status1.value=="A")

{
	status="A";
}else if(document.forms[0].status1.value=="E")
{
	status='E';
}else if(document.forms[0].status1.value=="R")
{
	status="R";
}

if(status=="")
	{
	status="A"
	}
	if(mode=="insert" )
	{

	
		if (tosubmit && mode =='insert')
	{

	document.forms[0].status_val.value="A";
    document.forms[0].since_date.value=document.forms[0].date_time.value;
   document.forms[0].diagnosis_code.value=document.forms[0].diagnosis_code.value;
   document.forms[0].route_of_expo.value=document.forms[0].route_exp.value;
   document.forms[0].allergy_test_res.value=document.forms[0].allergy_test_res.value;
   document.forms[0].treat_advice.value=document.forms[0].treat_advice.value;
   document.forms[0].remarks.value=document.forms[0].remarks.value;
  document.forms[0].drug_code.value=document.forms[0].drug_code.value;
  document.forms[0].date_time.value=document.forms[0].date_time.value;
  document.forms[0].term_code.value=document.forms[0].term_code.value;
	
	if(parent.parent.workAreaFrame!=null)
		document.forms[0].submit();
	else
		{			
			document.forms[0].target="";
			document.forms[0].submit();			
		}

	
	
	}else if(tosubmit && mode =='record')
	{
		document.forms[0].causative_code.value=document.forms[0].causative_code.value;
	    document.forms[0].status1.value=status;
		document.forms[0].status_val.value=status;
		if(document.forms[0].status1.value !="A")
		{
		document.forms[0].err_remark.value=
	document.forms[0].err_remark.value;
	document.forms[0].date_time.value=
		document.forms[0].date_time.value;
		}
		document.forms[0].since_date.value=document.forms[0].date_time.value;
	document.forms[0].diagnosis_code.value=document.forms[0].diagnosis_code.value;
	document.forms[0].route_of_expo.value=document.forms[0].route_exp.value;
	document.forms[0].allergy_test_res.value=document.forms[0].allergy_test_res.value;
	document.forms[0].treat_advice.value=document.forms[0].treat_advice.value;
	document.forms[0].remarks.value=document.forms[0].remarks.value;
    document.forms[0].drug_code.value=document.forms[0].drug_code.value;
   document.forms[0].date_time.value=document.forms[0].date_time.value;
	document.forms[0].term_code.value=document.forms[0].term_code.value;
	
		if(document.forms[0].status1.value =='E')
		{
	document.forms[0].err_remark.value=document.forms[0].err_remark.value;
		}
		

		if(parent.parent.workAreaFrame!=null)
			window.close();
		else
		{
		document.forms[0].target="";
		window.close();
		}
		
	}
}
}

/*Called Onclick of record button where the values r passed to servlet*/
function record_values()
{	
    var isOthAllergenAppl = parent.frames[3].document.forms[0].isOthAllergenAppl.value;//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
	parent.frames[4].document.forms[0].check_stat.value = "record_values";
	var tosubmit=true;
	var mode=parent.frames[3].document.forms[0].mode.value;
	parent.frames[4].document.forms[0].since_date.value=parent.frames[3].document.forms[0].since_date.value;
   
	var status="";
if(parent.frames[3].document.forms[0].event_status.value=="A")
{
	status="A";
}else if(parent.frames[3].document.forms[0].event_status.value=="E")
{
	status='E';
}else if(parent.frames[3].document.forms[0].event_status.value=="R")
{
	status="R";
}

if(status=="")
	{
	status="A"
	}
	if(mode=="insert" )
	{
	//modified for FS102MRPMGCRF0083v1.2 PMG20089-CRF-0083 SCR 3896 on 10-09-08
	//Condition modified for the CRF - RUT-CRF-0064
	if(parent.frames[3].document.forms[0].known_allergy.value==0 || parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y')
	{
		if(parent.frames[3].document.forms[0].no_known_allergy.checked==true)
		{
			//Added for the crf - RUT-CRF-0064 - Begin
			if(parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y'){								
				parent.frames[4].document.forms[0].AllergyConfirmYN.value=parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value;
				parent.frames[4].document.forms[0].allergy_conf_reqd_yn.value=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;				
			}
			//Added for the crf - RUT-CRF-0064 - End

			parent.frames[4].document.forms[0].no_known_allergy.value = parent.frames[3].document.forms[0].no_known_allergy.value;
			if(parent.frames[3].document.forms[0].no_known_allergy.value == 'Y'){
				parent.frames[4].document.forms[0].no_known_allergy.value='N'
			}
			parent.frames[4].document.forms[0].estimated_duration_yn.value='N';
			parent.frames[4].document.forms[0].add_reaction.disabled=false;

			parent.frames[3].document.forms[0].adv_event_ind.disabled=false;
			parent.frames[3].document.forms[0].adv_event_ind_one.disabled=false; 
			parent.frames[3].document.forms[0].adv_event_ind_two.disabled=false;
			parent.frames[3].document.forms[0].adv_event_ind_three.disabled=false;
			parent.frames[3].document.forms[0].adverse_even_type.disabled=false;
			parent.frames[3].document.forms[0].allergen.disabled=false;
			/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl == "true")
				parent.frames[3].document.forms[0].allergen_free_text.disabled=false;
			/*End*/
			parent.frames[3].document.forms[0].cause_sub.disabled=false;
			parent.frames[3].document.forms[0].onset_date.disabled=false;
			parent.frames[3].document.forms[0].estimated_duration.disabled=false;
			parent.frames[3].document.forms[0].b_days.disabled=false;
			parent.frames[3].document.forms[0].b_months.disabled=false;
			parent.frames[3].document.forms[0].b_age.disabled=false;
			//Commented the below line for the crf - RUT-CRF-0064, since the form was anyhow getting submitted from line 2765 or 2773			
			//parent.frames[4].document.forms[0].submit();
		}
		/***----------9/27/2008---------------***/
		else{
			/*Added for the CRF - RUT-CRF-0064 - Begin*/
			var allergy_conf_reqd_yn=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;
			if(allergy_conf_reqd_yn=='Y' && parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value==''){
				var error1;
				error1=getMessage("CAN_NOT_BE_BLANK","common");
				error1=error1.replace("$",getLabel("eMR.PatientDrugAllergy.label","MR"));
				alert(error1);
				tosubmit =false;
			}/*Added for the CRF - RUT-CRF-0064 - End*/
			else if(parent.frames[3].document.forms[0].adv_event_type.value =="")
		{

				
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventType.label","MR"));
		alert(error1);
		tosubmit =false;
		}else if(parent.frames[3].document.forms[0].allergen.value == "" && isOthAllergenAppl != "true")//Modified by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
		{
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}
		/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751*/
		else if(parent.frames[3].document.forms[0].allergen.value == "" && TrimStr(parent.frames[3].document.forms[0].allergen_free_text.value) == "" && isOthAllergenAppl == "true"){
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}/*End*/
		else if((parent.frames[3].document.forms[0].allergyAlertby.value =="D") && (parent.frames[3].document.forms[0].cause_sub.value==""))
		{
			var error1;
			error1=getMessage("CAN_NOT_BE_BLANK","common");
			error1=error1.replace("$",getLabel("eMR.CausativeSubstance.label","MR"));
			alert(error1);
			tosubmit =false;
		}else if(parent.frames[4].document.forms[0].react_code_final.value=="")
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		error3=error3.replace("$",getLabel("eMR.addreaction.label","MR"));
		alert(error3);
		tosubmit =false;
		}
		else if(parent.frames[4].document.forms[0].since_date.value =="")
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		var label = getLabel("Common.EventType.label","Common")+" "+(getLabel("Common.details.label","Common"));
		error3=error3.replace("$",label);
		alert(error3);
		tosubmit =false;
		}
		

						/***------9/27/2008-------------------***/


		}
	}
	//
	else if(parent.frames[3].document.forms[0].adv_event_type.value =="")
		{
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventType.label","MR"));
		alert(error1);
		tosubmit =false;
		}else if(parent.frames[3].document.forms[0].allergen.value =="" && isOthAllergenAppl != "true")//Modified by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
		{
				var error2;
				error2=getMessage("CAN_NOT_BE_BLANK","common");
				error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
				alert(error2);
				tosubmit =false;
		}
		/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751*/
		else if(parent.frames[3].document.forms[0].allergen.value == "" && TrimStr(parent.frames[3].document.forms[0].allergen_free_text.value) == "" && isOthAllergenAppl == "true"){
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}/*End*/
		else if((parent.frames[3].document.forms[0].allergyAlertby.value =="D") && (parent.frames[3].document.forms[0].cause_sub.value==""))
		{
			var error1;
			error1=getMessage("CAN_NOT_BE_BLANK","common");
			error1=error1.replace("$",getLabel("eMR.CausativeSubstance.label","MR"));
			alert(error1);
			tosubmit =false;
		}else if(parent.frames[4].document.forms[0].react_code_final.value=="")
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		error3=error3.replace("$",getLabel("eMR.addreaction.label","MR"));
		alert(error3);
		tosubmit =false;
		}
		else if(parent.frames[4].document.forms[0].since_date.value =="")
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		var label = getLabel("Common.EventType.label","Common")+" "+(getLabel("Common.details.label","Common"));
		error3=error3.replace("$",label);
		alert(error3);
		tosubmit =false;
		}

	}else if(mode=="record" && status=="A")
	{  
		//var z = 0;
		
		if(parent.frames[3].document.forms[0].adv_event_ind.value =="")
		{
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventIndindicator.label","MR"));
		alert(error1);

		tosubmit =false;
		}else
			
		if(parent.frames[3].document.forms[0].adv_event_type.value =="")
		{
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventType.label","MR"));
		alert(error1);

		tosubmit =false;
		}else if(parent.frames[3].document.forms[0].allergen.value =="" && isOthAllergenAppl != "true")//Modified by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
		{
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}
		/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751*/
		else if(parent.frames[3].document.forms[0].allergen.value == "" && TrimStr(parent.frames[3].document.forms[0].allergen_free_text.value) == "" && isOthAllergenAppl == "true"){
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}/*End*/
		else if(parent.frames[3].document.forms[0].onset_date.value =="")
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		error3=error3.replace("$",getLabel("Common.OnsetDate.label","Common"));
		alert(error3);
		tosubmit =false;
		}
		parent.frames[4].document.forms[0].add_reation_yn.value='Y';
		
    
	}else if(mode=="record" && status !="A")
	{
		
			if(parent.frames[3].document.forms[0].adv_event_ind.value =="")
		{
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventIndindicator.label","MR"));
		alert(error1);
		tosubmit =false;
		}else 
			
		if(parent.frames[3].document.forms[0].adv_event_type.value =="")
		{
		var error1;
		error1=getMessage("CAN_NOT_BE_BLANK","common");
		error1=error1.replace("$",getLabel("eMR.AdverseEventType.label","MR"));
		alert(error1);
		tosubmit =false;
		}else if(parent.frames[3].document.forms[0].allergen.value =="" && isOthAllergenAppl != "true")//Modified by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
		{
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}
		/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751*/
		else if(parent.frames[3].document.forms[0].allergen.value == "" && TrimStr(parent.frames[3].document.forms[0].allergen_free_text.value) == "" && isOthAllergenAppl == "true"){
			var error2;
			error2=getMessage("CAN_NOT_BE_BLANK","common");
			error2=error2.replace("$",getLabel("eMR.Allergen.label","MR"));
			alert(error2);
			tosubmit =false;
		}/*End*/
		parent.frames[4].document.forms[0].add_reation_yn.value='N';
		
	}
	
	
	if(mode == "insert")
		{
		parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].event_infosource.value
			parent.frames[4].document.forms[0].allergy_test_res.value=parent.frames[3].document.forms[0].event_observation.value;
	
	parent.frames[4].document.forms[0].treat_advice.value=parent.frames[3].document.forms[0].event_advice.value;
	parent.frames[4].document.forms[0].remarks.value=parent.frames[3].document.forms[0].event_remarks.value;
	parent.frames[4].document.forms[0].diagnosis_code.value=parent.frames[3].document.forms[0].event_diag.value;
	parent.frames[4].document.forms[0].route_of_expo.value=parent.frames[3].document.forms[0].event_exposure.value;
		}

		if(mode == "insert")
		{
		parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].event_certainty.value
		}

/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751 Start*/
var allergen1 = "";
var allergen  = "";
if(isOthAllergenAppl == "true"){
	if(parent.frames[3].document.forms[0].allergen_id.value == "" && parent.frames[3].document.forms[0].allergen_free_text.value != ""){
		allergen = parent.frames[3].document.forms[0].allergen_free_text.value;
	}else{
		allergen1=parent.frames[3].document.forms[0].allergen.value;
		allergen=allergen1.split("|");
		allergen=allergen[0];
	}
}else{/*End*/
	allergen1=parent.frames[3].document.forms[0].allergen.value;
	allergen=allergen1.split("|");
	allergen=allergen[0];
}

var adv_event_type1=parent.frames[3].document.forms[0].adv_event_type.value;
var adv_event_type=adv_event_type1.split("|");
adv_event_type=adv_event_type[0];

		




if (parent.frames[3].document.forms[0].adv_event_ind.checked==true)
{
	
	parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind.value
		
}else if (parent.frames[3].document.forms[0].adv_event_ind_one.checked==true)
{
		parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_one.value;
		parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].event_infosource.value;
		parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].event_certainty.value;
		

}else if (parent.frames[3].document.forms[0].adv_event_ind_two.checked==true)
{
	parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_two.value;
	parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].event_infosource.value;
		parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].event_certainty.value;
}else 
{
	parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_three.value;
	parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].event_infosource.value;
		parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].event_certainty.value;
}
		parent.frames[4].document.forms[0].adv_event_type.value=adv_event_type;
		parent.frames[4].document.forms[0].allergen.value=allergen;
		parent.frames[4].document.forms[0].onset_date.value=parent.frames[3].document.forms[0].onset_date.value;
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		 parent.frames[4].document.forms[0].onset_type.value=parent.frames[3].document.forms[0].onset_type.value;
		 parent.frames[4].document.forms[0].comments.value=parent.frames[3].document.forms[0].comments.value;
		 /*end ML-MMOH-CRF-0366 */
		 


if(mode=="insert")
	{
		/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			if(parent.frames[3].document.forms[0].allergen_id.value == "" && parent.frames[3].document.forms[0].allergen_free_text.value != ""){
				parent.frames[4].document.forms[0].allergen_id.value = "Oth";
				parent.frames[4].document.forms[0].allergen_free_text.value=parent.frames[3].document.forms[0].allergen_free_text.value;
			}else
				parent.frames[4].document.forms[0].allergen_id.value=parent.frames[3].document.forms[0].allergen_id.value;
		}else{/*End*/
				parent.frames[4].document.forms[0].allergen_id.value=parent.frames[3].document.forms[0].allergen_id.value;
		}
	}else
	{
		parent.frames[4].document.forms[0].allergen_id.value=parent.frames[3].document.forms[0].causative_code.value;
		/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
		if(isOthAllergenAppl == "true"){
			parent.frames[4].document.forms[0].allergen_free_text.value=parent.frames[3].document.forms[0].allergen_free_text.value;
		}
	}
parent.frames[4].document.forms[0].advEventSrlNo.value=parent.frames[3].document.forms[0].advEventSrlNo.value;//Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
parent.frames[4].document.forms[0].cause_sub.value=parent.frames[3].document.forms[0].cause_sub.value;
parent.frames[4].document.forms[0].allergyAlertby.value=parent.frames[3].document.forms[0].allergyAlertby.value;
parent.frames[4].document.forms[0].drug_code.value=parent.frames[3].document.forms[0].drug_code.value;

if(parent.frames[4].document.forms[0].count_val)
{
var date_blank=false;

var countvalue=parent.frames[4].document.forms[0].count_val.value;

for (var i=0;i<=countvalue-1 ;i++ )
{  

	if(eval("parent.frames[4].document.forms[0].reaction_date"+i).value=="")
	{   
		var date_blank=true;
	}
}
}


if(parent.frames[4].document.forms[0].oth_reaction_counter)
	{
	var other_date_blank=false;
	
	var other_countvalue=parent.frames[4].document.forms[0].oth_reaction_counter.value;
		for (var i=0;i<=other_countvalue-1 ;i++ )
		{

			if(eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value=="")
			{
				
				var other_date_blank=true;
			}
		}

		/**/
	}

	


if(parent.frames[4].document.forms[0].count_val || parent.frames[4].document.forms[0].oth_reaction_counter)
	{

	if(parent.frames[4].document.forms[0].count_val && parent.frames[4].document.forms[0].oth_reaction_counter)
		{
		if(date_blank || other_date_blank)
			{
				
				var error1;
				error1=getMessage("CAN_NOT_BE_BLANK","common");
				error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
				alert(error1);
				tosubmit =false;
			}else
			{
			}
		}else if(parent.frames[4].document.forms[0].count_val)
		{
		if(date_blank )
			{
				
				var error1;
				error1=getMessage("CAN_NOT_BE_BLANK","common");
				error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
				alert(error1);
				tosubmit =false;
			}else
			{
				
			}
		}
		else if(parent.frames[4].document.forms[0].oth_reaction_counter)
		{
		if(other_date_blank)
			{
				
				var error1;
				error1=getMessage("CAN_NOT_BE_BLANK","common");
				error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
				alert(error1);
				tosubmit =false;
			}else
			{
				
			}
		}
		
	}



	if (tosubmit && mode =='insert') 
	{
		//Modified for the crf - RUT-CRF-0064
		if(parent.frames[3].document.forms[0].known_allergy.value=='0' || parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y')
		{
			if(parent.frames[3].document.forms[0].no_known_allergy.checked==true)
				parent.frames[4].document.forms[0].no_known_allergy.value="N";
				else
					parent.frames[4].document.forms[0].no_known_allergy.value="Y";
			parent.frames[4].document.forms[0].estimated_duration_yn.value=parent.frames[3].document.forms[0].estimated_duration.value;
	if(parent.frames[4].document.forms[0].estimated_duration_yn.value=="")
		parent.frames[4].document.forms[0].estimated_duration_yn.value="N";
		}
	else
	{
	parent.frames[4].document.forms[0].no_known_allergy.value="Y";
	parent.frames[4].document.forms[0].status_val.value="A";
	parent.frames[4].document.forms[0].estimated_duration_yn.value=parent.frames[3].document.forms[0].estimated_duration.value;
	if(parent.frames[4].document.forms[0].estimated_duration_yn.value=="")
		parent.frames[4].document.forms[0].estimated_duration_yn.value="N";

	parent.frames[4].document.forms[0].since_date.value=parent.frames[3].document.forms[0].since_date.value;
	parent.frames[4].document.forms[0].diagnosis_code.value=parent.frames[3].document.forms[0].event_diag.value;
	parent.frames[4].document.forms[0].route_of_expo.value=parent.frames[3].document.forms[0].event_exposure.value;


	parent.frames[4].document.forms[0].route_of_expo.value=parent.frames[3].document.forms[0].event_exposure.value;
	
	parent.frames[4].document.forms[0].allergy_test_res.value=parent.frames[3].document.forms[0].event_observation.value;
	
	parent.frames[4].document.forms[0].treat_advice.value=parent.frames[3].document.forms[0].event_advice.value;
	parent.frames[4].document.forms[0].remarks.value=parent.frames[3].document.forms[0].event_remarks.value;
	
	parent.frames[4].document.forms[0].drug_code.value=parent.frames[4].document.forms[0].drug_code.value;
	parent.frames[4].document.forms[0].date_time.value=parent.frames[3].document.forms[0].since_date.value;
	parent.frames[4].document.forms[0].term_code.value=parent.frames[4].document.forms[0].term_code.value;

	  
	 }
		//Added for the CRF - RUT-CRF-0064 - Begin
		if(parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y'){
			parent.frames[4].document.forms[0].AllergyConfirmYN.value=parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value;//Added for the crf - RUT-CRF-0064
			parent.frames[4].document.forms[0].allergy_conf_reqd_yn.value=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;
		}
		//Added for the CRF - RUT-CRF-0064 - End
	
	if(parent.parent.workAreaFrame!=null)
		{
			parent.submitframe.document.submit_form.record.disabled = true;
			parent.frames[4].document.forms[0].submit();
		}
		
	else
		{			
			parent.frames[4].document.forms[0].target="";
			parent.submitframe.document.submit_form.record.disabled = true;
			parent.frames[4].document.forms[0].submit();			
		}

	
	
	}else if(tosubmit && mode =='record')
	{  
		
		parent.frames[4].document.forms[0].causative_code.value=parent.frames[3].document.forms[0].causative_code.value;

	    parent.frames[4].document.forms[0].status1.value=status;
		parent.frames[4].document.forms[0].status_val.value=status;
		
		
		if(status.value !="A")
		{
			parent.frames[4].document.forms[0].err_remark.value=
			parent.frames[3].document.forms[0].event_err_remark.value;
			parent.frames[4].document.forms[0].date_time.value=
			parent.frames[3].document.forms[0].since_date.value;
		}
		
		parent.frames[4].document.forms[0].since_date.value=parent.frames[3].document.forms[0].since_date.value;
		
		parent.frames[4].document.forms[0].diagnosis_code.value=parent.frames[3].document.forms[0].diagnosis_code.value;
	
		if(parent.frames[3].document.forms[0].event_exposure.value != "")
			parent.frames[4].document.forms[0].route_of_expo.value=parent.frames[3].document.forms[0].event_exposure.value;
    	else
			parent.frames[4].document.forms[0].route_of_expo.value=parent.frames[3].document.forms[0].route_of_exposure.value;


	parent.frames[4].document.forms[0].allergy_test_res.value=parent.frames[3].document.forms[0].event_observation.value;
		
	//parent.frames[3].document.forms[0].event_advice.value
	parent.frames[4].document.forms[0].treat_advice.value=parent.frames[3].document.forms[0].event_advice.value;

	//parent.frames[3].document.forms[0].event_remarks.value

		parent.frames[4].document.forms[0].remarks.value=parent.frames[3].document.forms[0].event_remarks.value;

		parent.frames[4].document.forms[0].drug_code.value=parent.frames[4].document.forms[0].drug_code.value;
		if(parent.frames[3].document.forms[0].since_date.value != "")
			parent.frames[4].document.forms[0].date_time.value=parent.frames[3].document.forms[0].since_date.value;
		else
			parent.frames[4].document.forms[0].date_time.value=parent.frames[3].document.forms[0].reaction_date.value;
		parent.frames[4].document.forms[0].term_code.value=parent.frames[4].document.forms[0].term_code.value;
		
		if(parent.frames[3].document.forms[0].event_infosource.value !="")		
			parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].event_infosource.value;
		else
			parent.frames[4].document.forms[0].sou_of_info.value=parent.frames[3].document.forms[0].pat_obser.value;
    	if(parent.frames[3].document.forms[0].event_certainty.value != "")

			parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].event_certainty.value;

		else
			parent.frames[4].document.forms[0].certainity.value=parent.frames[3].document.forms[0].Certainity.value;

		if(status =='E')
		{
			parent.frames[4].document.forms[0].err_remark.value=parent.frames[3].document.forms[0].event_err_remark.value;
			
		}
		
		parent.frames[3].document.forms[0].submit();
		//Added for the CRF - RUT-CRF-0064 - Begin
		if(parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y'){
		parent.frames[4].document.forms[0].AllergyConfirmYN.value=parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value;
		parent.frames[4].document.forms[0].allergy_conf_reqd_yn.value=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;
		}
		//Added for the CRF - RUT-CRF-0064 - End
		if(parent.parent.workAreaFrame!=null){	
			
				parent.submitframe.document.submit_form.record.disabled = true;
				parent.frames[4].document.forms[0].submit();
			}
		else
		{	
    		parent.frames[4].document.forms[0].target="";
			parent.submitframe.document.submit_form.record.disabled = true;
			parent.frames[4].document.forms[0].submit();	
		}


	}
	
}
function visCausative(){
	if(parent.frames[3].document.forms[0].allergyAlertby.value=="D")
	{
		
		
	parent.frames[3].document.forms[0].Causative_sub.style.visibility='visible';
	}else
	{
		
		parent.frames[3].document.forms[0].Causative_sub.style.visibility='hidden';
	}
}


/* for scrolling purpose in existing records search */

function scrollTitle1()
{
  var x = document.body.scrollTop;

  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
     document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
     document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;
    
 

   }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-15;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-15;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-15;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-15;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-15;
	
	
	 }
}

function scrolltitle2()
{
	 var x = document.body.scrollTop;

  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
     document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
     document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;


   }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-5;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-5;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-5;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-5;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-5;

		
	 }
}


async function expandColapseframe(obj)
{
    var retVal			= new String();
	var arr				= new Array();
	var reaction_date	= '';
	var adv_event_type	= '';
	var status_db		= '';
	var Certainity		= '';
	var reaction_date	= '';
	var diagnosis_code	= '';
	var patient_id		= parent.frames[3].document.forms[0].PatientId.value;
    var Encounter_Id	= parent.frames[3].document.forms[0].Encounter_Id.value;
	var mode			= document.forms[0].mode.value;
	var	causative_code	= parent.frames[3].document.forms[0].causative_code.value;
	var	active_diag_cnt = parent.frames[3].document.forms[0].active_diag_cnt.value;
	var	Pract_id		= parent.frames[3].document.forms[0].Pract_id.value;
	var	practitioner_type= parent.frames[3].document.forms[0].practitioner_type.value;
	var	patient_class	= parent.frames[3].document.forms[0].patient_class.value;
	var	Locn_Code		= parent.frames[3].document.forms[0].Locn_Code.value;
	var	location_type	= parent.frames[3].document.forms[0].location_type.value;
	var	speciality_code = parent.frames[3].document.forms[0].speciality_code.value;
	var	Dob				= parent.frames[3].document.forms[0].Dob.value;
	var	sysdate			= parent.frames[3].document.forms[0].sysdate.value;
	var sysdate_time    = sysdate.substring(10,16);
	var	onset_date_time	= parent.frames[3].document.forms[0].onset_date.value;
	var onset_date		= onset_date_time.substring(0,10);
	var	since_date  	= onset_date;
	var onset_datetime  = onset_date_time.substring(10,19);
	var changeonsetflag	= parent.frames[3].document.forms[0].changeonsetflag.value;

	if(mode=='insert'){
		reaction_date	= '';
		adv_event_type  = '';
		status_db		= '';
		Certainity		= '';
		reaction_date	= '';
		diagnosis_code	= '';
		
		}
	else{

	 adv_event_type		= parent.frames[3].document.forms[0].adv_event_type_code.value;
	 status_db			= parent.frames[3].document.forms[0].status_pass.value;
	 Certainity			= parent.frames[3].document.forms[0].Certainity.value;
	 reaction_date		= parent.frames[3].document.forms[0].reaction_date.value;
	  diagnosis_code	= parent.frames[3].document.forms[0].diagnosis_code.value;
	 
	 }
	 
	var dialogHeight	= "50vh" ;
	var dialogTop		= "30" ;
	var dialogWidth		= "75vw" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status  + "; dialogTop :" + dialogTop ;
	/*Thursday, January 21, 2010 , 18223 */
	//var arguments		= "";
	var event_details_hidden = parent.frames[3].document.forms[0].event_observation.value+"^^"					
								+parent.frames[3].document.forms[0].event_advice.value+"^^" +parent.frames[3].document.forms[0].event_remarks.value+"^^"+parent.frames[3].document.forms[0].event_err_remark.value;
	var arguments		= event_details_hidden;
	/**/
	var callurl="../../eMR/jsp/RecordPatientAdverseEventadddetail.jsp?mode="+mode+"&causative_code="+causative_code+"&patient_id="+patient_id+"&Encounter_Id="+Encounter_Id+"&reaction_date="+encodeURIComponent(reaction_date)+"&adv_event_type="+adv_event_type+"&status_db="+status_db+"&Certainity="+Certainity+"&diagnosis_code_db="+encodeURIComponent(diagnosis_code)+"&active_diag_cnt="+active_diag_cnt+"&patient_class="+patient_class+"&practitioner_type="+practitioner_type+"&practitioner_type="+Pract_id+"&speciality_code="+speciality_code+"&location_type="+location_type+"&Locn_Code="+Locn_Code+"&Dob="+Dob+"&since_date="+since_date+"&onset_date="+onset_date+"&changeonsetflag="+changeonsetflag+"&onset_date_time="+encodeURIComponent(onset_date_time); 

	retVal =await window.showModalDialog(callurl,arguments,features);
	//retVal = window.open(callurl,arguments,'height=250,width=1020,top=250,left=0');
	
	if(retVal != null && retVal != undefined)
	{
		if(retVal != "")
		{

/**/
		parent.frames[3].document.forms[0].changeonsetflag.value = "N";
		arr=retVal.split("^")
		parent.frames[3].document.forms[0].event_status.value=arr[0];
		if(arr[0] != 'E')
		{
			if(arr[1]=="dd"){
				parent.frames[3].document.forms[0].since_date.value="";
			}else{
				parent.frames[3].document.forms[0].since_date.value=arr[1];
			}
			 parent.frames[3].document.forms[0].event_certainty.value=arr[2];
			 parent.frames[3].document.forms[0].event_diag.value=arr[3];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[4];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[5];
			 parent.frames[3].document.forms[0].event_observation.value=arr[6];
			 parent.frames[3].document.forms[0].event_advice.value=arr[7];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[8];
			/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] , to change reaction date and onset date as per Active Since Date*/
			if(mode == "insert")
			{
				if(parent.frames[4].document.forms[0].count_val)
				{
					var countvalue=parent.frames[4].document.forms[0].count_val.value;
					for (var i=0;i<=countvalue-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[1]+""+sysdate_time;
					}
				}
				if(parent.frames[4].document.forms[0].oth_reaction_counter)
				{
					var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
					for (var i=0;i<=oth_reaction_counter-1 ;i++ )
					{
						eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[1]+""+sysdate_time;
					}
				}
			}
			
			/*oth_reaction_counter*/
		}
		else
		{

			  parent.frames[3].document.forms[0].event_err_remark.value=arr[1];
			  if(arr[1]=="dd"){
				  parent.frames[3].document.forms[0].since_date.value="";
			  }else{
				  parent.frames[3].document.forms[0].since_date.value=arr[2];
			  }
			
			 parent.frames[3].document.forms[0].event_certainty.value=arr[3];
			 parent.frames[3].document.forms[0].event_diag.value=arr[4];
			 parent.frames[3].document.forms[0].event_exposure.value=arr[5];
			 parent.frames[3].document.forms[0].event_infosource.value=arr[6];
			 parent.frames[3].document.forms[0].event_observation.value=arr[7];
			 parent.frames[3].document.forms[0].event_advice.value=arr[8];
			 parent.frames[3].document.forms[0].event_remarks.value=arr[9];
			 //parent.frames[3].document.forms[0].onset_date.value=arr[1]+""+onset_datetime
			 if(mode == "insert")
			{
				 if(parent.frames[4].document.forms[0].count_val)
					{
						var countvalue=parent.frames[4].document.forms[0].count_val.value;
						for (var i=0;i<=countvalue-1 ;i++ )
						{
							eval("parent.frames[4].document.forms[0].reaction_date"+i).value = arr[2]+""+sysdate_time;
						}
					}
					if(parent.frames[4].document.forms[0].oth_reaction_counter)
					{
						var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
						for (var i=0;i<=oth_reaction_counter-1 ;i++ )
						{
							eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = arr[2]+""+sysdate_time;
						}
					}
			}
			 
		}
/**/

	if(arr[0] != 'A')
	{
		parent.frames[4].document.getElementById("add_resc").style.visibility='hidden';
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;			
	}
	else
	{
		if(mode != "insert")
		{
			if(parent.frames[4].document.getElementById("add_resc"))

			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
		}
		
		if(arr[1] != "" && arr[1]!='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#9999FF';
		}else if(arr[1]=='dd'){
			parent.frames[3].document.getElementById("eventdtlsID").style.backgroundColor='#BD6981';
	}
}



	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH details = \""+encodeURIComponent(retVal)+"\" steps='9'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}
	}

}
//9/27/2008

function reloadAdverseEventFrame()
{
		
	parent.frames[4].location.reload();
	
		
}
//
function loadFrame(){


parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,6%,1%,10%,5%,0%,5%";//Modified for the CRF - RUT-CRF-0064
}
function loadFrameS(){
	
	parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,10%,0%,10%,5%,0,5%";//Modified for the CRF - RUT-CRF-0064
}
function loadFrameMR(){
	
	parent.document.getElementById('resultpage').style.height = "30vh";
	parent.document.getElementById('resultpage1').style.height = "10vh";
	parent.document.getElementById('staticcolorpage').style.height = "3vh";
	parent.document.getElementById('Headerpage').style.height = "25vh";
	parent.document.getElementById('reaction_details_page').style.height = "10vh";
	parent.document.getElementById('detail_view').style.height = "0vh";
	parent.document.getElementById('submitframe').style.height = "10vh";
	parent.document.getElementById('messageFrame').style.height = "6vh";
	

//parent.document.getElementById("allergy_recording").rows="15%,6%,1%,11%,5%,0%,5%,2%";//Modified for the CRF - RUT-CRF-0064
 
}
function loadFrameMRS()
{
	

	parent.document.getElementById("allergy_recording").rows="7.4%,6%,1%,11%,5%,0%,5%,2%";
}
function loadFrameMRC()
{

	

	//parent.document.getElementById("allergy_recording").rows="15%,6%,1%,11%,5%,0%,5%,2%";//Modified for the CRF - RUT-CRF-0064
	parent.document.getElementById('resultpage').style.height = "26vh";
	parent.document.getElementById('resultpage1').style.height = "15vh";
	parent.document.getElementById('staticcolorpage').style.height = "1vh";
	parent.document.getElementById('Headerpage').style.height = "29vh";
	parent.document.getElementById('reaction_details_page').style.height = "12vh";
	parent.document.getElementById('detail_view').style.height = "0vh";
	parent.document.getElementById('detail_view').style.display="none";
	parent.document.getElementById('submitframe').style.height = "4vh";
	parent.document.getElementById('messageFrame').style.height = "6vh";

}
/*Based on adv event ind selected agin frame expands and collapses*/
function show_table(obj)
{	
	setTimeout('reloadAdverseEventFrame()',50)
	if(parent.frames[4].document.forms[0] != null)
	var mode=parent.frames[4].document.forms[0].mode.value;

	if(obj.value!=null && obj.value!="")
	{
		
		if(mode=="insert")
		{
			if(parent.parent.workAreaFrame!=null)
			{
				
				
					setTimeout('loadFrame()',50)

			}
			else
				{
				
				setTimeout('loadFrameMR()',50)
			}
		}else
		{
			if(parent.parent.workAreaFrame!=null)
				{
					
				
				setTimeout('loadFrame()',50)
				}
			else
			{
				
				setTimeout('loadFrameMR()',50)
			}
		}
		
		//parent.frames[3].document.forms[0].expand.value=getLabel("Common.EventType.label","common")+" "+getLabel("Common.details.label","common");
		//parent.frames[3].document.forms[0].expand.name = "hide";
	}else 
	{
		
	
		if(mode=="insert")
		{
			if(parent.parent.workAreaFrame!=null){
				
				parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="2%,2%,0%,4%,1%,0,5%";
				
				}
			else
			{
			setTimeout('loadFrameMRS()',50)
			
			}

		}else
		{
			if(parent.parent.workAreaFrame!=null){
				
				setTimeout('loadFrameS()',25)
				
				}
			else{
				
					
					setTimeout('loadFrameMR()',50)
			}
		}
		parent.frames[3].document.forms[0].expand.value=getLabel("Common.EventType.label","common");
		parent.frames[3].document.forms[0].expand.name = "expand";
	}
}

/*Onclick of Reaction date from the existing records the values get defaulted*/
function default_records(reaction_date,causative_code,adv_event_type_ind_code,adv_event_type_code,
PatientId,Certainity,severity_main,adv_event_dtl_srl_no,diagnosis_code,severity_code,active_date,causative_substance)
{
		if(reaction_date !=null && reaction_date!="")
		{
		
			if(parent.parent.workAreaFrame!=null)
				parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
			else
				parent.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
		
		var Encounter_Id=parent.frames[1].document.forms[0].Encounter_Id.value;
		var allergy_conf_reqd_yn=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;//Added for the crf - RUT-CRF-0064
		  /*Below line added for this CRF Bru-HIMS-CRF-133*/
	      var isPatientEncMovement=parent.frames[3].document.forms[0].isPatientEncMovement.value;
          var Sydate=parent.frames[3].document.forms[0].Sydate.value;
	      var p_queue_date=parent.frames[3].document.forms[0].p_queue_date.value;
	      var p_queue_status=parent.frames[3].document.forms[0].p_queue_status.value;
			
		  var sPhInstalled_YN=parent.frames[3].document.forms[0].sPhInstalled_YN.value;/*Added By Rameswar on 4th June 2015 Against AAKH-SCF-0198 IN055068*/
	    //End Bru-HIMS-CRF-133
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		
		/*var url="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?mode=modify&causative_code="+causative_code+"&reaction_date="+encodeURIComponent(reaction_date)+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Certainity="+Certainity+"&severity_main="+encodeURIComponent(severity_main)+"&Encounter_Id="+Encounter_Id+"&diagnosis_code="+encodeURIComponent(diagnosis_code)+"&severity_code="+severity_code+"&active_date="+encodeURIComponent(active_date)+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn
		+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
		parent.frames[3].location.href=url;*/
		
		var url="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?mode=modify&causative_code="+causative_code+"&reaction_date="+encodeURIComponent(reaction_date)+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Certainity="+Certainity+"&severity_main="+encodeURIComponent(severity_main)+"&Encounter_Id="+Encounter_Id+"&diagnosis_code="+encodeURIComponent(diagnosis_code)+"&severity_code="+severity_code+"&active_date="+encodeURIComponent(active_date)+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn
		+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status+"&sPhInstalled_YN="+sPhInstalled_YN;
		parent.frames[3].location.href=url; /*Modified By Rameswar on 4th June 2015 Against AAKH-SCF-0198 IN055068*/

		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=modify&reaction_date="+encodeURIComponent(reaction_date)+"&severity_main="+encodeURIComponent(severity_main)+"&severity_code="+severity_code+"&causative_code="+causative_code+"&PatientId="+PatientId+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
		parent.frames[4].location.href=url;


		var url2="../../eMR/jsp/RecordPatientAdverseEventadddetail.jsp?flag=N&mode=modify&causative_code="+causative_code+"&reaction_date="+encodeURIComponent(reaction_date)+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Certainity="+Certainity+"&severity_main="+encodeURIComponent(severity_main)+"&adv_event_dtl_srl_no="+adv_event_dtl_srl_no+"&Encounter_Id="+Encounter_Id+"&causative_substance="+encodeURIComponent(causative_substance)+"&active_date="+encodeURIComponent(active_date);
		
		parent.frames[5].location.href=url2;


		}
}

/*based on the status selected in modify mode reason or remarks area is built dynamically*/
function chk_man(obj)
{
	 
	if(obj.value=="E")
	{
		

		document.getElementById("status_val").innerHTML=getLabel("Common.reason.label","Common");
		document.forms[0].all.status_date.innerHTML=getLabel("Common.Ason.label","Common");

		document.getElementById("status_val2").innerHTML="<textarea name='err_remark' onkeypress='return imposeMaxLength(this, 30);' rows='1' column='30' style='resize: none;'   ></textarea>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			parent.frames[3].document.forms[0].date_time.disabled=false;
			parent.frames[3].document.forms[0].date_time_cal.disabled=false;
			parent.frames[4].document.forms[0].cause_sub.disabled=true;
			parent.frames[4].document.forms[0].treat_advice.disabled=true;
			parent.frames[4].document.forms[0].remarks.disabled=true;
			parent.frames[4].document.forms[0].allergy_test_res.disabled=true;
			parent.frames[4].document.forms[0].Site_Of_Reac.disabled=true;
			
			parent.frames[4].document.forms[0].severity.disabled=true;
			parent.frames[4].document.forms[0].route_exp.disabled=true;
			parent.frames[4].document.forms[0].reaction_date.disabled=true;
			parent.frames[4].document.forms[0].cal1.disabled=true;
			
			parent.frames[4].document.forms[0].add_reaction.disabled=true;
			parent.frames[4].document.forms[0].pat_obser.disabled=true;
			parent.frames[4].document.forms[0].aller_test.disabled=true;
			parent.frames[4].document.forms[0].Staff_obser.disabled=true;
			parent.frames[4].document.forms[0].reac_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].cal_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].expo_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].sever_img.style.visibility="hidden";


	}else if(obj.value=="R")
	{
		
		document.getElementById("status_val").innerHTML=getLabel("Common.remarks.label","Common");
		document.getElementById("status_val2").innerHTML="<textarea name='err_remark'  style='resize: none;'  onkeypress='return imposeMaxLength(this, 30);' rows='1' column='30'  ></textarea>&nbsp;&nbsp;";
			parent.frames[3].document.forms[0].date_time.disabled=false;
			parent.frames[3].document.forms[0].date_time_cal.disabled=false;
			parent.frames[4].document.forms[0].cause_sub.disabled=true;
			parent.frames[4].document.forms[0].treat_advice.disabled=true;
			parent.frames[4].document.forms[0].remarks.disabled=true;
			parent.frames[4].document.forms[0].allergy_test_res.disabled=true;
			parent.frames[4].document.forms[0].Site_Of_Reac.disabled=true;
			
			parent.frames[4].document.forms[0].severity.disabled=true;
			parent.frames[4].document.forms[0].route_exp.disabled=true;
			parent.frames[4].document.forms[0].reaction_date.disabled=true;
			parent.frames[4].document.forms[0].cal1.disabled=true;
			
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
			parent.frames[4].document.forms[0].pat_obser.disabled=true;
			parent.frames[4].document.forms[0].aller_test.disabled=true;
			parent.frames[4].document.forms[0].Staff_obser.disabled=true;
			parent.frames[4].document.forms[0].reac_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].cal_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].expo_man.style.visibility="hidden";
			parent.frames[4].document.forms[0].sever_img.style.visibility="hidden";
		document.forms[0].status_date.innerHTML=getLabel("Common.Ason.label","Common");


	}else if(obj.value=="O")
	{
	
		document.getElementById("status_val").innerHTML=getLabel("Common.reason.label","Common");
		document.getElementById("status_val2").innerHTML="<textarea name='err_remark'  id ='err_remark' style='resize: none;'  onkeypress='return imposeMaxLength(this, 30);' rows='1' column='30'  ></textarea>&nbsp;&nbsp;";
			parent.frames[3].document.forms[0].date_time.disabled=true;
			parent.frames[3].document.forms[0].date_time_cal.disabled=true;
			parent.frames[4].document.forms[0].cause_sub.disabled=false;
			parent.frames[4].document.forms[0].treat_advice.disabled=false;
			parent.frames[4].document.forms[0].remarks.disabled=false;
			parent.frames[4].document.forms[0].allergy_test_res.disabled=false;
			parent.frames[4].document.forms[0].Site_Of_Reac.disabled=false;
			
			parent.frames[4].document.forms[0].severity.disabled=false;
			parent.frames[4].document.forms[0].route_exp.disabled=false;
			parent.frames[4].document.forms[0].reaction_date.disabled=false;
			parent.frames[4].document.forms[0].cal1.disabled=false;
			
			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].pat_obser.disabled=false;
			parent.frames[4].document.forms[0].aller_test.disabled=false;
			parent.frames[4].document.forms[0].Staff_obser.disabled=false;
			parent.frames[4].document.forms[0].reac_man.style.visibility="visible";
			parent.frames[4].document.forms[0].cal_man.style.visibility="visible";
			parent.frames[4].document.forms[0].expo_man.style.visibility="visible";
			parent.frames[4].document.forms[0].sever_img.style.visibility="visible";
			document.forms[0].status_date.innerHTML=getLabel("Common.since.label","Common");


	}
} 

/*Called on click of Allergen selected selected from existing old records*/ 
function display_header(m,Encounter_Id,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,Certainity,severity_main,onset_date,diagnosis_code,severity_code,active_date,final_reac_code_val,term_code,reaction_date,status,source_of_info,route_of_exposure,estimated_duration,inerror_date,resolved_date,others_reaction,drug_code,onset_type,cnt_recurring,advEventSrlNo,adv_event_dtl_srl_no)//drug_code argument added by Dharma on Jan 29th 2015 against  ML-BRU-SCF-1520 [IN:053155]
//advEventSrlNo added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751
//adv_event_dtl_srl_no Added by Ashwini on 30-Nov-2020 for SKR-SCF-1499
{ 

	if(status=='Active')
	status='A';
else if(status=='Resolved')
	status='R';
else if(status=='In Error')
	status='E';

//

if(Certainity=='Definitive')
	Certainity='D';
else if(Certainity=='Probable')
	Certainity='P';
	
	parent.frames[6].document.forms[0].markerror.style.visibility='visible';
	parent.frames[6].document.forms[0].record.style.visibility='visible';
if(status!="A")
	{
	parent.frames[6].document.forms[0].markerror.style.visibility='hidden';
	parent.frames[6].document.forms[0].record.style.visibility='hidden';
	}
	
	
		if(parent.parent.workAreaFrame!=null)
		{
			
			//parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,13%,20%,0,5%";
			parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,6%,1%,8%,5%,0,5%";//Modified for the CRF - RUT-CRF-0064
		}
		else
		{	
			
			
			//parent.document.getElementById("allergy_recording").rows="15%,6%,1%,11%,5%,0%,5%,2%";//Modified for the CRF - RUT-CRF-0064
			parent.document.getElementById('resultpage').style.height = "26vh";
			parent.document.getElementById('resultpage1').style.height = "15vh";
			parent.document.getElementById('staticcolorpage').style.height = "1vh";
			parent.document.getElementById('Headerpage').style.height = "29vh";
			parent.document.getElementById('reaction_details_page').style.height = "12vh";
			parent.document.getElementById('detail_view').style.height = "0vh";
			parent.document.getElementById('detail_view').style.display="none";
			parent.document.getElementById('submitframe').style.height = "4vh";
			parent.document.getElementById('messageFrame').style.height = "6vh";
		}


	
	var active_diagnosis=parent.Headerpage.document.forms[0].active_diag_cnt.value;
	
	//var url="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?mode=record&causative_code="+causative_code+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Certainity="+Certainity+"&severity_main="+severity_main+"&onset_date="+onset_date+"&diagnosis_code="+diagnosis_code+"&severity_code="+severity_code+"&active_date="+active_date+"&causative_substance="+ encodeURIComponent(causative_substance)+"&source_of_info="+source_of_info+"&route_of_exposure="+route_of_exposure+"&estimated_duration="+estimated_duration+"&reaction_date="+reaction_date+"&status_db="+status+"&resolved_date="+resolved_date+"&inerror_date="+inerror_date+"&diagnosis_code="+diagnosis_code+"&term_code="+term_code;
	
	/*encodeURIComponent(), Below Line Added by Senthil on 21-Nov-2011 [IN:026962]*/
	var lsRegExp = /\+/g;  
    var causativesubstance=unescape(String(eval("document.forms[0].causative_substanc"+m).value).replace(lsRegExp, " ")); 
	
    //End
	//Added for the CRF - RUT-CRF-0064
    var allergy_conf_reqd_yn=parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value;
	var sPhInstalled_YN=parent.frames[3].document.forms[0].sPhInstalled_YN.value; /*Added By Rameswar on 4th June 2015 Against AAKH-SCF-0198 IN055068*/



	/*var url="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?mode=record&causative_code="+causative_code+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&Certainity="+Certainity+"&severity_main="+severity_main+"&onset_date="+onset_date+"&diagnosis_code="+diagnosis_code+"&severity_code="+severity_code+"&active_date="+active_date+"&causative_substance="+encodeURIComponent(causativesubstance)+"&source_of_info="+source_of_info+"&route_of_exposure="+route_of_exposure+"&estimated_duration="+estimated_duration+"&reaction_date="+reaction_date+"&status_db="+status+"&resolved_date="+resolved_date+"&inerror_date="+inerror_date+"&diagnosis_code="+diagnosis_code+"&term_code="+term_code+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn+"&drug_code="+encodeURIComponent(drug_code);*/
 
 
var url="../../eMR/jsp/RecordPatientAdverseEvent5.jsp?mode=record&causative_code="+causative_code+"&advEventSrlNo="+advEventSrlNo+"&adv_event_dtl_srl_no="+adv_event_dtl_srl_no+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&PatientId="+PatientId+"&Encounter_Id="+Encounter_Id+"&Certainity="+Certainity+"&severity_main="+severity_main+"&onset_date="+onset_date+"&diagnosis_code="+diagnosis_code+"&severity_code="+severity_code+"&active_date="+active_date+"&causative_substance="+encodeURIComponent(causativesubstance)+"&source_of_info="+source_of_info+"&route_of_exposure="+route_of_exposure+"&estimated_duration="+estimated_duration+"&reaction_date="+reaction_date+"&status_db="+status+"&resolved_date="+resolved_date+"&inerror_date="+inerror_date+"&diagnosis_code="+diagnosis_code+"&term_code="+term_code+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn+"&drug_code="+encodeURIComponent(drug_code)+"&sPhInstalled_YN="+sPhInstalled_YN+"&onset_type="+onset_type+"&comments="+encodeURIComponent(eval("document.forms[0].comment"+m).value); /*Modified By Rameswar on 4th June 2015 Against AAKH-SCF-0198 IN055068*/



	parent.frames[3].location.href=url;
	
	var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=record&severity_main="+severity_main+"&severity_code="+severity_code+"&causative_code="+causative_code+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type_code+"&Encounter_Id="+Encounter_Id+"&status="+status+"&reac_code_val="+final_reac_code_val+"&otr_reaction="+others_reaction+"&onset_date="+onset_date+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&allergy_conf_reqd_yn="+allergy_conf_reqd_yn;
	parent.frames[4].location.href=url;
    
/*  clear ing session  */

	var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='CLEAR_ALL_SESSION_VALUES'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
	

	

	var url1="../../eMR/jsp/RecordPatientAdverseEventadddetail.jsp?mode=record&causative_code="+causative_code+"&reaction_date="+reaction_date+"&PatientId="+PatientId+"&status_db="+status+"&severity_code="+severity_code+"&final_reac_code_val="+final_reac_code_val+"&adv_event_type_ind_code="+adv_event_type_ind_code+"&adv_event_type_code="+adv_event_type_code+"&active_date="+active_date+"&diagnosis_code="+diagnosis_code+"&term_code="+term_code+"&flag_db=DB&resolved_date="+resolved_date+"&inerror_date="+inerror_date;
	
	

}
/*Called when the boolean value returned is true from servlet*/
function Onsuccess()
{
	
	alert(getMessage("RECORD_INSERTED","SM"));
	if(top.content!=null && !parent.parent.document.getElementById('dialog-body'))
	{

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='CLEAR_ALL_SESSION_VALUES'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		top.content.messageFrame.location.href="../eCommon/jsp/MstCodeError.jsp";
		top.content.workAreaFrame.location.reload();
		
		top.plineFrame.location.reload();

		
	


	}
	else
	{

		parent.frames[0].location.reload();
		parent.frames[1].location.reload();
		parent.frames[2].location.reload();
		parent.frames[3].location.reload();
		parent.frames[4].location.reload();
		parent.frames[5].location.reload();
		parent.frames[6].location.reload();
		
	    //parent.window.close();
		//window.close(); 
		//parent.document.getElementById('dialog_tag').close();
		parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	}
	
}
async function callAllery(patient_id)
{
	
	var dialogHeight= "39vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "76";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";

	var retVal=await window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);
}
/*Function to open diagnosis window*/

async function openDiagnosis()
{

	var patient_id=parent.frames[6].document.forms[0].PatientId.value;
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "PH";

	//if(parent.parent.parent.frames[2].frames[2].frames[2].document.forms[0].active_diag_cnt.value !="0")
	
	if(parent.frames[2].document.forms[0].active_diag_cnt.value !="0")
	{
	if(module_id=="PH")   //Used only For Pharmacy Orders
	{
		 function_id	= "PH";
		 no_of_items 	= "1";
		 option_type	= "ACTIVE";

	}
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type;
	var retVal 			= new String();
	var dialogHeight 	= "38vh" ;
	var dialogWidth  	= "65vw" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
	
	if(retVal!=undefined && retVal !="")
	{
		var dia_val=retVal.split("||");
		var dia_val2=dia_val[0];
		var dia_val3=dia_val2.split("|");
		var dia_desc=dia_val3[1];
		var dia_code=dia_val3[0];

		document.forms[0].diagnosis.value=dia_desc;
		document.forms[0].diagnosis_code.value=dia_code;
	}else
	{
		document.forms[0].diagnosis.value="";
		document.forms[0].diagnosis_code.value="";
	}
	} else
	{

		

			var Encounter_Id= parent.frames[6].document.forms[0].Encounter_Id.value;
			var Pract_id=parent.frames[6].document.forms[0].Pract_id.value;
			var practitioner_type=parent.frames[6].document.forms[0].practitioner_type.value;
			var patient_class=parent.frames[6].document.forms[0].patient_class.value;

			var dialogHeight= "41vh";
			var dialogWidth = "65vw";
			var dialogTop	= "72";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal =await  window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&patient_id="+patient_id+"&encounter_id="+Encounter_Id+"&episode_id="+Encounter_Id+"&Pract_id="+Pract_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class,arguments,features);
			if(retVal !="")
	{
		var dia_val=retVal.split("^");
		//var dia_val2=dia_val[0];
	//	var dia_val3=dia_val2.split("|");
		var dia_desc=dia_val[2];
		var dia_code=dia_val[1];
		var term_code=dia_val[0];

		document.forms[0].diagnosis.value=dia_desc;
		document.forms[0].diagnosis_code.value=dia_code;
		document.forms[0].term_code.value=term_code;
	}else
	{
		document.forms[0].diagnosis.value="";
		document.forms[0].diagnosis_code.value="";
		document.forms[0].term_code.value="";
	}
	}

}

async function openDiagnosis1()
{

 var retVal 			= new String();
var patient_id=document.forms[0].PatientId.value;
var encounter_id=document.forms[0].Encounter_Id.value;
//var patient_id="BL09000930";
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "PH";

	//if(parent.parent.parent.frames[2].frames[2].frames[2].document.forms[0].active_diag_cnt.value !="0")
/*
	This is logic for runtime we can find the dignosis count



*/
		var xmlDoc = ""
		 var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patient_id = \""+patient_id+"\" steps='11'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)

		/*

		*/

if(document.forms[0].active_diag_cnt.value !="0")
	{
	if(module_id=="PH")   //Used only For Pharmacy Orders
	{
		 function_id	= "PH";
		 no_of_items 	= "1";
		 option_type	= "ACTIVE";

	}
	var query_string	= "encounter_id="+encounter_id+"&patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type;
	
	//var retVal 			= new String();
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "95vw" ;
	var dialogTop    	= "10";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
	
	if(retVal!=undefined && retVal !="")
	{
		var dia_val=retVal.split("||");
		var dia_val2=dia_val[0];
		var dia_val3=dia_val2.split("|");
		var dia_desc=dia_val3[1];
		var dia_code=dia_val3[0];

		document.forms[0].diagnosis.value=dia_desc;
		document.forms[0].diagnosis_code.value=dia_code;
		
	}else
	{
		document.forms[0].diagnosis.value="";
		document.forms[0].diagnosis_code.value="";
	}
	}else
	{

		

			var Encounter_Id= document.forms[0].Encounter_Id.value;
			var Pract_id=document.forms[0].Pract_id.value;
			var practitioner_type=document.forms[0].practitioner_type.value;
			var patient_class=document.forms[0].patient_class.value;
			var Locn_Code=document.forms[0].Locn_Code.value;
			var location_type=document.forms[0].location_type.value;
			var speciality_code=document.forms[0].speciality_code.value;


			var dialogHeight= "90vh";
			var dialogWidth = "100vw";
			var dialogTop	= "10";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			//retVal =  window.open("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&patient_id="+patient_id+"&encounter_id="+Encounter_Id+"&episode_id="+Encounter_Id+"&Pract_id="+Pract_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&speciality_code="+speciality_code+"&location_type="+location_type+"&Locn_Code="+Locn_Code,arguments,'height=937,width=1012,top=0,left=0');
			retVal = await  window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&patient_id="+patient_id+"&encounter_id="+Encounter_Id+"&episode_id="+Encounter_Id+"&Pract_id="+Pract_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&speciality_code="+speciality_code+"&location_type="+location_type+"&Locn_Code="+Locn_Code,arguments,features);


			if(retVal !="" && retVal != null && retVal != undefined)
			{
		var dia_val=retVal.split("^");
	   var dia_val2=dia_val[0];
		var dia_val3=dia_val2.split("|");
		var dia_desc=dia_val[2];
		var dia_code=dia_val[1];
		var term_code=dia_val[0];

		document.forms[0].diagnosis.value=dia_desc;
		document.forms[0].diagnosis_code.value=dia_code;
		document.forms[0].term_code.value=term_code;
		}else
		{
		document.forms[0].diagnosis.value="";
		document.forms[0].diagnosis_code.value="";
		document.forms[0].term_code.value="";
		}
	}

}


/*To set the severity value in the header*/
function set_severe_value(obj)
{

 if(parent.frames[3].document.forms[0].severity_head.value=='U')
	{
	parent.frames[3].document.forms[0].severity.value=obj.value;
	parent.frames[3].document.forms[0].severity.disabled=true;
	}else if(parent.frames[3].document.forms[0].severity_head.value=='M')
	{
		if(obj.value=='M' || obj.value =='O' || obj.value =='S')
		{
			parent.frames[3].document.forms[0].severity.value=obj.value;
			parent.frames[3].document.forms[0].severity.disabled=true;
		}else
		{
			alert(getMessage("MAINTAIN_SEVERITY_LEVEL","MR"));
			parent.frames[4].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
			parent.frames[3].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
		}
	}else if(parent.frames[3].document.forms[0].severity_head.value=='O')
	{
		if(obj.value =='O' || obj.value =='S')
		{
			parent.frames[3].document.forms[0].severity.value=obj.value;
			parent.frames[3].document.forms[0].severity.disabled=true;
		}else
		{
			alert(getMessage("MAINTAIN_SEVERITY_LEVEL","MR"));
			parent.frames[4].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
			parent.frames[3].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
		}
	}else if(parent.frames[3].document.forms[0].severity_head.value=='S')
	{
		if(obj.value =='S')
		{
			parent.frames[3].document.forms[0].severity.value=obj.value;
			parent.frames[3].document.forms[0].severity.disabled=true;
		}else
		{
			alert(getMessage("MAINTAIN_SEVERITY_LEVEL","MR"));
			parent.frames[4].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
			parent.frames[3].document.forms[0].severity.value=parent.frames[2].document.forms[0].severity_head.value;
		}
	}
}

async function open_cause_subs_lup()
{
		
		var allergen_code=parent.frames[3].document.forms[0].allergen_id.value;
		var locale=document.forms[0].locale.value;

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var sql="select DRUG_CODE code , DRUG_DESC description from  ph_drug_lang_vw where GENERIC_ID='"+allergen_code+"' and language_id='"+locale+"' AND upper(DRUG_CODE) like upper(?) and upper(DRUG_DESC) like upper(?) ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].cause_sub.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 
		var arr=new Array();
		retVal =await CommonLookup(getLabel("eMR.DrugLookup.label","MR"), argumentArray );
		
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			document.forms[0].cause_sub.value=arr[1];
			document.forms[0].drug_code.value=arr[0];
		}else
		{
			document.forms[0].cause_sub.value="";
			document.forms[0].drug_code.value="";
		}
		
}


function call_reaction_window()
{

}
function allow_nochars( val ) {

	var text_val=val.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		val.value="";
	}
}
function resetForm()
{
	document.forms[0].search_text.value="";
	parent.frames[1].document.forms[0].reset();
	parent.frames[2].document.forms[0].other_reaction.value="";

}

function load_reaction_table()
{
	//window.setTimeOut('',500)
	
	if(parent.frames[5].document.forms[0].mode.value =="insert")
	{

		if (document.forms[0].react_code_final.value !="")
		{  			
			parent.frames[4].document.getElementById('reaction_table').style='display';

			parent.frames[4].document.forms[0].add_reaction.disabled=false;	
            			
			
		}
		//ICN 6178.4  to display other reaction  11/7/2008
		else if(document.forms[0].otr_reaction.value != ""){
			
			parent.frames[4].document.getElementById('reaction_table').style='display';

			parent.frames[4].document.forms[0].add_reaction.disabled=false;
		}//
		else{
			/*already the reaction_table will be in none only */
			//parent.frames[4].document.forms[0].reaction_table.style.display="none"; 
			/* Below line added for existing bug by venkatesh */
			if(parent.frames[4].document.forms[0].allergen.value!=""){
			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			}else{parent.frames[4].document.forms[0].add_reaction.disabled=true;}
			/*end*/
		}
	}else if(parent.frames[5].document.forms[0].mode.value =="record")
	{

		if(parent.frames[4].document.forms[0] != null)
			parent.frames[4].document.getElementById('reaction_table').style='display';
	}else
	{

	}
	if(parent.frames[4].document.forms[0].react_code_final.value!="" )
	{

		//10/23/2008 8:25 PM
	//parent.frames[4].document.getElementById("add_resc").style.visibility='hidden';
	}
}
function scrollTitle_reaction()
{
  var x = document.body.scrollTop;
var mode=parent.frames[4].document.forms[0].mode.value;

	  if(x == 0){
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;

   }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-5;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-5;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-5;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-5;

	 }


}

async function onblur_reaction(obj)
{ 

	var event_done	= "onClick";

	var flag		= parent.frames[5].document.forms[0].flag.value;
	var react_val	= parent.frames[3].document.forms[0].react_values.value;
	var mode		= parent.frames[3].document.forms[0].mode.value;	
	//var reac_code_val_prev=parent.frames[5].document.forms[0].final_reac_code_val.value;
	var reac_code_val_prev		= parent.frames[1].document.forms[0].final_reac_code_val.value;
	var reac_code_val_prev_one	= parent.frames[4].document.forms[0].react_code_final.value;
	var reac_desc_val_prev_one	= parent.frames[4].document.forms[0].reac_desc_val.value;
	var onset_date1	= parent.frames[4].document.forms[0].onset_date1.value;
	var status		= document.forms[0].status.value;
	var since_date	= parent.frames[3].document.forms[0].since_date.value
	var oldreactionvalue_count=parent.frames[4].document.forms[0].oldreactionvalue_count.value;	
	if(reac_code_val_prev_one !="")
	{
		reac_code_val_prev_one	= reac_code_val_prev_one.substring(2,reac_code_val_prev_one.length)
	}
	var oth_reaction= document.forms[0].oth_reaction.value;
	var allergen;
	var search_text	= obj.value;
	var count_val	= parent.frames[4].document.forms[0].count_val.value;
	var oth_reaction_counter	= parent.frames[4].document.forms[0].oth_reaction_counter.value;
	var final_total = "";
	var final_total_oth			= "";
	var final_total_record		= "";
	var final_total_oth_record	= "";	
	if(mode =="insert")
	{
		allergen=parent.frames[3].document.forms[0].allergen_id.value;
		if(since_date == "")
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].onset_date.value;
			var	addReactionDate1	= addReactionDate.substring(0,16);
		
		}else
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].since_date.value;
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}
	}else
	{
		allergen=parent.frames[3].document.forms[0].causative_code.value;
		if(since_date == "")
		{
			var	addReactionDate		= convertDate(parent.frames[3].document.forms[0].reaction_date.value,"DMY","en",localeName);
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}else
		{
			var	addReactionDate		= parent.frames[3].document.forms[0].since_date.value;
			var	sysdate				= parent.frames[3].document.forms[0].sysdate.value;
			var sysdate_time		= sysdate.substring(10,16);
			var	addReactionDate1	= addReactionDate+""+sysdate_time;
		}
	}
 
	if(mode =="insert")
	{
		if(count_val != 0){
			for(var i = 0 ; i<= count_val-1 ; i++)
			{
				/*Wednesday, December 23, 2009 , to check reaction date mandatory*/
				if (parent.frames[4].document.forms[0]["reaction_date" + i].value === "")
				{
					var error1;
					error1=getMessage("CAN_NOT_BE_BLANK","common");
					error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error1);
					return false;
				}else
				{   var code = parent.frames[4].document.forms[0]["reaction_code" + i].value;
					var a = parent.frames[4].document.forms[0]["reac_desc" + i].value;
					var b = parent.frames[4].document.forms[0]["reaction_date" + i].value;
					var c = parent.frames[4].document.forms[0]["severity" + i].value;
						if(c == "")
						c="~";
					var d = parent.frames[4].document.forms[0]["Site_Of_Reac" + i].value;
					if(d == "")	
					d="~";
					
					//final_total += a+"^"+b+"^"+c+"^"+d+"!";
					final_total_record +=code+"^"+a+"^"+b+"^"+c+"^"+d+"!";	
				}
				
			}
		}
		if(oth_reaction_counter != 0){
			
			for(var i = 0 ; i<= oth_reaction_counter-1 ; i++)
			{
				/*Wednesday, December 23, 2009 , to check reaction date mandatory*/
				if(eval("parent.frames[4].document.forms[0].other_reaction_date"+i+".value") == "")
				{
					var error2;
					error2=getMessage("CAN_NOT_BE_BLANK","common");
					error2=error2.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error2);
					return false;
				}
				else
				{
					var e = parent.frames[4].document.forms[0]["oth_reac_desc" + i].value;
                   var f = parent.frames[4].document.forms[0]["other_reaction_date" + i].value;
                  var g = parent.frames[4].document.forms[0]["severity_oth" + i].value;
						if(g == "")
						g="~";
					var h = parent.frames[4].document.forms[0]["Site_Of_Reac_oth" + i].value;
					if(h == "")	
					h="~";
					
					final_total_oth += e+"^"+f+"^"+g+"^"+h+"!";
				}
				
			}
		}
		
	}
	if(mode=="record")
	{ /*get the previous Reaction added by Senthil on 16-08-2011*/	
		var oldreactionvalue_count=parent.frames[4].document.forms[0].oldreactionvalue_count.value;		
		if(oldreactionvalue_count!=0){
		var reactcode="";
		for(var m=0; m<=oldreactionvalue_count-1;m++){
		     reactcode+=eval("parent.frames[4].document.forms[0].adv_reac_event_code"+m+".value")+"`";			 
		}
	      reactcode=reactcode.substring(0,reactcode.length-1);		 
		}	
		if(count_val != 0){
			for(var i = 0 ; i<= count_val-1 ; i++)
			{
				if(eval("parent.frames[4].document.forms[0].reaction_date"+i+".value") == "")
				{
					var error1;
					error1=getMessage("CAN_NOT_BE_BLANK","common");
					error1=error1.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error1);
					return false;
				}else
				{   var code = eval("parent.frames[4].document.forms[0].reaction_code"+i+".value")
					var a = eval("parent.frames[4].document.forms[0].reac_desc"+i+".value")
					var b = eval("parent.frames[4].document.forms[0].reaction_date"+i+".value")
					var c = eval("parent.frames[4].document.forms[0].severity"+i+".value")
						if(c == "")
						c="~";
					var d = eval("parent.frames[4].document.forms[0].Site_Of_Reac"+i+".value")
					if(d == "")	
					d="~";
					//final_total_record += a+"^"+b+"^"+c+"^"+d+"!";
					final_total_record +=code+"^"+a+"^"+b+"^"+c+"^"+d+"!";	
				}
				
			}
		}
		 if(oth_reaction_counter != 0)
		 {
			for(var i = 0 ; i<= oth_reaction_counter-1 ; i++)
			{
				if(eval("parent.frames[4].document.forms[0].other_reaction_date"+i+".value") == "")
				{
					var error2;
					error2=getMessage("CAN_NOT_BE_BLANK","common");
					error2=error2.replace("$",getLabel("Common.ReactionDate.label","Common"));
					alert(error2);
					return false;
				}else
				{
					var e = eval("parent.frames[4].document.forms[0].oth_reac_desc"+i+".value")
					var f = eval("parent.frames[4].document.forms[0].other_reaction_date"+i+".value")
					var g = eval("parent.frames[4].document.forms[0].severity_oth"+i+".value")
						if(g == "")
						g="~";
					var h = eval("parent.frames[4].document.forms[0].Site_Of_Reac_oth"+i+".value")
					if(h == "")	
					h="~";
					
					final_total_oth_record += e+"^"+f+"^"+g+"^"+h+"!";
				}
				
			}
		}
			

	}
	var patient_id=parent.frames[3].document.forms[0].PatientId.value;
	var Encounter_Id=parent.frames[3].document.forms[0].Encounter_Id.value;
	//var adv_event_ind=parent.frames[5].document.forms[0].adv_event_type_ind_code.value;
	//var adv_event_type=parent.frames[5].document.forms[0].adv_event_type_code.value;
	var adv_event_type=parent.frames[3].document.forms[0].adv_event_type_code.value;
	var adv_event_ind=parent.frames[1].document.forms[0].adv_event_type_ind_code.value;
	var reactCodes3 = parent.frames[3].document.forms[0].reactCodes3.value;
	var dialogHeight= "28vh" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status  + "; dialogTop :" + dialogTop ;
	//var callurl="../../eMR/jsp/RecordPatientAdverseEvent3.jsp?mode="+mode+"&allergen="+allergen+"&react_val="+react_val+"&flag="+flag+"&search_text="+search_text+"&event_done="+event_done+"&oth_reaction="+oth_reaction;
	//status=document.forms[0].status.value;
	var callurl="../../eMR/jsp/RecordPatientAdverseEvent3.jsp?mode="+mode+"&allergen="+allergen+"&react_val="+react_val+"&flag="+flag+"&patient_id="+patient_id+"&search_text="+encodeURIComponent(search_text)+"&adv_event_ind="+adv_event_ind+"&adv_event_type="+adv_event_type+"&oth_reaction="+encodeURIComponent(oth_reaction)+"&event_done="+event_done+"&status="+status+"&reactCodes3="+reactCodes3+"&onblurRec=Y "+"&reactcode="+reactcode+"&oldreactionvalue_count="+oldreactionvalue_count+" ";
	
	if(mode=="record" || oldreactionvalue_count==0){
	       reac_code_val_prev=reactcode;
	 }
	
	var retVal = new String();
	retVal =await window.showModalDialog(callurl,arguments,features);
	if(retVal !=undefined && retVal!=""&&retVal!=''){	
		parent.frames[3].document.forms[0].react_values.value=retVal;
		parent.frames[5].document.forms[0].react_values1.value=retVal;
		var reactCodes3Split = retVal.split('`');
		parent.frames[3].document.forms[0].reactCodes3.value=reactCodes3Split[0];
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH retVal=\""+retVal+"\" allergen=\""+allergen+"\" reac_code_val_prev=\""+reac_code_val_prev+"\" patient_id=\""+patient_id+"\" adv_event_ind=\""+adv_event_ind+"\" adv_event_type=\""+adv_event_type+"\" final_total=\""+final_total+"\" steps='8'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
	}/*else
	{
		//parent.frames[3].document.forms[0].react_values.value="";
	}*/
	
	if(retVal !=undefined)
		{   

	//Painting of reaction part happens over hre
	
			if(parent.parent.workAreaFrame!=null){
			parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="8%,6%,1%,8%,5%,0%,5%";//Modified for the CRF - RUT-CRF-0064
			

				//parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
			}
			else{
				parent.document.getElementById("allergy_recording").rows='15%,6%,1%,11%,5%,0%,5%,2%';//Modified for the CRF - RUT-CRF-0064
				//parent.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
			}
	parent.frames[4].document.forms[0].add_reaction.disabled=false;
	parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
	if(parent.parent.workAreaFrame!=null)
	parent.parent.workAreaFrame.document.getElementById("reaction_details_page").style.visibility='visible';
	var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	var reac_desc_val=parent.frames[4].document.forms[0].reaction_value.value;
	var final_reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	var final_reac_desc_val=parent.frames[4].document.forms[0].reac_desc1_val.value;      
			if(reac_code_val_prev_one !="")
			{
				final_reac_code_val=reac_code_val + reac_code_val_prev_one;
				final_reac_desc_val=reac_desc_val;
			}			
			if(parent.frames[3].document.forms[0].mode.value =="insert")
			{   
				var	causative_code=parent.frames[3].document.forms[0].causative_code.value;
				var PatientId=parent.frames[3].document.forms[0].PatientId.value;
			  /*Remove Record When UnCheck the CheckBox*/	
			if(retVal!=undefined && retVal==""){ 
              parent.frames[4].document.forms[0].react_code_final.value = "";
			  parent.frames[4].document.forms[0].reac_desc_val.value = "";
			  parent.frames[3].document.forms[0].reactCodes3.value="";
			  parent.frames[3].document.forms[0].react_values.value="";			  
		      }
				var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=insert&final_total_oth="+final_total_oth+"&final_total="+final_total+"&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&Encounter_Id="+Encounter_Id+"&status="+status+"&reaction_date_disply="+encodeURIComponent(addReactionDate1)+" ";
				parent.frames[4].location.href=url;
				parent.frames[6].location.href="../../eMR/jsp/RecordPatientAdverseEvent9.jsp";
			
			}else
			{  
				
			if(retVal!=undefined && retVal==""){ 
			    
                parent.frames[4].document.forms[0].reac_desc_val.value = "";
			    parent.frames[3].document.forms[0].reactCodes3.value="";
			    parent.frames[3].document.forms[0].react_values.value="";
				parent.frames[6].document.forms[0].markerror.style.visibility='visible';
				}else{
					parent.frames[6].location.href="../../eMR/jsp/RecordPatientAdverseEvent9.jsp";
				}

				var final_total=final_total_record;
				var final_total_oth=final_total_oth_record;
				var	causative_code=parent.frames[3].document.forms[0].causative_code.value;
				var PatientId=parent.frames[3].document.forms[0].PatientId.value;
				var	otr_reaction=parent.frames[4].document.forms[0].otr_reaction.value;
				var adv_event_type_ind_code1=parent.frames[4].document.forms[0].adv_event_type_ind_code1.value;	
				var status=document.forms[0].status.value;  
                   /*Remove Record When UnCheck the CheckBox*/
					
				
				var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=record&final_total_oth="+final_total_oth+"&final_total="+final_total+"&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&adv_event_type_ind_code="+adv_event_type_ind_code1+"&otr_reaction="+encodeURIComponent(otr_reaction)+"&onset_date="+encodeURIComponent(onset_date1)+"&status="+status+"&adding_react_yn=Y&reaction_date_disply="+encodeURIComponent(addReactionDate1)+" ";

				parent.frames[4].location.href=url;
		//		parent.frames[6].location.href="../../eMR/jsp/RecordPatientAdverseEvent9.jsp";
				
			    
		     
			}
		}else
		{
			if(parent.parent.workAreaFrame!=null){

				//parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
				//parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="5%,6%,1%,8%,5%,0%,5%";
				parent.parent.workAreaFrame.document.getElementById("allergy_recording").rows="10%,10%,0%,15%,20%,0,5%";
			}
			else
			{
				//parent.document.getElementById("allergy_recording").rows="10%,10%,0%,30%,20%,5%,0,5%";
				//parent.document.getElementById("allergy_recording").rows='9%,6%,1%,7%,5%,0%,5%,2%';
				parent.document.getElementById("allergy_recording").rows="7%,6%,1%,11%,5%,0%,5%,2%";

			}
	
	/*parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
	var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?mode=insert";*/
	parent.frames[4].document.forms[0].add_reaction.disabled=false;
	parent.frames[4].document.forms[0].add_reaction_search.disabled=false;

	var	causative_code=parent.frames[3].document.forms[0].causative_code.value;
	var PatientId=parent.frames[3].document.forms[0].PatientId.value;
	var	otr_reaction=parent.frames[4].document.forms[0].otr_reaction.value;
   var adv_event_type_ind_code1=parent.frames[4].document.forms[0].adv_event_type_ind_code1.value;	
   var status=document.forms[0].status.value;
   var reac_code_val=parent.frames[4].document.forms[0].react_code_final.value;
	var reac_desc_val=parent.frames[4].document.forms[0].reac_desc_val.value;
	var url="../../eMR/jsp/RecordPatientAdverseEvent13.jsp?final_total_oth="+final_total_oth+"&final_total="+final_total+"&mode="+mode+"&reac_code_val="+reac_code_val+"&reac_desc_val="+reac_desc_val+"&PatientId="+PatientId+"&adv_event_type_code="+adv_event_type+"&causative_code="+causative_code+"&adv_event_type_ind_code="+adv_event_type_ind_code1+"&otr_reaction="+encodeURIComponent(otr_reaction)+"&onset_date="+encodeURIComponent(onset_date1)+"&status="+status+"&Encounter_Id="+Encounter_Id+"";
	parent.frames[4].location.href=url;
	parent.frames[6].location.href="../../eMR/jsp/RecordPatientAdverseEvent9.jsp";
	
		}		
}

function valtextReaction(obj)
{
	

	var search_text=parent.frames[0].document.forms[0].search_text.value;
	var allergen=parent.frames[0].document.forms[0].allergen.value;
	var react_val=parent.frames[0].document.forms[0].react_val.value;
	var mode=parent.frames[0].document.forms[0].mode.value;
	var flag=parent.frames[0].document.forms[0].flag.value;
	var adv_event_ind=parent.frames[0].document.forms[0].adv_event_ind.value;
	var adv_event_type=parent.frames[0].document.forms[0].adv_event_type.value;
	var patientId=parent.frames[0].document.forms[0].patientId.value;
	var errorMsg=parent.frames[0].document.forms[0].errorMsg.value;
	var checkedRec=parent.frames[0].document.forms[0].checkedRec.value;

	var url="../../eMR/jsp/RecordPatientAdverseEvent10.jsp?allergen="+allergen+"&search_text="+search_text+"&react_val="+react_val+"&mode="+mode+"&flag="+flag+"&patient_id="+patientId+"&adv_event_ind="+adv_event_ind+"&adv_event_type="+adv_event_type+"&errorMsg="+errorMsg+"&checkedRec="+checkedRec;
	parent.frames[1].location.href=url;
}



function Check_Duplicate(obj,n)
{
		var mode=parent.frames[3].document.forms[0].mode.value;
		var reaction_code;
		
		var PatientId= parent.frames[5].document.forms[0].PatientId.value;
		var reaction_date=obj.value;
		if(mode=="insert")
		{
			var allergen=parent.frames[3].document.forms[0].allergen_id.value;
		}
		else
		{
			var allergen=parent.frames[3].document.forms[0].causative_code.value;
		}
		
		if(eval("parent.frames[4].document.forms[0].reaction_code"+n)){
			
			reaction_code=eval("parent.frames[4].document.forms[0].reaction_code"+n).value;
		}		
		
		var xmlDoc="";	
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH  PatientId=\""+PatientId+"\"  reaction_date=\""+encodeURIComponent(reaction_date)+"\"  allergen=\""+allergen+"\" reaction_code=\""+reaction_code+"\"  steps='4'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) 	

		if(parent.frames[5].document.forms[0].duplicate.value =="Y")
		{
			alert(getMessage("REACTION_ALREADY_RECORDED_DATE","MR"));
			obj.value="";
		}
}



function Check_Duplicate1(obj)
{
		var mode=parent.frames[3].document.forms[0].mode.value;
		var PatientId= parent.frames[5].document.forms[0].PatientId.value;
		var reaction_date=obj.value;
		if(mode=="insert")
		{
		var allergen=parent.frames[3].document.forms[0].allergen_id.value;
		}else
		{
		var allergen=parent.frames[3].document.forms[0].causative_code.value;
		}
		var reaction_code=parent.frames[4].document.forms[0].reaction_oth.value;
		

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH  PatientId=\""+PatientId+"\"  reaction_date=\""+encodeURIComponent(reaction_date)+"\"  allergen=\""+allergen+"\" reaction_code=\""+reaction_code+"\"  steps='4'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) 	

		if(parent.frames[5].document.forms[0].duplicate.value =="Y")
		{
			alert(getMessage("REACTION_ALREADY_RECORDED_DATE","MR"));
			obj.value="";
		}
}

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		Obj.value = "";
		alert(getMessage("DAYS_CHECK","Common"));		
		Obj.focus(); 
		document.forms[0].onset_date.value=''; 
		
	}
//	document.forms[0].onset.onblur();
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) { 
		Obj.value = "";
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus(); 
		document.forms[0].onset_date.value='';
		
	}
//	document.forms[0].onset.onblur();
}
function CheckForNumber_L(Objval,obj1) 
{
  
	val = Objval.value;
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
	{

		if ( val.length > 0 ) {
			document.forms[0].onset_date.value='';
			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
	}
	
}
function calci(Obj,format,locale,dateObj)

{
	
	
	
	
	var currDate = document.forms[0].ServerDate.value;

	var intervalY='Y',intervalM='M',intervalD='d';
	var years="0";
	years=document.forms[0].b_age.value;
	var months="0";
	months=document.forms[0].b_months.value;
	var days="0";
	days=document.forms[0].b_days.value;
	var tempDate="";
	if(years>=0){
			tempDate=minusDate(currDate, format, locale, years, intervalY);
	}
	if(months>=0){
		if(months >=0 && months <12)
			tempDate=minusDate(tempDate, format, locale, months, intervalM);
	}
	if(days>=0){
		if(days >=0 && days <32)
			tempDate=minusDate(tempDate, format, locale, days, intervalD);
	}
		dateObj.value=tempDate;
	
		    var dob			= document.forms[0].Dob.value;
			var bdate = convertDate(document.forms[0].Dob.value,"DMY",localeName,"en");
			var dateObj1    = document.forms[0].onset_date.value;
			var dateObj     =dateObj1.substring(0,10);
			var greg_todate1 = convertDate(dateObj,"DMY",localeName,"en");
			if(!isBefore(bdate,greg_todate1,'DMY',localeName))// DateUtils.js
			{
				var msg = getMessage("ONSET_DT_BT_DOB_AND_CURR","MR");
				alert(msg);
				document.forms[0].onset_date.value='';		
				
				document.forms[0].b_days.value = '0';
				document.forms[0].b_months.value='0';
				document.forms[0].b_age.value='0';
				
			}

		/*Wednesday, January 20, 2010 IN018294*/
		var sysDate		= document.forms[0].sysDate.value;
		var sysdate_time=sysDate.substring(10,16)
		parent.frames[3].document.forms[0].changeonsetflag.value = "Y";
		/*18503 Thursday, January 28, 2010*/
		if(parent.frames[3].document.forms[0].event_status.value != "")
			parent.frames[3].document.forms[0].since_date.value = dateObj;
		if(parent.frames[4].document.forms[0].count_val)
		{
			var countvalue=parent.frames[4].document.forms[0].count_val.value;
			for (var i=0;i<=countvalue-1 ;i++ )
			{
				eval("parent.frames[4].document.forms[0].reaction_date"+i).value = dateObj+""+sysdate_time;
			}
		}
		if(parent.frames[4].document.forms[0].oth_reaction_counter)
		{
			var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
			for (var i=0;i<=oth_reaction_counter-1 ;i++ )
			{
				eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = dateObj+""+sysdate_time;
			}
		}
	/**/
		

		

}

function calcage(obj1,obj2) 
{
	//obj1 = document.forms[0].ServerDate.value;
	//obj2 = document.forms[0].onset_date.value;
		
	if(obj1.value != '' || obj2.value != '' )
	{
		
		//if(doDateCheckAlert(obj1,obj2))
		if(doDateTimeChk(obj1,obj2))
		{
			if(CheckDate(obj1) == false){
					obj1.focus();
			}else
			{
		
				if(obj1.value.length !=0)
				{
					var datecal=obj1.value;
					strDateArray = datecal.split("/");
					if (strDateArray.length != 3) ;
					else 
					{
						strDay = strDateArray[0];
						strMonth = strDateArray[1];
						strYear = strDateArray[2];
					}

				    var ageYears, ageMonths, ageDays
				    var datecal2=obj2.value;
					bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);

					mm = bornDate.getMonth()+1 ;
					dd = bornDate.getDate();
					yy = bornDate.getFullYear();
					


					strDateArray1 = datecal2.split("/");
					if (strDateArray.length != 3) ;
					else 
					{
						strDay1 = strDateArray1[0];
						strMonth1 = strDateArray1[1];
						strYear1 = strDateArray1[2];
					}

					testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
					mm2 = testDate.getMonth()+1 ;
					dd2 = testDate.getDate();
					yy2 = testDate.getFullYear();


			
					if (yy < 100 && yy > 20) 
					{
						yy = yy + 1900
			        }
					if (yy2 < 100)
					{
						if (yy2 > 20) 
						{
							yy2 = yy2 + 1900
				        }
						else
						{
							yy2 = yy2 + 2000
				        }
				    }
			
					ageYears = yy2 - yy

				    if(mm2 == mm)
					{
						if(dd2 < dd)
						{
							mm2 = mm2 + 12;
							ageYears = ageYears - 1;
						}
				    }

				    if(mm2 < mm)
					{
						mm2 = mm2 + 12;
						ageYears = ageYears - 1;
						ageMonths = mm2 - mm;
					}

					ageMonths = mm2 - mm;

				    if (dd2 < dd) 
					{
						ageMonths = ageMonths - 1;
						if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
						{
							dd2 = dd2 + 30;
						}
						else
						if(ageMonths == 2)
						{
							dd2=dd2+30;
						}
						else
						{
							dd2=dd2+30;
						}
						if (mm2 == mm) 
						{
							ageMonths = 0;
							ageYears = ageYears - 1;
						}
				    }
		
					ageDays = dd2 - dd;

				if(document.forms[0].estimated_duration.checked == true)///*10/11/2008*/
				{
					if(	document.forms[0].b_age!=null)
					{
						document.forms[0].b_age.value= ageYears ;
						if(document.forms[0].b_age.value.length == 1  && document.forms[0].b_age.value !='0') document.forms[0].b_age.value="0"+ageYears ;
						
						document.forms[0].b_months.value=ageMonths;
						if(document.forms[0].b_months.value.length == 1 && document.forms[0].b_months.value !='0') document.forms[0].b_months.value="0"+ageMonths;
						
						document.forms[0].b_days.value=ageDays;
						if(document.forms[0].b_days.value.length == 1 && document.forms[0].b_days.value !='0') document.forms[0].b_days.value="0"+ageDays;
					}
					else
					{
						document.forms[0].b_age1.value= ageYears ;
						if(document.forms[0].b_age1.value.length == 1  && document.forms[0].b_age1.value !='0') document.forms[0].b_age1.value="0"+ageYears ;
											
						document.forms[0].b_months1.value=ageMonths;
						if(document.forms[0].b_months1.value.length == 1 && document.forms[0].b_months1.value !='0') document.forms[0].b_months1.value="0"+ageMonths;
											
						document.forms[0].b_days1.value=ageDays;
						if(document.forms[0].b_days1.value.length == 1 && document.forms[0].b_days1.value !='0') document.forms[0].b_days1.value="0"+ageDays;
					}
				}///*10/11/2008*/
				
				}
			}
		}
	}
	
}

function checkWithDob(onset, dob,sysDate, format, locale)
{


	if(onset != "")
	{
		if(!isBetween(dob,sysDate,onset, format, locale))
		{	
			alert(getMessage("ONSET_DT_BT_DOB_AND_CURR","MR"));
			return false;
		}
		else
			 return true;
	}
}

function imposeMaxLength(obj,maxlength)
{
return (obj.value.length < maxlength);

}

function checkMaxLimit(obj)
	{
		if ( obj.value.length > 100 )
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","common");
			var remarks = getLabel("Common.Text.label","common") + " " + getLabel("Common.Entered.label","common");
			error = error.replace("$",remarks);
			error = error.replace("#","100")
			alert(error);
			obj.select();
			return false;
		}
		else
			return true;
	}
	
/*	function checkCommentMaxLimit(obj)
	{ 
	  
	if (obj.value.length >300){
			var error = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			error = error.replace("$",getLabel("Common.remarks.label","Common")); 
			error = error.replace("#","200");
			alert(error)
			obj.focus(); 
		}

	}
	
	function checkCommentMaxLimit1(obj)
	{ 
	  
	var strCheck = '~`!@#$%^&()-=+{[}]|:;",/?\<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1 && whichCode != 92) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
		}

	} */
	

	function clear_session()
	{

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='CLEAR_ALL_SESSION_VALUES'/></root>"
				
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		//xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
	}
function enable_dmy()
{
	if(parent.Headerpage.document.search_form.estimated_duration.checked==true)
	{
		parent.Headerpage.document.search_form.estimated_duration.value="Y";
		parent.Headerpage.document.search_form.b_days.disabled=false;
		parent.Headerpage.document.search_form.b_days.value='';
		parent.Headerpage.document.search_form.b_months.disabled=false;
		parent.Headerpage.document.search_form.b_months.value='';
		parent.Headerpage.document.search_form.b_age.disabled=false;
		parent.Headerpage.document.search_form.b_age.value='';
		//parent.Headerpage.document.getElementById("clock").innerHTML="<img src='../../eCommon/images/mc_history.gif.gif'>";
		parent.Headerpage.document.getElementById("clock").style.visibility="visible";
		
		/*var ServerDate  =document.forms[0].ServerDate.value;
		var onset_date = document.forms[0].onset_date.value;
		calcage(this,ServerDate,onset_date);*/
		//parent.Headerpage.document.getElementById("clock").style.display="none";
	}
	else
	{
		parent.Headerpage.document.search_form.estimated_duration.value="N";
		//10/23/2008 reset current date
			parent.Headerpage.document.search_form.onset_date.value=parent.Headerpage.document.search_form.sysDate.value;
		parent.Headerpage.document.search_form.b_days.disabled=true;
		parent.Headerpage.document.search_form.b_days.value="";
		parent.Headerpage.document.search_form.b_months.disabled=true;
		parent.Headerpage.document.search_form.b_months.value="";
		parent.Headerpage.document.search_form.b_age.disabled=true;
		parent.Headerpage.document.search_form.b_age.value="";
		parent.Headerpage.document.getElementById("clock").style.visibility="hidden";
	}
}

function disable_curr_assement(obj)
{

	//Added for the CRF - RUT-CRF-0064 - Begin
	if(parent.frames[3].document.forms[0].allergy_conf_reqd_yn.value == 'Y'){
		if(parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value=='N'){
			parent.frames[3].document.forms[0].no_known_allergy.checked=true;
		}else{
			parent.frames[3].document.forms[0].no_known_allergy.checked=false;
		}
	}
	//Added for the CRF - RUT-CRF-0064 - End
	if(parent.frames[3].document.forms[0].no_known_allergy.checked==true)
	{ 
		clear_page();/*Added by Rameswar on 8th Jun 2015 Against IN055801*/
		parent.frames[3].document.forms[0].adv_event_ind.disabled=true;
		parent.frames[3].document.forms[0].adv_event_ind_one.disabled=true;
		parent.frames[3].document.forms[0].adv_event_ind_two.disabled=true;
		parent.frames[3].document.forms[0].adv_event_ind_three.disabled=true;
		
		parent.frames[3].document.forms[0].adverse_even_type.disabled=true;

		parent.frames[3].document.forms[0].allergen.disabled=true;
		parent.frames[3].document.forms[0].cause_sub.disabled=true;
		parent.frames[3].document.forms[0].onset_date.disabled=true;
		parent.frames[3].document.forms[0].estimated_duration.disabled=true;
		parent.frames[3].document.forms[0].b_days.disabled=true;
		parent.frames[3].document.forms[0].b_months.disabled=true; 
		parent.frames[3].document.forms[0].b_age.disabled=true;
		parent.frames[3].document.forms[0].estimated_duration.value="N";
		parent.frames[3].document.forms[0].cal2.disabled=true;
		parent.frames[3].document.forms[0].eventdtlsID.disabled=true;
		parent.frames[3].document.forms[0].allergyAlertby.disabled=true;// added by  munisekhar for  [IN:045538]
       
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
   	   parent.frames[3].document.forms[0].onset[0].disabled=true
	   parent.frames[3].document.forms[0].onset[1].disabled=true
	   parent.frames[3].document.forms[0].onset[2].disabled=true
	   parent.frames[3].document.forms[0].comments.disabled=true
		/*end ML-MMOH-CRF-0366 */
		
		parent.frames[4].document.forms[0].add_reaction.disabled=true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		
		parent.frames[5].document.forms[0].definit.disabled=true;
		parent.frames[5].document.forms[0].probable.disabled=true;
		parent.frames[5].document.forms[0].diagnosis.disabled=true;
		parent.frames[5].document.forms[0].route_exp.disabled=true;
		parent.frames[5].document.forms[0].pat_obser.disabled=true;
		parent.frames[5].document.forms[0].aller_test.disabled=true;
		parent.frames[5].document.forms[0].Staff_obser.disabled=true;
		parent.frames[5].document.forms[0].allergy_test_res.disabled=true;
		parent.frames[5].document.forms[0].treat_advice.disabled=true;
		parent.frames[5].document.forms[0].remarks.disabled=true;
		parent.frames[5].document.forms[0].active.disabled=true;
		parent.frames[5].document.forms[0].date_time.disabled=true;
			//clear_page();
	}
	else
	{
		
		parent.frames[3].document.forms[0].adv_event_ind.disabled=false;
		parent.frames[3].document.forms[0].adv_event_ind_one.disabled=false;
		parent.frames[3].document.forms[0].adv_event_ind_two.disabled=false;
		parent.frames[3].document.forms[0].adv_event_ind_three.disabled=false;
		
		parent.frames[3].document.forms[0].adverse_even_type.disabled=false;
		//parent.frames[3].document.forms[0].allergen.disabled=false;
		//parent.frames[3].document.forms[0].cause_sub.disabled=false;
		parent.frames[3].document.forms[0].onset_date.disabled=false;
		parent.frames[3].document.forms[0].estimated_duration.disabled=false;
		parent.frames[3].document.forms[0].eventdtlsID.disabled=false;
		parent.frames[3].document.forms[0].allergyAlertby.disabled=false;// added by  munisekhar for  [IN:045538]
		//parent.frames[3].document.forms[0].b_days.disabled=false;
		//parent.frames[3].document.forms[0].b_months.disabled=false;
		//parent.frames[3].document.forms[0].b_age.disabled=false;
	  
	 
	  /*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
	  parent.frames[3].document.forms[0].onset[0].disabled=false
	   parent.frames[3].document.forms[0].onset[1].disabled=false
	   parent.frames[3].document.forms[0].onset[2].disabled=false
	   parent.frames[3].document.forms[0].comments.disabled=false
		/*end ML-MMOH-CRF-0366 */
		parent.frames[5].document.forms[0].definit.disabled=false;
		parent.frames[5].document.forms[0].probable.disabled=false;
		parent.frames[5].document.forms[0].diagnosis.disabled=false;
		parent.frames[5].document.forms[0].route_exp.disabled=false;
		parent.frames[5].document.forms[0].pat_obser.disabled=false;
		parent.frames[5].document.forms[0].aller_test.disabled=false;
		parent.frames[5].document.forms[0].Staff_obser.disabled=false;
		parent.frames[5].document.forms[0].allergy_test_res.disabled=false;
		parent.frames[5].document.forms[0].treat_advice.disabled=false;
		parent.frames[5].document.forms[0].remarks.disabled=false;
		parent.frames[5].document.forms[0].active.disabled=false;
		parent.frames[5].document.forms[0].date_time.disabled=false;
		parent.frames[3].document.forms[0].cal2.disabled=false;
	}
}

function getchkvalues(obj){
	var count_val = parent.frames[4].document.forms[0].tot_cnt.value;	
	if(obj.checked==true){
			obj.value='Y'
			
		}else{
			obj.value='N'
		}
	}

function mark_error()
{
	//var check_stat = 
		parent.frames[4].document.forms[0].check_stat.value = "mark_error";
	var chk=false;
	var count_val = parent.frames[4].document.forms[0].oth_reaction_counter.value;
	var allergen1=parent.frames[3].document.forms[0].causative_code.value;
	var allergen=allergen1.split("|");
	allergen=allergen[0];
	parent.frames[4].document.forms[0].allergen.value=allergen1;


		if (parent.frames[3].document.forms[0].adv_event_ind.checked==true)
			parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind.value
		
		else if (parent.frames[3].document.forms[0].adv_event_ind_one.checked==true)
		
			parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_one.value;
		
		else if (parent.frames[3].document.forms[0].adv_event_ind_two.checked==true)
		
			parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_two.value;
	
		else 
		
			parent.frames[4].document.forms[0].adv_event_ind.value=parent.frames[3].document.forms[0].adv_event_ind_three.value;
			
//var adv_event_type1=parent.frames[3].document.forms[0].adv_event_type.value;		
	parent.frames[4].document.forms[0].adv_event_type.value=parent.frames[3].document.forms[0].adv_event_type.value;
//var allergy_code = parent.frames[1].document.forms[0].causative_code.value;
var count_val = parent.frames[4].document.forms[0].count_val.value;
	


	var final_value ="";
	var chkreact  ="";
	if(!(parent.frames[4].document.forms[0].mode=='insert'))
		{
	if(parent.frames[4].document.forms[0].tot_cnt)
			{
			var countvalue=parent.frames[4].document.forms[0].tot_cnt.value;
			
			for (var i=0;i<=countvalue-1 ;i++ )
			{
				
				if(eval("parent.frames[4].document.forms[0].chkreact"+i))
				{
					if(eval("parent.frames[4].document.forms[0].chkreact"+i).checked ==true)
					{
						//final_value += eval("parent.frames[4].document.forms[0].error_status"+i).value+"$"+eval("parent.frames[4].document.forms[0].react_description"+i).value+"$"+eval("parent.frames[4].document.forms[0].adv_event_rxn_srl_no"+i).value+"$"+eval("parent.frames[4].document.forms[0].severity_desc"+i).value+"$"+eval("parent.frames[4].document.forms[0].site_desc"+i).value+"$";
						final_value += eval("parent.frames[4].document.forms[0].error_status"+i).value+"$"+eval("parent.frames[4].document.forms[0].react_description"+i).value+"$"+eval("parent.frames[4].document.forms[0].adv_event_rxn_srl_no"+i).value+"$";

						chkreact +=eval("parent.frames[4].document.forms[0].chkreact"+i).value
					}
					/*else
					{
						alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
						return false;
					}*/
				}
			}
			
			parent.frames[4].document.forms[0].chk_react.value=chkreact;

			/*5/27/2009 IN010344
			if(parent.frames[4].document.forms[0].chk_react.value.length == parent.frames[4].document.forms[0].count_val.value){
			*/
			if(parent.frames[4].document.forms[0].chk_react.value.length == parent.frames[4].document.forms[0].tot_cnt.value){
				var error = getMessage("REACTION_CANNOT_ERROR","MR");
				alert(error);
				return false;
			}
			
		
			parent.frames[4].document.forms[0].final_value.value=final_value;
			if(! (parent.frames[4].document.forms[0].final_value.value.length > 0)){
				var error1 = getMessage("NO_SELECTION","IP");
				alert(error1);
				return false;
			}

		}
		/*if(count_val <= 1 ){
			var error3;
			/*error3=getMessage("CAN_NOT_BE_BLANK","common");
			error3=error3.replace("$",getLabel("eMR.addreaction.label","MR"));*/
			/*error3 = getLabel("eMR.addreaction.label","MR");
			alert(error3);
			return false;
		}*/
		
		parent.frames[4].document.forms[0].submit();
	}
}

function openToolTip(allergen)
{
	
	var patient_id = parent.frames[3].document.forms[0].PatientId.value
	
	//val = unescape(val);
	//buildTable(val);
/*
	bodwidth = parent.frames[1].document.body.offsetWidth;
	bodheight = parent.frames[1].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth);
	y = y + (document.getElementById("tooltiplayer").offsetHeight);
	
	if(x<bodwidth)
		x =event.x;
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2);
	
	if(y<bodheight)
		y =event.y;
	else if(event.y>bodheight)
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2);
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight);

	y+=document.body.scrollTop;
	x+=document.body.scrollLeft;
	document.getElementById("tooltiplayer").style.posLeft = x;
	
	if(document.getElementById("tooltiplayer").offsetWidth > 250)
		document.getElementById("tooltiplayer").style.posLeft = 111;
	else
		document.getElementById("tooltiplayer").style.posLeft = 275;

	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';
*/	
	/*var allergy_details()=new Array();
	
	var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=1><b>View Active Allergy</b></font></th></tr><tr><td><table cellpadding=0 cellspacing=0 border=1><tr><td class=SENPAT nowrap>Allergen</td><td class=SENPAT nowrap>Onset Date</td><td class=SENPAT nowrap>Last Reaction date</td><td class=SENPAT nowrap>Reaction Description</td><td class=SENPAT nowrap>Severity</td></tr>";
	if(allergy_details[patientid] != '')
	{
		tabdata +=allergy_details[episodeid]+"</td></tr></table></table></body></html>";
		document.getElementById("allergenLink").innerHTML = tabdata;
		document.getElementById("allergenLink").style.top  = obj.offsetTop;
		document.getElementById("allergenLink").style.left  = obj.offsetLeft+50 ;
		document.getElementById("allergenLink").style.visibility='visible' ;
	}

*/
	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='allergen_view_form' id='allergen_view_form' method='post' action='../../eMR/jsp/RecordPatientAdverseEventView.jsp'><input type='hidden' name='allergen' id='allergen' value='"+allergen+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='x_coordinate' id='x_coordinate' value='"+event.x+"'><input type='hidden' name='y_coordinate' id='y_coordinate' value='"+event.y+"'></form></body></html>";
	parent.parent.frames[1].document.write(HTMLVal);
	parent.parent.frames[1].document.allergen_view_form.submit();
}

/*function hideToolTip()
	{
		document.getElementById("tooltiplayer").style.visibility='hidden';
	}
*/
	function displayToolTip(obj,x_coordinate,y_coordinate)
{
	obj = obj + "^^";
	obj = unescape(obj);
	var rowval = obj.split ("<br>");
	
	var nowrapval = "";
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='2' width='25%' align='center'>";

	for( var i=0; i<rowval.length-1; i++ )
	{
		if(i==0)
		{
			var colval = rowval[i].split("^^");
			tab_dat += "<tr>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[0] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[1] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[2] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[3] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[4] +" </td>";
			tab_dat += "</tr> ";
			
		}
		else
		{
			var colval = rowval[i].split("^^");
			tab_dat += "<tr>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[0] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[1] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[2] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[3] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[4] +" </td>";
			tab_dat += "</tr>";
		}
	}

	tab_dat += "</table> ";

	if (parent.frames[1].document.getElementById("t") != null)
		parent.frames[1].document.getElementById("t").innerHTML = tab_dat;

	parent.frames[1].document.getElementById("tooltiplayer").style.visibility="visible";
	var bodwidth  = (parent.frames[1].document.body.offsetWidth)/2;
	var bodheight = (parent.frames[1].document.body.offsetHeight)/2;
	
//	var x = x_coordinate - 1;
	var y = y_coordinate - 5;
	y += parent.frames[1].document.body.scrollTop;
//  x += parent.frames[1].document.body.scrollLeft;
    parent.frames[1].document.getElementById("tooltiplayer").style.posLeft= bodwidth;//2;
    parent.frames[1].document.getElementById("tooltiplayer").style.posTop =bodheight; //y;
}



/***************************************************************
function display_Allergen(causative_code,adv_event_type_code,obj1)
{
	var y = document.body.scrollDown;
	var tabdata="";
	var x = causative_code;
	var allergen ="";
	var onset_date ="";
	var reaction_date ="";
	var reac_desc ="";
	var severity ="";
	var tokens="";
	var obj=causative_code+adv_event_type_code;
	var internalStr=document.forms[0].internalStr.value;
	var  internalArr=internalStr.split("||");
	var internalArrlen=internalArr.length;
	var internalArr2=internalArr[0].split("&&");
	
	tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK ><tr><th align='left'><font size=2 color='Blue'><b>View Active Allergy</b></font></th></tr><tr><td><table cellpadding=0 cellspacing=0 border=1><tr><td nowrap><B>Allergen</B></td><td  nowrap><B>Onset date</B></td><td nowrap><B>Last reaction date</B></td><td  nowrap><B>Reaction Description</B></td><td nowrap><B>Severity</B></td></tr>";
	
	for(var i=0;i<internalArrlen;i++){
		var internalArr2=internalArr[i];
		 tokens=internalArr2.split("&&");
		if(tokens[0]==obj){
			
		
	if(tokens[5] =="M")
		tokens[5]="Mild";
	else if(tokens[5]=="O")
		tokens[5]="Moderate";
	else if(tokens[5]=="S")
		tokens[5]="Severe";
	else if(tokens[5]=="U")
		tokens[5]="Unknown";
	else if(tokens[5] =="")
		tokens[5]="";

		tabdata +="<tr><td>"+tokens[1]+"</td><td>"+tokens[2]+"</td><td>"+tokens[3]+"</td><td>"+tokens[4]+"</td><td>"+tokens[5]+"</td>";
		
		}
	}
		
	tabdata+="</tr></table></table></body></html>";
		 parent.frames[1].document.getElementById("allergenLink").innerHTML = tabdata;
		
		 parent.frames[1].document.getElementById("allergenLink").style.top  =obj1.offsetTop ;
		 parent.frames[1].document.getElementById("allergenLink").style.left  =obj1.offsetLeft+50 ;
		 parent.frames[1].document.getElementById("allergenLink").style.visibility='visible' ;
		
		
	
}
********************************************************************/
function hidePopUp()
{
	document.getElementById("allergenLink").style.visibility='hidden' ;
}

function load_header()
{
	
	//parent.frames[1].document.forms[0].all.header_part.style.display="none";
	/*parent.frames[1].document.forms[0].all.head3.style.display="none";
	parent.frames[1].document.forms[0].all.head4.style.display="none";
	parent.frames[1].document.forms[0].all.head5.style.display="none";*/
	//var url="../../eMR/jsp/RecordPatientAdverseEvent4.jsp?rs_mode=result";

		//parent.frames[1].location.href=url;

	
var flag="flag" ;

	//parent.frames[1].document.forms[0].modeResult1.value="loadTime";
//var url="../../eMR/jsp/RecordPatientAdverseEvent4.jsp?flag="+flag;

//parent.resultpage.location.href=url;



}
function defaultdmy()
{
	
	var sysdate = parent.frames[3].document.forms[0].sysDate.value;
	
	if(parent.frames[3].document.forms[0].estimated_duration.checked == true && parent.frames[3].document.forms[0].onset_date.value == sysdate)
	{
		
		parent.Headerpage.document.search_form.b_days.value='0';
		parent.Headerpage.document.search_form.b_months.value='0';
		parent.Headerpage.document.search_form.b_age.value='0';
	}
}

  
function calcfields(obj1,obj2) 
{
	/*to check  onset date between current date and DOB*/
	
	var dob			= document.forms[0].Dob.value;
	var currDate    = document.forms[0].ServerDate.value;
	var dateObj1    = document.forms[0].onset_date.value;
	var sysDate		= document.forms[0].sysDate.value;
	var locale		= document.forms[0].locale.value;
	var format      = "DMY";
	
	var dateObj     = dateObj1.substring(0,10);
	
	/*
	if(dob != null && dob != "")
	{
		
		if(!checkWithDob(dateObj,dob, sysDate, format, locale))
		{
				dateObj = currDate;
				//Obj.value = 0;
				document.forms[0].b_months.value = 0;
				document.forms[0].b_days.value = 0;
				document.forms[0].b_age.value = 0;
		}
	}*/
	/**/
	if(obj1.value != '' && obj2.value != '' )
	{

		var a = obj1.value;
		var b = obj2.value;

		var a=  a.split(" ");
		var b=  b.split(" ");
		var datecal="";
		var datecal="";

		datecal=a[0];
		datecal2=b[0];


		if(obj1.value.length !=0)
		{

				strDateArray = datecal.split("/");
				if (strDateArray.length != 3) ;
				else 
				{
					strDay = strDateArray[0];
					strMonth = strDateArray[1];
					strYear = strDateArray[2];
				}

				var ageYears, ageMonths, ageDays;
		
				bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
				mm = bornDate.getMonth()+1 ;
				dd = bornDate.getDate();
				yy = bornDate.getFullYear();


				strDateArray1 = datecal2.split("/");

				if (strDateArray.length != 3) ;
				else 
				{
					strDay1 = strDateArray1[0];
					strMonth1 = strDateArray1[1];
					strYear1 = strDateArray1[2];
				}

				testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
				mm2 = testDate.getMonth()+1 ;
				dd2 = testDate.getDate();
				yy2 = testDate.getFullYear();
		

				if (yy < 100 && yy > 20) 
				{
					yy = yy + 1900
				}
				if (yy2 < 100)
				{
					if (yy2 > 20) 
					{
						yy2 = yy2 + 1900
					}
					else
					{
						yy2 = yy2 + 2000
					}
				}
		
				ageYears = yy2 - yy

				if(mm2 == mm)
				{
					if(dd2 < dd)
					{
						mm2 = mm2 + 12;
						ageYears = ageYears - 1;
					}
				}

				if(mm2 < mm)
				{
					mm2 = mm2 + 12;
					ageYears = ageYears - 1;
					ageMonths = mm2 - mm;
				}

				ageMonths = mm2 - mm;

				if (dd2 < dd) 
				{
					ageMonths = ageMonths - 1;
					if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
					{
						dd2 = dd2 + 30;
					}
					else
					if(ageMonths == 2)
					{
						dd2=dd2+30;
					}
					else
					{
						dd2=dd2+30;
					}
					if (mm2 == mm) 
					{
						ageMonths = 0;
						ageYears = ageYears - 1;
					}
				}

				ageDays = dd2 - dd;
				if(document.forms[0].estimated_duration.checked == true){///*10/11/2008*/
				
					if(	document.forms[0].b_age!=null && document.forms[0].mode.value!='modify')
					{
						/*alert("1");*/
						
						//alert((document.forms[0].onset_date.value >= document.forms[0].Dob.value ));
						//alert((!isAfter(document.forms[0].onset_date.value,document.forms[0].sysdate.value,'DMYHMS',localeName)));
					
						/*var bdate = convertDate(document.forms[0].Dob.value,"DMY",localeName,"en");
						var dateObj1    = document.forms[0].onset_date.value;
						var dateObj     =dateObj1.substring(0,10);
						var greg_todate1 = convertDate(dateObj,"DMY",localeName,"en");*/

						//if(isBefore(bdate,greg_todate1,'DMY',localeName))
						
						//alert("ageYears "+ageYears);


						if((isBefore(document.forms[0].dob_hh_disply.value,document.forms[0].onset_date.value,'DMYHMS',localeName)) )
						{
							if(ageYears >=0)
							{
								
								document.forms[0].b_age.value= ageYears ;

								if(document.forms[0].b_age.value.length == 1  && document.forms[0].b_age.value !='0') document.forms[0].b_age.value="0"+ageYears ;

								document.forms[0].b_months.value=ageMonths;
								if(document.forms[0].b_months.value.length == 1 && document.forms[0].b_months.value !='0') document.forms[0].b_months.value="0"+ageMonths;
								
								document.forms[0].b_days.value=ageDays;
								if(document.forms[0].b_days.value.length == 1 && document.forms[0].b_days.value !='0') document.forms[0].b_days.value="0"+ageDays;
							}

						}
						else
						{
							document.forms[0].b_age.value="0";
							document.forms[0].b_months.value="0";
							document.forms[0].b_days.value="0";

						}

					}
					else if(document.forms[0].mode.value!='modify')
					{
						
						document.forms[0].b_age1.value= ageYears ;
						if(document.forms[0].b_age1.value.length == 1  && document.forms[0].b_age1.value !='0') document.forms[0].b_age1.value="0"+ageYears ;
											
						document.forms[0].b_months1.value=ageMonths;
						if(document.forms[0].b_months1.value.length == 1 && document.forms[0].b_months1.value !='0') document.forms[0].b_months1.value="0"+ageMonths;
											
						document.forms[0].b_days1.value=ageDays;
						if(document.forms[0].b_days1.value.length == 1 && document.forms[0].b_days1.value !='0') document.forms[0].b_days1.value="0"+ageDays;
					}
				}
			}
		/*Wednesday, January 20, 2010 IN018294*/
			var sysdate_time=sysDate.substring(10,16)
			parent.frames[3].document.forms[0].changeonsetflag.value = "Y";
			/*18503 Thursday, January 28, 2010*/
			if(parent.frames[3].document.forms[0].event_status.value != "")
				parent.frames[3].document.forms[0].since_date.value = dateObj;

			if(parent.frames[4].document.forms[0].count_val)
			{
				var countvalue=parent.frames[4].document.forms[0].count_val.value;
				for (var i=0;i<=countvalue-1 ;i++ )
				{
					eval("parent.frames[4].document.forms[0].reaction_date"+i).value = dateObj+""+sysdate_time;
				}
			}
			if(parent.frames[4].document.forms[0].oth_reaction_counter)
			{
				var oth_reaction_counter=parent.frames[4].document.forms[0].oth_reaction_counter.value;
				for (var i=0;i<=oth_reaction_counter-1 ;i++ )
				{
					eval("parent.frames[4].document.forms[0].other_reaction_date"+i).value = dateObj+""+sysdate_time;
				}
			}
		/**/
	}
	//DateChk(document.forms[0].currentdateTime.value,document.forms[0].onset_date.value);
	/*else if(obj1.value == '' )
	{
		if(	document.forms[0].b_age!=null && document.forms[0].mode.value!='modify')
		{
			document.forms[0].b_days.focus();
		}
		else if(document.forms[0].mode.value!='modify')
		{
			document.forms[0].b_days1.focus();
		}
	}*/
}

function CheckForSpecChars_event(event){
    var strCheck = '^';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return false ;
}
function CheckForSpecChars_spec(event){

    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
	
    var strCheck = '~`!@#$%^&()-=+{[}]|:;",/?\<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1 && whichCode != 92) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}

function CheckForSpecChars_spec1(event){
       var strCheck = '';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1 && whichCode != 92) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}


function checkForMax(obj,ldmaxSize)
{
	var longdesctext=obj.value;
	if(longdesctext.length > ldmaxSize){
		var error=getMessage('REMARKS_NOT_EXCEED_200_CH','SM');
		error=error.replace('Remarks',getLabel("Common.reason.label","Common"));
		error=error.replace('200',ldmaxSize);
		alert(error);
		var revertField = obj.value.slice(0,ldmaxSize);
   		obj.value = revertField;
		obj.focus();
	}
} 
function checkMaxLength(obj)
{
     if(obj.name!="comments"){ //comment changed to comments by Rameswar for ML-MMOH-366  
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : "";

	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error=getMessage('REMARKS_CANNOT_EXCEED','Common');
		if(obj.name == 'cause_sub')
			error=error.replace('$',getLabel("eMR.CausativeSubstance.label","MR"));
		else if(obj.name == 'other_reaction')
			error=error.replace('$',getLabel("eMR.OtherReactions.label","MR"));
		/*Added by Thamizh selvi on 2nd Jan 2018 for ML-MMOH-CRF-0751 Start*/
		else if(obj.name == "allergen_free_text")
			error=error.replace('$',getLabel("Common.other.label","Common")+" "+getLabel("eMR.Allergen.label","MR"));
		/*End*/
		error=error.replace('#',mlength);
		alert(error);
		obj.value=obj.value.substring(0,mlength)
	}}
	if(obj.name=="comments"){ //comment changed to comments by Rameswar for ML-MMOH-366 
	if (obj.getAttribute && obj.value.length>300)
	{
		var error=getMessage('REMARKS_CANNOT_EXCEED','Common');
		error=error.replace('$',getLabel("Common.Comments.label","Common"));
		error=error.replace('#',300);
		alert(error);
		obj.value=obj.value.substring(0,300)
	}
	}
}

//Function added for the CRF - RUT-CRF-0064 - Begin
function checkAllergyYes(obj){
	
	//clear_page();
	if(obj.checked){
		parent.frames[0].document.record_patientAdverse.AllergyNo.checked=false;
		parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value="Y";
		if(parent.frames[3].document.forms[0].no_known_allergy){
			
			parent.frames[3].document.forms[0].no_known_allergy.checked=false;
			parent.frames[3].document.forms[0].no_known_allergy.onclick();
			parent.frames[3].document.forms[0].no_known_allergy.disabled=true;
			if(parent.frames[3].document.forms[0].mode.value=='record'){
				clear_page();
			}
			parent.frames[3].document.forms[0].mode.value='insert';
			//parent.frames[3].document.forms[0].no_known_allergy.onclick();
		}				
	}	
}

function checkAllergyNo(obj){
if(obj.checked){
	parent.frames[0].document.record_patientAdverse.AllergyYes.checked=false;
	parent.frames[0].document.record_patientAdverse.AllergyConfirmYN.value="N";
	if(parent.frames[3].document.forms[0].no_known_allergy){
		parent.frames[3].document.forms[0].no_known_allergy.onclick();
		parent.frames[3].document.forms[0].no_known_allergy.checked=true;
		parent.frames[3].document.forms[0].no_known_allergy.disabled=true;
		//alert('onclick called');
		if(parent.frames[3].document.forms[0].mode.value=='record'){
			clear_page();
		}
		parent.frames[3].document.forms[0].mode.value='insert';
		
	}
}	
}
//Function added for the CRF - RUT-CRF-0064 - End

/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
function onSet_Check(obj){

	 if(parent.frames[3].document.forms[0].onset[0].checked){
		  
		   parent.frames[3].document.forms[0].onset_type.value='N';
		   }
		else if(parent.frames[3].document.forms[0].onset[1].checked){
		
		parent.frames[3].document.forms[0].onset_type.value='I';
		}else if(parent.frames[3].document.forms[0].onset[2].checked){
		
		parent.frames[3].document.forms[0].onset_type.value='D';
		}
}
/*end ML-MMOH-CRF-0366 */
/*Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751 Start*/
function enableDisableAllergLkp(obj){
	if(TrimStr(obj.value) != ""){
		document.forms[0].allergen.value="";
		document.forms[0].allergen.disabled=true;
		document.forms[0].drug_search.disabled=true;
		document.forms[0].adv_code_allerg.style.visibility='hidden';
		document.forms[0].cause_sub.value="";
		document.forms[0].cause_sub.disabled=false;
		if(document.forms[0].cause_sub_search != null)
			document.forms[0].cause_sub_search.disabled=false;
		if(parent.frames[4].document.forms[0]!=null)
		{
			parent.frames[4].document.forms[0].add_reaction.disabled=false;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=false;
		}
	}else{
		document.forms[0].allergen.value="";
		document.forms[0].allergen.disabled=false;
		document.forms[0].drug_search.disabled=false;
		document.forms[0].adv_code_allerg.style.visibility='visible';
		document.forms[0].cause_sub.value="";
		document.forms[0].cause_sub.disabled=true;
		if(document.forms[0].cause_sub_search != null)
			document.forms[0].cause_sub_search.disabled=true;
		if(parent.frames[4].document.forms[0]!=null)
		{
			parent.frames[4].document.forms[0].add_reaction.disabled=true;
			parent.frames[4].document.forms[0].add_reaction_search.disabled=true;
		}
	}
}/*End*/

/*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
function callAllergenSearch(obj)
{
	var adv_evnt_code1	= document.forms[0].adv_event_type.value;
		adv_evnt_code1	= adv_evnt_code1.split('|');
	var adv_evnt_code	= adv_evnt_code1[0];
	var adv_evnt_val	= document.forms[0].adv_evnt_ind.value;
	var locale			= document.forms[0].locale.value;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var target			= "";
	var sql				= ""; 
	
	sql = "SELECT a.generic_id code, a.generic_name description, b.thirdparty_type thirdparty_type FROM ph_generic_name_lang_vw a, ph_generic_ext_prod_ref b WHERE a.generic_id = b.generic_id AND UPPER (a.generic_id) LIKE UPPER (?) AND UPPER (LTRIM (a.generic_name)) LIKE UPPER (?) AND UPPER (b.thirdparty_type) LIKE UPPER (?) AND a.eff_status = 'E' AND b.eff_status = 'E' AND b.product_id = 'CIMS' AND a.language_id = '"+locale+"' " ;

	argumentArray[0] = sql ;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2,3";
	argumentArray[5] = document.forms[0].allergen.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;     
		
	retVal = AllergenLookup(getLabel("eMR.ExtGenLinkLookup.label","MR"), argumentArray);
	
	var arr = new Array();

	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal = unescape(retVal);
		arr = retVal.split(",");
		var arr_desc = arr[1];

		document.forms[0].allergen.value = arr_desc;
		document.forms[0].allergen_id.value = arr[0];
		document.forms[0].cause_sub.disabled = false;
		document.forms[0].cause_sub_search.disabled = false;
		parent.frames[4].document.forms[0].add_reaction.disabled = false;
		parent.frames[4].document.forms[0].add_reaction_search.disabled = false;
	}else
	{
		document.forms[0].allergen.value = "";
		document.forms[0].allergen_id.value = "";
		document.forms[0].cause_sub.value = "";
		document.forms[0].cause_sub.disabled = true;
		document.forms[0].cause_sub_search.disabled = true;
		parent.frames[4].document.forms[0].add_reaction.disabled = true;
		parent.frames[4].document.forms[0].add_reaction_search.disabled = true;
	}
}
/*End GHL-CRF-0614.1*/

