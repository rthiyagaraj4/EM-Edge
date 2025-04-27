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
//import java.util.HashMap;

import eCommon.SingleTableHandler.*;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import eMM.Common.MmRepository;
import eCommon.Common.CommonRepository;
import eMM.Common.MmAdapter;
import eST.Common.StAdapter;
import eST.KitTemplate.*;
import eST.Common.StRepository;


public class UserAccessForMaterialGroupBean extends MmAdapter implements Serializable {

	String user_id;
   //String language_id;
//	String total_materials;
	int total_no ;
	java.util.ArrayList itemClasses;
	java.util.ArrayList material_values;


	/*

	materialGroupList structure
index - value
	0 - material_group_code
	1 - short_desc
	2 - DBAction
	3 - EffStatus
	4 - ChangedYN
*/
	java.util.ArrayList materialGroupList;

	public UserAccessForMaterialGroupBean() {
		}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/*	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
public String getLanguageId() 
	{
		return this.language_id;
	}
*/
		public String getUser_id() {
		return this.user_id;
	}

		public java.util.ArrayList getItemClasses() {
		return this.itemClasses;
	}
		public java.util.ArrayList getmaterialGroupList() {
		return this.materialGroupList;
	}
	public void setmaterialGroupList(ArrayList materialGroupList){
		this.materialGroupList=materialGroupList;
	}
public void clear()
	{
		super.clear();
		materialGroupList=null;
	}
	

	

public java.util.HashMap insert() {
		HashMap	hmSQLMap	= new HashMap();
		HashMap	hmTableData	= new HashMap();
		ArrayList alTmpInsData = new ArrayList();
		ArrayList alInsData = new ArrayList();
		ArrayList alTmpUpdateData = new ArrayList();
		ArrayList alUpdateData = new ArrayList();
		ArrayList		materialGroupList =  getmaterialGroupList();
		int count=0;
		while((materialGroupList != null) && (count < materialGroupList.size())){
			if( materialGroupList.get(count+2).equals("I") && materialGroupList.get(count+4).equals("Y")){
				alTmpInsData = new ArrayList();
				alTmpInsData.add(getUser_id());
				alTmpInsData.add(materialGroupList.get(count+0));
				alTmpInsData.add("E");
				alTmpInsData.add(login_by_id);
				alTmpInsData.add(login_at_ws_no);
				alTmpInsData.add(login_facility_id);
				alTmpInsData.add(login_by_id);
				alTmpInsData.add(login_at_ws_no);
				alTmpInsData.add(login_facility_id);
				alInsData.add(alTmpInsData);
				}
			
				if(materialGroupList.get(count+2).equals("U")){
				alTmpUpdateData = new ArrayList();
				if(	materialGroupList.get(count+4).equals("Y") )
				alTmpUpdateData.add("E");
				if(	materialGroupList.get(count+4).equals("N") )
				alTmpUpdateData.add("D");
				alTmpUpdateData.add(login_by_id);
				alTmpUpdateData.add(login_at_ws_no);
				alTmpUpdateData.add(login_facility_id);
				alTmpUpdateData.add(getUser_id());
				alTmpUpdateData.add(materialGroupList.get(count+0));
				alUpdateData.add(alTmpUpdateData);

				}
				count+=5;
		}				
	
		   hmSQLMap.put("hdrInsertSQL",MmRepository.getMmKeyValue("SQL_MM_MATRIALS_GROUP_INSERT"));
		  //hmSQLMap.put("hdrInsertSQL","insert into mm_user_material_group( user_id,material_group_code,eff_status, added_by_id, added_date,added_at_ws_no, added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id ) VALUES  (? ,? ,? ,?,sysdate, ?, ?,?,sysdate,?,?)");


	    hmSQLMap.put("dtlInsertSQL", MmRepository.getMmKeyValue("SQL_MM_USER_MATERIAL_GROUP_UPDATE"));
		//hmSQLMap.put("dtlInsertSQL", "update mm_user_material_group  set eff_status=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where user_id=? and material_group_code=?");
        hmTableData.put("properties", getProperties());
        hmTableData.put("HdrInsertData", alInsData);
        hmTableData.put("DtlInsertData", alUpdateData);
        return ItemStoreBinMethodCall(hmTableData, hmSQLMap);
	}
    public HashMap ItemStoreBinMethodCall(HashMap hashmap, HashMap hashmapQuery)
    {
        HashMap hashmapResult = new HashMap();
			
        try
        {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/KitTemplate",KitTemplateLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
			exception.printStackTrace() ;
			}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getMMMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", (String) hashmapResult.get("msgid" )) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }




	public HashMap validate() {
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		return resultMap;
	}

	//public void setAll(java.util.HashMap hashValues) {
	public void setAll(Hashtable hashValues) {
		this.total_no = Integer.parseInt((String)hashValues.get("total_item_class")); 
		material_values=new ArrayList();
		for(int i = 0; i<total_no; i++){
				String val =  (String)hashValues.get("material_group_"+i);
				if (val != null &&  (!val.equals("")))
					material_values.add(val);
		}
	}

	public ArrayList isSSIVModuleInstalled() throws Exception
		{
		//System.err.println("calling 	isSSIVModuleInstalled()");
		HashMap		hmSSIV		=	null;	
		ArrayList	arrSSIV		=	new  ArrayList();
        
		hmSSIV	=	new HashMap();
		hmSSIV.put("IV",checkForNull(MM_license_rights.getSTboundary()));
		hmSSIV.put("SS",checkForNull(MM_license_rights.getSSboundary()));
		hmSSIV.put("PO",checkForNull(MM_license_rights.getPOboundary()));
		arrSSIV.add(hmSSIV);
		
		return arrSSIV;
	}	




public ArrayList	getMaterialGroupList(){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt_select_drugtype =	null ;
		java.sql.ResultSet rset_drug_type = null;
		materialGroupList = new ArrayList();
		try{
			String sql_select_drug_type = MmRepository.getMmKeyValue("SQL_MM_MATRIALS_GROUP_CODE_DESC_1") ;

//String sql_select_drug_type="SELECT  mm_material_group.material_group_code, mm_material_group.short_desc, 'I' db_action, 'D' eff_status  FROM mm_material_group_lang_vw mm_material_group  WHERE material_group_code NOT IN (SELECT material_group_code FROM  mm_user_material_group WHERE user_id =? ) and mm_material_group.language_id=?  UNION ALL SELECT   mm_material_group.material_group_code, mm_material_group.short_desc,'U' db_action,  a.eff_status FROM mm_material_group_lang_vw mm_material_group,mm_user_material_group a WHERE mm_material_group.language_id=? and a.user_id =?  and mm_material_group.material_group_code=a.material_group_code ORDER BY 2";

			
			connection = getConnection();
			pstmt_select_drugtype = connection.prepareStatement(sql_select_drug_type);
			pstmt_select_drugtype.setString(1, getUser_id());
			pstmt_select_drugtype.setString(2, getLanguageId());
			pstmt_select_drugtype.setString(3, getLanguageId());
			pstmt_select_drugtype.setString(4, getUser_id());
			rset_drug_type = pstmt_select_drugtype.executeQuery();
			while((rset_drug_type!= null)&& (rset_drug_type.next())){
				materialGroupList.add(rset_drug_type.getString("MATERIAL_GROUP_CODE"));
				materialGroupList.add(rset_drug_type.getString("SHORT_DESC"));
				materialGroupList.add(rset_drug_type.getString("DB_ACTION"));
				materialGroupList.add(rset_drug_type.getString("EFF_STATUS"));
				String ff=rset_drug_type.getString("EFF_STATUS");
				if(ff.equals("E"))
				materialGroupList.add("Y");
				else
					materialGroupList.add("N");
			}

			try{
				rset_drug_type.close();
				pstmt_select_drugtype.close();
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				rset_drug_type.close();
				pstmt_select_drugtype.close();
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return materialGroupList;
}
}
