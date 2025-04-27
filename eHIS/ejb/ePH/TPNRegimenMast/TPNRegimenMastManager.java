/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017      63877   		chithra      UnusedLocal variable
22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
---------------------------------------------------------------------------------------------------------------
*/
package ePH.TPNRegimenMast;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;


/**
*
* @ejb.bean
*	name="TPNRegimenMast"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNRegimenMast"
*	local-jndi-name="TPNRegimenMast"
*	impl-class-name="ePH.TPNRegimenMast.TPNRegimenMastManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNRegimenMast.TPNRegimenMastLocal"
*	remote-class="ePH.TPNRegimenMast.TPNRegimenMastRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNRegimenMast.TPNRegimenMastLocalHome"
*	remote-class="ePH.TPNRegimenMast.TPNRegimenMastHome"
*	generate= "local,remote"
*
*
*/

public class TPNRegimenMastManager extends PhEJBSessionAdapter {


String 	standard_regimen_yn ="";
 
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		Properties prop	= null;

		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "0");


final String SQL_PH_TPN_REGIMEN_MAST_INSERT1 = (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_INSERT1" );

		final String SQL_PH_TPN_REGIMEN_MAST_INSERT2 = (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_INSERT2" );

		final String SQL_PH_TPN_REGIMEN_MAST_SELECT12 = (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_SELECT12" );
				
		final String SQL_PH_TPN_REGIMEN_MAST_INSERT3 = (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_INSERT3" );
		
		final String SQL_AM_UOM_EQVL_SELECT	= (String) sqlMap.get( "SQL_AM_UOM_EQVL_SELECT" );		

		prop	= (Properties)tabData.get( "properties" );
		String login_facility_id		= (String)tabData.get("login_facility_id");
		String login_by_id				= (String)tabData.get("login_by_id");
		String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
		HashMap header					= (HashMap)tabData.get("header");
		HashMap ord_disp				= (HashMap)tabData.get("ord_disp");
//		HashMap masterform				= (HashMap)tabData.get("masterform");

		ArrayList constituents			= (ArrayList)tabData.get("constituents");
		String external_drug			= (String)tabData.get("external_drug");
		String total_energy			= (String)tabData.get("total_energy");
		String npc_ratio			= (String)tabData.get("npc_ratio");
		String drug_item_code_ind			= (String)tabData.get("drug_item_code_ind");
		String lipid_emulsion			= (String)tabData.get("lipid_emulsion");
		String single_emulsion		= (header.get("single_emulsion")==null)?"":(String)header.get("single_emulsion");
		String ppn		= (header.get("ppn")==null)?"":(String)header.get("ppn");
// pead_tpn_regimen_yn
		String pead_tpn_regimen_yn= (header.get("pead_tpn_regimen_yn")==null)?"":(String)header.get("pead_tpn_regimen_yn");
		String overage_volume		= (header.get("overage_volume")==null)?"":(String)header.get("overage_volume");
		String eqvlvalue					= "";
		String stockuom						= "";
		Connection connection										= null;
		PreparedStatement pstmt_insert_regimen			= null;
		PreparedStatement pstmt_insert_const_regimen	= null;
		PreparedStatement pstmt_insert_inventory_drug	= null;
		PreparedStatement pstmt_select							= null;
		ResultSet	resultSet=null;
		try {
//			connection = getConnection() ;
			connection = getConnection((Properties)tabData.get("PROPERTIES"));

			pstmt_select = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_SELECT12 ) ;				
			pstmt_select.setString(1, (header.get("item_code")==null)?"":(String)header.get("item_code"));
			resultSet=pstmt_select.executeQuery();
			if (resultSet.next())
			{
				stockuom=resultSet.getString("SALE_UOM_CODE");
			}
			if(resultSet!=null)	closeResultSet	( resultSet );
			if(pstmt_select!=null)	closeStatement( pstmt_select );	
			pstmt_select = connection.prepareStatement( SQL_AM_UOM_EQVL_SELECT ) ;
			pstmt_select.setString(1,(header.get("pres_base_uom")==null)?"":(String)header.get("pres_base_uom"));
			pstmt_select.setString(2, stockuom);
			pstmt_select.setString(3, stockuom);
			pstmt_select.setString(4,(header.get("pres_base_uom")==null)?"":(String)header.get("pres_base_uom"));

			resultSet=pstmt_select.executeQuery();
			if (resultSet.next())
			{
				eqvlvalue=resultSet.getString("EQVL_VALUE");
			}
			if(resultSet!=null)	closeResultSet	( resultSet );
			if(pstmt_select!=null)	closeStatement( pstmt_select );	

			pstmt_insert_regimen = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_INSERT1 ) ;
//			pstmt_insert_regimen = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_INSERT1 ) ;
			pstmt_insert_regimen.setString(1, (header.get("tpn_regimen_code")==null)?"":(String)header.get("tpn_regimen_code") );
//			pstmt_insert_regimen.setString(2, "Y");
			pstmt_insert_regimen.setString(2, (header.get("standard_regimen_yn")==null)?"":(String)header.get("standard_regimen_yn"));
			pstmt_insert_regimen.setString(3, "N");
//pstmt_insert_regimen.setString(4,(header.get("short_name")==null)?"":(String)header.get("short_name"));
			//ADDED for ML-MMOH-SCF-0839 START
			String short_name=(String)header.get("long_name");
			if(short_name.length() > 40 && short_name!= null  && !short_name.equals(""))
				
				pstmt_insert_regimen.setString(4, (header.get("long_name")==null)?"":((String)header.get("long_name")).substring(0,40));
				else
					pstmt_insert_regimen.setString(4, (header.get("long_name")==null)?"":(String)header.get("long_name"));
			//ADDED for ML-MMOH-SCF-0839 END
			pstmt_insert_regimen.setString(5, (header.get("long_name")==null)?"":(String)header.get("long_name"));
			pstmt_insert_regimen.setString(6, (header.get("item_code")==null)?"":(String)header.get("item_code"));
			pstmt_insert_regimen.setString(7, (header.get("dflt_tpn_route")==null)?"":(String)header.get("dflt_tpn_route"));
			pstmt_insert_regimen.setString(8, (header.get("total_volume")==null)?"":(String)header.get("total_volume"));
			pstmt_insert_regimen.setString(9, (header.get("pres_base_uom")==null)?"":(String)header.get("pres_base_uom"));
			pstmt_insert_regimen.setString(10, eqvlvalue);
			pstmt_insert_regimen.setString(11, total_energy); // Tot_cal
			pstmt_insert_regimen.setString(12, "");
			pstmt_insert_regimen.setString(13, (ord_disp.get("schedule_id")==null)?"":(String)ord_disp.get("schedule_id"));
			pstmt_insert_regimen.setString(14, (ord_disp.get("prescribing_catg")==null)?"":(String)ord_disp.get("prescribing_catg"));
			pstmt_insert_regimen.setString(15, (ord_disp.get("infuse_over")==null)?"":(String)ord_disp.get("infuse_over"));
			pstmt_insert_regimen.setString(16, (ord_disp.get("infuse_over_list")==null)?"":(String)ord_disp.get("infuse_over_list"));
			pstmt_insert_regimen.setString(17, (ord_disp.get("authorize_yn")==null)?"":(String)ord_disp.get("authorize_yn"));
			pstmt_insert_regimen.setString(18, (ord_disp.get("disp_via_pres")==null)?"":(String)ord_disp.get("disp_via_pres"));
			pstmt_insert_regimen.setString(19, (ord_disp.get("disp_against_damage")==null)?"":(String)ord_disp.get("disp_against_damage"));
			pstmt_insert_regimen.setString(20, "");
			pstmt_insert_regimen.setString(21, (ord_disp.get("caution_label_1")==null)?"":(String)ord_disp.get("caution_label_1"));
			pstmt_insert_regimen.setString(22, (ord_disp.get("caution_label_2")==null)?"":(String)ord_disp.get("caution_label_2"));
			pstmt_insert_regimen.setString(23, (ord_disp.get("spl_instruction")==null)?"":(String)ord_disp.get("spl_instruction"));
			pstmt_insert_regimen.setString(24, (ord_disp.get("patient_direction")==null)?"":(String)ord_disp.get("patient_direction"));
			pstmt_insert_regimen.setString(25, external_drug);
			pstmt_insert_regimen.setString(26, "");
			pstmt_insert_regimen.setString(27, "");
			pstmt_insert_regimen.setString(28, "");
			pstmt_insert_regimen.setString(29, "");
			pstmt_insert_regimen.setString(30, login_by_id);
			pstmt_insert_regimen.setString(31, login_at_ws_no);
			pstmt_insert_regimen.setString(32, login_facility_id);
			pstmt_insert_regimen.setString(33, login_by_id);
			pstmt_insert_regimen.setString(34, login_at_ws_no);
			pstmt_insert_regimen.setString(35, login_facility_id);
			pstmt_insert_regimen.setString(36, single_emulsion);
			pstmt_insert_regimen.setString(37, ppn);
			pstmt_insert_regimen.setString(38, npc_ratio);
			pstmt_insert_regimen.setString(39, pead_tpn_regimen_yn);
			pstmt_insert_regimen.setString(40, overage_volume);
			//int i=pstmt_insert_regimen.executeUpdate(); UnusedLocal variable 63877
			pstmt_insert_regimen.executeUpdate();//altered above statement UnusedLocal variable 63877
			if(!drug_item_code_ind.equals("X")){
				
				pstmt_select = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_SELECT12 ) ;
				
				pstmt_select.setString(1, (header.get("item_code")==null)?"":(String)header.get("item_code"));
				resultSet=pstmt_select.executeQuery();
				if (resultSet.next())
				{
					stockuom=resultSet.getString("SALE_UOM_CODE");
				}

				if(resultSet!=null)	closeResultSet	( resultSet );
				if(pstmt_select!=null)	closeStatement( pstmt_select );	
standard_regimen_yn = (header.get("standard_regimen_yn")==null)?"":(String)header.get("standard_regimen_yn");
			if(standard_regimen_yn.equals("Y"))	{

				pstmt_insert_inventory_drug = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_INSERT3 ) ;
				
					pstmt_insert_inventory_drug.setString(1, (header.get("tpn_regimen_code")==null)?"":(String)header.get("tpn_regimen_code") );
					pstmt_insert_inventory_drug.setString(2, (header.get("item_code")==null)?"":(String)header.get("item_code"));
					pstmt_insert_inventory_drug.setString(3, stockuom);
					pstmt_insert_inventory_drug.setString(4, eqvlvalue);
					pstmt_insert_inventory_drug.setString(5, "");
					pstmt_insert_inventory_drug.setString(6, login_by_id);
					pstmt_insert_inventory_drug.setString(7, login_at_ws_no);
					pstmt_insert_inventory_drug.setString(8, login_facility_id);
					pstmt_insert_inventory_drug.setString(9, login_by_id);
					pstmt_insert_inventory_drug.setString(10, login_at_ws_no);
					pstmt_insert_inventory_drug.setString(11, login_facility_id);
					//int j=pstmt_insert_inventory_drug.executeUpdate();
					pstmt_insert_inventory_drug.executeUpdate(); //MODIFIED FOR COMMON-ICN-0048
					//System.err.println("j-----200------>"+j);

			}
			}

			if(constituents.size()!=0) {
				pstmt_insert_const_regimen	= connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_INSERT2 ) ;
				HashMap record	=	new HashMap();
				for(int j=0; j<constituents.size(); j++) {
					record	=	(HashMap)constituents.get(j);

					pstmt_insert_const_regimen.setString(1, (String)header.get("tpn_regimen_code"));

					pstmt_insert_const_regimen.setString(2, (record.get("const_generic_code")==null)?"":(String)record.get("const_generic_code"));

					pstmt_insert_const_regimen.setString(3, (record.get("const_perc")==null)?"":(String)record.get("const_perc"));

						pstmt_insert_const_regimen.setString(4, (record.get("const_vol")==null)?"":(String)record.get("const_vol"));

						pstmt_insert_const_regimen.setString(5, (record.get("const_weight_unit")==null)?"":(String)record.get("const_weight_unit"));

						pstmt_insert_const_regimen.setString(6, (record.get("const_weight")==null)?"":(String)record.get("const_weight"));

					pstmt_insert_const_regimen.setString(7, (record.get("const_weight_unit")==null)?"":(String)record.get("const_weight_unit"));
					
					pstmt_insert_const_regimen.setString(8, lipid_emulsion);
					pstmt_insert_const_regimen.setString(9, login_by_id);
					pstmt_insert_const_regimen.setString(10, login_at_ws_no);
					pstmt_insert_const_regimen.setString(11, login_facility_id);
					pstmt_insert_const_regimen.setString(12, login_by_id);
					pstmt_insert_const_regimen.setString(13, login_at_ws_no);
					pstmt_insert_const_regimen.setString(14, login_facility_id);
					//System.err.println("going to add batch"+j);
					pstmt_insert_const_regimen.addBatch();

				}
				int result1[]=pstmt_insert_const_regimen.executeBatch();
					//System.err.println("j-----237------>"+result1.length);

				for (int k=0;k<result1.length ;k++ ) {
					if(result1[k]<0  && result1[k] != -2 ) {
						pstmt_insert_const_regimen.cancel();
						connection.rollback();
						System.err.println("Failed in Const batch");
					}
				}
			}

			connection.commit();
			map.put( "result", new Boolean(true));
			map.put("msgid","RECORD_INSERTED");
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
			try {
				connection.rollback();
				//debug += "\nException : " + e;
				throw new EJBException(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
		}
/*		
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
			connection.rollback();
		}
*/		
		finally {
			try {
				closeResultSet	( resultSet );
				closeStatement( pstmt_insert_regimen ) ;
				closeStatement( pstmt_insert_const_regimen );
				closeStatement( pstmt_insert_inventory_drug );
				closeStatement( pstmt_select );	
//				closeConnection( connection );
				closeConnection(connection, (Properties)tabData.get("PROPERTIES"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		//System.err.println("map---------ejb--->"+map);
		return map;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "0");

		final String SQL_PH_TPN_REGIMEN_MAST_UPDATE1			= (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_UPDATE1" );
		final String SQL_PH_TPN_REGIMEN_MAST_DELETE1			= (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_DELETE1" );
		final String SQL_PH_TPN_REGIMEN_MAST_INSERT2			= (String) sqlMap.get( "SQL_PH_TPN_REGIMEN_MAST_INSERT2" );

		String login_facility_id		= (String)tabData.get("login_facility_id");
		String login_by_id				= (String)tabData.get("login_by_id");
		String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
		HashMap header					= (HashMap)tabData.get("header");
		HashMap ord_disp				= (HashMap)tabData.get("ord_disp");
		ArrayList constituents			= (ArrayList)tabData.get("constituents");
		String external_drug			= (String)tabData.get("external_drug");
		String total_energy				= (String)tabData.get("total_energy");
		String npc_ratio				= (String)tabData.get("npc_ratio");
		String lipid_emulsion			= (String)tabData.get("lipid_emulsion");

		Connection connection							= null;
		PreparedStatement pstmt_update_regimen			= null;
		PreparedStatement pstmt_delete_regimen			= null;
		PreparedStatement pstmt_insert_const_regimen	= null;
		Properties prop=null;
//		String short_name			= (header.get("short_name")==null)?"":(String)header.get("short_name");
		String short_name			= (header.get("long_name")==null)?"":(String)header.get("long_name");
		String long_name			= (header.get("long_name")==null)?"":(String)header.get("long_name");
		String item_code			= (header.get("item_code")==null)?"":(String)header.get("item_code");
		String dflt_tpn_route		= (header.get("dflt_tpn_route")==null)?"":(String)header.get("dflt_tpn_route");
		String schedule_id			= (ord_disp.get("schedule_id")==null)?"":(String)ord_disp.get("schedule_id");
		String prescribing_catg		= (ord_disp.get("prescribing_catg")==null)?"":(String)ord_disp.get("prescribing_catg");
		String infuse_over			= (ord_disp.get("infuse_over")==null)?"":(String)ord_disp.get("infuse_over");
		String infuse_over_list		= (ord_disp.get("infuse_over_list")==null)?"":(String)ord_disp.get("infuse_over_list");
		String authorize_yn			= (ord_disp.get("authorize_yn")==null)?"":(String)ord_disp.get("authorize_yn");
		String disp_via_pres		= (ord_disp.get("disp_via_pres")==null)?"":(String)ord_disp.get("disp_via_pres");
		String disp_against_damage	= (ord_disp.get("disp_against_damage")==null)?"":(String)ord_disp.get("disp_against_damage");
		String caution_label_1		= (ord_disp.get("caution_label_1")==null)?"":(String)ord_disp.get("caution_label_1");
		String caution_label_2		= (ord_disp.get("caution_label_2")==null)?"":(String)ord_disp.get("caution_label_2");
		String spl_instruction		= (ord_disp.get("spl_instruction")==null)?"":(String)ord_disp.get("spl_instruction");
		String patient_direction	= (ord_disp.get("patient_direction")==null)?"":(String)ord_disp.get("patient_direction");
		String tpn_regimen_code		= (header.get("tpn_regimen_code")==null)?"":(String)header.get("tpn_regimen_code");
		String single_emulsion		= (header.get("single_emulsion")==null)?"":(String)header.get("single_emulsion");
		String standard_regimen_yn	= (header.get("standard_regimen_yn")==null) ?"":(String)header.get("standard_regimen_yn");

		String ppn					= (header.get("ppn")==null)?"":(String)header.get("ppn");

		String pead_tpn_regimen_yn	= (header.get("pead_tpn_regimen_yn")==null)?"":(String)header.get("pead_tpn_regimen_yn");
		String overage_volume		= (header.get("overage_volume")==null)?"":(String)header.get("overage_volume");
		String pres_base_uom		= (header.get("pres_base_uom")==null)?"":(String)header.get("pres_base_uom");

		String total_volume			= (header.get("total_volume")==null) ?"":(String)header.get("total_volume");

		prop = (Properties)tabData.get( "PROPERTIES" );	//moved from down to up for common-icn-0029

		try {

			//prop = (Properties)tabData.get( "PROPERTIES" );	
			connection = getConnection( prop ) ;
			
			pstmt_update_regimen = connection.prepareStatement(SQL_PH_TPN_REGIMEN_MAST_UPDATE1);
			pstmt_update_regimen.setString(1, standard_regimen_yn);
			pstmt_update_regimen.setString(2, "N");
			//if else condtion added for ML-MMOH-SCF-0839
			if(short_name.length() > 40 && short_name!= null && !short_name.equals(""))
			
			pstmt_update_regimen.setString(3, short_name.substring(0,40));
			else
			pstmt_update_regimen.setString(3, long_name);
			
			pstmt_update_regimen.setString(4, long_name);
			pstmt_update_regimen.setString(5, item_code);
			pstmt_update_regimen.setString(6, dflt_tpn_route);
			pstmt_update_regimen.setString(7, total_volume);
			pstmt_update_regimen.setString(8, pres_base_uom);
			pstmt_update_regimen.setString(9, "");
			pstmt_update_regimen.setString(10, total_energy);
			pstmt_update_regimen.setString(11, "");
			pstmt_update_regimen.setString(12, schedule_id);
			pstmt_update_regimen.setString(13, prescribing_catg);
			pstmt_update_regimen.setString(14, infuse_over);
			pstmt_update_regimen.setString(15, infuse_over_list);
			pstmt_update_regimen.setString(16, authorize_yn);
			pstmt_update_regimen.setString(17, disp_via_pres);
			pstmt_update_regimen.setString(18, disp_against_damage);
			pstmt_update_regimen.setString(19, "");
			pstmt_update_regimen.setString(20, caution_label_1);
			pstmt_update_regimen.setString(21, caution_label_2);
			pstmt_update_regimen.setString(22, spl_instruction);
			pstmt_update_regimen.setString(23, patient_direction);
			pstmt_update_regimen.setString(24, external_drug);
			pstmt_update_regimen.setString(25, "");
			pstmt_update_regimen.setString(26, "");
			pstmt_update_regimen.setString(27, "");
			pstmt_update_regimen.setString(28, "");
			pstmt_update_regimen.setString(29, login_by_id);
			pstmt_update_regimen.setString(30, login_at_ws_no);
			pstmt_update_regimen.setString(31, login_facility_id);
			pstmt_update_regimen.setString(32, single_emulsion);
			pstmt_update_regimen.setString(33, ppn);
			pstmt_update_regimen.setString(34, npc_ratio);
			pstmt_update_regimen.setString(35, pead_tpn_regimen_yn);
			pstmt_update_regimen.setString(36, overage_volume);
			pstmt_update_regimen.setString(37, tpn_regimen_code);
			pstmt_update_regimen.executeUpdate();

			pstmt_delete_regimen = connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_DELETE1 ) ;
			pstmt_delete_regimen.setString(1, tpn_regimen_code);
			pstmt_delete_regimen.executeUpdate();

			if(constituents.size()!=0) {
				pstmt_insert_const_regimen	= connection.prepareStatement( SQL_PH_TPN_REGIMEN_MAST_INSERT2 ) ;

				HashMap record	=	new HashMap();
				for(int j=0; j<constituents.size(); j++) {
					record						=	(HashMap)constituents.get(j);
					pstmt_insert_const_regimen.setString(1, (String)header.get("tpn_regimen_code"));
					pstmt_insert_const_regimen.setString(2,(record.get("const_generic_code")==null)?"":(String)record.get("const_generic_code"));
					pstmt_insert_const_regimen.setString(3,(record.get("const_perc")==null)?"":(String)record.get("const_perc"));
					pstmt_insert_const_regimen.setString(4,(record.get("const_vol")==null)?"":(String)record.get("const_vol"));
					if(record.get("const_uom")==null || record.get("const_uom")== ""){
					pstmt_insert_const_regimen.setString(5,(record.get("const_weight_unit")==null)?"":(String)record.get("const_weight_unit"));//modified for ml-mmoh-scf-1303
					}
					else{
						pstmt_insert_const_regimen.setString(5,(record.get("const_uom")==null)?"":(String)record.get("const_uom"));//modified for ml-mmoh-scf-1303
					}
					pstmt_insert_const_regimen.setString(6,(record.get("const_weight")==null)?"":(String)record.get("const_weight"));
					pstmt_insert_const_regimen.setString(7,(record.get("const_weight_unit")==null)?"":(String)record.get("const_weight_unit"));
					pstmt_insert_const_regimen.setString(8,lipid_emulsion);	
					pstmt_insert_const_regimen.setString(9,login_by_id);
					pstmt_insert_const_regimen.setString(10,login_at_ws_no);
					pstmt_insert_const_regimen.setString(11,login_facility_id);
					pstmt_insert_const_regimen.setString(12,login_by_id);
					pstmt_insert_const_regimen.setString(13,login_at_ws_no);
					pstmt_insert_const_regimen.setString(14,login_facility_id);
					//System.err.println("going to add batch"+j);
					pstmt_insert_const_regimen.addBatch();
				}

				int result1[]=pstmt_insert_const_regimen.executeBatch();

				for (int k=0;k<result1.length ;k++ ){
					if(result1[k]<0  && result1[k] != -2 ){
						pstmt_insert_const_regimen.cancel();
						connection.rollback();
						System.err.println("Failed in Const batch");
					}
				}
			}

			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
			try {
				connection.rollback();
				//debug += "\nException : " + e;
				throw new EJBException(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
		}
		finally {
			try {
				closeStatement(pstmt_update_regimen);
				closeStatement(pstmt_delete_regimen);
				closeStatement(pstmt_insert_const_regimen);
		//		closeConnection(connection, (Properties)tabData.get("PROPERTIES"));
				closeConnection( connection,prop ); //common-icn-0029
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
		return map ;
	}
	// delete method ends here
} 
