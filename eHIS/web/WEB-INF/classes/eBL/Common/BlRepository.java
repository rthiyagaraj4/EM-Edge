/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version           TFS/Incident        SCF/CRF        		Developer Name
--------------------------------------------------------------------------------------------------------
1            V210131            13185         MMS-DM-CRF-0100.1       	Shikha Seth
2            V210211            12033         AMS-CRF-00249             Ram kumar S
3            V210310            12033         AMS-CRF-00249             Ram kumar S
4            V210420            16905         MOHE-SCF-0099      		Shikha Seth/Muthu
5			 V210614			19794       MMS-ME-SCF-0025-TF	   	Mohana Priya K
6			 V210818			21883		 MMS-ME-SCF-0031-TF			Mohana Priya K
7			V211027				18595	        MMS-DM-CRF-0185			      Mohana Priya K											
5		V211021 & V211026	    25297		PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link   Mohana Priya K
		 & V211103 &V211123
6			V211221				26886			Alpha-PMG2021-MMS-CRF-0004/01-All payer		Mohanapriya K
7			V220314				29635	  ATE-BL-Regression-PMG2021-MMS-CRF-0004-Specific payer Mohanapriya K
8			V220607							MMS-MD-SCF-0211					Mohanapriya K
9			V220628							MOHE-CRF-0114					Manivel Natarajan
10			V220728             28686         NMC-JD-SCF-0266           Manivel Natarajan
11			V221017						      MMS-DM-CRF-0209 			Namrata Charate
12			 V231128  			 51666 		   GHL-CRF-0642-US004			 Namrata Charate
--------------------------------------------------------------------------------------------------------
*/
package eBL.Common;
import java.util.*;
import java.util.HashMap;

public class BlRepository
{
	static
	{
		i = 0;
		dataMap = new HashMap();
		load();
	}

	/*Added by Karthik(15-Oct-2012) to retrieve Plain and direct Queries*/
	public static  String getBlKeyValue(String keyPlainSQL) throws Exception
	{
		return getValue(keyPlainSQL);
	}

	/*Added by Karthik(15-Oct-2012) to retrieve Plain and direct Queries*/
	private static String getValue(String keyPlainSQL) throws Exception {
		String resultQuery = "";
		try {
			resultQuery = (String)dataMap.get(keyPlainSQL);
			if(resultQuery == null)
				throw new Exception(keyPlainSQL + " : Key not found");
		}catch(Exception exception) {
			throw new Exception(keyPlainSQL + " : Key not found");
		}
		return resultQuery;
	}


	public static  String getBlKeyValue(String s,HashMap values,String called_for) throws Exception
	{
		return getValue(s,values,called_for);
	}

	private static String getValue(String s,HashMap values,String called_for) throws Exception
	{
		String s1 = "";

		String sql_blng_grp_lkup = "", sql_non_ins_blng_grp_lkup="", sql_ins_payer_lkup="", sql_non_ins_payer_lkup="", sql_credit_payer_lkup="", sql_sponsor_payer_lkup="", sql_ref_src_lkup="", sql_gl_holder_lkup="";
		//String sql_bl_patsearch_rights_code="";
		String sql_bl_patsearch_rights_code="",sql_bl_payer_grp ="",sql_bl_clinic_location="",sql_bl_charge_location="";
		String sqlFacilityIDLKUP ="" ,sqlEncounterIDLKUP1 ="" ,sqlEncounterIDLKUP2 ="" ,sqlEncounterIDLKUP3 ="" ,sqlEncounterIDLKUP4 =""; //V210420
		System.err.println("66, BlRepository.java");
		
		try
		{
			if(called_for.equals("BGLKUP"))
			{
				//V210211 Starts
				String ageValue = (String) values.get("AgeValidation");
				String ageFlag="";
				String ageValuereceived="";
				if(ageValue != null && !ageValue.equals("")){
					String[] ageVal=ageValue.split("~");
					ageValuereceived=ageVal[0];
					System.err.println("Age Val 0  "+ageVal[0]);
					ageFlag=ageVal[1];
					System.err.println("Age Val 1  "+ageVal[1]);
				}else{
					ageFlag="N";
				}
				//V210211 Ends
				
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				
				
				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";

				String episode_type = (String) values.get("episode_type");
				if(episode_type == null) episode_type = "";

				String function_id = (String) values.get("function_id");
				if(function_id == null) function_id = "";

				String blnggrp = (String) values.get("blnggrp");
				if(blnggrp == null) blnggrp = "";

				String encounter_date = (String) values.get("encounter_date");
				if(encounter_date == null) encounter_date = "";

				String citizen_yn = (String) values.get("citizen_yn");
				if(citizen_yn == null) citizen_yn = "";

				String ext_blng_grp = (String) values.get("ext_blng_grp");
				if(ext_blng_grp == null) ext_blng_grp = "";
				
				/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
				String restrictBlngGrp = (String) values.get("restrictBlngGrp");
				if(restrictBlngGrp == null) {
					restrictBlngGrp = "";
				}
				String blnggrp_Facility = (String) values.get("BlngGrpFacility");
				if(blnggrp_Facility == null) {
					blnggrp_Facility = "N";
				}
				String login_user = (String) values.get("login_user");
				if(login_user == null) {
					login_user = "";
				}
				/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
				/* Added V190508-Aravindh/GHL-CRF-0553/Starts */
				String siteSpecDispBlngGrpCatg 	= (String) values.get("siteSpecDispBlngGrpCatg");
				String billingGroupCatCode 		= (String) values.get("billingGroupCatCode");
				String slmtIndicator 			= (String) values.get("slmtIndicator");
				siteSpecDispBlngGrpCatg 		= siteSpecDispBlngGrpCatg == null ? "" : siteSpecDispBlngGrpCatg;
				billingGroupCatCode 			= billingGroupCatCode == null ? "" : billingGroupCatCode;
				slmtIndicator					= slmtIndicator == null ? "" : slmtIndicator;
				/* Added V190508-Aravindh/GHL-CRF-0553/Ends */

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String cash_leg = bl_labels.getString("eBL.CASH.label");
				String credit_leg = bl_labels.getString("eBL.CREDIT.label");
				String sponsor_leg = bl_labels.getString("eBL.SPONSOR.label");
				String ins_leg = common_labels.getString("Common.Insurance.label");

				sql_blng_grp_lkup = "select blng_grp_id blng_grp_id,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SRT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') CAP_REF_SRC_YN, nvl(REF_SOURCE_MAIN_MAND_YN,'N') REF_SRC_MN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,'N') REF_SRC_SB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,blcore.package_blng_grp_yn('"+facility_id+"','"+patient_id+"','"+episode_type+"','"+function_id+"',blng_grp_id,to_date('"+encounter_date+"','DD/MM/YYYY'),'B',DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED')) PKG_AVAIL_YN from BL_BLNG_GRP_LANG_VW a where (NVL(category,'UNRESTRICTED') IN (DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'),'UNRESTRICTED')) and language_id='"+locale+"' AND ";

				if(blnggrp.equals("1"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(hcare_only_yn,'N') = 'N' and nvl(status,'X' )!='S'";
				}
				else if(blnggrp.equals("2"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(ref_valid_for_regn_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(hcare_only_yn,'N') = 'N'" ;
				}
				else if(blnggrp.equals("3"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(op_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("4"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ip_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("5"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')= 'N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("6"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and blng_grp_id='"+ext_blng_grp+"'";
				}
				else if(blnggrp.equals("7"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ae_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("8"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(dy_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				//V210211 Starts
				if(ageFlag.equals("Y")) {
					sql_blng_grp_lkup = sql_blng_grp_lkup +  "AND  ( (nvl('"+ageValuereceived+"' ,0) between nvl(a.age_from,0) and nvl(a.age_to,999)  and nvl(a.AGE_REQ_YN,'N') = 'Y')  OR "+
						      "( nvl(a.AGE_REQ_YN,'N') = 'N' )) ";
				}
				//V210211 Ends
				
				/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
				if(restrictBlngGrp.equalsIgnoreCase("true")) {
					sql_blng_grp_lkup = sql_blng_grp_lkup + " and blng_grp_id NOT in (select b.blng_grp_id from BL_BLNG_GRP_RES_BY_USER b" +
							" where UPPER(b.user_id) = UPPER(NVL('"+login_user+"', b.user_id))" +
							" and b.blng_grp_id=a.blng_grp_id and trunc(sysdate) between b.restrict_date_From and nvl(b.restrict_date_to, trunc(sysdate))) ";
				}
				/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
				/* Added V190508-Aravindh/GHL-CRF-0553/Starts */
				if("true".equalsIgnoreCase(siteSpecDispBlngGrpCatg)) {
					if(!"".equals(billingGroupCatCode)) {
						sql_blng_grp_lkup = sql_blng_grp_lkup + " and blng_grp_id in (select c.blng_grp_id from BL_BLNG_GRP_BY_CATG c where c.BLNG_GRP_ID = a.blng_grp_id and c.BLNG_GRP_CATG = '"+billingGroupCatCode+"')";
					}
					if(!"".equals(slmtIndicator.trim())) {
						sql_blng_grp_lkup = sql_blng_grp_lkup + " and a.settlement_ind = '"+slmtIndicator+"'";
					}
				}
				/* Added V190508-Aravindh/GHL-CRF-0553/Ends */
				if(blnggrp_Facility.equals("Y")) {
					sql_blng_grp_lkup = sql_blng_grp_lkup + "AND  ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') "+
							"or ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY')='Y')) "+
							" and (blng_grp_id in (select blng_Grp_id from bl_blng_grp_facility where  facility_id ='"+facility_id+"'   ))) ";
				}
			}
			//Added by Rajesh V for CRF-0155
			else if(called_for.equals("BGLKUP_BG_PAYER"))
			{
				//V210211 Starts
				String ageValue = (String) values.get("AgeValidation");
				String ageFlag="";
				String ageValuereceived="";
				if(ageValue != null && !ageValue.equals("")){
					String[] ageVal=ageValue.split("~");
					ageValuereceived=ageVal[0];
					System.err.println("Age Val 0  "+ageVal[0]);
					ageFlag=ageVal[1];
					System.err.println("Age Val 1  "+ageVal[1]);
				}else{
					ageFlag="N";
				}
				//V210211 Ends
				
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";

				String episode_type = (String) values.get("episode_type");
				if(episode_type == null) episode_type = "";

				String function_id = (String) values.get("function_id");
				if(function_id == null) function_id = "";

				String blnggrp = (String) values.get("blnggrp");
				if(blnggrp == null) blnggrp = "";

				String encounter_date = (String) values.get("encounter_date");
				if(encounter_date == null) encounter_date = "";

				String citizen_yn = (String) values.get("citizen_yn");
				if(citizen_yn == null) citizen_yn = "";

				String ext_blng_grp = (String) values.get("ext_blng_grp");
				if(ext_blng_grp == null) ext_blng_grp = "";

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String cash_leg = bl_labels.getString("eBL.CASH.label");
				String credit_leg = bl_labels.getString("eBL.CREDIT.label");
				String sponsor_leg = bl_labels.getString("eBL.SPONSOR.label");
				String ins_leg = common_labels.getString("Common.Insurance.label");

				sql_blng_grp_lkup = "select blng_grp_id blng_grp_id,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SRT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') CAP_REF_SRC_YN, nvl(REF_SOURCE_MAIN_MAND_YN,'N') REF_SRC_MN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,'N') REF_SRC_SB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,blcore.package_blng_grp_yn('"+facility_id+"','"+patient_id+"','"+episode_type+"','"+function_id+"',blng_grp_id,to_date('"+encounter_date+"','DD/MM/YYYY'),'B',DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED')) PKG_AVAIL_YN from BL_BLNG_GRP_LANG_VW a where (NVL(category,'UNRESTRICTED') IN (DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'),'UNRESTRICTED')) and language_id='"+locale+"' AND UPPER(short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')') LIKE UPPER(?) AND ";

				if(blnggrp.equals("1"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(hcare_only_yn,'N') = 'N' and nvl(status,'X' )!='S'";
				}
				else if(blnggrp.equals("2"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(ref_valid_for_regn_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(hcare_only_yn,'N') = 'N'" ;
				}
				else if(blnggrp.equals("3"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(op_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("4"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ip_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("5"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')= 'N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("6"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and blng_grp_id='"+ext_blng_grp+"'";
				}
				else if(blnggrp.equals("7"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ae_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("8"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(dy_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				//V210211 Starts
				if(ageFlag.equals("Y")) {
					sql_blng_grp_lkup = sql_blng_grp_lkup +  "AND  ( (nvl('"+ageValuereceived+"' ,0) between nvl(a.age_from,0) and nvl(a.age_to,999)  and nvl(a.AGE_REQ_YN,'N') = 'Y')  OR "+
						      "( nvl(a.AGE_REQ_YN,'N') = 'N' )) ";
				}
				//V210211 Ends
				
			}
			else if(called_for.equals("BGLKUP_BG_PAYER_FOR_JS"))
			{
				//V210211 Starts
				String ageValue = (String) values.get("AgeValidation");
				String ageFlag="";
				String ageValuereceived="";
				if(ageValue != null && !ageValue.equals("")){
					String[] ageVal=ageValue.split("~");
					ageValuereceived=ageVal[0];
					System.err.println("Age Val 0  "+ageVal[0]);
					ageFlag=ageVal[1];
					System.err.println("Age Val 1  "+ageVal[1]);
				}else{
					ageFlag="N";
				}
				//V210211 Ends
				
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";

				String episode_type = (String) values.get("episode_type");
				if(episode_type == null) episode_type = "";

				String function_id = (String) values.get("function_id");
				if(function_id == null) function_id = "";

				String blnggrp = (String) values.get("blnggrp");
				if(blnggrp == null) blnggrp = "";

				String encounter_date = (String) values.get("encounter_date");
				if(encounter_date == null) encounter_date = "";

				String citizen_yn = (String) values.get("citizen_yn");
				if(citizen_yn == null) citizen_yn = "";

				String ext_blng_grp = (String) values.get("ext_blng_grp");
				if(ext_blng_grp == null) ext_blng_grp = "";


				sql_blng_grp_lkup = "select short_desc description,blng_grp_id code from BL_BLNG_GRP_LANG_VW a where (NVL(category,'UNRESTRICTED') IN (DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'),'UNRESTRICTED')) and language_id='"+locale+"' and  ";

				if(blnggrp.equals("1"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(hcare_only_yn,'N') = 'N' and nvl(status,'X' )!='S'";
				}
				else if(blnggrp.equals("2"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ref_yn,'N')='Y' and nvl(ref_valid_for_regn_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(hcare_only_yn,'N') = 'N'" ;
				}
				else if(blnggrp.equals("3"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(op_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("4"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ip_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("5"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')= 'N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("6"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(status,'X' )!='S' and blng_grp_id='"+ext_blng_grp+"'";
				}
				else if(blnggrp.equals("7"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(ae_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				else if(blnggrp.equals("8"))
				{
					sql_blng_grp_lkup = sql_blng_grp_lkup + "nvl(dy_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
				}
				
				//V210211 Starts
				if(ageFlag.equals("Y")) {
					sql_blng_grp_lkup = sql_blng_grp_lkup +  "AND  ( (nvl('"+ageValuereceived+"' ,0) between nvl(a.age_from,0) and nvl(a.age_to,999)  and nvl(a.AGE_REQ_YN,'N') = 'Y')  OR "+
						      "( nvl(a.AGE_REQ_YN,'N') = 'N' )) ";
				}
				//V210211 Ends
			}
			//Added by Rajesh V for CRF-0155
			else if (called_for.equals("NONINSBGLKUP"))
			{				
				//V210310 Starts
				String ageValue = (String) values.get("AgeValidation");
				String ageFlag="";
				String ageValuereceived="";
				if(ageValue != null && !ageValue.equals("")){
					String[] ageVal=ageValue.split("~");
					ageValuereceived=ageVal[0];
					System.err.println("Age Val 0  "+ageVal[0]);
					ageFlag=ageVal[1];
					System.err.println("Age Val 1  "+ageVal[1]);
				}else{
					ageFlag="N";
				}
				//V210310 Ends
				
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";

				String citizen_yn = (String) values.get("citizen_yn");
				if(citizen_yn == null) citizen_yn = "";

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String cash_leg = bl_labels.getString("eBL.CASH.label");
				String credit_leg = bl_labels.getString("eBL.CREDIT.label");
				String sponsor_leg = bl_labels.getString("eBL.SPONSOR.label");
				String ins_leg = common_labels.getString("Common.Insurance.label");
				
				/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
				String restrictBlngGrp = (String) values.get("restrictBlngGrp");
				if(restrictBlngGrp == null) {
					restrictBlngGrp = "";
				}
				String login_user = (String) values.get("login_user");
				if(login_user == null) {
					login_user = "";
				}
				/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */

				sql_non_ins_blng_grp_lkup = "select blng_grp_id BLG_GP,short_desc||'('||decode(settlement_ind||adm_rec_flag,'C','"+cash_leg+"','C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1','"+sponsor_leg+"','X2','"+ins_leg+"')||')' SRT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') CAPT_REF_SRC_DTL_YN, nvl(REF_SOURCE_MAIN_MAND_YN,'N') REF_SRC_MN_MAND_YN,nvl(REF_SOURCE_SUB_MAND_YN,'N') REF_SRC_SUB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw a where language_id='"+locale+"' and status is null and settlement_ind || adm_rec_flag != 'X2' and (('"+module_id+"'='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or ('"+module_id+"'='AE' and ae_yn = 'Y') or ('"+module_id+"'='OP' and op_yn = 'Y') or ('"+module_id+"'='IP' and ip_yn = 'Y') or ('"+module_id+"'='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE('"+citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'),'UNRESTRICTED')) AND NVL(PACKAGE_YN,'N')='N'";
				
				/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
				if(restrictBlngGrp.equalsIgnoreCase("true")) {
					sql_non_ins_blng_grp_lkup = sql_non_ins_blng_grp_lkup + " and blng_grp_id NOT in (select b.blng_grp_id from BL_BLNG_GRP_RES_BY_USER b" +
							" where UPPER(b.user_id) = UPPER(NVL('"+login_user+"', b.user_id))" +
							" and b.blng_grp_id=a.blng_grp_id and trunc(sysdate) between b.restrict_date_From and nvl(b.restrict_date_to, trunc(sysdate))) ";
				}
				/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
				
				//V210310 Starts
				if(ageFlag.equals("Y")) {
					sql_non_ins_blng_grp_lkup = sql_non_ins_blng_grp_lkup +  "AND  ( (nvl('"+ageValuereceived+"' ,0) between nvl(a.age_from,0) and nvl(a.age_to,999)  and nvl(a.AGE_REQ_YN,'N') = 'Y')  OR "+
						      "( nvl(a.AGE_REQ_YN,'N') = 'N' )) ";
				}
				//V210310 Ends
			}
			else if (called_for.equals("INSPAYERLKUP"))
			{
				String valid_cust_check = "", valid_pol_check = "";
				//Commented against MMS-DM-SCF-0729
				/*String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";*/
				//Commented against MMS-DM-SCF-0729

				String episode_type = (String) values.get("episode_type");
				if(episode_type == null) episode_type = "";

				String auto_fin_chk = (String) values.get("auto_fin_chk");
				if(auto_fin_chk == null) auto_fin_chk = "";

			//Commented against MMS-DM-SCF-0729
			/*	String cust_grp_code = (String) values.get("cust_grp_code");
				if(cust_grp_code == null) cust_grp_code = "";

				String class_code = (String) values.get("class_code");
				if(class_code == null) class_code = "";

				String blng_grp_id = (String) values.get("blng_grp_id");
				if(blng_grp_id == null) blng_grp_id = "";

				String search_by_items = (String) values.get("search_by_items");
				if(search_by_items == null) search_by_items = "";

				String search_code = (String) values.get("search_code");
				if(search_code == null) search_code = "";
				
				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";*/
				//Commented against MMS-DM-SCF-0729

				if(episode_type.equals("R"))
				{
					valid_cust_check = " and (?='MP' and a.ref_yn='Y') ";//Modified against MMS-DM-SCF-0729
					valid_pol_check=" and (?='MP' and nvl(c.external_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
				}
				else if(episode_type.equals("O"))
				{
					valid_cust_check = " and (?='OP' and a.op_yn='Y') ";//Modified against MMS-DM-SCF-0729
					valid_pol_check=" and (?='OP' and nvl(c.outpatient_cover,'N')='Y')";//Modified against MMS-DM-SCF-0729
				}
				else if(episode_type.equals("E"))
				{
					valid_cust_check = " and (?='AE' and a.op_yn='Y') ";//Modified against MMS-DM-SCF-0729
					valid_pol_check=" and (?='AE' and nvl(c.outpatient_cover,'N')='Y')";//Modified against MMS-DM-SCF-0729
				}
				else if(episode_type.equals("I"))
				{
					valid_cust_check = " and (?='IP' and a.ip_yn='Y') ";//Modified against MMS-DM-SCF-0729
					valid_pol_check=" and (?='IP' and nvl(c.inpatient_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
				}
				else if(episode_type.equals("D"))
				{
					valid_cust_check = " and (?='DC' and a.ip_yn='Y') ";//Modified against MMS-DM-SCF-0729
					valid_pol_check=" and (?='DC' and nvl(c.inpatient_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
				}

				if(auto_fin_chk.equals("Y"))
				{
					sql_ins_payer_lkup = "select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
					+" blcommon.getcntry(a.country_code,?) cny_nam, blcommon.getregn(a.region_code,?) rg_nam,"
					+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
					+" from AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,BL_APPL_BG_BY_CLASSFCTN f"
					+" where a.acc_entity_code=b.acc_entity_code"
					+" AND b.acc_entity_code=d.acc_entity_code"
					+" and a.language_id=b.language_id"
					+" and a.language_id=?"
					+" and d.cust_group_code=f.APPL_CUST_GROUP_CODE"
					+" AND b.cust_group_code =NVL(?,b.cust_group_code)"
					+" and f.APPL_CUST_GROUP_CODE=NVL(?,f.APPL_CUST_GROUP_CODE)"
					+" and f.CLASSIFICATION_CODE=?"
					+" and f.APPL_BLNG_GRP_ID=?"
					+" and a.cust_code=d.cust_code"
					+" and d.cust_code = f.APPL_CUST_CODE"
					+" and a.patient_flag='Y'"
					+" and NVL(a.pat_com_flag,'N')='N'"
					+" and nvl(a.insurance_yn,'Y')='Y'"
					+" and a.status is null"
					+valid_cust_check
					+" AND EXISTS (SELECT 'Y' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code)"
					+" AND decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl(?,decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";
					//Query Modified against MMS-DM-SCF-0729
				}
				else
				{
					/*sql_ins_payer_lkup = "select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
					+" blcommon.getcntry(a.country_code,'"+locale+"') cny_nam, blcommon.getregn(a.region_code,'"+locale+"') rg_nam,"
					+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
					+" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d"
					+" WHERE a.acc_entity_code= b.acc_entity_code"
					+" AND b.acc_entity_code= d.acc_entity_code"
					+" AND a.language_id = b.language_id"
					+" AND b.cust_group_code = d.cust_group_code"
					+" AND a.language_id='"+locale+"'"
					+" AND b.cust_group_code =NVL('"+cust_grp_code+"',b.cust_group_code)"
					+" AND a.cust_code = d.cust_code"
					+" AND a.patient_flag = 'Y'"
					+" AND NVL(a.pat_com_flag,'N') = 'N'"
					+" AND NVL(a.insurance_yn,'Y') = 'Y'"
					+" AND a.status IS NULL"
					+valid_cust_check
					+" AND EXISTS (SELECT 'Y' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code)"
					+" AND decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";*/
					sql_ins_payer_lkup = "select distinct d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
							+" blcommon.getcntry(a.country_code,?) cny_nam, blcommon.getregn(a.region_code,?) rg_nam,"
							+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
							+" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,bl_ins_policy_type_hdr c "
							+" WHERE a.acc_entity_code= b.acc_entity_code"
							+" AND b.acc_entity_code= d.acc_entity_code"
							+" AND a.language_id = b.language_id"
							+" AND b.cust_group_code = d.cust_group_code"
							+" AND operating_facility_id = ?"
							+" AND (c.cust_code = d.cust_code OR  c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code "
							+" AND a.language_id=?"
							+" AND b.cust_group_code = ?"
							//+" AND a.cust_group_code = '"+cust_grp_code+"'"
							+" AND a.cust_code = d.cust_code"
							+" AND a.patient_flag = 'Y'"
							+" AND NVL(a.pat_com_flag,'N') = 'N'"
							+" AND NVL(a.insurance_yn,'Y') = 'Y'"
							+" AND a.status IS NULL"
							+valid_cust_check							
							+" AND decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl(?,decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";
							//Query Modified against MMS-DM-SCF-0729
				}
			}
			else if (called_for.equals("CREDITPAYERLKUP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String auto_fin_chk = (String) values.get("auto_fin_chk");
				if(auto_fin_chk == null) auto_fin_chk = "";

				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";

				String blng_grp_id = (String) values.get("blng_grp_id");
				if(blng_grp_id == null) blng_grp_id = "";

				String class_code = (String) values.get("class_code");
				if(class_code == null) class_code = "";

				String cust_grp_code = (String) values.get("cust_grp_code");
				if(cust_grp_code == null) cust_grp_code = "";

				String search_by_items = (String) values.get("search_by_items");
				if(search_by_items == null) search_by_items = "";

				String search_code = (String) values.get("search_code");
				if(search_code == null) search_code = "";

				String select_cust_frm_pkg = (String) values.get("select_cust_frm_pkg");
				if(select_cust_frm_pkg == null) select_cust_frm_pkg = "";
				String site_id = (String) values.get("site_id");
				if(site_id == null) site_id = "";
			
				if(auto_fin_chk.equals("Y") )
				{
					if(site_id.equals("true")){
					

					sql_credit_payer_lkup = "select c.cust_code CUST_CODE,a.long_name LONG_NAME,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.long_desc LONG_DESC,b.short_desc CUST_GROUP_NAME,"
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
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and d.CLASSIFICATION_CODE='"+class_code+"'"
					+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
					+" and (d.APPL_CUST_GROUP_CODE='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'Y'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
					}else{
					
						sql_credit_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
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
								+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
								+" and d.CLASSIFICATION_CODE='"+class_code+"'"
								+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
								+" and (d.APPL_CUST_GROUP_CODE='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
								+" and a.patient_flag = 'Y'"
								+" and a.pat_com_flag = 'Y'"
								+" and nvl (insurance_yn,'N') = 'N'"
								+" and a.status is null"
								+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
								+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
								+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
								+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
					}	
				
				}
				else
				{
					if(site_id.equals("true")){

					sql_credit_payer_lkup = "select c.cust_code CUST_CODE,a.long_name LONG_NAME,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.long_desc LONG_DESC,b.short_desc CUST_GROUP_NAME,"
					+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
					+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
					+" where a.language_id = b.language_id"
					+" and a.language_id='"+locale+"'"
					+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
					+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
					+" and b.cust_group_code = c.cust_group_code"
					+" and a.cust_code = c.cust_code"
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'Y'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
				else{
				
					sql_credit_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
							+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
							+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
							+" where a.language_id = b.language_id"
							+" and a.language_id='"+locale+"'"
							+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
							+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
							+" and b.cust_group_code = c.cust_group_code"
							+" and a.cust_code = c.cust_code"
							+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
							+" and a.patient_flag = 'Y'"
							+" and a.pat_com_flag = 'Y'"
							+" and nvl (insurance_yn,'N') = 'N'"
							+" and a.status is null"
							+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
							+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
							+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
							+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
				}

				if(!select_cust_frm_pkg.equals(""))
				{
					StringTokenizer st = new StringTokenizer(select_cust_frm_pkg,"@@");
					ArrayList temp_al = new ArrayList();

					sql_credit_payer_lkup = sql_credit_payer_lkup + " and c.cust_code in ('";

					while(st.hasMoreElements())
					{
						temp_al.add((String)st.nextToken());
					}

					for(int i=0;i<temp_al.size();i++)
					{
						if(i != (temp_al.size()-1))
							sql_credit_payer_lkup = sql_credit_payer_lkup + temp_al.get(i) + "','";
						else
							sql_credit_payer_lkup = sql_credit_payer_lkup + temp_al.get(i) +"')";
					}
				}
			}
			else if (called_for.equals("SPONSORPAYERLKUP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String auto_fin_chk = (String) values.get("auto_fin_chk");
				if(auto_fin_chk == null) auto_fin_chk = "";

				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";

				String blng_grp_id = (String) values.get("blng_grp_id");
				if(blng_grp_id == null) blng_grp_id = "";

				String class_code = (String) values.get("class_code");
				if(class_code == null) class_code = "";

				String cust_grp_code = (String) values.get("cust_grp_code");
				if(cust_grp_code == null) cust_grp_code = "";

				String search_by_items = (String) values.get("search_by_items");
				if(search_by_items == null) search_by_items = "";

				String search_code = (String) values.get("search_code");
				if(search_code == null) search_code = "";

				String select_cust_frm_pkg = (String) values.get("select_cust_frm_pkg");
				if(select_cust_frm_pkg == null) select_cust_frm_pkg = "";
				
				String site_id = (String) values.get("site_id");
				if(site_id == null) site_id = "";

				if(auto_fin_chk.equals("Y"))
				{
					if(site_id.equals("true")){
					sql_sponsor_payer_lkup = "select c.cust_code CUST_CODE,a.long_name LONG_NAME,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.long_desc LONG_DESC,b.short_desc CUST_GROUP_NAME,"
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
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and d.CLASSIFICATION_CODE='"+class_code+"'"
					+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
					+" and (d.APPL_CUST_GROUP_CODE='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'N'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}else{
					sql_sponsor_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
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
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and d.CLASSIFICATION_CODE='"+class_code+"'"
					+" and d.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
					+" and (d.APPL_CUST_GROUP_CODE='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'N'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
			}
				else
				{
					if(site_id.equals("true")){
					sql_sponsor_payer_lkup = "select c.cust_code CUST_CODE,a.long_name LONG_NAME,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.long_desc LONG_DESC,b.short_desc CUST_GROUP_NAME,"
					+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
					+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
					+" where a.language_id = b.language_id"
					+" and a.language_id='"+locale+"'"
					+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
					+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
					+" and b.cust_group_code = c.cust_group_code"
					+" and a.cust_code = c.cust_code"
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'N'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}else{
					sql_sponsor_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
					+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
					+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
					+" where a.language_id = b.language_id"
					+" and a.language_id='"+locale+"'"
					+" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE"
					+" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE"
					+" and b.cust_group_code = c.cust_group_code"
					+" and a.cust_code = c.cust_code"
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'N'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
				}
				if(!select_cust_frm_pkg.equals(""))
				{
					StringTokenizer st = new StringTokenizer(select_cust_frm_pkg,"@@");
					ArrayList temp_al = new ArrayList();

					sql_sponsor_payer_lkup = sql_sponsor_payer_lkup + " and c.cust_code in ('";

					while(st.hasMoreElements())
					{
						temp_al.add((String)st.nextToken());
					}

					for(int i=0;i<temp_al.size();i++)
					{
						if(i != (temp_al.size()-1))
							sql_sponsor_payer_lkup = sql_sponsor_payer_lkup + temp_al.get(i) + "','";
						else
							sql_sponsor_payer_lkup = sql_sponsor_payer_lkup + temp_al.get(i) +"')";
					}
				}
			}
			else if(called_for.equals("NONINSCUSTLKUP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";

				String cust_grp_code = (String) values.get("cust_grp_code");
				if(cust_grp_code == null) cust_grp_code = "";

				String non_ins_slmt_ind = (String) values.get("non_ins_slmt_ind");
				if(non_ins_slmt_ind == null) non_ins_slmt_ind = "";

				String non_ins_adm_flag = (String) values.get("non_ins_adm_flag");
				if(non_ins_adm_flag == null) non_ins_adm_flag = "";

				String search_by_items = (String) values.get("search_by_items");
				if(search_by_items == null) search_by_items = "";

				String search_code = (String) values.get("search_code");
				if(search_code == null) search_code = "";

				if(non_ins_slmt_ind.equals("R"))
				{
					sql_non_ins_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
					+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
					+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
					+" where a.language_id = b.language_id"
					+" and a.language_id='"+locale+"'"
					+" and b.cust_group_code = c.cust_group_code"
					+" and a.cust_code = c.cust_code"
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'Y'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
				else if(non_ins_slmt_ind.equals("X") && non_ins_adm_flag.equals("1"))
				{
					sql_non_ins_payer_lkup = "select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
					+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC"
					+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
					+" where a.language_id = b.language_id"
					+" and a.language_id='"+locale+"'"
					+" and b.cust_group_code = c.cust_group_code"
					+" and a.cust_code = c.cust_code"
					+" and (b.cust_group_code='"+cust_grp_code+"' or '"+cust_grp_code+"' is null)"
					+" and a.patient_flag = 'Y'"
					+" and a.pat_com_flag = 'N'"
					+" and nvl (insurance_yn,'N') = 'N'"
					+" and a.status is null"
					+" and (('"+module_id+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
					+" or ('"+module_id+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
					+" or ('"+module_id+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))"
					+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
				}
			}
			else if(called_for.equals("REFSRCLKUP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String episode_type = (String) values.get("episode_type");
				if(episode_type == null) episode_type = "";

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String gov_leg = bl_labels.getString("eBL.GOVT_REFERRAL.label");
				String pvt_leg = bl_labels.getString("eBL.PVT_REFERRAL.label");

				sql_ref_src_lkup = "Select REFERRAL_CODE REFERRAL_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC,LONG_NAME LONG_NAME,decode(ORG_TYPE,'G','"+gov_leg+"','P','"+pvt_leg+"') ORG_TYPE from AM_REFERRAL_LANG_VW where (('"+episode_type+"' = 'R' and SOURCE_USE_AT_REGN_YN='Y') or ('"+episode_type+"' in ('O','E') and SOURCE_USE_AT_VISIT_YN ='Y') or ('"+episode_type+"' in ('I','D') and SOURCE_USE_AT_ADM_YN ='Y')) and language_id = '"+locale+"' and nvl(eff_status,'E')='E'";
			}
			else if(called_for.equals("GLHOLDERLKUP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";

				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";

				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";

				String slmt_ind = (String) values.get("slmt_ind");
				if(slmt_ind == null) slmt_ind = "";

				String encounter_date_time = (String) values.get("encounter_date_time");
				if(encounter_date_time == null) encounter_date_time = "";

				String module_id = (String) values.get("module_id");
				if(module_id == null) module_id = "";

				if(module_id.equals("OP") || module_id.equals("AE") || module_id.equals("IP") || module_id.equals("DC"))
				{
					sql_gl_holder_lkup = "SELECT DISTINCT credit_doc_ref_desc DOC_REF,TO_CHAR(credit_doc_ref_start_date,'dd/mm/yyyy') ST_DATE,TO_CHAR(credit_doc_ref_date,'dd/mm/yyyy') END_DATE,NVL(gl_holder_name,'') GL_NAME,NVL(cust_code,'') CUST_CODE,NVL(short_name,'') SHRT_DESC,NVL(CUST_GROUP_CODE,'') CUST_GRP_CODE,nvl(CUST_GROUP_DESC,'') cust_grp_desc, nvl(NO_OF_ENC_GL_VALID,'') NO_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_VALID,'') NO_OP_ENC_GL_VALID,nvl(NO_OF_AE_ENC_GL_VALID,'') NO_AE_ENC_GL_VALID,nvl(NO_OF_IP_ENC_GL_VALID,'') NO_IP_ENC_GL_VALID,nvl(NO_OF_DC_ENC_GL_VALID,'') NO_DC_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_AVAILED,'') NO_OP_ENC_GL_AVAILED,nvl(NO_OF_AE_ENC_GL_AVAILED,'') NO_AE_ENC_GL_AVAILED,nvl(NO_OF_IP_ENC_GL_AVAILED,'') NO_IP_ENC_GL_AVAILED,nvl(NO_OF_DC_ENC_GL_AVAILED,'') NO_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE operating_facility_id = '"+facility_id +"' AND language_id='"+locale+"' AND patient_id = '"+patient_id+"' AND settlement_ind = '"+slmt_ind+"' AND credit_doc_ref_date > trunc( to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI'))";
				}
				else
				{
					sql_gl_holder_lkup = "select '' DOC_REF,'' ST_DATE,'' END_DATE,' ' GL_NAME,' ' CUST_CODE,' ' SHRT_DESC,' ' CUST_GROUP_CODE,' ' CUST_GRP_DESC, ' ' NO_ENC_GL_VALID, ' ' NO_AE_ENC_GL_VALID, ' ' NO_OP_ENC_GL_VALID, ' ' NO_IP_ENC_GL_VALID, ' ' NO_DC_ENC_GL_VALID ,' ' NO_OP_ENC_GL_AVAILED,' ' NO_AE_ENC_GL_AVAILED,' ' NO_IP_ENC_GL_AVAILED,' ' NO_DC_ENC_GL_AVAILED FROM dual a WHERE 1=2";
				}
			}
			else if(called_for.equals("PATSEARCH"))
			{
				String rightsType = (String) values.get("rights_type");
				if(rightsType==null) {
					rightsType="S";
				}

				if(rightsType.equals("U")){
				sql_bl_patsearch_rights_code="select code,description from (select bl_user_id code, appl_user_name description from sm_appl_user, bl_user where bl_user_id = appl_user_id union select '**','All Users' from dual ) where upper(description) like upper(?) and upper(code) like upper(?)";
				}
				else if(rightsType.equals("G")){
				sql_bl_patsearch_rights_code="select code,description from (select user_group_id code,long_desc description from bl_user_group union select '**','All Groups' from dual ) where upper(description) like upper(?) and upper(code) like upper(?)";
				}
				else if(rightsType.equals("R")){
				sql_bl_patsearch_rights_code="select code,description from (select resp_id code, resp_name description from sm_resp union select '**','All Responsibilities' from dual ) where upper(description) like upper(?) and  upper(code) like upper(?)";
				}
				else{
				sql_bl_patsearch_rights_code="select code,description from (select bl_user_id code, appl_user_name description from sm_appl_user, bl_user where bl_user_id = appl_user_id union select '**','All Users' from dual ) where upper(description) like upper(?) and upper(code) like upper(?)";
				}
				}
            else if(called_for.equals("BLLOCATION"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";
				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";
//           	    sql_bl_charge_location = "SELECT SHORT_DESC,CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"'";

                sql_bl_charge_location = "SELECT SHORT_DESC,CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'";

			}
			else if(called_for.equals("BLCLINICLOCAT"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";
				String facility_id = (String) values.get("facility_id");
				if(facility_id == null) facility_id = "";
//           	    sql_bl_charge_location = "SELECT SHORT_DESC,CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"'";

                sql_bl_clinic_location = "SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'";

			}
			else if(called_for.equals("BLPAYERGRP"))
			{
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";
           	    sql_bl_payer_grp = "SELECT SHORT_DESC FROM AR_CUST_GROUP_LANG_VW where language_id = '"+locale+"'";

			}
			//V210420 start
			/*else if(called_for.equals("BLOPIPREP_FACILITY_ID_LKUP1")){ 
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";				
				String facility = (String) values.get("facility");
				if(facility == null) facility = "";
				sqlFacilityIDLKUP = "SELECT facility_id facility_id,facility_name facility_name FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"')  and upper(facility_id) = upper('"+facility+"')";
			}
			else if(called_for.equals("BLOPIPREP_FACILITY_ID_LKUP2")){ 
				String locale = (String) values.get("locale");
				if(locale == null) locale = "en";
				sqlFacilityIDLKUP = "SELECT facility_id facility_id,facility_name facility_name from( select '**' facility_id,'All Facility' facility_name  from dual union SELECT facility_id facility_id,facility_name facility_name FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"')) where 1=1";
			}
			else if(called_for.equals("BLOPIPREP_ENCOUNTER_ID_LKUP1")){ 
				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";
				String episodeType = (String) values.get("episodeType");
				if(episodeType == null) episodeType = "";
				String Effective_from = (String) values.get("Effective_from");
				if(Effective_from == null) Effective_from = "";
				String Effective_to = (String) values.get("Effective_to");
				if(Effective_to == null) Effective_to = "";
				sqlEncounterIDLKUP1 = "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID FROM pr_encounter WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('"+Effective_from+"','dd/MM/yyyy')) AND TRUNC (to_date('"+Effective_to+"','dd/MM/yyyy')) ";
			}
			else if(called_for.equals("BLOPIPREP_ENCOUNTER_ID_LKUP2")){	
				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";
				String episodeType = (String) values.get("episodeType");
				if(episodeType == null) episodeType = "";
				sqlEncounterIDLKUP2 = "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID FROM pr_encounter WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"'";			
			}
			else if(called_for.equals("BLOPIPREP_ENCOUNTER_ID_LKUP3")){				
				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";
				String episodeType = (String) values.get("episodeType");
				if(episodeType == null) episodeType = "";
				String Effective_from = (String) values.get("Effective_from");
				if(Effective_from == null) Effective_from = "";
				String Effective_to = (String) values.get("Effective_to");
				if(Effective_to == null) Effective_to = "";
				String facility = (String) values.get("facility");
				if(facility == null) facility = "";
				sqlEncounterIDLKUP3 = "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('"+Effective_from+"','dd/MM/yyyy')) AND TRUNC (to_date('"+Effective_to+"','dd/MM/yyyy'))  ";				
			}
			else if(called_for.equals("BLOPIPREP_ENCOUNTER_ID_LKUP4")){
				String patient_id = (String) values.get("patient_id");
				if(patient_id == null) patient_id = "";
				String episodeType = (String) values.get("episodeType");
				if(episodeType == null) episodeType = "";				
				String facility = (String) values.get("facility");
				if(facility == null) facility = "";
				sqlEncounterIDLKUP4 = "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' ";

			}*/
			//V210420 End
			//Assigning the Queries to the Respective Keys
			dataMap.put("SQL_BL_BLNG_GRP_LKUP", sql_blng_grp_lkup);
			dataMap.put("SQL_BL_NON_INS_BLNG_GRP_LKUP", sql_non_ins_blng_grp_lkup);
			dataMap.put("SQL_BL_INS_PAYER_LKUP", sql_ins_payer_lkup);
			dataMap.put("SQL_BL_NON_INS_PAYER_LKUP", sql_non_ins_payer_lkup);
			dataMap.put("SQL_BL_CREDIT_PAYER_LKUP", sql_credit_payer_lkup);
			dataMap.put("SQL_BL_SPONSOR_PAYER_LKUP", sql_sponsor_payer_lkup);
			dataMap.put("SQL_BL_REF_SRC_LKUP", sql_ref_src_lkup);
			dataMap.put("SQL_BL_GL_HOLDER_LKUP", sql_gl_holder_lkup);
			dataMap.put("SQL_BL_PATSEARCH_RIGHTS_CODE",sql_bl_patsearch_rights_code );
			//Charge Patient
			dataMap.put("SQL_BL_CHRG_LOCATION", sql_bl_charge_location);
			dataMap.put("SQL_BL_CLINIC_LOCATION", sql_bl_clinic_location);
			dataMap.put("SQL_BL_PAYER_GROUP", sql_bl_payer_grp);
			
			//V210420 Start
			/*dataMap.put("BLOPIPREP_FACILITY_ID_LKUP", sqlFacilityIDLKUP);
			dataMap.put("BLOPIPREP_ENCOUNTER_ID_LKUP1", sqlEncounterIDLKUP1);
			dataMap.put("BLOPIPREP_ENCOUNTER_ID_LKUP2", sqlEncounterIDLKUP2);
			dataMap.put("BLOPIPREP_ENCOUNTER_ID_LKUP3", sqlEncounterIDLKUP3);
			dataMap.put("BLOPIPREP_ENCOUNTER_ID_LKUP4", sqlEncounterIDLKUP4);
			System.err.println("sqlFacilityIDLKUP="+sqlFacilityIDLKUP);
			System.err.println("BLOPIPREP_ENCOUNTER_ID_LKUP1="+sqlEncounterIDLKUP1);
			System.err.println("BLOPIPREP_ENCOUNTER_ID_LKUP2="+sqlEncounterIDLKUP2);
			System.err.println("BLOPIPREP_ENCOUNTER_ID_LKUP3="+sqlEncounterIDLKUP3);
			System.err.println("BLOPIPREP_ENCOUNTER_ID_LKUP4="+sqlEncounterIDLKUP4);*/
//V210420 End
			s1 = (String)dataMap.get(s);

			if(s1 == null)
				throw new Exception(s + " : Key not found");
		}
		catch(Exception exception)
		{
			throw new Exception(s + " : Key not found");
		}
		return s1;
	}

	protected void finalize() throws Throwable
	{
		if(dataMap != null)
			dataMap = null;
	}

	private static void load()
	{
		//Plain Queries are added here
		dataMap.put("SQL_BL_PATSEARCH_RIGHTS_DATA","select  OPERATING_FACILITY_ID,RIGHTS_TYPE,RIGHTS_CODE,EFF_FROM_DATE,EFF_TO_DATE,APPL_TO_ALL_YN,APPL_TO_IP_YN,APPL_TO_DC_YN,APPL_TO_OP_YN,APPL_TO_EM_YN,APPL_TO_EX_YN,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE from bl_pat_search_rights");
		dataMap.put("SQL_BL_PAGE_PARAMS","select chunk_value,display_rec_per_page from ibaehis.bl_pat_search_param where operating_facility_id=");
		/*Added by karthik on 09-Nov-2012 for Calendar Module Begins*/
		dataMap.put("SQL_BL_WK_DAYTYPE_CODE","select sun_day_type_code,mon_day_type_code,tue_day_type_code,wed_day_type_code,thu_day_type_code,fri_day_type_code,sat_day_type_code from bl_parameters where operating_facility_id =");
		dataMap.put("SQL_BL_HOLIDAY_DETAILS","select C.CAL_DATE,C.DAY_TYPE_CODE,T.SHORT_DESC,C.REMARKS from BL_CALENDAR C,BL_DAY_TYPE T where C.DAY_TYPE_CODE=T.DAY_TYPE_CODE and  C.CAL_YEAR=? and to_char(C.CAL_DATE,'MM')=? order by C.CAL_DATE ASC");
		dataMap.put("SQL_BL_DAYTYPE_CODE_DESC","select DAY_TYPE_CODE,SHORT_DESC from bl_day_type");
		dataMap.put("SQL_BL_DAYTYPE_CODE_DESC_SRCH","select DAY_TYPE_CODE code,SHORT_DESC description  from  bl_day_type  where upper(SHORT_DESC) like upper(?) and  upper(DAY_TYPE_CODE) like upper(?)");
		dataMap.put("SQL_BL_CALENDAR_YEARS","select distinct(to_char(CAL_DATE,'YYYY')) as year from BL_CALENDAR order by year asc");
		/*Added by karthik on 09-Nov-2012 for Calendar Module Begins*/
		//Lookup Queries

		dataMap.put("FACILITY_LIST","SELECT FACILITY_ID CODE, FACILITY_NAME DESCRIPTION FROM SM_FACILITY_PARAM_LANG_VW ");
		dataMap.put("FUNCTION_ID_LOOKUP","SELECT FUNCTION_ID CODE, FUNCTION_NAME DESCRIPTION FROM SM_FUNCTION_LANG_VW");
		dataMap.put("BILL_GRP_ID_LOOKUP","SELECT BLNG_GRP_ID CODE, SHORT_DESC DESCRIPTION FROM BL_BLNG_GRP_LANG_VW");
		//Added on 5th Nov
		dataMap.put("BANNER_FORMAT_LOOKUP","SELECT BANNER_ID CODE, BANNER_DESC DESCRIPTION FROM BL_BANNER_HDR");
		dataMap.put("INFO_LOOKUP","SELECT INFO_NAME CODE, INFO_DESCRIPTION DESCRIPTION FROM BL_BANNER_INFO_DTLS");
		dataMap.put("STAT_LEG_LOOKUP","SELECT LEGEND_DESC code, LEGEND_DESC description FROM BL_BANNER_STATIC_INFO");
		dataMap.put("BL_USER_LOOKUP","select bl_user_id code, APPL_USER_NAME description FROM bl_user, SM_APPL_USER_LANG_VW");
		dataMap.put("BL_USER_GRP_LOOKUP","select USER_GROUP_ID code, SHORT_DESC description from BL_USER_GROUP_LANG_VW");
		dataMap.put("RESP_LOOKUP","select RESP_ID code, RESP_NAME description from SM_RESP_LANG_VW");
		dataMap.put("TOOLBAR_FORMAT_LOOKUP","SELECT FORMAT_CODE CODE, FORMAT_DESCRIPTION DESCRIPTION FROM BL_TOOLBAR_FORMAT_HDR");

		// Lookup queries for DAY TYPES AND TIME TYPES
		dataMap.put("DAY_TYPE_CODE_LOOKUP","SELECT DAY_TYPE_CODE code, SHORT_DESC DESCRIPTION FROM BL_DAY_TYPE_LANG_VW where upper(DAY_TYPE_CODE) like upper(?) and upper(short_desc) like upper(?) and  language_id= ");
		dataMap.put("TIME_TYPE_CODE_LOOKUP","SELECT TIME_TYPE_CODE code, SHORT_DESC DESCRIPTION FROM BL_TIME_TYPE_LANG_VW where upper(TIME_TYPE_CODE) like upper(?) and upper(short_desc) like upper(?) and  language_id= ");

		//Queries Added for Service Item Mapping
		dataMap.put("SERV_ITEM_LOOKUP_S","SELECT BLNG_SERV_CODE CODE, SHORT_DESC DESCRIPTION FROM BL_BLNG_SERV_LANG_VW ");
		dataMap.put("SERV_ITEM_LOOKUP_M","SELECT ITEM_CODE CODE, LONG_DESC DESCRIPTION FROM MM_ITEM_LANG_VW ");

		//Queries added for Payer Group - 22/11/2012
		dataMap.put("CUST_GROUP_LOOKUP","SELECT LANG.CUST_GROUP_CODE CODE, LANG.SHORT_DESC || \'-\' || CGROUP.SERV_GROUP_REQD_BY_PAYER DESCRIPTION " +
			"FROM AR_CUST_GROUP_LANG_VW LANG, AR_CUST_GROUP CGROUP ");
		dataMap.put("CUSTOMER_LOOKUP","SELECT CUST_CODE CODE, SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW ");
		dataMap.put("REF_HOSPITAL_LOOKUP","SELECT REFERRAL_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_REFERRAL_LANG_VW ");
		dataMap.put("PATIENT_CLASS_LIST","SELECT PATIENT_CLASS CODE, SHORT_DESC DESCRIPTION FROM AM_PATIENT_CLASS_LANG_VW ");
		dataMap.put("PAYMENT_BASIS_IND_LIST","SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) CODE, A.LIST_ELMT_VALUE DESCRIPTION FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B ");

		/*Added by karthik on 03-Dec-2012 for Service Groups/Classifications*/
		dataMap.put("SQL_BL_SERVICEGROUP", "select SERV_GRP_CODE,LONG_DESC,SHORT_DESC from bl_blng_serv_grp order by SERV_GRP_CODE");
		dataMap.put("SQL_BL_SERVICECLASSIFICATION", "select SERV_CLASSIFICATION_CODE,LONG_DESC,SHORT_DESC from bl_serv_classification  where SERV_CLASSIFICATION_CODE like (?)");

		//Queries added for Payer Service Group - 29/11/2012
		dataMap.put("PAYER_SERV_GRP_LOOKUP","SELECT PAYER_SERV_GRP_HDR CODE, SHORT_DESC DESCRIPTION FROM BL_PAYER_SERV_GRP_HDR_LANG_VW ");

		//Queries added for Set up Rule Factors - 18/12/2012
		dataMap.put("BILLING_CLASS_LOOKUP","SELECT BLNG_CLASS_CODE CODE, SHORT_DESC DESCRIPTION FROM  BL_BLNG_CLASS_LANG_VW ");
		dataMap.put("BILLING_RULE_LOOKUP","SELECT  BLNG_CLASS_CODE CODE, SHORT_DESC DESCRIPTION FROM  BL_BLNG_CLASS_LANG_VW BCLASS ");
		dataMap.put("DATE_TYPE_LOOKUP","SELECT DAY_TYPE_CODE CODE, SHORT_DESC DESCRIPTION FROM BL_DAY_TYPE_LANG_VW DAYTYPE ");
		dataMap.put("TIME_TYPE_LOOKUP","SELECT TIME_TYPE_CODE CODE, SHORT_DESC DESCRIPTION FROM  BL_TIME_TYPE_LANG_VW TIMETYPE ");
		dataMap.put("BILLING_SERVICE_LOOKUP","SELECT BLNG_SERV_CODE CODE, SHORT_DESC  DESCRIPTION FROM BL_BLNG_SERV_LANG_VW ");
		dataMap.put("OPTION_LIST","SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) CODE, A.LIST_ELMT_VALUE DESCRIPTION FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL'" +
				" AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'BLSSLRUL_ND_OPTION' ");

		// queries for Package Grouping
		dataMap.put("SERV_ITEM_LOOKUP_SELECT_S","SELECT LONG_DESC , BLNG_SERV_CODE FROM BL_BLNG_SERV_LANG_VW WHERE BLNG_SERV_CODE = ");
		dataMap.put("SERV_ITEM_LOOKUP_SELECT_G","SELECT LONG_DESC , SERV_GRP_CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE SERV_GRP_CODE = ");
		dataMap.put("SERV_ITEM_LOOKUP_SELECT_C","SELECT LONG_DESC , SERV_CLASSIFICATION_CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE SERV_CLASSIFICATION_CODE = ");
		dataMap.put("SERV_ITEM_LOOKUP_SELECT_T","SELECT LONG_DESC , SALE_CATEGORY_CODE FROM BL_ST_ITEM_SAL_CAT_HDR_LANG_VW WHERE SALE_CATEGORY_CODE = ");
		dataMap.put("SERV_ITEM_LOOKUP_SELECT_M","SELECT LONG_DESC , ITEM_CODE FROM BL_MM_ITEM_VW WHERE ITEM_CODE = ");

		dataMap.put("SERV_ITEM_LOOKUP_S_NEW","SELECT BLNG_SERV_CODE CODE, LONG_DESC DESCRIPTION FROM BL_BLNG_SERV_LANG_VW WHERE upper(BLNG_SERV_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND LANGUAGE_ID = ");
		dataMap.put("SERV_ITEM_LOOKUP_G_NEW","SELECT SERV_GRP_CODE CODE , LONG_DESC DESCRIPTION FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(SERV_GRP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND  LANGUAGE_ID = ");
		dataMap.put("SERV_ITEM_LOOKUP_C_NEW","SELECT SERV_CLASSIFICATION_CODE CODE , LONG_DESC DESCRIPTION  FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE upper(SERV_CLASSIFICATION_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND  LANGUAGE_ID = ");
		dataMap.put("SERV_ITEM_LOOKUP_T_NEW","SELECT SALE_CATEGORY_CODE CODE , LONG_DESC DESCRIPTION FROM BL_ST_ITEM_SAL_CAT_HDR_LANG_VW WHERE upper(SALE_CATEGORY_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND  LANGUAGE_ID = ");
		dataMap.put("SERV_ITEM_LOOKUP_M_NEW","SELECT ITEM_CODE CODE , LONG_DESC DESCRIPTION  FROM BL_MM_ITEM_VW  WHERE upper(ITEM_CODE) like upper(?) and upper(LONG_DESC) like upper(?) ");

		//queries added for Discharge Billing rule

		dataMap.put("BILLING_GROUP_LOOKUP","SELECT BLNG_GRP_ID CODE, SHORT_DESC DESCRIPTION FROM BL_BLNG_GRP_LANG_VW ");
		dataMap.put("POLICY_TYPE_LOOKUP","SELECT HDR.POLICY_TYPE_CODE CODE, PTYPE.SHORT_DESC DESCRIPTION FROM BL_INS_POLICY_TYPE_HDR HDR, BL_INS_POLICY_TYPES_LANG_VW PTYPE ");
		dataMap.put("CUSTOMER_GROUP_LOOKUP","SELECT CUST_GROUP_CODE CODE, SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW LANG ");

		//Description queries for Discharge Billing Rule

		dataMap.put("CUST_GRP_DESC_SQL","SELECT SHORT_DESC FROM AR_CUST_GROUP_LANG_VW ");
		dataMap.put("CUST_DESC_SQL","SELECT SHORT_NAME FROM AR_CUSTOMER_LANG_VW ");
		dataMap.put("POLICY_TYPE_DESC_SQL","SELECT SHORT_DESC FROM  BL_INS_POLICY_TYPES_LANG_VW ");
		dataMap.put("BILLING_CLASS_DESC_SQL","SELECT SHORT_DESC FROM  BL_BLNG_CLASS_LANG_VW ");
		dataMap.put("BILLING_GROUP_DESC_SQL","SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW ");

		// queries for Billing Group Category
		dataMap.put("BILLING_GRP_CATEGORY","SELECT DISTINCT A.BLNG_GRP_ID FROM  BL_BLNG_GRP_BY_CATG A ,BL_BLNG_GRP_CATG B WHERE  A.BLNG_GRP_CATG = B.BLNG_GRP_CATG AND  A.BLNG_GRP_CATG=");
		dataMap.put("BILLING_GRP_CATEGORY_DESC","SELECT DISTINCT BLNG_GRP_ID, SHORT_DESC ,DETAIL_DESC FROM BL_BLNG_GRP A WHERE  BLNG_GRP_ID =");
		dataMap.put("BILLING_GRP_CATEGORY_DESC_ALL","SELECT DISTINCT BLNG_GRP_ID CODE, SHORT_DESC DESCRIPTION ,DETAIL_DESC DETAILDESCRIPTION FROM BL_BLNG_GRP_LANG_VW  WHERE upper(BLNG_GRP_ID) like upper(?) and upper(SHORT_DESC) like upper(?) AND  LANGUAGE_ID = ");

		// queries for Maintain Previlage Card

		//dataMap.put("Billing_Previlage_Card_Patient_SQL","SELECT CARD_TYPE_CODE,PRICE_CLASS_CODE,EFFECTIVE_FROM,EFFECTIVE_TO,HCARD_PRICE,NO_OF_OP_VISITS_ALLOWED,NO_OF_OP_VISITS_UTILIZED,HCARD_SEQ_NO FROM BL_HCARD_SUB_HDR WHERE PRIMARY_PATIENT_ID = ");
		dataMap.put("Billing_Previlage_Card_Patient_SQL","SELECT CARD_TYPE_CODE,PRIMARY_PATIENT_ID, PRICE_CLASS_CODE, EFFECTIVE_FROM, EFFECTIVE_TO,HCARD_PRICE, NO_OF_OP_VISITS_ALLOWED, NO_OF_OP_VISITS_UTILIZED,HCARD_SEQ_NO,PACKAGE_CODE,BLNG_SERV_CODE FROM BL_HCARD_SUB_HDR WHERE PRIMARY_PATIENT_ID = 'VALUE1' UNION SELECT A.CARD_TYPE_CODE,A.PRIMARY_PATIENT_ID, A.PRICE_CLASS_CODE, A.EFFECTIVE_FROM, A.EFFECTIVE_TO, A.HCARD_PRICE, A.NO_OF_OP_VISITS_ALLOWED, A.NO_OF_OP_VISITS_UTILIZED,A.HCARD_SEQ_NO,A.PACKAGE_CODE,BLNG_SERV_CODE FROM BL_HCARD_SUB_HDR A, BL_HCARD_SUB_DTL B WHERE A.HCARD_SEQ_NO = B.HCARD_SEQ_NO AND B.ADDITIONAL_PATIENT_ID = 'VALUE2' ORDER BY EFFECTIVE_TO DESC");
		dataMap.put("Billing_Previlage_Card_Detail_SQL","SELECT SHORT_DESC FROM BL_HCARD_HDR WHERE CARD_TYPE_CODE = ");
		dataMap.put("Billing_Previlage_Price_Class_Detail_SQL","SELECT LONG_DESC FROM BL_PRICE_CLASS_LANG_VW WHERE PRICE_CLASS_CODE = ");
		dataMap.put("Billing_Previlage_Patient_Detail_SQL","SELECT SHORT_NAME FROM MP_PATIENT_MAST WHERE PATIENT_ID = ");
		dataMap.put("Billing_Previlage_Clinic_Visit_Detail_SQL","SELECT A.VISIT_TYPE_CODE, A.SHORT_DESC FROM OP_VISIT_TYPE_LANG_VW A WHERE A.EFF_STATUS = 'E' AND A.LANGUAGE_ID =  ");
		dataMap.put("Billing_Previlage_Clinic_Detail_SQL","SELECT CLINIC_CODE, SHORT_DESC FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = ");
		dataMap.put("Billing_Previlage_AdditionalPatient_SQL","SELECT ADDITIONAL_PATIENT_ID FROM BL_HCARD_SUB_DTL WHERE HCARD_SEQ_NO = ");
		dataMap.put("Billing_Previlage_Visit_Utilize_SQL","SELECT VISIT_TYPE_CODE,CLINIC_CODE,NO_OF_VISITS_ALLOWED, NO_OF_VISITS_UTILIZED FROM BL_HCARD_SUBS_VISIT_DTL WHERE OPERATING_FACILITY_ID =");
		dataMap.put("Billing_Previlage_Price_Class_DROPDOWN_SQL","SELECT PRICE_CLASS_CODE, LONG_DESC FROM BL_PRICE_CLASS_LANG_VW WHERE PRICE_CLASS_CODE  in (SELECT DISTINCT(PRICE_CLASS_CODE) FROM bl_hcard_dtl WHERE CARD_TYPE_CODE = '@CARDTYPECODE' ) AND LANGUAGE_ID =");
		dataMap.put("Billing_Previlage_Additional_Patient_Price_Class_SQL","SELECT   B.PRICE_CLASS_CODE FROM BL_HCARD_SUB_HDR A, BL_HCARD_SUB_DTL B   WHERE A.HCARD_SEQ_NO = ");
		dataMap.put("Billing_Previlage_OP_Visit_Utilization_Details_SQL","SELECT   NO_OF_OP_VISITS_ALLOWED,NO_OF_OP_VISITS_UTILIZED FROM BL_HCARD_SUB_HDR WHERE PRIMARY_PATIENT_ID = '@patientId' AND  HCARD_SEQ_NO = '@hcardSeqNo' UNION SELECT  A.NO_OF_OP_VISITS_ALLOWED, A.NO_OF_OP_VISITS_UTILIZED  FROM BL_HCARD_SUB_HDR A, BL_HCARD_SUB_DTL B WHERE A.HCARD_SEQ_NO = B.HCARD_SEQ_NO AND B.ADDITIONAL_PATIENT_ID = '@patientId1' AND A.HCARD_SEQ_NO = '@hcardSeqNo1'  ");

		// Queries for HealthCard Master - Added by Karthik on 22-Jan-2013 Starts
		dataMap.put("BL_HEALTHCARD_HEADER","select LONG_DESC,SHORT_DESC,VALID_DAYS,EFFECTIVE_FROM,EFFECTIVE_TO,STATUS,NO_OF_OP_VISITS,NO_OF_PAT_ALLOWED from bl_hcard_hdr  where CARD_TYPE_CODE=?");
		dataMap.put("BL_HEALTHCARD_AGEDETAILS", "select FROM_AGE_DAYS,FROM_AGE_MONTH,FROM_AGE_YRS,TO_AGE_DAYS,TO_AGE_MONTH,TO_AGE_YRS,BLNG_SERV_CODE,PRICE_CLASS_CODE from bl_hcard_dtl  where CARD_TYPE_CODE=? order by FROM_AGE_YRS");
		dataMap.put("BL_HEALTHCARD_VISITDETAILS","select CLINIC_CODE,VISIT_TYPE_CODE,NO_OF_VISITS_ALLOWED from bl_hcard_visit_rule  where CARD_TYPE_CODE=?");
		dataMap.put("BL_HEALTHCARD_GROUPDETAILS", "select A.BLNG_GRP_ID,B.short_desc from bl_hcard_cash_blnggrp_dtl A,bl_blng_grp_lang_vw B where A.BLNG_GRP_ID=B.BLNG_GRP_ID AND B.language_id='en' AND A.CARD_TYPE_CODE=?");
		dataMap.put("BL_HEALTHCARD_PRICE_LOOKUP", "select price_class_code code, short_desc description from bl_price_class_lang_vw where language_id='en' and upper(price_class_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2");
		dataMap.put("BL_HEALTHCARD_SERVICE_LOOKUP", "select blng_serv_code code, short_desc description from bl_blng_serv_lang where language_id='en' and upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2");
		dataMap.put("BL_HEALTHCARD_CLINIC_LOOKUP", "select clinic_code code, short_desc description from op_clinic_lang_vw where LANGUAGE_ID ='en' and FACILITY_ID = 'HS' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2");
		dataMap.put("BL_HEALTHCARD_VISIT_LOOKUP", "select A.visit_type_code code, A.short_desc description from op_visit_type_lang_vw A, op_visit_type_for_clinic B where A.FACILITY_ID = B.FACILITY_ID and A.VISIT_TYPE_CODE = B.VISIT_TYPE_CODE and B.FACILITY_ID = 'HS' and A.LANGUAGE_ID = 'en' and A.EFF_STATUS = 'E'	and B.EFF_STATUS = 'E' and upper(A.visit_type_code) like upper(?) and upper(A.short_desc) like upper(?) and B.CLINIC_CODE = ");
		dataMap.put("BL_HEALTHCARD_BLNGGRP_LOOKUP", "select code, description from  ( select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='en' and  (status is null or status != 'S') and SETTLEMENT_IND='C' ) where  upper(code) like upper(?) and upper(description) like upper(?)  ORDER BY 2");
		dataMap.put("BL_HEALTHCARD_DEFN_QRYRESULT","select card_type_code,long_desc,status,effective_from,effective_to from bl_hcard_hdr");
  		dataMap.put("BL_HEALTHCARD_PRICE_CODE_DESC", "select  short_desc   from bl_price_class_lang_vw where language_id='en' and OPERATING_FACILITY_ID = 'HS'  and price_class_code=?");
		dataMap.put("BL_HEALTHCARD_SERVICE_CODE_DESC", "select  short_desc from bl_blng_serv_lang where language_id='en' and ADDED_FACILITY_ID='HS' and BLNG_SERV_CODE = ?");
		dataMap.put("BL_HEALTHCARD_CLINIC_CODE_DESC", "select  short_desc   from op_clinic_lang_vw where language_id='en' and FACILITY_ID = 'HS' and CLINIC_CODE=?");
		dataMap.put("BL_HEALTHCARD_VISITTYPE_CODE_DESC", "select  short_desc   from op_visit_type_lang_vw where language_id='en' and FACILITY_ID = 'HS'and VISIT_TYPE_CODE=?");

		// Queries for HealthCard Master - Added by Karthik on 24-Jan-2013 Ends

		//Healthcard Subscription - Rajesh V
		dataMap.put("BL_HEALTHCARDSUBS_PATHDR","{ ? = call  get_patient_line(?,?)}");
		dataMap.put("BL_HEALTHCARDSUBS_GETDOB","{ ? = call  IBAEHIS.blhealthcard.get_dob(?,sysdate)}");
		dataMap.put("BL_HEALTHCARDSUBS_CARDDTL","select bhd.price_class_code,bps.long_desc,bhh.valid_days,to_char(bhh.effective_from,'dd/mm/yyyy') eff_from,to_char(bhh.effective_to,'dd/mm/yyyy') eff_to from bl_hcard_dtl bhd, bl_price_class bps,bl_hcard_hdr bhh where bhd.operating_facility_id = ? and bhd.card_type_code = ?  and bhd.card_type_code = bhh.card_type_code and bhd.price_class_code = bps.price_class_code and  lpad(to_char(?),3,'0')||lpad(to_char(?),2,'0')||lpad(to_char(?),3,'0') between lpad(to_char(from_age_yrs),3,'0')||lpad(to_char(from_age_month),2,'0')||lpad(to_char(from_age_days),3,'0') and lpad(to_char(to_age_yrs),3,'0')||lpad(to_char(to_age_month),2,'0')||lpad(to_char(to_age_days),3,'0')");
		dataMap.put("BL_HEALTHCARDSUBS_TODATE","select to_char(to_date(?,'dd/mm/yyyy')+?,'dd/mm/yyyy') todat from dual");
		dataMap.put("BL_HEALTHCARDSUBS_SERVPRICE","{ ? = call  IBAEHIS.blhealthcard.get_serv_price(?,?,?,?,?)}");
		dataMap.put("BL_HEALTHCARDSUBS_CARDDESC","SELECT SHORT_DESC DESCRIPTION, CARD_TYPE_CODE CODE FROM  BL_HCARD_HDR WHERE STATUS = 'Y' AND UPPER(CARD_TYPE_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1");
		//Healthcard Subscription - Rajesh V


		/* queries for Customer Specfic Desc Master by Boopathy Starts Here */
		dataMap.put("CUST_GROUP_CODE_LOOKUP",		"SELECT CUST_GROUP_CODE CODE,LONG_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND STATUS IS NULL  AND LANGUAGE_ID =  ");
		dataMap.put("CUST_CODE_LOOKUP",				"SELECT CUST_CODE CODE, LONG_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(LONG_NAME) like upper(?) AND STATUS IS NULL AND CUST_GROUP_CODE =  ");
		dataMap.put("BLNG_GROUP_ID_LOOKUP",			"SELECT BLNG_GRP_ID CODE, LONG_DESC DESCRIPTION FROM BL_BLNG_GRP_LANG_VW WHERE upper(BLNG_GRP_ID) like upper(?) and upper(LONG_DESC) like upper(?)  AND SETTLEMENT_IND = 'C' AND STATUS IS NULL AND LANGUAGE_ID = ");
		dataMap.put("BLNG_SERV_CODE_LOOKUP",		"SELECT BLNG_SERV_CODE CODE , LONG_DESC DESCRIPTION FROM BL_BLNG_SERV_LANG_VW WHERE upper(BLNG_SERV_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID = ");
		dataMap.put("CASH_BLNG_GROUP_ID_LOOKUP",	"SELECT BLNG_GRP_ID CODE, LONG_DESC DESCRIPTION FROM BL_BLNG_GRP_LANG_VW WHERE upper(BLNG_GRP_ID) like upper(?) and upper(LONG_DESC) like upper(?)  AND SETTLEMENT_IND = 'C' AND STATUS IS NULL AND LANGUAGE_ID = ");

		/* queries for Customer Specfic Desc Master by Boopathy Ends Here */



		/* queries for Panel Setup Master by Boopathy Starts Here */
		dataMap.put("PANEL_CATEGORIES_MASTER",		"SELECT PANEL_CATEGORY_CODE, LONG_DESC, SHORT_DESC  FROM BL_BLNG_PANEL_CATEGORY WHERE ADDED_FACILITY_ID =  ");

		/* queries for Panel Setup  Master by Boopathy Ends Here */


		/* queries for Panel Setup Master by Boopathy Starts Here */
		dataMap.put("PANEL_CATEGORIES_MASTER",							"SELECT PANEL_CATEGORY_CODE, LONG_DESC, SHORT_DESC  FROM BL_BLNG_PANEL_CATEGORY WHERE ADDED_FACILITY_ID =  ");
		dataMap.put("PANEL_DETAILS_HEADER",								"SELECT PANEL_CODE,PANEL_CATEGORY_CODE, LONG_DESC, SHORT_DESC,ADD_SERVICES_DURING_ENTRY  FROM BL_PANEL_HDR WHERE ADDED_FACILITY_ID =");
		dataMap.put("PANEL_CONSTITUENTS_DETAILS",						"SELECT PANEL_CODE,PANEL_SRL,BLNG_SERV_CODE,REQD_QTY,MODIFY_QTY_DURING_ENTRY FROM BL_PANEL_DTL WHERE ADDED_FACILITY_ID='@facilityId' AND PANEL_CODE='@panelCode' ORDER BY PANEL_SRL");
		dataMap.put("BILLING_SERVICE_DESC_FOR_PANEL_CONSTITUENTS",		"SELECT LONG_DESC  FROM BL_BLNG_SERV_LANG_VW WHERE  BLNG_SERV_CODE='@billingServiceCode' AND LANGUAGE_ID='@locale' ");
		dataMap.put("BILLING_PANEL_CODE_LOOKUP",						"SELECT PANEL_CODE CODE,SHORT_DESC DESCRIPTION FROM BL_PANEL_HDR WHERE upper(PANEL_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)");
		dataMap.put("BILLING_PANEL_INYERCOMPANY_FROM_FACILITY_DROPDOWN","SELECT DISTINCT OPERATING_FACILITY_ID  FROM BL_INTER_FACILITY_SERVICE");
		dataMap.put("BILLING_PANEL_INYERCOMPANY_TO_FACILITY_DROPDOWN",  "SELECT DISTINCT PERFORMING_FACILITY_ID FROM BL_INTER_FACILITY_SERVICE");
		dataMap.put("BILLING_PANEL_INYERCOMPANY_FACILITY_DESC_DROPDOWN","SELECT FACILITY_NAME FROM SM_FACILITY WHERE  FACILITY_ID = '@facilityId' ");
		/* queries for Panel Setup  Master by Boopathy Ends Here */


		/* queries for Record Pre Approval added by Boopathy Starts Here */
		dataMap.put("EPISODE_TYPE_RECORD_PREAPPROVAL",				"SELECT EPISODE_ID,VISIT_ID,PATIENT_ID FROM BL_VISIT_FIN_DTLS WHERE OPERATING_FACILITY_ID = ");
		dataMap.put("EPISODE_TYPE_DROPDOWN",						"SELECT PATIENT_CLASS , SHORT_DESC FROM AM_PATIENT_CLASS  WHERE  PATIENT_CLASS != 'XT'   ");
		dataMap.put("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL",		"SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM BL_VISIT_FIN_DTLS WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ");
		dataMap.put("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL", 		"SELECT LONG_DESC DESCRIPTION , CUST_GROUP_CODE CODE FROM AR_CUST_GROUP_LANG_VW WHERE upper(LONG_DESC) like upper(?) and upper(CUST_GROUP_CODE) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID = ");
		dataMap.put("PAYER_LOOKUP_RECORD_PREAPPROVAL", 				"SELECT LONG_NAME DESCRIPTION , CUST_CODE CODE FROM AR_CUSTOMER_LANG_VW WHERE upper(LONG_NAME) like upper(?) and upper(CUST_CODE) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID = ");
		dataMap.put("POLICY_LOOKUP_RECORD_PREAPPROVAL", 			"SELECT LONG_DESC DESCRIPTION , POLICY_TYPE_CODE CODE FROM BL_INS_POLICY_TYPES_LANG_VW WHERE upper(LONG_DESC) like upper(?) and upper(POLICY_TYPE_CODE) like upper(?) AND NVL(STATUS,'A') !='S' AND OPERATING_FACILITY_ID = ");
		dataMap.put("RECORD_PREAPPROVAL_PATIENT_DATA",	 			"SELECT   ROWID, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, EFFECTIVE_FROM, EFFECTIVE_TO,POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID,APPROVED_AMT,ACCT_SEQ_NO,ENCOUNTER_ID FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE PATIENT_ID = '@patientId' AND EPISODE_TYPE = '@episodeType' AND OPERATING_FACILITY_ID = '@facilityId' AND ACCT_SEQ_NO =(SELECT MAX (ACCT_SEQ_NO)FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE OPERATING_FACILITY_ID = '@facilityId1' AND PATIENT_ID = '@patientId1' AND EPISODE_TYPE = '@episodeType1' AND EPISODE_ID = '@episodeId' AND VISIT_ID = '@visitId') AND EPISODE_ID = '@episodeId1'  AND visit_id = '@visitId1' AND POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL ORDER BY PRIORITY");
		dataMap.put("PRE_APPROVAL_REQUEST_DETAILS",	 				"SELECT ROWID, SERV_EXCL_INCL_CRIT, BLNG_SERV_CODE, PRE_APP_NUM, APP_REQ_DATE,APP_GIVEN_DATE, PRE_APP_REMARK, PRE_APP_STATUS, ADDED_BY_ID,MODIFIED_BY_ID, ADDED_DATE, MODIFIED_DATE, ADDED_AT_WS_NO,MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_FACILITY_ID,OPERATING_FACILITY_ID, ACCT_SEQ_NO, CUST_CODE, PATIENT_ID,EPISODE_TYPE, EPISODE_ID, VISIT_ID, POLICY_TYPE_CODE, CUST_GROUP_CODE,PRIORITY, BLNG_GRP_ID, POLICY_NUMBER, EFFECTIVE_FROM, STATUS, AVAIL_SERV_AMT, REASON_CODE FROM BL_INS_BLNG_SERV_PREAPP WHERE PATIENT_ID = '@patientId'   AND OPERATING_FACILITY_ID = '@facilityId'   AND EPISODE_TYPE = '@episodeType' AND PRE_APP_STATUS= '@requestStatus'   AND BL_INS_BLNG_SERV_PREAPP.ACCT_SEQ_NO = @acctSeqNo   AND (PATIENT_ID = '@patientId1')   AND (EPISODE_ID = '@episodeId')   AND (VISIT_ID = '@visitId')   AND (PRIORITY = '@priority')");
		dataMap.put("PRE_APPROVAL_REQUEST_PATIENTNAME_AND_MOBILE",	"SELECT SHORT_NAME, OTHER_CONTACT_NUM FROM MP_PATIENT_MAST WHERE PATIENT_ID = ");
		dataMap.put("PRE_APPROVAL_REQUEST_PATIENT_AGE",				"SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) YEAR,TRUNC(MOD(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH),12)) MONTH,TRUNC(SYSDATE-ADD_MONTHS(DATE_OF_BIRTH,TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12)*12+TRUNC(MOD(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH),12)))) DAY FROM MP_PATIENT_MAST WHERE PATIENT_ID = ");
		dataMap.put("PRE_APPROVAL_REQUEST_BILLINGSERVICEDESC",		"SELECT SHORT_DESC  FROM BL_BLNG_SERV_LANG_VW WHERE  NVL(STATUS,'n') != 'S' AND LANGUAGE_ID = ");
		dataMap.put("PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP",		"SELECT ACTION_REASON_CODE CODE, ACTION_REASON_DESC DESCRIPTION FROM BL_ACTION_REASON_LANG WHERE action_Reason_code in(select ACTION_REASON_CODE from BL_ACTION_REASON_BY_TYPE where ACTION_TYPE='RA' AND ACTIVE_YN = 'Y' ) AND upper(ACTION_REASON_CODE) like upper(?) and upper(ACTION_REASON_DESC) like upper(?) AND  NVL(status,'E') = 'E' AND LANGUAGE_ID =");
		dataMap.put("PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP","SELECT BLNG_SERV_CODE CODE,SHORT_DESC DESCRIPTION FROM BL_BLNG_SERV_LANG_VW WHERE upper(BLNG_SERV_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND  NVL(STATUS,'n') != 'S' AND LANGUAGE_ID = ");
		dataMap.put("RECORD_PREAPPROVAL_PATIENT_DATA_PART1_QUERY",	 "SELECT   ROWID,BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, EFFECTIVE_FROM, EFFECTIVE_TO,POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID,APPROVED_AMT,ACCT_SEQ_NO,ENCOUNTER_ID FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE EPISODE_TYPE = '@episodeType' AND OPERATING_FACILITY_ID = '@facilityId' ");
		dataMap.put("RECORD_PREAPPROVAL_PATIENT_DATA_PART2_QUERY",	 "AND ACCT_SEQ_NO =(SELECT MAX (ACCT_SEQ_NO)FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE OPERATING_FACILITY_ID = '@facilityId1'  AND EPISODE_TYPE = '@episodeType1' AND EPISODE_ID = '@episodeId' AND VISIT_ID = '@visitId') AND EPISODE_ID = '@episodeId1'  AND visit_id = '@visitId1' AND POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL ORDER BY PRIORITY");
		dataMap.put("RECORD_PREAPPROVAL_MODAL_WINDOW_QUERY",	 	 "SELECT DISTINCT BLNG_SERV_CODE FROM BL_PATIENT_CHARGES_FOLIO WHERE OPERATING_FACILITY_ID = '@facilityId' AND EPISODE_TYPE = '@episodeType' AND PATIENT_ID = '@patientId' AND CUST_GROUP_CODE = '@customerGroupCode' AND CUST_CODE = '@customerCode' AND POLICY_TYPE_CODE = '@policyTypeCode' AND PRIORITY = @priority AND ACCT_SEQ_NO = @acctSeqNo AND EPISODE_ID = @episodeId AND NVL(VISIT_ID,0) = DECODE(EPISODE_TYPE,'E',1,'O',1,NVL(VISIT_ID,0)) AND BLNG_SERV_CODE LIKE '@billingServiceCode' AND TRX_STATUS IS NULL");
		/* queries for  Record Pre Approval added by Boopathy Ends Here */

		//Rajesh V - Queries for Policy Definition
		//Modified V181005-Aravindh/AAKH-CRF-0107/POLICY_DEF_HDR_INFO->Added one more column hdr.policy_cov_by_refer_price
		//Modified V190517-Aravindh/NMC-JD-CRF-0010/POLICY_DEF_HDR_INFO->Added one more column hdr.policy_approved_yn
		//Modified against NMC-JD-CRF-0045--14-08-2020
		dataMap.put("POLICY_DEF_HDR_INFO",				  "select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer,  decode(hdr.CUST_CODE,'**',?,hdr.cust_code) cust_code , decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, hdr.POLICY_TYPE_CODE, hdr.operating_facility_id, hdr.policy_coverage_basis,hdr.payer_cov_rule,hdr.copay_perc,hdr.def_req_policy_dates,hdr.addl_days_policy_expdt, hdr.slmt_appl_yn,to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to,hdr.screening_policy_yn, hdr.group_policy_yn, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn, hdr.CLAIM_AGREED_EXISTS_YN clms_agrmt_exts,hdr.payer_ref_code from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");//Added against NMC-JD-CRF-0045 //V211221
		dataMap.put("POLICY_DEFN_HDR_INFO",				  "select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group,hdr.CUST_GROUP_CODE,decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer,  decode(hdr.CUST_CODE,'**',?,hdr.cust_code) cust_code ,decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type,hdr.POLICY_TYPE_CODE, hdr.operating_facility_id, hdr.policy_coverage_basis,hdr.payer_cov_rule,hdr.copay_perc,hdr.def_req_policy_dates,hdr.addl_days_policy_expdt, hdr.slmt_appl_yn,to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to,hdr.screening_policy_yn, hdr.group_policy_yn, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn,hdr.CLAIM_AGREED_EXISTS_YN clms_agrmt_exts,hdr.payer_ref_code  from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  (hdr.CUST_CODE = ? or hdr.CUST_CODE='**') and hdr.POLICY_TYPE_CODE = ? and rownum=1 order by hdr.cust_code desc  ");//V211103 //V211221
		dataMap.put("POLICY_DEF_SERVICE_INFO",			  "select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  ");
		dataMap.put("POLICY_DEFN_SERVICE_INFO",			  "select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and (hdr.CUST_CODE = ? or hdr.CUST_CODE='**') and hdr.POLICY_TYPE_CODE = ? and rownum=1 order by hdr.cust_code desc  ");//V211103
		dataMap.put("POLICY_DEF_OUTPAT_INFO",			  "select hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.across_encounters_yn across_encounter,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_OP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_OP duration_type, MULTI_FACTOR_DEDUCTIBLE_RULE, ITEM_PATIENT_AMOUNT_LIMIT from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  ");  //V221017
		dataMap.put("POLICY_DEFN_OUTPAT_INFO",			  "select hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.across_encounters_yn across_encounter,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_OP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_OP duration_type from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.policy_eff_to>sysdate and rownum=1   order by hdr.cust_code desc ");//V211021 & V211026
		dataMap.put("POLICY_DEF_INPAT_INFO",			  "select hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.ip_across_encounters_yn across_encounter,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_IP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_IP duration_type, MULTI_FACTOR_DED_RULE_IP from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		dataMap.put("POLICY_DEFN_INPAT_INFO",			  "select hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.ip_across_encounters_yn across_encounter,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_IP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_IP duration_type from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.policy_eff_to > sysdate and rownum=1   order by hdr.cust_code desc ");//V211021 & V211026
		dataMap.put("POLICY_DEF_EXTERNAL_INFO",			  "select hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.ex_across_encounters_yn across_encounter,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		dataMap.put("POLICY_DEFN_EXTERNAL_INFO",			  "select hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.ex_across_encounters_yn across_encounter,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.policy_eff_to>sysdate and rownum=1   order by hdr.cust_code desc ");//V211021& V211026
		//Added against NMC-JD-CRF-0045 by Priya Starts
	dataMap.put("POLICY_DEF_SERVICE_INFO_GP_POLICY",			  "select hdr.GROUP_POLICY_YN gppolicy,hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  ");

	dataMap.put("POLICY_DEF_OUTPAT_INFO_GP_POLICY",			  "select hdr.GROUP_POLICY_YN gppolicy,hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.across_encounters_yn across_encounter,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_OP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_OP duration_type, MULTI_FACTOR_DEDUCTIBLE_RULE, ITEM_PATIENT_AMOUNT_LIMIT from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  "); //V221017
		
	dataMap.put("POLICY_DEF_INPAT_INFO_GP_POLICY",			  "select hdr.GROUP_POLICY_YN gppolicy,hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.ip_across_encounters_yn across_encounter,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_IP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_IP duration_type, MULTI_FACTOR_DED_RULE_IP from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		
	dataMap.put("POLICY_DEF_EXTERNAL_INFO_GP_POLICY",			  "select hdr.GROUP_POLICY_YN gppolicy,hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.ex_across_encounters_yn across_encounter,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		//Added against NMC-JD-CRF-0045 by Priya Ends
		//Modified V181005-Aravindh/AAKH-CRF-0107/POLICY_DEF_INCL_EXCL_DTL->Added one more column hdr.policy_cov_by_refer_price
		
	// Added for crf-0170 hdr.group_service_ind 
		dataMap.put("POLICY_DEF_INCL_EXCL_DTL",			  "select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, "+
														  " decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code,hdr.special_service_yn,hdr.excl_incl_ind,hdr.ovride_incl_excl_yn,hdr.copay_ind,hdr.copay_val,hdr.include_policy_level_copay_yn, hdr.pre_approval_yn,hdr.cumm_cvrg_with_oth_payers_yn,hdr.last_payer_coverage_yn,hdr.qty_capping,hdr.amount_capping,hdr.per_day_amount_limit, hdr.patient_copay, hdr.patient_amount_limit, hdr.no_of_days_limit,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to, per_day_amt_limit_gross_net,hdr.incl_home_medication_yn, "+
															" (select count(*) from bl_insu_policy_exclusions excl where excl.operating_facility_id = ? and excl.CUST_GROUP_CODE = ? and  excl.CUST_CODE = ? and excl.POLICY_TYPE_CODE = ? and excl.serv_excl_incl_crit = hdr.serv_excl_incl_crit and excl.blng_serv_code = hdr.blng_serv_code and excl.patient_class = hdr.patient_class And excl.Episode_Or_Encounter_Flag = Hdr.Episode_Or_Encounter_Flag AND excl.SEX  = hdr.SEX AND excl.AGE_GROUP_CODE = hdr.AGE_GROUP_CODE AND excl.CLINIC_NURSING_IND = hdr.CLINIC_NURSING_IND AND excl.CLINIC_NURSING_CODE = hdr.CLINIC_NURSING_CODE And excl.SPLTY_CODE = Hdr.SPLTY_CODE AND excl.EFFECTIVE_FROM  = hdr.EFFECTIVE_FROM ) total, "+
														  " hdr.across_encounters_yn, hdr.dflt_acr_enc_grp_for_same_epis, hdr.dflt_acr_enc_grp_durn_type, hdr.dflt_acr_enc_grp_durn,hdr.group_service_ind, hdr.policy_cov_by_refer_price cover_ref_price , hdr.across_enc_exlincl_yn"+
														  " , hdr.DIAG_BASED_COPAY_DEFN "+ //MOHE-CRF-0114
														  " from bl_insu_policy_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
							dataMap.put("POLICY_DEFN_INCL_EXCL_DTL",			  "select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, "+
														  " decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code,hdr.special_service_yn,hdr.excl_incl_ind,hdr.ovride_incl_excl_yn,hdr.copay_ind,hdr.copay_val,hdr.include_policy_level_copay_yn, hdr.pre_approval_yn,hdr.cumm_cvrg_with_oth_payers_yn,hdr.last_payer_coverage_yn,hdr.qty_capping,hdr.amount_capping,hdr.per_day_amount_limit, hdr.patient_copay, hdr.patient_amount_limit, hdr.no_of_days_limit,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to, per_day_amt_limit_gross_net,hdr.incl_home_medication_yn, "+
															" (select count(*) from bl_insu_policy_exclusions excl where excl.operating_facility_id = ? and excl.CUST_GROUP_CODE = ? and   excl.cust_code = ? and excl.POLICY_TYPE_CODE = ? and excl.serv_excl_incl_crit = hdr.serv_excl_incl_crit and excl.blng_serv_code = hdr.blng_serv_code and excl.patient_class = hdr.patient_class And excl.Episode_Or_Encounter_Flag = Hdr.Episode_Or_Encounter_Flag AND excl.SEX  = hdr.SEX AND excl.AGE_GROUP_CODE = hdr.AGE_GROUP_CODE AND excl.CLINIC_NURSING_IND = hdr.CLINIC_NURSING_IND AND excl.CLINIC_NURSING_CODE = hdr.CLINIC_NURSING_CODE And excl.SPLTY_CODE = Hdr.SPLTY_CODE AND excl.EFFECTIVE_FROM  = hdr.EFFECTIVE_FROM ) total, "+
														  " hdr.across_encounters_yn, hdr.dflt_acr_enc_grp_for_same_epis, hdr.dflt_acr_enc_grp_durn_type, hdr.dflt_acr_enc_grp_durn,hdr.group_service_ind, hdr.policy_cov_by_refer_price cover_ref_price , hdr.across_enc_exlincl_yn"+
														  " , hdr.DIAG_BASED_COPAY_DEFN "+														  
														  " from bl_insu_policy_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.effective_to>sysdate "); //V211021 & V211026
//Added  Preeapproval Duration Quantity /V180725-Gayathri/MMS-DM-CRF-0126

// Added for crf-0170 hdr.group_service_ind 
		dataMap.put("POLICY_DEF_PREAPPROVAL_DTL",		  "select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code, hdr.preapproval_amt_capping, hdr.preapproval_qty_capping, hdr.preapproval_dur_capping, hdr.preapproval_amt_gross_net,hdr.ACROSS_ENC_PREAPP_YN ,hdr.service_level_approval_yn,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,hdr.ALLOW_SPLIT_IF_NO_APPROVAL,hdr.group_service_ind from bl_ins_preapproval_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		dataMap.put("POLICY_DEFN_PREAPPROVAL_DTL",		  "select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code, hdr.preapproval_amt_capping, hdr.preapproval_qty_capping, hdr.preapproval_dur_capping, hdr.preapproval_amt_gross_net,hdr.ACROSS_ENC_PREAPP_YN ,hdr.service_level_approval_yn,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,hdr.ALLOW_SPLIT_IF_NO_APPROVAL,hdr.group_service_ind from bl_ins_preapproval_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.effective_to>sysdate  ");//V211021 & V211026
		
		dataMap.put("POLICY_DEF_EXCLUSION_POPUP",		  "select hdr.excl_serv_excl_incl_crit, decode(hdr.excl_blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.excl_serv_excl_incl_crit,hdr.excl_blng_serv_code,?)) blng_serv_desc,hdr.excl_blng_serv_code,hdr.excl_incl_ind,hdr.copay_ind,hdr.copay_val,hdr.qty_capping,hdr.amount_capping,hdr.per_day_amount_limit, hdr.per_day_amt_limit_gross_net, hdr.patient_copay, hdr.patient_amount_limit, hdr.no_of_days_limit,to_char(hdr.EXCL_EFFECTIVE_FROM,'dd/mm/yyyy') effective_from,to_char(hdr.EXCL_EFFECTIVE_TO,'dd/mm/yyyy') effective_to,hdr.per_day_amt_limit_gross_net, "+
		" hdr.across_encounters_yn, hdr.dflt_acr_enc_grp_for_same_epis, hdr.dflt_acr_enc_grp_durn_type, hdr.dflt_acr_enc_grp_durn ,across_enc_exlincl_yn"+
		" from bl_insu_policy_exclusions hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ");

		dataMap.put("POLICY_DEF_INCL_EXCL_CRITERIA",	  "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description, A.LIST_ELMT_VALUE code FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? ORDER BY A.LIST_SRL_NO  ");
		dataMap.put("POLICY_DEF_INCL_EXCL_POP_CRITERIA",  "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description, A.LIST_ELMT_VALUE code FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = ?  AND B.LANGUAGE_ID (+) = ? ORDER BY A.LIST_SRL_NO  ");
		
		dataMap.put("POLICY_DEF_INPAT_LOAD",			  "select ip_cred_auth_req_yn,ip_cred_auth_mand_to_capt_yn,ip_dflt_auth_ref_as_pol_no_yn,inpatient_covered,inpatient_limit_type,ip_approved_days_limit_type,ip_approved_no_of_days,ip_approved_amt_limit_type,ip_approved_amt_limit,mand_bill_gen_check_ind_ip,mand_inv_gen_check_ind_ip,ip_across_encounters_yn,ip_patient_copay,ip_patient_amount_limit,ip_approved_amt_gross_net,DFLT_ACR_ENC_GRP_DURN_IP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_IP duration_type from bl_ins_policy_type_hdr where policy_type_code = ? and cust_code = ? and cust_group_code = ? and operating_facility_id = ? ");
		dataMap.put("POLICY_DEF_EXTERNAL_LOAD",			  "select ex_cred_auth_req_yn,ex_cred_auth_mand_to_capt_yn,ex_dflt_auth_ref_as_pol_no_yn,external_covered,external_limit_type,ex_approved_days_limit_type,ex_approved_no_of_days,ex_approved_amt_limit_type,ex_approved_amt_limit,mand_bill_gen_check_ind_ex,mand_inv_gen_check_ind_ex,ex_across_encounters_yn,ex_patient_copay,ex_patient_amount_limit,ex_approved_amt_gross_net from bl_ins_policy_type_hdr where policy_type_code = ? and cust_code = ? and cust_group_code = ? and operating_facility_id = ? ");
		//Rajesh V - Queries for Policy Definition

		//Rajesh V - Queries for Encounter Specific Definition
		dataMap.put("ENCOUNTER_SPECIFIC_DATA_DETAILS_OE",	"SELECT   rownum, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, "+
		"to_char(EFFECTIVE_FROM,'DD/MM/YYYY') EFFECTIVE_FROM, to_char(EFFECTIVE_TO,'DD/MM/YYYY') EFFECTIVE_TO, "+
		"to_char(POLICY_EXPIRY_DATE,'DD/MM/YYYY') POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID, "+
		"ACCT_SEQ_NO,nvl(Encounter_Id,Episode_Id||lpad(visit_id,4,0)) Encounter_Id,episode_type, to_char(CREDIT_AUTH_DATE,'DD/MM/YYYY') CREDIT_AUTH_DATE,APPROVED_AMT "+
		"FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE PATIENT_ID = ? AND EPISODE_TYPE = ? AND OPERATING_FACILITY_ID = ? "+
		"AND ACCT_SEQ_NO   in (select CUR_ACCT_SEQ_NO from bl_visit_fin_dtls where patient_id = ? and episode_id =?) "+
		"AND EPISODE_ID = ?  and "+
		//"AND  ? = to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') and "+
		//"AND EPISODE_ID = ?  AND  to_date(?,'DD/MM/YYYY') BETWEEN POLICY_START_DATE AND nvl(POLICY_EXPIRY_DATE, to_date(?,'DD/MM/YYYY')) and "+
		"POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL "+
		" AND exists (select 1 from pr_encounter a where operating_facility_id = A.FACILITY_ID "+
			" and patient_id = A.PATIENT_ID "+
			"  and episode_id = A.EPISODE_ID "+
			"  and visit_id = A.OP_EPISODE_VISIT_NUM  "+
			" and a.facility_id = ? "+
			"  and A.ENCOUNTER_ID = ? || LPAD (visit_id, 4, 0) "+
			"  and a.patient_id = ? "+
			" and trunc(A.VISIT_ADM_DATE_TIME) = to_date(?,'dd/mm/yyyy') "+
		" )     ORDER BY visit_id desc");

		dataMap.put("ENCOUNTER_SPECIFIC_DATA_DETAILS_ID",	"SELECT   rownum, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, "+
		"to_char(EFFECTIVE_FROM,'DD/MM/YYYY') EFFECTIVE_FROM, to_char(EFFECTIVE_TO,'DD/MM/YYYY') EFFECTIVE_TO, "+
		"to_char(POLICY_EXPIRY_DATE,'DD/MM/YYYY') POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID, "+
		"ACCT_SEQ_NO,nvl(Encounter_Id,Episode_Id||lpad(visit_id,4,0)) Encounter_Id,episode_type, to_char(CREDIT_AUTH_DATE,'DD/MM/YYYY') CREDIT_AUTH_DATE,APPROVED_AMT "+
		"FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE PATIENT_ID = ? AND EPISODE_TYPE = ? AND OPERATING_FACILITY_ID = ? "+
		"AND ACCT_SEQ_NO   in (select CUR_ACCT_SEQ_NO from bl_episode_fin_dtls where patient_id = ? and episode_id =?) "+
		"AND EPISODE_ID = ?  AND  "+
		//"? = to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') and "+
		//"AND EPISODE_ID = ?  AND  to_date(?,'DD/MM/YYYY') BETWEEN POLICY_START_DATE AND nvl(POLICY_EXPIRY_DATE, to_date(?,'DD/MM/YYYY')) and "+
		" POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL "+
		" and exists (select 1 from pr_encounter a  "+
			  " where operating_facility_id = A.FACILITY_ID "+
			  "  and patient_id = A.PATIENT_ID "+
			  " and episode_id = A.EPISODE_ID	 "+												                 
			  "   and a.facility_id = ? "+
			  "   and A.ENCOUNTER_ID = ?  "+
			  "   and a.patient_id = ? "+
			  "   and trunc(A.VISIT_ADM_DATE_TIME) = to_date(?,'dd/mm/yyyy') )  "+    
		" ORDER BY visit_id desc");

		dataMap.put("ENCOUNTER_SPECIFIC_DATA_DETAILS_R",	"SELECT   rownum, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, "+
		"to_char(EFFECTIVE_FROM,'DD/MM/YYYY') EFFECTIVE_FROM, to_char(EFFECTIVE_TO,'DD/MM/YYYY') EFFECTIVE_TO, "+
		"to_char(POLICY_EXPIRY_DATE,'DD/MM/YYYY') POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID, "+
		"ACCT_SEQ_NO,nvl(Encounter_Id,Episode_Id||lpad(visit_id,4,0)) Encounter_Id,episode_type, to_char(CREDIT_AUTH_DATE,'DD/MM/YYYY') CREDIT_AUTH_DATE,APPROVED_AMT "+
		"FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE PATIENT_ID = ? AND EPISODE_TYPE = ? AND OPERATING_FACILITY_ID = ? "+
		"AND ACCT_SEQ_NO   in (select CUR_ACCT_SEQ_NO from bl_patient_fin_dtls where patient_id = ? ) "+
		" AND  ? = to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') and "+
		//" AND  to_date(?,'DD/MM/YYYY') BETWEEN POLICY_START_DATE AND nvl(POLICY_EXPIRY_DATE, to_date(?,'DD/MM/YYYY')) and "+
		" POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL ORDER BY visit_id desc");

		dataMap.put("ENCOUNTER_SPECIFIC_DATA_DETAILS_R_PREV",	"SELECT   rownum, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE,PRIORITY, POLICY_NUMBER, "+
		"to_char(EFFECTIVE_FROM,'DD/MM/YYYY') EFFECTIVE_FROM, to_char(EFFECTIVE_TO,'DD/MM/YYYY') EFFECTIVE_TO, "+
		"to_char(POLICY_EXPIRY_DATE,'DD/MM/YYYY') POLICY_EXPIRY_DATE, CREDIT_AUTH_REF, PATIENT_ID, EPISODE_ID,VISIT_ID, "+
		"NULL ACCT_SEQ_NO,nvl(Encounter_Id,Episode_Id||lpad(visit_id,4,0)) Encounter_Id,episode_type, to_char(CREDIT_AUTH_DATE,'DD/MM/YYYY') CREDIT_AUTH_DATE,APPROVED_AMT "+
		"FROM BL_ENCOUNTER_PAYER_PRIORITY WHERE PATIENT_ID = ? AND EPISODE_TYPE = ? AND OPERATING_FACILITY_ID = ? "+
		"AND ACCT_SEQ_NO   in (select CUR_ACCT_SEQ_NO from bl_patient_fin_dtls where patient_id = ? ) "+
		" AND  "+
		" POLICY_TYPE_CODE IS NOT NULL AND CUST_CODE IS NOT NULL ORDER BY visit_id desc ");

		dataMap.put("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE"," and hdr.episode_type = ? and hdr.episode_id = ? and hdr.visit_id =? and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? and hdr.policy_number = ?");
		dataMap.put("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID"," and hdr.episode_type = ? and hdr.episode_id = ?  and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? and hdr.policy_number = ?");
		dataMap.put("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R"," and hdr.episode_type = ?  and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? and hdr.policy_number = ?");
		//Modified V181005-Aravindh/AAKH-CRF-0107/ENCOUNTER_SPECIFIC_SERVICE_COVERAGE->Added one more column hdr.policy_cov_by_refer_price
		//Modified V190517-Aravindh/NMC-JD-CRF-0010/ENCOUNTER_SPECIFIC_SERVICE_COVERAGE->Added one more column hdr.policy_approved_yn
		dataMap.put("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE","select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn,hdr.COPAY_PERC,hdr.POLICY_COVERAGE_BASIS,hdr.PAYER_COV_RULE,NVL(hdr.ACROSS_ENC_GROUP_ID,'') ACROSS_ENC_GROUP_ID, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn, hdr.CLAIM_AGREED_EXISTS_YN clms_agrmt_exts from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_SERVICE_COVERAGES","select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn,hdr.COPAY_PERC,hdr.POLICY_COVERAGE_BASIS,hdr.PAYER_COV_RULE,NVL(hdr.ACROSS_ENC_GROUP_ID,'') ACROSS_ENC_GROUP_ID, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn, hdr.CLAIM_AGREED_EXISTS_YN clms_agrmt_exts from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  (hdr.CUST_CODE = ?  or hdr.CUST_CODE = '**') and hdr.POLICY_TYPE_CODE=? and hdr.patient_id = ?  and rownum=1 "); //V211103
/*
		dataMap.put("ENCOUNTER_SPECIFIC_OUTPAT_INFO","select hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  and hdr.patient_id = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_INPAT_INFO","select hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount  from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_EXTERNAL_INFO","select hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount  from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? ");
*/
		dataMap.put("ENCOUNTER_SPECIFIC_OUTPAT_INFO","select hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount, MULTI_FACTOR_DEDUCTIBLE_RULE from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ?  and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=?   and hdr.patient_id = ? and rownum=1   "); //V230228
		dataMap.put("ENCOUNTER_SPECIFIC_INPAT_INFO","select hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount, MULTI_FACTOR_DED_RULE_IP from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and  hdr.patient_id = ? and rownum=1   "); //V230228
		dataMap.put("ENCOUNTER_SPECIFIC_EXTERNAL_INFO","select hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount  from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and  hdr.patient_id = ? and rownum=1   ");

//V211027  //V211103
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE"," and hdr.episode_type = ? and hdr.episode_id = ? and hdr.visit_id =? and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID"," and hdr.episode_type = ? and hdr.episode_id = ?  and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R"," and hdr.episode_type = ?  and hdr.acct_seq_no = nvl(?,hdr.acct_seq_no) and hdr.priority = ? ");

		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_OE"," and excl.episode_type = ? and excl.episode_id = ?  and excl.visit_id =? and excl.acct_seq_no = nvl(?,excl.acct_seq_no) and excl.priority = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_ID"," and excl.episode_type = ? and excl.episode_id = ?  and excl.acct_seq_no = nvl(?,excl.acct_seq_no) and excl.priority = ? ");
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_R"," and excl.episode_type = ?  and excl.acct_seq_no = nvl(?,excl.acct_seq_no) and excl.priority = ? ");

		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART","select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc,decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code,hdr.INCL_HOME_MEDICATION_YN,hdr.special_service_yn,hdr.excl_incl_ind,hdr.ovride_incl_excl_yn,hdr.copay_ind,hdr.copay_val,hdr.include_policy_level_copay_yn, hdr.pre_approval_yn,hdr.cumm_cvrg_with_oth_payers_yn,hdr.last_payer_coverage_yn,hdr.qty_capping,hdr.amount_capping,hdr.per_day_amount_limit, hdr.patient_copay, hdr.patient_amount_limit, hdr.no_of_days_limit,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to, per_day_amt_limit_gross_net,to_char(hdr.effective_date,'dd/mm/yyyy') effective_date "+
		", hdr.across_enc_exlincl_yn across_enc_exlincl_yn, (select count(*) from bl_insu_policy_addl_excl excl where excl.operating_facility_id = ? and excl.CUST_GROUP_CODE = ? and  excl.CUST_CODE = ? and excl.POLICY_TYPE_CODE = ? and excl.serv_excl_incl_crit = hdr.serv_excl_incl_crit and excl.blng_serv_code = hdr.blng_serv_code and excl.patient_class = hdr.patient_class  And excl.Episode_Or_Encounter_Flag = Hdr.Episode_Or_Encounter_Flag AND excl.SEX  = hdr.SEX AND excl.AGE_GROUP_CODE = hdr.AGE_GROUP_CODE AND excl.CLINIC_NURSING_IND = hdr.CLINIC_NURSING_IND AND excl.CLINIC_NURSING_CODE = hdr.CLINIC_NURSING_CODE And excl.SPLTY_CODE = Hdr.SPLTY_CODE AND excl.EFFECTIVE_FROM  = hdr.EFFECTIVE_FROM and excl.patient_id = ? ");

		//Modified V181005-Aravindh/AAKH-CRF-0107/ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART->Added one more column hdr.policy_cov_by_refer_price & CRF-0170
		/*dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART",") total, hdr.policy_cov_by_refer_price cover_ref_price,hdr.group_service_ind "+
															" from bl_insu_policy_addl_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?  and hdr.patient_id = ? "); *///V211123
		dataMap.put("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART",") total, hdr.policy_cov_by_refer_price cover_ref_price,hdr.group_service_ind, hdr.DIAG_BASED_COPAY_DEFN "+ //MOHE-CRF-0114
															" from bl_insu_policy_addl_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.patient_id = ? ");//V211123 //V220607 hdr.effective_to>sysdate

	//	dataMap.put("ENCOUNTER_SPECIFIC_PRE_APPROVAL","select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code, hdr.preapproval_amt_capping, hdr.preapproval_qty_capping,hdr.preapproval_dur_capping, hdr.preapproval_amt_gross_net, hdr.ACROSS_ENC_PREAPP_YN, hdr.service_level_approval_yn,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,hdr.group_service_ind from bl_insu_preapproval_addl_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? ");// & CRF-0170 //V211123

	dataMap.put("ENCOUNTER_SPECIFIC_PRE_APPROVAL","select hdr.patient_class,hdr.AGE_GROUP_CODE,decode(hdr.AGE_GROUP_CODE,'**','All Age groups',(select Long_Desc from Bl_Ins_Age_Group where Age_Group_Code = hdr.AGE_GROUP_CODE)) age_group_desc, hdr.SEX,hdr.episode_or_encounter_flag,hdr.clinic_nursing_ind,hdr.clinic_nursing_code,hdr.splty_code, decode(hdr.clinic_nursing_ind,'C',DECODE(Hdr.Clinic_Nursing_Code,'**','All Clinic',(select short_desc from OP_CLINIC_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and clinic_code = hdr.clinic_nursing_code)),'N',DECODE(hdr.clinic_nursing_code,'**','All Nursing Unit',(select LONG_DESC from IP_NURSING_UNIT_LANG_VW where upper(language_id) = upper(?) and facility_id = hdr.operating_facility_id and NURSING_UNIT_CODE = hdr.clinic_nursing_code)),'A','All Clinic/ Nursing unit') clinic_nursing_desc, decode(hdr.splty_code,'**','All Specialities',(select short_desc from am_speciality_lang_vw where language_id = ? and speciality_code = hdr.splty_code )) spec_desc,hdr.serv_excl_incl_crit, decode(hdr.blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.serv_excl_incl_crit,hdr.blng_serv_code,?)) blng_serv_desc,hdr.blng_serv_code, hdr.preapproval_amt_capping, hdr.preapproval_qty_capping,hdr.preapproval_dur_capping, hdr.preapproval_amt_gross_net, hdr.ACROSS_ENC_PREAPP_YN, hdr.service_level_approval_yn,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,hdr.group_service_ind from bl_insu_preapproval_addl_dtls hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.patient_id = ? ");//V211123 //V220607 and hdr.effective_to>sysdate

		dataMap.put("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP","select hdr.excl_serv_excl_incl_crit, decode(hdr.excl_blng_serv_code,'**','All Billing Services',blcommonproc.get_description('SERV_CRIT',hdr.excl_serv_excl_incl_crit,hdr.excl_blng_serv_code,?)) blng_serv_desc,hdr.excl_blng_serv_code,hdr.excl_incl_ind,hdr.copay_ind,hdr.copay_val,hdr.qty_capping,hdr.amount_capping,hdr.per_day_amount_limit, hdr.patient_copay, hdr.patient_amount_limit, hdr.per_day_amt_limit_gross_net,hdr.no_of_days_limit,to_char(hdr.EXCL_EFFECTIVE_FROM,'dd/mm/yyyy') effective_from,to_char(hdr.EXCL_EFFECTIVE_TO,'dd/mm/yyyy') effective_to,hdr.per_day_amt_limit_gross_net,to_char(hdr.effective_date,'dd/mm/yyyy') effective_date from bl_insu_policy_addl_excl hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? and patient_id = ?  And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ");
		//Modified V181005-Aravindh/AAKH-CRF-0107/COMMON_POLICY_SERVICE_COVERAGE->Added one more column hdr.policy_cov_by_refer_price
		//Modified V190517-Aravindh/NMC-JD-CRF-0010/COMMON_POLICY_SERVICE_COVERAGE->Added one more column hdr.policy_approved_yn
		dataMap.put("COMMON_POLICY_SERVICE_COVERAGE","select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn, to_char(hdr.POLICY_EFF_FROM,'dd/mm/yyyy') POLICY_EFF_FROM, to_char(hdr.POLICY_EFF_TO,'dd/mm/yyyy') POLICY_EFF_TO,hdr.COPAY_PERC,hdr.POLICY_COVERAGE_BASIS,hdr.PAYER_COV_RULE, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ");
		dataMap.put("COMMON_POLICY_SERVICE_COVERAGE_DTLS","select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn, to_char(hdr.POLICY_EFF_FROM,'dd/mm/yyyy') POLICY_EFF_FROM, to_char(hdr.POLICY_EFF_TO,'dd/mm/yyyy') POLICY_EFF_TO,hdr.COPAY_PERC,hdr.POLICY_COVERAGE_BASIS,hdr.PAYER_COV_RULE, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and   (hdr.cust_code = ?  or hdr.cust_code = '**') and hdr.POLICY_TYPE_CODE=? and hdr.policy_eff_to>sysdate and rownum=1   order by hdr.cust_code desc ");//V211021 & V211026

		//Modified V181012-Aravindh/AAKH-CRF-0107/COMMON_ENCOUNTER_SERVICE_COVERAGE->Added one more column hdr.policy_cov_by_refer_price
		//Modified V190517-Aravindh/NMC-JD-CRF-0010/COMMON_ENCOUNTER_SERVICE_COVERAGE->Added one more column hdr.policy_approved_yn
		dataMap.put("COMMON_ENCOUNTER_SERVICE_COVERAGE","select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn, to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy') POLICY_EFF_FROM, to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy') POLICY_EFF_TO,hdr.COPAY_PERC,hdr.POLICY_COVERAGE_BASIS,hdr.PAYER_COV_RULE, hdr.policy_cov_by_refer_price cover_ref_price, NVL(hdr.policy_approved_yn,'N') policy_approved_yn from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? ");

		dataMap.put("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_OE",	"select count(*) as enc_count "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		"where   a.ACROSS_ENCOUNTERS_YN = 'Y' "+
		"and  B.ACROSS_ENC_GROUP_ID is not null "+
		"and  a.cust_group_code = b.cust_group_code "+
		"and  a. cust_code     =  b.cust_code "+
		"And  A.Policy_Type_Code = B.Policy_Type_Code "+
		"And  A.Operating_facility_id = B.Operating_facility_id "+
		"And  B.Cust_Group_Code  = ? "+
		"And  B.Cust_Code        = ? "+
		"And  B.Policy_Type_Code = ? "+
		"And  B.Operating_facility_id = ? "+
		"And  B.Patient_id = ? "+
		"and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");

		dataMap.put("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_ID",	"select count(*) as enc_count "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		"where   a.IP_ACROSS_ENCOUNTERS_YN = 'Y' "+
		"and  B.ACROSS_ENC_GROUP_ID is not null "+
		"and  a.cust_group_code = b.cust_group_code "+
		"and  a. cust_code     =  b.cust_code "+
		"And  A.Policy_Type_Code = B.Policy_Type_Code "+
		"And  A.Operating_facility_id = B.Operating_facility_id "+
		"And  B.Cust_Group_Code  = ? "+
		"And  B.Cust_Code        = ? "+
		"And  B.Policy_Type_Code = ? "+
		"And  B.Operating_facility_id = ? "+
		"And  B.Patient_id = ? "+
		"and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");

		dataMap.put("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_R",	"select count(*) as enc_count "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		"where   a.EX_ACROSS_ENCOUNTERS_YN = 'Y' "+
		"and  B.ACROSS_ENC_GROUP_ID is not null "+
		"and  a.cust_group_code = b.cust_group_code "+
		"and  a. cust_code     =  b.cust_code "+
		"And  A.Policy_Type_Code = B.Policy_Type_Code "+
		"And  A.Operating_facility_id = B.Operating_facility_id "+
		"And  B.Cust_Group_Code  = ? "+
		"And  B.Cust_Code        = ? "+
		"And  B.Policy_Type_Code = ? "+
		"And  B.Operating_facility_id = ? "+
		"And  B.Patient_id = ? "+
		"and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");

		dataMap.put("ENCOUNTER_SPECIFIC_ENC_GRP_OE",	"select nvl(b.Encounter_Id,b.Episode_Id||lpad(b.visit_id,4,0)) ENCOUNTER_ID,NVL(b.ACROSS_ENC_GROUP_ID,'') ACROSS_ENC_GROUP_ID,b.POLICY_NUMBER "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		 "where a.ACROSS_ENCOUNTERS_YN = 'Y' "+
		 "and  B.ACROSS_ENC_GROUP_ID is not null "+
		 "and  a.cust_group_code = b.cust_group_code "+
		 "and  a. cust_code     =  b.cust_code "+
		 "And  A.Policy_Type_Code = B.Policy_Type_Code "+
		 "and a.operating_facility_id = b.operating_facility_id "+
		 "and  b.cust_group_code  = ? "+
		 "and  b.cust_code        = ? "+
		 "And  B.Policy_Type_Code = ? "+
		 "And B.Operating_Facility_Id = ? "+
		 "And  B.Patient_id = ? "+
		 "and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");

		dataMap.put("ENCOUNTER_SPECIFIC_ENC_GRP_ID",	"select nvl(b.Encounter_Id,b.Episode_Id||lpad(b.visit_id,4,0)) ENCOUNTER_ID,NVL(b.ACROSS_ENC_GROUP_ID,'') ACROSS_ENC_GROUP_ID,b.POLICY_NUMBER "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		 "where a.IP_ACROSS_ENCOUNTERS_YN = 'Y' "+
		 "and  B.ACROSS_ENC_GROUP_ID is not null "+
		 "and  a.cust_group_code = b.cust_group_code "+
		 "and  a. cust_code     =  b.cust_code "+
		 "And  A.Policy_Type_Code = B.Policy_Type_Code "+
		 "and a.operating_facility_id = b.operating_facility_id "+
		 "and  b.cust_group_code  = ? "+
		 "and  b.cust_code        = ? "+
		 "And  B.Policy_Type_Code = ? "+
		 "And B.Operating_Facility_Id = ? "+
		 "And  B.Patient_id = ? "+
		 "and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");

		dataMap.put("ENCOUNTER_SPECIFIC_ENC_GRP_R",	"select nvl(b.Encounter_Id,b.Episode_Id||lpad(b.visit_id,4,0)) ENCOUNTER_ID,NVL(b.ACROSS_ENC_GROUP_ID,'') ACROSS_ENC_GROUP_ID,b.POLICY_NUMBER "+
		"From Bl_Ins_Policy_Type_Hdr A,Bl_Ins_Policy_Addl_Hdr B "+
		 "where a.EX_ACROSS_ENCOUNTERS_YN = 'Y' "+
		 "and  B.ACROSS_ENC_GROUP_ID is not null "+
		 "and  a.cust_group_code = b.cust_group_code "+
		 "and  a. cust_code     =  b.cust_code "+
		 "And  A.Policy_Type_Code = B.Policy_Type_Code "+
		 "and a.operating_facility_id = b.operating_facility_id "+
		 "and  b.cust_group_code  = ? "+
		 "and  b.cust_code        = ? "+
		 "And  B.Policy_Type_Code = ? "+
		 "And B.Operating_Facility_Id = ? "+
		 "And  B.Patient_id = ? "+
		"and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE)");
		//Rajesh V - Queries for Encounter Specific Definition

		/* queries for Record Pre Approval Report Criteria added by Boopathy Starts Here */
		dataMap.put("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP",	 	 "SELECT SPECIALITY_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW WHERE upper(SPECIALITY_CODE) like upper(?) AND upper(SHORT_DESC) like upper(?) AND NVL(EFF_STATUS,'E')  !=  'D' AND LANGUAGE_ID =");
		dataMap.put("RECORD_REPORT_CRITERIA_PRACTIONER_LOOKUP",	 	 "SELECT PRACTITIONER_NAME CODE ,PRACTITIONER_ID DESCRIPTION FROM AM_PRACTITIONER_LANG_VW  WHERE upper(PRACTITIONER_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) AND LANGUAGE_ID =");
		dataMap.put("RECORD_REPORT_CRITERIA_EPISODE_NO_LOOKUP",	  	 "SELECT ENCOUNTER_ID CODE, PATIENT_CLASS DESCRIPTION FROM PR_ENCOUNTER  WHERE upper(ENCOUNTER_ID) like upper(?) AND upper(PATIENT_CLASS) like upper(?) ");
		/* queries for Record Pre Approval  Record Pre Approval added by Boopathy Ends Here */

		/* queries for Add Payer Insurance Default Approved Date and limit queries  added by Boopathy Starts Here */
		//		dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_MP",	 	 "SELECT POLICY_EFF_FROM, POLICY_EFF_TO,EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND CUST_CODE =  '@customerCode' ");	//Commented V210614
		//	dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_IP",	 	 "SELECT POLICY_EFF_FROM, POLICY_EFF_TO,IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND CUST_CODE =  '@customerCode' ");	//Commented V210614
			//dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_OP",	  	 "SELECT POLICY_EFF_FROM, POLICY_EFF_TO,OP_APPROVED_NO_OF_DAYS,OP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND CUST_CODE =  '@customerCode' "); //Commented V210614
			dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_MP",	 	 "SELECT POLICY_EFF_FROM, POLICY_EFF_TO,EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM (SELECT POLICY_EFF_FROM, POLICY_EFF_TO,EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND (CUST_CODE =  '@customerCode' OR CUST_CODE =  '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1");//V220314 // V220728
			dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_IP",	 	 "SELECT POLICY_EFF_FROM, POLICY_EFF_TO,IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM (SELECT POLICY_EFF_FROM, POLICY_EFF_TO,IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND (CUST_CODE =  '@customerCode' OR CUST_CODE =  '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1");//V220314 //V220728
		
		dataMap.put("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_OP",	  	 "SELECT POLICY_EFF_FROM,POLICY_EFF_TO,OP_APPROVED_NO_OF_DAYS,OP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT from (SELECT POLICY_EFF_FROM, POLICY_EFF_TO,OP_APPROVED_NO_OF_DAYS,OP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE = '@policyTypeCode' AND CUST_GROUP_CODE = '@customerGroupcode' AND (CUST_CODE = '@customerCode' OR CUST_CODE = '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1 "); //V210614 // V220314 //V220728
		/* queries for Add Payer Insurance Default Approved Date and limit queries added by Boopathy Ends Here */

		/*Queries Added by Rajesh Varadharajan for Billing Print Format*/
		dataMap.put("BIL_PRINT_FMT_GET_STATIC_INFO_BEAN",	 	 "SELECT LANG_LEGEND_ID, STATIC_INFO_DESC FROM BL_BILL_PRINT_STATIC_INFO ");

		dataMap.put("BIL_PRINT_FMT_GET_HDR_BEAN",	 	"SELECT FORMAT_CODE, FORMAT_DESCRIPTION, OP_YN, EM_YN, IP_YN, DC_YN, EX_YN, FIRST_TIME_PRINT_IND, " +
		"REPRINT_IND, PRT_DOCTOR_WITH_SERV_DESC_YN, PRT_DOCTOR_SPECIALITY_YN, SUMMARY_BY_PRINT_GROUP_YN, DETAIL_BY_PRINT_GROUP_LINE_YN, " +
		"DETAIL_BY_SERVICE_YN, SUBTOTAL_YN, PRT_REMARKS_ONLY_FOR_MISC_SERV, PRT_DOCTOR_INSTEAD_OF_SERV_YN, SUMMARY_BY_BLNG_SERV_YN, " +
		"PRINT_SERV_DESC_FOR_ITEM_YN, SUPPRESS_ZERO_GROSS_YN FROM BL_BILL_PRINT_FORMAT_HDR  " +
		"WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ?");

		dataMap.put("BIL_PRINT_FMT_GET_FMT_DTL_BEAN",	"SELECT  INFO_TYPE, SEQ_NO, INFO_IN_COLUMN1, INFO_IN_COLUMN2, INFO_IN_COLUMN3, INFO_IN_COLUMN4, INFO_IN_COLUMN5, " +
		"INFO_IN_COLUMN6, COLUMN1_DETAIL_REQ_YN, COLUMN2_DETAIL_REQ_YN, COLUMN1_STATIC_LEGEND, COLUMN2_STATIC_LEGEND, COLUMN3_STATIC_LEGEND, " +
		"COLUMN4_STATIC_LEGEND, COLUMN5_STATIC_LEGEND, COLUMN6_STATIC_LEGEND,  COLUMN1_STATIC_VALUE, COLUMN2_STATIC_VALUE, COLUMN3_STATIC_VALUE, " +
		"COLUMN4_STATIC_VALUE, COLUMN5_STATIC_VALUE, COLUMN6_STATIC_VALUE, COLUMN1_JUSTIFICATION, COLUMN2_JUSTIFICATION, COLUMN1_NO_PRINT_IF_ZERO_YN, " +
		"COLUMN2_NO_PRINT_IF_ZERO_YN  FROM BL_BILL_PRINT_FORMAT_DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ?");

		dataMap.put("BIL_PRINT_FMT_GET_PRT_GRP_HDR_BEAN",	"SELECT serv.prt_grp_hdr_code,bl.short_desc FROM BL_BILL_PRINT_SUM_BY_BLNG_SERV serv, bl_blng_prt_grp_hdr bl WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? "+
		" and serv.prt_grp_hdr_code = bl.prt_grp_hdr_code ");

		dataMap.put("BIL_PRINT_FMT_GET_CUST_BG_BEAN",	"SELECT CUST_OR_BG, CUST_GROUP_CODE, CUST_BG_CODE, BILL_TYPE, PRINT_REPRINT_FLAG  FROM " +
		"BL_BILL_PRINT_FORMAT_CUST_BG WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND CUST_OR_BG = ?");

		dataMap.put("BIL_PRINT_FMT_GET_PRT_GRP_SERV_BEAN",	" Select Serv.Print_Grp_Line_Serv_Ind, Serv.Print_Grp_Serv_Code, "+
		"(Select Long_Desc From Bl_Blng_Prt_Grp_Hdr Where Prt_Grp_Hdr_Code = Serv.Print_Grp_Serv_Code) Print_Grp_Serv_Desc, "+
		"Serv.Print_Grp_Line_Code, "+
		"(select Long_Desc from BL_BLNG_PRT_GRP_LINE  where PRT_GRP_LINE_CODE = Serv.Print_Grp_Line_Code And Prt_Grp_Hdr_Code =  Serv.Print_Grp_Serv_Code ) Print_Grp_Line_Desc, "+
		"Serv.Serv_Long_Desc_Yn, Bl.Long_Desc "+
		"FROM BL_BILL_PRINT_FORMAT_SERVICE serv,BL_BLNG_PRT_GRP_HDR bl WHERE serv.OPERATING_FACILITY_ID = ?  AND serv.FORMAT_CODE = ? "+
		"and bl.PRT_GRP_HDR_CODE = serv.print_grp_serv_code");

		dataMap.put("BIL_PRINT_FMT_GET_FMT_FOR_CUST",	"SELECT FORMAT_CODE, (Select format_description from bl_bill_print_format_hdr where format_code = BL_BILL_PRINT_FORMAT_CUST_BG.FORMAT_CODE ) format_description, "+
														"BILL_TYPE, PRINT_REPRINT_FLAG  FROM BL_BILL_PRINT_FORMAT_CUST_BG  " +
														"WHERE OPERATING_FACILITY_ID = ?  AND CUST_GROUP_CODE = ? AND CUST_OR_BG = ? and CUST_BG_CODE = ? ");

		dataMap.put("BIL_PRINT_FMT_GET_FMT_FOR_BG",	 	"SELECT FORMAT_CODE, (Select format_description from bl_bill_print_format_hdr where format_code = BL_BILL_PRINT_FORMAT_CUST_BG.FORMAT_CODE ) format_description, "+
														"BILL_TYPE, PRINT_REPRINT_FLAG  FROM BL_BILL_PRINT_FORMAT_CUST_BG  " +
														"WHERE OPERATING_FACILITY_ID = ?  AND  CUST_OR_BG = ? and CUST_BG_CODE = ? ");

		dataMap.put("BIL_PRINT_FMT_FETCH_BY_CUST",	  	"SELECT FORMAT_CODE, CUST_OR_BG, CUST_GROUP_CODE, CUST_BG_CODE, BILL_TYPE, PRINT_REPRINT_FLAG  " +
														"FROM BL_BILL_PRINT_FORMAT_CUST_BG WHERE OPERATING_FACILITY_ID = ?  AND CUST_GROUP_CODE = ? AND CUST_BG_CODE = ?");

		dataMap.put("BIL_PRINT_FMT_FETCH_BY_BG",	  	"SELECT FORMAT_CODE, CUST_OR_BG, CUST_GROUP_CODE, CUST_BG_CODE, BILL_TYPE, PRINT_REPRINT_FLAG  " +
														"FROM BL_BILL_PRINT_FORMAT_CUST_BG WHERE OPERATING_FACILITY_ID = ? AND CUST_BG_CODE = ?");


		dataMap.put("BIL_PRINT_FMT_FETCH_SERVICE",		"SELECT  INFO_TYPE,SEQ_NO, INFO_IN_COLUMN1,(SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
														" and INFO_NAME = DTL.INFO_IN_COLUMN1 and INFO_NAME in ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN1, "+
														 " INFO_IN_COLUMN2,(SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
																	" and INFO_NAME = DTL.INFO_IN_COLUMN2 and INFO_NAME NOT in ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN2, "+
														 " INFO_IN_COLUMN3, (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
																	" and INFO_NAME = DTL.INFO_IN_COLUMN3 and INFO_NAME NOT in  ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN3, "+
														" INFO_IN_COLUMN4, (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
																" and INFO_NAME = DTL.INFO_IN_COLUMN4 and INFO_NAME NOT in  ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN4, "+
														" INFO_IN_COLUMN5, (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
																" and INFO_NAME = DTL.INFO_IN_COLUMN5 and INFO_NAME NOT in  ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN5, "+
														" INFO_IN_COLUMN6, (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='SERVICE-INFO' "+
																" and INFO_NAME = DTL.INFO_IN_COLUMN6 and INFO_NAME NOT in  ('SERVICE-NAME','SERVICE-NAME-WITH-CODE') and rownum=1) HDN6,  "+
														" column2_detail_only_yn,column3_detail_only_yn,column4_detail_only_yn,column5_detail_only_yn,column6_detail_only_yn "+
														" FROM BL_BILL_PRINT_FORMAT_DTL DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND INFO_TYPE='SERVICE-INFO'");

		dataMap.put("BIL_PRINT_FMT_FETCH_HDR",	 	"SELECT FORMAT_CODE, FORMAT_DESCRIPTION, OP_YN, EM_YN, IP_YN, DC_YN, EX_YN, "+
													"(select static_info_desc from bl_bill_print_static_info where lang_legend_id = BL_BILL_PRINT_FORMAT_HDR.FIRST_TIME_PRINT_IND) FIRST_TIME_PRINT_IND, " +
													"(select static_info_desc from bl_bill_print_static_info where lang_legend_id = BL_BILL_PRINT_FORMAT_HDR.REPRINT_IND) REPRINT_IND, "+
													"FIRST_TIME_PRINT_IND FIRST_TIME_PRINT_IND_HDN,REPRINT_IND REPRINT_IND_HDN, "+
													"PRT_DOCTOR_WITH_SERV_DESC_YN, PRT_DOCTOR_SPECIALITY_YN, SUMMARY_BY_PRINT_GROUP_YN, DETAIL_BY_PRINT_GROUP_LINE_YN, " +
													"DETAIL_BY_SERVICE_YN, SUBTOTAL_YN, PRT_REMARKS_ONLY_FOR_MISC_SERV, PRT_DOCTOR_INSTEAD_OF_SERV_YN, SUMMARY_BY_BLNG_SERV_YN, " +
													"PRINT_SERV_DESC_FOR_ITEM_YN, SUPPRESS_ZERO_GROSS_YN, PRT_DISC_MED_IN_SEP_LINE_YN FROM BL_BILL_PRINT_FORMAT_HDR  " +
													"WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ?");

		dataMap.put("BIL_PRINT_FMT_FETCH_EOB",		"SELECT  INFO_TYPE,SEQ_NO, INFO_IN_COLUMN1, "+
													" (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls    WHERE INFO_TYPE='LAST-PAGE-INFO'  and INFO_NAME = DTL.INFO_IN_COLUMN1 and rownum=1) HDN1,  "+
													 " column1_static_value, "+
													" (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.column1_static_value and rownum=1) hdn2,  "+
													 "  column1_justification "+
													" FROM BL_BILL_PRINT_FORMAT_DTL DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND INFO_TYPE='LAST-PAGE-INFO'");

		dataMap.put("BIL_PRINT_FMT_FETCH_CUST",		" SELECT bg.format_code,bg.CUST_OR_BG, bg.CUST_GROUP_CODE, bg.CUST_BG_CODE, bg.BILL_TYPE, bg.PRINT_REPRINT_FLAG,cust.cust_code,cust.long_name  FROM "+
													" BL_BILL_PRINT_FORMAT_CUST_BG bg, ar_customer cust WHERE cust.cust_group_code = bg.cust_group_code and Bg.Cust_Bg_Code =  Cust.Cust_Code and bg.OPERATING_FACILITY_ID = ?  AND bg.FORMAT_CODE = ? AND bg.CUST_OR_BG = ?");

		dataMap.put("BIL_PRINT_FMT_FETCH_HDR_DTL",	"SELECT  INFO_TYPE,SEQ_NO, INFO_IN_COLUMN1,(SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='BILL-INFO' and INFO_NAME = DTL.INFO_IN_COLUMN1 and rownum=1) HDN1, "+
													 " INFO_IN_COLUMN2,(SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='BILL-INFO' and INFO_NAME = DTL.INFO_IN_COLUMN2 and rownum=1) HDN4, "+
													 " COLUMN1_STATIC_VALUE, (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.COLUMN1_STATIC_VALUE and rownum=1) HDN3, "+
													" COLUMN2_STATIC_VALUE, (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.COLUMN2_STATIC_VALUE and rownum=1) HDN6, "+
													" COLUMN1_STATIC_LEGEND, (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.COLUMN1_STATIC_LEGEND and rownum=1) HDN2, "+
													" COLUMN2_STATIC_LEGEND, (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.COLUMN2_STATIC_LEGEND and rownum=1) HDN5  FROM BL_BILL_PRINT_FORMAT_DTL DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND INFO_TYPE='BILL-INFO'");

		dataMap.put("BIL_PRINT_FMT_FETCH_FMT_BG",	"SELECT bg.format_code,bg.CUST_OR_BG, bg.CUST_GROUP_CODE, bg.CUST_BG_CODE, bg.BILL_TYPE, bg.PRINT_REPRINT_FLAG,cust.long_desc  FROM "+
													" BL_BILL_PRINT_FORMAT_CUST_BG bg, BL_BLNG_GRP  cust WHERE bg.OPERATING_FACILITY_ID =?  AND bg.FORMAT_CODE = ? AND bg.CUST_OR_BG = ? "+
													"  and cust.BLNG_GRP_ID = bg.cust_bg_code and cust.settlement_ind = 'C' ");

		dataMap.put("BIL_PRINT_FMT_FETCH_TITLE",	"SELECT  INFO_TYPE,SEQ_NO, INFO_IN_COLUMN1,(SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls  WHERE INFO_TYPE='HEADER-INFO' and INFO_NAME = DTL.INFO_IN_COLUMN1 and rownum=1) HDN1, COLUMN1_STATIC_VALUE, (select static_info_desc from bl_bill_print_static_info "+
													" WHERE lang_legend_id = DTL.COLUMN1_STATIC_VALUE and rownum=1) HDN2  FROM BL_BILL_PRINT_FORMAT_DTL DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND INFO_TYPE='HEADER-INFO'");

		dataMap.put("BIL_PRINT_FMT_FETCH_TOTAL",	"SELECT  INFO_TYPE,SEQ_NO, INFO_IN_COLUMN1, "+
													" (SELECT distinct INFO_DESCRIPTION  FROM bl_bill_print_info_dtls    WHERE INFO_TYPE='BILL-TOTAL-INFO'  and INFO_NAME = DTL.INFO_IN_COLUMN1 and rownum=1) HDN1,  "+
													 " column1_static_legend, "+
													" (select static_info_desc from bl_bill_print_static_info WHERE lang_legend_id = DTL.column1_static_legend and rownum=1) hdn2,  "+
													 "  column1_detail_req_yn,column1_no_print_if_zero_yn "+
													" FROM BL_BILL_PRINT_FORMAT_DTL DTL WHERE OPERATING_FACILITY_ID = ?  AND FORMAT_CODE = ? AND INFO_TYPE='BILL-TOTAL-INFO'");


		/*Queries Added by Rajesh Varadharajan for Billing Print Format*/
		////Added two parameters V181005-Gayathri/MMS-DM-SCF-0243.1
		dataMap.put("DISCOUNT_DETAILS_FETCH",	  "SELECT blng_class_code, blng_serv_ind, cust_pc_ind,  ip_rate, op_rate, emer_rate, ref_rate, daycare_rate, min_charge_amt, max_charge_amt, base_qty, gross_net_appl_ind, apply_disc_yn, "+
					"to_char(valid_from,'dd/mm/yyyy') valid_from,to_char(valid_to,'dd/mm/yyyy') valid_to,st_item_public_price_chk_yn,st_item_rate_basis_ind  from  bl_serv_cust_pc_price where "+
		            "operating_facility_id   = ? "+
	             "AND NVL(blng_serv_ind,'#')          = NVL(?,'#') "+
	             "AND cust_pc_ind            = ? " +
	             "AND cust_pc_code         = ? "+
	             "AND BLNG_SERV_CODE         = ? "+
				 "AND BLNG_CLASS_CODE		 		  = DECODE(?,'A',BLNG_CLASS_CODE,?)"+
	             "AND NVL(CUST_GROUP_CODE,'#')        = NVL(?,'#') "+
	             "AND NVL(POLICY_TYPE_CODE,'#')       = NVL(?,'#') "+
				 "AND TO_CHAR (valid_from, 'dd/mm/yyyy') >= NVL(?,to_char(valid_from,'dd/mm/yyyy'))");

		/*Queries Added by Rajesh Varadharajan for Service Location*/
		dataMap.put("SERVICE_LOCN_FETCH_DATA",	"Select Long_Desc,Short_Desc From Bl_Service_Locn "+
												"where Operating_Facility_Id = ? and serv_locn_code = ?");
		/*Queries Added by Rajesh Varadharajan for Service Location*/
		
		//start - added by Pradeepa for Medical Report Authorization 
		dataMap.put("MED_REP_OUTSTD_AMT_AUTH_YN",	"SELECT auth_start_time FROM bl_mr_authorized_patient WHERE  operating_facility_id=? and patient_id=? ");
		dataMap.put("MED_REP_OUTSTD_AMT_AUTH_YN_CHECK",	"SELECT * FROM bl_mr_authorized_patient WHERE  operating_facility_id=? and patient_id=? and sysdate between auth_start_time AND auth_start_time + (?/24) ");
		dataMap.put("MED_REP_REQ_AUTH_VALIDITY",	"select MEDICAL_REQ_AUTHORIZE_VALIDITY from mr_parameter ");
		dataMap.put("MED_REP_OUTSTD_AMT_AUTH_INSERT", "INSERT INTO bl_mr_authorized_patient(operating_facility_id, patient_id,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,auth_start_time) VALUES(?,?,?,sysdate,?,?,?,sysdate,?,?,sysdate)");
		dataMap.put("MED_REP_OUTSTD_AMT_AUTH_UPDATE", "UPDATE bl_mr_authorized_patient SET auth_start_time=sysdate,MODIFIED_BY_ID=?" +
													",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE  operating_facility_id=? and patient_id=? ");
		dataMap.put("MED_REP_OUTSTD_AMT_AUTH_DELETE",	"DELETE FROM bl_mr_authorized_patient WHERE operating_facility_id=? AND patient_id=? ");

		
		//ends - added by Pradeepa for Medical Report Authorization 
		
		/*Queries Added by Rajesh Varadharajan for Income Accounts*/
		dataMap.put("INCOME_ACCOUNTS_GET_INTERFACE",	"select ACC_INT_DESC description, ACC_INT_CODE code from BL_GL_ACCOUNT_LANG_VW where upper(language_id) = upper(?) "+
														" and ACC_ENTITY_CODE=? and nvl(status,'X') != 'S' and upper(ACC_INT_CODE) like upper(?)  ");		

		dataMap.put("INCOME_ACCOUNTS_GET_BILL_TYPE",	"select long_desc description, bill_type_code code from bl_bill_type_lang_vw where upper(language_id) = upper(?)  "+
														"and upper(bill_type_code) like upper(?) ");

		dataMap.put("INCOME_ACCOUNTS_GET_ACC_ENTITY",	"SELECT ACC_ENTITY_CODE,ACC_ENTITY_NAME   FROM SY_ACC_ENTITY_LANG_VW  "+
														"WHERE ACC_ENTITY_ID = ?  AND UPPER(LANGUAGE_ID) = UPPER(?)");
		dataMap.put("INCOME_ACCOUNTS_INTERFACE",	"Select INCOME_ACC_INT_CODE,to_char(EFF_TO_DATE,'dd/mm/yyyy') EFF_TO_DATE From BL_type_for_BLNG_SERV "+
				"where ACC_ENTITY_CODE = ? and BILL_TYPE_CODE = ? and BLNG_SERV_CODE = ? and to_char(EFF_FROM_DATE,'dd/mm/yyyy') = ? ");
		
		dataMap.put("INCOME_ACCOUNTS_GET_RULE",	"SELECT LONG_DESC description  FROM BL_ADDL_CHARGE_RULE_LANG_VW  WHERE FACILITY_ID = ?  AND RULE_CODE = ?  AND "+
													"UPPER(LANGUAGE_ID) = UPPER(?) ");
		
		dataMap.put("ADDITIONAL_CHARGE_INTERFACE",	"Select INCOME_ACC_INT_CODE,to_char(EFF_TO_DATE,'dd/mm/yyyy') EFF_TO_DATE From bl_addl_charge_inc_int "+
				"where ACC_ENTITY_CODE = ? and BILL_TYPE_CODE = ? and BLNG_SERV_CODE = ? and to_char(EFF_FROM_DATE,'dd/mm/yyyy') = ? and FACILITY_ID = ? and RULE_CODE = ? ");

		/*Queries Added by Rajesh Varadharajan for Income Accounts*/
		
		//Queries Added for  Transactions - Rajesh V
		dataMap.put("CP_SERVICE_GROUP", "SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper(?) order by SERV_GRP_CODE");
		dataMap.put("GET_BLNG_SERV_LUKP", "SELECT SERV_GRP_CODE,SHORT_DESC FROM BL_BLNG_SERV_GRP_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(STATUS,'N')='N' ORDER BY SERV_GRP_CODE ");
		dataMap.put("CP_ORDER_CATEGORY", "select order_category code, short_desc description from or_order_category_lang_vw where upper(language_id) = upper(?)");
		dataMap.put("BR_SERVICE_LOCATION", "select SHORT_DESC,SERV_LOCN_CODE FROM BL_SERVICE_LOCN_LANG_VW  WHERE OPERATING_FACILITY_ID = ? AND UPPER(LANGUAGE_ID) = UPPER(?) AND NVL(STATUS,'X') != 'S'");
		dataMap.put("BR_BILL_OPTIONS", "SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) LIST_LABEL, A.LIST_ELMT_VALUE FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B "+
									       " WHERE A.MODULE_ID = 'BL' "+ 
									       " AND A.MODULE_ID = B.MODULE_ID (+) "+
									       " AND A.LIST_REF = B.LIST_REF (+) "+
									       " AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) "+
									       " AND A.LIST_REF = 'BILVT_ND_OPTION' "+
									       " AND upper(B.LANGUAGE_ID (+))  = upper(?) "+
									       " ORDER BY A.LIST_SRL_NO "); 
		//Queries Added for Transactions - Rajesh V
		
		// Queries for IPBedcharges Episode - Added by Karthik on 28-Aug-2013 Starts  
        dataMap.put("BL_OPBEDCHARGE_EPISODEID_LOOKUP","SELECT EPISODE_ID EPISODE_ID,ADMISSION_DATE_TIME ADMISSION_DATE_TIME, DISCHARGE_DATE_TIME DISCHARGE_DATE_TIME FROM BL_EPISODE_FIN_DTLS WHERE OPERATING_FACILITY_ID =@facility_id AND EPISODE_TYPE IN ('I', 'D') AND PATIENT_ID =@patient_id ");
        dataMap.put("BL_OPBEDCHARGE_BEDDETAILS_LOOKUP","SELECT PATIENT_ID PATIENT_ID, SRL_NO SRL_NO, FR_BED_TYPE_CODE FR_BED_TYPE_CODE, TO_BED_TYPE_CODE TO_BED_TYPE_CODE, TO_BED_CLASS_CODE TO_BED_CLASS_CODE FROM IP_ADT_TRN WHERE FACILITY_ID=@facility AND  PATIENT_ID=@patient_id AND ENCOUNTER_ID=@encounter_id");
        dataMap.put("BL_OPBEDCHARGE_BILLCLASS_LOOKUP","SELECT b.long_desc description, b.blng_class_code code FROM bl_blng_class a,bl_blng_class_lang_vw b WHERE a.status IS NULL AND NVL(PATIENT_CATEGORY_CODE,'X') IN ('I','D','X') AND a.blng_class_code=b.blng_class_code AND language_id =@locale and upper(b.blng_class_code) like upper(?) and upper(b.long_desc) like upper(?)");
        dataMap.put("BL_OPBEDCHARGE_BILLSERV_LOOKUP","SELECT LONG_desc description, blng_serv_code code FROM bl_blng_serv_LANG_VW WHERE status IS NULL and RATE_ENTRY_BY_USER_FLAG='R' AND LANGUAGE_ID=@locale and upper(blng_serv_code) like upper(?) and upper(LONG_desc) like upper(?)");
        dataMap.put("BL_OPBEDCHARGE_MULTI_LOOKUP","SELECT PATIENT_ID PATIENT_ID,SRL_NO SRL_NO,FR_BED_TYPE_CODE FR_BED_TYPE_CODE,TO_BED_TYPE_CODE TO_BED_TYPE_CODE,TO_BED_CLASS_CODE TO_BED_CLASS_CODE FROM IP_ADT_TRN WHERE FACILITY_ID =@facility_id AND PATIENT_ID =@patient_id AND ENCOUNTER_ID =@episode_id");
        dataMap.put("BL_OPBEDCHARGE_BILLSERV_SRCH_PAGE_QRY","SELECT BLNG_SERV_CODE as code,SHORT_DESC   FROM BL_BLNG_SERV  WHERE BLNG_SERV_CODE in(@blng_serv_code,substr(@blng_serv_code,1,3) ,substr(@blng_serv_code,1,2) ) union "+
        		"SELECT SERV_CLASSIFICATION_CODE as code,SHORT_DESC   FROM BL_SERV_CLASSIFICATION  WHERE SERV_CLASSIFICATION_CODE in(@blng_serv_code,substr(@blng_serv_code,1,3) ,substr(@blng_serv_code,1,2) ) union "+
        		"SELECT SERV_GRP_CODE as code,SHORT_DESC   FROM BL_BLNG_SERV_GRP  WHERE SERV_GRP_CODE in(@blng_serv_code,substr(@blng_serv_code,1,3) ,substr(@blng_serv_code,1,2) ) "+"order by code desc");
        dataMap.put("BL_OPBEDCHARGE_BILLSERV_SRCHCODE_PAGE_QRY","SELECT CUST_PC_IND,CUST_PC_CODE,TO_CHAR(VALID_FROM, 'DD-MON-YYYY'),TO_CHAR(VALID_TO, 'DD-MON-YYYY') FROM "+
				"BL_SERV_CUST_PC_PRICE WHERE CUST_PC_IND = decode(NVL(@applicable_to,'A'),'A',cust_pc_ind,@applicable_to) AND blng_serv_code = @blng_serv_code and ROWID IN ( SELECT "+
				"MAX(ROWID) FROM BL_SERV_CUST_PC_PRICE WHERE nvl(trunc(valid_to),trunc(sysdate)) >= trunc(sysdate) AND "+
				"CUST_PC_IND=decode(NVL(@applicable_to,	'A'),'A',cust_pc_ind,@applicable_to) AND blng_serv_code = @blng_serv_code GROUP BY CUST_PC_IND,CUST_PC_CODE,BLNG_SERV_CODE, trunc(valid_from)) ");
        dataMap.put("BL_OPBEDCHARGE_BILLSERV_SRCHPRICE_PAGE_QRY","SELECT BLNG_CLASS_CODE,RATE_FACTOR_IND,IP_RATE,OP_RATE,REF_RATE,EMER_RATE,DAYCARE_RATE,MIN_CHARGE_AMT,BASE_QTY,APPLY_DISC_YN FROM BL_SERV_CUST_PC_PRICE"+ 
    			" WHERE blng_serv_code = @blng_serv_code AND cust_pc_ind=@applicable_to "+
    			" and nvl(trunc(valid_to),trunc(sysdate)) >= trunc(sysdate) " +
    			" and (CUST_PC_CODE=@cust_pc_code) and (BLNG_SERV_CODE=@blng_serv_code) and (VALID_FROM=@valid_from)");
        dataMap.put("BL_OPBEDCHARGE_BILLSERV_SRCHDISCOUNT_PAGE_QRY","SELECT IP_DISC_PERC,DAYCARE_DISC_PERC,OP_DISC_PERC,EMER_DISC_PERC,REF_DISC_PERC,"+
    			"TO_CHAR(VALID_FROM, 'DD-MON-YYYY'),TO_CHAR(VALID_TO, 'DD-MON-YYYY')  FROM BL_SERV_CUST_PC_DISCOUNT WHERE CUST_PC_IND = @applicable_to AND "+
    			"CUST_PC_CODE =@cust_pc_code AND PKG_SERV_CODE = @blng_serv_code AND BLNG_CLASS_CODE = @blng_class_code and valid_from >=@valid_from ");
        dataMap.put("BL_OPBEDCHARGE_ALLDETAILS","SELECT ADT_SL_NO,BED_TYPE_CODE_FR,BED_TYPE_CODE_TO,BLNG_CLASS_CODE,BLNG_SERV_CODE,APPLY_FOR_PREV_CHARGES_YN FROM BL_BED_CHRG_BY_TFR_EPISODE WHERE 1=1 and (PATIENT_ID=@patient_id) and (EPISODE_ID=@episode_id)");
        dataMap.put("BL_OPBEDCHARGE_BEDTYPEDESC","select short_desc from ip_bed_type_LANG_vw where language_id =@locale AND BED_TYPE_CODE=?  ");
        dataMap.put("BL_OPBEDCHARGE_BLNGSERVDESC","SELECT SHORT_DESC FROM bl_blng_serv_LANG_VW WHERE status IS NULL and RATE_ENTRY_BY_USER_FLAG='R' and LANGUAGE_ID=@locale and BLNG_SERV_CODE=?");
        dataMap.put("BL_OPBEDCHARGE_BLNGCLASSDESC","SELECT b.long_desc FROM bl_blng_class a,bl_blng_class_lang_vw b WHERE a.status IS NULL AND NVL(PATIENT_CATEGORY_CODE,'X') IN ('I','D','X') AND a.blng_class_code=b.blng_class_code AND language_id =@locale and b.blng_class_code=?");
        dataMap.put("BL_OPBEDCHARGE_ACC_ENT_DESC","select  ACC_ENTITY_NAME from sy_acc_entity where ACC_ENTITY_ID=?");
        dataMap.put("BL_OPBEDCHARGE_PRC_CLS_DESC","select LONG_DESC from bl_price_class where PRICE_CLASS_CODE=?");
        dataMap.put("BL_OPBEDCHARGE_BLNG_GRP_DESC","select LONG_DESC from bl_blng_grp where BLNG_GRP_ID=?");
        dataMap.put("BL_OPBEDCHARGE_CUST_GRP_DESC","select long_name from ar_customer where cust_code=?");
		// Queries for  IPBedcharges Episode - Added by Karthik on 28-Aug-2013 Ends 

		dataMap.put("FUNCTION_TYPE_DROPDOWN", "SELECT FUNCTION_ID,FUNCTION_DESC FROM BL_FUNCTIONS union select '**','All Functions' from dual minus SELECT FUNCTION_ID,FUNCTION_DESC FROM BL_FUNCTIONS where FUNCTION_ID= 'INTERIM_BILL_AUTH' AND blcommon.is_function_applicable_yn ('BL', 'BL_INTERIM_BILL_APPROVAL') = 'N'"); //V210131
		dataMap.put("PREVILEGE_TYPES_CHKBOX", "SELECT PRIVILEGE_DESC FROM BL_PRIVILEGES ");
		dataMap.put("SERVICE_GROUP_DROPDOWN", "SELECT SERV_GRP_CODE,LONG_DESC FROM BL_BLNG_SERV_GRP_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(STATUS,'N')='N' ORDER BY SERV_GRP_CODE");
		
		/*Added by karthik on 24-june-2014 for Report Module Begins*/
		dataMap.put("BLREPORT_LOAD_REPORT_DETAILS", "select SEQ_NO,COLUMN_INFO,CLUMN_VALUE,TOT_REQ,GROUP_ID,ORDERBY_REQ from RE_REPORT_INFO_DTLS where REPORT_ID=?");
		dataMap.put("BLREPORT_LOAD_REPORT_HEADER", "select SEQ_NO,FIELD_INFO,ALINGMENT,FIELD_VALUE from RE_REPORT_INFO_HDR where REPORT_ID=?");
		dataMap.put("BLREPORT_LOAD_REPORT_CRITERIA", "select SEQ_NO,COLUMN_INFO,TYPE,MANDATORY_YN,DFLT_VALUE,GROUP_ID from RE_REPORT_GEN_CRITRIA where REPORT_ID=?  order by SEQ_NO asc");
		dataMap.put("BLREPORT_LOAD_REPORT_ACCESSRIGHTS", "select USER_TYPE,USER_CODE,to_char(EFF_FROM,'dd/mm/yyyy') ,to_char(EFF_TO,'dd/mm/yyyy') from RE_REPORT_SECURITY_USER where REPORT_ID=?");
		dataMap.put("BLREPORT_GET_DATAGROUPLIST", "select distinct(GROUP_ID) from TEMP_GRP_DTLS");
		dataMap.put("BLREPORT_SELECT_DATAGROUP_INFO", "select SEQ_NO,COLUMN_INFO,CLUMN_VALUE,TOT_REQ,ORDERBY_REQ from TEMP_GRP_DTLS where GROUP_ID=?");
		dataMap.put("BLREPORT_DELETE_REPORT_TITLEINFO", "delete from RE_REPORT where REPORT_ID=?");
		dataMap.put("BLREPORT_INSERT_REPORT_TITLEINFO", "insert into RE_REPORT(REPORT_ID,REPORT_NAME,EFF_FROM,EFF_TO) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))");
		dataMap.put("BLREPORT_INSERT_REPORT_HEADERINFO", "insert into RE_REPORT_INFO_HDR(REPORT_ID,SEQ_NO,FIELD_INFO,ALINGMENT,FIELD_VALUE) values (?,?,?,?,?)");
		dataMap.put("BLREPORT_DELETE_REPORT_HEADERINFO", "delete from RE_REPORT_INFO_HDR  where REPORT_ID=?");
		dataMap.put("BLREPORT_DELETE_REPORT_DETAILS", "delete from RE_REPORT_INFO_DTLS  where REPORT_ID=?");
		dataMap.put("BLREPORT_DELETE_REPORT_CRITERIA", "delete from RE_REPORT_GEN_CRITRIA  where REPORT_ID=?");
		dataMap.put("BLREPORT_INSERT_REPORT_DETAILS", "insert into RE_REPORT_INFO_DTLS(REPORT_ID,GROUP_ID,SEQ_NO,COLUMN_INFO,CLUMN_VALUE,TOT_REQ,ORDERBY_REQ) values (?,?,?,?,?,?,?)");
		dataMap.put("BLREPORT_INSERT_REPORT_CRITERIAINFO", "insert into RE_REPORT_GEN_CRITRIA(REPORT_ID,SEQ_NO,COLUMN_INFO,TYPE,MANDATORY_YN,DFLT_VALUE,GROUP_ID) values (?,?,?,?,?,?,?)");
		dataMap.put("BLREPORT_DELETE_USERACCESSRIGHTS", "delete from RE_REPORT_SECURITY_USER  where REPORT_ID=?");
		dataMap.put("BLREPORT_INSERT_USERACCESSRIGHTS", "insert into RE_REPORT_SECURITY_USER(REPORT_ID,USER_TYPE,USER_CODE,EFF_FROM,EFF_TO) values (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))");
		dataMap.put("BLREPORT_QUERY_RESULT_LIST", "select REPORT_ID,REPORT_NAME,to_char(EFF_FROM,'dd/mm/yyyy') EFF_FROM,to_char(EFF_TO,'dd/mm/yyyy') EFF_TO from RE_REPORT");
		dataMap.put("BLREPORT_SELECT_USERGROUP", "select code,description from(select user_group_id code,long_desc description from bl_user_group union select '**','All Groups' from dual) where upper(code) like UPPER(?) and upper(description) like UPPER(?)");
		dataMap.put("BLREPORT_SELECT_USER", "select code,description from(select bl_user_id code, appl_user_name description from sm_appl_user, bl_user where bl_user_id = appl_user_id union select '**','All Users' from dual) where upper(code) like UPPER(?) and upper(description) like UPPER(?)");
		dataMap.put("BLREPORT_GET_QUERY_FROM_TABLE", "SELECT QUERY FROM IBAEHIS.DUMMYQUERYTABLE WHERE ID=?");
		/*Added by karthik on 24-june-2014 for Report Module Ends*/
		
		//Queries for Defaulting Search Elements - Rajesh V
		dataMap.put("DFLT_SEARCH_LOAD_CRITERIA", 	"Select SEARCH_DISPL_FIELDS "+
													"From BL_DFLT_SEARCH_ELEMENTS "+
													"Where OPERATING_FACILITY_ID = ? "+
													"And USER_ID = ? "+
													"And FUNCTION_ID = ? ");
		
		dataMap.put("DFLT_SEARCH_RECORD_COUNT", 	"Select count(*) as Total "+
													"From BL_DFLT_SEARCH_ELEMENTS "+
													"Where OPERATING_FACILITY_ID = ? "+
													"And USER_ID = ? "+
													"And FUNCTION_ID = ? ");
		
		dataMap.put("DFLT_SEARCH_INSERT_NEW", 	"Insert into BL_DFLT_SEARCH_ELEMENTS(OPERATING_FACILITY_ID,FUNCTION_ID,"+
												"USER_ID,SEARCH_DISPL_FIELDS,ADDED_DATE,MODIFIED_DATE,ADDED_BY_ID,"+
												"MODIFIED_BY_ID,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO,ADDED_FACILITY_ID,"+
												"MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,sysdate,?,?,?,?,?,?)");
		
		dataMap.put("DFLT_SEARCH_UPDATE_EXISTING", 	"Update BL_DFLT_SEARCH_ELEMENTS "+
													"Set SEARCH_DISPL_FIELDS = ?, MODIFIED_DATE = sysdate, "+
													"MODIFIED_BY_ID = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? "+
													"Where OPERATING_FACILITY_ID = ? And FUNCTION_ID= ? And USER_ID = ? ");
		
		dataMap.put("INSERT_SY_PROG_PARAM", "{ call   BL_INSERT_SY_PROG_PARAM (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		//Queries for Defaulting Search Elements - Rajesh V
		
		//Queries for MMS-CRF-125 Rajesh V
		dataMap.put("CHECK_OVERLAP_FLAG", "Select count(*) total_count from bl_package_price_req_dtls where operating_facility_id = ? and "+ 
											" session_id = ? and pgm_date = ? and overlap_flag = 1");
		dataMap.put("GET_OVERLAP_RECORD", "Select package_code,CUST_GROUP_CODE,CUST_CODE,to_char(eff_from_date_new,'dd/mm/yyyy') eff_from_date,TO_CHAR (eff_to_date_new, 'dd/mm/yyyy') eff_to_date,BLNG_GRP_ID,BLNG_CLASS_CODE "+
											 "from bl_package_price_req_dtls "+ 
											 "where operating_facility_id = ? and session_id = ?  "+
											 "and pgm_date = ? and overlap_flag = 1");
		dataMap.put("GET_SESSION_ID", "select USERENV ('sessionid') session_id,TO_CHAR (SYSDATE, 'DDMMYYHH24MISS') pgm_date from dual");
		
		dataMap.put("INSERT_PKG_UPD_REQ", "{ call  blpackage.Insertpkupdreq (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020,// added against MMS-DM-CRF-118.9
		dataMap.put("POPULATE_PKG_UPD_REQ", "{ call  blpackage.jobsubmitpkupdreq (?,?,?,?,?,?,?) }");
		dataMap.put("CHECK_BULK_UPD_ACCESS", "Select 'X' from bl_users_for_credit_auth where operating_facility_id = ? and nvl(package_definition_change_yn,'N')='Y' and credit_auth_user_id = ? ");
		dataMap.put("GET_PKG_BACK_DATE", "Select PKG_EFF_FRM_BACKDATE_DAYS from bl_parameters where operating_facility_id = ?");
		//Queries for MMS-CRF-125 Rajesh V
		/*Added by karthik on 11-Nov-2014 for Pkg Price Query Module starts*/
		dataMap.put("BLPKGPRICEQUERY_PKG_PRICE_MAIN", "select USER_ID,CUST_GROUP_CODE,CUST_CODE,BLNG_GRP_ID,BLNG_CLASS_CODE,EFF_FROM_DATE,EFF_TO_DATE from BL_PACKAGE_PRICE_REQ_DTLS");
		dataMap.put("BLPKGPRICEQUERY_BLNGGRP_DESC", "SELECT SHORT_DESC FROM BL_BLNG_GRP WHERE BLNG_GRP_ID = ?");
		dataMap.put("BLPKGPRICEQUERY_BLNGCLASS_DESC", "SELECT SHORT_DESC FROM BL_BLNG_CLASS WHERE BLNG_CLASS_CODE = ?");
		dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE", "select dtls.PACKAGE_CODE,DECODE (dtls.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = dtls.operating_facility_id AND pkg.package_code = dtls.package_code)) SHORT_DESC,decode(dtls.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual, nvl(dtls.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
				"req.MARK_UP_IND,req.ROUNDING_BY_INTEGER,req.ROUND_MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,dtls.JOB_ERROR_MESG "+
				"from BL_PACKAGE_PRICE_UPDTN_REQ req,bl_package_price_req_dtls dtls "+
				"where req.OPERATING_FACILITY_ID = dtls.OPERATING_FACILITY_ID "+				
				"and req.session_id = dtls.session_id "+
				"and req.pgm_date = dtls.pgm_date "+
				"and req.user_id = dtls.user_id "+
				"and req.sl_no = dtls.sl_no  AND dtls.package_code != '**' "+				
				"and (dtls.ERROR_FLAG = 1 OR dtls.job_error_mesg is not null) "+
				"and req.RATE_DISCOUNT_IND = 'R' "); 
		dataMap.put("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_PRICE", "select dtls.PACKAGE_CODE,DECODE (dtls.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = dtls.operating_facility_id AND pkg.package_code = dtls.package_code)) SHORT_DESC,decode(dtls.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual, nvl(dtls.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
						"req.MARK_UP_IND,req.ROUNDING_BY_INTEGER,req.ROUND_MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE "+
						"from BL_PACKAGE_PRICE_UPDTN_REQ req,bl_package_price_req_dtls dtls "+
						"where req.OPERATING_FACILITY_ID = dtls.OPERATING_FACILITY_ID "+						
						"and req.session_id = dtls.session_id "+
						"and req.pgm_date = dtls.pgm_date "+
						"and req.user_id = dtls.user_id "+
						"and req.sl_no = dtls.sl_no  AND dtls.package_code != '**' "+						
						"and (dtls.ERROR_FLAG = 0 AND dtls.job_error_mesg is null) "+
						"and req.RATE_DISCOUNT_IND = 'R' "); 
		dataMap.put("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_DISC", "select dtls.PACKAGE_CODE,DECODE (dtls.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = dtls.operating_facility_id AND pkg.package_code = dtls.package_code)) SHORT_DESC,decode(dtls.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual,nvl(dtls.BLNG_GRP_ID,'') BLNG_GRP_ID,nvl(dtls.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
				"req.MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE "+
				"from BL_PACKAGE_PRICE_UPDTN_REQ req,bl_package_price_req_dtls dtls "+
				"where req.OPERATING_FACILITY_ID = dtls.OPERATING_FACILITY_ID "+				
				"and req.session_id = dtls.session_id "+
				"and req.pgm_date = dtls.pgm_date "+
				"and req.user_id = dtls.user_id "+
				"and req.sl_no = dtls.sl_no  AND dtls.package_code != '**' "+				
				"and (dtls.ERROR_FLAG = 0 AND dtls.job_error_mesg is null) "+
				"and req.RATE_DISCOUNT_IND = 'D' ");
	dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC", "select dtls.PACKAGE_CODE,DECODE (dtls.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = dtls.operating_facility_id AND pkg.package_code = dtls.package_code)) SHORT_DESC,decode(dtls.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual,nvl(dtls.BLNG_GRP_ID,'') BLNG_GRP_ID,nvl(dtls.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
				"req.MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,dtls.JOB_ERROR_MESG "+
				"from BL_PACKAGE_PRICE_UPDTN_REQ req,bl_package_price_req_dtls dtls "+
				"where req.OPERATING_FACILITY_ID = dtls.OPERATING_FACILITY_ID "+				
				"and req.session_id = dtls.session_id "+
				"and req.pgm_date = dtls.pgm_date "+
				"and req.user_id = dtls.user_id "+
				"and req.sl_no = dtls.sl_no  AND dtls.package_code != '**' "+				
				"and (dtls.ERROR_FLAG = 1 OR dtls.job_error_mesg is not null) "+
				"and req.RATE_DISCOUNT_IND = 'D' ");
	
	dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ", "select req.PACKAGE_CODE,DECODE (req.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = req.operating_facility_id AND pkg.package_code = req.package_code)) SHORT_DESC,decode(req.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual,nvl(req.BLNG_GRP_ID,'') BLNG_GRP_ID,nvl(req.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
			"req.MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,req.JOB_ERROR_MESG "+
			"from BL_PACKAGE_PRICE_UPDTN_REQ req "+
			"where NOT EXISTS(SELECT 1  FROM bl_package_price_req_dtls dtls "+
		"WHERE  dtls.operating_facility_id = req.operating_Facility_id "+
		"AND    dtls.session_id = req.session_id  "+
		" AND    dtls.pgm_date = req.pgm_date AND dtls.sl_no = req.sl_no AND dtls.package_code != '**') "+
		"AND (req.error_flag = 1 OR req.job_error_mesg IS NOT NULL) "+
		"AND req.rate_discount_ind = 'D' "); 

	dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ", "select req.PACKAGE_CODE,DECODE (req.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = req.operating_facility_id AND pkg.package_code = req.package_code)) SHORT_DESC,decode(req.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual, nvl(req.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
			"req.MARK_UP_IND,req.ROUNDING_BY_INTEGER,req.ROUND_MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,req.JOB_ERROR_MESG "+
			"from BL_PACKAGE_PRICE_UPDTN_REQ req "+
			"where NOT EXISTS(SELECT 1  FROM bl_package_price_req_dtls dtls "+
			"WHERE  dtls.operating_facility_id = req.operating_Facility_id "+
			"AND    dtls.session_id = req.session_id  "+
			" AND    dtls.pgm_date = req.pgm_date AND dtls.sl_no = req.sl_no AND dtls.package_code != '**') "+
			"AND (req.error_flag = 1 OR req.job_error_mesg IS NOT NULL) "+
			"AND req.rate_discount_ind = 'R' "); 
	dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ_FOR_STAR", "select req.PACKAGE_CODE,DECODE (req.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = req.operating_facility_id AND pkg.package_code = req.package_code)) SHORT_DESC,decode(req.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual,nvl(req.BLNG_GRP_ID,'') BLNG_GRP_ID,nvl(req.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
			"req.MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,decode(req.job_error_mesg,NULL,'No Packages got affected for the request',req.job_error_mesg) job_error_mesg "+
			"from BL_PACKAGE_PRICE_UPDTN_REQ req "+
			"WHERE 1 in (SELECT count(*) FROM bl_package_price_req_dtls dtls "+
			          " WHERE dtls.operating_facility_id = req.operating_facility_id "+
			             "AND dtls.session_id = req.session_id "+
			             "AND dtls.pgm_date = req.pgm_date "+
			             "AND dtls.package_code = '**' ) "+
			   "AND 1 in (SELECT count(*) "+
			            "FROM bl_package_price_req_dtls dtls "+
			           "WHERE dtls.operating_facility_id = req.operating_facility_id "+
			             "AND dtls.session_id = req.session_id "+
			             "AND dtls.pgm_date = req.pgm_date) "+
		"AND (req.error_flag = 1 OR req.job_error_mesg IS NOT NULL OR req.job_error_mesg IS NULL ) "+
		"AND req.rate_discount_ind = 'D' "); 

	dataMap.put("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ_FOR_STAR", "select req.PACKAGE_CODE,DECODE (req.package_code,'**', 'All Packages',(SELECT short_desc FROM bl_package pkg WHERE pkg.operating_facility_id = req.operating_facility_id AND pkg.package_code = req.package_code)) SHORT_DESC,decode(req.CUST_GROUP_CODE,NULL,'Standard','Customer') Standard_Customer,decode(req.PACKAGE_CODE,'**','Bulk','Individual') Bulk_Individual, nvl(req.BLNG_CLASS_CODE,'') BLNG_CLASS_CODE,req.PRICE_TYPE,req.AMOUNT AMOUNT_PERCENTAGE, "+
			"req.MARK_UP_IND,req.ROUNDING_BY_INTEGER,req.ROUND_MARK_UP_IND,req.EFF_FROM_DATE,req.EFF_TO_DATE,decode(req.job_error_mesg,NULL,'No Packages got affected for the request',req.job_error_mesg) job_error_mesg "+
			"from BL_PACKAGE_PRICE_UPDTN_REQ req "+	
			"WHERE 1 in (SELECT count(*) FROM bl_package_price_req_dtls dtls "+
	          " WHERE dtls.operating_facility_id = req.operating_facility_id "+
	             "AND dtls.session_id = req.session_id "+
	             "AND dtls.pgm_date = req.pgm_date "+
	             "AND dtls.package_code = '**' ) "+
	           "AND 1 in (SELECT count(*) "+
	            "FROM bl_package_price_req_dtls dtls "+
	           "WHERE dtls.operating_facility_id = req.operating_facility_id "+
	             "AND dtls.session_id = req.session_id "+
	             "AND dtls.pgm_date = req.pgm_date) "+
			"AND (req.error_flag = 1 OR req.job_error_mesg IS NOT NULL OR req.job_error_mesg IS NULL ) "+
			"AND req.rate_discount_ind = 'R' "); 
		/*Added by karthik on 11-Nov-2014 for Pkg Price Query Module ends*/ 
	
	//Added by Rajesh V for IN55781
	dataMap.put("BL_PKG_ACROSS_ENC_YN", "select across_encounter_yn from bl_package where operating_facility_id = ? and package_code = ? ");
	dataMap.put("BL_PKG_PART_DEP_ALLOWED_YN", "SELECT allow_partial_deposit_yn "+
						  "FROM bl_package_base_price "+
						 "WHERE operating_facility_id = ? "+
						   "AND package_code = ? "+
						   "AND (blng_class_code = ? OR blng_class_code = '**') "+
						   "AND TRUNC (eff_from_date) = "+
						          "(SELECT TRUNC (MAX (eff_from_date)) "+
						             "FROM bl_package_base_price "+
						            "WHERE operating_facility_id = ? "+
						              "AND package_code = ? "+
						              "AND (blng_class_code = ? OR blng_class_code = '**') "+
						              "AND TRUNC (eff_from_date) <= TRUNC (SYSDATE))");
	
	dataMap.put("BL_PKG_PART_DEP_ALLOWED_YN_ASSOC", "SELECT allow_partial_deposit_yn "+
						  "FROM bl_package_base_price "+
						 "WHERE operating_facility_id = ? "+
						   "AND package_code = ? "+
						   "AND (blng_class_code = ? OR blng_class_code = '**') "+
						   "AND TRUNC (eff_from_date) = "+
						          "(SELECT TRUNC (MAX (eff_from_date)) "+
						             "FROM bl_package_base_price "+
						            "WHERE operating_facility_id = ? "+
						              "AND package_code = ? "+
						              "AND (blng_class_code = ? OR blng_class_code = '**') "+
						              "AND TRUNC (eff_from_date) <= (select trunc(added_date) "+
									 "from bl_package_sub_hdr "+ 
									 "where operating_facility_id = ? "+
									 "and patient_id = ? "+
									 "and package_code = ? "+
									 "and package_seq_no = ?))");
	//Added for KAUH-CRF-0318
	dataMap.put("GET_PATIENT_CLASS", "Select decode(patient_class,'XT','EX',patient_class) patient_class,short_desc from AM_PATIENT_CLASS_LANG_VW where language_id = ? ");
	dataMap.put("GET_EFF_DATE_FOR_RULE_CODE", "Select to_char(eff_date_from,'dd/mm/yyyy') eff_date_from,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to from BL_ADDL_CHARGE_RULE where facility_id = ? and rule_code = ? ");
	dataMap.put("GET_LAST_SEQ_NUM", "select nvl(max(SEQ_NO),0) seq_no from BL_SERV_RULE_CODE_HDR");
	dataMap.put("INSERT_TO_COSMETIC_RULE_HDR", "Insert into BL_SERV_RULE_CODE_HDR (OPERATING_FACILITY_ID,SEQ_NO,BILLING_GROUP_CODE,PATIENT_CLASS,CUSTOMER_GROUP_CODE,CUSTOMER_CODE, "+
											    "POLICY_TYPE_CODE,RULE_CODE,STATUS,ADDED_FACILITY_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE, "+
											    "MODIFIED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,MODIFIED_DATE) "+
											    "values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate)");
	
	dataMap.put("INSERT_TO_COSMETIC_RULE_CRITERIA","Insert into BL_SERV_RULE_CODE_CRITERIA (SEQ_NO,CRITERIA_TYPE,CRITERIA_CODE, "+
												    "ADDED_FACILITY_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE, "+
												    "MODIFIED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,MODIFIED_DATE) "+
													"values (?,?,?,?,?,?,sysdate,?,?,?,sysdate)");
	dataMap.put("INSERT_TO_COSMETIC_RULE_EXCLUSION","Insert into BL_SERV_RULE_CODE_EXCL (SEQ_NO,EXCLUSION_TYPE,EXCLUSION_CODE,INCLUDE_YN, "+
												    "ADDED_FACILITY_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE, "+
												    "MODIFIED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,MODIFIED_DATE) "+
												    "values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate)");
	
	dataMap.put("QUERY_COSMETIC_HDR", "select RULE_CODE,(Select short_desc from BL_ADDL_CHARGE_RULE Where facility_id = ? and rule_code = HDR.rule_code) Rule_desc,  "+ 
		"PATIENT_CLASS,  "+ 
		"BILLING_GROUP_CODE,Decode(Hdr.BILLING_GROUP_CODE,'**','All Billing Group', (Select short_desc from BL_BLNG_GRP_LANG_VW Where upper(language_id) = upper(?) and blng_grp_id = Hdr.BILLING_GROUP_CODE)) BILLING_GROUP_DESC,  "+ 
		"CUSTOMER_GROUP_CODE, Decode(Hdr.CUSTOMER_GROUP_CODE,'**','All Payer Group', (Select short_desc from ar_cust_group_lang_vw where upper(language_id) = upper(?) and cust_group_code = HDR.CUSTOMER_GROUP_CODE )) Customer_grp_desc,  "+  
		"CUSTOMER_CODE, Decode(Hdr.CUSTOMER_CODE,'**','All Payer', (Select short_name from ar_customer_lang_vw where upper(language_id) = upper(?) and Cust_Code = HDR.CUSTOMER_CODE )) Customer_desc,   "+
		"POLICY_TYPE_CODE, Decode(HDR.POLICY_TYPE_CODE,'**','All Policies', (Select short_desc from bl_ins_policy_types_lang_vw where operating_facility_id = ? and upper(language_id) = upper(?) and policy_type_code = HDR.POLICY_TYPE_CODE )) policy_desc, "+
        "NVL(STATUS,'D') STATUS  "+
		"from BL_SERV_RULE_CODE_HDR HDR "+
        "WHERE SEQ_NO = ?");
	
	dataMap.put("QUERY_COSMETIC_CRITERIA", "Select CRITERIA_TYPE,CRITERIA_CODE, "+
				"decode(CRITERIA_CODE,'**','All Billing Services', "+
				"blcommonproc.get_description('SERV_CRIT',CRITERIA_TYPE,CRITERIA_CODE,?)) criteria_desc "+
				"From BL_SERV_RULE_CODE_CRITERIA "+
				"Where SEQ_NO = ?  ");
	
	dataMap.put("QUERY_COSMETIC_EXCLUSION", "Select EXCLUSION_TYPE,EXCLUSION_CODE, "+
			"decode(EXCLUSION_CODE,'**','All Billing Services', "+
			"blcommonproc.get_description('SERV_CRIT',EXCLUSION_TYPE,EXCLUSION_CODE,?)) exclusion_desc, INCLUDE_YN "+
			"From BL_SERV_RULE_CODE_EXCL "+
			"Where SEQ_NO = ?  ");
	
	dataMap.put("UPDATE_COSMETIC_HDR", "Update BL_SERV_RULE_CODE_HDR "+
				"Set status = ?, modified_facility_id = ?,  "+
				"MODIFIED_BY_ID = ?,MODIFIED_AT_WS_NO = ?, "+
				"MODIFIED_DATE = sysdate  "+
				"Where Seq_no = ? ");
	
	dataMap.put("DELETE_COSMETIC_CRITERIA", "Delete from BL_SERV_RULE_CODE_CRITERIA "+
				"Where SEQ_NO = ? "+
				"And CRITERIA_TYPE = ? "+
				"And CRITERIA_CODE = ?");
	
	dataMap.put("DELETE_COSMETIC_EXCLUSION", "Delete from BL_SERV_RULE_CODE_EXCL "+
			"Where SEQ_NO = ? "+
			"And EXCLUSION_TYPE = ? "+
			"And EXCLUSION_CODE = ?");
	
	dataMap.put("UPDATE_COSMETIC_EXCLUSION","Update BL_SERV_RULE_CODE_EXCL "+
				"Set INCLUDE_YN = ?, modified_facility_id = ?,  "+
				"MODIFIED_BY_ID = ?,MODIFIED_AT_WS_NO = ?, "+
				"MODIFIED_DATE = sysdate "+  
				"Where SEQ_NO = ? "+ 
				"And EXCLUSION_TYPE = ? And EXCLUSION_CODE = ?");
	
	dataMap.put("COSMETIC_HDR_COUNT", "Select count(*) total_cnt "+
                  "from BL_SERV_RULE_CODE_HDR "+
                  "where operating_facility_id = ? "+
                  "and Billing_group_code = ? "+
                  "and patient_class = ? "+
                  "and customer_group_code = ? "+
                  "and customer_code = ? "+
                  "and Policy_type_code = ? "+
                  "and rule_code = ?");
	//Added for KAUH-CRF-0318	
	//Added for PMG-CRF-005 Pradeepa K
		dataMap.put("GET_PAT_CLASS", "SELECT PATIENT_CATEGORY_CODE FROM BL_BLNG_CLASS WHERE BLNG_CLASS_CODE=? ");
		//Added for PMG-CRF-005 Pradeepa K
	//Conversion Queries
	dataMap.put("GET_PRIV_FOR_CANCEL", "select  nvl(CANCEL_INDIRECT_SERV_YN,'N') CANCEL_INDIRECT_SERV_YN, "+
						"nvl(CANCEL_SELF_ENTERED_SRVC_ONLY,'N') CANCEL_SELF_ENTERED_SRVC_ONLY "+
						"from bl_user "+
						"where OPERATING_FACILITY_ID= ? "+
						"and		BL_USER_ID= ? ");
	
	dataMap.put("GET_BILL_RECEIPT_INFO_DTLS", "{ call bl_get_bill_gen_dtls.get_bill_hdr_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("GET_OUTSTANDING_BILLS", "{ call bl_get_bill_gen_dtls.get_outstanding_bills(?,?,?) }");
	dataMap.put("GET_UNBILLED_EPI_BILLS", "{ call bl_get_bill_gen_dtls.get_unbilled_episode_dtls(?,?,?) }");
	dataMap.put("GET_UNBILLED_EPI_SERVICE", "{ call bl_get_bill_gen_dtls.get_unbilled_srv_req_epi(?,?,?,?,?,?,?,?) }");
	dataMap.put("GET_PACKAGE_CLOSURE", "{ call bl_get_bill_gen_dtls.get_pkg_dtls_for_closure(?,?,?,?,?,?,?,?) }");
	dataMap.put("GET_PACKAGE_DTLS", "{ call bl_get_bill_gen_dtls.get_pkg_folio_dtls(?,?,?,?,?,?) }");
	dataMap.put("REOPEN_PACKAGE", "{ call blpackage.reopenpackage(?,?,?,?,?,?,?) }");
	dataMap.put("GET_PRIVILEGE_FOR_USER", "{ call blplaceservice.bl_get_user_service_access(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("GET_ENC_BILL_DTLS", "{ call bl_get_bill_gen_dtls.get_enc_payer_priority_dtls(?,?,?,?,?,?,?) }");
	dataMap.put("BED_COMPUTATION_YN", "{ call bl_get_bill_gen_dtls.bed_computation_alert1(?,?,?,?,?,?) }");
	dataMap.put("BED_COMPUTATION_ALERT", "{ call bl_get_bill_gen_dtls.bed_computation_alert1(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("BED_COMPUTATION_MAIN", "{ call bl_get_bill_gen_dtls.bed_charge(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("BED_COMPUTATION_MAIN_FIXED", "{ call bl_get_bill_gen_dtls.bed_charge_fixed_chkout(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("BILL_GENERATE_MAIN","{ call bl_get_bill_gen_dtls.proc_apply_bill_gen(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("RECLAC_DEPOSIT_SLMT","{ call bl_get_bill_gen_dtls.recalc_dep_slmt_amts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	dataMap.put("BILL_CASH_COUNTER_VALIDATE", "{call bl_get_bill_gen_dtls.bl_cash_counter_validate(?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("BL_SPECIAL_CLINIC_VALIDATE", "{call bl_get_bill_gen_dtls.bl_special_clinic_validate(?,?,?,?,?,?,?,?)}");
	dataMap.put("BILL_SETTLEMENT_AMOUNT_VALIDATE", "{call bl_get_bill_gen_dtls.validate_settlement_amt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("BILL_EXEMPTION_AMOUNT_VALIDATE", "{call bl_get_bill_gen_dtls.validate_exemption_amt(?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("FETCH_FOLIO_RECS", "{ call bl_get_bill_gen_dtls.fetch_folio_records(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("VALIDATE_SERV_EXCLUSION", "{call bl_get_bill_gen_dtls.validate_excl_record(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("CHECK_SERVICE_DISCOUNT", "Select bl_get_bill_gen_dtls.allow_adhoc_disc_yn(?,?,?,?,?) as allowed_yn from dual");
	dataMap.put("GET_INTERFACE_DTLS", "{ call bl_get_bill_gen_dtls.proc_admin_interface_recs(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	dataMap.put("UNPROCESSED_CHECK", "{call bl_get_bill_gen_dtls.unprocessed_check(?,?,?,?,?,?,?,?,?)}");
	dataMap.put("GET_UNBILLED_OUTST_AMT", "{call bl_get_bill_gen_dtls.PROC_GET_OUTST_UNBILL_AMT(?,?,?,?,?,?,?)}");
	//Conversion Queries
	
	//Added by Pradeepa for GDOH-CRF-127 
	dataMap.put("DFLT_BILLING_GRP", "SELECT A.APPL_BLNG_GRP_ID ,B.SHORT_DESC FROM BL_PAT_AUTO_CLASSFCTN_RULES A,BL_BLNG_GRP B,BL_CLASSFCTN_CODE C where A.APPL_BLNG_GRP_ID=B.BLNG_GRP_ID AND A.OPERATING_FACILITY_ID =? AND A.CLASSIFICATION_CODE =? AND A.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE AND A.INCOME_ASSET_IND = ? AND  C.INCL_FAMILY_YN = ? AND   ? BETWEEN A.LOWER_LIMIT AND nvl(A.UPPER_LIMIT,?) ");
	dataMap.put("DFLT_BILLING_GRP_IP", " AND B.IP_YN='Y'");
	//ENDS
	dataMap.put("MULTI_BILL_SLMT_DEPOSIT_LIST", 
			"SELECT a.DOC_TYPE_CODE,a.DOC_NUMBER,a.DOC_SRNO,a.SLMT_TYPE_CODE,(Select -DOC_OUTST_AMT from BL_PATIENT_LEDGER "+
				       "  WHERE   PATIENT_ID   = a.patient_id "+
				       "  and org_doc_type_code=a.doc_type_code "+
				       "  and org_doc_num=a.doc_number "+
				       "  and org_doc_srno=a.doc_srno "+
				       "   AND    ( RECPT_NATURE_CODE in ('AD','PR') OR (RECPT_NATURE_CODE in ('MI') AND RECPT_TYPE_CODE IN (SELECT RECEIPT_TYPE_CODE FROM BL_RECEIPT_TYPE WHERE SPL_AGN_DEPOSIT_YN     = 'Y')) ) "+
				       "  AND     NVL(TRX_STATUS,'N') = 'N'" +
				       "  AND     NVL(ADJ_AMT,0) != NVL(DOC_AMT,0)" +
				      "   AND     TRX_TYPE_CODE = '5'" +
				        "   AND     DOC_OUTST_AMT != 0 ) DOC_AMT  " +
				" FROM BL_RECEIPT_REFUND_dtl a "+
				"WHERE (a.doc_type_code,a.doc_number/*,doc_srno*/) in  "+
				"(select org_doc_type_code,org_doc_num /*,org_doc_srno*/ from BL_PATIENT_LEDGER "+
				"         WHERE       PATIENT_ID        = ? "+
				"         AND     RECPT_NATURE_CODE in ('AD','PR') "+
				"         AND     NVL(TRX_STATUS,'N') = 'N' "+
				"         AND     NVL(ADJ_AMT,0) != NVL(DOC_AMT,0) "+
				"         AND     TRX_TYPE_CODE = '5' "+
				"         AND     DOC_OUTST_AMT != 0  "+
				"         and     'N'= (select nvl(dont_adj_full_deposit_yn,'N') from bl_parameters "+
				"                       where OPERATING_FACILITY_ID = ?) "+
				"group by org_doc_type_code,org_doc_num "+
				"having sum(NVL(ADJ_AMT,0)) = 0 "+
				"union all "+
				"Select org_doc_type_code,org_doc_num /*,org_doc_srno*/ from BL_PATIENT_LEDGER "+
				"         WHERE       PATIENT_ID        = ? "+
				"         AND     RECPT_NATURE_CODE in ('AD','PR') "+
				"         AND     NVL(TRX_STATUS,'N') = 'N' "+
				"         AND     NVL(ADJ_AMT,0) != NVL(DOC_AMT,0) "+
				"         AND     TRX_TYPE_CODE = '5' "+
				"         AND     DOC_OUTST_AMT != 0  "+
				"         and     'Y'= (select nvl(dont_adj_full_deposit_yn,'N') from bl_parameters "+
				"                       where OPERATING_FACILITY_ID = ?) "+
				"union all "+
				"select org_doc_type_code,org_doc_num /*,org_doc_srno*/ from BL_PATIENT_LEDGER "+
				"         WHERE       PATIENT_ID        = ? "+
				"         AND     RECPT_NATURE_CODE in ('AD','PR','MI') "+
				"         AND     NVL(TRX_STATUS,'N') = 'N' "+
				"         AND     RECPT_TYPE_CODE IN (SELECT RECEIPT_TYPE_CODE FROM BL_RECEIPT_TYPE WHERE SPL_AGN_DEPOSIT_YN     = 'Y') "+
				"         AND     NVL(ADJ_AMT,0) != NVL(DOC_AMT,0) "+
				"         AND     TRX_TYPE_CODE = '5' "+
				"         AND     DOC_OUTST_AMT != 0  "+
				"group by org_doc_type_code,org_doc_num) "+
				"ORDER BY doc_type_code,doc_number, doc_srno "
			);
	dataMap.put("MULTI_BILL_SLMT_DEPOSIT_REMARK", "select NARRATION from  bl_receipt_refund_hdr where PATIENT_ID=? and DOC_TYPE_CODE=? and DOC_NUMBER=?");
	dataMap.put("MULTI_BILL_SLMT_DFLT_RCPT_TYPE", "select receipt_type_code from bl_receipt_type where recpt_nature_code='BI' and rownum <=1 ");
	dataMap.put("PATIENT_DEPOSIT_VALIDATE", "{ call bl_cash_slmt_limitation.BL_PATIENT_DEP_VAL_PROC_3t(?,?,?,?,?,?,?) }");   //V231128
	dataMap.put("PATIENT_RECEIPT_VALIDATE", "{ call bl_cash_slmt_limitation.BL_PATIENT_REC_VAL_PROC_3t(?,?,?,?,?,?,?,?,?,?,?,?,?) }");  //V231128
	
	dataMap.put("OUTSTANDING_AMT_ALL_ENCOUNTERS","{ call blcommon.calculate_outst_amount(?,?,?,?,?,?) }"); // Added by Subha on V07022018 for ML-MMOH-CRF-0757
	dataMap.put("UNBILLED_AMT_ALL_ENCOUNTERS", "SELECT NVL (SUM (NVL (upd_net_charge_amt, 0)), 0)" +
		              " p_unbilled_amt" +
		              " FROM bl_patient_charges_folio a" +
		              " WHERE operating_facility_id = ?" +
		              " AND patient_id = ?" +  
		              " AND bill_doc_num IS NULL" +
		              " AND (   'Y' = DECODE (?, 'ALMO', 'N', 'Y')" +
		                    " OR 1 =" +
		                          " (SELECT 1" +
		                             " FROM bl_blng_serv" +
		                            " WHERE blng_serv_code = a.blng_serv_code" +
		                              " AND NVL (dr_share_appl_yn, 'N') = 'Y'))"); // Added by Subha on V12022018 for ML-MMOH-CRF-0757

	//Added V180208-Aravindh/GHL-CRF-0500 below queries
	dataMap.put("GET_HOSP_HEADER_DTLS", "{ call Get_Header_Dtls(?,?,?,?,?,?,?,?) }");
	dataMap.put("GET_FACILITY_ADDR", "{ call get_facility_addr(?,?,?,?) }");
	
	dataMap.put("GET_LEGENDS_FRM_TRANS_DATA", "select pk_value, column_value as legends from sm_record_Trans_data where module_id = 'SM' and TABLE_ID = 'SM_LANG_LEGEND' " +
			" and substr(PK_VALUE,1,7) = 'BLRPSAD' and LANGUAGE_ID = ? ");
	/*
	dataMap.put("GET_SPL_DEPOSIT_TRANS", "select z.operating_facility_id, z.episode_type, z.patient_id, z.episode_id, z.visit_id, z.org_doc_type_code, z.org_doc_num, " +
			" z.org_doc_date, z.trx_status, z.recpt_type_code, z.doc_type, nvl(z.cr_amt,0) cr_amt,nvl(z.dr_amt,0) dr_amt, z.act_amt, " +
			" sum(nvl(cr_amt,0)-nvl(dr_amt,0)) over(partition by z.patient_id order by z.org_doc_date) bal, " +
			" Decode(episode_type,'R','External','O','Outpatient','D','Daycare','I','Inpatient','E','Emergency',' ') Episode_Desc, " +
			" decode(doc_type,'B','Bill','R','Receipt','F','Refund',' ') doc_type_desc, y.TITLE_CODE||' '||y.FIRST_NAME||' '||y.SECOND_NAME||' '||y.LAST_NAME Patient_Name, " +
			" decode(z.episode_id,0,' ',z.episode_id) new_episode_id, decode(z.cr_amt,0,' ',z.cr_amt) new_cr_amt, decode(z.dr_amt,0,' ',z.dr_amt) new_dr_amt, " +
			" decode(nvl(x.encounter_id,z.episode_id),0,' ',nvl(x.encounter_id,z.episode_id)) encounter_id, to_char(z.org_doc_date,'dd-Mon-yyyy') new_org_doc_date " +
			" from (select a.operating_facility_id, a.episode_type, a.patient_id, a.episode_id, a.visit_id, a.org_doc_type_code, a.org_doc_num, a.org_doc_date, " +
			" a.trx_status,a.recpt_type_code,recpt_refund_ind doc_type, case when recpt_refund_ind = 'R' then abs(a.doc_amt) else 0 end cr_amt, " +
			" case when recpt_refund_ind = 'F' then abs(a.doc_amt) else 0 end dr_amt, abs(a.doc_amt) act_amt from bl_patient_ledger a, bl_receipt_refund_hdr b " +
			" where a.operating_facility_id = b.operating_facility_id and a.patient_id = b.patient_id  and a.org_doc_type_code = b.doc_type_code " +
			" and a.org_doc_num = b.doc_number and a.recpt_type_code in (select receipt_type_code  from bl_receipt_type  where nvl (spl_agn_deposit_yn, 'N') = 'Y') " +
			" and a.trx_status is null and nvl (recpt_refund_ind, 'N') in ('R','F') and a.operating_facility_id = ? " +
			" and a.patient_id between nvl(?,a.patient_id) and nvl(?,a.patient_id) " +
			" union all " +
			" select a.operating_facility_id, c.episode_type, a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, " +
			" nvl(b.added_date,c.LAST_RECPT_DOC_DATE), a.trx_status,a.recpt_type_code, 'B' doc_type, 0 cr_amt, " +
			" sum(abs(b.doc_amt)) dr_amt, sum(abs(b.doc_amt)) act_amt " +
			" from bl_patient_ledger a, bl_patient_ledger_trn b, bl_bill_hdr c, bl_receipt_refund_hdr d " +
			" where a.recpt_type_code in (select receipt_type_code from bl_receipt_type where nvl (spl_agn_deposit_yn, 'N') = 'Y') and a.trx_status is null " +
			" and nvl (recpt_refund_ind, 'N') = 'R'  and b.operating_facility_id = a.operating_facility_id  and b.patient_id = a.patient_id " +
			" and b.org_doc_type_code = a.org_doc_type_code  and b.org_doc_num = a.org_doc_num and nvl(b.doc_amt,0) != 0 and b.trx_status is null " +
			" and c.operating_facility_id = b.operating_facility_id and c.patient_id = b.patient_id and c.doc_type_code = b.ad_pr_adj_bill_doc_type " +
			" and c.doc_num = b.ad_pr_adj_bill_doc_num  and a.operating_facility_id = d.operating_facility_id and a.patient_id = d.patient_id " +
			" and a.org_doc_type_code = d.doc_type_code and a.org_doc_num = d.doc_number " +
			" and a.recpt_type_code in (select receipt_type_code from bl_receipt_type where nvl (spl_agn_deposit_yn, 'N') = 'Y') and a.operating_facility_id = ? " +
			" and a.patient_id between nvl(?,a.patient_id) and nvl(?,a.patient_id) group by a.operating_facility_id, c.episode_type, " +
			" a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, nvl(b.added_date,c.LAST_RECPT_DOC_DATE), " +
			" a.trx_status,a.recpt_type_code, 'B'  ) z, MP_PATIENT_MAST y, pr_encounter x " +
			" where z.patient_id = y.patient_id and z.patient_id = x.patient_id(+) and z.episode_id = x.episode_id(+) and z.visit_id = x.OP_EPISODE_VISIT_NUM(+) " +
			" order by patient_id asc, org_doc_date asc");
	*/
	
	dataMap.put("GET_SPL_DEPOSIT_TRANS", "select z.operating_facility_id, z.episode_type, z.patient_id, z.episode_id, z.visit_id, z.org_doc_type_code, z.org_doc_num, " +
			" z.org_doc_date, z.trx_status, z.recpt_type_code, z.doc_type, nvl(z.cr_amt,0) cr_amt,nvl(z.dr_amt,0) dr_amt, z.act_amt, " +
			" sum(nvl(cr_amt,0)-nvl(dr_amt,0)) over(partition by z.patient_id order by z.org_doc_date) bal, " +
			" Decode(episode_type,'R','External','O','Outpatient','D','Daycare','I','Inpatient','E','Emergency',' ') Episode_Desc, " +
			" decode(doc_type,'B','Bill','R','Receipt','F','Refund',' ') doc_type_desc, y.TITLE_CODE||' '||y.FIRST_NAME||' '||y.SECOND_NAME||' '||y.LAST_NAME Patient_Name, " +
			" decode(z.episode_id,0,' ',z.episode_id) new_episode_id, decode(z.cr_amt,0,' ',z.cr_amt) new_cr_amt, decode(z.dr_amt,0,' ',z.dr_amt) new_dr_amt, " +
			" decode(nvl(x.encounter_id,z.episode_id),0,' ',nvl(x.encounter_id,z.episode_id)) encounter_id, to_char(z.org_doc_date,'dd-Mon-yyyy') new_org_doc_date " +
			" from (select a.operating_facility_id, a.episode_type, a.patient_id, a.episode_id, a.visit_id, a.org_doc_type_code, a.org_doc_num, a.org_doc_date, " +
			" a.trx_status,a.recpt_type_code,recpt_refund_ind doc_type, case when recpt_refund_ind = 'R' then abs(a.doc_amt) else 0 end cr_amt, " +
			" case when recpt_refund_ind = 'F' then abs(a.doc_amt) else 0 end dr_amt, abs(a.doc_amt) act_amt from bl_patient_ledger a, bl_receipt_refund_hdr b " +
		    " where a.patient_id >= NVL (?, a.patient_id) and a.patient_id <= NVL (?, a.patient_id) and a.operating_facility_id = ? and a.episode_type = b.episode_type and NVL (a.episode_id, 0) = NVL (b.episode_id, 0) "+
			" and NVL (a.visit_id, 0) = NVL (b.visit_id, 0)  and a.operating_facility_id = b.operating_facility_id  and a.patient_id = b.patient_id  and a.org_doc_type_code = b.doc_type_code "+
		    " and a.org_doc_num = b.doc_number and bl_chk_recp_code_spl_ag_depyn(a.recpt_type_code) = 'Y'  and a.trx_status IS NULL   and NVL (recpt_refund_ind, 'N') IN ('R', 'F') "+
			" union all " +
			" select a.operating_facility_id, c.episode_type, a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, " +
			" nvl(b.added_date,c.LAST_RECPT_DOC_DATE), a.trx_status,a.recpt_type_code, 'B' doc_type, 0 cr_amt, " +
			" sum(abs(b.doc_amt)) dr_amt, sum(abs(b.doc_amt)) act_amt " +
			" from bl_patient_ledger a, bl_patient_ledger_trn b, bl_bill_hdr c, bl_receipt_refund_hdr d " +
			" where  a.patient_id >= NVL (?, a.patient_id)  and a.patient_id <= NVL (?, a.patient_id) and a.operating_facility_id = ? and a.episode_type = SUBSTR (a.episode_type, 1) "+
			" and NVL (a.episode_id, 0) = SUBSTR (NVL (a.episode_id, 0), 1) and NVL (a.visit_id, 0) = SUBSTR (NVL (a.visit_id, 0), 1) and b.patient_id >= NVL (?, a.patient_id) "+
			" and b.patient_id <= NVL (?, a.patient_id) and b.operating_facility_id = ? and a.episode_type = b.episode_type and NVL (a.episode_id, 0) = NVL (b.episode_id, 0) "+
			" and NVL (a.visit_id, 0) = NVL (b.visit_id, 0) and bl_chk_recp_code_spl_ag_depyn(a.recpt_type_code) = 'Y' "+
			" and a.trx_status is null " +
			" and nvl (recpt_refund_ind, 'N') = 'R'  and b.operating_facility_id = a.operating_facility_id  and b.patient_id = a.patient_id " +
			" and b.org_doc_type_code = a.org_doc_type_code  and b.org_doc_num = a.org_doc_num and nvl(b.doc_amt,0) != 0 and b.trx_status is null " +
			" and c.operating_facility_id = b.operating_facility_id and c.patient_id = b.patient_id and c.doc_type_code = b.ad_pr_adj_bill_doc_type " +
			" and c.doc_num = b.ad_pr_adj_bill_doc_num  and a.operating_facility_id = d.operating_facility_id and a.patient_id = d.patient_id " +
			" and a.org_doc_type_code = d.doc_type_code and a.org_doc_num = d.doc_number  and bl_chk_recp_code_spl_ag_depyn(a.recpt_type_code) = 'Y' "+
			" group by a.operating_facility_id, c.episode_type, " +
			" a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, nvl(b.added_date,c.LAST_RECPT_DOC_DATE), " +
			" a.trx_status,a.recpt_type_code, 'B'  ) z, MP_PATIENT_MAST y, pr_encounter x " +
			" where z.patient_id = y.patient_id and z.patient_id = x.patient_id(+) and z.episode_id = x.episode_id(+) and z.visit_id = x.OP_EPISODE_VISIT_NUM(+) " +
			" order by patient_id asc, org_doc_date asc");
	//Added V181107-Aravindh/AAKH-CRF-0103
	dataMap.put("AUTO_BILL_JOB_STS_DTL_WITHERR", "SELECT PATIENT_ID, TO_CHAR (VISIT_ADM_DATE_TIME, 'dd/MM/yyyy HH24:MI') VISIT_ADM_DATE_TIME, DECODE (EPISODE_TYPE,'O', 'Outpatient','E', 'Emergency') EPISODE_TYPE, " +
			" EPISODE_ID, VISIT_ID, LOCN_CODE, LOCN_DESC, NVL(PAYER_UNBILLED_AMT,0) PAYER_UNBILLED_AMT, ERR_MSG, BILL_NO FROM BL_BACKGROUND_PROCESS " +
			" WHERE OPERATING_FACILITY_ID = ? AND ORAJOBID = ? AND ORASESSIONID = ? AND NVL(STATUS,'N') != 'C' AND ERR_MSG IS NOT NULL AND PATIENT_ID IS NOT NULL");
	
	dataMap.put("AUTO_BILL_JOB_STS_DTL_WITHOUTERR", "SELECT PATIENT_ID, TO_CHAR (VISIT_ADM_DATE_TIME, 'dd/MM/yyyy HH24:MI') VISIT_ADM_DATE_TIME, DECODE (EPISODE_TYPE,'O', 'Outpatient','E', 'Emergency') EPISODE_TYPE, " +
			" EPISODE_ID, VISIT_ID, LOCN_CODE, LOCN_DESC, NVL(PAYER_UNBILLED_AMT,0) PAYER_UNBILLED_AMT, ERR_MSG, BILL_NO FROM BL_BACKGROUND_PROCESS" +
			"  WHERE  OPERATING_FACILITY_ID = ? AND ORAJOBID = ? AND ORASESSIONID = ? AND NVL(STATUS,'N') = 'C' AND ERR_MSG IS NULL  AND PATIENT_ID IS NOT NULL");
			
	dataMap.put("GET_LEGENDS_FRM_DEPOSIT_TRANS_DATA", "select pk_value, column_value as legends from sm_record_Trans_data where module_id = 'SM' and TABLE_ID = 'SM_LANG_LEGEND' " +
			" and substr(PK_VALUE,1,7) = 'BLRPPAD' and LANGUAGE_ID = ? ");
			
			
	dataMap.put("GET_DEPOSIT_TRANS", "SELECT  z.operating_facility_id, z.episode_type, z.patient_id, z.episode_id, visit_id, org_doc_type_code, org_doc_num, " +
			" org_doc_date, trx_status, recpt_type_code, doc_type, cr_amt, dr_amt, act_amt, " +
			" sum(nvl(cr_amt,0)-nvl(dr_amt,0)) over(partition by z.patient_id order by org_doc_date) bal, packagedtl," +
			"DECODE (episode_type,'R', 'External','O', 'Outpatient','D', 'Daycare','I', 'Inpatient','E', 'Emergency',' ') episode_desc,"+
			" DECODE (doc_type,'B', 'Bill','R', 'Receipt','F', 'Refund',' ') doc_type_desc,x.title_code || ' '|| x.first_name || ' ' || x.second_name || ' ' "+
			" || x.last_name patient_name, DECODE (z.episode_id, 0, ' ', z.episode_id) new_episode_id, DECODE (z.cr_amt, 0, ' ', z.cr_amt) new_cr_amt, "+
			"DECODE (z.dr_amt, 0, ' ', z.dr_amt) new_dr_amt, DECODE (NVL (y.encounter_id, z.episode_id), 0, ' ', NVL (y.encounter_id, z.episode_id) ) encounter_id, "+
			"TO_CHAR (z.org_doc_date, 'dd-Mon-yyyy') new_org_doc_date "+
			" from (select a.operating_facility_id, a.episode_type, a.patient_id, a.episode_id, a.visit_id, a.org_doc_type_code, a.org_doc_num, a.org_doc_date, " +
			" a.trx_status,a.recpt_type_code,recpt_refund_ind doc_type, case when recpt_refund_ind = 'R' then abs(a.doc_amt) else 0 end cr_amt, " +
			" case when recpt_refund_ind = 'F' then abs(a.doc_amt) else 0 end dr_amt, abs(a.doc_amt) act_amt, b.encounter_id ,(select package_code||' / '||c.PACKAGE_SEQ_NO from"+ 
			" BL_PACKAGE_sub_hdr c  where  a.patient_id = c.patient_id  and B.PACKAGE_SEQ_NO = C.PACKAGE_SEQ_NO  and nvl(c.STATUS,'$') != 'L') packagedtl "+
			" from bl_patient_ledger a, bl_receipt_refund_hdr b " +
		    " where a.operating_facility_id = b.operating_facility_id  and a.patient_id = b.patient_id  and a.org_doc_type_code = b.doc_type_code "+
		    " and a.org_doc_num = b.doc_number "+
			" AND a.trx_status IS NULL AND NVL (recpt_refund_ind, 'N') IN ('R', 'F') AND a.operating_facility_id = ? "+
			"AND a.patient_id BETWEEN  ? AND NVL (?, ?) and B.recpt_nature_code != 'BI' "+
			" union all " +
			" select a.operating_facility_id, c.episode_type, a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, " +
			" nvl(b.added_date,c.LAST_RECPT_DOC_DATE), a.trx_status,a.recpt_type_code, 'B' doc_type, 0 cr_amt, " +
			" sum (ABS (B.doc_amt)) dr_amt, avg (ABS (c.bill_amt)) act_amt, c.encounter_id,null packagedtl " +
			" from bl_patient_ledger a, bl_patient_ledger_trn b, bl_bill_hdr c, bl_receipt_refund_hdr d " +
			" where  a.trx_status is null " +
			" and nvl (recpt_refund_ind, 'N') = 'R'  and b.operating_facility_id = a.operating_facility_id  and b.patient_id = a.patient_id " +
			" and b.org_doc_type_code = a.org_doc_type_code  and b.org_doc_num = a.org_doc_num and nvl(b.doc_amt,0) != 0 and b.trx_status is null " +
			" and c.operating_facility_id = b.operating_facility_id and c.patient_id = b.patient_id and c.doc_type_code = b.ad_pr_adj_bill_doc_type " +
			" and c.doc_num = b.ad_pr_adj_bill_doc_num  and a.operating_facility_id = d.operating_facility_id and a.patient_id = d.patient_id " +
			" and a.org_doc_type_code = d.doc_type_code and a.org_doc_num = d.doc_number  AND a.operating_facility_id = ? AND a.patient_id BETWEEN ?" +
			"AND NVL (?, ?) and D.recpt_nature_code != 'BI' "+
			" group by a.operating_facility_id, c.episode_type, " +
			" a.patient_id, c.episode_id, c.visit_id, c.doc_type_code, c.doc_num, nvl(b.added_date,c.LAST_RECPT_DOC_DATE), " +
			" a.trx_status,a.recpt_type_code, 'B', c.encounter_id) z,mp_patient_mast x,  pr_encounter y "+  
			" where  z.patient_id = y.patient_id(+) AND z.patient_id = x.patient_id(+) AND z.episode_id = y.episode_id(+) AND z.visit_id = y.op_episode_visit_num(+) " +
			" ORDER BY patient_id ASC, org_doc_date ASC");

		//Added V201125-PalaniNarayanan for MOHE-CRF-50.3 US-4 Starts
		dataMap.put("ITEAM_PRICE_LIST","SELECT a.acc_entity_name name, a.acc_entity_id   id FROM   sy_acc_entity a,  sm_facility_for_user b WHERE  b.facility_id = a.acc_entity_id "+  
		"AND b.appl_user_id = ? ORDER BY 1");

		dataMap.put("ITEAM_PRICE_LIST_STATUS","SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) List_Element, A.LIST_ELMT_VALUE  FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE 	A.MODULE_ID = 'BL' AND " +
		"A.MODULE_ID = ? AND A.LIST_REF = B.LIST_REF AND A.LIST_SRL_NO = B.LIST_SRL_NO AND A.LIST_REF ='STATUS_IND' AND B.LANGUAGE_ID = ? " + "ORDER BY A.LIST_SRL_NO");  
		//Added V201125-PalaniNarayanan for MOHE-CRF-50.3 US-4 Ends
		
		dataMap.put("Multi_Factor_Deduct_Rule_Hdr_Info","select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, hdr.POLICY_TYPE_CODE, hdr.operating_facility_id,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to, operating_facility_id, episode_type, episode_encounter, item_category, patient_copay, patient_amount_limit_yn, copay_applied_on  from bl_insu_drug_deduct_dtl hdr where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.ITEM_CATEGORY = ? "); //V221017
		
		dataMap.put("Bl_Order_Status_List", "select order_status_code as code, short_desc as description from OR_ORDER_STATUS_CODE");
		//Added by Monika -- for CRF AAKH-0152-Requirement 3
		
		dataMap.put("GET_ITEM_LIST_VALUES","SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) item_desc, A.LIST_ELMT_VALUE item_id FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = ? AND A.LIST_REF = ? AND B.LANGUAGE_ID = ? AND A.LIST_REF = B.LIST_REF AND A.LIST_SRL_NO = B.LIST_SRL_NO " + "ORDER BY A.LIST_SRL_NO");
	}

	//private static BlRepository instance;
	private static int i;
	private static HashMap dataMap;
}
