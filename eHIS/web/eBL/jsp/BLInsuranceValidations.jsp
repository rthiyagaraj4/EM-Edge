<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.BLPatRegChargesBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%	
/*	 
Sr No        Version           TFS/Incident        SCF/CRF            		 	Developer Name
-------------------------------------------------------------------------------------------------
1            V210827            23216         	MMS-KH-SCF-0159      			Mohana/MuthuN
2            V210707            21282     		NMC-JD-SCF-0215-TP				Mohana Priya K
3			 V211020												Mohanapriya K
-------------------------------------------------------------------------------------------------
*/
	Connection con = null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	PreparedStatement pstmt4 = null ;
	PreparedStatement pstmt5 = null ;//Added for MMS-DM-CRF-0164.1_73095
	PreparedStatement pstmt6 = null ;//Added against NMC-JD-CRF-0054 policyAddPayer
	PreparedStatement pstmt7 = null ;//Added against NMC-JD-CRF-0054 policyMand Flag
	PreparedStatement pstmt8 = null ;//Added against NMC-JD-CRF-0054 policyMand Flag
	PreparedStatement pstmt9 = null ;//Added against NMC-JD-CRF-0054 policyMand Flag
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;//Added for MMS-DM-CRF-0164.1_73095
	ResultSet rs6 = null;//Added against NMC-JD-CRF-0054 policyAddPayer
	ResultSet rs7 = null;//Added against NMC-JD-CRF-0054 policyMand Flag
	ResultSet rs8 = null;//Added against NMC-JD-CRF-0054 policyMand Flag
	ResultSet rs9 = null;//Added against NMC-JD-CRF-0054 policyMand Flag
	
	//Added By Niveditha for NMC-JD-CRF-0054.3
	PreparedStatement ec_pstmt = null;
	ResultSet ec_rs = null;
	String ec_cust_group_details = "N", NationalityFlag = "N", NonCizAltId1 = "N", NonCizAltId2 = "N", NonCizAltId3 = "N", NonCizAltId4 = "N", NonCizAltId5 = "N", CizAltId1 = "N", CizAltId2 = "N", CizAltId3 = "N", CizAltId4 = "N", CizAltId5 = "N" ;
	
	//Added against MMS-DM-CRF-0164.1_73072 starts
	String TotalRecords = request.getParameter("rtn_total_records");
	HashMap MembershipIdRemove=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION"); 
	HashMap NationalityIdRemove=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION"); //Diff
	//Added against MMS-DM-CRF-0164.1_73072 ends
	/*//Added Against NMC-JD-CRF-0054 for Policy Number Count Starts here
	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean pkgBean	= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList payerList=new ArrayList();
	payerList=(ArrayList)pkgBean.getDetails();
	HashMap headerDtls=new HashMap();
	headerDtls= (HashMap)payerList.get(0);
	//Added Against NMC-JD-CRF-0054 for Policy Number Count Starts Ends*/
	try
	{
		con = ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		String adj_rule_ind="", adj_perc_amt_ind="", adj_perc_amt_value="", pmnt_diff_adj_int="", drg_pmnt_diff_adj_int="", spl_srv_pmnt_diff_adj_int="", pmnt_diff_adj_int_desc="";

		String cust_group_code="",cust_code="", policy_type_code="", priority="", facility_id="", patient_class="", episode_type="";

		String str_bg_curr_code="",policy_coverage_basis_ind="",policy_approved_by = "";

		String restrict_check="",apprd_amt_restrict_check="",apprd_days_restrict_check="",cred_auth_req_yn="",dflt_auth_ref_as_pol_no_yn="",cred_auth_mand_capt_yn="";

		String restricted_YN="",v_display_hide="",v_display_hide_apprvd_amt="",credit_apprd_amt="",v_display_hide_apprvd_days="",credit_apprd_days="";

		String v_display_hide_cred_auth="";
		String gl_holder_name = "", doc_ref = "", credit_doc_ref_desc ="", no_of_enc_gl_valid="", no_of_ae_enc_gl_valid="", no_of_op_enc_gl_valid="", no_of_ip_enc_gl_valid="", no_of_dc_enc_gl_valid="";
		String no_of_enc_gl_availed="", no_of_ae_enc_gl_availed="", no_of_op_enc_gl_availed="", no_of_ip_enc_gl_availed="", no_of_dc_enc_gl_availed="";
		String gl_doc_ref_exist_YN="N";

		String no_data_found = "N";
		String payer_suspend_yn =""; //muthu 32426 on 9/5/2012

		String overlap_YN="N", rltd_policies_rec_avail_YN="N", rltd_pol_start_date="", rltd_pol_exp_date="", cur_pol_least_prio_YN="N";

		String addl_days_policy_expdt="",days_policy_expdt="",days_policy_strtdt=""; // GHL-0020 SCRUM CRF related

		String locale			= (String)session.getAttribute("LOCALE");

		String encounter_date_time = request.getParameter("encounter_date_time"); // GHL-0020 SCRUM CRF related
		if(encounter_date_time==null) encounter_date_time="";

		String patient_id = request.getParameter("patient_id");
		if(patient_id==null) patient_id="";

		String calld_frm = request.getParameter("called_from");
		if(calld_frm==null) calld_frm="";

		String billing_group=request.getParameter("billing_group");
		if(billing_group==null) billing_group="";

		String str_user = (String) session.getValue("login_user");
		if(str_user==null) str_user="";


		facility_id=request.getParameter("facility_id");
		if(facility_id==null) facility_id="";

		episode_type=request.getParameter("episode_type");
		if(episode_type==null) episode_type="";

		cust_group_code=request.getParameter("cust_group_code");
		if(cust_group_code==null) cust_group_code="";
		
		//Added against MMS-DM-CRF-0164.1_73072 Starts
		String custGrpcode=request.getParameter("custGrpcode");
		if(custGrpcode==null) custGrpcode="";
		//Added against MMS-DM-CRF-0164.1_73072 Ends

		cust_code=request.getParameter("cust_code");
		if(cust_code==null) cust_code="";

		policy_type_code=request.getParameter("policy_type_code");
		if(policy_type_code==null) policy_type_code="";

		gl_holder_name =request.getParameter("gl_holder_name");
		if(gl_holder_name==null) gl_holder_name="";

		doc_ref =request.getParameter("doc_ref");
		if(doc_ref==null) doc_ref="";

		String strModplcyDtlYN;
		
		//Retriving SiteSpec Value - //Added for MMS-DM-CRF-0164.1_73072 Starts
		String siteSpecBillGrp =request.getParameter("siteSpecMemberID");
		if(siteSpecBillGrp==null) siteSpecBillGrp="";
		String siteSpecPolFlag =request.getParameter("siteSpecPolicyNo");
		if(siteSpecPolFlag==null) siteSpecPolFlag=""; 
		Connection conBill = null;
		PreparedStatement pstmtSite = null ;
		ResultSet rsSite = null;
		PreparedStatement pstmtBill = null ;
		ResultSet rsBill = null;
		//Added for MMS-DM-CRF-0164.1_730 Ends
		//Muthu against 32426 on 9/5/2012
		if(calld_frm.equals("payersuspended"))
		{
			try
			{
				String sql_payer_suspend="SELECT STATUS FROM ar_customer_lang_vw WHERE CUST_CODE = ? AND LANGUAGE_ID = ? ";
				pstmt = con.prepareStatement(sql_payer_suspend);
				pstmt.setString(1,cust_code);
				pstmt.setString(2,locale);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					payer_suspend_yn = rs.getString(1);
				}
			if (rs != null)   rs.close();
			pstmt.close();
			out.println(payer_suspend_yn);
			}
			catch(Exception e)
			{
				System.out.println("Exception while executing payer_suspend_yn :"+e);
			}		
			
		//Added for MMS-DM-CRF-0164.1_73072 Starts	
		/*if(siteSpecBillGrp.equals("Y"))
		{
			String MandatoryFlag="";
			String MemberFlag="";
			String CustCode="";
			String custGrpExtIntFlag="";//NMC-JD-CRF-0054
			CustCode=cust_code.substring( 0, cust_code.indexOf("-"));
			//Added Against NMC-JD-CRF-0054 Starts
			try{
				String cust_grp_ext_int_YN = "Select cust_grp_ext_interface_yn from bl_parameters where OPERATING_FACILITY_ID='"+facility_id+"'";
						//System.err.println("cust_grp_ext_int_YN Query BLInsValidation.jsp:"+cust_grp_ext_int_YN);
				pstmt4 = con.prepareStatement(cust_grp_ext_int_YN);
				rs4=pstmt4.executeQuery();
				if( rs4 != null ) 
				{
					while(rs4.next())
					{
						custGrpExtIntFlag = rs4.getString(1);
						System.err.println("custGrpExtIntFlag BLInsValidation.jsp:"+custGrpExtIntFlag);
					}				
				}
			}catch(Exception e)
				{ 
					e.printStackTrace();
					System.err.println("Main Exception cust_grp_ext_int_YN:"+e);
				}
			//Added Against NMC-JD-CRF-0054 Ends
			try{				
				String membership = "Select MEMBSHPID_MAND_FLAG from AR_CUST_GROUP where CUST_GROUP_CODE = '"+CustCode+"'";
				pstmt4 = con.prepareStatement(membership);
				rs4=pstmt4.executeQuery();
				if( rs4 != null ) 
				{
					while(rs4.next())
					{
						MandatoryFlag = rs4.getString(1);
					}				
				}			
			}
			catch(Exception e)
			{ 
				e.printStackTrace();
				System.err.println("Main Exception BLInsValidation.jsp:"+e);
			}
		if(custGrpExtIntFlag.equals("Y") && MandatoryFlag.equals("Y") && TotalRecords!=null)//added against NMC-JD-CRF-0054
		{
			// String []MemberNumber= new String[100];
			String []MemberNo= new String[100];
			ArrayList<String> Memberlist = new ArrayList<String>();
			try
			{
				System.err.println("TotalRecords :"+TotalRecords);
				for(int m=1;m<=Integer.parseInt(TotalRecords);m++){
					String MemberNumber=(String) MembershipIdRemove.get(Integer.toString(m));
					MemberNo=MemberNumber.split("~");
					if(MemberNo.length!=0){
						Memberlist.add(MemberNo[2]);
					}
				}
				System.err.println("Memberlist :"+Memberlist);
				if(Memberlist.isEmpty()){
					MemberFlag="Y";
				}else{
					if(Memberlist.size()==Integer.parseInt(TotalRecords)){
						MemberFlag="N";
					}else{
						MemberFlag="Y";
					}					
				}	
				System.err.println("MemberFlag :"+MemberFlag);
			out.println(MemberFlag);
			}
			catch(Exception e)
			{
				System.err.println("Exception while executing member :"+e);
				e.printStackTrace();
			}
		//Added for MMS-DM-CRF-0164.1_73072 ends
		}
		}*/
		}
		//Muthu against 32426 on 9/5/2012

		//Added for MMS-DM-CRF-0164.1 and NMC-JD-CRF-0054 Starts - SiteSpecific Logic
		String member="";
		String MemberFlag="N",NatFlag="N"; //Diff
		String policyNumberDupFlag="N";
		if(calld_frm.equals("memIDPolId"))
		{
			if(siteSpecBillGrp.equals("Y"))
			{
				String MandatoryFlag="";
				String CustCode="";
				String priorityPat="";
				String patMemId="";
				String clmCode="";
				String clmAuthBy="";
				String poliNum="";
				String patId=request.getParameter("patientId");
				if(patId==null) patId="";
				HashMap<String, String> memHaspMap = new HashMap<String, String>();
				String custGrpExtIntFlag="";//NMC-JD-CRF-0054
				//Modified V210707  & V210827 Starts
				//CustCode=cust_code.substring( 0, cust_code.indexOf("-"));
				if(cust_code.indexOf("-")!=-1){
					CustCode=cust_code.substring( 0, cust_code.indexOf("-"));
				}
				else if(cust_code.indexOf("_")!=-1){
					CustCode=cust_code.substring( 0, cust_code.indexOf("_"));
				}
				else if(cust_code.indexOf("/")!=-1){
					CustCode=cust_code.substring( 0, cust_code.indexOf("/"));
				}else{
					CustCode=cust_code;
				}
				//Modified V210707 & V210827 Ends
				System.err.println("319,CustCode:"+CustCode);
				//Added Against NMC-JD-CRF-0054 Starts
				try{
						String cust_grp_ext_int_YN = "Select cust_grp_ext_interface_yn from bl_parameters where OPERATING_FACILITY_ID= ? ";
						pstmt4 = con.prepareStatement(cust_grp_ext_int_YN);
						pstmt4.setString(1,facility_id);
						rs4=pstmt4.executeQuery();
						if( rs4 != null ) 
						{
							while(rs4.next())
							{
								custGrpExtIntFlag = rs4.getString(1);
								//System.err.println("244,custGrpExtIntFlag:"+custGrpExtIntFlag);
							}				
						}
				}catch(Exception e)
					{ 
						e.printStackTrace();
						System.err.println("Main Exception cust_grp_ext_int_YN:"+e);
					}
				//Added Against NMC-JD-CRF-0054 Ends
				try{				
						String membership = "Select MEMBSHPID_MAND_FLAG from AR_CUST_GROUP where CUST_GROUP_CODE = ? ";
						pstmt4 = con.prepareStatement(membership);
						pstmt4.setString(1,CustCode);
						rs4=pstmt4.executeQuery();
						if( rs4 != null ) 
						{
							while(rs4.next())
							{
								MandatoryFlag = rs4.getString(1);
								//System.err.println("348,MandatoryFlag:"+MandatoryFlag);
							}				
						}			
					}
				catch(Exception e)
				{ 
					e.printStackTrace();
					System.err.println("Main Exception 5555555555555:"+e);
				}
			//System.err.println("271,TotalRecords::"+TotalRecords);	
			if(custGrpExtIntFlag.equals("Y") && MandatoryFlag.equals("Y") && TotalRecords!=null)//Added against NMC-JD-CRF-0054 
			{		
				String []MemberNo= new String[100];
				ArrayList<String> Memberlist = new ArrayList<String>();
				//System.err.println("Memberlist====>  "+Memberlist);
				try
				{
					//System.err.println("MembershipIdRemove[m] ==> "+MembershipIdRemove);
					if(!MembershipIdRemove.isEmpty()){
						for(int m=1;m<=Integer.parseInt(TotalRecords);m++){
							String MemberNumber=(String) MembershipIdRemove.get(Integer.toString(m));
							//System.err.println("MemberNumber[m] ==> "+MemberNumber);
							if(MemberNumber!=null){
								//System.err.println("MemberNo  before:"+MemberNo.length);
								MemberNo=MemberNumber.split("~");
								//System.err.println("MemberNumber :"+MemberNumber);
								//System.err.println("MemberNo  aftter:"+MemberNo.length);
								if(MemberNo.length!=0){
									if(MemberNo[2]!=null && !MemberNo[2].equals("")){   //31-08-2020
										Memberlist.add(MemberNo[2]);
										//System.err.println("MemberNo[2] :"+MemberNo[2]);
									}
								}
							}
						}
					}else{
						HashMap<String,String> polMemMap=( session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null ? new HashMap<String,String>(): (HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION") );
						//HashMap Empty Case making DB call to fetch Membership  values
						try{				
								String membershipQuery = "SELECT priority,CLAIM_CODE,CREDIT_AUTH_BY,membership_no,POLICY_NUMBER from bl_encounter_payer_priority  WHERE patient_id = ? and settlement_Ind='X'";
								//System.err.println("443,membershipQuery:"+membershipQuery);
								pstmt8 = con.prepareStatement(membershipQuery);
								pstmt8.setString(1,patId);
								rs8=pstmt8.executeQuery();
								if( rs8 != null ) 
								{
									while(rs8.next())
									{
										priorityPat = rs8.getString(1);
										clmCode = rs8.getString(2);
										clmAuthBy = rs8.getString(3);
										patMemId = rs8.getString(4);
										poliNum = rs8.getString(5);
										if(priorityPat==null) priorityPat="";
										if(clmCode==null) clmCode="";
										if(clmAuthBy==null) clmAuthBy="";
										if(patMemId==null) patMemId="";
										if(poliNum==null) poliNum="";
										memHaspMap.put(priorityPat,patMemId);
										polMemMap.put(priorityPat, clmCode +"~" + clmAuthBy +"~" + patMemId +"~"+ poliNum);
										//System.err.println("454,polMemMap:"+polMemMap);
										session.setAttribute("CLAIM_CREDIT_MAP_SESSION",polMemMap);
										//System.err.println("456,Priority:"+priorityPat);
										//System.err.println("457,patMemId:"+patMemId);
									}				
								}			
							}
						catch(Exception e)
						{ 
							e.printStackTrace();
							System.err.println("Main Exception 5555555555555:"+e);
						}
						if(!memHaspMap.isEmpty()){
							for(int n=1;n<=Integer.parseInt(TotalRecords);n++){
							String MemberNumber=(String) memHaspMap.get(Integer.toString(n));
							System.err.println("Member hash map  ==> "+MemberNumber);
							if(MemberNumber!=null && !MemberNumber.equals("")){ //31-08-2020
							Memberlist.add(MemberNumber);
							}
						}
						}
					}
						System.err.println("Memberlist :"+Memberlist);
					if(Memberlist.isEmpty()){
						MemberFlag="Y";
					}else{
						if(Memberlist.size()!=Integer.parseInt(TotalRecords)){
							MemberFlag="Y";
						}					
					}	
				System.err.println("MemberFlag,389==>"+MemberFlag);
				}
				catch(Exception e)
				{
					System.err.println("Exception while executing member :"+e);
					e.printStackTrace();
				}
				}
			}
			if(siteSpecPolFlag.equals("Y")){
				String polMandFlag="";
				String patId=request.getParameter("polPatId");
				//System.err.println("calld_frm BLInsValidation.jsp:"+calld_frm);
				//System.err.println("siteSpecPolFlag BLInsValidation.jsp:"+siteSpecPolFlag);
				//Modified V210707 & V210827 Starts
				//String custCode=cust_code.substring( 0, cust_code.indexOf("-"));
				String custCode="";
				if(cust_code.indexOf("-")!=-1){
					custCode=cust_code.substring( 0, cust_code.indexOf("-"));
				}
				else if(cust_code.indexOf("_")!=-1){
					custCode=cust_code.substring( 0, cust_code.indexOf("_"));
				}
				else if(cust_code.indexOf("/")!=-1){
					custCode=cust_code.substring( 0, cust_code.indexOf("/"));
				}else{
					custCode= cust_code;
				}
				//Modified V210707 & V210827 Ends
				
				String priorityPatPol="";
				String patPolNo="";
				String clmCodePol = "";
				String clmAuthBypol ="";
				String patMemIdpol ="";
				HashMap<String, String> polHaspMap = new HashMap<String, String>();
				System.err.println("custCode BLInsValidation.jsp:"+custCode);
				//Retriving Policy Number Mandatory Flag from DB
				try{				
					String policyNoMandQuery = "Select policyno_mand_flag  from AR_CUST_GROUP where CUST_GROUP_CODE = ? ";
					//System.err.println("policyNoMandQuery BLInsValidation.jsp:"+policyNoMandQuery);
					pstmt7 = con.prepareStatement(policyNoMandQuery);
					pstmt7.setString(1,custCode);
					rs7=pstmt7.executeQuery();
					if( rs7 != null ) 
					{
						while(rs7.next())
						{
							polMandFlag = rs7.getString(1);
							System.err.println("polMandFlag BLInsValidation.jsp:"+polMandFlag);
						}				
					}	
				rs7.close();
				pstmt7.close();
				}
				catch(Exception e)
				{ 
					rs7.close();
					pstmt7.close();
					e.printStackTrace();
					System.err.println("Main Exception BLInsValidation.jsp:"+e);
				}
				if(polMandFlag.equals("Y") && TotalRecords!=null){
					String []polNo= new String[100];
					ArrayList<String> polNolist = new ArrayList<String>();
					try
					{
						if(!MembershipIdRemove.isEmpty()){
							for(int m=1;m<=Integer.parseInt(TotalRecords);m++){
								String polNumber=(String) MembershipIdRemove.get(Integer.toString(m));
								//System.err.println("polNumber :"+polNumber);
								if(polNumber!=null){
									polNo=polNumber.split("~");
									//System.err.println("polNo Length :"+polNo.length);
									if(polNo.length!=0)//added against NMC-JD-CRF-0054
									{
										if(polNo.length>3){
											//31-08-2020
											if(polNo[3]!=null && !polNo[3].equals("")){ 
												polNolist.add(polNo[3]);
											}
										}
									}
								}
							}
						}else
						{
						//HashMap Empty Case making DB call to fetch Membership  values
						HashMap<String,String> polMemMap1=( session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null ? new HashMap<String,String>(): (HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION") );
						try{				
								String policyNumerQuery = "SELECT priority,CLAIM_CODE,CREDIT_AUTH_BY,membership_no,POLICY_NUMBER from bl_encounter_payer_priority  WHERE patient_id = ? and settlement_Ind='X'";
								//System.err.println("195,policyNumerQuery:"+policyNumerQuery);
								pstmt9 = con.prepareStatement(policyNumerQuery);
								pstmt9.setString(1,patId);
								rs9=pstmt9.executeQuery();
								if( rs9 != null ) 
								{
									while(rs9.next())
									{
										priorityPatPol = rs9.getString(1);
										clmCodePol = rs9.getString(2);
										clmAuthBypol = rs9.getString(3);
										patMemIdpol = rs9.getString(4);
										patPolNo = rs9.getString(5);
										if(priorityPatPol==null) priorityPatPol="";
										if(clmCodePol==null) clmCodePol="";
										if(clmAuthBypol==null) clmAuthBypol="";
										if(patMemIdpol==null) patMemIdpol="";
										if(patPolNo==null) patPolNo="";
										polHaspMap.put(priorityPatPol,patPolNo);
										polMemMap1.put(priorityPatPol, clmCodePol +"~" + clmAuthBypol +"~" + patMemIdpol +"~"+ patPolNo);
										//System.err.println("454,polMemMap1:  in policy number "+polMemMap1);
										session.setAttribute("CLAIM_CREDIT_MAP_SESSION",polMemMap1);
										//System.err.println("204,Priority:"+priorityPatPol);
										//System.err.println("205,Policy no:"+patPolNo);
									}				
								}			
							}
						catch(Exception e)
						{ 
							e.printStackTrace();
							System.err.println("Main Exception 5555555555555:"+e);
						}
							if(!polHaspMap.isEmpty()){
								for(int n=1;n<=Integer.parseInt(TotalRecords);n++){
								String polNumber=(String) polHaspMap.get(Integer.toString(n));
								System.err.println("Policy hash map  ==> "+polNumber);
								if(polNumber!=null && !polNumber.equals("")){  //31-08-2020
									polNolist.add(polNumber);
								}
								}
							}
						}
						if(polNolist.isEmpty()){
							policyNumberDupFlag="Y";
						}else{
							if(polNolist.size()!=Integer.parseInt(TotalRecords)){
								policyNumberDupFlag="Y";
							}					
						}	
					}
					catch(Exception e)
					{
						System.err.println("Exception while executing member :"+e);
						e.printStackTrace();
					}
				} //polMandFlag
			}//siteSpecPolFlag


			//Added Against NMC-JD-CRF-0054.3 By Niveditha
			//String CustGroupCode=cust_code.substring( 0, cust_code.indexOf("-"));//07-Jul-21

			//Modified V210707 & V210827 Starts
			String CustGroupCode="";
			if(cust_code.indexOf("-")!=-1){
				CustGroupCode=cust_code.substring( 0, cust_code.indexOf("-"));
			}
			else if(cust_code.indexOf("_")!=-1){
				CustGroupCode=cust_code.substring( 0, cust_code.indexOf("_"));
			}
			else if(cust_code.indexOf("/")!=-1){
				CustGroupCode=cust_code.substring( 0, cust_code.indexOf("/"));
			}else{
				CustGroupCode=cust_code; 
			}
			//Modified V210707 & V210827 Ends

			System.err.println("9000,CustGroupCode:"+CustGroupCode);
			try{				
				ec_cust_group_details = "Select NATID_MAND_FLAG, MAND_ALTID1, MAND_ALTID2, MAND_ALTID3, MAND_ALTID4, MAND_ALTID5, CITIZEN_MAND_ALTID1, CITIZEN_MAND_ALTID2, CITIZEN_MAND_ALTID3, CITIZEN_MAND_ALTID4, CITIZEN_MAND_ALTID5 from AR_CUST_GROUP where CUST_GROUP_CODE = ? ";
				
				System.err.println("9000,ec_cust_group_details:"+ec_cust_group_details);
				ec_pstmt = con.prepareStatement(ec_cust_group_details);
				ec_pstmt.setString(1,CustGroupCode);
				ec_rs=ec_pstmt.executeQuery();
				if( ec_rs != null ) {
					while(ec_rs.next()){
						NationalityFlag = ec_rs.getString(1);
						NonCizAltId1 = ec_rs.getString(2);
						NonCizAltId2 = ec_rs.getString(3);
						NonCizAltId3 = ec_rs.getString(4);
						NonCizAltId4 = ec_rs.getString(5);
						NonCizAltId5 = ec_rs.getString(6);
						CizAltId1 = ec_rs.getString(7);
						CizAltId2 = ec_rs.getString(8);
						CizAltId3 = ec_rs.getString(9);
						CizAltId4 = ec_rs.getString(10);
						CizAltId5 = ec_rs.getString(11);
					}				
				}			
				}catch(Exception e){ 
					e.printStackTrace();
					System.err.println("Main Exception BLInsValidation.jsp:on ec_cust_group_details"+e);
			}
			//Added Against NMC-JD-CRF-0054.3 By Niveditha

			//out.println("~"+MemberFlag+"~"+policyNumberDupFlag); 
			out.println("~"+MemberFlag+"~"+policyNumberDupFlag+"~"+NationalityFlag+"~"+NonCizAltId1+"~"+NonCizAltId2+"~"+NonCizAltId3+"~"+NonCizAltId4+"~"+NonCizAltId5+"~"+CizAltId1+"~"+CizAltId2+"~"+CizAltId3+"~"+CizAltId4+"~"+CizAltId5); //Modified by Niveditha for NMC-JD-CRF-0054.3		
		}
		//Added against MMS-DM-CRF-0164.1_73072 Ends	
		
		//Added against MMS-DM-CRF-0164.1_73095 Starts
		if(calld_frm.equals("memIDAddPayer"))
		{
			String MandatoryFlagAddPayer="";
			String custGrpExtIntFlag="";
			//Added Against NMC-JD-CRF-0054 Starts
			try{
					//System.err.println("memIDAddPayer====>");
					//System.err.println("facility_id====>"+facility_id);
					String cust_grp_ext_int_YN = "Select cust_grp_ext_interface_yn from bl_parameters where OPERATING_FACILITY_ID= ? ";
					pstmt4 = con.prepareStatement(cust_grp_ext_int_YN);
					pstmt4.setString(1,facility_id);
					rs4=pstmt4.executeQuery();
					if( rs4 != null ) 
					{
						while(rs4.next())
						{
							custGrpExtIntFlag = rs4.getString(1);
							//System.err.println("custGrpExtIntFlag====>"+custGrpExtIntFlag);
						}				
					}
				}catch(Exception e)
				{ 
					e.printStackTrace();
					System.err.println("Main Exception cust_grp_ext_int_YN:"+e);
				}
				//Added Against NMC-JD-CRF-0054 Ends
			if(custGrpExtIntFlag.equals("Y"))//Added Against NMC-JD-CRF-0054
			{
				System.err.println("custGrpExtIntFlag==if Y==>"+custGrpExtIntFlag);
				try{	
					
					String membershipAddPayer = "Select MEMBSHPID_MAND_FLAG from AR_CUST_GROUP where CUST_GROUP_CODE = ? ";
					pstmt5 = con.prepareStatement(membershipAddPayer);
					pstmt5.setString(1,custGrpcode);
					rs5=pstmt5.executeQuery();
					if( rs5 != null ) 
					{
						while(rs5.next())
						{
							MandatoryFlagAddPayer = rs5.getString(1);
							//System.err.println("MandatoryFlagAddPayer in validation===>"+MandatoryFlagAddPayer);
						}				
					}
					out.println(MandatoryFlagAddPayer);			
				}
			catch(Exception e)
			{ 
				e.printStackTrace();
				System.err.println("Main Exception MandatoryFlagAddPayer:"+e);
			}
			}
		}
			
		//Added against MMS-DM-CRF-0164.1_73095 Ends
		
		//Added against NMC-JD-CRF-0054 policyAddPayer starts
		if(calld_frm.equals("polAddPayer"))
		{
			String policyMandatoryAddPayer="";
			try{	
					//System.err.println("custGrpcode in validations=====>"+custGrpcode);
					String policyAddPayer = "Select policyno_mand_flag from AR_CUST_GROUP where CUST_GROUP_CODE = ? ";
					pstmt6 = con.prepareStatement(policyAddPayer);
					pstmt6.setString(1,custGrpcode);
					rs6=pstmt6.executeQuery();
					if( rs6 != null ) 
					{
						while(rs6.next())
						{
							policyMandatoryAddPayer = rs6.getString(1);
							//System.err.println("policyMandatoryAddPayer in validation===>"+policyMandatoryAddPayer);
						}				
					}
					out.println(policyMandatoryAddPayer);			
				}
			catch(Exception e)
			{ 
				e.printStackTrace();
				System.err.println("Main Exception policyMandatoryAddPayer:"+e);
			}
		}	
		//	Added against NMC-JD-CRF-0054 policyAddPayer ends
	if(calld_frm.equals("adj_rul"))
	{
			priority=request.getParameter("priority");
			if(priority==null) priority="";
		
			patient_class=request.getParameter("patient_class");
			if(patient_class==null) patient_class="";

			String sql="select adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,spl_srv_pmnt_diff_adj_int from  bl_payers_priority_by_bg where operating_facility_id = ? and blng_grp_id = ? and cust_group_code = ? and cust_code = ? and patient_class = ? and policy_type_code = ? and priority_no= ? ";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,billing_group);
			pstmt.setString(3,cust_group_code);
			pstmt.setString(4,cust_code);
			pstmt.setString(5,patient_class);
			pstmt.setString(6,policy_type_code);
			pstmt.setString(7,priority);
			
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					no_data_found = "Y";

					adj_rule_ind=(String)rs.getString("adj_rule_ind");
					if(adj_rule_ind==null || adj_rule_ind.equals("")) adj_rule_ind=" ";
					adj_perc_amt_ind=(String)rs.getString("adj_perc_amt_ind");
					if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals("")) adj_perc_amt_ind=" ";
					adj_perc_amt_value=(String)rs.getString("adj_perc_amt_value");
					if(adj_perc_amt_value==null || adj_perc_amt_value.equals("")) adj_perc_amt_value=" ";
					pmnt_diff_adj_int=(String)rs.getString("pmnt_diff_adj_int");
					if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals("")) pmnt_diff_adj_int=" ";
					drg_pmnt_diff_adj_int=(String)rs.getString("drg_pmnt_diff_adj_int");
					if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals("")) drg_pmnt_diff_adj_int=" ";
					spl_srv_pmnt_diff_adj_int=(String)rs.getString("spl_srv_pmnt_diff_adj_int");
					if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals("")) spl_srv_pmnt_diff_adj_int=" ";
				}
	
			}
			else
			{
				no_data_found = "N";
			}
			if(rs != null) rs.close();
			pstmt.close();

			if(no_data_found.equals("N"))
			{
				sql="select adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,spl_srv_pmnt_diff_adj_int from  bl_payers_priority_by_bg where operating_facility_id = ? and blng_grp_id = ? and cust_group_code = ? and cust_code ='**' and patient_class = ? and policy_type_code = ? and priority_no= ? ";

				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,billing_group);
				pstmt.setString(3,cust_group_code);
				pstmt.setString(4,patient_class);
				pstmt.setString(5,policy_type_code);
				pstmt.setString(6,priority);
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						adj_rule_ind=(String)rs.getString("adj_rule_ind");
						if(adj_rule_ind==null || adj_rule_ind.equals("")) adj_rule_ind=" ";
						adj_perc_amt_ind=(String)rs.getString("adj_perc_amt_ind");
						if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals("")) adj_perc_amt_ind=" ";
						adj_perc_amt_value=(String)rs.getString("adj_perc_amt_value");
						if(adj_perc_amt_value==null || adj_perc_amt_value.equals("")) adj_perc_amt_value=" ";
						pmnt_diff_adj_int=(String)rs.getString("pmnt_diff_adj_int");
						if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals("")) pmnt_diff_adj_int=" ";
						drg_pmnt_diff_adj_int=(String)rs.getString("drg_pmnt_diff_adj_int");
						if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals("")) drg_pmnt_diff_adj_int=" ";
						spl_srv_pmnt_diff_adj_int=(String)rs.getString("spl_srv_pmnt_diff_adj_int");
						if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals("")) spl_srv_pmnt_diff_adj_int=" ";
					}
		
				}
				if(rs != null) rs.close();
				pstmt.close();
			}
			
			if(!pmnt_diff_adj_int.equals(""))
			{
				sql="SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_entity_code = (select acc_entity_code from sy_acc_entity where acc_entity_id= ? ) and acc_int_code= ? and LANGUAGE_ID= ? ";

				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,pmnt_diff_adj_int);
				pstmt.setString(3,locale);
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						pmnt_diff_adj_int_desc=(String)rs.getString("acc_int_desc");
						if(pmnt_diff_adj_int_desc==null || pmnt_diff_adj_int_desc.equals("")) pmnt_diff_adj_int_desc=" ";
					}
				}
				if(rs != null) rs.close();
				pstmt.close();
			}

		}
		else if(calld_frm.equals("bg_curr_code"))
		{
			String currency_code_for_bg_qry="Select CURRENCY_CODE from bl_blng_grp where blng_grp_id= ? ";
			pstmt = con.prepareStatement( currency_code_for_bg_qry ) ;
			pstmt.setString(1,billing_group);
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_bg_curr_code = rs.getString(1);
				}

				if(str_bg_curr_code == null) str_bg_curr_code="";

				if (rs != null) rs.close();
				pstmt.close();	
			}
		}
		else if(calld_frm.equals("cust_pol_change"))
		{
			if(!(policy_type_code.equals("") && cust_code.equals("")))
			{
				try
				{
					String restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U') , DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = ? and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code= ? ";
					String empty_sql_check="N";

					pstmt = con.prepareStatement(restrict_check_sql);
					
					pstmt.setString(1,episode_type);
					pstmt.setString(2,episode_type);
					pstmt.setString(3,episode_type);
					pstmt.setString(4,episode_type);
					pstmt.setString(5,episode_type);
					pstmt.setString(6,episode_type);
					pstmt.setString(7,facility_id);
					pstmt.setString(8,policy_type_code);
					pstmt.setString(9,cust_code);
					pstmt.setString(10,cust_group_code);
										
					rs=pstmt.executeQuery();
					if( rs != null ) 
					{
						empty_sql_check="Y";
						while(rs.next())
						{
							restrict_check = rs.getString(1);
							apprd_amt_restrict_check = rs.getString(2); 
							apprd_days_restrict_check = rs.getString(3); 
							cred_auth_req_yn = rs.getString(4); 
							dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
							cred_auth_mand_capt_yn = rs.getString(6);
							empty_sql_check="N";
						}
					}
					if (rs != null)   rs.close();
					pstmt.close();

					if(empty_sql_check.equals("Y"))
					{
						restrict_check="";
						restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = '**' and a.cust_group_code = ? ";

						pstmt = con.prepareStatement(restrict_check_sql);
						
						pstmt.setString(1,episode_type);
						pstmt.setString(2,episode_type);
						pstmt.setString(3,episode_type);
						pstmt.setString(4,episode_type);
						pstmt.setString(5,episode_type);
						pstmt.setString(6,episode_type);
						pstmt.setString(7,facility_id);
						pstmt.setString(8,policy_type_code);
						pstmt.setString(9,cust_group_code);
						
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
						if (rs != null)   rs.close();
						pstmt.close();
					}
				}
				catch(Exception e)
				{
					//out.println("Exception in restrict_check_sql:"+e);
					e.printStackTrace();
				}

				try
				{
					String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS, a.POLICY_APPROVED_BY FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_GROUP_CODE = ? AND a.CUST_CODE = ? and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code";
					
					pstmt = con.prepareStatement(sql_policy_coverage_basis_ind);
					
					pstmt.setString(1,facility_id);
					pstmt.setString(2,policy_type_code);
					pstmt.setString(3,cust_group_code);
					pstmt.setString(4,cust_code);
					
					rs = pstmt.executeQuery() ;

					String empty_sql_check="N";

					if( rs!= null ) 
					{
						empty_sql_check="Y";
						while( rs.next() )
						{  
							policy_coverage_basis_ind = rs.getString(1);
							policy_approved_by = rs.getString(2);
							empty_sql_check="N";
						}
					}
					if (rs != null)   rs.close();
					pstmt.close();

					if(empty_sql_check.equals("Y"))
					{
						sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS , a.POLICY_APPROVED_BY FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_GROUP_CODE = ? AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code and b.cust_code= ? ";
						
						pstmt = con.prepareStatement(sql_policy_coverage_basis_ind);
						
						pstmt.setString(1,facility_id);
						pstmt.setString(2,policy_type_code);
						pstmt.setString(3,cust_group_code);
						pstmt.setString(4,cust_code);
							
						rs = pstmt.executeQuery() ;

						if( rs!= null ) 
						{
							while( rs.next() )
							{  
								policy_coverage_basis_ind = rs.getString(1);
								policy_approved_by = rs.getString(2);
							}
						}
						if (rs != null)   rs.close();
						pstmt.close();
					}
				}		
				catch(Exception e)
				{
					//out.println("Exception in sql_policy_coverage_basis_ind:"+e);
					e.printStackTrace();
				}
			}
			if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
			if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
			if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
			if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
			if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
			if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";
			if(policy_coverage_basis_ind == null) policy_coverage_basis_ind =" ";
			if(policy_approved_by == null) policy_approved_by = "";
			if(restrict_check.equals("R"))
			{
				restricted_YN="";
				
				if(apprd_amt_restrict_check.equals("U"))
				{
					v_display_hide_apprvd_amt = "display:none";
					credit_apprd_amt="";
				}

				if(apprd_days_restrict_check.equals("U"))
				{
					v_display_hide_apprvd_days = "display:none";
					credit_apprd_days="";
				}
			}
			else if(restrict_check.equals("U"))
			{
				restricted_YN="DISABLED";
				v_display_hide="display:none";
				v_display_hide_apprvd_amt = "display:none";
				v_display_hide_apprvd_days = "display:none";
				credit_apprd_amt="";
				credit_apprd_days="";
			}
			if(cred_auth_req_yn.equals("Y"))
			{
				v_display_hide_cred_auth = "display:inline";
/*
				if(dflt_auth_ref_as_pol_no_yn.equals("Y"))
				{
					if(!policy_no.equals("") && credit_auth_ref.equals(""))
					{
						int policy_no_len = policy_no.length();
						if(policy_no_len <=20 )
							credit_auth_ref = policy_no.substring(0,policy_no_len);
						else
							credit_auth_ref = policy_no.substring(0,20);
					}
				}
				if(credit_auth_date.equals(""))
				{
					credit_auth_date = encounter_date_aft_trunc;
				}
*/
			}
			else
			{
				v_display_hide_cred_auth = "display:none";
//				credit_auth_ref = "";
//				credit_auth_date = "";
			}
		}
		else if(calld_frm.equals("gl_enc_chk"))
		{
			String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC, NO_OF_ENC_GL_VALID, NO_OF_OP_ENC_GL_VALID, NO_OF_AE_ENC_GL_VALID, NO_OF_IP_ENC_GL_VALID, NO_OF_DC_ENC_GL_VALID,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID= ? AND PATIENT_ID= ? AND CUST_GROUP_CODE= ? AND CUST_CODE= ? and LANGUAGE_ID= ? ";
	
			if(!gl_holder_name.equals(""))
			{
				qry_gl_chk = qry_gl_chk + " and GL_HOLDER_NAME=?";
			}
			pstmt = con.prepareStatement(qry_gl_chk);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,cust_group_code);
			pstmt.setString(4,cust_code);
			pstmt.setString(5,locale);
			
			if(!gl_holder_name.equals(""))
			{
			pstmt.setString(6,gl_holder_name);
			}
			rs = pstmt.executeQuery() ;
			
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					credit_doc_ref_desc = rs.getString(1);
					if(credit_doc_ref_desc == null) credit_doc_ref_desc="";
					if(credit_doc_ref_desc.equals(doc_ref))
					{
						gl_doc_ref_exist_YN = "Y";
						no_of_enc_gl_valid= rs.getString(2);
						if(no_of_enc_gl_valid == null) no_of_enc_gl_valid=" ";

						no_of_op_enc_gl_valid= rs.getString(3);
						if(no_of_op_enc_gl_valid == null) no_of_op_enc_gl_valid=" ";

						no_of_ae_enc_gl_valid= rs.getString(4);
						if(no_of_ae_enc_gl_valid == null) no_of_ae_enc_gl_valid=" ";

						no_of_ip_enc_gl_valid= rs.getString(5);
						if(no_of_ip_enc_gl_valid == null) no_of_ip_enc_gl_valid=" ";

						no_of_dc_enc_gl_valid= rs.getString(6);
						if(no_of_dc_enc_gl_valid == null) no_of_dc_enc_gl_valid=" ";

						no_of_op_enc_gl_availed= rs.getString(7);
						if(no_of_op_enc_gl_availed == null) no_of_op_enc_gl_availed="0";
	
						no_of_ae_enc_gl_availed= rs.getString(8);
						if(no_of_ae_enc_gl_availed == null) no_of_ae_enc_gl_availed="0";

						no_of_ip_enc_gl_availed= rs.getString(9);
						if(no_of_ip_enc_gl_availed == null) no_of_ip_enc_gl_availed="0";

						no_of_dc_enc_gl_availed= rs.getString(10);
						if(no_of_dc_enc_gl_availed == null) no_of_dc_enc_gl_availed="0";

						int num_no_of_op_enc_gl_availed = Integer.parseInt(no_of_op_enc_gl_availed);
						int num_no_of_ae_enc_gl_availed = Integer.parseInt(no_of_ae_enc_gl_availed);
						int num_no_of_ip_enc_gl_availed = Integer.parseInt(no_of_ip_enc_gl_availed);
						int num_no_of_dc_enc_gl_availed = Integer.parseInt(no_of_dc_enc_gl_availed);

						int num_no_of_enc_gl_availed = num_no_of_op_enc_gl_availed+num_no_of_ae_enc_gl_availed+num_no_of_ip_enc_gl_availed+num_no_of_dc_enc_gl_availed;

						no_of_enc_gl_availed=Integer.toString(num_no_of_enc_gl_availed);
					}
					else
					{
						gl_doc_ref_exist_YN = "N";
						no_of_enc_gl_valid=" ";
						no_of_op_enc_gl_valid=" ";
						no_of_ae_enc_gl_valid=" ";
						no_of_ip_enc_gl_valid=" ";
						no_of_dc_enc_gl_valid=" ";
						no_of_enc_gl_availed="0";
						no_of_op_enc_gl_availed="0";
						no_of_ae_enc_gl_availed="0";
						no_of_ip_enc_gl_availed="0";
						no_of_dc_enc_gl_availed="0";
					}
				}
			}
			if(gl_doc_ref_exist_YN.equals("N"))
			{
				no_of_enc_gl_valid=" ";
				no_of_op_enc_gl_valid=" ";
				no_of_ae_enc_gl_valid=" ";
				no_of_ip_enc_gl_valid=" ";
				no_of_dc_enc_gl_valid=" ";
				no_of_enc_gl_availed="0";
				no_of_op_enc_gl_availed="0";
				no_of_ae_enc_gl_availed="0";
				no_of_ip_enc_gl_availed="0";
				no_of_dc_enc_gl_availed="0";
			}

		}
		else if(calld_frm.equals("pocy_date_valid")) // New Loop for pocy_date_valid added for GHL-0020 SCRUM CRF
		{
			try
			{
					/*String pocy_date_valid="select  ADDL_DAYS_POLICY_EXPDT,To_Char (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')+ADDL_DAYS_POLICY_EXPDT,'DD/MM/YYYY') SYS1, to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys from BL_INS_POLICY_TYPE_HDR 	where CUST_GROUP_CODE   = '"+cust_group_code+"' and POLICY_TYPE_CODE  ='"+policy_type_code +"' and CUST_CODE = '"+cust_code+"'  AND   DEF_REQ_POLICY_DATES='Y'";
					*/
					String pocy_date_valid="SELECT addl_days_policy_expdt,to_char(to_date(?,'dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date(?, 'dd/mm/yyyy HH24:MI')), 'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID= ? AND cust_group_code = ? AND policy_type_code = ? AND (cust_code = ? OR (cust_code <> ? AND cust_code = '**')) AND def_req_policy_dates = 'Y'";

					pstmt = con.prepareStatement(pocy_date_valid) ;
					pstmt.setString(1,encounter_date_time);
					pstmt.setString(2,encounter_date_time);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,cust_group_code);
					pstmt.setString(5,policy_type_code);
					pstmt.setString(6,cust_code);
					pstmt.setString(7,cust_code);
					rs = pstmt.executeQuery();
					if( rs != null ) 
					{
						while(rs.next())
						{
							addl_days_policy_expdt=rs.getString(1);
							days_policy_strtdt=rs.getString(3);
							days_policy_expdt=rs.getString(2);
							System.out.println("@@@@1addl_days_policy_expdt"+addl_days_policy_expdt);
							System.out.println("@@@@1days_policy_strtdt"+days_policy_strtdt);
							System.out.println("@@@@1days_policy_expdt"+days_policy_expdt);
							System.out.println("@@@@2days_policy_strtdt"+com.ehis.util.DateUtils.convertDate(days_policy_strtdt,"DMY",locale,"en"));
							System.out.println("@@@@2days_policy_expdt"+com.ehis.util.DateUtils.convertDate(days_policy_expdt,"DMY",locale,"en"));

						}
					}
					if(addl_days_policy_expdt == null) addl_days_policy_expdt="";
					if(days_policy_strtdt == null) days_policy_strtdt="";
					if(days_policy_expdt == null) days_policy_expdt="";

					if(rs != null) rs.close();
					pstmt.close();
			}
			catch(Exception ex)
			{
					System.err.println("Exception in Policy Start and Expiry date validation in BLInsuranceValidations.jsp"+ex);
					ex.printStackTrace();
			}
		}
		else if(calld_frm.equals("ins_dtls_post"))
		{
			String action = request.getParameter("action");
			if(action == null) action="";

			String locn = request.getParameter("locn");
			if(locn == null) locn="";

//			String bean_id = "BLPatRegChargesBean" ;
//			String bean_name = "eBL.BLPatRegChargesBean";
	//		BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id, bean_name, request ) ;

//			bean.clearBean();	

			String str_total_records = request.getParameter("total_records");
			if(str_total_records == null) str_total_records="0";
			int tot_rec = Integer.parseInt(str_total_records);

			ArrayList existing_records_array=new ArrayList();
			HashMap hm = new HashMap();

			if(tot_rec > 0)
			{
				for(int i=0;i<tot_rec;i++)
				{
					String policy_start_date_conv=request.getParameter("policy_start_date"+i);
						if(policy_start_date_conv==null) policy_start_date_conv="";
					
					String policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
						if(policy_exp_date_conv==null) policy_exp_date_conv="";

					String credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
						if(credit_auth_date_conv==null) credit_auth_date_conv="";

					String policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
						if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
		
					String policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
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

					String[] records=new String[39];
					String billing_group_desc=request.getParameter("billing_group_desc"+i);
					if(billing_group_desc==null) billing_group_desc="";
					records[0]=billing_group_desc;
					records[1]=request.getParameter("blng_grp_code"+i);
					String existing_blng_grp_name=records[1];
					records[2]=request.getParameter("payer_desc"+i);
					records[3]=request.getParameter("cust_3"+i);
					records[4]=request.getParameter("priority"+i);
					records[5]=request.getParameter("policy_type_desc"+i);
					records[6]=request.getParameter("policy_type_code"+i);
					records[7]=request.getParameter("policy_no"+i);
	//				records[8]=request.getParameter("policy_start_date"+i);
					records[8]=policy_start_date_conv;
	//				records[9]=request.getParameter("policy_exp_date"+i);
					records[9]=policy_exp_date_conv;
					records[10]=request.getParameter("credit_auth_ref"+i);
	//				records[11]=request.getParameter("credit_auth_date"+i);
					records[11]=credit_auth_date_conv;
					records[12]=request.getParameter("credit_apprd_amt"+i);
					records[13]=request.getParameter("credit_apprd_days"+i);
	//				records[14]=request.getParameter("policy_eff_frm_date"+i);
					records[14]=policy_eff_frm_date_conv;
	//				records[15]=request.getParameter("policy_eff_to_date"+i);
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

					existing_records_array.add(records);
				}
			}


			hm.put("existing_records_array",existing_records_array);
			hm.put("total_records",str_total_records);
			
			if(locn.equals("inside") /*|| action.equals("add_more_bg")*/)
			{
				session.setAttribute("ins_pol_dtls_for_addl_bg",(HashMap)hm);
			}
			else
			{
				session.setAttribute("ins_pol_dtls",(HashMap)hm);
			}

//			bean.setFinDtls(hm);
//			putObjectInBean(bean_id,bean,request);
/*
			HashMap finDtls_temp		= new HashMap();
//			finDtls_temp = (HashMap)bean.getFinDtls();
			finDtls_temp =(HashMap) session.getAttribute("ins_pol_dtls");
			ArrayList existing_records_array1 = (ArrayList)finDtls_temp.get("existing_records_array");

			for(int i=0;i<existing_records_array1.size();i++)
			{
				String[] records = (String[]) existing_records_array1.get(i);
				for(int j=0;j<records.length;j++)
				{
					System.err.println("existing_records_array:"+records[j]);
				}
			}
*/
		}
		else if(calld_frm.equals("pol_eff_dates_check"))
		{
			String checked_row ="";
			int checked_row_cur = 0;

			String locn = request.getParameter("locn");
			if(locn == null) locn="";

			String action = request.getParameter("action");
			if(action == null) action="";

			String blng_grp_code_cur = request.getParameter("blng_grp_code");
			if(blng_grp_code_cur == null) blng_grp_code_cur="";

			String payer_group_code_cur = request.getParameter("payer_group_code");
			if(payer_group_code_cur == null) payer_group_code_cur="";

			String payer_code_cur = request.getParameter("payer_code");
			if(payer_code_cur == null) payer_code_cur="";

			String policy_type_code_cur = request.getParameter("policy_type_code");
			if(policy_type_code_cur == null) policy_type_code_cur="";

			String policy_no_cur = request.getParameter("policy_no");
			if(policy_no_cur == null) policy_no_cur="";

			String str_priority_cur = request.getParameter("priority");
			if(str_priority_cur == null) str_priority_cur="";

			int priority_cur = Integer.parseInt(str_priority_cur);

			String policy_start_date_cur = request.getParameter("policy_start_date");
			if(policy_start_date_cur == null) policy_start_date_cur="";

			String policy_exp_date_cur = request.getParameter("policy_exp_date");
			if(policy_exp_date_cur == null) policy_exp_date_cur="";

			String policy_eff_frm_date_cur = request.getParameter("policy_eff_frm_date");
			if(policy_eff_frm_date_cur == null) policy_eff_frm_date_cur="";

			String policy_eff_to_date_cur = request.getParameter("policy_eff_to_date");
			if(policy_eff_to_date_cur == null) policy_eff_to_date_cur="";

			if(policy_eff_to_date_cur.equals("") || policy_eff_to_date_cur == null)
				policy_eff_to_date_cur = policy_exp_date_cur;
			
			if(action.equals("modify"))
			{
				checked_row = request.getParameter("checked_row");
				if(checked_row == null) checked_row="";

				checked_row_cur = Integer.parseInt(checked_row);
			}
			
//			String bean_id = "BLPatRegChargesBean" ;
//			String bean_name = "eBL.BLPatRegChargesBean";
//			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id, bean_name, request ) ;
//			bean			= (BLPatRegChargesBean)getBeanObject( "BLPatRegChargesBean", "eBL.BLPatRegChargesBean", request ) ;
//			bean.clearBean();	

			ArrayList existing_records_array = new ArrayList();
			ArrayList existing_records_array_addl = new ArrayList();
		
			HashMap finDtls_temp		= new HashMap();
			HashMap finDtls_addl_bg		= new HashMap();
			String str_total_records="", str_total_records_addl="";
			int tot_rec = 0, tot_rec_addl = 0;
//			finDtls_temp = (HashMap)bean.getFinDtls();
//			if(finDtls_temp == null)
//			{
				finDtls_temp = (HashMap) session.getAttribute("ins_pol_dtls");
				finDtls_addl_bg = (HashMap) session.getAttribute("ins_pol_dtls_for_addl_bg");
//			}
			if(locn.equals("inside"))
			{
				str_total_records = (String) finDtls_addl_bg.get("total_records");
				if(str_total_records == null) str_total_records="0";
				tot_rec = Integer.parseInt(str_total_records);

				existing_records_array = (ArrayList)finDtls_addl_bg.get("existing_records_array");

				str_total_records_addl = (String) finDtls_temp.get("total_records");
				if(str_total_records_addl == null) str_total_records_addl="0";
				tot_rec_addl = Integer.parseInt(str_total_records_addl);

				existing_records_array_addl = (ArrayList)finDtls_temp.get("existing_records_array");
			}
			else
			{
				str_total_records = (String) finDtls_temp.get("total_records");
				if(str_total_records == null) str_total_records="0";
				tot_rec = Integer.parseInt(str_total_records);

				existing_records_array = (ArrayList)finDtls_temp.get("existing_records_array");
			}

			for(int i=0;i<tot_rec;i++)
			{
				if((action.equals("modify") && i != checked_row_cur) || !action.equals("modify"))
				{
					String[] records = (String[]) existing_records_array.get(i);

					String payer_group_code_rec = (String)records[25];	
					String payer_code_rec = (String)records[3];	
					String policy_type_code_rec = (String)records[6];	
					String policy_no_rec = (String)records[7];	
					String str_priority_rec = (String)records[4];	
					int priority_rec=Integer.parseInt(str_priority_rec);
		
					String policy_eff_frm_date_rec=(String)records[14];	
					if(policy_eff_frm_date_rec==null) policy_eff_frm_date_rec="";
					policy_eff_frm_date_rec=policy_eff_frm_date_rec.trim();
					if(!policy_eff_frm_date_rec.equals(""))
					{
						policy_eff_frm_date_rec=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_rec,"DMY","en",locale);
					}

					String policy_eff_to_date_rec=(String)records[15];	
					if(policy_eff_to_date_rec==null) policy_eff_to_date_rec="";
					policy_eff_to_date_rec=policy_eff_to_date_rec.trim();
					if(!policy_eff_to_date_rec.equals(""))
					{
						policy_eff_to_date_rec=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_rec,"DMY","en",locale);
					}

					String policy_exp_date_rec=(String)records[9];	
					if(policy_exp_date_rec==null) policy_exp_date_rec="";
					policy_exp_date_rec=policy_exp_date_rec.trim();
					if(!policy_exp_date_rec.equals(""))
					{
						policy_exp_date_rec=com.ehis.util.DateUtils.convertDate(policy_exp_date_rec,"DMY","en",locale);
					}
					if(policy_eff_to_date_rec == null || policy_eff_to_date_rec.equals(""))
						policy_eff_to_date_rec = policy_exp_date_rec;

					if(payer_group_code_cur.equals(payer_group_code_rec))
					{
						if(payer_code_cur.equals(payer_code_rec))
						{
							if(policy_type_code_cur.equals(policy_type_code_rec))
							{
								if(policy_no_cur.equalsIgnoreCase(policy_no_rec))
								{
									if(com.ehis.util.DateUtils.isBetween(policy_eff_frm_date_rec,policy_eff_to_date_rec,policy_eff_frm_date_cur,"DMY",locale))
									{
										overlap_YN = "Y";
									}
									else if((com.ehis.util.DateUtils.isBefore(policy_eff_frm_date_cur,policy_eff_to_date_rec,"DMY",locale) || com.ehis.util.DateUtils.isBefore(policy_eff_to_date_cur,policy_eff_to_date_rec,"DMY",locale)) && priority_cur != priority_rec && priority_cur > priority_rec)
									{
										overlap_YN = "Y";
									}
									else if((com.ehis.util.DateUtils.isAfter(policy_eff_frm_date_cur,policy_eff_frm_date_rec,"DMY",locale) || com.ehis.util.DateUtils.isAfter(policy_eff_to_date_cur,policy_eff_frm_date_rec,"DMY",locale)) && priority_cur != priority_rec && priority_cur < priority_rec)
									{
										overlap_YN = "Y";
									}
									else
									{
										overlap_YN = "N";
									}
								}
							}
						}
					}
				}
			}

			if(overlap_YN.equals("N"))
			{
				for(int i=0;i<tot_rec_addl;i++)
				{
					String[] records = (String[]) existing_records_array_addl.get(i);

					String payer_group_code_rec = (String)records[25];	
					String payer_code_rec = (String)records[3];	
					String policy_type_code_rec = (String)records[6];	
					String policy_no_rec = (String)records[7];	
					String str_priority_rec = (String)records[4];	
					int priority_rec=Integer.parseInt(str_priority_rec);
		
					String policy_eff_frm_date_rec=(String)records[14];	
					if(policy_eff_frm_date_rec==null) policy_eff_frm_date_rec="";
					policy_eff_frm_date_rec=policy_eff_frm_date_rec.trim();
					if(!policy_eff_frm_date_rec.equals(""))
					{
						policy_eff_frm_date_rec=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_rec,"DMY","en",locale);
					}

					String policy_eff_to_date_rec=(String)records[15];	
					if(policy_eff_to_date_rec==null) policy_eff_to_date_rec="";
					policy_eff_to_date_rec=policy_eff_to_date_rec.trim();
					if(!policy_eff_to_date_rec.equals(""))
					{
						policy_eff_to_date_rec=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_rec,"DMY","en",locale);
					}
					if(payer_group_code_cur.equals(payer_group_code_rec))
					{
						if(payer_code_cur.equals(payer_code_rec))
						{
							if(policy_type_code_cur.equals(policy_type_code_rec))
							{
								if(policy_no_cur.equalsIgnoreCase(policy_no_rec))
								{
									if(com.ehis.util.DateUtils.isBetween(policy_eff_frm_date_rec,policy_eff_to_date_rec,policy_eff_frm_date_cur,"DMY",locale))
									{
										overlap_YN = "Y";
									}
									else if((com.ehis.util.DateUtils.isBefore(policy_eff_frm_date_cur,policy_eff_to_date_rec,"DMY",locale) || com.ehis.util.DateUtils.isBefore(policy_eff_to_date_cur,policy_eff_to_date_rec,"DMY",locale)) && priority_cur != priority_rec && priority_cur > priority_rec)
									{
										overlap_YN = "Y";
									}
									else if((com.ehis.util.DateUtils.isAfter(policy_eff_frm_date_cur,policy_eff_frm_date_rec,"DMY",locale) || com.ehis.util.DateUtils.isAfter(policy_eff_to_date_cur,policy_eff_frm_date_rec,"DMY",locale)) && priority_cur != priority_rec && priority_cur < priority_rec)
									{
										overlap_YN = "Y";
									}
									else
									{
										overlap_YN = "N";
									}
								}
							}
						}
					}
				}
			}
		}
		else if(calld_frm.equals("chk_for_rltd_policies"))
		{
			String checked_row ="";
			int checked_row_cur = 0;

			String action = request.getParameter("action");
			if(action == null) action="";

			String locn = request.getParameter("locn");
			if(locn == null) locn="";

			String blng_grp_code_cur = request.getParameter("blng_grp_code");
			if(blng_grp_code_cur == null) blng_grp_code_cur="";

			String payer_group_code_cur = request.getParameter("payer_group_code");
			if(payer_group_code_cur == null) payer_group_code_cur="";

			String payer_code_cur = request.getParameter("payer_code");
			if(payer_code_cur == null) payer_code_cur="";

			String policy_type_code_cur = request.getParameter("policy_type_code");
			if(policy_type_code_cur == null) policy_type_code_cur="";

			String policy_no_cur = request.getParameter("policy_no");
			if(policy_no_cur == null) policy_no_cur="";

			String str_priority_cur = request.getParameter("priority");
			if(str_priority_cur == null) str_priority_cur="";

			int priority_cur = Integer.parseInt(str_priority_cur);

			if(action.equals("modify"))
			{
				checked_row = request.getParameter("checked_row");
				if(checked_row == null) checked_row="";

				checked_row_cur = Integer.parseInt(checked_row);
			}

			String policy_start_date_cur = request.getParameter("policy_start_date");
			if(policy_start_date_cur == null) policy_start_date_cur="";

			String policy_exp_date_cur = request.getParameter("policy_exp_date");
			if(policy_exp_date_cur == null) policy_exp_date_cur="";

			if(!policy_start_date_cur.equals(""))
			{
				policy_start_date_cur=com.ehis.util.DateUtils.convertDate(policy_start_date_cur,"DMY","en",locale);
			}

			if(!policy_exp_date_cur.equals(""))
			{
				policy_exp_date_cur=com.ehis.util.DateUtils.convertDate(policy_exp_date_cur,"DMY","en",locale);
			}

			ArrayList existing_records_array = new ArrayList();
			ArrayList existing_records_array_addl = new ArrayList();
			int least_priority = 0;

			HashMap finDtls_temp		= new HashMap();
			HashMap finDtls_addl_bg		= new HashMap();
			String str_total_records="", str_total_records_addl="";
			int tot_rec = 0, tot_rec_addl = 0;
//			finDtls_temp = (HashMap)bean.getFinDtls();
//			if(finDtls_temp == null)
//			{
				finDtls_temp = (HashMap) session.getAttribute("ins_pol_dtls");
				finDtls_addl_bg = (HashMap) session.getAttribute("ins_pol_dtls_for_addl_bg");
//			}
			if(locn.equals("inside"))
			{
				str_total_records = (String) finDtls_addl_bg.get("total_records");
				if(str_total_records == null) str_total_records="0";
				tot_rec = Integer.parseInt(str_total_records);

				existing_records_array = (ArrayList)finDtls_addl_bg.get("existing_records_array");

				str_total_records_addl = (String) finDtls_temp.get("total_records");
				if(str_total_records_addl == null) str_total_records_addl="0";
				tot_rec_addl = Integer.parseInt(str_total_records_addl);

				existing_records_array_addl = (ArrayList)finDtls_temp.get("existing_records_array");
			}
			else
			{
				str_total_records = (String) finDtls_temp.get("total_records");
				if(str_total_records == null) str_total_records="0";
				tot_rec = Integer.parseInt(str_total_records);

				existing_records_array = (ArrayList)finDtls_temp.get("existing_records_array");
			}

			if(tot_rec > 1 || (tot_rec == 1 && (action.equals("add") || action.equals("add_more_bg"))))
			{
				for(int i=0;i<tot_rec;i++)
				{
					if((action.equals("modify") && i != checked_row_cur) || !action.equals("modify"))
					{
						String[] records = (String[]) existing_records_array.get(i);

						String payer_group_code_rec = (String)records[25];	
						String payer_code_rec = (String)records[3];	
						String policy_type_code_rec = (String)records[6];	
						String policy_no_rec = (String)records[7];	
						String str_priority_rec = (String)records[4];	
						int priority_rec=Integer.parseInt(str_priority_rec);

						String policy_start_date_rec=(String)records[8];	
						if(policy_start_date_rec==null) policy_start_date_rec="";
						policy_start_date_rec=policy_start_date_rec.trim();

						String policy_exp_date_rec=(String)records[9];	
						if(policy_exp_date_rec==null) policy_exp_date_rec="";
						policy_exp_date_rec=policy_exp_date_rec.trim();

						if(!policy_start_date_rec.equals(""))
						{
							policy_start_date_rec=com.ehis.util.DateUtils.convertDate(policy_start_date_rec,"DMY","en",locale);
						}

						if(!policy_exp_date_rec.equals(""))
						{
							policy_exp_date_rec=com.ehis.util.DateUtils.convertDate(policy_exp_date_rec,"DMY","en",locale);
						}
						if(payer_group_code_cur.equals(payer_group_code_rec))
						{
							if(payer_code_cur.equals(payer_code_rec))
							{
								if(policy_type_code_cur.equals(policy_type_code_rec))
								{
									if(policy_no_cur.equalsIgnoreCase(policy_no_rec))
									{
										if(priority_cur < priority_rec)
										{
											least_priority = priority_cur;
										}
										else if(priority_cur > priority_rec)
										{
											least_priority = priority_rec;
										}
										else
										{
											least_priority = priority_cur;
										}
										rltd_policies_rec_avail_YN = "Y";
										rltd_pol_start_date = policy_start_date_rec;
										rltd_pol_exp_date = policy_exp_date_rec;
									}
								}
							}
						}
					}
				}
			}
			else
			{
				rltd_policies_rec_avail_YN = "N";
				rltd_pol_start_date = policy_start_date_cur;
				rltd_pol_exp_date = policy_exp_date_cur;
			}
			if(!rltd_policies_rec_avail_YN.equals("Y"))
			{
				rltd_policies_rec_avail_YN = "N";
				rltd_pol_start_date = policy_start_date_cur;
				rltd_pol_exp_date = policy_exp_date_cur;
			}

			if(rltd_policies_rec_avail_YN.equals("N"))
			{
				for(int i=0;i<tot_rec_addl;i++)
				{
					String[] records = (String[]) existing_records_array_addl.get(i);

					String payer_group_code_rec = (String)records[25];	
					String payer_code_rec = (String)records[3];	
					String policy_type_code_rec = (String)records[6];	
					String policy_no_rec = (String)records[7];	
					String str_priority_rec = (String)records[4];	
					int priority_rec=Integer.parseInt(str_priority_rec);

					String policy_start_date_rec=(String)records[8];	
					if(policy_start_date_rec==null) policy_start_date_rec="";
					policy_start_date_rec=policy_start_date_rec.trim();

					String policy_exp_date_rec=(String)records[9];	
					if(policy_exp_date_rec==null) policy_exp_date_rec="";
					policy_exp_date_rec=policy_exp_date_rec.trim();

					if(!policy_start_date_rec.equals(""))
					{
						policy_start_date_rec=com.ehis.util.DateUtils.convertDate(policy_start_date_rec,"DMY","en",locale);
					}

					if(!policy_exp_date_rec.equals(""))
					{
						policy_exp_date_rec=com.ehis.util.DateUtils.convertDate(policy_exp_date_rec,"DMY","en",locale);
					}
					if(rltd_policies_rec_avail_YN.equals("N"))
					{
						if(payer_group_code_cur.equals(payer_group_code_rec))
						{
							if(payer_code_cur.equals(payer_code_rec))
							{
								if(policy_type_code_cur.equals(policy_type_code_rec))
								{
									if(policy_no_cur.equalsIgnoreCase(policy_no_rec))
									{
										if(priority_cur < priority_rec)
										{
											least_priority = priority_cur;
										}
										else if(priority_cur > priority_rec)
										{
											least_priority = priority_rec;
										}
										else
										{
											least_priority = priority_cur;
										}
										rltd_policies_rec_avail_YN = "Y";
										rltd_pol_start_date = policy_start_date_rec;
										rltd_pol_exp_date = policy_exp_date_rec;
									}
								}
							}
						}
					}
				}
			}
			if(!rltd_policies_rec_avail_YN.equals("Y"))
			{
				rltd_policies_rec_avail_YN = "N";
				rltd_pol_start_date = policy_start_date_cur;
				rltd_pol_exp_date = policy_exp_date_cur;
			}
			if(least_priority == priority_cur)
			{
				cur_pol_least_prio_YN = "Y";
			}
			else
			{
				cur_pol_least_prio_YN = "N";
			}
		}
	
		if(calld_frm.equals("adj_rul"))
		{
			if(!(cust_code==null || cust_code.equals("")))
			{									
				out.println(adj_rule_ind+"&^&"+adj_perc_amt_ind+"&^&"+adj_perc_amt_value+"&^&"+pmnt_diff_adj_int+"&^&"+drg_pmnt_diff_adj_int+"&^&"+spl_srv_pmnt_diff_adj_int+"&^&"+pmnt_diff_adj_int_desc);
			}
		}
		else if(calld_frm.equals("bg_curr_code"))
		{
			out.println(str_bg_curr_code);
		}
		else if(calld_frm.equals("cust_pol_change"))
		{
			out.println(restrict_check+"/"+apprd_amt_restrict_check+"/"+apprd_days_restrict_check+"/"+cred_auth_req_yn+"/"+dflt_auth_ref_as_pol_no_yn+"/"+policy_coverage_basis_ind+"/"+cred_auth_mand_capt_yn+"/"+policy_approved_by);
		}
		else if(calld_frm.equals("gl_enc_chk"))
		{
			out.println(gl_doc_ref_exist_YN+"/"+no_of_enc_gl_valid+"/"+no_of_op_enc_gl_valid+"/"+no_of_ae_enc_gl_valid+"/"+no_of_ip_enc_gl_valid+"/"+no_of_dc_enc_gl_valid+"/"+no_of_enc_gl_availed+"/"+no_of_op_enc_gl_availed+"/"+no_of_ae_enc_gl_availed+"/"+no_of_ip_enc_gl_availed+"/"+no_of_dc_enc_gl_availed);
		}
		else if(calld_frm.equals("pocy_date_valid")) // New Loop for pocy_date_valid added for GHL-0020 SCRUM CRF
		{
			out.println(days_policy_strtdt+"&^&"+days_policy_expdt);
		}
		else if(calld_frm.equals("pol_eff_dates_check"))
		{
			out.println(overlap_YN);
		}
		else if(calld_frm.equals("chk_for_rltd_policies"))
		{
			out.println(rltd_policies_rec_avail_YN+"&^&"+rltd_pol_start_date+"&^&"+rltd_pol_exp_date+"&^&"+cur_pol_least_prio_YN);
		}
		/* 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts*/
		else if(calld_frm.equals("chk_validity_across_encounters"))
		{
			
		String acr_enc_cust_group_code=request.getParameter("cust_group_code");
		String acr_enc_cust_code=request.getParameter("cust_code");
		String acr_enc_policy_type_code=request.getParameter("policy_type_code");	
		String patientID =  request.getParameter("patient_id");
		String patClass=request.getParameter("patClass");
			
		/* 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 */
		String across_encounter =  request.getParameter("across_encounter");
		String acr_enc_priority=request.getParameter("priority");
			HashMap validAcrossEncMap = (HashMap)session.getAttribute("VALID_ACROSS_ENCOUNTER_MAP");
			if(validAcrossEncMap==null){
			validAcrossEncMap=new HashMap();
			}
			if(across_encounter!=null && across_encounter.length() >0 && acr_enc_policy_type_code.length() > 0 && acr_enc_priority.length() >0 )
			{
			validAcrossEncMap.put(acr_enc_policy_type_code+acr_enc_priority,across_encounter);
			session.setAttribute("VALID_ACROSS_ENCOUNTER_MAP",validAcrossEncMap);
			}
				
		/* 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 */
			
			String qryPart=" where   a.ACROSS_ENCOUNTERS_YN = 'Y'  ";
			if(patClass.equalsIgnoreCase("OP")){
			qryPart=" where   a.ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}
			if(patClass.equalsIgnoreCase("IP")){
			qryPart=" where   a.IP_ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}
			if(patClass.equalsIgnoreCase("EX")){
			qryPart=" where   a.EX_ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}		
			
			
		//	con	=	ConnectionManager.getConnection(request);	//V211020
			
			
			String query_ref_source =
			" select count(*)    "+
			" from bl_ins_policy_type_hdr a,bl_ins_policy_addl_hdr b  "+
			qryPart+
			" and  B.ACROSS_ENC_GROUP_ID is not null  "+
			" and  a.cust_group_code = b.cust_group_code  "+
			" and  a. cust_code     =  b.cust_code  "+
			" and  a.policy_Type_code = b.policy_type_code  " +
			" and  b.cust_group_code  = ? " + 
			" and  b.cust_code        = ? " + 
			" and  b.policy_type_code = ? " + 
			" and  b.patient_id =  ? " +
			" and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE) ";
			
			System.err.println(" BLInsuranceValidations:query_ref_source->"+query_ref_source);
			
			pstmt = con.prepareStatement(query_ref_source);	
			pstmt.setString(1,acr_enc_cust_group_code);
			pstmt.setString(2,acr_enc_cust_code);
			pstmt.setString(3,acr_enc_policy_type_code);
			pstmt.setString(4,patientID);
			
			rs = pstmt.executeQuery();
		
			if(rs.next())
			{			
				String count	=	rs.getString(1);
				System.out.println(count);
				
				if(count!=null){
					int recCount=Integer.parseInt(count);
					if(recCount==0){
						out.println("~N");
					}else{
						out.println("~Y");
					}					
				}
				else{
					out.println("~N");
				}				
			}				
		}//else_if
		/* 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends*/
	}//try
	
	catch(Exception e)
	{
		System.out.println("Exception:"+e);
		e.printStackTrace();
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
