<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.Common.BLHelper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt_pack= null;
	Statement stmt1				= null;
	//Connection conn				= null;//V210413
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs_pack				= null;
	String  nid  ="";
	ResultSet rs1				= null;
	CallableStatement call_pkg = null;

	String locale			= (String)session.getAttribute("LOCALE");
	//String sql=""; //V210413
	boolean site_id = false;
	try
	{
		//conn = ConnectionManager.getConnection();	//V210413
		con	=	ConnectionManager.getConnection(request);//V210413
		//site_id = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","DISP_CUST_LONG_DESC");
		site_id = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
		System.err.println("site_id"+site_id);
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}
	finally{
	//	ConnectionManager.returnConnection(conn);//V210413
		System.err.println("Conection closed");
	}
	session.setAttribute( "siteSpecf", site_id );	

	try
  	{
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		//con	=	ConnectionManager.getConnection(request);//V210413
		
		Properties p = (Properties)httpSession.getValue("jdbc");
		String strclientip=p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";		
		
		String strLoggedUser = p.getProperty("login_user");
		if(strLoggedUser == null) strLoggedUser="";
		
//		System.err.println("querstring  in 2.jsp page:"+request.getQueryString());
		String nd_settlement_ind ="",/*ar_install_yn="",*/query_cust="", strEpisodeType="", str_function_id="";
		String nd_adm_rec_flag ="";
		String slmt_type_code="",dflt_slmt_type_code="", cash_slmt_flag="", cust_code1="",ins_auth_flag="";
		String mcash_set_type1="", mcust_1="", mcust_group_1="", mcredit_doc_ref1="", mcredit_doc_date1="", mcredit_doc_start_date1="", mcust_2="",mcust_group_2="";
		String mcredit_doc_ref2="", mcredit_doc_date2="",mcredit_doc_start_date2="", mcust_3="", mins_cust_priority="",mpolicy_type="", mpolicy_no="";
		String mpolicy_start_date="",mpolicy_expiry_date="", mnon_insur_blng_grp="", sys_date="",sys_date_wht_sec="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="",meff_to_date="";	
		String billing_group="";
		String str_cust_grp_code_for_pkg="", str_cust_code_for_pkg="";
		String payerGrpBySetup="";

		String rtn_slmt_type_code="";String rtn_credit_cust_group_code="";String rtn_credit_cust_code="";String rtn_credit_doc_ref="";String rtn_credit_doc_end_date="";String rtn_credit_doc_start_date="";String rtn_sponsor_cust_group_code="";String rtn_sponsor_cust_code="";String rtn_sponsor_credit_doc_ref="";String rtn_sponsor_credit_doc_end_date="";String rtn_sponsor_credit_doc_start_date="";String rtn_ins_cust_group_code="";String rtn_ins_cust_code="";String rtn_ins_cust_priority="";String rtn_ins_policy_type_code="";String rtn_ins_policy_no="";String rtn_ins_policy_start_date="";String rtn_ins_policy_expiry_date="";String rtn_non_ins_blng_grp="";String rtn_ins_credit_auth_ref="";String rtn_ins_credit_auth_date="";String rtn_ins_credit_approval_days="";String rtn_ins_credit_approval_amount="";String rtn_ins_policy_eff_from_date="";String rtn_ins_policy_eff_to_date="";

		String rtn_tot_valid_enc_with_gl="", rtn_tot_valid_op_enc_with_gl="", rtn_tot_valid_ae_enc_with_gl="", rtn_tot_valid_ip_enc_with_gl ="", rtn_tot_valid_dc_enc_with_gl="";

		String rtn_no_of_enc_gl_availed ="0", rtn_no_of_op_enc_gl_availed ="0", rtn_no_of_ae_enc_gl_availed ="0", rtn_no_of_ip_enc_gl_availed= "0", rtn_no_of_dc_enc_gl_availed ="0";

		String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";
		String rtn_gl_doc_ref_exist_YN="N";
		String third_party_gl_in_use_yn ="", third_party_gl_mandatory_yn="";
		String encounter_date_time = "", encounter_date_aft_trunc="";
		String str_valid_pkg_for_pat_bg_avail_YN="N";
		String str_facility_id = (String)httpSession.getValue("facility_id");

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		String strSettlementDesc = "0";
		String billing_mode =(String) request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");

		str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		if(operation==null) operation = "Insert";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		third_party_gl_in_use_yn = request.getParameter("third_party_gl_in_use_yn");
		if(third_party_gl_in_use_yn == null) third_party_gl_in_use_yn="N";

		third_party_gl_mandatory_yn = request.getParameter("third_party_gl_mandatory_yn");
		if(third_party_gl_mandatory_yn == null) third_party_gl_mandatory_yn="N";
		
		//added by sarathkumar 27/june/16 for ML-MMOH-SCF-0399.1 
		//if count is greater than zero then egl should be enabled
		int eglEnableCount=Integer.parseInt(BLHelper.getDescriptionViaSQL(con,"select count(*) from XH_STANDARD_PROFILE where PROFILE_ID ='EGLPROF1' and EFF_STATUS = 'E'"));
		
		payerGrpBySetup = request.getParameter("payerGrpBySetup");
		if(payerGrpBySetup == null) payerGrpBySetup="N";
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
				rtn_credit_cust_group_code=((String)bl_data.get("credit_cust_group_code")).trim();
				rtn_credit_cust_code=((String)bl_data.get("credit_cust_code")).trim();
				rtn_credit_doc_ref=((String)bl_data.get("credit_doc_ref")).trim();
				rtn_credit_doc_start_date=((String)bl_data.get("credit_doc_start_date")).trim();
				rtn_credit_doc_end_date=((String)bl_data.get("credit_doc_end_date")).trim();
				rtn_sponsor_cust_group_code=((String)bl_data.get("sponsor_cust_group_code")).trim();
				rtn_sponsor_cust_code=((String)bl_data.get("sponsor_cust_code")).trim();
				rtn_sponsor_credit_doc_ref=((String)bl_data.get("sponsor_credit_doc_ref")).trim();
				rtn_sponsor_credit_doc_start_date=((String)bl_data.get("sponsor_credit_doc_start_date")).trim();
				rtn_sponsor_credit_doc_end_date=((String)bl_data.get("sponsor_credit_doc_end_date")).trim();
				rtn_ins_cust_group_code=((String)bl_data.get("ins_cust_group_code")).trim();
				rtn_ins_cust_code=((String)bl_data.get("ins_cust_code")).trim();
				rtn_ins_cust_priority=((String)bl_data.get("ins_cust_priority")).trim();
				rtn_ins_policy_type_code=((String)bl_data.get("ins_policy_type_code")).trim();
				rtn_ins_policy_no=((String)bl_data.get("ins_policy_no")).trim();
				rtn_ins_policy_start_date=((String)bl_data.get("ins_policy_start_date")).trim();
				rtn_ins_policy_expiry_date=((String)bl_data.get("ins_policy_expiry_date")).trim();
				rtn_ins_credit_auth_ref=((String)bl_data.get("ins_credit_auth_ref")).trim();
				rtn_ins_credit_auth_date=((String)bl_data.get("ins_credit_auth_date")).trim();
				rtn_ins_credit_approval_days=((String)bl_data.get("ins_credit_approval_days")).trim();
				rtn_ins_credit_approval_amount=((String)bl_data.get("ins_credit_approval_amount")).trim();
				rtn_ins_policy_eff_from_date=((String)bl_data.get("ins_policy_eff_from_date")).trim();
				rtn_ins_policy_eff_to_date=((String)bl_data.get("ins_policy_eff_to_date")).trim();

				rtn_tot_valid_enc_with_gl =((String)bl_data.get("tot_valid_enc_with_gl")).trim();
				rtn_tot_valid_op_enc_with_gl =((String)bl_data.get("tot_valid_op_enc_with_gl")).trim();
				rtn_tot_valid_ae_enc_with_gl =((String)bl_data.get("tot_valid_ae_enc_with_gl")).trim();
				rtn_tot_valid_ip_enc_with_gl =((String)bl_data.get("tot_valid_ip_enc_with_gl")).trim();
				rtn_tot_valid_dc_enc_with_gl =((String)bl_data.get("tot_valid_dc_enc_with_gl")).trim();


				rtn_no_of_enc_gl_availed =((String)bl_data.get("no_of_enc_gl_availed")).trim();
				rtn_no_of_op_enc_gl_availed =((String)bl_data.get("no_of_op_enc_gl_availed")).trim();
				rtn_no_of_ae_enc_gl_availed =((String)bl_data.get("no_of_ae_enc_gl_availed")).trim();
				rtn_no_of_ip_enc_gl_availed =((String)bl_data.get("no_of_ip_enc_gl_availed")).trim();
				rtn_no_of_dc_enc_gl_availed =((String)bl_data.get("no_of_dc_enc_gl_availed")).trim();

				rtn_gl_doc_ref_exist_YN =((String)bl_data.get("gl_doc_ref_exist_YN")).trim();
				
				if(rtn_tot_valid_enc_with_gl == null) rtn_tot_valid_enc_with_gl="";
				if(rtn_tot_valid_op_enc_with_gl == null) rtn_tot_valid_op_enc_with_gl="";
				if(rtn_tot_valid_ae_enc_with_gl == null) rtn_tot_valid_ae_enc_with_gl="";
				if(rtn_tot_valid_ip_enc_with_gl == null) rtn_tot_valid_ip_enc_with_gl="";
				if(rtn_tot_valid_dc_enc_with_gl == null) rtn_tot_valid_dc_enc_with_gl="";

				if(rtn_no_of_enc_gl_availed == null) rtn_no_of_enc_gl_availed="0";
				if(rtn_no_of_op_enc_gl_availed == null) rtn_no_of_op_enc_gl_availed="0";
				if(rtn_no_of_ae_enc_gl_availed == null) rtn_no_of_ae_enc_gl_availed="0";
				if(rtn_no_of_ip_enc_gl_availed == null) rtn_no_of_ip_enc_gl_availed="0";
				if(rtn_no_of_dc_enc_gl_availed == null) rtn_no_of_dc_enc_gl_availed="0";
/*
if(autoFinChk.equals("Y"))
{
	System.err.println("Inside Class Loop in 2.jsp");
	class_code = ((String)bl_data.get("class_code")).trim();
}
*/
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
/*			
HashMap bl_data=(HashMap)session.getAttribute("financial_details");
if(!(bl_data==null || bl_data.isEmpty()))
{
	if(autoFinChk.equals("Y"))
	{
		System.err.println("Inside Class Loop in 2.jsp");
		class_code = ((String)bl_data.get("class_code")).trim();
	}
}
*/
		}
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strCategory = "";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");
		if (strshowHideBlngClass == null) strshowHideBlngClass = "";

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		String str_blng_grp_id = "";
		String str_short_desc = "";	

		String cust_code_1 = "", cust_group_code_1 = "", str_cust_curr_code="",str_cust_curr_desc="";
		String short_name_1 = "", cust_group_desc_1 = "";

		String cust_code_2 = "" , cust_group_code_2 = "";
		String short_name_2 = "", cust_group_desc_2 = "" ;

		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";
		String cust_valid_from_date = "" , cust_valid_to_date = "";
		String  str_charge_logic = "";

		try
		{
			String query_date="select NVL(charge_logic_yn,'N') charge_logic,to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_parameters where operating_facility_id='"+str_facility_id+"'";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{
					str_charge_logic = rs4.getString(1);
					sys_date = rs4.getString(2);
					sys_date_wht_sec = rs4.getString(3);			
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		/* Commented and added below for PE Changes
			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		*/
		}
		catch(Exception e)
		{
			out.println("Exception @ install"+e);
			e.printStackTrace();
		}
		/* Commented for PE Changes and values are passed from AddModifyPatFinDetails.jsp
		try
		{
			String sql2 = "select nvl(third_party_gl_in_use_yn,'N') third_party_gl_in_use_yn, nvl(third_party_gl_mandatory_yn,'N') third_party_gl_mandatory_yn,to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_parameters where operating_facility_id = '"+str_facility_id +"'";
			System.err.println("sql2="+str_facility_id+"/"+sql2);
			pstmt = con.prepareStatement(sql2);
			rs4 = pstmt.executeQuery() ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					third_party_gl_in_use_yn = rs4.getString("third_party_gl_in_use_yn");
					third_party_gl_mandatory_yn = rs4.getString("third_party_gl_mandatory_yn");
					sys_date = rs4.getString(3);
					sys_date_wht_sec = rs4.getString(4);			
				}
			}
			if (rs4 != null) rs4.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in sql2:"+e);
		}
		if (third_party_gl_in_use_yn == null ) third_party_gl_in_use_yn ="";
		if (third_party_gl_mandatory_yn == null ) third_party_gl_mandatory_yn ="";
		*/
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
		encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		//	stmt1 = con.createStatement();
			pstmt=con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
			rs = pstmt.executeQuery() ;
			
			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
			e.printStackTrace();
		}
		if(!encounter_date_aft_trunc.equals(""))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}

		strCitizenYn = request.getParameter("CitizenYn");
		if(strCitizenYn == null) strCitizenYn="N";
		/*		
		if(!patient_id.equals(""))
		{
			String sqlCiti = "select citizen_yn from mp_patient where patient_id ='"+patient_id+"'";
			pstmt = con.prepareStatement(sqlCiti);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
				}
			}
			if(rs2 !=null) rs2.close();
			if(pstmt != null) pstmt.close();	
		}
		*/
		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		/*
			String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg from bl_mp_param ";
			pstmt = con.prepareStatement(sql0);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
			}
			}
			if(pstmt != null) pstmt.close();
			if(rs2 !=null) rs2.close();

			if ( strdfltbgyn == null) strdfltbgyn = "N";
			if ( srtencdfltbgyn == null) srtencdfltbgyn="N";
		*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}
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
		if(rs5 !=null) rs5.close();
		if(pstmt != null) pstmt.close();
		if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		if (l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
		if (l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
		if (l_cust_code == null) l_cust_code = "";
		if (l_slmt_ind == null) l_slmt_ind = "";
		if (l_adm_rec_flag == null) l_adm_rec_flag = "";		
		
		String strCreditDoc_YN="N";
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		String package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";
		String pkg_disc_disp = "";

		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}
		
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
				excep.printStackTrace();
			}
		}
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mcash_set_type1		= rtn_slmt_type_code;// rtn_slmt_type_code
			if ( mcash_set_type1 == null ) mcash_set_type1 ="";			
			
			mcust_group_1	= rtn_credit_cust_group_code;
			if (mcust_group_1 == null) mcust_group_1 = "";
			
			mcust_1				= rtn_credit_cust_code;//rtn_credit_cust_code
			if (mcust_1 == null) mcust_1 = "";			

			mcredit_doc_ref1	= rtn_credit_doc_ref;//rtn_credit_doc_ref
			if ( mcredit_doc_ref1 == null ) mcredit_doc_ref1 = "";			

			mcredit_doc_date1	= rtn_credit_doc_end_date;//rtn_credit_doc_end_date
			if ( mcredit_doc_date1 == null ) mcredit_doc_date1 ="";

			mcredit_doc_start_date1	= rtn_credit_doc_start_date;//rtn_credit_doc_start_date
			if ( mcredit_doc_start_date1 == null ) mcredit_doc_start_date1 = "";

			mcust_group_2		= rtn_sponsor_cust_group_code;
			if(mcust_group_2 == null) mcust_group_2="";

			mcust_2				= rtn_sponsor_cust_code;// rtn_sponsor_cust_code
			if ( mcust_2 == null ) mcust_2 = "";			

			mcredit_doc_ref2	= rtn_sponsor_credit_doc_ref;//rtn_sponsor_credit_doc_ref
			if ( mcredit_doc_ref2 == null ) mcredit_doc_ref2 = "";

			mcredit_doc_date2	= rtn_sponsor_credit_doc_end_date;//rtn_sponsor_credit_doc_end_date
			if ( mcredit_doc_date2 == null ) mcredit_doc_date2 = "";		

			mcredit_doc_start_date2	= rtn_sponsor_credit_doc_start_date;//rtn_sponsor_credit_doc_start_date

			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			if(mcredit_doc_start_date2.equals(""))
			{
				mcredit_doc_start_date2	= rtn_sponsor_credit_doc_start_date;//rtn_sponsor_credit_doc_start_date
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			}				
			
			mcust_3		=rtn_ins_cust_code;//rtn_ins_cust_code 

			if ( mcust_3 == null ) mcust_3 = "";
			mins_cust_priority	= rtn_ins_cust_priority;//rtn_ins_cust_priority

			if ( mins_cust_priority == null ) mins_cust_priority = "";
			mpolicy_type	= rtn_ins_policy_type_code;//rtn_ins_policy_type_code

			if ( mpolicy_type == null ) mpolicy_type = "";
			mpolicy_no	= rtn_ins_policy_no;//rtn_ins_policy_no

			if ( mpolicy_no == null ) mpolicy_no ="";
			mpolicy_start_date	= rtn_ins_policy_start_date;//rtn_ins_policy_start_date

			if ( mcust_3 == null ) mcust_3 = "";
			
			mpolicy_expiry_date = rtn_ins_policy_expiry_date;//rtn_ins_policy_expiry_date
			if ( mpolicy_expiry_date == null ) mpolicy_expiry_date = "";			

			mnon_insur_blng_grp = rtn_non_ins_blng_grp;//rtn_non_ins_blng_grp 
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			mcredit_auth_ref	= rtn_ins_credit_auth_ref;//rtn_ins_credit_auth_ref
			if ( mcredit_auth_ref == null ) mcredit_auth_ref = "";
			
			mcredit_auth_date	= rtn_ins_credit_auth_date;//rtn_ins_credit_auth_date
			if ( mcredit_auth_date == null ) mcredit_auth_date = "";			

			mapp_days			= rtn_ins_credit_approval_days;//rtn_ins_credit_approval_days
			if  ( mapp_days == null ) mapp_days = ""; 

			mapp_amount			= rtn_ins_credit_approval_amount;//rtn_ins_credit_approval_amount 
			if ( mapp_amount == null ) mapp_amount = "";

			meff_frm_date		= rtn_ins_policy_eff_from_date;//rtn_ins_policy_eff_from_date 
			if ( meff_frm_date == null ) meff_frm_date = "";

			meff_to_date		= rtn_ins_policy_eff_to_date;//rtn_ins_policy_eff_to_date 
			if ( meff_to_date == null ) meff_to_date = "";

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

		nd_settlement_ind = request.getParameter("setlmt_ind");
		if(nd_settlement_ind == null) nd_settlement_ind = "";
		nd_adm_rec_flag = request.getParameter("adm_rec_flag");
		if(nd_adm_rec_flag == null) nd_adm_rec_flag = "";

		strCreditDoc_YN = request.getParameter("credit_doc_ref_reqd_yn");
		if(strCreditDoc_YN == null) strCreditDoc_YN = "";
	/* Commented for PE Changes, values are passed from 6.jsp
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		pstmt = con.prepareStatement(sql);
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
		if(rs !=null) rs.close();
		if(pstmt != null) pstmt.close();

		if(nd_settlement_ind==null)nd_settlement_ind="";
		if(nd_adm_rec_flag==null)nd_adm_rec_flag="";	
	*/		

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
		
		if(!patient_id.equals("") && !billing_group.equals(""))
		{
			try
			{
				call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
				call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

				call_pkg.setString(2,str_facility_id);
				call_pkg.setString(3,patient_id);
				call_pkg.setString(4,strEpisodeType);
				call_pkg.setString(5,str_function_id);
				call_pkg.setString(6,billing_group);
				call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
				call_pkg.setString(8,"B");
				if(strCitizenYn.equals("Y"))
				{
					call_pkg.setString(9,"NATIONALS");
				}
				else
				{
					call_pkg.setString(9,"OTHERS");
				}

				call_pkg.execute();							
				str_valid_pkg_for_pat_bg_avail_YN = call_pkg.getString(1);				
				call_pkg.close();
				if ( str_valid_pkg_for_pat_bg_avail_YN == null ) str_valid_pkg_for_pat_bg_avail_YN = "";
			}
			catch(Exception e)
			{
				System.out.println("Exception while chekcing package:"+e.toString());
				out.println("Exception while chekcing package:"+e.toString());
				e.printStackTrace();
			}

			if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
			{
				String sql_pkg_dtl_hdr_qry="SELECT A.CUST_GROUP_CODE,A.CUST_CODE FROM bl_patient_package_hdr A, BL_PRICE_CLASS_LANG_VW B, BL_BLNG_GRP_LANG_VW C WHERE A.operating_facility_id = '"+str_facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' and B.LANGUAGE_ID = C.LANGUAGE_ID and  A.PRICE_CLASS_CODE = B.PRICE_CLASS_CODE AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND A.patient_id = '"+patient_id+"' AND to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY')) AND A.status = 'O' and A.BLNG_GRP_ID='"+billing_group+"'";

				pstmt_pack = con.prepareStatement(sql_pkg_dtl_hdr_qry);
				rs_pack = pstmt_pack.executeQuery() ;

				if( rs_pack != null) 
				{
					while( rs_pack.next() )
					{
						String str_cust_grp_code=rs_pack.getString(1);
						if(str_cust_grp_code == null) str_cust_grp_code="";

						str_cust_grp_code_for_pkg = str_cust_grp_code_for_pkg + str_cust_grp_code + "@@";

						String str_cust_code=rs_pack.getString(2);
						if(str_cust_code == null) str_cust_code="";

						str_cust_code_for_pkg = str_cust_code_for_pkg + str_cust_code + "@@";
					}
				}
				if (rs_pack != null)   rs_pack.close();
				if (pstmt_pack != null) pstmt_pack.close();
			}
		}
		
	//unused variable, commented on 09/06/05
	/*
		try
		{
			String query_ar="select install_yn from sm_module where module_id='AR'";
			pstmt1 = con.prepareStatement(query_ar);
			rs3 = pstmt1.executeQuery() ;
			if( rs3 != null ) 
			{
				while( rs3.next() )
				{  
					ar_install_yn = rs3.getString("install_yn");
				}
			}
			pstmt1.close();

		}
		catch(Exception e)
		{
			out.println("Exception @ install"+e);
		}
	*/
		
%>
		<!--For Date Validation-->
<%
%>

<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
<script language='javascript' src='../js/AddModifyPatFinClassDetails.js'></script>
<script language="javascript" src='../js/AddModifyPatFinDetailsPkgDiscDtls.js'></script> 
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="javascript" src='../../eBL/js/BLeGLInterface.js'></script>
<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript'>

function funDisable(flag)
{
	var oper = document.forms[0].operation_fun.value;
	var cust_id =parent.parent.frames[0].document.forms[0].customer_id.value;
	var calling_function_id = document.forms[0].function_id.value;
	var operation=document.forms[0].operation.value;
	var booleanSecurity = parent.parent.frames[0].document.forms[0].boolean_security.value;
	var SiteSpecific =parent.parent.frames[0].document.forms[0].SiteSpecific.value;
	var mode = document.forms[0].operation_mode.value;
	var varSettlementInd ="";
	var varModuleId = "";
	var SettlementInd = document.forms[0].setlmt_ind.value;
	var ModuleId = document.forms[0].calling_module_id.value;	
	
	var payerGrpBySetup= document.forms[0].payerGrpBySetup.value;

	try
	{
		var bl_data_from_repos_yn = document.forms[0].bl_data_from_repos_yn.value;

		if (  (bl_data_from_repos_yn == 'Y')  && ( varModuleId  =='MP') )
		{
			if(document.forms[0].credit_doc_start_date1.value=='')
			{ 
				document.forms[0].credit_doc_start_date1.value = document.forms[0].sys_date.value;
			}
		}
	}
	catch(e)
	{
	}

	if (flag == 1) 
	{
		if('Y'!=payerGrpBySetup)
		{
		disableAllElements();
		disableFields();
		
		}
		if (varSettlementInd == "C" && (varModuleId=="OP" ||varModuleId=="AE" || varModuleId=="IP" || varModuleId=="DC" ) )
		{
			//If Condition for cash_set_type1 is added throughout the Page to fix Script error - Rajesh V
			if(document.forms[0].cash_set_type1 != undefined){
				document.forms[0].cash_set_type1.disabled = false;
			}				
		}
		disableFields();
		return;
	}
	
	try
	{
		var setValue ="";
		if (varSettlementInd == "C" && (varModuleId=="OP" ||varModuleId=="AE"|| varModuleId=="IP" || varModuleId=="DC") )
		{
			try
			{
				if(document.forms[0].cash_set_type1 != undefined){
					for(i=0;i<document.forms[0].cash_set_type1.options.length;i++)
					{
						var cashSetValue = document.forms[0].cash_set_type1.options[i].value;
						
						if (cashSetValue == null)
						{
							continue;
						}
						var len = cashSetValue.length;
						var subValue ="";
						if (len >0)
						{
							subValue = cashSetValue.substring(len-1,len);
						}
						if (subValue  == "Y")
						{
							document.forms[0].cash_set_type1.value = cashSetValue;
						}
					}
				}
			}
			catch(e)
			{
			}
			//document.forms[0].cash_set_type1.remove(document.forms[0].cash_set_type1.options[0]);
			if(document.forms[0].cash_set_type1 != undefined){
				document.forms[0].cash_set_type1.disabled = false;
			}
			if(document.forms[0].cash_set_type1 != undefined){
			disableFields();
			}
		}
	}
	catch(e)
	{
	}
	
	disableFields();
}
	
function disableFields(){
	var operation=document.forms[0].operation.value;
	var booleanSecurity = parent.parent.frames[0].document.forms[0].boolean_security.value;
	var SiteSpecific =parent.parent.frames[0].document.forms[0].SiteSpecific.value;
	var ModuleId = document.forms[0].calling_module_id.value;
	var calling_function_id = document.forms[0].function_id.value;
	if(calling_function_id == "PAT_REG" && (operation =="Insert" || operation =="Update") && SiteSpecific== "Y" && booleanSecurity== "true")
	{  
		if(document.forms[0].cash_set_type1 != undefined && document.forms[0].cash_set_type1 != null  ){
			document.forms[0].cash_set_type1.disabled = true;	
		}		
	}
}

function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1);
	}
}

async function noninsblnggrplkup()
{		
	var target			= document.forms[0].non_ins_billing_group_desc;		
	var billinggroup    = document.forms[0].non_insur_blng_grp.value;	
	var retVal			= new String();	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";		
		
//	var title="Non-Insurance Billing Groups";
	var title=getLabel("eBL.NON_INS_BILLING_GROUP.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,30%,60%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var expnote=getLabel("eBL.EXPLANATORY_NOTE.label","BL");
	expnote=encodeURIComponent(expnote);
	var column_descriptions = code+","+desc+","+expnote;

//	var column_descriptions = escape("Code,Description,Explanatory Note"); 

	var message = '';		
	message=encodeURIComponent(message);
	var strCitizenYn = document.forms[0].CitizenYn.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var locale = document.forms[0].locale.value;

	sql1 = "select blng_grp_id BLG_GP,rpad(short_desc,15,' ')||' (' || decode(settlement_ind|| adm_rec_flag, 'C',	'CASH', 'C0','CASH','C1','CASH','C2','CASH','R', 'CREDIT','R0', 'CREDIT','R1', 'CREDIT','R2', 'CREDIT','X1', 'SPONSOR','X2','INSURANCE')||')' SRT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC from bl_blng_grp_lang_vw where language_id='"+locale+"' and status is null and settlement_ind || adm_rec_flag != 'X2' and (('"+strModuleId+"'='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or ('"+strModuleId+"'='AE' and ae_yn = 'Y') or ('"+strModuleId+"'='OP' and op_yn = 'Y') or ('"+strModuleId+"'='IP' and ip_yn = 'Y') or ('"+strModuleId+"'='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED'))";							

	sql = escape(sql1);							

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message;
	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

	var arr=new Array();		

    if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);
	 
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

	   		document.forms[0].non_ins_billing_group_desc.value=arr[1];
			document.forms[0].non_insur_blng_grp.value=arr[0];					  

			document.forms[0].blnggrpappyn.value = "Y";
			document.forms[0].BlngGrpStatus.value = "";
			document.forms[0].blnggrpcatgappyn.value = "Y";
				   
			callNonInsurance(document.forms[0].non_insur_blng_grp);
		}
		else
		{
			target.focus();
		}
	}
}

async function getNonInsBlngGrpSearch()
{
	var billing_group=document.forms[0].non_insur_blng_grp.value;		

	if(billing_group=="select") billing_group="";		
		
	if((billing_group!=""))
	{
		var retVal;
		var dialogHeight= "15" ;
		var dialogWidth	= "43" ;
		var dialogTop = "205" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLBillingGrpDet.jsp?billing_group=	"+billing_group;
		retVal = await window.showModalDialog(url,arguments,features);
	}
}

function valfield(obj)
{
	if (obj.value != '')
	{
		if (parseInt(obj.value) < 0 )
		{
			alert("BL9520","BL");
			obj.focus();
		}
	}
	return 1;
}

async function getCustDet()
{
	var cust_1=document.forms[0].cust_1.value;				
	
	if(cust_1=="select") cust_1="";
	if(cust_1=="")
	{
		//document.forms[0].cust_1.focus();
		//document.forms[0].cust_1_desc.focus();
	}
				
	if((cust_1!=""))
	{
		var retVal;
		var dialogHeight= "14" ;
		var dialogWidth	= "23" ;
		var dialogTop = "350" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLCustomerDet.jsp?cust_code="+cust_1;
		retVal = await window.showModalDialog(url,arguments,features);
	}
}

async function getCustDetSponser()
{
	var cust_2=document.forms[0].cust_2.value;
	
	if(cust_2=="select") cust_2="";
	if(cust_2=="")
	{
		//document.forms[0].cust_2_desc.focus();
	}
	if((cust_2!=""))
	{
		var retVal;
		var dialogHeight= "60vh" ;
		var dialogWidth	= "70vw" ;
		var dialogTop = "0" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLCustomerDet.jsp?cust_code="+cust_2;
		retVal = await top.window.showModalDialog(url,arguments,features);
	}
}

function changeOnSelectCustomerGrp(selectObj)
{
	var cust_1 = selectObj.value;
	var optlength = document.forms[0].cust_1.options.length;
	var slmt_ind  = '<%=nd_settlement_ind%>';
	var adm_rec_flag  = '<%=nd_adm_rec_flag%>';
	var module_id = document.forms[0].calling_module_id.value;				

	for (var i=0; i<optlength; i++)
	{
		document.forms[0].cust_1.options.remove("cust_1");
	}
			
	if((cust_1=="") ||(cust_1=="select")) 
	{				
		var cust_code	= 'select';
		var short_desc	= '         ---- Select ----         ';
		var opt=document.createElement('OPTION'); 
		opt.text	=	short_desc; 
		opt.value	=	cust_code; 
		document.forms[0].cust_1.add(opt); 
		document.forms[0].cust_1.selectedIndex = 0;
		//return false;
	}

	var HTMLVal="<html><body onMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='BLCustomerForm' id='BLCustomerForm' method='post' action='../../eBL/jsp/BLCustomerCode.jsp'>"+
			"<input type='hidden' name='cust_group_code' id='cust_group_code' value=\""+cust_1+"\">"+
            "<input type='hidden' name='slmt_ind' id='slmt_ind' value=\""+slmt_ind+"\">"+ 
			"<input type='hidden' name='adm_rec_flag' id='adm_rec_flag' value=\""+adm_rec_flag+"\">"+
            "<input type='hidden' name='module_id' id='module_id' value=\""+module_id+"\">"+
			"</form></body></html>";
			
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.parent.frames[2].document.BLCustomerForm.submit();

	return true;
}

function changeOnSelectCustomerGrp2(selectObj)
{
	var cust_2 = selectObj.value;
	var optlength = document.forms[0].cust_2.options.length;
	var slmt_ind  = '<%=nd_settlement_ind%>';
	var adm_rec_flag  = '<%=nd_adm_rec_flag%>';
	var module_id = document.forms[0].calling_module_id.value;				

	for (var i=0; i<optlength; i++)
	{
		document.forms[0].cust_2.options.remove("cust_2");
	}				

	if((cust_2=="") ||(cust_2=="select")) 
	{				
		var cust_code	= 'select';
		var short_desc	= '         ---- Select ----         ';
		var opt=document.createElement('OPTION'); 
		opt.text	=	short_desc; 
		opt.value	=	cust_code; 
		document.forms[0].cust_2.add(opt); 
		document.forms[0].cust_2.selectedIndex = 0;
		//return false;
	}			
			
	var HTMLVal="<html><body onMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='BLCustomerForm' id='BLCustomerForm' method='post' action='../../eBL/jsp/BLCustomerCode.jsp'>"+
			"<input type='hidden' name='cust_group_code' id='cust_group_code' value=\""+cust_2+"\">"+
            "<input type='hidden' name='slmt_ind' id='slmt_ind' value=\""+slmt_ind+"\">"+ 
			"<input type='hidden' name='adm_rec_flag' id='adm_rec_flag' value=\""+adm_rec_flag+"\">"+
            "<input type='hidden' name='module_id' id='module_id' value=\""+module_id+"\">"+
			"</form></body></html>";
			
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.parent.frames[2].document.BLCustomerForm.submit();

	return true;			
}

async function credit_custgrouplkup(clng_evnt)
{

	var site_id= document.forms[0].site_id.value;
	var autoFinChk = document.forms[0].autoFinChk.value;
	var target				= document.forms[0].cust_group_desc_1;	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].cust_group_desc_1.value='';
			document.forms[0].cust_group_code_1.value = '';
			return;
		}
	}
	var msg="";

	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var message				= "";
	if(site_id == 'true'){
		var column_sizes = escape("25%,35%,40%");
	}else{
	var column_sizes = escape("30%,70%");
	}
	var locale = document.forms[0].locale.value;
		
	if (autoFinChk == "Y")
	{
				var blng_grp_id = document.forms[0].billing_group.value;
		var class_code = document.forms[0].class_code.value;
		if(site_id == 'true'){
		sql = " SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME,b.LONG_DESC LONG_DESC FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id='"+locale+"' AND a.CLASSIFICATION_CODE = '"+class_code+"' AND a.APPL_BLNG_GRP_ID = '"+blng_grp_id+"' AND b.status IS NULL";
		}else{
			sql = " SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id='"+locale+"' AND a.CLASSIFICATION_CODE = '"+class_code+"' AND a.APPL_BLNG_GRP_ID = '"+blng_grp_id+"' AND b.status IS NULL";
		}
		}
	else
	{
		if(site_id == 'true'){
		sql = "	select cust_group_code cust_group_code,short_desc short_name,LONG_DESC LONG_DESC from ar_cust_group_lang_vw where language_id='"+locale+"' and status is null";
		}else{
			sql = "	select cust_group_code cust_group_code,short_desc short_name from ar_cust_group_lang_vw where language_id='"+locale+"' and status is null";

		}
	}

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
	title=encodeURIComponent(title);	
	if(site_id == 'true'){
	var code=getLabel("eBL.CustomerGroupCode.label","BL");
	code=encodeURIComponent(code);
	var desc=getLabel("eBL.description.label","eBL");
	desc=encodeURIComponent(desc);
	var cust_group_long_name=getLabel("eBL.long_desc.label","BL");
	cust_group_long_name=encodeURIComponent(cust_group_long_name);
	}else{
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	}
	if(site_id == 'true'){
	column_descriptions = code+","+desc+","+cust_group_long_name;
	}else{
		column_descriptions = code+","+desc;
	}
	sql = escape(sql);
	if(site_id == 'true'){
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYY";
	}else{
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";	
	}
	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");
	
		document.forms[0].cust_group_desc_1.value=arr[1];
	    document.forms[0].cust_group_code_1.value=arr[0];
	  
		chk_for_gl_valid(document.forms[0].credit_doc_ref1);
	}
	else
	{	
		document.forms[0].cust_group_desc_1.value='';
	    document.forms[0].cust_group_code_1.value='';												
	}
	
}

async function custgrouplkup1(clng_evnt)
{	
	var autoFinChk = document.forms[0].autoFinChk.value;

	var target				= document.forms[0].cust_group_desc_2;
	var locale = document.forms[0].locale.value;
	var site_id= document.forms[0].site_id.value;
	var selecltd_cust_grp_frm_pkg = document.forms[0].selecltd_cust_grp_frm_pkg.value;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].cust_group_desc_2.value='';
			document.forms[0].cust_group_code_2.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "0";
	var dialogHeight		= "60vh" ;
	var dialogWidth			= "70vw" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	if(site_id == 'true'){
		
		var column_sizes = escape("25%,35%,40%");
		}else{
		var column_sizes = escape("30%,70%");
		}
	

	var locale = document.forms[0].locale.value;
	
	if (autoFinChk == "Y")
	{
				var blng_grp_id = document.forms[0].billing_group.value;
		var class_code = document.forms[0].class_code.value;
		if(site_id == 'true'){
		sql = " SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME,b.LONG_DESC LONG_DESC FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id='"+locale+"' AND a.CLASSIFICATION_CODE = '"+class_code+"' AND a.APPL_BLNG_GRP_ID = '"+blng_grp_id+"' AND b.status IS NULL";
		}else{
			sql = " SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id='"+locale+"' AND a.CLASSIFICATION_CODE = '"+class_code+"' AND a.APPL_BLNG_GRP_ID = '"+blng_grp_id+"' AND b.status IS NULL";
		}
		}
	else
	{
		if(site_id == 'true'){
		sql = "	select cust_group_code cust_group_code,short_desc short_name,LONG_DESC LONG_DESC from ar_cust_group_lang_vw where language_id='"+locale+"' and status is null";
		}else{
			sql = "	select cust_group_code cust_group_code,short_desc short_name from ar_cust_group_lang_vw where language_id='"+locale+"' and status is null";

		}
	}

	if(selecltd_cust_grp_frm_pkg != "")
	{
		var cust_group_arr = selecltd_cust_grp_frm_pkg.split("@@");
		
		sql = sql + " and cust_group_code in ('";
		for(var i=0;i<cust_group_arr.length;i++)
		{
			
			if(i != (cust_group_arr.length-1))
				sql = sql + cust_group_arr[i] + "','";
			else
				sql = sql + cust_group_arr[i] +"')";
		}
		
	}

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
	title=encodeURIComponent(title);	
	if(site_id == 'true'){
	var code=getLabel("eBL.CustomerGroupCode.label","BL");
	code=encodeURIComponent(code);
	var desc=getLabel("eBL.description.label","eBL");
	desc=encodeURIComponent(desc);
	var cust_group_long_name=getLabel("eBL.long_desc.label","BL");
	cust_group_long_name=encodeURIComponent(cust_group_long_name);
	}else{
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	}
	if(site_id == 'true'){
	
	column_descriptions = code+","+desc+","+cust_group_long_name;
	}else{
		column_descriptions = code+","+desc;
	}
	sql = escape(sql);
	
	if(site_id == 'true'){
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYY";
	}else{
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";	
	}

	


	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
		
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");
		
		document.forms[0].cust_group_desc_2.value=arr[1];
	    document.forms[0].cust_group_code_2.value=arr[0];	
		chk_for_gl_valid(document.forms[0].credit_doc_ref2);
	}
	else
	{	
		document.forms[0].cust_group_desc_2.value='';
	    document.forms[0].cust_group_code_2.value='';												
	}
}
/*
function cust1grouplkup()
{	
	var msg="";
	var target			= document.forms[0].cust_1_desc;
	var retVal			= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql				= "";
	var search_desc			= "";
	var tit				= "";		
	var ModuleId     = '<%=strModuleId%>';
	var custgroup = document.forms[0].cust_group_1.value;
	var locale = document.forms[0].locale.value;

	var cust_valid_frm=getLabel("eBL.VALID_FROM.label","BL");
	cust_valid_frm=encodeURIComponent(cust_valid_frm);	
	var cust_valid_to=getLabel("eBL.VALID_TO.label","BL");
	cust_valid_to=encodeURIComponent(cust_valid_to);	
		
	sql = "	select cust_code, short_name,to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO from ar_customer_lang_vw where language_id=`"+locale+"` and patient_flag = `Y` and pat_com_flag = `Y` and status is null and ((`"+ModuleId+"` in (`OP`,`AE`) and nvl(op_yn,`N`) = `Y`) or (`"+ModuleId+"` in (`IP`,`DC`) and nvl(ip_yn,`N`) = `Y`) or (`"+ModuleId+"` = `MP` and nvl(ref_yn,`N`) = `Y`)) and (( cust_group_code = `"+custgroup+"` and  `"+custgroup+"` is not null ) or `"+custgroup+"` is null )";	
		
	search_code="cust_code";
	search_desc="short_name";
//	tit="Customers "; 
	tit=getLabel("Common.Customer.label","common"); 
	tit=encodeURIComponent(tit);		
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();

	if (!(retVal == null))
	{
	    var retVal=unescape(retVal);
		arr=retVal.split("::");
		
		document.forms[0].cust_1_desc.value=arr[0];
	    document.forms[0].cust_1.value=arr[1];					
	}
	else
	{				
		document.forms[0].cust_1_desc.value='';
		document.forms[0].cust_1.value = '';
	
		target.focus();
	}
}
*/
/* Function for Credit Customer Lkup */
async function credit_custlkup(clng_evnt)
{		
	var autoFinChk = document.forms[0].autoFinChk.value;
	var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var target			= document.forms[0].cust_1_desc;	
	var calling_module_id = document.forms[0].calling_module_id.value;
	var site_id= document.forms[0].site_id.value;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{
			document.forms[0].cust_1_desc.value='';
			document.forms[0].cust_1.value = '';
			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="none";			
			}
			return;
		}
	}

	var retVal			= new String();	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var message = '';	

	var search_by_items = document.forms[0].search_by_items.value;
	var search_code = document.forms[0].search_code.value;

	var locale = document.forms[0].locale.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;
	var strCustGroupCode = document.forms[0].cust_group_code_1.value;
	var blng_grp_curr_code = parent.parent.frames[0].document.forms[0].currency_code_for_bg.value;
	var selecltd_cust_frm_pkg = document.forms[0].selecltd_cust_frm_pkg.value;
	var facility_id = document.forms[0].facility_id.value;
	var blng_grp_id = document.forms[0].billing_group.value;
	var class_code = document.forms[0].class_code.value;

	var cust_valid_from_date="", cust_valid_to_date = "", cust_curr_code="",cust_curr_desc="";
	if(site_id == 'true'){
	var column_sizes = escape("10%,10%,10%,10%,10%,10%,5%,5%,5%,5%,0%,0%");
	}else{
		var column_sizes = escape("5%,25%,5%,25%,10%,10%,10%,10%,0%,0%");
	}
	var title=getLabel("Common.Customer.label","common"); 
	title=encodeURIComponent(title);
	if(site_id == 'true'){
	var code=getLabel("eBL.CustomerCode.label","BL");
	code=encodeURIComponent(code);
	var long_name=getLabel("eBL.long_name.label","BL");
	long_name=encodeURIComponent(long_name);
	var cust_short_name=getLabel("eBL.CUSTOMER_GROUPS.label","BL");
	cust_short_name=encodeURIComponent(cust_short_name);
	var cust_group_code=getLabel("eBL.CustomerGroupCode.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var long_desc=getLabel("eBL.long_desc.label","BL");
	long_desc=encodeURIComponent(long_desc);
	var cust_long_name=getLabel("eBL.description.label","BL");
	cust_long_name=encodeURIComponent(cust_long_name);
	}else{
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var cust_group_code=getLabel("eBL.CUST_GROUP_CODE.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var cust_group=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	cust_group=encodeURIComponent(cust_group);
	}
	var country = getLabel("Common.country.label","common");
	country = encodeURIComponent(country);
	var region = getLabel("eMP.region.label","MP");
	region = encodeURIComponent(region);
	var cust_valid_frm=getLabel("eBL.VALID_FROM.label","BL");
	cust_valid_frm=encodeURIComponent(cust_valid_frm);	
	var cust_valid_to=getLabel("eBL.VALID_TO.label","BL");
	cust_valid_to=encodeURIComponent(cust_valid_to);	
	var curr_code=getLabel("eBL.CURR_CODE.label","BL");
	cust_curr_code=encodeURIComponent(cust_curr_code);
	var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
	curr_desc=encodeURIComponent(curr_desc);
	if(site_id == 'true'){
	var column_descriptions = code+","+long_name+","+cust_short_name+","+cust_group_code+","+long_desc+","+cust_long_name+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;
	}else{
		var column_descriptions = code+","+desc+","+cust_group_code+","+cust_group+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;
	}
	if(site_id == 'true'){
	sql = "called_for=CREDITPAYERLKUP&locale="+locale+"&auto_fin_chk="+autoFinChk+"&blng_grp_id="+blng_grp_id+"&class_code="+class_code+"&cust_grp_code="+strCustGroupCode+"&facility_id="+facility_id+"&module_id="+strModuleId+"&search_by_items="+search_by_items+"&search_code="+search_code+"&select_cust_frm_pkg="+selecltd_cust_frm_pkg+"&site_id="+site_id;
	}else{
		sql = "called_for=CREDITPAYERLKUP&locale="+locale+"&auto_fin_chk="+autoFinChk+"&blng_grp_id="+blng_grp_id+"&class_code="+class_code+"&cust_grp_code="+strCustGroupCode+"&facility_id="+facility_id+"&module_id="+strModuleId+"&search_by_items="+search_by_items+"&search_code="+search_code+"&select_cust_frm_pkg="+selecltd_cust_frm_pkg;
	}
	/*		
	if (autoFinChk == "Y")
	{
//Added facility_id in the customer lookup query for PE Changes
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
			+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c,BL_APPL_BG_BY_CLASSFCTN D "
			+" where a.language_id = b.language_id" 
			+" and a.language_id='"+locale+"'"
			+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
			+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
			+" and d.OPERATING_FACILITY_ID='"+facility_id+"'"
			+" and b.cust_group_code = c.cust_group_code"
			+" and c.cust_group_code = d.APPL_CUST_GROUP_CODE"
			+" and a.cust_code = c.cust_code" 
			+" and c.cust_code = d.APPL_CUST_CODE" 
			+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
			+" and d.CLASSIFICATION_CODE='"+class_code+"'"
			+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
			+" and (d.APPL_CUST_GROUP_CODE='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
			+" and a.patient_flag = 'Y'" 
			+" and a.pat_com_flag = 'Y'" 
			+" and nvl (insurance_yn,'N') = 'N'" 
			+" and a.status is null" 
			+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
			+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
	else
	{
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
			+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
			+" where a.language_id = b.language_id" 
			+" and a.language_id='"+locale+"'"
			+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
			+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"			
			+" and b.cust_group_code = c.cust_group_code"
			+" and a.cust_code = c.cust_code" 
			+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
			+" and a.patient_flag = 'Y'" 
			+" and a.pat_com_flag = 'Y'" 
			+" and nvl (insurance_yn,'N') = 'N'" 
			+" and a.status is null" 
			+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
			+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
	if(selecltd_cust_frm_pkg != "")
	{
		var cust_arr = selecltd_cust_frm_pkg.split("@@");
		sql = sql + " and c.cust_code in ('";
		for(var i=0;i<cust_arr.length;i++)
		{
			if(i != (cust_arr.length-1))
				sql = sql + cust_arr[i] + "','";
			else
				sql = sql + cust_arr[i] +"')";
		}
	}

//	sql = escape(sql);							
*/
//	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";
if(site_id == 'true'){
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYYYYYYYNN";
}else{
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";
}
	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

	var arr=new Array();		

    if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			

			if(site_id == 'true'){
			cust_valid_from_date = arr[8].substring(0,10);
			cust_valid_to_date = arr[9].substring(0,10);
			cust_curr_code = arr[10];
			cust_curr_desc= arr[11];
			}else{
				cust_valid_from_date = arr[6].substring(0,10);
				cust_valid_to_date = arr[7].substring(0,10);
				cust_curr_code = arr[8];
				cust_curr_desc= arr[9];	
			}
			if(cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc= cust_valid_from_date;
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);

				if(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					document.forms[0].cust_1_desc.value='';
					document.forms[0].cust_1.value = '';
					return false;
				}
			}
			if(cust_valid_to_date != "")
			{
				var cust_valid_to_date_loc = cust_valid_to_date;
				if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);

				if(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					document.forms[0].cust_1_desc.value='';
					document.forms[0].cust_1.value = '';
					return false;
				}
			}

			if((blng_grp_curr_code != "" && cust_curr_code == "") || (blng_grp_curr_code == "" && cust_curr_code != "") || (blng_grp_curr_code != "" && cust_curr_code != "" && cust_curr_code != blng_grp_curr_code))
			{
				alert(getMessage("BL6312","BL"));
				document.forms[0].cust_1_desc.value='';
				document.forms[0].cust_1.value = '';
				document.forms[0].cust_curr_code.value = "";
				document.forms[0].cust_curr_desc.value = "";
				document.getElementById('cust_curr_desc_disp').style.display="none";
				document.getElementById('cust_curr_desc_val').innerText="";
				return false;
			}
			else
			{
				document.forms[0].cust_curr_code.value = cust_curr_code;
				document.forms[0].cust_curr_desc.value = cust_curr_desc;
			}
			
			if(site_id == 'true'){
			document.forms[0].cust_1.value=arr[0];
			document.forms[0].cust_1_desc.value=arr[2];
			document.forms[0].cust_group_desc_1.value=arr[5];
			document.forms[0].cust_group_code_1.value=arr[3];	
			document.forms[0].cust_valid_from_date.value=cust_valid_from_date;
			document.forms[0].cust_valid_to_date.value=cust_valid_to_date;
			}else{
			document.forms[0].cust_1.value=arr[0];	
			document.forms[0].cust_1_desc.value=arr[1];
			document.forms[0].cust_group_desc_1.value=arr[3];
			document.forms[0].cust_group_code_1.value=arr[2];	
			document.forms[0].cust_valid_from_date.value=cust_valid_from_date;
			document.forms[0].cust_valid_to_date.value=cust_valid_to_date;
		}
			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="inline";			
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var updation=formValidation(xmlStr,"clearBean");
			}
		}
		else
		{
			document.forms[0].cust_1_desc.value='';
			document.forms[0].cust_1.value = '';
			target.focus();
			
			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="none";			
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var updation=formValidation(xmlStr,"clearBean");
			}
		}
	}
	curr_desc_1();
	chk_for_gl_valid(document.forms[0].credit_doc_ref1);
}
/*
function cust2grouplkup()
{			
	var msg="";
	var target			= document.forms[0].cust_2_desc;
	var retVal			= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql				= "";
	var search_desc			= "";
	var tit				= "";		
	var ModuleId     = '<%=strModuleId%>';
	var custgroup = document.forms[0].cust_group_1.value;
	var locale = document.forms[0].locale.value;
		
	sql=" select cust_code, short_name from ar_customer_lang_vw where language_id=`"+locale+"` and patient_flag = `Y` and pat_com_flag = `N`   and nvl (insurance_yn,`N`) = `N`  and status is null and ((`"+ModuleId+"` in (`OP`,`AE`) and nvl(op_yn,`N`) = `Y`) or (`"+ModuleId+"` in (`IP`,`DC`) and nvl(ip_yn,`N`) = `Y`) or (`"+ModuleId+"` = `MP` and nvl(ref_yn,`N`) = `Y`)) and (( cust_group_code = `"+custgroup+"` and  `"+custgroup+"` is not null ) or `"+custgroup+"` is null )";	
		
	search_code="cust_code";
	search_desc="short_name";
//	tit="Customers "; 
	tit=getLabel("Common.Customer.label","common"); 
	tit=encodeURIComponent(tit);	
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("::");
	
		document.forms[0].cust_2_desc.value=arr[0];
	    document.forms[0].cust_2.value=arr[1];					
	}
	else
	{				
		document.forms[0].cust_2_desc.value='';
		document.forms[0].cust_2.value = '';									
		target.focus();
	}
}	  
*/
/* Function for Sponsor Customer Lkup */
async function cust2grouplkup(clng_evnt)
{		
	var autoFinChk = document.forms[0].autoFinChk.value;
	var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var target			= document.forms[0].cust_2_desc;	
	var calling_module_id = document.forms[0].calling_module_id.value;
var site_id= document.forms[0].site_id.value;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].cust_2_desc.value='';
			document.forms[0].cust_2.value='';	

			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="none";			
			}

			return;
		}
	}

	var retVal			= new String();	
	var dialogTop			= "0";
	var dialogHeight		= "60vh" ;
	var dialogWidth			= "70vw" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var message = '';	

	var search_by_items = document.forms[0].search_by_items.value;
	var search_code = document.forms[0].search_code.value;

	var locale = document.forms[0].locale.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;
	var strCustGroupCode = document.forms[0].cust_group_code_2.value;
	var blng_grp_curr_code = parent.parent.frames[0].document.forms[0].currency_code_for_bg.value;
	var selecltd_cust_frm_pkg = document.forms[0].selecltd_cust_frm_pkg.value;
	var facility_id = document.forms[0].facility_id.value;
	var blng_grp_id = document.forms[0].billing_group.value;
	var class_code = document.forms[0].class_code.value;

	var cust_valid_from_date="", cust_valid_to_date = "", cust_curr_code="",cust_curr_desc="";
		if(site_id == 'true'){
	var column_sizes = escape("5%,25%,5%,25%,10%,10%,10%,10%,10%,10%,0%,0%");
	}else{
	var column_sizes = escape("5%,25%,5%,25%,10%,10%,10%,10%,0%,0%");
	}	
	

	var title=getLabel("Common.Customer.label","common"); 
	title=encodeURIComponent(title);
	
	
	if(site_id == 'true'){
	var code=getLabel("eBL.CustomerCode.label","BL");
	code=encodeURIComponent(code);
	var long_name=getLabel("eBL.long_name.label","BL");
	long_name=encodeURIComponent(long_name);
	var cust_short_name=getLabel("eBL.CUSTOMER_GROUPS.label","BL");
	cust_short_name=encodeURIComponent(cust_short_name);
	var cust_group_code=getLabel("eBL.CustomerGroupCode.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var long_desc=getLabel("eBL.long_desc.label","BL");
	long_desc=encodeURIComponent(long_desc);
	var cust_long_name=getLabel("eBL.description.label","BL");
	cust_long_name=encodeURIComponent(cust_long_name);
	}else{
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var cust_group_code=getLabel("eBL.CUST_GROUP_CODE.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var cust_group=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	cust_group=encodeURIComponent(cust_group);
	}
	
	var country = getLabel("Common.country.label","common");
	country = encodeURIComponent(country);
	var region = getLabel("eMP.region.label","MP");
	region = encodeURIComponent(region);
	var cust_valid_frm=getLabel("eBL.VALID_FROM.label","BL");
	cust_valid_frm=encodeURIComponent(cust_valid_frm);	
	var cust_valid_to=getLabel("eBL.VALID_TO.label","BL");
	cust_valid_to=encodeURIComponent(cust_valid_to);	
	var curr_code=getLabel("eBL.CURR_CODE.label","BL");
	curr_code=encodeURIComponent(curr_code);
	var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
	curr_desc=encodeURIComponent(curr_desc);

	if(site_id == 'true'){
	var column_descriptions = code+","+long_name+","+cust_short_name+","+cust_group_code+","+long_desc+","+cust_long_name+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;
	}else{
		var column_descriptions = code+","+desc+","+cust_group_code+","+cust_group+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;
	}
	
if(site_id == 'true'){
	sql = "called_for=SPONSORPAYERLKUP&locale="+locale+"&auto_fin_chk="+autoFinChk+"&blng_grp_id="+blng_grp_id+"&class_code="+class_code+"&cust_grp_code="+strCustGroupCode+"&facility_id="+facility_id+"&module_id="+strModuleId+"&search_by_items="+search_by_items+"&search_code="+search_code+"&select_cust_frm_pkg="+selecltd_cust_frm_pkg+"&site_id="+site_id;
	}else{
		sql = "called_for=SPONSORPAYERLKUP&locale="+locale+"&auto_fin_chk="+autoFinChk+"&blng_grp_id="+blng_grp_id+"&class_code="+class_code+"&cust_grp_code="+strCustGroupCode+"&facility_id="+facility_id+"&module_id="+strModuleId+"&search_by_items="+search_by_items+"&search_code="+search_code+"&select_cust_frm_pkg="+selecltd_cust_frm_pkg;
	}

/*		
	if (autoFinChk == "Y")
	{
		var blng_grp_id = document.forms[0].billing_group.value;
		var class_code = document.forms[0].class_code.value;
//Added facility_id in the customer lookup query for PE Changes
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
			+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c,BL_APPL_BG_BY_CLASSFCTN D "
			+" where a.language_id = b.language_id" 
			+" and a.language_id='"+locale+"'"
			+" and d.OPERATING_FACILITY_ID='"+facility_id+"'"
			+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
			+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
			+" and b.cust_group_code = c.cust_group_code"
			+" and c.cust_group_code = d.APPL_CUST_GROUP_CODE"
			+" and a.cust_code = c.cust_code" 
			+" and c.cust_code = d.APPL_CUST_CODE" 
			+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
			+" and d.CLASSIFICATION_CODE='"+class_code+"'"
			+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
			+" and (d.APPL_CUST_GROUP_CODE='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
			+" and a.patient_flag = 'Y'" 
			+" and a.pat_com_flag = 'N'" 
			+" and nvl (insurance_yn,'N') = 'N'" 
			+" and a.status is null" 
			+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
			+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
			+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
	else
	{
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
		+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
		+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
		+" where a.language_id = b.language_id" 
		+" and a.language_id='"+locale+"'"
		+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
		+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"			
		+" and b.cust_group_code = c.cust_group_code"
		+" and a.cust_code = c.cust_code" 
		+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
		+" and a.patient_flag = 'Y'" 
		+" and a.pat_com_flag = 'N'" 
		+" and nvl (insurance_yn,'N') = 'N'" 
		+" and a.status is null" 
		+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
		+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
	if(selecltd_cust_frm_pkg != "")
	{
		var cust_arr = selecltd_cust_frm_pkg.split("@@");
		sql = sql + " and c.cust_code in ('";
		for(var i=0;i<cust_arr.length;i++)
		{
			if(i != (cust_arr.length-1))
				sql = sql + cust_arr[i] + "','";
			else
				sql = sql + cust_arr[i] +"')";
		}
	}

//	sql = escape(sql);							
*/
//	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";

if(site_id == 'true'){
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYYYYYYYNN";
}else{
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";
}
	

	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

	var arr=new Array();		

    if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			
			
				if(site_id == 'true'){
			cust_valid_from_date = arr[8].substring(0,10);
			cust_valid_to_date = arr[9].substring(0,10);
			cust_curr_code = arr[10];
			cust_curr_desc= arr[11];
			}else{
				cust_valid_from_date = arr[6].substring(0,10);
				cust_valid_to_date = arr[7].substring(0,10);
				cust_curr_code = arr[8];
				cust_curr_desc= arr[9];	
			}
			
			
			
		

			if(cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc=cust_valid_from_date;
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);

				if(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					document.forms[0].cust_2_desc.value='';
					document.forms[0].cust_2.value='';	
					return false;
				}
			}
			if(cust_valid_to_date != "")
			{
				var cust_valid_to_date_loc=cust_valid_to_date;
				if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);

				if(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					document.forms[0].cust_2_desc.value='';
					document.forms[0].cust_2.value='';	
					return false;
				}
			}

			if((blng_grp_curr_code != "" && cust_curr_code == "") || (blng_grp_curr_code == "" && cust_curr_code != "") || (blng_grp_curr_code != "" && cust_curr_code != "" && cust_curr_code != blng_grp_curr_code))
			{
				alert(getMessage("BL6312","BL"));
				document.forms[0].cust_2_desc.value='';
				document.forms[0].cust_2.value='';	
				document.forms[0].cust_curr_code.value = "";
				document.forms[0].cust_curr_desc.value = "";
				document.getElementById('cust_curr_desc_disp').style.display="none";
				document.getElementById('cust_curr_desc_val').innerText="";
				return false;
			}
			else
			{
				document.forms[0].cust_curr_code.value = cust_curr_code;
				document.forms[0].cust_curr_desc.value = cust_curr_desc;
			}
			
			
			if(site_id == 'true'){
			document.forms[0].cust_2.value=arr[0];	
			document.forms[0].cust_2_desc.value=arr[2];
			document.forms[0].cust_group_desc_2.value=arr[4];
			document.forms[0].cust_group_code_2.value=arr[3];
			document.forms[0].cust_valid_from_date.value=cust_valid_from_date;
			document.forms[0].cust_valid_to_date.value=cust_valid_to_date;
			}else{
			document.forms[0].cust_2.value=arr[0];	
			document.forms[0].cust_2_desc.value=arr[1];
			document.forms[0].cust_group_desc_2.value=arr[3];
			document.forms[0].cust_group_code_2.value=arr[2];	
			document.forms[0].cust_valid_from_date.value=cust_valid_from_date;
			document.forms[0].cust_valid_to_date.value=cust_valid_to_date;
		}
			

			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="inline";			
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var updation=formValidation(xmlStr,"clearBean");
			}
		}
		else
		{
			document.forms[0].cust_2_desc.value='';
			document.forms[0].cust_2.value='';	
			target.focus();

			if(package_enabled_yn == 'Y' && (calling_module_id == 'OP' || calling_module_id == 'IP'))
			{
				document.getElementById('pkg_disc_disp').style.display="none";		
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var updation=formValidation(xmlStr,"clearBean");				
			}
		}
		curr_desc_1();
		chk_for_gl_valid(document.forms[0].credit_doc_ref2);
	}
}
function curr_desc_1()
{
	var setlmt_ind = document.forms[0].setlmt_ind.value;
	if(setlmt_ind == 'X' || setlmt_ind == 'R')
	{
		var cust_curr_desc = document.forms[0].cust_curr_desc.value;

		if(cust_curr_desc != "")
		{
			document.getElementById('cust_curr_desc_disp').style.display="inline";
			document.getElementById('cust_curr_desc_val').innerText=cust_curr_desc;
		}
		else
		{
			document.getElementById('cust_curr_desc_disp').style.display="none";
			document.getElementById('cust_curr_desc_val').innerText="";
		}
	}
}

function dfltslmt()
{
	var dfltslmt = document.forms[0].dflt_slmt_type_code.value;
	var operation = document.forms[0].operation_fun.value;
	var autoFinChk = document.forms[0].autoFinChk.value;
//	var cash_settl_ind = document.forms[0].cash_settl_ind.value;
	var cash_slmt_type = document.forms[0].cash_slmt_type.value;

	if(( autoFinChk == "Y" && cash_slmt_type=="") || (autoFinChk=="N" ))
	{
		if(document.forms[0].cash_set_type1 != null && document.forms[0].cash_set_type1 != undefined)
		{
			for(i=0;i<document.forms[0].cash_set_type1.options.length;i++)
			{									
				var cashSetValue = document.forms[0].cash_set_type1.options[i].value;									
				if (cashSetValue == null)
				{
					continue;
				}

				var len = cashSetValue.length;
				var subValue ="";
				if (len >0)
				{
					subValue = cashSetValue.substring(0,len-1);
				}

				if (subValue == dfltslmt)
				{								
					if(document.forms[0].cash_set_type1.value==''){
					document.forms[0].cash_set_type1.value = cashSetValue;
					}
				}
			}
		}
	}
}

function srch_by_crit_for_cust()
{
	var setlmt_ind = document.forms[0].setlmt_ind.value;
	if(setlmt_ind != 'C')
	{
		var srch_by = document.forms[0].search_by_items.value;
/*
		if(srch_by == "CG")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("eBL.CUSTOMER_GROUP.label","BL");
		}
		else 
*/
		if (srch_by == "CY")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("Common.country.label","common");
		}
		else if (srch_by == "RN")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("eMP.region.label","MP");
		}

		document.forms[0].srch_by_desc.value='';
		document.forms[0].search_code.value = '';
	}
}

async function srchbylkup(clng_evnt)
{	
	var srch_by = document.forms[0].search_by_items.value;
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].search_code ;
	var target = document.forms[0].srch_by_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].srch_by_desc.value='';
			document.forms[0].search_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";
/*	
	if(srch_by == "CG")
	{
		var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
		title=encodeURIComponent(title);		
		
		sql = "	select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and status is null";	
	}
	else 
*/
	if (srch_by == "CY")
	{
		var title=getLabel("Common.country.label","common"); 
		title=encodeURIComponent(title);		
		
		sql = "select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}
	else if (srch_by == "RN")
	{
		var title=getLabel("eMP.region.label","MP"); 
		title=encodeURIComponent(title);		
		
		sql = "select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
	}
	else
	{	
		target.value='';
		target_code.value = '';
	}
}

function chk_for_gl_valid(credit_doc_ref)
{
	var calling_module_id = document.forms[0].calling_module_id.value;
	var function_id = document.forms[0].function_id.value;

	if(calling_module_id != 'MP' && function_id!="BOOKING")
	{
		var facility_id = document.forms[0].facility_id.value;
		var patient_id = document.forms[0].patient_id.value;
		var episode_type = document.forms[0].episode_type.value;
		var gl_holder_name = parent.parent.frames[0].document.forms[0].gl_holder_name.value;
		var setlmt_ind = document.forms[0].setlmt_ind.value;
		var adm_rec_flag = document.forms[0].adm_rec_flag.value;
		var cust_grp_code = "",cust_code="";
		var doc_ref = credit_doc_ref.value;

		if(setlmt_ind == 'R')//Credit
		{
			cust_grp_code = document.forms[0].cust_group_code_1.value;
			cust_code = document.forms[0].cust_1.value;
		}
		else if(setlmt_ind == 'X' && adm_rec_flag == '1')//Sponsor
		{
			cust_grp_code = document.forms[0].cust_group_code_2.value;
			cust_code = document.forms[0].cust_2.value;		
		}

		var gl_holder_name = parent.parent.frames[0].document.forms[0].gl_holder_name.value;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();			
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var param="facility_id="+facility_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&gl_holder_name="+gl_holder_name+"&cust_group_code="+cust_grp_code+"&cust_code="+cust_code+"&doc_ref="+doc_ref+"&called_from=gl_enc_chk";
		var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;			
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText = trimString(xmlHttp.responseText);		
//		alert(responseText);
		if(responseText != "")
		{
			var retArray = new Array();
			retArray=responseText.split("/");

			var gl_doc_ref_exist_YN = 	retArray[0] ;
			document.forms[0].gl_doc_ref_exist_YN.value = gl_doc_ref_exist_YN;

			var tot_valid_enc_with_gl = retArray[1];
			if(tot_valid_enc_with_gl == null || tot_valid_enc_with_gl==" ") tot_valid_enc_with_gl="";

			var tot_valid_op_enc_with_gl = retArray[2];
			if(tot_valid_op_enc_with_gl == null || tot_valid_op_enc_with_gl==" ") tot_valid_op_enc_with_gl="";

			var tot_valid_ae_enc_with_gl = retArray[3];
			if(tot_valid_ae_enc_with_gl == null || tot_valid_ae_enc_with_gl==" ") tot_valid_ae_enc_with_gl="";

			var tot_valid_ip_enc_with_gl = retArray[4];
			if(tot_valid_ip_enc_with_gl == null || tot_valid_ip_enc_with_gl==" ") tot_valid_ip_enc_with_gl="";

			var tot_valid_dc_enc_with_gl = retArray[5];
			if(tot_valid_dc_enc_with_gl == null || tot_valid_dc_enc_with_gl==" ") tot_valid_dc_enc_with_gl="";

			var tot_availed_enc_with_gl = retArray[6];
			if(tot_availed_enc_with_gl == null || tot_availed_enc_with_gl==" ") tot_availed_enc_with_gl="0";

			var tot_availed_op_enc_with_gl = retArray[7];
			if(tot_availed_op_enc_with_gl == null || tot_availed_op_enc_with_gl==" ") tot_availed_op_enc_with_gl="0";

			var tot_availed_ae_enc_with_gl = retArray[8];
			if(tot_availed_ae_enc_with_gl == null || tot_availed_ae_enc_with_gl==" ") tot_availed_ae_enc_with_gl="0";

			var tot_availed_ip_enc_with_gl = retArray[9];
			if(tot_availed_ip_enc_with_gl == null || tot_availed_ip_enc_with_gl==" ") tot_availed_ip_enc_with_gl="0";

			var tot_availed_dc_enc_with_gl = retArray[10];
			if(tot_availed_dc_enc_with_gl == null || tot_availed_dc_enc_with_gl==" ") tot_availed_dc_enc_with_gl="0";

			if(gl_doc_ref_exist_YN == 'Y')
			{
				if(setlmt_ind == 'R')//Credit
				{
					document.forms[0].credit_doc_start_date1.disabled=true;					
					document.forms[0].credit_doc_date1.disabled=true;
				}
				else if(setlmt_ind == 'X' && adm_rec_flag == '1')//Sponsor
				{	
					document.forms[0].credit_doc_start_date2.disabled=true;
					document.forms[0].credit_doc_date2.disabled=true;
				}

				document.forms[0].tot_valid_enc_with_gl.value = tot_valid_enc_with_gl;
				document.forms[0].tot_valid_op_enc_with_gl.value = tot_valid_op_enc_with_gl;
				document.forms[0].tot_valid_ae_enc_with_gl.value = tot_valid_ae_enc_with_gl;
				document.forms[0].tot_valid_ip_enc_with_gl.value = tot_valid_ip_enc_with_gl;
				document.forms[0].tot_valid_dc_enc_with_gl.value = tot_valid_dc_enc_with_gl;
				document.forms[0].tot_valid_enc_with_gl.disabled=true;
				document.forms[0].tot_valid_op_enc_with_gl.disabled=true;
				document.forms[0].tot_valid_ae_enc_with_gl.disabled=true;
				document.forms[0].tot_valid_ip_enc_with_gl.disabled=true;
				document.forms[0].tot_valid_dc_enc_with_gl.disabled=true;
				document.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;
				document.forms[0].tot_availed_op_enc_with_gl.value = tot_availed_op_enc_with_gl;
				document.forms[0].tot_availed_ae_enc_with_gl.value = tot_availed_ae_enc_with_gl;
				document.forms[0].tot_availed_ip_enc_with_gl.value = tot_availed_ip_enc_with_gl;
				document.forms[0].tot_availed_dc_enc_with_gl.value = tot_availed_dc_enc_with_gl;
			}
			else
			{
				if(setlmt_ind == 'R')//Credit
				{
					document.forms[0].credit_doc_start_date1.disabled=false;					
					document.forms[0].credit_doc_date1.disabled=false;
				}
				else if(setlmt_ind == 'X' && adm_rec_flag == '1')//Sponsor
				{	
					document.forms[0].credit_doc_start_date2.disabled=false;
					document.forms[0].credit_doc_date2.disabled=false;
				}

				document.forms[0].tot_valid_enc_with_gl.value = tot_valid_enc_with_gl;
				document.forms[0].tot_valid_op_enc_with_gl.value = tot_valid_op_enc_with_gl;
				document.forms[0].tot_valid_ae_enc_with_gl.value = tot_valid_ae_enc_with_gl;
				document.forms[0].tot_valid_ip_enc_with_gl.value = tot_valid_ip_enc_with_gl;
				document.forms[0].tot_valid_dc_enc_with_gl.value = tot_valid_dc_enc_with_gl;
				document.forms[0].tot_valid_enc_with_gl.disabled=false;
				document.forms[0].tot_valid_op_enc_with_gl.disabled=false;
				document.forms[0].tot_valid_ae_enc_with_gl.disabled=false;
				document.forms[0].tot_valid_ip_enc_with_gl.disabled=false;
				document.forms[0].tot_valid_dc_enc_with_gl.disabled=false;
				document.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;
				document.forms[0].tot_availed_op_enc_with_gl.value = tot_availed_op_enc_with_gl;
				document.forms[0].tot_availed_ae_enc_with_gl.value = tot_availed_ae_enc_with_gl;
				document.forms[0].tot_availed_ip_enc_with_gl.value = tot_availed_ip_enc_with_gl;
				document.forms[0].tot_availed_dc_enc_with_gl.value = tot_availed_dc_enc_with_gl;
			}
		}
	}
}

function chk_max_entry(obj,obj1)
{
	var tot_valid_enc_with_gl = obj1.value;
	var episode_type=document.forms[0].episode_type.value;
	var op_valid_enc_value = document.forms[0].tot_valid_op_enc_with_gl;
	var ae_valid_enc_value = document.forms[0].tot_valid_ae_enc_with_gl;
	var ip_valid_enc_value = document.forms[0].tot_valid_ip_enc_with_gl;
	var dc_valid_enc_value = document.forms[0].tot_valid_dc_enc_with_gl;

	if(episode_type == "O")
	{
		if(op_valid_enc_value.value != "")
		{
			if(eval(op_valid_enc_value.value) == 0)
			{
				alert(getMessage("BL6429","BL"));
				op_valid_enc_value.value='';
				op_valid_enc_value.select();
				return false;
			}
		}
	}

	if(episode_type == "E")
	{
		if(ae_valid_enc_value.value != "")
		{
			if(eval(ae_valid_enc_value.value) == 0)
			{
				alert(getMessage("BL6429","BL"));
				ae_valid_enc_value.value='';
				ae_valid_enc_value.select();
				return false;
			}
		}
	}

	if(episode_type == "I")
	{
		if(ip_valid_enc_value.value != "")
		{
			if(eval(ip_valid_enc_value.value) == 0)
			{
				alert(getMessage("BL6429","BL"));
				ip_valid_enc_value.value='';
				ip_valid_enc_value.select();
				return false;
			}
		}
	}

	if(episode_type == "D")
	{
		if(dc_valid_enc_value.value != "")
		{
			if(eval(dc_valid_enc_value.value) == 0)
			{
				alert(getMessage("BL6429","BL"));
				dc_valid_enc_value.value='';
				dc_valid_enc_value.select();
				return false;
			}
		}
	}

	if(tot_valid_enc_with_gl!="")
	{
		if( eval(obj.value) > eval(tot_valid_enc_with_gl) )
		{
			alert(getMessage("BL6427","BL"));
			obj.value='';
			obj.select();
			return false;
		}
	}
}

function chk_max_entry_total(obj)
{
	var tot_valid_enc_with_gl = obj.value;
	var episode_type=document.forms[0].episode_type.value;

	if(tot_valid_enc_with_gl != "")
	{
		var op_valid_enc_value = document.forms[0].tot_valid_op_enc_with_gl;
		var ae_valid_enc_value = document.forms[0].tot_valid_ae_enc_with_gl;
		var ip_valid_enc_value = document.forms[0].tot_valid_ip_enc_with_gl;
		var dc_valid_enc_value = document.forms[0].tot_valid_dc_enc_with_gl;
		var tot_invalid_entry = 0;
		var op_invalid_entry = 0;
		var ae_invalid_entry = 0;
		var ip_invalid_entry = 0;
		var dc_invalid_entry = 0;

		if(eval(tot_valid_enc_with_gl) == 0)
		{
			alert(getMessage("BL6430","BL"));
			obj.value='';
			obj.select();
			return false;
		}

		if(op_valid_enc_value.value != "")
		{
			if(eval(tot_valid_enc_with_gl) < eval(op_valid_enc_value.value))
			{
				tot_invalid_entry++;
				op_invalid_entry++;
			}
		}

		if(ae_valid_enc_value.value != "")
		{
			if(eval(tot_valid_enc_with_gl) < eval(ae_valid_enc_value.value))
			{
				tot_invalid_entry++;
				ae_invalid_entry++;
				ae_valid_enc_value.value=tot_valid_enc_with_gl;
			}
		}

		if(ip_valid_enc_value.value != "")
		{
			if(eval(tot_valid_enc_with_gl) < eval(ip_valid_enc_value.value))
			{
				tot_invalid_entry++;
				ip_invalid_entry++;
				ip_valid_enc_value.value=tot_valid_enc_with_gl;
			}
		}

		if(dc_valid_enc_value.value != "")
		{
			if(eval(tot_valid_enc_with_gl) < eval(dc_valid_enc_value.value))
			{
				tot_invalid_entry++;
				dc_invalid_entry++;
				dc_valid_enc_value.value=tot_valid_enc_with_gl;
			}
		}

		if(tot_invalid_entry > 0 )
		{
			alert(getMessage("BL6427","BL"));
			if(op_invalid_entry > 0)
			{
				op_valid_enc_value.value=tot_valid_enc_with_gl;
			}
			if(ae_invalid_entry > 0)
			{
				ae_valid_enc_value.value=tot_valid_enc_with_gl;
			}
			if(ip_invalid_entry > 0)
			{
				ip_valid_enc_value.value=tot_valid_enc_with_gl;
			}
			if(dc_invalid_entry > 0)
			{
				dc_valid_enc_value.value=tot_valid_enc_with_gl;
			}
		}
	}
}

</script>
</head>
<%
		if(operation.equals("Update"))
		{
%>

<body onLoad='funDisable(1);dfltslmt();curr_desc_1();disableFields();disable();' onMouseDown="CodeArrest()" >
<%
		}
		else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
		{
%>
<body onLoad='disableMappingItems();dfltslmt();curr_desc_1();disableFields();disable();' onMouseDown="CodeArrest()" >
<%
		}
		else
		{
%>
<body onLoad='funDisable(2);dfltslmt();curr_desc_1();disableFields();disable();' onMouseDown="CodeArrest()" > 
<%
		}
%>
<form name='PatFinCase2Form' id='PatFinCase2Form' method='post' action=''  scrolling=no >
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<%
		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{
%>
<td align='left' class='columnHeader' colspan='12'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td>
<%
		}
		else
		{
%>
		<th align='left' class='columnHeader' colspan='15'><fmt:message key="eBL.SLMT_DTL_DOC_REF.label" bundle="${bl_labels}"/></td>
<%
		}

		if(strModuleId.equals("MP") && (nd_settlement_ind.equals("C")))		
		{

//			if (nd_settlement_ind.equals("C"))
//				strSettlementDesc = "Cash Settlement";
				
%>
	<tr>
<!-- The following changes are done for Internationalisation Process
Align removed & legend id added by Manivel Natarajan on 10/Aug/2006 -->
<!--
			<td width="" align="right" class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Settlement Indicator</td>
			<td width="" align="left" class='label'>&nbsp;<select name='cash_settl_ind' id='cash_settl_ind' disabled ><option value='<%=nd_settlement_ind %>' selected><%=strSettlementDesc %></option></td>
			<input type='hidden' name='Case' id='Case' value='1'>
-->
<!--		<td width="25%" class="label"><fmt:message key="eBL.SLMT_INDICATOR.label" bundle="${bl_labels}"/></td>
			<td width="25%" class='fields'><select name='cash_settl_ind' id='cash_settl_ind' disabled ><option value='<%=nd_settlement_ind %>' selected><%=strSettlementDesc %></option></td>

			<td width="25%" class="label"><fmt:message key="eBL.SLMT_INDICATOR.label" bundle="${bl_labels}"/></td>
			<td width="25%" class='fields'><select name='cash_settl_ind' id='cash_settl_ind' disabled ><option value='<%=nd_settlement_ind %>' selected><fmt:message key="eBL.CASH_SETTLEMENT.label" bundle="${bl_labels}"/></option></td>
-->
		<input type='hidden' name='cash_settl_ind' id='cash_settl_ind' value='<%=nd_settlement_ind %>'>
		<input type='hidden' name='Case' id='Case' value='1'>
		<td width="25%" class="label"  ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%" ><select name='cash_set_type1' id='cash_set_type1' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
//Added By Vijay For MLMMOH-SCF-0754
		try{
			Boolean siteSpec=false;
			System.err.println("billing_group before change "+billing_group);
			siteSpec=	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
			if(siteSpec)
			{
				String billingGroup=request.getParameter("billingGroup");
				System.out.println("billing Grp "+billingGroup);	
				if(!(billingGroup==null || ("").equals(billingGroup)))
				{
					billing_group=billingGroup;
				}
			}
			System.err.println("billing_group after change  "+billing_group);
			//Ends



			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1,billing_group);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					dflt_slmt_type_code=rs2.getString(1) ;
//					System.out.println("dflt_slmt_type_code:"+dflt_slmt_type_code);
					if(dflt_slmt_type_code==null) dflt_slmt_type_code="";
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in gettng dflt_slmt_type_code "+e);
		}
			finally{
				if(rs2 !=null) rs2.close();
				pstmt.close() ;
					}
			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where status is null and language_id='"+locale+"' order by short_desc  " ) ;
			
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					if(mcash_set_type1.equals(slmt_type_code))
					{
						out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
				}
			}
			
			if(rs2 !=null) rs2.close();
			pstmt.close() ;
%>      
			</select><img src='../../eCommon/images/mandatory.gif'></td>
<%
			if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") && strSettlTypeOverride.equals("N"))
			{
%>
		<input type='hidden' name='cash_set_type1' id='cash_set_type1' value='<%=strExtSettlType %>'>
<%
			}
			if(nd_adm_rec_flag.equals("0") && strCreditDoc_YN.equals("Y"))
			{	
%>			
		<td width="25%" class="label" ><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" ><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" ><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
%>
	</tr>			

	<tr> 
		<td width="25%" class="label" ><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{									   
%>
		<td width="25%" class='fields' ><input type='text'  name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>	
		<td width="25%" class='fields'><input type='text' name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img  src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
%>
		<td width="25%"  class="label" ><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'  onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>	
		<td width="25%"  class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)%>'  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>	
<%
				}
%>	
	</tr>
<% 
			}
			else
			{
%>
		<td class="label" width="25%" ></td>
		<td class="label" width="25%" ></td>
	</tr>
<%
			}
%>		
<%
		}
		else if((nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0"))) 
		{ 
//			System.err.println("Inside Cash");
%>
	<tr>
		<td width="25%" class="label"  ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
		<input type='hidden' name='Case' id='Case' value='1'>
		<td class='fields' width="35%" ><select name='cash_set_type1' id='cash_set_type1' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
		//Added By Vijay For MLMMOH-SCF-0754
		try{
			Boolean siteSpec=false;
			System.out.println("billing_group before change "+billing_group);
			siteSpec=	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
			if(siteSpec)
			{
				String billingGroup=request.getParameter("billingGroup");
				System.out.println("billing Grp "+billingGroup);	
				if(!(billingGroup==null || ("").equals(billingGroup)))
				{
					billing_group=billingGroup;
				}
			}
			System.out.println("billing_group after change  "+billing_group);
			//Ends
			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1,billing_group);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					dflt_slmt_type_code=rs2.getString(1) ;
//					System.out.println("dflt_slmt_type_code:"+dflt_slmt_type_code);
					if(dflt_slmt_type_code==null) dflt_slmt_type_code="";
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in getting dflt_slmt_type_code "+e);
		}
			finally{
			if(rs2 !=null) rs2.close();
			pstmt.close() ;
			}
			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where status is null and language_id='"+locale+"' order by short_desc  " ) ;
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					if(mcash_set_type1.equals(slmt_type_code))
					{
						out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
				}
			}
			if(rs2 !=null) rs2.close();
			pstmt.close() ;
%>      
		</select><img src='../../eCommon/images/mandatory.gif'></td>
<% 
			if (strCreditDoc_YN.equals("N"))
			{	
%>
		<td width="25%" >&nbsp;</td>
		<td width="25%" >&nbsp;</td>
	</tr>
<%
			}
		
		/***** 
				The following code is added by Murugavel 
				for the Customization on 10 Aug 2002
				Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference
				New Variables: strCreditDoc_YN.
				New Hidden Form field: credit_doc_yn
				Credit Doc Date should accept only the future date and the

		******/

			if (strCreditDoc_YN.equals("Y"))
			{	
%>
		<td width="25%"  class="label" ><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
<!--
		<td width="25%" class='fields'><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields'><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" ><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" ><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
%>
	 </tr>			

	<tr> 
		<td width="25%" class="label" ><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td> 
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'  onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>	
		<td width="25%" class='fields'  ><input type='text' name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
%>
		<td width="25%" class="label" ><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td> 
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>	
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)%>'  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
%>
	</tr>
<!--
		<td width="" align="right" class="label" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doc Reference </td>
<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="" align="left" colspan="2">&nbsp;<input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='50' maxlength='20' value='<%=mcredit_doc_ref1%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="" align="left" colspan="2">&nbsp;<input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='60' maxlength='20'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>
		<td colspan="2">&nbsp;</td>
	</tr>
-->
<%
			}	
			if(reset_blng_grp.equals("YES") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{
				pkg_disc_disp = "display:inline";
			}
			else
			{
				pkg_disc_disp = "display:none";
			}
			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{
%>
	<tr>
		<td align='left' colspan='4'><div id='pkg_disc_disp' style='<%=pkg_disc_disp%>'><a class='label' href="javascript:packageDiscountfromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);">[<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>]</a></div></td>
	</tr>
<%
			}
/***** 
				The above code is added by Murugavel 
				for the Customization on 10 Aug 2002
				Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference.
				New Variables: strCreditDoc_YN.
				
		******/
%>

<% 
		}
		else if ( nd_settlement_ind.equals("R") ) 
		{
//			System.out.println("Inside R");
%>		
	<tr>	
		<td width="25%" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields">
			
				<select name='search_by_items' id='search_by_items' onChange='srch_by_crit_for_cust();'>
<!--
					<option value='CG' ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></option>
-->
					<option value='CY'><fmt:message key="Common.country.label" bundle="${common_labels}"/></option>
					<option value='RN' SELECTED><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></option>
				</select>
		</td>

		<td width="25%" class="label"><b id='srch_by_leg'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="srch_by_desc" id="srch_by_desc" maxlength='30' size='30'  tabindex='0' value="" onBlur="return srchbylkup('B')"><input type='button' class='button' name="srchbybut" id="srchbybut" value='?' onClick="return srchbylkup('C')" tabindex='0'><input type= 'hidden' name="search_code" id="search_code"  value=""></td>			
	</tr>
<%
			if ( mcust_1 != null || l_cust_code != null)
			{		
//6/10/2008				query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl('"+mcust_1+"','"+l_cust_code+"') and (b.cust_group_code='"+mcust_group_1+"' or '"+mcust_group_1+"' is null)";	
//String site_id= BLReportIdMapper.getCustomerId();

//if(site_id.equals("SHALM")){
	if(eglEnableCount > 0){
	//Removed insurance_yn = 'N' conditon alone for ML-MMOH-SCF-0431 by sarathkumar 29/Jun/16
	            
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
	}
	else{
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";	
	}
//				System.out.println("query_cust:"+query_cust);
		
				pstmt = con.prepareStatement(query_cust) ;
				
				pstmt.setString(1,locale);
				pstmt.setString(2,strModuleId);
				pstmt.setString(3,strModuleId);
				pstmt.setString(4,strModuleId);
				pstmt.setString(5,mcust_1);
				pstmt.setString(6,l_cust_code);
				pstmt.setString(7,mcust_group_1);
				pstmt.setString(8,mcust_group_1);
				
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						cust_code_1 = rs.getString( "cust_code" ) ;
						short_name_1 = rs.getString( "short_name" ) ;
						cust_group_code_1 = rs.getString( "CUST_GROUP_CODE" ) ;
						cust_group_desc_1 = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (cust_code_1 == null ) cust_code_1 = "";
				if (short_name_1 == null ) short_name_1 = "";	
				if (cust_group_code_1 == null ) cust_group_code_1 = "";	
				if (cust_group_desc_1 == null ) cust_group_desc_1 = "";	
				if (cust_valid_from_date == null) cust_valid_from_date = "";
				if (cust_valid_to_date == null) cust_valid_to_date = "";
			}
		
			if(!mcust_1.equals(""))
			{
				String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code='"+mcust_1+"' and language_id='"+locale+"'";
//				System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
				pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
				rs = pstmt.executeQuery();

				if( rs != null )
				{
					while( rs.next() ) 
					{
						str_cust_curr_code = rs.getString(1);
						str_cust_curr_desc = rs.getString(2);
					}
					if(str_cust_curr_code == null) str_cust_curr_code="";
					if(str_cust_curr_desc == null) str_cust_curr_desc="";

					if (rs != null) rs.close();
						if(pstmt != null) pstmt.close();	
				}	
			}
//			System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//			System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);
%>		
	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields"><input type='text' name="cust_group_desc_1" id="cust_group_desc_1" maxlength='15' size='30'  tabindex='0' value="<%=cust_group_desc_1%>" onBlur="return credit_custgrouplkup('B')"><input type='button' class='button' name="cust1but" id="cust1but" value='?' onClick="return credit_custgrouplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'><input type= 'hidden' name="cust_group_code_1" id="cust_group_code_1"  value="<%=cust_group_code_1%>"></td>
		<td width="25%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>

	<tr> 
		<td width="25%" class="label"><a href="javascript:getCustDet();"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="cust_curr_desc_disp" style="display:none"><Font color='red'><b id="cust_curr_desc_val"></b></font></div>	
		<input type='hidden' name='Case' id='Case' value='2'></td>
		<td width="25%" class='fields' nowrap><input type='text' name="cust_1_desc" id="cust_1_desc" maxlength='40' size='30'  tabindex='0' value="<%=short_name_1%>" onBlur="return credit_custlkup('B')"><input type='button' class='button' name="cust1but" id="cust1but" value='?' onClick="return credit_custlkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>

		<input type= hidden name="cust_1" id="cust_1"  value="<%=cust_code_1%>">
		<input type='hidden' name='cust_curr_code' id='cust_curr_code' value="<%=str_cust_curr_code%>">
		<input type= "hidden" name="cust_curr_desc" id="cust_curr_desc"  value="<%=str_cust_curr_desc%>">
		<input type= hidden name="cust_valid_from_date" id="cust_valid_from_date"  value="<%=cust_valid_from_date%>">
		<input type= hidden name="cust_valid_to_date" id="cust_valid_to_date"  value="<%=cust_valid_to_date%>">

		<!--
		
		<td width="" align="right" class="label"><a href="javascript:getCustDet();">Customer</a>	
		<input type='hidden' name='Case' id='Case' value='2'></td>
		<td width="" align="left" colspan="2"><select name='cust_1' id='cust_1'  ><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----Select-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <%
	//	if(ar_install_yn.equals("Y"))
		
		query_cust="select cust_code, short_name from ar_customer where patient_flag = 'Y' and pat_com_flag = 'Y' and status is null and ((? in ('OP','AE') and nvl(op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(ip_yn,'N') = 'Y') or ? = 'MP') order by short_name";
		

		/************
		else if(ar_install_yn.equals("N"))
		{
			query_cust="select cust_code, short_name from bl_emp_ins_mst where status is null and insurance_yn='Y' and blng_grp_id='"+billing_group+"' order by short_name";
		}
		***********/
		pstmt = con.prepareStatement(query_cust) ;
		pstmt.setString(1,strModuleId);
		pstmt.setString(2,strModuleId);
		pstmt.setString(3,strModuleId);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				String cust_code = rs.getString( "cust_code" ) ;
				String short_name = rs.getString( "short_name" ) ;
				//if(billing_mode.equals("Modify"))
				//{
					if(mcust_1.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}
					else if(l_cust_code.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}				
					
					else
					{
						out.println("<option value=\""+cust_code+"\">"+short_name+"</option>");
					}
				//}
				//out.println( "<option value='" + cust_code + "' >" + short_name ) ;
			}
		}
		pstmt.close() ;
		%>

	     </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>		
		 -->
	
		<td width="25%" class="label"><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
		<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
		%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref1)"><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=mcredit_doc_ref1%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref1)"><img src='../../eCommon/images/mandatory.gif'></td>
		<%
			}
			else
			{
		%>
<!--
			<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref1)"><img src='../../eCommon/images/mandatory.gif'></td>
-->
			<td width="25%" class='fields' ><input type='text' name='credit_doc_ref1' id='credit_doc_ref1' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref1)"><img src='../../eCommon/images/mandatory.gif'></td>
		<%
			}
		%>
			
   </tr>

	<tr>
		<td width="25%"  class="label"><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>
<%	
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_start_date1' id='credit_doc_start_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date1',document.forms[0].credit_doc_start_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>     
		<td width="25%" class="label"><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
 <%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date1' id='credit_doc_date1' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date1',document.forms[0].credit_doc_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>	
	</tr>
	</tr>
<%
			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{
%>
	<tr>
		<td align='left' colspan='4'><div id='pkg_disc_disp' style='display:none'><a class='label' href="javascript:packageDiscountfromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);">[<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>]</a></div></td>
	</tr>
<%
			}
			if(!(strModuleId.equals("MP")) && !(str_function_id.equals("BOOKING")))
			{
%>	
	<tr>
		<td align='left' class='columnHeader' colspan='4'><fmt:message key="eBL.MAX_NO_OF_ENC_ALLOW_FOR_CREDIT_DOC.label" bundle="${bl_labels}"/></td>
	</tr>

	<tr>
		<td width="25%"  class="label" colspan=4>
			<fmt:message key="Common.total.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_enc_with_gl' id='tot_valid_enc_with_gl' size='3' maxlength='3' value='<%=rtn_tot_valid_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry_total(this)'><input type='hidden' name='tot_availed_enc_with_gl' id='tot_availed_enc_with_gl' value='<%=rtn_no_of_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_op_enc_with_gl' id='tot_valid_op_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_op_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_op_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_op_enc_with_gl' id='tot_availed_op_enc_with_gl' value='<%=rtn_no_of_op_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_ae_enc_with_gl' id='tot_valid_ae_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_ae_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_ae_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_ae_enc_with_gl' id='tot_availed_ae_enc_with_gl' value='<%=rtn_no_of_ae_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_ip_enc_with_gl' id='tot_valid_ip_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_ip_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_ip_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_ip_enc_with_gl' id='tot_availed_ip_enc_with_gl' value='<%=rtn_no_of_ip_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_dc_enc_with_gl' id='tot_valid_dc_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_dc_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_dc_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_dc_enc_with_gl' id='tot_availed_dc_enc_with_gl' value='<%=rtn_no_of_dc_enc_gl_availed%>'>
		</td>
	</tr>
<%
			}
			else
			{
%>
<!--
		<input type='hidden' name='gl_doc_ref_exist_YN' id='gl_doc_ref_exist_YN' value='<%=rtn_gl_doc_ref_exist_YN%>'>
-->
		<input type='hidden' name='tot_valid_enc_with_gl' id='tot_valid_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_op_enc_with_gl' id='tot_valid_op_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_ae_enc_with_gl' id='tot_valid_ae_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_ip_enc_with_gl' id='tot_valid_ip_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_dc_enc_with_gl' id='tot_valid_dc_enc_with_gl' value=''>

		<input type='hidden' name='tot_availed_enc_with_gl' id='tot_availed_enc_with_gl' value='<%=rtn_no_of_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_op_enc_with_gl' id='tot_availed_op_enc_with_gl' value='<%=rtn_no_of_op_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_ae_enc_with_gl' id='tot_availed_ae_enc_with_gl' value='<%=rtn_no_of_ae_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_ip_enc_with_gl' id='tot_availed_ip_enc_with_gl' value='<%=rtn_no_of_ip_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_dc_enc_with_gl' id='tot_availed_dc_enc_with_gl' value='<%=rtn_no_of_dc_enc_gl_availed%>'>
<%
			}   
		}
		else if((nd_settlement_ind.equals("X") && nd_adm_rec_flag.equals("1"))
		/*||strCreditDoc_YN.equals("Y")*/
	   ) 
		{  //System.err.println("Inside X 1");
%>
		<!--
		<tr>
		<td width="" >&nbsp;</td>
		<td width=""  colspan="5">&nbsp;<input type='hidden' name='Case' id='Case' value='3'></td>
		</tr>
		-->
<!--
    <tr>
		<td width="25%"  class="label"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' readonly name="cust_group_desc" id="cust_group_desc" maxlength='30' size='30'  tabindex='0' value=""><input type='button' class='button' name="custgroupbut" id="custgroupbut" value='?' onClick="return custgrouplkup1()" tabindex='0'></td>
		<input type= hidden name="cust_group_1" id="cust_group_1"  value="">		
-->		
	<tr>	
		<td width="25%" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></div></td>
		<td width="25%" class="fields">
			
				<select name='search_by_items' id='search_by_items' onChange='srch_by_crit_for_cust();'>
<!--
					<option value='CG' SELECTED><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></option>
-->
					<option value='CY'><fmt:message key="Common.country.label" bundle="${common_labels}"/></option>
					<option value='RN' SELECTED><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></option>
				</select>
		</td>

		<td width="25%" class="label"><b id='srch_by_leg'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="srch_by_desc" id="srch_by_desc" maxlength='30' size='30'  tabindex='0' value="" onBlur="return srchbylkup('B')"><input type='button' class='button' name="srchbybut" id="srchbybut" value='?' onClick="return srchbylkup('C')" tabindex='0'><input type= hidden name="search_code" id="search_code"  value=""></td>			
	</tr>
<%
			if ( mcust_2 != null )
			{		

//6/10/2008				query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b  where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'N'   and nvl (a.insurance_yn,'N') = 'N'  and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl('"+mcust_2+"','"+l_cust_code+"') and (b.cust_group_code='"+mcust_group_2+"' or '"+mcust_group_2+"' is null)";
					if(eglEnableCount > 0){
					//Removed insurance_yn = 'N' conditon alone for ML-MMOH-SCF-0431 by sarathkumar 29/Jun/16
				
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
					}
					else{
						query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
					}
				pstmt = con.prepareStatement(query_cust) ;
//				System.out.println("query_cust:"+query_cust);

				pstmt.setString(1,locale);
				pstmt.setString(2,strModuleId);
				pstmt.setString(3,strModuleId);
				pstmt.setString(4,strModuleId);
				pstmt.setString(5,mcust_2);
				pstmt.setString(6,l_cust_code);
				pstmt.setString(7,mcust_group_1);
				pstmt.setString(8,mcust_group_1);
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						cust_code_2 = rs.getString( "cust_code" ) ;
						short_name_2 = rs.getString( "short_name" ) ;
						cust_group_code_2 = rs.getString( "CUST_GROUP_CODE" ) ;
						cust_group_desc_2 = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;
	
				if (cust_code_2 == null ) cust_code_2 = "";
				if (short_name_2 == null ) short_name_2 = "";	
				if (cust_group_code_2 == null ) cust_group_code_2 = "";	
				if (cust_group_desc_2 == null ) cust_group_desc_2 = "";	
				if (cust_valid_from_date == null ) cust_valid_from_date = "";	
				if (cust_valid_to_date == null ) cust_valid_to_date = "";	
			}

			if(!mcust_2.equals(""))
			{
				String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code='"+mcust_2+"' and language_id='"+locale+"'";
//				System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
				pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
				rs = pstmt.executeQuery();

				if( rs != null )
				{
					while( rs.next() ) 
					{
						str_cust_curr_code = rs.getString(1);
						str_cust_curr_desc = rs.getString(2);
					}
					if(str_cust_curr_code == null) str_cust_curr_code="";
					if(str_cust_curr_desc == null) str_cust_curr_desc="";

					if (rs != null) rs.close();
					if(pstmt != null) pstmt.close();	
				}	
			}
//			System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//			System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);
%>
<%
//System.out.println("str_credit_doc_reqd_yn  "+str_credit_doc_reqd_yn);
//String strCustomerId= BLReportIdMapper.getCustomerId(); //V210413
boolean setEmpty=false;
//if(strCustomerId.equals("SHALM")&&strCreditDoc_YN.equals("Y"))
	if((eglEnableCount > 0) && strCreditDoc_YN.equals("Y"))

{
	/*Code added by Karthik to check whether to make 5 fields (cust grp,cust,doc ref,doc start date,doc end date) blank */
	if(strEpisodeType.equalsIgnoreCase("O") || strEpisodeType.equalsIgnoreCase("E")){//for OP and Emergency cases
		
		String startDate="";
		String endDate="";
		
			if((billing_mode.equals("Modify")) || (operation.equals("Update"))){
				startDate=mcredit_doc_start_date2;
				endDate=mcredit_doc_date2;
			}else{	
				startDate=l_credit_doc_ref_start_date;
				endDate=l_credit_doc_ref_date;
			}
			/* If date range does not fall within from date and to date, then set fileds to blank */
			if( endDate!=null && !endDate.equals("") ){				 
				if(com.ehis.util.DateUtils.isAfterNow(endDate, "DMY", locale)==false){ //sysdate is greater than end date i.e, sysdate doesnot fall within startdate and end date range 
					setEmpty=true;	
				}
			}

			
			
		}else if(strEpisodeType.equalsIgnoreCase("I") || strEpisodeType.equalsIgnoreCase("D") ){//for IP and Daycare Cases
			
		setEmpty=true;
		
	}
%>
<div id='egl_id_type' >
<tr>	
<td width="25%"  class="label" ><fmt:message key="eBL.IDENTIFY_TYPE.label" bundle="${bl_labels}"/></td>
<td width="25%"  class='fields' ><select name="identify_type" id="identify_type" id='identify_type' tabIndex='3' >
		
<!--<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<option value="01">Old IC</option>
<option value="02">New IC (Eliminate dash)</option>
<option value="03">Millitary Card Number</option>
<option value="04">Police Card Number</option>
<option value="05">Mother's IC </option>
<option value="06">Father's IC </option>
<option value="07">Work Permit</option>
<option value="08">Passport</option>
<option value="09">Birth Certificate</option>
<option value="10">Pension Card</option>
<option value="11">Driving License</option>
<option value="20">MRN</option> -->

<%
			pstmt = con.prepareStatement( "select LIST_ELMT_VALUE,LIST_ELMT_LABEL  from SM_LIST_ITEM   where module_id = 'BL'  and   list_Ref  ='BLTVSTFN_EGL_IND_TYPE'  and function_id ='BL_MODIFY_FIN_DTLS'  order by list_srl_no" );
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String identifier_code = rs1.getString( "LIST_ELMT_VALUE" ) ;
					String identifier_desc = rs1.getString( "LIST_ELMT_LABEL" ) ;

					    if(identifier_code.equals("02"))
						out.println("<option value=\""+identifier_code+"\" selected>"+identifier_desc+"</option>");
						else
						out.println("<option value=\""+identifier_code+"\">"+identifier_desc+"</option>");
				
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;
%>      
</select>
<%
			pstmt = con.prepareStatement( "select NVL(NATIONAL_ID_NO,ALT_ID1_NO) nid from mp_patient   where patient_id=?  " );
			pstmt.setString(1,patient_id);
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					 nid = rs1.getString( "nid" ) ;		
					 if(nid==null) nid="";
				
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;
%>      
<img src='../../eCommon/images/mandatory.gif'>
<td width="25%"  class="label" ><fmt:message key="eBL.NID.label" bundle="${bl_labels}"/></td>
<td width="25%"  class='fields' > <input type ='text' id='nid' name='nid' id='nid' value='<%=nid%>' size=30 length=20>
<img src='../../eCommon/images/mandatory.gif'>&nbsp;


<input type=button class='button' id='eGL' name='eGL' id='eGL' value="eGL" onClick="eGLInterface()" <%= (eglEnableCount == 0)? "disabled" :"" %> >


 </td>
</div>
</tr>
<%} %>
	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields"><input type='text' name="cust_group_desc_2" id="cust_group_desc_2" maxlength='15' size='30'  tabindex='0' value="<%= (setEmpty==true)?"": cust_group_desc_2%>" onBlur="return custgrouplkup1('B')"><input type='button' class='button' name="cust1but" id="cust1but" value='?' onClick="return custgrouplkup1('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'><input type= 'hidden' name="cust_group_code_2" id="cust_group_code_2"  value="<%=cust_group_code_2%>"></td>
		<td width="25%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>

	<tr>
		<td width="25%" class="label"><a href="javascript:getCustDetSponser();"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="cust_curr_desc_disp" style="display:none" align='right'><Font color='red'><b id="cust_curr_desc_val"></b></font></div>
		<input type='hidden' name='Case' id='Case' value='3'></td>
		<td width="25%%" class='fields' ><input type='text' name="cust_2_desc" id="cust_2_desc" maxlength='40' size='30'  tabindex='0' value="<%=(setEmpty==true)?"":short_name_2%>" onBlur="return cust2grouplkup('B')"><input type='button' class="button" name="cust2but" id="cust2but" value='?' onClick="return cust2grouplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>

		<input type= hidden name="cust_2" id="cust_2"  value="<%=cust_code_2%>">
		<input type='hidden' name='cust_curr_code' id='cust_curr_code' value="<%=str_cust_curr_code%>">
		<input type= "hidden" name="cust_curr_desc" id="cust_curr_desc"  value="<%=str_cust_curr_desc%>">
		<input type= hidden name="cust_valid_from_date" id="cust_valid_from_date"  value="<%=cust_valid_from_date%>">
		<input type= hidden name="cust_valid_to_date" id="cust_valid_to_date"  value="<%=cust_valid_to_date%>">

		<td width="25%"  class="label"><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
<!--
		<td width="25%" class='fields'  ><input type='text' name='credit_doc_ref2' id='credit_doc_ref2' size='30' maxlength='30' value="<%=mcredit_doc_ref2%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref2)"><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields'  ><input type='text' name='credit_doc_ref2' id='credit_doc_ref2' size='30' maxlength='30' value="<%=(setEmpty==true)?"":mcredit_doc_ref2%>"  onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref2)"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}	
			else
			{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref2' id='credit_doc_ref2' size='30' maxlength='30' value="<%=l_credit_doc_ref_desc%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref2)"><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref2' id='credit_doc_ref2' size='30' maxlength='30' value="<%=(setEmpty==true)?"":l_credit_doc_ref_desc%>"  onBlur="chk_for_gl_valid(document.forms[0].credit_doc_ref2)"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>
		
     </tr>

	<tr>
	 	<td width="25%" class="label"><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td> 
 <%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_start_date2' id='credit_doc_start_date2' size='10' maxlength='10'  value='<%=(setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date2,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);'><img name='credit_doc_start_date2Img' src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_start_date2',document.forms[0].credit_doc_start_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_start_date2' id='credit_doc_start_date2' size='10' maxlength='10' value='<%=(setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)%>' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);'><img name='credit_doc_start_date2Img'  src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);'onClick="return showCalendar_loc('credit_doc_start_date2',document.forms[0].credit_doc_start_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>
		<td width="25%"  class="label"><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
 <%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date2' id='credit_doc_date2' size='10' maxlength='10' value='<%=(setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(mcredit_doc_date2,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);'><img name='credit_doc_date2Img'  src="../../eCommon/images/CommonCalendar.gif"  onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date2',document.forms[0].credit_doc_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date2' id='credit_doc_date2' size='10' maxlength='10' value='<%=(setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);'><img  name='credit_doc_date2Img'  src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);' onClick="return showCalendar_loc('credit_doc_date2',document.forms[0].credit_doc_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>	
	</tr>
<%
			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{
%>
	<tr>
		<td align='left' colspan='4'><div id='pkg_disc_disp' style='display:none'><a class='label' href="javascript:packageDiscountfromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);">[<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>]</a></div></td>
	</tr>
<%
			}
			if(!(strModuleId.equals("MP")) && !(str_function_id.equals("BOOKING")))
			{
%>
	<tr>
		<td align='left' class='columnHeader' colspan='4'><fmt:message key="eBL.MAX_NO_OF_ENC_ALLOW_FOR_CREDIT_DOC.label" bundle="${bl_labels}"/></td>
	</tr>

	<tr>
		<td width="25%"  class="label" colspan=4>
			<fmt:message key="Common.total.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_enc_with_gl' id='tot_valid_enc_with_gl' size='3' maxlength='3' value='<%=rtn_tot_valid_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry_total(this)'><input type='hidden' name='tot_availed_enc_with_gl' id='tot_availed_enc_with_gl' size='3' maxlength='3' value='<%=rtn_no_of_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			
			<fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_op_enc_with_gl' id='tot_valid_op_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_op_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_op_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_op_enc_with_gl' id='tot_availed_op_enc_with_gl' size='3' maxlength='3' value='<%=rtn_no_of_op_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_ae_enc_with_gl' id='tot_valid_ae_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_ae_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_ae_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_ae_enc_with_gl' id='tot_availed_ae_enc_with_gl' size='3' maxlength='3' value='<%=rtn_no_of_ae_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_ip_enc_with_gl' id='tot_valid_ip_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_ip_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_ip_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_ip_enc_with_gl' id='tot_availed_ip_enc_with_gl' size='3' maxlength='3' value='<%=rtn_no_of_ip_enc_gl_availed%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<input type='text' name='tot_valid_dc_enc_with_gl' id='tot_valid_dc_enc_with_gl' size='2' maxlength='2' value='<%=rtn_tot_valid_dc_enc_with_gl%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chk_max_entry(document.forms[0].tot_valid_dc_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)'><input type='hidden' name='tot_availed_dc_enc_with_gl' id='tot_availed_dc_enc_with_gl' size='3' maxlength='3' value='<%=rtn_no_of_dc_enc_gl_availed%>'>

<!--
			<input type='hidden' name='gl_doc_ref_exist_YN' id='gl_doc_ref_exist_YN' value='<%=rtn_gl_doc_ref_exist_YN%>'>
-->
		</td>
	</tr>
<%
			}
			else
			{
%>
<!--
		<input type='hidden' name='gl_doc_ref_exist_YN' id='gl_doc_ref_exist_YN' value='<%=rtn_gl_doc_ref_exist_YN%>'>
-->
		<input type='hidden' name='tot_valid_enc_with_gl' id='tot_valid_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_op_enc_with_gl' id='tot_valid_op_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_ae_enc_with_gl' id='tot_valid_ae_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_ip_enc_with_gl' id='tot_valid_ip_enc_with_gl' value=''>
		<input type='hidden' name='tot_valid_dc_enc_with_gl' id='tot_valid_dc_enc_with_gl' value=''>

		<input type='hidden' name='tot_availed_enc_with_gl' id='tot_availed_enc_with_gl' value='<%=rtn_no_of_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_op_enc_with_gl' id='tot_availed_op_enc_with_gl' value='<%=rtn_no_of_op_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_ae_enc_with_gl' id='tot_availed_ae_enc_with_gl' value='<%=rtn_no_of_ae_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_ip_enc_with_gl' id='tot_availed_ip_enc_with_gl' value='<%=rtn_no_of_ip_enc_gl_availed%>'>
		<input type='hidden' name='tot_availed_dc_enc_with_gl' id='tot_availed_dc_enc_with_gl' value='<%=rtn_no_of_dc_enc_gl_availed%>'>

<%
			}
		} 
		else if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2")) 
		{
			if(ins_auth_flag.equals("N"))
			{
%>
<!-- The following changes are done for Internationalisation Process
blank row removed by Manivel Natarajan on 10/Aug/2006 -->
<!--
	<tr><td colspan='6'>&nbsp;</td></tr>
-->
		<!--<tr><td colspan='6'>&nbsp;</td></tr>-->
<%
			}
%>
    <tr>
		<td width="25%"  class="label" ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/><input type='hidden' name='Case' id='Case' value='4'></td> 
	
		<td width="25%" class='fields' ><select name='cust_3' id='cust_3' onchange='return changeOnSelectCustomer(this);'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
	//	if(ar_install_yn.equals("Y"))
		//{
			query_cust="select cust_code, short_name from ar_customer_lang_vw where language_id=? and patient_flag = 'Y' and pat_com_flag = 'N'  and nvl(insurance_yn,'Y') = 'Y'   and status is null  and ((? in ('OP','AE') and nvl(op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y'))  order  by short_name";
		//}
		//else
		//{
		//	query_cust="select cust_code, short_name from bl_emp_ins_mst where status is null and insurance_yn='Y' and blng_grp_id='"+billing_group+"' order by short_name";
		//}
			pstmt = con.prepareStatement(query_cust) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,strModuleId);
			pstmt.setString(3,strModuleId);
			pstmt.setString(4,strModuleId);
			
		    rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					cust_code1 = rs.getString( "cust_code" ) ;
					String short_name = rs.getString( "short_name" ) ;
					cust_code1=cust_code1.trim();
					//out.println("<script>alert("+mcust_3+");</script>");
					//	out.println("<script>alert("+cust_code1+");</script>");
					//if(billing_mode.equals("Modify"))
					//{
					if(mcust_3.equals(cust_code1))
					{
						out.println("<option selected value=\""+cust_code1+"\">"+short_name+"</option>");
					}
					else
					{
						out.println("<option value=\""+cust_code1+"\">"+short_name+"</option>");
					}
				//}
				//out.println( "<option value='" + cust_code1 + "' >" + short_name ) ;
				}
			}
			if(rs !=null) rs.close();
			pstmt.close() ;
%>      
	   </select><img src='../../eCommon/images/mandatory.gif'></td>
<%
			String query_policy_type="select policy_type_code, short_desc from bl_ins_policy_types_lang_vw where language_id='"+locale+"' and policy_type_code = '"+mpolicy_type+"' and nvl(status,'N') <> 'S'  order  by short_desc";
		//out.println("query_policy_type :"+query_policy_type);
%>
<!--	<td width="" align="right" class="label"><a href="javascript:getPolicySearch();">Policy Type</a></td>
-->
		<td width="25%"  class="label" ><a href="javascript:getPolicySearch();"><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></a></td>

<!--	<td width="" align="left" colspan="2"> -->
		<td width="25%" class='fields' ><select name='policy_type' id='policy_type'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			pstmt = con.prepareStatement(query_policy_type) ;
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					String policy_type_code = rs.getString( "policy_type_code" ) ;
					String short_desc = rs.getString( "short_desc" ) ;
					//if(billing_mode.equals("Modify"))
					//{
						if(mpolicy_type.equals(policy_type_code))
						{
							out.println("<option selected value=\""+policy_type_code+"\">"+short_desc+"</option>");
						}
						else
						{
							out.println("<option value=\""+policy_type_code+"\">"+short_desc+"</option>");
						}
					//}
					//out.println( "<option value='" + policy_type_code + "' >" + short_desc ) ;
				}
			}
			if(rs !=null) rs.close();
			pstmt.close() ;
%>      
		</select><img src='../../eCommon/images/mandatory.gif'><!--<a href="javascript:getPolicySearch();">View Policy</a>--><!--<input type='button' class='button' name='policy_search' id='policy_search' value='?' onClick='return getPolicySearch();'>--></td>
	</tr>
	<tr>
	    <td width="" class="label"><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='policy_no' id='policy_no' size='30' maxlength='30' value="<%=mpolicy_no%>" ><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields'><input type='text' name='policy_no' id='policy_no' size='30' maxlength='30'><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>
		<td width="25%"  class="label"><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
 <%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td class='fields' width="25%"  ><input type='text' name='policy_expiry_date' id='policy_expiry_date' size='10' maxlength='10' value='<%=mpolicy_expiry_date%>'onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_expiry_date',document.forms[0].policy_expiry_date);" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);'><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td class='fields' width="25%" ><input type='text' name='policy_expiry_date' id='policy_expiry_date' size='10' maxlength='10' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_expiry_date',document.forms[0].policy_expiry_date);" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);'><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>
	</tr>
	
	<tr>
		<td class='label' width="25%" class="label"><a href="javascript:getNonInsBlngGrpSearch();"><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></a></td>	

<%
			pstmt = con.prepareStatement( "select blng_grp_id, short_desc ,DECODE(?,'MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category from bl_blng_grp_lang_vw where language_id=? and (( status is null and settlement_ind || adm_rec_flag != 'X2' and ((?='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or (?='AE' and ae_yn = 'Y') or (?='OP' and op_yn = 'Y') or (?='IP' and ip_yn = 'Y') or (?='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED'))) or (blng_grp_id = ? and NVL(?,'N') = 'Y')) order  by short_desc" ) ;
			
			pstmt.setString(1,strModuleId);
			pstmt.setString(2,locale);
			pstmt.setString(3,strModuleId);
			pstmt.setString(4,strModuleId);
			pstmt.setString(5,strModuleId);
			pstmt.setString(6,strModuleId);
			pstmt.setString(7,strModuleId);
			pstmt.setString(8,strCitizenYn);
			pstmt.setString(9,mnon_insur_blng_grp);
			pstmt.setString(10,strdfltbgyn);	

			rs = pstmt.executeQuery() ;		
			
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					String non_blng_grp_id = rs.getString( "blng_grp_id" ) ;
					String short_desc = rs.getString( "short_desc" ) ;

					if((mnon_insur_blng_grp.equals(non_blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
					{
						str_blng_grp_id = non_blng_grp_id;
						str_short_desc = short_desc;

						strBlngGrpAppYN = rs.getString("episode_type_app_yn");
						strBlngGrpStatus = rs.getString("status");
						strCategory = rs.getString("category");

						if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";		
						if(strBlngGrpStatus == null ||strBlngGrpStatus.equals("null")) 
						strBlngGrpStatus="";
						if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
						strCategory="UNRESTRICTED";		

						/*out.println("<option selected value=\""+non_blng_grp_id+"\">"+short_desc+"</option>");*/

						if (strCitizenYn.equals("Y"))
						{
							if (strCategory.equals("UNRESTRICTED") || strCategory.equals("NATIONALS"))
							{
								strBlngGrpCatgAppYN = "Y";
							}
							else
							{
								strBlngGrpCatgAppYN = "N";

							}
						}
						else
						{
							if (strCategory.equals("UNRESTRICTED") || strCategory.equals("OTHERS"))
							{
								strBlngGrpCatgAppYN = "Y";
							}
							else
							{
								strBlngGrpCatgAppYN = "N";

							}
						}
					}
					else
					{
						/*
						out.println("<option value=\""+non_blng_grp_id+"\">"+short_desc+"</option>");
						*/
					}

				//}
				//out.println( "<option value='" + non_blng_grp_id + "' >" + short_desc ) ;
				}	
			}
			if(rs !=null) rs.close();
			pstmt.close() ;
%>

	 <!--
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	 -->

		<td class='fields' width="25%"><input type='text' readonly name="non_ins_billing_group_desc" id="non_ins_billing_group_desc" maxlength='30' size='30' tabindex='0' value="<%=str_short_desc%>" ><input type='button' class='button' name="noninsblnggrpbut" id="noninsblnggrpbut" value='?' onClick="return noninsblnggrplkup()" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>

		<input type= hidden name="non_insur_blng_grp" id="non_insur_blng_grp"  value="<%=str_blng_grp_id%>">

		<td width="25%" ></td>
		<td width="25%" ></td>
	</tr>
<%
			if(ins_auth_flag.equals("Y"))
			{
%>
   <tr>
		<td width="25%" class="label"><fmt:message key="eBL.CREDIT_AUTH_REF.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="25%"  ><input type='text' name='credit_auth_ref' id='credit_auth_ref' size='20' maxlength='20' value="<%=mcredit_auth_ref%>"></td>
		<td  width="25%" class="label"><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="25%" ><input type='text' name='credit_auth_date' id='credit_auth_date' size='10' maxlength='10' value='<%=mcredit_auth_date%>' onBlur='return chkDtLessWithSysDate(this,sys_date);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('credit_auth_date',document.forms[0].credit_auth_date);" onBlur='return chkDtLessWithSysDate(document.forms[0].credit_auth_date,sys_date);'></td>
	</tr>
	
	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="25%" ><input type='text' name='app_days' id='app_days' size='3' maxlength='3' value='<%=mapp_days%>' onBlur='return valfield(this);'></td>
		<td width="25%" class="label"><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="25%" ><input type='text' name='app_amount' id='app_amount' size='10' maxlength='10' value='<%=mapp_amount%>' onBlur='return valfield(this);'></td>
	</tr>

	<tr>
		<td width="25%"  class="label"><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%"  ><input type='text' name='eff_frm_date' id='eff_frm_date' size='10' maxlength='10' value='<%=meff_frm_date%>' onBlur='return chkDtLessWithSysDate(this,sys_date);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('eff_frm_date',document.forms[0].eff_frm_date);" onBlur='return chkDtLessWithSysDate(document.forms[0].eff_frm_date,sys_date);'></td>
		<td width=""></td>
		<td width=""></td>
    </tr>
	
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
<%
			}
			else
			{
%>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr><td colspan=6>&nbsp;</td></tr>
<%
			}
		}
%>
	<tr>
		<td width='25%'>&nbsp;</td>
		<td width='25%'>&nbsp;</td>
		<td width='25%'>&nbsp;</td>
		<td width='25%'>&nbsp;</td>
	</tr>

<input type='hidden' name='gl_doc_ref_exist_YN' id='gl_doc_ref_exist_YN' value='<%=rtn_gl_doc_ref_exist_YN%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=str_facility_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='episode_type' id='episode_type' value='<%=strEpisodeType%>'>
<input type='hidden' name='billing_group' id='billing_group' value='<%=billing_group%>'>
<input type='hidden' name='setlmt_ind' id='setlmt_ind' value='<%=nd_settlement_ind%>'>
<input type='hidden' name='adm_rec_flag' id='adm_rec_flag' value='<%=nd_adm_rec_flag%>'>	
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value='<%=ins_auth_flag%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value='<%=strCreditDoc_YN%>'>
<input type='hidden' name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
<input type='hidden' name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
<input type='hidden' name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	
<input type='hidden' name="function_id" id="function_id" value='<%=str_function_id%>'>	
<input type='hidden' name="operation_fun" id="operation_fun" value='<%=operation%>'>	
<input type='hidden' name="operation_mode" id="operation_mode" value='<%=billing_mode%>'>	
<input type='hidden' name="billing_mode" id="billing_mode" value='<%=billing_mode%>'>	
<input type=hidden name='operation' id='operation'	value='<%=operation%>'>
<input type='hidden' name='CitizenYn' id='CitizenYn' value='<%=strCitizenYn%>'>
<input type='hidden' name='blnggrpappyn' id='blnggrpappyn' value='<%=strBlngGrpAppYN%>'>		
<input type='hidden' name='blnggrpcatgappyn' id='blnggrpcatgappyn' value='<%=strBlngGrpCatgAppYN%>'>
<input type='hidden' name='BlngGrpStatus' id='BlngGrpStatus' value='<%=strBlngGrpStatus%>'>		
<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type='hidden' name="dflt_slmt_type_code" id="dflt_slmt_type_code"  value='<%=dflt_slmt_type_code%>'>
<input type='hidden' name="sel_frm_prev_enc" id="sel_frm_prev_enc"  value='<%=sel_frm_prev_enc%>'>

<input type='hidden' name='selecltd_cust_grp_frm_pkg' id='selecltd_cust_grp_frm_pkg' value="<%=str_cust_grp_code_for_pkg%>">
<input type='hidden' name='selecltd_cust_frm_pkg' id='selecltd_cust_frm_pkg' value="<%=str_cust_code_for_pkg%>">

<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value='<%=encounter_date_aft_trunc%>'>

<input type='hidden' name='third_party_gl_in_use_yn' id='third_party_gl_in_use_yn' value='<%=third_party_gl_in_use_yn%>'>

<input type='hidden' name='cash_slmt_type' id='cash_slmt_type' value='<%=mcash_set_type1%>'>
<input type='hidden' name='package_enabled_yn' id='package_enabled_yn' value='<%=package_enabled_yn%>'>

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
<input type='hidden' name='payerGrpBySetup' id='payerGrpBySetup' value='<%=payerGrpBySetup%>'>
<input type=hidden name='logged_user_id' id='logged_user_id'   value='<%=strLoggedUser%>'>
<input type='hidden' name='strclientip' id='strclientip' value='<%=strclientip%>'>
<input type='hidden' name='site_id' id='site_id' value='<%=site_id%>'> 


</table>
</form>
</body>
</html>
<% 
	}
	catch(Exception e)
	{ 
		out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt1 != null)		stmt1.close();
		if(pstmt != null) 	pstmt.close(); 	
		if(pstmt1 != null)	pstmt1.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

