<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@page import="com.google.gson.JsonObject"%>
<%@ page import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*,java.text.*,eXH.InterfaceUtil,eBL.*" contentType="text/html;charset=UTF-8" %>
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
<script>
function selected_loc(i)
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
</script>
<%
	int priority_count=0;
	String sql_default="";
	String autoFinChk="N";
	String blng_grp_values="", billing_group = "", class_code = "";
	JsonObject objFromBean = null;
	String str_currency_code_for_bg="", str_currency_desc_for_bg="";
	String payerGrpBySetup = "";
	String strChargeLogicYN = "";
	String p_patient_class = "";
	String DFLT_POLICY_DEF_IN_VIS_REG_YN=null;
	int totalRecords=0;
	String classval="";
	String strModuleId = "";
	String valid_payer_YN="";
	String valid_policy_type_code_YN="";
	String cust_valid_from_date = "" ,cust_valid_to_date = "";
	String payer_suspended_YN = "N", policy_suspended_YN = "N";
	String episode_type="";
	String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
	String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
	String policy_coverage_basis_gbl_ind="";
	String cust_group_name = "";
	String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
	String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";
	String pol_validity_chk_date="";
	String rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
	
	Connection con				= null;
 	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	
	try
	{
	HttpSession httpSession = request.getSession(false);
	String facility_id = (String)httpSession.getValue("facility_id");	
	String locale			= (String)session.getAttribute("LOCALE");	
	con	=	ConnectionManager.getConnection(request);
	
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	
	objFromBean = addModifyBean.getDfltPlcyAndPyrGrpSetup(con, facility_id);
	DFLT_POLICY_DEF_IN_VIS_REG_YN = objFromBean.get("dfltPolicyDefInVisRegnYn").getAsString();
	payerGrpBySetup = objFromBean.get("payerGrpBySetup").getAsString();
	strChargeLogicYN = objFromBean.get("strChargeLogicYN").getAsString();
	objFromBean = null;	
	

	
	billing_group = request.getParameter("billing_group") == null ? "" : request.getParameter("billing_group");
	p_patient_class = request.getParameter("p_patient_class") == null ? "" : request.getParameter("p_patient_class");
	class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
	strModuleId = request.getParameter("strModuleId") == null ? "" : request.getParameter("strModuleId");
	episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		objFromBean=addModifyBean.getblngGrpDesc(billing_group,locale,con);
		String blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		blng_grp_values=blng_grp_values+billing_group+"|";
	int i=0;

	if(autoFinChk.equals("Y"))
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN,d.POLICY_EFF_TO effTo FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,BL_APPL_BG_BY_CLASSFCTN g WHERE a.operating_facility_id ='"+facility_id+"' AND a.blng_grp_id ='"+billing_group+"' AND a.BLNG_GRP_ID = g.APPL_BLNG_GRP_ID AND a.patient_class ='"+p_patient_class+"' and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE AND g.CLASSIFICATION_CODE='"+class_code+"' AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND a.operating_facility_id = g.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=f.cust_code AND f.cust_code=g.APPL_CUST_CODE AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND d.cust_group_code=g.APPL_CUST_GROUP_CODE AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code ORDER BY a.priority_no";	
	}
	else
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN,d.POLICY_EFF_TO effTo FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,bl_blng_grp g  WHERE a.operating_facility_id ='"+facility_id+"'  AND  g.blng_grp_id  = a.blng_grp_id AND g.DFLT_PAYER_DTLS_DURING_REGN_YN = 'Y' AND a.blng_grp_id ='"+billing_group+"' AND a.patient_class ='"+p_patient_class+"' and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=f.cust_code AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code and nvl(a.status,'E') = 'E'  ORDER BY a.priority_no";	
	}
		if(payerGrpBySetup.equalsIgnoreCase("Y")){		
			String payerList=(String)session.getAttribute("BL_PAYER_LIST_FROM_SETUP");
			session.setAttribute("BL_PAYER_LIST_FROM_SETUP",null);
			if(payerList != null){
				sql_default = FinDtlsQueryFormation(payerList,facility_id,billing_group,p_patient_class);
			}
		}
	pstmt = con.prepareStatement(sql_default);
	rs2 = pstmt.executeQuery() ;
	if( rs2 != null) 
	{
		while( rs2.next() )
		{  
			String payerEligibilityParam="9";
			String cust_code=rs2.getString(1);
			if(cust_code==null || cust_code.equals("")) cust_code="";
			String cust_short_name="";String policy_short_desc="";
			String policy_type_code=rs2.getString(3);
			if(policy_type_code==null || policy_type_code.equals("")) policy_type_code="";
			String priority_no=rs2.getString(5);
			if(priority_no==null || priority_no.equals("")) priority_no="";
			String cust_group_code=rs2.getString(12);
			if(cust_group_code==null || cust_group_code.equals("")) cust_group_code="";
			String policy_coverage_basis_ind=rs2.getString(13);
			if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals("")) policy_coverage_basis_ind="";
			String adj_rule_ind=rs2.getString(6);
			if(adj_rule_ind==null || adj_rule_ind.equals("")) adj_rule_ind="";
			String adj_perc_amt_ind=rs2.getString(7);
			if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals("")) adj_perc_amt_ind="";
			String adj_perc_amt_value=rs2.getString(8);
			if(adj_perc_amt_value==null || adj_perc_amt_value.equals("")) adj_perc_amt_value="";
			String pmnt_diff_adj_int=rs2.getString(9);
			if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals("")) pmnt_diff_adj_int="";
			String drg_pmnt_diff_adj_int=rs2.getString(10);
			if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals("")) drg_pmnt_diff_adj_int="";
			String spl_srv_pmnt_diff_adj_int=rs2.getString(11);
			if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals("")) spl_srv_pmnt_diff_adj_int="";
			String interfaceYNcustgroup = rs2.getString(15);
			if(interfaceYNcustgroup==null || interfaceYNcustgroup.equals("")) interfaceYNcustgroup="";
			String polEfToDate=rs2.getString(16); 
			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}
			priority_count++;
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			objFromBean=addModifyBean.getRefSourceFlagsForP1(billing_group, con);
			referral_source_capture_YN= objFromBean.get("referral_source_code_flag").getAsString();
			ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			objFromBean=addModifyBean.getCustDtls(cust_group_code,cust_code,locale,policy_type_code,con);
			cust_group_name=objFromBean.get("cust_group_name").getAsString();
			cust_short_name=objFromBean.get("cust_short_name").getAsString();
			policy_short_desc=objFromBean.get("policy_short_desc").getAsString();	
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
%>
<%
	if(i==0)
	{
%>
<tr>
<td class='PATIENTLINECOLOR'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;<div id="bg_curr_desc_disp<%=totalRecords%>" style="display:inline"><Font color='red'><b id="bg_curr_desc<%=totalRecords%>"></b></font></div></td>
<td class='PATIENTLINECOLOR' colspan=2 ><input type='text' readonly name="billing_group_desc<%=totalRecords%>" id="billing_group_desc<%=totalRecords%>" maxlength='40' size='25' tabindex='0' value="<%=blng_grp_long_desc%>"></td>
<input type='hidden' name='blng_grp_visible<%=totalRecords%>' id='blng_grp_visible<%=totalRecords%>' value="Y">
<td  class='PATIENTLINECOLOR'>
			<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
			</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc<%=totalRecords%>" id="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" id="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name_<%=totalRecords%>" id="pmy_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
		</div>
</td>
<td class='PATIENTLINECOLOR'>
		<div id='ref_src_code_sub_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
</td>
<td class='PATIENTLINECOLOR' colspan=2>
		<div id='ref_src_code_sub_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc<%=totalRecords%>" id="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'B')">
			<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" id="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name_<%=totalRecords%>" id="sec_ref_src_lng_name_<%=totalRecords%>" align='center' style="visibility:hidden">
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
<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' id='referral_source_main_desc<%=totalRecords%>' value="">
<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' id='referral_source_sub_desc<%=totalRecords%>' value="">
<%
	}
	String check_profileId="ELCPROF1";
	String profile_id_exists="N";
	String moduleIdCheck = InterfaceUtil.checkModuleIdForPayerEligibility(strModuleId);
    profile_id_exists = InterfaceUtil.isInterfaceProfileExisting(check_profileId);
	if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck) )
	{ 
		if("Y".equals(interfaceYNcustgroup))
		{
		  payerEligibilityParam="0";
		}
		else
		{
          payerEligibilityParam="9";
		}
	}
%>
<tr id=row<%=totalRecords%>>
<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>" id="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>" id="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='blng_grp_code<%=totalRecords%>' id='blng_grp_code<%=totalRecords%>' value="<%=billing_group%>">
<input type='hidden' name='referral_source_main_code<%=totalRecords%>' id='referral_source_main_code<%=totalRecords%>' value="">
<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' id='referral_source_sub_code<%=totalRecords%>' value="">
<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' id='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' id='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' id='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
<input type= "hidden" name="payerEligibilityParam<%=totalRecords%>" id="payerEligibilityParam<%=totalRecords%>"  value="<%=payerEligibilityParam%>">
<input type= "hidden" name="responseCode<%=totalRecords%>" id="responseCode<%=totalRecords%>" value="">
<input type= "hidden" name="responseCodeDesc<%=totalRecords%>" id="responseCodeDesc<%=totalRecords%>" value="">
<input type= "hidden" name="statuDescription<%=totalRecords%>" id="statuDescription<%=totalRecords%>" value="">
<input type= "hidden" name="validityPeriod<%=totalRecords%>" id="validityPeriod<%=totalRecords%>" value="">
<input type= "hidden" name="validityPeriodDesc<%=totalRecords%>" id="validityPeriodDesc<%=totalRecords%>" value="">
<input type= "hidden" name="eligibilityCode<%=totalRecords%>" id="eligibilityCode<%=totalRecords%>" value="">
<input type= "hidden" name="transactionId<%=totalRecords%>" id="transactionId<%=totalRecords%>" value="">
<input type= "hidden" name="responseDateTime<%=totalRecords%>" id="responseDateTime<%=totalRecords%>" value="">
<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' id='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected_loc(<%=totalRecords%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>' id='ins_cust_group_name<%=totalRecords%>'  value="<%=cust_group_name%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<%
	try
	{
		String empty_sql_check="N";
		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO,a.status status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and a.CUST_CODE ='"+cust_code+"' and b.cust_group_code='"+cust_group_code+"'";
		pstmt = con.prepareStatement(valid_payer_YN_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			valid_payer_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_payer_YN=rs.getString(1);
				cust_valid_from_date = rs.getString(2);
				cust_valid_to_date = rs.getString(3);
				payer_suspended_YN = rs.getString(4);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
		if(payer_suspended_YN == null) payer_suspended_YN="";
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_payer_YN_sql:"+e);
			e.printStackTrace();
	}

	if(valid_payer_YN.equals("")) valid_payer_YN="N";
	if(cust_valid_from_date == null) cust_valid_from_date= "";
	if(cust_valid_to_date == null) cust_valid_to_date= "";
	if(cust_code.equals("**")) valid_payer_YN="Y";
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>' id='payer_desc<%=totalRecords%>'  value="<%=cust_short_name%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
<input type='hidden' name='cust_3<%=totalRecords%>' id='cust_3<%=totalRecords%>' value="<%=cust_code%>">
<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' id='ins_cust_group_code<%=totalRecords%>' value="<%=cust_group_code%>">
<input type='hidden' name='valid_payer_YN<%=totalRecords%>' id='valid_payer_YN<%=totalRecords%>' value="<%=valid_payer_YN%>">
<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' id='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' id='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' id='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' id='priority<%=totalRecords%>' style='text-align:right'  value="<%=priority_no%>" onFocus='check(<%=totalRecords%>);'  readonly></td> 
<%
//6/10/2008	String valid_policy_type_code_YN_sql="Select DISTINCT 'Y' from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, ar_customer c where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' and nvl(a.status,'N') <> 'S' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code='"+cust_code+"' and c.cust_group_code = b.cust_group_code and (b.cust_code=c.cust_code or b.cust_code = '**') and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";
	objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, cust_code, cust_group_code, policy_type_code, locale, facility_id, con);
	valid_policy_type_code_YN = objFromBean.get("valid_policy_type_code_YN").getAsString();
	policy_suspended_YN = objFromBean.get("policy_suspended_YN").getAsString();
	if(!(policy_type_code.equals("") && cust_code.equals("")))
	{
		String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_code+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
		String empty_sql_check="N";
		v_display_hide="";
		v_display_hide_apprvd_amt="";
		v_display_hide_apprvd_days="";
		cred_auth_req_yn = "N";
		cred_auth_mand_capt_yn = "N";
		dflt_auth_ref_as_pol_no_yn = "N";
		pstmt = con.prepareStatement(restrict_check_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{
			empty_sql_check="Y";
			while(rs.next())
			{
				restrict_check=rs.getString(1);
				apprd_amt_restrict_check = rs.getString(2); 
				apprd_days_restrict_check = rs.getString(3);
				cred_auth_req_yn = rs.getString(4); 
				dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
				cred_auth_mand_capt_yn = rs.getString(6); 
				empty_sql_check="N";
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
		if(empty_sql_check.equals("Y"))
		{
			restrict_check="";
			apprd_amt_restrict_check ="";
			apprd_days_restrict_check ="";
			restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code='"+cust_group_code+"'";
			pstmt = con.prepareStatement(restrict_check_sql);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{
				while(rs.next())
				{
					restrict_check=rs.getString(1);
					apprd_amt_restrict_check = rs.getString(2); 
					apprd_days_restrict_check = rs.getString(3);
					cred_auth_req_yn = rs.getString(4); 
					dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
					cred_auth_mand_capt_yn = rs.getString(6); 
				}
			}
			if(rs != null) rs.close();
			pstmt.close();
		}
	}	
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";			
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";
	if(restrict_check.equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (restrict_check.equals("R"))
	{
		if(apprd_amt_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(apprd_days_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
	if(cred_auth_req_yn.equals("Y"))
	{
		if(cred_auth_mand_capt_yn.equals("Y"))
		{
			encounter_date = encounter_date_aft_trunc;
		}
		else
		{
			encounter_date = "";
		}
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		encounter_date = "";
		v_display_hide_cred_auth = "display:none";
	}
	if(!encounter_date.equals(""))
	{
		if(!locale.equals("en"))
		{
			encounter_date=com.ehis.util.DateUtils.convertDate(encounter_date,"DMY","en",locale);
		}
	}
%>
<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>' id='policy_type_desc<%=totalRecords%>'  value="<%=policy_short_desc%>" onFocus='check(<%=totalRecords%>);'  readonly>
<% if( "Y".equals(strChargeLogicYN)) { %>
<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
<%}%>	
</td>
<input type='hidden' name='policy_type_code<%=totalRecords%>' id='policy_type_code<%=totalRecords%>' value="<%=policy_type_code%>" >
<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' id='valid_policy_type_code_YN<%=totalRecords%>' value="<%=valid_policy_type_code_YN%>" >
<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' id='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>' id='policy_no<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' id='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value=''  onFocus='check(<%=totalRecords%>);' readonly></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' id='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value=''  onFocus='check(<%=totalRecords%>);'  readonly></td>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>' id='credit_auth_ref<%=totalRecords%>' value="" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' id='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value='<%=encounter_date%>' readonly></div></td>
</tr>
<tr id=row<%=totalRecords%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
<td class=<%=classval%> width='12%'><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' id='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' id='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' id='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value='' readonly></td>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' id='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value='' readonly></td>
</tr>
<input type="hidden" name="tmp_pol_eff_to<%=totalRecords %>" id="tmp_pol_eff_to<%=totalRecords %>" id="tmp_pol_eff_to<%=totalRecords %>" value="<%=polEfToDate%>"> <!-- Added By Vijay For MMS-QF-SCF-567 -->
<input type=hidden name='adj_rule_ind<%=totalRecords%>' id='adj_rule_ind<%=totalRecords%>' value="<%=adj_rule_ind%>">
<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' id='adj_perc_amt_ind<%=totalRecords%>' value="<%=adj_perc_amt_ind%>">
<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' id='adj_perc_amt_value<%=totalRecords%>' value="<%=adj_perc_amt_value%>">
<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' id='pmnt_diff_adj_int<%=totalRecords%>' value="<%=pmnt_diff_adj_int%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' id='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=drg_pmnt_diff_adj_int%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' id='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=spl_srv_pmnt_diff_adj_int%>">
<input type=hidden name='restrict_check<%=totalRecords%>' id='restrict_check<%=totalRecords%>' value="<%=restrict_check%>">
<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' id='apprd_amt_restrict_check<%=totalRecords%>' value='<%=apprd_amt_restrict_check%>'>
<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' id='apprd_days_restrict_check<%=totalRecords%>' value='<%=apprd_days_restrict_check%>'>
<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' id='policy_coverage_basis_ind<%=totalRecords%>' value="<%=policy_coverage_basis_ind%>">
<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' id='cred_auth_req_yn<%=totalRecords%>' value="<%=cred_auth_req_yn%>">
<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' id='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=cred_auth_mand_capt_yn%>">
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' id='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=dflt_auth_ref_as_pol_no_yn%>">
<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' id='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
<input type=hidden name='rec_edited_YN<%=totalRecords%>' id='rec_edited_YN<%=totalRecords%>' value="N">
<input type=hidden name='policy_eff_to_date_hdn' id='policy_eff_to_date_hdn' id='policy_eff_to_date_hdn' value='<%=rtn_ins_policy_eff_to_date %>'>
<input type=hidden name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>' value=""> 
<input type=hidden name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>'   value="">  <!--  V230315 -->

<input type=hidden name="userId_for_priv<%=totalRecords%>" id="userId_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->
<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" id="reasonCode_for_priv<%=totalRecords%>" value="" />  <!-- V230707 -->

<%
		i++;
	    totalRecords++;
	}
	}
	%>
	<input type="hidden" name="totRec" id="totRec" id="totRec" value="<%=totalRecords%>">	
	<%
		if(rs2 != null) rs2.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 
%>
