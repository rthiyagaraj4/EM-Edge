/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// include packages statement
package eOR;

//import necessary packages
import java.io.* ;
import java.util.* ;
import java.sql.*;
import eOR.OROrdersTab.*;
import javax.rmi.* ;
import javax.naming.* ;
import eCommon.SingleTableHandler.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.http.*;

// Class definition starts 
public class OrdersTabBean extends OrAdapter implements Serializable
{
	private String patient_class_desc = "";
	private String patient_class = "";
	private String practitioner_id = "";
	//private String practitioner_desc = "";
	private String func_id = "";
	//private String applicable_yn = "";
	
	private String tabNameForExistOrder = "";
	private String seqNumForExistOrder = "";
	private String tabNameForNewOrder = "";
	private String seqNumForNewOrder = "";
	private String tabNameForFrequentOrders = "";
	private String seqNumForFrequentOrders = "";
	private String tabNameForSearch = "";
	private String seqNumForSearch = "";
	private String tabNameForTickSheet = "";
	private String seqNumForTickSheet = "";
	private String tabNameForOrderSets = "";
	private String seqNumForOrderSets = "";
	private String tabNameForImage = "";
	private String seqNumForImage = "";
	private String tabNameForPlaceOrder = "";
	private String seqNumForPlaceOrder = "";
	
	private String exist_order = "";
	private String new_order = "";
	private String Frequent_Orders = "";
	private String addl_search = "";
	private String tick_sheets = "";
	private String order_sets = "";
	private String image = "";
	private String place_order= "";
	
	
	private String sys_tab_name_existorder = "";
	private String sys_tab_name_neworder = "";
	private String sys_tab_name_FrequentOrders = "";
	private String sys_tab_name_search = "";
	private String sys_tab_name_ticksheets = "";
	private String sys_tab_name_ordersets = "";
	private String sys_tab_name_image = "";
	private String sys_tab_name_placeorder = "";

	Vector sys_tab_names = new Vector();
	Vector user_tab_names = new Vector();
	Vector seq_nos = new Vector();
	Vector applicable_yns = new Vector();
	
	public void setAll(Hashtable hashTable)
	{
		
		if(hashTable.containsKey("mode")) setMode((String)hashTable.get("mode"));
		if(hashTable.containsKey("patient_class_desc")) setPatientDescription((String)hashTable.get("patient_class_desc"));
		if(hashTable.containsKey("patient_class")) setPatientClass((String)hashTable.get("patient_class"));
		if(hashTable.containsKey("practitioner_id")) setPracID((String)hashTable.get("practitioner_id"));
		if(hashTable.containsKey("func_id")) SetFuncId((String)hashTable.get("func_id"));

		if(hashTable.containsKey("tabNameForExistOrder")) setExistTabName((String)hashTable.get("tabNameForExistOrder"));
		if(hashTable.containsKey("seqNumForExistOrder")) setExistSeqNo((String)hashTable.get("seqNumForExistOrder"));
		if(hashTable.containsKey("tabNameForNewOrder")) setNewTabName((String)hashTable.get("tabNameForNewOrder"));
		if(hashTable.containsKey("seqNumForNewOrder")) setNewSeqNo((String)hashTable.get("seqNumForNewOrder"));
		if(hashTable.containsKey("tabNameForFrequentOrders")) setFrequentOrdersTabName((String)hashTable.get("tabNameForFrequentOrders"));
		if(hashTable.containsKey("seqNumForFrequentOrders")) setFrequentOrdersSeqNo((String)hashTable.get("seqNumForFrequentOrders"));
		if(hashTable.containsKey("tabNameForSearch")) setSearchTabName((String)hashTable.get("tabNameForSearch"));
		if(hashTable.containsKey("seqNumForSearch")) setSearchSeqNo((String)hashTable.get("seqNumForSearch"));
		if(hashTable.containsKey("tabNameForTickSheet")) setTickSheetTabName((String)hashTable.get("tabNameForTickSheet"));
		if(hashTable.containsKey("seqNumForTickSheet")) setTickSheetSeqNo((String)hashTable.get("seqNumForTickSheet"));
		if(hashTable.containsKey("tabNameForOrderSets")) setOrderSetTabName((String)hashTable.get("tabNameForOrderSets"));
		if(hashTable.containsKey("seqNumForOrderSets")) setOrderSetSeqNo((String)hashTable.get("seqNumForOrderSets"));
		if(hashTable.containsKey("tabNameForImage")) setImageTabName((String)hashTable.get("tabNameForImage"));
		if(hashTable.containsKey("seqNumForImage")) setImageSeqNo((String)hashTable.get("seqNumForImage"));
		if(hashTable.containsKey("tabNameForPlaceOrder")) setPlaceOrderTabName((String)hashTable.get("tabNameForPlaceOrder"));
		if(hashTable.containsKey("seqNumForPlaceOrder")) setPlaceOrderSeqNo((String)hashTable.get("seqNumForPlaceOrder"));

		if(hashTable.containsKey("exist_order")) setExistOrder((String )hashTable.get("exist_order"));
		if(hashTable.containsKey("new_order")) setNewOrder((String )hashTable.get("new_order"));
		if(hashTable.containsKey("Frequent_Orders")) setFrequentOrders((String )hashTable.get("Frequent_Orders"));
		if(hashTable.containsKey("addl_search")) setAdditionalSearch((String )hashTable.get("addl_search"));
		if(hashTable.containsKey("tick_sheets")) setTickSheets((String )hashTable.get("tick_sheets"));
		if(hashTable.containsKey("order_sets")) setOrderSets((String )hashTable.get("order_sets"));
		if(hashTable.containsKey("image")) setImage((String )hashTable.get("image"));
		if(hashTable.containsKey("place_order")) setPlaceOrder((String )hashTable.get("place_order"));
		
		if(hashTable.containsKey("sys_tab_name_existorder")) setSysTabExistOrder((String )hashTable.get("sys_tab_name_existorder"));
		if(hashTable.containsKey("sys_tab_name_neworder")) setSysTabNewOrder((String )hashTable.get("sys_tab_name_neworder"));
		if(hashTable.containsKey("sys_tab_name_FrequentOrders")) setSysTabFrequentOrders((String )hashTable.get("sys_tab_name_FrequentOrders"));
		if(hashTable.containsKey("sys_tab_name_search")) setSysTabSearch((String )hashTable.get("sys_tab_name_search"));
		if(hashTable.containsKey("sys_tab_name_ticksheets")) setSysTabTickSheets((String )hashTable.get("sys_tab_name_ticksheets"));
		if(hashTable.containsKey("sys_tab_name_ordersets")) setSysTabOrderSets((String )hashTable.get("sys_tab_name_ordersets"));
		if(hashTable.containsKey("sys_tab_name_image")) setSysTabImage((String )hashTable.get("sys_tab_name_image"));
		if(hashTable.containsKey("sys_tab_name_placeorder")) setSysTabPlaceOrder((String )hashTable.get("sys_tab_name_placeorder"));

	}
	public void setSysTabExistOrder(String sys_tab_name_existorder)
	{
		this.sys_tab_name_existorder =  sys_tab_name_existorder.trim();
	}
	public void setSysTabNewOrder(String sys_tab_name_neworder)
	{
		this.sys_tab_name_neworder =  sys_tab_name_neworder.trim();
	}
	public void setSysTabFrequentOrders(String sys_tab_name_FrequentOrders)
	{
		this.sys_tab_name_FrequentOrders =  sys_tab_name_FrequentOrders.trim();
	}
	public void setSysTabSearch(String sys_tab_name_search)
	{
		this.sys_tab_name_search =  sys_tab_name_search.trim();
	}
	public void setSysTabTickSheets(String sys_tab_name_ticksheets)
	{
		this.sys_tab_name_ticksheets =  sys_tab_name_ticksheets.trim();
	}
	public void setSysTabOrderSets(String sys_tab_name_ordersets)
	{
		this.sys_tab_name_ordersets =  sys_tab_name_ordersets.trim();
	}
	public void setSysTabImage(String sys_tab_name_image)
	{
		this.sys_tab_name_image =  sys_tab_name_image.trim();
	}
	public void setSysTabPlaceOrder(String sys_tab_name_placeorder)
	{
		this.sys_tab_name_placeorder =  sys_tab_name_placeorder.trim();
	}
	public void setExistOrder(String exist_order)
	{
		this.exist_order = exist_order.trim();
	}
	public void setNewOrder(String new_order)
	{
		this.new_order = new_order.trim();
	}
	public void setFrequentOrders(String Frequent_Orders)
	{
		this.Frequent_Orders = Frequent_Orders.trim();
	}
	public void setAdditionalSearch(String addl_search)
	{
		this.addl_search = addl_search.trim();
	}
	public void setTickSheets(String tick_sheets)
	{
		this.tick_sheets = tick_sheets.trim();
	}
	public void setOrderSets(String order_sets)
	{
		this.order_sets = order_sets.trim();
	}
	public void setImage(String image)
	{
		this.image = image.trim();
	}
	public void setPlaceOrder(String place_order)
	{
		this.place_order = place_order.trim();
	}
	/*public void setApplicable(String yn)
	{
		this.applicable_yn = yn.trim();
	}*/
	public void setPatientDescription(String patient_desc)
	{
		this.patient_class_desc = patient_desc.trim();
	}
	public void setPatientClass(String patient_class)
	{
		this.patient_class = patient_class.trim();
	}
	public void setPracID(String prac_id)
	{
		this.practitioner_id = prac_id.trim();
	}
	/*public void setPracDesc(String prac_desc)
	{
		this.practitioner_desc = prac_desc.trim();
	}*/
	public void SetFuncId(String func_id)
	{
		this.func_id = func_id.trim();
	}
	public void setExistTabName(String tab_name)
	{
		this.tabNameForExistOrder = tab_name.trim();
	}
	public void setExistSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForExistOrder  = "0";
		else
			this.seqNumForExistOrder = seq_no.trim();
	}
	public void setNewTabName(String tab_name)
	{
		this.tabNameForNewOrder = tab_name.trim();
	}
	public void setNewSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForNewOrder  = "0";
		else
			this.seqNumForNewOrder = seq_no.trim();
	}
	public void setFrequentOrdersTabName(String tab_name)
	{
		this.tabNameForFrequentOrders = tab_name.trim();
	}
	public void setFrequentOrdersSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForFrequentOrders  = "0";
		else
			this.seqNumForFrequentOrders = seq_no.trim();
	}
	public void setSearchTabName(String tab_name)
	{
		this.tabNameForSearch = tab_name.trim();
	}
	public void setSearchSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForSearch  = "0";
		else
			this.seqNumForSearch = seq_no.trim();
	}
	public void setTickSheetTabName(String tab_name)
	{
		this.tabNameForTickSheet = tab_name.trim();
	}
	public void setTickSheetSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForTickSheet  = "0";
		else
			this.seqNumForTickSheet = seq_no.trim();
	}
	public void setOrderSetTabName(String tab_name)
	{
		this.tabNameForOrderSets = tab_name.trim();
	}
	public void setOrderSetSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForOrderSets  = "0";
		else
			this.seqNumForOrderSets = seq_no.trim();
	}
	public void setImageTabName(String tab_name)
	{
		this.tabNameForImage = tab_name.trim();
	}
	public void setImageSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForImage  = "0";
		else
			this.seqNumForImage = seq_no.trim();
	}
	public void setPlaceOrderTabName(String tab_name)
	{
		this.tabNameForPlaceOrder = tab_name.trim();
	}
	public void setPlaceOrderSeqNo(String seq_no)
	{
		if((seq_no == null) || (seq_no == ""))
			this.seqNumForPlaceOrder  = "0";
		else
			this.seqNumForPlaceOrder = seq_no.trim();
	}

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "");

		return map ;
	}

	public HashMap insert()        /************ INSERT METHOD ********************/
	{
		HashMap tabData = new HashMap();
		HashMap sqlData = new HashMap();
		HashMap hashMap = new HashMap();
		try
			{
			sqlData.put( "SQL_OR_INDEX_ORDERTAB_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDERTAB_INSERT") );

			/*Context ctx = new InitialContext();
			Object obj = ctx.lookup( (String ) OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"));
			OROrdersTabHome home = (OROrdersTabHome) PortableRemoteObject.narrow(obj,OROrdersTabHome.class);
			OROrdersTabRemote remote = home.create();*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"), OROrdersTabHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			if(exist_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_existorder);
				user_tab_names.add(tabNameForExistOrder);
				seq_nos.add(seqNumForExistOrder);
				applicable_yns.add(exist_order);
			}
			if(new_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_neworder);
				user_tab_names.add(tabNameForNewOrder);
				seq_nos.add(seqNumForNewOrder);
				applicable_yns.add(new_order);
			}
			if(Frequent_Orders.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_FrequentOrders);
				user_tab_names.add(tabNameForFrequentOrders);
				seq_nos.add(seqNumForFrequentOrders);
				applicable_yns.add(Frequent_Orders);
			}
			if(addl_search.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_search);
				user_tab_names.add(tabNameForSearch);
				seq_nos.add(seqNumForSearch);
				applicable_yns.add(addl_search);
			}
			if(tick_sheets.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_ticksheets);
				user_tab_names.add(tabNameForTickSheet);
				seq_nos.add(seqNumForTickSheet);
				applicable_yns.add(tick_sheets);
			}
			if(order_sets.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_ordersets);
				user_tab_names.add(tabNameForOrderSets);
				seq_nos.add(seqNumForOrderSets);
				applicable_yns.add(order_sets);
			}
			if(image.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_image);
				user_tab_names.add(tabNameForImage);
				seq_nos.add(seqNumForImage);
				applicable_yns.add(image);
			}
			if(place_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_placeorder);
				user_tab_names.add(tabNameForPlaceOrder);
				seq_nos.add(seqNumForPlaceOrder);
				applicable_yns.add(place_order);
			}
			
			tabData.put("patient_class",patient_class);
			tabData.put("patient_class_desc",patient_class_desc);
			tabData.put("practitioner_id",practitioner_id);
			tabData.put("func_id",func_id);
			tabData.put("Added_By_ID",login_by_id);
			tabData.put("Added_At_Ws_No",login_at_ws_no );
			tabData.put("Added_Facility_ID",login_facility_id );
			tabData.put("Modified_By_ID",login_by_id);
			tabData.put("Modified_At_Ws_No",login_at_ws_no);
			tabData.put("Modified_Facility_ID",login_facility_id);
			tabData.put("properties", getProperties());
			tabData.put("sys_tab_name",sys_tab_names);
			tabData.put("user_tab_name",user_tab_names);
			tabData.put("seq_no",seq_nos);
			tabData.put("applicable_yn",applicable_yns);
			
			//hashMap = remote.insert(tabData,sqlData);
			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlData;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlData.getClass();
 			hashMap = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;

			
			sys_tab_names.removeAllElements();
			user_tab_names.removeAllElements();
			seq_nos.removeAllElements();
			applicable_yns.removeAllElements();

			}catch(Exception e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			
		return hashMap;
	}
	
	public HashMap modify()     /************ MODIFY METHOD ********************/
	{
		HashMap tabData = new HashMap();
		HashMap sqlData = new HashMap();
		HashMap hashMap = new HashMap(); 
		
		try
			{
			
			sqlData.put( "SQL_OR_INDEX_ORDERTAB_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDERTAB_INSERT"));
			sqlData.put("SQL_OR_INDEX_ORDERTAB_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDERTAB_DELETE"));

		/*	Context ctx = new InitialContext();
			Object obj = ctx.lookup( OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"));
			OROrdersTabHome home = (OROrdersTabHome) PortableRemoteObject.narrow(obj,OROrdersTabHome.class);
			OROrdersTabRemote remote = home.create();*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"), OROrdersTabHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			if(exist_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_existorder);
				user_tab_names.add(tabNameForExistOrder);
				seq_nos.add(seqNumForExistOrder);
				applicable_yns.add(exist_order);
			}
			if(new_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_neworder);
				user_tab_names.add(tabNameForNewOrder);
				seq_nos.add(seqNumForNewOrder);
				applicable_yns.add(new_order);
			}
			if(Frequent_Orders.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_FrequentOrders);
				user_tab_names.add(tabNameForFrequentOrders);
				seq_nos.add(seqNumForFrequentOrders);
				applicable_yns.add(Frequent_Orders);
			}
			if(addl_search.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_search);
				user_tab_names.add(tabNameForSearch);
				seq_nos.add(seqNumForSearch);
				applicable_yns.add(addl_search);
			}
			if(tick_sheets.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_ticksheets);
				user_tab_names.add(tabNameForTickSheet);
				seq_nos.add(seqNumForTickSheet);
				applicable_yns.add(tick_sheets);
			}
			if(order_sets.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_ordersets);
				user_tab_names.add(tabNameForOrderSets);
				seq_nos.add(seqNumForOrderSets);
				applicable_yns.add(order_sets);
			}
			if(image.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_image);
				user_tab_names.add(tabNameForImage);
				seq_nos.add(seqNumForImage);
				applicable_yns.add(image);
			}
			if(place_order.equalsIgnoreCase("Y"))
			{
				sys_tab_names.add(sys_tab_name_placeorder);
				user_tab_names.add(tabNameForPlaceOrder);
				seq_nos.add(seqNumForPlaceOrder);
				applicable_yns.add(place_order);
			}
			
			tabData.put("patient_class",patient_class);
			tabData.put("patient_class_desc",patient_class_desc);
			tabData.put("practitioner_id",practitioner_id);
			tabData.put("func_id",func_id);
			tabData.put("Added_By_ID",login_by_id);
			tabData.put("Added_At_Ws_No",login_at_ws_no );
			tabData.put("Added_Facility_ID",login_facility_id );
			tabData.put("Modified_By_ID",login_by_id);
			tabData.put("Modified_At_Ws_No",login_at_ws_no);
			tabData.put("Modified_Facility_ID",login_facility_id);
			tabData.put("properties", getProperties());
			tabData.put("sys_tab_name",sys_tab_names);
			tabData.put("user_tab_name",user_tab_names);
			tabData.put("seq_no",seq_nos);
			tabData.put("applicable_yn",applicable_yns);

			//hashMap = remote.modify(tabData,sqlData);
			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlData;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlData.getClass();
 			hashMap = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;

			sys_tab_names.removeAllElements();
			user_tab_names.removeAllElements();
			seq_nos.removeAllElements();
			applicable_yns.removeAllElements();

			}catch(Exception e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		return hashMap;
	}
	public HashMap delete()
	{
		HashMap tabData = new HashMap();
		HashMap sqlData = new HashMap();
		HashMap hashMap = new HashMap(); 
		try
		{
			sqlData.put("SQL_OR_INDEX_ORDERTAB_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDERTAB_DELETE"));
			/*Context ctx = new InitialContext();
			Object obj = ctx.lookup( OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"));
			OROrdersTabHome home = (OROrdersTabHome) PortableRemoteObject.narrow(obj,OROrdersTabHome.class);
			OROrdersTabRemote remote = home.create();*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ORDERS_TAB_JNDI"), OROrdersTabHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			tabData.put("patient_class",patient_class.trim());
			tabData.put("practitioner_id",practitioner_id.trim());
			tabData.put("func_id",func_id.trim());
			tabData.put("properties", getProperties());
			//hashMap = remote.delete(tabData,sqlData);	
			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlData;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlData.getClass();
 			hashMap = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return hashMap;
	}
	public HashMap checkForDuplicates(HashMap tabData)
	{
		HashMap hashMap = new HashMap();

		Vector listOfRecords = new Vector(); // contains all the list of records & details
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String practitioner_id = "";
		String func_id = "";
		String patient_class = "";
		String SQL_OR_INDEX_ORDERTAB_DUPLICATE_CHECK = "";
		String sys_tab_name = "";
		String user_tab_name = "";
		String applicable_yn = "";
		int seq_number = 0;

	try
	{
		if(tabData.isEmpty())
		{
			System.out.println("No Data Available");
			return null;
		}
		else
		{
			practitioner_id = (String)tabData.get("practitioner_id");
			patient_class = (String)tabData.get("patient_class");
			func_id = (String)tabData.get("func_id");
	
			if((practitioner_id!=null) || (practitioner_id != "")) 
				practitioner_id = practitioner_id.trim();
			else 
				practitioner_id = "";

			if((patient_class!=null) || (patient_class != "")) 
				patient_class = patient_class.trim();
			else
				patient_class = "";

			if((func_id!=null) || (func_id != "")) 
				func_id = func_id.trim();
			else
				func_id = "";
		
			SQL_OR_INDEX_ORDERTAB_DUPLICATE_CHECK = OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDERTAB_DUPLICATE_CHECK");
			connection = getConnection();
				
				preparedStatement = connection.prepareStatement(SQL_OR_INDEX_ORDERTAB_DUPLICATE_CHECK);
				preparedStatement.setString(1,practitioner_id);
				preparedStatement.setString(2,patient_class);
				preparedStatement.setString(3,func_id);
				resultSet = preparedStatement.executeQuery(); // execution of the query
	
				while(resultSet.next())
					{
						practitioner_id = resultSet.getString("practitioner_id");
						sys_tab_name = resultSet.getString("sys_tab_name");
						user_tab_name = resultSet.getString("user_tab_name");
						seq_number = resultSet.getInt("seq_no");
						applicable_yn = resultSet.getString("applicable_yn");
						func_id = resultSet.getString("function_id");
	
						listOfRecords.add(practitioner_id);
						listOfRecords.add(sys_tab_name);
						listOfRecords.add(user_tab_name);
						listOfRecords.add(String.valueOf(seq_number));
						listOfRecords.add(applicable_yn);
						listOfRecords.add(func_id);
					}
					
				if(listOfRecords.isEmpty())
					hashMap = null;
				else
					hashMap.put("listOfRecords",listOfRecords);
			}//end of else
		}catch(SQLException sqle)
		{
				sqle.printStackTrace();
				System.err.println(sqle.getMessage());
		}
		catch(Exception e)
		{
				e.printStackTrace();
				System.err.println(e.getMessage());
		}	
		finally
		{
				try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection );
				}catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
		}
		return hashMap;

	} // end of CheckForDuplicates

	
	public ArrayList getPatientClass()
		{
			ArrayList patientClass = new ArrayList();
			Vector shDesc = new Vector(); // for storing all the short descriptions of patients
			Vector patClass = new Vector(); // for storing all the patient classes

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String patient_class_desc = "";
			String patient_class = "";
			String SQL_OR_PATIENT_CLASS_SELECT="";

		try{
			SQL_OR_PATIENT_CLASS_SELECT = OrRepositoryExt.getOrKeyValue("SQL_OR_PATIENT_CLASS_SELECT");
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SQL_OR_PATIENT_CLASS_SELECT);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				patient_class_desc = resultSet.getString("short_desc");
				patient_class = resultSet.getString("patient_class");
				shDesc.add(patient_class_desc);
				patClass.add(patient_class);
			}
		
			patientClass.add(shDesc);
			patientClass.add(patClass);

		}catch(SQLException sqle)
			{
			    System.err.println(sqle.getMessage());
				sqle.printStackTrace();
			}
		catch(Exception e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{  //freeing the memory by closing the connections and resultsets which are opened
				try{
				closeResultSet( resultSet ) ;
				closeStatement( preparedStatement ) ;
				closeConnection( connection );
				}catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}

			return patientClass; //returning the ArrayList Object which contains all the patient details
		}
	
	public String getPhInstall()
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String SQL_OR_CHECK_MODULE_INSTALL_YN="";
		String install_yn = "";
		try{
		SQL_OR_CHECK_MODULE_INSTALL_YN = OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN");
		connection = getConnection();


		preparedStatement = connection.prepareStatement(SQL_OR_CHECK_MODULE_INSTALL_YN);
		preparedStatement.setString(1,"PH");
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			install_yn = resultSet.getString("install_yn");
		}
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
			System.err.println(sqle.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		finally
		{
			try{
			closeResultSet( resultSet ) ;
			closeStatement( preparedStatement ) ;
			closeConnection( connection);
			}catch(Exception e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return install_yn;
	}

}
