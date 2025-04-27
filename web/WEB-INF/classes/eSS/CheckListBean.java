/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import  eSS.Common.SsAdapter;
import  eST.Common.StAdapter;
import eSS.Common.SsTransaction;
import eCommon.SingleTableHandler.*;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import java.sql.*;
import eSS.CheckList.*;

public class CheckListBean extends MasterCodeBean implements Serializable {
	private ArrayList	alDtlRecords=new ArrayList();
	private String checklist_code   = "";
	private String checklist_desc   = "";
	private String eff_status = "";
	private String mandatory_status = "";
	private String mode_temp = "";
	public void  clear(){
		super.clear();
		alDtlRecords=new ArrayList();
	mode_temp = "";
	}
	public String getMode_Temp(){
		return mode_temp;
	}
   public void setMode_Temp(String mode_temp){
		this.mode_temp = mode_temp;
	}
	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}
   public void setCheckListCode(String checklist_code){
		this.checklist_code = checklist_code;
	}

	public String getCheckListCode(){
		return this.checklist_code;
	}
   public void setCheckListDesc(String checklist_desc){
		this.checklist_desc = checklist_desc;
	}

	public String getCheckListDesc(){
		return this.checklist_desc;
	}
   public void setEff_Status(String eff_status){
		this.eff_status = eff_status;
	}

	public String getEff_Status(){
		return this.eff_status;
	}
	public void setMandatory_Status(String mandatory_status){
		this.mandatory_status = mandatory_status;
	}

	public String getMandatory_Status(){
		return this.mandatory_status;
	}


	public void updateDtlRecord(int index,HashMap hmDtlRecord){
		if (index==-1) {
			index	=	alDtlRecords.size()-1;
			alDtlRecords.add(hmDtlRecord);
		}else
			alDtlRecords.set(index,hmDtlRecord);
	}
	/*public ArrayList getUom_code_List(String item_code) throws Exception{
		String chkParameters[] = {getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),item_code};
		
		ArrayList result = new ArrayList();
		
		result = fetchRecords(getSsRepositoryValue("SQL_ST_KIT_TEMPLATE_UOM_CODE"),chkParameters);
			return result;
	}
	/*public String getPur_uom_code_Modify_List(String uom_code,String item_code) throws Exception{
			
			String chkParameters[] = {getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),getGenItemUOM(item_code),getLanguageId(),item_code};
			return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_ST_KIT_TEMPLATE_UOM_CODE"),chkParameters),uom_code);
		
	}*/

	/*public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(getSsRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
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
			short_des = fetchRecord(getSsRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters);
			//	short_des = fetchRecord(getSsRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters);
		}catch(Exception e){
			short_desc = "";
		}
		
		if(short_des.size() > 0)
			short_desc = (String)short_des.get("SHORT_DESC");

		return short_desc;
	}*/
	public void setAll(Hashtable hashtable) {
		System.out.println("In the SetAll"+hashtable);
		setCheckListCode((String)hashtable.get("checklist_code"));
		setCheckListDesc((String)hashtable.get("checklist_desc"));
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
	public void loadData(String checklist_code) throws Exception {
		HashMap hmRecord = new HashMap();
		try {
		ArrayList alRecords	=	fetchRecords("SELECT CHECKLIST_CODE,A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,QUANTITY,MADATORY_ITEM_YN,SEQ_NO,A.EFF_STATUS FROM SS_CHECKLIST_DTL A,MM_ITEM B WHERE CHECKLIST_CODE=? AND A.ITEM_CODE=B.ITEM_CODE ORDER BY A.SEQ_NO",checklist_code);
		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmDtlRecord	=	new HashMap();
			hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));

			setCheckListCode((String)hmRecord.get("CHECKLIST_CODE"));

			hmDtlRecord.put("item_code",hmRecord.get("ITEM_CODE"));
			hmDtlRecord.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmDtlRecord.put("qty",hmRecord.get("QUANTITY"));
			hmDtlRecord.put("mandatory_status",hmRecord.get("MADATORY_ITEM_YN"));
			hmDtlRecord.put("seq_no",hmRecord.get("SEQ_NO"));
			hmDtlRecord.put("eff_status",hmRecord.get("EFF_STATUS"));
			hmDtlRecord.put("db_action","U");
			alDtlRecords.add(hmDtlRecord);  
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

		alHdrData.add((String)getCheckListCode());
		alHdrData.add((String)getCheckListDesc());
		alHdrData.add((String)getEff_Status());
        alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		arraylist1.add(alHdrData);
	//	System.out.println("arraylist1==>"+arraylist1);
	
        for(int i = 0; i < alDtlRecords.size(); i++)
        {
            HashMap hashmap2 = (HashMap)alDtlRecords.get(i);
				alDtlData = new ArrayList();
				alDtlData.add((String)getCheckListCode());
                alDtlData.add((String)hashmap2.get("item_code"));
                alDtlData.add((String)hashmap2.get("mandatory_status"));
				alDtlData.add((String)hashmap2.get("qty"));
                alDtlData.add("");
				alDtlData.add((String)hashmap2.get("seq_no"));
                alDtlData.add((String)hashmap2.get("eff_status"));
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				arraylist2.add(alDtlData);
			 
        }
		
    //System.out.println("arraylist2==>"+arraylist2);
        
		hmSQLMap.put("hdrInsertSQL","INSERT INTO SS_CHECKLIST(CHECKLIST_CODE,CHECKLIST_DESC,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
        hmSQLMap.put("dtlInsertSQL", "INSERT INTO SS_CHECKLIST_DTL(CHECKLIST_CODE,ITEM_CODE,MADATORY_ITEM_YN,QUANTITY,UOM_CODE,SEQ_NO,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrInsertData", arraylist1);
        hmTableData.put("DtlInsertData", arraylist2);
		hmTableData.put("LanguageData",LanguageData);
		
        return checkListMethodCall(hmTableData, hmSQLMap, 1);
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

		alHdrData.add((String)getCheckListDesc());
		alHdrData.add((String)getEff_Status());
        alHdrData.add(getLoginById());
        alHdrData.add(getLoginAtWsNo());
        alHdrData.add(getLoginFacilityId());
		alHdrData.add((String)getCheckListCode());
		alUpdHdrData.add(alHdrData);
	
        for(int i = 0; i < alDtlRecords.size(); i++)
        {
            HashMap hashmap2 = (HashMap)alDtlRecords.get(i);
			if(hashmap2.get("db_action").equals("I")){
				alDtlData	= new ArrayList();
				alDtlData.add((String)getCheckListCode());
                alDtlData.add((String)hashmap2.get("item_code"));
                alDtlData.add((String)hashmap2.get("mandatory_status"));
				alDtlData.add((String)hashmap2.get("qty"));
                alDtlData.add("");

                alDtlData.add((String)hashmap2.get("seq_no"));
                alDtlData.add((String)hashmap2.get("eff_status"));
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alDtlData.add(getLoginById());
				alDtlData.add(getLoginAtWsNo());
				alDtlData.add(getLoginFacilityId());
				alInsDtlData.add(alDtlData);
			}else{
				alUpdDtlData	= new ArrayList();
                alUpdDtlData.add((String)hashmap2.get("qty"));
                alUpdDtlData.add((String)hashmap2.get("mandatory_status"));
                alUpdDtlData.add((String)hashmap2.get("seq_no"));
                alUpdDtlData.add((String)hashmap2.get("eff_status"));
				alUpdDtlData.add(getLoginById());
				alUpdDtlData.add(getLoginAtWsNo());
				alUpdDtlData.add(getLoginFacilityId());
				alUpdDtlData.add((String)getCheckListCode());
                alUpdDtlData.add((String)hashmap2.get("item_code"));
				alUpdtDtlData.add(alUpdDtlData);
			}
        }
		

        hmSQLMap.put("hdrUpdateSQL","UPDATE SS_CHECKLIST SET CHECKLIST_DESC=?, EFF_STATUS=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE CHECKLIST_CODE=?");
        hmSQLMap.put("dtlUpdateSQL","UPDATE SS_CHECKLIST_DTL SET QUANTITY=?,MADATORY_ITEM_YN=?,SEQ_NO=?,EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE CHECKLIST_CODE=? AND ITEM_CODE=?");
        hmSQLMap.put("dtlInsertSQL", "INSERT INTO SS_CHECKLIST_DTL(CHECKLIST_CODE,ITEM_CODE,MADATORY_ITEM_YN,QUANTITY,UOM_CODE,SEQ_NO,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrUpdateData", alUpdHdrData);
        hmTableData.put("DtlInsertData", alInsDtlData);
        hmTableData.put("DtlUpdateData", alUpdtDtlData);
		hmTableData.put("LanguageData",LanguageData);
		//System.out.println("hmTableData@@==>"+hmTableData);
        return checkListMethodCall(hmTableData, hmSQLMap, 2);
	}
    public HashMap checkListMethodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
			
        
        try
        {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_CHECK_LIST"),CheckListHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); 
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
            hashmapResult.put("message", getMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"SS") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"SS") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }


	
	public boolean isDuplicateInArrayList(ArrayList arrayList, String []stKeyFields, String []stValues, int exceptionalIndex){
		boolean result=false;
		int j=0;
		for (int i=0;i<arrayList.size()&& (!result);i++) {
			if (exceptionalIndex == i) continue;
			result=true;
			for (j=0; j<stKeyFields.length ; j++ ) {
				if (! ((HashMap)arrayList.get(i)).get(stKeyFields[j]).toString().equals(stValues[j])) {
					result=false;
					break;
				}
			}
	
		}

		return result;
	}
		}
