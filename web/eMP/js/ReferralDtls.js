function closeWin()
{
	window.returnValue = "Pass";
	window.close();
	top.frames[2].frames[1].frames[2].location.reload();
	
}
 
function reloadPage()
{
	 
	var encounter_id = parent.frames[1].document.forms[0].from_encounter_id.value;
	var patient_id = parent.frames[1].document.forms[0].patient_id.value;
	var Transaction_type = parent.frames[1].document.forms[0].Transaction_type.value;
	
	parent.frames[2].location.href= "../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id="+encounter_id+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+" ";
}
function updateRefDtls()
{
	document.forms[0].mode.value ="update";
	if(document.forms[0].Transaction_type.value == 'DP')
	{
		document.forms[0].submit();
	}
}

function submitPage()
{

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
	var function_id = document.forms[0].hddFuncID.value;
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

	var fields = new Array();
		var ref_type = document.forms[0].referral_type.value;
		var refDateNonMandatory = parent.frames[1].document.forms[0].isRefDateNonMandatory.value;
		var i=0;
		if(ref_type != "X")
	{
		fields[i++] = document.forms[0].referral_type;
		fields[i++] = document.forms[0].hcare_setting_type;
		fields[i++] = document.forms[0].referred_to;

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
		{
			if(refDateNonMandatory != "true")
				fields[i++] = document.forms[0].preferred_date;
		}

		fields[i++] = document.forms[0].speciality;
		fields[i++] = document.forms[0].priority;
	}
	else
	{
		fields[i++] = document.forms[0].referral_type;
		fields[i++] = document.forms[0].hcare_setting_type;
		fields[i++] = document.forms[0].referred_to;

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
		{
			if(refDateNonMandatory != "true")
				fields[i++] = document.forms[0].preferred_date;
		}

		fields[i++] = document.forms[0].priority;

	}

	if(document.getElementById('refID').style.visibility=='visible')
	{
	    /*if(ref_type != "X")
		  fields[i++] = document.forms[0].ref_for_ip;
		else
          fields[i++] = document.forms[0].ref_for_ip;*/

		if(ref_type == "X")
		{
			
			fields[i++] = document.forms[0].ref_for_ip; 
			var names = getLabel("Common.referraltype.label","Common");
			names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
			names = names + "," + getLabel("Common.ReferredTo.label","Common");
			
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
			{
				if(refDateNonMandatory != "true")
					names = names + "," + getLabel("Common.PreferredDate.label","Common");
			}

			names = names + "," + getLabel("Common.priority.label","Common"); 
			names = names + "," + getLabel("Common.referredfor.label","Common");

			/*getLabel("Common.referraltype.label","Common");
			getLabel("Common.HealthcareSettingType.label","Common");
			getLabel("Common.referralsource.label","Common");
			getLabel("Common.PreferredDate.label","Common");
			getLabel("Common.speciality.label","Common");
			getLabel("Common.priority.label","Common");
			getLabel("Common.PreferredDate.label","Common");*/
		}
		else
		{
			fields[i++] = document.forms[0].location0;
			fields[i++] = document.forms[0].ref_for_ip;
			//var names = new Array (	"Referral Type", "Healthcare Setting Type", "Referral Source", "Preferred Date", "Specialty", "Priority","Location ", "Referred For" );
						 /*Below line Added for this CRF  Bru-HIMS-CRF-261 */		
			if(document.forms[0].quick_admission && document.forms[0].quick_admission.checked){
	               fields[i++] = document.forms[0].location1;
	               fields[i++] = document.forms[0].pract_name;
	               fields[i++] = document.forms[0].Bedcode;
	               fields[i++] = document.forms[0].bed_type;
				   fields[i++] = document.forms[0].service_desc;
				   fields[i++] = document.forms[0].visit_adm_type;
					var names = getLabel("Common.referraltype.label","Common");
					names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
					names = names + "," + getLabel("Common.ReferredTo.label","Common");

					//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
					if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
					{
						if(refDateNonMandatory != "true")
							names = names + "," + getLabel("Common.PreferredDate.label","Common");
					}

					names = names + "," + getLabel("Common.speciality.label","Common");
					names = names + "," + getLabel("Common.priority.label","Common");
					names = names + "," + getLabel("Common.locationtype.label","Common");
					names = names + "," + getLabel("Common.referredfor.label","Common");
					names = names + "," + getLabel("Common.Location.label","Common");
					names = names + "," + getLabel("Common.practitioner.label","Common"); 
					names = names + "," + getLabel("Common.BedClass.label","Common");
					names = names + "," + getLabel("Common.bedtype.label","Common");
					names = names + "," + getLabel("Common.service.label","Common");
					names = names + "," + getLabel("Common.admissiontype.label","Common");
			}else{ 
			//End  Bru-HIMS-CRF-261 
			
					var names = getLabel("Common.referraltype.label","Common");
					names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
					names = names + "," + getLabel("Common.ReferredTo.label","Common");

					//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
					if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
					{
						if(refDateNonMandatory != "true")
							names = names + "," + getLabel("Common.PreferredDate.label","Common");
					}

					names = names + "," + getLabel("Common.speciality.label","Common");
					names = names + "," + getLabel("Common.priority.label","Common");
					names = names + "," + getLabel("Common.locationtype.label","Common");
					names = names + "," + getLabel("Common.referredfor.label","Common");
			}
		}

	}
	else
	{		
		if(ref_type == "X")
		{  
			//var names = new Array (	"Referral Type", "Healthcare Setting Type", "Referral Source", "Preferred Date", "Specialty", "Priority" );
			var names =	getLabel("Common.referraltype.label","Common");
			names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
			names = names + "," + getLabel("Common.ReferredTo.label","Common");

			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
			{
				if(refDateNonMandatory != "true")
					names = names + "," + getLabel("Common.PreferredDate.label","Common");
			}

			names = names + "," + getLabel("Common.priority.label","Common");
		}
		else
		{	//alert("ref_type--->"+ref_type);			
            if(ref_type != ""){
				fields[i++] = document.forms[0].location0;
				
				 /*Below line Added for this CRF  Bru-HIMS-CRF-261 */		
				if(document.forms[0].quick_admission && document.forms[0].quick_admission.checked){ 
					   fields[i++] = document.forms[0].location1;
					   fields[i++] = document.forms[0].pract_name;
					   fields[i++] = document.forms[0].Bedcode;
					   fields[i++] = document.forms[0].bed_type;
					   fields[i++] = document.forms[0].service_desc;
					   fields[i++] = document.forms[0].visit_adm_type;
						var names =	getLabel("Common.referraltype.label","Common");
						names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
						names = names + "," + getLabel("Common.ReferredTo.label","Common");

						//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
						if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
						{
							if(refDateNonMandatory != "true")
								names = names + "," + getLabel("Common.PreferredDate.label","Common");
						}

						names = names + "," + getLabel("Common.speciality.label","Common"); 
						names = names + "," + getLabel("Common.priority.label","Common");
						names = names + "," + getLabel("Common.locationtype.label","Common");
						names = names + "," + getLabel("Common.Location.label","Common");
						names = names + "," + getLabel("Common.practitioner.label","Common");
						names = names + "," + getLabel("Common.BedClass.label","Common");
						names = names + "," + getLabel("Common.bedtype.label","Common");
						names = names + "," + getLabel("Common.service.label","Common");
						names = names + "," + getLabel("Common.admissiontype.label","Common");
				}else{ 
				//End  Bru-HIMS-CRF-261 
				
						var names =	getLabel("Common.referraltype.label","Common");
						names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
						names = names + "," + getLabel("Common.ReferredTo.label","Common");

						//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
						if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
						{
							if(refDateNonMandatory != "true")
								names = names + "," + getLabel("Common.PreferredDate.label","Common");
						}

						names = names + "," + getLabel("Common.speciality.label","Common");
						names = names + "," + getLabel("Common.priority.label","Common");
						names = names + "," + getLabel("Common.locationtype.label","Common");
				}
			}
			else
			{
				var names = getLabel("Common.referraltype.label","Common");
				names = names + "," + getLabel("Common.HealthcareSettingType.label","Common");
				names = names + "," + getLabel("Common.ReferredTo.label","Common");

				//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
				if(isImproveReferralProcessAppl != "true" || function_id == 'RegisterInpatientReferral')
				{
					if(refDateNonMandatory != "true")
						names = names + "," + getLabel("Common.PreferredDate.label","Common");
				}

				names = names + "," + getLabel("Common.speciality.label","Common");
				names = names + "," + getLabel("Common.priority.label","Common");
			}
		}

	}

	if(checkMandatory( fields, names)) 
	{
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"

		for(var i=0; i<document.forms[0].length;i++)
		{
			if( document.forms[0].elements[i].disabled ==true)
			{
				document.forms[0].elements[i].disabled =false;
			}
		}
		document.forms[0].record.disabled=true;
		/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 start*/
		if(  function_id=="ModifyReferral" && isForAdmissionAppl=="true") {
			document.forms[0].mode.value ="modify";	
			document.forms[0].submit();	
			alert(getMessage("RECORD_MODIFIED","SM" ));
			document.parentWindow.returnValue = "Y";
			parent.window.close();
		}
		else if(  function_id=="for_admission" && isForAdmissionAppl=="true") {
			document.forms[0].mode.value ="insert";
			document.forms[0].submit();
			alert(getMessage("RECORD_MODIFIED","SM" ));
			document.parentWindow.returnValue = "Y";
			parent.window.close();	
		}
		
		else {
			document.forms[0].mode.value ="insert";
			document.forms[0].action= "../../servlet/eMP.RegisterReferralsServlet";
			document.forms[0].submit();
		}
		/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 end*/

	}
}

function checkMandatory( fields, names)
{

	var errors = "" ;
	var str2="";
	var names1=names.split(",");
	//var message=getMessage("CAN_NOT_BE_BLANK",'Common');
	//message.replace('$',"")
	for( var i=0; i<fields.length; i++ ) {
		if(CheckVal(fields[i].value)) {}
		else{
			//errors = errors + "APP-00000"+(i+1)+" "+ names[i] + " cannot be blank..." + "\n" ;
		//	str2=(i+1)+" "+names[i];
			str2=names1[i];
			errors = errors + getMessage("CAN_NOT_BE_BLANK",'Common').replace('$',str2)+ "\n" ;
		}
		
	}
	if ( errors.length != 0 ) {
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

function clearAll()
{
	document.forms[0].reset();	
	document.forms[0].priority.value	= "L";
	document.forms[0].record.disabled	= false;
	if(document.getElementById('id4'))
				document.getElementById('id4').style.visibility	= 'Visible';
	document.getElementById('location0').disabled=true;
	document.getElementById('locn_type_img').style.visibility	= 'Hidden';
	document.getElementById('location1').disabled=true;
	document.getElementById('location2').disabled=true;
	document.getElementById('pract_name').disabled=true;
	document.getElementById('pract_butt').disabled=true;
	document.getElementById('refID').style.visibility	= 'Hidden';

	document.getElementById('lng_name').style.visibility="hidden";
	document.forms[0].referred_to.value="";
	document.forms[0].referral_source.value="";
	document.forms[0].referral_source_lkp_bkup_text.value="";

	
/*Below line Added for this CRF Bru-HIMS-CRF-261*/	
if(document.forms[0].quick_admission && !document.forms[0].quick_admission.checked){
	
if(document.getElementById('locntion_img')) 
document.getElementById('locntion_img').style.visibility	= 'hidden';	
if(document.getElementById('PractImg')) 
document.getElementById('PractImg').style.visibility	= 'hidden';	
if(document.getElementById('bedcode_img')) 
document.getElementById('bedcode_img').style.visibility	= 'hidden';
if(document.getElementById('locntion_type_img')) 
document.getElementById('locntion_type_img').style.visibility	= 'hidden';
if(document.getElementById('visit_adm_type_img')) 
document.getElementById('visit_adm_type_img').style.visibility	= 'hidden';
if(document.getElementById('service_desc_img')) 
document.getElementById('service_desc_img').style.visibility	= 'hidden';
if(document.getElementById('bedclass')) 
document.getElementById('bedclass').style.visibility	= 'hidden';
if(document.getElementById('bedclass1')) 
document.getElementById('bedclass1').style.visibility	= 'hidden';
if(document.getElementById('bedtype')) 
document.getElementById('bedtype').style.visibility	= 'hidden';
if(document.getElementById('bedtype1')) 
document.getElementById('bedtype1').style.visibility	= 'hidden';
if(document.getElementById('admtype')) 
document.getElementById('admtype').style.visibility	= 'hidden';
if(document.getElementById('admtype1')) 
document.getElementById('admtype1').style.visibility	= 'hidden';	
}  
/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 


if(document.forms[0].hddFuncID.value=="ModifyReferral" && document.forms[0].isForAdmissionAppl.value=="true"){
	document.forms[0].speciality.value="";
	document.forms[0].speciality_desc.value="";
	document.forms[0].service.value="";
	document.forms[0].service_desc.value="";
	document.forms[0].practitioner.value="";
	document.forms[0].pract_name.value="";
	document.forms[0].ref_for_ip.value="";
	document.forms[0].preferred_date.value="";
	document.forms[0].referral_reason_code.value="";
	document.forms[0].referral_reason_desc.value="";
	document.forms[0].priority.value="";
	document.forms[0].location2.value="";
	document.forms[0].from_ext_practitioner_id.value="";
	document.forms[0].onloadcount.value='1';

}
/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
//End Bru-HIMS-CRF-261
	//parent.frames[2].location.href ='../../eCommon/html/blank.html'; //this line commented for End Bru-HIMS-CRF-261
}

function TableHeader()
{
	setTimeout("enableTableHeader()",1000);
}

/// Function used to enable the table header if there are tuples...
function enableTableHeader()
{
	parent.frames[1].document.getElementById('RefDetailsHeader').style.visibility='Visible';
}

/// Function used to view the details of appointments already made...
async function view_appt_details(ref_no)
{
	var retVal		=    new String();
	var dialogHeight= "70vh";	
	var dialogWidth = "70vw";
	var dialogTop	= "120";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal =await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+ref_no+"&flag=Visit_Reg",arguments,features);
}

/// Function used to Book an appointment for that Referral ID...
async function book_appointment(referral_id, P_practitioner_id, P_patient_id, splty_code, P_locn_type, recall_date, i, P_locn_code,encounter_id,facility_id)	
{
	var selectedPractId		= P_practitioner_id;
	var selectedLocnCode	= P_locn_code;

	var retVal		= new String();
	var returnVal	= new String();
	
	var dialogHeight= "90vh";	
	var dialogWidth = "90vw" ;
	var dialogTop	= "1" ;
	var center		= "1" ;
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;

	var condition = '';
	var condition = "i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+"&callingMode=OP&from_AE=N&from_facility_id="+facility_id+"&from_encounter_id="+encounter_id;
	
	
	retVal = await top.window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+condition,arguments,features);

	//variable added by Sethu for dynamic name to be set in the document.getElementById()
	var field_id_apptLabel = "";	

	if(retVal != null && retVal != "")
	{
		var Val = retVal.split("^");
		var mode = Val[0];
		h = Val[1];

		if (mode=="1")
		{
			h=h+ "&title="+getLabel('Common.bookappointment.label','common');
			returnVal = await top.window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);
			
		}
		else if (mode=="2")
		{
			h=h+ "&title="+getLabel('Common.bookappointment.label','common');
			returnVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
			
		}
		else if (mode=="3")
		{
			h=h+ "&title="+getLabel('Common.bookappointment.label','common');
			returnVal = await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
			
		}else{
			returnVal = retVal;
		}
	
		if(returnVal != null && returnVal != "")
		{
			if(returnVal=="OP")
			{
				book_appointment(referral_id, P_practitioner_id, P_patient_id, splty_code, P_locn_type, recall_date, i)
			}
			else if(returnVal != null && returnVal != "")
			{

				
				field_id_apptLabel = "apptLabel"+i;
				var result = returnVal.split("*");
				if(result[0] != "OP" && parent.frames[1].document.forms[0].Refresh){ 
					var ApptNo		= result[0];					
					//eval("document.getElementById('apptLabel')"+i).innerText	= ApptNo;
					eval(document.getElementById(field_id_apptLabel)).innerText	= ApptNo;
					parent.frames[1].document.forms[0].Refresh.onclick();
				}else if( result[0] != "OP" && !parent.frames[1].document.forms[0].Refresh){ 
				    var ApptNo		= result[0];
					//eval("document.getElementById('apptLabel')"+i).innerText	= ApptNo;
					eval(document.getElementById(field_id_apptLabel)).innerText	= ApptNo;
				 reloadPage();
				}
			}
		}
	}
}

/// This function will open ViewPatReferral.jsp., to view the Referral details...
async function showRefDtls(ref_id)
{
	var retVal = 	new String();
	var arguments = "";
	var dialogHeight= "95vh" ;
	var dialogTop = "1" ;
	var dialogWidth	= "99vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
	
	var retVal = await  top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref_id,arguments,features);
}

/// Added by Sridhar R on 13 JULY 2004
/// Function scrollView() will focus on respective tabs based on function...
function scrollView(obj)
{
	var FuncID = document.forms[0].hddFuncID.value;
	if(FuncID == 'PrepareDischargeAdvice' || FuncID == 'DischargePatient')
	{
		var BodyFrame	= document.forms[0].hddBodyFrame.value;
		var SubmitFrame = document.forms[0].hddSubmitFrame.value;

		if(obj.name == 'referred')
		{
			if(document.forms[0].referral_type.disabled)
			{
				eval(BodyFrame).document.getElementById("tab1").scrollIntoView();
				eval(BodyFrame).document.forms[0].auth_pract_desc.focus();
			}
		}
		else if(obj.name == 'ReferralNotesButton')
		{
			eval(BodyFrame).document.getElementById("tab2").scrollIntoView();
			eval(BodyFrame).document.forms[0].referred.focus();
		}
	}
}

function getService(Nursunit,Location)
{
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;

	var reff_to = document.forms[0].referred_to.value; 
	var referralType = document.forms[0].referral_type.value;
	var speciality_code = document.forms[0].speciality.value;
	var Nursunit = Nursunit.value;
	var Location_Type = Location.value;
	

	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateService&Nursunit="+Nursunit+"&Location_Type="+Location_Type+"&reff_to="+reff_to+"&speciality_code="+speciality_code+"&ref_type="+referralType+"&BodyFrame="+BodyFrame+" '></form></BODY></HTML>";
	eval(SubmitFrame).document.write(HTMLVal);
	eval(SubmitFrame).document.forms[0].submit();
}

	function disable()
	{
		//document.forms[0].referred_to.disabled			= true; // commented for crf 508 and below 2 lines added
		document.forms[0].referral_source.disabled			= true;
		document.forms[0].referral_source_lkp_but.disabled	= true;

		document.forms[0].hcare_setting_type.disabled	= true;		
		document.forms[0].referral_type.disabled		= true;
		document.forms[0].location0.disabled			= true;
		document.forms[0].location1.disabled			= true;
		document.forms[0].location2.disabled			= true;
		document.forms[0].location2.style.display='none';
		document.forms[0].service_desc.disabled			= true;
		document.forms[0].search_service.disabled		= true;
	}

/// Only for Register Inpatient Referral Function ...[IP module]
//// Sets the value for Bedside as 'Y' if Checked else 'N'
function setVal()
{	
	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
	var function_id = document.forms[0].hddFuncID.value;

	if(document.forms[0].Bedside.checked == true)
	{
		document.forms[0].Bedside.value				= 'Y';

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
			document.getElementById('prefDateImg').style.visibility = 'hidden';
		}else{
			document.getElementById('prefDateImg').style.visibility = 'visible';
		}

		//document.getElementById('PractImg').style.visibility		= 'visible';
		document.getElementById('locn_type_img').style.visibility	= 'hidden';

		document.forms[0].referred.checked		= true
			setTimeout('enable_referred(document.forms[0].referred)',200);
		document.forms[0].referral_type.value	= 'L';
			setTimeout('getval1(document.forms[0].referral_type)',400);	  

		setTimeout('disable()',600);
		
			/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538]*/	
			
			document.getElementById('frm_pract_image').style.visibility	= 'visible';
            document.getElementById('frm_practn_name').style.visibility	= 'visible';
			document.getElementById('frm_practimg').style.visibility	= 'visible';
			
		    //Started CRF Bru-HIMS-CRF-354 [IN:038538]	
			if(parent.frames[1].document.RefPatientDtls_form.pract_bedside_referral.value=="A"){
			document.getElementById('frm_pract_name').value=parent.frames[1].document.RefPatientDtls_form.from_practitioner_name.value;
			document.getElementById('frm_practitioner').value=parent.frames[1].document.RefPatientDtls_form.practitioner_id.value;
			}if(parent.frames[1].document.RefPatientDtls_form.pract_bedside_referral.value=="L"){ 			
			document.getElementById('frm_pract_name').value=parent.frames[1].document.RefPatientDtls_form.loginpractitioner.value;
			document.getElementById('frm_practitioner').value=parent.frames[1].document.RefPatientDtls_form.functionroleid.value;
			}
			//End Bru-HIMS-CRF-354 [IN:038538]	
		
		
	}
	else
	{
		document.forms[0].Bedside.value				= 'N';
		document.getElementById('prefDateImg').style.visibility	= 'hidden';
		document.getElementById('PractImg').style.visibility		= 'hidden';
		document.getElementById('locn_type_img').style.visibility	= 'visible';

		document.forms[0].referred.checked		= true
			enable_referred(document.forms[0].referred);
		document.forms[0].referral_type.value	= '';
			//getval1(document.forms[0].referral_type);
		parent.frames[1].defaultLoginFacility();/*Added By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]*/

		//document.forms[0].referred_to.disabled			= false;  // commented for crf 508 & below 2 lines added
		
		/*Commented By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/
		/*document.forms[0].referral_source.disabled			= false;
		document.forms[0].referral_source_lkp_but.disabled			= false;

		document.forms[0].hcare_setting_type.disabled	= false	*/	
		/*Commented By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/
		document.forms[0].referral_type.disabled		= false
		/*Wednesday, July 08, 2009 IN012168*/
		//document.forms[0].location0.disabled			= false
		//document.forms[0].location1.disabled			= false
		document.forms[0].location2.disabled			= false
		document.forms[0].location2.style.display='inline';

		document.forms[0].service_desc.disabled			= false
		document.forms[0].search_service.disabled		= false
		
		/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538]*/	
		document.getElementById('frm_pract_name').value="";
		document.getElementById('frm_practitioner').value="";
		document.getElementById('frm_pract_image').style.visibility	= 'hidden';
        document.getElementById('frm_practn_name').style.visibility	= 'hidden';
		document.getElementById('frm_practimg').style.visibility	= 'hidden';
			//End Bru-HIMS-CRF-354 [IN:038538]	
		
	}
}

function populate_hcare(obj)
{
	var FuncID = document.forms[0].hddFuncID.value;
	if(FuncID != 'DischargePatient')
	{
		document.getElementById('practitioner').value	= "";
		document.getElementById('pract_name').value	= "";
	}
	 var ref_type = document.forms[0].referral_type.value;
	 if (ref_type =="X")
	 {
		if(FuncID != 'DischargePatient')
		{
			document.forms[0].location2.value		= "";
		}

	 }
	 else if(ref_type =="E" || ref_type =="L")
	 {
		delete_values(document.forms[0].location1)

		if(document.forms[0].speciality.value != "")
	    {
			document.forms[0].pract_butt.disabled=false;
			document.forms[0].pract_name.disabled=false;
		}
		else
		{
			document.forms[0].pract_butt.disabled=true;
		   document.forms[0].pract_name.disabled=true;
		}
	 }
}

function popServiceXRef(obj)
{
	if(obj.value == 'L')
	{
		//document.forms[0].referred_to.onchange();
	}
}

/// The function is called on the onchange event of [Referred To] to fetch the records for specialty  & Service ...
function populate_ext_specialty(obj)
{
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module = document.forms[0].hddModule.value;
	
	var ref_to_code	= obj.value;
	var ref_type	= document.forms[0].referral_type.value;
	var hcare_type	= document.forms[0].hcare_setting_type.value;

/*	if(ref_type == 'X')
	{
		delete_values(document.getElementById("speciality"));
	
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateSpecialty&ref_type="+ref_type+"&hcare_type="+hcare_type+"&ref_to_code="+ref_to_code+"&BodyFrame="+BodyFrame+"&Module="+Module+"'></form></BODY></HTML>";
		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	}
	else if(ref_type=='E' || ref_type=='L')
	{

		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateServiceVals&ref_type="+ref_type+"&hcare_type="+hcare_type+"&ref_to_code="+ref_to_code+"&BodyFrame="+BodyFrame+"&Module="+Module+"'></form></BODY></HTML>";
		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();

	} */

	if(ref_type == '' || obj.value == '')
	{
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateBlankORG&ref_type="+ref_type+"&hcare_type="+hcare_type+"&ref_to_code="+ref_to_code+"&BodyFrame="+BodyFrame+"&Module="+Module+"'></form></BODY></HTML>";
		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	}
}

async function referral_notes(val)
{
	var function_id			=	document.forms[0].functionid.value;
	//alert(function_id);
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var functionid=document.forms[0].hddFuncID.value;
	var referralcomponent;
	var dialogHeight= "203px" ;
	var dialogWidth = "700px" ;                    
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
	if (functionid == "DischargePatient")
		eval(BodyFrame).document.forms[0].ReferralNotes.value	=	val;

	var arguments	= escape(eval(BodyFrame).document.forms[0].ReferralNotes.value);
	var retVal ="";
	if (functionid != "DischargePatient")
	{
		
		retVal = await top.window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?function_id="+function_id+"&ref_comp=refNotes",arguments,features);
		
			
	}
	else
	{

		retVal = await window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?function_id="+function_id+"&from=search&ref_comp=refNotes",arguments,features);
		
	}
	
	if(retVal != null){
		eval(BodyFrame).document.forms[0].ReferralNotes.value=unescape(retVal);
	}
}

function blurgetReasonForRef(obj)
{
	if(makeValidString(obj))
		obj.select();

	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	obj.value=trimString(obj.value);

	if(obj.value == "")
	{
		document.forms[0].referral_reason_code.value;
		eval(BodyFrame).document.forms[0].ref_reason.disabled=false;
		return;
	}
	getReasonForRef(document.forms[0].ref_reason)
}

async function getReasonForRef(obj)
{
	var BodyFrame		= document.forms[0].hddBodyFrame.value;
	var tit				= getLabel('Common.ReasonforReferral.label','common');
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	// This sql is used to populate the specialty  code and description for given facility and nursing unit code with status = 'E'

	//sql="SELECT contact_reason_code code,contact_reason description FROM AM_CONTACT_REASON_LANG_VW  WHERE upper eff_status='E' and  reason_for_referral_yn='Y' and language_id='"+localeName+"'  and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)";
	sql="SELECT contact_reason_code code,contact_reason description FROM am_contact_reason_lang_vw WHERE eff_status='E'  and reason_for_referral_yn='Y'  and language_id ='"+localeName+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)";	


	/*dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "reason_for_referral_yn" ;
	dataValueArray[1]	= "Y";
	dataTypeArray[1]	= STRING;*/

	/*argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= document.forms[0].referral_reason_desc.value;
	argumentArray[6]	= CODE_LINK;
	argumentArray[7]	= CODE_DESC;*/
	argumentArray[0]	= sql;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		argumentArray[5]	= document.forms[0].referral_reason_desc.value;
		argumentArray[6]	= CODE_LINK;
		argumentArray[7]	= CODE_DESC;
	
		retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].referral_reason_desc.value=arr[1];
		document.forms[0].referral_reason_code.value=arr[0];
		//eval(BodyFrame).document.forms[0].ref_reason.disabled=true;
	}
	else
	{
		document.forms[0].referral_reason_desc.value="";
		document.forms[0].referral_reason_code.value="";
	}
}

function getPractitioner22(obj,target)
{
	 if(target.value !='' &&  target != null){
       getPractitioner2(obj,target);
     }else
	{

	}

}

function getPractitioner2(obj,target)
{
/*	if(document.forms[0].referral_type.value== 'X') 
	{
         	var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var retVal ;
			var argumentArray=new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";				
	        var arr1=new Array();	   
			tit="'"+getLabel("Common.external.label",'Common')+" "+getLabel("Common.practitioner.label",'Common')+"'";
			
			sql="select  PRACTITIONER_ID code, PRACTITIONER_NAME Description from am_ext_practitioner_lang_vw  where  eff_status='E' and language_id='"+localeName+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?)  order by 2";
			
			
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );
	
	
         	 var ret1=unescape(retVal);
	
	
	         if (ret1 != "" )
		     {
			 arr1= ret1.split(",");	
             document.forms[0].practitioner.value	=	arr1[0];
			document.forms[0].pract_name.value		=	arr1[1];		
		}
		else
		{
			document.forms[0].practitioner.value	=	"";
			document.forms[0].pract_name.value		=	"";			
			document.forms[0].pract_name.focus();
		}
	}
	else
	{ */


		var practName_FName	= "";
		var practName_FValue= "";
		var practId_FName	= "";
		var locn_code	= document.forms[0].location1.value;
		var locationArray = new Array();

		locationArray = locn_code.split(":::");
		locn_code = locationArray[0];
		practName_FName=target.name;
		practName_FValue=encodeURIComponent(target.value);
		practId_FName=document.forms[0].pract_name.name;

		var ref_to      = document.forms[0].referred_to.value; 

		var locn_type 	= document.forms[0].location0.value;
		var splty_code	= document.forms[0].speciality.value;

		var sql="";
		var sql2="";


		if (locn_code!="")
		{
			if(locn_type == "C" || locn_type == "Y" || locn_type == "E")
			{
				
				//sql = "SELECT facility_id, practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code,am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2)  primary_specialty, gender,a.position_code job_title FROM am_pract_all_splty_vw a WHERE 'Y' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND pract_type LIKE (?) AND  facility_id ='"+ref_to+"' AND specialty_code = '"+splty_code+"' AND primary_speciality_code LIKE UPPER(?) AND ( UPPER(practitioner_id) LIKE UPPER(NVL(?, practitioner_id))  OR UPPER(am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1))) ) AND  DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U')) AND  upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) UNION SELECT facility_id, practitioner_id practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name , am_get_desc.am_practitioner(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender,  position_code job_title FROM am_pract_all_splty_vw WHERE practitioner_id IN ( SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id ='"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E' ) AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND  facility_id ='"+ref_to+"' AND specialty_code = '"+splty_code+"'";/*and ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id))  OR UPPER(am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) )*/
				

				/*

				sql = "SELECT practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code,am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2)  primary_specialty, gender,a.position_code job_title FROM am_pract_all_splty_vw a WHERE 'Y' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND pract_type LIKE (?) AND  facility_id ='"+ref_to+"' AND specialty_code = '"+splty_code+"' AND primary_speciality_code LIKE UPPER(?) AND ( UPPER(practitioner_id) LIKE UPPER(NVL(?, practitioner_id))  OR UPPER(am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1))) ) AND  DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U')) AND  upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) UNION SELECT facility_id, practitioner_id practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name , am_get_desc.am_practitioner(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender,  position_code job_title FROM am_pract_all_splty_vw WHERE practitioner_id IN ( SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id ='"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E' ) AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND  facility_id ='"+ref_to+"' AND specialty_code = '"+splty_code+"'";/*and ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id))  And UPPER(am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) )

				
				
				sql2 = "SELECT  practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender,  a.position_code job_title FROM am_pract_all_splty_vw a WHERE 'Y' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND pract_type LIKE (?) AND  facility_id ='"+ref_to+"' AND SPECIALTY_CODE = '"+splty_code+"' AND primary_speciality_code LIKE UPPER(?) AND ( UPPER(practitioner_id) LIKE UPPER(NVL(?, practitioner_id))  AND UPPER(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1))) ) AND  DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U')) AND  upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) UNION SELECT facility_id, practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.am_practitioner(PRACT_TYPE,'"+localeName+"',2) practitioner_type, specialty_code, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender,  position_code job_title FROM am_pract_all_splty_vw WHERE practitioner_id IN ( SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id ='"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E' ) AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND  facility_id ='"+ref_to+"' AND specialty_code = '"+splty_code+"'";

				*/
				/*Monday, October 18, 2010 , SRR20056-SCF-5664-IN024451 modified to search practitioner name in local language */
				sql = " SELECT  a.facility_id facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, a.specialty_code specialty_code,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2)  primary_specialty, a.gender gender,a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE ((    a.practitioner_id IN(SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E') AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"') )  OR ('Y' = (SELECT open_to_all_pract_yn  FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"') ) )  AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' AND a.pract_type LIKE (?) AND  a.facility_id ='"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND a.primary_speciality_code LIKE UPPER(?) AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id))  OR UPPER(am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND  upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) ";

				
				
				sql2 = "SELECT  a.facility_id facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, a.specialty_code specialty_code,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2)  primary_specialty, a.gender gender,a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE ((    a.practitioner_id IN(SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E') AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"') )  OR ('Y' = (SELECT open_to_all_pract_yn  FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code = '"+locn_code+"') ) )  AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' AND a.pract_type LIKE (?) AND  a.facility_id ='"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND a.primary_speciality_code LIKE UPPER(?) AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id))  AND UPPER(am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1)) LIKE UPPER(NVL(? ,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND  upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) ";
			}
			else if(locn_type == "N")
			{
				/*Monday, October 18, 2010 , SRR20056-SCF-5664-IN024451 am_get_desc.am_practitioner(a.PRACTITIONER_ID) changed to am_get_desc.am_practitioner(e.PRACTITIONER_ID) for search practitioner name in local language */
				sql ="SELECT  a.practitioner_id practitioner_id, am_get_desc.am_practitioner(e.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+locn_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(e.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(e.practitioner_id,'"+localeName+"',1))) ) AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) AND (1 = 1)";

				sql2 ="SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(e.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+locn_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) AND UPPER (am_get_desc.am_practitioner(e.practitioner_id,'"+localeName+"',1)) LIKE UPPER (NVL (?, am_get_desc.am_practitioner(e.practitioner_id,'"+localeName+"',1))) ) AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) AND (1 = 1)";
			}
		}
		else if(locn_code == ""){

			if(document.forms[0].referral_type.value!='X'){
			if(locn_type == "N")
			{
	
				/*Monday, October 18, 2010 , SRR20056-SCF-5664-IN024451 am_practitioner_lang_vw b for search practitioner name in local language */
				sql = "SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1)  practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' and a.specialty_code='"+splty_code+"'AND a.practitioner_id IN (SELECT practitioner_id FROM ip_nursing_unit_for_pract a WHERE facility_id = '"+ref_to+"') AND a.facility_id = '"+ref_to+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND (a.JOB_TITLE LIKE (?) OR a.JOB_TITLE IS NULL)";	
				
				sql2 = "SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, a. gender gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' and a.specialty_code='"+splty_code+"'AND a.practitioner_id IN (SELECT practitioner_id FROM ip_nursing_unit_for_pract a WHERE facility_id = '"+ref_to+"') AND a.facility_id = '"+ref_to+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND (a.JOB_TITLE LIKE (?) OR a.JOB_TITLE IS NULL)";
			}
			else
			{	
				/*sql = "SELECT practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender, a.position_code job_title FROM am_pract_all_splty_vw a WHERE practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id = '"+ref_to+"' AND eff_status = 'E' )  AND facility_id = '"+ref_to+"' AND specialty_code = '"+splty_code+"' AND pract_type LIKE (?)  AND primary_speciality_code LIKE UPPER(?) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))  OR  UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)) ) AND  DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) AND (1 = 1)";
				
				sql2 = "SELECT practitioner_id practitioner_id, am_get_desc.am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, gender, a.position_code job_title FROM am_pract_all_splty_vw a WHERE practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id = '"+ref_to+"' AND eff_status = 'E' )  AND facility_id = '"+ref_to+"' AND specialty_code = '"+splty_code+"' AND pract_type LIKE (?)  AND primary_speciality_code LIKE UPPER(?) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))  AND  UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)) ) AND  DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) AND (1 = 1)";*/

				/*Monday, October 18, 2010 , SRR20056-SCF-5664-IN024451 modified to search practitioner name in local language */
				
				
                if(practName_FName=="frm_pract_name"){ //this condtion Added for this CRF Bru-HIMS-CRF-354
					splty_code = "";
				}else{

				sql = "SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty, a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and a.practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id = '"+ref_to+"' AND eff_status = 'E' )  AND a.facility_id = '"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) AND (1 = 1)";

				sql2 = "SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.PRACTITIONER_ID,'"+localeName+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"',2) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty,a.gender gender, a.position_code job_title FROM am_pract_all_splty_vw a,am_practitioner_lang_vw b WHERE a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and a.practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id = '"+ref_to+"' AND eff_status = 'E' )  AND a.facility_id = '"+ref_to+"' AND a.specialty_code = '"+splty_code+"' AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) AND (1 = 1)";
				
				}

			}

		   }else{
			   	sql	 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_ext_practitioner (a.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type (a.pract_type,'"+localeName+"', 2) practitioner_type,am_get_desc.am_speciality (a.primary_speciality_code, '"+localeName+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_ext_practitioner_lang_vw  a,AM_EXT_PRACT_FOR_REFERRAL b, AM_REFERRAL c  WHERE b.REFERRAL_CODE=c.REFERRAL_CODE and c.REFERRAL_CODE='"+ref_to+"' and b.eff_status='E' AND  a.practitioner_id = b.practitioner_id AND a.language_id = '"+localeName+"'  AND UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type))  AND UPPER (a.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), a.primary_speciality_code)) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id))  OR UPPER (a.practitioner_name) LIKE  UPPER (NVL (?, a.practitioner_name)))  AND  a.gender LIKE   NVL (DECODE (UPPER (?), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U'),a.gender) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) ORDER BY 2";	
              
			    sql2=sql;


		    }
		}

	
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	= "<root><SEARCH " ;
			xmlStr += " practName_FName=\"" +practName_FName + "\"";
			xmlStr += " practName_FValue=\"" +practName_FValue + "\"";
			xmlStr += " sql=\"" +escape(sql)+ "\"";
			xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" +splty_code+ "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";
		
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
	

		//eval(responseText);
		eval(practSearch(practName_FName,practName_FValue,splty_code,responseText));		
	//}
}

async function practSearch(practName_FName,practName_FValue,splty_code,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "95vh" ;
	var dialogWidth	= "60vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"&primary_specialty="+splty_code+"&job_title="+"&gender=",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (objName=="pract_name")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner.value	=	arr[0];
			document.forms[0].pract_name.value		=	arr[1];	
		if(parent.frames[1].document.forms[0].referral_type.value=='X'){
		if(document.forms[0].pract_name.value.value !=''){
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=true;
		parent.frames[1].document.forms[0].from_ext_practitioner_id.value="";
		}else{
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
		parent.frames[1].document.forms[0].from_ext_practitioner_id.value="";
        }
	      }
		}
		else
		{
			document.forms[0].practitioner.value	=	"";
			document.forms[0].pract_name.value		=	"";			
			document.forms[0].pract_name.focus();
		}
	}else if (objName=="frm_pract_name")
	{ /*else if condtion Added for this  CRF Bru-HIMS-CRF-354 [IN:038538] */
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].frm_practitioner.value	=	arr[0];
			document.forms[0].frm_pract_name.value		=	arr[1];	
		
		}
		else
		{
			document.forms[0].frm_practitioner.value	=	"";
			document.forms[0].frm_pract_name.value		=	"";			
			document.forms[0].frm_pract_name.focus();
		}
		/*this else if condtion Added for this  CRF Bru-HIMS-CRF-354 [IN:038538] */
	}
	else
	{
		DisAdvPractLookupRetVal(retVal,objName);
	}
}

function clear_location(obj)
{
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module = document.forms[0].hddModule.value;
	var ref_type = document.forms[0].referral_type.value;
	var ref_locn_code =  document.forms[0].ref_locn_code.value;	
	var FuncID = document.forms[0].hddFuncID.value;  
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value;  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	 
	if(FuncID != 'RegisterInpatientReferral' && FuncID != 'DischargePatient')
	{  
	   /*Below if condition Added for this CRF Bru-HIMS-CRF-261*/
	   if(document.forms[0].quick_admission && !document.forms[0].quick_admission.checked){
		document.forms[0].ref_for_ip.disabled = false; 
		document.forms[0].ref_for_ip.value = '';
			
       }
      //End Bru-HIMS-CRF-261	   
	}
	if(FuncID != 'RegisterInpatientReferral' )
	{   //Below line Added for this SCF MMS-SCF-0087 [IN:042991]
		if ((obj=="N")){  
		     
			if(document.forms[0].quick_admission && !document.forms[0].quick_admission.checked){
				document.getElementById('refID').style.visibility = "Visible";
				document.forms[0].ref_for_ip.disabled=false;
			}else if((document.forms[0].quick_admission == undefined) || (document.forms[0].quick_admission == "undefined")){ 
			    //Added for this SCF ML-MMOH-SCF-0496
				document.getElementById('refID').style.visibility = "Visible";
				document.forms[0].ref_for_ip.disabled=false;
				document.forms[0].ref_for_ip.value = ''; 
			}
		}else { 			
			document.getElementById('refID').style.visibility = "Hidden";
			
		}	
	}
	
	var len1=document.forms[0].practitioner.length;
	var j=1;
	while(j<len1)
	{
		len1=document.forms[0].practitioner.length;
		document.forms[0].practitioner.remove(j);
	}
	var len=document.forms[0].location1.length;
	var i=1;
	while(i<len)
	{
		len=document.forms[0].location1.length
		document.forms[0].location1.remove(i)
	}
	//delete_values(document.getElementById("service")); 
	if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else {
	document.forms[0].service_desc.value="";
	document.forms[0].service.value="";
		}

	var ref_to		=	document.forms[0].referred_to.value; 
	
	var loc_type	=	obj;
	var location1	=	document.forms[0].location1.value;
	var specialty	=	document.forms[0].speciality.value
	var service		=	document.forms[0].service.value;   
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
	if(FuncID=="ModifyReferral" && document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true"){
		loc_type=document.forms[0].ref_locn_type.value; 
		service=document.forms[0].hddref_service_code.value; 
	}
	if(FuncID=="ModifyReferral" && document.forms[0].onloadcount.value>0  && isForAdmissionAppl=="true"){
		ref_locn_code='';
	}
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
	if((loc_type=='C') || (loc_type=='N') || (loc_type == 'Y') || (loc_type == 'E'))
	{

		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateLocation&loc_type="+loc_type+"&ref_type="+ref_type+"&ref_to="+ref_to+"&specialty="+specialty+"&service="+service+"&BodyFrame="+BodyFrame+"&Module="+Module+"&ref_locn_code="+ref_locn_code+"&function_id="+FuncID+"'></form></BODY></HTML>";

		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	}
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 11-08-2023 start*/
	if ((FuncID == "ModifyReferral" || FuncID == "for_admission") && isForAdmissionAppl == "true") {
		if (specialty == "") {
			document.forms[0].speciality_desc.disabled = false;
			document.forms[0].search_speciality.disabled = false;
			document.forms[0].location0.disabled = true;
			document.forms[0].location1.disabled = true;
		} else {
			if (loc_type != "") {
				document.forms[0].location1.disabled = false;
			}else {
				document.forms[0].location1.disabled = true;
				document.forms[0].speciality_desc.disabled = false;
				document.forms[0].search_speciality.disabled = false;
			}
		}
	}
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 11-08-2023 end*/
}

function Clearloc()
{
	  delete_values(document.forms[0].location1);
	  document.forms[0].location0.options(0).selected=true;
}
function populateServices(obj)
{
	
	var ref_type = document.forms[0].referral_type.value;
	var FuncID = document.forms[0].hddFuncID.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 01-08-2023
	/*if(document.forms[0].speciality.value != ""){
		
		document.forms[0].location0.disabled	=	false;                        
		document.forms[0].location1.disabled	=	false;
		
	}
	else
	{

		document.forms[0].location0.disabled	=	true;                        
		document.forms[0].location1.disabled	=	true;
		document.forms[0].location0.value="";
		document.forms[0].location1.value="";
	}*/
	
	if(ref_type =="E" || ref_type =="L")
	{
		
		if(document.forms[0].speciality.value != "")
		{
			
			document.forms[0].pract_butt.disabled=false;
			document.forms[0].pract_name.disabled=false;
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
			if((FuncID=="ModifyReferral" || FuncID == "for_admission") && isForAdmissionAppl=="true"){
			document.forms[0].location0.disabled=false;
			}
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
			
		}
		else
		{

			document.forms[0].pract_butt.disabled=true;
			document.forms[0].pract_name.disabled=true;
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
			if((FuncID=="ModifyReferral" || FuncID == "for_admission") && isForAdmissionAppl=="true"){
			document.forms[0].location0.disabled=true;
			document.forms[0].location1.disabled=true;
			document.forms[0].location0.value="";
			document.forms[0].location1.value="";
			}
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
		}

	}
	else if(ref_type =="X")
	{
	//	document.forms[0].pract_butt.disabled=true;
       /*	document.forms[0].pract_butt.disabled=true;
			document.forms[0].pract_name.disabled=true; */
			document.forms[0].pract_butt.disabled=false;
			document.forms[0].pract_name.disabled=false;
			document.forms[0].pract_name.value="";
			document.forms[0].practitioner.value="";
		    document.forms[0].from_ext_practitioner_id.disabled=false;
            document.forms[0].from_ext_practitioner_id.value="";

			//document.forms[0].pract_name.disabled=false;
		    //document.getElementById('pract_butt').disabled=false;	
		
	}
	// Below if condition  Added for this CRF  Bru-HIMS-CRF-261 
  if(document.forms[0].quick_admission && !document.forms[0].quick_admission.checked){
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(document.forms[0].isImproveReferralProcessAppl.value == "true" && document.forms[0].hddFuncID.value != 'RegisterInpatientReferral'){
			if(document.forms[0].speciality_desc.value == "" && document.forms[0].location0.value == ""){
				document.forms[0].location0.value = "";
				delete_values(document.getElementById('location1'))
				document.forms[0].location2.value = "";
			}
		}else{
			document.forms[0].location0.value = "";
			delete_values(document.getElementById('location1'))
			document.forms[0].location2.value = "";
		}
   }	
   //end CRF  Bru-HIMS-CRF-261	
}

function validatePrefDate(prefDate)
{
		//alert('validatePrefDate');
	if(prefDate.value != "")
	{
		var system_date	= document.forms[0].system_date;

		//if(!doDateCheckAlert(system_date,prefDate))
		if(!isAfterNow(prefDate.value,'DMY',localeName))
		{
			document.forms[0].preferred_date.value="";
			document.forms[0].preferred_date.select();
			var msg= getMessage("CANNOT_LESSER","MP");
			msg = msg.replace("#",getLabel('Common.PreferredDate.label','common'));
			msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
			alert(msg);
		}
	}
}

/*function validatePrefDateTime(prefDate)
{
	if(prefDate.value != "")
	{
	//	var system_date_time	= document.forms[0].system_date_time;
		var system_date_time	= document.forms[0].system_date_time.value;
		var prefDate1= prefDate.value;
		if(localeName!="en")
		{
			system_date_time=convertDate(system_date_time,"DMYHM","th","en")
			prefDate1=convertDate(prefDate1,"DMYHM","th","en")
		}
		if(prefDate.value != '' )
		{
			if(!doDateTimeChk(prefDate1))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME","SM") );
				prefDate.focus();
				prefDate.select();
				return ;
			}
			else
			{
				var frdt = prefDate.value;
				var tdt = document.forms[0].system_date_time.value;
				if(localeName!="en")
				{
					frdt=convertDate(frdt,"DMYHM","th","en")
					tdt=convertDate(tdt,"DMYHM","th","en")
				}
				checkDateTime(frdt,tdt);
			}
		}
	}
}*/

/*function checkDateTime(obj1,obj2)
{	
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")
	var splittime1 = a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 splittime1 = a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	if(Date.parse(to_date) > Date.parse(from_date))
	{
	
		var error = getMessage("CANNOT_LESSER","MP");			 
		error = error.replace("$",getLabel('Common.SystemDate.label','common') );	   
		error = error.replace("#", getLabel("Common.PreferredDate.label","Common"));
		alert(error);

		document.forms[0].preferred_date.focus();
		document.forms[0].preferred_date.select();
		return false;
	}
}*/

function  validate_from_date(obj)
{
	//	alert('validate_from_date');
	if(obj.value.length>0)
		validDateObj(obj,'DMY',localeName);
//		CheckDate(obj);
	if(document.forms[0].hddModule.value == "IP")
	{
		DateValidation(obj);
	}
}

function DateValidation(obj)
{ 
//alert(document.forms[0].curdateWithoutTime.value);
	curdate = document.forms[0].curdateWithoutTime;
	var obj1=obj.value;
	/*if(localeName!="en")
	{
		obj1=convertDate(obj1,"DMY","th","en")
	}*/
	
	//var msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
	var msg =       getMessage("DATE1_LT_DATE2","IP");
	msg	=	msg.replace("$",getLabel("Common.PreferredDate.label","Common"));
	msg	=	msg.replace("#",getLabel("Common.ReferredDate.label","Common"));
//	if(doDateCheckAlert(curdate.value,obj1) == false) 
	if(obj1.length>0)
	{
		if(!isAfterNow(obj1,'DMY',localeName)) 
		{
			//obj.focus();
		//	obj.select();
		
			alert(msg);
		}
	}
}

function getval2(obj)
{
	var hcare_type	= obj;
	var FuncID		= document.forms[0].hddFuncID.value;
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module		= document.forms[0].hddModule.value;
	var ref_type	= document.forms[0].referral_type.value;
	var Transaction_type = document.forms[0].hdd_Transaction_type.value;
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023
	
	location0_array = new Array() ;                    
	//delete_values(document.getElementById('referred_to')) //commented for crf 508 and below 4 lines added
	document.getElementById('lng_name').style.visibility="hidden";
	document.forms[0].referred_to.value="";
	document.forms[0].referral_source.value="";
	document.forms[0].referral_source_lkp_bkup_text.value="";

	
	var FuncID		= document.forms[0].hddFuncID.value;
	if(FuncID != 'DischargePatient')
	{
		delete_values(document.getElementById('location0'))
		delete_values(document.getElementById('location1'))
		document.getElementById('location2').value		= ""
		document.getElementById('practitioner').value		= "";
		document.getElementById('pract_name').value		= "";
	}
	if(ref_type == 'X' || ref_type == 'E' || ref_type == 'L')
	{
		if(ref_type=="X" )
		{
			document.forms[0].location0.disabled	=	true;                        
			document.forms[0].location1.disabled	=	true;
			document.forms[0].location2.disabled	=	false;
			document.forms[0].location2.style='display';
			document.getElementById("locn_type_img").style.visibility	= 'hidden';
			document.forms[0].from_ext_practitioner_id.value="";
		}
		else if(ref_type=="E" || ref_type == "L")
		{

			if(ref_type == "L" && document.forms[0].Bedside != null)
			{
				if(document.forms[0].Bedside.checked == false)
					document.getElementById('locn_type_img').style.visibility	= 'visible';
				else
					document.getElementById('locn_type_img').style.visibility	= 'hidden';
			}
			else
			{
				document.getElementById('locn_type_img').style.visibility	= 'visible';
			}
            document.forms[0].location2.style.display='none';
			document.forms[0].location2.disabled	=	true;
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 start*/
			if((FuncID=="ModifyReferral" || FuncID == "for_admission") && isForAdmissionAppl=="true"){
			} else {
				document.forms[0].location0.disabled	=	false;                       
				document.forms[0].location1.disabled	=	false;
			}
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 end*/
		}
		var loc0=document.forms[0].location0.value;
		//document.forms[0].referred_to.value		=	""; //commented for crf 508 and below 4 lines added

		document.getElementById('lng_name').style.visibility="hidden";
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";

		
		if(FuncID != 'DischargePatient')
		{
			document.forms[0].location0.value		=	"";
			document.forms[0].location1.value		=	"";
			document.forms[0].preferred_date.value	=	"";
			document.forms[0].location2.value		=	"";
			document.forms[0].practitioner.value	=	"";
		}
		
		/*var ref= document.forms[0].referred_to ; // commented block for crf 508. below 4 lines added
		while (ref.options.length >1)
		{
			ref.options.remove(1);
		}*/
		

		document.getElementById('lng_name').style.visibility="hidden";
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";

		
		var referred_to_value		=	document.forms[0].referred_to_value.value;
		var function_id = document.forms[0].hddFuncID.value;
		var ref_locn_type			=	document.forms[0].ref_locn_type.value;
		var ref_locn_code			=	document.forms[0].ref_locn_code.value;
		 
		//Added for this SCF ML-MMOH-SCF-0496
		if(document.forms[0].ref_for_ip){
			  document.forms[0].ref_for_ip.disabled=false;
			  document.forms[0].ref_for_ip.value = ''; 
			  if(document.getElementById('refID'))document.getElementById('refID').style.visibility = "Hidden";
		  }
				
	   //End SCF ML-MMOH-SCF-0496	


		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateReferredTo&ref_type="+ref_type+"&loc0="+loc0+"&hcare_type="+hcare_type+"&BodyFrame="+BodyFrame+"&resetHcare=Y&Module="+Module+"&referred_to_value="+referred_to_value+"&function_id="+function_id+"&ref_locn_code="+ref_locn_code+"&Transaction_type="+Transaction_type+"&ref_locn_type="+ref_locn_type+"'></form></BODY></HTML>";

		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	}

	if (ref_type=="L")
	{
		document.forms[0].hcare_setting_type.value		= "";
		document.forms[0].hcare_setting_type.disabled	= true;
	}
	else 
		document.forms[0].hcare_setting_type.disabled	= false;
}


function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt=document.createElement("Option");
	opt.text="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
	opt.value="";
	field.add(opt);
}

/// Added by Sridhar R on 12 Oct 2004,,,,
/// This function is called from RegisterReferralsServlet.
/// This called only for Discahrge Advice & Discharge Patient IP functions where Discharge Type is External Discahrge..[ED]
/// The user will be able to refer a patient to external facility Only..

function popExternal(obj)
{
	
	while(obj.options.length >2)
	{
		obj.options.remove(1);
	}
	var val=obj.value;
	setTimeout("getval1('"+obj+"','"+val+"')",500);
	//getval1(obj);
}

function getval1(obj,val)
{
	

	document.getElementById('lng_name').style.visibility="hidden";
	var FuncID = document.forms[0].hddFuncID.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 01-08-2023
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module		= document.forms[0].hddModule.value;
	var ref_type	= document.forms[0].referral_type.value;
	var Transaction_type	= document.forms[0].hdd_Transaction_type.value;
	var Option				= document.forms[0].hddOption.value;
	var ref_service_code	= document.forms[0].hddref_service_code.value;
	location0_array = new Array () ;                    
	delete_values(document.getElementById('hcare_setting_type'))

	//delete_values(document.getElementById('referred_to')) // commented for crf 508. below 4 lines added
	document.getElementById('lng_name').style.visibility="hidden";
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		 document.forms[0].referral_source.value=""; 
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";
	}


		
   if(obj.value == 'X' || obj.value =='' || obj.value == 'L' ||obj.value == 'E')
  {	  
	    if(document.getElementById('id4'))
            document.getElementById('id4').style.visibility	= 'Visible';
         if(obj.value != 'X')
		 {
			  document.getElementById('pract_butt').disabled=true;
			  document.forms[0].pract_name.disabled=true;
			  document.forms[0].pract_ext_name.style.display='none';
			  
			if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
			} else{  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
					 document.getElementById('practitioner').value		= "";
					 document.getElementById('pract_name').value		= ""; 
					 document.forms[0].from_ext_practitioner_id.value="";
				}
			 

        }
		else
		{

			document.getElementById('pract_butt').disabled=false;
		    document.forms[0].pract_name.disabled=false;
		    document.forms[0].pract_ext_name.style.display='inline';
			if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
			} else {
		    document.forms[0].from_ext_practitioner_id.value="";
		    document.getElementById('practitioner').value		= "";
		    document.getElementById('pract_name').value		= "";
			}
		}

	}
	if(obj.value == 'X' || obj.value =='')
	{
		//document.getElementById('pract_butt').style.visibility = "hidden";
		//document.getElementById('pract_butt').disabled=true;
		//document.forms[0].pract_name.disabled=true;
		//document.forms[0].pract_name.disabled=false;
		if(document.getElementById('refID'))
			document.getElementById('refID').style.visibility = "hidden";
		document.getElementById('locn_type_img').style.visibility	= 'hidden';
		if(obj.value == 'X' )
			if(document.getElementById('id4'))
				document.getElementById('id4').style.visibility	= 'hidden';
	}
	else
	{		
		if(document.getElementById('id4'))
            document.getElementById('id4').style.visibility	= 'Visible';
		document.getElementById('pract_butt').style.visibility = "Visible";
		if(document.forms[0].Bedside != null)
		{
			if(document.forms[0].Bedside.checked == false)
				document.getElementById('locn_type_img').style.visibility	= 'visible';
			else
				document.getElementById('locn_type_img').style.visibility	= 'hidden';
		}
		else
			document.getElementById('locn_type_img').style.visibility	= 'visible';
	}


	document.forms[0].ref_reason.disabled			= false;
	document.forms[0].referral_reason_desc.disabled = false; 

		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else if(FuncID != 'DischargePatient') {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
				
		delete_values(document.getElementById('location0'))
		delete_values(document.getElementById('location1'))
		document.forms[0].referral_reason_desc.value	= "";
		
		document.getElementById('location2').value		= "";
		document.getElementById('practitioner').value		= "";
		document.getElementById('pract_name').value		= "";

		document.getElementById('speciality').value		= "";
		document.getElementById('service').value			= "";

		document.getElementById('speciality_desc').value		= "";
		document.getElementById('service_desc').value			= "";


		if(FuncID != 'RegisterInpatientReferral')
		{
			document.getElementById('ref_for_ip').value			= "";
		}
	}
	
	if(ref_type == 'X' || ref_type == 'E' || ref_type == 'L' || ref_type=='')
	{
		if(ref_type=="X" || ref_type=='')
		{
			document.forms[0].location0.disabled	=	true;                        
			document.forms[0].location1.disabled	=	true;
			document.forms[0].location2.disabled	=	false;
			document.forms[0].location2.style.display='inline';

		}
		else if(ref_type=="E" || ref_type == "L")
		{
			document.forms[0].location2.style.display='none';
			document.forms[0].location2.disabled	=	true;
			document.forms[0].location0.disabled	=	false;                        
			document.forms[0].location1.disabled	=	false;

			//document.forms[0].location0.disabled	=	true;                        //document.forms[0].location1.disabled	=	true;
		}

		var loc0=document.forms[0].location0.value;
		
		//document.forms[0].referred_to.value		=	""; //commented for crf 508. Below 4 lines added
		document.getElementById('lng_name').style.visibility="hidden";
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else {
		 document.forms[0].referral_source.value=""; 
		 document.forms[0].preferred_date.value	=	"";  
		 document.forms[0].referred_to.value="";
		 document.forms[0].referral_source_lkp_bkup_text.value="";
		 document.forms[0].hcare_setting_type.value = "";
		}
		
		if (FuncID=="ModifyReferral" && document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true"){
				document.forms[0].referral_type.disabled= false;
				document.forms[0].speciality_desc.disabled = false;
				document.forms[0].search_speciality.disabled= false;
				document.forms[0].preferred_date.disabled= false;
				document.forms[0].preferred_date_cal.disabled= false;
				document.forms[0].priority.disabled= false;
				
		}
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
		if((FuncID=="ModifyReferral" || FuncID == "for_admission") && isForAdmissionAppl=="true"){
		if(document.forms[0].speciality.value==""){                       
			document.forms[0].location0.disabled	=	true;	
		}
		if(document.forms[0].location0.value==""){                     
			document.forms[0].location1.disabled	=	true;	
		}
		}
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else if(FuncID != 'DischargePatient') {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		
			document.forms[0].location0.value		=	"";
			document.forms[0].location1.value		=	"";
			document.forms[0].location2.value		=	"";
			document.forms[0].practitioner.value	=	"";
		}

		/*var ref= document.forms[0].referred_to ; // commented block for crf 508. below 4 lines added
		while (ref.options.length >1)
		{
			ref.options.remove(1);
		}
		*/

		document.getElementById('lng_name').style.visibility="hidden";
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else{  
		document.forms[0].referral_source.value=""; 
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";
		}
		
		//Added for this SCF ML-MMOH-SCF-0496
		 if(document.forms[0].ref_for_ip){
				document.forms[0].ref_for_ip.disabled=false;
				if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
					} else {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
				 document.forms[0].ref_for_ip.value = ''; 
				}
				if(document.getElementById('refID'))document.getElementById('refID').style.visibility = "Hidden";
		 }
		
	   //End SCF ML-MMOH-SCF-0496	

		var hcare_type = document.forms[0].hcare_setting_type.value;
		
		var ref_hcare_setting_type	=	 document.forms[0].ref_hcare_setting_type.value;
		var referred_to_value		=	document.forms[0].referred_to_value.value;
		var ref_priority			=	document.forms[0].ref_priority.value;
		var ref_specialty			=	document.forms[0].ref_specialty.value;
		var ref_locn_type			=	document.forms[0].ref_locn_type.value;
		var ref_locn_code			=	document.forms[0].ref_locn_code.value;

		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateHcare&specLoad=1&ref_type="+ref_type+"&loc0="+loc0+"&hcare_type="+hcare_type+"&BodyFrame="+BodyFrame+"&Option="+Option+"&Module="+Module+"&Transaction_type="+Transaction_type+"&function_id="+FuncID+"&ref_hcare_setting_type="+ref_hcare_setting_type+"&referred_to_value="+referred_to_value+"&ref_priority="+ref_priority+"&ref_specialty="+ref_specialty+"&ref_locn_type="+ref_locn_type+"&ref_locn_code="+ref_locn_code+"&ref_service_code="+ref_service_code+"'></form></BODY></HTML>";
		
				
		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.form1.submit();
		
	}

	if (ref_type=="L")
	{
		document.forms[0].hcare_setting_type.disabled = true;
        document.forms[0].referral_source.disabled	= true;
		document.forms[0].referral_source_lkp_but.disabled = true;
	}
	else{
		document.forms[0].hcare_setting_type.disabled = false;
	    document.forms[0].referral_source.disabled	= false;
	    document.forms[0].referral_source_lkp_but.disabled = false;
	}
	//alert("val---->"+val);
	if(val == "X")
           if(document.getElementById('id4'))
				 document.getElementById('id4').style.visibility	= 'hidden';
// Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 23.07.2020
 var isTransferCase= document.forms[0].isTransferCase.value;
 if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else if(isTransferCase=="true"){ //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

     if(ref_type =="X")
{
    	 
    	 document.getElementById('transfer_case_yn').style.display="inline";
    	 document.getElementById('transfer_case').style.display="inline";
		 document.forms[0].transfer_case_yn.checked=false;
		 document.forms[0].transfer_case_yn.value='N';
         
		 
}
	else
{
		
		document.getElementById('transfer_case_yn').style.display="none";
		document.getElementById('transfer_case').style.display="none";
	    document.forms[0].transfer_case_yn.checked=false;
		document.forms[0].transfer_case_yn.value='N';
}     
}
 //Ended by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
		
		
		
}

function enable_referred(checkVal)
{

	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Transaction_type  = document.forms[0].hdd_Transaction_type.value;
	var FuncID = document.forms[0].hddFuncID.value; 
	var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value;  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

	if(FuncID == "RegisterInpatientReferral" || Transaction_type == "DA" || Transaction_type == "DP" || Transaction_type == "CO")
	{
		checkVal.checked = true ;
	}

	if (checkVal.checked==true )
	{
		document.forms[0].referred.value				=	"Y";
		document.forms[0].referral_type.disabled		= false;
		document.forms[0].hcare_setting_type.disabled	= false;
		//document.forms[0].referred_to.disabled			= false; // commented for crf 508 and below 2 lines added
		document.forms[0].referral_source.disabled			= false;
		document.forms[0].referral_source_lkp_but.disabled			= false;
		
		document.forms[0].priority.disabled				= false;
		//document.forms[0].priority.value				= "L"; //this line commented for this Bru-HIMS-CRF-261
		document.forms[0].preferred_date.disabled		= false;
		document.getElementById('preferred_date_cal').disabled		= false;
		document.forms[0].speciality_desc.disabled			= false;
		document.forms[0].service_desc.disabled				= false;
		document.forms[0].search_speciality.disabled			= false;
		document.forms[0].search_service.disabled				= false;
		document.forms[0].location2.disabled			= false;
		 //  document.forms[0].location2.style.display='inline';
		  document.getElementById('location2').style.display='inline';
		if((document.forms[0].referral_type.value == 'E') && (document.forms[0].referral_type.value == 'L'))
		{
			document.forms[0].pract_name.disabled			= false;
			document.forms[0].pract_butt.disabled			= false;
			document.forms[0].location0.disabled			= false;
			document.forms[0].location1.disabled			= false;
		}
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		document.forms[0].referral_reason_desc.value	= ""; 
		document.forms[0].referral_reason_desc.disabled	= false;
		document.forms[0].ref_reason.disabled			= false;		
		}


	
	if(FuncID != 'RegisterInpatientReferral')
	{
		document.forms[0].ref_for_ip.disabled			= false;
		document.getElementById('refID').style.visibility				= 'hidden';
	}
		document.forms[0].ReferralNotesButton.disabled	= false; 
		document.forms[0].ReferralNotes.value			= ''; 
		document.getElementById('id1').style.visibility				= 'visible';
		document.getElementById('id2').style.visibility				= 'visible';
		document.getElementById('id3').style.visibility				= 'visible';
		document.getElementById('id4').style.visibility				= 'visible';
		document.getElementById('id5').style.visibility				= 'visible';


		var FuncID = document.forms[0].hddFuncID.value;
		if(FuncID != 'DischargePatient')
		{
		/*	var service = eval(BodyFrame).document.forms[0].service;
			while(service.options.length > 0)
				service.remove(service.options[1]);

			var serviceOpt	= eval(BodyFrame).document.createElement("OPTION");
			serviceOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
			serviceOpt.value	= "";
			eval(BodyFrame).document.forms[0].service.add(serviceOpt);  */
			document.forms[0].service_desc.value="";
			document.forms[0].service.value="";
		}

		var hcare_setting_type = eval(BodyFrame).document.forms[0].hcare_setting_type;
		while(hcare_setting_type.options.length > 0)
			hcare_setting_type.remove(hcare_setting_type.options[1]);

		var hcare_setting_typeOpt	= eval(BodyFrame).document.createElement("OPTION");
		hcare_setting_typeOpt.text	= "---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		hcare_setting_typeOpt.value	= "";
		eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcare_setting_typeOpt);

		/*var referred_to = eval(BodyFrame).document.forms[0].referred_to;  // block comment for crf 508. bleow 4 lines added
		while(referred_to.options.length > 0)
			referred_to.remove(referred_to.options[1]);

		var referred_toOpt	= eval(BodyFrame).document.createElement("OPTION");
		referred_toOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		referred_toOpt.value	= "";

		eval(BodyFrame).document.forms[0].referred_to.add(referred_toOpt);
		*/

		document.getElementById('lng_name').style.visibility="hidden";
		if(document.forms[0].onloadcount.value<1 && isForAdmissionAppl=="true" ){  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		} else {  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		document.forms[0].referral_source.value="";
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";
		}
		

		
		/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538]*/
	/*if(document.forms[0].frm_practitioner)
	  document.forms[0].frm_practitioner.value="";
	if(document.forms[0].frm_pract_name)
      document.forms[0].frm_pract_name.value="";
	  document.forms[0].frm_pract_name.disabled	= true;
	  document.forms[0].frm_pract_butt.disabled	= true;*/
	 
//End this CRF Bru-HIMS-CRF-354 [IN:038538] 


	}
	else if (checkVal.checked==false)
	{
		document.forms[0].referred.value				=	"N";
		document.forms[0].referral_type.disabled		= true;
		document.forms[0].referral_type.value			= "";
		document.forms[0].hcare_setting_type.disabled	= true;
		document.forms[0].hcare_setting_type.value		= "";
		
		//document.forms[0].referred_to.disabled			= true;  // commented for crf 508. below 2 lines added
		document.forms[0].referral_source.disabled			= true;
		document.forms[0].referral_source_lkp_but.disabled			= true;


		//document.forms[0].referred_to.value				= "";// commented for crf 508. below 2 lines added
		document.getElementById('lng_name').style.visibility="hidden";
		document.forms[0].referred_to.value="";
		document.forms[0].referral_source.value="";
		document.forms[0].referral_source_lkp_bkup_text.value="";

		document.forms[0].priority.disabled				= true;
		document.forms[0].priority.value				= "";
		document.forms[0].preferred_date.disabled		= true;
		document.forms[0].preferred_date.value			= "";
		document.getElementById('preferred_date_cal').disabled		= true;
		document.forms[0].speciality_desc.disabled			= true;
		document.forms[0].search_speciality.disabled			= true;
		document.forms[0].speciality.value				= "";
		document.forms[0].service_desc.disabled				= true;
		document.forms[0].search_service.disabled				= true;
		document.forms[0].service.value					= "";
		document.forms[0].location0.disabled			= true;
		document.forms[0].location1.disabled			= true;
		document.forms[0].location2.disabled			= true;
        document.forms[0].location2.style.display='none';
		document.forms[0].referral_reason_desc.value	= "";
		document.forms[0].referral_reason_desc.disabled	= true;
		document.forms[0].ref_reason.disabled			= true;

		var FuncID = document.forms[0].hddFuncID.value;
		if(FuncID != 'DischargePatient')
		{
			document.forms[0].location0.value				= "";
			document.forms[0].location1.value				= "";
			document.forms[0].location2.value				= "";
		}

		document.forms[0].pract_name.value				= "";
		document.forms[0].pract_butt.disabled			= true;
	
		if(FuncID != 'RegisterInpatientReferral')
		{
			document.forms[0].ref_for_ip.disabled			= true;
			document.forms[0].ref_for_ip.value				= "";
			document.getElementById('refID').style.visibility				= 'hidden';
		}

		document.forms[0].ReferralNotesButton.disabled	= true;
		document.forms[0].ReferralNotes.value			= ''; 
		document.getElementById('id1').style.visibility				= 'hidden';
		document.getElementById('id2').style.visibility				= 'hidden';
		document.getElementById('id3').style.visibility				= 'hidden';
		document.getElementById('id4').style.visibility				= 'hidden';
		document.getElementById('id5').style.visibility				= 'hidden';

	}
}

function beforegetspeciality1(obj,ref_to)
{
	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
	var function_id = document.forms[0].hddFuncID.value;

	if(document.forms[0].speciality_desc.value!="")
	{
		document.getElementById('pract_butt').disabled=false;
		document.forms[0].pract_name.disabled=false;
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
			if(document.forms[0].location1.value == ""){
				getspeciality1(obj,ref_to);
			}
		}else{
			getspeciality1(obj,ref_to);
		}
	}
	else
	{
		document.forms[0].speciality_desc.value="";
        document.forms[0].speciality.value="";
		if(document.forms[0].referral_type.value !='X'){
		document.getElementById('pract_butt').disabled=true;
		document.forms[0].pract_name.disabled=true;  
		}
		if(document.forms[0].referral_type.value =='X'){
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;

		}
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		if(document.forms[0].service)
		document.forms[0].service.value="";
		if(document.forms[0].service_desc)
   		document.forms[0].service_desc.value="";
   		
		if(document.forms[0].Bedcode){
		var len=document.forms[0].Bedcode.length;
	    var i=1;
	    while(i<len)
	    {
		  len=document.forms[0].Bedcode.length
		  document.forms[0].Bedcode.remove(i)
	    }
     }
    if(document.forms[0].bed_type){
    var len1=document.forms[0].bed_type.length;	
	var j=1;
	while(j<len1)
	{
		len1=document.forms[0].bed_type.length
		document.forms[0].bed_type.remove(j)
	 }
  }		
 if(document.forms[0].visit_adm_type){
    var len2=document.forms[0].visit_adm_type.length;	
	var k=1;
	while(k<len2)
	{
		len2=document.forms[0].visit_adm_type.length
		document.forms[0].visit_adm_type.remove(k)
	 }
  }  	
//End this CRF CRF Bru-HIMS-CRF-261		
        document.forms[0].pract_name.value="";
   		document.forms[0].practitioner.value="";
   		document.forms[0].from_ext_practitioner_id.value="";
	}
}
async function getspeciality1(obj,ref_to)
{
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.speciality.label','Common');
		var sql="";
	    
		var referred_to=document.forms[0].referred_to.value;
		

		var referral_type=document.forms[0].referral_type.value;

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
		var function_id = document.forms[0].hddFuncID.value;
		var multi_spec = document.forms[0].multi_spec.value;
		var location_code = document.forms[0].location1.value;
		var facility_id = document.forms[0].referred_to.value;
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	    if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
			if(multi_spec == "Y")
			{
				sql="SELECT speciality_code code, short_desc description FROM am_speciality_lang_vw a, ip_nurs_unit_for_specialty b WHERE a.speciality_code = b.specialty_code AND a.eff_status = 'E' AND b.nursing_unit_code = '"+location_code+"' AND b.facility_id = '"+facility_id+"' AND a.language_id = '"+localeName+"' AND UPPER (a.speciality_code) LIKE UPPER (?) AND UPPER (a.short_desc) LIKE UPPER (?) order by 1";
			}else{
				if(referral_type=='X')
				{
					sql="Select specialty_code code,am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2) description from am_referral_for_specialty_vw where referral_code='"+referred_to+"' and upper(specialty_code) like upper(?) and upper(am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2))  like upper(?)  order by 2";
				}else
				{
					sql="Select SPECIALITY_CODE code,SHORT_DESC description from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+localeName+"'  and upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?)  order by 1";
				}
			}
		}else{
			if(referral_type=='X')
			{
				sql="Select specialty_code code,am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2) description from am_referral_for_specialty_vw where referral_code='"+referred_to+"' and upper(specialty_code) like upper(?) and upper(am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2))  like upper(?)  order by 2";
			}else
			{
				sql="Select SPECIALITY_CODE code,SHORT_DESC description from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+localeName+"'  and upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?)  order by 1";
			}
		}
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].speciality_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == ""))
		{

				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			document.forms[0].speciality_desc.value=arr[1];
			document.forms[0].speciality.value=arr[0];

			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
				if(multi_spec == "Y"){
					document.forms[0].speciality_desc.disabled = true;
					document.forms[0].search_speciality.disabled = true;
				}
			}
			
		    setTimeout("populateServices()",500);		
			
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
				if(multi_spec == "N"){
					if((document.forms[0].quick_admission && document.forms[0].quick_admission.checked) || document.forms[0].location1.value == ""){
					   if(document.forms[0].location0)
					   setTimeout('clear_location(document.forms[0].location0.value)',500);
					}
				}
			}else{
				//Below line Added for this CRF  Bru-HIMS-CRF-261
				if(document.forms[0].quick_admission && document.forms[0].quick_admission.checked){
				   if(document.forms[0].location0)
				   setTimeout('clear_location(document.forms[0].location0.value)',500);
				}
				//End CRF  Bru-HIMS-CRF-261
			}
		
		
			
		}
		else
	{	document.forms[0].speciality_desc.value="";
        document.forms[0].speciality.value=""; 
		
	}

}

async function getspeciality(obj,ref_to)
{
	
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		var isImproveReferralProcessAppl = document.forms[0].isImproveReferralProcessAppl.value;
		var function_id = document.forms[0].hddFuncID.value;
		var multi_spec = document.forms[0].multi_spec.value;
		var location_code = document.forms[0].location1.value;
		var facility_id = document.forms[0].referred_to.value;
	
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.speciality.label','Common');
		var sql="";

		var referred_to=document.forms[0].referred_to.value;
		
		
		var referral_type=document.forms[0].referral_type.value;

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	    if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
			if(multi_spec == "Y")
			{
				sql="SELECT speciality_code code, short_desc description FROM am_speciality_lang_vw a, ip_nurs_unit_for_specialty b WHERE a.speciality_code = b.specialty_code AND a.eff_status = 'E' AND b.nursing_unit_code = '"+location_code+"' AND b.facility_id = '"+facility_id+"' AND a.language_id = '"+localeName+"' AND UPPER (a.speciality_code) LIKE UPPER (?) AND UPPER (a.short_desc) LIKE UPPER (?) order by 1";
			}else{
				if(referral_type=='X')
				{
					sql="Select specialty_code code,am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2) description from am_referral_for_specialty_vw where referral_code='"+referred_to+"' and upper(specialty_code) like upper(?) and upper(am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2))  like upper(?)  order by 2";
				}else
				{
					sql="Select SPECIALITY_CODE code,SHORT_DESC description from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+localeName+"'  and upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?)  order by 1";
				}
			}
		}else{
			if(referral_type=='X')
			{
				sql="Select specialty_code code,am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2) description from am_referral_for_specialty_vw where referral_code='"+referred_to+"' and upper(specialty_code) like upper(?) and upper(am_get_Desc.am_speciality(specialty_code,'"+localeName+"',2))  like upper(?)  order by 2";
			}else
			{
				sql="Select SPECIALITY_CODE code,SHORT_DESC description from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+localeName+"'  and upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?)  order by 1";
			}
		}

	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].speciality_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			document.forms[0].speciality_desc.value=arr[1];
			document.forms[0].speciality.value=arr[0];

			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
				if(multi_spec == "Y"){
					document.forms[0].speciality_desc.disabled = true;
					document.forms[0].search_speciality.disabled = true;
				}
			}
			
			setTimeout("populateServices()",500);
			
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl == "true" && function_id != 'RegisterInpatientReferral'){
				if(multi_spec == "N"){
					if((document.forms[0].quick_admission && document.forms[0].quick_admission.checked) || document.forms[0].location1.value == ""){
					   if(document.forms[0].location0)
					   setTimeout('clear_location(document.forms[0].location0.value)',500);
					}
				}
			}else{
				//Below line Added for this CRF  Bru-HIMS-CRF-261
				if(document.forms[0].quick_admission && document.forms[0].quick_admission.checked){
				   if(document.forms[0].location0)
				   setTimeout('clear_location(document.forms[0].location0.value)',500);
				}
				//End CRF  Bru-HIMS-CRF-261
			}
			
		}
		else
	{	
			document.forms[0].speciality_desc.value="";
        document.forms[0].speciality.value=""; 
		
	}

}



async function getServicelook1(obj,ref_to)
{
	
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.service.label','Common');
		var sql="";
		var FuncID =document.forms[0].hddFuncID.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var sql1="";//Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value;  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var facility_id=document.forms[0].facility_id.value;
		var referral_type=document.forms[0].referral_type.value;

		var referred_to=document.forms[0].referred_to.value; 


		var location_type=document.forms[0].location0.value;
		var location1=document.forms[0].location1.value;
		var speciality_code=document.forms[0].speciality.value;

		   
	    
		if(referral_type=='L' || referral_type=='E')
		{
    /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
			sql1="union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"'";
			if((FuncID=="ModifyReferral" || FuncID=="for_admission") && isForAdmissionAppl=="true"){
				sql1="";
			}
      /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
			if(location_type=='Y')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW  where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' "+sql1+") and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else if(location_type=='C')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else if(location_type=='E')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else if(location_type=='N')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else
			{
			sql="SELECT  Distinct SERVICE_CODE code,am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2) description FROM am_facility_service WHERE EFF_STATUS = 'E' and operating_facility_id = '"+referred_to+"' and upper(SERVICE_CODE) like upper(?) and upper(am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2))  like upper(?) order by 1";
			}
		}else
		{
			if(referred_to=="")	
			{

			sql="SELECT  SERVICE_CODE code,SHORT_DESC description FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by 1";
			}else
			{

			sql="SELECT  SERVICE_CODE code,SHORT_DESC description FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by 1";
			}
					
		}

	
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].service_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			document.forms[0].service_desc.value=arr[1];
			document.forms[0].service.value=arr[0];
			
			
		}
		else
	{	document.forms[0].service_desc.value="";
        document.forms[0].service.value=""; 
		
	}

}

async function getServicelook(obj,ref_to)
{

	
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.service.label','Common');
		var sql="";
		var FuncID =document.forms[0].hddFuncID.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var sql1="";//Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var isForAdmissionAppl = document.forms[0].isForAdmissionAppl.value;  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		var facility_id=document.forms[0].facility_id.value;
		var referral_type=document.forms[0].referral_type.value;

		var referred_to=document.forms[0].referred_to.value; 

		var location_type=document.forms[0].location0.value;
		var location1=document.forms[0].location1.value;
		var speciality_code=document.forms[0].speciality.value;

			    
		if(referral_type=='L' || referral_type=='E')
		{
    /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
			sql1="union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"'";
			if((FuncID=="ModifyReferral" || FuncID=="for_admission") && isForAdmissionAppl=="true"){
				sql1="";
			}
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
			if(location_type=='Y')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW  where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' "+sql1+" ) and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else if(location_type=='C')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";
			}else if(location_type=='E')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else if(location_type=='N')
			{
				sql=" select service_code code, short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+location1+"' and a.facility_id='"+referred_to+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+referred_to+"' and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+location1+"') and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by short_desc ";

			}else
			{
				
				
			sql="SELECT Distinct SERVICE_CODE code,am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2) description FROM am_facility_service WHERE EFF_STATUS = 'E' and operating_facility_id = '"+referred_to+"' and upper(SERVICE_CODE) like upper(?) and upper(am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2))  like upper(?) order by 1";
			}
		}else
		{
			if(referred_to=="")	
			{

			sql="SELECT  SERVICE_CODE code,SHORT_DESC description FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by 1";
			}else
			{
				
				//sql="SELECT  SERVICE_CODE code,am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2) description FROM am_facility_service WHERE EFF_STATUS = 'E' and operating_facility_id = '"+referred_to+"' and upper(SERVICE_CODE) like upper(?) and upper(am_get_desc.am_service(SERVICE_CODE,'"+localeName+"',2))  like upper(?) order by 1";

				sql="SELECT  SERVICE_CODE code,SHORT_DESC description FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+localeName+"' and upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC)  like upper(?) order by 1";

			
			}
					
		}

	
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].service_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			document.forms[0].service_desc.value=arr[1];
			document.forms[0].service.value=arr[0];
			
			
		}
		else
	{	document.forms[0].service_desc.value="";
        document.forms[0].service.value=""; 
		
	}

}

async function referralSourceLookup(obj){
	var retVal			= new String();	
	var srch_by_clmn_index=""; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	var dialogTop			= "240";
	var dialogHeight		= "75vh" ;
	var dialogWidth			= "60vw" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
	var target=obj;
	var FuncID =document.forms[0].hddFuncID.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	var isForAdmissionAppl =document.forms[0].isForAdmissionAppl.value; //Added by lakshmanan for ML-MMOH-CRF-1972 on 01-08-2023
	var title=getLabel("Common.ReferredTo.label","common");	//Title  modified  for PMG2014-CRF-0007 [IN:046756]
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,20%,20%,20%,20%");
	
	
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);	

	var shortDesc=getLabel("Common.shortdescription.label","common");
	shortDesc=encodeURIComponent(shortDesc);
	
	var longDesc=getLabel("Common.longdescription.label","common");
	longDesc=encodeURIComponent(longDesc);

	var longname=getLabel("Common.longname.label","common");
	longname=encodeURIComponent(longname);

	var hlthcrsttyp="Healthcaresettingstype";

	var column_descriptions = code+","+shortDesc+","+longDesc+","+longname+","+hlthcrsttyp;
	
	var message = '';
	var facilityid=parent.frames[1].document.forms[0].facility_id.value;			
	var target=parent.frames[1].document.forms[0].referral_source;
	var ref_type=parent.frames[1].document.forms[0].referral_type.value;
	var hcareType=parent.frames[1].document.forms[0].hcare_setting_type.value;
	var locale=document.forms[0].locale_js.value;
	var Module		= document.forms[0].hddModule.value;
	var Transaction_type = document.forms[0].hdd_Transaction_type.value;

	var sql = '';
	var param='';

	if(ref_type==''){
		var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Referral Type')+ "\n" ;
		alert(error)
		parent.frames[1].document.forms[0].referral_type.focus();
		parent.frames[1].document.forms[0].referral_source.value="";

	}else{
		if(hcareType==''){
			var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Healthcare Setting Type')+ "\n" ;
			alert(error)
			parent.frames[1].document.forms[0].hcare_setting_type.focus();
			parent.frames[1].document.forms[0].referral_source.value="";

		}else{

			if(ref_type=='L'){
				sql="select nvl(a.FACILITY_ID,'') referred_to_id,nvl(a.FACILITY_NAME,'') referred_to_id_desc ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code,nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id=? and b.language_id=? and a.facility_id=? ";
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
				if(FuncID=="ModifyReferral" && isForAdmissionAppl=="true"){
					srch_by_clmn_index="&srch_by_clmn_index=1";
				} else {
					srch_by_clmn_index="&srch_by_clmn_index=3";
				}
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+srch_by_clmn_index+"&col_show_hide=YYNNN";

			}else if(ref_type=='X'){
				sql="Select nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code  from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";



				if(Module=="IP" || Transaction_type=="DA" || Transaction_type=="DP" )	{
	
					sql = "SELECT nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and a.EFF_STATUS = 'E' AND a.DEST_USE_AT_DISCH_YN = 'Y' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";
				}

				if(Module=="OP" || Transaction_type=="CO"){
	
					sql = "SELECT nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and a.EFF_STATUS = 'E' AND a.DEST_USE_AT_CONCL_YN = 'Y' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";

				}
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
					if(FuncID=="ModifyReferral" && isForAdmissionAppl=="true"){
						srch_by_clmn_index="&srch_by_clmn_index=1";
					} else {
						srch_by_clmn_index="&srch_by_clmn_index=3";
					}
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+srch_by_clmn_index+"&col_show_hide=YYYYN";
				// above line modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
			}else if(ref_type=='E'){
				sql="SELECT nvl(a.FACILITY_ID,'') referred_to_id ,nvl(a.FACILITY_NAME,'') referred_to_id_desc   ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code, nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != ?  AND a.hcare_setting_type_code=?   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN  (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code =  a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id=?  AND b.language_id=? "
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
					if(FuncID=="ModifyReferral" && isForAdmissionAppl=="true"){
						srch_by_clmn_index="&srch_by_clmn_index=1";
					} else {
						srch_by_clmn_index="&srch_by_clmn_index=2";
					}
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+srch_by_clmn_index+"&col_show_hide=YYNNN";
				// above line modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
			}	


			retVal= await window.showModalDialog("../../eAM/jsp/ReferralSourceLookupFrames.jsp?calling_from=create&"+param,arguments,features);
			
			if(retVal){
				var ret_array = retVal.split("^~^");
				parent.frames[1].document.forms[0].referred_to.value=ret_array[0];
				if(ref_type=='X'){
					parent.frames[1].document.forms[0].referral_source.value=ret_array[2];
					parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=ret_array[2];
				}else{
					parent.frames[1].document.forms[0].referral_source.value=ret_array[1];
					parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=ret_array[1];
				}

				if(ret_array[3] !='' && ref_type=='X' && ret_array[3] !='-select-'){			
					parent.frames[1].document.getElementById('lng_name').style.visibility="visible";
					parent.frames[1].document.getElementById('lng_name').title=ret_array[3];

				}else{
					parent.frames[1].document.getElementById('lng_name').style.visibility="hidden";
				}

				populate_ext_specialty(parent.frames[1].document.forms[0].referred_to);
			}

			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(parent.frames[1].document.forms[0].hddFuncID.value == 'ModifyReferral' && parent.frames[1].document.forms[0].isForAdmissionAppl.value == "true"){ //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
				
			} else if(parent.frames[1].document.forms[0].isImproveReferralProcessAppl.value=="true" && parent.frames[1].document.forms[0].hddFuncID.value != 'RegisterInpatientReferral'){  
				parent.frames[1].document.forms[0].location0.onchange();
			}
		}
	}
	
}

function clear_ref(){
	
	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	if(parent.frames[1].document.forms[0].isImproveReferralProcessAppl.value == "true" && parent.frames[1].document.forms[0].hddFuncID.value != 'RegisterInpatientReferral'){
		parent.frames[1].document.forms[0].location0.onchange();
	}

	if(parent.frames[1].document.forms[0].referral_source.value==''){
			
		if(parent.frames[1].document.forms[0].referral_type.value == 'X')
		   {
			parent.frames[1].document.getElementById('pract_name').value="";
			parent.frames[1].document.getElementById('practitioner').value="";
		    parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
            parent.frames[1].document.forms[0].from_ext_practitioner_id.value="";
			parent.frames[1].document.forms[0].pract_name.disabled=false;
		    parent.frames[1].document.getElementById('pract_butt').disabled=false;	
         	
          }
		parent.frames[1].document.getElementById('lng_name').style.visibility="hidden";
		parent.frames[1].document.forms[0].referred_to.value="";
		parent.frames[1].document.forms[0].referral_source.value="";
		parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value="";

	}else{
		if(parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value != parent.frames[1].document.forms[0].referral_source.value){
			referralSourceLookup(parent.frames[1].document.forms[0].referral_source_lkp_but)
		}
	}
}

function disable_ext_pract(obj)
{
	if(parent.frames[1].document.forms[0].referral_type.value=='X'){
		if(obj.value !='' )
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=true;
	    else
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
	}
}


function disable_pract(obj)
{
	
	if(parent.frames[1].document.forms[0].referral_type.value=='X'){
		if(obj.value !='' ){
		parent.frames[1].document.forms[0].pract_name.disabled=true;
		parent.frames[1].document.getElementById('pract_butt').disabled=true;	
		}else{
		parent.frames[1].document.forms[0].pract_name.disabled=false;
		parent.frames[1].document.getElementById('pract_butt').disabled=false;	
		}
    
	}
}

/*Below function Added for this CRF Bru-HIMS-CRF-261 */
function populateBedclass(obj)
{  
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module = document.forms[0].hddModule.value;
	var ref_type = document.forms[0].referral_type.value;
	var ref_locn_code =  document.forms[0].ref_locn_code.value;	
	var FuncID = document.forms[0].hddFuncID.value;
	
	var loc_type=document.forms[0].location0.value; 
	 
	
	var len=document.forms[0].Bedcode.length;
	var i=1;
	while(i<len)
	{
		len=document.forms[0].Bedcode.length
		document.forms[0].Bedcode.remove(i)
	}
	//Below line Added for this CRF Bru-HIMS-CRF-261 (after commited the files)
	var len1=document.forms[0].bed_type.length;
	var j=1;
	while(j<len1)
	{
		len1=document.forms[0].bed_type.length
		document.forms[0].bed_type.remove(j)
	}
	
	var len2=document.forms[0].visit_adm_type.length;
	var k=1;
	while(k<len2)
	{
		len2=document.forms[0].visit_adm_type.length
		document.forms[0].visit_adm_type.remove(k)
	}
	//End Bru-HIMS-CRF-261 (after commited the files)
	


	//var ref_to		=	document.forms[0].referred_to.value; 
	
	var loc_code	=	obj; 
	/*var location1	=	document.forms[0].location1.value;
	var specialty	=	document.forms[0].speciality.value
	var service		=	document.forms[0].service.value;  */

	if(document.forms[0].service)
	document.forms[0].service.value="";
    if(document.forms[0].service_desc)
	document.forms[0].service_desc.value="";
	

	if(loc_type=='N')	{
      document.forms[0].Bedcode.disabled=false;
     document.forms[0].bed_type.disabled=false;
	 
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateBedclass&loc_code="+loc_code+"&BodyFrame="+BodyFrame+"&Module="+Module+"&function_id="+FuncID+"'></form></BODY></HTML>";

		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	}else{
	document.forms[0].Bedcode.disabled=true;
    document.forms[0].bed_type.disabled=true;
}
}

function populateBedType(obj)
{  
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;
	var Module = document.forms[0].hddModule.value;
	var ref_type = document.forms[0].referral_type.value;
	var ref_locn_code =  document.forms[0].ref_locn_code.value;	
	var FuncID = document.forms[0].hddFuncID.value;
	
	var loc_code=document.forms[0].location1.value;
	
	 
	
	var len=document.forms[0].bed_type.length;
	
	var i=1;
	while(i<len)
	{
		len=document.forms[0].bed_type.length
		document.forms[0].bed_type.remove(i)
	}
	


	//var ref_to		=	document.forms[0].referred_to.value; 
	
	var bedclasscode	=	obj;

	//var location1	=	document.forms[0].location1.value;
	//var specialty	=	document.forms[0].speciality.value
	//var service		=	document.forms[0].service.value;   

	//if((loc_type=='C') || (loc_type=='N') || (loc_type == 'Y') || (loc_type == 'E'))	{

		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateBedtype&loc_code="+loc_code+"&BodyFrame="+BodyFrame+"&Module="+Module+"&bedclasscode="+bedclasscode+"&function_id="+FuncID+"'></form></BODY></HTML>";

		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
	//}
}
/*Below function modified for this incident [41098]*/
async function view_admitpatient(referral_id,from_encounterid,admission_type)
{  
  if(admission_type=="B"){
   alert(getMessage("ALLOWED_ADMISSION_TYPE",'IP'));
  }else{
   
	var retVal		=    new String();
	var dialogHeight= "400px";	
	var dialogWidth = "700px";
	var dialogTop	= "72";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var getUrl = "../../eIP/jsp/AdmitPatient.jsp?menu_id=IP&module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=NYNNN&quick_admission_type=Y&quick_adm=Quick_admission&quick_adm_referralid="+referral_id+"&ref_encounter_id="+from_encounterid+"";
	retVal = await window.showModalDialog(getUrl,arguments,features);     
	if(retVal != null && retVal != ""){
	var result = retVal.split("*");	 
	if(parent.frames[1].document.forms[0].regOutref && parent.frames[1].document.forms[0].regOutref.value!="" && parent.frames[1].document.forms[0].regOutref.value=="REG_OUT_REF") { 
		QuickApptreloadPage();
		parent.frames[1].location.href	= parent.frames[1].location.href;//Added By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]
	  }else{ 
	  window.close();
	 }
	}else{ 
	
	/*if(parent.frames[1].document.forms[0].regOutref && parent.frames[1].document.forms[0].regOutref.value!="" && parent.frames[1].document.forms[0].regOutref.value=="REG_OUT_REF") {
		//QuickApptreloadPage(); //this line commented for this CRF Bru-HIMS-CRF-261 (after commited the files)
	  }*/
	  	parent.frames[1].location.href	= parent.frames[1].location.href;//Added By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]
	}
	}
}

function QuickApptreloadPage()
{	 
	var encounter_id = parent.frames[1].document.forms[0].from_encounter_id.value;
	var patient_id = parent.frames[1].document.forms[0].patient_id.value; 
	var Transaction_type = parent.frames[1].document.forms[0].Transaction_type.value; 


	parent.frames[2].location.reload();	
	//parent.frames[2].location.href="";
	//parent.frames[2].location.href= "../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id="+encounter_id+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+" ";  
	
	parent.frames[2].location.href= "../eMP/jsp/ReferralDetailsResult.jsp?encounter_id="+encounter_id+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+" ";  
	//parent.frames[2].location.reload();	
}
/*End CRF Bru-HIMS-CRF-261 */

/*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/
async function record_referral_note()
{	var encounter_id ="";
	var episode_type ="";
	
	var method_name ="record_referral_note";
	if(document.forms[0].calling_module.value=='OP'){
	encounter_id = parent.frames[1].document.forms[0].from_encounter_id.value ;}
	else if (document.forms[0].calling_module.value=='IP')
	{encounter_id =parent.frames[1].document.forms[0].encounter_id.value;
	}
	var patient_id = parent.frames[1].document.forms[0].patient_id.value;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH" ;
	xmlStr += " method_name=\"" + method_name + "\""	;
	xmlStr += " encounter_id=\"" +escape(encounter_id)+ "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eIP/jsp/IPintermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var patient_class  = trimString(responseText);
	
	if(patient_class == "IP" || patient_class=="DC")
	episode_type ="I";
	if(patient_class=="OP" ||patient_class=="EM")
    episode_type ="O";

var URL="../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=REFERRAL_LETTER&appl_task_id=REFERRAL_LETTER&title=Record Referral Letter&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&patient_class="+patient_class+"&called_from=REFFERAL_NOTE_FROM_PAS";
var dialogHeight= "1000px" ;
var dialogWidth = "1200px" ;                    
var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
var arguments	= "";
var retVal = await window.showModalDialog(URL,arguments,features);



if(retVal !="" && typeof retVal !="undefined"){ 	

  document.forms[0].temp_field.value="Y";
}
parent.frames[1].document.forms[0].CA_REF_LETTER_NOTES_REC_YN.value=document.forms[0].temp_field.value;
	
} /*Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362*/

/*Below line added for this CRF ML-MMOH-CRF-0566*/
function getReason(obj)
{
    
	var BodyFrame	= document.forms[0].hddBodyFrame.value;
	var SubmitFrame = document.forms[0].hddSubmitFrame.value;	
	var bedside_ref_review_status = document.forms[0].bedside_ref_review_status.value;
   
	if(obj=="X" || obj=="S"){
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/getReferralDetails.jsp?src1=populateReason&BodyFrame="+BodyFrame+"&bedsideReferral="+obj+"'></form></BODY></HTML>";		
		eval(SubmitFrame).document.write(HTMLVal);
		eval(SubmitFrame).document.forms[0].submit();
}else{
 if(eval(BodyFrame).document.getElementById('referral_reg_id') && eval(BodyFrame).document.getElementById('referral_reg_id').style.visibility == "visible"){

		var referral_reg_id = eval(BodyFrame).document.getElementById('referral_reg_id');
		var length1  = referral_reg_id.length; 	    
        for(var i=length1-1; i>=0; i--) { 
				referral_reg_id.remove(i);
		} 	  
      eval(BodyFrame).document.getElementById('referral_reg').style.visibility = "hidden";	
      eval(BodyFrame).document.getElementById('referral_reg_id').style.visibility = "hidden";
      eval(BodyFrame).document.getElementById('ref_reg_id').style.visibility = "hidden";		  
    }
	
  }
	
}

//End ML-MMOH-CRF-566
/*Below line added for this CRF ML-MMOH-CRF-0566 US3*/
async function callCancelRejectRemarks(status,cancelrejectcode) {	
    var dialogHeight	= "9.3" ;
	var dialogWidth		= "30" ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments; 
    var statusCode="";
	if(status=="S"){
		statusCode=getLabel("Common.cancel.label","common")+" "+getLabel("Common.remarks.label","common");
		statusCode=encodeURIComponent(statusCode);	
	}else if(status=="X"){
		statusCode=getLabel("Common.Reject.label","common")+" "+getLabel("Common.remarks.label","common");
		statusCode=encodeURIComponent(statusCode);
	}
    if(status=="S" || status=="X"){
	var retVal =await window.showModalDialog('../../eIP/jsp/CancelRejectRemarks.jsp?cancelrejectcode='+encodeURIComponent(cancelrejectcode)+'&statusCode='+statusCode,arguments,features);
	}
	
}
//End this CRF ML-MMOH-CRF-0566 US3
//Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020
function ChangeState(obj)
{
 if (obj.checked == true)
  {
	  
	  document.forms[0].transfer_case_yn.value='Y';
	  
  }
  else
  {
	   document.forms[0].transfer_case_yn.value='N';
	   
  }
} 
//Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020

/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
function autoPopulateSpecialty(clinic_code)
{
	var location_code = clinic_code;
	var location_type = document.forms[0].location0.value;
	var facility_id = document.forms[0].referred_to.value;
	var language_id = localeName;
	
	if(location_code != ""){
		if(location_type=='C' || location_type=='E' || location_type=='Y'){
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH location_code=\""+location_code+"\" location_type=\""+location_type+"\" facility_id=\""+facility_id+"\" language_id=\""+language_id+"\" action='getSpecDescforLoc'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var returnVal = trimString(responseText);
			var arr = returnVal.split("#");
			var specialty_desc = arr[0];
			var specialty_code = arr[1];

			document.forms[0].speciality_desc.value = specialty_desc;
			document.forms[0].speciality.value = specialty_code;
			if (specialty_desc!="")
			document.forms[0].speciality_desc.disabled = true;
			if (specialty_code!="")
			document.forms[0].search_speciality.disabled = true;
			beforegetspeciality1(document.forms[0].speciality_desc,document.forms[0].referred_to);
			populateServices(document.forms[0].speciality_desc);
		}else{
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH location_code=\""+location_code+"\" facility_id=\""+facility_id+"\" language_id=\""+language_id+"\" action='getSpecDescforLocNurUnit'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var returnVal = trimString(responseText);
			var arr = returnVal.split("#");
			var noOfRecords		= arr[0];
			var specialty_desc	= arr[1];
			var specialty_code	= arr[2];

			if(noOfRecords == "1"){
				document.forms[0].multi_spec.value = "N";
				document.forms[0].speciality_desc.value = specialty_desc;
				document.forms[0].speciality.value = specialty_code;
				document.forms[0].speciality_desc.disabled = true;
				document.forms[0].search_speciality.disabled = true;
				beforegetspeciality1(document.forms[0].speciality_desc,document.forms[0].referred_to);
				populateServices(document.forms[0].speciality_desc);
			}else{
				if(document.forms[0].speciality_desc.value == ""){
					document.forms[0].multi_spec.value = "Y";
					document.forms[0].speciality_desc.value = "";
					document.forms[0].speciality.value = "";
					document.forms[0].speciality_desc.disabled = false;
					document.forms[0].search_speciality.disabled = false;
					beforegetspeciality1(document.forms[0].speciality_desc,document.forms[0].referred_to);
					populateServices(document.forms[0].speciality_desc);
				}else{
					document.forms[0].speciality_desc.disabled = true;
					document.forms[0].search_speciality.disabled = true;
				}
			}
		}
	}else{
		document.forms[0].multi_spec.value = "N";
		document.forms[0].speciality_desc.value = "";
		document.forms[0].speciality.value = "";
		document.forms[0].speciality_desc.disabled = false;
		document.forms[0].search_speciality.disabled = false;
		beforegetspeciality1(document.forms[0].speciality_desc,document.forms[0].referred_to);
		populateServices(document.forms[0].speciality_desc);
	}
}

function clearSpecVal()
{
	if(document.forms[0].speciality_desc.disabled == true){
		document.forms[0].speciality_desc.value = "";
		document.forms[0].speciality.value = "";
		document.forms[0].speciality_desc.disabled = false;
		document.forms[0].search_speciality.disabled = false;
		beforegetspeciality1(document.forms[0].speciality_desc,document.forms[0].referred_to);
		populateServices(document.forms[0].speciality_desc);
	}
}
/*End MMS-DM-CRF-0187*/

