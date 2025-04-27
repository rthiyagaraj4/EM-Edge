// <<billing_remarks#01>>Start
async function showBillingRemarks()
{

	var patId = document.forms[0].patId.value;
	var module_id = document.forms[0].module_id.value;
	var calling_function_id = document.forms[0].calling_function_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var visit_id = document.forms[0].visit_id.value;
	var arguments = "";
	var param = "patient_id="+patId+"&module_id="+module_id+"&calling_function_id="+calling_function_id+
	"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id;
	var dialogHeight= "30vh" ;
	var dialogWidth	= "40vw" ;
	//var dialogTop	= "66" ;	
	var status = "no";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	await window.showModalDialog( "../../eBL/jsp/BLPatientRemarks.jsp?"+param,arguments,features);

}
//<<billing_remarks#01>>End
var currentTabQuery = new String();
var previousTabQuery = new String();
previousTabQuery = "visit_tab";
currentTabQuery = "visit_tab";

async function tab_clickQuery(objName)
{  
	if(prevTabObj == null)
		prevTabObj = "visit_tab";
	
	selectTab(objName);
	//changeTabQuery(objName);

	if (objName == 'visit_tab' || objName == 'visit_tab1')
	  moveToTab(1);
	else if (objName == 'additional_tab' || objName == 'additional_tab1')
	{         
		 moveToTab(2);
	}	
	else if ((objName == 'financial_tab' || objName == 'financial_tab1') && (document.forms[0].bl_install_yn.value =="Y"))
	{
	oa_install_yn=parent.frames[3].document.getElementById('oa_install_yn').value
	
		
		var service_code=document.forms[0].service_code.value;
		var referral_id="";
		if(parent.frames[3].document.getElementById('referral_code')!=null)
		{
		 referral_id=parent.frames[3].document.getElementById('referral_code').value;
		}

		if(service_code!="" && referral_id=="" )
		{			
			callQueryVisitRegistration(visit_registration.oa_install_yn.value);
			//setTimeout("await chkOnSub()",1000);
			await chkOnSub();
		}
		else
		{
			await chkOnSub();		
		}
	}
}

function moveToTab(TabIndex) {	
	var bookmarkToMove;
    if ( TabIndex == 1 )  {        
		document.getElementById('visit_tab').scrollIntoView({
			  behavior: "smooth",
			  block: "nearest",
			  inline: "start"
			});		
	} else if ( TabIndex == 2 ) {
            document.getElementById('financial_tab').scrollIntoView({
            	  behavior: "smooth",
            	  block: "nearest",
            	  inline: "start"
            	});
	}  
}

async function chkOnSub(calledFrom)
{
	if(calledFrom == 'onApply')
		frame_ref = self.frames[1].frames[3];
	else
		frame_ref = parent.frames[3];
		
	var referral_id="";
	var financial_detail_ref_id = frame_ref.document.forms[0].financial_detail_ref_id.value;
	var financial_detail_org_type = frame_ref.document.forms[0].org_type.value;
	var visit_type_derv_rule = frame_ref.document.forms[0].visit_type_derv_rule.value;//Added for the CRF - MMS-QH-CRF 41.1
	var referral_req_yn="N";
	if(frame_ref.document.forms[0].Referal_Required) {
		if(frame_ref.document.forms[0].Referal_Required.checked)
		{
			referral_req_yn="Y";	
		}
		else {
			referral_req_yn="N";	
		}	
	}
	
	if(frame_ref.document.getElementById('referral_code')!=null)
	{
		referral_id=frame_ref.document.getElementById('referral_code').value;
	 
	}
	if(frame_ref.document.getElementById('referral_code')!=null )
	{ 
		if(frame_ref.document.getElementById('referral_code').value!=""){
			 
			referral_req_yn="Y";			
		}
	}
	var package_flag="";
	if (frame_ref.document.forms[0].pkg_sel.value == "Y")
		package_flag="Y";
	else
		package_flag="N";
            
	var ins_auth_flag="N";
	var upd_pat_flag = "Y";
	var pkg_bill_type = frame_ref.document.getElementById('pkg_bill_type').value;
	var pkg_bill_no = frame_ref.document.getElementById('pkg_bill_no').value;
	var billing_group       = frame_ref.document.forms[0].billing_group;
/*
	var billing_class       = parent.frames[3].document.forms[0].billing_class;
	var employer_code       = parent.frames[3].document.forms[0].employer_code;
	var cash_set_type1      = parent.frames[3].document.forms[0].cash_set_type1;
	var cash_insmt_ref1     = parent.frames[3].document.forms[0].cash_insmt_ref1;
	var cash_insmt_date1    = parent.frames[3].document.forms[0].cash_insmt_date1;
	var cash_insmt_rmks1    = parent.frames[3].document.forms[0].cash_insmt_rmks1;
	var cust_1              = parent.frames[3].document.forms[0].cust_1;
	var credit_doc_ref1     = parent.frames[3].document.forms[0].credit_doc_ref1;
	var credit_doc_date1    = parent.frames[3].document.forms[0].credit_doc_date1;
	var cust_2              = parent.frames[3].document.forms[0].cust_2;
	var credit_doc_ref2     = parent.frames[3].document.forms[0].credit_doc_ref2;
	var credit_doc_date2    = parent.frames[3].document.forms[0].credit_doc_date2;
	var cust_3              = parent.frames[3].document.forms[0].cust_3;
	var policy_type         = parent.frames[3].document.forms[0].policy_type;
	var policy_no           = parent.frames[3].document.forms[0].policy_no;
	var policy_expiry_date  = parent.frames[3].document.forms[0].policy_expiry_date;
	var non_insur_blng_grp  = parent.frames[3].document.forms[0].non_insur_blng_grp;
	var cash_set_type2      = parent.frames[3].document.forms[0].cash_set_type2;
	var cash_insmt_ref2     = parent.frames[3].document.forms[0].cash_insmt_ref2;
	var cash_insmt_date2    = parent.frames[3].document.forms[0].cash_insmt_date2;
	var cash_insmt_rmks2    = parent.frames[3].document.forms[0].cash_insmt_rmks2;
	var cust_4              = parent.frames[3].document.forms[0].cust_4;
	var credit_doc_ref3     = parent.frames[3].document.forms[0].credit_doc_ref3;
	var credit_doc_date3    = parent.frames[3].document.forms[0].credit_doc_date3;
	var setlmt_ind          = parent.frames[3].document.forms[0].setlmt_ind;
	var upd_fin_dtls        = parent.frames[3].document.forms[0].upd_fin_dtls;
*/
	var billing_mode        = frame_ref.document.forms[0].billing_mode;
/*
	var credit_auth_ref     = parent.frames[3].document.forms[0].credit_auth_ref;
	var credit_auth_date    = parent.frames[3].document.forms[0].credit_auth_date;
	var app_days            = parent.frames[3].document.forms[0].app_days;
	var app_amount          = parent.frames[3].document.forms[0].app_amount;		
*/
	
	var health_card_expired_yn1  = frame_ref.document.forms[0].health_card_expired_yn1.value;
	var health_card_expired_yn  = frame_ref.document.forms[0].health_card_expired_yn;
/*
	var annual_income			= parent.frames[3].document.forms[0].annual_income;
	var family_asset			= parent.frames[3].document.forms[0].family_asset;
	var no_of_dependants		= parent.frames[3].document.forms[0].no_of_dependants;
	var resp_for_payment		= parent.frames[3].document.forms[0].resp_for_payment;
	var credit_doc_reqd_yn1		= parent.frames[3].document.forms[0].credit_doc_reqd_yn1;
	var credit_doc_reqd_yn2		= parent.frames[3].document.forms[0].credit_doc_reqd_yn2;
*/
	var calling_module_id	= "OP";
	var calling_function_id = frame_ref.document.forms[0].functionId.value;
/*
	var gl_holder_name=parent.frames[3].document.forms[0].gl_holder_name;
	var gl_holder_reln=parent.frames[3].document.forms[0].gl_holder_reln;
	var eff_frm_date        = parent.frames[3].document.forms[0].eff_frm_date;
	var remarks             = parent.frames[3].document.forms[0].remarks;
	var user_id             = parent.frames[3].document.forms[0].user_id;
*/
	var patient_id  = frame_ref.document.forms[0].bl_patient_id; 	


/*
	if(parent.frames[3].document.forms[0].cred_start_date!=null)
	{
		document.forms[0].cred_start_dt1.value    = parent.frames[3].document.forms[0].cred_start_date.value;
	   document.forms[0].cred_start_dt2.value  = parent.frames[3].document.forms[0].cred_start_date.value;
	  document.forms[0].cred_start_dt3.value      = parent.frames[3].document.forms[0].cred_start_date.value;
	}
*/
	var episode = "";
		
	var show_hide_blng_class = "HIDE";
	/*if (parent.frames[3].document.forms[0].new_op_episode_yn.checked ==true)
		episode="Y";
	else
		episode="N";*/
		
	var record = "";
	var cnt = frame_ref.document.forms[0].reccnt.value;

	if (cnt == 0)
		record = "N";
	else
		record  = "Y";
            
	if(billing_group.value!="" && record == "Y")
		billing_mode.value="Modify";
	
	var operation="";
	if (record == "Y" && billing_group.value!="")
		operation="Update";
	
	var clinic_code = frame_ref.document.forms[0].assign_care_locn_code;
	var visit_type_code = frame_ref.document.forms[0].visit_adm_type;            			
	var bl_interface_yn = frame_ref.document.forms[0].bl_interface_yn.value;    
	var bl_install_yn	= frame_ref.document.forms[0].bl_install_yn.value;    
	var facilityId		= frame_ref.document.forms[0].facilityId.value;    
	var p_order_catalog = frame_ref.document.forms[0].order_cat_code.value;
	var vst_regn_date_time = frame_ref.document.forms[0].vst_regn_date_time.value;
	var vst_date_time=convertDate(vst_regn_date_time,"DMYHMS",localeName,"en");	
	vst_regn_date_time = convertDate(vst_regn_date_time,"DMYHM",localeName,"en");		
	patient_class ="OP";
	
	var attend_practitioner_id=frame_ref.document.forms[0].attend_practitioner_id.value;
	frame_ref.document.getElementById('dummy_locn_code').value=clinic_code.value;
	frame_ref.document.getElementById('dummy_visit_type').value=visit_type_code.value; 
	frame_ref.document.getElementById('dummy_visit_dttime').value=frame_ref.document.forms[0].vst_regn_date_time.value;
/* 			
	var qryStr="operation="+operation+"&package_flag="+package_flag+"&ins_auth_flag="+ins_auth_flag+"&upd_pat_flag="+upd_pat_flag+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value+"&billing_class="+billing_class.value+"&employer_code="+employer_code.value+"&cash_set_type1="+cash_set_type1.value+"&cash_insmt_ref1="+cash_insmt_ref1.value+"&cash_insmt_date1="+cash_insmt_date1.value;
	qryStr += "&cash_insmt_rmks1="+cash_insmt_rmks1.value+"&cust_1="+cust_1.value+"&credit_doc_ref1="+credit_doc_ref1.value+"&credit_doc_date1="+credit_doc_date1.value+"&cust_2="+cust_2.value;
	qryStr += "&credit_doc_ref2="+credit_doc_ref2.value+"&credit_doc_date2="+credit_doc_date2.value+"&cust_3="+cust_3.value+"&policy_type="+escape(policy_type.value);
	qryStr += "&policy_no="+policy_no.value+"&policy_expiry_date="+policy_expiry_date.value+"&non_insur_blng_grp="+non_insur_blng_grp.value+"&cash_set_type2="+cash_set_type2.value;
	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
	qryStr += "&cash_insmt_ref2="+cash_insmt_ref2.value+"&cash_insmt_date2="+cash_insmt_date2.value+"&cash_insmt_rmks2="+cash_insmt_rmks2.value+"&cust_4="+cust_4.value+"&credit_doc_ref3="+credit_doc_ref3.value+"&credit_doc_date3="+credit_doc_date3.value+"&setlmt_ind="+setlmt_ind.value+"&credit_auth_ref="+credit_auth_ref.value+"&credit_auth_date="+credit_auth_date.value+"&app_days="+app_days.value+"&app_amount="+app_amount.value+"&health_card_expired_yn="+health_card_expired_yn1+"&annual_income="+annual_income.value+"&family_asset="+family_asset.value+"&no_of_dependants="+no_of_dependants.value+"&resp_for_payment="+resp_for_payment.value+"&credit_doc_reqd_yn1="+credit_doc_reqd_yn1.value+"&credit_doc_reqd_yn2="+credit_doc_reqd_yn2.value+"&eff_frm_date="+eff_frm_date.value+"&remarks="+remarks.value+"&clinic_code="+clinic_code.value+"&visit_type_code="+visit_type_code.value+"&user_id="+user_id.value;
	qryStr += "&episode="+episode+"&record="+record+"&patient_id="+patient_id.value+"&show_hide_blng_class="+show_hide_blng_class+"&Chg_to_Visitor_Grp="+document.forms[0].Chg_to_Visitor_Grp.value;
	qryStr += "&bl_interfaced_yn="+bl_interface_yn+ 
			"&bl_install_yn="+bl_install_yn+"&facilityId="+facilityId+"&patient_class="+patient_class;
*/

	//Added by prithivi on 11/12/2016 for MMS-QH-CRF-0085
    var service_code = frame_ref.document.forms[0].service_code.value;
	var isPractoApptYn = frame_ref.document.forms[0].isPractoApptYn.value;

	var qryStr="billing_group="+billing_group.value+"&operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no+"&billing_mode="+billing_mode.value+"&vst_regn_date_time="+vst_date_time+"&service_code="+service_code+"&isPractoApptYn="+isPractoApptYn; //modified for 41.1

	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
	qryStr += "&health_card_expired_yn="+health_card_expired_yn1+"&clinic_code="+clinic_code.value+"&visit_type_code="+visit_type_code.value;
	qryStr += "&episode="+episode+"&record="+record+"&patient_id="+patient_id.value+"&show_hide_blng_class="+show_hide_blng_class+"&Chg_to_Visitor_Grp="+frame_ref.document.forms[0].Chg_to_Visitor_Grp.value;
	qryStr += "&bl_interfaced_yn="+bl_interface_yn+ 
			"&bl_install_yn="+bl_install_yn+"&facilityId="+facilityId+"&patient_class="+patient_class;
	qryStr += "&referral_req_yn="+referral_req_yn;

	if(referral_id=="")
	{
		qryStr +="&financial_detail_ref_id="+financial_detail_ref_id;
		qryStr +="&org_type_ind="+financial_detail_org_type;
	}
	else
	{
		qryStr +="&financial_detail_ref_id="+referral_id;
		qryStr +="&org_type_ind="+financial_detail_org_type;
	}


/*
	qryStr+="&credit_doc_start_date1="+document.forms[0].cred_start_dt1.value;
	qryStr+="&credit_doc_start_date2="+document.forms[0].cred_start_dt2.value;
	qryStr+="&credit_doc_start_date3="+document.forms[0].cred_start_dt3.value;
	qryStr+="&gl_holder_name="+gl_holder_name.value;		qryStr+="&pat_reln_with_gl_holder="+gl_holder_reln.value;
*/
	
	qryStr+="&p_order_catalog="+p_order_catalog.value+"&practitioner_id="+attend_practitioner_id
    if(attend_practitioner_id!="")
	qryStr+="&practitioner_type_ind=P";
	qryStr+="&billingFlag="+frame_ref.document.forms[0].bl_success.value;
	qryStr+="&encounter_date_time="+vst_regn_date_time;
	qryStr+="&care_locn_type_ind="+frame_ref.document.forms[0].locn_type.value;// Added by Dharma for ML-BRU-SCF-0911 [IN:041316] on Feb 18th 2014
	/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/
	qryStr+="&patientId="+frame_ref.document.forms[0].patient_id.value;
	if(frame_ref.document.forms[0].selOrdCtlgCodes!=null){
	    qryStr+="&orderCatalogCode="+frame_ref.document.forms[0].selOrdCtlgCodes.value;
	}
  /*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] End*/
   
	frame_ref.document.forms[0].bl_success.value = "N";
	var returnArray = new Array(); 
	
	if(visit_type_code.value != "")
	{
    	returnArray = await getFinDtl(qryStr);
    	
	    /*Below line commented above line added for this SCF  MMS-SCF-0157 [IN:044906]*/
		/*if(visit_type_derv_rule != 'B'){	 //added condition for MMS-QH-CRF-41.1
			returnArray = getFinDtl(qryStr);	
		}
		else{
			if( calledFrom != 'onApply'){	 //added condition for MMS-QH-CRF-41.1
			returnArray = getFinDtl(qryStr);
			
			}
		}*/ //End MMS-SCF-0157 [IN:044906]
    	
		if(calledFrom != 'onApply')
		{
			if ((previousTabQuery=="visit_tab") || (previousTabQuery=="visit_tab1"))
				tab_clickQuery("visit_tab");
			else if ((previousTabQuery=="additional_tab") || (previousTabQuery=="additional_tab1"))
				tab_clickQuery("additional_tab");
		}
		
		if(returnArray.length>0)
		{
			billing_group.value				= returnArray[0];
			/*billing_class.value				= returnArray[1];
			employer_code.value         = returnArray[2];    
			cash_set_type1.value        = returnArray[3];
			cash_insmt_ref1.value		= returnArray[4];
			cash_insmt_date1.value		= returnArray[5];
			cash_insmt_rmks1.value   = returnArray[6];
			cust_1.value						= returnArray[7];
			credit_doc_ref1.value			= returnArray[8];
			credit_doc_date1.value      = returnArray[9];
			cust_2.value						= returnArray[10];
			credit_doc_ref2.value			= returnArray[11];
			credit_doc_date2.value		= returnArray[12];
			cust_3.value						= returnArray[13];
			policy_type.value				= returnArray[14];
			policy_no.value					= returnArray[15];
			policy_expiry_date.value   = returnArray[16];
			non_insur_blng_grp.value = returnArray[17];
			cash_set_type2.value        = returnArray[18];
			cash_insmt_ref2.value		= returnArray[19];
			cash_insmt_date2.value		= returnArray[20];
			cash_insmt_rmks2.value   = returnArray[21];
			cust_4.value						= returnArray[22];
			credit_doc_ref3.value			= returnArray[23];
			credit_doc_date3.value      = returnArray[24];
			setlmt_ind.value					= returnArray[25];
			upd_fin_dtls.value				= returnArray[26];
			credit_auth_ref.value			= returnArray[27];
			credit_auth_date.value		= returnArray[28];
			app_days.value					= returnArray[29];
			app_amount.value				= returnArray[30];			
			annual_income.value         = returnArray[31];
			family_asset.value          = returnArray[32];
			no_of_dependants.value      = returnArray[33];
			resp_for_payment.value      = returnArray[34];
			credit_doc_reqd_yn1.value   = returnArray[35];
			credit_doc_reqd_yn2.value   = returnArray[36];			
			eff_frm_date.value          = returnArray[37];
			remarks.value               = returnArray[38];
			user_id.value               = returnArray[39]; 			
			document.forms[0].cred_start_dt1.value = returnArray[40];
			document.forms[0].cred_start_dt2.value = returnArray[41];
			document.forms[0].cred_start_dt3.value = returnArray[42];
			gl_holder_name.value = returnArray[43];			
			gl_holder_reln.value = returnArray[44];	
		*/	
			frame_ref.document.forms[0].bl_success.value = "Y";
			billing_mode.value          = "Modify" ;
			calOrdCtlgAmt(calledFrom);//Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461]


			//NEW CODE added here to validate the visit type based on the return value from billing for MMS-QH-CRF 41.1
			
			if(visit_type_derv_rule == 'B' && bl_install_yn == 'Y'){
				var vst_typ_ind = returnArray[1];
				var episode_id = returnArray[2];
				var blng_grp_id= returnArray[3];
				var cust_code = returnArray[4];
				var cust_grp_code = returnArray[5];
				var policy_type_code = returnArray[6];
	
				/*returnArray[1]="F";
				returnArray[2]="";
				returnArray[3]="INSU";
				returnArray[4]="01-00001";
				returnArray[5]="01";
				returnArray[6]="UNIV_COVERAGE_10";*/
				
				if(vst_typ_ind == 'undefined' || vst_typ_ind=='null' || vst_typ_ind == null)
					vst_typ_ind='';
				var old_vst_typ_ind = frame_ref.document.forms[0].vst_type_ind.value;	
				if(old_vst_typ_ind != vst_typ_ind){//The following steps should happen only when the earlier visit type indicator is different from the indicator returned
						//var msg = getMessage('FIN_CHNGD_SEL_VST_TYPE','OP');
						//alert(msg);				
					
					if(episode_id == 'undefined' || episode_id=='null' || episode_id==null)
						episode_id='';
					if(blng_grp_id == 'undefined' || blng_grp_id=='null' || blng_grp_id==null)
						blng_grp_id='';
					if(cust_code == 'undefined' || cust_code=='null' || cust_code==null)
						cust_code='';
					if(cust_grp_code == 'undefined' || cust_grp_code=='null' || cust_grp_code==null)
						cust_grp_code='';
					if(policy_type_code == 'undefined' || policy_type_code=='null' || policy_type_code==null)
						policy_type_code='';
		
					var billing_frame="";
					if(calledFrom != 'onApply'){
						billing_frame=parent.frames[3];
						message_sub_frame=parent.parent.messageFrame;
					}else{
						billing_frame=frames[1].frames[3];
						message_sub_frame=frames[2];
					}
					if(calledFrom != 'onApply'){
						populateVisitTypeForBillingInsurance(vst_typ_ind,episode_id,blng_grp_id,cust_code,cust_grp_code,policy_type_code,billing_frame,message_sub_frame);
					}else{
						var proceed=populateVisitTypeForInsurance(vst_typ_ind,episode_id,blng_grp_id,cust_code,cust_grp_code,policy_type_code,billing_frame,message_sub_frame);
						if(!proceed)	{			
							frame_ref.document.forms[0].proceed_visit_regn.value='N';
						}
					}
				
				}
			}
		}
		else
		{
			return false;  
		}			
	}
	else
	{	
		
		var erval = getMessage('CAN_NOT_BE_BLANK','COMMON');
		erval = erval.replace('$',getLabel('Common.visittype.label','Common'));
		alert(erval);
		if(frame_ref.document.forms[0].visit_adm_type.disabled == false)
		{
		frame_ref.document.forms[0].visit_adm_type.focus();
		}
		return false; 				
	}

	/*var ln = billing_group.value;
	var blinterface = parent.frames[0].document.forms[0].bl_interface_yn.value;
	if (ln.length>0)
		if (blinterface=='Y')
			if (parent.frames[0].document.forms[0].compute)
				parent.frames[0].document.forms[0].compute.disabled=false;*/
		
}

async function getFinDtl(qryStr)
{
	var retVal;
	var dialogTop = "0px";
	var dialogHeight = "90vh";
	var dialogWidth = "90vw";

	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal =await top.window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	
	return retVal;          
}

async function showPackage()
{           
	var retVal;
	var dialogHeight= "30vh" ;
	var dialogWidth = "50vw" ;
	var dialogTop = "" ;
	var center = "1" ;                                                         
	var status="no";
	var patient_id = document.getElementById('pat_id1').value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var url = "../../eBL/jsp/QueryPackageDetails.jsp?patient_id="+patient_id+"&mode=OP";
	retVal = await window.showModalDialog(url,arguments,features);                        
	if ((retVal!=null) && (retVal!="")) parent.frames[1].document.forms[0].pkg_sel.value = "Y";
	var returnArray = new Array();
	if ((retVal!=null) && (retVal!=""))
		returnArray = retVal.split(",");
	if(returnArray.length>0)
	{
		parent.frames[1].document.forms[0].pkg_bill_type.value = returnArray[0];
		parent.frames[1].document.forms[0].pkg_bill_no.value = returnArray[1];
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
			if (window.confirm(getMessage("INS_PLCY_EXPIRED_CNFRM_UPDATE","OP"))==true)  
				ret='Y'; 
			else 
				ret='N'; 
			if (ret=='Y') 
				chkOnSub(); 
			else 
			{

				if(parent.parent.frames[1].frames[0].document.forms[0].ct_patient_id != null){
				parent.parent.frames[1].frames[0].document.forms[0].ct_patient_id.value = "";
				}
				parent.parent.frames[1].frames[0].tab_clickQuery("checkin_tab");
			}
		}
		else if(Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) return true;
	}   
}

async function getPatID()
{
	

	var functionid="";
	var funcact='';
	var patFlag="";
	if(parent.parent.frames[0].document.getElementById('function_id') != null)
	{
		functionid=parent.parent.frames[0].document.getElementById('function_id').value;
	}
	

	if (document.forms[0].register_pat_yn.value=="Y")
	{	   
		if(functionid == "VISIT_REGISTRATION")
		{
			pat_id=await PatientSearch('','','','','','','','Y','Y','Visitreg');
			
			if(pat_id != null)
			{
			patFlag=pat_id.charAt(0);
						
			if(patFlag == 'Y')
			{
				document.getElementById('patFlag').value=patFlag;
				var patientID=pat_id.substring(1,pat_id.length);
				pat_id=patientID;
			}else
			{
				patFlag = 'N';
			}
			}
		
		}
		else if(functionid == "PROCD_REGISTRATION")
		{
			pat_id=await PatientSearch('','','','','','','','Y','Y','ProcdReg');
			
			if(pat_id != null)
			{
			patFlag=pat_id.charAt(0);
						
			if(patFlag == 'Y')
			{
				document.getElementById('patFlag').value=patFlag;
				var patientID=pat_id.substring(1,pat_id.length);
				pat_id=patientID;
			}else
			{
				patFlag = 'N';
			}
			}

		}
	}
   else
	{
	   pat_id=PatientSearch();
		   
		   if(pat_id != null)
		   {
			patFlag=pat_id.charAt(0);
						
			if(patFlag == 'Y')
			{
				document.getElementById('patFlag').value=patFlag;
				var patientID=pat_id.substring(1,pat_id.length);
				pat_id=patientID;
			}else
			{
				patFlag = 'N';
			}
		   }
	}	
	if( pat_id != null )
	{
		document.getElementById('pat_id1').value = pat_id 		
		if(document.getElementById('pat_id2') != null)
			document.getElementById('pat_id2').value = pat_id             
	}
	if(visit_registration.oa_install_yn.value != "N")
	{	
		parent.parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?"+parent.parent.frames[0].document.getElementById('func_source').value;
	}
	document.getElementById('srch_code').click()    
}
function checkLength(Obj,SizeVal)  
{
	if ( Obj.value.length > SizeVal )
	{
		var err = getMessage('DESC_LENGTH_200','OP');
		alert(err);
		Obj.focus();
	}
}
function clearData()
{ 
	
if(parent.frames[1].document.forms[0].other_alt_type!=null)	
parent.frames[1].document.forms[0].other_alt_type.disabled=false;
if(parent.frames[1].document.forms[0].other_alt_type!=null)	
parent.frames[1].document.forms[0].other_alt_type.value="";
if(parent.frames[1].document.forms[0].alt_id1_no!=null)
parent.frames[1].document.forms[0].alt_id1_no.readOnly=false;
if(parent.frames[1].document.forms[0].alt_id1_no!=null)
parent.frames[1].document.forms[0].alt_id1_no.value="";
if(parent.frames[1].document.forms[0].alt_id2_no!=null)
parent.frames[1].document.forms[0].alt_id2_no.readOnly=false;
if(parent.frames[1].document.forms[0].alt_id2_no!=null)
parent.frames[1].document.forms[0].alt_id2_no.value="";
if(parent.frames[1].document.forms[0].alt_id3_no!=null)
parent.frames[1].document.forms[0].alt_id3_no.readOnly=false;
if(parent.frames[1].document.forms[0].alt_id3_no!=null)
parent.frames[1].document.forms[0].alt_id3_no.value="";
if(parent.frames[1].document.forms[0].alt_id4_no!=null)
parent.frames[1].document.forms[0].alt_id4_no.readOnly=false;
if(parent.frames[1].document.forms[0].alt_id4_no!=null)
parent.frames[1].document.forms[0].alt_id4_no.value="";
// added by munisekhar for MMS-QH-CRF-0162
var isSiteSpe_change_pat_dtls=parent.frames[1].document.forms[0].isSiteSpe_change_pat_dtls.value;
var userFunRightsCount	= parseInt(parent.frames[1].document.forms[0].userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
if(isSiteSpe_change_pat_dtls=="true" && userFunRightsCount > 0)
parent.frames[1].document.getElementById("Update_pat").style.visibility="hidden";
/*parent.frames[1].document.forms[0].pat_id1.readOnly=false;
parent.frames[1].document.forms[0].pat_id1.value="";*/
/*Above line commented and belwo line Added for this SCF MMS-SCF-0105 [IN:043502]*/
if(parent.frames[1].document.forms[0].pat_id1.disabled){
parent.frames[1].document.forms[0].pat_id1.disabled=false;
parent.frames[1].document.forms[0].pat_id1.value="";
}
//End MMS-SCF-0105 [IN:043502]

if(parent.frames[1].document.forms[0].referal_id1!=null)
parent.frames[1].document.forms[0].referal_id1.readOnly=false;
if(parent.frames[1].document.forms[0].referal_id1!=null)
parent.frames[1].document.forms[0].referal_id1.value="";
/*if(parent.frames[1].document.forms[0].nationality_desc!=null)
parent.frames[1].document.forms[0].nationality_desc.value="";
if(parent.frames[1].document.forms[0].r_town_code!=null)
parent.frames[1].document.forms[0].r_town_code.value="";
if(parent.frames[1].document.forms[0].r_area_code!=null)
parent.frames[1].document.forms[0].r_area_code.value="";
if(parent.frames[1].document.forms[0].r_region_code!=null)
parent.frames[1].document.forms[0].r_region_code.value="";
if(parent.frames[1].document.forms[0].category_desc_txt!=null)
parent.frames[1].document.forms[0].category_desc_txt.value="";
if(parent.frames[1].document.forms[0].WaitListNo!=null)
parent.frames[1].document.forms[0].WaitListNo.value="";
if(parent.frames[1].document.forms[0].speciality!=null)
parent.frames[1].document.forms[0].speciality.value="";
if(parent.frames[1].document.forms[0].priority!=null)
parent.frames[1].document.forms[0].priority.value="";
if(parent.frames[1].document.forms[0].frmDate!=null)
parent.frames[1].document.forms[0].frmDate.value="";
if(parent.frames[1].document.forms[0].ToDate!=null)
parent.frames[1].document.forms[0].ToDate.value="";*/
if(parent.frames[1].document.forms[0]!=null)
parent.frames[1].document.forms[0].reset();


if(parent.frames[1].document.forms[0].srch_code!=null)
parent.frames[1].document.forms[0].srch_code.disabled=false;
if(parent.frames[1].document.forms[0].srch!=null)
parent.frames[1].document.forms[0].srch.disabled=false;
if(parent.frames[1].document.forms[0].ref_id_search!=null)
parent.frames[1].document.forms[0].ref_id_search.disabled=false;
parent.frames[1].document.forms[0].pat_id1.focus();



	
	parent.frames[2].document.location.href='../../eCommon/html/blank.html'
	parent.frames[3].document.location.href='../../eCommon/html/blank.html'
	parent.frames[4].document.location.href='../../eCommon/html/blank.html'
	if(parent.frames[1].document.forms[0].srch_code!=null)
	parent.frames[1].document.forms[0].srch_code.disabled=false;
	/*if(parent.parent.frames[0].document.getElementById('ct_patient_id') != null)
	{
	parent.parent.frames[0].document.getElementById('ct_patient_id').value = '';
	}
	
	if(document.getElementById('referral_id')!=null)
	{
	document.getElementById('referral_id').value = '';
	}

	if(document.getElementById('attend_practitioner_id') !=null)
	{
	 document.getElementById('attend_practitioner_id').value = '';
	}
	var initparams="";

	var functionid="";

	if(parent.parent.frames[0].document.getElementById('init_params') != null)
	{

		initparams=parent.parent.frames[0].document.getElementById('init_params').value;

	}

	if(parent.parent.frames[0].document.getElementById('function_id') != null)
	{
		functionid=parent.parent.frames[0].document.getElementById('function_id').value;
	}
	
	document.location.href = "../../eOP/jsp/VisitRegistrationQuery.jsp?"+initparams+"&oa_install_yn="+parent.frames[0].document.forms[0].oa_install_yn.value+"&from_head=Y&oper_stn_id="+document.forms[0].oper_stn_id.value+"&called_from="+document.forms[0].called_from.value+"&divval=Y&function_id="+functionid;
	parent.frames[1].location.href="VisitRegistrationApptRecds.jsp?patient_id=&oper_stn_id="+document.forms[0].oper_stn_id.value;*/
}
       
async function getReferralID()
{
	var funcid=parent.frames[1].document.forms[0].functionId.value;
	
	var retVal;
	var dialogTop       = "61";
	var dialogHeight    = "1000px";
	var dialogWidth     = "1500px";    
	var arguments       = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
	var arguments   = "" ;
	
	oth_params = "&p_patient_id="+document.getElementById('pat_id1').value+"&p_referral_id="+document.getElementById('referal_id1').value
	
		
	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=OP_REG_VISIT&p_select=YES&p_reg_patient=YES&ass_func_id="+funcid+oth_params

		
	retVal = await window.showModalDialog(url,arguments,features);
	
	if(retVal==null) retVal="";
	document.getElementById('referal_id1').value= retVal
	
	if(document.getElementById('referal_id2') != null)
		document.getElementById('referal_id2').value= retVal		
	
  if(retVal!="") 
	document.getElementById('srch_code').click()
}

 


function setValue(val, obj)
{
	ChangeUpperCase(obj)
	if(val == "patient")
	{
		document.getElementById('pat_id1').value= obj.value
		
		if(document.getElementById('pat_id2') != null)
			document.getElementById('pat_id2').value= obj.value
	}
	else
	{
		document.getElementById('referal_id1').value= obj.value            
		
		if(document.getElementById('referal_id2') != null)
			document.getElementById('referal_id2').value= obj.value
	}
		
}



/*function chkDateTime(obj1, obj2) 
{
	if (ValidateDateTime(obj1, obj2))
		return false;
	else
		return true;
}*/

    


function checkPatientId()
{
	if ( document.getElementById('patient_id').value.length != document.getElementById('patient_id').size && document.getElementById('patient_id').value.length > 0)
	{
		var mes=getMessage("PAT_ID_CH","MP");
		mes=mes.replace("$",document.getElementById('patient_id').size);
		alert(mes);
	 
	  document.getElementById('patient_id').focus();
	}

	if ( document.getElementById('patient_id').value.length == document.getElementById('patient_id').size )
	{
	  var HTMLVal = new String();
	  HTMLVal = "<HTML><BODYonKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='pat_id' id='pat_id' type='hidden' value='"+document.getElementById('patient_id').value+"'></form></BODY></HTML>";

	 parent.parent.messageFrame.document.write(HTMLVal);
	  parent.parent.messageFrame.document.form1.submit();
	}
}

      
    
function gifpop(CheckinIdent,resclass)
{
	if(resclass == "P")
	{
		if(CheckinIdent=="X")
		{
			if(document.getElementById('gifpop') != null)
				document.getElementById('gifpop').style.visibility="hidden";
		}
		else
		{
			if(document.getElementById('gifpop') != null)		
				document.getElementById('gifpop').style.visibility="visible";


		}
	}
	else
	{
		if(document.getElementById('gifpop') != null)
			document.getElementById('gifpop').style.visibility="hidden";
	}
}

      



async function callConfirmBilling()
{	
	var retVal;
	var dialogHeight= "30vh" ;
	var dialogWidth	= "40vw" ;
	var dialogTop = "" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eBL/jsp/BLBillingGroupConfirm.jsp",arguments,features);
	return retVal;
}

/*function show_gen_file_window(gen_file_yn)
{
  if (gen_file_yn=="Y")
  {
	var retVal =  new String();
    var dialogHeight= "7" ;
    var dialogWidth = "15" ;
    var features  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
    var arguments = "" ;
    retVal = window.showModalDialog("../../eOP/jsp/VisitRegistrationGenFileNo.jsp?gen_file_yn="+gen_file_yn,arguments,features);
    return retVal;
  }
}*/

async function show_last_visit_details(patientid)
{
   var retVal =  new String();
   /*
   var dialogTop = "190" ;
   dialogWidth = "120" ;
   dialogHeight = "35";
   */
   var dialogTop = "190" ;
   var dialogHeight= "700px" ;
   var dialogWidth = "1000px" ;
   var status = "no";
   var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+" ; scroll=no; status:" + status;
   var arguments = "" ;
  
    retVal = await window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patientid,arguments,features);

   return retVal;
}

//Following function added for the SCF - MMS-SCF-0163
function populateVisitTypeForInsurance(vst_typ_ind,episode_id,blng_grp_id,cust_code,cust_grp_code,policy_type_code,frame_ref,message_frame){
	var old_vst_type_ind=frame_ref.document.forms[0].vst_type_ind.value;
	if(old_vst_type_ind=='' || (vst_typ_ind!='' && old_vst_type_ind!=vst_typ_ind)){
		if(frame_ref.document.forms[0].visit_adm_type){
			removeitems(frame_ref.document.forms[0].visit_adm_type);
		}
		var vst_regn_date_time = frame_ref.document.forms[0].vst_regn_date_time.value;
		var vst_date_time=convertDate(vst_regn_date_time,"DMYHMS",localeName,"en");	
	    var xmlStr ="<root><SEARCH ";
		 xmlStr +=" /></root>";
		
		 var param="called_function=BLNGINS&vst_typ_frm_blng="+vst_typ_ind+"&patient_id="+frame_ref.document.forms[0].patient_id.value+"&care_locn_code="+frame_ref.document.forms[0].assign_care_locn_code.value+"&bl_install_yn="+frame_ref.document.forms[0].bl_install_yn.value+"&service_code="+frame_ref.document.forms[0].service_code.value+"&vst_date_time="+vst_date_time+"&old_vst_type_ind="+frame_ref.document.forms[0].vst_type_ind.value+"&vst_typ_frm_blng="+vst_typ_ind+"&order_count_select="+frame_ref.document.forms[0].order_count_select.value+"&episode_id="+episode_id+"&policy_type_code="+policy_type_code+"&cust_code="+cust_code+"&cust_grp_code="+cust_grp_code+"&blng_grp_id="+blng_grp_id+"&billing_frame=frames[1].frames[3].";
		 var proceed=true;
		 var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
		 var xmlDoc = "" ;
		 var xmlHttp = new XMLHttpRequest() ;
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		 xmlHttp.open("POST",temp_jsp,false);
		 xmlHttp.send(xmlDoc);
		 responseText=trimString(xmlHttp.responseText);
		 eval(responseText)
		 return proceed;
				
		}
}


