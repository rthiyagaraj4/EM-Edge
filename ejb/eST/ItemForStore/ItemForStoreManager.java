/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B								GHL-CRF-0456
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172

---------------------------------------------------------------------------------------------------------
*/
package eST.ItemForStore;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="ItemForStore"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ItemForStore"
*	local-jndi-name="ItemForStore"
*	impl-class-name="eST.ItemForStore.ItemForStoreManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ItemForStore.ItemForStoreLocal"
*	remote-class="eST.ItemForStore.ItemForStoreRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ItemForStore.ItemForStoreLocalHome"
*	remote-class="eST.ItemForStore.ItemForStoreHome"
*	generate= "local,remote"
*
*
*/

public class ItemForStoreManager extends StEJBSessionAdapter {

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL)  { //throws RemoteException
        Connection connection = null;
		Properties properties=null;

		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
//		HashMap		hmArgSQL	=	new HashMap();
		HashMap		hmArgData1	=	new HashMap();
		HashMap		hmArgSQL1	=	new HashMap();
		hmArgData				=	(HashMap)hmData.get("InsertData");

		
		ArrayList totalinsertRecords	= new ArrayList();

		hmResult.put("result", FALSE);
		//boolean	  flag				= false;

        try{
           properties						= (Properties)hmData.get("properties");
		   connection						= getConnection(properties);
		   connection.setAutoCommit(false);
		

			for(int i=0;i<hmArgData.size();i++)
			{
				HashMap recordValues	= new HashMap();
				recordValues			= (HashMap)hmArgData.get(i+"");
				ArrayList insertRecord	= new ArrayList();
				//for(int j=0;j<recordValues.size();j++)
				//{
					insertRecord.add(recordValues.get("store_code"));
					insertRecord.add(recordValues.get("item_code"));
					insertRecord.add(recordValues.get("bin_location_code"));
					insertRecord.add(recordValues.get("stock_yn"));
					insertRecord.add(recordValues.get("min_stock_qty"));
					insertRecord.add(recordValues.get("max_stock_qty"));
					insertRecord.add(recordValues.get("reorder_level"));
					insertRecord.add(recordValues.get("reorder_freq_days"));
					insertRecord.add(recordValues.get("getlead_days"));
					insertRecord.add(recordValues.get("min_stock_days"));
					insertRecord.add(recordValues.get("min_percentage"));
					insertRecord.add(recordValues.get("reorder_qty"));
					insertRecord.add(recordValues.get("log_in_id"));
					insertRecord.add(recordValues.get("login_at_ws_no"));
					insertRecord.add(recordValues.get("login_facility_id"));
					insertRecord.add(recordValues.get("log_in_id"));
					insertRecord.add(recordValues.get("login_at_ws_no"));
					insertRecord.add(recordValues.get("login_facility_id"));
					insertRecord.add(recordValues.get("req_gen_stage"));
					insertRecord.add(recordValues.get("req_uom"));
					insertRecord.add(recordValues.get("get_issue_uom"));
					//added for phyinv type and count per year by Jagadeesh 20/10/2004 
					insertRecord.add(recordValues.get("phy_inv_type"));
					insertRecord.add(recordValues.get("phy_inv_count_per_year"));
					insertRecord.add(recordValues.get("sales_allowed_yn"));//Added for GHL-CRF-0456 
					insertRecord.add(recordValues.get("consumption_allowed_yn"));//Added for GHL-CRF-0456 
					insertRecord.add(recordValues.get("near_expiry_appl"));//Added for MMS-DM-CRF-0177
					insertRecord.add(recordValues.get("durn_value"));//Added for MMS-DM-CRF-0177
					insertRecord.add(recordValues.get("durn_type"));//Added for MMS-DM-CRF-0177
					insertRecord.add(recordValues.get("durn_value_in_days"));//Added for MMS-DM-CRF-0177
					insertRecord.add(recordValues.get("no_of_days"));//Added for MO-CRF-20172  
                    
					totalinsertRecords.add(insertRecord);
					System.out.println("totalinsertRecords: "+totalinsertRecords);
					System.out.println("hmSQL: "+hmSQL);
				//} 
			}
				hmArgData1.put(DATA,totalinsertRecords);
				hmArgSQL1.put(BATCH_SQL,hmSQL.get("SQL_ST_ITEM_STORE_INSERT"));

				hmResult	=	operateBatch(connection, hmArgData1, hmArgSQL1);
				throwExceptionWhenFailed(hmResult);
			// Records inserted into st_item_store_bin_locn
			{
				HashMap binHmArgData		= new HashMap();
				binHmArgData				=	(HashMap)hmData.get("InsertData");
				ArrayList bininsertRecords	= new ArrayList();
				HashMap	  count				= new HashMap();
				HashMap	  hmArgData2		= new HashMap();
				HashMap	  hmArgSQL2			= new HashMap();
					for(int i=0;i<binHmArgData.size();i++)
					{
						HashMap recordValues	= new HashMap();
						recordValues			= (HashMap)binHmArgData.get(i+"");
						ArrayList insertBinRecord	= new ArrayList();

						String alParameters[] = {(String)recordValues.get("item_code"),(String)recordValues.get("store_code")};
						try{
							count = fetchRecord(connection,(String)hmSQL.get("SQL_ST_ITEM_STORE_BIN_LOCN_COUNT"),alParameters);
						}catch(Exception e)
						{
							count = new HashMap();
							count.put("BIN_LOCATION_CODE","1");
						}
						String bin_location_code = (String)recordValues.get("bin_location_code");

					//if(Integer.parseInt((String)count.get("BIN_LOCATION_CODE")) == 0 && (bin_location_code.length()) > 1 )
//The Above line is commented by Mahesh on 9/12/2008(MM/DD/YYYY) because checking with >1 is wrong in case of length of a String. if the Code has only one character, then this condition may Fail
					if(Integer.parseInt((String)count.get("BIN_LOCATION_CODE")) == 0 && (bin_location_code.length()) > 0 )
					{
						
			//			flag = true;
						insertBinRecord.add(recordValues.get("store_code"));
						insertBinRecord.add(recordValues.get("item_code"));
						insertBinRecord.add(recordValues.get("bin_location_code"));
						insertBinRecord.add(recordValues.get("log_in_id"));
						insertBinRecord.add(recordValues.get("login_at_ws_no"));
						insertBinRecord.add(recordValues.get("login_facility_id"));
						insertBinRecord.add(recordValues.get("log_in_id"));
						insertBinRecord.add(recordValues.get("login_at_ws_no"));
						insertBinRecord.add(recordValues.get("login_facility_id"));
						insertBinRecord.add("Y");
						bininsertRecords.add(insertBinRecord);
					
				       }
				    }
					hmArgData2.put(DATA,bininsertRecords);
					hmArgSQL2.put(BATCH_SQL,hmSQL.get("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT"));
					hmResult	=	operateBatch(connection, hmArgData2, hmArgSQL2);
					throwExceptionWhenFailed(hmResult);
			}
				connection.commit();
					
	if (connection!=null) {
					closeConnection(connection,properties);	
				}
		
		
		}
		catch (Exception exception) {
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}
		finally {
			 try{
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}

		

	return hmResult;
}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public HashMap modify(HashMap hmData, HashMap hmArgSQL) { // throws RemoteException

          Connection connection = null;
		Properties properties=null;

		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		
		//ArrayList totalinsertRecords	= new ArrayList();
		hmArgData = (HashMap)hmData.get("ModifyData");
		hmResult.put("result", FALSE);
	//	boolean	  flag				= false;

        try{
           properties						= (Properties)hmData.get("properties");

		   connection						= getConnection(properties);
		   connection.setAutoCommit(false);
		
			
				HashMap recordValues	= new HashMap();
				recordValues			= (HashMap)hmArgData.get("1");
				ArrayList updateRecord	= new ArrayList();
				{
					updateRecord.add(recordValues.get("bin_location_code"));
					updateRecord.add(recordValues.get("stock_yn"));
					updateRecord.add(recordValues.get("min_stock_qty"));
					updateRecord.add(recordValues.get("max_stock_qty"));
					updateRecord.add(recordValues.get("reorder_level"));
					updateRecord.add(recordValues.get("reorder_freq_days"));
					updateRecord.add(recordValues.get("getlead_days"));
					updateRecord.add(recordValues.get("min_stock_days"));
					
					updateRecord.add(recordValues.get("min_percentage"));					
					updateRecord.add(recordValues.get("log_in_id"));
					updateRecord.add(recordValues.get("login_at_ws_no"));
					updateRecord.add(recordValues.get("login_facility_id"));

					updateRecord.add(recordValues.get("req_gen_stage"));
					updateRecord.add(recordValues.get("req_uom"));
					updateRecord.add(recordValues.get("get_issue_uom"));
					updateRecord.add(recordValues.get("eff_status"));
					// added by Jagadeesh on 19/10/2004 
					updateRecord.add(recordValues.get("get_phy_inv_type"));
					updateRecord.add(recordValues.get("get_phy_inv_count_per_year"));
					updateRecord.add(recordValues.get("reorder_qty"));
					updateRecord.add(recordValues.get("sales_allowed_yn"));//Added for GHL-CRF-0456 
					updateRecord.add(recordValues.get("consumption_allowed_yn"));//Added for GHL-CRF-0456 

					
					updateRecord.add(recordValues.get("near_expiry_appl"));//Added for MMS-DM-CRF-0177
					updateRecord.add(recordValues.get("durn_value"));//Added for MMS-DM-CRF-0177
					updateRecord.add(recordValues.get("durn_type"));//Added for MMS-DM-CRF-0177
					updateRecord.add(recordValues.get("durn_value_in_days"));//Added for MMS-DM-CRF-0177
					updateRecord.add(recordValues.get("no_of_days")); //MO-CRF-20172
					
					updateRecord.add(recordValues.get("store_code"));
					updateRecord.add(recordValues.get("item_code"));
					
			

				   

					hmArgData.put(DATA,updateRecord);
					hmArgSQL.put(UPDATE_SQL,hmArgSQL.get("SQL_ST_ITEM_STORE_UPDATE"));

					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}
				
			{
				ArrayList bininsertRecords	= new ArrayList();
				HashMap	  count				= new HashMap();
				HashMap	  insertSQL2		= new HashMap();
				//HashMap updateRecordValues	= new HashMap();
				HashMap hmArgData2			= new HashMap();

				//updateRecordValues			= (HashMap)hmArgData.get("1");
				ArrayList insertBinRecord	= new ArrayList();
				String []alParameters		= {(String)recordValues.get("item_code"),(String)recordValues.get("store_code"),(String)recordValues.get("bin_location_code")};
				try{
					 count = fetchRecord(connection,(String)hmArgSQL.get("SQL_ST_ITEM_STORE_MODIFY_BIN_LOCN_COUNT"),alParameters);
				}catch(Exception e)
				{
					e.printStackTrace();
					count = new HashMap();
					count.put("BIN_LOCATION_CODE","1");
				}
				String bin_location_code = (String)recordValues.get("bin_location_code");
				//if(Integer.parseInt((String)count.get("BIN_LOCATION_CODE")) == 0 &&(bin_location_code.length() > 1) )
//The Above line is commented by Mahesh on 9/12/2008(MM/DD/YYYY) because checking with >1 is wrong in case of length of a String. if the Code has only one character, then this condition may Fail
				if(Integer.parseInt((String)count.get("BIN_LOCATION_CODE")) == 0 &&(bin_location_code.length() > 0) )
				{
//						flag	 = true;
						insertBinRecord.add(recordValues.get("store_code"));
						insertBinRecord.add(recordValues.get("item_code"));
						insertBinRecord.add(recordValues.get("bin_location_code"));
						insertBinRecord.add(recordValues.get("log_in_id"));
						insertBinRecord.add(recordValues.get("login_at_ws_no"));
						insertBinRecord.add(recordValues.get("login_facility_id"));
						insertBinRecord.add(recordValues.get("log_in_id"));
						insertBinRecord.add(recordValues.get("login_at_ws_no"));
						insertBinRecord.add(recordValues.get("login_facility_id"));
						insertBinRecord.add("Y");
						bininsertRecords.add(insertBinRecord);

					
					hmArgData2.put(DATA,bininsertRecords);

					insertSQL2.put(BATCH_SQL,hmArgSQL.get("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT"));
					hmResult	=	operateBatch(connection, hmArgData2, insertSQL2);
					throwExceptionWhenFailed(hmResult);
					
					}
				}
				
					connection.commit();
			if (connection!=null) {
					closeConnection(connection,properties);	
				}
				
		}
		catch (Exception exception) {
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			hmResult.put(MSGID,exception.getMessage());

			exception.printStackTrace();
		}
		finally {
			 try{
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}

		return hmResult;
	
    }

    /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap delete(HashMap hashmap, HashMap hashmap1)  { //throws RemoteException
        return getMessageHashMap(false);
    }

}
