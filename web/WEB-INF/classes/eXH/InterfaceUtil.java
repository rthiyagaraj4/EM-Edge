/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import org.apache.commons.lang.StringUtils;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public class InterfaceUtil
{
	public static String buildWhrClause(String[] colNames,String[] colVal)
	{
		StringBuilder whrClause = new StringBuilder();
		int colCount = colNames.length;
		boolean isInitCriteria = true;

		for (int i = 0; i < colCount; i++)
		{
			if(StringUtils.isNotEmpty(colVal[i]))
			{
				if(isInitCriteria) 
				{					
					isInitCriteria = false;					
				}
				else
				{
					whrClause.append(" AND ");
				}
				whrClause.append(colNames[i]);
				whrClause.append("='");
				whrClause.append(colVal[i]);
				whrClause.append("'");
			}			
		}
		if(whrClause.length() > 0) whrClause.insert(0," WHERE ");
		return whrClause.toString();
	}

	public static String isInterfaceProfileExisting(String interfaceProfileId)
	{
		Connection con				= null;
        String profile_id_exists="N";
		CallableStatement checkProfileIdStatement = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String checkProfileIdQuery = "{ ? = call xh_standard_profile_exists(?) }";

				checkProfileIdStatement = con.prepareCall(checkProfileIdQuery);
				checkProfileIdStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
				checkProfileIdStatement.setString(2, interfaceProfileId);
				checkProfileIdStatement.execute();
			
				profile_id_exists = checkProfileIdStatement.getString(1);
		 }
		catch(Exception e)
		{
		    profile_id_exists="N";
			System.out.println("InterfaceUtil::isInterfaceProfileExisting::::Exception in checkProfileIdStatement..."+e);
		}
		finally{
			try{
			 checkProfileIdStatement.close();
			 con.close();
			}
			catch(Exception e)
			{

			}
		}
		return profile_id_exists;
	}

	public static String isInterfaceEnabled(String custGroupCode)
	{
		Connection con				= null;
        String interfaceEnabled="N";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String checkProfileIdQuery = "SELECT INTERFACE_YN FROM AR_CUST_GROUP WHERE CUST_GROUP_CODE= ?";

				pstmt = con.prepareStatement(checkProfileIdQuery);
				pstmt.setString(1, custGroupCode);
				rs = pstmt.executeQuery();
			    while(rs.next())
				{
                   interfaceEnabled = rs.getString("INTERFACE_YN");
				}
		 }
		catch(Exception e)
		{
		    interfaceEnabled="N";
			System.out.println("InterfaceUtil::inInterfaceEnabled::::Exception in pstmt..."+e);
		}
		finally{
			try{
				 pstmt.close();
				 rs.close();
				 con.close();
			}
			catch(Exception e)
			{

			}
		}
		return interfaceEnabled;
	}

	public static String isNationalIdMandFlagEnabled(String custGroupCode)
	{
		Connection con				= null;
        String nationalIdFlagEnabled="N";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String checkProfileIdQuery = "SELECT NATID_MAND_FLAG FROM AR_CUST_GROUP WHERE CUST_GROUP_CODE= ?";

				pstmt = con.prepareStatement(checkProfileIdQuery);
				pstmt.setString(1, custGroupCode);
				rs = pstmt.executeQuery();
			    while(rs.next())
				{
                   nationalIdFlagEnabled = rs.getString("NATID_MAND_FLAG");
				}
		 }
		catch(Exception e)
		{
		    nationalIdFlagEnabled="N";
			System.out.println("InterfaceUtil::nationalIdFlagEnabled::::Exception in pstmt..."+e);
		}
		finally{
			try{
				pstmt.close();
				rs.close();
				con.close();
			}
			catch(Exception e)
			{

			}
		}
		return nationalIdFlagEnabled;
	}

	public static String isVisitRegProcFlagEnabled(String custGroupCode)
	{
		Connection con				= null;
		String visitRegProcFlagEnabled="N";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con =  ConnectionManager.getConnection();
			String checkProfileIdQuery = "SELECT VISIT_REG_PROC_FLAG FROM AR_CUST_GROUP WHERE CUST_GROUP_CODE= ?";

			pstmt = con.prepareStatement(checkProfileIdQuery);
			pstmt.setString(1, custGroupCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   visitRegProcFlagEnabled = rs.getString("VISIT_REG_PROC_FLAG");
			}
		 }
		catch(Exception e)
		{
			visitRegProcFlagEnabled="N";
			System.out.println("InterfaceUtil::visitRegProcFlagEnabled::::Exception in pstmt..."+e);
		}
		finally
		{
			try{
				pstmt.close();
				rs.close();
				con.close();
			}
			catch(Exception e)
			{

			}
		}
		return visitRegProcFlagEnabled;
	}

	public static String checkModuleIdForPayerEligibility(String callingModuleId)
	{
        String moduleIdEnabled="N";
		Connection conn=null;
		boolean result=false;
		  try{
			    conn = ConnectionManager.getConnection();
			    result=eCommon.Common.CommonBean.isSiteSpecific(conn, callingModuleId,"XH_ENABLE_BUPA");
				if(result)
			    {
                  moduleIdEnabled="Y";
			    }
				else
			    {
				  moduleIdEnabled="N";
			    }
		 }
		catch(Exception e)
		{
		    moduleIdEnabled="N";
			System.out.println("InterfaceUtil::checkModuleIdForPayerEligibility::::Exception..."+e);
		}
		finally
		{
			try{
				conn.close();
			}
			catch(Exception e)
			{

			}
		}
		return moduleIdEnabled;
	}

	public static String getBarcodeData(String appId)
	{
		Connection con				= null;
        String barcodeData="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String getBarcodeQuery = "SELECT CLOB_VALUE FROM XM_FILE_CLOB_BLOB WHERE EVENT_TYPE= ?";

				pstmt = con.prepareStatement(getBarcodeQuery);
				pstmt.setString(1, appId);
				rs = pstmt.executeQuery();
			    while(rs.next())
				{
                   barcodeData = rs.getString("CLOB_VALUE");
				}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("InterfaceUtil::inInterfaceEnabled::::Exception in pstmt..."+e);
		}
		finally{
			try{
			 con.close();
			 pstmt.close();
			 rs.close();
			}
			catch(Exception e)
			{

			}
		}
		return barcodeData;
	}

	public static String isPromotionCodeEnabled(String appId)
	{
		Connection con				= null;
        String key3="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String getPromoCodeQuery = "SELECT KEY_3 FROM xh_filter_dms_vw WHERE APPLICATION_ID= ?";

				pstmt = con.prepareStatement(getPromoCodeQuery);
				pstmt.setString(1, appId);
				rs = pstmt.executeQuery();
			    while(rs.next())
				{
                   key3 = rs.getString("KEY_3");
				}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("InterfaceUtil::isPromotionCodeEnabled::::Exception in pstmt..."+e);
		}
		finally{
			try{
			 con.close();
			 pstmt.close();
			 rs.close();
			}
			catch(Exception e)
			{

			}
		}
		return key3;
	}

	public static String getKYCconfigValue()
	{
		Connection con				= null;
        String aadhar_config_enabled_yn="";
		String aadhar_option_value="";
		String result = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  try{
			    con =  ConnectionManager.getConnection();
				String getKYCconfigQuery = "SELECT AADHAR_CONFIG_ENABLED_YN, AADHAR_OPTION_VALUE FROM MP_PARAM WHERE MODULE_ID='MP'";

				pstmt = con.prepareStatement(getKYCconfigQuery);
				rs = pstmt.executeQuery();
			    while(rs.next())
				{
                   aadhar_config_enabled_yn = rs.getString("AADHAR_CONFIG_ENABLED_YN");
				   aadhar_option_value = rs.getString("AADHAR_OPTION_VALUE");
				}

				if("Y".equalsIgnoreCase(aadhar_config_enabled_yn))
			    {
					result = aadhar_option_value;
			    }
				else{
                     
                    result = "validate";
				}

		 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("InterfaceUtil::getKYCconfigValue::::Exception in pstmt..."+e);
		}
		finally{
			try{
			 con.close();
			 pstmt.close();
			 rs.close();
			}
			catch(Exception e)
			{

			}
		}
		return result;
	}


	public static String getTranslationData(String tableId, String appId, String fieldValue)
	{
		Connection con				= null;
		CallableStatement cstmt = null;
		String transValue = "";
		String errorCode = "";
		String errorMsg = "";
		  try{
			    con =  ConnectionManager.getConnection();
				String getTranslationDataQuery = "{ CALL XHTRANSLATION(?,?,?,?,?,?) }";

				cstmt = con.prepareCall(getTranslationDataQuery);
				cstmt.setString(1, tableId);
				cstmt.setString(2, appId);
				cstmt.setString(3, fieldValue);
				cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				cstmt.execute();
				transValue = cstmt.getString(4);
				errorCode = cstmt.getString(5);
				errorMsg = cstmt.getString(6);

		 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("InterfaceUtil::getTranslationData::::Exception in cstmt..."+e);
		}
		finally{
			try{
			 con.close();
			 cstmt.close();
			}
			catch(Exception e)
			{

			}
		}
		return transValue;
	}

	public static int getWaitTime(String profileID)
	{
		Connection con				= null;
        int waitTime = 60;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryCommApplication = "";

		try{
			con =  ConnectionManager.getConnection();

			queryCommApplication = "Select COMM_PROCESS_IDLE_TIME from XH_PROTOCOL a, XH_PROTOCOL_LINK b, XH_INTERACTIVE_CONNECT_PARAM c "
										+ " where a.PROTOCOL_ID = b.PROTOCOL_ID and b.APPLICATION_ID = c.PLUGIN_TYPE and a.PROTOCOL_ID = ?";			

			pstmt = con.prepareStatement(queryCommApplication);
			pstmt.setString(1, profileID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   waitTime = rs.getInt(1);	
			}
		}
		catch(Exception e)
		{
			waitTime = 60;
			System.out.println("InterfaceUtil::getWaitTime :: Exception ::: "+e.getMessage());
		}
		finally{
				try{
					pstmt.close();
					rs.close();
					con.close();
				}
				catch(Exception e)
				{

				}
		}
		return waitTime;
	}
}
