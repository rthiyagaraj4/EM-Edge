/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;

import java.io.Serializable;
import java.util.*;
//import java.util.Hashtable;
//import java.util.HashMap;
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;
import eMM.Common.MmAdapter;
//import eMM.Common.MmRepository;
import java.sql.* ;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;
//import eCommon.Common.CommonRepository;

/**
* Class representing the state and behaviour of the Trade name for Item function.
* It extends MmAdapter, a module specific adapter class.
*/

public class TradeNameForItemBean extends MmAdapter implements Serializable { 
	/* Variable to hold the Item Code*/
	private String item_code="";
	/* Variable to hold the Short description of the Item*/
	private String item_desc="";
	/* Variable to hold the Trade ID*/
	private String trade_id="";
	/* Variable to hold the Short description of the Trade corresponding to the Trade ID*/
	private String trade_name="";
	/* Variable to hold the Manufacturer ID corresponding to the Trade ID*/
	private String manufacturer_id="";
	/* Variable to hold the Manufacturer Name corresponding to the Manufacturer ID*/
	private String manufacturer_name="";

	/* ArrayList to hold the details of the records retrived corresponding to the entered
	Item Code.*/
	private ArrayList DataList = new ArrayList();
	/* Variable to hold the HttpSession. This is used to make the bean session-aware.*/

	protected String SelectSQL;
	//protected String language_id;

	private ArrayList tradeNameForItemList = new ArrayList ();
		
	/*Setter and getter method for Item Code */

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_code() {
		return item_code;
	}
	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId() 
	{
		return this.language_id;
	}*/
	/*Setter and getter method for Item Description */

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public String getItem_desc() {
		return item_desc;
	}

	/*Setter and getter method for Trade ID */

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}

	public String getTrade_id() {
		return trade_id;
	}

	/*Setter and getter method for Trade Name */

	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}

	public String getTrade_name() {
		return trade_name;
	}

	/*Setter and getter method for Manufacturer ID */

	public void setManufacturer_id(String manufacturer_id) {
		this.manufacturer_id	= manufacturer_id;
	}

	public String getManufacturer_id() {
		return manufacturer_id;
	}

	/*Setter and getter method for Manufacturer Name */

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name	= manufacturer_name;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	/* Method to get the list of records related to the entered Item Code 
	* @return ArrayList The list of records related to the entered Item Code
	*/

	public ArrayList getDataList() {
		return DataList;
	}

	public void setTradeNameForItemList (ArrayList p_tradeNameForItemList) {
		tradeNameForItemList = p_tradeNameForItemList;
	}

	public ArrayList getTradeNameForItemList () {
		return tradeNameForItemList;
	}

	/* Methods to set the values for all the fields using the HashTable passed
	*@param htRecordSet, Hashtable containing values for all the fields.
	*/

	public void setAll(Hashtable htRecordSet) {
		setItem_code((String) htRecordSet.get("item_code"));
		setItem_desc((String) htRecordSet.get("item_desc"));
		setTrade_id((String) htRecordSet.get("trade_id"));
		setTrade_name((String) htRecordSet.get("trade_name"));
		setManufacturer_id((String) htRecordSet.get("manufacturer_id"));
		setManufacturer_name((String) htRecordSet.get("manufacturer_name"));
		setMode("1");
	}

	/* Method used to clear all the fields */

	public void clear() {
		super.clear();
		setItem_code("");
		setItem_desc("");
		setTrade_id("");
		setTrade_name("");
		setManufacturer_id("");
		setManufacturer_name("");
	}

	/* Method to retrive the Manufacturer details for the given trade ID 
	*@param trade_id, The Trade ID to which the manufacturer details has to be retrived.
	*@return HashMap, The details of the Manufacturer retrived. This contains only the Name 
	* and ID.
	*/

	public HashMap getManufacturerDetails(String trade_id) {
		HashMap manufacturer_details = new HashMap();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getMmRepositoryValue("SQL_AM_MANUFACTURER_DETAILS_SELECT") ) ;
//			System.out.println(pstmt); 
			pstmt.setString (1,trade_id) ;
			pstmt.setString (2,getLanguageId()) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()) {
				manufacturer_details.put("MANUFACTURER_ID",resultSet.getString( "manufacturer_id" ));
				manufacturer_details.put("MANUFACTURER_NAME",resultSet.getString( "manufacturer_name" ));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {			
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			es.printStackTrace();
			}
		}
		return manufacturer_details;
	}


	public void loadData(String item_code) throws Exception {
	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		DataList = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(getMmRepositoryValue("SQL_MM_TRADE_NAME_FOR_ITEM_SELECT") ) ;
			pstmt.setString( 1, item_code ) ;
			pstmt.setString( 2, getLanguageId() ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();
				dataRow.put( "ITEM_CODE",resultSet.getString( "item_code" ) ) ;
				dataRow.put( "ITEM_DESC",resultSet.getString( "item_name" ) ) ;
				dataRow.put( "TRADE_ID",resultSet.getString( "trade_id" ) ) ;
				dataRow.put( "TRADE_NAME",resultSet.getString( "trade_name" ) ) ;
				dataRow.put( "MANUFACTURER_ID",resultSet.getString( "manufacturer_id" ) ) ;
				dataRow.put( "MANUFACTURER_NAME",resultSet.getString( "manufacturer_name") );
				dataRow.put( "MODE","2" );
				dataRow.put( "ADD",new Boolean(false));
				DataList.add(dataRow);
			}						
		} catch ( Exception e )	{
			DataList.add(e.toString());
			e.printStackTrace() ;			
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}		
	}

	public void initialize(HashMap hmTradeNameForItem) {
		setItem_code	(hmTradeNameForItem.get("ITEM_CODE").toString()	);
		setItem_desc	(hmTradeNameForItem.get("ITEM_DESC").toString() );
		setTrade_id		(hmTradeNameForItem.get("TRADE_ID").toString()	);
		setTrade_name	(hmTradeNameForItem.get("TRADE_NAME").toString() );
		setManufacturer_id	(hmTradeNameForItem.get("MANUFACTURER_ID").toString() );
		setManufacturer_name	(hmTradeNameForItem.get("MANUFACTURER_NAME").toString() );
	}

	public String toString() {
		return 
			" |Trade ID					"+	trade_id				+
			"||Trade Name				"+	trade_name				;
	}

	public String[] getArray(String string, String delimeter) {
		String[] stArReturn=null;
		StringTokenizer stTokens=new StringTokenizer(string,delimeter);
		stArReturn=new String[stTokens.countTokens()];
		for (int i=0 ;i<stArReturn.length ;i++ ) {
			stArReturn[i]=stTokens.nextToken();
		}
		return stArReturn;
	}

	public boolean isTradeIdInArrayList(ArrayList itemArrayList,String tradeID,int index) {
		boolean result = false;
		//String value = null;
		
	/*	if(itemArrayList!=null) {
//			value = itemArrayList.toString();
		}*/
		try {
			for (int i=0;i<itemArrayList.size();i++) {
				if (index == i) {
					continue;
				}
				if (((HashMap)itemArrayList.get(i)).get("TRADE_ID").toString().equals(tradeID) ) {
					result=true;
					break;
				}
			}
		}
		catch (Exception e) {
				e.printStackTrace();
//			value = e.toString();
		}
		return result;
	}
	
	/* Not sure of. need to be checked.*/

	public HashMap validate() {
		HashMap hmReturn = new HashMap();
		hmReturn.put("result",new Boolean(true));
		hmReturn.put("message","success");
		return hmReturn;
	}


	public boolean isValidTradeID(String trade_id) throws Exception {
		boolean result = false;
		try {
			HashMap hmResult= fetchRecord(getMmRepositoryValue("SQL_AM_TRADE_NAME_CHECK"),trade_id);
			int count = Integer.parseInt((String)hmResult.get("COUNT"));
			if(count != 0) {
				result = true;	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	
	public HashMap insert() {
		HashMap result = new HashMap() ;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;

		ArrayList insertData	=	new ArrayList() ;
		ArrayList whereData		=	new ArrayList()	;
		ArrayList LanguageData = new ArrayList() ;

		result.put("result",new Boolean(true));
		result.put("message","Mart");
		result.put("flag","true");
		//result.put("tradeList", getTradeNameForItemList());

		try {
			if(tradeNameForItemList != null) {
				int size	=	tradeNameForItemList.size();
	
				for(int i=0;i<size;i++) {
					HashMap tradeNameForItemRow	= (HashMap)tradeNameForItemList.get(i);
					ArrayList insertRow		=	new ArrayList();
					if(((Boolean)tradeNameForItemRow.get("ADD")).booleanValue() != false) {
						insertRow.add((String)tradeNameForItemRow.get("ITEM_CODE"));	
						insertRow.add((String)tradeNameForItemRow.get("TRADE_ID"));	
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertData.add(insertRow);
							}
				}	

				sqlMap.put( "InsertSQL", getMmRepositoryValue("SQL_MM_TRADE_NAME_FOR_ITEM_INSERT") );
				sqlMap.put( "SelectSQL", SelectSQL); 
				LanguageData.add(getLanguageId());
				tabData.put( "properties",getProperties() );
				tabData.put( "InsertData",insertData);	
				tabData.put( "WhereData", whereData);
					tabData.put( "LanguageData",LanguageData);
								
//				SingleTableHandlerHome singleTableHandlerHome = null;
//				SingleTableHandlerRemote	singleTableHandlerRemote	= null;

			/*	InitialContext context = new InitialContext();
				Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
				result.put( "object",object) ;
				if(object != null) {
					singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
				}

				singleTableHandlerRemote = singleTableHandlerHome.create();

				result = singleTableHandlerRemote.singleBatchHandler(tabData, sqlMap);*/
//				System.err.println("result from EJB : "+result);		

				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				 result = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) result.get( "result" )).booleanValue() ) {
//					System.out.println("msgid when the result is true : "+(String) result.get( "msgid" ));
					result.put( "message", getMMMessage(getLanguageId(),(String) result.get( "msgid" ),"ST") ) ;

				}
				else {
					if( ((String)result.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ) {

//						System.out.println("msgid when the result is false : "+(String) result.get( "msgid" ));

						String msgID =  getMMMessage(getLanguageId(),(String) result.get( "msgid" ),"ST") ;
						msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;

						result.put( "message", msgID  ) ;
						result.put( "invalidCode", delimitedString( (ArrayList)result.get("invalidCode")) ) ;
					} 
					else {
						result.put( "message", (result.get("msgid"))) ;
					}
				}
			}
			
		}
		catch (Exception e) {
			result.put("flag",e.toString());
			e.printStackTrace() ;
		}	
/*		finally {
			try {
			} 
			catch( Exception ee ) {
				result.put( "message",ee.toString() ) ;
			}
		}*/
		return result;
	}	
	
	//Added for MOHE-CRF-0167 US001
	public boolean getSite(){
		Connection connection	 = null;  
		boolean site			 = false;
	    try {
				  
				connection = getConnection();
				site = eCommon.Common.CommonBean.isSiteSpecific(connection, "MM","MM_TRADE_NAME_FOR_ITEM");	
			}
			catch(Exception ex){
				ex.printStackTrace();
			} 
			finally{
				try{
					closeConnection(connection);
				} catch(Exception e) 
				{	
					e.printStackTrace();
				}
			}
		return site;
	}	
	//Added for  MOHE-CRF-0167 US001
}



	
