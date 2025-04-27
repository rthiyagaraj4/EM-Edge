/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import eST.Common.StRepository;
import eCommon.Common.CommonBean;
//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StAdapter;
//import eST.Common.StHeaderBean;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;

public class CancelCountSheetBean extends StTransaction implements Serializable{

	private String item_code;
	private String store_code;
	private String facility_id;
	private String phy_inv_id;
	private String Added_Date;
	//private String language_id;
	private ArrayList expDetailsList = new ArrayList();
	private String checkBoxVals;
	private ArrayList deleteDetailsList = new ArrayList();
	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return this.store_code;
	}
/*	public void setLanguageId(String language_id) {
		 this.language_id = language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setcheckBoxVals(String checkBoxVals )
	{
		this.checkBoxVals=checkBoxVals;
		
	}

	public String getcheckBoxVals()
	{
		
		return checkBoxVals;
		
	}

	public ArrayList getArrayCodeList(String facility_id)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
		//ArrayList expDetailsList = new ArrayList();
		facility_id=facility_id;
      //  Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_CANCEL_COUNT_PHY_INV_ID"));
			preparedstatement.setString( 1, facility_id ) ;       
			
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("PHY_INV_ID", CommonAdapter.checkForNull(resultset.getString(1)));
               // hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }
   

public ArrayList getArrayList(String phy_inv_id)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
       // Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_CANCEL_COUNT_STORE"));
			preparedstatement.setString( 1, phy_inv_id ) ;       
			preparedstatement.setString( 2, getLanguageId() ) ;       
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); )
            {
                hashmap = new HashMap();
                hashmap.put("store_code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("short_desc", CommonAdapter.checkForNull(resultset.getString(2)));

				arraylist.add(hashmap);
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }
   


	/*public String getPhysicalInv()
	{

		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_COUNT_PHY_INV_ID"),C1));
	}
	*/
	public String getStore_code_List(){
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),arr_lang));
	}

public ArrayList queryResultDetails(String facility_id,String store_code,String item_code,String phy_inv_id) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList tempDetailsList = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_CANCEL_COUNT_SHEET_QUERY_RESULT") ) ;

			store_code = CommonBean.checkForNull(store_code,"%");
			item_code = CommonBean.checkForNull(item_code,"%");
			phy_inv_id = CommonBean.checkForNull(phy_inv_id,"");
			facility_id = CommonBean.checkForNull(facility_id,"");
			
		
			pstmt.setString( 1, facility_id ) ;
			pstmt.setString( 2, phy_inv_id ) ;
			pstmt.setString( 3, store_code ) ;
			pstmt.setString( 4, item_code ) ;
			pstmt.setString( 5, getLanguageId() ) ;
		

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
		
				dataRow.put("STORE_DESC",resultSet.getString("STORE_DESC")) ;
				dataRow.put("ITEM_CODE",resultSet.getString("ITEM_CODE")) ;
				dataRow.put("ITEM_DESC",resultSet.getString("ITEM_DESC")) ;
				dataRow.put("UOM",resultSet.getString("UOM")) ;
				dataRow.put("STORE_CODE",resultSet.getString("STORE_CODE")) ;
				dataRow.put("PHY_INV_ID",resultSet.getString("PHY_INV_ID")) ;
				dataRow.put("SELECTED",resultSet.getString("SELECTED"));
				tempDetailsList.add(dataRow);
			}
			}

			catch(Exception e) {
				e.printStackTrace();
			}
		
			finally
			{
            try
            {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
			}
			expDetailsList=tempDetailsList;
			return tempDetailsList;
			}

	public void setAll(java.util.Hashtable hashValues) {
			
			//String keyCode="";
			//String selectedKey ="";
			String chk_rec="";

			//java.util.Enumeration hashKeys = hashValues.keys();
			
			
		/*	while (hashKeys.hasMoreElements()) 
				{
				keyCode = (String) hashKeys.nextElement();
					if (keyCode.startsWith("ch"))
					{
						selectedKey = (String) hashValues.get(keyCode);
						if (selectedKey != null && selectedKey.trim().length()>0) 
							{
							chk_rec=(String)hashValues.get("selectedKey");
							}
					}
				}
				*/

			chk_rec=(String)hashValues.get("checkBoxVals");
			facility_id=(String)hashValues.get("facility_id");
			//String chk_rec=getcheckBoxVals( );
		

			StringTokenizer st=new StringTokenizer(chk_rec,",");
			
			int i=0;
			
			while(st.hasMoreTokens())
			{
				
				HashMap h=new HashMap();
				String s1=st.nextToken();
				
				if(s1.equals("Y"))
				{
				h=(HashMap)expDetailsList.get(i);
				h.put("SELECTED","Y");
				deleteDetailsList.add(h);
				}
				i++;
			}
			
			
		
	}
	
	public HashMap insert() {

		
		HashMap hmResult = new HashMap();
		try {

			ArrayList st_phy_del=new ArrayList();
			ArrayList st_hdr_del=new ArrayList();
			ArrayList store_del=new ArrayList();
			ArrayList item_del=new ArrayList();
			ArrayList st_can_cnt=new ArrayList();

			HashMap st_DataMap  = new HashMap();
			HashMap st_SQLMap = new HashMap();

			HashMap hmCommonData=	new HashMap();
			hmCommonData.put("login_by_id", getLoginById());
			hmCommonData.put("login_facility_id", login_facility_id );
			hmCommonData.put("login_at_ws_no", login_at_ws_no);

			
			for(int i=0;i<deleteDetailsList.size();i++)
			{
				
				HashMap st_phy = new HashMap();
				HashMap st_phy_delete = new HashMap();
				st_phy = (HashMap)deleteDetailsList.get(i);
				st_phy_delete.put("facility_id",facility_id);
				st_phy_delete.put("PHY_INV_ID",(st_phy.get("PHY_INV_ID").toString()) );
				phy_inv_id = st_phy.get("PHY_INV_ID").toString();
				st_phy_delete.put("STORE_CODE",(st_phy.get("STORE_CODE").toString()) );
				st_phy_delete.put("ITEM_CODE" , (st_phy.get("ITEM_CODE").toString()) );
				st_phy_del.add(st_phy_delete);
			
			}

				
			Added_Date =getAddedDate(phy_inv_id);
			for(int i=0;i<deleteDetailsList.size();i++)
			{
				HashMap st_hdr = new HashMap();			
				HashMap st_hdr_delete = new HashMap();
				st_hdr = (HashMap)deleteDetailsList.get(i);
				st_hdr_delete.put("facility_id",facility_id);
				st_hdr_delete.put("PHY_INV_ID",(st_hdr.get("PHY_INV_ID").toString()) );
				st_hdr_delete.put("STORE_CODE",(st_hdr.get("STORE_CODE").toString()) );
				st_hdr_delete.put("ITEM_CODE" , (st_hdr.get("ITEM_CODE").toString()) );
				st_hdr_del.add(st_hdr_delete);
				st_hdr_delete.put("PHY_INV_DATE" , Added_Date );
				st_can_cnt.add(st_hdr_delete);
				

			}

			for(int i=0;i<deleteDetailsList.size();i++)
			{
				
				HashMap item_batch=new HashMap();	
				HashMap item_batch_del=new HashMap();
				item_batch = (HashMap)deleteDetailsList.get(i);
			//	item_batch_del.put("phy_inv_id","");
			//	item_batch_del.put("phy_inv_start_qty","");
			//	item_batch_del.put("phy_inv_start_date","");
				item_batch_del.put("PHY_INV_ID",(item_batch.get("PHY_INV_ID").toString()) );
				item_batch_del.put("STORE_CODE",(item_batch.get("STORE_CODE").toString()) );
				item_batch_del.put("ITEM_CODE" , (item_batch.get("ITEM_CODE").toString()) );
				item_del.add(item_batch_del);
			}
			for(int i=0;i<deleteDetailsList.size();i++)
			{
				
				HashMap store_batch=new HashMap();	
				HashMap store_batch_del=new HashMap();
				store_batch = (HashMap)deleteDetailsList.get(i);
			//	store_batch_del.put("phy_inv_id","");
			//	store_batch_del.put("phy_inv_start_qty","");
			//	store_batch_del.put("phy_inv_start_date","");
				store_batch_del.put("PHY_INV_ID",(store_batch.get("PHY_INV_ID").toString()) );
				store_batch_del.put("STORE_CODE",(store_batch.get("STORE_CODE").toString()) );
				store_batch_del.put("ITEM_CODE" , (store_batch.get("ITEM_CODE").toString()) );
				store_del.add(store_batch_del);
			}


			st_SQLMap.put("phy_inv_dtl_delete", getStRepositoryValue("SQL_ST_CANCEL_COUNT_DTL"));
			st_SQLMap.put("phy_inv_hdr_delete", getStRepositoryValue("SQL_ST_CANCEL_COUNT_HDR"));
			st_SQLMap.put("store_batch_update", getStRepositoryValue("SQL_ST_CANCEL_COUNT_STORE_UPDATE"));
			st_SQLMap.put("item_batch_update", getStRepositoryValue("SQL_ST_CANCEL_COUNT_ITEM_UPDATE"));

			st_SQLMap.put("SQL_ST_CANC_PHY_INV_ITEMS", getStRepositoryValue("SQL_ST_CANC_PHY_INV_ITEMS"));
			st_SQLMap.put("SQL_ST_PHY_INV_PARAM_UPDATE_FOR_CANCEL", getStRepositoryValue("SQL_ST_PHY_INV_PARAM_UPDATE_FOR_CANCEL"));
			st_SQLMap.put("SQL_ST_PHY_INV_HDR_SELECT_COUNT", getStRepositoryValue("SQL_ST_PHY_INV_HDR_SELECT_COUNT"));
			st_SQLMap.put("SQL_ST_PHY_INV_DTL_SELECT_COUNT", getStRepositoryValue("SQL_ST_PHY_INV_DTL_SELECT_COUNT"));

			st_DataMap.put("properties",	getProperties());
			st_DataMap.put("st_phy_delete",st_phy_del);
			st_DataMap.put("st_hdr_delete",st_hdr_del);
			st_DataMap.put("store_delete",store_del);
			st_DataMap.put("item_delete",item_del);
			st_DataMap.put("st_can_cnt",st_can_cnt); // Added on 1/20/2005 for cancel count sheet
						
			st_DataMap.put("CommonData",hmCommonData);
			

			/*
		eST.CondemnExpiredBatches.CondemnExpiredBatchesRemote condemnExpiredBatchesremote = null;
			InitialContext initialcontext = new InitialContext();
			Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_CONDEMN_EXPIRED_BATCHES"));
			eST.CondemnExpiredBatches.CondemnExpiredBatchesHome condemnExpiredBatcheshome = (eST.CondemnExpiredBatches.CondemnExpiredBatchesHome)PortableRemoteObject.narrow(obj1, eST.CondemnExpiredBatches.CondemnExpiredBatchesHome.class);
			condemnExpiredBatchesremote = condemnExpiredBatcheshome.create();
			hmResult = condemnExpiredBatchesremote.insert(hmDataMap, hmSQLMap); 

				*/

			//eST.CancelCountSheet.CancelCountSheetRemote cancelCountSheetremote = null;
			/*InitialContext initialcontext = new InitialContext();
			Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_COUNT_CANCEL_SHEET"));
			eST.CancelCountSheet.CancelCountSheetHome cancelCountSheethome = (eST.CancelCountSheet.CancelCountSheetHome)PortableRemoteObject.narrow(obj1, eST.CancelCountSheet.CancelCountSheetHome.class);
			cancelCountSheetremote = cancelCountSheethome.create();
			// Added on 1/20/2005  for inserting records into Cancel count sheet table
			hmResult = cancelCountSheetremote.insert(st_DataMap, st_SQLMap); */

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_COUNT_CANCEL_SHEET"),eST.CancelCountSheet.CancelCountSheetHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = st_DataMap;
			argArray[1] = st_SQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = st_DataMap.getClass(); ;
			paramArray[1] = st_SQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		//	eST.CondemnExpiredBatches.CondemnExpiredBatchesRemote condemnExpiredBatchesremote = null;
		//	hmResult = new eST.CancelCountSheet.CancelCountManager().insert( st_DataMap, st_SQLMap ) ;
			expDetailsList=new ArrayList();
			deleteDetailsList=new ArrayList();

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return hmResult;
	}



	public boolean validateCheckedCount(java.util.Hashtable hashValues) {
		String keyCode = "";
		String selectedKey ="";
		ArrayList alCheckedItems = new ArrayList();

		java.util.Enumeration hashKeys = hashValues.keys();

		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("t")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					alCheckedItems.add(selectedKey);
				}
			}
		}

		if(alCheckedItems.size() > 0) {
			return true;
		}
		else {
			return false;
		}

	}


	public void clear()
	{
	this.item_code="";
	this.store_code="";
	expDetailsList=new ArrayList();
	deleteDetailsList=new ArrayList();
	//tempDetailsList=new ArrayList();
	this.phy_inv_id="";
	this.facility_id="";
	}
public String getAddedDate(String phy_inv_id) throws Exception
	{
		String AddedDate ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//ArrayList tempDetailsList = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_PHY_INV_HDR_SELECT_DATE") ) ;
			pstmt.setString( 1, phy_inv_id ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
				{
					AddedDate =resultSet.getString("ADDED_DATE");
				}
			}

			catch(Exception e) {
				e.printStackTrace();
			}
		
			finally
			{
            try
            {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
			}
		
			return AddedDate;
			}
	public int colourReturn(String item_code,String phy_inv_id){
		ArrayList alParameters =  new ArrayList();
		String count = "1";
		alParameters.add(this.store_code);
		alParameters.add(item_code);
		try{
		//fetchRecord(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_DATE"),arr_count);
			count = (String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ITEM_BATCH WHERE STORE_CODE = ? AND ITEM_CODE = ?",alParameters)).get("COUNT");
			alParameters = new ArrayList();
			alParameters.add(login_facility_id);
			alParameters.add(this.store_code);
			alParameters.add(item_code);
			alParameters.add(phy_inv_id);
			HashMap hmResult = (HashMap)fetchRecord("SELECT COUNT(*) COUNT,ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL WHERE FACILITY_ID = ? AND STORE_CODE = ? AND ITEM_CODE = ? AND PHY_INV_ID = ? AND ITEM_QTY IS NOT NULL GROUP BY ENTRY_COMPLETED_YN",alParameters);
			if(!count.equals("0")&&(checkForNull((String)hmResult.get("COUNT"),"0")).equals("0")){
				return 3;
			}
			if(!(checkForNull((String)hmResult.get("COUNT"),"0")).equals("0")&&(checkForNull((String)hmResult.get("ENTRY_COMPLETED_YN"),"N")).equals("N")){
				return 2;
			}
			if(!(checkForNull((String)hmResult.get("COUNT"),"0")).equals("0")&&(checkForNull((String)hmResult.get("ENTRY_COMPLETED_YN"),"N")).equals("Y")){
				return 4;
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
	}

}
