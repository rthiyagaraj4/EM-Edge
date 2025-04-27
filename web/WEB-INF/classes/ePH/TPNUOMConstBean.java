/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				 ?				 ?				    ?			    ?								   ?
29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.TPNUOMConst.*;

//saved on 25/10/2005
public class TPNUOMConstBean extends PhAdapter implements Serializable {

	protected ArrayList group_codes = new ArrayList();
	Hashtable recordSet = null;

	public TPNUOMConstBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
		e.printStackTrace() ;
		}
    }

    public void clear() {
		group_codes = new ArrayList();
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

    public void setAll( Hashtable recordSetMultiple ) {
		this.mode = (String)recordSetMultiple.get("mode");
		recordSet = recordSetMultiple;
	}

	public ArrayList getGroupCodes(){
		return this.group_codes ;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

		ArrayList ph_tpn_param			 = new ArrayList();
		ArrayList ph_tpn_param_for_const = new ArrayList();
		ArrayList common_values			 = new ArrayList();
		ph_tpn_param.add((String)recordSet.get("energy_unit"));				 // energy_unit
		ph_tpn_param.add((String)recordSet.get("regimen_presc_base_unit"));  // regimen_presc_base_unit
		ph_tpn_param.add((String)recordSet.get("max_weight"));				 // max weight
		ph_tpn_param.add((String)recordSet.get("min_weight"));  // min weight
		ph_tpn_param.add((String)recordSet.get("exp_period"));				 // expirty period
		
		String item_fluid=(String)recordSet.get("itmfld_req_yn");
		if (item_fluid.equals(""))
		{
			item_fluid="N";
		}
		ph_tpn_param.add(item_fluid);            // Item Fluid req.
		ph_tpn_param.add((String)recordSet.get("order_regimen_by"));         //order regimen by

		//System.out.println("ph tpn param values in bean"+ph_tpn_param);

		
		common_values.add(login_by_id.trim());								 // added_by_id
		common_values.add(login_at_ws_no.trim());							 // added_at_ws_no
		common_values.add(login_facility_id.trim());                         // added_facility_id

		int total_count = Integer.parseInt((String)recordSet.get("total_count"));			 // total_count
		for (int i=1;i<=total_count ;i++ ){
			//if(recordSet.get("regimen_setup_unit"+i) != null && !(((String)recordSet.get("regimen_setup_unit"+i)).trim()).equals(""))
			String regimen_setup_unit=(String)recordSet.get("regimen_setup_unit"+i);
			String order_qty_limit_unit=(String)recordSet.get("order_qty_limit_unit"+i);
			if(!regimen_setup_unit.equals("X") || !order_qty_limit_unit.equals("X")) 
			{
         		ph_tpn_param_for_const.add((String)recordSet.get("srl_no"+i));							//srl_no
				ph_tpn_param_for_const.add((String)recordSet.get("group_or_individual_ind"+i));			// group_or_individual_ind 
				ph_tpn_param_for_const.add((String)recordSet.get("const_group_code"+i));				// const_group_code        
				ph_tpn_param_for_const.add((String)recordSet.get("regimen_setup_unit"+i));				// regimen_setup_unit      
				ph_tpn_param_for_const.add((String)recordSet.get("ordering_unit"+i));					// ordering_unit           
				ph_tpn_param_for_const.add((String)recordSet.get("order_qty_limit_unit"+i));			// order_qty_limit_unit    
				ph_tpn_param_for_const.add((String)recordSet.get("prep_unit"+i));						// prep_unit               
			}
		}
		
		//TPNUOMConstHome   home=null;
		//TPNUOMConstRemote remote=null;
		try{
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			
			tabData.put("common_values",common_values);
			tabData.put("ph_tpn_param",ph_tpn_param);
			tabData.put("ph_tpn_param_for_const",ph_tpn_param_for_const);
            String SQL_PH_TPN_PARAM_UPDATE="UPDATE PH_TPN_PARAM SET ENERGY_UNIT=?, REGIMEN_PRESC_BASE_UNIT=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, PEAD_MAX_WEIGHT_VALUE=?, ADULT_MIN_WEIGHT_VALUE=?, EXPIRY_FOR_TPN_ADM=?, ITEM_FLUID_APPL_YN=?, ORD_REGIMEN_IND=? WHERE MODULE_ID='PH'";
            String SQL_PH_TPN_PARAM_INSERT="INSERT INTO PH_TPN_PARAM(MODULE_ID, ENERGY_UNIT, REGIMEN_PRESC_BASE_UNIT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,PEAD_MAX_WEIGHT_VALUE,ADULT_MIN_WEIGHT_VALUE,EXPIRY_FOR_TPN_ADM,ITEM_FLUID_APPL_YN, ORD_REGIMEN_IND) VALUES('PH',?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?)";

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_TPN_PARAM_INSERT",SQL_PH_TPN_PARAM_INSERT);
			sqlMap.put("SQL_PH_TPN_PARAM_FOR_CONST_INSERT",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAM_FOR_CONST_INSERT"));
			
			//sqlMap.put("SQL_PH_TPN_PARAM_UPDATE",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAM_UPDATE"));
			sqlMap.put("SQL_PH_TPN_PARAM_UPDATE",SQL_PH_TPN_PARAM_UPDATE);
			sqlMap.put("SQL_PH_TPN_PARAM_FOR_CONST_UPDATE",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAM_FOR_CONST_UPDATE"));
			sqlMap.put("SQL_PH_TPN_PARAMETERS_SELECT7",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT7"));
			sqlMap.put("SQL_PH_TPN_PARAMETERS_SELECT8",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT8"));
			//new line
			sqlMap.put("SQL_PH_TPN_PARAM_FOR_CONST_DELETE",PhRepository.getPhKeyValue("SQL_PH_TPN_PARAM_FOR_CONST_DELETE"));	
			try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_TPN_PARAM") ) ;

				home  = (TPNUOMConstHome) PortableRemoteObject.narrow( object, TPNUOMConstHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPN_PARAM" ),TPNUOMConstHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		

		//System.err.println("result-------->"+result);
				if( ((Boolean) result.get( "result" )).booleanValue() )	{
					map.put( "result", new Boolean( true ) ) ;		
					map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
					//map.put( "message", getMessage((String) map.get( "msgid")) ) ;
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
		}//catch
		finally{
			map.put("flag","0");
			}//finally

        // System.err.println("map-------158--->"+map);
		return map;
	}
	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;
	}

//dd
public Hashtable getForOrderingUnit() throws Exception
	{
		
				Connection connection = null ;
        PreparedStatement pstmt1=null;
        ResultSet resultSet1 = null;
		Hashtable ht = new Hashtable();
        try {
			connection = getConnection() ;
		    pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT9") ) ;
		
		resultSet1 = pstmt1.executeQuery() ;

		while(resultSet1.next()){
			ht.put(resultSet1.getString("CONST_GROUP_CODE"),resultSet1.getString("DFLT_ORD_UNIT_IND"));

		}
}catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
	
				return ht;	
	}

//new
public Hashtable energyloadInitialData1(String locale) throws Exception{
		Hashtable result = new Hashtable();		
		ArrayList arr_list_energy = new ArrayList();
		ArrayList arr_list_pres_base_unit = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {

		/* 
			Now Both SQL_PH_TPN_PARAMETERS_SELECT1,SQL_PH_TPN_PARAMETERS_SELECT2 are same...
			It's already coded...so it has been retained as it is...
		*/

			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_ENERGY_SELECT1") ) ;
			pstmt.setString(1,locale);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_energy.add(resultSet.getString("UOM_CODE"));
				arr_list_energy.add(resultSet.getString("SHORT_DESC"));
			}
			
			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT2") ) ;
			pstmt.setString(1,locale);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_pres_base_unit.add(resultSet.getString("UOM_CODE"));
				arr_list_pres_base_unit.add(resultSet.getString("SHORT_DESC"));
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
		result.put("ENERGY",arr_list_energy);
		result.put("PRES_BASE_UNIT",arr_list_pres_base_unit);
		return result;		
	}




//dd
	public Hashtable loadInitialData(String locale) throws Exception{
		Hashtable result = new Hashtable();		
		ArrayList arr_list_energy = new ArrayList();
		ArrayList arr_list_pres_base_unit = new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {

		/* 
			Now Both SQL_PH_TPN_PARAMETERS_SELECT1,SQL_PH_TPN_PARAMETERS_SELECT2 are same...
			It's already coded...so it has been retained as it is...
		*/

			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT1") ) ;
			pstmt.setString(1,locale);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_energy.add(resultSet.getString("UOM_CODE"));
				arr_list_energy.add(resultSet.getString("SHORT_DESC"));
			}
			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT2") ) ;
			pstmt.setString(1,locale);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				arr_list_pres_base_unit.add(resultSet.getString("UOM_CODE"));
				arr_list_pres_base_unit.add(resultSet.getString("SHORT_DESC"));
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
		result.put("ENERGY",arr_list_energy);
		result.put("PRES_BASE_UNIT",arr_list_pres_base_unit);
		return result;		
	}


	public Hashtable paintConstituents(String locale)throws Exception{
		Hashtable result = new Hashtable();		
		Connection connection = null ;
        PreparedStatement pstmt1=null,pstmt2 = null ;
        ResultSet resultSet1 = null,resultSet2=null;
        try {
			connection = getConnection() ;
		   // pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT3") ) ;
		    pstmt1 = connection.prepareStatement("SELECT distinct b.DISP_SRL_NO,a.CONST_GROUP_CODE,a.CONST_GROUP_NAME FROM PH_TPN_CONST_GRP_LANG_VW a,PH_TPN_CONST_GENERIC_NAME b WHERE a.EFF_STATUS='E' AND a.CONST_GROUP_CODE=b.CONST_GROUP_CODE  and b.UOM_SETUP_LEVEL_IND='G' AND b.eff_status = 'E' AND a.LANGUAGE_ID = ? ORDER BY DISP_SRL_NO") ; // AND b.eff_status = 'E' Added for  ML-MMOH-CRF-1266 [IN:068728]
			pstmt1.setString(1,locale);
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				String const_group_code = resultSet1.getString("CONST_GROUP_CODE");
				group_codes.add(const_group_code);
				group_codes.add(resultSet1.getString("CONST_GROUP_NAME"));
				group_codes.add(resultSet1.getString("DISP_SRL_NO"));
				pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT4") ) ;
				pstmt2.setString(1,const_group_code.trim());
				pstmt2.setString(2,locale.trim());
				resultSet2 = pstmt2.executeQuery();
				ArrayList arr_list = new ArrayList();
				while (resultSet2 != null && resultSet2.next()){
					arr_list.add(resultSet2.getString("CONST_GENERIC_CODE"));
					arr_list.add(resultSet2.getString("CONST_GENERIC_NAME"));
					arr_list.add(resultSet2.getString("DISP_SRL_NO"));
					//ADDED HERE
					arr_list.add(resultSet2.getString("DFLT_ORD_UNIT_IND"));
				}
				if(resultSet2!=null) closeResultSet( resultSet2 ) ;
                if(pstmt2!=null) closeStatement( pstmt2 ) ;
				result.put(const_group_code,arr_list);
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeResultSet( resultSet2 ) ;
                closeStatement( pstmt2 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;		
	}

	
	public Hashtable loadDataForUpdate()throws Exception{
		Hashtable result = new Hashtable();		
		ArrayList uom_parameters= new ArrayList();
		Hashtable ht_quantity_uom_parameters = new Hashtable();
		Connection connection = null ;
        PreparedStatement pstmt1=null,pstmt2 = null ;
        ResultSet resultSet1 = null,resultSet2=null;
        try {
			connection = getConnection() ;
		  //  pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT5") ) ;
		    pstmt1 = connection.prepareStatement("SELECT ENERGY_UNIT, REGIMEN_PRESC_BASE_UNIT, PEAD_MAX_WEIGHT_VALUE,ADULT_MIN_WEIGHT_VALUE, EXPIRY_FOR_TPN_ADM, ITEM_FLUID_APPL_YN, ORD_REGIMEN_IND  FROM PH_TPN_PARAM WHERE MODULE_ID='PH'") ;
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				uom_parameters.add(resultSet1.getString("ENERGY_UNIT"));
				uom_parameters.add(resultSet1.getString("REGIMEN_PRESC_BASE_UNIT"));

				uom_parameters.add(resultSet1.getString("PEAD_MAX_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("ADULT_MIN_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("EXPIRY_FOR_TPN_ADM"));
				uom_parameters.add(resultSet1.getString("ITEM_FLUID_APPL_YN"));
				uom_parameters.add(resultSet1.getString("ORD_REGIMEN_IND"));
				
			}
			pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT6") ) ;
			resultSet2 = pstmt2.executeQuery();
            while ( resultSet2 != null && resultSet2.next() ) {
				ArrayList quantity_uom_parameters= new ArrayList();
				quantity_uom_parameters.add(resultSet2.getString("CONST_GROUP_CODE"));
				quantity_uom_parameters.add(resultSet2.getString("REGIMEN_SETUP_UNIT"));
				quantity_uom_parameters.add(resultSet2.getString("ORDERING_UNIT"));
				quantity_uom_parameters.add(resultSet2.getString("ORD_UNIT_IND"));
				quantity_uom_parameters.add(resultSet2.getString("PREP_UNIT"));	
				ht_quantity_uom_parameters.put(resultSet2.getString("SRL_NO"),quantity_uom_parameters);				
			}
			result.put("uom_parameters",uom_parameters);
			result.put("ht_quantity_uom_parameters",ht_quantity_uom_parameters);
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeResultSet( resultSet2 ) ;
                closeStatement( pstmt2 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;		
	}


}//class end
