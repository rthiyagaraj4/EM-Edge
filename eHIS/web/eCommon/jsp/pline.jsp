<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,java.io.*, webbeans.eCommon.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
	<head>
		<% 
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			

			String ctx_banner_content = "";

			String pat_photo_in_db_yn = "N";
			String pat_photo_http_path = "";
			int pat_photo_rnwl_dys = 0;
			int diff_in_days=0;
			int no_of_days = 0;
			int past_surgery_cnt = 0;
			int patient_notes_cnt = 0;
			String P_ENCNTR_DATE	= "";
			String P_LOCN_CODE		= "";
			String P_LOCN_TYPE		= "";
			String P_VISIT_ID		= "";
			String P_EPISODE_ID		= "";
			String P_PHYSICIAN_ID	= "";
			String P_EPISODE_TYPE	= "";
			
			String length_of_stay="";//this line added for this CRF Bru-HIMS-CRF-411
			
			
			String P_MODULE_ID=request.getParameter("P_MODULE_ID")==null?"":request.getParameter("P_MODULE_ID");
			String P_FUNCTION_ID=request.getParameter("P_FUNCTION_ID")==null?"":request.getParameter("P_FUNCTION_ID");
			String enableCDR=request.getParameter("enableCDR")==null?"N":request.getParameter("enableCDR");
			String practEnableCDR	= "N";
						
 
			 String patient_id = request.getParameter("Patient_ID");

			 if(patient_id == null || patient_id.equals("null"))
				patient_id = "";
				
			 if(patient_id.equals(""))
				patient_id = request.getParameter("Patient_Id");

   		     if(patient_id == null || patient_id.equals("null"))
				patient_id = "";

 			 String episode_id = request.getParameter("EncounterId");

			 if(episode_id == null || episode_id.equals("null"))
				episode_id = "";

 			 String facility_id = "";
			 facility_id = request.getParameter("Facility_Id") == null ? "" : request.getParameter("Facility_Id");
			 if(facility_id.equals(""))
			 	facility_id = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");

			 String bl_install_yn = (String)session.getValue("bl_operational") == null ? "" : (String)session.getValue("bl_operational");
			String login_user_id	=	(String)session.getValue("login_user");	
  			 String visit_id = request.getParameter("visit_id") == null? "" : request.getParameter("visit_id");
 			 //String bl_details = "";
			 String bl_episode_id = "";
			 String bl_episode_visit_num = "";
			 String bannerCateg = "P";
             String viewPatPhotoYN = "N";
 			 String allergyListYN = "N";
		 	 String profileYN = "N";
		 	 String highRiskYN = "N";
			 String known_allergy_yn = "N";			 
			 String eye_indicator = "";
			 String general_remarks = "";
			 String Day_before_BirthDay = "";
			 String Birth_day = "";
			 String EstimatedAge = "";
			 String TOOL_TIP_TEXT = "";
 			 String deceasedYN = "N";
			 int researchCount = 0;
			 String activeYN = "N";
			 String suspended = "N";
			 String vipYN = "N";
			 String viewPatFinDtlsYN = "N";
			 String P_LOCN_DESC = "";
			 //String cp_operational_yn = "N";
			 String myhix_appl_YN = "N"; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
			 String myhix_view_YN="N";// Added for MYHIX integration ML-MMOH-CRF-0507.1.
			 
			 String altID1	= ""; //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]
			 String alt_id4_no	= ""; 
			 String mlc_yn = ""; //Added for ML-MMOH-CRF-1954
			 boolean isMlcApplicable = false; //Added for ML-MMOH-CRF-1954

			 if(episode_id.equals("")) bannerCateg = "P";
			 else bannerCateg = "E";
			 
 			java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
			String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
			String workStationId	= (String) p.getProperty("client_ip_address") == null ? "" : (String) p.getProperty("client_ip_address");
			
 			Connection con = null;
			PreparedStatement ps = null;
			ResultSet res = null;
			StringBuffer testBuffer = new StringBuffer();
			String patient_long_name="";
			String patient_long_name_loc_lang="";
			
			/*Added by Rameswar on  27-07-2016 for  AAKH-CRF-0083 */				
			String HAAD_Data ="";
			
			//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
			boolean isAllergyIconReplaced = false; 
			
			//Below line added for this CRF ML-MMOH-CRF-0780
			int nextofKin=0;
			String NEXT_OF_KIN_TOOLTIP="";
			
			//Below line added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601
            Boolean increasedaddressLength = false;	
            Boolean alterAddressApplicable = false; 
			Boolean isDiscRefCountApplicable=false; // added by mujafar for ML-MMOH-CRF-1130.1 START
			 String disc_sum_count = "";
			 String ref_sum_count = "";
			 String disc_ref_count_temp=""; // added by mujafar for ML-MMOH-CRF-1130.1 END
			
			/*Added by Thamizh selvi on 4th June 2018 against MMS-DM-CRF-0115 Start*/
			int cdrCount = 0;
			String nationalityId = "";	
			/*End*/
			String isCDRConfigured	= "N";
			int histAllergyCnt = 0;//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117

			String MFSScore = ""; //Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158

			/* Added by kamatchi S for ML-MMOH-CRF-1182 */
			String FPPPatient_yn = "N";
			String Episode_Type = ""; 
			boolean isFPPDisplayApplicable = false;
			/* Added by kamatchi S for ML-MMOH-CRF-1182 END*/
			
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 */ 
			String archival_yn = "N";
			String user_password = "";
			String ArchivalDBUrl = "";
			String lst_purge_encntr_id = "";
			boolean isArchivalDisplayApplicable = false;
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 END*/

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	    <script src='../../eMP/js/PatEncBanner.js' language='javascript'></script>
	    <script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
	    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
	
		
		String sqlDeceased = "";
		String File_exist="N"; 
		try
		{
			con = ConnectionManager.getConnection(request);	
			/* Added by kamatchi S for ML-MMOH-CRF-1182 START */
			isFPPDisplayApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FPP_DISPLAY");
			if(isFPPDisplayApplicable)
			{
			Episode_Type = eMP.MPCommonBean.getPatientEncounterDetails(con,facility_id,episode_id);
			if(!Episode_Type.equals(""))
			FPPPatient_yn = eMP.MPCommonBean.getFPPDetails(con,facility_id,Episode_Type,episode_id);
			}
			/* Added by kamatchi S for ML-MMOH-CRF-1182 END */
			
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 */ 
			isArchivalDisplayApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ARCHIVE_DISPLAY");
			
			user_password=eMP.MPCommonBean.getUserPassword(con,login_user_id);
		
		
		
			if(isArchivalDisplayApplicable)
			{
				ArchivalDBUrl=eMP.MPCommonBean.getArchivalDBUrl(con);
				archival_yn=eMP.MPCommonBean.getArchivalYN(con,patient_id);
				lst_purge_encntr_id = eMP.MPCommonBean.getLstPurgeEncId(con,patient_id);
			}
			/* Added by Prakash for PMG2023-COMN-CRF-0002.4 END*/

			//Added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
			alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); 	
			isDiscRefCountApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","DISC_REF_COUNT_APPL"); // added by mujafar for ML-MMOH-CRF-1130.1 
			//End ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601

			//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
			isAllergyIconReplaced = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","REPLACE_ALLERGY_ICON");
		
			//Below line added for this CRF ML-MMOH-CRF-0780		
			//nextofKin = eMP.ChangePatientDetails.getNextofKin(con, patient_id);
		
			isMlcApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MARK_PATIENT_MLC");//SiteSpecific added for ML-MMOH-CRF-1954 by Ajay Hatwate
			
			if(!patient_id.equals("") || !episode_id.equals(""))
			{
				java.sql.Clob bnrContentClob = null;
				java.io.Reader bnrContentReader = null;
				java.io.BufferedReader bnrBuffReader = null;

				String bannerContentStr = "";
				try
				{		
					eMP.PatEncBannerReplacementBean patEncBannerReplaceBean = new eMP.PatEncBannerReplacementBean();
					
					//Start Read the banner content from the application context instead of database
					
					if(bannerCateg.equalsIgnoreCase("E")){
						ctx_banner_content = (application.getAttribute("User_Banner_Encounter") == null)?"":(String)application.getAttribute("User_Banner_Encounter");
						if(ctx_banner_content != null || ctx_banner_content.length()>0);
						else 
							ctx_banner_content = (application.getAttribute("System_Banner_Encounter") == null)?"":(String)application.getAttribute("System_Banner_Encounter");
					}else if(bannerCateg.equalsIgnoreCase("P")){
						ctx_banner_content = (application.getAttribute("User_Banner_Patient") == null)?"":(String)application.getAttribute("User_Banner_Patient");
						if(ctx_banner_content != null || ctx_banner_content.length()>0);
						else 
							ctx_banner_content = (application.getAttribute("System_Banner_Patient") == null)?"":(String)application.getAttribute("System_Banner_Patient");
					}
					
				
					if(ctx_banner_content != null && ctx_banner_content.length()>0);
					else{ 
						ps = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF='U01' and BANNER_CATEG = ? ");
						ps.setString(1,bannerCateg);
						res = ps.executeQuery();
						if(res != null && res.next()){
							Clob clob = (java.sql.Clob) res.getObject("BANNER_CONTENT");
							BufferedReader reader = new BufferedReader(clob.getCharacterStream());
							ctx_banner_content = reader.readLine();
							reader.close();
						}
						if(res != null)res.close();
						if(ps != null)ps.close();
						if(ctx_banner_content != null && ctx_banner_content.length() > 0){
							if(bannerCateg.equalsIgnoreCase("E")){
								application.setAttribute("User_Banner_Encounter",ctx_banner_content);
							}else if(bannerCateg.equalsIgnoreCase("P")){
								application.setAttribute("User_Banner_Patient",ctx_banner_content);
							}
						}else{
							ps = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF='Sys' and BANNER_CATEG = ? ");
							ps.setString(1,bannerCateg);
							res = ps.executeQuery();
							
							if(res != null && res.next()){
								Clob clob = (java.sql.Clob) res.getObject("BANNER_CONTENT");
								BufferedReader reader = new BufferedReader(clob.getCharacterStream());
								ctx_banner_content = reader.readLine();
								reader.close();
							}
							if(res != null)res.close();
							if(ps != null)ps.close();
							if(ctx_banner_content != null && ctx_banner_content.length() > 0){
								if(bannerCateg.equalsIgnoreCase("E")){
									application.setAttribute("System_Banner_Encounter",ctx_banner_content);
								}else if(bannerCateg.equalsIgnoreCase("P")){
									application.setAttribute("System_Banner_Patient",ctx_banner_content);
								}
							}							
						}
					}
					//End Read the banner content from the application context instead of database
					
					HashMap testHashValues = null;
					
					if(episode_id.equals(""))
						testHashValues = (HashMap)patEncBannerReplaceBean.putToHash(con, "P", patient_id, episode_id, facility_id, locale);
					else
						testHashValues = (HashMap)patEncBannerReplaceBean.putToHash(con, "E", patient_id, episode_id, facility_id, locale);

					testBuffer = (StringBuffer) patEncBannerReplaceBean.replaceVariables(ctx_banner_content,testHashValues);
					
					HashMap mpPatientValues = (HashMap)patEncBannerReplaceBean.getMpPatientValues();	
					patient_id = (String) mpPatientValues.get("PATIENT_ID");
					deceasedYN = (String) mpPatientValues.get("DECEASED_YN");
					activeYN = (String) mpPatientValues.get("ACTIVE_YN");
					suspended = (String) mpPatientValues.get("SUSPEND_YN");
					vipYN = (String) mpPatientValues.get("VIP_YN");
					eye_indicator = (String) mpPatientValues.get("eye_indicator");
					general_remarks =java.net.URLEncoder.encode( (String) mpPatientValues.get("general_remarks")==null?"":(String) mpPatientValues.get("general_remarks"),"UTF-8");
					Day_before_BirthDay = (String) mpPatientValues.get("Day_before_BirthDay");
					Birth_day = (String) mpPatientValues.get("Birth_day");
					EstimatedAge = (String) mpPatientValues.get("EstimatedAge");
					TOOL_TIP_TEXT = (String) mpPatientValues.get("TOOL_TIP_TEXT");
					NEXT_OF_KIN_TOOLTIP  = (String) mpPatientValues.get("NEXT_OF_KIN_TOOLTIP"); //Added for this CRF ML-MMOH-CRF-0780
					nationalityId = (String) mpPatientValues.get("nationalityId");//Added by Thamizh selvi on 5th June 2018 against MMS-DM-CRF-0115

					mlc_yn = (String)mpPatientValues.get("MLC_YN") == null ?"N":(String)mpPatientValues.get("MLC_YN"); //Added for ML-MMOH-CRF-1954		
				
					if(bannerCateg.equals("E")) { 
						bl_episode_id = (String) mpPatientValues.get("BL_EPISODE_ID");
						bl_episode_visit_num = (String) mpPatientValues.get("BL_OP_EPISODE_VISIT_NUM");
						P_ENCNTR_DATE	= (String) mpPatientValues.get("P_ENCNTR_DATE");
						P_LOCN_CODE		= (String) mpPatientValues.get("P_LOCN_CODE");
						P_LOCN_TYPE		= (String) mpPatientValues.get("P_LOCN_TYPE");
						P_VISIT_ID		= (String) mpPatientValues.get("P_VISIT_ID");
						P_EPISODE_ID	= (String) mpPatientValues.get("P_EPISODE_ID");
						P_PHYSICIAN_ID	= (String) mpPatientValues.get("P_PHYSICIAN_ID");
						P_EPISODE_TYPE	= (String) mpPatientValues.get("P_EPISODE_TYPE");
						length_of_stay  = (String) mpPatientValues.get("LENGTH_OF_STAY");
						P_LOCN_DESC  = (String) mpPatientValues.get("P_LOCN_DESC");
					}

					HAAD_Data =eMR.MRHaadcolorConfigBean.getHAADPlinecontext(con,patient_id,facility_id);
					/*Added by Rameswar on  27-07-2016 for  AAKH-CRF-0083 */

					if(res != null) res.close();
					if(ps != null) ps.close();
				}
				catch(Exception e)
				{  
				   e.printStackTrace();
					out.println("Exception at try - Clob of PLine.jsp -"+e.toString());
					e.printStackTrace(System.err);
				}
			}//end of if patient_id	
		
			// query modified to get myhix access right. Added for MYHIX integration ML-MMOH-CRF-0507.1
			
			String sqlQuery = "SELECT "+
					" GET_TASK_APPLICABILITY('PATIENT_SEARCH',null,?,null) PATIENT_SEARCH,'N' TAB_MENU_YN,"+
					" GET_TASK_APPLICABILITY('ALLERGY_LST',null,?,null) ALLERGY_LST, "+
					" GET_TASK_APPLICABILITY('VIEW_PROFILE',null,?,null) VIEW_PROFILE, "+
					" KNOWN_ALLERGY_YN , pat_photo_in_db_yn, "+
					" (Select 'Y' from pr_high_risk_condition where patient_id =? and close_date is null  AND rownum=1) HIGH_RISK_COUNT, "+
					" null CURRENT_LOCATION, "+
					" (select view_pat_photo_yn from mp_access_rights where resp_id =?) view_pat_photo_yn, "+
					" (select VIEW_PAT_FIN_DTLS_YN from mp_access_rights where resp_id =?) view_pat_fin_dtls_yn, "+ 
					" (SELECT COUNT(*) FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?) total, "+
					" (select pat_photo_renewal_alert_days from mp_param) pat_photo_renewal_alert_days,"+
					" (Select  pat_photo_http_path from sm_db_info) pat_photo_http_path ,"+
					" (Select trunc(sysdate-modified_date) no_of_days from MP_PATIENT_PHOTO where PATIENT_ID = ?) no_of_days,"+
					" (select count(*) from pr_encounter_procedure where patient_id = ? and error_yn != 'Y') past_surgery_cnt,"+ 
					" (select count(*) from mp_patient_notes where patient_id = ?) patient_notes_cnt,"+
					" (select myhix_view_YN from MR_USER_ACCESS_RIGHTS where appl_user_id = ? and facility_id=?) myhix_view_YN ,"+
					" patient_long_name,patient_long_name_loc_lang,cdr_count,alt_id1_no,alt_id4_no,national_id_no "+
					" from mp_all_patients_vw where patient_id = ?";
					
			ps = con.prepareStatement("SELECT "+
						" GET_TASK_APPLICABILITY('PATIENT_SEARCH',null,?,null) PATIENT_SEARCH,'N' TAB_MENU_YN,"+
						" GET_TASK_APPLICABILITY('ALLERGY_LST',null,?,null) ALLERGY_LST, "+
						" GET_TASK_APPLICABILITY('VIEW_PROFILE',null,?,null) VIEW_PROFILE, "+
						" KNOWN_ALLERGY_YN , pat_photo_in_db_yn, "+
						" (Select 'Y' from pr_high_risk_condition where patient_id =? and close_date is null  AND rownum=1) HIGH_RISK_COUNT, "+
						" null CURRENT_LOCATION, "+
						" (select view_pat_photo_yn from mp_access_rights where resp_id =?) view_pat_photo_yn, "+
						" (select VIEW_PAT_FIN_DTLS_YN from mp_access_rights where resp_id =?) view_pat_fin_dtls_yn, "+ 
						" (SELECT COUNT(*) FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?) total, "+
						" (select pat_photo_renewal_alert_days from mp_param) pat_photo_renewal_alert_days,"+
						" (Select  pat_photo_http_path from sm_db_info) pat_photo_http_path ,"+
						" (Select trunc(sysdate-modified_date) no_of_days from MP_PATIENT_PHOTO where PATIENT_ID = ?) no_of_days,"+
						" (select count(*) from pr_encounter_procedure where patient_id = ? and error_yn != 'Y') past_surgery_cnt,"+ 
						" (select count(*) from mp_patient_notes where patient_id = ?) patient_notes_cnt,"+
						" (select myhix_view_YN from MR_USER_ACCESS_RIGHTS where appl_user_id = ? and facility_id=?) myhix_view_YN ,"+
						" patient_long_name,patient_long_name_loc_lang,cdr_count,alt_id1_no,alt_id4_no,national_id_no "+
						" from mp_all_patients_vw where patient_id = ?");
			
			
			ps.setString(1, resp_id);
			ps.setString(2, resp_id);
			ps.setString(3, resp_id);			
			ps.setString(4, patient_id);
			ps.setString(5, resp_id);
			ps.setString(6, resp_id);
			ps.setString(7, patient_id);
			ps.setString(8, patient_id);
			ps.setString(9, patient_id);
			ps.setString(10, patient_id);
			ps.setString(11, (String)session.getValue("login_user")); // Added for MYHIX integration ML-MMOH-CRF-0507.1
			ps.setString(12, facility_id); // Added for MYHIX integration ML-MMOH-CRF-0507.1
			ps.setString(13, patient_id);
			res = ps.executeQuery();
			while(res.next())
			{
				allergyListYN = res.getString("ALLERGY_LST") == null ? "N" : res.getString("ALLERGY_LST");
				profileYN = res.getString("VIEW_PROFILE") == null ? "N" : res.getString("VIEW_PROFILE");		
				known_allergy_yn = res.getString("KNOWN_ALLERGY_YN") == null ? "U" : res.getString("KNOWN_ALLERGY_YN");
				highRiskYN = res.getString("HIGH_RISK_COUNT") == null ? "N" : res.getString("HIGH_RISK_COUNT");
				viewPatPhotoYN = res.getString("VIEW_PAT_PHOTO_YN") == null ? "N" : res.getString("VIEW_PAT_PHOTO_YN");
				viewPatFinDtlsYN = res.getString("view_pat_fin_dtls_yn") == null ? "N" : res.getString("view_pat_fin_dtls_yn");
				researchCount = res.getInt("total");					
				pat_photo_in_db_yn = res.getString("pat_photo_in_db_yn")==null?"N":res.getString("pat_photo_in_db_yn");				
				pat_photo_rnwl_dys = res.getInt("pat_photo_renewal_alert_days"); 					
				no_of_days = res.getInt("no_of_days");			
				past_surgery_cnt = res.getInt("past_surgery_cnt");		
				patient_notes_cnt = res.getInt("patient_notes_cnt");			
				pat_photo_http_path = res.getString("pat_photo_http_path");			
				patient_long_name =	res.getString("patient_long_name")==null?"":res.getString("patient_long_name");	
				myhix_view_YN =	res.getString("myhix_view_YN")==null?"N":res.getString("myhix_view_YN");	 //Added for MYHIX integration ML-MMOH-CRF-0507.1	 				
				altID1			 =	res.getString("alt_id1_no")==null?"":res.getString("alt_id1_no");	  //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]	 				
				alt_id4_no			 =	res.getString("alt_id4_no")==null?"":res.getString("alt_id4_no");	 
				nationalityId	 =	res.getString("national_id_no")==null?"":res.getString("national_id_no");	  //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313] 			
				//cdrCount		 =	res.getInt("cdr_count");	 //Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]	 				
			} 
			
			/* System.out.println(" ******************* Inside pline jsp 431 allergyListYN : "+allergyListYN+" profileYN : "+profileYN
					+" known_allergy_yn : "+known_allergy_yn+" highRiskYN : "+highRiskYN
					+" viewPatPhotoYN : "+viewPatPhotoYN+" viewPatFinDtlsYN : "+viewPatFinDtlsYN
					+" viewPatFinDtlsYN : "+viewPatFinDtlsYN+" researchCount : "+researchCount
					+" pat_photo_in_db_yn : "+pat_photo_in_db_yn+" pat_photo_rnwl_dys : "+pat_photo_rnwl_dys
					+" pat_photo_rnwl_dys : "+pat_photo_rnwl_dys+" no_of_days : "+no_of_days
					+" past_surgery_cnt : "+past_surgery_cnt+" patient_notes_cnt : "+patient_notes_cnt
					+" pat_photo_http_path : "+pat_photo_http_path+" patient_long_name : "+patient_long_name
					+" myhix_view_YN : "+myhix_view_YN+" altID1 : "+altID1); */
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
			
		   //Below line added for this CRF ML-MMOH-CRF-0780		
		    nextofKin = eMP.ChangePatientDetails.getNextofKin(con, patient_id);
			//Added By Dharma on Aug 14th 2018 against MMS-DM-CRF-0115.2 [IN:068313]
			if(testBuffer.indexOf("id='CDR'") != -1){
				isCDRConfigured	= "Y";
			}
			if("Y".equals(enableCDR) && "Y".equals(isCDRConfigured)){
				practEnableCDR	= eCommon.Common.CommonBean.getCDRIconEnableYNforPract(con, login_user_id);
			}
			
		   	if("Y".equals(enableCDR) && "Y".equals(practEnableCDR) && "Y".equals(isCDRConfigured)){
				cdrCount = eMP.MPCommonBean.getCDRCount(con, nationalityId,altID1,patient_id);//Added by Thamizh selvi on 6th June 2018 against MMS-DM-CRF-0115	
			}

			myhix_appl_YN 	= CommonBean.getMyHixApplicable(con); //added for MYHIX integration ML-MMOH-CRF-0507.1.

			MFSScore = eMP.MPCommonBean.getMorseFallScaleScore(con, episode_id, patient_id); //Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158

			histAllergyCnt = eMP.MPCommonBean.getHistAllergyCnt(con, patient_id);//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117
			disc_ref_count_temp = eCommon.Common.CommonBean.getDisRefSumCnt(con,patient_id); // added by mujafar for ML-MMOH-CRF-1130.1 START
			if(disc_ref_count_temp.contains("~~"))
			{
				String[] retVal = disc_ref_count_temp.split("~~");
				if(retVal.length==2)
				{
					disc_sum_count= retVal[0];
					ref_sum_count = retVal[1];
				}
				else
				{
					disc_sum_count= retVal[0];
				}
			}
			String path="";
			String fmt_file_modified_date="";
			path=pat_photo_http_path+patient_id+".jpg";
			File f = new File(path);    
			
			if(f.exists()){
				pat_photo_http_path=pat_photo_http_path.replaceAll("\\\\","|");
				java.util.Date file_modified_date =new java.util.Date(f.lastModified());
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
				fmt_file_modified_date=sdf.format(file_modified_date);
				/*
					Query will get the difference in dates of System date and file modified date
				*/
				String Date_Query="SELECT TRUNC(SYSDATE-TO_DATE('"+fmt_file_modified_date+"','DD/MM/YYYY')) DIFF_IN_DAYS FROM DUAL";
				ps = con.prepareStatement(Date_Query);
				res=ps.executeQuery();
				while(res.next()){
					diff_in_days=Integer.parseInt(res.getString("DIFF_IN_DAYS"));
				}
				File_exist="Y";
			}
			else
			{
				File_exist="N";
			}
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
		}//end of try - main
		catch(Exception excep)
		{
          excep.printStackTrace();	
		  out.println("Exception in try main of PLine.jsp------"+excep.toString());
			excep.printStackTrace(System.err);			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
%>
	<body onKeyDown="lockKey()" OnMouseDown='CodeArrest()'>
		<form name='patLineForm' id='patLineForm'>
			<table width='100%' cellspacing='0' cellpadding='0' height='44' width='1024' bgcolor="#fff791">
				<%=testBuffer%>			
			</table>
			<!--Below line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065]-->
			 <input type = 'hidden' name='Remarks' id='Remarks' value = '<%=general_remarks%>'> 
			 <input type = 'hidden' name='visit_date_time' id='visit_date_time' value = '<%=P_ENCNTR_DATE%>'> 
			 <input type = 'hidden' name='TOOL_TIP_TEXT' id='TOOL_TIP_TEXT' value = '<%=TOOL_TIP_TEXT%>'>
			<!--end-->
			
			<!--Added for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-00601--> 
            <input type="hidden" name="increasedaddressLength" id="increasedaddressLength" value="<%=increasedaddressLength%>"> 
            <input type="hidden" name="alterAddressApplicable" id="alterAddressApplicable" value="<%=alterAddressApplicable%>"> 
			<input type="hidden" name="isDiscRefCountApplicable" id="isDiscRefCountApplicable" value="<%=isDiscRefCountApplicable%>">  
			<input type="hidden" name="disc_sum_count" id="disc_sum_count" value="<%=disc_sum_count%>">
			<input type="hidden" name="ref_sum_count" id="ref_sum_count" value="<%=ref_sum_count%>">
            <input type="hidden" name="cdrCount" id="cdrCount" value="<%=cdrCount%>"> 
            <input type="hidden" name="practEnableCDR" id="practEnableCDR" value="<%=practEnableCDR%>"> 
            <input type="hidden" name="workStationId" id="workStationId" value="<%=workStationId%>"> 
            <!--End ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0601-->
	    <input type="hidden" name="isFPPDisplayApplicable" id="isFPPDisplayApplicable" value="<%=isFPPDisplayApplicable%>"> <!--Added by Kamatchi S for ML-MMOH-CRF-1182-->
	    <input type="hidden" name="isArchivalDisplayApplicable" id="isArchivalDisplayApplicable" value="<%=isArchivalDisplayApplicable%>"> <!--Added by Prakash for PMG2023-COMN-CRF-0002.4-->	
		</form>
	</body>
</html>
<script>
    var classValue = "NORMPATLINE";
	if('<%=deceasedYN%>' == 'Y') classValue = 'DECEASEDPATLINE';
	else classValue = "NORMPATLINE";
	if(document.getElementById('tdLine1') != null)
		document.getElementById('tdLine1').className = classValue;
	if(document.getElementById('tdLine2') != null)
		document.getElementById('tdLine2').className = classValue;
	if(document.getElementById('tdPhoto') != null)
		document.getElementById('tdPhoto').className = classValue;
	if(document.getElementById('FINANCIAL') != null)
	{
		if('<%=bl_install_yn%>' == "Y" && '<%=patient_id%>' != "")
		{
			document.getElementById('FINANCIAL').style.cursor = 'pointer';
			
			document.getElementById('FINANCIAL').addEventListener("click",function(){ViewBLDtl("<%=bl_episode_id%>","<%=bl_episode_visit_num%>","<%=patient_id%>")});
		}	
		else
		{
			document.getElementById("FINANCIAL").style.display = 'none';
		}
	}

	
	if(document.getElementById('PAT_PROFILE') != null)
	{
		if('<%=profileYN%>' == 'A')
		{
			document.getElementById("PAT_PROFILE").style.cursor = 'pointer';
			document.getElementById("PAT_PROFILE").addEventListener("click",function(){callPatientProfile("<%=patient_id%>","<%=episode_id%>")});
		}
		else
		{
			document.getElementById("PAT_PROFILE").style.display = 'none';
		}
	}
	
	if('<%=allergyListYN%>' == 'A')
	{
		if(document.getElementById("PAT_ALERTS_ALLERGY") != null )
		{
			if(('<%=known_allergy_yn%>' == 'Y') || ('<%=highRiskYN%>' == 'Y'))
			{
				//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
				if('<%=isAllergyIconReplaced%>' == 'true')
				{
					document.getElementById("PAT_ALERTS_ALLERGY").innerHTML="<img src='../../eCommon/images/PI_Allergies.gif'><span style='color:red;font-weight:bold;font-size:14px'>"+getLabel("Common.KnownAllergy.label","Common")+"</span>";
				}
				document.getElementById("PAT_ALERTS_ALLERGY").style.cursor = 'pointer';
				document.getElementById("PAT_ALERTS_ALLERGY").addEventListener("click",function(){callAllery('<%=patient_id%>')});
			}
			else if(('<%=known_allergy_yn%>' == 'N') && ('<%=highRiskYN%>' == 'N'))
			{
				//document.getElementById("PAT_ALERTS_ALLERGY").style.display = 'none';
				//Added by Sangeetha for ML-MMOH-CRF-0692 on 27/07/17
				if('<%=isAllergyIconReplaced%>' == 'true')
				{
					document.getElementById("PAT_ALERTS_ALLERGY").innerHTML="<img src='../../eCommon/images/PI_Allergies_Gray.gif'><span style='color:black;font-weight:bold;font-size:14px'>"+getLabel("Common.no.label","Common")+ " " +getLabel("Common.KnownAllergy.label","Common")+"</span>";
				}
				else
				{
					document.getElementById("PAT_ALERTS_ALLERGY").innerHTML="<img src='../../eCommon/images/PI_Allergies_Gray.gif'>";
				}

			}
			else
			{
				document.getElementById("PAT_ALERTS_ALLERGY").style.display = 'none';
			}
		}
	}
	if(document.getElementById("PAT_CLIN_RSRCH_CAT") != null)
	{
		if(<%=researchCount%> > 0 )
		{
			document.getElementById("PAT_CLIN_RSRCH_CAT").style.cursor = 'pointer';
			document.getElementById("PAT_CLIN_RSRCH_CAT").addEventListener("click",function(){return researchPatient('<%=patient_id%>')});
		}
		else
		{
			document.getElementById("PAT_CLIN_RSRCH_CAT").style.display = 'none';
		}
	}

	if(document.getElementById("PAT_PHOTO") != null)
	{
		if('<%=viewPatPhotoYN%>' == "Y" && '<%=patient_id%>' != "")
		{			
			if('<%=pat_photo_in_db_yn%>'=="Y" ){
					document.getElementById("PAT_PHOTO").style.cursor = 'pointer';			
					document.getElementById("PAT_PHOTO").addEventListener("click",function(){ showPatientImage('<%=patient_id%>')});
					document.getElementById("PAT_PHOTO").innerHTML= '<img id="patient_photo" src = "../../eMP/jsp/PaintImage.jsp?patient_id=<%=patient_id%>&pat_photo_in_db_yn=<%=pat_photo_in_db_yn%>&pat_photo_http_path=<%=pat_photo_http_path%>" height="45" width="50" border = "2">';				

				if(<%=no_of_days%> > <%=pat_photo_rnwl_dys%> && <%=pat_photo_rnwl_dys%> !=0) { 
					document.getElementById("patient_photo").style.filter="alpha(opacity=20)";					 
				}				
				document.getElementById("patient_photo").style.border = '2px solid black';
			}else if('<%=pat_photo_in_db_yn%>'=="N" && '<%=File_exist%>'=='Y'){
					document.getElementById("PAT_PHOTO").style.cursor = 'pointer';			
					document.getElementById("PAT_PHOTO").addEventListener("click",function(){ showPatientImage('<%=patient_id%>')});
					document.getElementById("PAT_PHOTO").innerHTML= '<img id="patient_photo" src = "../../eMP/jsp/PaintImage.jsp?patient_id=<%=patient_id%>&pat_photo_in_db_yn=<%=pat_photo_in_db_yn%>&pat_photo_http_path=<%=pat_photo_http_path%>" height="45" width="20">';	
				if(<%=diff_in_days%> > <%=pat_photo_rnwl_dys%> && <%=pat_photo_rnwl_dys%> !=0) {
					document.getElementById("patient_photo").style.filter="alpha(opacity=20)";
				}
				document.getElementById("patient_photo").style.border = '2px solid black';
			}
		}
		/* else
		{
			document.getElementById("PAT_PHOTO").style.display = 'none';
			if(document.getElementById("tdPhoto") != null)
				document.getElementById("tdPhoto").style.display = 'none';
		} */
	}

	if(document.getElementById("DEACTIVATED") != null)
	{
		if('<%=activeYN%>' == 'N')
			document.getElementById("DEACTIVATED").style.display = 'inline';
		else
			document.getElementById("DEACTIVATED").style.display = 'none';
	}

	if(document.getElementById("SUSPENDED") != null)
	{
		if('<%=suspended%>' == 'Y')
			document.getElementById("SUSPENDED").style.display = 'inline';
		else
			document.getElementById("SUSPENDED").style.display = 'none';
	}

	if(document.getElementById("PATIENT_NAME") != null)
	{
		document.getElementById("PATIENT_NAME").style.cursor = 'pointer';
		document.getElementById("PATIENT_NAME").style.color = 'BLUE';
		//document.getElementById("PATIENT_NAME").addEventListener("onmouseover",function(){ dispPatName()});
		//document.getElementById("PATIENT_NAME").addEventListener("click",function(){ callDemographics('<%=patient_id%>')});
		document.getElementById("PATIENT_NAME").addEventListener("click",function(){ callDemographics('<%=patient_id%>')});
		
		if("<%=patient_long_name%>"==""){
			if(document.getElementById("long_name"))
				document.getElementById("long_name").style.display = 'none';
		}else{
			//document.getElementById("lng_name").style.cursor = 'arrow';
			if(document.getElementById("long_name"))
				document.getElementById("long_name").title="<%=patient_long_name%>";
		}
		
	}
	
	if(document.getElementById("PAT_NAME_LOCAL_LANG") != null){
		if("<%=patient_long_name_loc_lang%>"==""){
			if(document.getElementById("long_name_loc"))
				document.getElementById("long_name_loc").style.display = 'none';
		}else{
			//document.getElementById("lng_name_loc").style.cursor = 'pointer';
			if(document.getElementById("long_name_loc"))
				document.getElementById("long_name_loc").title="<%=patient_long_name_loc_lang%>";
		}
	}
  // alert(document.getElementById("VIP_PAT"));alert(vipYN);
	if(document.getElementById("VIP_PAT") != null)
	{
		if('<%=vipYN%>' == 'Y')
			document.getElementById("VIP_PAT").style.display = 'inline';
		else
			document.getElementById("VIP_PAT").style.display = 'none';
	}

	if(document.getElementById("FINANCIAL") != null)
	{
		if('<%=viewPatFinDtlsYN%>' == 'Y')
			document.getElementById("FINANCIAL").style.display = 'inline';
		else
			document.getElementById("FINANCIAL").style.display = 'none';
	}

	if(document.getElementById("DIAGNOSIS") != null)
	{
		document.getElementById("DIAGNOSIS").style.cursor = 'pointer';
		document.getElementById("DIAGNOSIS").addEventListener("click",function(){ callDiagnosis('<%=patient_id%>','<%=episode_id%>')});
	}

	//Added the below code for RUT-CRF-0016 IN023399 on 01.05.2012 by Suresh M
	if(document.getElementById("FREE_TEXT") != null){ 		 

		if(document.getElementById("Remarks").value !=""){			
			document.getElementById("FREE_TEXT").style.cursor = 'pointer';
			document.getElementById("FREE_TEXT").addEventListener("click",function(){ callRemarks(decodeURIComponent(document.getElementById("Remarks").value,'UTF-8'))});
		} else {
			document.getElementById("FREE_TEXT").style.display = 'none';
		}
	
	}

	if(document.getElementById("RIGHT_EYE") != null || document.getElementById("LEFT_EYE") != null)
	{  		
		if('<%=eye_indicator%>' == 'RE') { 			
			if(document.getElementById("LEFT_EYE") != null)document.getElementById("LEFT_EYE").innerHTML="";
		}else if('<%=eye_indicator%>' == 'LE'){  
			if(document.getElementById("RIGHT_EYE") != null)document.getElementById("RIGHT_EYE").innerHTML="";
		} else {  
			if(document.getElementById("LEFT_EYE") != null)document.getElementById("LEFT_EYE").innerHTML="";
			if(document.getElementById("RIGHT_EYE") != null)document.getElementById("RIGHT_EYE").innerHTML="";
		}
	}

	if(document.getElementById("BIRTH_DAY") != null )
	{ 		 
		if('<%=EstimatedAge%>' == '' && ('<%=Day_before_BirthDay%>' != ''  || '<%=Birth_day%>' != '' )) {  
			document.getElementById("BIRTH_DAY").style.display = 'inline';			 
		}
		else{  			 
			document.getElementById("BIRTH_DAY").style.display = 'none';
		}
	} 	 

	if(document.getElementById("SURGERY") != null)
	{			
		if('<%=past_surgery_cnt%>' > 0){  			
		   document.getElementById("SURGERY").style.cursor = 'pointer';
		   document.getElementById("SURGERY").addEventListener("click",function(){ callProcedureDetails('<%=patient_id%>','<%=past_surgery_cnt%>')});
		}else{
			document.getElementById("SURGERY").style.display = 'none';
		}
	}

	if(document.getElementById("PAT_NOTES") != null)	{	
		if('<%=patient_notes_cnt%>' > 0){ 	
			document.getElementById("PAT_NOTES").innerHTML = "<span class='image' title='<%=TOOL_TIP_TEXT%>' id='PAT_NOTES' style = 'cursor:pointer' onclick = patientNotes('<%=patient_id%>','<%=episode_id%>') ><img src='../../eCommon/images/DataNotes.png'></span>";					
		}else{
			document.getElementById("PAT_NOTES").style.cursor = 'pointer';		
		    document.getElementById("PAT_NOTES").addEventListener("click",function(){patientNotes('<%=patient_id%>','<%=episode_id%>')});	
		}	
	}
    /*Below line added for this CRF ML-MMOH-CRF-0780*/
   if(document.getElementById("NEXT_OF_KIN")!=null){	  
		if('<%=nextofKin%>' > 0){
		   document.getElementById("NEXT_OF_KIN").innerHTML = "";
		}else{	   
		   //document.getElementById("NEXT_OF_KIN").style.cursor = 'pointer';
		   document.getElementById('NEXT_OF_KIN').innerHTML = "<span title='<%=NEXT_OF_KIN_TOOLTIP%>' id='nextofkin_blinker'style='color:red;font-size:16px'><img src='../../eCommon/images/NextofKin.png'></span>";		   
		}	

       		
	}	
	//End this CRF ML-MMOH-CRF-0780

	if(document.getElementById('MYHIX_VIEW') != null) //Added for MYHIX integration ML-MMOH-CRF-0507.1
	{			
		if('<%=myhix_appl_YN%>' =='Y' && '<%=myhix_view_YN%>' =='Y'){
			if(document.getElementById('isDiscRefCountApplicable').value=="true") // added by mujafar for ML-MMOH-CRF-1130.1 START
			{
			var temp = "<b><font size='1'>";
			if(document.getElementById('disc_sum_count').value!="")
				temp=temp+" "+"DS:"+document.getElementById('disc_sum_count').value;
			if(document.getElementById('ref_sum_count').value!="")
				temp=temp+" "+"RS:"+document.getElementById('ref_sum_count').value;
			  temp = temp+"</font></b>";
			document.getElementById("MYHIX_VIEW").innerHTML = document.getElementById("MYHIX_VIEW").innerHTML+temp; // added by mujafar for ML-MMOH-CRF-1130.1 END
			document.getElementById("MYHIX_VIEW").style.cursor = 'pointer';
			document.getElementById("MYHIX_VIEW").addEventListener("click",function(){ callMyHix('<%=patient_id%>','<%=episode_id%>')});
			} 
			else
			{
			document.getElementById('MYHIX_VIEW').innerHTML = document.getElementById('MYHIX_VIEW').innerHTML;
			document.getElementById("MYHIX_VIEW").style.cursor = 'pointer';
			document.getElementById("MYHIX_VIEW").addEventListener("click",function(){ callMyHix('<%=patient_id%>','<%=episode_id%>')});	
			} // added by mujafar for ML-MMOH-CRF-1130.1 END
		}else{
			document.getElementById('MYHIX_VIEW').style.visibility = 'hidden';
		}
	}	
	
	/*Added by Thamizh selvi on 4th June 2018 against MMS-DM-CRF-0115 Start*/
	if(document.getElementById("CDR") != null && ('<%=enableCDR%>' == "Y" && '<%=practEnableCDR%>' == "Y" && "<%=isCDRConfigured%>"=="Y")){
		if('<%=cdrCount%>' > 0)	{
			document.getElementById("CDR").style.cursor = 'pointer';
			//document.getElementById("CDR").addEventListener("click",function(){callClinicalDataRepository("<%=patient_id%>","<%=episode_id%>","<%=P_EPISODE_TYPE%>")});
			document.getElementById("CDR").addEventListener("click",function(){callClinicalDataRepository("<%=patient_id%>","<%=nationalityId%>","<%=altID1%>")});
		}else{
			
			
			document.getElementById('CDR').innerHTML = "<span class='image' title='"+getLabel("Common.CDRNoData.label","Common")+"' id='CDR'><img src='../../eCommon/images/CDR_NoData.PNG'></span>";
		}
	}else if(document.getElementById('CDR') != null){
		document.getElementById('CDR').style.visibility = 'hidden';
	}
	/*End*/

	/*Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1117 Start*/
	if(document.getElementById('HIST_ALLERGY') != null)
	{			
		if(!('<%=histAllergyCnt%>' > 0))
			document.getElementById('HIST_ALLERGY').style.visibility = 'hidden';
	}/*End*/	
	
	/*below line added for this CRF Bru-HIMS-CRF-411*/
		
	if(document.getElementById("LENGTH_OF_STAY") != null && '<%=length_of_stay%>'=="")
	{   	
	document.getElementById("LENGTH_OF_STAY").innerHTML=""; 			 
	}	
    //End Bru-HIMS-CRF-411	

	/*Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158*/
	if(document.getElementById("MORSE_FALL_SCALE") && document.getElementById("MORSE_FALL_SCALE") != null)
	{
		var MFSScoreValue = '<%=MFSScore%>';

		if(MFSScoreValue.indexOf("24") != -1)
		{
			document.getElementById("MORSE_FALL_SCALE").innerHTML = "<span class='image' id='MORSE_FALL_SCALE'><img src='../../eCommon/images/Fall_Low_risk.png'></span>";
		}
		else if(MFSScoreValue.indexOf("44") != -1)
		{
			document.getElementById("MORSE_FALL_SCALE").innerHTML = "<span class='image' id='MORSE_FALL_SCALE'><img src='../../eCommon/images/Fall_moderate_risk.png'></span>";
		}
		else if(MFSScoreValue.indexOf("45") != -1)
		{
			document.getElementById("MORSE_FALL_SCALE").innerHTML = "<span class='image' id='MORSE_FALL_SCALE'><img src='../../eCommon/images/Fall_high_risk.png'></span>";
		}
		else
		{
			document.getElementById("MORSE_FALL_SCALE").style.visibility = 'hidden';
		}
	}else
	{
		if (document.getElementById("MORSE_FALL_SCALE"))
		{
			document.getElementById("MORSE_FALL_SCALE").style.visibility = 'hidden';
		}
	}
	/*End ML-MMOH-CRF-1158*/
	
	/*Modified By Dharma Start*/
/*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083 -Start*/
	if(document.getElementById('HAAD_DISEASE') != null)
	{

		var patientId = '<%=patient_id%>';
		var spanElement ;
		var temp;
		var COLOR_CODE ="";
		var DISEASE_NAME ="";
		var docElement ;
		var data;
		if(patientId!=""){
				data = '<%=HAAD_Data%>';
				if(data!=''){
					spanElement = data.split('|');
					
					for(i=0;i<spanElement.length-1;i++){
							temp=spanElement[i].split('~');
							DISEASE_NAME = temp[0];
							COLOR_CODE	= temp[1];
							docElement = eval(document.getElementById("dis"+i));
					
							docElement.style.width="10px";
							docElement.style.height="15px";
							docElement.style.border="1px solid";
							docElement.style.backgroundColor=$.trim(COLOR_CODE);
							docElement.title=$.trim(DISEASE_NAME);				
						}	
				}	
		}
	} /*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083 - End*/

	if(document.getElementById('NUHDEEK_ID') != null)	{	
		if('<%=alt_id4_no%>' !=""){
			document.getElementById('NUHDEEK_ID').innerHTML = "<span class='image' title='Nuhdeek' id='NUHDEEK_ID' style = 'cursor:pointer'><img src='../../eCommon/images/NUHDEEK.png'></span>";					
		}else{
			document.getElementById('NUHDEEK_ID').innerHTML="";	
		}	
	}
	$( "#NUHDEEK_ID" ).click(function() {
			var dataElements	= "P_USE_ID=<%=login_user_id%>&P_NUHDEEK_ID=<%=alt_id4_no%>&P_PATIENT_ID=<%=patient_id%>&P_ENCNTR_DATE=<%=P_ENCNTR_DATE%>&P_VISIT_ID=<%=P_VISIT_ID%>&P_EPISODE_ID=<%=P_EPISODE_ID%>&P_EPISODE_TYPE=<%=P_EPISODE_TYPE%>&P_PHYSICIAN_ID=<%=P_PHYSICIAN_ID%>&P_ACCESSION_NUM=&P_ORDER_ID=&P_ORDER_TYPE_CODE=&P_LOCN_TYPE=<%=P_LOCN_TYPE%>&P_LOCN_CODE=<%=P_LOCN_CODE%>&P_CUST_CODE=&P_ITEM_CODE=&P_RESP_ID=<%=resp_id%>&P_FACILITY_ID=<%=facility_id%>&P_INV_ORG_ID=&P_MODULE_ID=<%=P_MODULE_ID%>&P_FUNCTION_ID=<%=P_FUNCTION_ID%>&P_ACCESS_RIGHTS=&P_LANGUAGE_ID=<%=localeName%>&P_MULTI_SITE_YN=&P_MULTI_LANG_YN=&P_WS_NO=&P_Ext_Input_Key=&P_Ext_Application_ID=DMS&P_Ext_Function=VIEW&P_pwd=&P_Connect_string=&P_LOCN_DESC=<%=P_LOCN_DESC%>";	
			dispExtApp(dataElements);		
	});
	/*Modified By Dharma End*/
	/*Added By Dharma on 8th July 2020 against AAKH-CRF-0119.1 Start*/
	$( "#MALAFFI_ICON" ).click(function() {
			var dataElements	= "<PATIENT_ID><%=patient_id%>$!^<PRACTITIONER_ID><%=P_PHYSICIAN_ID%>$!^<USER_NAME><%=login_user_id%>$!^<MACHINE_ID><%=workStationId%>$!^<SESSION_ID>";	
			EMWebMalaffi(dataElements);		
	});
	/*Added By Dharma on 8th July 2020 against AAKH-CRF-0119.1 End*/

	$( "#PAT_DMS" ).click(function() {
		/* $.ajax({  
			url:'../../servlet/eXH.InvokeExternalApplication',		  
		      type:'post',  
		      data:{'P_USE_ID':'<%=login_user_id%>','P_PATIENT_ID':'<%=patient_id%>','P_ENCNTR_DATE':'<%=P_ENCNTR_DATE%>','P_VISIT_ID':'<%=P_VISIT_ID%>','P_EPISODE_ID':'<%=P_EPISODE_ID%>','P_EPISODE_TYPE':'<%=P_EPISODE_TYPE%>','P_PHYSICIAN_ID':'<%=P_PHYSICIAN_ID%>','P_ACCESSION_NUM':'','P_ORDER_ID':'','P_ORDER_TYPE_CODE':'','P_LOCN_TYPE':'<%=P_LOCN_TYPE%>','P_LOCN_CODE':'<%=P_LOCN_CODE%>','P_CUST_CODE':'','P_ITEM_CODE':'','P_RESP_ID':'<%=resp_id%>','P_FACILITY_ID':'<%=facility_id%>','P_INV_ORG_ID':'','P_MODULE_ID':'','P_FUNCTION_ID':'','P_ACCESS_RIGHTS':'','P_LANGUAGE_ID':'<%=localeName%>','P_MULTI_SITE_YN':'','P_MULTI_LANG_YN':'','P_WS_NO':'','P_Ext_Input_Key':'','P_Ext_ Application_ID':'DMS','P_Ext_Function':'VIEW','P_pwd':'','P_Connect_string':''},
		      dataType: 'html'		    
		 });*/
         
		var dataElements	= "P_USE_ID=<%=login_user_id%>&P_PATIENT_ID=<%=patient_id%>&P_ENCNTR_DATE=<%=P_ENCNTR_DATE%>&P_VISIT_ID=<%=P_VISIT_ID%>&P_EPISODE_ID=<%=P_EPISODE_ID%>&P_EPISODE_TYPE=<%=P_EPISODE_TYPE%>&P_PHYSICIAN_ID=<%=P_PHYSICIAN_ID%>&P_ACCESSION_NUM=&P_ORDER_ID=&P_ORDER_TYPE_CODE=&P_LOCN_TYPE=<%=P_LOCN_TYPE%>&P_LOCN_CODE=<%=P_LOCN_CODE%>&P_CUST_CODE=&P_ITEM_CODE=&P_RESP_ID=<%=resp_id%>&P_FACILITY_ID=<%=facility_id%>&P_INV_ORG_ID=&P_MODULE_ID=<%=P_MODULE_ID%>&P_FUNCTION_ID=<%=P_FUNCTION_ID%>&P_ACCESS_RIGHTS=&P_LANGUAGE_ID=<%=localeName%>&P_MULTI_SITE_YN=&P_MULTI_LANG_YN=&P_WS_NO=&P_Ext_Input_Key=&P_Ext_Application_ID=DMS&P_Ext_Function=VIEW&P_pwd=&P_Connect_string=&P_LOCN_DESC=<%=P_LOCN_DESC%>";
	
		dispExtApp(dataElements);
	});
	/*Modified By Dharma End*/
	
	/*Added by Ajay Hatwate for ML-MMOH-CRF-1954 on 05/07/2023 */
	var mlc_yn = '<%=mlc_yn%>';
	var mlcAppl = '<%=isMlcApplicable%>';
	if(mlcAppl == 'true'){
		if(document.getElementById('MLC') || document.getElementById('MLC') != null){
			if(mlc_yn != 'Y'){
				document.getElementById('MLC').style.display = 'none';
			}
		}
	}else{
		if(document.getElementById('MLC') || document.getElementById('MLC') != null){
			document.getElementById('MLC').style.display = 'none';
		}
	}
	/*End of ML-MMOH-CRF-1954 */
	//Added by Kamatchi S for ML-MMOH-CRF-1182
    if(document.getElementById('FPP_ICON') && document.getElementById('FPP_ICON') != null)
    {       
        var FPPValue = '<%=FPPPatient_yn%>';
        if(FPPValue == "Y" && document.getElementById('isFPPDisplayApplicable').value=="true")
        {
            document.getElementById('FPP_ICON').innerHTML = "<span class='image' id='FPP_ICON'><img src='../../eCommon/images/FPP.png'></span>";
        }
        else
        {
            document.getElementById('FPP_ICON').style.display = 'none';
        }
    }
	else
	{
		if (document.getElementById('FPP_ICON'))
		{
			document.getElementById('FPP_ICON').style.visibility = 'hidden';
		}
	}
	/*End*/
	
	
	if(document.getElementById('ARCHIVE_LINK') != null)
	{
		if('<%=archival_yn%>' == 'Y' && document.getElementById("isArchivalDisplayApplicable").value=="true"){
			document.getElementById("ARCHIVE_LINK").style.cursor = 'pointer';
			document.getElementById("ARCHIVE_LINK").addEventListener("click",function(){callArchivalData("<%=login_user_id%>","<%=user_password%>","<%=facility_id%>","<%=patient_id%>","<%=lst_purge_encntr_id%>","<%=ArchivalDBUrl%>")});
		}
		else {
			document.getElementById('ARCHIVE_LINK').style.display = 'none';
		}
	}
// Ends Suresh	

//Below NOK blinker code commented on 1st Aug 2018 by Thamizh selvi
/*Below line added for this CRF ML-MMOH-CRF-0780	
var blink_speed = 600; 
setInterval(function () {
var elemt ="";
if(document.getElementById('nextofkin_blinker')) elemt=document.getElementById('nextofkin_blinker'); 

if(document.getElementById('NEXT_OF_KIN')!=null && '<%=nextofKin%>'==0) elemt.style.visibility = (elemt.style.visibility == 'hidden' ? '' : 'hidden'); 
 
 }, blink_speed);
//End this CRF ML-MMOH-CRF-0780*/
</script>


