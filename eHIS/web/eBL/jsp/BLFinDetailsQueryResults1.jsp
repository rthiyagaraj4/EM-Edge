<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	PreparedStatement pstmt2 = null ;
	ResultSet rs = null ;
	ResultSet rs1 = null, rs2 = null;
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");

//		String user_id = "";
		String facility_id = (String)httpSession.getValue("facility_id");	
		String last_visit_dtls="N";
		String sql="";		

		String rtn_blng_class_code="",rtn_employer_code="",rtn_slmt_ind="",rtn_blng_grp="";
//		String rtn_bing_class_desc="",rtn_blng_grp_desc="";
		String rtn_annual_family_income="",rtn_family_assets_value="",rtn_num_of_dependents="";
		String rtn_resp_for_bill_payment="",rtn_pat_reln_with_resp_pers="",rtn_gl_holder_name="",rtn_pat_reln_with_gl_holder="";

		String rtn_slmt_type_code="",rtn_inst_ref="",rtn_inst_date="",rtn_inst_remarks="";
		String rtn_credit_doc_reqd_yn="",rtn_credit_cust_code="",rtn_credit_doc_ref="",rtn_credit_doc_start_date="",rtn_credit_doc_end_date="";
		String rtn_sponsor_cust_code="",rtn_sponsor_credit_doc_ref="",rtn_sponsor_credit_doc_start_date="",rtn_sponsor_credit_doc_end_date="";

		String rtn_ins_blng_grp="",rtn_ins_cust_code="",rtn_ins_cust_priority="",rtn_ins_policy_type_code="",rtn_ins_policy_no="";
		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="",rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="",rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";
		String rtn_non_ins_blng_grp="",rtn_non_ins_cust_code="",rtn_non_ins_credit_doc_reqd_yn="",rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref="",rtn_non_ins_inst_date="",rtn_non_ins_inst_remarks="",rtn_non_ins_credit_doc_ref="",rtn_non_ins_credit_doc_start_date="",rtn_non_ins_credit_doc_end_date="";

//		String rtn_non_ins_blng_grp_desc="";	
		String rtn_remarks="";

		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String cust_code="",credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String non_ins_blng_grp_id="",non_ins_cust_code="",non_ins_settlement_ind="";

		String temp_ins_blng_grp="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";
		
//		String remarks="";

		String patient_id=request.getParameter("patient_id");

		sql="select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id ='"+patient_id+"'";

		try
		{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					rtn_blng_grp= rs.getString("blng_grp_id");
					if(rtn_blng_grp==null) rtn_blng_grp="";
					rtn_slmt_ind= rs.getString("settlement_ind");
					if(rtn_slmt_ind==null) rtn_slmt_ind="";
					if(last_visit_dtls.equals("N"))
					{
						rtn_annual_family_income= rs.getString("annual_family_income");
						if(rtn_annual_family_income==null) rtn_annual_family_income="";
						rtn_family_assets_value = rs.getString("family_assets_value");
						if(rtn_family_assets_value==null) rtn_family_assets_value="";
					}
					rtn_num_of_dependents= rs.getString("num_of_dependents");
					if(rtn_num_of_dependents==null) rtn_num_of_dependents="";
					rtn_resp_for_bill_payment= rs.getString("resp_for_bill_payment");
					if(rtn_resp_for_bill_payment==null) rtn_resp_for_bill_payment="";
					rtn_pat_reln_with_resp_pers= rs.getString("pat_reln_with_resp_pers");
					if(rtn_pat_reln_with_resp_pers==null) rtn_pat_reln_with_resp_pers="";
					rtn_remarks= rs.getString("remarks");
					if(rtn_remarks==null) rtn_remarks="";
					rtn_gl_holder_name= rs.getString("gl_holder_name");
					if(rtn_gl_holder_name==null) rtn_gl_holder_name="";
					rtn_pat_reln_with_gl_holder= rs.getString("pat_reln_with_gl_holder");
					if(rtn_pat_reln_with_gl_holder==null) rtn_pat_reln_with_gl_holder="";
					rtn_blng_class_code= rs.getString("blng_class_code");
					if(rtn_blng_class_code==null) rtn_blng_class_code="";
					rtn_employer_code= rs.getString("employer_code");
					if(rtn_employer_code==null) rtn_employer_code="";
//					user_id = p.getProperty("login_user");
//					if(user_id==null) user_id="";

					slmt_type_code=rs.getString("slmt_type_code");
//					System.out.println("slmt_type_code:"+slmt_type_code);
					if(slmt_type_code==null) slmt_type_code="";
					inst_ref =  rs.getString("slmt_doc_ref_desc");
					if(inst_ref==null) inst_ref="";
					inst_date = rs.getString("slmt_doc_ref_date");
					if(inst_date==null) inst_date="";
					inst_remarks = rs.getString("slmt_doc_remarks");
					if(inst_remarks==null) inst_remarks="";

					cust_code=rs.getString("cust_code");
					if(cust_code==null) cust_code="";
					credit_doc_ref_desc= rs.getString("credit_doc_ref_desc");
					if(credit_doc_ref_desc==null) credit_doc_ref_desc="";
					credit_doc_ref_start_date= rs.getString("credit_doc_ref_start_date");
					if(credit_doc_ref_start_date==null) credit_doc_ref_start_date="";
					credit_doc_ref_date= rs.getString("credit_doc_ref_date");
					if(credit_doc_ref_date==null) credit_doc_ref_date="";

					non_ins_blng_grp_id= rs.getString("non_ins_blng_grp_id");
//					System.out.println("non_ins_blng_grp_id:"+non_ins_blng_grp_id);
					if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";
					non_ins_cust_code= rs.getString("non_ins_cust_code");
					if(non_ins_cust_code==null) non_ins_cust_code="";

					if (rtn_slmt_ind.equals("C"))
					{
//						System.out.println("Inside Cash");
						rtn_slmt_type_code= slmt_type_code;
						if(rtn_slmt_type_code==null) rtn_slmt_type_code="";
						rtn_inst_ref =  inst_ref;
						if(rtn_inst_ref==null) rtn_inst_ref="";
						rtn_inst_date = inst_date;
						if(rtn_inst_date==null) rtn_inst_date="";
						rtn_inst_remarks = inst_remarks;
						if(rtn_inst_remarks==null) rtn_inst_remarks="";

						if (credit_doc_ref_desc !=null)
						{
							rtn_credit_doc_reqd_yn = "Y";
						}
						else
						{
							rtn_credit_doc_reqd_yn = "N";
						}
					}
					else if (rtn_slmt_ind.equals("R"))
					{
//						System.out.println("Inside Credit");
						rtn_credit_doc_reqd_yn = "Y";
						rtn_credit_cust_code = cust_code;
						if(rtn_credit_cust_code==null) rtn_credit_cust_code="";
					}

					if( rtn_slmt_ind.equals("R") || (rtn_slmt_ind.equals("C") && !(credit_doc_ref_desc.equals(""))))
					{
//						System.out.println("Inside Credit");
 						rtn_credit_doc_ref = credit_doc_ref_desc;
						if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
						rtn_credit_doc_start_date = credit_doc_ref_start_date;
						if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
						rtn_credit_doc_end_date = credit_doc_ref_date;
						if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
					}
					else if(rtn_slmt_ind.equals("X") &&  non_ins_blng_grp_id.equals(""))
					{
//						System.out.println("Inside Sponsor");
						rtn_credit_doc_reqd_yn = "Y";
						rtn_sponsor_cust_code = cust_code;
						if(rtn_sponsor_cust_code==null) rtn_sponsor_cust_code="";
						rtn_sponsor_credit_doc_ref = credit_doc_ref_desc;
						if(rtn_sponsor_credit_doc_ref==null) rtn_sponsor_credit_doc_ref="";
						rtn_sponsor_credit_doc_start_date = credit_doc_ref_start_date;
						if(rtn_sponsor_credit_doc_start_date==null) rtn_sponsor_credit_doc_start_date="";
						rtn_sponsor_credit_doc_end_date = credit_doc_ref_date;
						if(rtn_sponsor_credit_doc_end_date==null) rtn_sponsor_credit_doc_end_date="";

					}
					else if(rtn_slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
					{
//						System.out.println("Inside Insurance");
						String sql_ins="SELECT a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type = 'R' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL ORDER BY 2";

						try
						{
							pstmt1 = con.prepareStatement(sql_ins);
							rs1 = pstmt1.executeQuery() ;
							if( rs1 != null ) 
							{
								while( rs1.next() )
								{  
									temp_ins_cust_code=rs1.getString("cust_code");
									rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
									if(rtn_ins_cust_code==null) rtn_ins_cust_code="";
									
									temp_ins_cust_priority=rs1.getString("priority");
									rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
									if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
									
									temp_ins_policy_type_code=rs1.getString("policy_type_code");
									rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
									if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";
									
									temp_ins_policy_no=rs1.getString("policy_number");
									rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
									if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
									
									temp_ins_policy_start_date=rs1.getString("policy_start_date");
									rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
									if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
									
									temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
									rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
									if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
									
									temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
									rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
									if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
									
									temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
									rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+temp_ins_credit_auth_date+"|";
									if(rtn_ins_credit_auth_date==null) rtn_ins_credit_auth_date="";
									
									temp_ins_credit_approval_days=rs1.getString("approved_days");
									if(temp_ins_credit_approval_days==null || temp_ins_credit_approval_days.equals("")) temp_ins_credit_approval_days=" ";
									rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+temp_ins_credit_approval_days+"|";
									if(rtn_ins_credit_approval_days==null) rtn_ins_credit_approval_days="";
									
									temp_ins_credit_approval_amount=rs1.getString("approved_amt");
									if(temp_ins_credit_approval_amount==null || temp_ins_credit_approval_amount.equals("")) temp_ins_credit_approval_amount=" ";
									rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+temp_ins_credit_approval_amount+"|";
									if(rtn_ins_credit_approval_amount==null) rtn_ins_credit_approval_amount="";
									
									temp_ins_policy_eff_from_date=rs1.getString("effective_from");
									rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
									if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
									
									temp_ins_policy_eff_to_date=rs1.getString("effective_to");
									if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
									rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
									if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";
									
									temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
									if(temp_ins_adj_rule_ind==null) temp_ins_adj_rule_ind=" ";
									rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
									if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
									
									temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
									if(temp_ins_adj_perc_amt_ind==null) temp_ins_adj_perc_amt_ind=" ";
									rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
									if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
									
									temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
									if(temp_ins_adj_perc_amt_value==null) temp_ins_adj_perc_amt_value=" ";
//									System.out.println("temp_ins_adj_perc_amt_value:"+temp_ins_adj_perc_amt_value);
									rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
									if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
									
									temp_ins_pmnt_diff_adj_int=rs1.getString("pmnt_diff_adj_int");
									if(temp_ins_pmnt_diff_adj_int==null) temp_ins_pmnt_diff_adj_int=" ";
									rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+temp_ins_pmnt_diff_adj_int+"|";
									if(rtn_ins_pmnt_diff_adj_int==null) rtn_ins_pmnt_diff_adj_int="";
									
									temp_ins_drg_pmnt_diff_adj_int=rs1.getString("drg_pmnt_diff_adj_int");
									if(temp_ins_drg_pmnt_diff_adj_int==null) temp_ins_drg_pmnt_diff_adj_int=" ";
									rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+temp_ins_drg_pmnt_diff_adj_int+"|";
									if(rtn_ins_drg_pmnt_diff_adj_int==null) rtn_ins_drg_pmnt_diff_adj_int="";
									
									temp_ins_spl_srv_pmnt_diff_adj_int=rs1.getString("spl_srv_pmnt_diff_adj_int");
									if(temp_ins_spl_srv_pmnt_diff_adj_int==null) temp_ins_spl_srv_pmnt_diff_adj_int=" ";									rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+temp_ins_spl_srv_pmnt_diff_adj_int+"|";
									if(rtn_ins_spl_srv_pmnt_diff_adj_int==null) rtn_ins_spl_srv_pmnt_diff_adj_int="";

									temp_ins_blng_grp=rs1.getString("blng_grp_id");
									if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
									if(temp_ins_cust_priority.equals("1"))
									{
										rtn_blng_grp=temp_ins_blng_grp;
									}
									rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
								}
							}
						
						}
						catch(Exception e)
						{
						}
						rs1.close();
						pstmt1.close();

						rtn_non_ins_blng_grp = non_ins_blng_grp_id;
						if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";
						rtn_non_ins_cust_code = non_ins_cust_code;

						if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";

						String sql_non_ins="select settlement_ind from bl_blng_grp where blng_grp_id ='"+non_ins_blng_grp_id+"'";
						try
						{
							pstmt2 = con.prepareStatement(sql_non_ins);
							rs2 = pstmt2.executeQuery() ;
							if( rs2 != null ) 
							{
								while( rs2.next() )
								{  
									non_ins_settlement_ind=rs2.getString("settlement_ind");
									if(non_ins_settlement_ind==null) non_ins_settlement_ind="";
								}
							}
						}
						catch(Exception e)
						{
						}
						rs2.close();
						pstmt2.close();
						if(non_ins_settlement_ind.equals("C"))
						{
							if(!(credit_doc_ref_desc.equals("")))
							{
								rtn_non_ins_credit_doc_reqd_yn = "Y";
							}
							else
							{
								rtn_non_ins_credit_doc_reqd_yn = "N";
							}
						
							rtn_non_ins_slmt_type_code = slmt_type_code;

							if(rtn_non_ins_slmt_type_code==null) rtn_non_ins_slmt_type_code="";
							rtn_non_ins_inst_ref = inst_ref;
							if(rtn_non_ins_inst_ref==null) rtn_non_ins_inst_ref="";
							rtn_non_ins_inst_date = inst_date;
							if(rtn_non_ins_inst_date==null) rtn_non_ins_inst_date="";
							rtn_non_ins_inst_remarks  = inst_remarks;
							if(rtn_non_ins_inst_remarks==null) rtn_non_ins_inst_remarks="";
						}
						else
						{
							rtn_non_ins_credit_doc_reqd_yn = "Y";
						}

						rtn_non_ins_credit_doc_ref = credit_doc_ref_desc;
						if(rtn_non_ins_credit_doc_ref==null) rtn_non_ins_credit_doc_ref="";
						rtn_non_ins_credit_doc_start_date = credit_doc_ref_start_date;
						if(rtn_non_ins_credit_doc_start_date==null) rtn_non_ins_credit_doc_start_date="";
						rtn_non_ins_credit_doc_end_date  = credit_doc_ref_date;
						if(rtn_non_ins_credit_doc_end_date==null) rtn_non_ins_credit_doc_end_date="";
				}
			}
		}
	rs.close();
	pstmt.close();
	}
	catch(Exception e)
	{
	}

%>
<html>	
<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>


<script language='javascript'>
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name='PatFinQryForm' id='PatFinQryForm' method='post' action=''  scrolling=no>
<table width='100%' cellpadding='3' cellspacing='0' border='0' align="center">
<td class="COLUMNHEADER" ><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></td>

<tr>
	<td class='label' width="25%" ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
	<td class='data'  width="25%" ><b><%=rtn_blng_grp%></b></td>
	<td class='label' width="25%" ><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=rtn_non_ins_blng_grp%></b></td>
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td class='data'  width="25%" ><b><%=rtn_blng_class_code%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="eBL.EMPLOYER_NAME.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%" ><b><%=rtn_employer_code%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
</tr>

<%
	if (rtn_slmt_ind.equals("C"))
	{
%>
<tr>
	<td class='label' width="25%"><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
	<td class='data' width="25%" ><b><%=rtn_slmt_type_code%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
</tr>
<%
	}
	}
	
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>


</table>
 
</form>
</body>
</html>

