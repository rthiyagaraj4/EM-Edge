/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date   Rev.By		Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
15/10/2011	  IN28059		 MenakaV	 						Existing Order>Result Screen Result from HC Lab display 
										 						duplicate in result screen in some case.
19/01/2012    IN029928    	Ramesh     							Order reporting d/t changes for MEDICITY
26/06/2012    IN032816		Chowminya G							Existing order, system was displayed new result but old picture file	
01/10/2012	  IN035413      NijithaS	 						CRF-OR- Bru-HIMS-CRF-263/07- Modified Note not reflected in Existing Orders & Order Tracking
04/10/2012	  IN034931      NijithaS	 						In View audit trial facility code being displayed instead of Description.
21/12/2012	  IN035317      Chowminya G	 						In View audit trial Re - route from performing location not displayed
20/05/2013	  IN037793		Karthi L							To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.
03/07/2013    IN039857		Chowminya G   						Print Button from result view page for LB order
18/12/2013	  IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality
30/01/2014    IN045798		Chowminya    30/01/2014 Chowminya   The Original alignment of the Order format Items are getting changed in the Order format screen  
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
06/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to.   
04/04/2014	IN047528		Karthi L		04/04/2014		Akbar 			 "#" symbols  are printing  instead of number  
07/05/2014	IN048464		Karthi L		07/05/2014		Ramesh			History added for clinical comments		
06/08/2014  IN049419		Ramesh G/Karthi L										An Audit Trail for Additional Information Amendment of Order
12/09/2014  IN051103		Karthi L		12/09/2014		Karthi L		Amended by Details displayed as Null
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.
19/09/2014		IN051105		Karthi L	19/09/2014		Ramesh			Amended Order format details Line level, are not displayed while view
09/10/2014  IN051890		Chowminya										System does not sent print job (data from interface LIS) to report server
16/11/2015		IN057113	Karthi L							 			ML-MMOH-CRF-0335 - IN057113
23/08/2016		IN061345	Ramesh G										Not able to view the lab reports through clinician access.
22/12/2016	IN062669		Vijayakumar K									ML-MMOH-CRF-0728 [IN:062669]
10/05/2017	IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
07/07/2017	IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
07/11/2017	IN064132		Raja S			07/11/2017		Ramesh G		ML-MMOH-CRF-0831
15/01/2018  IN065844        Sharanraj			            Ramesh G        MLL-MMMOH-CRF-1000
07/03/2018	IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
13/03/2018  IN066974		Sharanraj   				    Ramesh G 		OR-ML-MMOH-CRF-1000/03
19/03/2018	IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787 
26/02/2018	IN066119		Raja S			26/02/2018		Ramesh G		ML-MMOH-CRF-1024
07/02/2018	IN066581		Sharanraj		24/04/2018		Raja            PMG2018-TECH-CRF-0001 
28/06/2018	IN065341    	 Prakash C		29/06/2018		Ramesh G		MMS-DM-CRF-0115
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
08/04/2019	IN069968	   Prakash C 	    08/04/2019	    Ramesh G    ML-MMOH-SCF-1191
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
06/09/2019	IN071127		Sivabagyam M	06/09/2019		Ramesh G		Alpha-RL-Unable to attach images for Interval test...
15/01/2021	7632			Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
29/07/2021	20165			Ramesh Goli										ML-MMOH-CRF-1637.1
21/12/2021	25408			Ramesh Goli		21/04/2021		RAMESH G		ML-BRU-CRF-0629.4
24/02/2022	25671			Ramesh G										NMC-JD-CRF-0091.2
16/08/2022	29803			Ramesh G									 	ML-BRU-CRF-0635
--------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import java.util.zip.*;
import java.math.*;//IN064688 added
import eOR.Common.* ;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;


public class ViewOrder extends OrAdapter implements SceduleFreqeuncyInterface, java.io.Serializable {
	HashMap clob_data_hmp  = new HashMap();
	HashMap key_value_map1 = new HashMap();
	HashMap key_value_map2 = new HashMap();
	 ArrayList arrayData = new ArrayList();
	 ArrayList prepsdata=new ArrayList();
	 ArrayList deptData=new ArrayList();
	private HashMap schdMap = null; // Added By Sridhar Reddy SRR20056-CRF-0274
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
	public ViewOrder()//IN061961 starts
	{
		setSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");
		setSiteSpecific("RESULTSPRINTINGINPDF");//7632
		setSiteSpecific("ESIGNATURE_REQUIRED");//25671
		
	}//IN061961 ends
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
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CMTS_COUNT") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				max_action_seq_num = ""+resultSet.getInt("action_seq_num")  ;
			}
		} catch ( Exception e )	{
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
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PRACT_SELECT") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				order_practitioner_name = resultSet.getString("appl_user_name")  ;
			}
		} catch ( Exception e )	{
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
		//ArrayList all_schedule 		= new ArrayList();
		//ArrayList time_schedule 	= new ArrayList();
		ArrayList arr_list	= new ArrayList();
		//int i=1;
		int repeat = 0;
		String uom_code = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_SCHD_DTL") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)order_line_num.trim());
			resultSet = pstmt.executeQuery() ;
	

			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			HashMap currRec =  new 	HashMap();
			while( resultSet.next() ) {
				//HashMap currRec =  new 	HashMap();

				day_list.add(checkForNull(resultSet.getString("order_line_freq_day"),""));
				time_list.add(checkForNull(resultSet.getString("order_line_field_value"),""));
				dose_list.add(checkForNull(resultSet.getString("order_line_dose_qty_value"),""));
				uom_code = (checkForNull(resultSet.getString("order_line_dose_qty_unit"),""));
				day_names.add("");
				repeat++;


	/*			if(!((interval_type.trim()).equalsIgnoreCase("W"))){
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

				}*/
			}



			currRec.put("durationType","");
			currRec.put("start_date_time","");
			currRec.put("repeat",repeat);
			currRec.put("end_date_time","");
			currRec.put("uom_code",uom_code);
			arr_list.add(currRec);
			arr_list.add(day_list);
			arr_list.add(day_names);
			arr_list.add(time_list);
			arr_list.add(dose_list);

			//time_schedule.addAll(all_schedule);



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

		return arr_list;
	}

	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;
	}
	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}


	public String getComments(String order_id, String num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_comment = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CMTS") ) ;

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
				pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt2.setString(1, "RL");
				pstmt2.setString(2, login_facility_id);
				resultSet2 = pstmt2.executeQuery() ;
				if(resultSet2!=null && resultSet2.next() ) {
					lb_install_yn = 	resultSet2.getString("operational_yn")  ;
				}
			}commented on 7/18/2007 for lb_install_yn change by uma*/

			if(order_category.equals("LB")){
				pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			}else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}


			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_CMTS") ) ;
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
				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
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
						pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
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
							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1,language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_install_yn change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled

							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("CN") && (resultSet.getString("order_field_mnemonic").equals("PERFORM_PRACT_ID") || resultSet.getString("order_field_mnemonic").equals("CONULT_MED_ID")) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_AM_PRACTITIONER_PERFORM_TEAM_SURGEON") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}else if(((order_category.trim()).equalsIgnoreCase("OT"))  && (resultSet.getString("order_field_mnemonic").equals("ANAESTHESIA")) )    // For OT ANAESTHESIA
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				/*Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587*/
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
				{
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				/*Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587*/

				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;

				order_format_dtl.add(record);
			}

		} catch ( Exception e )	{

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
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_INSTRUCTIONS_MODE"));
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
				pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt2.setString(1, "RL");
				pstmt2.setString(2, login_facility_id);
				resultSet2 = pstmt2.executeQuery() ;
				if(resultSet2!=null && resultSet2.next() ) {
					lb_install_yn = 	resultSet2.getString("operational_yn")  ;
				}
			}commented on 7/18/2007 for lb_install_yn logic change by uma */
			 if(order_category.equals("LB")){
				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
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
				pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			} else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}
			if(called_from!=null && called_from.equals("RESULT_ENTRY"))
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_CMTS") ) ;
			else
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_CMTS") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)line_id.trim());
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				//String record[] = new String[8]; //Changed index IN045798
				String record[] = new String[9];
				record[0] = resultSet.getString("order_line_field_type")  ;
				record[1] = resultSet.getString("order_line_label_text")  ;
				record[2] = resultSet.getString("order_line_field_value")  ;
				record[3] = resultSet.getString("item_narration")  ;
				record[4] = resultSet.getString("order_line_field_mnemonic")  ;
				record[5] = resultSet.getString("order_line_num")  ;
				record[6] = resultSet.getString("catalog_synonym_dc");
				record[7] = resultSet.getString("discr_msr_uom");
				record[8] = resultSet.getString("accept_option");//IN045798

				//if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )changed on 7/18/2007 for lb_install_yn logic change by uma
				if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
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
						pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
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
									pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn logic change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_instal_yn logic change by uma
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_line_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_line_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("PH") && resultSet.getString("order_line_field_mnemonic").equals("PRES_REMARKS") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PH_PRES_REMARK") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_line_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("ANAESTHESIA")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				/*Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587*/
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
				{
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				/*Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587*/

				order_format_dtl.add(record);
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;

			}
		} catch ( Exception e )	{

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
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_INSTNS"));
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
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_FORMAT_LINE_DETAILS_COUNT"));
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
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_CONDN") ) ;

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

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return result_data;
	}

	public String[] getAbnormalLegend(String abnorm_ind)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String result_data[] = new String[2];
		String legend_type = "S";
		try
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT LEGEND_TYPE FROM CR_CLIN_EVENT_PARAM" ) ;

			resultSet = pstmt.executeQuery() ;

			if(resultSet.next())
			{
				legend_type = resultSet.getString(1) == null ? "S" : resultSet.getString(1);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			result_data[0] = legend_type;

			if(legend_type.equals("S"))
			{
				pstmt = connection.prepareStatement( "SELECT DECODE(?,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') ABNORM_IND FROM CR_CLIN_EVENT_PARAM" ) ;
			}
			else if(legend_type.equals("C"))
			{
				pstmt = connection.prepareStatement( "SELECT DECODE(?,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,LOW_COLOR_CODE,CRIT_STR,CRIT_COLOR_CODE,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR,CRIT_LOW_COLOR_CODE,'') ABNORM_IND FROM CR_CLIN_EVENT_PARAM" ) ;
			}
			
			if (legend_type.equals("S") || legend_type.equals("C"))
			{
				pstmt.setString(1,abnorm_ind);
				resultSet = pstmt.executeQuery() ;

				if(resultSet.next() )
				{
					result_data[1] = resultSet.getString("ABNORM_IND");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}else{			
				result_data[1] ="";
			}
			
		}
		catch ( Exception e )
		{

			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return result_data;
	}


/**

	@return		:	ArrayList
*/
	//IN042552 Start.
	//public ArrayList viewResultDetail(String order_id, String ord_line_num, String cont_order_ind, String patient_id, String ord_cat, String facility_id,String resp_id, String order_status, String pract_reln_id) throws Exception {
	//public ArrayList viewResultDetail(String order_id, String ord_line_num, String cont_order_ind, String patient_id, String ord_cat, String facility_id,String resp_id, String order_status, String pract_reln_id,String clinician_id) throws Exception {//IN042552 End.
	public ArrayList viewResultDetail(String order_id, String ord_line_num, String cont_order_ind, String patient_id, String ord_cat, String facility_id,String resp_id, String order_status, String pract_reln_id,String clinician_id,String event_code,String view_by) throws Exception {//IN061961
	//IN042552 End.
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
		String order_date			= "";
		panels						= new  ArrayList();
	    discrete					= new  ArrayList();
		String ot_install_yn		= "N";
		//String[] record2 = null;
		String[] record1 = null;
		String labchk="";
		boolean isviewLineDtls = isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961


		try {

			if((ord_line_num.equals(" ")|| ord_line_num.equals("")))
				ord_line_num = "";
			if(!ord_line_num.equals("")&& !view_by.equals("L")&& !ord_cat.equals("LB")&& !isviewLineDtls)//IN061961
				ord_line_num=null;//IN061961 
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
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

            pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
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

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
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
			String regHyperLink = "N";//IN068986
			if(ord_cat.equals("LB"))
			{

				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull((String)order_id.trim(),"") );

				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() ) 
				{

						 //record1 = new String[2];// Only One record
						 record1 = new String[3];// IN068986
						record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
						record1[1]=resultSet6.getString( "order_type_code" )  ;
						record1[2]=checkForNull(resultSet6.getString( "STATUS_HIPERLINK_YN" ))  ;//IN068986
						//catalogchk=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
						//IN068986 start
						if(!regHyperLink.equals("Y")){
							if(record1[2].equals("Y"))
								regHyperLink="Y";
						}
						//IN068986 ends
				}
				labchk=checkForNull(getmoduleRL(record1[0],ord_cat,record1[1],login_facility_id),"");
			}
				if(regHyperLink.equals("Y"))//IN068986
					lbrdSearchYN="Y";
			//IN035413 Starts
			String performing_deptloc_code = null;

			if(Constants.ORDER_CATEGORY.equals(ord_cat))
			{
				performing_deptloc_code = getPerformingDeptLocCode(order_id);
			}

			//IN035413 Ends
			//if(((install_yn.equals("Y") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT"))) && (lbrdSearchYN.equals("Y"))){changed on 7/18/2007 for lb_install_yn check logic by uma
			//if((((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT"))) && (lbrdSearchYN.equals("Y")))||(ord_cat.equals("OH")))//IN035413
			if((((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT") && performing_deptloc_code==null)) && (lbrdSearchYN.equals("Y")))||(ord_cat.equals("OH")))//IN035413
			{
				//if (lbrdSearchYN.equals("Y"))
				//{


					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						//IN042552 Start.
						//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_FREQ_EXPL") ) ;
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // commented for IN047528
						//IN042552 End.
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN047528 // Commented for IN064688
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN064688(Result_NUM,NORMAL_LOW,NORMAL_HIGH)//Commented for IN064132
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN064132
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // IN065970 reopen ends  //Commented for IN067037
						//6484 Start.  
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN067037
						//29803 Start.
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); 
						pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt,a.result_status resultStatus FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); 
						//29803 End.
						//6484 End.
					}else{
						//IN042552 Start.
						//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS") ) ;
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");// commented for IN047528
						//IN042552 End.
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN047528 // Commented for IN064688
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN064688(Result_NUM,NORMAL_LOW,NORMAL_HIGH) //Commented for IN064132
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN064132
						//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); //IN065970 reopen ends// //Commented for IN067037
						// pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN067037
						if(view_by.equals("L")&& ord_cat.equals("LB")&&isviewLineDtls){//	IN061961 starts
							//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and a.event_code = ? and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // COMMENTED FOR  IN061961
						  	//6484 Start.	
								//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and decode(ORDER_CATALOG_NATURE,'P',a.event_group,'A',a.event_code) = ? and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN061961
								//29803 Stat.
								//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and decode(ORDER_CATALOG_NATURE,'P',a.event_group,'A',a.event_code) = ? and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN061961
								pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt,a.result_status resultStatus FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and decode(ORDER_CATALOG_NATURE,'P',a.event_group,'A',a.event_code) = ? and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc"); // modified for IN061961
								//29803 End.
							//6484 End.
						}else{
							//6484 Start.
							//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");
							//29803 Stat.
							//pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");
							pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id,a.facility_id, 0 uploaded_doc_cnt,a.result_status resultStatus FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");
							//29803 End.
							//6484 end.
						}	
					}
					 if(view_by.equals("L")&& ord_cat.equals("LB")&&isviewLineDtls){
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, event_code);//IN061961
						pstmt.setString(3, patient_id);
						pstmt.setString(4, resp_id);
						pstmt.setString(5, pract_reln_id);
						pstmt.setString(6, language_id);
						pstmt.setString(7, language_id);
					 }else{
							pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, patient_id);
						pstmt.setString(3, resp_id);
						pstmt.setString(4, pract_reln_id);
						pstmt.setString(5, language_id);
						pstmt.setString(6, language_id);
					 }
							//	IN061961 ends

				/*} else {
					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){

						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PARENT_CHILD_RSLT_DTLS") ) ;
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, ord_line_num);
						pstmt.setString(3, patient_id);
						pstmt.setString(4, resp_id);
						pstmt.setString(5, resp_id);
					}else{
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_WITHOUT_LB") ) ;
						pstmt.setString(1, (String)order_id.trim());
						pstmt.setString(2, ord_line_num);
						pstmt.setString(3, patient_id);
						pstmt.setString(4, resp_id);
						pstmt.setString(5, resp_id);
					}
				}*/

			}else{

				if(!ord_cat.equals("LB"))//IN061961
					ord_line_num=null;//IN061961
				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){

					//IN042552 Start
					//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PARENT_CHILD_RSLT_DTLS") ) ;
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); // commented for IN047528
					//IN042552 End.
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); // modified for IN047528 // Commented for IN064688
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); // modified for IN064688(Result_NUM,NORMAL_LOW,NORMAL_HIGH)//Commented for IN064132
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); // modified for IN064132 
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); // IN065970 reopen ends //commented for IN067037
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); //modified for IN067037//IN070610
					//6484 Start.
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); //modified for IN067037//IN070610					
					//29803 Stat.
					//pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); //modified for IN067037//IN070610					
					pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt,a.result_status resultStatus FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc"); //modified for IN067037//IN070610					
					//29803 End.
					//6484 end.
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, (String)order_id.trim());
					pstmt.setString(3, ord_line_num);
					pstmt.setString(4, patient_id);
					pstmt.setString(5, resp_id);
					pstmt.setString(6, pract_reln_id);
					pstmt.setString(7, language_id);
					pstmt.setString(8, language_id);
				}
				else
				{

					//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_WITHOUT_LB") ) ;// Modified by Menaka for issue IN28059
					//IN042552 Start.
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ? order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	//Modified by Menaka for issue IN28059				
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;		//Ramesh // commented for IN047528			
					//IN042552 End.
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	// modified for IN047528 // Commented for IN064688	 		
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	// modified for IN064688(Result_NUM,NORMAL_LOW,NORMAL_HIGH)//Commented for IN064132
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	// modified for IN064132
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, NORMAL_LOW, NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	// IN065970 reopen ends//Commented for IN067037
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn,a.facility_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	//modified for IN067037//IN070610
					//6484 Start.
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	//modified for IN067037//IN070610
					//29803 Stat.
					//pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	//modified for IN067037//IN070610
					pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix,  DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn, d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status,DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID) resulted_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn,a.facility_id,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM) uploaded_doc_cnt,a.result_status resultStatus FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='Y'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	//modified for IN067037//IN070610
					//29803 Stat.
					//6484 End.
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, ord_line_num);
					pstmt.setString(3, patient_id);
					pstmt.setString(4, resp_id);
					pstmt.setString(5, pract_reln_id);
					pstmt.setString(6, language_id);
					pstmt.setString(7, language_id);
				}
			}

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {

                String record[];
               // if(((install_yn.equals("Y") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (lbrdSearchYN.equals("Y"))){changed on 7/18/2007 for lb_instal_yn logic change by uma
                if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (lbrdSearchYN.equals("Y"))){

                   // record = new String[26];
					//record = new String[33]; [IN035639]
					//record = new String[34]; // commented for  Bru-HIMS-CRF-052.1 [IN037793]
					//record = new String[35]; //  modified for  Bru-HIMS-CRF-052.1 [IN037793]// Commented for IN064132
                			//record = new String[36];//Added for IN064132
					//record = new String[37];//IN065970 reopen//IN071127
					//record = new String[38];//IN065970 reopen//IN071127
					record = new String[39];//29803
                }else{ //record = new String[25];

					//record = new String[32];//modified for CAimage //[IN035639]
					//record = new String[33];  // Commented for IN064132
					//record = new String[34]; //Added for IN064132
					//record = new String[35]; //IN065970 reopen//IN070610
                	//record = new String[36];//IN070610
					record = new String[37];//29803
				}
				String result_data = "";


				record[0] = resultSet.getString("report_srl_no")  ;
				record[1] = resultSet.getString("discr_msr_panel_id") +"`~"+ resultSet.getString("report_srl_no") ;

				if(record[1] != null){
					if(!currPanel.trim().equalsIgnoreCase(record[1])) {
						panels.add(record[1]);
						 currPanel = record[1] ;
					}
				}



				record[2] = resultSet.getString("discr_msr_id") +"`~"+ resultSet.getString("report_srl_no") ;

				if(!currDiscrete.trim().equalsIgnoreCase(record[2])) {
					discrete.add(record[2]);
					 currDiscrete = record[2] ;
				}

				record[3] = resultSet.getString("srl_no")  ;
				record[4] = resultSet.getString("result_type")  ;
				//IN064688 Changes Starts
				//record[5] = resultSet.getString("result_num")  ;
				BigDecimal rn =resultSet.getBigDecimal("result_num");
				if(rn!=null)
					record[5]=rn.toString();
				else
					record[5]="";
				//IN064688 Changes Ends
				record[6] = resultSet.getString("result_num_uom")  ;
				record[7] = resultSet.getString("result_str")  ;
				result_data = "";
				
				//6484 Start.
				if("Y".equals(resultSet.getString("compress_hist_data_yn")==null?"N":(String)resultSet.getString("compress_hist_data_yn"))){
					StringBuffer compresshistData = new StringBuffer();
					java.sql.Blob hist_data_blob =  (java.sql.Blob)resultSet.getBlob("compress_hist_data");
					if(hist_data_blob!=null && hist_data_blob.length()>0){
						InputStream ins1 = hist_data_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {							
									compresshistData.append(line+"\n");
								}
							}					
						}
						result_data = compresshistData.toString();
					}
				}else{
					Clob rslt_data = resultSet.getClob("result_data");
					if(rslt_data!=null && rslt_data.length() > 0)
						result_data = rslt_data.getSubString(1,( (int)rslt_data.length() ));
					
				}				
				result_data += ((resultSet.getString("comments")==null?"":(String)resultSet.getString("comments")));
				//6484 end.
				
			    arrayData.add(result_data);
				string_check.append(result_data);				
				record[8] = result_data ;
				
				order_date = resultSet.getString("reporting_date")  ;
				//---[IN029928]/Start---
				/*
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
				*/
					record[9] = order_date;
				//---[IN029928]/End-----

				record[10] = resultSet.getString("result_status")  ;
				//IN064688 Changes Starts
				//record[11] = resultSet.getString("normal_low")  ;
				//record[12] = resultSet.getString("normal_high")  ;
				BigDecimal nl =resultSet.getBigDecimal("normal_low");
				if(nl!=null)
					record[11]=nl.toString();
				else
					record[11]="";
				BigDecimal nh =resultSet.getBigDecimal("normal_high");
				if(nh!=null)
					record[12]=nh.toString();
				else
					record[12]="";
				//IN064688 Changes Ends
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
	                record[30] = resultSet.getString("result_num_prefix")  ;
	                record[31] = resultSet.getString("status")  ;
					record[32] = resultSet.getString("normalcy_str")  ;
					record[33] = resultSet.getString("num_data_yn")  ; //[IN035639]
					record[34] = resultSet.getString("ext_image_upld_id")  ; // Bru-HIMS-CRF-052.1 [IN037793]
					record[35] = resultSet.getString("resulted_practitioner")  ; //Added for IN064132
					record[36] = resultSet.getString("facility_id")  ; //Added for IN065970 reopen
					record[37] = resultSet.getString("discr_msr_id")  ; //IN071127	
					record[38] = resultSet.getString("resultStatus")  ; //29803			
                } else {

	                record[22] = resultSet.getString("ext_image_obj_id")  ;
	                record[23] = resultSet.getString("ext_image_appl_id")  ;
	                record[24] = resultSet.getString("reporting_practitioner")  ;
	                record[25] = resultSet.getString("hist_rec_type")  ;
	                record[26] = resultSet.getString("contr_sys_id")  ;
	                record[27] = resultSet.getString("accession_num")  ;
	                record[28] = resultSet.getString("contr_sys_event_code")  ;
	                record[29] = resultSet.getString("result_num_prefix")  ;
	                record[30] = resultSet.getString("status")  ;
					record[31] = resultSet.getString("normalcy_str")  ;
					record[32] = resultSet.getString("num_data_yn")  ; //[IN035639]
					record[33] = resultSet.getString("resulted_practitioner")  ; //Added for IN064132
					record[34] = resultSet.getString("facility_id")  ; //Added for IN065970 reopen
					record[35] = resultSet.getString("uploaded_doc_cnt");//IN070610
					record[36] = resultSet.getString("resultStatus")  ; //29803
				}


				order_format_dtl.add(record);
				count++;
			}
		} catch ( Exception e )	{

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

	public TreeMap traverseList(int key, ArrayList raw_list, TreeMap refined_map)
	{

		TreeMap sorted_panel_map 	= new TreeMap();


		String[]raw_array 			= null;
		chk = "";
		if(key == 1)
		{//search for panel_id
			for(int i=0; i<raw_list.size(); i++)
			{
				raw_array = (String[])raw_list.get(i);
				sorted_panel_map.put(raw_array[key], "");
				key_value_map1.put(raw_array[key], raw_array[18]);

			}
			setKeyValueData1(key_value_map1);
			return sorted_panel_map;
		}

		if(key == 2)
		{//search for descr_msr_id
			Set tmp_set = (Set)refined_map.keySet();

			Iterator itr = (Iterator)tmp_set.iterator() ;
			String panel_key = "";
			//int cnt = 0;
			while(itr.hasNext())
			{
				sorted_panel_map = new TreeMap();
				panel_key = (String)itr.next();
				for(int i=0; i<raw_list.size(); i++)
				{
					raw_array = (String[])raw_list.get(i);

					if(raw_array[1].equals(panel_key) )
					{
						sorted_panel_map.put(raw_array[key], "");
					}
					key_value_map2.put(raw_array[key], raw_array[19]);

				}
				refined_map.put(panel_key, sorted_panel_map);
				setKeyValueData2(key_value_map2);
			}
			return refined_map;
		}


		if(key == 9)
		{//search for date time
			Set tmp_set = (Set)refined_map.keySet();

			Iterator itr = (Iterator)tmp_set.iterator() ;
			//chk += ">> "+itr.toString();
				chk =chk+">> "+itr.toString();
			TreeMap dscr_msr_panel = null;
			String dcsr_msr_val = "";
			String dscr_msr_panel_key = "";

			while(itr.hasNext())
			{
				dscr_msr_panel_key 	= (String)itr.next();
				dscr_msr_panel	   	= (TreeMap)refined_map.get(dscr_msr_panel_key);

				Set tmp_dscr_set 	= (Set)dscr_msr_panel.keySet();

				Iterator tmp_dscr_itr = (Iterator)tmp_dscr_set.iterator() ;
				while(tmp_dscr_itr.hasNext())
				{
					dcsr_msr_val = (String)tmp_dscr_itr.next();
					//chk += ">>> "+dcsr_msr_val;
						chk =chk+">>> "+dcsr_msr_val;
					sorted_panel_map = new TreeMap();
					for(int i=0; i<raw_list.size(); i++)
					{
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
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_AUDIT_TRIAL1"));
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
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_AUDIT_TRIAL2"));
				pstmt.setString(1, (checkForNull(order_id,"")).trim());

				resultSet	= pstmt.executeQuery() ;

				if ( resultSet != null )
				{
					while(resultSet.next())
					{

                        String[] record	= new String[4];
						record[0] = resultSet.getString("specimen_collect_date_time")  ;

						record[1] = resultSet.getString("specimen_collected_by")  ;

						/*record[2] = resultSet.getString("register_date_time");

						record[3] = resultSet.getString("register_pract_id");
						*/
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

	public String getAuditPractionerDesc(String pract_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  pract_name	= "";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_PRACT_DTLS"));
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

		String order_data[] = new String[8];//IN039857
		try{
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_DTLS") ) ;
			pstmt = connection.prepareStatement("select order_id,order_type_code,patient_class,priority,source_type,source_code,order_status,OR_GET_DESC.OR_ORDER_TYPE(order_type_code,?,'2')ord_typ_desc from or_order where order_id = ?") ;//IN039857
			pstmt.setString(1, language_id);
			pstmt.setString(2, order_id.trim());

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {
				order_data[0] = resultSet.getString("order_type_code");
				order_data[1] = resultSet.getString("patient_class");
				order_data[2] = resultSet.getString("priority");
				order_data[3] = resultSet.getString("order_id");
				order_data[4] = resultSet.getString("source_type");
				order_data[5] = resultSet.getString("source_code");
				order_data[6] = resultSet.getString("order_status");
				order_data[7] = resultSet.getString("ord_typ_desc");//IN039857
			}
		}catch ( Exception e )	{

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
			//25408 Start.
			setSiteSpecificYN("PERFORMED_HYPERLINK");
			if(isSiteSpecific("PERFORMED_HYPERLINK"))
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_LB_RD_SEARCH_MOHBR_YN"));
			else
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_LB_RD_SEARCH_YN"));
			//25408 End.
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

			e.printStackTrace() ;
			throw e ;
		}finally{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return C_ORDER_ID;
	}

	//IN065844 starts 
public String orgordid(String order_id) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	PreparedStatement pstmt1 	= null;
	ResultSet resultSet1 		= null;
	String orgid="N";
	int count=0;
	//String amendReason="";//CheckStyle
	try
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement("SELECT ORG_ORDER_ID FROM OR_ORDER_LINE WHERE ORDER_ID=?") ;
		pstmt.setString(1, order_id);
		resultSet = pstmt.executeQuery() ;
		if( resultSet.next() )
		{
			orgid=resultSet.getString("ORG_ORDER_ID")==null?"N":resultSet.getString("ORG_ORDER_ID");
		}
		if(!orgid.equals("N"))
		{	
			pstmt1 = connection.prepareStatement("select count(*) reasonCount from or_order_amend_reason where order_id =?") ;
			pstmt1.setString(1, orgid);
			resultSet1 = pstmt1.executeQuery() ;
			if( resultSet1.next() )
			{
				count=resultSet1.getInt("reasonCount");
			}
			if(count>0)
			{
				orgid="Y";
			}
			//IN066974 STARTS
			else
			{
				orgid="N";
			}
			//IN066974 ENDS
		}
	}
	catch( Exception e)
	{
		e.printStackTrace() ;
		throw e ;
	}
	finally
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection) ;
	}
	return orgid;
}
public String checkAmendOrder(String orderId) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String orgid="N";
	try
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement("select distinct order_id from OR_ORDER_AMEND_REASON where order_id=?") ;
		pstmt.setString(1, orderId);
		resultSet = pstmt.executeQuery() ;
		if( resultSet.next() )
		{
			orgid=resultSet.getString("order_id")==null?"N":resultSet.getString("order_id");
		}
	}
	catch( Exception e)
	{
		e.printStackTrace() ;
		throw e ;
	}
	finally
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection) ;
	}
	return orgid;
}
	
public ArrayList getAmendReason(String orderId) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt1 	= null;
	ResultSet resultSet 		= null;
	ResultSet resultSet1 		= null;

	ArrayList amend=new ArrayList();
	ArrayList reason=new ArrayList();
	ArrayList date1=new ArrayList();
	ArrayList ordid=new ArrayList();
	String orig_Ids="";
	try
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement("SELECT OR_GET_ORDER_IDS ( ?) DD FROM DUAL") ;
		pstmt.setString(1, orderId);
		resultSet = pstmt.executeQuery() ;
		if(resultSet.next())
		{
		   orig_Ids=resultSet.getString("DD");
		}
		orig_Ids="("+orig_Ids+")";
		pstmt1 = connection.prepareStatement("select order_id,order_amend_reason,to_char(added_date,'dd/mm/yyyy hh24:mi')added_date from or_order_amend_reason where order_id in "+orig_Ids.toString()+" order by order_id desc") ;
		resultSet1 = pstmt1.executeQuery() ;
		while(resultSet1.next() )
		{
			ordid.add(resultSet1.getString("order_id"));
			
			reason.add(resultSet1.getString("order_amend_reason")==null?"":resultSet1.getString("order_amend_reason"));
			date1.add(resultSet1.getString("added_date")==null?"":resultSet1.getString("added_date"));
		}
		amend.add(reason);
		amend.add(date1);
		amend.add(ordid);
	}
	catch( Exception e)
	{
		e.printStackTrace() ;
		throw e ;
	}
	finally
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection) ;
	}
	return amend;
}
	//IN065844 ends
	
public String getFacilityName() throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String facility_name = "";
	try
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PARAM_FOR_FACILITY_VIEW_ORDER") ) ;
		pstmt.setString(1, language_id);
		pstmt.setString(2, login_facility_id);
		resultSet = pstmt.executeQuery() ;

		while( resultSet != null && resultSet.next() )
		{
			facility_name = resultSet.getString("facility_name");
		}
	} 
	catch ( Exception e )
	{
		e.printStackTrace() ;
		throw e ;
	}
	finally 
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection) ;
	}
	return facility_name;
}
public String getPractitionerName(String practitioner_id) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String practitioner_name = "";
	try
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_PRACT") ) ;
		pstmt.setString(1,language_id);
		pstmt.setString(2, practitioner_id);
		resultSet = pstmt.executeQuery() ;
		while( resultSet != null && resultSet.next() )
		{
			practitioner_name = resultSet.getString("practitioner_name");
		}
	}
	catch ( Exception e )
	{
		e.printStackTrace() ;
		throw e ;
	} 
	finally
	{
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

				pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_TRANSFER_APPT_DETAILS"));
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
				pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_SET_ORDER_ID_SELECT"));
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

	//public ArrayList getOrderCatalogDetails(String order_id) throws Exception {
	//public ArrayList getOrderCatalogDetails(String order_id,String RepDb) throws Exception {
	//public ArrayList getOrderCatalogDetails(String order_id,String RepDb,String order_catalog_code,String view_by) throws Exception {//	IN061961
		public ArrayList getOrderCatalogDetails(String order_id,String RepDb,String order_catalog_code,String view_by,String ord_cat) throws Exception {//	IN061961
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCatalog		= new ArrayList();
		if(RepDb.equals(" ") || RepDb.equals("null")) RepDb = "";//IN065341
		String sql="";
		boolean isviewLineDtls = isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
		try{
			if(view_by.equals("L")&&isviewLineDtls&&ord_cat.equals("LB")){//IN061961starts
                connection	= getConnection();
				pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_CATALOGS_LINE"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, (checkForNull(order_id,"")).trim());
				pstmt.setString(3, (checkForNull(order_catalog_code,"")).trim());//IN061961ends
			}else{
                connection	= getConnection();
		//IN065341 starts		
			//pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_CATALOGS"));
				sql="SELECT order_catalog_code, or_get_desc.or_order_catalog##REPDB##(order_catalog_code,?,'2') catalog_synonym_dc, order_line_num FROM or_order_line ##REPDB## WHERE order_id = ? order by order_line_num";
				sql=sql.replaceAll("##REPDB##", RepDb);
				pstmt		= connection.prepareStatement(sql);
		//IN065341 ends
				pstmt.setString(1, language_id);
				pstmt.setString(2, (checkForNull(order_id,"")).trim());
			}//IN061961ends
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

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return OrderCatalog;
	}

	//public ArrayList getOrderHistoryDetails(String order_id, String order_line_num) throws Exception {
	public ArrayList getOrderHistoryDetails(String order_id, String order_line_num,String RepDb) throws Exception {	
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCatalog		= new ArrayList();
		if(RepDb.equals(" ") || RepDb.equals("null")) RepDb = "";//IN065341
		try{
                connection	= getConnection();
                /* IN066581 Starts */                
                boolean site=false;
    			site = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_ORDER_ACTION");
    			String reptDb="";
    			if(site)
    			{
    				 reptDb=ReportDbDet(getLoginFacilityId());
    			}
        		String sqlqry=OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ORDER_DTLS");
        	//IN065341 starts
				if(site)
					sqlqry=sqlqry.replace("$$REPDB##", reptDb);
				else
					sqlqry=sqlqry.replace("$$REPDB##", RepDb);
        	//IN065341 ends				
                	pstmt		= connection.prepareStatement(sqlqry);
                /* IN066581 ends */   
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

		//IN065341 starts
		//public ArrayList getViewDetails(String order_id, String order_line_num, String field_mnemonic) throws Exception {
	//	public ArrayList getViewDetails(String order_id, String order_line_num, String field_mnemonic,String RepDb) throws Exception {//IN065341 ends
		public ArrayList getViewDetails(String order_id, String order_line_num, String field_mnemonic,String RepDb, String view_by,String ord_cat) throws Exception {//IN061961	
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Details			= new ArrayList();
		if(RepDb.equals("") || RepDb.equals("null")) RepDb = "";//IN065341
		String sql="";//IN065341
		boolean isviewLineDtls = isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
		try{
            	if(!order_line_num.equals(" ")&& view_by.equals("L")&& !ord_cat.equals("LB")&& field_mnemonic.equals("") && isviewLineDtls||!isviewLineDtls)//IN061961
			    	order_line_num=null;//IN061961
                connection	= getConnection();

				if(checkForNull(order_line_num,"").equals("")) {
			//IN065341 starts		
				//sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM)  Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,NVL(am_get_desc.am_practitioner ##REPDB##(action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1))  appl_user_name FROM or_order_action_vw ##REPDB## WHERE order_id = ? ORDER BY ORDER_LINE_NUM, action_seq_num , action_date_time";//IN64543
				//20165 Start.
				//sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM)  Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,NVL(am_get_desc.am_practitioner ##REPDB##(action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1))  appl_user_name, nvl((SELECT INSTRUCTION_TYPE FROM or_order_line WHERE order_id = or_order_action_vw.order_id AND order_line_num = or_order_action_vw.order_line_num),'T')INSTRUCTION_TYPE,ORDER_LINE_NUM FROM or_order_action_vw ##REPDB## WHERE order_id = ? ORDER BY ORDER_LINE_NUM, action_seq_num , action_date_time";//IN64543
				sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM)  Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,DECODE(action_user_id,'PATIENT_TRANSFER','AUTO RE ROUTE DUE TO PATIENT TRANSFER',NVL(am_get_desc.am_practitioner ##REPDB##(action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1)))  appl_user_name, nvl((SELECT INSTRUCTION_TYPE FROM or_order_line WHERE order_id = or_order_action_vw.order_id AND order_line_num = or_order_action_vw.order_line_num),'T')INSTRUCTION_TYPE,ORDER_LINE_NUM FROM or_order_action_vw ##REPDB## WHERE order_id = ? ORDER BY ORDER_LINE_NUM, action_seq_num , action_date_time";//IN64543
				//20165 End.
				sql=sql.replaceAll("##REPDB##", RepDb);
				pstmt		= connection.prepareStatement(sql);
				//pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ACTION_DTLS"));
			//IN065341 ends	
					pstmt.setString(1,language_id);
					pstmt.setString(2,language_id);
					pstmt.setString(3,language_id);
					pstmt.setString(4, (checkForNull(order_id,"")).trim());
					//pstmt.setString(4, (checkForNull(order_catalog_code,"")).trim());
					//System.out.println("value"+pstmt);
					
				} else  { // With order_line_num this query
				//IN065341 starts
					//pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ORDER_LINE_ACTION_DTLS"));
					//sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM) Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,NVL(am_get_desc.am_practitioner##REPDB## (action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1))  appl_user_name FROM or_order_action_vw ##REPDB## WHERE order_id = ? AND order_line_num =  ? AND field_mnemonic = nvl(?, field_mnemonic) ORDER BY action_seq_num, action_date_time";//IN64543
					//20165 Start.
					//sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM) Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,NVL(am_get_desc.am_practitioner##REPDB## (action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1))  appl_user_name, nvl((SELECT INSTRUCTION_TYPE FROM or_order_line WHERE order_id = or_order_action_vw.order_id AND order_line_num = or_order_action_vw.order_line_num),'T')INSTRUCTION_TYPE,ORDER_LINE_NUM FROM or_order_action_vw ##REPDB## WHERE order_id = ? AND order_line_num =  ? AND field_mnemonic = nvl(?, field_mnemonic) ORDER BY action_seq_num, action_date_time";//IN64543
					sql="SELECT (select or_get_desc.OR_ORDER_CATALOG##REPDB##(order_catalog_code,?,2) from or_order_line ##REPDB## where order_id=or_order_action_vw.order_id and order_line_num=or_order_action_vw.ORDER_LINE_NUM) Order_catalog_desc, nvl(field_mnemonic,'') field_legends ,action_seq_num, action_user_id, to_char(action_date_time,'dd/mm/yyyy hh24:mi') action_date_time, action_facility_id, field_mnemonic, field_value_old, field_value_new, field_value_txt, order_status_old, order_status_new, freq_old_desc, freq_new_desc, durn_old_desc, durn_new_desc, uom_old_desc, uom_new_desc, perform_old_desc, perform_new_desc,order_catalog_new_desc,order_catalog_old_desc,facility_old_desc,facility_new_desc,DECODE(action_user_id,'PATIENT_TRANSFER','AUTO RE ROUTE DUE TO PATIENT TRANSFER',NVL(am_get_desc.am_practitioner##REPDB## (action_user_id,?,1),sm_get_desc.sm_appl_user##REPDB## (action_user_id,?,1)))  appl_user_name, nvl((SELECT INSTRUCTION_TYPE FROM or_order_line WHERE order_id = or_order_action_vw.order_id AND order_line_num = or_order_action_vw.order_line_num),'T')INSTRUCTION_TYPE,ORDER_LINE_NUM FROM or_order_action_vw ##REPDB## WHERE order_id = ? AND order_line_num =  ? AND field_mnemonic = nvl(?, field_mnemonic) ORDER BY action_seq_num, action_date_time";
					//20165 Start.
					sql=sql.replaceAll("##REPDB##", RepDb);
					pstmt		= connection.prepareStatement(sql);
				//IN065341 ends	
					pstmt.setString(1,language_id);
					pstmt.setString(2,language_id);
					pstmt.setString(3,language_id);
					pstmt.setString(4, (checkForNull(order_id,"")).trim());
					pstmt.setString(5, (checkForNull(order_line_num,"")).trim());
					pstmt.setString(6, (checkForNull(field_mnemonic,"")).trim());
				}

  				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
                        //String[] record	= new String[25];//IN64543
						String[] record	= new String[27];//IN64543
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
						record[25] = checkForNull(resultSet.getString("instruction_type"));//IN64543
						record[26] = checkForNull(resultSet.getString("order_line_num"));//IN64543
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
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_USER_SELECT") ) ;

			pstmt.setString(1, user_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				appl_user_name = resultSet.getString("appl_user_name");
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return appl_user_name;
	}

	public String getDescription(String field_mnemonic , String field_code) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String	 field_value		= "";
 		try 
		{
			 connection = getConnection() ;
			 if(field_mnemonic.equals("ROUTE_CODE")) 
			 {
				  pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_ROUTE_SELECT") ) ;
			 } 
			 else if(field_mnemonic.equals("PERFORM_DEPTLOC_CODE")) 
			 {
				  pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_PH_PERFORMING_LOCN_SELECT") ) ;
			 }
			 if(field_mnemonic.equals("ROUTE_CODE")) 
			 {
				pstmt.setString(1, field_code);
				pstmt.setString(2, language_id);
			 }
			 else if(field_mnemonic.equals("PERFORM_DEPTLOC_CODE")) 
			 {
				pstmt.setString(1, field_code);
			 }
			 resultSet = pstmt.executeQuery() ;

			 while( resultSet != null && resultSet.next() ) 
			 {
				field_value		= resultSet.getString("short_desc");
			 }
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return field_value;
	}

	public String getImageRefYn(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String	 image_ref_yn		= "N";
 		try {
				 connection = getConnection() ;
				  pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_REF_YN") ) ;

 				 pstmt.setString(1, order_id);
				 pstmt.setString(2, "1"); // order_line_num
 				 resultSet = pstmt.executeQuery() ;
				 while( resultSet != null && resultSet.next() ) {
 					image_ref_yn		= resultSet.getString("image_ref_yn");
				}
				if(image_ref_yn==null) image_ref_yn = "N";
 			} catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return image_ref_yn;
	}
	//IN065341 starts
		//public ArrayList<String> getRemarks(String order_id, String action_seq_num) throws Exception
	public ArrayList<String> getRemarks(String order_id, String action_seq_num,String RepDb) throws Exception
	//IN065341 ends
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList<String> remarks			    = new ArrayList<String>();
		if(RepDb.equals("") || RepDb.equals("null")) RepDb = "";//IN065341
		try
		{
			connection = getConnection() ;
			/*IN066581 starts*/
			boolean site=false;
			site = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_ORDER_ACTION");
			String reptDb="";
			if(site)
			{	
				reptDb=ReportDbDet(getLoginFacilityId());
			}
			String sqlqry=OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_REMARKS_SELECT");
	//IN065341 starts
			if(site)
				sqlqry=sqlqry.replace("$$REPDB##", reptDb);
			else
				sqlqry=sqlqry.replace("$$REPDB##", RepDb);
	//IN065341 ends
            		pstmt		= connection.prepareStatement(sqlqry);
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_HISTORY_REMARKS_SELECT") ) ; 
			/*IN066581 ends*/
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, order_id);
			pstmt.setString(4, action_seq_num);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				remarks.add(resultSet.getString("action_user_name")==null?"":resultSet.getString("action_user_name"));
				remarks.add(resultSet.getString("field_value_txt")==null?"":resultSet.getString("field_value_txt"));
			}
		}
		catch ( Exception e )
		{

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
				if(view_details[5]!=null && !view_details[5].equals("")) //IN035317 Check was incorrect 
					old_value	= getDescription(view_details[4], view_details[5]);
 				if(view_details[6]!=null && !view_details[6].equals("")) //IN035317
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
		//else if(view_details!=null && view_details[4].equals("PERFORMING_FACILITY_ID"))//IN034931
		else if(view_details!=null && view_details[4].equals("PERFORM_FACILITY_ID"))
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
			else if(view_details[6]!=null  && (view_details[6].equals("3") || view_details[6].equals("4")))
				new_value	= "IV Piggy Back";
			else if(view_details[6]!=null && view_details[6].equals("5"))
				new_value	= "IV Without Additive";
  		}
		else if(view_details!=null && view_details[4].equals("ROUTE_CODE"))
		{  // check the field mnemonic if(ROUTE_CODE)
			if(view_details[5]!=null && !view_details[5].equals(""))
				old_value	= getDescription(view_details[4], view_details[5]);
 			if(view_details[6]!=null && !view_details[6].equals(""))
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
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_ORDER_ID"));
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
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_LINE_NUM"));
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
				pstmt_charting = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_DISPLAY_CHARTING"));
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
	String legend_type = "";
	ArrayList charting										= new ArrayList() ;
	ArrayList listDesc							=new ArrayList();
	HashMap mapDescColor							=new HashMap();


	try
		  {
				connection  = getConnection();
				pstmt_charting = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COLOR"));
				pstmt_charting.setString(1,(String)getLanguageId());  // MOHE-CRF-0038.3
				rslRst	  =pstmt_charting.executeQuery();
				while(rslRst != null && rslRst.next())
				{
					legend_type = rslRst.getString("LEGEND_TYPE") == null ? "" : rslRst.getString("LEGEND_TYPE");

					high_value_desc = rslRst.getString("high_str_desc") == null ? "" : rslRst.getString("high_str_desc");
					if(legend_type.equals("S"))
						high_value_color = rslRst.getString("HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("HIGH_SYMBOL_ICON");
					else
						high_value_color = rslRst.getString("high_color_code") == null ? "" : rslRst.getString("high_color_code");

					mapDescColor.put(high_value_desc,high_value_color);
					listDesc.add(high_value_desc);

					low_value_desc = rslRst.getString("low_str_desc") == null ? "" : rslRst.getString("low_str_desc");
					if(legend_type.equals("S"))
						low_value_color = rslRst.getString("LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("LOW_SYMBOL_ICON");
					else
						low_value_color = rslRst.getString("low_color_code") == null ? "" : rslRst.getString("low_color_code");

					if(!(mapDescColor.containsKey(low_value_desc)))
					{
						mapDescColor.put(low_value_desc,low_value_color);
						listDesc.add(low_value_desc);
					}

					abnml_value_desc = rslRst.getString("abn_str_desc") == null ? "" : rslRst.getString("abn_str_desc");
					if(legend_type.equals("S"))
						abnml_value_color = rslRst.getString("ABN_SYMBOL_ICON") == null ? "" : rslRst.getString("ABN_SYMBOL_ICON");
					else
						abnml_value_color = rslRst.getString("abn_color_code") == null ? "" : rslRst.getString("abn_color_code");

					if(!(mapDescColor.containsKey(abnml_value_desc)))
					{
						mapDescColor.put(abnml_value_desc,abnml_value_color);
						listDesc.add(abnml_value_desc);
					}

					crtcl_value_desc = rslRst.getString("crit_str_desc") == null ? "" : rslRst.getString("crit_str_desc");
					if(legend_type.equals("S"))
						crtcl_value_color = rslRst.getString("CRIT_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_SYMBOL_ICON");
					else
						crtcl_value_color = rslRst.getString("crit_color_code") == null ? "" : rslRst.getString("crit_color_code");

					if(!(mapDescColor.containsKey(crtcl_value_desc)))
					{
						mapDescColor.put(crtcl_value_desc,crtcl_value_color);
						listDesc.add(crtcl_value_desc);
					}

					crtcl_high_value_desc = rslRst.getString("crit_high_str_desc") == null ? "" : rslRst.getString("crit_high_str_desc");
					if(legend_type.equals("S"))
						crtcl_high_value_color = rslRst.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_HIGH_SYMBOL_ICON");
					else
						crtcl_high_value_color = rslRst.getString("crit_high_color_code") == null ? "" : rslRst.getString("crit_high_color_code");

					if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
					{
						mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
						listDesc.add(crtcl_high_value_desc);
					}

					crtcl_low_value_desc = rslRst.getString("crit_low_str_desc") == null ? "" : rslRst.getString("crit_low_str_desc");
					if(legend_type.equals("S"))
						crtcl_low_value_color = rslRst.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_LOW_SYMBOL_ICON");
					else
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
			charting.add(legend_type);
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
			pstmt_charting_dates = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_DISPLAY_CHARTING_DATES"));
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

/*******Added by Deepa on 11/4/2009 at 2:31 PM for IN011473****************/

	public ArrayList getRepPractCnt(String order_id,String ord_line_num, String patient_id, String resp_id, String facility_id, String ord_cat, String order_status, String cont_order_ind) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet6 			= null;
		ResultSet resultSet7 			= null;
		ArrayList repPractCnt = new ArrayList();
		String ot_install_yn		= "N";
		String[] record1 = null;
		String labchk = "";
		String repPract = "";

		try 
		{
			if(ord_line_num.equals(" ")|| ord_line_num.equals(""))
				ord_line_num = "";

			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, "RL");
			resultSet = pstmt.executeQuery() ;

			String install_yn = "";
			if(resultSet.next() ) 
			{
				install_yn = 	resultSet.getString("install_yn")  ;
			}
			if(install_yn == null)	install_yn = "";

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

			String rd_install_yn = "";
			if(resultSet.next() )
			{
				rd_install_yn = 	resultSet.getString("operational_yn")  ;
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(rd_install_yn == null)	rd_install_yn = "";

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

			if(resultSet.next() )
			{
				ot_install_yn = 	resultSet.getString("operational_yn");
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(ot_install_yn==null)	ot_install_yn = "";

			String lbrdSearchYN = getLBRDSearchYN(order_status);

			if(ord_cat.equals("LB"))
			{
				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull((String)order_id.trim(),"") );

				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() )
				{
					record1 = new String[2];// Only One record
					record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
					record1[1]=resultSet6.getString( "order_type_code" )  ;
				}
				labchk=checkForNull(getmoduleRL(record1[0],ord_cat,record1[1],login_facility_id),"");
			}



			if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT"))) && (lbrdSearchYN.equals("Y")))
			{

				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
				{

					//SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_FREQ_EXPL
					//IN061345 Start.
					//pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner,a.event_group,a.event_code,a.event_date,  SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.hist_rec_type =d.hist_rec_type(+) and a.accession_num =d.accession_num(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc") ;
					pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner,a.event_group,a.event_code,a.event_date,  SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.hist_rec_type =d.hist_rec_type(+) and a.accession_num =d.accession_num(+) and a.contr_sys_id = d.contr_sys_id(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc") ;
					//IN061345 End.
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, patient_id);
					pstmt.setString(3, resp_id);
					pstmt.setString(4, resp_id);
				}
				else
				{

					//SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS
					//IN061345 Start.
					//pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner, SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.event_group,a.event_code,a.event_date FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.hist_rec_type =d.hist_rec_type(+) and a.accession_num =d.accession_num(+)   and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null and rownum <=1) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date ") ;
					pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner, SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.event_group,a.event_code,a.event_date FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.hist_rec_type =d.hist_rec_type(+) and a.accession_num =d.accession_num(+) and a.contr_sys_id = d.contr_sys_id(+)  and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null and rownum <=1) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date ") ;
					//IN061345 End.
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, patient_id);
					pstmt.setString(3, resp_id);
					pstmt.setString(4, resp_id);
				}				
			} 
			else
			{
				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
				{

					//SQL_OR_ORDER_ENTRY_GET_PARENT_CHILD_RSLT_DTLS
					pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO,a.event_group,a.event_code,a.event_date FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc") ;
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, (String)order_id.trim());
					pstmt.setString(3, ord_line_num);
					pstmt.setString(4, patient_id);
					pstmt.setString(5, resp_id);
					pstmt.setString(6, resp_id);
				}
				else
				{

					//SQL_OR_ORDER_ENTRY_GET_RSLT_DTLS_WITHOUT_LB -- given by Rajan
					pstmt = connection.prepareStatement("SELECT distinct a.performed_by_id reporting_practitioner,a.event_date, request_num_seq FROM cr_encounter_detail a WHERE SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,INSTR (a.accession_num, '!', 1, 2) - INSTR (a.accession_num, '!') - 1) = (?) AND SUBSTR (a.accession_num, INSTR (a.accession_num, '!', 1, 4) + 1) = NVL ((?),SUBSTR (a.accession_num, INSTR (a.accession_num, '!', 1, 4) + 1)) AND patient_id = (?) AND 'A' =  DECODE (protection_ind,'Z', get_task_applicability ('VIEW_CONF_RESULT','',?,?),'A') AND NVL (a.status, '#') != 'S' order by a.event_date desc,request_num_seq") ;
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, ord_line_num);
					pstmt.setString(3, patient_id);
					pstmt.setString(4, resp_id);
					pstmt.setString(5, resp_id);
				}
			}

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next())
			{
				repPract = resultSet.getString("reporting_practitioner") == null ? "" : resultSet.getString("reporting_practitioner");
				if(!repPractCnt.contains(repPract))
					repPractCnt.add(repPract);
			}	
		} //end of try
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet6 ) ;
			closeResultSet( resultSet7 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt6 ) ;
			closeStatement( pstmt7 ) ;
			closeConnection(connection) ;
		}
		return repPractCnt;
	}//end of method	
	
	public String getRepPractName(String parctID, String localeName) throws Exception
	{
	
		Connection con	= null;
		PreparedStatement psPract = null;
		ResultSet rsPract	= null;
		String repPractName = "";

		try
		{
			con  = getConnection();

			psPract = con.prepareStatement("select AM_GET_DESC.AM_PRACTITIONER(?,?,1) pract_desc from dual ");

			psPract.setString(1, parctID);
			psPract.setString(2, localeName);

			rsPract = psPract.executeQuery();

			while(rsPract.next())
			{
				repPractName = rsPract.getString("pract_desc") == null ? "" : rsPract.getString("pract_desc");
			}			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			closeResultSet(rsPract) ;
			closeStatement(psPract) ;
			closeConnection(con);
		}

		return repPractName;
	}//end of getRepPractName
/* Added By Arvind For CRF-804 
	*/
	//public ArrayList<Map<String,String>> getClinicalNotesHistory(String accessionNum,String facilityId,String languageId) throws Exception {
		public ArrayList<Map<String,String>> getClinicalNotesHistory(String accessionNum,String facilityId,String languageId,String RepDb) throws Exception {//IN065341
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		//IN065341 starts
			if(RepDb.equals(" ") || RepDb.equals("null")) RepDb = "";
			String sql="";
		//IN065341 ends
		try {
		//IN065341 starts	
			//String sql="select distinct a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi') s_action_date_time,b.practitioner_name clinician_name, a.action_type,  action_status action_desc,dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type,am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,?,2)spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code  and d.practitioner_id(+) = a.REQUEST_BY_ID and a.facility_id =? and a.accession_num =? and  b.language_id =? and  d.language_id(+) =? order by nvl(a.action_date_time,a.ADDED_DATE)  desc,action_status desc,action_type desc ";
			 sql="select distinct a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi') s_action_date_time,b.practitioner_name clinician_name, a.action_type,  action_status action_desc,a.action_date_time action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type,am_get_desc.AM_SPECIALITY##REPDB##(a.ACTION_BY_GROUP_CODE,?,2)spl_desc from ca_encntr_note_audit_log ##REPDB## a, am_practitioner_lang_vw ##REPDB## b ,am_speciality_lang_vw ##REPDB## c, am_practitioner_lang_vw ##REPDB## d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code  and d.practitioner_id(+) = a.REQUEST_BY_ID and a.facility_id =? and a.accession_num =? and  b.language_id =? and  d.language_id(+) =? order by nvl(a.action_date_time,a.ADDED_DATE)  desc,action_status desc,action_type desc ";
		//IN065341 ends
			 
			connection = getConnection() ;
			sql=sql.replaceAll("##REPDB##",RepDb);//IN065341
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,languageId); 
			pstmt.setString(2,facilityId);							
			pstmt.setString(3,accessionNum); 
			pstmt.setString(4,languageId); 
			pstmt.setString(5,languageId); 

			Map<String,String> map=null;
			ArrayList<Map<String,String>> clinicalHistory=new ArrayList<Map<String,String>>();

			resultSet = pstmt.executeQuery() ;
			
			while( resultSet != null && resultSet.next() )
			{
					map=new HashMap<String,String>();
					map.put("CLINICIAN_NAME",resultSet.getString("clinician_name")==null?"":resultSet.getString("clinician_name"));
					map.put("ACTION_TYPE",resultSet.getString("action_type")==null?"":resultSet.getString("action_type"));
					map.put("ACTION_DESC",resultSet.getString("action_desc")==null?"":resultSet.getString("action_desc"));
					map.put("S_ACTION_DATE_TIME",resultSet.getString("s_action_date_time")==null?"":resultSet.getString("s_action_date_time"));
					map.put("PRIVILEGE_TYPE",resultSet.getString("privilege_type")==null?"":resultSet.getString("privilege_type"));
					map.put("SPL_DESC",resultSet.getString("spl_desc")==null?"":resultSet.getString("spl_desc"));
					map.put("REQUESTED_BY_PRACT",resultSet.getString("requested_by_pract")==null?"":resultSet.getString("requested_by_pract"));
					
					clinicalHistory.add(map);				
			}
			
			return clinicalHistory.size()>0?clinicalHistory:null;
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

	}
	//End Here 
	//--[IN032816] - Start
	public String getRltNoteSts(String order_id)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		String AccNum = "";
		try
		{
			connection = getConnection() ;
			sql = "select  accession_num from (SELECT action_by_id,ACCESSION_NUM,ACTION_DATE_TIME,ACTION_TYPE FROM ca_encntr_note_audit_log a,or_result_detail b WHERE a.accession_num = b.linked_note_accession_num AND b.order_id = ? order by action_date_time desc) where rownum= 1";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString( 1, order_id.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;		
			while(resultSet.next())
			{
				AccNum = resultSet.getString("accession_num") == null ? "" : resultSet.getString("accession_num");
			}	
		}	
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet(resultSet) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}	
		return AccNum;
	}
	//--[IN032816] - End
	/**
	 * This method returns the performing location code given the order id as input(IN035413).
	 * @param order_id
	 * @return performing_deptloc_code
	 * @throws Exception
	 */
	private String getPerformingDeptLocCode(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  performing_deptloc_code	= null;

		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement("SELECT performing_deptloc_code from or_order where ORDER_ID = ?  ") ;
			pstmt.setString( 1, checkForNull((String)order_id.trim(),""));
			resultSet = pstmt.executeQuery() ;
			
			if( resultSet != null && resultSet.next() ) 
			{
				performing_deptloc_code = resultSet.getString( "performing_deptloc_code" )  ;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return performing_deptloc_code;	
	}
	//11g Conversion Start.
	public String getPractRelId(String patient_id,String facility_id,String practitioner_id,String encntr_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  Pract_Reln_Id	= null;
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement("SELECT PRACT_RELN_ID FROM CA_ENCNTR_PRACT_RELN WHERE PATIENT_ID=? AND FACILITY_ID=? AND PRACTITIONER_ID=? AND ENCOUNTER_ID=? AND DIRECT_YN='Y'") ;
			pstmt.setString( 1, checkForNull((String)patient_id.trim(),""));
			pstmt.setString( 2, checkForNull((String)facility_id.trim(),""));
			pstmt.setString( 3, checkForNull((String)practitioner_id.trim(),""));
			pstmt.setString( 4, checkForNull((String)encntr_id.trim(),""));
			
			resultSet = pstmt.executeQuery() ;			
			if( resultSet != null && resultSet.next() ) 
			{
				Pract_Reln_Id = resultSet.getString( "PRACT_RELN_ID" )  ;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return Pract_Reln_Id;	
	}	
	//11g Conversion End.
	//IN039857 - Start
	//This below logic included for Lab order category alone and should be executed only if IBA lab module installed (2tier)
	public String getLBInstallYN() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  LBInstallYN			= "N";
		String LBResultHTML			= "N";//IN051890
		int count 					= 0 ;//IN051890
		try
		{
			connection = getConnection();
			//IN051890 - Start	
			pstmt = connection.prepareStatement("Select count(*) count from OR_PAT_APPLICABLE_FUNC where function_id = 'PRINT_LB_RESULT_IN_HTML' and PATIENT_CLASS = '*A' ");
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) 
			{ 
				count	 = resultSet.getInt(1);
				if(count>0)
				{
					LBResultHTML = "Y";	
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(!("Y".equals(LBResultHTML)))
			{
			//IN051890 - End	
				pstmt = connection.prepareStatement( "SELECT EXT_IMAGE_APPL_ID FROM CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID='IBARL' and EFF_STATUS = 'E'") ;
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next())
				{ 
					LBInstallYN = resultSet.getString("EXT_IMAGE_APPL_ID");
					if("IBARL".equals(LBInstallYN))
						LBInstallYN = "Y";
				}
			}//IN051890 if closed
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return LBInstallYN;	
	}	
	//IN039857 - End
	//IN045798 - Start
	public String getMultiPresentationSelection(String field_mnemonic) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  DisplayHdr			= "N";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( "select 'Y' flag from or_order_field where FIELD_MNEMONIC = ? and FIELD_TYPE = 'L' and PRESENTATION_TYPE = 'M' and SINGLE_OR_MULTI = 'M' ") ;
			pstmt.setString( 1, checkForNull((String)field_mnemonic.trim(),""));
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				DisplayHdr = resultSet.getString("flag");
				if("Y".equals(DisplayHdr))
					DisplayHdr = "Y";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return DisplayHdr;	
	}	
	//IN045798 - End
	// IN047204 - Start
	public String getExternalDmsLinkYN(String facilty_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  externalLinkYN			= "N";
		try
		{
			connection =getConnection();
			pstmt = connection.prepareStatement( "SELECT DMS_EXT_LINK_YN FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID = ?") ;
			pstmt.setString(1, facilty_id.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				externalLinkYN = resultSet.getString("DMS_EXT_LINK_YN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return externalLinkYN;	
	}	
	// IN047204 - End
	// IN048464 - Start
	public HashMap getClinicalCommentsHistory(String order_id, int action_seq_num, String language_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		
		try {
			String sql= " SELECT SM_GET_DESC.SM_APPL_USER(a.ADDED_BY_ID,?,1) ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE  FROM OR_ORDER_COMMENT a WHERE ORDER_ID = ? AND ACTION_SEQ_NUM = ?";
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,language_id); 
			pstmt.setString(2,order_id);							
			pstmt.setInt(3, action_seq_num);
			HashMap<String,String> clinicalHistory=null;
			

			resultSet = pstmt.executeQuery() ;
			
			while( resultSet != null && resultSet.next() )
			{
				clinicalHistory = new HashMap<String,String>();
				clinicalHistory.put("CLINICIAN_NAME",resultSet.getString("ADDED_NAME")==null?"":resultSet.getString("ADDED_NAME"));
				clinicalHistory.put("ADDED_DATE_TIME",resultSet.getString("ADDED_DATE")==null?"":resultSet.getString("ADDED_DATE"));
			}
			
			return clinicalHistory;
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

	}
	// IN048464 - End
	// IN049419 Start.
	public ArrayList getOrderFormatDetailAuditTrail(String order_id,String action_seq_num) throws Exception {
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
		String bt_install_yn 		= "N";
		String rd_install_yn 		= "N";
		String ot_install_yn		= "N";
		String order_category		= "";
		String[] record1 = null;
		String labchk="";
		try {
			connection = getConnection() ;

			if(order_id!=null && order_id.length() >2)
				order_category = order_id.substring(0,2); // First 2 characters for order_category			

			if(order_category.equals("LB")){
				pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			}else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}


			pstmt = connection.prepareStatement( "SELECT   order_field_type, order_label_text, order_field_value, accept_option,order_field_mnemonic, order_discr_msr_unit discr_msr_uom FROM or_order_field_values_action WHERE order_id = (?) AND action_seq_num = ? ORDER BY order_seq_num" ) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)action_seq_num.trim());
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
					pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
					pstmt6.setString( 1, checkForNull(order_id.trim(),"") );

					resultSet6 = pstmt6.executeQuery() ;
					if( resultSet6 != null && resultSet6.next() ) {
							 record1 = new String[2];// Only One record
							record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
							record1[1]=resultSet6.getString( "order_type_code" )  ;
					}
					labchk=checkForNull(getmoduleRL(record1[0],order_category,record1[1],login_facility_id),"");
				}
				
				if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_BLOOD_GROUP") )
				{
					record[2]=checkForNull(record[2],"");
					if(record[2].equals("null"))record[2]="";
					if(!record[2].equals(""))
					{
						pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery() ;
						if(resultSet1!=null && resultSet1.next() ) {	// One rec
							record[2] = resultSet1.getString("description")  ;
						}
					}
				}else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_RHESUS") )
				{
						record[2]=checkForNull(record[2],"");
						if(record[2].equals("null"))record[2]="";
						if(!record[2].equals(""))
						{
							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
					}
				}else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1,language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled

							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, order_id);
							resultSet1 = pstmt1.executeQuery() ;

							if(resultSet1!=null && resultSet1.next() )
							{	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
				}else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("OT_OPER_KEYWORD") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("CN") && (resultSet.getString("order_field_mnemonic").equals("PERFORM_PRACT_ID") || resultSet.getString("order_field_mnemonic").equals("CONULT_MED_ID")) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_AM_PRACTITIONER_PERFORM_TEAM_SURGEON") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}else if(((order_category.trim()).equalsIgnoreCase("OT"))  && (resultSet.getString("order_field_mnemonic").equals("ANAESTHESIA")) )    // For OT ANAESTHESIA
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
				{
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
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
	
	public ArrayList getOrderFormatLineDetailAuditTrail(String order_id,String action_seq_num,String line_id, String called_from) throws Exception {
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
			
			 if(order_category.equals("LB")){
				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
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
				pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery() ;
				if(resultSet3!=null &&  resultSet3.next() ) {
					bt_install_yn = 	resultSet3.getString("operational_yn")  ;
				}
			} else if(order_category.equals("RD")){
				pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery() ;
				if(resultSet4!=null &&  resultSet4.next() ) {
					rd_install_yn = 	resultSet4.getString("operational_yn")  ;
				}
			}else if(order_category.equals("OT")){
				pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery() ;
				if(resultSet5!=null &&  resultSet5.next() ) {
					ot_install_yn = 	resultSet5.getString("operational_yn")  ;
				}
			}
			
			if(called_from!=null && called_from.equals("RESULT_ENTRY"))
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_CMTS_AUDITTRAIL") ) ;
			else
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_CMTS_AUDITTRAIL") ) ;

			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)action_seq_num.trim());
			pstmt.setString(3, (String)line_id.trim());
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				String record[] = new String[9];
				record[0] = resultSet.getString("order_line_field_type")  ;
				record[1] = resultSet.getString("order_line_label_text")  ;
				record[2] = resultSet.getString("order_line_field_value")  ;
				record[3] = resultSet.getString("item_narration")  ;
				record[4] = resultSet.getString("order_line_field_mnemonic")  ;
				record[5] = resultSet.getString("order_line_num")  ;
				record[6] = resultSet.getString("catalog_synonym_dc");
				record[7] = resultSet.getString("discr_msr_uom");
				record[8] = resultSet.getString("accept_option");//IN045798
				
				if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
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
						pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery() ;
						if(resultSet1!=null && resultSet1.next() ) {	// One rec
							record[2] = resultSet1.getString("description")  ;
						}
					}				
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_line_field_mnemonic").equals("DONOR_RHESUS") )
				{
					record[2]=checkForNull(record[2],"");
					if(!record[2].equals(""))
					{
									pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
									pstmt1.setString(1, record[2]);
									resultSet1 = pstmt1.executeQuery() ;
									if(resultSet1!=null && resultSet1.next() ) {	// One rec
										record[2] = resultSet1.getString("description")  ;
									}
						}
								
				}
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				} else if(order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("ANATOMY_SITE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				
				} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("TRANSPORT_MODE") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("STUDY_LOC") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PATIENT_POSITION") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
				{
					// For both OT install or OT not  uninstalled
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
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
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_line_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_line_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}
				else if(order_category.equals("PH") && resultSet.getString("order_line_field_mnemonic").equals("PRES_REMARKS") )
				{
					pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PH_PRES_REMARK") ) ;
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}
				}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_line_field_mnemonic").equals("ANAESTHETIST_CODE") )
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}
				else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("ANAESTHESIA")) )    // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery() ;
					if(resultSet1!=null && resultSet1.next() ) {	// One rec
						record[2] = resultSet1.getString("description")  ;
					}

				}				
				else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
				{
					pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
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
		public String getOrderLineInstMaxCount(String order_id, String order_line_num, String field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		int max_action_seq_num = 0;
		String max_action_seq = "0";
		int order_line_sequ = 0;
		if(field_mnemonic.equalsIgnoreCase("Comments")) {
			field_mnemonic = "ITEM_NARRATION";
		}
		if(order_line_num != null && order_line_num != ""){
			order_line_sequ = Integer.parseInt(order_line_num);
		}
		String sql = "";
		if(field_mnemonic.equalsIgnoreCase("Instructions")) {
			sql = "SELECT MAX(ACTION_SEQ_NUM) action_seq_num FROM  OR_ORDER_LINE_FLD_VAL_ACTION WHERE ORDER_ID = ? and ORDER_LINE_NUM = ? and ORDER_LINE_FIELD_MNEMONIC in('DEPT_INSTRNS', 'PATIENT_INSTRNS')";
		} else {
			sql = "SELECT MAX(ACTION_SEQ_NUM) action_seq_num FROM  OR_ORDER_LINE_FLD_VAL_ACTION WHERE ORDER_ID = ? and ORDER_LINE_NUM = ? and ORDER_LINE_FIELD_MNEMONIC = ?";
		}	
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setInt(2, order_line_sequ);
			if(!field_mnemonic.equalsIgnoreCase("Instructions")) {
				pstmt.setString(3, field_mnemonic);
			}	
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				max_action_seq_num = resultSet.getInt("action_seq_num")  ;
			}
			max_action_seq = Integer.toString(max_action_seq_num);
		} catch ( Exception e )	{
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
		return max_action_seq;
	}
	public HashMap getOrderLineInstructions(String order_id, String order_line_num, String action_sequ, String field_mnemonic, String language_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pAuditStat =  null; // IN051106
		ResultSet auditResultSet	= null; // IN051106
		ResultSet resultSet 			= null;
		HashMap orderLineMap = null;
		//String max_action_seq_num = ""; //commented for checkstyle
		int order_line_sequ = 0;
		int action_seq_num = 0;
		String auditSql = ""; // IN051106
		if(field_mnemonic.equalsIgnoreCase("Comments")) {
			field_mnemonic = "ITEM_NARRATION";
		}
		if(order_line_num != null && order_line_num != ""){
			order_line_sequ = Integer.parseInt(order_line_num);
		}
		if(action_sequ != null && action_sequ != ""){
			action_seq_num = Integer.parseInt(action_sequ);
		}
		//String sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?) ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.order_line_field_mnemonic = ? AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // commented for IN051103
		//String sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.order_line_field_mnemonic = ? AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // modified for IN051103 - commented for IN051105
		String sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=b.MODIFIED_BY_ID), ?, '1') ADDED_NAME, to_char(b.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, b.order_line_field_value,b.order_line_fld_value_free_fmt,(select nvl(instruction_type,'T') from or_order_line where order_id = b.order_id and order_line_num = b.order_line_num)instruction_type FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.order_line_field_mnemonic = ? AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; //IN051105 - MOdified on 19/09/2014//IN64543
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, (String)order_id.trim());
			pstmt.setInt(3, action_seq_num);
			pstmt.setInt(4, order_line_sequ);
			pstmt.setString(5, field_mnemonic);
			resultSet = pstmt.executeQuery() ;
			orderLineMap = new HashMap<String, String>(); // IN051106
			if( resultSet != null && resultSet.next() ) {
				//orderLineMap = new HashMap<String, String>(); // commented - IN051106	
				//IN64543, starts
				//orderLineMap.put("ORDER_LINE_FIELD_VALUE", resultSet.getString("ORDER_LINE_FIELD_VALUE"));
				if("T".equals(resultSet.getString("instruction_type")))
					orderLineMap.put("ORDER_LINE_FIELD_VALUE", resultSet.getString("ORDER_LINE_FIELD_VALUE"));
				else
					orderLineMap.put("ORDER_LINE_FIELD_VALUE", resultSet.getString("order_line_fld_value_free_fmt"));
				//IN64543, ends
				//orderLineMap.put("AMEND_REASON", resultSet.getString("ORDER_AMEND_REASON")); //- commented for IN051106
				orderLineMap.put("ADDED_NAME", resultSet.getString("ADDED_NAME"));
				orderLineMap.put("ADDED_DATE", resultSet.getString("ADDED_DATE"));
			}
			 // IN051106 - Start
			if(action_seq_num >1) {
				action_seq_num = action_seq_num -1;
				auditSql = "SELECT  a.order_amend_reason ORDER_AMEND_REASON FROM  or_order_amend_reason a WHERE a.order_id = ? AND a.action_seq_num = ?";
				pAuditStat = connection.prepareStatement(auditSql) ;
				pAuditStat.setString(1, (String)order_id.trim());
				pAuditStat.setInt(2, action_seq_num);
				auditResultSet = pAuditStat.executeQuery();
				if(auditResultSet != null && auditResultSet.next()){
					orderLineMap.put("AMEND_REASON", auditResultSet.getString("ORDER_AMEND_REASON"));
				} 
			}	
			 // IN051106 - End
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( auditResultSet ) ;
			closeStatement( pAuditStat ) ;	
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return orderLineMap;
	}
	public HashMap getCurrentOrderLineInstructions(String order_id, String order_line_num, String action_sequ, String field_mnemonic, String language_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pAuditStat =  null; // IN051106
		ResultSet auditResultSet	= null; // IN051106
		HashMap orderLineMap = null;
		
		int order_line_sequ = 0;
		int action_seq_num = 0; //added for IN051106
		String auditSql = ""; // IN051106
		String sql = "";
		if(field_mnemonic.equalsIgnoreCase("Comments")) {
			field_mnemonic = "ITEM_NARRATION";
			
			//sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?) ADDED_NAME, TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE FROM or_order_line a WHERE a.order_id = ? AND a.order_line_num = ?"; -- Commented for IN051103
			//sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') ADDED_NAME, TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE FROM or_order_line a WHERE a.order_id = ? AND a.order_line_num = ?"; // modified for IN051103 - //IN051105
			sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=a.MODIFIED_BY_ID), ?, '1') ADDED_NAME, TO_CHAR (a.MODIFIED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE FROM or_order_line a WHERE a.order_id = ? AND a.order_line_num = ?"; // modified for IN051105
		}
		else if(field_mnemonic.equalsIgnoreCase("Instructions")) {
			//sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?) ADDED_NAME, TO_CHAR (b.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from or_order_line_field_values b WHERE   b.order_id = ? AND b.order_line_num = ? AND b.ORDER_LINE_FIELD_MNEMONIC IN ('DEPT_INSTRNS', 'PATIENT_INSTRNS')"; -- Commented for IN051103
			sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=b.ADDED_BY_ID), ?, '1') ADDED_NAME, TO_CHAR (b.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from or_order_line_field_values b WHERE   b.order_id = ? AND b.order_line_num = ? AND b.ORDER_LINE_FIELD_MNEMONIC IN ('DEPT_INSTRNS', 'PATIENT_INSTRNS')"; // modified  for IN051103
		}
		else {
			//sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?) ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE FROM  or_order_line_field_values a WHERE a.order_id = ? AND a.order_line_num = ?  AND a.order_line_field_mnemonic = ?"; // commented for IN051103
			sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE FROM  or_order_line_field_values a WHERE a.order_id = ? AND a.order_line_num = ?  AND a.order_line_field_mnemonic = ?"; // modified for IN051103
		}	
		if(order_line_num != null && order_line_num != ""){
			order_line_sequ = Integer.parseInt(order_line_num);
		}
		//added for IN051106 - Start
		if(action_sequ != null && action_sequ != ""){
			action_seq_num = Integer.parseInt(action_sequ);
		}
		//added for IN051106 - End
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, (String)order_id.trim());
			pstmt.setInt(3, order_line_sequ);
			if(!field_mnemonic.equalsIgnoreCase("ITEM_NARRATION") && !field_mnemonic.equalsIgnoreCase("Instructions")) {
				pstmt.setString(4, field_mnemonic);
			}	
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				orderLineMap = new HashMap<String, String>();
				orderLineMap.put("ADDED_NAME", resultSet.getString("ADDED_NAME"));
				orderLineMap.put("ADDED_DATE", resultSet.getString("ADDED_DATE"));
			}
			 // IN051106 - Start
			if(action_seq_num >1) {
				action_seq_num = action_seq_num -1;
				auditSql = "SELECT  a.order_amend_reason FROM  or_order_amend_reason a WHERE a.order_id = ? AND a.action_seq_num = ?";
      				pAuditStat = connection.prepareStatement(auditSql) ;
				pAuditStat.setString(1, (String)order_id.trim());
				pAuditStat.setInt(2, action_seq_num);
				auditResultSet = pAuditStat.executeQuery();
				if(auditResultSet != null && auditResultSet.next()){
					orderLineMap.put("AMEND_REASON", auditResultSet.getString("ORDER_AMEND_REASON"));
				} 
			}
			 // IN051106 - End
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( auditResultSet ) ;
				closeStatement( pAuditStat ) ;		
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return orderLineMap;
	}
	//IN049419 End.
	public String isPrintPinValidReq() throws Exception{ //ML-MMOH-CRF-0335 - IN057113 - Start
		String confidentialPinReq = "N";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		String selectSql = "SELECT CONF_PIN_REQ_YN FROM CA_PARAM WHERE MODULE_ID = 'CA'";
		try {
			con = getConnection();
			pStatement = con.prepareStatement(selectSql);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				confidentialPinReq = resultSet.getString("CONF_PIN_REQ_YN");
			}
		} catch(Exception ex){
			System.out.println(" Exception Occured in ViewOrder.java " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(con != null) con.close();
		}
		return confidentialPinReq;
	} //ML-MMOH-CRF-0335 - IN057113 - End
	//IN062669 starts
	public void insertResultViewer(String order_id,String order_line_num,String login_user_id,String login_at_ws_no,String facility_id) throws Exception //Added throws Exception for IN066581
	{
		int recordCount = 0;
		Connection connection = null;
		PreparedStatement pstmt_count = null;
		PreparedStatement pstmt_pract_name = null;
		PreparedStatement pstmt_order_action = null;
		PreparedStatement pstmt_action_seq_num = null;
		PreparedStatement pstmt_or_order_line = null;
		ResultSet rs_action_seq_num = null;
		ResultSet rs_or_order_line = null;
		ResultSet rs_pract_name = null;
		String field_value_txt = "Result viewed by Practitioner : ";
		boolean result = true;
		int insert_order_action = -1;
		int update_or_order_line = 0;
		int action_seq_num = 0;
		int i_order_line_num = 0;
		String order_line_status = "", practitioner_name = "", result_line_status = "";
		try
		{
			connection = getConnection();
			pstmt_pract_name = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACTITIONER_DETAILS"));
			pstmt_pract_name.setString(1,language_id);
			pstmt_pract_name.setString(2,login_user_id);
			rs_pract_name = pstmt_pract_name.executeQuery();
			while(rs_pract_name.next())
			{
				practitioner_name = rs_pract_name.getString("practitioner_name");
			}
			field_value_txt = field_value_txt.concat(practitioner_name);
			pstmt_count = connection.prepareStatement("SELECT NO_OF_RESULT_VIEWERS,ORDER_LINE_STATUS,ORDER_LINE_NUM,RESULT_LINE_STATUS FROM OR_ORDER_LINE WHERE ORDER_ID = ? ");
			pstmt_count.setString(1,order_id);
			rs_or_order_line = pstmt_count.executeQuery();
			while(rs_or_order_line.next())
			{
				recordCount = (int) rs_or_order_line.getInt("NO_OF_RESULT_VIEWERS");
				order_line_status = checkForNull(rs_or_order_line.getString("ORDER_LINE_STATUS"),"");
				i_order_line_num = (int) rs_or_order_line.getInt("ORDER_LINE_NUM");
				result_line_status = checkForNull(rs_or_order_line.getString("RESULT_LINE_STATUS"),"");
				if((recordCount<3) && ("CD".equals(order_line_status)||"RS".equals(result_line_status)||"RS".equals(order_line_status)||"RA".equals(result_line_status)||"RM".equals(order_line_status)||"RM".equals(result_line_status)||"MA".equals(order_line_status)||"MA".equals(result_line_status)))
				{
					recordCount++;
										
					/*IN066581 Starts */
					boolean site=false;
		    		site = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_ORDER_ACTION");
		    		String reptDb="";
		    		if(site)
		    		{
		    			 reptDb=ReportDbDet(getLoginFacilityId());	
		    		}
					//pstmt_action_seq_num = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 L_ACTION_SEQ_NUM FROM OR_ORDER_ACTION WHERE ORDER_ID = ?"); 
					pstmt_action_seq_num = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 L_ACTION_SEQ_NUM FROM OR_ORDER_ACTION "+reptDb+"  WHERE ORDER_ID = ?"); 
					/*IN066581 ends */
					pstmt_action_seq_num.setString(1,order_id);
					rs_action_seq_num = pstmt_action_seq_num.executeQuery();
					while(rs_action_seq_num.next())
					{
						action_seq_num =(int) rs_action_seq_num.getInt("L_ACTION_SEQ_NUM");
					}
					/*IN066581 Starts*/
					String sqlqry=OrRepository.getOrKeyValue("SQL_OR_RESULT_VIEWER_INSERT_OR_ORDER_ACTION");
					sqlqry=sqlqry.replace("$$REPDB##", reptDb);
		            		pstmt_order_action		= connection.prepareStatement(sqlqry);
					//pstmt_order_action = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_VIEWER_INSERT_OR_ORDER_ACTION")); 
					/*IN066581 ends*/
					pstmt_order_action.setString(1,order_id);
					pstmt_order_action.setInt(2,i_order_line_num);
					pstmt_order_action.setInt(3,action_seq_num);
					pstmt_order_action.setString(4,login_user_id);
					pstmt_order_action.setString(5,facility_id);
					pstmt_order_action.setString(6,field_value_txt);
					insert_order_action = pstmt_order_action.executeUpdate();
					
					if(insert_order_action < 0)
						result = false;
					else
						result = true;
						
					if(result)
					{
						pstmt_or_order_line = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_VIEWER_UPDATE_OR_ORDER_LINE"));
						pstmt_or_order_line.setInt(1,recordCount);
						// IN069968 Start.
						/*pstmt_or_order_line.setString(2,login_user_id);
						pstmt_or_order_line.setString(3,login_at_ws_no);
						pstmt_or_order_line.setString(4,facility_id);
						pstmt_or_order_line.setString(5,order_id);
						pstmt_or_order_line.setInt(6,i_order_line_num);*/ 
						pstmt_or_order_line.setString(2,order_id);
						pstmt_or_order_line.setInt(3,i_order_line_num);
						//IN069968 End.
						update_or_order_line = pstmt_or_order_line.executeUpdate();
						connection.commit();
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( rs_action_seq_num ) ;
				closeResultSet( rs_pract_name ) ;
				closeStatement( pstmt_count ) ;
				closeStatement( pstmt_pract_name );
				closeStatement( pstmt_order_action ) ;
				closeStatement( pstmt_or_order_line ) ;
				closeConnection(connection) ;
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	//IN062669 ends
	//IN064215 start
	public String confAccessPrevYN(String order_id, String ord_line_num, String cont_order_ind, String patient_id, String ord_cat, String facility_id,String resp_id, String order_status, String pract_reln_id,String clinician_id) throws Exception 
	{
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
		String order_date			= "";//old_order_date = ""; //Checkstyle
		panels						= new  ArrayList();
	    discrete					= new  ArrayList();
		String ot_install_yn		= "N";
		String[] record1 = null;
		String labchk="";
		String confAccessPrev = "";

		try 
		{
			
			if(ord_line_num.equals(" ")|| ord_line_num.equals(""))
				ord_line_num = "";

			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, "RL");
			resultSet = pstmt.executeQuery() ;

			String install_yn = "";
			if(resultSet.next() ) 
			{
				install_yn = 	resultSet.getString("install_yn")  ;
			}
			if(install_yn == null)
				install_yn = "";

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

            pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
            pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

			String rd_install_yn = "";
			if(resultSet.next() ) 
			{
				rd_install_yn = 	resultSet.getString("operational_yn")  ;
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;



			if(rd_install_yn == null)
				rd_install_yn = "";

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
            pstmt.setString(1, ord_cat);
			pstmt.setString(2, facility_id);
			resultSet = pstmt.executeQuery() ;

 			if(resultSet.next() ) 
			{
				ot_install_yn = 	resultSet.getString("operational_yn")  ;
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(ot_install_yn==null)
				ot_install_yn = "";

			String lbrdSearchYN = getLBRDSearchYN(order_status);

			if(ord_cat.equals("LB"))
			{
				pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
				pstmt6.setString( 1, checkForNull((String)order_id.trim(),"") );

				resultSet6 = pstmt6.executeQuery() ;
				if( resultSet6 != null && resultSet6.next() ) 
				{
					record1 = new String[2];
					record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
					record1[1]=resultSet6.getString( "order_type_code" )  ;
				}
				labchk=checkForNull(getmoduleRL(record1[0],ord_cat,record1[1],login_facility_id),"");
			}
			
			String performing_deptloc_code = null;

			if(Constants.ORDER_CATEGORY.equals(ord_cat))
			{
				performing_deptloc_code = getPerformingDeptLocCode(order_id);
			}

			if((((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")) || (ot_install_yn.equals("Y") && ord_cat.equals("OT") && performing_deptloc_code==null)) && (lbrdSearchYN.equals("Y")))||(ord_cat.equals("OH")))//IN035413
			{
				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
				{
					pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, hist_data result_data, d.compress_hist_data_yn,d.compress_hist_data,d.comments, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+)  and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id in (select order_id from or_order_line where parent_order_id = (?) and parent_order_line_num =nvl(1,order_line_num))) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id = ? and c.language_id(+)=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='N' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");
				}
				else
				{
					pstmt = connection.prepareStatement("SELECT SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1) srl_no, null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  , result_num_uom,result_str  result_str, D.HIST_DATA result_data, d.compress_hist_data_yn,d.compress_hist_data,d.comments, to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(REQUEST_NUM_SEQ,1,INSTR(REQUEST_NUM_SEQ,'#')+1) GROUP_SEQ_NO, request_num_seq test_seq_no,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn, a.ext_image_upld_id FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c ,cr_encounter_detail_txt d WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type =d.hist_rec_type(+) and a.CONTR_SYS_ID=d.CONTR_SYS_ID(+) and a.accession_num =d.accession_num(+) and a.CONTR_SYS_EVENT_CODE=d.CONTR_SYS_EVENT_CODE(+) and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) in  (select accession_num from or_order_line where  order_id = (?) and accession_num is not null /*and rownum <=1*/) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A') and nvl(a.status,'#') != 'S' and b.language_id =? and c.language_id(+) =? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='N' ORDER BY GROUP_SEQ_NO ,TEST_SEQ_NO,a.event_group,a.event_code,a.event_date desc");
				}
				pstmt.setString(1, (String)order_id.trim());
				pstmt.setString(2, patient_id);
				pstmt.setString(3, resp_id);
				pstmt.setString(4, pract_reln_id);
				pstmt.setString(5, language_id);
				pstmt.setString(6, language_id);
			}
			else
			{
				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
				{
					pstmt = connection.prepareStatement( "SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no,   SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id,   null result_type,result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn,d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and c.event_group_type(+) = a.event_group_type  and a.hist_rec_type =d.hist_rec_type(+)  and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) in (select order_id from or_order where parent_ordeR_id = (?)) and SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)   in (select to_char(order_line_num) from or_ordeR_line where parent_ordeR_id = (?) and parent_ordeR_line_num = nvl((?),parent_ordeR_line_num)) and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S'  and b.language_id= ? and c.language_id(+) = ? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='N' ORDER BY GROUP_SEQ_NO ,srl_no,a.event_group,a.event_code,a.event_date desc");
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, (String)order_id.trim());
					pstmt.setString(3, ord_line_num);
					pstmt.setString(4, patient_id);
					pstmt.setString(5, resp_id);
					pstmt.setString(6, pract_reln_id);
					pstmt.setString(7, language_id);
					pstmt.setString(8, language_id);
				}
				else
				{
					pstmt = connection.prepareStatement("SELECT  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  report_srl_no, nvl(a.EVENT_GROUP,a.EVENT_CODE) discr_msr_panel_id, a.EVENT_CODE discr_msr_id, SUBSTR(a.accession_num,INSTR(a.accession_num, '!',  1,  3)+1)  srl_no,  null result_type, result_num_prefix, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) RESULT_NUM  ,result_num_uom, result_str  result_str, hist_data result_data, d.compress_hist_data_yn,d.compress_hist_data,d.comments, to_char(event_date,'dd/mm/yyyy hh24:mi') reporting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000' ,8,'99999999990.90000000',9,'99999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, null result_comments, null result_type , c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc , SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) GROUP_SEQ_NO, SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1)  test_seq_no,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,DECODE(A.event_code,A.event_group,NULL,b.short_desc)  event_group_desc   ,b.short_desc event_desc, a.status,a.normalcy_str,a.num_data_yn FROM Cr_encounter_DETAIL a,CR_CLN_EVT_MST_LANG_VW b,CR_CLN_EVT_GRP_LANG_VW c,cr_encounter_detail_txt d  WHERE  b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code and b.event_code_type = a.event_code_type and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group  and c.event_group_type(+) = a.event_group_type and a.hist_rec_type =d.hist_rec_type(+) and a.contr_sys_id =d.contr_sys_id(+) and a.accession_num = d.accession_num (+) and a.contr_sys_event_code =d.contr_sys_event_code(+)  and SUBSTR(a.accession_num,INSTR(a.accession_num,'!')+1,INSTR(a.accession_num,'!',1,2)-INSTR(a.accession_num,'!')-1) = (?) and  SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1) =nvl((?),SUBSTR(a.accession_num,INSTR(a.accession_num,'!',1,4)+1))  and patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,?),'A')  and nvl(a.status,'#') != 'S' and b.language_id= ? and c.language_id(+) = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.EVENT_GROUP),'N')='N'  order by report_srl_no,a.event_date desc,hist_rec_type,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code") ;	// modified for IN047528			
					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, ord_line_num);
					pstmt.setString(3, patient_id);
					pstmt.setString(4, resp_id);
					pstmt.setString(5, pract_reln_id);
					pstmt.setString(6, language_id);
					pstmt.setString(7, language_id);
				}
			}

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) 
			{
                String record[];

                if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (lbrdSearchYN.equals("Y")))
				{
					record = new String[35];
                }
				else
				{ 
					record = new String[33];  
				}
				
				String result_data = "";

				record[0] = resultSet.getString("report_srl_no")  ;
				record[1] = resultSet.getString("discr_msr_panel_id") +"`~"+ resultSet.getString("report_srl_no") ;

				if(record[1] != null)
				{
					if(!currPanel.trim().equalsIgnoreCase(record[1])) 
					{
						panels.add(record[1]);
						currPanel = record[1];
					}
				}

				record[2] = resultSet.getString("discr_msr_id") +"`~"+ resultSet.getString("report_srl_no") ;

				if(!currDiscrete.trim().equalsIgnoreCase(record[2])) 
				{
					discrete.add(record[2]);
					currDiscrete = record[2];
				}

				record[3] = resultSet.getString("srl_no")  ;
				record[4] = resultSet.getString("result_type")  ;
				record[5] = resultSet.getString("result_num")  ;
				record[6] = resultSet.getString("result_num_uom")  ;
				record[7] = resultSet.getString("result_str")  ;
				result_data = "";
				
				//6484 Start.
				if("Y".equals(resultSet.getString("compress_hist_data_yn")==null?"N":(String)resultSet.getString("compress_hist_data_yn"))){
					StringBuffer compresshistData = new StringBuffer();
					java.sql.Blob hist_data_blob =  (java.sql.Blob)resultSet.getBlob("compress_hist_data");
					if( hist_data_blob!= null && hist_data_blob.length()>0){
						InputStream ins1 = hist_data_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {							
									compresshistData.append(line+"\n");
								}
							}					
						}
						result_data = compresshistData.toString();
					}
				}else{
					Clob rslt_data = resultSet.getClob("result_data");
					if(rslt_data!=null && rslt_data.length() > 0)
						result_data = rslt_data.getSubString(1,( (int)rslt_data.length() ));
					
				}				
				result_data += ((resultSet.getString("comments")==null?"":(String)resultSet.getString("comments")));
				//6484 End.
				
			    arrayData.add(result_data);
				string_check.append(result_data);

				record[8]  = result_data ;
				order_date = resultSet.getString("reporting_date")  ;
				record[9]  = order_date;
				record[10] = resultSet.getString("result_status")  ;
				record[11] = resultSet.getString("normal_low")  ;
				record[12] = resultSet.getString("normal_high")  ;
				record[13] = resultSet.getString("critical_low")  ;
				record[14] = resultSet.getString("critical_high")  ;
				record[15] = resultSet.getString("norm_abnorm_ind")  ;
				record[16] = resultSet.getString("result_comments")  ;
				record[17] = "";
				record[18] = resultSet.getString("parent_short_desc")  ;
				record[19] = resultSet.getString("child_desc")  ;
				record[20] = resultSet.getString("result_desc")  ;
				record[21] = ""+count ;
                
                if(((labchk.equalsIgnoreCase("IBARL") && ord_cat.equals("LB")) || (rd_install_yn.equals("Y") && ord_cat.equals("RD")))  && (lbrdSearchYN.equals("Y")))
				{
                    record[22] = ((resultSet.getString("PRACTITIONER_ID") == null) ? "" : resultSet.getString("PRACTITIONER_ID"));
                    record[23] = resultSet.getString("ext_image_obj_id")  ;
                    record[24] = resultSet.getString("ext_image_appl_id")  ;
                    record[25] = resultSet.getString("reporting_practitioner")  ;
					record[26] = resultSet.getString("hist_rec_type")  ;
	                record[27] = resultSet.getString("contr_sys_id")  ;
	                record[28] = resultSet.getString("accession_num")  ;
	                record[29] = resultSet.getString("contr_sys_event_code")  ;
	                record[30] = resultSet.getString("result_num_prefix")  ;
	                record[31] = resultSet.getString("status")  ;
					record[32] = resultSet.getString("normalcy_str")  ;
					record[33] = resultSet.getString("num_data_yn")  ;
					record[34] = resultSet.getString("ext_image_upld_id")  ;
                } 
				else 
				{
	                record[22] = resultSet.getString("ext_image_obj_id")  ;
	                record[23] = resultSet.getString("ext_image_appl_id")  ;
	                record[24] = resultSet.getString("reporting_practitioner")  ;
	                record[25] = resultSet.getString("hist_rec_type")  ;
	                record[26] = resultSet.getString("contr_sys_id")  ;
	                record[27] = resultSet.getString("accession_num")  ;
	                record[28] = resultSet.getString("contr_sys_event_code")  ;
	                record[29] = resultSet.getString("result_num_prefix")  ;
	                record[30] = resultSet.getString("status")  ;
					record[31] = resultSet.getString("normalcy_str")  ;
					record[32] = resultSet.getString("num_data_yn")  ;
				}

				order_format_dtl.add(record);
				count++;
				
				if(order_format_dtl.isEmpty())
				{
					confAccessPrev = "N";
				}
				else
				{
					confAccessPrev = "Y";
				}
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet6 ) ;
			closeResultSet( resultSet7 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt6 ) ;
			closeStatement( pstmt7 ) ;
			closeConnection(connection) ;
		}
		return confAccessPrev;
	}
	//End of confAccessPrevYN
	//IN064215 ends
	//IN066119 starts
	public HashMap orParamFacility(Connection con,String facility_id) throws Exception{  
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		HashMap orParamFacVal = new HashMap() ;
		String selectSql = "SELECT HIDE_SPECIMENTYPE,HIDE_REPORTINGPRAC FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID = ?";
		try {
			pStatement = con.prepareStatement(selectSql);
			pStatement.setString(1,facility_id);
			resultSet = pStatement.executeQuery(); 
			while(resultSet.next()){
				orParamFacVal.put("HIDE_SPECIMENTYPE",checkForNull(resultSet.getString("HIDE_SPECIMENTYPE"),"N"));
				orParamFacVal.put("HIDE_REPORTINGPRAC",checkForNull(resultSet.getString("HIDE_REPORTINGPRAC"),"N"));
			}
		} catch(Exception ex){
			System.out.println(" Exception Occured in orParamFacility ViewOrder.java " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
		}
		return orParamFacVal;
	}
	//IN066119 ends
	
	//IN64543, starts
	public String getApptDtlsFromComments(String order_id, String order_line_num)throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String comments = "";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_COMMENTS_DATA"));

			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {				
						comments = checkForNull(resultSet.getString("ITEM_NARRATION"),"");		
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return comments;
	}
	//IN64543, ends
	// 7632STARTS
	public ArrayList getPdfPrintingEvents(String patient_id)throws Exception,SQLException {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList array = new ArrayList();
		try {
			connection = ConnectionManager.getConnection();
			pstmt1 = connection
					.prepareStatement("SELECT USERENV('SESSIONID')l_session_id,to_char(SYSDATE,'DDMMYYHH24MISS') curr_date,SYS_CONTEXT('USERENV','IP_ADDRESS')machine_name FROM DUAL");

			rs = pstmt1.executeQuery();
			pstmt2 = connection
					.prepareStatement("SELECT distinct PERFORMING_FACILITY_ID,ORDERING_FACILITY_ID FROM OR_ORDER WHERE patient_id = ?");
			pstmt2.setString(1, patient_id);
			rs1 = pstmt2.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					array.add(rs.getString("l_session_id") == null ? "" : rs
							.getString("l_session_id"));
					array.add((String) rs.getString("curr_date") == null ? ""
							: rs.getString("curr_date"));
					array.add((String) rs.getString("machine_name") == null ? ""
							: rs.getString("machine_name"));

				}
			}
			if (rs1 != null) {
				while (rs1.next()) {
					array.add(rs1.getString("PERFORMING_FACILITY_ID") == null ? ""
							: rs1.getString("PERFORMING_FACILITY_ID"));
					array.add(rs1.getString("ORDERING_FACILITY_ID") == null ? ""
							: rs1.getString("ORDERING_FACILITY_ID"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(pstmt1);
			closeResultSet(rs1);
			closeStatement(pstmt2);
			closeResultSet(rs);
			if(connection!=null)connection.close();
		}

		return array;
	}
	public ArrayList viewCall(String facility_id,String ws_no,String reportServer,String userid,String report_option,String order_id)	throws Exception,SQLException {
		Connection connection = null;
		PreparedStatement pstmt_chldorderlst = null;
		ResultSet rschildor_lst = null;
		ArrayList array = new ArrayList();
		String l_specimen_no="";
		try {
			connection = ConnectionManager.getConnection();
			pstmt_chldorderlst = connection.prepareStatement("SELECT ACCESSION_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ?");
			//IN056670 ends
			pstmt_chldorderlst.setString(1,order_id);
			rschildor_lst = pstmt_chldorderlst.executeQuery() ;
	
			if(rschildor_lst.next())    
			{
					l_specimen_no	  = checkForNull(rschildor_lst.getString("ACCESSION_NUM"),""); //IN056670
			}
			if(pstmt_chldorderlst!=null)
				pstmt_chldorderlst.close();
			if(rschildor_lst!=null)
				rschildor_lst.close();
			
			CallableStatement cs = connection.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
			cs.setString( 1,	"RL" ) ;
			cs.setString( 2,	"RLRRSENQ" ) ;
			cs.setString( 3,	"" ) ;
			cs.setString( 4,	"" ) ;
			cs.setString( 5,	facility_id ) ;
			cs.setString( 6,	ws_no ) ;
			cs.setString( 7,	report_option ) ;
			cs.registerOutParameter( 8,  Types.VARCHAR ) ;
			cs.registerOutParameter( 9,  Types.VARCHAR ) ;
			cs.registerOutParameter( 10, Types.VARCHAR ) ;
			cs.registerOutParameter( 11, Types.VARCHAR ) ;
			cs.registerOutParameter( 12, Types.VARCHAR ) ;
			cs.registerOutParameter( 13, Types.VARCHAR ) ;
			cs.registerOutParameter( 14, Types.VARCHAR ) ;
			cs.registerOutParameter( 15, Types.VARCHAR ) ;
			cs.registerOutParameter( 16, Types.VARCHAR ) ;
			cs.registerOutParameter( 17, Types.VARCHAR ) ;
			cs.execute() ;

			String report	= cs.getString( 8 ) ;
			String server	= cs.getString( 9 ) ;
			String copies	= cs.getString( 10 ) ;
			if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
			String queue_name	= cs.getString( 12 ) ;
			String message	= cs.getString( 15 ) ;
			if (message==null) message="";
			String app_server_ip = cs.getString( 16 ) ;
			String rep_server_key= cs.getString( 17 ) ;
			array.add(report);
			array.add(server);
			array.add(copies);
			array.add(queue_name);
			array.add(message);
			array.add(app_server_ip);
			array.add(rep_server_key);
					
			if (rep_server_key==null) rep_server_key="";
		 
			reportServer = "http://" + app_server_ip + reportServer ;
			array.add(reportServer);
			array.add(l_specimen_no);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(pstmt_chldorderlst);
			closeResultSet(rschildor_lst);
			if(connection!=null)connection.close();
		}
		return array;
	}
	
	public String viewInsert(String locale, String login_user,String facilityid, String login_at_ws_no, String accession_num,String req_date, String resp_id, String operating_facility_id,String report_id, String session_id, String p_module_id,String eventCode, String patient_id, String machine_name)throws Exception,SQLException {
		Connection connection1 = null;
		PreparedStatement pstatmt = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		PreparedStatement pstment = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		String section_code = "", urgent_indicator = "";
		String print_type = "";
		//Hashtable htResMesg = new Hashtable(); //COMMON-ICN-0122
		//String error_value = ""; //COMMON-ICN-0122
		String catalog_code = "", test_code = "";
		//boolean result = false; //COMMON-ICN-0122
		//boolean result1 = false; //COMMON-ICN-0122
		connection1 = ConnectionManager.getConnection();
		pstmt3 = connection1
				.prepareStatement("SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE CONTR_MSR_PANEL_ID = ?");
		pstmt3.setString(1, eventCode);
		resultSet1 = pstmt3.executeQuery();

		if (resultSet1.next()) {
			catalog_code = resultSet1.getString("ORDER_CATALOG_CODE");
		}
		pstmt4 = connection1
				.prepareStatement("SELECT patient_id, specimen_no, section_code, episode_type, source_code, source_type, urgent_indicator FROM RL_REQUEST_HEADER WHERE specimen_no = ?");
		pstmt4.setString(1, accession_num);
		resultSet3 = pstmt4.executeQuery();
		if (resultSet3.next()) {
			section_code = resultSet3.getString("section_code");
			urgent_indicator = resultSet3.getString("urgent_indicator");
		}
		pstment = connection1
				.prepareStatement("SELECT NVL(GROUP_TEST_YN,'N') group_test,TEST_CODE FROM RL_TEST_CODE WHERE  ORDER_CATALOG_CODE=?");
		pstment.setString(1, catalog_code);
		resultSet = pstment.executeQuery();
		if (resultSet.next()) {
			test_code = resultSet.getString("TEST_CODE");
		}
		pstmt6 = connection1
				.prepareStatement("select SPECIMEN_WISE from ca_param");
		resultSet5 = pstmt6.executeQuery();
		if (resultSet5.next()) {
			print_type = resultSet5.getString("SPECIMEN_WISE");
		}
		try {
			if ("S".equals(print_type)) {
				pstatmt = connection1
						.prepareStatement("INSERT INTO SY_PROG_PARAM (operating_facility_Id, PGM_ID, SESSION_ID, PGM_DATE,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6, PARAM7, PARAM8,PARAM9,PARAM10,PARAM18,PARAM25) VALUES(?, ?, ?, ?, ?,?, null, ?,?, 'Y', 'Z', 'P', 'REPRINT', 'Y', ?,'V')");
				pstatmt.setString(1, facilityid);
				pstatmt.setString(2, report_id);
				pstatmt.setInt(3, Integer.parseInt(session_id));
				pstatmt.setString(4, req_date);
				pstatmt.setString(5, patient_id);
				pstatmt.setString(6, accession_num);
				pstatmt.setString(7, login_user);
				pstatmt.setString(8, section_code);
				pstatmt.setString(9, "");
			} else {
				pstatmt = connection1
						.prepareStatement("INSERT INTO SY_PROG_PARAM (operating_facility_Id, PGM_ID, SESSION_ID, PGM_DATE,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6, PARAM7, PARAM8,PARAM9,PARAM10,PARAM18,PARAM25) VALUES(?, ?, ?, ?, ?,?, null, ?,?, 'Y', 'Z', 'P', 'REPRINT', 'Y', ?,'V')");
				pstatmt.setString(1, facilityid);
				pstatmt.setString(2, report_id);
				pstatmt.setInt(3, Integer.parseInt(session_id));
				pstatmt.setString(4, req_date);
				pstatmt.setString(5, patient_id);
				pstatmt.setString(6, accession_num);
				pstatmt.setString(7, login_user);
				pstatmt.setString(8, section_code);
				pstatmt.setString(9, test_code);
			}
			pstatmt.executeUpdate();
			pstmt5 = connection1
					.prepareStatement("INSERT INTO SY_REPORT_GENERATE_REQUEST(operating_facility_id,USER_ID,MACHINE_NAME,WS_NO,PGM_ID,SESSION_ID,REQUEST_DATE,REGENERATE_REQUEST_DATE,PGM_TYPE,CMD_LINE_ARG,REQUEST_STATUS,URGENT_INDICATOR)VALUES(?, ?, ?, ?, ?, ?, sysdate, NULL, 'C',?,NULL,?)");
			pstmt5.setString(1, facilityid);
			pstmt5.setString(2, login_user);
			pstmt5.setString(3, machine_name);
			pstmt5.setString(4, login_at_ws_no);
			pstmt5.setString(5, report_id);
			pstmt5.setInt(6, Integer.parseInt(session_id));
			pstmt5.setString(7, accession_num);
			pstmt5.setString(8, urgent_indicator);
			pstmt5.executeUpdate();
			connection1.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			closeStatement(pstment);
			closeStatement(pstatmt);
			closeStatement(pstmt3);
			closeStatement(pstmt4);
			closeStatement(pstmt5);
			closeStatement(pstmt6);
			closeResultSet(resultSet);
			closeResultSet(resultSet1);
			closeResultSet(resultSet2);
			closeResultSet(resultSet3);
			closeResultSet(resultSet4);
			closeResultSet(resultSet5);
			closeConnection(connection1);
			
		}
		return "Success";
	}
	//7632 ENDS
}//end of class
