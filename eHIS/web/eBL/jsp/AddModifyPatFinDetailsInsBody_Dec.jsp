<!DOCTYPE html>
<%@page import="com.google.gson.JsonObject"%>
<%@ page import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*,java.text.*,eXH.InterfaceUtil,eBL.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script>
/* karthik added the below function to provide the link for Policy Definition 38144	MMS-QH-CRF-0082 - starts*/
 /*
Sr No        Version           Incident        SCF/CRF               Developer Name
-----------------------------------------------------------------------------------
1            V210629             19794        MMS-ME-SCF-0025-TF     Mohana priya K
2			 V220908							TH-KW-CRF-0093 			Namrata Charate
3			 V230315							MMS-DM-CRF-0209.5		Namrata Charate
4			 V232504							SKR-SCF-1731-TF         Namrata Charate
5			 V230707							AAKH-CRF-0142.1			Namrata Charate
*/
async function callPolicyDetails(count){
	var dialogHeight= "34" ;
	var dialogWidth	= "84" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;	 
	
	var ins_cust_group_name = eval("document.add_modify_pat_fin_det_insmain.ins_cust_group_code"+count);
	var payerGroup=ins_cust_group_name.value;
	var cust_3 = eval("document.add_modify_pat_fin_det_insmain.cust_3"+count);
	var payerCode=cust_3.value;
	var policy_type_code = eval("document.add_modify_pat_fin_det_insmain.policy_type_code"+count);
	var policy=policy_type_code.value;
	var policy_start_date = eval("document.add_modify_pat_fin_det_insmain.policy_start_date"+count);
	var startDate=policy_start_date.value;
	var policy_exp_date = eval("document.add_modify_pat_fin_det_insmain.policy_exp_date"+count);
	var endDate=policy_exp_date.value;
	var priority_form = eval("document.add_modify_pat_fin_det_insmain.priority"+count);
	var priority=priority_form.value;
	var policy_no = eval("document.add_modify_pat_fin_det_insmain.policy_no"+count);
	var policyNo=policy_no.value;
	var episodeType=document.add_modify_pat_fin_det_insmain.episode_type.value;

	// Patient Id Parameter is passed as null to get Policy Details, If patient_id,episode_id,visit_id,acctseq  is given then Encounter specific Policy Defn will be Loaded
	var queryParams='mode=modify&patinetId=&payergroupCode='+ payerGroup  +
	'&payerCode='+payerCode+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&visitId='+'&acctSeq=&priority='+priority+
	'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+'&auth=N';
		
	var retVal =await window.showModalDialog('../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?'+queryParams,arguments,features);
}
/* karthik added the below function to provide the link for Policy Definition 38144	MMS-QH-CRF-0082 - ends*/
</script>
<html>
<%!
private String FinDtlsQueryFormation(String payerList,String facility_id,String billing_group,String p_patient_class){
	String sql_default = "";
		
	ArrayList<String> arPayerList=new ArrayList<String>();
	String queryFramed="";

	StringTokenizer stTilt=new StringTokenizer(payerList,"~");
	
	while(stTilt.hasMoreTokens()){
		arPayerList.add(stTilt.nextToken());
	}

	for(int pc=0;pc<arPayerList.size();pc++){	
		
		if(pc!=0)  queryFramed+=" OR "; 	
		
		StringTokenizer stPipe=new StringTokenizer(arPayerList.get(pc),"|");
		while(stPipe.hasMoreTokens()){
			queryFramed+= " (a.blng_grp_id = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_group_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.policy_type_code = '"+stPipe.nextToken()+"'"+
	                      " ) ";
			if(stPipe.hasMoreTokens()){
				stPipe.nextToken();
			}
			
		}
	}	
	sql_default="SELECT DISTINCT a.cust_code cust_code, NULL cust_short_name, "+
            "a.policy_type_code policy_type_code, NULL policy_short_desc, "+
            "a.priority_no priority_no, a.adj_rule_ind adj_rule_ind, "+
            "a.adj_perc_amt_ind adj_perc_amt_ind, "+
            "a.adj_perc_amt_value adj_perc_amt_value, "+
            "a.pmnt_diff_adj_int pmnt_diff_adj_int, "+
            "a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int, "+
            "a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, "+
            "a.cust_group_code cust_group_code, d.policy_coverage_basis, "+
            "NULL short_desc,e.INTERFACE_YN, D.POLICY_EFF_TO "+ //Added by shikha on 01-06-2020
       "FROM bl_payers_priority_by_bg a, "+
            "bl_ins_policy_types b, "+
            "ar_customer c, "+
            "bl_ins_policy_type_hdr d, "+
            "ar_cust_group e, "+
            "bl_cust_by_cust_group f "+
      "WHERE a.operating_facility_id = '"+facility_id+"' "+
        "AND a.blng_grp_id = '"+billing_group+"' "+
        "AND a.patient_class = '"+p_patient_class+"' "+
        "AND c.acc_entity_code = e.acc_entity_code "+
        "AND e.acc_entity_code = f.acc_entity_code "+
        "AND a.operating_facility_id = b.operating_facility_id "+
        "AND a.operating_facility_id = d.operating_facility_id "+
        "AND (a.cust_code = d.cust_code OR d.cust_code = '**') "+
        "AND (c.cust_code = a.cust_code OR a.cust_code = '**') "+
        "AND c.cust_code = f.cust_code "+
        "AND a.cust_group_code = f.cust_group_code "+
        "AND a.cust_group_code = d.cust_group_code "+
        "AND d.cust_group_code = e.cust_group_code "+
        "AND a.policy_type_code = b.policy_type_code "+
        "AND a.policy_type_code = d.policy_type_code "+
        "AND(  "+
        queryFramed +
        ")  ORDER BY a.priority_no ";
	
	return sql_default;
}
%>
<%
		String bean_id1		=	"";
	String bean_name1	=	"";
	String policy_no=request.getParameter("policy_no");
	boolean siteSpecUploadDocAll = false;
	String isExtnJSPLoaded = "N";
	HashMap 	blInsuranceImageList	=	null;
	BLInsuranceImageBean blInsuranceImageBean 	= 	null;
	BLInsuranceImage	blInsuranceImage = null;	
	int index1=0;
	bean_id1	= 	"bl_blinsuranceimagebean" ;
	bean_name1	= 	"eBL.BLInsuranceImageBean";
	Connection con1		= null;
	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean = 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, request );
	con1	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
	if(siteSpecUploadDocAll)
	{
		blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
		Object ob[] =(blInsuranceImageList.keySet()).toArray();
		Arrays.sort(ob); //Added V190612 DHANANAJAY/IN70646
		for(index1=0;index1<ob.length;index1++)
		{
			String arr1 = ob[index1].toString();
			String[] val1 = arr1.split("_");
			if(val1[0].equals(policy_no))
			{
			blInsuranceImageList.remove(arr1);
			}
		}
	}
	Boolean Site_spec=false;
	String siteSpecMemberID ="";
	Connection conn = null; 
	Connection conNew = null;
	PreparedStatement pstmtNew = null ;
	ResultSet rsNew = null;
	try
	{
		conn = ConnectionManager.getConnection();	
		Site_spec = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","MEMBERSHIP_ID_MANDATORY");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	if(Site_spec){
		siteSpecMemberID="Y";
	}
	else{
		siteSpecMemberID="N";
	}
	if(siteSpecMemberID.equals("Y"))
	{
		String New_slmt_ind = "";
		String BillingNewGroup=request.getParameter("billing_group");
		conNew = ConnectionManager.getConnection();
		String Set_Indicator_query="select settlement_ind from bl_blng_grp where blng_grp_id = ? ";
		pstmtNew = conNew.prepareStatement(Set_Indicator_query);
		pstmtNew.setString(1,BillingNewGroup);
		rsNew = pstmtNew.executeQuery() ;
		if( rsNew != null ) 
		{
			while( rsNew.next() )
			{  
				New_slmt_ind = rsNew.getString("settlement_ind");
			}
		}
		if (rsNew != null) rsNew.close();
		pstmtNew.close();
		
		String priority_MemberId=request.getParameter("Mem_Priority");
		String totalrecords=request.getParameter("total_records");
		if(totalrecords==null) totalrecords="";//GHL-CRF-0550.1
		if(totalrecords == null){
			System.err.println("total_records retrived null");	
		}
		else if(totalrecords.equals("0")){
			HashMap<String,String>  MembershipIdRemove=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION"); 
			MembershipIdRemove.remove(priority_MemberId);
		}	
		if(New_slmt_ind.equals("X")){
		try{
			HashMap<String,String> claimCreditMap=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION");
			String claim_code="";
			String credit_authorisation_by="";
			String membershipId="";
			String claimCredit="";
			String priority=request.getParameter("priority");
			if(claimCreditMap!=null){
				claimCredit=claimCreditMap.get(priority);	
				if(claimCredit!=null){		
					String[] arrClaimCredit= claimCredit.split("~");
					HashMap RemoveMember	= (HashMap)session.getAttribute("financial_details"); 
					String MemberNumber=(String) RemoveMember.get("membership_number");
					String curMemberId=arrClaimCredit[2];
					
					String NewFin_Dlts="";
					String [] Memberarr=MemberNumber.split("\\|");
					for(int iMem=0;iMem<Memberarr.length;iMem++){
						if(!Memberarr[iMem].equals(curMemberId)){
							NewFin_Dlts=NewFin_Dlts+curMemberId+"|";
						}
					}
					RemoveMember.put("membership_number",NewFin_Dlts);
					session.setAttribute("financial_details",(HashMap)RemoveMember);			
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
	JsonObject objFromBean = null;
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	Connection con				= null;
 	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	String payerGrpBySetup = "";
	String strChargeLogicYN = "";
	String orgPolEffToDate=""; // Added By Vijay for MMS-QF-SCF-567
	String sql="";
	String locale			= (String)session.getAttribute("LOCALE");

		request.setCharacterEncoding("UTF-8");
		/************** package Billing Changes ********start************/
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
			String facility_id = (String)httpSession.getValue("facility_id");
			String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		String package_enabled_yn = "N";		
		package_enabled_yn = bean.getBlPkgYN(facility_id);	
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";
		/************** package Billing Changes ********end************/	
		String queryString=(request.getQueryString());
		
		String DFLT_POLICY_DEF_IN_VIS_REG_YN=null;
		objFromBean = addModifyBean.getDfltPlcyAndPyrGrpSetup(con, facility_id);
		DFLT_POLICY_DEF_IN_VIS_REG_YN = objFromBean.get("dfltPolicyDefInVisRegnYn").getAsString();
		payerGrpBySetup = objFromBean.get("payerGrpBySetup").getAsString();
		strChargeLogicYN = objFromBean.get("strChargeLogicYN").getAsString();
		objFromBean = null;	
		String calling_function_id="";
		String checked_row="";
		String record_count="";
		int total_records=0;
		int selected_index=0;	
		String new_blng_grp_name="";
		String existing_blng_grp_name="";
		String billing_group_desc="";
		String blng_grp_values="";
		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
		String valid_payer_YN="";
		String valid_policy_type_code_YN="";
		String cust_group_code="", cust_group_name = "";
		String policy_coverage_basis_gbl_ind="";
		String policy_coverage_basis_ind="";
		String str_currency_code_for_bg="", str_currency_desc_for_bg="";
		String policy_start_date_conv="";
		String policy_exp_date_conv="";
		String credit_auth_date_conv="";
		String policy_eff_frm_date_conv="";
		String policy_eff_to_date_conv="";
		String policy_eff_to_date_Org=""; //Added By Vijay for MMS-QF-SCf-567
		String pol_validity_chk_date="";
		String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
		String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
		String fin_dtls_updated_YN="N", fin_class_dtls_updated_YN="N";
		String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";
		String cust_valid_from_date = "" ,cust_valid_to_date = "";
		String referral_source_code_flag="N";
		String referral_source_main_mand_YN="N";
		String referral_source_sub_mand_YN="N";
		String pr_payer_employer_id_mand_YN = "N";
		String blng_grp_code_for_pkg_use="", str_valid_pkg_for_pat_bg_avail_YN="N";
		String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";
		String def_req_pol_date_avail_YN = "N";
		String payer_suspended_YN = "N", policy_suspended_YN = "N";
		String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
		ArrayList new_records_array=null;
		ArrayList existing_records_array=new ArrayList();
		ArrayList existing_records_array1=new ArrayList();
		calling_function_id = request.getParameter("calling_function_id");
		if(calling_function_id == null) calling_function_id="";
		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";	
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";//muthu - 32139
		String refresh_check=request.getParameter("refresh_check");
		if(refresh_check==null) refresh_check="N";
		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";
		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";
		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";	
		Boolean siteSpec=false;
		Boolean siteSpecPolApprv = false; //Added V190517-Aravindh/NMC-JD-CRF-0010
		try
		{
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_DFLT_POL_EXP_DAYS_CONFIG");
			String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facility_id+"'";
			pstmt = con.prepareStatement(polApprvSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String enablePolicyApprvl = rs.getString("enable_policy_approval_yn");
				if("Y".equals(enablePolicyApprvl)) {
					siteSpecPolApprv = true;
				}
			}
			rs.close();
			if(pstmt != null) pstmt.close();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		if(refresh_check.equals("Y"))
		{
			String priority_1_blng_grp_code="";
			int priority_1_blng_grp_index=0;
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			for(int i=0;i<total_records;i++)
			{
				String temp_blng_grp_code=request.getParameter("blng_grp_code"+i);
				String temp_priority=request.getParameter("priority"+i);
				if(temp_priority.equals("1"))
				{
					priority_1_blng_grp_code=temp_blng_grp_code;
					blng_grp_code_for_pkg_use = temp_blng_grp_code;
				}
			}
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";	
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
					if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
					if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
					if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
					if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))	
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
			//	String[] records=new String[53];  //V232504
				String[] records=new String[55];  //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				records[0]=billing_group_desc;
				records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				records[2]=request.getParameter("payer_desc"+i);
				records[3]=request.getParameter("cust_3"+i);
				records[4]=request.getParameter("priority"+i);
				records[5]=request.getParameter("policy_type_desc"+i);
				records[6]=request.getParameter("policy_type_code"+i);
				records[7]=request.getParameter("policy_no"+i);
				records[8]=policy_start_date_conv;
				records[9]=policy_exp_date_conv;
				records[10]=request.getParameter("credit_auth_ref"+i);
				records[11]=credit_auth_date_conv;
				records[12]=request.getParameter("credit_apprd_amt"+i);
				records[13]=request.getParameter("credit_apprd_days"+i);
				records[14]=policy_eff_frm_date_conv;
				records[15]=policy_eff_to_date_conv;
				records[16]=request.getParameter("adj_rule_ind"+i);
				records[17]=request.getParameter("adj_perc_amt_ind"+i);
				records[18]=request.getParameter("adj_perc_amt_value"+i);
				records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				records[22]=request.getParameter("restrict_check"+i);
				records[23]=request.getParameter("valid_payer_YN"+i);
				records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				records[25]=request.getParameter("ins_cust_group_code"+i);
				records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				records[27]=request.getParameter("referral_source_main_code"+i);
				records[28]=request.getParameter("referral_source_main_desc"+i);
				records[29]=request.getParameter("referral_source_sub_code"+i);
				records[30]=request.getParameter("referral_source_sub_desc"+i);
				records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				records[32]=request.getParameter("apprd_days_restrict_check"+i);
				records[33]=request.getParameter("cred_auth_req_yn"+i);
				records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				records[35]=request.getParameter("cust_valid_from_date"+i);
				records[36]=request.getParameter("cust_valid_to_date"+i);
				records[37]=request.getParameter("ins_cust_group_name"+i);
				records[39]=request.getParameter("rec_edited_YN"+i);
				records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
                records[41]=request.getParameter("payerEligibilityParam"+i);
				records[42]=request.getParameter("responseCode"+i);
				records[43]=request.getParameter("responseCodeDesc"+i);
				records[44]=request.getParameter("statuDescription"+i);
				records[45]=request.getParameter("validityPeriod"+i);
				records[46]=request.getParameter("validityPeriodDesc"+i);
				records[47]=request.getParameter("eligibilityCode"+i);
				records[48]=request.getParameter("transactionId"+i);
				records[49]=request.getParameter("responseDateTime"+i);
				records[51]=request.getParameter("mcn_for_policy"+i); //V232504
				records[52]=request.getParameter("reg_ref_id"+i); //V232504
				records[53]="";  //V230707
				records[54]="";  //V230707
				if(records[1].equals(priority_1_blng_grp_code))
				{
					existing_records_array.add(priority_1_blng_grp_index,records);
					priority_1_blng_grp_index++;
				}	
				else
					existing_records_array.add(records);
			}
			objFromBean = addModifyBean.getRefSourceFlagsForP1(priority_1_blng_grp_code, con);
			referral_source_code_flag= objFromBean.get("referral_source_code_flag").getAsString();
			referral_source_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			referral_source_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			pr_payer_employer_id_mand_YN = objFromBean.get("pr_payer_employer_id_mand_YN").getAsString();
		}
		String accept_check=request.getParameter("accept_check");
		if(accept_check==null) accept_check="";
		if(accept_check.equals("accept") )
		{
			HashMap new_blng_grp_records=(HashMap)session.getAttribute("new_blng_grp_records");
			new_blng_grp_name=(String)session.getAttribute("new_blng_grp_name");
			new_records_array=(ArrayList)new_blng_grp_records.get(new_blng_grp_name);
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
					if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
					if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
					if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
					if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
			//	String[] records=new String[53]; //V232504
				String[] records=new String[55]; //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				records[0]=billing_group_desc;
				records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				records[2]=request.getParameter("payer_desc"+i);
				records[3]=request.getParameter("cust_3"+i);
				records[4]=request.getParameter("priority"+i);
				records[5]=request.getParameter("policy_type_desc"+i);
				records[6]=request.getParameter("policy_type_code"+i);
				records[7]=request.getParameter("policy_no"+i);
				records[8]=policy_start_date_conv;
				records[9]=policy_exp_date_conv;
				records[10]=request.getParameter("credit_auth_ref"+i);
				records[11]=credit_auth_date_conv;
				records[12]=request.getParameter("credit_apprd_amt"+i);
				records[13]=request.getParameter("credit_apprd_days"+i);
				records[14]=policy_eff_frm_date_conv;
				records[15]=policy_eff_to_date_conv;
				records[16]=request.getParameter("adj_rule_ind"+i);
				records[17]=request.getParameter("adj_perc_amt_ind"+i);
				records[18]=request.getParameter("adj_perc_amt_value"+i);
				records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				records[22]=request.getParameter("restrict_check"+i);
				records[23]=request.getParameter("valid_payer_YN"+i);
				records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				records[25]=request.getParameter("ins_cust_group_code"+i);
				records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				records[27]=request.getParameter("referral_source_main_code"+i);
				records[28]=request.getParameter("referral_source_main_desc"+i);
				records[29]=request.getParameter("referral_source_sub_code"+i);
				records[30]=request.getParameter("referral_source_sub_desc"+i);
				
				records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				records[32]=request.getParameter("apprd_days_restrict_check"+i);
				records[33]=request.getParameter("cred_auth_req_yn"+i);
				records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				records[35]=request.getParameter("cust_valid_from_date"+i);
				records[36]=request.getParameter("cust_valid_to_date"+i);
				records[37]=request.getParameter("ins_cust_group_name"+i);
				records[39]="Y";
				records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
				records[41]=request.getParameter("payerEligibilityParam"+i);
				records[42]=request.getParameter("responseCode"+i);
				records[43]=request.getParameter("responseCodeDesc"+i);
				records[44]=request.getParameter("statuDescription"+i);
				records[45]=request.getParameter("validityPeriod"+i);
				records[46]=request.getParameter("validityPeriodDesc"+i);
				records[47]=request.getParameter("eligibilityCode"+i);
				records[48]=request.getParameter("transactionId"+i);
				records[49]=request.getParameter("responseDateTime"+i);	
				records[50]=policy_eff_to_date_conv;//Added V180806-Aravindh/ARYU-SCF-0113
				records[51]=request.getParameter("mcn_for_policy"+i);  //V232504					
				records[52]=request.getParameter("reg_ref_id"+i);  //V232504
				records[53]="";  //V230707
				records[54]="";  //V230707
				existing_records_array.add(records);
			}
		//	String[] output3=new String[53];  //V232504
			String[] output3=new String[55];  //V230707
			System.err.println("new_records_array size is: "+new_records_array.size());
			for(int j=0;j<new_records_array.size();j++)
			{	
				output3=(String[])new_records_array.get(j);
				existing_records_array.add(output3);
			}
		}
		String remove_check=request.getParameter("remove_check");	
		if(remove_check==null) remove_check="";
		if(checked_row==null) checked_row="";
		if(remove_check.equals("remove"))
		{
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="0";
			total_records=Integer.parseInt(record_count);
			checked_row=request.getParameter("checked_row");
			if(checked_row==null) checked_row="0";
			selected_index=Integer.parseInt(checked_row);
			for(int i=0;i<total_records;i++)
			{
				if(!(i==selected_index))
				{
					policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
					policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
						if(policy_exp_date_conv==null) policy_exp_date_conv="";
					credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
						if(credit_auth_date_conv==null) credit_auth_date_conv="";
					policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
						if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
					policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
						if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
						policy_eff_to_date_Org=request.getParameter("tmp_pol_eff_to"+i);	
						if(policy_eff_to_date_Org==null) policy_eff_to_date_Org=""; 
					if(!locale.equals("en"))
					{
						if(!policy_start_date_conv.equals(""))
							policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
						if(!policy_exp_date_conv.equals(""))
							policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
						if(!credit_auth_date_conv.equals(""))
							credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
						if(!policy_eff_frm_date_conv.equals(""))
							policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
						if(!policy_eff_to_date_conv.equals(""))
							policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
					}
					String[] records=new String[55];  //V230707
					billing_group_desc=request.getParameter("billing_group_desc"+i);
					if(billing_group_desc==null) billing_group_desc="";
					records[0]=billing_group_desc;
					records[1]=request.getParameter("blng_grp_code"+i);
					existing_blng_grp_name=records[1];
					records[2]=request.getParameter("payer_desc"+i);
					records[3]=request.getParameter("cust_3"+i);
					records[4]=request.getParameter("priority"+i);
					records[5]=request.getParameter("policy_type_desc"+i);
					records[6]=request.getParameter("policy_type_code"+i);
					records[7]=request.getParameter("policy_no"+i);
					records[8]=policy_start_date_conv;
					records[9]=policy_exp_date_conv;
					records[10]=request.getParameter("credit_auth_ref"+i);
					records[11]=credit_auth_date_conv;
					records[12]=request.getParameter("credit_apprd_amt"+i);
					records[13]=request.getParameter("credit_apprd_days"+i);
					records[14]=policy_eff_frm_date_conv;
					records[15]=policy_eff_to_date_conv;
					records[16]=request.getParameter("adj_rule_ind"+i);
					records[17]=request.getParameter("adj_perc_amt_ind"+i);
					records[18]=request.getParameter("adj_perc_amt_value"+i);
					records[19]=request.getParameter("pmnt_diff_adj_int"+i);
					records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
					records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
					records[22]=request.getParameter("restrict_check"+i);
					records[23]=request.getParameter("valid_payer_YN"+i);
					records[24]=request.getParameter("valid_policy_type_code_YN"+i);
					records[25]=request.getParameter("ins_cust_group_code"+i);
					records[26]=request.getParameter("policy_coverage_basis_ind"+i);
					records[27]=request.getParameter("referral_source_main_code"+i);
					records[28]=request.getParameter("referral_source_main_desc"+i);
					records[29]=request.getParameter("referral_source_sub_code"+i);
					records[30]=request.getParameter("referral_source_sub_desc"+i);
					records[31]=request.getParameter("apprd_amt_restrict_check"+i);
					records[32]=request.getParameter("apprd_days_restrict_check"+i);
					records[33]=request.getParameter("cred_auth_req_yn"+i);
					records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
					records[35]=request.getParameter("cust_valid_from_date"+i);
					records[36]=request.getParameter("cust_valid_to_date"+i);
					records[37]=request.getParameter("ins_cust_group_name"+i);
					records[39]=request.getParameter("rec_edited_YN"+i);
					records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
					records[41]=request.getParameter("payerEligibilityParam"+i);
					records[42]=request.getParameter("responseCode"+i);
					records[43]=request.getParameter("responseCodeDesc"+i);
					records[44]=request.getParameter("statuDescription"+i);
					records[45]=request.getParameter("validityPeriod"+i);
					records[46]=request.getParameter("validityPeriodDesc"+i);
					records[47]=request.getParameter("eligibilityCode"+i);
					records[48]=request.getParameter("transactionId"+i);
					records[49]=request.getParameter("responseDateTime"+i);
					records[50]=policy_eff_to_date_Org;	//Added By Vijay for MMS-QF-SCf-567
					records[51]=request.getParameter("mcn_for_policy"+i);  //V220908					
					records[52]=request.getParameter("reg_ref_id"+i);  //V230315
					records[53]=request.getParameter("userId_for_priv"+i);  //V230707
					records[54]=request.getParameter("reasonCode_for_priv"+i);  //V230707						
					existing_records_array.add(records);
				}else{
								/***************Package Billing Changes ***********start***************/
				if(package_enabled_yn.equals("Y")){
					String mapKey=request.getParameter("blng_grp_code"+i)+"~~"+request.getParameter("ins_cust_group_code"+i)+"~~"+request.getParameter("cust_3"+i)+"~~"+request.getParameter("priority"+i)+"~~"+request.getParameter("policy_type_code"+i)+"~~"+request.getParameter("policy_no"+i)+"~~"+request.getParameter("policy_eff_frm_date"+i);
					HashMap payerDtls=(HashMap)bean.getPayerDtls();
					if(payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
						payerDtls.remove(mapKey);
					bean.setPayerDtls(payerDtls);
					bean.setDetails(new ArrayList());	
					}
					/***************Package Billing Changes ***********end***************/
				}
			}
		}
		String add_check=request.getParameter("add_check");
		if(add_check==null) add_check="";
		if(add_check.equals("add"))
		{
			String ins_parameters=request.getParameter("retVal");
			if(ins_parameters==null || ins_parameters.equals("")) ins_parameters="";
			ins_parameters = java.net.URLDecoder.decode(ins_parameters,"UTF-8");
			StringTokenizer st=new StringTokenizer(ins_parameters,"^~^");
			String blng_grp_desc="";
			String[] records=new String[55];   //V230707
			int j=0;
			while(st.hasMoreTokens())
			{
				try{
					records[j]=st.nextToken();
					if(records[j].equals(" ")) records[j]="";
					j++;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			String blng_grp_code=records[1];
			objFromBean=addModifyBean.getblngGrpDesc(blng_grp_code,locale,con);
			blng_grp_desc=objFromBean.get("blng_grp_desc").getAsString();
			records[0]=blng_grp_desc;
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			String check_rec_avail="N";
			if(total_records >0)
			{
				for(int i=0;i<total_records;i++)
				{
					String temp_blng_grp_code=request.getParameter("blng_grp_code"+i);
					if(blng_grp_code.equals(temp_blng_grp_code))
					{
						records[27]=request.getParameter("referral_source_main_code"+i);
						records[28]=request.getParameter("referral_source_main_desc"+i);
						records[29]=request.getParameter("referral_source_sub_code"+i);
						records[30]=request.getParameter("referral_source_sub_desc"+i);
						check_rec_avail="Y";
					}
				}
			}
			else
			{
				records[27]="";
				records[28]="";
				records[29]="";
				records[30]="";
			}

			if(check_rec_avail.equals("N"))
			{
				records[27]="";
				records[28]="";
				records[29]="";
				records[30]="";
			}
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
				if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
				if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
				if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
				if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
				if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
				String[] existing_records=new String[55];   //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				existing_records[0]=billing_group_desc;
				existing_records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				existing_records[2]=request.getParameter("payer_desc"+i);
				existing_records[3]=request.getParameter("cust_3"+i);
				existing_records[4]=request.getParameter("priority"+i);
				existing_records[5]=request.getParameter("policy_type_desc"+i);
				existing_records[6]=request.getParameter("policy_type_code"+i);
				existing_records[7]=request.getParameter("policy_no"+i);
				existing_records[8]=policy_start_date_conv;
				existing_records[9]=policy_exp_date_conv;
				existing_records[10]=request.getParameter("credit_auth_ref"+i);
				existing_records[11]=credit_auth_date_conv;
				existing_records[12]=request.getParameter("credit_apprd_amt"+i);
				existing_records[13]=request.getParameter("credit_apprd_days"+i);
				existing_records[14]=policy_eff_frm_date_conv;
				existing_records[15]=policy_eff_to_date_conv;
				existing_records[16]=request.getParameter("adj_rule_ind"+i);
				existing_records[17]=request.getParameter("adj_perc_amt_ind"+i);
				existing_records[18]=request.getParameter("adj_perc_amt_value"+i);
				existing_records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				existing_records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				existing_records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				existing_records[22]=request.getParameter("restrict_check"+i);
				existing_records[23]=request.getParameter("valid_payer_YN"+i);
				existing_records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				existing_records[25]=request.getParameter("ins_cust_group_code"+i);
				existing_records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				existing_records[27]=request.getParameter("referral_source_main_code"+i);
				existing_records[28]=request.getParameter("referral_source_main_desc"+i);
				existing_records[29]=request.getParameter("referral_source_sub_code"+i);
				existing_records[30]=request.getParameter("referral_source_sub_desc"+i);
				existing_records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				existing_records[32]=request.getParameter("apprd_days_restrict_check"+i);
				existing_records[33]=request.getParameter("cred_auth_req_yn"+i);
				existing_records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				existing_records[35]=request.getParameter("cust_valid_from_date"+i);
				existing_records[36]=request.getParameter("cust_valid_to_date"+i);
				existing_records[37]=request.getParameter("ins_cust_group_name"+i);
				existing_records[39]=request.getParameter("rec_edited_YN"+i);
				existing_records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
				existing_records[41]=request.getParameter("payerEligibilityParam"+i);
				System.err.println("payerEligibilityParam is: "+existing_records[41]);
				existing_records[42]=request.getParameter("responseCode"+i);
				existing_records[43]=request.getParameter("responseCodeDesc"+i);
				existing_records[44]=request.getParameter("statuDescription"+i);
				existing_records[45]=request.getParameter("validityPeriod"+i);
				existing_records[46]=request.getParameter("validityPeriodDesc"+i);
				existing_records[47]=request.getParameter("eligibilityCode"+i);
				existing_records[48]=request.getParameter("transactionId"+i);
				existing_records[49]=request.getParameter("responseDateTime"+i);
				existing_records[50]=request.getParameter("tmp_pol_eff_to"+i);
				existing_records[51]=request.getParameter("mcn_for_policy"+i);  //V220908
				existing_records[52]=request.getParameter("reg_ref_id"+i);  //V230315
				existing_records[53]=request.getParameter("userId_for_priv"+i);  //V230707
				existing_records[54]=request.getParameter("reasonCode_for_priv"+i);  //V230707	
				existing_records_array1.add(existing_records);
			}
			String desc="";
			int count = 0;
			boolean flag = false;
			int size=existing_records_array1.size();
			for (int k=0;k<existing_records_array1.size();k++)
			{
				String[] record1 = (String[]) existing_records_array1.get(k);
				desc = record1[0];

				if(desc.equals(records[0]))
				{
					count++;
				}
				if(count > 0 && !desc.equals(records[0]))
				{
					count = k;
					flag = true;
					break;
				}
			}
			if(flag)
			{
				existing_records_array1.add(count,records);
			}
			else
			{
				count = size;
				existing_records_array1.add(count++,records);
			}
			int count1=0;
			for (int k=0;k<existing_records_array1.size();k++)
			{
				String[] record1 = (String[]) existing_records_array1.get(k);
				String blng_grp_id=record1[1];
				if(blng_grp_id.equals(request.getParameter("billing_group")))
				{
					existing_records_array.add(count1,record1);
					count1++;
				}
				else
				{
					existing_records_array.add(record1);
				}
			}
		}
		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";
		int totalRecords=0;
		String nd_settlement_ind ="";
		String nd_adm_rec_flag ="";
		String ins_auth_flag="";
		String cust_4="", cash_set_type2="", cash_insmt_ref1="";
		String rtn_ins_blng_grp="",rtn_ins_cust_group_code="",rtn_ins_cust_code="", rtn_ins_cust_priority="",rtn_ins_policy_type_code="", rtn_ins_policy_no="", rtn_mcn_for_policy="", rtn_reg_ref_id="";
		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="";
		String rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="";
		String rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";
		String rtn_ins_ref_src_main_code ="", rtn_ins_ref_src_main_desc="",rtn_ins_ref_src_sub_code="",rtn_ins_ref_src_sub_desc="";
		String rtn_ins_restrict_check = "", rtn_ins_apprd_amt_restrict_check = "", rtn_ins_apprd_days_restrict_check= "";
		String rtn_ins_cred_auth_req_yn="", rtn_ins_dflt_auth_ref_as_pol_no_yn ="", rtn_ins_cred_auth_mand_capt_yn ="";
		String rtn_payerEligibilityParamSession ="", rtn_responseCode="",rtn_responseCodeDesc="",rtn_statuDescription="";
		String rtn_validityPeriod ="", rtn_validityPeriodDesc="",rtn_eligibilityCode="",rtn_transactionId="",rtn_responseDateTime="";
		String rtn_userId_for_priv ="",rtn_reasonCode_for_priv ="";  //V230707	
		int j=0;
		StringTokenizer token_seperator=null;
		ArrayList mins_blng_grp=new ArrayList();
		ArrayList mcust_group_3=new ArrayList();
		ArrayList mcust_group_desc=new ArrayList();
		ArrayList mpayer_desc=new ArrayList();
		ArrayList mcust_3=new ArrayList();
		ArrayList mins_cust_priority=new ArrayList();
		ArrayList mpolicy_no=new ArrayList();
		ArrayList mpolicy_type_code=new ArrayList();
		ArrayList mpolicy_type_desc=new ArrayList();
		ArrayList mpolicy_start_date=new ArrayList();
		ArrayList mpolicy_expiry_date=new ArrayList();
		ArrayList mcredit_auth_ref=new ArrayList();
		ArrayList mcredit_auth_date=new ArrayList();
		ArrayList mcred_auth_req_yn=new ArrayList();
		ArrayList mcred_auth_mand_capt_yn=new ArrayList();
		ArrayList mdflt_auth_ref_as_pol_no_yn=new ArrayList();
		ArrayList mcredit_apprd_days=new ArrayList();
		ArrayList mcredit_apprd_amt=new ArrayList();
		ArrayList mpolicy_eff_frm_date=new ArrayList();
		ArrayList mpolicy_eff_to_date=new ArrayList();
		ArrayList m_mcn_for_policy=new ArrayList();  //V220908
		ArrayList m_reg_ref_id = new ArrayList();  //V230315
		ArrayList muserId_for_priv=new ArrayList();  //V230707
		ArrayList mreasonCode_for_priv=new ArrayList();  //V230707
		ArrayList madj_rule_ind=new ArrayList();
		ArrayList madj_perc_amt_ind=new ArrayList();
		ArrayList madj_perc_amt_value=new ArrayList();
		ArrayList mpmnt_diff_adj_int=new ArrayList();
		ArrayList mdrg_pmnt_diff_adj_int=new ArrayList();
		ArrayList mspl_srv_pmnt_diff_adj_int=new ArrayList();
		ArrayList mref_ins_src_main_code=new ArrayList();
		ArrayList mref_ins_src_main_desc=new ArrayList();
		ArrayList mref_ins_src_sub_code=new ArrayList();
		ArrayList mref_ins_src_sub_desc=new ArrayList();
		ArrayList mrestrict_check=new ArrayList();
		ArrayList mapprd_amt_restrict_check=new ArrayList();
		ArrayList mapprd_days_restrict_check=new ArrayList();
		ArrayList mins_payerEligibilityParamSession=new ArrayList();
		ArrayList mins_responseCode=new ArrayList();
		ArrayList mins_responseCodeDesc=new ArrayList();
		ArrayList mins_statuDescription=new ArrayList();
		ArrayList mins_validityPeriod=new ArrayList();
		ArrayList mins_validityPeriodDesc=new ArrayList();
		ArrayList mins_eligibilityCode=new ArrayList();
		ArrayList mins_transactionId=new ArrayList();
		ArrayList mins_responseDateTime=new ArrayList();
		String  mnon_insur_blng_grp="", sys_date="",billing_group="";
		String rtn_slmt_type_code="";String rtn_non_ins_blng_grp="";
		String ref_src_main_lng_name = "";
		String ref_src_sub_lng_name = "";
		String strModuleId = "";
		strModuleId=request.getParameter("calling_module_id");
		if(strModuleId==null || strModuleId.equals("")) strModuleId="";
		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
		String p_patient_class  = request.getParameter("patient_class");
		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("AE")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}
		String episode_type="";
		if(strModuleId.equals("MP")) episode_type="R";
		else if(strModuleId.equals("AE")) episode_type="E";
		else if(strModuleId.equals("OP")) episode_type="O";
		else if(strModuleId.equals("IP")) episode_type="I";
		else if(strModuleId.equals("DC")) episode_type="D";
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";		
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}
		if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=(String)bl_data.get("blng_grp");
				rtn_ins_blng_grp=(String)bl_data.get("ins_blng_grp");
				rtn_slmt_type_code=(String)bl_data.get("slmt_type_code");
				rtn_ins_cust_group_code = (String)bl_data.get("ins_cust_group_code");
				rtn_ins_cust_code=(String)bl_data.get("ins_cust_code");
				rtn_ins_cust_priority=(String)bl_data.get("ins_cust_priority");
				rtn_ins_policy_type_code=(String)bl_data.get("ins_policy_type_code");
				rtn_ins_policy_no=(String)bl_data.get("ins_policy_no");
				rtn_ins_policy_start_date=(String)bl_data.get("ins_policy_start_date");
				rtn_ins_policy_expiry_date=(String)bl_data.get("ins_policy_expiry_date");
				rtn_ins_credit_auth_ref=(String)bl_data.get("ins_credit_auth_ref");
				rtn_ins_credit_auth_date=(String)bl_data.get("ins_credit_auth_date");
				rtn_ins_cred_auth_req_yn=(String)bl_data.get("ins_cred_auth_req_yn");
				rtn_ins_cred_auth_mand_capt_yn=(String)bl_data.get("ins_cred_auth_mand_capt_yn");
				rtn_ins_dflt_auth_ref_as_pol_no_yn=(String)bl_data.get("ins_dflt_auth_ref_as_pol_no_yn");
				rtn_ins_credit_approval_days=(String)bl_data.get("ins_credit_approval_days");
				rtn_ins_credit_approval_amount=(String)bl_data.get("ins_credit_approval_amount");
				rtn_ins_policy_eff_from_date=(String)bl_data.get("ins_policy_eff_from_date");
				rtn_ins_policy_eff_to_date=(String)bl_data.get("ins_policy_eff_to_date");
				rtn_mcn_for_policy=(String)bl_data.get("mcn_for_policy"); //V220908
				if(rtn_mcn_for_policy == null) rtn_mcn_for_policy="";
				rtn_reg_ref_id=(String)bl_data.get("reg_ref_id"); //V230315
				if(rtn_reg_ref_id == null) rtn_reg_ref_id="";
				rtn_userId_for_priv = ((String)bl_data.get("userId_for_priv"));   //V230707
				if(rtn_userId_for_priv == null) rtn_userId_for_priv="";
				rtn_reasonCode_for_priv = ((String)bl_data.get("reasonCode_for_priv"));   //V230707
				if(rtn_reasonCode_for_priv == null) rtn_reasonCode_for_priv="";
				rtn_ins_adj_rule_ind=(String)bl_data.get("ins_adj_rule_ind");
				rtn_ins_adj_perc_amt_ind=(String)bl_data.get("ins_adj_perc_amt_ind");
				rtn_ins_adj_perc_amt_value=(String)bl_data.get("ins_adj_perc_amt_value");
				rtn_ins_pmnt_diff_adj_int=(String)bl_data.get("ins_pmnt_diff_adj_int");
				rtn_ins_drg_pmnt_diff_adj_int=(String)bl_data.get("ins_drg_pmnt_diff_adj_int");
				rtn_ins_spl_srv_pmnt_diff_adj_int=(String)bl_data.get("ins_spl_srv_pmnt_diff_adj_int");
				rtn_ins_ref_src_main_code =(String)bl_data.get("ins_ref_src_main_code");
				if(rtn_ins_ref_src_main_code == null) rtn_ins_ref_src_main_code="";
				rtn_ins_ref_src_main_desc=(String)bl_data.get("ins_ref_src_main_desc");
				if(rtn_ins_ref_src_main_desc == null) rtn_ins_ref_src_main_desc="";
				rtn_ins_ref_src_sub_code=(String)bl_data.get("ins_ref_src_sub_code");
				if(rtn_ins_ref_src_sub_code == null) rtn_ins_ref_src_sub_code="";
				rtn_ins_ref_src_sub_desc=(String)bl_data.get("ins_ref_src_sub_desc");
				if(rtn_ins_ref_src_sub_desc == null) rtn_ins_ref_src_sub_desc="";
				rtn_ins_restrict_check=(String)bl_data.get("ins_restrict_check");
				if(rtn_ins_restrict_check == null) rtn_ins_restrict_check="";
				rtn_ins_apprd_amt_restrict_check=(String)bl_data.get("ins_apprd_amt_restrict_check");
				if(rtn_ins_apprd_amt_restrict_check == null) rtn_ins_apprd_amt_restrict_check="";
				rtn_ins_apprd_days_restrict_check=(String)bl_data.get("ins_apprd_days_restrict_check");
				if(rtn_ins_apprd_days_restrict_check == null) rtn_ins_apprd_days_restrict_check="";
				fin_dtls_updated_YN=(String)bl_data.get("fin_dtls_updated_YN");
				if(fin_dtls_updated_YN==null) fin_dtls_updated_YN="N";
				fin_class_dtls_updated_YN=(String)bl_data.get("fin_class_dtls_updated_YN");
				if(fin_class_dtls_updated_YN==null) fin_class_dtls_updated_YN="N";
				rtn_payerEligibilityParamSession=(String)bl_data.get("rtn_payerEligibilityParamSession");
				if(rtn_payerEligibilityParamSession == null) rtn_payerEligibilityParamSession="";
				rtn_responseCode=(String)bl_data.get("rtn_responseCode");
				if(rtn_responseCode == null) rtn_responseCode="";
				rtn_responseCodeDesc=(String)bl_data.get("rtn_responseCodeDesc");
				if(rtn_responseCodeDesc == null) rtn_responseCodeDesc="";
				rtn_statuDescription=(String)bl_data.get("rtn_statuDescription");
				if(rtn_statuDescription == null) rtn_statuDescription="";
				rtn_validityPeriod=(String)bl_data.get("rtn_validityPeriod");
				if(rtn_validityPeriod == null) rtn_validityPeriod="";
				rtn_validityPeriodDesc=(String)bl_data.get("rtn_validityPeriodDesc");
				if(rtn_validityPeriodDesc == null) rtn_validityPeriodDesc="";
				rtn_eligibilityCode=(String)bl_data.get("rtn_eligibilityCode");
				if(rtn_eligibilityCode == null) rtn_eligibilityCode="";
				rtn_transactionId=(String)bl_data.get("rtn_transactionId");
				if(rtn_transactionId == null) rtn_transactionId="";
				rtn_responseDateTime=(String)bl_data.get("rtn_responseDateTime");
				if(rtn_responseDateTime == null) rtn_responseDateTime="";
				cust_4=((String)bl_data.get("non_ins_cust_code")).trim();
				if(cust_4 == null) cust_4="";
				cash_set_type2=((String)bl_data.get("non_ins_slmt_type_code")).trim();
				if(cash_set_type2 == null) cash_set_type2="";
				cash_insmt_ref1=((String)bl_data.get("inst_ref")).trim();
				if(cash_insmt_ref1 == null) cash_insmt_ref1="";
				
				
				
				if(session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null){
				HashMap<String,String> claimCreditMapFromBean=new HashMap<String,String>();				
				claimCreditMapFromBean=addModifyBean.claimCreditMap(rtn_ins_cust_priority, rtn_ins_cust_group_code, rtn_ins_cust_code, rtn_ins_policy_start_date, rtn_ins_policy_expiry_date, rtn_ins_policy_eff_from_date, rtn_ins_policy_no, patient_id, con);
				session.setAttribute("CLAIM_CREDIT_MAP_SESSION", claimCreditMapFromBean);
			}
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
		}

		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		ArrayList<String> defaultLoadedBillingGroupInfo=new ArrayList<String>();
		String strDefaultInfo="";
		if(session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO")==null){
			
			StringTokenizer stCustGrpTok=new StringTokenizer(rtn_ins_cust_group_code,"|");
			StringTokenizer stCustCodeTok=new StringTokenizer(rtn_ins_cust_code,"|");
			StringTokenizer stCustPlcyTok=new StringTokenizer(rtn_ins_policy_type_code,"|");			
			while(stCustGrpTok.hasMoreTokens()){
				strDefaultInfo = stCustGrpTok.nextToken()+"|"+stCustCodeTok.nextToken()+"|"+stCustPlcyTok.nextToken();
				defaultLoadedBillingGroupInfo.add(strDefaultInfo);
			}			
			session.setAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO",defaultLoadedBillingGroupInfo);	
			
		}						
		try
		{
			String sql_trunc_time="select to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy') from dual";
			
			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
			
			rs = pstmt.executeQuery() ;
		if( rs!= null ) 
		{
			while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
					encounter_date_time = rs.getString(1);//muthu - 32139 
					sys_date = rs.getString(2);
				}				
			}
			if (rs != null)   rs.close();
		if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
		
		if(refresh_check.equals("Y"))
		{
			if(!blng_grp_code_for_pkg_use.equals("") && !patient_id.equals(""))
			{
				
				str_valid_pkg_for_pat_bg_avail_YN=addModifyBean.getPackageBlngGrpYn(facility_id, patient_id, episode_type, calling_function_id, blng_grp_code_for_pkg_use, encounter_date_aft_trunc, con);
			}
		}
		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strBlngGrpCatgAppYN = "Y";		
		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");
		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";
		String strCitizenYn = "N";		
		String nationalityyn = "";
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
		if(pstmt != null) pstmt.close();
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
		strModuleId = request.getParameter("calling_module_id");
		String strExtSettlType ="";
		String strSettlTypeOverride ="";		
		nationalityyn = request.getParameter("nationality_yn");		
	    if (nationalityyn == null) nationalityyn = "";	
		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
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
		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{
			String strTempFunId = request.getParameter("id_fun");
			if (strTempFunId== null)
			{
				strExtSettlType = rtn_slmt_type_code;
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

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			int rec_aval_check = 0;
		
			token_seperator=new StringTokenizer(rtn_ins_blng_grp,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_blng_grp.add(j,s1);
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_cust_group_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_name="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("")  || s1.equals(" ")) s1="";
				mcust_group_3.add(j,s1);
				if(!s1.equals(""))
				{
					String payer_group_sql="select SHORT_DESC short_name from ar_cust_group_lang_vw where cust_group_code='"+s1+"' and language_id='"+locale+"'";
					rec_aval_check = 0;
					pstmt = con.prepareStatement(payer_group_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null) 
					{
						while( rs.next() ) 
						{
							short_name=(String)rs.getString("short_name");
							if(short_name==null || short_name.equals("")) short_name="";
							mcust_group_desc.add(j,short_name);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mcust_group_desc.add(j,short_name);
						}
					}
					else
					{
						mcust_group_desc.add(j,"");
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mcust_group_desc.add(j,short_name);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cust_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_name="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("")  || s1.equals(" ")) s1="";
				mcust_3.add(j,s1);
				if(!s1.equals(""))
				{
					String payer_sql="select short_name from ar_customer_lang_vw where cust_code='"+s1+"' and language_id='"+locale+"' 	";
					rec_aval_check = 0;

					pstmt = con.prepareStatement(payer_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null) 
					{
						while( rs.next() ) 
						{
							short_name=(String)rs.getString("short_name");
							if(short_name==null || short_name.equals("")) short_name="";
							mpayer_desc.add(j,short_name);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mpayer_desc.add(j,short_name);
						}
					}
					else
					{
						mpayer_desc.add(j,"");
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mpayer_desc.add(j,short_name);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cust_priority,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				mins_cust_priority.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_type_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_desc="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_type_code.add(j,s1);

				if(!s1.equals(""))
				{
					String policy_type_desc_sql="select short_desc from bl_ins_policy_types_lang_vw where language_id='"+locale+"'  and  policy_type_code='"+s1+"'"; 
					rec_aval_check = 0;

					pstmt = con.prepareStatement(policy_type_desc_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null ) 
					{
						while( rs.next() ) 
						{
							short_desc=(String)rs.getString("short_desc");
							if(short_desc==null || short_desc.equals("")) short_desc="";
							mpolicy_type_desc.add(j,short_desc);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mpolicy_type_desc.add(j,short_desc);
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mpolicy_type_desc.add(j,short_desc);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_no,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_no.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_start_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_start_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_expiry_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_expiry_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			mnon_insur_blng_grp = rtn_non_ins_blng_grp;//rtn_non_ins_blng_grp 
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			token_seperator=new StringTokenizer(rtn_ins_credit_auth_ref,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_auth_ref.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_credit_auth_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_auth_date.add(j,s1);				 //rtn_ins_cust_priority
				
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_mcn_for_policy,"|");  //V220908
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				m_mcn_for_policy.add(j,s1);				 //rtn_mcn_for_policy
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_reg_ref_id,"|");  //V230315
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				m_reg_ref_id.add(j,s1);				 //reg_ref_id
				j++;
			}  
			//V230315
		
			token_seperator=new StringTokenizer(rtn_ins_cred_auth_req_yn,"|");
			j=0;
			
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mcred_auth_req_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cred_auth_mand_capt_yn,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mcred_auth_mand_capt_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}


			token_seperator=new StringTokenizer(rtn_ins_dflt_auth_ref_as_pol_no_yn,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mdflt_auth_ref_as_pol_no_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_credit_approval_days,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_apprd_days.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_credit_approval_amount,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_apprd_amt.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_eff_from_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_eff_frm_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_policy_eff_to_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_eff_to_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_adj_rule_ind,"|");
			j=0;
			madj_rule_ind.add(j,"");
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_rule_ind.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_adj_perc_amt_ind,"|");
			j=0;
			madj_perc_amt_ind.add(j,"");
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_perc_amt_ind.add(j,s1);
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_ins_adj_perc_amt_value,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_perc_amt_value.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_drg_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mdrg_pmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_spl_srv_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mspl_srv_pmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_main_code,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_main_code.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_main_desc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_main_desc.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_sub_code,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_sub_code.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_sub_desc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_sub_desc.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mrestrict_check.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_apprd_amt_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mapprd_amt_restrict_check.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_apprd_days_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mapprd_days_restrict_check.add(j,s1);				 
				j++;
			}
          
		token_seperator=new StringTokenizer(rtn_payerEligibilityParamSession,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_payerEligibilityParamSession.add(j,s1);				 
				j++;
			}
		if(mins_payerEligibilityParamSession.size()==0)
         mins_payerEligibilityParamSession=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_responseCode,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseCode.add(j,s1);				 
				j++;
			}
			if(mins_responseCode.size()==0)
            mins_responseCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

			
		token_seperator=new StringTokenizer(rtn_responseCodeDesc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseCodeDesc.add(j,s1);				 
				j++;
			}
			if(mins_responseCodeDesc.size()==0)
            mins_responseCodeDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_statuDescription,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_statuDescription.add(j,s1);				 
				j++;
			}
			if(mins_statuDescription.size()==0)
         mins_statuDescription=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_validityPeriod,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_validityPeriod.add(j,s1);				 
				j++;
			}
			if(mins_validityPeriod.size()==0)
         mins_validityPeriod=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_validityPeriodDesc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_validityPeriodDesc.add(j,s1);				 
				j++;
			}
			if(mins_validityPeriodDesc.size()==0)
         mins_validityPeriodDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_eligibilityCode,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_eligibilityCode.add(j,s1);				 
				j++;
			}
			if(mins_eligibilityCode.size()==0)
         mins_eligibilityCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_transactionId,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_transactionId.add(j,s1);				 
				j++;
			}
			if(mins_transactionId.size()==0)
            mins_transactionId=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_responseDateTime,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseDateTime.add(j,s1);				 
				j++;
			}
			if(mins_responseDateTime.size()==0)
            mins_responseDateTime=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());
		
		//V230707
		token_seperator=new StringTokenizer(rtn_userId_for_priv,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				muserId_for_priv.add(j,s1);				 
				j++;
			}
			
		//V230707
		token_seperator=new StringTokenizer(rtn_reasonCode_for_priv,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mreasonCode_for_priv.add(j,s1);				 
				j++;
			}
			
			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			visit_type_code		= request.getParameter("visit_type_code");
			if ( visit_type_code == null ) visit_type_code = "";
			
		}
		if((clinic_code==null) || (clinic_code.equals("null"))) clinic_code="";
		if((visit_type_code==null) || (visit_type_code.equals("null"))) visit_type_code="";
		objFromBean=addModifyBean.getSettlementIndAdmRec(operation, billing_mode, billing_group, con);
		nd_settlement_ind=objFromBean.get("nd_settlement_ind").getAsString();
		nd_adm_rec_flag=objFromBean.get("nd_adm_rec_flag").getAsString();
		strCreditDoc_YN=objFromBean.get("strCreditDoc_YN").getAsString();
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

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<STYLE TYPE="text/CSS">

.BACKGROUND {
  BACKGROUND-COLOR: RED;
}
/* This style is used for locking the table's heading  */
div#tbl-container {
width: 1020px;
height: 234px;
overflow: auto;
}
thead td, thead td.locked	{
position:relative;
}
thead td {
top: expression(document.getElementById("tbl-container").scrollTop-2); 
z-index: 20;
}
</STYLE>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/AddModifyPatFinDetails.js"></script>
<script language="javascript" src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

//Added By Vijay for MMS-QF-SCf-567
$(document).ready(function()
		{		
			var totRec=$('#totRec').val();
			var msg='';
			
			var siteSpec=$('#siteSpec').val();
			if(siteSpec=="true"){
			for(var i=0;i<totRec;i++)
				{
					var tmp_pol_eff_to=$('#tmp_pol_eff_to'+i).val();
					if(tmp_pol_eff_to==null||tmp_pol_eff_to=='null')
					tmp_pol_eff_to='';
					if(tmp_pol_eff_to=='')
					{
					
						msg+="message";
						//alert('Expiry date for' +payerGrp+ 'is not available in the Policy setup');
					}
				
				}
			
			if(msg!=''){alert('Expiry date is not available in the Policy setup');}
			}
			
			});
</script>


<script>


function check(i)
{
	document.add_modify_pat_fin_det_insmain.focussed_row.value=i;
}

function selected(i)
{
	var selected_row=eval("document.forms[0].selected_row"+i);
	if(selected_row.checked==false)
	{
		selected_row.checked=false;
		document.add_modify_pat_fin_det_insmain.checked_row.value="";
	}
	else
	{
		var total_records=document.forms[0].total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("document.forms[0].selected_row"+j);
			temp.checked=false;
		}
		selected_row.checked=true;
		document.add_modify_pat_fin_det_insmain.checked_row.value=i;
	}
}

function policy_coverage_basis_ind()
{
	var totalRecords=document.forms[0].total_records.value;
	if(totalRecords!=0)
	{
		for(var i=0;i<totalRecords;i++)
		{
			var valid_payer_YN=eval("document.forms[0].valid_payer_YN"+i);
			var valid_policy_type_code_YN=eval("document.forms[0].valid_policy_type_code_YN"+i);

			if(valid_payer_YN.value == "Y" && valid_policy_type_code_YN.value == "Y")
			{
				var policy_cov_basis_ind=eval(document.getElementById("policy_coverage_basis_"+i));
				var policy_cov_basis_ind_val=eval("document.forms[0].policy_coverage_basis_ind"+i);
				if(policy_cov_basis_ind_val.value=="P")
				{
					policy_cov_basis_ind.innerText=getLabel("eBL.PATIENT_BASED.label","BL");
				}
				else if(policy_cov_basis_ind_val.value=="I")
				{
					policy_cov_basis_ind.innerText=getLabel("eBL.PAYER_BASED.label","BL");
				}
			}
		}
	}
}

function ref_src_check()
{
	var refresh_check=document.forms[0].refresh_check.value;
	var total_records=document.forms[0].total_records.value;
	var valid_pkg_for_pat_bg_avail_YN = document.forms[0].valid_pkg_for_pat_bg_avail_YN.value;
	var patient_id = document.forms[0].patient_id.value;

	if(refresh_check=="Y")
	{
		var cap_ref_src_dtl_flag=document.forms[0].cap_ref_src_dtl_flag.value;
		var pmry_ref_src_mand_YN=document.forms[0].referral_source_main_mand_YN.value;
		var sec_ref_src_mand_YN=document.forms[0].referral_source_sub_mand_YN.value;
		var pr_payer_employer_id_mand_YN = document.forms[0].pr_payer_employer_id_mand_YN.value;
		var capture_employer_id_yn = parent.parent.parent.frames[0].document.forms[0].capture_employer_id_yn.value;

		if(cap_ref_src_dtl_flag=="Y")
		{
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_leg_disp").style.display="inline";
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_val_disp").style.display="inline";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value="";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value="";
			if(pmry_ref_src_mand_YN == "Y")
			{
				parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_mand_disp").style.display="inline";
			}
			else
			{
				parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_mand_disp").style.display="none";
			}

			parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_leg_disp").style.display="inline";
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_val_disp").style.display="inline";
			parent.parent.parent.frames[0].document.getElementById("referral_source_sub_code").value="";
			parent.parent.parent.frames[0].document.getElementById("referral_source_sub_desc").value="";
			if(sec_ref_src_mand_YN == "Y")
			{
				parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_mand_disp").style.display="inline";
			}
			else
			{
				parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_mand_disp").style.display="none";
			}

			parent.parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value="Y";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
			parent.parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
			if(total_records > 0)
			{
				for(var i=0;i<total_records;i++)
				{
					var temp_blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
					if(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)
					{
						var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
						parent.parent.parent.frames[0].document.getElementById("referral_source_main_code").value=ref_src_main_code1.value;

						var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
						parent.parent.parent.frames[0].document.getElementById("referral_source_main_desc").value=ref_src_main_desc1.value;

						var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
						parent.parent.parent.frames[0].document.getElementById("referral_source_sub_code").value=ref_src_sub_code1.value;

						var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
						parent.parent.parent.frames[0].document.getElementById("referral_source_sub_desc").value=ref_src_sub_desc1.value;

						var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

						if(blng_grp_visible.value == "Y")
						{
							var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));

							if(pmy_ref_src_lng_name.alt != "")
							{
								parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="visible";
								parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt=pmy_ref_src_lng_name.alt;
							}
							else
							{
								parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
								parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
							}

							var sec_ref_src_lng_name = document.getElementById("sec_ref_src_lng_name_"+i);

							if(sec_ref_src_lng_name.alt != "")
							{
								parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="visible";
								parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt=sec_ref_src_lng_name.alt;
							}
							else
							{
								parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
								parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
							}
						}
					}
				}
			}
		}
		else if(cap_ref_src_dtl_flag=="N")
		{
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_leg_disp").style.display="none";
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_main_val_disp").style.display="none";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value="";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value="";

			parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_leg_disp").style.display="none";
			parent.parent.parent.frames[0].document.getElementById("ref_src_code_sub_val_disp").style.display="none";
			parent.parent.parent.frames[0].document.getElementById("referral_source_sub_code").value="";
			parent.parent.parent.frames[0].document.getElementById("referral_source_sub_desc").value="";

			parent.parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value="N";
			parent.parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
			parent.parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;

			parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
			parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
			parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
			parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
		}
		
		if(capture_employer_id_yn == 'Y')
		{
			if(document.forms[0].pr_payer_employer_id_mand_YN.value == 'Y')
			{
				parent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = "Y";
				parent.parent.parent.frames[0].document.getElementById("emp_id_mand_YN_disp").style.display='inline';
			}
			else
			{
				parent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = "N";
				parent.parent.parent.frames[0].document.getElementById("emp_id_mand_YN_disp").style.display='none';
				parent.parent.parent.frames[0].document.forms[0].employer_code.value="";
			}
		}
		else
		{
			parent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = "N";
			parent.parent.parent.frames[0].document.forms[0].employer_code.value="";
			parent.parent.parent.frames[0].document.getElementById("emp_id_mand_YN_disp").style.display='none';
		}
		if(patient_id !="")
		{
			if(valid_pkg_for_pat_bg_avail_YN == "Y")
			{
				parent.parent.parent.frames[0].document.getElementById("vw_pkg_dtl_disp").style.display='inline';
			}
			else
			{
				parent.parent.parent.frames[0].document.getElementById("vw_pkg_dtl_disp").style.display='none';
			}
		}
		// This line of code is added for avoiding the refresh flag's value to be carried forward for other flags like add,accept so that duplication of records doesnt occur
		document.forms[0].refresh_check.value="N";
		/* *************************** *********************** */
	}
	var count = 0;
	if(refresh_check!="Y")
	{
		if(total_records >0)
		{
			for(var i=0;i<total_records;i++)
			{
				var temp_blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
				if(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)
				{
					count++;
				}
			}
		}
		if(count == 1)
		{
			for(var i=0;i<total_records;i++)
			{
				var temp_blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);

				if(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)
				{
					var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
					ref_src_main_code1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value;

					var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
					ref_src_main_desc1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value;

					var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
					ref_src_sub_code1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value;

					var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
					ref_src_sub_desc1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value;

					var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

					if(blng_grp_visible.value == "Y")
					{
						var pmy_ref_src_lng_name_hdr = parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt;

						if(pmy_ref_src_lng_name_hdr != "")
						{
							var pmy_ref_src_lng_name = document.getElementById("pmy_ref_src_lng_name_"+i);

							pmy_ref_src_lng_name.style.visibility="visible";
							pmy_ref_src_lng_name.alt=pmy_ref_src_lng_name_hdr;
						}
						else
						{
							var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));
							pmy_ref_src_lng_name.style.visibility="hidden";
						}

						var sec_ref_src_lng_name_hdr = parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt;

						if(sec_ref_src_lng_name_hdr != "")
						{
							var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));

							sec_ref_src_lng_name.style.visibility="visible";
							sec_ref_src_lng_name.alt=sec_ref_src_lng_name_hdr;
						}
						else
						{
							var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));
							sec_ref_src_lng_name.style.visibility="hidden";
						}
					}
				}
			}
		}
	}

	
}

function refsrclkup(cur_rec_blng_grp,sel_frm_prmy_sec,ref_desc,clng_evnt)
{
	var episode_type=document.forms[0].episode_type.value;
	var locale=document.forms[0].locale.value;
	var main_blng_grp=parent.parent.parent.frames[0].document.forms[0].billing_group.value;
	var total_records = document.forms[0].total_records.value;

	if(clng_evnt == 'B')
	{
		if(ref_desc.value == "")
		{
			if(sel_frm_prmy_sec == 'M')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;
						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
							ref_src_main_code1.value="";
							
							var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
							ref_src_main_desc1.value="";

							var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

							if(blng_grp_visible.value == "Y")
							{
								var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));
								pmy_ref_src_lng_name.style.visibility="hidden";
							}
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value="";
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value="";

						parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
						parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
					}
				}
			}

			if(sel_frm_prmy_sec == 'S')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;

						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
							ref_src_sub_code1.value="";

							var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
							ref_src_sub_desc1.value="";
						}

						var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

						if(blng_grp_visible.value == "Y")
						{
							var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));
							sec_ref_src_lng_name.style.visibility="hidden";
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value="";
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value="";

						parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="hidden";
						parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
					}
				}
			}
			return;
		}
	}

	var retVal			= new String();		
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";		
		
	var title=getLabel("Common.referralsource.label","common");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,20%,20%,30%,10%");               

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var short_desc=getLabel("Common.shortdescription.label","common");
	short_desc=encodeURIComponent(short_desc);
	var long_desc=getLabel("Common.longdescription.label","common");
	long_desc=encodeURIComponent(long_desc);
	var long_name=getLabel("Common.longname.label","common");
	long_name=encodeURIComponent(long_name);
	var org_type=getLabel("Common.OrganisationType.label","common");
	org_type=encodeURIComponent(org_type);
	var column_descriptions = code+","+short_desc+","+long_desc+","+long_name+","+org_type;

	var gov_leg = getLabel("eBL.GOVT_REFERRAL.label","BL");
	gov_leg=encodeURIComponent(gov_leg);

	var pvt_leg = getLabel("eBL.PVT_REFERRAL.label","BL");
	pvt_leg=encodeURIComponent(pvt_leg);

	var message = '';
		
	if (cur_rec_blng_grp.length == 0) return;

	var sql="called_for=REFSRCLKUP&locale="+locale+"&episode_type="+episode_type;

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(ref_desc.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();					

	if(retVal == null) retVal='';	
	
	if (retVal != null || retVal != "")
	{	
		var retVal=unescape(retVal);				

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			if(sel_frm_prmy_sec == 'M')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;

						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
							ref_src_main_code1.value=arr[0];
							
							var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
							ref_src_main_desc1.value=arr[2];

							var ref_src_lng_name = arr[3];

							var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

							if(blng_grp_visible.value == "Y")
							{
								if(ref_src_lng_name != "")
								{
									var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));

									pmy_ref_src_lng_name.style.visibility="visible";
									pmy_ref_src_lng_name.alt=arr[3];
								}
								else
								{
									var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));
									pmy_ref_src_lng_name.style.visibility="hidden";
								}
							}
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=arr[0];
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=arr[2];

						if(ref_src_lng_name != "")
						{
							parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="visible";
							parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt=arr[3];
						}
						else
						{
							parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
							parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
						}
					}
				}
			}

			if(sel_frm_prmy_sec == 'S')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;

						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
							ref_src_sub_code1.value=arr[0];

							var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
							ref_src_sub_desc1.value=arr[2];

							var ref_src_lng_name = arr[3];

							var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

							if(blng_grp_visible.value == "Y")
							{
								if(ref_src_lng_name != "")
								{
									var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));

									sec_ref_src_lng_name.style.visibility="visible";
									sec_ref_src_lng_name.alt=arr[3];
								}
								else
								{
									var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));
									sec_ref_src_lng_name.style.visibility="hidden";
								}
							}
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value=arr[0];
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value=arr[2];

						if(ref_src_lng_name != "")
						{
							parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="visible";
							parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt=arr[3];
						}
						else
						{
							parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="hidden";
							parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
						}
					}
				}
			}
		}	
		else
		{
			if(sel_frm_prmy_sec == 'M')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;
						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
							ref_src_main_code1.value="";
							
							var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
							ref_src_main_desc1.value="";
							
							var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

							if(blng_grp_visible.value == "Y")
							{
								var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));
								pmy_ref_src_lng_name.style.visibility="hidden";
							}
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value="";
						parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value="";

						parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
						parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
					}
				}
			}

			if(sel_frm_prmy_sec == 'S')
			{
				if(total_records >0)
				{
					for(var i=0;i<total_records;i++)
					{
						var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
						var blng_grp_code=blng_grp_code1.value;

						if(cur_rec_blng_grp.value == blng_grp_code)
						{
							var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
							ref_src_sub_code1.value="";

							var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
							ref_src_sub_desc1.value="";
							
							var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

							if(blng_grp_visible.value == "Y")
							{
								var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));
								sec_ref_src_lng_name.style.visibility="hidden";
							}
						}
					}
					if(main_blng_grp == cur_rec_blng_grp.value)
					{
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value="";
						parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value="";

						parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="hidden";
						parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
					}
				}
			}
		}
	}
	else
	{
		if(sel_frm_prmy_sec == 'M')
		{
			if(total_records >0)
			{
				for(var i=0;i<total_records;i++)
				{
					var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
					var blng_grp_code=blng_grp_code1.value;
					if(cur_rec_blng_grp.value == blng_grp_code)
					{
						var ref_src_main_code1=eval("document.forms[0].referral_source_main_code"+i);
						ref_src_main_code1.value="";
						
						var ref_src_main_desc1=eval("document.forms[0].referral_source_main_desc"+i);
						ref_src_main_desc1.value="";

						var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

						if(blng_grp_visible.value == "Y")
						{
							var pmy_ref_src_lng_name = eval(document.getElementById("pmy_ref_src_lng_name_"+i));
							pmy_ref_src_lng_name.style.visibility="hidden";
						}
					}
				}
				if(main_blng_grp == cur_rec_blng_grp.value)
				{
					parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value="";
					parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value="";

					parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").style.visibility="hidden";
					parent.parent.parent.frames[0].document.getElementById("pmy_ref_src_lng_name").alt="";
				}
			}
		}

		if(sel_frm_prmy_sec == 'S')
		{
			if(total_records >0)
			{
				for(var i=0;i<total_records;i++)
				{
					var blng_grp_code1=eval("document.forms[0].blng_grp_code"+i);
					var blng_grp_code=blng_grp_code1.value;

					if(cur_rec_blng_grp.value == blng_grp_code)
					{
						var ref_src_sub_code1=eval("document.forms[0].referral_source_sub_code"+i);
						ref_src_sub_code1.value="";

						var ref_src_sub_desc1=eval("document.forms[0].referral_source_sub_desc"+i);
						ref_src_sub_desc1.value="";

						var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);

						if(blng_grp_visible.value == "Y")
						{
							var sec_ref_src_lng_name = eval(document.getElementById("sec_ref_src_lng_name_"+i));
							sec_ref_src_lng_name.style.visibility="hidden";
						}
					}
				}
				if(main_blng_grp == cur_rec_blng_grp.value)
				{
					parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value="";
					parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value="";

					parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").style.visibility="hidden";
					parent.parent.parent.frames[0].document.getElementById("sec_ref_src_lng_name").alt="";
				}
			}
		}
	}
}

function dflt_pol_validity_date()
{
	var locale=document.forms[0].locale.value;
	var module_id = document.forms[0].calling_module_id.value;
	var total_records= document.forms[0].total_records.value;

	if(module_id != 'MP')
	{
		for(var i=0;i<total_records;i++)
		{
			var policy_eff_frm_date = eval("document.forms[0].policy_eff_frm_date"+i);
			var credit_apprd_days = eval("document.forms[0].credit_apprd_days"+i);
			var apprd_days_restrict_check = eval("document.forms[0].apprd_days_restrict_check"+i);
			var pol_validity_chk_date = eval("document.forms[0].pol_validity_chk_date"+i);

			if(policy_eff_frm_date.value != "" && credit_apprd_days.value != "" && apprd_days_restrict_check.value=='R')
			{
				var pol_validity_chk_date_val = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(credit_apprd_days.value)-1,'d');

				pol_validity_chk_date.value=pol_validity_chk_date_val;
			}
		}
	}
}

function curr_code()
{
	var total_records = document.forms[0].total_records.value;

	for(var i=0;i<total_records;i++)
	{
		var currency_desc_for_bg = eval("document.forms[0].currency_desc_for_bg"+i);
		currency_desc_for_bg = currency_desc_for_bg.value;

		var blng_grp_visible = eval("document.forms[0].blng_grp_visible"+i);
		blng_grp_visible = blng_grp_visible.value;

		if(blng_grp_visible == 'Y')
		{
			if(currency_desc_for_bg != "")
			{
				var bg_curr_desc_disp = eval(document.getElementById("bg_curr_desc_disp"+i));
				bg_curr_desc_disp.style.display="inline";

				var bg_curr_desc = eval(document.getElementById("bg_curr_desc"+i));
				bg_curr_desc.innerText=currency_desc_for_bg;
			}
			else
			{
				var bg_curr_desc_disp = eval(document.getElementById("bg_curr_desc_disp"+i));
				bg_curr_desc_disp.style.display="none";

				var bg_curr_desc = eval(document.getElementById("bg_curr_desc"+i));
				bg_curr_desc.innerText="";
			}
		}
	}
}

</script>
</head>
<%
if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
{
if(!("Y").equalsIgnoreCase(payerGrpBySetup))
	{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='disableAllElements();policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();' >
<%
	}else{
		%>	
		<body onLoad='policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<%
	}
}else{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();' >
<%
}
%>
<form name='add_modify_pat_fin_det_insmain' id='add_modify_pat_fin_det_insmain' method='post' >
<div id='tbl-container'>
<table cellpadding=3 cellspacing=0  width="100%" align='left' id='ins_data' border=1>
<thead>
<tr><td class='COLUMNHEADER' colspan='9' align='left'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td></tr>
<tr>
	<td class='COLUMNHEADER' width='14%'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='14%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>
	</tr>
</thead>
<tbody>
<%
	String query_default = null;
	ResultSet rs_dflt_ld = null;
	PreparedStatement pstmt_dflt_ld = null;	
	String classval="";
	if((((billing_mode.equals("Modify")) || (operation.equals("Update"))) && fin_dtls_updated_YN.equals("N") && fin_class_dtls_updated_YN.equals("N")) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
	{
		int total_Records=mpolicy_type_code.size();
		totalRecords=0;
		String desc = "";
		String tempDesc = "";
        String payerEligibilityParam="9";
		int priority_count=0;
		if(strModuleId.equalsIgnoreCase("IP") || strModuleId.equalsIgnoreCase("DC")){ 	  
			query_default="select  TO_CHAR(POLICY_EFF_FROM, 'DD/MM/YYYY'),TO_CHAR(POLICY_EFF_TO, 'DD/MM/YYYY'),IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,TO_CHAR(SYSDATE, 'DD/MM/YYYY'),addl_days_policy_expdt from bl_ins_policy_type_hdr where (cust_code = ?  or cust_code = '**') and POLICY_TYPE_CODE=? and rownum=1   order by cust_code desc ";//V210629
		}else if(strModuleId.equalsIgnoreCase("OP") || strModuleId.equalsIgnoreCase("AE")) {	 
			query_default="SELECT TO_CHAR (policy_eff_from, 'DD/MM/YYYY'),TO_CHAR (policy_eff_to, 'DD/MM/YYYY'), op_approved_no_of_days,op_approved_amt_limit, TO_CHAR (SYSDATE, 'DD/MM/YYYY'), addl_days_policy_expdt FROM bl_ins_policy_type_hdr WHERE (cust_code = ?  or cust_code = '**') AND policy_type_code = ? and rownum=1   order by cust_code desc ";//V210629
		}else if(strModuleId.equals("MP")) {
			query_default="select  TO_CHAR(POLICY_EFF_FROM, 'DD/MM/YYYY'),TO_CHAR(POLICY_EFF_TO, 'DD/MM/YYYY'),EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,TO_CHAR(SYSDATE, 'DD/MM/YYYY'),addl_days_policy_expdt from bl_ins_policy_type_hdr where (cust_code = ?  or cust_code = '**')  and POLICY_TYPE_CODE=? and rownum=1   order by cust_code desc ";//V210629
		}
		pstmt_dflt_ld = con.prepareStatement(query_default);
		for(int i=0;i<total_Records;i++)
	    {		
			if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			pstmt_dflt_ld.setString(1,mcust_3.get(i).toString());
			pstmt_dflt_ld.setString(2,mpolicy_type_code.get(i).toString());
			rs_dflt_ld = pstmt_dflt_ld.executeQuery() ;
			if( rs_dflt_ld != null ) 
			{	
				while( rs_dflt_ld.next() )
				{  
					String tmp_pol_start_date= rs_dflt_ld.getString(1)==null?"":rs_dflt_ld.getString(1);
					String tmp_pol_exp_date= rs_dflt_ld.getString(2)==null?"":rs_dflt_ld.getString(2);
					String tmp_pol_appd_days= rs_dflt_ld.getString(3)==null?"":rs_dflt_ld.getString(3);
					String tmp_pol_appd_amt= rs_dflt_ld.getString(4)==null?"":rs_dflt_ld.getString(4);
					String tmp_pol_eff_from= rs_dflt_ld.getString(5)==null?"":rs_dflt_ld.getString(5);
					String tmp_pol_exp_days= rs_dflt_ld.getString(6)==null?"":rs_dflt_ld.getString(6);
					String tmp_pol_eff_to=(String)mpolicy_eff_to_date.get(i);
					orgPolEffToDate=tmp_pol_eff_to; //Added By Vijay for MMS-QF-SCf-567
					if(tmp_pol_exp_date.equals("") && !tmp_pol_exp_days.equals("") && !tmp_pol_start_date.equals("")){//if (policy END == null && expiry_days ! =null)		policyend  =	policy start  + expirydays;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_start_date).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_exp_days)-1);
						tmp_pol_exp_date=sdf.format(cal.getTime());
					}
					if(!tmp_pol_appd_days.equals("") && !tmp_pol_eff_from.equals("")){ //if (approval_days ! =null)		effectivtodate =	effectivfromdate  + approval_days;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_eff_from).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_appd_days)-1);
						tmp_pol_eff_to=sdf.format(cal.getTime());		
					}else if(!tmp_pol_exp_days.equals("") && !tmp_pol_eff_from.equals("")){ //	if (expiry_days ! =null)		effectivtodate =	effectivfromdate  + expirydays;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_eff_from).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_exp_days)-1);
						tmp_pol_eff_to=sdf.format(cal.getTime());	
					}
					if(tmp_pol_eff_to.equals("") && !tmp_pol_exp_date.equals(""))				
					{
						tmp_pol_eff_to=tmp_pol_exp_date;
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date date_pol_eff_to = sdf.parse(tmp_pol_eff_to);
			     		java.util.Date date_pol_eff_from = sdf.parse(tmp_pol_eff_from);
			     		
		        		long diff = date_pol_eff_to.getTime() - date_pol_eff_from.getTime();
		    			long diffDays =  ( diff / (24 * 60 * 60 * 1000) ) + 1 ; // 1 day added for inclusive purpose
		    			tmp_pol_appd_days=""+diffDays;	
					}					
					else					
					if(!tmp_pol_eff_to.equals("") && !tmp_pol_exp_date.equals("")){
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    		java.util.Date date_pol_eff_to = sdf.parse(tmp_pol_eff_to);
		     		java.util.Date date_pol_eff_from = sdf.parse(tmp_pol_eff_from);
		    		java.util.Date date_pol_exp_date = sdf.parse(tmp_pol_exp_date);
		        	if(date_pol_eff_to.compareTo(date_pol_exp_date)>0){  //if(effective date   > policy end date)
		        		tmp_pol_eff_to=tmp_pol_exp_date;
		        		date_pol_eff_to = sdf.parse(tmp_pol_eff_to);        		
		        		long diff = date_pol_eff_to.getTime() - date_pol_eff_from.getTime();
		    			long diffDays =  ( diff / (24 * 60 * 60 * 1000) ) + 1 ; // 1 day added for inclusive purpose
		    			tmp_pol_appd_days=""+diffDays;
		        	}
					}
					mpolicy_start_date.set(i,tmp_pol_start_date );
					mpolicy_expiry_date.set(i,tmp_pol_exp_date );
					mcredit_apprd_days.set(i,tmp_pol_appd_days );
					mcredit_apprd_amt.set(i,tmp_pol_appd_amt );
					mpolicy_eff_frm_date.set(i,tmp_pol_eff_from );
					mpolicy_eff_to_date.set(i,tmp_pol_eff_to );
				}
			}
			}		
		String billingGroupId = (String)mins_blng_grp.get(i);
		bean.setDBApprvlsToBean(facility_id,episode_type,patient_id,(String)mins_blng_grp.get(i),(String)mcust_group_3.get(i),(String)mcust_3.get(i),(String)mins_cust_priority.get(i),(String)mpolicy_type_code.get(i),(String)mpolicy_no.get(i),(String)mpolicy_eff_frm_date.get(i),(String)mcredit_auth_ref.get(i),(String)mcredit_auth_date.get(i),(String)mcredit_apprd_amt.get(i),(String)mcredit_apprd_days.get(i));//added for package billing
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_CODE = '"+mcust_3.get(i)+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
			String empty_sql_check="N";
			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if(rs != null) rs.close();
			stmt.close();
			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE 	a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		priority_count++;
		String blng_grp_code=(String)mins_blng_grp.get(i);
		String blng_grp_long_desc="";
		objFromBean=addModifyBean.getblngGrpDesc(blng_grp_code,locale,con);
		blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		desc=(String)mins_blng_grp.get(i);
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		String blngGrpCode=(String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getRefSourceFlagsForP1(blngGrpCode,con);
		referral_source_capture_YN=objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN=objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN=objFromBean.get("referral_source_sub_mand_YN").getAsString();
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!mref_ins_src_main_code.get(i).equals(""))
		{
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,"3",con);
 	}
		else
		{
			ref_src_main_lng_name="";
		}
		if(!mref_ins_src_sub_code.get(i).equals(""))
		{
			String refInsSrcSubCode=(String)mref_ins_src_sub_code.get(i);
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcSubCode, locale, "3", con); 
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		try
		{
			String empty_sql_check="N";
		
			String custCode=(String)mcust_3.get(i);
			String custGrpCode=(String)mcust_group_3.get(i);
			
			objFromBean=addModifyBean.validPayerYN(strModuleId,custCode,custGrpCode,con);
			payer_suspended_YN=objFromBean.get("payer_suspended_YN").getAsString();
			cust_valid_from_date=objFromBean.get("cust_valid_from_date").getAsString();
			cust_valid_to_date=objFromBean.get("cust_valid_to_date").getAsString();
			empty_sql_check=objFromBean.get("empty_sql_check").getAsString();
			valid_payer_YN=objFromBean.get("valid_payer_YN").getAsString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			String empty_sql_check="N";
			String custCode=(String)mcust_3.get(i);
			String custGrpCode=(String)mcust_group_3.get(i);
			String policyTypeCode=(String)mpolicy_type_code.get(i);

			objFromBean=addModifyBean.getvalidPolicyTypeCodeYN(empty_sql_check,strModuleId, custCode, custGrpCode,policyTypeCode,locale,facility_id, con);			
			empty_sql_check=	objFromBean.get("empty_sql_check").getAsString();
			valid_policy_type_code_YN= objFromBean.get("valid_policy_type_code_YN").getAsString();
			policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{	
%>	
<tr>
<td class='PATIENTLINECOLOR'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;<div id="bg_curr_desc_disp<%=totalRecords%>" style="display:inline"><Font color='red'><b id="bg_curr_desc<%=totalRecords%>"></b></font></div></td>
<td class='PATIENTLINECOLOR' colspan=2><input type='text' readonly name="billing_group_desc<%=totalRecords%>" id="billing_group_desc<%=totalRecords%>" maxlength='30' size='25' tabindex='0' value="<%=blng_grp_long_desc%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="Y">
<td  class='PATIENTLINECOLOR'>
			<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
			</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc<%=totalRecords%>" id="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=mref_ins_src_main_desc.get(i)%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" id="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_main_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_main_lng_name%>">
<%
			}
%>			
		</div>
</td>
<td class='PATIENTLINECOLOR'>
		<div id='ref_src_code_sub_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_sub_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc<%=totalRecords%>" id="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=mref_ins_src_sub_desc.get(i)%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'B')" >
			<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" id="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_sub_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_sub_lng_name%>">
<% 
			}
%>	
		</div>
</td>
</tr>
<%
		}
		else
		{
%>
<input type='hidden' name='billing_group_desc<%=totalRecords%>' id='billing_group_desc<%=totalRecords%>' value="<%=blng_grp_long_desc%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="N">
<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' id='referral_source_main_desc<%=totalRecords%>' value="<%=mref_ins_src_main_desc.get(i)%>">
<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' id='referral_source_sub_desc<%=totalRecords%>' value="<%=mref_ins_src_sub_desc.get(i)%>">
<%
		}
%>
<tr id=row<%=totalRecords%>>
<input type= "hidden" name="payerEligibilityParam<%=totalRecords%>" id="payerEligibilityParam<%=totalRecords%>"  value="<%=mins_payerEligibilityParamSession.get(i)%>">
<input type= "hidden" name="responseCode<%=totalRecords%>" id="responseCode<%=totalRecords%>"  value="<%=mins_responseCode.get(i)%>">
<input type= "hidden" name="responseCodeDesc<%=totalRecords%>" id="responseCodeDesc<%=totalRecords%>"  value="<%=mins_responseCodeDesc.get(i)%>">
<input type= "hidden" name="statuDescription<%=totalRecords%>" id="statuDescription<%=totalRecords%>"  value="<%=mins_statuDescription.get(i)%>">
<input type= "hidden" name="validityPeriod<%=totalRecords%>" id="validityPeriod<%=totalRecords%>"  value="<%=mins_validityPeriod.get(i)%>">
<input type= "hidden" name="validityPeriodDesc<%=totalRecords%>" id="validityPeriodDesc<%=totalRecords%>"  value="<%=mins_validityPeriodDesc.get(i)%>">
<input type= "hidden" name="eligibilityCode<%=totalRecords%>" id="eligibilityCode<%=totalRecords%>"  value="<%=mins_eligibilityCode.get(i)%>">
<input type= "hidden" name="transactionId<%=totalRecords%>" id="transactionId<%=totalRecords%>"  value="<%=mins_transactionId.get(i)%>">
<input type= "hidden" name="responseDateTime<%=totalRecords%>" id="responseDateTime<%=totalRecords%>"  value="<%=mins_responseDateTime.get(i)%>">
<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>" id="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>" id="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='blng_grp_code<%=totalRecords%>' id='blng_grp_code<%=totalRecords%>' value="<%=mins_blng_grp.get(i)%>">
<input type='hidden' name='referral_source_main_code<%=totalRecords%>' id='referral_source_main_code<%=totalRecords%>' value="<%=mref_ins_src_main_code.get(i)%>">
<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' id='referral_source_sub_code<%=totalRecords%>' value="<%=mref_ins_src_sub_code.get(i)%>">
<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' id='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' id='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' id='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
<%	
		blng_grp_values=blng_grp_values+mins_blng_grp.get(i)+"|";
		if(valid_payer_YN.equals("Y") && valid_policy_type_code_YN.equals("Y"))
		{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="<%=mcust_group_desc.get(i)%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="<%=mpayer_desc.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="<%=mcust_3.get(i)%>">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="<%=mcust_group_3.get(i)%>">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="<%=valid_payer_YN%>">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value="<%=mins_cust_priority.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if((mrestrict_check.get(i)).equals("U"))
	{	
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if ((mrestrict_check.get(i)).equals("R"))
	{
		if((mapprd_amt_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if((mapprd_days_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="<%=mpolicy_type_desc.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
	</td>
<input type=hidden name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="<%=mpolicy_type_code.get(i)%>">
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="<%=valid_policy_type_code_YN%>">
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="<%=mpolicy_no.get(i)%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	policy_start_date_conv=(String)mpolicy_start_date.get(i);	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(encounter_date_time==null) encounter_date_time="";
	try
	{
		String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date(?, 'dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID= ? AND  cust_group_code = ? AND policy_type_code = ? AND (cust_code = ? OR (cust_code <> ? AND cust_code = '**')) AND def_req_policy_dates = 'Y'";
		
		def_req_pol_date_avail_YN = "N";
		
		pstmt = con.prepareStatement(pocy_date_valid) ;
		
		pstmt.setString(1,encounter_date_time);
		pstmt.setString(2,encounter_date_time);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,(String)mcust_group_3.get(i));
		pstmt.setString(5,(String)mpolicy_type_code.get(i));
		pstmt.setString(6,(String)mcust_3.get(i));
		pstmt.setString(7,(String)mcust_3.get(i));
		
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while(rs.next())
			{
				//addl_days_policy_expdt=rs.getString(1);
				policy_start_date_conv=rs.getString(3);
				if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=rs.getString(2);
				if(policy_exp_date_conv==null) policy_exp_date_conv="";
				def_req_pol_date_avail_YN = "Y";
			}
		}
		else
		{
			def_req_pol_date_avail_YN="N";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(def_req_pol_date_avail_YN.equals("Y"))
	{
		policy_eff_frm_date_conv=policy_start_date_conv;
		policy_eff_to_date_conv=policy_exp_date_conv;
	}
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}
%>
<%
if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			policy_start_date_conv=(String)mpolicy_start_date.get(i);	
			policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);			
			policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);				
			policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
}
%>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_start_date_conv%>"  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_exp_date_conv%>"  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	if((mcred_auth_req_yn.get(i)).equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="<%=mcredit_auth_ref.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<%
	credit_auth_date_conv=(String)mcredit_auth_date.get(i);	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value="<%=credit_auth_date_conv%>"  onFocus='check(<%=totalRecords%>);' readonly></div></td>
</tr>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="<%=mcredit_apprd_amt.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="<%=mcredit_apprd_days.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_eff_frm_date_conv%>"  onFocus='check(<%=totalRecords%>);' readonly>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<% if(siteSpec){  %>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value="<%=orgPolEffToDate%>"  onFocus='check(<%=totalRecords%>);' ></td>
<%}else{ 											%>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_eff_to_date_conv%>"  onFocus='check(<%=totalRecords%>);' ></td>
<%} %>
</tr>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="<%=madj_rule_ind.get(i)%>">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="<%=madj_perc_amt_ind.get(i)%>">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="<%=madj_perc_amt_value.get(i)%>">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="<%=mpmnt_diff_adj_int.get(i)%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=mdrg_pmnt_diff_adj_int.get(i)%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=mspl_srv_pmnt_diff_adj_int.get(i)%>">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='<%=mrestrict_check.get(i)%>'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='<%=mapprd_amt_restrict_check.get(i)%>'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='<%=mapprd_days_restrict_check.get(i)%>'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value='<%=policy_coverage_basis_ind%>'>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="<%=mcred_auth_req_yn.get(i)%>">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=mcred_auth_mand_capt_yn.get(i)%>">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=mdflt_auth_ref_as_pol_no_yn.get(i)%>">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>'  value="<%=rec_edited_YN%>">
<input type=hidden name="totRec" id="totRec" id="totRec" value="<%=total_Records%>">
<input type=hidden name='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' value="<%=orgPolEffToDate%>">  <!-- Added By Vijay for MMS-QF-SCf-567 -->
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="">   <!-- V230315 -->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<%	
	totalRecords++;
	}
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="N">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	v_display_hide_apprvd_amt="display:inline";
	v_display_hide_apprvd_days = "display:inline";
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
	<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type='hidden' name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="">
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="N">
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	v_display_hide_cred_auth = "display:inline";
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></div></td>
</tr>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text' id='policy_eff_to_date<%=totalRecords%>' name='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
</tr>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value=''>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="N">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="N">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="N">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="N">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="">  <!--  V230315 -->
<input type=hidden name="totRec" id="totRec" value="<%=total_Records %>">
<input type=hidden name='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' value="<%=orgPolEffToDate%>">  <!-- Added By Vijay for MMS-QF-SCf-567 -->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<%
	totalRecords++;
	}
	}
	tempDesc=desc;
	}	
if(rs_dflt_ld !=null) rs_dflt_ld.close();
if(pstmt_dflt_ld !=null) pstmt_dflt_ld.close();		
}
else if((((billing_mode.equals("Modify")) || (operation.equals("Update"))) && (fin_dtls_updated_YN.equals("Y") || fin_class_dtls_updated_YN.equals("Y"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
{
	int total_Records=mpolicy_type_code.size();
	totalRecords=0;
	String desc = "";
	String tempDesc = "";
	String payerEligibilityParam = "9";	
	for(int i=0;i<total_Records;i++)
	{
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_CODE = '"+mcust_3.get(i)+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
			String empty_sql_check="N";
			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if(rs != null) rs.close();
			stmt.close();
			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String billingGroupId = (String)mins_blng_grp.get(i);
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		String blng_grp_long_desc="";
		desc=(String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getblngGrpDesc(desc, locale, con);
		blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		String blngGrpId= (String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getRefSourceFlagsForP1(blngGrpId, con);
		//Changed by prithivi for bupa interface
		//referral_source_capture_YN=objFromBean.get("referral_source_capture_YN").getAsString();
		referral_source_capture_YN=objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN=objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN=objFromBean.get("referral_source_sub_mand_YN").getAsString();	
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!mref_ins_src_main_code.get(i).equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);			
		}
		else
		{
			ref_src_main_lng_name="";
		}
		if(!mref_ins_src_sub_code.get(i).equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		objFromBean = addModifyBean.validPayerYN(strModuleId, (String) mcust_3.get(i), (String) mcust_group_3.get(i), con);
		valid_payer_YN=objFromBean.get("valid_payer_YN").getAsString();
		cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
		cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
		payer_suspended_YN = objFromBean.get("payer_suspended_YN").getAsString();
		objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, (String) mcust_3.get(i), (String) mcust_group_3.get(i), (String) mpolicy_type_code.get(i), locale, facility_id, con);
		valid_policy_type_code_YN= objFromBean.get("valid_policy_type_code_YN").getAsString();
		policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{
%>
<tr>
<td class='PATIENTLINECOLOR'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;<div id="bg_curr_desc_disp<%=totalRecords%>" style="display:inline"><Font color='red'><b id="bg_curr_desc<%=totalRecords%>"></b></font></div></td>
<td class='PATIENTLINECOLOR' colspan=2 ><input type='text' readonly name="billing_group_desc<%=totalRecords%>" id="billing_group_desc<%=totalRecords%>" maxlength='30' size='25' tabindex='0' value="<%=blng_grp_long_desc%>"></td>
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="Y">
<td  class='PATIENTLINECOLOR'>
			<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
			</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc<%=totalRecords%>" id="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=mref_ins_src_main_desc.get(i)%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" id="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_main_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_main_lng_name%>">
<%
			}
%>			
		</div>
</td>
<td class='PATIENTLINECOLOR'>
		<div id='ref_src_code_sub_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_sub_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc<%=totalRecords%>" id="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=mref_ins_src_sub_desc.get(i)%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" id="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_sub_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_sub_lng_name%>">
<%
			}
%>	
		</div>
</td>
</tr>
<%
		}else{		
%>
<input type='hidden' name='billing_group_desc<%=totalRecords%>' id='billing_group_desc<%=totalRecords%>' value="<%=blng_grp_long_desc%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="N">
<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' id='referral_source_main_desc<%=totalRecords%>' value="<%=mref_ins_src_main_desc.get(i)%>">
<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' id='referral_source_sub_desc<%=totalRecords%>' value="<%=mref_ins_src_sub_desc.get(i)%>">
<%
		}
%>
<tr id=row<%=totalRecords%>>
<input type= "hidden" name="payerEligibilityParam<%=totalRecords%>" id="payerEligibilityParam<%=totalRecords%>"  value="<%=mins_payerEligibilityParamSession.get(i)%>">
<input type= "hidden" name="responseCode<%=totalRecords%>" id="responseCode<%=totalRecords%>"  value="<%=mins_responseCode.get(i)%>">
<input type= "hidden" name="responseCodeDesc<%=totalRecords%>" id="responseCodeDesc<%=totalRecords%>"  value="<%=mins_responseCodeDesc.get(i)%>">
<input type= "hidden" name="statuDescription<%=totalRecords%>" id="statuDescription<%=totalRecords%>"  value="<%=mins_statuDescription.get(i)%>">
<input type= "hidden" name="validityPeriod<%=totalRecords%>" id="validityPeriod<%=totalRecords%>"  value="<%=mins_validityPeriod.get(i)%>">
<input type= "hidden" name="validityPeriodDesc<%=totalRecords%>" id="validityPeriodDesc<%=totalRecords%>"  value="<%=mins_validityPeriodDesc.get(i)%>">
<input type= "hidden" name="eligibilityCode<%=totalRecords%>" id="eligibilityCode<%=totalRecords%>"  value="<%=mins_eligibilityCode.get(i)%>">
<input type= "hidden" name="transactionId<%=totalRecords%>" id="transactionId<%=totalRecords%>"  value="<%=mins_transactionId.get(i)%>">
<input type= "hidden" name="responseDateTime<%=totalRecords%>" id="responseDateTime<%=totalRecords%>"  value="<%=mins_responseDateTime.get(i)%>">
<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>" id="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>" id="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='blng_grp_code<%=totalRecords%>' id='blng_grp_code<%=totalRecords%>' value="<%=mins_blng_grp.get(i)%>">
<input type='hidden' name='referral_source_main_code<%=totalRecords%>' id='referral_source_main_code<%=totalRecords%>' value="<%=mref_ins_src_main_code.get(i)%>">
<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' id='referral_source_sub_code<%=totalRecords%>' value="<%=mref_ins_src_sub_code.get(i)%>">
<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' id='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' id='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' id='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
<%
		blng_grp_values=blng_grp_values+mins_blng_grp.get(i)+"|";
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="<%=mcust_group_desc.get(i)%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="<%=mpayer_desc.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="<%=mcust_3.get(i)%>">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="<%=mcust_group_3.get(i)%>">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value='<%=valid_payer_YN%>'>
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value="<%=mins_cust_priority.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="<%=mpolicy_type_desc.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type=hidden name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="<%=mpolicy_type_code.get(i)%>">
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="<%=valid_policy_type_code_YN%>">
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value='<%=mpolicy_no.get(i)%>' onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	policy_start_date_conv=(String)mpolicy_start_date.get(i);	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	try
	{
		String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date(?, 'dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID= ? AND  cust_group_code = ?  AND policy_type_code = ? AND (cust_code = ? OR (cust_code <> ? AND cust_code = '**')) AND def_req_policy_dates = 'Y'";
		
		def_req_pol_date_avail_YN = "N";
		pstmt = con.prepareStatement(pocy_date_valid) ;
		
		pstmt.setString(1,encounter_date_time);
		pstmt.setString(2,encounter_date_time);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,(String)mcust_group_3.get(i));
		pstmt.setString(5,(String)mpolicy_type_code.get(i));
		pstmt.setString(6,(String)mcust_3.get(i));
		pstmt.setString(7,(String)mcust_3.get(i));
		
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while(rs.next())
			{
				//addl_days_policy_expdt=rs.getString(1);
				policy_start_date_conv=rs.getString(3);
				policy_exp_date_conv=rs.getString(2);
				def_req_pol_date_avail_YN = "Y";
			}
		}
		else
		{
			def_req_pol_date_avail_YN="N";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(def_req_pol_date_avail_YN.equals("Y")) 
	{
		policy_eff_frm_date_conv=policy_start_date_conv;
		policy_eff_to_date_conv=policy_exp_date_conv;
	}
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_frm_date_conv.equals(""))
	{
	policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}
%>
<% 
if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			policy_start_date_conv=(String)mpolicy_start_date.get(i);	
			policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);			
			policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);				
			policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
}
%>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_start_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_exp_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	if((mcred_auth_req_yn.get(i)).equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="<%=mcredit_auth_ref.get(i)%>" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<%
	credit_auth_date_conv=(String)mcredit_auth_date.get(i);	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value='<%=credit_auth_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></div></td>
</tr>
<%
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if((mrestrict_check.get(i)).equals("U"))
	{	
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if ((mrestrict_check.get(i)).equals("R"))
	{
		if((mapprd_amt_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if((mapprd_days_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
%>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value='<%=mcredit_apprd_amt.get(i)%>' onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value='<%=mcredit_apprd_days.get(i)%>' onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_frm_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_to_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></td>
</tr>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="<%=madj_rule_ind.get(i)%>">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="<%=madj_perc_amt_ind.get(i)%>">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="<%=madj_perc_amt_value.get(i)%>">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="<%=mpmnt_diff_adj_int.get(i)%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=mdrg_pmnt_diff_adj_int.get(i)%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=mspl_srv_pmnt_diff_adj_int.get(i)%>">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='<%=mrestrict_check.get(i)%>'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='<%=mapprd_amt_restrict_check.get(i)%>'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='<%=mapprd_days_restrict_check.get(i)%>'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value='<%=policy_coverage_basis_ind%>'>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="<%=mcred_auth_req_yn.get(i)%>">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=mcred_auth_mand_capt_yn.get(i)%>">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=mdflt_auth_ref_as_pol_no_yn.get(i)%>">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="<%=rec_edited_YN%>">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="<%=m_mcn_for_policy.get(i)%>">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="<%=m_reg_ref_id.get(i)%>">  <!--  V230315 -->
<input type=hidden name='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' value="<%=mpolicy_eff_to_date.get(i)%>">  <!--  V232704 -->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="<%=muserId_for_priv.get(i)%>" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="<%=mreasonCode_for_priv.get(i)%>" />  <!-- V230707 -->
<% 
			tempDesc=desc;
			totalRecords++;
	}
}
else if(remove_check.equals("remove"))
{
	totalRecords=0;
	String desc = "";
	String tempDesc = "";
	String[] output1=new String[55]; //V230707
	for(int i=0;i<existing_records_array.size();i++)
	{
		output1=(String[])existing_records_array.get(i);
		policy_coverage_basis_ind=output1[26];	
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		desc = output1[1];
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		objFromBean = addModifyBean.getCustValidDates(output1[3], con);
		cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
		cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
		objFromBean = addModifyBean.getCurrencyCode(output1[1], locale, con);
		str_currency_code_for_bg= objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg= objFromBean.get("str_currency_desc_for_bg").getAsString();
		objFromBean = addModifyBean.getRefSourceFlagsForP1(output1[1], con);
		referral_source_capture_YN = objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!output1[27].equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)output1[27];
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);		
		}
		else
		{
			ref_src_main_lng_name="";
		}

		if(!output1[29].equals(""))
		{
			String refInsSrcMainCode=(String)output1[29];
			String val = "3";
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		payer_suspended_YN = addModifyBean.payerSuspendedYn(strModuleId, output1[3], output1[25], con);
			String empty_sql_check="N";
			String custCde=(String)output1[3];
			String custGrpCde =(String)output1[25]; 
			String policyTypeCde=(String)output1[6];
			objFromBean=addModifyBean.getpolicySuspendedYN(empty_sql_check,strModuleId, custCde, custGrpCde,policyTypeCde,locale,facility_id, con);			
			empty_sql_check=	objFromBean.get("empty_sql_check").getAsString();
			policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();		
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc))){
%>
<tr>
<td class='PATIENTLINECOLOR' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;<div id="bg_curr_desc_disp<%=totalRecords%>" style="display:inline"><Font color='red'><b id="bg_curr_desc<%=totalRecords%>"></b></font></div></td>
<td class='PATIENTLINECOLOR' colspan=2><input type='text' readonly name="billing_group_desc<%=totalRecords%>" id="billing_group_desc<%=totalRecords%>" maxlength='30' size='25' tabindex='0' value="<%=output1[0]%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="Y">
<td  class='PATIENTLINECOLOR' >
			<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
			</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc<%=totalRecords%>" id="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[28]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" id="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_main_lng_name.equals("")){
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}else{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_main_lng_name%>">
<%
			}
%>			
		</div>
</td>
<td class='PATIENTLINECOLOR'>
		<div id='ref_src_code_sub_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_sub_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc<%=totalRecords%>" id="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[30]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" id="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_sub_lng_name.equals("")){
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}else{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_sub_lng_name%>">
<%
			}
%>	
		</div>
</td>
</tr>
<%
		}else{
%>
<input type='hidden' name='billing_group_desc<%=totalRecords%>' id='billing_group_desc<%=totalRecords%>' value="<%=output1[0]%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="N">
<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' id='referral_source_main_desc<%=totalRecords%>' value="<%=output1[28]%>">
<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' id='referral_source_sub_desc<%=totalRecords%>' value="<%=output1[30]%>">
<%
		}
%>
<tr id=row<%=totalRecords%>>
<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>" id="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>" id="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='blng_grp_code<%=totalRecords%>' id='blng_grp_code<%=totalRecords%>' value="<%=output1[1]%>">
<input type='hidden' name='referral_source_main_code<%=totalRecords%>' id='referral_source_main_code<%=totalRecords%>' value="<%=output1[27]%>">
<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' id='referral_source_sub_code<%=totalRecords%>' value="<%=output1[29]%>">
<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' id='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' id='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' id='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
<input type='hidden' name='payerEligibilityParam<%=totalRecords%>' id='payerEligibilityParam<%=totalRecords%>' value="<%=output1[41]%>">
<input type='hidden' name='responseCode<%=totalRecords%>' id='responseCode<%=totalRecords%>' value="<%=output1[42]%>">
<input type='hidden' name='responseCodeDesc<%=totalRecords%>' id='responseCodeDesc<%=totalRecords%>' value="<%=output1[43]%>">
<input type='hidden' name='statuDescription<%=totalRecords%>' id='statuDescription<%=totalRecords%>' value="<%=output1[44]%>">
<input type='hidden' name='validityPeriod<%=totalRecords%>' id='validityPeriod<%=totalRecords%>' value="<%=output1[45]%>">
<input type='hidden' name='validityPeriodDesc<%=totalRecords%>' id='validityPeriodDesc<%=totalRecords%>' value="<%=output1[46]%>">
<input type='hidden' name='eligibilityCode<%=totalRecords%>' id='eligibilityCode<%=totalRecords%>' value="<%=output1[47]%>">
<input type='hidden' name='transactionId<%=totalRecords%>' id='transactionId<%=totalRecords%>' value="<%=output1[48]%>">
<input type='hidden' name='responseDateTime<%=totalRecords%>' id='responseDateTime<%=totalRecords%>' value="<%=output1[49]%>">
<%
	blng_grp_values=blng_grp_values+output1[1]+"|";
	if(output1[23].equals("Y") && output1[24].equals("Y"))
	{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="<%=output1[37]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="<%=output1[2]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="<%=output1[3]%>">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="<%=output1[25]%>">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value='<%=output1[23]%>'>
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value="<%=output1[4]%>" onFocus='check(<%=totalRecords%>);'  readonly></td> 
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="<%=output1[5]%>" onFocus='check(<%=totalRecords%>);'  readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type='hidden' name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="<%=output1[6]%>" >
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value='<%=output1[24]%>'>
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="<%=output1[7]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	policy_start_date_conv=(String)output1[8];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_start_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	policy_exp_date_conv=(String)output1[9];	 
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_exp_date_conv%>'  onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	if(output1[33].equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="<%=output1[10]%>" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<%
	credit_auth_date_conv=(String)output1[11];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value='<%=credit_auth_date_conv%>' readonly></div></td>
</tr>
<%
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if(output1[22].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[22].equals("R"))
	{
		if(output1[31].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[32].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
%>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%>><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value='<%=output1[12]%>' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value='<%=output1[13]%>' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<%
	policy_eff_frm_date_conv=(String)output1[14];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
%>	
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_frm_date_conv%>' readonly></td>
<%
	policy_eff_to_date_conv=(String)output1[15];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_to_date_conv%>' readonly></td>
</tr>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="<%=output1[16]%>">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="<%=output1[17]%>">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="<%=output1[18]%>">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[19]%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[20]%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[21]%>">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='<%=output1[22]%>'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='<%=output1[31]%>'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='<%=output1[32]%>'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value='<%=policy_coverage_basis_ind%>'>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="<%=output1[33]%>">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=output1[40]%>">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=output1[34]%>">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="<%=output1[39]%>">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="<%=output1[51]%>">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="<%=output1[52]%>">   <!-- V230315 -->
<input type="hidden" name="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" value="<%=output1[50]%>">  <!--  Added By Vijay for MMS-QF-SCf-567-->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="<%=output1[53]%>" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="<%=output1[54]%>" />  <!-- V230707 -->
<%
		totalRecords++; %>
	<input type="hidden" name="totRec" id="totRec" id="totRec"  value="<%=existing_records_array.size()%>"> <!-- Added By Vijay For MMS-QF-SCf-567  -->
<% }
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="N">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);' readonly></td>
<%
		v_display_hide_apprvd_amt="display:inline";
		v_display_hide_apprvd_days = "display:inline";
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type=hidden name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="">
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="N">
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
		v_display_hide_cred_auth = "display:inline";
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></div></td>
</tr>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
</tr>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value=''>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="N">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="N">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="N">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="N">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="<%=output1[51]%>">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="<%=output1[52]%>">   <!-- V230315 -->
<input type=hidden name="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" value="<%=output1[50]%>">  <!--  Added By Vijay for MMS-QF-SCf-567-->
<input type=hidden name="totRec" id="totRec" id="totRec"  value="<%=existing_records_array.size()%>"><!-- Added By Vijay For MMS-QF-SCf-567  -->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="<%=output1[53]%>" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="<%=output1[54]%>" />  <!-- V230707 -->
<%
			totalRecords++;
		}
	}
	tempDesc=desc;
	}
}
else if(accept_check.equals("accept") || add_check.equals("add") || refresh_check.equals("Y"))
{
		totalRecords=0;
		String desc = "";
		String tempDesc = "";
		String[] output1=new String[55]; //V230707
		for(int i=0;i<existing_records_array.size();i++)
		{
			output1=(String[])existing_records_array.get(i);
			String OrgPolEffToDate = "";
			 try {
				OrgPolEffToDate=(String)output1[50];
			} catch(ArrayIndexOutOfBoundsException ex) {
				OrgPolEffToDate = "";
				ex.printStackTrace();
			}
			policy_coverage_basis_ind=output1[26];	
			if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			desc = output1[1];
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			objFromBean = addModifyBean.getRefSourceFlagsForP1(output1[1], con);
			referral_source_capture_YN = objFromBean.get("referral_source_code_flag").getAsString();
			ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			objFromBean = addModifyBean.getCustValidDates(output1[3], con);
			cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
			cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
			objFromBean = addModifyBean.getCurrencyCode(output1[1], locale, con);
			str_currency_code_for_bg = objFromBean.get("str_currency_code_for_bg").getAsString();
			str_currency_desc_for_bg = objFromBean.get("str_currency_desc_for_bg").getAsString();
			if(referral_source_capture_YN.equals("Y"))
			{
				ref_src_code_disp="display:inline";
				if(ref_src_main_mand_YN.equals("Y"))
				{
					ref_src_code_main_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_main_mand_disp = "display:none";
				}
				if(ref_src_sub_mand_YN.equals("Y"))
				{
					ref_src_code_sub_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_sub_mand_disp = "display:none";
				}
			}
			else if(referral_source_capture_YN.equals("N"))
			{
				ref_src_code_disp="display:none";
				ref_src_code_main_mand_disp = "display:none";
				ref_src_code_sub_mand_disp = "display:none";
			}
			else
			{
				ref_src_code_disp="display:none";
			}
			if(!output1[27].equals(""))
			{
				String val="3";
				String refInsSrcMainCode=(String)output1[27];
				ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
			}
			else
			{
				ref_src_main_lng_name="";
			}

			if(!output1[29].equals(""))
			{
				String val="3";
				String refInsSrcMainCode=(String)output1[29];
				ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);				
			}
			else
			{
				ref_src_sub_lng_name="";
			}
			String empty_sql_check = "N";
	 		String customerCode=(String)output1[3];
	 		String customerGroupCode=(String)output1[25];		
			objFromBean=addModifyBean.payerSuspendedYN(strModuleId, customerCode, customerGroupCode, con);
			empty_sql_check=objFromBean.get("empty_sql_check").getAsString();
			payer_suspended_YN=objFromBean.get("payer_suspended_YN").getAsString();
		objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, output1[3], output1[25], output1[6], locale, facility_id, con);
		policy_suspended_YN = objFromBean.get("policy_suspended_YN").getAsString();		
	if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
	{
%>
<tr>
	<td class='PATIENTLINECOLOR'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;<div id="bg_curr_desc_disp<%=totalRecords%>" style="display:inline"><Font color='red'><b id="bg_curr_desc<%=totalRecords%>"></b></font></div></td>
	<td class='PATIENTLINECOLOR' colspan=2><input type='text' readonly name="billing_group_desc<%=totalRecords%>" id="billing_group_desc<%=totalRecords%>" maxlength='30' size='25' tabindex='0' value="<%=output1[0]%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="Y">
	<td  class='PATIENTLINECOLOR'>
			<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
			</div>
	</td>
	<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc<%=totalRecords%>" id="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[28]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" id="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_main_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_main_lng_name%>">
<%
			}
%>	
		</div>
	</td>
	<td class='PATIENTLINECOLOR'>
		<div id='ref_src_code_sub_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>
	<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_sub_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc<%=totalRecords%>" id="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[30]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" id="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_sub_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:inline" alt="<%=ref_src_sub_lng_name%>">
<%
			}
%>	
		</div>
	</td>
</tr>

<%
	}
	else
	{
%>
<input type='hidden' name='billing_group_desc<%=totalRecords%>' id='billing_group_desc<%=totalRecords%>' value="<%=output1[0]%>">
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="N">
<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' id='referral_source_main_desc<%=totalRecords%>' value="<%=output1[28]%>">
<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' id='referral_source_sub_desc<%=totalRecords%>' value="<%=output1[30]%>">
<%
	}
%>
<tr id=row<%=totalRecords%>>
<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>" id="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>" id="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='blng_grp_code<%=totalRecords%>' id='blng_grp_code<%=totalRecords%>' value="<%=output1[1]%>">
<input type='hidden' name='referral_source_main_code<%=totalRecords%>' id='referral_source_main_code<%=totalRecords%>' value="<%=output1[27]%>">
<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' id='referral_source_sub_code<%=totalRecords%>' value="<%=output1[29]%>">
<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' id='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' id='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' id='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
<input type='hidden' name='payerEligibilityParam<%=totalRecords%>' id='payerEligibilityParam<%=totalRecords%>' value="<%=output1[41]%>">
<input type='hidden' name='responseCode<%=totalRecords%>' id='responseCode<%=totalRecords%>' value="<%=output1[42]%>">
<input type='hidden' name='responseCodeDesc<%=totalRecords%>' id='responseCodeDesc<%=totalRecords%>' value="<%=output1[43]%>">
<input type='hidden' name='statuDescription<%=totalRecords%>' id='statuDescription<%=totalRecords%>' value="<%=output1[44]%>">
<input type='hidden' name='validityPeriod<%=totalRecords%>' id='validityPeriod<%=totalRecords%>' value="<%=output1[45]%>">
<input type='hidden' name='validityPeriodDesc<%=totalRecords%>' id='validityPeriodDesc<%=totalRecords%>' value="<%=output1[46]%>">
<input type='hidden' name='eligibilityCode<%=totalRecords%>' id='eligibilityCode<%=totalRecords%>' value="<%=output1[47]%>">
<input type='hidden' name='transactionId<%=totalRecords%>' id='transactionId<%=totalRecords%>' value="<%=output1[48]%>">
<input type='hidden' name='responseDateTime<%=totalRecords%>' id='responseDateTime<%=totalRecords%>' value="<%=output1[49]%>">
<%
	blng_grp_values=blng_grp_values+output1[1]+"|";
	if(output1[23].equals("Y") && output1[24].equals("Y"))
	{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="<%=output1[37]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="<%=output1[2]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="<%=output1[3]%>">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="<%=output1[25]%>">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="<%=output1[23]%>">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value="<%=output1[4]%>" onFocus='check(<%=totalRecords%>);'  readonly></td> 
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="<%=output1[5]%>" onFocus='check(<%=totalRecords%>);'  readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type='hidden' name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="<%=output1[6]%>" >
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="<%=output1[24]%>" >
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="<%=output1[7]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	policy_start_date_conv=(String)output1[8];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_start_date_conv%>"  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
	policy_exp_date_conv=(String)output1[9];	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_exp_date_conv%>"  onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	if(output1[33].equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="<%=output1[10]%>" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<%
	credit_auth_date_conv=(String)output1[11];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value="<%=credit_auth_date_conv%>" readonly></div></td>
</tr>
<%	
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";

	if(output1[22].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[22].equals("R"))
	{
		if(output1[31].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[32].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
%>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%>><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="<%=output1[12]%>" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="<%=output1[13]%>" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<%
	policy_eff_frm_date_conv=(String)output1[14];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
%>	
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_eff_frm_date_conv%>" readonly></td>
<%
	policy_eff_to_date_conv=(String)output1[15];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value="<%=policy_eff_to_date_conv%>" readonly></td>
</tr>
<input type=hidden name='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' value='<%=policy_eff_to_date_conv %>'>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="<%=output1[16]%>">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="<%=output1[17]%>">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="<%=output1[18]%>">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[19]%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[20]%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[21]%>">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value="<%=output1[22]%>">
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='<%=output1[31]%>'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='<%=output1[32]%>'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value="<%=policy_coverage_basis_ind%>">
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="<%=output1[33]%>">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=output1[40]%>">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=output1[34]%>">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="<%=output1[39]%>">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value="<%=output1[51]%>">  
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="<%=output1[52]%>">  <!--  V230315 -->
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="<%=output1[53]%>" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="<%=output1[54]%>" />  <!-- V230707 -->
<%
		totalRecords++;
	}
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{
%>
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="N">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);' readonly></td>
<%
		v_display_hide_apprvd_amt="display:inline";
		v_display_hide_apprvd_days = "display:inline";
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td><input type=hidden name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value=""><input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="N">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
<%
		v_display_hide_cred_auth = "display:inline";
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></div></td>
</tr>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
</tr>
<input type=hidden name='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' id='tmp_pol_eff_to<%=totalRecords%>' value=''>
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='U'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value=''>
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="N">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="N">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="N">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="N">
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>'   value=""> 
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="">   <!--  V230315 -->
 
<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->

<%
			totalRecords++;
		}
	}
	tempDesc=desc;
	}
}
else
{
	isExtnJSPLoaded = "Y";
	%>
	
<jsp:include page="../../eBL/jsp/AddModifyPatFinDetailsInsBodyExtn1.jsp" >
	<jsp:param name="flush" value="true" />
	<jsp:param name="billing_group"  value='<%=billing_group%>'/>
	<jsp:param name="p_patient_class"  value='<%=p_patient_class%>'/>
	<jsp:param name="class_code"  value='<%=class_code%>'/>
	<jsp:param name="totalRecords"  value='<%=totalRecords%>'/>
	<jsp:param name="strModuleId"  value='<%=strModuleId%>'/>
	<jsp:param name="episode_type"  value='<%=episode_type%>'/>
</jsp:include> 
				
<%				
}
%>
</tbody>
</table>
</div>
<input type='hidden' name='total_records' id='total_records' value="<%=totalRecords%>">
<input type='hidden' name='isExtnJSPLoaded' id='isExtnJSPLoaded' value="<%=isExtnJSPLoaded%>">
<input type='hidden' name='focussed_row' id='focussed_row' value='' >
<input type='hidden' name='checked_row' id='checked_row' value='' >
<input type='hidden' name='sys_date' id='sys_date' value="<%=sys_date%>">
<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value="<%=ins_auth_flag%>">
<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type='hidden' name='Case' id='Case' value='4'>
<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value="<%=strCreditDoc_YN%>">
<input type='hidden' name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value="<%=strRepositoryYN%>">	
<input type='hidden' name="items_disabled" id="items_disabled" value="<%=strItemsDisabled%>">	
<input type='hidden' name="calling_module_id" id="calling_module_id" value="<%=strModuleId%>">	
<input type='hidden' name="function_id" id="function_id" value="<%=str_function_id%>">	
<input type='hidden' name="operation_fun" id="operation_fun" value="<%=operation%>">	
<input type='hidden' name="operation_mode" id="operation_mode" value="<%=billing_mode%>">	
<input type='hidden' name='CitizenYn' id='CitizenYn' value="<%=strCitizenYn%>">
<input type='hidden' name='blnggrpappyn' id='blnggrpappyn' value="<%=strBlngGrpAppYN%>">		
<input type='hidden' name='blnggrpcatgappyn' id='blnggrpcatgappyn' value="<%=strBlngGrpCatgAppYN%>">
<input type='hidden' name='BlngGrpStatus' id='BlngGrpStatus' value="<%=strBlngGrpStatus%>">
<input type='hidden' name='mpolicy_type' id='mpolicy_type' value="<%=mpolicy_type_code%>">
<input type='hidden' name="locale" id="locale"  value="<%=locale%>">
<input type='hidden' name="p_patient_class" id="p_patient_class"  value="<%=p_patient_class%>">
<input type='hidden' name="episode_type" id="episode_type"  value="<%=episode_type%>">
<input type='hidden' name='facility_id' id='facility_id'   value="<%=facility_id%>">
<input type='hidden' name='patient_id' id='patient_id'   value="<%=patient_id%>">
<input type='hidden' name="queryString" id="queryString"  value="<%=queryString%>">
<input type='hidden' name="blng_grp_values" id="blng_grp_values"  value="<%=blng_grp_values%>">
<input type='hidden' name='cap_ref_src_dtl_flag' id='cap_ref_src_dtl_flag' value="<%=referral_source_code_flag%>">
<input type='hidden' name='referral_source_main_mand_YN' id='referral_source_main_mand_YN' value='<%=referral_source_main_mand_YN%>'>
<input type='hidden' name='referral_source_sub_mand_YN' id='referral_source_sub_mand_YN' value='<%=referral_source_sub_mand_YN%>'>
<input type='hidden' name='pr_payer_employer_id_mand_YN' id='pr_payer_employer_id_mand_YN' value='<%=pr_payer_employer_id_mand_YN%>'>
<input type='hidden' name='refresh_check' id='refresh_check' value='<%=refresh_check%>'>
<input type="hidden" name="policy_coverage_basis_gbl_ind" id="policy_coverage_basis_gbl_ind" value="<%=policy_coverage_basis_gbl_ind%>" >
<input type="hidden" name="valid_pkg_for_pat_bg_avail_YN" id="valid_pkg_for_pat_bg_avail_YN" value="<%=str_valid_pkg_for_pat_bg_avail_YN%>" >
<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
<input type='hidden' name='retVal' id='retVal' value=''>
<input type=hidden name="siteSpec" id="siteSpec" value="<%=siteSpec %>"> 
<input type=hidden name="siteSpecPolApprv" id="siteSpecPolApprv" value="<%=siteSpecPolApprv %>" /> 
<%
queryString=queryString+"&payerGrpBySetup="+payerGrpBySetup;
	if((!(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y"))))
	{
		
%>
<script>
	parent.frames[2].location.href="../../eBL/jsp/AddModifyPatFinDetailsInsButton.jsp?&<%=queryString%>";	
</script>
<%
	}
%>
<%
	if((!(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y"))))
	{
					
%>
	<input type= hidden name="billing_group" id="billing_group"  value="<%=billing_group%>">
<%
		if( ((!(cust_4.equals("")) || !(cash_set_type2.equals(""))) && autoFinChk.equals("N")) || autoFinChk.equals("Y") )
		{
%>
<script>
	parent.parent.frames[1].location.href="../../eBL/jsp/AddModifyPatFinDetails7.jsp?<%=queryString%>";	
</script>
<%
		}
		if(!(cash_insmt_ref1.equals("")))
		{
%>
<script>
	parent.parent.frames[1].location.href="../../eBL/jsp/AddModifyPatFinDetails4.jsp?<%=queryString%>";	
</script>
<%
		}
	}
	else
	{
%>
	<input type= hidden name="billing_group" id="billing_group"  value="<%=billing_group%>">
<%
	}
%>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);

		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);

%>
<script>
var isExtnJSPLoaded = document.forms[0].isExtnJSPLoaded.value;
if(isExtnJSPLoaded == "Y"){
	var totRec = document.forms[0].totRec.value;
	document.forms[0].total_records.value = totRec;
}
	
</script>
