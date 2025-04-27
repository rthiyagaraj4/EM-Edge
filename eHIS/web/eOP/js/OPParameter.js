var disptype

function create() 
{
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyOPParameter.jsp" ;
}

function edit() {
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
}

function apply()
{
  	var  fields;
	var  names;
	
	var Form=f_query_add_mod.document.forms[0];
	
if( (Form.follow_up.disabled || Form.no_follow_up.disabled) && Form.visit_type_derv_rule_hdn.value == 'S') //MMS-QH-CRF- 0041.1 changes by Abirami
	{
	fields=new Array(Form.Visit_Control, Form.Visit_Completion,
                                   Form.Max_dur_allow, Form.Max_no_visit,Form.RefreshInterval,							  				  
									  Form.assign_q_num_by);
    names=new Array(getLabel("eOP.MaxNoofdaysforvisitreviscancel.label","OP"),getLabel("eOP.MaxNoofdaysforvisitcompletion.label","OP"),
                                  getLabel("eOP.FollowUpVisitDuratin.label","OP"), getLabel("eOP.NoofFollowUpVisitAllowed.label","OP"),getLabel("Common.RefreshInterval.label","Common"),
								  getLabel("eOP.AssignQueueNumberby.label","OP") );
                             
    
	}else
		{
			fields=new Array(Form.Visit_Control, Form.Visit_Completion,	Form.RefreshInterval, Form.assign_q_num_by); //MMS-QH-CRF- 0041.1 changes by Abirami
		}

	  if( (Form.Max_dur_allow.disabled  || Form.Max_no_visit.disabled) && Form.visit_type_derv_rule_hdn.value == 'S'){ //MMS-QH-CRF- 0041.1 changes by Abirami
     	         fields=new Array(Form.Visit_Control, Form.Visit_Completion,
                                      Form.follow_up, Form.no_follow_up,Form.RefreshInterval,	  
									  Form.assign_q_num_by);
               names=new Array(getLabel("eOP.MaxNoofdaysforvisitreviscancel.label","OP"),getLabel("eOP.MaxNoofdaysforvisitcompletion.label","OP"),getLabel("Common.followup.label","Common"),getLabel("eOP.NoFollowup.label","OP"),getLabel("Common.RefreshInterval.label","Common"),
                                       	getLabel("eOP.AssignQueueNumberby.label","OP") );
	}else
		{
				
		    //fields=new Array(Form.Visit_Control, Form.Visit_Completion, Form.RefreshInterval,Form.assign_q_num_by);
		    /*Modified By Dharma on 16th May 2014 */
		    if( (Form.follow_up.disabled || Form.no_follow_up.disabled) && Form.visit_type_derv_rule_hdn.value == 'S') {
		      fields=new Array(Form.Visit_Control, Form.Visit_Completion,
                      Form.Max_dur_allow, Form.Max_no_visit,Form.RefreshInterval,							  				  
						  Form.assign_q_num_by);
		  	}else{
		  		 fields=new Array(Form.Visit_Control, Form.Visit_Completion, Form.RefreshInterval,Form.assign_q_num_by);
		  	}
	    	
		}
	
		
		
if(Form.visit_type_derv_rule_hdn.value == 'P'){	 
	fields=new Array(Form.Visit_Control, Form.Visit_Completion,Form.dfltruleid,Form.RefreshInterval,Form.assign_q_num_by);
	names=new Array(getLabel("eOP.MaxNoofdaysforvisitreviscancel.label","OP"),getLabel("eOP.MaxNoofdaysforvisitcompletion.label","OP"),getLabel("eOP.DefalutRuleID.label","OP"),getLabel("Common.RefreshInterval.label","Common"),getLabel("eOP.AssignQueueNumberby.label","OP"));        
}                                    
    if(Form.disposition.checked)
    {
        fields[fields.length]=Form.disptype;
        names[names.length]=getLabel("Common.DispositionType.label","Common");
    }  

if(f_query_add_mod.document.forms[0].visit_backdating_allowed_yn.checked==true && f_query_add_mod.document.getElementById('backdategif').style.visibility=='visible'){
		if(f_query_add_mod.document.forms[0].visit_backdate_days.value ==""){
			 fields[fields.length]=Form.visit_backdate_days;			
			names[names.length]=getLabel("eOP.AllowbackdatingVisitDateTime.label","OP")+" "+getLabel("Common.within.label","Common")+" "+getLabel("Common.days.label","Common");    
		}
}
		if(f_query_add_mod.document.forms[0].minMinutes.value !== "" && f_query_add_mod.document.forms[0].maxMinutes.value !== ""){
		 if(f_query_add_mod.document.forms[0].minMinutes.value == f_query_add_mod.document.forms[0].maxMinutes.value){
			var err =getMessage("PAT_WAIT_TIME","OP");	
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err;			
			 return;
		  }
		}
	
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
    {
       if(Form.follow_up.disabled==true || Form.no_follow_up.disabled==true||
				Form. Max_dur_allow.disabled==true || Form.Max_no_visit.disabled==true)
	{
	          Form.follow_up.disabled=false;
				Form.no_follow_up.disabled=false;
				Form. Max_dur_allow.disabled=false;
				Form.Max_no_visit.disabled=false;
	}
			
		if(f_query_add_mod.document.forms[0].emer_pat_chk_yn.checked==true)
		{
			f_query_add_mod.document.forms[0].emer_pat_yn.value='Y';
		}
		else
		{
			f_query_add_mod.document.forms[0].emer_pat_yn.value='N';			
		}

		if(f_query_add_mod.document.forms[0].inv_visitregn_mpq_from_ca_yn.checked==true)
		{
			f_query_add_mod.document.forms[0].inv_visitregn_mpq_from_ca_yn.value='Y';
		}
		else
		{
			f_query_add_mod.document.forms[0].inv_visitregn_mpq_from_ca_yn.value='N';			
		}

		if(f_query_add_mod.document.forms[0].inc_arrive_cons_start_pats_yn.checked==true) {
			f_query_add_mod.document.forms[0].inc_arrive_cons_start_pats_yn.value='Y';
		} else {
			f_query_add_mod.document.forms[0].inc_arrive_cons_start_pats_yn.value='N';			
		}
		
		//Added by Ajay H. for MMS-DM-CRF-0209.4
if(f_query_add_mod.document.forms[0].isclinicCategory.value=='true') {
		if(f_query_add_mod.document.forms[0].cliniccatagory.checked==true) {
			f_query_add_mod.document.forms[0].cliniccatagory.value='Y';
			f_query_add_mod.document.forms[0].ClinicRefrlReq.value='Y';
		} else {
			f_query_add_mod.document.forms[0].cliniccatagory.value='N';
			f_query_add_mod.document.forms[0].ClinicRefrlReq.value='N';				
		}
       if(f_query_add_mod.document.forms[0].clinicCatagoryman.checked==true) {
			f_query_add_mod.document.forms[0].clinicCatagoryman.value='Y';
		} else {
			f_query_add_mod.document.forms[0].clinicCatagoryman.value='N';			
		}
}
		//End of MMS-DM-CRF-0209.4
		if(f_query_add_mod.document.forms[0].override_pract_for_appt_yn.checked==true)
		{
			f_query_add_mod.document.forms[0].override_pract_for_appt_yn.value='Y';
		}
		else
		{
			f_query_add_mod.document.forms[0].override_pract_for_appt_yn.value='N';			
		}
		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(f_query_add_mod.document.forms[0].isNationalIdValidationAppl.value=="true")
		{
			if(f_query_add_mod.document.forms[0].validate_natid_reg_visit.checked==true)
			{
				f_query_add_mod.document.forms[0].validate_natid_reg_visit.value='Y';
			}
			else
			{
				f_query_add_mod.document.forms[0].validate_natid_reg_visit.value='N';			
			}
		}
		/*End MO-CRF-20148*/

		if(f_query_add_mod.document.forms[0].reg_visit_for_inpat_yn.checked==true)
		{
			f_query_add_mod.document.forms[0].reg_visit_for_inpat_yn.value='Y';
		}
		else
		{			
			f_query_add_mod.document.forms[0].reg_visit_for_inpat_yn.value='N';			
		}	

	if(f_query_add_mod.document.forms[0].ean_vst_dtls_temp_yn.checked==true)
		{
			f_query_add_mod.document.forms[0].ean_vst_dtls_temp_yn.value='Y';
		}
		else
		{			
			f_query_add_mod.document.forms[0].ean_vst_dtls_temp_yn.value='N';			
		}	
		
		if(f_query_add_mod.document.forms[0].visit_type_derv_rule[0].disabled)
			f_query_add_mod.document.forms[0].visit_type_derv_rule[0].disabled = false;
		if(f_query_add_mod.document.forms[0].visit_type_derv_rule[1].disabled)
			f_query_add_mod.document.forms[0].visit_type_derv_rule[1].disabled = false;		
		if(f_query_add_mod.document.forms[0].visit_type_derv_rule[2].disabled)
			f_query_add_mod.document.forms[0].visit_type_derv_rule[2].disabled = false;	//changes for MMS-QH-CRF 41.1 by Abirami
		if(f_query_add_mod.document.forms[0].episode_closure_by.disabled)
			f_query_add_mod.document.forms[0].episode_closure_by.disabled = false;//Changed for the CRF - Bru-HIMS-CRF-170
    	 Form.submit();	
		
				}
     		 }

function onSuccess(){f_query_add_mod.location.reload()}
function reset() {     
     f_query_add_mod.location.reload()
}
function checkDisposition(obj, mode, selval)
{
    if(obj.checked)
    {
		document.getElementById('id1').src="../../eCommon/images/mandatory.gif"; 
		document.getElementById('id1').style.visibility='visible';
		document.forms[0].disptype.disabled=false
        var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/ecis.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'>";
        HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eOP/jsp/FetchValForOPParameter.jsp'>";
        if(mode=="modify")
        {
            HTMLVal = HTMLVal +"<input type='hidden' name='selval' id='selval' value='"+selval+"'>"
        }
        HTMLVal = HTMLVal +"</form></BODY></HTML>";
        parent.messageFrame.document.write(HTMLVal);
        parent.messageFrame.document.form1.submit();
	}
    else
    {
		document.getElementById('id1').style.visibility='hidden';
        removeitems(document.forms[0].disptype)	        
    }
}

function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

//Functions used in OPParameter.jsp
//MMS-QH-CRF- 0041.1 changes
function setOverrideValue(Obj)
{
	if(Obj.checked)	{
		
		document.getElementById('servicebased').style.display='';
	    document.getElementById('practitionerbased').style.display='none';
		
		document.getElementById("override_episode_yn").value="Y";
		
		document.forms[0].Max_dur_allow.value = "";
		document.forms[0].Max_no_visit.value = "";
		document.forms[0].follow_up.disabled=false;
		document.forms[0].no_follow_up.disabled=false;
		document.forms[0].Max_dur_allow.disabled=true;
		document.forms[0].Max_no_visit.disabled=true;
		document.forms[0].follow_up.focus();
		document.forms[0].followup_img.style.visibility="hidden";
		document.forms[0].non_followup_img.style.visibility="hidden";
		document.forms[0].min_elapse_img.style.visibility="visible";
		document.forms[0].nofollowup_img.style.visibility="visible";
	

	} else {
		
		if(document.getElementById("visit_type_derv_rule_hdn").value == "S")
		{
			document.getElementById('servicebased').style.display='';
		    document.getElementById('practitionerbased').style.display='none';
		    
		    document.forms[0].Max_dur_allow.disabled=false;
			document.forms[0].Max_no_visit.disabled=false;
			document.forms[0].Max_dur_allow.focus();
			
			document.forms[0].followup_img.style.visibility="visible";
			document.forms[0].non_followup_img.style.visibility="visible";
		
		}else if(document.getElementById("visit_type_derv_rule_hdn").value == "B")
		{
			document.getElementById('servicebased').style.display='none';
		    document.getElementById('practitionerbased').style.display='none';
		}else if(document.getElementById("visit_type_derv_rule_hdn").value == "P")
		{
			document.getElementById('servicebased').style.display='none';
		    document.getElementById('practitionerbased').style.display='';
		}
	
		document.getElementById("override_episode_yn").value="N";
		document.forms[0].follow_up.value="";
		document.forms[0].no_follow_up.value="";
		
		document.forms[0].follow_up.disabled=true;
		document.forms[0].no_follow_up.disabled=true;
		
		

	document.forms[0].min_elapse_img.style.visibility="hidden";
	document.forms[0].nofollowup_img.style.visibility="hidden";
	} 
}

function change_value()
{
				if(document.forms[0].emer_pat_chk_yn.checked==true)
				{
					document.forms[0].emer_pat_yn.value='Y';
				}
				else
				{
					document.forms[0].emer_pat_yn.value='N';			
				}				
}

function enableDisable(obj)
			{
				if(obj.checked)
				{
					document.forms[0].bl_interface.value="Y";
					document.forms[0].bl_interface_yn.value="Y";
				}
				else
				{
					document.forms[0].bl_interface.value="N";
					document.forms[0].bl_interface_yn.value="N";
				}
			}

function VisiTypecoEpi(obj)
			{
				if(obj.checked)
				{
				obj.value="Y";
				document.forms[0].override_episode_yn.value="Y";
					}
				  else
				   {
					obj.value="N";
					document.forms[0].override_episode_yn.value="N";
					}
			       }
  
function checkvalid(obj)
{
	if(!(obj.value >=5 ))
	{
		var error = getMessage("DATE1_LT_DATE2","OP");
		error = error.replace("$",getLabel("Common.RefreshInterval.label","Common"));
		error = error.replace("#","5");
		alert(error);		
		obj.focus();
		obj.select();
	}
}	

function callinstall()
{
	
	if(document.forms[0].install_yn.value=='Y')
	{
		if(document.forms[0].invokevisit.value=='Y')
		{
			document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.value='Y';
			document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.checked=true;
		}
		else
		{
			document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.value='N';
			document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.checked=false;
		}
			
	}
	else
	{
		
		document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.value='N';			
		document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.checked=false;			
		document.forms[0].INV_VISITREGN_MPQ_FROM_CA_YN.disabled=true;			
	}


}

function visitTypeRule(obj){  
	
	if(obj.value == "S"){	
		 document.getElementById('servicebased').style.display='';
		 document.getElementById('practitionerbased').style.display='none';
			
		document.getElementById("Max_dur_allow").disabled=false;
		document.getElementById("Max_no_visit").disabled=false;
		document.getElementById("Max_dur_allow").focus();
		
		document.getElementById("followup_img").style.visibility="visible";
		document.getElementById("non_followup_img").style.visibility="visible";
			
		document.forms[0].visit_type_derv_rule.value = "S";
		document.forms[0].visit_type_derv_rule_hdn.value = "S";
		 
	}else if(obj.value == "P"){
		 document.getElementById('practitionerbased').style.display='';
		 document.getElementById('servicebased').style.display='none';

		 document.forms[0].visit_type_derv_rule.value = "P"; 	
		 document.forms[0].visit_type_derv_rule_hdn.value = "P"; 	
	}else if(obj.value == "B"){
		 document.getElementById('practitionerbased').style.display='none';
		 document.getElementById('servicebased').style.display='none';
		 document.getElementById("visit_type_derv_rule_hdn").value = "B";
	}
		 document.getElementById("Max_dur_allow").value = "";
			document.getElementById("Max_no_visit").value = "";
			
			document.getElementById("follow_up").value="";
			document.getElementById("no_follow_up").value="";
			
			document.getElementById("follow_up").disabled=true;
			document.getElementById("no_follow_up").disabled=true;
			
			document.getElementById("min_elapse_img").style.visibility="hidden";
			document.getElementById("nofollowup_img").style.visibility="hidden";
	
}

function valid_dat(Obj)
{
	if ((Obj.value=="0")||(Obj.value=="00")||(Obj.value=="000"))
	{
		alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
		Obj.focus();
	}
}
//Added by Ajay for MMS-DM-CRF-0209.4
function changeMandFld(obj){
if(!obj.checked){
	document.forms[0].clinicCatagoryman.disabled=true;
	document.forms[0].clinicCatagoryman.checked=false;
	document.forms[0].ClinicRefrlReq1.checked=false;
}else{
	document.forms[0].clinicCatagoryman.disabled=false;
	document.forms[0].ClinicRefrlReq1.checked=true;
}
}

