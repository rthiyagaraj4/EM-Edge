/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.DispenseLocation ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="DispenseLocation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DispenseLocation"
*	local-jndi-name="DispenseLocation"
*	impl-class-name="ePH.DispenseLocation.DispenseLocationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DispenseLocation.DispenseLocationLocal"
*	remote-class="ePH.DispenseLocation.DispenseLocationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DispenseLocation.DispenseLocationLocalHome"
*	remote-class="ePH.DispenseLocation.DispenseLocationHome"
*	generate= "local,remote"
*
*
*/

public class DispenseLocationManager extends PhEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData,HashMap sqlMap) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		Connection connection			= null ;
		PreparedStatement pstmt_insert	= null ;
		PreparedStatement pstmt_insert1	= null ;
		int result1 =0;
		String report_id ="";
		//int delete_count = 0;

		try {
			ArrayList insertData1	= (ArrayList)tabData.get( "InsertDataDL" ) ;
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_insert = connection.prepareStatement( (String) sqlMap.get( "InsertSQLDL" ) ) ;
			pstmt_insert1 = connection.prepareStatement( (String) sqlMap.get( "InsertSQLDL1" ) ) ;

			pstmt_insert.setString(1,	(String)insertData1.get(0));
			pstmt_insert.setString(2,	(String)insertData1.get(1));
			pstmt_insert.setString(3,	(String)insertData1.get(2));
			pstmt_insert.setString(4,	(String)insertData1.get(3));
			pstmt_insert.setString(5,	(String)insertData1.get(4));
			pstmt_insert.setString(6,	(String)insertData1.get(5));
			pstmt_insert.setString(7,	(String)insertData1.get(6));
			pstmt_insert.setString(8,	(String)insertData1.get(7));
			pstmt_insert.setString(9,	(String)insertData1.get(8));
			pstmt_insert.setString(10,	(String)insertData1.get(9));
			pstmt_insert.setString(11,	(String)insertData1.get(10));
			pstmt_insert.setString(12,	(String)insertData1.get(11));
			pstmt_insert.setString(13,	(String)insertData1.get(12));
			pstmt_insert.setString(14,	(String)insertData1.get(13));
			pstmt_insert.setString(15,	(String)insertData1.get(14));
			pstmt_insert.setString(16,	(String)insertData1.get(15));
			pstmt_insert.setString(17,	(String)insertData1.get(16));
			//pstmt_insert.setString(18,	(String)insertData1.get(17));
			pstmt_insert.setString(18,	(String)insertData1.get(17));
			pstmt_insert.setString(19,	(String)insertData1.get(18));
			pstmt_insert.setString(20,	(String)insertData1.get(19));
			pstmt_insert.setString(21,	(String)insertData1.get(20));
			pstmt_insert.setString(22,	(String)insertData1.get(21));
			pstmt_insert.setString(23,	(String)insertData1.get(22));
			pstmt_insert.setString(24,	(String)insertData1.get(23));
			pstmt_insert.setString(25,	(String)insertData1.get(24));
			pstmt_insert.setString(26,	(String)insertData1.get(25));
			pstmt_insert.setString(27,	(String)insertData1.get(26));
			pstmt_insert.setString(28,	(String)insertData1.get(27));
			pstmt_insert.setString(29,	(String)insertData1.get(28));
			pstmt_insert.setString(30,	(String)insertData1.get(29));
			pstmt_insert.setString(31,	(String)insertData1.get(30));
			pstmt_insert.setString(32,	(String)insertData1.get(31));
			pstmt_insert.setString(33,	(String)insertData1.get(32));
			pstmt_insert.setString(34,	(String)insertData1.get(33));
			pstmt_insert.setString(35,	(String)insertData1.get(34));
			pstmt_insert.setString(36,	(String)insertData1.get(35));
			pstmt_insert.setString(37,	(String)insertData1.get(36));
			pstmt_insert.setString(38,	(String)insertData1.get(37));
			pstmt_insert.setString(39,	(String)insertData1.get(38));
			pstmt_insert.setString(40,	(String)insertData1.get(39));
			pstmt_insert.setString(41,	(String)insertData1.get(40));
			pstmt_insert.setString(42,	(String)insertData1.get(41));
			pstmt_insert.setString(43,	(String)insertData1.get(42));
			pstmt_insert.setString(44,	(String)insertData1.get(43));
			pstmt_insert.setString(45,	(String)insertData1.get(44));
			//pstmt_insert.setString(47,	(String)insertData1.get(46));
			pstmt_insert.setString(46,	(String)insertData1.get(45));
			pstmt_insert.setString(47,	(String)insertData1.get(46));
			pstmt_insert.setString(48,	(String)insertData1.get(47));
			pstmt_insert.setString(49,	(String)insertData1.get(48));
			pstmt_insert.setString(50,	(String)insertData1.get(49));
			pstmt_insert.setString(51,	(String)insertData1.get(50));
			pstmt_insert.setString(52,	(String)insertData1.get(51));
			pstmt_insert.setString(53,	(String)insertData1.get(52));
			pstmt_insert.setString(54,	(String)insertData1.get(53));
			pstmt_insert.setString(55,	(String)insertData1.get(54));
			pstmt_insert.setString(56,	(String)insertData1.get(55));
			pstmt_insert.setString(57,	(String)insertData1.get(56));
			pstmt_insert.setString(58,	(String)insertData1.get(57));
			pstmt_insert.setString(59,	(String)insertData1.get(58));
			pstmt_insert.setString(60,	(String)insertData1.get(59));

			pstmt_insert.setString(61,	(String)insertData1.get(60));
			pstmt_insert.setString(62,	(String)insertData1.get(61));
			pstmt_insert.setString(63,	(String)insertData1.get(62));
			pstmt_insert.setString(64,	(String)insertData1.get(63));
			pstmt_insert.setString(65,	(String)insertData1.get(64));
			pstmt_insert.setString(66,	(String)insertData1.get(65));
			pstmt_insert.setString(67,	(String)insertData1.get(66));
			pstmt_insert.setString(68,	(String)insertData1.get(67));			
			
			pstmt_insert.setString(69,	(String)insertData1.get(69));	/* added for SRR20056-CRF-0663 ----------------START*/		
			pstmt_insert.setString(70,	(String)insertData1.get(70));			
			pstmt_insert.setString(71,	(String)insertData1.get(71));	/* added for SRR20056-CRF-0663 ----------------END*/

			pstmt_insert.setString(72,	(String)insertData1.get(72));	/* added for SRR20056-SCF-7639	ICN027720 ----------------START*/	
			pstmt_insert.setString(73,	(String)insertData1.get(73));	/* added for SRR20056-SCF-7639	ICN027720 ----------------END*/
			pstmt_insert.setString(74,	(String)insertData1.get(74));	//added for KDAH-CRF-0231 [IN-034551]

			pstmt_insert.setString(75,	(String)insertData1.get(75));	//Added for Bru-HIMS-CRF-142 [IN:030195] - start
			pstmt_insert.setString(76,	(String)insertData1.get(76));	
			pstmt_insert.setString(77,	(String)insertData1.get(77));	
			pstmt_insert.setString(78,	(String)insertData1.get(78));	//Added for Bru-HIMS-CRF-142 [IN:030195] -end
			pstmt_insert.setString(79,	(String)insertData1.get(79));	//Added for RUT-CRF-0035 [IN029926] 
			pstmt_insert.setString(80,	(String)insertData1.get(80));	//Added for HSA-CRF-0113 [IN:048166]
			pstmt_insert.setString(81,	(String)insertData1.get(81));  //Added for NMC-JD-CRF-0008 
			
			int result = pstmt_insert.executeUpdate() ;

			String dispenseLocationType = (String)insertData1.get(5);
			if (!dispenseLocationType.equals("P")){ //selected dispense location type is clinic or nursing unit 
				//delete_count = 1;
				result1 = 1;
			}
			else{
				HashMap onlinePrintMap = (HashMap)insertData1.get(68);
				if(onlinePrintMap !=null && onlinePrintMap.size()>0){
					Set keys = onlinePrintMap.keySet();			
					HashMap rowMap = null;
					for (Iterator i = keys.iterator(); i.hasNext();){
						report_id = (String)i.next();
						rowMap = (HashMap)onlinePrintMap.get(report_id);
						if (rowMap!=null && rowMap.containsKey("OP_A")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"OP");//patient_class
							pstmt_insert1.setString(5,	"A");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("OP_A").toString());//print_status
							pstmt_insert1.setString(7,	"10");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_A
						if (rowMap!=null && rowMap.containsKey("OP_F")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"OP");//patient_class
							pstmt_insert1.setString(5,	"F");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("OP_F").toString());//print_status
							pstmt_insert1.setString(7,	"20");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_F
						if (rowMap!=null && rowMap.containsKey("OP_D")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"OP");//patient_class
							pstmt_insert1.setString(5,	"D");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("OP_D").toString());//print_status
							pstmt_insert1.setString(7,	"30");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_D
						if (rowMap!=null && rowMap.containsKey("OP_AS")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"OP");//patient_class
							pstmt_insert1.setString(5,	"AS");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("OP_AS").toString());//print_status
							pstmt_insert1.setString(7,	"40");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_AS
						if (rowMap!=null && rowMap.containsKey("IP_FP")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"IP");//patient_class
							pstmt_insert1.setString(5,	"FP");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("IP_FP").toString());//print_status
							pstmt_insert1.setString(7,	"50");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_FP
						if (rowMap!=null && rowMap.containsKey("IP_F")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"IP");//patient_class
							pstmt_insert1.setString(5,	"F");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("IP_F").toString());//print_status
							pstmt_insert1.setString(7,	"60");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_F
						if (rowMap!=null && rowMap.containsKey("IP_AF")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"IP");//patient_class
							pstmt_insert1.setString(5,	"AF");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("IP_AF").toString());//print_status
							pstmt_insert1.setString(7,	"70");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_AF
						if (rowMap!=null && rowMap.containsKey("IP_D")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"IP");//patient_class
							pstmt_insert1.setString(5,	"D");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("IP_D").toString());//print_status
							pstmt_insert1.setString(7,	"80");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_D
						if (rowMap!=null && rowMap.containsKey("IP_DF")){
							pstmt_insert1.setString(1,	(String)insertData1.get(0));//facility_id
							pstmt_insert1.setString(2,	(String)insertData1.get(1));//disp_loc_code
							pstmt_insert1.setString(3,	report_id);//report_id
							pstmt_insert1.setString(4,	"IP");//patient_class
							pstmt_insert1.setString(5,	"DF");//disp_stage
							pstmt_insert1.setString(6,	rowMap.get("IP_DF").toString());//print_status
							pstmt_insert1.setString(7,	"90");//display_order
							pstmt_insert1.setString(8,	"E");//eff_status
							result1 =pstmt_insert1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_DF
					}//end for totla report_id's	
				}
			}// if dispense location type is pharmacy 
			if ( result<1 || result1<1   ) {
				connection.rollback();
				throw new EJBException("Insert Failed");
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
				map.put( "msgid", "RECORD_INSERTED" ) ;
				connection.commit();
			}
		}
		catch( Exception e ) {
			System.err.println("Error while insertion tabData"+tabData);
			try {
				connection.rollback();				
		 	}
			catch ( Exception e1 ) {
				e1.printStackTrace() ;
			}
			//connection.rollback();
			map.put( "msgid", "Exception in EJB : " + e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert ) ;				
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		Connection connection			= null ;
		PreparedStatement pstmt_update	= null ;
		PreparedStatement pstmt_update1	= null ;
		int result1 =0;
		int delete_count = 0;
		String report_id ="";
		try {
			
			ArrayList modifyData1	= (ArrayList)tabData.get( "ModifyDataDL" ) ;
			
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_update = connection.prepareStatement( (String) sqlMap.get( "ModifySQLDL" ) ) ;
			pstmt_update1 = connection.prepareStatement( (String) sqlMap.get( "ModifySQLDL1" ) ) ;
			
			pstmt_update.setString(1,	(String)modifyData1.get(0));
			pstmt_update.setString(2,	(String)modifyData1.get(1));
			pstmt_update.setString(3,	(String)modifyData1.get(2));
			pstmt_update.setString(4,	(String)modifyData1.get(3));
			pstmt_update.setString(5,	(String)modifyData1.get(4));
			pstmt_update.setString(6,	(String)modifyData1.get(5));
			pstmt_update.setString(7,	(String)modifyData1.get(6));
			pstmt_update.setString(8,	(String)modifyData1.get(7));
			pstmt_update.setString(9,	(String)modifyData1.get(8));
			pstmt_update.setString(10,	(String)modifyData1.get(9));
			pstmt_update.setString(11,	(String)modifyData1.get(10));
			pstmt_update.setString(12,	(String)modifyData1.get(11));
			//pstmt_update.setString(13,	(String)modifyData1.get(12));
			pstmt_update.setString(13,	(String)modifyData1.get(12));
			pstmt_update.setString(14,	(String)modifyData1.get(13));
			pstmt_update.setString(15,	(String)modifyData1.get(14));
			pstmt_update.setString(16,	(String)modifyData1.get(15));
			pstmt_update.setString(17,	(String)modifyData1.get(16));
			pstmt_update.setString(18,	(String)modifyData1.get(17));
			pstmt_update.setString(19,	(String)modifyData1.get(18));
			pstmt_update.setString(20,	(String)modifyData1.get(19));
			pstmt_update.setString(21,	(String)modifyData1.get(20));
			pstmt_update.setString(22,	(String)modifyData1.get(21));
			pstmt_update.setString(23,	(String)modifyData1.get(22));
			pstmt_update.setString(24,	(String)modifyData1.get(23));
			pstmt_update.setString(25,	(String)modifyData1.get(24));
			pstmt_update.setString(26,	(String)modifyData1.get(25));
			pstmt_update.setString(27,	(String)modifyData1.get(26));
			pstmt_update.setString(28,	(String)modifyData1.get(27));
			pstmt_update.setString(29,	(String)modifyData1.get(28));
			pstmt_update.setString(30,	(String)modifyData1.get(29));
			pstmt_update.setString(31,	(String)modifyData1.get(30));
			pstmt_update.setString(32,	(String)modifyData1.get(31));
			pstmt_update.setString(33,	(String)modifyData1.get(32));
			pstmt_update.setString(34,	(String)modifyData1.get(33));
			pstmt_update.setString(35,	(String)modifyData1.get(34));
			pstmt_update.setString(36,	(String)modifyData1.get(35));
			pstmt_update.setString(37,	(String)modifyData1.get(36));
			pstmt_update.setString(38,	(String)modifyData1.get(37));
			//pstmt_update.setString(40,	(String)modifyData1.get(39));
			pstmt_update.setString(39,	(String)modifyData1.get(38));
			pstmt_update.setString(40,	(String)modifyData1.get(39));
			pstmt_update.setString(41,	(String)modifyData1.get(40));
			pstmt_update.setString(42,	(String)modifyData1.get(41));
			pstmt_update.setString(43,	(String)modifyData1.get(42));
			pstmt_update.setString(44,	(String)modifyData1.get(43));
			pstmt_update.setString(45,	(String)modifyData1.get(44));
			pstmt_update.setString(46,	(String)modifyData1.get(45));
			pstmt_update.setString(47,	(String)modifyData1.get(46));
			pstmt_update.setString(48,	(String)modifyData1.get(47));
			pstmt_update.setString(49,	(String)modifyData1.get(48));
			pstmt_update.setString(50,	(String)modifyData1.get(49));
			pstmt_update.setString(51,	(String)modifyData1.get(50));
			pstmt_update.setString(52,	(String)modifyData1.get(51));
			pstmt_update.setString(53,	(String)modifyData1.get(52));			
			pstmt_update.setString(54,	(String)modifyData1.get(53));
			pstmt_update.setString(55,	(String)modifyData1.get(54));
			pstmt_update.setString(56,	(String)modifyData1.get(55));
			pstmt_update.setString(57,	(String)modifyData1.get(56));
			pstmt_update.setString(58,	(String)modifyData1.get(57));
			pstmt_update.setString(59,	(String)modifyData1.get(58));
			/* added for SRR20056-CRF-0663 ----------------START*/
			pstmt_update.setString(60,	(String)modifyData1.get(63));			
			pstmt_update.setString(61,	(String)modifyData1.get(64));			
			pstmt_update.setString(62,	(String)modifyData1.get(65));			
			/* added for SRR20056-CRF-0663 ----------------END*/
			pstmt_update.setString(63,	(String)modifyData1.get(66));
			pstmt_update.setString(64,	(String)modifyData1.get(67));

			pstmt_update.setString(65,	(String)modifyData1.get(68)); 			// added for KDAH-CRF-0231 [IN-034551]

			pstmt_update.setString(66,	(String)modifyData1.get(69));	//Added for Bru-HIMS-CRF-142 [IN:030195] - start
			pstmt_update.setString(67,	(String)modifyData1.get(70));
			pstmt_update.setString(68,	(String)modifyData1.get(71));
			pstmt_update.setString(69,	(String)modifyData1.get(72));	//Added for Bru-HIMS-CRF-142 [IN:030195] - End
			pstmt_update.setString(70,	(String)modifyData1.get(73));  // Added for RUT-CRF-0035 [IN029926]
			
			pstmt_update.setString(71,	(String)modifyData1.get(74)); //Added for HSA-CRF-0113 [IN:048166] 
			pstmt_update.setString(72,	(String)modifyData1.get(75)); //Added for NMC-JD-CRF-0008
			pstmt_update.setString(73,	(String)modifyData1.get(59));/* added for SRR20056-SCF-7639	ICN027720 ----------------START*/ //Modified for NMC-JD-CRF-0008 where parameters
			pstmt_update.setString(74,	(String)modifyData1.get(60));/* added for SRR20056-SCF-7639	ICN027720 ----------------END*///Modified for NMC-JD-CRF-0008 where parameters
			
			
			
			int result = pstmt_update.executeUpdate() ;
            String dispenseLocationType = (String)modifyData1.get(61) ;

			if (!dispenseLocationType.equals("P")){//code 'Pharmacy' is replaced by 'P' for IN044805 
				delete_count = 1;
				result1 = 1;
			}
			else{
				HashMap onlinePrintMap = (HashMap)modifyData1.get(62);
				Set keys = onlinePrintMap.keySet();
				 
				String facility_id = modifyData1.get(30).toString();
				String disp_locn_code = modifyData1.get(60).toString();

				delete_count = deleteOnlinePrintDetails(connection,facility_id,disp_locn_code);
				if (delete_count > 0){
					HashMap rowMap = null;
					for (Iterator i = keys.iterator(); i.hasNext();){
						report_id = (String)i.next();
						rowMap = (HashMap)onlinePrintMap.get(report_id);
						if (rowMap!=null && rowMap.containsKey("OP_A")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"OP");//patient_class
							pstmt_update1.setString(5,	"A");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("OP_A").toString());//print_status
							pstmt_update1.setString(7,	"10");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_A
						if (rowMap!=null && rowMap.containsKey("OP_F")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"OP");//patient_class
							pstmt_update1.setString(5,	"F");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("OP_F").toString());//print_status
							pstmt_update1.setString(7,	"20");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_F
						if (rowMap!=null && rowMap.containsKey("OP_D")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"OP");//patient_class
							pstmt_update1.setString(5,	"D");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("OP_D").toString());//print_status
							pstmt_update1.setString(7,	"30");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_D
						if (rowMap!=null && rowMap.containsKey("OP_AS")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"OP");//patient_class
							pstmt_update1.setString(5,	"AS");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("OP_AS").toString());//print_status
							pstmt_update1.setString(7,	"40");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for OP_AS
						if (rowMap!=null && rowMap.containsKey("IP_FP")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"IP");//patient_class
							pstmt_update1.setString(5,	"FP");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("IP_FP").toString());//print_status
							pstmt_update1.setString(7,	"50");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_FP
						if (rowMap!=null && rowMap.containsKey("IP_F")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"IP");//patient_class
							pstmt_update1.setString(5,	"F");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("IP_F").toString());//print_status
							pstmt_update1.setString(7,	"60");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_F
						if (rowMap!=null && rowMap.containsKey("IP_AF")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"IP");//patient_class
							pstmt_update1.setString(5,	"AF");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("IP_AF").toString());//print_status
							pstmt_update1.setString(7,	"70");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_AF
						if (rowMap!=null && rowMap.containsKey("IP_D")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"IP");//patient_class
							pstmt_update1.setString(5,	"D");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("IP_D").toString());//print_status
							pstmt_update1.setString(7,	"80");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_D
						if (rowMap!=null && rowMap.containsKey("IP_DF")){
							pstmt_update1.setString(1,	(String)modifyData1.get(30));//facility_id
							pstmt_update1.setString(2,	(String)modifyData1.get(60));//disp_loc_code
							pstmt_update1.setString(3,	report_id);//report_id
							pstmt_update1.setString(4,	"IP");//patient_class
							pstmt_update1.setString(5,	"DF");//disp_stage
							pstmt_update1.setString(6,	rowMap.get("IP_DF").toString());//print_status
							pstmt_update1.setString(7,	"90");//display_order
							pstmt_update1.setString(8,	"E");//eff_status
							result1 =pstmt_update1.executeUpdate() ;
							if (result1 < 1){
								break;
							}
						}//end for IP_DF
					}//end for totla report_id's
				}// delete_count > 0	
			}//if dispense location type is pharmacy
			if ( result < 1 ||result1 < 1 || delete_count < 1) {
				connection.rollback();
				throw new EJBException("Update Failed");
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
				map.put( "msgid", "RECORD_MODIFIED" ) ;
				connection.commit();
			}
		}
		catch( Exception e ) {
			e.printStackTrace() ;
			System.err.println("Error While Updation tabData="+tabData ) ;
			try {
				connection.rollback();				
		 	}
			catch ( Exception e1 ) {
				e1.printStackTrace() ;
			}
			map.put( "msgid", "Exception in EJB : " + e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_update1 ) ;
				closeStatement( pstmt_update ) ;
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}

	public int  deleteOnlinePrintDetails(Connection connection, String facility_id, String disp_locn_code)  {
		
        PreparedStatement pstmt = null ;
        int count = 0;
		String sqlQuery ="delete from ph_disp_locn_prn_option where facility_id =? and disp_locn_code = ?";	
		try { 
			pstmt = connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			count = pstmt.executeUpdate();	
			if(count ==0)
				count = 1;
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
        }
        finally {
            try {
                closeStatement( pstmt ) ;
            }
            catch(Exception es){
				es.printStackTrace();
			}
        }
		return count;
	}
}
