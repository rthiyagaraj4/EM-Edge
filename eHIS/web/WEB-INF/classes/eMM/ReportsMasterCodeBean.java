/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;



//import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import eCommon.Common.CommonRepository;
import eMM.Common.MmRepository;
import eCommon.SingleTableHandler.*;
import java.util.StringTokenizer;

public class ReportsMasterCodeBean extends eMM.Common.MmAdapter implements java.io.Serializable{

	public String module_id="MM";
 
public ReportsMasterCodeBean() {

	}

	public ArrayList getMasterCodeList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrMasterCode		=	new  ArrayList();
		HashMap		hmMasterCode		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_SM_MASTER_CODE_SELECT_REPORTS")); //Commented by Martin eSS.Common.SsInterface.SQL_SS_SURGERYTYPE_MODIFY
				pstmt.setString(1, module_id);
				resultSet = pstmt.executeQuery();
//				System.err.println("SQL_SM_MASTER_CODE_SELECT_REPORTS : " +MmRepository.getMmKeyValue("SQL_SM_MASTER_CODE_SELECT_REPORTS") + " : " );
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmMasterCode			=	new HashMap();
					
					hmMasterCode.put("code",checkForNull(resultSet.getString(1)));
					hmMasterCode.put("desc",checkForNull(resultSet.getString(2)));
					arrMasterCode.add(hmMasterCode);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrMasterCode;
		}
	
	public String getNature(){
		return getStaticListOptionTag( "B,Both;E,Enabled;D,Disabled;");
	}
	
	public String getOrderByItemAnalysis(){
		return getStaticListOptionTag( "1,Item Analysis Code;3,Item Analysis Description;");
	}

	public String getOrderByItemClass(){
		return getStaticListOptionTag( "1,Item Class Code;3,Item Class Description;");
	}
	public String getOrderByStore(){
		return getStaticListOptionTag( "3,Store Code;5,Store Description;1,Department Code;");
	}
	public String getOrderByBinLocation(){
		return getStaticListOptionTag( "3,Bin Location Code;4,Bin Location Description;");
	}
	public String getReportType(){
		return getStaticListOptionTag( "1,Detail;2,Summary;");
	}
	public String getOrderByItem() {
		return getStaticListOptionTag("1, Item Code;2, Item Description;3, Trade ID;4, Trade Description");
	}

	public String getOrderBySupplier() {
		return getStaticListOptionTag("1, Supplier Code;2, Supplier Description;");
	}

	public String getOrderByMaterial() {
		return getStaticListOptionTag("1, Material Code;2, Description;");
	}
	public String getOrderByTransactionRemarks(){
		return getStaticListOptionTag( "3,Transaction Remarks Code;4,Transaction Remarks Description;");
	}
	public ArrayList getStoreList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrStore		=	new  ArrayList();
		HashMap		hmStore			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_STORE_SELECT")); //Commented by Martin eSS.Common.SsInterface.SQL_SS_SURGERYTYPE_MODIFY
				resultSet = pstmt.executeQuery();
//				System.err.println("SQL_MM_STORE_SELECT : " +MmRepository.getMmKeyValue("SQL_MM_STORE_SELECT") + " : " );
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmStore			=	new HashMap();
					hmStore.put("code",checkForNull(resultSet.getString(1)));
					hmStore.put("desc",checkForNull(resultSet.getString(2)));
					arrStore.add(hmStore);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrStore;
		}

	public ArrayList getModuleList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrModule		=	new  ArrayList();
		HashMap		hmModule			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MODULE_ID")); 
				resultSet = pstmt.executeQuery();
//				System.err.println("SQL_MODULE_ID : " +MmRepository.getMmKeyValue("SQL_MODULE_ID") + " : " );
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmModule			=	new HashMap();
					hmModule.put("code",checkForNull(resultSet.getString(1)));
					hmModule.put("desc",checkForNull(resultSet.getString(2)));
					arrModule.add(hmModule);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrModule;
	}

public ArrayList getTRNTypeList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrModule		=	new  ArrayList();
		HashMap		hmModule			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement("select TRN_TYPE, LONG_DESC from ST_TRN_TYPE"); 
				resultSet = pstmt.executeQuery();
//				System.err.println("SQL_MODULE_ID : " +MmRepository.getMmKeyValue("SQL_MODULE_ID") + " : " );
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmModule			=	new HashMap();
					hmModule.put("code",checkForNull(resultSet.getString(1)));
					hmModule.put("desc",checkForNull(resultSet.getString(2)));
					arrModule.add(hmModule);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrModule;
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}
	public String getStaticListOptionTag(String stStaticList) {
		return getStaticListOptionTag(stStaticList, "");
	}
}
