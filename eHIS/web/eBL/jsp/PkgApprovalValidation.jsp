<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;

	try 
	{
		request.setCharacterEncoding("UTF-8");

		String locale			= (String)session.getAttribute("LOCALE");
		//String facility_id			= (String)session.getAttribute("facility_id");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash					= (Hashtable)hash.get( "SEARCH" ) ;	
		bean.setLanguageId(locale);		
		String	func_mode	= request.getParameter( "func_mode" );	
		String	form_name	= (String) hash.get( "form_name" );		
	
		if(func_mode != null && func_mode.equals("saveToBean" ) )
		{
			ArrayList payer=new ArrayList();
			payer=(ArrayList)bean.getDetails();
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			if(payer!=null && payer.size()>0){
				hdrDtls=	(HashMap)payer.get(0);
				authDtls=	(HashMap)payer.get(1);
				pkgApprovals=	(HashMap)payer.get(2);
			}
			if(form_name != null && form_name.equals("PkgDtls" ) )
			{
				//String	credit_auth_ref		= (String)hash.get( "credit_auth_ref" );	
				String	appr_seq_no		= (String)hash.get( "appr_seq_no" );	
			/*	if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
				if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				*/ //commented for IN 20964
				if(appr_seq_no!=null && !appr_seq_no.equals(""))// changed for IN 20964
				appr_seq_no=appr_seq_no.trim();// changed for IN 20964
				if(appr_seq_no!=null && !appr_seq_no.equals(""))// changed for IN 20964
				{
					ArrayList  creditPkgApprovals=new ArrayList();
					String	total_records		=	(String) hash.get( "total_records" );
					ArrayList record;
					int totalRec				=	Integer.parseInt(total_records);
					String pkg_code = "";
					for(int i=0;i<totalRec; i++)
					{
					   pkg_code = (String) hash.get( "pkg_code"+i );
					   if(pkg_code!=null && !pkg_code.equals(""))
					   {
							record=new ArrayList();
							record.add((String)hash.get( "pkg_seq_no"+i ));
							record.add((String)hash.get( "pkg_code"+i ));
							record.add((String)hash.get( "pkg_desc"+i ));
							record.add((String)hash.get( "aprv_amt"+i ));
							record.add((String)hash.get( "pkg_disc_type"+i ));
							record.add((String)hash.get( "pkg_disc_amt"+i ));
							record.add((String)hash.get( "pkg_disc_reason"+i ));
							record.add((String)hash.get( "pkg_disc_reason_desc"+i ));
							creditPkgApprovals.add(record);
							record=null;	
					   }
					}
			//		if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(credit_auth_ref))// commented for IN 20964
					if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(appr_seq_no))// changed for IN 20964
					{
						//pkgApprovals.remove(credit_auth_ref);// commented for IN 20964
						pkgApprovals.remove(appr_seq_no);// changed for IN 20964
					}
				//	pkgApprovals.put(credit_auth_ref,creditPkgApprovals);// commented for IN 20964
					pkgApprovals.put(appr_seq_no,creditPkgApprovals);// commented for IN 20964

					payer=new ArrayList();
					payer.add(hdrDtls);
					payer.add(authDtls);
					payer.add(pkgApprovals);
					bean.setDetails(payer);
				}
			}
			else if(form_name != null && form_name.equals("PayerDtls" ) )
			{
				authDtls=new HashMap();
				String	total_records		=	(String) hash.get( "total_records" );
				ArrayList record;
				int totalRec				=	Integer.parseInt(total_records);
				String appr_seq_no = "";// added for IN 20964
				String credit_apprd_amt = "";// added for IN 20964
	
				for(int i=0;i<totalRec; i++)
				{
					appr_seq_no = (String) hash.get( "appr_seq_no"+i );
					if(appr_seq_no!=null && !appr_seq_no.equals(""))
						appr_seq_no=appr_seq_no.trim();
					credit_apprd_amt = (String) hash.get( "credit_apprd_amt"+i );
					if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
						credit_apprd_amt=credit_apprd_amt.trim();
				   if(appr_seq_no!=null && !appr_seq_no.equals("") && credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				   {
						/** addded for IN 20964***end****/
						record=new ArrayList();
						record.add((String)hash.get( "appr_seq_no"+i ));// added for IN 20964
						record.add((String)hash.get( "credit_auth_ref"+i ));
						record.add((String)hash.get( "credit_auth_date"+i ));
						record.add(credit_apprd_amt);
						record.add((String)hash.get( "credit_apprd_days"+i ));
						record.add((String)hash.get( "pkg_dtls_yn"+i ));
						record.add((String)hash.get( "pol_validity_chk_date"+i ));
						//if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(credit_auth_ref))// commented for IN 20964
						if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))// changed for IN 20964
						{	
							//authDtls.remove(credit_auth_ref);// commented for IN 20964
							authDtls.remove(appr_seq_no);// changed for IN 20964
						}
						//authDtls.put(credit_auth_ref,record);		// commented for IN 20964	
						authDtls.put(appr_seq_no,record);		// commented for IN 20964	
						record=null;				
				   }	
				}
				payer=new ArrayList();
				payer.add(hdrDtls);
				payer.add(authDtls);
				payer.add(pkgApprovals);
				bean.setDetails(payer);		
			}	
		}	
		else if(func_mode != null && func_mode.equals("removeFromBean" ) )
		{
			String	blng_grp_code	= (String) hash.get( "blng_grp_code" );	
			String	payer_grp_code	= (String) hash.get( "payer_grp_code" );	
			String	payer_code	= (String) hash.get( "payer_code" );	
			String	policy_type_code	= (String) hash.get( "policy_type_code" );	
			String	policy_no	= (String) hash.get( "policy_no" );	
			String	policy_eff_frm_date	= (String) hash.get( "policy_eff_frm_date" );	
			String	priority	= (String) hash.get( "priority" );	
			String mapKey=blng_grp_code.trim()+"~~"+payer_grp_code.trim()+"~~"+payer_code.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
			ArrayList payer=new ArrayList();		
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			String	appr_seq_no		= (String) hash.get( "appr_seq_no" );	//added for IN 20964
			
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();//added for IN 20964
			if(appr_seq_no==null || appr_seq_no.equals(""))//changed for  IN 20964
			{
				if(payerDtls!=null && (payerDtls.size()>0) && payerDtls.containsKey(mapKey))		
					payerDtls.remove(mapKey);	
				bean.setPayerDtls(payerDtls);
			}
			else
			{		
				payer=(ArrayList)bean.getDetails();
				if(payer!=null && payer.size()>0)
				{
					hdrDtls=	(HashMap)payer.get(0);
					authDtls=	(HashMap)payer.get(1);
					pkgApprovals=	(HashMap)payer.get(2);
				}		
				if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
				{
					authDtls.remove(appr_seq_no);////changed for  IN 20964
				}	
				if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(appr_seq_no))//changed for  IN 20964
				{
					pkgApprovals.remove(appr_seq_no);//changed for  IN 20964
				}			
				payer=new ArrayList();
				payer.add(hdrDtls);
				payer.add(authDtls);
				payer.add(pkgApprovals);				
				bean.setDetails(payer);
			}				
		}
		else if(func_mode != null && func_mode.equals("renameBeanKey" ) )
		{
			String	oldMapKey	= (String) hash.get( "oldMapKey" );	
			String	currMapKey	= (String) hash.get( "currMapKey" );			
			ArrayList payer=new ArrayList();
			if(!oldMapKey.equals(currMapKey))
			{	
				HashMap payerDtls=(HashMap)bean.getPayerDtls();
				if(payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(oldMapKey))
				{	
					payer=(ArrayList)payerDtls.get(oldMapKey);			
					payerDtls.put(currMapKey,payer);
					payerDtls.remove(oldMapKey);
				}
				bean.setPayerDtls(payerDtls);
			}
		}
		else if(func_mode!= null && func_mode.equals("hdrVals"))//Function called while clicking accept button inside Add,modify payer in FInancial Details tab
		{
			String 	appr_seq_no=(String)hash.get( "appr_seq_no" );
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();
			String 	credit_auth_ref=(String)hash.get( "credit_auth_ref" );
			if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
			String 	credit_apprd_amt=(String)hash.get( "credit_apprd_amt" );
			if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				credit_apprd_amt=credit_apprd_amt.trim();
			String apprd_amt_restrict_check =(String)hash.get( "apprd_amt_restrict_check" );
			if(apprd_amt_restrict_check!=null && !apprd_amt_restrict_check.equals(""))
				apprd_amt_restrict_check=apprd_amt_restrict_check.trim();
			
			if((credit_apprd_amt!=null && !credit_apprd_amt.equals("") && apprd_amt_restrict_check.equals("R")) || (credit_apprd_amt==null || credit_apprd_amt.equals("") && apprd_amt_restrict_check.equals("U")))
			{
				
				String mapKey=((String)hash.get( "blng_grp_code" )).trim()+"~~"+((String)hash.get( "ins_cust_group_code" )).trim()+"~~"+((String)hash.get( "cust_3" )).trim()+"~~"+((String)hash.get( "priority" )).trim()+"~~"+((String)hash.get( "policy_type_code" )).trim()+"~~"+((String)hash.get( "policy_no" )).trim()+"~~"+((String)hash.get( "policy_eff_frm_date" )).trim();
				HashMap payerDtls=(HashMap)bean.getPayerDtls();
				ArrayList payer=new ArrayList();
				payer=(ArrayList)bean.getDetails();
				HashMap hdrDtls=new HashMap();
				HashMap authDtls=new HashMap();
				HashMap pkgApprovals=new HashMap();
				
				if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
					payer=(ArrayList)payerDtls.get(mapKey);
				if(payer!=null && payer.size()>0){
					hdrDtls=	(HashMap)payer.get(0);
					authDtls=	(HashMap)payer.get(1);
					pkgApprovals=	(HashMap)payer.get(2);
				}		
				HashMap hdrVals=new HashMap();
				ArrayList oldRecord=new ArrayList();	
				ArrayList record=new ArrayList();	
				hdrVals.put("billing_group_desc",(String)hash.get( "billing_group_desc" ));
				hdrVals.put("blng_grp_code",(String)hash.get( "blng_grp_code" ));
				hdrVals.put("payer_desc",(String)hash.get( "payer_desc" ));
				hdrVals.put("cust_3",(String)hash.get( "cust_3" ));
				hdrVals.put("priority",(String)hash.get( "priority" ));
				hdrVals.put("policy_type_desc",(String)hash.get( "policy_type_desc" ));
				hdrVals.put("policy_type_code",(String)hash.get( "policy_type_code" ));
				hdrVals.put("policy_no",(String)hash.get( "policy_no" ));
				hdrVals.put("policy_start_date",(String)hash.get( "policy_start_date" ));
				hdrVals.put("policy_exp_date",(String)hash.get( "policy_exp_date" ));
				
				hdrVals.put("credit_auth_ref",credit_auth_ref);
				hdrVals.put("credit_auth_date",(String)hash.get( "credit_auth_date" ));
				hdrVals.put("credit_apprd_amt",(String)hash.get( "credit_apprd_amt" ));
				hdrVals.put("credit_apprd_days",(String)hash.get( "credit_apprd_days" ));
				hdrVals.put("policy_eff_frm_date",(String)hash.get( "policy_eff_frm_date" ));
				hdrVals.put("policy_eff_to_date",(String)hash.get( "policy_eff_to_date" ));
				hdrVals.put("adj_rule_ind",(String)hash.get( "adj_rule_ind" ));
				hdrVals.put("adj_perc_amt_ind",(String)hash.get( "adj_perc_amt_ind" ));
				hdrVals.put("adj_perc_amt_value",(String)hash.get( "adj_perc_amt_value" ));
				hdrVals.put("pmnt_diff_adj_int",(String)hash.get( "pmnt_diff_adj_int" ));
				hdrVals.put("drg_pmnt_diff_adj_int",(String)hash.get( "drg_pmnt_diff_adj_int" ));
				hdrVals.put("spl_srv_pmnt_diff_adj_int",(String)hash.get( "spl_srv_pmnt_diff_adj_int" ));
				hdrVals.put("restrict_check",(String)hash.get( "restrict_check" ));
				hdrVals.put("valid_payer_YN",(String)hash.get( "valid_payer_YN" ));
				hdrVals.put("valid_policy_type_code_YN",(String)hash.get( "valid_policy_type_code_YN" ));
				hdrVals.put("ins_cust_group_code",(String)hash.get( "ins_cust_group_code" ));
				hdrVals.put("policy_coverage_basis_ind",(String)hash.get( "policy_coverage_basis_ind" ));
				hdrVals.put("referral_source_main_code",(String)hash.get( "referral_source_main_code" ));
				hdrVals.put("referral_source_main_desc",(String)hash.get( "referral_source_main_desc" ));
				hdrVals.put("referral_source_sub_code",(String)hash.get( "referral_source_sub_code" ));
				hdrVals.put("referral_source_sub_desc",(String)hash.get( "referral_source_sub_desc" ));
				hdrVals.put("apprd_amt_restrict_check",(String)hash.get( "apprd_amt_restrict_check" ));
				hdrVals.put("apprd_days_restrict_check",(String)hash.get( "apprd_days_restrict_check" ));
				hdrVals.put("cred_auth_req_yn",(String)hash.get( "cred_auth_req_yn" ));
				hdrVals.put("dflt_auth_ref_as_pol_no_yn",(String)hash.get( "dflt_auth_ref_as_pol_no_yn" ));
				hdrVals.put("cust_valid_from_date",(String)hash.get( "cust_valid_from_date" ));
				hdrVals.put("cust_valid_to_date",(String)hash.get( "cust_valid_to_date" ));
				hdrVals.put("ins_cust_group_name",(String)hash.get( "ins_cust_group_name" ));
				hdrVals.put("pol_validity_chk_date",(String)hash.get( "pol_validity_chk_date" ));
				//Added by prithivi on 08/12/2016 for MMS-QH-CRF-0085 - 9 values
				hdrVals.put("response_code",(String)hash.get( "response_code" ));
				hdrVals.put("status_description",(String)hash.get( "status_description" ));	
				hdrVals.put("validity_period",(String)hash.get( "validity_period" ));	
				hdrVals.put("eligibility_code",(String)hash.get( "eligibility_code" ));	
				hdrVals.put("transaction_id",(String)hash.get( "transaction_id" ));	
				hdrVals.put("response_date_time",(String)hash.get( "response_date_time" ));
				hdrVals.put("errorMsg",(String)hash.get( "errorMsg" ));
				hdrVals.put("remarks",(String)hash.get( "remarks" ));
				hdrVals.put("validity_until",(String)hash.get( "validity_until" ));
				System.out.println("PkgApprovalValidation.jsp:::response code..."+(String)hash.get( "response_code" ));
				System.out.println("PkgApprovalValidation.jsp:::status_description..."+(String)hash.get( "status_description" ));
				System.out.println("PkgApprovalValidation.jsp:::validity_until..."+(String)hash.get( "validity_until" ));
				//above fields are Added by prithivi on 08/12/2016 for MMS-QH-CRF-0085
				 if((authDtls==null || authDtls.size()==0) && (pkgApprovals==null || pkgApprovals.size()==0) )	{
					record=new ArrayList();
					record.add(appr_seq_no);// added for IN 20964
					record.add(credit_auth_ref);
					record.add((String)hash.get( "credit_auth_date" ));
					record.add(credit_apprd_amt);
					record.add((String)hash.get( "credit_apprd_days" ));
					record.add( "N" );
					record.add((String)hash.get( "pol_validity_chk_date" ));	
					//authDtls.put(credit_auth_ref,record);
					authDtls.put(appr_seq_no,record);// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				 }
				 else if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
				 {// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
					record=new ArrayList();	
					oldRecord=new ArrayList();	
					oldRecord=(ArrayList)authDtls.get((String)hash.get( "appr_seq_no" ));// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
					record.add(appr_seq_no);// added for IN 20964
					record.add(credit_auth_ref);
					record.add((String)hash.get( "credit_auth_date" ));
					record.add(credit_apprd_amt);
					record.add((String)hash.get( "credit_apprd_days" ));
					record.add((String)oldRecord.get(5));	
					record.add((String)hash.get( "pol_validity_chk_date" ));	
					//authDtls.remove(credit_auth_ref);// commented for IN 20964
					authDtls.remove(appr_seq_no);// added for IN 20964
				//	authDtls.put(credit_auth_ref,record);		// commented for IN 20964		
					authDtls.put(appr_seq_no,record);		// commented for IN 20964		
				 }
				payer=new ArrayList();
				payer.add(hdrVals);
				payer.add(authDtls);
				payer.add(pkgApprovals);
				bean.setDetails(payer);		
				bean.saveDetails(mapKey);
						
			}
			
		}
		else if(func_mode!= null && func_mode.equals("nonInsHdrVals"))
		{
			String 	appr_seq_no=(String)hash.get( "appr_seq_no" );
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();
			String 	credit_auth_ref=(String)hash.get( "credit_auth_ref" );
			if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
			String 	credit_apprd_amt=(String)hash.get( "credit_apprd_amt" );
			if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				credit_apprd_amt=credit_apprd_amt.trim();
			
			String mapKey=((String)hash.get( "blng_grp_code" )).trim()+"~~"+((String)hash.get( "cust_group_code" )).trim()+"~~"+((String)hash.get( "cust_3" )).trim();
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
			ArrayList payer=new ArrayList();
			payer=(ArrayList)bean.getDetails();
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			
			if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
				payer=(ArrayList)payerDtls.get(mapKey);
			if(payer!=null && payer.size()>0)
			{
				hdrDtls=	(HashMap)payer.get(0);
				authDtls=	(HashMap)payer.get(1);
				pkgApprovals=	(HashMap)payer.get(2);
			}		
			HashMap hdrVals=new HashMap();
			ArrayList oldRecord=new ArrayList();	
			ArrayList record=new ArrayList();	
	//		hdrVals.put("billing_group_desc",(String)hash.get( "billing_group_desc" ));
			hdrVals.put("blng_grp_code",(String)hash.get( "blng_grp_code" ));
	//		hdrVals.put("payer_desc",(String)hash.get( "payer_desc" ));
			hdrVals.put("cust_3",(String)hash.get( "cust_3" ));
	//		hdrVals.put("priority",(String)hash.get( "priority" ));
	//		hdrVals.put("policy_type_desc",(String)hash.get( "policy_type_desc" ));
	//		hdrVals.put("policy_type_code",(String)hash.get( "policy_type_code" ));
	//		hdrVals.put("policy_no",(String)hash.get( "policy_no" ));
	//		hdrVals.put("policy_start_date",(String)hash.get( "policy_start_date" ));
	//		hdrVals.put("policy_exp_date",(String)hash.get( "policy_exp_date" ));
			
	//		hdrVals.put("credit_auth_ref",credit_auth_ref);
	//		hdrVals.put("credit_auth_date",(String)hash.get( "credit_auth_date" ));
	//		hdrVals.put("credit_apprd_amt",(String)hash.get( "credit_apprd_amt" ));
	//		hdrVals.put("credit_apprd_days",(String)hash.get( "credit_apprd_days" ));
	//		hdrVals.put("policy_eff_frm_date",(String)hash.get( "policy_eff_frm_date" ));
	//		hdrVals.put("policy_eff_to_date",(String)hash.get( "policy_eff_to_date" ));
	//		hdrVals.put("adj_rule_ind",(String)hash.get( "adj_rule_ind" ));
	//		hdrVals.put("adj_perc_amt_ind",(String)hash.get( "adj_perc_amt_ind" ));
	//		hdrVals.put("adj_perc_amt_value",(String)hash.get( "adj_perc_amt_value" ));
	//		hdrVals.put("pmnt_diff_adj_int",(String)hash.get( "pmnt_diff_adj_int" ));
	//		hdrVals.put("drg_pmnt_diff_adj_int",(String)hash.get( "drg_pmnt_diff_adj_int" ));
	//		hdrVals.put("spl_srv_pmnt_diff_adj_int",(String)hash.get( "spl_srv_pmnt_diff_adj_int" ));
	//		hdrVals.put("restrict_check",(String)hash.get( "restrict_check" ));
	//		hdrVals.put("valid_payer_YN",(String)hash.get( "valid_payer_YN" ));
	//		hdrVals.put("valid_policy_type_code_YN",(String)hash.get( "valid_policy_type_code_YN" ));
			hdrVals.put("ins_cust_group_code",(String)hash.get( "cust_group_code" ));
	//		hdrVals.put("policy_coverage_basis_ind",(String)hash.get( "policy_coverage_basis_ind" ));
	//		hdrVals.put("referral_source_main_code",(String)hash.get( "referral_source_main_code" ));
	//		hdrVals.put("referral_source_main_desc",(String)hash.get( "referral_source_main_desc" ));
	//		hdrVals.put("referral_source_sub_code",(String)hash.get( "referral_source_sub_code" ));
	//		hdrVals.put("referral_source_sub_desc",(String)hash.get( "referral_source_sub_desc" ));
	//		hdrVals.put("apprd_amt_restrict_check",(String)hash.get( "apprd_amt_restrict_check" ));
	//		hdrVals.put("apprd_days_restrict_check",(String)hash.get( "apprd_days_restrict_check" ));
	//		hdrVals.put("cred_auth_req_yn",(String)hash.get( "cred_auth_req_yn" ));
	//		hdrVals.put("dflt_auth_ref_as_pol_no_yn",(String)hash.get( "dflt_auth_ref_as_pol_no_yn" ));
	//		hdrVals.put("cust_valid_from_date",(String)hash.get( "cust_valid_from_date" ));
	//		hdrVals.put("cust_valid_to_date",(String)hash.get( "cust_valid_to_date" ));
	//		hdrVals.put("ins_cust_group_name",(String)hash.get( "ins_cust_group_name" ));
	//		hdrVals.put("pol_validity_chk_date",(String)hash.get( "pol_validity_chk_date" ));	
	/*		 if((authDtls==null || authDtls.size()==0) && (pkgApprovals==null || pkgApprovals.size()==0) )	{
				record=new ArrayList();
				record.add(appr_seq_no);// added for IN 20964
				record.add(credit_auth_ref);
				record.add((String)hash.get( "credit_auth_date" ));
				record.add(credit_apprd_amt);
				record.add((String)hash.get( "credit_apprd_days" ));
				record.add( "N" );
				record.add((String)hash.get( "pol_validity_chk_date" ));	
				//authDtls.put(credit_auth_ref,record);
				authDtls.put(appr_seq_no,record);// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
			 }
			 else if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
			 {// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				record=new ArrayList();	
				oldRecord=new ArrayList();	
				oldRecord=(ArrayList)authDtls.get((String)hash.get( "appr_seq_no" ));// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				record.add(appr_seq_no);// added for IN 20964
				record.add(credit_auth_ref);
				record.add((String)hash.get( "credit_auth_date" ));
				record.add(credit_apprd_amt);
				record.add((String)hash.get( "credit_apprd_days" ));
				record.add((String)oldRecord.get(5));	
				record.add((String)hash.get( "pol_validity_chk_date" ));	
				//authDtls.remove(credit_auth_ref);// commented for IN 20964
				authDtls.remove(appr_seq_no);// added for IN 20964
			//	authDtls.put(credit_auth_ref,record);		// commented for IN 20964		
				authDtls.put(appr_seq_no,record);		// commented for IN 20964		
			 }
	*/
			payer=new ArrayList();
			payer.add(hdrVals);
			payer.add(authDtls);
			payer.add(pkgApprovals);
			bean.setDetails(payer);		
			bean.saveDetails(mapKey);
		}
		else if(func_mode!= null && func_mode.equals("dupChk"))
		{  		
			ArrayList codes     = new ArrayList();
			int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
			int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
	
			String item	= (String) hash.get( "item" );	
			for(int i=0;i<totRec; i++)
			{
				if(i!=index)
				codes.add((String) hash.get( "code_"+i ));
			}
		
			if(codes.contains(item))
				out.println("duplicateAlert('"+index+"','"+form_name+"')");
		}
		else if(func_mode != null && func_mode.equals("claimCreditMapSession" ) )
		{
			// Karthik added the code to add claim code starts  - IN50355
			HashMap<String,String> claimCreditMap=( session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null ? new HashMap<String,String>(): (HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION") );
			claimCreditMap.put((String)hash.get( "priority" ), (String)hash.get( "claim_code" ) +"~" + (String)hash.get( "credit_authorisation_by" ) +"~" + (String)hash.get( "membershipId")+"~" + (String)hash.get( "policy_no"));
			session.setAttribute("CLAIM_CREDIT_MAP_SESSION",claimCreditMap);
			// Karthik added the code to add claim code starts  - IN50355
		
		}
		else if(func_mode != null && func_mode.equals("clearBean" ) )
		{
			bean.clearBean();
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace() ;
		System.out.println("Exception from PkgApprovalValidation :"+e);
	}
	putObjectInBean(bean_id,bean,request);
%>

