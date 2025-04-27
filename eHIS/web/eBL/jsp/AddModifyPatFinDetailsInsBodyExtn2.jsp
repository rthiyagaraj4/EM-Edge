<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@page import="com.google.gson.JsonObject"%>
<%@ page import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*,java.text.*,eXH.InterfaceUtil,eBL.*" contentType="text/html;charset=UTF-8" %>
<%
	int totalRecords=0;
	String classval="";
	String desc = "";
	String tempDesc = "";
	String policy_coverage_basis_ind="", policy_coverage_basis_gbl_ind="";
	String blng_grp_values="", billing_group = "", class_code = "";
	String p_patient_class = "";
	String episode_type="";
	JsonObject objFromBean = null;
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	String cust_valid_from_date = "" ,cust_valid_to_date = "";
	String str_currency_code_for_bg="", str_currency_desc_for_bg="";
	String payer_suspended_YN = "N", policy_suspended_YN = "N";
	String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
	String ref_src_main_lng_name = "";
	String ref_src_sub_lng_name = "";

	String policy_start_date_conv="";
	String policy_exp_date_conv="";
	String credit_auth_date_conv="";
	String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String policy_eff_frm_date_conv="";
	String policy_eff_to_date_conv="";
	String policy_eff_to_date_Org=""; //Added By Vijay for MMS-QF-SCf-567
	String pol_validity_chk_date="";
	ArrayList existing_records_array=new ArrayList();
	String strChargeLogicYN = "";
	String strModuleId = "";
	String[] output1=new String[59]; //V240301 	//V240828 -MMS-DM-CRF-0252.1-US004
	String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
	
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
		
		billing_group = request.getParameter("billing_group") == null ? "" : request.getParameter("billing_group");
		p_patient_class = request.getParameter("p_patient_class") == null ? "" : request.getParameter("p_patient_class");
		class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
		strModuleId = request.getParameter("strModuleId") == null ? "" : request.getParameter("strModuleId");
		episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		
		existing_records_array = (ArrayList) request.getAttribute("existing_records_array");
	System.err.println("existing_records_array size is: "+existing_records_array.size());
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
			System.err.println("value of output1 for desc:"+output1[1]+"is this");
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			System.err.println("custcode value : "+output1[3]);
			objFromBean = addModifyBean.getCustValidDates(output1[3], con);
			
			
			cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
			System.err.println("cust_valid_from_date 121 : "+cust_valid_from_date);
			cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
			System.err.println("cust_valid_to_date 121: "+cust_valid_to_date);
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
	<td class='PATIENTLINECOLOR' colspan=2><input type='text' readonly name="billing_group_desc<%=totalRecords%>" maxlength='30' size='25' tabindex='0' value="<%=output1[0]%>">
	<input type='hidden' name='blng_grp_visible<%=totalRecords%>' value="Y">
	<td  class='PATIENTLINECOLOR' >
				<div id='ref_src_code_main_leg_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
				</div>
	</td>
	<td class='PATIENTLINECOLOR' colspan=2>
			<div id='ref_src_code_main_val_disp<%=totalRecords%>' style='<%=ref_src_code_disp%>'>
				<input type='text' name="referral_source_main_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[28]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'B')">
				<input type='button' class='button' name="refsrcmainbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'M',referral_source_main_desc<%=totalRecords%>,'C')" tabindex='0'>
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
				<input type='text' name="referral_source_sub_desc<%=totalRecords%>" maxlength='50' size='24' tabindex='0'  value="<%=output1[30]%>" onBlur="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'B')">
				<input type='button' class='button' name="refsrcsubbut<%=totalRecords%>" value='?' onClick="return refsrclkup(document.forms[0].blng_grp_code<%=totalRecords%>,'S',referral_source_sub_desc<%=totalRecords%>,'C')" tabindex='0'>
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
	<input type='hidden' name='billing_group_desc<%=totalRecords%>' value="<%=output1[0]%>">
	<input type='hidden' name='blng_grp_visible<%=totalRecords%>' value="N">
	<input type='hidden' name='referral_source_main_desc<%=totalRecords%>' value="<%=output1[28]%>">
	<input type='hidden' name='referral_source_sub_desc<%=totalRecords%>' value="<%=output1[30]%>">
	<%
			}
	%>
	<tr id=row<%=totalRecords%>>
	<input type= "hidden" name="currency_code_for_bg<%=totalRecords%>"  value="<%=str_currency_code_for_bg%>">
	<input type= "hidden" name="currency_desc_for_bg<%=totalRecords%>"  value="<%=str_currency_desc_for_bg%>">
	<input type='hidden' name='blng_grp_code<%=totalRecords%>' value="<%=output1[1]%>">
	<input type='hidden' name='referral_source_main_code<%=totalRecords%>' value="<%=output1[27]%>">
	<input type='hidden' name='referral_source_sub_code<%=totalRecords%>' value="<%=output1[29]%>">
	<input type='hidden' name='referral_source_capture_YN<%=totalRecords%>' value="<%=referral_source_capture_YN%>">
	<input type='hidden' name='referral_source_main_mand_YN<%=totalRecords%>' value="<%=ref_src_main_mand_YN%>">
	<input type='hidden' name='referral_source_sub_mand_YN<%=totalRecords%>' value="<%=ref_src_sub_mand_YN%>">
	<input type='hidden' name='payerEligibilityParam<%=totalRecords%>' value="<%=output1[41]%>">
	<input type='hidden' name='responseCode<%=totalRecords%>' value="<%=output1[42]%>">
	<input type='hidden' name='responseCodeDesc<%=totalRecords%>' value="<%=output1[43]%>">
	<input type='hidden' name='statuDescription<%=totalRecords%>' value="<%=output1[44]%>">
	<input type='hidden' name='validityPeriod<%=totalRecords%>' value="<%=output1[45]%>">
	<input type='hidden' name='validityPeriodDesc<%=totalRecords%>' value="<%=output1[46]%>">
	<input type='hidden' name='eligibilityCode<%=totalRecords%>' value="<%=output1[47]%>">
	<input type='hidden' name='transactionId<%=totalRecords%>' value="<%=output1[48]%>">
	<input type='hidden' name='responseDateTime<%=totalRecords%>' value="<%=output1[49]%>">
	<%
		blng_grp_values=blng_grp_values+output1[1]+"|";
		if(output1[23].equals("Y") && output1[24].equals("Y"))
		{
	%>
	<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>'  value="<%=output1[37]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
	<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>'  value="<%=output1[2]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
	<input type='hidden' name='cust_3<%=totalRecords%>' value="<%=output1[3]%>">
	<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' value="<%=output1[25]%>">
	<input type='hidden' name='valid_payer_YN<%=totalRecords%>' value='<%=output1[23]%>'>
	<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' value="<%=payer_suspended_YN%>">
	<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' value="<%=cust_valid_from_date%>">
	<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' value="<%=cust_valid_to_date%>">
	<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' style='text-align:right'  value="<%=output1[4]%>" onFocus='check(<%=totalRecords%>);'  readonly></td> 
	<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>'  value="<%=output1[5]%>" onFocus='check(<%=totalRecords%>);'  readonly>
	<% if( "Y".equals(strChargeLogicYN)) { %>
	<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
	<%}%>	
	</td>
	<input type='hidden' name='policy_type_code<%=totalRecords%>' value="<%=output1[6]%>" >
	<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' value='<%=output1[24]%>'>
	<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' value="<%=policy_suspended_YN%>">
	<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>'   value="<%=output1[7]%>" onFocus='check(<%=totalRecords%>);'  readonly></td>
	<%
		policy_start_date_conv=(String)output1[8];	
		if(policy_start_date_conv==null) policy_start_date_conv="";
		policy_start_date_conv=policy_start_date_conv.trim();
		if(!policy_start_date_conv.equals(""))
		{
			policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
		}
	%>
	<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_start_date_conv%>'  onFocus='check(<%=totalRecords%>);' readonly></td>
	<%
		policy_exp_date_conv=(String)output1[9];	 
		if(policy_exp_date_conv==null) policy_exp_date_conv="";
		policy_exp_date_conv=policy_exp_date_conv.trim();
		if(!policy_exp_date_conv.equals(""))
		{
			policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
		}
	%>
	<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_exp_date_conv%>'  onFocus='check(<%=totalRecords%>);'  readonly></td>
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
	<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>'   value="<%=output1[10]%>" onFocus='check(<%=totalRecords%>);'  readonly></div></td>
	<%
		credit_auth_date_conv=(String)output1[11];	
		if(credit_auth_date_conv==null) credit_auth_date_conv="";
		credit_auth_date_conv=credit_auth_date_conv.trim();
		if(!credit_auth_date_conv.equals(""))
		{
			credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
		}
	%>
	<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value='<%=credit_auth_date_conv%>' readonly></div></td>
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
	<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value='<%=output1[12]%>' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
	<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
	<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value='<%=output1[13]%>' onFocus='check(<%=totalRecords%>);'  readonly></div></td>
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
	<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_frm_date_conv%>' readonly></td>
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
	<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value='<%=policy_eff_to_date_conv%>' readonly></td>
	</tr>
	<input type=hidden name='adj_rule_ind<%=totalRecords%>' value="<%=output1[16]%>">
	<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' value="<%=output1[17]%>">
	<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' value="<%=output1[18]%>">
	<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[19]%>">
	<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[20]%>">
	<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="<%=output1[21]%>">
	<input type=hidden name='restrict_check<%=totalRecords%>' value='<%=output1[22]%>'>
	<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' value='<%=output1[31]%>'>
	<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' value='<%=output1[32]%>'>
	<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' value='<%=policy_coverage_basis_ind%>'>
	<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' value="<%=output1[33]%>">
	<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' value="<%=output1[40]%>">
	<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="<%=output1[34]%>">
	<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' value="<%=pol_validity_chk_date%>">
	<input type=hidden name='rec_edited_YN<%=totalRecords%>' value="<%=output1[39]%>">
	<input type=hidden name='mcn_for_policy<%=totalRecords%>'   value="<%=output1[51]%>">  
	<input type=hidden name='reg_ref_id<%=totalRecords%>'   value="<%=output1[52]%>">   <!-- V230315 -->
	<input type="hidden" name="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" value="<%=output1[50]%>">  <!--  Added By Vijay for MMS-QF-SCf-567-->
	<input type=hidden name="userId_for_priv<%=totalRecords%>" value="<%=output1[53]%>" />  <!-- V230707 -->
	<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" value="<%=output1[54]%>" />  <!-- V230707 -->
	<input type=hidden name="offline_Eligibility_Check<%=totalRecords%>" value="<%=output1[55]%>" />  <!-- V240301 -->
	<input type=hidden name="offline_Eligibility_Dt<%=totalRecords%>" value="<%=output1[56]%>" />  <!-- V240301 -->
	<input type=hidden name="offline_Eligibility_Code<%=totalRecords%>" value="<%=output1[57]%>" />  <!-- V240301 -->
	<input type=hidden name="admission_approval_details<%=totalRecords%>" value="<%=output1[58]%>" />  <!-- V280827 -->
	

		
	<% }
		else
		{
			if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
			{
	%>
	<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=totalRecords%>' value='<%=totalRecords%>' onClick="selected(<%=totalRecords%>)" >&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
	<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='payer_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
	<input type='hidden' name='cust_3<%=totalRecords%>' value="">
	<input type='hidden' name='ins_cust_group_code<%=totalRecords%>' value="">
	<input type='hidden' name='valid_payer_YN<%=totalRecords%>' value="N">
	<input type='hidden' name='payer_suspended_YN<%=totalRecords%>' value="">
	<input type='hidden' name='cust_valid_from_date<%=totalRecords%>' value="">
	<input type='hidden' name='cust_valid_to_date<%=totalRecords%>' value="">
	<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=totalRecords%>' style='text-align:right'  value='' onFocus='check(<%=totalRecords%>);' readonly></td>
	<%
			v_display_hide_apprvd_amt="display:inline";
			v_display_hide_apprvd_days = "display:inline";
	%>
	<td class=<%=classval%> width='12%' ><input maxlength='40' size='13' type=text name='policy_type_desc<%=totalRecords%>'  value="" onFocus='check(<%=totalRecords%>);' readonly>
	<% if( "Y".equals(strChargeLogicYN)) { %>
	<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->
	<%}%>	
	</td>
	<input type=hidden name='policy_type_code<%=totalRecords%>' value="">
	<input type='hidden' name='valid_policy_type_code_YN<%=totalRecords%>' value="N">
	<input type='hidden' name='policy_suspended_YN<%=totalRecords%>' value="">
	<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);'  readonly></td>
	<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
	<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
	<%
			v_display_hide_cred_auth = "display:inline";
	%>
	<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=totalRecords%>'   value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
	<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=totalRecords%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></div></td>
	</tr>
	<tr id=row<%=totalRecords%>>
	<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=totalRecords%>"></b></td>
	<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
	<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
	<td  class=<%=classval%> width='12%'><div id="apprd_days_leg_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
	<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=totalRecords%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=totalRecords%>' style='text-align:right'  value="" onFocus='check(<%=totalRecords%>);' readonly></div></td>
	<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
	<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly>
	<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
	<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=totalRecords%>' size='10' maxlength='10' value=""  onFocus='check(<%=totalRecords%>);' readonly></td>
	</tr>
	<input type=hidden name='adj_rule_ind<%=totalRecords%>' value="">
	<input type=hidden name='adj_perc_amt_ind<%=totalRecords%>' value="">
	<input type=hidden name='adj_perc_amt_value<%=totalRecords%>' value="">
	<input type=hidden name='pmnt_diff_adj_int<%=totalRecords%>' value="">
	<input type=hidden name='drg_pmnt_diff_adj_int<%=totalRecords%>' value="">
	<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=totalRecords%>' value="">
	<input type=hidden name='restrict_check<%=totalRecords%>' value='U'>
	<input type=hidden name='apprd_amt_restrict_check<%=totalRecords%>' value='U'>
	<input type=hidden name='apprd_days_restrict_check<%=totalRecords%>' value='U'>
	<input type=hidden name='policy_coverage_basis_ind<%=totalRecords%>' value=''>
	<input type=hidden name='cred_auth_req_yn<%=totalRecords%>' value="N">
	<input type=hidden name='cred_auth_mand_capt_yn<%=totalRecords%>' value="N">
	<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=totalRecords%>' value="N">
	<input type=hidden name='pol_validity_chk_date<%=totalRecords%>' value="">
	<input type=hidden name='rec_edited_YN<%=totalRecords%>' value="N">
	<input type=hidden name='mcn_for_policy<%=totalRecords%>'   value="<%=output1[51]%>">  
	<input type=hidden name='reg_ref_id<%=totalRecords%>'   value="<%=output1[52]%>">   <!-- V230315 -->
	<input type=hidden name="tmp_pol_eff_to<%=totalRecords%>" id="tmp_pol_eff_to<%=totalRecords%>" value="<%=output1[50]%>">  <!--  Added By Vijay for MMS-QF-SCf-567-->
	<input type=hidden name="userId_for_priv<%=totalRecords%>" value="<%=output1[53]%>" />  <!-- V230707 -->
	<input type=hidden name="reasonCode_for_priv<%=totalRecords%>" value="<%=output1[54]%>" />  <!-- V230707 -->
	<input type=hidden name="offline_Eligibility_Check<%=totalRecords%>" value="<%=output1[55]%>" />  <!-- V240301 -->
	<input type=hidden name="offline_Eligibility_Dt<%=totalRecords%>" value="<%=output1[56]%>" />  <!-- V240301 -->
	<input type=hidden name="offline_Eligibility_Code<%=totalRecords%>" value="<%=output1[57]%>" />  <!-- V240301 -->
	<input type=hidden name="admission_approval_details<%=totalRecords%>" value="<%=output1[58]%>" />  <!-- V280827 -->
	<%
				
			}
		}
		totalRecords++;
		tempDesc=desc;
		}
	%>	
		<input type=hidden name="totRec" id="totRec"  value="<%=existing_records_array.size()%>"><!-- Added By Vijay For MMS-QF-SCf-567  -->
	<%
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