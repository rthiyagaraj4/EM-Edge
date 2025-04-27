//  The Following array is used for 
// storing the Nursing Unit Details for the correct patient_id or booking_ref_no entered
// (NOTE: Please don't remove the following Array).
var arrNursingUnitDetails	=	new Array();
var admDatestat=0;

function create() 
{
	if(parent.content !=null)
		parent.content.frames[1].location.reload();
}
 
function BLCheckElig(f)
{
//alert('BLCheckElig')
	/***********added for package billing********************
		in param <input type='hidden' name='field8' id='field8' value=\""+AdmitPatient_form.patient_id.value+"\">
	**********************************end***********/
	var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><form><input type='hidden' name='field1' id='field1' value=\""+AdmitPatient_form.bed_type.value+"\"><input type='hidden' name='field2' id='field2' value=\""+AdmitPatient_form.billing_group.value+"\"><input type='hidden' name='field3' id='field3' value=\""+AdmitPatient_form.bed_no.value+"\"><input type='hidden' name='field8' id='field8' value=\""+AdmitPatient_form.patient_id.value+"\"><input type='hidden' name='field4' id='field4' value='Admission'><input type='hidden' name='field5' id='field5' value='parent.frames[1].frames[2].document.AdmitPatient_form.bed_no'><input type='hidden' name='field6' id='field6' value='parent.frames[1].frames[2].document.AdmitPatient_form.modified_bed_type'><input type='hidden' name='field7' id='field7' value='../js/AdmitPatient.js'></form></body></html>";
	
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.dummy_form.submit();
}

//This function is used to check the mandatory fields before submitting the page

async function apply()
{
	
	
	/* * For ref
	parent.content.frames[0].name			- "commontoolbarFrame"
	parent.content.frames[1].name			- "f_query_add_mod"
	parent.content.frames[1].frames[0].name - "Select_frame"
	parent.content.frames[1].frames[1].name - "Pline_frame"
	parent.content.frames[1].frames[2].name - "Main_frame"
	parent.content.frames[1].frames[3].name - "Buttons_frame"
	parent.content.frames[1].frames[4].name - "dummy"
	parent.content.frames[2].name			- "messageFrame"	
	*/

	var called_from = "";

	if(parent.content != null)
	{
		if(parent.content.frames[0] != null && parent.content.frames[0].name == "commontoolbarFrame")
			 parent.content.frames[0].document.forms[0].apply.disabled = true;
	}
	
	var difframe = 'N'
	var f = "";
	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	

	
    if(parent.content !=null && !dialogFrame)
	{
		f = parent.content.frames[1];
	}
	else
	{
		if(dialogFrame)
			f = dialogFrame.contentWindow.frames[1];
		else
        f = parent.frames[1];

		if(f.frames[0].document.forms[0].called_from)
			called_from = f.frames[0].document.forms[0].called_from.value;
		//added for  ICN 7440 12/31/2008
		if(!f.frames[0].document.forms[0].called_from.value == 'NEWBORN_REG')
			difframe = 'Y'
    } 	

	var DownTimePatient= await isDownTimePatient();
		if(DownTimePatient==='false'){
			if(difframe=='Y')
			{
				
				parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
			}
			else
			{
				commontoolbarFrame.location.href='../../eCommon/html/process.html';
			}




	f.frames[2].document.AdmitPatient_form.pat_flag.value = f.frames[0].document.Select_form.pat_flag.value;

	var sStyle = f.frames[2].document.forms[0].sStyle.value;
	var b = f.frames[0].document.Select_form.booking_ref_no.value;
    var p = f.frames[0].document.Select_form.patient_id.value;
	 /* In below line trimString() method added by Venkatesh.S on 30-Oct-2013 aganist RUT-SCF-0314 [IN044633] */
    var r = trimString(f.frames[0].document.Select_form.referral_id.value);
	var s = f.frames[0].document.Select_form.bkg_type.value;
    f.frames[2].document.AdmitPatient_form.booking_ref_no.value = b;
    f.frames[2].document.AdmitPatient_form.patient_id.value = p;
    f.frames[2].document.AdmitPatient_form.referral_id.value = r;
	f.frames[2].document.AdmitPatient_form.bkg_type.value = s;
    var result =0;
	var fields=new Array();
	var names = new Array();
	var p = 0;


	fields[p]= f.frames[0].document.Select_form.admission_for;
	names[p] = getLabel("eIP.AdmissionFor.label","IP");
	p++;

	fields[p]= f.frames[2].document.AdmitPatient_form.patient_id;
	names[p] = getLabel('Common.patientId.label','Common');
	p++;
	
	fields[p]= f.frames[2].document.AdmitPatient_form.Splcode;
	names[p] = getLabel('Common.speciality.label','Common');
	p++;

	fields[p]= f.frames[2].document.AdmitPatient_form.nursing_unit;
	names[p] = getLabel('Common.nursingUnit.label','Common');
	p++;
	
	fields[p]= f.frames[2].document.AdmitPatient_form.service;
	names[p] = getLabel('Common.service.label','Common');
	p++;

	fields[p]= f.frames[2].document.AdmitPatient_form.Bedcode;
	names[p] = getLabel('Common.BedClass.label','common');
	p++;
	
	fields[p]= f.frames[2].document.AdmitPatient_form.bed_type;
	names[p] = getLabel('Common.bedtype.label','Common');
	p++;
	
	
	if(f.frames[2].document.AdmitPatient_form.bed_mandatory_for_admn_yn.value =='Y') 
	{
		fields[p]= f.frames[2].document.AdmitPatient_form.bed_no;
		names[p] = getLabel('Common.bedno.label','Common');
		p++;	
	}
	

	fields[p]= f.frames[2].document.AdmitPatient_form.visit_adm_date_time;
	names[p] = getLabel('Common.admissiondate.label','Common');
	p++;

	fields[p]= f.frames[2].document.AdmitPatient_form.visit_adm_type;
	names[p] = getLabel('Common.admissiontype.label','Common');
	p++;

	fields[p]= f.frames[2].document.AdmitPatient_form.practid;
	names[p] = getLabel('eIP.AdmittingPractitioner.label','IP');
	p++;

	if(f.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value =='N') 
	{
		if(f.frames[2].document.AdmitPatient_form.bed_no.value !='') 
		{
			f.frames[2].document.AdmitPatient_form.attend_img.style.visibility = "visible";
			fields[p]= f.frames[2].document.AdmitPatient_form.att_practid;
			names[p] = getLabel('Common.AttendingPractitioner.label','Common');
			p++;
		}
	}
			/*Below line added for this CRF GDOH-CRF-0129*/
			if(f.frames[2].document.AdmitPatient_form.isReferral && f.frames[2].document.AdmitPatient_form.isReferral.value=="true"){
			  if(f.frames[2].document.AdmitPatient_form.reason_reqd_Flag.value == "Y")
				{  
					fields[p]= f.frames[2].document.AdmitPatient_form.chief_complaint;
					names[p] = getLabel('Common.Referralfrom.label','Common');
					p++;
				}
			
			 }else{			
				// Added for MMS-QH-CRF-0144 
				if(f.frames[2].document.AdmitPatient_form.reason_reqd_Flag.value == "Y")
				{  
					fields[p]= f.frames[2].document.AdmitPatient_form.chief_complaint;
					names[p] = getLabel('Common.ReasonforAdmission.label','Common');
					p++;
				}
		}	
		//End this CRF GDOH-CRF-0129	
			
if(called_from!='NEWBORN_REG') {
			// below changed for ABM
	if(parent.content){
		parent.content.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.content.f_query_add_mod.frames[0].document.forms[0].queryString.value;
	}else if(top.f_query_add_mod.Main_frame && top.f_query_add_mod.Main_frame.AdmitPatient_form.from_adv_bed_mgmt.value=='Y'){
		top.commontoolbarFrame.location.href='../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt=Y';
		//top.f_query_add_mod.Main_frame.AdmitPatient_form.from_adv_bed_mgmt.value
		//../../eIP/jsp/AdmitPatientToolbar.jsp
	}
	
}
	if(checkFields( fields, names, messageFrame, difframe, f))
    {
//        f.frames[2].document.AdmitPatient_form.bed_no.disabled = false;
        f.frames[2].document.AdmitPatient_form.room_no.disabled = false;
		var fr  = f.frames[2].document.AdmitPatient_form.visit_adm_date_time;
        var to = f.frames[2].document.AdmitPatient_form.ot_date_time;
        if(to.value != '')
        {
			var greg_FromDate = convertDate(fr.value,'DMYHM',localeName,'en');
			var greg_ToDate = convertDate(to.value,'DMYHM',localeName,'en');
		
			//if(ValidateDateTime(fr,to))
			if(isAfter(greg_ToDate,greg_FromDate,'DMYHM','en'))
				result = 0;
			else
			{
				if (difframe=='Y')
				{
					var localerrors = f.frames[2].getMessage("INVALID_OT_DATE","IP");
					var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>" +
					"<body class='message' onKeyDown='lockKey()'><script> document.writeln(\""+localerrors+"\");"+
					" parent.frames[0].location.href='../../eIP/jsp/AdmitPatientToolbar.jsp'; "+
					"</script></body>" +
					"</html>"
				   messageFrame.document.open('text/html', 'replace');
				   messageFrame.document.writeln(s);
				   result = 1;
				}else if((top.f_query_add_mod && top.f_query_add_mod.Main_frame) && top.f_query_add_mod.Main_frame.document.AdmitPatient_form.from_adv_bed_mgmt.value=='Y'){
					var msg = getMessage("DATE1_LT_DATE2","IP");
					msg	=	msg.replace("$",getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
					msg	=	msg.replace("#",getLabel("Common.SystemDateTime.label","Common"));
					var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>" +
					"<body class='message' onKeyDown='lockKey()'><script> document.writeln(\""+msg+"\");"+
					" parent.frames[0].location.href='../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt=Y'; "+
					"</script></body>" +
					"</html>"
				   messageFrame.document.open('text/html', 'replace');
				   messageFrame.document.writeln(s);
				   result = 1;
				}
				else
				{
					//parent.frames[1].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[1].getMessage("INVALID_OT_DATE","IP") ;

							var msg = getMessage("DATE1_LT_DATE2","IP");
							msg	=	msg.replace("$",getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
							msg	=	msg.replace("#",getLabel("Common.SystemDateTime.label","Common"));
							//f.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg ;
							messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg ;
							result = 1;
						}
					}
				}
/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
				var error=""; // added by mujafar for MMS-MD-SCF-0096 start 
				var reg_date_time	= fnGetRegistrationDateTime();
				reg_date_time = convertDate(reg_date_time,"DMYHMS","en",localeName);
				visit_adm_date_time =	 f.frames[2].document.AdmitPatient_form.visit_adm_date_time.value+':00';
				if(reg_date_time!="" && visit_adm_date_time!=""){ 
				if(!isAfter(visit_adm_date_time,reg_date_time,"DMYHMS",localeName)){ 
				error = getMessage('REG_DATE_TIME_SHOULD_GR_EQUAL','Common');			
				error = error.replace('$',getLabel("Common.AdmissionDateTime.label",'Common'));			
				//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error ; // commented by mujafar and handled below for MMS-MD-SCF-0096
				result = 1;
				
			}
				}
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/
		// added by mujafar for MMS-DM-SCF-0096 start 
			var error1 = "";
			var adm_date_chk_days = f.frames[2].document.AdmitPatient_form.adm_date_chk_days.value;
			var adm_date_chk_days_type = f.frames[2].document.AdmitPatient_form.adm_date_chk_days_type.value;
			var systemDateTime = getSysDateTime(adm_date_chk_days,adm_date_chk_days_type);
			var visit_adm_date_time1 = f.frames[2].document.AdmitPatient_form.visit_adm_date_time.value;
			
			systemDateTime = convertDate(systemDateTime,"DMYHM","en",localeName);
			if(systemDateTime!="" && visit_adm_date_time!=""){
				if(!isAfter(visit_adm_date_time1,systemDateTime,"DMYHM",localeName)){ 
				error1 = getMessage('ADM_DATE_LT_EXCEEDED','IP');
				//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error1 ;
				result = 1;
				
			}
					
			}
			
			if(error != "" && error1 == "")
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			else if(error == "" && error1!= "")
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error1;
			else
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error+"<br>"+error1 ;
			
			// added by mujafar for MMS-MD-SCF-0096 end



				if (f.frames[2].document.AdmitPatient_form.bl_success)
				{
					if(f.frames[2].document.AdmitPatient_form.isBlInstalled.value == 'Y' && f.frames[2].document.AdmitPatient_form.bl_success.value == 'N')
					{
						if (difframe=='Y' || ((top.f_query_add_mod && top.f_query_add_mod.Main_frame) && top.f_query_add_mod.Main_frame.document.AdmitPatient_form.from_adv_bed_mgmt.value=='Y'))
						{
							var localerrors = f.frames[2].getMessage("FINANCIAL_DET_MANDATORY","MP")
							var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
							"<body class='message' onKeyDown='lockKey()'><script> document.writeln(\""+localerrors+"\");"+
							" parent.frames[0].location.href='../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt=Y'; "+
							"</script></body>" +
							"</html>"
						   messageFrame.document.open('text/html', 'replace');
						   messageFrame.document.writeln(s);
						   result = 1;
						}
						else
						{
							/*Friday, January 08, 2010 , IN017993 Message Frame Reference added for new born admission */
							if(called_from=='NEWBORN_REG') {
		
								f.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
							result = 1;
							}else
							{
								/*Below line Added for this CRF Bru-HIMS-CRF-261*/
							if(called_from=='Quick_admission'){
							   if(parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type && parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value=="Y" && parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm.value=="Quick_admission"){
							   //if(parent.frames[2].frames[1].frames[2].document.AdmitPatient_form.quick_admission_type && parent.frames[2].frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value=="Y")
							  // { 					  
							  if(parent.frames[1].frames[2].document.getElementById('findtl_tab')){
							  parent.frames[1].frames[2].document.getElementById('findtl_tab').click();
							  result = 0;
							  }//else{
								//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
								// result = 1;
							 // }
								
								 }
							   }else if(called_from=="" && parent.frames[2].frames[1].frames[2].document.AdmitPatient_form.quick_admission_type && parent.frames[2].frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value=="Y"){ 
							   
							   if(parent.frames[2].frames[1].frames[2].document.getElementById('findtl_tab')){
							  parent.frames[2].frames[1].frames[2].document.getElementById('findtl_tab').click();
							  result = 0;
							  }
							   
							   }else{
								parent.content.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("FINANCIAL_DET_MANDATORY","MP");
								result = 1;
								}
								//End this CRF Bru-HIMS-CRF-261
							}
						}
					}
				}
				if(result == 0)
				{
					/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
					var isForm60Warning	= chkForm60OrPanCardAvail(f.frames[2].document.AdmitPatient_form.isForm60Available.value);
					//Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347
					var validationForPanCardAvail = PanCardAvailCheck
					(f.frames[2].document.AdmitPatient_form.validationForPanCardAvail.value);
					if(validationForPanCardAvail == "Y"){
						f.frames[2].document.AdmitPatient_form.form60_YN.value='Y';
						alert(getMessage("VALIDATE_PANCARD_MNDT_FORM60",'MP'));
					}else{
						if(validationForPanCardAvail == "N")
							f.frames[2].document.AdmitPatient_form.form60_YN.value='N';
					if(isForm60Warning=="Y"){
						alert(getMessage("FORM_60_OR_PAN_CARD",'MP'));
						}
					}
					/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/
			if(beforeSubmit())
			{
				beforeSubmit();
			}
		}
		
	}
		}else{
			alert(getMessage("DOWNTIME_PATIENT_NOT_ALLOWED",'COMMON'));
			if(difframe=='Y') {
				parent.commontoolbarFrame.location.reload();
			}
			else{
				commontoolbarFrame.location.reload();
			}

		}
	if(parent.content !=null)
	{
		 /*
		 if(parent.content.frames[0])
			parent.content.frames[0].location.reload(); */
		}

}
/*
 *	This funtion is used to check the mandatory fields
 *  Arg1	: Values of fields		Arg2	: Names of fields
 *  Arg3	: Error Frame			Arg4	:Common tool bar or not
 *  Arg5	: From which page function is called
 */
function checkFields( fields, names, messageFrame, diffFrame, callingFrame ) 
{
	var sStyle			= callingFrame.frames[2].document.forms[0].sStyle.value;
	var errors = "" ;

	for( var i=0; i<fields.length; i++ ) 
	{
		if(callingFrame.frames[2].trimCheck(fields[i].value)) 
		{
			fields[i].value = callingFrame.frames[2].trimString(fields[i].value);
		}
		else
		{
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
		}
	}

	if ( errors.length != 0 ) 
	{
		if (diffFrame == 'Y')
		{
			var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='message' onKeyDown='lockKey()'><script>parent.frames[0].location.href='../../eIP/jsp/AdmitPatientToolbar.jsp';document.writeln(\""+errors+"\");</script></body></html>";
			messageFrame.document.open('text/html', 'replace');
			messageFrame.document.writeln(s);
		}else if((top.f_query_add_mod && top.f_query_add_mod.Main_frame) && top.f_query_add_mod.Main_frame.document.AdmitPatient_form.from_adv_bed_mgmt.value=='Y'){
			var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='message' onKeyDown='lockKey()'><script>parent.frames[0].location.href='../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt=Y';document.writeln(\""+errors+"\");</script></body></html>";
			messageFrame.document.open('text/html', 'replace');
			messageFrame.document.writeln(s);
		}
		else
		{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}
		return false ;
	}
	return true ;
}

function applyone(difframe)
{
		var f = parent.frames[1].frames[1];
		var difframe = 'N'
		if(parent.frames[1].name != 'content')
		{
			f = parent.frames[1];
			difframe = 'Y'
		}
		
		if(difframe == 'Y')
		{
			var html = "<html><body onKeyDown='lockKey()'><form name='dummyForSubmit' id='dummyForSubmit'  action='../../servlet/eIP.AdmitPatientServlet' method='post'>";
			for(var i=0;i<f.frames[2].document.AdmitPatient_form.elements.length;i++)
			{
				var n = f.frames[2].document.AdmitPatient_form.elements[i].name;
				var v = f.frames[2].document.AdmitPatient_form.elements[i].value;
				html += "<input type=hidden name='"+n+"' id='"+n+"' value=\""+v+"\">";
			}

			html+="</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",html);
			parent.messageFrame.dummyForSubmit.submit();
		}
		else 
		{
			parent.frames[1].frames[2].document.forms[0].pat_ser_grp_code.value = parent.frames[1].frames[0].document.getElementById('pat_ser_grp_code').value;
			if(parent.content !=null)
				parent.content.frames[1].frames[2].document.AdmitPatient_form.submit();
		} 
		
}

function onSuccess() 
{
	create();
}
/*
 * This function is used to reset the page
*/
function reset()
{
	setTimeout("resetForm()", 100);
}

function resetForm() 
{		
		if(parent.content != null){
			parent.content.frames[1].frames[0].location.reload();// "Select_frame"
			parent.content.frames[1].frames[2].location.reload();// "Main_frame"
			parent.content.frames[1].frames[3].location.reload();// "Button_frame"
			parent.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html';// "Pline_frame"
			parent.content.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.content.f_query_add_mod.frames[0].document.forms[0].queryString.value;
		}
		else{//for new born admission
			if(window.dialogArguments != undefined) {	


				var patient_id    = parent.frames[1].frames[0].document.forms[0].patient_id.value
				var admission_for = parent.frames[1].frames[0].document.forms[0].admission_for.value
				var called_from = parent.frames[1].frames[0].document.forms[0].called_from.value
				var operator_station = parent.frames[1].frames[0].document.forms[0].operator_station.value
				var deactivate_pseudo_bed_yn = parent.frames[1].frames[2].document.forms[0].deactivate_pseudo_bed_yn.value	
					//Added the code and passed as param for IN023629 on 03.08.2010 by Suresh M
				var bl_interfaced_yn = parent.frames[1].frames[2].document.forms[0].bl_interfaced_yn.value;
				var adm_date_chk_days_type = parent.frames[1].frames[2].document.forms[0].adm_date_chk_days_type.value;
				var adm_date_chk_days = parent.frames[1].frames[2].document.forms[0].adm_date_chk_days.value;
				
				parent.frames[1].frames[0].location.href ="../../eIP/jsp/AdmitPatientSelect.jsp?patient_id="+patient_id+"&admission_for="+admission_for+"&called_from="+called_from+"&oper_stn_id="+operator_station+" "; 
				parent.frames[1].frames[2].location.href ="../../eIP/jsp/addModifyAdmitPatient.jsp?oper_stn_id="+operator_station+"&deactivate_pseudo_bed_yn="+deactivate_pseudo_bed_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&adm_date_chk_days_type="+adm_date_chk_days_type+"&adm_date_chk_days="+adm_date_chk_days+"  "; 
				
			}
			
		}
	
		
		
}

function validateSplchars(obj, fld_lgnd)
{
    var fields = new Array(obj);
    var names = new Array(fld_lgnd);
    if(!SpecialCharCheck(fields,names,'',"A",'') )
    {
        obj.select()
        obj.focus()
        return false;
    }
    return true;
}


function validateFields(obj)
{
	var bkg_type		= parent.frames[0].document.Select_form.bkg_type.value;
	if(obj.value=="" && obj.name == 'bed_no')
	{
		if(bkg_type !='D' && document.forms[0].from_adv_bed_mgmt.value=='N')
			document.AdmitPatient_form.room_no.value = '';
		if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value == "Y")
			parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";
		parent.frames[3].document.getElementById('valuables').disabled = true;
	}

	if((obj.value=='')&&(obj.name!='nursing_unit_desc')) 
		return false;

    var continue_yn = true ;

    if((obj.value=='')&&(obj.name!='nursing_unit_desc'))   
		continue_yn =false;
    else if(obj.name == 'bed_no')   
	{
		continue_yn = validateSplchars (obj,'Bed No');
		if(bkg_type !='D')
		{	
			if(document.forms[0].from_adv_bed_mgmt.value=='N')
				document.AdmitPatient_form.room_no.value='';
			parent.frames[3].document.getElementById('valuables').disabled = false;
		}
	}

    if(continue_yn)
    {
		var admtypecode = '';
        var admdate  = '';
        var nursingcode = '';
        var bedno = '';
		var Splcode = "";
		var expDaysofStay = "";
		var tospecialtycode = '';
		var Indicator = '';
		var patient_class_id = "";


        if(obj.name == 'visit_adm_type')
            admtypecode = obj.value;
        else if(obj.name == 'visit_adm_date_time')
		{
			
            //admdate = obj.value;
			admdate	= convertDate(obj.value,"DMYHM",localeName,"en" );
			
		}
        else if(obj.name == 'nursing_unit_desc')
		{
			if(obj.value=='')
			Indicator = 'Blnk_Nursing_Unit';
			nursingcode = document.AdmitPatient_form.nursing_unit.value;
			bedno=	parent.frames[2].document.AdmitPatient_form.bed_no.value;
			tospecialtycode = document.AdmitPatient_form.to_speciality_code.value;
			if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value == "Y")
			parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";
			patient_class_id = document.AdmitPatient_form.patient_class_id.value
		}
		else if(obj.name == 'bed_no')
        {
            if(bkg_type !='D' && document.forms[0].from_adv_bed_mgmt.value=='N')
			document.AdmitPatient_form.room_no.value = '';
            bedno = obj.value;
			bedno = bedno.toUpperCase();
			if (bedno!='')
			{
				document.AdmitPatient_form.bed_no.value = bedno;
			}
            nursingcode		 = document.AdmitPatient_form.nursing_unit.value;
			patient_class_id = document.AdmitPatient_form.patient_class_id.value;
			
        }

		Splcode		     = document.AdmitPatient_form.Splcode.value;
		expDaysofStay	 = document.AdmitPatient_form.exp_days_stay.value;

		var service_add  = "Y";
		if(document.AdmitPatient_form.service.value != "")
			service_add  = "N";

		var urlStr		 = parent.frames[1].location.href;
		if(document.AdmitPatient_form.sub_service.value != "")
			service_add = "N";
		var deactivate_pseudo_bed_yn = document.AdmitPatient_form.deactivate_pseudo_bed_yn.value;
		var HTMLVal =" <html><body class='MESSAGE' onKeyDown='lockKey()'> <form name='mainform' id='mainform' "+
		" method='post' action='../../eIP/jsp/AdmissionValidation.jsp'>"+
		" <input type='hidden' name='field1' id='field1' value='"+admtypecode+"'> "+
		" <input type='hidden' name='field2' id='field2' value='"+admdate+"'> "+
		" <input type='hidden' name='field3' id='field3' value='"+nursingcode+"'> "+
		" <input type='hidden' name='field4' id='field4' value='Main_form'> "+
		" <input type='hidden' name='field5' id='field5' value='"+bedno+"'> "+
		" <input type='hidden' name='Splcode' id='Splcode' value='"+Splcode+"'> "+
		" <input type='hidden' name='Indicator' id='Indicator' value='"+Indicator+"'> "+
		" <input type='hidden' name='expDaysofStay' id='expDaysofStay' value='"+expDaysofStay+"'> "+
		" <input type='hidden' name='tospecialtycode' id='tospecialtycode' value='"+tospecialtycode+"'> "+ 
		" <input type='hidden' name='service_add' id='service_add' value='"+service_add+"'> "+
		" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class_id+"'> "+
		" <input type='hidden' name='bkg_type' id='bkg_type' value='"+bkg_type+"'> "+
		" <input type='hidden' name='from_adv_bed_mgmt' id='from_adv_bed_mgmt' value='"+document.forms[0].from_adv_bed_mgmt.value+"'> "+
		" <input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'> "+
		" </form></body></html>";

		if(parent.parent.messageFrame.document.body != null)
		{			
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.forms[0].submit();
		}
    }
	else
	{
        if(obj.name == 'bed_no')
        {
            if(bkg_type !='D' && document.forms[0].from_adv_bed_mgmt.value=='N')
				document.AdmitPatient_form.room_no.value = '';

			if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=="Y")
				parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";

			parent.frames[3].document.getElementById('valuables').disabled = true;
		}
    }
}


function popDynamicValues(obj)
{
	if(obj.value==parent.frames[0].arrNursingUnitDetails[0])
	{
		document.forms[0].ancillary_yn.value	=	parent.frames[0].arrNursingUnitDetails[1];
		document.forms[0].service.value			=	parent.frames[0].arrNursingUnitDetails[2];
		document.forms[0].bed_no.value			=	parent.frames[0].arrNursingUnitDetails[4];
		document.forms[0].room_no.value			=	parent.frames[0].arrNursingUnitDetails[5];
	}
    if (self.document.forms[0].name!='booking_form')
	{
		self.document.AdmitPatient_form.service.value = '';
        self.document.AdmitPatient_form.bed_no.value = '';
        self.document.AdmitPatient_form.room_no.value = '';
        var object = obj; 
        validateFields(object);
	}
}

function fetchValForBedClass(obj){}
/*
 * This function is used to validate the admission date
 */
function validateDate(obj,val)
{
	//var currdate = self.document.AdmitPatient_form.currdate;
	var back_date = self.document.AdmitPatient_form.back_date;
	//var visit_adm_date_time = document.AdmitPatient_form.visit_adm_date_time;
	
	if(obj.value != '')
    {
//		if(doDateTimeChk(obj))
		if(validDateObj(obj,"DMYHM", localeName)) // DateUtils.js
        {
			//var cdate	= convertDate(currdate.value,"DMYHM",localeName,"en");
			//var back_date	= convertDate(self.document.AdmitPatient_form.back_date.value,"DMYHM",localeName,"en" );
			var visit_adm_date_time	= convertDate(obj.value,"DMYHM",localeName,"en" );

			if(val == 'A')
            {
//				if(!ValidateDateTime(obj,currdate))
				if(!isBeforeNow(visit_adm_date_time, "DMYHM", 'en'))// DateUtils.js
				{
					alert(getMessage("FUTURE_DATE_NOT_ALLOWED",'IP'));
                    obj.focus();
					obj.select();
                }
				else
				{
					//if(!ValidateDateTime(back_date,obj))
					if(isBefore(visit_adm_date_time,back_date.value, "DMYHM", 'en'))
					{
						alert(getMessage("ADM_DATE_LT_EXCEEDED",'IP'));
						obj.focus();
						//obj.select();
						obj.value = "";
					}
					/*else
					{
					setTimeout("validateFields(document.AdmitPatient_form.visit_adm_date_time)", 0);
					}*/
				}
            }
        }
      }
	admDatestat = 1;
	return 1;
}

function beforeSubmit(val)
{
	var f = "";
    // if(parent.content !=null)
	// {
	// 	f = parent.content.frames[1];
	// }
	// else
	// {
    //     f = parent.frames[1];
    // }
	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	
    if(parent.content !=null && !dialogFrame)
	{
		f = parent.content.frames[1];
	}
	else
	{
		if(dialogFrame)
			f = dialogFrame.contentWindow.frames[1];
		else
			f = parent.frames[1];
	}

       f.frames[2].document.AdmitPatient_form.practid.disabled = false;
        f.frames[2].document.AdmitPatient_form.Splcode.disabled = false;
        f.frames[2].document.AdmitPatient_form.Bedcode.disabled = false;
        f.frames[2].document.AdmitPatient_form.nursing_unit.disabled = false;
        f.frames[2].document.AdmitPatient_form.team_id.disabled = false;
        f.frames[2].document.AdmitPatient_form.visit_adm_type.disabled = false;
        f.frames[2].document.AdmitPatient_form.arrival_code.disabled = false;
        f.frames[2].document.AdmitPatient_form.ambulatory_status.disabled = false;

        if(f.frames[2].document.AdmitPatient_form.gender_obj)
            f.frames[2].document.AdmitPatient_form.gender_obj.disabled=false;
        if(f.frames[2].document.AdmitPatient_form.name_prefixz)
            f.frames[2].document.AdmitPatient_form.name_prefixz.disabled=false;
        if(f.frames[2].document.AdmitPatient_form.name_suffixz)
            f.frames[2].document.AdmitPatient_form.name_suffixz.disabled=false;
        if(f.frames[2].document.AdmitPatient_form.nationality)
            f.frames[2].document.AdmitPatient_form.nationality.disabled=false;
		//chk for future blocks
		var bedno = f.frames[2].document.AdmitPatient_form.bed_no.value;
		var nursingunit = f.frames[2].document.AdmitPatient_form.nursing_unit.value;
		var patid = f.frames[0].document.Select_form.patient_id.value;
		
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/AdmissionValidation.jsp'><form><input type='hidden' name='field3' id='field3' value=\""+bedno+"\"><input type='hidden' name='patient_nursingunit' id='patient_nursingunit' value=\""+nursingunit+"\"><input type='hidden' name='future_yn' id='future_yn' value='Y'><input type='hidden' name='pat_id' id='pat_id' value=\""+patid+"\"></form></body></html>";
	
		messageFrame.document.write(HTMLVal);
		messageFrame.document.dummy_form.submit();
       return true;
}

/*
 * This function is used to get the date 
 */
function calcDate(Obj)
{
// below only one line added by Venkatesh.S on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804].
   var patient_class = parent.frames[0].document.Select_form.admission_for.value;
     
	 var dateVal = Obj.value;
		
		admDate = convertDate(AdmitPatient_form.visit_adm_date_time.value,'DMYHM',localeName,'en');
		
      	var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='dateVal' id='dateVal' value='"+dateVal+"'><input type='hidden' name='admDate' id='admDate' value='"+admDate+"'><input type='hidden' name='expdate' id='expdate' value='expdate'><input type='hidden' name='patient_class' id='patient_class' value='"+patient_class+"'></form></body></html>";
		parent.dummy.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        parent.dummy.document.forms[0].submit();

}

/*
 * This function is used to check the date and time format.
 * It internally calls chkDate and chktime methods
 */

function doChkDisDateTime(obj)
{
	
	
    var objchk = obj.value;
    if(objchk != 0)
    {
        var comp=obj
        obj=obj.value
        var sysdat = document.forms[0].currdate.value;
        var dttime = obj.split(" ");
        var dt
        var time
        var retval=true
        if(dttime.length>1)
        {
            dt=dttime[0]
            time=dttime[1]

            if(!checkDt(dt) )
            {
                retval= false
				comp.value="";
                comp.focus()
            }
            else
            {
                if(time==null || time=="")
                {
                    alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"));
                    retval= false;
                    comp.focus()
                    comp.select()
                }
                else
                {
                    if(!chkTime(time))
                    {
                        retval= false
                        alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"));
						comp.value="";
                        comp.focus()
                        comp.select()
                    }
                }
            }
        }//dttime length < 0
		else
		{
			retval= false
			alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"));
			comp.value="";
			comp.focus()
			comp.select()
		}

	return retval
    }

 }

/*
 *	This fucntion is used to check the date format
 *  and returns true or false
 */

function checkDt(date1)
{

    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

        if(date1m<=12)
        {

            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {	 retval= false	}

            if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
            {	retval= false	}

			if ((date1y.length <4) || (date1y.length >4))
			{	retval= false	}
        }
        else
		{	retval= false;	}
	}
    else
        {retval= false;}
        
	return retval;

}

/*
 * This function is used to check the time format and returns true or false
 */
function chkTime(time1)
{
    var retval=true;

    if( (time1.charAt(time1.length-1) )!=":")
    {
        var time1arr=new Array()
        time1arr=time1.split(":")

        if(time1arr.length==2)
        {
            var time1hr=time1arr[0]
            var time1min=time1arr[1]

            time1hr=eval(time1hr)
            time1min=eval(time1min)
            if(time1hr<=23)
            {
                if(time1min>60)
                  retval=false;
			}
            else
                retval=false;
        }
        else
            retval=false;
     }
    else
		retval=false;
 
    return retval
}

/*
 * This function is used to chk the OTdatetime format and calls validate function
 * returns true or false
 */
function doOTDateTimeChk(obj)
{
   
	//var objchk = obj.value;
    //if(objchk.length != 0)
    //{
       //retval= doDateTimeChk(obj)
		   
        //if(retval != false)
		if(validDateObj(obj,'DMYHM',localeName))
        {   
			//var OTdate				= objchk ;
			var OTdate			= convertDate(obj.value,'DMYHM',localeName,'en');
            //var admndate			= document.forms[0].visit_adm_date_time.value;
			var admndate		= convertDate(document.forms[0].visit_adm_date_time.value,'DMYHM',localeName,'en');
			//var exp_discharge_date	= document.forms[0].expecteddischargedate.value;
			var exp_discharge_date		= convertDate(document.forms[0].expecteddischargedate.value,'DMYHM',localeName,'en');
	
			if( ValidateAdmnOTDateTime(OTdate,admndate) == false ) 
				return false;
			if(exp_discharge_date != "")
			{
				 //if( ValidateAdmnOTDateTime(OTdate,exp_discharge_date) == false ) 
					 //return false;
					 if(isAfter(OTdate,exp_discharge_date,'DMYHM','en'))
					{
						alert(getMessage("INVALID_OT_DATE",'IP'));
						document.forms[0].ot_date_time.value="";
						document.forms[0].ot_date_time.focus();
						return false
					}
					else
						return true;
			}
        }
        else
        {
            //obj.select()
            //alert(getMessage("INVALID_DATE_TIME","SM"));
			return false;
        }

		//return retval
     //}
}
/*
 * This function is used to validat the OT date and it returns true or false
 */
function ValidateAdmnOTDateTime(from,to)
{
	/*var a=  from.split(" ")
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
	*/
    //if(Date.parse(from_date) > Date.parse(to_date))
	if(isBefore(from,to,'DMYHM','en'))
    {
        //alert(getMessage("INVALID_OT_DATE",'IP'));
        var error = getMessage("DATE1_SHD_GT_DATE2",'IP');
		error = error.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label",'IP'));
		error = error.replace('#',getLabel("Common.AdmissionDateTime.label",'Common'));
		alert(error);
		document.forms[0].ot_date_time.value="";
        document.forms[0].ot_date_time.focus();
        document.forms[0].ot_date_time.select();
        return false
    }
    else
        return true;
}
/*
 * This function is used to populate the referral patients
 */
async function PopRefDetails(){

		var retVal;
       var dialogHeight= "90vh" ;
	var dialogTop = "10" ;
	var dialogWidth	= "90vw" ;
        var center  = "1" ;
        var status  = "no";
        var scroll  = "no";

        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
        var arguments   = "" ;
		var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?calledFrom=IP&p_select=YES&p_reg_patient=YES&p_calling_function=IP_ADMIT";
		retVal = await window.showModalDialog(url,arguments,features);
	
		parent.parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.parent.f_query_add_mod.frames[0].document.forms[0].queryString.value;
			

        if(retVal!=null)
        {
            document.forms[0].referral_id.value=retVal;
			validatePat(document.forms[0].referral_id,'Referral ID');
			parent.frames[3].document.getElementById('referal_details').disabled = false;

			if(parent.frames[2].document.forms[0].isBlInstalled.value=="Y")
				parent.frames[2].document.forms[0].financial_detail_ref_id.value=retVal;
		}
		else
		{
			if(parent.frames[2].document.forms[0].isBlInstalled.value=="Y")
				parent.frames[2].document.forms[0].financial_detail_ref_id.value="";
		}
}


function popDynamicVals(obj,Splcode)
{
	if(Splcode==null)	
		Splcode	=	"";
	var val = obj.value;
	if (val != null && val != "")
	{
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value='"+val+"'><input type='hidden' name='funct' id='funct' value='spec'>"+
			"<input type='hidden' name='funct_name' id='funct_name' value='ipadmit'>"+
			"<input type='hidden' name='spl_fr' id='spl_fr' value='"+Splcode+"'>"+
			"</form></body></html>";
		self.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		self.document.query_spec.submit();
	}
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

/*function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}*/


/*
 *	This function is used to populate the speciality details...
 */
async function getSpecialty(getFacilitID)
{
	var tit				= getLabel("Common.speciality.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var facilityId		= getFacilitID;

	var locale			= document.forms[0].locale.value;
	//below changed for ABM
	if(document.forms[0].from_adv_bed_mgmt.value=='Y'){
		sql = "select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW a,IP_NURS_UNIT_FOR_SPECIALTY b where a.language_id = '"+locale+"' and eff_status like ? and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) and b.NURSING_UNIT_CODE='"+document.forms[0].nursing_unit.value+"' and a.SPECIALITY_CODE=+b.SPECIALTY_CODE";
	}else{
		sql = "select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW a where a.language_id = '"+locale+"' and eff_status like ? and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?)";
	}
	
	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "2,3";
	argumentArray[5]	= document.forms[0].SplDesc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].SplDesc.value=arr[1];
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].SplDesc_hid.value = document.forms[0].SplDesc.value;
		
		document.forms[0].practid_desc.value="";
		document.forms[0].practid.value="";

		document.forms[0].att_practid_desc.value="";
		document.forms[0].att_practid.value="";
		/*Tuesday, February 16, 2010 , 19382 ,disable bed no lookup button if Admit Patient with Bed is unchecked in AM->Operator Station */
		if((document.forms[0].nurs_unt_auth_val.value == "N" && document.forms[0].bed_mandatory_for_admn_yn.value == "N")|| document.forms[0].from_adv_bed_mgmt.value=='Y')
			document.forms[0].bed_avail_chart.disabled=true;
		else
			document.forms[0].bed_avail_chart.disabled=false;
	}
	else
	{
		if(document.forms[0].from_adv_bed_mgmt.value=='N'){
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit_desc.onblur();
		}

		document.forms[0].SplDesc.value="";
		document.forms[0].Splcode.value="";

		document.forms[0].practid_desc.value="";
		document.forms[0].practid_desc_hid.value="";

		document.forms[0].att_practid_desc.value="";
		document.forms[0].att_practid.value="";
	}
	
	
}


/*
 *	This funtion is used to populate the nursing unit with details
 *	Arg1	: Facility Id
 *	Arg2	: Login user
 *	Arg3	: Operatior station
 */
async function NursingUnitLookup(FacilityID,LoginUser,OperatorStationID)
{
	if(document.forms[0].SplDesc.value=='')
	{
		alert(getMessage('SPLTY_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.value = '';
		document.forms[0].nursing_unit.value = '';
		document.forms[0].SplDesc.select();
		return false;
	}
	var Facility_ID				=	FacilityID;
	var Login_User				=	LoginUser;
	var Operator_Station_ID		=	OperatorStationID;
	var nursingUnitCode			=  document.forms[0].nursing_unit_desc.value
	var tit						= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var tospecialtycode			= document.forms[0].to_speciality_code.value;
	var splty_code				= document.forms[0].Splcode.value;
	var pract_id				= document.forms[0].practid.value;
	var patientclass			= parent.frames[0].document.Select_form.admission_for.value;
	var bkg_type				= parent.frames[0].document.Select_form.bkg_type.value;
	var clin_code				= parent.frames[0].document.Select_form.clin_code.value;
	var admit_patient_with_bed_yn="Y";
	if(clin_code!="") {
		if(document.getElementById('d_clinic_code')) {
			document.getElementById('d_clinic_code').value = clin_code;
			}
	}

	var room_no					= document.forms[0].room_no.value;
	var bed_mandatory_for_admn_yn= document.forms[0].bed_mandatory_for_admn_yn.value;
	var call_function;

	

//		if(bkg_type == 'D' || bkg_type =='I')
		call_function='Admit_patient';
//		else
//			call_function='Admit';
	var statics_yn='Y';
	
	if (patientclass == "I")
	{
		patientclass = "IP";
	}
	if (patientclass == "D")
	{
		patientclass = "DC";
	}

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&specilaty_code="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&bkg_type="+bkg_type+"&clin_code="+clin_code+"&statics_yn="+statics_yn+"&call_function="+call_function+"&room_no="+room_no;
	
	var retVal =  await window.showModalDialog(jsp_name,arguments, features);
	var arr=new Array();
	if (retVal != null )
	{
		arr=retVal.split("~");		
		document.forms[0].nursing_unit_desc.value=arr[1];
		document.forms[0].nursing_unit.value=arr[0];
		document.forms[0].patient_class_id.value = arr[2];

		/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
		if(arr[0] != "")
		{
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH step='seven' nursing_unit=\""+arr[0]+"\"  operatorstation=\""+Operator_Station_ID+"\" Login_User=\""+Login_User+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			admit_patient_with_bed_yn = responseText
		}
		
		document.forms[0].nurs_unit_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		validateFields(document.forms[0].nursing_unit_desc);
		if(document.forms[0].patient_class_id.value == 'DC')
		{
			document.forms[0].exp_days_stay.value = '1';
			document.forms[0].exp_days_stay.onblur();
			document.forms[0].exp_days_stay.readOnly = true;
		}
		document.forms[0].Bedcode.value='';

		
		if(bkg_type !='D')
		{
			document.forms[0].bed_no.value='';
			document.forms[0].room_no.value='';
		}
		if(document.forms[0].pat_check_in_allowed_yn.value == "Y")
		document.forms[0].attend_img.style.visibility="hidden";
		parent.frames[3].document.getElementById('valuables').disabled = true;


		//document.forms[0].SplDesc.value='';
		//document.forms[0].Splcode.value='';
		document.forms[0].practid_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].att_practid_desc.value='';
		document.forms[0].att_practid.value='';

	}
	else
	{		
		document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.value = '';
		document.forms[0].patient_class_id.value ='';
		//document.forms[0].SplDesc.value='';
		//document.forms[0].Splcode.value='';
		document.forms[0].practid_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].att_practid_desc.value='';
		document.forms[0].att_practid.value='';
		document.forms[0].Bedcode.value='';
		document.forms[0].bed_type.value='';
		
		if(bkg_type !='D')
		{
			document.forms[0].bed_no.value='';
			document.forms[0].room_no.value='';
		}
		if(document.forms[0].pat_check_in_allowed_yn.value == "Y")
		document.forms[0].attend_img.style.visibility="hidden";
		parent.frames[3].document.getElementById('valuables').disabled = true;
		var obj = document.forms[0].service;
		var length  = obj.length;
		for(i=0;i<length;i++) { obj.remove(0); }
		
		var opt = document.createElement("OPTION");
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value= '';
		document.forms[0].service.add(opt);
	}
	/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
	
	
	if(admit_patient_with_bed_yn=="Y" || bed_mandatory_for_admn_yn == "Y") 
	{
		enableBed(document.forms[0].nursing_unit_desc);
	}
	else 
	{
		document.forms[0].bed_no.value = '';
		document.forms[0].bed_avail_chart.disabled = true;
	}
}
/*modified for GHL-CRF-0020 */
function Allfunc(obj1,obj2)
{  
	
	document.forms[0].bl_success.value = "N";
}function CheckForSpecChars_Remarks(event)
{
	var strCheck ='~`!@#$%^&*()-_=+{[}]|:;",./?\<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    //if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM"))
	return false ;
}
function imposeMaxLength(obj)
{
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.admission.label","common") + " " + getLabel("Common.remarks.label","common");
		error = error.replace("$",remarks);
		error = error.replace("#","250")
		alert(error);
		obj.value=obj.value.substring(0,mlength)
	}
}

// Added for MMS-QH-CRF-0144 : The below method is moved from AdmitPatientSelect.jsp to this JS file.
function disableflds()
{ 
	var call_func = parent.frames[2].document.AdmitPatient_form.call_func.value;
	
	if(call_func == "PATREG")
	{
		validatePat(document.forms[0].patient_id,'Patient ID');
	}
}
//Added by Abirami for enabling ValidatePatient.
function changeValidatePat()
{
	document.Select_form.validatePat_yn.value = 'N'; // Modified by Abirami 	
}


/*Added By Dharma on 21st Oct 2015 Start*/
function validatePatient(obj,localeName){
	var dateTime	= obj.value;
	var dateTime = convertDate(dateTime,'DMYHM',localeName,'en');
	var patientId = parent.frames[0].document.Select_form.patient_id.value;
	if(patientId!="" && dateTime!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH dateTime=\""+dateTime+"\"  patientId=\""+patientId+"\" action='validate_admision_discharge_date_time' flag='A' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(responseText!=""){
			var msg = getMessage("DATE_OVERLAPPING","IP");
			msg		= msg.replace("$",getLabel("Common.admissiondate.label","common"));
			msg		= msg.replace("#",responseText);
			alert(msg);
			obj.focus();
		}
	}
}


function isDownTimePatient(){
	
	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	if(dialogFrame)
	{
		f =dialogFrame.contentWindow.frames[1];
	}
	else if(parent.content !=null && !parent.parent.document.getElementById('dialog-body')) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}
	var patientId = f.frames[0].document.Select_form.patient_id.value;
	//alert(patientId + 'pateint id')
	if(patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='isDownTimePatient' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.response
		responseText = trimString(responseText)
		return responseText;
	}else{
		return "false";
	}
}
/*Added By Dharma on 21st Oct 2015 End*/ 
/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start*/
function chkForm60OrPanCardAvail(isForm60Available){
	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	

	
    if(parent.content !=null && !dialogFrame)
	{
		f = parent.content.frames[1];
	}
	else
	{
		if(dialogFrame)
			f = dialogFrame.contentWindow.frames[1];
		else
			f = parent.frames[1];
	}
	var patientId = f.frames[0].document.Select_form.patient_id.value;

	if(isForm60Available=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='chkForm60OrPanCardAvail' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText
	}
}
/*Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End*/

//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
function PanCardAvailCheck(isPanCardAvailable){
	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	
    if(parent.content !=null && !dialogFrame)
	{
		f = parent.content.frames[1];
	}
	else
	{
		if(dialogFrame)
			f = dialogFrame.contentWindow.frames[1];
		else
			f = parent.frames[1];
	}
	var patientId = f.frames[0].document.Select_form.patient_id.value;
	if(isPanCardAvailable=="true" && patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PanCardAvailCheck' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText
	}
}
// added by mujafar for MMS-MD-SCF-0096 start  
function getSysDateTime(adm_date_chk_days,adm_date_chk_days_type)
{ 

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH adm_date_chk_days=\""+adm_date_chk_days+"\"  adm_date_chk_days_type=\""+adm_date_chk_days_type+"\" action='getSystemDateTime'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var sysDateTime = trimString(responseText);
	
	return sysDateTime;
}
// added by mujafar for MMS-MD-SCF-0096 start 

/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
function fnGetRegistrationDateTime(){

	var dialogFrame = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	

	
    if(parent.content !=null && !dialogFrame)
	{
		f = parent.content.frames[1];
	}
	else
	{
		if(dialogFrame)
			f = dialogFrame.contentWindow.frames[1];
		else
			f = parent.frames[1];
	}
	var patientId = f.frames[0].document.Select_form.patient_id.value;

	if(patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='getRegDateTime' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText
	}
}
 /*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/

/*Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779*/
function psychiatryForms()
{
	var admissionFormCode	= "";
	var shortDesc			= "";
	var byDefault			= "";
	var PFValue				= "";
	var checkAttribute		= "";
	var splcode				= document.AdmitPatient_form.Splcode.value;
	
	var jsonArguments	= {
							'splcode':splcode,
							'action':'fetchPsychiatryForm'
						  };
	if(splcode!="")
	{
		$.ajax({  
			url:'../../eIP/jsp/PsychiatryFormIntermediate.jsp',  
			type:'post',
			data:jsonArguments,
			dataType: 'json',
			
			success: function(data)
			{
				if(data!=null)
				{
					var storedRecordList = eval(data);

					$.each(storedRecordList,function(index,value)
					{		
						admissionFormCode	=  value.admissionFormCode;
						shortDesc			=  value.shortDesc;
						byDefault			=  value.byDefault;
					
						
						if(byDefault == "Y" )
						{
							checkAttribute = "checked";
						}
						else
						{
							checkAttribute = "";
						}

						PFValue += "<tr><td align='left' class='label' nowrap><input type='checkbox' id='pf_id"+index+"' name='pfcheckbox' id='pfcheckbox' onclick = 'PformGetCheckdValues("+index+");'  value="+admissionFormCode+" "+checkAttribute+">"+shortDesc+"</td></tr>";

						setTimeout("PformGetCheckdValues("+index+");",200);
	
					});
					
					$("#PF_display",parent.frames[2].document).html(PFValue);
				}
			},
			error: function(data)
			{
				$("#PF_display",parent.frames[2].document).html("");
			}
			});
	}else
	{
		$("#PF_display",parent.frames[2].document).html("");
	}
}

function PformGetCheckdValues(ind)
{
	var VarCheckedValues	= "";
	var cnt					= 0;
		
		$("input[name='pfcheckbox']").filter(':checked').each(function() {
			VarCheckedValues+=$(this).val()+",";
			cnt++;
		});

		if(cnt>10)
		{
			var msg = getMessage("CANNOT_SEL_MORE_THAN_TEN_FORM","IP");
			alert(msg);
			$("input[id='pf_id"+ind+"']").attr('checked', false); 
		}
		else
		{
			if(VarCheckedValues!='')
			{
				VarCheckedValues = VarCheckedValues.slice(0,-1);
			}

			document.AdmitPatient_form.PFValue.value = VarCheckedValues;
		}
}
/*End ML-MMOH-CRF-0779*/

