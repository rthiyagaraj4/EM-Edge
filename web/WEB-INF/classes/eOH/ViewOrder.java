/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;
 

import java.io.* ;
import java.util.* ;
import java.sql.*;

import eOH.Common.* ;
import eCommon.Common.*;

public class ViewOrder extends OHAdapter implements SceduleFreqeuncyInterface, java.io.Serializable {
	HashMap clob_data_hmp  = new HashMap();
	HashMap key_value_map1 = new HashMap();
	HashMap key_value_map2 = new HashMap();
	 ArrayList arrayData = new ArrayList();
	 ArrayList prepsdata=new ArrayList();
	 ArrayList deptData=new ArrayList();
	 public ArrayList getArrayData(){
	 		return arrayData;
	}

	StringBuffer	string_check = new StringBuffer();
	 public StringBuffer getStringBuffer(){
		 		return (StringBuffer)string_check;
		}


	public ArrayList panels       = new  ArrayList();
	public ArrayList discrete	   = new  ArrayList();
	public String interval_type = "";
	
	public String chk = "";
	public void setPrepsData(String prepsData,int i)
	{
		prepsdata.add(i,prepsData);
	}
	public String getPrepsData(int i)
	{
		return (String)prepsdata.get(i);
	}

	public String getDeptData(int i)
	{
		return (String)deptData.get(i);
	}

	public void setDeptData(String deptdata,int i)
	{
		deptData.add(i,deptdata);
	}

	public void setIntervalType(String interval_type){
		this.interval_type = interval_type;
	}

	public void setClobData(String clob_data, String count){
		this.clob_data_hmp.put(count, clob_data );
	}

	public String getClobData(String count){
		return (String)clob_data_hmp.get(count);
	}


	public void setKeyValueData1(HashMap key_value_map1){
		this.key_value_map1 = key_value_map1;
	}
	public void setKeyValueData2(HashMap key_value_map2){
		this.key_value_map2 = key_value_map2;
	}

	public HashMap getKeyValueData1(){
		return (HashMap)key_value_map1;
	}
	public HashMap getKeyValueData2(){
		return (HashMap)key_value_map2;
	}

/**
	@return		:	ArrayList
*/

	 public void clear(){

	 if(clob_data_hmp.isEmpty())
		  clob_data_hmp.clear();

 	 if(key_value_map1.isEmpty())
		  key_value_map1.clear();

 	 if(key_value_map2.isEmpty())
		 key_value_map2.clear();

	 panels       = new  ArrayList();
	 discrete	   = new  ArrayList();

	 }



	public String getMaxCount(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String max_action_seq_num = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CMTS_COUNT") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				max_action_seq_num = ""+resultSet.getInt("action_seq_num")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return max_action_seq_num;
	}

	public String getOrderPractitioner(String order_id) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String order_practitioner_name  = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PRACT_SELECT") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				order_practitioner_name = resultSet.getString("appl_user_name")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from order practitioner" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return order_practitioner_name;
	}
	


//Implementation of the Interface SceduleFreqeuncyInterface
	public boolean   setScheduleFrequencyStr(Hashtable ht){
		return true;
	}

//Implementation of the Interface SceduleFreqeuncyInterface
	public ArrayList getScheduleFrequencyStr(String order_id, String order_line_num){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList all_schedule 		= new ArrayList();
		ArrayList time_schedule 	= new ArrayList();
		int i=1;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_SCHD_DTL") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)order_line_num.trim());
			resultSet = pstmt.executeQuery() ;
			while( resultSet.next() ) {
				HashMap currRec =  new 	HashMap();
				if(!((interval_type.trim()).equalsIgnoreCase("W"))){
						currRec.put("admin_day_or_time","H");
						currRec.put("admin_day"		   ,"");
						currRec.put("admin_time"	   ,checkForNull(resultSet.getString("order_line_field_value"),""));
						currRec.put("admin_qty"		   ,checkForNull(resultSet.getString("order_line_dose_qty_value")));
						currRec.put("uom_desc"		   ,checkForNull(resultSet.getString("order_line_dose_qty_unit")));

						time_schedule.add(currRec);

				}else{
					if((checkForNull(resultSet.getString("order_line_field_value"),"")).equals("Y")){
						currRec.put("admin_day_or_time","D");
						currRec.put("admin_day"		   ,""+i);
						currRec.put("admin_time"	   ,"");
						currRec.put("admin_qty"		   ,checkForNull(resultSet.getString("order_line_dose_qty_value")));
						currRec.put("uom_desc"		   ,checkForNull(resultSet.getString("order_line_dose_qty_unit")));

						i++;
						all_schedule.add(currRec);
					}else if((checkForNull(resultSet.getString("order_line_field_value"))).equals("N")){
						i++;
						continue;
					}else{
						currRec.put("admin_day_or_time","D");
						currRec.put("admin_day"		   ,"");
						currRec.put("admin_time"	   ,checkForNull(resultSet.getString("order_line_field_value"),""));
						currRec.put("admin_qty"		   ,checkForNull(resultSet.getString("order_line_dose_qty_value")));
						currRec.put("uom_desc"		   ,checkForNull(resultSet.getString("order_line_dose_qty_unit")));

						time_schedule.add(currRec);
					}

				}
			}
			time_schedule.addAll(all_schedule);
		} catch ( Exception e )	{
			e.printStackTrace() ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}catch(Exception e){
				e.printStackTrace() ;
			}
		}

		return time_schedule;
	}



	public String getComments(String order_id, String num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_comment = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CMTS") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)num.trim());
			resultSet = pstmt.executeQuery() ;

			/*while( resultSet != null && resultSet.next() ) {
					order_comment = "";
				   	java.io.InputStream datas = resultSet.getAsciiStream("order_comment");
				   	if(datas!=null) {
				   	   int c;
				   	   while ((c = datas.read ()) != -1)
				   	   order_comment = ""+ order_comment +(char)c;
				   	}if(datas!=null) datas.close();
			}*/
			order_comment = "";
			Clob ord_cmt_data = null;
			while(resultSet != null && resultSet.next()){
				ord_cmt_data = resultSet.getClob("order_comment");
				if(ord_cmt_data !=null && ord_cmt_data.length() > 0)
					order_comment = ord_cmt_data.getSubString(1,( (int)ord_cmt_data.length() ));
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		return order_comment;
	}

/**

	@return		:	ArrayList
*/

	public ArrayList getOrderFormatDetail(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;PreparedStatement pstmt5 	= null;
		PreparedStatement pstmt6 	= null;PreparedStatement pstmt7 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet2 		= null;ResultSet resultSet3 		= null;
		ResultSet resultSet4 		= null;ResultSet resultSet5 		= null;
		ResultSet resultSet6 		= null;ResultSet resultSet7 		= null;
		ArrayList order_format_dtl  = new ArrayList();
		//String lb_install_yn 		= "N";commented for lb_install_yn change on 7/18/2007 by uma 
		String bt_install_yn 		= "N";
		String rd_install_yn 		= "N";
		String ot_install_yn		= "N";
		String order_category		= "";
		//String[] record2 = null;
		String[] record1 = null;
		String labchk="";
		try {
			connection = getConnection() ;

			if(order_id!=null && order_id.length() >2)
				order_category = order_id.substring(0,2); // First 2 characters for order_category

			/*if(order_category.equals("LB")){
				pstmt2 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt2.setString(1, "RL");
				pstmt2.setString(2, login_facility_id);
				resultSet2 = pstmt2.executeQuery() ;
				if(resultSet2!=null && resultSet2.next() ) {
					lb_install_yn = 	resultSet2.getString("operational_yn")  ;
				}
			}commented on 7/18/2007 for lb_install_yn change by uma*/

			if(order_category.equals("LB")){
				pstmt3 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			}else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}


			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_CMTS") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				String record[] = new String[6];

				record[0] = resultSet.getString("order_field_type")  ;
				record[1] = resultSet.getString("order_label_text")  ;
				record[2] = resultSet.getString("order_field_value")  ;
				record[3] = resultSet.getString("accept_option")  ;
				record[4] = resultSet.getString("discr_msr_uom")  ;
				record[5] = resultSet.getString("order_field_mnemonic")  ;
				
   if(order_category.equals("LB")){
				pstmt6 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull(order_id.trim(),"") );
         
				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() ) { 
						 record1 = new String[2];// Only One record
						record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
						record1[1]=resultSet6.getString( "order_type_code" )  ;
				}
				labchk=checkForNull(getmoduleRL(record1[0],order_category,record1[1],login_facility_id),"");
			}
				//if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE") )//changed on 7/18/2007 for lb_instal_yn change check by uma 
				if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma 
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_BLOOD_GROUP") )
				{
					record[2]=checkForNull(record[2],"");
					if(record[2].equals("null"))record[2]="";
					if(!record[2].equals(""))
					{
						pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery() ;
						if(resultSet1!=null && resultSet1.next() ) {	// One rec
							record[2] = resultSet1.getString("description")  ;
						}
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma 
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_RHESUS") )
				{
						record[2]=checkForNull(record[2],"");
						if(record[2].equals("null"))record[2]="";
						if(!record[2].equals(""))
						{
							pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
					}
								//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma 
				}
				 else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1,language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_install_yn change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled
					
							pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, order_id);
							resultSet1 = pstmt1.executeQuery() ;
						
							if(resultSet1!=null && resultSet1.next() ) 
							{	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("OT_OPER_KEYWORD") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("CN") && (resultSet.getString("order_field_mnemonic").equals("PERFORM_PRACT_ID") || resultSet.getString("order_field_mnemonic").equals("CONULT_MED_ID")) )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_AM_PRACTITIONER_PERFORM_TEAM_SURGEON") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}else if(((order_category.trim()).equalsIgnoreCase("OT"))  && (resultSet.getString("order_field_mnemonic").equals("ANAESTHESIA")) )    // For OT ANAESTHESIA
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}

				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;

				order_format_dtl.add(record);
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet1 ) ;
			closeResultSet( resultSet2 ) ;
			closeResultSet( resultSet3 ) ;
			closeResultSet( resultSet4 ) ;
			closeResultSet( resultSet5 ) ;
			closeResultSet( resultSet6 ) ;
			closeResultSet( resultSet7 ) ;
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt2 ) ;
			closeStatement( pstmt3 ) ;
			closeStatement( pstmt4 ) ;
			closeStatement( pstmt5 ) ;
			closeStatement( pstmt6 ) ;
			closeStatement( pstmt7 ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		return order_format_dtl;
	}

	  public String getInstructionsMode(String reason_code) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  instruction_mode	= "";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_INSTRUCTIONS_MODE"));
			pstmt.setString(1, checkForNull(reason_code,""));
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					instruction_mode = resultSet.getString("action_reason_desc");
				}
			}
		}catch(Exception e)
		{
			System.err.println( "When Populating Instructions" +e) ;
			e.printStackTrace() ;
		}finally{
			try{
            closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return instruction_mode;
	}
/**

	@return		:	ArrayList
*/

	public ArrayList getOrderFormatLineDetail(String order_id,String line_id, String called_from) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5 	= null;PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet1 		= null;ResultSet resultSet2 		= null;
		ResultSet resultSet3 		= null;ResultSet resultSet4 		= null;
		ResultSet resultSet5 		= null;ResultSet resultSet6 		= null;
		ResultSet resultSet7 		= null;
		//String lb_install_yn 		= "N";commented on 7/18/2007 for lb_install_yn logic change by uma 
		String bt_install_yn 		= "N";
		String rd_install_yn 		= "N";
		String ot_install_yn		= "N";
		String order_category		= "";
		ArrayList order_format_dtl = new ArrayList();
		String labchk="";
		//String[] record2 = null;
		String[] record1 = null;
		try {
			connection = getConnection() ;

			if(order_id!=null && order_id.length() >2)
				order_category = order_id.substring(0,2); // First 2 characters for order_category

			/*if(order_category.equals("LB")){
				pstmt2 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt2.setString(1, "RL");
				pstmt2.setString(2, login_facility_id);
				resultSet2 = pstmt2.executeQuery() ;
				if(resultSet2!=null && resultSet2.next() ) {
					lb_install_yn = 	resultSet2.getString("operational_yn")  ;
				}
			}commented on 7/18/2007 for lb_install_yn logic change by uma */
			 if(order_category.equals("LB")){
				pstmt6 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull((String)order_id.trim(),"") );
         
				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() ) { 
						 record1 = new String[2];// Only One record
						record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
						record1[1]=resultSet6.getString( "order_type_code" )  ;
				}
				labchk=checkForNull(getmoduleRL(record1[0],order_category,record1[1],login_facility_id),"");
			}
			if(order_category.equals("LB")){
				pstmt3 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			} else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}
			if(called_from!=null && called_from.equals("RESULT_ENTRY"))
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_CMTS") ) ;
			else
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_CMTS") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)line_id.trim());
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				String record[] = new String[8];
				record[0] = resultSet.getString("order_line_field_type")  ;
				record[1] = resultSet.getString("order_line_label_text")  ;
				record[2] = resultSet.getString("order_line_field_value")  ;
				record[3] = resultSet.getString("item_narration")  ;
				record[4] = resultSet.getString("order_line_field_mnemonic")  ;
				record[5] = resultSet.getString("order_line_num")  ;
				record[6] = resultSet.getString("catalog_synonym_dc");
				record[7] = resultSet.getString("discr_msr_uom");

				//if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )changed on 7/18/2007 for lb_install_yn logic change by uma 
				if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_line_field_mnemonic").equals("DONOR_BLOOD_GROUP") )
				{
					record[2]=checkForNull(record[2],"");
					if(!record[2].equals(""))
					{
						pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery() ;
						if(resultSet1!=null && resultSet1.next() ) {	// One rec
							record[2] = resultSet1.getString("description")  ;
						}
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma 
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_line_field_mnemonic").equals("DONOR_RHESUS") )
				{
					record[2]=checkForNull(record[2],"");
					if(!record[2].equals(""))
					{
									pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
									pstmt1.setString(1, record[2]);
									resultSet1 = pstmt1.executeQuery() ;
									if(resultSet1!=null && resultSet1.next() ) {	// One rec
										record[2] = resultSet1.getString("description")  ;
									}
						}
								//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma 
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn logic change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_instal_yn logic change by uma 
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled
					pstmt1 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, order_id);
							resultSet1 = pstmt1.executeQuery() ;
						
							if(resultSet1!=null && resultSet1.next() ) 
							{	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("OT_OPER_KEYWORD") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_line_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_line_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("PH") && resultSet.getString("order_line_field_mnemonic").equals("PRES_REMARKS") )
				{
					pstmt1 = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PH_PRES_REMARK") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_line_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("ANAESTHESIA")) )    // For OT SURGERY_TYPE
				{
					
					pstmt1 = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				
				order_format_dtl.add(record);
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally { 
			try{
			closeResultSet( resultSet5 ) ;
			closeResultSet( resultSet4 ) ;
			closeResultSet( resultSet3 ) ;
			closeResultSet( resultSet2 ) ;
			closeResultSet( resultSet1 ) ;
			closeResultSet( resultSet6 ) ;
			closeResultSet( resultSet7 ) ;
			closeResultSet( resultSet ) ;
			closeStatement( pstmt5 ) ;
			closeStatement( pstmt4 ) ;
			closeStatement( pstmt3 ) ;
			closeStatement( pstmt2 ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt6 ) ;
			closeStatement( pstmt7 ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return order_format_dtl;
	}


	// To populate the Instructions
	public ArrayList getInstructions(String order_id, String line_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Instructions		= new ArrayList();

		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_INSTNS"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, line_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						String[] record	= new String[4];
						record[0] = resultSet.getString("order_line_field_type")  ;
						record[1] = resultSet.getString("order_line_label_text")  ;
						record[2] = resultSet.getString("order_line_field_value")  ;
						record[3] = resultSet.getString("order_line_field_mnemonic")  ;
						Instructions.add(record);
					}
				}
			}catch ( Exception e )	{
				System.err.println( "Error loading values from database") ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return Instructions;
	}

	public int getIndTotalCount(String order_id, String line_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int total					= 0;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FORMAT_LINE_DETAILS_COUNT"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, line_id);

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						total = resultSet.getInt( "total" );
					}
				}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database") ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
				return total;
	}




	public String[] getAbnormalCondition()throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String result_data[] = new String[6];
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_CONDN") ) ;

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {
				result_data[0] = resultSet.getString("high_str");
				result_data[1] = resultSet.getString("low_str");
				result_data[2] = resultSet.getString("abn_str");
				result_data[3] = resultSet.getString("crit_str");
				result_data[4] = resultSet.getString("crit_high_str");
				result_data[5] = resultSet.getString("crit_low_str");
			}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return result_data;
	}




/**

	@return		:	ArrayList
*/

	public ArrayList viewResultDetail(String order_id, String ord_line_num, String cont_order_ind, String patient_id, String ord_cat, String facility_id,String resp_id, String order_status) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet6 			= null;
		ResultSet resultSet7 			= null;
		ArrayList order_format_dtl = new ArrayList();
		int count = 0;

		String currPanel			= "";
		String currDiscrete			= "";
		String order_date			= "",old_order_date = "";
		panels						= new  ArrayList();
	    discrete					= new  ArrayList();
		String ot_install_yn		= "N";
		//String[] record2 = null;
		String[] record1 = null;
		String labchk="";
		

		try {

			if(ord_line_num.equals(" ")|| ord_line_num.equals(""))
				ord_line_num = null;

			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, "RL");
			resultSet = pstmt.executeQuery() ;

			String install_yn = "";
			if(resultSet.next() ) {
				install_yn = 	resultSet.getString("install_yn")  ;
			}
			if(install_yn == null)
				install_yn = "";

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

            pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
            pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

			String rd_install_yn = "";
			if(resultSet.next() ) {
				rd_install_yn = 	resultSet.getString("operational_yn")  ;
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(rd_install_yn == null)
				rd_install_yn = "";

			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
            pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

 			if(resultSet.next() ) {
				ot_install_yn = 	resultSet.getString("operational_yn")  ;
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(ot_install_yn==null)
				ot_install_yn = "";


			String lbrdSearchYN = getLBRDSearchYN(order_status);

 if(ord_cat.equals("LB")){
				pstmt6 = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull((String)order_id.trim(),"") );
         
				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() ) { 
						 record1 = new String[2];// Only One record
						record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
						record1[1]=resultSet6.getString( "order_type_code" )  ;
						//catalogchk=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
				}
				labchk=checkForNull(getmoduleRL(record1[0],ord_cat,record1[1],login_facility_id),"");
			}
			//if(((install_yn.equals("Y") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT"))) && (lbrdSearchYN.equals("Y"))){changed on 7/18/2007 for lb_install_yn check logic by uma 
			if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT"))) && (lbrdSearchYN.equals("Y"))){
				//if (lbrdSearchYN.equals("Y"))
				{
					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_FREQ_EXPL") ) ;
					}else{
						pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS") ) ;
					}
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, patient_id);
						pstmt.setString(3, resp_id);
						pstmt.setString(4, resp_id);
						
				} /*else {
					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PARENT_CHILD_RSLT_DTLS") ) ;
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, ord_line_num);
						pstmt.setString(3, patient_id);
						pstmt.setString(4, resp_id);
						pstmt.setString(5, resp_id);
					}else{
						pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_WITHOUT_LB") ) ;
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, ord_line_num);
						pstmt.setString(3, patient_id);
						pstmt.setString(4, resp_id);
						pstmt.setString(5, resp_id);
					}
				}*/
			}else{
				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
					pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PARENT_CHILD_RSLT_DTLS") ) ;
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, (String)order_id.trim());
					pstmt.setString(3, ord_line_num);
					pstmt.setString(4, patient_id);
					pstmt.setString(5, resp_id);
					pstmt.setString(6, resp_id);
				}else{
					pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_WITHOUT_LB") ) ;
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, ord_line_num);
					pstmt.setString(3, patient_id);
					pstmt.setString(4, resp_id);
					pstmt.setString(5, resp_id);
				}
			}

			resultSet = pstmt.executeQuery() ;
			Clob rslt_data = null;	//Common-ICN-0044
			while(resultSet.next() ) {
                String record[];
               // if(((install_yn.equals("Y") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (lbrdSearchYN.equals("Y"))){changed on 7/18/2007 for lb_instal_yn logic change by uma 
                if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (lbrdSearchYN.equals("Y"))){
                   // record = new String[26];
					record = new String[30];
                }else{ //record = new String[25];
					record = new String[29];//modified for CAimage
				}
				String result_data = "";

				record[0] = resultSet.getString("report_srl_no")  ;
				record[1] = resultSet.getString("discr_msr_panel_id")  ;

				if(record[1] != null){
					if(!currPanel.trim().equalsIgnoreCase(record[1])) {
						panels.add(record[1]);
						 currPanel = record[1] ;
					}
				}


				record[2] = resultSet.getString("discr_msr_id")  ;

				if(!currDiscrete.trim().equalsIgnoreCase(record[2])) {
					discrete.add(record[2]);
					 currDiscrete = record[2] ;
				}

				record[3] = resultSet.getString("srl_no")  ;
				record[4] = resultSet.getString("result_type")  ;
				record[5] = resultSet.getString("result_num")  ;
				record[6] = resultSet.getString("result_num_uom")  ;
				record[7] = resultSet.getString("result_str")  ;
				result_data = "";
				 rslt_data = resultSet.getClob("result_data");
				if(rslt_data!=null && rslt_data.length() > 0)
					result_data = rslt_data.getSubString(1,( (int)rslt_data.length() ));
					//setClobData(result_data, ""+count);
			    arrayData.add(result_data);
				string_check.append(result_data);

				//if(rslt_data == null)
				//	rslt_data = "";
				//chk += "res_data here : "+result_data;
				record[8] = result_data ;
				order_date = resultSet.getString("reporting_date")  ;
				if(cont_order_ind!=null && cont_order_ind.equals("DO"))
				{
					if(old_order_date.equals(""))
					{
					  old_order_date = order_date;
					  record[9]  	 = old_order_date;
				    }
					else
					   record[9]  		= old_order_date;
			    }
				else
					record[9] = order_date;

				record[10] = resultSet.getString("result_status")  ;
				record[11] = resultSet.getString("normal_low")  ;
				record[12] = resultSet.getString("normal_high")  ;
				record[13] = resultSet.getString("critical_low")  ;
				record[14] = resultSet.getString("critical_high")  ;
				record[15] = resultSet.getString("norm_abnorm_ind")  ;
				record[16] = resultSet.getString("result_comments")  ;
				record[17] = "";//resultSet.getString("parent_msr")  ;
				record[18] = resultSet.getString("parent_short_desc")  ;
				record[19] = resultSet.getString("child_desc")  ;
				record[20] = resultSet.getString("result_desc")  ;
				record[21] = ""+count ;
                //if(((install_yn.equals("Y") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")))  && (lbrdSearchYN.equals("Y"))){changed on 7/18/2007 for lb_install_yn logic change by uma 
                if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")))  && (lbrdSearchYN.equals("Y"))){
                    record[22] = ((resultSet.getString("PRACTITIONER_ID") == null) ? "" : resultSet.getString("PRACTITIONER_ID"));
                    record[23] = resultSet.getString("ext_image_obj_id")  ;
                    record[24] = resultSet.getString("ext_image_appl_id")  ;
                    record[25] = resultSet.getString("reporting_practitioner")  ;
					record[26] = resultSet.getString("hist_rec_type")  ;
	                record[27] = resultSet.getString("contr_sys_id")  ;
	                record[28] = resultSet.getString("accession_num")  ;
	                record[29] = resultSet.getString("contr_sys_event_code")  ;
                } else {
	                record[22] = resultSet.getString("ext_image_obj_id")  ;
	                record[23] = resultSet.getString("ext_image_appl_id")  ;
	                record[24] = resultSet.getString("reporting_practitioner")  ;
	                record[25] = resultSet.getString("hist_rec_type")  ;
	                record[26] = resultSet.getString("contr_sys_id")  ;
	                record[27] = resultSet.getString("accession_num")  ;
	                record[28] = resultSet.getString("contr_sys_event_code")  ;
				}

				order_format_dtl.add(record);
				count++;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" + e) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet6 ) ;
			closeResultSet( resultSet7 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt6 ) ;
			closeStatement( pstmt7 ) ;
			closeConnection(connection) ;
		}
		return order_format_dtl;
	}

	public TreeMap getAllTimes(int key, ArrayList raw_list){
		TreeMap sorted_time_map 	= new TreeMap();
		String[]raw_array 			= null;
		chk = "";

		for(int i=0; i<raw_list.size(); i++){
			raw_array = (String[])raw_list.get(i);
			sorted_time_map.put(raw_array[key], "");
		}
		return sorted_time_map;

	}

	public TreeMap traverseList(int key, ArrayList raw_list, TreeMap refined_map){
		TreeMap sorted_panel_map 	= new TreeMap();
		

		String[]raw_array 			= null;
		chk = "";
		if(key == 1) {//search for panel_id
			for(int i=0; i<raw_list.size(); i++){
				raw_array = (String[])raw_list.get(i);
				sorted_panel_map.put(raw_array[key], "");
				key_value_map1.put(raw_array[key], raw_array[18]);
			}
			setKeyValueData1(key_value_map1);
			return sorted_panel_map;
		}

		if(key == 2) {//search for descr_msr_id
			Set tmp_set = (Set)refined_map.keySet();
			Iterator itr = (Iterator)tmp_set.iterator() ;
			String panel_key = "";
			while(itr.hasNext()){
				sorted_panel_map = new TreeMap();
				panel_key = (String)itr.next();
				for(int i=0; i<raw_list.size(); i++){
					raw_array = (String[])raw_list.get(i);
					if(raw_array[1].equals(panel_key) )
						sorted_panel_map.put(raw_array[key], "");
						key_value_map2.put(raw_array[key], raw_array[19]);
				}
				refined_map.put(panel_key, sorted_panel_map);
				setKeyValueData2(key_value_map2);

			}
			return refined_map;
		}


		if(key == 9) {//search for date time
			Set tmp_set = (Set)refined_map.keySet();
			Iterator itr = (Iterator)tmp_set.iterator() ;
			//chk += ">> "+itr.toString();
				chk =chk+">> "+itr.toString();
			TreeMap dscr_msr_panel = null;
			//Common-ICN-0044
			Set tmp_dscr_set = null;	
			Iterator tmp_dscr_itr = null;	
			//Common-ICN-0044
			String dcsr_msr_val = "";
			String dscr_msr_panel_key = "";

			while(itr.hasNext()){
				dscr_msr_panel_key 	= (String)itr.next();
				dscr_msr_panel	   	= (TreeMap)refined_map.get(dscr_msr_panel_key);
				 tmp_dscr_set 	= (Set)dscr_msr_panel.keySet();
				 tmp_dscr_itr = (Iterator)tmp_dscr_set.iterator() ;
				while(tmp_dscr_itr.hasNext()){
					dcsr_msr_val = (String)tmp_dscr_itr.next();
					//chk += ">>> "+dcsr_msr_val;
						chk =chk+">>> "+dcsr_msr_val;
					sorted_panel_map = new TreeMap();
					for(int i=0; i<raw_list.size(); i++){
						raw_array = (String[])raw_list.get(i);

						if(raw_array[2].equals(dcsr_msr_val) )
							sorted_panel_map.put(raw_array[key], raw_array);
					}
					dscr_msr_panel.put(dcsr_msr_val,sorted_panel_map);
				}
			}
			return refined_map;
		}
		return null;

	}

	public ArrayList getAuditTrialValues(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Instructions		= new ArrayList();

		try{
				order_id = checkForNull(order_id,"").trim();
				
                connection	= getConnection();
				pstmt		= connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_AUDIT_TRIAL1"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, (checkForNull(order_id,"")).trim());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[12];
						record[0] = resultSet.getString("ord_date_time")  ;
						record[1] = resultSet.getString("ord_pract_id")  ;
						record[2] = resultSet.getString("ord_consent_by_date_time")  ;
						record[3] = resultSet.getString("ord_consent_by_id")  ;
						record[4] = resultSet.getString("ord_auth_date_time")  ;
						record[5] = resultSet.getString("ord_auth_by_pract_id")  ;
						record[6] = resultSet.getString("ord_appr_date_time")  ;
						record[7] = resultSet.getString("ord_appr_by_user_id")  ;
						record[8] = resultSet.getString("ord_cosign_date_time")  ;
						record[9] = resultSet.getString("ord_cosign_by_pract_id")  ;
						record[10] = resultSet.getString("regn_date_time")  ;
						record[11] = resultSet.getString("regn_pract_id")  ;
						Instructions.add(record);
					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return Instructions;
	}

	public ArrayList getAuditTrialSpecimenValues(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Instructions		= new ArrayList();

		try{
				order_id = checkForNull(order_id,"").trim();
				connection	= getConnection();
				pstmt		= connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_AUDIT_TRIAL2"));
				pstmt.setString(1, (checkForNull(order_id,"")).trim());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[4];
						record[0] = resultSet.getString("specimen_collect_date_time")  ;
						record[1] = resultSet.getString("specimen_collected_by")  ;
						
						Instructions.add(record);
					}
				}
			}catch ( Exception e )	{
				System.out.println( "Error loading values from database") ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return Instructions;
	}

	public String getAuditPractionerDesc(String pract_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  pract_name	= "";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_PRACT_DTLS"));
			pstmt.setString(1,language_id);
			pstmt.setString(2, checkForNull(pract_id,"").trim());
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					pract_name = resultSet.getString("practitioner_name");
					if (pract_name == null) {
					   pract_name = "";
					}
				}
			}
		}catch(Exception e)
		{
			System.err.println( "When Populating Instructions" +e) ;
			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return pract_name;
	}

	public String[] getOrderDetails(String order_id)throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String order_data[] = new String[7];
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_DTLS") ) ;
			pstmt.setString(1, order_id.trim());

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {
				order_data[0] = resultSet.getString("order_type_code");
				order_data[1] = resultSet.getString("patient_class");
				order_data[2] = resultSet.getString("priority");
				order_data[3] = resultSet.getString("order_id");
				order_data[4] = resultSet.getString("source_type");
				order_data[5] = resultSet.getString("source_code");
				order_data[6] = resultSet.getString("order_status");
			}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return order_data;
	}

	public String getLBRDSearchYN(String order_status) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  lbrdSearchYN	= "N";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_LB_RD_SEARCH_YN"));
			pstmt.setString(1, checkForNull(order_status,"").trim());
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					lbrdSearchYN = resultSet.getString("lbrdSearchYN");
					if (lbrdSearchYN == null) {
					   lbrdSearchYN = "N";
					}
				}
			}
		}catch(Exception e)
		{
			System.err.println( "When Populating Instructions" +e) ;
			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return lbrdSearchYN;
	}

	public ArrayList getChildOrders(String order_id) throws Exception {
	Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList C_ORDER_ID			= new ArrayList();
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT ORDER_ID FROM  OR_ORDER	WHERE  PARENT_ORDER_ID = ?  AND  ORDER_STATUS  IN (SELECT ORDER_STATUS FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('70','75','85','90'))") ;
			pstmt.setString(1, order_id);
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				String[] record	= new String[1];
				record[0] = resultSet.getString("ORDER_ID");
				C_ORDER_ID.add(record);
			}
		}
		catch( Exception e) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}finally{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return C_ORDER_ID;
	}

	public String getFacilityName() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String facility_name = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_PARAM_FOR_FACILITY_VIEW_ORDER") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				facility_name = resultSet.getString("facility_name");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return facility_name;
	}
	public String getPractitionerName(String practitioner_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String practitioner_name = "";
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_PRACT") ) ;
				pstmt.setString(1,language_id);
				pstmt.setString(2, practitioner_id);
				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					practitioner_name = resultSet.getString("practitioner_name");
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from databasepractitioner_name" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return practitioner_name;
	}

	public ArrayList getViewApptTransferDtls(String appt_ref_no, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Details			= new ArrayList();
		try{
                connection			= getConnection();

				pstmt				= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_TRANSFER_APPT_DETAILS"));
 				pstmt.setString(1, (checkForNull(facility_id,"")).trim());
				pstmt.setString(2, (checkForNull(appt_ref_no,"")).trim());
 			 
  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[14];
   						record[0] = checkForNull(resultSet.getString("alcn_criteria"));
  						record[1] = checkForNull(resultSet.getString("appt_slab_from_time"));
						record[2] = checkForNull(resultSet.getString("appt_slab_to_time"));
						record[3] = checkForNull(resultSet.getString("clinic_code"));
						record[4] = checkForNull(resultSet.getString("practitioner_id"));
  						record[5] = checkForNull(resultSet.getString("appt_date"));
						record[6] = checkForNull(resultSet.getString("appt_type_code"));
						record[7] = checkForNull(resultSet.getString("team_id"));
						record[8] = checkForNull(resultSet.getString("overbooked_yn"));
 						record[9] = checkForNull(resultSet.getString("forced_appt_yn"));
						record[10] = checkForNull(resultSet.getString("care_locn_type_ind")); //clinic_type
 						record[11] = checkForNull(resultSet.getString("resource_class"));
						record[12] = checkForNull(resultSet.getString("visit_type_ind")); //visit_type_ind
 						record[13] = checkForNull(resultSet.getString("appt_day"));
						Details.add(record);
 					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return Details;
	}

public ArrayList getOrderIds(String order_set_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderId		= new ArrayList();
		try{
                connection	= getConnection();
				pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_SET_ORDER_ID_SELECT"));
				pstmt.setString(1,language_id);
				pstmt.setString(2, (checkForNull(order_set_id,"")).trim());
  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[3];
						record[0] = resultSet.getString("order_id")  ;
 						record[1] = resultSet.getString("order_category")  ;
						record[2] = resultSet.getString("order_category_short_desc")  ;
 						OrderId.add(record);
					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return OrderId;
	}

	public ArrayList getOrderCatalogDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCatalog		= new ArrayList();
		try{
                connection	= getConnection();
				pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_CATALOGS"));
				pstmt.setString(1, (checkForNull(order_id,"")).trim());
  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[3];
						record[0] = resultSet.getString("order_catalog_code")  ;
						record[1] = resultSet.getString("catalog_synonym_dc")  ;
 						record[2] = resultSet.getString("order_line_num")  ;
  						OrderCatalog.add(record);
					}
				}
			}catch ( Exception e )	{
				System.out.println( "Error loading values from database") ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return OrderCatalog;
	}

	public ArrayList getOrderHistoryDetails(String order_id, String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCatalog		= new ArrayList();
		try{
                connection	= getConnection();
				pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ORDER_DTLS"));
				pstmt.setString(1, (checkForNull(order_id,"")).trim());
				pstmt.setString(2, (checkForNull(order_line_num,"")).trim());
  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[3];
						record[0] = resultSet.getString("field_mnemonic")  ;
						record[1] = resultSet.getString("order_line_num")  ;
  						record[2] = resultSet.getString("field_legends")  ;
  						OrderCatalog.add(record);
					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return OrderCatalog;
	}

		public ArrayList getViewDetails(String order_id, String order_line_num, String field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Details			= new ArrayList();
		try{
                connection	= getConnection();

				if(checkForNull(order_line_num,"").equals("")) {
					pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ACTION_DTLS"));
					pstmt.setString(1,language_id);
					pstmt.setString(2, (checkForNull(order_id,"")).trim());
				} else  { // With order_line_num this query
					pstmt		= connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ORDER_LINE_ACTION_DTLS"));
					pstmt.setString(1,language_id);
					pstmt.setString(2, (checkForNull(order_id,"")).trim());
					pstmt.setString(3, (checkForNull(order_line_num,"")).trim());
					pstmt.setString(4, (checkForNull(field_mnemonic,"")).trim());
				}

  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        String[] record	= new String[25];
 						record[0] = checkForNull(resultSet.getString("action_seq_num"));
  						record[1] = checkForNull(resultSet.getString("action_user_id"));
						record[2] = checkForNull(resultSet.getString("action_date_time"));
						record[3] = checkForNull(resultSet.getString("action_facility_id"));
						record[4] = checkForNull(resultSet.getString("field_mnemonic"));
  						record[5] = checkForNull(resultSet.getString("field_value_old"));
						record[6] = checkForNull(resultSet.getString("field_value_new"));
						record[7] = checkForNull(resultSet.getString("field_value_txt"));
						record[8] = checkForNull(resultSet.getString("field_legends"));
						record[9] = checkForNull(resultSet.getString("order_status_old"));
						record[10] = checkForNull(resultSet.getString("order_status_new"));
 						record[11] = checkForNull(resultSet.getString("freq_old_desc"));
						record[12] = checkForNull(resultSet.getString("freq_new_desc"));
						record[13] = checkForNull(resultSet.getString("durn_old_desc"));
						record[14] = checkForNull(resultSet.getString("durn_new_desc"));
						record[15] = checkForNull(resultSet.getString("uom_old_desc"));
						record[16] = checkForNull(resultSet.getString("uom_new_desc"));
						record[17] = checkForNull(resultSet.getString("perform_old_desc"));
						record[18] = checkForNull(resultSet.getString("perform_new_desc"));
						record[19] = checkForNull(resultSet.getString("order_catalog_old_desc"));
						record[20] = checkForNull(resultSet.getString("order_catalog_new_desc"));
						record[21] = checkForNull(resultSet.getString("facility_old_desc"));
						record[22] = checkForNull(resultSet.getString("facility_new_desc"));
						record[23] = checkForNull(resultSet.getString("appl_user_name"));
						record[24] = checkForNull(resultSet.getString("Order_catalog_desc"));
  						Details.add(record);
					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return Details;
	}

	public String getUserName(String user_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String appl_user_name = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_USER_SELECT") ) ;

			pstmt.setString(1, user_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				appl_user_name = resultSet.getString("appl_user_name");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database appl_user_name" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return appl_user_name;
	}

	public String getDescription(String field_mnemonic , String field_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String	 field_value		= "";
 		try {
				 connection = getConnection() ;
				 if(field_mnemonic.equals("ROUTE_CODE")) {
					  pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ROUTE_SELECT") ) ;
				 } else if(field_mnemonic.equals("PERFORM_DEPTLOC_CODE")) {
 				 	  pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_PH_PERFORMING_LOCN_SELECT") ) ;
				 }
					pstmt.setString(1, field_code);
 					resultSet = pstmt.executeQuery() ;
					while( resultSet != null && resultSet.next() ) {
 						field_value		= resultSet.getString("short_desc");
					}
 			} catch ( Exception e )	{
				System.err.println( "Error loading values from database field_value" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return field_value;
	}

	public String getImageRefYn(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String	 image_ref_yn		= "N";
 		try {
				 connection = getConnection() ;
				  pstmt = connection.prepareStatement( OHRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_REF_YN") ) ;

 				 pstmt.setString(1, order_id);
				 pstmt.setString(2, "1"); // order_line_num
 				 resultSet = pstmt.executeQuery() ;
				 while( resultSet != null && resultSet.next() ) {
 					image_ref_yn		= resultSet.getString("image_ref_yn");
				}
				if(image_ref_yn==null) image_ref_yn = "N";
 			} catch ( Exception e )	{
				System.err.println( "Error loading values from database field_value" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return image_ref_yn;
	}

	public String getRemarks(String order_id, String action_seq_num) throws Exception 
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String remarks			    = "";
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OHRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_REMARKS_SELECT") ) ;

			pstmt.setString(1, order_id);
			pstmt.setString(2, action_seq_num);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				remarks = resultSet.getString("field_value_txt");
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database field_value_txt" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return remarks;
	}

	public String[] getFieldValue(String order_id, String[] view_details) throws Exception 
	{
			 // view_details Will hold all the old and new desc of frequency,duration,qty(uom),perform desc
 		String[] fieldValue	= new String[2]; // will hold the old and new desc
		String old_value		= "",	new_value = "";
  		if(view_details!=null && view_details[4].equals("ORDER_LINE_STATUS")) 
		{ // check the field mnemonic if(ORDER_LINE_STATUS)
			old_value	=	view_details[9];		//order_status_old
			new_value	=	view_details[10];		//order_status_new
		} 
		else if(view_details!=null && view_details[4].equals("FREQ_CODE")) 
			{ // check the field mnemonic if(FREQ_CODE)
			old_value	=	view_details[11];		//freq_old_desc
			new_value	=	view_details[12];		//freq_new_desc
		} 
		else if(view_details!=null && view_details[4].equals("DURN_TYPE")) 
		{  // check the field mnemonic if(DURN_TYPE)
			old_value	=	view_details[13];		//durn_old_desc
			new_value	=	view_details[14];		//durn_new_desc
		} 
		else if(view_details!=null && view_details[4].equals("QTY_UNIT")) 
		{  // check the field mnemonic if(QTY_UNIT)
			old_value	=	view_details[15];		//uom_old_desc
			new_value	=	view_details[16];		//uom_new_desc
		} 
		else if(view_details!=null && view_details[4].equals("PERFORM_DEPTLOC_CODE")) 
		{  // check the field mnemonic if(PERFORM_DEPTLOC_CODE)
			if(order_id!=null && order_id.substring(0,2).equals("PH")) 
			{
				if(view_details[5]!=null && view_details[5].equals(""))
					old_value	= getDescription(view_details[4], view_details[5]);
 				if(view_details[6]!=null && view_details[6].equals(""))
					new_value	= getDescription(view_details[4], view_details[6]);
 			}	
			else 
			{
				 old_value		=	view_details[17];		//perform_old_desc
				 new_value		=	view_details[18];		//perform_new_desc
			}
		}
		else if(view_details!=null && view_details[4].equals("ORDER_CATALOG_CODE")) 
		{  // check the field mnemonic if(ORDER_CATALOG_CODE)
 			 old_value	=	view_details[19];		//order_catalog_old_desc
			 new_value	=	view_details[20];		//order_catalog_old_desc
		}  
		else if(view_details!=null && view_details[4].equals("PERFORMING_FACILITY_ID")) 
		{  // check the field mnemonic if(PERFORMING_FACILITY_ID)
			 old_value	=	view_details[21];		//facility_old_desc
			 new_value	=	view_details[22];		//facility_new_desc
		} 
		else if(view_details!=null && view_details[4].equals("IV_PREP_YN")) 
		{  // check the field mnemonic if(IV_PREP_YN)
			if( view_details[5]!=null  && (view_details[5].equals("1") || view_details[5].equals("2")))
				old_value	=  "IV With Additives";
			else if(view_details[5]!=null  && (view_details[5].equals("3") || view_details[5].equals("4")))
				old_value	= "IV Piggy Back";
			else if(view_details[5]!=null && view_details[5].equals("5"))
				old_value	= "IV Without Additive";

			if( view_details[6]!=null  && (view_details[6].equals("1") || view_details[6].equals("2")))
				new_value	=  "IV With Additives";
			else if(view_details[6]!=null  && (view_details[65].equals("3") || view_details[6].equals("4")))
				new_value	= "IV Piggy Back";
			else if(view_details[6]!=null && view_details[6].equals("5"))
				new_value	= "IV Without Additive";
  		} 
		else if(view_details!=null && view_details[4].equals("ROUTE_CODE")) 
		{  // check the field mnemonic if(ROUTE_CODE)
			if(view_details[5]!=null && view_details[5].equals(""))
				old_value	= getDescription(view_details[4], view_details[5]);
 			if(view_details[6]!=null && view_details[6].equals(""))
				new_value	= getDescription(view_details[4], view_details[6]);
  		} 
		else if(view_details!=null)
		{
			 old_value	=	view_details[5];		//field_value_old
			 new_value	=	view_details[6];		//field_value_new
		}
			if(old_value==null || old_value.equals(""))
				old_value	=	"&nbsp";
			if(new_value==null || new_value.equals(""))
				new_value	=	"&nbsp";

			fieldValue[0]		= old_value;
			fieldValue[1]		= new_value;
			return fieldValue;
	}

public ArrayList getOrderId(String order_id) throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		ArrayList get_order_id=new ArrayList();
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_GET_ORDER_ID"));
			pstmt.setString(1,(String)order_id.trim());
			pstmt.setString(2,(String)order_id.trim());
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				String orderId = rs.getString("order_id");
				if(!get_order_id.contains(orderId))
				{
					get_order_id.add(orderId);
				}
			}
				
		}
		catch(Exception e)
		{
				e.printStackTrace() ;
				throw e ;
		}
		finally 
		{ 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return get_order_id;		
}

public ArrayList getOrderLineNum(String order_id) throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String order_line_num="";
		ArrayList order_line_no=new ArrayList();
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_ORDER_LINE_NUM"));
			pstmt.setString(1,(String)order_id.trim());
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				order_line_num = rs.getString("order_line_num");
				order_line_no.add(order_line_num);
			}
		}
		catch(Exception e)
		{
				e.printStackTrace() ;
				throw e ;
		}
		finally 
		{ 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return order_line_no;	
}

public ArrayList getChartingDetails(String order_id,String order_line_num) throws Exception 
{
	Connection connection	= null;
	PreparedStatement pstmt_charting = null;
	ResultSet rs_charting			= null;
	ArrayList charting										= new ArrayList() ;
	
	String contr_module_trans_ref="";
	

	if(order_id==null || order_id.equals(" ")) order_id = "";
	if(order_line_num==null || order_line_num.equals(" ")) order_line_num = "";
	contr_module_trans_ref=order_id.trim()+"!"+order_line_num.trim();
	
	try
		  {
				connection  = getConnection();
				pstmt_charting = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_DISPLAY_CHARTING"));
				pstmt_charting.setString(1,(String)contr_module_trans_ref.trim());
												
				rs_charting	  =pstmt_charting.executeQuery();
				while(rs_charting != null && rs_charting.next())
				{
					String[]  charting_details							= new String[17];
					charting_details[0]  = checkForNull(rs_charting.getString("PANEL_DISP_ORDER_SEQ"),"");
					charting_details[1]  = checkForNull(rs_charting.getString("DISCR_DISP_ORDER_SEQ"),"");
					charting_details[2]  = checkForNull(rs_charting.getString("TEST_OBSERV_DT_TM"),"");
					charting_details[3]  = checkForNull(rs_charting.getString("CHART_GROUP_ID"),"");
					charting_details[4]  = checkForNull(rs_charting.getString("DISCR_MSR_ID").trim(),"");
					charting_details[5]  = checkForNull(rs_charting.getString("NORM_ABNORM_IND"),"");
					charting_details[6]  = checkForNull(rs_charting.getString("dt").trim(),"");
					charting_details[7]  = checkForNull(rs_charting.getString("DISCR_MSR_RESULT_TYPE"),"");
					charting_details[8]  = checkForNull(rs_charting.getString("DISCR_MSR_RESULT_NUM"),"");
					charting_details[9]  = checkForNull(rs_charting.getString("DISCR_MSR_RESULT_NUM_UOM"),"");
					charting_details[10]  = checkForNull(rs_charting.getString("DISCR_MSR_RESULT_STR"),"");
					charting_details[11]  = checkForNull(rs_charting.getString("RESULT_NUM_PREFIX"),"");
					charting_details[12]  = checkForNull(rs_charting.getString("normal_range_color"),"");
					charting_details[13]  = checkForNull(rs_charting.getString("NORMAL_LOW"),"");
					charting_details[14]  = checkForNull(rs_charting.getString("NORMAL_HIGH"),"");
					charting_details[15]  = checkForNull(rs_charting.getString("CRITICAL_LOW"),"");
					charting_details[16]  = checkForNull(rs_charting.getString("CRITICAL_HIGH"),"");
					charting.add(charting_details);
				}
		}
		catch(Exception e)
		{
				e.printStackTrace() ;
				throw e ;
				
		}finally 
		{ 
			
			closeResultSet(rs_charting) ;
			closeStatement(pstmt_charting) ;
			closeConnection(connection);
		}

		return charting;
}

public ArrayList getDetailsColors() throws Exception 
{
	Connection connection	= null;
	PreparedStatement pstmt_charting = null;
	ResultSet rslRst			= null;
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String deltaValue	= "";
	ArrayList charting										= new ArrayList() ;
	ArrayList listDesc							=new ArrayList();
	HashMap mapDescColor							=new HashMap();
	

	try
		  {
				connection  = getConnection();
				pstmt_charting = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COLOR"));
														
				rslRst	  =pstmt_charting.executeQuery();
				while(rslRst != null && rslRst.next())
				{
					high_value_desc = rslRst.getString("high_str_desc") == null ? "" : rslRst.getString("high_str_desc");
					high_value_color = rslRst.getString("high_color_code") == null ? "" : rslRst.getString("high_color_code");

					mapDescColor.put(high_value_desc,high_value_color);
					listDesc.add(high_value_desc);

					low_value_desc = rslRst.getString("low_str_desc") == null ? "" : rslRst.getString("low_str_desc");
					low_value_color = rslRst.getString("low_color_code") == null ? "" : rslRst.getString("low_color_code");
				   
					if(!(mapDescColor.containsKey(low_value_desc)))
					{
						mapDescColor.put(low_value_desc,low_value_color);
						listDesc.add(low_value_desc);
					}

					abnml_value_desc = rslRst.getString("abn_str_desc") == null ? "" : rslRst.getString("abn_str_desc");
					abnml_value_color = rslRst.getString("abn_color_code") == null ? "" : rslRst.getString("abn_color_code");

					if(!(mapDescColor.containsKey(abnml_value_desc)))
					{
						mapDescColor.put(abnml_value_desc,abnml_value_color);
						listDesc.add(abnml_value_desc);
					}

					crtcl_value_desc = rslRst.getString("crit_str_desc") == null ? "" : rslRst.getString("crit_str_desc");
					crtcl_value_color = rslRst.getString("crit_color_code") == null ? "" : rslRst.getString("crit_color_code");

					if(!(mapDescColor.containsKey(crtcl_value_desc)))
					{
						mapDescColor.put(crtcl_value_desc,crtcl_value_color);
						listDesc.add(crtcl_value_desc);
					}

					crtcl_high_value_desc = rslRst.getString("crit_high_str_desc") == null ? "" : rslRst.getString("crit_high_str_desc");
					crtcl_high_value_color = rslRst.getString("crit_high_color_code") == null ? "" : rslRst.getString("crit_high_color_code");

					if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
					{
						mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
						listDesc.add(crtcl_high_value_desc);
					}  

					crtcl_low_value_desc = rslRst.getString("crit_low_str_desc") == null ? "" : rslRst.getString("crit_low_str_desc");
					crtcl_low_value_color = rslRst.getString("crit_low_color_code") == null ? "" : rslRst.getString("crit_low_color_code");

					if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
					{
						mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
						listDesc.add(crtcl_low_value_desc);
					}

					deltaValue = rslRst.getString("DELTA_FAIL_STR") == null ? "" : rslRst.getString("DELTA_FAIL_STR");

		
				}
			charting.add(listDesc);
			charting.add(mapDescColor);
		}
		catch(Exception e)
		{
				e.printStackTrace() ;
				throw e ;
				
		}finally 
		{ 
			
			closeResultSet(rslRst) ;
			closeStatement(pstmt_charting) ;
			closeConnection(connection);
		}

		return charting;
}

public ArrayList getChartingDetailsDates(String order_id,String order_line_num) throws Exception 
{
	Connection connection	= null;
	PreparedStatement pstmt_charting_dates = null;
	ResultSet rs_charting_dates			= null;
	ArrayList charting_dates										= new ArrayList() ;
	
	String contr_module_trans_ref="";
	

	if(order_id==null || order_id.equals(" ")) order_id = "";
	if(order_line_num==null || order_line_num.equals(" ")) order_line_num = "";
	contr_module_trans_ref=order_id.trim()+"!"+order_line_num.trim();

		try
		  {
			connection  = getConnection();
			pstmt_charting_dates = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("SQL_OR_DISPLAY_CHARTING_DATES"));
			pstmt_charting_dates.setString(1,(String)contr_module_trans_ref.trim());
			rs_charting_dates	  =pstmt_charting_dates.executeQuery();
			while(rs_charting_dates != null && rs_charting_dates.next())
			{
				String chart_date="";
				chart_date  = checkForNull(rs_charting_dates.getString("dt").trim(),"");
				charting_dates.add(chart_date);
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet(rs_charting_dates) ;
			closeStatement(pstmt_charting_dates) ;
			closeConnection(connection);
		}
		return charting_dates;
		
}
public String getmoduleRL(String catalogcode,String categorycode,String ordertypecode,String facility_id) throws Exception 
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String modname="";
		try
		 {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OHRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1,(String)catalogcode);
			pstmt.setString(2,(String)categorycode);
			pstmt.setString(3,(String)ordertypecode);
			pstmt.setString(4,(String)facility_id);
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				modname = rs.getString("modname");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}finally 
		{ 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return modname;		
	}


}
