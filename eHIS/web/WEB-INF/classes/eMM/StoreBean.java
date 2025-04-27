/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 
 ---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
06/04/2017	IN063261		Manoj kumar KV								   		GHL-CRF-0444			
---------------------------------------------------------------------------------------------------------

 */
package eMM ;

import java.io.Serializable ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.HashMap ;
import java.util.Hashtable ;
import java.util.ArrayList ;
import eMM.Common.MmAdapter;
import eMM.Common.MmRepository;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.SingleTableHandler.SingleTableHandlerHome;


public class StoreBean extends MmAdapter implements Serializable
{	protected String store_code				= "";
	protected String long_desc				= "";
	protected String short_desc				= "";
	protected String dept_code				= "";
	protected String cust_code				= "";
	protected String store_incharge_name	= "";
	protected String store_incharge_title	= "";
	protected String store_location			= "";
	protected String external_yn			= "N";
	protected String eff_status				= "D";
	protected String contact_ref			= "";
	protected String PO_dept_code			= "";
	protected String store_group			= "";
	protected String remarks			     = "";  //30/11/11
	protected String drug_license_no          =""; //added for GHL-CRF-0444
	public StoreBean() throws Exception
	{ 
		try
		{
			doCommon();
		}
		catch(Exception e){
		e.printStackTrace();
		}
	}
	public void setStoreCode (String store_code)
	{
		this.store_code = store_code;
	}
	public void setLongDesc (String long_desc)
	{
		this.long_desc = long_desc;
	}
	public void setShortDesc (String short_desc)
	{
		this.short_desc = short_desc;
	}

	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}*/
	public void setDeptCode (String dept_code)
	{
		this.dept_code = dept_code;
	}
	public void setPODeptCode (String PO_dept_code)
	{
		this.PO_dept_code = PO_dept_code;
	}
	public void setCustCode( String cust_code ) 
	{
		this.cust_code  = cust_code ;
	}
	public void setStoreInName( String store_incharge_name ) 
	{
		this.store_incharge_name =	store_incharge_name  ;
	}
	public void setStoreInTitle( String store_incharge_title ) 
	{
		this.store_incharge_title =	store_incharge_title  ;
	}
	public void setStoreLocation( String store_location ) 
	{
		this.store_location	= store_location  ;
	}
	public void setExternal( String external_yn ) 
	{
		this.external_yn = external_yn  ;
	}
	public void setEffStatus( String eff_status ) 
	{
		if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
	}
	
	public void setContactRef( String contact_ref)
	{
		this.contact_ref = contact_ref ;
	}
	public void setStoreGroup(String store_group) 
	{
		this.store_group = store_group ;
	}
	//30/11/11
	//Starts
	public void setRemarks(String remarks)   
	{
		this.remarks = remarks ;
	}
   public String getRemarks() 
	{
		return this.remarks;
	}
	
	//ends 30/11/11
   // starts for GHL-CRF-0444
   public void setDrugLicenseNo(String drug_license_no)   
	{
		this.drug_license_no = drug_license_no ;
	}
// Ends for GHL-CRF-0444

	public String getStoreCode() 
	{
		return this.store_code;
	}
	public String getLongDesc() 
	{
		return this.long_desc;
	}
	public String getShortDesc() 
	{
		return this.short_desc;
	}	
	public String getDeptCode() 
	{
		return this.dept_code;
	}
	public String getPODeptCode() 
	{
		return this.PO_dept_code;
	}
	
/*public String getLanguageId() 
	{
		return this.language_id;
	}*/

	public String getCustCode() 
	{
		return this.cust_code;
	}
	public String getStoreInName() 
	{
		return this.store_incharge_name	;
	}
	public String getStoreInTitle() 
	{
		return this.store_incharge_title	;
	}
	public String getStoreLocation() 
	{
		return this.store_location	;
	}
	public String getExternal() 
	{
		return this.external_yn	;
	}
	public String getEffStatus() 
	{
		return this.eff_status	;
	}
	public String getContactRef()
	{
		return this.contact_ref;
	}

	public String getStoreGroup() 
	{
		return this.store_group;
	}
	// starts for GHL-CRF-0444
	public String getDrugLicenseNo() 
	{
		return this.drug_license_no;
	}
	// Ends for GHL-CRF-0444

	public void clear()
	{
		super.clear();
		store_code = "";
		long_desc = "";
		short_desc = "";
		dept_code = "";
		cust_code = "";
		store_incharge_name = "";
		store_incharge_title = "";
		store_location = "";
		external_yn = "N";
		eff_status = "D";
		contact_ref	= "";
		PO_dept_code = "";
		store_group = "";
		remarks = "";   //30/11/11
		drug_license_no =""; // Added for GHL-CRF-0444
	}
	public void setAll (Hashtable recordSet)
	{
		super.setAll(recordSet);

		if(recordSet.containsKey("store_code"))
			setStoreCode((String)recordSet.get("store_code")) ;

		if(recordSet.containsKey("long_desc"))
			setLongDesc((String)recordSet.get("long_desc")) ;

		if(recordSet.containsKey("short_desc"))
			setShortDesc((String)recordSet.get("short_desc")) ;

		if(recordSet.containsKey("dept_code"))
			setDeptCode((String)recordSet.get("dept_code")) ;

		if(recordSet.containsKey("cust_code"))
			setCustCode((String)recordSet.get("cust_code"));

		if(recordSet.containsKey("store_incharge_name"))
			setStoreInName((String)recordSet.get("store_incharge_name"));

		if(recordSet.containsKey("store_incharge_title"))
			setStoreInTitle((String)recordSet.get("store_incharge_title"));

		if(recordSet.containsKey("store_location"))
			setStoreLocation((String)recordSet.get("store_location"));

		if(recordSet.containsKey("external_yn") && (!((String)recordSet.get("external_yn")).equals("")))
			setExternal((String)recordSet.get("external_yn"));
		else
			setExternal("N");

		if(recordSet.containsKey("eff_status") && (!((String)recordSet.get("eff_status")).equals("")))
			setEffStatus((String)recordSet.get("eff_status"));
		else
			setEffStatus("D");

		if(recordSet.containsKey("contact_ref"))
			setContactRef((String)recordSet.get("contact_ref"));
		if(recordSet.containsKey("PO_dept_code"))
			setPODeptCode((String)recordSet.get("PO_dept_code")) ;
			else
			setPODeptCode("") ;
		
		if(recordSet.containsKey("store_group"))
			setStoreGroup((String)recordSet.get("store_group")) ;
		if(recordSet.containsKey("remarks"))
		setRemarks((String)recordSet.get("remarks")) ;//30/11/11

		if(recordSet.containsKey("drug_license_no")) // Added for GHL-CRF-0444
			setDrugLicenseNo((String)recordSet.get("drug_license_no")) ;// Added for GHL-CRF-0444
	}

	private void doCommon() throws Exception 
	{
	}

	public HashMap validate()throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public HashMap insert()
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap() ;

		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();
		ArrayList LanguageData = new ArrayList() ;

		InsertData.add(store_code);		
		InsertData.add(long_desc);
		InsertData.add(short_desc);
		InsertData.add(login_facility_id);
		InsertData.add(dept_code);
		InsertData.add(cust_code);
		InsertData.add(store_incharge_name);
		InsertData.add(store_incharge_title);
		InsertData.add(store_location);
		InsertData.add(external_yn);
		InsertData.add(contact_ref);
		InsertData.add(eff_status);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(PO_dept_code);
		InsertData.add(store_group);
		InsertData.add(remarks); //30/11/11
		InsertData.add(drug_license_no); // Added for GHL-CRF-0444
		WhereData.add(store_code);
		
		LanguageData.add(getLanguageId());
		tabData.put( "InsertData",	InsertData ) ;
		tabData.put( "WhereData",	WhereData ) ;
		tabData.put( "properties",	getProperties() ) ;
		tabData.put( "LanguageData",LanguageData);
		
		HashMap sqlMap = new HashMap() ;
	//	sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_STORE_INSERT" ));
	//	sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_STORE_CODE_EXISTS "));

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try {
		//sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_STORE_INSERT" ));
		//sqlMap.put( "InsertSQL", "INSERT INTO mm_store ( store_code, long_desc, short_desc, facility_id, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, external_yn, contact_ref,eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,PO_dept_code,store_group_code,remarks ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? ,?,?,?)");
			// Added for GHL-CRF-0444
		sqlMap.put( "InsertSQL", "INSERT INTO mm_store ( store_code, long_desc, short_desc, facility_id, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, external_yn, contact_ref,eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,PO_dept_code,store_group_code,remarks,drug_license_no ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? ,?,?,?,?)");

		sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_STORE_CODE_EXISTS"));


				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

		
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/
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
				
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST") ) ;
			} 
			catch(Exception e)
			{
//				System.err.println( "Error Calling EJB : "+e.toString() ) ;
				map.put( "message", e.toString()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee )
					{
//						System.err.println( ee.getMessage() ) ;
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

		ModifyData.add(long_desc);
		ModifyData.add(short_desc);		
		ModifyData.add(dept_code);
		ModifyData.add(cust_code);
		ModifyData.add(store_incharge_name);
		ModifyData.add(store_incharge_title);
		ModifyData.add(store_location);
		ModifyData.add(external_yn);
		ModifyData.add(contact_ref);
		ModifyData.add(eff_status);
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(PO_dept_code);
		ModifyData.add(store_group);
		ModifyData.add(remarks); 
		ModifyData.add(drug_license_no); // Added for GHL-CRF-0444
		ModifyData.add(store_code);
		
		
		LanguageData.add(getLanguageId());

		tabData.put( "ModifyData",	ModifyData ) ;
		System.out.println("tabData 393" +tabData);
		tabData.put( "properties",	getProperties() ) ;
		tabData.put( "LanguageData",LanguageData);
		
		HashMap sqlMap = new HashMap() ;
		SingleTableHandlerRemote remote = null ;
		try
		{
		
		//sqlMap.put("ModifySQL", MmRepository.getMmKeyValue( "SQL_MM_STORE_UPDATE" ));
		//sqlMap.put("ModifySQL", "UPDATE mm_store SET long_desc = ?, short_desc = ?, dept_code =?, cust_code = ?, store_incharge_name = ?, store_incharge_title = ?, store_location = ?, external_yn = ?, contact_ref = ? ,eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?,PO_dept_code=?,store_group_code=?,remarks=? WHERE store_code = ?");
			// Added for GHL-CRF-0444
			sqlMap.put("ModifySQL", "UPDATE mm_store SET long_desc = ?, short_desc = ?, dept_code =?, cust_code = ?, store_incharge_name = ?, store_incharge_title = ?, store_location = ?, external_yn = ?, contact_ref = ? ,eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?,PO_dept_code=?,store_group_code=?,remarks=?,drug_license_no=? WHERE store_code = ?");
				
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER")) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
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
					map.put("message", getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST"));		
			}
			catch(Exception e)
			{
				System.err.println( "Error Calling EJB : "+e ) ; 
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
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace() ;
				}
			}

		return map ;
	}

	public void loadData() throws Exception {
		Connection connection = null; 
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			//pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_STORE_MODIFY"));
			//pstmt = connection.prepareStatement("SELECT store_code, long_desc, short_desc, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, contact_ref ,external_yn, eff_status,PO_dept_code,store_group_code,remarks FROM mm_store_lang_vw mm_store WHERE store_code=? AND facility_id=? AND language_id = ?");
			// Added for GHL-CRF-0444
			pstmt = connection.prepareStatement("SELECT store_code, long_desc, short_desc, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, contact_ref ,external_yn, eff_status,PO_dept_code,store_group_code,remarks,drug_license_no FROM mm_store_lang_vw mm_store WHERE store_code=? AND facility_id=? AND language_id = ?");

			pstmt.setString( 1, store_code);
			pstmt.setString( 2, login_facility_id);
			pstmt.setString( 3, getLanguageId());

			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setStoreCode(resultSet.getString("store_code"));
				setLongDesc(resultSet.getString("long_desc"));
				setShortDesc(resultSet.getString("short_desc"));
				setDeptCode(checkForNull(resultSet.getString("dept_code")));
				setCustCode(checkForNull(resultSet.getString("cust_code")));				
				setStoreInName(checkForNull(resultSet.getString("store_incharge_name")));
				setStoreInTitle(checkForNull(resultSet.getString("store_incharge_title")));
				setStoreLocation(checkForNull(resultSet.getString("store_location")));
				setContactRef(checkForNull(resultSet.getString("contact_ref")));
				setExternal(resultSet.getString("external_yn"));
				setEffStatus(resultSet.getString("eff_status"));
				setPODeptCode(resultSet.getString("PO_dept_code"));	
				setStoreGroup(resultSet.getString("store_group_code"));
                setRemarks(resultSet.getString("remarks"));					
                setDrugLicenseNo(checkForNull(resultSet.getString("drug_license_no"))); // Added for GHL-CRF-0444
				
			}
		} 
		catch (Exception e )	{
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
				es.printStackTrace();
			}

		}
	}
	
	public String isARModuleInstalled() throws Exception{
		String	bReturn="";
		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_STORE_AR_MODULE_SEARCH"));
			preparedStatement.setString(1,getAccEntityID() );
			resultSet=preparedStatement.executeQuery();
			if(resultSet!=null && resultSet.next())//Added by suresh.r on 12-03-2015
				bReturn=(resultSet.getString("OPERATIONAL_YN"));
			if(preparedStatement != null)
					closeStatement(preparedStatement);
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
		finally
		{
			try{
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);

			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return bReturn;
	}	

	public ArrayList getDepartment() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrDept			=	new  ArrayList();
		HashMap		hmDept 			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_STORE_DEPT")); //Commented by Martin eSS.Common.SsInterface.SQL_SS_SURGERYTYPE_MODIFY
				pstmt.setString( 1, login_facility_id);
				resultSet = pstmt.executeQuery();
//				System.err.println("SQL_MM_STORE_SELECT : " +MmRepository.getMmKeyValue("SQL_MM_STORE_SELECT") + " : " +store_code);
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmDept			=	new HashMap();
					hmDept.put("code",checkForNull(resultSet.getString(1)));
					hmDept.put("desc",checkForNull(resultSet.getString(2)));
					arrDept.add(hmDept);
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
			return arrDept;
		}
 public String getInterface_to_external_po_yn(String acc_entity_id){
	 String result_yn = "N";
	try{
		HashMap result = (HashMap)fetchRecord("select INTERFACE_TO_EXTERNAL_PO_YN from st_acc_entity_param where acc_entity_id=?",acc_entity_id);
		result_yn = checkForNull((String)result.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	}catch(Exception e){
		e.printStackTrace();
	}
	return result_yn;
 }

	public String getStoreGroupEnabled(String strStoreGroupCode,String strDisabled) {
		String sql ="";
		if(mode.equals("1")){
			sql ="SELECT STORE_GROUP_CODE,SHORT_DESC FROM MM_STORE_GROUP_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
		}else if(mode.equals("2")){
			if(strDisabled.equals("")){
				sql ="SELECT STORE_GROUP_CODE,SHORT_DESC FROM MM_STORE_GROUP_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
			}else{
				sql ="SELECT STORE_GROUP_CODE,SHORT_DESC FROM MM_STORE_GROUP_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY SHORT_DESC";
			}
		}
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(sql, sqlParam),strStoreGroupCode);
	}

}

 
