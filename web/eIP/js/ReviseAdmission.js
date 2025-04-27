function apply(){
/*		if(parent.content != null)
	{
		if(parent.content.frames[0] != null && parent.content.frames[0].name == "commontoolbarFrame")
			 parent.content.frames[0].document.forms[0].apply.disabled = true;
	}*/
	var difframe = 'N'
	var f = "";
    if(parent.content !=null){
		f = parent.content.frames[1];
	}else{
        f = parent.frames[1];
    }
	var sStyle = f.document.forms[0].sStyle.value;
    var result =0;
	var fields=new Array();
	var names = new Array();
	var p = 0;

	
	fields[p]= f.document.Change_Adm_Dtls_Form.nursing_unit;
	names[p] = getLabel('Common.nursingUnit.label','Common');
	p++;
	
	fields[p]= f.document.Change_Adm_Dtls_Form.Bedcode;
	names[p] = getLabel('Common.BedClass.label','common');
	p++;
	fields[p]= f.document.Change_Adm_Dtls_Form.bed_type;
	names[p] = getLabel('Common.bedtype.label','Common');
	p++; 	

	fields[p]= f.document.Change_Adm_Dtls_Form.visit_adm_type;
	names[p] = getLabel('Common.admissiontype.label','Common');
	p++;
	fields[p]= f.document.Change_Adm_Dtls_Form.Splcode;
	names[p] = getLabel('Common.speciality.label','Common');
	p++;
	fields[p]= f.document.Change_Adm_Dtls_Form.practid;
	names[p] = getLabel('eIP.AdmittingPractitioner.label','IP');
	p++;
	fields[p]= f.document.Change_Adm_Dtls_Form.service;
	names[p] = getLabel('Common.service.label','Common');
	p++;
	fields[p]= f.document.Change_Adm_Dtls_Form.revision_resn_desc;
	names[p] = getLabel('eIP.ReasonforChangeAdmission.label','IP');
	p++;
	var adt_status=f.document.Change_Adm_Dtls_Form.adt_status.value
	var pat_check_in_allowed_yn=f.document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value
	var checkForBilling=f.document.Change_Adm_Dtls_Form.checkForBilling.value

	if(f.document.Change_Adm_Dtls_Form.bed_img!=null) {	
		if(f.document.Change_Adm_Dtls_Form.bed_no.value =='') { 
			fields[p]= f.document.Change_Adm_Dtls_Form.bed_no;
			names[p] = getLabel('Common.bedno.label','Common');
			p++;
		} 
	}

	if(f.document.Change_Adm_Dtls_Form.room_img!=null) {	
		if(f.document.Change_Adm_Dtls_Form.room_no.value =='') { 
			fields[p]= f.document.Change_Adm_Dtls_Form.room_no;
			names[p] = getLabel('Common.roomcubicleno.label','Common');
			p++;
		} 
	}

  /*
	if(adt_status=="01"&&pat_check_in_allowed_yn=='N'){
		if(f.document.Change_Adm_Dtls_Form.bed_no.value ==''){
			f.document.Change_Adm_Dtls_Form.bed_img.style.visibility = "visible";
			f.document.Change_Adm_Dtls_Form.room_img.style.visibility = "visible";
			fields[p]= f.document.Change_Adm_Dtls_Form.bed_no;
			names[p] = getLabel('Common.bedno.label','Common');
			p++;
			fields[p]= f.document.Change_Adm_Dtls_Form.room_no;
			names[p] = getLabel('Common.roomcubicleno.label','Common');
			p++;

		}else{
			f.document.Change_Adm_Dtls_Form.bed_img.style.visibility = "hidden";
			f.document.Change_Adm_Dtls_Form.room_img.style.visibility = "hidden";
		}
	}else if((adt_status=="01"&&pat_check_in_allowed_yn=='Y')){
		if(f.document.Change_Adm_Dtls_Form.bed_no.value ==''){
			f.document.Change_Adm_Dtls_Form.bed_img.style.visibility = "visible";
			f.document.Change_Adm_Dtls_Form.room_img.style.visibility = "visible";
			fields[p]= f.document.Change_Adm_Dtls_Form.bed_no;
			names[p] = getLabel('Common.bedno.label','Common');
			p++;
			fields[p]= f.document.Change_Adm_Dtls_Form.room_no;
			names[p] = getLabel('Common.roomcubicleno.label','Common');
			p++;
	}
}

*/

	//if(pat_check_in_allowed_yn =='N' && adt_status=='01') {
		/*Wednesday, August 05, 2009 IN013004*/
	if(adt_status=='01') {
		if(f.document.Change_Adm_Dtls_Form.bed_no.value !='') {
			f.document.Change_Adm_Dtls_Form.attend_img.style.visibility = "visible";
			fields[p]= f.document.Change_Adm_Dtls_Form.att_practid;
			names[p] = getLabel('Common.AttendingPractitioner.label','Common');
			p++;
		}
	}
	
	

if(checkFields( fields, names,f)){
		if(checkForChange()){
	document.forms[0].nursing_unit_desc.disabled=false;
	document.forms[0].service.disabled=false;
	document.forms[0].sub_service.disabled=false;
	document.forms[0].Bedcode.disabled=false;
	document.forms[0].bed_type.disabled=false;
	document.forms[0].bed_no.disabled=false;
	document.forms[0].room_no.disabled=false;
	document.forms[0].visit_adm_type.disabled=false;
	document.forms[0].ambulatory_status.disabled=false;
	document.forms[0].ot_date_time.disabled=false;
	document.forms[0].att_practid_desc.disabled=false;
	document.forms[0].admission_approval_details.disabled=false; //Added by Suji Keerthi for MMS-DM-CRF-0191 US002 
	parent.frames[1].document.forms[0].action="../../servlet/eIP.ChangeAdmissionDtlsServlet";
	parent.frames[1].document.forms[0].target="messageFrame";
	parent.frames[1].document.forms[0].submit();
	}else{
		alert(getMessage("ONE_CHANGE_REQUIRED",'IP'));
		}
	}
}

function onSubmit1(){
			var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/ChangeAdmissionValidation.jsp'><form><input type='hidden' name='field3' id='field3' value=\""+bedno+"\"><input type='hidden' name='bl_Nursingunit' id='bl_Nursingunit' value=\""+document.forms[0].nursing_unit.value+"\"><input type='hidden' name='future_yn' id='future_yn' value='Y'><input type='hidden' name='patient_id' id='patient_id' value=\""+document.forms[0].patient_id.value+"\"></form></body></html>";
	
		messageFrame.document.write(HTMLVal);
		messageFrame.document.dummy_form.submit();
}
function BLCheckElig(f){
	var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><form><input type='hidden' name='field1' id='field1' value=\""+document.forms[0].bed_type.value+"\"><input type='hidden' name='field2' id='field2' value=\""+AdmitPatient_form.billing_group.value+"\"><input type='hidden' name='field3' id='field3' value=\""+document.forms[0].bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Admission'><input type='hidden' name='field5' id='field5' value='parent.frames[1].frames[2].document.AdmitPatient_form.bed_no'><input type='hidden' name='field6' id='field6' value='parent.frames[1].frames[2].document.AdmitPatient_form.modified_bed_type'><input type='hidden' name='field7' id='field7' value='../js/AdmitPatient.js'></form></body></html>";
	
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.dummy_form.submit();
}
function checkForChange(){
	var proceed 	= new Boolean() ;
	proceed	=false;
	var NUnit_Chk		=	document.forms[0].NUnit_Chk
	var Servic_Chk		=	document.forms[0].Servic_Chk
	var SubServ_Chk =	document.forms[0].SubServ_Chk
	var BedCls_Chk	=	document.forms[0].BedCls_Chk
	var BedTyp_Chk	=	document.forms[0].BedTyp_Chk
	var BedNo_Chk	=	document.forms[0].BedNo_Chk
	var RoomNo_Chk=	document.forms[0].RoomNo_Chk
	var Splty_Chk		=	document.forms[0].Splty_Chk
	var AdmTyp_Chk =	document.forms[0].AdmTyp_Chk
	var AmblSts_Chk		=	document.forms[0].AmblSts_Chk
	var EDD_Chk		=	document.forms[0].EDD_Chk
	var OTD_Chk		=	document.forms[0].OTD_Chk
	var Admtprct_Chk=	 document.forms[0].Admtprct_Chk
	var Attndprct_Chk=	 document.forms[0].Attndprct_Chk
	var refId_Chk=	 document.forms[0].refId_Chk	
	var AdmApprDtls_Chk=	 document.forms[0].AdmApprDtls_Chk //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
	

	if(NUnit_Chk.value!=document.forms[0].nursing_unit.value){
		proceed= true;
	}
	if(Servic_Chk.value!=document.forms[0].service.value){

		proceed= true;
	}
	if(SubServ_Chk.value!=document.forms[0].sub_service.value){
		proceed= true;
	}
	if(BedCls_Chk.value!=document.forms[0].Bedcode.value){
		proceed= true;
	}
	if(BedTyp_Chk.value!=document.forms[0].bed_type.value){
		proceed= true;
	}
	if(BedNo_Chk.value!=document.forms[0].bed_no.value){
		proceed= true;
	}
	if(RoomNo_Chk.value!=document.forms[0].room_no.value){
		proceed= true;
	}
	if(Splty_Chk.value!=document.forms[0].Splcode.value){
		proceed= true;
	}
	if(AdmTyp_Chk.value!=document.forms[0].visit_adm_type.value){
		proceed= true;
	}
	if(AmblSts_Chk.value!=document.forms[0].ambulatory_status.value){
		proceed= true;
	}
	if(EDD_Chk.value!=document.forms[0].expecteddischargedate.value){
		proceed= true;
	}
	if(OTD_Chk.value!=document.forms[0].ot_date_time.value){
		proceed= true;
	}
	if(Admtprct_Chk.value!=document.forms[0].practid.value){
		proceed= true;
	}
	if(Attndprct_Chk.value!=document.forms[0].att_practid.value){
		proceed= true;
	}
	if(refId_Chk.value!=document.forms[0].referral_id.value){
		proceed= true;
	}
	//Below added by Suji Keerthi for MMS-DM-CRF-0191 US002
	if(AdmApprDtls_Chk.value!=document.forms[0].admission_approval_details.value){
		proceed= true;
	}
	//Ended by Suji Keerthi for MMS-DM-CRF-0191 US002
	if(document.forms[0].customer_id.value == "AMRI")
	{
		var admin_remarks_Chk=	 document.forms[0].admin_remarks_Chk	;
		if(admin_remarks_Chk.value!=document.forms[0].admission_remarks.value){
			proceed= true;
		}
	}
if (proceed){
	return true;
}else{
	return false
}


}
function checkFields( fields, names,callingFrame ) {
	var sStyle			= callingFrame.document.forms[0].sStyle.value;
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(callingFrame.trimCheck(fields[i].value)) {
			fields[i].value = callingFrame.trimString(fields[i].value);
		}else{
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
		}
	}

	if ( errors.length != 0 ){
					parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}
	
	function BeforegetSpecialty(obj){

	var f = "";
    if(parent.content !=null){
		f = parent.content.frames[1];
	}else{
        f = parent.frames[1];
    }
	var adt_status=f.document.Change_Adm_Dtls_Form.adt_status.value
	var pat_check_in_allowed_yn=f.document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value

	if(pat_check_in_allowed_yn =='N' && adt_status=='01') 
		if(f.document.Change_Adm_Dtls_Form.bed_no.value !='') 
			f.document.Change_Adm_Dtls_Form.attend_img.style.visibility = "visible";
				
		if(document.forms[0].SplDesc.value == ""){
			document.forms[0].Splcode.value="";

			document.forms[0].practid_desc.value="";
			document.forms[0].practid.value="";
			
			if(document.forms[0].err_status.value == 'true')
			{
				document.forms[0].att_practid_desc.value = "";
				document.forms[0].att_practid.value="";
			}else
			{
				document.forms[0].att_practid_desc.value=document.forms[0].att_practitioner_name.value
				document.forms[0].att_practid.value=document.forms[0].att_practitioner_id.value
			}
		}
if(document.forms[0].SplDesc_hid.value != document.forms[0].SplDesc.value){
			if(document.forms[0].SplDesc.value != ""){
				document.forms[0].Splcode.value="";
				
				document.forms[0].practid_desc.value="";
				document.forms[0].practid.value="";
				
				if(document.forms[0].err_status.value == 'true')
				{
					document.forms[0].att_practid_desc.value = "";
					document.forms[0].att_practid.value="";
				}else
				{
					document.forms[0].att_practid_desc.value=document.forms[0].att_practitioner_name.value
					document.forms[0].att_practid.value=document.forms[0].att_practitioner_id.value
				}
				getSpecialty(obj);
			}
		}
		

	}

async function getSpecialty(getFacilitID){
	var tit				= getLabel("Common.speciality.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var facilityId		= getFacilitID;
	var locale			= document.forms[0].locale.value;
	var code			= document.forms[0].nursing_unit.value;


	sql = "Select a.speciality_code code,a.short_desc description from AM_SPECIALITY_LANG_VW a, IP_NURS_UNIT_FOR_SPECIALTY b where a.language_id='"+locale+"' and a.eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?)";
	/*Wednesday, May 19, 2010 , modified for PE*/
	//sql = "Select a.speciality_code code,am_get_desc.am_speciality(a.speciality_code,'"+locale+"',2) description from AM_SPECIALITY a, IP_NURS_UNIT_FOR_SPECIALTY b where a.eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?)";


	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "b.facility_id" ;
	dataValueArray[1]	= getFacilitID;
	dataTypeArray[1]	= STRING;

	argumentArray[0]		= sql;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]		= "3,4";
	argumentArray[5]		= document.forms[0].SplDesc.value;
	argumentArray[6]		= DESC_LINK;
	argumentArray[7]		= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].SplDesc.value=arr[1];
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].SplDesc_hid.value = document.forms[0].SplDesc.value;

	}
}


	function BeforeNursingUnitLookup(facilityID,User,OperationStation){
		var oldValFlag = false;
		if(document.forms[0].nursing_unit_desc.value == ''){
			document.forms[0].nurs_unit_desc_hid.value = "";
			document.forms[0].bed_no.value = "";
			document.forms[0].bed_avail_chart.disabled = false;
			document.forms[0].attend_img.style.visibility = "hidden";
			document.forms[0].practid_desc.value="";
			document.forms[0].practid.value="";
			document.forms[0].practid_desc_hid.value="";
			document.forms[0].att_practid_desc.value="";
			document.forms[0].att_practid.value="";
		}

		if(document.forms[0].nurs_unit_desc_hid.value != document.forms[0].nursing_unit_desc.value)
			oldValFlag = true;

		if(oldValFlag){
			
			document.forms[0].nursing_unit.value ="";
			var obj		= document.forms[0].service; 
			var length  = obj.length;
			for(i=0;i<length;i++) 
			{obj.remove(1);}
			var obj1		= document.forms[0].sub_service; 
			var length1		= obj1.length;
			for(i=0;i<length1;i++) 
			{obj1.remove(1);}
			var obj2		= document.forms[0].bed_type; 
			var length2		= obj2.length;
			for(i=0;i<length2;i++) {
				obj2.remove(1);
			}
			
			document.forms[0].Bedcode.value="";
			document.forms[0].bed_no.value = "";
			document.forms[0].room_no.value = "";
		if(document.forms[0].nursing_unit_desc.value!=""){
				/*if(parent.frames[0].document.forms[0].booking_ref_no.value == "")
					document.forms[0].patient_class_id.value = "";----To Be Confirmed*/
				NursingUnitLookup(facilityID,User,OperationStation);
			}else{
				validateFields(document.forms[0].nursing_unit_desc);
			}
		}
	}


async function NursingUnitLookup(FacilityID,LoginUser,OperatorStationID){
	
	var Facility_ID						=	FacilityID;
	var Login_User						=	LoginUser;
	var Operator_Station_ID		=	OperatorStationID;
	var nursingUnitCode				=  document.forms[0].nursing_unit_desc.value
	var tit									= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight					= "400px" ;
	var dialogWidth					= "700px" ;
	var status								= "no";
	var features							= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments						= "" ;

	var splty_code						= document.forms[0].Splcode.value;
	var pract_id							= document.forms[0].practid.value;

	var patient_class					=document.forms[0].patient_class.value;
	var room_no							= document.forms[0].room_no.value;
	var call_function					=	document.forms[0].call_function.value;

	var statics_yn='Y';
	var clinic_code	=	"";
	
	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&specilaty_code="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&patientclass="+patient_class+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function+"&room_no="+room_no;
	
	var retVal =  await window.showModalDialog(jsp_name,arguments, features);
		
	var arr=new Array();
	
	if (retVal != null )
	{
		arr=retVal.split("~");
		document.forms[0].nursing_unit_desc.value=arr[1];
		document.forms[0].nursing_unit.value=arr[0];
		document.forms[0].patient_class.value = arr[2];
		document.forms[0].nurs_unit_desc_hid.value = document.forms[0].nursing_unit_desc.value;

		validateFields(document.forms[0].nursing_unit_desc);
		if(document.forms[0].patient_class.value == 'DC')
		{
		/*	document.forms[0].exp_days_stay.value = '1';
			document.forms[0].exp_days_stay.onblur();
			document.forms[0].exp_days_stay.readOnly = true;*/
		}
		document.forms[0].Bedcode.value='';

		
		//if(document.forms[0].pat_check_in_allowed_yn.value == "Y")
		/**Wednesday, August 05, 2009 IN013004*/
		if(document.forms[0].adt_status.value == "00")
			document.forms[0].attend_img.style.visibility="hidden";
		else
			{
				if(document.Change_Adm_Dtls_Form.bed_no.value !='')
					document.forms[0].attend_img.style.visibility="visible";
			}

		document.forms[0].practid_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].att_practid_desc.value='';
		document.forms[0].att_practid.value='';

	}
	else
	{		
		document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.value = '';
		document.forms[0].practid_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].att_practid_desc.value='';
		document.forms[0].att_practid.value='';
		document.forms[0].Bedcode.value='';
		document.forms[0].bed_type.value='';
		
	/*	if(bkg_type !='D')
		{
			document.forms[0].bed_no.value='';
			document.forms[0].room_no.value='';
		}-----To be Confirm*/
		//if(document.forms[0].pat_check_in_allowed_yn.value == "Y")
		/*Wednesday, August 05, 2009 IN013004*/
		if(document.forms[0].adt_status.value == "00")
			document.forms[0].attend_img.style.visibility="hidden";
		else
			document.forms[0].attend_img.style.visibility="visible";
		var obj = document.forms[0].service;
		var length  = obj.length;
		for(i=0;i<length;i++) { obj.remove(0); }
		
		var opt = document.createElement("OPTION");
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value= '';
		document.forms[0].service.add(opt);
	}
	enableBed(document.forms[0].nursing_unit_desc);
}
	function enableBed(nursingUnit){
		if(nursingUnit.value != ''){
			if(document.forms[0].nurs_unt_auth_val.value == "Y"){
				document.forms[0].bed_no.value = '';
				document.forms[0].bed_avail_chart.disabled = false;
			}

	}
		else if(nursingUnit.value == '')
		{

			document.forms[0].bed_no.value = '';
			document.forms[0].bed_avail_chart.disabled = false;
			document.forms[0].room_no.readOnly = true;
		}
	}


	function CheckNursingUnit(){		
		var nursingunit=document.forms[0].nursing_unit_desc.value;
		if(nursingunit == ''){
			document.forms[0].sub_service.value='';
			document.forms[0].bed_no.value='';
			document.forms[0].room_no.value='';
			document.forms[0].SplDesc.value='';
			document.forms[0].expecteddischargedate.value='';
			document.forms[0].otdatetime.value='';

			/*if(parent.frames[0].document.Select_form.bkg_type.value !='D'){
				document.forms[0].room_no.value='';
			}  --To be Confirmed*/
			var obj =document.forms[0].service;		
			var slength  = obj.length;
			for(i=0;i<=slength;i++) {
				obj.remove(0);
			}
			var opt = parent.frames[1].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj.add(opt);

			var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) {
				obj1.remove(0);
			}
			var opt = parent.frames[1].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj1.add(opt);

			var obj1 =document.forms[0].bed_type;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) {
				obj1.remove(0);
			}
			var opt = parent.frames[1].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj1.add(opt);

			var obj3 =document.forms[0].Bedcode;		
			var slength3  = obj3.length;
			for(i=0;i<=slength3;i++) {
				obj3.remove(0);
			}
			var opt3 = parent.frames[1].document.createElement('Option');
			opt3.value = "";
			opt3.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt3.selected = true;
			obj3.add(opt3);

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



function validateFields(obj){
	if(obj.value=="" && obj.name == 'bed_no'){
		if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value == "Y")
			parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility="hidden";
	}

	if((obj.value=='')&&(obj.name!='nursing_unit_desc')) 
		return false;

    var continue_yn = true ;

    if((obj.value=='')&&(obj.name!='nursing_unit_desc'))   
		continue_yn =false;
    else if(obj.name == 'bed_no'){
		continue_yn = validateSplchars (obj,'Bed No');

	}

    if(continue_yn){
		var admtypecode = '';
        var admdate  = '';
        var nursingcode = '';
        var bedno = '';
		var Splcode = "";
		var expDaysofStay = "";
		var tospecialtycode = '';
		var Indicator = '';
		var patient_class= "";


        if(obj.name == 'visit_adm_type')
            admtypecode = obj.value;
 
        else if(obj.name == 'nursing_unit_desc'){
			if(obj.value=='')
			Indicator = 'Blnk_Nursing_Unit';
			nursingcode = document.Change_Adm_Dtls_Form.nursing_unit.value;
			bedno=	parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;
			tospecialtycode = document.Change_Adm_Dtls_Form.to_speciality_code.value;
			if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value == "Y")
			parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility="hidden";
			patient_class = document.Change_Adm_Dtls_Form.patient_class.value
		}
		else if(obj.name == 'bed_no'){
           bedno = obj.value;
			bedno = bedno.toUpperCase();
			if (bedno!=''){
				document.Change_Adm_Dtls_Form.bed_no.value = bedno;
			}
            nursingcode		 = document.Change_Adm_Dtls_Form.nursing_unit.value;
			patient_class = document.Change_Adm_Dtls_Form.patient_class.value;
			
        }

		Splcode		     = document.Change_Adm_Dtls_Form.Splcode.value;

		var service_add  = "Y";
		if(document.Change_Adm_Dtls_Form.service.value != "")
			service_add  = "N";

		var urlStr		 = parent.frames[1].location.href;
		if(document.Change_Adm_Dtls_Form.sub_service.value != "")
			service_add = "N";
		var patient_id=document.forms[0].patient_id.value;

		var deactivate_pseudo_bed_yn = document.Change_Adm_Dtls_Form.deactivate_pseudo_bed_yn.value;
		var HTMLVal =" <html><body class='MESSAGE' onKeyDown='lockKey()'> <form name='mainform' id='mainform' "+
		" method='post' action='../../eIP/jsp/ChangeAdmissionValidation.jsp'>"+
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
		" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class+"'> "+
		" <input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'> "+
		" <input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'> "+
		" </form></body></html>";

		if(parent.parent.messageFrame.document.body != null){			
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.forms[0].submit();
		}
    }else{
        if(obj.name == 'bed_no'){
           /* if(bkg_type !='D')
				document.AdmitPatient_form.room_no.value = '';

			if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=="Y")
				parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility="hidden";*/

//			parent.frames[3].document.getElementById("valuables").disabled = true;
		}
    }
}
	
function onServiceChange(){
	if(document.forms[0].service.value!='')
	PopulateSubService('A');

}

	function PopulateSubService(fVal){
	var from = fVal;
	var nursingunit = "";
	var serviceCode = "";
	var patient_class_id = "";
	var HTMLVal =	" <html><body class='MESSAGE' onKeyDown='lockKey()'> <form name='dum_form' id='dum_form' "+
			" method='post' action='../../eIP/jsp/ChangeAdmissionValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''> "+
			" <input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value=''> "+
			" <input type='hidden' name='field4' id='field4' value='Main_form'> "+
			" <input type='hidden' name='field5' id='field5' value=''> ";
	if(fVal == 'G'){
		nursingunit = parent.frames[1].document.forms[0].nursing_unit.value;
		serviceCode = parent.frames[1].document.forms[0].service.value;
		patient_class_id = parent.frames[1].document.forms[0].patient_class.value
		HTMLVal += 
			" <input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'> "+" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class_id+"'>  </form></body></html>";
		
		if(parent.messageFrame.document.body != null){			
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();
		}
	}else{
		nursingunit = parent.frames[1].document.forms[0].nursing_unit.value;
		serviceCode = parent.frames[1].document.forms[0].service.value;
		patient_class_id = parent.frames[1].document.forms[0].patient_class.value
		HTMLVal += 
			" <input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'> "+" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class_id+"'> "+" <input type='hidden' name='frame_ref' id='frame_ref' value='parent.frames[1]'> </form></body></html>";
		if(parent.messageFrame.document.body != null){			
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();
		}
	}

}
function onBedClassChange(){
	
	var obj = document.forms[0].bed_type;
	var length = obj.length;
	for(i=0;i<length;i++){
		obj.remove(0);
	}
	var opt = document.createElement('OPTION');
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value = "";
	obj.add(opt);
   var bed_class			 = document.forms[0].Bedcode.value;
   var nursingunit_code	 = document.forms[0].nursing_unit.value;

   var deactivate_pseudo_bed_yn = 'N';
	document.forms[0].bed_no.value = '';
	document.forms[0].bed_avail_chart.disabled = false;
	document.forms[0].room_no.value = '';
	document.Change_Adm_Dtls_Form.attend_img.style.visibility = "hidden";
	
	if(bed_class!=""){
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/ChangeAdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='nursingunit_code' id='nursingunit_code' value='"+nursingunit_code+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}
	
}

function onBedClassChange1(){
	var obj = document.forms[0].bed_type;
	var length = obj.length;
	for(i=0;i<length;i++){
		obj.remove(0);
	}
	var opt = document.createElement('OPTION');
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value = "";
	obj.add(opt);
   var deactivate_pseudo_bed_yn = 'N';
   var bed_class			 = document.forms[0].Bedcode.value;
   var nursingunit_code	 = document.forms[0].nursing_unit.value;
   var bedtype_Code	 = document.forms[0].bedtypecode.value;

	document.Change_Adm_Dtls_Form.attend_img.style.visibility = "hidden";
	
	if(bed_class!=""){
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/ChangeAdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='nursingunit_code' id='nursingunit_code' value='"+nursingunit_code+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'><input type='hidden' name='bedtype_Code' id='bedtype_Code' value='"+bedtype_Code+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}

}

async function callModal(ref){
		var nursingunit = "";
		var practitionerid = "";
		var specialitycode = "";
		if(parent.frames[1].document.forms[0].nursing_unit_desc.value != "")
			nursingunit = parent.frames[1].document.forms[0].nursing_unit.value;
		if(parent.frames[1].document.forms[0].practid_desc.value != "")
			practitionerid =document.forms[0].practid.value;
		if(parent.frames[1].document.forms[0].SplDesc.value != "")
			specialitycode	=document.forms[0].Splcode.value;
		var bedclasscode =document.forms[0].Bedcode.value;

		var bedtypecode =document.forms[0].bed_type.value;
		var gender =document.forms[0].gender.value;
		var agevalue =document.forms[0].age.value;

		var patientclass='';
		/*if(bkgtype == 'D')
			patientclass='DC';
		else if(bkgtype == 'I')-----To be Confirm*/

		patientclass =document.forms[0].patient_class.value;

		var room_num;
		var obj =document.forms[0].sub_service;
		var n = obj.length;
		for(i=0;i<n;i++)
			obj.remove(0);
		var opt = parent.frames[2].document.createElement('Option');
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value = "";
		obj.add(opt);
		if(patientclass =='DC'){
			room_num=parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value;
		}else{
			room_num='';
		}
		var age = "";

		if(agevalue != ''){
			var yr = eval(agevalue.indexOf("Y"));
			var mon = eval(agevalue.indexOf("M"));
			if(mon>=0 && yr>=0){
				age = agevalue.substring(0,yr);
				agevalue = "Y";
			}
			else if(mon >= 0){
				age = agevalue.substring(0,mon);
				agevalue = "M";
			}else{
				age = agevalue.substring(0,yr);
				agevalue = "Y";
			}
		}
		var retVal = 	new String();
		var wherecondn = "ADMIT_PAT_YN";
		var dialogHeight= "400px";
		var dialogWidth = "700px";
		var dialogTop	= "72";

		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=specialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&room_no_code="+room_num+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&patient_class="+patientclass+"&wherecondn="+wherecondn,arguments,features);

		if(retVal != null)
		{
			retVal = retVal.replace("|","&");
			var arr = retVal.split("^");
			if (arr.length > 2){
				parent.frames[1].document.forms[0].nursing_unit.value=arr[0];
				parent.frames[1].document.forms[0].nursing_unit_desc.value=arr[9];
				parent.frames[1].document.forms[0].nurs_unit_desc_hid.value =document.forms[0].nursing_unit_desc.value;
				parent.frames[1].document.forms[0].bedtypecode.value=arr[2];
				var arrsplty = arr[11].split("*All SPLTY*");
				if (arrsplty.length==1)
				{
					parent.frames[1].document.forms[0].Splcode.value=arr[10];
					parent.frames[1].document.forms[0].SplDesc.value=arr[11];
				}
				if (arr .length > 1)
				{
					var arr1 = arr[1].split("/");
					parent.frames[1].document.forms[0].bed_no.value = arr1[0];
					p =document.forms[0].Bedcode.options;
					for (i=0; i<p.options.length; i++) 
					{
						if(p.options[i].value ==arr[3])
							p.options[i].selected = true;
					}
					onBedClassChange1();
				}
				parent.frames[1].document.forms[0].patient_class.value = arr[15];
				
				if(parent.frames[1].document.forms[0].patient_class.value =='DC')
				{
				/*	parent.frames[2].forms[0].exp_days_stay.value = '1';
					parent.frames[2].forms[0].exp_days_stay.onblur();
					parent.frames[2].forms[0].exp_days_stay.readOnly = true;*/
				}
//			if(bkgtype !='D')
				parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value = arr[4];

			}
			else
			{
				arr = retVal.split("^");
				parent.frames[1].document.forms[0].nursing_unit.value = arr[0];
				if (arr.length == 2)
					parent.frames[1].document.forms[0].nursing_unit_desc.value = arr[1];
					parent.frames[1].document.forms[0].nurs_unit_desc_hid.value =document.forms[0].nursing_unit_desc.value;
			}

			
			if(parent.frames[1].document.forms[0].nursing_unit.value != '')
			{
				if(parent.frames[1].document.forms[0].adt_status.value == "01")
				{
					parent.frames[1].document.forms[0].attend_img.style.visibility="visible";
				}
				else if(parent.frames[1].document.forms[0].pat_check_in_allowed_yn.value == "N" && document.forms[0].bed_no.value !='')
				{
					parent.frames[1].document.forms[0].attend_img.style.visibility="visible";
				}
			}
		}
	}

	function BeforeGetPractID1(obj1,obj2){
		var oldValFlag			= false;
		if(document.forms[0].practid_desc_hid.value != document.forms[0].practid_desc.value)
			oldValFlag = true;
		if(oldValFlag){
			if(document.forms[0].practid_desc.value!="")
			getPractID(obj1,obj2);
		}
	}

	function BeforeGetPractID2(obj1,obj2){
		var oldValFlag			= false;
		if(document.forms[0].att_practid_desc_hid.value != document.forms[0].att_practid_desc.value)
			oldValFlag = true;
		if(oldValFlag){
			if(document.forms[0].att_practid_desc.value!="")
				getPractID(obj1,obj2);
		}
	}
function getPractID(obj,target){
	var sStyle	= document.forms[0].sStyle.value;
	var Spl_code= document.forms[0].SplDesc.value;
	if((Spl_code == null) || (Spl_code == "")){	
		msg=getMessage('SPLTY_NOTNULL','IP');
		if (msg !=""){
			parent.parent.messageFrame.document.open();
			var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
			"<body class='message' onKeyDown='lockKey()'><script>document.writeln(\""+msg+"\");";
			s += "<\/script></body></html>"
			parent.parent.messageFrame.document.writeln(s);
		}
		document.forms[0].practid_desc.value = "";
		if(document.forms[0].err_status.value == 'true')
		{
			document.forms[0].att_practid_desc.value = "";
			document.forms[0].att_practid.value="";
		}else
		{
			document.forms[0].att_practid_desc.value=document.forms[0].att_practitioner_name.value
			document.forms[0].att_practid.value=document.forms[0].att_practitioner_id.value
		}
		document.forms[0].SplDesc.focus();
	}else{
		var sql					= "";
		var sql2				= "";
		var facility			= document.forms[0].facility_id.value;
		var locale				= document.forms[0].locale.value;
		var nursing_unit_cd		= document.forms[0].nursing_unit.value;
		var splty				= document.forms[0].Splcode.value;
		var practName_FName		= target.name;
		var practName_FValue			= target.value;
		getPractitioner(obj, target, facility, splty,nursing_unit_cd,"Q5");
	}
}


function PractLookupRetVal(retVal,objName){
	var arr;
	if (retVal != null){
		arr=retVal.split("~");
		if(objName=='practid_desc'){
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];
			document.forms[0].practid_desc_hid.value = document.forms[0].practid_desc.value;

		}
		if(objName=='att_practid_desc'){
			document.forms[0].att_practid.value=arr[0];
			document.forms[0].att_practid_desc.value=arr[1];
			document.forms[0].att_practid_desc_hid.value = document.forms[0].att_practid_desc.value;
		}

	}else{
		if(objName=='practid_desc'){
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";
		}
		if(objName=='att_practid_desc'){
			document.forms[0].att_practid.value="";
			document.forms[0].att_practid_desc.value="";			
		}
	}
}
	function chkbedno(){
		if((document.forms[0].bed_no.value!="") && (document.forms[0].bed_no.value!=null)){
			if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value == "N")
				parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility="visible";
		}
		else if((document.forms[0].bed_no.value=="") || (document.forms[0].bed_no.value==null)){
			document.forms[0].attend_img.style.visibility = "hidden";
		}
		if(document.forms[0].bed_no != ""){
			validateFields(document.forms[0].bed_no);
		}
	}
	function populateList(){
		var patient_id=document.Change_Adm_Dtls_Form.patient_id.value;
	var HTMLVal =	" <html><body class='MESSAGE' onKeyDown='lockKey()'> <form name='dum_form' id='dum_form' "+
			" method='post' action='../../eIP/jsp/ChangeAdmissionValidation.jsp'>"+
			" <input type='hidden' name='populateList' id='populateList' value='Y'>"+"<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();


	}


	/*
	 * This function is used to validate the expected discharge date
	 */ 

	function validateExpDate(obj){
		
		if(document.forms[0].patient_class_value.value == "DC")
	{
			if(validDateObj(obj,"DMYHM", localeName))
				dayCareDateCheck(obj);
		
	}else if(document.forms[0].patient_class_value.value == "IP"){
			if(validDateObj(obj,'DMYHM',localeName))
			{
				var greg_VisitAdmDateTime = convertDate(document.forms[0].admission_date_time.value,'DMYHM',localeName,'en');
				var greg_expectedDischargeDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
				if(isBefore(greg_expectedDischargeDateTime,greg_VisitAdmDateTime,'DMYHM','en'))
				{
					var msg = getMessage("EXP_DIS_DATE_GT_SYSDATE",'IP');
					msg = msg.replace("or equal to Current Date Time",getLabel('Common.admissiondate.label','Common'))
					alert(msg);
					obj.value = "";
				}
				return true;
			}
			else
				return false;
		//}
	}
	}
	
	function dayCareDateCheck(dateVal)
{
	
	if(document.getElementById('patient_class_value').value == "DC")
	{
		var valid					= document.forms[0].valid.value;
		var expecteddischargedate	= document.forms[0].expecteddischargedate.value;
		//var system_date_time		= document.forms[0].system_date_time;
		var from_time				= document.forms[0].from_time.value;
		var max_param_date			= document.forms[0].max_param_date.value;
		var valid_date				= document.forms[0].valid_date.value;
		
		var locale = Change_Adm_Dtls_Form.locale.value;
		var greg_date = convertDate(expecteddischargedate,"DMYHM",locale,"en");

		if(expecteddischargedate != '')
		{
			if(valid == "N")
			{
				if(isAfter(from_time, greg_date,"DMYHM",locale))
				{
					var trn_error = getMessage("DATE1_LT_DATE2","IP");
					trn_error = trn_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
					alert(trn_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
				//if(isAfter(greg_date, valid_date,"DMYHM","en")) 5/22/2009 SRR20056-SCF-3027  IN010821
				//if(!isBefore(greg_date, valid_date,"DMYHM",locale))
				if(isAfter(greg_date, valid_date,"DMYHM",locale)) //Modified for AAKH-SCF-0093
				{	var max_error = getMessage("GENERAL_CANNOT_EXCEED","IP");
					max_error = max_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					max_error = max_error.replace("#",valid_date);
					//max_error = max_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
					alert(max_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
			}
			else if(valid == "Y")
			{
				if(isAfter(from_time, greg_date,"DMYHM",locale))
					
				{
					var trn_error = getMessage("DATE1_LT_DATE2","IP");
					trn_error = trn_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
					alert(trn_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}

				if(isAfter(greg_date, max_param_date,"DMYHM",locale))
				{
					var param_error = getMessage("DATE1_GT_DATE2","IP");
					param_error = param_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					param_error = param_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
					alert(param_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
			}
		}
	}
}
function doOTDateTimeChk(obj){
   
		if(validDateObj(obj,'DMYHM',localeName)){   
			var OTdate			= convertDate(obj.value,'DMYHM',localeName,'en');
			var admndate		= convertDate(document.forms[0].admission_date_time.value,'DMYHM',localeName,'en');
			var exp_discharge_date		= convertDate(document.forms[0].expecteddischargedate.value,'DMYHM',localeName,'en');
			if( ValidateAdmnOTDateTime(admndate,OTdate) == false ) 
				return false;

			if(exp_discharge_date != ""){
				 if( ValidateAdmnOTDateTime(OTdate,exp_discharge_date) == false ) 
					 return false;
			}
        }else{
			return false;
        }
}
/*
 * This function is used to validat the OT date and it returns true or false
 */
function ValidateAdmnOTDateTime(from,to){

	if(isAfter(from,to,'DMYHM','en')){
        alert(getMessage("INVALID_OT_DATE",'IP'));
        document.forms[0].ot_date_time.focus();
        document.forms[0].ot_date_time.select();
        return false
    }else
        return true;
}

	function BeforeReasonLookup(){	
		var oldValFlag = false;
		if(document.forms[0].revision_resn_hid_desc.value != document.forms[0].revision_resn_desc.value)
			oldValFlag = true;
		if(oldValFlag){
			if(document.forms[0].revision_resn_desc.value!="")
				ReasonLookup();
		}
	}



		async function ReasonLookup(){
		var tit				= getLabel("eIP.ReasonforChangeAdmission.label","IP");

		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var locale = document.forms[0].locale.value;
		// This sql populates the reasons for admission with given search value
		//sql="select CONTACT_REASON_CODE code,CONTACT_REASON description from AM_CONTACT_REASON where  eff_status like ? and  CHANGE_ADMISSION_DTLS_YN='Y' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON)  like upper(?)" ;	   
		/*Wednesday, May 19, 2010 , modified for language conversion*/
		sql="select CONTACT_REASON_CODE code,am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1) description from AM_CONTACT_REASON where  eff_status like ? and  CHANGE_ADMISSION_DTLS_YN='Y' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON)  like upper(?)" ;	   
		dataNameArray[0]	= "eff_status" ;
		dataValueArray[0]	= "E";
		dataTypeArray[0]	= STRING;
		argumentArray[0]		= sql;
		argumentArray[1]		= dataNameArray ;
		argumentArray[2]		= dataValueArray ;
		argumentArray[3]		= dataTypeArray ;
		argumentArray[4]		= "2,3";
		argumentArray[5]		= document.forms[0].revision_resn_desc.value;
		argumentArray[6]		= DESC_LINK;
		argumentArray[7]		= DESC_CODE;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].revision_resn_desc.value=arr[1];
			document.forms[0].revision_resn_code.value=arr[0];
			document.forms[0].revision_resn_hid_desc.value = document.forms[0].revision_resn_desc.value
		}else{
			document.forms[0].revision_resn_desc.value="";
			document.forms[0].revision_resn_code.value="";
		}
	}
	
function disableFields(){
	document.forms[0].nursing_unit.disabled=true;
	document.forms[0].service.disabled=true;
	document.forms[0].sub_service.disabled=true;
	document.forms[0].Bedcode.disabled=true;
	document.forms[0].bed_type.disabled=true;
	document.forms[0].bed_no.disabled=true;
	document.forms[0].room_no.disabled=true;
	document.forms[0].visit_adm_type.disabled=true;
	document.forms[0].ambulatory_status.disabled=true;
	document.forms[0].ot_date_time.disabled=true;

	document.forms[0].att_practid_desc.disabled=true;
}
async function getReferralID() {
	var p_to_locn_code=document.forms[0].frm_nursing_unit_code.value;
	 var p_to_pract_id=document.forms[0].frm_practitioner_id.value;
	// var p_to_pract_name=document.forms[0].cur_pract_name.value;
	 var p_speciality_code=document.forms[0].frm_specialty_code.value;
	 var p_service_code=document.forms[0].frm_service_code.value;
	// var res_class=document.forms[0].resclass.value;
	// var p_to_locn_type=document.forms[0].cur_locn_type.value;
	 var p_patient_id=document.forms[0].patient_id.value;

	
	var funcid="";	
	var retVal;
	var dialogTop       = "61";
	var dialogHeight    = "700px";
	var dialogWidth = "900px";    
	var arguments   = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
	var arguments   = "" ;	
	url="../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=CHG_ADM_DTLS&p_to_locn_code="+p_to_locn_code+"&p_to_pract_id="+p_to_pract_id+"&p_speciality_code="+p_speciality_code+"&p_service_code="+p_service_code+"&p_select=YES&p_reg_patient=YES&p_patient_id="+p_patient_id;
	
	retVal = await top.window.showModalDialog(url,arguments,features);
	//retVal = window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	document.getElementById("referral_id").value= retVal	
	
	/*var xmlHttp = new XMLHttpRequest();	
	xmlHttp.open("POST","../../eCommon/jsp/commonToolbar.jsp?menu_id=IP&module_id=IP&function_id=MODIFY_SERVICE_FOR_INPATIENT&function_name=Change%20Admission%20Details&function_type=F&access=NNNNN",false);
	xmlHttp.send(null);		
	responseText=xmlHttp.responseText;
	*/
}

function searchReferral(obj)
{		
	 	 if(document.forms[0].referral_id.value!='')
           {
	         if(obj.value!='')	
	         {					 
			     var revisVisitFlag = "Y";
				 var referal_id1 =document.forms[0].referral_id.value;
				 var p_to_locn_code =document.forms[0].frm_nursing_unit_code.value;
				 var patient_id =document.forms[0].patient_id.value;
                 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOP/jsp/GetValResource.jsp'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+referal_id1+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='revisVisitFlag' id='revisVisitFlag' value='"+revisVisitFlag+"'><input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value='"+p_to_locn_code+"'><input type='hidden' name='callingfrom' id='callingfrom' value='IP'></form></BODY></HTML>";						
				 parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				 parent.frames[2].document.form1.submit();
		     }
	      }	  
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

//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
function UploadDocument()
{
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;

	var dialogHeight = "400px";
	var dialogWidth	= "700px";
	var status = "no";
	var arguments = "";
	var function_id = "UPLOAD_DOC";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll = auto; status:" + status;

	window.showModalDialog('../../eMP/jsp/MPUploadDocument.jsp?function_id='+function_id+'&patient_id='+patient_id+'&encounter_id='+encounter_id,arguments,features);			
}

