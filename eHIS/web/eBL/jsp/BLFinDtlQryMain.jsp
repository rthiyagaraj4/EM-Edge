<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = ""; 
	String login_user = ""; 
	String strSetInd = ""; 
	String strAdmFlag = "";
	String strFamIn = ""; 
	String strFamAss  = ""; 	
//	String strNoDep = ""; 	
	String strNonInsBlGrId = "";
	String strNonInsCustGroupCode = ""; 
	String strNonInsCustCode = ""; 
	String strGLHol  = ""; 
	String strPatRel  = ""; 
	String strBillGrp = "";
	String strBillGrpId = "";
	String strPatRelGL = ""; 	
	String strCrdDocRef = ""; 	
	String strCrDocRefStDate = ""; 
	String strCrDocRefEndDate = ""; 
	String strResPay  = ""; 
	String strPatRelnRespPers="";	  	
	String strAllParam="";	 
	String strepisodetype=""; 
	String strepisodeid=""; 	
	String strvisitid="";
	String strpatientid=""; 
	String strslmttypecode="";	String patln="";
	String strcustgroupcode ="";
	String strcustcode ="";
	String strCurrAcctSeqNo="";
	String episode_type_flag="";
	String strEncRegDate = "";
//	int intNoDep=0;
	String strNoDep="";
//	long intepisodeid=0;
//	int intvisitid=0;
	String str_valid_pkg_for_pat_avail_YN = "N", str_valid_pkg_for_pat_enc_avail_YN="N";
	
	String fin_class_flag_YN="N";
	String strClassType = "", strClassCode = "", strFinRemarks = "", strSocialPensionerId ="", strIncAssetInd = "";
	String strIndInc = "", strIndIncFreq = "", strSpouseInc = "", strSpouseIncFreq = "", strDepInc = "", strDepIncFreq = "";
	String strClassStartDate = "", strClassEndDate = "";
	String strClassFamIn="",strClassFamAss="";

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	CallableStatement call =null;

	String sql1=""; 
	String sql2=""; String sql3=""; String sql4="";
	String epitype="";
	String locale="";
	String title="";
	String encounter="";
	String ref_src_main_code="",ref_src_sub_code="";
	String non_ins_ref_src_main_code="",non_ins_ref_src_sub_code="";
	String referral_source_code_flag="N",non_ins_referral_source_code_flag="N";
	String strBlngGrpId="";

	request.setCharacterEncoding("UTF-8");

	try
	{
//		System.err.println("Query String in QryMain.jsp:"+request.getQueryString());
		con=ConnectionManager.getConnection(request);	
		
		facility_id = (String)httpSession.getValue("facility_id");

		locale	= (String)session.getAttribute("LOCALE");
		if(locale==null) locale="";

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

		title=(String)request.getParameter("title");
		if(title==null) title="";

		login_user =  p.getProperty("login_user");

//		strepisodetype = request.getParameter("episodetype");

		strepisodeid = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		strpatientid = request.getParameter("patientid");
		if(strpatientid==null)
		{ 
			strpatientid=request.getParameter("patient_id");
		}
		if(strpatientid==null) strpatientid="";
//		epitype = request.getParameter("episode1");
		
		strpatientid=strpatientid.trim();
//		strepisodetype=strepisodetype.trim();
		strepisodeid=strepisodeid.trim();
		strvisitid=strvisitid.trim();
//		System.err.println("strpatientid:"+strpatientid);
//		System.err.println("strepisodeid:"+strepisodeid);
//		System.err.println("strvisitid:"+strvisitid);
		if (!strpatientid.equals("") && strepisodeid.equals(""))
		{
			episode_type_flag="MP";
			strepisodetype="R";
		}
		else if(!strpatientid.equals("") && !strepisodeid .equals("") && !strvisitid .equals(""))
		{
			episode_type_flag="AEOP";
		}
		else if(!strpatientid.equals("") && !strepisodeid .equals("") && strvisitid .equals(""))
		{
			episode_type_flag="IPDC";
		}
//		System.err.println("episode_type_flag:"+episode_type_flag);
//		System.out.println("strpatientid:"+strpatientid);
//		System.out.println("episode_type_flag:"+episode_type_flag);
//		System.out.println("strepisodeid:"+strepisodeid);
//		System.out.println("strvisitid:"+strvisitid);
		
		try
		{
			try
			{
					call = con.prepareCall("{ ? = call  get_patient_line(?,?)}");	
					call.registerOutParameter(1,java.sql.Types.VARCHAR);
					call.setString(2,strpatientid);
					call.setString(3,locale);
					call.execute();				
			
					patln = call.getString(1);			
			
					call.close();	
					if ( patln == null ) patln = "";
					int ind=patln.indexOf("#");
					patln=patln.substring(0,ind);
			}
			catch(Exception e)
			{
		
			}
		
//			System.out.println("patln:"+patln);

			try
			{	
				
//				if(strepisodetype.equals("R")) 
				if(episode_type_flag.equals("MP")) 
				{ 
//					System.out.println("Inside MP Level");
					sql1 = "SELECT  b.long_desc billing_group,"+
							" b.settlement_ind settlement_ind,"+                     		
							" b.adm_rec_flag adm_rec_flag,"+
							" a.annual_family_income aannual_family_income,"+                  
							" a.family_assets_value family_assets_value,"+                  
							" a.num_of_dependents num_of_dependents,"+                  				
							" a.non_ins_blng_grp_id non_ins_blng_grp_id,"+                   		
							" a.non_ins_cust_code non_ins_cust_code,"+                			
							" a.gl_holder_name gl_holder_name,"+             
							" a.pat_reln_with_gl_holder pat_reln_with_gl_holder,"+                
							" a.credit_doc_ref_desc credit_doc_desc,"+      
							" TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date,"+              
							" TO_CHAR(a.credit_doc_ref_date ,'DD/MM/YYYY') credit_doc_end_date,"+               		
							" a.resp_for_bill_payment resp_for_bill_payment,"+             	
							" a.pat_reln_with_resp_pers pat_reln_with_resp_pers,"+ 
							" a.slmt_type_code, a.cust_code,"+	
							" a.CUR_ACCT_SEQ_NO cur_acct_seq_no,"+
							" a.cust_group_code,"+
							" a.non_ins_cust_group_code,"+
							" a.blng_grp_id,"+
							" to_char(c.REGN_DATE,'DD/MM/YYYY') REGN_DATE,"+
							" a.CLASSIFICATION_TYPE CLASSIFICATION_TYPE,"+
							" a.CLASSIFICATION_CODE CLASSIFICATION_CODE,"+
							" a.FINANCIAL_REMARKS FINANCIAL_REMARKS,"+
							" a.SOCIAL_PENSIONER_ID SOCIAL_PENSIONER_ID,"+
							" a.PATIENT_INC_ASSET_IND PATIENT_INC_ASSET_IND,"+
							" a.PATIENT_INC_ASSET_AMT PATIENT_INC_ASSET_AMT,"+
							" a.PATIENT_INC_ASSET_FREQ PATIENT_INC_ASSET_FREQ,"+
							" a.SPOUSE_INC_ASSET_AMT SPOUSE_INC_ASSET_AMT,"+ 
							" a.SPOUSE_INC_ASSET_FREQ SPOUSE_INC_ASSET_FREQ,"+
							" a.DEPENDENT_INC_ASSET_AMT DEPENDENT_INC_ASSET_AMT,"+      
							" a.DEPENDENT_INC_ASSET_FREQ DEPENDENT_INC_ASSET_FREQ,"+
							" to_char(a.CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,"+
							" to_char(a.CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE"+
							" FROM bl_patient_fin_dtls a,"+
							"  bl_blng_grp_lang_vw b,"+
							"  mp_patient c "+
							" WHERE a.patient_id = '"+strpatientid+"' "+
							" AND a.patient_id = c.patient_id "+
							" AND a.blng_grp_id = b.blng_grp_id "+
							" AND b.language_id = '"+locale+"'";
//					 System.err.println("sql1:"+sql1);
					 pstmt = con.prepareStatement(sql1);
					 rs = pstmt.executeQuery() ;
					
					 while(rs.next())
					 {			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);	
						strNoDep = rs.getString(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRel  = rs.getString(15);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
						strcustgroupcode = rs.getString(19);
						strNonInsCustGroupCode = rs.getString(20);
						strBillGrpId = rs.getString(21);
						strEncRegDate = rs.getString(22);
						strClassType = rs.getString(23);
						strClassCode = rs.getString(24);						
						strFinRemarks = rs.getString(25);
						strSocialPensionerId = rs.getString(26);
						strIncAssetInd = rs.getString(27);
						strIndInc = rs.getString(28);
						strIndIncFreq = rs.getString(29);
						strSpouseInc = rs.getString(30);
						strSpouseIncFreq = rs.getString(31);
						strDepInc = rs.getString(32);
						strDepIncFreq = rs.getString(33);
						strClassStartDate = rs.getString(34);
						strClassEndDate = rs.getString(35);
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}//closing if for episodetype "R"	
			}//closing try episodetype "R"
			catch(Exception e)
			{
				System.out.println("Exception in MP level Data Fetch:"+e.toString());
			}

			try
			{	
//			   if((strepisodetype.equals("O")) || (strepisodetype.equals("E"))) 
				if(episode_type_flag.equals("AEOP")) 
				{
//   					System.out.println("Inside OP r AE Level");
					sql2="SELECT  b.long_desc billing_group, "+
						" b.settlement_ind settlement_ind,     "+      		
						" b.adm_rec_flag adm_rec_flag,		"+
						" c.annual_family_income annual_family_income,  "+                 
						" c.family_assets_value family_assets_value,  "+             
						" a.num_of_dependents num_of_dependents,      "+         				
						" a.non_ins_blng_grp_id non_ins_blng_grp_id,  "+         		
						" a.non_ins_cust_code non_ins_cust_code,      "+     			
						" a.gl_holder_name gl_holder_name,            "+   
						" a.pat_reln_with_gl_holder pat_reln_with_gl_holder,   "+             
						" a.credit_doc_ref_desc credit_doc_desc,  "+        
						" TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date,  "+
						" TO_CHAR(a.credit_doc_ref_date,'DD/MM/YYYY') credit_doc_end_date,   "+         		
						" a.resp_for_bill_payment resp_for_bill_payment,        "+          	
						" a.pat_reln_with_resp_pers pat_reln_with_resp_pers,     "+   
						" a.slmt_type_code,a.cust_code, "+
						" a.CUR_ACCT_SEQ_NO cur_acct_seq_no, "+
						" a.EPISODE_TYPE episode_type, "+
						" a.cust_group_code, "+
						" a.non_ins_cust_group_code, "+
						" a.blng_grp_id, "+
						" to_char(d.VISIT_REGN_DATE_TIME,'DD/MM/YYYY') VISIT_REGN_DATE_TIME, "+
						" a.CLASSIFICATION_TYPE CLASSIFICATION_TYPE, "+
						" a.CLASSIFICATION_CODE CLASSIFICATION_CODE, "+
						" NULL FINANCIAL_REMARKS, "+
						" a.SOCIAL_PENSIONER_ID SOCIAL_PENSIONER_ID, "+
						" a.PATIENT_INC_ASSET_IND PATIENT_INC_ASSET_IND, "+
						" a.PATIENT_INC_ASSET_AMT PATIENT_INC_ASSET_AMT, "+
						" a.PATIENT_INC_ASSET_FREQ PATIENT_INC_ASSET_FREQ, "+
						" a.SPOUSE_INC_ASSET_AMT SPOUSE_INC_ASSET_AMT , "+ 
						" a.SPOUSE_INC_ASSET_FREQ SPOUSE_INC_ASSET_FREQ, "+
						" a.DEPENDENT_INC_ASSET_AMT DEPENDENT_INC_ASSET_AMT , "+      
						" a.DEPENDENT_INC_ASSET_FREQ DEPENDENT_INC_ASSET_FREQ, "+
						" to_char(a.CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE, "+
						" to_char(a.CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE, "+
						" a.annual_family_income annual_family_income,  "+                 
						" a.family_assets_value family_assets_value  "+         
						" FROM bl_visit_fin_dtls a, "+
						" bl_blng_grp_lang_vw b,   "+
						" bl_patient_fin_dtls c ,   "+
						" op_visit d    "+
						" WHERE a.operating_facility_id = '"+facility_id+"'  "+
//						" AND a.episode_type ='"+strepisodetype+"' "+
						" AND c.patient_id = '"+strpatientid+"'  "+
						" AND a.episode_id = '"+strepisodeid+"'	"+ 
						" AND a.visit_id = '"+strvisitid+"'	"+
						" AND a.episode_id = d.episode_id	"+
						" AND a.visit_id = d.visit_id	"+
						" AND a.blng_grp_id = b.blng_grp_id	"+
						" AND a.operating_facility_id = d.facility_id "+
						" AND b.language_id = '"+locale+"' ";
//					System.err.println("sql2:"+sql2);
					pstmt = con.prepareStatement(sql2);
					 rs = pstmt.executeQuery() ;
			
					while(rs.next())
					{			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);			 
						strNoDep = rs.getString(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
//						strPatRel  = rs.getString(15);			 	
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);			 
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
						strepisodetype=rs.getString(19);
						strcustgroupcode = rs.getString(20);
						strNonInsCustGroupCode = rs.getString(21);
						strBillGrpId = rs.getString(22);
						strEncRegDate = rs.getString(23);
						strClassType = rs.getString(24);
						strClassCode = rs.getString(25);						
						strFinRemarks = rs.getString(26);
						strSocialPensionerId = rs.getString(27);
						strIncAssetInd = rs.getString(28);
						strIndInc = rs.getString(29);
						strIndIncFreq = rs.getString(30);
						strSpouseInc = rs.getString(31);
						strSpouseIncFreq = rs.getString(32);
						strDepInc = rs.getString(33);
						strDepIncFreq = rs.getString(34);
						strClassStartDate = rs.getString(35);
						strClassEndDate = rs.getString(36);
						strClassFamIn = rs.getString(37);
						strClassFamAss = rs.getString(38);
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}//closing if for episodetype OE
			}//closing try episodetype OE
			catch(Exception e)
			{
				System.out.println("Exception in OP AE level Data Fetch:"+e.toString());
			}
			
			try
			{
//				if((strepisodetype.equals("D")) || (strepisodetype.equals("I")))
				if(episode_type_flag.equals("IPDC")) 
				{
//					System.out.println("Inside IP r AE Level");
					sql3="SELECT  b.long_desc billing_group,"+
			 			 " b.settlement_ind settlement_ind,             "+       		
			 			 " b.adm_rec_flag adm_rec_flag,	"+	
						 " c.annual_family_income annual_family_income,  "+                 
						 " c.family_assets_value family_assets_value,   "+                 
						 " a.num_of_dependents num_of_dependents,       "+               				
						 " a.non_ins_blng_grp_id non_ins_blng_grp_id,    "+                		
						 " a.non_ins_cust_code non_ins_cust_code,         "+             			
						 " a.gl_holder_name gl_holder_name,            "+             
						 " a.pat_reln_with_gl_holder pat_reln_with_gl_holder,"+                
						 " a.credit_doc_ref_desc credit_doc_desc,              "+      
						 " TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date,    "+           
						 " TO_CHAR(a.credit_doc_ref_date,'DD/MM/YYYY') credit_doc_end_date,     "+               		
						 " a.resp_for_bill_payment resp_for_bill_payment,    "+              	
						 " a.pat_reln_with_resp_pers pat_reln_with_resp_pers,   "+    
						 " a.slmt_type_code, a.cust_code, "+
						 " a.CUR_ACCT_SEQ_NO cur_acct_seq_no, "+
						 " a.EPISODE_TYPE episode_type, "+
						 " a.cust_group_code, "+
						 " a.non_ins_cust_group_code, "+
						 " a.blng_grp_id, "+
						 " to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY') ADMISSION_DATE_TIME, "+
						 " a.CLASSIFICATION_TYPE CLASSIFICATION_TYPE, "+
						 " a.CLASSIFICATION_CODE CLASSIFICATION_CODE, "+
						 " NULL FINANCIAL_REMARKS, "+
						 " a.SOCIAL_PENSIONER_ID SOCIAL_PENSIONER_ID, "+
						 " a.PATIENT_INC_ASSET_IND PATIENT_INC_ASSET_IND, "+
						 " a.PATIENT_INC_ASSET_AMT PATIENT_INC_ASSET_AMT, "+
						 " a.PATIENT_INC_ASSET_FREQ PATIENT_INC_ASSET_FREQ, "+
						 " a.SPOUSE_INC_ASSET_AMT SPOUSE_INC_ASSET_AMT , "+ 
						 " a.SPOUSE_INC_ASSET_FREQ SPOUSE_INC_ASSET_FREQ, "+
						 " a.DEPENDENT_INC_ASSET_AMT DEPENDENT_INC_ASSET_AMT, "+       
						 " a.DEPENDENT_INC_ASSET_FREQ DEPENDENT_INC_ASSET_FREQ, "+
						 " to_char(a.CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE, "+
						 " to_char(a.CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE, "+
						 " a.annual_family_income annual_family_income,  "+                 
						 " a.family_assets_value family_assets_value  "+         
					   	 " FROM bl_episode_fin_dtls a,"+
						 " bl_blng_grp_lang_vw b    ,"+
						 " bl_patient_fin_dtls c    "+
//						 " ip_episode d    "+
						 " WHERE a.operating_facility_id = '"+facility_id+"'  "+
//						 " AND a.episode_type = '"+strepisodetype+"'  "+
						 " AND c.patient_id = '"+strpatientid+"'  "+
						 " AND a.episode_id =  '"+strepisodeid+"'  "+
//						 " AND a.episode_id = d.episode_id	"+
						 " AND a.blng_grp_id = b.blng_grp_id  "+
//						 " AND a.operating_facility_id = d.facility_id  "+
						 " AND b.language_id = '"+locale+"' ";
//				System.out.println("sql3:"+sql3);
					pstmt = con.prepareStatement(sql3);
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);	
						strNoDep = rs.getString(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRel  = rs.getString(15);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
						strepisodetype=rs.getString(19);
						strcustgroupcode = rs.getString(20);
						strNonInsCustGroupCode = rs.getString(21);
						strBillGrpId = rs.getString(22);
						strEncRegDate = rs.getString(23);
						strClassType = rs.getString(24);
						strClassCode = rs.getString(25);						
						strFinRemarks = rs.getString(26);
						strSocialPensionerId = rs.getString(27);
						strIncAssetInd = rs.getString(28);
						strIndInc = rs.getString(29);
						strIndIncFreq = rs.getString(30);
						strSpouseInc = rs.getString(31);
						strSpouseIncFreq = rs.getString(32);
						strDepInc = rs.getString(33);
						strDepIncFreq = rs.getString(34);
						strClassStartDate = rs.getString(35);
						strClassEndDate = rs.getString(36);
						strClassFamIn = rs.getString(37);
						strClassFamAss = rs.getString(38);
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}//closing if for episodetype DI
			}//closing try episodetype DI
			catch(Exception e)
			{
				System.out.println("Exception in IP DC level Data Fetch:"+e.toString());
			}
		
			try
			{   
				sql4="select short_desc  from bl_slmt_type where slmt_type_code = '"+strslmttypecode+"' ";
			
				pstmt = con.prepareStatement(sql4);
				rs = pstmt.executeQuery() ;
				
				while(rs.next())
				{
					strslmttypecode=rs.getString(1);
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			catch(Exception e) 
			{
				System.out.println("3="+e.toString());
			}
		
//			System.out.println("strepisodetype:"+strepisodetype);

			if(strepisodetype.equals("O"))
			{
				epitype=(String) bl_labels.getString("Common.Outpatient.label");
				encounter = strepisodeid +  " / " + strvisitid + " / " + epitype;
			}
			else if(strepisodetype.equals("E"))
			{
				epitype=(String) bl_labels.getString("Common.emergency.label");
				encounter = strepisodeid +  " / " + strvisitid + " / " + epitype;
			}
			else if(strepisodetype.equals("I"))
			{
				epitype=(String) bl_labels.getString("Common.inpatient.label");
				encounter = strepisodeid +  " / " + epitype;
			}
			else if(strepisodetype.equals("D"))
			{
				epitype=(String) bl_labels.getString("Common.daycare.label");
				encounter = strepisodeid + " / " + epitype;
			}

			String ref_src_code_qry="";

			if(strepisodetype.equals("R"))
			{
				ref_src_code_qry = "select a.blng_grp_id BLNG_GRP_ID,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_MAIN,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_SUB,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_SUB from bl_patient_fin_dtls a, bl_blng_grp_lang_vw b  WHERE a.patient_id = '"+strpatientid+"' AND a.blng_grp_id = b.blng_grp_id  AND b.language_id = '"+locale+"'";
			}
			else if(strepisodetype.equals("O") || strepisodetype.equals("E"))
			{
				ref_src_code_qry = "select b.blng_grp_id BLNG_GRP_ID,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_MAIN,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_SUB,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_SUB FROM bl_visit_fin_dtls a, bl_blng_grp_lang_vw b, bl_patient_fin_dtls c    WHERE a.operating_facility_id = '"+facility_id+"'  AND c.patient_id = '"+strpatientid+"' AND a.episode_id = '"+strepisodeid+"' AND a.visit_id = '"+strvisitid+"' AND a.blng_grp_id = b.blng_grp_id AND b.language_id = '"+locale+"'";
			}
			else if(strepisodetype.equals("I") || strepisodetype.equals("D"))
			{
				ref_src_code_qry = "select b.blng_grp_id BLNG_GRP_ID, blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,'"+strepisodetype+"') REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_MAIN,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.NON_INS_REF_SOURCE_CODE_SUB,'"+strepisodetype+"') NON_INS_REF_SOURCE_CODE_SUB from bl_episode_fin_dtls a, bl_blng_grp_lang_vw b , bl_patient_fin_dtls c WHERE a.operating_facility_id = '"+facility_id+"' AND c.patient_id = '"+strpatientid+"'  AND a.episode_id =  '"+strepisodeid+"' AND a.blng_grp_id = b.blng_grp_id  AND b.language_id = '"+locale+"'";
			}

		try
		{
			if(!ref_src_code_qry.equals(""))
			{
				pstmt = con.prepareStatement(ref_src_code_qry);
				rs = pstmt.executeQuery() ;

				while(rs.next())
				{	
					strBlngGrpId=rs.getString("BLNG_GRP_ID");
					if(strBlngGrpId==null) strBlngGrpId="";

					ref_src_main_code=rs.getString("REFERRAL_SOURCE_CODE_MAIN");
					if(ref_src_main_code==null) ref_src_main_code="";

					ref_src_sub_code=rs.getString("REFERRAL_SOURCE_CODE_SUB");
					if(ref_src_sub_code==null) ref_src_sub_code="";

					non_ins_ref_src_main_code=rs.getString("NON_INS_REF_SOURCE_CODE_MAIN");
					if(non_ins_ref_src_main_code==null) non_ins_ref_src_main_code="";

					non_ins_ref_src_sub_code=rs.getString("NON_INS_REF_SOURCE_CODE_SUB");
					if(non_ins_ref_src_sub_code == null) non_ins_ref_src_sub_code="";
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in ref_src_code_qry:"+e);
		}

			String ref_src_code_valid_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+strBlngGrpId+"'";

			try
			{
				pstmt = con.prepareStatement(ref_src_code_valid_qry);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						referral_source_code_flag = rs.getString(1);
					}
				}
				if (rs != null) rs.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_valid_qry:"+e);
			}
			if(referral_source_code_flag == null) referral_source_code_flag="N";

			String non_ins_ref_src_code_valid_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+strNonInsBlGrId+"'";

			try
			{
				pstmt = con.prepareStatement(non_ins_ref_src_code_valid_qry);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						non_ins_referral_source_code_flag = rs.getString(1);
					}
				}
				if (rs != null) rs.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_valid_qry:"+e);
			}
			if(non_ins_referral_source_code_flag == null) non_ins_referral_source_code_flag="N";

			try
			{
				CallableStatement call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
				call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

				call_pkg.setString(2,facility_id);
				call_pkg.setString(3,strpatientid);
				call_pkg.setString(4,strepisodetype);
				call_pkg.setString(5,"VIEW_FINANCIAL_DTLS"); // Function ID
				call_pkg.setString(6,strBillGrpId);
				call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(strEncRegDate,"DMY",locale,"en"));
				call_pkg.setString(8,"P");
				call_pkg.setString(9,"");

				call_pkg.execute();							
				str_valid_pkg_for_pat_avail_YN = call_pkg.getString(1);				
				call_pkg.close();
				if ( str_valid_pkg_for_pat_avail_YN == null ) str_valid_pkg_for_pat_avail_YN = "";
//				System.err.println("str_valid_pkg_for_pat_avail_YN:"+str_valid_pkg_for_pat_avail_YN);
			}
			catch(Exception e)
			{
				System.out.println("Exception in Package Proc Call:"+e);
			}

			try
			{
				CallableStatement call_pkg = con.prepareCall("{ ? = call  blcore.availd_package_for_enc_yn(?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
				call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

				call_pkg.setString(2,facility_id);
				call_pkg.setString(3,strpatientid);
				call_pkg.setString(4,strepisodetype);
				call_pkg.setString(5,strepisodeid); 
				call_pkg.setString(6,strvisitid);
				call_pkg.setString(7,"VIEW_FINANCIAL_DTLS");// Function ID
				call_pkg.setString(8,strBillGrpId);
				call_pkg.setString(9,com.ehis.util.DateUtils.convertDate(strEncRegDate,"DMY",locale,"en"));
				call_pkg.setString(10,"");
				call_pkg.setString(11,"");

				call_pkg.execute();							
				str_valid_pkg_for_pat_enc_avail_YN = call_pkg.getString(1);				
				call_pkg.close();
				if ( str_valid_pkg_for_pat_enc_avail_YN == null ) str_valid_pkg_for_pat_enc_avail_YN = "";
//				System.out.println("str_valid_pkg_for_pat_enc_avail_YN:"+str_valid_pkg_for_pat_enc_avail_YN);
			}
			catch(Exception e)
			{
				System.out.println("Exception in function availd_package_for_enc_yn:"+e);
			}

			String sql_bl_class = "Select AUTO_FIN_CLASSFCTN_IN_USE_YN from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+facility_id+"'";
			try
			{
				pstmt = con.prepareStatement(sql_bl_class);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						fin_class_flag_YN = rs.getString(1);
					}
				}
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
//				System.err.println("From FinDtlsMain fin_class_flag_YN:"+fin_class_flag_YN);
			}
			catch(Exception e)
			{
				out.println("Exception in sql_bl_class::"+e);
				System.err.println("Exception in sql_bl_class::"+e);
			}
			if(fin_class_flag_YN == null) fin_class_flag_YN="N";
%>			
<html>
<head>
<title>
<% 
			if(strepisodetype.equals("R"))
			{
%>
				<%=title%> / <%=patln%> 
<%
			}
			else
			{
%>
				<%=title%> / <%=patln%>  /  <%=encounter%>
<%
			}
%>
</title>

<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<form>
<%		
/*
			try
			{	
				con = ConnectionManager.getConnection(request);
				if(strepisodetype.equals("R")) 
				{ 
					System.out.println("Inside MP Level");
					sql1 = "SELECT  b.long_desc billing_group,"+
							" b.settlement_ind settlement_ind, "+                     		
							" b.adm_rec_flag adm_rec_flag,		"+
							" a.annual_family_income annual_family_income, "+                  
							" a.family_assets_value family_assets_value,  "+                  
							" a.num_of_dependents num_of_dependents,    "+                  				
							" a.non_ins_blng_grp_id non_ins_blng_grp_id, "+                   		
							" a.non_ins_cust_code non_ins_cust_code,      "+                			
							" a.gl_holder_name gl_holder_name,            "+             
							" a.pat_reln_with_gl_holder pat_reln_with_gl_holder, "+                
							" a.credit_doc_ref_desc credit_doc_desc,              "+      
							" TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date, "+              
							" TO_CHAR(a.credit_doc_ref_date ,'DD/MM/YYYY') credit_doc_end_date,     "+               		
							" a.resp_for_bill_payment resp_for_bill_payment,     "+             	
							" a.pat_reln_with_resp_pers pat_reln_with_resp_pers,   "+ 
							" a.slmt_type_code, a.cust_code, "+	
							" a.CUR_ACCT_SEQ_NO cur_acct_seq_no "+
							" FROM bl_patient_fin_dtls a, "+
							"  bl_blng_grp_lang_vw b "+
							" WHERE a.patient_id = '"+strpatientid+"'  "+
							" AND a.blng_grp_id = b.blng_grp_id "+
							" AND b.language_id = '"+locale+"' ";
		
					 pstmt = con.prepareStatement(sql1);
					 rs = pstmt.executeQuery() ;
					
					 while(rs.next())
					 {			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);	
						intNoDep = rs.getInt(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRel  = rs.getString(15);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
					}
				}//closing if for episodetype "R"	
			}//closing try episodetype "R"
			catch(Exception e)
			{
				System.out.println("3="+e.toString());
			}
			finally	
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}	

			try
			{	
			   if((strepisodetype.equals("O")) || (strepisodetype.equals("E"))) 
				{
   					System.out.println("Inside OP r AE Level");
					sql2="SELECT  b.long_desc billing_group, "+
						" b.settlement_ind settlement_ind,     "+      		
						" b.adm_rec_flag adm_rec_flag,		"+
						" a.annual_family_income annual_family_income,  "+                 
						" a.family_assets_value family_assets_value,  "+             
						" a.num_of_dependents num_of_dependents,      "+         				
						" a.non_ins_blng_grp_id non_ins_blng_grp_id,  "+         		
						" a.non_ins_cust_code non_ins_cust_code,      "+     			
						" a.gl_holder_name gl_holder_name,            "+   
						" a.pat_reln_with_gl_holder pat_reln_with_gl_holder,   "+             
						" a.credit_doc_ref_desc credit_doc_desc,  "+        
						" TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date,  "+
						" TO_CHAR(a.credit_doc_ref_date,'DD/MM/YYYY') credit_doc_end_date,   "+         		
						" a.resp_for_bill_payment resp_for_bill_payment,        "+          	
						" a.pat_reln_with_resp_pers pat_reln_with_resp_pers,     "+   
						" a.slmt_type_code,a.cust_code, "+
						" a.CUR_ACCT_SEQ_NO cur_acct_seq_no "+
						" FROM bl_visit_fin_dtls a, "+
						" bl_blng_grp_lang_vw b    "+
						" WHERE a.operating_facility_id = '"+facility_id+"'  "+
						" AND a.episode_type ='"+strepisodetype+"' "+
						" AND a.episode_id = '"+strepisodeid+"'	"+ 
						" AND a.visit_id = '"+strvisitid+"'	"+
						" AND a.blng_grp_id = b.blng_grp_id	"+
						" AND b.language_id = '"+locale+"' ";
		
					pstmt = con.prepareStatement(sql2);
					 rs = pstmt.executeQuery() ;
			
					while(rs.next())
					{			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);			 
						intNoDep = rs.getInt(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
						strPatRel  = rs.getString(15);			 	
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);			 
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
					}
				}//closing if for episodetype OE
			}//closing try episodetype OE
			catch(Exception e)
			{
				System.out.println("333="+e.toString());
			}
			finally
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}	
			
			try
			{
				if((strepisodetype.equals("D")) || (strepisodetype.equals("I")))
				{
					System.out.println("Inside IP r AE Level");
					sql3="SELECT  b.long_desc billing_group,"+
			 			 " b.settlement_ind settlement_ind,             "+       		
			 			 " b.adm_rec_flag adm_rec_flag,	"+	
						 "	a.annual_family_income annual_family_income,  "+                 
						 "	a.family_assets_value family_assets_value,   "+                 
						 " 	a.num_of_dependents num_of_dependents,       "+               				
						 "	a.non_ins_blng_grp_id non_ins_blng_grp_id,    "+                		
						 "	a.non_ins_cust_code non_ins_cust_code,         "+             			
						 "	a.gl_holder_name gl_holder_name,            "+             
						 "	a.pat_reln_with_gl_holder pat_reln_with_gl_holder,"+                
						 "	a.credit_doc_ref_desc credit_doc_desc,              "+      
						 "	TO_CHAR(a.credit_doc_ref_start_date,'DD/MM/YYYY') credit_doc_ref_start_date,    "+           
						 "	TO_CHAR(a.credit_doc_ref_date,'DD/MM/YYYY') credit_doc_end_date,     "+               		
						 "	a.resp_for_bill_payment resp_for_bill_payment,    "+              	
						 "	a.pat_reln_with_resp_pers pat_reln_with_resp_pers,   "+    
						 " a.slmt_type_code, a.cust_code "+
						 " a.CUR_ACCT_SEQ_NO cur_acct_seq_no, "+
					   	 " FROM bl_episode_fin_dtls a,"+
						 " bl_blng_grp_lang_vw b    "+
						 " WHERE a.operating_facility_id = '"+facility_id+"'  "+
						 " AND a.episode_type = '"+strepisodetype+"'  "+
						 " AND a.episode_id =  '"+strepisodeid+"'  "+
						 " AND a.blng_grp_id = b.blng_grp_id  "+
						 " AND b.language_id = '"+locale+"' ";
				
					pstmt = con.prepareStatement(sql3);
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{			
						strBillGrp = rs.getString(1);	
						strSetInd =rs.getString(2);
						strAdmFlag = rs.getString(3);
						strFamIn = rs.getString(4);			 
						strFamAss  = rs.getString(5);	
						intNoDep = rs.getInt(6);
						strNonInsBlGrId = rs.getString(7);
						strNonInsCustCode = rs.getString(8);
						strGLHol  = rs.getString(9);
						strPatRel  = rs.getString(15);
						strGLHol  = rs.getString(9);
						strPatRelGL = rs.getString(10);
						strCrdDocRef = rs.getString(11);
						strCrDocRefStDate = rs.getString(12);
						strCrDocRefEndDate = rs.getString(13);
						strResPay  = rs.getString(14);
						strPatRelnRespPers = rs.getString(15);
						strslmttypecode = rs.getString(16);
						strcustcode = rs.getString(17);
						strCurrAcctSeqNo=rs.getString(18);
					}

				}//closing if for episodetype DI
			}//closing try episodetype DI
			catch(Exception e)
			{
				System.out.println("3="+e.toString());
			}
			finally
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}			
		
			try
			{   
				sql4="select short_desc  from bl_slmt_type where slmt_type_code = '"+strslmttypecode+"' ";
			
				pstmt = con.prepareStatement(sql4);
				rs = pstmt.executeQuery() ;
				
				while(rs.next())
				{
					strslmttypecode=rs.getString(1);
				}
			}
			catch(Exception e) 
			{
				System.out.println("3="+e.toString());
			}
			finally
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}			
*/
		}//closing outer main try
		catch(Exception sql)
		{
		}
	
		if (strBillGrp == null) strBillGrp = "";
		if (strSetInd == null) strSetInd = "";
		if (strAdmFlag == null) strAdmFlag = "";
		if (strFamIn == null) strFamIn = "";
		if (strFamAss == null) strFamAss = "";
		if (strAdmFlag == null) strAdmFlag = "";
		if (strNonInsBlGrId == null) strNonInsBlGrId = "";
		if (strNonInsCustCode == null) strNonInsCustCode = "";
		if (strGLHol == null) strGLHol = "";
		if (strPatRelGL == null) strPatRelGL = "";
		if (strCrdDocRef == null) strCrdDocRef = "";
		if (strCrDocRefStDate == null) strCrDocRefStDate = "";
		if (strCrDocRefEndDate == null) strCrDocRefEndDate = "";
		if (strResPay == null) strResPay = "";
		if (strPatRel == null) strPatRel = "";
		if (strslmttypecode == null) strslmttypecode = "";
		if (strcustcode == null) strcustcode ="";
		if (strcustgroupcode == null) strcustgroupcode ="";
		if (strNonInsCustGroupCode == null) strNonInsCustGroupCode = "";
		if (strClassType == null) strClassType = "";
		if (strClassCode == null) strClassCode = "";
		if (strFinRemarks == null) strFinRemarks = "";
		if (strSocialPensionerId == null) strSocialPensionerId = "";
		if (strIncAssetInd == null) strIncAssetInd = "";
		if (strIndInc == null) strIndInc = "";
		if (strIndIncFreq == null) strIndIncFreq = "";
		if (strSpouseInc == null) strSpouseInc = "";
		if (strSpouseIncFreq == null) strSpouseIncFreq = "";
		if (strDepInc == null) strDepInc = "";
		if (strDepIncFreq == null) strDepIncFreq = "";
		if (strClassStartDate == null) strClassStartDate = "";
		if (strClassEndDate == null) strClassEndDate = "";
		if (strClassFamIn == null) strClassFamIn="";
		if (strClassFamAss == null) strClassFamAss="";

		strAllParam = (request.getQueryString()) + "&strPatientId="+strpatientid+
													"&strEncRegDate="+strEncRegDate+
													"&strBillGrpId="+strBillGrpId+
													"&strBillGrp="+strBillGrp+
													"&strSetInd="+strSetInd +
													"&strAdmFlag="+strAdmFlag+
													"&strFamIn="+strFamIn+	
													"&strFamAss="+strFamAss +
													"&strAdmFlag="+strAdmFlag+
													"&strNoDep="+strNoDep +
													"&strNonInsBlGrId="+strNonInsBlGrId+
													"&strNonInsCustCode="+strNonInsCustCode +
													"&strNonInsCustGroupCode="+strNonInsCustGroupCode +
													"&strGLHol="+strGLHol+
													"&strPatRelGL="+strPatRelGL +
													"&strCrdDocRef="+strCrdDocRef+
													"&strCrDocRefStDate="+strCrDocRefStDate +
													"&strCrDocRefEndDate="+strCrDocRefEndDate+
													"&strResPay="+strResPay +
													"&strPatRel="+strPatRel +
													"&strslmttypecode="+strslmttypecode +
													"&strcustgroupcode="+strcustgroupcode+
													"&strcustcode="+strcustcode+
													"&strCurrAcctSeqNo="+strCurrAcctSeqNo+
													"&episodetype="+strepisodetype+
													"&episodeid="+strepisodeid+
													"&visitid="+strvisitid+
													"&referral_source_code_flag="+referral_source_code_flag+
													"&non_ins_referral_source_code_flag="+non_ins_referral_source_code_flag+
													"&valid_pkg_for_pat_avail_YN="+str_valid_pkg_for_pat_avail_YN+
													"&valid_pkg_for_pat_enc_avail_YN="+str_valid_pkg_for_pat_enc_avail_YN+
													"&strClassType="+strClassType+
													"&strClassCode="+strClassCode+
													"&strFinRemarks="+strFinRemarks+
													"&strSocialPensionerId="+strSocialPensionerId+
													"&strIncAssetInd="+strIncAssetInd+
													"&strIndInc="+strIndInc+
													"&strIndIncFreq="+strIndIncFreq+
													"&strSpouseInc="+strSpouseInc+
													"&strSpouseIncFreq="+strSpouseIncFreq+
													"&strDepInc="+strDepInc+
													"&strDepIncFreq="+strDepIncFreq+
													"&strClassStartDate="+strClassStartDate+
													"&strClassEndDate="+strClassEndDate+
													"&strClassFamIn="+strClassFamIn+
													"&strClassFamAss="+strClassFamAss+
													"&fin_class_flag_YN="+fin_class_flag_YN+
													"&ref_src_main_code="+ref_src_main_code+
													"&ref_src_sub_code="+ref_src_sub_code+
													"&non_ins_ref_src_main_code="+non_ins_ref_src_main_code+
													"&non_ins_ref_src_sub_code="+non_ins_ref_src_sub_code;

//		System.err.println("strAllParam:"+strAllParam);
%>

<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type= 'hidden' name="strBillGrp" id="strBillGrp"  value="<%=strBillGrp%>">
<input type= 'hidden' name="strBillGrpId" id="strBillGrpId"  value="<%=strBillGrpId%>">
<input type='hidden' name='strFamIn' id='strFamIn' value='<%=strFamIn%>'>
<input type='hidden' name='NoDep' id='NoDep' value='<%=strNoDep%>'>
<input type='hidden' name='strPatRel' id='strPatRel' value="<%=strPatRel%>">
<input type='hidden' name='strGLHol' id='strGLHol' value="<%=strGLHol%>">
<input type='hidden' name='strResPay' id='strResPay' value="<%=strResPay%>">
<input type='hidden' name='strPatRelGL' id='strPatRelGL' value="<%=strPatRelGL%>">
<input type='hidden' name='strAdmFlag' id='strAdmFlag' value='<%=strAdmFlag%>'>
<input type='hidden' name='strCrdDocRef' id='strCrdDocRef' value="<%=strCrdDocRef%>">
<input type='hidden' name='strSetInd' id='strSetInd' value='<%=strSetInd%>'>
<input type='hidden' name='strFamAss' id='strFamAss' value='<%=strFamAss%>'>
<input type='hidden' name='strslmttypecode' id='strslmttypecode' value='<%=strslmttypecode%>'>
<input type='hidden' name='strcustcode' id='strcustcode' value="<%=strcustcode%>">
<input type='hidden' name='strcustgroupcode' id='strcustgroupcode' value="<%=strcustgroupcode%>">
<input type='hidden' name='strNonInsBlGrId' id='strNonInsBlGrId' value="<%=strNonInsBlGrId%>">
<input type='hidden' name='strNonInsCustCode' id='strNonInsCustCode' value="<%=strNonInsCustCode%>">
<input type='hidden' name='strNonInsCustGroupCode' id='strNonInsCustGroupCode' value="<%=strNonInsCustGroupCode%>">
<input type='hidden' name='strCrDocRefStDate' id='strCrDocRefStDate' value='<%=strCrDocRefStDate%>'>
<input type='hidden' name='strCrDocRefEndDate' id='strCrDocRefEndDate' value='<%=strCrDocRefEndDate%>'>
<input type='hidden' name='episodetype1' id='episodetype1' value='<%=strepisodetype%>'>
<input type='hidden' name='strEncRegDate' id='strEncRegDate' value='<%=strEncRegDate%>'>

</form>
	

<iframe name='tab_frames' id='tab_frames' src="BLFinDtlQryMainTabs.jsp?<%=strAllParam%>"  frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
<!--
<frame name='mainFrame' id='mainFrame' src="BLFinDtlQryMainFrames.jsp?<%=strAllParam%>" frameborder=0 noresize scrolling='no' noresize>
-->
<iframe name='mainFrame' id='mainFrame'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' noresize style='height:96vh;width:100vw'></iframe>





<%
	}
	catch(Exception eX)
	{
		System.out.println("Error in QryMain.jsp= "+eX);
	}
	finally
	{ 
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

