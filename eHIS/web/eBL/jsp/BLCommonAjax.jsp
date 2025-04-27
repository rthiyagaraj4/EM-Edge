<%/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            		  Ram kumar S
 2           V210407                        AMS-CRF-0238,AMRI-CRF-0473,    
											GHL-CRF-0635				      Ram kumar S
 3			 V211212			25887		PMG2021-MMS-CRF-0004.1			  Nandhini M
 4			 V220908						TH-KW-CRF-0093 			         Namrata Charate
5	         V221107								TH-KW-CRF-0174  		Mohana Priya K
6				V221216				37915			TH-KW-CRF-0084.1			Mohanapriya
 7           V221227						PMG2022-COMN-CRF-0009   Namrata Charate
 8			V230125								TH-KW-CRF-0097				Pruthvi Raj
*/ %>
<%@page import="java.util.Hashtable"%>
<%@page import="java.io.*"%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="eBL.BLInsuranceImageBean"%>
<%@page import="eBL.BLInsuranceImage"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="javax.servlet.ServletInputStream"%>
<%@page import="javax.sql.rowset.serial.SerialBlob"%>
<%@page import= "javax.sql.rowset.serial.SerialException"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="eBL.Common.BlRepository"%>
<%
	request.setCharacterEncoding("UTF-8");
	//Added against GHL-CRF-0550
	HashMap newhasInsuranceImageValues =new HashMap();
	String bean_id								=	"";
	String bean_name							=	"";	
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	//Added against GHL-CRF-0550
	String functionMode = "";
	String setupAmendPrice="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	JSONObject obj=new JSONObject();
	try {
		con = ConnectionManager.getConnection();
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}

		if ("comparePatientId".equals(functionMode)) {
			String fromPatId = request.getParameter("fromPatId");
			String toPatId = request.getParameter("toPatId");
			boolean patIdStatus = BLHelper.comparePatientId(fromPatId,
					toPatId);
			out.println(patIdStatus);
		} else if ("SetupAmend".equals(functionMode)) {//V190318-Aravindh/Modified from 'if' to 'else if'
			String service_code = request.getParameter("service_code");
			String service = request.getParameter("criteria");
			String locale = request.getParameter("locale");
			System.err.println("functionMode-->"+functionMode+"service_code-->"+service_code+"service-->"+service+"locale-->"+locale);
			 try {
			pstmt=con.prepareStatement("select blcommonproc.bl_mat_linked_ser_yn(?,?,?) from dual");			
			
			pstmt.setString(1,service);
			pstmt.setString(2,service_code);
			pstmt.setString(3,locale);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				setupAmendPrice =rs.getString(1);
			}
			obj.put("setupAmendPrice",setupAmendPrice);
			System.out.println("setupAmendPrice" + setupAmendPrice);
			out.println(obj);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("setupAmendPrice" + e);
			} 
		}
		//added for MMS-CRF-0004.1 starts V211212
		else if ("SetupAmendCommon".equals(functionMode)) {//V190318-Aravindh/Modified from 'if' to 'else if'
			String service_code = request.getParameter("service_code");
			String service = request.getParameter("criteria");
			//String locale = request.getParameter("locale");
			System.err.println("82---->functionMode,common-->"+functionMode+"service_code-->"+service_code+"service-->"+service);
			 try {
			pstmt=con.prepareStatement("select BL_EBLCOMMON.is_bl_mm_item_serv_yn (?,?) from dual");		
			
			pstmt.setString(1,service);
			pstmt.setString(2,service_code);
			//pstmt.setString(3,locale);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				setupAmendPrice =rs.getString(1);
			}
			obj.put("setupAmendPrice",setupAmendPrice);
			System.out.println("setupAmendPrice" + setupAmendPrice);
			out.println(obj);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("setupAmendPrice" + e);
			} 
		}
		//added for MMS-CRF-0004.1 ends V211212
		
		else if("getPatientName".equals(functionMode)) {/* Added V190211-Aravindh/KDAH-CRF-0513.1 */
			String patientID = request.getParameter("patientID");
			String patientName = BLReportIdMapper.getPatientName(con, patientID);
			out.println(patientName);
		} else if("validatePatientIdWithDetails".equals(functionMode)) {/* Added V190211-Aravindh/KDAH-CRF-0513.1 */
			String patientID = request.getParameter("patientID");
			String patientName = request.getParameter("patientName");
			String patientDob = request.getParameter("patientDob");
			String patientGender = request.getParameter("patientGender");
			boolean flag = false;
			String flagPatName = "false", dbPatName = "";
			String sql = "SELECT PATIENT_ID, UPPER(PATIENT_NAME) PATIENT_NAME, TO_CHAR(DATE_OF_BIRTH,'dd/MM/yyyy') DATE_OF_BIRTH, UPPER(SEX) GENDER FROM MP_PATIENT "
					+ " WHERE PATIENT_ID = '"+patientID+"' ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("DATE_OF_BIRTH").equals(patientDob) && rs.getString("GENDER").equalsIgnoreCase(patientGender)) {
					flag = true;
				} 
				dbPatName = rs.getString("PATIENT_NAME");
				if(rs.getString("PATIENT_NAME").equalsIgnoreCase(patientName)) {
					flagPatName = "true";
				} else if(rs.getString("PATIENT_NAME").contains(patientName.toUpperCase()) || patientName.toUpperCase().contains(rs.getString("PATIENT_NAME"))) {
					flagPatName = "partial";
				} else {
					flagPatName = "false";
				}
			}
			
			if(flag == true) {
				if("true".equals(flagPatName)) {
					out.println("true");
				} else if("partial".equals(flagPatName)) {
					out.println("patientNamePartial");
				} else {
					out.println("patientNameMismatch:::"+dbPatName);
				}
			} else {
				out.println("false");				
			}
		} else if("validateLoginCashCounter".equals(functionMode)) {/* Added V190211-Aravindh/KDAH-CRF-0513.1 */
			String locale = request.getParameter("locale");
			String facilityId = request.getParameter("facilityId");
			String clientIpAddress = request.getParameter("clientIpAddress");
			String practoUser = request.getParameter("practoUser");
			
			String errorCode = "", errorText = "";
			
			boolean flag = false;
			CallableStatement cstmt = con.prepareCall("{ call BL_GENERATE_RECPT_FOR_VENDORS.validate_dflt_wp_cash_counter(?,?,?,?,?,?,?) }");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, locale);
			cstmt.setString(3, "R");
			cstmt.setString(4, "AD");
			cstmt.setString(5, clientIpAddress);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
			errorCode = cstmt.getString(6);
			errorText = cstmt.getString(7);
			
			if(null != errorCode && !"".equals(errorCode)) {
				Hashtable messageHashtable=new Hashtable();
				messageHashtable = MessageManager.getMessage(locale, errorCode, "BL");
				String msg= (String)messageHashtable.get("message");
				out.println(msg);
			} else if(null != errorText && !"".equals(errorText)) {
				out.println(errorText);
			} else {
				out.println("");
			}
		} else if("getOrderCatalogAmt".equals(functionMode)) {//Added V190401-Aravindh/GHL-CRF-0525
			String patientID = request.getParameter("patientId");
			String orderCtlgCode = request.getParameter("orderCatalogCode");
			String blSuccessYN = request.getParameter("bl_success") == null?"N":request.getParameter("bl_success");
			String clinicCode = request.getParameter("clinic_code") == null?"":request.getParameter("clinic_code");
			JSONObject orderCatlogDtlsJsonObj = BLReportIdMapper.getOrderCatalogDtls(con, patientID, orderCtlgCode, blSuccessYN, clinicCode, request);
			out.print(orderCatlogDtlsJsonObj);
		} else if("getBlngGrpCatByBlngGrp".equals(functionMode)) {//Added V190508-Aravindh/GHL-CRF-0553
			String blngGrpId = request.getParameter("blngGrpId");
			String blngGrpCatgCode = "", blngGrpCatgDesc = "", slmtIndicator = "";
			String blngCatgSql = "SELECT b.BLNG_GRP_CATG BLNG_GRP_CATG_CODE, c.SHORT_DESC BLNG_GRP_CATG_DESC, a.SETTLEMENT_IND FROM BL_BLNG_GRP_LANG_VW a, BL_BLNG_GRP_BY_CATG b, BL_BLNG_GRP_CATG_LANG_VW c " 
					+" WHERE b.BLNG_GRP_ID(+) = a.BLNG_GRP_ID AND c.BLNG_GRP_CATG(+) = b.BLNG_GRP_CATG AND a.BLNG_GRP_ID = '"+blngGrpId+"'";
			
			pstmt = con.prepareStatement(blngCatgSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				blngGrpCatgCode = rs.getString("BLNG_GRP_CATG_CODE") == null ? "" : rs.getString("BLNG_GRP_CATG_CODE");
				blngGrpCatgDesc = rs.getString("BLNG_GRP_CATG_DESC") == null ? "" : rs.getString("BLNG_GRP_CATG_DESC");
				slmtIndicator 	= rs.getString("SETTLEMENT_IND");
			}
			rs.close();
			pstmt.close();
			out.println(blngGrpCatgCode+":::"+blngGrpCatgDesc+":::"+slmtIndicator);
		} else if ("blngGrpChk".equals(functionMode)) {
			String blngGrp = request.getParameter("blngGrp");
			int cnt=0;
			String sql="SELECT count(*) cnt FROM bl_blng_grp WHERE blng_grp_id =  '"+blngGrp+"' AND settlement_ind = 'C'";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){ 
					cnt=rs.getInt("cnt");
				}
			}
			rs.close();
			pstmt.close();
			out.println(cnt);
		} else if("validatePolicyApproved".equals(functionMode)) {
			String facilityId 		= request.getParameter("facilityId");
			String payerGroupCode 	= request.getParameter("payerGroupCode");
			String payerCode 		= request.getParameter("payerCode");
			String policyTypeCode	= request.getParameter("policyTypeCode");
			
			String validatePolicySql = "SELECT GET_POLICY_APPROVAL_YN(?,?,?,?) policy_approval_yn FROM DUAL";
			String validatePolicy = "N";
			pstmt = con.prepareStatement(validatePolicySql);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, payerGroupCode);
			pstmt.setString(3, payerCode);
			pstmt.setString(4, policyTypeCode);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				validatePolicy = rs.getString("policy_approval_yn");
			}
			rs.close();
			pstmt.close();
			System.err.println("validatePolicyApproved->facilityId: "+facilityId+",payerGroupCode: "+payerGroupCode+",payerCode: "+payerCode+",policyTypeCode: "+policyTypeCode+". Out->validatePolicy: "+validatePolicy);
			if("Y".equals(validatePolicy)) {
				out.println("true");
			} else {
				out.println("false");
			}
		} else if ("ClaimAgreeReqYN".equals(functionMode)) { //Added V190704 MuthuN/NMC-JD-CRF-0002.1
			String payerGrpCode = request.getParameter("payerGrpCode");			
			String payerCode = request.getParameter("payerCode");			
			String policyTypecode = request.getParameter("policyTypeCode");			
			String facility_id = request.getParameter("facility_id");			
			String claimAgreeExist = "", sql = "";
			System.out.println("functionMode-->"+functionMode+"payerGrpCode-->"+payerGrpCode);
			try{
				if(!("".equals(policyTypecode) && "".equals(policyTypecode))) {
					sql = "select CLAIM_AGREED_EXISTS_YN claims_agmt_exists from bl_ins_policy_type_hdr" 
						+" where OPERATING_FACILITY_ID = '"+facility_id+"' and CUST_GROUP_CODE = '"+payerGrpCode+"'"
						+ " and CUST_CODE = '"+payerCode+"' and policy_type_Code = '"+policyTypecode+"'";
				} else {
					sql = "select claims_agmt_exists from ar_cust_group where cust_group_code='"+payerGrpCode+"'";
				}
				pstmt=con.prepareStatement(sql);			
								
				rs = pstmt.executeQuery();
				while (rs.next()) {
					claimAgreeExist =rs.getString("claims_agmt_exists");
				}
				System.out.println("claimAgreeExist" + claimAgreeExist);
				out.print(claimAgreeExist);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("claimAgreeExist: "+ e);
			} 
		} else if("capturePatBedCategory".equals(functionMode)) {//Added V190820-Aravindh/GHL-CRF-0523
			String blngGrpId  = request.getParameter("blngGrpId");
			String facilityId = request.getParameter("facilityId");
			
			String captPatBedCatgSql = "SELECT NVL(capture_pat_bed_category_yn,'N') capture_pat_bed_category_yn FROM bl_blng_grp WHERE blng_grp_id = '"+blngGrpId
					+ "' AND ((blcommon.is_function_applicable_yn('BL', 'BL_BLNG_GRP_FACILITY') = 'N') "
					+ " OR ((blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_FACILITY') = 'Y') "
					+ " AND (blng_grp_id IN (SELECT b.blng_grp_id FROM bl_blng_grp_facility b WHERE b.facility_id = '"+facilityId+"'))))";
			
			String capturePatBedCatgYN = "N";
			
			pstmt = con.prepareStatement(captPatBedCatgSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				capturePatBedCatgYN 	= rs.getString("capture_pat_bed_category_yn");
			}
			rs.close();
			pstmt.close();
			out.print("capturePatBedCatgYN:::"+capturePatBedCatgYN);
		} else if("validateBillingGroup".equals(functionMode)) {//Added V191218-Aravindh/GHL-CRF-0599 Starts
			String blngGrpId  = request.getParameter("blngGrpId");
			
			String validateBlngGrpSql = "SELECT COUNT(1) blng_grp_cnt FROM bl_blng_grp WHERE blng_grp_id = '"+blngGrpId+"' AND "
					+ " TRUNC (SYSDATE) BETWEEN TRUNC (valid_from) AND TRUNC (NVL (valid_to, SYSDATE))";
			
			int blngGrpCnt = 0;
			
			pstmt = con.prepareStatement(validateBlngGrpSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				blngGrpCnt = rs.getInt("blng_grp_cnt");
			}
			rs.close();
			pstmt.close();
			if(blngGrpCnt == 0) {
				String getValidFromDate = "SELECT TO_CHAR(VALID_FROM,'dd/MM/yyyy') VALID_FROM_DATE, TO_CHAR(SYSDATE,'dd/MM/yyyy') TODAY_DATE, TO_CHAR(VALID_TO,'dd/MM/yyyy') VALID_TO_DATE FROM BL_BLNG_GRP WHERE blng_grp_id = '"+blngGrpId+"'", validFromDate = "", todayDate = "", validToDate = "";
				
				pstmt = con.prepareStatement(getValidFromDate);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					validFromDate = rs.getString("VALID_FROM_DATE");
					todayDate = rs.getString("TODAY_DATE");
					validToDate = rs.getString("VALID_TO_DATE");
				}
				rs.close();
				pstmt.close();
				
				out.print("blngGrpValid:::N:::"+validFromDate+":::"+todayDate+":::"+validToDate);
			} else {
				out.print("blngGrpValid:::Y");
			}//Added V191218-Aravindh/GHL-CRF-0599 Ends
		}else if("validate_settlement".equals(functionMode)){
			//GHL-CRF-0550
			String billgrp_name="";
			String stmind="";
			String  billgrp_Name=request.getParameter("billgrp_name");
			pstmt = con.prepareStatement( "select SETTLEMENT_IND from BL_BLNG_GRP where BLNG_GRP_ID='"+billgrp_Name+"'" );
			rs = pstmt.executeQuery();			
			while(rs.next())
			{						
				stmind=  rs.getString(1);
			}				
			out.println(stmind);			
		}
		else if("validate_settlement1".equals(functionMode)){
			String billgrp_name="";
			String stmind="";
			String  billgrp_Name=request.getParameter("billgrp_name");
			pstmt = con.prepareStatement( "select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC='"+billgrp_Name+"'" );
					rs = pstmt.executeQuery();	
				while(rs.next())
					{
							 stmind=  rs.getString(1);
					}		
			out.println(stmind);
		}		
		//GHL-CRF-0550  PALANI NARAYANAN      - START		
		else if("validateEpisodeTypeData".equals(functionMode)){		
			int rowCount=0;
			String patient_id=request.getParameter("patient_id");
			String episode_type=request.getParameter("episode_type");
			String episode_id=request.getParameter("episode_id"); //Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
			
			//Commented by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020			
			Blob pat_ins_blob ;
			//int rowCount=0;
			BLInsuranceImage bimg;
			boolean flage=true;
			byte[] pat_ins_bytes;
		
			BLInsuranceImageBean blInsuranceImageBean 			= 	null;
			blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;	
			blInsuranceImageBean.clearBean();
			
			try
			{
				//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020 episode_type condition
				if (episode_type.equals("R")){
					pstmt = con.prepareStatement("SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and episode_type = ?  ") ;				
					pstmt.setString(1,patient_id);
					pstmt.setString(2,episode_type);	
				}else {
					pstmt = con.prepareStatement("SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and episode_type = ? and encounter_id = ? ");				
					pstmt.setString(1,patient_id);
					pstmt.setString(2,episode_type);
					pstmt.setString(3,episode_id);						
				}
				//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
				rs = pstmt.executeQuery();
				while(rs!=null && rs.next()) {						
					bimg = new BLInsuranceImage();
					bimg.setPayerGroupCode(checkNull(rs.getString(1)));
					bimg.setPayerCode(checkNull(rs.getString(2)));
					bimg.setPolicyCode(checkNull(rs.getString(3)));
					bimg.setPolicyNo(checkNull(rs.getString(4)));
					bimg.setStartDate(checkNull(rs.getString(5)));
					bimg.setEndDate(checkNull(rs.getString(6)));
						
					pat_ins_blob = rs.getBlob(7);
						
						
					Integer checkshareOrDB=rs.getInt(8);
					if(checkshareOrDB==null || checkshareOrDB==0){
							
						if(pat_ins_blob!=null)
						{
						InputStream in = pat_ins_blob.getBinaryStream();
						int len = (int)pat_ins_blob.length();
							
						byte[] by = new byte[(int) len];
						//by=	pat_ins_blob.getBytes(1, len);
							
						//by=pat_ins_blob.getBytes(1, len);
						in.read(by, 0, (int) len);
						bimg.setImage(by);
						}						
					} else if(checkshareOrDB==1){
						String filePath=rs.getString(9);
						if(filePath!=null && !filePath.equals("")){
							bimg.setImage(BLHelper.imagePathToBytes(filePath));
						}
					}
					bimg.setDbMod(true);						
					bimg.setDocType(checkNull(rs.getString(11)));
					bimg.setDocRemarks(checkNull(rs.getString(12)));
					bimg.setCreditAuthNo(checkNull(rs.getString(13)));
					bimg.setCreditAuthDate(checkNull(rs.getString(14)));
					bimg.setBillingGroup(checkNull(rs.getString(15)));
					bimg.setRowid(checkNull(rs.getString(16)));
						
					if(rowCount==0)
					newhasInsuranceImageValues.put(""+bimg.getIndex_cash(),bimg);
					else
						newhasInsuranceImageValues.put(""+bimg.getIndex_cash()+rowCount,bimg);
					rowCount++;							
		 }	
				blInsuranceImageBean.setInsuranceImageValues(newhasInsuranceImageValues);				
				out.println("true");
		}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}		
	} 
	//GHL-CRF-0550  PALANI NARAYANAN      - END		
	//GHL-CRF-0550  PALANI NARAYANAN  FOR 2TIER CHANGES     - START	
	else if("validateEpisodeTypeDataTwoTier".equals(functionMode)){			
		int rowCount=0;
		String patient_id=request.getParameter("patient_id");
		patient_id=(patient_id==null)?"":patient_id;
		String episode_type=request.getParameter("episode_type");
		episode_type=(episode_type==null)?"":episode_type;
		//String billing_group=request.getParameter("billing_group");
		//billing_group=(billing_group==null)?"":billing_group;
		String policy_number=request.getParameter("policy_number");
		policy_number=(policy_number==null)?"":policy_number;
				
		String encounter_id=request.getParameter("encounter_id");
		encounter_id=(encounter_id==null)?"":encounter_id;
				
		if(episode_type.equalsIgnoreCase("O"))
			episode_type="OP";
		else if(episode_type.equalsIgnoreCase("I"))
			episode_type="IP";
		else if(episode_type.equalsIgnoreCase("D"))
			episode_type="DC";
		else if(episode_type.equalsIgnoreCase("E"))
			episode_type="AE";
		else
			episode_type="MP";		
				
		Blob pat_ins_blob ;
		//int rowCount=0;
		BLInsuranceImage bimg;
		boolean flage=true;
		byte[] pat_ins_bytes;

		BLInsuranceImageBean blInsuranceImageBean 			= 	null;
		blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;	
		blInsuranceImageBean.clearBean();
			
		try
		{
		if(policy_number.equals("") || policy_number.equals("null")|| policy_number.equals(null))
		{
			pstmt = con.prepareStatement("SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and a.patient_class = ? and a.encounter_id = ?") ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,episode_type);
			//pstmt.setString(3,billing_group);
			pstmt.setString(3,encounter_id);
		}
		else
		{
			pstmt = con.prepareStatement("SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and a.patient_class = ? and a.encounter_id = ? and a.policy_number = ?") ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,episode_type);
			//pstmt.setString(3,billing_group);
			pstmt.setString(3,encounter_id);
			pstmt.setString(4,policy_number);
		}
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) { 
				bimg = new BLInsuranceImage();
				bimg.setPayerGroupCode(checkNull(rs.getString(1)));
				bimg.setPayerCode(checkNull(rs.getString(2)));
				bimg.setPolicyCode(checkNull(rs.getString(3)));
				bimg.setPolicyNo(checkNull(rs.getString(4)));
				bimg.setStartDate(checkNull(rs.getString(5)));
				bimg.setEndDate(checkNull(rs.getString(6)));
				//pat_ins_blob = res.getBlob(7);
				pat_ins_blob = rs.getBlob(7);
				//pat_ins_bytes =res.getBytes(7);
				Integer checkshareOrDB=rs.getInt(8);
				if(checkshareOrDB==null || checkshareOrDB==0){
					if(pat_ins_blob!=null)
					{
					InputStream in = pat_ins_blob.getBinaryStream();
					int len = (int)pat_ins_blob.length();
					byte[] by = new byte[(int) len];
					//by=	pat_ins_blob.getBytes(1, len);
					//by=pat_ins_blob.getBytes(1, len);
					in.read(by, 0, (int) len);
					bimg.setImage(by);
					//bimg.setBlobData(pat_ins_blob);
					//bimg.setBlobdata(pat_ins_blob);
					}
				} else if(checkshareOrDB==1){
					String filePath=rs.getString(9);
					if(filePath!=null && !filePath.equals("")){
						bimg.setImage(BLHelper.imagePathToBytes(filePath));
					}
				}
				bimg.setDbMod(true);
				//bimg.setBillingGroup(res.getString(10));
				//blng_grp_id=res.getString(10);
				bimg.setDocType(checkNull(rs.getString(11)));
				bimg.setDocRemarks(checkNull(rs.getString(12)));
				bimg.setCreditAuthNo(checkNull(rs.getString(13)));
				bimg.setCreditAuthDate(checkNull(rs.getString(14)));
				bimg.setBillingGroup(checkNull(rs.getString(15)));
				bimg.setRowid(checkNull(rs.getString(16)));
				
				if(rowCount==0)
				newhasInsuranceImageValues.put(""+bimg.getIndex_cash(),bimg);
				else
					newhasInsuranceImageValues.put(""+bimg.getIndex_cash()+rowCount,bimg);
				rowCount++;
		}	
			blInsuranceImageBean.setInsuranceImageValues(newhasInsuranceImageValues);
			//if(newhasInsuranceImageValues.size()!=0)
			out.println("true");
		}
		//GHL-CRF-0550  PALANI NARAYANAN  FOR 2TIER CHANGES     - START
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		}		
		else if("chk_Bl_Remarks".equals(functionMode)){   //Added for NMC-JD-CRF-010.1 24/8/2020 PALANINARAYANAN START
		String ret_remarks="";				
		try
		{				
			String mode=request.getParameter("mode");
			String payerGroup=request.getParameter("payerGroup");
			String payer=request.getParameter("payer");
			String policy=request.getParameter("policy");
			String sqlINC =	"select remarks from bl_ins_policy_type_hdr where CUST_GROUP_CODE=? and POLICY_TYPE_CODE=? and CUST_CODE=?";
			pstmt = con.prepareStatement(sqlINC);
			pstmt.setString(1,payerGroup);
			pstmt.setString(2,policy);
			pstmt.setString(3,payer);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ret_remarks	= rs.getString(1);
				ret_remarks	= (ret_remarks == null)?"":ret_remarks;
			}
			if(pstmt!=null)  pstmt.close();
			if(rs!=null)  rs.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		out.println(ret_remarks);
		}
		//Added for NMC-JD-CRF-010.1 24/8/2020 PALANINARAYANAN END
		//Added for MOHE-CRF-0050.2 04/11/2020 PALANINARAYANAN STARTS
		else if("validatsessionid".equals(functionMode)) {
			String p_facility_id = request.getParameter("p_facility_id");
			String p_report_id = request.getParameter("p_report_id");
			String p_cash_counter_code = request.getParameter("p_cash_counter_code");
			String p_cash_counter_user_id = request.getParameter("p_cash_counter_user_id");
			String p_login_date_time = request.getParameter("p_login_date_time");
			String p_logout_date_time = request.getParameter("p_logout_date_time");
			String login_user = request.getParameter("login_user");
			System.out.println("login_user==>>552"+login_user);
			String errorCode = "";
			String  errorText = "";
			boolean flag = false;
			String  session_id="";
			String  pmgdate="";
			CallableStatement cstmt = con.prepareCall("{ call BL_INSERT_SY_PROG_PARAM(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, p_facility_id);
			cstmt.setString(2, p_report_id);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.setString(5, p_cash_counter_code);
			cstmt.setString(6, p_cash_counter_user_id);
			cstmt.setString(7, p_login_date_time);
			cstmt.setString(8, p_logout_date_time);
			cstmt.setString(9, login_user);
			cstmt.execute();	
			session_id = cstmt.getString(3);
			pmgdate = cstmt.getString(4);
			out.println(session_id+"::"+pmgdate);
		}
		//Added for MOHE-CRF-0050.2 04/11/2020 PALANINARAYANAN Ends
		//Added for MOHE-CRF-0050.3 04/11/2020 PALANINARAYANAN STARTS
		//Modified for MOHE-CRF-0050.2 23/12/2020 PALANINARAYANAN STARTS
		else if("InsertItemPrice".equals(functionMode)) 
		{   String FromdAmendedDateNull ="";
			String TodAmendedDateNull ="";
			String p_facility_id = request.getParameter("p_facility_id");
			String p_report_id = request.getParameter("p_report_id");
			String login_user = request.getParameter("login_user");
			String itemprice = request.getParameter("itemprice");
			String item_type = request.getParameter("item_type");
			String itemstatus = request.getParameter("itemstatus");
			String trdnamchk = request.getParameter("trdnamchk");
			String FromItemCode = request.getParameter("FromItemCode");
			if ((FromItemCode == null) ||(FromItemCode.equals("")) ) 
			{
			FromItemCode="!!!!!!!!!!!!!!!!!!!!";
			}
			String ToItemCode = request.getParameter("ToItemCode");
			if ((ToItemCode == null) ||(ToItemCode.equals("")) ) 
			{
			ToItemCode="~~~~~~~~~~~~~~~~~~~~";
			}
			String frmamendedBy_code = request.getParameter("frmamendedBy_code");
			if ((frmamendedBy_code == null) ||(frmamendedBy_code.equals("")) ) 
			{
			frmamendedBy_code="!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
			}
			String toamendedBy_code = request.getParameter("toamendedBy_code");
			if ((toamendedBy_code == null) ||(toamendedBy_code.equals("")) ) 
			{
			toamendedBy_code="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
			}
			String FromdAmendedDate = request.getParameter("FromdAmendedDate");
			if ((FromdAmendedDate == null) ||(FromdAmendedDate.equals("")) ) 
			{
			FromdAmendedDateNull="01/01/1800";
			}
			
			String TodAmendedDate = request.getParameter("TodAmendedDate");
			
			if ((TodAmendedDate == null) ||(TodAmendedDate.equals("")) ) 
			{
			TodAmendedDateNull="31/12/4712";
			}
			
			String errorCode = "";
			String  errorText = "";
			boolean flag = false;
			String  session_id="";
			String  pmgdate="";
			try{
			if ((!FromdAmendedDate.equals("")) || (!TodAmendedDate.equals("") ))
			{	
			CallableStatement cstmt = con.prepareCall("{ call BL_INSERT_SY_PROG_PARAM(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))}");
			cstmt.setString(1, p_facility_id);
			cstmt.setString(2, p_report_id);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.setString(5, frmamendedBy_code);
			cstmt.setString(6, toamendedBy_code);
			cstmt.setString(7, FromItemCode);
			cstmt.setString(8, ToItemCode);
			cstmt.setString(9, FromdAmendedDate);
			cstmt.setString(10, TodAmendedDate);
			cstmt.execute();	
			session_id = cstmt.getString(3);
			pmgdate = cstmt.getString(4);
			System.out.println("pmgdate...."+pmgdate);
			out.println(session_id+"::"+pmgdate);
			}
			else
			{
			CallableStatement cstmt1 = con.prepareCall("{ call BL_INSERT_SY_PROG_PARAM(?,?,?,?,?,?,?,?,?,?)}");
			cstmt1.setString(1, p_facility_id);
			cstmt1.setString(2, p_report_id);
			cstmt1.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt1.setString(5, frmamendedBy_code);
			cstmt1.setString(6, toamendedBy_code);
			cstmt1.setString(7, FromItemCode);
			cstmt1.setString(8, ToItemCode);
			cstmt1.setString(9, FromdAmendedDateNull);
			cstmt1.setString(10, TodAmendedDateNull);
			cstmt1.execute();	
			session_id = cstmt1.getString(3);
			pmgdate = cstmt1.getString(4);
			System.out.println("pmgdate...."+pmgdate);
			out.println(session_id+"::"+pmgdate);
			}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}	
	//Modified for MOHE-CRF-0050.2 23/12/2020 PALANINARAYANAN Ends			
		}
		else if("validateaAuthwithpolicydetails".equals(functionMode)) 
		{  	//Added for MMS-DM-CRF-0100.1 PALANINARAYANAN STARTS
			String facility_id = request.getParameter("facility_id");
			String userid = request.getParameter("userid");
			String prespid = checkNull(request.getParameter("prespid"));
			String functionID = request.getParameter("functionID");
			String payer_group = request.getParameter("payer_group");
			String payer = request.getParameter("payer");
			String policy = request.getParameter("policy");
			String previlage = request.getParameter("previlage");
			String currentdate = request.getParameter("currentdate");
			String  p_privilege_val="";
			String  p_allowed_yn="";
			try{
			CallableStatement cstmt = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, userid);
			cstmt.setString(3, prespid);
			cstmt.setString(4, functionID);
			cstmt.setString(5, payer_group);
			cstmt.setString(6, payer);
			cstmt.setString(7, policy);
			cstmt.setString(8, previlage);
			cstmt.setString(9, currentdate);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.execute();	
			p_privilege_val = cstmt.getString(10);
			p_allowed_yn = cstmt.getString(11);
			System.out.println("password check"+p_privilege_val+"::"+p_allowed_yn);
			out.println(p_privilege_val+"::"+p_allowed_yn);
				//Added for MOHE-CRF-0050.2 04/11/2020 PALANINARAYANAN Ends
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}		
		}
		//Starts V210211
		else if(functionMode.equals("validateBillingGrp")){
			try{
				String ModuleId=request.getParameter("ModuleId");
				String FunctionId=request.getParameter("FunctionId");
				String patientId=request.getParameter("patientId");
				String facId=request.getParameter("facId");
				System.out.println("Module Id "+ModuleId+" Function Id "+FunctionId+" patient Id "+patientId+" Facility Id "+facId);
				String getAgeQuery ="";
				if((ModuleId.equals("OP") && FunctionId.equals("VISIT_REGISTRATION")) || (ModuleId.equals("IP") && FunctionId.equals("ADMISSION")) || (ModuleId.equals("AE") && FunctionId.equals("VISIT_REGISTRATION"))){
					getAgeQuery = "select blcore.bl_get_age('"+facId+"','"+patientId+"','R','','') xAge from dual";
				}
				System.err.println("getAgeQuery  "+getAgeQuery);
				pstmt = con.prepareStatement(getAgeQuery);
				rs = pstmt.executeQuery();
				String xAge ="";
			  	while(rs!= null && rs.next()){
			  		xAge = rs.getString("xAge") == null ? "" : rs.getString("xAge");
			  		System.err.println("xAge  "+xAge);
		        }
				out.println("~S~"+xAge);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("Exception while Validating Billing Group :"+e);
				out.println("~E~"+e);
			}
			finally {
			    if (rs != null) {
			        try {
			        	rs.close();
			        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
			    }
			    if (pstmt != null) {
			        try {
			        	pstmt.close();
			        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
			    }
			    if (con != null) {
			        try {
			        	con.close();
			        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
			    }
			}
		}
		//Ends V210211
		//V210407 Starts
	else if("genQrCode".equals(functionMode)) {
			System.err.println("Calling QRCodeGeneration");
			String patId=request.getParameter("patientid");
			String episode_id=request.getParameter("episode_id");
			String facility_id=request.getParameter("facility_id");
			String logInId=request.getParameter("logInId");
			String episodeType=request.getParameter("episodeType");
			String WsNo=request.getParameter("WsNo");
			String visitId=request.getParameter("visitId");
			String docNum=request.getParameter("docNum");
			String qrCode=request.getParameter("qrCode");
			String docTypeCode=request.getParameter("docTypeCode");
			HashMap<String,String> valuesToGen = new HashMap<String,String>();
			valuesToGen.put("patId", patId);
			valuesToGen.put("logInId", logInId);
			valuesToGen.put("episodeType", episodeType);
			valuesToGen.put("facility_id", facility_id);
			valuesToGen.put("episode_id", episode_id);
			valuesToGen.put("visitId", visitId);
			valuesToGen.put("WsNo", WsNo);
			valuesToGen.put("docNum", docNum);
			valuesToGen.put("qrCode", qrCode);
			valuesToGen.put("docTypeCode", docTypeCode);
			QRCodeGenerator.generateQRCodeImage(350, 350,valuesToGen);
			System.err.println("return from QRCodeGeneration Success");
			out.println("Success");
		}
		//V210407 Ends
		else if("validateParamPkgSubcDeposit".equals(functionMode)){   //Added for NMC-JD-CRF-0084 on 260121 starts	
		String pkg_def_deposit_req_yn="N";
		String pkgParm_interim_bill_auth_reqd="";
		String responseText ="";
		try
		{				
			String sysDate=request.getParameter("sysDate");
			String function_id=request.getParameter("function_id");
			String facility_id=request.getParameter("facility_id");
			String package_code=request.getParameter("Mul_pack_code");
			String sqlpkgbase =	"select deposit_req_yn from bl_package_base_price a  WHERE operating_facility_id = '"+facility_id+"' AND package_code = '"+package_code+"' AND eff_from_date = ( SELECT eff_from_date FROM bl_package_period b WHERE b.operating_facility_id = a.operating_facility_id AND b.package_code = a.package_code AND eff_from_date <= TRUNC (sysdate) AND NVL (eff_to_date, TRUNC (sysdate)) >= TRUNC (sysdate))";
			pstmt = con.prepareStatement(sqlpkgbase);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				pkg_def_deposit_req_yn= rs.getString(1);			
				pkg_def_deposit_req_yn	= (pkg_def_deposit_req_yn == null)?"N":pkg_def_deposit_req_yn;  //changed on 21-02-2021
				System.err.println("pkg_def_deposit_req_yn==>>bl_package_base_price==727==>>"+pkg_def_deposit_req_yn);
			}
		
			String sqlblparam =	"select pkg_deposit_sub_reqd_yn from bl_parameters WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt = con.prepareStatement(sqlblparam);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				pkgParm_interim_bill_auth_reqd= rs.getString(1);				
				pkgParm_interim_bill_auth_reqd	= (pkgParm_interim_bill_auth_reqd == null)?"N":pkgParm_interim_bill_auth_reqd; //changed on 21-02-2021
				System.err.println("pkgParm_interim_bill_auth_reqd==>>bl_parameters==738==>>"+pkgParm_interim_bill_auth_reqd);
			}
			if(pstmt!=null)  pstmt.close();
			if(rs!=null)  rs.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		if(pkg_def_deposit_req_yn.equals("N") && pkgParm_interim_bill_auth_reqd.equals("N") )
		{
			responseText="N";
			out.println(responseText);
		}
		else
		{
			responseText="Y";
			out.println(responseText);
		}		
		}
		else if("validateBlIntreamBillMenuDisableOrEnable".equals(functionMode)) 
		{//added for BL-MMS-DM-CRF-0100.1 on 010221 starts
			try{
				String p_facility_id = request.getParameter("facilityId");
				String  responseText="";
				String sql ="select  blcommon.interim_bill_auth_reqd_yn(?) from dual";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,p_facility_id);
				rs = pstmt.executeQuery();
			while(rs.next())
			{
				responseText = rs.getString(1);
			}
				out.println(responseText);
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
				//added against checkstyle
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
			}
		//added for BL-MMS-DM-CRF-0100.1 on 010221 ends
		}
		else if("PackageDeAssociate".equals(functionMode)) {/* Below code added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STRATS */
			
			String pkg_code=request.getParameter("pkg_code");
			String package_seq_no=request.getParameter("package_seq_no");
			String operating_facility_id=request.getParameter("operating_facility_id");
			String pat_id=request.getParameter("pat_id");
			String function_id=request.getParameter("function_id");
			String user=request.getParameter("user");
			String ws_no=request.getParameter("ws_no");
			System.err.println("pkg_code"+pkg_code);
			System.err.println("package_seq_no"+package_seq_no);
			System.err.println("operating_facility_id"+operating_facility_id);
			System.err.println("operating_facility_id"+operating_facility_id);
			System.err.println("pat_id"+pat_id);
			
			String episode_id= "";
			String visit_id= "";
			String episode_type= "";
			
			String sql =	"select b.encounter_id episode_id,b.visit_id,b.episode_type  from bl_package_encounter_dtls b "+
							"where b.operating_facility_id = '"+operating_facility_id+"' and b.patient_id = '"+pat_id+"' and b.package_code = '"+pkg_code+"' and b.package_seq_no = '"+package_seq_no+"'";
					
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				episode_id= rs.getString(1);
				visit_id= rs.getString(2);
				episode_type= rs.getString(3);
			
			}
			
			rs.close();
			pstmt.close();
				
			String errorCode = "", errorText = "", errorMsg = "";
			
			CallableStatement cstmt = con.prepareCall("{ call blpackage.deassociateencounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt.setString(1, operating_facility_id);
			cstmt.setString(2, function_id);
			cstmt.setString(3, pat_id);
			cstmt.setString(4, episode_id);
			cstmt.setString(5, episode_type);
			cstmt.setString(6, episode_id);
			cstmt.setString(7, visit_id);
			cstmt.setString(8, pkg_code);
			cstmt.setString(9, package_seq_no);
			cstmt.setString(10, user); 
			cstmt.setString(11, ws_no);
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			cstmt.execute();
			errorCode = cstmt.getString(12);
			errorText = cstmt.getString(13);
			errorMsg = cstmt.getString(14);
			
			if(null != errorCode && !"".equals(errorCode)) {
				System.err.println("msg::::error code:::"+errorCode);
				out.println(errorCode);
			} else if(null != errorText && !"".equals(errorText)) {
				System.out.println("errorText :::: "+errorText);
				out.println(errorText);
			} 
			 else if(null != errorMsg && !"".equals(errorMsg)) {
				 System.out.println("errorMsg :::: "+errorMsg);
					out.println(errorMsg);
				} 
			else {
				con.commit();
				out.println("");
			}
		}
		
		else if("CommonAuthforMaintainTreatment".equals(functionMode)) 
		{//added for PMG2021-COMN-CRF-00076 starts
			try{
				String function_id = request.getParameter("function_id");
				String privlege_code = request.getParameter("privlege_code");
				String userid = request.getParameter("user");
				String facility_id = request.getParameter("facility_id");
				System.err.println(function_id);
				System.err.println(privlege_code);
				System.err.println(userid);
				System.err.println(facility_id);
				String  responseText="";
				String sql ="SELECT NVL(package_cancel,'N') FROM bl_user WHERE upper(BL_USER_ID) = '"+userid+"' AND operating_facility_id ='"+facility_id+"' AND status IS NULL";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
						{
					responseText =rs.getString(1);
						}
				
				System.err.println("responseText====>>from BLCommonAjax.jsp :: "+responseText);
				
				out.println(responseText);
					}

						catch(Exception e)
						{
							System.err.println(e);
						}
						//added for PMG2021-COMN-CRF-00076on 210624 ends
		}
		
		
		else if("PkgCancelforMaintainTreatment".equals(functionMode)) 
		{//added for PMG2021-COMN-CRF-00076 starts
			try{
				String function_id = request.getParameter("function_id");
				
				String userid = request.getParameter("user");
				String facility_id = request.getParameter("facility_id");
				String patientid = request.getParameter("patientid");
				String package_code = request.getParameter("package_code");
				String package_seq_no = request.getParameter("package_seq_no");
				String cancel_code = request.getParameter("cancel_code");
				String local = request.getParameter("local");
				String ws_no = request.getParameter("ws_no");
			
				System.err.println(function_id);
				System.err.println(facility_id);
				System.err.println(patientid);
				System.err.println(package_code);
				System.err.println(package_seq_no);
				System.err.println(cancel_code);
				System.err.println(userid);
				System.err.println(local);
				System.err.println(ws_no);
				
				String  responseText="";
				String errorCode = "", errorText = "", errorMsg = "";
				
			
				
				CallableStatement cstmt = con.prepareCall("{ call cancel_package(?,?,?,?,?,?,?,?,?,?,?) }");
			
				cstmt.setString(1, facility_id);
				cstmt.setString(2, patientid);
				cstmt.setString(3,package_code);
				cstmt.setString(4, package_seq_no);
				cstmt.setString(5, cancel_code);
				cstmt.setString(6, userid);
				cstmt.setString(7, ws_no);
				cstmt.setString(8, local);
				cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
				cstmt.execute();
				
				errorCode = cstmt.getString(9);
				errorText = cstmt.getString(10);
				errorMsg = cstmt.getString(11);
				
				
				if(null != errorCode && !"".equals(errorCode)) {
					System.err.println("msg::::error code:::"+errorCode);
					out.println(errorCode);
				} else if(null != errorText && !"".equals(errorText)) {
					System.out.println("errorText :::: "+errorText);
					out.println(errorText);
				} 
				 else if(null != errorMsg && !"".equals(errorMsg)) {
					 System.out.println("errorMsg :::: "+errorMsg);
						out.println(errorMsg);
					} 
				else {
					con.commit();
					out.println("");
				}				
			}
			catch(Exception e)
			{
				System.err.println(e);
			}
		}
		else if("DeleteServiceDetailMTP".equals(functionMode)) 
		{//added for PMG2021-COMN-CRF-00076 starts
			try{
					String function_id = request.getParameter("function_id");					
					String userid = request.getParameter("user");
					String facility_id = request.getParameter("facility_id");
					String patientid = request.getParameter("patientid");
					String package_code = request.getParameter("package_code");
					String package_seq_no = request.getParameter("package_seq_no");
					String cancel_code = request.getParameter("cancel_code");
					String local = request.getParameter("local");
					String ws_no = request.getParameter("ws_no");
				
					System.err.println(function_id);
					System.err.println(facility_id);
					System.err.println(patientid);
					System.err.println(package_code);
					System.err.println(package_seq_no);
					System.err.println(cancel_code);
					System.err.println(userid);
					System.err.println(local);
					System.err.println(ws_no);
					
					String  responseText="";
					String errorCode = "", errorText = "", errorMsg = "";			
				
					CallableStatement cstmt = con.prepareCall("{ call cancel_package(?,?,?,?,?,?,?,?,?,?,?) }");
				
					cstmt.setString(1, facility_id);
					cstmt.setString(2, patientid);
					cstmt.setString(3,package_code);
					cstmt.setString(4, package_seq_no);
					cstmt.setString(5, cancel_code);
					cstmt.setString(6, userid);
					cstmt.setString(7, ws_no);
					cstmt.setString(8, local);
					cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
					cstmt.execute();
					
					errorCode = cstmt.getString(9);
					errorText = cstmt.getString(10);
					errorMsg = cstmt.getString(11);					
					
					if(null != errorCode && !"".equals(errorCode)) {
						System.err.println("msg::::error code:::"+errorCode);
						out.println(errorCode);
					} else if(null != errorText && !"".equals(errorText)) {
						System.out.println("errorText :::: "+errorText);
						out.println(errorText);
					} else if(null != errorMsg && !"".equals(errorMsg)) {
							System.out.println("errorMsg :::: "+errorMsg);
							out.println(errorMsg);
					} 
					else {
						con.commit();
						out.println("");
					}				
			}
			catch(Exception e)
			{
				System.err.println(e);
				e.printStackTrace();
			}
		}
		else if("patientCategory".equals(functionMode)){   
			String patientCategory="";				
			try
			{				
				String billing_class=request.getParameter("billing_class");
				String category =	"select NVL(PATIENT_CATEGORY_CODE,'') from BL_BLNG_CLASS where BLNG_CLASS_CODE=?";
				pstmt = con.prepareStatement(category);
				pstmt.setString(1,billing_class);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					patientCategory	= rs.getString(1);
				}
				System.err.println("patientCategory====>"+patientCategory);
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(patientCategory);
		}
		else if("updBillPrintFlag".equals(functionMode)){
			System.err.println("from updBillPrintFlag :" + functionMode);
			String error_flag = "N";
			String strbilldoctypecode = request.getParameter("docTypeCode");
			String strbilldocnum = request.getParameter("docNum");
			String facility_id = request.getParameter("facility_id");
			try{
				String upd_stmt1="update BL_BILL_HDR set bill_print_flag = 'N', bill_print_flag_det = 'N' where DOC_TYPE_CODE='"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"' AND OPERATING_FACILITY_ID='"+facility_id+"' ";	
				System.err.println("from updBillPrintFlag :" + upd_stmt1);				
				pstmt = con.prepareStatement(upd_stmt1);
				int res_upd1 = pstmt.executeUpdate();

				if (res_upd1 != 0) {
					error_flag = "N";								
				}
				else{
					error_flag = "Y";								
				}
			}
			catch(Exception e)
			{
				error_flag = "Y";
				e.printStackTrace();
			}
			System.err.println("from updBillPrintFlag :" + error_flag);
			if("N".equals(error_flag)){
				con.commit();
			}
			out.println(error_flag);
		}
		//V220908
		else if("getMCNMandYN".equals(functionMode)){
			
			String cust_grp_code = request.getParameter("custGrpCode");
			
			String qry_MCNMandYN = "select NVL(MCN_NUMBER_MANDATE_FLAG,'N') MCN_NUMBER_MANDATE_FLAG from ar_cust_group where cust_group_code = '"+cust_grp_code+"'";
			
			String MCNMandYN = "N";
			
			pstmt = con.prepareStatement(qry_MCNMandYN);
			rs = pstmt.executeQuery();
			
			if(rs != null){
				while(rs.next()) {
					MCNMandYN 	= rs.getString("MCN_NUMBER_MANDATE_FLAG");
				}
			}
			rs.close();
			pstmt.close();
			out.println(MCNMandYN);
		}
		//V220908		
		else if("SetSelApprvdDrugsList".equals(functionMode)){
			String sel_drug_code = request.getParameter("sel_drug_code");
			String sel_drug_desc = request.getParameter("sel_drug_desc");
			String apprYN = request.getParameter("apprYN");
			String IPYN = request.getParameter("IPYN");
			String DCYN = request.getParameter("DCYN");
			String OPYN = request.getParameter("OPYN");
			String EMYN = request.getParameter("EMYN");
			String ALLYN = request.getParameter("ALLYN");
			String hashVal = sel_drug_code+"~"+sel_drug_desc+"~"+apprYN+"~"+IPYN+"~"+DCYN+"~"+OPYN+"~"+EMYN+"~"+ALLYN;
			HashMap sel_drug_list = (HashMap) session.getAttribute("sel_drug_list");
			if(sel_drug_list == null){
				sel_drug_list = new HashMap();
			}
			sel_drug_list.put(sel_drug_code,hashVal);
			System.err.println("hashVal in ajax:"+hashVal);
			session.setAttribute("sel_drug_list",sel_drug_list);
			out.println("Y");			
		}
		else if("ChkForRecordAvail".equals(functionMode)){
			String facilityID = request.getParameter("facilityID");
			String billingGrpID = request.getParameter("billingGrpID");
			String payerGroupCode = request.getParameter("payerGroupCode");
			String payerCode = request.getParameter("payerCode");
			String policyTypeCode = request.getParameter("policyTypeCode");
			
			String qry = "select 'Y' rec_exists from BL_PH_DRUG_AGREEMENT where operating_facility_id = '"+facilityID+"' AND BLNG_GRP_ID = '"+billingGrpID+"' AND CUST_GROUP_CODE = '"+payerGroupCode+"' AND CUST_CODE = '"+payerCode+"' AND POLICY_TYPE_CODE = '"+policyTypeCode+"'" +
			" AND (OP_YN = 'Y' OR EM_YN = 'Y' OR IP_YN = 'Y' OR DC_YN = 'Y') group by operating_facility_id, BLNG_GRP_ID, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE";
			
			String recExists = "N";
			
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();
			
			if(rs != null){
				while(rs.next()) {
					recExists 	= rs.getString("rec_exists");
				}
			} else {
				recExists = "N";
			}
			rs.close();
			pstmt.close();
			out.println(recExists);
		}
		else if("PatientSign".equals(functionMode)){
			System.err.println("PatientSign");
			String docTypeCode = request.getParameter("docTypeCode");
			String docNum = request.getParameter("docNum");
			String visitId = request.getParameter("visitId");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String patient_Id = request.getParameter("patientId");
			
			String image = request.getParameter("image");
			System.err.println("image "+image);
			String byteString=(image.split(",")[1]);
			System.err.println("byteString "+byteString);
			byte[] imageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(byteString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			System.err.println(imageByte.length);
			String mpi_id = request.getParameter("mpi_id");
			
			java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
			String ws_no		= (String) p.getProperty( "client_ip_address" );
			String login_user = (String) p.getProperty("login_user");
			HttpSession httpSession = request.getSession(false);	
			String facility_id = (String)httpSession.getValue("facility_id");
			System.err.println("1315,--->"+ws_no);
			System.err.println("login_user "+login_user);
			System.err.println("facility_id "+facility_id);
			
			CallableStatement cstmt = con.prepareCall("{ call IBAEHIS.bl_esign_save(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?) }");
			
				cstmt.setString(1, facility_id);
				cstmt.setString(2, patient_Id);
				cstmt.setString(3,episodeType);
				cstmt.setString(4, episodeId);
				cstmt.setString(5, visitId);
				cstmt.setString(6, docTypeCode);
				cstmt.setString(7, docNum);
				cstmt.setString(8, mpi_id);
				cstmt.setBinaryStream(9, bis,imageByte.length);
				cstmt.setString(10, login_user);
				cstmt.setString(11, ws_no);
				cstmt.setString(12, facility_id);
				cstmt.setString(13, login_user);
				cstmt.setString(14, ws_no);
				cstmt.setString(15, facility_id);
				cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
				cstmt.execute();
				
				String errorCode = cstmt.getString(16);
				String errorText = cstmt.getString(17);
				String errorMsg = cstmt.getString(18);
				
				if(null != errorCode && !"".equals(errorCode)) {
					System.err.println("msg::error code:::"+errorCode);
					out.println(errorCode);
				} else if(null != errorText && !"".equals(errorText)) {
					System.out.println("errorText :: "+errorText);
					out.println(errorText);
				} 
				  if(null != errorMsg && !"".equals(errorMsg)) {
					 System.out.println("errorMsg :: "+errorMsg);
						out.println(errorMsg);
					} 
				else {
					con.commit();
					System.out.println("commit in e-sign :: ");
					out.println("");
				}		
		}
		else if("mpiInsData".equals(functionMode)){
			HttpSession httpSession = request.getSession(false);	
			String facility = (String)httpSession.getValue("facility_id");
			System.err.println("mpiInsData retrival");
			String docTypeCode = request.getParameter("billdoctypecode");
			String docNum = request.getParameter("billdocnum");
			System.err.println("docTypeCode"+docTypeCode);
			System.err.println("docNum"+docNum);
			Statement stmt = null;
			ResultSet rs1 =null;
			String mpi_id="";
			int insBillCount=0;
			String qrympiid="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+facility+"' and DOC_TYPE_CODE='"+docTypeCode+"' and DOC_NUM='"+docNum+"'";
			stmt = con.createStatement();
			rs1 = stmt.executeQuery(qrympiid) ;
			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					mpi_id = rs1.getString(1);
				}
			}
			System.err.println("mpi_id retrival "+mpi_id);
			if(stmt!=null) stmt.close();
			if(rs1!=null) rs1.close();			
			
			String qry = "select count(*) from bl_bill_hdr a , bl_blng_grp b where a.operating_facility_id = '"+facility+"' and mpi_id = '"+mpi_id+"' and a.blng_grp_id =b.blng_grp_id and a.bill_amt >0 and a.cust_code is not null and b.SETTLEMENT_IND = 'X'";
			stmt = con.createStatement();
			rs1 = stmt.executeQuery(qry) ;
			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					insBillCount = rs1.getInt(1);
				}
			} else {
				insBillCount = 0;
			}
			System.err.println("insBillCount retrival "+insBillCount);
			if(stmt!=null) stmt.close();
			if(rs1!=null) rs1.close();
			
			out.println(mpi_id+":::"+insBillCount);
		}
		else if("settlement_ind".equals(functionMode)){
			HttpSession httpSession = request.getSession(false);	
			String facility = (String)httpSession.getValue("facility_id");
			System.err.println("setl_ind ");
			String episodeId = request.getParameter("episodeId");
			Statement stmt = null;
			ResultSet rs1 =null;
			String setl_ind="";
			String qrysttlmtind="select settlement_ind from bl_episode_fin_dtls where operating_facility_id = '"+facility+"' and episode_id ='"+episodeId+"'";
			stmt = con.createStatement();
			rs1 = stmt.executeQuery(qrysttlmtind) ;
			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					setl_ind = rs1.getString(1);
				}
			}
			System.err.println("setl_ind retrival "+setl_ind);
			if(stmt!=null) stmt.close();
			if(rs1!=null) rs1.close();			
			
			out.println(setl_ind);
		}//V221216
		else if("getBLDischAuthWindowYN".equals(functionMode)){
			
			java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user = (String) p.getProperty("login_user");
			String facility_id = request.getParameter("facility_id");
			String doc_num = request.getParameter("docNum");
			String pat_outs_bill = request.getParameter("pat_outs_bill");
			
			String p_privilege_val = ""; 
			String p_window = ""; 
			
			try{
				
			CallableStatement cstmt = con.prepareCall("{ call BL_DISCHARGE_CLEARANCE.BL_VALIDATE_DISC_CLEARANCE(?,?,?,?,?,?) }");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, doc_num);
			cstmt.setString(3, pat_outs_bill);
			cstmt.setString(4, login_user);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
			p_privilege_val = cstmt.getString(5);
			p_window = cstmt.getString(6);
			out.println(p_privilege_val+":::"+p_window); 
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}		
		} //V221227
		else if("getBLDischUserAuthYN".equals(functionMode)){
		
			String facility_id = request.getParameter("facility_id"); 
			String userID = request.getParameter("userID");
			String pinNum = request.getParameter("pinNum");
			String reasonCode = request.getParameter("reasonCode");
			String remark = request.getParameter("remark");
			String window_name = request.getParameter("window_name");
			String errorCode = "";
				
			try{
			CallableStatement cstmt = con.prepareCall("{ call BL_DISCHARGE_CLEARANCE.BL_DISC_CLEAR_ACCEPT(?,?,?,?,?,?,?)}");
			
			cstmt.setString(1, facility_id);
			cstmt.setString(2, userID);
			cstmt.setString(3, pinNum);
			cstmt.setString(4, reasonCode);
			cstmt.setString(5, remark);
			cstmt.setString(6, window_name);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			
			cstmt.execute();	
			
			errorCode = cstmt.getString(7);
			out.println(errorCode);
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			} 
		} //V221227
	 	else if("getBLDischCancelClearAuthWindowYN".equals(functionMode)){
				
				java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
				String login_user = (String) p.getProperty("login_user");
				String facility_id = request.getParameter("facility_id");
				String patientId = request.getParameter("patientId");
				String episode_id = request.getParameter("episode_id");
				String episode_type = request.getParameter("episode_type");
				
				String p_privilege_val = ""; 
				String error_code = ""; 
				
				try{
					
					CallableStatement cstmt = con.prepareCall("{ call BL_CANCEL_DISCHARGE_CLEARANCE.BL_VAL_CANCEL_DISC_CLEARANCE(?,?,?,?,?,?,?) }");
					cstmt.setString(1, facility_id);
					cstmt.setString(2, login_user);
					cstmt.setString(3, episode_type);
					cstmt.setString(4, episode_id);
					cstmt.setString(5, patientId);
					
					cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
					
					cstmt.execute();
					
					p_privilege_val = checkNull(cstmt.getString(6));
					error_code = checkNull(cstmt.getString(7));
		
					System.err.println("password check "+p_privilege_val); 
					System.err.println("error_code "+error_code);
					if("".equals(error_code))
						out.println(p_privilege_val); 
					else
						out.println(error_code);  
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}		
			} //V221227
		 	else if("getBLDischCancelClearUserAuthYN".equals(functionMode)){
				
				String facility_id = request.getParameter("facility_id"); 
				String userID = request.getParameter("userID");
				String pinNum = request.getParameter("pinNum");
				String reasonCode = request.getParameter("reasonCode");
				String remark = request.getParameter("remark");
				String errorCode = "";
					
				try{
				CallableStatement cstmt = con.prepareCall("{ call BL_CANCEL_DISCHARGE_CLEARANCE.BL_CANCEL_DISC_CLEAR_ACCEPT(?,?,?,?,?,?)}");
				
				cstmt.setString(1, facility_id);
				cstmt.setString(2, userID);
				cstmt.setString(3, pinNum);
				cstmt.setString(4, reasonCode);
				cstmt.setString(5, remark);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				
				cstmt.execute();	
				
				errorCode = cstmt.getString(6);
				out.println(errorCode);
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				} 
			} //V221227
			else if("ReprintReport".equals(functionMode)){
				String facility_id = (String)session.getAttribute("facility_id"); 
				String reportId = request.getParameter("p_report_id");
				String param1 = request.getParameter("param1");
				String param2 = request.getParameter("param2");
				String param3 = request.getParameter("param3");
				String param4 = request.getParameter("param4");
				String param5 = request.getParameter("param5");
				String param6 = request.getParameter("param6");
				String param7 = request.getParameter("param7");
				String param8 = request.getParameter("param8");
				String param9 = request.getParameter("param9");
				String param10 = request.getParameter("param10");
				String param11 = request.getParameter("param11");
				String param12 = request.getParameter("param12");
				String param13 = request.getParameter("param13");
				String param14 = request.getParameter("param14");
				String param15 = request.getParameter("param15");
				String param16 = request.getParameter("param16");
				String param17 = request.getParameter("param17");
				String param18 = request.getParameter("param18");
				String param19 = request.getParameter("param19");
				String param20 = request.getParameter("param20");
				String param21 = request.getParameter("param21");
				String param22 = request.getParameter("param22");			
				String param23 = request.getParameter("param23");
				String param24 = request.getParameter("param24");
				String param25 = request.getParameter("param25");
				String param26 = request.getParameter("param26");
				String param27 = request.getParameter("param27");
				String param28 = request.getParameter("param28");
				String param29 = request.getParameter("param29");
				String param30 = request.getParameter("param30");
				
				int session_id = 0;
				String pgm_date = "";
				String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
				CallableStatement cstmt = con.prepareCall(insertSql);
				cstmt.setString(1, facility_id);
				cstmt.setString(2, reportId);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.VARCHAR);
				cstmt.setString(5, param1);
				cstmt.setString(6, param2);
				cstmt.setString(7, param3);
				cstmt.setString(8, param4);
				cstmt.setString(9, param5);
				cstmt.setString(10, param6);
				cstmt.setString(11, param7);
				cstmt.setString(12, param8);
				cstmt.setString(13, param9);
				cstmt.setString(14, param10);
				cstmt.setString(15, param11);
				cstmt.setString(16, param12);
				cstmt.setString(17, param13);
				cstmt.setString(18, param14);
				cstmt.setString(19, param15);
				cstmt.setString(20, param16);
				cstmt.setString(21, param17);
				cstmt.setString(22, param18);
				cstmt.setString(23, param19);
				cstmt.setString(24, param20);
				cstmt.setString(25, param21);
				cstmt.setString(26, param22);
				cstmt.setString(27, param23);
				cstmt.setString(28, param24);
				cstmt.setString(29, param25);
				cstmt.setString(30, param26);
				cstmt.setString(31, param27);
				cstmt.setString(32, param28);
				cstmt.setString(33, param29);
				cstmt.setString(34, param30);
				cstmt.execute();
				
				session_id = cstmt.getInt(3);
				pgm_date = cstmt.getString(4);
				String a = session_id+":::"+pgm_date;
				System.err.println("session_id->"+session_id);
				System.err.println("pgm_date->"+pgm_date);
				cstmt = null;
				con.commit();
				out.println(a.trim());
			} //V221227
			else if("ReprintReportValue".equals(functionMode)){
				
				java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
				String ws_no		= (String) p.getProperty( "client_ip_address" );
				String facility_id = (String)session.getAttribute("facility_id"); 
				String module_id = request.getParameter("module_id"); 
				String report_id = request.getParameter("p_report_id");
				String reportServer	= (String) session.getValue( "report_server" ) ;
				String userid		= (String) session.getValue( "report_connect_string" ) ;
				String dest_locn_type = "";
				String dest_locn_code = "";
				String report_opt = request.getParameter("reportOption");
				String report = "", server = "",copies = "", report_mode = "", queue_name = "", report_tool = "", status = "" ,message = "",app_server_ip = "", rep_server_key = ""; 
				CallableStatement cstmt = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
				
				cstmt.setString( 1,	module_id ) ;
				cstmt.setString( 2,	report_id ) ;
				cstmt.setString( 3,	dest_locn_type ) ;
				cstmt.setString( 4,	dest_locn_code ) ;
				cstmt.setString( 5,	facility_id ) ;
				cstmt.setString( 6,	ws_no ) ;
				cstmt.setString( 7,	report_opt ) ;
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 10, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 11, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 12, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 13, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 14, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 15, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 16, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 17, Types.VARCHAR ) ;
				cstmt.execute() ;
				report	= cstmt.getString( 8 ) ;
				server	= cstmt.getString( 9 ) ;
				copies	= cstmt.getString( 10 ) ;	
				if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
				report_mode	= cstmt.getString( 11 ) ;
				queue_name	= cstmt.getString( 12 ) ;
				report_tool	= cstmt.getString( 13 ) ;
				status	= cstmt.getString( 14 ) ;
				message	= cstmt.getString( 15 ) ;
				
				if (message==null) message="";
				app_server_ip = cstmt.getString( 16 ) ;
				
				rep_server_key= cstmt.getString( 17 ) ;
				reportServer = "http://" + app_server_ip + reportServer ;
				
				String a = report+":::"+server+":::"+copies+":::"+app_server_ip+":::"+rep_server_key+":::"+reportServer+":::"+userid+":::"+message;
				cstmt = null;
				con.commit();
				out.println(a.trim());
				
			} //V221227 ends
			//V230125 starts
			else if("ReprintConsentForm".equals(functionMode)){
				String facility_id = (String)session.getAttribute("facility_id"); 
				String reportId = request.getParameter("p_report_id");
				String param1 = request.getParameter("param1");
				String param2 = request.getParameter("param2");
				String param3 = request.getParameter("param3");
				String param4 = request.getParameter("param4");
				String param5 = request.getParameter("param5");
				String param6 = request.getParameter("param6");
				String param7 = request.getParameter("param7");
				String param8 = request.getParameter("param8");
				String param9 = request.getParameter("param9");
				String param10 = request.getParameter("param10");
				String param11 = request.getParameter("param11");
				String param12 = request.getParameter("param12");
				String param13 = request.getParameter("param13");
				String param14 = request.getParameter("param14");
				String param15 = request.getParameter("param15");
				String param16 = request.getParameter("param16");
				String param17 = request.getParameter("param17");
				String param18 = request.getParameter("param18");
				String param19 = request.getParameter("param19");
				String param20 = request.getParameter("param20");
				String param21 = request.getParameter("param21");
				String param22 = request.getParameter("param22");			
				String param23 = request.getParameter("param23");
				String param24 = request.getParameter("param24");
				String param25 = request.getParameter("param25");
				String param26 = request.getParameter("param26");
				String param27 = request.getParameter("param27");
				String param28 = request.getParameter("param28");
				String param29 = request.getParameter("param29");
				String param30 = request.getParameter("param30");
				
				int session_id = 0;
				String pgm_date = "";
				String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
				CallableStatement cstmt = con.prepareCall(insertSql);
				cstmt.setString(1, facility_id);
				cstmt.setString(2, reportId);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.VARCHAR);
				cstmt.setString(5, param1);
				cstmt.setString(6, param2);
				cstmt.setString(7, param3);
				cstmt.setString(8, param4);
				cstmt.setString(9, param5);
				cstmt.setString(10, param6);
				cstmt.setString(11, param7);
				cstmt.setString(12, param8);
				cstmt.setString(13, param9);
				cstmt.setString(14, param10);
				cstmt.setString(15, param11);
				cstmt.setString(16, param12);
				cstmt.setString(17, param13);
				cstmt.setString(18, param14);
				cstmt.setString(19, param15);
				cstmt.setString(20, param16);
				cstmt.setString(21, param17);
				cstmt.setString(22, param18);
				cstmt.setString(23, param19);
				cstmt.setString(24, param20);
				cstmt.setString(25, param21);
				cstmt.setString(26, param22);
				cstmt.setString(27, param23);
				cstmt.setString(28, param24);
				cstmt.setString(29, param25);
				cstmt.setString(30, param26);
				cstmt.setString(31, param27);
				cstmt.setString(32, param28);
				cstmt.setString(33, param29);
				cstmt.setString(34, param30);
				cstmt.execute();
				
				session_id = cstmt.getInt(3);
				pgm_date = cstmt.getString(4);
				String a = session_id+":::"+pgm_date;
				System.err.println("session_id->"+session_id);
				System.err.println("pgm_date->"+pgm_date);
				cstmt = null;
				con.commit();
				out.println(a.trim());
			} 
			else if("ReprintConsentFormReportRouting".equals(functionMode)){
				
				java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
				String ws_no		= (String) p.getProperty( "client_ip_address" );
				String facility_id = (String)session.getAttribute("facility_id"); 
				String module_id = request.getParameter("module_id"); 
				String report_id = request.getParameter("p_report_id");
				String reportServer	= (String) session.getValue( "report_server" ) ;
				String userid		= (String) session.getValue( "report_connect_string" ) ;
				String dest_locn_type = "";
				String dest_locn_code = "";
				String report_opt = request.getParameter("reportOption");
				String report = "", server = "",copies = "", report_mode = "", queue_name = "", report_tool = "", status = "" ,message = "",app_server_ip = "", rep_server_key = ""; 
				CallableStatement cstmt = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
				
				cstmt.setString( 1,	module_id ) ;
				cstmt.setString( 2,	report_id ) ;
				cstmt.setString( 3,	dest_locn_type ) ;
				cstmt.setString( 4,	dest_locn_code ) ;
				cstmt.setString( 5,	facility_id ) ;
				cstmt.setString( 6,	ws_no ) ;
				cstmt.setString( 7,	report_opt ) ;
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 10, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 11, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 12, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 13, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 14, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 15, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 16, Types.VARCHAR ) ;
				cstmt.registerOutParameter( 17, Types.VARCHAR ) ;
				cstmt.execute() ;
				report	= cstmt.getString( 8 ) ;
				server	= cstmt.getString( 9 ) ;
				copies	= cstmt.getString( 10 ) ;	
				if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
				report_mode	= cstmt.getString( 11 ) ;
				queue_name	= cstmt.getString( 12 ) ;
				report_tool	= cstmt.getString( 13 ) ;
				status	= cstmt.getString( 14 ) ;
				message	= cstmt.getString( 15 ) ;
				
				if (message==null) message="";
				app_server_ip = cstmt.getString( 16 ) ;
				
				rep_server_key= cstmt.getString( 17 ) ;
				reportServer = "http://" + app_server_ip + reportServer ;
				
				String a = report+":::"+server+":::"+copies+":::"+app_server_ip+":::"+rep_server_key+":::"+reportServer+":::"+userid+":::"+message;
				cstmt = null;
				con.commit();
				out.println(a.trim());
				
			} else if("ReprintConsentFormReportDir".equals(functionMode)){
				
				String report_dir_path = "";
				String report_base_dir = "";
				String dir_path_separator = "";
				String report_dir	= "";
				java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
				String login_user = (String) p.getProperty("login_user");
				
				pstmt = con.prepareCall( "select report_base_dir, dir_path_separator,report_dir from sm_db_info" ) ;
				rs = pstmt.executeQuery() ;

				if ( rs != null && rs.next() ) {
					report_base_dir		= rs.getString( "report_base_dir" ) ;
					dir_path_separator	= rs.getString( "dir_path_separator" ) ;
					report_dir_path	= rs.getString( "report_dir" ) ;

					report_dir 	= report_base_dir + dir_path_separator + login_user + dir_path_separator ;	
				}
				System.err.println("report_dir is: "+report_dir);
				
				rs.close();
				pstmt.close();
				
				out.println(report_dir);
				
				
			}//V230125 ends
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from BLCommonAjax :" + e);
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
	%>
<%!
public String checkNull(String inputString)
{
	if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
		inputString = "";
	return inputString;
}
%>
