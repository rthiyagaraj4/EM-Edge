/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.*;
import eST.KitTemplate.*;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import java.sql.*;

public class KitTemplateBean extends StAdapter implements Serializable {
	private ArrayList	alDtlRecords=new ArrayList();
	private String kit_code   = "";
	private String kit_desc   = "";
	private String eff_status = "";
	public void  clear(){
		super.clear();
		alDtlRecords=new ArrayList();
	}
	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}
   public void setKitTemplateCode(String kit_code){
		this.kit_code = kit_code;
	}

	public String getKitTemplateCode(){
		return this.kit_code;
	}
   public void setKitTemplateDesc(String kit_desc){
		this.kit_desc = kit_desc;
	}

	public String getKitTemplateDesc(){
		return this.kit_desc;
	}
   public void setEff_Status(String eff_status){
		this.eff_status = eff_status;
	}

	public String getEff_Status(){
		return this.eff_status;
	}

	public void updateDtlRecord(int index,HashMap hmDtlRecord){
	System.out.println("hmDtlRecord===========53====>" +hmDtlRecord);
		if (index==-1) {
			index	=	alDtlRecords.size()-1;
			alDtlRecords.add(hmDtlRecord);
			System.out.println("alDtlRecords===========56====>" +alDtlRecords);
		}else
			alDtlRecords.set(index,hmDtlRecord);
			System.out.println("alDtlRecords===========60====>" +alDtlRecords);
	}
	public ArrayList getUom_code_List(String item_code) throws Exception{
		String chkParameters[] = {getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),item_code};
		
		ArrayList result = new ArrayList();
		
		result = fetchRecords(getStRepositoryValue("SQL_ST_KIT_TEMPLATE_UOM_CODE"),chkParameters);
			return result;
	}
	public String getPur_uom_code_Modify_List(String uom_code,String item_code) throws Exception{
			
			String chkParameters[] = {getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),item_code};
			return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_KIT_TEMPLATE_UOM_CODE"),chkParameters),uom_code);
		
	}

	public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");

		return gen_uom_code;

	}
	public String getShortDesc(String uom_code) throws Exception {
		String chkdefaultParameters[] = {uom_code,getLanguageId()};
		String short_desc			  = "";	
		HashMap short_des			  = new HashMap();
		try{
			short_des = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters);
			//	short_des = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters);
		}catch(Exception e){
			short_desc = "";
		}
		
		if(short_des.size() > 0)
			short_desc = (String)short_des.get("SHORT_DESC");

		return short_desc;
	}
	public void setAll(Hashtable hashtable) {
		setKitTemplateCode((String)hashtable.get("kit_template_code"));
		setKitTemplateDesc((String)hashtable.get("kit_template_desc"));
		if(((String)hashtable.get("eff_status")).equals(""))
			setEff_Status("E");
		else
			setEff_Status((String)hashtable.get("eff_status"));
	}
	 public HashMap validate(){
        HashMap hashmap = new HashMap();
       // ArrayList arraylist = new ArrayList();
        hashmap.put("result", super.TRUE);
        return hashmap;
    }
	public void loadData(String kit_template_code) throws Exception {
		HashMap hmRecord = new HashMap();
		try {
		ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_KIT_TEMPLATE_DTL_SELECT"),kit_template_code);
		
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			System.out.println("hmRecord===========127====>" +hmRecord);
			HashMap hmDtlRecord	=	new HashMap();
			hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));

			setKitTemplateCode((String)hmRecord.get("KIT_TEMPLATE_CODE"));

			hmDtlRecord.put("item_code",hmRecord.get("ITEM_CODE"));
			hmDtlRecord.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmDtlRecord.put("qty",hmRecord.get("QUANTITY"));
			hmDtlRecord.put("uom_code",hmRecord.get("UOM_CODE"));
			hmDtlRecord.put("seq_no",hmRecord.get("SEQ_NO"));
			hmDtlRecord.put("eff_status",hmRecord.get("EFF_STATUS"));
			hmDtlRecord.put("db_action","U");
			hmDtlRecord.put("usage_type",hmRecord.get("USAGE_TYPE"));
			alDtlRecords.add(hmDtlRecord);  
			System.out.println("alDtlRecords===========142====>" +alDtlRecords);
		}
		} 
		catch (Exception e) {
            e.printStackTrace();
		}
	}

	public HashMap insert(){
        HashMap hmTableData = new HashMap();
        ArrayList alHdrData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        ArrayList alDtlData= new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        HashMap hmSQLMap = new HashMap();

		alHdrData.add((String)getKitTemplateCode());
		alHdrData.add((String)getKitTemplateDesc());
		alHdrData.add((String)getEff_Status());
        alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		arraylist1.add(alHdrData);
		
	
        for(int i = 0; i < alDtlRecords.size(); i++)
        {
            HashMap hashmap2 = (HashMap)alDtlRecords.get(i);
			System.out.println("hashmap2===========178====>" +hashmap2);
				alDtlData = new ArrayList();
				alDtlData.add((String)getKitTemplateCode());
                alDtlData.add((String)hashmap2.get("item_code"));
                alDtlData.add((String)hashmap2.get("qty"));
                alDtlData.add((String)hashmap2.get("uom_code"));
                alDtlData.add((String)hashmap2.get("seq_no"));
                alDtlData.add((String)hashmap2.get("eff_status"));
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(checkForNull((String)hashmap2.get("usage_type"),"O")); //27/07/12
				arraylist2.add(alDtlData);
			 
        }
		

        hmSQLMap.put("hdrInsertSQL",getStRepositoryValue("SQL_ST_KIT_TEMPLATE_INSERT"));
        hmSQLMap.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_KIT_TEMPLATE_DTL_INSERT"));
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrInsertData", arraylist1);
        hmTableData.put("DtlInsertData", arraylist2);
		hmTableData.put("LanguageData",LanguageData);
        return kitTemplateMethodCall(hmTableData, hmSQLMap, 1);
	}
	public HashMap modify(){
        HashMap hmTableData = new HashMap();
        ArrayList alHdrData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        ArrayList alDtlData= new ArrayList();
        ArrayList alUpdDtlData= new ArrayList();
        ArrayList alUpdHdrData = new ArrayList();
        ArrayList alInsDtlData = new ArrayList();
        ArrayList alUpdtDtlData = new ArrayList();
        HashMap hmSQLMap = new HashMap();

		alHdrData.add((String)getKitTemplateDesc());
		alHdrData.add((String)getEff_Status());
        alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		alHdrData.add((String)getKitTemplateCode());
		alUpdHdrData.add(alHdrData);
	
        for(int i = 0; i < alDtlRecords.size(); i++)
        {
            HashMap hashmap2 = (HashMap)alDtlRecords.get(i);
			System.out.println("hashmap2hashmap2 modify" +hashmap2);
			if(hashmap2.get("db_action").equals("I")){
				alDtlData	= new ArrayList();
				alDtlData.add((String)getKitTemplateCode());
                alDtlData.add((String)hashmap2.get("item_code"));
                alDtlData.add((String)hashmap2.get("qty"));
                alDtlData.add((String)hashmap2.get("uom_code"));
                alDtlData.add((String)hashmap2.get("seq_no"));
                alDtlData.add((String)hashmap2.get("eff_status"));
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add((String)hashmap2.get("usage_type")); //27/07/12
				alInsDtlData.add(alDtlData);
			}else{
				alUpdDtlData	= new ArrayList();
                alUpdDtlData.add((String)hashmap2.get("qty"));
                alUpdDtlData.add((String)hashmap2.get("uom_code"));
                alUpdDtlData.add((String)hashmap2.get("seq_no"));
                alUpdDtlData.add((String)hashmap2.get("eff_status"));
				alUpdDtlData.add(getLoginById());
				alUpdDtlData.add(getLoginAtWsNo());
				alUpdDtlData.add(getLoginFacilityId());
				alUpdDtlData.add((String)hashmap2.get("usage_type")); //27/07/12
				alUpdDtlData.add((String)getKitTemplateCode());
                alUpdDtlData.add((String)hashmap2.get("item_code"));
				
				alUpdtDtlData.add(alUpdDtlData);
			}
        }
		

        hmSQLMap.put("hdrUpdateSQL","UPDATE ST_KIT_TEMPLATE SET  KIT_TEMPLATE_DESC=?,EFF_STATUS=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE KIT_TEMPLATE_CODE=?");
        hmSQLMap.put("dtlUpdateSQL",getStRepositoryValue("SQL_ST_KIT_TEMPLATE_DTL_UPDATE"));
        hmSQLMap.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_KIT_TEMPLATE_DTL_INSERT"));
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrUpdateData", alUpdHdrData);
        hmTableData.put("DtlInsertData", alInsDtlData);
        hmTableData.put("DtlUpdateData", alUpdtDtlData);
		hmTableData.put("LanguageData",LanguageData);
        return kitTemplateMethodCall(hmTableData, hmSQLMap, 2);    
	}
    public HashMap kitTemplateMethodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
			
        try
        {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_KIT_TEMPLATE"),KitTemplateLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			
			if(mode==2)
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
			exception.printStackTrace() ;
			}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }
}
