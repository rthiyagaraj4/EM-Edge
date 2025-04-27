/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import eBL.Common.BlAdapter;
import webbeans.eCommon.*;

public class BlServiceDiscPriceBean extends BlAdapter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String facilityId = "";
	private String servInd = "";	
	private String servCode = "";
	private String servDesc = "";
	private String priceInd = "";
	private String priceCode = "";
	private String priceDesc = "";
	private String policyCode = "";
	private String policyDesc = "";
	private String custGrpCode = "";
	private String custGrpDesc = "";

	private String blngClassCode = "";
	private String blngClassDesc = "";
	private String ratePriceInd = "";
	private String chkCostAvl = "";
	private String costInd = "";
	private String costAmt = "";
	private String ipRate = "";
	private String opRate = "";
	private String emRate = "";
	private String exRate = "";
	private String dcRate = "";
	private String minCharge = "";
	
	private String maxCharge = "";
	private String baseQty = "";
	private String priceApplicability = "";
	private String applyDiscount = "";
	private String priceEffFrom = "";
	private String priceEffTo = "";
	private String discInd = "";
	private String discEffFrom = "";
	private String discEffTo = "";
	private String ipDiscRate = "";
	private String opDiscRate = "";
	private String emDiscRate = "";
	private String exDiscRate = "";
	private String dcDiscRate = "";
	private String discApplicability = "";
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
	private String st_item_public_price_chk_yn = "";

	private String enable = ""; 
	private int discountCnt = 0;
		private String st_item_rate_basis_ind = "";
	public String getSt_item_public_price_chk_yn() {
		return st_item_public_price_chk_yn;
	}
	public void setSt_item_public_price_chk_yn(String st_item_public_price_chk_yn) {
		this.st_item_public_price_chk_yn = st_item_public_price_chk_yn;
	}
	public String getSt_item_rate_basis_ind() {
		return st_item_rate_basis_ind;
	}
	public void setSt_item_rate_basis_ind(String st_item_rate_basis_ind) {
		this.st_item_rate_basis_ind = st_item_rate_basis_ind;
	}
//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
	public int getDiscountCnt() {
		return discountCnt;
	}


	public void setDiscountCnt(int discountCnt) {
		this.discountCnt = discountCnt;
	}


	public String getFacilityId() {
		return facilityId;
	}


	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}


	public String getServInd() {
		return servInd;
	}


	public void setServInd(String servInd) {
		this.servInd = servInd;
	}


	public String getServCode() {
		return servCode;
	}


	public void setServCode(String servCode) {
		this.servCode = servCode;
	}


	public String getServDesc() {
		return servDesc;
	}


	public void setServDesc(String servDesc) {
		this.servDesc = servDesc;
	}


	public String getPriceInd() {
		return priceInd;
	}


	public void setPriceInd(String priceInd) {
		this.priceInd = priceInd;
	}


	public String getPriceCode() {
		return priceCode;
	}


	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}


	public String getPriceDesc() {
		return priceDesc;
	}


	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}


	public String getPolicyCode() {
		return policyCode;
	}


	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}


	public String getPolicyDesc() {
		return policyDesc;
	}


	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}


	public String getCustGrpCode() {
		return custGrpCode;
	}


	public void setCustGrpCode(String custGrpCode) {
		this.custGrpCode = custGrpCode;
	}


	public String getCustGrpDesc() {
		return custGrpDesc;
	}


	public void setCustGrpDesc(String custGrpDesc) {
		this.custGrpDesc = custGrpDesc;
	}


	public String getBlngClassCode() {
		return blngClassCode;
	}


	public void setBlngClassCode(String blngClassCode) {
		this.blngClassCode = blngClassCode;
	}


	public String getBlngClassDesc() {
		return blngClassDesc;
	}


	public void setBlngClassDesc(String blngClassDesc) {
		this.blngClassDesc = blngClassDesc;
	}
	
	
	private Hashtable recordSet = new Hashtable();
	HashMap<String, Object> commonStoreMap = new HashMap<String, Object>();

	public HashMap<String, Object> getCommonStoreMap() {
		return commonStoreMap;
	}

	public void setCommonStoreMap(HashMap<String, Object> commonStoreMap) {
		this.commonStoreMap = commonStoreMap;
	}

	public void setAll(Hashtable recordSet) {

		if (recordSet.containsKey("mode"))
			setMode((String) recordSet.get("mode"));
		this.recordSet = recordSet;
	}

	
	public BlServiceDiscPriceBean loadDescriptions(String facilityId,String servInd,String servCode,String priceInd,String priceCode, String custGrpCode,String policyCode,String blngClass,String locale, String validFrom,String mode, String validTo){
		BlServiceDiscPriceBean blServiceDiscPriceBean = new BlServiceDiscPriceBean();
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			blServiceDiscPriceBean.setFacilityId(checkForNull(facilityId) );
			blServiceDiscPriceBean.setServInd(checkForNull(servInd));
			blServiceDiscPriceBean.setServCode(checkForNull(servCode));
			blServiceDiscPriceBean.setPriceInd(checkForNull(priceInd));
			blServiceDiscPriceBean.setPriceCode(checkForNull(priceCode));
			blServiceDiscPriceBean.setCustGrpCode(checkForNull(custGrpCode));
			blServiceDiscPriceBean.setPolicyCode(checkForNull(policyCode));
			blServiceDiscPriceBean.setBlngClassCode(checkForNull(blngClass));
			System.err.println("policyCode "+checkForNull(policyCode));
			
			String sqlServDesc = "Select blcommonproc.get_description('SERV_CRIT',?,?,?) serv_desc from dual";
			pstmt = con.prepareStatement(sqlServDesc);
			pstmt.setString(1, servInd);
			pstmt.setString(2, servCode);
			pstmt.setString(3, locale);
			rst = pstmt.executeQuery();
			if(rst != null)
			while(rst.next()){
				blServiceDiscPriceBean.setServDesc(checkForNull(rst.getString("serv_desc")));
			}
			
		pstmt = null;
		rst = null;
		
		String sqlPriceDesc = "";
		if("S".equals(priceInd)){
			sqlPriceDesc = "SELECT facility_name price_description FROM sm_facility_param WHERE LANGUAGE_ID=? AND facility_id = ? ";
			pstmt = con.prepareStatement(sqlPriceDesc);
			pstmt.setString(1, locale);
			pstmt.setString(2, priceCode);
			rst = pstmt.executeQuery();
		}
		else if("B".equals(priceInd)){
			sqlPriceDesc = "SELECT short_desc price_description FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID=? AND blng_grp_id = ? ";
			pstmt = con.prepareStatement(sqlPriceDesc);
			pstmt.setString(1, locale);
			pstmt.setString(2, priceCode);
			rst = pstmt.executeQuery();
		}
		else if("C".equals(priceInd)){
			sqlPriceDesc = "SELECT Short_Name price_description FROM ar_customer_lang_vw WHERE LANGUAGE_ID=? AND Cust_code = ? AND  acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = ?)";
			pstmt = con.prepareStatement(sqlPriceDesc);
			pstmt.setString(1, locale);
			pstmt.setString(2, priceCode);
			pstmt.setString(3, facilityId);
			rst = pstmt.executeQuery();
		}
		else if("P".equals(priceInd)){
			sqlPriceDesc = "SELECT Short_Desc price_description FROM bl_price_class_lang_vw WHERE LANGUAGE_ID=?  and Price_Class_Code = ? AND OPERATING_FACILITY_ID = ?  ";
			pstmt = con.prepareStatement(sqlPriceDesc);
			pstmt.setString(1, locale);
			pstmt.setString(2, priceCode);
			pstmt.setString(3, facilityId);
			rst = pstmt.executeQuery();
		}			
		if(rst != null)
		while(rst.next()){
			blServiceDiscPriceBean.setPriceDesc(checkForNull(rst.getString("price_description")));
		}
		
		if("**".equals(priceCode)){
			blServiceDiscPriceBean.setPriceDesc("All Price Code");
		}
		pstmt = null;
		rst = null;
		
		String sqlCustGrpDesc = "select long_desc from ar_cust_group_lang_vw where cust_group_code = ? and language_id = ? ";
		pstmt = con.prepareStatement(sqlCustGrpDesc);
		pstmt.setString(1, custGrpCode);
		pstmt.setString(2, locale);
		rst = pstmt.executeQuery();
		if(rst != null)
		while(rst.next()){
			blServiceDiscPriceBean.setCustGrpDesc(checkForNull(rst.getString("long_desc")));
		}
		
		if("**".equals(custGrpCode)){
			blServiceDiscPriceBean.setCustGrpDesc("All Payer Group");
		}
		pstmt = null;
		rst = null;
		
		String sqlPolicyDesc = "select long_desc  from bl_ins_policy_types_lang_vw where policy_type_code = ? and language_id = ? ";
		pstmt = con.prepareStatement(sqlPolicyDesc);
		pstmt.setString(1, policyCode);
		pstmt.setString(2, locale);
		rst = pstmt.executeQuery();
		if(rst != null)
		while(rst.next()){
			blServiceDiscPriceBean.setPolicyDesc(checkForNull(rst.getString("long_desc")));
		}
		
		
		pstmt = null;
		rst = null;
		
		String sqlBlngClassDesc = "SELECT Short_Desc FROM BL_BLNG_CLASS_lang_vw WHERE Blng_Class_Code = ? and LANGUAGE_ID=? ";
		pstmt = con.prepareStatement(sqlBlngClassDesc);
		pstmt.setString(1, blngClass);
		pstmt.setString(2, locale);
		rst = pstmt.executeQuery();
		if(rst != null)
		while(rst.next()){
			blServiceDiscPriceBean.setBlngClassDesc(checkForNull(rst.getString("Short_Desc")));
		}
		
		if("**".equals(blngClass)){
			blServiceDiscPriceBean.setBlngClassDesc("All Billing Class");
		}
			
		}catch(Exception e){
			System.err.println("Exception in BLServiceDiscPriceBean -> "+e);
			e.printStackTrace();
		}
		return blServiceDiscPriceBean;
	}
	// To get the Sysdate, with Properties
	public ArrayList getSysDateTime(Properties properties) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList currentDate = new ArrayList();

		try {
			connection = ConnectionManager.getConnection(properties);
			pstmt = connection.prepareStatement(
					"select to_char(sysdate,'HH12:MM') sys_time,to_char(sysdate,'dd/mm/yyyy') sys_date, to_char(sysdate+1,'dd/mm/yyyy')   next_sys_date ,to_char(sysdate,'DD/mm/yyyy') || ' 23:59' curr_date, to_char(sysdate - 7,'DD/mm/yyyy') || ' 00:00' last_week_date, to_char(sysdate - 7,'DD/mm/yyyy') last_week_without_date,  to_char(sysdate + 7,'DD/mm/yyyy') next_week_without_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate - 30 ,'DD/mm/yyyy') last_month_date, to_char( sysdate, 'HH24:MI:SS' ) sys_time_sec, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sys_date_time_sec,USERENV('SESSIONID') session_id from dual");
			resultSet = pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				currentDate.add(resultSet.getString("sys_date"));
				currentDate.add(resultSet.getString("last_week_without_date"));
				currentDate.add(resultSet.getString("sys_date_time"));
				currentDate.add(resultSet.getString("next_week_without_date"));
				currentDate.add(resultSet.getString("last_month_date"));
				currentDate.add(resultSet.getString("sys_time_sec"));
				currentDate.add(resultSet.getString("last_week_date"));
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			closeStatement(pstmt);
			closeResultSet(resultSet);
			if (connection != null)
				ConnectionManager.returnConnection(connection, properties);
		}

		return currentDate;
	}

	public ArrayList getloadpricecls(String facilityId,String servInd,String servCode,String priceInd,String priceCode, String custGrpCode,String policyCode,
			String blngClass,String locale, String validFrom,String mode, String validTo) throws Exception {
		ArrayList loadPriceCls = new ArrayList();
		System.err.println("66,loadPriceCls");
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		connection = ConnectionManager.getConnection(properties);
		String sqlPriceClass = "select RATE_FACTOR_IND,SERV_COST_IND,SERV_COST_AMT,CHECK_FOR_COST_AVL_YN, "+
		"IP_RATE,OP_RATE,REF_RATE,EMER_RATE,DAYCARE_RATE,MIN_CHARGE_AMT, "+
		"MAX_CHARGE_AMT,BASE_QTY,GROSS_NET_APPL_IND,APPLY_DISC_YN,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO ,ST_ITEM_PUBLIC_PRICE_CHK_YN,ST_ITEM_RATE_BASIS_IND "+
		"from bl_serv_cust_pc_price  "+
		"where OPERATING_FACILITY_ID = ? and NVL(blng_serv_ind,'#') = NVL(?,'#') and BLNG_SERV_CODE = ? and CUST_PC_IND = ? and CUST_PC_CODE = ? "+
		"and blng_class_code = ? and NVL(POLICY_TYPE_CODE,'#') =  NVL(?,'#') and NVL(CUST_GROUP_CODE,'#') =  NVL(?,'#') and to_char(valid_from,'dd/mm/yyyy') = ? ";

		System.err.println("sqlPriceClass:"+sqlPriceClass);
		System.err.println("Values for price class query:"+facilityId+"/"+servInd+"/"+servCode+"/"+priceInd+"/"+priceCode+"/"+custGrpCode+"/"+policyCode+"/"+blngClass+"/"+locale+"/"+validFrom+"/"+mode+"/"+validTo);
		try {
			System.err.println(sqlPriceClass);
			pstmt = connection.prepareStatement(sqlPriceClass);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, servInd);
			pstmt.setString(3, servCode);
			pstmt.setString(4, priceInd);
			pstmt.setString(5, priceCode);
			pstmt.setString(6, blngClass);
			pstmt.setString(7, policyCode);
			pstmt.setString(8, custGrpCode);
			pstmt.setString(9, validFrom);

			resultSet = pstmt.executeQuery();
			System.err.println("after execute ");
			int i = 0;
			if(resultSet != null){
				while (resultSet.next()) {
					loadPriceCls.add(checkForNull(resultSet.getString("RATE_FACTOR_IND")));
					loadPriceCls.add(checkForNull(resultSet.getString("VALID_FROM")));
					loadPriceCls.add(checkForNull(resultSet.getString("VALID_TO")));
					loadPriceCls.add(checkForNull(resultSet.getString("IP_RATE")));
					loadPriceCls.add(checkForNull(resultSet.getString("OP_RATE")));
					loadPriceCls.add(checkForNull(resultSet.getString("EMER_RATE")));
					loadPriceCls.add(checkForNull(resultSet.getString("REF_RATE")));
					loadPriceCls.add(checkForNull(resultSet.getString("DAYCARE_RATE")));
					loadPriceCls.add(checkForNull(resultSet.getString("GROSS_NET_APPL_IND")));
					loadPriceCls.add(checkForNull(resultSet.getString("BASE_QTY")));
					loadPriceCls.add(checkForNull(resultSet.getString("ST_ITEM_PUBLIC_PRICE_CHK_YN")));
					loadPriceCls.add(checkForNull(resultSet.getString("ST_ITEM_RATE_BASIS_IND")));
					loadPriceCls.add(checkForNull(resultSet.getString("MIN_CHARGE_AMT")));
					loadPriceCls.add(checkForNull(resultSet.getString("MAX_CHARGE_AMT")));
					loadPriceCls.add(checkForNull(resultSet.getString("CHECK_FOR_COST_AVL_YN")));
					loadPriceCls.add(checkForNull(resultSet.getString("SERV_COST_IND")));
					loadPriceCls.add(checkForNull(resultSet.getString("SERV_COST_AMT")));
					loadPriceCls.add(checkForNull(resultSet.getString("APPLY_DISC_YN")));
					loadPriceCls.add(discDtlsqry( facilityId,servInd,servCode,priceInd,priceCode,custGrpCode,policyCode,blngClass,locale,validFrom,mode,validTo));
					i++;  
					System.err.println("158,loadPriceCls ,i -" + i);

					System.err.println("158,loadPriceCls ,loadPriceCls -" + loadPriceCls);
				}
			}
		} catch (Exception e) {

		e.printStackTrace();
		throw e;
		} finally {
		closeStatement(pstmt);
		closeResultSet(resultSet);
		if (connection != null)
		ConnectionManager.returnConnection(connection, properties);
		}
		return loadPriceCls;
	}

	public HashMap modify() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String key = null;
		ArrayList insertRow = new ArrayList();
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", new Boolean(false));
			map.put("message", "ERROR While updating the record in PH_DISP_DRUG_BATCH" + e.getMessage());
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception eclose) {

				// TODO: handle exception
				eclose.printStackTrace();
			}
		}

		return map;
	}

	public String discDtlsqry(String facilityId,String servInd,String servCode,String priceInd,String priceCode, String custGrpCode,String policyCode,
	String blngClass,String locale, String validFrom,String mode, String validTo) throws Exception {
		
		ArrayList discDtlsqrylist = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String discStringForBlngClass = "";
		
		String sqlDiscountClass = "select DISC_OPTION,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,DISC_APPLICABLE_IND,STATUS, "+
		"IP_DISC_PERC,OP_DISC_PERC,REF_DISC_PERC,EMER_DISC_PERC,DAYCARE_DISC_PERC, "+
		"DISC_IN_HOURS DISC_UPTO_HRS, HOURLY_DISC_PERC DISC_UPTO_PERCAMT "+
		"from bl_serv_cust_pc_discount  "+ 
		"where OPERATING_FACILITY_ID = ? and pkg_serv_ind = 'S' and NVL(blng_serv_ind,'#') = NVL(?,'#') and pkg_serv_code = ? and cust_pc_ind = ? and cust_pc_code = ?  "+
		"and blng_class_code = ? and NVL(POLICY_TYPE_CODE,'#') =  NVL(?,'#') and NVL(CUST_GROUP_CODE,'#') =  NVL(?,'#') "+
		" and valid_from >= to_date(?,'dd/mm/yyyy') "+
		" and valid_from <=  NVL(TO_DATE(?, 'dd/mm/yyyy'),SYSDATE+3650) "+
		"  AND (   (    valid_to IS NULL  ) "+
		" OR (    valid_to IS NOT NULL "+
		" AND valid_to BETWEEN SYSDATE - 1 AND SYSDATE + 3650 ))  order by VALID_FROM";
		//added by Nandhini against MMS-QH-CRF-0128.4
		System.err.println("sqlDiscountClass:"+sqlDiscountClass);
		try 
		{
			System.err.println("values for Discount fetch:" + facilityId+"/"+ servInd+"/"+servCode+"/"+priceInd+"/"+priceCode+"/"+custGrpCode+"/"+policyCode+"/"+blngClass+"/"+locale+"/"+validFrom+"/"+mode+"/"+ validTo);
			connection = ConnectionManager.getConnection(properties);
			pstmt = connection.prepareStatement(sqlDiscountClass);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, servInd);
			pstmt.setString(3, servCode);
			pstmt.setString(4, priceInd);
			pstmt.setString(5, priceCode);
			pstmt.setString(6, blngClass);
			pstmt.setString(7, policyCode);
			pstmt.setString(8, custGrpCode);
			pstmt.setString(9, validFrom);
			pstmt.setString(10, validTo);
			rst = pstmt.executeQuery();
			
			if(rst != null){
				while(rst.next())
				{
					String discInd = checkForNull(rst.getString("DISC_OPTION"), " ");
					String IPPercVal = checkForNull(rst.getString("IP_DISC_PERC"), " ");
					String OPPerVal	 = checkForNull(rst.getString("OP_DISC_PERC"), " ");
					String DCPerVal	 = checkForNull(rst.getString("DAYCARE_DISC_PERC"), " ");
					String EMPerVal  = checkForNull(rst.getString("EMER_DISC_PERC"), " ");
					String EXPerVal  = checkForNull(rst.getString("REF_DISC_PERC"), " ");
					String discApplicability = checkForNull(rst.getString("DISC_APPLICABLE_IND"), " ");
					String discEffFromDate = checkForNull(rst.getString("VALID_FROM"), " ");
					String discEffToDate =  checkForNull(rst.getString("VALID_TO"), " ");
					String isDiscInsMod = "M";
					String discUptoHrs =  checkForNull(rst.getString("DISC_UPTO_HRS"), " ");
					String discUptoPercAmt =  checkForNull(rst.getString("DISC_UPTO_PERCAMT"), " ");
					
					discStringForBlngClass = discStringForBlngClass + discInd+"::"+IPPercVal+"::"+OPPerVal+"::"+EMPerVal+"::"+EXPerVal+"::"+DCPerVal+"::"+discApplicability+"::"+discEffFromDate+"::"+discEffToDate+"::"+isDiscInsMod+"::"+discUptoHrs+"::"+discUptoPercAmt+"::"+",";
					
					/* discDtlsqrylist.add(checkForNull(rst.getString("DISC_OPTION")));
					discDtlsqrylist.add(checkForNull(rst.getString("VALID_FROM")));
					discDtlsqrylist.add(checkForNull(rst.getString("VALID_TO")));				
					discDtlsqrylist.add(checkForNull(rst.getString("DISC_APPLICABLE_IND")));
					discDtlsqrylist.add(checkForNull(rst.getString("STATUS")));		
					discDtlsqrylist.add(checkForNull(rst.getString("IP_DISC_PERC")));
					discDtlsqrylist.add(checkForNull(rst.getString("OP_DISC_PERC")));
					discDtlsqrylist.add(checkForNull(rst.getString("REF_DISC_PERC")));
					discDtlsqrylist.add(checkForNull(rst.getString("EMER_DISC_PERC")));				
					discDtlsqrylist.add(checkForNull(rst.getString("DAYCARE_DISC_PERC"))); */
				}
			}
			System.err.println("discStringForBlngClass:"+discStringForBlngClass);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeStatement(pstmt);
			closeResultSet(rst);
			if (connection != null)
			ConnectionManager.returnConnection(connection, properties);
		}
		return discStringForBlngClass;
	}

	public String getFacilityName(String facility_id, String locale) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		// ArrayList FacilityList = new ArrayList();
		String facilityName = "";

		try {
			connection = getConnection();
			// pstmt =
			// connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT"
			// )) ;
			pstmt = connection.prepareStatement(
					"select facility_name from sm_facility_param_lang_vw  where facility_id = ? and status = 'E' and language_id = ?");
			pstmt.setString(1, facility_id);
			pstmt.setString(2, locale);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				facilityName = (String) resultSet.getString("facility_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return facilityName;
	}
	public String getChargeRate(String chargerate) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		// ArrayList FacilityList = new ArrayList();
		String chargerateYN = "";
		String rateflagYN = "N";

		try {
			connection = getConnection();
			// pstmt =
			// connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT"
			// )) ;
			pstmt = connection.prepareStatement(
					"select RATE_ENTRY_BY_USER_FLAG from bl_blng_serv where BLNG_SERV_CODE=? ");
			pstmt.setString(1, chargerate);

			resultSet = pstmt.executeQuery();
			
			if (resultSet != null && resultSet.next()) {
					chargerateYN = (String) resultSet.getString("RATE_ENTRY_BY_USER_FLAG");
			}
			
			if(chargerateYN.equals("R")){
				rateflagYN="Y";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return rateflagYN;
	}

	public ArrayList getOrderingFacilityId(String locale) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList result = new ArrayList();
		try {
			connection = getConnection();
			// pstmt = connection.prepareStatement( PhRepository.getPhKeyValue(
			// "SQL_PH_DISPLOCN_SELECT" )) ;
			// pstmt = connection.prepareStatement("SELECT B.FACILITY_ID
			// FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM
			// SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_LANG_VW B WHERE
			// A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID
			// = ? AND B.LANGUAGE_ID= ?") ; //commented and added below sql for
			// 033992 - [PH -> ReRoute -> Ordering Facility is not shown in
			// Verification stage]
			pstmt = connection.prepareStatement(
					"SELECT FACILITY_ID ,FACILITY_NAME  FROM  SM_FACILITY_PARAM_LANG_VW  WHERE STATUS ='E'AND LANGUAGE_ID= ? order by FACILITY_NAME");
			// pstmt.setString(1,p_user_name); //Commented for 033992 //order by
			// added for ML-BRU-SCF-1517 [IN:053108]
			pstmt.setString(1, locale);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.add(e.toString());
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}
	
	public String getBlngClassType(String blngClassCode) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String result = "";
		try 
		{
			connection = getConnection();			
			pstmt = connection.prepareStatement(
					"select NVL(PATIENT_CATEGORY_CODE,'') PATIENT_CATEGORY_CODE from bl_blng_class where BLNG_CLASS_CODE = ? ");
			pstmt.setString(1, blngClassCode);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				result = resultSet.getString("PATIENT_CATEGORY_CODE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}	
	
public String isServiceChargeBased(String servCode) {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	String rateChargeFlag = "";
	String isServiceChargeBasedYN = "N";

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(
				"select RATE_ENTRY_BY_USER_FLAG from bl_blng_serv where BLNG_SERV_CODE=? ");
		pstmt.setString(1, servCode);

		resultSet = pstmt.executeQuery();
		
		if (resultSet != null && resultSet.next()) {
				rateChargeFlag = (String) resultSet.getString("RATE_ENTRY_BY_USER_FLAG");
		}
		
		if(rateChargeFlag.equals("C")){
			isServiceChargeBasedYN = "Y";
		}
			
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
	return isServiceChargeBasedYN;
}	
	
	public String isServMMBased(String servCode) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String isServMMBasedYN = "";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(
					"select NVL(MM_ITEM_SERV_YN,'N') MM_ITEM_SERV_YN from bl_blng_serv where BLNG_SERV_CODE=? ");
			pstmt.setString(1, servCode);

			resultSet = pstmt.executeQuery();
			
			if (resultSet != null && resultSet.next()) {
					isServMMBasedYN = (String) resultSet.getString("MM_ITEM_SERV_YN");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return isServMMBasedYN;
	}	
	//Added newly for MMS-KH-SCF-0187
	public String isServMatBased(String servCode,String servInd) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String isServMMBasedYN = "";
		System.err.println("isServMatBased servCode:"+servCode);
		System.err.println("isServMatBased servInd:"+servInd);
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement("select BL_EBLCOMMON.is_bl_mm_item_serv_yn (?,?) from dual");
			pstmt.setString(1, servInd);
			pstmt.setString(2, servCode);

			resultSet = pstmt.executeQuery();
			
			if (resultSet != null && resultSet.next()) {
					isServMMBasedYN = resultSet.getString(1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return isServMMBasedYN;
	}	
}
