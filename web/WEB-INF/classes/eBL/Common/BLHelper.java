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
package eBL.Common;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

//import eBL.BLPayerServiceGrpHdrBean;

import webbeans.eCommon.ConnectionManager;
import org.apache.commons.io.FileUtils;

public class BLHelper {

	public static byte[] imagePathToBytes(String filePath){
		byte[] imageByteArray = null;
		try {
			 File imgFile = new File(filePath);
			 imageByteArray = FileUtils.readFileToByteArray(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error Occured while converting Image File from Path "+ filePath);
		}
		 return imageByteArray;		
	}
	
	public static Map<String,String> getCodeDescMap(String sql, Set<String> idList, String where, String colId, String orderBy ) throws Exception
	{
		Map<String,String> codeDescMap = new LinkedHashMap<String,String>();
		
		where = where == null ? "" : where;
		
		StringBuffer whereClause = new StringBuffer(where); 
		
		Connection connection 		=  ConnectionManager.getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		
		try
		{
			//build the prepared stmt
			buildWhereClause(whereClause, idList, colId);
			sql += whereClause.toString();
			sql += orderBy;
			pstmt = connection.prepareStatement(sql);
			
			int pstmtIndex = 1;
			if(idList != null && !idList.isEmpty())
			{
				for(String id : idList)
				{ 
					pstmt.setString(pstmtIndex++, id);
				}
			}
			
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
			
				codeDescMap.put(rs.getString("CODE"), rs.getString("DESCRIPTION"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from getColumnDesc()= :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null)connection.close();
			
		}		
		return codeDescMap;		
	}
	
	private static void buildWhereClause(StringBuffer whereClause, Set<String> idList, String colId)
	{
		if(idList == null || idList.isEmpty())
		{
			return;
		}
	
		if(whereClause != null && whereClause.equals(""))
		{
			whereClause.append(" WHERE ").append(colId);
		}
		else
		{
			whereClause.append(" AND ").append(colId);
		}
		
		if(idList.size() == 1)
		{
			whereClause.append(" = ?");
		}
		else
		{
			whereClause.append(" in (");
			
			for(int index=0; index< idList.size(); index++)
			{
				whereClause.append("? ");
				
				if(index < (idList.size() - 1))
				{
					whereClause.append(",");
				}
			}
			whereClause.append(")");
		}
	}
	

   public static String checkForNull(String value)
   {
	   if(value == null)
	   {
		   value = "";
	   }
	   return value;
   }
	
   public static String toDate(String date, String locale)
	{
		if(date==null)
			date="";
		else
			date = com.ehis.util.DateUtils.convertDate(date,"DMY",locale,"en");
		
		return date;
	}
   
   public static Map<String,String> getFacilityMap(String locale) throws Exception
	{
		String FACILITY_WHERE = " WHERE LANGUAGE_ID = '" + locale + "' AND STATUS = 'E'";
		String FACILITY_SQL = BlRepository.getBlKeyValue("FACILITY_LIST");
			
		return BLHelper.getCodeDescMap(FACILITY_SQL, null, FACILITY_WHERE, "", " ORDER BY FACILITY_NAME");
	}
	
	
	public static Map<String,String> getPatientClassMap(String locale) throws Exception
	{
	
		String PATIENT_CLASS_WHERE = " WHERE LANGUAGE_ID = '" + locale + "'";
		String PATIENT_CLASS_SQL = BlRepository.getBlKeyValue("PATIENT_CLASS_LIST");
			
		return BLHelper.getCodeDescMap(PATIENT_CLASS_SQL, null, PATIENT_CLASS_WHERE, "", " ORDER BY SHORT_DESC");
	}

	public static Map<String,String> getOptionMap(String locale) throws Exception
	{
	
		String OPTION_WHERE = " AND LANGUAGE_ID = '" + locale + "'";
		String OPTION_SQL = BlRepository.getBlKeyValue("OPTION_LIST");
			
		return BLHelper.getCodeDescMap(OPTION_SQL, null, OPTION_WHERE, "", " ORDER BY A.LIST_SRL_NO");
	}
	
	
	public static Map<String,String> getPaymentBasisIndMap(String locale) throws Exception
	{
	
		String PAYMENT_BASIS_IND_WHERE = " WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) " +
				"AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'BLSGPPYR_PAYMENT_BASIS_IND' AND UPPER(B.LANGUAGE_ID (+)) = '" + locale + "'";
		String PAYMENT_BASIS_IND_SQL = BlRepository.getBlKeyValue("PAYMENT_BASIS_IND_LIST");
			
		return BLHelper.getCodeDescMap(PAYMENT_BASIS_IND_SQL, null, PAYMENT_BASIS_IND_WHERE, "", " ORDER BY A.LIST_SRL_NO");
	}
	
	
	public static String getAccEntityCode(String facilityId, String  languageId) throws Exception
	{
		
		String accEntitySql = "SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY_LANG_VW WHERE  ACC_ENTITY_ID = ?  AND LANGUAGE_ID= ?"; 
		 
		
		Connection connection 		=  ConnectionManager.getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		
		try
		{
			//build the prepared stmt
			pstmt = connection.prepareStatement(accEntitySql);
			
			pstmt.setString(1, facilityId);
			pstmt.setString(2, languageId);
			
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				return rs.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from getColumnDesc()= :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null)connection.close();
			
		}		
		return "";		
	}
	
	public static String fetchCustGroupDesc(String custGrpCode, Connection connection)
			throws Exception {

		String sql = "SELECT SHORT_DESC FROM AR_CUST_GROUP_LANG_VW WHERE CUST_GROUP_CODE = ?";
		return fetchDescription(sql, custGrpCode, connection);
	}
	
	public static String fetchCustDesc(String custCode, Connection connection)
			throws Exception {

		String sql = "SELECT SHORT_NAME FROM AR_CUSTOMER_LANG_VW WHERE CUST_CODE = ?";
		return fetchDescription(sql, custCode, connection);
	}
	
	
	public static String fetchDescription(String sql, String code, Connection connection)
			throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if("**".equals(code))
		{
			return "ALL";
		}
		
		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Exception from fetchDescription()= :" + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return code;
	}

	public static String getDescriptionViaSQL(Connection con,String query,String ...args){

		PreparedStatement pst = null;
		ResultSet rs = null;
		String descriptionResult=new String();	
		
		try {

			pst = con.prepareStatement(query);
			for(int i=0;i<args.length;i++){
			pst.setString(i+1, args[i]);
			}
			rs = pst.executeQuery();

			if (rs.next()) {
				descriptionResult=rs.getString(1);	
			}			

		} catch (Exception e) {
			System.out.println("Exception from getDescriptionViaSQL()= :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return  descriptionResult;		
	}
	
	public static String getSysDate(Connection connection,String format) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sysDate="";
		try {

			pstmt = connection.prepareStatement("select to_char(sysdate,?) from dual");
			pstmt.setString(1,format);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sysDate= rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Exception from fetchDescription()= :" + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

		}
		return sysDate;
	}
	
	public static String getNoOfDecimals(Connection connection){
		String noOfDecimals = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = connection.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				noOfDecimals = rs.getString("no_of_decimal");
			}

		} catch (Exception e) {
			System.err.println("Exception from getNoOfDecimals -> " + e);
			e.printStackTrace();
		} finally {
			try{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			}
			catch(Exception eX){
				eX.printStackTrace();
			}
		}
		return noOfDecimals; 
	}
	
	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
			
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			output = messageId;
		}
		finally{
			pstmt = null;
			try{
			if(rst!=null) rst.close(); // Added against V210416
			}
			catch(Exception e)
			{
				System.err.println("Exception in getMessageString :"+e);
				e.printStackTrace();
			}			
		}
		return output;
	}	
	
	public static boolean comparePatientId(String fromPatId, String toPatId) {		
		int comparedVal = toPatId.compareTo(fromPatId);		
		if(comparedVal >= 0) {
			return true;
		} else {
			return false;
		}
	}

	//Added by Subha on V12022018 for ML-MMOH-CRF-0757
	public static String getTotalOutstAmt(Connection con, String patientid, String facility_id) {
		String outstAmtAllEnc = "";
		String outstAmtQry = "";
		CallableStatement call =null; 
		try {
			outstAmtQry = BlRepository.getBlKeyValue("OUTSTANDING_AMT_ALL_ENCOUNTERS");
			call = con.prepareCall(outstAmtQry);
			call.setString(1, patientid);
			call.setString(2, facility_id);
			call.registerOutParameter(3,java.sql.Types.INTEGER);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.execute();
			outstAmtAllEnc = call.getString(3);
		} catch (Exception e) {
			System.out.println("Exception in OUTSTANDING_AMT_ALL_ENCOUNTERS:"+e);
			e.printStackTrace();
		} finally {
			try {
				if(call != null) {
					call.close();
				}
			} catch(Exception eX) {
				System.out.println("Exception in Connection:"+eX);
				eX.printStackTrace();
			}
		}
		return outstAmtAllEnc;
	}
	
	//Added by Subha on V12022018 for ML-MMOH-CRF-0757
	public static String getTotalUnbilledAmt(Connection con, String facility_id, String patientid, String customerid) {
		String unbilledAmtAllEnc = "";
		String unbilledAmtQry = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			unbilledAmtQry = BlRepository.getBlKeyValue("UNBILLED_AMT_ALL_ENCOUNTERS");
			pstmt = con.prepareStatement(unbilledAmtQry);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patientid);
			pstmt.setString(3, customerid);
			rs = pstmt.executeQuery() ;
			if(rs.next()) {
				unbilledAmtAllEnc = rs.getString(1);
			}
		} catch(Exception e) {
			System.out.println("Exception in UNBILLED_AMT_ALL_ENCOUNTERS:"+e);
			e.printStackTrace();
		} finally {
			try{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				}
				catch(Exception eX){
					System.out.println("Exception in Connection:"+eX);
					eX.printStackTrace();
				}
		}
		return unbilledAmtAllEnc;
	}
	
	//Added by Monika on -- for CRF AAKH-0152-Requirement 3
	public static Map<String, String> getOrderStatusList(Connection con) {
		Map<String,String> oredrStatusList = new HashMap<String,String>();
		String blOrderStatusQry = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			blOrderStatusQry = BlRepository.getBlKeyValue("Bl_Order_Status_List");
			pstmt = con.prepareStatement(blOrderStatusQry);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				oredrStatusList.put(rs.getString("CODE"), rs.getString("DESCRIPTION"));
			}
		} catch(Exception e) {
			System.out.println("Exception in Get Order Status List: "+e);
			e.printStackTrace();
		} finally {
			try{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				}
				catch(Exception eX){
					System.out.println("Exception in Connection:"+eX);
					eX.printStackTrace();
				}
		}
		return oredrStatusList;
	}
	
	public static HashMap getListOfItems(Connection con, String module_id, String list_ref, String locale) {
		String bl_query = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap listItems = new HashMap();
		try 
		{
			bl_query = BlRepository.getBlKeyValue("GET_ITEM_LIST_VALUES");
			pstmt = con.prepareStatement(bl_query);
			pstmt.setString(1, module_id);
			pstmt.setString(2, list_ref);
			pstmt.setString(3, locale);
			rs = pstmt.executeQuery();
			while (rs.next()) {				
				listItems.put(rs.getString("item_id"), rs.getString("item_desc"));
			}
		} catch(Exception e) {
			System.err.println("Exception in getListOfItems: "+e);
			e.printStackTrace();
		} finally {
			try{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				}
				catch(Exception eX){
					System.err.println("Exception1 in getListOfItems:"+eX);
					eX.printStackTrace();
				}
		}
		return listItems;
	}
};
