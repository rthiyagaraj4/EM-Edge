/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.CommonRepository;
import ePO.Common.PoRepository;
import eCommon.SingleTableHandler.*;
 
public class MultipleInsertPurchaseUnitBean extends ePO.Common.PoAdapter implements java.io.Serializable{

	private int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	//private String master_type ;
	private String []unit_code = new String[RECORD_SIZE];
	private String []long_desc  = new String[RECORD_SIZE];
	private String []short_desc = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];
	private String []global_unit = new String[RECORD_SIZE];
	private String []supp_address_1 = new String[RECORD_SIZE];
	private String []supp_address_2 = new String[RECORD_SIZE];
	private String []supp_address_3 = new String[RECORD_SIZE];

	protected String InsertSQL;
	protected String ModifySQL;
	protected String SelectSQL;
	protected String UpdateSQL;
	protected String codeFieldName;
	
	public MultipleInsertPurchaseUnitBean() {

	}

	/* Set Methods Start */
	public void setUnit_code(int index, String unit_code) {
			this.unit_code[index]		=	(unit_code != null)?unit_code.toUpperCase():null; 
	}

	public void setLong_desc(int index, String long_desc) {
			this.long_desc[index]		=	long_desc; 
	}

	public void setShort_desc(int index, String short_desc) {
			this.short_desc[index]		=	short_desc; 
	}
	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]		=	eff_status;//checkForNull(eff_status,"D");
	}
	public void setGlobal_unit(int index, String global_unit) {
			this.global_unit[index]		=	global_unit;//checkForNull(global_unit,"N");
	}

	public void setSupp_Address_1(int index,String supp_address_1)
	{
		this.supp_address_1[index]=checkForNull(supp_address_1);
	}

	

	public void setSupp_Address_2(int index,String supp_address_2)
	{
		this.supp_address_2[index]=checkForNull(supp_address_2);
	}

	

	public void setSupp_Address_3(int index,String supp_address_3)
	{
		this.supp_address_3[index]=checkForNull(supp_address_3);
	}







	
	/* Set Methods End */

	/* Get Methods Start */	
	
	public String getUnit_code(int index) {
		return this.unit_code[index];
	}

	public String getLong_desc(int index) {
		return this.long_desc[index];
	}

	public String getShort_desc(int index) {
		return this.short_desc[index];
	}

	public String getEff_status(int index) {
		return this.eff_status[index];
	}
	public String getGlobal_unit(int index) {
		return this.global_unit[index];
	}

	public String getSupp_Address_1(int index)
	{
		return supp_address_1[index];
	}

	public String getSupp_Address_2(int index)
	{
		return supp_address_2[index];
	}

		public String getSupp_Address_3(int index)
	{
		return supp_address_3[index];
	}


	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear();
		for (int index=0;index<RECORD_SIZE;index++)
		{
			unit_code[index]	 = "";
			long_desc[index] = "";
			short_desc[index] = "";
			eff_status[index] = "D";	
			global_unit[index] = "N";
			supp_address_1[index] = "";
			supp_address_2[index] = "";
			supp_address_3[index] = "";
		}
	}

	public void setAll(Hashtable recordSet) {
		System.out.println("recordSet in setAll Mul. Ins. Pur. Unit Bean "+recordSet);
		for (int index=0;index<RECORD_SIZE;index++) {
			String tempCode	=	(String)recordSet.get("unit_code_"+index);
			String tempLong_desc	=	(String)recordSet.get("long_desc_"+index);
			String tempShort_desc	=	(String)recordSet.get("short_desc_"+index);
			String tempEff_status	=	(String)recordSet.get("eff_status_"+index);
			String tempGlobal_unit	=	(String)recordSet.get("global_unit_"+index);
			String tempsupp_address_1	=	(String)recordSet.get("supp_address1_"+index);
			String tempsupp_address_2	=	(String)recordSet.get("supp_address2_"+index);
			String tempsupp_address_3	=	(String)recordSet.get("supp_address3_"+index);
			if((tempCode== null) || (tempCode.equals(""))) {
				setUnit_code	(index, null);
				setLong_desc	(index, null);
				setShort_desc	(index, null);
				setEff_status(index, null);
				setGlobal_unit(index, null);
				setSupp_Address_1(index,null);
				setSupp_Address_2(index,null);
				setSupp_Address_3(index,null);
				continue; 
			}

		
			setUnit_code	(index, tempCode);
			setLong_desc	(index, tempLong_desc	);
			setShort_desc	(index, tempShort_desc	);
			if(tempEff_status==null || tempEff_status.trim().equals(""))
				setEff_status	(index, "D");
			else
				setEff_status	(index, tempEff_status);
				
			if(tempGlobal_unit==null || tempGlobal_unit.trim().equals(""))
				setGlobal_unit	(index, "N");
			else
				setGlobal_unit	(index, tempGlobal_unit);

			setSupp_Address_1(index,tempsupp_address_1);
			setSupp_Address_2(index,tempsupp_address_2);
			setSupp_Address_3(index,tempsupp_address_3);
		}
	}

	public HashMap insert() {
	System.out.println("Multiple insert Purchase Unit ");
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		ArrayList LanguageData = new ArrayList() ;

		hmResult.put("result", new Boolean(false));

		for (int index=0;index<RECORD_SIZE;index++) {
			if((getUnit_code(index) == null) || (getUnit_code(index).equals(""))) 
					continue;
			ArrayList alInsertRecord        =       new ArrayList();
			alInsertRecord.add(getUnit_code(index));
			alInsertRecord.add(getLong_desc(index));
			alInsertRecord.add(getShort_desc(index));
			alInsertRecord.add(getGlobal_unit(index));
			alInsertRecord.add(getEff_status(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(getSupp_Address_1(index));
			alInsertRecord.add(getSupp_Address_2(index));
			alInsertRecord.add(getSupp_Address_3(index));
			
			alInsertData.add(alInsertRecord);
			//For duplicate check
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(getUnit_code(index));
			alWhereData.add(duplicateValue);
	}
		LanguageData.add(getLanguageId());
		hmSQLMap.put("InsertSQL", InsertSQL); 
		hmSQLMap.put("SelectSQL", SelectSQL); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);
		hmTableData.put( "LanguageData",LanguageData);
		
		System.out.println("hmTableData in Multiple Purchase Unit= "+hmTableData);
		System.out.println("hmSQLMap in Multiple Purchase Unit = "+hmSQLMap);
		
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			System.out.println("hmResult in Multiple Purchase Unit = "+hmResult);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
			hmResult.put( "message", getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ;
					msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					hmResult.put( "message", msgID  ) ;
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) ) ;
				} else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
			
		} 
		catch(Exception e) {
			System.err.println("Error-Calling EJB - SSM: "+e);
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null){}
					//singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				System.err.println("Exceptions : SSM" +ee.getMessage());
				hmResult.put("message", ee.toString());
			}
		}
		return hmResult;
	}


	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
				ArrayList LanguageData = new ArrayList() ;
		
		hmResult.put("result", new Boolean(false));

		alModifyData.add(long_desc[0]);
		alModifyData.add(short_desc[0]);
		alModifyData.add(global_unit[0]);
		alModifyData.add(eff_status[0]);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);
		alModifyData.add(supp_address_1[0]);
		alModifyData.add(supp_address_2[0]);
		alModifyData.add(supp_address_3[0]);
		alModifyData.add(unit_code[0]);
				
		LanguageData.add(getLanguageId());
		hmSQLMap.put("ModifySQL", UpdateSQL); 
		System.err.println("alModifyData"+alModifyData);
		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",LanguageData);

//		SingleTableHandlerHome		singleTableHandlerHome		= null;
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;
			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			System.err.println("Error Calling EJB : SSM"+e);
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null){}
				//	singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				System.err.println("Exceptions : SSM "+ee.getMessage());
				hmResult.put("message", ee.getMessage());
			}
		}
		return hmResult;
	}

	public String toString() {
		StringBuffer arrayContent = new StringBuffer();
		for (int index=0;index<RECORD_SIZE;index++) {
			arrayContent.append("Record :"+ (index + 1) +" :: ");
			arrayContent.append(unit_code [index]	+"=	");
			arrayContent.append(long_desc[index]+"=");
			arrayContent.append(short_desc[index]+"=");
			arrayContent.append(eff_status[index]+"=");	
			arrayContent.append(global_unit[index]+"=");	
			arrayContent.append("<BR>");
		}	
		return arrayContent.toString();
	}

	/* Added by Martin */
	public void loadData() throws Exception {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(ModifySQL); 
			pstmt.setString(1, unit_code[0]);
		    pstmt.setString(2, getLanguageId()); //27/06/12

			resultSet = pstmt.executeQuery();
			if ((resultSet != null) && (resultSet.next())) {
				setUnit_code(0,resultSet.getString("PUR_UNIT_CODE"));
				setLong_desc(0,resultSet.getString("long_desc"));
				setShort_desc(0,resultSet.getString("short_desc"));
				setGlobal_unit(0,resultSet.getString("global_unit_yn"));
				setEff_status(0,resultSet.getString("eff_status"));

				setSupp_Address_1(0,resultSet.getString("ADD1_DESC"));
				setSupp_Address_2(0,resultSet.getString("ADD2_DESC"));
				setSupp_Address_3(0,resultSet.getString("ADD3_DESC"));
				
			}
		} 
		catch (Exception e)	{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				System.err.println("Exceptions : SSM "+ es.toString());
				es.printStackTrace();
			}
		}
	}

	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	/*public ArrayList getMasterTypeList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrStore		=	new  ArrayList();
		HashMap		hmStore			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_ST_PO_MASTER_TYPE_SELECT")); 
				resultSet = pstmt.executeQuery();
				
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmStore			=	new HashMap();
					hmStore.put("type",checkForNull(resultSet.getString(1)));
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
		*/
}
