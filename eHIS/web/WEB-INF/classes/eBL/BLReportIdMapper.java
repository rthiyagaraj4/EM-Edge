/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
 
package eBL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.*;

import webbeans.eCommon.ConnectionManager;
import webbeans.op.CurrencyFormat;

public class BLReportIdMapper {

	//The below Varaibles are added by Karthik to allow only one time fetch of NumberofDecimal Value from DB 
	private static boolean DECIMAL_ACQUIRED=false;
	private static int DECIMAL_VALUE=2;
	
	//Karthik added below method on 30/09/2014 to convert the given string input value to Billing Format value with corresponding Decimals
	public static String convertBLCurrencyDecimalFormat( String amount ) {

		int noofdecimal = 2;

		try {	
			
			noofdecimal=getNoOfDecimal();
			
			if (amount == null || "".equals(amount)) {
				amount = "0.00";
			} else {
				CurrencyFormat cf = new CurrencyFormat();
				amount = cf.formatCurrency(amount, noofdecimal);
			}

		} catch (Exception e) {
			System.out.println("Exception Getting Number of Decimals. " + e.toString());
			e.printStackTrace();
		}	 
		return amount;
	}
	
	//Karthik added below method on 30/09/2014 to retreive Total number of Decimals in Billing Format 
	public static int getNoOfDecimal() {
		
		Connection con = null;
		PreparedStatement pstmt_dec = null;
		ResultSet rs_dec  = null;

		int noofdecimal = 2;
		
		if(DECIMAL_ACQUIRED){
			noofdecimal=DECIMAL_VALUE;
		}else{			

			try {
				
				 con = ConnectionManager.getConnection();
				 pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		
				 rs_dec = pstmt_dec.executeQuery();
				if (rs_dec.next() && rs_dec != null)
					noofdecimal = rs_dec.getInt(1);				
				
				DECIMAL_ACQUIRED=true;
				DECIMAL_VALUE=noofdecimal;				
			} catch (Exception e) {
				System.err.println("Exception Getting Number of Decimals. " + e.toString());
				DECIMAL_ACQUIRED=false;
				noofdecimal = 2;
				e.printStackTrace();
			}
			//Added against V210416
			finally{			
			try{
				if (rs_dec != null)						rs_dec.close();
				if (pstmt_dec != null)						pstmt_dec.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
				}
		}		
		return noofdecimal;
	}
	
	public static String getBlrBlPrtReportId(String facilityId,String billType){
		
		String sqlReportId = "select report_id  from  bl_bill_reports where OPERATING_FACILITY_ID = ?  and bill_type=? ";
		String reportId = "";
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlReportId);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, billType);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					reportId = rst.getString("report_id");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting Report Id -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}		
		return reportId;
	}
	
	public static String getCustomerId(){

		String sqlCustId = "select customer_id from sm_site_param ";
		String custId = "";
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlCustId);

			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					custId = rst.getString("customer_id");
				}
			}			
		}
		catch(Exception e){
			System.err.println("Exception in getting Report Id -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}		
		return custId;
	}
	
	public static String getBillType(String episodeType, String calledFrom, String calledModuleId){

		String billType = "";		 
		 
		if(episodeType != null && !("".equals(episodeType))){
			if("O".equals(episodeType) || "E".equals(episodeType)){
				billType = "OP-VISIT-BILL";
			}
			else if("I".equals(episodeType) || "D".equals(episodeType)){
				billType = "IP-UNDERCHARGE-BILL";
			}
			else{
				billType = "EX-BILL";
			}
		}
		else if(calledModuleId != null && !("".equals(calledModuleId))){
			if("OP".equals(calledModuleId)){
				billType = "OP-VISIT-BILL";
			}
			else if("IP".equals(calledModuleId)){
				billType = "IP-UNDERCHARGE-BILL";
			}
			else{
				billType = "EX-BILL";
			}
		}		
		return billType;
	}
	
public static String getReciptReportId(String facilityId,String episodeType,String calledModuleId,String reciptNature, String reciptOrRefund ){
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	if(episodeType == null || "".equals(episodeType)){
		if(calledModuleId != null && !("".equals(calledModuleId))){
			if("OP".equals(calledModuleId)){
				episodeType = "O";
			}
			else if("IP".equals(calledModuleId)){
				episodeType = "I";
			}
			else{
				episodeType = "E";
			}
		}
		}
		
		String sqlReportId = "select report_id  from  BL_RECEIPT_REPORTS where OPERATING_FACILITY_ID = ?  and REC_NATURE=? and REC_OR_REF = ? and episode_type = ?";
		String reportId = "";
		
		try{
			
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlReportId);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, reciptNature);
			pstmt.setString(3, reciptOrRefund);
			pstmt.setString(4, episodeType);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					reportId = rst.getString("report_id");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting Report Id -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			ConnectionManager.returnConnection(con);			
		}		
		return reportId;
	}

	public static String windowCloseRestrict(String facilityId){
		
		Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		 
		String restrictFlag = "";
		String sqlCloseRestrict = "Select BL_DISC_WND_CLOSE_RSTRICT from  BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlCloseRestrict);
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					restrictFlag = rst.getString("BL_DISC_WND_CLOSE_RSTRICT");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting WindowCloseRestrict Id -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}
		return restrictFlag;
	}

public static String allowCloseRegnBillGeneration(String facilityId){		
		Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		 
		String allowCloseRegnBillGeneration = "";
		String sqlAllowCloseRegnBillGeneration = "select nvl(Allow_Bill_Gen_Regn_Close_YN,'N') Allow_Bill_Gen_Regn_Close_YN from bl_parameters where operating_facility_id = ?";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlAllowCloseRegnBillGeneration);
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					allowCloseRegnBillGeneration = rst.getString("Allow_Bill_Gen_Regn_Close_YN");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting allowCloseRegnBillGeneration Id -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}
		return allowCloseRegnBillGeneration;
	}
	
	public static String getChargeLogic(String facilityId){
		String restrictFlag = "";
		String sqlCloseRestrict = "Select NVL(charge_logic_yn,'N') charge_logic from  BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
		Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlCloseRestrict);
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					restrictFlag = rst.getString(1);
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting ChargeLogic Bl_parameters -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{
			try{
			if(pstmt!= null) pstmt.close();
			if(rst!=null) rst.close();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
			ConnectionManager.returnConnection(con);			
		}
		return restrictFlag;
	}
	
	//Added By Vijay for MMS-CRF-208 (Report in Arabic)
	/* getReportId function used in other modules also
	 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
	 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
	 * eMP - PatientRegistrationServlet.java
	 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
	 */
	public static String getReportId(Connection con, String locale,String existingReportId, String facility_id) {
		Boolean printRcptSiteSpec = false;
		String reportId = existingReportId;
		String strfacilityid = facility_id;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		try {
			printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
					"BL", "ARABIC_REPORT_PRINT");

			if (printRcptSiteSpec) {
				//Commented by Subha for MMS-DM-CRF-131.1
				/*if (("ar").equalsIgnoreCase(locale)) {
					reportId = "BLRBLPRT_ALMOAR";
				}*/
				//Added By Subha for MMS-DM-CRF-131.1
				String reportLang = "SELECT NVL (bill_print_lang, 'E') bill_print_lang FROM bl_parameters WHERE operating_facility_id = ?";
				pstmt = con.prepareStatement(reportLang);
				pstmt.setString(1, strfacilityid);
				rs = pstmt.executeQuery();
				if(rs != null && rs.next()){
					reportLang = rs.getString("bill_print_lang");
				}
				if(("E").equals(reportLang)) {
					reportId = existingReportId;
					System.out.println("Report ID in IF:" + reportId);
				} else {
					reportId = "BLRBLPRT_ALMOAR";
					System.out.println("Report ID in ELSE:" + reportId);
				} // End				
			}
			System.out.println("report ID "+reportId);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in getting Report Id " + e);
		} 
		//Added against V210416
		finally {
			try{
			if(pstmt!= null) pstmt.close();
			if(rs!=null) rs.close();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return reportId;
	}	
	
	//Added By Vijay for MMS-CRF-208 (Report in Arabic) 
	public static String getReportIdForReceipt(Connection con, String locale,String existingreport, String facility_id) {
		Boolean printRcptSiteSpec = false;
		String reportId = existingreport;
		String strfacilityid = facility_id;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		try {
				printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
					"BL", "ARABIC_REPORT_PRINT");

			if (printRcptSiteSpec) {
				//Commented by Subha for MMS-DM-CRF-131.1
				/*if (("ar").equalsIgnoreCase(locale)) {
					reportId = "BLRECPRT_ALMOAR";
				}*/
				
				//Added By Subha for MMS-DM-CRF-131.1
				String reportLang = "SELECT NVL (bill_print_lang, 'E') bill_print_lang FROM bl_parameters WHERE operating_facility_id = ?";
				pstmt = con.prepareStatement(reportLang);
				pstmt.setString(1, strfacilityid);
				rs = pstmt.executeQuery();
				if(rs != null && rs.next()){
					reportLang = rs.getString("bill_print_lang");
				}
				if(("E").equals(reportLang)) {
					reportId = existingreport;
					System.out.println("Report ID in IF:" + reportId);
				} else {
					reportId = "BLRECPRT_ALMOAR";
					System.out.println("Report ID in ELSE:" + reportId);
				} // End
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in getting Report Id " + e);
		} 
		//Added against V210416
		finally {
			try{
			if(pstmt!= null) pstmt.close();
			if(rs!=null) rs.close();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return reportId;
	}
	
	//Added V180123-Aravindh/MMS-JU-SCF-0102
	public static String truncateUptoTwoDecimal(String strVal, int roundOff) {
		
		String afterDecimal = "", dot = ".";
		
		if(strVal == null) {
			strVal = "0";
		}
		strVal.trim();
		if(strVal.equals("")) {
			strVal = "0";
		}
		
		for(int i = 0; i < roundOff; i++) {
			afterDecimal += "0";
		}
		
		if (strVal.contains(".")) {
			
			String[] arraySplit = strVal.split("\\.");
			
			if(arraySplit[0].equals("")) {
				arraySplit[0] = "0";
			}
			
			if (arraySplit.length > 1) {
				
				if (arraySplit[1].length() > roundOff) {
					afterDecimal = arraySplit[1].substring(0, roundOff);
				} else {
					afterDecimal = arraySplit[1] + afterDecimal.substring(0,roundOff-arraySplit[1].length());
				}				
			}			
			return arraySplit[0] + dot + afterDecimal;			
		} else {			
			return strVal + dot + afterDecimal;			
		}
	}
	//Added V180201-Subha/KDAH-SCF-0472
	public static String getBlReprintMethod(Connection con, String existingReportId, String facility_id) {
		String gstApplicableYN = "N";
		String printOrientation = "P";
		ResultSet  rstMt =  null;
		PreparedStatement pstmtRpt = null;
		CallableStatement cstmt = null;//KDAH-CRF-0546
		String strBlrblprt  = existingReportId;
		String strfacilityid = facility_id;
		try{ 
			pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
			rstMt = pstmtRpt.executeQuery();
			if(rstMt != null && rstMt.next()){
				gstApplicableYN = rstMt.getString("gst_applicable");
			}
			
			if("Y".equals(gstApplicableYN)){
				//ADDED FOR KDAH-CRF-0546 on 15-May-20
				try{ 				
					cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
					cstmt.setString(1,strfacilityid);
					cstmt.setString(2,"R");				
					cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.execute();
						printOrientation = cstmt.getString(3);
						strBlrblprt = cstmt.getString(4);
						System.out.println("528-->printOrientation==>"+printOrientation);
						System.out.println("529-->strBlrblprt==>"+strBlrblprt);
				}
				catch(Exception e){
					printOrientation = "P";
					System.err.println("Exception in getting BLReportIdMapper.java, 1"+e);
					e.printStackTrace();
				}
				finally{
					try
					{
						if (cstmt !=null) cstmt.close();
					}
					catch(Exception ee1) 
					{
						System.err.println("Exception in getting BLReportIdMapper.java, 2"+ee1);
						ee1.printStackTrace();
					}
				}
				//ADDED FOR KDAH-CRF-0546
				/*String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
											"FROM bl_parameters "+
											"WHERE operating_facility_id = ?";
				
				pstmtRpt = con.prepareStatement(printOrientationSql);
				pstmtRpt.setString(1, strfacilityid);
				rstMt = pstmtRpt.executeQuery();
				
				if(rstMt != null && rstMt.next()){
					printOrientation = rstMt.getString("default_bill_print_orientation");
				}*/
				//ADDED FOR KDAH-CRF-0546 on 15-May-20
			}
			
			if(("L".equals(printOrientation)) 
					&& ("BLRBLPRT".equals(strBlrblprt))){
				strBlrblprt = "BLRBLPRL";
			}
		}
		catch(Exception e){
			printOrientation = "P";
			System.err.println("Exception in getting printOrientation, 1"+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}
			catch(Exception ee1) 
			{
				System.err.println("Exception in getting printOrientation, 2"+ee1);
				ee1.printStackTrace();
			}
		}		
		return strBlrblprt;
	}	
		
	/* Added V190128-Aravindh/KDAH-CRF-0513/getPatientName */
	public static String getPatientName(Connection con, String patientID) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		String sql = 	"select patient_name from mp_patient where patient_id = ?";
		String patientName = "";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, patientID);
			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				patientName = rst.getString("patient_name");
			}
		} catch(Exception e) {
			System.err.println("Error in BLReportIdMapper.java-> getPatientName: "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally {
			try{
			if(pstmt!= null) pstmt.close();
			if(rst!=null) rst.close();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
		return patientName;
		}
	}
	
	/* Added V190402-Aravindh/GHL-CRF-0525/For getting order catalog amounts */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static JSONObject getOrderCatalogDtls(Connection con, String patientID, String orderCatalogCodeStr, String blSuccess, String clinicCode, HttpServletRequest req)
	{
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		JSONObject json		= new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj, ctlgCodeJson;
		
		if(null == blSuccess || "".equals(blSuccess)) {
			blSuccess = "N";
		}
		
		HttpSession session = req.getSession();
		
		HashMap finDtls = (HashMap) session.getAttribute("financial_details");
		
		String orderCtlgDtls = "";
		String orderCtlgTotal = "";
		
		String orderCatalogCode = "", netAmt = "", grossAmt = "", patNetAmt = "", patGrossAmt = "", payerNetAmt = "", payerGrossAmt = "";
		String totalNetAmt = "", totalGrossAmt = "", patTotalNetAmt = "", patTotalGrossAmt = "", payerTotalNetAmt = "", payerTotalGrossAmt = "";
		
		try{			
			//GHL-ICN-0062
			String blngGrp = (String) finDtls.get("blng_grp");
			String sql = 	"SELECT adm_rec_flag FROM BL_BLNG_GRP where BLNG_GRP_ID=?";
			String admrecFlag = "";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, blngGrp);
				rst = pstmt.executeQuery();
				while(rst != null && rst.next()){
					admrecFlag = rst.getString("adm_rec_flag");
					System.err.println("620, admrecFlag==>"+admrecFlag);
				}
			} catch(Exception e) {
				System.err.println("Error in BLReportIdMapper.java-> admrecFlag:"+e);
				e.printStackTrace();
			}
			//Added against V210416
			finally {
				try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
			//GHL-ICN-0062
			
			orderCatalogCodeStr = orderCatalogCodeStr.replace("~~", "##");			
			//blSuccess = "Y";
			
			String slmtInd = (String) finDtls.get("slmt_ind");			
			if("X".equals(slmtInd)) {
				if("1".equals(admrecFlag)){//GHL-ICN-0062
					blngGrp = (String) finDtls.get("blng_grp");
					System.err.println("619, blngGrp==>"+blngGrp);
				}else{//GHL-ICN-0062
					blngGrp = (String) finDtls.get("ins_blng_grp");//strBlnggrpId
				}				
			} else {
				blngGrp = (String) finDtls.get("blng_grp");//strBlnggrpId
			}
			
			if(null == blngGrp || "null".equals(blngGrp)) {
				blngGrp = "";
			}
			
			if(!"".equals(orderCatalogCodeStr)) {
				if("N".equals(blSuccess) && "".equals(blngGrp)) {
					cstmt = con.prepareCall("{ call bl_get_ord_catlg_dtls_bef_reg(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
					
					cstmt.setString(1,patientID);
					cstmt.setString(2,orderCatalogCodeStr);
					cstmt.setString(3,clinicCode);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(10,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(11,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(12,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(13,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(14,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(15,java.sql.Types.INTEGER);
					cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
					
					cstmt.execute();
					
					orderCtlgDtls = cstmt.getString(16);
					orderCtlgTotal = cstmt.getString(17);
				} else {
					cstmt=con.prepareCall(" { call bl_get_ord_cat_dtls_bef_reg(?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) } ");
					
					orderCatalogCodeStr = orderCatalogCodeStr.replace("~~", "##");
					
					HashMap hosp_dtls = (HashMap) finDtls.get("hosp_dtls");
					
					String strFacilityId = (String) session.getValue( "facility_id" );
					String strLoggedUser = (String) session.getValue("login_user");
					String locale = (String) session.getAttribute("LOCALE");
					Properties p = (Properties) session.getValue( "jdbc" ) ;
					String clientIpAddress	= p.getProperty("client_ip_address");
					
					cstmt.setString(1, strFacilityId);
					cstmt.setString(2, "OP");
					cstmt.setString(3, "O");//strEpisodeType
					cstmt.setString(4, patientID);
					cstmt.setString(5, "");//strEncounterId
					cstmt.setString(6, "0");//strEpisodeId
					cstmt.setString(7, "0");//strVisitId
					if(null != hosp_dtls) {
						cstmt.setString(8, (String) hosp_dtls.get("hosp_serv_panel_ind"));//strHospServPanelInd
					} else {
						cstmt.setString(8, "");//strHospServPanelInd
					}
					cstmt.setString(9, orderCatalogCodeStr);
					cstmt.setString(10, "1");
					cstmt.setString(11, "0");
					cstmt.setString(12, blngGrp);//strBlnggrpId
					if("R".equals(slmtInd)) {//Credit Type
						cstmt.setString(13, (String) finDtls.get("credit_cust_group_code"));//strCustGroupCode
						cstmt.setString(14, (String) finDtls.get("credit_cust_code"));//strCustCode
					} else {//GHL-ICN-0062
						if("1".equals(admrecFlag)){
							cstmt.setString(13, (String) finDtls.get("sponsor_cust_group_code"));//strCustGroupCode
							cstmt.setString(14, (String) finDtls.get("sponsor_cust_code"));//strCustCode
						}else{//GHL-ICN-0062
							cstmt.setString(13, (String) finDtls.get("ins_cust_group_code"));//strCustGroupCode
							cstmt.setString(14, (String) finDtls.get("ins_cust_code"));//strCustCode
						}
					}
					cstmt.setString(15, (String) finDtls.get("ins_policy_type_code"));//strPolicyTypeCode
					cstmt.setString(16, (String) finDtls.get("ins_cust_priority"));//strPolicyPriority
					cstmt.setString(17, (String) finDtls.get("ins_policy_no"));//strPolicyNumber
					cstmt.setString(18, (String) finDtls.get("ins_policy_start_date"));//strPolicyStartDate
					cstmt.setString(19, (String) finDtls.get("ins_policy_expiry_date"));//strPolicyExpiryDate
					cstmt.setString(20, (String) finDtls.get("ins_credit_auth_ref"));//strCreditAuthRef
					cstmt.setString(21, (String) finDtls.get("ins_credit_auth_date"));//strCreditAuthDate
					cstmt.setString(22, (String) finDtls.get("ins_policy_eff_from_date"));//strEffectiveFrom
					cstmt.setString(23, (String) finDtls.get("ins_policy_eff_to_date"));//strEffectiveTo
					cstmt.setString(24, (String) finDtls.get("ins_credit_approval_amount"));//strApprovedAmt
					cstmt.setString(25, (String) finDtls.get("ins_credit_approval_days"));//strApprovedDays
					cstmt.setString(26, (String) finDtls.get("non_ins_blng_grp"));//strNonInsBlnggrpId
					cstmt.setString(27, (String) finDtls.get("non_ins_cust_group_code"));//strNonInsCustGroupCode
					cstmt.setString(28, (String) finDtls.get("non_ins_cust_code"));//strNonInsCustCode
					cstmt.setString(29, strLoggedUser);
					cstmt.setString(30, clientIpAddress);
					cstmt.setInt(31, 1);
					cstmt.setString(32, "");
					cstmt.setString(33, locale);
					cstmt.setString(34, clinicCode);
					
					cstmt.registerOutParameter(35, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(36, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(37, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(38, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(39, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(40, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(41, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(42, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(43, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(44, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(45, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(46, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(47, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(48, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(49, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(50, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(51, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(52, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(53, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(54, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(55, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(56, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(57, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(58, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(59, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(60, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(61, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(62, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(63, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(64, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(65, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(66, java.sql.Types.INTEGER);
					cstmt.registerOutParameter(67, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(68, java.sql.Types.VARCHAR);
					
					cstmt.execute();
					
					orderCtlgDtls = cstmt.getString(67);
					if(null == orderCtlgDtls) {
						orderCtlgDtls = "";
					}
					orderCtlgTotal = cstmt.getString(68);
					if(null == orderCtlgTotal) {
						orderCtlgTotal = "";
					}
				}
				
				if(null == orderCtlgDtls) {
					orderCtlgDtls = "";
				}
				if(null == orderCtlgTotal) {
					orderCtlgTotal = "";
				}
	
				System.out.println("orderCtlgDtls->"+ orderCtlgDtls);
				
				if(!"".equals(orderCtlgDtls)) {
					String[] orderCtlgList = orderCtlgDtls.split("\\|");
					
					for(int i = 0; i < orderCtlgList.length; i++) {
						String[] orderDtls = orderCtlgList[i].split("\\~");
						orderCatalogCode 	= orderDtls[0];
						netAmt 				= orderDtls[1];
						grossAmt  			= orderDtls[2];
						patNetAmt 			= orderDtls[3];
						patGrossAmt 		= orderDtls[4];
						payerNetAmt 		= orderDtls[5];
						payerGrossAmt 		= orderDtls[6];
						
						jsonObj = new JSONObject();
						jsonObj.put("netAmt", netAmt);
						jsonObj.put("grossAmt", grossAmt);
						jsonObj.put("patNetAmt", patNetAmt);
						jsonObj.put("patGrossAmt", patGrossAmt);
						jsonObj.put("payerNetAmt", payerNetAmt);
						jsonObj.put("payerGrossAmt", payerGrossAmt);
						
						ctlgCodeJson = new JSONObject();
						ctlgCodeJson.put(orderCatalogCode, jsonObj);
						
						jsonArray.add(ctlgCodeJson);
					}
				}
				
				if(!"".equals(orderCtlgTotal)) {
					
					String orderCtlgTotList[] = orderCtlgTotal.split("\\~");
					
					totalNetAmt 		= orderCtlgTotList[0];
					totalGrossAmt 		= orderCtlgTotList[1];
					patTotalNetAmt  	= orderCtlgTotList[2];
					patTotalGrossAmt 	= orderCtlgTotList[3];
					payerTotalNetAmt 	= orderCtlgTotList[4];
					payerTotalGrossAmt 	= orderCtlgTotList[5];
					
					jsonObj = new JSONObject();
					jsonObj.put("totalNetAmt", totalNetAmt);
					jsonObj.put("totalGrossAmt", totalGrossAmt);
					jsonObj.put("patTotalNetAmt", patTotalNetAmt);
					jsonObj.put("patTotalGrossAmt", patTotalGrossAmt);
					jsonObj.put("payerTotalNetAmt", payerTotalNetAmt);
					jsonObj.put("payerTotalGrossAmt", payerTotalGrossAmt);
					
					ctlgCodeJson = new JSONObject();
					ctlgCodeJson.put("totals", jsonObj);
					
					jsonArray.add(ctlgCodeJson);
				}
			}//End if orderCatalogCodeStr check not empty

			json.put("orderCatalogDtls",jsonArray);
	} 
	catch(Exception e) {
			System.err.println("Error in BLReportIdMapper.java-> getOrderCatalogDtls: "+e);
			e.printStackTrace();
		}
		return json;
	}
	//TH-KW-CRF-0174
	public static String eSignatureFlag(String facilityId){
		
		Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rst = null;
		 
		String eSignatureFlag = "";
		String sqlCloseRestrict = "Select NVL(CAPTURE_PATIENT_ESIGNATURE,'N') CAPTURE_PATIENT_ESIGNATURE from  BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlCloseRestrict);
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					eSignatureFlag = rst.getString("CAPTURE_PATIENT_ESIGNATURE");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting CAPTURE_PATIENT_ESIGNATURE  -> "+e);
			e.printStackTrace();
		}
		//Added against V210416
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}
		return eSignatureFlag;
	}
	
	public static String isDiscClearanceEnabledYN(String facilityId){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		 
		String isDiscClearanceEnabledYN = "N";
		String sql = "Select NVL(DISC_CLEARANCE_ENABLED_YN,'N') DISC_CLEARANCE_ENABLED_YN from BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					isDiscClearanceEnabledYN = rst.getString("DISC_CLEARANCE_ENABLED_YN");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting DISC_CLEARANCE_ENABLED_YN  -> "+e);
			e.printStackTrace();
		}
		finally{			
			try{
				if(pstmt!= null) pstmt.close();
				if(rst!=null) rst.close();
				}catch (Exception ee) {
					ee.printStackTrace();
				}			
			ConnectionManager.returnConnection(con);			
		}
		return isDiscClearanceEnabledYN;
	}
}
