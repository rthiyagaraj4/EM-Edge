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
3/2/2020	72190			shazana										SKR-SCF-1312
14/12/2020   IN8219         Prabha	 	   15/12/2020	Manickavasagam J   MMS-DM-CRF-0177
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
--------------------------------------------------------------------------------------------------------------------
*/
package ePH.DrugMaster ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ; 
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="DrugMaster"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DrugMaster"
*	local-jndi-name="DrugMaster"
*	impl-class-name="ePH.DrugMaster.DrugMasterManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DrugMaster.DrugMasterLocal"
*	remote-class="ePH.DrugMaster.DrugMasterRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DrugMaster.DrugMasterLocalHome"
*	remote-class="ePH.DrugMaster.DrugMasterHome"
*	generate= "local,remote"
*
*
*/

public class DrugMasterManager extends PhEJBSessionAdapter {
	//Properties  prop							=	null;
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		StringBuffer messages = new StringBuffer() ;
		String	restricted_yn	=	"";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection						=	null ;
		PreparedStatement pstmt_insert				=	null ;
		PreparedStatement pstmt_delete				=	null ;
		Properties  prop							=	null;
		try {
							
			prop= (Properties)tabData.get( "properties" );
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			ArrayList drugmastermain	= (ArrayList) tabData.get("drugmastermain");
			ArrayList characteristics	= (ArrayList) tabData.get("characteristics");

			ArrayList prescribing_det	= (ArrayList) tabData.get("prescribing_det");
			ArrayList iv_char			= (ArrayList) tabData.get("iv_char");
			ArrayList dispensing		= (ArrayList) tabData.get("dispensing");
			//ArrayList inventory			= (ArrayList) tabData.get("inventory");
			ArrayList trade				= (ArrayList) tabData.get("trade");
			ArrayList generic			= (ArrayList) tabData.get("generic");
			ArrayList external_db		= (ArrayList) tabData.get("external_db");
			ArrayList Comp_Fluids		= (ArrayList) tabData.get("Comp_Fluids");
			ArrayList agegroup				= (ArrayList) tabData.get("ageGroup");
			ArrayList sliding_scale_chkd_values	=	(ArrayList) tabData.get("sliding_scale_chkd_values");
			String desc = (String) tabData.get("longDesc");//added for SKR-SCF-1312 
			ArrayList  supportive_drugs = (ArrayList) tabData.get("supportive");//Added for TH-KW-CRF-0007

			String sql_ph_drug_insert						= (String) sqlMap.get( "SQL_PH_DRUG_INSERT");
			//String sql_ph_inventory_item_for_drug_insert	= (String) sqlMap.get( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT");
			String sql_ph_generic_name_for_drug_insert		= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT");
			String sql_ph_trade_name_for_drug_insert		= (String) sqlMap.get( "SQL_PH_TRADE_NAME_FOR_DRUG_INSERT");
			String sql_ph_ext_drug_insert					= (String) sqlMap.get("SQL_PH_EXT_DRUG_INSERT");
			String sql_ph_comp_fluids_insert				= (String) sqlMap.get("SQL_PH_COMP_FLUIDS_DRUG_INSERT");
			String sql_ph_age_group_for_drug_insert			= (String) sqlMap.get("SQL_PH_AGE_GROUP_FOR_DRUG_INSERT");
		//	String sql_ph_drug_sliding_scale_tmpl_delete	=	(String) sqlMap.get("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE");
			String sql_ph_drug_sliding_scale_tmpl_delete1	=	(String) sqlMap.get("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1");
			String sql_ph_drug_sliding_scale_tmpl_insert	=	(String) sqlMap.get("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT");
			String sql_ph_supportive_drugs_insert           =    (String) sqlMap.get("SQL_PH_SUPPORTIVE_DRUGS_INSERT");//Added for TH-KW-CRF-0007
			String reissue_type_ind							= "";//Added for Bru-HIMS-CRF-405[IN 044830]-Start
			reissue_type_ind								= (String)dispensing.get(20);
			 if(reissue_type_ind.equals(""))
				 reissue_type_ind="N";//Added for Bru-HIMS-CRF-405[IN 044830]-End
			connection = getConnection(prop) ;
			connection.setAutoCommit( false ) ;
			String strength						=	"";
			float strength_per_value_pres_uom	=	0.0f;
			float	content_per_pres_uom			=	0.0f; 
			int prn_doses_pres_prd_fill			=	0; 
			int prn_doses_cont_daily_fill		=	0; 
			double infuse_over_value				=	0.0; 
			double deflt_fluid_infuse_over_value				=	0.0; //Added for ML-MMOH-CRF-1223
			//int base_uom						=	0;
			//float strength_uom					=	0.0f;

			//first insert
			pstmt_insert			=	connection.prepareStatement( sql_ph_drug_insert ) ;
			
			//from main form - DRUG_CODE, DRUG_DESC, IN_FORMULARY_YN, LINK_TO_EXISTING_ITEM, ITEM_CODE, GENERIC_ID,DRUG_CLASS, COMPOUND_DRUG_YN, FORM_CODE, ROUTE_CODE,
			int fld=0;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(0) ) ;
			pstmt_insert.setString( ++fld, desc ) ; //MODIFIED FOR SKR-SCF-1312
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(2) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(3) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(4) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(5) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(6) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(7) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(8) ) ;
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(9) ) ;
			
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(11) ) ; //DEFAULT_ROUTE_YN Code Added For RUT-CRF-0034
			
			//from charateristics - DRUG_TYPE, SCHEDULE_ID, RESTRICTED_DRUG_YN, TRIAL_DRUG, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS, APPL_TO_TDM_YN,APPL_TO_VERBAL_ORDER_YN 
			String drug_type="";
			if( ((String) characteristics.get(0)==null) || (((String)characteristics.get(0)).equals("")))
				drug_type	=	"X";
			else
				drug_type	=	(String) characteristics.get(0);
			pstmt_insert.setString( ++fld, drug_type					 ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(1) ) ;

			if( (String) characteristics.get(2)==null || ((String)characteristics.get(2)).equals(""))
				restricted_yn	=	"N";
			else
				restricted_yn	=	(String) characteristics.get(2);

			pstmt_insert.setString( ++fld, restricted_yn ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(3) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(4) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(5) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(6) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(7) ) ;
			if(((String) characteristics.get(8))!=null){
				pstmt_insert.setString( ++fld, (String) characteristics.get(8) ) ;
			}
			else{
				pstmt_insert.setString( ++fld, "" ) ;
			}
			
			if(((String) characteristics.get(9))!=null){
				pstmt_insert.setString( ++fld, (String) characteristics.get(9) ) ;
			}
			else{
				pstmt_insert.setString( ++fld, "" ) ;
			}

			//dispense
			//prescribing_det - PRES_BASE_UOM, CALC_DOSG_BY_FREQ_DURN_YN,STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE
			
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(0) ) ;
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(1) ) ;

			if(((String) prescribing_det.get(2))!=null)	{
				if( ((String) prescribing_det.get(2)).equals(""))
					strength	=	"0";
				else
					strength	=	(String) prescribing_det.get(2);
			}
			else{
				strength	=	"0"; 
			}
			pstmt_insert.setString( ++fld, strength ) ;
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(3) ) ;
			
			if( ((String) prescribing_det.get(4))!=null )		{
				pstmt_insert.setString( ++fld, (String) prescribing_det.get(4) ) ;
			}
			else {
				pstmt_insert.setString( ++fld, (String) prescribing_det.get(4) ) ;
			}

			if( ((String) prescribing_det.get(5))!=null )		{
				if( ((String) prescribing_det.get(5)).equals(""))
					strength_per_value_pres_uom	=	0;
				else
					strength_per_value_pres_uom	=	 Float.parseFloat((String) prescribing_det.get(5));
			}
			else{
				strength_per_value_pres_uom	=	0;
			}
			pstmt_insert.setFloat( ++fld, strength_per_value_pres_uom ) ;
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(6) ) ;
			
			//dispense -FRACT_DOSE_ROUND_UP_YN,STOCK_UOM,CONTENT_IN_PRES_BASE_UOM,CALC_DEF_DOSAGE_YN, DISP_ALT_FORM_YN, DISP_MULTI_STRENGTH_YN, PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT,

			pstmt_insert.setString( ++fld, (String) dispensing.get(0) ) ;
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(9) ) ;
			if(((String) prescribing_det.get(10))!=null){
				if( ((String) prescribing_det.get(10)).equals(""))	
					content_per_pres_uom	=	0.0f;
				else
					content_per_pres_uom	= Float.parseFloat((String) prescribing_det.get(10));
			}
			else{
				content_per_pres_uom	=	0.0f;
			}
			pstmt_insert.setFloat( ++fld, content_per_pres_uom ) ;
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(11) ) ;
		// ends here
			pstmt_insert.setString( ++fld, (String) dispensing.get(1) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(2) ) ;

			if(((String) dispensing.get(3))!=null)	{
				if( ((String) dispensing.get(3)).equals(""))	
					prn_doses_pres_prd_fill	=	0;
				else
					prn_doses_pres_prd_fill	= Integer.parseInt((String) dispensing.get(3));
			}
			else{
				prn_doses_pres_prd_fill	=	0;
			}
			pstmt_insert.setInt( ++fld, prn_doses_pres_prd_fill ) ;
		
			if(((String) dispensing.get(4))!=null)	{
				if( ((String) dispensing.get(4)).equals(""))	
					prn_doses_cont_daily_fill	=	0;
				else
					prn_doses_cont_daily_fill	= Integer.parseInt((String) dispensing.get(4));
			}
			else{
				prn_doses_cont_daily_fill	=	0;
			}
			pstmt_insert.setInt( ++fld, prn_doses_cont_daily_fill ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(5) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(6) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(7)) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(8)) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(9) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(10) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(11) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(12) ) ;
			//added by senthil kumar j on 15/4/2004
			//pstmt_insert.setString( ++fld, (String) dispensing.get(12) ) ;
			//ended...

			if(((String) dispensing.get(13))!=null){
				pstmt_insert.setString( ++fld, (String) dispensing.get(13) ) ;
			}
			else{
				pstmt_insert.setString( ++fld, "" ) ;
			}
			//iv char - IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE 

			pstmt_insert.setString( ++fld, (String) iv_char.get(0) ) ;
			pstmt_insert.setString( ++fld, (String) iv_char.get(1) ) ;
			
			if(((String) iv_char.get(2))!=null)	{
				if( ((String) iv_char.get(2)).equals(""))	
					infuse_over_value	=	0.0;
				else
					infuse_over_value	= Double.parseDouble((String) iv_char.get(2));
			}
			else	{
				infuse_over_value	=	0.0;
			}

			pstmt_insert.setDouble( ++fld, infuse_over_value ) ;
			pstmt_insert.setString( ++fld, (String) iv_char.get(3) ) ;

			//mandatory - ADDED_BY_ID, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID

			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(0) ) ;
			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(1) ) ;
			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(2) ) ;
			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(3) ) ;
			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(4) ) ;
			pstmt_insert.setString( ++fld, (String) mandatory_flds.get(5) ) ;
			String physical_form = "";

			if(iv_char.get(4)==null || iv_char.get(4) == ""){
				physical_form ="S";
			}
			else{
				physical_form =(String)iv_char.get(4);
			}

			pstmt_insert.setString( ++fld, physical_form) ;
			pstmt_insert.setString( ++fld, (String)iv_char.get(5)) ;
		//	pstmt_insert.setString( ++fld, (String)drugmastermain.get(0)) ;
			
			// Default fluid code for iv char	
			pstmt_insert.setString( ++fld, (String) iv_char.get(6) ) ;
			pstmt_insert.setString( ++fld, (String) iv_char.get(7) ) ;
			pstmt_insert.setString( ++fld, (String) iv_char.get(8) ) ;

			// characteristics -- appl tdm, verbal order appl during MAR
			pstmt_insert.setString( ++fld, (String) characteristics.get(10) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(11) ) ;

			pstmt_insert.setString( ++fld, (String) characteristics.get(12) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(13) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(14) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(15) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(16) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(17) ) ;
			pstmt_insert.setString( ++fld, (String) characteristics.get(18) ) ;
			pstmt_insert.setString( ++fld, (String) dispensing.get(14) ) ; //  FRACT_DOSE_APPL_YN
			pstmt_insert.setString( ++fld, (String) characteristics.get(19) ) ; //ITEM_IMAGE_FILENAME
			pstmt_insert.setString( ++fld, (String) dispensing.get(15) ) ;    //VERIFICATION_REQD_YN
			pstmt_insert.setString( ++fld, (String) characteristics.get(20) ) ;    //EDL_CODES
			pstmt_insert.setString( ++fld, (String) characteristics.get(21) ) ;    //EDL_REMARKS
			pstmt_insert.setString( ++fld, (String) characteristics.get(22) ) ;//Pregnancy Category Group Code
			pstmt_insert.setString( ++fld, (String) characteristics.get(23) ) ;//Pregnancy Category Code1
			pstmt_insert.setString( ++fld, (String) characteristics.get(24) ) ;//Pregnancy Category Code2
			pstmt_insert.setString( ++fld, (String) characteristics.get(25) ) ; //Pregnancy Category Code3 
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(10) ) ; //PROMT_ALERT_PREFERRED_DRUG

			//System.out.println("@@=====Before setString in insert========"+(String)dispensing.get(16));
			pstmt_insert.setString( ++fld, (String) dispensing.get(16) ) ; //ALLOW_MORETHAN_PRES_QTY_YN
		    pstmt_insert.setString( ++fld, (String) dispensing.get(17) ) ; //PRINT Label RUT-CRF-0067
		    pstmt_insert.setString( ++fld, (String) dispensing.get(18) ) ;// Added default_dosage_by For SKR-CRF-PHIS-003[IN028182]
			pstmt_insert.setString( ++fld, (String) characteristics.get(27) ) ;//code added for Bru-HIMS-CRF-070[IN029935]
			pstmt_insert.setString( ++fld, (String) dispensing.get(19)) ;//Added for Drug_Indication For ML-BRU-CRF-072[Inc:29938]
			pstmt_insert.setString( ++fld, (String) characteristics.get(28)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld, (String) characteristics.get(29)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld, (String) characteristics.get(30)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld, (String) characteristics.get(31)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld, (String) characteristics.get(32)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld, (String) characteristics.get(33)) ;//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_insert.setString( ++fld,  reissue_type_ind ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_insert.setString( ++fld, (String) dispensing.get(21) ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_insert.setString( ++fld, (String) dispensing.get(22) ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_insert.setString( ++fld, (String) prescribing_det.get(12) ) ;//parameter DEFAULT_DOSAGE_BY_YN Added for AAKH-CRF-089
			pstmt_insert.setString( ++fld, (String) characteristics.get(34) ) ;//added for ghl-crf-0482
			//System.out.println("@@=====After setString in insert========");
			pstmt_insert.setString( ++fld, (String) drugmastermain.get(12) ) ; //DRUG_SEARCH_BY INSERTED for MMS-DM-CRF-0177
			pstmt_insert.setString( ++fld, (String) characteristics.get(35) ) ;//Added for TH-KW-CRF-0008 DRUG_EXPIRY_ALERT_DAYS
			//System.out.println("@@=====After setString in insert========");
			
			pstmt_insert.setString( ++fld, (String) characteristics.get(36) ) ;//Added for KDAH-CRF-0610 REST_ANTI_JUSTFORM_YN
			pstmt_insert.setString( ++fld, (String) characteristics.get(37) ) ;//Added for KDAH-CRF-0610 REST_ANTI_JUSTFORM_DURATION

			int ph_drug_insert = pstmt_insert.executeUpdate() ;
			
			//messages.append("ph_drug_insert :"+ph_drug_insert) ;
			//messages.append("Insert Result:"+ph_drug_insert);
	//second stmt
			if(ph_drug_insert!=0){
				closeStatement(pstmt_insert);
		//		pstmt_insert=null;
			/*	pstmt_insert = connection.prepareStatement(sql_ph_inventory_item_for_drug_insert ) ;
				pstmt_insert.clearBatch();

				if(inventory!=null && inventory.size()>0){
				for (int i=0;i<inventory.size() ;i++ ){
					HashMap hh=new HashMap();
					hh=(HashMap) inventory.get(i);
					
					//messages.append("Values :"+(String)drugmastermain.get(0)+","	+(String)hh.get("item_code")+","					+(String)hh.get("stock_uom")+","					+(String)hh.get("base_uom")+","					+(String)hh.get("strength_uom")) ;

					if( ((String)hh.get("flag") !=null) && (((String)hh.get("flag")).equals("I"))){
					pstmt_insert.setString( 1, (String) drugmastermain.get(0));
					pstmt_insert.setString( 2, (String)hh.get("item_code") );
					pstmt_insert.setString( 3, (String)hh.get("stock_uom_code") );			
					if(((String)hh.get("base_uom"))!=null)	{
							if( ((String)hh.get("base_uom")).equals(""))	
								base_uom	=	0;
							else
								base_uom	= Integer.parseInt((String) (String)hh.get("base_uom"));
					}
					else{
						base_uom	=	0;
					}

					pstmt_insert.setInt( 4, base_uom );

					if(((String)prescribing_det.get(2))!=null)	{
							if( ((String)prescribing_det.get(2)).equals(""))	
								strength_uom	=	0;
							else
								strength_uom	= Float.parseFloat((String) prescribing_det.get(2));
					}
					else{
						strength_uom	=	0;
					}

					pstmt_insert.setFloat( 5, strength_uom );
					pstmt_insert.setString( 6, (String) mandatory_flds.get(0) ) ;
					pstmt_insert.setString( 7, (String) mandatory_flds.get(1) ) ;
					pstmt_insert.setString( 8, (String) mandatory_flds.get(2) ) ;
					pstmt_insert.setString( 9, (String) mandatory_flds.get(3) ) ;
					pstmt_insert.setString( 10, (String) mandatory_flds.get(4) ) ;
					pstmt_insert.setString( 11, (String) mandatory_flds.get(5) ) ;
					pstmt_insert.addBatch();
				}
				}

				
				int[] ph_inventory_insert= pstmt_insert.executeBatch();
				for (int i=0;i<ph_inventory_insert.length ;i++ ){
					if(ph_inventory_insert[i]<0  && ph_inventory_insert[i] != -2 ){
						pstmt_insert.cancel();
						throw new EJBException("Inventory Insertion Failed");
						}				
					}
				}*/
	//third stmt

				pstmt_insert=null;
				pstmt_insert = connection.prepareStatement( sql_ph_generic_name_for_drug_insert ) ;
				pstmt_insert.clearBatch();
				if((String) drugmastermain.get(7) !=null && ((String)drugmastermain.get(7)).equals("Y"))	{
					if(generic!=null && generic.size()>0){
						for (int i=0;i<generic.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) generic.get(i);
						//	messages.append("Values :"+(String)drugmastermain.get(0)+","	+(String)hh.get("generic_id")+","							+(String)hh.get("select")) ;
							if( ((String)hh.get("flag") !=null) && (((String)hh.get("flag")).equals("I"))){				
								pstmt_insert.setString( 1, (String) drugmastermain.get(0));
								pstmt_insert.setString( 2, (String) hh.get("generic_id") );
								pstmt_insert.setInt( 3,	   Integer.parseInt((String) hh.get("disp_seq_no")) );
								pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
								pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
								pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
								pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
								pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
								pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;

								pstmt_insert.addBatch();				
							}
						}
						int[] ph_generic_name_insert= pstmt_insert.executeBatch();

						for (int i=0;i<ph_generic_name_insert.length ;i++ ){
							if(ph_generic_name_insert[i]<0  && ph_generic_name_insert[i] != -2 ){
								pstmt_insert.cancel();
								throw new EJBException("Generic Insertion Failed");
							}
						}
					}
				}
				closeStatement( pstmt_insert ) ;
//mahesh
				pstmt_insert = connection.prepareStatement( sql_ph_ext_drug_insert ) ;
				pstmt_insert.clearBatch();
				if(external_db!=null && external_db.size()>0){
					for (int i=0;i<external_db.size()-1;){
						if((((String)external_db.get(i+3)).equals("I"))){	
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String) external_db.get(i++) );
							pstmt_insert.setString( 3, (String) external_db.get(i++) );
							pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
							pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
							pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
							pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
							pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
							pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;
							pstmt_insert.setString( 10,(String) external_db.get(i++) ) ;
							
							i++;
							pstmt_insert.addBatch();	
							}
					}
					int[] ph_ext_drug_insert= pstmt_insert.executeBatch();
					for (int i=0;i<ph_ext_drug_insert.length ;i++ ){
						if(ph_ext_drug_insert[i]<0  && ph_ext_drug_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("External Drug Insertion Failed");
						}
					}
				}

//INSERT INTO PH_DRUG_COMPATIBILITY_FLUID(DRUG_CODE,FLUID_CODE,DEFAULT_YN,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement( sql_ph_comp_fluids_insert ) ;
				pstmt_insert.clearBatch();
					if(Comp_Fluids!=null && Comp_Fluids.size()>0){
						for (int i=0;i<Comp_Fluids.size()-5;){//Changed 4 to 5 for ML-MMOH-CRF-1223
								if((((String)Comp_Fluids.get(i+3)).equals("I"))){	
								pstmt_insert.setString( 1, (String) drugmastermain.get(0)  );
								pstmt_insert.setString( 2, (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 3, (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 4, (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 5, (String) mandatory_flds.get(0)  );
								pstmt_insert.setString( 6, (String) mandatory_flds.get(1)  );
								pstmt_insert.setString( 7, (String) mandatory_flds.get(2)  );
								pstmt_insert.setString( 8, (String) mandatory_flds.get(3)  );
								pstmt_insert.setString( 9, (String) mandatory_flds.get(4)  );
								pstmt_insert.setString( 10, (String) mandatory_flds.get(5) );
								i++;
					            deflt_fluid_infuse_over_value	= Double.parseDouble((String) Comp_Fluids.get(i++));//Added for ML-MMOH-CRF-1223
		
								pstmt_insert.setDouble( 11,deflt_fluid_infuse_over_value );//Added for ML-MMOH-CRF-1223
								
								pstmt_insert.addBatch();	
								
							}
						}
						int[] ph_comp_fluids_insert= pstmt_insert.executeBatch();
						for (int i=0;i<ph_comp_fluids_insert.length ;i++ ){
							if(ph_comp_fluids_insert[i]<0  && ph_comp_fluids_insert[i] != -2 ){
								pstmt_insert.cancel();
								throw new EJBException("Compound Fluids Insertion Failed");
							}
						}
					}
					
		//fourth stmt
		closeStatement( pstmt_insert ) ; //common-icn-0029
				pstmt_insert=null;
				//messages.append(sql_ph_trade_name_for_drug_insert) ;	
				
				pstmt_insert = connection.prepareStatement( sql_ph_trade_name_for_drug_insert ) ;
				pstmt_insert.clearBatch();

				if(trade!=null && trade.size()>0){
					for (int i=0;i<trade.size() ;i++ ){
						HashMap hh=new HashMap();
						hh=(HashMap) trade.get(i);
					//System.out.println("in the Insert"+hh);
						if( ((String)hh.get("flag") !=null) && (((String)hh.get("flag")).equals("I"))){
							String eff=(String)hh.get("select");
							if(eff.equals("Y"))
							eff="E";
							else
							eff="D";
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String)hh.get("trade_id") );
							pstmt_insert.setInt( 3, Integer.parseInt((String)hh.get("disp_seq_no")));
							pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
							pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
							pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
							pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
							pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
							pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;
							pstmt_insert.setString( 10,(String) hh.get("trade_image_filename")); //TRADE_IMAGE_FILENAME
							pstmt_insert.setString( 11,eff);
							pstmt_insert.addBatch();				
						}
					} 
					int[] ph_trade_name_insert= pstmt_insert.executeBatch();

					for (int i=0;i<ph_trade_name_insert.length ;i++ ){
						if(ph_trade_name_insert[i]<0  && ph_trade_name_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Trade Name Insertion Failed");
						 }
					}
				}

				//weight stmt
				closeStatement( pstmt_insert ) ; //common-icn-0029
				pstmt_insert=null;
				//messages.append(sql_ph_trade_name_for_drug_insert) ;	
			
				pstmt_insert = connection.prepareStatement( sql_ph_age_group_for_drug_insert ) ;
			//	pstmt_insert = connection.prepareStatement( "insert into PH_DRUG_AGE_GROUP (DRUG_CODE, AGE_GROUP_CODE,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,WT_MAND_YN,DRUG_APPL_YN,EFF_STATUS)values(?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?)") ;
				pstmt_insert.clearBatch();

				if(agegroup!=null && agegroup.size()>0){
					for (int i=0;i<agegroup.size() ;i++ ){
						HashMap hh=new HashMap();
						hh=(HashMap) agegroup.get(i);
					//System.out.println("in the Insert"+hh);
					
						if( ((String)hh.get("flag") !=null) && (((String)hh.get("flag")).equals("I"))){
							String eff=(String)hh.get("select");
							if(eff.equals("Y"))
								eff="E";
							else
								eff="D";
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String)hh.get("age_group_code") );
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
							pstmt_insert.setString( 9, (String) hh.get("select_weight")) ;//WT_MAND_YN
							pstmt_insert.setString( 10, (String) hh.get("select_drug_appl")) ;//DRUG_APPL_YN
							pstmt_insert.setString( 11, eff);
							pstmt_insert.setString( 12, (String) hh.get("ht_mand_yn")) ;//HT_MAND_YN
							pstmt_insert.addBatch();				
						}
					} 
					int[] ph_weight_group_insert= pstmt_insert.executeBatch();

					for (int i=0;i<ph_weight_group_insert.length ;i++ ){
						if(ph_weight_group_insert[i]<0  && ph_weight_group_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("weight Insertion Failed");
						 }
					}
				}
			
				//sliding_scale_template stmt
				String sld_drug_code =(String) drugmastermain.get(0);
				pstmt_delete=null;
				pstmt_delete = connection.prepareStatement(sql_ph_drug_sliding_scale_tmpl_delete1) ;
				pstmt_delete.setString(1,sld_drug_code);
				try{
					pstmt_delete.executeUpdate();
				}
				catch(SQLException se) { 
					se.printStackTrace();
				}
				closeStatement( pstmt_delete ) ;
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement( sql_ph_drug_sliding_scale_tmpl_insert ) ;
				pstmt_insert.clearBatch();

			/*	if(sliding_scale_chkd_values.size()!=0)
				{
					//INSERT INTO PH_DRUG_SLIDING_SCALE_TMPL(DRUG_CODE, TEMPLATE_ID,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)
										
					int sliding_scale_insert=0; 
					int sld = 1;
				
					for(int s=0; s<sliding_scale_chkd_values.size();s++)
					{
						pstmt_insert = connection.prepareStatement(sql_ph_drug_sliding_scale_tmpl_insert) ;	
						pstmt_insert.setString(sld,sld_drug_code);
						sld++;
						pstmt_insert.setString(sld,(String) sliding_scale_chkd_values.get(s));
						
					
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID

						sliding_scale_insert = pstmt_insert.executeUpdate() ;
						closeStatement(pstmt_insert);
						sld=1;
						if(sliding_scale_insert==0)
							{
								map.put("flag","exception");
								throw new EJBException("Sliding_scale_template insertion failed");
							}
					
					} // end for
				} */
				if(sliding_scale_chkd_values.size()!=0){
										
					//int sliding_scale_insert=0; 
				//	int sld = 1;
					for(int s=0; s<sliding_scale_chkd_values.size();s++){
						pstmt_insert.setString(1,sld_drug_code);
					//	sld++;
						pstmt_insert.setString(2,(String) sliding_scale_chkd_values.get(s));
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();	
					}
					int[] sliding_scale_group_insert= pstmt_insert.executeBatch();

					for (int i=0;i<sliding_scale_group_insert.length ;i++ ){
						if(sliding_scale_group_insert[i]<0  && sliding_scale_group_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Sliding Scale Insertion Failed");
						 }
					}
				}
				//__end sliding_scale_template
				pstmt_insert = connection.prepareStatement( sql_ph_supportive_drugs_insert ) ;//Adding start for TH-KW-CRF-0007
				pstmt_insert.clearBatch();
				if(supportive_drugs.size()>0){
					for (int z=0;z<supportive_drugs.size();z++){
						    pstmt_insert.setString(1,(String) drugmastermain.get(0));
						    pstmt_insert.setString(2,(String) supportive_drugs.get(z));
							pstmt_insert.setInt(3,z+1);
							pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();
					}
					int[] supportive_drugs_insert= pstmt_insert.executeBatch();

					for (int i=0;i<supportive_drugs_insert.length ;i++ ){
						if(supportive_drugs_insert[i]<0  && supportive_drugs_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Supportive Drugs Insertion Failed");
						 }
				}//Adding end for TH-KW-CRF-0007
			}
		 }
			else{
				map.put("flag","exception");
				throw new EJBException("Ph Drug Insertion Failed");
			}
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			map.put("msgid","RECORD_INSERTED" ) ;
		}
		catch( Exception e ) {
			try{
				//messages.append( e.getMessage() ) ;
				map.put("flag",e.toString());
				map.put( "msgid", e.toString() ) ;
				connection.rollback();
				e.printStackTrace();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				ee.printStackTrace();
			}
		}
		finally {
			//map.put( "msgid", messages.toString() ) ;
			try {
				closeStatement( pstmt_insert ) ;
				closeConnection( connection,prop );
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		//map.put( "msgid", messages.toString() ) ;
		map.put( "flag",messages.toString());
			
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
	
		Connection connection						=	null ;
		PreparedStatement pstmt_insert				=	null ;
		PreparedStatement pstmt_update				=	null ;
		PreparedStatement pstmt_delete				=	null ;
		PreparedStatement pstmt_select				=	null ;
		PreparedStatement pstmt_comp_fluids_update	=	null ;
		PreparedStatement pstmt_dflt_fluid_update	=	null ;
		ResultSet resultSet1 = null ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		StringBuffer messages				=	new StringBuffer() ;
		Properties  prop					=	null;
		String restricted_yn				=	"";

		try	{
			 prop= (Properties)tabData.get( "properties" );
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			ArrayList drugmastermain	= (ArrayList) tabData.get("drugmastermain");
			ArrayList characteristics	= (ArrayList) tabData.get("characteristics");
			ArrayList prescribing_det	= (ArrayList) tabData.get("prescribing_det");
			ArrayList iv_char			= (ArrayList) tabData.get("iv_char");
			ArrayList dispensing		= (ArrayList) tabData.get("dispensing");
			//ArrayList inventory			= (ArrayList) tabData.get("inventory");
			ArrayList trade				= (ArrayList) tabData.get("trade");
			ArrayList generic			= (ArrayList) tabData.get("generic");
			ArrayList external_db		= (ArrayList) tabData.get("external_db");
			ArrayList Comp_Fluids		= (ArrayList) tabData.get("Comp_Fluids");
			ArrayList agegroup			= (ArrayList) tabData.get("ageGroup");
			ArrayList sliding_scale_chkd_values	=	(ArrayList) tabData.get("sliding_scale_chkd_values");
			ArrayList  supportive_drugs = (ArrayList) tabData.get("supportive");//Added for TH-KW-CRF-0007


			String sql_ph_drug_update						= (String) sqlMap.get( "SQL_PH_DRUG_UPDATE");
			String sql_ph_ext_drug_update					= (String) sqlMap.get("SQL_PH_EXT_DRUG_UPDATE");
			String sql_ph_trade_name_for_drug_update		= (String) sqlMap.get( "SQL_PH_TRADE_NAME_FOR_DRUG_UPDATE");
			String sql_ph_generic_name_for_drug_update		= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_FOR_DRUG_UPDATE");	
			String sql_ph_comp_fluids_update				= (String) sqlMap.get( "SQL_PH_COMP_FLUIDS_DRUG_UPDATE");	
            String sql_dosage_limit_by_base_upadate         = (String) sqlMap.get( "SQL_DOSAGE_LIMIT_BY_BASE_UPADATE"); // Added for ML-MMOH-CRF-0978
            String sql_dosage_limit_by_str_upadate          = (String) sqlMap.get( "SQL_DOSAGE_LIMIT_BY_STR_UPADATE"); // Added for ML-MMOH-CRF-0978
			//String sql_ph_inventory_item_for_drug_delete	= (String) sqlMap.get( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_DELETE");	
			String sql_ph_trade_name_for_drug_delete		= (String) sqlMap.get( "SQL_PH_TRADE_NAME_FOR_DRUG_DELETE");
			String sql_ph_generic_name_for_drug_delete		= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_FOR_DRUG_DELETE");	

		//	String sql_ph_inventory_item_for_drug_insert	= (String) sqlMap.get( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT");
			String sql_ph_generic_name_for_drug_insert		= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_FOR_DRUG_INSERT");
			String sql_ph_trade_name_for_drug_insert		= (String) sqlMap.get( "SQL_PH_TRADE_NAME_FOR_DRUG_INSERT");
			String sql_ph_ext_drug_insert					= (String) sqlMap.get("SQL_PH_EXT_DRUG_INSERT");
			String sql_ph_comp_fluids_insert				= (String) sqlMap.get("SQL_PH_COMP_FLUIDS_DRUG_INSERT");

			String sql_ph_comp_fluids_status_update			= (String) sqlMap.get("SQL_PH_COMP_FLUIDS_STATUS_UPDATE");
			String sql_ph_dflt_fluid_update					= (String) sqlMap.get("SQL_PH_DFLT_FLUID_UPDATE");
			String sql_ph_age_group_for_drug_insert			= (String) sqlMap.get("SQL_PH_AGE_GROUP_FOR_DRUG_INSERT");
			String sql_ph_age_group_for_drug_update			= (String) sqlMap.get("SQL_PH_AGE_GROUP_FOR_DRUG_UPDATE");
			String sql_ph_drug_sliding_scale_tmpl_delete1	= (String) sqlMap.get("SQL_PH_DRUG_SLIDING_SCALE_TMPL_DELETE1");
			String sql_ph_drug_sliding_scale_tmpl_insert	= (String) sqlMap.get("SQL_PH_DRUG_SLIDING_SCALE_TMPL_INSERT");
			String sql_ph_supportive_drugs_insert           = (String) sqlMap.get("SQL_PH_SUPPORTIVE_DRUGS_INSERT");//Added for TH-KW-CRF-0007
			String sql_ph_supportive_drugs_delete           = (String) sqlMap.get("SQL_PH_SUPPORTIVE_DRUG_DELETE");//Added for TH-KW-CRF-0007
			String reissue_type_ind							= "";//Added for Bru-HIMS-CRF-405[IN 044830]-Start
			String sql_ph_supportive_drugs_select           =" SELECT COUNT(*) FROM PH_SUPPORTIVE_DRUGS WHERE PARENT_DRUG_CODE =?";//Added for TH-KW-CRF-0007

			System.err.println("sql_ph_drug_update@@==="+sql_ph_drug_update+"characteristics@@@==="+characteristics);
			reissue_type_ind								= (String)dispensing.get(20);
			 if(reissue_type_ind.equals(""))
				 reissue_type_ind="N";//Added for Bru-HIMS-CRF-405[IN 044830]-End
			connection = getConnection(prop) ;
			connection.setAutoCommit( false ) ;
			int stability_hrs					=	0;
			String	strength_per_pres_uom		=	"";
			String strength						=	"";
			float strength_per_value_pres_uom	=	0.0f;
			float	content_per_pres_uom		=	0.0f; 
			int prn_doses_pres_prd_fill			=	0; 
			int prn_doses_cont_daily_fill		=	0; 
			double infuse_over_value				=	0.0; 
			double deflt_fluid_infuse_over_value				=	0.0; //Added for ML-MMOH-CRF-1223
			//int base_uom						=	0;
			//float strength_uom					=	0.0f;
			
			if(((String) iv_char.get(1)).equals("N")){
				try{
					pstmt_comp_fluids_update	=	connection.prepareStatement( sql_ph_comp_fluids_status_update ) ;
					
					pstmt_comp_fluids_update.setString( 1, (String) mandatory_flds.get(0) ) ;
					pstmt_comp_fluids_update.setString( 2, (String) mandatory_flds.get(1) ) ;
					pstmt_comp_fluids_update.setString( 3, (String) mandatory_flds.get(2) ) ;
					pstmt_comp_fluids_update.setString( 4, (String) drugmastermain.get(0) ) ;
					
					int ph_drg_comp_fluid = 0;
					try{
						ph_drg_comp_fluid = pstmt_comp_fluids_update.executeUpdate() ;
					}
					catch(Exception e) {
						System.err.println("While executing update for comp flds."+e.toString());
					}
				}catch(Exception e){
					System.err.println("Error updating comp fluids status.. "+e.toString());
				}

				try{
					pstmt_dflt_fluid_update	=	connection.prepareStatement( sql_ph_dflt_fluid_update ) ;
					
					pstmt_dflt_fluid_update.setString( 1, (String) mandatory_flds.get(0) ) ;
					pstmt_dflt_fluid_update.setString( 2, (String) mandatory_flds.get(1) ) ;
					pstmt_dflt_fluid_update.setString( 3, (String) mandatory_flds.get(2) ) ;
					pstmt_dflt_fluid_update.setString( 4, (String) drugmastermain.get(0) ) ;
					
					int ph_drg_dflt_fluid = 0;
					try{
						ph_drg_dflt_fluid = pstmt_dflt_fluid_update.executeUpdate() ;
					}
					catch(Exception e) {
						System.err.println("While executing update for default flds."+e.toString());
					}
				}catch(Exception es){
					System.err.println("Error updating default fluid .. "+es.toString());
				}
			}
			//first update
			//pstmt_update	=	null;
	    if( prescribing_det.get(3)!=null && drugmastermain.get(0)!=null && !((String)drugmastermain.get(0)).equals("")){ // Added for ML-MMOH-CRF-0978 -Start
			pstmt_update	=	connection.prepareStatement( sql_dosage_limit_by_str_upadate ) ;
			pstmt_update.setString(1,(String)prescribing_det.get(3));
			pstmt_update.setString(2,(String)drugmastermain.get(0));
			pstmt_update.executeUpdate();
	    }

	    if(drugmastermain.get(0)!=null && prescribing_det.get(0)!=null && !((String)drugmastermain.get(0)).equals("")){
			closeStatement( pstmt_update ) ; //common-icn-0029
			pstmt_update	=	connection.prepareStatement(sql_dosage_limit_by_base_upadate) ;
			pstmt_update.setString(1,(String)prescribing_det.get(0));
			pstmt_update.setString(2,(String)drugmastermain.get(0));
			pstmt_update.executeUpdate();
	    } // Added for ML-MMOH-CRF-0978 -End
		closeStatement( pstmt_update ) ; //common-icn-0029
			pstmt_update	=	connection.prepareStatement( sql_ph_drug_update ) ;
			
			int fld=0;
			//from charateristics - drug_desc, DRUG_TYPE, SCHEDULE_ID, RESTRICTED_DRUG_YN, AFFECTS_PREGNANCY_YN, AFFECTS_BREAST_FEEDING_YN, AFFECTS_LAB_RESULTS_YN, STABILITY_REQD_YN, STABILITY_HRS,APPL_TO_TDM_YN,APPL_TO_VERBAL_ORDER_YN 
			pstmt_update.setString( ++fld, (String) drugmastermain.get(1) ) ;
			pstmt_update.setString( ++fld, (String) drugmastermain.get(2) ) ;
			pstmt_update.setString( ++fld, (String) drugmastermain.get(3) ) ;
			pstmt_update.setString( ++fld, (String) drugmastermain.get(4) ) ;
			pstmt_update.setString( ++fld, (String) drugmastermain.get(9) ) ; //Code Added For RUT_CRF-0034
			String drug_type="";
			if( ((String) characteristics.get(0)==null) || (((String)characteristics.get(0)).equals("")))
				drug_type	=	"X";
			else
				drug_type	=	(String) characteristics.get(0);
			pstmt_update.setString( ++fld, drug_type					 ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(1) ) ;
			if( (String) characteristics.get(2)==null || ((String)characteristics.get(2)).equals(""))
				restricted_yn	=	"N";
			else
				restricted_yn	=	(String) characteristics.get(2);

			pstmt_update.setString( ++fld, restricted_yn				   ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(3) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(4) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(5) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(6) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(7) ) ;
			if(((String) characteristics.get(8))!=null){
				if( ((String) characteristics.get(8)).equals(""))	
					stability_hrs	=	0;
				else
					stability_hrs	= Integer.parseInt((String) characteristics.get(8));
			}
			else{
				stability_hrs	=	0;
			}
			
			pstmt_update.setInt( ++fld, stability_hrs ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(9) ) ;
			//pstmt_update.setString( ++fld, (String) characteristics.get(13) ) ;
			//messages.append("characteristics:"+(String)characteristics.get(0)+","+(String)characteristics.get(1)+","+(String)characteristics.get(2)+","+(String)characteristics.get(3)+","+(String)characteristics.get(4)+","+ (String)characteristics.get(5)+","+(String)characteristics.get(6)+","+(String)characteristics.get(7)+","+(String)characteristics.get(8)+":");
			//prescribing_det - PRES_BASE_UOM, CALC_DOSG_BY_FREQ_DURN_YN,STRENGTH_VALUE, STRENGTH_UOM, STRENGTH_PER_PRES_UOM, STRENGTH_PER_VALUE_PRES_UOM,PRES_CATG_CODE

			pstmt_update.setString( ++fld, (String) prescribing_det.get(0) ) ;
			pstmt_update.setString( ++fld, (String) prescribing_det.get(1) ) ;
			if(((String) prescribing_det.get(2))!=null)	{
				if( ((String) prescribing_det.get(2)).equals(""))
					strength	=	"0";
				else
					strength	=	(String) prescribing_det.get(2);
			}
			else{
				strength	=	"0";
			}
			pstmt_update.setString( ++fld, strength ) ;
			pstmt_update.setString( ++fld, (String) prescribing_det.get(3) ) ;
			
			if( ((String) prescribing_det.get(4))!=null ){
				if( !((String) prescribing_det.get(4)).equals("")  )	
					strength_per_pres_uom	= (String) prescribing_det.get(4);
			}
			else{
				strength_per_pres_uom	=	"";
			}
			
			pstmt_update.setString( ++fld, strength_per_pres_uom ) ;
			
			if( ((String) prescribing_det.get(5))!=null )		{
				if( ((String) prescribing_det.get(5)).equals(""))
					strength_per_value_pres_uom	=	0;
				else
					strength_per_value_pres_uom	=	 Float.parseFloat((String) prescribing_det.get(5));
			}
			else{
				strength_per_value_pres_uom	=	0;
			}
			pstmt_update.setFloat( ++fld, strength_per_value_pres_uom ) ;
			pstmt_update.setString( ++fld, (String) prescribing_det.get(6) ) ;
			//messages.append("prescribtion: "+(String) prescribing_det.get(0)+","+(String) prescribing_det.get(1)+","+(String) prescribing_det.get(2)+","+(String) prescribing_det.get(3)+","+(String) prescribing_det.get(4)+","+(String) prescribing_det.get(5)+": ");
			
			//dispense -FRACT_DOSE_ROUND_UP_YN,STOCK_UOM,CONTENT_IN_PRES_BASE_UOM,DISP_ALT_FORM_YN,DISP_MULTI_STRENGTH_YN,PRN_DOSES_PRES_PRD_FILL, PRN_DOSES_CONT_DAILY_FILL, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT,
			pstmt_update.setString( ++fld, (String) dispensing.get(0) ) ;
			pstmt_update.setString( ++fld, (String) prescribing_det.get(9) ) ;
			if(((String) prescribing_det.get(10))!=null)	{
				if( ((String) prescribing_det.get(10)).equals(""))	
					content_per_pres_uom	=	0.0f;
				else
					content_per_pres_uom	= Float.parseFloat((String) prescribing_det.get(10));
			}
			else{
				content_per_pres_uom	=	0.0f;
			}
			pstmt_update.setFloat( ++fld, content_per_pres_uom ) ;
			pstmt_update.setString( ++fld, (String) prescribing_det.get(11)) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(1) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(2) ) ;
			
			if(((String) dispensing.get(3))!=null)	{
				if( ((String) dispensing.get(3)).equals(""))	
					prn_doses_pres_prd_fill	=	0;
				else
					prn_doses_pres_prd_fill	= Integer.parseInt((String) dispensing.get(3));
			}
			else{
				prn_doses_pres_prd_fill	=	0;
			}
			pstmt_update.setInt( ++fld, prn_doses_pres_prd_fill) ;
			
			if(((String) dispensing.get(4))!=null)	{
				if( ((String) dispensing.get(4)).equals(""))	
					prn_doses_cont_daily_fill	=	0;
				else
					prn_doses_cont_daily_fill	= Integer.parseInt((String) dispensing.get(4));
			}
			else{
				prn_doses_cont_daily_fill	=	0;
			}
			pstmt_update.setInt( ++fld, prn_doses_cont_daily_fill ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(5) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(6) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(7) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(8)) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(9) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(10) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(11) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(12) ) ; 
			pstmt_update.setString( ++fld, (String) dispensing.get(13) ) ; 
			
			//messages.append(" dispense: "+(String) dispensing.get(0)+","+(String) dispensing.get(1)+","+(String) dispensing.get(2)+","+(String) dispensing.get(3)+","+(String) dispensing.get(4)+","+(String) dispensing.get(5)+","+(String) dispensing.get(6)+","+(String) dispensing.get(7)+","+(String) dispensing.get(8)+","+(String) dispensing.get(9)+","+(String) dispensing.get(10)+","+(String) dispensing.get(11)+","+(String) dispensing.get(12)+","+(String) dispensing.get(13)+":");
			//iv char - IV_INGREDIENT_YN, IV_FLUID_YN, INFUSE_OVER_VALUE, INFUSE_OVER_DURN_TYPE
			//System.out.println("@@Here===="+iv_char.get(2));
			pstmt_update.setString( ++fld, (String) iv_char.get(0) ) ;
			pstmt_update.setString( ++fld, (String) iv_char.get(1) ) ;
			
			if(((String) iv_char.get(2))!=null)	{
				if( ((String) iv_char.get(2)).equals(""))	
					infuse_over_value	=	0.0;
				else
					infuse_over_value	= Double.parseDouble((String) iv_char.get(2));
			}
			else{
				infuse_over_value	=	0.0;
			}

			pstmt_update.setDouble( ++fld, infuse_over_value ) ;
			pstmt_update.setString( ++fld, (String) iv_char.get(3) ) ;
				//System.out.println("@@Here 1111===="+iv_char);
			//messages.append(" iv char"+(String) iv_char.get(0)+","+(String) iv_char.get(1)+","+(String) iv_char.get(2)+","+(String) iv_char.get(3)+":");	
			//mandatory -  MODIFIED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID

			pstmt_update.setString( ++fld, (String) mandatory_flds.get(0) ) ;
			pstmt_update.setString( ++fld, (String) mandatory_flds.get(1) ) ;
			pstmt_update.setString( ++fld, (String) mandatory_flds.get(2) ) ;
			//messages.append("mandatory :"+(String) mandatory_flds.get(0)+","+(String) mandatory_flds.get(1)+","+(String) mandatory_flds.get(2));

			String physical_form = "";

			if(iv_char.get(4)==null || iv_char.get(4) == ""){
				physical_form ="S";
			}
			else{
				physical_form =(String)iv_char.get(4);
			}

			pstmt_update.setString( ++fld, physical_form) ;
			pstmt_update.setString( ++fld,(String)iv_char.get(5)) ;
		//	pstmt_update.setString( ++fld,(String)drugmastermain.get(0)) ;
			// Default Fluid code value.
			pstmt_update.setString( ++fld, (String) iv_char.get(6) ) ;
			pstmt_update.setString( ++fld, (String) iv_char.get(7) ) ;
			pstmt_update.setString( ++fld, (String) iv_char.get(8) ) ;
			
			// characteristics applc tdm, verbal order appl during MAR
			pstmt_update.setString( ++fld, (String) characteristics.get(10) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(11) ) ;	
			pstmt_update.setString( ++fld, (String) characteristics.get(12) ) ;
			pstmt_update.setString( ++fld, (String) characteristics.get(13) ) ;	
			pstmt_update.setString( ++fld, ((String) characteristics.get(14)).trim() ) ;	
			pstmt_update.setString( ++fld, (String) characteristics.get(15) ) ;		
			String weight_rec_appl_age_group=(String) characteristics.get(16);
			if(weight_rec_appl_age_group==null || weight_rec_appl_age_group.equals("null"))
				weight_rec_appl_age_group="";
			pstmt_update.setString( ++fld, weight_rec_appl_age_group ) ;	
			pstmt_update.setString( ++fld, (String) characteristics.get(17) ) ;	
			pstmt_update.setString( ++fld, (String) characteristics.get(18) ) ;
			pstmt_update.setString( ++fld, (String) dispensing.get(14) ) ;		//  FRACT_DOSE_APPL_YN
			pstmt_update.setString( ++fld, (String) characteristics.get(19) ) ; //  ITEM_IMAGE_FILENAME
			pstmt_update.setString( ++fld, (String) dispensing.get(15) ) ;		// VERIFICATION_REQD_YN
			pstmt_update.setString( ++fld, (String) characteristics.get(20) ) ;		// EDL_CODES
			pstmt_update.setString( ++fld, (String) characteristics.get(21) ) ;		// EDL_REMARKS
		//	System.out.println("@@=====Before setString in modify========"+(String)dispensing.get(16));
			pstmt_update.setString( ++fld, (String) dispensing.get(16) ) ; // ALLOW_MORETHAN_PRES_QTY_YN
			pstmt_update.setString( ++fld, (String) characteristics.get(22) ) ; // Pregnancy Category Group code
			pstmt_update.setString( ++fld, (String) characteristics.get(23) ) ; //  Pregnancy Category  code1
			pstmt_update.setString( ++fld, (String) characteristics.get(24) ) ; //  Pregnancy Category code2
			pstmt_update.setString( ++fld, (String) characteristics.get(25) ) ; //  Pregnancy Category code3
 			pstmt_update.setString( ++fld, (String) drugmastermain.get(10) ) ; // PROMPT_ALERT_FOR_DRUG

			pstmt_update.setString( ++fld, (String) drugmastermain.get(11) ) ; // Code Added For RUT-CRF-0034
			pstmt_update.setString( ++fld, (String) dispensing.get(17) ) ; // //PRINT Label RUT-CRF-0067
			pstmt_update.setString( ++fld, (String) dispensing.get(18) ) ;//Added For default_dosage_by SKR-CRF-PHIS-003[IN028182]
			pstmt_update.setString( ++fld, (String) characteristics.get(27) ) ;//code added for Bru-HIMS-CRF-070[IN029935]
			pstmt_update.setString( ++fld, (String) dispensing.get(19) );//Added For Drug_Indication for ML-BRU-CRF-072[Inc:29938]
			pstmt_update.setString( ++fld, (String) characteristics.get(28) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld, (String) characteristics.get(29) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld, (String) characteristics.get(30) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld, (String) characteristics.get(31) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld, (String) characteristics.get(32) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld, (String) characteristics.get(33) );//Added for PREG_EFFECT For RUT-CRF-0063[29601]
			pstmt_update.setString( ++fld,  reissue_type_ind ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_update.setString( ++fld, (String) dispensing.get(21) ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_update.setString( ++fld, (String) dispensing.get(22) ) ;//Added for Bru-HIMS-CRF-405[IN 044830]
			pstmt_update.setString( ++fld, (String) prescribing_det.get(12) ) ; // parameter DEFAULT_DOSAGE_BY_YN added AAKH-CRF-089
			//System.err.println("@@(String) prescribing_det.get(12)========:"+(String) prescribing_det.get(12));
			pstmt_update.setString( ++fld, (String) characteristics.get(34) );//added for ghl-crf-0482
			pstmt_update.setString( ++fld, (String) drugmastermain.get(12) ) ;    // DRUG_SEARCH_BY UPDATED for MMS-DM-CRF-0177
			pstmt_update.setString( ++fld, (String) characteristics.get(35) );//Added for TH-KW-CRF-0008 DRUG_EXPIRY_ALERT_DAYS
			pstmt_update.setString( ++fld, (String) characteristics.get(36) );//Added for KDAH-CRF-0610 REST_ANTI_JUSTFORM_YN
			pstmt_update.setString( ++fld, (String) characteristics.get(37) );//Added for KDAH-CRF-0610 REST_ANTI_JUSTFORM_DURATION

			pstmt_update.setString( ++fld, (String) drugmastermain.get(0) ) ;    // Drug code value
			
			//messages.append("drug code :"+(String) drugmastermain.get(0));
			
			int ph_drug_update = 0;
			try{
				ph_drug_update = pstmt_update.executeUpdate() ;
			}
			catch(Exception e) {
				System.err.println("The error values encounterd "+e.toString());
		}
			if(ph_drug_update!=0){

			//pstmt_delete	=	null;
				pstmt_delete	=	connection.prepareStatement( sql_ph_generic_name_for_drug_delete ) ;
				if(generic!=null && generic.size()>0){
					for (int i=0;i<generic.size() ;i++ ){
						HashMap hh=new HashMap();
						hh=(HashMap) generic.get(i);

		
						if( ((String)hh.get("flag")).equals("D"))	{
					
						pstmt_delete.setString( 1, (String) drugmastermain.get(0) );
							pstmt_delete.setString( 2, (String) hh.get("generic_id") ) ;
							pstmt_delete.addBatch();				
						}
					}
				}
				try{
					if(generic!=null && generic.size()>0){
						int[] ph_generic_name_delete	= pstmt_delete.executeBatch();
					
						for (int i=0;i<ph_generic_name_delete.length ;i++ ){
							if(ph_generic_name_delete[i]<0  && ph_generic_name_delete[i] != -2 ){
								pstmt_delete.cancel();
								throw new EJBException("Generic Deletion Failed");
							}
						}
					}
				}
				catch(Exception e){
					System.out.println("===========ph_generic_name_delete trycatch ========="+e.toString());
				}
				closeStatement( pstmt_delete ) ;
				pstmt_delete	=	connection.prepareStatement( sql_ph_trade_name_for_drug_delete ) ;

				//pstmt_delete	=	null;
				int supp_count=0;
				pstmt_select =connection.prepareStatement(sql_ph_supportive_drugs_select);
				  pstmt_select.setString(1,(String) drugmastermain.get(0));
				  resultSet1 = pstmt_select.executeQuery();
					if( resultSet1.next() ) {
						 supp_count	=	resultSet1.getInt(1);
					}
					System.err.println("supp_count@@@==="+supp_count);
				pstmt_delete	=	connection.prepareStatement( sql_ph_supportive_drugs_delete ) ;
				if(supp_count>0){
					for (int i=0;i<supp_count ;i++ ){
					//	HashMap hh=new HashMap();
					//	hh=(HashMap) supportive_drugs.get(i);
		
						    pstmt_delete.setString( 1, (String) drugmastermain.get(0) );
							
							pstmt_delete.addBatch();				
					}
				  }
				try{
					if(supp_count>0){
						int[] ph_support_drugs_delete	= pstmt_delete.executeBatch();
					
						for (int i=0;i<ph_support_drugs_delete.length ;i++ ){
							if(ph_support_drugs_delete[i]<0  && ph_support_drugs_delete[i] != -2 ){
								pstmt_delete.cancel();
								throw new EJBException("Supportive Drugs Deletion Failed");
							}
						}
					}
				}
				catch(Exception e){
					System.out.println("===========ph_supporttive_drus trycatch ========="+e.toString());
				}
			
				//messages.append("after generic delete");	

				//pstmt_delete	=	null;
				closeStatement( pstmt_delete ) ;
				pstmt_delete	=	connection.prepareStatement( sql_ph_trade_name_for_drug_delete ) ;
				pstmt_delete.clearBatch();
                 //System.err.println("in the EJB"+trade.size()+trade);

					if(trade!=null && trade.size()>0){
						

						for (int i=0;i<trade.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) trade.get(i);
							if( ((String)hh.get("flag")).equals("D"))	{
								pstmt_delete.setString( 1, (String) drugmastermain.get(0) );
								pstmt_delete.setString( 2, (String) hh.get("trade_id") ) ;
								pstmt_delete.addBatch();				
							}
						}
					}

					int[] ph_trade_name_delete	= pstmt_delete.executeBatch();

					for (int i=0;i<ph_trade_name_delete.length ;i++ ){
						if(ph_trade_name_delete[i]<0  && ph_trade_name_delete[i] != -2 ){
							pstmt_delete.cancel();
							throw new EJBException("Trade Deletion Failed");
						
						}
					}
					//	messages.append("after trade delete");	


						/***Inventory Delete Start*********/
						//pstmt_delete	=	null;
					/*	closeStatement( pstmt_delete ) ;
						pstmt_delete	=	connection.prepareStatement( sql_ph_inventory_item_for_drug_delete ) ;

						if(inventory!=null && inventory.size()>0){
							pstmt_delete.setString( 1, (String) drugmastermain.get(0) );
							pstmt_delete.executeUpdate();	
						}*/

					//messages.append("after inventory delete");	

					/***Inventory Delete Ends**********/

					/****Update of Trade,Inventory & Generic Starts***********/
					closeStatement( pstmt_update ) ;
					pstmt_update	=	null;
					pstmt_update	=	connection.prepareStatement( sql_ph_trade_name_for_drug_update) ;
					String eff_status="";
					if(trade!=null && trade.size()>0){
						for (int i=0;i<trade.size() ;i++ ){
							HashMap hh=new HashMap();
							
							hh=(HashMap) trade.get(i);
							//System.err.println("@@@@@@"+hh+trade.size()+hh.size());
							if(hh.size()==8) {
								eff_status = ((String)hh.get("eff_status"));
							}
							else{    
								  if(((String)hh.get("select")).equals("N") && ((String)hh.get("eff_status")).equals("Y"))

								 eff_status="D";
									else  if( ((String)hh.get("select")).equals("") && ((String)hh.get("eff_status")).equals("N") )
										eff_status="D";
									else if( ((String)hh.get("select")).equals("") && ((String)hh.get("eff_status")).equals("Y") )
										eff_status="E";
									else{
									String yy=(String) hh.get("select");
									if(yy.equals("Y") )
									eff_status="E";
									else if(yy.equals("N"))
									eff_status="D";
								
									}
							}
							//System.err.println("IN THE UPDATE PART OF THE DRUG MASTR EJB"+hh+eff_status);
                            if( ((String)hh.get("flag")).equals("DB")){
								
								pstmt_update.setInt( 1, Integer.parseInt((String) hh.get("disp_seq_no")));
								pstmt_update.setString( 2,eff_status  ) ;
								pstmt_update.setString( 3, (String) mandatory_flds.get(0) ) ;
								pstmt_update.setString( 4, (String) mandatory_flds.get(1) ) ;
								pstmt_update.setString( 5, (String) mandatory_flds.get(2) ) ;
								pstmt_update.setString( 6, (String) hh.get("trade_image_filename") ) ; //TRADE_IMAGE_FILENAME
								pstmt_update.setString( 7, (String) drugmastermain.get(0));
								pstmt_update.setString( 8, (String) hh.get("trade_id") );
                                
								pstmt_update.addBatch();				
							}
						}

						int[] ph_trade_name_update	= pstmt_update.executeBatch();

						for (int i=0;i<ph_trade_name_update.length ;i++ ){
							if(ph_trade_name_update[i]<0  && ph_trade_name_update[i] != -2 ){
								pstmt_update.cancel();
								throw new EJBException("Trade Name Updation Failed");
							}
						}

					}
					closeStatement( pstmt_update ) ;
					// weight update
					pstmt_update	=	null;
					pstmt_update	=	connection.prepareStatement( sql_ph_age_group_for_drug_update) ;
				//	pstmt_update	=	connection.prepareStatement("UPDATE PH_DRUG_AGE_GROUP SET  EFF_STATUS=?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? , WT_MAND_YN=?,DRUG_APPL_YN=? WHERE DRUG_CODE = ? AND  AGE_GROUP_CODE = ?");
									
					String  wt_mand_yn="", ht_mand_yn=""; // ht_mand_yn added for Bru-HIMS-CRF-079 IN[029945] 
					String  drug_appl_yn="";
					String eff_status1="";
					if(agegroup!=null && agegroup.size()>0){
						for (int i=0;i<agegroup.size() ;i++ ){
							HashMap hh=new HashMap();
							
							hh=(HashMap) agegroup.get(i);
							//System.err.println("@@@@@@  "+hh.size());
							if(hh.size()==11) { //changed from 10 to 11 for Bru-HIMS-CRF-079 IN[029945] 
								eff_status1 = ((String)hh.get("eff_status"));
							}
							else{    
							  if(((String)hh.get("select")).equals("N") && ((String)hh.get("eff_status")).equals("Y"))
								 eff_status1="D";
								else  if( ((String)hh.get("select")).equals("") && ((String)hh.get("eff_status")).equals("N") )
									eff_status1="D";
								else if( ((String)hh.get("select")).equals("") && ((String)hh.get("eff_status")).equals("Y") )
									eff_status1="E";
								else{
									String yy=(String) hh.get("select");
									if(yy.equals("Y") )
										eff_status1="E";
									else if(yy.equals("N"))
										eff_status1="D";
								}
							}
							wt_mand_yn=(String) hh.get("select_weight");
							ht_mand_yn=(String) hh.get("ht_mand_yn"); // added for Bru-HIMS-CRF-079 IN[029945] 
							drug_appl_yn=(String) hh.get("select_drug_appl");
							if(hh.size()==11) { //changed from 10 to 11 for Bru-HIMS-CRF-079 IN[029945] 
								wt_mand_yn = ((String)hh.get("eff_status_weight"));
								drug_appl_yn = ((String)hh.get("eff_status_drug_appl"));
							}
							else{
								if(drug_appl_yn.equals("") && ((String)hh.get("eff_status_drug_appl")).equals("N"))
									drug_appl_yn="N";
								else if(drug_appl_yn.equals("") && ((String)hh.get("eff_status_drug_appl")).equals("Y"))
									drug_appl_yn="Y";

								if(wt_mand_yn.equals("") && ((String)hh.get("eff_status_weight")).equals("N"))
									wt_mand_yn="N";
								else if(wt_mand_yn.equals("") && ((String)hh.get("eff_status_weight")).equals("Y"))
									wt_mand_yn="Y";
								if(ht_mand_yn==null || ht_mand_yn.equals("")) // if block added for Bru-HIMS-CRF-079 IN[029945] 
									ht_mand_yn="N";
							}
                            if( ((String)hh.get("flag")).equals("DB")){
								pstmt_update.setString( 1,eff_status1  ) ;
								pstmt_update.setString( 2, (String) mandatory_flds.get(0) ) ;
								pstmt_update.setString( 3, (String) mandatory_flds.get(1) ) ;
								pstmt_update.setString( 4, (String) mandatory_flds.get(2) ) ;
								pstmt_update.setString( 5, wt_mand_yn ) ;
								pstmt_update.setString( 6, drug_appl_yn ) ;
								pstmt_update.setString( 7, ht_mand_yn); // added for Bru-HIMS-CRF-079 IN[029945] 
								pstmt_update.setString( 8, (String) drugmastermain.get(0));
								pstmt_update.setString( 9, (String) hh.get("age_group_code") );
								pstmt_update.addBatch();				
							}
						}
					//	}

						int[] ph_agegroup_update	= pstmt_update.executeBatch();

						for (int i=0;i<ph_agegroup_update.length ;i++ ){
							if(ph_agegroup_update[i]<0  && ph_agegroup_update[i] != -2 ){
								pstmt_update.cancel();
								throw new EJBException(" age_group_code Updation Failed");
							}
						}
					}
					
					//Mahesh
					closeStatement(pstmt_insert);
					pstmt_insert=null;
					pstmt_insert = connection.prepareStatement( sql_ph_ext_drug_insert ) ;
					pstmt_insert.clearBatch();
					closeStatement( pstmt_update ) ;
					pstmt_update	=	null;
					pstmt_update	=	connection.prepareStatement( sql_ph_ext_drug_update) ;

					if(external_db!=null && external_db.size()>0){
						
						for (int i=0;i<external_db.size()-1;){
							if(((String)external_db.get(i+3)).equals("U")){
								pstmt_update.setString( 7, (String)external_db.get(i++));
								pstmt_update.setString( 1, (String)external_db.get(i++)) ;
								pstmt_update.setString( 2, (String)external_db.get(i++)) ;
								pstmt_update.setString( 3, (String) mandatory_flds.get(0) ) ;
								pstmt_update.setString( 4, (String) mandatory_flds.get(1) ) ;
								pstmt_update.setString( 5, (String) mandatory_flds.get(2) ) ;
								pstmt_update.setString( 6, (String) drugmastermain.get(0));
								i++;
								
								pstmt_update.addBatch();				
							}
							else if(((String)external_db.get(i+3)).equals("I")){
								pstmt_insert.setString( 1, (String) drugmastermain.get(0));
								pstmt_insert.setString( 2, (String) external_db.get(i++) );
								pstmt_insert.setString( 3, (String) external_db.get(i++) );
								pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
								pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
								pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
								pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
								pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
								pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;
								pstmt_insert.setString( 10,(String) external_db.get(i++) ) ;
								i++;

								pstmt_insert.addBatch();  
							}
						}

						int[] ph_external_name_update	= pstmt_update.executeBatch();

						for (int i=0;i<ph_external_name_update.length ;i++ ){
							if(ph_external_name_update[i]<0  && ph_external_name_update[i] != -2 ){
								pstmt_update.cancel();
								throw new EJBException("External drug Name Updation Failed");
							}
						}
						int[] ph_ext_db_insert	= pstmt_insert.executeBatch();

						for (int i=0;i<ph_ext_db_insert.length ;i++ ){
							if(ph_ext_db_insert[i]<0  && ph_ext_db_insert[i] != -2 ){
								pstmt_insert.cancel();
								throw new EJBException("External drug Name Insertion Failed");
							}
						}

					}

					closeStatement(pstmt_insert);
					pstmt_insert=null;
					pstmt_insert = connection.prepareStatement( sql_ph_comp_fluids_insert ) ;
					pstmt_insert.clearBatch();
					closeStatement( pstmt_update ) ;
					pstmt_update	=	null;
					pstmt_update	=	connection.prepareStatement( sql_ph_comp_fluids_update) ;
					if(Comp_Fluids!=null && Comp_Fluids.size()>0){
						for (int i=0;i<Comp_Fluids.size()-5;){//Changed 4 to for ML-MMOH-CRF-1223
							if((((String)Comp_Fluids.get(i+3)).equals("I"))){	
								pstmt_insert.setString( 1,  (String) drugmastermain.get(0)  );
								pstmt_insert.setString( 2,  (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 3,  (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 4,  (String) Comp_Fluids.get(i++)   );
								pstmt_insert.setString( 5,  (String) mandatory_flds.get(0)  );
								pstmt_insert.setString( 6,  (String) mandatory_flds.get(1)  );
								pstmt_insert.setString( 7,  (String) mandatory_flds.get(2)  );
								pstmt_insert.setString( 8,  (String) mandatory_flds.get(3)  );
								pstmt_insert.setString( 9,  (String) mandatory_flds.get(4)  );
								pstmt_insert.setString( 10, (String) mandatory_flds.get(5)  );
								i++;
							    deflt_fluid_infuse_over_value	= Double.parseDouble((String) Comp_Fluids.get(i++));//Added for ML-MMOH-CRF-1223
								pstmt_insert.setDouble( 11,deflt_fluid_infuse_over_value );//Added for ML-MMOH-CRF-1223
								pstmt_insert.addBatch();	
								
							}
							else if((((String)Comp_Fluids.get(i+3)).equals("U"))){	
								pstmt_update.setString( 1, (String) drugmastermain.get(0)  );
								pstmt_update.setString( 9, (String) Comp_Fluids.get(i++)   );
								pstmt_update.setString( 2, (String) Comp_Fluids.get(i++)   );
								pstmt_update.setString( 3, (String) Comp_Fluids.get(i++)   );
								pstmt_update.setString( 4, (String) mandatory_flds.get(0)  );
								pstmt_update.setString( 5, (String) mandatory_flds.get(1)  );
								pstmt_update.setString( 6, (String) mandatory_flds.get(2)  );
								//pstmt_update.setString( 7, (String) drugmastermain.get(0)  );removed
								i++;
							    deflt_fluid_infuse_over_value	= Double.parseDouble((String) Comp_Fluids.get(i++));//Added for ML-MMOH-CRF-1223
								pstmt_update.setDouble( 7,deflt_fluid_infuse_over_value );//Added for ML-MMOH-CRF-1223
								pstmt_update.setString( 8, (String) drugmastermain.get(0)  );
								pstmt_update.addBatch();	
							}
						}
						int[] ph_comp_fluids_update	= pstmt_update.executeBatch();

						for (int i=0;i<ph_comp_fluids_update.length ;i++ ){
							if(ph_comp_fluids_update[i]<0  && ph_comp_fluids_update[i] != -2 ){
								pstmt_update.cancel();
								throw new EJBException("Compatible Fluids Updation Failed");
							}
						}
						int[] ph_comp_fluids_insert= pstmt_insert.executeBatch();
						for (int i=0;i<ph_comp_fluids_insert.length ;i++ ){
							if(ph_comp_fluids_insert[i]<0  && ph_comp_fluids_insert[i] != -2 ){
								pstmt_insert.cancel();
								throw new EJBException("Compound Fluids Insertion Failed");
							}
						}
					}
					closeStatement(pstmt_update);
					//messages.append("ph trade name updated");

					pstmt_update	=	null;
					pstmt_update	=	connection.prepareStatement( sql_ph_generic_name_for_drug_update ) ;
					pstmt_update.clearBatch();

					if(generic!=null && generic.size()>0){
						for (int i=0;i<generic.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) generic.get(i);
							if( ((String)hh.get("flag")).equals("U"))	{
								pstmt_update.setString( 1, (String) hh.get("disp_seq_no"));
								pstmt_update.setString( 2, (String) mandatory_flds.get(0) ) ;
								pstmt_update.setString( 3, (String) mandatory_flds.get(1) ) ;
								pstmt_update.setString( 4, (String) mandatory_flds.get(2) ) ;
								pstmt_update.setString( 5, (String) drugmastermain.get(0));
								pstmt_update.setString( 6, (String) hh.get("generic_id") );
								pstmt_update.addBatch();				
							}
						}
						int[] ph_generic_name_update	= pstmt_update.executeBatch();

						for (int i=0;i<ph_generic_name_update.length ;i++ ){
							if(ph_generic_name_update[i]<0  && ph_generic_name_update[i] != -2 ){
								pstmt_update.cancel();
								throw new EJBException("Generic Updation Failed");
							}
						}
					}

					//messages.append("ph generic name updated");
					/****Update of Trade,Inventory & Generic Ends***********/
					/****Insert  of Inventory, Trade & Generic Starts***********/
					//pstmt_insert=null;

					closeStatement( pstmt_insert ) ;

				/*	pstmt_insert = connection.prepareStatement( sql_ph_inventory_item_for_drug_insert ) ;
					pstmt_insert.clearBatch();

					if(inventory!=null && inventory.size()>0){
						for (int i=0;i<inventory.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) inventory.get(i);
							if( ((String)hh.get("flag")).equals("I")){
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String)hh.get("item_code") );
							pstmt_insert.setString( 3, (String)hh.get("stock_uom_code") );			
							if(((String)hh.get("base_uom"))!=null)	{
									if( ((String)hh.get("base_uom")).equals(""))	
										base_uom	=	0;
									else
										base_uom	= Integer.parseInt((String) (String)hh.get("base_uom"));
							}
							else{
								base_uom	=	0;
							}

							pstmt_insert.setInt( 4, base_uom );

							if(((String)prescribing_det.get(2))!=null)	{
									if( ((String)prescribing_det.get(2)).equals(""))	
										strength_uom	=	0;
									else
										strength_uom	= Float.parseFloat((String) prescribing_det.get(2));
							}
							else{
								strength_uom	=	0;
							}

							pstmt_insert.setFloat( 5, strength_uom );
							pstmt_insert.setString( 6, (String) mandatory_flds.get(0) ) ;
							pstmt_insert.setString( 7, (String) mandatory_flds.get(1) ) ;
							pstmt_insert.setString( 8, (String) mandatory_flds.get(2) ) ;
							pstmt_insert.setString( 9, (String) mandatory_flds.get(0) ) ;
							pstmt_insert.setString( 10, (String) mandatory_flds.get(1) ) ;
							pstmt_insert.setString( 11, (String) mandatory_flds.get(2) ) ;
							pstmt_insert.addBatch();
						}
					}

						
					int[] ph_inventory_insert= pstmt_insert.executeBatch();

					for (int i=0;i<ph_inventory_insert.length ;i++ ){
						if(ph_inventory_insert[i]<0  && ph_inventory_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Inventory Insertion Failed");
							}				
						}
					}
					//messages.append("ModifyMode: inventory name insertion over");
					//third stmt
					//pstmt_insert=null;
					closeStatement( pstmt_insert ) ;*/	
					pstmt_insert = connection.prepareStatement( sql_ph_generic_name_for_drug_insert ) ;
					pstmt_insert.clearBatch();
			
					if((String) drugmastermain.get(7) !=null){
						if(generic!=null && generic.size()>0){

							for (int i=0;i<generic.size() ;i++ ){
								HashMap hh=new HashMap();
								hh=(HashMap) generic.get(i);

								if(((String)hh.get("flag")).equals("I")){				
								
									pstmt_insert.setString( 1, (String) drugmastermain.get(0));
									pstmt_insert.setString( 2, (String) hh.get("generic_id") );
									pstmt_insert.setInt( 3,	   Integer.parseInt((String) hh.get("disp_seq_no")) );
									pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
									pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
									pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
									pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
									pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
									pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;
									pstmt_insert.addBatch();				
								}
							}
							int[] ph_generic_name_insert= pstmt_insert.executeBatch();

							for (int i=0;i<ph_generic_name_insert.length ;i++ ){
								if(ph_generic_name_insert[i]<0  && ph_generic_name_insert[i] != -2 ){
									pstmt_insert.cancel();
									throw new EJBException("Generic  Insertion Failed");
									
								}
							}
						}
					}
					closeStatement( pstmt_insert ) ;
					pstmt_insert=null;
					pstmt_insert = connection.prepareStatement( sql_ph_trade_name_for_drug_insert ) ;
					pstmt_insert.clearBatch();

					if(trade!=null && trade.size()>0){
						for (int i=0;i<trade.size() ;i++ ){
							HashMap hh=new HashMap();
							hh=(HashMap) trade.get(i);
							if(((String)hh.get("flag")).equals("I")){
								String eff=(String)hh.get("select");
							if(eff.equals("Y"))
							eff="E";
							else
							eff="D";
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String)hh.get("trade_id") );
							pstmt_insert.setInt( 3, Integer.parseInt((String)hh.get("disp_seq_no")));
							pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;
							pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;
							pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;
							pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;
							pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;
							pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;
							pstmt_insert.setString( 10,(String) hh.get("trade_image_filename")); //TRADE_IMAGE_FILENAME
							pstmt_insert.setString( 11, eff) ;
							pstmt_insert.addBatch();				
						}
					} 
					int[] ph_trade_name_insert= pstmt_insert.executeBatch();

					for (int i=0;i<ph_trade_name_insert.length ;i++ ){
						if(ph_trade_name_insert[i]<0  && ph_trade_name_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Trade Name Insertion Failed");
							
						}
					}
				}	
				


			//	weight record age group
				closeStatement( pstmt_insert ) ;
				
				pstmt_insert = connection.prepareStatement( sql_ph_age_group_for_drug_insert ) ;
			
				pstmt_insert.clearBatch();

				if(agegroup!=null && agegroup.size()>0){
					for (int i=0;i<agegroup.size() ;i++ ){
						HashMap hh=new HashMap();
						hh=(HashMap) agegroup.get(i);
						
						if( ((String)hh.get("flag")).equals("I")){
							String eff=(String)hh.get("select");
							if(eff.equals("Y"))
							eff="E";
							else
							eff="D";
							pstmt_insert.setString( 1, (String) drugmastermain.get(0));
							pstmt_insert.setString( 2, (String)hh.get("age_group_code") );
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;// MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;// MODIFIED_FACILITY_ID
							pstmt_insert.setString( 9, (String) hh.get("select_weight") ) ;		//  WT_MAND_YN
							pstmt_insert.setString( 10, (String) hh.get("select_drug_appl")) ;		//  DRUG_APPL_YN
							pstmt_insert.setString( 11, eff) ;
							pstmt_insert.setString( 12, (String) hh.get("ht_mand_yn")) ; //  added for Bru-HIMS-CRF-079 IN[029945] 
							pstmt_insert.addBatch();				
						}
					} 
					int[] ph_weight_group_insert= pstmt_insert.executeBatch();

					for (int i=0;i<ph_weight_group_insert.length ;i++ ){
						if(ph_weight_group_insert[i]<0  && ph_weight_group_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("weight Insertion Failed");
						 }
					}
				}	

		//sliding_scale_template stmt
				String sld_drug_code =(String) drugmastermain.get(0);
					
				pstmt_delete=null;
				pstmt_delete = connection.prepareStatement(sql_ph_drug_sliding_scale_tmpl_delete1) ;
				pstmt_delete.setString(1,sld_drug_code);
				
				try{
					pstmt_delete.executeUpdate();
				
				
				}catch(SQLException se) { System.out.println("In delete :"+se);	}

				closeStatement( pstmt_delete ) ;
				closeStatement( pstmt_insert ); //common-icn-0029
				pstmt_insert = connection.prepareStatement( sql_ph_drug_sliding_scale_tmpl_insert ) ;
			
				pstmt_insert.clearBatch();
		/*		if(sliding_scale_chkd_values.size()!=0)
				{
										
					int sliding_scale_insert=0; 
					int sld = 1;
					for(int s=0; s<sliding_scale_chkd_values.size();s++)
					{
						pstmt_insert = connection.prepareStatement(sql_ph_drug_sliding_scale_tmpl_insert) ;
						pstmt_insert.setString(sld,sld_drug_code);
						sld++;
						pstmt_insert.setString(sld,(String) sliding_scale_chkd_values.get(s));
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
						sliding_scale_insert = pstmt_insert.executeUpdate() ;
						sld=1;
						if(sliding_scale_insert==0)
							{
								map.put("flag","exception");
								throw new EJBException("Sliding_scale_template insertion failed");
							}
					
					} // end for
				} */
				if(sliding_scale_chkd_values.size()!=0)
				{
										
					//int sliding_scale_insert=0; 
				//	int sld = 1;
					for(int s=0; s<sliding_scale_chkd_values.size();s++)
					{
						pstmt_insert.setString(1,sld_drug_code);
					//	sld++;
						pstmt_insert.setString(2,(String) sliding_scale_chkd_values.get(s));
							pstmt_insert.setString( 3, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 4, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 5, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 6, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 8, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();	
								
					}
					int[] sliding_scale_group_insert= pstmt_insert.executeBatch();

					for (int i=0;i<sliding_scale_group_insert.length ;i++ ){
						if(sliding_scale_group_insert[i]<0  && sliding_scale_group_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Sliding Scale Insertion Failed");
						 }
					}
				}
				//__end sliding_scale_template
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement( sql_ph_supportive_drugs_insert ) ;//Adding start for TH-KW-CRF-0007
				pstmt_insert.clearBatch();
				if(supportive_drugs.size()>0){
					for (int z=0;z<supportive_drugs.size();z++){
						    pstmt_insert.setString(1,(String) drugmastermain.get(0));
						    pstmt_insert.setString(2,(String) supportive_drugs.get(z));
							pstmt_insert.setInt(3,z+1);
							pstmt_insert.setString( 4, (String) mandatory_flds.get(0) ) ;// ADDED_BY_ID
							pstmt_insert.setString( 5, (String) mandatory_flds.get(1) ) ;// ADDED_AT_WS_NO
							pstmt_insert.setString( 6, (String) mandatory_flds.get(2) ) ;// ADDED_FACILITY_ID
							pstmt_insert.setString( 7, (String) mandatory_flds.get(3) ) ;// MODIFIED_BY_ID
							pstmt_insert.setString( 8, (String) mandatory_flds.get(4) ) ;//MODIFIED_AT_WS_NO
							pstmt_insert.setString( 9, (String) mandatory_flds.get(5) ) ;//MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();
					}
					int[] supportive_drugs_insert= pstmt_insert.executeBatch();

					for (int i=0;i<supportive_drugs_insert.length ;i++ ){
						if(supportive_drugs_insert[i]<0  && supportive_drugs_insert[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Supportive Drugs Insertion Failed");
						 }
				}//Adding end for TH-KW-CRF-0007
			 }
		/****Insert  of Trade,Inventory & Generic Ends***********/
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				connection.commit();
			}
			else{
				throw new EJBException("Ph Drug Updation Failed");
			}
		}
		catch( Exception e ) {
			try{
				messages.append( e.getMessage() ) ;
				
				System.out.println("1436"+ e.toString());
				connection.rollback();
				e.printStackTrace();
				map.put( "flag"," " ) ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", e.toString()) ;
				//throw new Exception( e.getMessage() ) ;
				return map;
			}
			catch ( Exception ee ) {
				ee.printStackTrace();
				messages.append( ee.getMessage() ) ;
				map.put( "flag"," " ) ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", e.toString()) ;
				return map;
			}
		} 
		finally{
			try {
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_delete ) ;
				closeStatement( pstmt_select ) ;//Added for TH-KW-CRF-0007
				closeResultSet( resultSet1 ) ;//Added for TH-KW-CRF-0007
				closeStatement( pstmt_comp_fluids_update ) ;
				closeStatement( pstmt_dflt_fluid_update ) ;
				closeConnection( connection,prop);
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid",messages.toString()) ;
		map.put( "flag", messages.toString() ) ;
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}
}
