function getVal(obj){

	var pregnant								= document.DR_OtherDtls_Form.pregnant;
	var not_pregnant						= document.DR_OtherDtls_Form.not_pregnant;            
	var preg_deliver_wks				= document.DR_OtherDtls_Form.preg_deliver_wks;      
	var preg_dtls_unknown			= document.DR_OtherDtls_Form.preg_dtls_unknown;  
	var dlivr_wks_btn					= document.getElementById("dlivr_wks_btn");  
	var dlivr_wks_lbl						= document.getElementById("dlivr_wks_lbl");  

	
	if(obj.name=='not_pregnant'){
		obj.value='N';
		pregnant.checked=false;
//		pregnant.value='N';
//		pregnant.disabled=true;
		showGestation(pregnant);
		dlivr_wks_btn.style.visibility="visible";
		dlivr_wks_btn.style.display="inline";
		dlivr_wks_lbl.style.visibility="visible";
		dlivr_wks_lbl.style.display="inline";
		preg_deliver_wks.value='N';
		preg_dtls_unknown.checked=false;
		preg_dtls_unknown.value='N';
//		preg_dtls_unknown.disabled=true;
		preg_deliver_wks.checked=false;
		preg_deliver_wks.value='N';
	}else if(obj.name=='pregnant'){
		obj.value='P';
		not_pregnant.checked=false;
//		not_pregnant.value='N';
//		not_pregnant.disabled=true;
		preg_dtls_unknown.checked=false;
//		preg_dtls_unknown.value='N';
//		preg_dtls_unknown.disabled=true;
		preg_deliver_wks.checked=false;
		preg_deliver_wks.value='N';
	}else if(obj.name=='preg_dtls_unknown'){
		obj.value='U';
		pregnant.checked=false;
//		pregnant.value='N';
//		pregnant.disabled=true;
		showGestation(pregnant);
		not_pregnant.checked=false;
//		not_pregnant.value='N';
//		not_pregnant.disabled=true;
		preg_deliver_wks.checked=false;
//		preg_deliver_wks.value="";
	}else{
//		obj.value='D';
	}
}
function getChkBoxVal(obj){
	if(obj.checked==true){
		obj.value='Y';
	}else{
		obj.value='N';
	}
}


function Save(finalize_val){
if(finalize_val=="Y"){
	document.getElementById("finalize_btn").disabled=true;
}else if(finalize_val=="N"){
	document.getElementById("save_btn").disabled=true;
}
//	alert(finalize_val)
/*Fields From Header Section*/
var proceed=new Boolean();
var Header_Form_OBJ			 = parent.DR_HeaderDtl_Frame.document.DR_HeaderDtls_Form;
var DiagnosisDtl_Form_OBJ	 = parent.DR_DiagnosisDtl_Frame.document.DR_DiagnosisDtls_Form;
var Otherdtl_Form_OBJ		 = parent.DR_OtherDtl_Frame.document.DR_OtherDtls_Form;
proceed=false;
	var attend_pract				 = Header_Form_OBJ.attend_pract.value;
	var attend_pract_name		 = Header_Form_OBJ.attend_pract_name;
	var certify_pract_name	 = Header_Form_OBJ.certify_pract_name;
	var certify_pract				 = Header_Form_OBJ.certify_pract.value;
	var designation					 = Header_Form_OBJ.designation.value;
	var citizen_id_num			 = Header_Form_OBJ.citizen_id_num.value;
	var brought_in_dead			 = Header_Form_OBJ.brought_in_dead.value;
	var registration_no			 = Header_Form_OBJ.registration_no.value;
	var year						     = Header_Form_OBJ.year;
	var month							 = Header_Form_OBJ.month;
	var date							 = Header_Form_OBJ.date;
	var hours							 = Header_Form_OBJ.hours;
	var deceased_date_time	 = Header_Form_OBJ.deceased_date_time.value;
	var patient_id					 = Header_Form_OBJ.patient_id.value;
	var encounter_id				 = Header_Form_OBJ.encounter_id.value;
	var gender						 = Header_Form_OBJ.gender.value;
	/*Mode From Diagnosis Section*/
	var	mode = DiagnosisDtl_Form_OBJ.mode;
/*Fields From DLC Officer,Pregnant Details and MLC Sections*/

	var remarks								= Otherdtl_Form_OBJ.remarks.value;
	var preg_not_preg					= Otherdtl_Form_OBJ.not_pregnant;            
	var pregnant								= Otherdtl_Form_OBJ.pregnant;      
	var preg_gestational_prd			= Otherdtl_Form_OBJ.preg_gestational_age.value;   
	var preg_deliver_wks				= Otherdtl_Form_OBJ.preg_deliver_wks.value;      
	var preg_dtls_unknown			= Otherdtl_Form_OBJ.preg_dtls_unknown;                      
	var mlc										= Otherdtl_Form_OBJ.mlc.value;                   
	var mlc_police_rept_no			= Otherdtl_Form_OBJ.mlc_police_rept_no.value;                      
	var mlc_police_station				= Otherdtl_Form_OBJ.mlc_police_station.value;                     
	var mlc_id								= Otherdtl_Form_OBJ.mlc_id.value; 
//	var dlivr_wks_btn					= parent.DR_OtherDtl_Frame.document.DR_OtherDtls_Form.dlivr_wks_btn; 
//	var dlivr_wks_lbl						= parent.DR_OtherDtl_Frame.document.DR_OtherDtls_Form.dlivr_wks_lbl; 


	var	locn_code			=  Header_Form_OBJ.locn_code.value		
	var	gender				=  Header_Form_OBJ.gender.value
	var	dob					=  Header_Form_OBJ.dob.value
	var	speciality_code	=  Header_Form_OBJ.speciality_code.value
	var	episode_id		=  Header_Form_OBJ.episode_id.value
	var	practitioner_id	=  Header_Form_OBJ.practitioner_id.value
	var	practitioner_type=  Header_Form_OBJ.practitioner_type.value
	var	patient_class		  =  Header_Form_OBJ.patient_class.value
	var	call_from			  =  Header_Form_OBJ.call_from.value			
	var	episode_type	  =  Header_Form_OBJ.episode_type.value	
	/*Five more Additional will come */
	var addl_field1="";
	var addl_field2="";
	var addl_field3="";
	var addl_field4="";
	var addl_field5="";
	var deathCerApplYn="";
	deathCerApplYn=document.getElementById("deathCerApplYn").value; //Added by Rameswar  Against  HSA-SCF-0143.1 [IN:055069]
	if(Header_Form_OBJ.ADDL_FIELD1){
		addl_field1=Header_Form_OBJ.ADDL_FIELD1.value;
	}
	if(Header_Form_OBJ.ADDL_FIELD2){
		addl_field2=Header_Form_OBJ.ADDL_FIELD2.value;
	}
	if(Header_Form_OBJ.ADDL_FIELD3){
		addl_field3=Header_Form_OBJ.ADDL_FIELD3.value;
	}
	if(Header_Form_OBJ.ADDL_FIELD4){
		addl_field4=Header_Form_OBJ.ADDL_FIELD4.value;
	}
	if(Header_Form_OBJ.ADDL_FIELD5){
		addl_field5=Header_Form_OBJ.ADDL_FIELD5.value;
	}
	/*Additional Fields in MLC,Pregnant,DLC Officer or Remarks Section*/
	if(Otherdtl_Form_OBJ.ADDL_FIELD1){
		addl_field1=Otherdtl_Form_OBJ.ADDL_FIELD1.value;
	}
	if(Otherdtl_Form_OBJ.ADDL_FIELD2){
		addl_field2=Otherdtl_Form_OBJ.ADDL_FIELD2.value;
	}
	if(Otherdtl_Form_OBJ.ADDL_FIELD3){
		addl_field3=Otherdtl_Form_OBJ.ADDL_FIELD3.value;
	}
	if(Otherdtl_Form_OBJ.ADDL_FIELD4){
		addl_field4=Otherdtl_Form_OBJ.ADDL_FIELD4.value;
	}
	if(Otherdtl_Form_OBJ.ADDL_FIELD5){
		addl_field5=Otherdtl_Form_OBJ.ADDL_FIELD5.value;
	}
	var fields=new Array();
	var names = new Array();
	var p = 0;
	var	msgFrame=parent.DR_Message_Frame;
		if(attend_pract_name.value==""){
			fields[p] = attend_pract_name;
			names[p] = getLabel("Common.AttendingPractitioner.label","Common");
			p++;
		}
		if(certify_pract_name.value==""){
			fields[p] = certify_pract_name;
			names[p] = getLabel("eMR.ceritifiedpractitioner.label","eMR");
			p++;
		}
	  if(checkFieldsofMst(fields, names, msgFrame)){
		  proceed=true;
	  }else{
			if(finalize_val=="Y"){
				document.getElementById("finalize_btn").disabled=false;
			}else if(finalize_val=="N"){
				document.getElementById("save_btn").disabled=false;
			}
		  proceed=false;
		  return false;
	  }
	var PrimaryTab=parent.DR_DiagnosisDtl_Frame.document.getElementById("PrimaryTab");
	if(PrimaryTab==null){
		var err_msg=getMessage("CAUSE_OF_DEATH_MAND","MR");
		alert(err_msg);
		if(finalize_val=="Y"){
			document.getElementById("finalize_btn").disabled=false;
		}else if(finalize_val=="N"){
			document.getElementById("save_btn").disabled=false;
		}
		proceed=false;
		return false;
		}else{
			proceed=true
		}


 /*Checking For Female Patients Only*/
var preg_status="";
	  if(gender=='F'){
		  if(pregnant.checked==true){
			preg_status="P";
			gestational_unit=Otherdtl_Form_OBJ.unit_of_gest_nb_hid.value;
		}else if(preg_not_preg.checked==true){
			preg_status="N";
			preg_gestational_prd="";
			gestational_unit="";
		}else if(preg_dtls_unknown.checked==true){
			preg_status="U";
			preg_gestational_prd="";
			gestational_unit="";
			preg_deliver_wks="";
		}else{
			var err_msg=getMessage("PREGNANCY_DTLS_MAND","MR");
			alert(err_msg);
			if(finalize_val=="Y"){
				document.getElementById("finalize_btn").disabled=false;
			}else if(finalize_val=="N"){
				document.getElementById("save_btn").disabled=false;
			}
			return false;
//			preg_status="N";
//			preg_gestational_prd="";
//			gestational_unit="";
		}
	  }else{
		preg_status="";
		preg_gestational_prd="";
		gestational_unit="";
		preg_deliver_wks="";
	  }	


	/*alert(addl_field1.value)
	alert(addl_field2.value)
	alert(addl_field3.value)
	alert(addl_field4.value)
	alert(addl_field5.value)*/
//	alert(addl_field5)
/*	if(pregnant.value!='Y' || preg_dtls_unknown!='Y'){
		preg_not_preg.checked=true;
		preg_not_preg.value='Y';

		dlivr_wks_btn.style.visibility="visible";
		dlivr_wks_btn.style.display="inline";
		dlivr_wks_lbl.style.visibility="visible";
		dlivr_wks_lbl.style.display="inline";

		pregnant.checked=false;
		pregnant.value='N';
		pregnant.disabled=true;

		preg_dtls_unknown.checked=false;
		preg_dtls_unknown.value='N';
		preg_dtls_unknown.disabled=true;
	}*/
//	alert(proceed)
	if(proceed){
//		alert(preg_status)
		var primaryTab = parent.DR_DiagnosisDtl_Frame.document.getElementById("PrimaryTab");
		if(primaryTab!=null){
//			alert(primaryTab.rows.length)
			var temp_code			="";
			var primary_diag		="";
			var diag_onset_date	="";
			var diag_illnes_date  ="";
			for (var k=0;k<primaryTab.rows.length-1 ;k++){
				primary_diag = parent.DR_DiagnosisDtl_Frame.document.forms[0]["primary_chk" + k].value;
				diag_onset_date = parent.DR_DiagnosisDtl_Frame.document.forms[0]["onset_date_" + k].value;

				if(diag_onset_date==""){
					diag_onset_date="00";
				}
				
					temp_code=temp_code+primary_diag+"$"+diag_onset_date+"~";
			}
			temp_code=temp_code.substring(0,temp_code.length-1);
//			alert(temp_code)
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=SaveRecords&diag_codes="+encodeURIComponent(temp_code),false);
			xmlHttp.send(null);		
			responseText=trimString(xmlHttp.responseText);
		}
		var xmlHttp = new XMLHttpRequest();
				xmlHttp.open("POST","../../servlet/eMR.MDRServlet?patient_id="+patient_id+"&encounter_id="+encounter_id+"&attend_pract="+attend_pract+"&certify_pract="+certify_pract+"&designation="+designation+"&citizen_id_num="+citizen_id_num+"&brought_in_dead="+brought_in_dead+"&registration_no="+registration_no+"&deceased_date_time="+deceased_date_time+"&remarks="+encodeURIComponent(remarks)+"&mlc="+mlc+"&mlc_police_rept_no="+encodeURIComponent(mlc_police_rept_no)+"&mlc_police_station="+encodeURIComponent(mlc_police_station)+"&mlc_id="+encodeURIComponent(mlc_id)+"&Finalize="+finalize_val+"&mode="+mode.value+"&preg_status="+preg_status+"&preg_gestational_prd="+preg_gestational_prd+"&gestational_unit="+gestational_unit+"&preg_deliver_wks="+preg_deliver_wks+"&addl_field1="+encodeURIComponent(addl_field1)+"&addl_field2="+encodeURIComponent(addl_field2)+"&addl_field3="+encodeURIComponent(addl_field3)+"&addl_field4="+encodeURIComponent(addl_field4)+"&addl_field5="+encodeURIComponent(addl_field5),false);
				xmlHttp.send(null);		
				responseText=trimString(xmlHttp.responseText);
//				alert(responseText)
				/*var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" );
				xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
				xmlHttp.send(null);		
//				responseText=xmlHttp.responseText;*/
				var retnValue=responseText.split("~");
				var inserted=retnValue[0];
				var staus=retnValue[1];
				alert(inserted)
				if(staus=="RECORD_INSERTED"){					
					if(deathCerApplYn !=""){//Added by Rameswar  Against  HSA-SCF-0143.1 [IN:055069]
						printMDRCertificate();
					}
				}
//					alert(staus)
				
				
				const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			    dialogTag.close();
					/*parent.DR_HeaderDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterHeaderDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id.value+"&encounter_id="+encounter_id.value+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id.value+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I";
					parent.DR_DiagnosisDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id.value+"&encounter_id="+encounter_id.value+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id.value+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I";
					parent.DR_OtherDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterOthersDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id.value+"&encounter_id="+encounter_id.value+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id.value+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I";*/


	}

}
/**
	F.Y.I:
	1.The below two functions are commented for CRF CRF ADD-SRR20056-CRF-450.xls added on 1/8/2010 10:32 AM
*/
/*function paintValue(){
	var primaryTab		 = document.getElementById("PrimaryTab");
	var total_tr			 = document.getElementById("seq_no").value;
	var hid_illnes_date = trimString(document.getElementById("hid_illnes_date").value);
	if(total_tr!=0){
		if(total_tr==1){
			avg_rnd=0;
		}else {
			avg_rnd=1;
		}
	/*var avg_cnt=(total_tr+1)/2;
	var avg_rnd	=Math.round(avg_cnt);
		eval("document.getElementById("illnes_decease_date_")"+avg_rnd+"").innerHTML="<input type='text' value='"+hid_illnes_date+"' name='illnes_date' id='illnes_date' Readonly align='left' size='15' maxlength='15'>";
	}
}
function paintValueView(){
	var primaryTab		 = document.getElementById("PrimaryTab");
	var total_tr			 = document.getElementById("seq_no").value;
	var hid_illnes_date = trimString(document.forms[0].hid_illnes_date.value);
	if(total_tr!=0){
		if(total_tr==1){
			avg_rnd=0;
		}else {
			avg_rnd=1;
		}
		eval("document.getElementById("illnes_decease_date_")"+avg_rnd+"").innerHTML=hid_illnes_date;
	}
}*/

function buildGroups(obj){
//		alert(obj.value)
		var temp_code="";
		var proceed 	= new Boolean() ;
		proceed=true;

		var move_to_grp=document.DR_DiagnosisDtls_Form.move_to_grp.value;
		var mode=document.DR_DiagnosisDtls_Form.mode.value;
//		var temp_code=document.forms[0].temp_code.value
//			alert(temp_code)
		var chk_d=eval("document.forms[0].slctd_code");
		var genaralTab = document.getElementById("GenaralTab");
		var primaryTab = document.getElementById("PrimaryTab");
		var othersTab = document.getElementById("OthersTab");
		var max_pri_diag = document.getElementById("max_pri_diag").value;
		var max_oth_dis = document.getElementById("max_oth_dis").value;
		if(max_oth_dis==""){
			max_oth_dis=0;
		}
		var totalRecords1 =document.forms[0].totalRecords1.value;
//		alert(document.forms[0].totalRecords1.value)
		 /*parent.DR_HeaderDtl_Frame.document.forms[0].diag_totalRecords.value=totalRecords1;
		var diag_totalRecords =parent.DR_HeaderDtl_Frame.document.forms[0].diag_totalRecords.value;
		alert(diag_totalRecords)*/
		/*
			FYI:
			1.Making all the codes to single string from all the groups every time, and passing to Intermediate page.
		*/
	if(primaryTab!=null){
		for (var k=0;k<primaryTab.rows.length-1 ;k++){
			if (document.forms[0]["primary_chk" + k].checked){
				temp_code = temp_code + document.forms[0]["primary_chk" + k].value + "~";
			}
		}
	}
	if(othersTab!=null){
		for (var k=0;k<othersTab.rows.length-1 ;k++){
			if (document.forms[0]["others_chk" + k].checked)
{
				temp_code = temp_code + document.forms[0]["others_chk" + k].value + "~";

			}
		}
	}
	if(genaralTab!=null){
			for (var j=0;j<genaralTab.rows.length-1 ;j++){
			if (document.forms[0]["slctd_code" + j].checked== true) {
           temp_code = temp_code + document.forms[0]["slctd_code" + j].value + "~";
}

			}
		}
	}

		temp_code=temp_code.substring(0,temp_code.length-1);
//		alert(temp_code)
if(temp_code!=null && temp_code!=""){
		if(move_to_grp=="C"){
			var arr=new Array();
			var temp_code1=temp_code
			var temp_code2=temp_code1.split("~");
			var total_tr=parseInt(temp_code2.length);
			var primary_cnt=document.getElementById("seq_no").value;
			var primary_len=parseInt(temp_code2.length)+parseInt(primary_cnt)
//			alert(primary_len)
				if(max_pri_diag>=primary_len){
					proceed=true;
			}else{
					proceed=false;
					var err_msg=getMessage("MR_PARAM_SETUP","MR")
					alert(err_msg);
			}
		}else if(move_to_grp=="O"){
			var arr=new Array();
			var temp_code1=temp_code
			var temp_code2=temp_code1.split("~");
			var other_cnt=document.getElementById("other_cause_death").value;
//			alert(other_cnt)
			var other_len=parseInt(temp_code2.length)+parseInt(other_cnt)
				if(max_oth_dis>=other_len){
					proceed=true;
			}else{
					proceed=false;
					var err_msg=getMessage("MR_PARAM_SETUP","MR")
					alert(err_msg);
			}
		}

if(proceed){
	var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?diag_codes="+encodeURIComponent(temp_code)+"&move_to_grp="+move_to_grp+"&max_pri_diag="+max_pri_diag+"&max_oth_dis="+max_oth_dis,false);
		xmlHttp.send(null);		
		responseText=trimString(xmlHttp.responseText);
			/*if(responseText=="StopAdding"){
				alert("You cannot add diagnosis as per MR parameter limit.");
		}*/
}
		parent.DR_DiagnosisDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?patient_id="+document.forms[0].patient_id.value+"&encounter_id="+document.forms[0].encounter_id.value+"&practitioner_id="+document.forms[0].practitioner_id.value+"&practitioner_type="+document.forms[0].practitioner_type.value+"&modify_onsedt_YN=N"+"&mode="+mode+"&totalRecords="+totalRecords1+"&patient_class="+document.forms[0].patient_class.value;
	}
}
async function AddNewDiagnosis(patient_id,encounter_id,locn_code,gender,dob,speciality_code,episode_id,practitioner_id,practitioner_type,patient_class){
	var totalRecords1 =document.forms[0].totalRecords1.value;
	var facility_id		 =document.forms[0].facility_id.value;
	document.getElementById("newdiag_btn").disabled=true;
//	alert(totalRecords1)
	var dialogHeight="100vh";
	var dialogWidth="100vw";
	var dialogTop="10";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var title="";
	var max_pri_diag  = document.getElementById("max_pri_diag").value;
	var PrimaryTab	 = document.getElementById("seq_no").value
	if(max_pri_diag>PrimaryTab){
	var action_url="../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&Locn_Code="+locn_code+"&Sex="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&totalRecords="+totalRecords1+"&facility_id="+facility_id;
	var retVal=await top.window.showModalDialog(action_url,title,features);
//	alert("DeathRe==>" +retVal)
		if(retVal=="Y"){
		parent.DR_DiagnosisDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&Locn_Code="+locn_code+"&Sex="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&totalRecords="+totalRecords1+"&facility_id="+facility_id+"&increment_records=Y";
		}
			document.getElementById("newdiag_btn").disabled=false;
	}else{
			var err_msg=getMessage("MR_PARAM_SETUP_NEW_DIAG","MR")
			alert(err_msg);
			document.getElementById("newdiag_btn").disabled=false;
	}
}
function resetValues(){
	document.forms[0].clear_btn.disabled=true;
	if(confirm(getMessage("CLEAR_MDR_DTLS","MR"))){
			var	patient_id	 		=  parent.DR_HeaderDtl_Frame.document.forms[0].patient_id.value;
			var	encounter_id		=  parent.DR_HeaderDtl_Frame.document.forms[0].encounter_id.value;	
			var	locn_code			=  parent.DR_HeaderDtl_Frame.document.forms[0].locn_code.value;		
			var	gender				=  parent.DR_HeaderDtl_Frame.document.forms[0].gender.value;
			var	dob					=  parent.DR_HeaderDtl_Frame.document.forms[0].dob.value;
			var	speciality_code	=  parent.DR_HeaderDtl_Frame.document.forms[0].speciality_code.value;
			var	episode_id		=  parent.DR_HeaderDtl_Frame.document.forms[0].episode_id.value;
			var	practitioner_id	=  parent.DR_HeaderDtl_Frame.document.forms[0].practitioner_id.value;
			var	practitioner_type=  parent.DR_HeaderDtl_Frame.document.forms[0].practitioner_type.value;
			var	patient_class		  =  parent.DR_HeaderDtl_Frame.document.forms[0].patient_class.value;
			var	call_from			  =  parent.DR_HeaderDtl_Frame.document.forms[0].call_from.value;			
			var	episode_type	  =  parent.DR_HeaderDtl_Frame.document.forms[0].episode_type.value;	
			var	mode				  =  parent.DR_HeaderDtl_Frame.document.forms[0].mode.value;	
			var	finalize_yn				  =  parent.DR_HeaderDtl_Frame.document.forms[0].finalize_yn.value;	
			var	visit_adm_date				  =  parent.DR_HeaderDtl_Frame.document.forms[0].visit_adm_date.value;	

			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
			if(responseText){
				parent.DR_HeaderDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterHeaderDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&visit_adm_date="+visit_adm_date;
				parent.DR_DiagnosisDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&visit_adm_date="+visit_adm_date;
				parent.DR_OtherDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterOthersDtls.jsp?cause_of_death=Y&modal_yn=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&Locn_Code="+locn_code+"&gender="+gender+"&Dob="+dob+"&speciality_code="+speciality_code+"&episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&patient_class="+patient_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&visit_adm_date="+visit_adm_date;
					document.forms[0].clear_btn.disabled=false;
			}
		}else{
			document.forms[0].clear_btn.disabled=false;
	}
}
function showGestation(obj){
	if(obj.checked==true){
//		obj.value="P";
//		document.getElementById("gest_age").style.visibility="visible";
		document.getElementById("gest_age").style.display="inline"
//		document.getElementById("gest_age_txt").style.visibility="visible";
		document.getElementById("gest_age_txt").style.display="inline";
//		document.getElementById("preg_deliver_wks").disabled=false;
//		document.getElementById("dlivr_wks_btn").style.visibility="visible";
		document.getElementById("dlivr_wks_btn").style.display="inline";
//		document.getElementById("dlivr_wks_lbl").style.visibility="visible";
		document.getElementById("dlivr_wks_lbl").style.display="inline";

	}else{
//		obj.value="N";
		document.getElementById("gest_age").style.display="none"
		document.getElementById("preg_gestational_age").value="";
		document.getElementById("gest_age_txt").style.display="none";
		document.getElementById("dlivr_wks_btn").style.display="none";
		document.getElementById("dlivr_wks_lbl").style.display="none";

	}

}
function validate_duplicate_diag(Obj,indx){
	var sel_val=Obj.value;
	var prev_val="";
	var sec_obj="";
	var count_val=document.DR_DiagnosisDtls_Form.seq_no.value;
			if(count_val>1){
				for(ij=0;ij<count_val;ij++){
					var obj_seq= eval("document.forms[0].seqdiag"+ij);
					if(obj_seq.value==sel_val && obj_seq.name!= Obj.name){
						sec_obj=obj_seq;
						break;
					}
				}
				for(kk=1;kk<=count_val;kk++){
					var inx=kk;
					var cntr=0;
					for(ij=0;ij<count_val;ij++){
						var obj_seq= eval("document.forms[0].seqdiag"+ij);
						if(parseInt(obj_seq.value)==parseInt(kk)){
							cntr++;
						}
					}

					if(cntr==0){
						break;
					}
				}
			}
			sec_obj.value=(eval(inx));
}

function populateSeqNOs(){
	var count_val_diag=document.DR_DiagnosisDtls_Form.seq_no.value;
	for(ij=0;ij<count_val_diag;ij++){
		var obj_seq= eval("document.forms[0].seqdiag"+ij);
		for(k=1;k<=count_val_diag;k++){			
			var temp = k;
			var opt=document.createElement("OPTION");
			opt.text=temp;
			opt.value=temp;
			obj_seq.add(opt);					
		}
		obj_seq.options.selectedIndex=ij;
		obj_seq.value=eval(ij)+1;

	}
}

function sort(myTable){
	var primaryTab = document.getElementById("PrimaryTab");
	var temp_code			="";
	var seq_diag_no		="";
	var primary_diag		="";
	var diag_onset_date	="";
	var diag_illnes_date  ="";
	if(primaryTab!=null){
//			alert(primaryTab.rows.length)
		for (var k=0;k<primaryTab.rows.length-1 ;k++){
				seq_diag_no = document.forms[0]["seqdiag" + k].value;
				primary_diag = document.forms[0]["primary_chk" + k].value;
				diag_onset_date = document.forms[0]["onset_date_" + k].value;
//				diag_illnes_date	=	eval("document.forms[0].illnes_decease_date_"+k+"").value;
				if(diag_onset_date==""){
					diag_onset_date="00";
				}
				/*if(diag_illnes_date==""){
					diag_illnes_date="01";
				}*/
					temp_code=temp_code+seq_diag_no+"$"+primary_diag+"$"+diag_onset_date+"~";
			}
			temp_code=temp_code.substring(0,temp_code.length-1);
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=SEQUENCING&diag_codes="+encodeURIComponent(temp_code),false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
			parent.DR_DiagnosisDtl_Frame.location.href="../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?patient_id="+document.forms[0].patient_id.value+"&encounter_id="+document.forms[0].encounter_id.value+"&practitioner_id="+document.forms[0].practitioner_id.value+"&practitioner_type="+document.forms[0].practitioner_type.value+"&modify_onsedt_YN=Y"+"&patient_class="+document.forms[0].patient_class.value;
		}
	}
function getPractitionerId(obj,target){
		var facility_id					= document.forms[0].facilityId.value;
		var certify_pract_hidden	= document.forms[0].certify_pract_hidden.value;
		var attend_pract_hidden	= document.forms[0].attend_pract_hidden.value;
		if(target.name=='certify_pract_name'){
			if(target.value==certify_pract_hidden){
				return;
			}else{
				getPractitioner(obj, target,facility_id,"Q6");
			}
		}else if(target.name=='attend_pract_name'){
			if(target.value==attend_pract_hidden){
				return;
			}else{
				getPractitioner(obj, target,facility_id,"Q6");
			}
		}
}
function clearValues(){
	document.DR_HeaderDtls_Form.designation.value		 ="";
	document.DR_HeaderDtls_Form.citizen_id_num.value ="";
	document.DR_HeaderDtls_Form.registration_no.value ="";
}
function PractLookupRetVal(retVal,objName){
	var arr;
	var citizen_regis_no;
	if (retVal != null){
		arr=retVal.split("~");
//		alert(arr)
		if(objName=='certify_pract_name'){
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=CERTIFIED_PRACT_DETAILS&certified_pract_id="+arr[0],false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
//			alert(responseText)
			citizen_regis_no=responseText.split(",");
			document.DR_HeaderDtls_Form.certify_pract.value=arr[0];//Cretified Practitioner ID
			document.DR_HeaderDtls_Form.certify_pract_name.value=arr[1];//Certified Practitioner Name
			document.DR_HeaderDtls_Form.certify_pract_hidden.value=arr[1];//Certified Practitioner Name
			if(arr[5]=="&nbsp;"){
				designation="";
			}else{
				designation=arr[5];
			}
			document.DR_HeaderDtls_Form.designation.value=designation;//Certified Practioner Designation
			document.DR_HeaderDtls_Form.citizen_id_num.value=citizen_regis_no[0];//Certified Practitioner Citizen ID
			document.DR_HeaderDtls_Form.registration_no.value=citizen_regis_no[1];//Certified Registration Num
		}else{
			document.DR_HeaderDtls_Form.attend_pract.value=arr[0];//Attend Practitioner ID
			document.DR_HeaderDtls_Form.attend_pract_name.value=arr[1];//Attend Practitioner Name
			document.DR_HeaderDtls_Form.attend_pract_hidden.value=arr[1];//Attend Practitioner Name
		}
	}
	else{
		if(objName=='certify_pract_name'){
			document.DR_HeaderDtls_Form.certify_pract.value="";
			document.DR_HeaderDtls_Form.certify_pract_name.value="";
			document.DR_HeaderDtls_Form.designation.value="";
			document.DR_HeaderDtls_Form.citizen_id_num.value="";
			document.DR_HeaderDtls_Form.registration_no.value="";
		}else{			
			document.DR_HeaderDtls_Form.attend_pract.value="";             
			document.DR_HeaderDtls_Form.attend_pract_name.value="";
		}
	}

}
function validateLOS(obj){
	if(obj.checked==true){
		obj.value='Y'
		/*document.getElementById("id_year").style.visibility="hidden";
		document.getElementById("id_month").style.visibility="hidden";
		document.getElementById("id_hrs").style.visibility="hidden";
		document.getElementById("leng_year").style.visibility="hidden";
		document.getElementById("leng_mon").style.visibility="hidden";
		document.getElementById("leng_hrs").style.visibility="hidden";*/
		document.getElementById("id_year").style.display="none";
		document.getElementById("id_month").style.display="none";
		document.getElementById("id_hrs").style.display="none";
		document.getElementById("leng_year").style.display="none";
		document.getElementById("leng_mon").style.display="none";
		document.getElementById("leng_hrs").style.display="none";
		document.getElementById("id_year").value="";
		document.getElementById("id_month").value="";
		document.getElementById("id_day").value=0;
		document.getElementById("id_hrs").value="";
		document.getElementById("id_day").disabled=true;

	}else{
		obj.value='N'
		/*document.getElementById("id_year").style.visibility="visible";
		document.getElementById("id_month").style.visibility="visible";
		document.getElementById("id_hrs").style.visibility="visible";
		document.getElementById("leng_year").style.visibility="visible";
		document.getElementById("leng_mon").style.visibility="visible";
		document.getElementById("leng_hrs").style.visibility="visible";*/
		document.getElementById("id_year").style.display="inline";
		document.getElementById("id_month").style.display="inline";
		document.getElementById("id_hrs").style.display="inline";
		document.getElementById("leng_year").style.display="inline";
		document.getElementById("leng_mon").style.display="inline";
		document.getElementById("leng_hrs").style.display="inline";
		document.getElementById("id_day").value="";
		document.getElementById("id_day").disabled=false;
	}
}
function disableButons(){
	var finalize_yn		 = parent.DR_HeaderDtl_Frame.document.DR_HeaderDtls_Form.finalize_yn;
	var save_btn		= parent.DR_Button_Frame.document.getElementById("save_btn"); 
	var finalize_btn		= parent.DR_Button_Frame.document.getElementById("finalize_btn"); 
	var clear_btn		= parent.DR_Button_Frame.document.getElementById("clear_btn"); 
	var newdiag_btn	= parent.DR_DiagnosisDtl_Frame.document.getElementById("newdiag_btn"); 
	var seq_btn			= parent.DR_DiagnosisDtl_Frame.document.getElementById("seq_btn"); 
	var move_to_grp	= parent.DR_DiagnosisDtl_Frame.document.getElementById("move_to_grp"); 
//		parent.DR_HeaderDtl_Frame.document.forms[0].locn_code.value	
	if(finalize_yn.value=="Y"){
		parent.DR_Button_Frame.document.getElementById("save_btn").style.display="none";
		parent.DR_Button_Frame.document.getElementById("finalize_btn").style.display="none";
		parent.DR_Button_Frame.document.getElementById("clear_btn").style.display="none";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("newdiag_btn").style.display="none";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("seq_btn").style.display="none";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("move_to_grp").style.display="none";
	}else{
		parent.DR_Button_Frame.document.getElementById("save_btn").display="inline";
		parent.DR_Button_Frame.document.getElementById("finalize_btn").style.display="inline";
		parent.DR_Button_Frame.document.getElementById("clear_btn").style.display="inline";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("newdiag_btn").style.display="inline";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("seq_btn").style.display="inline";
		parent.DR_DiagnosisDtl_Frame.document.getElementById("move_to_grp").style.display="inline";
	}
}
		function validateDatetime(obj,obj2,place_holder) {
			var from = obj.value;
			var proceed=true;
			if(!from==""){
				var to   = document.forms[0].currentdate.value;
//				var greg_todate = convertDate(to,"DMYHM",document.forms[0].locale.value,"en");
				var fromdateTime			 = convertDate(from,"DMYHM",document.forms[0].locale.value,"en");
				var currentDateTime		 = getCurrentDate("DMYHM",document.forms[0].locale.value);
				var todateTime				 = convertDate(currentDateTime,"DMYHM",document.forms[0].locale.value,"en");

				var fromarray;
				var toarray;
				var frmdt=from.split(" ");
				document.forms[0].dumy_onset.value=frmdt[0];
				if(!frmdt[1]==""){
					from=frmdt[0];				
					fromarray  = from.split("/");
					toarray    = to.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(validDateObj(obj,"DMYHM",document.forms[0].locale.value)){
					if(doDateTimeChk(fromdateTime)){
//						alert(isBefore(fromdateTime,todateTime,'DMYHM',document.forms[0].locale.value))
						if(!isBefore(fromdateTime,todateTime,'DMYHM',"en")){// DateUtils.js
//							if(Date.parse(todt) < Date.parse(fromdt)) {
								var invaldt = getMessage("MRDATE1_GT_DATE2",'MR') ;
								var census_date_from=obj2;
								var sys_date=getLabel("Common.SystemDate.label","Common");
								invaldt=invaldt.replace('$',census_date_from);
								invaldt=invaldt.replace('#',sys_date);
								alert(invaldt);
								obj.value='';
								obj.focus();
								var duration_of_illness	=eval("document.forms[0].duration_of_illnes_"+place_holder+" ");
								duration_of_illness.value='';
								proceed=false;
							}
					}else{        
						alert(getMessage("INVALID_DATE_FMT", "SM"));
						obj.select();
						obj.focus();
						var duration_of_illness	=eval("document.forms[0].duration_of_illnes_"+place_holder+" ");
						duration_of_illness.value='';
						proceed=false;
					}
				}else{        
						obj.select();
						obj.focus();
						var duration_of_illness	=eval("document.forms[0].duration_of_illnes_"+place_holder+" ");
						duration_of_illness.value='';
						proceed=false;
					}
					/*if (CheckDate(obj)){
						if(Date.parse(todt) < Date.parse(fromdt)) {
							var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
							var census_date_from=obj2;
							var sys_date=getLabel("Common.CurrentDate.label","Common");
							invaldt=invaldt.replace('$',census_date_from);
							invaldt=invaldt.replace('#',sys_date);
							alert(invaldt);
							obj.value='';
							obj.focus();
							
						}
					}*/
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
					obj.focus();
					proceed=false;
				}
			}
			if(proceed){
				caluculateDOI(place_holder)
			}
		}
function checkgestationVal(obj){
	if (obj.value>=40){
		alert("Gestation age will be less than 40 weeks.");
	}
	return false;
}
function caluculateDOI(place_holder){
	/* 
		F.Y.I:
		1.This function was modified for dispaly duration of illness to aganist each diagnosis in only SAVE mode.
		2.For a gap CRF ADD-SRR20056-CRF-450.xls Modified On 1/7/2010.
	*/

	var primaryTab = document.getElementById("PrimaryTab");
	var temp_code			  ="";
	var diag_onset_date	  ="";
	var illnes_date			  ="";
	var duration_of_illnes_date ="";
	if(primaryTab!=null){
			diag_onset_date	=	eval("document.forms[0].onset_date_"+place_holder+"").value;
			if(diag_onset_date!=""){
			temp_code=diag_onset_date;
			}
			var xmlHttp = new XMLHttpRequest();
			if(temp_code!=""){	
					xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=CALCULATEDOI&diag_onset_dates="+encodeURIComponent(temp_code),false);
					xmlHttp.send(null);		
					responseText=trimString(xmlHttp.responseText);
					illnes_date=responseText;

			}
				duration_of_illnes_date				=	eval("document.forms[0].duration_of_illnes_"+place_holder+"");
				duration_of_illnes_date.value	=	illnes_date
//				document.forms[0].illnes_date_k.value=illnes_date
		}

}
function validateMinMax(obj,min_value,max_value,curr_value) //Function to validate the minimum and maximum values with the current values for gestation, birth weight, length , height and chest circumference.  
{	
	if(obj.value != "") {		
		var str = "";
//		if(min_value==0) min_value="";
//		if(max_value==0) max_value="";
		if ((parseFloat(curr_value.value) < parseFloat(min_value)) || (parseFloat(curr_value.value) > parseFloat(max_value)))	{
				str = getMessage("RANGE_CHK_FOR_MIN_MAX","MP");		
				str = str.replace('$', min_value);
				str = str.replace('@', max_value);
				alert(str);
				//obj.select();
				obj.value='';
				obj.focus();				
					
		}
	}
}
/*Printing Of Death Register Certificate added On 9/22/2009*/
async function printMDRCertificate(){
	var	patient_id	 		=  parent.DR_HeaderDtl_Frame.document.forms[0].patient_id.value;
	var	encounter_id		=  parent.DR_HeaderDtl_Frame.document.forms[0].encounter_id.value;	
	var	facility_id			=  parent.DR_HeaderDtl_Frame.document.forms[0].facilityId.value;	
	var	function_id		=  "MAINTAIN_DEATH_REGISTER";	

	var sqlString ="select report_id, report_desc,1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID ='MRDTHCER' ";
	var reportParamNames = "p_encounter_id,p_facility_id,p_patient_id";
	var reportParamValues = ""+encounter_id+","+facility_id+","+patient_id+"";
//	alert(reportParamNames)
//	alert(reportParamValues)
	
	var dialogHeight	= "25vh";
	var dialogWidth	= "65vw";
	var dialogTop		= "58";
	var arguments		=	"";
	var getUrl		=	"../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+encodeURIComponent(sqlString)+"&reportParamNames="+encodeURIComponent(reportParamNames)+"&reportParamValues="+encodeURIComponent(reportParamValues)+"&p_encounter_id="+encounter_id+"&Patient_ID="+patient_id+"&P_function_id="+function_id+"&p_facility_id="+facility_id;
	var features = "dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+"; status=no;";
	retVal = await window.showModalDialog(getUrl,arguments,features);
}

function printMDRCertificate1(){  
	var	patient_id	 		=  parent.DR_HeaderDtl_Frame.document.forms[0].patient_id.value;
	var	encounter_id		=  parent.DR_HeaderDtl_Frame.document.forms[0].encounter_id.value;	
	var	facility_id			=  parent.DR_HeaderDtl_Frame.document.forms[0].facilityId.value;	
	var	function_id		=  "MAINTAIN_DEATH_REGISTER";	


		
	var sqlString ="select report_id, report_desc,1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID ='MRDTHCER' ";
	var reportParamNames = "p_encounter_id,p_facility_id,p_patient_id";
	var reportParamValues = ""+encounter_id+","+facility_id+","+patient_id+"";

print_yn = confirm(getMessage("PRINT_DEATH_CERT","MR"));
if(print_yn){
parent.frames[5].location.href ="../../eMR/jsp/MDRCertificate.jsp?sqlString="+encodeURIComponent(sqlString)+"&reportParamNames="+encodeURIComponent(reportParamNames)+"&reportParamValues="+encodeURIComponent(reportParamValues)+"&p_encounter_id="+encounter_id+"&Patient_ID="+patient_id+"&P_function_id="+function_id+"&first_time_only=Y&p_module_id=MR&p_facility_id="+facility_id+"";
}  
}


function doCheck(event){
    var strCheck = '""';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}

function diableFilelds(){
	if(document.DR_HeaderDtls_Form){
		var finalize=document.DR_HeaderDtls_Form.finalize_yn.value;
	}
	if(finalize=='Y'){
		if(document.DR_HeaderDtls_Form){
			for(count=0;count<document.DR_HeaderDtls_Form.elements.length;count++){
			if(document.DR_HeaderDtls_Form.elements[count].type=="text" || document.DR_HeaderDtls_Form.elements[count].type=="button" || document.DR_HeaderDtls_Form.elements[count].type=="select-one" || document.DR_HeaderDtls_Form.elements[count].type=="checkbox" || document.DR_HeaderDtls_Form.elements[count].type=="image"){
			document.DR_HeaderDtls_Form.elements[count].disabled=true;
			}
		}
	}
	}
}

function diableFilelds3(){
var finalize;
	 finalize=document.DR_OtherDtls_Form.finalize_yn.value;
if(finalize=="Y"){
		if(document.DR_OtherDtls_Form){
			for(count=0;count<document.DR_OtherDtls_Form.elements.length;count++){
			if(document.DR_OtherDtls_Form.elements[count].type=="text" || document.DR_OtherDtls_Form.elements[count].type=="button" || document.DR_OtherDtls_Form.elements[count].type=="select-one" || document.DR_OtherDtls_Form.elements[count].type=="checkbox" || document.DR_OtherDtls_Form.elements[count].type=="radio" ||document.DR_OtherDtls_Form.elements[count].type=="image"){
			document.DR_OtherDtls_Form.elements[count].disabled=true;
			}
		}
	  }
	}
}

function checkMaxLen(obj)
{
	if (obj.value.length>200)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
		error = error.replace("$",getLabel("Common.remarks.label","Common"));
		error = error.replace("#","200");
		alert(error)
		obj.focus();
	}
}
function closeWindow(){
	var xmlHttp 	= new XMLHttpRequest();
	xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
	xmlHttp.send(null);		
	responseText=xmlHttp.responseText;
	//window.close();
	 const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	    dialogTag.close();
}
function enableMLCDtls(obj){
	if(obj.checked==true){
		document.forms[0].mlc_police_rept_no.disabled=false;
		document.forms[0].mlc_police_station.disabled=false;
		document.forms[0].mlc_id.disabled=false;
	}else{
		document.forms[0].mlc_police_rept_no.disabled=true;
		document.forms[0].mlc_police_station.disabled=true;
		document.forms[0].mlc_id.disabled=true;
		document.forms[0].mlc_police_rept_no.value="";
		document.forms[0].mlc_police_station.value="";
		document.forms[0].mlc_id.value="";
	}
}


