<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,com.ehis.util.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
    ResultSet rset          = null;
	StringBuffer SqlSB		= new StringBuffer();
	String system_date		= "";
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
	String call_function	= request.getParameter("call_function")==null?"":request.getParameter("call_function");

	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_num	= request.getParameter("cert_num")==null?"":request.getParameter("cert_num");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_from_date	= request.getParameter("cert_from_date")==null?"":request.getParameter("cert_from_date");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_to_date	= request.getParameter("cert_to_date")==null?"":request.getParameter("cert_to_date");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String duration	= request.getParameter("duration")==null?"":request.getParameter("duration");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String duration_dmy	= request.getParameter("duration_dmy")==null?"":request.getParameter("duration_dmy");
	//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050
	String  deli_cert_num = request.getParameter("deli_cert_num")==null?"":request.getParameter("deli_cert_num");//shanmukh
    
	//Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
	Boolean isChangesInAdditionalDtlsTabAppl = false;
	
	//Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049
	Boolean isAutoPopDurationApplyn = false;

	//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
	Boolean isItemOnLoanOthersDisableDateAppl = false;
	int patient_age = 0;
	String dob="",age="";
	String facilityid = (String) session.getValue("facility_id" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String user_name		= (String) session.getValue( "login_user" ) ;
	String locale			= (String)session.getAttribute("LOCALE");
	String h_dis_medication		= "";
	String h_dis_summ_prep		= "";
	String h_dis_summ_prep_by   = "";
	String h_informed_to		= "";
	String h_cert_no			= "";
	String h_iv_catheters_chk   = "";
	String h_iv_removed_by		= "";
	String h_iv_removed_dt		= "";
	String h_tubes_chk			= "";	
	String h_tubes_removed_by   = "";
	String h_tubes_removed_dt   = "";
	String h_drg_chk			= "";
	String h_drg_removed_by		= "";
	String h_drg_removed_dt		= "";
	String h_ngt_tube_chk		= "";
	String h_ngt_tube_removed_by = "";
	String h_ngt_tube_removed_dt = "";
	String h_cngt_tube_chk		= "";
	String h_cngt_tube_removed_by	= "";
	String h_cngt_tube_removed_dt = "";
	String h_urn_chk				= "";
	String h_urn_removed_by		= "";
	String h_urn_removed_dt		= "";
	String h_curn_chk			= "";
	String h_curn_removed_by    = "";
	String h_curn_removed_dt    ="";
	String h_sto_chk			= "";
	String h_sto_removed_by		= "";
	String h_sto_removed_dt		= "";
	String h_dressing_chk		= "";
	String h_dressing_removed_by= "";
	String h_dressing_removed_dt= "";
	String h_blng_returned		= "";
	String h_blng_returned_dt   = "";
	String h_blng_remarks		= "";
	String h_vlb_returned		= "";
	String h_vlb_returned_by    = "";
	String h_vlb_witness		= "";
	String h_witness_id			= "";
	String h_vlb_user			= "";
	String h_tp_arranged    = "";
	String h_tp_returned_dt    = "";
	String h_tp_remarks    = "";	
	String h_adv_cnt_given    = "";	
	String h_adv_cnt_parent    = "";	
	String h_adv_cnt_guardian    = "";	
	String h_wc_chk    = "";
	String h_wc_given_by    = "";		
	String h_wc_given_dt    = "";
	String h_nu_chk    = "";
	String h_nu_given_by    = "";
	String h_nu_given_dt    = "";
	String h_mc_chk    = "";
	String h_mc_given_by    = "";
	String h_mc_given_dt    = "";
	String h_ph_chk    = "";
	String h_ph_given_by    = "";
	String h_ph_given_dt    = "";
	String h_cop_chk    = "";
	String h_cop_given_by    = "";
	String h_cop_given_dt    = "";
	String h_coc_chk    = "";
	String h_coc_given_by    = "";
	String h_coc_given_dt    = "";
	String h_cot_chk    = "";
	String h_cot_given_by    = "";
	String h_cot_given_dt    = "";
	String h_oth_he_chk    = "";
	String h_oth_text    = "";
	String h_oth_given_by    = "";
	String h_oth_given_dt    = "";
	String h_top_to_toe_chk    = "";
	String h_co_umb_stmp_chk    = "";
	String h_care_of_skin_chk    = "";
	String h_care_of_eye_chk    = "";
	String h_expr_br_mlk_chk    = "";
	String h_tube_feed_chk    = "";
	String h_gst_feed_chk    = "";
	String h_frm_milk_chk    = "";
	String h_imn_sch_chk    = "";
	String h_care_of_stoma_chk    = "";
	String h_anl_dil_chk    = "";
	String h_pop_chk    = "";
	String h_fever_chk    = "";
	String h_sz_chk    = "";
	String h_jnd_chk    = "";
	String h_gpd_chk    = "";
	String h_stlc_chk    = "";
	String h_stlf_chk    = "";
	String h_coptb_chk    = "";
	String h_oth_ph_chk    = "";
	String h_bfd_chk    = "";
	String h_stm_cr_chk    = "";
	String h_oper_chk    = "";
	String h_pop_care_chk    = "";
	String h_dn_given_chk    = "";
	String h_db_given_chk    = "";
	String h_oth_pamphlets    = "";
	String h_oth_app_fix_item1    = "";
	String h_oth_app_fix_item1_given1  ="";
	String h_oth_app_fix_item1_dt1  = "";
	String h_oth_app_fix_item2  = "";
	String h_oth_app_fix_item2_given2  = "";
	String h_oth_app_fix_item2_dt2  = "";
	String h_oth_app_fix_item3  = "";
	String h_oth_app_fix_item3_given3  ="";
	String h_oth_app_fix_item3_dt3  = "";
	String h_oth_app_fix_item4  = "";
	String h_oth_app_fix_item4_given4  = "";
	String h_oth_app_fix_item4_dt4  = "";
	String h_oth_app_fix_item5  = "";
	String h_oth_app_fix_item5_given5  = "";
	String h_oth_app_fix_item5_dt5  = "";
	String h_oth_app_fix_item6  = "";
	String h_oth_app_fix_item6_given6  = "";
	String h_oth_app_fix_item6_dt6  = "";
	String h_oth_app_fix_item7  = "";
	String h_oth_app_fix_item7_given7  = "";
	String h_oth_app_fix_item7_dt7  = "";
	String h_oth_app_fix_item8  = "";
	String h_oth_app_fix_item8_given8  = "";
	String h_oth_app_fix_item8_dt8  = "";
	String h_oth_app_fix_item9  = "";
	String h_oth_app_fix_item9_given9  = "";
	String h_oth_app_fix_item9_dt9  = "";
	String h_oth_app_fix_item10  = "";
	String h_oth_app_fix_item10_given10  = "";
	String h_oth_app_fix_item10_dt10  = "";
	String h_ref_ltr_chk  = "";
	String h_rep_ltr_chk  = "";
	String h_cln_doc_chk  = "";
	String h_oth_doc_chk  = "";
	String h_ref_ltr_conf_chk  = "";
	String h_rep_ltr_dtls  = "";
	String h_rep_ltr_conf  = "";
	String h_cln_doc_dtls  = "";
	String h_cln_doc_conf  = "";
	String h_oth_doc_desc  = "";
	String h_oth_doc_dtls  = "";
	String h_oth_doc_conf  = "";
	String h_relationship  = "";
	String h_rel_date_time  = "";
	String h_rem_lv_ward  = "";
	String h_name_of_patient  = "";
	String h_mot_ic_no  = "";
	String h_rn_txt  = "";
	String h_ward_txt  = "";
	String h_discharge_date  = "";
	String h_weight_txt  = "";
	String h_length_txt  = "";
	String h_head_circum  = "";
	String h_adv_given  = "";
	String h_relationship_txt  = "";
	String h_mother_name  = "";
	String h_mother_no  = "";
	String h_father_name  = "";
	String h_father_no  = "";
	String h_Remarks  = "";
	String disch_chklist_status  = "";
	String h_user_txt  = "";
	String operation = "";
	String h_date_time_txt = "";
	String admission_date_time = "";
	String system_date_display = "";
	String max_trn_date_time	= "";

	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	String h_iv_remove_chk			 = "";
	String h_iv_remarks				 = "";
	String h_tubes_remove_chk		 = "";
	String h_tubes_remarks			 = "";
	String h_drg_remove_chk			 = "";
	String h_drg_remarks			 = "";
	String h_ngt_remove_chk			 = "";
	String h_ngt_remarks			 = "";
	String h_urn_remove_chk			 = "";
	String h_urn_remarks			 = "";
	String h_sto_remove_chk			 = "";
	String h_sto_remarks			 = "";
	String h_dressing_remove_chk	 = "";
	String h_dressing_remarks		 = "";
	/*End ML-MMOH-CRF-1142*/

	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	String h_itemloan_chk			= "";
	String h_itemloan_removed_by	= "";
	String h_itemloan_removed_dt	= "";
	String h_itemloan_remove_chk	= "";
	String h_itemloan_remarks		= "";
	String h_others_chk				= "";
	String h_others_removed_by		= "";
	String h_others_removed_dt		= "";
	String h_others_remove_chk		= "";
	String h_others_remarks			= "";
	/*End ML-MMOH-CRF-1218*/
	String h_chargeable_item_yn ="";//Added for MMS-KH-CRF-0052.1

	try
	{		
		con = ConnectionManager.getConnection(request);

		isChangesInAdditionalDtlsTabAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","DISCHRG_CHKLST_ADD_DTLS"); //Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
		
		isAutoPopDurationApplyn = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AUTO_POPULATE_DURATION"); //Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049 
		isItemOnLoanOthersDisableDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "ADD_ITEMS_AND_DISBL_DATE"); //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
		
		pstmt = con.prepareStatement(" select WITNESS_ID,RETURNED_YN,RETURNED_BY_ID from pr_patient_valuables WHERE facility_id = '"+facilityid+"' AND encounter_id = '"+encounter_id+"' ");

		rset = pstmt.executeQuery();
		if (rset.next())
		{
			h_vlb_returned = rset.getString("RETURNED_YN");
			h_vlb_user = rset.getString("RETURNED_BY_ID");
			h_witness_id = rset.getString("WITNESS_ID");
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();

		SqlSB.append(" select FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,DISCHARGE_MEDICATION_YN,DISCH_SUMMARY_SIGNED_YN,DISCH_SUMMARY_PREP_BY_ID,");		SqlSB.append("INFORMED_YN,MEDICAL_CERT_AVAIL_YN,REM_ITEM01_YN,REM_ITEM01_REMOVED_BY,to_char(REM_ITEM01_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM01_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM02_YN,REM_ITEM02_REMOVED_BY,to_char(REM_ITEM02_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM02_REMOVED_DATE,REM_ITEM03_YN,REM_ITEM03_REMOVED_BY,to_char(REM_ITEM03_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM03_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM04_YN,REM_ITEM04_REMOVED_BY,to_char(REM_ITEM04_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM04_REMOVED_DATE,REM_ITEM05_YN,REM_ITEM05_REMOVED_BY,to_char(REM_ITEM05_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM05_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM06_YN,REM_ITEM06_REMOVED_BY,to_char(REM_ITEM06_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM06_REMOVED_DATE,REM_ITEM07_YN,REM_ITEM07_REMOVED_BY,to_char(REM_ITEM07_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM07_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM08_YN,REM_ITEM08_REMOVED_BY,to_char(REM_ITEM08_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM08_REMOVED_DATE,REM_ITEM09_YN,REM_ITEM09_REMOVED_BY,to_char(REM_ITEM09_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM09_REMOVED_DATE,");
		SqlSB.append(" BELONGINGS_RETN_YN,to_char(BELONGINGS_RETN_DATE,'dd/mm/rrrr hh24:mi')BELONGINGS_RETN_DATE,");		
		SqlSB.append(" BELONGINGS_REMARKS, VALUABLES_RETN_YN,VALUABLES_RETN_BY_ID, VALUABLES_WITNESS_ID, TRANSPORT_ARRANGED_YN, to_char(TRANSPORT_ARRANGED_DATE,'dd/mm/rrrr hh24:mi')TRANSPORT_ARRANGED_DATE,TRANSPORT_REMARKS,HED_ADVICE_GIVEN_TO,HED_ITEM01_YN,HED_ITEM01_GIVEN_BY,to_char(HED_ITEM01_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM01_DATE,");
		SqlSB.append(" HED_ITEM02_YN,HED_ITEM02_GIVEN_BY,to_char(HED_ITEM02_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM02_DATE,HED_ITEM03_YN,HED_ITEM03_GIVEN_BY,to_char(HED_ITEM03_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM03_DATE,HED_ITEM04_YN,HED_ITEM04_GIVEN_BY,to_char(HED_ITEM04_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM04_DATE,HED_ITEM05_YN,HED_ITEM05_GIVEN_BY,to_char(HED_ITEM05_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM05_DATE,HED_ITEM06_YN,HED_ITEM06_GIVEN_BY,to_char(HED_ITEM06_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM06_DATE,HED_ITEM07_YN,HED_ITEM07_GIVEN_BY,to_char(HED_ITEM07_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM07_DATE,HED_OTHERS_YN,HED_OTHERS,HED_OTHERS_GIVEN_BY,to_char(HED_OTHERS_DATE,'dd/mm/rrrr hh24:mi')HED_OTHERS_DATE,");		SqlSB.append("PHG_ITEM01_YN,PHG_ITEM02_YN,PHG_ITEM03_YN,PHG_ITEM04_YN,NUTR_ITEM01_YN,NUTR_ITEM02_YN,NUTR_ITEM03_YN,NUTR_ITEM04_YN,NUTR_ITEM05_YN,NUTR_ITEM06_YN,NUTR_ITEM07_YN,NUTR_ITEM08_YN,NUTR_ITEM09_YN,NUTR_ITEM10_YN,NUTR_ITEM11_YN,NUTR_ITEM12_YN,NUTR_ITEM13_YN,NUTR_ITEM14_YN,NUTR_ITEM15_YN,NUTR_ITEM16_YN,PLET_ITEM01_YN,");		SqlSB.append("PLET_ITEM02_YN,PLET_ITEM03_YN,PLET_ITEM04_YN,PLET_ITEM05_YN,PLET_ITEM06_YN,PLET_OTHERS,APF_ITEM01,APF_ITEM01_GIVEN_BY,to_char(APF_ITEM01_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM01_DATE,APF_ITEM02,APF_ITEM02_GIVEN_BY,to_char(APF_ITEM02_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM02_DATE,APF_ITEM03,APF_ITEM03_GIVEN_BY,to_char(APF_ITEM03_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM03_DATE,APF_ITEM04,APF_ITEM04_GIVEN_BY,to_char(APF_ITEM04_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM04_DATE,APF_ITEM05,APF_ITEM05_GIVEN_BY,to_char(APF_ITEM05_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM05_DATE,APF_ITEM06,APF_ITEM06_GIVEN_BY,to_char(APF_ITEM06_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM06_DATE,APF_ITEM07,APF_ITEM07_GIVEN_BY,to_char(APF_ITEM07_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM07_DATE,APF_ITEM08,APF_ITEM08_GIVEN_BY,to_char(APF_ITEM08_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM08_DATE,APF_ITEM09,APF_ITEM09_GIVEN_BY,to_char(APF_ITEM09_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM09_DATE,APF_ITEM10,APF_ITEM10_GIVEN_BY,to_char(APF_ITEM10_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM10_DATE,");
		SqlSB.append(" ODC_REF_LTR_YN, ODC_REF_LTR_CONF_YN, ODC_ITEM01_YN, ODC_ITEM01_DETAIL1, ODC_ITEM01_DETAIL2, ODC_ITEM02_YN,ODC_ITEM02_DETAIL1, ODC_ITEM02_DETAIL2, ODC_OTHERS_YN,ODC_OTHERS_DESC, ODC_OTHERS_DETAIL1, ODC_OTHERS_DETAIL2,				LWA_RELATIONSHIP,to_char(LWA_DATE,'dd/mm/rrrr hh24:mi')LWA_DATE,LWA_REMARKS,SCH_PATIENT_NAME,SCH_MOTHERS_NRIC,SCH_R_NURSE,SCH_WARD,to_char(SCH_DATE_OF_DISCH,'dd/mm/rrrr hh24:mi')SCH_DATE_OF_DISCH,");		SqlSB.append("SCH_WEIGHT,SCH_LENGTH,SCH_HEAD_CIR,SCH_ADVICE_GIVEN_TO,SCH_RELATIONSHIP,DISCH_CHKLIST_STATUS,DISCH_CHKLIST_PREPARED_BY,DISCH_CHKLIST_CONFIRMED_BY,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/rrrr hh24:mi')MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,SCH_MOTHERS_NAME, SCH_FATHERS_NAME, SCH_FATHERS_NRIC, SCH_OTHER, REM_ITEM01_REMOVE_YN, REM_ITEM01_REMARKS, REM_ITEM02_REMOVE_YN, REM_ITEM02_REMARKS, REM_ITEM03_REMOVE_YN, REM_ITEM03_REMARKS, REM_ITEM04_REMOVE_YN, REM_ITEM04_REMARKS, REM_ITEM06_REMOVE_YN, REM_ITEM06_REMARKS, REM_ITEM08_REMOVE_YN, REM_ITEM08_REMARKS, REM_ITEM09_REMOVE_YN, REM_ITEM09_REMARKS, REM_ITEM10_REMARKS, REM_ITEM10_REMOVED_BY, to_char(REM_ITEM10_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM10_REMOVED_DATE, REM_ITEM10_REMOVE_YN, REM_ITEM10_YN, REM_ITEM11_REMARKS, REM_ITEM11_REMOVED_BY, to_char(REM_ITEM11_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM11_REMOVED_DATE, REM_ITEM11_REMOVE_YN, REM_ITEM11_YN,CHARGEABLE_ITEM_YN from IP_DISCHARGE_CHECKLIST where facility_id = ? and encounter_id = ? ");//CHARGEABLE_ITEM_YN Added by chandra for MMS-KH-CRF-0052.1
		//Above query modified by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
		//Above query modified by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218

		pstmt = con.prepareStatement(SqlSB.toString());
		pstmt.setString(1,facilityid);
		pstmt.setString(2,encounter_id);

		rset = pstmt.executeQuery();
		while(rset.next())
		{
			 h_dis_medication    = checkForNull(rset.getString("DISCHARGE_MEDICATION_YN"));
			 h_chargeable_item_yn = checkForNull(rset.getString("CHARGEABLE_ITEM_YN"));//Added for MMS-KH-CRF-0052.1
			 h_dis_summ_prep    = checkForNull(rset.getString("DISCH_SUMMARY_SIGNED_YN"));	
			 h_dis_summ_prep_by    = checkForNull(rset.getString("DISCH_SUMMARY_PREP_BY_ID"));	
			 h_informed_to    = checkForNull(rset.getString("INFORMED_YN"));	
			 h_cert_no    = checkForNull(rset.getString("MEDICAL_CERT_AVAIL_YN"));	
			 h_iv_catheters_chk    = checkForNull(rset.getString("REM_ITEM01_YN"));	
			 h_iv_removed_by    = checkForNull(rset.getString("REM_ITEM01_REMOVED_BY"));	
			 h_iv_removed_dt    = checkForNull(rset.getString("REM_ITEM01_REMOVED_DATE"));	
			 h_tubes_chk    = checkForNull(rset.getString("REM_ITEM02_YN"));	
			 h_tubes_removed_by    =checkForNull(rset.getString("REM_ITEM02_REMOVED_BY"));	
			 h_tubes_removed_dt    = checkForNull(rset.getString("REM_ITEM02_REMOVED_DATE"));	
			 h_drg_chk    = checkForNull(rset.getString("REM_ITEM03_YN"));	
			 h_drg_removed_by    = checkForNull(rset.getString("REM_ITEM03_REMOVED_BY"));	
			 h_drg_removed_dt    = checkForNull(rset.getString("REM_ITEM03_REMOVED_DATE"));	
			 h_ngt_tube_chk    = checkForNull(rset.getString("REM_ITEM04_YN"));	
			 h_ngt_tube_removed_by    =checkForNull(rset.getString("REM_ITEM04_REMOVED_BY"));	
			 h_ngt_tube_removed_dt    = checkForNull(rset.getString("REM_ITEM04_REMOVED_DATE"));	
			 h_cngt_tube_chk    = checkForNull(rset.getString("REM_ITEM05_YN"));	
			 h_cngt_tube_removed_by    = checkForNull(rset.getString("REM_ITEM05_REMOVED_BY"));	
			 h_cngt_tube_removed_dt    = checkForNull(rset.getString("REM_ITEM05_REMOVED_DATE"));	
			 h_urn_chk    = checkForNull(rset.getString("REM_ITEM06_YN"));	
			 h_urn_removed_by    = checkForNull(rset.getString("REM_ITEM06_REMOVED_BY"));	
			 h_urn_removed_dt    = checkForNull(rset.getString("REM_ITEM06_REMOVED_DATE"));	
			 h_curn_chk    = checkForNull(rset.getString("REM_ITEM07_YN"));	
			 h_curn_removed_by    = checkForNull(rset.getString("REM_ITEM07_REMOVED_BY"));	
			 h_curn_removed_dt    =checkForNull(rset.getString("REM_ITEM07_REMOVED_DATE"));	
			 h_sto_chk    = checkForNull(rset.getString("REM_ITEM08_YN"));	
			 h_sto_removed_by    = checkForNull(rset.getString("REM_ITEM08_REMOVED_BY"));	
			 h_sto_removed_dt    =checkForNull(rset.getString("REM_ITEM08_REMOVED_DATE"));	
			 h_dressing_chk    = checkForNull(rset.getString("REM_ITEM09_YN"));	
			 h_dressing_removed_by    = checkForNull(rset.getString("REM_ITEM09_REMOVED_BY"));	
			 h_dressing_removed_dt    = checkForNull(rset.getString("REM_ITEM09_REMOVED_DATE"));	
			 h_blng_returned    =checkForNull(rset.getString("BELONGINGS_RETN_YN"));	
			 h_blng_returned_dt    = checkForNull(rset.getString("BELONGINGS_RETN_DATE"));	
			 h_blng_remarks    = checkForNull(rset.getString("BELONGINGS_REMARKS"));	
			 h_tp_arranged    = checkForNull(rset.getString("TRANSPORT_ARRANGED_YN"));	
			 h_tp_returned_dt    = checkForNull(rset.getString("TRANSPORT_ARRANGED_DATE"));	
			 h_tp_remarks    =checkForNull(rset.getString("TRANSPORT_REMARKS"));			
			 h_adv_cnt_given    = checkForNull(rset.getString("HED_ADVICE_GIVEN_TO"));		
			 /*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
			 h_itemloan_chk			= checkForNull(rset.getString("REM_ITEM10_YN"));	
			 h_itemloan_removed_by	= checkForNull(rset.getString("REM_ITEM10_REMOVED_BY"));	
			 h_itemloan_removed_dt	= checkForNull(rset.getString("REM_ITEM10_REMOVED_DATE"));	
			 h_itemloan_remove_chk	= checkForNull(rset.getString("REM_ITEM10_REMOVE_YN"));	
			 h_itemloan_remarks		= checkForNull(rset.getString("REM_ITEM10_REMARKS"));
			 h_others_chk			= checkForNull(rset.getString("REM_ITEM11_YN"));	
			 h_others_removed_by	= checkForNull(rset.getString("REM_ITEM11_REMOVED_BY"));	
			 h_others_removed_dt	= checkForNull(rset.getString("REM_ITEM11_REMOVED_DATE"));	
			 h_others_remove_chk	= checkForNull(rset.getString("REM_ITEM11_REMOVE_YN"));	
			 h_others_remarks		= checkForNull(rset.getString("REM_ITEM11_REMARKS"));
			 /*End ML-MMOH-CRF-1218*/

			 if(h_adv_cnt_given.equals("2"))
			 {
				h_adv_cnt_parent="Y";						
				h_adv_cnt_guardian="Y";						
			 }
			 else if(h_adv_cnt_given.equals("1"))
			 {
				h_adv_cnt_parent="N";						
				h_adv_cnt_guardian="Y";					
			 }
			 else if(h_adv_cnt_given.equals("0"))
			 {
				h_adv_cnt_parent="Y";						
				h_adv_cnt_guardian="N";					
			 }
			 else if(h_adv_cnt_given.equals(""))
			 {
				h_adv_cnt_parent="N";						
				h_adv_cnt_guardian="N";					
			 }
			 h_wc_chk    = checkForNull(rset.getString("HED_ITEM01_YN"));			
			 h_wc_given_by    = checkForNull(rset.getString("HED_ITEM01_GIVEN_BY"));			
			 h_wc_given_dt    = checkForNull(rset.getString("HED_ITEM01_DATE"));
			 h_nu_chk    = checkForNull(rset.getString("HED_ITEM02_YN"));
			 h_nu_given_by    = checkForNull(rset.getString("HED_ITEM02_GIVEN_BY"));
			 h_nu_given_dt    = checkForNull(rset.getString("HED_ITEM02_DATE"));
			 h_mc_chk    = checkForNull(rset.getString("HED_ITEM03_YN"));
			 h_mc_given_by    = checkForNull(rset.getString("HED_ITEM03_GIVEN_BY"));
			 h_mc_given_dt    =checkForNull(rset.getString("HED_ITEM03_DATE"));
			 h_ph_chk    = checkForNull(rset.getString("HED_ITEM04_YN"));
			 h_ph_given_by    = checkForNull(rset.getString("HED_ITEM04_GIVEN_BY"));
			 h_ph_given_dt    = checkForNull(rset.getString("HED_ITEM04_DATE"));
			 h_cop_chk    = checkForNull(rset.getString("HED_ITEM05_YN"));
			 h_cop_given_by    =checkForNull(rset.getString("HED_ITEM05_GIVEN_BY"));
			 h_cop_given_dt    = checkForNull(rset.getString("HED_ITEM05_DATE"));
			 h_coc_chk    = checkForNull(rset.getString("HED_ITEM06_YN"));
			 h_coc_given_by    = checkForNull(rset.getString("HED_ITEM06_GIVEN_BY"));
			 h_coc_given_dt    = checkForNull(rset.getString("HED_ITEM06_DATE"));
			 h_cot_chk    = checkForNull(rset.getString("HED_ITEM07_YN"));
			 h_cot_given_by    = checkForNull(rset.getString("HED_ITEM07_GIVEN_BY"));
			 h_cot_given_dt    = checkForNull(rset.getString("HED_ITEM07_DATE"));
			 h_oth_he_chk    = checkForNull(rset.getString("HED_OTHERS_YN"));
			 h_oth_text    =checkForNull(rset.getString("HED_OTHERS"));
			 h_oth_given_by    = checkForNull(rset.getString("HED_OTHERS_GIVEN_BY"));
			 h_oth_given_dt    = checkForNull(rset.getString("HED_OTHERS_DATE"));
			 h_top_to_toe_chk    = checkForNull(rset.getString("PHG_ITEM01_YN"));
			 h_co_umb_stmp_chk    = checkForNull(rset.getString("PHG_ITEM02_YN"));
			 h_care_of_skin_chk    = checkForNull(rset.getString("PHG_ITEM03_YN"));
			 h_care_of_eye_chk    = checkForNull(rset.getString("PHG_ITEM04_YN"));
			 h_expr_br_mlk_chk    =checkForNull(rset.getString("NUTR_ITEM01_YN"));
			 h_tube_feed_chk    =checkForNull(rset.getString("NUTR_ITEM02_YN"));
			 h_gst_feed_chk    = checkForNull(rset.getString("NUTR_ITEM03_YN"));
			 h_frm_milk_chk    = checkForNull(rset.getString("NUTR_ITEM04_YN"));
			 h_imn_sch_chk    = checkForNull(rset.getString("NUTR_ITEM05_YN"));
			 h_care_of_stoma_chk    = checkForNull(rset.getString("NUTR_ITEM06_YN"));
			 h_anl_dil_chk    = checkForNull(rset.getString("NUTR_ITEM07_YN"));
			 h_pop_chk    =checkForNull(rset.getString("NUTR_ITEM08_YN"));
			 h_fever_chk    = checkForNull(rset.getString("NUTR_ITEM09_YN"));
			 h_sz_chk    = checkForNull(rset.getString("NUTR_ITEM10_YN"));
			 h_jnd_chk    = checkForNull(rset.getString("NUTR_ITEM11_YN"));
			 h_gpd_chk    = checkForNull(rset.getString("NUTR_ITEM12_YN"));
			 h_stlc_chk    = checkForNull(rset.getString("NUTR_ITEM13_YN"));
			 h_stlf_chk    = checkForNull(rset.getString("NUTR_ITEM14_YN"));
			 h_coptb_chk    =checkForNull(rset.getString("NUTR_ITEM15_YN"));
			 h_oth_ph_chk    = checkForNull(rset.getString("NUTR_ITEM16_YN"));

			 h_bfd_chk    = checkForNull(rset.getString("PLET_ITEM01_YN"));

			 h_stm_cr_chk    = checkForNull(rset.getString("PLET_ITEM02_YN"));
			 h_oper_chk    = checkForNull(rset.getString("PLET_ITEM03_YN"));
			 h_pop_care_chk    = checkForNull(rset.getString("PLET_ITEM04_YN"));
			 h_dn_given_chk    = checkForNull(rset.getString("PLET_ITEM05_YN"));
			 h_db_given_chk    = checkForNull(rset.getString("PLET_ITEM06_YN"));
			 h_oth_pamphlets    = checkForNull(rset.getString("PLET_OTHERS"));

			 h_oth_app_fix_item1    = checkForNull(rset.getString("APF_ITEM01"));
			 h_oth_app_fix_item1_given1  =checkForNull(rset.getString("APF_ITEM01_GIVEN_BY"));
			 h_oth_app_fix_item1_dt1  = checkForNull(rset.getString("APF_ITEM01_DATE"));
			 h_oth_app_fix_item2  = checkForNull(rset.getString("APF_ITEM02"));
			 h_oth_app_fix_item2_given2  = checkForNull(rset.getString("APF_ITEM02_GIVEN_BY"));
			 h_oth_app_fix_item2_dt2  = checkForNull(rset.getString("APF_ITEM02_DATE"));
			 h_oth_app_fix_item3  = checkForNull(rset.getString("APF_ITEM03"));
			 h_oth_app_fix_item3_given3  = checkForNull(rset.getString("APF_ITEM03_GIVEN_BY"));
			 h_oth_app_fix_item3_dt3  = checkForNull(rset.getString("APF_ITEM03_DATE"));

			 h_oth_app_fix_item4  = checkForNull(rset.getString("APF_ITEM04"));
			 h_oth_app_fix_item4_given4  = checkForNull(rset.getString("APF_ITEM04_GIVEN_BY"));
			 h_oth_app_fix_item4_dt4  = checkForNull(rset.getString("APF_ITEM04_DATE"));

			 h_oth_app_fix_item5  = checkForNull(rset.getString("APF_ITEM05"));
			 h_oth_app_fix_item5_given5  = checkForNull(rset.getString("APF_ITEM05_GIVEN_BY"));
			 h_oth_app_fix_item5_dt5  = checkForNull(rset.getString("APF_ITEM05_DATE"));

			 h_oth_app_fix_item6  = checkForNull(rset.getString("APF_ITEM06"));
			 h_oth_app_fix_item6_given6  = checkForNull(rset.getString("APF_ITEM06_GIVEN_BY"));
			 h_oth_app_fix_item6_dt6  = checkForNull(rset.getString("APF_ITEM06_DATE"));

			 h_oth_app_fix_item7  = checkForNull(rset.getString("APF_ITEM07"));
			 h_oth_app_fix_item7_given7  = checkForNull(rset.getString("APF_ITEM07_GIVEN_BY"));
			 h_oth_app_fix_item7_dt7  = checkForNull(rset.getString("APF_ITEM07_DATE"));

			 h_oth_app_fix_item8  = checkForNull(rset.getString("APF_ITEM08"));
			 h_oth_app_fix_item8_given8  = checkForNull(rset.getString("APF_ITEM08_GIVEN_BY"));
			 h_oth_app_fix_item8_dt8  = checkForNull(rset.getString("APF_ITEM08_DATE"));

			 h_oth_app_fix_item9  = checkForNull(rset.getString("APF_ITEM09"));
			 h_oth_app_fix_item9_given9  = checkForNull(rset.getString("APF_ITEM09_GIVEN_BY"));
			 h_oth_app_fix_item9_dt9  = checkForNull(rset.getString("APF_ITEM09_DATE"));
				
			 h_oth_app_fix_item10  = checkForNull(rset.getString("APF_ITEM10"));
			 h_oth_app_fix_item10_given10  = checkForNull(rset.getString("APF_ITEM10_GIVEN_BY"));
			 h_oth_app_fix_item10_dt10  = checkForNull(rset.getString("APF_ITEM10_DATE"));

			 h_ref_ltr_chk  = checkForNull(rset.getString("ODC_REF_LTR_YN"));
			 h_ref_ltr_conf_chk  = checkForNull(rset.getString("ODC_REF_LTR_CONF_YN"));

			 h_rep_ltr_chk  = checkForNull(rset.getString("ODC_ITEM01_YN"));
			 h_rep_ltr_dtls  = checkForNull(rset.getString("ODC_ITEM01_DETAIL1"));
			 h_rep_ltr_conf  = checkForNull(rset.getString("ODC_ITEM01_DETAIL2"));

			 h_cln_doc_chk  = checkForNull(rset.getString("ODC_ITEM02_YN"));
			 h_cln_doc_dtls  = checkForNull(rset.getString("ODC_ITEM02_DETAIL1"));
			 h_cln_doc_conf  = checkForNull(rset.getString("ODC_ITEM02_DETAIL2"));

			 h_oth_doc_chk  = checkForNull(rset.getString("ODC_OTHERS_YN"));
			 h_oth_doc_desc  = checkForNull(rset.getString("ODC_OTHERS_DESC"));
			 h_oth_doc_dtls  = checkForNull(rset.getString("ODC_OTHERS_DETAIL1"));
			 h_oth_doc_conf  = checkForNull(rset.getString("ODC_OTHERS_DETAIL2"));

			 h_relationship  = checkForNull(rset.getString("LWA_RELATIONSHIP"));
			 h_rel_date_time  = checkForNull(rset.getString("LWA_DATE"));
			 h_rem_lv_ward  = checkForNull(rset.getString("LWA_REMARKS"));

			 h_name_of_patient  = checkForNull(rset.getString("SCH_PATIENT_NAME"));
			 h_mot_ic_no  =checkForNull(rset.getString("SCH_MOTHERS_NRIC"));
			 h_rn_txt  =checkForNull(rset.getString("SCH_R_NURSE"));
			 h_ward_txt  = checkForNull(rset.getString("SCH_WARD"));
			 h_discharge_date  = checkForNull(rset.getString("SCH_DATE_OF_DISCH"));
			 h_weight_txt  = checkForNull(rset.getString("SCH_WEIGHT"));
			 h_length_txt  = checkForNull(rset.getString("SCH_LENGTH"));
			 h_head_circum  = checkForNull(rset.getString("SCH_HEAD_CIR"));
			 h_adv_given  = checkForNull(rset.getString("SCH_ADVICE_GIVEN_TO"));
			 h_relationship_txt  = checkForNull(rset.getString("SCH_RELATIONSHIP"));
			 
			 h_mother_name  = checkForNull(rset.getString("SCH_MOTHERS_NAME"));
			 h_mother_no  = checkForNull(rset.getString("SCH_MOTHERS_NRIC"));
			 h_father_name  = checkForNull(rset.getString("SCH_FATHERS_NAME"));
			 h_father_no  = checkForNull(rset.getString("SCH_FATHERS_NRIC"));
			 h_Remarks  = checkForNull(rset.getString("SCH_OTHER"));
				
			 /*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			 h_iv_remove_chk		= checkForNull(rset.getString("REM_ITEM01_REMOVE_YN"));	
			 h_iv_remarks			= checkForNull(rset.getString("REM_ITEM01_REMARKS"));
			 h_tubes_remove_chk		= checkForNull(rset.getString("REM_ITEM02_REMOVE_YN"));	
			 h_tubes_remarks		= checkForNull(rset.getString("REM_ITEM02_REMARKS"));
			 h_drg_remove_chk		= checkForNull(rset.getString("REM_ITEM03_REMOVE_YN"));	
			 h_drg_remarks			= checkForNull(rset.getString("REM_ITEM03_REMARKS"));
			 h_ngt_remove_chk		= checkForNull(rset.getString("REM_ITEM04_REMOVE_YN"));	
			 h_ngt_remarks			= checkForNull(rset.getString("REM_ITEM04_REMARKS"));
			 h_urn_remove_chk		= checkForNull(rset.getString("REM_ITEM06_REMOVE_YN"));	
			 h_urn_remarks			= checkForNull(rset.getString("REM_ITEM06_REMARKS"));
			 h_sto_remove_chk		= checkForNull(rset.getString("REM_ITEM08_REMOVE_YN"));	
			 h_sto_remarks			= checkForNull(rset.getString("REM_ITEM08_REMARKS"));
			 h_dressing_remove_chk	= checkForNull(rset.getString("REM_ITEM09_REMOVE_YN"));	
			 h_dressing_remarks		= checkForNull(rset.getString("REM_ITEM09_REMARKS"));
			 /*End ML-MMOH-CRF-1142*/

			 disch_chklist_status  = checkForNull(rset.getString("DISCH_CHKLIST_STATUS"));				
			 h_user_txt=checkForNull(rset.getString("DISCH_CHKLIST_CONFIRMED_BY"));
			 if(h_user_txt.equals(""))
				 h_user_txt  = checkForNull(rset.getString("DISCH_CHKLIST_PREPARED_BY"));
	
			 h_date_time_txt  =checkForNull(rset.getString("MODIFIED_DATE"));	
		}

		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();

		if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		SqlSB.append(" select to_char(DATE_OF_BIRTH,'dd/mm/rrrr')dob, calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1)age,to_char(sysdate,'dd/mm/rrrr hh24:mi') dttm,(SELECT to_char(admission_date_time, 'dd/mm/rrrr hh24:mi')admission_date_time FROM IP_OPEN_ENCOUNTER WHERE facility_id = '"+facilityid+"' AND encounter_id = '"+encounter_id+"' AND patient_id = '"+patient_id+"') admission_date_time ");
		SqlSB.append(" , (Select to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = '"+encounter_id+"' and facility_id  = '"+facilityid+"')max_trn_date_time ");
		SqlSB.append(" from mp_patient where patient_id='"+patient_id+"' ");
		pstmt = con.prepareStatement(SqlSB.toString());
		rset = pstmt.executeQuery();
		while(rset.next())
		{
			dob    = checkForNull(rset.getString("dob"));
			age    = rset.getString("age")==null?"0":rset.getString("age");	
			admission_date_time = rset.getString("admission_date_time");
			system_date         = rset.getString("dttm");	
			max_trn_date_time	= checkForNull(rset.getString("max_trn_date_time"));
		}
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
		patient_age = Integer.parseInt(age);
		system_date_display = DateUtils.convertDate(system_date,"DMYHM","en",locale);
	}catch(Exception e){	e.printStackTrace();}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
<html> 
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListMain' id='DischargeCheckListMain' action='../../servlet/eIP.DischargeCheckListServlet' method='post' target='submitFrame' >
	<table border="1" cellpadding="1" cellspacing="1" width="100%" align='center'>
	<tr>
		<td class='data' id='tab_1' style='cursor:pointer;background:BLUE;width:114' onclick="call_jsp_main('D');" align='center'><font color='WHITE' size=1><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></font></td>
		<td class='data' id='tab_2' style='cursor:pointer;background:NAVY;width:114' onclick="call_jsp_main('R');" align='center'><font color='WHITE'size=1><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/>
        </font></td> 
		<td class='data' id='tab_3' style='cursor:pointer;background:NAVY;width:114' onclick="call_jsp_main('H');" align='center'><font color='WHITE' size=1><fmt:message key="eIP.HealthEducation.label" bundle="${ip_labels}"/></font></td>
<%	
	if(patient_age <= 12)  
	{	%>
		<td class='data' id='tab_4' style='cursor:pointer;background:NAVY;width:114' onclick="call_jsp_main('P');" align='center'><font color='WHITE' size=1><fmt:message key="eIP.PaediatricDetails.label" bundle="${ip_labels}"/></font></td>
<%	}	%>
		<td class='data' id='tab_5' style='cursor:pointer;background:NAVY;width:114' onclick="call_jsp_main('O');" align='center' wrap><font color='WHITE' size=1><fmt:message key="eIP.ApplFixturesDocuments.label" bundle="${ip_labels}"/></font></td>
<%	if(patient_age <= 12)
	{	%>
		<td class='data' id='tab_6' style='cursor:pointer;background:NAVY;width:114' onclick="call_jsp_main('L');" align='center'><font color='WHITE' size=1><fmt:message key="eIP.SupportiveCare.label" bundle="${ip_labels}"/></font></td>
<%	}	%>
	</tr>
</table>

<input type='hidden' name='h_iv_catheters_chk' id='h_iv_catheters_chk' value='<%=h_iv_catheters_chk%>' >
<input type='hidden' name='h_iv_removed_by' id='h_iv_removed_by' value='<%=h_iv_removed_by%>'>
<input type='hidden' name='h_iv_removed_dt' id='h_iv_removed_dt'value='<%=h_iv_removed_dt%>'>
<input type='hidden' name='h_tubes_chk' id='h_tubes_chk'value='<%=h_tubes_chk%>'>
<input type='hidden' name='h_tubes_removed_by' id='h_tubes_removed_by'value='<%=h_tubes_removed_by%>'>
<input type='hidden' name='h_tubes_removed_dt' id='h_tubes_removed_dt'value='<%=h_tubes_removed_dt%>'>
<input type='hidden' name='h_drg_chk' id='h_drg_chk' value='<%=h_drg_chk%>'>
<input type='hidden' name='h_drg_removed_by' id='h_drg_removed_by' value='<%=h_drg_removed_by%>'>
<input type='hidden' name='h_drg_removed_dt' id='h_drg_removed_dt' value='<%=h_drg_removed_dt%>'>
<input type='hidden' name='h_ngt_tube_chk' id='h_ngt_tube_chk' value='<%=h_ngt_tube_chk%>'>
<input type='hidden' name='h_ngt_tube_removed_by' id='h_ngt_tube_removed_by' value='<%=h_ngt_tube_removed_by%>'>
<input type='hidden' name='h_ngt_tube_removed_dt' id='h_ngt_tube_removed_dt' value='<%=h_ngt_tube_removed_dt%>'> 
<input type='hidden' name='h_cngt_tube_chk' id='h_cngt_tube_chk' value='<%=h_cngt_tube_chk%>'>
<input type='hidden' name='h_cngt_tube_removed_by' id='h_cngt_tube_removed_by' value='<%=h_cngt_tube_removed_by%>'>
<input type='hidden' name='h_cngt_tube_removed_dt' id='h_cngt_tube_removed_dt' value='<%=h_cngt_tube_removed_dt%>'>
<input type='hidden' name='h_urn_chk' id='h_urn_chk' value='<%=h_urn_chk%>'>
<input type='hidden' name='h_urn_removed_by' id='h_urn_removed_by' value='<%=h_urn_removed_by%>'>
<input type='hidden' name='h_urn_removed_dt' id='h_urn_removed_dt' value='<%=h_urn_removed_dt%>'>
<input type='hidden' name='h_curn_chk' id='h_curn_chk' value='<%=h_curn_chk%>'>
<input type='hidden' name='h_curn_removed_by' id='h_curn_removed_by' value='<%=h_curn_removed_by%>'>
<input type='hidden' name='h_curn_removed_dt' id='h_curn_removed_dt' value='<%=h_curn_removed_dt%>'>
<input type='hidden' name='h_sto_chk' id='h_sto_chk' value='<%=h_sto_chk%>'>
<input type='hidden' name='h_sto_removed_by' id='h_sto_removed_by' value='<%=h_sto_removed_by%>'>
<input type='hidden' name='h_sto_removed_dt' id='h_sto_removed_dt' value='<%=h_sto_removed_dt%>'>
<input type='hidden' name='h_dressing_chk' id='h_dressing_chk' value='<%=h_dressing_chk%>'>
<input type='hidden' name='h_dressing_removed_by' id='h_dressing_removed_by' value='<%=h_dressing_removed_by%>'>
<input type='hidden' name='h_dressing_removed_dt' id='h_dressing_removed_dt' value='<%=h_dressing_removed_dt%>'>
<input type='hidden' name='h_blng_returned' id='h_blng_returned' value='<%=h_blng_returned%>'>
<input type='hidden' name='h_blng_returned_dt' id='h_blng_returned_dt' value='<%=h_blng_returned_dt%>'>
<input type='hidden' name='h_blng_remarks' id='h_blng_remarks' value='<%=h_blng_remarks%>'>
<input type='hidden' name='h_vlb_returned' id='h_vlb_returned' value='<%=h_vlb_returned%>'>
<input type='hidden' name='h_vlb_returned_by' id='h_vlb_returned_by' value='<%=h_vlb_returned_by%>'>
<input type='hidden' name='h_vlb_witness' id='h_vlb_witness' value='<%=h_vlb_witness%>'>
<input type='hidden' name='h_witness_id' id='h_witness_id' value='<%=h_witness_id%>'>
<input type='hidden' name='h_vlb_user' id='h_vlb_user' value='<%=h_vlb_user%>'>

<input type='hidden' name='h_tp_arranged' id='h_tp_arranged' value='<%=h_tp_arranged%>'>
<input type='hidden' name='h_tp_returned_dt' id='h_tp_returned_dt' value='<%=h_tp_returned_dt%>'>
<input type='hidden' name='h_tp_remarks' id='h_tp_remarks' value='<%=h_tp_remarks%>'>
<input type='hidden' name='h_adv_cnt_parent' id='h_adv_cnt_parent' value='<%=h_adv_cnt_parent%>'>
<input type='hidden' name='h_adv_cnt_guardian' id='h_adv_cnt_guardian' value='<%=h_adv_cnt_guardian%>'>
<input type='hidden' name='h_wc_chk' id='h_wc_chk' value='<%=h_wc_chk%>'>
<input type='hidden' name='h_wc_given_by' id='h_wc_given_by' value='<%=h_wc_given_by%>'>
<input type='hidden' name='h_wc_given_dt' id='h_wc_given_dt' value='<%=h_wc_given_dt%>'>
<input type='hidden' name='h_nu_chk' id='h_nu_chk' value='<%=h_nu_chk%>'>
<input type='hidden' name='h_nu_given_by' id='h_nu_given_by' value='<%=h_nu_given_by%>'>
<input type='hidden' name='h_nu_given_dt' id='h_nu_given_dt' value='<%=h_nu_given_dt%>'>
<input type='hidden' name='h_mc_chk' id='h_mc_chk' value='<%=h_mc_chk%>'>
<input type='hidden' name='h_mc_given_by' id='h_mc_given_by' value='<%=h_mc_given_by%>'>
<input type='hidden' name='h_mc_given_dt' id='h_mc_given_dt' value='<%=h_mc_given_dt%>'>
<input type='hidden' name='h_ph_chk' id='h_ph_chk' value='<%=h_ph_chk%>'>
<input type='hidden' name='h_ph_given_by' id='h_ph_given_by' value='<%=h_ph_given_by%>'>
<input type='hidden' name='h_ph_given_dt' id='h_ph_given_dt' value='<%=h_ph_given_dt%>'>
<input type='hidden' name='h_cop_chk' id='h_cop_chk' value='<%=h_cop_chk%>'>
<input type='hidden' name='h_cop_given_by' id='h_cop_given_by' value='<%=h_cop_given_by%>'>
<input type='hidden' name='h_cop_given_dt' id='h_cop_given_dt' value='<%=h_cop_given_dt%>'>
<input type='hidden' name='h_coc_chk' id='h_coc_chk' value='<%=h_coc_chk%>'>
<input type='hidden' name='h_coc_given_by' id='h_coc_given_by' value='<%=h_coc_given_by%>'>
<input type='hidden' name='h_coc_given_dt' id='h_coc_given_dt' value='<%=h_coc_given_dt%>'>
<input type='hidden' name='h_cot_chk' id='h_cot_chk' value='<%=h_cot_chk%>'>
<input type='hidden' name='h_cot_given_by' id='h_cot_given_by' value='<%=h_cot_given_by%>'>
<input type='hidden' name='h_cot_given_dt' id='h_cot_given_dt' value='<%=h_cot_given_dt%>'>
<input type='hidden' name='h_oth_he_chk' id='h_oth_he_chk' value='<%=h_oth_he_chk%>'>
<input type='hidden' name='h_oth_text' id='h_oth_text' value='<%=h_oth_text%>'>
<input type='hidden' name='h_oth_given_by' id='h_oth_given_by' value='<%=h_oth_given_by%>'>
<input type='hidden' name='h_oth_given_dt' id='h_oth_given_dt' value='<%=h_oth_given_dt%>'>
<input type='hidden' name='h_top_to_toe_chk' id='h_top_to_toe_chk' value='<%=h_top_to_toe_chk%>'>
<input type='hidden' name='h_co_umb_stmp_chk' id='h_co_umb_stmp_chk' value='<%=h_top_to_toe_chk%>'>
<input type='hidden' name='h_care_of_skin_chk' id='h_care_of_skin_chk' value='<%=h_care_of_skin_chk%>'>
<input type='hidden' name='h_care_of_eye_chk' id='h_care_of_eye_chk' value='<%=h_care_of_eye_chk%>'>
<input type='hidden' name='h_expr_br_mlk_chk' id='h_expr_br_mlk_chk' value='<%=h_expr_br_mlk_chk%>'>
<input type='hidden' name='h_tube_feed_chk' id='h_tube_feed_chk' value='<%=h_tube_feed_chk%>'>
<input type='hidden' name='h_gst_feed_chk' id='h_gst_feed_chk' value='<%=h_gst_feed_chk%>'>
<input type='hidden' name='h_frm_milk_chk' id='h_frm_milk_chk' value='<%=h_frm_milk_chk%>'>
<input type='hidden' name='h_imn_sch_chk' id='h_imn_sch_chk' value='<%=h_imn_sch_chk%>'>
<input type='hidden' name='h_care_of_stoma_chk' id='h_care_of_stoma_chk' value='<%=h_care_of_stoma_chk%>'>
<input type='hidden' name='h_anl_dil_chk' id='h_anl_dil_chk' value='<%=h_anl_dil_chk%>'>
<input type='hidden' name='h_pop_chk' id='h_pop_chk' value='<%=h_pop_chk%>'>
<input type='hidden' name='h_fever_chk' id='h_fever_chk' value='<%=h_fever_chk%>'>
<input type='hidden' name='h_sz_chk' id='h_sz_chk' value='<%=h_sz_chk%>'>
<input type='hidden' name='h_jnd_chk' id='h_jnd_chk' value='<%=h_jnd_chk%>'>
<input type='hidden' name='h_gpd_chk' id='h_gpd_chk' value='<%=h_gpd_chk%>'>
<input type='hidden' name='h_stlc_chk' id='h_stlc_chk' value='<%=h_stlc_chk%>'>
<input type='hidden' name='h_stlf_chk' id='h_stlf_chk' value='<%=h_stlf_chk%>'>
<input type='hidden' name='h_coptb_chk' id='h_coptb_chk' value='<%=h_coptb_chk%>'>
<input type='hidden' name='h_oth_ph_chk' id='h_oth_ph_chk' value='<%=h_oth_ph_chk%>'>
<input type='hidden' name='h_bfd_chk' id='h_bfd_chk' value='<%=h_bfd_chk%>'>
<input type='hidden' name='h_stm_cr_chk' id='h_stm_cr_chk' value='<%=h_stm_cr_chk%>'>
<input type='hidden' name='h_oper_chk' id='h_oper_chk' value='<%=h_oper_chk%>'>
<input type='hidden' name='h_pop_care_chk' id='h_pop_care_chk' value='<%=h_pop_care_chk%>'>
<input type='hidden' name='h_oth_pamphlets' id='h_oth_pamphlets' value='<%=h_oth_pamphlets%>'>
<input type='hidden' name='h_dn_given_chk' id='h_dn_given_chk' value='<%=h_dn_given_chk%>'>
<input type='hidden' name='h_db_given_chk' id='h_db_given_chk' value='<%=h_db_given_chk%>'>

<input type='hidden' name='h_oth_app_fix_item1' id='h_oth_app_fix_item1' value='<%=h_oth_app_fix_item1%>'>
<input type='hidden' name='h_oth_app_fix_item1_given1' id='h_oth_app_fix_item1_given1' value='<%=h_oth_app_fix_item1_given1%>'>
<input type='hidden' name='h_oth_app_fix_item1_dt1' id='h_oth_app_fix_item1_dt1' value='<%=h_oth_app_fix_item1_dt1%>'>
<input type='hidden' name='h_oth_app_fix_item2' id='h_oth_app_fix_item2' value='<%=h_oth_app_fix_item2%>'>
<input type='hidden' name='h_oth_app_fix_item2_given2' id='h_oth_app_fix_item2_given2' value='<%=h_oth_app_fix_item2_given2%>'>
<input type='hidden' name='h_oth_app_fix_item2_dt2' id='h_oth_app_fix_item2_dt2' value='<%=h_oth_app_fix_item2_dt2%>'>
<input type='hidden' name='h_oth_app_fix_item3' id='h_oth_app_fix_item3' value='<%=h_oth_app_fix_item3%>'>
<input type='hidden' name='h_oth_app_fix_item3_given3' id='h_oth_app_fix_item3_given3' value='<%=h_oth_app_fix_item3_given3%>'>
<input type='hidden' name='h_oth_app_fix_item3_dt3' id='h_oth_app_fix_item3_dt3' value='<%=h_oth_app_fix_item3_dt3%>'>

<input type='hidden' name='h_oth_app_fix_item4' id='h_oth_app_fix_item4' value='<%=h_oth_app_fix_item4%>'>
<input type='hidden' name='h_oth_app_fix_item4_given4' id='h_oth_app_fix_item4_given4' value='<%=h_oth_app_fix_item4_given4%>'>
<input type='hidden' name='h_oth_app_fix_item4_dt4' id='h_oth_app_fix_item4_dt4' value='<%=h_oth_app_fix_item4_dt4%>'>

<input type='hidden' name='h_oth_app_fix_item5' id='h_oth_app_fix_item5' value='<%=h_oth_app_fix_item5%>'>
<input type='hidden' name='h_oth_app_fix_item5_given5' id='h_oth_app_fix_item5_given5' value='<%=h_oth_app_fix_item5_given5%>'>
<input type='hidden' name='h_oth_app_fix_item5_dt5' id='h_oth_app_fix_item5_dt5' value='<%=h_oth_app_fix_item5_dt5%>'>

<input type='hidden' name='h_oth_app_fix_item6' id='h_oth_app_fix_item6' value='<%=h_oth_app_fix_item6%>'><input type='hidden' name='h_oth_app_fix_item6_given6' id='h_oth_app_fix_item6_given6' value='<%=h_oth_app_fix_item6_given6%>'><input type='hidden' name='h_oth_app_fix_item6_dt6' id='h_oth_app_fix_item6_dt6' value='<%=h_oth_app_fix_item6_dt6%>'>

<input type='hidden' name='h_oth_app_fix_item7' id='h_oth_app_fix_item7' value='<%=h_oth_app_fix_item7%>'><input type='hidden' name='h_oth_app_fix_item7_given7' id='h_oth_app_fix_item7_given7' value='<%=h_oth_app_fix_item7_given7%>'><input type='hidden' name='h_oth_app_fix_item7_dt7' id='h_oth_app_fix_item7_dt7' value='<%=h_oth_app_fix_item7_dt7%>'>

<input type='hidden' name='h_oth_app_fix_item8' id='h_oth_app_fix_item8' value='<%=h_oth_app_fix_item8%>'><input type='hidden' name='h_oth_app_fix_item8_given8' id='h_oth_app_fix_item8_given8' value='<%=h_oth_app_fix_item8_given8%>'><input type='hidden' name='h_oth_app_fix_item8_dt8' id='h_oth_app_fix_item8_dt8' value='<%=h_oth_app_fix_item8_dt8%>'>

<input type='hidden' name='h_oth_app_fix_item9' id='h_oth_app_fix_item9' value='<%=h_oth_app_fix_item9%>'><input type='hidden' name='h_oth_app_fix_item9_given9' id='h_oth_app_fix_item9_given9' value='<%=h_oth_app_fix_item9_given9%>'><input type='hidden' name='h_oth_app_fix_item9_dt9' id='h_oth_app_fix_item9_dt9' value='<%=h_oth_app_fix_item9_dt9%>'>

<input type='hidden' name='h_oth_app_fix_item10' id='h_oth_app_fix_item10' value='<%=h_oth_app_fix_item10%>'><input type='hidden' name='h_oth_app_fix_item10_given10' id='h_oth_app_fix_item10_given10' value='<%=h_oth_app_fix_item10_given10%>'><input type='hidden' name='h_oth_app_fix_item10_dt10' id='h_oth_app_fix_item10_dt10' value='<%=h_oth_app_fix_item10_dt10%>'>




<input type='hidden' name='h_ref_ltr_chk' id='h_ref_ltr_chk' value='<%=h_ref_ltr_chk%>'><input type='hidden' name='h_confirm_chk' id='h_confirm_chk' value='<%=h_ref_ltr_conf_chk%>'>
<input type='hidden' name='h_rep_ltr_chk' id='h_rep_ltr_chk' value='<%=h_rep_ltr_chk%>'><input type='hidden' name='h_rep_dtl_txt' id='h_rep_dtl_txt' value='<%=h_rep_ltr_dtls%>'>
<input type='hidden' name='h_rep_cnf_txt' id='h_rep_cnf_txt' value='<%=h_rep_ltr_conf%>'><input type='hidden' name='h_cln_doc_chk' id='h_cln_doc_chk' value='<%=h_cln_doc_chk%>'>
<input type='hidden' name='h_cln_dtl_txt' id='h_cln_dtl_txt' value='<%=h_cln_doc_dtls%>'><input type='hidden' name='h_cln_cnf_txt' id='h_cln_cnf_txt' value='<%=h_cln_doc_conf%>'>
<input type='hidden' name='h_oth_doc_chk' id='h_oth_doc_chk' value='<%=h_oth_doc_chk%>'><input type='hidden' name='h_oth_dtl_txt1' id='h_oth_dtl_txt1' value='<%=h_oth_doc_dtls%>'>
<input type='hidden' name='h_oth_cnf_txt1' id='h_oth_cnf_txt1' value='<%=h_oth_doc_conf%>'><input type='hidden' name='h_oth_doc_txt' id='h_oth_doc_txt' value='<%=h_oth_doc_desc%>'>
<input type='hidden' name='h_relationship' id='h_relationship' value='<%=h_relationship%>'><input type='hidden' name='h_rel_date_time' id='h_rel_date_time' value='<%=h_rel_date_time%>'>
<input type='hidden' name='h_rem_lv_ward' id='h_rem_lv_ward' value='<%=h_rem_lv_ward%>'><input type='hidden' name='h_sc_care_home' id='h_sc_care_home'>
<input type='hidden' name='h_name_of_patient' id='h_name_of_patient' value='<%=h_name_of_patient%>'><input type='hidden' name='h_mot_ic_no' id='h_mot_ic_no' value='<%=h_mot_ic_no%>'>
<input type='hidden' name='h_rn_txt' id='h_rn_txt' value='<%=h_rn_txt%>'><input type='hidden' name='h_ward_txt' id='h_ward_txt' value='<%=h_ward_txt%>'>
<input type='hidden' name='h_discharge_date' id='h_discharge_date' value='<%=h_discharge_date%>'><input type='hidden' name='h_weight_txt' id='h_weight_txt' value='<%=h_weight_txt%>'>
<input type='hidden' name='h_length_txt' id='h_length_txt' value='<%=h_length_txt%>'><input type='hidden' name='h_head_circum' id='h_head_circum' value='<%=h_head_circum%>'>
<input type='hidden' name='h_adv_given' id='h_adv_given' value='<%=h_adv_given%>'>

<input type='hidden' name='h_relationship_txt' id='h_relationship_txt' value='<%=h_relationship_txt%>'>
<input type='hidden' name='h_mother_name' id='h_mother_name' value='<%=h_mother_name%>'>
<input type='hidden' name='h_mother_no' id='h_mother_no' value='<%=h_mother_no%>'>
<input type='hidden' name='h_father_name' id='h_father_name' value='<%=h_father_name%>'>
<input type='hidden' name='h_father_no' id='h_father_no' value='<%=h_father_no%>'>
<input type='hidden' name='h_Remarks' id='h_Remarks' value='<%=h_Remarks%>'>

<input type='hidden' name='h_date_time_txt' id='h_date_time_txt'><input type='hidden' name='h_user_txt' id='h_user_txt'>

<input type='hidden' name='h_dis_medication' id='h_dis_medication' value='<%=h_dis_medication%>'><input type='hidden' name='h_dis_summ_prep' id='h_dis_summ_prep' value='<%=h_dis_summ_prep%>'><input type='hidden' name='h_dis_summ_prep_by' id='h_dis_summ_prep_by' value='<%=h_dis_summ_prep_by%>'>
<input type='hidden' name='h_informed_to' id='h_informed_to' value='<%=h_informed_to%>'><input type='hidden' name='h_cert_no' id='h_cert_no' value='<%=h_cert_no%>'>
<input type='hidden' name='h_loc_txt' id='h_loc_txt' ><input type='hidden' name='h_rem_by_txt' id='h_rem_by_txt'>
<input type='hidden' name='h_apt_date_time' id='h_apt_date_time'>

<input type='hidden' name='system_date_time' id='system_date_time' value="<%=system_date%>">


<input type='hidden' name='h_inform_to' id='h_inform_to' value="">
<input type='hidden' name='h_informed_date' id='h_informed_date' value="">
<input type='hidden' name='h_informed_name' id='h_informed_name' value="">
<input type='hidden' name='h_chargeable_item_yn' id='h_chargeable_item_yn' value="<%=h_chargeable_item_yn%>"><!-- Added by chandra for MMS-KH-CRF-0052.1 -->

<%

if(!disch_chklist_status.equals("")) operation="modify";
else operation = "insert"; %>

<input type='hidden' name='operation' id='operation' value="<%=operation%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
<!-- fields for retaining values from database -->
<input type='hidden' name='hh_iv_catheters_chk' id='hh_iv_catheters_chk' value="<%=h_iv_catheters_chk%>"><input type='hidden' name='hh_iv_removed_by' id='hh_iv_removed_by'  value="<%=h_iv_removed_by%>"><input type='hidden' name='hh_iv_removed_dt' id='hh_iv_removed_dt' value="<%=h_iv_removed_dt%>" >
<input type='hidden' name='hh_tubes_chk' id='hh_tubes_chk' value="<%=h_tubes_chk%>"><input type='hidden' name='hh_tubes_removed_by' id='hh_tubes_removed_by' value="<%=h_tubes_removed_by%>">
<input type='hidden' name='hh_tubes_removed_dt' id='hh_tubes_removed_dt' value="<%=h_tubes_removed_dt%>"><input type='hidden' name='hh_drg_chk' id='hh_drg_chk' value="<%=h_drg_chk%>">
<input type='hidden' name='hh_drg_removed_by' id='hh_drg_removed_by' value="<%=h_drg_removed_by%>"><input type='hidden' name='hh_drg_removed_dt' id='hh_drg_removed_dt' value="<%=h_drg_removed_dt%>"> 
<input type='hidden' name='hh_ngt_tube_chk' id='hh_ngt_tube_chk' value="<%=h_ngt_tube_chk%>"><input type='hidden' name='hh_ngt_tube_removed_by' id='hh_ngt_tube_removed_by' value="<%=h_ngt_tube_removed_by%>"><input type='hidden' name='hh_ngt_tube_removed_dt' id='hh_ngt_tube_removed_dt' value="<%=h_ngt_tube_removed_dt%>">
<input type='hidden' name='hh_cngt_tube_chk' id='hh_cngt_tube_chk' value="<%=h_cngt_tube_chk%>"><input type='hidden' name='hh_cngt_tube_removed_by' id='hh_cngt_tube_removed_by' value="<%=h_cngt_tube_removed_by%>"><input type='hidden' name='hh_cngt_tube_removed_dt' id='hh_cngt_tube_removed_dt' value="<%=h_cngt_tube_removed_dt%>">
<input type='hidden' name='hh_urn_chk' id='hh_urn_chk' value="<%=h_urn_chk%>"><input type='hidden' name='hh_urn_removed_by' id='hh_urn_removed_by' value="<%=h_urn_removed_by%>">
<input type='hidden' name='hh_urn_removed_dt' id='hh_urn_removed_dt' value="<%=h_urn_removed_dt%>"><input type='hidden' name='hh_curn_chk' id='hh_curn_chk' value="<%=h_curn_chk%>">
<input type='hidden' name='hh_curn_removed_by' id='hh_curn_removed_by' value="<%=h_curn_removed_by%>"><input type='hidden' name='hh_curn_removed_dt' id='hh_curn_removed_dt' value="<%=h_curn_removed_dt%>"><input type='hidden' name='hh_sto_chk' id='hh_sto_chk' value="<%=h_sto_chk%>">
<input type='hidden' name='hh_sto_removed_by' id='hh_sto_removed_by' value="<%=h_sto_removed_by%>"><input type='hidden' name='hh_sto_removed_dt' id='hh_sto_removed_dt' value="<%=h_sto_removed_dt%>">
<input type='hidden' name='hh_dressing_chk' id='hh_dressing_chk' value="<%=h_dressing_chk%>"><input type='hidden' name='hh_dressing_removed_by' id='hh_dressing_removed_by' value="<%=h_dressing_removed_by%>"><input type='hidden' name='hh_dressing_removed_dt' id='hh_dressing_removed_dt' value="<%=h_dressing_removed_dt%>">
<input type='hidden' name='hh_blng_returned' id='hh_blng_returned' value="<%=h_blng_returned%>"><input type='hidden' name='hh_blng_returned_dt' id='hh_blng_returned_dt' value="<%=h_blng_returned_dt%>">
<input type='hidden' name='hh_blng_remarks' id='hh_blng_remarks' value="<%=h_blng_remarks%>"><input type='hidden' name='hh_vlb_returned' id='hh_vlb_returned' value="<%=h_vlb_returned%>">
<input type='hidden' name='hh_vlb_returned_by' id='hh_vlb_returned_by' value="<%=h_vlb_user%>"><input type='hidden' name='hh_vlb_witness' id='hh_vlb_witness' value="<%=h_witness_id%>">
<input type='hidden' name='hh_witness_id' id='hh_witness_id' value='<%=h_witness_id%>'><input type='hidden' name='hh_vlb_user' id='hh_vlb_user' value='<%=h_vlb_user%>'>
<input type='hidden' name='hh_tp_arranged' id='hh_tp_arranged' value="<%=h_tp_arranged%>"><input type='hidden' name='hh_tp_returned_dt' id='hh_tp_returned_dt' value="<%=h_tp_returned_dt%>">
<input type='hidden' name='hh_tp_remarks' id='hh_tp_remarks' value="<%=h_tp_remarks%>"><input type='hidden' name='hh_adv_cnt_parent' id='hh_adv_cnt_parent' value="<%=h_adv_cnt_parent%>">
<input type='hidden' name='hh_adv_cnt_guardian' id='hh_adv_cnt_guardian' value="<%=h_adv_cnt_guardian%>"><input type='hidden' name='hh_wc_chk' id='hh_wc_chk' value="<%=h_wc_chk%>">
<input type='hidden' name='hh_wc_given_by' id='hh_wc_given_by' value="<%=h_wc_given_by%>"><input type='hidden' name='hh_wc_given_dt' id='hh_wc_given_dt' value="<%=h_wc_given_dt%>">
<input type='hidden' name='hh_nu_chk' id='hh_nu_chk' value="<%=h_nu_chk%>"><input type='hidden' name='hh_nu_given_by' id='hh_nu_given_by' value="<%=h_nu_given_by%>">
<input type='hidden' name='hh_nu_given_dt' id='hh_nu_given_dt' value="<%=h_nu_given_dt%>"><input type='hidden' name='hh_mc_chk' id='hh_mc_chk' value="<%=h_mc_chk%>">
<input type='hidden' name='hh_mc_given_by' id='hh_mc_given_by' value="<%=h_mc_given_by%>"><input type='hidden' name='hh_mc_given_dt' id='hh_mc_given_dt' value="<%=h_mc_given_dt%>">
<input type='hidden' name='hh_ph_chk' id='hh_ph_chk' value="<%=h_ph_chk%>"><input type='hidden' name='hh_ph_given_by' id='hh_ph_given_by' value="<%=h_ph_given_by%>">
<input type='hidden' name='hh_ph_given_dt' id='hh_ph_given_dt' value="<%=h_ph_given_dt%>"><input type='hidden' name='hh_cop_chk' id='hh_cop_chk' value="<%=h_cop_chk%>">
<input type='hidden' name='hh_cop_given_by' id='hh_cop_given_by' value="<%=h_cop_given_by%>"><input type='hidden' name='hh_cop_given_dt' id='hh_cop_given_dt' value="<%=h_cop_given_dt%>">
<input type='hidden' name='hh_coc_chk' id='hh_coc_chk' value="<%=h_coc_chk%>"><input type='hidden' name='hh_coc_given_by' id='hh_coc_given_by' value="<%=h_coc_given_by%>">
<input type='hidden' name='hh_coc_given_dt' id='hh_coc_given_dt' value="<%=h_coc_given_dt%>"><input type='hidden' name='hh_cot_chk' id='hh_cot_chk' value="<%=h_cot_chk%>">
<input type='hidden' name='hh_cot_given_by' id='hh_cot_given_by' value="<%=h_cot_given_by%>"><input type='hidden' name='hh_cot_given_dt' id='hh_cot_given_dt' value="<%=h_cot_given_dt%>">
<input type='hidden' name='hh_oth_he_chk' id='hh_oth_he_chk' value="<%=h_oth_he_chk%>"><input type='hidden' name='hh_oth_text' id='hh_oth_text' value="<%=h_oth_text%>">
<input type='hidden' name='hh_oth_given_by' id='hh_oth_given_by' value="<%=h_oth_given_by%>"><input type='hidden' name='hh_oth_given_dt' id='hh_oth_given_dt' value="<%=h_oth_given_dt%>">
<input type='hidden' name='hh_top_to_toe_chk' id='hh_top_to_toe_chk' value="<%=h_top_to_toe_chk%>"><input type='hidden' name='hh_co_umb_stmp_chk' id='hh_co_umb_stmp_chk' value="<%=h_co_umb_stmp_chk%>">
<input type='hidden' name='hh_care_of_skin_chk' id='hh_care_of_skin_chk' value="<%=h_care_of_skin_chk%>"><input type='hidden' name='hh_care_of_eye_chk' id='hh_care_of_eye_chk' value="<%=h_care_of_eye_chk%>"><input type='hidden' name='hh_expr_br_mlk_chk' id='hh_expr_br_mlk_chk' value="<%=h_expr_br_mlk_chk%>">
<input type='hidden' name='hh_tube_feed_chk' id='hh_tube_feed_chk' value="<%=h_tube_feed_chk%>"><input type='hidden' name='hh_gst_feed_chk' id='hh_gst_feed_chk' value="<%=h_gst_feed_chk%>">
<input type='hidden' name='hh_frm_milk_chk' id='hh_frm_milk_chk' value="<%=h_frm_milk_chk%>"><input type='hidden' name='hh_imn_sch_chk' id='hh_imn_sch_chk' value="<%=h_imn_sch_chk%>">
<input type='hidden' name='hh_care_of_stoma_chk' id='hh_care_of_stoma_chk' value="<%=h_care_of_stoma_chk%>"><input type='hidden' name='hh_anl_dil_chk' id='hh_anl_dil_chk' value="<%=h_anl_dil_chk%>">
<input type='hidden' name='hh_pop_chk' id='hh_pop_chk' value="<%=h_pop_chk%>"><input type='hidden' name='hh_fever_chk' id='hh_fever_chk' value="<%=h_fever_chk%>">
<input type='hidden' name='hh_sz_chk' id='hh_sz_chk' value="<%=h_sz_chk%>"><input type='hidden' name='hh_jnd_chk' id='hh_jnd_chk' value="<%=h_jnd_chk%>">
<input type='hidden' name='hh_gpd_chk' id='hh_gpd_chk' value="<%=h_gpd_chk%>"><input type='hidden' name='hh_stlc_chk' id='hh_stlc_chk' value="<%=h_stlc_chk%>">
<input type='hidden' name='hh_stlf_chk' id='hh_stlf_chk' value="<%=h_stlf_chk%>"><input type='hidden' name='hh_coptb_chk' id='hh_coptb_chk' value="<%=h_coptb_chk%>">
<input type='hidden' name='hh_oth_ph_chk' id='hh_oth_ph_chk' value="<%=h_oth_ph_chk%>"><input type='hidden' name='hh_bfd_chk' id='hh_bfd_chk' value="<%=h_bfd_chk%>">
<input type='hidden' name='hh_stm_cr_chk' id='hh_stm_cr_chk' value="<%=h_stm_cr_chk%>"><input type='hidden' name='hh_oper_chk' id='hh_oper_chk' value="<%=h_oper_chk%>">
<input type='hidden' name='hh_pop_care_chk' id='hh_pop_care_chk' value="<%=h_pop_care_chk%>"><input type='hidden' name='hh_oth_pamphlets' id='hh_oth_pamphlets' value="<%=h_oth_pamphlets%>">
<input type='hidden' name='hh_dn_given_chk' id='hh_dn_given_chk' value="<%=h_dn_given_chk%>"><input type='hidden' name='hh_db_given_chk' id='hh_db_given_chk' value="<%=h_db_given_chk%>">
<input type='hidden' name='hh_oth_app_fix_item1' id='hh_oth_app_fix_item1' value="<%=h_oth_app_fix_item1%>"><input type='hidden' name='hh_oth_app_fix_item1_given1' id='hh_oth_app_fix_item1_given1' value="<%=h_oth_app_fix_item1_given1%>"><input type='hidden' name='hh_oth_app_fix_item1_dt1' id='hh_oth_app_fix_item1_dt1' value="<%=h_oth_app_fix_item1_dt1%>">

<input type='hidden' name='hh_oth_app_fix_item2' id='hh_oth_app_fix_item2' value="<%=h_oth_app_fix_item2%>"><input type='hidden' name='hh_oth_app_fix_item2_given2' id='hh_oth_app_fix_item2_given2' value="<%=h_oth_app_fix_item2_given2%>"><input type='hidden' name='hh_oth_app_fix_item2_dt2' id='hh_oth_app_fix_item2_dt2' value="<%=h_oth_app_fix_item2_dt2%>">

<input type='hidden' name='hh_oth_app_fix_item3' id='hh_oth_app_fix_item3' value="<%=h_oth_app_fix_item3%>"><input type='hidden' name='hh_oth_app_fix_item3_given3' id='hh_oth_app_fix_item3_given3' value="<%=h_oth_app_fix_item3_given3%>"><input type='hidden' name='hh_oth_app_fix_item3_dt3' id='hh_oth_app_fix_item3_dt3' value="<%=h_oth_app_fix_item3_dt3%>">

<input type='hidden' name='hh_oth_app_fix_item4' id='hh_oth_app_fix_item4' value="<%=h_oth_app_fix_item4%>"><input type='hidden' name='hh_oth_app_fix_item4_given4' id='hh_oth_app_fix_item4_given4' value="<%=h_oth_app_fix_item4_given4%>"><input type='hidden' name='hh_oth_app_fix_item4_dt4' id='hh_oth_app_fix_item4_dt4' value="<%=h_oth_app_fix_item4_dt4%>">

<input type='hidden' name='hh_oth_app_fix_item5' id='hh_oth_app_fix_item5' value="<%=h_oth_app_fix_item5%>"><input type='hidden' name='hh_oth_app_fix_item5_given5' id='hh_oth_app_fix_item5_given5' value="<%=h_oth_app_fix_item5_given5%>"><input type='hidden' name='hh_oth_app_fix_item5_dt5' id='hh_oth_app_fix_item5_dt5' value="<%=h_oth_app_fix_item5_dt5%>">

<input type='hidden' name='hh_oth_app_fix_item6' id='hh_oth_app_fix_item6' value="<%=h_oth_app_fix_item6%>"><input type='hidden' name='hh_oth_app_fix_item6_given6' id='hh_oth_app_fix_item6_given6' value="<%=h_oth_app_fix_item6_given6%>"><input type='hidden' name='hh_oth_app_fix_item6_dt6' id='hh_oth_app_fix_item6_dt6' value="<%=h_oth_app_fix_item6_dt6%>">

<input type='hidden' name='hh_oth_app_fix_item7' id='hh_oth_app_fix_item7' value="<%=h_oth_app_fix_item7%>"><input type='hidden' name='hh_oth_app_fix_item7_given7' id='hh_oth_app_fix_item7_given7' value="<%=h_oth_app_fix_item7_given7%>"><input type='hidden' name='hh_oth_app_fix_item7_dt7' id='hh_oth_app_fix_item7_dt7' value="<%=h_oth_app_fix_item7_dt7%>">

<input type='hidden' name='hh_oth_app_fix_item8' id='hh_oth_app_fix_item8' value="<%=h_oth_app_fix_item8%>"><input type='hidden' name='hh_oth_app_fix_item8_given8' id='hh_oth_app_fix_item8_given8' value="<%=h_oth_app_fix_item8_given8%>"><input type='hidden' name='hh_oth_app_fix_item8_dt8' id='hh_oth_app_fix_item8_dt8' value="<%=h_oth_app_fix_item8_dt8%>">

<input type='hidden' name='hh_oth_app_fix_item9' id='hh_oth_app_fix_item9' value="<%=h_oth_app_fix_item9%>"><input type='hidden' name='hh_oth_app_fix_item9_given9' id='hh_oth_app_fix_item9_given9' value="<%=h_oth_app_fix_item9_given9%>"><input type='hidden' name='hh_oth_app_fix_item9_dt9' id='hh_oth_app_fix_item9_dt9' value="<%=h_oth_app_fix_item9_dt9%>">

<input type='hidden' name='hh_oth_app_fix_item10' id='hh_oth_app_fix_item10' value="<%=h_oth_app_fix_item10%>"><input type='hidden' name='hh_oth_app_fix_item10_given10' id='hh_oth_app_fix_item10_given10' value="<%=h_oth_app_fix_item10_given10%>"><input type='hidden' name='hh_oth_app_fix_item10_dt10' id='hh_oth_app_fix_item10_dt10' value="<%=h_oth_app_fix_item10_dt10%>">

<input type='hidden' name='hh_ref_ltr_chk' id='hh_ref_ltr_chk' value="<%=h_ref_ltr_chk%>"><input type='hidden' name='hh_confirm_chk' id='hh_confirm_chk' value="<%=h_ref_ltr_conf_chk%>">
<input type='hidden' name='hh_rep_ltr_chk' id='hh_rep_ltr_chk' value="<%=h_rep_ltr_chk%>"><input type='hidden' name='hh_rep_dtl_txt' id='hh_rep_dtl_txt' value='<%=h_rep_ltr_dtls%>'>
<input type='hidden' name='hh_rep_cnf_txt' id='hh_rep_cnf_txt' value='<%=h_rep_ltr_conf%>'><input type='hidden' name='hh_cln_doc_chk' id='hh_cln_doc_chk' value="<%=h_cln_doc_chk%>">
<input type='hidden' name='hh_cln_dtl_txt' id='hh_cln_dtl_txt' value='<%=h_cln_doc_dtls%>'><input type='hidden' name='hh_cln_cnf_txt' id='hh_cln_cnf_txt' value="<%=h_cln_doc_conf%>">
<input type='hidden' name='hh_oth_doc_chk' id='hh_oth_doc_chk' value="<%=h_oth_doc_chk%>"><input type='hidden' name='hh_oth_dtl_txt1' id='hh_oth_dtl_txt1' value='<%=h_oth_doc_dtls%>'>
<input type='hidden' name='hh_oth_cnf_txt1' id='hh_oth_cnf_txt1' value='<%=h_oth_doc_conf%>'><input type='hidden' name='hh_oth_doc_txt' id='hh_oth_doc_txt' value='<%=h_oth_doc_desc%>'>
<input type='hidden' name='hh_relationship' id='hh_relationship' value="<%=h_relationship%>"><input type='hidden' name='hh_rel_date_time' id='hh_rel_date_time' value="<%=h_rel_date_time%>">
<input type='hidden' name='hh_rem_lv_ward' id='hh_rem_lv_ward' value="<%=h_rem_lv_ward%>"><input type='hidden' name='hh_sc_care_home' id='hh_sc_care_home'>
<input type='hidden' name='hh_name_of_patient' id='hh_name_of_patient' value="<%=h_name_of_patient%>"><input type='hidden' name='hh_mot_ic_no' id='hh_mot_ic_no' value="<%=h_mot_ic_no%>">
<input type='hidden' name='hh_rn_txt' id='hh_rn_txt' value="<%=h_rn_txt%>"><input type='hidden' name='hh_ward_txt' id='hh_ward_txt' value="<%=h_ward_txt%>">
<input type='hidden' name='hh_discharge_date' id='hh_discharge_date' value="<%=h_discharge_date%>"><input type='hidden' name='hh_weight_txt' id='hh_weight_txt' value="<%=h_weight_txt%>">
<input type='hidden' name='hh_length_txt' id='hh_length_txt' value="<%=h_length_txt%>"><input type='hidden' name='hh_head_circum' id='hh_head_circum' value="<%=h_head_circum%>">
<input type='hidden' name='hh_adv_given' id='hh_adv_given' value="<%=h_adv_given%>">


<input type='hidden' name='hh_relationship_txt' id='hh_relationship_txt' value="<%=h_relationship_txt%>">
<input type='hidden' name='hh_mother_name' id='hh_mother_name' value="<%=h_mother_name%>">
<input type='hidden' name='hh_mother_no' id='hh_mother_no' value="<%=h_mother_no%>">
<input type='hidden' name='hh_father_name' id='hh_father_name' value="<%=h_father_name%>">
<input type='hidden' name='hh_father_no' id='hh_father_no' value="<%=h_father_no%>">
<input type='hidden' name='hh_Remarks' id='hh_Remarks' value="<%=h_Remarks%>">


<input type='hidden' name='hh_date_time_txt' id='hh_date_time_txt' value="<%=h_date_time_txt%>"><input type='hidden' name='hh_user_txt' id='hh_user_txt' value="<%=h_user_txt%>">

<input type='hidden' name='hh_dis_medication' id='hh_dis_medication' value="<%=h_dis_medication%>"><input type='hidden' name='hh_dis_summ_prep' id='hh_dis_summ_prep' value="<%=h_dis_summ_prep%>"><input type='hidden' name='hh_dis_summ_prep_by' id='hh_dis_summ_prep_by' value="<%=h_dis_summ_prep_by%>"> 
<input type='hidden' name='hh_informed_to' id='hh_informed_to' value="<%=h_informed_to%>"><input type='hidden' name='hh_cert_no' id='hh_cert_no' value="<%=h_cert_no%>">
<input type='hidden' name='hh_loc_txt' id='hh_loc_txt' ><input type='hidden' name='hh_rem_by_txt' id='hh_rem_by_txt'>
<input type='hidden' name='hh_apt_date_time' id='hh_apt_date_time'>
<input type='hidden' name='patient_age' id='patient_age' value="<%=patient_age%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='admission_date_time' id='admission_date_time' value='<%=admission_date_time%>'>
<input type='hidden' name='system_date_display' id='system_date_display' value='<%=system_date_display%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='max_trn_date_time' id='max_trn_date_time' value="<%=max_trn_date_time%>">

<!--Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620-->
<input type='hidden' name='cert_num' id='cert_num' value="<%=cert_num%>">
<input type='hidden' name='cert_from_date' id='cert_from_date' value="<%=cert_from_date%>">
<input type='hidden' name='cert_to_date' id='cert_to_date' value="<%=cert_to_date%>">
<input type='hidden' name='duration' id='duration' value="<%=duration%>">
<input type='hidden' name='duration_dmy' id='duration_dmy' value="<%=duration_dmy%>">
<!--Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050-->
<input type='hidden' name='deli_cert_num' id='deli_cert_num' value="<%=deli_cert_num%>">

<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<input type='hidden' name='isChangesInAdditionalDtlsTabAppl' id='isChangesInAdditionalDtlsTabAppl' value="<%=isChangesInAdditionalDtlsTabAppl%>">

<input type='hidden' name='h_iv_remove_chk' id='h_iv_remove_chk' value='<%=h_iv_remove_chk%>' >
<input type='hidden' name='h_iv_remarks' id='h_iv_remarks' value='<%=h_iv_remarks%>' >
<input type='hidden' name='h_tubes_remove_chk' id='h_tubes_remove_chk' value='<%=h_tubes_remove_chk%>' >
<input type='hidden' name='h_tubes_remarks' id='h_tubes_remarks' value='<%=h_tubes_remarks%>' >
<input type='hidden' name='h_drg_remove_chk' id='h_drg_remove_chk' value='<%=h_drg_remove_chk%>' >
<input type='hidden' name='h_drg_remarks' id='h_drg_remarks' value='<%=h_drg_remarks%>' >
<input type='hidden' name='h_ngt_remove_chk' id='h_ngt_remove_chk' value='<%=h_ngt_remove_chk%>' >
<input type='hidden' name='h_ngt_remarks' id='h_ngt_remarks' value='<%=h_ngt_remarks%>' >
<input type='hidden' name='h_urn_remove_chk' id='h_urn_remove_chk' value='<%=h_urn_remove_chk%>' >
<input type='hidden' name='h_urn_remarks' id='h_urn_remarks' value='<%=h_urn_remarks%>' >
<input type='hidden' name='h_sto_remove_chk' id='h_sto_remove_chk' value='<%=h_sto_remove_chk%>' >
<input type='hidden' name='h_sto_remarks' id='h_sto_remarks' value='<%=h_sto_remarks%>' >
<input type='hidden' name='h_dressing_remove_chk' id='h_dressing_remove_chk' value='<%=h_dressing_remove_chk%>' >
<input type='hidden' name='h_dressing_remarks' id='h_dressing_remarks' value='<%=h_dressing_remarks%>' >

<input type='hidden' name='hh_iv_remove_chk' id='hh_iv_remove_chk' value='<%=h_iv_remove_chk%>' >
<input type='hidden' name='hh_iv_remarks' id='hh_iv_remarks' value='<%=h_iv_remarks%>' >
<input type='hidden' name='hh_tubes_remove_chk' id='hh_tubes_remove_chk' value='<%=h_tubes_remove_chk%>' >
<input type='hidden' name='hh_tubes_remarks' id='hh_tubes_remarks' value='<%=h_tubes_remarks%>' >
<input type='hidden' name='hh_drg_remove_chk' id='hh_drg_remove_chk' value='<%=h_drg_remove_chk%>' >
<input type='hidden' name='hh_drg_remarks' id='hh_drg_remarks' value='<%=h_drg_remarks%>' >
<input type='hidden' name='hh_ngt_remove_chk' id='hh_ngt_remove_chk' value='<%=h_ngt_remove_chk%>' >
<input type='hidden' name='hh_ngt_remarks' id='hh_ngt_remarks' value='<%=h_ngt_remarks%>' >
<input type='hidden' name='hh_urn_remove_chk' id='hh_urn_remove_chk' value='<%=h_urn_remove_chk%>' >
<input type='hidden' name='hh_urn_remarks' id='hh_urn_remarks' value='<%=h_urn_remarks%>' >
<input type='hidden' name='hh_sto_remove_chk' id='hh_sto_remove_chk' value='<%=h_sto_remove_chk%>' >
<input type='hidden' name='hh_sto_remarks' id='hh_sto_remarks' value='<%=h_sto_remarks%>' >
<input type='hidden' name='hh_dressing_remove_chk' id='hh_dressing_remove_chk' value='<%=h_dressing_remove_chk%>' >
<input type='hidden' name='hh_dressing_remarks' id='hh_dressing_remarks' value='<%=h_dressing_remarks%>' >
<!--End ML-MMOH-CRF-1142-->

<!--Added by Mano on 19-Mar-2018 for ML-MMOH-CRF-1049-->
<input type='hidden' id='isAutoPopDurationApplyn' value="<%=isAutoPopDurationApplyn%>"/>

<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->
<input type='hidden' name='isItemOnLoanOthersDisableDateAppl' id='isItemOnLoanOthersDisableDateAppl' value="<%=isItemOnLoanOthersDisableDateAppl%>">
<input type='hidden' name='h_itemloan_chk' id='h_itemloan_chk' value='<%=h_itemloan_chk%>'>
<input type='hidden' name='h_itemloan_removed_by' id='h_itemloan_removed_by' value='<%=h_itemloan_removed_by%>'>
<input type='hidden' name='h_itemloan_removed_dt' id='h_itemloan_removed_dt' value='<%=h_itemloan_removed_dt%>'>
<input type='hidden' name='h_itemloan_remove_chk' id='h_itemloan_remove_chk' value='<%=h_itemloan_remove_chk%>'>
<input type='hidden' name='h_itemloan_remarks' id='h_itemloan_remarks' value='<%=h_itemloan_remarks%>'>
<input type='hidden' name='hh_itemloan_chk' id='hh_itemloan_chk' value="<%=h_itemloan_chk%>">
<input type='hidden' name='hh_itemloan_removed_by' id='hh_itemloan_removed_by' value="<%=h_itemloan_removed_by%>">
<input type='hidden' name='hh_itemloan_removed_dt' id='hh_itemloan_removed_dt' value="<%=h_itemloan_removed_dt%>">
<input type='hidden' name='hh_itemloan_remove_chk' id='hh_itemloan_remove_chk' value='<%=h_itemloan_remove_chk%>'>
<input type='hidden' name='hh_itemloan_remarks' id='hh_itemloan_remarks' value='<%=h_itemloan_remarks%>'>
<input type='hidden' name='h_others_chk' id='h_others_chk' value='<%=h_others_chk%>'>
<input type='hidden' name='h_others_removed_by' id='h_others_removed_by' value='<%=h_others_removed_by%>'>
<input type='hidden' name='h_others_removed_dt' id='h_others_removed_dt' value='<%=h_others_removed_dt%>'>
<input type='hidden' name='h_others_remove_chk' id='h_others_remove_chk' value='<%=h_others_remove_chk%>'>
<input type='hidden' name='h_others_remarks' id='h_others_remarks' value='<%=h_others_remarks%>'>
<input type='hidden' name='hh_others_chk' id='hh_others_chk' value="<%=h_others_chk%>">
<input type='hidden' name='hh_others_removed_by' id='hh_others_removed_by' value="<%=h_others_removed_by%>">
<input type='hidden' name='hh_others_removed_dt' id='hh_others_removed_dt' value="<%=h_others_removed_dt%>">
<input type='hidden' name='hh_others_remove_chk' id='hh_others_remove_chk' value='<%=h_others_remove_chk%>'>
<input type='hidden' name='hh_others_remarks' id='hh_others_remarks' value='<%=h_others_remarks%>'>
<!--End ML-MMOH-CRF-1218-->
<input type='hidden' name='hh_chargeable_item_yn' id='hh_chargeable_item_yn' value="<%=h_chargeable_item_yn%>"><!-- Added by chandra for MMS-KH-CRF-0052.1 -->
<script>
if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1)
{
	if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0])
	{
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication)
		{
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication.value=document.forms[0].h_dis_medication.value;
			if(document.forms[0].h_dis_medication.value == 'Y')	
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication.checked = true;
		}
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn)
		{//Adding start by Chandra for MMS-KH-CRF-0052.1
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn.value=document.forms[0].h_chargeable_item_yn.value;
			if(document.forms[0].h_chargeable_item_yn.value == 'Y')	
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn.checked = true;
		}//Adding end for MMS-KH-CRF-0052.1
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep)
		{
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.value=document.forms[0].h_dis_summ_prep.value;
			if(document.forms[0].h_dis_summ_prep.value == 'Y')
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.checked = true;
		}

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by)
		{
			parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by.value=document.forms[0].h_dis_summ_prep_by.value;
		}
	}
}

</script>
<%
	if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
	{
%>
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=user_name%>">
	<input type="hidden" name="p_encounter_id" id="p_encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="p_resp_id" id="p_resp_id" value="<%=p_resp_id%>">
<%
	}
%>
</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

