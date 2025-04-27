/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
--------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;

public class ReprintFormsBean extends OrAdapter implements java.io.Serializable {
 //   protected Hashtable allValues 		= new Hashtable();
//	protected String total_records 		= "";
//	protected String report_type	 	= "";
//	protected String print_at_locn		= "";

//	HttpServletRequest request 			= null;
//	HttpServletResponse response 		= null;

//	StringBuffer traceVals = new StringBuffer();
//	public String chk = "";

	public void setMode(String mode){						this.mode = mode;	}
//	public void setTotalRecs(String total_records){			this.total_records = total_records;	}
//	public void setReportType(String report_type){			this.report_type = report_type;	}
//	public void setPrintAtLocn(String print_at_locn){		this.print_at_locn = print_at_locn;	}

/*	public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response;
	}
*/
	public String getMode(){			return mode;	}
//	public String getTotalRecs(){		return total_records;	}
//	public String setReportType(){		return report_type;	}
//	public String getPrintAtLocn(){		return print_at_locn;	}

	public ArrayList getSearchOrderCategory() {
        Connection connection 	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet 	= null;
        ArrayList orderCategory	= new ArrayList();

        try {
			connection 	= getConnection();
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1"));
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat = new String[2];
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				orderCategory.add(order_cat);
			}
		}
		catch (Exception e) {
			System.out.println("ReprintFormsBean: Error in getSearchOrderCategory():"+e.getMessage());
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception e) {
				System.out.println("Finally Exception:"+e.getMessage());
			}
		}
		return orderCategory;
	}

    public ArrayList getSearchOrderType(String orderCategory) {
        Connection connection 	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet 	= null;
        ArrayList orderType	= new ArrayList();

        try {
			connection 	= getConnection();
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE"));
			pstmt.setString(1, orderCategory);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				String[] order_type = new String[2];
				order_type[0] = resultSet.getString(1)  ;
				order_type[1] = resultSet.getString(2)  ;
				orderType.add(order_type);
			}
		}
		catch (Exception e) {
			System.out.println("ReprintFormsBean: Error in getSearchOrderType():"+e.getMessage());
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception e) {
				System.out.println("Finally Exception:"+e.getMessage());
			}
		}
		return orderType;
	}

	public String  isModuleInstalled(String facility_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String install_yn = "";

		//System.out.println("order_category : "+order_category);

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;

			pstmt.setString(1, order_category.trim());
			pstmt.setString(2, facility_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString(1)  ;
				//System.out.println("SDSD");
			}else{
				install_yn  = "N";
				//System.out.println("eeeee");
			}
		} catch ( Exception e )	{
			System.out.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return install_yn;
	}

	public ArrayList getLocation(String location_type,String location) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;
		//chk = "";
		try {
			connection = getConnection() ;
			if ((location.equalsIgnoreCase("print")) && (location_type.equalsIgnoreCase("L"))) {
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_DEST_LOCN_SELECT") ) ;
					pstmt.setString( 1, location_type.trim() ) ;
			} else { //if (location.equalsIgnoreCase("source"))
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN") ) ;
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5, location_type.trim() ) ;
			}
			/*pstmt.setString( 1,language_id);
			pstmt.setString( 2,language_id);
			pstmt.setString( 3,language_id);
			pstmt.setString( 4,language_id);*/
			//pstmt.setString( 5, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}


	/**
		This will set all the values to set methods - persistant methods
		@param		:   recordSet-Hashtable
		@return		:	void
	*/

	public void setAll( Hashtable recordSet ) {
	//		allValues = recordSet;

	//		if(recordSet.containsKey("report_type")){setReportType((String)recordSet.get("report_type"));}
	//		if(recordSet.containsKey("total_recs")){	setTotalRecs((String)recordSet.get("total_recs"));	}
	//		if(recordSet.containsKey("print_at_locn")){	setPrintAtLocn((String)recordSet.get("print_at_locn"));}
//System.out.println("###############allvalues"+recordSet);
			this.mode = (String)recordSet.get( "mode" );

		//	this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
		//	this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
	}
	public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public ArrayList getSearchDetails(String report_type,String order_category,String order_type_code,String order_id, String date_from,String date_to,String source_type,String source_from,String source_to,String patient_id, String encntr_id,String facility_id,int start, int end) throws Exception {

	/*System.out.println("#####report_type="+report_type);
	System.out.println("#####order_category="+order_category);
	System.out.println("#####order_type_code="+order_type_code);
	System.out.println("#####order_id="+order_id);
	System.out.println("#####date_from="+date_from);
	System.out.println("#####date_to="+date_to);
	System.out.println("#####source_type="+source_type);
	System.out.println("#####source_from="+source_from);
	System.out.println("#####source_to="+source_to);
	System.out.println("#####patient_id="+patient_id);
	System.out.println("#####encntr_id="+encntr_id);
	//System.out.println("#####print_at_locn"+print_at_locn);
	System.out.println("#####facility_id="+facility_id);
	System.out.println("#####start="+start);
	System.out.println("#####end="+end);*/
	if(date_from==null || date_from.equals(" ")) date_from = "";
	if(date_to==null || date_to.equals(" ")) date_to = "";
	if (!language_id.equals("en")){
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");			
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
		}
	
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

 		int total_records			= 0;


		ArrayList resultData = new ArrayList() ;
		try {
			connection 	= getConnection();
			//System.out.println("report_type:"+report_type);
			if (report_type.equalsIgnoreCase("C")) {
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_CONSENT_SELECT"));
			} else if (report_type.equalsIgnoreCase("O")) {
                pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_ORDER_SELECT"));
			} else if (report_type.equalsIgnoreCase("R")) {
				//String lbInstalled 	= this.isModuleInstalled(facility_id,"RL");
				String rdInstalled 	= this.isModuleInstalled(facility_id,"RD");
				String query		= OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_RESULT_SELECT");
				int count = 0;
				//if (lbInstalled.equalsIgnoreCase("Y")) count++;commented on 7/19/2007 for lab_install check by uma 
				if (rdInstalled.equalsIgnoreCase("Y")) count++;
				String modulesInstalled[] = new String[count];
				count = 0;
				/*if (lbInstalled.equalsIgnoreCase("Y")) {
					modulesInstalled[count] = "LB";
					count++;
				}commented on 7/19/2007 for lab_install check by uma */
				if (rdInstalled.equalsIgnoreCase("Y")) {
					modulesInstalled[count] = "RD";
				}
				query				= replaceQuery(query,modulesInstalled);
				//System.out.println("query:="+query);
                //pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_RESULT_SELECT"));
                pstmt				= connection.prepareStatement(query);
			}else if (report_type.equalsIgnoreCase("L")) {
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_COLLECT_LIST_SELECT"));
				/*pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, language_id);
				pstmt.setString(4, language_id);
				pstmt.setString(5, language_id);
				pstmt.setString(6, language_id);
				pstmt.setString(7, language_id);
				pstmt.setString(8,patient_id);
			pstmt.setString(9,encntr_id);
			pstmt.setString(10,date_from);
			pstmt.setString(11,date_to);
			pstmt.setString(12,order_category);
			pstmt.setString(13,order_type_code);
			pstmt.setString(14,source_type);
			pstmt.setString(15,source_from);
			pstmt.setString(16,source_to);
			pstmt.setString(17,order_id);
			pstmt.setString(18,login_facility_id);*/
			}else if (report_type.equalsIgnoreCase("X"))
			{

				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_REFERRAL_SELECT"));
				/*pstmt.setString(1, language_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,encntr_id);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);
			pstmt.setString(6,order_category);
			pstmt.setString(7,order_type_code);
			pstmt.setString(8,source_type);
			pstmt.setString(9,source_from);
			pstmt.setString(10,source_to);
			pstmt.setString(11,order_id);
			pstmt.setString(12,login_facility_id);*/

			}else if (report_type.equalsIgnoreCase("S"))
			{

				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORTS_REPRINT_REFUSAL_SELECT"));
			/*	pstmt.setString(1, language_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,encntr_id);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);
			pstmt.setString(6,order_category);
			pstmt.setString(7,order_type_code);
			pstmt.setString(8,source_type);
			pstmt.setString(9,source_from);
			pstmt.setString(10,source_to);
			pstmt.setString(11,order_id);
			pstmt.setString(12,login_facility_id);*/
			}
			pstmt.setString(1, language_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,encntr_id);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);
			pstmt.setString(6,order_category);
			pstmt.setString(7,order_type_code);
			pstmt.setString(8,source_type);
			pstmt.setString(9,source_from);
			pstmt.setString(10,source_to);
			pstmt.setString(11,order_id);
			pstmt.setString(12,login_facility_id);
            //System.out.println("patient_id:"+patient_id+",encntr_id:"+encntr_id+",date_from:"+date_from+",date_to:"+date_to+",order_category:"+order_category+",order_type_code:"+order_type_code+",source_type:"+source_type+",source_from:"+source_from+",source_to:"+source_to+",order_id:"+order_id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet!=null) {
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				
				while ( start <= end && resultSet!=null && resultSet.next()) {

						String[] record;
						if (report_type.equalsIgnoreCase("R"))
							record = new String[26];
						else if(report_type.equalsIgnoreCase("C"))
							record = new String[28];
						else if(report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))
							record = new String[29];
						else
							record = new String[25];

						record[0] = resultSet.getString("order_category");
						record[1] = resultSet.getString("order_category_short_desc");
						record[2] = resultSet.getString("priority_desc");
						record[3] = resultSet.getString("encounter_dtls");
						record[4] = resultSet.getString("patient_class_short_desc");
						record[5] = resultSet.getString("patient_class");
						record[6] = resultSet.getString("location_details");
						record[7] = resultSet.getString("order_id");
						record[8] = resultSet.getString("patient_id");
						record[9] = resultSet.getString("encounter_id");
						record[10] = resultSet.getString("order_date_time");
						record[11] = resultSet.getString("order_detail");
						record[12] = resultSet.getString("source_type");
						record[13] = resultSet.getString("source_code");
						record[14] = resultSet.getString("priority");
						record[15] = resultSet.getString("order_type_code");
						record[16] = resultSet.getString("order_type_short_desc");
						record[17] = resultSet.getString("ord_pract_id");
						record[18] = resultSet.getString("ordering_pract_name");
						record[19] = resultSet.getString("order_status");
						record[20] = resultSet.getString("order_status_short_desc");
						record[21] = resultSet.getString("ord_cosign_reqd_yn");
						record[22] = resultSet.getString("cont_order_ind");
						record[23] = resultSet.getString("sex");
						if (report_type.equalsIgnoreCase("R")) {
							record[24] = resultSet.getString("report_srl_no");
							// Pass the total Number of Records
							record[25] = String.valueOf(total_records);
						}
						else if (report_type.equalsIgnoreCase("C")) {
							record[24] = resultSet.getString("catalog_code");
							record[25] = resultSet.getString("order_line_num");
							record[26] = resultSet.getString("item_narration");
							// Pass the total Number of Records
							record[27] = String.valueOf(total_records);
						}
						else if (report_type.equalsIgnoreCase("X")||report_type.equalsIgnoreCase("S"))
						{
							record[24] = resultSet.getString("catalog_code");
							record[25] = resultSet.getString("order_line_num");
							record[26] = resultSet.getString("item_narration");
							record[27] = resultSet.getString("srl_no");

							// Pass the total Number of Records
							record[28] = String.valueOf(total_records);

						}
						else 
						{
							// Pass the total Number of Records
							record[24] = String.valueOf(total_records);
						}

						resultData.add(record) ;
						start++;
					}
					if (resultSet.next())
					{
						String[] templist = (String[])resultData.get(0);
						if (report_type.equalsIgnoreCase("R")) {
							templist[25] = ""+(end+7);
						}
						else if (report_type.equalsIgnoreCase("C")) {
							templist[27] = ""+(end+7);
						}
						else if (report_type.equalsIgnoreCase("X")||report_type.equalsIgnoreCase("S"))
						{
							templist[28] = ""+(end+7);
						}
						else
						{
							templist[24] = ""+(end+7);
						}
						resultData.set(0,templist);
					}
 			}
		} catch (Exception e) {
            System.out.println("Error loading values from database:"+e.getMessage());
            e.printStackTrace();
		} finally {
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
		}
		return resultData;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			map = reprintForms();
		}catch(Exception e){
			System.out.println("Error in calling the insert method :"+e.getMessage());
            e.printStackTrace();
		}

		return map;
	}

	public HashMap reprintForms() throws Exception {
		HashMap map = new HashMap() ;
		//Hashtable tabDataPrint 	= new Hashtable();
		//OnLinePrinting online_print = new OnLinePrinting(request,response);
	/*	OnLinePrinting online_print = new OnLinePrinting();
		//System.out.println("Before On Line Printing" + online_print);
		// one parameter is to print the order form , another paramater is to print the consent forms
		if (!report_type.equalsIgnoreCase("L")) {
			//Hashtable tabDataPrint 	= new Hashtable();
			int tot_recs	= 0;
			for (int i = 0; i < Integer.parseInt(checkForNull((String)allValues.get("total_recs"),"0"));i++) {
				String checked = checkForNull((String)allValues.get("chk"+i));
				if (checked.equalsIgnoreCase("Y")) {

					tabDataPrint.put("ord_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
					tabDataPrint.put("order_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
					tabDataPrint.put("order_category"+tot_recs,checkForNull((String)allValues.get("ord_cat"+i)));
					//System.out.println("order_category"+tot_recs+":="+checkForNull((String)allValues.get("ord_cat"+i)));
					tabDataPrint.put("patient_class"+tot_recs,checkForNull((String)allValues.get("pat_class"+i)));
					tabDataPrint.put("pat_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
					tabDataPrint.put("patient_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
					tabDataPrint.put("encounter_id"+tot_recs,checkForNull((String)allValues.get("encounter_id"+i)));
					tabDataPrint.put("order_date_time"+tot_recs,checkForNull((String)allValues.get("order_date_time"+i)));
					tabDataPrint.put("catalog_code"+tot_recs,checkForNull((String)allValues.get("catalog_code"+i)));
					tabDataPrint.put("priority"+tot_recs,checkForNull((String)allValues.get("priority"+i)));
					tabDataPrint.put("ord_typ_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
					tabDataPrint.put("order_type_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
					tabDataPrint.put("ord_typ_desc"+tot_recs,checkForNull((String)allValues.get("order_type_desc"+i)));
					tabDataPrint.put("ord_pract_id"+tot_recs,checkForNull((String)allValues.get("ord_pract_id"+i)));
					tabDataPrint.put("order_status"+tot_recs,checkForNull((String)allValues.get("order_status"+i)));
					tabDataPrint.put("order_line_num"+tot_recs,checkForNull((String)allValues.get("order_line_num"+i)));
					tabDataPrint.put("cont_order_ind"+tot_recs,checkForNull((String)allValues.get("cont_order_ind"+i)));
					tabDataPrint.put("facility_id"+tot_recs,checkForNull((String)allValues.get("facility_id"+i)));
					tabDataPrint.put("location_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
					tabDataPrint.put("source_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
					tabDataPrint.put("location_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
					tabDataPrint.put("source_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
					tabDataPrint.put("report_srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));
					tabDataPrint.put("srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));

					tabDataPrint.put("chk"+tot_recs,checkForNull((String)allValues.get("chk"+i)));
					tot_recs++;
				}
			}
			tabDataPrint.put("facility_id",login_facility_id);
			tabDataPrint.put("source_type",checkForNull((String)allValues.get("source_type")));
			tabDataPrint.put("total_recs",""+tot_recs);
			tabDataPrint.put("total_records",""+tot_recs);
			//System.out.println("REPRINT:tot_recs:"+tot_recs);
		}
		if (report_type.equalsIgnoreCase("C")) {
			online_print.callConsentFormOnlineRePrint(tabDataPrint,request,response);
			//online_print.callConsentFormOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		} else if (report_type.equalsIgnoreCase("O")) {
			//allValues.put("order_entry","OrderEntry");
			tabDataPrint.put("order_entry","ExistingOrder");
			online_print.callOnlineRePrint(tabDataPrint,request,response);
            //online_print.callOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		} else if (report_type.equalsIgnoreCase("R")) {
			Hashtable repDataPrint 	= new Hashtable();
			for (int i = 0; i < Integer.parseInt(checkForNull((String)tabDataPrint.get("total_records"),"0"));i++) {
				repDataPrint.clear();
				repDataPrint.put("facility_id",login_facility_id);
				repDataPrint.put("source_type",checkForNull((String)tabDataPrint.get("source_type1")));
				repDataPrint.put("ord_typ_code",checkForNull((String)tabDataPrint.get("ord_typ_code"+i)));
				repDataPrint.put("patient_class",checkForNull((String)tabDataPrint.get("patient_class"+i)));
				repDataPrint.put("priority",checkForNull((String)tabDataPrint.get("priority"+i)));
				repDataPrint.put("ord_id",checkForNull((String)tabDataPrint.get("ord_id"+i)));
				repDataPrint.put("location_code",checkForNull((String)tabDataPrint.get("location_code"+i)));
				repDataPrint.put("report_srl_no",checkForNull((String)tabDataPrint.get("report_srl_no"+i)));

				online_print.reprintResultEntryReport(repDataPrint,request,response); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
			}
            //online_print.printResultEntryReport(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		} else if (report_type.equalsIgnoreCase("L")) {
			//Hashtable tabDataPrint 	= new Hashtable();

			tabDataPrint.put( "total_recs" ,"1");
			tabDataPrint.put("facility_id",login_facility_id);
			tabDataPrint.put("collection_list","");
			tabDataPrint.put("printLocationType",checkForNull((String)allValues.get("source_type1")));
			tabDataPrint.put("printLocation",checkForNull((String)allValues.get("location_code")));

			tabDataPrint.put("date_from",checkForNull((String)allValues.get("date_from")));
			tabDataPrint.put("date_to",checkForNull((String)allValues.get("date_to")));
			tabDataPrint.put("priority","A");
			tabDataPrint.put("location_type",checkForNull((String)allValues.get("location_type")));
			tabDataPrint.put("locn",checkForNull((String)allValues.get("locn2")));
			tabDataPrint.put("locn1",checkForNull((String)allValues.get("locn1")));
			tabDataPrint.put("order_type",checkForNull((String)allValues.get("order_type")));
			tabDataPrint.put("order_type1",checkForNull((String)allValues.get("order_type")));
			tabDataPrint.put("option","R");
			tabDataPrint.put("select_specific_order","A");
			tabDataPrint.put("patientId",checkForNull((String)allValues.get("patient_id")));
			tabDataPrint.put("order_id",checkForNull((String)allValues.get("order_id")));
			tabDataPrint.put("encounter_id",checkForNull((String)allValues.get("encntr_id")));
			online_print.callSpecimenCollectOnLinePrint(tabDataPrint,request,response);
		}else if (report_type.equalsIgnoreCase("X"))
		{
			online_print.callReferralFormOnlinePrint(tabDataPrint,request,response);
		}
		else if (report_type.equalsIgnoreCase("S"))
		{
			online_print.callRefusalFormOnlinePrint(tabDataPrint,request,response);
		}
	*/
		//System.out.println("After On Line Printing");
		//map.put( "message", "APP-OR0148 Report has been Submitted to the Printer" ) ;
		//map.put( "result", new Boolean( false ) ) ;
		//map.put( "flag", "") ;
		//map.put( "callOnSuccess", new Boolean( false ) ) ;
		return map;
	}

	private String replaceQuery(String query,String[] modulesInstalled) {
		if (modulesInstalled.length > 0) {
			query = query + "and a.order_category not in (";
			for(int i = 0; i < modulesInstalled.length; i++) {
				if (i != 0) query = query + ",";
				query = query +"'" + modulesInstalled[i] + "'";
			}
			query = query + ") order by a.ord_date_time desc";
		}
		return query;
	}

	public String getConsentDetails(String order_id, String order_line_num) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
 		ResultSet resultSet 			= null;
		String reprintDetails			= "";
 
		//oracle.sql.CLOB	clob_details	= null;  //Web logic Conversion -- [IN037372]
		java.sql.Clob	clob_details	= null;
     try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_FORMS_CONSENT_FORM_CONTENT") ) ;
			pstmt.setString( 1, order_id);
			pstmt.setString( 2, order_line_num);

			resultSet = pstmt.executeQuery() ;

			if(resultSet.next()){
				clob_details	=	(java.sql.Clob) resultSet.getClob("CONSENT_FORM_CONTENT");
				if(clob_details!=null && clob_details.length() > 0){
					reprintDetails = clob_details.getSubString(1,( (int)clob_details.length() ));
				}
		}
	}
	catch (Exception e) {
            System.out.println("Error loading values from reprint:"+e.getMessage());
            e.printStackTrace();
		} finally {
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
		}
		return reprintDetails;
	}


	public String getConsentDetails(String order_id, String order_line_num,String consent_ref_id) throws Exception 
	{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
 		ResultSet resultSet 			= null;
		String reprintDetails			= "";
 
		//oracle.sql.CLOB	clob_details	= null; //Web logic Conversion -- [IN037372]
		java.sql.Clob clob_details	= null;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_FORMS_CONSENT_FORM_CONTENT") ) ;
			//pstmt = connection.prepareStatement( "SELECT form_content consent_form_content FROM OR_CONSENT_REF_DTL a, OR_CONSENT_REF_HDR b WHERE a.consent_ref_id= ? and a.order_id = ? AND a.order_line_num = ? AND a.TYPE = 'C' AND b.consent_ref_id = a.consent_ref_id AND b.form_id = a.form_id AND DBMS_LOB.getlength (b.form_content) > 0" ) ;
			
			pstmt.setString( 1, consent_ref_id);
			pstmt.setString( 2, order_id);
			pstmt.setString( 3, order_line_num);
			
			resultSet = pstmt.executeQuery() ;

			if(resultSet.next())
			{
				//clob_details	=	(oracle.sql.CLOB) resultSet.getClob("CONSENT_FORM_CONTENT");  //Web logic Conversion -- [IN037372]
				clob_details	=	(java.sql.Clob) resultSet.getClob("CONSENT_FORM_CONTENT");
				if(clob_details!=null && clob_details.length() > 0)
				{
					reprintDetails = clob_details.getSubString(1,( (int)clob_details.length() ));
				}
			}
		}
		catch (Exception e) 
		{
           // System.out.println("Error loading values from reprint:"+e.getMessage());
            e.printStackTrace();
		} 
		finally 
		{
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
		}
		return reprintDetails;
	}

	public String getRefusalDetails(String order_id, String order_line_num, String patient_id, String srl_no) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
 		ResultSet resultSet 			= null;
		String reprintDetails			= "";
 
		//oracle.sql.CLOB	clob_details	= null; //Web logic Conversion -- [IN037372]
		java.sql.Clob	clob_details	= null;
     try {
			connection = getConnection() ;
			if(checkForNull(order_id,"").equals("") && checkForNull(order_line_num,"").equals("")) {
	 			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_FORMS_REFUSAL_FORM_CONTENT") ) ;
				pstmt.setString( 1, order_id);
				pstmt.setString( 2, order_line_num);
			} else {
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_FORMS_REFUSAL_FORM_CONTENT_PATIENT_SRL") ) ;
				pstmt.setString( 1, patient_id);
				pstmt.setString( 2, srl_no);
			}
			
			resultSet = pstmt.executeQuery() ;

			if(resultSet.next()){
				//clob_details	=	(oracle.sql.CLOB) resultSet.getObject("REFUSAL_FORM_CONTENT");  //Web logic Conversion -- [IN037372]
				clob_details	=	(java.sql.Clob) resultSet.getObject("REFUSAL_FORM_CONTENT");
				if(clob_details!=null && clob_details.length() > 0){
					reprintDetails = clob_details.getSubString(1,( (int)clob_details.length() ));
				}
		}
	}
	catch (Exception e) {
            System.out.println("Error loading values from reprint:"+e.getMessage());
            e.printStackTrace();
		} finally {
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
		}
		return reprintDetails;
	}

public String getReferralDetails(String order_id, String order_line_num) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
 		ResultSet resultSet 			= null;
		String reprintDetails			= "";
 
		//oracle.sql.CLOB	clob_details	= null; //Web logic Conversion -- [IN037372]
		java.sql.Clob	clob_details	= null;
     try {
			connection = getConnection() ;
 			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_FORMS_REFERRAL_FORM_CONTENT") ) ;
			pstmt.setString( 1, order_id);
			pstmt.setString( 2, order_line_num);

			resultSet = pstmt.executeQuery() ;

			if(resultSet.next()){
				//clob_details	=	(oracle.sql.CLOB) resultSet.getObject("REFERRAL_FORM_CONTENT");  //Web logic Conversion -- [IN037372]
				clob_details	=	(java.sql.Clob) resultSet.getObject("REFERRAL_FORM_CONTENT"); 
				if(clob_details!=null && clob_details.length() > 0){
					reprintDetails = clob_details.getSubString(1,( (int)clob_details.length() ));
				}
		}
	}
	catch (Exception e) {
            System.out.println("Error loading values from reprint:"+e.getMessage());
            e.printStackTrace();
		} finally {
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
		}
		return reprintDetails;
	}

	public ArrayList getConsents(String order_id,String order_line_num,String order_catalog_code) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList ConsentDtls		= new ArrayList();

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REPRINT_CONSENT_FOR_ORDER") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_id);
			pstmt.setString( 3, order_line_num);
			pstmt.setString( 4, order_catalog_code);

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				record	  = new String[3];
				record[0] = resultSet.getString("form_id");
				record[1] = resultSet.getString("form_label");
				record[2] = resultSet.getString("consent_ref_id");

				ConsentDtls.add(record)  ;
			}
		} catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return ConsentDtls;
	}
}
