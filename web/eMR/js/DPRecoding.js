var gmyWin = null; //Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272

async function show_clinic_his(obj){ 
	var Pat_id		= parent.frames[2].document.forms[0].Pat_id.value;
	var fac_id			= parent.frames[2].document.forms[0].facility_id.value;
	var enc_id		= parent.frames[2].document.forms[0].EncounterId.value;
	//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
	var accession_num = parent.frames[2].document.forms[0].accession_num.value; 
	var dischargeSummary = parent.frames[2].document.forms[0].dischargeSummary.value; 
	
	document.getElementById("tooltiplayer").style.visibility = 'hidden';

	var title="";
	var retVal =    new String();
	var dialogHeight= "95vh" ;
	var dialogWidth = "97vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	if(obj=='VCH'){
		retVal = await window.showModalDialog("../../eMR/jsp/DPRecodingViewClinicHistFrame.jsp?patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}else if(obj=='PBL'){
		retVal = await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}else if(obj=='PCL'){
		retVal = await window.showModalDialog("../../eMR/jsp/DPRecodingViewProcListFrame.jsp?modal_yn=Y&called_mod=&patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}else  if(obj=='DP'){
		retVal =await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?called_frm=Dispense&mode=Q&patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}else  if(obj=='VA'){	
		retVal =await window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}else if(obj=='VCN'){
		retVal =await window.showModalDialog("../../eCA/jsp/ViewClinicalNoteMain.jsp?option_id=PHYSICIAN_NOTES1&patient_id="+Pat_id+"&encounter_id="+enc_id, arguments, features);
	}
	//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
	else if(obj=='DS' && dischargeSummary == 'true'){

		gmyWin = myOpenWindow(accession_num,arguments,features,gmyWin);
	
	}
	if(retVal==undefined){
		document.getElementById('tooltiplayer').style.visibility = 'hidden'
	}
}






function enable_mrk_err(p_cd1,p_cd2,p_type,tm_st){
	parent.parent.frames[4].document.forms[0].error.disabled=false;
	var err	= getMessage('MR_ACT_DIAG_PROC_MRK_ERR','MR');

	if(p_type=='P'){
		err=err.replace('$','Procedure code')
		err=err.replace('$',p_cd1)
		err=err.replace('$','Procedure code')
		err=err.replace('$',p_cd2)
		alert(err);
	}else{
		err=err.replace('$','Diagnosis code')
		err=err.replace('$',p_cd1)
		err=err.replace('$','Diagnosis code')
		err=err.replace('$',p_cd2)
		alert(err);
	}

	parent.frames[4].location.href="../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+parent.frames[4].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[4].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[4].document.forms[0].EncounterId.value+"&dflt_termset="+tm_st+"&Patient_Class="+parent.frames[4].document.forms[0].Patient_Class.value+"&execute_hdr_qry=Y";


}

function enable_auth(){
	if(parent.parent.frames[4].document.forms[0].authorize){
		parent.parent.frames[4].document.forms[0].authorize.disabled=false;
	}
	if(parent.parent.frames[4].document.forms[0].reject){
		parent.parent.frames[4].document.forms[0].reject.disabled=false;
	}
	parent.frames[4].location.href ="./../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+parent.frames[2].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&execute_hdr_qry=Y";
}

function showEncounter_new(indx){
	//var enc1=eval("parent.frames[1].document.forms[0].all.enc1"+i).value;
	if(parent.frames[1].document.getElementById("dispenc"+indx) != null){
		parent.frames[1].document.getElementById("dispenc"+indx).style.display = "inline";
		parent.frames[1].document.getElementById("dispenc"+indx).style.visibility = "visible";
		var patName=parent.frames[1].document.getElementById("Pat_name"+indx).value;
		var obj= parent.frames[1].document.getElementById("encSymbol"+indx);
		obj.innerHTML="<a href='javascript:onclick=collapseEncounter_new("+indx+")'>-</a>&nbsp;&nbsp;"+patName;
		//<a href='javascript:onclick=changePline("+indx+",parent.frames[1].document.forms[0].all.facility_id.value)'></a>"+patName;
	}
	parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
}


function collapseEncounter_new(indx){
		parent.frames[1].document.getElementById("dispenc"+indx).style.display = "none";
		parent.frames[1].document.getElementById("dispenc"+indx).style.visibility = "hidden";
		var patName=parent.frames[1].document.getElementById("Pat_name"+indx).value;
		var obj=parent.frames[1].document.getElementById("encSymbol"+indx);
		obj.innerHTML="<a href='javascript:onclick=showEncounter_new("+indx+")'>+</a>&nbsp;&nbsp;"+patName;
		//<a href='javascript:onclick=changePline("+indx+",parent.frames[1].document.forms[0].all.facility_id.value)'></a>"+patName;

		parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function Original_Diag(){
	
		
		parent.frames[2].document.forms[0].Reject_Diag.disabled=true;
//		parent.RecodeScreen.rows="47%,47%,5%,0%";
		var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
		var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
//		parent.RecodeScreen.rows="47%,47%,5%,0%";
		
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="48%,48%,4%,0%";
		}else if(allow_recode_diag_yn=="Y"){
			parent.RecodeScreen.rows="95%,0%,5%,0%";
		}else if(allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="10%,85%,5%,0%";
		}

		parent.frames[4].document.forms[0].activity.value="RejectDiagnosis";
		parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
		parent.frames[4].document.forms[0].target="messageFrame";
		parent.frames[4].document.forms[0].submit();

}

function Original_Proc(){
	
		
		parent.frames[2].document.forms[0].Reject_Proc.disabled=true;
		var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
		var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
//		parent.RecodeScreen.rows="47%,47%,5%,0%";
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="48%,48%,4%,0%";
		}else if(allow_recode_diag_yn=="Y"){
			parent.RecodeScreen.rows="95%,0%,5%,0%";
		}else if(allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="10%,85%,5%,0%";
		}
		parent.frames[4].document.forms[0].activity.value="RejectProcedure";
		parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
		parent.frames[4].document.forms[0].target="messageFrame";
		parent.frames[4].document.forms[0].submit();

}

function Save_DRG(){
	
		parent.parent.frames[5].document.forms[0].Save.disabled=true;
		
		//parent.RecodeScreen.rows="47%,47%,5%,0%";

		parent.parent.frames[5].document.forms[0].activity.value="SaveDRG";
		parent.frames[5].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
		parent.frames[5].document.forms[0].target="messageFrame";
		parent.frames[5].document.forms[0].submit();

}


function open_Print(pVal,pSucc){
		if(pSucc=='N'){
			if(parent.frames[4].document.forms[0].calDRG)
				parent.frames[4].document.forms[0].calDRG.disabled=false;
			if(parent.frames[4].document.forms[0].seqDrg)
				parent.frames[4].document.forms[0].seqDrg.disabled=true;
			if(parent.frames[4].document.forms[0].reject)
				parent.frames[4].document.forms[0].reject.disabled=true;

			//Open_DRG();
			setTimeout("Open_DRG()",500);

		}
		if (pVal=='N' && pSucc=='Y'){
			  //p_language_id=locale;
			var err	= getMessage("RECORD_INSERTED","SM");
			alert(err) ;

			//Open_DRG();
			setTimeout("Open_DRG()",500);

			//parent.parent.frames[5].document.forms[0].activity.value="OpenReport";
			//parent.frames[5].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
			//parent.frames[5].document.forms[0].target="messageFrame";
			//parent.frames[5].document.forms[0].submit();
		}
}
/*
F.Y.I: The following function was removed  for enhancement of DRG and mot using any where.
The Error and Warn messages are getting from the Procedure(SQL) it self.
on 10/19/2009.
*/
function display_desc(err){
		if(err!=''){
			var msg='';
			var msg_str="MR_DRG_ERR"+err;

			msg=getMessage(msg_str,'MR');
			msg=msg.substring(11,msg.length);

			if(parent.parent.frames[5].document.forms[0].drg_error_desc)
				parent.parent.frames[5].document.forms[0].drg_error_desc.value= msg;
		}
}

function onSuccess()
{

	var stage_no=parent.parent.frames[1].document.forms[0].stage_no.value;
	var enc_val=parent.parent.frames[1].document.forms[0].enc_val.value;
	var finalSelect1=parent.parent.frames[1].document.forms[0].finalSelect.value;
	var dflt_termset=parent.parent.frames[1].document.forms[0].dflt_termset.value;
	var Patient_Class=parent.parent.frames[1].document.forms[0].Patient_Class.value;
	var pat_temp=parent.parent.frames[1].document.forms[0].pat_temp.value;
	var enc_temp=parent.parent.frames[1].document.forms[0].enc_temp.value;
	
	parent.parent.frames[1].location.href="../eMR/jsp/DPRecodingPatDetail.jsp?stage_no="+stage_no+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp;
}

function onSuccess_DRG()
{

	var stage_no=parent.parent.frames[1].document.forms[0].stage_no.value;
	var enc_val=parent.parent.frames[1].document.forms[0].enc_val.value;
	var finalSelect1=parent.parent.frames[1].document.forms[0].finalSelect.value;
	var dflt_termset=parent.parent.frames[1].document.forms[0].dflt_termset.value;
	var Patient_Class=parent.parent.frames[1].document.forms[0].Patient_Class.value;
	var pat_temp=parent.parent.frames[1].document.forms[0].pat_temp.value;
	var enc_temp=parent.parent.frames[1].document.forms[0].enc_temp.value;
	
	parent.parent.frames[1].location.href="../eMR/jsp/DPRecodingPatDetail.jsp?stage_no="+stage_no+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp;
	
	
	//Open_DRG();
	setTimeout("Open_DRG()",500);
}



function onSuccess_Auth(p_Class,drg_yn) {

	if(p_Class== 'IP' && drg_yn=='Y'){

		

		
		parent.frames[4].document.forms[0].activity.value="Authorize";
		parent.frames[4].document.forms[0].action="../../servlet/eMR.DRGCalculationServlet";
		parent.frames[4].document.forms[0].target="messageFrame";
		parent.frames[4].document.forms[0].submit();

		var allow_recode_diag_yn	=parent.frames[4].document.forms[0].allow_recode_diag_yn.value;
		var allow_recode_proc_yn	=parent.frames[4].document.forms[0].allow_recode_proc_yn.value;
//		parent.RecodeScreen.rows="47%,47%,5%,0%";
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="48%,48%,4%,0%";
		}else if(allow_recode_diag_yn=="Y"){
			parent.RecodeScreen.rows="95%,0%,5%,0%";
		}else if(allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="10%,85%,5%,0%";
		}		
		
		//parent.frames[6].location.href = "../eCommon/jsp/MstCodeError.jsp?err_num=Processing DRG. Please wait";
	}else{
		var stage_no=parent.parent.frames[1].document.forms[0].stage_no.value;
		var enc_val=parent.parent.frames[1].document.forms[0].enc_val.value;
		var finalSelect1=parent.parent.frames[1].document.forms[0].finalSelect.value;
		var dflt_termset=parent.parent.frames[1].document.forms[0].dflt_termset.value;
		var Patient_Class=parent.parent.frames[1].document.forms[0].Patient_Class.value;
		var pat_temp=parent.parent.frames[1].document.forms[0].pat_temp.value;
		var enc_temp=parent.parent.frames[1].document.forms[0].enc_temp.value;
		
		parent.parent.frames[1].location.href="../eMR/jsp/DPRecodingPatDetail.jsp?stage_no="+stage_no+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp;
	}		
	
}

function recodeScreen(){

			parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
			var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
			var confirm_appl = parent.frames[4].document.forms[0].confirm_appl.value; // added by mujafar for ML-MMOH-CRF-0878
			var temp_code = parent.frames[2].document.forms[0].temp_code.value;
			var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
			var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
			var gender = parent.frames[2].document.forms[0].gender.value;
			var age = parent.frames[2].document.forms[0].age.value;
			var dob = parent.frames[2].document.forms[0].dob.value;
			var spec_code = parent.frames[2].document.forms[0].spec_code.value;
			var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
			var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
			var caused_death = parent.frames[2].document.forms[0].caused_death.value;
			var hd_term_code = parent.frames[2].document.forms[0].hd_term_code.value;
			var chk_yn = parent.frames[2].document.getElementById('chk_yn').value;

			


			var recode_status = "RECODED";
			/*
				F.Y.I:
				1.This pat_visit_dt_time is passed DPRecodingAddModify.jsp only in Case of   Procedure Recoding.
				2.For Diagnosis it was not passed.
				*/
					var pat_visit_dt_time = "";//Added For SRR-CRF-303.1 on 12/11/2009
					var pat_disch_dt_time = "";//Added For SRR-CRF-303.1 on 12/11/2009
					var temp_proc	= parent.frames[3].document.forms[0].temp_proc.value;
					var procedure_yn	=parent.frames[3].document.forms[0].procedure_yn.value;
					if(temp_proc=="" && temp_code =="" ){
						alert(getMessage('SEL_DIAG_PROC','MR'));

							return false;
					}else if (temp_proc!="" && temp_code !="" ){
							alert(getMessage('DIAG_PROC_RECD','MR'));
							return false;
					}else if(temp_proc != '' && temp_proc!=null && procedure_yn == "Y"){
//									parent.RecodeScreen.rows="35%,25%,5%,*";
								var allow_recode_diag_yn=parent.frames[3].document.getElementById('allow_recode_diag_yn').value;
								var allow_recode_proc_yn=parent.frames[3].document.getElementById('allow_recode_proc_yn').value;
								pat_visit_dt_time=parent.frames[3].document.getElementById('pat_visit_dt_time').value;
								pat_disch_dt_time=parent.frames[3].document.getElementById('pat_disch_dt_time').value;
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			//parent.RecodeScreen.rows="35%,25%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="25vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="20vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}else if(allow_recode_proc_yn=="Y"){
			//parent.RecodeScreen.rows="5%,40%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="25vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="20vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}
		var tmp=parent.frames[3].document.forms[0].temp_proc.value;
		var temp_val=parent.frames[3].document.forms[0].temp_proc.value;
		var DB_Recode_Stages="";
		var DB_Recode_Status="";
		var DB_Recode_Grpvals="";
		var db_contr_mod_id	 ="";
		var db_code_extn_yn	 ="";
		var flg="Y";
		if(temp_val!=''){
			temp_arr=temp_val.split("~");
			for( i=0;i<temp_arr.length-1;i++){
				var in_arr=temp_arr[i].split("$");
				var trm_cd=in_arr[3];
				DB_Recode_Stages=DB_Recode_Stages+""+in_arr[6]+",";
				DB_Recode_Status=DB_Recode_Status+""+in_arr[5]+",";
				DB_Recode_Grpvals=DB_Recode_Grpvals+""+in_arr[7]+",";
//												db_contr_mod_id=db_contr_mod_id+""+in_arr[10]+",";
//												db_code_extn_yn=db_code_extn_yn+""+in_arr[11]+",";
				//if(trm_cd=="NEWCODE" || trm_cd=="ERROR"){
						//flg="N";
						//break;
					//}
				
			}
			DB_Recode_Stages		= DB_Recode_Stages.substring(0,DB_Recode_Stages.length-1);
			DB_Recode_Status		= DB_Recode_Status.substring(0,DB_Recode_Status.length-1);
			DB_Recode_Grpvals	= DB_Recode_Grpvals.substring(0,DB_Recode_Grpvals.length-1);
			db_contr_mod_id			= db_contr_mod_id.substring(0,db_contr_mod_id.length-1);
			db_code_extn_yn			= db_code_extn_yn.substring(0,db_code_extn_yn.length-1);
		}
										
									//if(flg == "Y")	{
//										parent.RecodeScreen.rows="35%,25%,5%,*";
										
	                                     /* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
										parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?confirm_appl="+confirm_appl+"&procedure_yn="+parent.frames[3].document.getElementById('procedure_yn').value+"&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&temp_code="+encodeURIComponent(parent.frames[3].document.getElementById('temp_proc').value)+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code+"&chk_yn="+chk_yn+"&DB_Recode_Stages="+DB_Recode_Stages+"&DB_Recode_Status="+DB_Recode_Status+"&DB_Recode_Grpvals="+DB_Recode_Grpvals+"&pat_visit_dt_time="+pat_visit_dt_time+"&pat_disch_dt_time="+pat_disch_dt_time+"&specialty_code="+parent.frames[2].document.forms[0].specialty_code.value;
										//  modified by mujafar for ML-MMOH-CRF-0878
									//}else{
										//alert('New code/Error cannot be recoded.');
									//}

	}else if(temp_code!= '' && temp_code!=null){
		var hold_arr = new Array();
		if(temp_code != ""){
	//						var tmp=parent.frames[2].document.forms[0].temp_code.value;
	//						var temp_val=parent.frames[2].document.forms[0].temp_code.value;
										var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
										var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
			if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			//	parent.RecodeScreen.rows="35%,25%,5%,*";
				parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="25vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
				parent.document.getElementById("DiagProcTrans").style.height="20vh";
				//parent.document.getElementById("DiagProcTrans").style.width="75vh";
				parent.document.getElementById("DiagProcTrans").style.display="inline";
	
			}else if(allow_recode_diag_yn=="Y"){
				//parent.RecodeScreen.rows="50%,0%,5%,*";
				parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="25vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
				parent.document.getElementById("DiagProcTrans").style.height="20vh";
				//parent.document.getElementById("DiagProcTrans").style.width="75vh";
				parent.document.getElementById("DiagProcTrans").style.display="inline";
	
			}
			var tmp=temp_code;
			var temp_val=temp_code;
			var DB_Recode_Stages="";
			var DB_Recode_Status="";
			var DB_Recode_Grpvals="";
			var flg="Y";
											
			if(temp_val!=''){
				temp_arr=temp_val.split("~");
				for( i=0;i<temp_arr.length-1;i++){
					var in_arr=temp_arr[i].split("$");
					var trm_cd=in_arr[3];
					hold_arr[i]=in_arr[1];
					DB_Recode_Stages=DB_Recode_Stages+""+in_arr[6]+",";
					DB_Recode_Status=DB_Recode_Status+""+in_arr[5]+",";
					DB_Recode_Grpvals=DB_Recode_Grpvals+""+in_arr[7]+",";
					//if(trm_cd=="NEWCODE" || trm_cd=="ERROR"){
						//	flg="N";
						//	break;
						//}
					
				}
				DB_Recode_Stages	=DB_Recode_Stages.substring(0,DB_Recode_Stages.length-1);
				DB_Recode_Status	=DB_Recode_Status.substring(0,DB_Recode_Status.length-1);
				DB_Recode_Grpvals	=DB_Recode_Grpvals.substring(0,DB_Recode_Grpvals.length-1);					
			}
											
			var prin_diag_yn='Y';
														
			if(parent.frames[2].document.forms[0].principal_diag.value!=''){											
				for( p=0;p<hold_arr.length;p++){											
					if(hold_arr[p]==parent.frames[2].document.forms[0].principal_diag.value){
						prin_diag_yn='N';
					}													
				}												
			}else{
				prin_diag_yn='N'
			}
			//if(flg == "Y")	{ 
//											parent.RecodeScreen.rows="35%,25%,5%,*";
           /* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
		   
			parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?confirm_appl="+confirm_appl+"&stage_no="+stage_no+"&temp_code="+encodeURIComponent(temp_code)+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code+"&chk_yn="+chk_yn+"&DB_Recode_Stages="+DB_Recode_Stages+"&DB_Recode_Status="+DB_Recode_Status+"&DB_Recode_Grpvals="+DB_Recode_Grpvals+"&prin_diag="+prin_diag_yn+"&specialty_code="+parent.frames[2].document.forms[0].specialty_code.value+"&isMultiDescAppl="+parent.frames[2].document.forms[0].isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281
			// modified by mujafar for ML-MMOH-CRF-0878


			//}else{
				//alert('New code/Error cannot be recoded.');
			//}
		}/*else{
			parent.RecodeScreen.rows="47%,47%,5%,0%";
			alert('Please select any checkbox..');
		}*/
	}			
}

function resetAddModify()
{
		var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
		var temp_code = parent.frames[2].document.forms[0].temp_code.value;
		var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
		var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
		var gender = parent.frames[2].document.forms[0].gender.value;
		var age = parent.frames[2].document.forms[0].age.value;
		var dob = parent.frames[2].document.forms[0].dob.value;
		var spec_code = parent.frames[2].document.forms[0].spec_code.value;
		var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
		var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
		var newCode_yn = parent.frames[5].document.forms[0].newCode_yn.value;
		if(parent.frames[5].document.forms[0]){
			parent.frames[5].document.forms[0].reset();
		}
	/*if(newCode_yn == 'Y'){
		if(parent.frames[5].document.forms[0].procedure_yn.value == 'Y'){
				parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?newCode_yn="+newCode_yn+"&procedure_yn="+parent.frames[5].document.getElementById("procedure_yn").value+"&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&temp_code="+parent.frames[3].document.getElementById("temp_proc").value+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;

		}else{
					parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?newCode_yn="+newCode_yn+"&procedure_yn="+parent.frames[5].document.getElementById("procedure_yn").value+"&stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;
		}
	}else{
		if(parent.frames[5].document.forms[0].procedure_yn.value == 'Y'){
				parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?procedure_yn="+parent.frames[5].document.getElementById("procedure_yn").value+"&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&temp_code="+parent.frames[3].document.getElementById("temp_proc").value+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;
		}
		else
		{
			parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;
		}
	}*/
}
var free_text_cnt=0;
var term_set_cnt=0;
function enableSelect1(m,obj,term_code1,dagger_independent_yn,mode){	
	var count1 = document.forms[0].i.value;
	var final_diag_values	= parent.frames[2].document.forms[0].final_diag_values.value;
	var diag_tset				= parent.frames[4].document.forms[0].rec_diag_tset.value;
	
	var k = 0;
	if(mode=='Modify'){
		parent.frames[2].document.forms[0].modify_temp_code.value='';
		parent.frames[2].document.forms[0].checked_yn.value="Y";
		if(document.forms[0].temp_chk.value == "Y")	{
			parent.frames[2].document.forms[0].modify_temp_code.value=parent.frames[2].document.forms[0].modify_temp_code.value+obj.value;
		}else{
				parent.frames[2].document.forms[0].modify_temp_code.value=obj.value;
		}
		parent.frames[2].document.forms[0].temp_chk.value="Y";
			diagClassModification(mode,dagger_independent_yn)
			
			
	}else{
			if (obj.checked == true ){
					parent.frames[2].document.forms[0].checked_yn.value="Y";
					if(document.forms[0].temp_chk.value == "Y")	{
						parent.frames[2].document.forms[0].temp_code.value=parent.frames[2].document.forms[0].temp_code.value+obj.value;
					}else{
							parent.frames[2].document.forms[0].temp_code.value=obj.value;
					}
					parent.frames[2].document.forms[0].temp_chk.value="Y";
//					var tot = parent.frames[2].document.forms[0].temp_code.value;
					var tot = obj.value;
					var arr = tot.split("~");
					var temp_arr ="";
					var sel_indx="";
					var tm_set_indx="";
					var fval=arr[0];
					var inner_arr=fval.split("$");
					sel_indx=inner_arr[10];
					if(sel_indx=='Y'){
						free_text_cnt++;
					}
					var tm_set=inner_arr[2];
					if(tm_set!=diag_tset){
						term_set_cnt++;
					}
//			alert("=IF Proc="+proc_tm_set_cnt+"=IF=Diag=Cheked=>"+term_set_cnt);
		}else{
				var tot = parent.frames[2].document.forms[0].temp_code.value;
				var arr = tot.split("~");
				var temp_arr ="";
				for(var i=0;i< arr.length-1;i++){
					var fval=arr[i];
					var inner_arr=fval.split("$");
					var sel_indx=inner_arr[0];
					if(sel_indx!=m){
						temp_arr=temp_arr+arr[i]+"~";
					}
				}
				parent.frames[2].document.forms[0].temp_code.value = temp_arr;

				var tot1=obj.value;
				var arr1 = tot1.split("~");
				var fval1=arr1[0];
				var inner_arr1=fval1.split("$");
				if(inner_arr1[10]=="Y"){
					free_text_cnt--;
				}
				var tm_set=inner_arr1[2];
				if(tm_set!=diag_tset){
					term_set_cnt--;
				}
//				alert("=Else Proc="+proc_tm_set_cnt+"=Else=Diag=Un0Cheked=>"+term_set_cnt);
			}
			document.forms[0].diag_term_set_cnt.value=term_set_cnt
			if(free_text_cnt==0){
				diableConfimBTN();
			}else{
				parent.frames[4].document.forms[0].confirm.disabled=true;
			}
	}
}
// Procdure Recoding functions below
var  proc_tm_set_cnt	 =0;
function selectProcedure(m,obj,proc_code1,mode,code_extn_dtl,contr_mod_id,laterality_ind,pat_visit_dt_time,pat_disch_dt_time){
	var count1 = parent.frames[3].document.forms[0].i.value; 
	var proc_tset=parent.frames[4].document.forms[0].rec_proc_tset.value;
	var k = 0;
		parent.frames[3].document.getElementById('procedure_yn').value='Y';
		if(mode=='ProcModify'){
			parent.frames[3].document.forms[0].modify_temp_proc.value='';
	//		parent.frames[3].document.forms[0].checked_yn.value="Y";
			if(document.forms[0].temp_chk.value == "Y")	{
				parent.frames[3].document.forms[0].modify_temp_proc.value=parent.frames[3].document.forms[0].modify_temp_proc.value+obj.value;
			}else{
					parent.frames[3].document.forms[0].modify_temp_proc.value=obj.value;
			}
//			parent.frames[3].document.forms[0].temp_chk.value="Y";
//			alert(parent.frames[3].document.forms[0].modify_temp_proc.value)
				ModifyProcedure(mode,code_extn_dtl,contr_mod_id,laterality_ind,pat_visit_dt_time,pat_disch_dt_time)
	}else{
			if(obj.checked == true ){
//			parent.frames[3].document.getElementById("procedure_yn").value='Y';
				/*	F.Y.I: Added On 12/23/2009 for SRR-303.1
					1.For showing a alert by selecting of OT Procedure and Both Start Date & End Dates (Headers)  are not recorded.
					2.For Disabling the Confirm button  Selected code is having different term sets.*/
				var tot = obj.value;
				var arr = tot.split("~");
				var temp_arr ="";
				var sel_indx	="";
				var srt_dt		="";
				var end_dt	="";
				var tm_set	="";
				var proc_cd	="";
				var fval=arr[0];
				var inner_arr=fval.split("$");
				sel_indx	= inner_arr[10];//Proc_type
				srt_dt		= inner_arr[14];//Checkin Date/Time
				end_dt		= inner_arr[15];//Check out Date/Time
				tm_set		=	inner_arr[2];//Term Set
				proc_cd	=	inner_arr[1];// Proc_Code
//				alert(tm_set)
//				alert(proc_tset)
				var append_err_ot	="";
				if(tm_set!=proc_tset){
					proc_tm_set_cnt++;
				}
				if(sel_indx=='OT'){
					if(srt_dt=="01" && end_dt=="01" ){
						var error_msg	=	getMessage("OT_PROC_CANNOT_CONFIRM","MR");
//						error_msg	 =error_msg.replace("$",proc_cd);
						alert(error_msg)
						obj.checked=false;
						append_err_ot ="N";
					}else{
						append_err_ot ="Y";
					}
				}else{
						append_err_ot ="Y";
				}
//			alert("=If Proc="+proc_tm_set_cnt+"=If=Diag=>"+term_set_cnt);

				if(append_err_ot=="Y"){
					if (parent.frames[3].document.getElementById('temp_chk').value == 'Y'){
						parent.frames[3].document.forms[0].temp_proc.value=parent.frames[3].document.forms[0].temp_proc.value+obj.value;
					}else{
						parent.frames[3].document.forms[0].temp_proc.value=obj.value;
					}
					parent.frames[3].document.forms[0].temp_chk.value="Y";
				}
//				alert("Proc==>" +parent.frames[3].document.forms[0].temp_proc.value)

		}else{
			var tot = parent.frames[3].document.forms[0].temp_proc.value;
			var arr = tot.split("~");
			var temp_arr ="";
			for(var i=0;i< arr.length-1;i++){
				var fval=arr[i];
				var inner_arr=fval.split("$");
				var sel_indx=inner_arr[0];
				if(sel_indx!=m){
					temp_arr=temp_arr+arr[i]+"~";
				}
			}
			parent.frames[3].document.forms[0].temp_proc.value = temp_arr;
				var tot1		 = obj.value;
				var arr			 = tot1.split("~");
				var fval1		 = arr[0];
				var inner_arr1= fval1.split("$");
				var proc_type	=	inner_arr1[10];
				var srt_dt			=	inner_arr1[14];
				var end_dt		=	inner_arr1[15];
				var tm_set		=	inner_arr1[2];
				if(tm_set!=proc_tset){
					proc_tm_set_cnt--;
				}
				/*if(proc_type=="OT"){
					if(srt_dt=="01" && end_dt=="01" ){
						cnt_of_ot_proc--;
					}
				}*/
		}
			document.forms[0].proc_term_set_cnt.value=proc_tm_set_cnt
				diableConfimBTN();
			/*if(proc_tm_set_cnt==0){
				parent.frames[4].document.forms[0].confirm.disabled=false;
			}else{
				parent.frames[4].document.forms[0].confirm.disabled=true;
			}*/
	//alert(parent.frames[3].document.forms[0].temp_proc.value);
		
	}
}
/*Added On 12/24/2009
  F.Y.I : This Will be Calling form enbleselect();and SelectProcedure().
  1.In This function when Diagnosis or Procedure code is selected if that code termset is different then confirm button will be diaabled.
*/
function diableConfimBTN(){
	var diag_term_set_cnt	= "";
	var proc_term_set_cnt	= "";
	if( parent.frames[2].document.forms[0]){
		 diag_term_set_cnt	=parent.frames[2].document.forms[0].diag_term_set_cnt.value;
	}
	if(parent.frames[3].document.forms[0]){
		 proc_term_set_cnt	=parent.frames[3].document.forms[0].proc_term_set_cnt.value;
	}
	if(eval(diag_term_set_cnt)==0 && eval(proc_term_set_cnt)==0){
		parent.frames[4].document.forms[0].confirm.disabled=false;
	}else{
		parent.frames[4].document.forms[0].confirm.disabled=true;
	}

}




async function show_window(obj)
{
	//var dob = parent.frames[5].document.forms[0].age.value;
	//var age = parent.frames[5].document.forms[0].dob.value;
	var dob = parent.frames[5].document.forms[0].dob.value;
	var age = parent.frames[5].document.forms[0].age.value;
	var sex = parent.frames[5].document.forms[0].gender.value;
	var searchtext = parent.frames[5].document.forms[0].diagprob_code.value;
	var practitioner_id = parent.frames[5].document.forms[0].Practitioner_Id.value;
	var term_set_id = parent.frames[5].document.forms[0].dflt_termset.value;
	var Encounter_Id = parent.frames[5].document.forms[0].EncounterId.value;
	var speciality_code = parent.frames[5].document.forms[0].speciality_code.value;
	var diagnosis_by_long_desc_yn = parent.frames[5].document.forms[0].diagnosis_by_long_desc_yn.value;//Maheshwaran K added for HSA-CRF-0234
	var retVal =    new String();
	var dialogHeight= "60vh" ;
	var dialogWidth = "63vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	
//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
	retVal = await top.window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if(retVal != null)
	{
		//var arr = new Array();
		//retcode = retVal.split("/");
		retcode=retVal ;  // 2 lines commented and new line added on 15th jul 2009
		if(obj == 1)
		{
			parent.frames[5].document.forms[0].diagprob_code.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code.onblur();
		}
		else if(obj == 2)
		{
			parent.frames[5].document.forms[0].diagprob_code1.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code1.onblur();
		}
		else if(obj == 3)
		{
			parent.frames[5].document.forms[0].diagprob_code2.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code2.onblur();
		}
	}
}

function getDescription(obj){
//		parent.frames[5].document.forms[0].diagprob_code.value=trimString(parent.frames[5].document.forms[0].diagprob_code.value);
//		parent.frames[5].document.forms[0].diagprob_code1.value=trimString(parent.frames[5].document.forms[0].diagprob_code1.value);
//		parent.frames[5].document.forms[0].diagprob_code2.value=trimString(parent.frames[5].document.forms[0].diagprob_code2.value);

		var diag_code0 = parent.frames[5].document.forms[0].diagprob_code.value;
		var diag_code1=	parent.frames[5].document.forms[0].diagprob_code1.value;
		var diag_code2= parent.frames[5].document.forms[0].diagprob_code2.value;

		var hid_diagprob_code_0= parent.frames[5].document.forms[0].hid_diagprob_code_0.value;
		var hid_diagprob_code_1= parent.frames[5].document.forms[0].hid_diagprob_code_1.value;
		var hid_diagprob_code_2= parent.frames[5].document.forms[0].hid_diagprob_code_2.value;

		var procedure_yn= parent.frames[5].document.forms[0].procedure_yn.value;
		diag_code0 =  diag_code0.toUpperCase();
		diag_code1 =  diag_code1.toUpperCase();
		diag_code2 =  diag_code2.toUpperCase();

		hid_diagprob_code_0 =  hid_diagprob_code_0.toUpperCase();
		hid_diagprob_code_1 =  hid_diagprob_code_1.toUpperCase();
		hid_diagprob_code_2 =  hid_diagprob_code_2.toUpperCase();

		var proceed_flg=true;
		var validated_code =false;
		var diag_code='';
		var dupflg=false;
		var active_diag_codes='';
		if(procedure_yn!="Y"){
				active_diag_codes=parent.frames[2].document.forms[0].active_diag_codes.value;
		}else{
			active_diag_codes=parent.frames[3].document.forms[0].active_proc_codes.value;
		}
		
		var arr_act=active_diag_codes.split("~");

		var dflt_t_set=parent.frames[5].document.forms[0].code_set.value;
		var tmp_val_act='';
		if(obj == 1){
			if(hid_diagprob_code_0!=diag_code0){
				if(procedure_yn!="Y"){
					parent.frames[5].document.forms[0].record_assosicate_codes_0.value="";
				}
				validated_code =true;
			}
			if(diag_code0==diag_code1 || diag_code0==diag_code2){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code.value = diag_code0;
			diag_code=diag_code0;
			tmp_val_act=dflt_t_set+'$'+diag_code;
			
			for(var act=0;act<arr_act.length;act++){
				if(arr_act[act]==tmp_val_act){
					alert(getMessage('ACT_DIAG_PROC_CODE','MR'));
					proceed_flg=false;
					parent.frames[5].document.forms[0].diagprob_code.value='';
					parent.frames[5].document.forms[0].diagprob_desc.value='';
					/* Below line was added by venkatesh against 58644 */
					parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
					/*end 58644 */
					break;

				}

			}

		}else if(obj == 2){
			if(hid_diagprob_code_1!=diag_code1){
				if(procedure_yn!="Y"){
					parent.frames[5].document.forms[0].record_assosicate_codes_1.value="";
				}
				validated_code =true;
			}
			if(diag_code1==diag_code0 || diag_code1==diag_code2){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code1.value = diag_code1;
			diag_code= diag_code1;
			tmp_val_act=dflt_t_set+'$'+diag_code;
			
			for(var act=0;act<arr_act.length;act++){
				if(arr_act[act]==tmp_val_act){
					alert(getMessage('ACT_DIAG_PROC_CODE','MR'));
					proceed_flg=false;
					parent.frames[5].document.forms[0].diagprob_code1.value='';
					parent.frames[5].document.forms[0].diagprob_desc1.value='';
					break;

				}

			}
		}else if(obj == 3){
			if(hid_diagprob_code_2!=diag_code2){
				if(procedure_yn!="Y"){
					parent.frames[5].document.forms[0].record_assosicate_codes_2.value="";
				}
				validated_code =true;
			}
			if(diag_code2==diag_code1 || diag_code2==diag_code0){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code2.value = diag_code2;
			diag_code= diag_code2;
			tmp_val_act=dflt_t_set+'$'+diag_code;

			tmp_val_act=dflt_t_set+'$'+diag_code;
			
			for(var act=0;act<arr_act.length;act++){
				if(arr_act[act]==tmp_val_act){
					alert(getMessage('ACT_DIAG_PROC_CODE','MR'));
					proceed_flg=false;
					parent.frames[5].document.forms[0].diagprob_code2.value='';
					parent.frames[5].document.forms[0].diagprob_desc2.value='';
					break;
				}
			}
		}
	
	if(diag_code!=""){
		if(dupflg){
			var err_msg=getMessage('DUP_DIAG_PROC','MR');
			alert(err_msg);
			if(obj == 1){
				parent.frames[5].document.forms[0].diagprob_code.focus();
			}else if(obj == 2){
				parent.frames[5].document.forms[0].diagprob_code1.focus();
			}else if(obj == 3){
				parent.frames[5].document.forms[0].diagprob_code2.focus();
			}
		}else{
			if(validated_code){
				if(proceed_flg){ 
					htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.frames[5].document.forms[0].dflt_termset.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='hidden' name='Age' id='Age' value='"+parent.frames[5].document.forms[0].age.value+"'><input type='hidden' name='Sex' id='Sex' value='"+parent.frames[5].document.forms[0].gender.value+"'><input type='hidden' name='Dob' id='Dob' value='"+parent.frames[5].document.forms[0].dob.value+"'></input><input type='hidden' name='mode' id='mode' value='recode'></input><input type='hidden' name='descIndex' id='descIndex' value='"+obj+"'><input type='hidden' name='newcodeYN' id='newcodeYN' value='"+parent.frames[5].document.forms[0].newCode_yn.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[5].document.forms[0].Pat_id.value+"'><input type='hidden' name='EncounterId' id='EncounterId' value='"+parent.frames[5].document.forms[0].EncounterId.value+"'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[5].document.forms[0].procedure_yn.value+"'><input type='hidden' name='stage_no' id='stage_no' value='"+parent.frames[5].document.forms[0].stage_no.value+"'><input type='hidden' name='isMultiDescAppl' id='isMultiDescAppl' value='"+parent.frames[5].document.forms[0].isMultiDescAppl.value+"'></input></form></body></html>"; // added by mujafar for ML-MMOH-CRF-1281
					parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
					parent.frames[6].document.MRvalidate.submit();
				}
			}
		}

	}else{
		var procedure_yn = parent.frames[5].document.forms[0].procedure_yn.value;
		if(obj == 1){
			parent.frames[5].document.forms[0].diagprob_desc.value = "";
			parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "";
			parent.frames[5].document.getElementById('long_desc_0').style.display="none";
			if(procedure_yn!="Y"){
				parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
				parent.frames[5].document.forms[0].dagger_independent_yn_0.value = "N";
				
				if(parent.frames[5].document.forms[0].isMultiDescAppl.value=="true" && parent.frames[5].document.getElementById('other_disp1'))
						{ // Added by mujafar for ML-MMOH-CRF-1281 US3
						parent.frames[5].document.getElementById('other_disp1').style.visibility = "hidden";
						parent.frames[5].document.getElementById('other_disp2').style.visibility = "hidden";
						}
				
				
			}
		}else if(obj == 2){
			parent.frames[5].document.forms[0].diagprob_desc1.value = "";
			parent.frames[5].document.forms[0].hid_diagprob_code_1.value = "";
			parent.frames[5].document.getElementById('long_desc_1').style.display="none";
			if(procedure_yn!="Y"){
				parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true
				parent.frames[5].document.forms[0].dagger_independent_yn_1.value = "N";
			}
		}else if(obj == 3){
			parent.frames[5].document.forms[0].diagprob_desc2.value = "";
			parent.frames[5].document.forms[0].hid_diagprob_code_2.value = "";
			parent.frames[5].document.getElementById('long_desc_2').style.display="none";
			if(procedure_yn!="Y"){
				parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true
				parent.frames[5].document.forms[0].dagger_independent_yn_2.value = "N";
			}
		}
		return false;
	}
}

function Click_Authorize(){

	parent.frames[4].document.forms[0].authorize.disabled=true;
	parent.frames[4].document.forms[0].reject.disabled=true;

	
	var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
	var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;
	var allow_recode_diag_yn	=parent.frames[4].document.forms[0].allow_recode_diag_yn.value;
	var allow_recode_proc_yn	=parent.frames[4].document.forms[0].allow_recode_diag_yn.value;



	var out_arr="";

	var DB_Chkdiag_Values	="";
	var DB_Chkdiag_srl_no	="";
	var DB_Chkgroup_yn		="";// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	var DB_Chkgroup_seq_no="";// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	var DB_Chksupport_seq_no="";// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	var DB_Chkproc_Values	="";
	var DB_Chkproc_srl_no	="";
//	var db_contr_mod_id="";
//	var db_code_xtrn="";

	if(final_diag_values!=""){
		 out_arr=final_diag_values.split("~");
		for(i=0;i<out_arr.length-1;i++){
			var in_arr=out_arr[i].split("$");
			DB_Chkdiag_Values=DB_Chkdiag_Values+"'"+in_arr[1]+"',";
			DB_Chkdiag_srl_no=DB_Chkdiag_srl_no+"'"+in_arr[4]+"',";
			DB_Chkgroup_yn=DB_Chkgroup_yn+in_arr[7]+",";
			DB_Chkgroup_seq_no=DB_Chkgroup_seq_no+in_arr[9]+",";
			DB_Chksupport_seq_no=DB_Chksupport_seq_no+"'"+in_arr[11]+"',";
		}
	}
	
	if(final_proc_values!=""){
		out_arr1=final_proc_values.split("~");
		for(ij=0;ij<out_arr1.length-1;ij++){
			var in_arr1=out_arr1[ij].split("$");
			DB_Chkproc_Values=DB_Chkproc_Values+"'"+in_arr1[1]+"',";
			DB_Chkproc_srl_no=DB_Chkproc_srl_no+"'"+in_arr1[4]+"',";
//			db_contr_mod_id=db_contr_mod_id+"'"+in_arr1[10]+"',";
//			db_code_xtrn=DB_Chkproc_srl_no+"'"+in_arr1[11]+"',";

		}
	}
	DB_Chkdiag_Values		=DB_Chkdiag_Values.substring(0,DB_Chkdiag_Values.length-1);
	DB_Chkdiag_srl_no		=DB_Chkdiag_srl_no.substring(0,DB_Chkdiag_srl_no.length-1);
	DB_Chkgroup_yn			=DB_Chkgroup_yn.substring(0,DB_Chkgroup_yn.length-1);// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	DB_Chkgroup_seq_no	=DB_Chkgroup_seq_no.substring(0,DB_Chkgroup_seq_no.length-1);// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	DB_Chksupport_seq_no	=DB_Chksupport_seq_no.substring(0,DB_Chksupport_seq_no.length-1);// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	DB_Chkproc_Values	=DB_Chkproc_Values.substring(0,DB_Chkproc_Values.length-1);
	DB_Chkproc_srl_no		=DB_Chkproc_srl_no.substring(0,DB_Chkproc_srl_no.length-1);
//	db_contr_mod_id=db_contr_mod_id.substring(0,db_contr_mod_id.length-1);
//	db_code_xtrn=db_code_xtrn.substring(0,db_code_xtrn.length-1);
	parent.frames[4].document.forms[0].Confirm_Dig_Data.value=DB_Chkdiag_Values;
	parent.frames[4].document.forms[0].sel_srl_no.value=DB_Chkdiag_srl_no;
	parent.frames[4].document.forms[0].final_Diag_group_yn.value=DB_Chkgroup_yn;// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	parent.frames[4].document.forms[0].group_seq_no_data.value=DB_Chkgroup_seq_no;// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	parent.frames[4].document.forms[0].support_seq_no_data.value=DB_Chksupport_seq_no;// Added On 2/16/2010 for SRR-CRF-303.2(IN015597)
	parent.frames[4].document.forms[0].Confirm_Proc_Data.value=DB_Chkproc_Values;
	parent.frames[4].document.forms[0].sel_proc_srl_no.value=DB_Chkproc_srl_no;
//	parent.frames[4].document.forms[0].sel_mod_id.value=db_contr_mod_id;
//	parent.frames[4].document.forms[0].sel_cod_xtn.value=db_code_xtrn;

	var prin_diag=parent.frames[2].document.forms[0].principal_diag.value;
	var prin_diag_cnt=parent.frames[2].document.forms[0].prin_diag_cnt.value;
	var p_class=parent.frames[4].document.forms[0].Patient_Class.value;
	var drg_yn=parent.frames[4].document.forms[0].drg_yn.value;
//	alert(final_diag_values)
	if(drg_yn=='Y' && p_class=='IP' && final_diag_values!="" && prin_diag==""){
		alert(getMessage('NIL_PRI_DIAG','MR'))
		parent.frames[4].document.forms[0].authorize.disabled=false;
		parent.frames[4].document.forms[0].reject.disabled=false;
//		parent.RecodeScreen.rows="47%,47%,5%,0%";
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="48%,48%,4%,0%";
		}else if(allow_recode_diag_yn=="Y"){
			parent.RecodeScreen.rows="95%,0%,5%,0%";
		}else if(allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="10%,85%,5%,0%";
		}
	}else{
		if(prin_diag!="" && prin_diag_cnt>1 ){
			alert(getMessage('PRIM_DIAGS_NOT_ALLOWED','MR'))
			parent.frames[4].document.forms[0].authorize.disabled=false;
			parent.frames[4].document.forms[0].reject.disabled=false;
				//		parent.RecodeScreen.rows="47%,47%,5%,0%";
			if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
				parent.RecodeScreen.rows="48%,48%,4%,0%";
			}else if(allow_recode_diag_yn=="Y"){
				parent.RecodeScreen.rows="95%,0%,5%,0%";
			}else if(allow_recode_proc_yn=="Y"){
				parent.RecodeScreen.rows="10%,85%,5%,0%";
			}
		}else{
			parent.frames[4].document.forms[0].principal_diag.value="'"+parent.frames[2].document.forms[0].principal_diag.value+"'";
			parent.frames[4].document.forms[0].prin_stg_srl_no.value="'"+parent.frames[2].document.forms[0].prin_stg_srl_no.value+"'";

			if(confirm(getMessage('AUTHORIZE_CODE','MR'))){
				var HTMLVal = new String();
				
				//alert(parent.frames[2].document.getElementById('authorize_item').value)
				//HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[2].document.forms[0].term_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='Patient_Class' id='Patient_Class' value='"+parent.frames[2].document.forms[0].Patient_Class.value+"'><input type='hidden' name='authorize_item' id='authorize_item' value='"+parent.frames[2].document.getElementById('authorize_item').value+"'><input type='hidden' name='mode' id='mode' value='authorize'><input type='hidden' name='recode_status' id='recode_status' value='AUTHORIZED'></input></form></body></html>";
				//parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);


				//parent.frames[6].document.tempRecode.submit();

				parent.frames[4].document.forms[0].activity.value="Authorize";
				parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
				parent.frames[4].document.forms[0].target="messageFrame";
				parent.frames[4].document.forms[0].submit();
		//		parent.RecodeScreen.rows="47%,47%,5%,0%";
				if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
					parent.RecodeScreen.rows="48%,48%,4%,0%";
				}else if(allow_recode_diag_yn=="Y"){
					parent.RecodeScreen.rows="95%,0%,5%,0%";
				}else if(allow_recode_proc_yn=="Y"){
					parent.RecodeScreen.rows="10%,85%,5%,0%";
				}

			}else{
					parent.frames[4].document.forms[0].authorize.disabled=false;
					parent.frames[4].document.forms[0].reject.disabled=false;
			//		parent.RecodeScreen.rows="47%,47%,5%,0%";
					if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
						parent.RecodeScreen.rows="48%,48%,4%,0%";
					}else if(allow_recode_diag_yn=="Y"){
						parent.RecodeScreen.rows="95%,0%,5%,0%";
					}else if(allow_recode_proc_yn=="Y"){
						parent.RecodeScreen.rows="10%,85%,5%,0%";
					}

			}
		}
	}

}

function finalrecodeVal(){
//	parent.frames[5].document.forms[0].Save.disabled=true;
	var diagprob_code=parent.frames[5].document.forms[0].diagprob_code.value
		var diagprob_code1=parent.frames[5].document.forms[0].diagprob_code1.value
		var diagprob_code2=parent.frames[5].document.forms[0].diagprob_code2.value
		var obj="";
		var diag_code0 = parent.frames[5].document.forms[0].diagprob_code.value;
		var diag_code1=	parent.frames[5].document.forms[0].diagprob_code1.value;
		var diag_code2=	parent.frames[5].document.forms[0].diagprob_code2.value;
//		diag_code0 =  diag_code0.toUpperCase();
//		diag_code1 =  diag_code1.toUpperCase();
//		diag_code2 =  diag_code2.toUpperCase();
		var validCode	="";
	if(diagprob_code!=""){
				obj="1";
				validCode	  = diagprob_code.toUpperCase()+"$";
	} 
	if(diagprob_code1!=""){
						obj1="2";

				validCode	 =	validCode+diagprob_code1.toUpperCase()+"$";
	} 
	if(trimString(diagprob_code2)!=""){
						obj2="2";

				validCode	 =	validCode+diagprob_code2.toUpperCase()+"$";
		}
		validCode=validCode.substring(0,validCode.length-1);

		var diag_code='';
		var dupflg=false;
		if(obj == 1){
			if(diag_code0==diag_code1 || diag_code0==diag_code2){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code.value = diag_code0;
			diag_code=diag_code0;

		}else if(obj1 == 2){
			if(diag_code1==diag_code0 || diag_code1==diag_code2){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code1.value = diag_code1;
			diag_code= diag_code1;
		}else if(obj2 == 3){

		if(diag_code2==diag_code1 || diag_code2==diag_code0){
				dupflg=true;
			}
			parent.frames[5].document.forms[0].diagprob_code2.value = diag_code2;
			diag_code= diag_code2;
		}
	
	if(diag_code!=""){

		if(dupflg){

			alert(getMessage('DUP_DIAG_PROC','MR'));
			if(obj == 1){
				parent.frames[5].document.forms[0].diagprob_code.focus();
			}else if(obj1 == 2){
				parent.frames[5].document.forms[0].diagprob_code1.focus();
			}else if(obj2== 3){
				parent.frames[5].document.forms[0].diagprob_code2.focus();
			}
		}else{
			htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.frames[5].document.forms[0].dflt_termset.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='hidden' name='Age' id='Age' value='"+parent.frames[5].document.forms[0].age.value+"'><input type='hidden' name='Sex' id='Sex' value='"+parent.frames[5].document.forms[0].gender.value+"'><input type='hidden' name='Dob' id='Dob' value='"+parent.frames[5].document.forms[0].dob.value+"'></input><input type='hidden' name='mode' id='mode' value='ValidateDesc'></input><input type='hidden' name='descIndex' id='descIndex' value='"+obj+"'><input type='hidden' name='newcodeYN' id='newcodeYN' value='"+parent.frames[5].document.forms[0].newCode_yn.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[5].document.forms[0].Pat_id.value+"'><input type='hidden' name='EncounterId' id='EncounterId' value='"+parent.frames[5].document.forms[0].EncounterId.value+"'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[5].document.forms[0].procedure_yn.value+"'><input type='hidden' name='validCode' id='validCode' value='"+validCode+"'><input type='hidden' name='stage_no' id='stage_no' value='"+parent.frames[5].document.forms[0].stage_no.value+"'></input></form></body></html>";
			
			parent.frames[6].document.write(htmlval);
			parent.frames[6].document.MRvalidate.submit();
		}
	}else{
		if(obj == 1)
			parent.frames[5].document.forms[0].diagprob_desc.value = "";
		else if(obj1 == 2)
			parent.frames[5].document.forms[0].diagprob_desc1.value = "";
		else if(obj2 == 3)
			parent.frames[5].document.forms[0].diagprob_desc2.value = "";
		return false;

	}

}

function recodeVal(){

	if(parent.frames[5].document.forms[0].diagprob_code1.value == '' && parent.frames[5].document.forms[0].diagprob_code2.value == ''){
		parent.frames[5].document.forms[0].termcode_cnt.value = 1;
	}else if(parent.frames[5].document.forms[0].diagprob_code1.value == '' || parent.frames[5].document.forms[0].diagprob_code2.value == '') {
		parent.frames[5].document.forms[0].termcode_cnt.value = 2;
	}else{
		parent.frames[5].document.forms[0].termcode_cnt.value = 3;
	}

	if(parent.frames[5].document.forms[0].newCode_yn.value == 'Y'){  // new code
			parent.frames[5].document.forms[0].sel_item.value=parent.frames[5].document.forms[0].diagprob_code.value+","+parent.frames[5].document.forms[0].code_set.value;
			parent.frames[5].document.forms[0].orig_termset.value=parent.frames[5].document.forms[0].code_set.value;
			var fields=new Array();
			var names = new Array();
			var p = 0;
             /* Below lines added against HSA-CRF-300 */
			if(parent.frames[5].document.forms[0].diag_stage && parent.frames[5].document.forms[0].diag_stage.value =="" )
			{
				fields[p] = parent.frames[5].document.forms[0].diag_stage;
				names[p] = getLabel("eMR.EncounterStage.label","MR");
				p++;
			}
			
         
			  /* END HSA-CRF-300 */
			
			if(parent.frames[5].document.forms[0].as_on_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status_date;
				names[p] = getLabel("Common.Ason.label","Common");
				p++;
			}
			if(parent.frames[5].document.forms[0].priority_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].priority;
				names[p] = getLabel("Common.priority.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].severity_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].severity;
				names[p] = getLabel("Common.Severity.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].accuracy_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].accuracy;
				names[p] = getLabel("Common.Accuracy.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].onset_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_date;
				names[p] = getLabel("Common.onsetdate.label","Common");
				p++;
			}
			if(parent.frames[5].document.forms[0].onset_type_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_type;
				names[p] = getLabel("eMR.OnsetType.label","MR");
				p++;
			}

			if(parent.frames[5].document.forms[0].status_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status;
				names[p] = getLabel("Common.status.label","Common");
				p++;
			}

			fields[p] = parent.frames[5].document.forms[0].code_set;
			names[p] = getLabel("eMR.DiagnosisSet.label","eMR");
			p++;

			fields[p] = parent.frames[5].document.forms[0].diagprob_code;
			names[p] = getLabel("Common.diagnosis.label","Common");
			p++;
			
			// added by mujafar for ML-MMOH-CRF-1281 Start
	if(parent.frames[5].document.forms[0].isMultiDescAppl.value=="true" && parent.frames[5].document.getElementById('other_disp1'))
	{ // Added by mujafar for ML-MMOH-CRF-1281 US3 
	
	if(parent.frames[5].document.getElementById('other_disp1').style.visibility=='visible')
	{
	 fields[p]=parent.frames[5].document.forms[0].term_oth_desc;
     names[p] = getLabel("Common.other.label","Common")+" "+getLabel("Common.description.label","Common")+"s" ; 
	 p++;
	}
	}
			


		var	msgFrame=parent.frames[6];
		if(parent.frames[5].document.forms[0].procedure_yn.value == 'Y'){
			var proc_type		= parent.frames[5].document.forms[0].proc_type;//Added On 12/14/2009 for SRR-CRF-303.1	
			var start_dt_time	= parent.frames[5].document.forms[0].start_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
			var end_dt_time	= parent.frames[5].document.forms[0].end_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
			var fields=new Array();
			var names = new Array();
			var p = 0;

			fields[p] = parent.frames[5].document.forms[0].code_set;
			names[p] = getLabel("eMR.DiagnosisSet.label","eMR");
			p++;
			fields[p] = parent.frames[5].document.forms[0].diagprob_code;
			names[p] = getLabel("Common.Procedure.label","Common");
			p++;
			fields[p] = proc_type;                                                                                                                       
			names[p] = getLabel("Common.Procedure.label","Common")+" "+getLabel("Common.type.label","Common"); 			
			p++;
			if(proc_type.value=="OT"){
				fields[p] = start_dt_time;                                                                                                                       
				names[p] = getLabel("eMR.checkindatetime.label","MR");
				p++;
				fields[p] = end_dt_time;                                                                                                                       
				names[p] = getLabel("eMR.checkoutdatetime.label","MR"); 			
				p++;

			}
			if(parent.frames[5].document.forms[0].proc_status_appl_yn.value == "Y"){
				fields[p] = parent.frames[5].document.forms[0].status;
				names[p] = getLabel("Common.status.label","Common");
				p++;
			}
			//fields[p] = parent.frames[5].document.forms[0].proc_type;
			//names[p] = getLabel("Common.type.label","Common");
			//p++;


			
	/*	var fields = new Array(parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code,parent.frames[5].document.forms[0].proc_type);
			var names = new Array(getLabel("Common.DiagnosisSet.label","Common"),getLabel("Common.Procedure.label","Common"),getLabel("Common.type.label","Common"),getLabel("Common.type.label","Common"));
			fields[p] = parent.frames[5].document.forms[0].proc_type;
			fields[p] = getLabel("Common.type.label","Common");
			p++;*/


			if(parent.frames[5].checkFieldsofMst(fields, names, msgFrame)){
					finalrecodeVal();
				/*if(parent.frames[5].document.forms[0]){
					parent.frames[5].document.forms[0].submit();
					parent.RecodeScreen.rows="47%,47%,5%,0%";
				}else{
			parent.frames[5].document.forms[0].Save.disabled=false;
		}*/
	}else{
			parent.frames[5].document.forms[0].Save.disabled=false;
		}
	}else{
			if(parent.frames[5].checkFieldsofMst(fields, names, msgFrame)){

						finalrecodeVal();
				/*if(parent.frames[5].document.forms[0]){
					parent.frames[5].document.forms[0].submit();
					parent.RecodeScreen.rows="47%,47%,5%,0%";
				}else{
			parent.frames[5].document.forms[0].Save.disabled=false;
		}*/
		}else{
				parent.frames[5].document.forms[0].Save.disabled=false;
		}
	}
	}else{    // recoding
		var proc_type	= parent.frames[5].document.forms[0].proc_type;//Added On 12/14/2009 for SRR-CRF-303.1	
		var start_dt_time	= parent.frames[5].document.forms[0].start_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var end_dt_time	= parent.frames[5].document.forms[0].end_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var code_set	= parent.frames[5].document.forms[0].code_set;//Added On 12/14/2009 for SRR-CRF-303.1	
		var diagprob_code	= parent.frames[5].document.forms[0].diagprob_code;//Added On 12/14/2009 for SRR-CRF-303.1	
//		var diagprob_code	= parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code;

		if(parent.frames[5].document.forms[0].procedure_yn.value == 'Y'){
			var fields = new Array();
			var names = new Array();
			var p = 0;
			fields[p] =	 code_set;                                                                                                                     
			names[p] = getLabel("eMR.DiagnosisSet.label","eMR"); 			
			p++;

			fields[p] = diagprob_code;                                                                                                            
			names[p] = getLabel("Common.Procedure.label","Common"); 			
			p++;

			fields[p] = proc_type;                                                                                                                       
			names[p] = getLabel("Common.Procedure.label","Common")+" "+getLabel("Common.type.label","Common"); 			
			p++;
			if(proc_type.value=="OT"){
				fields[p] = start_dt_time;                                                                                                                       
				names[p] = getLabel("eMR.checkindatetime.label","MR"); 			
				p++;
				fields[p] = end_dt_time;                                                                                                                       
				names[p] = getLabel("eMR.checkoutdatetime.label","MR"); 			
				p++;
			}
			if(parent.frames[5].document.forms[0].proc_status_appl_yn.value == "Y"){
				fields[p] = parent.frames[5].document.forms[0].status;
				names[p] = getLabel("Common.status.label","Common");
				p++;
			}

		}else{
			var fields=new Array();
			var names = new Array();
			var p = 0;
            /* Below lines added against HSA-CRF-300 */
			if(parent.frames[5].document.forms[0].diag_stage && parent.frames[5].document.forms[0].diag_stage.value =="" )
			{
				fields[p] = parent.frames[5].document.forms[0].diag_stage;
				names[p] = getLabel("eMR.EncounterStage.label","MR");
				p++;
			}
			
        
			/* END HSA-CRF-300 */
			if(parent.frames[5].document.forms[0].as_on_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status_date;
				names[p] = getLabel("Common.Ason.label","Common");
				p++;
			}
			if(parent.frames[5].document.forms[0].priority_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].priority;
				names[p] = getLabel("Common.priority.label","Common");
				p++;
			}


			if(parent.frames[5].document.forms[0].severity_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].severity;
				names[p] = getLabel("Common.Severity.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].accuracy_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].accuracy;
				names[p] = getLabel("Common.Accuracy.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].onset_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_date;
				names[p] = getLabel("Common.onsetdate.label","Common");
				p++;
			}
			
			if(parent.frames[5].document.forms[0].onset_type_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_type;
				names[p] = getLabel("eMR.OnsetType.label","MR");
				p++;
			}

			if(parent.frames[5].document.forms[0].status_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status;
				names[p] = getLabel("Common.status.label","Common");
				p++;
			}

			fields[p] = parent.frames[5].document.forms[0].code_set;
			names[p] = getLabel("eMR.DiagnosisSet.label","eMR");
			p++;

			fields[p] = parent.frames[5].document.forms[0].diagprob_code;
			names[p] = getLabel("Common.diagnosis.label","Common");
			p++;

			
			/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
			if(parent.frames[5].document.forms[0].doctorsDescription.value == "true" && parent.frames[5].document.forms[0].mode.value != 'Modify')
			{

				fields[p] = parent.frames[5].document.forms[0].doctor_desc;
				names[p] = getLabel("eMR.DoctorDesc.label","eMR");
				p++;					

			}
			/*End ML-MMOH-CRF-1269*/
			
			if(parent.frames[5].document.forms[0].isMultiDescAppl.value=="true" && parent.frames[5].document.getElementById('other_disp1'))
			{ // Added by mujafar for ML-MMOH-CRF-1281 US3 

			if(parent.frames[5].document.getElementById('other_disp1').style.visibility=='visible')
			{
			fields[p]=parent.frames[5].document.forms[0].term_oth_desc;
			names[p] = getLabel("Common.other.label","Common")+" "+getLabel("Common.description.label","Common")+"s" ; 
			p++;
			}
			}

			//fields[p] = parent.frames[5].document.forms[0].onset_date;
			//names[p] = getLabel("Common.onsetdate.label","Common");

		//var fields = new Array(parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code,parent.frames[5].document.forms[0].onset_date);

		//var names = new Array(getLabel("Common.DiagnosisSet.label","Common"),getLabel("Common.diagnosis.label","Common"),getLabel("Common.onsetdate.label","Common"));
		}
		var	msgFrame=parent.frames[6];
		if(parent.frames[5].checkFieldsofMst(fields, names, msgFrame)) {
			var err='';
			if(parent.frames[5].document.forms[0].termcode_cnt.value > '1'){
				if(parent.frames[5].document.forms[0].procedure_yn.value != 'Y'){
					var prim_codes= parent.frames[5].document.forms[0].diag_classfication.value;
					prim_det=prim_codes.split("$");
					if(prim_det[1]=='PD'){
						alert(getMessage('PRI_DIAG_ERR','MR'));					
						err='Y';
					}
				}
			}

			if(err==''){
				var mode=parent.frames[5].document.forms[0].mode.value;
				if(mode!="Modify" && mode!="ProcModify"){
					finalrecodeVal();
				}else{
					submit();
				}
			}else{
				parent.frames[5].document.forms[0].Save.disabled=false;
			}
			
		/*if(parent.frames[5].document.forms[0]){
				parent.frames[5].document.forms[0].submit();
				parent.RecodeScreen.rows="47%,47%,5%,0%";
			}else{
			parent.frames[5].document.forms[0].Save.disabled=false;
		}*/
		}else{
			
		}
	

}
}
function submit(){
		var allow_recode_diag_yn	= parent.frames[5].document.forms[0].allow_recode_diag_yn.value;
		var allow_recode_proc_yn	= parent.frames[5].document.forms[0].allow_recode_proc_yn.value;
		var butn_hdr_modified_dt	= parent.frames[4].document.forms[0].hdr_modified_dt.value;
		/*
			1.Here the hidden vairable name hdr_modified_dt is same for DPRecodingAddModify.jsp & DPRecodingButton.jsp.
			2.The Value of  hdr_modified_dt from DPRecodingButton.jsp was assgined to  hdr_modified_dt  from DPRecodingAddModify.jsp.
			because in servlet hdr_modified_dt is taken wheather the value is submitted from the DPRecodingAddModify.jsp or DPRecodingButton.jsp.  
		*/
		parent.frames[5].document.forms[0].hdr_modified_dt.value=butn_hdr_modified_dt;

		var procedure_yn		= parent.frames[5].document.forms[0].procedure_yn;//Added On 12/14/2009 for SRR-CRF-303.1
		var proc_type			= parent.frames[5].document.forms[0].proc_type;//Added On 12/14/2009 for SRR-CRF-303.1	
		var start_dt_time		= parent.frames[5].document.forms[0].start_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var end_dt_time		= parent.frames[5].document.forms[0].end_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var pat_visit_dt_time	= parent.frames[5].document.forms[0].pat_visit_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var pat_disch_dt_time	= parent.frames[5].document.forms[0].pat_disch_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
		var start_dt_tm_lbl	="";
		var end_dt_tm_lbl	="";
		var start_dt		=		parent.frames[5].document.forms[0].proc_srt_dt_hid.value;
		var end_dt		=		parent.frames[5].document.forms[0].proc_end_dt_hid.value;
		var valid_date_chk	= true;//Added On 12/14/2009 for SRR-CRF-303.1	
		var allow_to_submit	= true;//Added On 12/14/2009 for SRR-CRF-303.1	
		var restrict_prim_diag	= false;//Added On 3/1/2010 for SRR-CRF-303.2	
		
				if(parent.frames[5].document.forms[0]){
					if(procedure_yn.value == 'Y'){
						var error=getMessage("DATE_BTWN_ENC_PERIOD_RANGE","MR") ;
						if(proc_type.value=="OT"){
									if(start_dt_time.value!=""){
										var start_dt_chk	 = ValidateProcDates(start_dt_time.value,pat_visit_dt_time.value,pat_disch_dt_time.value);
										if(!start_dt_chk){
											start_dt_tm_lbl	 = getLabel("eMR.checkindatetime.label","MR");
											error	 = error.replace("$",start_dt_tm_lbl)
											alert(error)
											parent.frames[5].document.forms[0].start_dt_time.value="";
											parent.frames[5].document.forms[0].start_dt_time.focus();
											allow_to_submit	=false;
										}else{
											allow_to_submit	=true;
										}
								}
								if(allow_to_submit){
									if(end_dt_time.value!=""){
												var end_dt_chk	 = ValidateProcDates(end_dt_time.value,pat_visit_dt_time.value,pat_disch_dt_time.value);
												if(!end_dt_chk){
													end_dt_tm_lbl	 = getLabel("eMR.checkoutdatetime.label","MR");
													error	 = error.replace("$",end_dt_tm_lbl)
													alert(error)
													parent.frames[5].document.forms[0].end_dt_time.value="";
													parent.frames[5].document.forms[0].end_dt_time.focus();
													allow_to_submit	=false;
											}else{
													allow_to_submit	=true;
											}
									}
								}
						}else if(proc_type.value=="NO"){
							if(start_dt_time.value!=""){
								var start_dt_chk	 = ValidateProcDates(start_dt_time.value,pat_visit_dt_time.value,pat_disch_dt_time.value);
								if(!start_dt_chk){
									start_dt_tm_lbl	 = getLabel("Common.startdatetime.label","Common");
									error	 = error.replace("$",start_dt_tm_lbl)
									alert(error)
									parent.frames[5].document.forms[0].start_dt_time.value="";
									parent.frames[5].document.forms[0].start_dt_time.focus();
									allow_to_submit	=false;
								}else{
									allow_to_submit	=true;
								}
							}
							if(allow_to_submit){
								if(end_dt_time.value!=""){
									var end_dt_chk	 = ValidateProcDates(end_dt_time.value,pat_visit_dt_time.value,pat_disch_dt_time.value);
									if(!end_dt_chk){
										end_dt_tm_lbl	 = getLabel("Common.enddatetime.label","Common");
										error	 = error.replace("$",end_dt_tm_lbl)
										alert(error)
										parent.frames[5].document.forms[0].end_dt_time.value="";
										parent.frames[5].document.forms[0].end_dt_time.focus();
										allow_to_submit	=false;
									}else{
										allow_to_submit	=true;
									}
								}
							}
						}
							proc_type.disabled=false;

					}else{
						restrict_prim_diag=restirctPrimaryDiag(parent.frames[5].document.forms[0].diag_classfication);
						if(restrict_prim_diag){
							allow_to_submit=true;
						}else{
							allow_to_submit=false;
						}

						if(proc_type){
							proc_type.disabled=true;
						}
					}
					if(parent.frames[5].document.forms[0].status){
						parent.frames[5].document.forms[0].status.disabled=false;
					}
						if(allow_to_submit){
							parent.frames[5].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
							parent.frames[5].document.forms[0].submit();
							if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
								//parent.RecodeScreen.rows="48%,48%,4%,0%";
								parent.document.getElementById('RecDiagnosisDiag').style.height="40vh";
								parent.document.getElementById('RecDiagnosisProc').style.height="40vh";
								parent.document.getElementById('RecDiagnosisButton').style.height="5vh";
								parent.document.getElementById('DiagProcTrans').style.height="0vh";
							}else if(allow_recode_diag_yn=="Y"){
								//parent.RecodeScreen.rows="95%,0%,5%,0%";
								parent.document.getElementById('RecDiagnosisDiag').style.height="90vh";
								parent.document.getElementById('RecDiagnosisProc').style.height="0vh";
								parent.document.getElementById('RecDiagnosisButton').style.height="5vh";
								parent.document.getElementById('DiagProcTrans').style.height="0vh";
							}else if(allow_recode_proc_yn=="Y"){
								//parent.RecodeScreen.rows="10%,85%,5%,0%";
								parent.document.getElementById('RecDiagnosisDiag').style.height="10vh";
								parent.document.getElementById('RecDiagnosisProc').style.height="80vh";
								parent.document.getElementById('RecDiagnosisButton').style.height="5vh";
								parent.document.getElementById('DiagProcTrans').style.height="0vh";
							}
						}
					if(parent.frames[5].document.forms[0].status){
						parent.frames[5].document.forms[0].status.disabled=true;
					}
					if(proc_type){
						proc_type.disabled=true;
					}
//					parent.RecodeScreen.rows="47%,47%,5%,0%";
				}else{
				parent.frames[5].document.forms[0].Save.disabled=false;
		}
	/*if(parent.frames[5].document.forms[0].diagprob_code){
		parent.frames[5].document.forms[0].diagprob_code.value="";
	}
	if(parent.frames[5].document.forms[0].diagprob_code1){
	parent.frames[5].document.forms[0].diagprob_code1.value="";
	}
	if(parent.frames[5].document.forms[0].diagprob_code2){
	parent.frames[5].document.forms[0].diagprob_code2.value="";
	}*/
}
function confirmScreen(){				
	parent.frames[4].document.forms[0].confirm.disabled=true;
	
	var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		/*parent.RecodeScreen.rows="48%,48%,4%,0%";*/
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="15vh";
		parent.document.getElementById("DiagProcTrans").style.height="20vh";
	}else if(allow_recode_diag_yn=="Y"){
		/*parent.RecodeScreen.rows="95%,0%,5%,0%";*/
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="15vh";
		parent.document.getElementById("DiagProcTrans").style.height="20vh";
	}else if(allow_recode_proc_yn=="Y"){
		/*parent.RecodeScreen.rows="10%,85%,5%,0%";*/
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="15vh";
		parent.document.getElementById("DiagProcTrans").style.height="20vh";
	}
	var temp_val=parent.frames[2].document.forms[0].temp_code.value;
	var temp_proc_val	=	parent.frames[3].document.forms[0].temp_proc.value;
	var procedure_yn	 =	parent.frames[3].document.forms[0].procedure_yn.value;
//	var procedure_yn	 ="";
	var out_arr="";

	if(temp_val=="" && temp_proc_val=="" ){
		alert(getMessage('SEL_DIAG_PROC','MR'));
		parent.frames[4].document.forms[0].confirm.disabled=false;
		return false;
	}/*else if(temp_val !='' && temp_proc_val!=''){
		alert("Both Diagnosis and Procedure are Not allowed to Cofirm At Same Time.Cannot Proceed.");
		return false;
	}*/else{
		var DB_Chkdiag_Values="";
		var DB_Chkdiag_srl_no="";
		var DB_Chkdiag_stage_Values="";
		var DB_Chkproc_Values="";
		var DB_Chkproc_srl_no="";
		var DB_Chkproc_stage_Values="";
		var DB_Chkdiag_group_Values="";
		var DB_Chkdiag_group_seq_Values="";
		var DB_Chkproc_group_Values="";
		var DB_Chkproc_group_seq_Values="";
		var DB_Chkdiag_staus_Values="";
		var DB_Chkproc_staus_Values="";
		var  db_contr_mod_id="";
		var  db_code_xtn="";
		var  db_acess_num="";
		var  db_code_xtn_dtl="";

			if(temp_val!=""){
				 out_arr=temp_val.split("~");
				for(i=0;i<out_arr.length-1;i++){
					var in_arr=out_arr[i].split("$");
					DB_Chkdiag_Values				= DB_Chkdiag_Values+"'"+in_arr[1]+"',";
					DB_Chkdiag_srl_no				= DB_Chkdiag_srl_no+"'"+in_arr[4]+"',";
					DB_Chkdiag_stage_Values	= DB_Chkdiag_stage_Values+in_arr[6]+",";
					DB_Chkdiag_group_Values	=DB_Chkdiag_group_Values+in_arr[7]+",";
					DB_Chkdiag_group_seq_Values	= DB_Chkdiag_group_seq_Values+in_arr[9]+",";
					DB_Chkdiag_staus_Values			= DB_Chkdiag_staus_Values+in_arr[5]+",";
				}
			}
			
			if(temp_proc_val!=""){
				out_arr1=temp_proc_val.split("~");
				for(ij=0;ij<out_arr1.length-1;ij++){
					var in_arr1=out_arr1[ij].split("$");
					DB_Chkproc_Values			=	DB_Chkproc_Values+"'"+in_arr1[1]+"',";
					DB_Chkproc_srl_no				=	DB_Chkproc_srl_no+"'"+in_arr1[4]+"',";
					DB_Chkproc_stage_Values	=	DB_Chkproc_stage_Values+in_arr1[6]+",";
					DB_Chkproc_group_Values	 =	DB_Chkproc_group_Values+in_arr1[7]+",";
					DB_Chkproc_group_seq_Values	=	DB_Chkproc_group_seq_Values+in_arr1[9]+",";
					DB_Chkproc_staus_Values			=	DB_Chkproc_staus_Values+in_arr1[5]+",";
	/*				db_contr_mod_id	 =	db_contr_mod_id+""+in_arr1[10]+",";
					db_code_xtn		 =	db_code_xtn+""+in_arr1[11]+",";
					db_acess_num		 =	db_acess_num+""+in_arr1[12]+",";
					db_code_xtn_dtl	 =	db_code_xtn_dtl+""+in_arr1[13]+",";*/

				}
			}
				DB_Chkdiag_Values				= DB_Chkdiag_Values.substring(0,DB_Chkdiag_Values.length-1);
				DB_Chkdiag_srl_no				= DB_Chkdiag_srl_no.substring(0,DB_Chkdiag_srl_no.length-1);
				DB_Chkproc_Values			= DB_Chkproc_Values.substring(0,DB_Chkproc_Values.length-1);
				DB_Chkproc_srl_no				= DB_Chkproc_srl_no.substring(0,DB_Chkproc_srl_no.length-1);
				DB_Chkdiag_stage_Values	= DB_Chkdiag_stage_Values.substring(0,DB_Chkdiag_stage_Values.length-1);
				DB_Chkproc_stage_Values	= DB_Chkproc_stage_Values.substring(0,DB_Chkproc_stage_Values.length-1);
				DB_Chkdiag_group_Values	= DB_Chkdiag_group_Values.substring(0,DB_Chkdiag_group_Values.length-1);
				DB_Chkdiag_group_seq_Values	= DB_Chkdiag_group_seq_Values.substring(0,DB_Chkdiag_group_seq_Values.length-1);
				DB_Chkproc_group_Values			= DB_Chkproc_group_Values.substring(0,DB_Chkproc_group_Values.length-1);
				DB_Chkproc_group_seq_Values	= DB_Chkproc_group_seq_Values.substring(0,DB_Chkproc_group_seq_Values.length-1);
				DB_Chkdiag_staus_Values			= DB_Chkdiag_staus_Values.substring(0,DB_Chkdiag_staus_Values.length-1);
				DB_Chkproc_staus_Values			= DB_Chkproc_staus_Values.substring(0,DB_Chkproc_staus_Values.length-1);
				/*db_contr_mod_id	 =	db_contr_mod_id.substring(0,db_contr_mod_id.length-1);
				db_code_xtn		 =	db_code_xtn.substring(0,db_code_xtn.length-1);
				db_acess_num		 =	db_acess_num.substring(0,db_acess_num.length-1);
				db_code_xtn_dtl	 =	db_code_xtn_dtl.substring(0,db_code_xtn_dtl.length-1);*/



				parent.frames[4].document.forms[0].activity.value="Confirm";
				parent.frames[4].document.forms[0].Confirm_Dig_Data.value=DB_Chkdiag_Values;
				parent.frames[4].document.forms[0].sel_srl_no.value=DB_Chkdiag_srl_no;
				parent.frames[4].document.forms[0].Confirm_Proc_Data.value=DB_Chkproc_Values;
				parent.frames[4].document.forms[0].sel_proc_srl_no.value=DB_Chkproc_srl_no;
				parent.frames[4].document.forms[0].diag_stage_values_cnfrm.value=DB_Chkdiag_stage_Values;
				parent.frames[4].document.forms[0].proc_stage_values_cnfrm.value=DB_Chkproc_stage_Values;

				parent.frames[4].document.forms[0].diag_group_values_cnfrm.value=DB_Chkdiag_group_Values;
				parent.frames[4].document.forms[0].diag_group_seq_values_cnfrm.value=DB_Chkdiag_group_seq_Values;
				parent.frames[4].document.forms[0].proc_group_values_cnfrm.value=DB_Chkproc_group_Values;
				parent.frames[4].document.forms[0].proc_group_seq_values_cnfrm.value=DB_Chkproc_group_seq_Values;
				parent.frames[4].document.forms[0].diag_status_values_cnfrm.value=DB_Chkdiag_staus_Values;
				parent.frames[4].document.forms[0].proc_status_values_cnfrm.value=DB_Chkproc_staus_Values;
				/*parent.frames[4].document.forms[0].sel_mod_id.value=db_contr_mod_id;
				parent.frames[4].document.forms[0].sel_cod_xtn.value=db_code_xtn;
				parent.frames[4].document.forms[0].sel_acess_num.value=db_acess_num;
				parent.frames[4].document.forms[0].sel_cod_xtn_dtl.value=db_code_xtn_dtl;*/


				parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
				parent.frames[4].document.forms[0].target="messageFrame";
				if(window.confirm(getMessage('CNRFM_DIAG_PROC','MR'))){
					parent.frames[5].location.href='../../eCommon/html/blank.html';
					parent.frames[4].document.forms[0].submit();
				}else{
					parent.frames[5].location.href='../../eCommon/html/blank.html';
					parent.frames[4].document.forms[0].confirm.disabled =false;
					return false;
			}

	}


}



function markScreen(){
	parent.frames[4].document.forms[0].error.disabled=true;
	var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		//parent.RecodeScreen.rows="48%,48%,4%,0%";
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
		parent.document.getElementById("DiagProcTrans").style.height="0vh";

	}else if(allow_recode_diag_yn=="Y"){
		//parent.RecodeScreen.rows="95%,0%,5%,0%";
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="45h";
		parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
		parent.document.getElementById("DiagProcTrans").style.height="0vh";

	}else if(allow_recode_proc_yn=="Y"){
		//parent.RecodeScreen.rows="10%,85%,5%,0%";
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
		parent.document.getElementById("DiagProcTrans").style.height="0vh";

	}
//	parent.frames[5].location.href='../../eCommon/html/blank.html';

	var stage_no=	parent.frames[4].document.forms[0].stage_no;
	var DB_MrkErr_Values="";
	var DB_MrkErr_Srlnos="";
	var DB_MrkErr_Status="";
	var DB_MrkErr_GrpBy="";
	var DB_MrkErr_Stages="";
	var blck_orginl_code= false;
	var temp_val=parent.frames[2].document.forms[0].temp_code.value;
	var temp_proc_val	=	parent.frames[3].document.forms[0].temp_proc.value;
	var procedure_yn	 =	parent.frames[3].document.forms[0].procedure_yn.value;
	if(temp_proc_val==''){
		procedure_yn='';
		 
	}
//	var procedure_yn	 ="";
	if(temp_val=="" && temp_proc_val=="" ){
		alert(getMessage('SEL_DIAG_PROC','MR'));
		parent.frames[4].document.forms[0].error.disabled=false;
		return false;
	}else if(temp_val !='' && temp_proc_val!=''){
		alert(getMessage('DIAG_PROC_RECD','MR'));
		parent.frames[4].document.forms[0].error.disabled=false;
		return false;
	}else{
		var out_arr;
			if(procedure_yn!='Y'){
					 out_arr=temp_val.split("~");
			}else{
				parent.frames[4].document.forms[0].procedure_yn.value="Y";
				out_arr=temp_proc_val.split("~");
			}
			
			for(i=0;i<out_arr.length-1;i++){
				var in_arr=out_arr[i].split("$");
					if(in_arr[6]=="0" || in_arr[5]=="O"){
						blck_orginl_code	=	true;
						break;
					}else if(in_arr[3]=="Review"){
						blck_orginl_code	=	true;
						break;
					}else{
						blck_orginl_code=false;
						DB_MrkErr_Values=DB_MrkErr_Values+"'"+in_arr[1]+"',";
						DB_MrkErr_Srlnos=DB_MrkErr_Srlnos+""+in_arr[4]+",";
						DB_MrkErr_Status=DB_MrkErr_Status+""+in_arr[5]+",";
						DB_MrkErr_Stages=DB_MrkErr_Stages+""+in_arr[6]+",";
						DB_MrkErr_GrpBy=DB_MrkErr_GrpBy+""+in_arr[7]+",";
					}
			}
				if(blck_orginl_code){
							alert(getMessage('MRK_ERR_CHK','MR'));
							//alert('APP-MR0119 Mark error permitted only for recoded status');
							parent.frames[5].location.href='../../eCommon/html/blank.html';
							parent.frames[4].document.forms[0].error.disabled=false;
							return false;
				}else{
						DB_MrkErr_Values	=	DB_MrkErr_Values.substring(0,DB_MrkErr_Values.length-1);
						DB_MrkErr_Srlnos	=	DB_MrkErr_Srlnos.substring(0,DB_MrkErr_Srlnos.length-1);
						DB_MrkErr_Status	=	DB_MrkErr_Status.substring(0,DB_MrkErr_Status.length-1);
						DB_MrkErr_GrpBy	=	DB_MrkErr_GrpBy.substring(0,DB_MrkErr_GrpBy.length-1);
						DB_MrkErr_Stages	=	DB_MrkErr_Stages.substring(0,DB_MrkErr_Stages.length-1);
						parent.frames[4].document.forms[0].activity.value="MarkError";
						parent.frames[4].document.forms[0].marked_err_diagvals.value=DB_MrkErr_Values;
						parent.frames[4].document.forms[0].sel_srl_no.value=DB_MrkErr_Srlnos;//This Hidden Field is in Button Frame
						parent.frames[4].document.forms[0].sel_status.value=DB_MrkErr_Status;//This Hidden Field is in Button Frame
						parent.frames[4].document.forms[0].grpby_val.value=DB_MrkErr_GrpBy;//This Hidden Field is in Button Frame
						parent.frames[4].document.forms[0].sel_stages_val.value=DB_MrkErr_Stages;//This Hidden Field is in Button Frame
						parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
						parent.frames[4].document.forms[0].target="messageFrame";

						if(window.confirm(getMessage('ERR_DIAG_PROC','MR'))){
							parent.frames[4].document.forms[0].submit();
						}else{
							parent.frames[5].location.href='../../eCommon/html/blank.html';
							parent.frames[4].document.forms[0].error.disabled=false;
							return false;
						}
					//}
				}
			}
}

function getLevel(obj){
//	parent.RecodeScreen.rows="47%,47%,5%,0%";
//	alert(parent.frames[1].document.forms[0].all.stage_no.value)

	var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="48%,48%,4%,0%";
	}else if(allow_recode_diag_yn=="Y"){
		parent.RecodeScreen.rows="95%,0%,5%,0%";
	}else if(allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="10%,85%,5%,0%";
	}
	var cur_Sel= obj.value;
//	obj.disabled=true;
	var enctr_id=parent.frames[2].document.forms[0].EncounterId.value;
	var pat_id=parent.frames[2].document.forms[0].Pat_id.value;
	var L1_hdr_status	= parent.frames[1].document.getElementById('L1_hdr_status').value
	var L2_hdr_status	= parent.frames[1].document.getElementById('L2_hdr_status').value
	var L3_hdr_status	= parent.frames[1].document.getElementById('L3_hdr_status').value
	var curr_level			= parent.frames[1].document.getElementById('curr_level').value;
	var hdr_modified_dt		= parent.frames[1].document.getElementById('hdr_modified_dt').value;

	if(cur_Sel == 0){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag0.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_id="+pat_id+"&EncounterId="+enctr_id+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&sel_val="+cur_Sel;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc0.jsp?mode1=show_lvl1&mode=Y&EncounterId="+enctr_id+"&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;

		parent.frames[4].location.href="../../eMR/jsp/DPRecodingButton.jsp?show_level="+obj.value+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&show=O&EncounterId="+enctr_id+"&stage_no="+parent.frames[2].document.getElementById('Stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&execute_hdr_qry=Y";

	}else if(cur_Sel == 1){
		
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_id="+pat_id+"&EncounterId="+enctr_id+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&sel_val="+cur_Sel+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+enctr_id+"&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
		
		parent.frames[4].location.href="../../eMR/jsp/DPRecodingButton.jsp?show_level="+obj.value+"&show=O&EncounterId="+enctr_id+"&stage_no="+parent.frames[2].document.getElementById('Stage_no').value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&sel_val="+cur_Sel+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&execute_hdr_qry=Y";


	}else if(cur_Sel == 2){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_id="+pat_id+"&EncounterId="+enctr_id+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&sel_val="+cur_Sel+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+enctr_id+"&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[4].location.href="../../eMR/jsp/DPRecodingButton.jsp?show_level="+obj.value+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&show=O&EncounterId="+enctr_id+"&stage_no="+parent.frames[2].document.getElementById('Stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&execute_hdr_qry=Y";
	}else if(cur_Sel == 3){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_id="+pat_id+"&EncounterId="+enctr_id+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&sel_val="+cur_Sel+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+enctr_id+"&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[4].location.href="../../eMR/jsp/DPRecodingButton.jsp?show_level="+obj.value+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&show=O&EncounterId="+enctr_id+"&stage_no="+parent.frames[2].document.getElementById('Stage_no').value+"&Pat_id="+pat_id+"&sel_val="+cur_Sel+"&execute_hdr_qry=Y";
	}
		parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";

}


function changePline(encId,fac_id,i,L1_hdr_status,L2_hdr_status,L3_hdr_status,curr_level){
	var fac_id=parent.frames[1].document.getElementById('facility_id').value;
	var hdr_modified_dt=parent.frames[1].document.getElementById('hdr_modified_dt').value;
//	parent.RecodeScreen.rows="47%,47%,5%,0%";
	var allow_recode_diag_yn=parent.frames[1].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[1].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="48%,48%,4%,0%";
	}else if(allow_recode_diag_yn=="Y"){
		parent.RecodeScreen.rows="95%,0%,5%,0%";
	}else if(allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="10%,85%,5%,0%";
	}

	var st_no = parent.frames[1].document.getElementById('stage_no').value;
	parent.frames[0].location.href="../../eCommon/jsp/pline.jsp?Facility_Id="+fac_id+"&EncounterId="+encId;

	if(st_no == 1){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

	}else if(st_no == 2){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;

		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;



	}else if(st_no == 3){
		parent.frames[2].location.href="../../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
		
		parent.frames[3].location.href="../../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&dflt_termset="+parent.frames[1].document.getElementById('dflt_termset').value+"&Pat_sex="+parent.frames[1].document.getElementById('Pat_sex').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&EncounterId="+encId+"&gender="+eval("parent.frames[1].document.getElementById('gender')"+i).value+"&age="+eval("parent.frames[1].document.getElementById('age')"+i).value+"&dob="+eval("parent.frames[1].document.getElementById('dob')"+i).value+"&spec_code="+eval("parent.frames[1].document.getElementById('spec_code')"+i).value+"&Patient_Class="+parent.frames[1].document.getElementById('Patient_Class').value+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;


	}

		
		parent.frames[4].location.href="../../eMR/jsp/DPRecodingButton.jsp?pat_class="+parent.frames[1].document.getElementById('Patient_Class').value+"&EncounterId="+encId+"&stage_no="+parent.frames[1].document.getElementById('stage_no').value+"&Pat_id="+eval("parent.frames[1].document.getElementById('pid')"+i).value+"&execute_hdr_qry=Y";

			
		parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function addTermSet(obj)
{
	
		parent.frames[5].document.getElementById('t1').style.visibility='visible';
		parent.frames[5].document.getElementById('t1').style.display='inline';
		parent.frames[5].document.getElementById('t2').style.visibility='visible';
		parent.frames[5].document.getElementById('t2').style.display='inline';
		obj=0;
		parent.frames[5].document.getElementById('i').value=obj;

}

function newCode(mode){
	parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
	var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
	var confirm_appl=parent.frames[4].document.forms[0].confirm_appl.value; // added by mujafar for ML-MMOH-CRF-0878
	var temp_code = parent.frames[2].document.forms[0].temp_code.value;
	var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
	var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
	var gender = parent.frames[2].document.forms[0].gender.value;
	var age = parent.frames[2].document.forms[0].age.value;
	var dob = parent.frames[2].document.forms[0].dob.value;
	var spec_code = parent.frames[2].document.forms[0].spec_code.value;
	var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
	var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
	var caused_death = parent.frames[2].document.forms[0].caused_death.value;
	var hd_term_code = parent.frames[2].document.forms[0].hd_term_code.value;
	var recode_status = "NEWCODE";
	var procedure_YN	="";
	var allow_recode_diag_yn	="";//Parameter SetUps
	var allow_recode_proc_yn	="";//Parameter SetUps
	/*
		F.Y.I:
		1.This pat_visit_dt_time & pat_disch_dt_time is passed DPRecodingAddModify.jsp only in Case of   Procedure NewCode.
		2.For Diagnosis it will be empty.
	*/
	var pat_visit_dt_time			="";//For SRR-CRF-303.1
	var pat_disch_dt_time			="";//For SRR-CRF-303.1
//	parent.RecodeScreen.rows="48%,48%,4%,0%";

parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
parent.document.getElementById("RecDiagnosisProc").style.height="41vh";
parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
parent.document.getElementById("DiagProcTrans").style.height="20vh";
//parent.document.getElementById("DiagProcTrans").style.width="75vh";
parent.document.getElementById("DiagProcTrans").style.display="none";

	if(mode=="Diag"){
		procedure_YN ="N";
		allow_recode_diag_yn	=parent.frames[2].document.forms[0].allow_recode_diag_yn.value;	
		allow_recode_proc_yn	=parent.frames[2].document.forms[0].allow_recode_proc_yn.value;
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		//	parent.RecodeScreen.rows="35%,25%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="20vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="25vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}else if(allow_recode_diag_yn=="Y"){
			//parent.RecodeScreen.rows="50%,0%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="20vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="25vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}
	}else{
		parent.frames[3].document.forms[0].procedure_yn.value="Y";
		//procedure_YN	= parent.frames[3].document.forms[0].procedure_yn.value ;
		procedure_YN="Y";
		allow_recode_diag_yn	=parent.frames[3].document.forms[0].allow_recode_diag_yn.value;	
		allow_recode_proc_yn	=parent.frames[3].document.forms[0].allow_recode_proc_yn.value;
		pat_visit_dt_time			=parent.frames[3].document.forms[0].pat_visit_dt_time.value;
		pat_disch_dt_time		=parent.frames[3].document.forms[0].pat_disch_dt_time.value;
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			//parent.RecodeScreen.rows="35%,25%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="20vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="25vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}else if(allow_recode_proc_yn=="Y"){
			//parent.RecodeScreen.rows="8%,40%,5%,*";
			parent.document.getElementById("RecDiagnosisDiag").style.height="30vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="20vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="25vh";
			//parent.document.getElementById("DiagProcTrans").style.width="75vh";
			parent.document.getElementById("DiagProcTrans").style.display="inline";
		}
	}
var prin_diag_yn='N';
if(parent.frames[2].document.forms[0].principal_diag.value!=''){
	prin_diag_yn='Y';
}
//	parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?newCode_yn=Y&procedure_yn="+parent.frames[3].document.forms[0].procedure_yn.value+"&stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code;

/* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?confirm_appl="+confirm_appl+"&newCode_yn=Y&procedure_yn="+procedure_YN+"&stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code+"&prin_diag="+prin_diag_yn+"&pat_visit_dt_time="+pat_visit_dt_time+"&pat_disch_dt_time="+pat_disch_dt_time+"&specialty_code="+parent.frames[2].document.forms[0].specialty_code.value+"&isMultiDescAppl="+parent.frames[2].document.forms[0].isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281
// modified by mujafar for ML-MMOH-CRF-0878
	
			//parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code;


	
}

function completeScreen(){
	
	parent.frames[4].document.forms[0].complete.disabled=true;
	var allow_recode_diag_yn=parent.frames[2].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[2].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		//parent.RecodeScreen.rows="48%,48%,4%,0%";
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
		parent.document.getElementById("DiagProcTrans").style.height="0vh";

	}else if(allow_recode_diag_yn=="Y"){
//		parent.RecodeScreen.rows="95%,0%,5%,0%";
		parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
		parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
		parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
		parent.document.getElementById("DiagProcTrans").style.height="20vh";

	}else if(allow_recode_proc_yn=="Y"){
	//	parent.RecodeScreen.rows="10%,85%,5%,0%";
	parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
	parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
	parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
	parent.document.getElementById("DiagProcTrans").style.height="0vh";

	}
//	parent.frames[5].location.href='../../eCommon/html/blank.html';
	var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
	var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;


	var out_arr="";

	var DB_Chkdiag_Values="";
	var DB_Chkdiag_srl_no="";
	var DB_Chkproc_Values="";
	var DB_Chkproc_srl_no="";

	var error='';
	if(final_diag_values!=""){
		 out_arr=final_diag_values.split("~");
		for(i=0;i<out_arr.length-1;i++){
			var in_arr=out_arr[i].split("$");
			if(in_arr[3]=='Review'){
				error="Y";
				break;
			}
			
		}
	}
	
	if(final_proc_values!=""){
		out_arr1=final_proc_values.split("~");
		for(ij=0;ij<out_arr1.length-1;ij++){
			var in_arr1=out_arr1[ij].split("$");
			if(in_arr1[3]=='Review'){
				error="Y";
				break;
			}

		}
	}
	if(error=="Y"){
		alert(getMessage('MR_REV_CNT_COMP','MR'))
		parent.frames[4].document.forms[0].complete.disabled=false;
		parent.frames[5].location.href='../../eCommon/html/blank.html';
		return false;
	}else{
		if(window.confirm(getMessage('CMPL_DIAG_PROC','MR'))){

					parent.frames[4].document.forms[0].activity.value="Complete";
					parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
					parent.frames[4].document.forms[0].target="messageFrame";
					parent.frames[4].document.forms[0].submit();
		}else{
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			parent.frames[4].document.forms[0].complete.disabled=false;
			return false;
		}
	}
}

function rejectScreen(){
	var allow_recode_diag_yn=parent.frames[4].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[4].document.getElementById('allow_recode_proc_yn').value;

	parent.frames[4].document.forms[0].activity.value="Reject";
	parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
	parent.frames[4].document.forms[0].target="messageFrame";
	parent.frames[4].document.forms[0].submit();
//	parent.RecodeScreen.rows="47%,47%,5%,0%";
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="48%,48%,4%,0%";
	}else if(allow_recode_diag_yn=="Y"){
		parent.RecodeScreen.rows="95%,0%,5%,0%";
	}else if(allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="10%,85%,5%,0%";
	}
}


function validate_duplicate_proc(Obj,indx){


	/*
	var sel_val=Obj.value;
	var prev_val="";
	var sec_obj="";

	var count_val=parent.frames[3].document.forms[0].proc_seq_no.value;	
	
	if(count_val>1){
		for(ij=0;ij<count_val;ij++){



			var obj_seq= eval("parent.frames[3].document.forms[0].seqproc"+ij);
			//alert('a'+obj_seq.value)
			//alert('b'+sel_val)
			//alert('c'+obj_seq.name)
			//alert('d'+Obj.name)
		

			if(obj_seq.value==sel_val && obj_seq.name!= Obj.name){

				if(obj_seq.value!="99999"){
					sec_obj=obj_seq;
					break;
				}else{
					alert('else')
					sec_obj=obj_seq;
				}

			}
			
			
		}

		for(kk=1;kk<=count_val;kk++){
			var inx=kk;
			
			var cntr=0;
			for(ij=0;ij<count_val;ij++){


				var obj_seq= eval("parent.frames[3].document.forms[0].seqproc"+ij);

				if(parseInt(obj_seq.value)==parseInt(kk)){
					cntr++;
				}
			
			
			}

			if(cntr==0){
				break;
			}

		}

	}
	//alert(Obj.name);
	alert(sec_obj.name);
	
	sec_obj.options.selectedIndex=(parseInt(inx)-1);
	*/
}

function validate_duplicate_diag(Obj,indx){

	
	/*var count_val=parent.frames[2].document.forms[0].diag_seq_no.value;
	alert('count_val' + count_val)
	alert('Obj' + Obj.value)
	alert('indx' + indx)
	var hid_val=eval("parent.frames[2].document.forms[0].hdd_trx_no"+indx).value;
	var flg=true;
	if(Obj.value!='99999'){
		for(ij=1;ij<count_val;ij++){		
			if(indx!== ij){
				var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);
				if (obj_seq.value==Obj.value ){
					//if(Obj.value!=='99999'){
						alert("Cannot have duplicate sequence number");
						Obj.value=hid_val;
						flg=false;
						break;
					//}else{
						//if(Obj.value=='99999'){
							//eval("parent.frames[2].document.forms[0].hdd_trx_no"+indx).value='99999';
							//break;
						//}
					//}
				}

			}
		}
		alert(flg)
		if(flg){

			eval("parent.frames[2].document.forms[0].hdd_trx_no"+indx).value=Obj.value;
		}

	}else{
		eval("parent.frames[2].document.forms[0].hdd_trx_no"+indx).value='99999';
	}
	*/

	/*
	var sel_val=Obj.value;
	var prev_val="";
	var sec_obj="";

	var count_val=parent.frames[2].document.forms[0].diag_seq_no.value;
	var prin_YN=parent.frames[2].document.forms[0].principal_diag.value;
	if(prin_YN!=''){

			if(count_val>1){
				for(ij=1;ij<count_val;ij++){


					var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);
					if(obj_seq.value==sel_val && obj_seq.name!= Obj.name && obj_seq.value!="99999" ){
						sec_obj=obj_seq;
						break;

					}
					
					
				}
				for(kk=2;kk<=count_val;kk++){
					var inx=kk;
					
					var cntr=0;
					for(ij=1;ij<count_val;ij++){


						var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);

						if(parseInt(obj_seq.value)==parseInt(kk)){
							cntr++;
						}
					
					
					}

					if(cntr==0){
						break;
					}

				}

			}
			sec_obj.value=eval(inx);
	}else{
			if(count_val>1){
				for(ij=0;ij<count_val;ij++){


					var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);

					if(obj_seq.value==sel_val && obj_seq.name!= Obj.name){
						sec_obj=obj_seq;
						break;

					}
					
					
				}

				for(kk=1;kk<=count_val;kk++){
					var inx=kk;
					
					var cntr=0;
					for(ij=0;ij<count_val;ij++){


						var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);

						if(parseInt(obj_seq.value)==parseInt(kk)){
							cntr++;
						}
					
					
					}

					if(cntr==0){
						break;
					}

				}

			}
			sec_obj.value=(eval(inx)-1);
	}
	//alert(Obj.name);
	//alert(sel_val);
	
	*/

}

function Open_DRG(pval){
	var allow_recode_diag_yn=parent.frames[4].document.getElementById('allow_recode_diag_yn').value;
	var allow_recode_proc_yn=parent.frames[4].document.getElementById('allow_recode_proc_yn').value;
	if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="35%,25%,5%,*";
	}else if(allow_recode_diag_yn=="Y"){
		parent.RecodeScreen.rows="50%,0%,5%,*";
	}else if(allow_recode_proc_yn=="Y"){
		parent.RecodeScreen.rows="5%,40%,5%,*";
	}
//}
//		parent.RecodeScreen.rows="35%,25%,5%,*";
		if(pval=='x'){
		parent.frames[5].location.href="../../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=Y&Pat_id="+parent.frames[4].document.getElementById("Pat_id").value+"&EncounterId="+parent.frames[4].document.getElementById('EncounterId').value+"&stage_no="+parent.frames[4].document.getElementById('stage_no').value+"&confirm_appl="+parent.frames[4].document.getElementById('confirm_appl').value;
		// modified by mujafar for ML-MMOH-CRF-0878
		}else{
			//parent.frames[5].location.href="../eMR/jsp/DPRecodingDRGFrames.jsp?DRGcal=N&Pat_id="+parent.frames[4].document.forms[0].all.Pat_id.value+"&EncounterId="+parent.frames[4].document.forms[0].all.EncounterId.value;
		}
		

		var count_val_diag=parent.frames[2].document.forms[0].diag_seq_no.value;
		var count_val_proc=parent.frames[3].document.forms[0].proc_seq_no.value;
		var prim='N';
//		alert('count_val_diag'+count_val_diag)
		if(parent.frames[2].document.forms[0].principal_diag.value!=''){
			prim='Y'
		}
		//alert(count_val_diag)
		//alert(prim)
		if(count_val_diag>1){
			for(ij=0;ij<count_val_diag;ij++){


				var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);
				obj_seq.disabled=false;

				if(prim=='Y'){

					if( ij==0){
						var temp = 1;
						var opt=document.createElement("OPTION");
						opt.text=temp;
						opt.value=temp;
						obj_seq.add(opt);
						obj_seq.options.selectedIndex=ij;
						parent.frames[2].document.forms[0].seqdiag0.disabled=true;

					}else{

						for(k=2;k<=count_val_diag;k++){			
					
							var temp = k;
							var opt=document.createElement("OPTION");
							opt.text=temp;
							opt.value=temp;
							obj_seq.add(opt);					
						}

							var temp = k;
							var opt=document.createElement("OPTION");
							opt.text='NA';
							opt.value='99999';
							obj_seq.add(opt);
							//obj_seq.value=eval(ij)+1;  commented on 23/jan/2009
							obj_seq.value=eval("parent.frames[2].document.forms[0].hdd_trx_no"+ij).value;


						
					}

				}else{

					for(k=0;k<=count_val_diag;k++){			
					
						var temp = k;
						var opt=document.createElement("OPTION");
						opt.text=temp;
						opt.value=temp;
						obj_seq.add(opt);					
					}
					obj_seq.options.selectedIndex=ij;
				}
				

				
			}

		}else{
			if(count_val_diag !=0){
				var obj_seq= parent.frames[2].document.forms[0].seqdiag0;
				obj_seq.disabled=false;				
				var temp = 1;
				var opt=document.createElement("OPTION");
				opt.text=temp;
				opt.value=temp;
				obj_seq.add(opt);
				obj_seq.value=1;

				if(prim=='Y'){
					obj_seq.disabled=true;
				}
			}
		}
		
			
		

		if(count_val_proc>1){
			for(ijk=0;ijk<count_val_proc;ijk++){
				var obj_seq1= eval("parent.frames[3].document.forms[0].seqproc"+ijk);
				obj_seq1.disabled=false;


				for(kik=1;kik<=count_val_proc;kik++){
					var temp = kik;
					var opt=document.createElement("OPTION");
					opt.text=temp;
					opt.value=temp;
					obj_seq1.add(opt);					
				}
//				var temp = k; Modified 10/25/2010 
				var opt=document.createElement("OPTION");
				opt.text='NA';
				opt.value='99999';
				obj_seq1.add(opt);
				//if(eval("parent.frames[3].document.forms[0].hdd_trx_no"+ijk).value=='99999'){
					obj_seq1.value=eval("parent.frames[3].document.forms[0].hdd_trx_no"+ijk).value;
				//}else{
					//obj_seq1.options.selectedIndex=ijk;
				//}

				
				
				
			}

		}else{
			if(count_val_proc !=0){
				var obj_seq1= parent.frames[3].document.forms[0].seqproc0;
				obj_seq1.disabled=false;				
				var temp = 1;
				var opt=document.createElement("OPTION");
				opt.text=temp;
				opt.value=temp;
				obj_seq1.add(opt);
				obj_seq1.value=1;

				
			}

		}

		if(parent.frames[4].document.forms[0].calDRG)
			parent.frames[4].document.forms[0].calDRG.disabled=false;

		if(parent.frames[4].document.forms[0].seqDrg)
			parent.frames[4].document.forms[0].seqDrg.disabled=true;



}

/*function SeqIndex(i,sel)
{
	var drg_cnt = parent.frames[2].document.forms[0].all.i.value;
		//alert("drg_cnt "+drg_cnt);

	var j=i+1;

	if(sel.value == 2)
	{
		eval("parent.frames[2].document.forms[0].all.seqNo"+j).options[0].selected = true;
			var drg_temp=eval("parent.frames[2].document.forms[0].all.seqNo"+j).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+j).value+"&"+eval("parent.frames[2].document.forms[0].all.seqNo"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+i).value+"~"

		//if(i ==1)
		//	eval("parent.frames[2].document.forms[0].all.seqNo"+i).options[0].selected = true;
	}
	else if(sel.value == 1)
	{
		eval("parent.frames[2].document.forms[0].all.seqNo"+j).options[1].selected = true;

		var drg_temp=eval("parent.frames[2].document.forms[0].all.seqNo"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.seqNo"+j).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+j).value+"~"
//		if(i ==1)
//			eval("parent.frames[2].document.forms[0].all.seqNo"+i).options[1].selected = true;

	}

	parent.frames[2].document.forms[0].all.drg_temp.value = drg_temp;
}
*/
function Reject_Drg(){

	var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
	var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;
	var allow_recode_diag_yn=parent.frames[4].document.forms[0].allow_recode_diag_yn.value;
	var allow_recode_proc_yn=parent.frames[4].document.forms[0].allow_recode_proc_yn.value;

	var stg_no=parent.frames[2].document.forms[0].Stage_no.value;

	var out_arr="";

	var DB_Chkdiag_Values="";
	var DB_Chkdiag_srl_no="";
	var DB_diag_confirm_yn="";
	var DB_Chkproc_Values="";
	var DB_Chkproc_srl_no="";
	var DB_proc_confirm_yn="";
	var DB_Diag_group_yn="";
	var DB_Diag_group_seq_no="";
	var DB_Diag_support_seq_no="";
	var DB_Proc_group_yn="";
	var stage_auth="D";


	if(final_diag_values!=""){
		 out_arr=final_diag_values.split("~");
		for(i=0;i<out_arr.length-1;i++){
			var in_arr=out_arr[i].split("$");
			DB_Chkdiag_Values=DB_Chkdiag_Values+"'"+in_arr[1]+"',";
			DB_Chkdiag_srl_no=DB_Chkdiag_srl_no+"'"+in_arr[4]+"',";
			DB_diag_confirm_yn=DB_diag_confirm_yn+in_arr[10]+",";
			DB_Diag_group_yn=DB_Diag_group_yn+in_arr[7]+",";//Added On 7/2/2009
			DB_Diag_group_seq_no=DB_Diag_group_seq_no+in_arr[9]+",";//Added On 2/17/2010 For [IN015597]
			DB_Diag_support_seq_no=DB_Diag_support_seq_no+"'"+in_arr[11]+"',";//Added On 2/17/2010 For [IN015597]
			if(eval(in_arr[6])==stg_no){
				stage_auth="S";
			}
		}
	}
	
	if(final_proc_values!=""){
		out_arr1=final_proc_values.split("~");
		for(ij=0;ij<out_arr1.length-1;ij++){
			var in_arr1=out_arr1[ij].split("$");
			DB_Chkproc_Values=DB_Chkproc_Values+"'"+in_arr1[1]+"',";
			DB_Chkproc_srl_no=DB_Chkproc_srl_no+"'"+in_arr1[4]+"',";
			DB_proc_confirm_yn=DB_proc_confirm_yn+in_arr1[10]+",";
			DB_Proc_group_yn=DB_Proc_group_yn+in_arr1[7]+",";//Added On 7/2/2009
			if(eval(in_arr1[6])==stg_no){
				stage_auth="S";
			}

		}
	}
	DB_Chkdiag_Values=DB_Chkdiag_Values.substring(0,DB_Chkdiag_Values.length-1);
	DB_Chkdiag_srl_no=DB_Chkdiag_srl_no.substring(0,DB_Chkdiag_srl_no.length-1);
	DB_Chkproc_Values=DB_Chkproc_Values.substring(0,DB_Chkproc_Values.length-1);
	DB_Chkproc_srl_no=DB_Chkproc_srl_no.substring(0,DB_Chkproc_srl_no.length-1);
	DB_proc_confirm_yn=DB_proc_confirm_yn.substring(0,DB_proc_confirm_yn.length-1);
	DB_diag_confirm_yn=DB_diag_confirm_yn.substring(0,DB_diag_confirm_yn.length-1);
	DB_Diag_group_yn=DB_Diag_group_yn.substring(0,DB_Diag_group_yn.length-1);//Added On 7/2/2009
	DB_Diag_group_seq_no=DB_Diag_group_seq_no.substring(0,DB_Diag_group_seq_no.length-1);//Added On 2/17/2010 For [IN015597]
	DB_Diag_support_seq_no=DB_Diag_support_seq_no.substring(0,DB_Diag_support_seq_no.length-1);//Added On 2/17/2010 For [IN015597]
	DB_Proc_group_yn=DB_Proc_group_yn.substring(0,DB_Proc_group_yn.length-1);//Added On 7/2/2009

	parent.frames[4].document.forms[0].Confirm_Dig_Data.value=DB_Chkdiag_Values;
	parent.frames[4].document.forms[0].sel_srl_no.value=DB_Chkdiag_srl_no;
	parent.frames[4].document.forms[0].Confirm_Proc_Data.value=DB_Chkproc_Values;
	parent.frames[4].document.forms[0].sel_proc_srl_no.value=DB_Chkproc_srl_no;
	parent.frames[4].document.forms[0].final_diag_confirm_yn.value=DB_diag_confirm_yn;
	parent.frames[4].document.forms[0].final_proc_confirm_yn.value=DB_proc_confirm_yn;
	parent.frames[4].document.forms[0].final_Diag_group_yn.value=DB_Diag_group_yn;//Added On 7/2/2009
	parent.frames[4].document.forms[0].group_seq_no_data.value=DB_Diag_group_seq_no;//Added On 7/2/2009
	parent.frames[4].document.forms[0].support_seq_no_data.value=DB_Diag_support_seq_no;//Added On 7/2/2009
	parent.frames[4].document.forms[0].final_Proc_group_yn.value=DB_Proc_group_yn;//Added On 7/2/2009
	parent.frames[4].document.forms[0].stage_auth.value=stage_auth;


//	parent.RecodeScreen.rows="47%,47%,5%,0%";
//	parent.RecodeScreen.rows="47%,47%,5%,0%";
		if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="48%,48%,4%,0%";
		}else if(allow_recode_diag_yn=="Y"){
			parent.RecodeScreen.rows="95%,0%,5%,0%";
		}else if(allow_recode_proc_yn=="Y"){
			parent.RecodeScreen.rows="10%,85%,5%,0%";
		}

	parent.frames[4].document.forms[0].activity.value="RejectDRG";
	parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
	parent.frames[4].document.forms[0].target="messageFrame";
	parent.frames[4].document.forms[0].submit();

}

function recallDRG(){
		parent.frames[4].document.forms[0].calDrg.disabled=true;
		parent.frames[4].document.forms[0].reject.disabled=true;
		
		if(parent.parent.frames[5].document.forms[0].document.forms[0].Save){
			parent.parent.frames[5].document.forms[0].document.forms[0].Save.disabled=true;
		}
		var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
		var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;
		var allow_recode_diag_yn=parent.frames[4].document.forms[0].allow_recode_diag_yn.value;	
		var allow_recode_proc_yn=parent.frames[4].document.forms[0].allow_recode_proc_yn.value;	
		var count_val_diag=parent.frames[2].document.forms[0].diag_seq_no.value;	
		var count_val_proc=parent.frames[3].document.forms[0].proc_seq_no.value;	
		var diag_new_seq="";
		var proc_new_seq="";
		var flg_diag=true;
		if(count_val_diag>1){
			for(ij=0;ij<count_val_diag;ij++){
				var obj_seq= eval("parent.frames[2].document.forms[0].seqdiag"+ij);
				for(pp=0;pp<count_val_diag;pp++){
					if(pp!= ij ){
						var obj_seq_temp= eval("parent.frames[2].document.forms[0].seqdiag"+pp);
						if(obj_seq.value==obj_seq_temp.value && obj_seq.value !='99999'){
							flg_diag=false;
							break ;
						}
					}					
				}
				if(!flg_diag){
						break;
				}
				diag_new_seq=diag_new_seq+"'"+obj_seq.value+"',";
			}
		}
		var flg_proc=true;
		if(count_val_proc>1){
			for(ijk=0;ijk<count_val_proc;ijk++){
				var obj_seq= eval("parent.frames[3].document.forms[0].seqproc"+ijk);
				for(pnr=0;pnr<count_val_proc;pnr++){
					if(pnr!= ijk ){
						var obj_seq_temp1= eval("parent.frames[3].document.forms[0].seqproc"+pnr);
						if(obj_seq.value==obj_seq_temp1.value && obj_seq.value !='99999'){
							flg_proc=false;
							break ;
						}
					}
				}
				if(!flg_proc){
						break;
				}
				proc_new_seq=proc_new_seq+"'"+obj_seq.value+"',";
			}
		}
		if(flg_diag && flg_proc){
			var out_arr="";
			var DB_Chkdiag_Values="";
			var DB_Chkdiag_srl_no="";
			var DB_Chkproc_Values="";
			var DB_Chkproc_srl_no="";
			var DB_Diag_group_yn="";
			var DB_Diag_group_yn="";//Added On 2/17/2010 For [IN015597]
			var DB_Diag_group_seq_no="";//Added On 2/17/2010 For [IN015597]
			var DB_Diag_support_seq_no="";//Added On 2/17/2010 For [IN015597]
			if(final_diag_values!=""){
				 out_arr=final_diag_values.split("~");
				for(i=0;i<out_arr.length-1;i++){
					var in_arr=out_arr[i].split("$");
					DB_Chkdiag_Values=DB_Chkdiag_Values+"'"+in_arr[1]+"',";
					DB_Chkdiag_srl_no=DB_Chkdiag_srl_no+"'"+in_arr[4]+"',";
					DB_Diag_group_yn=DB_Diag_group_yn+in_arr[7]+",";//Added On 2/22/2010 For [IN015597]
					DB_Diag_group_seq_no=DB_Diag_group_seq_no+in_arr[9]+",";//Added On 2/22/2010 For [IN015597]
					DB_Diag_support_seq_no=DB_Diag_support_seq_no+"'"+in_arr[11]+"',";//Added On 2/22/2010 For [IN015597]
				}
			}
			if(final_proc_values!=""){
				out_arr1=final_proc_values.split("~");
				for(ij=0;ij<out_arr1.length-1;ij++){
					var in_arr1=out_arr1[ij].split("$");
					DB_Chkproc_Values=DB_Chkproc_Values+"'"+in_arr1[1]+"',";
					DB_Chkproc_srl_no=DB_Chkproc_srl_no+"'"+in_arr1[4]+"',";
				}
			}
			DB_Chkdiag_Values				= DB_Chkdiag_Values.substring(0,DB_Chkdiag_Values.length-1);
			DB_Chkdiag_srl_no				= DB_Chkdiag_srl_no.substring(0,DB_Chkdiag_srl_no.length-1);
			DB_Diag_group_seq_no		= DB_Diag_group_seq_no.substring(0,DB_Diag_group_seq_no.length-1);//Added On 2/17/2010 For [IN015597]
			DB_Diag_support_seq_no	= DB_Diag_support_seq_no.substring(0,DB_Diag_support_seq_no.length-1);//Added On 2/17/2010 For [IN015597]

			DB_Chkproc_Values=DB_Chkproc_Values.substring(0,DB_Chkproc_Values.length-1);
			DB_Chkproc_srl_no=DB_Chkproc_srl_no.substring(0,DB_Chkproc_srl_no.length-1);
			diag_new_seq=diag_new_seq.substring(0,diag_new_seq.length-1);
			proc_new_seq=proc_new_seq.substring(0,proc_new_seq.length-1);

			parent.frames[4].document.forms[0].diag_new_seq.value=diag_new_seq;
			parent.frames[4].document.forms[0].proc_new_seq.value=proc_new_seq;
			parent.frames[4].document.forms[0].Confirm_Dig_Data.value=DB_Chkdiag_Values;
			parent.frames[4].document.forms[0].sel_srl_no.value=DB_Chkdiag_srl_no;
			parent.frames[4].document.forms[0].final_Diag_group_yn.value=DB_Diag_group_yn;//Added On 2/17/2010 For [IN015597]
			parent.frames[4].document.forms[0].group_seq_no_data.value=DB_Diag_group_seq_no;//Added On 2/17/2010 For [IN015597]
			parent.frames[4].document.forms[0].support_seq_no_data.value=DB_Diag_support_seq_no;//Added On 2/17/2010 For [IN015597]
			parent.frames[4].document.forms[0].Confirm_Proc_Data.value=DB_Chkproc_Values;
			parent.frames[4].document.forms[0].sel_proc_srl_no.value=DB_Chkproc_srl_no;
	//		parent.RecodeScreen.rows="47%,47%,5%,0%";
			if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
				parent.RecodeScreen.rows="48%,48%,4%,0%";
			}else if(allow_recode_diag_yn=="Y"){
				parent.RecodeScreen.rows="95%,0%,5%,0%";
			}else if(allow_recode_proc_yn=="Y"){
				parent.RecodeScreen.rows="10%,85%,5%,0%";
			}
			parent.frames[4].document.forms[0].activity.value="ReCalculateDRG";
			parent.frames[4].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
			parent.frames[4].document.forms[0].target="messageFrame";
			parent.frames[4].document.forms[0].submit();
		}else{
			var err_msg	=getMessage("DUP_SEQ_NO_NOT_ALLOWED",'MR');
			alert(err_msg);
			parent.frames[4].document.forms[0].calDrg.disabled=false;
			parent.frames[4].document.forms[0].reject.disabled=false;
			if(parent.parent.frames[5].document.forms[0].document.forms[0].Save)
				parent.parent.frames[5].document.forms[0].document.forms[0].Save.disabled=false;
		}
}


function chkDiag(){
	if(parent.frames[5].document.forms[0].newCode_yn.value == 'Y')
		parent.frames[5].document.forms[0].addDiag.disabled=true;
	else
		parent.frames[5].document.forms[0].addDiag.disabled=false;
}

function checkMaxLimitOfRemark(obj)
{
	if ( obj.value.length > 30 )
	{
		var invaldtFrom = getMessage("REMARKS_XCEED_2000_CHARS","MR") ;
		invaldtFrom = invaldtFrom.replace('2000','30');
		alert(invaldtFrom);
		obj.select();
		return false;
	}
	else
		return true;
	
}

async function callTermCode(obj)
{		
		var temp_term_code = "";
		//var term_desc = document.Procedure_List.proc_desc.value
		var term_desc = "";
		var term_code_associated = "";
		var mode ="";
		
		var mulitple_yn = "";
		var term_set_id= document.forms[0].code_set.value;
		var retVal = new String();
		var dialogTop   = "10px";
	    var dialogHeight= "80vh" ;
	    var dialogWidth = "55vw" ;
	    
		var status = "no";
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(tit)+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc+"&recode_yn=Y";
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await top.window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
	
		if( returnVal == null || returnVal == "" ){
			/*if(obj=='1'){
			document.forms[0].diagprob_code.value = "";
			document.forms[0].diagprob_desc.value = "";
			}else if(obj=='2'){
				document.forms[0].diagprob_code1.value = "";
				document.forms[0].diagprob_desc1.value = "";
			}else if(obj=='3'){
				document.forms[0].diagprob_code2.value = "";
				document.forms[0].diagprob_desc2.value = "";
			}*/
			//document.Procedure_List.diagprob_code.value="";
			//document.Procedure_List.proc_desc.value="";
			
		}else{
			
			var retValCode = returnVal.split("||") ;
			var retVal		 = retValCode[0].split("\"") ;
			term_code		 = retVal[0];
			term_code_desc	 = retVal[1];
			level_desc		 = retVal[2];
			level			 = retVal[3];
			
			if(obj=='1'){
//				document.forms[0].diagprob_code.focus();
				document.forms[0].diagprob_code.value = trimString(term_code);
				document.forms[0].diagprob_desc.value = retValCode[1];
				document.forms[0].diagprob_code.onblur();
			}else if(obj=='2'){
//				document.forms[0].diagprob_code1.focus();
				document.forms[0].diagprob_code1.value = trimString(term_code);
				document.forms[0].diagprob_desc1.value = retValCode[1];
				document.forms[0].diagprob_code1.onblur();

			}else if(obj=='3'){
//				document.forms[0].diagprob_code2.focus();
				document.forms[0].diagprob_code2.value = trimString(term_code);
				document.forms[0].diagprob_desc2.value = retValCode[1];
				document.forms[0].diagprob_code2.onblur();
			}

			
		}
}

function validateDate(obj,obj2) {
		var from = obj.value;
	
		var to   = document.forms[0].currentdate.value;
        var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var locale= document.forms[0].locale.value;
		if (validDate(obj.value,"DMY",locale)){
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
			}
		}

		function validateDatetime(obj,obj2) {
			var from = obj.value;
			if(!from==""){
				var to   = document.forms[0].currentdate.value;
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
					var locale= document.forms[0].locale.value;
					if(validDate(obj.value,"DMYHM",locale)){
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
					}else{        
						alert(getMessage("INVALID_DATE_FMT", "SM"));
						obj.select();
						obj.focus();
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
				}
			}
		}

async function callDetails(cal_from,term_set,term_code,EncounterId,stg_srl_no,procedureYN,accession_num,contr_mod_id){
	  var dialogTop="0vh";
	  var center='1';
			/*if (cal_from=="Diag"){
			dialogTop = "240";
		}else if("Proc"){
			dialogTop = "430";		
		}*/
		if(contr_mod_id=="OR"){
			accession_num=accession_num.replace("#","$")
		}
	  var dialogHeight = "35vh" ;
	  var dialogWidth = "60vw" ;
	  var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	  var arguments = "" ;
	  retVal=await window.showModalDialog("../../eMR/jsp/DPDisplayEquiSpprtDiagFrames.jsp?cal_from="+cal_from+"&term_set="+term_set+"&term_code="+term_code+"&EncounterId="+EncounterId+"&stg_srl_no="+stg_srl_no+"&procedureYN="+procedureYN+"&accession_num="+accession_num+"&contr_mod_id="+contr_mod_id,arguments,features);
}

	//function disable_confirmed_Buttons_dum(){
			//setTimeout('disable_confirmed_Buttons()',250);
   // }
	function disable_confirmed_Buttons(){

					var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
					var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;

					var out_arr="";

					var DB_Chkdiag_Values="";
					var DB_Chkdiag_srl_no="";
					var DB_Chkproc_Values="";
					var DB_Chkproc_srl_no="";

					var error='';


					if(final_diag_values!=""){
						 out_arr=final_diag_values.split("~");
						for(i=0;i<out_arr.length-1;i++){
							var in_arr=out_arr[i].split("$");
							if(in_arr[3]!='Confirmed'){
								error="Y";
								break;
							}
							
						}
					}
					
					if(final_proc_values!=""){
						out_arr1=final_proc_values.split("~");
						for(ij=0;ij<out_arr1.length-1;ij++){
							var in_arr1=out_arr1[ij].split("$");
							if(in_arr1[3]!='Confirmed'){
								error="Y";
								break;
							}

						}
					}
					
					if(error==""){
						if(parent.frames[4].document.forms[0].recode){
							parent.frames[4].document.forms[0].recode.disabled=true;
						}

						if(parent.frames[4].document.forms[0].confirm){
							parent.frames[4].document.forms[0].confirm.disabled=true;
						}

						if(parent.frames[4].document.forms[0].error){
							parent.frames[4].document.forms[0].error.disabled=true;
						}
					}
		}	
function dis_but_dum(obj){
	if(obj>0){
		setTimeout('dis_but()',100);
	}
}

function dis_but(){
	if(parent.frames[2].document.forms[0] && parent.frames[3].document.forms[0]){
		var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
		var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;
		var out_arr="";

		var DB_Chkdiag_Values="";
		var DB_Chkdiag_srl_no="";
		var DB_Chkproc_Values="";
		var DB_Chkproc_srl_no="";

		var error='';
		var diff_code="N";

		var diag_tset=parent.frames[4].document.forms[0].rec_diag_tset.value;
		var proc_tset=parent.frames[4].document.forms[0].rec_proc_tset.value;
if(final_diag_values=="" && final_proc_values==""){
		parent.frames[4].document.forms[0].recode.disabled=true;
		parent.frames[4].document.forms[0].confirm.disabled=true;
		parent.frames[4].document.forms[0].error.disabled=true;
		parent.frames[4].document.forms[0].complete.disabled=true;
		return false;
}else{
		if(final_diag_values!=""){
			 out_arr=final_diag_values.split("~");
			for(i=0;i<out_arr.length-1;i++){
				var in_arr=out_arr[i].split("$");
				if(in_arr[3]!='Confirmed'){
					error="Y";
					break;
				}     
				
			}
		}
						
		if(final_proc_values!=""){
			out_arr1=final_proc_values.split("~");
			for(ij=0;ij<out_arr1.length-1;ij++){
				var in_arr1=out_arr1[ij].split("$");
				if(in_arr1[3]!='Confirmed'){
					error="Y";
					break;
				}

			}
		}
		if(error==""){
			if(parent.frames[4].document.forms[0].recode){
				parent.frames[4].document.forms[0].recode.disabled=true;
			}

			if(parent.frames[4].document.forms[0].confirm){
				parent.frames[4].document.forms[0].confirm.disabled=true;
			}

			if(parent.frames[4].document.forms[0].error){
				parent.frames[4].document.forms[0].error.disabled=true;
			}

		}

		if(final_diag_values!=""){
			out_arr=final_diag_values.split("~");
			for(i=0;i<out_arr.length-1;i++){
				var in_arr=out_arr[i].split("$");
				if(in_arr[2]!=diag_tset){
					diff_code="Y";
					break;
				}     
				
			}
		}
						
		if(final_proc_values!=""){
			out_arr1=final_proc_values.split("~");
			for(ij=0;ij<out_arr1.length-1;ij++){
				var in_arr1=out_arr1[ij].split("$");
				if(in_arr1[2]!=proc_tset){
					diff_code="Y";
					break;
				}

			}
		}
				if(diff_code=="Y"){
					if(parent.frames[4].document.forms[0].confirm){
					//				parent.frames[4].document.forms[0].confirm.disabled=true;
				}
			}
		}	
	}else{
		setTimeout('dis_but()',100);
	}
}
function diagClassModification(mode,dagger_independent_yn){
			var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
			var modify_temp_code = parent.frames[2].document.getElementById('modify_temp_code').value;
			var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
			var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
			var gender = parent.frames[2].document.forms[0].gender.value;
			var age = parent.frames[2].document.forms[0].age.value;
			var dob = parent.frames[2].document.forms[0].dob.value;
			var spec_code = parent.frames[2].document.forms[0].spec_code.value;
			var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
			var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
			var caused_death = parent.frames[2].document.forms[0].caused_death.value;
			var hd_term_code = parent.frames[2].document.forms[0].hd_term_code.value;

			var allow_recode_diag_yn=parent.frames[3].document.getElementById('allow_recode_diag_yn').value;
			var allow_recode_proc_yn=parent.frames[3].document.getElementById('allow_recode_proc_yn').value;
			if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
				/*parent.RecodeScreen.rows="35%,25%,5%,*";*/
				parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="10vh";
				parent.document.getElementById("DiagProcTrans").style.height="22vh";
			}else if(allow_recode_proc_yn=="Y"){
/*				parent.RecodeScreen.rows="5%,40%,5%,*";*/
				parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="15vh";
				parent.document.getElementById("DiagProcTrans").style.height="0vh";
			}else if(allow_recode_diag_yn=="Y"){
/*				parent.RecodeScreen.rows="40%,5%,5%,*";*/
				parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="15vh";
				parent.document.getElementById("DiagProcTrans").style.height="0vh";
			}
			var hold_arr = new Array();
			if(modify_temp_code!=''){
				temp_arr=modify_temp_code.split("~");
				for( i=0;i<temp_arr.length-1;i++){
					var in_arr=temp_arr[i].split("$");
					hold_arr[i]=in_arr[1];
				}
			}
		var prin_diag_yn="Y";
			if(parent.frames[2].document.forms[0].principal_diag.value!=''){											
			for( p=0;p<hold_arr.length;p++){											
				if(hold_arr[p]==parent.frames[2].document.forms[0].principal_diag.value){
					prin_diag_yn='N';
				}													
			}												
		}else{
			prin_diag_yn='N'
		}
			
		parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?procedure_yn=N&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&modify_temp_code="+encodeURIComponent(parent.frames[2].document.getElementById('modify_temp_code').value)+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&l1_termCode="+hd_term_code+"&mode="+mode+"&prin_diag="+prin_diag_yn+"&dagger_independent_yn="+dagger_independent_yn+"&specialty_code="+parent.frames[2].document.forms[0].specialty_code.value+"&isMultiDescAppl="+parent.frames[2].document.forms[0].isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281



}
function ModifyProcedure(mode,code_extn_dtl,contr_mod_id,laterality_ind,pat_visit_dt_time,pat_disch_dt_time){
//			var stage_no = parent.frames[3].document.forms[0].Stage_no.value;
			var dflt_termset = parent.frames[3].document.forms[0].dflt_termset.value;
			var Pat_id = parent.frames[3].document.forms[0].Pat_id.value;
			var EncounterId = parent.frames[3].document.forms[0].EncounterId.value;
			var Patient_Class = parent.frames[3].document.forms[0].Patient_Class.value;
			var allow_recode_diag_yn=parent.frames[3].document.getElementById('allow_recode_diag_yn').value;
			var allow_recode_proc_yn=parent.frames[3].document.getElementById('allow_recode_proc_yn').value;
			if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
				/*parent.RecodeScreen.rows="35%,25%,5%,*";*/
				parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
				parent.document.getElementById("DiagProcTrans").style.height="0vh";
			}else if(allow_recode_proc_yn=="Y"){
				/*parent.RecodeScreen.rows="5%,40%,5%,*";*/
				parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
				parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
				parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
				parent.document.getElementById("DiagProcTrans").style.height="0vh";
			}
				/* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				parent.frames[5].location.href="../../eMR/jsp/DPRecodingAddModify.jsp?procedure_yn=Y&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&modify_proc_code="+encodeURIComponent(parent.frames[3].document.getElementById('modify_temp_proc').value)+"&dflt_termset="+parent.frames[3].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&mode="+mode+"&code_extn_dtl="+code_extn_dtl+"&contr_mod_id="+contr_mod_id+"&laterality_ind="+laterality_ind+"&pat_visit_dt_time="+pat_visit_dt_time+"&pat_disch_dt_time="+pat_disch_dt_time+"&specialty_code="+parent.frames[2].document.forms[0].specialty_code.value; 

}
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}
function getExtension(obj){
	if (obj.value=="OT"){
		document.getElementById('show_extn_dtl').style.visibility="visible";
	}else{
		document.getElementById('show_extn_dtl').style.visibility="hidden";
	}
	
}
async function show_err_history(view_from){
var EncounterId	=document.forms[0].EncounterId.value;
var p_facility_id	=document.forms[0].facility_id.value;
var diag_err_cnt	="0";
var proc_err_cnt	="0";
var diag_excodes_cnt= "0";
var proc_excodes_cnt="0";
var diag_origerr_cnt="0";
var proc_origerr_cnt="0";
if(view_from=="MRK_ERR" || view_from=="EX_CODES"){
	 diag_err_cnt			= document.forms[0].diag_err_cnt.value;
	 proc_err_cnt			= document.forms[0].proc_err_cnt.value;
	 diag_excodes_cnt	= document.forms[0].diag_excodes_cnt.value;
	 proc_excodes_cnt	= document.forms[0].proc_excodes_cnt.value;
	 diag_origerr_cnt		= document.forms[0].diag_origerr_cnt.value;
	 proc_origerr_cnt		= document.forms[0].proc_origerr_cnt.value;

}else{
	 diag_origerr_cnt	= document.forms[0].diag_origerr_cnt.value;
	 proc_origerr_cnt	= document.forms[0].proc_origerr_cnt.value;
}
	  var dialogTop="130";
	  var center='1';
			/*if (cal_from=="Diag"){
			dialogTop = "240";
		}else if("Proc"){
			dialogTop = "430";		
		}*/
	  var dialogHeight = "50vh" ;
	  var dialogWidth = "60vw" ;
	  var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	  var arguments = "" ;
	  retVal=await window.showModalDialog("../../eMR/jsp/DPRecodedHistory.jsp?encounterID="+EncounterId+"&diag_err_cnt="+diag_err_cnt+"&proc_err_cnt="+proc_err_cnt+"&diag_excodes_cnt="+diag_excodes_cnt+"&proc_excodes_cnt="+proc_excodes_cnt+"&diag_origerr_cnt="+diag_origerr_cnt+"&proc_origerr_cnt="+proc_origerr_cnt+"&view_from="+view_from,arguments,features);

}
function disableDiagProcChkbox(disp_none ){
	var diagFormObj	=parent.RecDiagnosisDiag.document.forms[0];
	var procFormObj	=parent.RecDiagnosisProc.document.forms[0];
	if(disp_none=="Y"){
		if(diagFormObj){
			for(count=0;count<diagFormObj.elements.length;count++){
			if(diagFormObj.elements[count].type=="text" || diagFormObj.elements[count].type=="button" || diagFormObj.elements[count].type=="select-one" || diagFormObj.elements[count].type=="checkbox" || diagFormObj.elements[count].type=="radio" ||diagFormObj.elements[count].type=="image"){
			diagFormObj.elements[count].disabled=true;
			}
		}
			parent.RecDiagnosisDiag.document.getElementById('show_level').disabled=false;
			if(diagFormObj.Reject_Diag){
				diagFormObj.Reject_Diag.disabled=false;
			}
			if(diagFormObj.Reject_Proc){
				diagFormObj.Reject_Proc.disabled=false;
			}
	  }
		if(procFormObj){
			for(count=0;count<procFormObj.elements.length;count++){
			if(procFormObj.elements[count].type=="text" || procFormObj.elements[count].type=="button" || procFormObj.elements[count].type=="select-one" || procFormObj.elements[count].type=="checkbox" || procFormObj.elements[count].type=="radio" ||procFormObj.elements[count].type=="image"){
			procFormObj.elements[count].disabled=true;
			}
		}
	  }
	}
}
/*Function delevoped for SRR-CRF-303.1 On 12/11/2009*/
function showProcdatestimes(obj){
		document.getElementById('proc_dt_times').style.visibility="visible";
		document.getElementById('proc_dt_times').style.display	="inline";
		document.forms[0].start_dt_time.value	=	"";
		document.forms[0].end_dt_time.value		=	"";

	if (obj.value=="OT"){
		document.getElementById('id_start_dt_time').innerHTML=getLabel("eMR.checkindatetime.label","MR"); 	
		document.getElementById('start_mand').style.visibility="visible";
		document.getElementById('id_end_dt_time').innerHTML=getLabel("eMR.checkoutdatetime.label","MR"); 	
		document.getElementById('end_mand').style.visibility="visible";

	}else if(obj.value=="NO"){
		document.getElementById('id_start_dt_time').innerHTML=getLabel("Common.startdatetime.label","Common"); 	
		document.getElementById('start_mand').style.visibility="hidden";
		document.getElementById('id_end_dt_time').innerHTML=getLabel("Common.enddatetime.label","Common"); 	
		document.getElementById('end_mand').style.visibility="hidden";
	}else{
		document.getElementById('proc_dt_times').style.visibility="hidden";
		document.getElementById('proc_dt_times').style.display="none";

	}
}
function procDateValidation(obj){
//	alert(document.forms[0].pat_visit_dt_time.value);
//alert(range)
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	if(obj.value!=""){
			var locale					=document.forms[0].locale.value;
			var proc_type			=document.forms[0].proc_type.value;
			var start_dt_time		=document.forms[0].start_dt_time;
			var end_dt_time		=document.forms[0].end_dt_time;
			var start_dt_tm_lbl	="";
			var end_dt_tm_lbl	="";
			if(proc_type=="OT"){
				start_dt_tm_lbl	 = getLabel("eMR.checkindatetime.label","MR");
				end_dt_tm_lbl	 = getLabel("eMR.checkoutdatetime.label","MR");
			}else{
				start_dt_tm_lbl	 = getLabel("Common.startdatetime.label","Common"); 
				end_dt_tm_lbl	 = getLabel("Common.enddatetime.label","Common");
			}
			var objVal	=convertDate(obj.value,"DMYHM",locale,"en");//Converting Date.

			var invalid_status=validDateObj(obj,"DMYHM", locale)
			if(invalid_status){
				var date_check=DateChkWithLabel(start_dt_time,end_dt_time,"DMYHM",start_dt_tm_lbl,end_dt_tm_lbl);
				/*if(date_check){
						htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='mode' id='mode' value='VALIDATE_DT_TM'></input><input type='hidden' name='EncounterId' id='EncounterId' value='"+parent.frames[5].document.forms[0].EncounterId.value+"'></input><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[5].document.forms[0].Pat_id.value+"'></input><input type='hidden' name='proc_chk_dates' id='proc_chk_dates' value='"+objVal+"'></input><input type='hidden' name='field_names' id='field_names' value='"+obj.name+"'></input></form></body></html>";
						parent.submitFrame.document.write(htmlval);
						parent.submitFrame.document.MRvalidate.submit();
				}*/
			}else{
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				}
		}else{
					if(obj.name=="start_dt_time"){
						document.forms[0].proc_srt_dt_hid.value="Y";
					}
					if(obj.name=="end_dt_time"){
						document.forms[0].proc_end_dt_hid.value="Y";
					}

		}
}
function populateLateralityVal(laterality_val){
	if(laterality_val=="L"){
		document.forms[0].proc_laterality.options[1].selected=true;
	}else if(laterality_val=="R"){
		document.forms[0].proc_laterality.options[2].selected=true;
	}else if(laterality_val=="B"){
		document.forms[0].proc_laterality.options[3].selected=true;
	}else if(laterality_val=="N"){
		document.forms[0].proc_laterality.options[4].selected=true;
	}else{
		document.forms[0].proc_laterality.options[0].selected=true;
	}
}
function DateChkWithLabel(from,to,format,start_dt_tm_lbl,end_dt_tm_lbl){
	var locale		= parent.frames[5].document.forms[0].locale.value;
	if (from.value != undefined){
		from = from.value;
	}else{
		from=from;
	}
	if (to.value != undefined){
		to = to.value;
	}else{
		to=to;
	}
	if ( to=='' || from=='' ){
		return true;
	}
	 if(!parent.frames[5].isBefore(from,to,format,locale)){
		var error=getMessage("DATES_MUST_GR_EQUAL","MR") ;
		error=error.replace("$",start_dt_tm_lbl);
		error=error.replace("#",end_dt_tm_lbl);
//			alert(error)
			document.forms[0].start_dt_time.select();
			document.forms[0].start_dt_time.focus();
			parent.frames[6].location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}
function resetProcdatetimes(){
	document.forms[0].reset();
	var mode	=	document.forms[0].mode.value;
	var proc_type_hid_yn	=	document.forms[0].proc_type_hid_yn.value;
	var procedure_yn	=	document.forms[0].procedure_yn.value;
	var laterality_val	=	document.forms[0].laterality_ind.value;
	var new_code		=	document.forms[0].newCode_yn.value;
	var diagprob_code = document.forms[0].diagprob_code.value; // added by mujafar for ML-MMOH-CRF-1281
 	if(procedure_yn=="Y"){
			if(mode !="ProcModify"){
				if(proc_type_hid_yn=="Y" ){
					document.getElementById('proc_dt_times').style.visibility="hidden";
					document.getElementById('proc_dt_times').style.display	="none";
					document.forms[0].start_dt_time.value	=	"";
					document.forms[0].end_dt_time.value		=	"";
				}
				if(new_code!="Y"){
					if(document.forms[0].proc_laterality.type!="hidden"){
					if(laterality_val=="L"){
						document.forms[0].proc_laterality.options[1].selected=true;
					}else if(laterality_val=="R"){
						document.forms[0].proc_laterality.options[2].selected=true;
					}else if(laterality_val=="B"){
						document.forms[0].proc_laterality.options[3].selected=true;
					}else if(laterality_val=="N"){
						document.forms[0].proc_laterality.options[4].selected=true;
					}else{
						document.forms[0].proc_laterality.options[0].selected=true;
					}
				}
			}
			}else{
				if(document.forms[0].proc_laterality.type!="hidden"){
					if(laterality_val=="L"){
						document.forms[0].proc_laterality.options[1].selected=true;
					}else if(laterality_val=="R"){
						document.forms[0].proc_laterality.options[2].selected=true;
					}else if(laterality_val=="B"){
						document.forms[0].proc_laterality.options[3].selected=true;
					}else if(laterality_val=="N"){
						document.forms[0].proc_laterality.options[4].selected=true;
					}else{
						document.forms[0].proc_laterality.options[0].selected=true;
					}
				}
			}
	}else{
		if(document.forms[0].spprt_diag_btn_0){
			 document.forms[0].spprt_diag_btn_0.disabled=true
		}
		if(document.forms[0].spprt_diag_btn_1){
			document.forms[0].spprt_diag_btn_1.disabled=true
		}
		if(document.forms[0].spprt_diag_btn_2){
			document.forms[0].spprt_diag_btn_2.disabled=true
		}
		
		
		if(document.forms[0].isMultiDescAppl.value=="true" && document.getElementById('other_disp1') && mode == "")
						{ // Added by mujafar for ML-MMOH-CRF-1281 US3
						if(diagprob_code == "")
						document.getElementById('other_disp1').style.visibility = "hidden";
						document.getElementById('other_disp2').style.visibility = "hidden";
						}
		
		
		
	}
if(mode !="ProcModify" && mode!="Modify"){
		if(document.forms[0].diagprob_code){
			document.forms[0].long_desc_val_0.value="";
			document.getElementById('long_desc_0').style.display="none";
		}
		if(document.forms[0].diagprob_code1){
			document.forms[0].long_desc_val_1.value="";
			document.getElementById('long_desc_1').style.display="none";
		}
		if(document.forms[0].diagprob_code2){
			document.forms[0].long_desc_val_2.value="";
			document.getElementById('long_desc_2').style.display="none";
		}
}

}

function ValidateProcDates(entered_date,vist_date,discharge_date){
	entered_date	= parent.frames[5].convertDate(entered_date,"DMYHM",localeName,"en");//Converting Date.
	var a=  entered_date.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
//	var hrs =eval(splittime1[0]);
	mon = splitdate1[1]; 
	 //var from_date  =new Date(splitdate1[2], mon, splitdate1[0]-1, hrs,splittime1[1])
	 var entered_date  =new Date(splitdate1[2], splitdate1[1]-1,splitdate1[0], splittime1[0], splittime1[1]);


	 a=  vist_date.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 mon = splitdate1[1];
	 //var to_date  =new Date(splitdate1[2], mon,days, splittime1[0]-1, splittime1[1])
	 var visit_date  =new Date(splitdate1[2], splitdate1[1]-1,splitdate1[0], splittime1[0], splittime1[1]);


	a=  discharge_date.split(" ")
	splitdate=a[0];
	splittime=a[1]
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	mon = splitdate1[1]; 
	 //var from_date  =new Date(splitdate1[2], mon, splitdate1[0]-1, hrs,splittime1[1])
	var dischared_date  =new Date(splitdate1[2], splitdate1[1]-1,splitdate1[0], splittime1[0], splittime1[1])
//		alert("entered_date==>" +entered_date+"visit_date==>" +visit_date+"dischared_date==>"+dischared_date)
		 if(Date.parse(entered_date)>=Date.parse(visit_date)){
			if(Date.parse(entered_date)<=Date.parse(dischared_date)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}



		/* alert(isBefore(from_date,to_date,"DMYHM",localeName))
		 if(isBefore(to_date,from_date,"DMYHM",localeName)){
			return true;
		 }else{
			 return false;
		 }*/
}

function getErrorMessage(stage_no,patient_id,encounter_id,dflt_termset,Patient_Class,L1_hdr_status,L2_hdr_status,L3_hdr_status,curr_level,hdr_modified_dt){
	var err_msg=getMessage('ENC_ALREADY_MODIFIED','MR');
	alert(err_msg)
	if(stage_no==1){
			parent.frames[2].location.href="../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
			parent.frames[3].location.href="../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
	}else if(stage_no==2){
			parent.frames[2].location.href="../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
			parent.frames[3].location.href="../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
	}else if(stage_no==3){
			parent.frames[2].location.href="../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
			parent.frames[3].location.href="../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level;
	}
		onSuccess();
	parent.frames[4].location.href="../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt+"&execute_hdr_qry=N";
	parent.frames[6].location.href ="../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg+"&err_value=0";

}
function checkStartEnddates(){
			var proc_type		= parent.frames[5].document.forms[0].proc_type;//Added On 12/14/2009 for SRR-CRF-303.1	
			var start_dt_time	= parent.frames[5].document.forms[0].start_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
			var end_dt_time	= parent.frames[5].document.forms[0].end_dt_time;//Added On 12/14/2009 for SRR-CRF-303.1	
			htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='mode' id='mode' value='VALIDATE_DT_TM_ON_RECORD'></input><input type='hidden' name='EncounterId' id='EncounterId' value='"+parent.frames[5].document.forms[0].EncounterId.value+"'></input><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[5].document.forms[0].Pat_id.value+"'></input><input type='hidden' name='proc_srt_dt' id='proc_srt_dt' value='"+start_dt_time.value+"'></input><input type='hidden' name='proc_end_dt' id='proc_end_dt' value='"+end_dt_time.value+"'></input></form></body></html>";
			parent.submitFrame.document.write(htmlval);
			parent.submitFrame.document.MRvalidate.submit();
}
function setValue(from,Obj){
	if (from=="LINKED_DIAG"){
		if(Obj.checked==true){
				Obj.value	="Y";
		}else{
				Obj.value	="N";
		}
	}else if(from=="UNLINKED_DIAG"){
		if(Obj.checked==true){
				Obj.value	="Y";
		}else{
				Obj.value	="N";
		}
	}
}
function recodeSupportDiagnosis(calling_status,associate_codes,term_set,term_code,encounter_id,patient_id,occur_srl_no,stage_no_disp,support_seq_no,Group_seq_no,group_YN,trx_no,supprt_diag_view){
	var hdr_modified_dt	 =	parent.frames[4].document.forms[0].hdr_modified_dt.value;

	if(Group_seq_no==0){
		Group_seq_no="";
	}
	  var dialogTop		=	"204";
	  var center			=	'2';
	  var dialogHeight = "30vh" ;
	  var dialogWidth = "50vw" ;
	  var features		= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	  var arguments		= "" ;
	  retVal=window.showModalDialog("../../eMR/jsp/DPRecodingSupportDiagFrames.jsp?calling_status="+calling_status+"&associate_codes="+associate_codes+"&term_set="+term_set+"&term_code="+term_code+"&EncounterId="+encounter_id+"&patient_id="+patient_id+"&occur_srl_no="+occur_srl_no+"&stage_no_disp="+stage_no_disp+"&support_seq_no="+support_seq_no+"&trx_no="+trx_no+"&Group_seq_no="+Group_seq_no+"&group_YN="+group_YN+"&activity=RECODE&supprt_diag_view="+supprt_diag_view+"&hdr_modified_dt="+hdr_modified_dt,arguments,features);
	  if(retVal=="00"){
		var Patient_Class = parent.RecDiagnosisDiag.document.forms[0].Patient_Class.value
		parent.RecDiagnosisButton.location.href="../../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+stage_no_disp+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&execute_hdr_qry=Y";
	  }
}
async function recordSupportDiagnosis(cnt,encounter_id,patient_id){
	var diagAddmodify_formObj	=	parent.frames[5].document.forms[0];
	var diagAddmodify_formObj_str	=	"parent.frames[5].document.DiagProcAddModify";
	var term_code	= "";
	var term_set	 	= "";
	var code_indicator = "";
	var associate_codes = "";
	if (cnt==0){
		term_code		= eval(""+diagAddmodify_formObj_str+".diagprob_code").value;
		code_indicator	= eval(""+diagAddmodify_formObj_str+".code_indicator_0").value;
	}else if(cnt==1){
		term_code		= eval(""+diagAddmodify_formObj_str+".diagprob_code1").value;
		code_indicator	= eval(""+diagAddmodify_formObj_str+".code_indicator_1").value;
	}else if(cnt==2){
		term_code		= eval(""+diagAddmodify_formObj_str+".diagprob_code2").value;
		code_indicator	= eval(""+diagAddmodify_formObj_str+".code_indicator_2").value;
	}
	term_set	=	diagAddmodify_formObj.code_set.value;
	if(code_indicator=="D"){
		associate_codes="A";
	}else if(code_indicator=="C"){
		associate_codes="EC";
	}
	var record_assosicate_codes_0 = diagAddmodify_formObj.record_assosicate_codes_0.value;
	var record_assosicate_codes_1 = diagAddmodify_formObj.record_assosicate_codes_1.value;
	var record_assosicate_codes_2 = diagAddmodify_formObj.record_assosicate_codes_2.value;
	  var dialogTop		=	"250";
	  var center			=	'1';
	  var dialogHeight = "26vh" ;
	  var dialogWidth = "50vw" ;
	  var features		= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	  var arguments		= "" ;
	  retVal=await window.showModalDialog("../../eMR/jsp/DPRecodingSupportDiagFrames.jsp?term_set="+term_set+"&term_code="+term_code+"&EncounterId="+encounter_id+"&patient_id="+patient_id+"&activity=RECORD&associate_codes="+associate_codes+"&diagprob_code_val="+cnt+"&record_assosicate_codes_0="+encodeURIComponent(record_assosicate_codes_0)+"&record_assosicate_codes_1="+encodeURIComponent(record_assosicate_codes_1)+"&record_assosicate_codes_2="+encodeURIComponent(record_assosicate_codes_2),arguments,features);
	if(retVal!=undefined){
		var return_val	= retVal.split("@*");
		 if(return_val[0]==0){
			 diagAddmodify_formObj.record_assosicate_codes_0.value=return_val[1];
		 }else  if(return_val[0]==1){
			 diagAddmodify_formObj.record_assosicate_codes_1.value=return_val[1];
		 }else  if(return_val[0]==2){
			 diagAddmodify_formObj.record_assosicate_codes_2.value=return_val[1];
		 }
	}

}

function saverecodedSupportDiags(){
	var linked_diag_Formobj			= parent.Linked_Support_Diag_Frame.document.linked_supprt_diag_form;
	var unlinked_diag_Formobj		= parent.Unlinked_Support_Diag_Frame.document.unlinked_supprt_diag_form;
	var spprt_diag_btn_Formobj	= parent.Support_Diag_BTN_Frame.document.supprt_diag_btn_form;
	var linked_diag_Formobj_str	 = "parent.Linked_Support_Diag_Frame.document.linked_supprt_diag_form";
	var unlinked_diag_Formobj_str	 = "parent.Unlinked_Support_Diag_Frame.document.unlinked_supprt_diag_form";
	var linked_diag_cnt					 =	linked_diag_Formobj.total_records.value;
	var unlinked_diag_cnt				 =	unlinked_diag_Formobj.total_records.value;
	var chk_linked_diag	= "";
	var hid_linked_diag	= "";
	var modified_diag_code 	= "";
	var diag_code_val		 	= "";
	var diag_buffer				 	= "";
	var delete_linked_diag		= "";
	var insert_unlinked_diag	= "";
	for (var i=0;i<linked_diag_cnt ;i++ ){
			chk_linked_diag	=	eval(""+linked_diag_Formobj_str+".chk_linked_diag_"+i+"").value;
			hid_linked_diag	 	=	eval(""+linked_diag_Formobj_str+".hid_linked_diag_"+i+"").value;
			diag_buffer			=	hid_linked_diag.split("$#");
			diag_code_val		=	diag_buffer[0];
			modified_diag_code	=	diag_buffer[1];
//			alert("modified_diag_code===>" +modified_diag_code)
			if(chk_linked_diag!=diag_code_val){
					delete_linked_diag	=	delete_linked_diag+"'"+modified_diag_code+"',";
			}			
		}
		delete_linked_diag	= delete_linked_diag.substring(0,delete_linked_diag.length-1);
		spprt_diag_btn_Formobj.delete_linked_diag.value=delete_linked_diag;
	for (var i=0;i<unlinked_diag_cnt ;i++ ){
			chk_linked_diag	=	eval(""+unlinked_diag_Formobj_str+".chk_unlinked_diag_"+i+"").value;
			hid_linked_diag	 	=	eval(""+unlinked_diag_Formobj_str+".hid_unlinked_diag_"+i+"").value;
			diag_buffer			=	hid_linked_diag.split("$#");
			diag_code_val		=	diag_buffer[0];
			modified_diag_code	=	diag_buffer[1];
			if(chk_linked_diag!=diag_code_val){
					insert_unlinked_diag	=	insert_unlinked_diag+modified_diag_code+"|@";
			}			
		}
		insert_unlinked_diag	= insert_unlinked_diag.substring(0,insert_unlinked_diag.length-2);
		spprt_diag_btn_Formobj.insert_unlinked_diag.value=insert_unlinked_diag;
		if(delete_linked_diag!="" || insert_unlinked_diag!=""){
				spprt_diag_btn_Formobj.action="../../servlet/eMR.DPRecodingSupprtDiagServlet";
				spprt_diag_btn_Formobj.target="targetFrame";
				spprt_diag_btn_Formobj.submit();
//			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
//			unlinked_diag_Formobj.submit();
		}else{
			var no_save_msg	=getMessage('NO_CHANGE_TO_SAVE','Common');
			alert(no_save_msg)
//			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+no_save_msg+"&err_value=0";

		}

}
function saverecordedSupportDiags(){
	var record_diag_Formobj			 = parent.Record_Support_Diag_Frame.document.record_supprt_diag_form;
	var spprt_diag_btn_Formobj	 = parent.Support_Diag_BTN_Frame.document.supprt_diag_btn_form;
	var record_diag_Formobj_str	 = "parent.Record_Support_Diag_Frame.document.record_supprt_diag_form";
	var record_diag_cnt					 =	record_diag_Formobj.total_records.value;
	var diagprob_code_val				 =	record_diag_Formobj.diagprob_code_val.value;
	var chk_linked_diag			= "";
	var hid_linked_diag			= "";
	var modified_diag_code 	= "";
	var diag_code_val		 	= "";
	var diag_buffer				 	= "";
	var record_assosicate_codes	= "";
	for (var i=0;i<record_diag_cnt ;i++ ){
			chk_linked_diag	=	eval(""+record_diag_Formobj_str+".chk_unlinked_diag_"+i+"").value;
			hid_linked_diag	 	=	eval(""+record_diag_Formobj_str+".hid_unlinked_diag_"+i+"").value;
			diag_buffer			=	hid_linked_diag.split("$#");
			diag_code_val		=	diag_buffer[0];
			modified_diag_code	=	diag_buffer[1];
			if(chk_linked_diag!=diag_code_val){
					record_assosicate_codes	=	record_assosicate_codes+modified_diag_code+"|@";
			}			
		}
		record_assosicate_codes	= record_assosicate_codes.substring(0,record_assosicate_codes.length-2);
		
//Added by Ajay Hatwate for RBU-GHL-CRF-0044.1
		if(record_diag_Formobj.is_search_option.value == "true"){	
			var record_assosicate_codes_0 = "";
			if(diagprob_code_val == "0"){
				record_assosicate_codes_0 = record_diag_Formobj.record_assosicate_codes_0.value;
			}else if(diagprob_code_val == "1"){
				record_assosicate_codes_0 = record_diag_Formobj.record_assosicate_codes_1.value;			
			}else if(diagprob_code_val == "2"){
				record_assosicate_codes_0 = record_diag_Formobj.record_assosicate_codes_2.value;
			}

			record_assosicate_codes = record_assosicate_codes + "|@"+record_assosicate_codes_0;
		}
		window.returnValue=diagprob_code_val+"@*"+record_assosicate_codes
		window.close();
}
function restirctPrimaryDiag(Obj){
	var proceed=true
//	var dagger_independent_yn	=parent.RecDiagnosisAddModify.document.forms[0].dagger_independent_yn.value;
	var dagger_independent_yn="N";
	var dagger_independent_yn_0	=parent.frames[5].document.forms[0].dagger_independent_yn_0.value;
	var dagger_independent_yn_1	=parent.frames[5].document.forms[0].dagger_independent_yn_1.value;
	var dagger_independent_yn_2	=parent.frames[5].document.forms[0].dagger_independent_yn_2.value;
	if(dagger_independent_yn_0=="Y"||dagger_independent_yn_1=="Y"||dagger_independent_yn_2=="Y"){
			dagger_independent_yn	= "Y";
	}
	var primary_diag			=Obj.value;
	var selectedDiagclass	=Obj.selectedIndex;
	if(selectedDiagclass!=0){
		var diag_class_type_hid	=parent.frames[5].document.getElementById("diag_class_type_"+selectedDiagclass+" ");
		if(diag_class_type_hid){
			diag_class_type_hid = diag_class_type_hid.value
			if (dagger_independent_yn=="Y" && diag_class_type_hid=="PD"){
					var err_msg=getMessage('PRIM_DIAG_NOT_APPLICABLE','MR');;
					alert(err_msg)
					Obj.options[0].selected=true;
					proceed=false;
			}
		}
	}
	return proceed;
}
function getSupperrormsg(){
	var err_msg=getMessage('ENC_ALREADY_MODIFIED','MR');
	alert(err_msg)
	parent.window.close();
}

function displayMenu(patient_id,encounter_id,practitioner_type){
	displayToolTip(patient_id,encounter_id,practitioner_type)
}
function displayToolTip(patient_id,encounter_id,practitioner_type){  
		buildTable(patient_id,encounter_id,practitioner_type) 
		bodwidth  = parent.parent.frames[2].document.body.offsetWidth
		bodheight = parent.parent.frames[2].document.body.offsetHeight
		var x 	  = event.x;
		var y 	  = event.y;
		
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth)
		y 	  = y + (document.getElementById('tooltiplayer').offsetHeight)

		if(x<bodwidth)
			x = event.x 
		else
			x = x - (document.getElementById('tooltiplayer').offsetWidth)
		if(y<bodheight)
			y = event.y
		else
			y = y - (document.getElementById('tooltiplayer').offsetHeight)
				
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
			
		document.getElementById("tooltiplayer").style.Left= x-10+"px";
		document.getElementById("tooltiplayer").style.Top = y+90+"px";
		document.getElementById("tooltiplayer").style.visibility='visible' 
		var element = document.getElementById("viewClinicalHistory");
		element.removeEventListener('mouseover', hideTooltip);

}

function buildTable(){ 

	//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
	var dischargeSummary = parent.frames[2].document.forms[0].dischargeSummary.value;
	var accession_num	 = parent.frames[2].document.forms[0].accession_num.value;

		var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center' style='position: absolute; width: 12%; visibility: visible; left: 580px; top: -85px; z-index: 1000'>"
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('VCH')>"+getLabel("eMR.ViewClinicalHistory.label","eMR")+"</a></td>";	
		tab_dat     += "</tr>";
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('PBL')>"+getLabel("Common.ProblemList.label","Common")+"</a></td>";	
		tab_dat     += "</tr>";
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('PCL')>"+getLabel("Common.Procedure.label","Common")+" "+getLabel("Common.List.label","Common")+"</a></td>";	
		tab_dat     += "</tr>";
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('DP')>"+getLabel("Common.DrugProfile.label","Common")+"</a></td>";	
		tab_dat     += "</tr>";
		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('VA')>View Alerts</a></td>";	
		tab_dat     += "</tr>";
		
		/*Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272*/
		if(dischargeSummary == "true" && accession_num != "")
		{
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('DS')>"+getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.Summary.label","Common")+"</a></td>";	
			tab_dat     += "</tr>";
		}
		/*End ML-MMOH-CRF-1272*/

		//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_clinic_his('VCN')>View Clinical Notes</a></td>";
		//tab_dat     += "</tr>";
		tab_dat     += "</table>";
		document.getElementById('t').innerHTML = tab_dat;

}
function hideTooltip(){
	if (document.getElementById("tooltiptable1"))
		document.getElementById("tooltiptable1").style.visibility = 'hidden';
	
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
	var element = document.getElementById("viewClinicalHistory");
	element.addEventListener('mouseover', hideTooltip);
}
function callOnMouseOut(obj)
{
	obj.className = currClass; 
}
function DummyRef(){
}
async function showLongDescription(long_desc_params,obj){
	if(long_desc_params==""||long_desc_params==null){
		if(parent.frames[5].document.forms[0]){
			if(obj==0){
				long_desc_params=parent.frames[5].document.forms[0].long_desc_val_0.value;
			}else if(obj==1){
				long_desc_params=parent.frames[5].document.forms[0].long_desc_val_1.value;
			}else if(obj==2){
				long_desc_params=parent.frames[5].document.forms[0].long_desc_val_2.value;
			}
		}
	}
		var long_desc_vals=long_desc_params.split(",");
		var term_code = long_desc_vals[0];
		var term_set = long_desc_vals[1];
//		alert("term_set==>" +term_set+"term_code==>" +term_code)

	var dialogHeight= "50vh" ;
	var dialogWidth = "31vw" ;
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?term_set_id="+term_set+"&term_code="+term_code,arguments,features);
}

function checkQuote() {
	if(document.getElementById('remarks')!=null){
		var val	= document.getElementById('remarks').value;
		if(val!=""){
			val =	val.replace(/["']/g, "")
			document.getElementById('remarks').value = val;
		}
	}
	
}

/* In Below lines methods added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
async function selectProblem(){

    var retVal ;
	var newArray ;
	var newArrayCode	= new Array();
	var newArrayDesc	= new Array();
	var callFunction	= "";
	var patient_id		    = document.forms[0].Pat_id.value;  
	var Encounter_Id		= document.forms[0].EncounterId.value;  
	var specialty_code		= document.forms[0].specialty_code.value;  
	var code_set 			= document.forms[0].code_set.value;
	var diagprob_desc		= document.forms[0].diagprob_desc.value; 
    var diagprob_code	    = document.forms[0].hid_diagprob_code_0.value; 
	var mode			    = document.forms[0].mode.value;
	var onset_date		    = document.forms[0].onset_date.value;
	var occur_srl_no        =document.forms[0].occur_srl_no.value;

	if(mode == "Modify")
		callFunction	= "modifyProblem";
		else
		   callFunction	= "selectProblem";
	
	var dialogHeight	= "80vh";
	var dialogWidth		= "40vw";
	var title			= getLabel("eMR.Select.label","MR")+" "+(getLabel("Common.Problem.label","Common"));
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	 
	retVal=await window.showModalDialog("../../eMR/jsp/selectProblemFrames.jsp?callFunction="+callFunction+"&title="+title+"&patient_id="+patient_id+"&encounter_id="+Encounter_Id+"&speciality_code="+specialty_code+"&term_set_id="+code_set+"&term_code="+diagprob_code+"&mode="+mode+"&occur_srl_no="+occur_srl_no+"&onset_date="+encodeURIComponent(onset_date)+"&short_desc="+encodeURIComponent(diagprob_desc)+" "	,arguments,features);
	
	if(retVal != null && retVal != undefined )
	{
		newArray	 = retVal.split("^");
		document.forms[0].complaint_desc.value = "" ;
		document.forms[0].complaint_id.value	 = "" ;
		for(var i = 0 ; i <= newArray.length-1 ; i++) 
		{
			newArrayCode = newArray[i].split("$");
			

			if(newArray[i] != undefined && newArray[i] != null && newArray[i] != "" )
			{
				document.forms[0].complaint_desc.value += newArrayCode[1]+";"; 
				document.forms[0].complaint_id.value	 += newArrayCode[0]+"$"; 
			}
		}
		
	}

}

function EnableNotifySetup()
		{
		var notify_code=document.forms[0].notification_setup.value; 
		var notify_code1 = notify_code.split("&"); 
		var notifiable_code=notify_code1[0];
		var email_yn=notify_code1[1];
		var deft_note_type=notify_code1[2];//Added senthil 	
        var diagprob_code=document.forms[0].diagprob_code.value;  
        var diagprob_desc=document.forms[0].diagprob_desc.value;	
		
		 
		
		if(document.forms[0].notification_setup.value!='')  {  
			document.forms[0].notifiable_code.value=notifiable_code; 
			document.forms[0].email_yn.value=email_yn;
			document.forms[0].default_note_type.value=deft_note_type; }
		else {  

			document.forms[0].notifiable_code.value=notifiable_code;
			document.forms[0].email_yn.value=email_yn;
			document.forms[0].default_note_type.value=deft_note_type; } 

		
		}
		
		/*end HSA-CRF-300*/

/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
function checkMaxLimitOfDoctorsDesc(obj)
{
	if ( obj.value.length > 100 )
	{
		var invaldtFrom = getMessage("REMARKS_XCEED_2000_CHARS","MR") ;
		invaldtFrom = invaldtFrom.replace('Remarks',getLabel("eMR.DoctorDesc.label","MR"));
		invaldtFrom = invaldtFrom.replace('2000','100');
		alert(invaldtFrom);
		obj.select();
		return false;
	}
	else
		return true;
}
/*End ML-MMOH-CRF-1269*/

/*Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272*/
function myOpenWindow(accession_num,arguments,features,windObj)
{
	var theWin;

	if(windObj != null)
	{
		if(!windObj.closed)
		{
			windObj.focus();
			return windObj;
		}
	}

	theWin = window.open("../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num="+accession_num, arguments, features);
	return theWin;
}

function destroyPopUps()
{
	if(gmyWin)
	{
		gmyWin.close();
	}
}
/*End ML-MMOH-CRF-1272*/
function longDescToolTip(term_code, long_desc) {
	var tab_data2 = "<div> " + term_code + " / " + long_desc + "</div>";
	return tab_data2;    
}

//Added by Ajay Hatwate for ML-MMOH-CRF-1941
var radioval = 'D';
function storeVal(currad){
	radioval = currad.value
}

function submitSearchOption(calling_status,associate_codes,term_set,term_code,encounter_id,patient_id,occur_srl_no,stage_no_disp,support_seq_no,Group_seq_no,group_YN,trx_no,diagprob_code_val,record_assosicate_codes_0,record_assosicate_codes_1,record_assosicate_codes_2,supprt_diag_view){
	
	var search_crit = document.forms[0].search_criteria.value;
	var search_text = document.forms[0].search_text.value;
	
	parent.frames[1].location.href="../../eMR/jsp/DPRecordSupportDiagnosis.jsp?search_by="+radioval+"&search_criteria="+search_crit+"&search_text="+search_text+"&calling_status="+calling_status+"&associate_codes="+associate_codes+"&term_set="+term_set+"&term_code="+term_code+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&occur_srl_no="+occur_srl_no+"&stage_no_disp="+stage_no_disp+"&support_seq_no="+support_seq_no+"&Group_seq_no="+Group_seq_no+"&group_YN="+group_YN+"&trx_no="+trx_no+"&diagprob_code_val="+diagprob_code_val+"&record_assosicate_codes_0="+record_assosicate_codes_0+"&record_assosicate_codes_1="+record_assosicate_codes_1+"&record_assosicate_codes_2="+record_assosicate_codes_2+"&supprt_diag_view="+supprt_diag_view;
	
}

function CheckForSpecChars_event(event){
	if(event.keyCode!='13'){
		var strCheck = '"';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return true;  
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return false ;
	}else{
		return false;
	}
}
function resetPage(){
	document.forms[0].search_by[0].checked=true;
	document.forms[0].search_criteria.options[1].selected=true;
	document.forms[0].search_text.value="";
	var calling_status=document.forms[1].calling_status.value;
	var associate_codes=document.forms[1].associate_codes.value;
	var term_set=document.forms[1].term_set.value;
	var term_code=document.forms[1].term_code.value;
	var encounter_id=document.forms[1].encounter_id.value;
	var patient_id=document.forms[1].patient_id.value;
	var occur_srl_no=document.forms[1].occur_srl_no.value;
	var stage_no_disp=document.forms[1].stage_no_disp.value;
	var support_seq_no=document.forms[1].support_seq_no.value;
	var trx_no=document.forms[1].trx_no.value;
	var diagprob_code_val=document.forms[1].diagprob_code_val.value;
	var record_assosicate_codes_0=document.forms[1].record_assosicate_codes_0.value;
	var record_assosicate_codes_1=document.forms[1].record_assosicate_codes_1.value;
	var record_assosicate_codes_2=document.forms[1].record_assosicate_codes_2.value;
	submitSearchOption(calling_status,associate_codes,term_set,term_code,encounter_id,patient_id,occur_srl_no,stage_no_disp,support_seq_no,'','',trx_no,diagprob_code_val,record_assosicate_codes_0,record_assosicate_codes_1,record_assosicate_codes_2,'');
}

