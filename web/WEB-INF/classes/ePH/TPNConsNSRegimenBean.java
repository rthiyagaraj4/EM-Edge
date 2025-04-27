/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.TPNConsNSRegimen.*;

//saved on 25/10/2005
public class TPNConsNSRegimenBean extends PhAdapter implements Serializable {

	protected Hashtable recordSet = null;
	private ArrayList exstingItems = new ArrayList();
	ArrayList osmolvalue =new ArrayList();
	ArrayList contprsUOM =new ArrayList();
	private HashMap  applicable		   = new HashMap();//added for ML-MMOH-CRF-1201
	ArrayList applicablList =null;//added for ml-mmoh-crf-1201
	

	public void setExstngItems(ArrayList exstng_items){
		this.exstingItems = exstng_items;
	}

	public ArrayList getExstngItems(){
		return this.exstingItems;
	}
	public void setOsmolar(ArrayList osmolvalue)	{
		this.osmolvalue	=	osmolvalue;
	}

	public ArrayList getOsmolar()	{
		return this.osmolvalue;
	}

	public void setContprsUOM(ArrayList contprsUOM)	{
		this.contprsUOM	=	contprsUOM;
	}

	public ArrayList getContprsUOM()	{
		return this.contprsUOM;
	}
	//added for ML-MMOH-CRF-1201 START
	public void setApplicabulityMap (HashMap applicable){
		this.applicable = applicable;
		}
		public HashMap getApplicabulityMap() {
			return applicable;
		}
		public ArrayList getApplicablList() {
			return applicablList;
		}

		public void setApplicablList(ArrayList applicablList) {
			this.applicablList = applicablList;
		}
		
		//added for ML-MMOH-CRF-1201 END
	public TPNConsNSRegimenBean() {
        try {
            doCommon();
        }
        catch(Exception e) {e.printStackTrace();}
    }

    public void clear() {	
        super.clear() ;
          applicable		   = new HashMap();//added for ML-MMOH-CRF-1201
    	//ArrayList applicablList =null;//added for ml-mmoh-crf-1201 //Commented for common-icn-0048
    }

    private void doCommon() throws Exception {
    }

    public void setAll( Hashtable recordSetMultiple ) {
		this.mode = (String)recordSetMultiple.get("mode");
		recordSet = recordSetMultiple;
	}

	public Hashtable getInitialValues(String locale) throws Exception{
		Hashtable result = new Hashtable();		
		ArrayList arr_list_generic = new ArrayList();
		ArrayList arr_list_molecule = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT1") ) ;
		  pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_generic.add(resultSet.getString("CONST_GENERIC_CODE"));
				arr_list_generic.add(resultSet.getString("CONST_GENERIC_NAME"));
				arr_list_generic.add(resultSet.getString("CONST_GROUP_CODE"));				
			}
			if(resultSet!=null)		closeResultSet( resultSet ) ;
            if(pstmt!=null)			closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT2") ) ;
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_molecule.add(resultSet.getString("MOLECULE_CODE"));
				arr_list_molecule.add(resultSet.getString("DESCRIPTION"));
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		result.put("arr_list_generic",arr_list_generic);
		result.put("arr_list_molecule",arr_list_molecule);
		//System.err.println("result--------->"+result);
		return result;		
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

		ArrayList tpn_const_for_ns_regimen = new ArrayList();
		ArrayList inv_item_for_ns_regimen  = new ArrayList();
		ArrayList common_values			   = new ArrayList();
		ArrayList items					   = new ArrayList();
		boolean site_bru=false;//added for ml-bru-crf-1201
		Connection connection	= null;//added for ml-mmoh-crf-1201
		// Forming ArrayList for PH_TPN_CONST_FOR_NS_REGIMEN
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_generic_code"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_short_name"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_long_name"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("physical_form"));
		if(((String)recordSet.get("concentration_percent")==null)||((String)recordSet.get("const_long_name")).equals("")){
			tpn_const_for_ns_regimen.add("");
		}else{
			tpn_const_for_ns_regimen.add((String)recordSet.get("concentration_percent"));
		}
		if(((String)recordSet.get("manufacturer_var_percentage")==null)||((String)recordSet.get("manufacturer_var_percentage")).equals("")){
			tpn_const_for_ns_regimen.add("");
		}else{
			tpn_const_for_ns_regimen.add((String)recordSet.get("manufacturer_var_percentage"));
		}		
		if(((String)recordSet.get("eff_status")==null)||((String)recordSet.get("eff_status")).equals("")){
			tpn_const_for_ns_regimen.add("D");
		}else{
			tpn_const_for_ns_regimen.add("E");
		}
		
		//HashMap map_applicable=getApplicabulityMap(); //Commented for common-icn-0048
		//HashMap map1 =new HashMap(); //Commented for common-icn-0048
		int tot_no_of_rows = Integer.parseInt((String)recordSet.get("tot_no_of_rows"));
		for (int i=1;i<=tot_no_of_rows ; i++){
			if(((String)recordSet.get("item_add"+i)).equals("Y")){
				inv_item_for_ns_regimen.add((String)recordSet.get("const_generic_code"));
				inv_item_for_ns_regimen.add((String)recordSet.get("item_code"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("stock_uom_code"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("molecule"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("osmolar_value"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("content_in_pres_base_uom"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("item_concentration"+i));//Added for ML-MMOH-CRF-1201
				inv_item_for_ns_regimen.add((String)recordSet.get("volume"+i));//Added for ML-MMOH-CRF-1201
				if(!applicable.containsKey((String)recordSet.get("item_code"+i))){
					getAgeGroupsNS(language_id,(String)recordSet.get("item_code"+i));
				}
			}
		}

		
		common_values.add(login_by_id.trim());								 // added_by_id
		common_values.add(login_at_ws_no.trim());							 // added_at_ws_no
		common_values.add(login_facility_id.trim());                         // added_facility_id
		
		try{
			items = (ArrayList)checkExistingItems();
		 
		}catch(Exception e){
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
		}
		if(items.size() != 0){
			map.put( "message", "APP-002005 Record Already Exists... : "+items);
			map.put("flag","0");
		}else{


//		TPNConsNSRegimenHome     home=null;
//		TPNConsNSRegimenRemote remote=null;
		try{
			connection = getConnection() ;//added for ml-mmoh-crf-1201
			 site_bru =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","APPLICABILITY_SETTINGS");//ADDED FOR ML-MMOH-CRF-1201
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			
			tabData.put("common_values",common_values);
			tabData.put("tpn_const_for_ns_regimen",tpn_const_for_ns_regimen);
			tabData.put("inv_item_for_ns_regimen",inv_item_for_ns_regimen);
			//added for ml-bru-crf-1201 start
			tabData.put("site_bru",site_bru);
			tabData.put("applicablList",applicablList);
			tabData.put("applicableMap",applicable);
			//added for ml-bru-crf-1201 end

			HashMap sqlMap = new HashMap() ;
			String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1="INSERT INTO PH_INV_ITEM_FOR_NS_REGIMEN(CONST_SRL_NO,CONST_GENERIC_CODE, ITEM_CODE, STOCK_UOM, MOLECULE_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CONTENT_IN_PRES_BASE_UOM,OSMOLAR_VALUE,ITEM_CONCENTRATION_PERCENT,VOLUME) VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";//ITEM_CONCENTRATION_PERCENT,VOLUME Added for ML-MMOH-CRF-1201
			sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1",SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1);
			sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2"));
			sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5"));
			sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6"));
			sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY","INSERT INTO PH_TPN_CONST_APPL_SETTING(CONST_GENERIC_CODE, item_code,AGE_GROUP_CODE,APPL_STATUS,added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no, modified_facility_id)VALUES (?, ?, ?, ?,?,SYSDATE, ?,?, ?, SYSDATE,?, ?)");		
			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_TPN_CONS_NS_REGIMEN") ) ;

				home  = (TPNConsNSRegimenHome) PortableRemoteObject.narrow( object, TPNConsNSRegimenHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.insert( tabData, sqlMap ) ;*/


     Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPN_CONS_NS_REGIMEN" ),TPNConsNSRegimenHome.class,getLocalEJB());

     Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

	 Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

	 Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();
	
	HashMap result  = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
				if( ((Boolean) result.get( "result" )).booleanValue() )	{
					map.put( "result", new Boolean( true ) ) ;		
					map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH"));
					map.put("flag","0");
				}
				else{
					map.put( "message", result.get("msgid") ) ;
					map.put("flag","0");
				}
			}//try
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}//catch
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}
	finally{
		 try {
			closeConnection( connection );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}	
		return map;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList tpn_const_for_ns_regimen = new ArrayList();
		ArrayList inv_item_for_ns_regimen  = new ArrayList();
		ArrayList common_values			   = new ArrayList();
		ArrayList items					   = new ArrayList();
		ArrayList modiOsmolVal			   = new ArrayList();
		ArrayList ContPrsUomVal			   = new ArrayList();
		//ArrayList osmolmdVal			   = new ArrayList();  //Commented for common-icn-0048
		//ArrayList osmolmdValAl = new ArrayList(); //Commented for common-icn-0048
		//String	osmolar_value ="";  //Commented for common-icn-0048
		String	osmolVal ="";
		//String osmolVal1="";  //Commented for common-icn-0048
		String itm_code="";
		String PrsBaseUomVal="";
		String moleculeVal="";
		String item_concentration_percent="";//Added for ML-MMOH-CRF-1201
		String volume ="";//Added for ML-MMOH-CRF-1201
		boolean site_bru=false;//added for ml-bru-crf-1201
		Connection connection	= null;//added for ml-mmoh-crf-1201
		modiOsmolVal = getOsmolar();
		ContPrsUomVal = getContprsUOM();

		
		ArrayList BaseUomVal = new ArrayList();
		String PrsBaseUom ="";

		// Forming ArrayList for PH_TPN_CONST_FOR_NS_REGIMEN
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_generic_code"));
		//tpn_const_for_ns_regimen.add((String)recordSet.get("const_srl_no"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_short_name"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("const_long_name"));
		tpn_const_for_ns_regimen.add((String)recordSet.get("physical_form"));
		if(((String)recordSet.get("concentration_percent")==null)||((String)recordSet.get("const_long_name")).equals("")){
			tpn_const_for_ns_regimen.add("");
		}else{
			tpn_const_for_ns_regimen.add((String)recordSet.get("concentration_percent"));
		}
		if(((String)recordSet.get("manufacturer_var_percentage")==null)||((String)recordSet.get("manufacturer_var_percentage")).equals("")){
			tpn_const_for_ns_regimen.add("");
		}else{
			tpn_const_for_ns_regimen.add((String)recordSet.get("manufacturer_var_percentage"));
		}		
		if(((String)recordSet.get("eff_status")==null)||((String)recordSet.get("eff_status")).equals("")){
			tpn_const_for_ns_regimen.add("D");
		}else{
			tpn_const_for_ns_regimen.add("E");
		}

		int tot_no_of_rows = Integer.parseInt((String)recordSet.get("tot_no_of_rows"));

		for (int i=1;i<=tot_no_of_rows ; i++){

			osmolVal="";
			moleculeVal="";
			item_concentration_percent="";//Added for ML-MMOH-CRF-1201
            volume="";//Added for ML-MMOH-CRF-1201

			if(((String)recordSet.get("item_add"+i)).equals("Y")){

			itm_code=(String)recordSet.get("item_code"+i);

/*
			for(int j=0;j<modiOsmolVal.size();j=j+2) {
				if(!(modiOsmolVal.get(j).equals(itm_code))) {
					osmolVal=(String)recordSet.get("osmolar_value"+i);	
				}

			else if(modiOsmolVal.get(j).equals(itm_code)) {
					osmolVal=(String)modiOsmolVal.get(j+1);	
				}
			}
*/

		
		for(int j=0;j<modiOsmolVal.size();j=j+6) {//Changed 4 to 6 for ML-MMOH-CRF-1201

		BaseUomVal.add(modiOsmolVal.get(j+3));

			for(int k=0;k<BaseUomVal.size();k++){
			PrsBaseUom = (String)BaseUomVal.get(k);
			}
		}

			for(int j=0;j<modiOsmolVal.size();j=j+6) {//Changed 4 to 6 for ML-MMOH-CRF-1201

				if(!(modiOsmolVal.get(j).equals(itm_code))) {
					osmolVal=(String)recordSet.get("osmolar_value"+i)==null?"":(String)recordSet.get("osmolar_value"+i);	
					moleculeVal=(String)recordSet.get("molecule"+i)==null?"":(String)recordSet.get("molecule"+i);	
					PrsBaseUomVal=(String)recordSet.get("content_in_pres_base_uom"+i)==null?"":(String)recordSet.get("content_in_pres_base_uom"+i);	
					item_concentration_percent=(String)recordSet.get("item_concentration"+i)==null?"":(String)recordSet.get("item_concentration"+i);//Added for ML-MMOH-CRF-1201
                    volume=(String)recordSet.get("volume"+i)==null?"":(String)recordSet.get("volume"+i);//Added for ML-MMOH-CRF-1201
				}

			else if(modiOsmolVal.get(j).equals(itm_code)) {
					osmolVal=(String)modiOsmolVal.get(j+1)==null?"":(String)modiOsmolVal.get(j+1);	
					moleculeVal=(String)modiOsmolVal.get(j+2)==null?"":(String)modiOsmolVal.get(j+2);
					PrsBaseUomVal=(String)modiOsmolVal.get(j+3)==null?"":(String)modiOsmolVal.get(j+3);	
					item_concentration_percent=(String)modiOsmolVal.get(j+4)==null?"":(String)modiOsmolVal.get(j+4);//Added for ML-MMOH-CRF-1201
                    volume=(String)modiOsmolVal.get(j+5)==null?"":(String)modiOsmolVal.get(j+5);//Added for ML-MMOH-CRF-1201
					break;
				}
			}

		/*
			for(int j=0;j<ContPrsUomVal.size();j=j+2) {
				if(!(ContPrsUomVal.get(j).equals(itm_code))) {
					PrsBaseUomVal=(String)recordSet.get("content_in_pres_base_uom"+i);	
				}

			else if(ContPrsUomVal.get(j).equals(itm_code)) {
					PrsBaseUomVal=(String)ContPrsUomVal.get(j+3);	
				}
			}
			*/

				inv_item_for_ns_regimen.add((String)recordSet.get("const_generic_code"));
			//	inv_item_for_ns_regimen.add((String)recordSet.get("item_code"+i));
				inv_item_for_ns_regimen.add(itm_code);
			//	inv_item_for_ns_regimen.add((String)recordSet.get("const_srl_no"+i));
				inv_item_for_ns_regimen.add((String)recordSet.get("stock_uom_code"+i));
//				inv_item_for_ns_regimen.add((String)recordSet.get("molecule"+i));	
				inv_item_for_ns_regimen.add(moleculeVal);	
			//	inv_item_for_ns_regimen.add((String)recordSet.get("osmolar_value"+i));
				inv_item_for_ns_regimen.add(osmolVal);
//				inv_item_for_ns_regimen.add((String)recordSet.get("content_in_pres_base_uom"+i));		
				inv_item_for_ns_regimen.add(PrsBaseUomVal);
				inv_item_for_ns_regimen.add(item_concentration_percent);//Added for ML-MMOH-CRF-1201
				inv_item_for_ns_regimen.add(volume);//Added for ML-MMOH-CRF-1201
				if(!applicable.containsKey(itm_code)){
					getAgeGroupsNS(language_id,itm_code);
				}
			}
		}

		common_values.add(login_by_id.trim());								 // added_by_id
		common_values.add(login_at_ws_no.trim());							 // added_at_ws_no
		common_values.add(login_facility_id.trim());                         // added_facility_id
		
		
		try{
			items = (ArrayList)checkExistingItems();
		
		}catch(Exception e){
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
		}
		if(items.size() != 0){
			map.put( "message", "APP-002005 Record Already Exists... : "+items);
			map.put("flag","0");
		}else{

//			TPNConsNSRegimenHome     home=null;
//			TPNConsNSRegimenRemote remote=null;
			try{
				connection = getConnection() ;//added for ml-mmoh-crf-1201
				 site_bru =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","APPLICABILITY_SETTINGS");//ADDED FOR ML-MMOH-CRF-1201
				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				
				tabData.put("common_values",common_values);
				tabData.put("tpn_const_for_ns_regimen",tpn_const_for_ns_regimen);
				tabData.put("inv_item_for_ns_regimen",inv_item_for_ns_regimen);
				tabData.put("exsting_items",getExstngItems());
				//added for ml-bru-crf-1201 start
				tabData.put("site_bru",site_bru);
				tabData.put("applicablList",applicablList);
				tabData.put("applicableMap",applicable);
				//added for ml-bru-crf-1201 end

				HashMap sqlMap = new HashMap() ;
				String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1="INSERT INTO PH_INV_ITEM_FOR_NS_REGIMEN(CONST_SRL_NO,CONST_GENERIC_CODE, ITEM_CODE, STOCK_UOM, MOLECULE_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CONTENT_IN_PRES_BASE_UOM,OSMOLAR_VALUE,ITEM_CONCENTRATION_PERCENT,VOLUME) VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";//,ITEM_CONCENTRATION_PERCENT,VOLUME added for ML-MMOH-CRF-1201
	            sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1",SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1);
			 	sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2"));
				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE"));
				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE1",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE1"));

				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_UPDATE",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_UPDATE"));
				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5",PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5"));
				//added for ml-bru-crf-1201 start
				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY","INSERT INTO PH_TPN_CONST_APPL_SETTING(CONST_GENERIC_CODE, item_code,AGE_GROUP_CODE,APPL_STATUS,added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no, modified_facility_id)VALUES (?, ?, ?, ?,?,SYSDATE, ?,?, ?, SYSDATE,?, ?)");
				sqlMap.put("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE_APPLICABILITY","DELETE FROM PH_TPN_CONST_APPL_SETTING  WHERE CONST_GENERIC_CODE=?  and item_code =? and added_facility_id=?");
				//added for ml-bru-crf-1201 end
				try {
/*					InitialContext context = new InitialContext() ;
					Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_TPN_CONS_NS_REGIMEN") ) ;

					home  = (TPNConsNSRegimenHome) PortableRemoteObject.narrow( object, TPNConsNSRegimenHome.class ) ;
					remote = home.create() ;
					HashMap result = remote.modify( tabData, sqlMap ) ;*/
					
	Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPN_CONS_NS_REGIMEN" ),TPNConsNSRegimenHome.class,getLocalEJB());

  Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

  Object argArray[] =new Object[2];
		argArray[0]= tabData;
		argArray[1]=sqlMap;

Class  paramArray[] = new Class[2];
		paramArray[0]= tabData.getClass();
		paramArray[1] = sqlMap.getClass();

HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					
						// System.err.println("getLanguageId--------->"+getLanguageId());
					
					if( ((Boolean) result.get( "result" )).booleanValue() )	{
						map.put( "result", new Boolean( true ) ) ;		
						map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
						map.put("flag","0");
					}
					else{
						map.put( "message", result.get("msgid") ) ;
						map.put("flag","0");
					}
				}//try
				catch(Exception e) {
					map.put( "message", e.getMessage()) ;
					e.printStackTrace() ;
				}//catch
			}//try
			catch(Exception e){
				map.put( "message", "exp :"+e.getMessage()) ;
				map.put("flag","0");
				e.printStackTrace() ;
			}finally{
				 try {
						closeConnection( connection );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
		}
		return map;
	}
	
	public String getSaleUOMCode(String item_code) throws Exception{
		String result = "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT4") ) ;
			pstmt.setString(1,item_code.trim());
		    resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("SALE_UOM_CODE");
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;		
	}

	public ArrayList getModifyData(String const_generic_code,String const_srl_no,String locale)throws Exception{
		ArrayList result = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;

		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT8") ) ;
			pstmt.setString(1,const_generic_code.trim());
			pstmt.setString(2,const_srl_no.trim());
			pstmt.setString(3,locale.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("CONST_GENERIC_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_NAME"));
				result.add(resultSet.getString("CONST_SHORT_NAME"));
				result.add(resultSet.getString("CONST_LONG_NAME"));
				result.add(resultSet.getString("PHYSICAL_FORM"));
				result.add(resultSet.getString("CONCENTRATION_PERCENT"));
				result.add(resultSet.getString("MANUFACTURER_VAR_PERCENTAGE"));
				result.add(resultSet.getString("EFF_STATUS"));				
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;
	}

//@  contpressbaseUOM


  public ArrayList getcontPrssUOM(String item_code,String const_generic_code) throws Exception {

  		ArrayList exstcontPresuom = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			
			connection = getConnection() ;
		    pstmt = connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM FROM PH_INV_ITEM_FOR_NS_REGIMEN WHERE item_code = ? AND CONST_GENERIC_CODE=?");
			pstmt.setString(1,item_code.trim());
			pstmt.setString(2,const_generic_code.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				exstcontPresuom.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));
			}
		setContprsUOM(exstcontPresuom);
		}

		catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return exstcontPresuom;
  }


  public ArrayList loadContPrssUOM(String item_code,String const_generic_code) throws Exception {

  		ArrayList exstcontPresuomVal = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			
			connection = getConnection() ;
		    pstmt = connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM FROM PH_INV_ITEM_FOR_NS_REGIMEN WHERE item_code = ? AND CONST_GENERIC_CODE=?");
			pstmt.setString(1,item_code.trim());
			pstmt.setString(2,const_generic_code.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				exstcontPresuomVal.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));
			}

//			setContprsUOM(exstcontPresuomVal);

		}

		catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return exstcontPresuomVal;
  }

///@
 public ArrayList getItemModifyData(String const_generic_code, String conc_percent,String locale)throws Exception{
		ArrayList result = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		ArrayList exsting_items = new ArrayList();
		ArrayList osml_values = new ArrayList();
		if(conc_percent==null){conc_percent="";}
        try {
			
			connection = getConnection() ;
		   //pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT9") ) ;
            pstmt = connection.prepareStatement("SELECT CONTENT_IN_PRES_BASE_UOM,A.CONST_GENERIC_CODE, A.ITEM_CODE,B.SHORT_DESC ITEM_DESC, D.MOLECULE_CODE,D.OSMOLAR_VALUE,C.DESCRIPTION MOLECULE_DESC, D.STOCK_UOM STOCK_UOM,D.ITEM_CONCENTRATION_PERCENT,D.VOLUME FROM PH_TPN_CNST_FR_NS_RGMN_LANG_VW A,MM_ITEM_LANG_VW B,PH_TPN_ELECT_MOL_FORMULA C, PH_INV_ITEM_FOR_NS_REGIMEN D WHERE A.ITEM_CODE = B.ITEM_CODE AND A.CONST_GENERIC_CODE = D.CONST_GENERIC_CODE AND A.ITEM_CODE=D.ITEM_CODE AND D.MOLECULE_CODE = C.MOLECULE_CODE(+) AND A.CONST_GENERIC_CODE=? AND NVL(CONCENTRATION_PERCENT,100) = NVL(?,100) AND A.LANGUAGE_ID = B.LANGUAGE_ID AND A.LANGUAGE_ID = ?") ;//,D.ITEM_CONCENTRATION_PERCENT,D.VOLUME Added for ML-MMOH-CRF-1201
			pstmt.setString(1,const_generic_code.trim());
			pstmt.setString(2,conc_percent.trim());
			pstmt.setString(3,locale.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("CONST_GENERIC_CODE"));
				
				result.add(resultSet.getString("ITEM_CODE"));

				exsting_items.add(resultSet.getString("ITEM_CODE"));

				result.add(resultSet.getString("ITEM_DESC"));
				
				result.add(resultSet.getString("MOLECULE_CODE"));			

				result.add(resultSet.getString("MOLECULE_DESC"));

				result.add(resultSet.getString("STOCK_UOM"));

				result.add(resultSet.getString("OSMOLAR_VALUE"));
				result.add(resultSet.getString("ITEM_CONCENTRATION_PERCENT"));//Added for ML-MMOH-CRF-1201
				result.add(resultSet.getString("VOLUME"));//Added for ML-MMOH-CRF-1201

				osml_values.add(resultSet.getString("ITEM_CODE"));
				osml_values.add(resultSet.getString("OSMOLAR_VALUE"));
				osml_values.add(resultSet.getString("MOLECULE_CODE"));
				osml_values.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));
				osml_values.add(resultSet.getString("ITEM_CONCENTRATION_PERCENT"));//Added for ML-MMOH-CRF-1201
				osml_values.add(resultSet.getString("VOLUME"));//Added for ML-MMOH-CRF-1201
			}
		setOsmolar(osml_values);
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		setExstngItems(exsting_items);
		return result;
	}


	
	public String getGroupCode(String const_generic_code)throws Exception{
		String result = "";	
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT1A") ) ;
			pstmt.setString(1,const_generic_code.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("CONST_GROUP_CODE");
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;
	}

	public String getContentInPresBaseUOM(String item_stock_uom)throws Exception{
		//ArrayList uomResult = new ArrayList();  //Commented for common-icn-0048
		Connection connection				= null ;
        PreparedStatement pstmt				= null ;
        ResultSet resultSet					= null;
		String tpn_prescribing_base_unit	= "";
		String result						= "";	
		
        try {
			connection = getConnection() ;
			/*pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT11") ) ;
			pstmt.setString(1,generic_code.trim());
			pstmt.setString(2,generic_code.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next()){
				sale_uom_code = resultSet.getString("SALE_UOM_CODE");
			}*/

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT5") ) ;
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next()){
				tpn_prescribing_base_unit = resultSet.getString("REGIMEN_PRESC_BASE_UNIT");
			}

			if(tpn_prescribing_base_unit.equals(item_stock_uom)){
				result = "1";
			}else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT10") ) ;
				pstmt.setString(1,tpn_prescribing_base_unit.trim());
				pstmt.setString(2,item_stock_uom.trim());
				pstmt.setString(3,item_stock_uom.trim());
				pstmt.setString(4,tpn_prescribing_base_unit.trim());

				resultSet = pstmt.executeQuery() ;
				while ( resultSet != null && resultSet.next() ) {
					result = resultSet.getString("EQVL_VALUE");					
				}
				
				if(result==null || result.equals("")){
					result = "NO";
				}
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
//		uomResult.add(result);

		return result;

	}

	
	public ArrayList checkExistingItems()throws Exception{

		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;

		ArrayList item = new ArrayList();
		ArrayList exstingItems = new ArrayList();
		exstingItems = getExstngItems();

        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT12") ) ;
			
			int tot_no_of_rows = Integer.parseInt((String)recordSet.get("tot_no_of_rows"));
			for (int i=1;i<=tot_no_of_rows ; i++){

			if(!exstingItems.contains((String)recordSet.get("item_code"+i))){
				if(((String)recordSet.get("item_add"+i)).equals("Y")) {
					pstmt.setString(1,(String)recordSet.get("const_generic_code"));
					pstmt.setString(2,(String)recordSet.get("item_code"+i));
					resultSet = pstmt.executeQuery() ;
					if(resultSet.next()){
						if(!resultSet.getString("COUNT").equals("0")) {
								item.add((String)recordSet.get("item_code"+i));
						}
					}	
				}
			}	
		}
		
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }

		return item;
	}
	//addedfor ml-mmoh-crf-1201 start
	public ArrayList  getAgeGroupsNS(String locale,String drug_code)
	{
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			ArrayList result=new ArrayList();
			HashMap  map =getApplicabulityMap();
			HashMap  map1 =new HashMap();
			
			try {
				connection = getConnection() ;
				//this query retrieveds age groups
				
				//String sql="SELECT a.age_group_code, a.short_desc FROM am_age_group_lang_vw a, ph_tpn_const_appl_setting b WHERE eff_status = 'E' AND a.age_group_code = b.age_group_code AND language_id = ? AND ITEM_CODE   = ? AND CONST_GENERIC_CODE =?";
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_SELECT1" )) ;
				 pstmt.setString(1,locale);
				resultSet = pstmt.executeQuery() ;
				while (resultSet.next()) {
					result.add(resultSet.getString("AGE_GROUP_CODE"));
					result.add(resultSet.getString("SHORT_DESC"));
					map1.put(resultSet.getString("AGE_GROUP_CODE"), "N");
				}
				result.add(0, "*A");
				result.add(1, "All");
				map1.put("*A", "N");
			}
			catch ( Exception e ) {
				//System.err.println( "Error loading values from database1" ) ;
				e.printStackTrace() ;
				result.add(e.toString());
			}
			finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es) {
					System.err.println(es);
				}

			}
			//System.out.println("map1"+map1);
			//System.out.println("map"+map);
			map.put(drug_code, map1);
			//System.out.println("map"+map);
			setApplicabulityMap(map);
			setApplicablList(result);
			return result;

	}
	public  void  getModifiedApplicabilitySettings(String drug_code,String regimen_code)
	{
			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			ArrayList result=new ArrayList();
			HashMap  map =getApplicabulityMap();
			HashMap  map1 =new HashMap();
			System.out.println("map1"+map1);  
			System.out.println("map"+map);
			try {
				connection = getConnection() ;
				//this query retrieveds age groups
				
				//String sql="select  b.AGE_GROUP_CODE,APPL_STATUS,SHORT_DESC from PH_TPN_CONST_APPL_SETTING a,AM_AGE_GROUP_LANG_VW b where CONST_GENERIC_CODE=? and a.AGE_GROUP_CODE=b.AGE_GROUP_CODE and item_code =? and EFF_STATUS='E' AND LANGUAGE_ID = ? ";
				String sql="SELECT age_group_code, appl_status,(SELECT short_desc FROM am_age_group_lang_vw WHERE AGE_GROUP_CODE=a.AGE_GROUP_CODE AND eff_status = 'E' AND language_id = ?) short_desc FROM ph_tpn_const_appl_setting a WHERE const_generic_code = ? AND item_code = ?";
				pstmt = connection.prepareStatement(sql) ;
				 pstmt.setString(1,language_id);
				pstmt.setString(2,regimen_code.trim());
				 pstmt.setString(3,drug_code.trim());
				
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null){
				while (resultSet.next()) {
					result.add(resultSet.getString("AGE_GROUP_CODE"));
					if((resultSet.getString("AGE_GROUP_CODE")).equals("*A")){
					result.add("All");
					}
					else{
						result.add(resultSet.getString("SHORT_DESC"));
					}
					map1.put(resultSet.getString("AGE_GROUP_CODE"), resultSet.getString("APPL_STATUS"));
					
				  
				}
				if(map1.size()!=0){
				map.put(drug_code, map1);
				setApplicabulityMap(map);
				setApplicablList(result);
				}
				else{
					result=getAgeGroupsNS(language_id,drug_code);
				}
				}
				else{
					result=getAgeGroupsNS(language_id,drug_code);
				}
				
				
				/*else{
					map.put(drug_code, map1);
					//System.out.println("map"+map);
					setApplicabulityMap(map);
					setApplicablList(result);
				}*/
			}
			catch ( Exception e ) {
				//System.err.println( "Error loading values from database1" ) ;
				e.printStackTrace() ;
				result.add(e.toString());
			}
			finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es) {
					System.err.println(es);
				}

			}
			

	}

	//added for ml-mmoh-crf-1201 end
}//class end
