<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con=null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1  = null;
	PreparedStatement pstmt2  = null;

	ResultSet rs1 = null;
	ResultSet rs2 = null;		

  	try
  	{	
//		System.out.println("Hidden Flds Loaded1");
		session.removeAttribute("financial_details");
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");

		String patient_id="";
		String episode_type="";
		String user_id = "";
		String facility_id = (String)httpSession.getValue("facility_id");	

		String last_visit_dtls="N";
		String sql="",episode="",record="";
		String strdfltbgyn="";

//		int future_adm_count=0;

		// Varibales for sql query
//Unused Var's
/*
		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String cust_code="",credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String non_ins_blng_grp_id="",non_ins_cust_code="",non_ins_settlement_ind="";

		String remarks="";
*/		

		// return variables
		String rtn_blng_class_code="",rtn_employer_code="",rtn_slmt_ind="",rtn_blng_grp="";
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

		String rtn_remarks="";

		String temp_ins_blng_grp="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";

		String billing_mode="",upd_fin_dtls="C", operation="Insert";


			patient_id=request.getParameter("patient_id");
			episode=request.getParameter("episode");
			record=request.getParameter("record");
			episode_type=request.getParameter("episode_type");
		
			if(episode==null)episode="";
			if(record==null)record="";
			if(episode_type==null)episode_type="";
		
			con = ConnectionManager.getConnection(request);

			if(episode.equals("N"))
			{
				String cond="Select last_episode_id, last_visit_id from op_last_visit where last_patient_id='"+patient_id+"'";

				pstmt2 = con.prepareStatement(cond);
				rs2 = pstmt2.executeQuery() ;
				if( rs2 != null ) 
				{
					while( rs2.next() )
					{
						last_visit_dtls="Y";
					}
				}
				if (rs2 != null)   rs2.close();
				pstmt2.close();
			}


		
			//sql="select blng_grp_id, blng_class_code, employer_code, settlement_ind, credit_doc_ref_desc,to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_code, slmt_type_code, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks, remarks, policy_type_code, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_id, non_ins_cust_code, annual_family_income, family_assets_value, num_of_dependents,      resp_for_bill_payment,GL_HOLDER_NAME,PAT_RELN_WITH_GL_HOLDER,to_char(CREDIT_DOC_REF_START_DATE, 'dd/mm/yyyy') CREDIT_DOC_REF_START_DATE from bl_patient_fin_dtls where patient_id='"+patient_id+"'";

			try
			{
				String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg from bl_mp_param ";
				pstmt = con.prepareStatement(sql0);
				rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{
					while( rs2.next() )
					{  
						strdfltbgyn = rs2.getString("bg");
					}
				}
				if (rs2 != null)   rs2.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in sql0:"+e);
			}
		
			sql="select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id ='"+patient_id+"'";
		
			try
			{
					String sql_ins="SELECT a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_date,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id FROM bl_ins_track_dtls a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type='"+episode_type+"' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND  a.priority is not NULL ORDER BY 2";

//							System.out.println("sql_ins:"+sql_ins);

							try
							{
								pstmt1 = con.prepareStatement(sql_ins);
								rs1 = pstmt1.executeQuery() ;
								if( rs1 != null ) 
								{
									while( rs1.next() )
									{  
//										System.out.println("Inside Ins Query");
										
										temp_ins_cust_code=rs1.getString("cust_code");
										if(temp_ins_cust_code==null || temp_ins_cust_code.equals("")) temp_ins_cust_code=" ";
										rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
										if(rtn_ins_cust_code==null) rtn_ins_cust_code="";
										
										temp_ins_cust_priority=rs1.getString("priority");
										if(temp_ins_cust_priority==null || temp_ins_cust_priority.equals("")) temp_ins_cust_priority=" ";
										rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
										if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
										
										temp_ins_policy_type_code=rs1.getString("policy_type_code");
										if(temp_ins_policy_type_code==null || temp_ins_policy_type_code.equals("")) temp_ins_policy_type_code=" ";
										rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
										if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";
										
										temp_ins_policy_no=rs1.getString("policy_number");
										if(temp_ins_policy_no==null || temp_ins_policy_no.equals("")) temp_ins_policy_no=" ";
										rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
										if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
										
										temp_ins_policy_start_date=rs1.getString("policy_start_date");
										if(temp_ins_policy_start_date==null || temp_ins_policy_start_date.equals("")) temp_ins_policy_start_date=" ";
										rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
										if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
										
										temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
										if(temp_ins_policy_expiry_date==null || temp_ins_policy_expiry_date.equals("")) temp_ins_policy_expiry_date=" ";
										rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
										if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
										
										temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
										if(temp_ins_credit_auth_ref==null || temp_ins_credit_auth_ref.equals("")) temp_ins_credit_auth_ref=" ";
										rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
										if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
										
										temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
										if(temp_ins_credit_auth_date==null || temp_ins_credit_auth_date.equals("")) temp_ins_credit_auth_date=" ";
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
										if(temp_ins_policy_eff_from_date==null || temp_ins_policy_eff_from_date.equals("")) temp_ins_policy_eff_from_date=" ";
										rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
										if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
										
										temp_ins_policy_eff_to_date=rs1.getString("effective_to");
										if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
										rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
										if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";
										
										temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
										if(temp_ins_adj_rule_ind==null || temp_ins_adj_rule_ind.equals("")) temp_ins_adj_rule_ind=" ";
										rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
										if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
										
										temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
										if(temp_ins_adj_perc_amt_ind==null || temp_ins_adj_perc_amt_ind.equals("")) temp_ins_adj_perc_amt_ind=" ";
										rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
										if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
										
										temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
										if(temp_ins_adj_perc_amt_value==null || temp_ins_adj_perc_amt_value.equals("")) temp_ins_adj_perc_amt_value=" ";
	//									System.out.println("temp_ins_adj_perc_amt_value:"+temp_ins_adj_perc_amt_value);
										rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
										if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
										
										temp_ins_pmnt_diff_adj_int=rs1.getString("pmnt_diff_adj_int");
										if(temp_ins_pmnt_diff_adj_int==null || temp_ins_pmnt_diff_adj_int.equals("")) temp_ins_pmnt_diff_adj_int=" ";
										rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+temp_ins_pmnt_diff_adj_int+"|";
										if(rtn_ins_pmnt_diff_adj_int==null) rtn_ins_pmnt_diff_adj_int="";
										
										temp_ins_drg_pmnt_diff_adj_int=rs1.getString("drg_pmnt_diff_adj_int");
										if(temp_ins_drg_pmnt_diff_adj_int==null || temp_ins_drg_pmnt_diff_adj_int.equals("")) temp_ins_drg_pmnt_diff_adj_int=" ";
										rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+temp_ins_drg_pmnt_diff_adj_int+"|";
										if(rtn_ins_drg_pmnt_diff_adj_int==null) rtn_ins_drg_pmnt_diff_adj_int="";
										
										temp_ins_spl_srv_pmnt_diff_adj_int=rs1.getString("spl_srv_pmnt_diff_adj_int");
										if(temp_ins_spl_srv_pmnt_diff_adj_int==null || temp_ins_spl_srv_pmnt_diff_adj_int.equals("")) temp_ins_spl_srv_pmnt_diff_adj_int=" ";									rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+temp_ins_spl_srv_pmnt_diff_adj_int+"|";
										if(rtn_ins_spl_srv_pmnt_diff_adj_int==null) rtn_ins_spl_srv_pmnt_diff_adj_int="";

										temp_ins_blng_grp=rs1.getString("blng_grp_id");
										if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
										if(temp_ins_cust_priority.equals("1"))
										{
											rtn_blng_grp=temp_ins_blng_grp;
	//										System.out.println("rtn_blng_grp:"+rtn_blng_grp);
										}
										rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
	//									System.out.println("rtn_ins_blng_grp:"+rtn_ins_blng_grp);

									}
								}
							
							}
							catch(Exception e)
							{
							}
							if (rs1 != null)   rs1.close();
							pstmt1.close();

			}
			catch(Exception e){}
			pstmt.close();
		
		
		billing_mode=billing_mode.trim();

		HashMap tabdata = new HashMap();
		tabdata.put("blng_grp",rtn_blng_grp);
		tabdata.put("slmt_ind",rtn_slmt_ind);
		tabdata.put("credit_doc_reqd_yn",rtn_credit_doc_reqd_yn);
		tabdata.put("blng_class",rtn_blng_class_code);
		tabdata.put("emp_code",rtn_employer_code);
		tabdata.put("slmt_type_code",rtn_slmt_type_code);
		tabdata.put("inst_ref",rtn_inst_ref);
		tabdata.put("inst_date",rtn_inst_date);
		tabdata.put("inst_remarks",rtn_inst_remarks);

		tabdata.put("credit_cust_code",rtn_credit_cust_code);
		tabdata.put("credit_doc_ref",rtn_credit_doc_ref);
		tabdata.put("credit_doc_start_date",rtn_credit_doc_start_date);
		tabdata.put("credit_doc_end_date",rtn_credit_doc_end_date);

		tabdata.put("sponsor_cust_code",rtn_sponsor_cust_code);
		tabdata.put("sponsor_credit_doc_ref",rtn_sponsor_credit_doc_ref);
		tabdata.put("sponsor_credit_doc_start_date",rtn_sponsor_credit_doc_start_date);
		tabdata.put("sponsor_credit_doc_end_date",rtn_sponsor_credit_doc_end_date);

		tabdata.put("ins_blng_grp",rtn_ins_blng_grp);
		tabdata.put("ins_cust_code",rtn_ins_cust_code);
		tabdata.put("ins_cust_priority",rtn_ins_cust_priority);
		tabdata.put("ins_policy_type_code",rtn_ins_policy_type_code);
		tabdata.put("ins_policy_no",rtn_ins_policy_no);
		tabdata.put("ins_policy_start_date",rtn_ins_policy_start_date);
		tabdata.put("ins_policy_expiry_date",rtn_ins_policy_expiry_date);
		tabdata.put("ins_credit_auth_ref",rtn_ins_credit_auth_ref);
		tabdata.put("ins_credit_auth_date",rtn_ins_credit_auth_date);
		tabdata.put("ins_credit_approval_days",rtn_ins_credit_approval_days);
		tabdata.put("ins_credit_approval_amount",rtn_ins_credit_approval_amount);
		tabdata.put("ins_policy_eff_from_date",rtn_ins_policy_eff_from_date);
		tabdata.put("ins_policy_eff_to_date",rtn_ins_policy_eff_to_date);
		tabdata.put("ins_adj_rule_ind",rtn_ins_adj_rule_ind);
		tabdata.put("ins_adj_perc_amt_ind",rtn_ins_adj_perc_amt_ind);
		tabdata.put("ins_adj_perc_amt_value",rtn_ins_adj_perc_amt_value);
		tabdata.put("ins_pmnt_diff_adj_int",rtn_ins_pmnt_diff_adj_int);
		tabdata.put("ins_drg_pmnt_diff_adj_int",rtn_ins_drg_pmnt_diff_adj_int);
		tabdata.put("ins_spl_srv_pmnt_diff_adj_int",rtn_ins_spl_srv_pmnt_diff_adj_int);
		tabdata.put("non_ins_blng_grp",rtn_non_ins_blng_grp);
		tabdata.put("non_ins_credit_doc_reqd_yn",rtn_non_ins_credit_doc_reqd_yn);
		tabdata.put("non_ins_slmt_type_code",rtn_non_ins_slmt_type_code);
		tabdata.put("non_ins_inst_ref",rtn_non_ins_inst_ref);
		tabdata.put("non_ins_inst_date",rtn_non_ins_inst_date);
		tabdata.put("non_ins_inst_remarks",rtn_non_ins_inst_remarks);
		tabdata.put("non_ins_cust_code",rtn_non_ins_cust_code);
		tabdata.put("non_ins_credit_doc_ref",rtn_non_ins_credit_doc_ref);
		tabdata.put("non_ins_credit_doc_start_date",rtn_non_ins_credit_doc_start_date);
		tabdata.put("non_ins_credit_doc_end_date",rtn_non_ins_credit_doc_end_date);

		tabdata.put("annual_income",rtn_annual_family_income);
		tabdata.put("family_asset",rtn_family_assets_value);
		tabdata.put("no_of_dependants",rtn_num_of_dependents);
		tabdata.put("resp_for_payment",rtn_resp_for_bill_payment);
		tabdata.put("pat_reln_with_resp_person",rtn_pat_reln_with_resp_pers);
		tabdata.put("fin_remarks",rtn_remarks);
		tabdata.put("gl_holder_name",rtn_gl_holder_name);
		tabdata.put("pat_reln_with_gl_holder",rtn_pat_reln_with_gl_holder);
		tabdata.put("upd_patient_fin_dtls_yn",upd_fin_dtls);
		tabdata.put("user_id",user_id);
//		System.out.println("tabdata values in change patient:"+tabdata);

		
		session.setAttribute("financial_details",tabdata);
//		System.out.println("financial_details in BLTest.jsp:"+session.getAttribute("financial_details"));


//		The following 2 lines are added for the OP & AE module purpose.To nullify the session everytime the patient_id is loaded
//		System.out.println("Session Values Reset in BLFinDetHiddenFlds.jsp");
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
		
 <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
  
<input type='hidden' name='billing_group' id='billing_group' value='<%=rtn_blng_grp%>'></input>
<input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
<input type='hidden' name='bl_operation' id='bl_operation' value='<%=operation%>'></input>

<!--
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'></input>

<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'></input>
<input type='hidden' name='last_visit_dtls' id='last_visit_dtls' value='<%=last_visit_dtls%>'></input>
-->
</body>


<% 
	}
	catch(Exception e)
	{ 
		out.println(e);
	} 
	finally
	{
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if(pstmt2 != null) pstmt2.close();

		ConnectionManager.returnConnection(con,request);
	}
%> 

<script>
window.close();
</script>
</html>

