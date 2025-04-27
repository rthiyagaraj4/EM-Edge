
<%
/*
Sr No              Version                TFS id              SCF/CRF                        Developer Name
------------------------------------------------------------------------------------------------------------------------
1                  V202009                 4322           	 NMC-JD-SCF-0095        		 Shikha Seth/Mohana
2                  V220816                34122              TH-KW-CRF-0156                  Namrata/Manivel
3										  39432				 MMS-QF-SCF-0664				 Manivel N
*/
%>

<%@page import="java.net.URLDecoder"%> 
<%@page import="eBL.Common.*"%>
<%@page import="eBL.PkgSubsBean"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,  eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%!

private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
}
private String checkForNull(String inputString) {
	return (inputString == null) ? "" : inputString;
}
%>
<%
request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs_pat = null;
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	try {
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		} catch(Exception ex) {
			System.err.println("Error in EncounterCommonValidation.jsp for getting site3TierAlmoFeature Connection: "+ex);
			ex.printStackTrace();
		}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
	//Added by Manivel for TH-KW-CRF-0156
	boolean dfltRcptTypeForDeposit = false;
	try {
		dfltRcptTypeForDeposit = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENBL_DFLT_RCPT_TYPE_FOR_NATURE");
		} catch(Exception ex) {
			System.err.println("Error in EncounterCommonValidation.jsp for getting dfltRcptTypeForDeposit Connection: "+ex);
			ex.printStackTrace();
		}
		
	try {	
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		
	 if("get_Pat_Details".equals(func_mode)){
		String patId = request.getParameter("patient_id");
		CallableStatement call = con.prepareCall("{ ? = call  IBAEHIS.blhealthcard.get_dob(?,sysdate)}");	
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,patId);
		call.execute();							
		String age = call.getString(1);
		String ageArr[] = age.split(" ");
		int years=Integer.parseInt(ageArr[0]);
		int months=Integer.parseInt(ageArr[2]);
		int days=Integer.parseInt(ageArr[4]);
		String sex = "";
		String patName = "";
		//System.out.println("welcme to the file PKG Subscription Dtls "+ years+"/"+months+"/"+days);
		String sql = 	"select patient_name, sex from mp_patient where patient_id = ?";		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, patId);
		rs_pat = pstmt.executeQuery();
		while(rs_pat != null && rs_pat.next()){
			patName = rs_pat.getString("patient_name");
			sex = rs_pat.getString("sex");
		}
		out.println( years+":::"+months+":::"+days+":::"+sex+":::"+patName);
		pstmt.close();
		rs_pat.close();
		call.close();
	}
	 else if("CHK_PAT_ID".equals(func_mode))	
		{
			String patient_id	= request.getParameter( "patient_id" );
			String str_x="";
			pstmt = con.prepareStatement( "SELECT 'X' FROM mp_patient WHERE patient_id='"+patient_id+"'");			
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				str_x  =  rs_pat.getString(1);
			}
			if(str_x==null) str_x="";
			if(str_x.equals("")){
			out.println("N");
			}else{
				out.println("Y");
			}


		}
	 else if("clearBean".equals(func_mode))	
		{
		 	String beanId = "bl_EncounterSpecificDefinitionBean" ;
		 	String beanName = "blPolicy.EncounterSpecificDefinitionBean";
		 
		 	EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
			cleanBeanObject(beanId, beanName, request);
		 	policyBean.clearAll();
		 	
		 	EncounterSpecificDefinitionBean deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject("DeletedEncounterBean", beanName, request);
		 	cleanBeanObject("DeletedEncounterBean", beanName, request);
		 	deletedPolicyBean.clearAll();
		 	
		 	out.println("Y");

		}
	 else if("validatePolicy".equals(func_mode))	
		{
			String payerGroup	= request.getParameter( "payerGroup" );
			String payer	= request.getParameter( "payer" );
			String policy	= request.getParameter( "policy" );
			int rsCnt = 0;
			//pstmt = con.prepareStatement( "SELECT count(1) total FROM bl_ins_policy_type_hdr WHERE CUST_GROUP_CODE= ? and CUST_CODE = ? and POLICY_TYPE_CODE = ?");	
			pstmt = con.prepareStatement( "SELECT count(1) total FROM bl_ins_policy_type_hdr WHERE CUST_GROUP_CODE= ? and CUST_CODE = ? and POLICY_TYPE_CODE = ? and operating_facility_id = ?"); //V202009 added by shikha
			pstmt.setString(1,payerGroup);
			pstmt.setString(2,payer);
			pstmt.setString(3,policy);
			pstmt.setString(4,facilityId);//V202009 added by Shikha
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				rsCnt  =  rs_pat.getInt("total");
			}

			//System.err.println("total cnt->"+rsCnt);
			if(rsCnt>0){
				out.println("N");
			}else{
				out.println("Y");
			}

			pstmt = null;
			rs_pat = null;
		}
		else if("defaultEncounter".equals(func_mode))	
		{
			//System.err.println("defaultEncounter");
		 	String patId	= request.getParameter( "pat_id" );
			String epsdType	= request.getParameter( "epsdType" );
			String facility_id = request.getParameter( "facility_id" );
			String sqlEpsiodeId = "",sqlEpisodeCount = "";

			/*if(("I".equals(epsdType)) || ("D".equals(epsdType))){
				sqlEpsiodeId = "Select episode_id from bl_episode_fin_dtls where patient_id = '"+patId+"' and episode_type= '"+epsdType+"' ";	
				//sqlEpisodeCount = "Select count(episode_id) from bl_episode_fin_dtls where patient_id = '"+patId+"' and episode_type= '"+epsdType+"' ";
			}
			else if(("O".equals(epsdType)) || ("R".equals(epsdType)) || ("E".equals(epsdType))){
				sqlEpsiodeId = "Select episode_id from bl_visit_fin_dtls where patient_id = '"+patId+"' and episode_type = '"+epsdType+"' ";	
				//sqlEpisodeCount = "Select episode_id from bl_visit_fin_dtls where patient_id = '"+patId+"' and episode_type = '"+epsdType+"' "
			}*/
			sqlEpsiodeId = "Select distinct(to_char(Episode_Id)) episode_id,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time,(to_char(VISIT_ID)) visit_id  from Bl_Encounter_Payer_Priority where operating_facility_id = '"+facility_id+"' and patient_id = '"+patId+"' and episode_type= '"+epsdType+"' ";	
			System.out.println(sqlEpsiodeId);
			int rsCnt = 0,rsVisit=0;
			String encDate = "";
			int cnt = 0;
			//System.err.println("sql->"+sqlEpsiodeId);
			pstmt = con.prepareStatement(sqlEpsiodeId);	
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				rsCnt  =  rs_pat.getInt("episode_id");
			
				encDate = rs_pat.getString("Enc_Regn_Date_Time");
				rsVisit  =  rs_pat.getInt("visit_id");
				cnt++;
			}

			if(cnt != 1){
				out.println("N");
			}else {
				out.println(rsCnt+":::"+encDate+":::"+rsVisit);
			}

			pstmt = null;
			rs_pat = null;

		}
	 
		else if("defaultReceipttype".equals(func_mode))	
		{

		 	String rcptdesc	= request.getParameter( "rcptdesc" );
			String facility_id = request.getParameter( "facility_id" );
			String	sqlrecpttype = "";
			//System.err.println("rcptnature="+rcptnature);
			//rcptnature = "PR";
		//	System.out.println("rcptnature11="+RECPT_NATURE_CODE);
			sqlrecpttype=	 "SELECT   DISTINCT receipt_type_code ,  long_desc, dflt_rcpt_type_for_nature  FROM bl_receipt_type_lang_vw WHERE receipt_type_code = NVL (NULL, receipt_type_code) AND  language_id='"+locale+"' AND acc_entity_code IN ( SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = '"+facility_id+"') AND receipt_type_code IN ( SELECT receipt_type_code FROM bl_receipt_type_lang_vw  WHERE recpt_nature_code ='"+rcptdesc+"' AND language_id='"+locale+"' AND NVL	 (status, 'X') <> 'S') "; // Query modified by Manivel N on 16-08-22 for TH-KW-CRF-0156
			System.err.println("sqlrecpttype="+sqlrecpttype);
			String rsCnt = "";
			String rsCnt1="";
			String isDfltRcptTypeYN = "N"; // Added by Manivel N on 16-08-22 for TH-KW-CRF-0156
			String dfltRcptTypeString = ""; // Added by Manivel N on 16-08-22 for TH-KW-CRF-0156
			int cnt = 0;
			
			pstmt = con.prepareStatement(sqlrecpttype);	
			rs_pat = pstmt.executeQuery();	
			System.out.println("sqlrecpttype"+sqlrecpttype);
			while(rs_pat!=null && rs_pat.next())
			{
				
				rsCnt  =  rs_pat.getString("receipt_type_code");
				rsCnt1  =  rs_pat.getString("long_desc");
				
				// Added by Manivel N on 16-08-22 for TH-KW-CRF-0156
				isDfltRcptTypeYN = rs_pat.getString("dflt_rcpt_type_for_nature");
				if("Y".equals(isDfltRcptTypeYN))
					dfltRcptTypeString = rsCnt+":::"+rsCnt1;
				
				cnt++;
			}
			
			if(cnt != 1){
				// Added by Manivel N on 16-08-22 for TH-KW-CRF-0156
				if(dfltRcptTypeForDeposit){
					if(!dfltRcptTypeString.equals(""))
						out.println(dfltRcptTypeString);
					else
						out.println("N");
				} else
					out.println("N");
			}else {
				out.println(rsCnt+":::"+rsCnt1);
			}

			pstmt = null;
			rs_pat = null;

		}
	
		 else if("copyPolicy".equals(func_mode))	
		{
		 	String fromPayerCode	= request.getParameter( "fromPayerCode" );
			String fromPayer	= request.getParameter( "fromPayer" );
			String fromPolicy	= request.getParameter( "fromPolicy" );
			String fromFacility	= request.getParameter( "fromFacility" );
			String toPayerCode	= request.getParameter( "toPayerCode" );
			String toPayer	= request.getParameter( "toPayer" );
			String toPolicy	= request.getParameter( "toPolicy" );
			String toFacility	= request.getParameter( "toFacility" );
			String startDate   = request.getParameter( "startDate" );
			if(startDate==null) startDate="";			
			String endDate   = request.getParameter( "endDate" );
			if(endDate==null) endDate="";
			System.err.println("fromPayerCode->"+fromPayerCode);
			System.err.println("fromPayer->"+fromPayer);
			System.err.println("fromPolicy->"+fromPolicy);
			System.err.println("fromFacility->"+fromFacility);
			System.err.println("toPayerCode->"+toPayerCode);
			System.err.println("toPayer->"+toPayer);
			System.err.println("toPolicy->"+toPolicy);
			System.err.println("toFacility->"+toFacility);
			//Added by Rajesh V for MMS-ICN-0036
			String	loggedInUser	=  (String) session.getValue("login_user");	
			Properties p = (Properties) session.getValue( "jdbc" ) ;
			String clientIpAddress	= p.getProperty("client_ip_address");
			String str_error_level = "", str_sysmesage_id="", str_error_text="",returnMessage = "";
			String success = "";
			//String startDate = "", endDate="";
			String cstSql="";

			con.setAutoCommit(false);
			System.err.println("in encountercommon.jsp="+startDate+"/"+endDate+"/");
			 if(startDate.length()==0)
				 cstSql ="{ call   blinspolicycoverage.copypolicy (?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,NULL)}";
		 	 else if(endDate.length()==0)
		 		cstSql ="{ call   blinspolicycoverage.copypolicy (?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),NULL)}";
		 	 else
		 		cstSql ="{ call   blinspolicycoverage.copypolicy (?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))}";
			System.err.println("cstSql="+cstSql);
			CallableStatement cstmt = con.prepareCall(cstSql);
								
			cstmt.setString(1, fromFacility);
			cstmt.setString(2, fromPayerCode);
			cstmt.setString(3, fromPayer);
			cstmt.setString(4, fromPolicy);
			cstmt.setString(5, toFacility);
			cstmt.setString(6, toPayerCode);
			cstmt.setString(7, toPayer);
			cstmt.setString(8, toPolicy);
			//Changed Param Sequencing by Rajesh V for MMS-ICN-0036
			cstmt.setString(9, loggedInUser);
			cstmt.setString(10, clientIpAddress);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			if(startDate.length()>0)
			{
				cstmt.setString(14, startDate);
			 if(endDate.length()>0)
				 cstmt.setString(15, endDate);
			
			}
				

			System.err.println("before execute");

			cstmt.execute();
			System.err.println("after execute");
			str_error_level = cstmt.getString(11);
			str_sysmesage_id = cstmt.getString(12);
			str_error_text = cstmt.getString(13);

			System.err.println("str_error_level->"+str_error_level);
			System.err.println("str_sysmesage_id->"+str_sysmesage_id);
			System.err.println("str_error_text->"+str_error_text);
			if(str_error_level == null && str_error_text == null && str_sysmesage_id == null){
				returnMessage = "Operation Completed Sucessfully";
				con.commit();
				success = "Y";

				String sqlEpsiodeId = "select to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? ";
				pstmt = con.prepareStatement(sqlEpsiodeId);	
				pstmt.setString(1,toFacility);
				pstmt.setString(2,toPayerCode);
				pstmt.setString(3,toPayer);
				pstmt.setString(4,toPolicy);
				rs_pat = pstmt.executeQuery();	
				while(rs_pat!=null && rs_pat.next())
				{
					startDate  =  rs_pat.getString("effective_from");
					endDate = rs_pat.getString("effective_to");
				}

			}
			else{
				if(str_error_level!=null || str_error_text!=null){
					returnMessage = str_error_text;
				}

				if(str_sysmesage_id!=null){
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							/*try{
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								System.err.println("Exceprion in RB ->"+rbException);
							}*/
							
							returnMessage += "<br/>"+msgArr[l];
						}
					}else{
						
						/*try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
						}*/
						returnMessage += "<br/>"+str_sysmesage_id;
					}
				}
				con.rollback();
				success = "N";
			}
			returnMessage += ":::###"+success+":::###"+startDate+":::###"+endDate;
			out.println(returnMessage);
			cstmt = null;
			pstmt = null;
			rs_pat = null;
		}
		else if("approval_check".equals(func_mode))	
	{
			
			String patient_id	= request.getParameter( "patient_id" );
			String episode_type	= request.getParameter( "episode_type" );
			String episode_id	= request.getParameter( "episode_id" );
			String apprvl_yn ="";

			if(patient_id == null) patient_id  = "";
			if(episode_type == null) episode_type  = "";
			if(episode_id == null) episode_id  = "";		


		try
		{
			String cstSql ="{ ?=call   bl_charge.bl_get_bill_approved_enc (?,?,?,?)}";
			CallableStatement cstmt = con.prepareCall(cstSql);
									
            cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
			cstmt.setString(2, facilityId);
			cstmt.setString(3, patient_id);
			cstmt.setString(4, episode_id);
			cstmt.setString(5, episode_type);
			cstmt.execute();
			apprvl_yn = cstmt.getString(1);
			if(cstmt!=null) cstmt.close();

		}
		catch(Exception ee)
		{
		}

			
			out.println(""+apprvl_yn);

	}
		else if("compareBeans".equals(func_mode))	
		{
			System.err.println("In compareBeans");
			String polFacilityId = request.getParameter("facility_id");
			String payerGroup = request.getParameter("payerGroup");
			String payer = request.getParameter("payer");
			String policy = request.getParameter("policy");
			String key = request.getParameter("key");

			String beanId = "PayerPolicyInsuranceMasterBean";
			String beanName = "eBL.PolicyInsuranceMasterBean";
			List<PolicyInsuranceMasterBean> inPatListSession = null; 
			List<PolicyInsuranceMasterBean> externalListSession = null; 
			//List<PolicyInsuranceMasterBean> preAppListSession = null; 
			
			List<PolicyInsuranceMasterBean> inPatListMethod = null; 
			List<PolicyInsuranceMasterBean> externalListMethod = null; 
			//List<PolicyInsuranceMasterBean> preAppListMethod = null; 

			HashMap<String,List<PolicyInsuranceMasterBean>> policyMapSession = null;
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMapMethod = null;

			HashMap<String,PolicyInsuranceMasterBean> masterMap = null;

			//HashMap<String,List<PolicyInsuranceMasterBean>> popupMapMethod = null;
			//HashMap<String,List<PolicyInsuranceMasterBean>> popupMapSession = null;

			//List<PolicyInsuranceMasterBean> exclusionListSession = null; 
			//List<PolicyInsuranceMasterBean> exclusionListMethod = null; 

			PolicyInsuranceMasterBean policyBean = new PolicyInsuranceMasterBean();
			
			PolicyInsuranceMasterBean policyBeanIndSession = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
			PolicyInsuranceMasterBean policyBeanSession = null;
			System.err.println("policyBeanIndSession->"+policyBeanIndSession);
			if(policyBeanIndSession != null){
				masterMap = policyBeanIndSession.getMasterMap();
			}

			if(masterMap != null){
				policyBeanSession = masterMap.get(key);
			}
			System.err.println("policyBeanSession->"+policyBeanSession);
			if(policyBeanSession != null){
				System.err.println("policyBeanSession not null");
				policyMapSession = policyBeanSession.getPolicyMap();
				System.err.println("policyMapSession->"+policyMapSession);
				if(!(policyMapSession == null || policyMapSession.isEmpty())){
					System.err.println("Populating policyMapSession");
					inPatListSession = policyMapSession.get("Inpatient");
					externalListSession = policyMapSession.get("External");
					//preAppListSession = policyMapSession.get("preApproval");
				}

				//popupMapSession = policyBeanSession.getPopupMap();
			}
			
			//
			/*System.err.println("popupMapSession->"+popupMapSession);
			if(popupMapSession != null){
				for (Iterator iterator = popupMapSession.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					System.err.println("Session Key is->"+type);
					
				}
			}*/
			//
			String plcyOrEnctr = request.getParameter("plcyOrEnctr");
			PolicyInsuranceMasterBean policyBeanMethod = null;
			if("policy".equals(plcyOrEnctr)){
				policyBeanMethod = policyBean.getPolicyDefinitionDetials(polFacilityId, payerGroup, payer, policy, locale);
			}
			else{
				String hdnpatientId = request.getParameter("hdnpatientId");
				String hdnvisitId = request.getParameter("hdnvisitId");
				String hdnacctSeq = request.getParameter("hdnacctSeq");
				String hdnpriority = request.getParameter("hdnpriority");
				String hdnepisodeType = request.getParameter("hdnepisodeType");
				String hdnepisodeId = request.getParameter("hdnepisodeId");
				String hdnpolicyNo = request.getParameter("hdnpolicyNo");
				policyBeanMethod = policyBean.getEncounterSpecificDetials(polFacilityId, payerGroup, payer, policy, hdnpatientId, hdnepisodeType, hdnepisodeId, hdnvisitId, hdnacctSeq, hdnpriority, hdnpolicyNo, locale);
			}

			if(policyBeanMethod != null){
				policyMapMethod = policyBeanMethod.getPolicyMap();
				if(!(policyMapMethod == null || policyMapMethod.isEmpty())){
					inPatListMethod = policyMapMethod.get("Inpatient");
					externalListMethod = policyMapMethod.get("External");
					//preAppListMethod = policyMapMethod.get("preApproval");
				}

				//popupMapMethod = policyBeanMethod.getPopupMap();
			}

			
			/*if(popupMapMethod != null){
				System.err.println("popupMapMethod->"+popupMapMethod);
				for (Iterator iterator = popupMapMethod.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					System.err.println(" Method Key is->"+type);
					
				}
			}*/
			System.err.println("in list sess"+inPatListSession);
			System.err.println("ext list sess"+externalListSession);
			//System.err.println("preapp list sess"+preAppListSession);
			System.err.println("in list mthd"+inPatListMethod);
			System.err.println("ext list mthd"+externalListMethod);
			//System.err.println("preapp list mthd"+preAppListMethod);
			if(inPatListMethod != null && inPatListSession == null){
				policyMapSession.put("Inpatient", inPatListMethod);
				System.err.println("in list updated");
			}
			
			if(externalListMethod != null && externalListSession == null){
				policyMapSession.put("External", externalListMethod);
				System.err.println("external updated");
			}
			
			/*if(preAppListMethod != null && preAppListSession == null){
				policyMapSession.put("preApproval", preAppListMethod);
				System.err.println("preapp updated");
			}
			
			if((!(popupMapMethod == null || popupMapMethod.isEmpty())) && (popupMapSession == null || popupMapSession.isEmpty())){
				policyBeanSession.setPopupMap(popupMapMethod);
				System.err.println("All Exclusions are copied");

			}
			else if( (!(popupMapMethod == null || popupMapMethod.isEmpty())) && (!(popupMapSession == null || popupMapSession.isEmpty()))){
				for (Iterator iterator = popupMapMethod.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					exclusionListSession = popupMapSession.get(type);
					exclusionListMethod = popupMapMethod.get(type);

					if(exclusionListMethod != null && exclusionListSession == null){
						popupMapSession.put(type,exclusionListMethod);
						System.err.println(" Exclusion Copied for row no ->"+type);
					}
					
					
				}
				
			}*/

			masterMap.put(key, policyBeanSession);
			putObjectInBean(beanId,policyBeanIndSession,request);
			out.println("Y");
		}
		else if("clearBeanFromMP".equals(func_mode)){
			
			eBL.BLInsuranceImageBean blInsuranceImageBean 		= 	null;
			String bean_id							= 	"bl_blinsuranceimagebean" ;
			String bean_name						= 	"eBL.BLInsuranceImageBean";
			blInsuranceImageBean					= 	(eBL.BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
			blInsuranceImageBean.clearBean();
			
			String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
			String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
			PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;
			if(pol_bean!=null)
			pol_bean.clearAll();
			cleanBeanObject(pol_bean_id, pol_bean_name, request);

			String enc_pol_bean_id		= "EncPolicyInsuranceMasterBean" ;
			String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";							
			PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, request ) ;
			if(enc_pol_bean!=null)
			enc_pol_bean.clearAll();
			cleanBeanObject(enc_pol_bean_id, enc_pol_bean_name, request );
			
			session.setAttribute("VALID_ACROSS_ENCOUNTER_MAP",null);						
			session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",null);
		}
		else if("loadPayerFinDtls".equals(func_mode)){
			String retVal = request.getParameter("payerDtls");
			if(retVal == null)	retVal = "";
			if(retVal.length()>0){
				retVal = retVal.substring(1);
				session.setAttribute("BL_PAYER_LIST_FROM_SETUP",retVal);
			}

			out.println("Y");
		}
		else if("prevEncounterCheck".equals(func_mode))	
		{
			String blngClass	= request.getParameter( "blngClass" );
			String custGrp	= request.getParameter( "custGrp" );
			String patClass	= request.getParameter( "patClass" );
			
			if(blngClass == null)	blngClass="";
			if(custGrp == null)		custGrp="";
			if(patClass == null)	patClass="";
			
			StringTokenizer blngClassArr = new StringTokenizer(blngClass,"|");
			StringTokenizer custGrpArr =  new StringTokenizer(custGrp,"|");
			
			String returnVal = "Y";
			//Y Means Restrict in Front End. N Means No Restriction
			if(blngClassArr.countTokens() == custGrpArr.countTokens()){				
				while(custGrpArr.hasMoreTokens()){
					pstmt = null;
					String sqlPrevEnc = "Select count(*) total "+
										" from bl_payers_priority_by_bg "+
										" where nvl(status,'E') = 'E' "+
										" and blng_grp_id = ? "+
										" and cust_group_code = ? "+
										" and patient_class = ? "+
										" and operating_facility_id = ? ";
					pstmt = con.prepareStatement(sqlPrevEnc);
					pstmt.setString(1, blngClassArr.nextToken());
					pstmt.setString(2, custGrpArr.nextToken());
					pstmt.setString(3, patClass);
					pstmt.setString(4, facilityId);
					rs_pat = pstmt.executeQuery();
					if(rs_pat != null && rs_pat.next()){
						if(rs_pat.getInt("total") == 0){
							returnVal = "Y";
							break;
						}
						else		returnVal = "N";
						
					}
				}
			}
			else{
				returnVal = "Y";
			}

			out.println(returnVal);

			pstmt = null;
			rs_pat = null;
		}
		else if("priorityOneCheck".equals(func_mode)){
			
			/* Karthik added for adding Package Association */
			String siteParam="";				
			PreparedStatement pstmt_pri = null;
			ResultSet rs_pri = null;
				try{
					String siteParamSql = "Select CUSTOMER_ID from SM_SITE_PARAM ";
					pstmt_pri = con.prepareStatement(siteParamSql);		
					rs_pri = pstmt_pri.executeQuery();
					if(rs_pri != null){
						if(rs_pri.next()){
							siteParam = rs_pri.getString("CUSTOMER_ID");
							if(siteParam==null){
								siteParam="";
							}
						}
					}			
	
				}
				catch(Exception e)
				{
					System.out.println("Exception in getting bl_param"+e);
				}finally{
					if(pstmt_pri!=null){
					pstmt_pri.close();
					}
					if(rs_pri!=null){
					rs_pri.close();
					}
					
				}
				/* Karthik added for adding Package Association */
		//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeature & AAKH-SCF-0404.1
		if(siteParam.equals("ALMO") || site3TierAlmoFeature == true){
				out.println("N");
			}else{
			String payerGrpCode,payerCode = "";
			String insCustGrp = request.getParameter("insCustGrp");
			String insCust = request.getParameter("insCust");
			PkgSubsBean bean			= (PkgSubsBean)getBeanObject( "PkgSubsBean", "eBL.PkgSubsBean", request ) ;
			String patientId = (String) session.getAttribute("patient_id");			
			HashMap  patPackSubsDetails=bean.getPatientPackSubsDtls();
			ArrayList	pkgDtls		=	new ArrayList();
			ArrayList	pkgCodes		=	new ArrayList();
			ArrayList	payerGrpCode_list	=	new ArrayList();
			ArrayList	payerCode_list	=	new ArrayList();
			String restrict = "N";
			if(patPackSubsDetails.size()>0 && patPackSubsDetails.containsKey(patientId) )			
			{
				pkgDtls					=(ArrayList)patPackSubsDetails.get(patientId);
				if(pkgDtls.size()>0)
				{
					pkgCodes = (ArrayList)pkgDtls.get(0);
					payerGrpCode_list = (ArrayList)pkgDtls.get(7);
					payerCode_list = (ArrayList)pkgDtls.get(9);
				}
			}
			
			int totRec = 0;
			if(pkgCodes.size() >0)
				totRec = pkgCodes.size();	
			
			for(int i=0; i<totRec; i++)
			{	
				if(pkgCodes.size() >0){
					payerGrpCode	=(String)payerGrpCode_list.get(i);
					payerCode	=(String)payerCode_list.get(i);
					if(!insCustGrp.equals(payerGrpCode) || !insCust.equals(payerCode)){
						restrict = "Y";
					}
				}
			}
			out.println(restrict);
		}
		}
		else if("eGLCustGroup".equals(func_mode)){
			
			String cust_code =request.getParameter("cust_code");
			String cust_grp_code=request.getParameter("cust_grp_code");
			String reln_code = request.getParameter("reln_code");
			String episode_type = request.getParameter("episode_type");
			String reln_desc ="";
			String valid_from_dt="";
			String valid_to_dt="";
			String start_date="";
			String end_date="";
			String cust_desc="";
			String cust_grp_desc="";
			
			String sqlCustomer = "select to_char(valid_from,'dd/mm/yyyy') effective_from,to_char(valid_to,'dd/mm/yyyy') effective_to,short_name cust_desc from ar_customer where CUST_CODE = ?  ";
			try
			{
			pstmt = con.prepareStatement(sqlCustomer);	
			pstmt.setString(1,cust_code);
			
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				valid_from_dt  =  rs_pat.getString("effective_from");
				valid_to_dt = rs_pat.getString("effective_to");
				cust_desc  = rs_pat.getString("cust_desc");
			}
			}
			catch(Exception ee) 
			{
				cust_desc="Err";
			}
			if(pstmt !=null) pstmt.close();
			if(rs_pat!=null) rs_pat.close();
			
			/* Karthik added to take egl difference days data from database */
			
			String egl_diff_days_query=
					"SELECT DECODE (?, "+
				               "'O', NVL (egl_op_doc_days, 90), "+
				               "'E', NVL (egl_em_doc_days, 90), "+
				               "'I', NVL (egl_ip_doc_days, 30), "+
				               "'D', NVL (egl_dc_doc_days, 30) "+
				               ") "+
				  " FROM bl_parameters "+
				  " WHERE operating_facility_id = ?";
			
			String egl_diff_days= BLHelper.getDescriptionViaSQL(con,egl_diff_days_query, episode_type,facilityId);
			if(egl_diff_days==null || egl_diff_days.equals("")){
				egl_diff_days="30";
			}
			
			sqlCustomer = "select to_char(sysdate,'dd/mm/yyyy') start_date,to_char(sysdate+"+egl_diff_days+",'dd/mm/yyyy') end_date from dual   ";
			//sqlCustomer = "select short_desc cust_grp_desc,to_char(sysdate,'dd/mm/yyyy') start_date,to_char(sysdate+90,'dd/mm/yyyy') end_date from ar_cust_group where CUST_GROUP_CODE = ?  ";
			try
			{
			pstmt = con.prepareStatement(sqlCustomer);				
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				start_date  =  rs_pat.getString("start_date");
				end_date = rs_pat.getString("end_date");
			}
			}
			catch(Exception ee) {
				cust_grp_desc = "Err";
			}
			if(pstmt !=null) pstmt.close();
			if(rs_pat!=null) rs_pat.close();
			
			sqlCustomer = "select short_desc cust_grp_desc from ar_cust_group where CUST_GROUP_CODE = ?  ";
			//sqlCustomer = "select short_desc cust_grp_desc,to_char(sysdate,'dd/mm/yyyy') start_date,to_char(sysdate+90,'dd/mm/yyyy') end_date from ar_cust_group where CUST_GROUP_CODE = ?  ";
			try
			{
			pstmt = con.prepareStatement(sqlCustomer);	
			pstmt.setString(1,cust_grp_code);
			
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{		
				cust_grp_desc  = rs_pat.getString("cust_grp_desc");
			}
			}
			catch(Exception ee) {
				cust_grp_desc = "Err";
			}
			if(pstmt !=null) pstmt.close();
			if(rs_pat!=null) rs_pat.close();
//			Commented by Karthikeyan for ML-MMOH-SCF-0398.1  		
/* 			if(reln_code.startsWith("SEL")==false)*/
			//{
			sqlCustomer = "select SHORT_DESC SHORT_DESC from MP_RELATIONSHIP_LANG_VW where RELATIONSHIP_CODE = ? and language_id='"+locale+"' and nvl(eff_status,'E') != 'D'";
		//	sqlCustomer = "select short_desc cust_grp_desc,to_char(sysdate,'dd/mm/yyyy') start_date,to_char(sysdate+90,'dd/mm/yyyy') end_date from ar_cust_group where CUST_GROUP_CODE = ?  ";
		//System.out.println("sql value "+sqlCustomer);
		try
			{
			pstmt = con.prepareStatement(sqlCustomer);	
			pstmt.setString(1,reln_code);
			
			rs_pat = pstmt.executeQuery();	
			while(rs_pat!=null && rs_pat.next())
			{
				
				reln_desc = rs_pat.getString("SHORT_DESC");
			}
			}
			catch(Exception ee) {
				reln_desc = "";
			}
			if(pstmt !=null) pstmt.close();
			if(rs_pat!=null) rs_pat.close();
			//} 
			System.out.println("retn data ######"+valid_from_dt+"^"+valid_to_dt+"^"+cust_desc+"^"+cust_grp_desc+"^"+start_date+"^"+end_date);
			
			out.println(valid_from_dt+"^"+valid_to_dt+"^"+cust_desc+"^"+cust_grp_desc+"^"+start_date+"^"+end_date+"^"+reln_desc);
			
		}
		else if("getBlngGrpParams".equals(func_mode)){
			String patient_id = request.getParameter("patient_id");
			String episode_type = request.getParameter("episode_type");
			String function_id = request.getParameter("function_id");
			String blnggrp = request.getParameter("blnggrp");
			String encounter_date = request.getParameter("encounter_date");
			String citizen_yn = request.getParameter("citizen_yn");
			String ext_blng_grp = request.getParameter("ext_blng_grp");

			String billing_group = request.getParameter("billingGroup");
			String selectClause = "";
			String whereClause = "";
			String finalQuery = "";
			
			patient_id = decodeParam(patient_id);
			episode_type = decodeParam(episode_type);
			function_id = decodeParam(function_id);
			blnggrp = decodeParam(blnggrp);
			encounter_date = decodeParam(encounter_date);
			citizen_yn = decodeParam(citizen_yn);
			ext_blng_grp = decodeParam(ext_blng_grp);
			billing_group = decodeParam(billing_group);
			
			String payerHdnVal = "";
			HashMap values = new HashMap();
			values.put("locale",locale);
			values.put("facility_id",facilityId);
			values.put("patient_id",patient_id);
			values.put("episode_type",episode_type);
			values.put("function_id",function_id);
			values.put("blnggrp",blnggrp);
			values.put("encounter_date",encounter_date);
			values.put("citizen_yn",citizen_yn);
			values.put("ext_blng_grp",ext_blng_grp);
			selectClause = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP");
									
			whereClause = " AND   blng_grp_id ='"+billing_group+"' ";
			
			finalQuery = selectClause+whereClause;
			pstmt = con.prepareStatement(finalQuery);
			rs_pat = pstmt.executeQuery();
			if(rs_pat !=null && rs_pat.next()){
				payerHdnVal = 	checkForNull(rs_pat.getString("blng_grp_id"))+"^~^"+
						checkForNull(rs_pat.getString("srt_desc"))+"^~^"+
						checkForNull(rs_pat.getString("dtl_desc"))+"^~^"+
						checkForNull(rs_pat.getString("cap_ref_src_yn"))+"^~^"+
						checkForNull(rs_pat.getString("ref_src_mn_mand_yn"))+"^~^"+
						checkForNull(rs_pat.getString("ref_src_sb_mand_yn"))+"^~^"+
						checkForNull(rs_pat.getString("currency_code"))+"^~^"+
						checkForNull(rs_pat.getString("currency_desc"))+"^~^"+
						checkForNull(rs_pat.getString("pr_payer_employer_id_mand_yn"))+"^~^"+
						checkForNull(rs_pat.getString("package_yn"))+"^~^"+
						checkForNull(rs_pat.getString("pkg_avail_yn"))+"^~^";
			}
			out.println(payerHdnVal);
		} 
		else if("approval_check_for_epi".equals(func_mode))	// Added for MMS-QF-SCF-0664
		{
			System.err.println("inside approval_check_for_epi:");
			String patient_id	= request.getParameter( "patient_id" );
			String episode_type	= request.getParameter( "episode_type" );
			String episode_id	= request.getParameter( "episode_id" );
			String visit_id	= request.getParameter( "visit_id" );
			String apprvl_yn ="";

			if(patient_id == null) patient_id  = "";
			if(episode_type == null) episode_type  = "";
			if(episode_id == null) episode_id  = "";
			if(visit_id == null) visit_id  = "";

			try
			{
				String cstSql ="{ ?=call   BL_CHARGE.bl_get_bill_approved_enc_vis (?,?,?,?,?)}";
				CallableStatement cstmt = con.prepareCall(cstSql);
										
				cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
				cstmt.setString(2, facilityId);
				cstmt.setString(3, patient_id);
				cstmt.setString(4, episode_id);
				cstmt.setString(5, visit_id);
				cstmt.setString(6, episode_type);
				cstmt.execute();
				apprvl_yn = cstmt.getString(1);
				if(cstmt!=null) cstmt.close();
				System.err.println("apprvl_yn:"+apprvl_yn);
			}
			catch(Exception ee)
			{
				System.err.println("Exception from approval_check_for_epi :"+ee);
			}
			
			out.println(""+apprvl_yn);
		}	
}catch (Exception e) {

	e.printStackTrace() ;
	System.err.println("Exception from PkgDefValidation :"+e);
}
finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%>
