/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for ChangeBinLocationForTrayBean
*/
package eSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.*;
//import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eSS.ChangeBinLocationTray.*;


public class ChangeBinLocationForTrayBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	private String group_code;
	private String tray_no;
	private String owner_store_code;
	private String curr_store_code;
	private String bin_location_code;
	private String old_bin_location_code;
	private String expiry_date;
	private String status;
	private String doc_type_code;
	private String new_bin_location_code;
	private String new_bin_location_desc;
	private ArrayList ResultList = new ArrayList();
	// Table Column Variables 

	public void setResultList(ArrayList result) {
		this.ResultList = result;
	}
	public ArrayList getResultList(){
	return ResultList;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public void setBin_location_code(String bin_location_code) {
		this.bin_location_code = bin_location_code;
	}

	public void setNew_bin_location_code(String new_bin_location_code) {
		this.new_bin_location_code = new_bin_location_code;
	}

	public void setNew_bin_location_desc(String new_bin_location_desc) {
		this.new_bin_location_desc = new_bin_location_desc;
	}
	
	public void setOld_bin_location_code(String old_bin_location_code) {
		this.old_bin_location_code= old_bin_location_code;
	}

	public void setCurr_store_code(String curr_store_code) {
		this.curr_store_code = curr_store_code;
	}

	public void setOwner_store_code(String owner_store_code) {
		//System.err.println("inside the changeBinLocation"+owner_store_code);
		this.owner_store_code = owner_store_code;
	}

	public void setTray_no(String tray_no) {
		this.tray_no = tray_no;
	}

	public String getGroup_code(){
		return group_code;
	}
	public String getTray_no() {
		return tray_no;
	}
	public String getOwner_store_code() {
		return owner_store_code;
	}
	public String getCurr_store_code(){
		return curr_store_code;
	}
	public String getBin_location_code() {
		return bin_location_code;
	}
	public String getNew_bin_location_code() {
		return new_bin_location_code;
	}
	public String getNew_bin_location_desc() {
		return new_bin_location_desc;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public String getStatus(){
		return status;
	}
	public String getOld_bin_location_code() {
		return this.old_bin_location_code;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public String getDocTypes() throws Exception {
		String optionValues = null;
		//Get the selected Document Type Code for the given Document Type
		
		try{
			String doc_typeCode= fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_DFLT_DOC_TYPE_CODE"),getLoginFacilityId()).get("DEF_PRE_DOC_TYPE_CODE").toString();
			setDoc_type_code(doc_typeCode);	
			java.util.ArrayList alPrepareGroupDoc = new java.util.ArrayList(5);
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			alPrepareGroupDoc.add(login_facility_id);
			alPrepareGroupDoc.add("PRE");
			alPrepareGroupDoc.add(getLanguageId());
			alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"), alPrepareGroupDoc);

			optionValues = getListOptionTag(alOptionValues,getDoc_type_code());
			alPrepareGroupDoc = null;
			alOptionValues = null;
			return optionValues;
		} catch ( Exception e )	{
			//System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public void clear(){
		super.clear();
		group_code="";
		tray_no="";
		owner_store_code="";
		curr_store_code="";
		bin_location_code="";
		expiry_date="";
		status="";
		old_bin_location_code="";
	}

	public void setAll(Hashtable htRecordSet) {
		setMode((String) htRecordSet.get("mode"));
		/*setGroup_code((String) htRecordSet.get("group_code"));
		setTray_no((String) htRecordSet.get("tray_no"));
		setOwner_store_code((String) htRecordSet.get("owner_store_code"));
		setCurr_store_code((String) htRecordSet.get("curr_store_code"));
		setBin_location_code((String) htRecordSet.get("bin_location_code"));
		setExpiry_date((String) htRecordSet.get("expiry_date"));
		setStatus((String) htRecordSet.get("status"));*/
	}
	
	public String getOwnerStores() throws Exception{
		try{
			//String store_Code= fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_DFLT_DOC_TYPE_CODE"),getLoginFacilityId()).get("DEF_STORE_CODE_FOR_PRE").toString();
			String store_Code= (String)fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_DFLT_DOC_TYPE_CODE"),getLoginFacilityId()).get("DEF_STORE_CODE_FOR_PRE");//modified dt:26/6/08
			//System.err.println("Change Bin Location"+store_Code);
			setOwner_store_code(store_Code);	
			String optionValues = null;
			java.util.ArrayList alOwnerStores = new java.util.ArrayList(5);
			java.util.ArrayList alOwnerStoreValues = new java.util.ArrayList();
			alOwnerStores.add(login_facility_id);
			alOwnerStores.add(getLoginById());
			alOwnerStores.add(getLanguageId());
			alOwnerStoreValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"), alOwnerStores);
			optionValues = getListOptionTag(alOwnerStoreValues,getOwner_store_code());
			alOwnerStores = null;
			alOwnerStoreValues = null;
			return optionValues;
		} catch ( Exception e )	{
			//System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
	}
	public String getModNewBinLocation(){
		ArrayList alparams=new ArrayList();
		alparams.add(getOwner_store_code());
		alparams.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alparams), getNew_bin_location_code());
	}
	public ArrayList getBinLocations() {
        ArrayList binLocationData = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, getOwner_store_code());
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                binLocationData.add(record);
            }
        } catch (Exception e) {
            //System.err.println("Error loading values from database");
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		System.out.println("binLocationData========>"+binLocationData);
        return binLocationData;
	}

	public String getGroupName() {
		try {
			java.util.HashMap groupName = fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_SELECT_LIST_SINGLE"), getGroup_code());
			return (String)groupName.get("SHORT_DESC");
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	

    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	public ArrayList loadResultPage(String new_bin_location_code,String new_bin_location_desc,String owner_store_code,String bin_location_code,String group_code,String tray_no,String doc_type_code,String doc_no,String locale) throws Exception {
		String []  alParameters={new_bin_location_code,new_bin_location_desc,getLoginById(),owner_store_code,bin_location_code,group_code,tray_no,doc_type_code,doc_no,locale};
		//System.err.println("getLoginById"+getLoginById());
		//System.err.println("locale====in bean======"+locale);
		ArrayList listRecord =new ArrayList();
		try {
			//listRecord = fetchRecords(getSsRepositoryValue("SQL_SS_TRAY_DTLS_QUERY_RESULT"),alParameters);
			listRecord = fetchRecords("SELECT dtl.group_code, grp.short_desc group_desc, tray_no,       owner_store_code, mm.short_desc store_desc,       dtl.bin_location_code, dd.short_desc doc_desc, dtl.pre_doc_no,       mbin.short_desc bin_desc, NVL (?, '&nbsp;') new_bin_location,       NVL (?, '&nbsp;') new_bin_location_desc  FROM ss_tray_dtls dtl,       ss_group_lang_vw grp,       mm_store_lang_vw mm,       mm_bin_location_lang_vw mbin,       sy_doc_type_master_lang_vw dd WHERE curr_store_code IS NULL   AND dtl.phy_inv_id IS NULL   AND dtl.group_code = grp.group_code   AND owner_store_code = mm.store_code   AND owner_store_code = mm.store_code   AND owner_store_code = mbin.store_code   AND dtl.bin_location_code = mbin.bin_location_code   AND dtl.pre_doc_type_code = dd.doc_type_code   AND owner_store_code IN (SELECT store_code                              FROM ss_user_access_for_store                             WHERE user_id = ?                               AND pre_allowed_yn = 'Y')   AND dtl.owner_store_code LIKE UPPER (?)   AND dtl.bin_location_code LIKE UPPER (?)   AND dtl.group_code LIKE UPPER (?)   AND TO_CHAR (tray_no) LIKE ?   AND dtl.pre_doc_type_code LIKE UPPER (?)   AND dtl.pre_doc_no LIKE UPPER (?)   AND grp.language_id = mm.language_id   AND grp.language_id = mbin.language_id   AND grp.language_id = dd.language_id   AND grp.language_id=?",alParameters);
			ResultList=listRecord;
			return listRecord;
		} catch ( Exception e )	{
			//System.err.println( "Error SQL_SS_TRAY_DTLS_QUERY_RESULT values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public void loadData() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(getSsRepositoryValue("SQL_SS_TRAY_DTLS_SELECT_SINGLE")); 
			//System.err.println(getSsRepositoryValue("SQL_SS_TRAY_DTLS_SELECT_SINGLE"));
			preparedStatement.setString(1, getGroup_code());
			preparedStatement.setInt(2, Integer.parseInt(getTray_no()));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				setGroup_code(resultSet.getString("group_code"));
				setTray_no(resultSet.getString("tray_no"));
				setOwner_store_code(resultSet.getString("owner_store_code"));
				setBin_location_code(resultSet.getString("bin_location_code"));
				setExpiry_date(resultSet.getString("expiry_date"));
				setStatus(resultSet.getString("status"));
			}
			preparedStatement = null;
			resultSet = null;
		}
		catch (Exception e )	{
			//System.err.println("Error loading values from database");
			e.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				//System.err.println("Exception : "+ es.toString());
				es.printStackTrace();
			}
		}
	}

    public String getBinLocationCode() {
		String optionValues = null;
		old_bin_location_code = getBin_location_code();
		java.util.ArrayList alOptionValues = getListOptionArrayList((String)SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"), getOwner_store_code(),false);
		optionValues = getListOptionTag(alOptionValues,getBin_location_code());
		alOptionValues = null;
		return optionValues;
    }

	public String paramsInBean() {
		return "group_code" + group_code+
				"tray_no" + tray_no+
				"owner_store_code" + owner_store_code+
				"curr_store_code" + curr_store_code+
				"bin_location_code" +bin_location_code+
				"expiry_date" +expiry_date+
				"status"+status;
	}

	public HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList hmDataColl	= new ArrayList();
		ArrayList	 alModifyData =null;
		Properties properties = getProperties();
		StringBuffer messages = new StringBuffer() ;

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;
		for(int j=0;j<ResultList.size();j++) {
			HashMap hh=new HashMap();
			hh=(HashMap) ResultList.get(j);
					if(!((String)hh.get("NEW_BIN_LOCATION")).equals("&nbsp;")){
						alModifyData = new ArrayList();
						alModifyData.add((String)hh.get("NEW_BIN_LOCATION"));
						alModifyData.add(login_by_id);
						alModifyData.add(login_at_ws_no);
						alModifyData.add(login_facility_id);
						alModifyData.add((String)hh.get("GROUP_CODE"));
						alModifyData.add(new Integer((String)hh.get("TRAY_NO")));
						hmDataColl.add(alModifyData);
					}
		}
		hmTableData.put("properties",properties);
		hmTableData.put("ModifyData",hmDataColl);
		hmSQLMap.put("ModifySQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_UPDATE"));

		try {
/*				ChangeBinLocationTrayHome changeBinLocationTrayHome = null ;
				ChangeBinLocationTrayRemote changeBinLocationTrayRemote = null ;
				
				InitialContext context = new InitialContext() ;
				Object object = context.lookup(getSsRepositoryValue("JNDI_CHANGE_BIN_LOCATION_FOR_TRAY"));
				changeBinLocationTrayHome  = (ChangeBinLocationTrayHome) PortableRemoteObject.narrow(object, ChangeBinLocationTrayHome.class) ;
				changeBinLocationTrayRemote = changeBinLocationTrayHome.create() ;

				hmResult = changeBinLocationTrayRemote.modify(hmTableData, hmSQLMap) ;
				*/
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_CHANGE_BIN_LOCATION_FOR_TRAY"),ChangeBinLocationTrayHome.class,getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = hmTableData;
					argArray[1] = hmSQLMap;

					Class [] paramArray = new Class[2];
					paramArray[0] = hmTableData.getClass(); ;
					paramArray[1] = hmSQLMap.getClass();

					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				
			//hmResult=new eSS.ChangeBinLocationTray1.ChangeBinLocationTrayManager().modify(hmTableData, hmSQLMap) ;
				if(((Boolean) hmResult.get("result")).booleanValue())
					//hmResult.put("message", getMessage((String) hmResult.get("message"))) ;
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;


				else 
					hmResult.put("message", (hmResult.get("msgid"))) ;
		}
		catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} 
			//System.out.println("hmResult"+hmResult);
			
		return hmResult	;
	}
}
