function callGroupLocation(GroupId,apptdate,fromtime,totime){  
	 $.ajax({  
      url:'../../eOA/jsp/GetGroupLocation.jsp',  
      type:'post',  
      data:{'GroupId':GroupId,'apptdate':apptdate,'fromtime':fromtime,'totime':totime,action:'get_booking_count'},
      dataType: 'json',
      success: function(data) {  
     	 if(data.isJsonResults==1){
     		 if(parseInt(data.MIN_PATIENTS) >= parseInt(data.BOOKING_COUNT)){
     			 alert(getMessage("APP_LESS_MINPAT_GRP","OA"));
     		 }
     		FnProceedConfirmBooking();
     	 }
      } ,
      error: function(jqXHR, textStatus, errorThrown) {
          alert("incoming Text " + jqXHR.responseText);
      }
  });  
}


function Apply(Obj){
	var a="insert";
	var b="modify";
	var c=Obj.value;
	var group_id	= document.apptdetails_form.group_id.value;
	var apptdate	= parent.f_apptdetails.apptdetails_form.dateapd.value;
	var fromtime	= parent.f_apptdetails.apptdetails_form.new_from_time.value;
	var totime		= parent.f_apptdetails.apptdetails_form.new_to_time.value;
	if(c == "Confirm Cancellation"){
		parent.f_apptdetails.apptdetails_form.function1.value=a;		
		if(group_id!=""){
			callGroupLocation(group_id,apptdate,fromtime,totime);
			return false;
		}
	}else{
		parent.f_apptdetails.apptdetails_form.function1.value=a;
	}
	FnProceedConfirmBooking();
}
function FnProceedConfirmBooking(){
	document.apptdetails_form.confcancel.disabled=true;
	//Bru-HIMS-CRF 169 changes start
	if(document.apptdetails_form.reason_for_cancellation){
		if (document.apptdetails_form.reason_for_cancellation.value == document.apptdetails_form.pat_cancel_reason.value){
			document.apptdetails_form.pat_cncl_count.value=parseInt(document.forms[0].pat_cncl_count.value)+1; //Increment the pat_cncl_count when reason for cancellation is same as that of oa param
		}
	}
	//Bru-HIMS-CRF 169 changes end
	parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
	parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
	parent.f_apptdetails.apptdetails_form.submit();
}

async function allocationDetails(clinicCode,clinicDate,practID){
	var dialogTop = "60" ;
	var dialogHeight= "20" ;
	var dialogWidth	= "40" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal=await window.showModalDialog("../../eOA/jsp/ClinicAllocationDetails.jsp?clinic_code="+clinicCode+"&clinic_date="+clinicDate+"&practitioner_id="+practID,arguments,features);	
}

function checkFields1( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {
			fields[i].value = trimString1(fields[i].value);
		}
		//else	errors = errors + "APP-OA0001 " + names[i] + " cannot be blank..." + "\n" ;
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$',names[i]);
				errors = errors + err + "\n";
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function trimCheck1(inString) {
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

function trimString1(inString) {
	var outString;
	var startPos;
	var endPos;
	var ch;

	// where do we start?
	startPos = 0;
	ch = inString.charAt(startPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		startPos++;
		ch = inString.charAt(startPos);
	}

	// where do we end?
	endPos = inString.length - 1;
	ch = inString.charAt(endPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		endPos--;
		ch = inString.charAt(endPos);
	}

	// get the string
	outString = inString.substring(startPos, endPos + 1);

	return outString;
}

 	async function show_window()
	{
		var patid=document.forms[0].patientid.value;
				var retVal = 	new String();
				var dialogHeight= "11.3" ;
				var dialogWidth	= "25" ;
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=no; status:" + status; 
				retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentContact.jsp?mode=1&patient_id="+patid+"&contactvals="+escape(document.forms[0].contactvals.value)+"",arguments,features);
		}

	async function show_Reference_details(appt_no2,fac_id2)
{
var dialogHeight= "23" ;
var dialogWidth	= "54" ;
var dialogTop = "190" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
await window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

	function abortwin()
	{
	var v="abort";
	//parent.window.returnValue=v;
	//parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = v;   
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close();
	}
	function checkBoxValue(cBox){
	if (cBox.checked == true){
		cBox.value = "Y";
	document.apptdetails_form.confcancel.disabled=false;
	}
	 else{
	document.apptdetails_form.confcancel.disabled=true;
		cBox.value = "N";
	 }
}

	function valcheck1(Obj)
    {
	var email_appl_yn=document.apptdetails_form.email_appl_yn.value;
	var email_appl_for_appt_wo_pid_yn=document.apptdetails_form.email_appl_for_appt_wo_pid_yn.value;
	var emailid=document.apptdetails_form.emailid.value;
	var pat_email_appl_yn=document.apptdetails_form.pat_email_appl_yn.value;
	var rd_appt_yn=document.apptdetails_form.rd_appt_yn.value;
	var clinic_type = document.forms[0].clinic_type.value;
	var episode_type="";
	var calling_module_id="";

		if(clinic_type =="D")
		{
			episode_type="I";
			calling_module_id="DC";
		}else
		{
			episode_type="O";
			calling_module_id="OP";
		}

		document.forms[0].episode_type.value = episode_type;


	 document.forms[0].confcancel.disabled=true;
	 var flag1 =false;
	  var flag2 =false;
	  var flag3=true;
	 var referral_id=document.forms[0].referral_id.value;
		
		if(document.forms[0].flag.value !="Appointment" && parent.f_apptdetails.document.apptdetails_form.reason_for_cancellation.value=="")
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel("Common.ReasonforCancellation.label","Common"));
			alert(error);
			parent.f_apptdetails.document.apptdetails_form.reason_code_cancel.focus();
			document.forms[0].confcancel.disabled=false;
			flag1=false;
		}
		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		else if(document.forms[0].flag.value != "Appointment" && parent.f_apptdetails.document.apptdetails_form.remarks_img.style.visibility == 'visible' && parent.f_apptdetails.document.apptdetails_form.other_remarks.value == "")
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel("Common.remarks.label","Common"));
			alert(error);
			parent.f_apptdetails.document.apptdetails_form.other_remarks.focus();
			document.forms[0].confcancel.disabled=false;
			flag1=false;
		}else{
		flag1=true
		}
		if(flag1==true)
		{
			if(document.forms[0].order_id.value !="" && rd_appt_yn=="N")
			{
				var error=getMessage("CANNOT_CANCEL_ORDER","OA");
				alert(error);
				document.forms[0].confcancel.disabled=false;
					flag3=false;
			}else
			{
				flag3=true;
			}
		}
	if(referral_id !="" && flag1==true )
	{
			if(window.confirm(getMessage('APPT_BKD_REFERAL','OA')))
			{
				document.forms[0].referral_value.value="O";
				flag2=true;
			}else
			{
				document.forms[0].referral_value.value="C";
				flag2=true;
			}
		
			if(flag1==true && flag2==true && flag3==true){
				document.apptdetails_form.confcancel.disabled=true;
				if(document.apptdetails_form.patientid.value!=""){
					if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
						if(emailid!=""){
							document.apptdetails_form.send_email_yn.value="Y";
							Apply(Obj);
						}else{
							if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
								document.apptdetails_form.send_email_yn.value="N";
								Apply(Obj);
							}else{
								document.apptdetails_form.send_email_yn.value="N";
							}
						}
					}else{
						document.apptdetails_form.send_email_yn.value="N";
						Apply(Obj);
					}
				}else{
					if(email_appl_for_appt_wo_pid_yn=="Y"){
						if(emailid!=""){
							document.apptdetails_form.send_email_yn.value="Y";
							Apply(Obj);
						}else{
							if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
									document.apptdetails_form.send_email_yn.value="N";
									Apply(Obj);
								}else{
									document.apptdetails_form.send_email_yn.value="N";
								}
						}
					}else{
						document.apptdetails_form.send_email_yn.value="N";
						Apply(Obj);
					}
				}
				//Apply(Obj);
			} 
	}else{
		if(flag1==true && flag3==true){
			document.apptdetails_form.confcancel.disabled=true;
				if(document.apptdetails_form.patientid.value!=""){
					if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
						if(emailid!=""){
							document.apptdetails_form.send_email_yn.value="Y";
							Apply(Obj);
						}else{
							if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
								document.apptdetails_form.send_email_yn.value="N";
								Apply(Obj);
							}else{
								document.apptdetails_form.send_email_yn.value="N";
							}
						}
					}else{
						document.apptdetails_form.send_email_yn.value="N";
						Apply(Obj);
					}
				}else{
					if(email_appl_for_appt_wo_pid_yn=="Y"){
						if(emailid!=""){
							document.apptdetails_form.send_email_yn.value="Y";
							Apply(Obj);
						}else{
							if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
									document.apptdetails_form.send_email_yn.value="N";
									Apply(Obj);
								}else{
									document.apptdetails_form.send_email_yn.value="N";
								}
						}
					}else{
						document.apptdetails_form.send_email_yn.value="N";
						Apply(Obj);
					}
				}
				//Apply(Obj);
			} 
	}
		//document.forms[0].confcancel.disabled=false;
	}
	
	
	function sh_focus() 
	{
        var flag= document.getElementById("flag").value;
		var call_function_ip= document.forms[0].call_function_ip.value;
		var apptstatus=document.forms[0].apptstatus.value;
		// Tuesday, March 30, 2010 20369 Venkat s
		if(document.forms[0].wtListControl.value!='B'){
			document.forms[0].reason_code_cancel.value='';
			document.forms[0].reason_for_cancellation.value='';
		}

		if  (flag == "cancel_appt")
		{
		document.getElementById("allbuttons").style.visibility="hidden";
		document.getElementById("revisetxt").style.visibility="visible";
		document.getElementById("cancelbuttons").style.visibility="visible";
		checkPatCnclReason();//Bru - HIMS-CRF 169 changes - alert on load of the cancel appointment page
		}
		else  
		{
			if(document.forms[0].wtListControl.value!='B'){
				document.getElementById("allbuttons").style.visibility="visible";
				document.getElementById("revisetxt").style.visibility="hidden";
				document.getElementById("cancelbuttons").style.visibility="hidden";
			}
		}
	
		if(call_function_ip == "admit")
		{
			document.getElementById("allbuttons").style.visibility="hidden";
			document.getElementById("ip_button").style.visibility="visible";
		}
		if(apptstatus == "A")
		{
			document.getElementById("allbuttons").style.visibility="hidden";
			
			document.getElementById("reg_button").style.visibility="visible";
			
		}
	
	}

	function sh_layer() {
		
		document.getElementById("allbuttons").style.visibility="hidden";
		document.getElementById("revisetxt").style.visibility="visible";
		document.getElementById("cancelbuttons").style.visibility="visible";
		document.getElementById("cancel_flag").value = "C";
		checkPatCnclReason();
	}
	/*
		RUT-CRF-0005 by Sudhakar
		function sh_layer1(oper) has been changed
	*/
	async function sh_layer1(oper) {	
			var res_type=document.forms[0].res_type.value;
			var clinic_type=document.forms[0].clinic_type.value;		
			var rd_appt_yn=document.forms[0].rd_appt_yn.value;		

	var h="hjjh";
	document.getElementById("cancel_flag").value = "R";
	if(oper=='close'){ 	
	parent.window.returnValue=parent.f_apptdetails.document.apptdetails_form.appt_ref_no.value+"|"+h+"|"+parent.f_apptdetails.document.apptdetails_form.clinic_code.value+"|"+parent.f_apptdetails.document.apptdetails_form.practitioner_id.value+"|"+parent.f_apptdetails.document.apptdetails_form.new_from_time.value+"|"+parent.f_apptdetails.document.apptdetails_form.new_to_time.value+"|"+parent.f_apptdetails.document.apptdetails_form.pre_pat_alcn_catg_code.value;
	parent.window.close();
	}
	else if(oper=='trans'){
			var flag=true;
			//var customer_id = parent.f_apptdetails.document.apptdetails_form.customer_id.value;
			var rule_appl_yn= parent.f_apptdetails.document.apptdetails_form.rule_appl_yn.value;
			var res_type = parent.f_apptdetails.document.apptdetails_form.res_type.value;
			if(rule_appl_yn =='Y' && res_type=='P'/*&& (appt_category == '1' || appt_category == '3')*/){			
				if(window.confirm(getMessage("RESH_APPT_PRACT_UNKNOWN","OA"))){
					flag=false;	
					//ruleBasedTransfer(practitioner_name,clinic_name,tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,speciality_code,speciality_desc);
					var retVal = 	new String();
					var dialogHeight = "100vh" ;
					var dialogWidth  = "100vw" ;
					var dialogTop    = "60";	
					var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; scrolling:no; status=no";
					var arguments    = "" ;	
					//var url	= 	"../../eOA/jsp/RuleBasedTransferFrame.jsp?speciality_desc="+speciality_desc+"&speciality_code="+speciality_code+"&practitioner_name="+practitioner_name+"&clinic_name="+clinic_name+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&apptrefno="+apptrefno+"&cliniccode1="+cliniccode1+"&practitionerid="+practitionerid+"&apptdate="+apptdate+"&overbookedyn="+overbookedyn+"&apptslabfromtime="+apptslabfromtime+"&apptslabtotime="+apptslabtotime+"&appt_day1="+appt_day1+"&visit_type_ind="+visit_type_ind+"&team_id="+team_id+"&forced="+forced+"&rsClass="+rsClass+"&locnType="+locnType;
					var url	= 	"../../eOA/jsp/RuleBasedTransferFrame.jsp?apptrefno="+parent.f_apptdetails.document.apptdetails_form.appt_ref_no.value;					
					retVal 	 	 = await window.showModalDialog(url,arguments,features);
					window.close();
					parent.window.returnValue='closed';
					parent.window.close();
				}else{
					flag=true;				
				}
			}
			if(flag){			
					var retVal = 	new String();
					var dialogHeight= "95vh" ;
					var dialogWidth	= "80vw" ;
					var dialogTop = "82" ;
					var dialogRight   = "345px";
					var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogRight:" +dialogRight+ "; dialogTop:" +dialogTop+ "; status=no" ;
					var arguments    = "" ;		
				var obook_appt_yn = document.forms[0].obook_appt_yn.value;// value is y
				var Forced=document.forms[0].Forced.value;

				
				var url="../../eOA/jsp/TransferAppointmentFrame.jsp?tfr_appt_across_catg_yn="+parent.f_apptdetails.document.apptdetails_form.tfr_appt_across_catg_yn.value+"&i_from_time="+parent.f_apptdetails.document.apptdetails_form.new_from_time.value+"&i_to_time="+parent.f_apptdetails.document.apptdetails_form.new_to_time.value+"&i_appt_ref_no="+parent.f_apptdetails.document.apptdetails_form.appt_ref_no.value+"&i_clinic_code="+parent.f_apptdetails.document.apptdetails_form.clinic_code.value+"&i_practitioner_id="+parent.f_apptdetails.document.apptdetails_form.practitioner_id.value+"&i_team_id="+parent.f_apptdetails.document.apptdetails_form.team_id.value+"&new_appt_date="+document.forms[0].appt_date.value+"&i_appt_date="+document.forms[0].appt_date.value+"&alcn_criteria="+document.forms[0].alcn_criteria.value+"&over_booked="+document.forms[0].overbooked_yn.value+"&obook_appt_yn="+document.forms[0].obook_appt_yn.value+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&rd_appt_yn="+rd_appt_yn
				retVal 	 	 = await top.window.showModalDialog(url,arguments,features);

					if(retVal == 'closed'){
						parent.window.returnValue='closed';
						parent.window.close();
					}
			}
	 }
	}
	function exitwin() {
					
			var u="close";
			parent.window.returnValue=u;
			parent.window.close();
			
		}


function exitwin1() {
					var u="closed";
					parent.window.returnValue=u;
					parent.window.close();
							
		}

function exitwin_normal() {
					var u="close";
					parent.window.returnValue=u;
					parent.window.close();
								
	}





async function past_visits_view(){ 
				var patient_id=parent.document.frames[0].document.forms[0].patientid.value;
				var service_code=parent.document.frames[0].document.forms[0].service_code.value;

				var retVal = 	new String();
				var dialogHeight= "28" ;
				var dialogTop = "100" ;
				var dialogWidth	= "60" ;
				var status = "no";
				var scroll = "no";
				if(patient_id!=''){
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var callurl="../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id;

				retVal = await window.showModalDialog(callurl,arguments,features);
				}
			}

function valcheck(){//function calling when confirm revision for Transfer Appointment

	var clinic_type = document.forms[0].clinic_type.value;
	
	var episode_type="";
	var calling_module_id="";
	if(clinic_type =="D"){

		episode_type="I";
		calling_module_id="DC";
	}else{
	
		episode_type="O";
		calling_module_id="OP";
	}
	document.forms[0].episode_type.value = episode_type;
	
	if(document.forms[0].sec_resources.value!="")
	{	
		spl_sec(); 
		var sec_req=(document.forms[0].sec_resources.value).indexOf("Y");
		if(sec_req!=-1 && document.forms[0].sec_sel222.value==""){
			alert(getMessage("SEC_RES_NT_SEL","OA"));
		}else{
			valcheck_revise();
		}
	}else
	{

		valcheck_revise();
	}
}

function spl_sec(){
	var sec_sel=document.forms[0].sec_sel.value;
	var secc_sel=sec_sel;
	var tmp_str="";
	var flg="F";
	var s_arr=secc_sel.split("||");
	if(s_arr.length > 1 ){
		sec_sel='';
		for(var i=0;i<s_arr.length;i++){
			var tm0=s_arr[i];
			var s_arr1=tm0.split("#");
			var tm1=s_arr1[0];
			var tm2=s_arr1[1];
			if(tm2=='*')
				tm2='';
			sec_sel=sec_sel+tm2;
		}
	}
	if(sec_sel !=''){
		var sec_arr=sec_sel.split("@");
		var sec_arr33=sec_sel.split("@");
		for(var i=0;i<sec_arr.length;i++){
			var sec_arr1=sec_arr[i].split(",");
			if(sec_arr1.length==10){
				flg="T";
				if(sec_arr1[9]=='Y'){
					tmp_str=tmp_str+sec_arr33[i].substring(0,sec_arr33[i].length-2)+"@";
				}
			}
		}
		if(flg=="T")
			document.forms[0].sec_sel222.value=tmp_str;
	}else{
		document.forms[0].sec_sel222.value='';
	}
}



function vall(){
	if(document.forms[0].reason_for_cancellation.value=="") {
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.ReasonforRevision.label","Common"));
		alert(error);
		document.forms[0].reason_for_cancellation.focus();
	}else if (document.forms[0].From_timeval){
		if(document.forms[0].From_timeval.value=="") {
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel("Common.appttime.label","Common")+getLabel("Common.from.label","Common"));
			alert(error);
			document.forms[0].From_timeval.focus();
		}else if(document.forms[0].To_timeval.value=="") {
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel("Common.appttime.label","Common")+getLabel("Common.to.label","Common"));
			alert(error);
			document.forms[0].To_timeval.focus();
		}else{
			document.forms[0].confrev.disabled=true;
			document.forms[0].submit();			
		}
	}else{		
		document.forms[0].confrev.disabled=true;
		document.forms[0].function1.value='modify';

		document.forms[0].submit();			
	}
}

async function Modal_Contact_Details(obj){
		
		var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
		var patient_id = document.forms[0].patientid.value;//Added by Ajay Hatwate for ML-MMOH-SCF-2610 TF
		var appttypecode = document.forms[0].appttypecode.value;//Added by Ajay Hatwate for ML-MMOH-SCF-2610 TF
		var retVal =    new String();
		

		var dialogHeight= "800px" ;
		var dialogWidth = "900px" ;
		/*Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true")
			dialogWidth = "900px" ;
		/*End*/
		var status = "no";
		
		concat_address_hidden=document.forms[0].concat_address_hidden.value;
		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		retVal = await window.showModalDialog("../../eMP/jsp/ContactDetailsFrame.jsp?readonly_yn=Y&patient_id="+patient_id+"&visit_type_code="+appttypecode+"&",arguments,features);	

		
		
	
}

	
async function show_window_oth(){
				var retVal = 	new String();
				var dialogHeight= "15" ;
				var dialogWidth	= "50" ;
				var status = "no";
				var dialogTop = "253" ;
				var patid	= document.forms[0].patientid.value;
				var ref_no = document.forms[0].appt_ref_no.value;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status+"; dialogTop :" + dialogTop ;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentOther.jsp?patient_id="+patid+"&appt_ref_no="+ref_no,arguments,features);
}

/*function CheckTime(obj,valt) {
	if (obj.value!="")		{
	       	var timefield = obj;
	       	var val1;
	       	if (chkTime(obj.value) == false) {
				alert(getMessage("INVALID_TIME_FMT","SM"));
	       		timefield.select();
	       		timefield.focus();
	       		return false;
	       	}
	       	else {
				if(valt=="FM") {
					val1=valt;
				}
				else if(valt=="TO") {
					val1=valt;
			}
		timevalidation(val1,obj);
				return true;
	       	      }
	}
	}*/
function CheckTime(obj,valt) 
{
	
	var timefield = obj;

	if (obj.value!="")		{
	       	var timefield = obj;
	       	var val1;
	       	if (chkTime(obj.value) == false) {
				alert(getMessage("INVALID_TIME_FMT","SM"));
	       		timefield.select();
	       		timefield.focus();
	       		return false;
	       	}

	}
}
function formatTimePerPatient(obj)
{
	if (obj.value.length == 2)
	{
		if (obj.value.substring(1,2) == ':')
		{
			obj.value = '0' + obj.value ;
		}
	}
	if (obj.value.length == 3)
	{
		if (obj.value.substring(0,1) == ':')
		{
			obj.value = '00' + obj.value ;
		}
	}

}



      function timevalidation(val,obj)
      {
		  var fromtimeh=document.forms[0].new_from_time.value;
		  var fromtime=document.forms[0].From_timeval.value;
		  var totime=document.forms[0].To_timeval.value;
		  var totimeh=document.forms[0].new_to_time.value;
		  var timefield = obj;
		  var sys=document.forms[0].ServerDate.value;
		  var apptdt=document.forms[0].appt_date.value;
		  var syst=document.forms[0].ServerTime.value;
  		    fromtimeharray=fromtimeh.split(":");
			totimeharray=totimeh.split(":");
			fromtimearray=fromtime.split(":");
			totimearray=totime.split(":");
			sysarray=sys.split("/");
			apptarray=apptdt.split("/");
			systarray=syst.split(":");

			var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
			var tohtm=new Date(1,1,1,totimeharray[0],totimeharray[1],0,0);
			var fromtm=new Date(1,1,1,fromtimearray[0],fromtimearray[1],0,0);
			var totm=new Date(1,1,1,totimearray[0],totimearray[1],0,0);
			var systm=new Date(1,1,1,systarray[0],systarray[1],0,0);
			var sysdt = new Date(sysarray[2],sysarray[1],sysarray[0]);
			var aptdt = new Date(apptarray[2],apptarray[1],apptarray[0]);


			if(val=="FM")
		  	{
		  	if(( Date.parse(fromtm) < Date.parse(fromhtm) ) )
					{
					timefield.select();
	       			timefield.focus();
					var err_fromtm1 =getMessage("APPT_OVERLAP","OA") ;
					alert(err_fromtm1);
					}
					
			if(Date.parse(fromtm) > Date.parse(totm))
					{
					timefield.select();
	       			timefield.focus();
					var err_gr =getMessage("FM_TIME_GR_TO_TIME","Common") ;
					alert(err_gr);
					}
			}
			
		else if(val=="TO")
		  {
					if(( Date.parse(tohtm) < Date.parse(totm) ))
					{
						timefield.select();
						timefield.focus();
						var err_fromtm1 =getMessage("TO_TM_NOT_VALID","OA") ;
						alert(err_fromtm1);
					}
					
					if(Date.parse(totm) <= Date.parse(fromtm)) 
					{
						timefield.select();
	       					timefield.focus();
						var err_gr1 =getMessage("TO_TIME_LESS_FM_TIME","Common") ;
						alert(err_gr1);
					}
				

		}
}
function clear_from_sess(){

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='CLEAR_SEC_FROM_SESSION'/></root>"
				
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

async function show_second(){
	var fromTime	= document.getElementById("new_from_time").value;
	var toTime		= document.getElementById("new_to_time").value;
	var facility_id =  document.forms[0].facilityid.value;
	var u			= document.forms[0].visitshortdesc.value;
	var clinic_code	= document.getElementById("clinic_code").value;
	var clinic_date	= document.getElementById("appt_date").value;
	var practitioner_id	= document.getElementById("practitioner_id").value;
	var visittypecode= document.getElementById("appttypecode").value;
	var pat_id=document.getElementById("patientid").value
	var time_table_type=document.forms[0].i_time_table_type.value
	var clinic_name_sec=document.forms[0].clinic_name_sec.value;
	var care_locn_desc_sec=document.forms[0].care_locn_desc_sec.value;
	var res_pri_class_desc=document.forms[0].res_pri_class_desc.value;
	var pract_name_pri=document.forms[0].pract_name_pri.value;
	var ServerTime =document.forms[0].ServerTime.value;
	var ServerDate =document.forms[0].sys_date.value;
	
	var dialogHeight= "29" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var no_of_slots=document.getElementById("no_of_slots").value	

	var sec_req=document.forms[0].sec_resources.value	
	var res_class=document.getElementById("res_type").value	
	var clinic_type=document.getElementById("clinic_type").value


	var sec_resorces='';
	var sec_resorces1='';
	var sec_resorces_req='';
	var secArr=sec_req.split("-");
	for(i=0;i<secArr.length;i++){
		
		var sec_req1=secArr[i];

		var sec_req2=sec_req1.split("*");

		sec_resorces=sec_resorces+"'"+sec_req2[0]+"',";
		sec_resorces1=sec_resorces1+sec_req2[0]+",";
		sec_resorces_req=sec_resorces_req+sec_req2[1]+",";
	}
sec_resorces=sec_resorces.substring(0,sec_resorces.length -1);
sec_resorces_req=sec_resorces_req.substring(0,sec_resorces_req.length -1);


	var sel_secondary=document.getElementById("sec_sel").value

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()

					
	xmlStr ="<root><SEARCH sel_sec = \""+sel_secondary+"\" sec_req=\""+sec_resorces+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" facility_id=\""+facility_id+"\" time_table_type=\""+time_table_type+"\"  steps='ADD_SEC_TO_SESSION'/></root>"


	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
var sec_res_value=document.forms[0].sec_value_count.value;
	if(sec_res_value!=='')	
	{

		
callurl="../../eOA/jsp/SecResMain.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerTime="+escape(ServerTime)+"&ServerDate="+escape(ServerDate);
	
	var retVal = new String();
	var retVal1 = new String();
	retVal = await window.showModalDialog(callurl,arguments,features);

 
	if(retVal==null){
	 retVal='';
	}
	document.getElementById("sec_sel").value=retVal;
	
	}else
	{
		alert(getMessage("NO_SEC_SCHEDULES_AVLBL","OA"));
	}

}


/*Script functions for LinkSecondarydetails.jsp*/

async function show_second1()
{
	var fromTime	= document.getElementById("new_from_time").value;
	var toTime		= document.getElementById("new_to_time").value;
	var clinic_code	= document.getElementById("clinic_code").value;
	var clinic_date	= document.getElementById("appt_date").value;
	var practitioner_id	= document.getElementById("practitioner_id").value;
	var visittypecode= document.getElementById("appttypecode").value;
	var pat_id=document.getElementById("patientid").value
	var time_table_type=document.getElementById("i_time_table_type").value;
	var facility_id =  document.forms[0].facilityid.value;
	var u = document.forms[0].visitshortdesc.value;
	var clinic_name_sec=document.forms[0].clinic_name_sec.value;
	var care_locn_desc_sec=document.forms[0].clinic_name_sec.value;
	var res_pri_class_desc=document.forms[0].res_pri_class_desc.value;
	var pract_name_pri=document.forms[0].pract_name_pri.value;
	var ServerDate =document.forms[0].ServerDate.value;
	var ServerTime =document.forms[0].ServerTime.value;
	
	var dialogHeight= "29" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var no_of_slots=document.getElementById("no_of_slots").value	

	var sec_req=document.getElementById("sec_resources").value	
	var res_class=document.getElementById("res_type").value	
	var clinic_type=document.getElementById("clinic_type").value


	var sec_resorces='';
	var sec_resorces1='';
	var sec_resorces_req='';
	var secArr=sec_req.split("-");
	for(i=0;i<secArr.length;i++)
	{
		
		var sec_req1=secArr[i];
		var sec_req2=sec_req1.split("*");
		sec_resorces=sec_resorces+"'"+sec_req2[0]+"',";
		sec_resorces1=sec_resorces1+sec_req2[0]+",";
		sec_resorces_req=sec_resorces_req+sec_req2[1]+",";
	}
	sec_resorces=sec_resorces.substring(0,sec_resorces.length -1);
	sec_resorces_req=sec_resorces_req.substring(0,sec_resorces_req.length -1);

	var sel_secondary=document.getElementById("sec_sel").value

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()

					
	xmlStr ="<root><SEARCH sel_sec = \""+sel_secondary+"\" sec_req=\""+sec_resorces+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" facility_id=\""+facility_id+"\" time_table_type=\""+time_table_type+"\" steps='ADD_SEC_TO_SESSION'/></root>"

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	var sec_res_value=document.forms[0].sec_value_count.value;
	
	if(sec_res_value!='')
	{
		callurl="../../eOA/jsp/SecResMain.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerDate="+escape(ServerDate)+"&ServerTime="+escape(ServerTime);
		//alert(callurl);
			var retVal = new String();
			var retVal1 = new String();
			retVal = await window.showModalDialog(callurl,arguments,features);
		
		 if (retVal==null) retVal='';
			document.getElementById("sec_sel").value=retVal;
	
	 }else
	 {
		alert(getMessage("NO_SEC_SCHEDULES_AVLBL","OA"));
	 }
}
function spl_sec1()
{
	var sec_sel=document.forms[0].sec_sel.value;
	var secc_sel=sec_sel;
	var tmp_str="";
	var flg="F";
	var s_arr=secc_sel.split("||");
	if(s_arr.length > 1 )
	{
			sec_sel='';

			for(var i=0;i<s_arr.length;i++)
			{
				var tm0=s_arr[i];
				var s_arr1=tm0.split("#");
				var tm1=s_arr1[0];
				var tm2=s_arr1[1];
				if(tm2=='*')
				tm2='';
				sec_sel=sec_sel+tm2;
			}

	}

	if(sec_sel !='')
	{
		var sec_arr=sec_sel.split("@");
		var sec_arr33=sec_sel.split("@");

		for(var i=0;i<sec_arr.length;i++)
		{
			var sec_arr1=sec_arr[i].split(",");
			if(sec_arr1.length==10)
			{
				flg="T";
				if(sec_arr1[9]=='Y')
				{
					tmp_str=tmp_str+sec_arr33[i].substring(0,sec_arr33[i].length-2)+"@";
				}
			}

		}
		if(flg=="T")
		{
			document.forms[0].sec_sel222.value=tmp_str;
		}
		}else{
			document.forms[0].sec_sel222.value='';
		}

}
function valcheck2()
{	

	if(document.forms[0].sec_resources.value!="")
	{
		
		spl_sec1(); 
		var sec_req=(document.forms[0].sec_resources.value).indexOf("Y");
		
		if(sec_req!=-1 && document.forms[0].sec_sel222.value=="")
		{
			alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
		}else if(sec_req ==-1 && document.forms[0].sec_sel222.value==""){
			alert(getMessage("NO_CHANGE_TO_SAVE","Common"));	
		}else if(sec_req ==-1 && document.forms[0].sec_sel222.value!="")
		{
			
			document.forms[0].submit();	
		}else
		{
			document.forms[0].submit();		

		}
	}else{
		
		document.forms[0].submit();		
	}
}
// Monday, March 29, 2010 20371
function reasonlookup_revise_blur(obj){
	if(obj.value!=""){
		reasonlookup_revise();
	}else{
		document.forms[0].reason_for_revision.value="";
		document.forms[0].reason_code_revision.value="";
	}
}


async function reasonlookup_revise()
{

		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		//var sql = "SELECT CONTACT_REASON_CODE code, CONTACT_REASON description FROM AM_CONTACT_REASON WHERE	 TRANSFER_APPOINTMENT_YN = 'Y' and EFF_STATUS = 'E' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";
		
		var sql = "Select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON_LANG_VW where TRANSFER_APPOINTMENT_YN = 'Y' and Eff_Status = 'E' and exclude_yn != 'Y' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
	
		argumentArray[5] = document.forms[0].reason_for_revision.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			
			document.forms[0].reason_for_revision.value=desc;
			document.forms[0].reason_code_revision.value=code;
			
		}else
		{
			

		document.forms[0].reason_for_revision.value="";
			document.forms[0].reason_code_revision.value="";
	
		}
}
// Monday, March 29, 2010 20371
function reasonlookup_blur(obj){
	if(obj.value!=""){
		reasonlookup();
	}else{
		document.forms[0].reason_code_cancel.value="";
		document.forms[0].reason_for_cancellation.value="";
	}
}
async function reasonlookup()
{
		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		//var sql = "SELECT CONTACT_REASON_CODE code, CONTACT_REASON description FROM AM_CONTACT_REASON WHERE	 CANCEL_APPOINTMENT_YN = 'Y' and EFF_STATUS = 'E' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";
	
		var sql="Select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON_LANG_VW where cancel_Appointment_Yn = 'Y' and Eff_Status = 'E' and exclude_yn != 'Y' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		
		argumentArray[5] = document.forms[0].reason_code_cancel.value;
	
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC ; 
		retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
		
			document.forms[0].reason_code_cancel.value=desc;
			document.forms[0].reason_for_cancellation.value=code;
		
		}else
		{
			
			document.forms[0].reason_for_cancellation.value="";
			document.forms[0].reason_code_cancel.value="";
	
		}
}

function freeFormateCheck()
{


    var i_time_table_type=document.forms[0].i_time_table_type.value;
	
    var fromtime=document.forms[0].From_timeval.value;
    var totime=document.forms[0].To_timeval.value;
    var clinic_start_time=document.forms[0].starttime.value;
	var clinic_end_time=document.forms[0].endtime.value;
	var clinic_code=document.apptdetails_form.clinic_code.value
	//var clinic_date=document.apptdetails_form.apptdate.value
	var facilityid=document.apptdetails_form.facilityid.value
	var pract_id=document.apptdetails_form.practitioner_id.value;
	var clinic_date=document.apptdetails_form.i_appt_date_display.value;
	var appt_ref_no=document.apptdetails_form.appointment_ref.value;
	var to_over_book_yn=document.apptdetails_form.to_over_book_yn.value;
	var patientid=document.apptdetails_form.patientid.value;
	var clinic_type=document.apptdetails_form.clinic_type.value;	
	var old_date=document.forms[0].old_date.value;
	

 
	if(totime <= fromtime && to_over_book_yn == 'N')  // fromtime=11:00 totime=10:00
	{
		
	var error=getMessage("TO_TIME_GRT_FROM_TIME","OA");
	error=error.replace("$",getLabel('Common.totime.label','common_labels'));
	error=error.replace("#",getLabel('Common.fromtime.label','common_labels'));
    alert(error);
	} 
	
	else{
	
	//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" );
	//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" );
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH facilityid = \""+facilityid+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" pract_id=\""+pract_id+"\" from_time=\""+fromtime+"\" to_time=\""+totime+"\" appt_ref_no=\""+appt_ref_no+"\" patientid=\""+patientid+"\" clinic_type=\""+clinic_type+"\" steps='free_formate_check'";
	xmlStr +=" /></root>" ;
   //alert("xmlStr==="+xmlStr);
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;

	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
	responseText=eval(responseText);
	
//Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301]
   var old_from_time=document.forms[0].apptslabfmtime.value; 
    var old_to_time=document.forms[0].apptslabtotime.value;
 
	//Below code was added by Venkatesh S on 21.06.2011 for SRR20056-SCF-7292 [IN:027301]
	var curren_app_inter=parseInt(old_from_time);
	 var tran_sch_inter=parseInt(old_to_time);
	 

//Code ends	
	



if(responseText=='1'){
		
		var error=getMessage("OVERLAP_WITH_BRK_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	//eval(responseText);
	if(responseText=='2'){
		
		var error=getMessage("OVERLAP_WITH_BRK_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	

	if(responseText=='3'){
		
		var error=getMessage("APPT_WITH_OVERLAP","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	if(responseText=='4'){
		
		var error=getMessage("APPT_WITH_OVERLAP","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='5'){
		
          var error=getMessage("APPT_OVERLAP","OA");
		alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	if(responseText=='6'){
		
		var error=getMessage("BREAK_TIME_OVERLAPS","OA");
		alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='7'){
		
		var error=getMessage("OVERLAP_WITH_START_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='8'){
		
		var error=getMessage("OVERLAP_WITH_END_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='9'){
		
		var error=getMessage("OVERLAP_WITH_START_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='10'){
		
		var error=getMessage("OVERLAP_WITH_END_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='11'){
			var error=getMessage("APPT_OVERLAP_NOT_PROCEED","OA");		
			alert(error);		
			return false;
	}
	if(responseText=='0')
	{
		//alert("Success");
		//parent.frames[2].document.forms[0].Insupd.disabled=false;
		
		/*Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301]
	 This condition used to transfer maximum time interval appoinment to  minimum avail schedule in free_format.
	 for example may 4th has one appoinment time is 10:00 to 11:00,this appoinment is tranfered to may 6th that total schedule time is 10:00 to 10:30, only in this situation this condition will work in fine.*/
		
		if(curren_app_inter>tran_sch_inter) 	//Below code was added by Venkatesh S on 21.06.2011 for SRR20056-SCF-7292 [IN:027301]
		{
	
		  if(confirm(getMessage("AVAIL_SCHDL_LESS_TRNFR_APPT_TIME","OA"))){		
		    return true;
		  }else{
			return false;
		 }	
		} //(end)
	return true;
	}	
	
		
}

}


function valcheck_revise(){
	var email_appl_yn=document.apptdetails_form.email_appl_yn.value;
	
	var email_appl_for_appt_wo_pid_yn=document.apptdetails_form.email_appl_for_appt_wo_pid_yn.value;
	var emailid=document.apptdetails_form.emailid.value;
	var pat_email_appl_yn=document.apptdetails_form.pat_email_appl_yn.value;
		
		if(document.forms[0].i_time_table_type.value=="3"){
			
		var retFlag=freeFormateCheck(); //here "retFlag" value is false 

		if(!retFlag)
		{
			
			return;
		}
		}
	if(document.forms[0].pract_override_reason && document.forms[0].pract_override_reason.value==""){
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("eOA.ReasonForOverride.label","OA"));
		alert(error);
	}else if(document.forms[0].reason_for_revision.value==""){ 
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.ReasonforRevision.label","Common"));
		alert(error);
	document.forms[0].reason_for_revision.focus();
	}else if(document.forms[0].rd_oa_integration_yn.value=="Y" &&  document.forms[0].rd_appt_yn.value=="Y" && document.forms[0].orderCatMapped.value=="N"){ 		
		alert(getLabel("eOA.CATLOG_NOT_LINKED.label","OA"));		
	}
	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	else if(document.forms[0].rev_remarks_img.style.visibility == 'visible' && document.forms[0].rev_other_remarks.value == "")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.ReasonforRevision.label","Common")+" "+getLabel("Common.remarks.label","Common"));
		alert(error);
	}
	else if(document.forms[0].ovr_remarks_img.style.visibility == 'visible' && document.forms[0].ovr_other_remarks.value == "")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("eOA.ReasonForOverride.label","OA")+" "+getLabel("Common.remarks.label","Common"));
		alert(error);
	}
	/*End ML-MMOH-CRF-1114*/
	else{
		var count_wait_list=parent.f_apptdetails.apptdetails_form.count_wait_list.value;
		var to_clinic_alcn=parent.f_apptdetails.apptdetails_form.to_clinic_alcn.value;
		var alcnflag=true;
		
		if(to_clinic_alcn=='NG'){
			var clinic_code=parent.f_apptdetails.apptdetails_form.clinic_code.value;
			var countrycode=parent.f_apptdetails.apptdetails_form.countrycode.value;
			var appt_date=parent.f_apptdetails.apptdetails_form.appt_date.value;
			var practitioner_id=parent.f_apptdetails.apptdetails_form.practitioner_id.value;
			var slot_appt_ctrl=parent.f_apptdetails.apptdetails_form.slot_appt_ctrl.value;
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH alcn_criteria=\""+to_clinic_alcn+"\" slot_appt_ctrl=\""+slot_appt_ctrl+"\" clinic_code = \""+clinic_code+"\" countrycode=\""+countrycode+"\"  clinic_date=\""+appt_date+"\" practitioner_id=\""+practitioner_id+"\" steps='ALCN_VALIDATION'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			var transfer_alcn_yn=parent.f_apptdetails.apptdetails_form.transfer_alcn_yn.value;
			if(transfer_alcn_yn=='Y'){
				if(count_wait_list >0){
				alert(getMessage("WAIT_LIST_PREFERENCE_DATE","OA"));		
				parent.f_apptdetails.apptdetails_form.function1.value="modify";
				//parent.f_apptdetails.apptdetails_form.submit();
				//adding for email changes 
					if(document.apptdetails_form.patientid.value!=""){
						if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
									document.apptdetails_form.send_email_yn.value="N";
									parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
									parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
									parent.f_apptdetails.apptdetails_form.submit();
								}else{
									document.apptdetails_form.send_email_yn.value="N";
								}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							parent.f_apptdetails.apptdetails_form.submit();
						}
					}else{
						if(email_appl_for_appt_wo_pid_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
										document.apptdetails_form.send_email_yn.value="N";
										parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
										parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
										parent.f_apptdetails.apptdetails_form.submit();
									}else{
										document.apptdetails_form.send_email_yn.value="N";
									}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							parent.f_apptdetails.apptdetails_form.submit();
						}
					}//end adding for email changes
			}else{
				parent.f_apptdetails.apptdetails_form.function1.value="modify";
				//adding for email changes
					if(document.apptdetails_form.patientid.value!=""){
						if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
									document.apptdetails_form.send_email_yn.value="N";
									parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								    parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
									parent.f_apptdetails.apptdetails_form.submit();
								}else{
									document.apptdetails_form.send_email_yn.value="N";
								}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							parent.f_apptdetails.apptdetails_form.submit();
						}
					}else{
						if(email_appl_for_appt_wo_pid_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
										document.apptdetails_form.send_email_yn.value="N";
										parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
										parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
										parent.f_apptdetails.apptdetails_form.submit();
									}else{
										document.apptdetails_form.send_email_yn.value="N";
									}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							parent.f_apptdetails.apptdetails_form.submit();
						}
					}//end of adding for email changes
				}
			}
		}else{ 
			if(count_wait_list >0){
			
				alert(getMessage("WAIT_LIST_PREFERENCE_DATE","OA"));
				parent.f_apptdetails.apptdetails_form.function1.value="modify";
				//parent.f_apptdetails.apptdetails_form.submit();
				//adding for email changes 
					if(document.apptdetails_form.patientid.value!=""){
						if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
									document.apptdetails_form.send_email_yn.value="N";
									parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
									parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
									parent.f_apptdetails.apptdetails_form.submit();
								}else{
									document.apptdetails_form.send_email_yn.value="N";
								}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							 parent.f_apptdetails.apptdetails_form.submit();
						}
					}else{
						if(email_appl_for_appt_wo_pid_yn=="Y"){
							if(emailid!=""){
								document.apptdetails_form.send_email_yn.value="Y";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								 parent.f_apptdetails.apptdetails_form.submit();
							}else{
								if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
										document.apptdetails_form.send_email_yn.value="N";
										parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
										parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
										parent.f_apptdetails.apptdetails_form.submit();
									}else{
										document.apptdetails_form.send_email_yn.value="N";
									}
							}
						}else{
							document.apptdetails_form.send_email_yn.value="N";
							parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
							parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
							parent.f_apptdetails.apptdetails_form.submit();
						}
					}//end adding for email chnages

			}else{
				var overBookFlag;
				if(document.apptdetails_form.overbooked_yn.value=='Y'){					
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr ="<root><SEARCH  clinic_code = '"+document.apptdetails_form.clinic_code.value+"' appt_date='"+document.apptdetails_form.appt_date.value+"' practitioner_id='"+document.apptdetails_form.practitioner_id.value+"' appt_ref_no='"+document.apptdetails_form.appointment_ref.value+"' time_table_type_from='"+document.apptdetails_form.i_time_table_type.value+"' steps='overbook_validation'/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","ServerSide.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)
					overBookFlag=responseText;
				}				
				if(overBookFlag==1){
					alert(getMessage("MAX_FIRST_VISITS_REACHED_TRANS","OA"));
					return;
				}if(overBookFlag==2){
					alert(getMessage("MAX_OTHER_VISITS_REACHED_TRANS","OA"));
					return;
				}if(overBookFlag==2){
					alert('Max Visits reached cannot proceed')
					return;
				}else{
					parent.f_apptdetails.apptdetails_form.function1.value="modify";
					//adding for email changes
						if(document.apptdetails_form.patientid.value!=""){
							if(email_appl_yn=="Y" && pat_email_appl_yn=="Y"){
								if(emailid!=""){
									document.apptdetails_form.send_email_yn.value="Y";
										parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
										parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
									 parent.f_apptdetails.apptdetails_form.submit();
								}else{
									if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
										document.apptdetails_form.send_email_yn.value="N";
										parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
										parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
										parent.f_apptdetails.apptdetails_form.submit();
									}else{
										document.apptdetails_form.send_email_yn.value="N";
									}
								}
							}else{
								document.apptdetails_form.send_email_yn.value="N";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}
						}else{
							if(email_appl_for_appt_wo_pid_yn=="Y"){
								if(emailid!=""){
									document.apptdetails_form.send_email_yn.value="Y";
									parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
									parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
									parent.f_apptdetails.apptdetails_form.submit();
								}else{
									if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
											document.apptdetails_form.send_email_yn.value="N";
											parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
											parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
											parent.f_apptdetails.apptdetails_form.submit();
										}else{
											document.apptdetails_form.send_email_yn.value="N";
										}
								}
							}else{
								document.apptdetails_form.send_email_yn.value="N";
								parent.f_apptdetails.apptdetails_form.action='../../servlet/eOA.AppointmentDetailsServlet';
								parent.f_apptdetails.apptdetails_form.target = 'messageFrame';
								parent.f_apptdetails.apptdetails_form.submit();
							}
						}//end of adding for email changes
				}
			}
		}
	}
}

	function onsuccess()
	{
		
		var group_id="";
		var is_spltyWaitListCheck	= true;
		if(parent.frames[0].document.forms[0].group_id!=null){
			group_id	= parent.frames[0].document.forms[0].group_id.value;
			if(group_id!=null && group_id!=""){
				is_spltyWaitListCheck	= false;
			}
		}
		var error = getMessage("APPT_CANCELLED","OA" );
		alert(error);
		if(is_spltyWaitListCheck){
			/*added for bru-173 by Sudhakar starts*/
			var waitListFlag;				
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH  speciality_code= '"+document.apptdetails_form.speciality_code.value+"' steps='spltyWaitListCheck'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			waitListFlag=responseText;
			/*added for bru-173 by Sudhakar Ends*/
		}
		window.returnValue='closed';
		window.close();
	}
	
async function openWaitList(){
	var dialogHeight = "45" ;
	var dialogWidth	= "80" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var no_of_slots =document.apptdetails_form.no_of_slots.value;
	if(no_of_slots == 0)
		no_of_slots =1;
	
	var url = "../../eOA/jsp/OAWaitListWrapper.jsp?clinnic_code="+document.apptdetails_form.frm_clinic_code.value+"&wtListControl=B&practitioner_id="+document.apptdetails_form.frm_pract_id.value+"&appt_date="+document.apptdetails_form.dateapd.value+"&no_of_slots="+no_of_slots+"&res_type="+document.apptdetails_form.res_type.value+"&clinic_type="+document.apptdetails_form.clinic_type.value+"&rd_appt_yn="+document.apptdetails_form.rd_appt_yn.value+"&clinic_name_sec="+document.apptdetails_form.clinic_name_sec.value;
	
	var retVal=await window.showModalDialog(url,arguments,features);		
}
	
	function closeWindow(){
	}

	function onsuccess1()
	{
		
		var error = getMessage("APPT_REVISED","OA" );
		alert(error);
		/*added for bru-173 by Sudhakar starts*/
		var waitListFlag;				
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH  speciality_code= '"+document.apptdetails_form.speciality_code.value+"' steps='spltyWaitListCheck'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		waitListFlag=responseText;
		/*added for bru-173 by Sudhakar Ends*/
		//window.returnValue='closed';
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = 'closed';   
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();		
	}
	async function audittrial(apptrefno1,date,loc,res){
		       
                var retVal = 	new String();
				var dialogHeight= "70vh" ;
				var dialogWidth	= "90vw" ;
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=auto; status:" + status; 
         //retVal =window.showModalDialog("../../eOA/jsp/ViewAuditTrial.jsp?apptrefno1="+apptrefno1+"&date="+date+"&loc="+loc+"&res="+res,arguments,features);
         retVal =await window.showModalDialog("../../eOA/jsp/ViewAuditTrialFrame.jsp?apptrefno1="+apptrefno1+"&date="+date+"&loc="+loc+"&res="+res,arguments,features);
	}

async function PatInsModalWindow(from_clinic,to_clinic){
	var clinicInsYN=document.apptdetails_form.clinicInsYN.value;
	var orderInsYN=document.apptdetails_form.orderInsYN.value;
	var clinic_code=document.apptdetails_form.clinic_code.value;
	var appt_ref_no=document.apptdetails_form.appt_ref_no.value;
	var features    = "dialogHeight:70vh; dialogWidth:80vw; scroll=no; status:no";
	var arguments = '';	
	document.forms[0].patInsSelectYN.value="Y";
	document.forms[0].procInsSelectYN.value="Y";
	var rd_appt_yn=document.apptdetails_form.rd_appt_yn.value;
	var url="../../eOA/jsp/OAPatientInstructionsMain.jsp?from_page=transfer_appt&clinic_code="+clinic_code+"&clinicInsYN="+clinicInsYN+"&orderInsYN="+orderInsYN+"&appt_refno="+appt_ref_no+"&rd_appt_yn="+rd_appt_yn; //PMG20089-CRF-0885.3
	var retVal = await window.showModalDialog(url,arguments,features);
}

async function show_patinstructions(appt_no2){

	var dialogHeight = "75vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;;
	var rd_appt_yn=document.apptdetails_form.rd_appt_yn.value;
	await window.showModalDialog("../../eOA/jsp/OAPatientInstructionsMain.jsp?appt_refno="+appt_no2+"&from_page=view_dtls&rd_appt_yn="+rd_appt_yn,arguments,features);//PMG20089-CRF-0885.3
}
function clearSession(){
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='CLEAR_ALL_FROM_SESSION'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

/*RUT-CRF-0005 changes starts*/
function reasonForOverride(obj,target,locale){
	if(target.value == ""){
		document.forms[0].pract_override_reason.value ="";
		return;
	}
	reasonForOverrideLookup(obj,target,locale)
}

async function reasonForOverrideLookup(Obj,pract_override_reason_desc,locale){

	var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(PRACT_OVERRIDE_REASON_YN,'N') = 'Y' and eff_status='E' 	and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
	//var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(over_riding_reason,'N') = 'Y' and eff_status='E' 	and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
	var tit				= getLabel("Common.ContactReason.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = pract_override_reason_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		var index=ret1.indexOf(',');
		var arr1=ret1.substring(index+1,ret1.length)//ret1.split(",");
		var arr0=ret1.substring(0,index);
		
		document.forms[0].pract_override_reason_desc.value=arr1;
		document.forms[0].pract_override_reason.value=arr0;
	
	}else{
		document.forms[0].pract_override_reason_desc.value="";
		document.forms[0].pract_override_reason.value="";
	}
}
/*RUT-CRF-0005 changes ends*/

//Bru-HIMS-CRF-169 changes start
function checkPatCnclReason(){
	var ptcnclcnt=0;
	if (document.forms[0].pat_cncl_count){
		if(document.forms[0].patient_id){
			if(document.forms[0].patient_id.value!=""){
				var xmlDoc= "" ;
				var xmlHttp= new XMLHttpRequest();
				
				xmlStr	="<root><SEARCH " ;
				xmlStr += "pat_id=\""+document.forms[0].patient_id.value+"\" steps='CHK_PAT_CNCL'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
				if(ptcnclcnt!="0"){
					var confirm_message=getMessage("MAX_CANCEL_COUNT_EXCEEDED","OA");
					confirm_message=confirm_message.replace("#",ptcnclcnt);
					if (confirm(confirm_message)){
						document.forms[0].pat_cncl_count.value='0';
					}
				}							
			}	
		}
	}
}

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
function displayRemarksForRev(obj)
{
	var reason_code = obj.value;
	var others_id = document.forms[0].others_id.value;

	if(others_id != "" && reason_code == others_id)
	{
		document.getElementById("rev_remarks_labl").style.visibility = "visible";
		document.getElementById("rev_remarks_fld").style.visibility = "visible";	
		//document.getElementById("rev_remarks_img").style.visibility = "visible";//Commented for ML-MMOH-CRF-1390 BY KAMATCHI S	
	}
	else
	{
		document.getElementById("rev_remarks_labl").style.visibility = "hidden";
		document.getElementById("rev_remarks_fld").style.visibility = "hidden";	
		//document.getElementById("rev_remarks_img").style.visibility = "hidden";//Commented for ML-MMOH-CRF-1390 BY KAMATCHI S
	}
}

function displayRemarksForOvr(obj)
{
	var reason_code = obj.value;
	var others_id = document.forms[0].others_id.value;

	if(others_id != "" && reason_code == others_id)
	{
		document.getElementById("ovr_remarks_labl").style.visibility = "visible";
		document.getElementById("ovr_remarks_fld").style.visibility = "visible";	
		document.getElementById("ovr_remarks_img").style.visibility = "visible";	
	}
	else
	{
		document.getElementById("ovr_remarks_labl").style.visibility = "hidden";
		document.getElementById("ovr_remarks_fld").style.visibility = "hidden";	
		document.getElementById("ovr_remarks_img").style.visibility = "hidden";	
	}
}
/*End ML-MMOH-CRF-1114*/

