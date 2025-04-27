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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.Common.CommonRepository;
import eMM.Common.MmAdapter;

public class ItemUOMDefinition extends MmAdapter implements Serializable{ 

	private String item_code="";
	private String item_desc="";
	private String uom_code="";
	private String equom_code="";
	private String conversion="";
	private String eff_status="";
	private String equom_qty="";

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public String getItem_desc() {
		return item_desc;
	}
	
	public void setUOM_code(String uom_code) {
		this.uom_code = uom_code;
	}

	public String getUOM_code() {
		return uom_code;
	}

	public void setEquiUOM_code(String equom_code) {
		this.equom_code = equom_code;
	}

	public String getEquiUOM_code() {
		return equom_code;
	}

	public void setConversion(String conversion) {
		this.conversion= conversion;
	}

	public String getConversion() {
		return conversion;
	}

	public void setEqUOMQty(String equom_qty) {
		this.equom_qty= equom_qty;
	}

	public String getEqUOMQty() {
		return equom_qty;
	}
	
	
	public void setEff_Status ( String eff_status ){
        if(eff_status.equals("D") || eff_status==null || eff_status=="")
            this.eff_status = "D" ;
        else
			if(eff_status.equals("E"))
		this.eff_status = eff_status ;		
    }

	public String getEff_Status() {
		return this.eff_status	;
	}

	
	public HashMap validate()throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public void clear()
	{
		super.clear();
		setItem_code("");
		setUOM_code("");
		setEquiUOM_code("");
		setConversion("");
		setEff_Status("D");
		setEqUOMQty(""); 		
	}

	public void setAll (Hashtable recordSet)
	{
		super.setAll(recordSet);
	
		if(recordSet.containsKey("item_code"))
			setItem_code((String)recordSet.get("item_code")) ;

		if(recordSet.containsKey("uom_code"))
			setUOM_code((String)recordSet.get("uom_code")) ;

		if(recordSet.containsKey("equom_code"))
			setEquiUOM_code((String)recordSet.get("equom_code")) ;

		if(recordSet.containsKey("conversion"))
			setConversion((String)recordSet.get("conversion")) ; 
		
		if(recordSet.containsKey("eff_status"))
			setEff_Status((String)recordSet.get("eff_status")) ;

		if(recordSet.containsKey("equom_qty"))
			setEqUOMQty((String)recordSet.get("equom_qty")) ;		
		
	}


 public void loadData(String item_code,String uom_code,String equom_code){

HashMap hmRecord	=	new HashMap();
ArrayList arr=new ArrayList();
arr.add(item_code);
arr.add(uom_code);
arr.add(equom_code);
try{
ArrayList hmResult=fetchRecords("SELECT ITEM_CODE, UOM_CODE, EQVL_UOM_CODE,EQVL_VALUE,EFF_STATUS,EQVL_UOM_QTY FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE=? AND UOM_CODE=? AND EQVL_UOM_CODE=?",arr);
for (int i=0; i<hmResult.size(); i++) {
	hmRecord	=	(HashMap)hmResult.get(i);
setItem_code(checkForNull((String)hmRecord.get("ITEM_CODE")));
setUOM_code(checkForNull((String)hmRecord.get("UOM_CODE")));
setEquiUOM_code(checkForNull((String)hmRecord.get("EQVL_UOM_CODE")));
setConversion(checkForNull((String)hmRecord.get("EQVL_VALUE"),"1"));
setEff_Status(checkForNull((String)hmRecord.get("EFF_STATUS")));
setEqUOMQty(checkForNull((String)hmRecord.get("EQVL_UOM_QTY")));
}
}catch(Exception e)
	{
System.err.println(e);
	}

}

	public String getUOM(String UOM_code) 
	{
		String result="";
		try
		{
		
			String sql = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_UOM_DEFN_SELECT_EQUI_UOM");  
			ArrayList alParameters=new ArrayList();
			alParameters.add(getLanguageId());
			
			result = getListOptionTag(getListOptionArrayList(sql,alParameters),UOM_code);
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;

	}

	public String getEquivalentUOM(String equom_code) 
	{
		String result="";
		try
		{
	
		String sql = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_UOM_DEFN_SELECT_UOM");
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLanguageId());
		
		result = getListOptionTag(getListOptionArrayList(sql,alParameters),equom_code);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;

	}

	public HashMap insert()
	{
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		HashMap tabData = new HashMap() ;
		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();
		ArrayList LanguageData = new ArrayList() ;

		InsertData.add(item_code);		
		InsertData.add(uom_code);
		InsertData.add(equom_code);
		InsertData.add(conversion);
		
		InsertData.add(eff_status);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(equom_qty);

		WhereData.add(item_code);
		WhereData.add(uom_code);
		WhereData.add(equom_code);

		LanguageData.add(getLanguageId());
		tabData.put( "InsertData",	InsertData ) ;
		tabData.put( "WhereData",	WhereData ) ;
		tabData.put( "properties",	getProperties() ) ;
		tabData.put( "LanguageData",LanguageData);
		

		
		HashMap sqlMap = new HashMap() ;
		
//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try 
		{
			
			
			sqlMap.put( "InsertSQL", eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_UOM_DEFN_INSERT" ));	
			sqlMap.put( "InsertSQL","INSERT INTO MM_ITEM_UOM_DEFN (ITEM_CODE,UOM_CODE,EQVL_UOM_CODE,EQVL_VALUE,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EQVL_UOM_QTY)VALUES(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");	
			sqlMap.put( "SelectSQL", eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_UOM_DEFN_CODE_EXISTS"));
			

			Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

			Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
		} 
		catch(Exception e)
		{
				map.put( "message", e.toString()) ;
				e.printStackTrace() ;
		}
		finally
		{
			try 
			{
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
						ee.printStackTrace() ;
					}
			}
		return map ;
	}

	public HashMap modify() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap() ;
		ArrayList ModifyData = new ArrayList();
		ArrayList LanguageData = new ArrayList() ;
		
		
		ModifyData.add(conversion);
		ModifyData.add(eff_status);
		
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(equom_qty);
		
		ModifyData.add(item_code);
		ModifyData.add(uom_code);
		ModifyData.add(equom_code);
		LanguageData.add(getLanguageId());

		tabData.put( "ModifyData",	ModifyData ) ;
		
		tabData.put( "properties",	getProperties() ) ;
		
		tabData.put( "LanguageData",LanguageData);
			

		HashMap sqlMap = new HashMap() ;
		SingleTableHandlerRemote remote = null ;

		
		try
		{
			//String updatesql="UPDATE MM_ITEM_UOM_DEFN SET  EQVL_VALUE = ?, EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ? WHERE ITEM_CODE= ? AND UOM_CODE = ? AND EQVL_UOM_CODE =?";
			//sqlMap.put( "ModifySQL",eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_UOM_DEFN_UPDATE"));
			sqlMap.put( "ModifySQL","UPDATE MM_ITEM_UOM_DEFN SET  EQVL_VALUE = ?, EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ?,EQVL_UOM_QTY=? WHERE ITEM_CODE= ? AND UOM_CODE = ? AND EQVL_UOM_CODE =?");
				
			Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();

			 map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() )		
				map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
			else
				map.put("message",map.get("msgid"));		
		}
		catch(Exception e)
		{
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally
		{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee ) 
				{
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace() ;
				}
		}

		return map ;
	}
	public HashMap getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		//String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			base_uom = fetchRecord("SELECT GEN_UOM_CODE, A.SHORT_DESC  FROM MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW A WHERE ITEM_CODE = ?  AND A.UOM_CODE = MM.GEN_UOM_CODE AND A.LANGUAGE_ID = MM.LANGUAGE_ID AND A.LANGUAGE_ID = ?",chkdefaultParameters);
			//base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),item_code);
		}catch(Exception e){
			e.printStackTrace() ;
		}
		if(base_uom.size() > 0)
			return base_uom;
		return base_uom;
	}

}
