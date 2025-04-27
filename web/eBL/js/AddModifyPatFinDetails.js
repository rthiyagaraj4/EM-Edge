function callSettlements(Obj)
{
	try{
		var obj2 = document.forms[0].ins_auth_flag;
		var obj3 = document.forms[0].clinic_code;
		var obj4 = document.forms[0].visit_type_code;
		var obj5 = document.forms[0].show_hide_blng_class;
		var obj7 = document.forms[0].items_disabled;
//		var obj8 = document.forms[0].calling_module_id; 
		var obj9 = document.forms[0].ext_settl_type;		
		var obj10 = document.forms[0].patient_id;
		var obj11 = document.forms[0].setlmt_ind;
		var obj12 = document.forms[0].adm_rec_flag;
		var obj13 = document.forms[0].credit_doc_ref_reqd_yn;
		var obj14 = document.forms[0].CitizenYn;

		var query_string=document.forms[0].query_string.value;
		//parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetails6.jsp?reset_blng_grp=YES&billing_group='+Obj.value+'&ins_auth_flag='+obj2.value+'&clinic_code='+obj3.value+'&visit_type_code='+obj4.value+'&show_hide_blng_class='+obj5.value+'&bl_data_from_repos_yn='+obj6.value+'&items_disabled='+obj7.value+'&calling_module_id='+obj8.value+'&id_fun=1&set_typ_from_frame1='+obj9.value+'&patient_id='+obj10.value+"&"+query_string;
	
		parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetails6.jsp?reset_blng_grp=YES&billing_group='+Obj.value+'&ins_auth_flag='+obj2.value+'&clinic_code='+obj3.value+'&visit_type_code='+obj4.value+'&show_hide_blng_class='+obj5.value+'&items_disabled='+obj7.value+'&id_fun=1&set_typ_from_frame1='+obj9.value+'&patient_id='+obj10.value+'&setlmt_ind='+obj11.value+'&adm_rec_flag='+obj12.value+'&credit_doc_ref_reqd_yn='+obj13.value+"&CitizenYn="+obj14.value+"&"+query_string;
}
	catch(e)
	{
	}
}

function callNonInsurance(Obj)
{
	try
	{
		var obj6 = document.forms[0].bl_data_from_repos_yn.value;
		var obj7 = document.forms[0].items_disabled.value;
		var obj8 = document.forms[0].calling_module_id.value;
		var payerGrpBySetup= document.forms[0].payerGrpBySetup.value;        
	}
	catch(e)
	{
	}	
	parent.parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetails7.jsp?non_insur_blng_grp='+Obj.value+
	 '&calling_module_id='+obj8+'&items_disabled='+obj7+'&bl_data_from_repos_yn='+ obj6+'&payerGrpBySetup='+payerGrpBySetup;
}

function callSettlements1(Obj)
{
	var str = Obj.value;
	var obj=str.substring(0,2);
	parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetails4.jsp?cash_set_type1='+obj;
}

function callNonInsurance1(Obj)
{
	var str = Obj.value;
	var obj=str.substring(0,2);
	var payerGrpBySetup= document.forms[0].payerGrpBySetup.value;
	
	parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetails8.jsp?cash_set_type2='+obj+'&payerGrpBySetup='+payerGrpBySetup;	
}

function disableObject(obj)
{
	try
	{		
		var module_id = parent.frames[0].document.forms[0].calling_module_id.value;
		if (((obj.name == "billing_group") && (module_id == "MP")) || (module_id != "MP"))
		{
			return;
		}
	}
	catch(ex)
	{
	}
	disableCommon(2,obj);	
}

function disableCommon(funCase,obj)
{
	var repos_YN = "";
	var entireValue = "";
	if (funCase == 1)
	{
		repos_YN = document.forms[0].bl_data_from_repos_yn.value;
	}
	else if (funCase == 2)
	{
		repos_YN = parent.frames[0].document.forms[0].bl_data_from_repos_yn.value;
	}
	if (repos_YN == "Y")
	{
		if (funCase == 1)
		{
			entireValue = document.forms[0].items_disabled.value;
		}
		else if (funCase == 2)
		{
			entireValue = parent.frames[0].document.forms[0].items_disabled.value;
		}
			
	var arr = new Array();
	arr = entireValue.split("|");
	indx = arr.length;
	var checkArr = new Array();
	for (i=0;i<indx;i++)
	{
	checkArr = arr[i].split("-");
	if (checkArr.length >1 )
	{
	if (checkArr[1] == "N")
	{
		try
		{	
			if (funCase == 1)
			{	
					var itemDis = checkArr[0];
					var itm = "document.forms[0]."+itemDis;
					objDisable = eval(itm);
					eval('objDisable.disabled=true');
			}
			else if (funCase == 2)
			{
				
				var itemDis2 = checkArr[0];
				var itemDis1 = obj.name;
				if (itemDis1 == itemDis2)
				{
					eval('obj.disabled=true');
				} 
			}
		}
		catch(e)
		{
				
		}
	}
	}
	}
	}
}

function disableMappingItems()
{
	var obj = new Object();
	disableCommon(1,obj);	
}
async function showBillingGrpConfirm()
{	
	var retVal;
	var dialogHeight= "9" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eBL/jsp/BLBillingGroupConfirm.jsp",arguments,features);
	return(retVal);
}

/* Karthik added the below Function to Authenticate User to check his permissions to add listed Payers - Starts */
function validateAllPayers(payerCode,payer,policy,blngClass) {
	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=MOD_FIN_DTLS_VAL_ALL";

	var xmlStr ="<root><SEARCH ";

	if(payerCode!=null){		
		xmlStr+= "payerCode=\"" + payerCode + "\" " ;	
//		temp_jsp+="&payerCode="+payerCode;
	}
	if(payer!=null){		
		xmlStr+= "payer=\"" + payer + "\" " ;	
//		temp_jsp+="&payer="+payer;
	}
	if(policy!=null){		
		xmlStr+= "policy=\"" + policy + "\" " ;	
	//	temp_jsp+="&policy="+policy;
	}
	if(blngClass!=null){		
		xmlStr+= "blngClass=\"" + blngClass + "\" " ;	
	//	temp_jsp+="&blngClass="+blngClass;
	}

	xmlStr +=" /></root>";	
	var updation=formPayerValidation(xmlStr,temp_jsp);
	return updation;
//  return  true;
}

/* Karthik added the below Function to Authenticate User to check his permissions to add listed Payers - Ends */

//Added By Rajesh V to pass the Authorised user in params
function validateAllPayersAuth(payerCode,payer,policy,blngClass,user) {
	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=MOD_FIN_DTLS_VAL_ALL_AUTH";

	var xmlStr ="<root><SEARCH ";

	if(payerCode!=null){		
		xmlStr+= "payerCode=\"" + payerCode + "\" " ;	
//		temp_jsp+="&payerCode="+payerCode;
	}
	if(payer!=null){		
		xmlStr+= "payer=\"" + payer + "\" " ;	
//		temp_jsp+="&payer="+payer;
	}
	if(policy!=null){		
		xmlStr+= "policy=\"" + policy + "\" " ;	
	//	temp_jsp+="&policy="+policy;
	}
	if(blngClass!=null){		
		xmlStr+= "blngClass=\"" + blngClass + "\" " ;	
	//	temp_jsp+="&blngClass="+blngClass;
	}

	if(user != null){
		xmlStr+= "authorizedUser=\"" + user + "\" " ;	
//		temp_jsp+="&authorizedUser="+user
	}

	xmlStr +=" /></root>";	
	var updation=formPayerValidation(xmlStr,temp_jsp);

//	var updation=formPayerValidation("<dummy><body>DummyXML</body></dummy>",temp_jsp);
	return updation;
//return true;
}

/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Starts */

function doUserAuthenticationValidationMain(successfulUser) {
	var frmObj=document.forms[0];
	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=MOD_FIN_DTLS";
	if(successfulUser!=null){		
		temp_jsp+="&successfulUser="+successfulUser;
	}
	var xmlString=formXMLStringMain(frmObj);
	var updation=formPayerValidation(xmlString,temp_jsp);	
	return updation;
}

function formPayerValidation(xmlStr,temp_jsp)
{	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	/* If the given users authentication returns true then string  @@@SUCCESS@@@  will be present in the response HTML
	else string @@@FAILED@@@  will be present */

	if(responseText.indexOf('@@@SUCCESS@@@')==-1){ //If success string is not found return false
		return false;
	}else{		
		return true;	
	}	
}

/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy - Ends */

async function authScr(obj,enc_sel_check)
{	
	var retVal=new Array();
	var dialogHeight= "30vh" ;
	var dialogWidth	= "32vw" ;
	var dialogTop = "" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	if(enc_sel_check.value=="N")
	{
		if(parent.parent.frames[1].name=="package_frame")
		{
			retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s",arguments,features);
		}
		else if(parent.frames[1].name=="MainFrame2" || parent.parent.frames[1].name=="MainFrame2")
		{
			retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode="+obj+"",arguments,features);
		}
	}
	else
	{
		var upd_fin_dtls=parent.frames[0].document.forms[0].upd_fin_dtls.value;
		var remarks=parent.frames[0].document.forms[0].remarks.value;
//		var user_id=parent.frames[0].document.forms[0].user_id.value;
		var fin_auth_user_id=parent.frames[0].document.forms[0].fin_auth_user_id.value;
	
		retVal[0]="Y";
		retVal[1]=upd_fin_dtls;
		retVal[2]=remarks;
		retVal[3]=fin_auth_user_id;
	}
	if(retVal==null) retVal="";
	if(retVal.length>0)
	{		
		if(retVal[0] == "Y")
		{			
			enableAllElements();
			if(document.forms[0].valid_pkg_for_pat_bg_avail_YN.value == "Y")
			{
				parent.frames[0].document.getElementById('vw_pkg_dtl_disp').style.display="inline";
			}
			if(parent.frames[0].document.getElementById('pkgAssociateSubs') != null)
			{
				parent.frames[0].document.getElementById('pkgAssociateSubs').style.display="inline";
			}
			if(parent.frames[0].document.getElementById('sel_frm_prev_enc_disp') != null)
			{
				parent.frames[0].document.getElementById('sel_frm_prev_enc_disp').style.display="inline";
			}
//			if(document.forms[0].third_party_gl_in_use_yn.value == "Y")
//			{
			if ( parent.frames[1].frames.length >0 )
			{
			if(parent.frames[1].frames[0].location.href.indexOf("AddModifyPatFinDetails2.jsp")!=-1)
			{
				if(parent.frames[1].frames[0].name=="Frame61")
				{
					var calling_module_id =parent.frames[0].document.forms[0].calling_module_id.value;
					var function_id = parent.frames[0].document.forms[0].function_id.value;

					if(calling_module_id!="MP" && calling_module_id!="BOOKING")
					{
						var settlement_ind = parent.frames[1].frames[0].document.forms[0].setlmt_ind.value;
						var adm_rec_flag = parent.frames[1].frames[0].document.forms[0].adm_rec_flag.value;
						var gl_doc_ref_exist_YN = parent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value;

						if(settlement_ind=='R' || (settlement_ind=='X' &&  adm_rec_flag=='1'))
						{
							if(gl_doc_ref_exist_YN == 'Y')
							{
								if(settlement_ind == 'R')
								{
									parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled = true;
									parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled = true;
								}
								else if(settlement_ind == 'X' && adm_rec_flag == "1")
								{
									parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled = true;
									parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled = true;
								}
								parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled = true;
								parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled = true;
								parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled = true;
								parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled = true;
								parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled = true;
							}
							else
							{
								if(settlement_ind == 'R')
								{
									parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled = false;
									parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled = false;
								}
								else if(settlement_ind == 'X' && adm_rec_flag == "1")
								{
									parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled = true;
									parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled = true;
								}
								parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled = false;
								parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled = false;
								parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled = false;
								parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled = false;
								parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled = false;
							}
						}
					}
					
					if(calling_module_id =="OP" || calling_module_id =="IP")
					{
						var settlement_ind = parent.frames[1].frames[0].document.forms[0].setlmt_ind.value;
						var adm_rec_flag = parent.frames[1].frames[0].document.forms[0].adm_rec_flag.value;
						var package_enabled_yn = parent.frames[1].frames[0].document.forms[0].package_enabled_yn.value;
						
						if(package_enabled_yn == 'Y')
						{
							if(settlement_ind == 'R')
							{
								if(parent.frames[1].frames[0].document.forms[0].cust_group_code_1 !== "" && parent.frames[1].frames[0].document.forms[0].cust_1 !== "")
								{
									if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
									{
										parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
									}
								}
							}
							else if(settlement_ind == 'X' && adm_rec_flag == "1")
							{
								if(parent.frames[1].frames[0].document.forms[0].cust_group_code_2 !== "" && parent.frames[1].frames[0].document.forms[0].cust_2 !== "")
								{
									if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
									{
										parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
									}
								}
							}
							else if(settlement_ind == 'C')
							{
								if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
								{
									parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
								}
							}
						}
					}
				}
			}
			}
//			}

			var bill_grp=parent.frames[0].document.forms[0].billing_group;
			var upd_fin_dtls=parent.frames[0].document.forms[0].upd_fin_dtls;
			var remarks=parent.frames[0].document.forms[0].remarks;
			var fin_auth_user_id=parent.frames[0].document.forms[0].fin_auth_user_id;
			upd_fin_dtls.value=retVal[1];
			remarks.value=retVal[2];
			fin_auth_user_id.value=retVal[3];
			try
			{
				bill_grp.focus();
			}
			catch(e)
			{
			}
			
		parent.frames[0].document.forms[0].modify_button.disabled=true;

		try
		{
			// Added on May'10'2004 for the HMC disabling even after auth.
			var bl_data_from_repos_yn = document.forms[0].bl_data_from_repos_yn.value;
			var calling_module_id = document.forms[0].calling_module_id.value;

			if (  (bl_data_from_repos_yn == 'Y')  && ( calling_module_id == 'MP') )
			{
				document.forms[0].blnggrpbut.disabled = true;
				try
				{
					parent.frames[1].frames[0].document.forms[0].cust1but.disabled=true;
				}
				catch(e)
				{

				}

			}
		}
		catch(e)
		{
		}
	}
	}	
	return retVal;
}

async function getPolicySearch()
{
	var cust=document.forms[0].cust_3.value;
	var polty_cd=document.forms[0].policy_type.value;
	var clinic_cd=document.forms[0].clinic_code.value;
	var visit_cd=document.forms[0].visit_type_code.value;
	if(polty_cd=="select")polty_cd="";

	if(cust=="")
	{
		document.forms[0].cust_3.focus();
	}
	else if(polty_cd=="")
	{
		document.forms[0].policy_type.focus();
	}
	if((cust!="")&&(polty_cd!=""))
	{
		var retVal;
		var dialogHeight= "35" ;
		var dialogWidth	= "40" ;
		var dialogTop = "180" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLPolicyDetailsMain.jsp?cust_code="+cust+"&policy_code="+escape(polty_cd)+"&clinic_code="+clinic_cd+"&visit_type_code="+visit_cd+"";
		retVal = await window.showModalDialog(url,arguments,features);
	}	
}

function checkForValidFrames4()
{
	try
	{
		var url = parent.frames[1].frames[1].location.href;
		url = url.toLowerCase();

	if ( (url.indexOf("blank.html")==-1))
		return true;
	else
		return false;
	}catch(err)
	{
	}
}

function checkForValidFrames8()
{
	var url = parent.frames[1].frames[1].frames[1].location.href;
	url = url.toLowerCase();
	
	if ( (url.indexOf("blank.html")==-1))
		return true;
	else
		return false;
}

function checkForValidFrames3()
{
	var url = parent.frames[1].frames[1].frames[0].location.href;
	url = url.toLowerCase();
	
	if ( (url.indexOf("blank.html")==-1))
		return true;
	else
		return false;
}

async function sendBackFinDetails2()
{
	
	var dialogTop	= "200";
	var dialogHeight= "60" ; 
	var dialogWidth	= "40" ;	
	var dialogLeft	= "90" ;

	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;scrolling=no;valign=center; dialogLeft: "+dialogLeft ;

	var arguments			= "" ;
	var tit				= "Patient Charging Basis on "+"";
	var bed_type = "";
	var billing_group = "";
	var bed_no = "";
	var bed_ref = "";
	var bed_type_ref = "";

	retVal=await window.showModalDialog("../../eBL/jsp/BLCheckEligibilityLevel.jsp?bed_type="+bed_type+"&billing_group="+billing_group+"&bed_no="+bed_no+"&title="+tit,arguments,features);
}

async function sendBackFinDetails()
{
	var auth='Y';
	var siteSpec			= $("#siteSpec").val(); 
	var calling_module_id 	= $("#calling_module_id").val();
	if(siteSpec=='true'){
		if((calling_module_id=="OP" || calling_module_id=="AE")){
			var finDtlMainTabs		= parent.parent.tab_frames.document;				
			var change_flag			= $(finDtlMainTabs).find("#change_flag").val(); 
			var class_type			= $(finDtlMainTabs).find("#class_type").val();				
			var patientId 			= $(finDtlMainTabs).find("#patientId").val(); 
			var prevPatId 			= $(finDtlMainTabs).find("#prevPatId").val(); 
			if(!(class_type=='EX' || class_type=='SC')){	
				if(change_flag=='Y'){					
					var called_from					= 'getSessionVal';	
					var classTypChangeAuthYnPatId;
					var classTypChangeAuthYN		= $(finDtlMainTabs).find("#classTypChangeAuthYN").val();  //parent.parent.frames[0].document.forms[0].classTypChangeAuthYN.value;
					var changePatAuthYN 			= $(finDtlMainTabs).find("#changePatAuthYN").val(); //parent.parent.frames[0].document.forms[0].changePatAuthYN.value;				
					
					if(!(patientId == prevPatId) && (prevPatId != '' )){							
						if((classTypChangeAuthYN == 'Y' && !(changePatAuthYN == 'Y'))){
						auth= await authUserOnClose();							
						}
					}
					else if(!(patientId == prevPatId) && (prevPatId == '' )){
							if(!(classTypChangeAuthYN == 'Y')){
							auth= await authUserOnClose();								
						 }
					}	
					
					if(auth=='Y'){
						classTypChangeAuthYN='Y';
						called_from='authUser';
						$.ajax({
							
							type:'POST',
							url:"../jsp/AddModPatFinClassChangeAuthAjax.jsp?classTypChangeAuthYN="+classTypChangeAuthYN+"&patientId="+patientId+"&called_from="+called_from+"&prevPatId="+prevPatId,
							async:false,
							dataType:"json",
							success : function(data){
							},
							error: function(data){
							}
						});
						
					}
				}
			}
		}
	}
	
	if(auth=='Y'){
		var rtn_patient_id="";
		var rtn_facility_id="";
		var rtn_blng_grp ="";
		var rtn_blng_class="";
		var rtn_emp_code="";
		var capture_emp_id_yn = "",str_payer_emp_id_mand_yn="";
		var rtn_fin_auth_user_id="";
	
		var rtn_slmt_type_code="";
		var rtn_inst_ref="";
		var rtn_inst_date="";
		var rtn_inst_remarks="";
		var rtn_adm_rec_flag = "";
		var rtn_credit_cust_group_code ="";
		var rtn_credit_cust_code="";
		var rtn_credit_doc_ref="";
		var rtn_credit_doc_end_date="";
		var rtn_credit_doc_start_date="";
		
		var rtn_sponsor_cust_group_code = "";
		var rtn_sponsor_cust_code="";
		var rtn_sponsor_credit_doc_ref="";
		var rtn_sponsor_credit_doc_end_date="";
		var rtn_sponsor_credit_doc_start_date="";
		
		var rtn_ins_blng_grp="";
		var rtn_ins_cust_group_code = "";
		var rtn_ins_cust_code="";
		var rtn_ins_cust_priority="";
		var rtn_ins_policy_type_code="";
		var rtn_ins_policy_no="";
		var rtn_ins_policy_start_date="";
		var rtn_ins_policy_expiry_date="";
		var rtn_ins_credit_auth_ref="";
		var rtn_ins_credit_auth_date="";
		var rtn_ins_credit_approval_days="";
		var rtn_ins_credit_approval_amount="";
		var rtn_ins_policy_eff_from_date="";
		var rtn_ins_policy_eff_to_date="";
		var rtn_ins_adj_rule_ind="";
		var rtn_ins_adj_perc_amt_ind="";
		var rtn_ins_adj_perc_amt_value="";
		var rtn_ins_pmnt_diff_adj_int="";
		var rtn_ins_drg_pmnt_diff_adj_int="";
		var rtn_ins_spl_srv_pmnt_diff_adj_int="";
		var rtn_ins_restrict_check="", rtn_ins_apprd_amt_restrict_check="", rtn_ins_apprd_days_restrict_check="";;
		var rtn_ins_policy_coverage_basis_ind="";
		var rtn_mcn_for_policy="";  //V220908
		var rtn_reg_ref_id=""; //V230315
		var rtn_userId_for_priv="";   //V230707
		var rtn_reasonCode_for_priv="";  //V230707
		var rtn_ins_ref_src_main_code="",rtn_ins_ref_src_main_desc="", rtn_ins_ref_src_sub_code="", rtn_ins_ref_src_sub_desc="";
	
		var cust_valid_from_date = "", cust_valid_to_date = "" , ins_cust_valid_from_date ="", ins_cust_valid_to_date = "",	non_ins_cust_valid_from_date ="", non_ins_cust_valid_to_date = "";
	
		var restrict_check="",apprd_amt_restrict_check="",apprd_days_restrict_check="";
		var rtn_ins_cred_auth_req_yn="", rtn_ins_dflt_auth_ref_as_pol_no_yn="", rtn_ins_cred_auth_mand_capt_yn="";
		var cred_auth_req_yn="", dflt_auth_ref_as_pol_no_yn="",cred_auth_mand_capt_yn;
	
		var rtn_non_ins_blng_grp="";
		var rtn_non_ins_ref_src_main_code="",rtn_non_ins_ref_src_main_desc="", rtn_non_ins_ref_src_sub_code="", rtn_non_ins_ref_src_sub_desc="";
		var rtn_ins_auth_flag="";
	
		var rtn_non_ins_slmt_type_code="";
		var rtn_non_ins_inst_ref="";
		var rtn_non_ins_inst_date="";
		var rtn_non_ins_inst_remarks="";
		
		var rtn_non_ins_cust_group_code = "";
		var rtn_non_ins_cust_code="";
		var rtn_non_ins_credit_doc_ref="";
		var rtn_non_ins_credit_doc_end_date="";
		var rtn_non_ins_credit_doc_start_date="";
	
		//var rtn_slmt_ind="";
		var rtn_upd_patient_fin_dtls_yn="";
		var rtn_spl_clinic_rel_enc_YN="";
		
		var rtn_user_id="";
		var HideChk="";
		var chkCashSet1="";
		var chkCashSet2="";
	
		var cap_ref_src_dtl_flag=document.forms[0].cap_ref_src_dtl_flag.value;
		var referral_source_main_mand_YN = document.forms[0].referral_source_main_mand_YN.value;
		var referral_source_sub_mand_YN = document.forms[0].referral_source_sub_mand_YN.value;
	
		var rtn_annual_income =  "";		
		var rtn_family_asset  = "";	
		var chk_credit_doc_yn1 = "";
		var chk_credit_doc_yn2 = "";	
		var chk_health_card_exp_yn = "";
		var temp_dflt_blng_grp = "";
		var temp_dflt_blng_desc = "";
		var rtn_no_of_dependants = "";			
		var rtn_resp_for_payment = "";
		var rtn_pat_reln_with_resp_person = "";
		var rtn_gl_holder_name = "";	
		var rtn_pat_reln_with_gl_holder = "";	
		var rtn_credit_doc_reqd_yn = "";
		var rtn_non_ins_credit_doc_reqd_yn = "";
		var rtn_ref_src_main_code="";
		var rtn_ref_src_main_desc="";
		var rtn_ref_src_sub_code="";
		var rtn_ref_src_sub_desc="";
	
		var rtn_tot_valid_enc_with_gl="";
		var rtn_tot_valid_op_enc_with_gl="";
		var rtn_tot_valid_ae_enc_with_gl="";
		var rtn_tot_valid_ip_enc_with_gl="";
		var rtn_tot_valid_dc_enc_with_gl="";
	
		var rtn_tot_availed_enc_with_gl="";
		var rtn_tot_availed_op_enc_with_gl="";
		var rtn_tot_availed_ae_enc_with_gl="";
		var rtn_tot_availed_ip_enc_with_gl="";
		var rtn_tot_availed_dc_enc_with_gl="";
	
		var rtn_gl_doc_ref_exist_YN = "N";
		var sys_date = "";
		var encounter_date_time = "", encounter_date_aft_trunc="";
		var rtn_pat_ser_code = "", charge_for_pat_regn_yn="N";
	
		var rtn_class_code = "";
		var rtn_remarks = "";
		var rtn_social_pensioner_id = "";
		var rtn_inc_asset_ind = "";
		var rtn_ind_inc ="";
	  	var rtn_ind_inc_freq =""	;
		var rtn_spouse_inc =""	;
		var rtn_spouse_inc_freq =""	;
		var rtn_dependent_inc =""	;
		var rtn_dependent_inc_freq ="";
		var rtn_class_type = "";
		var rtn_valid_from = "";
		var rtn_valid_to = "";
		var rtn_last_date = "";
		//Added V190801 Gayathri/GHL-CRF-0523
		var rtn_pat_bed_cat="";
		rtn_pat_bed_cat=parent.frames[0].document.forms[0].patient_bed_category.value;
		var capture_pat_bed_category="";
		capture_pat_bed_category=parent.frames[0].document.forms[0].capture_pat_bed_cat.value;
	    //Added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check
		
		var rtn_payerEligibilityParamSession="";
		var rtn_responseCode="";
		var rtn_responseCodeDesc="";
		var rtn_statuDescription="";
		var rtn_validityPeriod="";
		var rtn_validityPeriodDesc="";
		var rtn_eligibilityCode="";
		var rtn_transactionId="";
		var rtn_responseDateTime="";
		//above variables were added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check
		
		var rtn_reg_referral_flag="";  //V230616
		rtn_reg_referral_flag = parent.frames[0].document.forms[0].reg_referral_flag.value;
		
		
		var fin_class_flag_YN = parent.frames[0].document.forms[0].fin_class_flag_YN.value;
		var autoFinChk = parent.frames[0].document.forms[0].autoFinChk.value;
	
		var resp_for_pay = parent.frames[0].document.forms[0].resp_for_payment.value;
		var customer_id= parent.frames[0].document.forms[0].customer_id.value;
		
		var blng_grp		= parent.frames[0].document.forms[0].billing_group.value;
		var rtn_slmt_ind = parent.frames[0].document.forms[0].setlmt_ind.value;
		//Added V181105-Subha/KDAH-SCF-0425/Starts
		var site_specific = $('#site_specific_blg_grp_chng').val();
		var ext_blng_grp = parent.frames[0].document.forms[0].mblnggroup.value;
		var cur_blng_grp = parent.frames[0].document.forms[0].billing_group.value;
		var state_validated = parent.ValidFrame.document.forms[0].validated_state.value;
		//Added V181105-Subha/KDAH-SCF-0425/Ends
		var strOrderCtlgCode = "";//Added V190403-Aravindh/GHL-CRF-0525
		var siteSpecValidateBlngGrp = $('#siteSpecValidateBlngGrp').val();//Added V191218-Aravindh/GHL-CRF-0599
		
		/* Added V191218-Aravindh/GHL-CRF-0599/Starts */
		if(siteSpecValidateBlngGrp == true || siteSpecValidateBlngGrp == 'true') {
			var blngGrpValid = validateBillingGroup();
			if(blngGrpValid != true) {//Added V191218-Aravindh/GHL-CRF-0599/if-condition
				return false;
			}
		}
		/* Added V191218-Aravindh/GHL-CRF-0599/Ends */
		
		if(customer_id == 'GP'){
			//if(resp_for_pay=="" && rtn_slmt_ind != 'R')
			if(resp_for_pay=="" && rtn_slmt_ind == 'C')
			{
				alert(getMessage("BL9757","BL"));
				document.forms[0].resp_for_payment.focus();
				return false;
			}
		}
		
		if(autoFinChk=="Y" && calling_function_id != "BOOKING")
		{
			rtn_class_code =  parent.parent.frames[0].document.forms[0].class_code.value;
			rtn_remarks =  parent.parent.frames[0].document.forms[0].remarks.value;
			rtn_social_pensioner_id = parent.parent.frames[0].document.forms[0].social_pensioner_id.value;
			rtn_inc_asset_ind = parent.parent.frames[0].document.forms[0].inc_asset_ind.value;
			rtn_ind_inc = parent.parent.frames[0].document.forms[0].ind_inc.value;
			rtn_ind_inc_freq = parent.parent.frames[0].document.forms[0].ind_inc_freq.value;
			rtn_spouse_inc = parent.parent.frames[0].document.forms[0].spouse_inc.value;
			rtn_spouse_inc_freq = parent.parent.frames[0].document.forms[0].spouse_inc_freq.value;
			rtn_dependent_inc  = parent.parent.frames[0].document.forms[0].dependent_inc.value;
			rtn_dependent_inc_freq  = parent.parent.frames[0].document.forms[0].dependent_inc_freq.value;
			rtn_class_type = parent.parent.frames[0].document.forms[0].class_type.value;
			rtn_no_of_dependants = parent.parent.frames[0].document.forms[0].no_of_dependants.value;	
			rtn_valid_from  = parent.parent.frames[0].document.forms[0].valid_from.value;
			rtn_valid_to  = parent.parent.frames[0].document.forms[0].valid_to.value;
			rtn_last_date  = parent.parent.frames[0].document.forms[0].last_date.value;
		}
		
		var locale=document.forms[0].locale.value;
		var rtn_total_records="";
		var query_string=document.forms[0].query_string.value;
		var recordsArray=new Array();
		var emplr_name_sitespec=parent.frames[0].document.forms[0].Emplr_Blngrp_mapping.value;			//Added V190119-Gayathri-GHL-crf-0532
	
		var rtn_patient_id=parent.frames[0].document.forms[0].patient_id.value;;
		var rtn_facility_id=parent.frames[0].document.forms[0].facility_id.value;;
	
		var calling_module_id = parent.frames[0].document.forms[0].calling_module_id.value;
	
		var temp_blng_class =  parent.frames[0].document.forms[0].temp_blng_class.value;
		var temp_bill_type =  parent.frames[0].document.forms[0].temp_bill_type.value;
	
		var calling_function_id = parent.frames[0].document.forms[0].function_id.value;
		var rtn_fin_auth_user_id=parent.frames[0].document.forms[0].fin_auth_user_id.value;
	
		var boolPatientFound = parent.frames[0].document.forms[0].patient_found.value;
		
		var bed_class_code  = parent.frames[0].document.forms[0].bed_class_code.value;
		var visit_adm_type  = parent.frames[0].document.forms[0].visit_adm_type.value;
		var nursing_unit_code = parent.frames[0].document.forms[0].nursing_unit_code.value;
		var dept_code = parent.frames[0].document.forms[0].dept_code.value;
	
		var blInterface = parent.frames[0].document.forms[0].bl_interfaced_yn.value;
	
		//	blInterface="Y";
		var bl_oper_yn = parent.frames[0].document.forms[0].bl_oper_yn.value;
		//	bl_oper_yn="Y";
		
		rtn_blng_grp		= parent.frames[0].document.forms[0].billing_group.value;
		if(rtn_blng_grp==null) rtn_blng_grp="";
	
		rtn_blng_class		= parent.frames[0].document.forms[0].billing_class.value;
		if(rtn_blng_class==null) rtn_blng_class="";
		//Added V190119-Gayathri-GHL-CRF-0532
			
		capture_emp_id_yn		= parent.frames[0].document.forms[0].capture_employer_id_yn.value;
		if(capture_emp_id_yn==null) capture_emp_id_yn="N";
		
		if(emplr_name_sitespec == "Y" && capture_emp_id_yn == "Y")
		{
		rtn_emp_code		= parent.frames[0].document.forms[0].emp_id_mand_YN_dis.value;
		if(rtn_emp_code==null) rtn_emp_code="";
		}else{
			if(parent.frames[0].document.forms[0].emp_id_mand_YN_dis != undefined && parent.frames[0].document.forms[0].emp_id_mand_YN_dis != "undefined" 
			&& parent.frames[0].document.forms[0].emp_id_mand_YN_dis != null && parent.frames[0].document.forms[0].emp_id_mand_YN_dis != "null") {//Added V190808-Aravindh/GHL-SCF-1446/if-condition
				rtn_emp_code		= parent.frames[0].document.forms[0].emp_id_mand_YN_dis.value;
				if(rtn_emp_code==null) rtn_emp_code="";
			}
		}	
	
		str_payer_emp_id_mand_yn		= parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value;
		if(str_payer_emp_id_mand_yn==null) str_payer_emp_id_mand_yn="N";
	
		rtn_fin_remarks		= parent.frames[0].document.forms[0].remarks.value;
		if(rtn_fin_remarks==null) rtn_fin_remarks="";
	
		sys_date = parent.frames[0].document.forms[0].sys_date.value;
		if(sys_date == null) sys_date ="";
		
		encounter_date_time = parent.frames[0].document.forms[0].encounter_date_time.value;
		if(encounter_date_time == null) encounter_date_time ="";
		
		strOrderCtlgCode = parent.frames[0].document.forms[0].strOrderCtlgCode.value;//Added V190403-Aravindh/GHL-CRF-0525
		if(strOrderCtlgCode == null) strOrderCtlgCode ="";//Added V190403-Aravindh/GHL-CRF-0525
	
		encounter_date_aft_trunc = parent.frames[0].document.forms[0].encounter_date_aft_trunc;
	
		var upd_patient_fin_dtls_YN="";
	    upd_patient_fin_dtls_YN=parent.frames[0].document.forms[0].upd_fin_dtls.checked;
	
		if(upd_patient_fin_dtls_YN)
		{
			rtn_upd_patient_fin_dtls_yn="Y";
		}
		else
		{
			rtn_upd_patient_fin_dtls_yn="N";
		}
	
		var spl_clinic_rel_enc_YN="";
	    spl_clinic_rel_enc_YN=parent.frames[0].document.forms[0].spl_clinic_rel_enc_YN.checked;
	
		if(spl_clinic_rel_enc_YN)
		{
			rtn_spl_clinic_rel_enc_YN="Y";
		}
		else
		{
			rtn_spl_clinic_rel_enc_YN="N";
		}
	
	//	rtn_upd_patient_fin_dtls_yn= parent.frames[0].document.forms[0].upd_fin_dtls.value;
		if(rtn_upd_patient_fin_dtls_yn==null || rtn_upd_patient_fin_dtls_yn=="") rtn_upd_patient_fin_dtls_yn="N";
		if(rtn_spl_clinic_rel_enc_YN==null || rtn_spl_clinic_rel_enc_YN=="") rtn_spl_clinic_rel_enc_YN="N";	
	
		rtn_user_id= parent.frames[0].document.forms[0].user_id.value;
		if(rtn_user_id==null) rtn_user_id="";
	
		HideChk= parent.frames[0].document.forms[0].show_hide_blng_class.value;
			
		rtn_annual_income =  parent.frames[0].document.forms[0].annual_income.value;	
		if(rtn_annual_income==null) rtn_annual_income="";
	
		rtn_family_asset  = parent.frames[0].document.forms[0].family_asset.value;	
		if(rtn_family_asset==null) rtn_family_asset="";
	
		rtn_no_of_dependants = parent.frames[0].document.forms[0].no_of_dependants.value;		
		if(rtn_no_of_dependants==null) rtn_no_of_dependants="";
		
		rtn_resp_for_payment = parent.frames[0].document.forms[0].resp_for_payment.value;		
		if(rtn_resp_for_payment==null) rtn_resp_for_payment = "";
	
		rtn_ref_src_main_code= parent.frames[0].document.forms[0].referral_source_main_code.value;		
		if(rtn_ref_src_main_code==null) rtn_ref_src_main_code = "";
	
		rtn_ref_src_main_desc= parent.frames[0].document.forms[0].referral_source_main_desc.value;		
		if(rtn_ref_src_main_desc==null) rtn_ref_src_main_desc = "";
	
		rtn_ref_src_sub_code= parent.frames[0].document.forms[0].referral_source_sub_code.value;		
		if(rtn_ref_src_sub_code==null) rtn_ref_src_sub_code = "";
	
		rtn_ref_src_sub_desc= parent.frames[0].document.forms[0].referral_source_sub_desc.value;		
		if(rtn_ref_src_sub_desc==null) rtn_ref_src_sub_desc = "";
		
		charge_for_pat_regn_yn  = parent.frames[0].document.forms[0].charge_for_pat_regn_yn.value;		
		if(rtn_pat_ser_code==null) rtn_pat_ser_code = "";
	
		rtn_pat_ser_code = parent.frames[0].document.forms[0].pat_ser_code.value;		
		if(rtn_pat_ser_code==null) rtn_pat_ser_code = "";	
	
		if(capture_emp_id_yn == "Y" && str_payer_emp_id_mand_yn=="Y")
		{
			if(rtn_emp_code=="" || rtn_emp_code==null)
			{
				alert(getMessage("BL6321","BL"));
				return false;
			}
		}			
		
		if(!CheckChars_local(parent.frames[0].document.forms[0].resp_for_payment))
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
			parent.frames[0].document.forms[0].resp_for_payment.select();
			return false;
		}
	
		rtn_pat_reln_with_resp_person=parent.frames[0].document.forms[0].pat_reln_with_resp_person.value;
		if(rtn_pat_reln_with_resp_person==null) rtn_pat_reln_with_resp_person="";
		
		var v_third_party_gl_in_use_yn = parent.frames[0].document.forms[0].third_party_gl_in_use_yn.value;
		if (v_third_party_gl_in_use_yn == null) v_third_party_gl_in_use_yn = "N";
	
		var v_third_party_gl_mandatory_yn = parent.frames[0].document.forms[0].third_party_gl_mandatory_yn.value;
		if (v_third_party_gl_mandatory_yn == null) v_third_party_gl_mandatory_yn = "N";
		if (v_third_party_gl_in_use_yn == "Y")
		{	
			rtn_gl_holder_name = parent.frames[0].document.forms[0].gl_holder_name.value;
			if (rtn_gl_holder_name==null) rtn_gl_holder_name = "";
	
			if(!CheckChars_local(parent.frames[0].document.forms[0].gl_holder_name))
			{
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[0].document.forms[0].gl_holder_name.select();
				return false;
			}
		}
	
		if(rtn_resp_for_payment=="" && rtn_pat_reln_with_resp_person!="")
		{
	//		alert("Responsible for Payment cannot be empty");
			alert(getMessage("BL9757","BL"));
			return false;
		}
		   
		if (v_third_party_gl_in_use_yn == "Y")
	    {
			rtn_pat_reln_with_gl_holder = parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value;		
		}
		if (rtn_pat_reln_with_gl_holder==null) rtn_pat_reln_with_gl_holder = "";
		
		special_scheme_appl = parent.frames[0].document.forms[0].special_scheme_appl.value;		
		special_scheme_blng_grp = parent.frames[0].document.forms[0].special_scheme_blng_grp.value;	
		alt_id1_exp_date = parent.frames[0].document.forms[0].alt_id1_exp_date.value;	
		
		var bed_no = 	parent.frames[0].document.forms[0].bed_no.value;	
		try
		{
			if ( (calling_module_id == "OP" ||calling_module_id == "AE" ) && (bl_oper_yn == 'Y')  )
			{
				if (temp_blng_class == null || temp_blng_class == ""|| temp_blng_class == " " )
				{
					alert(getMessage("BL1130",'BL'));
					return(false);
				}
				if (temp_bill_type == null || temp_bill_type== ""|| temp_bill_type== " " )
				{
					alert(getMessage("BL1130",'BL'));
					return(false);
				}
			}
	
			if ( (bl_oper_yn == 'Y') &&(calling_module_id == "IP" || calling_module_id == "DC") )
			{
				if ( (bed_no != null) && (bed_no !="") && (bed_no !=" ") )
				{
					if (temp_blng_class == null || temp_blng_class == ""|| temp_blng_class == " " )
					{
						alert(getMessage("BL9206",'BL'));
						return(false);
					}
				}
				if (temp_bill_type == null || temp_bill_type== ""|| temp_bill_type== " " )
				{
					alert(getMessage("BL9202",'BL'));
					return(false);
				}
				if (dept_code == null)
				{
					alert(getMessage("BL1184",'BL'));
					return(false);
				}
				if ( (sys_message_id != null) )
				{
					if ( (sys_message_id !="" ) && (sys_message_id !='null') )
					{
						alert(getMessage(sys_message_id));
						return(false);
					}
				}
			}
		}
		catch(es)
		{
		}
		
	
		var varBillingApp = parent.frames[0].document.forms[0].blnggrpappyn.value;		
		var indx = parent.frames[0].document.forms[0].billing_group.selectedIndex;
		
		if (rtn_blng_grp != "" && varBillingApp == 'N')
		{
			alert(getMessage("BL1523",'BL'));		
			return(false);	
		}
	
		var vblnggrpstatus = "";	
		if (rtn_blng_grp != "" && vblnggrpstatus == 'S' )
		{
				alert(getMessage("BL0026",'BL'));		
				return(false);	
		}
	
		var vblnggrpcatgappyn = "";
		if (rtn_blng_grp != "" && vblnggrpcatgappyn == 'N' )
		{
				alert(getMessage("BL1524",'BL'));		
				return(false);	
		}
	
		var arr = new Array();
		arr = varBillingApp.split("|");
		indx = indx-1;
		
		if(rtn_blng_grp=="")
		{
			alert(getMessage("BL9301",'BL'));
			return false;
		}
	
		if((rtn_blng_class == "") && (calling_function_id=="VISIT_REGISTRATION"))
		{
		}
	
		if ( (special_scheme_appl != 'N') && (calling_module_id != "MP" ) )
		{
			if (rtn_blng_grp != special_scheme_blng_grp)
			{
				alert(getMessage("BL9305",'BL'));
				return(false);
			}
		}
	
	//	rtn_slmt_ind = parent.frames[0].document.forms[0].setlmt_ind.value;
	
		rtn_adm_rec_flag = parent.frames[0].document.forms[0].adm_rec_flag.value;
		
		if (rtn_slmt_ind==null) rtn_slmt_ind ="";
	
		if (rtn_slmt_ind != "C" && !(rtn_slmt_ind == "X" && rtn_adm_rec_flag == "2"))
		{
			if (v_third_party_gl_in_use_yn == "Y" && v_third_party_gl_mandatory_yn == "Y"  && rtn_gl_holder_name == "")
			{
				alert(getMessage("BL9544",'BL'));
				return(false);
			}
	
			if (v_third_party_gl_in_use_yn == "Y" && v_third_party_gl_mandatory_yn == "Y"  && rtn_pat_reln_with_gl_holder == "")
			{
				alert(getMessage("BL9545",'BL'));
				return(false);
			}
	
			if (v_third_party_gl_in_use_yn == "Y" && rtn_pat_reln_with_gl_holder != "" && rtn_gl_holder_name == "")
			{
				alert(getMessage("BL9544",'BL'));
				return(false);
			}
	
			if (v_third_party_gl_in_use_yn == "Y" && rtn_gl_holder_name != "" && rtn_pat_reln_with_gl_holder == "")
			{
				alert(getMessage("BL9545",'BL'));
				return(false);
			}
		}
		//Added V190801 Gayathri/GHL-CRF-0523	
	
		if(rtn_pat_bed_cat=="" && capture_pat_bed_category== "Y" )
		{
			alert(getMessage("BL0859","BL"));
			return false;
		}
		if(cap_ref_src_dtl_flag=="Y")
		{
			var rtn_blng_grp_desc = parent.frames[0].document.forms[0].billing_group_desc.value;
			if(referral_source_main_mand_YN == "Y")
			{
				if((rtn_ref_src_main_code=="" || rtn_ref_src_main_code==null) || (rtn_ref_src_main_desc=="" || rtn_ref_src_main_desc==null))
				{
					alert(getMessage("BL9816","BL")+" "+getLabel("Common.for.label","common")+" "+rtn_blng_grp_desc);
					return false;
				}
			}
	
			if(referral_source_sub_mand_YN == "Y")
			{
				if((rtn_ref_src_sub_code=="" || rtn_ref_src_sub_code==null) || (rtn_ref_src_sub_desc=="" || rtn_ref_src_sub_desc==null))
				{
					alert(getMessage("BL9817","BL")+" "+getLabel("Common.for.label","common")+" "+rtn_blng_grp_desc);
					return false;
				}
			}
		}
		else
		{
			rtn_ref_src_main_code="";
			rtn_ref_src_main_desc="";
			rtn_ref_src_sub_code="";
			rtn_ref_src_sub_desc="";
		}
	
		if (HideChk=="SHOW" )
		{
			if (rtn_slmt_ind == "C" )
			{
				try
				{
					rtn_slmt_type_code	= parent.frames[1].frames[0].document.forms[0].cash_set_type1.value;
					rtn_slmt_type_code=rtn_slmt_type_code.substring(0,2);
					if(rtn_slmt_type_code==null) rtn_slmt_type_code="";
				}
	
				catch(ex)
				{
				}
				
				var	chk_credit_doc_yn1 = parent.frames[1].frames[0].document.forms[0].credit_doc_reqd_yn1.value;
				if(chk_credit_doc_yn1==null) chk_credit_doc_yn1="";
				rtn_credit_doc_reqd_yn	= chk_credit_doc_yn1;
				
				if (chk_credit_doc_yn1 == "Y")
				{
					rtn_credit_doc_ref = parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.value;
					if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
	//				if(!CheckChars_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
					if(!CheckCharsAllLang_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
					{
						alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
						parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.select();
						return false;
					}
					
					rtn_credit_doc_start_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.value;	
					if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
					if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1,encounter_date_aft_trunc,"Y"))
					{
						alert(getMessage("BL9883","BL"));
						return false;
					}
	
					if(rtn_credit_doc_start_date!="")
					{
						rtn_credit_doc_start_date=convertDate(rtn_credit_doc_start_date,'DMY',locale,"en");
					}
	
					rtn_credit_doc_end_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_date1.value;	
					if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
	
					if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_date1,encounter_date_aft_trunc,"Y"))
					{
						alert(getMessage("BL9884","BL"));
						return false;
					}
	
					if(rtn_credit_doc_end_date!="")
					{
						rtn_credit_doc_end_date=convertDate(rtn_credit_doc_end_date,'DMY',locale,"en");
					}
				}
	
				if(!((rtn_resp_for_payment=="") ||(rtn_resp_for_payment==null)))
				{
					if(rtn_pat_reln_with_resp_person==null || rtn_pat_reln_with_resp_person=="")
					{
						alert(getMessage("BL9561","BL"));
	//					parent.frames[0].document.forms[0].pat_reln_with_resp_person.focus();
						return false;
					}
				}
	
				if(rtn_slmt_type_code=="")
				{
					alert(getMessage("BL9521","BL"));
	//				parent.frames[1].frames[0].document.forms[0].cash_set_type1.focus();
					return false;
				}
	
				if(chk_credit_doc_yn1 =="Y")
				{
					if(rtn_credit_doc_ref=="")
					{
						alert(getMessage("BL9302",'BL'));
	//					parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.focus();
						return false;
					}			
		
					if(rtn_credit_doc_start_date=="")
					{
						alert(getMessage("BL1531",'BL'));
	//					parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.focus();
						return false;
					}
					if(rtn_credit_doc_end_date=="")
					{
						alert(getMessage("BL1532",'BL'));
	//					parent.frames[1].frames[0].document.forms[0].credit_doc_date1.focus();
						return false;
					}
				}
				//Added V181105-Subha/KDAH-SCF-0425/Starts
				if(state_validated == 'N') {
					if(site_specific == true || site_specific == "true") {//Modified V180528-Aravindh/KDAH-SCF-0425/From if(site_specific)
						if(ext_blng_grp != "" && ext_blng_grp != undefined && ext_blng_grp != null) {
							if(cur_blng_grp != ext_blng_grp) {
								var confirm_yn = confirm(getMessage("BL0750","BL"));
								if(!confirm_yn) {
									return false;
								}
							}
						}
					}
				}      
				//Added V181105-Subha/KDAH-SCF-0425/Ends
	
				var slmt_type_code = "";
				var blng_grp = "";
				var cust_group_code = "";
				var cust_code ="";
	
				if(rtn_upd_patient_fin_dtls_yn == "Y")
				{
					chng_class_for_inv_pyrs_on_rfrsh();
					slmt_type_code=rtn_slmt_type_code;
					blng_grp=rtn_blng_grp;
					if(rtn_slmt_ind=="R")
					{
						cust_group_code = rtn_credit_cust_group_code;
						cust_code=rtn_credit_cust_code;
					}	
					else if(rtn_slmt_ind=="X" && rtn_non_ins_blng_grp=="")
					{
						cust_group_code = rtn_sponsor_cust_group_code;
						cust_code=rtn_sponsor_cust_code;
					}
					else if(rtn_slmt_ind=="X" && rtn_non_ins_blng_grp!="")
					{
						blng_grp=rtn_ins_blng_grp;
						cust_group_code=rtn_ins_cust_group_code;
						cust_code=rtn_ins_cust_code;
						slmt_type_code=rtn_non_ins_slmt_type_code;
					}
				
				var  ret_val= await validate_upd_pat_fin_dtls(rtn_patient_id,rtn_facility_id,blng_grp,rtn_slmt_ind,slmt_type_code,cust_code,rtn_ins_policy_type_code,rtn_ins_cust_priority,rtn_non_ins_blng_grp,rtn_non_ins_cust_code);
						
					if(ret_val == 'N')
						return false;
				}
	
				document.PatFinMainForm.rtn_blng_grp.value=rtn_blng_grp;
				document.PatFinMainForm.rtn_slmt_ind.value=rtn_slmt_ind;
				document.PatFinMainForm.rtn_credit_doc_reqd_yn.value=rtn_credit_doc_reqd_yn;
				document.PatFinMainForm.rtn_blng_class.value=rtn_blng_class;
				document.PatFinMainForm.rtn_emp_code.value=rtn_emp_code;
				document.PatFinMainForm.rtn_slmt_type_code.value=rtn_slmt_type_code;
				document.PatFinMainForm.rtn_inst_ref.value=rtn_inst_ref;
				document.PatFinMainForm.rtn_inst_date.value=rtn_inst_date;
				document.PatFinMainForm.rtn_inst_remarks.value=rtn_inst_remarks;
				document.PatFinMainForm.rtn_credit_cust_group_code.value=rtn_credit_cust_group_code;
				document.PatFinMainForm.rtn_credit_cust_code.value=rtn_credit_cust_code;
				document.PatFinMainForm.rtn_credit_doc_ref.value=rtn_credit_doc_ref;
				document.PatFinMainForm.rtn_credit_doc_start_date.value=rtn_credit_doc_start_date;
				document.PatFinMainForm.rtn_credit_doc_end_date.value=rtn_credit_doc_end_date;
				document.PatFinMainForm.rtn_sponsor_cust_group_code.value=rtn_sponsor_cust_group_code;
				document.PatFinMainForm.rtn_sponsor_cust_code.value=rtn_sponsor_cust_code;
				document.PatFinMainForm.rtn_sponsor_credit_doc_ref.value=rtn_sponsor_credit_doc_ref;
				document.PatFinMainForm.rtn_sponsor_credit_doc_start_date.value=rtn_sponsor_credit_doc_start_date;
				document.PatFinMainForm.rtn_sponsor_credit_doc_end_date.value=rtn_sponsor_credit_doc_end_date;
				document.PatFinMainForm.rtn_ins_blng_grp.value=rtn_ins_blng_grp;
				document.PatFinMainForm.rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;
				document.PatFinMainForm.rtn_ins_cust_code.value=rtn_ins_cust_code;
				document.PatFinMainForm.rtn_ins_cust_priority.value=rtn_ins_cust_priority;
				document.PatFinMainForm.rtn_ins_policy_type_code.value=rtn_ins_policy_type_code;
				document.PatFinMainForm.rtn_ins_policy_no.value=rtn_ins_policy_no;
				document.PatFinMainForm.rtn_ins_policy_start_date.value=rtn_ins_policy_start_date;
				document.PatFinMainForm.rtn_ins_policy_expiry_date.value=rtn_ins_policy_expiry_date;
				document.PatFinMainForm.rtn_ins_credit_auth_ref.value=rtn_ins_credit_auth_ref;
				document.PatFinMainForm.rtn_ins_credit_auth_date.value=rtn_ins_credit_auth_date;
				document.PatFinMainForm.rtn_ins_cred_auth_req_yn.value=rtn_ins_cred_auth_req_yn;
				document.PatFinMainForm.rtn_ins_cred_auth_mand_capt_yn.value=rtn_ins_cred_auth_mand_capt_yn;			
				document.PatFinMainForm.rtn_ins_dflt_auth_ref_as_pol_no_yn.value=rtn_ins_dflt_auth_ref_as_pol_no_yn;
				document.PatFinMainForm.rtn_ins_credit_approval_days.value=rtn_ins_credit_approval_days;
				document.PatFinMainForm.rtn_ins_credit_approval_amount.value=rtn_ins_credit_approval_amount;
				document.PatFinMainForm.rtn_ins_policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
				document.PatFinMainForm.rtn_ins_policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
				document.PatFinMainForm.rtn_ins_adj_rule_ind.value=rtn_ins_adj_rule_ind;
				document.PatFinMainForm.rtn_ins_adj_perc_amt_ind.value=rtn_ins_adj_perc_amt_ind;
				document.PatFinMainForm.rtn_ins_adj_perc_amt_value.value=rtn_ins_adj_perc_amt_value;
				document.PatFinMainForm.rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;
				document.PatFinMainForm.rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;
				document.PatFinMainForm.rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;
				document.PatFinMainForm.rtn_non_ins_blng_grp.value=rtn_non_ins_blng_grp;
				document.PatFinMainForm.rtn_non_ins_credit_doc_reqd_yn.value=rtn_non_ins_credit_doc_reqd_yn;
				document.PatFinMainForm.rtn_non_ins_slmt_type_code.value=rtn_non_ins_slmt_type_code;
				document.PatFinMainForm.rtn_non_ins_inst_ref.value=rtn_non_ins_inst_ref;
				document.PatFinMainForm.rtn_non_ins_inst_date.value=rtn_non_ins_inst_date;
				document.PatFinMainForm.rtn_non_ins_inst_remarks.value=rtn_non_ins_inst_remarks;
				document.PatFinMainForm.rtn_non_ins_cust_group_code.value=rtn_non_ins_cust_group_code;
				document.PatFinMainForm.rtn_non_ins_cust_code.value=rtn_non_ins_cust_code;
				document.PatFinMainForm.rtn_non_ins_credit_doc_ref.value=rtn_non_ins_credit_doc_ref;
				document.PatFinMainForm.rtn_non_ins_credit_doc_start_date.value=rtn_non_ins_credit_doc_start_date;
				document.PatFinMainForm.rtn_non_ins_credit_doc_end_date.value=rtn_non_ins_credit_doc_end_date;
				document.PatFinMainForm.rtn_annual_income.value=rtn_annual_income;
				document.PatFinMainForm.rtn_family_asset.value=rtn_family_asset;
				document.PatFinMainForm.rtn_no_of_dependants.value=rtn_no_of_dependants;
				document.PatFinMainForm.rtn_resp_for_payment.value=rtn_resp_for_payment;
				document.PatFinMainForm.rtn_pat_reln_with_resp_person.value=rtn_pat_reln_with_resp_person;
				document.PatFinMainForm.rtn_fin_remarks.value=rtn_fin_remarks;
			
				document.PatFinMainForm.rtn_gl_holder_name.value=rtn_gl_holder_name;
				document.PatFinMainForm.rtn_pat_reln_with_gl_holder.value=rtn_pat_reln_with_gl_holder;
				document.PatFinMainForm.rtn_upd_patient_fin_dtls_yn.value=rtn_upd_patient_fin_dtls_yn;
				document.PatFinMainForm.rtn_spl_clinic_rel_enc_YN.value=rtn_spl_clinic_rel_enc_YN;			
				document.PatFinMainForm.rtn_user_id.value=rtn_user_id;
				document.PatFinMainForm.rtn_fin_auth_user_id.value=rtn_fin_auth_user_id;
				document.PatFinMainForm.rtn_ins_restrict_check.value=rtn_ins_restrict_check;
				document.PatFinMainForm.rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;
				document.PatFinMainForm.rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;
				document.PatFinMainForm.rtn_ref_src_main_code.value=rtn_ref_src_main_code;
				document.PatFinMainForm.rtn_ref_src_main_desc.value=rtn_ref_src_main_desc;
				document.PatFinMainForm.rtn_ref_src_sub_code.value=rtn_ref_src_sub_code;
				document.PatFinMainForm.rtn_ref_src_sub_desc.value=rtn_ref_src_sub_desc;
			
				document.PatFinMainForm.rtn_ins_ref_src_main_code.value=rtn_ins_ref_src_main_code;
				document.PatFinMainForm.rtn_ins_ref_src_main_desc.value=rtn_ins_ref_src_main_desc;
				document.PatFinMainForm.rtn_ins_ref_src_sub_code.value=rtn_ins_ref_src_sub_code;
				document.PatFinMainForm.rtn_ins_ref_src_sub_desc.value=rtn_ins_ref_src_sub_desc;
			
				document.PatFinMainForm.rtn_non_ins_ref_src_main_code.value=rtn_non_ins_ref_src_main_code;
				document.PatFinMainForm.rtn_non_ins_ref_src_main_desc.value=rtn_non_ins_ref_src_main_desc;
				document.PatFinMainForm.rtn_non_ins_ref_src_sub_code.value=rtn_non_ins_ref_src_sub_code;
				document.PatFinMainForm.rtn_non_ins_ref_src_sub_desc.value=rtn_non_ins_ref_src_sub_desc;
			
				document.PatFinMainForm.rtn_tot_valid_enc_with_gl.value=rtn_tot_valid_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_op_enc_with_gl.value=rtn_tot_valid_op_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_ae_enc_with_gl.value=rtn_tot_valid_ae_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_ip_enc_with_gl.value=rtn_tot_valid_ip_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_dc_enc_with_gl.value=rtn_tot_valid_dc_enc_with_gl;
			
				document.PatFinMainForm.rtn_tot_availed_enc_with_gl.value=rtn_tot_availed_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_op_enc_with_gl.value=rtn_tot_availed_op_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_ae_enc_with_gl.value=rtn_tot_availed_ae_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_ip_enc_with_gl.value=rtn_tot_availed_ip_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_dc_enc_with_gl.value=rtn_tot_availed_dc_enc_with_gl;
				document.PatFinMainForm.rtn_gl_doc_ref_exist_YN.value=rtn_gl_doc_ref_exist_YN;
				document.PatFinMainForm.rtn_calling_function_id.value=calling_function_id;
				document.PatFinMainForm.rtn_pat_ser_code.value=rtn_pat_ser_code;
				document.PatFinMainForm.rtn_mcn_for_policy.value=rtn_mcn_for_policy;  //V220908
				document.PatFinMainForm.rtn_reg_ref_id.value=rtn_reg_ref_id;  //V230315
				document.PatFinMainForm.rtn_userId_for_priv.value=rtn_userId_for_priv;  //V230707
				document.PatFinMainForm.rtn_reasonCode_for_priv.value=rtn_reasonCode_for_priv;   //V230707
		
				if(autoFinChk=="Y" && calling_function_id != "BOOKING")
				{	   
					document.PatFinMainForm.rtn_class_type.value = rtn_class_type;
					document.PatFinMainForm.rtn_class_code.value = rtn_class_code;
					document.PatFinMainForm.rtn_remarks.value = rtn_remarks;
					document.PatFinMainForm.rtn_social_pensioner_id.value = rtn_social_pensioner_id;
					document.PatFinMainForm.rtn_inc_asset_ind.value = rtn_inc_asset_ind;
					document.PatFinMainForm.rtn_ind_inc.value = rtn_ind_inc;
					document.PatFinMainForm.rtn_ind_inc_freq.value = rtn_ind_inc_freq;
					document.PatFinMainForm.rtn_spouse_inc.value = rtn_spouse_inc;
					document.PatFinMainForm.rtn_spouse_inc_freq.value = rtn_spouse_inc_freq;
					document.PatFinMainForm.rtn_dependent_inc.value = rtn_dependent_inc;
					document.PatFinMainForm.rtn_dependent_inc_freq.value = rtn_dependent_inc_freq;
					document.PatFinMainForm.rtn_valid_from.value = rtn_valid_from;
					document.PatFinMainForm.rtn_valid_to.value = rtn_valid_to;
					document.PatFinMainForm.rtn_last_date.value = rtn_last_date;
				}
				var returnArray=new Array(rtn_blng_grp);

				//parent.window.returnValue=returnArray;
				let dialogBody = parent.parent.document.getElementById('dialog-body');
			
			    /* Code Added by Vedesh A D for Edge Conversion */
				var dialogTagFrame = "";
				var dialogBodyFrame = "";
				const diagElement = top.document.getElementsByTagName("dialog");
			    var i = 0; var j = 0;
			    for (i = 0; i < diagElement.length; i++) 
				{
			    	for (j = 0; j < diagElement[i].children.length; j++) 
					{
			    		var element = diagElement[i].children[j];
			    		let dialogSrc = element.src;
			    		if (typeof dialogSrc !== "undefined")
			    		{ 
				    		if (dialogSrc.includes("AddModifyPatFinDetailsMain.jsp") )
				        	{
				    			//dialogTagFrame = diagElement[i];
				    			dialogBodyFrame = element;
				    			
				        	}
			    		}    		
			    	} 
			    }
			    if(dialogTagFrame == undefined && dialogBodyFrame == undefined){
			    
			    	dialogTagFrame = parent.parent.document.getElementById('dialog_tag');
			    	dialogBodyFrame = parent.parent.document.getElementById('dialog-body');
			    }
			    /* end */
			    
			    dialogBodyFrame.contentWindow.returnValue = returnArray;

				parent.frames[2].location.href='../../eBL/jsp/BLFinancialDetailsSubmit.jsp';
				return true; 
			}
		}
	
		if(rtn_slmt_ind=="X" && rtn_adm_rec_flag=="2")
		{
			var mode=parent.frames[1].frames[0].frames[1].document.forms[0].Case.value;
		}
		else
		{
			try
			{
			var mode=parent.frames[1].frames[0].document.forms[0].Case.value;
			}catch(err){}
		}
		if(mode=="1")
		{
			rtn_slmt_type_code	= parent.frames[1].frames[0].document.forms[0].cash_set_type1.value;
			chkCashSet1=rtn_slmt_type_code.substring(2);
			rtn_slmt_type_code=rtn_slmt_type_code.substring(0,2);
		}
		if (mode == "1")
		{
			chk_credit_doc_yn1 = parent.frames[1].frames[0].document.forms[0].credit_doc_reqd_yn1.value;
			rtn_credit_doc_reqd_yn	= chk_credit_doc_yn1;
	
			if (chk_credit_doc_yn1 == "Y")
			{
				rtn_credit_doc_ref = parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.value;
				if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
	//			if(!CheckChars_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
				if(!CheckCharsAllLang_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
				{
					alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
					parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.select();
					return false;
				}
	
				rtn_credit_doc_start_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.value;				
				if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
				
				if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9883","BL"));
					return false;
				}
	
				if(rtn_credit_doc_start_date!="")
				{
					rtn_credit_doc_start_date=convertDate(rtn_credit_doc_start_date,'DMY',locale,"en");
				}
	
				rtn_credit_doc_end_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_date1.value;			
				if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
	
				if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_date1,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9884","BL"));
					return false;
				}
	
				if(rtn_credit_doc_end_date!="")
				{
					rtn_credit_doc_end_date=convertDate(rtn_credit_doc_end_date,'DMY',locale,"en");
				}
			}
		}
		
		if((mode != "4")&&(chkCashSet1!="Y"))
		{
			if(checkForValidFrames4())
			{
				rtn_inst_ref = parent.frames[1].frames[1].document.forms[0].cash_insmt_ref1.value;
				if(rtn_inst_ref==null) rtn_inst_ref="";
				rtn_inst_date  = parent.frames[1].frames[1].document.forms[0].cash_insmt_date1.value;
				if(rtn_inst_date==null) rtn_inst_date="";
				rtn_inst_remarks = parent.frames[1].frames[1].document.forms[0].cash_insmt_rmks1.value;
				if(rtn_inst_remarks==null) rtn_inst_remarks="";
			}
		}
		
		if(mode=="2")
		{
			rtn_credit_cust_group_code = parent.frames[1].frames[0].document.forms[0].cust_group_code_1.value;
			if(rtn_credit_cust_group_code==null) rtn_credit_cust_group_code="";
	
			rtn_credit_cust_code    = parent.frames[1].frames[0].document.forms[0].cust_1.value;
			if(rtn_credit_cust_code==null) rtn_credit_cust_code="";
	
			cust_valid_from_date		= parent.frames[1].frames[0].document.forms[0].cust_valid_from_date.value;
			cust_valid_to_date			= parent.frames[1].frames[0].document.forms[0].cust_valid_to_date.value;
			
			if(cust_valid_from_date == " " || cust_valid_from_date == null) cust_valid_from_date="";
			if(cust_valid_to_date == " " || cust_valid_to_date == null) cust_valid_to_date="";
	
			if(cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc=cust_valid_from_date;
	
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);
	
				if(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date_loc,'DMY',locale))
				{				
					//Added by Rajesh V - If logic
					if(calling_module_id != 'MP'){
						alert(getMessage("BL8227","BL"));
						return false;
					}
				}
			}
			if(cust_valid_to_date != "")
			{	
				var cust_valid_to_date_loc=cust_valid_to_date;
	
				if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);
	
				if(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					return false;
				}
			}
	
			rtn_credit_doc_ref = parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.value;
			if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
	//		if(!CheckChars_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
			if(!CheckCharsAllLang_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref1))
			{
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.select();
				return false;
			}
	
			rtn_credit_doc_start_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.value;				
			if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
			if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9883","BL"));
				return false;
			}
	
			if(rtn_credit_doc_start_date!="")
			{
				rtn_credit_doc_start_date=convertDate(rtn_credit_doc_start_date,'DMY',locale,"en");
			}
	
			rtn_credit_doc_end_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_date1.value;
			if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
	
			if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_date1,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9884","BL"));
				return false;
			}
	
			if(rtn_credit_doc_end_date!="")
			{
				rtn_credit_doc_end_date=convertDate(rtn_credit_doc_end_date,'DMY',locale,"en");
			}
		}
		
		if(mode=="3")
		{	
			rtn_sponsor_cust_group_code = parent.frames[1].frames[0].document.forms[0].cust_group_code_2.value;
			if(rtn_sponsor_cust_group_code==null) rtn_sponsor_cust_group_code="";
	
			rtn_sponsor_cust_code		= parent.frames[1].frames[0].document.forms[0].cust_2.value;
			if(rtn_sponsor_cust_code==null) rtn_sponsor_cust_code="";
	
			cust_valid_from_date		= parent.frames[1].frames[0].document.forms[0].cust_valid_from_date.value;
			cust_valid_to_date			= parent.frames[1].frames[0].document.forms[0].cust_valid_to_date.value;
	
			if(cust_valid_from_date == " " || cust_valid_from_date == null) cust_valid_from_date="";
			if(cust_valid_to_date == " " || cust_valid_to_date == null) cust_valid_to_date="";
	
			if(cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc=cust_valid_from_date;
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);
	
				if(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date_loc,'DMY',locale))
				{
					//Added by Rajesh V - If logic
					if(calling_module_id != 'MP'){
						alert(getMessage("BL8227","BL"));
						return false;
					}
				}
			}
			if(cust_valid_to_date != "")
			{
				var cust_valid_to_date_loc=cust_valid_to_date;
	
				if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);
	
				if(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					return false;
				}
			}
	
			rtn_sponsor_credit_doc_ref	= parent.frames[1].frames[0].document.forms[0].credit_doc_ref2.value;
			if(rtn_sponsor_credit_doc_ref==null) rtn_sponsor_credit_doc_ref="";
	//		if(!CheckChars_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref2))
		/*	if(!CheckCharsAllLang_local(parent.frames[1].frames[0].document.forms[0].credit_doc_ref2))
			{
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				 parent.frames[1].frames[0].document.forms[0].credit_doc_ref2.select();
				return false;
			}*/
			
			rtn_sponsor_credit_doc_start_date  = parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.value;				
			if(rtn_sponsor_credit_doc_start_date==null) rtn_sponsor_credit_doc_start_date="";
			if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9883","BL"));
				return false;
			}
	
			if(rtn_sponsor_credit_doc_start_date!="")
			{
				rtn_sponsor_credit_doc_start_date=convertDate(rtn_sponsor_credit_doc_start_date,'DMY',locale,"en");
			}
	
			rtn_sponsor_credit_doc_end_date	= parent.frames[1].frames[0].document.forms[0].credit_doc_date2.value;
			if(rtn_sponsor_credit_doc_end_date==null) rtn_sponsor_credit_doc_end_date="";
	
			if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[0].document.forms[0].credit_doc_date2,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9884","BL"));
				return false;
			}
	
			if(rtn_sponsor_credit_doc_end_date!="")
			{
				rtn_sponsor_credit_doc_end_date=convertDate(rtn_sponsor_credit_doc_end_date,'DMY',locale,"en");
			}
		}
	
		if (mode=="2" || mode=="3")
		{
			var temp_tot_valid_op_enc_with_gl = "";
			var temp_tot_valid_op_enc_with_gl = "";
			var temp_tot_valid_ae_enc_with_gl = "";
			var temp_tot_valid_ip_enc_with_gl = "";
			var temp_tot_valid_dc_enc_with_gl = "";
	
			rtn_gl_doc_ref_exist_YN = parent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value;
			rtn_tot_valid_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value;
			rtn_tot_valid_op_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value;
			rtn_tot_valid_ae_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value;
			rtn_tot_valid_ip_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value;
			rtn_tot_valid_dc_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value;
	
			temp_tot_valid_enc_with_gl = rtn_tot_valid_enc_with_gl;
			temp_tot_valid_op_enc_with_gl = rtn_tot_valid_op_enc_with_gl;
			temp_tot_valid_ae_enc_with_gl = rtn_tot_valid_ae_enc_with_gl;
			temp_tot_valid_ip_enc_with_gl = rtn_tot_valid_ip_enc_with_gl;
			temp_tot_valid_dc_enc_with_gl = rtn_tot_valid_dc_enc_with_gl;
	
			if(temp_tot_valid_enc_with_gl=="") temp_tot_valid_enc_with_gl='999';
			if(temp_tot_valid_op_enc_with_gl=="") temp_tot_valid_op_enc_with_gl=rtn_tot_valid_enc_with_gl;
			if(temp_tot_valid_ae_enc_with_gl=="") temp_tot_valid_ae_enc_with_gl=rtn_tot_valid_enc_with_gl;
			if(temp_tot_valid_ip_enc_with_gl=="") temp_tot_valid_ip_enc_with_gl=rtn_tot_valid_enc_with_gl;
			if(temp_tot_valid_dc_enc_with_gl=="") temp_tot_valid_dc_enc_with_gl=rtn_tot_valid_enc_with_gl;
	
			rtn_tot_availed_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_availed_enc_with_gl.value;
			rtn_tot_availed_op_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_availed_op_enc_with_gl.value;
			rtn_tot_availed_ae_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_availed_ae_enc_with_gl.value;
			rtn_tot_availed_ip_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_availed_ip_enc_with_gl.value;
			rtn_tot_availed_dc_enc_with_gl = parent.frames[1].frames[0].document.forms[0].tot_availed_dc_enc_with_gl.value;
			if(calling_function_id != "BOOKING" && calling_module_id != "MP")
			{
				if(rtn_gl_doc_ref_exist_YN =="Y")
				{
					if(calling_module_id=="OP")
					{
						if( ( (eval(rtn_tot_availed_op_enc_with_gl)+1) > eval(temp_tot_valid_op_enc_with_gl) ) || ( (eval(rtn_tot_availed_enc_with_gl)+1) > eval(rtn_tot_valid_enc_with_gl) ) )
						{
							alert(getMessage("BL6428","BL"));
							return false;
						}
					}
					else if(calling_module_id=="AE")
					{
						if( ( (eval(rtn_tot_availed_ae_enc_with_gl)+1) > eval(temp_tot_valid_ae_enc_with_gl) ) || ( (eval(rtn_tot_availed_enc_with_gl)+1) > eval(rtn_tot_valid_enc_with_gl) ) )
						{
							alert(getMessage("BL6428","BL"));
							return false;
						}
					}
					else if(calling_module_id=="IP")
					{
						if( ( (eval(rtn_tot_availed_ip_enc_with_gl)+1) > eval(temp_tot_valid_ip_enc_with_gl) ) || ( (eval(rtn_tot_availed_enc_with_gl)+1) > eval(rtn_tot_valid_enc_with_gl) ) )
						{
							alert(getMessage("BL6428","BL"));
							return false;
						}
					}
					else if(calling_module_id=="DC")
					{
						if( ( (eval(rtn_tot_availed_dc_enc_with_gl)+1) > eval(temp_tot_valid_dc_enc_with_gl) ) || ( (eval(rtn_tot_availed_enc_with_gl)+1) > eval(rtn_tot_valid_enc_with_gl) ) )
						{
							alert(getMessage("BL6428","BL"));
							return false;
						}
					}
				}
				else
				{
					if(eval(temp_tot_valid_enc_with_gl) == 0)
					{
						alert(getMessage("BL6430","BL"));
						parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value='';
						parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.select();
						return false;
					}
	
					if(calling_module_id == "OP")
					{
						if(temp_tot_valid_op_enc_with_gl != "")
						{
							if(eval(temp_tot_valid_op_enc_with_gl) == 0)
							{
								alert(getMessage("BL6429","BL"));
								parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value='';
								parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.select();
								return false;
							}
						}
					}
	
					if(calling_module_id == "AE")
					{
						if(temp_tot_valid_ae_enc_with_gl != "")
						{
							if(eval(temp_tot_valid_ae_enc_with_gl) == 0)
							{
								alert(getMessage("BL6429","BL"));
								parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value='';
								parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.select();
								return false;
							}
						}
					}
	
					if(calling_module_id == "IP")
					{
						if(temp_tot_valid_ip_enc_with_gl != "")
						{
							if(eval(temp_tot_valid_ip_enc_with_gl) == 0)
							{
								alert(getMessage("BL6429","BL"));
								parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value='';
								parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.select();
								return false;
							}
						}
					}
	
					if(calling_module_id == "DC")
					{
						if(temp_tot_valid_dc_enc_with_gl != "")
						{
							if(eval(temp_tot_valid_dc_enc_with_gl) == 0)
							{
								alert(getMessage("BL6429","BL"));
								parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value='';
								parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.select();
								return false;
							}
						}
					}
				}
			}
		}
	
		if(mode=="4")
		{
			rtn_total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;
			if(rtn_total_records==null) rtn_total_records="";
			//Added by prithivi on 05/01/2017 for mms-qh-crf-0085 bupa insurance payer eligibility check
			//Commented by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1
			//var moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);
		   
			//Commented by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1
			//if(rtn_slmt_ind=="X" && moduleIdValidation=="Y")
			if (rtn_slmt_ind=="X")
			{
			    var payerEligibility_check_arr=new Array();
			    var eligibilityCheck=false;
			    var alertMsgg="Payer Eligibility Check hasn't been done for the following                                     \n\n";
				for(var i=0;i<rtn_total_records;i++)
				{
				   var payerElgParam = eval("parent.frames[1].frames[0].frames[1].document.forms[0].payerEligibilityParam"+i);
				   var ins_blng_grp_desc1_int2=eval("parent.frames[1].frames[0].frames[1].document.forms[0].ins_cust_group_name"+i);
				   var blngGrpVal=ins_blng_grp_desc1_int2.value;
				   var ins_blng_grp_code12=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
				   var ins_blng_grp_code2=ins_blng_grp_code12.value;
	
				    if(payerElgParam!=undefined)
					{
						var payer_desc1_int=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_desc"+i);
						var priority1_int=eval("parent.frames[1].frames[0].frames[1].document.forms[0].priority"+i);
						var policy_type_desc1_int=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_desc"+i);
						var payerElgParamValue=payerElgParam.value;
						var payerDescVal=payer_desc1_int.value;
						var priorityVal=priority1_int.value;
						var policyTypeVal=policy_type_desc1_int.value;				   
					   
						var ins_cust_group_code_int = eval("parent.frames[1].frames[0].frames[1].document.forms[0].ins_cust_group_code"+i);
						var ins_cust_group_code_int_val = ins_cust_group_code_int.value;
	
						//Variables added by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1
	
						var op_interface_flag = "";
					 	var	em_interface_flag = "";
						var	ip_interface_flag = "";
						var	dc_interface_flag = "";
	
						var	membshpid_flag = "";
						var	policyno_flag = "";
	
						var interfaceYNvalidate = "";
	
						//var visitRegProcFlag = visitRegProcEnabledInterface(ins_cust_group_code_int_val);
	
						var custGrpJsonOB = checkCustomerGroupInterface(ins_cust_group_code_int_val);
	
						//Code added by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1 - Starts Here.
	
						var CustGroupConfig = jQuery.parseJSON(custGrpJsonOB);	
	
						op_interface_flag = CustGroupConfig.op_interface_flag;
						em_interface_flag = CustGroupConfig.em_interface_flag;
						ip_interface_flag = CustGroupConfig.ip_interface_flag;
						dc_interface_flag = CustGroupConfig.dc_interface_flag;
	
						membshpid_flag = CustGroupConfig.membshpid_flag;
						policyno_flag = CustGroupConfig.policyno_flag;
						visitreg_flag = CustGroupConfig.visitreg_flag;
	
						if (calling_module_id == "OP" && op_interface_flag == "Y")
						{
							interfaceYNvalidate = "Y";
						}
						if (calling_module_id == "IP" && ip_interface_flag == "Y")
						{
							interfaceYNvalidate = "Y";
						}
						if (calling_module_id == "AE" && em_interface_flag == "Y")
						{
							interfaceYNvalidate = "Y";
						}
						if (calling_module_id == "DC" && dc_interface_flag == "Y")
						{
							interfaceYNvalidate = "Y";
						}
	
						//Code added by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1 - Ends here.
	
						if(payerElgParamValue == "0")
						{
							eligibilityCheck=true;
							alertMsgg=alertMsgg+"Billing group: "+blngGrpVal+"      Payer: "+payerDescVal+"        Priority: "+priorityVal+"         Policy: "+policyTypeVal+"\n\n";
						}
						else if(payerElgParamValue == "")
						{
							//Commented by Sethu on 15/09/2020 for NMC-JD-CRF-0054.1
							//var interfaceYNvalidate = checkCustomerGroupInterface(ins_cust_group_code_int_val);						
							
							if(interfaceYNvalidate =="Y")
							{
								eligibilityCheck=true;
								alertMsgg=alertMsgg+"Billing group: "+blngGrpVal+"      Payer: "+payerDescVal+"        Priority: "+priorityVal+"         Policy: "+policyTypeVal+"\n\n";
							}
						}
	
					}
				}
				if(eligibilityCheck==true)
				{
				   alert(alertMsgg);
				   return false;
				}
			}
		  	
			rtn_ins_auth_flag = parent.frames[1].frames[0].frames[1].document.forms[0].ins_auth_flag.value;
			if(rtn_ins_auth_flag==null) rtn_ins_auth_flag="";
			
			//moved above
			//rtn_total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;
			//if(rtn_total_records==null) rtn_total_records="";
	
			rtn_non_ins_blng_grp   = parent.frames[1].frames[0].frames[2].document.forms[0].non_insur_blng_grp.value;
			if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";
	
			rtn_non_ins_ref_src_main_code= parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_main_code.value;		
			if(rtn_non_ins_ref_src_main_code==null) rtn_non_ins_ref_src_main_code = "";
	
			rtn_non_ins_ref_src_main_desc= parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_main_desc.value;		
			if(rtn_non_ins_ref_src_main_desc==null) rtn_non_ins_ref_src_main_desc = "";
	
			rtn_non_ins_ref_src_sub_code= parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_sub_code.value;		
			if(rtn_non_ins_ref_src_sub_code==null) rtn_non_ins_ref_src_sub_code = "";
	
			rtn_non_ins_ref_src_sub_desc= parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_sub_desc.value;		
			if(rtn_non_ins_ref_src_sub_desc==null) rtn_non_ins_ref_src_sub_desc = "";
	
			var noninsblnggrpappyn	   = parent.frames[1].frames[0].frames[1].document.forms[0].blnggrpappyn.value;
	
			var noninsblnggrpcatgappyn   = parent.frames[1].frames[0].frames[1].document.forms[0].blnggrpcatgappyn.value;
			var noninsblnggrpstatus	   = parent.frames[1].frames[0].frames[1].document.forms[0].BlngGrpStatus.value;
	
			var payer_code_arr=new Array();
			var policy_type_code_arr=new Array();
			var priority_arr=new Array();
			var policy_coverage_basis_ind_arr=new Array();
			var ins_blng_grp_code_arr=new Array();
			var ins_blng_grp_desc_arr=new Array();
	
			var ins_policy_no_arr=new Array();
			var ins_pol_start_date_arr=new Array();
			var ins_pol_exp_arr=new Array();
			var ins_pol_exp_date_arr=new Array();
			var ins_pol_eff_frm_date_arr=new Array();
			var ins_pol_eff_to_date_arr=new Array();
	
			for(var i=0;i<rtn_total_records;i++)
			{
				var cust_31 = eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_3"+i);
				var payer_code=cust_31.value;
				var policy_type_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_code"+i);
				var policy_type_code=policy_type_code1.value;
				var priority1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].priority"+i);
				var priority=priority1.value;
				var ins_blng_grp_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
				var ins_blng_grp_code=ins_blng_grp_code1.value;
				var ins_blng_grp_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].billing_group_desc"+i);
				var ins_blng_grp_desc=ins_blng_grp_desc1.value;
				
	
				var policy_coverage_basis_ind1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_coverage_basis_ind"+i);
				var policy_coverage_basis_ind=policy_coverage_basis_ind1.value;
	
				var ins_policy_no1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_no"+i);
				var ins_policy_no=ins_policy_no1.value;
				var ins_policy_start_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_start_date"+i);
				var ins_policy_start_date = ins_policy_start_date1.value;
				var ins_policy_exp_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_exp_date"+i);
				var ins_policy_exp_date = ins_policy_exp_date1.value;
				var ins_policy_eff_frm_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_eff_frm_date"+i);
				var ins_policy_eff_frm_date = ins_policy_eff_frm_date1.value;
				var ins_policy_eff_to_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_eff_to_date"+i);
				var ins_policy_eff_to_date = ins_policy_eff_to_date1.value;
	
				payer_code_arr[i]=payer_code;
				policy_type_code_arr[i]=policy_type_code;
				priority_arr[i]=priority;
				policy_coverage_basis_ind_arr[i]=policy_coverage_basis_ind;
				ins_blng_grp_code_arr[i]=ins_blng_grp_code;
				ins_blng_grp_desc_arr[i]=ins_blng_grp_desc;
	
				ins_policy_no_arr[i] = ins_policy_no;
				ins_pol_start_date_arr[i] = ins_policy_start_date;
				ins_pol_exp_arr[i] = ins_policy_exp_date;
				ins_pol_eff_frm_date_arr[i] = ins_policy_eff_frm_date;
				ins_pol_eff_to_date_arr[i] = ins_policy_eff_to_date;
			}
			
			if(payer_code_arr.length==0)
			{
	//			alert("atleast on payer should be entered");
				alert(getMessage("BL9574","BL"));
				return false;
			}
			
			var poly_cov_bas_count=0;
			var patient_poly_cov_count=0;
	
			for (var i=0;i<policy_coverage_basis_ind_arr.length;i++)
			{
			    var policy_coverage_basis_ind_var1 = policy_coverage_basis_ind_arr[i];
				var j = i;
	
			    while(!((j+1)>rtn_total_records))
			    {
					var policy_coverage_basis_ind_var2 = policy_coverage_basis_ind_arr[j];
	
					if(policy_coverage_basis_ind_var1!=policy_coverage_basis_ind_var2)
					{
						poly_cov_bas_count++;
					}
	
					if((i!=j) && (policy_coverage_basis_ind_var1=="P" && policy_coverage_basis_ind_var2=="P"))
					{
						patient_poly_cov_count++;
					}
					j++;
			    }
			}
			
	/*		if(patient_poly_cov_count>0)
			{
				alert(getMessage("BL9727","BL"));
				return false;
			}  */
			if(poly_cov_bas_count>0)
			{
			var chargeLogic=document.forms[0].str_charge_logic.value;//48333
				if(chargeLogic!="Y"){
				alert(getMessage("BL9790","BL"));
				return false;
				}
			}
	
			for (var i=0;i<priority_arr.length;i++)
			{
			    var priortiy_var1 = priority_arr[i];
				var j = i;
	
			    while(!((j+1)>rtn_total_records))
			    {
					j++;
					var priortiy_var2 = priority_arr[j];
	
					if(parseInt(priortiy_var1) == parseInt(priortiy_var2))
					{
	//					alert("Duplicate Value found for Priority");
						alert(getMessage("BL9573","BL"));
						return false;
					}
			    }
			}
	
			var priority_check_flag=false;
	
			for(var i=0;i<priority_arr.length;i++)
			{
				if(parseInt(priority_arr[i])==1)
					priority_check_flag=true;
			}
	
			if(!priority_check_flag)
			{
				alert(getMessage("BL9834","BL"));
				return false;
			}
	
			for (var i=0;i<payer_code_arr.length;i++)
			{
			    var payer_var1 = payer_code_arr[i];
			    var policy_var1 = policy_type_code_arr[i];
				var blng_grp1 = ins_blng_grp_code_arr[i];
				var priority1 = priority_arr[i];
	
				var policy_no1 = ins_policy_no_arr[i];
				var pol_start_date_arr1 = ins_pol_start_date_arr[i];
				var pol_exp_date_arr1 = ins_pol_exp_date_arr[i];
				var policy_eff_frm_date1 = ins_pol_eff_frm_date_arr[i];
				var policy_eff_to_date1 = ins_pol_eff_to_date_arr[i];
			    var j = i;
			    while(!((j+1)>rtn_total_records))
			    {
					j++;
			        var payer_var2 =payer_code_arr[j];
					var policy_var2 = policy_type_code_arr[j];
					var blng_grp2 = ins_blng_grp_code_arr[j];
					var priority2 = priority_arr[j];
	
					var policy_no2 = ins_policy_no_arr[j];
					var pol_start_date_arr2 = ins_pol_start_date_arr[j];
					var pol_exp_date_arr2 = ins_pol_exp_date_arr[j];
					var policy_eff_frm_date2 = ins_pol_eff_frm_date_arr[j];
					var policy_eff_to_date2 = ins_pol_eff_to_date_arr[j];
				    if(payer_var1==payer_var2)
					{
						if(policy_var1==policy_var2)
						{
							if(policy_no1 == policy_no2)
							{
								if(!chkEffDatesOverlap(policy_eff_frm_date1,policy_eff_to_date1,policy_eff_frm_date2,policy_eff_to_date2))
								{
									if(priority1 > priority2);
									{
	//									alert("Policy Eff. date Cannot Overlap for the same Payer Group,Payer,Policy Type,Policy No Combination");
										alert(getMessage("BL7425","BL"));
										return false;
									}
								}
								else
								{
									if(priority1 > priority2)
									{
	//									alert("Policy Eff. date Cannot Overlap for the same Payer Group,Payer,Policy Type,Policy No Combination");
										alert(getMessage("BL7425","BL"));
										return false;
									}
								}
							}
						}
					}
			    }
			}
	
			var check_clag="N";
	
			for(var i=0;i<rtn_total_records;i++)
			{
			if(priority_arr[i]=="1")
			{
				if(!(ins_blng_grp_code_arr[i]==rtn_blng_grp))
				{
					if(confirm(getMessage("BL9851","BL")))
					{
						parent.frames[0].document.forms[0].billing_group_desc.value=ins_blng_grp_desc_arr[i];
						parent.frames[0].document.forms[0].billing_group.value=ins_blng_grp_code_arr[i];
	
						var getString=parent.frames[1].frames[0].frames[2].document.forms[0].queryString.value;
					
						var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;
						parent.frames[1].frames[0].frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?refresh_check=Y&"+getString+"&total_records="+total_records;
	
						parent.frames[1].frames[0].frames[1].document.forms[0].submit();
	
						return false;
					}
					else
					{
	//						alert(getMessage("BL9586","BL"));
						return false;
					}
				}
			}
			}
	
			var temp="";
			var temp1="";
			var blng_grp_count=0;
			var list_of_blng_grp_arr=new Array();
			var j=0;
	
			for(var i=0;i<rtn_total_records;i++)
			{
				temp=ins_blng_grp_desc_arr[i];
				if((temp!="" && temp1=="") || (temp!=temp1))
				{
					blng_grp_count++;
					list_of_blng_grp_arr[j]=temp;
					j++;
				}
				temp1=temp;
			}
	
			var hs=new Hashtable();
			var sel_priority="";
	
			for(var i=0;i<list_of_blng_grp_arr.length;i++)
			{
				var sel_blng_grp=list_of_blng_grp_arr[i];
				sel_priority="";
				for(var j=0;j<rtn_total_records;j++)
				{
					if(sel_blng_grp==ins_blng_grp_desc_arr[j])
					{
						var temp=priority_arr[j];
						sel_priority=sel_priority+temp+":";
						hs.put(sel_blng_grp,sel_priority);
					}
				}
			}
	
			var total_keys=hs.keys();
			var priorty_values="";
			var temp_arr=new Array();
			
			var max_priority_arr=new Array();
	
			for(var i=0;i<total_keys.length;i++)
			{
				priorty_values=hs.get(total_keys[i]);
				priorty_values=priorty_values.substring(0,priorty_values.length-1);
				temp_arr=priorty_values.split(':');
				var temp="";
				var temp1="";
				var max_priority="";
				var k=1;
	
				for(var j=0;j<temp_arr.length;j++)
				{
					if(parseInt(k) <= temp_arr.length)
					{
						if(parseInt(j)==0)
							temp=temp_arr[j];
	
						if(parseInt(temp_arr.length)==1)
							temp1=temp_arr[j];
						else
							temp1=temp_arr[k];
	
						if(temp1==null)
							temp1=temp;
	
						if(parseInt(temp) > parseInt(temp1))
							max_priority=temp;
						else
							max_priority=temp1;
	
						temp=max_priority;
						k++;
					}
				}
				max_priority_arr[i]=max_priority;
			}
	
			var min_priority_arr=new Array();
			
			for(var i=0;i<total_keys.length;i++)
			{
				priorty_values=hs.get(total_keys[i]);
				priorty_values=priorty_values.substring(0,priorty_values.length-1);
				temp_arr=priorty_values.split(':');
				var temp="";
				var temp1="";
				var min_priority="";
				var k=1;
	
				for(var j=0;j<temp_arr.length;j++)
				{
					if(parseInt(k) <= temp_arr.length)
					{
						if(parseInt(j)==0)
							temp=temp_arr[j];
	
						if(parseInt(temp_arr.length)==1)
							temp1=temp_arr[j];
						else
							temp1=temp_arr[k];
	
						if(temp1==null)
							temp1=temp;
	
						if(parseInt(temp) < parseInt(temp1))
							min_priority=temp;
						else
							min_priority=temp1;
	
						temp=min_priority;
						k++;
					}
				}
				min_priority_arr[i]=min_priority;
			}
	
			var temp_priority="";
			var temp1_priority="";
			var j=1;
			var key_name="";
			var key_name1="";
	
			for(var i=0;i<total_keys.length;i++)
			{
				key_name=total_keys[i];
				key_name1=total_keys[j];
	
				if(key_name1==null)
					key_name1=key_name;
	
				if(!(min_priority_arr[j]==null))
				{
					if(!(parseInt(min_priority_arr[j]) > parseInt(max_priority_arr[i])))
					{
						alert(getMessage("BL9835","BL")+" "+key_name+" "+getLabel("Common.and.label","Common")+" "+key_name1);
						return false;
					}
				}
				j++;			
			}
	
			for(var i=0;i<rtn_total_records;i++)
			{
				var rtn_ins_blng_grp1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
				if(rtn_ins_blng_grp1.value=="" || rtn_ins_blng_grp1.value==null)
				{
					rtn_ins_blng_grp1.value=="";
				}
				rtn_ins_blng_grp=rtn_ins_blng_grp+rtn_ins_blng_grp1.value+"|";
	
				var payer_desc= eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_desc"+i);
				
				var rtn_ins_cust_group_code1   = eval("parent.frames[1].frames[0].frames[1].document.forms[0].ins_cust_group_code"+i);
				var rtn_ins_cust_group_code_temp = rtn_ins_cust_group_code1.value;
				
				if(rtn_ins_cust_group_code_temp == null || rtn_ins_cust_group_code_temp == "")
				{
					alert(getMessage("BL6277","BL"));
					return false;
				}
	//				rtn_ins_cust_group_code_temp = " ";
	
				rtn_ins_cust_group_code = rtn_ins_cust_group_code + rtn_ins_cust_group_code_temp + "|";
	
				var rtn_cust_31		   = eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_3"+i);
				if(rtn_cust_31.value=="" || rtn_cust_31.value==null)
				{
	//				rtn_cust_31.value="";
	//				alert("Payer cannot be blank");
					alert(getMessage("BL9532","BL"));
					return false;
				}
	
				var temp_ins_cust_valid_from_date	= eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_valid_from_date"+i);
				ins_cust_valid_from_date = temp_ins_cust_valid_from_date.value;
	
				var temp_ins_cust_valid_to_date	= eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_valid_to_date"+i);
				ins_cust_valid_to_date = temp_ins_cust_valid_to_date.value;
	
				if(ins_cust_valid_from_date == " " || ins_cust_valid_from_date == null) ins_cust_valid_from_date="";
				if(ins_cust_valid_to_date == " " || ins_cust_valid_to_date == null) ins_cust_valid_to_date="";
	
				if(ins_cust_valid_from_date != "")
				{
					var ins_cust_valid_from_date_loc= ins_cust_valid_from_date;
	
					if(locale != 'en')
						ins_cust_valid_from_date_loc=convertDate(ins_cust_valid_from_date_loc,'DMY','en',locale);
		
					if(!isAfter(encounter_date_aft_trunc.value,ins_cust_valid_from_date_loc,'DMY',locale))
					{
						//Added by Rajesh V - If logic
						if(calling_module_id != 'MP'){
							alert(getMessage("BL8227","BL")+":"+payer_desc.value);
							return false;
						}
					}
				}
				if(ins_cust_valid_to_date != "")
				{
					var ins_cust_valid_to_date_loc=ins_cust_valid_to_date;
									
					if(locale != 'en')
						ins_cust_valid_to_date_loc=convertDate(ins_cust_valid_to_date_loc,'DMY','en',locale);
		
					if(!isBefore(encounter_date_aft_trunc.value,ins_cust_valid_to_date_loc,'DMY',locale))
					{
						alert(getMessage("BL8227","BL")+":"+payer_desc.value);
						return false;
					}
				}
				rtn_ins_cust_code=rtn_ins_cust_code+rtn_cust_31.value+"|";
	
				var rtn_priority1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].priority"+i);
				if(rtn_priority1.value=="" || rtn_priority1.value==null)
				{
	//				rtn_priority1.value="";
					alert(getMessage("BL9325","BL"));
					return false;
				}
				if(rtn_priority1.value==1)
				{
					rtn_blng_grp=rtn_ins_blng_grp1.value;
				}
				rtn_ins_cust_priority=rtn_ins_cust_priority+rtn_priority1.value+"|";
	
				var rtn_policy_type_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_code"+i);
				if(rtn_policy_type_code1.value=="" || rtn_policy_type_code1.value==null)
				{
	//				rtn_policy_type_code1.value="";
	//				alert("Policy Type Code cannot be blank");
					alert(getMessage("BL9103","BL"));
					return false;
				}
				rtn_ins_policy_type_code=rtn_ins_policy_type_code+rtn_policy_type_code1.value+"|";
	
	            //Added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check           
				var payerEligibilityParamSession1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payerEligibilityParam"+i);
				 if(payerEligibilityParamSession1!=undefined)
				 {
				   if(payerEligibilityParamSession1.value==null || payerEligibilityParamSession1.value=="") payerEligibilityParamSession1.value=" ";
				   rtn_payerEligibilityParamSession=rtn_payerEligibilityParamSession+payerEligibilityParamSession1.value+"|";
				 }
	
				var responseCode1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].responseCode"+i);
				if(responseCode1!=undefined)
				 {
				   if(responseCode1.value==null || responseCode1.value=="") responseCode1.value=" ";
	               rtn_responseCode=rtn_responseCode+responseCode1.value+"|";
				 }
	
				var responseCodeDesc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].responseCodeDesc"+i);
				if(responseCodeDesc1!=undefined)
				 {
					 if(responseCodeDesc1.value==null || responseCodeDesc1.value=="") responseCodeDesc1.value=" ";
	               rtn_responseCodeDesc=rtn_responseCodeDesc+responseCodeDesc1.value+"|";
				 }
	
				var statuDescription1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].statuDescription"+i);            
				if(statuDescription1!=undefined)
				 {
					 if(statuDescription1.value==null || statuDescription1.value=="") statuDescription1.value=" ";
	               rtn_statuDescription=rtn_statuDescription+statuDescription1.value+"|";
				 }
	
				var validityPeriod1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].validityPeriod"+i);
				if(validityPeriod1!=undefined)
				 {
					 if(validityPeriod1.value==null || validityPeriod1.value=="") validityPeriod1.value=" ";
	               rtn_validityPeriod=rtn_validityPeriod+validityPeriod1.value+"|";
				 }
	
				var validityPeriodDesc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].validityPeriodDesc"+i);            
				if(validityPeriodDesc1!=undefined)
				 {
					  if(validityPeriodDesc1.value==null || validityPeriodDesc1.value=="") validityPeriodDesc1.value=" ";
	               rtn_validityPeriodDesc=rtn_validityPeriodDesc+validityPeriodDesc1.value+"|";
				 }
	
				var eligibilityCode1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].eligibilityCode"+i);            
				if(eligibilityCode1!=undefined)
				 {
					 if(eligibilityCode1.value==null || eligibilityCode1.value=="") eligibilityCode1.value=" ";
	               rtn_eligibilityCode=rtn_eligibilityCode+eligibilityCode1.value+"|";
				 }
	
				var transactionId1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].transactionId"+i);            
				if(transactionId1!=undefined)
				 {
					 if(transactionId1.value==null || transactionId1.value=="") transactionId1.value=" ";
	               rtn_transactionId=rtn_transactionId+transactionId1.value+"|";
				 }
	
				var responseDateTime1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].responseDateTime"+i);            
				if(responseDateTime1!=undefined)
				 {
					 if(responseDateTime1.value==null || responseDateTime1.value=="") responseDateTime1.value=" ";
	               rtn_responseDateTime=rtn_responseDateTime+responseDateTime1.value+"|";
				 }
	
				//above code was added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check
	
				var policy_type_desc=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_desc"+i);
				var	rtn_policy_no1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_no"+i);
	      //NMC-JD-CRF-0054 Starts
				var policySiteSpec=document.getElementById('siteSpecPolicyNo').value;
				if(policySiteSpec!="Y"){
					if(rtn_policy_no1.value=="" || rtn_policy_no1.value==null)
					{
						rtn_policy_no1.value="";
						alert(getMessage("BL9104","BL"));
						return false;
					}
				}
	      //NMC-JD-CRF-0054 Ends
				if(rtn_policy_no1.value==""|| rtn_policy_no1.value==null) rtn_policy_no1.value = " ";  //V230828
				rtn_ins_policy_no=rtn_ins_policy_no+rtn_policy_no1.value+"|";
				
				//V220908
				var rtn_mcn_for_policy1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].mcn_for_policy"+i);
			//	alert("mcn value is:"+rtn_mcn_for_policy1.value+"bnbnb");
				if(rtn_mcn_for_policy1.value==""|| rtn_mcn_for_policy1.value==null) rtn_mcn_for_policy1.value = " ";
				rtn_mcn_for_policy=rtn_mcn_for_policy+rtn_mcn_for_policy1.value+"|";
				//V220908
				
				//V230315
				var rtn_reg_ref_id1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].reg_ref_id"+i);
				if(rtn_reg_ref_id1.value==""|| rtn_reg_ref_id1.value==null) rtn_reg_ref_id1.value = " ";
				rtn_reg_ref_id=rtn_reg_ref_id+rtn_reg_ref_id1.value+"|";
				//V230315
				
				//V230707
				var rtn_userId_for_priv1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].userId_for_priv"+i);
				if(rtn_userId_for_priv1.value==""|| rtn_userId_for_priv1.value==null) rtn_userId_for_priv1.value = " ";
				rtn_userId_for_priv=rtn_userId_for_priv+rtn_userId_for_priv1.value+"|";
				//V230707
				
				//V230707
				var rtn_reasonCode_for_priv1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].reasonCode_for_priv"+i);
				if(rtn_reasonCode_for_priv1.value==""|| rtn_reasonCode_for_priv1.value==null) rtn_reasonCode_for_priv1.value = " ";
				rtn_reasonCode_for_priv=rtn_reasonCode_for_priv+rtn_reasonCode_for_priv1.value+"|";
				//V230707
	
				var rtn_policy_start_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_start_date"+i);
				var rtn_ins_policy_start_date_temp=rtn_policy_start_date1.value;
				if(rtn_ins_policy_start_date_temp==null) rtn_ins_policy_start_date_temp="";
	
				var rtn_policy_exp_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_exp_date"+i);
				var rtn_ins_policy_expiry_date_temp=rtn_policy_exp_date1.value;
				if(rtn_ins_policy_expiry_date_temp==null) rtn_ins_policy_expiry_date_temp="";
	
				if(rtn_ins_policy_start_date_temp=="")
				{
	//				rtn_policy_start_date1.value="";
	//				alert("Policy Start Date cannot be blank");
					alert(getMessage("BL9324","BL"));
					return false;
				}
	
				if(rtn_ins_policy_expiry_date_temp=="")
				{
	//				rtn_policy_exp_date1.value="";
	//				alert("Policy End Date cannot be blank");
					alert(getMessage("BL9105","BL"));
					return false;
				}
	/*
				if(!chkDtLessEqualThanEncDateNew(rtn_policy_start_date1,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9880","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
					return false;
				}
	*/
				if(!chkPolicyStartDate(rtn_policy_start_date1,rtn_policy_exp_date1,encounter_date_aft_trunc,payer_desc.value,policy_type_desc.value))
				{
	//				alert(getMessage("BL9880","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
					return false;
				}
	
	/*
				if(!chkDtGreaterEqualThanEncDateNew(rtn_policy_exp_date1,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9881","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
					return false;
				}
	*/
				if(!chkPolicyExpiryDate(rtn_policy_start_date1,rtn_policy_exp_date1,encounter_date_aft_trunc,payer_desc.value,policy_type_desc.value))
				{
	//				alert(getMessage("BL9881","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
					return false;
				}
	
				if(rtn_ins_policy_start_date_temp!="")
				{
					rtn_ins_policy_start_date_temp=convertDate(rtn_ins_policy_start_date_temp,"DMY",locale,"en");
				}
				rtn_ins_policy_start_date=rtn_ins_policy_start_date+rtn_ins_policy_start_date_temp+"|";
			
	
				if(rtn_ins_policy_expiry_date_temp!="")
				{
					rtn_ins_policy_expiry_date_temp=convertDate(rtn_ins_policy_expiry_date_temp,'DMY',locale,"en");
				}
				rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+rtn_ins_policy_expiry_date_temp+"|";
				
				var rtn_ins_cred_auth_req_yn1 = eval("parent.frames[1].frames[0].frames[1].document.forms[0].cred_auth_req_yn"+i);
				cred_auth_req_yn = rtn_ins_cred_auth_req_yn1.value;
				rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+"|";
	
				var cred_auth_mand_capt_yn1 =eval("parent.frames[1].frames[0].frames[1].document.forms[0].cred_auth_mand_capt_yn"+i);
				cred_auth_mand_capt_yn = cred_auth_mand_capt_yn1.value;
				rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+cred_auth_mand_capt_yn+"|";
	
				var rtn_ins_dflt_auth_ref_as_pol_no_yn1 = eval("parent.frames[1].frames[0].frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn"+i);
				dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn1.value;
				rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+"|";
				
				if(cred_auth_req_yn =="Y")
				{
					var rtn_credit_auth_ref1 =eval("parent.frames[1].frames[0].frames[1].document.forms[0].credit_auth_ref"+i);				
	
					var rtn_credit_auth_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].credit_auth_date"+i);
					var rtn_ins_credit_auth_date_temp=rtn_credit_auth_date1.value;
					if(rtn_ins_credit_auth_date_temp==null) rtn_ins_credit_auth_date_temp="";
	
					if(cred_auth_mand_capt_yn == "Y")
					{
						if(rtn_credit_auth_ref1.value=="" || rtn_credit_auth_ref1.value==null)
						{
							alert(getMessage("BL8148","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}
	
						if(rtn_ins_credit_auth_date_temp=="")
						{
							alert(getMessage("BL9562","BL"));
							return false;
						}
	
	/*
						if(!chkDtLessEqualThanEncDateNew(rtn_credit_auth_date1,encounter_date_aft_trunc,"Y"))
						{
							alert(getMessage("BL9882","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}
	*/
						if(!chkCreditAuthDate(rtn_credit_auth_date1,payer_desc.value,policy_type_desc.value))
						{
	//						alert(getMessage("BL9882","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}	
	
						rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+rtn_credit_auth_ref1.value+"|";
	
						if(rtn_ins_credit_auth_date_temp!="")
						{
							rtn_ins_credit_auth_date_temp=convertDate(rtn_ins_credit_auth_date_temp,'DMY',locale,"en");
						}
						rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+rtn_ins_credit_auth_date_temp+"|";
					}
					else
					{
						if((rtn_credit_auth_ref1=="" && rtn_credit_auth_date1!="") || (rtn_credit_auth_ref1!="" && rtn_credit_auth_date1==""))
						{
							alert(getMessage("BL7427","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}
	
						if(rtn_credit_auth_ref1.value=="" || rtn_credit_auth_ref1.value==null)
						{
							rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+" "+"|";
						}
						else
						{
							rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+rtn_credit_auth_ref1.value+"|";						
						}
						
						if(rtn_ins_credit_auth_date_temp!="")
						{
							rtn_ins_credit_auth_date_temp=convertDate(rtn_ins_credit_auth_date_temp,'DMY',locale,"en");
							rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+rtn_ins_credit_auth_date_temp+"|";
						}
						else
						{
							rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+" "+"|";
						}
					}
				}
				else
				{
					rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+" "+"|";
					rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+" "+"|";
				}
				var restrict_check1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].restrict_check"+i);
				restrict_check=restrict_check1.value;
				rtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+"|";	
	
				var apprd_amt_restrict_check1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].apprd_amt_restrict_check"+i);
				apprd_amt_restrict_check=apprd_amt_restrict_check1.value;
				rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+"|";
	
				var apprd_days_restrict_check1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].apprd_days_restrict_check"+i);
				apprd_days_restrict_check=apprd_days_restrict_check1.value;
				rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+"|";
	
				if(restrict_check=="R")
				{
					if(apprd_amt_restrict_check == "R")
					{
						var rtn_credit_apprd_amt1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].credit_apprd_amt"+i);
						if(rtn_credit_apprd_amt1.value=="" || rtn_credit_apprd_amt1.value==null)
						{
							alert(getMessage("BL9564","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}
						rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+rtn_credit_apprd_amt1.value+"|";
					}
					else
					{
						rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+" "+"|";
					}
					if(apprd_days_restrict_check == "R")
					{
						var rtn_credit_apprd_days1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].credit_apprd_days"+i);
						if(rtn_credit_apprd_days1.value=="" || rtn_credit_apprd_days1.value==null)
						{
							alert(getMessage("BL9563","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
							return false;
						}
						rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+rtn_credit_apprd_days1.value+"|";
					}
					else
					{
						rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+" "+"|";
					}
				}
				else if(restrict_check=="U")
				{
					rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+" "+"|";
					rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+" "+"|";
				}
	
				var rtn_policy_eff_frm_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_eff_frm_date"+i);
				var rtn_ins_policy_eff_from_date_temp=rtn_policy_eff_frm_date1.value;
				if(rtn_ins_policy_eff_from_date_temp==null) rtn_ins_policy_eff_from_date_temp="";
	
				var rtn_policy_eff_to_date1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_eff_to_date"+i);
				var rtn_ins_policy_eff_to_date_temp=rtn_policy_eff_to_date1.value;
				if(rtn_ins_policy_eff_to_date_temp==null) rtn_ins_policy_eff_to_date_temp="";
	
				if(rtn_ins_policy_eff_from_date_temp=="" )
				{
					alert(getMessage("BL9565","BL"));
					return false;
				}
	
				if(rtn_ins_policy_eff_to_date_temp=="" )
				{
					rtn_ins_policy_eff_to_date_temp=" ";
				}
				if(!chkPolicyEffFromDate(rtn_policy_eff_frm_date1,rtn_policy_eff_to_date1,rtn_policy_start_date1,rtn_policy_exp_date1,encounter_date_aft_trunc,payer_desc.value,policy_type_desc.value))
				{
					return false;
				}
	
				if(rtn_ins_policy_eff_from_date_temp!="")
				{
					rtn_ins_policy_eff_from_date_temp=convertDate(rtn_ins_policy_eff_from_date_temp,'DMY',locale,"en");
				}
				rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+rtn_ins_policy_eff_from_date_temp+"|";
				if(!chkPolicyEffToDate(rtn_policy_eff_to_date1,rtn_policy_eff_frm_date1,rtn_policy_exp_date1,encounter_date_aft_trunc,payer_desc.value,policy_type_desc.value))
				{
					return false;
				}
	
				if(rtn_ins_policy_eff_to_date_temp!="" && rtn_ins_policy_eff_to_date_temp!=" ")
				{
					rtn_ins_policy_eff_to_date_temp=convertDate(rtn_ins_policy_eff_to_date_temp,'DMY',locale,"en");
				}
				rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+rtn_ins_policy_eff_to_date_temp+"|";
	
				var rtn_adj_rule_ind1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].adj_rule_ind"+i);
				var adj_rule_ind1=rtn_adj_rule_ind1.value;
				
				if(adj_rule_ind1==null || adj_rule_ind1=="")
				{
					adj_rule_ind1=" ";
				}
				rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+adj_rule_ind1+"|";
	
	
				var rtn_adj_perc_amt_ind1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].adj_perc_amt_ind"+i);
				var adj_perc_amt_ind1=rtn_adj_perc_amt_ind1.value;
	
				if(adj_perc_amt_ind1==null || adj_perc_amt_ind1=="")
				{
					adj_perc_amt_ind1=" ";
				}
				rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+adj_perc_amt_ind1+"|";
				
				var rtn_adj_perc_amt_value1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].adj_perc_amt_value"+i);
				var adj_perc_amt_value1=rtn_adj_perc_amt_value1.value;
				if(adj_perc_amt_value1==null || adj_perc_amt_value1=="")
				{
					adj_perc_amt_value1=" ";
				}
				rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+adj_perc_amt_value1+"|";
				
				var rtn_pmnt_diff_adj_int1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].pmnt_diff_adj_int"+i);
				var pmnt_diff_adj_int1=rtn_pmnt_diff_adj_int1.value;
				if(pmnt_diff_adj_int1==null || pmnt_diff_adj_int1=="")
				{
					pmnt_diff_adj_int1=" ";
				}
				rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+pmnt_diff_adj_int1+"|";
	
				var rtn_drg_pmnt_diff_adj_int1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].drg_pmnt_diff_adj_int"+i);
				var drg_pmnt_diff_adj_int1=rtn_drg_pmnt_diff_adj_int1.value;
				if(drg_pmnt_diff_adj_int1==null || drg_pmnt_diff_adj_int1=="")
				{
					drg_pmnt_diff_adj_int1=" ";
				}
				rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+drg_pmnt_diff_adj_int1+"|";
	
				var rtn_spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+i);
				var spl_srv_pmnt_diff_adj_int1=rtn_spl_srv_pmnt_diff_adj_int1.value;
				if(spl_srv_pmnt_diff_adj_int1==null || spl_srv_pmnt_diff_adj_int1=="")
				{
					spl_srv_pmnt_diff_adj_int1=" ";
				}
				rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+spl_srv_pmnt_diff_adj_int1+"|";
	
				var rtn_ins_valid_payer_YN1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].valid_payer_YN"+i);
				if(rtn_ins_valid_payer_YN1.value=="N")
				{	
					var ins_payer_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_desc"+i);
					alert(getMessage("BL9588","BL")+":"+ins_payer_desc1.value);
					return false;
				}
				else if(rtn_ins_valid_payer_YN1.value=="Y")
				{
					var payer_suspended_YN1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_suspended_YN"+i);
					if(payer_suspended_YN1.value=="S")
					{
						var ins_payer_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_desc"+i);
						alert(getMessage("BL7435","BL")+":"+ins_payer_desc1.value);
						return false;
					}
				}
	
				var rtn_ins_valid_policy_type_code_YN1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].valid_policy_type_code_YN"+i);
				if(rtn_ins_valid_policy_type_code_YN1.value=="N")
				{
					var policy_type_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_desc"+i);
					var ins_payer_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_desc"+i);
					alert(getMessage("BL9589","BL")+":"+ins_payer_desc1.value+"/"+policy_type_desc1.value);
					return false;
				}
				else if(rtn_ins_valid_policy_type_code_YN1.value=="Y")
				{
					var policy_suspended_YN1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_suspended_YN"+i);
					if(policy_suspended_YN1.value=="S")
					{
						var policy_type_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_desc"+i);
						alert(getMessage("BL7436","BL")+":"+policy_type_desc1.value);
						return false;
					}
				}
	
				var temp_referral_source_capture_YN=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_capture_YN"+i);
				if(temp_referral_source_capture_YN.value == "Y")
				{
					var temp_billing_group_desc=eval("parent.frames[1].frames[0].frames[1].document.forms[0].billing_group_desc"+i);
	
					var rtn_ins_ref_src_main_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code"+i);
					var ins_ref_src_main_code1=rtn_ins_ref_src_main_code1.value;
	
					var rtn_ins_ref_src_main_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc"+i);
					var ins_ref_src_main_desc1=rtn_ins_ref_src_main_desc1.value;
	
					var temp_referral_source_main_mand_YN=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_mand_YN"+i);
					
					if(ins_ref_src_main_code1==null || ins_ref_src_main_code1=="" || ins_ref_src_main_desc1==null || ins_ref_src_main_desc1=="") 
					{
						if(temp_referral_source_main_mand_YN.value == "Y")
						{
							alert(getMessage("BL9816","BL")+" "+getLabel("Common.for.label","common")+" "+temp_billing_group_desc.value);
							return false;
						}
						else
						{
							ins_ref_src_main_code1=" ";
							ins_ref_src_main_desc1=" ";
						}
					}
	
					rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+ins_ref_src_main_code1+"|";
					rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+ins_ref_src_main_desc1+"|";
	
					var rtn_ins_ref_src_sub_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code"+i);
					var ins_ref_src_sub_code1=rtn_ins_ref_src_sub_code1.value;
	
					var rtn_ins_ref_src_sub_desc1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc"+i);
					var ins_ref_src_sub_desc1=rtn_ins_ref_src_sub_desc1.value;
	
					
					var temp_referral_source_sub_mand_YN=eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_mand_YN"+i);
	
					if(ins_ref_src_sub_code1==null || ins_ref_src_sub_code1=="" || ins_ref_src_sub_desc1==null || ins_ref_src_sub_desc1=="")
					{
						if(temp_referral_source_sub_mand_YN.value == "Y")
						{
							alert(getMessage("BL9817","BL")+" "+getLabel("Common.for.label","common")+" "+temp_billing_group_desc.value);
							return false;
						}
						else
						{
							ins_ref_src_sub_code1=" ";
							ins_ref_src_sub_desc1=" ";
						}
					}
					rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+ins_ref_src_sub_code1+"|";
					rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+ins_ref_src_sub_desc1+"|";
				}
				else
				{				
					rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+" "+"|";
					rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+" "+"|";
					rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+" "+"|";
					rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+" "+"|";
				}
	
				if(calling_module_id != 'MP')
				{
					var temp_pol_validity_chk_date=eval("parent.frames[1].frames[0].frames[1].document.forms[0].pol_validity_chk_date"+i);
	
					if(rtn_ins_policy_eff_from_date_temp != "" && apprd_days_restrict_check=='R')
					{
						if(rtn_credit_apprd_days1 != "")
						//if(rtn_credit_apprd_days1.value != "")
						{
							if(!isAfter(temp_pol_validity_chk_date.value,encounter_date_aft_trunc.value,'DMY',locale))
							{
								alert(getMessage("BL6203","BL")+":"+payer_desc.value+"/"+policy_type_desc.value);
								return false;
							}
						}
					}
				}
			}
			
			/* Added V190527-Aravindh/NMC-JD-CRF-0010/Starts */
			var siteSpecPolApprv = eval("parent.frames[1].frames[0].frames[1].document.forms[0].siteSpecPolApprv");
			if(siteSpecPolApprv.value == "true") {
				var nonApprvdPlcyErrMsg = "";
				for(var i=0;i<rtn_total_records;i++)
				{
					var validateApprovedPolicy = false;
					var payer_code = eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_3"+i);
					var policy_type_code=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_code"+i);
					var payer_grp_code=eval("parent.frames[1].frames[0].frames[1].document.forms[0].ins_cust_group_code"+i);
					var policy_type_desc=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_desc"+i);
					var facility_id=eval("parent.frames[1].frames[0].frames[1].document.forms[0].facility_id");
					//alert(ins_blng_grp_code.value+", "+payer_code.value+", "+policy_type_code.value+", "+ facility_id.value);
					validateApprovedPolicy = validateApprovedPolicyYN(payer_grp_code, payer_code, policy_type_code, facility_id.value);
					if(validateApprovedPolicy != true) {
						if(nonApprvdPlcyErrMsg != "") {
							nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + ", ";
						}
						nonApprvdPlcyErrMsg = nonApprvdPlcyErrMsg + policy_type_desc.value;
					}
				}
				
				if(nonApprvdPlcyErrMsg != "") {
					alert(getMessage("BL0833","BL").replace("$","'"+nonApprvdPlcyErrMsg+"'."));
					return false;
				}
			}
			/* Added V190527-Aravindh/NMC-JD-CRF-0010/Ends */
		}	
	
		//Case:4.1
		/*************** 
				The following code is added on 11/aug/2002
		Single Line		chk_credit_doc_yn2 = parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_yn.value;	
		****************/
	
		if(mode=="4")
		{
			if(rtn_non_ins_blng_grp=="")
			{
					alert(getMessage("BL9106",'BL'));
					return false;
			}
			if (rtn_non_ins_blng_grp != "" && noninsblnggrpappyn == 'N' )
			{		
					alert(getMessage("BL1527",'BL'));		
					return(false);	
			}
			if (rtn_non_ins_blng_grp != "" && noninsblnggrpstatus == 'S' )
			{
					alert(getMessage("BL1530",'BL'));		
					return(false);	
			}
			if (rtn_non_ins_blng_grp != "" && noninsblnggrpcatgappyn == 'N' )
			{
					alert(getMessage("BL1528",'BL'));		
					return(false);	
			}
	
			var non_ins_ref_src_capture_YN= parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_capture_YN.value;
			var non_ins_ref_src_main_mand_YN = parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_main_mand_YN.value;
			var non_ins_ref_src_sub_mand_YN = parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_ref_src_sub_mand_YN.value;
	
			if(non_ins_ref_src_capture_YN=="Y")
			{
				var rtn_non_ins_blng_grp_desc = parent.frames[1].frames[0].frames[2].document.forms[0].non_ins_billing_group_desc.value;
	
				if(non_ins_ref_src_main_mand_YN == "Y")
				{
					if((rtn_non_ins_ref_src_main_code=="" || rtn_non_ins_ref_src_main_code==null) || (rtn_non_ins_ref_src_main_desc=="" || rtn_ref_src_main_desc==null))
					{
						alert(getMessage("BL9816","BL")+" "+getLabel("Common.for.label","common")+" "+rtn_non_ins_blng_grp_desc);
						return false;
					}
				}
	
				if(non_ins_ref_src_sub_mand_YN == "Y")
				{
					if((rtn_non_ins_ref_src_sub_code=="" || rtn_non_ins_ref_src_sub_code==null) || (rtn_non_ins_ref_src_sub_desc=="" || rtn_non_ins_ref_src_sub_desc==null))
					{
						alert(getMessage("BL9817","BL")+" "+getLabel("Common.for.label","common")+" "+rtn_non_ins_blng_grp_desc);
						return false;
					}
				}
			}
			else
			{
				rtn_non_ins_ref_src_main_code="";
				rtn_non_ins_ref_src_main_desc="";
				rtn_non_ins_ref_src_sub_code="";
				rtn_non_ins_ref_src_sub_desc="";
			}
	
			var mode2 = parent.frames[1].frames[1].frames[0].document.forms[0].Case_1.value;
	
			chk_credit_doc_yn2 = parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_reqd_yn2.value;
	
			rtn_non_ins_credit_doc_reqd_yn = chk_credit_doc_yn2;
			if (chk_credit_doc_yn2 == "Y")
			{
				rtn_non_ins_credit_doc_ref	= parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3.value;
				if(rtn_non_ins_credit_doc_ref==null) rtn_non_ins_credit_doc_ref="";
	//			if(!CheckChars_local(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3))
				if(!CheckCharsAllLang_local(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3))
				{
					alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
					parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3.select();
					return false;
				}		
	
				rtn_non_ins_credit_doc_start_date	= parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_st_date3.value;
				if(rtn_non_ins_credit_doc_start_date==null) rtn_non_ins_credit_doc_start_date="";
				if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_st_date3,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9883","BL"));
					return false;
				}
	
				if(rtn_non_ins_credit_doc_start_date!="")
				{
					rtn_non_ins_credit_doc_start_date=convertDate(rtn_non_ins_credit_doc_start_date,'DMY',locale,"en");
				}
				
				rtn_non_ins_credit_doc_end_date	= parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_date3.value;
				if(rtn_non_ins_credit_doc_end_date==null) rtn_non_ins_credit_doc_end_date="";
				if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_date3,encounter_date_aft_trunc,"Y"))
				{
					alert(getMessage("BL9884","BL"));
					return false;
				}
	
				if(rtn_non_ins_credit_doc_end_date!="")
				{
					rtn_non_ins_credit_doc_end_date=convertDate(rtn_non_ins_credit_doc_end_date,'DMY',locale,"en");
				}
			}
		}
			
		if((mode=="4")&&(mode2=="2"))
		{
			rtn_non_ins_slmt_type_code = parent.frames[1].frames[1].frames[0].document.forms[0].cash_set_type2.value;
			if(rtn_non_ins_slmt_type_code==null) rtn_non_ins_slmt_type_code="";
			chkCashSet2=rtn_non_ins_slmt_type_code.substring(2);
			rtn_non_ins_slmt_type_code=rtn_non_ins_slmt_type_code.substring(0,2);
			
		}
		
		if(mode=="4")
		{
			if(checkForValidFrames8() && (chkCashSet2 != "Y"))
			{
				rtn_non_ins_inst_ref = parent.frames[1].frames[1].frames[1].document.forms[0].cash_insmt_ref2.value;
				if(rtn_non_ins_inst_ref==null) rtn_non_ins_inst_ref="";
				rtn_non_ins_inst_date  = parent.frames[1].frames[1].frames[1].document.forms[0].cash_insmt_date2.value;
				if(rtn_non_ins_inst_date==null) rtn_non_ins_inst_date="";
				if(rtn_non_ins_inst_date!="")
				{
					rtn_non_ins_inst_date=convertDate(rtn_non_ins_inst_date,'DMY',locale,"en");
				}
				rtn_non_ins_inst_remarks = parent.frames[1].frames[1].frames[1].document.forms[0].cash_insmt_rmks2.value;
				if(rtn_non_ins_inst_remarks==null) rtn_non_ins_inst_remarks="";
				if(rtn_non_ins_credit_doc_start_date!="")
				{
					rtn_non_ins_credit_doc_start_date=convertDate(rtn_non_ins_credit_doc_start_date,'DMY',locale,"en");
				}
			}
		}	
		
		if((mode=="4")&&(mode2=="1"))
		{
			rtn_non_ins_cust_group_code = parent.frames[1].frames[1].frames[0].document.forms[0].non_ins_cust_group_code.value;
			if(rtn_non_ins_cust_group_code == null) rtn_non_ins_cust_group_code="";
	
			rtn_non_ins_cust_code		= parent.frames[1].frames[1].frames[0].document.forms[0].cust_4.value;
			if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";
	
			non_ins_cust_valid_from_date		= parent.frames[1].frames[1].frames[0].document.forms[0].non_ins_cust_valid_from_date.value;
			non_ins_cust_valid_to_date			= parent.frames[1].frames[1].frames[0].document.forms[0].non_ins_cust_valid_to_date.value;
	
			if(non_ins_cust_valid_from_date == " " || non_ins_cust_valid_from_date == null) non_ins_cust_valid_from_date="";
			if(non_ins_cust_valid_to_date == " " || non_ins_cust_valid_to_date == null) non_ins_cust_valid_to_date="";
	
			if(non_ins_cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc=non_ins_cust_valid_from_date;
	
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);
	
				if(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8228","BL"));
					return false;
				}
			}
			if(non_ins_cust_valid_to_date != "")
			{
				var non_ins_cust_valid_to_date_loc= non_ins_cust_valid_to_date;
	
				if(locale != 'en')
					non_ins_cust_valid_to_date_loc=convertDate(non_ins_cust_valid_to_date_loc,'DMY','en',locale);
	
				if(!isBefore(encounter_date_aft_trunc.value,non_ins_cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8228","BL"));
					return false;
				}
			}
	
			rtn_non_ins_credit_doc_ref	= parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3.value;
			if(rtn_non_ins_credit_doc_ref==null) rtn_non_ins_credit_doc_ref="";
	//		if(!CheckChars_local(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3))
			if(!CheckCharsAllLang_local(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3))
			{
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_ref3.select();
				return false;
			}
			
			rtn_non_ins_credit_doc_start_date = parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_st_date3.value;
			if(rtn_non_ins_credit_doc_start_date==null) rtn_non_ins_credit_doc_start_date="";
			if(!chkDtLessEqualThanEncDateNew(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_st_date3,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9883","BL"));
				return false;
			}
			if(rtn_non_ins_credit_doc_start_date!="")
			{
				rtn_non_ins_credit_doc_start_date=convertDate(rtn_non_ins_credit_doc_start_date,'DMY',locale,"en");
			}
	
			rtn_non_ins_credit_doc_end_date	= parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_date3.value;
			if(rtn_non_ins_credit_doc_end_date==null) rtn_non_ins_credit_doc_end_date="";
	
			if(!chkDtGreaterEqualThanEncDateNew(parent.frames[1].frames[1].frames[0].document.forms[0].credit_doc_date3,encounter_date_aft_trunc,"Y"))
			{
				alert(getMessage("BL9884","BL"));
				return false;
			}
	
			if(rtn_non_ins_credit_doc_end_date!="")
			{
				rtn_non_ins_credit_doc_end_date=convertDate(rtn_non_ins_credit_doc_end_date,'DMY',locale,"en");
			}		
		}
	
		if((rtn_blng_class == "") && (HideChk=="SHOW"))
		{
			
		}
		if(rtn_blng_grp=="")
		{
			alert(getMessage("BL9301",'BL'));
			return false;
		}
		if(mode=="1")
		{
			if(rtn_slmt_type_code=="")
			{
				alert(getMessage("BL9521",'BL'));
				return false;
			}		
			
			if(chk_credit_doc_yn1 =="Y")
			{
				if(rtn_credit_doc_ref=="")
				{
					alert(getMessage("BL9302",'BL'));
					return false;
				}
				if(rtn_credit_doc_start_date=="")
				{
					alert(getMessage("BL1531",'BL'));
					return false;
				}
				if(rtn_credit_doc_end_date=="")
				{
					alert(getMessage("BL1532",'BL'));
					return false;
				}
			}
		}
	
		if(mode=="2")
		{
			if(rtn_credit_cust_group_code == "")
			{
				alert(getMessage("BL6278",'BL'));
				return false;
			}
			if(rtn_credit_cust_code=="")
			{
				alert(getMessage("BL9102",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].cust_1.focus();
				return false;
			}
			if(rtn_credit_doc_ref=="")
			{
				alert(getMessage("BL9302",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.focus();
				return false;
			}
			if(rtn_credit_doc_start_date=="")
			{
				alert(getMessage("BL1531",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.focus();
				return false;
			}
			if(rtn_credit_doc_end_date=="")
			{
				alert(getMessage("BL1532",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_date1.focus();
				return false;
			}
		}
		else if(mode=="3")
		{
			if(rtn_sponsor_cust_group_code == "")
			{
				alert(getMessage("BL6278",'BL'));
				return false;
			}
	
			if(rtn_sponsor_cust_code=="")
			{
				alert(getMessage("BL9102",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].cust2but.focus();
				return false;
			}
			if(rtn_sponsor_credit_doc_ref=="")
			{
				alert(getMessage("BL9302",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_ref2.focus();
				return false;
			}
			if(rtn_sponsor_credit_doc_start_date=="")
			{
				alert(getMessage("BL1531",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.focus();
				return false;
			}
			if(rtn_sponsor_credit_doc_end_date=="")
			{
				alert(getMessage("BL1532",'BL'));
	//			parent.frames[1].frames[0].document.forms[0].credit_doc_date2.focus();
				return false;
			}
		}
		else if((mode=="4")&&(mode2=="1"))
		{
			if(rtn_non_ins_cust_group_code == "")
			{
				alert(getMessage("BL6278",'BL'));
				return false;
			}
	
			if(rtn_non_ins_cust_code=="")
			{
				alert(getMessage("BL9102",'BL'));
				return false;
			}
			if(rtn_non_ins_credit_doc_ref=="")
			{
				alert(getMessage("BL9302",'BL'));
				return false;
			}
			if(rtn_non_ins_credit_doc_start_date=="")	
			{
				alert(getMessage("BL1531",'BL'));
				return false;
			}
			if(rtn_non_ins_credit_doc_end_date=="")	
			{
				alert(getMessage("BL1532",'BL'));
				return false;
			}
		}
		else if((mode=="4")&&(mode2=="2"))
		{
			if(rtn_non_ins_slmt_type_code=="")
			{
				alert(getMessage("BL9107",'BL'));
				return false;
			}
			if(chkCashSet2 !="Y")
			{
				if(checkForValidFrames8())
				{
					if(rtn_non_ins_inst_ref=="")
					{
						alert(getMessage("BL9527",'BL'));
						return false;
					}
					if(rtn_non_ins_inst_date=="")
					{
						alert(getMessage("BL9528",'BL'));
						return false;
					}
				}
			}
			if (chk_credit_doc_yn2=="Y")
			{
				if(rtn_non_ins_credit_doc_ref=="")
				{
					alert(getMessage("BL9302",'BL'));
					return false;
				}
				if(rtn_non_ins_credit_doc_start_date=="")	
				{
					alert(getMessage("BL1531",'BL'));
					return false;
				}
				if(rtn_non_ins_credit_doc_end_date=="")	
				{
					alert(getMessage("BL1532",'BL'));
					return false;
				}
			}
		}
				
		if(rtn_blng_grp=="")rtn_blng_grp="";
		if(rtn_blng_class=="")rtn_blng_class="";
		if(rtn_emp_code=="")rtn_emp_code="";
		if(rtn_slmt_type_code=="")rtn_slmt_type_code="";
		if(rtn_inst_ref=="")rtn_inst_ref="";
		if(rtn_inst_date=="")rtn_inst_date="";
		if(rtn_inst_remarks=="")rtn_inst_remarks="";
		if(rtn_credit_cust_group_code=="")rtn_credit_cust_group_code="";
		if(rtn_credit_cust_code=="")rtn_credit_cust_code="";
		if(rtn_credit_doc_ref=="")rtn_credit_doc_ref="";
		if(rtn_credit_doc_end_date=="")rtn_credit_doc_end_date="";
		if(rtn_credit_doc_start_date=="")rtn_credit_doc_start_date="";
		if(rtn_sponsor_cust_group_code=="")rtn_sponsor_cust_group_code="";
		if(rtn_sponsor_cust_code=="")rtn_sponsor_cust_code="";
		if(rtn_sponsor_credit_doc_ref=="")rtn_sponsor_credit_doc_ref="";
		if(rtn_sponsor_credit_doc_end_date=="")rtn_sponsor_credit_doc_end_date="";
		if(rtn_sponsor_credit_doc_start_date=="")rtn_sponsor_credit_doc_start_date="";
	//	if(rtn_ins_cust_code=="")rtn_ins_cust_code="";
	//	if(rtn_poly_typ=="")rtn_poly_typ="";
	//	if(rtn_poly_no=="")rtn_poly_no="";
	//	if(rtn_poexp_dt=="")rtn_poexp_dt="";
		if(rtn_non_ins_blng_grp=="")rtn_non_ins_blng_grp="";
		if(rtn_non_ins_slmt_type_code=="")rtn_non_ins_slmt_type_code="";
		if(rtn_non_ins_inst_ref=="")rtn_non_ins_inst_ref="";
		if(rtn_non_ins_inst_date=="")rtn_non_ins_inst_date="";
		if(rtn_non_ins_inst_remarks=="")rtn_non_ins_inst_remarks="";
		if(rtn_non_ins_cust_group_code=="")rtn_non_ins_cust_group_code="";
		if(rtn_non_ins_cust_code=="")rtn_non_ins_cust_code="";
		if(rtn_non_ins_credit_doc_ref=="")rtn_non_ins_credit_doc_ref="";
		if(rtn_non_ins_credit_doc_end_date=="")rtn_non_ins_credit_doc_end_date="";
		if(rtn_non_ins_credit_doc_start_date=="")rtn_non_ins_credit_doc_start_date="";
	
		if(rtn_upd_patient_fin_dtls_yn=="") rtn_upd_patient_fin_dtls_yn="C";
	
		// Commented as Procedure is not corrected
		var slmt_type_code = "";
		var blng_grp = "";
		var cust_group_code ="";
		var cust_code ="";
		if(rtn_upd_patient_fin_dtls_yn == "Y")
		{
			chng_class_for_inv_pyrs_on_rfrsh();
			slmt_type_code=rtn_slmt_type_code;
			blng_grp=rtn_blng_grp;
			
			if(rtn_slmt_ind=="R")
			{
				cust_group_code=rtn_credit_cust_group_code;
				cust_code=rtn_credit_cust_code;
			}	
			else if(rtn_slmt_ind=="X" && rtn_non_ins_blng_grp=="")
			{
				cust_group_code=rtn_sponsor_cust_group_code;
				cust_code=rtn_sponsor_cust_code;
			}
			else if(rtn_slmt_ind=="X" && rtn_non_ins_blng_grp!="")
			{
				blng_grp=rtn_ins_blng_grp;
				cust_group_code=rtn_ins_cust_group_code;
				cust_code=rtn_ins_cust_code;
				slmt_type_code=rtn_non_ins_slmt_type_code;
			}
		}
		
		//Added by Rajesh V for CRF - 155
		var payerGrpBySetup = parent.frames[0].document.forms[0].payerGrpBySetup.value;
		if(payerGrpBySetup == 'Y'){
			var chkBlngClass = rtn_ins_blng_grp;
			var chkCustGrp = rtn_ins_cust_group_code;
			var chkPatClass = parent.frames[0].document.forms[0].calling_module_id.value;
			if(chkPatClass == "MP" || chkPatClass == ""){
				chkPatClass="XT";
			}
			else if(chkPatClass == "EM" || chkPatClass == "AE"){ 
				chkPatClass="EM";
			}
			else if(chkPatClass == "OP"){
				chkPatClass="OP";
			}
			else if(chkPatClass == "IP"){
				chkPatClass="IP";
			}
			else if(chkPatClass == "DC"){
				chkPatClass="DC";
			}
			
			if(chkBlngClass.length>0 && chkCustGrp.length>0){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=prevEncounterCheck&blngClass="+chkBlngClass+"&custGrp="+chkCustGrp+"&patClass="+chkPatClass;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);	
				if(responseText == 'Y'){
					alert('Customer Group is not valid for the Selected Billing Group');
					return false;
				}
			}
		}
		//Added by Rajesh V for CRF - 155	
		
		/* The below Function is added to Authenticate User to check his permissions to add listed Payers - Starts karthik*/
	
		//if(parent.frames[1].frames[0].length>0){	Commented and Added Below Conditions for IN49903 - Rajesh V
		if(parent.MainFrame2.InsuranceFrame != undefined ){
		if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
		var rtn_total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;
		if(rtn_total_records==null) rtn_total_records="";
		var cust ="";
		var policy_type_code= "";
		var cust_group_code="";
		var blng_grp ="";
	
		var cust1 ;
		var policy_type_code1;
		var cust_group_code1;
		var blng_grp1;
	
		for(var i=0;i<rtn_total_records;i++)
		{
			cust_group_code1   = eval("parent.frames[1].frames[0].frames[1].document.forms[0].ins_cust_group_code"+i);
			cust_group_code = cust_group_code + cust_group_code1.value +"|";
			cust1 = eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_3"+i);			
			cust = cust + cust1.value +"|";
	
			policy_type_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].policy_type_code"+i);
			policy_type_code = policy_type_code + policy_type_code1.value +"|";
		}
	
		var rtn_blng_class1 =  parent.frames[0].document.forms[0].billing_class.value;
		var rtn_slmt_ind = parent.frames[0].document.forms[0].setlmt_ind.value;
		var chkPatClass = parent.frames[0].document.forms[0].calling_module_id.value;
		var successfulUserAuthentication=document.PatFinMainForm.successfulUserAuthentication.value;
			
		if(rtn_slmt_ind=='X' && successfulUserAuthentication=='false'){		
			if(validateAllPayers(cust_group_code,cust,policy_type_code,chkPatClass)==false){
				alert("User dont have Permission to add listed Payer");
				var dialogHeight= "14" ;
				var dialogWidth	= "22" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;			
				
				var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp",arguments,features);
	
				if(retVal != undefined && retVal.length>0 && retVal[0]=="Y"){
					var successfulUser=retVal[3];
					if(validateAllPayersAuth(cust_group_code,cust,policy_type_code,chkPatClass,successfulUser)==false){
						alert("User dont have Permission to add listed Payer");
						return false;
					}else{
						document.PatFinMainForm.successfulUserAuthentication.value='true';
					}
				}
				else{
					alert("User dont have Permission to add listed Payer");
					return false;
				}	
						}
					}
			}
		}
	 /*The below Function is added to Authenticate User to check his permissions to add listed Payers - Ends */
		
		//Added by Rajesh V for CRF - 140
		var insCustGrp = '';
		var insCust = '';
		var priorityOneParam = '';
		if(payerGrpBySetup == 'Y'){
			if(parent.MainFrame2.InsuranceFrame != undefined){
				if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
					var insBodyFrm = parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain;
					
					if(insBodyFrm.name == 'add_modify_pat_fin_det_insmain'){
						var totalRecord = insBodyFrm.total_records.value;
						if(totalRecord>0){
							for(var indx=0;indx<totalRecord;indx++){
								if(eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.priority'+indx).value==1){
									insCustGrp = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_code'+indx).value;
									insCust = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.cust_3'+indx).value;
									break;
								}						
							}
						}
					}
				}
			}
	
			if(insCustGrp.length>0){
				priorityOneParam = '&insCustGrp='+insCustGrp+'&insCust='+insCust;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=priorityOneCheck"+priorityOneParam;
				//alert(param)
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);	
				if(responseText == 'Y'){
					alert('Priority one Payer details should be used for Package subscription');
					return false;
				}
			}		
		}
		
		//Added V181105-Subha/KDAH-SCF-0425/Starts
		if(state_validated == 'N') {
			if(site_specific == true || site_specific == "true") {//Modified V180528-Aravindh/KDAH-SCF-0425/From site_specific != "false"
				if(calling_module_id == 'AE' || calling_module_id == "DC" || calling_module_id == 'IP' || calling_module_id == 'OP') {
					if(cur_blng_grp != ext_blng_grp) {
						var confirm_yn = confirm(getMessage("BL0750","BL"));
						if(!confirm_yn) {
							return false;
						}
					}
				} else if(calling_module_id == 'MP') {
					if(ext_blng_grp != "" && ext_blng_grp != undefined && ext_blng_grp != null) {
						if(cur_blng_grp != ext_blng_grp) {
							var confirm_yn = confirm(getMessage("BL0750","BL"));
							if(!confirm_yn) {
								return false;
							}
						}
					}
				}
			}
		}
		//Added V181105-Subha/KDAH-SCF-0425/Ends
		
		//alert(insCustGrp + ','+ insCust +','+insCustGrpDesc+','+insCustDesc);
		//Added by Rajesh V for CRF - 140
		try
		{
			
			if (blInterface == null)
			{
				blInterface = "N";
			}
			
			if(calling_module_id == 'MP' && charge_for_pat_regn_yn=="Y")
			{
				try
				{
					parent.ValidFrame.document.forms[0].billing_group.value= parent.frames[0].document.forms[0].billing_group.value;
					parent.ValidFrame.document.forms[0].clinic_code.value= parent.frames[0].document.forms[0].clinic_code.value;
					parent.ValidFrame.document.forms[0].visit_type_code.value=  parent.frames[0].document.forms[0].visit_type_code.value;
					parent.ValidFrame.document.forms[0].patient_id.value = parent.frames[0].document.forms[0].patient_id.value;
					parent.ValidFrame.document.forms[0].episode_type.value = parent.frames[0].document.forms[0].episode_type.value;
					parent.ValidFrame.document.forms[0].facility_id.value = parent.frames[0].document.forms[0].facility_id.value;
					parent.ValidFrame.document.forms[0].calling_module_id.value = parent.frames[0].document.forms[0].calling_module_id.value;
					parent.ValidFrame.document.forms[0].calling_function_id.value = parent.frames[0].document.forms[0].function_id.value;			
					parent.ValidFrame.document.forms[0].logged_user_id.value = parent.frames[0].document.forms[0].logged_user_id.value;
					parent.ValidFrame.document.forms[0].practitioner_id.value = parent.frames[0].document.forms[0].practitioner_id.value;
					parent.ValidFrame.document.forms[0].practitioner_type_ind.value = parent.frames[0].document.forms[0].practitioner_type_ind.value;
					parent.ValidFrame.document.forms[0].disaster_regn_YN.value = parent.frames[0].document.forms[0].disaster_regn_YN.value;
	
					if(mode=="2")
					{
						parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_credit_cust_group_code;
						parent.ValidFrame.document.forms[0].cust_code.value = rtn_credit_cust_code;
					}
					else if(mode=="3")
					{
						parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_sponsor_cust_group_code;
						parent.ValidFrame.document.forms[0].cust_code.value = rtn_sponsor_cust_code;
					}
					else if(mode=="4")
					{
						parent.ValidFrame.document.forms[0].billing_group.value=rtn_ins_blng_grp;
						parent.ValidFrame.document.forms[0].cust_group_code.value=rtn_ins_cust_group_code;
						parent.ValidFrame.document.forms[0].cust_code.value=rtn_ins_cust_code;
						parent.ValidFrame.document.forms[0].policy_priority.value=rtn_ins_cust_priority;
						parent.ValidFrame.document.forms[0].policy_type_code.value=rtn_ins_policy_type_code;
						parent.ValidFrame.document.forms[0].policy_no.value=rtn_ins_policy_no;
						parent.ValidFrame.document.forms[0].policy_start_date.value=rtn_ins_policy_start_date;
						parent.ValidFrame.document.forms[0].policy_expiry_date.value=rtn_ins_policy_expiry_date;
						parent.ValidFrame.document.forms[0].credit_auth_ref.value=rtn_ins_credit_auth_ref;
						parent.ValidFrame.document.forms[0].credit_auth_date.value=rtn_ins_credit_auth_date;
						parent.ValidFrame.document.forms[0].policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
						parent.ValidFrame.document.forms[0].policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
						parent.ValidFrame.document.forms[0].credit_approval_days.value=rtn_ins_credit_approval_days;
						parent.ValidFrame.document.forms[0].credit_approval_amount.value=rtn_ins_credit_approval_amount;
						parent.ValidFrame.document.forms[0].mcn_for_policy.value=rtn_mcn_for_policy;  //V220908
						parent.ValidFrame.document.forms[0].reg_ref_id.value=rtn_reg_ref_id;  //V230315
						parent.ValidFrame.document.forms[0].userId_for_priv.value=rtn_userId_for_priv;  //V230707
						parent.ValidFrame.document.forms[0].reasonCode_for_priv.value=rtn_reasonCode_for_priv;  //V230707
						
					} 
					else
					{
						parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_credit_cust_group_code;
						parent.ValidFrame.document.forms[0].cust_code.value = rtn_credit_cust_code;
					}
	
					parent.ValidFrame.document.forms[0].non_ins_blng_grp_id.value = rtn_non_ins_blng_grp;
					parent.ValidFrame.document.forms[0].non_ins_cust_group_code.value = rtn_non_ins_cust_group_code;
					parent.ValidFrame.document.forms[0].non_ins_cust_code.value = rtn_non_ins_cust_code;
					parent.ValidFrame.document.forms[0].encounter_date_time.value=encounter_date_time;
					parent.ValidFrame.document.forms[0].rtn_pat_ser_code.value=rtn_pat_ser_code;
					
					parent.ValidFrame.document.forms[0].charge_for_pat_regn_yn.value=charge_for_pat_regn_yn;
				}
				catch(er)
				{
					alert("error="+er);
				}
	
				parent.frames[3].location.href='../../eBL/jsp/BLValidation.jsp';
				
				if(parent.ValidFrame.document.forms[0].validated_state.value == 'Y')
				{
					var dialogHeight= "20vh";
					var dialogWidth	= "45vw";
					var dialogTop = "0vh";
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";  scroll=no ; status: " + status + " ; dialogTop :" + dialogTop;
					var arguments	= "" ;
	
					var episode_type = parent.ValidFrame.document.forms[0].episode_type.value;
	
					var hospvisitchargeYN = parent.ValidFrame.document.forms[0].hospvisitchargeYN.value;
					var medvisitchargeYN = parent.ValidFrame.document.forms[0].medvisitchargeYN.value;
					var addlvisitchargeYN = parent.ValidFrame.document.forms[0].addlvisitchargeYN.value;
					var exempt_date = parent.ValidFrame.document.forms[0].exempt_date.value;
					var bill_gen = parent.ValidFrame.document.forms[0].bill_gen.value;
	
					var hosp_serv_panel_ind = parent.ValidFrame.document.forms[0].hosp_serv_panel_ind.value;
					var hosp_serv_panel_code = parent.ValidFrame.document.forms[0].hosp_serv_panel_code.value;
	//				var hosp_serv_panel_str = parent.ValidFrame.document.forms[0].hosp_serv_panel_str.value;
					var hosp_serv_panel_qty = parent.ValidFrame.document.forms[0].hosp_serv_panel_qty.value;
					var hosp_serv_chrg_amt = parent.ValidFrame.document.forms[0].hosp_serv_chrg_amt.value;
	
					var med_serv_panel_ind = parent.ValidFrame.document.forms[0].med_serv_panel_ind.value;
					var med_serv_panel_code = parent.ValidFrame.document.forms[0].med_serv_panel_code.value;
	//				var med_serv_panel_str = parent.ValidFrame.document.forms[0].med_serv_panel_str.value;
					var med_serv_panel_qty = parent.ValidFrame.document.forms[0].med_serv_panel_qty.value;
					var med_serv_chrg_amt = parent.ValidFrame.document.forms[0].med_serv_chrg_amt.value;
	
					var addl_serv_panel_ind = parent.ValidFrame.document.forms[0].addl_serv_panel_ind.value;
					var addl_serv_panel_code = parent.ValidFrame.document.forms[0].addl_serv_panel_code.value;
	//				var med_serv_panel_str = parent.ValidFrame.document.forms[0].med_serv_panel_str.value;
					var addl_serv_panel_qty = parent.ValidFrame.document.forms[0].addl_serv_panel_qty.value;
					var addl_serv_chrg_amt = parent.ValidFrame.document.forms[0].addl_serv_chrg_amt.value;
	
					var str_hosp_chrg_amt = parent.ValidFrame.document.forms[0].str_hosp_chrg_amt.value;
					var str_hosp_chrg_pat_amt=parent.ValidFrame.document.forms[0].str_hosp_chrg_pat_amt.value;
					var str_med_chrg_amt = parent.ValidFrame.document.forms[0].str_med_chrg_amt.value;
					var str_med_chrg_pat_amt= parent.ValidFrame.document.forms[0].str_med_chrg_pat_amt.value;
					var str_addl_chrg_amt = parent.ValidFrame.document.forms[0].str_addl_chrg_amt.value;
					var str_addl_chrg_pat_amt= parent.ValidFrame.document.forms[0].str_addl_chrg_pat_amt.value;
	
					var clinic_code=parent.ValidFrame.document.forms[0].clinic_code.value;
						
					if(rtn_upd_patient_fin_dtls_yn == "Y")
					{
					var  ret_val= await validate_upd_pat_fin_dtls(rtn_patient_id,rtn_facility_id,blng_grp,rtn_slmt_ind,slmt_type_code,cust_code,rtn_ins_policy_type_code,rtn_ins_cust_priority,rtn_non_ins_blng_grp,rtn_non_ins_cust_code,priority_arr,ins_blng_grp_code_arr);
					
						if(ret_val == 'N')
							return false;
					}
					
					if (hospvisitchargeYN == "Y" || medvisitchargeYN == "Y" || addlvisitchargeYN == "Y" || exempt_date!="" || bill_gen!="") 
					{			
						var url = "../../eBL/jsp/BLVisitChargeDetFrame.jsp?hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+exempt_date+"&bill_gen="+bill_gen+"&episode_type="+episode_type+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&"+query_string;	
	
						retVal = await window.showModalDialog(url,arguments,features);
						// Returns 1 for close , 2 for modify
					}
					else
					{
						retVal = "1";				
					}
				}
				else if(parent.ValidFrame.document.forms[0].validated_state.value == 'N')
				{
					
					parent.ValidFrame.document.forms[0].start_valid.value = 'Y';				
	
					parent.ValidFrame.document.forms[0].submit();
				}
				else if(parent.ValidFrame.document.forms[0].validated_state.value == 'E')
				{
	
					alert("Error in Script:"+parent.ValidFrame.document.forms[0].error_message.value);			
				}
	
				if (retVal == "1")				
				{
					document.forms[0].rtn_blng_grp.value=rtn_blng_grp;
					document.forms[0].rtn_slmt_ind.value=rtn_slmt_ind;
					document.forms[0].rtn_credit_doc_reqd_yn.value=rtn_credit_doc_reqd_yn;
					document.forms[0].rtn_blng_class.value=rtn_blng_class;
					document.forms[0].rtn_emp_code.value=rtn_emp_code;
					document.forms[0].rtn_slmt_type_code.value=rtn_slmt_type_code;
					document.forms[0].rtn_inst_ref.value=rtn_inst_ref;
					document.forms[0].rtn_inst_date.value=rtn_inst_date;
					document.forms[0].rtn_inst_remarks.value=rtn_inst_remarks;
					document.forms[0].rtn_credit_cust_group_code.value=rtn_credit_cust_group_code;
					document.forms[0].rtn_credit_cust_code.value=rtn_credit_cust_code;
					document.forms[0].rtn_credit_doc_ref.value=rtn_credit_doc_ref;
					document.forms[0].rtn_credit_doc_start_date.value=rtn_credit_doc_start_date;
					document.forms[0].rtn_credit_doc_end_date.value=rtn_credit_doc_end_date;
					document.forms[0].rtn_sponsor_cust_group_code.value=rtn_sponsor_cust_group_code;
					document.forms[0].rtn_sponsor_cust_code.value=rtn_sponsor_cust_code;
					document.forms[0].rtn_sponsor_credit_doc_ref.value=rtn_sponsor_credit_doc_ref;
					document.forms[0].rtn_sponsor_credit_doc_start_date.value=rtn_sponsor_credit_doc_start_date;
					document.forms[0].rtn_sponsor_credit_doc_end_date.value=rtn_sponsor_credit_doc_end_date;
					document.forms[0].rtn_ins_blng_grp.value=rtn_ins_blng_grp;
					document.forms[0].rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;
					document.forms[0].rtn_ins_cust_code.value=rtn_ins_cust_code;
					document.forms[0].rtn_ins_cust_priority.value=rtn_ins_cust_priority;
					document.forms[0].rtn_ins_policy_type_code.value=rtn_ins_policy_type_code;
					document.forms[0].rtn_ins_policy_no.value=rtn_ins_policy_no;
					document.forms[0].rtn_ins_policy_start_date.value=rtn_ins_policy_start_date;
					document.forms[0].rtn_ins_policy_expiry_date.value=rtn_ins_policy_expiry_date;
					document.forms[0].rtn_ins_credit_auth_ref.value=rtn_ins_credit_auth_ref;
					document.forms[0].rtn_ins_credit_auth_date.value=rtn_ins_credit_auth_date;
					document.forms[0].rtn_ins_cred_auth_req_yn.value=rtn_ins_cred_auth_req_yn;
					document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=rtn_ins_cred_auth_mand_capt_yn;				
					document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=rtn_ins_dflt_auth_ref_as_pol_no_yn;
					document.forms[0].rtn_ins_credit_approval_days.value=rtn_ins_credit_approval_days;
					document.forms[0].rtn_ins_credit_approval_amount.value=rtn_ins_credit_approval_amount;
					document.forms[0].rtn_ins_policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
					document.forms[0].rtn_ins_policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
					document.forms[0].rtn_ins_adj_rule_ind.value=rtn_ins_adj_rule_ind;
					document.forms[0].rtn_ins_adj_perc_amt_ind.value=rtn_ins_adj_perc_amt_ind;
					document.forms[0].rtn_ins_adj_perc_amt_value.value=rtn_ins_adj_perc_amt_value;
					document.forms[0].rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;
					document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;
					document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;
					document.forms[0].rtn_non_ins_blng_grp.value=rtn_non_ins_blng_grp;
					document.forms[0].rtn_non_ins_credit_doc_reqd_yn.value=rtn_non_ins_credit_doc_reqd_yn;
					document.forms[0].rtn_non_ins_slmt_type_code.value=rtn_non_ins_slmt_type_code;
					document.forms[0].rtn_non_ins_inst_ref.value=rtn_non_ins_inst_ref;
					document.forms[0].rtn_non_ins_inst_date.value=rtn_non_ins_inst_date;
					document.forms[0].rtn_non_ins_inst_remarks.value=rtn_non_ins_inst_remarks;
					document.forms[0].rtn_non_ins_cust_group_code.value=rtn_non_ins_cust_group_code;
					document.forms[0].rtn_non_ins_cust_code.value=rtn_non_ins_cust_code;
					document.forms[0].rtn_non_ins_credit_doc_ref.value=rtn_non_ins_credit_doc_ref;
					document.forms[0].rtn_non_ins_credit_doc_start_date.value=rtn_non_ins_credit_doc_start_date;
					document.forms[0].rtn_non_ins_credit_doc_end_date.value=rtn_non_ins_credit_doc_end_date;
					document.forms[0].rtn_annual_income.value=rtn_annual_income;
					document.forms[0].rtn_family_asset.value=rtn_family_asset;
					document.forms[0].rtn_no_of_dependants.value=rtn_no_of_dependants;
					document.forms[0].rtn_resp_for_payment.value=rtn_resp_for_payment;
					document.forms[0].rtn_pat_reln_with_resp_person.value=rtn_pat_reln_with_resp_person;
					document.forms[0].rtn_fin_remarks.value=rtn_fin_remarks;
					document.forms[0].rtn_gl_holder_name.value=rtn_gl_holder_name;
					document.forms[0].rtn_pat_reln_with_gl_holder.value=rtn_pat_reln_with_gl_holder;
					document.forms[0].rtn_upd_patient_fin_dtls_yn.value=rtn_upd_patient_fin_dtls_yn;
					document.forms[0].rtn_spl_clinic_rel_enc_YN.value=rtn_spl_clinic_rel_enc_YN;
					document.forms[0].rtn_user_id.value=rtn_user_id;
					document.forms[0].rtn_fin_auth_user_id.value=rtn_fin_auth_user_id;
					document.forms[0].rtn_ins_restrict_check.value=rtn_ins_restrict_check;
					document.forms[0].rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;
					document.forms[0].rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;
					document.forms[0].rtn_ref_src_main_code.value=rtn_ref_src_main_code;
					document.forms[0].rtn_ref_src_main_desc.value=rtn_ref_src_main_desc;
					document.forms[0].rtn_ref_src_sub_code.value=rtn_ref_src_sub_code;
					document.forms[0].rtn_ref_src_sub_desc.value=rtn_ref_src_sub_desc;
					document.forms[0].rtn_mcn_for_policy.value = rtn_mcn_for_policy;  //V220908
					document.forms[0].rtn_reg_ref_id.value = rtn_reg_ref_id;  //V230315
					document.forms[0].rtn_userId_for_priv.value = rtn_userId_for_priv;  //V230707
					document.forms[0].rtn_reasonCode_for_priv.value = rtn_reasonCode_for_priv;  //V230707
					
					document.PatFinMainForm.rtn_ins_ref_src_main_code.value=rtn_ins_ref_src_main_code;
					document.PatFinMainForm.rtn_ins_ref_src_main_desc.value=rtn_ins_ref_src_main_desc;
					document.PatFinMainForm.rtn_ins_ref_src_sub_code.value=rtn_ins_ref_src_sub_code;
					document.PatFinMainForm.rtn_ins_ref_src_sub_desc.value=rtn_ins_ref_src_sub_desc;
	
					document.PatFinMainForm.rtn_non_ins_ref_src_main_code.value=rtn_non_ins_ref_src_main_code;
					document.PatFinMainForm.rtn_non_ins_ref_src_main_desc.value=rtn_non_ins_ref_src_main_desc;
					document.PatFinMainForm.rtn_non_ins_ref_src_sub_code.value=rtn_non_ins_ref_src_sub_code;
					document.PatFinMainForm.rtn_non_ins_ref_src_sub_desc.value=rtn_non_ins_ref_src_sub_desc;
	
					document.PatFinMainForm.rtn_tot_valid_enc_with_gl.value=rtn_tot_valid_enc_with_gl;
					document.PatFinMainForm.rtn_tot_valid_op_enc_with_gl.value=rtn_tot_valid_op_enc_with_gl;
					document.PatFinMainForm.rtn_tot_valid_ae_enc_with_gl.value=rtn_tot_valid_ae_enc_with_gl;
					document.PatFinMainForm.rtn_tot_valid_ip_enc_with_gl.value=rtn_tot_valid_ip_enc_with_gl;
					document.PatFinMainForm.rtn_tot_valid_dc_enc_with_gl.value=rtn_tot_valid_dc_enc_with_gl;
	
					document.PatFinMainForm.rtn_tot_availed_enc_with_gl.value=rtn_tot_availed_enc_with_gl;
					document.PatFinMainForm.rtn_tot_availed_op_enc_with_gl.value=rtn_tot_availed_op_enc_with_gl;
					document.PatFinMainForm.rtn_tot_availed_ae_enc_with_gl.value=rtn_tot_availed_ae_enc_with_gl;
					document.PatFinMainForm.rtn_tot_availed_ip_enc_with_gl.value=rtn_tot_availed_ip_enc_with_gl;
					document.PatFinMainForm.rtn_tot_availed_dc_enc_with_gl.value=rtn_tot_availed_dc_enc_with_gl;
	
					document.PatFinMainForm.rtn_gl_doc_ref_exist_YN.value=rtn_gl_doc_ref_exist_YN;	
					document.PatFinMainForm.rtn_calling_function_id.value=calling_function_id;	
					
					document.PatFinMainForm.rtn_pat_ser_code.value=rtn_pat_ser_code;	
				
	
					if(autoFinChk=="Y" && calling_function_id != "BOOKING")
					{	   
						document.PatFinMainForm.rtn_class_type.value = rtn_class_type;
						document.PatFinMainForm.rtn_class_code.value = rtn_class_code;
						document.PatFinMainForm.rtn_remarks.value = rtn_remarks;
						document.PatFinMainForm.rtn_social_pensioner_id.value = rtn_social_pensioner_id;
						document.PatFinMainForm.rtn_inc_asset_ind.value = rtn_inc_asset_ind;
						document.PatFinMainForm.rtn_ind_inc.value = rtn_ind_inc;
						document.PatFinMainForm.rtn_ind_inc_freq.value = rtn_ind_inc_freq;
						document.PatFinMainForm.rtn_spouse_inc.value = rtn_spouse_inc;
						document.PatFinMainForm.rtn_spouse_inc_freq.value = rtn_spouse_inc_freq;
						document.PatFinMainForm.rtn_dependent_inc.value = rtn_dependent_inc;
						document.PatFinMainForm.rtn_dependent_inc_freq.value = rtn_dependent_inc_freq;
						document.PatFinMainForm.rtn_valid_from.value = rtn_valid_from;
						document.PatFinMainForm.rtn_valid_to.value = rtn_valid_to;
						document.PatFinMainForm.rtn_last_date.value = rtn_last_date;
					}
	
					var returnArray=new Array(rtn_blng_grp);
					window.returnValue=returnArray;
									
					
					parent.frames[2].location.href='../../eBL/jsp/BLFinancialDetailsSubmit.jsp';
				}
			}
			else if ((calling_module_id == 'IP' || calling_module_id == 'DC') || ((calling_module_id == 'MP') && charge_for_pat_regn_yn=="N") || (blInterface == "N"))
			{
				if(calling_module_id != 'MP' && rtn_upd_patient_fin_dtls_yn == "Y")
				{
					var  ret_val= await validate_upd_pat_fin_dtls(rtn_patient_id,rtn_facility_id,blng_grp,rtn_slmt_ind,slmt_type_code,cust_code,rtn_ins_policy_type_code,rtn_ins_cust_priority,rtn_non_ins_blng_grp,rtn_non_ins_cust_code,priority_arr,ins_blng_grp_code_arr);
						
					if(ret_val == 'N')
						return false;
				}
	
				document.forms[0].rtn_blng_grp.value=rtn_blng_grp;
				document.forms[0].rtn_slmt_ind.value=rtn_slmt_ind;
				document.forms[0].rtn_credit_doc_reqd_yn.value=rtn_credit_doc_reqd_yn;
				document.forms[0].rtn_blng_class.value=rtn_blng_class;
				document.forms[0].rtn_emp_code.value=rtn_emp_code;
				document.forms[0].rtn_slmt_type_code.value=rtn_slmt_type_code;
				document.forms[0].rtn_inst_ref.value=rtn_inst_ref;
				document.forms[0].rtn_inst_date.value=rtn_inst_date;
				document.forms[0].rtn_inst_remarks.value=rtn_inst_remarks;
				document.forms[0].rtn_credit_cust_group_code.value=rtn_credit_cust_group_code;
				document.forms[0].rtn_credit_cust_code.value=rtn_credit_cust_code;
				document.forms[0].rtn_credit_doc_ref.value=rtn_credit_doc_ref;
				document.forms[0].rtn_credit_doc_start_date.value=rtn_credit_doc_start_date;
				document.forms[0].rtn_credit_doc_end_date.value=rtn_credit_doc_end_date;
				document.forms[0].rtn_sponsor_cust_group_code.value=rtn_sponsor_cust_group_code;
				document.forms[0].rtn_sponsor_cust_code.value=rtn_sponsor_cust_code;
				document.forms[0].rtn_sponsor_credit_doc_ref.value=rtn_sponsor_credit_doc_ref;
				document.forms[0].rtn_sponsor_credit_doc_start_date.value=rtn_sponsor_credit_doc_start_date;
				document.forms[0].rtn_sponsor_credit_doc_end_date.value=rtn_sponsor_credit_doc_end_date;
				document.forms[0].rtn_ins_blng_grp.value=rtn_ins_blng_grp;
				document.forms[0].rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;
				document.forms[0].rtn_ins_cust_code.value=rtn_ins_cust_code;
				document.forms[0].rtn_ins_cust_priority.value=rtn_ins_cust_priority;
				document.forms[0].rtn_ins_policy_type_code.value=rtn_ins_policy_type_code;
				document.forms[0].rtn_ins_policy_no.value=rtn_ins_policy_no;
				document.forms[0].rtn_ins_policy_start_date.value=rtn_ins_policy_start_date;
				document.forms[0].rtn_ins_policy_expiry_date.value=rtn_ins_policy_expiry_date;
				document.forms[0].rtn_ins_credit_auth_ref.value=rtn_ins_credit_auth_ref;
				document.forms[0].rtn_ins_credit_auth_date.value=rtn_ins_credit_auth_date;
	 			document.forms[0].rtn_ins_cred_auth_req_yn.value=rtn_ins_cred_auth_req_yn;
				document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=rtn_ins_cred_auth_mand_capt_yn;				
				document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=rtn_ins_dflt_auth_ref_as_pol_no_yn;
				document.forms[0].rtn_ins_credit_approval_days.value=rtn_ins_credit_approval_days;
				document.forms[0].rtn_ins_credit_approval_amount.value=rtn_ins_credit_approval_amount;
				document.forms[0].rtn_ins_policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
				document.forms[0].rtn_ins_policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
				document.forms[0].rtn_ins_adj_rule_ind.value=rtn_ins_adj_rule_ind;
				document.forms[0].rtn_ins_adj_perc_amt_ind.value=rtn_ins_adj_perc_amt_ind;
				document.forms[0].rtn_ins_adj_perc_amt_value.value=rtn_ins_adj_perc_amt_value;
				document.forms[0].rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;
				document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;
				document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;
				document.forms[0].rtn_non_ins_blng_grp.value=rtn_non_ins_blng_grp;
				document.forms[0].rtn_non_ins_credit_doc_reqd_yn.value=rtn_non_ins_credit_doc_reqd_yn;
				document.forms[0].rtn_non_ins_slmt_type_code.value=rtn_non_ins_slmt_type_code;
				document.forms[0].rtn_non_ins_inst_ref.value=rtn_non_ins_inst_ref;
				document.forms[0].rtn_non_ins_inst_date.value=rtn_non_ins_inst_date;
				document.forms[0].rtn_non_ins_inst_remarks.value=rtn_non_ins_inst_remarks;
				document.forms[0].rtn_non_ins_cust_group_code.value=rtn_non_ins_cust_group_code;
				document.forms[0].rtn_non_ins_cust_code.value=rtn_non_ins_cust_code;
				document.forms[0].rtn_non_ins_credit_doc_ref.value=rtn_non_ins_credit_doc_ref;
				document.forms[0].rtn_non_ins_credit_doc_start_date.value=rtn_non_ins_credit_doc_start_date;
				document.forms[0].rtn_non_ins_credit_doc_end_date.value=rtn_non_ins_credit_doc_end_date;
				document.forms[0].rtn_annual_income.value=rtn_annual_income;
				document.forms[0].rtn_family_asset.value=rtn_family_asset;
				document.forms[0].rtn_no_of_dependants.value=rtn_no_of_dependants;
				document.forms[0].rtn_resp_for_payment.value=rtn_resp_for_payment;
				document.forms[0].rtn_pat_reln_with_resp_person.value=rtn_pat_reln_with_resp_person;
				document.forms[0].rtn_fin_remarks.value=rtn_fin_remarks;
				document.forms[0].rtn_gl_holder_name.value=rtn_gl_holder_name;
				document.forms[0].rtn_pat_reln_with_gl_holder.value=rtn_pat_reln_with_gl_holder;
				document.forms[0].rtn_upd_patient_fin_dtls_yn.value=rtn_upd_patient_fin_dtls_yn;
				document.forms[0].rtn_spl_clinic_rel_enc_YN.value=rtn_spl_clinic_rel_enc_YN;
				document.forms[0].rtn_user_id.value=rtn_user_id;
				document.forms[0].rtn_fin_auth_user_id.value=rtn_fin_auth_user_id;
				document.forms[0].rtn_total_records.value=rtn_total_records;
				document.forms[0].rtn_ins_restrict_check.value=rtn_ins_restrict_check;
				document.forms[0].rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;
				document.forms[0].rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;
				document.forms[0].rtn_ref_src_main_code.value=rtn_ref_src_main_code;
				document.forms[0].rtn_ref_src_main_desc.value=rtn_ref_src_main_desc;
				document.forms[0].rtn_ref_src_sub_code.value=rtn_ref_src_sub_code;
				document.forms[0].rtn_ref_src_sub_desc.value=rtn_ref_src_sub_desc;
				document.forms[0].rtn_mcn_for_policy.value = rtn_mcn_for_policy;  //V220908
				document.forms[0].rtn_reg_ref_id.value = rtn_reg_ref_id;  //V230315
				document.forms[0].rtn_userId_for_priv.value = rtn_userId_for_priv;  //V230707
				document.forms[0].rtn_reasonCode_for_priv.value = rtn_reasonCode_for_priv;  //V230707
				document.forms[0].rtn_payerEligibilityParamSession.value=rtn_payerEligibilityParamSession; //V230707
				document.forms[0].rtn_responseCode.value=rtn_responseCode; //V230707
				document.forms[0].rtn_responseCodeDesc.value=rtn_responseCodeDesc; //V230707
				document.forms[0].rtn_statuDescription.value=rtn_statuDescription; //V230707
				document.forms[0].rtn_validityPeriod.value=rtn_validityPeriod;   //V230707
				document.forms[0].rtn_validityPeriodDesc.value=rtn_validityPeriodDesc;  //V230707
				document.forms[0].rtn_eligibilityCode.value=rtn_eligibilityCode;  //V230707
				document.forms[0].rtn_transactionId.value=rtn_transactionId;   //V230707
				document.forms[0].rtn_responseDateTime.value=rtn_responseDateTime;  //V230707
	
				
				document.PatFinMainForm.rtn_ins_ref_src_main_code.value=rtn_ins_ref_src_main_code;
				document.PatFinMainForm.rtn_ins_ref_src_main_desc.value=rtn_ins_ref_src_main_desc;
				document.PatFinMainForm.rtn_ins_ref_src_sub_code.value=rtn_ins_ref_src_sub_code;
				document.PatFinMainForm.rtn_ins_ref_src_sub_desc.value=rtn_ins_ref_src_sub_desc;
	
				document.PatFinMainForm.rtn_non_ins_ref_src_main_code.value=rtn_non_ins_ref_src_main_code;
				document.PatFinMainForm.rtn_non_ins_ref_src_main_desc.value=rtn_non_ins_ref_src_main_desc;
				document.PatFinMainForm.rtn_non_ins_ref_src_sub_code.value=rtn_non_ins_ref_src_sub_code;
				document.PatFinMainForm.rtn_non_ins_ref_src_sub_desc.value=rtn_non_ins_ref_src_sub_desc;
	
				document.PatFinMainForm.rtn_tot_valid_enc_with_gl.value=rtn_tot_valid_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_op_enc_with_gl.value=rtn_tot_valid_op_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_ae_enc_with_gl.value=rtn_tot_valid_ae_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_ip_enc_with_gl.value=rtn_tot_valid_ip_enc_with_gl;
				document.PatFinMainForm.rtn_tot_valid_dc_enc_with_gl.value=rtn_tot_valid_dc_enc_with_gl;
	
				document.PatFinMainForm.rtn_tot_availed_enc_with_gl.value=rtn_tot_availed_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_op_enc_with_gl.value=rtn_tot_availed_op_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_ae_enc_with_gl.value=rtn_tot_availed_ae_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_ip_enc_with_gl.value=rtn_tot_availed_ip_enc_with_gl;
				document.PatFinMainForm.rtn_tot_availed_dc_enc_with_gl.value=rtn_tot_availed_dc_enc_with_gl;
	
				document.PatFinMainForm.rtn_gl_doc_ref_exist_YN.value=rtn_gl_doc_ref_exist_YN;			
				document.PatFinMainForm.rtn_calling_function_id.value=calling_function_id;	
	
				document.PatFinMainForm.rtn_pat_ser_code.value=rtn_pat_ser_code;				
	
				if(autoFinChk=="Y" && calling_function_id != "BOOKING")
				{
					document.PatFinMainForm.rtn_class_type.value = rtn_class_type;
					document.PatFinMainForm.rtn_class_code.value = rtn_class_code;
					document.PatFinMainForm.rtn_remarks.value = rtn_remarks;
					document.PatFinMainForm.rtn_social_pensioner_id.value = rtn_social_pensioner_id;
					document.PatFinMainForm.rtn_inc_asset_ind.value = rtn_inc_asset_ind;
					document.PatFinMainForm.rtn_ind_inc.value = rtn_ind_inc;
					document.PatFinMainForm.rtn_ind_inc_freq.value = rtn_ind_inc_freq;
					document.PatFinMainForm.rtn_spouse_inc.value = rtn_spouse_inc;
					document.PatFinMainForm.rtn_spouse_inc_freq.value = rtn_spouse_inc_freq;
					document.PatFinMainForm.rtn_dependent_inc.value = rtn_dependent_inc;
					document.PatFinMainForm.rtn_dependent_inc_freq.value = rtn_dependent_inc_freq;
					document.PatFinMainForm.rtn_valid_from.value = rtn_valid_from;
					document.PatFinMainForm.rtn_valid_to.value = rtn_valid_to;
					document.PatFinMainForm.rtn_last_date.value = rtn_last_date;
				}
	
				var returnArray=new Array(rtn_blng_grp);
				window.returnValue=returnArray;
				parent.frames[2].location.href='../../eBL/jsp/BLFinancialDetailsSubmit.jsp';
			}
			else if ((calling_module_id == 'OP' || calling_module_id == 'AE') && (blInterface == "Y") )
			{
				
				var retVal;
	
				if(calling_function_id=='BOOKING')
				{
					retVal = "1";
				}
				else
				{
					try
					{
						parent.ValidFrame.document.forms[0].billing_group.value= parent.frames[0].document.forms[0].billing_group.value;
						parent.ValidFrame.document.forms[0].clinic_code.value= parent.frames[0].document.forms[0].clinic_code.value;
						parent.ValidFrame.document.forms[0].visit_type_code.value=  parent.frames[0].document.forms[0].visit_type_code.value;
						parent.ValidFrame.document.forms[0].patient_id.value = parent.frames[0].document.forms[0].patient_id.value;
						parent.ValidFrame.document.forms[0].episode_type.value = parent.frames[0].document.forms[0].episode_type.value;
						parent.ValidFrame.document.forms[0].facility_id.value = parent.frames[0].document.forms[0].facility_id.value;
						parent.ValidFrame.document.forms[0].calling_module_id.value = parent.frames[0].document.forms[0].calling_module_id.value;
						parent.ValidFrame.document.forms[0].calling_function_id.value = parent.frames[0].document.forms[0].function_id.value;
						parent.ValidFrame.document.forms[0].logged_user_id.value = parent.frames[0].document.forms[0].logged_user_id.value;
						parent.ValidFrame.document.forms[0].practitioner_id.value = parent.frames[0].document.forms[0].practitioner_id.value;
						parent.ValidFrame.document.forms[0].practitioner_type_ind.value = parent.frames[0].document.forms[0].practitioner_type_ind.value;
						parent.ValidFrame.document.forms[0].disaster_regn_YN.value = parent.frames[0].document.forms[0].disaster_regn_YN.value;
	
						if(mode=="2")
						{
							parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_credit_cust_group_code;
							parent.ValidFrame.document.forms[0].cust_code.value = rtn_credit_cust_code;
						}
						else if(mode=="3")
						{
							parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_sponsor_cust_group_code;
							parent.ValidFrame.document.forms[0].cust_code.value = rtn_sponsor_cust_code;
						}
						else if(mode=="4")
						{
							parent.ValidFrame.document.forms[0].billing_group.value=rtn_ins_blng_grp;
							parent.ValidFrame.document.forms[0].cust_group_code.value=rtn_ins_cust_group_code;
							parent.ValidFrame.document.forms[0].cust_code.value=rtn_ins_cust_code;
							parent.ValidFrame.document.forms[0].policy_priority.value=rtn_ins_cust_priority;
							parent.ValidFrame.document.forms[0].policy_type_code.value=rtn_ins_policy_type_code;
							parent.ValidFrame.document.forms[0].policy_no.value=rtn_ins_policy_no;
							parent.ValidFrame.document.forms[0].policy_start_date.value=rtn_ins_policy_start_date;
							parent.ValidFrame.document.forms[0].policy_expiry_date.value=rtn_ins_policy_expiry_date;
							parent.ValidFrame.document.forms[0].credit_auth_ref.value=rtn_ins_credit_auth_ref;
							parent.ValidFrame.document.forms[0].credit_auth_date.value=rtn_ins_credit_auth_date;
							parent.ValidFrame.document.forms[0].policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
							parent.ValidFrame.document.forms[0].policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
							parent.ValidFrame.document.forms[0].credit_approval_days.value=rtn_ins_credit_approval_days;
							parent.ValidFrame.document.forms[0].credit_approval_amount.value=rtn_ins_credit_approval_amount;
		//					parent.ValidFrame.document.forms[0].non_ins_blng_grp_id.value=rtn_non_ins_blng_grp;
		//					parent.ValidFrame.document.forms[0].non_ins_cust_code.value=rtn_non_ins_cust_code;
							parent.ValidFrame.document.forms[0].mcn_for_policy.value=rtn_mcn_for_policy;  //V220908
							parent.ValidFrame.document.forms[0].reg_ref_id.value=rtn_reg_ref_id;  //V230315
							parent.ValidFrame.document.forms[0].rtn_reg_referral_flag.value=rtn_reg_referral_flag;  //V230616
							parent.ValidFrame.document.forms[0].userId_for_priv.value=rtn_userId_for_priv;  //V230707
							parent.ValidFrame.document.forms[0].reasonCode_for_priv.value=rtn_reasonCode_for_priv;  //V230707
						
							
							
						} 
						else
						{
							parent.ValidFrame.document.forms[0].cust_group_code.value = rtn_credit_cust_group_code;
							parent.ValidFrame.document.forms[0].cust_code.value = rtn_credit_cust_code;
						}
						
	
						parent.ValidFrame.document.forms[0].non_ins_blng_grp_id.value = rtn_non_ins_blng_grp;
						parent.ValidFrame.document.forms[0].non_ins_cust_group_code.value = rtn_non_ins_cust_group_code;
						parent.ValidFrame.document.forms[0].non_ins_cust_code.value = rtn_non_ins_cust_code;
						parent.ValidFrame.document.forms[0].encounter_date_time.value=encounter_date_time;
						parent.ValidFrame.document.forms[0].strOrderCtlgCode.value=strOrderCtlgCode;//Added V190408-Aravindh/GHL-CRF-0525
						//alert("parent.ValidFrame.document.forms[0].encounter_date_time.value " +parent.ValidFrame.document.forms[0].encounter_date_time.value);
						
					}
					catch(er)
					{
						alert("error="+er);
					}
					
					parent.frames[3].location.href='../../eBL/jsp/BLValidation.jsp';
					
					if(parent.ValidFrame.document.forms[0].validated_state.value == 'Y')
					{
						/* Modified V190401-Aravindh/GHL-CRF-0525/Added if-else condition */
						var dialogHeight= "";
						var dialogWidth	= "";
						var dialogTop = "";
						if(parent.ValidFrame.document.forms[0].chkOrderCtlgAmt.value == 'true') {
							dialogHeight= "20vh";
							dialogWidth	= "45vw";
							dialogTop = "0vh";
						} else {
							dialogHeight= "20vh";
							dialogWidth	= "45vw";
							dialogTop = "0vh";
						}
						
						var center = "1" ;														   
						var status="no";
						var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";  scroll=no ; status: " + status + " ; dialogTop :" + dialogTop;
						var arguments	= "" ;
	
						var episode_type = parent.ValidFrame.document.forms[0].episode_type.value;
	
						var hospvisitchargeYN = parent.ValidFrame.document.forms[0].hospvisitchargeYN.value;
						var medvisitchargeYN = parent.ValidFrame.document.forms[0].medvisitchargeYN.value;
						var addlvisitchargeYN = parent.ValidFrame.document.forms[0].addlvisitchargeYN.value;
						var exempt_date = parent.ValidFrame.document.forms[0].exempt_date.value;
						var bill_gen = parent.ValidFrame.document.forms[0].bill_gen.value;
	
						var hosp_serv_panel_ind = parent.ValidFrame.document.forms[0].hosp_serv_panel_ind.value;
						var hosp_serv_panel_code = parent.ValidFrame.document.forms[0].hosp_serv_panel_code.value;
		//				var hosp_serv_panel_str = parent.ValidFrame.document.forms[0].hosp_serv_panel_str.value;
						var hosp_serv_panel_qty = parent.ValidFrame.document.forms[0].hosp_serv_panel_qty.value;
						var hosp_serv_chrg_amt = parent.ValidFrame.document.forms[0].hosp_serv_chrg_amt.value;
	
						var med_serv_panel_ind = parent.ValidFrame.document.forms[0].med_serv_panel_ind.value;
						var med_serv_panel_code = parent.ValidFrame.document.forms[0].med_serv_panel_code.value;
		//				var med_serv_panel_str = parent.ValidFrame.document.forms[0].med_serv_panel_str.value;
						var med_serv_panel_qty = parent.ValidFrame.document.forms[0].med_serv_panel_qty.value;
						var med_serv_chrg_amt = parent.ValidFrame.document.forms[0].med_serv_chrg_amt.value;
	
						var addl_serv_panel_ind = parent.ValidFrame.document.forms[0].addl_serv_panel_ind.value;
						var addl_serv_panel_code = parent.ValidFrame.document.forms[0].addl_serv_panel_code.value;
		//				var med_serv_panel_str = parent.ValidFrame.document.forms[0].med_serv_panel_str.value;
						var addl_serv_panel_qty = parent.ValidFrame.document.forms[0].addl_serv_panel_qty.value;
						var addl_serv_chrg_amt = parent.ValidFrame.document.forms[0].addl_serv_chrg_amt.value;
	
						var str_hosp_chrg_amt = parent.ValidFrame.document.forms[0].str_hosp_chrg_amt.value;
						var str_hosp_chrg_pat_amt=parent.ValidFrame.document.forms[0].str_hosp_chrg_pat_amt.value;
						var str_med_chrg_amt = parent.ValidFrame.document.forms[0].str_med_chrg_amt.value;
						var str_med_chrg_pat_amt= parent.ValidFrame.document.forms[0].str_med_chrg_pat_amt.value;
						var str_addl_chrg_amt = parent.ValidFrame.document.forms[0].str_addl_chrg_amt.value;
						var str_addl_chrg_pat_amt= parent.ValidFrame.document.forms[0].str_addl_chrg_pat_amt.value;
	
						var clinic_code=parent.ValidFrame.document.forms[0].clinic_code.value;
						
						var strOrderCtlgDtls = parent.ValidFrame.document.forms[0].strOrderCtlgDtls.value;//Added V190403-Aravindh/GHL-CRF-0525
						var strOrderCtlgTotal = parent.ValidFrame.document.forms[0].strOrderCtlgTotal.value;//Added V190403-Aravindh/GHL-CRF-0525
						
	// Commented as Procedure is not corrected
	
						if(rtn_upd_patient_fin_dtls_yn == "Y")
						{
							var  ret_val=await validate_upd_pat_fin_dtls(rtn_patient_id,rtn_facility_id,blng_grp,rtn_slmt_ind,slmt_type_code,cust_code,rtn_ins_policy_type_code,rtn_ins_cust_priority,rtn_non_ins_blng_grp,rtn_non_ins_cust_code,priority_arr,ins_blng_grp_code_arr);
							
							if(ret_val == 'N')
								return false;
						}
						
						//Added V190410-Aravindh/GHL-CRF-0525/include one more condition strOrderCtlgDtls != ""
						if (hospvisitchargeYN == "Y" || medvisitchargeYN == "Y" || addlvisitchargeYN == "Y" || exempt_date!="" || bill_gen!="" || strOrderCtlgCode != "") 
						{	
							var url = "../../eBL/jsp/BLVisitChargeDetFrame.jsp?hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+exempt_date+"&bill_gen="+bill_gen+"&episode_type="+episode_type+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&"+query_string;	
							url = url + "&strOrderCtlgDtls="+strOrderCtlgDtls+"&strOrderCtlgTotal="+strOrderCtlgTotal;//Added V190403-Aravindh/GHL-CRF-0525
							
							retVal = await window.showModalDialog(url,arguments,features);
							
							// Returns 1 for close , 2 for modify
						}
						else
						{
							retVal = "1";				
						}
	
					}
					else if(parent.ValidFrame.document.forms[0].validated_state.value == 'N')
					{
						
						parent.ValidFrame.document.forms[0].start_valid.value = 'Y';				
	
						parent.ValidFrame.document.forms[0].submit();
					}
					else if(parent.ValidFrame.document.forms[0].validated_state.value == 'E')
					{
	
						alert("Error in Script:"+parent.ValidFrame.document.forms[0].error_message.value);			
					}
				}
				
				if (retVal == "1")				
				{
						document.forms[0].rtn_blng_grp.value=rtn_blng_grp;
						document.forms[0].rtn_slmt_ind.value=rtn_slmt_ind;
						document.forms[0].rtn_credit_doc_reqd_yn.value=rtn_credit_doc_reqd_yn;
						document.forms[0].rtn_blng_class.value=rtn_blng_class;
						document.forms[0].rtn_emp_code.value=rtn_emp_code;
						document.forms[0].rtn_slmt_type_code.value=rtn_slmt_type_code;
						document.forms[0].rtn_inst_ref.value=rtn_inst_ref;
						document.forms[0].rtn_inst_date.value=rtn_inst_date;
						document.forms[0].rtn_inst_remarks.value=rtn_inst_remarks;
						document.forms[0].rtn_credit_cust_group_code.value=rtn_credit_cust_group_code;
						document.forms[0].rtn_credit_cust_code.value=rtn_credit_cust_code;
						document.forms[0].rtn_credit_doc_ref.value=rtn_credit_doc_ref;
						document.forms[0].rtn_credit_doc_start_date.value=rtn_credit_doc_start_date;
						document.forms[0].rtn_credit_doc_end_date.value=rtn_credit_doc_end_date;
						document.forms[0].rtn_sponsor_cust_group_code.value=rtn_sponsor_cust_group_code;
						document.forms[0].rtn_sponsor_cust_code.value=rtn_sponsor_cust_code;
						document.forms[0].rtn_sponsor_credit_doc_ref.value=rtn_sponsor_credit_doc_ref;
						document.forms[0].rtn_sponsor_credit_doc_start_date.value=rtn_sponsor_credit_doc_start_date;
						document.forms[0].rtn_sponsor_credit_doc_end_date.value=rtn_sponsor_credit_doc_end_date;
						document.forms[0].rtn_ins_blng_grp.value=rtn_ins_blng_grp;
						document.forms[0].rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;
						document.forms[0].rtn_ins_cust_code.value=rtn_ins_cust_code;
						document.forms[0].rtn_ins_cust_priority.value=rtn_ins_cust_priority;
						document.forms[0].rtn_ins_policy_type_code.value=rtn_ins_policy_type_code;
						document.forms[0].rtn_ins_policy_no.value=rtn_ins_policy_no;
						document.forms[0].rtn_ins_policy_start_date.value=rtn_ins_policy_start_date;
						document.forms[0].rtn_ins_policy_expiry_date.value=rtn_ins_policy_expiry_date;
						document.forms[0].rtn_ins_credit_auth_ref.value=rtn_ins_credit_auth_ref;
						document.forms[0].rtn_ins_credit_auth_date.value=rtn_ins_credit_auth_date;
						document.forms[0].rtn_ins_cred_auth_req_yn.value=rtn_ins_cred_auth_req_yn;
						document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=rtn_ins_cred_auth_mand_capt_yn;				
						document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=rtn_ins_dflt_auth_ref_as_pol_no_yn;
						document.forms[0].rtn_ins_credit_approval_days.value=rtn_ins_credit_approval_days;
						document.forms[0].rtn_ins_credit_approval_amount.value=rtn_ins_credit_approval_amount;
						document.forms[0].rtn_ins_policy_eff_from_date.value=rtn_ins_policy_eff_from_date;
						document.forms[0].rtn_ins_policy_eff_to_date.value=rtn_ins_policy_eff_to_date;
						document.forms[0].rtn_ins_adj_rule_ind.value=rtn_ins_adj_rule_ind;
						document.forms[0].rtn_ins_adj_perc_amt_ind.value=rtn_ins_adj_perc_amt_ind;
						document.forms[0].rtn_ins_adj_perc_amt_value.value=rtn_ins_adj_perc_amt_value;
						document.forms[0].rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;
						document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;
						document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;
						document.forms[0].rtn_non_ins_blng_grp.value=rtn_non_ins_blng_grp;
						document.forms[0].rtn_non_ins_credit_doc_reqd_yn.value=rtn_non_ins_credit_doc_reqd_yn;
						document.forms[0].rtn_non_ins_slmt_type_code.value=rtn_non_ins_slmt_type_code;
						document.forms[0].rtn_non_ins_inst_ref.value=rtn_non_ins_inst_ref;
						document.forms[0].rtn_non_ins_inst_date.value=rtn_non_ins_inst_date;
						document.forms[0].rtn_non_ins_inst_remarks.value=rtn_non_ins_inst_remarks;
						document.forms[0].rtn_non_ins_cust_group_code.value=rtn_non_ins_cust_group_code;
						document.forms[0].rtn_non_ins_cust_code.value=rtn_non_ins_cust_code;
						document.forms[0].rtn_non_ins_credit_doc_ref.value=rtn_non_ins_credit_doc_ref;
						document.forms[0].rtn_non_ins_credit_doc_start_date.value=rtn_non_ins_credit_doc_start_date;
						document.forms[0].rtn_non_ins_credit_doc_end_date.value=rtn_non_ins_credit_doc_end_date;
						document.forms[0].rtn_annual_income.value=rtn_annual_income;
						document.forms[0].rtn_family_asset.value=rtn_family_asset;
						document.forms[0].rtn_no_of_dependants.value=rtn_no_of_dependants;
						document.forms[0].rtn_resp_for_payment.value=rtn_resp_for_payment;
						document.forms[0].rtn_pat_reln_with_resp_person.value=rtn_pat_reln_with_resp_person;
						document.forms[0].rtn_fin_remarks.value=rtn_fin_remarks;
						document.forms[0].rtn_gl_holder_name.value=rtn_gl_holder_name;
						document.forms[0].rtn_pat_reln_with_gl_holder.value=rtn_pat_reln_with_gl_holder;
						document.forms[0].rtn_upd_patient_fin_dtls_yn.value=rtn_upd_patient_fin_dtls_yn;
						document.forms[0].rtn_spl_clinic_rel_enc_YN.value=rtn_spl_clinic_rel_enc_YN;
						document.forms[0].rtn_user_id.value=rtn_user_id;
						document.forms[0].rtn_fin_auth_user_id.value=rtn_fin_auth_user_id;
						document.forms[0].rtn_ins_restrict_check.value=rtn_ins_restrict_check;
						document.forms[0].rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;
						document.forms[0].rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;
						document.forms[0].rtn_ref_src_main_code.value=rtn_ref_src_main_code;
						document.forms[0].rtn_ref_src_main_desc.value=rtn_ref_src_main_desc;
						document.forms[0].rtn_ref_src_sub_code.value=rtn_ref_src_sub_code;
						document.forms[0].rtn_ref_src_sub_desc.value=rtn_ref_src_sub_desc;
	
						//Added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check
						//AddModifyPatFinDetails.jsp
						document.forms[0].rtn_payerEligibilityParamSession.value=rtn_payerEligibilityParamSession;
						document.forms[0].rtn_responseCode.value=rtn_responseCode;
						document.forms[0].rtn_responseCodeDesc.value=rtn_responseCodeDesc;
						document.forms[0].rtn_statuDescription.value=rtn_statuDescription;
						document.forms[0].rtn_validityPeriod.value=rtn_validityPeriod;
						document.forms[0].rtn_validityPeriodDesc.value=rtn_validityPeriodDesc;
						document.forms[0].rtn_eligibilityCode.value=rtn_eligibilityCode;
						document.forms[0].rtn_transactionId.value=rtn_transactionId;
						document.forms[0].rtn_responseDateTime.value=rtn_responseDateTime;
	
				        //above code was added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check
	
						document.forms[0].rtn_mcn_for_policy.value = rtn_mcn_for_policy;  //V220908
						document.forms[0].rtn_reg_ref_id.value = rtn_reg_ref_id;  //V230315
						document.forms[0].rtn_userId_for_priv.value = rtn_userId_for_priv;  //V230707
						document.forms[0].rtn_reasonCode_for_priv.value = rtn_reasonCode_for_priv;  //V230707
				
				
						
						document.PatFinMainForm.rtn_ins_ref_src_main_code.value=rtn_ins_ref_src_main_code;
						document.PatFinMainForm.rtn_ins_ref_src_main_desc.value=rtn_ins_ref_src_main_desc;
						document.PatFinMainForm.rtn_ins_ref_src_sub_code.value=rtn_ins_ref_src_sub_code;
						document.PatFinMainForm.rtn_ins_ref_src_sub_desc.value=rtn_ins_ref_src_sub_desc;
	
						document.PatFinMainForm.rtn_non_ins_ref_src_main_code.value=rtn_non_ins_ref_src_main_code;
						document.PatFinMainForm.rtn_non_ins_ref_src_main_desc.value=rtn_non_ins_ref_src_main_desc;
						document.PatFinMainForm.rtn_non_ins_ref_src_sub_code.value=rtn_non_ins_ref_src_sub_code;
						document.PatFinMainForm.rtn_non_ins_ref_src_sub_desc.value=rtn_non_ins_ref_src_sub_desc;
	
						document.PatFinMainForm.rtn_tot_valid_enc_with_gl.value=rtn_tot_valid_enc_with_gl;
						document.PatFinMainForm.rtn_tot_valid_op_enc_with_gl.value=rtn_tot_valid_op_enc_with_gl;
						document.PatFinMainForm.rtn_tot_valid_ae_enc_with_gl.value=rtn_tot_valid_ae_enc_with_gl;
						document.PatFinMainForm.rtn_tot_valid_ip_enc_with_gl.value=rtn_tot_valid_ip_enc_with_gl;
						document.PatFinMainForm.rtn_tot_valid_dc_enc_with_gl.value=rtn_tot_valid_dc_enc_with_gl;
	
						document.PatFinMainForm.rtn_tot_availed_enc_with_gl.value=rtn_tot_availed_enc_with_gl;
						document.PatFinMainForm.rtn_tot_availed_op_enc_with_gl.value=rtn_tot_availed_op_enc_with_gl;
						document.PatFinMainForm.rtn_tot_availed_ae_enc_with_gl.value=rtn_tot_availed_ae_enc_with_gl;
						document.PatFinMainForm.rtn_tot_availed_ip_enc_with_gl.value=rtn_tot_availed_ip_enc_with_gl;
						document.PatFinMainForm.rtn_tot_availed_dc_enc_with_gl.value=rtn_tot_availed_dc_enc_with_gl;
	
						document.PatFinMainForm.rtn_gl_doc_ref_exist_YN.value=rtn_gl_doc_ref_exist_YN;			
						document.PatFinMainForm.rtn_calling_function_id.value=calling_function_id;	
	
						document.PatFinMainForm.rtn_pat_ser_code.value=rtn_pat_ser_code;				
	
						if(autoFinChk=="Y" && calling_function_id != "BOOKING")
						{	   
							document.PatFinMainForm.rtn_class_type.value = rtn_class_type;
							document.PatFinMainForm.rtn_class_code.value = rtn_class_code;
							document.PatFinMainForm.rtn_remarks.value = rtn_remarks;
							document.PatFinMainForm.rtn_social_pensioner_id.value = rtn_social_pensioner_id;
							document.PatFinMainForm.rtn_inc_asset_ind.value = rtn_inc_asset_ind;
							document.PatFinMainForm.rtn_ind_inc.value = rtn_ind_inc;
							document.PatFinMainForm.rtn_ind_inc_freq.value = rtn_ind_inc_freq;
							document.PatFinMainForm.rtn_spouse_inc.value = rtn_spouse_inc;
							document.PatFinMainForm.rtn_spouse_inc_freq.value = rtn_spouse_inc_freq;
							document.PatFinMainForm.rtn_dependent_inc.value = rtn_dependent_inc;
							document.PatFinMainForm.rtn_dependent_inc_freq.value = rtn_dependent_inc_freq;
							document.PatFinMainForm.rtn_valid_from.value = rtn_valid_from;
							document.PatFinMainForm.rtn_valid_to.value = rtn_valid_to;
							document.PatFinMainForm.rtn_last_date.value = rtn_last_date;
						}
	
						var returnArray=new Array(rtn_blng_grp);
						parent.window.returnValue=returnArray;
						parent.frames[2].location.href='../../eBL/jsp/BLFinancialDetailsSubmit.jsp';
				}
			} 
		}
		catch (e)
		{
			//alert('Final Err='+e);
		}
		
	 }

}

//Authorize user on close
async function authUserOnClose()
{	
	//alert("authUserOnClose ");
	var finDtlMainTabs		= parent.parent.tab_frames.document;

	var siteSpec	=$(finDtlMainTabs).find("#siteSpec").val(); //parent.parent.frames[0].document.forms[0].siteSpec.value;
	var module_id 	= $(finDtlMainTabs).find("#calling_module_id").val(); //parent.parent.frames[0].document.forms[0].calling_module_id.value;

//		var upd_class_dtls_YN = document.forms[0].upd_class_dtls_YN.value;
		var retVal=new Array();
//		if(upd_class_dtls_YN == "N")
//		{
			var dialogHeight= "14" ;
			var dialogWidth	= "22" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s",arguments,features);
//			alert("retVal "+retVal);
//		}
//		else
//		{
//			retVal[0]="Y";
//		}
		if(retVal!=undefined)
		{
			if(retVal.length>0)
			{
				if(retVal[0]=="Y")
				{
				//	alert("authorized");
					document.forms[0].userAuthorizedOnClose.value = 'Y';
					 if(siteSpec=='true'){
						 if(module_id == "OP" || module_id == "AE"){
								var patientId = $(finDtlMainTabs).find("#patientId").val(); //parent.parent.frames[0].document.forms[0].patientId.value;
								var prevPatId = $(finDtlMainTabs).find("#prevPatId").val(); //parent.parent.frames[0].document.forms[0].prevPatId.value;

								if(!(patientId == prevPatId) && (prevPatId != '' )){
									$(finDtlMainTabs).find("#changePatAuthYN").val('Y'); //parent.parent.frames[0].document.forms[0].changePatAuthYN.value="Y"; 
								}
						 
								$(finDtlMainTabs).find("#classTypChangeAuthYN").val('Y'); //parent.parent.frames[0].document.forms[0].classTypChangeAuthYN.value="Y"; 
						 }
					 }
					
					return 'Y';
					 
					 
				}
				else{
					//alert("not authorized");
					return 'N';
				}
			}
		}
		else{
				//	alert("not authorized");
					return 'N';
		}
		
		//alert("authUser ends "+document.forms[0].blng_grp_id.value);

}

function changeOnSelectCustomer(selectObj)
{
	var cust_3 = selectObj.value;

	
	var optlength = document.forms[0].policy_type.options.length;

	for (var i=0; i<optlength; i++)
	{
		document.forms[0].policy_type.options.remove("policy_type_code");
	}

	if((cust_3=="") ||(cust_3=="select")) 
	{
		var policy_type_code	= 'select';
//		var policy_type_code = getLabel("Common.defaultSelect.label","Common");
//		var short_desc	= '         ---- Select ----         ';
		var short_desc	= '---' + getLabel("Common.defaultSelect.label","Common") + '---';
		var opt=document.createElement('OPTION'); 
		opt.text	=	short_desc; 
		opt.value	=	policy_type_code; 
		document.forms[0].policy_type.add(opt); 
		document.forms[0].policy_type.selectedIndex = 0;
		return false;
	}	


	var HTMLVal="<html><body><form name='BLPolicyCodeForm' id='BLPolicyCodeForm' method='post' action='../../eBL/jsp/BLPolicyCode.jsp'>"+
	"<input type='hidden' name='cust_code' id='cust_code' value='"+cust_3+"'>"+
	"</form></body></html>";
		
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);

	parent.parent.frames[2].document.BLPolicyCodeForm.submit();

	return true;
	
}

function confirmPasswd(obj)
{
	var usr_id=document.forms[0].user_id;
	var pass_wd=document.forms[0].passwd;
	var rmks=document.forms[0].remarks;

	var upd_fin_dtl=document.forms[0].upd_fin_dtl;

	if(upd_fin_dtl.checked==true)
		upd_fin_dtl.value='Y';
	else
		upd_fin_dtl.value='N';
						
		if(usr_id.value=="")
		{
			alert(getMessage("BL9112",'BL'));
			usr_id.focus();
			return false;
		}
		if(pass_wd.value=="")
		{
			alert(getMessage("BL9113",'BL'));
			pass_wd.focus();
			return false;
		}

		if(rmks.value=="")
		{
			alert(getMessage("BL9306",'BL'));
			rmks.focus();
			return false;
		}
		
		var HTMLVal="<html><body><form name='BLConfirmPassWdForm' id='BLConfirmPassWdForm' method='post' action='../../eBL/jsp/BLConfirmPassWd.jsp'>"+
		"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
		"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
		"<input type='hidden' name='upd_fin_dtl' id='upd_fin_dtl' value='"+upd_fin_dtl.value+"'>"+
		"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
		"</form></body></html>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[1].document.BLConfirmPassWdForm.submit();
		return true;
	//}
}

function enableAllElements()
{
	var len = parent.frames.length;
	var chkCashSet1="";
	var chkCashSet2="";
	var Case="0";	
	var rtn_slmt_ind = parent.frames[0].document.forms[0].setlmt_ind.value;
	var rtn_adm_rec_flag = parent.frames[0].document.forms[0].adm_rec_flag.value;
	if(parent.frames[0].location.href.indexOf("AddModifyPatFinDetails.jsp")!=-1)
	{
		if(parent.frames[0].name=="MainFrame1")
		{
			var no_of_ele5=parent.frames[0].document.forms[0].elements.length;
			for(var j=0;j<no_of_ele5;j++)
			{				
				parent.frames[0].document.forms[0].elements[j].disabled=false;
				disableObject(parent.frames[0].document.forms[0].elements[j]);
			}
		}
	}
	//parent.frames[0].document.forms[0].health_card_yn.disabled = true;
	if ( parent.frames[1].frames.length >0 )
	{
		if(!(rtn_slmt_ind=="X" && rtn_adm_rec_flag=="2"))
		{
		if(parent.frames[1].frames[0].location.href.indexOf("AddModifyPatFinDetails2.jsp")!=-1)
		{
			if(parent.frames[1].frames[0].name=="Frame61")
			{
				var no_of_ele2=parent.frames[1].frames[0].document.forms[0].elements.length;
				for(var j=0;j<no_of_ele2;j++)
				{
					parent.frames[1].frames[0].document.forms[0].elements[j].disabled=false;
					disableObject(parent.frames[1].frames[0].document.forms[0].elements[j]);
				}
			}
		}
		}
		if(rtn_slmt_ind=="X" && rtn_adm_rec_flag=="2")
		{
		if(parent.frames[1].frames[0].frames[1].location.href.indexOf("AddModifyPatFinDetailsInsBody.jsp")!=-1)
		{
			if(parent.frames[1].frames[0].frames[1].name=="AddModifypatFinDetailsInsBodyFrame")
			{
				var no_of_ele2=parent.frames[1].frames[0].frames[1].document.forms[0].elements.length;
				for(var j=0;j<no_of_ele2;j++)
				{
					parent.frames[1].frames[0].frames[1].document.forms[0].elements[j].disabled=false;
					disableObject(parent.frames[1].frames[0].frames[1].document.forms[0].elements[j]);
				}
			}
			if(parent.frames[1].frames[0].frames[2].name=="AddModifypatFinDetailsInsButtonFrame")
			{
				var no_of_ele2=parent.frames[1].frames[0].frames[2].document.forms[0].elements.length;
				for(var j=0;j<no_of_ele2;j++)
				{
					parent.frames[1].frames[0].frames[2].document.forms[0].elements[j].disabled=false;
					disableObject(parent.frames[1].frames[0].frames[2].document.forms[0].elements[j]);
				}
			}
		}
		}
	try
		{
			if(rtn_slmt_ind=="X" && rtn_adm_rec_flag=="2")
			{
				Case=parent.frames[1].frames[0].frames[1].document.forms[0].Case.value;
			}
			else
			{
				Case=parent.frames[1].frames[0].document.forms[0].Case.value;
			}
//			Case=parent.frames[1].frames[0].document.forms[0].Case.value;
		}
	catch (e)
	{
	}
	
	if(Case=="1")
	{
		try
		{	
			if (parent.frames[1].frames[0].document.forms[0].cash_set_type1 != null)
			{
				var chk_set_typ=parent.frames[1].frames[0].document.forms[0].cash_set_type1.value
				chkCashSet1=chk_set_typ.substring(2);
				chk_set_typ=chk_set_typ.substring(0,2);
			}
		}
		catch(e2)
		{
		}
		
	}
	if(Case=="1" && chkCashSet1 != "Y")
	{
		try
		{	
			if(parent.frames[1].frames.length>1)
			{
				if(parent.frames[1].frames[1].location.href.indexOf("AddModifyPatFinDetails4.jsp")!=-1)
				{
					if(parent.frames[1].frames[1].name=="Frame62")
					{
						var no_of_ele2=parent.frames[1].frames[1].document.forms[0].elements.length;
							for(var j=0;j<no_of_ele2;j++)
						{
							parent.frames[1].frames[1].document.forms[0].elements[j].disabled=false;
							disableObject(parent.frames[1].frames[1].document.forms[0].elements[j]);
						}
					}
				}
			}
		}
		catch(e3)
		{
		}
		
	}		
	
	if(Case=="4")
	{
		try
		{
			if ( (parent.frames[1].frames.length)>1)
			{

				if(parent.frames[1].frames[1].frames[0].location.href.indexOf("AddModifyPatFinDetails3.jsp")!=-1)
				{
					if(parent.frames[1].frames[1].frames[0].name=="frame21")
					{
						var no_of_ele3=parent.frames[1].frames[1].frames[0].document.forms[0].elements.length;
						for(var j=0;j<no_of_ele3;j++)
						{
							parent.frames[1].frames[1].frames[0].document.forms[0].elements[j].disabled=false;
							disableObject(parent.frames[1].frames[1].frames[0].document.forms[0].elements[j]);
						}
					}
				}
			}
		}
		catch(e5)
		{
		}
	}
	
	if(Case=="4")
	{
		try
		{	
			var chk_case_1=parent.frames[1].frames[1].frames[0].document.forms[0].Case_1.value;
			var chk_set_typ1="";
			if(chk_case_1=="2")
			{
				chk_set_typ1=parent.frames[1].frames[1].frames[0].document.forms[0].cash_set_type2.value
				chkCashSet2=chk_set_typ1.substring(2);
				chk_set_typ1=chk_set_typ1.substring(0,2);
				
			}
		}
		catch(e6)
		{
		}
	}
	
	if(Case=="4" && chkCashSet2 != "Y")
	{
		try
		{
			if(parent.frames[1].frames[1].frames[1].location.href.indexOf("AddModifyPatFinDetails8.jsp")!=-1)
			{
				if(parent.frames[1].frames[1].frames[1].name=="frame22")
				{
					var no_of_ele4=parent.frames[1].frames[1].frames[1].document.forms[0].elements.length;

					for(var j=0;j<no_of_ele4;j++)
					{
						parent.frames[1].frames[1].frames[1].document.forms[0].elements[j].disabled=false;
						disableObject(parent.frames[1].frames[1].frames[1].document.forms[0].elements[j]);
					}
				}
			}
		}
		catch(e7)
		{
		}

	}
	}// End of If for II frame has child frames
}
function disable1(){
var len =document.forms[0].elements.length;
var module_id = document.forms[0].calling_module_id.value;
var operation=parent.frames[0].document.forms[0].operation.value;
var booleanSecurity =parent.frames[0].document.forms[0].boolean_security.value;
var SiteSpecific=parent.frames[0].document.forms[0].SiteSpecific.value;
if(module_id== "MP" && operation== "Update" && booleanSecurity== "true"&& SiteSpecific== "Y"){
	for(var i=0;i<len;i++)
		{
	document.forms[0].elements[i].disabled=true;
		}
}
}

function disable(){
	var module_id = "";
	var operation= "";
	var booleanSecurity = "";
	var SiteSpecific = "";
	
	if(document.forms[0]!= null && document.forms[0]!= undefined ){
		var len =document.forms[0].elements.length;
		module_id = document.forms[0].calling_module_id.value;
		
		if (parent.parent.frames[0].document.forms[0] != undefined 
				&& parent.parent.frames[0].document.forms[0] != "undefined")
		{
			operation=parent.parent.frames[0].document.forms[0].operation.value;
			booleanSecurity = parent.parent.frames[0].document.forms[0].boolean_security.value;
			SiteSpecific=parent.parent.frames[0].document.forms[0].SiteSpecific.value;	
		}
		else
		{
			operation=parent.parent.parent.frames[0].document.forms[0].operation.value;
			booleanSecurity = parent.parent.parent.frames[0].document.forms[0].boolean_security.value;
			SiteSpecific=parent.parent.parent.frames[0].document.forms[0].SiteSpecific.value;
		}
		
		
		if(module_id== "MP" && operation== "Update" && booleanSecurity== "true"&& SiteSpecific== "Y"){
			for(var i=0;i<len;i++)
			{
				document.forms[0].elements[i].disabled=true;
			}
		}
	}
}

function disableAllElements()
{
	var module_id = document.forms[0].calling_module_id.value;
	var autoFinChk = document.forms[0].autoFinChk.value;
	var calling_function_id = document.forms[0].function_id.value;
	var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;
	//Added by Gayathri/V180912/GDOH-SCF-0292/Starts
	if(document.forms[0].class_type != undefined && document.forms[0].class_type != "undefined" 
		&& document.forms[0].class_type != null && document.forms[0].class_type != "null") {//Added V190304-Aravindh/KAUH-SCF-0316/if-condition
		var class_type=document.forms[0].class_type.value;
		
		if(class_type=="EX" || class_type=="SC"){
			if(document.forms[0].upd_fin_dtls.checked==true){
				document.forms[0].upd_fin_dtls.checked=false;
			}
		}
		}
//	Added by Gayathri/V180912/GDOH-SCF-0292/Ends
	var called_form = document.forms[0].name;
	var billing_mode = "";
	if( called_form == "add_modify_pat_fin_det_insmain" || called_form == "add_modify_pat_fin_det_insbut")
		billing_mode = document.forms[0].operation_mode.value;
	else
		billing_mode = document.forms[0].billing_mode.value;

	var len = document.forms[0].elements.length;

/* ************************** ADDED FOR CLASSIFICATION ENHANCEMENT ************************ */
	if(autoFinChk == "N")
	{
		for(var i=0;i<len;i++)
		{
			document.forms[0].elements[i].disabled=true;
		}
	}
	else if(autoFinChk=="Y" && calling_function_id != "BOOKING")
	{  
		for(var i=0;i<len;i++)
		{	
			if(document.forms[0].elements[i].name == "billing_group" || document.forms[0].elements[i].name == "billing_group_desc" || document.forms[0].elements[i].name == "blnggrpbut" || document.forms[0].elements[i].name=="annual_income" || document.forms[0].elements[i].name=="family_asset" || document.forms[0].elements[i].name == "no_of_dependants" || document.forms[0].elements[i].name == "cash_settl_ind")
				document.forms[0].elements[i].disabled=true;
			else
				document.forms[0].elements[i].disabled=false;
			if(document.forms[0].elements[i].name == "modify_button")
				document.forms[0].elements[i].style.visibility = "hidden"
		}
		if(document.forms[0].name=="PatFinMainForm")
		{
			var fin_class_dtls_updated_YN = document.forms[0].fin_class_dtls_updated_YN.value;

			callglholdercheck(document.forms[0].billing_group);

			if(fin_class_dtls_updated_YN == "N")
				callSettlements(document.forms[0].billing_group);
		}
	} 
/* ************************** ADDED FOR CLASSIFICATION ENHANCEMENT ************************ */
	if(document.forms[0].name=="PatFinMainForm")
	{
		document.getElementById('close_button').disabled = false;
		document.getElementById('modify_button').disabled = false;
	}

// Modified on 23-Jun-07 by manivel, to make the form fields enable on change of Encounters
// If the Primary Billing group is Insurance, PatFinCase4Form will be the last form to be loaded, so enabling the screen @ that point of time is adviced.
// If the Primary Billing group is not Insurance, PatFinCase2Form will be the last form to be loaded, so enabling the screen @ that point of time is adviced.
	
	if(document.forms[0].name == "PatFinCase4Form")
	{
		var sel_frm_prev_enc=document.forms[0].sel_frm_prev_enc.value;
		
		if(sel_frm_prev_enc=="Y")
		{
			parent.parent.parent.frames[0].document.getElementById("modify_button").click();
		}
	}

	if(document.forms[0].name == "PatFinCase2Form")
	{
		var sel_frm_prev_enc=document.forms[0].sel_frm_prev_enc.value;
		if(sel_frm_prev_enc=="Y")
		{
			parent.parent.parent.frames[0].document.getElementById('modify_button').click();
		}
	}
}


function disableModifyButton()
{		
		document.getElementById('modify_button').disabled = true;	
}

async function getPackageBill(obj1,obj2,obj3)
{
	var retVal;
	var dialogHeight= "30";
	var dialogWidth	= "50";
	var dialogTop = "75" ;
	var center = "1" ;														   
	var status="no";
	
	var pkg_bill_type = obj1;
	var pkg_bill_no = obj2;
	var patient_id = obj3;

	if (pkg_bill_type.length > 0) 
	{
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/dispPackageDetails.jsp?patient_id="+patient_id+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no;
		retVal = await window.showModalDialog(url,arguments,features);
		if(retVal==null) retVal="";
			
	}
}

function chkDtLessWithSysDate(entered_date,sys_date) 
{
	if((CheckDate(entered_date)))
	{
		var enteredDateArray; var sysDateArray;
		var enteredDate = entered_date.value ;
		var sysDate = sys_date.value;

		if(enteredDate.length > 0 && sysDate.length > 0 ) 
		{
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
			var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
			if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
			{
				//alert("Entered date cannot be greater than sys date");
				alert(getMessage("BL9114",'BL'));
//				entered_date.focus();
//				entered_date.select();
				/**
				* If the sys_date is less than the entered_date date,
				 * i.e., The Entered date is greater than the Current System Date
				* Then return false to indicate it is wrong..
				*/
				return false;
			}
			else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
		}	
		return true;
	}
}

function chkDtGreaterWithSysDate(entered_date,sys_date) 
{
	if(!(CheckDate(entered_date)))

	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)) 
		{
			//alert("Entered date cannot be Less than sys date");
			alert(getMessage("BL9115",'BL'));
//			entered_date.focus();
//			entered_date.select();
			/**
			* If the sys_date is greater than the entered_date date,
			* i.e., The Entered date is less than the Current System Date
			* Then return false to indicate it is wrong..
			*/
			return false;
		}
		else if(Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}

/** 
	The Following modification is undertaken by Murugavel.
	for the Gap Analysis Enhancements.	on 11/Aug/2002	
***/

function chkDtGreaterThanSysDate(entered_date,sys_date) 
{
	if((CheckDate(entered_date)))
	{

		var enteredDateArray; var sysDateArray;
		var enteredDate = entered_date.value ;
		var sysDate = sys_date.value;
	
		if(enteredDate.length > 0 && sysDate.length > 0 ) 
		{
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]-1);
				var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
			if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)) 
			{
				//alert("Entered date cannot be Less than sys date");
				alert(getMessage("BL8147",'BL'));
//				entered_date.focus();
//				entered_date.select();
				/**
				* If the sys_date is greater than the entered_date date,
				* i.e., The Entered date is less than the Current System Date
				* Then return false to indicate it is wrong..
				*/
				return false;
			}
			else if(Date.parse(sysDateObject) < (Date.parse(enteredDateObject))) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}	
		return true;
	}
	else
	{
		return(false);
	}
	
}

function chkDtLessEqualThanSysDate(entered_date,sys_date) 
{
	if((CheckDate(entered_date)))
	{
		var enteredDateArray; var sysDateArray;
		var enteredDate = entered_date.value ;
		var sysDate = sys_date.value;
	
		if(enteredDate.length > 0 && sysDate.length > 0 ) 
		{
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]-1);
				var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
			if(Date.parse(sysDateObject) <=  Date.parse(enteredDateObject)) 
			{
				//alert("Entered date cannot be Less than sys date");
				alert(getMessage("BL9114",'BL'));
//				entered_date.focus();
//				entered_date.select();
				/**
				* If the sys_date is greater than the entered_date date,
				* i.e., The Entered date is less than the Current System Date
				* Then return false to indicate it is wrong..
				*/
				return false;
			}
			else if(Date.parse(sysDateObject) > (Date.parse(enteredDateObject))) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}	
		return true;
	}
	else
	{
		return(false);
	}
	
}

function chkDtLessEqualThanSysDateNew(entered_date,sys_date)
{
	var locale=document.forms[0].locale.value;
	
	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var sysDate = sys_date.value;
			if(isBeforeNow(enteredDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9114",'BL'));
//				entered_date.select();
				return false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkDtGreaterEqualThanSysDateNew(entered_date,sys_date)
{
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var sysDate = sys_date.value;
			if(isAfterNow(enteredDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9115",'BL'));
//				entered_date.select();
				return false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkDtLessEqualThanEncDateNew(entered_date,encounter_date,close_call_check)
{
	var locale=document.forms[0].locale.value;
	if(close_call_check == "undefined" || close_call_check == null) close_call_check="";
	
	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var encounterDate = encounter_date.value;
			if(isBefore(enteredDate,encounterDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				if(close_call_check == "Y")
				{
					return false;
				}
				else
				{
					alert(getMessage("BL9876","BL"));
//					entered_date.select();
					return false;
				}
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			//entered_date.select();
			entered_date.value='';
			entered_date.focus();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkDtGreaterEqualThanEncDateNew(entered_date,encounter_date,close_call_check)
{
	var locale=document.forms[0].locale.value;
	if(close_call_check == "undefined" || close_call_check == null) close_call_check="N";

	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var encounterDate = encounter_date.value;
			if(isAfter(enteredDate,encounterDate,'DMY',locale))
			{
				return true;
			}
			else
			{
//				alert(getMessage("BL9115",'BL'));
				if(close_call_check == "Y")
				{
					return false;
				}
				else
				{
					alert(getMessage("BL9877","BL"));
//					entered_date.select();
					return false;
				}
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			//entered_date.select();
			entered_date.value='';
			entered_date.focus();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkPolicyEffFromDate(policy_eff_frm_date,policy_eff_to_date,start_date,exp_date,encounter_date,payer_desc,policy_desc)
{
	var locale=document.forms[0].locale.value;
	var module_id =document.forms[0].calling_module_id.value; 
	var eff_frm_date=policy_eff_frm_date.value;
	var eff_to_date=policy_eff_to_date.value;
	if(payer_desc == undefined || payer_desc == "undefined" || payer_desc == null) payer_desc="";
	if(policy_desc == undefined || policy_desc == "undefined" || policy_desc == null) payer_desc="";

	if(eff_frm_date!="")
	{
		if((validDate(policy_eff_frm_date.value,'DMY',locale)))
		{
			var start_date = start_date.value ;
			var exp_date = exp_date.value;
			var encounterDate = encounter_date.value;
			if(eff_to_date == "") eff_to_date=exp_date;
		
			if(start_date=="" || exp_date=="")
			{
				if(payer_desc !="" && policy_desc !="")
				{
					if(start_date=="")
					{
						alert(getMessage("BL9567","BL")+":"+payer_desc+"/"+policy_desc);
					}
					else if(exp_date=="")
					{
						alert(getMessage("BL9568","BL")+":"+payer_desc+"/"+policy_desc);
					}
					return false;
				}
				else
				{
					if(start_date=="")
					{
						alert(getMessage("BL9324","BL"));
					}
					else if(exp_date=="")
					{
						alert(getMessage("BL9105","BL"));
					}
					policy_eff_frm_date.focus();
//					policy_eff_frm_date.select();
					return false;
				}
			}
			else
			{
				if(start_date.length > 0 && exp_date.length > 0 ) 
				{
					if(payer_desc !="" && policy_desc !="")
					{
						if(!isBetween(start_date,exp_date,eff_frm_date,'DMY',locale))
						{
							//Added by Rajesh V - If Logic
							if(module_id!='MP'){
								alert(getMessage("BL8220","BL")+":"+payer_desc+"/"+policy_desc);
								return false;
							}
							
						}

						if(module_id == "MP")
						{
							if(!isBeforeNow(eff_frm_date,'DMY',locale))
							{
								var confirm_yn = confirm(getMessage("BL8215","BL")+":"+payer_desc+"/"+policy_desc);
								if(!confirm_yn)
								{
									return false;
								}
							}
						}
						else if(module_id == "IP" || module_id == "DC")
						{
							if(!isBefore(eff_frm_date,encounter_date.value,'DMY',locale))
							{
								var confirm_yn = confirm(getMessage("BL8215","BL")+":"+payer_desc+"/"+policy_desc);
								if(!confirm_yn)
								{
									return false;
								}
							}
						}
						else
						{
							if(!isBetween(eff_frm_date,eff_to_date,encounterDate,'DMY',locale))
							{
								alert(getMessage("BL8222","BL")+":"+payer_desc+"/"+policy_desc);
								return false;
							}
						}
					}
					else
					{
						if(!isBetween(start_date,exp_date,eff_frm_date,'DMY',locale))
						{
							//Added by Rajesh V - If Logic
							if(module_id!='MP'){
								alert(getMessage("BL8220","BL"));
//								policy_eff_frm_date.select();
								return false;
							}
							
						}

						if(module_id == "MP")
						{
							if(!isBeforeNow(eff_frm_date,'DMY',locale))
							{
								var confirm_yn = confirm(getMessage("BL8215","BL"));
								if(!confirm_yn)
								{
//									policy_eff_frm_date.select();
									return false;
								}
							}
						}
						else if(module_id == "IP" || module_id == "DC")
						{
							if(!isBefore(eff_frm_date,encounter_date.value,'DMY',locale))
							{
								var confirm_yn = confirm(getMessage("BL8215","BL"));
								if(!confirm_yn)
								{
									return false;
								}
							}
						}
						else
						{
							if(!isBetween(eff_frm_date,eff_to_date,encounterDate,'DMY',locale))
							{
								alert(getMessage("BL8222","BL"));
//								policy_eff_frm_date.select();
								return false;
							}
						}
					}
				}
			}
			return true;
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			policy_eff_frm_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkPolicyEffToDate(policy_eff_to_date,policy_eff_frm_date,exp_date,encounter_date,payer_desc,policy_desc)
{
	var eff_to_date=policy_eff_to_date.value;
	var locale=document.forms[0].locale.value;
	if(payer_desc == "undefined" || payer_desc == null) payer_desc="";
	if(policy_desc == "undefined" || policy_desc == null) payer_desc="";
	
	if(eff_to_date!="")
	{
		if((validDate(policy_eff_to_date.value,'DMY',locale)))
		{
			var eff_frm_date = policy_eff_frm_date.value ;
			var exp_date = exp_date.value;
			var encounterDate = encounter_date.value;

			if(eff_frm_date=="" || exp_date=="")
			{
				if(payer_desc !="" && policy_desc !="")
				{
					if(eff_frm_date=="") 
					{
						alert(getMessage("BL9569","BL")+":"+payer_desc+"/"+policy_desc);
					}
					else if(exp_date=="")
					{
						alert(getMessage("BL9570","BL")+":"+payer_desc+"/"+policy_desc);
					}
					return false;
				}
				else
				{
					if(eff_frm_date=="") 
					{
						alert(getMessage("BL9565","BL"));
					}
					else if(exp_date=="")
					{
						alert(getMessage("BL9105","BL"));
					}
//					policy_eff_to_date.select();
					return false;
				}
			}
			else
			{
				if(eff_frm_date.length > 0 && exp_date.length > 0 ) 
				{
					if(payer_desc !="" && policy_desc !="")
					{
						if(!isBetween(eff_frm_date,exp_date,eff_to_date,'DMY',locale))
						{
							alert(getMessage("BL8221","BL")+":"+payer_desc+"/"+policy_desc);
							return false;
						}	
					}
					else
					{
						if(!isBetween(eff_frm_date,exp_date,eff_to_date,'DMY',locale))
						{
							alert(getMessage("BL8221","BL"));
//							policy_eff_to_date.select();
							return false;
						}	
					}
				}	
				return true;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			policy_eff_to_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date,payer_desc,policy_desc)
{
	var locale=document.forms[0].locale.value;
	if(payer_desc == "undefined" || payer_desc == null) payer_desc="";
	if(policy_desc == "undefined" || policy_desc == null) policy_desc="";
	var module_id = document.forms[0].calling_module_id.value;

	if(policy_start_date.value != "")
	{
		if((validDate(policy_start_date.value,'DMY',locale)))
		{
			if(policy_exp_date.value != "")
			{
				if(!isBefore(policy_start_date.value,policy_exp_date.value,"DMY",locale))
				{
					if(payer_desc != "" && policy_desc != "")
					{
						alert(getMessage("BL8216","BL")+":"+payer_desc+"/"+policy_desc);
						return false;
					}
					else
					{
						alert(getMessage("BL8216","BL"));
//						policy_start_date.select();
						return false;
					}
				}
			}

			if(module_id == "MP")
			{
				if(!isBeforeNow(policy_start_date.value,"DMY",locale))
				{
					if(payer_desc != "" && policy_desc != "")
					{
						var confirm_yn = confirm(getMessage("BL8214","BL")+":"+payer_desc+"/"+policy_desc);
						if(!confirm_yn)
						{
							return false;
						}
					}
					else
					{
						var confirm_yn = confirm(getMessage("BL8214","BL"));
						if(!confirm_yn)
						{
//							policy_start_date.select();
							return false;
						}
					}
				}
			}
			else if(module_id == "IP" || module_id == "DC")
			{
				if(!isBefore(policy_start_date.value,encounter_date.value,"DMY",locale))
				{
					if(payer_desc != "" && policy_desc != "")
					{
						var confirm_yn = confirm(getMessage("BL8214","BL")+":"+payer_desc+"/"+policy_desc);
						if(!confirm_yn)
						{
							return false;
						}
					}
					else
					{
						var confirm_yn = confirm(getMessage("BL8214","BL"));
						if(!confirm_yn)
						{
//							policy_start_date.select();
							return false;
						}
					}
				}
			}
			else
			{
				if(!isBefore(policy_start_date.value,encounter_date.value,"DMY",locale))
				{
					if(payer_desc != "" && policy_desc != "")
					{
						alert(getMessage("BL9880","BL")+":"+payer_desc+"/"+policy_desc);
						return false;
					}
					else
					{
						alert(getMessage("BL9880","BL"));
//						policy_start_date.select();
						return false;
					}
				}
			}
			return true;
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date,payer_desc,policy_desc)
{
	var locale=document.forms[0].locale.value;
	if(payer_desc == "undefined" || payer_desc == null) payer_desc="";
	if(policy_desc == "undefined" || policy_desc == null) policy_desc="";
	var module_id = document.forms[0].calling_module_id.value;

	if(policy_exp_date.value != "")
	{
		if(validDate(policy_exp_date.value,'DMY',locale))
		{
			if(policy_start_date.value == "")
			{
				if(payer_desc != "" && policy_desc != "")
				{
					alert(getMessage("BL9324","BL")+":"+payer_desc+"/"+policy_desc);
					return false;
				}
				else
				{
					alert(getMessage("BL9324","BL"));
//					policy_exp_date.select();
					return false;
				}
			}
			else
			{
				if(!isAfter(policy_exp_date.value,policy_start_date.value,"DMY",locale))
				{
					if(payer_desc != "" && policy_desc != "")
					{
						alert(getMessage("BL8217","BL")+":"+payer_desc+"/"+policy_desc);
						return false;
					}
					else
					{
						alert(getMessage("BL8217","BL"));
//						policy_exp_date.select();
						return false;
					}
				}
				if( module_id == "MP")
				{
					if(!isAfterNow(policy_exp_date.value,"DMY",locale))
					{
						if(payer_desc != "" && policy_desc != "")
						{
							var confirm_yn = confirm(getMessage("BL8226","BL")+":"+payer_desc+"/"+policy_desc);
							if(!confirm_yn)
							{
								return false;
							}
						}
						else
						{
							var confirm_yn = confirm(getMessage("BL8226","BL"));
							if(!confirm_yn)
							{
//								policy_exp_date.select();
								return false;
							}
						}
					}
				}
				else
				{
					if(!isBefore(encounter_date.value,policy_exp_date.value,"DMY",locale))
					{
						if(payer_desc != "" && policy_desc != "")
						{
							alert(getMessage("BL8223","BL")+":"+payer_desc+"/"+policy_desc);
							return false;
						}
						else
						{
							alert(getMessage("BL8223","BL"));
//							policy_exp_date.select();
							return false;
						}
					}
				}
			}
			return true;
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			policy_start_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkCreditAuthDate(credit_auth_date,payer_desc,policy_desc)
{
	var locale=document.forms[0].locale.value;
	if(payer_desc == "undefined" || payer_desc == null) payer_desc="";
	if(policy_desc == "undefined" || policy_desc == null) policy_desc="";
	if(credit_auth_date.value != "")
	{
		if(validDate(credit_auth_date.value,'DMY',locale))
		{
/*
			if(!isBeforeNow(credit_auth_date.value,"DMY",locale))
			{
				if(payer_desc != "" && policy_desc != "")
				{
					alert(getMessage("BL8224","BL")+":"+payer_desc+"/"+policy_desc);
					return false;
				}
				else
				{
					alert(getMessage("BL9114","BL"));
					credit_auth_date.select();
					return false;
				}
			}
*/ // Commented for CRF-534.1
			return true;
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			credit_auth_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date)
{
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			return true;
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function makeUpperCase()
{
	if( (event.keyCode > 96) && (event.keyCode < 123) )
	{
		event.keyCode = event.keyCode - 32;
	}
	return true;
}

function put_decimal(obj)
{
	if(obj.value!='')
	{
		putDecimal(obj,17,2);
	}
}

function put_decimal(obj,deci)
{
	if(obj.value!='')
	{
		putDecimal(obj,17,deci);
	}
}


function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}

async function validate_upd_pat_fin_dtls(rtn_patient_id,rtn_facility_id,blng_grp,rtn_slmt_ind,slmt_type_code,cust_code,rtn_ins_policy_type_code,rtn_ins_cust_priority,rtn_non_ins_blng_grp,rtn_non_ins_cust_code,priority_array,ins_blng_grp_code_arr)
	{
		var retVal;
		var dialogHeight= "22" ;
		var dialogWidth	= "65" ;
		var dialogTop = "400" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + " ; scroll=no; status: " + status + "; dialogTop :" + dialogTop;

		var arguments	= "" ;
		var title=getLabel("eBL.UPD_PAT_FIN_DTLS_VALIDATE.label","BL");
		title=encodeURIComponent(title);
		var url="../../eBL/jsp/BLUpdPatFinDtlsValidateSubmit.jsp?title="+title+"&patient_id="+rtn_patient_id+"&facility_id="+rtn_facility_id+"&blng_grp="+encodeURIComponent(blng_grp)+"&slmt_ind="+rtn_slmt_ind+"&slmt_type_code="+slmt_type_code+"&cust_code="+encodeURIComponent(cust_code)+"&rtn_ins_policy_type_code="+encodeURIComponent(rtn_ins_policy_type_code)+"&ins_priority="+rtn_ins_cust_priority+"&non_ins_blng_grp="+encodeURIComponent(rtn_non_ins_blng_grp)+"&non_ins_cust_code="+encodeURIComponent(rtn_non_ins_cust_code);

		retVal = await window.showModalDialog(url,arguments,features);
		
		if(retVal != null)
		{
			if(retVal[0]=="2")
			{
				var invalid_payer_priority=retVal[1];
				var invalid_ins_blng_grp=retVal[2];
				var invalid_payer_priority_arr=new Array();
				var invalid_ins_blng_grp_arr=new Array();
				var priority_arr=priority_array;

				if(invalid_payer_priority != "")
				{
					invalid_payer_priority_arr=invalid_payer_priority.split("|");
					var check_var1="";
				
					for(var i=0;i<invalid_payer_priority_arr.length;i++)
					{
						for(var k=0;k<priority_arr.length;k++)
						{
							if(parseInt(invalid_payer_priority_arr[i]) == parseInt(priority_arr[k]))
							{
								check_var1="row"+parseInt(k);
							
								for (var j=0;j<parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows.length;j++)
								{						
									if(parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].id == check_var1)
									{
										parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells(0).className='RED';
										check_var1="@@@";
									}
								}
							}
						}
					}
				}
				if(invalid_ins_blng_grp != "")
				{
					invalid_ins_blng_grp_arr=invalid_ins_blng_grp.split("|");
					for(var i=0;i<invalid_ins_blng_grp_arr.length;i++)
					{
						for(var j=0;j<ins_blng_grp_code_arr.length;j++)
						{
							if(invalid_ins_blng_grp_arr[i] == ins_blng_grp_code_arr[j])
							{
								var ins_blng_grp_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].billing_group_desc"+j);
								ins_blng_grp_code1.className='BACKGROUND';
							}
						}
					}
				}
				return 'N';
			}
		}
		else
		{
			return 'N';
		}
	}

// This Function has been copied from Common JS file as we needed the last four sepcial characters to be allowed(/-. )
function CheckForSpecChars_local(event)
{
	//var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-. ';  // added by sarathkumar ML-MMOH-SCF-0659...
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.@,()\'\ ';  // added by sarathkumar ML-MMOH-SCF-0659...
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
//	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
//		return (event.keyCode -= 32);
	return true ;
}
// This Function has been copied from Common JS file as we needed the last three sepcial characters to be allowed(/-.) for ASCII code 45,46,47,32
function CheckChars_local(Obj)
{
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++)
		{
          //if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42) ||(str.charCodeAt(u)==42) ||((str.charCodeAt(u)>=45) && (str.charCodeAt(u)<=47)) || (str.charCodeAt(u)==32)); // added by sarathkumar ML-MMOH-SCF-0659...
        	if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=64) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42) ||(str.charCodeAt(u)==42) ||((str.charCodeAt(u)>=44) && (str.charCodeAt(u)<=47)) || (str.charCodeAt(u)==32) ||  (str.charCodeAt(u)==39)  ||  ((str.charCodeAt(u)>=40) && (str.charCodeAt(u)<=41)) ); // added by sarathkumar ML-MMOH-SCF-0659...
        	else
			{
                specCharsExist = false;
                break;
            }
        }
        return specCharsExist;
}

function roundNumber(num, dec)
{
	var result = Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
}

function callglholdercheck(obj,cald_frm)
{			
	var patient_id = document.forms[0].patient_id.value;						
	var mblnggroup = document.forms[0].mblnggroup.value;
	var calling_module_id = document.forms[0].calling_module_id.value;
	var customer_id = document.forms[0].customer_id.value;	

	if (mblnggroup != obj.value )
		document.forms[0].blnggrpappyn.value = 'Y';

	parent.frames[2].location.href='../../eBL/jsp/BLPatGlHolderCheck.jsp?billing_group='+obj.value+'&patient_id='+patient_id+'&calling_module_id='+calling_module_id+'&cald_frm='+cald_frm+'&customer_id='+customer_id;
}

function chk_for_entry(obj,obj1,obj2)
{
	if(obj.value != "")
	{
		obj1.disabled = false;
		obj2.disabled = false;
	}
	else
	{
		obj1.value = "";
		obj1.disabled = true;
		obj2.disabled=true;
	}
}

function CheckForSpecCharsAllNotAlwSpc_local(event)
{
    var strCheck = '~`!@#$%^&()=+[]{}\\|;:,<>?\'\"';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	return false ;
}

function CheckCharsAllLang_local(Obj)
{
        var str = Obj.value;
        var specCharsExist = true;
	    var strCheck = '~`!@#$%^&()=+[]{}\\|;:,<>?\'\"';
        for (var i=0;i<str.length;i++)
		{
			for(var j=0;j<strCheck.length;j++)
			{
				if(str.substring(i,i+1) == strCheck.substring(j,j+1))
				{
					specCharsExist = false;
					break;
				}
			}
		}
		return specCharsExist;
}

function enableLinks(){
if(parent.frames[0].document.getElementById('pkgAssociateSubs') != null)
{
	parent.frames[0].document.getElementById('pkgAssociateSubs').style.display="inline";
}
}

function validate(){
	
	enableAllElements();
	if(document.forms[0].valid_pkg_for_pat_bg_avail_YN.value == "Y")
	{
		parent.frames[0].document.getElementById('vw_pkg_dtl_disp').style.display="inline";
	}
	if(parent.frames[0].document.getElementById('pkgAssociateSubs') != null)
	{
		parent.frames[0].document.getElementById('pkgAssociateSubs').style.display="inline";
	}
	if(parent.frames[0].document.getElementById('sel_frm_prev_enc_disp') != null)
	{
		parent.frames[0].document.getElementById('sel_frm_prev_enc_disp').style.display="inline";
	}
//	if(document.forms[0].third_party_gl_in_use_yn.value == "Y")
//	{
	if ( parent.frames[1].frames.length >0 )
	{
		if(parent.frames[1].frames[0].location.href.indexOf("AddModifyPatFinDetails2.jsp")!=-1)
		{
			if(parent.frames[1].frames[0].name=="Frame61")
			{
				var calling_module_id =parent.frames[0].document.forms[0].calling_module_id.value;
				var function_id = parent.frames[0].document.forms[0].function_id.value;

				if(calling_module_id!="MP" && calling_module_id!="BOOKING")
				{
					var settlement_ind = parent.frames[1].frames[0].document.forms[0].setlmt_ind.value;
					var adm_rec_flag = parent.frames[1].frames[0].document.forms[0].adm_rec_flag.value;
					var gl_doc_ref_exist_YN = parent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value;

					if(settlement_ind=='R' || (settlement_ind=='X' &&  adm_rec_flag=='1'))
					{
						if(gl_doc_ref_exist_YN == 'Y')
						{
							if(settlement_ind == 'R')
							{
								parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled = true;
								parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled = true;
							}
							else if(settlement_ind == 'X' && adm_rec_flag == "1")
							{
								parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled = true;
								parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled = true;
							}
							parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled = true;
							parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled = true;
							parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled = true;
							parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled = true;
							parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled = true;
						}
						else
						{
							if(settlement_ind == 'R')
							{
								parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled = false;
								parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled = false;
							}
							else if(settlement_ind == 'X' && adm_rec_flag == "1")
							{
								parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled = true;
								parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled = true;
							}
							parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled = false;
							parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled = false;
							parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled = false;
							parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled = false;
							parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled = false;
						}
					}
				}
				
				if(calling_module_id =="OP" || calling_module_id =="IP")
				{
					var settlement_ind = parent.frames[1].frames[0].document.forms[0].setlmt_ind.value;
					var adm_rec_flag = parent.frames[1].frames[0].document.forms[0].adm_rec_flag.value;
					var package_enabled_yn = parent.frames[1].frames[0].document.forms[0].package_enabled_yn.value;
					
					if(package_enabled_yn == 'Y')
					{
						if(settlement_ind == 'R')
						{
							if(parent.frames[1].frames[0].document.forms[0].cust_group_code_1 !== "" && parent.frames[1].frames[0].document.forms[0].cust_1 !== "")
							{
								if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
								{
									parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
								}
								else
								{
									parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="none";
								}
							}
						}
						else if(settlement_ind == 'X' && adm_rec_flag == "1")
						{
							if(parent.frames[1].frames[0].document.forms[0].cust_group_code_2 !== "" && parent.frames[1].frames[0].document.forms[0].cust_2 !== "")
							{
								if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
								{
									parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
								}
								else
								{
									parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="none";
								}
							}
						}
						else if(settlement_ind == 'C')
						{
							if(parent.frames[1].frames[0].document.getElementById('pkg_disc_disp') != null)
							{
								parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="inline";
							}
							else
							{
								parent.frames[1].frames[0].document.getElementById('pkg_disc_disp').style.display="none";
							}
						}
					}
				}
			}
		}
	}
//	}

	var bill_grp=parent.frames[0].document.forms[0].billing_group;
	var upd_fin_dtls=parent.frames[0].document.forms[0].upd_fin_dtls;
	var remarks=parent.frames[0].document.forms[0].remarks;
	var fin_auth_user_id=parent.frames[0].document.forms[0].fin_auth_user_id;
//	upd_fin_dtls.value=retVal[1];
//	remarks.value=retVal[2];
//	fin_auth_user_id.value=retVal[3];
	try
	{
		bill_grp.focus();
	}
	catch(e)
	{
	}
	
	//parent.frames[0].document.forms[0].modify_button.disabled=true;

	try
	{
		// Added on May'10'2004 for the HMC disabling even after auth.
		var bl_data_from_repos_yn = document.forms[0].bl_data_from_repos_yn.value;
		var calling_module_id = document.forms[0].calling_module_id.value;

		if (  (bl_data_from_repos_yn == 'Y')  && ( calling_module_id == 'MP') )
		{
			document.forms[0].blnggrpbut.disabled = true;
			try
			{
				parent.frames[1].frames[0].document.forms[0].cust1but.disabled=true;
			}
			catch(e)
			{

			}

		}
	}
	catch(e)
	{
	}

	
}

function chkEffDatesOverlap(policy1_eff_frm_date,policy1_eff_to_date,policy2_eff_frm_date,policy2_eff_to_date)
{
	var locale=document.forms[0].locale.value;

	var module_id = document.forms[0].calling_module_id.value;

	if(policy1_eff_frm_date != "" && policy1_eff_to_date != "" && policy2_eff_frm_date != "" && policy2_eff_to_date != "")
	{
		if((validDate(policy1_eff_frm_date,'DMY',locale)) && (validDate(policy1_eff_to_date,'DMY',locale)) && (validDate(policy2_eff_frm_date,'DMY',locale)) && (validDate(policy2_eff_to_date,'DMY',locale)))
		{
			if(policy2_eff_frm_date != "")
			{
				if(isBefore(policy2_eff_frm_date,policy1_eff_to_date,"DMY",locale))
				{
					return false;
				}
				else
				{
					return true;
				}
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			return false;
		}
	}
	else
	{
		return true;
	}
}
function findtl()
{
	

var pat_regn_date_time='';
var billing_group='';
var confirmFlag='';
var pat_id=document.formSalesHeader.patient_id.value;
var module=document.formSalesHeader.module_id.value;

var params ='&calledFrom=modify_fin'+'&operation=Update'+
'&patient_id='+pat_id+'&module_id_new='+module+'&calling_module=MP'+'&calling_function_id=PAT_REG';


$.ajax({
	type:"GET",
	url:"../../eBL/jsp/BLModifyFinDetails.jsp",
	data:params,
	dataType:"text",
	async:false,
	success: function(data){
	var pat_regn_date_time=$.trim(data);
	
		$.ajax({
			type:"GET",
			url:"../../eBL/jsp/BLFinDetHiddenFlds.jsp",
			data:params,
			dataType:"text",
			async:false,
			success: function(data){
				
			},
			error: function(data){
				
		      }
			
		});
		
		
	},
	 error: function(data){
		
      }
});

var qryStr="operation="+"Update"+"&upd_pat_flag="+"N"+"&show_hide_blng_class="+"SHOW"+"&billing_mode="+"Modify";
qryStr += "&calling_module_id="+"MP"+"&calling_function_id="+"PAT_REG";
qryStr += "&bl_data_from_repos_yn="+"N"+"&data_source_id="+""+"&patient_id="+document.formSalesHeader.patient_id.value;
qryStr+="&nationality_yn="+"Y";	
qryStr+="&pat_regn_date_time="+pat_regn_date_time;	
qryStr+="&patient_class="+"XT"+"&pat_ser_code="+"";

var returnArray = new Array();   
returnArray = getFinDtl(qryStr);


if(returnArray!=undefined)
{


		var param_values ='&calledFrom=modify_fin1'+'&operation=Update'+
		'&patient_id='+pat_id+'&blng_grp='+returnArray;
		
				$.ajax({
			type:"GET",
			url:"../../eBL/jsp/BLModifyFinDetails.jsp",
			data:param_values,
			dataType:"text",
			async:false,
			success: function(data){
				var data1=$.trim(data);
			
				parent.frameSalesDetail.location.href="../../eBL/jsp/BLSessionValuesReset.jsp?&fin_dtls_reset=Y";
				parent.frameSalesDetail.location.reload();
				
		
				
			},
			 error: function(data){
				
		      }
		});
		

}
}

async function blUHIDBillchk(patient_id,function_id,module_id,pat_ser_code){
	


var params="";

var returnvalue='';
params="&patient_id="+patient_id+"&function_id="+function_id+"&module_id=MP"+"&str_pat_ser_code="+pat_ser_code+"&episode_type=R";

$.ajax({
	type:"POST",
	url:"../../servlet/eBL.BLUHIDBillInvokeServlet?"+params,
	async: false,
	success: async function(data){
		
		
		var retVal = trimString(data).split("::");
			var errorFlag=retVal[0];

			
			if(errorFlag=='N'){
			var str_bill_gen_later=retVal[1];
			var bill_gen_later=retVal[2];
			var str_blng_grp=retVal[3];
			var called_frm=retVal[4];
			var bill_doc_type=retVal[7];
			var bill_doc_number=retVal[8];
			var retValue = "";
			var dialogHeight = "40";
			var dialogWidth = "70";
			var dialogTop = "100";
			var center = "1";
			var status = "no";
			var column_sizes = escape("");
			var column_descriptions = "";
			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments = "";
			var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_number + "&blng_grp=" + str_blng_grp + "&module_id=MP"+"&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&call_disc_function_yn="+str_bill_gen_later+"&function_id="+function_id+"&episode_type=R"+"&called_frmUHID=Y";
			retValue = await window.showModalDialog(url, arguments, features);
			while(retValue==undefined){
	retValue = await window.showModalDialog(url, arguments, features);
			}
			returnvalue='Y';

			}

	else 
	{

	var error_txt=retVal[2];
	var msg_id=retVal[1];

	if(msg_id!='' && msg_id !='null')
		
		{
			alert(getMessage(msg_id,"BL"));
			returnvalue='N';
		
		}

	else if (error_txt !='' && error_txt !='null'){
		
		alert(error_txt);
		returnvalue='N';
	}
	}
		
		},
		error: function(data){	
	    }
	});

return returnvalue;
	
}

/* Added V190508-Aravindh/GHL-CRF-0553/Starts */
async function blngGrpCatgLookUp(clng_evnt) {
	var docForm = document.forms[0];
	var facilityId = docForm.facility_id.value;
	var locale = docForm.locale.value;
	var billingGroupCatDesc = docForm.billingGroupCatDesc;
	var billingGroupCatDescHid = docForm.billingGroupCatDescHid;
	var billingGroupCatCode = docForm.billingGroupCatCode;
	var slmtIndicator = docForm.slmtIndicator;
	var payerGrpBySetup = docForm.payerGrpBySetup;
	
	if(clng_evnt == "B") {
		if(billingGroupCatDesc.value == "") {
			billingGroupCatDesc.value = "";
			billingGroupCatCode.value = "";
			return;
		}
	}
	
	var dialogTop              = "40";
    var dialogHeight           = "10" ;
    var dialogWidth                   = "40" ;
    var features               = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments              = "" ;
    var title = "Billing Group Category";
    var column_sizes = escape("50%,50%");
    
    var column_descriptions = 'Description' + ',' + 'Code' + "," + 'Customer Group' + ',' + 'Customer Code' + "," + 'Customer' + ',' + 'Episode Type';
    
    var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YYYYYY&" +
                         "target="+billingGroupCatDesc.value+"&facilityId="+facilityId+"&locale="+locale;
    
    var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=BILLING_CATG_LOOKUP&"+param,arguments,features);
    
    retVal = unescape(retVal);
    if(retVal != undefined && retVal !="undefined")
    {
		var retArray = retVal.split("^~^");
		if(billingGroupCatCode.value == retArray[1] && billingGroupCatDescHid.value == retArray[0]) {
			return;
		}
		billingGroupCatDesc.value = retArray[0];
		billingGroupCatDescHid.value = retArray[0];
		billingGroupCatCode.value = retArray[1];
		docForm.billing_group_desc.value = "";
		docForm.billing_group.value = "";
		slmtIndicator.value = "";
		if(payerGrpBySetup.value == "Y") {
			blnggrplkupNew('B');
		} else {
			blnggrplkup('B');
		}
    } else {
    	billingGroupCatDesc.value = "";
    	billingGroupCatDescHid.value = "";
    	billingGroupCatCode.value = "";
    }
}

function clearBlngGrpVal() {
	var docForm = document.forms[0];
	/*docForm.billingGroupCatDesc.value = "";
	docForm.billingGroupCatCode.value = "";*/
	docForm.billing_group_desc.value = "";
	docForm.billing_group.value = "";
}

var count='0';//Added against GHL-SCF-1478
function getBlngGrpCategory(blngGrpId) {
	var frm = document.PatFinMainForm;
	var billing_group = frm.billing_group.value;
	var billing_flag = frm.billing_flag.value;//Added against GHL-SCF-1478
	if (billing_group.length > 0) {
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getBlngGrpCatByBlngGrp&blngGrpId=" + billing_group;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		responseText = responseText.split(":::");

		 if(frm != 'undefined' && frm != undefined && billing_flag=="Y" && count!="0") //Added billing_flag & count against GHL-SCF-1478
		 {
			frm.billingGroupCatCode.value = responseText[0];
			frm.billingGroupCatDesc.value = responseText[1];
			if(responseText[2] == "ZZ") {
				responseText[2] = "";
			}
 			frm.slmtIndicator.value = responseText[2]; 
	  }
	} else {
		 frm.billingGroupCatCode.value = "";
		frm.billingGroupCatDesc.value = "";
		frm.slmtIndicator.value = ""; 
	}
}
/* Added V190508-Aravindh/GHL-CRF-0553/Ends */
/* Added V190522-Aravindh/NMC-JD-CRF-0010/Starts */
function validateApprovedPolicyYN(payerGroupCode, payerCode, policyTypeCode, facilityId) {
	//alert(payerGroupCode.value+", "+payerCode.value+", "+policyTypeCode.value+", "+ facilityId);
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validatePolicyApproved&facilityId=" + facilityId 
					+"&payerGroupCode="+payerGroupCode.value+"&payerCode="+payerCode.value+"&policyTypeCode="+policyTypeCode.value;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);

	if(responseText == "true") {
		return true;
	} else {
		return false;
	}
}
/* Added V190522-Aravindh/NMC-JD-CRF-0010/Ends */
/* Added V190820-Aravindh/GHL-CRF-0523/Starts */
function capturePatBedCategory(mode) {
	var frm = document.PatFinMainForm;
	if(frm != 'undefined' && frm != undefined) {
		var capturePatBedCat = frm.capture_pat_bed_cat.value;
		if("Auth" == mode && "Y" != capturePatBedCat) {
			frm.patient_bed_category.disabled = true;
			frm.patbedcat_but.disabled = true;
			return;
		}
		
		var billing_group = frm.billing_group.value;
		var facilityId = frm.facility_id.value;
		if (billing_group.length > 0) {
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=capturePatBedCategory&blngGrpId=" + billing_group + "&facilityId=" + facilityId;
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send();
			var responseText = trimString(xmlHttp.responseText);
			responseText = responseText.split(":::");
			frm.capture_pat_bed_cat.value = responseText[1];
			if(responseText[1] != "Y") {
				frm.patient_bed_category.disabled = true;
				frm.patbedcat_but.disabled = true;
			} else {
				frm.patient_bed_category.disabled = false;
				frm.patbedcat_but.disabled = false;
			}
		} else {
			frm.capture_pat_bed_cat.value = "N";
		}
	}
}
/* Added V190820-Aravindh/GHL-CRF-0523/Ends */
//Added V190801-Gayathri/GHL-CRF-0523
async function patbedcat(obj)
{	
	var locale = document.forms[0].locale.value;
	var target = document.forms[0].patient_bed_category;
	var facility_id = document.forms[0].facility_id.value;	

	var message="";
	var retVal				= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";
	var title=getLabel("eBL.PATIENT_BED_CATEGORY.label","BL"); 
	title=encodeURIComponent(title);		
	sql = "SELECT bed_catg_code bed_catg_code,long_desc long_desc FROM bl_patient_bed_catg WHERE operating_facility_id = '"+facility_id+"' ";
	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	column_descriptions = code+","+desc;
	sql=escape(sql);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+"&"+"sql="+sql+"&target="+encodeURIComponent(obj.value);

	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null)) {
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");
		target.value=arr[1];
		document.forms[0].rtn_patient_bed_category.value=arr[0];
	} else {
		target.value='';
	}
}

//Added V191218-Aravindh/GHL-CRF-0599/Starts
function validateBillingGroup() {
	var frm = document.PatFinMainForm;
	if(frm != 'undefined' && frm != undefined) {

	var billing_group 	= frm.billing_group.value;
	var locale 			= frm.locale.value;

	if (billing_group.length > 0) {
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateBillingGroup&blngGrpId=" + billing_group;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		responseText = responseText.split(":::");
		var validBlngGrp = responseText[1];
		var validFromDate = responseText[2];
		var todayDate = responseText[3];
		var validToDate = responseText[4];
		if(validBlngGrp != "Y") {
			if(isAfter(validFromDate, todayDate, 'DMY', locale)) {
				//var msg = getMessage("BL0876","BLEXT");
					var msg = "APP-BL0876 Billing group was valid from '$' to '#'. Hence, couldn't be selected. Pl contact IT dept";
				msg = msg.replace("$",validFromDate);
				msg = msg.replace("#",validToDate);
				alert(msg);
				return false;
			} else {
				//var msg = getMessage("BL0875","BLEXT");
				var msg = "APP-BL0875 Billing group duration expired on '$'. Hence, couldn't be selected. Pl contact IT dept";
				msg = msg.replace("$",validToDate);
				alert(msg);
				return false;
			}
		} else {
			return true;
		}
	} else {
		return true;
	}
	} else {
	return true;
	}
}
//Added V191218-Aravindh/GHL-CRF-0599/Ends

//V220908
function validateClaimMCN(ins_cust_group_code){
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getMCNMandYN&custGrpCode=" + ins_cust_group_code;
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", temp_jsp, false);
        xmlHttp.send();
       var retVal = trimString(xmlHttp.responseText);
	   return retVal;		
}
//V220908

//V221027
function CheckForSpecChars_loc(event,obj){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function CheckForSpecChar(event,obj){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length!=0)
	{
		for(var i=0;i<obj.value.length;i++){
			var curChar = obj.value.charAt(i);
			var chck=strCheck.indexOf(curChar) ;
	
			if(chck==-1){
				alert(getMessage("BL8510", 'BL'));
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}
	return true ;
}
//V221027

