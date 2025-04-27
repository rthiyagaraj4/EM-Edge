/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019	IN068345     Prathyusha	                                     Required changes in item substitute mapping set up

27/05/2020  IN072875     Prabha                                          MMS-DM-CRF-0169
--------------------------------------------------------------------------------------------------------------------
*/
 package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ; 
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ; 
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class ParameterBean extends PhAdapter implements Serializable {

        protected String drug_item_code_link        ="";
        protected String drug_item_code_relation    ="";
        protected String gen_drug_code              ="";
        protected String drug_item_set_up           ="";
        protected String split_dose_freq            ="";
        protected String stat_dose_freq             ="";
        protected String route_transfusion          ="";
		//added on 25/04/2004 for drug searched by .
		protected String medn_order_by				="";
		protected String elapsed_period_of_orders_adr="";

		//ends here
		//added on 17/11/2004 for default frequency for tpn
		protected String deflt_freq_fr_tpn				="";
		protected String max_pres_duration				="";
        protected String allow_refill					="";
        protected String refill_allowed				    ="";
        protected String refill_prescription            ="";
        protected String print_refill                   ="";
        protected String prescription_duration          ="";
        protected String alternate_drug_selection       ="";
        protected String dispense_value_strength        ="";
		protected String allow_sel_by_atc_yn	        ="";
		protected String disp_alt_form_yn		    	="";
        protected String allow_dispense                 ="";
        protected String no_days_ahead                  ="";
        protected String allow_past_dispense            ="";
        protected String upto_days                      ="";
		protected String drug_db_interface_yn           ="N";
		protected String drug_db_interface_name         ="";
		protected String drug_db_dosecheck_yn           ="N";
		protected String drug_db_duptherapy_yn          ="N";
		protected String drug_db_interaction_yn         ="N";
		protected String drug_db_contracheck_yn         ="N";
		protected String drug_db_alergycheck_yn         ="N";
		protected String regn_stage_prompt		    	="Registration";
		protected String verify_stage_prompt	    	="Verification";
		protected String fill_stage_prompt		    	="Fill";
		protected String allocate_stage_prompt	    	="Allocate";
		protected String bill_receipt_stage_prompt   	="Bill/Receipt";
		protected String deliver_stage_prompt		    ="Deliver";
		protected String iv_with_additives              ="IV With Additives";
		protected String iv_intermittent                ="IV Intermittent";
		protected String iv_without_additives           ="IV Without Additives";
		protected String build_setup_log_yn		    	= "";
		protected String imageFilePath			    	= "";
		protected String print_alt_drug_dosage_qty_yn	="";
		protected String issue_uom_by	="D";
		protected String max_durn_for_dm_pres="";
		protected String trade_display_yn	="";
		protected String max_length_prn_remarks = ""; // Added for CRF 558 to get the max length of prn remarks

		protected String first_trimster_from = ""; // Added for RUT-CRF-0063 [IN:029601] -start
		protected String first_trimster_to = ""; 
		protected String second_trimster_from = ""; 
		protected String second_trimster_to = ""; 
		protected String third_trimster_from = ""; 
		protected String third_trimster_to = "";
		protected String preg_record_yn = "N";// Added for  RUT-CRF-0063 [IN:029601] -end
		protected String iv_calc_infuse_by = "D";// Added for  SKR-CRF-0035 [IN:037747] 
		protected String infusion_over_yn = "Y";// Added for  AAKH-CRF-0094 
		
		protected String eprescription_content_yn = "N"; // MMS-DM-CRF-0619

    public ParameterBean() {
        try {
            doCommon();
        }catch(Exception e) {
		e.printStackTrace() ;
		}
    }

	public String stockInstallYN()throws Exception {

        String st_install_yn       = "N";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        int count               = 0;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT4") ) ;
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
                count=resultSet.getInt(1);
            }
        if(count==0) st_install_yn="N";
        else st_install_yn="Y";

        } catch ( Exception e ) {
              e.printStackTrace() ;
            throw e ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
            }

        }
		return st_install_yn;
    }

	public String ipInstallYN()throws Exception {

        String ip_install_yn       = "N";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        int count               = 0;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT6") ) ;
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
                count=resultSet.getInt(1);
            }
        if(count==0) ip_install_yn="N";
        else ip_install_yn="Y";

        } catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
            }

        }
		return ip_install_yn;
    }


    public ArrayList loadRouteforTransfusion()throws Exception {

        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList record        =new ArrayList();
        HashMap   data          =null;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT3") ) ;
			pstmt.setString(1,getLanguageId());
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
                data            =new HashMap();
                data.put("route_code",resultSet.getString("route_code"));
                data.put("route_desc",resultSet.getString("route_desc"));
				data.put("route_color",checkForNull(resultSet.getString("route_color")));// added for CRF RUT-CRF-0034.1[IN:037389]
                record.add(data);
            }
        }
		catch ( Exception e ) {
            record.add("Exception from loadRouteforTransfusion :"+e);
            e.printStackTrace() ;
            throw e ;
        } 
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
            }

        }
    return record;
    }

// The following function fetches the default frequecy for tpn --- srijagadeesh; 17/11/2004

	public ArrayList defaultFrequencyforTpn()throws Exception {

        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList record        =new ArrayList();
        HashMap   data          =null;

        try {
            connection = getConnection() ;
            pstmt =         connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DEFAULT_FREQUENCY_SELECT1")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
                data            =new HashMap();
                data.put("freq_code",resultSet.getString("freq_code"));
                data.put("freq_desc",resultSet.getString("freq_desc"));
                record.add(data);
            }

        } catch ( Exception e ) {
            record.add("Exception from loadRouteforTransfusion :"+e);
	           e.printStackTrace() ;
            throw e ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
            }

        }
    return record;
    }


//this function are used  license key
/*
public String licenseYN()throws Exception {

        String licenseYN="";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        int count               = 0;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement("select DRUG_DB_INTERFACE_YN from ph_param") ; 
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next()) {
                licenseYN=resultSet.getString("DRUG_DB_INTERFACE_YN");
            }
        

        } catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
            }

        }

    }

/*
	public ArrayList loadDrugDatabaseNames() throws Exception{
		ArrayList result = new ArrayList();
 	    Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT7") ) ;
            resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
                result.add(resultSet.getString("PRODUCT_ID"));
                result.add(resultSet.getString("PRODUCT_DESC"));                
            }

        } catch ( Exception e ) {
            result.add("Exception from loadRouteforTransfusion :"+e);
            e.printStackTrace() ;
            throw e ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace() ;
			}

        }
		return result;
	}


*/

    public HashMap loadExistData()throws Exception {

        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        HashMap   data          =	null;

        try {
            connection = getConnection() ;
			//String str ="SELECT DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING, DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES, ALLOW_SEL_BY_ATC_YN, DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN,DISP_BEYOND_NO_OF_DAYS,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN, REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT, DELIVER_STAGE_PROMPT, APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN FROM PH_PARAM WHERE MODULE_ID='PH'";
		   
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT8")) ;
			//String str="SELECT DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING,DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES,REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES,ALLOW_SEL_BY_ATC_YN, DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS,DISP_BEYOND_EARLIEST_START_YN,DISP_BEYOND_NO_OF_DAYS,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN,REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT,DELIVER_STAGE_PROMPT, APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN,ITEM_IMAGE_PATH,PRINT_ALT_DRUG_DOSAGE_QTY_YN,ISSUE_UOM_BY,MAX_DURN_FOR_DM_PRES,TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,FRIST_TRIMSTER_START,FRIST_TRIMSTER_END,SECOND_TRIMSTER_START,SECOND_TRIMSTER_END,THIRD_TRIMSTER_START,THIRD_TRIMSTER_END,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY FROM PH_PARAM_LANG_VW PH_PARAM WHERE MODULE_ID='PH' AND LANGUAGE_ID = ?"; //trimster fields added for  RUT-CRF-0063 [IN:029601]
			String str="SELECT DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING,DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES,REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES,ALLOW_SEL_BY_ATC_YN, DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS,DISP_BEYOND_EARLIEST_START_YN,DISP_BEYOND_NO_OF_DAYS,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN,REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT,DELIVER_STAGE_PROMPT, APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN,ITEM_IMAGE_PATH,PRINT_ALT_DRUG_DOSAGE_QTY_YN,ISSUE_UOM_BY,MAX_DURN_FOR_DM_PRES,TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,FRIST_TRIMSTER_START,FRIST_TRIMSTER_END,SECOND_TRIMSTER_START,SECOND_TRIMSTER_END,THIRD_TRIMSTER_START,THIRD_TRIMSTER_END,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY,INFUSION_OVER_APP_YN,EPRESCRIPTION_CONTENT_YN FROM PH_PARAM_LANG_VW PH_PARAM WHERE MODULE_ID='PH' AND LANGUAGE_ID = ?"; //INFUSION_OVER_APP_YN added for AAKH-CRF-0094 trimster fields added for  RUT-CRF-0063 [IN:029601] //EPRESCRIPTION_CONTENT_YN--added for mms-dm-crf-0619

			pstmt = connection.prepareStatement(str);
			pstmt.setString(1,getLanguageId());

            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				data = new HashMap();
                data.put("drug_item_code_link_reqd_yn",resultSet.getString("DRUG_ITEM_CODE_LINK_REQD_YN"));
                data.put("drug_and_item_code_same_ind",resultSet.getString("DRUG_AND_ITEM_CODE_SAME_IND"));
                data.put("drug_code_gen_rule",resultSet.getString("DRUG_CODE_GEN_RULE"));
                data.put("drug_to_item_mapping",resultSet.getString("DRUG_TO_ITEM_MAPPING"));
                data.put("dflt_split_dose_freq_code",resultSet.getString("DFLT_SPLIT_DOSE_FREQ_CODE"));
                data.put("dflt_stat_dose_freq_code",resultSet.getString("DFLT_STAT_DOSE_FREQ_CODE"));
                data.put("dflt_iv_route_code",resultSet.getString("DFLT_IV_ROUTE_CODE"));
				data.put("medn_order_by",resultSet.getString("MEDN_ORDER_BY"));
                data.put("max_durn_for_op_pres",resultSet.getString("MAX_DURN_FOR_OP_PRES"));
                data.put("refill_yn",resultSet.getString("REFILL_YN"));
                data.put("max_refills_for_pres",resultSet.getString("MAX_REFILLS_FOR_PRES"));
                data.put("print_refill_pres_with_main_yn",resultSet.getString("PRINT_REFILL_PRES_WITH_MAIN_YN"));
                data.put("max_durn_for_refill_pres",resultSet.getString("MAX_DURN_FOR_REFILL_PRES"));
                data.put("max_durn_for_ip_pres",resultSet.getString("MAX_DURN_FOR_IP_PRES"));
                data.put("allow_sel_by_atc_yn",resultSet.getString("ALLOW_SEL_BY_ATC_YN"));
				data.put("disp_alt_form_yn",resultSet.getString("DISP_ALT_FORM_YN"));
                data.put("disp_multi_strength_yn",resultSet.getString("DISP_MULTI_STRENGTH_YN"));
                data.put("disp_before_start_date_yn",resultSet.getString("DISP_BEFORE_START_DATE_YN"));
                data.put("disp_before_no_of_days",resultSet.getString("DISP_BEFORE_NO_OF_DAYS"));
                data.put("disp_beyond_earliest_start_yn",resultSet.getString("DISP_BEYOND_EARLIEST_START_YN"));
                data.put("disp_beyond_no_of_days",resultSet.getString("DISP_BEYOND_NO_OF_DAYS"));
				data.put("drug_db_interface_yn",resultSet.getString("DRUG_DB_INTERFACE_YN"));
				//data.put("drug_db_interface_name",resultSet.getString("DRUG_DB_INTERFACE_NAME"));
				//data.put("drug_db_dosecheck_yn",resultSet.getString("DRUG_DB_DOSECHECK_YN"));
				//data.put("drug_db_duptherapy_yn",resultSet.getString("DRUG_DB_DUPTHERAPY_YN"));
				data.put("regn_stage_prompt",resultSet.getString("REGN_STAGE_PROMPT"));
				data.put("verify_stage_prompt",resultSet.getString("VERIFY_STAGE_PROMPT"));
				data.put("fill_stage_prompt",resultSet.getString("FILL_STAGE_PROMPT"));
				data.put("allocate_stage_prompt",resultSet.getString("ALLOCATE_STAGE_PROMPT"));
				data.put("bill_receipt_stage_prompt",resultSet.getString("BILL_RECEIPT_STAGE_PROMPT"));
				data.put("deliver_stage_prompt",resultSet.getString("DELIVER_STAGE_PROMPT"));
				data.put("deflt_freq_fr_tpn",resultSet.getString("APPL_FREQ_FOR_TPN"));
			    data.put("elapsed_period_of_orders_adr",resultSet.getString("ELAPSED_PRD_OF_ORD_FOR_ADR"));
    			data.put("iv_with_additives",resultSet.getString("IV_DRUG_FLUID_CONTINUOUS_LG"));
				data.put("iv_intermittent",resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_LG"));
				data.put("iv_without_additives",resultSet.getString("IV_WITHOUT_ADDITIVES_LG"));
				data.put("build_setup_log_yn",resultSet.getString("BUILD_SETUP_LOG_YN"));
				data.put("imageFilePath",resultSet.getString("ITEM_IMAGE_PATH"));
				data.put("print_alt_drug_dosage_qty_yn",resultSet.getString("PRINT_ALT_DRUG_DOSAGE_QTY_YN"));
				//data.put("drug_db_interact_check_yn",resultSet.getString("DRUG_DB_INTERACT_CHECK_YN"));
				 //data.put("drug_db_contraind_check_yn",resultSet.getString("DRUG_DB_CONTRAIND_CHECK_YN"));
                 //data.put("drug_db_allergy_check_yn",resultSet.getString("DRUG_DB_ALLERGY_CHECK_YN"));
                 data.put("issue_uom_by",resultSet.getString("ISSUE_UOM_BY"));
				 data.put("max_durn_for_dm_pres",resultSet.getString("MAX_DURN_FOR_DM_PRES"));
				 data.put("trade_display_yn",resultSet.getString("TRADE_DISPLAY_YN"));
				 data.put("max_length_prn_reason",resultSet.getString("MAX_LENGTH_PRN_REASON"));
				 data.put("first_trim_from",resultSet.getString("FRIST_TRIMSTER_START")); //added for  RUT-CRF-0063 [IN:029601] -start
				 data.put("first_trim_to",resultSet.getString("FRIST_TRIMSTER_END"));
				 data.put("second_trim_from",resultSet.getString("SECOND_TRIMSTER_START"));
				 data.put("second_trim_to",resultSet.getString("SECOND_TRIMSTER_END"));
				 data.put("third_trim_from",resultSet.getString("THIRD_TRIMSTER_START"));
				 data.put("third_trim_to",resultSet.getString("THIRD_TRIMSTER_END"));	
				 data.put("DISP_NO_PREG_DTL_YN",resultSet.getString("DISP_NO_PREG_DTL_YN")); //added for  RUT-CRF-0063 [IN:029601]-end
				 data.put("IV_CALC_INFUSE_BY",resultSet.getString("IV_CALC_INFUSE_BY")); //added for  SKR-CRF-0035 [IN:037747]
				 data.put("INFUSION_OVER_APP_YN",resultSet.getString("INFUSION_OVER_APP_YN").trim()); //added for  aakh-crf-0094
				 data.put("EPRESCRIPTION_CONTENT_YN",resultSet.getString("EPRESCRIPTION_CONTENT_YN"));  //added for MMS-DM-CRF-0169
              }
        }
		catch ( Exception e ) {
			if (data==null){
				data = new HashMap();
			}
            data.put("Exception",e);
            e.printStackTrace() ;
            throw e ;
        }
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace() ;
            }

        }
		return data;
    }

    public void setAll( Hashtable recordSet ) {

        if(recordSet.get("drug_item_code_link") != null)
            drug_item_code_link = (String)recordSet.get("drug_item_code_link") ;
        if(recordSet.get("drug_item_code_relation") != null)
            drug_item_code_relation = (String)recordSet.get("drug_item_code_relation") ;
        if(recordSet.get("gen_drug_code") != null)
            gen_drug_code = (String)recordSet.get("gen_drug_code") ;
        if(recordSet.get("drug_item_set_up") != null)
            drug_item_set_up = (String)recordSet.get("drug_item_set_up") ;
        if(recordSet.get("split_dose_freq") != null)
            split_dose_freq = (String)recordSet.get("split_dose_freq") ;
        if(recordSet.get("stat_dose_freq") != null)
            stat_dose_freq = (String)recordSet.get("stat_dose_freq");
        if(recordSet.get("route_transfusion") != null)
            route_transfusion = (String)recordSet.get("route_transfusion") ;
		//added on 25/04/2004 for drug searched by
		 if(recordSet.get("medn_order_by") != null)
            medn_order_by = (String)recordSet.get("medn_order_by") ;
		//ended here
		
		//added on 17/11/2004 for default frequency for tpn
		if(recordSet.get("deflt_freq_fr_tpn") != null)
            deflt_freq_fr_tpn = (String)recordSet.get("deflt_freq_fr_tpn") ;

        if(recordSet.get("max_pres_duration") != null)
            max_pres_duration = (String)recordSet.get("max_pres_duration") ;
        if(recordSet.get("allow_refill") != null)
            allow_refill = (String)recordSet.get("allow_refill") ;
        if(recordSet.get("refill_allowed") != null)
            refill_allowed = (String)recordSet.get("refill_allowed") ;
        if(recordSet.get("refill_prescription") != null)
            refill_prescription = (String)recordSet.get("refill_prescription") ;
        if(recordSet.get("print_refill") != null)
            print_refill = (String)recordSet.get("print_refill") ;
        if(recordSet.get("prescription_duration") != null)
            prescription_duration = (String)recordSet.get("prescription_duration") ;
		if(recordSet.get("disp_alt_form_yn") != null)
            disp_alt_form_yn = (String)recordSet.get("disp_alt_form_yn") ;

		if(recordSet.get("issue_uom_by") != null)
            issue_uom_by = (String)recordSet.get("issue_uom_by") ;

		if(recordSet.get("max_durn_for_dm_pres")!=null)
		   max_durn_for_dm_pres=(String)recordSet.get("max_durn_for_dm_pres");

		if(recordSet.get("print_alt_drug_dosage_qty_yn") != null)
            print_alt_drug_dosage_qty_yn = (String)recordSet.get("print_alt_drug_dosage_qty_yn") ;
		if(recordSet.get("allow_sel_by_atc_yn") != null)
            allow_sel_by_atc_yn = (String)recordSet.get("allow_sel_by_atc_yn") ;
        if(recordSet.get("dispense_value_strength") != null)
            dispense_value_strength = (String)recordSet.get("dispense_value_strength") ;
        if(recordSet.get("allow_dispense") != null)
            allow_dispense = (String)recordSet.get("allow_dispense") ;
        if(recordSet.get("no_days_ahead") != null)
            no_days_ahead = (String)recordSet.get("no_days_ahead") ;
        if(recordSet.get("allow_past_dispense") != null)
            allow_past_dispense = (String)recordSet.get("allow_past_dispense") ;
        if(recordSet.get("upto_days") != null)
            upto_days = (String)recordSet.get("upto_days") ;

        if(recordSet.get("drug_db_interface_yn") != null)
            drug_db_interface_yn = (String)recordSet.get("drug_db_interface_yn") ;
		
		/*
		if(recordSet.get("drug_db_interface_name") != null)
            drug_db_interface_name = (String)recordSet.get("drug_db_interface_name") ;
		if(recordSet.get("drug_db_dosecheck_yn") != null)
           drug_db_dosecheck_yn = (String)recordSet.get("drug_db_dosecheck_yn") ;
		if(recordSet.get("drug_db_duptherapy_yn") != null)
            drug_db_duptherapy_yn = (String)recordSet.get("drug_db_duptherapy_yn") ;
    	if(recordSet.get("drug_db_interaction_yn") != null)
         drug_db_interaction_yn = (String)recordSet.get("drug_db_interaction_yn") ;
		if(recordSet.get("drug_db_contracheck_yn") != null)
          drug_db_contracheck_yn = (String)recordSet.get("drug_db_contracheck_yn") ;
		if(recordSet.get("drug_db_alergycheck_yn") != null)
          drug_db_alergycheck_yn = (String)recordSet.get("drug_db_alergycheck_yn") ;  
        */
  
		if(recordSet.get("regn_stage_prompt") != null)
           regn_stage_prompt = (String)recordSet.get("regn_stage_prompt") ;
		if(recordSet.get("verify_stage_prompt") != null)
           verify_stage_prompt = (String)recordSet.get("verify_stage_prompt") ;
		if(recordSet.get("fill_stage_prompt") != null)
           fill_stage_prompt = (String)recordSet.get("fill_stage_prompt") ;
		if(recordSet.get("allocate_stage_prompt") != null)
           allocate_stage_prompt = (String)recordSet.get("allocate_stage_prompt") ;
		if(recordSet.get("bill_receipt_stage_prompt") != null)
           bill_receipt_stage_prompt = (String)recordSet.get("bill_receipt_stage_prompt") ;
		if(recordSet.get("deliver_stage_prompt") != null)
           deliver_stage_prompt = (String)recordSet.get("deliver_stage_prompt") ;
		if(recordSet.get("deflt_freq_fr_tpn") != null)
           deflt_freq_fr_tpn = (String)recordSet.get("deflt_freq_fr_tpn") ;
		if(recordSet.get("elapsed_period_of_orders_adr") != null)
		elapsed_period_of_orders_adr=(String)recordSet.get("elapsed_period_of_orders_adr") ;
		
		if(recordSet.get("iv_with_additives") != null)
           iv_with_additives = (String)recordSet.get("iv_with_additives") ;
		if(recordSet.get("iv_intermittent") != null)
           iv_intermittent = (String)recordSet.get("iv_intermittent") ;
		if(recordSet.get("iv_without_additives") != null)
           iv_without_additives = (String)recordSet.get("iv_without_additives") ;
		if(recordSet.get("audit_log_yn") != null)
           build_setup_log_yn = ((String)recordSet.get("audit_log_yn")).equals("")?"N":(String)recordSet.get("audit_log_yn") ;
		else
			build_setup_log_yn="N";
		if(recordSet.get("imageFilePath") != null)
           imageFilePath = (String)recordSet.get("imageFilePath");
		else
			imageFilePath = "";
		if(recordSet.get("display_trade_name") != null)
            trade_display_yn = (String)recordSet.get("display_trade_name") ;

		if(recordSet.get("mode") != null)
             mode = (String)recordSet.get("mode") ; 
		
		if(recordSet.get("max_length_for_prn_remarks")!=null)
			max_length_prn_remarks = (String)recordSet.get("max_length_for_prn_remarks");
		if(recordSet.get("first_trimster_from")!=null) //added for  RUT-CRF-0063 [IN:029601] -start
			first_trimster_from = (String)recordSet.get("first_trimster_from");
		if(recordSet.get("first_trimster_to")!=null)
			first_trimster_to = (String)recordSet.get("first_trimster_to");
		if(recordSet.get("second_trimster_from")!=null)
			second_trimster_from = (String)recordSet.get("second_trimster_from");
		if(recordSet.get("second_trimster_to")!=null)
			second_trimster_to = (String)recordSet.get("second_trimster_to");
		if(recordSet.get("third_trimster_from")!=null)
			third_trimster_from = (String)recordSet.get("third_trimster_from");
		if(recordSet.get("third_trimster_to")!=null)
			third_trimster_to = (String)recordSet.get("third_trimster_to"); 
		if(recordSet.get("Preg_record_yn")!=null)
			preg_record_yn = (String)recordSet.get("Preg_record_yn");//added for  RUT-CRF-0063 [IN:029601] -end
		if(recordSet.get("iv_calc_infuse_by")!=null)
			iv_calc_infuse_by = (String)recordSet.get("iv_calc_infuse_by");//added for  RUT-CRF-0063 [IN:029601] -end
		if(recordSet.get("infusion_over_app_yn")!=null)//added for  AAKH-CRF-0094
			infusion_over_yn = (String)recordSet.get("infusion_over_app_yn");//end 
		if(recordSet.get("eprescription_content_yn")!=null )       //start of MMS-DM-CRF-0619
		    eprescription_content_yn = (String)recordSet.get("eprescription_content_yn");
		if (eprescription_content_yn == null || eprescription_content_yn.equals("")){
				eprescription_content_yn  = "N";
            }
        					//End of MMS-DM-CRF-0619
      }

    public HashMap validate() throws Exception {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map ;
    }

    public HashMap insert() {
        HashMap map = new HashMap() ;
        String test=drug_item_code_link+" : "+drug_item_code_relation+" : "+gen_drug_code+" : "+drug_item_set_up+" :  "+split_dose_freq+" : "+stat_dose_freq+" : "+route_transfusion+" :"+medn_order_by+" : "+max_pres_duration+" : "+allow_refill+" : "+refill_allowed+" : "+print_refill+" : "+refill_prescription+" : "+prescription_duration+" : "+alternate_drug_selection+" : "+dispense_value_strength+" : : "+allow_dispense+" : "+no_days_ahead+" : "+allow_past_dispense+" : "+upto_days+" : "+deflt_freq_fr_tpn;
		map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "success" ) ;
        ArrayList insertData = new ArrayList() ;
        try{
            insertData.add( "PH" ) ;
            insertData.add( drug_item_code_link.trim() ) ;
            insertData.add( drug_item_code_relation.trim() ) ;
            insertData.add( gen_drug_code.trim() ) ;
            insertData.add( drug_item_set_up.trim()) ;
            insertData.add( split_dose_freq.trim() ) ;
            insertData.add( stat_dose_freq.trim() ) ;
            insertData.add( route_transfusion.trim() ) ;
			//added on 25/04/2004 for drug searched by
			insertData.add( medn_order_by.trim());
			
			//ended here
            insertData.add( new Integer(max_pres_duration.trim() )) ;

            if(!allow_refill.equals(""))
                insertData.add( allow_refill.trim()) ;
            else
                insertData.add( "N" ) ;

            if(!refill_allowed.equals(""))
                insertData.add( new Integer(refill_allowed.trim() )) ;
            else
                insertData.add(new Integer(0)) ;


            if(!print_refill.equals(""))
                insertData.add( print_refill.trim() ) ;
            else
                insertData.add( "N" ) ;

            if(!refill_prescription.equals(""))
                insertData.add( new Integer(refill_prescription.trim()) ) ;
            else
                insertData.add(new Integer(0)) ;

			 if(!prescription_duration.equals(""))
               insertData.add( new Integer(prescription_duration.trim()) ) ;
            else
                insertData.add(new Integer(0)) ;

			if(disp_alt_form_yn.equals("")){
				 disp_alt_form_yn="N";
			}
			if(print_alt_drug_dosage_qty_yn.equals("")){
				 print_alt_drug_dosage_qty_yn="Y";
			}

			//else
              //  disp_alt_form_yn="N";

			//commented FOR GHL-CRF-0548 start
			/*if(disp_alt_form_yn!=null && disp_alt_form_yn.equals("Y")){
			    insertData.add( "Y" ) ;
			}
			else{
			if(!dispense_value_strength.equals(""))
                insertData.add( dispense_value_strength.trim() ) ;
            else
                insertData.add( "N" ) ;			
			
			}*/
			//commented FOR GHL-CRF-0548 end 
			//ADDED FOR GHL-CRF-0548 start
			if(disp_alt_form_yn!=null && disp_alt_form_yn.equals("Y")){
				insertData.add( dispense_value_strength.trim() ) ;
			}
			else{
			 insertData.add( "M" ) ;		
			}
			//ADDED FOR GHL-CRF-0548 end
            if(!allow_dispense.equals(""))
                insertData.add( allow_dispense.trim() ) ;
            else
                insertData.add( "N" ) ;

            if(!no_days_ahead.equals(""))
                insertData.add( new Integer(no_days_ahead.trim()) ) ;
            else
                insertData.add(new Integer(0)) ;

            if(!allow_past_dispense.equals(""))
                insertData.add( allow_past_dispense.trim() ) ;
            else
                insertData.add( "N" ) ;

            if(!upto_days.equals(""))
                insertData.add( new Integer(upto_days.trim()) ) ;
            else
                insertData.add(new Integer(0)) ;

            insertData.add( login_by_id.trim() ) ;
            insertData.add( login_at_ws_no.trim() ) ;
            insertData.add( login_facility_id.trim() ) ;
            insertData.add( login_by_id.trim() ) ;
            insertData.add( login_at_ws_no.trim() ) ;
            insertData.add( login_facility_id.trim() ) ;
			if(!allow_sel_by_atc_yn.equals(""))
                insertData.add( allow_sel_by_atc_yn.trim() ) ;
            else
                insertData.add( "N" ) ;
			
			if(!disp_alt_form_yn.equals(""))
                insertData.add( disp_alt_form_yn.trim() ) ;
            else
                insertData.add( "N" ) ;


			if(!drug_db_interface_yn.equals(""))
                insertData.add( drug_db_interface_yn.trim() ) ;
            else
                insertData.add( "N" ) ;

            //insertData.add( drug_db_interface_name.trim() ) ;
           
			//if(!drug_db_dosecheck_yn.equals(""))
               // insertData.add( drug_db_dosecheck_yn.trim() ) ;
           // else
             //   insertData.add( "N" ) ;

		//	if(!drug_db_duptherapy_yn.equals(""))
              //  insertData.add( drug_db_duptherapy_yn.trim() ) ;
            //else
              //  insertData.add( "N" ) ;

			
			if(regn_stage_prompt==null || regn_stage_prompt.equals("")){
				regn_stage_prompt	="Registration"; 
			}
			if(verify_stage_prompt==null || verify_stage_prompt.equals("")){
				verify_stage_prompt	="Verification"; 
			}
			if(fill_stage_prompt==null || fill_stage_prompt.equals("")){
				fill_stage_prompt	="Fill"; 
			}
			if(allocate_stage_prompt==null || allocate_stage_prompt.equals("")){
				allocate_stage_prompt="Allocate"; 
			}
			if(bill_receipt_stage_prompt==null || bill_receipt_stage_prompt.equals("")){
				bill_receipt_stage_prompt="Bill/Receipt"; 
			}
			if(deliver_stage_prompt==null || deliver_stage_prompt.equals("")){
				deliver_stage_prompt	="Deliver"; 
			}

			if(deflt_freq_fr_tpn==null || deflt_freq_fr_tpn.equals("")){
				deflt_freq_fr_tpn	=" "; 
			}
			//added by uthra for IV 
			if(iv_with_additives==null || iv_with_additives.equals("")){
				iv_with_additives	="IV With Additives"; 
			}
			if(iv_intermittent==null || iv_intermittent.equals("")){
				iv_intermittent	="IV Intermittent"; 
			}
			if(iv_without_additives==null || iv_without_additives.equals("")){
				iv_without_additives	="IV Without Additives"; 
			}
			if(preg_record_yn==null || preg_record_yn.equals("")){
				preg_record_yn	="N"; 
			}
			if(iv_calc_infuse_by==null || iv_calc_infuse_by.equals("")){
				iv_calc_infuse_by	="D"; 
			}
			if(infusion_over_yn==null || infusion_over_yn.equals("")){
				infusion_over_yn	="N"; 
			}//end

			insertData.add( regn_stage_prompt.trim() ) ;
			insertData.add( verify_stage_prompt.trim() ) ;
			insertData.add( fill_stage_prompt.trim() ) ;
			insertData.add( allocate_stage_prompt.trim() ) ;
			insertData.add( bill_receipt_stage_prompt.trim() ) ;
			insertData.add( deliver_stage_prompt.trim() ) ;
			insertData.add( deflt_freq_fr_tpn.trim() ) ;
			//added on 20/12/2004 for drug searched by
			insertData.add( elapsed_period_of_orders_adr.trim());
			//added by uthra for IV
			insertData.add( iv_with_additives.trim() ) ;
			insertData.add( iv_intermittent.trim() ) ;
			insertData.add( iv_without_additives.trim() ) ;
			insertData.add( build_setup_log_yn.trim() ) ;
			insertData.add( imageFilePath.trim() ) ;

			if(!print_alt_drug_dosage_qty_yn.equals(""))
                insertData.add( print_alt_drug_dosage_qty_yn.trim() ) ;
            else
                insertData.add( "N" ) ;
			if(!issue_uom_by.equals(""))
                insertData.add( issue_uom_by.trim() ) ;
            else
                insertData.add( "D" ) ;
			insertData.add(max_durn_for_dm_pres.trim());

			 if(!trade_display_yn.equals(""))
                insertData.add( trade_display_yn.trim()) ;
            else
                insertData.add( "N" ) ;

			insertData.add(max_length_prn_remarks.trim());
			insertData.add(first_trimster_from.trim());	//added for  RUT-CRF-0063 [IN:029601] -start
			insertData.add(first_trimster_to.trim());
			insertData.add(second_trimster_from.trim());
			insertData.add(second_trimster_to.trim());
			insertData.add(third_trimster_from.trim());
			insertData.add(third_trimster_to.trim());	
			insertData.add(preg_record_yn.trim());	// RUT-CRF-0063 [IN:029601] -end
			insertData.add(iv_calc_infuse_by.trim());	// SKR-CRF-0035 [IN:037747] -end
			insertData.add(infusion_over_yn.trim());//added for aakh-crf-0094
			insertData.add(eprescription_content_yn.trim());   //added for MMS-DM-CRF-0619

            // if(!drug_db_interaction_yn.equals(""))
               // insertData.add( drug_db_interaction_yn.trim() ) ;
           // else
              //  insertData.add( "N" ) ;

			//if(!drug_db_contracheck_yn.equals(""))
            //    insertData.add( drug_db_contracheck_yn.trim() ) ;
            //else
               // insertData.add( "N" ) ;

			//if(!drug_db_alergycheck_yn.equals(""))
               // insertData.add( drug_db_alergycheck_yn.trim() ) ;
            //else
              //  insertData.add( "N" ) ;

			

			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "InsertData",insertData);
			
            HashMap sqlMap = new HashMap() ;
           
			/*String str = "INSERT INTO PH_PARAM(MODULE_ID, DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING, DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES,  DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN, REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT, DELIVER_STAGE_PROMPT,APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN,ITEM_IMAGE_PATH,PRINT_ALT_DRUG_DOSAGE_QTY_YN,ISSUE_UOM_BY,MAX_DURN_FOR_DM_PRES,TRADE_DISPLAY_YN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
			
		//	sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_PARAM_INSERT") );
			//sqlMap.put( "InsertSQL", "INSERT INTO PH_PARAM(MODULE_ID, DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING, DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES,  DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN, REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT, DELIVER_STAGE_PROMPT,APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN,ITEM_IMAGE_PATH,PRINT_ALT_DRUG_DOSAGE_QTY_YN,ISSUE_UOM_BY,MAX_DURN_FOR_DM_PRES,TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,FIRST_TRIMSTER_START,FIRST_TRIMSTER_END,SECOND_TRIMSTER_START,SECOND_TRIMSTER_END,THIRD_TRIMSTER_START,THIRD_TRIMSTER_END,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY,INFUSION_OVER_APP_YN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );//INFUSION_OVER_APP_YN added for AAKH-CRF-0094
			sqlMap.put( "InsertSQL", "INSERT INTO PH_PARAM(MODULE_ID, DRUG_ITEM_CODE_LINK_REQD_YN, DRUG_AND_ITEM_CODE_SAME_IND, DRUG_CODE_GEN_RULE, DRUG_TO_ITEM_MAPPING, DFLT_SPLIT_DOSE_FREQ_CODE, DFLT_STAT_DOSE_FREQ_CODE, DFLT_IV_ROUTE_CODE, MEDN_ORDER_BY, MAX_DURN_FOR_OP_PRES, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, MAX_DURN_FOR_IP_PRES,  DISP_MULTI_STRENGTH_YN, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ALLOW_SEL_BY_ATC_YN,DISP_ALT_FORM_YN,DRUG_DB_INTERFACE_YN, REGN_STAGE_PROMPT, VERIFY_STAGE_PROMPT, FILL_STAGE_PROMPT, ALLOCATE_STAGE_PROMPT, BILL_RECEIPT_STAGE_PROMPT, DELIVER_STAGE_PROMPT,APPL_FREQ_FOR_TPN,ELAPSED_PRD_OF_ORD_FOR_ADR,IV_DRUG_FLUID_CONTINUOUS_LG,IV_DRUG_FLUID_INTERMITTENT_LG,IV_WITHOUT_ADDITIVES_LG, BUILD_SETUP_LOG_YN,ITEM_IMAGE_PATH,PRINT_ALT_DRUG_DOSAGE_QTY_YN,ISSUE_UOM_BY,MAX_DURN_FOR_DM_PRES,TRADE_DISPLAY_YN,MAX_LENGTH_PRN_REASON,FIRST_TRIMSTER_START,FIRST_TRIMSTER_END,SECOND_TRIMSTER_START,SECOND_TRIMSTER_END,THIRD_TRIMSTER_START,THIRD_TRIMSTER_END,DISP_NO_PREG_DTL_YN, IV_CALC_INFUSE_BY,INFUSION_OVER_APP_YN,EPRESCRIPTION_CONTENT_YN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );//INFUSION_OVER_APP_YN added for AAKH-CRF-0094//EPRESCRIPTION_CONTENT_YN---added for mms-dm-crf-0619
    
		   //sqlMap.put( "InsertSQL", str );

            //SingleTableHandlerHome home = null;
            //SingleTableHandlerRemote remote = null;
            try {
                /*InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
                map = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


                if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

                else{
                    if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
                        map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
                    else
                        map.put( "message", (map.get("msgid"))) ;
                }
            }
            catch(Exception e) {
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
        map.put( "flag", test) ;
        return map ;
	}//insert ends

	public HashMap modify() {


        HashMap map = new HashMap() ;
//        String test=drug_item_code_link+" : "+drug_item_code_relation+" : "+gen_drug_code+" : "+drug_item_set_up+" :  "+split_dose_freq+" : "+stat_dose_freq+" : "+route_transfusion+" :"+medn_order_by+" : "+max_pres_duration+" : "+allow_refill+" : "+refill_allowed+" : "+print_refill+" : "+refill_prescription+" : "+prescription_duration+" : "+alternate_drug_selection+" : "+dispense_value_strength+" :  : "+allow_dispense+" : "+no_days_ahead+" : "+allow_past_dispense+" : "+upto_days+" : "+deflt_freq_fr_tpn;

        map.put( "flag", "test") ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "under Construction.." ) ;
        ArrayList modifyData = new ArrayList() ;
        try{
            modifyData.add( drug_item_code_link.trim() ) ;
            modifyData.add( drug_item_code_relation.trim() ) ;
            modifyData.add( gen_drug_code.trim() ) ;
            modifyData.add( drug_item_set_up.trim()) ;
            modifyData.add( split_dose_freq.trim() ) ;
            modifyData.add( stat_dose_freq.trim() ) ;
            modifyData.add( route_transfusion.trim() ) ;
			modifyData.add( medn_order_by.trim());
			modifyData.add( new Integer(max_pres_duration.trim() )) ;

            if(!allow_refill.equals(""))
                modifyData.add( allow_refill.trim()) ;
            else
                modifyData.add( "N" ) ;

            if(!refill_allowed.equals(""))
                modifyData.add( new Integer(refill_allowed.trim() )) ;
            else
                modifyData.add(new Integer(0)) ;
  

            if(!print_refill.equals(""))
                modifyData.add( print_refill.trim() ) ;
            else
                modifyData.add( "N" ) ;

            if(!refill_prescription.equals(""))
                modifyData.add( new Integer(refill_prescription.trim()) ) ;
            else
                modifyData.add(new Integer(0)) ;
			if(!prescription_duration.equals(""))
                modifyData.add( new Integer(prescription_duration.trim()) ) ;
            else
                modifyData.add(new Integer(0)) ;

           

			if(!dispense_value_strength.equals(""))
                modifyData.add( dispense_value_strength.trim() ) ;
            else
                modifyData.add( "N" ) ;
			
            if(!allow_dispense.equals(""))
                modifyData.add( allow_dispense.trim() ) ;
            else
                modifyData.add( "N" ) ;

            if(!no_days_ahead.equals(""))
                modifyData.add( new Integer(no_days_ahead.trim()) ) ;
            else
                modifyData.add(new Integer(0)) ;

            if(!allow_past_dispense.equals(""))
                modifyData.add( allow_past_dispense.trim() ) ;
            else
                modifyData.add( "N" ) ;

            if(!upto_days.equals(""))
                modifyData.add( new Integer(upto_days.trim()) ) ;
            else
                modifyData.add(new Integer(0)) ;
			
			if(!allow_sel_by_atc_yn.equals(""))
                modifyData.add( allow_sel_by_atc_yn.trim() ) ;
            else
                modifyData.add( "N" ) ;
			
			if(!disp_alt_form_yn.equals(""))
                modifyData.add( disp_alt_form_yn.trim() ) ;
            else
                modifyData.add( "N" ) ;

			if(preg_record_yn==null || preg_record_yn.equals("")){
				preg_record_yn	="N"; 
			}

			if(iv_calc_infuse_by==null || iv_calc_infuse_by.equals("")){
				iv_calc_infuse_by	="D"; 
			}
			//added for aakh-crf-0094
			if(infusion_over_yn==null || infusion_over_yn.equals("")){
				infusion_over_yn	="N"; 
			}//end

            modifyData.add( login_by_id.trim() ) ;
            modifyData.add( login_at_ws_no.trim() ) ;
            modifyData.add( login_facility_id.trim() ) ;

			if(!drug_db_interface_yn.equals(""))
                modifyData.add( drug_db_interface_yn.trim() ) ;
            else
                modifyData.add( "N" ) ;

           // modifyData.add( drug_db_interface_name.trim() ) ;
           
			//if(!drug_db_dosecheck_yn.equals(""))
              //  modifyData.add( drug_db_dosecheck_yn.trim() ) ;
          //  else
              //  modifyData.add( "N" ) ;

		//	if(!drug_db_duptherapy_yn.equals(""))
               // modifyData.add( drug_db_duptherapy_yn.trim() ) ;
           // else
           //     modifyData.add( "N" ) ;

			
			if(regn_stage_prompt==null || regn_stage_prompt.equals("")){
				regn_stage_prompt	="Registration"; 
			}
			if(verify_stage_prompt==null || verify_stage_prompt.equals("")){
				verify_stage_prompt	="Verification"; 
			}
			if(fill_stage_prompt==null || fill_stage_prompt.equals("")){
				fill_stage_prompt	="Fill"; 
			}
			if(allocate_stage_prompt==null || allocate_stage_prompt.equals("")){
				allocate_stage_prompt="Allocate"; 
			}
			if(bill_receipt_stage_prompt==null || bill_receipt_stage_prompt.equals("")){
				bill_receipt_stage_prompt="Bill/Receipt"; 
			}
			if(deliver_stage_prompt==null || deliver_stage_prompt.equals("")){
				deliver_stage_prompt	="Deliver"; 
			}
			if(deflt_freq_fr_tpn==null || deflt_freq_fr_tpn.equals("")){
				deflt_freq_fr_tpn	=" "; 
			}

			if(iv_with_additives==null || iv_with_additives.equals("")){
				iv_with_additives	="IV With Additives"; 
			}
			if(iv_intermittent==null || iv_intermittent.equals("")){
				iv_intermittent	="IV Intermittent"; 
			}
			if(iv_without_additives==null || iv_without_additives.equals("")){
				iv_without_additives	="IV Without Additives"; 
			}

			modifyData.add( regn_stage_prompt.trim() ) ;
			modifyData.add( verify_stage_prompt.trim() ) ;
			modifyData.add( fill_stage_prompt.trim() ) ;
			modifyData.add( allocate_stage_prompt.trim() ) ;
			modifyData.add( bill_receipt_stage_prompt.trim() ) ;
			modifyData.add( deliver_stage_prompt.trim() ) ;
			modifyData.add( deflt_freq_fr_tpn.trim() ) ;
			modifyData.add( elapsed_period_of_orders_adr.trim());
			modifyData.add( iv_with_additives.trim() ) ;
			modifyData.add( iv_intermittent.trim() ) ;
			modifyData.add( iv_without_additives.trim() ) ;
			modifyData.add( build_setup_log_yn.trim() ) ;
			modifyData.add( imageFilePath.trim() ) ;
	
			if(!print_alt_drug_dosage_qty_yn.equals(""))
                modifyData.add( print_alt_drug_dosage_qty_yn.trim() ) ;
            else
                modifyData.add( "N" ) ;
			modifyData.add(issue_uom_by.trim()) ;

			modifyData.add(max_durn_for_dm_pres.trim());

			 if(!trade_display_yn.equals(""))
                modifyData.add( trade_display_yn.trim()) ;
            else
                modifyData.add( "N" ) ;
			
			modifyData.add(max_length_prn_remarks.trim());
			modifyData.add(first_trimster_from.trim());	//added for  RUT-CRF-0063 [IN:029601] -start
			modifyData.add(first_trimster_to.trim());
			modifyData.add(second_trimster_from.trim());
			modifyData.add(second_trimster_to.trim());
			modifyData.add(third_trimster_from.trim());
			modifyData.add(third_trimster_to.trim());	
			modifyData.add(preg_record_yn.trim());//added for  RUT-CRF-0063 [IN:029601]-end
			modifyData.add(iv_calc_infuse_by.trim());//added for  SKR-CRF-0035 [IN:037747]-end
			modifyData.add(infusion_over_yn.trim());//added for aakh-crf-0094
			modifyData.add(eprescription_content_yn.trim());   //added for MMS-DM-CRF-0619
			

         //  if(!drug_db_interaction_yn.equals(""))
             //   modifyData.add( drug_db_interaction_yn.trim() ) ;
           // else
             //   modifyData.add( "N" ) ;

			//if(!drug_db_contracheck_yn.equals(""))
               // modifyData.add( drug_db_contracheck_yn.trim() ) ;
           // else
            //    modifyData.add( "N" ) ;

			//if(!drug_db_alergycheck_yn.equals(""))
              //  modifyData.add( drug_db_alergycheck_yn.trim() ) ;
           // else
             //   modifyData.add( "N" ) ;

            HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",modifyData);
			//System.out.println("ModifyData"+modifyData);

            HashMap sqlMap = new HashMap() ;
       /*   String str="UPDATE PH_PARAM SET DRUG_ITEM_CODE_LINK_REQD_YN=?, DRUG_AND_ITEM_CODE_SAME_IND =?, DRUG_CODE_GEN_RULE = ?, DRUG_TO_ITEM_MAPPING =?, DFLT_SPLIT_DOSE_FREQ_CODE = ?, DFLT_STAT_DOSE_FREQ_CODE =?, DFLT_IV_ROUTE_CODE = ?, MEDN_ORDER_BY= ?, MAX_DURN_FOR_OP_PRES =?, REFILL_YN =?, MAX_REFILLS_FOR_PRES = ?, PRINT_REFILL_PRES_WITH_MAIN_YN = ?, MAX_DURN_FOR_REFILL_PRES = ?, MAX_DURN_FOR_IP_PRES = ?, DISP_MULTI_STRENGTH_YN = ?,  DISP_BEFORE_START_DATE_YN  = ?, DISP_BEFORE_NO_OF_DAYS = ?, DISP_BEYOND_EARLIEST_START_YN = ?, DISP_BEYOND_NO_OF_DAYS = ?,ALLOW_SEL_BY_ATC_YN=?,DISP_ALT_FORM_YN=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,DRUG_DB_INTERFACE_YN=?,REGN_STAGE_PROMPT=?, VERIFY_STAGE_PROMPT=?, FILL_STAGE_PROMPT=?, ALLOCATE_STAGE_PROMPT=?, BILL_RECEIPT_STAGE_PROMPT=?, DELIVER_STAGE_PROMPT=?, APPL_FREQ_FOR_TPN=? ,ELAPSED_PRD_OF_ORD_FOR_ADR=?,    IV_DRUG_FLUID_CONTINUOUS_LG =?,IV_DRUG_FLUID_INTERMITTENT_LG= ?,    IV_WITHOUT_ADDITIVES_LG= ?, BUILD_SETUP_LOG_YN=?,ITEM_IMAGE_PATH = ?,PRINT_ALT_DRUG_DOSAGE_QTY_YN=?, ISSUE_UOM_BY=?,MAX_DURN_FOR_DM_PRES=?,TRADE_DISPLAY_YN=? WHERE MODULE_ID='PH'";  */
           
			

		//	sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_PARAM_UPDATE") );
			//sqlMap.put( "ModifySQL","UPDATE PH_PARAM SET DRUG_ITEM_CODE_LINK_REQD_YN=?, DRUG_AND_ITEM_CODE_SAME_IND =?, DRUG_CODE_GEN_RULE = ?, DRUG_TO_ITEM_MAPPING =?, DFLT_SPLIT_DOSE_FREQ_CODE = ?, DFLT_STAT_DOSE_FREQ_CODE =?, DFLT_IV_ROUTE_CODE = ?, MEDN_ORDER_BY= ?, MAX_DURN_FOR_OP_PRES =?, REFILL_YN =?, MAX_REFILLS_FOR_PRES = ?, PRINT_REFILL_PRES_WITH_MAIN_YN = ?, MAX_DURN_FOR_REFILL_PRES = ?, MAX_DURN_FOR_IP_PRES = ?, DISP_MULTI_STRENGTH_YN = ?,  DISP_BEFORE_START_DATE_YN  = ?, DISP_BEFORE_NO_OF_DAYS = ?, DISP_BEYOND_EARLIEST_START_YN = ?, DISP_BEYOND_NO_OF_DAYS = ?,ALLOW_SEL_BY_ATC_YN=?,DISP_ALT_FORM_YN=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,DRUG_DB_INTERFACE_YN=?,REGN_STAGE_PROMPT=?, VERIFY_STAGE_PROMPT=?, FILL_STAGE_PROMPT=?, ALLOCATE_STAGE_PROMPT=?, BILL_RECEIPT_STAGE_PROMPT=?, DELIVER_STAGE_PROMPT=?, APPL_FREQ_FOR_TPN=? ,ELAPSED_PRD_OF_ORD_FOR_ADR=?,    IV_DRUG_FLUID_CONTINUOUS_LG =?,IV_DRUG_FLUID_INTERMITTENT_LG= ?,    IV_WITHOUT_ADDITIVES_LG= ?, BUILD_SETUP_LOG_YN=?,ITEM_IMAGE_PATH = ?,PRINT_ALT_DRUG_DOSAGE_QTY_YN=?, ISSUE_UOM_BY=?,MAX_DURN_FOR_DM_PRES=?,TRADE_DISPLAY_YN=?,MAX_LENGTH_PRN_REASON=?,FIRST_TRIMSTER_START=?,FIRST_TRIMSTER_END=?,SECOND_TRIMSTER_START=?,SECOND_TRIMSTER_END=?,THIRD_TRIMSTER_START=?,THIRD_TRIMSTER_END=?,DISP_NO_PREG_DTL_YN=?, IV_CALC_INFUSE_BY=?,INFUSION_OVER_APP_YN=? WHERE MODULE_ID='PH'" );//INFUSION_OVER_APP_YN added for AAKH-CRF-0094
			sqlMap.put( "ModifySQL","UPDATE PH_PARAM SET DRUG_ITEM_CODE_LINK_REQD_YN=?, DRUG_AND_ITEM_CODE_SAME_IND =?, DRUG_CODE_GEN_RULE = ?, DRUG_TO_ITEM_MAPPING =?, DFLT_SPLIT_DOSE_FREQ_CODE = ?, DFLT_STAT_DOSE_FREQ_CODE =?, DFLT_IV_ROUTE_CODE = ?, MEDN_ORDER_BY= ?, MAX_DURN_FOR_OP_PRES =?, REFILL_YN =?, MAX_REFILLS_FOR_PRES = ?, PRINT_REFILL_PRES_WITH_MAIN_YN = ?, MAX_DURN_FOR_REFILL_PRES = ?, MAX_DURN_FOR_IP_PRES = ?, DISP_MULTI_STRENGTH_YN = ?,  DISP_BEFORE_START_DATE_YN  = ?, DISP_BEFORE_NO_OF_DAYS = ?, DISP_BEYOND_EARLIEST_START_YN = ?, DISP_BEYOND_NO_OF_DAYS = ?,ALLOW_SEL_BY_ATC_YN=?,DISP_ALT_FORM_YN=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,DRUG_DB_INTERFACE_YN=?,REGN_STAGE_PROMPT=?, VERIFY_STAGE_PROMPT=?, FILL_STAGE_PROMPT=?, ALLOCATE_STAGE_PROMPT=?, BILL_RECEIPT_STAGE_PROMPT=?, DELIVER_STAGE_PROMPT=?, APPL_FREQ_FOR_TPN=? ,ELAPSED_PRD_OF_ORD_FOR_ADR=?,    IV_DRUG_FLUID_CONTINUOUS_LG =?,IV_DRUG_FLUID_INTERMITTENT_LG= ?,    IV_WITHOUT_ADDITIVES_LG= ?, BUILD_SETUP_LOG_YN=?,ITEM_IMAGE_PATH = ?,PRINT_ALT_DRUG_DOSAGE_QTY_YN=?, ISSUE_UOM_BY=?,MAX_DURN_FOR_DM_PRES=?,TRADE_DISPLAY_YN=?,MAX_LENGTH_PRN_REASON=?,FIRST_TRIMSTER_START=?,FIRST_TRIMSTER_END=?,SECOND_TRIMSTER_START=?,SECOND_TRIMSTER_END=?,THIRD_TRIMSTER_START=?,THIRD_TRIMSTER_END=?,DISP_NO_PREG_DTL_YN=?, IV_CALC_INFUSE_BY=?,INFUSION_OVER_APP_YN=?,EPRESCRIPTION_CONTENT_YN=? WHERE MODULE_ID='PH'" );//INFUSION_OVER_APP_YN added for AAKH-CRF-0094 //EPRESCRIPTION_CONTENT_YN--added for mms-dm-crf-0169
		   //sqlMap.put( "ModifySQL", str );

            //SingleTableHandlerHome home = null;
           // SingleTableHandlerRemote remote = null;
            try {
                /*InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
                map = remote.modify( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


                if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

                else{
                    map.put( "message", (map.get("msgid"))) ;
                }
            }
            catch(Exception e) {
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
         return map ;
}//modify ends

public HashMap delete() {
         HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "flag", "test" ) ;
        map.put( "message", "under Construction.." ) ;
        return map ;
}

    public void clear() {
              super.clear() ;
    }


    private void doCommon() throws Exception {

    }

    /* Function specific methods end */
} 
