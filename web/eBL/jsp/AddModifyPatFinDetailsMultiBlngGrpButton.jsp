<!DOCTYPE html>
<%
/*
Sr No        Version            Incident          SCF/CRF             Developer Name
1           V232504							SKR-SCF-1731-TF         Namrata Charate
*/
%>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<%
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;

	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		//System.err.println("querstring  in grpbutton.jsp page:"+request.getQueryString());	
		String nd_settlement_ind ="", nd_adm_rec_flag ="",ins_auth_flag="";
		String package_enabled_yn="N";//added for package Billing
//Unused Var's

//		String slmt_type_code="", cash_slmt_flag="", cust_code1="";
//		String strSettlementDesc = "0";
//		String mcust_group_1="";

		String mcash_set_type1="", mcust_1="",  mcredit_doc_ref1="", mcredit_doc_date1="", mcredit_doc_start_date1="", mcust_2="";
		String mcredit_doc_ref2="", mcredit_doc_date2="",mcredit_doc_start_date2="", mcust_3="", mpolicy_type="", mpolicy_no="";
		String mpolicy_expiry_date="", mnon_insur_blng_grp="", sys_date="", sys_date_wht_sec="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="";	

		String fin_class_flag_YN="N",autoFinChk="N",class_code="",class_blng_grp_id="";

//		if( billing_group == null) billing_group="";
		String primary_blng_grp=request.getParameter("primary_blng_grp");
		if(primary_blng_grp == null) primary_blng_grp="";
		String facility_id = (String)httpSession.getValue("facility_id");
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";	
		String billing_group=request.getParameter("billing_group");
		if(billing_group == null) billing_group="";
		String rtn_non_ins_blng_grp="", encounter_date_time = ""; 
		String queryString=(request.getQueryString());
		String p_patient_class=request.getParameter("patient_class");
		String policy_coverage_basis_gbl_ind_from_main=request.getParameter("policy_coverage_basis_gbl_ind_from_main");
		if(policy_coverage_basis_gbl_ind_from_main==null) policy_coverage_basis_gbl_ind_from_main="";

		String str_max_priority=request.getParameter("max_priority");
		if(str_max_priority == null || str_max_priority.equals("")) str_max_priority="0";

		int max_priority=Integer.parseInt(str_max_priority);

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

//		System.out.println("encounter_date_time from Interface Module in MultiBlngGrpButton.jsp:"+encounter_date_time);		
/*
		if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) &&(primary_blng_grp.equals("")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp=((String)bl_data.get("non_ins_blng_grp")).trim();
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");		
		}
*/
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String bl_future_admn_YN="";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

//Unused Var's
/*
		String strCategory = "";
		String str_blng_grp_id = "";
		String str_short_desc = "";	

		String cust_code_1 = "";
		String short_name_1 = "";

		String cust_code_2 = "";
		String short_name_2 = "";
*/
		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
					sys_date_wht_sec = rs4.getString(2);
				}
			}
			if(rs4 != null) rs4.close();
			stmt.close();
/*
			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt.close();
*/
		}
		catch(Exception e)
		{
			out.println("Exception in sysdate query :"+e);
		}

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		if(!patient_id.equals(""))
		{
			String sqlCiti = "select citizen_yn from mp_patient where patient_id = ? ";
			pstmt = con.prepareStatement(sqlCiti);
			pstmt.setString(1,patient_id);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();	
		}
/*
		String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N'),to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') last_enc_bg from bl_mp_param ";
		pstmt = con.prepareStatement(sql0);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
				sys_date = rs2.getString(3);
				sys_date_wht_sec = rs2.getString(4);
			}
		}
		if(rs2 != null) rs2.close();
		pstmt.close();		

		if ( strdfltbgyn == null) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null) srtencdfltbgyn="N";

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

		bl_future_admn_YN=request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";

		
		String sqlstr="select credit_doc_ref_desc, to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date, to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date, cust_code, settlement_ind, decode(non_ins_blng_grp_id,null,decode(settlement_ind,'X',1,0),2) adm_rec_flag from bl_patient_fin_dtls where patient_id = ? ";
		
		pstmt = con.prepareStatement(sqlstr);
		pstmt.setString(1,patient_id);
		rs5 = pstmt.executeQuery();
		if( rs5 != null ) 
		{
			while( rs5.next() )
			{  
				l_credit_doc_ref_desc =  rs5.getString("credit_doc_ref_desc");
				l_credit_doc_ref_start_date =  rs5.getString("credit_doc_ref_start_date");
				l_credit_doc_ref_date =  rs5.getString("credit_doc_ref_date");
				l_cust_code =  rs5.getString("cust_code");			
				l_slmt_ind = rs5.getString("settlement_ind");			
				l_adm_rec_flag = rs5.getString("adm_rec_flag");			
			}
		}
		if(rs5 != null) rs5.close();
		pstmt.close();

		if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		if (l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
		if (l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
		if (l_cust_code == null) l_cust_code = "";
		if (l_slmt_ind == null) l_slmt_ind = "";
		if (l_adm_rec_flag == null) l_adm_rec_flag = "";	

		if (strshowHideBlngClass == null) strshowHideBlngClass = "";

		String strCreditDoc_YN="N";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");
		String strFunctionId=request.getParameter("calling_function_id");
		String strExtSettlType ="";
		String strSettlTypeOverride ="";		

		nationalityyn = request.getParameter("nationality_yn");		
		
	    if (nationalityyn == null) nationalityyn = "";	
		
		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
			strdfltbgyn = "Y";
		}

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}
		if(strFunctionId==null)
		{
			strFunctionId="";
		}
		
		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
		{	
			System.out.println("Inside the Future Admn Check in InsButton.jsp");
			strdfltbgyn="Y";
		}

		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{

			String strTempFunId = request.getParameter("id_fun");
			if (strTempFunId== null)
			{
				strExtSettlType = request.getParameter("cash_set_type1");	
			}
			else if (strTempFunId.equals("1"))
			{
				strExtSettlType = request.getParameter("set_typ_from_frame1");	

			}
		
			if (strExtSettlType == null)
			{
				strExtSettlType = "";
			}
			try
			{
				StringTokenizer strTokenizer = new StringTokenizer(strItemsDisabled,"|");
				String strTotData = "";
				int intIdx = 0;
				String strColumn="";
				String strOverride ="N";
				while(strTokenizer.hasMoreElements())
				{	
					strTotData = strTokenizer.nextToken();
					intIdx = strTotData.indexOf("-");
					strColumn = strTotData.substring(0,intIdx);
					strOverride = strTotData.substring(intIdx+1);
					if (strColumn.equals("cash_set_type1")) 
					{
						if (strOverride.equals("N"))
						{
							strSettlTypeOverride = "N";
						}
						else 
						{
							strSettlTypeOverride = "Y";
						}
					}
				}
			}
			catch(Exception excep)
			{
			}

		}

		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("EM")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{

			mcash_set_type1		= request.getParameter("cash_set_type1");
			if ( mcash_set_type1 == null ) mcash_set_type1 ="";			
			

			mcust_1				= request.getParameter("cust_1");
			if (mcust_1 == null) mcust_1 = "";
			

			mcredit_doc_ref1	= request.getParameter("credit_doc_ref1");
			if ( mcredit_doc_ref1 == null ) mcredit_doc_ref1 = "";	
			

			mcredit_doc_date1	= request.getParameter("credit_doc_date1");
			if ( mcredit_doc_date1 == null ) mcredit_doc_date1 ="";			


			mcredit_doc_start_date1	= request.getParameter("credit_doc_start_date1");
			if ( mcredit_doc_start_date1 == null ) mcredit_doc_start_date1 = "";

			

			mcust_2				= request.getParameter("cust_2");
			if ( mcust_2 == null ) mcust_2 = "";			

			mcredit_doc_ref2	= request.getParameter("credit_doc_ref2");
			if ( mcredit_doc_ref2 == null ) mcredit_doc_ref2 = "";

			mcredit_doc_date2	= request.getParameter("credit_doc_date2");
			if ( mcredit_doc_date2 == null ) mcredit_doc_date2 = "";
			

			mcredit_doc_start_date2	= request.getParameter("credit_doc_date0");
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			if(mcredit_doc_start_date2.equals(""))
			{
			mcredit_doc_start_date2	= request.getParameter("credit_doc_start_date2");
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			}
				
			
			mcust_3	= request.getParameter("cust_3");
			if ( mcust_3 == null ) mcust_3 = "";

			mpolicy_type		= request.getParameter("policy_type");
			if ( mpolicy_type == null ) mpolicy_type = "";
			

			mpolicy_no			= request.getParameter("policy_no");
			if ( mpolicy_no == null ) mpolicy_no ="";

			mpolicy_expiry_date = request.getParameter("policy_expiry_date");
			if ( mpolicy_expiry_date == null ) mpolicy_expiry_date = "";
			

//			mnon_insur_blng_grp = request.getParameter("non_insur_blng_grp");
			mnon_insur_blng_grp = rtn_non_ins_blng_grp;
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			mcredit_auth_ref	= request.getParameter("credit_auth_ref");
			if ( mcredit_auth_ref == null ) mcredit_auth_ref = "";

			
			mcredit_auth_date	= request.getParameter("credit_auth_date");
			if ( mcredit_auth_date == null ) mcredit_auth_date = "";			

			mapp_days			= request.getParameter("app_days");
			if  ( mapp_days == null ) mapp_days = ""; 

			mapp_amount			= request.getParameter("app_amount");
			if ( mapp_amount == null ) mapp_amount = "";

			meff_frm_date		= request.getParameter("eff_frm_date");
			if ( meff_frm_date == null ) meff_frm_date = "";

			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			visit_type_code		= request.getParameter("visit_type_code");
			if ( visit_type_code == null ) visit_type_code = "";

		}		

		if((mpolicy_type==null) || (mpolicy_type.equals("null")))
		mpolicy_type = java.net.URLEncoder.encode(mpolicy_type);
		

		if((mcredit_auth_ref==null) || (mcredit_auth_ref.equals("null"))) mcredit_auth_ref="";
		if((mcredit_auth_date==null) || (mcredit_auth_date.equals("null"))) mcredit_auth_date="";
		if((mapp_days==null) || (mapp_days.equals("null"))) mapp_days="";
		if((mapp_amount==null) || (mapp_amount.equals("null"))) mapp_amount="";
		if((meff_frm_date==null) || (meff_frm_date.equals("null"))) meff_frm_date="";
		if((clinic_code==null) || (clinic_code.equals("null"))) clinic_code="";
		if((visit_type_code==null) || (visit_type_code.equals("null"))) visit_type_code="";



		String sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,billing_group);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_settlement_ind = rs.getString("settlement_ind");
				nd_adm_rec_flag = rs.getString("adm_rec_flag");
				strCreditDoc_YN = rs.getString(3);

			}
		}
		if(rs != null) rs.close();
		pstmt.close();

		if(nd_settlement_ind==null)nd_settlement_ind="";
		if(nd_adm_rec_flag==null)nd_adm_rec_flag="";	
		

		if (l_slmt_ind.equals(nd_settlement_ind) && (nd_adm_rec_flag.equals(l_adm_rec_flag) ||l_slmt_ind.equals("C")||l_slmt_ind.equals("R")))
		{
			if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		}
		else
		{
			l_credit_doc_ref_desc = "";
			l_credit_doc_ref_start_date = "";
			l_credit_doc_ref_date = "";
			l_cust_code = "";
			l_slmt_ind = "";
			l_adm_rec_flag = "";		
		}	

		
%>
<head>

<script>
var totalRecords=0;
var formObj="";
var total_records="";
var checked_row="";
var blng_grp_code="";
var blng_grp_desc="";
var payer_desc="";
var cust_3="";
var priority="";
var policy_type_desc="";
var policy_type_code="";
var policy_no="";
var policy_start_date="";
var policy_exp_date="";
var credit_auth_ref="";
var credit_auth_date="";
var credit_apprd_amt="";
var credit_apprd_days="";
var policy_eff_frm_date="";
var policy_eff_to_date="";	
var adj_rule_ind="";;
var adj_perc_amt_ind="";
var adj_perc_amt_value="";
var pmnt_diff_adj_int="";
var drg_pmnt_diff_adj_int="";
var spl_srv_pmnt_diff_adj_int="";
var restrict_check="",apprd_amt_restrict_check="",apprd_days_restrict_check="";
var cred_auth_req_yn = "", dflt_auth_ref_as_pol_no_yn="", cred_auth_mand_capt_yn="";
var valid_payer_YN="";
var valid_policy_type_code_YN="";
var cust_group_code="";
var cust_group_name = "";
var policy_coverage_basis_ind="";
var cust_valid_from_date = "";
var cust_valid_to_date = "";
var pol_validity_chk_date="";

var v_display_hide="",v_display_hide_apprvd_amt="",v_display_hide_apprvd_days="";
var v_display_hide_cred_auth="";

var mcn_for_policy=""; //V232504
var reg_ref_id=""; //V232504

 //Added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check
	var payerEligibilityParam="";
	var responseCode="";
	var responseCodeDesc="";
	var statuDescription="";
	var validityPeriod="";
	var validityPeriodDesc="";
	var eligibilityCode="";
	var transactionId="";
	var responseDateTime="";
 //above variables were added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check

async function addPayer()
{
	var package_enabled_yn = document.forms[0].package_enabled_yn.value;	

	var locale=document.forms[0].locale.value;
	var retVal			= new String();

	formObj = parent.frames[1].document.forms[0];
	total_records=formObj.total_records.value;

	var encounter_date_time = document.forms[0].encounter_date_time.value;

	var priority="";

	var max_priority=document.forms[0].max_priority.value;

	var priority_arr=new Array();

	if(parseInt(total_records) != 0)
	{
		var priority_var="";
		for(var i=0;i<total_records;i++)
		{
			var priority1=eval("parent.frames[1].document.forms[0].priority"+i);
			priority_var=priority1.value;
			
			priority_arr[i]=priority_var;
		}
	}
	
	var priority="";
	if(parseInt(total_records)==0)
	{
		priority=parseInt(max_priority)+1;
	}

	/* var dialogTop			= "220";
//	var dialogHeight		= "22" ;
//	var dialogWidth			= "40" ;
	var dialogHeight		= "25" ;
	var dialogWidth			= "55" ; */
	
	var dialogTop			= "5vh";
	var dialogHeight		= "92vh" ;
	var dialogWidth			= "90vw" ; 

	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ADD_PAYER.label","BL");
	title=encodeURIComponent(title);
//	var column_sizes = escape("10%,30%,60%");
//	var column_descriptions="";
	var calling_module_id = document.forms[0].calling_module_id.value;	
	var getString=document.forms[0].queryString.value;
	var p_patient_class=document.forms[0].p_patient_class.value;
	var billing_group=document.forms[0].billing_group.value;

	var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;
	var autoFinChk = document.forms[0].autoFinChk.value;
	var class_code = document.forms[0].class_code.value;

	formObj = parent.frames[1].document.forms[0];
	totalRecords =eval(formObj.total_records.value);

	for(var j=0;j<totalRecords;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}

	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	//Commented by DhanasekarV against incident AAKH-SCF-0028   38536	on 1/4/2014

	
/*	if(policy_coverage_basis_gbl_ind=="P")
	{
		if(totalRecords==1)
		{
			alert(getMessage("BL9727","BL"));
			return false;
		}
	}
	*/

	//END
	
	parent.frames[1].document.forms[0].target = "InsValidationFrame";
	parent.frames[1].document.forms[0].action="../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add&locn=inside";
	parent.frames[1].document.forms[0].submit();

	parent.frames[1].document.forms[0].target = "";

	var param ="&title="+title+"&action=add&locn=inside"+"&patient_class="+p_patient_class+"&billing_group="+billing_group+"&calling_module_id="+calling_module_id+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&totalRecords="+totalRecords+"&priority_arr="+priority_arr+"&priority="+priority+"&max_priority="+max_priority+"&encounter_date_time="+encounter_date_time+"&fin_class_flag_YN="+fin_class_flag_YN+"&autoFinChk="+autoFinChk+"&class_code="+class_code+"&package_enabled_yn="+package_enabled_yn;
	
	retVal=await parent.window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?"+param,arguments,features);

	var count=0;
	var classval="";
	var	billing_grp="";
	if(retVal!=null)
	{
		formObj = parent.frames[1].document.forms[0];
		totalRecords =eval(formObj.total_records.value);
		count =totalRecords + 1; 
		billing_grp=document.forms[0].billing_group.value;
		var arr=new Array();
		if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);
					  
			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");	
				blng_grp_desc=decodeURIComponent(arr[0]);
				blng_grp_code=decodeURIComponent(arr[1]);
				payer_desc=decodeURIComponent(arr[2]);
				cust_3=decodeURIComponent(arr[3]);
				priority=arr[4];
				policy_type_desc=decodeURIComponent(arr[5]);
				policy_type_code=decodeURIComponent(arr[6]);
				policy_no=decodeURIComponent(arr[7]);
				policy_start_date=arr[8];
				policy_exp_date=arr[9];
				credit_auth_ref=decodeURIComponent(arr[10]);
				if(credit_auth_ref == null || credit_auth_ref==" ") credit_auth_ref="";
				credit_auth_date=arr[11];
				if(credit_auth_date == null || credit_auth_date==" ") credit_auth_date="";
				cred_auth_req_yn = arr[33];
				cred_auth_mand_capt_yn = arr[40];
				dflt_auth_ref_as_pol_no_yn=arr[34];

				var temp_credit_apprd_amt=arr[12];
				if(temp_credit_apprd_amt==" ") temp_credit_apprd_amt="";
				credit_apprd_amt=temp_credit_apprd_amt;
				
				var temp_credit_apprd_days=arr[13];
				if(temp_credit_apprd_days==" ") temp_credit_apprd_days="";
				credit_apprd_days=temp_credit_apprd_days;
				
				policy_eff_frm_date=arr[14];
				
				var temp_policy_eff_to_date=arr[15];
				if(temp_policy_eff_to_date==" ") temp_policy_eff_to_date="";
				policy_eff_to_date=temp_policy_eff_to_date;
				
				adj_rule_ind=decodeURIComponent(arr[16]);
				adj_perc_amt_ind=decodeURIComponent(arr[17]);
				adj_perc_amt_value=decodeURIComponent(arr[18]);
				pmnt_diff_adj_int=decodeURIComponent(arr[19]);
				drg_pmnt_diff_adj_int=decodeURIComponent(arr[20]);
				spl_srv_pmnt_diff_adj_int=decodeURIComponent(arr[21]);
				restrict_check=arr[22];
				apprd_amt_restrict_check=arr[31];
				apprd_days_restrict_check=arr[32];
				valid_payer_YN=arr[23];
				valid_policy_type_code_YN=arr[24];
				cust_group_code=decodeURIComponent(arr[25]);
				cust_group_name=decodeURIComponent(arr[37]);
				policy_coverage_basis_ind=arr[26];

				cust_valid_from_date = arr[35];
				cust_valid_to_date = arr[36];

				pol_validity_chk_date = arr[38];

				payerEligibilityParam= decodeURIComponent(arr[41]);
				responseCode= decodeURIComponent(arr[42]);
				responseCodeDesc= decodeURIComponent(arr[43]);
				statuDescription= decodeURIComponent(arr[44]);
				validityPeriod= decodeURIComponent(arr[45]);
				validityPeriodDesc= decodeURIComponent(arr[46]);
				eligibilityCode= decodeURIComponent(arr[47]);
				transactionId= decodeURIComponent(arr[48]);
				responseDateTime= decodeURIComponent(arr[49]);
				
				mcn_for_policy=decodeURIComponent(arr[51]);     //V232504
				reg_ref_id=decodeURIComponent(arr[52]);     //V232504
				

				if(locale!="en")
				{
					if(policy_start_date!="")
						policy_start_date=convertDate(policy_start_date,"DMY","en",locale);

					if(policy_exp_date!="")
						policy_exp_date=convertDate(policy_exp_date,"DMY","en",locale);
					
					if(credit_auth_date!="")
						credit_auth_date=convertDate(credit_auth_date,"DMY","en",locale);
					
					if(policy_eff_frm_date!="")
						policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY","en",locale);
					
					if(policy_eff_to_date!="")
						policy_eff_to_date=convertDate(policy_eff_to_date,"DMY","en",locale);

					if(pol_validity_chk_date!="")
						pol_validity_chk_date=convertDate(pol_validity_chk_date,"DMY","en",locale);
				}
			}
		}

		if(restrict_check=="U")
		{
			v_display_hide="display:none";
			v_display_hide_apprvd_amt = "display:none";
			v_display_hide_apprvd_days = "display:none";
		}
		else if (restrict_check=="R")
		{
			if(apprd_amt_restrict_check == "R")
			{
				v_display_hide_apprvd_amt = "display:inline";
			}
			else
			{
				v_display_hide_apprvd_amt = "display:none";
			}

			if(apprd_days_restrict_check == "R")
			{
				v_display_hide_apprvd_days = "display:inline";
			}
			else
			{
				v_display_hide_apprvd_days = "display:none";
			}
		}

		if(cred_auth_req_yn == "Y")
		{
			v_display_hide_cred_auth = "display:inline";
		}
		else
		{
			v_display_hide_cred_auth = "display:none";
		}

		var record_select=count;
		for (var j=totalRecords;j<count;j++ )
		{
//			if(j!=0)
//				blng_grp_desc="";
			
			if(j % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}

			curr_row	=	formObj.ins_data.insertRow();
			curr_row.id= "row"+eval(totalRecords+1);

			cell	=	curr_row.insertCell();
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].WIDTH	= "14%";
//			curr_row.cells(0).insertAdjacentHTML("BeforeEnd", "<input type=hidden name='blng_grp_code"+j+"' id='blng_grp_code"+j+"' value='"+billing_grp+"'><a onClick='modify_remove_payer("+j+");'><u>"+record_select+"</u></a>");
			curr_row.cells[0].insertAdjacentHTML("beforeend", "<input type=hidden name='blng_grp_code"+j+"' id='blng_grp_code"+j+"' value=\""+blng_grp_code+"\"><input type=hidden name='billing_group_desc"+j+"' id='billing_group_desc"+j+"' value=\""+blng_grp_desc+"\"><input type='checkbox' name='selected_row"+j+"' id='selected_row"+j+"' value='"+j+"' onClick='selected("+j+")'>&nbsp;&nbsp;<input maxlength='15' size='13' type=text name='ins_cust_group_name"+j+"' id='ins_cust_group_name"+j+"'  value=\""+cust_group_name+"\" onFocus='check("+j+");' readonly>");

			cell	=	curr_row.insertCell();
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].WIDTH	= "12%";
			curr_row.cells[1].insertAdjacentHTML("beforeend", "<input maxlength='15' size='13' type=text name='payer_desc"+j+"' id='payer_desc"+j+"'  value=\""+payer_desc+"\" onFocus='check("+j+");' readonly><input type=hidden name='cust_3"+j+"' id='cust_3"+j+"' value=\""+cust_3+"\"><input type=hidden name='ins_cust_group_code"+j+"' id='ins_cust_group_code"+j+"' value=\""+cust_group_code+"\"><input type=hidden name='valid_payer_YN"+j+"' id='valid_payer_YN"+j+"' value=\""+valid_payer_YN+"\"><input type=hidden name='cust_valid_from_date"+j+"' id='cust_valid_from_date"+j+"' value=\""+cust_valid_from_date+"\"><input type=hidden name='cust_valid_to_date"+j+"' id='cust_valid_to_date"+j+"' value=\""+cust_valid_to_date+"\">");

			cell	=	curr_row.insertCell();
			curr_row.cells[2].className	=classval;
			curr_row.cells[2].WIDTH	= "7%";
			curr_row.cells[2].insertAdjacentHTML("beforeend", "<input type='text' maxlength='2' size='3' name='priority"+j+"' id='priority"+j+"' style='text-align:right'  value='"+priority+"' onFocus='check("+j+");' readonly>");

			cell	=	curr_row.insertCell();
			curr_row.cells[3].className	=classval;
			curr_row.cells[3].WIDTH	= "12%";
			curr_row.cells[3].insertAdjacentHTML("beforeend", "<input maxlength='15' size='13' type=text name='policy_type_desc"+j+"' id='policy_type_desc"+j+"'  value=\""+policy_type_desc+"\" onFocus='check("+j+");' readonly><input type=hidden name='policy_type_code"+j+"' id='policy_type_code"+j+"' value=\""+policy_type_code+"\"><input type=hidden name='valid_policy_type_code_YN"+j+"' id='valid_policy_type_code_YN"+j+"' value=\""+valid_policy_type_code_YN+"\">");

			cell	=	curr_row.insertCell();
			curr_row.cells[4].className	= classval;
			curr_row.cells[4].WIDTH	= "12%";
			curr_row.cells[4].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='13' name='policy_no"+j+"' id='policy_no"+j+"' 	style='text-align:right'  value=\""+policy_no+"\" onFocus='check("+j+");' readonly>");

			cell	=	curr_row.insertCell();
			curr_row.cells[5].className	= classval;
			curr_row.cells[5].WIDTH	= "10%";
			curr_row.cells[5].insertAdjacentHTML("beforeend","<input type='text'  name='policy_start_date"+j+"' id='policy_start_date"+j+"' size='10' maxlength='10' value='"+policy_start_date+"'  onFocus='check("+j+");' readonly>");
		

			cell	=	curr_row.insertCell();
			curr_row.cells[6].className	= classval;
			curr_row.cells[6].WIDTH	= "10%";
			curr_row.cells[6].insertAdjacentHTML("beforeend","<input type='text'  name='policy_exp_date"+j+"' id='policy_exp_date"+j+"' size='10' maxlength='10' 	value='"+policy_exp_date+"'  onFocus='check("+j+");' readonly>");

			cell	=	curr_row.insertCell();
			curr_row.cells[7].className	= classval;
			curr_row.cells[7].WIDTH	= "12%";
			curr_row.cells[7].insertAdjacentHTML("beforeend", "<div id='credit_auth_val_disp"+j+"' style="+v_display_hide_cred_auth+" ><input type='text' maxlength='20' size='13' name='credit_auth_ref"+j+"' id='credit_auth_ref"+j+"' style='text-align:right'  value=\""+credit_auth_ref+"\" onFocus='check("+j+");' readonly></div>");

			cell	=	curr_row.insertCell();
			curr_row.cells[8].className	= classval;
			curr_row.cells[8].WIDTH	= "11%";
			curr_row.cells[8].insertAdjacentHTML("beforeend","<div id='credit_auth_date_val_disp"+j+"' style="+v_display_hide_cred_auth+" ><input type='text'  name='credit_auth_date"+j+"' id='credit_auth_date"+j+"' size='10' maxlength='10' value='"+credit_auth_date+"'  onFocus='check("+j+");' readonly></div>");

			curr_row	=	formObj.ins_data.insertRow();
			curr_row.id= "row"+eval(totalRecords+1);

			cell	=	curr_row.insertCell();
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].WIDTH	= "14%";
			curr_row.cells[0].insertAdjacentHTML("beforeend", "<b id='policy_coverage_basis_"+j+"'></b>");

			cell	=	curr_row.insertCell();
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].WIDTH	= "12%";
			curr_row.cells[1].insertAdjacentHTML("beforeend", "<div id='apprd_amt_leg_disp"+j+"' style="+v_display_hide_apprvd_amt+" ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div>");
			
			cell	=	curr_row.insertCell();
			curr_row.cells[2].className	= classval;
			curr_row.cells[2].WIDTH	= "7%";
			curr_row.cells[2].insertAdjacentHTML("beforeend", "<div id='apprd_amt_val_disp"+j+"' style="+v_display_hide_apprvd_amt+" ><input type='text' maxlength='10' size='7' name='credit_apprd_amt"+j+"' id='credit_apprd_amt"+j+"' style='text-align:right'  value='"+credit_apprd_amt+"' onFocus='check("+j+");' readonly></div>");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[3].className	= classval;
			curr_row.cells[3].WIDTH	= "12%";
			curr_row.cells[3].insertAdjacentHTML("beforeend", "<div id='apprd_days_leg_disp"+j+"' style="+v_display_hide_apprvd_days+" ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div>");

			cell	=	curr_row.insertCell();
			curr_row.cells[4].className	= classval;
			curr_row.cells[4].WIDTH	= "12%";
			curr_row.cells[4].insertAdjacentHTML("beforeend", "<div id='apprd_days_val_disp"+j+"' style="+v_display_hide_apprvd_days+" ><input type='text' maxlength='4' size='4' name='credit_apprd_days"+j+"' id='credit_apprd_days"+j+"' style='text-align:right'  value='"+credit_apprd_days+"' onFocus='check("+j+");' readonly></div>");

			cell	=	curr_row.insertCell();
			curr_row.cells[5].className	= classval;
			curr_row.cells[5].WIDTH	= "10%";
			curr_row.cells[5].insertAdjacentHTML("beforeend", "<fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/>");

			cell	=	curr_row.insertCell();
			curr_row.cells[6].className	= classval;
			curr_row.cells[6].WIDTH	= "10%";
			curr_row.cells[6].insertAdjacentHTML("beforeend","<input type='text'  name='policy_eff_frm_date"+j+"' id='policy_eff_frm_date"+j+"' size='10' maxlength='10' value='"+policy_eff_frm_date+"'  onFocus='check("+j+");' readonly>");

			cell	=	curr_row.insertCell();
			curr_row.cells[7].className	= classval;
			curr_row.cells[7].WIDTH	= "12%";
			curr_row.cells[7].insertAdjacentHTML("beforeend", "<fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/>");

			cell	=	curr_row.insertCell();
			curr_row.cells[8].className	= classval;
			curr_row.cells[8].WIDTH	= "11%";
			curr_row.cells[8].insertAdjacentHTML("beforeend","<input type='text'  name='policy_eff_to_date"+j+"' id='policy_eff_to_date"+j+"' size='10' maxlength='10' value='"+policy_eff_to_date+"' onFocus='check("+j+");' readonly><input type=hidden name='adj_rule_ind"+j+"' id='adj_rule_ind"+j+"' value=\""+adj_rule_ind+"\"><input type=hidden name='adj_perc_amt_ind"+j+"' id='adj_perc_amt_ind"+j+"' value=\""+adj_perc_amt_ind+"\"><input type=hidden name='adj_perc_amt_value"+j+"' id='adj_perc_amt_value"+j+"' value=\""+adj_perc_amt_value+"\"><input type=hidden name='pmnt_diff_adj_int"+j+"' id='pmnt_diff_adj_int"+j+"' value=\""+pmnt_diff_adj_int+"\"><input type=hidden name='drg_pmnt_diff_adj_int"+j+"' id='drg_pmnt_diff_adj_int"+j+"' value=\""+drg_pmnt_diff_adj_int+"\"><input type=hidden name='spl_srv_pmnt_diff_adj_int"+j+"' id='spl_srv_pmnt_diff_adj_int"+j+"' value=\""+spl_srv_pmnt_diff_adj_int+"\"><input type=hidden name='restrict_check"+j+"' id='restrict_check"+j+"' value=\""+restrict_check+"\"><input type=hidden name='apprd_amt_restrict_check"+j+"' id='apprd_amt_restrict_check"+j+"' value=\""+apprd_amt_restrict_check+"\"><input type=hidden name='apprd_days_restrict_check"+j+"' id='apprd_days_restrict_check"+j+"' value=\""+apprd_days_restrict_check+"\"><input type=hidden name='policy_coverage_basis_ind"+j+"' id='policy_coverage_basis_ind"+j+"' value='"+policy_coverage_basis_ind+"'><input type=hidden name='cred_auth_req_yn"+j+"' id='cred_auth_req_yn"+j+"' value='"+cred_auth_req_yn+"'><input type=hidden name='cred_auth_mand_capt_yn"+j+"' id='cred_auth_mand_capt_yn"+j+"' value='"+cred_auth_mand_capt_yn+"'><input type=hidden name='dflt_auth_ref_as_pol_no_yn"+j+"' id='dflt_auth_ref_as_pol_no_yn"+j+"' value='"+dflt_auth_ref_as_pol_no_yn+"'><input type=hidden name='pol_validity_chk_date"+j+"' id='pol_validity_chk_date"+j+"' value='"+pol_validity_chk_date+"'><input type=hidden name='rec_edited_YN"+j+"' id='rec_edited_YN"+j+"' value='Y'><input type=hidden name='payer_suspended_YN"+j+"' id='payer_suspended_YN"+j+"' value='N'><input type=hidden name='policy_suspended_YN"+j+"' id='policy_suspended_YN"+j+"' value='N'>");


			cell	=	curr_row.insertCell();
		curr_row.cells[9].className	= classval;
			curr_row.cells[9].WIDTH	= "10%";
			curr_row.cells[9].insertAdjacentHTML("beforeend","<input type=hidden name='payerEligibilityParam"+j+"' id='payerEligibilityParam"+j+"' value=\""+payerEligibilityParam+"\"> <input type=hidden name='responseCode"+j+"' id='responseCode"+j+"' value=\""+responseCode+"\"> <input type=hidden name='responseCodeDesc"+j+"' id='responseCodeDesc"+j+"' value=\""+responseCodeDesc+"\"> <input type=hidden name='statuDescription"+j+"' id='statuDescription"+j+"' value=\""+statuDescription+"\"> <input type=hidden name='validityPeriod"+j+"' id='validityPeriod"+j+"' value=\""+validityPeriod+"\"> <input type=hidden name='validityPeriodDesc"+j+"' id='validityPeriodDesc"+j+"' value=\""+validityPeriodDesc+"\"> <input type=hidden name='eligibilityCode"+j+"' id='eligibilityCode"+j+"' value=\""+eligibilityCode+"\"> <input type=hidden name='transactionId"+j+"' id='transactionId"+j+"' value=\""+transactionId+"\"> <input type=hidden name='responseDateTime"+j+"' id='responseDateTime"+j+"' value=\""+responseDateTime+"\"> <input type=hidden name='mcn_for_policy"+j+"' id='mcn_for_policy"+j+"' value=\""+mcn_for_policy+"\"> <input type=hidden name='reg_ref_id"+j+"' id='reg_ref_id"+j+"' value=\""+reg_ref_id+"\">"); //V232504

		record_select++;
		v_display_hide="";
		v_display_hide_apprvd_amt="";
		v_display_hide_apprvd_days="";
//		var temp=eval('parent.frames[1].document.forms[0].ins_cust_group_name'+j);
//		var temp1=eval('parent.frames[1].document.forms[0].ins_cust_group_code'+j);
//		alert(temp.value);
//		alert(temp1.value);
		}
		formObj.total_records.value=count;
		if(formObj.total_records.value==1)
		{
			parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind;
		}
		parent.frames[1].policy_coverage_basis_ind();

//		alert("total records:"+formObj.total_records.value);
	}
	else
	{
//		alert("closed");
	}
}

async function modifyPayer()
{
	var package_enabled_yn = document.forms[0].package_enabled_yn.value;	
	formObj = parent.frames[1].document.forms[0];
	total_records=formObj.total_records.value;

	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	var encounter_date_time = document.forms[0].encounter_date_time.value;

	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}

	var max_priority=document.forms[0].max_priority.value;

	var priority_arr=new Array();
	
	for(var i=0;i<total_records;i++)
	{
		var priority1=eval("parent.frames[1].document.forms[0].priority"+i);
		var priority=priority1.value;
			
		priority_arr[i]=priority;
	}

	var locale=document.forms[0].locale.value;
	checked_row=parent.frames[1].document.forms[0].checked_row.value;

	if(checked_row=="")
	{
//		alert("Select a row to modify");
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		parent.frames[1].document.forms[0].target = "InsValidationFrame";
		parent.frames[1].document.forms[0].action="../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=modify&locn=inside&checked_row="+checked_row;
		parent.frames[1].document.forms[0].submit();

		parent.frames[1].document.forms[0].target = "";

		var blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+checked_row);
		blng_grp_code=encodeURIComponent(blng_grp_code1.value);

		var payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+checked_row);
		payer_desc=encodeURIComponent(payer_desc1.value);

		var cust_31=eval("parent.frames[1].document.forms[0].cust_3"+checked_row);
		cust_3=encodeURIComponent(cust_31.value);

		var priority1=eval("parent.frames[1].document.forms[0].priority"+checked_row);
		priority=priority1.value;

		var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+checked_row);
		policy_type_desc=encodeURIComponent(policy_type_desc1.value);

		var policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+checked_row);
		policy_type_code=encodeURIComponent(policy_type_code1.value);

		var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
		policy_no=encodeURIComponent(policy_no1.value);

		var policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+checked_row);
		policy_start_date=policy_start_date1.value;

		var policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+checked_row);
		policy_exp_date=policy_exp_date1.value;

		var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
		credit_auth_ref=encodeURIComponent(credit_auth_ref1.value);

		var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
		credit_auth_date=credit_auth_date1.value;

		var credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
		credit_apprd_amt=credit_apprd_amt1.value;

		var credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
		credit_apprd_days=credit_apprd_days1.value;

		var policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+checked_row);
		policy_eff_frm_date=policy_eff_frm_date1.value;

		var policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+checked_row);
		policy_eff_to_date=policy_eff_to_date1.value;

		var adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+checked_row);
		adj_rule_ind=encodeURIComponent(adj_rule_ind1.value);

		var adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+checked_row);
		adj_perc_amt_ind=encodeURIComponent(adj_perc_amt_ind1.value);

		var adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+checked_row);
		adj_perc_amt_value=encodeURIComponent(adj_perc_amt_value1.value);

		var pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+checked_row);
		pmnt_diff_adj_int=encodeURIComponent(pmnt_diff_adj_int1.value);

		var drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+checked_row);
		drg_pmnt_diff_adj_int=encodeURIComponent(drg_pmnt_diff_adj_int1.value);

		var spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+checked_row);
		spl_srv_pmnt_diff_adj_int=encodeURIComponent(spl_srv_pmnt_diff_adj_int1.value);

		var restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+checked_row);
		restrict_check=restrict_check1.value;
		
		var valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+checked_row);
		valid_payer_YN=valid_payer_YN1.value;

		var payer_suspended_YN1=eval("parent.frames[1].document.forms[0].payer_suspended_YN"+checked_row);
		payer_suspended_YN=payer_suspended_YN1.value;

		var valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+checked_row);
		valid_policy_type_code_YN=valid_policy_type_code_YN1.value;

		var policy_suspended_YN1=eval("parent.frames[1].document.forms[0].policy_suspended_YN"+checked_row);
		policy_suspended_YN=policy_suspended_YN1.value;
		
		var cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+checked_row);
		cust_group_code=encodeURIComponent(cust_group_code1.value);

		var cust_group_name1=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+checked_row);
		cust_group_name=encodeURIComponent(cust_group_name1.value);

		var cust_valid_from_date1=eval("parent.frames[1].document.forms[0].cust_valid_from_date"+checked_row);
		cust_valid_from_date=encodeURIComponent(cust_valid_from_date1.value);

		var cust_valid_to_date1=eval("parent.frames[1].document.forms[0].cust_valid_to_date"+checked_row);
		cust_valid_to_date=encodeURIComponent(cust_valid_to_date1.value);

		if(!(locale=="en"))
		{
			if(!(policy_start_date=="" || policy_start_date==" "))
				policy_start_date=convertDate(policy_start_date,"DMY",locale,"en");
		
			if(!(policy_exp_date=="" || policy_exp_date==" "))
				policy_exp_date=convertDate(policy_exp_date,"DMY",locale,"en");

			if(!(credit_auth_date=="" || credit_auth_date==" "))
				credit_auth_date=convertDate(credit_auth_date,"DMY",locale,"en");

			if(!(policy_eff_frm_date=="" || policy_eff_frm_date==" "))
				policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY",locale,"en");

			if(!(policy_eff_to_date=="" || policy_eff_to_date==" "))
				policy_eff_to_date=convertDate(policy_eff_to_date,"DMY",locale,"en");
		}

		var policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+checked_row);
		policy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind1.value);

		var rec_edited_YN=eval("parent.frames[1].document.forms[0].rec_edited_YN"+checked_row);
		rec_edited_YN=rec_edited_YN.value;

		//V232504
		var mcn_for_policy1 = eval("parent.frames[1].document.forms[0].mcn_for_policy"+checked_row);  
		mcn_for_policy=mcn_for_policy1.value;
		//V232504
		var reg_ref_id1 = eval("parent.frames[1].document.forms[0].reg_ref_id"+checked_row);  
		reg_ref_id=reg_ref_id1.value;

		var retVal			= new String();

		/* var dialogTop			= "220";
		var dialogHeight		= "25" ;
		var dialogWidth			= "55" ; */
		
		var dialogTop			= "0vh";
		var dialogHeight		= "92vh" ;
		var dialogWidth			= "90vw" ; 

		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title=getLabel("eBL.MODIFY_PAYER.label","BL");
		title=encodeURIComponent(title);	
		var calling_module_id = document.forms[0].calling_module_id.value;	
		var getString=document.forms[0].queryString.value;
		var patient_id = document.forms[0].patient_id.value;
		var calling_module_id = document.forms[0].calling_module_id.value;
		var patient_class = document.forms[0].p_patient_class.value;
		var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;


		var payerEligibilityParamSession=eval("parent.frames[1].document.forms[0].payerEligibilityParam"+checked_row);
		payerEligibilityParamSession=encodeURIComponent(payerEligibilityParamSession.value);
		var responseCodeSession=eval("parent.frames[1].document.forms[0].responseCode"+checked_row);
		responseCodeSession=encodeURIComponent(responseCodeSession.value);
		var responseCodeDescSes=eval("parent.frames[1].document.forms[0].responseCodeDesc"+checked_row);
		responseCodeDescSes=encodeURIComponent(responseCodeDescSes.value);
		var statuDescriptionSession=eval("parent.frames[1].document.forms[0].statuDescription"+checked_row);
		statuDescriptionSession=encodeURIComponent(statuDescriptionSession.value);
		var validityPeriodSession=eval("parent.frames[1].document.forms[0].validityPeriod"+checked_row);
		validityPeriodSession=encodeURIComponent(validityPeriodSession.value);
		var validityPeriodDescSes=eval("parent.frames[1].document.forms[0].validityPeriodDesc"+checked_row);
		validityPeriodDescSes=encodeURIComponent(validityPeriodDescSes.value);
		var eligibilityCodeSes=eval("parent.frames[1].document.forms[0].eligibilityCode"+checked_row);
		eligibilityCodeSes=encodeURIComponent(eligibilityCodeSes.value);
		var transactionIdSes=eval("parent.frames[1].document.forms[0].transactionId"+checked_row);
		transactionIdSes=encodeURIComponent(transactionIdSes.value);
		var responseDateTimeSes=eval("parent.frames[1].document.forms[0].responseDateTime"+checked_row);
		responseDateTimeSes=encodeURIComponent(responseDateTimeSes.value);
			
		var param = "&title="+title+"&action=modify&locn=inside&blng_grp_code="+blng_grp_code+"&payer_desc="+payer_desc+"&cust_3="+cust_3+"&ins_cust_group_code="+cust_group_code+"&ins_cust_group_name="+cust_group_name+"&priority="+priority+"&policy_type_desc="+policy_type_desc+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&policy_start_date="+policy_start_date+"&policy_exp_date="+policy_exp_date+"&credit_auth_ref="+credit_auth_ref+"&credit_auth_date="+credit_auth_date+"&credit_apprd_amt="+credit_apprd_amt+"&credit_apprd_days="+credit_apprd_days+"&policy_eff_frm_date="+policy_eff_frm_date+"&policy_eff_to_date="+policy_eff_to_date+"&adj_rule_ind="+adj_rule_ind+"&adj_perc_amt_ind="+adj_perc_amt_ind+"&adj_perc_amt_value="+adj_perc_amt_value+"&pmnt_diff_adj_int="+pmnt_diff_adj_int+"&drg_pmnt_diff_adj_int="+drg_pmnt_diff_adj_int+"&spl_srv_pmnt_diff_adj_int="+spl_srv_pmnt_diff_adj_int+"&restrict_check="+restrict_check+"&valid_payer_YN="+valid_payer_YN+"&valid_policy_type_code_YN="+valid_policy_type_code_YN+"&policy_coverage_basis_ind="+policy_coverage_basis_ind+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&totalRecords="+total_records+"&priority_arr="+priority_arr+"&encounter_date_time="+encounter_date_time+"&cust_valid_from_date="+cust_valid_from_date+"&cust_valid_to_date="+cust_valid_to_date+"&checked_row="+checked_row+"&rec_edited_YN="+rec_edited_YN+"&patient_id="+patient_id+"&calling_module_id="+calling_module_id+"&patient_class="+patient_class+"&fin_class_flag_YN="+fin_class_flag_YN+"&payerElgParam="+payerEligibilityParamSession+"&respCdSes="+responseCodeSession+"&respCdDescSes="+responseCodeDescSes+"&statDes="+statuDescriptionSession+"&valPer="+validityPeriodSession+"&valPerDesc="+validityPeriodDescSes+"&elgCd="+eligibilityCodeSes+"&transId="+transactionIdSes+"&respDT="+responseDateTimeSes+"&package_enabled_yn="+package_enabled_yn+"&reg_ref_id="+reg_ref_id+"&mcn_for_policy="+mcn_for_policy; //V232504

		retVal= await parent.window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?"+param,arguments,features);
		
		formObj = parent.frames[1].document.forms[0];
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}

//		formObj.selected_row.checked=false;
		if(retVal!=null)
		{
		var arr=new Array();
		if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);
					  
			if(retVal != null && retVal.length>0)
			{
//				formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
				arr=retVal.split("^~^");	

				if(arr[22]=="R")
				{
					if(arr[31]=="R")
					{
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="inline";
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="inline";

					}
					else if(arr[31]=="U")
					{
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="none";
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="none";

						var credit_apprd_amt_chk=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
						credit_apprd_amt_chk.value="";
					}

					if(arr[32]=="R")
					{
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
						apprd_days_leg_disp1.style.display="inline";
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
						apprd_days_leg_disp1.style.display="inline";
					}
					else if(arr[32]=="U")
					{
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
						apprd_days_leg_disp1.style.display="none";
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
						apprd_days_leg_disp1.style.display="none";

						var credit_apprd_days_chk=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
						credit_apprd_days_chk.value="";
					}
				}
				else if(arr[22]=="U")
				{
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";

					var credit_apprd_amt_chk=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
					credit_apprd_amt_chk.value="";
					var credit_apprd_days_chk=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
					credit_apprd_days_chk.value="";
				}
				
				var blng_grp_desc1=eval("parent.frames[1].document.forms[0].billing_group_desc"+checked_row);
				blng_grp_desc1.value=decodeURIComponent(arr[0]);
				
				var blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+checked_row);
				blng_grp_code1.value=decodeURIComponent(arr[1]);
				
				var payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+checked_row);
				payer_desc1.value=decodeURIComponent(arr[2]);
				
				var cust_31=eval("parent.frames[1].document.forms[0].cust_3"+checked_row);
				cust_31.value=decodeURIComponent(arr[3]);
				
				var priority1=eval("parent.frames[1].document.forms[0].priority"+checked_row);
				priority1.value=arr[4];
				
				var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+checked_row);
				policy_type_desc1.value=decodeURIComponent(arr[5]);
				
				var policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+checked_row);
				policy_type_code1.value=decodeURIComponent(arr[6]);
				
				var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
				policy_no1.value=arr[7];
				
				var policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+checked_row);
				var policy_start_date_conv=arr[8];
				if(policy_start_date_conv=="" || policy_start_date_conv==" ") policy_start_date_conv="";
				if(policy_start_date_conv!="")
				{
					policy_start_date_conv=convertDate(policy_start_date_conv,"DMY","en",locale);
				}
				policy_start_date1.value=policy_start_date_conv;
				
				var policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+checked_row);
				var policy_exp_date_conv=arr[9];
				if(policy_exp_date_conv=="" || policy_exp_date_conv==" ") policy_exp_date_conv="";
				if(policy_exp_date_conv!="")
				{
					policy_exp_date_conv=convertDate(policy_exp_date_conv,"DMY","en",locale);
				}
				policy_exp_date1.value=policy_exp_date_conv;

				if(arr[33] == "Y")
				{
					var credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_val_disp"+checked_row));
					credit_auth_ref_val_disp1.style.display="inline";

					var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
					credit_auth_ref1.value=decodeURIComponent(arr[10]);

					var credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_date_val_disp"+checked_row));
					credit_auth_date_val_disp1.style.display="inline";
					
					var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
					var credit_auth_date_conv=arr[11];

					if(credit_auth_date_conv=="" || credit_auth_date_conv==" ") credit_auth_date_conv="";
					if(credit_auth_date_conv!="")
					{
						credit_auth_date_conv=convertDate(credit_auth_date_conv,"DMY","en",locale);
					}
					credit_auth_date1.value=credit_auth_date_conv;
				}
				else
				{
					var credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_val_disp"+checked_row));
					credit_auth_ref_val_disp1.style.display="none";

					var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
					credit_auth_ref1.value= "";
					
					var credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_date_val_disp"+checked_row));
					credit_auth_date_val_disp1.style.display="none";

					var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
					credit_auth_date1.value= "";
				}

				var cred_auth_req_yn1=eval("parent.frames[1].document.forms[0].cred_auth_req_yn"+checked_row);
				cred_auth_req_yn1.value=arr[33];

				var cred_auth_mand_capt_yn1=eval("parent.frames[1].document.forms[0].cred_auth_mand_capt_yn"+checked_row);
				cred_auth_mand_capt_yn1.value=arr[40];				

				var dflt_auth_ref_as_pol_no_yn1=eval("parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn"+checked_row);
				dflt_auth_ref_as_pol_no_yn1.value=arr[34];
				
				var credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
				var temp_credit_apprd_amt=arr[12];
				if(temp_credit_apprd_amt==" ") temp_credit_apprd_amt="";
				credit_apprd_amt1.value=temp_credit_apprd_amt;
				
				var credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
				var temp_credit_apprd_days=arr[13];
				if(temp_credit_apprd_days==" ") temp_credit_apprd_days="";
				credit_apprd_days1.value=temp_credit_apprd_days;
				
				var policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+checked_row);
				var policy_eff_frm_date_conv=arr[14];
				if(policy_eff_frm_date_conv=="" || policy_eff_frm_date_conv==" ") policy_eff_frm_date_conv="";
				if(policy_eff_frm_date_conv!="")
				{
					policy_eff_frm_date_conv=convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
				}
				policy_eff_frm_date1.value=policy_eff_frm_date_conv;
				
				var policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+checked_row);
				var policy_eff_to_date_conv=arr[15];
				if(policy_eff_to_date_conv=="" || policy_eff_to_date_conv==" ") policy_eff_to_date_conv="";
				if(policy_eff_to_date_conv!="")
				{
					policy_eff_to_date_conv=convertDate(policy_eff_to_date_conv,"DMY","en",locale);
				}
				policy_eff_to_date1.value=policy_eff_to_date_conv;
				
				var adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+checked_row);
				adj_rule_ind1.value=decodeURIComponent(arr[16]);
				
				var adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+checked_row);
				adj_perc_amt_ind1.value=decodeURIComponent(arr[17]);
				
				var adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+checked_row);
				adj_perc_amt_value1.value=decodeURIComponent(arr[18]);
				
				var pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+checked_row);
				pmnt_diff_adj_int1.value=decodeURIComponent(arr[19]);
				
				var drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+checked_row);
				drg_pmnt_diff_adj_int1.value=decodeURIComponent(arr[20]);
				
				var spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+checked_row);
				spl_srv_pmnt_diff_adj_int1.value=decodeURIComponent(arr[21]);
				
				var restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+checked_row);
				restrict_check1.value=arr[22];

				var apprd_amt_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_amt_restrict_check"+checked_row);
				apprd_amt_restrict_check1.value=arr[31];

				var apprd_days_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_days_restrict_check"+checked_row);
				apprd_days_restrict_check1.value=arr[32];

				var valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+checked_row);
				valid_payer_YN1.value=arr[23];

				var valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+checked_row);
				valid_policy_type_code_YN1.value=arr[24];

				var cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+checked_row);
				cust_group_code1.value=decodeURIComponent(arr[25]);

				var cust_group_name1=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+checked_row);
				cust_group_name1.value=decodeURIComponent(arr[37]);

				var policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+checked_row);
				policy_coverage_basis_ind1.value=arr[26];

				var cust_valid_from_date1=eval("parent.frames[1].document.forms[0].cust_valid_from_date"+checked_row);
				cust_valid_from_date1.value=arr[35];

				var cust_valid_to_date1=eval("parent.frames[1].document.forms[0].cust_valid_to_date"+checked_row);
				cust_valid_to_date1.value=arr[36];

				var pol_validity_chk_date=eval("parent.frames[1].document.forms[0].pol_validity_chk_date"+checked_row);
				var pol_validity_chk_date_conv = arr[38];

				if(pol_validity_chk_date_conv=="" || pol_validity_chk_date_conv==" ") pol_validity_chk_date_conv="";

				if(pol_validity_chk_date_conv!="")
				{
					pol_validity_chk_date_conv=convertDate(pol_validity_chk_date_conv,"DMY","en",locale);
				}
				pol_validity_chk_date.value=pol_validity_chk_date_conv;

				if(total_records==1)
				{
					parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind1.value;
				}

				parent.frames[1].policy_coverage_basis_ind();

				var rec_edited_YN=eval("parent.frames[1].document.forms[0].rec_edited_YN"+checked_row);
				rec_edited_YN.value = arr[39];
				
				var mcn_for_policy=eval("parent.frames[1].document.forms[0].mcn_for_policy"+checked_row);  //V232504
				mcn_for_policy.value=decodeURIComponent(arr[51]);  //V232504
				
				var reg_ref_id=eval("parent.frames[1].document.forms[0].reg_ref_id"+checked_row);  //V232504
				reg_ref_id.value=decodeURIComponent(arr[52]);  //V232504
				


				//Added by prithivi on 03/01/2017 for mms-qh-crf-0085 -- bupa insurance interface
				var payerEligibilityParam=eval("parent.frames[1].document.forms[0].payerEligibilityParam"+checked_row);

				var responseCode=eval("parent.frames[1].document.forms[0].responseCode"+checked_row);
				var responseCodeDesc=eval("parent.frames[1].document.forms[0].responseCodeDesc"+checked_row);
				var statuDescription=eval("parent.frames[1].document.forms[0].statuDescription"+checked_row);
				var validityPeriod=eval("parent.frames[1].document.forms[0].validityPeriod"+checked_row);
				var validityPeriodDesc=eval("parent.frames[1].document.forms[0].validityPeriodDesc"+checked_row);
				var eligibilityCode=eval("parent.frames[1].document.forms[0].eligibilityCode"+checked_row);
				var transactionId=eval("parent.frames[1].document.forms[0].transactionId"+checked_row);
				var responseDateTime=eval("parent.frames[1].document.forms[0].responseDateTime"+checked_row);

				var arrLength = arr.length-10;  // over all arr length is 51
				payerEligibilityParam.value = decodeURIComponent(arr[arrLength]);
				responseCode.value = decodeURIComponent(arr[arrLength+1]);
				responseCodeDesc.value = decodeURIComponent(arr[arrLength+2]);
				statuDescription.value = decodeURIComponent(arr[arrLength+3]);
				validityPeriod.value = decodeURIComponent(arr[arrLength+4]);
				validityPeriodDesc.value = decodeURIComponent(arr[arrLength+5]);
				eligibilityCode.value = decodeURIComponent(arr[arrLength+6]);
				transactionId.value = decodeURIComponent(arr[arrLength+7]);
				responseDateTime.value = decodeURIComponent(arr[arrLength+8]);

			}
		}
		}
		else
		{
//			alert("closed");
		}
	}
	parent.frames[1].document.forms[0].checked_row.value="";
}

/*
function removePayer()
{
	formObj = parent.frames[1].document.forms[0];
	total_records=formObj.total_records.value;

	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}

	var locale=document.forms[0].locale.value;
	var checked_row=parent.frames[1].document.forms[0].checked_row.value;
	if(checked_row=="")
	{
//		alert("Select a row to remove");
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		var blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+checked_row);
		blng_grp_code=encodeURIComponent(blng_grp_code1.value);

		var payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+checked_row);
		payer_desc=encodeURIComponent(payer_desc1.value);

		var cust_31=eval("parent.frames[1].document.forms[0].cust_3"+checked_row);
		cust_3=encodeURIComponent(cust_31.value);

		var priority1=eval("parent.frames[1].document.forms[0].priority"+checked_row);
		priority=priority1.value;

		var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+checked_row);
		policy_type_desc=encodeURIComponent(policy_type_desc1.value);

		var policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+checked_row);
		policy_type_code=policy_type_code1.value;

		var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
		policy_no=encodeURIComponent(policy_no1.value);

		var policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+checked_row);
		policy_start_date=policy_start_date1.value;

		var policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+checked_row);
		policy_exp_date=policy_exp_date1.value;

		var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
		credit_auth_ref=encodeURIComponent(credit_auth_ref1.value);

		var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
		credit_auth_date=credit_auth_date1.value;

		var credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
		credit_apprd_amt=credit_apprd_amt1.value;

		var credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
		credit_apprd_days=credit_apprd_days1.value;

		var policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+checked_row);
		policy_eff_frm_date=policy_eff_frm_date1.value;

		var policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+checked_row);
		policy_eff_to_date=policy_eff_to_date1.value;

		var adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+checked_row);
		adj_rule_ind=adj_rule_ind1.value;

		var adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+checked_row);
		adj_perc_amt_ind=adj_perc_amt_ind1.value;

		var adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+checked_row);
		adj_perc_amt_value=adj_perc_amt_value1.value;

		var pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+checked_row);
		pmnt_diff_adj_int=pmnt_diff_adj_int1.value;

		var drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+checked_row);
		drg_pmnt_diff_adj_int=drg_pmnt_diff_adj_int1.value;

		var spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+checked_row);
		spl_srv_pmnt_diff_adj_int=spl_srv_pmnt_diff_adj_int1.value;

		var restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+checked_row);
		restrict_check=restrict_check1.value;

		var valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+checked_row);
		valid_payer_YN=valid_payer_YN1.value;

		var valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+checked_row);
		valid_policy_type_code_YN=valid_policy_type_code_YN1.value;

		var cust_group_code1=eval("parent.frames[1].document.forms[0].cust_group_code"+checked_row);
		cust_group_code=encodeURIComponent(cust_group_code1.value);

		var policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+checked_row);
		policy_coverage_basis_ind=policy_coverage_basis_ind1.value;

		if(!(locale=="en"))
		{
			if(!(policy_start_date=="" || policy_start_date==" "))
				policy_start_date=convertDate(policy_start_date,"DMY",locale,"en");
		
			if(!(policy_exp_date=="" || policy_exp_date==" "))
				policy_exp_date=convertDate(policy_exp_date,"DMY",locale,"en");

			if(!(credit_auth_date=="" || credit_auth_date==" "))
				credit_auth_date=convertDate(credit_auth_date,"DMY",locale,"en");

			if(!(policy_eff_frm_date=="" || policy_eff_frm_date==" "))
				policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY",locale,"en");

			if(!(policy_eff_to_date=="" || policy_eff_to_date==" "))
				policy_eff_to_date=convertDate(policy_eff_to_date,"DMY",locale,"en");
		}

		var retVal			= new String();

		var dialogTop			= "220";
		var dialogHeight		= "18" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title=getLabel("eBL.REMOVE_PAYER.label","BL");
		title=encodeURIComponent(title);
		var calling_module_id = document.forms[0].calling_module_id.value;	
		var getString=document.forms[0].queryString.value;
		var param = "&title="+title+"&action=remove&payer_desc="+payer_desc+"&cust_3="+cust_3+"&cust_group_code="+cust_group_code+"&priority="+priority+"&policy_type_desc="+policy_type_desc+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&policy_start_date="+policy_start_date+"&policy_exp_date="+policy_exp_date+"&credit_auth_ref="+credit_auth_ref+"&credit_auth_date="+credit_auth_date+"&credit_apprd_amt="+credit_apprd_amt+"&credit_apprd_days="+credit_apprd_days+"&policy_eff_frm_date="+policy_eff_frm_date+"&policy_eff_to_date="+policy_eff_to_date+"&adj_rule_ind="+adj_rule_ind+"&adj_perc_amt_ind="+adj_perc_amt_ind+"&adj_perc_amt_value="+adj_perc_amt_value+"&pmnt_diff_adj_int="+pmnt_diff_adj_int+"&drg_pmnt_diff_adj_int="+drg_pmnt_diff_adj_int+"&spl_srv_pmnt_diff_adj_int="+spl_srv_pmnt_diff_adj_int+"&restrict_check="+restrict_check+"&valid_payer_YN="+valid_payer_YN+"&valid_policy_type_code_YN="+valid_policy_type_code_YN+"&policy_coverage_basis_ind="+policy_coverage_basis_ind+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&totalRecords="+total_records+"&"+getString;
	
		retVal=window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?"+param,arguments,features);

		formObj = parent.frames[1].document.forms[0];
		total_records=formObj.total_records.value;

		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}

		if(	retVal!=null)
		{
			var ret_val=retVal;
			if(ret_val=="remove")
			{	
					totalRecords =eval(formObj.total_records.value);

					if(totalRecords==1)
					{
						parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value="";
					}
					parent.frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBody.jsp?remove_check=remove&checked_row="+checked_row+"&total_records="+totalRecords+"&"+getString;

					parent.frames[1].document.forms[0].submit();
			}
		}
		else
		{
//			alert("closed");
		}
	}
	parent.frames[1].document.forms[0].checked_row.value="";
}
*/
function removePayerNew()
{
	var checked_row=parent.frames[1].document.forms[0].checked_row.value;
	var locale=document.forms[0].locale.value;
	formObj = parent.frames[1].document.forms[0];
	total_records=formObj.total_records.value;

	var getString=document.forms[0].queryString.value;

	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	
	if(checked_row=="")
	{
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		if(confirm(getMessage("BL9760","BL"))) //BL9760
		{
			totalRecords =eval(formObj.total_records.value);
			parent.frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBody.jsp?remove_check=remove&"+getString+"&checked_row="+checked_row+"&total_records="+totalRecords;

			parent.frames[1].document.forms[0].submit();
		}
		else
		{
			return false;			
		}
	}
	for(var j=0;j<total_records;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}
	parent.frames[1].document.forms[0].checked_row.value="";
	
}

function cancel()
{
	//parent.window.close();
	
	if(top.window.document.getElementById('dialog-body')) 
	{	
		var showModalFrame = top.window.document.getElementById('dialog-body').contentWindow;
		showModalFrame.document.getElementById("dialog_tag").close();
	}
	else
	{
		const dialogTag = parent.document.getElementById("dialog_tag"); 
	    dialogTag.close(); 
	}
}

function add_more_blng_grp()
{
	var locale=document.forms[0].locale.value;
	var billing_group=parent.frames[1].document.forms[0].billing_group.value;
	var primary_blng_grp=document.forms[0].primary_blng_grp.value;
	var primary_blng_grp_arr=new Array();
	primary_blng_grp_arr=primary_blng_grp.split("|");
	
	for (var i=0;i<primary_blng_grp_arr.length;i++)
	{
		    var blng_grp_val = primary_blng_grp_arr[i];
			if(blng_grp_val==billing_group)
			{
//				alert("Billing Group is Duplicated");
				alert(getMessage("BL9577","BL"));
				return false;
			}
	}
	
	var total_records=parent.frames[1].document.forms[0].total_records.value;
	var rtn_ins_blng_grp_desc="";
	var rtn_ins_blng_grp="";
	var rtn_ins_payer_desc="";
	var rtn_ins_cust_code="";
	var rtn_ins_cust_priority="";
	var rtn_ins_policy_type_desc="";
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
	var rtn_ins_restrict_check="",rtn_ins_apprd_amt_restrict_check="",rtn_ins_apprd_days_restrict_check="";
	var restrict_check="",apprd_amt_restrict_check="",apprd_days_restrict_check="";
	var rtn_ins_valid_payer_YN="";
	var rtn_ins_valid_policy_type_code_YN="";
	var rtn_ins_cust_group_code="";
	var rtn_ins_cust_group_name="";
	var rtn_ins_policy_coverage_basis_ind="";
	var policy_coverage_basis_gbl_ind="";
	var policy_coverage_basis_gbl_ind_from_main="";
	var rtn_ins_cred_auth_req_yn="", rtn_ins_dflt_auth_ref_as_pol_no_yn="",rtn_ins_cred_auth_mand_capt_yn="";
	var cred_auth_req_yn="", dflt_auth_ref_as_pol_no_yn="",cred_auth_mand_capt_yn="";

	var rtn_ref_src_main_code = "", rtn_ref_src_main_desc="";
	var rtn_ref_src_sub_code = "", rtn_ref_src_sub_desc="";
	var cap_ref_src_dtl_flag = "N";
	var referral_source_main_mand_YN = "N";
	var referral_source_sub_mand_YN = "N";

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
	
	//V232504
	var rtn_mcn_for_policy="";
	var rtn_reg_ref_id="";

	if(total_records==0)
	{
		alert(getMessage("BL9574","BL"));
		return false;
	}

	cap_ref_src_dtl_flag = parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value;
	referral_source_main_mand_YN = parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value;
	referral_source_sub_mand_YN = parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value;
	rtn_ref_src_main_code = parent.parent.frames[0].document.forms[0].referral_source_main_code.value;
	rtn_ref_src_main_desc = parent.parent.frames[0].document.forms[0].referral_source_main_desc.value;
	rtn_ref_src_sub_code = parent.parent.frames[0].document.forms[0].referral_source_sub_code.value;
	rtn_ref_src_sub_desc = parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value;

	if(cap_ref_src_dtl_flag=="Y")
	{
		if(referral_source_main_mand_YN == "Y")
		{
			if((rtn_ref_src_main_code=="" || rtn_ref_src_main_code==null) || (rtn_ref_src_main_desc=="" || rtn_ref_src_main_desc==null))
			{
				alert(getMessage("BL9816","BL"));
				return false;
			}
		}

		if(referral_source_sub_mand_YN == "Y")
		{
			if((rtn_ref_src_sub_code=="" || rtn_ref_src_sub_code==null) || (rtn_ref_src_sub_desc=="" || rtn_ref_src_sub_desc==null))
			{
				alert(getMessage("BL9817","BL"));
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

	policy_coverage_basis_gbl_ind_from_main=document.forms[0].policy_coverage_basis_gbl_ind_from_main.value;

	policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	if(policy_coverage_basis_gbl_ind_from_main=="I")
	{
		if(policy_coverage_basis_gbl_ind=="P")
		{
			alert(getMessage("BL9729","BL"));
			return false;
		}
	}
       var calling_module_id = parent.frames[1].document.forms[0].calling_module_id.value;
	   
	   var moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);
	   
	   if(moduleIdValidation=="Y")
		{
		    var payerEligibility_check_arr=new Array();
		    var eligibilityCheck=false;
		    var alertMsgg="Payer Eligibility Check hasn't been done for the following                                     \n\n";
			
			for(var i=0;i<total_records;i++)
			{
			   var payerElgParam = eval("parent.frames[1].document.forms[0].payerEligibilityParam"+i);
			   var ins_blng_grp_desc1_int2=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+i);
			   var blngGrpVal=ins_blng_grp_desc1_int2.value;
			   var ins_blng_grp_code12=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
			   var ins_blng_grp_code2=ins_blng_grp_code12.value;

			    if(payerElgParam!=undefined)
				{
				   var payer_desc1_int=eval("parent.frames[1].document.forms[0].payer_desc"+i);
				   var priority1_int=eval("parent.frames[1].document.forms[0].priority"+i);
				   var policy_type_desc1_int=eval("parent.frames[1].document.forms[0].policy_type_desc"+i);
				   
				   var payerElgParamValue=payerElgParam.value;
				   
				   var payerDescVal=payer_desc1_int.value;
				   var priorityVal=priority1_int.value;
				   var policyTypeVal=policy_type_desc1_int.value;
					if(payerElgParamValue == "0")
					{
					  eligibilityCheck=true;
					  alertMsgg=alertMsgg+"Billing group: "+blngGrpVal+"      Payer: "+payerDescVal+"        Priority: "+priorityVal+"         Policy: "+policyTypeVal+"\n\n";
					}
					else if(payerElgParamValue == "")
					{
						var ins_cust_group_code_int = eval("parent.frames[1].document.forms[0].ins_cust_group_code"+i);
						var ins_cust_group_code_int_val = ins_cust_group_code_int.value;

						var interfaceYNvalidate = checkCustomerGroupInterface(ins_cust_group_code_int_val);
						//alert("interfaceYNvalidate..."+interfaceYNvalidate);
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

	for(var i=0;i<total_records;i++)
	{
		var rtn_ins_billing_group_desc1=eval("parent.frames[1].document.forms[0].billing_group_desc"+i);
		
		if(rtn_ins_billing_group_desc1.value==null || rtn_ins_billing_group_desc1.value=="")
		{
			rtn_ins_billing_group_desc1.value=" ";
		}
		rtn_ins_blng_grp_desc=rtn_ins_blng_grp_desc+rtn_ins_billing_group_desc1.value+"|";

		var rtn_ins_blng_grp1=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
		if(rtn_ins_blng_grp1.value=="" || rtn_ins_blng_grp1.value==null)
		{
			rtn_ins_blng_grp1.value=="";
		}
		rtn_ins_blng_grp=rtn_ins_blng_grp+rtn_ins_blng_grp1.value+"|";

		var rtn_ins_payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+i);
		if(rtn_ins_payer_desc1.value=="" || rtn_ins_payer_desc1.value==null)
		{
			alert(getMessage("BL9532","BL"));
			return false;
		}
		rtn_ins_payer_desc=rtn_ins_payer_desc+rtn_ins_payer_desc1.value+"|";

		var rtn_cust_31		   = eval("parent.frames[1].document.forms[0].cust_3"+i);
		if(rtn_cust_31.value=="" || rtn_cust_31.value==null)
		{
			alert(getMessage("BL9532","BL"));
			return false;
		}
		rtn_ins_cust_code=rtn_ins_cust_code+rtn_cust_31.value+"|";

		var rtn_priority1=eval("parent.frames[1].document.forms[0].priority"+i);
		if(rtn_priority1.value=="" || rtn_priority1.value==null)
		{
			alert(getMessage("BL9325","BL"));
			return false;
		}
		rtn_ins_cust_priority=rtn_ins_cust_priority+rtn_priority1.value+"|";

		var rtn_policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+i);
		if(rtn_policy_type_desc1.value=="" || rtn_policy_type_desc1.value==null)
		{
			alert(getMessage("BL9103","BL"));
			return false;
		}
		rtn_ins_policy_type_desc=rtn_ins_policy_type_desc+rtn_policy_type_desc1.value+"|";

		var rtn_policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+i);
		if(rtn_policy_type_code1.value=="" || rtn_policy_type_code1.value==null)
		{
			alert(getMessage("BL9103","BL"));
			return false;
		}
		rtn_ins_policy_type_code=rtn_ins_policy_type_code+rtn_policy_type_code1.value+"|";
			
		var	rtn_policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+i);
		if(rtn_policy_no1.value=="" || rtn_policy_no1.value==null)
		{
			rtn_policy_no1.value="";
			alert(getMessage("BL9104","BL"));
			return false;
		}
		rtn_ins_policy_no=rtn_ins_policy_no+rtn_policy_no1.value+"|";

		var rtn_policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+i);
		var rtn_ins_policy_start_date_temp=rtn_policy_start_date1.value;
		if(rtn_ins_policy_start_date_temp==null) rtn_ins_policy_start_date_temp="";
		if(rtn_ins_policy_start_date_temp=="")
		{
			alert(getMessage("BL9324","BL"));
			return false;
		}
		if(rtn_ins_policy_start_date_temp!="")
		{
			rtn_ins_policy_start_date_temp=convertDate(rtn_ins_policy_start_date_temp,"DMY",locale,"en");
		}
		rtn_ins_policy_start_date=rtn_ins_policy_start_date+rtn_ins_policy_start_date_temp+"|";

		var rtn_policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+i);
		var rtn_ins_policy_expiry_date_temp=rtn_policy_exp_date1.value;
		if(rtn_ins_policy_expiry_date_temp==null) rtn_ins_policy_expiry_date_temp="";
		if(rtn_ins_policy_expiry_date_temp=="")
		{
			alert(getMessage("BL9105","BL"));
			return false;
		}
		if(rtn_ins_policy_expiry_date_temp!="")
		{
			rtn_ins_policy_expiry_date_temp=convertDate(rtn_ins_policy_expiry_date_temp,'DMY',locale,"en");
		}
		rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+rtn_ins_policy_expiry_date_temp+"|";
		
		var rtn_ins_cred_auth_req_yn1 = eval("parent.frames[1].document.forms[0].cred_auth_req_yn"+i);
		cred_auth_req_yn = rtn_ins_cred_auth_req_yn1.value;
		rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+"|";

		var rtn_ins_cred_auth_mand_capt_yn1 = eval("parent.frames[1].document.forms[0].cred_auth_mand_capt_yn"+i);
		cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn1.value;
		rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+cred_auth_mand_capt_yn+"|";

		var rtn_ins_dflt_auth_ref_as_pol_no_yn1 = eval("parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn"+i);
		dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn1.value;

		rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+"|";

		if(cred_auth_req_yn =="Y")
		{
			var rtn_credit_auth_ref1 =eval("parent.frames[1].document.forms[0].credit_auth_ref"+i);
			var rtn_credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+i);
			var rtn_ins_credit_auth_date_temp=rtn_credit_auth_date1.value;
			if(rtn_ins_credit_auth_date_temp==null) rtn_ins_credit_auth_date_temp="";

			if(cred_auth_mand_capt_yn=="Y")
			{
				if(rtn_credit_auth_ref1.value=="" || rtn_credit_auth_ref1.value==null)
				{
					alert(getMessage("BL8148","BL"));
					return false;
				}

				if(rtn_ins_credit_auth_date_temp=="")
				{
					alert(getMessage("BL9562","BL"));
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

		var rtn_restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+i);
		restrict_check=rtn_restrict_check1.value;
		rtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+"|";
		
		var apprd_amt_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_amt_restrict_check"+i);
		apprd_amt_restrict_check=apprd_amt_restrict_check1.value;
		rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+"|";
		
		var apprd_days_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_days_restrict_check"+i);
		apprd_days_restrict_check=apprd_days_restrict_check1.value;
		rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+"|";
		
		if(restrict_check=="R")
		{
			if(apprd_amt_restrict_check == "R")
			{
				var rtn_credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+i);
				if(rtn_credit_apprd_amt1.value=="" || rtn_credit_apprd_amt1.value==null)
				{
					alert(getMessage("BL9564","BL"));
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
				var rtn_credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+i);
				if(rtn_credit_apprd_days1.value=="" || rtn_credit_apprd_days1.value==null)
				{
					alert(getMessage("BL9563","BL"));
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

		var rtn_policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+i);
		var rtn_ins_policy_eff_from_date_temp=rtn_policy_eff_frm_date1.value;
		if(rtn_ins_policy_eff_from_date_temp==null) rtn_ins_policy_eff_from_date_temp="";
		if(rtn_ins_policy_eff_from_date_temp=="" )
		{
			alert(getMessage("BL9565","BL"));
			return false;
		}
		if(rtn_ins_policy_eff_from_date_temp!="")
		{
			rtn_ins_policy_eff_from_date_temp=convertDate(rtn_ins_policy_eff_from_date_temp,'DMY',locale,"en");
		}
		rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+rtn_ins_policy_eff_from_date_temp+"|";

		var rtn_policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+i);
		var rtn_ins_policy_eff_to_date_temp=rtn_policy_eff_to_date1.value;
		if(rtn_ins_policy_eff_to_date_temp==null) rtn_ins_policy_eff_to_date_temp="";
		if(rtn_ins_policy_eff_to_date_temp=="" )
		{
			rtn_ins_policy_eff_to_date_temp=" ";
		}
		if(rtn_ins_policy_eff_to_date_temp!="" && rtn_ins_policy_eff_to_date_temp!=" ")
		{
			rtn_ins_policy_eff_to_date_temp=convertDate(rtn_ins_policy_eff_to_date_temp,'DMY',locale,"en");
		}
		rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+rtn_ins_policy_eff_to_date_temp+"|";

		var rtn_adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+i);
		var adj_rule_ind1=rtn_adj_rule_ind1.value;
		
		if(adj_rule_ind1==null || adj_rule_ind1=="")
		{
			adj_rule_ind1=" ";
		}
		rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+adj_rule_ind1+"|";

		var rtn_adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+i);
		var adj_perc_amt_ind1=rtn_adj_perc_amt_ind1.value;
		if(adj_perc_amt_ind1==null || adj_perc_amt_ind1=="")
			{
				adj_perc_amt_ind1=" ";
			}
		rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+adj_perc_amt_ind1+"|";
			
		var rtn_adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+i);
		var adj_perc_amt_value1=rtn_adj_perc_amt_value1.value;
		if(adj_perc_amt_value1==null || adj_perc_amt_value1=="")
		{
			adj_perc_amt_value1=" ";
		}
		rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+adj_perc_amt_value1+"|";
			
		var rtn_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+i);
		var pmnt_diff_adj_int1=rtn_pmnt_diff_adj_int1.value;
		if(pmnt_diff_adj_int1==null || pmnt_diff_adj_int1=="")
		{
			pmnt_diff_adj_int1=" ";
		}
		rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+pmnt_diff_adj_int1+"|";

		var rtn_drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+i);
		var drg_pmnt_diff_adj_int1=rtn_drg_pmnt_diff_adj_int1.value;
		if(drg_pmnt_diff_adj_int1==null || drg_pmnt_diff_adj_int1=="")
		{
			drg_pmnt_diff_adj_int1=" ";
		}
		rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+drg_pmnt_diff_adj_int1+"|";

		var rtn_spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+i);
		var spl_srv_pmnt_diff_adj_int1=rtn_spl_srv_pmnt_diff_adj_int1.value;
		if(spl_srv_pmnt_diff_adj_int1==null || spl_srv_pmnt_diff_adj_int1=="")
		{
			spl_srv_pmnt_diff_adj_int1=" ";
		}
		rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+spl_srv_pmnt_diff_adj_int1+"|";

		var rtn_ins_valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+i);
		if(rtn_ins_valid_payer_YN1.value=="N")
		{
			alert(getMessage("BL9588","BL")+":"+rtn_ins_payer_desc1.value);
			return false;
		}
		else if(rtn_ins_valid_payer_YN1.value=="Y")
		{
			var payer_suspended_YN1=eval("parent.frames[1].document.forms[0].payer_suspended_YN"+i);
			if(payer_suspended_YN1.value=="S")
			{
				var ins_payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+i);
				alert(getMessage("BL7435","BL")+":"+rtn_ins_payer_desc1.value);
				return false;
			}
		}

		rtn_ins_valid_payer_YN=rtn_ins_valid_payer_YN+rtn_ins_valid_payer_YN1.value+"|";

		var rtn_ins_valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+i);
		if(rtn_ins_valid_policy_type_code_YN1.value=="N")
		{
			alert(getMessage("BL9589","BL")+":"+rtn_policy_type_desc1.value);
			return false;
		}
		else if(rtn_ins_valid_policy_type_code_YN1.value=="Y")
		{
			var policy_suspended_YN1=eval("parent.frames[1].document.forms[0].policy_suspended_YN"+i);

			if(policy_suspended_YN1.value=="S")
			{
				var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+i);
				alert(getMessage("BL7436","BL")+":"+rtn_policy_type_desc1.value);
				return false;
			}
		}

		rtn_ins_valid_policy_type_code_YN=rtn_ins_valid_policy_type_code_YN+rtn_ins_valid_policy_type_code_YN1.value+"|";

		var rtn_ins_cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+i);
		if(rtn_ins_cust_group_code1.value=="" || rtn_ins_cust_group_code1.value==null)
		{
			rtn_ins_cust_group_code1.value=" ";
		}
		rtn_ins_cust_group_code=rtn_ins_cust_group_code+rtn_ins_cust_group_code1.value+"|";

		var rtn_ins_cust_group_name1=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+i);
		if(rtn_ins_cust_group_name1.value=="" || rtn_ins_cust_group_name1.value==null)
		{
			rtn_ins_cust_group_name1.value=" ";
		}
		rtn_ins_cust_group_name=rtn_ins_cust_group_name+rtn_ins_cust_group_name1.value+"|";

		var rtn_ins_policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+i);
		var policy_coverage_basis_ind=rtn_ins_policy_coverage_basis_ind1.value;

		if(policy_coverage_basis_ind==null || policy_coverage_basis_ind=="")
		{
			policy_coverage_basis_ind=" ";
		}
		rtn_ins_policy_coverage_basis_ind=rtn_ins_policy_coverage_basis_ind+policy_coverage_basis_ind+"|";

		 //Added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check
			var payerEligibilityParamSession1=eval("parent.frames[1].document.forms[0].payerEligibilityParam"+i);
			 if(payerEligibilityParamSession1!=undefined)
			 {
               rtn_payerEligibilityParamSession=rtn_payerEligibilityParamSession+payerEligibilityParamSession1.value+"|";
			 }
			var responseCode1=eval("parent.frames[1].document.forms[0].responseCode"+i);
			if(responseCode1!=undefined)
			 {
               rtn_responseCode=rtn_responseCode+responseCode1.value+"|";
			 }

			var responseCodeDesc1=eval("parent.frames[1].document.forms[0].responseCodeDesc"+i);
			if(responseCodeDesc1!=undefined)
			 {
               rtn_responseCodeDesc=rtn_responseCodeDesc+responseCodeDesc1.value+"|";
			 }

			var statuDescription1=eval("parent.frames[1].document.forms[0].statuDescription"+i);            
			if(statuDescription1!=undefined)
			 {
               rtn_statuDescription=rtn_statuDescription+statuDescription1.value+"|";
			 }

			var validityPeriod1=eval("parent.frames[1].document.forms[0].validityPeriod"+i);
			if(validityPeriod1!=undefined)
			 {
               rtn_validityPeriod=rtn_validityPeriod+validityPeriod1.value+"|";
			 }

			var validityPeriodDesc1=eval("parent.frames[1].document.forms[0].validityPeriodDesc"+i);            
			if(validityPeriodDesc1!=undefined)
			 {
               rtn_validityPeriodDesc=rtn_validityPeriodDesc+validityPeriodDesc1.value+"|";
			 }

			var eligibilityCode1=eval("parent.frames[1].document.forms[0].eligibilityCode"+i);            
			if(eligibilityCode1!=undefined)
			 {
               rtn_eligibilityCode=rtn_eligibilityCode+eligibilityCode1.value+"|";
			 }

			var transactionId1=eval("parent.frames[1].document.forms[0].transactionId"+i);            
			if(transactionId1!=undefined)
			 {
               rtn_transactionId=rtn_transactionId+transactionId1.value+"|";
			 }

			var responseDateTime1=eval("parent.frames[1].document.forms[0].responseDateTime"+i);            
			if(responseDateTime1!=undefined)
			 {
               rtn_responseDateTime=rtn_responseDateTime+responseDateTime1.value+"|";
			 }

			//above code was added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check
			
			//V232504
			var mcn_for_policy_val=eval("parent.frames[1].document.forms[0].mcn_for_policy"+i);            
			if(mcn_for_policy_val!=undefined)
			 {
               rtn_mcn_for_policy=rtn_mcn_for_policy+mcn_for_policy_val.value+"|";
			 }
			
			//V232504
			var reg_ref_id_val=eval("parent.frames[1].document.forms[0].reg_ref_id"+i);            
			if(reg_ref_id_val!=undefined)
			 {
               rtn_reg_ref_id=rtn_reg_ref_id+reg_ref_id_val.value+"|";
			 }

	}

	document.forms[0].total_records.value=total_records;
	document.forms[0].rtn_ins_blng_grp_desc.value=rtn_ins_blng_grp_desc;
	document.forms[0].rtn_ins_blng_grp.value=rtn_ins_blng_grp;
	document.forms[0].rtn_ins_payer_desc.value=rtn_ins_payer_desc;
	document.forms[0].rtn_ins_cust_code.value=rtn_ins_cust_code;
	document.forms[0].rtn_ins_cust_priority.value=rtn_ins_cust_priority;
	document.forms[0].rtn_ins_policy_type_desc.value=rtn_ins_policy_type_desc;
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
	document.forms[0].rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;	document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;
	document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;
	document.forms[0].rtn_ins_restrict_check.value=rtn_ins_restrict_check;
	document.forms[0].rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;
	document.forms[0].rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;
	document.forms[0].rtn_ins_valid_payer_YN.value=rtn_ins_valid_payer_YN;
	document.forms[0].rtn_ins_valid_policy_type_code_YN.value=rtn_ins_valid_policy_type_code_YN;
	document.forms[0].rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;
	document.forms[0].rtn_ins_cust_group_name.value=rtn_ins_cust_group_name;
	document.forms[0].rtn_ins_policy_coverage_basis_ind.value=rtn_ins_policy_coverage_basis_ind;

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
	
	//V232504
	document.forms[0].rtn_mcn_for_policy.value=rtn_mcn_for_policy;
	//V232504
	document.forms[0].rtn_reg_ref_id.value=rtn_reg_ref_id;
	
	
	parent.window.returnValue = "accept";
	parent.frames[3].location.href='../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpSubmitValues.jsp';
	
	var showModalFrame = top.window.document.getElementById('dialog-body').contentWindow;	
	let dialogBody = showModalFrame.document.getElementById('dialog-body');
	
    dialogBody.contentWindow.returnValue = "accept";
	const dialogTag = showModalFrame.document.getElementById("dialog_tag");  
    dialogTag.close(); 

//	parent.window.close();
	
}
</script>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	
</head>
<%
if((billing_mode.equals("Modify")) || (operation.equals("Update")))
{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
}
else
{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
}
%>

<form name='' id=''>

<table cellpadding=0 cellspacing=0 border=0 width="100%" align='center' border=1>
<tr  >
	
	<td>
		<input  type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_PAYERS.label","bl_labels")%>" class="button" onClick="addPayer()" >
		<input  type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.MODIFY_PAYER.label","bl_labels")%>" class="button" onClick="modifyPayer()">
		<input  type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.REMOVE_PAYER.label","bl_labels")%>" class="button" onClick="removePayerNew()">


    </td>
</tr>

<tr>
	
	<td align=right>
	<input align=right type="button" name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class="button" onClick='add_more_blng_grp()' >

	<input align=right type="button" name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class="button"  onClick='cancel()' >
	</td>
</tr>

</table>

<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value='<%=ins_auth_flag%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type=hidden name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value='<%=strCreditDoc_YN%>'>
<input type=hidden name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
<input type=hidden name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
<input type='hidden' name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	
<input type=hidden name="operation_fun" id="operation_fun" value='<%=operation%>'>	
<input type=hidden name="operation_mode" id="operation_mode" value='<%=billing_mode%>'>	
<input type='hidden' name='CitizenYn' id='CitizenYn' value='<%=strCitizenYn%>'>
<input type=hidden name='blnggrpappyn' id='blnggrpappyn' value='<%=strBlngGrpAppYN%>'>		
<input type=hidden name='blnggrpcatgappyn' id='blnggrpcatgappyn' value='<%=strBlngGrpCatgAppYN%>'>
<input type=hidden name='BlngGrpStatus' id='BlngGrpStatus' value='<%=strBlngGrpStatus%>'>
<input type=hidden name='mpolicy_type' id='mpolicy_type' value="<%=mpolicy_type%>">
<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
<input type= hidden name="queryString" id="queryString"  value="<%=queryString%>">
<input type= hidden name="policy_coverage_basis_gbl_ind_from_main" id="policy_coverage_basis_gbl_ind_from_main"  value='<%=policy_coverage_basis_gbl_ind_from_main%>'>

<input type='hidden' name='max_priority' id='max_priority' value='<%=max_priority%>' >

<input type= hidden name="primary_blng_grp" id="primary_blng_grp"  value="<%=primary_blng_grp%>">
<input type= hidden name="billing_group" id="billing_group"  value="<%=billing_group%>">
<input type= hidden name="p_patient_class" id="p_patient_class"  value='<%=p_patient_class%>'>
<input type= hidden name="facility_id" id="facility_id"  value='<%=facility_id%>'>

<input type= hidden name="total_records" id="total_records" value="">
<input type='hidden' name='rtn_ins_blng_grp_desc' id='rtn_ins_blng_grp_desc' value="">
<input type='hidden' name='rtn_ins_blng_grp' id='rtn_ins_blng_grp' value="">
<input type='hidden' name='rtn_ins_payer_desc' id='rtn_ins_payer_desc' value="">
<input type='hidden' name='rtn_ins_cust_code' id='rtn_ins_cust_code' value="">
<input type='hidden' name='rtn_ins_cust_priority' id='rtn_ins_cust_priority' value="">
<input type='hidden' name='rtn_ins_policy_type_desc' id='rtn_ins_policy_type_desc' value="">
<input type='hidden' name='rtn_ins_policy_type_code' id='rtn_ins_policy_type_code' value="">
<input type='hidden' name='rtn_ins_policy_no' id='rtn_ins_policy_no' value="">
<input type='hidden' name='rtn_ins_policy_start_date' id='rtn_ins_policy_start_date' value="">
<input type='hidden' name='rtn_ins_policy_expiry_date' id='rtn_ins_policy_expiry_date' value="">
<input type='hidden' name='rtn_ins_credit_auth_ref' id='rtn_ins_credit_auth_ref' value="">
<input type='hidden' name='rtn_ins_credit_auth_date' id='rtn_ins_credit_auth_date' value="">
<input type='hidden' name='rtn_ins_cred_auth_req_yn' id='rtn_ins_cred_auth_req_yn' value="">
<input type='hidden' name='rtn_ins_cred_auth_mand_capt_yn' id='rtn_ins_cred_auth_mand_capt_yn' value="">
<input type='hidden' name='rtn_ins_dflt_auth_ref_as_pol_no_yn' id='rtn_ins_dflt_auth_ref_as_pol_no_yn' value="">
<input type='hidden' name='rtn_ins_credit_approval_days' id='rtn_ins_credit_approval_days' value="">
<input type='hidden' name='rtn_ins_credit_approval_amount' id='rtn_ins_credit_approval_amount' value="">
<input type='hidden' name='rtn_ins_policy_eff_from_date' id='rtn_ins_policy_eff_from_date' value="">
<input type='hidden' name='rtn_ins_policy_eff_to_date' id='rtn_ins_policy_eff_to_date' value="">
<input type='hidden' name='rtn_ins_adj_rule_ind' id='rtn_ins_adj_rule_ind' value="">
<input type='hidden' name='rtn_ins_adj_perc_amt_ind' id='rtn_ins_adj_perc_amt_ind' value="">
<input type='hidden' name='rtn_ins_adj_perc_amt_value' id='rtn_ins_adj_perc_amt_value' value="">
<input type='hidden' name='rtn_ins_pmnt_diff_adj_int' id='rtn_ins_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_ins_drg_pmnt_diff_adj_int' id='rtn_ins_drg_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_ins_spl_srv_pmnt_diff_adj_int' id='rtn_ins_spl_srv_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_ins_restrict_check' id='rtn_ins_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_amt_restrict_check' id='rtn_ins_apprd_amt_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_days_restrict_check' id='rtn_ins_apprd_days_restrict_check' value="">

<input type='hidden' name='rtn_ins_valid_payer_YN' id='rtn_ins_valid_payer_YN' value="">
<input type='hidden' name='rtn_ins_valid_policy_type_code_YN' id='rtn_ins_valid_policy_type_code_YN' value="">
<input type='hidden' name='rtn_ins_cust_group_code' id='rtn_ins_cust_group_code' value="">
<input type='hidden' name='rtn_ins_cust_group_name' id='rtn_ins_cust_group_name' value="">
<input type='hidden' name='rtn_ins_policy_coverage_basis_ind' id='rtn_ins_policy_coverage_basis_ind' value="">

<input type='hidden' name='rtn_ref_src_main_code' id='rtn_ref_src_main_code' value="">
<input type='hidden' name='rtn_ref_src_main_desc' id='rtn_ref_src_main_desc' value="">
<input type='hidden' name='rtn_ref_src_sub_code' id='rtn_ref_src_sub_code' value="">
<input type='hidden' name='rtn_ref_src_sub_desc' id='rtn_ref_src_sub_desc' value="">	

<input type='hidden' name='rtn_payerEligibilityParamSession' id='rtn_payerEligibilityParamSession' value="">
<input type='hidden' name='rtn_responseCode' id='rtn_responseCode' value="">
<input type='hidden' name='rtn_responseCodeDesc' id='rtn_responseCodeDesc' value="">
<input type='hidden' name='rtn_statuDescription' id='rtn_statuDescription' value="">
<input type='hidden' name='rtn_validityPeriod' id='rtn_validityPeriod' value="">
<input type='hidden' name='rtn_validityPeriodDesc' id='rtn_validityPeriodDesc' value="">
<input type='hidden' name='rtn_eligibilityCode' id='rtn_eligibilityCode' value="">
<input type='hidden' name='rtn_transactionId' id='rtn_transactionId' value="">
<input type='hidden' name='rtn_responseDateTime' id='rtn_responseDateTime' value="">

<input type='hidden' name='package_enabled_yn' id='package_enabled_yn' value='<%=package_enabled_yn%>'>

<input type='hidden' name='encounter_date_time' id='encounter_date_time' value='<%=encounter_date_time%>'>

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>

<input type='hidden' name='rtn_mcn_for_policy' id='rtn_mcn_for_policy' value="">  <!-- V232504 -->
<input type='hidden' name='rtn_reg_ref_id' id='rtn_reg_ref_id' value="">  <!-- V232504 -->



</form>
</body>

<script>
	parent.parent.frames[2].location.href="../../eCommon/html/blank.html";
</script>
</html>
<%
	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

