/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
13/7/2011     101            Chowminya G    Incident No: IN027622 - <ViewBy Line-issue when displaying future
											orders> 
24/11/2011    IN029659       Chowminya G    Incident No: IN029659 - < System allows to place the new orders using
											Copy Previous Order function- CRF Linked Issue> 
15/02/2012    IN031116		 Menaka V		Functionality equivalent to 5.x, placing consultation order.
22/06/2012    IN033488       Chowminya G    Incident No: IN033488 -  Error Marking - Result completed indicator> 
25/06/2012    IN032733		 Chowminya G	duration 24 hrs - displayed in Continuous frame.
25/06/2012    IN032734		 Chowminya G	duration 60 min - displayed in Continuous frame.
25/06/2012    IN032741		 Chowminya G	Expired Drugs indicator.
23/07/2012	  IN033472		 Nijitha S		System does not display Appointment Reschedule Reason in 
											Existing orders. 
25/09/2012	  IN030279		Ramesh G		Bru-HIMS-CRF-160	
15/11/2012	  IN030472		Ramesh G	Bru-HIMS-CRF-031[Patient instructions to be printed on demand] 										
07/02/2013	  IN029949	  Chowminya G  In the Practitioner Homepage under Orders to include “On Hold Medication” 										
12/02/2013	  IN037898	  	Chowminya G     Pharmacy Orders - On Hold  ->Duplicate Records displayed for Multi Orders 	
15/02/2013	  IN037927	  	Chowminya G     Pharmacy Orders - On Hold ->Query Criteria displayed wrongly 								
08/03/2013    IN038455      Chowminya G     System doesn’t display some pharmacy order status such as dispensed-partial, dispensed- completed - Active
03/04/2013    IN035929 		Karthi L		When user Place in OR/CA, user should not see Service charges.
03/06/2013    IN040462		Chowminya G		Time is not considered, hence drug displayed as Active
05/06/2013    IN029948		Nijitha  S      Bru-HIMS-CRF-082
10/06/2013    IN040462.1	Chowminya G		Time is not considered, hence drug displayed as Active
26/06/2013	  IN039741		Chowminya G		If user gives the catalog as search criteria in existing order, system displays "500-Internal Server error" after clicking on search button.
17/07/2013	  IN033207		NijithaS		Bru-HIMS-CRF-282												 
08/07/2013    IN042115		NijithaS		CRF-Bru-HIMS-CRF-282-33207/01 – CA>Orders>Existing Orders>Performing location is not displayed for the re-routed prescription							 
13/08/2013	  IN042045		Chowminya G	    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
22/08/2013	  IN041931		Vijayakumark	Alpha-OR-System is allowing the user to place disabled Orders through previous Orders and Copy Previous Orders function
21/11/2013	  IN044165		Vijayakumar K	Place an order->complete/discontinue/cancel the placed order->Existing Orders->click on Copy previous orders->System displaying placed Orders short description at orderable column.
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
21/08/2014	IN050648		Karthi		22/8/2014		Akbar				After place medical item, system display medical item in continuous orders.
19/03/2015  IN052649		Ramesh G										Previous orders - Default filter to be filtered by All or by specialty 
03/06/2015	  IN054720		Vijayakumar K	03/06/2015	Ramesh				ML-BRU-SCF-1580 [IN:054720]
09/10/2015	IN055910		Karthi L										From Clinician Access, modified result shall be identified by include “!” in Blue color
21/10/2015	  IN057196		Ramesh G										Recording Of Consent Form
21/10/2015	IN058125		Karthi L										Modified icon is showing for Registration Status.
07/01/2016	IN058790		Karthi L										Exisitng Orders-System displayed internal sever error on click of search button
08/03/2016	IN059490		Karthi L										After placing orders, in Existing order – keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]
09/5/2016	IN058811		Raja S		10/05/2016		Ramesh G			MO-CRF-20107 :National ID to be captured in any orderable (ALL Order Categories) is a national requirement.
22/09/2016	IN061722		Karthi L										 ML-MMOH-SCF-0502 [IN061722]
13/10/2016	IN062072		Raja S											Alpha-CIS-CA- Script error displayed If click on discontinue icon
28/11/2016	IN061958		Ramesh G										Age printing issue in RIS report (In RIS reports age getting print on the based of report print date instead of reporting date)
09/06/2017	IN063816		Krishna Gowtham J	09/06/2017		Ramesh G		GHL-CRF-0445.1		
27/06/2017  	IN064614	Vijayakumar K		27/06/2017		Ramesh G		CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1	
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
20/03/2018  IN066414		Sharanraj			13/04/2018		Ramesh G	 ML-MMOH-CRF-1071	
07/06/2018	IN067651		Raja S				07/06/2018		Ramesh G		GHL-SCF-1338
13/06/2018	IN067964		Sharanraj			13/06/2018		Ramesh G		Select View Order By as “Header” and click on Search button->System not responding								
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
8/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433					
22/08/2018	IN068133		Raja S				22/08/2018		Ramesh G		Alpha-RL-OR-Multi facility - Modified Icon								
17/10/2018	IN067817		sivabagyam	 17/10/2018	        Ramesh G       ML-MMOH-CRF-1198			
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G	MO-CRF-20137.1
28/1/2019	IN069597 		sivabagyam	 28/1/2019	        Ramesh G       CA-Common-Multi Facility Orders
4/02/2019   IN066453        Ramya Maddena   6/02/2019       Ramesh G		ML-BRU-CRF-0491
05/07/2019  IN70884     Ramya Maddena  05/07/2019    Ramesh G           CA-Practitioner Name is not displayed in Order Form of External Orders
21/10/2019	 IN071393		sivabagyam	 21/10/2019        Ramesh G       ML-MMOH-SCF-1369
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
21/02/2020	IN072473	SIVABAGYAM M		21/02/2020		RAMESH G		TBMC-SCF-0168
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
04/08/2020	IN073562	Nijitha S	04/08/2020	Ramesh G	MMS-KH-CRF-0029.4/01
24/09/2020	IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
14/10/2020	IN072542		SIVABAGYAM M	14/10/2020	RAMESH G	CA-GHL-CRF-0558.1-US003/02- View Chart Summary
17/12/2020	11330		Sivabagyam M		17/12/2020		Ramesh G	SKR-SCF-1518 
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
21/10/2021	25188			Prabha			22/10/2021		Ramesh G	Common-ICN-0069
28/02/2022  IN27707         Suji Keerthi.G  28/02/2022      Ramesh G    SKR-CRF-0052 
27/07/2022	26826			Ramesh G	MMS-DM-CRF-0197
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
28/05/2024	        	   HARIHARAN K	28/05/2024		RAMESH G		ML-MMOH-CRF-1617.1
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
-------------------------------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;


import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;


//import eOR.ORRegisterOrder.*;

public class ExistingOrder extends OrAdapter implements java.io.Serializable 
{

	protected Hashtable allValues 		= new Hashtable();
	protected String total_records 		= "";
	protected String view_type 			=  ""; // this is for checking the current encounter or all encounters
	protected String order_category 	= "";
	protected String order_type_code	= "";
	protected String priority 			= "";
	protected String location_type		= "";
	protected String locn 				= "";
	protected String patient_id			= "";
	protected String encntr_id 			= "";
	protected String order_id 			= "";
	protected String date_from 			= "";
	protected String date_to 			= "";
	protected String view_by			= "";
	protected String narration			= "";
	protected ArrayList beanValues		= new ArrayList();
	protected ArrayList copyOrderDetails = null;
	protected String existingQueryString = "";
	//protected ArrayList persistence_details		= new ArrayList();

	//HttpServletRequest request 			= null;
	//HttpServletResponse response 		= null;

	//StringBuffer traceVals 				= new StringBuffer();
	//public String chk 					= "";

	public void setMode(String mode){								this.mode = mode;	}
	public void setTotalRecs(String total_records){				this.total_records = total_records;	}
	public void setViewType(String view_type){		this.view_type = view_type;	}
	public void setOrderCategory(String order_category){		this.order_category = order_category;	}
	public void setOrderType(String order_type_code){		this.order_type_code = order_type_code;	}
	public void setPriority(String priority){							this.priority= priority;	}
	public void setLocationType(String location_type){		this.location_type= location_type;	}
	public void setLocation(String locn){							this.locn = locn;	}
	public void setPatientId(String patient_id){					this.patient_id = patient_id;	}
	public void setEncntrId(String encntr_id){					this.encntr_id = encntr_id;	}
	public void setOrderId(String order_id){						this.order_id= order_id;	}
	public void setDateFrom(String date_from){


	    if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) date_from = "";
				if (!language_id.equals("en")){

		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");/* Thai date validations end 14/02/2007*/
				}
		this.date_from= date_from;	}
	public void setDateTo(String date_to){
		
	   if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) date_to = "";
		
		if (!language_id.equals("en")){
		date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");/* Thai date validations start 14/02/2007*/
		}
		this.date_to= date_to;	}
	public void setViewBy(String view_by){						this.view_by= view_by;	}
	public void setBeanValues(ArrayList beanValues) {
		this.beanValues = beanValues;
	}
	public void setCopyOrderDetails(ArrayList copyOrderDetails) { this.copyOrderDetails = copyOrderDetails;}
	public void setExistingQueryString(String existingQueryString) { this.existingQueryString = existingQueryString;}
	/*public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}*/
	public ExistingOrder()//IN061961 starts
	{
		setSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");
		setSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");  //26826
		
	}//IN061961 ends

	public String getMode(){											return mode;	}
	public String getTotalRecs(){										return total_records;	}
	public String getViewType(){								return view_type;	}
	public String getOrderCategory(){								return order_category;	}
	public String getOrderType(){									return order_type_code;	}
	public String getPriority(){											return priority;	}
	public String getLocationType(){								return location_type;	}
	public String getLocation(){										return locn;	}
	public String getPatientId(){										return patient_id;	}
	public String getEncntrId(){										return encntr_id;	}
	public String getOrderId(){										return order_id;	}
	public String getDateFrom(){										return date_from;	}
	public String getDateTo(){											return date_to;	}
	public String getViewBy(){											return view_by;	}
	public ArrayList getBeanValues() {
		return this.beanValues;
	}

	public ArrayList getCopyOrderDetails() { return this.copyOrderDetails;}
	public String getExistingQueryString() { return this.existingQueryString;}
	/*public ArrayList getDetails(){
			return persistence_details;
	}*/
	//IN072654 Starts
	 HashMap<String, String> druginteractionYN = new HashMap<String,String>();
	 HashMap<String, ArrayList<OrderDrugInteractionVO>> druginteractionDtl = new HashMap<String,ArrayList<OrderDrugInteractionVO>>();
	 
	public HashMap<String, String> getDruginteractionYN() {
		return druginteractionYN;
	}
	public void setDruginteractionYN(HashMap<String, String> druginteractionYN) {
		this.druginteractionYN = druginteractionYN;
	}
	public HashMap<String, ArrayList<OrderDrugInteractionVO>> getDruginteractionDtl() {
		return druginteractionDtl;
	}
	public void setDruginteractionDtl(HashMap<String, ArrayList<OrderDrugInteractionVO>> druginteractionDtl) {
		this.druginteractionDtl = druginteractionDtl;
	}

	//IN072654 Ends

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	/*public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}*/

public ArrayList getOrderStatus(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderStatus = new ArrayList() ;
		String dfltOrdStatus = "";
		PreparedStatement pstmt1 =  null;
		ResultSet resultSet1	= null;
		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt1		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_DFLT_ORD_STAT") ) ;
			resultSet1  = pstmt1.executeQuery() ;

			while ( resultSet1 != null && resultSet1.next() ) {
				dfltOrdStatus = resultSet1.getString( "dflt_in_process_ord_stat" )  ;
			}
			if (dfltOrdStatus == null)
				dfltOrdStatus = "";
		/*} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		}
		finally { */
			
		//	closeConnection(connection) ;
		//}

		//try {
		//	connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_ORDER_STATUS_SELECT") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "order_status_code" )  ;
				record[2] = dfltOrdStatus;

				OrderStatus.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return OrderStatus;
	}


public ArrayList getAllOrderCategory(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			//pstmt.setString(1,language_id);
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;//IN031116
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ORDER BY short_desc") ;//IN031116
			pstmt.setString( 1, language_id);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	/*public String getSysDate () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String currentDate = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate = resultSet.getString("sys_time_sec")  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return currentDate;
	}
	*/

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
	//public ArrayList getSearchDetails(String view_type,String patient_id, String encntr_id, String order_status, String order_by, String catalog,String date_from,String date_to,String order_category,String order_type_code,String search_criteria,String priority,String view_by, String activity_type,String practitioner_type,String elapsed_orders,String sys_cancelled_orders,int start , int end,String responsibility_id,String ca_practitioner_id,String pract_reln_id) throws Exception //IN072542
	public ArrayList getSearchDetails(String view_type,String patient_id, String encntr_id, String order_status, String order_by, String catalog,String date_from,String date_to,String order_category,String order_type_code,String search_criteria,String priority,String view_by, String activity_type,String practitioner_type,String elapsed_orders,String sys_cancelled_orders,int start , int end,String responsibility_id,String ca_practitioner_id,String pract_reln_id,String login_user) throws Exception //IN072542
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
		int cnt						= 0;
	
		String catalog_column_name	= "b.catalog_synonym";  //default
		catalog = catalog.trim();
		String encounter_id = encntr_id;
		String sql					= "";
		String is_lab_installed_yn = ""; // for ML-MMOH-SCF-0502 [IN061722]
		setSiteSpecificYN("BLOOD_ORDERS_ACK"); //IN065091
		setSiteSpecific("RD_PEER_REVIEW_RESTRICT");//IN072542
		boolean restrict_rd	=false;	//IN072542
		restrict_rd=isSiteSpecific("RD_PEER_REVIEW_RESTRICT");//IN072542
		
		String is_bt_installed_yn	= ""; //IN065091
		if(catalog==null)
			catalog	= "";
		// HSA-CRF-0257.1 - IN055910 - Start
		if(order_category == null) 
			order_category = "";
		//HSA-CRF-0257.1 - IN055910 - End
		if(((view_type.trim()).equals("A")) || ((order_status.trim()).equals("F")))
		{ 
			// checking for all encounters
			encntr_id = null;
		}
		else
		{ 
			// checking for current encounter
			encntr_id  = encntr_id .trim();
		}
			/*if(practitioner_type!=null && (practitioner_type.equals("PS") || practitioner_type.equals("DN") || practitioner_type.equals("MD") || practitioner_type.equals("SG") || practitioner_type.equals("NS")) ) 
			{
			catalog_column_name	= "b.catalog_synonym_dc";
			} 		
			else if(practitioner_type!=null && (practitioner_type.equals("RD") || practitioner_type.equals("PT")) )
			{
			catalog_column_name	= "b.catalog_synonym_ad";
			}
			else
			catalog_column_name	= "b.catalog_synonym";Modified by Uma on 6/10/2009 for IN011292*/
		if(practitioner_type!=null && (practitioner_type.equals("PS") || practitioner_type.equals("DN") || practitioner_type.equals("MD") || practitioner_type.equals("SG") || practitioner_type.equals("NS")) ) 
		{
			catalog_column_name            = " nvl(b.catalog_synonym_dc,b.catalog_desc)";
		}  
		else if(practitioner_type!=null && (practitioner_type.equals("RD") || practitioner_type.equals("PT")) )
		{
			catalog_column_name            = " nvl(b.catalog_synonym_ad,b.catalog_desc)";
		}
		else
			catalog_column_name            = "nvl(b.catalog_synonym,b.catalog_desc)";

		try 
		{  
			is_lab_installed_yn = getLabInstalledYN();// for ML-MMOH-SCF-0502 [IN061722]
			is_bt_installed_yn 	= getBTInstalledYN();//IN065091 
			connection = getConnection() ;

			if(order_status.equals("P"))
				order_status = "EXT_PEND_RVS" ;
			else if(order_status.equals("O"))
				order_status = "EXT_OUTSTAND" ;
			else if(order_status.equals("A"))
				order_status = "EXT_ACTIVE" ;
			else if(order_status.equals("F"))
				order_status = "EXT_FUTURE_ORD" ;
			else if(order_status.equals("C"))
				order_status = "EXT_COMPL_ORD" ;
			else if(order_status.equals("D"))
				order_status = "EXT_DISC_CAN" ;
			else if(order_status.equals("H"))
				order_status = "EXT_HOLD" ;
			else if(order_status.equals("Z"))
				order_status = "EXT_ALL" ;
			//IN061903 starts
			else if("N".equals(order_status))
				order_status = "EXT_NOT_DONE";
			//IN061903 ends
			
			if((view_by.trim()).equals("L"))
			{
				//IN030279  Start				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d   WHERE  a.ordeR_id =b.ordER_id and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;
				
				
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN029948
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN029948  //IN039741
				//IN057196 Start.
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN039741
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN039741
				//IN057196 End. // commented for ML-MMOH-SCF-0502 [IN061722]
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ; // modified for ML-MMOH-SCF-0502 [IN061722]
				//IN065091 start
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ; //IN063816
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ; //IN065091 ends//IN065942, commented
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN,(select prn_regd_ord from or_order_catalog where order_catalog_code = b.order_catalog_code)prn_regd_ord,(select contr_msr_panel_id from or_order_catalog where order_catalog_code = b.order_catalog_code)event_code FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN065942		
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN,(select prn_regd_ord from or_order_catalog where order_catalog_code = b.order_catalog_code)prn_regd_ord,nvl(instruction_type,'T')instruction_type FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN64543			
				//IN068986 Start.
				//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN,(select prn_regd_ord from or_order_catalog where order_catalog_code = b.order_catalog_code)prn_regd_ord,nvl(instruction_type,'T')instruction_type,(select contr_msr_panel_id from or_order_catalog where order_catalog_code = b.order_catalog_code)event_code FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN061961				
	//		sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN,(select prn_regd_ord from or_order_catalog where order_catalog_code = b.order_catalog_code)prn_regd_ord,nvl(instruction_type,'T')instruction_type,(select contr_msr_panel_id from or_order_catalog where order_catalog_code = b.order_catalog_code)event_code,b.STATUS_HIPERLINK_YN, (SELECT count(*) interactionDtls  FROM or_order_drug_interaction where order_id=a.order_id and ORDER_LINE_NUM=b.order_line_num and override_reason is not null) interactionDtls,b.billing_status FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!')) &&RESTRICT## &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN061961//IN072654 Added Interaction Override remarks// Added override reason not null condition for IN074110	//added restrict for IN072542				
				//IN068986 End.
			sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num) order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?, ? ,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,ph_get_alternates(A.ORDER_ID, b.ORDER_LINE_NUM) alternates,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, b.barcode_appl, ##BTACKYN## bt_ack_YN,(select prn_regd_ord from or_order_catalog where order_catalog_code = b.order_catalog_code)prn_regd_ord,nvl(instruction_type,'T')instruction_type,(select contr_msr_panel_id from or_order_catalog where order_catalog_code = b.order_catalog_code)event_code,b.STATUS_HIPERLINK_YN, (SELECT count(*) interactionDtls  FROM or_order_drug_interaction where order_id=a.order_id and ORDER_LINE_NUM=b.order_line_num and override_reason is not null) interactionDtls,b.billing_status,or_get_neonate_spec_yn(a.order_id,a.order_type_code,a.order_category,NULL,NULL)lv_neonate_spec_yn,b.APPT_CAN_REASON,b.APPT_CAN_REMARKS,b.APPT_RESCHED_REMARKS FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d ##MOTABLENAME##  WHERE  a.ordeR_id =b.ordER_id ##MOWHERECON## and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##   AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!')) &&RESTRICT## &&FILTER## &&FILTER1## ORDER BY DECODE((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',a.OrdeR_type_code) desc, nvl(a.order_set_id,a.order_id),a.order_id, order_line_num" ;//IN061961//IN072654 Added Interaction Override remarks// Added override reason not null condition for IN074110	//added restrict for IN072542	//31792//ML-MMOH-CRF-1617.1 ADDED b.APPT_CAN_REASON,b.APPT_CAN_REMARKS,b.APPT_RESCHED_REMARKS			

				if(responsibility_id.equals("MO")){
					sql = sql.replace("##MOTABLENAME##"," , or_order_line_mo e");
					sql = sql.replace("##MOWHERECON##"," and a.order_id=e.order_id and b.order_id=e.order_id and b.order_line_num = e.order_line_num");
				}else{
					sql = sql.replace("##MOTABLENAME##","");
					sql = sql.replace("##MOWHERECON##","");
				}
				
				//IN072542 starts
				 if(restrict_rd)
				 {
					 sql =  sql.replace("&&RESTRICT##"," AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.ORDERING_FACILITY_ID,NULL,NULL,'"+login_user+"',b.ORDER_ID,b.order_line_num)='N' ");
				 }
				 else
					 sql =  sql.replace("&&RESTRICT##"," ");
				//IN072542 ENDS
				//IN030279  End.
					//---[101]/end-----
					/*Added by Uma on 4/28/2010 for IN020757*/
					if(!catalog.equals(""))
					{
						//sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##"," AND exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)))");//IN072473
						sql=sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##", "  AND UPPER (or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num)) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))");//IN072473
					}
					else
					{
						sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##"," ");
					}

					/*Ends Here by Uma on 4/28/2010 for IN020757*/
					//sql = sql.replaceAll("'CHANGE_CATALOG_SYNONYM_COLUMN'",catalog_column_name);
					if(order_status.equalsIgnoreCase("EXT_ACTIVE"))
					{
						if(elapsed_orders.equalsIgnoreCase("Y"))
						{
							sql=sql.replace("&&FILTER##"," ");
						}
						else
						{
							sql=sql.replace("&&FILTER##"," AND (b.end_date_time >SYSDATE OR b.end_date_time IS NULL)");
						}
						sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
					}
					else
					{
						if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
						{
							if(sys_cancelled_orders.equalsIgnoreCase("Y"))
							{
								sql =  sql.replace("&&FILTER1##"," ");
							}
							else
							{
								sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
							}
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
						}
						sql=sql.replace("&&FILTER##"," ");
					}
					//IN065091 start
					if("Y".equals(is_bt_installed_yn) && isSiteSpecificYN() && ("".equals(order_category.trim())||("LB".equals(order_category.trim()))))
					{
						sql=sql.replace("##BTACKYN##","GET_BT_ORDERS_ACKNOW_INDICATOR(b.order_id, a.PATIENT_ID, a.SOURCE_CODE, b.ORDER_CATALOG_CODE, b.ORD_DATE_TIME, ?, a.ordering_facility_id)");
					}
					else
					{
						sql=sql.replace("##BTACKYN##","'N'");
					}
					//IN065091 ends

					/* Thai date validations start 14/02/2007*/

					if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) 
						date_from = "";

					if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) 
						date_to = "";

					if (!language_id.equals("en"))
					{
						date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
						date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
					}
				
				/* Thai date validations end 14/02/2007*/	
				pstmt = connection.prepareStatement(sql);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				/*pstmt.setString( 5, language_id);
				pstmt.setString( 6, language_id);*/
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, encounter_id);
				pstmt.setString( ++cnt, ca_practitioner_id);
				pstmt.setString( ++cnt, responsibility_id);								
				pstmt.setString( ++cnt, pract_reln_id);
				pstmt.setString( ++cnt, is_lab_installed_yn); // added for ML-MMOH-SCF-0502 [IN061722]
				pstmt.setString( ++cnt, practitioner_type); // added for ML-MMOH-SCF-0502 [IN061722]
				//IN065091 start
				if("Y".equals(is_bt_installed_yn) && isSiteSpecificYN() && ("".equals(order_category.trim())||("LB".equals(order_category.trim()))))
				{
					pstmt.setString( ++cnt, language_id) ;
				}
				//IN065091 ends
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				pstmt.setString( ++cnt, patient_id.trim() ) ;
				pstmt.setString( ++cnt, encntr_id ) ;				
				pstmt.setString( ++cnt, date_from.trim() ) ;				
				pstmt.setString( ++cnt, date_to.trim() ) ;				
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_category.trim() ) ;
				pstmt.setString( ++cnt, order_type_code.trim() ) ;
				pstmt.setString( ++cnt, priority.trim() ) ;
				/*Added by Uma on 4/28/2010 for IN020757*/
				if(!catalog.equals(""))
				{
					pstmt.setString( ++cnt, language_id);
					pstmt.setString( ++cnt, practitioner_type);//IN072473
					pstmt.setString( ++cnt, search_criteria.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
				}
				/*Ends Here by Uma on 4/28/2010 for IN020757*/
				/*Commented by Uma for the IN025796
				pstmt.setString( ++cnt, date_from.trim() ) ;
				pstmt.setString( ++cnt, date_to.trim() ) ;
				Ends Here*/
				pstmt.setString( ++cnt, activity_type.trim() ) ;
				pstmt.setString( ++cnt, order_by.trim() ) ;
			}
			else if(catalog.equals(""))
			{
				if(order_status.equals("F"))
					order_status = "EXT_FUTURE_ORD_WITHOUTCATALOG" ;

				/* Thai date validations start 14/02/2007*/

				if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) 
					date_from = "";
				
				if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) 
					date_to = "";

				if (!language_id.equals("en"))
				{
				  	date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
					date_to = com.ehis.util.DateUtils.convertDate(date_to ,"DMY",language_id,"en");
				}

				/* Thai date validations end 14/02/2007*/
					//IN054720 starts
					//sql ="SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date  FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)";
					//sql ="SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date, a.performing_facility_id performing_facility_id  FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // commented for HSA-CRF-0257.1 - IN055910
					//IN054720 ends
					//IN057196 Start.
					//sql ="SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date, a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for HSA-CRF-0257.1 - IN055910
					//sql ="SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for HSA-CRF-0257.1 - IN055910
					//IN057196 End. // commented for ML-MMOH-SCF-0502 [IN061722]
				/*IN066414 starts*/
	//				sql ="SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.appt_resched_yn, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?, ? , ?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for ML-MMOH-SCF-0502 [IN061722]
				//sql ="SELECT (select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time,(select item_narration from or_order_line where order_id=a.order_id and rownum=1)item_narration,a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?, ? , ?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for ML-MMOH-SCF-0502 [IN061722]
				//sql ="SELECT (select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time,(select item_narration from or_order_line where order_id=a.order_id and rownum=1)item_narration,a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,RL_NOTIFY_DTLS_YN(a.modified_facility_id,a.order_id) lab_details,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?, ? , ?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for IN067817
				sql ="SELECT (select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time,(select item_narration from or_order_line where order_id=a.order_id and rownum=1)item_narration,a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,RL_NOTIFY_DTLS_YN(a.performing_facility_id,a.order_id) lab_details,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?, ? , ?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id &&ACCESSION_NO##,or_get_neonate_spec_yn(a.order_id,a.order_type_code,a.order_category,NULL,NULL)lv_neonate_spec_yn FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&RESTRICT## &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id)"; // modified for IN069597//IN072654
			//	sql ="SELECT (select appt_ref_num from or_order_line where order_id=a.order_id and rownum=1)appt_ref_num,(select appt_locn from or_order_line where order_id=a.order_id and rownum=1)appt_locn,(select TO_CHAR(appt_date_time,'DD/MM/YYYY HH24:MI') from or_order_line where order_id=a.order_id and rownum=1)appt_date_time,(select item_narration from or_order_line where order_id=a.order_id and rownum=1)item_narration,a.order_category order_category,or_get_desc.or_order_category(a.order_category, ?, '2' ) order_category_short_desc, DECODE (NVL (a.priority, 'R'),'U', 'Urgent', 'S', 'Stat','R', 'Routine') priority_desc,am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class,a.order_id order_id, A.patient_id, A.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,         or_get_order_catalog (a.order_id, a.order_type_code,?, ?) order_detail,source_type, source_code, a.priority priority,a.order_type_code order_type_code,or_get_desc.or_order_type (order_type_code,?,'2' ) order_type_short_desc,         a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,order_status,RL_NOTIFY_DTLS_YN(a.performing_facility_id,a.order_id) lab_details,or_get_desc.or_order_status_code (a.order_status,?, '2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.can_reason can_reason,or_get_existing_order_opern(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,NVL (a.cont_order_ind, 'DO'),           order_status,NULL,NULL,NULL,NULL,?,?,?,?, ? , ?) display_popupmenu,a.source_type source_type, a.source_code source_code,NVL (a.cont_order_ind, 'DO') cont_order_ind, a.iv_prep_yn iv_prep_yn,(SELECT 'Y'            FROM or_order_status_code WHERE order_status_code = a.order_status  AND order_status_type IN         ('55','58','60', '93', '80', '85', '90', '96','99'))  copy_yn,or_order_line_ph_color (a.ordering_facility_id,a.order_id,       '',1) ph_colors,(SELECT DECODE (SUM (  NVL (num_of_consent_req_bo, 0)+ NVL (num_of_consent_req_br, 0)),0, 'N','Y') FROM or_order_line  WHERE order_id = a.order_id) consent_req_yn,a.order_set_id order_set_id,(select billing_package_ref from or_order_line  WHERE order_id = a.order_id AND ROWNUM=1) billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn, a.performing_facility_id performing_facility_id, (SELECT count(*) interactionDtls  FROM or_order_drug_interaction where order_id=a.order_id) interactionDtls &&ACCESSION_NO## FROM or_order  a   WHERE A.patient_id = (?) AND NVL(A.encounter_id, 0) =  NVL ((?), NVL (A.encounter_id, 0))     AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR')  AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability                   WHERE oper_or_group_ref = ?))     AND (   (    'EXT_FUTURE_ORD' = ?   and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.future_order_yn='Y') )  OR 'EXT_FUTURE_ORD' != ?) AND a.order_category IN (SELECT order_category FROM or_order_category ic WHERE ic.order_category = NVL (?, ic.order_category))  AND a.order_type_code = NVL ((?), a.order_type_code) AND a.priority = NVL ((?), a.priority)     AND a.ord_date_time BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'), 'dd/mm/yyyy')+ .999 &&FILTER## &&FILTER1## ORDER BY DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', order_category_short_desc, 'T', order_type_short_desc) DESC, nvl(a.order_set_id,a.order_id),a.order_id"; // modified for IN071393///IN072654//IN072542
				//IN072542 starts
				 if(restrict_rd)
				 {
					 sql =  sql.replace("&&RESTRICT##"," AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.ORDERING_FACILITY_ID,NULL,NULL,'"+login_user+"',A.ORDER_ID,NULL)='N' ");
				 }
				 else
					 sql =  sql.replace("&&RESTRICT##"," ");
				//IN072542 ENDS
				if(order_status.equalsIgnoreCase("EXT_ACTIVE"))
				{
					if(elapsed_orders.equalsIgnoreCase("Y"))
					{
						sql =  sql.replace("&&FILTER##"," ");
						sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
					}
					else
					{
						//sql=sql.replace("&&FILTER##"," and exists(select 1 from or_order_line  where order_id=a.order_id AND (end_date_time>SYSDATE OR end_date_time IS NULL))");
						sql=sql.replace("&&FILTER##"," AND EXISTS (SELECT b.order_line_num FROM or_order_line b WHERE a.order_id = b.order_id AND b.cancelled_by_sys_yn != 'Y' AND (end_date_time > SYSDATE OR end_date_time IS NULL))");
						sql =  sql.replace("&&FILTER1##"," ");
					} 
				}
				else
				{	
					if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
					{
						if(sys_cancelled_orders.equalsIgnoreCase("Y"))
						{
							sql =  sql.replace("&&FILTER1##"," ");
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
						}
					}
					else
					{
						sql =  sql.replace("&&FILTER1##"," and exists (select b.order_line_num from or_order_line b where a.order_id = b.order_id and b.Cancelled_by_sys_yn!='Y') ");
					}
					sql=sql.replace("&&FILTER##"," ");
				}				
				sql = sql.replace("&&ACCESSION_NO##", ",( select accession_num from or_order_line where  order_id = a.order_id and rownum =1) accession_num "); // added for HSA-CRF-0257.1 - IN055910
				pstmt = connection.prepareStatement(sql); 
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, encounter_id);
				pstmt.setString( ++cnt, ca_practitioner_id);
				pstmt.setString( ++cnt, responsibility_id);
				pstmt.setString( ++cnt, pract_reln_id);
				pstmt.setString( ++cnt, is_lab_installed_yn); // added for ML-MMOH-SCF-0502 [IN061722]
				pstmt.setString( ++cnt, practitioner_type); // added for ML-MMOH-SCF-0502 [IN061722]
				pstmt.setString( ++cnt, patient_id.trim() ) ;
				pstmt.setString( ++cnt, encntr_id ) ;
				//	pstmt.setString( 12, date_from.trim() ) ;
				//	pstmt.setString( 13, date_to.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_category.trim() ) ;
				pstmt.setString( ++cnt, order_type_code.trim() ) ;
				pstmt.setString( ++cnt, priority.trim() ) ;
				pstmt.setString( ++cnt, date_from.trim() ) ;
				pstmt.setString( ++cnt, date_to.trim() ) ;
				pstmt.setString( ++cnt, order_by.trim() ) ;				
			}
			else
			{
				//sql ="SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code) /*AND OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?,b.order_line_num) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))*/ and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";  //IN039741
				//IN054720 starts
				//sql ="SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";  //IN039741
				//sql ="SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,a.performing_facility_id performing_facility_id FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";  //IN039741 -- commented for HSA-CRF-0257.1 - IN055910
				//IN054720 ends
				//IN057196 Start.
				//sql ="SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";  //modified for HSA-CRF-0257.1 - IN055910 
				//sql ="SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";  //modified for HSA-CRF-0257.1 - IN055910
				//IN057196 End. // commented for ML-MMOH-SCF-0502 [IN061722]
				//sql ="Select a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)"; // modified for  ML-MMOH-SCF-0502 [IN061722],commented for IN067964
				//IN067817 Start.
				//sql ="SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,b.appt_ref_num,b.appt_locn,TO_CHAR(b.appt_date_time,'DD/MM/YYYY HH24:MI')appt_date_time,b.item_narration,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)"; //Added for IN067964
				//sql ="SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,b.appt_ref_num,b.appt_locn,TO_CHAR(b.appt_date_time,'DD/MM/YYYY HH24:MI')appt_date_time,b.item_narration,RL_NOTIFY_DTLS_YN(a.modified_facility_id,a.order_id) lab_details,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";//IN067817
				//sql ="SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,b.appt_ref_num,b.appt_locn,TO_CHAR(b.appt_date_time,'DD/MM/YYYY HH24:MI')appt_date_time,b.item_narration,RL_NOTIFY_DTLS_YN(a.performing_facility_id,a.order_id) lab_details,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code)  and exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";//IN069597//IN072473
				//IN072473 Start.  
				sql ="SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,b.appt_ref_num,b.appt_locn,TO_CHAR(b.appt_date_time,'DD/MM/YYYY HH24:MI')appt_date_time,b.item_narration,RL_NOTIFY_DTLS_YN(a.performing_facility_id,a.order_id) lab_details,a.performing_facility_id performing_facility_id &&ACCESSION_NO##,or_get_neonate_spec_yn(a.order_id,a.order_type_code,a.order_category,NULL,NULL)lv_neonate_spec_yn FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code) AND UPPER (or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num)) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999 &&RESTRICT## &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";//IN069597//IN072473//IN072542
				//sql ="SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,       am_get_desc.am_patient_class (patient_class,  ?,'2') patient_class_short_desc,patient_class ,a.order_id order_id,a.patient_id,a.encounter_id,a.episode_id,a.episode_visit_num,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?,?)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1'))  ordering_pract_name,order_status,OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason  can_reason,OR_GET_EXISTING_ORDER_OPERN(a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(a.cont_order_ind,'DO'),order_status,null,null,null,null,?,?,?,?,?, ?) display_popupmenu,     a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind,a.iv_prep_yn iv_prep_yn,(select 'Y' from dual where (order_status) in (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','96','99'))) copy_yn,OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,'',1) ph_colors, (SELECT DECODE(SUM(NVL(NUM_OF_CONSENT_REQ_BO,0)+NVL(NUM_OF_CONSENT_REQ_BR,0)),0,'N','Y') FROM or_order_line WHERE order_id=a.order_id) consent_Req_Yn,a.order_set_id order_set_id,b.billing_package_ref billing_package_ref,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY') order_date,nvl((select 'N' from or_order_pend_status_log where pend_status_ind='PC' and order_id =a.order_id ),'Y') consent_rec_yn,b.appt_ref_num,b.appt_locn,TO_CHAR(b.appt_date_time,'DD/MM/YYYY HH24:MI')appt_date_time,b.item_narration,RL_NOTIFY_DTLS_YN(a.performing_facility_id,a.order_id) lab_details,a.performing_facility_id performing_facility_id &&ACCESSION_NO## FROM or_order a,or_order_line b WHERE a.order_id = b.order_id and b.order_line_num = 1 and a.patient_id = (?) AND nvl(a.encounter_id,0)= NVL((?),nvl(a.encounter_id,0)) AND nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR')           AND  TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy')         AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')     AND order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? AND exists (select 'X' from or_order_line where order_id = a.order_id and (b.future_order_yn='Y')) ) or 'EXT_FUTURE_ORD' != ? )  AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category))  AND a.order_type_code = NVL((?),a.order_type_code) AND UPPER (or_get_order_catalog (a.order_id, a.order_type_code,?, ?)) like DECODE ((?),'S','('||upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)||')') and a.priority=nvl((?),a.priority) AND  a.ord_date_time BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999  &&FILTER## &&FILTER1## ORDER BY decode((?),'D',to_char(a.Ord_Date_time,'YYYYMMDDHH24MISS'),'O',A.order_category,'T',order_type_short_desc) desc, nvl(a.order_set_id,a.order_id)";
				//IN072473 End.
				//IN067817 End.
				//IN072542 starts
				 if(restrict_rd)
				 {
					 sql =  sql.replace("&&RESTRICT##"," AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.ORDERING_FACILITY_ID,NULL,NULL,'"+login_user+"',A.ORDER_ID,NULL)='N' ");
				 }
				 else
					 sql =  sql.replace("&&RESTRICT##"," ");
				//IN072542 ENDS
				if(order_status.equalsIgnoreCase("EXT_ACTIVE"))
				{
					if(elapsed_orders.equalsIgnoreCase("Y"))
					{
						sql=sql.replace("&&FILTER##"," ");
					}
					else
					{
						sql=sql.replace("&&FILTER##"," AND (b.end_date_time >SYSDATE OR b.end_date_time IS NULL)");
					}
					sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
				}
				else
				{
					if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
					{
						if(sys_cancelled_orders.equalsIgnoreCase("Y"))
						{
							sql =  sql.replace("&&FILTER1##"," ");
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
						}
					}
					else
					{
						sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
					}
					sql=sql.replace("&&FILTER##"," ");
				}
				/* Thai date validations start 14/02/2007*/
				if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) 
					date_from = "";

				if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) 
					date_to = "";

				if (!language_id.equals("en"))
				{
					date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
					date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
				}
				sql = sql.replace("&&ACCESSION_NO##", ",( select accession_num from or_order_line where  order_id = a.order_id and rownum =1) accession_num "); // added for HSA-CRF-0257.1 - IN055910
				pstmt = connection.prepareStatement(sql);
  				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, encounter_id) ;
				pstmt.setString( ++cnt, ca_practitioner_id);
				pstmt.setString( ++cnt, responsibility_id);
				pstmt.setString( ++cnt, pract_reln_id);
				pstmt.setString( ++cnt, is_lab_installed_yn); // added for ML-MMOH-SCF-0502 [IN061722]
				pstmt.setString( ++cnt, practitioner_type); // added for ML-MMOH-SCF-0502 [IN061722]
				pstmt.setString( ++cnt, patient_id.trim() ) ;
				pstmt.setString( ++cnt, encntr_id ) ;
				pstmt.setString( ++cnt, date_from.trim() ) ;
				pstmt.setString( ++cnt, date_to.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_category.trim() ) ;
				pstmt.setString( ++cnt, order_type_code.trim() ) ;
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);//IN072473
				pstmt.setString( ++cnt, search_criteria.trim() ) ;
				pstmt.setString( ++cnt, catalog.trim() ) ;
				pstmt.setString( ++cnt, catalog.trim() ) ;
				pstmt.setString( ++cnt, catalog.trim() ) ;
				pstmt.setString( ++cnt, priority.trim() ) ;
				pstmt.setString( ++cnt, date_from.trim() ) ;
				pstmt.setString( ++cnt, date_to.trim() ) ;
				//pstmt.setString( 17, activity_type.trim() ) ;
				pstmt.setString( ++cnt, order_by.trim() ) ;				
			}

			resultSet = pstmt.executeQuery() ;			

			if(resultSet!=null) 
			{
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);

				while ( start <= end && resultSet!=null && resultSet.next()) 
				{
				   	String[] record;

					if((view_by.trim()).equals("L"))
					{
						//record = new String[71];//IN029948
						//record = new String[72];//IN029948 //IN057196
						//record = new String[73];//IN057196 //IN063816
						//record = new String[74];//IN063816 //IN065091
						//record = new String[75];//IN065091//IN065942, commented
						//record = new String[76];//IN065942//IN64543
						//record = new String[77];//IN64543
						//record = new String[78];//IN061961
						//record = new String[79];//IN068986//IN072654
						//record = new String[80];//IN072654
					//	record = new String[81];//19112
					//	record = new String[82];//19112//31792
						record = new String[85];//ML-MMOH-CRF-1617.1
					}
					else
					{
						//IN054720 starts
						//record = new String[60];
						//IN057196 Start.
						//record = new String[61];
						/*IN066414 starts*/
						//record = new String[62];
						//record = new String[63];//Commented for IN067670
						/*IN066414 ends*/
						//IN057196 End.
						//IN054720 ends
					//	record = new String[64];//Modified for IN067817
						record = new String[65];//Modified for IN067817//31792
						
					}

					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "order_category_short_desc" )  ;
					record[2] = resultSet.getString( "priority_desc" )  ;
					record[3] = resultSet.getString( "order_detail" )  ;
					record[4] = resultSet.getString( "order_type_code" )  ;
					record[5] = resultSet.getString( "ordering_pract_name" )  ;
					record[6] = resultSet.getString( "order_status_short_desc" )  ;
					record[7] = resultSet.getString( "order_date_time" )  ;
					record[8] = resultSet.getString( "order_type_short_desc" )  ;
					record[9] = resultSet.getString( "order_id" )  ;
					record[10] = resultSet.getString( "priority" )  ;

					if((view_by.trim()).equals("L"))
					{
						record[11] = resultSet.getString( "order_line_num" )  ;
						record[12] = resultSet.getString( "order_catalog_code" )  ;
						record[13] = resultSet.getString( "item_narration" )  ;
						record[14] = resultSet.getString( "order_status" )  ;
						record[15] = resultSet.getString( "display_popupmenu" )  ;
						record[16] = "";	//resultSet.getString( "discontinue_yn" )  ;
						record[17] = "";	//resultSet.getString( "result_hyperlink_yn" )  ;
						record[18] = resultSet.getString( "source_type" )  ;
						record[19] = resultSet.getString( "source_code" )  ;
						record[20] = resultSet.getString( "patient_class" )  ;
						record[21] = resultSet.getString( "cont_order_ind" )  ;
						record[22] = "";			 //resultSet.getString( "hold_yn" )  ;
						record[23] = "";			//resultSet.getString( "resume_yn" )  ;
						record[24] = resultSet.getString("can_line_reason");
						record[25] = resultSet.getString("iv_prep_yn");
						record[26] = "";			//resultSet.getString( "renew_yn" )  ;
						record[27] = resultSet.getString( "start_date_time" )  ;
						record[28] = resultSet.getString( "end_date_time" )  ;
						record[29] = "";			//resultSet.getString( "amend_yn" )  ;
						record[30] = checkForNull(resultSet.getString( "copy_yn" ),"")  ;
						record[31] = resultSet.getString( "can_date_time" )  ;
						record[32] = resultSet.getString( "can_pract_id" )  ;
						record[33] = resultSet.getString( "disc_date_time" )  ;
						record[34] = resultSet.getString( "disc_pract_id" )  ;
						record[35] = resultSet.getString( "last_action_reason_desc" )  ;
						record[36] = resultSet.getString( "ph_colors" )  ;
						record[37] = resultSet.getString( "can_line_reason" )  ;
						record[38] = resultSet.getString( "can_pract_id" )  ;
						record[39] = resultSet.getString( "can_date_time" )  ;
						record[40] = resultSet.getString( "disc_pract_id" )  ;
						record[41] = resultSet.getString( "disc_date_time" )  ;
						record[42] = resultSet.getString( "hold_pract_id" )  ;	
						record[43] = resultSet.getString( "hold_date_time" )  ;
						record[44] = resultSet.getString( "last_action_reason_desc" )  ;
						record[45] = resultSet.getString( "appt_date_time" )  ;	
						record[46] = resultSet.getString( "appt_ref_num" )  ;
						record[47] = resultSet.getString( "order_catalog_nature" )  ;
						record[48] = resultSet.getString( "sec_order_yn" )  ;
						record[49] = resultSet.getString( "pri_order_id" )  ;
						record[50] = resultSet.getString( "appt_locn" )  ;
						record[51] = resultSet.getString( "appt_resched_yn" )  ;
						record[52] = resultSet.getString( "appt_resched_reason" )  ;
						record[53] = resultSet.getString( "no_of_reschedules" )  ;
						record[54] = resultSet.getString( "appt_reqd_yn" )  ;
						record[55] = resultSet.getString( "notify_yn" )  ;
						record[56] = resultSet.getString( "last_action_type" )  ;
						record[57] = resultSet.getString( "accession_num" )  ;
						record[59] = resultSet.getString( "catalog_synonym" )  ;
						record[60] = resultSet.getString( "ord_consent_reqd_yn" )  ;
						record[61] = resultSet.getString( "order_set_id" )  ;
						record[62] = resultSet.getString( "performing_facility_id" )  ;
						record[63] = ""; //Link to Current Encounter
						record[64] = resultSet.getString( "ext_appl_accession_num"); //Ext Appl Accession No
						record[65] = ""; //View Replaced Order
						record[66] = ""; //View Cancelled Order
						record[67] =  resultSet.getString( "billing_package_ref" )  ;//Added by Uma on 4/15/2010 for package billing
						record[68] =  "";//Replace for package billing
						// Pass the total Number of Records
						//record[58] = String.valueOf(total_records);
						record[69] =  resultSet.getString( "order_date" )  ;
						record[70] =  resultSet.getString( "alternates" )  ;//IN029948
						record[71] =  resultSet.getString( "consent_rec_yn" ); //IN057196
						record[72] =  resultSet.getString( "barcode_appl" ); //IN063816
						record[73] =  resultSet.getString( "bt_ack_YN" ); //IN065091
						record[74] =  resultSet.getString( "prn_regd_ord" );//IN065942
						record[75] =  resultSet.getString( "instruction_type" );//IN64543
						record[76] =  resultSet.getString( "event_code" );//IN061961
						record[77] =  resultSet.getString( "STATUS_HIPERLINK_YN" );//IN068986
						record[78] =  resultSet.getString( "interactionDtls" );//IN072654
						record[79] = resultSet.getString( "billing_status" ); //19112
						record[81] = resultSet.getString( "lv_neonate_spec_yn" );//31792
						record[82] = resultSet.getString( "APPT_CAN_REASON" );//ML-MMOH-CRF-1617.1
						record[83] = resultSet.getString( "APPT_CAN_REMARKS" );//ML-MMOH-CRF-1617.1
						record[84] = resultSet.getString( "APPT_RESCHED_REMARKS" );//ML-MMOH-CRF-1617.1
	
		
					}
					else
					{
						record[11] = resultSet.getString( "can_reason" )  ;
						record[12] = resultSet.getString( "display_popupmenu" )  ;
						record[13] = resultSet.getString( "order_status" )  ;
						record[14] = "";//resultSet.getString( "result_hyper_link" )  ;
						record[15] = "";//resultSet.getString( "discontinue_yn" ) ;
						record[16] = resultSet.getString( "source_type" )  ;	
						record[17] = resultSet.getString( "source_code" )  ;
						record[18] = resultSet.getString( "patient_class" )  ;
						record[19] = resultSet.getString( "cont_order_ind" )  ;
						record[20] = "";//resultSet.getString( "hold_yn" )  ;
						record[21] = "";//resultSet.getString( "resume_yn" )  ;
						record[22] = resultSet.getString( "iv_prep_yn" )  ;
						record[23] = "";//resultSet.getString( "renew_yn" )  ;
						record[24] = checkForNull(resultSet.getString( "copy_yn" ),"")  ;
						record[25] = resultSet.getString( "ph_colors" )  ;
						record[26] = "";//	resultSet.getString( "can_line_reason" )  ;	
						record[27] = "";//	resultSet.getString( "can_pract_id" )  ;		
						record[28] = "";//	resultSet.getString( "can_date_time" )  ;		
						record[29] = "";//	resultSet.getString( "disc_pract_id" )  ;		
						record[30] = "";//	resultSet.getString( "disc_date_time" )  ;		
						record[31] = "";//	resultSet.getString( "hold_pract_id" )  ;		
						record[32] = "";//	resultSet.getString( "hold_date_time" )  ;		
						record[33] = ""; //	resultSet.getString( "last_action_reason_desc");
						/*IN066414 starts*/
//						record[34] = "";//	resultSet.getString( "appt_date_time" )  ;		
//						record[35] = "";//	resultSet.getString( "appt_ref_num" )  ;
						record[34] = resultSet.getString( "appt_date_time" );		
						record[35] = resultSet.getString( "appt_ref_num" );  
						/*IN066414 ends*/
						record[36] = "";//	resultSet.getString( "order_catalog_nature")  ;
						record[37] = "";//	resultSet.getString( "sec_order_yn" )  ;		
						record[38] = "";//	resultSet.getString( "pri_order_id" )  ; 
						/*IN066414 starts*/
//						record[39] = "";//	resultSet.getString( "appt_locn" )  ;
						record[39] = resultSet.getString( "appt_locn" );
						/*IN066414 ends*/
						record[40] = "";//	resultSet.getString( "appt_resched_yn" )  ;	
						record[41] = "";//	resultSet.getString( "appt_resched_reason" )  ;
						record[42] = "";//	resultSet.getString( "no_of_reschedules" )  ;	
						record[43] = "";//	resultSet.getString( "appt_reqd_yn" )  ;		
						record[44] = "";//	resultSet.getString( "start_date_time" )  ;	
						record[45] = "";//	resultSet.getString( "catalog_code" )  ;		
						record[46] = "";//	resultSet.getString( "notify_yn" )  ;			
						record[47] = "";//	resultSet.getString( "last_action_type" )  ;	
						//record[48] = "";//	resultSet.getString( "accession_num" )  ; -- commented for HSA-CRF-0257.1 - IN055910 		
						//HSA-CRF-0257.1 - IN055910 - Start
						if(order_category.equals("LB") || resultSet.getString( "order_category" ).equals("LB")) {
							record[48] = resultSet.getString( "accession_num" );
						} else {
							record[48] = ""; 	
						}
						// HSA-CRF-0257.1 - IN055910 - End
						record[50] = resultSet.getString( "consent_Req_Yn" )  ; //Consent required Flag	
						record[51] = resultSet.getString( "order_set_id" )  ; //Consent required Flag	
						record[52] = ""; //Link to Current Encounter
						record[53] = ""; //View Replaced Order
						record[54] = ""; //View Original Order
						record[55] = resultSet.getString( "billing_package_ref" )  ;//Added by Uma on 4/15/2010 for package billing
						record[56] = "";//Replace for package billing 
						// Pass the total Number of Records
						//record[49] = String.valueOf(total_records);
						record[57] =  resultSet.getString( "order_date" )  ;
						record[60] =  resultSet.getString( "performing_facility_id" )  ; //IN054720
						record[61] =  resultSet.getString( "consent_rec_yn" ); //IN057196
						record[62] =  resultSet.getString( "item_narration" ); //IN066414
						record[63] =  resultSet.getString( "lab_details" ); //IN067817
						record[64] = resultSet.getString( "lv_neonate_spec_yn" );//31792
						
					}

					OrderCat.add(record) ;
					start++;
				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					if((view_by.trim()).equals("L"))
					{
						//templist[70] = ""+(end+7);//IN029948
						//templist[71] = ""+(end+7);//IN029948 //IN057196
						//templist[72] = ""+(end+7);//IN057196 //IN063816
						//templist[73] = ""+(end+7);//IN063816 //IN065091
						//templist[74] = ""+(end+7);//IN065091//IN065942, commented
						//templist[75] = ""+(end+7);//IN065942//IN64543
						//templist[76] = ""+(end+7);//IN64543//IN061961
						//IN068986 Start.
						//templist[77] = ""+(end+7);//IN061961
						//templist[78] = ""+(end+7);//IN073562
						//templist[79] = ""+(end+7);//IN073562
						//IN068986 End.
						templist[80] = ""+(end+7);//19112
					}
					else
					{
						templist[58] = ""+(end+7);
					}
					OrderCat.set(0,templist);
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
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}

	public ArrayList getOrderSetSearchDetails(String view_type,String patient_id, String encntr_id, String order_status, String catalog,String date_from,String date_to,String order_category,String order_type_code,String search_criteria,String priority,String view_by, String orderId,String practitioner_type) throws Exception {		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		catalog = catalog.trim();

		//thai date converton starts

			if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) date_from = "";
            if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) date_to = "";
					if (!language_id.equals("en")){

             date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
             date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
			}

		//Thai DateConversion ends

		if(((view_type.trim()).equals("A")) || ((order_status.trim()).equals("F"))){ // checking for all encounters
			encntr_id = null;
		}else{ // checking for current encounter
			encntr_id  = encntr_id .trim();
		}

		try {
			connection = getConnection() ;

			if(order_status.equals("P"))
				order_status = "EXT_PEND_RVS" ;
			else if(order_status.equals("O"))
				order_status = "EXT_OUTSTAND" ;
			else if(order_status.equals("A"))
				order_status = "EXT_ACTIVE" ;
			else if(order_status.equals("F"))
				order_status = "EXT_FUTURE_ORD" ;
			else if(order_status.equals("C"))
				order_status = "EXT_COMPL_ORD" ;
			else if(order_status.equals("D"))
				order_status = "EXT_DISC_CAN" ;
			else if(order_status.equals("H"))
				order_status = "EXT_HOLD" ;
			else if(order_status.equals("Z"))
				order_status = "EXT_ALL" ;


			if((view_by.trim()).equals("L")){
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_ORDER_SET_LINE_LEVEL") ) ;
                
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5,language_id);
				pstmt.setString( 6,language_id);
				pstmt.setString( 7,language_id);
				pstmt.setString( 8, orderId.trim() ) ;
				pstmt.setString( 9, patient_id.trim() ) ;
				pstmt.setString( 10, encntr_id ) ;
				pstmt.setString( 11, date_from.trim() ) ;
				pstmt.setString( 12, date_to.trim() ) ;
				pstmt.setString( 13, order_status.trim() ) ;
				pstmt.setString( 14, order_status.trim() ) ;
				pstmt.setString( 15, order_status.trim() ) ;
			/*	pstmt.setString( 15, order_status.trim() ) ;
				pstmt.setString( 16, order_status.trim() ) ;
				pstmt.setString( 17, order_status.trim() ) ;
				pstmt.setString( 18, order_status.trim() ) ;
				pstmt.setString( 19, order_status.trim() ) ; */
				pstmt.setString( 16, order_category.trim() ) ;
				pstmt.setString( 17, order_type_code.trim() ) ;
				pstmt.setString( 18, priority.trim() ) ;
				pstmt.setString( 19, search_criteria.trim() ) ;
				pstmt.setString( 20, catalog.trim() ) ;
				pstmt.setString( 21, catalog.trim() ) ;
				pstmt.setString( 22, catalog.trim() ) ;
			}else  {
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_ORDER_SET_RSLT") ) ;
				
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,practitioner_type);
				pstmt.setString( 5,language_id);
				pstmt.setString( 6,language_id);
				pstmt.setString( 7,language_id);
				pstmt.setString( 8,language_id);
				pstmt.setString( 9, orderId.trim() ) ;
				pstmt.setString( 10, patient_id.trim() ) ;
				pstmt.setString( 11, encntr_id ) ;
                pstmt.setString( 12, date_from.trim() ) ;
				pstmt.setString( 13, date_to.trim() ) ;
				pstmt.setString( 14, order_status.trim() ) ;
				pstmt.setString( 15, order_status.trim() ) ;
				pstmt.setString( 16, order_status.trim() ) ;
			/*	pstmt.setString( 15, order_status.trim() ) ;
				pstmt.setString( 16, order_status.trim() ) ;
				pstmt.setString( 17, order_status.trim() ) ;
				pstmt.setString( 18, order_status.trim() ) ;
				pstmt.setString( 19, order_status.trim() ) ; */
				pstmt.setString( 17, order_category.trim() ) ;
				pstmt.setString( 18, order_type_code.trim() ) ;
				pstmt.setString( 19, priority.trim() ) ;
			}
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record;
				if((view_by.trim()).equals("L")){
					record = new String[31];
				}else{
					record = new String[25];
				}

				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "order_category_short_desc" )  ;
				record[2] = resultSet.getString( "priority_desc" )  ;
				record[3] = resultSet.getString( "order_detail" )  ;				
				record[4] = resultSet.getString( "order_type_code" )  ;
				record[5] = resultSet.getString( "ordering_pract_name" )  ;
				record[6] = resultSet.getString( "order_status_short_desc" )  ;				
				record[7] = resultSet.getString( "order_date_time" )  ;
				record[8] = resultSet.getString( "order_type_short_desc" )  ;
				record[9] = resultSet.getString( "order_id" )  ;
				record[10] = resultSet.getString( "priority" )  ;
				if((view_by.trim()).equals("L")){
					record[11] = resultSet.getString( "order_line_num" )  ;
					record[12] = resultSet.getString( "catalog_code" )  ;
					record[13] = resultSet.getString( "item_narration" )  ;
					record[14] = resultSet.getString( "order_status" )  ;
					record[15] = resultSet.getString( "display_popupmenu" );//resultSet.getString( "cancel_yn" )  ;
					record[16] = ""; //resultSet.getString( "discontinue_yn" )  ;
					record[17] = ""; //resultSet.getString( "result_hyperlink_yn" )  ;
					record[18] = resultSet.getString( "source_type" )  ;
					record[19] = resultSet.getString( "source_code" )  ;
					record[20] = resultSet.getString( "patient_class" )  ;
					record[21] = resultSet.getString( "cont_order_ind" )  ;
					record[22] = ""; //resultSet.getString( "hold_yn" )  ;
					record[23] = ""; //resultSet.getString( "resume_yn" )  ;
					record[24] = resultSet.getString("can_line_reason");
                    record[25] = resultSet.getString("iv_prep_yn");
                    record[26] = ""; //resultSet.getString( "renew_yn" )  ;
                    record[27] = resultSet.getString( "start_date_time" )  ;
                    record[28] = resultSet.getString( "end_date_time" )  ;
                    record[29] = ""; //resultSet.getString( "amend_yn" )  ;
                    record[30] = checkForNull(resultSet.getString( "copy_yn" ),"")  ;

				}else{
					record[11] = resultSet.getString( "can_reason" )  ;
					record[12] = resultSet.getString( "display_popupmenu" )  ;
					record[13] = resultSet.getString( "order_status" )  ;
					record[14] = ""; //resultSet.getString( "result_hyper_link" )  ;
					record[15] = ""; //resultSet.getString( "discontinue_yn" )  ;
					record[16] = resultSet.getString( "source_type" )  ;
					record[17] = resultSet.getString( "source_code" )  ;
					record[18] = resultSet.getString( "patient_class" )  ;
					record[19] = resultSet.getString( "cont_order_ind" )  ;
					record[20] = ""; //resultSet.getString( "hold_yn" )  ;
					record[21] = ""; //resultSet.getString( "resume_yn" )  ;
					record[22] = resultSet.getString( "iv_prep_yn" )  ;
					record[23] = ""; //resultSet.getString( "renew_yn" )  ;
					record[24] = checkForNull(resultSet.getString( "copy_yn" ),"")  ;
				}

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public String[] viewMainDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 	= null;//7632
		ResultSet resultSet1 			= null;//7632
		String specimen_type="";//7632
		//String[] record = new String[40] ; //Commented for IN058811
			//String[] record = new String[41] ;//Added for IN058811//IN066453
	//	String[] record = new String[44] ;//Added for IN066453
		String[] record = new String[46] ;//Added for IN066453//31792
		
			
		try {
				connection = getConnection() ;
				//7632 starts
				pstmt1= connection.prepareStatement("select SPECIMEN_DESC from  RL_SPECIMEN_TYPE_CODE where SPECIMEN_TYPE_CODE in( SELECT SPECIMEN_TYPE FROM OR_ORDER_LINE_LB WHERE ORDER_ID=?)") ;
				pstmt1.setString(1, order_id);
				resultSet1 = pstmt1.executeQuery() ;
				if(resultSet1.next())
					specimen_type=resultSet1.getString("SPECIMEN_DESC")==null? "":resultSet1.getString("SPECIMEN_DESC");
				//7632 ends
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);
				pstmt.setString( 6, language_id);	
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);//IN70884
				pstmt.setString( 14, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = resultSet.getString( "order_category_short_desc" )  ;
				record[1] = resultSet.getString( "order_type_short_desc" )  ;
				record[2] = resultSet.getString( "Priority_desc" )  ;
				record[3] = resultSet.getString( "sex" )  ;
				record[4] = resultSet.getString( "encounter_id" )  ;
				record[5] = resultSet.getString( "order_status_short_desc" )  ;
				record[6] = resultSet.getString( "patient_name" )  ;
				record[7] = resultSet.getString( "ordering_pract_name" )  ;
				record[8] = resultSet.getString( "ordering_facility" )  ;
				record[9] = resultSet.getString( "performing_facility" )  ;
				record[10] = getOrderHeaderFormatTxt(checkForNull(resultSet.getString("order_id"),""),((resultSet.getString( "order_category")).toString()));//resultSet.getString( "order_format" )  ;
                record[11] = resultSet.getString("ORD_PRACT_ID");
                record[12] = resultSet.getString("ORDER_DATE_TIME");
                record[13] = resultSet.getString("ordering_facility_id");
                record[14] = resultSet.getString("iv_prep_yn");
                record[15] = resultSet.getString("order_category");
                record[16] = resultSet.getString("order_mode");
                record[17] = resultSet.getString("performing_deptloc_type");
                record[18] = resultSet.getString("performing_deptloc_code");
                record[19] = resultSet.getString("performing_pract_id");
                record[20] = checkForNull(resultSet.getString("ref_facility_id"),"");
                record[21] = checkForNull(resultSet.getString("ref_date_time"),"");
                record[22] = checkForNull(resultSet.getString("ref_sent_pract_id"),"");
                record[23] = checkForNull(resultSet.getString("ref_sent_remarks"),"");
                record[24] = checkForNull(resultSet.getString("ref_report_pract_id"),"");
                record[25] = checkForNull(resultSet.getString("ref_report_date_time"),"");
                record[26] = checkForNull(resultSet.getString("ref_recieved_date_time"),"");
                record[27] = checkForNull(resultSet.getString("ref_recieved_pract_id"),"");
                record[28] = checkForNull(resultSet.getString("ref_recieved_remarks"),"");
                record[29] = checkForNull(resultSet.getString("action_seq_num"),"");
                record[30] = checkForNull(resultSet.getString("appl_user_name"),"");
                record[31] = checkForNull(resultSet.getString("IMAGE_REF_YN"),"N");
                record[32] = checkForNull(resultSet.getString("order_id"),"");
                record[33] = checkForNull(resultSet.getString("patient_class"),"");
                record[34] = checkForNull(resultSet.getString("age"),"");
                record[35] = checkForNull(resultSet.getString("Patient_id"),"");
                record[36] = checkForNull(resultSet.getString("source_type"),"");
                record[37] = checkForNull(resultSet.getString("source_code"),"");
                record[38] = checkForNull(resultSet.getString("location_description"),"");
                record[39] = checkForNull(resultSet.getString("order_type_code"),"");
				record[40] = checkForNull(resultSet.getString("national_id_no"),"");//Added for IN058811
                record[41] = checkForNull(resultSet.getString("accession_num"),"");//added for IN066453
				record[42] = checkForNull(resultSet.getString("category_number"),"");//added for IN066453
				record[43]=specimen_type;//7632
				record[44] = checkForNull(resultSet.getString("performing_facility_id"),"");//added for IN066453
				record[45] = checkForNull(resultSet.getString("lv_neonate_spec_yn"),"");//31792
				
			}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;//7632
				closeStatement( pstmt1 ) ;//7632
				closeConnection(connection);

		}

		return record;
	}

	public String[] viewMainDetails(Properties properties, String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		//String[] record = new String[39] ;//IN042115
		//String[] record = new String[40] ;//IN042115
			String[] record = new String[43] ;//IN043143//7632
		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);	
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);//IN70884
				pstmt.setString( 14, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = resultSet.getString( "order_category_short_desc" )  ;
				record[1] = resultSet.getString( "order_type_short_desc" )  ;
				record[2] = resultSet.getString( "Priority_desc" )  ;
				record[3] = resultSet.getString( "sex" )  ;
				record[4] = resultSet.getString( "encounter_id" )  ;
				record[5] = resultSet.getString( "order_status_short_desc" )  ;
				record[6] = resultSet.getString( "patient_name" )  ;
				record[7] = resultSet.getString( "ordering_pract_name" )  ;
				record[8] = resultSet.getString( "ordering_facility" )  ;
				record[9] = resultSet.getString( "performing_facility" )  ;
				record[10] = getOrderHeaderFormatTxt(checkForNull(resultSet.getString("order_id"),""),((resultSet.getString( "order_category")).toString()));//resultSet.getString( "order_format" )  ;
                record[11] = resultSet.getString("ORD_PRACT_ID");
                record[12] = resultSet.getString("ORDER_DATE_TIME");
                record[13] = resultSet.getString("ordering_facility_id");
                record[14] = resultSet.getString("iv_prep_yn");
                record[15] = resultSet.getString("order_category");
                record[16] = resultSet.getString("order_mode");
                record[17] = resultSet.getString("performing_deptloc_type");
                record[18] = resultSet.getString("performing_deptloc_code");
                record[19] = resultSet.getString("performing_pract_id");
                record[20] = checkForNull(resultSet.getString("ref_facility_id"),"");
                record[21] = checkForNull(resultSet.getString("ref_date_time"),"");
                record[22] = checkForNull(resultSet.getString("ref_sent_pract_id"),"");
                record[23] = checkForNull(resultSet.getString("ref_sent_remarks"),"");
                record[24] = checkForNull(resultSet.getString("ref_report_pract_id"),"");
                record[25] = checkForNull(resultSet.getString("ref_report_date_time"),"");
                record[26] = checkForNull(resultSet.getString("ref_recieved_date_time"),"");
                record[27] = checkForNull(resultSet.getString("ref_recieved_pract_id"),"");
                record[28] = checkForNull(resultSet.getString("ref_recieved_remarks"),"");
                record[29] = checkForNull(resultSet.getString("action_seq_num"),"");
                record[30] = checkForNull(resultSet.getString("appl_user_name"),"");
                record[31] = checkForNull(resultSet.getString("IMAGE_REF_YN"),"N");
                record[32] = checkForNull(resultSet.getString("order_id"),"");
                record[33] = checkForNull(resultSet.getString("patient_class"),"");
                record[34] = checkForNull(resultSet.getString("age"),"");
                record[35] = checkForNull(resultSet.getString("Patient_id"),"");
                record[36] = checkForNull(resultSet.getString("source_type"),"");
                record[37] = checkForNull(resultSet.getString("source_code"),"");
                record[38] = checkForNull(resultSet.getString("location_description"),"");
                record[39] = checkForNull(resultSet.getString("performing_facility_id"),"");//IN042115
				record[40] = checkForNull(resultSet.getString("order_status"),"");//IN043143
				record[41] = checkForNull(resultSet.getString("accession_num"),"");//added for 7632
				record[42] = checkForNull(resultSet.getString("category_number"),"");//added for 7632 
               
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);

		}

		return record;
	}

	public String[] viewExternalRemarks(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[2] ;


		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_EXTERNAL_DTLS") ) ;
				pstmt.setString( 1, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = checkForNull(resultSet.getString("ref_sent_remarks"),"");
                record[1] = checkForNull(resultSet.getString("ref_recieved_remarks"),"");
                
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}

	public String getPerformLocnDesc(Properties properties, String performing_deptloc_code,String order_category,String login_facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String locn_desc 		= "" ;
		try {
		      connection			= ConnectionManager.getConnection(properties) ;
		    if(performing_deptloc_code == null) performing_deptloc_code = "";
            
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_PERFORM_LOCN") ) ;		//IN033207
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_PERFORM_LOCN") ) ;		//IN033207
			pstmt.setString( 1, checkForNull(login_facility_id,"") );
            pstmt.setString( 2, performing_deptloc_code.trim() ) ;
            pstmt.setString( 3, order_category.trim() ) ;
			
			pstmt.setString(4,language_id);   //IN033207
			
		   
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next() ) {
				locn_desc = resultSet.getString( "short_desc" )  ;
				if (locn_desc == null)locn_desc = "";
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);
		}
		return locn_desc;
	}


	public String getPerformLocnDesc(String performing_deptloc_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String locn_desc 		= "" ;
		try {
		      connection = getConnection() ;
		    if(performing_deptloc_code == null) performing_deptloc_code = "";
            //pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_PERFORM_LOCN") ) ;	//IN033207
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_PERFORM_LOCN") ) ;		//IN033207
			pstmt.setString(1,login_facility_id);
            pstmt.setString( 2, performing_deptloc_code.trim() ) ;
			pstmt.setString( 3, language_id ) ;//IN033207
			

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next() ) {
				locn_desc = resultSet.getString( "short_desc" )  ;
				if (locn_desc == null)locn_desc = "";
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return locn_desc;
	}


/**
	@return		:	String
	//SQL_OR_ORDER_ENTRY_GET_PRACTITIONER_MULTIPLE_RECS
*/

	public ArrayList getPractitionerDetails(String order_id, String cont_order_ind,String facility_id,String ord_cat,String order_type_code) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList practitioner 		= new ArrayList() ;
		ord_cat = (ord_cat == null ?"":ord_cat);
		order_id = (order_id == null ?"":order_id);
		cont_order_ind = (cont_order_ind == null ?"":cont_order_ind);
		facility_id = (facility_id == null ?"":facility_id);
		order_type_code = (order_type_code == null ?"":order_type_code);

		try 
		{
				connection = getConnection() ;
				cont_order_ind = cont_order_ind.trim();
			if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER_MULTIPLE_RECS") ) ;
			}
			else
			{
				String install_yn = "";
				/*
				Modified by Uma on 10/1/2009 for 
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
                pstmt.setString(1, "RL");
                resultSet = pstmt.executeQuery();
                String install_yn = "";
                if (resultSet.next()) {
                    install_yn = resultSet.getString("install_yn");
                }
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				} catch(Exception e){

				}*/
				
				//String labchk = checkForNull(getmoduleRL("",ord_cat,order_type_code,facility_id),"");
				
				String labchk = "";

				pstmt = connection.prepareStatement("SELECT PERFORMING_APPL_ID FROM OR_ORDER WHERE ORDER_ID = ?");
				pstmt.setString(1,order_id);
				resultSet = pstmt.executeQuery();

                if (resultSet.next()) 
				{
                    labchk = resultSet.getString("PERFORMING_APPL_ID") == null ? "N" : resultSet.getString("PERFORMING_APPL_ID");
                }		
				
				if(labchk.equalsIgnoreCase("IBARL")) 
				{
					install_yn = "Y";
				}
				else
				{
					install_yn = "N";
				}
                if (install_yn == null) install_yn = "";


                pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
                pstmt.setString(1,ord_cat);
                pstmt.setString(2,facility_id);
                resultSet = pstmt.executeQuery();
                String rd_install_yn = "";
                if (resultSet.next()) 
				{
                    rd_install_yn = resultSet.getString("operational_yn");
                }
                if (rd_install_yn == null) rd_install_yn = "";
				try
				{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
                
                if (((install_yn.equals("Y") && ord_cat.equals("LB"))||(rd_install_yn.equals("Y") && ord_cat.equals("RD"))) && (cont_order_ind.equals("DO") || cont_order_ind.equals("CO"))) 
				{
					//pstmt = connection.prepareStatement("SELECT nvl(AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1'),performed_by_id) practitioner_name, to_char(event_date,'dd/mm/yyyy hh24:mi') collected_date,to_char(EVENT_AUTH_DATE_TIME,'dd/mm/yyyy hh24:mi') reported_time FROM am_practitioner a,cr_encounter_detail b WHERE  hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' and b.request_num =    (select 'F' ||added_facility_id ||'#'|| accession_num  from OR_ORDER_LINE where ordeR_id = (?) AND ROWNUM<=1) and accession_num is not null and a.practitioner_id(+) = b.PERFORMED_BY_ID AND ROWNUM<=1");  //commented for IN067651
					//Added for IN067651 starts
					boolean disAuthPracInResult = false;
					disAuthPracInResult=eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","DIS_AUTHPRAC_RESULT");
                    //pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER_LB"));
					if(disAuthPracInResult && ord_cat.equals("LB"))
						pstmt = connection.prepareStatement("select practitioner_name,collected_date,reported_time from (SELECT nvl(AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1'),performed_by_id) practitioner_name, to_char(event_date,'dd/mm/yyyy hh24:mi') collected_date,to_char(EVENT_AUTH_DATE_TIME,'dd/mm/yyyy hh24:mi') reported_time FROM am_practitioner a,cr_encounter_detail b WHERE  hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' and b.request_num =    (select 'F' ||added_facility_id ||'#'|| accession_num  from OR_ORDER_LINE where ordeR_id = (?) AND ROWNUM<=1) and accession_num is not null and a.practitioner_id(+) = b.AUTHORIZED_BY_ID order by EVENT_AUTH_DATE_TIME desc) where rownum<=1");                   
					else
						pstmt = connection.prepareStatement("SELECT nvl(AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1'),performed_by_id) practitioner_name, to_char(event_date,'dd/mm/yyyy hh24:mi') collected_date,to_char(EVENT_AUTH_DATE_TIME,'dd/mm/yyyy hh24:mi') reported_time FROM am_practitioner a,cr_encounter_detail b WHERE  hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' and b.request_num =    (select 'F' ||added_facility_id ||'#'|| accession_num  from OR_ORDER_LINE where ordeR_id = (?) AND ROWNUM<=1) and accession_num is not null and a.practitioner_id(+) = b.PERFORMED_BY_ID AND ROWNUM<=1");   
					//IN067651 changes ends

                }
                else 
				{
                    pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER") ) ;
				}
			}

			pstmt.setString( 1,language_id);
			pstmt.setString( 2, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next() ) {
				//practitioner = resultSet.getString( "practitioner_name" )  ;
               // ResultSetMetaData rsm = resultSet.getMetaData();
                for (int i = 1; i <= (resultSet.getMetaData()).getColumnCount();i++) {
                    practitioner.add(i-1,resultSet.getString(i));
                }
                //practitioner.add(0, resultSet.getString("practitioner_name"));
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return practitioner;
	}


	public String getPractitioner(String order_id, String cont_order_ind) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String practitioner 		= "" ;
		try {
			connection = getConnection() ;
			cont_order_ind = cont_order_ind.trim();
			if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER_MULTIPLE_RECS") ) ;
			}else{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER") ) ;
			}
			pstmt.setString( 1,language_id);
			pstmt.setString( 2, order_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next() ) {
				practitioner = resultSet.getString( "practitioner_name" )  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return practitioner;
	}

	public String getBillForFacility(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String bill_for_facility	= "N" ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_FOR_FACILITY") ) ;
			pstmt.setString( 1, facility_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next() ) {
				bill_for_facility = (resultSet.getString( "bl_module_yn" ) == null)? "N":resultSet.getString( "bl_module_yn" );
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return bill_for_facility;
	}


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

		public ArrayList viewOtherDetails(String order_id,String practitioner_type) throws Exception {
		//public ArrayList viewOtherDetails(String order_id,String practitioner_type,String order_line_num,String view_by,String order_cat_code) throws Exception {//IN061961
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList otherDetails = new ArrayList();
		boolean isviewLineDtls = isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
		String order_cat_code = "";
		String order_line_num = "";

		try {

			connection = getConnection() ;
			if(("LB").equals(order_cat_code)&&("L").equals(view_by)&&isviewLineDtls)//IN061961
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_DTL_LINE") ) ;//IN061961
			else
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_DTL") ) ;
			if(("LB").equals(order_cat_code)&&("L").equals(view_by)&&isviewLineDtls)//IN061961STARTS
			{
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, practitioner_type);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, login_facility_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, login_facility_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);
				pstmt.setString( 14, order_id.trim() ) ;
			pstmt.setString( 15, order_line_num) ;//IN061961 ENDDS
			}
			else
			{
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, practitioner_type);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, login_facility_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, login_facility_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);
				pstmt.setString( 14, order_id.trim() ) ;
			}
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				//String[] record = new String[47] ;//IN64543
				String[] record = new String[50] ;//IN068314//IN64543

				record[0] = resultSet.getString( "catalog_desc" )  ;
				record[1] = resultSet.getString( "priority_desc" )  ;
				record[2] = resultSet.getString( "start_date_time" )  ;
				record[3] = resultSet.getString( "end_date_time" )  ;
				record[4] = resultSet.getString( "order_qty" )  ;
				record[5] = resultSet.getString( "order_status_desc" )  ;
				record[6] = resultSet.getString( "freq_code" )  ;
				record[7] = resultSet.getString( "durn_type" )  ;
				record[8] = resultSet.getString( "order_line_status" )  ;
				record[9] = resultSet.getString( "order_line_num" )  ; //used as serial number inthe page
				record[10] = resultSet.getString( "frequency_detail" )  ;
				record[11] = /*resultSet.getString( "line_fields_display_detail" )  ;*/getOrderFormatTxt(order_id,record[9],((resultSet.getString( "order_category" )).toString()));
				record[12] = resultSet.getString( "item_narration" )  ;
				record[13] = resultSet.getString( "order_catalog_code" )  ;
				record[14] = resultSet.getString( "order_category" )  ;
				record[15] = resultSet.getString( "chk_box_flag" )  ;
				record[16] = resultSet.getString( "colour_status" )  ;
				record[17] = resultSet.getString( "can_line_reason" )  ;
				record[18] = resultSet.getString( "order_catalog_code" )  ;
				record[19] = resultSet.getString( "added_by_id" )  ;

				record[20] = resultSet.getString("appt_reqd_yn");
				record[21] = resultSet.getString("appt_date_time");
				record[22] = resultSet.getString("appt_ref_num");

				record[23] = resultSet.getString("cont_order_ind");
				record[24] = resultSet.getString("parent_order_id");
				record[25] = resultSet.getString("parent_order_line_num");

				record[26] = resultSet.getString("bill_yn");
				record[27] = resultSet.getString("billed_yn");
				record[28] = resultSet.getString("dosage_unit");
				record[29] = resultSet.getString("form_code");

				record[30] = resultSet.getString("appt_locn");
				record[31] = resultSet.getString("appt_resched_yn");
				record[32] = resultSet.getString("appt_resched_reason");
				record[33] = resultSet.getString("no_of_reschedules");
				record[34] = resultSet.getString("image_ref_yn");
				record[35] = resultSet.getString("explanatory_text");
				record[36] = resultSet.getString("quantity");
				record[37] = resultSet.getString("order_set_id");
				record[38] = resultSet.getString("order_type_code");
				record[39] = resultSet.getString("performing_facility_id");
				record[40] = resultSet.getString("durn_value");
				record[41] = resultSet.getString("contr_mod_id");
				record[42] = resultSet.getString("patient_id");
				record[43] = resultSet.getString("encounter_id");
				record[44] = resultSet.getString("patient_class");
				record[45] = resultSet.getString("sex");
				record[46] = resultSet.getString("appl_sliding_scale_yn");
				//IN64543 start
				//record[47] = resultSet.getString("INSTRUCTION_TYPE");//IN64543
				//IN64543, starts
				record[47] = checkForNull(resultSet.getString( "INSTRUCTION_TYPE" ),"T");//IN64543
				if("E".equals(record[47]))
				record[12] = resultSet.getString( "item_narration_free_fmt" );
				//IN64543, ends
				record[48] = resultSet.getString("fpp_yn");//IN068314
				record[49] = resultSet.getString("fpp_category");//IN068314
				otherDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return otherDetails;
	}

	public ArrayList viewOtherDetails(String order_id,String practitioner_type,String order_line_num,String view_by,String order_cat_code) throws Exception {
		//IN061961
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList otherDetails = new ArrayList();
		boolean isviewLineDtls = isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
		try {

			connection = getConnection() ;
			
			if(("LB").equals(order_cat_code)&&("L").equals(view_by)&&isviewLineDtls)//IN061961
			//	pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_DTL_LINE") ) ;//IN061961//commented for skr-scf-1723
				pstmt = connection.prepareStatement("SELECT g.iv_prep_yn, f.contr_mod_id contr_mod_id,a.order_line_num order_line_num,a.INSTRUCTION_TYPE,a.order_catalog_code order_catalog_code,/*decode(a.added_module_id,'RD','$$RD##'||'::'||a.reason_for_addition||'::')||*/or_get_order_catalog (g.order_id, g.order_type_code,?, ?,a.order_line_num)/*a.catalog_synonym_dc*/ catalog_desc,a.catalog_synonym_dc catalog_synonym, a.order_catalog_nature  order_catalog_nature, a.order_type_code order_type_code, a.order_category  order_category,a.ord_date_time ord_date_time, a.priority priority,DECODE(a.priority,'S','Stat','U','Urgent','R','Routine') priority_desc, a.ord_auth_reqd_yn ord_auth_reqd_yn, a.ord_auth_reason ord_auth_reason, a.ord_appr_reqd_yn ord_appr_reqd_yn, a.ord_cosign_reqd_yn ord_cosign_reqd_yn,TO_CHAR(a.start_date_time,'dd/mm/yyyy hh24:mi')  start_date_time, a.form_code form_code, a.route_code route_code, a.qty_value qty_value, a.qty_unit qty_unit, a.freq_code freq_code, AM_GET_DESC.AM_FREQUENCY(a.freq_code,?,'1') freq_desc, a.durn_value  durn_value, a.durn_type durn_type, AM_GET_DESC.AM_DURATION_TYPE(a.DURN_TYPE,?,'1') durn_desc, SUBSTR(a.line_fields_display_text,1,40) line_fields_display_text,a.item_narration  item_narration, a.next_sched_date next_sched_date, TO_CHAR(a.end_date_time,'dd/mm/yyyy hh24:mi')   end_date_time, a.auto_stop_date_time  auto_stop_date_time, RTRIM(RTRIM(TO_CHAR(a.order_qty,'9999999999999990.999999999999'),'0'),'.') || ' ' || PH_GET_UOM_DISPLAY(?,a.order_uom,?) order_qty, RTRIM(RTRIM(TO_CHAR(a.qty_value,'9999999999999990.999999999999'),'0'),'.') || ' ' || PH_GET_UOM_DISPLAY(?,a.qty_unit,?) dosage_unit, a.order_uom order_uom, a.appt_reqd_yn appt_reqd_yn, TO_CHAR(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, a.appt_ref_num appt_ref_num,a.result_applicable_yn  result_applicable_yn, a.bill_yn bill_yn ,a.billed_yn billed_yn,a.cont_order_ind cont_order_ind, a.added_by_id added_by_id,a.refill_single_cont_order_yn cont_order_ind, a.num_of_refills num_of_refills, a.child_order_yn child_order_yn, a.parent_order_id  parent_order_id, a.parent_order_line_num parent_order_line_num, a.order_set_id order_set_id, a.order_set_line_num  order_set_line_num, a.ord_pract_id ord_pract_id, a.ord_set_date_time ord_set_date_time, a.amd_pract_id  amd_pract_id, a.amd_date_time amd_date_time, a.hold_pract_id hold_pract_id, a.hold_date_time    hold_date_time, a.resume_pract_id resume_pract_id, a.resume_date_time resume_date_time, a.disc_pract_id disc_pract_id, a.disc_date_time disc_date_time, a.can_pract_id can_pract_id, a.can_date_time can_date_time, a.accession_num  accession_num, a.accession_line_num  accession_line_num, a.order_line_status order_line_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_line_status,?,'2') order_status_desc, a.result_line_status result_line_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.result_line_status,?,'2') result_status_desc, nvl2(a.freq_code,am_get_desc.am_frequency (a.freq_code, ?, '1') || '  ' || c.for_text || '  ' || (CASE      WHEN TO_CHAR (a.durn_value) IS NOT NULL AND NVL (INSTR (TO_CHAR (a.durn_value), '.', 1, 1), 0) != 0 THEN (SELECT    TO_CHAR (FLOOR (a.durn_value)) || ':' || TO_CHAR (ROUND (MOD (a.durn_value * 60, 60))) FROM DUAL) ELSE TO_CHAR (a.durn_value) END)|| ' ' || am_get_desc.am_duration_type (c.durn_type, ?, '1'),'') frequency_detail,SUBSTR(line_fields_display_text,1,40)    line_fields_display_detail, or_order_line_color('CANCEL_ORDER', a.order_id,a.order_type_code,a.order_catalog_code, a.order_line_num) colour_status, or_order_status_flag('CANCEL_ORDER', a.order_id,a.order_type_code,a.order_catalog_code, a.order_line_num) chk_box_flag, a.can_line_reason can_line_reason, a.form_code form_code,a.appt_locn  appt_locn,a.appt_resched_yn appt_resched_yn,a.appt_resched_reason appt_resched_reason,a.no_of_reschedules no_of_reschedules,a.image_ref_yn image_ref_yn, OR_GET_DESC.OR_ORDER_CATALOG(f.order_catalog_code,?,'4') explanatory_text, a.order_qty quantity,a.order_set_id order_set_id,f.order_type_code order_type_code,g.performing_facility_id performing_facility_id,g.patient_id patient_id,g.encounter_id encounter_id,g.patient_class patient_class,h.sex sex,f.appl_sliding_scale_yn,INSTRUCTION_TYPE,item_narration_free_fmt,a.FPP_YN,a.FPP_CATEGORY,(SELECT count(*) interaction_dtls  FROM or_order_drug_interaction where order_id=a.order_id and ORDER_LINE_NUM=a.order_line_num) interaction_dtls FROM or_order_line  a ,am_frequency b,am_duration_type c,or_order_status_code d,or_order_status_code e,or_order_catalog f,or_order g,mp_patient h WHERE a.order_id =? AND a.order_line_num = ? and g.patient_id=h.patient_id and g.order_id=a.order_id AND a.freq_code = b.freq_code (+) AND  a.durn_type = c.durn_type (+) AND a.order_line_status = d.order_status_code (+) AND a.result_line_status = e.order_status_code (+) and a.order_catalog_code = f.order_catalog_code ORDER BY a.order_line_num");
			else
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_DTL") ) ;//commented for skr-scf-1723
			pstmt = connection.prepareStatement("SELECT g.iv_prep_yn, f.contr_mod_id contr_mod_id,a.order_line_num order_line_num,a.order_catalog_code order_catalog_code,/*decode(a.added_module_id,'RD','$$RD##'||'::'||a.reason_for_addition||'::')||*/or_get_order_catalog (g.order_id, g.order_type_code,?, ?,a.order_line_num)/*a.catalog_synonym_dc*/ catalog_desc,a.catalog_synonym_dc catalog_synonym, a.order_catalog_nature  order_catalog_nature, a.order_type_code order_type_code, a.order_category  order_category,a.ord_date_time ord_date_time, a.priority priority,DECODE(a.priority,'S','Stat','U','Urgent','R','Routine') priority_desc, a.ord_auth_reqd_yn ord_auth_reqd_yn, a.ord_auth_reason ord_auth_reason, a.ord_appr_reqd_yn ord_appr_reqd_yn, a.ord_cosign_reqd_yn ord_cosign_reqd_yn,TO_CHAR(a.start_date_time,'dd/mm/yyyy hh24:mi')  start_date_time, a.form_code form_code, a.route_code route_code, a.qty_value qty_value, a.qty_unit qty_unit, a.freq_code freq_code, AM_GET_DESC.AM_FREQUENCY(a.freq_code,?,'1') freq_desc, a.durn_value  durn_value, a.durn_type durn_type, AM_GET_DESC.AM_DURATION_TYPE(a.DURN_TYPE,?,'1') durn_desc, SUBSTR(a.line_fields_display_text,1,40) line_fields_display_text,a.item_narration  item_narration,a.item_narration_free_fmt item_narration_free_fmt,a.next_sched_date next_sched_date, TO_CHAR(a.end_date_time,'dd/mm/yyyy hh24:mi')   end_date_time, a.auto_stop_date_time  auto_stop_date_time, RTRIM(RTRIM(TO_CHAR(a.order_qty,'9999999999999990.999999999999'),'0'),'.') || ' ' || PH_GET_UOM_DISPLAY(?,a.order_uom,?) order_qty, RTRIM(RTRIM(TO_CHAR(a.qty_value,'9999999999999990.999999999999'),'0'),'.') || ' ' || PH_GET_UOM_DISPLAY(?,a.qty_unit,?) dosage_unit, a.order_uom order_uom, a.appt_reqd_yn appt_reqd_yn, TO_CHAR(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, a.appt_ref_num appt_ref_num,a.result_applicable_yn  result_applicable_yn, a.bill_yn bill_yn ,a.billed_yn billed_yn,a.cont_order_ind cont_order_ind, a.added_by_id added_by_id,a.refill_single_cont_order_yn cont_order_ind, a.num_of_refills num_of_refills, a.child_order_yn child_order_yn, a.parent_order_id  parent_order_id, a.parent_order_line_num parent_order_line_num, a.order_set_id order_set_id, a.order_set_line_num  order_set_line_num, a.ord_pract_id ord_pract_id, a.ord_set_date_time ord_set_date_time, a.amd_pract_id  amd_pract_id, a.amd_date_time amd_date_time, a.hold_pract_id hold_pract_id, a.hold_date_time    hold_date_time, a.resume_pract_id resume_pract_id, a.resume_date_time resume_date_time, a.disc_pract_id disc_pract_id, a.disc_date_time disc_date_time, a.can_pract_id can_pract_id, a.can_date_time can_date_time, a.accession_num  accession_num, a.accession_line_num  accession_line_num, a.order_line_status order_line_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_line_status,?,'2') order_status_desc, a.result_line_status result_line_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.result_line_status,?,'2') result_status_desc, nvl2(a.freq_code,am_get_desc.am_frequency (a.freq_code, ?, '1') || '  ' || c.for_text || '  ' || (CASE      WHEN TO_CHAR (a.durn_value) IS NOT NULL AND NVL (INSTR (TO_CHAR (a.durn_value), '.', 1, 1), 0) != 0 THEN (SELECT    TO_CHAR (FLOOR (a.durn_value)) || ':' || TO_CHAR (ROUND (MOD (a.durn_value * 60, 60))) FROM DUAL) ELSE TO_CHAR (a.durn_value) END)|| ' ' || am_get_desc.am_duration_type (c.durn_type, ?, '1'),'') frequency_detail,SUBSTR(line_fields_display_text,1,40)    line_fields_display_detail, or_order_line_color('CANCEL_ORDER', a.order_id,a.order_type_code,a.order_catalog_code, a.order_line_num) colour_status, or_order_status_flag('CANCEL_ORDER', a.order_id,a.order_type_code,a.order_catalog_code, a.order_line_num) chk_box_flag, a.can_line_reason can_line_reason, a.form_code form_code,a.appt_locn  appt_locn,a.appt_resched_yn appt_resched_yn,a.appt_resched_reason appt_resched_reason,a.no_of_reschedules no_of_reschedules,a.image_ref_yn image_ref_yn, OR_GET_DESC.OR_ORDER_CATALOG(f.order_catalog_code,?,'4') explanatory_text, a.order_qty quantity,a.order_set_id order_set_id,f.order_type_code order_type_code,g.performing_facility_id performing_facility_id,g.patient_id patient_id,g.encounter_id encounter_id,g.patient_class patient_class,h.sex sex,f.appl_sliding_scale_yn,nvl(INSTRUCTION_TYPE,'T')INSTRUCTION_TYPE,a.fpp_yn,a.fpp_category, (SELECT count(*) interaction_dtls FROM or_order_drug_interaction where order_id=a.order_id and ORDER_LINE_NUM=a.order_line_num) interaction_dtls FROM or_order_line  a ,am_frequency b,am_duration_type c,or_order_status_code d,or_order_status_code e,or_order_catalog f,or_order g,mp_patient h WHERE a.order_id =? and g.patient_id=h.patient_id and g.order_id=a.order_id AND a.freq_code = b.freq_code (+) AND  a.durn_type = c.durn_type (+) AND a.order_line_status = d.order_status_code (+) AND a.result_line_status = e.order_status_code (+) and a.order_catalog_code = f.order_catalog_code ORDER BY a.order_line_num");
			if(("LB").equals(order_cat_code)&&("L").equals(view_by)&&isviewLineDtls)//IN061961STARTS
			{
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_type);
			pstmt.setString( 3, language_id);
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, login_facility_id);
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, login_facility_id);
			pstmt.setString( 8, language_id);
			pstmt.setString( 9, language_id);
			pstmt.setString( 10, language_id);
			pstmt.setString( 11, language_id);
			pstmt.setString( 12, language_id);
			pstmt.setString( 13, language_id);
			pstmt.setString( 14, order_id.trim() ) ;
			pstmt.setString( 15, order_line_num) ;//IN061961 ENDDS
			}
			else
			{
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, practitioner_type);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, login_facility_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, login_facility_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);
				pstmt.setString( 14, order_id.trim() ) ;
			}
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				//String[] record = new String[47] ;//IN64543
				//String[] record = new String[50] ;//IN64543//IN068314
				String[] record = new String[52] ;//IN072654//modified for skr-scf-1723

				record[0] = resultSet.getString( "catalog_desc" )  ;
				record[1] = resultSet.getString( "priority_desc" )  ;
				record[2] = resultSet.getString( "start_date_time" )  ;
				record[3] = resultSet.getString( "end_date_time" )  ;
				record[4] = resultSet.getString( "order_qty" )  ;
				record[5] = resultSet.getString( "order_status_desc" )  ;
				record[6] = resultSet.getString( "freq_code" )  ;
				record[7] = resultSet.getString( "durn_type" )  ;
				record[8] = resultSet.getString( "order_line_status" )  ;
				record[9] = resultSet.getString( "order_line_num" )  ; //used as serial number inthe page
				record[10] = resultSet.getString( "frequency_detail" )  ;
				record[11] = /*resultSet.getString( "line_fields_display_detail" )  ;*/getOrderFormatTxt(order_id,record[9],((resultSet.getString( "order_category" )).toString()));
				record[12] = resultSet.getString( "item_narration" )  ;
				record[13] = resultSet.getString( "order_catalog_code" )  ;
				record[14] = resultSet.getString( "order_category" )  ;
				record[15] = resultSet.getString( "chk_box_flag" )  ;
				record[16] = resultSet.getString( "colour_status" )  ;
				record[17] = resultSet.getString( "can_line_reason" )  ;
				record[18] = resultSet.getString( "order_catalog_code" )  ;
				record[19] = resultSet.getString( "added_by_id" )  ;

				record[20] = resultSet.getString("appt_reqd_yn");
				record[21] = resultSet.getString("appt_date_time");
				record[22] = resultSet.getString("appt_ref_num");

				record[23] = resultSet.getString("cont_order_ind");
				record[24] = resultSet.getString("parent_order_id");
				record[25] = resultSet.getString("parent_order_line_num");

				record[26] = resultSet.getString("bill_yn");
				record[27] = resultSet.getString("billed_yn");
				record[28] = resultSet.getString("dosage_unit");
				record[29] = resultSet.getString("form_code");

				record[30] = resultSet.getString("appt_locn");
				record[31] = resultSet.getString("appt_resched_yn");
				record[32] = resultSet.getString("appt_resched_reason");
				record[33] = resultSet.getString("no_of_reschedules");
				record[34] = resultSet.getString("image_ref_yn");
				record[35] = resultSet.getString("explanatory_text");
				record[36] = resultSet.getString("quantity");
				record[37] = resultSet.getString("order_set_id");
				record[38] = resultSet.getString("order_type_code");
				record[39] = resultSet.getString("performing_facility_id");
				record[40] = resultSet.getString("durn_value");
				record[41] = resultSet.getString("contr_mod_id");
				record[42] = resultSet.getString("patient_id");
				record[43] = resultSet.getString("encounter_id");
				record[44] = resultSet.getString("patient_class");
				record[45] = resultSet.getString("sex");
				record[46] = resultSet.getString("appl_sliding_scale_yn");
				//IN64543 start
				//record[47] = resultSet.getString("INSTRUCTION_TYPE");//IN64543
				//IN64543, starts
				record[47] = checkForNull(resultSet.getString( "INSTRUCTION_TYPE" ),"T");//IN64543
				if("E".equals(record[47]))
				record[12] = resultSet.getString( "item_narration_free_fmt" );
				record[48] = resultSet.getString("fpp_yn");//IN068314
				record[49] = resultSet.getString("fpp_category");//IN068314
				record[50] = resultSet.getString("interaction_dtls");//IN068314
				record[51] = resultSet.getString( "iv_prep_yn" )  ;//added for skr-scf-1723
				//IN64543, ends
				otherDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return otherDetails;
	}

/*	public ArrayList getBillChargeDetails(String order_id,String order_line_num,String ordering_facility_id) throws Exception {
		Connection connection 		= null;
		java.sql.CallableStatement cstmt 	= null;
		ArrayList billDetails				= new ArrayList();

		try {
			connection = getConnection() ;
			ordering_facility_id 	= (ordering_facility_id == null) ? "":ordering_facility_id;
			order_id				= (order_id == null) ? "":order_id;
			order_line_num			= (order_line_num == null) ? "":order_line_num;

			cstmt = connection.prepareCall( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_DETAILS") ) ;
			cstmt.setString( 1, ordering_facility_id.trim());
			cstmt.setString( 2, order_id.trim() ) ;
			cstmt.setString( 3, order_line_num.trim());
			cstmt.registerOutParameter(4, Types.VARCHAR ); //"P_DAY_TYPE_CODE"
			cstmt.registerOutParameter(5, Types.VARCHAR ); //"P_DAY_TYPE_DESC"
			cstmt.registerOutParameter(6, Types.VARCHAR ); //"P_TIME_TYPE_CODE"
			cstmt.registerOutParameter(7, Types.VARCHAR ); //"P_TIME_TYPE_DESC"
			cstmt.registerOutParameter(8, Types.VARCHAR ); //"P_BASE_QTY"
			cstmt.registerOutParameter(9, Types.VARCHAR ); //"P_BASE_RATE"
			cstmt.registerOutParameter(10,Types.VARCHAR ); //"P_ADDL_FACTOR"
			cstmt.registerOutParameter(11,Types.VARCHAR ); //"P_BASE_CHARGE_AMT"
			cstmt.registerOutParameter(12,Types.VARCHAR ); //"P_GROSS_CHARGE_AMT"
			cstmt.registerOutParameter(13,Types.VARCHAR ); //"P_DISC_AMT"
			cstmt.registerOutParameter(14,Types.VARCHAR ); //"P_NET_CHARGE_AMT"
			cstmt.registerOutParameter(15,Types.VARCHAR ); //"P_DISC_PERC"
			cstmt.registerOutParameter(16,Types.VARCHAR ); //"P_PAT_GROSS_CHARGE_AMT"
			cstmt.registerOutParameter(17,Types.VARCHAR ); //"P_PAT_DISC_AMT"
			cstmt.registerOutParameter(18,Types.VARCHAR ); //"P_PAT_NET_CHARGE_AMT"
			cstmt.registerOutParameter(19,Types.VARCHAR ); //"P_CUST_GROSS_CHARGE_AMT"
			cstmt.registerOutParameter(20,Types.VARCHAR ); //"P_CUST_DISC_AMT"
			cstmt.registerOutParameter(21,Types.VARCHAR ); //"P_CUST_NET_CHARGE_AMT"
			cstmt.registerOutParameter(22,Types.VARCHAR ); //"P_SPLIT_IND"
			cstmt.registerOutParameter(23,Types.VARCHAR ); //"P_CURR_AVAILED"
			cstmt.registerOutParameter(24,Types.VARCHAR ); //"P_CREDIT_AUTH_REF"
			cstmt.registerOutParameter(25,Types.VARCHAR ); //"P_ERROR_TEXT"
			cstmt.registerOutParameter(26,Types.VARCHAR ); //"P_SERV_PANEL_IND"
			cstmt.registerOutParameter(27,Types.VARCHAR ); //"P_SERV_PANEL_CODE"
			cstmt.registerOutParameter(28,Types.VARCHAR ); //"P_SERVICE_PANEL_NAME"

            cstmt.execute();
			//if (flag) {
				String[] record = new String[25] ;
                record[0] = cstmt.getString(4);    //"P_DAY_TYPE_CODE"
				record[1] = cstmt.getString(5);    //"P_DAY_TYPE_DESC"
				record[2] = cstmt.getString(6);    //"P_TIME_TYPE_CODE"
				record[3] = cstmt.getString(7);    //"P_TIME_TYPE_DESC"
				record[4] = cstmt.getString(8);    //"P_BASE_QTY"
				record[5] = cstmt.getString(9);    //"P_BASE_RATE"
				record[6] = cstmt.getString(10);   //"P_ADDL_FACTOR"
				record[7] = cstmt.getString(11);   //"P_BASE_CHARGE_AMT"
				record[8] = cstmt.getString(12);   //"P_GROSS_CHARGE_AMT"
				record[9] = cstmt.getString(13);   //"P_DISC_AMT"
				record[10] = cstmt.getString(14);  //"P_NET_CHARGE_AMT"
				record[11] = cstmt.getString(15);  //"P_DISC_PERC"
				record[12] = cstmt.getString(16);  //"P_PAT_GROSS_CHARGE_AMT"
				record[13] = cstmt.getString(17);  //"P_PAT_DISC_AMT"
				record[14] = cstmt.getString(18);  //"P_PAT_NET_CHARGE_AMT"
				record[15] = cstmt.getString(19);  //"P_CUST_GROSS_CHARGE_AMT"
				record[16] = cstmt.getString(20);  //"P_CUST_DISC_AMT"
				record[17] = cstmt.getString(21);  //"P_CUST_NET_CHARGE_AMT"
				record[18] = cstmt.getString(22);  //"P_SPLIT_IND"
				record[19] = cstmt.getString(23);  //"P_CURR_AVAILED"
				record[20] = cstmt.getString(24);  //"P_CREDIT_AUTH_REF"
				record[21] = cstmt.getString(25);  //"P_ERROR_TEXT"
				record[22] = cstmt.getString(26);  //"P_SERV_PANEL_IND"
				record[23] = cstmt.getString(27);  //"P_SERV_PANEL_CODE"
				record[24] = cstmt.getString(28);  //"P_SERVICE_PANEL_NAME"
				billDetails.add(record);
			//}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( cstmt ) ;
			closeConnection(connection);
		}

		return billDetails;
	}
*/


 public ArrayList getBillChargeDetails(Properties properties,String order_id,String order_line_num,String ordering_facility_id) throws Exception {
		Connection connection 		= null;
		java.sql.CallableStatement cstmt 	= null;
		ArrayList billDetails				= new ArrayList();

		try {
				connection				= ConnectionManager.getConnection(properties) ;
				ordering_facility_id 	= (ordering_facility_id == null) ? "":ordering_facility_id;
				order_id				= (order_id == null) ? "":order_id;
				order_line_num			= (order_line_num == null) ? "":order_line_num;

				cstmt = connection.prepareCall( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_DETAILS") ) ;
				cstmt.setString( 1, ordering_facility_id.trim());
				cstmt.setString( 2, order_id.trim() ) ;
				cstmt.setString( 3, order_line_num.trim());
				cstmt.registerOutParameter(4, Types.VARCHAR ); //"P_DAY_TYPE_CODE"
				cstmt.registerOutParameter(5, Types.VARCHAR ); //"P_DAY_TYPE_DESC"
				cstmt.registerOutParameter(6, Types.VARCHAR ); //"P_TIME_TYPE_CODE"
				cstmt.registerOutParameter(7, Types.VARCHAR ); //"P_TIME_TYPE_DESC"
				cstmt.registerOutParameter(8, Types.VARCHAR ); //"P_BASE_QTY"
				cstmt.registerOutParameter(9, Types.VARCHAR ); //"P_BASE_RATE"
				cstmt.registerOutParameter(10,Types.VARCHAR ); //"P_ADDL_FACTOR"
				cstmt.registerOutParameter(11,Types.VARCHAR ); //"P_BASE_CHARGE_AMT"
				cstmt.registerOutParameter(12,Types.VARCHAR ); //"P_GROSS_CHARGE_AMT"
				cstmt.registerOutParameter(13,Types.VARCHAR ); //"P_DISC_AMT"
				cstmt.registerOutParameter(14,Types.VARCHAR ); //"P_NET_CHARGE_AMT"
				cstmt.registerOutParameter(15,Types.VARCHAR ); //"P_DISC_PERC"
				cstmt.registerOutParameter(16,Types.VARCHAR ); //"P_PAT_GROSS_CHARGE_AMT"
				cstmt.registerOutParameter(17,Types.VARCHAR ); //"P_PAT_DISC_AMT"
				cstmt.registerOutParameter(18,Types.VARCHAR ); //"P_PAT_NET_CHARGE_AMT"
				cstmt.registerOutParameter(19,Types.VARCHAR ); //"P_CUST_GROSS_CHARGE_AMT"
				cstmt.registerOutParameter(20,Types.VARCHAR ); //"P_CUST_DISC_AMT"
				cstmt.registerOutParameter(21,Types.VARCHAR ); //"P_CUST_NET_CHARGE_AMT"
				cstmt.registerOutParameter(22,Types.VARCHAR ); //"P_SPLIT_IND"
				cstmt.registerOutParameter(23,Types.VARCHAR ); //"P_CURR_AVAILED"
				cstmt.registerOutParameter(24,Types.VARCHAR ); //"P_CREDIT_AUTH_REF"
				cstmt.registerOutParameter(25,Types.VARCHAR ); //"P_ERROR_TEXT"
				cstmt.registerOutParameter(26,Types.VARCHAR ); //"P_SERV_PANEL_IND"
				cstmt.registerOutParameter(27,Types.VARCHAR ); //"P_SERV_PANEL_CODE"
				cstmt.registerOutParameter(28,Types.VARCHAR ); //"P_SERVICE_PANEL_NAME"

				cstmt.execute();
				//if (flag) {
					String[] record = new String[25] ;
					record[0] = cstmt.getString(4);    //"P_DAY_TYPE_CODE"
					record[1] = cstmt.getString(5);    //"P_DAY_TYPE_DESC"
					record[2] = cstmt.getString(6);    //"P_TIME_TYPE_CODE"
					record[3] = cstmt.getString(7);    //"P_TIME_TYPE_DESC"
					record[4] = cstmt.getString(8);    //"P_BASE_QTY"
					record[5] = cstmt.getString(9);    //"P_BASE_RATE"
					record[6] = cstmt.getString(10);   //"P_ADDL_FACTOR"
					record[7] = cstmt.getString(11);   //"P_BASE_CHARGE_AMT"
					record[8] = cstmt.getString(12);   //"P_GROSS_CHARGE_AMT"
					record[9] = cstmt.getString(13);   //"P_DISC_AMT"
					record[10] = cstmt.getString(14);  //"P_NET_CHARGE_AMT"
					record[11] = cstmt.getString(15);  //"P_DISC_PERC"
					record[12] = cstmt.getString(16);  //"P_PAT_GROSS_CHARGE_AMT"
					record[13] = cstmt.getString(17);  //"P_PAT_DISC_AMT"
					record[14] = cstmt.getString(18);  //"P_PAT_NET_CHARGE_AMT"
					record[15] = cstmt.getString(19);  //"P_CUST_GROSS_CHARGE_AMT"
					record[16] = cstmt.getString(20);  //"P_CUST_DISC_AMT"
					record[17] = cstmt.getString(21);  //"P_CUST_NET_CHARGE_AMT"
					record[18] = cstmt.getString(22);  //"P_SPLIT_IND"
					record[19] = cstmt.getString(23);  //"P_CURR_AVAILED"
					record[20] = cstmt.getString(24);  //"P_CREDIT_AUTH_REF"
					record[21] = cstmt.getString(25);  //"P_ERROR_TEXT"
					record[22] = cstmt.getString(26);  //"P_SERV_PANEL_IND"
					record[23] = cstmt.getString(27);  //"P_SERV_PANEL_CODE"
					record[24] = cstmt.getString(28);  //"P_SERVICE_PANEL_NAME"
					billDetails.add(record);
			//}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( cstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return billDetails;
	}
 
public ArrayList getBLDetails(Properties properties, String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
				connection				= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_ORDER_DETAILS") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, parent_order_id ) ;
				pstmt.setString( 3, parent_order_line_num ) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[8];
					record[0] = resultSet.getString( "order_id" )  ;
					record[1] = resultSet.getString( "order_line_num" )  ;
					record[2] = resultSet.getString( "start_date_time" )  ;
					record[3] = resultSet.getString( "billed_yn" )  ;
					record[4] = resultSet.getString( "bill_yn" )  ;
					record[5] = resultSet.getString( "catalog_code" )  ;
					record[6] = resultSet.getString( "catalog_desc" )  ;
					record[7] = resultSet.getString("order_line_status");

					ApptDetails.add(record) ;
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);

		}

		return ApptDetails;
	}
	/*public ArrayList getBLDetails(String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_ORDER_DETAILS") ) ;
			pstmt.setString( 1, parent_order_id ) ;
			pstmt.setString( 2, parent_order_line_num ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[8];
				record[0] = resultSet.getString( "order_id" )  ;
				record[1] = resultSet.getString( "order_line_num" )  ;
				record[2] = resultSet.getString( "start_date_time" )  ;
				record[3] = resultSet.getString( "billed_yn" )  ;
				record[4] = resultSet.getString( "bill_yn" )  ;
				record[5] = resultSet.getString( "catalog_code" )  ;
				record[6] = resultSet.getString( "catalog_desc" )  ;
				record[7] = resultSet.getString("order_line_status");

				ApptDetails.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ApptDetails;
	} */

   	public String getAppointmentYN(String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String Appointment 			= "N";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_APPT_YN") ) ;
			pstmt.setString(1, parent_order_id);
			pstmt.setString(2, parent_order_line_num);

			resultSet = pstmt.executeQuery() ;

			if( resultSet.next() ) {
				if (resultSet.getInt(1) > 0)
					Appointment	= "Y";
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return Appointment;
	}

    public ArrayList getApptDetails(String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_APPT_DETAILS") ) ;
			pstmt.setString( 1, parent_order_id ) ;
			pstmt.setString( 2, parent_order_line_num ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[6];
				record[0] = resultSet.getString( "appt_ref_num" )  ;
				record[1] = resultSet.getString( "appt_date_time" )  ;
				record[2] = resultSet.getString( "appt_locn" )  ;
				record[3] = resultSet.getString( "appt_resched_yn" )  ;
				record[4] = resultSet.getString( "appt_resched_reason" )  ;
				record[5] = resultSet.getString( "no_of_reschedules" )  ;

				ApptDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ApptDetails;
	}
	   /* public ArrayList getOrderApptDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_APPT_DETAILS") ) ;
			pstmt.setString( 1, order_id ) ;
			pstmt.setString( 2, "1" ) ; // Always only one record will be there if appt is there
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "appt_ref_num" )  ;
				record[1] = resultSet.getString( "appt_date_time" )  ;

				ApptDetails.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ApptDetails;
	}
*/

	public String getRadiology(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	    String rd_install_yn		= "N";
 		try {
			connection = getConnection() ;

			 pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
             pstmt.setString(1,"RD");
             pstmt.setString(2,facility_id);
             resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    rd_install_yn = resultSet.getString("operational_yn");
                }
                if (rd_install_yn == null) rd_install_yn = "N";
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return rd_install_yn;
	}

	public String getOTModule(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	    String ot_install_yn		= "N";
 		try {
			connection = getConnection() ;

			 pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
             pstmt.setString(1,"OT");
             pstmt.setString(2,facility_id);
             resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    ot_install_yn = resultSet.getString("operational_yn");
                }
                if (ot_install_yn == null) ot_install_yn = "N";
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ot_install_yn;
	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getOrderTypeData(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(order_category.equals(""))
			order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}

		// Overridden methods
		// properties passed to get the connection, used for the page level scope
		public ArrayList getOrderTypeData(Properties properties, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(order_category.equals(""))
			order_category = null;
		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, order_category ) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCat.add(record) ;
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);

		}

		return OrderCat;
	}


	public void clear() {
		allValues 			= new Hashtable();
		total_records 		= "";
		view_type 			= "";
		order_category 		= "";
		order_type_code		= "";
		priority 			= "";
		location_type		= "";
		locn 				= "";
		patient_id			= "";
		encntr_id 			= "";
		order_id 			= "";
		date_from 			= "";
		date_to 			= "";
		view_by				= "";
		beanValues			= new ArrayList();
		//persistence_details	= null;
		copyOrderDetails	= null;
		existingQueryString	= "";

		super.clear();
	}

/**

	@return		:	String
*/

	public String getPrepsdata(String order_id, String ord_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String pat_preps_or_instrns_txt = "";
		String order_line_fld_value_ins_type = "";//IN64543
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PREP_DATA") ) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, (String)order_id.trim());//IN64543
			pstmt.setString(4, (String)ord_line_num.trim());//IN64543
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				
				//pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;//IN64543
				//IN64543, starts
				order_line_fld_value_ins_type = resultSet.getString("order_line_fld_value_ins_type")  ;//IN64543
				if("T".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;
				else if("E".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_fld_value_free_fmt")  ;
				//IN64543, ends
			}
			//chk +=  "ord_catalog_code :"+ord_catalog_code +"pat_preps_or_instrns_txt : "+pat_preps_or_instrns_txt;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
		return pat_preps_or_instrns_txt;
	}



/**

	@return		:	String[]
*/

	public String[] getScheduleYN(String freq_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String schedule[] = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_SCHD_YN") ) ;
			pstmt.setString(1, (String)freq_code.trim());

			resultSet = pstmt.executeQuery() ;

			if( resultSet.next() ) {
				schedule[0] = resultSet.getString("scheduled_yn")  ;
				schedule[1] = resultSet.getString("interval_durn_type")  ;
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return schedule;
	}



/**

	@return		:	ArrayList
*/

	public String getDeptdata(String order_id, String ord_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String pat_preps_or_instrns_txt = "";
		String order_line_fld_value_ins_type = "";//IN64543
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DEPT_DATA") ) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, (String)order_id.trim());//IN64543
			pstmt.setString(4, (String)ord_line_num.trim());//IN64543
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				//pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;//IN64543
				
				//IN64543, starts
				order_line_fld_value_ins_type = resultSet.getString("order_line_fld_value_ins_type")  ;
				if("T".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;
				else if("E".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_fld_value_free_fmt")  ;
				//IN64543, ends
			}
			//chk +=  "ord_catalog_code :"+ord_catalog_code +"pat_preps_or_instrns_txt : "+pat_preps_or_instrns_txt;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return pat_preps_or_instrns_txt;
	}



/**

	@return		:	ArrayList
*/

/*
	public String getPatientNoOfDays(String patient_id, String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String no_of_days = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_NO_OF_DAYS") ) ;
			pstmt.setString(1, (String)patient_id.trim());
			pstmt.setString(2, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				no_of_days = resultSet.getString("no_of_days")  ;
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return no_of_days;
	}

*/
/**
	@return		:	String
*/
/*
	public String getPatientInstruction(String catalog_code, String no_of_days, String sex) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String patient_instruction = "";
		String pat_instrn_age_sex_yn = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PAT_INSTRN_AGE_SEX_YN") ) ;
			pstmt.setString(1, (String)catalog_code.trim());
			resultSet = pstmt.executeQuery() ;

			if( resultSet.next() ) {
				pat_instrn_age_sex_yn = resultSet.getString("pat_instrn_age_sex_yn")  ;
			}
			if(pat_instrn_age_sex_yn.trim().equals("Y")){
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PAT_YN_INSTRN") ) ;
				pstmt.setString(1, (String)catalog_code.trim());
				pstmt.setString(2, (String)no_of_days.trim());
				pstmt.setString(3, checkForNull(sex.trim(),"N"));
				pstmt.setString(4, checkForNull(sex.trim(),"N"));
				pstmt.setString(5, checkForNull(sex.trim(),"N"));
			}else{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_LINE_PATIENT_INSTRUCTION1") ) ;
				pstmt.setString(1, (String)catalog_code.trim());
			}

			resultSet = pstmt.executeQuery() ;

			if( resultSet.next() ) {
				patient_instruction = resultSet.getString("pat_preps_or_instrns_txt")  ;
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return patient_instruction;
	}
*/

	public String getPatientInstruction(String order_id, String ord_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String pat_preps_or_instrns_txt = "";
		String order_line_fld_value_ins_type = "";//IN64543
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PAT_INSTN_DATA") ) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, (String)order_id.trim());//IN64543
			pstmt.setString(4, (String)ord_line_num.trim());//IN64543
			resultSet = pstmt.executeQuery() ;			

			if( resultSet.next() ) {
				//pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value");/IN64543
				
				//IN64543, starts
				order_line_fld_value_ins_type = resultSet.getString("order_line_fld_value_ins_type")  ;
				if("T".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;
				else if("E".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_fld_value_free_fmt")  ;
				//IN64543, ends
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return pat_preps_or_instrns_txt;
	}

	public String getMenu(String menu_id,String resp_id,String pract_relation_id) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String menu_value				= "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MENU") ) ;
			pstmt.setString(1, menu_id);
			pstmt.setString(2, resp_id);
			pstmt.setString(3, pract_relation_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					menu_value = checkForNull(resultSet.getString( "Menu" ),"X") ;  // If not found then X
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
			return menu_value;
	}	 // End of the getMenu


	public HashMap insert(){
			HashMap map = new HashMap() ;
		/*	map.put( "result", new Boolean( false ) ) ;
			try{


	 			traceVals.append("<><>map result is true<><>");
				//traceVals.append("requset"+(request == null));
				//java.util.Properties props = null;

				if(request == null)
					traceVals.append("====request isnull> after the methoid");
				else
				{
					traceVals.append("====map> getting session ");
				//	HttpSession session = request.getSession(false);
				//	traceVals.append("====map> got session: " + session ); 
				}
	*/
				//OnLinePrinting online_print = new OnLinePrinting(request,response);
/*				OnLinePrinting online_print = new OnLinePrinting();
				

				String total_records = (String)allValues.get("total_recs");
				int int_total_records = Integer.parseInt(total_records);

				Hashtable resultHash	= new Hashtable();
				Hashtable orderHash		= new Hashtable();

				//int result_count		= 0;
				int order_count			= 0;

				for(int i=0; i<int_total_records; i++){
					String chk_val = ((String)allValues.get("chk"+i));
					if(chk_val==null) chk_val = "";
					
					if( chk_val.equalsIgnoreCase("Y")){
						String order_status = (String)allValues.get("ord_status"+i);
						String result_yn	= getResultYN(order_status);
						
						if (result_yn.equals("Y")) {
							
							resultHash.put("ord_typ_code",((String)allValues.get("ord_typ_code"+i)));
							resultHash.put("ord_typ_desc",((String)allValues.get("ord_typ_desc"+i)));
							resultHash.put("patient_class",((String)allValues.get("patient_class"+i)));
							resultHash.put("priority",((String)allValues.get("priority"+i)));
							resultHash.put("ord_id",((String)allValues.get("ord_id"+i)));
							resultHash.put("source_type",((String)allValues.get("source_type"+i)));
							resultHash.put("location_code",((String)allValues.get("location_code"+i)));
							resultHash.put("report_srl_no","1");
 							resultHash.put("facility_id",((String)allValues.get("facility_id")));
							resultHash.put("order_entry",((String)allValues.get("order_entry")));
							resultHash.put("mode",((String)allValues.get("mode")));
							//resultHash.put("total_recs",""+result_count);
							//result_count++;
							map = (HashMap)online_print.printResultEntryReport(resultHash, request, response);
						
							//String tmp_vals = (String)map.get("traceVal");

						} else {
							orderHash.put("chk"+order_count,((String)allValues.get("chk"+i)));
							//orderHash.put("facility_id"+order_count,((String)allValues.get("facility_id"+i)));
							orderHash.put("ord_typ_code"+order_count,((String)allValues.get("ord_typ_code"+i)));
							orderHash.put("ord_typ_desc"+order_count,((String)allValues.get("ord_typ_desc"+i)));
							orderHash.put("patient_class"+order_count,((String)allValues.get("patient_class"+i)));
							orderHash.put("priority"+order_count,((String)allValues.get("priority"+i)));
							orderHash.put("ord_id"+order_count,((String)allValues.get("ord_id"+i)));
							orderHash.put("source_type"+order_count,((String)allValues.get("source_type"+i)));
							orderHash.put("location_code"+order_count,((String)allValues.get("location_code"+i)));
							order_count++;
						}
					}
				}
                orderHash.put("facility_id",((String)allValues.get("facility_id")));
				orderHash.put("order_entry",((String)allValues.get("order_entry")));
				orderHash.put("mode",((String)allValues.get("mode")));
				orderHash.put("total_recs",""+order_count);

				//map = (HashMap)online_print.callOnlinePrint(allValues);
			
				map = (HashMap)online_print.callOnlinePrint(allValues, request, response);
			
			//	map = (HashMap)online_print.callOnlinePrint(orderHash);
			
				//String tmp_vals = (String)map.get("traceVal");
		

			}catch(Exception e){

			}
		map.put("traceVal", traceVals.toString());
*/
		return map;

	}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
			allValues = recordSet;
            allValues.put("order_entry","ExistingOrder");
			if(recordSet.containsKey("view")){			setViewType((String)recordSet.get("view"));}
			if(recordSet.containsKey("order_category")){setOrderCategory((String)recordSet.get("order_category"));}
			if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));	}
			if(recordSet.containsKey("order_type")){		setOrderType((String)recordSet.get("order_type"));	}
			if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
			if(recordSet.containsKey("location_type")){ 	setLocationType((String)recordSet.get("location_type"));}
			if(recordSet.containsKey("locn")){				setLocation((String)recordSet.get("locn"));	}
			if(recordSet.containsKey("patientId")){		setPatientId((String)recordSet.get("patientId"));}
			if(recordSet.containsKey("encntr_id")){  		setEncntrId((String)recordSet.get("encntr_id"));}
			if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
			if(recordSet.containsKey("date_from")){
				
				String date_from=(String)recordSet.get("date_from");
				 if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) date_from = "";
					
					
					if (!language_id.equals("en")){
					date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
					}
				setDateFrom(date_from);}
			if(recordSet.containsKey("date_to")){
				
				String  date_to=(String)recordSet.get("date_to");

				if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) date_to = "";
					
					
					if (!language_id.equals("en")){
					date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
					}

				setDateTo(date_to);}

			if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}

			this.mode = (String)recordSet.get( "mode" );
//			this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
//			this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
		}

public String[] getHeaderLineCancelReason(String order_id) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String cancel_data[]		= new String[8];
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_HEADER_LINE_CANCEL_REASON") ) ;
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					cancel_data[0] = resultSet.getString("can_line_reason");
					cancel_data[1] = resultSet.getString("can_pract_id");
					cancel_data[2] = resultSet.getString("can_date_time");
					cancel_data[3] = resultSet.getString("disc_pract_id");
					cancel_data[4] = resultSet.getString("disc_date_time");
					cancel_data[5] = resultSet.getString("hold_pract_id");
					cancel_data[6] = resultSet.getString("hold_date_time");
					cancel_data[7] = resultSet.getString("last_action_reason_desc");
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
			return cancel_data;
	}	 // End of the getHeaderLineCancelReason

    public String getFormDesc(String form_code) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String form_desc			= "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_PH_FORM_DESC") ) ;
			pstmt.setString(1, form_code);
			pstmt.setString(2, language_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					form_desc = checkForNull(resultSet.getString( "form_desc" ),"") ;
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
			return form_desc;
	}	 // End of the getFormDesc -- For PH Order

	public String getSplitDosageYN(String order_id, String order_line_num) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String split_dose_yn		= "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_PH_SPLIT_DOSE_YN") ) ;
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					split_dose_yn = checkForNull(resultSet.getString( "split_dose_yn" ),"") ;
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
			return split_dose_yn;
	}	 // End of the getFormDesc -- For PH Order

    // 	When Diagnosis All is selected, call the function(Care Set Tab)
	public String[] getDiagCode(Properties properties) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] 	  diag_code		= new String[2];
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CARE_SET_DIAG_CODE"));
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					diag_code[0] = resultSet.getString("scheme");
					diag_code[1] = resultSet.getString("scheme_desc");
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}
		return diag_code;
	} // End of getDiagCode

	public ArrayList getPatientClass(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PatientClass = new ArrayList() ;

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST") ) ;
			pstmt.setString(1,language_id);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "PATIENT_CLASS" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;

				PatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);

		}

		return PatientClass;
	}

	public ArrayList getLocation(Properties properties, String location_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Location = new ArrayList() ;
		//chk = "";
		try {
			location_type = (location_type == null) ? "" : location_type;
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN") ) ;
 			
			pstmt.setString( 1,language_id);
			pstmt.setString( 2,language_id);
			pstmt.setString( 3,language_id);
			pstmt.setString( 4,language_id);
			pstmt.setString( 5, location_type.trim() ) ;
 			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				Location.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return Location;
	}

	public ArrayList getOrderLineData(Properties properties, String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderLineData		= new ArrayList() ;
		//chk = "";
		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_ORDER_ORDER_LINE_SELECT") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
        	resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_line_num" )  ;
				record[1] = resultSet.getString( "order_catalog_code" )  ;

				OrderLineData.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return OrderLineData;
	}
	//IN042045 included practitioner_type
	//public ArrayList viewCopyOrderDetails(String patient_id,String encounter_id,String patient_class,String from_date,String to_date,String order_category,String order_type_code,String facility_id,String cur_encounter_id,String cur_patient_class,String record1,String record2,String discharge_adv_date_time,String ord_pract_id,String catalog,String view_by,String search_criteria,String activity_type,String location_type,String locn)
	//IN052649 Satrt.
	//public ArrayList viewCopyOrderDetails(String patient_id,String encounter_id,String patient_class,String from_date,String to_date,String order_category,String order_type_code,String facility_id,String cur_encounter_id,String cur_patient_class,String record1,String record2,String discharge_adv_date_time,String ord_pract_id,String catalog,String view_by,String search_criteria,String activity_type,String location_type,String locn,String practitioner_type) throws Exception {
	public ArrayList viewCopyOrderDetails(String patient_id,String encounter_id,String patient_class,String from_date,String to_date,String order_category,String order_type_code,String facility_id,String cur_encounter_id,String cur_patient_class,String record1,String record2,String discharge_adv_date_time,String ord_pract_id,String catalog,String view_by,String search_criteria,String activity_type,String location_type,String locn,String practitioner_type,String speciality_code,String OrderingSpecialityCopyPreviousOrder) throws Exception {
		//IN052649 End.
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList copyOrderDetails = new ArrayList();

		patient_id = (patient_id == null) ? "" : patient_id.trim();
		encounter_id = (encounter_id == null) ? "" : encounter_id.trim();
		patient_class = (patient_class == null) ? "" : patient_class.trim();
		from_date = (from_date == null) ? "" : from_date.trim();
		to_date = (to_date == null) ? "" : to_date.trim();
       /* Thai date validations start 14/02/2007*/

	        if(from_date == null || from_date.equals("null") || from_date.equals("&nbsp;") || from_date.equals(" ")) from_date = "";
            if(to_date == null || to_date.equals("null") || to_date.equals("&nbsp;") || to_date.equals(" ")) to_date = "";
					if (!language_id.equals("en")){

             from_date = com.ehis.util.DateUtils.convertDate(from_date,"DMY",language_id,"en");
             to_date = com.ehis.util.DateUtils.convertDate(to_date,"DMY",language_id,"en");
			}
			/* Thai date validations end 14/02/2007*/



		order_category = (order_category == null) ? "" : order_category.trim();
		order_type_code = (order_type_code == null) ? "" : order_type_code.trim();
		//--[IN029659] - Start
		facility_id = (facility_id == null) ? "" : facility_id.trim();
		cur_encounter_id = (cur_encounter_id == null) ? "" : cur_encounter_id.trim();
		cur_patient_class = (cur_patient_class == null) ? "" : cur_patient_class.trim();
		record1 = (record1 == null) ? "" : record1.trim(); //Admission date
		record2 = (record2 == null) ? "" : record2.trim(); //Discharge date
		discharge_adv_date_time = (discharge_adv_date_time == null) ? "" : discharge_adv_date_time.trim();
		//--[IN029659] - End
		ord_pract_id = (ord_pract_id == null) ? "" : ord_pract_id.trim();
		catalog			= (catalog == null) ? "" : catalog.trim();
		view_by			= (view_by == null) ? "L" : view_by.trim();
		search_criteria = (search_criteria == null) ? "S" : search_criteria.trim();
		activity_type	= (activity_type == null) ? "" : activity_type.trim();
		location_type	= (location_type == null) ? "" : location_type.trim();
		locn	= (locn == null) ? "" : locn.trim();
		String specialityWhereCon = "";
		if(!"".equals(speciality_code)){
			if("P".equals(OrderingSpecialityCopyPreviousOrder)){
				specialityWhereCon = "AND (? IN (SELECT   primary_speciality_code FROM   am_practitioner WHERE   practitioner_id = a.ord_pract_id UNION ALL SELECT   speciality_code FROM   am_pract_specialities WHERE   facility_id = ? AND practitioner_id = a.ord_pract_id))";
			}else if("E".equals(OrderingSpecialityCopyPreviousOrder)){
				specialityWhereCon = "AND (? IN (SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=a.encounter_id))";
			}else if("A".equals(OrderingSpecialityCopyPreviousOrder)){
				specialityWhereCon = "AND (? IN (SELECT   primary_speciality_code FROM   am_practitioner WHERE   practitioner_id = a.ord_pract_id UNION ALL SELECT  speciality_code FROM   am_pract_specialities WHERE   facility_id = ? AND practitioner_id = a.ord_pract_id  UNION ALL SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=a.encounter_id))";
			}
		}
		try {
			connection = getConnection() ;
				if (view_by.equals("L")) {
					//System.out.println("sql @ line level"+OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_ORDER_SEARCH_BY_LINE"));
					//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_ORDER_SEARCH_BY_LINE") ) ;//Modified - [IN029659]
					//pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth) age FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//[IN041931] starts
					//pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth) age FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");//IN042045
					//IN044165 starts
					//pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth) age FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code)) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					// IN052649 Start.
					//pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth) age FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code)) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//IN061958 Start
					//pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth) age FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code)) "+specialityWhereCon+" ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					pstmt = connection.prepareStatement("SELECT a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,DECODE(NVL(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class,a.order_id order_id,a.patient_id,encounter_id,TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time ,OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,b.order_catalog_code catalog_code,b.priority priority,b.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc, a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1') ordering_pract_name,order_line_status   order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,b.order_line_num order_line_num,b.item_narration  item_narration,a.source_type source_type,a.source_code source_code,NVL(b.cont_order_ind,'DO') cont_order_ind,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,a.iv_prep_yn iv_prep_yn,b.catalog_synonym_dc catalog_desc,d.sex sex,d.date_of_birth dob, GET_AGE(d.date_of_birth,a.ord_date_time) age,(SELECT DEPT_ONLY_YN  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code) DEPT_ONLY_YN FROM or_order a, or_ordeR_line b,or_ordeR_status_code c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id and a.patient_id=d.patient_id AND NVL(b.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND a.patient_id = ? AND b.order_line_status = c.ordeR_status_code AND encounter_id = NVL((?),encounter_id) AND a.patient_class = NVL(?,a.patient_class) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND  a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code)  and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?))  AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND b.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_code FROM or_ORDER_STATUS_code WHERE ORDER_STATUS_type IN ('55','58','60','64','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type ,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code)) "+specialityWhereCon+" ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//IN061958 End.
					//IN052649 End.
					//IN044165 ends
					//[IN041931] ends
				}else if (view_by.equals("H")) {
					//System.out.println("in header"+OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_ORDER_SEARCH_BY_HEADER") );
					//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_ORDER_SEARCH_BY_HEADER") ) ;//Modified - [IN029659]
					//pstmt = connection.prepareStatement("SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,   DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time /*,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time*/ , or_get_order_catalog(a.order_id,a.order_type_code,?)  order_detail, a.source_type source_type,a.source_code source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1')  ordering_pract_name,  a.order_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') order_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.source_type source_type,a.source_code source_code,NVL(a.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,c.sex sex,c.date_of_birth dob, GET_AGE(c.date_of_birth) age FROM or_order a,or_order_line b,mp_patient c WHERE a.order_id = b.order_id AND B.ORDER_LINE_NUM=1 AND a.patient_id=c.patient_id and a.patient_id = ? AND a.encounter_id = NVL((?),a.encounter_id) AND a.patient_class = NVL((?),a.patient_class) AND NVL(a.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code) and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?)) AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND a.order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//[IN041931] starts
					//pstmt = connection.prepareStatement("SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,   DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time /*,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time*/ , or_get_order_catalog(a.order_id,a.order_type_code,?)  order_detail, a.source_type source_type,a.source_code source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1')  ordering_pract_name,  a.order_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') order_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.source_type source_type,a.source_code source_code,NVL(a.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,c.sex sex,c.date_of_birth dob, GET_AGE(c.date_of_birth) age FROM or_order a,or_order_line b,mp_patient c WHERE a.order_id = b.order_id AND B.ORDER_LINE_NUM=1 AND a.patient_id=c.patient_id and a.patient_id = ? AND a.encounter_id = NVL((?),a.encounter_id) AND a.patient_class = NVL((?),a.patient_class) AND NVL(a.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code) and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?)) AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND a.order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");//IN042045
					//IN052649 Start.
					//pstmt = connection.prepareStatement("SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,   DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time /*,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time*/ , or_get_order_catalog(a.order_id,a.order_type_code,?)  order_detail, a.source_type source_type,a.source_code source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1')  ordering_pract_name,  a.order_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') order_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.source_type source_type,a.source_code source_code,NVL(a.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,c.sex sex,c.date_of_birth dob, GET_AGE(c.date_of_birth) age FROM or_order a,or_order_line b,mp_patient c WHERE a.order_id = b.order_id AND B.ORDER_LINE_NUM=1 AND a.patient_id=c.patient_id and a.patient_id = ? AND a.encounter_id = NVL((?),a.encounter_id) AND a.patient_class = NVL((?),a.patient_class) AND NVL(a.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code) and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?)) AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND a.order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code)) ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//IN061958 Start.
					//pstmt = connection.prepareStatement("SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,   DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time /*,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time*/ , or_get_order_catalog(a.order_id,a.order_type_code,?)  order_detail, a.source_type source_type,a.source_code source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1')  ordering_pract_name,  a.order_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') order_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.source_type source_type,a.source_code source_code,NVL(a.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,c.sex sex,c.date_of_birth dob, GET_AGE(c.date_of_birth) age FROM or_order a,or_order_line b,mp_patient c WHERE a.order_id = b.order_id AND B.ORDER_LINE_NUM=1 AND a.patient_id=c.patient_id and a.patient_id = ? AND a.encounter_id = NVL((?),a.encounter_id) AND a.patient_class = NVL((?),a.patient_class) AND NVL(a.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code) and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?)) AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND a.order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code))  "+specialityWhereCon+" ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					pstmt = connection.prepareStatement("SELECT  a.order_category order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,   DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time /*,TO_CHAR(b.start_date_time,'DD/MM/YYYY HH24:MI') start_date_time ,TO_CHAR(b.end_date_time,'DD/MM/YYYY HH24:MI') end_date_time*/ , or_get_order_catalog(a.order_id,a.order_type_code,?)  order_detail, a.source_type source_type,a.source_code source_code,a.priority priority,a.order_type_code  order_type_code, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ord_pract_id,?,'1')  ordering_pract_name,  a.order_status order_status, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') order_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.source_type source_type,a.source_code source_code,NVL(a.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,a.ordering_facility_id ordering_facility_id, SM_GET_DESC.SM_FACILITY_PARAM(a.ordering_facility_id,?,'1') ordering_facility_name,c.sex sex,c.date_of_birth dob, GET_AGE(c.date_of_birth,a.ord_date_time) age,(SELECT DEPT_ONLY_YN  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code) DEPT_ONLY_YN  FROM or_order a,or_order_line b,mp_patient c WHERE a.order_id = b.order_id AND B.ORDER_LINE_NUM=1 AND a.patient_id=c.patient_id and a.patient_id = ? AND a.encounter_id = NVL((?),a.encounter_id) AND a.patient_class = NVL((?),a.patient_class) AND NVL(a.cont_order_ind,'DO') IN ('DO','DR','CO','CR') AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND a.order_category = NVL((?),a.order_Category) AND a.order_type_code = NVL((?),a.order_type_code) and a.order_type_code not in ('TDM','PDC') and a.order_category!='OH' AND a.order_category in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?,'','','','','',b.order_catalog_code,?)) AND a.ord_pract_id = NVL((?),a.ord_pract_id)  AND upper(b.catalog_synonym_dc) LIKE DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) AND a.order_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('55','58','60','64','93','80','85','90','91','92','99')) AND exists (select 'X' from or_order_line where order_id = a.order_id and nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))) and nvl(SOURCE_TYPE,'X')=NVL((?),nvl(source_TYPE,'X')) and nvl(SOURCE_code,'X') =NVL((?),nvl(source_CODE,'X')) AND ('E' = (SELECT eff_status  FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code))  "+specialityWhereCon+" ORDER BY TO_CHAR(a.Ord_Date_time,'YYYYMMDDHH24MI') DESC");
					//IN061958 End.
					//IN052649 End.
					//[IN041931] ends
				}
				pstmt.setString( 1, language_id); 
				pstmt.setString( 2, language_id ); 
				pstmt.setString( 3, language_id ); 
				pstmt.setString( 4, language_id ); 
				pstmt.setString( 5, language_id ); 
				pstmt.setString( 6, language_id ); 
				pstmt.setString( 7, language_id ); 
				pstmt.setString( 8, patient_id ) ;
				pstmt.setString( 9, encounter_id );
				pstmt.setString( 10, patient_class );
				pstmt.setString( 11, from_date );
				pstmt.setString( 12, to_date );
				pstmt.setString( 13, order_category );
				pstmt.setString( 14, order_type_code );
				pstmt.setString( 15, facility_id ); //-- [IN029659] - Start
			    pstmt.setString( 16, cur_encounter_id );
				pstmt.setString( 17, cur_patient_class );
				pstmt.setString( 18, record1 );
				pstmt.setString( 19, record2 );
				pstmt.setString( 20, discharge_adv_date_time );//-- [IN029659] - End
				pstmt.setString( 21, practitioner_type );//IN042045 Changed index values also
				pstmt.setString( 22, ord_pract_id );
			    pstmt.setString( 23, search_criteria );
				pstmt.setString( 24, catalog );
				pstmt.setString( 25, catalog );
				pstmt.setString( 26, catalog );
				pstmt.setString( 27, activity_type );
				pstmt.setString( 28, location_type);
				pstmt.setString( 29, locn);
				if(!"".equals(speciality_code)){
					if("P".equals(OrderingSpecialityCopyPreviousOrder)){
						pstmt.setString( 30, speciality_code);
						pstmt.setString( 31, facility_id);
					}else if("E".equals(OrderingSpecialityCopyPreviousOrder)){
						pstmt.setString( 30, speciality_code);
						pstmt.setString( 31, facility_id);
					}else if("A".equals(OrderingSpecialityCopyPreviousOrder)){
						pstmt.setString( 30, speciality_code);
						pstmt.setString( 31, facility_id);
						pstmt.setString( 32, facility_id);
					}
				}
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = null;
				if (view_by.equals("L")) {
					//record = new String[32] ;
					record = new String[33] ;
				} else {
					//record = new String[29];
					record = new String[30];
				}

				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "order_category_short_desc" )  ;
				record[2] = resultSet.getString( "order_type_short_desc" )  ;
				record[3] = resultSet.getString( "priority_desc" )  ;
				record[4] = resultSet.getString( "patient_class_short_desc" )  ;
				record[5] = resultSet.getString( "patient_class" )  ;
				record[6] = resultSet.getString( "order_id" )  ;
				record[7] = resultSet.getString( "patient_id" )  ;
				record[8] = resultSet.getString( "encounter_id" )  ; //used as serial number inthe page
				record[9] = resultSet.getString( "order_date_time" )  ;
				record[10] = resultSet.getString( "order_detail" )  ;
				record[11] = resultSet.getString( "source_type" )  ;
				record[12] = resultSet.getString( "source_code" )  ;
				record[13] = resultSet.getString( "priority" )  ;
				record[14] = resultSet.getString( "order_type_code" )  ;
				record[15] = resultSet.getString( "order_type_short_desc" )  ;
				record[16] = resultSet.getString( "ord_pract_id" )  ;
				record[17] = resultSet.getString( "ordering_pract_name" )  ;
				record[18] = resultSet.getString( "order_status" )  ;
				record[19] = resultSet.getString( "order_status_short_desc" )  ;
				record[20] = resultSet.getString( "cont_order_ind" )  ;
				record[21] = resultSet.getString( "sex" )  ;
				record[22] = resultSet.getString( "dob" )  ;
				record[23] = resultSet.getString( "ordering_facility_id" )  ;
				record[24] = resultSet.getString( "ordering_facility_name" )  ;
				record[25] = resultSet.getString( "iv_prep_yn" )  ;
				record[26] = resultSet.getString( "age" )  ;
				if (view_by.equals("L")) 
				{
					record[27] = resultSet.getString( "start_date_time" );
					record[28] = resultSet.getString( "end_date_time" );
					record[29] = resultSet.getString( "order_line_num" )  ;
					record[30] = resultSet.getString( "catalog_code" )  ;
					record[31] = resultSet.getString( "catalog_desc" )  ;
					record[32] = resultSet.getString( "DEPT_ONLY_YN" )  ;
				}
				else
				{
					record[27] = resultSet.getString( "order_date_time" );
					record[28] = "";
					record[29] = resultSet.getString( "DEPT_ONLY_YN" )  ;
				}


				copyOrderDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
        setBeanValues(copyOrderDetails);
		return copyOrderDetails;
	}

    public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();
		String sql = "";//IN030416
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_MONTH_DAY_TIME") ) ;//IN030416
			sql = "SELECT TO_CHAR (SYSDATE, 'HH24:MM') sys_time,TO_CHAR (SYSDATE, 'dd/mm/yyyy') sys_date,TO_CHAR (SYSDATE, 'DD/mm/yyyy') || ' 23:59' curr_date,TO_CHAR (SYSDATE - 7, 'DD/mm/yyyy') || ' 00:00' last_week_date,TO_CHAR (SYSDATE + 7, 'DD/mm/yyyy')  next_week_date,TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_date_time,TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'DD/mm/yyyy') last_month_date,TO_CHAR (ADD_MONTHS (SYSDATE, -1),'DD/mm/yyyy') || ' 00:00' last_month_date_time FROM DUAL";
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("next_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date"))  ;
				currentDate.add(resultSet.getString("last_month_date"));
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public ArrayList getDiagnosisSpecific(Properties properties, String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Diagnosis = new ArrayList() ;
		//chk = "";
		try {
			patient_id = (patient_id == null) ? "" : patient_id;
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_COPY_OEDER_DIAG_CODE_SPECIFIC") ) ;
		//	pstmt.setString( 1, facility_id.trim() ) ;
			pstmt.setString( 1, patient_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "code" )  ;
				record[1] = resultSet.getString( "description" )  ;

				Diagnosis.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return Diagnosis;
	}

    public String getDiagnosisDesc(Properties properties, String orderable_text_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  diag_desc			= "";
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_DESC"));
			pstmt.setString(1, checkForNull(orderable_text_id,""));
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					diag_desc = resultSet.getString("short_desc");
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}
		return diag_desc;
	} // End of getDiagnosisDesc

	public String getColorCodings(String facility_id,String order_id,String order_catalog_code,String order_line_num) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  colorString		= "X,X,X";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_COLOR_SELECT"));
			pstmt.setString(1, checkForNull(facility_id,""));
			pstmt.setString(2, checkForNull(order_id,""));
			pstmt.setString(3, checkForNull(order_catalog_code,""));
			pstmt.setString(4, checkForNull(order_line_num,""));
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					colorString = resultSet.getString(1);
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
		return colorString;
	} // End of getColorCodings
 

	public ArrayList getEncounterDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList EncounterDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_GET_OLD_ENCOUNTER_DETAILS") ) ;
			pstmt.setString( 1,order_id ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[5];
				record[0] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
				record[1] = checkForNull(resultSet.getString( "episode_id" ),"")  ;
				record[2] = checkForNull(resultSet.getString( "episode_visit_num" ),"")  ;
				record[3] = checkForNull(resultSet.getString( "source_type" ),"")  ;
				record[4] = checkForNull(resultSet.getString( "source_code" ),"")  ;
				EncounterDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return EncounterDetails;
	}

	//public String[] updateEncounterDetails(String encounter_id,String old_encounter_id,String old_episode_id,String old_visit_num,String old_source_type,String old_source_code,String order_id,String order_line_num) throws Exception{
	public String[] updateEncounterDetails(String encounter_id,String old_encounter_id,String old_episode_id,String old_visit_num,String old_source_type,String old_source_code,String order_id,String order_line_num,String p_called_from_ca) throws Exception{//IN071315
		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		ResultSet resultSet 		= null;
		CallableStatement cstmt		= null;
		CallableStatement cstmt1	= null;

		int	result					= 1;
		String[] encounter_details  = new String[2];
		String 	  flag				= "N";

		String curr_encounter_id	= "";
		String curr_episode_id		= "";
		String curr_visit_num		= "";
		String curr_source_type		= "";
		String curr_source_code		= "";
		String curr_patient_class   = "";
		String p_error_message		= "";
		try
		{
			connection = getConnection();

			connection.setAutoCommit( false ) ;
			cstmt	= connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
			cstmt1	= connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_BILLING_ACTIVATION") +" }");
			pstmt1	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_GET_CURR_ENCOUNTER_DETAILS"));
			pstmt1.setString(1, checkForNull(login_facility_id,""));
			pstmt1.setString(2, checkForNull(encounter_id,""));
			resultSet = pstmt1.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					curr_encounter_id	= checkForNull(resultSet.getString(1),"");
					curr_episode_id		= checkForNull(resultSet.getString(2),"");
					curr_visit_num		= checkForNull(resultSet.getString(3),"");
					curr_source_type	= checkForNull(resultSet.getString(4),"");
					curr_source_code	= checkForNull(resultSet.getString(5),"");
					curr_patient_class  = checkForNull(resultSet.getString(6),"");
				}
			}

				// Cancel the billing for the future orders
 				cstmt.setString(1, checkForNull(login_facility_id,"")); 					// P_FACILITY_ID
				cstmt.setString(2, order_id);						// P_ORDER_ID
				cstmt.setString(3, order_line_num);					// P_ORDER_LINE_NUM
				cstmt.setString(4, "CAN"); 							// P_MODE
				cstmt.setString(5, login_by_id);							// P_USER
				cstmt.setString(6, login_at_ws_no);						// P_WS_NO
			 	cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE	
				//IN071315 Starts
				if("Y".equals(p_called_from_ca))
					cstmt.setString(9, "CA");
				else
					cstmt.setString(9, "OR");
				//IN071315 Ends
				cstmt.execute();
				p_error_message	= cstmt.getString(8);  // message
				if(p_error_message!=null && !p_error_message.equals(""))
					result = 0;
				else result = 1;			

	  		//if (order_line_num == null || order_line_num.equals("")) {			
			if(result > 0) {
				pstmt2 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_UPDATE_ORDER_HDR"));
				pstmt2.setString(1,curr_encounter_id);
				pstmt2.setString(2,curr_episode_id);
				pstmt2.setString(3,curr_visit_num);
				pstmt2.setString(4,curr_source_type);
				pstmt2.setString(5,curr_source_code);
				pstmt2.setString(6,old_encounter_id);
				pstmt2.setString(7,old_episode_id);
				pstmt2.setString(8,old_visit_num);
				pstmt2.setString(9,old_source_type);
				pstmt2.setString(10,old_source_code);
				pstmt2.setString(11,curr_patient_class);
				pstmt2.setString(12,order_id);
				result = pstmt2.executeUpdate();
			}
			//} else {
			/*if (result > 0)	{
				pstmt2 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_UPDATE_ORDER_LINE"));
				pstmt2.setString(1,order_id);
				pstmt2.setString(2,order_line_num);				
				result = pstmt2.executeUpdate();
			}
			*/
			if(result>0) {
				cstmt1.setString(1, checkForNull(order_id,"")); 	// P_ORDER_ID
 			 	cstmt1.registerOutParameter( 2,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
				cstmt1.execute();
				p_error_message	= cstmt1.getString(2);  // message
				if(p_error_message!=null && !p_error_message.equals(""))
					result = 0;
				else result = 1;
			} 

			// Billing for the New order with mode as"REG"
			/*if(result>0) {
				cstmt.setString(1, checkForNull(login_facility_id,"")); 					// P_FACILITY_ID
				cstmt.setString(2, order_id);						// P_ORDER_ID
				cstmt.setString(3, order_line_num);					// P_ORDER_LINE_NUM
				cstmt.setString(4, "REG"); 							// P_MODE
				cstmt.setString(5, login_by_id);							// P_USER
				cstmt.setString(6, login_at_ws_no);						// P_WS_NO
			 	cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
				cstmt.execute();
				p_error_message	= cstmt.getString(8);  // message
				if(p_error_message!=null && !p_error_message.equals(""))
					result = 0;
				else result = 1;
			}*/

			// Billing for the new Order
			if(result>0){
				// ORDer the billing for the future orders
 				cstmt.setString(1, checkForNull(login_facility_id,"")); 					// P_FACILITY_ID
				cstmt.setString(2, order_id);						// P_ORDER_ID
				cstmt.setString(3, order_line_num);					// P_ORDER_LINE_NUM
				cstmt.setString(4, "ORD"); 							// P_MODE
				cstmt.setString(5, login_by_id);							// P_USER
				cstmt.setString(6, login_at_ws_no);						// P_WS_NO
			 	cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
				cstmt.execute();
				p_error_message	= cstmt.getString(8);  // message
				if(p_error_message!=null && !p_error_message.equals(""))
					result = 0;
				else result = 1;
			}

			if (result > 0)	{
				flag = "Y";//"Orders have been activated to the current encounter";
				connection.commit() ;
			}
			else {
				connection.rollback();
			}
		}catch(Exception e)
		{
			flag = "N";
			connection.rollback();
			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt2 ) ;
			closeStatement( cstmt ) ;
			closeStatement( cstmt1 ) ;
			closeConnection(connection);
		}
		encounter_details[0] = flag;
		encounter_details[1] = p_error_message;
		//return flag;
		return encounter_details;
	} // End of updateEncounterDetails

	public String getPractitionerName(Properties properties, String practitioner_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String practitioner_name = "";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_PRACT_DTLS") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, practitioner_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				practitioner_name = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return practitioner_name;
	}

	public String getFacilityName(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String facility_name = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_FACILITY_NAME") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, facility_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				facility_name = resultSet.getString(2)  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return facility_name;
	}

	public String getFacilityName(Properties properties, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String facility_name = "";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_FACILITY_NAME") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, facility_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				facility_name = resultSet.getString(2)  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return facility_name;
	}

	public String getTradeName(String order_id,String order_line_num) throws Exception { //Added by Prasad on 6/8/2007
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String tradename 		= null;
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_GET_TRADE_NAME") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, order_id);
			pstmt.setString(3, order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					tradename = checkForNull(resultSet.getString( "TRADE_NAME" ),"**") ;
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
		return tradename;
	}

	public String getResultYN(String order_status) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String result_yn			= "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RESULTED_YN") ) ;
			pstmt.setString(1, order_status);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while(resultSet.next()) {
					result_yn = checkForNull(resultSet.getString( "result_yn" ),"") ;
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
			return result_yn;
	}	 // End of the getFormDesc -- For PH Order

	public String[] getOrderDetails(String order_id)throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String order_data[] = new String[7];
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_DTLS") ) ;
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
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return order_data;
	}

	public ArrayList  getActivityType(String order_category, String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		ArrayList ActivityType		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category.trim() ) ;
			pstmt.setString( 3, order_type.trim() ) ;
			//pstmt.setString( 4, language_id);
			//pstmt.setString( 5, order_category.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;
			while(resultSet.next())
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "activity_type" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				ActivityType.add(record) ;
				
			}
						
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return ActivityType;
	}

	// overridden methods, pass the properties and get the connection, so that can use as page scope
	public ArrayList  getActivityType(Properties properties, String order_category, String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		ArrayList ActivityType		= new ArrayList();

		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, order_category.trim() ) ;
				pstmt.setString( 3, order_type.trim() ) ;
				//pstmt.setString( 4, language_id);
				//pstmt.setString( 5, order_category.trim() ) ;
				

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next())
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "activity_type" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					ActivityType.add(record) ;
					
				}
							
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return ActivityType;
	}

	public ArrayList getCommentData(String order_id, String ord_line_num) throws Exception { //Added by Prasad on 2/4/2007
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList comment_data = new ArrayList();
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_ORDER_LINE_REMARKS")) ; IN033472
			//pstmt = connection.prepareStatement("SELECT APPT_RESCHED_REASON,item_narration,can_line_reason FROM or_order_line WHERE order_id =? AND order_line_num=?");//IN033472//IN64543
			pstmt = connection.prepareStatement("SELECT APPT_RESCHED_REASON,item_narration,can_line_reason,ITEM_NARRATION_FREE_FMT,NVL(INSTRUCTION_TYPE,'T')INSTRUCTION_TYPE FROM or_order_line WHERE order_id =? AND order_line_num=?");//IN64543
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3] ;
				record[0] = resultSet.getString("item_narration")  ;
				record[1] = resultSet.getString("can_line_reason")  ;
				record[2] = resultSet.getString("APPT_RESCHED_REASON");//IN033472
				//IN64543, starts
				if((resultSet.getString("INSTRUCTION_TYPE")).equals("E"))
					record[0] = resultSet.getString("ITEM_NARRATION_FREE_FMT");
				//IN64543, ends
				comment_data.add(record);
			}
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return comment_data;
	}

	public ArrayList getHeaderCommentData(String order_id, String order_status) throws Exception { //Added by Hari on 10/04/2007
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList comment_data = new ArrayList();
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_ORDER_REMARKS")) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)order_status.trim());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				//String[] record = new String[2] ; //Commented for IN062072
				String[] record = new String[3] ; //IN062072
				record[0] = resultSet.getString("item_narration")  ;
				record[1] = resultSet.getString("can_line_reason")  ;
				record[2] = resultSet.getString("APPT_RESCHED_REASON"); //IN062072
				comment_data.add(record);
			}
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return comment_data;
	}
	
	

	
	
	
	/*public String getCatalogNature (String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_catalog_nature = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_CATALOG_NATURE") ) ;
			pstmt.setString(1, order_id.trim());
			
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				order_catalog_nature  = resultSet.getString("order_catalog_nature")  ;
				
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return order_catalog_nature;
	}*/
public String[] viewPrintDetails(String order_id) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[43] ;


		try {
				connection = getConnection() ;
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_PRINT") ) ;
				//IN061958 Start.
				//pstmt = connection.prepareStatement("SELECT a.order_category order_category,       or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,a.patient_class,   a.order_id order_id,decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,b.sex,get_age (b.date_of_birth) age,a.Patient_id,a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type_code, ?) order_detail,a.source_type, a.source_code, a.priority priority,a.order_type_code order_type_code, a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,a.order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn,sm_get_desc.sm_facility_param(a.ordering_facility_id,?,'1') ordering_facility,sm_get_desc.sm_facility_param(a.performing_facility_id,?,'1') performing_facility,       SUBSTR (a.order_fields_display_text, 1, 40) order_format,a.ordering_facility_id, a.iv_prep_yn,a.order_mode,a.performing_deptloc_type, a.performing_deptloc_code,a.performing_pract_id, a.ref_facility_id,TO_CHAR (a.ref_date_time, 'dd/mm/yyyy hh24:mi') ref_date_time,a.ref_sent_pract_id, a.ref_sent_remarks, a.ref_report_pract_id,TO_CHAR (a.ref_report_date_time,'dd/mm/yyyy hh24:mi' ) ref_report_date_time,TO_CHAR (a.ref_recieved_date_time,'dd/mm/yyyy hh24:mi') ref_recieved_date_time, a.ref_recieved_pract_id, a.ref_recieved_remarks,( select MAX (action_seq_num)  from  or_order_comment where order_id=a.order_id) action_seq_num, sm_get_desc.sm_appl_user(a.added_by_id,?,1) appl_user_name,nvl((select IMAGE_REF_YN from OR_order_line where order_id=a.order_id and IMAGE_REF_YN='Y'),'N') IMAGE_REF_YN,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,mp_get_desc.mp_country(b.nationality_code,?,1) nationality_long_name,b.national_id_no  national_id_no,performing_appl_id  FROM or_order a,mp_patient b WHERE order_id = (?) and b.patient_id=a.patient_id") ;
				pstmt = connection.prepareStatement("SELECT a.order_category order_category,       or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,a.patient_class,   a.order_id order_id,decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,b.sex,get_age (b.date_of_birth,a.ord_date_time) age,a.Patient_id,a.encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type_code, ?) order_detail,a.source_type, a.source_code, a.priority priority,a.order_type_code order_type_code, a.ord_pract_id ord_pract_id,nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name,a.order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn,sm_get_desc.sm_facility_param(a.ordering_facility_id,?,'1') ordering_facility,sm_get_desc.sm_facility_param(a.performing_facility_id,?,'1') performing_facility,       SUBSTR (a.order_fields_display_text, 1, 40) order_format,a.ordering_facility_id, a.iv_prep_yn,a.order_mode,a.performing_deptloc_type, a.performing_deptloc_code,a.performing_pract_id, a.ref_facility_id,TO_CHAR (a.ref_date_time, 'dd/mm/yyyy hh24:mi') ref_date_time,a.ref_sent_pract_id, a.ref_sent_remarks, a.ref_report_pract_id,TO_CHAR (a.ref_report_date_time,'dd/mm/yyyy hh24:mi' ) ref_report_date_time,TO_CHAR (a.ref_recieved_date_time,'dd/mm/yyyy hh24:mi') ref_recieved_date_time, a.ref_recieved_pract_id, a.ref_recieved_remarks,( select MAX (action_seq_num)  from  or_order_comment where order_id=a.order_id) action_seq_num, sm_get_desc.sm_appl_user(a.added_by_id,?,1) appl_user_name,nvl((select IMAGE_REF_YN from OR_order_line where order_id=a.order_id and IMAGE_REF_YN='Y'),'N') IMAGE_REF_YN,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,mp_get_desc.mp_country(b.nationality_code,?,1) nationality_long_name,b.national_id_no  national_id_no,performing_appl_id  FROM or_order a,mp_patient b WHERE order_id = (?) and b.patient_id=a.patient_id") ;
				//IN061958 End.
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);	
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, language_id);
				pstmt.setString( 12, language_id);
				pstmt.setString( 13, language_id);
				pstmt.setString( 14, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = resultSet.getString( "order_category_short_desc" )  ;
				record[1] = resultSet.getString( "order_type_short_desc" )  ;
				record[2] = resultSet.getString( "Priority_desc" )  ;
				record[3] = resultSet.getString( "sex" )  ;
				record[4] = resultSet.getString( "encounter_id" )  ;
				record[5] = resultSet.getString( "order_status_short_desc" )  ;
				record[6] = resultSet.getString( "patient_name" )  ;
				record[7] = resultSet.getString( "ordering_pract_name" )  ;
				record[8] = resultSet.getString( "ordering_facility" )  ;
				record[9] = resultSet.getString( "performing_facility" )  ;
				record[10] = resultSet.getString( "order_format" )  ;
                record[11] = resultSet.getString("ORD_PRACT_ID");
                record[12] = resultSet.getString("ORDER_DATE_TIME");
                record[13] = resultSet.getString("ordering_facility_id");
                record[14] = resultSet.getString("iv_prep_yn");
                record[15] = resultSet.getString("order_category");
                record[16] = resultSet.getString("order_mode");
                record[17] = resultSet.getString("performing_deptloc_type");
                record[18] = resultSet.getString("performing_deptloc_code");
                record[19] = resultSet.getString("performing_pract_id");
                record[20] = checkForNull(resultSet.getString("ref_facility_id"),"");
                record[21] = checkForNull(resultSet.getString("ref_date_time"),"");
                record[22] = checkForNull(resultSet.getString("ref_sent_pract_id"),"");
                record[23] = checkForNull(resultSet.getString("ref_sent_remarks"),"");
                record[24] = checkForNull(resultSet.getString("ref_report_pract_id"),"");
                record[25] = checkForNull(resultSet.getString("ref_report_date_time"),"");
                record[26] = checkForNull(resultSet.getString("ref_recieved_date_time"),"");
                record[27] = checkForNull(resultSet.getString("ref_recieved_pract_id"),"");
                record[28] = checkForNull(resultSet.getString("ref_recieved_remarks"),"");
                record[29] = checkForNull(resultSet.getString("action_seq_num"),"");
                record[30] = checkForNull(resultSet.getString("appl_user_name"),"");
                record[31] = checkForNull(resultSet.getString("IMAGE_REF_YN"),"N");
                record[32] = checkForNull(resultSet.getString("order_id"),"");
                record[33] = checkForNull(resultSet.getString("patient_class"),"");
                record[34] = checkForNull(resultSet.getString("age"),"");
                record[35] = checkForNull(resultSet.getString("Patient_id"),"");
                record[36] = checkForNull(resultSet.getString("source_type"),"");
                record[37] = checkForNull(resultSet.getString("source_code"),"");
                record[38] = checkForNull(resultSet.getString("location_description"),"");
                record[39] = checkForNull(resultSet.getString("nationality_long_name"),"");
                record[40] = checkForNull(resultSet.getString("national_id_no"),""); 
				record[41] = checkForNull(resultSet.getString("performing_appl_id"),"");
				record[42] = getReportedTime(order_id);
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}

	public String getReportedTime(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String reportingTime="";

		try 
		{
				
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PRACTITIONER_LB") ) ;
			pstmt = connection.prepareStatement("SELECT nvl(AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1'),performed_by_id) practitioner_name, to_char(event_date,'dd/mm/yyyy hh24:mi') collected_date,to_char(EVENT_AUTH_DATE_TIME,'dd/mm/yyyy hh24:mi') reported_time FROM am_practitioner a,cr_encounter_detail b WHERE  hist_rec_type = 'LBIN' AND contr_sys_id = 'LB' and b.request_num =    (select 'F' ||added_facility_id ||'#'|| accession_num  from OR_ORDER_LINE where ordeR_id = (?) AND ROWNUM<=1) and accession_num is not null and a.practitioner_id(+) = b.PERFORMED_BY_ID AND ROWNUM<=1") ;
			pstmt.setString( 1,language_id);
			pstmt.setString( 2, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next() ) 
			{
				reportingTime = resultSet.getString("reported_time")==null?"":resultSet.getString("reported_time");
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
			closeConnection(connection);

		}
		return reportingTime;
	}

	public String printSiteName() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String siteName="";

		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_ORDER_PRINT_SITE_NAME") ) ;
				pstmt.setString( 1, language_id);

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					siteName = checkForNull(resultSet.getString("site_name"),"");
				}
			} catch ( Exception e )	
			{
				e.printStackTrace() ;
				throw e ;
			} finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}
		return siteName;
	}
	public String getOrderSetDetails(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("bill_yn")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}

	public String[] getOrderSetViewDetails(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		//String record = "N" ;
		String[] record = new String[2] ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record[0] = resultSet.getString("bill_yn")  ;
				record[1] = resultSet.getString("contr_mod_id")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}


	public String getOrderSetId(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "";
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_ID") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("order_set_id" )  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
		return record;
	}

	public ArrayList getPREncounterDetails (String facility_id,String encounter_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList PREncounterDtls	= new ArrayList();
		try
		{
			connection = getConnection() ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ATTEND_PRACT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, checkForNull( facility_id,""));
			pstmt.setString(3, checkForNull( encounter_id,""));
			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )   // Only One Record
			{
				while(resultSet.next())
				{
					record	= new String[8];
					record[0] = checkForNull( resultSet.getString( "attend_practitioner_id" ), "" );
					record[1] = checkForNull( resultSet.getString( "practitioner_name" ), "" );
					record[2] = checkForNull( resultSet.getString( "discharge_date_time" ), "" );
					record[3] = checkForNull( resultSet.getString( "episode_id" ), "" );
					record[4] = checkForNull( resultSet.getString( "op_episode_visit_num" ), "" );
					record[5] = checkForNull( resultSet.getString( "team_id" ), "" );
					record[6] = checkForNull( resultSet.getString( "service_code" ), "" );
					record[7] = checkForNull( resultSet.getString( "visit_adm_date_time" ), "" );
					
					PREncounterDtls.add(record) ;
				}
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return PREncounterDtls;
	}	 // End of the getPREncounterDetails

	public String getRepPractDetails(String order_id, String ord_line_num, String localeName) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//ArrayList practitioner 		= new ArrayList();
		String reportingPractName = "";
		
		try 
		{
			connection = getConnection();
			pstmt = connection.prepareStatement("SELECT AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PRACTITIONER_NAME FROM AM_PRACTITIONER A,OR_RESULT_DETAIL B WHERE ORDER_ID = ? AND B.LINE_SRL_NO = ? AND A.PRACTITIONER_ID = B.REPORTING_PRACT_ID");
			pstmt.setString(1,localeName);
			pstmt.setString(2,order_id);
			pstmt.setString(3,ord_line_num);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				reportingPractName = resultSet.getString("PRACTITIONER_NAME") == null ? "" : resultSet.getString("PRACTITIONER_NAME");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return reportingPractName;
	}//end of getRepPractDetails

	public String getOrderID(String order_id,String func_mode) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String orderID = "";
		
		try 
		{
			connection = getConnection();
			if(func_mode.equalsIgnoreCase("ViewReplacedOrder"))
			{
				pstmt = connection.prepareStatement((String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_REPLACED_ORDER"));
			}
			else if(func_mode.equalsIgnoreCase("ViewOriginalOrder"))
			{
				pstmt = connection.prepareStatement((String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORIGINAL_ORDER"));
			}
			pstmt.setString(1,order_id);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				orderID = resultSet.getString("order_id") == null ? "" : resultSet.getString("order_id");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return orderID;
	}//end of getOrderID
	//-- [IN029659] - Start 
	
		public String getDischargeAdvDateTime(String patient_id, String encounter_id) throws Exception 
	{
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String discharge_adv_date_time = "";
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("select to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') DIS_ADV_DAT_TIM from ip_discharge_advice where patient_id=? and encounter_id=? and dis_adv_status != '9'"); 
			pstmt.setString(1, patient_id); // pass the patient_id
			pstmt.setString(2, encounter_id); // pass the encounter_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					discharge_adv_date_time = checkForNull(resultSet.getString( "DIS_ADV_DAT_TIM" ),"")  ;
						
				}
			}	// if there is no record, then also it should return as ""
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		 } 
		 finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return discharge_adv_date_time;
	}//end of getDischargeAdvDateTime
		public String[] getDischargeDateTime(String patient_id, String encounter_id) throws Exception 
	{
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String[] record = new String[2] ;
		
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("select TO_CHAR (visit_adm_date_time, 'DD/MM/YYYY HH24:MI') admit_dat_time,TO_CHAR (discharge_date_time,'DD/MM/YYYY HH24:MI') discharge_date_time  from pr_encounter WHERE patient_id = ? AND encounter_id = ? "); 
			pstmt.setString(1, patient_id); // pass the patient_id
			pstmt.setString(2, encounter_id); // pass the encounter_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					record[0] = checkForNull(resultSet.getString( "admit_dat_time" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "discharge_date_time" ),"")  ;
				}
			}	// if there is no record, then also it should return as ""
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		 } 
		 finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return record;
	}//end of getDischargeDateTime
	public String getCategoryChk(String order_category,String facility_id,String encounterId,String patientClas,String Adm_date,String Dis_date,String Adv_date) throws Exception 
	{
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String cat_chk = "";
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("Select  order_category from or_order_category where order_category = ? and ? in (SELECT order_category FROM or_order_category ia WHERE 'Y' = or_get_access_rule(?, ?, ia.order_category, ?, ?, ?, ?)) "); 
			pstmt.setString(1, order_category); 
			pstmt.setString(2, order_category); 
			pstmt.setString(3, facility_id); 
			pstmt.setString(4, encounterId); 
			pstmt.setString(5, patientClas); 
			pstmt.setString(6, Adm_date); 
			pstmt.setString(7, Dis_date); 
			pstmt.setString(8, Adv_date); 
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					cat_chk = checkForNull(resultSet.getString( "order_category" ),"")  ;
						
				}
			}	// if there is no record, then also it should return as ""
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		 } 
		 finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return cat_chk;
	}//end of getCategoryChk
	//-- [IN029659] - End
	//IN030416 Starts

	public int getActiveAllergyDetails(String patient_id)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		int count = 0;
		try
		{
			connection = getConnection() ;
			sql = "SELECT COUNT (*) FROM pr_allergy_sensitivity a WHERE patient_id = ? AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status LIKE 'A'";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString( 1, patient_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;		
			if (resultSet.next())
			{
				count = resultSet.getInt(1)  ;
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
		return count;
	}
	public String getDischargeAdviceDetails(String patient_id,String encntr_id)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		String record = "";
		try
		{
			connection = getConnection() ;
			sql = "select max(dis_adv_srl_no) into maxSrlNo from ip_discharge_advice where patient_id=? and encounter_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString( 1, patient_id.trim() ) ;
			pstmt.setString(2 , encntr_id ) ;
			resultSet = pstmt.executeQuery() ;		
			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString( "maxSrlNo" )  ;
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
		return record;
	}
	//IN27707 Starts
	public ArrayList getSingleContinuousOrderDetails(String view_type,String patient_id, String encntr_id, String order_status, String order_by, String catalog,String date_from,String date_to,String order_category,String order_type_code,String search_criteria,String priority,String view_by, String activity_type,String practitioner_type,String elapsed_orders,String sys_cancelled_orders,int start , int end,String responsibility_id,String ca_practitioner_id,String pract_reln_id,String category_type,String appl_user_id,String facility_id,String call_from,String called_frm1) throws Exception
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
		boolean isDfltOrderSts = isSiteSpecific("DEFAULT_ORDER_STATUS");
									
		int cnt						= 0;
								 
		String catalog_column_name	= "b.catalog_synonym";  //default
		catalog = catalog.trim();
		String encounter_id = encntr_id;
		String sql					= "";
		if(catalog==null)
			catalog	= "";

		if(((view_type.trim()).equals("A")) || ((order_status.trim()).equals("F")))
		{ 
			encntr_id = null;
		}
		else
		{ 
			encntr_id  = encntr_id .trim();
		}
			
		if(practitioner_type!=null && (practitioner_type.equals("PS") || practitioner_type.equals("DN") || practitioner_type.equals("MD") || practitioner_type.equals("SG") || practitioner_type.equals("NS")) ) 
		{
			catalog_column_name            = " nvl(b.catalog_synonym_dc,b.catalog_desc)";
		}  
		else if(practitioner_type!=null && (practitioner_type.equals("RD") || practitioner_type.equals("PT")) )
		{
			catalog_column_name            = " nvl(b.catalog_synonym_ad,b.catalog_desc)";
		}
		else
			catalog_column_name            = "nvl(b.catalog_synonym,b.catalog_desc)";

		try 
		{  
			connection = getConnection() ;

			if(order_status.equals("P"))
				order_status = "EXT_PEND_RVS" ;
			else if(order_status.equals("O"))
				order_status = "EXT_OUTSTAND" ;
			else if(order_status.equals("A"))
				order_status = "EXT_ACTIVE" ;
			else if(order_status.equals("F"))
				order_status = "EXT_FUTURE_ORD" ;
			else if(order_status.equals("C"))
				order_status = "EXT_COMPL_ORD" ;
			else if(order_status.equals("D"))
				order_status = "EXT_DISC_CAN" ;
			else if(order_status.equals("H"))
				order_status = "EXT_HOLD" ;
			else if(order_status.equals("Z"))
				order_status = "EXT_ALL" ;
			else if(order_status.equals("OA"))//11330
				order_status = "EXT_ACTIVE_OND" ;
			
			//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num,'', 'CA_SING_CONT') order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, case when order_line_status in ('CN','RJ','FC','DC') then '<font color=red>'||or_get_desc.or_order_status_code (order_line_status,?, '2' )||'</font>' else or_get_desc.or_order_status_code (order_line_status, ?, '2' )end order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (b.start_date_time, 'DD/MM/YYYY') start_date,to_char(start_date_time,'hh24:mi') start_time,case when b.order_category ='PH' then case when order_line_status not in('CN','DC') AND (TO_CHAR(end_date_time,'MM/DD/YYYY HH24:MI:SS')) >=  (TO_CHAR(SYSDATE,'MM/DD/YYYY HH24:MI:SS')) then 'ACTIVE'  else 'NON_ACTIVE' end end PH_STATUS, case when b.order_category = 'PH' then case when trunc(sysdate) BETWEEN  TRUNC (end_date_time-1) and TRUNC (end_date_time) then 'CURR_MED_YELLOW' when a.discharge_ind ='D' then 'CURR_MED_PINK' end end PH_BACK_CLR,b.durn_type,b.durn_value,b.freq_code, case when nvl(b.freq_code,'*')  not in (select freq_code from am_frequency where freq_nature='C') and (nvl(b.freq_code,'*')='*' or b.freq_code is not null and b.durn_type = 'H' AND to_number(TRIM (b.durn_value)) <= to_number('24') or b.durn_type='D' and to_number(NVL (TRIM (b.durn_value), 1)) <= to_number('1') or  b.durn_type = 'M' AND  TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440'))  then 'S' WHEN b.order_category = 'PH' AND NVL (b.freq_code, '*') IN (SELECT freq_code FROM am_frequency WHERE freq_nature = 'C') AND  a.IV_prep_yn  IN (1,2,5) AND (   (NVL (b.freq_code, '*') = '*') OR (    b.freq_code IS NOT NULL AND b.durn_type = 'H' AND TO_NUMBER (TRIM (b.durn_value)) <= TO_NUMBER ('24') )OR (    b.freq_code IS NOT NULL AND b.durn_type = 'D' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1') ) OR (    b.freq_code IS NOT NULL AND b.durn_type = 'M' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440') ) )THEN 'S' else 'C' end single_continuous,trunc(b.start_date_time) start_date_sort FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d   WHERE  a.ordeR_id =b.ordER_id and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND ((order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?))) or (order_line_status in ('DF','DP'))) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## &&FILTER2## ORDER BY start_date_sort DESC, start_time desc, DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', a.order_category,'T', a.order_type_code) DESC, NVL (a.order_set_id, a.order_id),a.order_id, order_line_num" ; //Modified --[IN032733][IN032734][IN032741][IN038455][IN040462.1] - Commented for - IN050648
			//sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num,'', 'CA_SING_CONT') order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, case when order_line_status in ('CN','RJ','FC','DC') then '<font color=red>'||or_get_desc.or_order_status_code (order_line_status,?, '2' )||'</font>' else or_get_desc.or_order_status_code (order_line_status, ?, '2' )end order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y'                       FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (b.start_date_time, 'DD/MM/YYYY') start_date,to_char(start_date_time,'hh24:mi') start_time,case when b.order_category ='PH' then case when order_line_status not in('CN','DC') AND (TO_CHAR(end_date_time,'MM/DD/YYYY HH24:MI:SS')) >=  (TO_CHAR(SYSDATE,'MM/DD/YYYY HH24:MI:SS')) then 'ACTIVE'  else 'NON_ACTIVE' end end PH_STATUS, case when b.order_category = 'PH' then case when trunc(sysdate) BETWEEN  TRUNC (end_date_time-1) and TRUNC (end_date_time) then 'CURR_MED_YELLOW' when a.discharge_ind ='D' then 'CURR_MED_PINK' end end PH_BACK_CLR,b.durn_type,b.durn_value,b.freq_code, case when nvl(b.freq_code,'*')  not in (select freq_code from am_frequency where freq_nature='C') and (nvl(b.freq_code,'*')='*' or b.freq_code is not null and b.durn_type = 'H' AND to_number(TRIM (b.durn_value)) <= to_number('24') or b.durn_type='D' and to_number(NVL (TRIM (b.durn_value), 1)) <= to_number('1') or  b.durn_type = 'M' AND  TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440'))  then 'S' WHEN b.order_category = 'PH' AND NVL (b.freq_code, '*') IN (SELECT freq_code FROM am_frequency WHERE freq_nature = 'C') AND  (a.IV_prep_yn  IN (1,2,5) or a.IV_prep_yn  is null) AND (   (NVL (b.freq_code, '*') = '*') OR (    b.freq_code IS NOT NULL AND b.durn_type = 'H' AND TO_NUMBER (TRIM (b.durn_value)) <= TO_NUMBER ('24') )OR (    b.freq_code IS NOT NULL AND b.durn_type = 'D' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1') ) OR (    b.freq_code IS NOT NULL AND b.durn_type = 'M' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440') ) OR 'N' = (select drug_yn from ph_drug where drug_code=b.order_catalog_code) )THEN 'S' else 'C' end single_continuous,trunc(b.start_date_time) start_date_sort FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d   WHERE  a.ordeR_id =b.ordER_id and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND ((order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?))) or (order_line_status in ('DF','DP'))) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## &&FILTER2## ORDER BY start_date_sort DESC, start_time desc, DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', a.order_category,'T', a.order_type_code) DESC, NVL (a.order_set_id, a.order_id),a.order_id, order_line_num" ; //Modified -- IN050648//IN64543
			if(order_status.equals("EXT_ACTIVE_OND")){ //11330 STARTS
				sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num,'', 'CA_SING_CONT') order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, case when order_line_status in ('CN','RJ','FC','DC') then '<font color=red>'||or_get_desc.or_order_status_code (order_line_status,?, '2' )||'</font>' else or_get_desc.or_order_status_code (order_line_status, ?, '2' )end order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y' FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (b.start_date_time, 'DD/MM/YYYY') start_date,to_char(start_date_time,'hh24:mi') start_time,case when b.order_category ='PH' then case when order_line_status not in('CN','DC') AND (TO_CHAR(end_date_time,'MM/DD/YYYY HH24:MI:SS')) >=  (TO_CHAR(SYSDATE,'MM/DD/YYYY HH24:MI:SS')) then 'ACTIVE'  else 'NON_ACTIVE' end end PH_STATUS, case when b.order_category = 'PH' then case when trunc(sysdate) BETWEEN  TRUNC (end_date_time-1) and TRUNC (end_date_time) then 'CURR_MED_YELLOW' when a.discharge_ind ='D' then 'CURR_MED_PINK' end end PH_BACK_CLR,b.durn_type,b.durn_value,b.freq_code, case when nvl(b.freq_code,'*')  not in (select freq_code from am_frequency where freq_nature='C') and (nvl(b.freq_code,'*')='*' or b.freq_code is not null and b.durn_type = 'H' AND to_number(TRIM (b.durn_value)) <= to_number('24') or b.durn_type='D' and to_number(NVL (TRIM (b.durn_value), 1)) <= to_number('1') or  b.durn_type = 'M' AND  TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440'))  then 'S' WHEN b.order_category = 'PH' AND NVL (b.freq_code, '*') IN (SELECT freq_code FROM am_frequency WHERE freq_nature = 'C') AND  (a.IV_prep_yn  IN (1,2,5) or a.IV_prep_yn  is null) AND (   (NVL (b.freq_code, '*') = '*') OR (    b.freq_code IS NOT NULL AND b.durn_type = 'H' AND TO_NUMBER (TRIM (b.durn_value)) <= TO_NUMBER ('24') )OR (    b.freq_code IS NOT NULL AND b.durn_type = 'D' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1') ) OR (    b.freq_code IS NOT NULL AND b.durn_type = 'M' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440') ) OR 'N' = (select drug_yn from ph_drug where drug_code=b.order_catalog_code) )THEN 'S' else 'C' end single_continuous,trunc(b.start_date_time) start_date_sort,nvl(b.INSTRUCTION_TYPE,'T') INSTRUCTION_TYPE FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d   WHERE  a.ordeR_id =b.ordER_id and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?)) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## &&FILTER2## ORDER BY start_date_sort DESC, start_time desc, DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', a.order_category,'T', a.order_type_code) DESC, NVL (a.order_set_id, a.order_id),a.order_id, order_line_num" ;
			}else{
				sql = "SELECT    a.order_category ,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') order_category_short_desc,   DECODE(nvl(b.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, a.order_id order_id,patient_id, encounter_id,episode_id,episode_visit_num, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num,'', 'CA_SING_CONT') order_detail, b.order_catalog_code , source_type,source_code,b.priority ,b.order_type_code  , OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type_short_desc,  a.ord_pract_id ord_pract_id, nvl(am_get_desc.am_practitioner (a.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (a.ord_pract_id,?,'1')) ordering_pract_name, order_line_status order_status, case when order_line_status in ('CN','RJ','FC','DC') then '<font color=red>'||or_get_desc.or_order_status_code (order_line_status,?, '2' )||'</font>' else or_get_desc.or_order_status_code (order_line_status, ?, '2' )end order_status_short_desc, b.ord_cosign_reqd_yn ord_cosign_reqd_yn, b.order_line_num order_line_num,b.item_narration  item_narration,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id ,TO_CHAR(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id ,TO_CHAR(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time, OR_GET_EXISTING_ORDER_OPERN (a.ordering_facility_id,a.order_id,a.order_category,a.order_type_code,nvl(b.cont_order_ind,'DO'),order_status,b.order_catalog_code,b.order_line_num,order_line_status,end_date_time,?,?,?,?) display_popupmenu,a.source_type source_type,a.source_code source_code,nvl(b.cont_order_ind,'DO') cont_order_ind,a.iv_prep_yn iv_prep_yn,to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time,(SELECT 'Y' FROM or_order_status_code WHERE order_status_code=order_line_status AND order_status_type IN         ('55','58','60','93','80','85','90','96','99')) copy_yn,b.last_action_reason_desc last_action_reason_desc, OR_ORDER_LINE_PH_COLOR(a.ordering_facility_id,a.order_id,b.order_catalog_code,b.order_line_num) ph_colors,b.can_line_reason can_line_reason,b.can_pract_id can_pract_id,to_char(b.can_date_time,'dd/mm/yyyy hh24:mi') can_date_time,b.disc_pract_id disc_pract_id,to_char(b.disc_date_time,'dd/mm/yyyy hh24:mi') disc_date_time,b.hold_pract_id hold_pract_id, to_char(b.hold_date_time,'dd/mm/yyyy hh24:mi') hold_date_time,b.last_action_reason_desc last_action_reason_desc,to_char(b.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time,b.appt_ref_num  appt_ref_num,b.order_catalog_nature order_catalog_nature,b.has_sec_order_yn sec_order_yn, b.pri_order_id pri_order_id,b.appt_locn  appt_locn,b.appt_resched_yn appt_resched_yn,b.appt_resched_reason appt_resched_reason,b.no_of_reschedules no_of_reschedules,b.appt_reqd_yn appt_reqd_yn,b.notify_yn notify_yn,b.last_action_type last_action_type,b.accession_num accession_num,b.catalog_synonym catalog_synonym,b.ord_consent_reqd_yn ord_consent_reqd_yn,b.order_set_id order_set_id,a.performing_facility_id performing_facility_id,b.ext_appl_accession_num ext_appl_accession_num,b.billing_package_ref billing_package_ref,TO_CHAR (b.start_date_time, 'DD/MM/YYYY') start_date,to_char(start_date_time,'hh24:mi') start_time,case when b.order_category ='PH' then case when order_line_status not in('CN','DC') AND (TO_CHAR(end_date_time,'MM/DD/YYYY HH24:MI:SS')) >=  (TO_CHAR(SYSDATE,'MM/DD/YYYY HH24:MI:SS')) then 'ACTIVE'  else 'NON_ACTIVE' end end PH_STATUS, case when b.order_category = 'PH' then case when trunc(sysdate) BETWEEN  TRUNC (end_date_time-1) and TRUNC (end_date_time) then 'CURR_MED_YELLOW' when a.discharge_ind ='D' then 'CURR_MED_PINK' end end PH_BACK_CLR,b.durn_type,b.durn_value,b.freq_code, case when nvl(b.freq_code,'*')  not in (select freq_code from am_frequency where freq_nature='C') and (nvl(b.freq_code,'*')='*' or b.freq_code is not null and b.durn_type = 'H' AND to_number(TRIM (b.durn_value)) <= to_number('24') or b.durn_type='D' and to_number(NVL (TRIM (b.durn_value), 1)) <= to_number('1') or  b.durn_type = 'M' AND  TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440'))  then 'S' WHEN b.order_category = 'PH' AND NVL (b.freq_code, '*') IN (SELECT freq_code FROM am_frequency WHERE freq_nature = 'C') AND  (a.IV_prep_yn  IN (1,2,5) or a.IV_prep_yn  is null) AND (   (NVL (b.freq_code, '*') = '*') OR (    b.freq_code IS NOT NULL AND b.durn_type = 'H' AND TO_NUMBER (TRIM (b.durn_value)) <= TO_NUMBER ('24') )OR (    b.freq_code IS NOT NULL AND b.durn_type = 'D' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1') ) OR (    b.freq_code IS NOT NULL AND b.durn_type = 'M' AND TO_NUMBER (NVL (TRIM (b.durn_value), 1)) <= TO_NUMBER ('1440') ) OR 'N' = (select drug_yn from ph_drug where drug_code=b.order_catalog_code) )THEN 'S' else 'C' end single_continuous,trunc(b.start_date_time) start_date_sort,nvl(b.INSTRUCTION_TYPE,'T') INSTRUCTION_TYPE FROM or_order a, or_order_line b,am_duration_type c,or_catalog_synonym_lang_vw d   WHERE  a.ordeR_id =b.ordER_id and b.order_catalog_code=d.order_catalog_code and b.durn_type = c.durn_type(+)  and d.language_id=? AND catalog_synonym_type=or_get_synonym_type(?,b.order_catalog_code) and  nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR')  and substr(a.order_id,1,2) !='CS' and patient_id = (?) and nvl(encounter_id,0) = NVL((?),nvl(encounter_id,0)) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') AND ((order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF = ?))) or (order_line_status in ('DF','DP'))) AND (('EXT_FUTURE_ORD' = ? and b.future_order_yn='Y')  or 'EXT_FUTURE_ORD' !=? ) AND a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) AND b.order_type_code = nvl((?),b.order_type_code) and b.priority=nvl((?),b.priority) &&CHANGE_CATALOG_SYNONYM_COLUMN##  /*AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.999*/  AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  &&FILTER## &&FILTER1## &&FILTER2## ORDER BY start_date_sort DESC, start_time desc, DECODE ((?),'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),'O', a.order_category,'T', a.order_type_code) DESC, NVL (a.order_set_id, a.order_id),a.order_id, order_line_num" ; //Modified -- IN050648//IN64543
			}//11330 ENDS
			if(!catalog.equals(""))
					{
						//sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##"," AND exists (select 1 from or_order_line ia, or_catalog_synonym_lang_vw ib where ia.order_id=a.order_id and ib.order_catalog_code=ia.order_catalog_code and ib.language_id=? and upper(ib.CATALOG_SYNONYM) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)))");//IN072473
						sql=sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##", "  AND UPPER (or_get_order_catalog (a.order_id, a.order_type_code,?, ?,b.order_line_num)) like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))");//IN072473
					}
					else
					{
						sql = sql.replace("&&CHANGE_CATALOG_SYNONYM_COLUMN##"," ");
					}

					if(order_status.equalsIgnoreCase("EXT_ACTIVE")||order_status.equalsIgnoreCase("EXT_ACTIVE_OND"))
					{
						if(elapsed_orders.equalsIgnoreCase("Y"))
						{
							sql=sql.replace("&&FILTER##"," ");
						}
						else
						{
							sql=sql.replace("&&FILTER##"," AND (b.end_date_time >SYSDATE OR b.end_date_time IS NULL)");
						}
						sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
					}
					else
					{
						if((order_status.equalsIgnoreCase("EXT_ALL"))||(order_status.equalsIgnoreCase("EXT_DISC_CAN")))
						{
							if(sys_cancelled_orders.equalsIgnoreCase("Y"))
							{
								sql =  sql.replace("&&FILTER1##"," ");
							}
							else
							{
								sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
							}
						}
						else
						{
							sql =  sql.replace("&&FILTER1##"," and b.Cancelled_by_sys_yn!='Y' ");
						}
						sql=sql.replace("&&FILTER##"," ");
					}
					if(category_type.equalsIgnoreCase("C"))
					{
						sql =  sql.replace("&&FILTER2##"," AND a.order_category IN (SELECT order_category FROM or_order_category a WHERE NOT EXISTS (SELECT 'Y' FROM or_custom_category WHERE appl_user_id = ?     AND order_category = a.order_category) and order_category not in('CN','CS') UNION SELECT order_category  FROM or_custom_category WHERE custom_category_yn = 'Y' AND appl_user_id = ?  and order_category not in('CN','CS')) ");
					}
					else if(category_type.equalsIgnoreCase("I"))
					{  
                      
					  if(isDfltOrderSts && call_from.equals("LOAD") && called_frm1=="" && (order_category=="" || order_category.equals("")))
						{    
                             sql =  sql.replace("&&FILTER2##"," and a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (DECODE ((select order_category from or_one_day_cont_order where practi_type=( select pract_type from sm_appl_user_vw where appl_user_id=?) and facility_id=?),'ALL', ic.order_category,(select order_category from or_one_day_cont_order where practi_type=( select pract_type from sm_appl_user_vw where appl_user_id=?) and facility_id=?),(select order_category from or_one_day_cont_order where practi_type=( select pract_type from sm_appl_user_vw where appl_user_id=?) and facility_id=?)), ic.order_category)) ");
						}else{

							sql =  sql.replace("&&FILTER2##"," and a.order_category in (select order_category from or_order_category ic where  ic.order_category =NVL (?, ic.order_category)) ");
					}
						
					}

					/* Thai date validations start 14/02/2007*/

					if(date_from == null || date_from.equals("null") || date_from.equals("&nbsp;") || date_from.equals(" ")) 
						date_from = "";

					if(date_to == null || date_to.equals("null") || date_to.equals("&nbsp;") || date_to.equals(" ")) 
						date_to = "";

					if (!language_id.equals("en"))
					{
						date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
						date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
					}
				
				/* Thai date validations end 14/02/2007*/	
				pstmt = connection.prepareStatement(sql);
				
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, encounter_id);
				pstmt.setString( ++cnt, ca_practitioner_id);
				pstmt.setString( ++cnt, responsibility_id);								
				pstmt.setString( ++cnt, pract_reln_id);
				pstmt.setString( ++cnt, language_id);
				pstmt.setString( ++cnt, practitioner_type);
				pstmt.setString( ++cnt, patient_id.trim() ) ;
				pstmt.setString( ++cnt, encntr_id ) ;				
				pstmt.setString( ++cnt, date_from.trim() ) ;				
				pstmt.setString( ++cnt, date_to.trim() ) ;				
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_status.trim() ) ;
				pstmt.setString( ++cnt, order_category.trim() ) ;
				pstmt.setString( ++cnt, order_type_code.trim() ) ;
				pstmt.setString( ++cnt, priority.trim() ) ;
				
				/*Added by Uma on 4/28/2010 for IN020757*/
				if(!catalog.equals(""))
				{
					pstmt.setString( ++cnt, language_id);
					pstmt.setString( ++cnt, practitioner_type);//IN072473
					pstmt.setString( ++cnt, search_criteria.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
					pstmt.setString( ++cnt, catalog.trim() ) ;
					
				}
				
				pstmt.setString( ++cnt, activity_type.trim() ) ;
				if(category_type.equals("C"))
				{
					pstmt.setString(++cnt,appl_user_id);
					pstmt.setString(++cnt,appl_user_id);
					
				}
				else if(category_type.equals("I"))
				{   
					if(isDfltOrderSts && call_from.equals("LOAD") && called_frm1=="" && (order_category=="" || order_category.equals("")))
					{
                       pstmt.setString(++cnt,appl_user_id);
                       pstmt.setString(++cnt,facility_id);
                       pstmt.setString(++cnt,appl_user_id);
                       pstmt.setString(++cnt,facility_id);
                       pstmt.setString(++cnt,appl_user_id);
                       pstmt.setString(++cnt,facility_id);
					}else{

					pstmt.setString(++cnt,order_category);
					}
										
				}
				//IN27707 Ends	
				pstmt.setString( ++cnt, order_by.trim() ) ;
				
		
			resultSet = pstmt.executeQuery() ;			
			//int rowcount = 0; //Commented for checkstyle
			
			if(resultSet!=null) 
			{
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);

				while ( start <= end && resultSet!=null && resultSet.next()) 
				{
					//String[] record = new String[79];//IN64543
					String[] record = new String[80];//IN64543
					
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "order_category_short_desc" )  ;
					record[2] = resultSet.getString( "priority_desc" )  ;
					record[3] = resultSet.getString( "order_detail" )  ;
					record[4] = resultSet.getString( "order_type_code" )  ;
					record[5] = resultSet.getString( "ordering_pract_name" )  ;
					record[6] = resultSet.getString( "order_status_short_desc" )  ;
					record[7] = resultSet.getString( "order_date_time" )  ;
					record[8] = resultSet.getString( "order_type_short_desc" )  ;
					record[9] = resultSet.getString( "order_id" )  ;
					record[10] = resultSet.getString( "priority" )  ;

					record[11] = resultSet.getString( "order_line_num" )  ;
					record[12] = resultSet.getString( "order_catalog_code" )  ;
					record[13] = resultSet.getString( "item_narration" )  ;
					record[14] = resultSet.getString( "order_status" )  ;
					record[15] = resultSet.getString( "display_popupmenu" )  ;
					record[16] = "";	//resultSet.getString( "discontinue_yn" )  ;
					record[17] = "";	//resultSet.getString( "result_hyperlink_yn" )  ;
					record[18] = resultSet.getString( "source_type" )  ;
					record[19] = resultSet.getString( "source_code" )  ;
					record[20] = resultSet.getString( "patient_class" )  ;
					record[21] = resultSet.getString( "cont_order_ind" )  ;
					record[22] = "";			 //resultSet.getString( "hold_yn" )  ;
					record[23] = "";			//resultSet.getString( "resume_yn" )  ;
					record[24] = resultSet.getString("can_line_reason");
					record[25] = resultSet.getString("iv_prep_yn");
					record[26] = "";			//resultSet.getString( "renew_yn" )  ;
					record[27] = resultSet.getString( "start_date_time" )  ;
					record[28] = resultSet.getString( "end_date_time" )  ;
					record[29] = "";			//resultSet.getString( "amend_yn" )  ;
					record[30] = checkForNull(resultSet.getString( "copy_yn" ),"")  ;
					record[31] = resultSet.getString( "can_date_time" )  ;
					record[32] = resultSet.getString( "can_pract_id" )  ;
					record[33] = resultSet.getString( "disc_date_time" )  ;
					record[34] = resultSet.getString( "disc_pract_id" )  ;
					record[35] = resultSet.getString( "last_action_reason_desc" )  ;
					record[36] = resultSet.getString( "ph_colors" )  ;
					record[37] = resultSet.getString( "can_line_reason" )  ;
					record[38] = resultSet.getString( "can_pract_id" )  ;
					record[39] = resultSet.getString( "can_date_time" )  ;
					record[40] = resultSet.getString( "disc_pract_id" )  ;
					record[41] = resultSet.getString( "disc_date_time" )  ;
					record[42] = resultSet.getString( "hold_pract_id" )  ;	
					record[43] = resultSet.getString( "hold_date_time" )  ;
					record[44] = resultSet.getString( "last_action_reason_desc" )  ;
					record[45] = resultSet.getString( "appt_date_time" )  ;	
					record[46] = resultSet.getString( "appt_ref_num" )  ;
					record[47] = resultSet.getString( "order_catalog_nature" )  ;
					record[48] = resultSet.getString( "sec_order_yn" )  ;
					record[49] = resultSet.getString( "pri_order_id" )  ;
					record[50] = resultSet.getString( "appt_locn" )  ;
					record[51] = resultSet.getString( "appt_resched_yn" )  ;
					record[52] = resultSet.getString( "appt_resched_reason" )  ;
					record[53] = resultSet.getString( "no_of_reschedules" )  ;
					record[54] = resultSet.getString( "appt_reqd_yn" )  ;
					record[55] = resultSet.getString( "notify_yn" )  ;
					record[56] = resultSet.getString( "last_action_type" )  ;
					record[57] = resultSet.getString( "accession_num" )  ;
					record[59] = resultSet.getString( "catalog_synonym" )  ;
					record[60] = resultSet.getString( "ord_consent_reqd_yn" )  ;
					record[61] = resultSet.getString( "order_set_id" )  ;
					record[62] = resultSet.getString( "performing_facility_id" )  ;
					record[63] = ""; //Link to Current Encounter
					record[64] = resultSet.getString( "ext_appl_accession_num"); //Ext Appl Accession No
					record[65] = ""; //View Replaced Order
					record[66] = ""; //View Cancelled Order
					record[67] =  resultSet.getString( "billing_package_ref" )  ;//Added by Uma on 4/15/2010 for package billing
					record[68] =  "";//Replace for package billing
						
					record[69] =  resultSet.getString( "start_date" )  ;
					record[70] =  resultSet.getString( "start_time" );
					record[71] =  resultSet.getString( "PH_STATUS" );
					record[72] =  resultSet.getString( "PH_BACK_CLR" )  ;
					record[73] =  resultSet.getString( "durn_type" );
					record[74] =  resultSet.getString( "durn_value" );
					record[75] =  resultSet.getString( "freq_code" );
					record[76] =  resultSet.getString( "single_continuous" );
					record[77] =  resultSet.getString( "start_date_sort" )  ;
					record[79] =  resultSet.getString( "INSTRUCTION_TYPE" );//IN64543
					
					OrderCat.add(record) ;
					start++;
				}
				if (resultSet.next())
				{	
					
					String[] templist = (String[])OrderCat.get(0);
					
						templist[78] = ""+(end+30);
					
					OrderCat.set(0,templist);
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
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}
//IN030416 Ends
	//--[IN033488]
public ArrayList getRltNoteSts(String order_id,String langId)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		ArrayList NoteStatus = new ArrayList() ;
		try
		{
			connection = getConnection() ;
			sql = "select am_get_desc.am_practitioner (action_by_id,?, '1') action_by_id,ACTION_DATE_TIME,ACTION_TYPE from (SELECT action_by_id,ACCESSION_NUM,ACTION_DATE_TIME,ACTION_TYPE FROM ca_encntr_note_audit_log a,or_result_detail b WHERE a.accession_num = b.linked_note_accession_num AND b.order_id = ? order by action_date_time desc) where rownum= 1";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString( 1, langId.trim() ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;		
			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[3];
				record[0] = resultSet.getString( "action_by_id" )  ;
				record[1] = resultSet.getString( "ACTION_DATE_TIME" )  ;
				record[2] = resultSet.getString( "ACTION_TYPE" )  ;

				NoteStatus.add(record) ;
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
		return NoteStatus;
	}
//--[IN033488]
//IN030472 Start. 
public String getOrderCatalogName(String orderId,String orderLineNum) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String cataLogName			="";

		try 
		{
			connection			= ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement("SELECT B.SHORT_DESC FROM OR_ORDER_LINE A,OR_ORDER_CATALOG B WHERE A.ORDER_CATALOG_CODE=B.ORDER_CATALOG_CODE AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=?") ;
			pstmt.setString( 1, orderId);
			pstmt.setString( 2, orderLineNum);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				cataLogName = resultSet.getString( "SHORT_DESC" );
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
			ConnectionManager.returnConnection(connection);
		}

		return cataLogName;	
	}
//IN030472 End.		
//IN029949 Start 
public ArrayList getMedicationHoldOrders(String ord_facility, String practitioner_id, String ord_cat, String patientId, String period_from, String period_to, int start, int end, String source_type, String source_code, String practitioner_type) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String sql="";
		ArrayList OrderCat = new ArrayList() ;
		//IN037927 - Start
		int indexid =1;
		String patient_class = ""; 
		if(source_type!=null && source_type.equalsIgnoreCase("C"))
		{
			patient_class	= "OP";
		}
		else if(source_type!=null && source_type.equalsIgnoreCase("W"))
		{
		   patient_class	= "IP";
		}
		else if(source_type!=null && source_type.equalsIgnoreCase("R"))
		{
		   patient_class	= "XT";
		}
		//IN037927 - End
		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en"); //IN037898
        period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");//IN037898
		try 
		{
			connection			= ConnectionManager.getConnection() ;
			//IN061958 Start.
			//sql = "SELECT  nvl(LAST_ACTION_REASON_DESC,CAN_LINE_REASON) can_reason, b.priority priority, or_get_order_catalog (a.order_id, a.order_type_code, ?,?,b.order_line_num) order_catalog, DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name,sex, date_of_birth,get_age (date_of_birth) age, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, a.encounter_id encounter_id ,a.source_type source_type, a.patient_id patient_id, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY hh24:mi') ORD_DATE_TIME, a.order_id order_id, a.source_code source_code, a.patient_class patient_class, b.order_catalog_code, a.order_type_code ,b.order_line_num, a.cont_order_ind, b.order_line_status FROM or_order a, or_order_line b, mp_patient c WHERE a.patient_id = c.patient_id and a.order_category = 'PH' AND A.ORDER_ID = b.order_id AND a.ordering_facility_id =? AND a.ORD_DATE_TIME BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 AND a.order_category != 'CS'AND b.order_line_status IN ( SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ( SELECT order_status_type FROM or_status_applicability WHERE oper_or_group_ref = 'EXT_HOLD')) AND a.ORD_PRACT_ID = ?  ##FILTER4$$ #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1#   order by b.ord_date_time";//IN037898 //IN037927 Modified
			sql = "SELECT  nvl(LAST_ACTION_REASON_DESC,CAN_LINE_REASON) can_reason, b.priority priority, or_get_order_catalog (a.order_id, a.order_type_code, ?,?,b.order_line_num) order_catalog, DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name,sex, date_of_birth,get_age (date_of_birth,a.ord_date_time) age, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, a.encounter_id encounter_id ,a.source_type source_type, a.patient_id patient_id, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY hh24:mi') ORD_DATE_TIME, a.order_id order_id, a.source_code source_code, a.patient_class patient_class, b.order_catalog_code, a.order_type_code ,b.order_line_num, a.cont_order_ind, b.order_line_status FROM or_order a, or_order_line b, mp_patient c WHERE a.patient_id = c.patient_id and a.order_category = 'PH' AND A.ORDER_ID = b.order_id AND a.ordering_facility_id =? AND a.ORD_DATE_TIME BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 AND a.order_category != 'CS'AND b.order_line_status IN ( SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ( SELECT order_status_type FROM or_status_applicability WHERE oper_or_group_ref = 'EXT_HOLD')) AND a.ORD_PRACT_ID = ?  ##FILTER4$$ #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1#   order by b.ord_date_time";//IN037898 //IN037927 Modified
			//IN061958 End.
			if(patientId==null || patientId.equals(""))
			{
				sql=sql.replace("##FILTER4$$"," ");
			}
			else 
			{
				sql=sql.replace("##FILTER4$$"," and a.patient_id = ?  ");
			}
			//IN037927 - Start
			if (!source_type.equals("")&& source_type!=null)
			{
				sql=sql.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',a.source_type) ");
			}
			else
			{
				sql=sql.replace("#SOURCE_TYPE_COND1#"    ,"");
			}
			if (!source_code.equals("") && source_code!=null)
			{
				sql=sql.replace("#SOURCE_CODE_COND1#"," AND a.SOURCE_code=?  ");	
				sql=sql.replace("#SOURCE_CODE_COND2#"," AND locn_code=? ");	
			}
			else
			{
				sql=sql.replace("#SOURCE_CODE_COND1#"    ,"");
				sql=sql.replace("#SOURCE_CODE_COND2#"    ,"");
			}
			//IN037927 - End
			pstmt = connection.prepareStatement(sql) ;
			
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, practitioner_type); //IN037898
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, ord_facility);
			pstmt.setString( indexid++, period_from);
			pstmt.setString( indexid++, period_to);
			pstmt.setString( indexid++, practitioner_id);

			if(patientId!=null && !patientId.equals(""))
			{
				pstmt.setString( indexid++, patientId);
			}
			//IN037927 - Start
			if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, patient_class) ;
				pstmt.setString( indexid++, source_type) ;
			}
			if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code) ;
			}
			//IN037927 - End
			resultSet = pstmt.executeQuery() ;
				
				if(start > 0)
				{
					for(int i=0;(i<start-1 && resultSet.next());i++);
				}
				while ( start <= end && resultSet!=null && resultSet.next()) 
				{
  				 		String[] record = new String[21];
						record[0] = checkForNull(resultSet.getString( "can_reason" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "priority" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "patient_name" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "sex" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "age" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "location_description" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "ORD_DATE_TIME" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[17] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
						record[19] = checkForNull(resultSet.getString( "order_line_status" ),"")  ;
				
						OrderCat.add(record) ;
						start++;
			}
			if (resultSet.next())
			{
				String[] templist = (String[])OrderCat.get(0);
				templist[20] = ""+(end+7);
				OrderCat.set(0,templist);
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
			ConnectionManager.returnConnection(connection);
		}

		return OrderCat;	
	}
//IN029949 End	
// IN035929 - START
	public String getBillingInterfaceShowYn(String facilityId) throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String show_bill_info_yn= "N";
		 String sqlQry = "Select disp_bl_dtl_yn from OR_PARAM_BY_FACILITY where operating_facility_id = ? ";
		 try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( sqlQry);
				pstmt.setString(1, facilityId); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					if(resultSet.next())
					{
						show_bill_info_yn = checkForNull(resultSet.getString( "disp_bl_dtl_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return show_bill_info_yn;
	}
//IN035929 End
	//IN043143 Starts
	public String getOrderLineStatus(String orderID,String orderLineNum) throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String order_line_status= "";
		 String sqlQry = "Select order_line_status from OR_ORDER_LINE where ORDER_ID = ? AND ORDER_LINE_NUM=?";
		 try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( sqlQry);
				pstmt.setString(1, orderID); 
				pstmt.setString(2, orderLineNum); 
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    
				{
					if(resultSet.next())
					{
						order_line_status = checkForNull(resultSet.getString( "order_line_status" ),"")  ;
					}
				}	
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return order_line_status;
	}
	//IN043143 Ends
	// IN049419 Start.
	public String getOrderFormatAuditTrailDtls() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String auditTrailYN = "N" ;
		String amndrsn_reqYN = "N" ;
		String amndrsn_mandatYN = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_FORMAT_AUDIT_TRAIL") ) ;				

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				auditTrailYN = (String)resultSet.getString("ORD_AUDIT_REQ_YN");
				amndrsn_reqYN = (String)resultSet.getString("ORD_AMNDRSN_REQ_YN");
				amndrsn_mandatYN = (String)resultSet.getString("ORD_AMNDRSN_MANDAT_YN");
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return auditTrailYN+"|"+amndrsn_reqYN+"|"+amndrsn_mandatYN;
	}
	
	public ArrayList getOrderAmendReasons(String order_cat) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList amend_reason = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_AMEND_REASONS") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, "AM");			
			pstmt.setString(4, (String)order_cat.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record[] = new String[3];
				record[0] = resultSet.getString("ACTION_REASON_CODE")  ;
				record[1] = resultSet.getString("ACTION_DESCRIPTION")  ;
				record[2] = resultSet.getString("ACTION_REASON_DESC")  ;

				amend_reason.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return amend_reason;
	}
	// IN049419 End.
	// IN052649 - Start
	public ArrayList getOrderingSpecialityType(String facility_id,String practitioner_id,String encounter_id) throws Exception {
		ArrayList orderingSpecialityDtl = new ArrayList();
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String orderingSpecialityType = "N" ;
		String primarySpecialityCode = "";
		String PrimarySpecialityDesc = "";
		String currentEncSpecialityCode = "";
		String currentEncSpecialityDesc = "";
		
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PARAM_FOR_FACILITY_SPLTY_TYPE") ) ;				
				pstmt.setString(1, facility_id);
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					orderingSpecialityType = (String)resultSet.getString("ORD_SPLTY_TYPE_IND");				
				}
				if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
				
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_PRIMARY_SPLTY_FOR_PRACTITIONER") ) ;				
				pstmt.setString(1, language_id);
				pstmt.setString(2, practitioner_id);
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					primarySpecialityCode = (String)resultSet.getString("PRIMARY_SPECIALITY_CODE");	
					PrimarySpecialityDesc = (String)resultSet.getString("SHORT_DESC");
				}
				if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
				
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_SPLTY_FOR_CURRENT_ENCOUNTER") ) ;				
				pstmt.setString(1, language_id);
				pstmt.setString(2, encounter_id);
				pstmt.setString(3, facility_id);
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					currentEncSpecialityCode = (String)resultSet.getString("SPECIALTY_CODE");
					currentEncSpecialityDesc = (String)resultSet.getString("SHORT_DESC");
				}
				if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
		orderingSpecialityDtl.add(orderingSpecialityType);
		orderingSpecialityDtl.add(primarySpecialityCode);
		orderingSpecialityDtl.add(PrimarySpecialityDesc);
		orderingSpecialityDtl.add(currentEncSpecialityCode);
		orderingSpecialityDtl.add(currentEncSpecialityDesc);
		return orderingSpecialityDtl;
	}
	
	public String getCopyPrevOrderFromDate(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String copy_prev_order_form_date = "0" ;		
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_COPY_PREV_ORD_FROM_DATE") ) ;				
				pstmt.setString(1, facility_id);
				resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
					{
				if ( !"0".equals((String)resultSet.getString("COPY_PREV_ORD_DURATION"))) {
					copy_prev_order_form_date = (String)resultSet.getString("COPY_PREV_ORD_DATE");				
				}
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return copy_prev_order_form_date;
	}
	//IN052649 - End
	//HSA-CRF-0257.1 - IN055910 - Start 
	public String getLabOrderStatusBySpecNo(String specimen_no, String view_by, String catalog_code, String patient_id) throws Exception {
		String order_status = "";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		// modified below codes for HSA-CRF-0257.1-02 - IN058125
		if(catalog_code == null) catalog_code = "";
		String selectQuery = "";
		String test_code = "";
		String tstCodQuery = "SELECT TEST_CODE FROM RL_TEST_CODE WHERE ORDER_CATALOG_CODE = ?";
		if(view_by.equalsIgnoreCase("L")){
			//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and CONTR_SYS_EVENT_CODE = ? "; //AAKH-SCF-0252
			//selectQuery = "SELECT  STATUS FROM CR_ENCOUNTER_DETAIL where HIST_REC_TYPE='LBIN' AND  ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE and CONTR_SYS_EVENT_CODE = ? AND PATIENT_ID =?"; //AAKH-SCF-0252 // PATIENT_ID, HIST_REC_TYPE added for PERF ISSUE - Karthi//Commented for IN068133
			selectQuery = "SELECT  STATUS FROM CR_ENCOUNTER_DETAIL where HIST_REC_TYPE='LBIN' AND   SUBSTR(ACCESSION_NUM,INSTR (ACCESSION_NUM, '#')+1) = ?||'@'||CONTR_SYS_EVENT_CODE and CONTR_SYS_EVENT_CODE = ? AND PATIENT_ID =?"; //IN068133
		} else {
			//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and STATUS = 'C'"; //AAKH-SCF-0252
			//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND   ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE AND PATIENT_ID =? and STATUS = 'C' "; //AAKH-SCF-0252 // PATIENT_ID, HIST_REC_TYPE added for PERF ISSUE - Karthi//Commented for IN068133
			selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND   SUBSTR(ACCESSION_NUM,INSTR (ACCESSION_NUM, '#')+1) = ?||'@'||CONTR_SYS_EVENT_CODE AND PATIENT_ID =? and STATUS = 'C' "; //Modified for IN068133
		}
		//selectQuery = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) AND ROWNUM=1";
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(tstCodQuery);
			pStatement.setString(1, catalog_code);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()){
				test_code = resultSet.getString("TEST_CODE");
			}
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			
			pStatement = connection.prepareStatement(selectQuery);
			pStatement.setString(1, specimen_no);
			
			if(view_by.equalsIgnoreCase("L")) {
				pStatement.setString(2, test_code);
				pStatement.setString(3, patient_id); // PATIENT_ID added for PERF ISSUE - Karthi
			} else{
				pStatement.setString(2, patient_id); // PATIENT_ID added for PERF ISSUE - Karthi
			}
			
			resultSet = pStatement.executeQuery();
			if(resultSet.next()){
				order_status = resultSet.getString( "STATUS" )  ;
			}
		}
		catch(Exception ex){
			System.err.println("5010. ExistingOrder.java ===> " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return order_status;
	}
	//HSA-CRF-0257.1 - IN055910 - End
	//HSA-CRF-0257.1-02 IN058125 - Start 
	public String getResultStatFromStatusAppl(String view_by, String order_id, String order_line, String patient_id) throws Exception {
		String isModified = "";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		String selectQuery = "";
		int order_line_int = 0;
		if(view_by.equalsIgnoreCase("L")) {
			selectQuery = "Select 'Y' isModified from or_order_line where order_id = ? and order_line_status IN ( SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type) and ORDER_LINE_NUM =?";
		} else {
			selectQuery = "Select 'Y' isModified from or_order where order_id = ? and patient_id = ? and order_status IN ( SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type)"; //added patient_id for PERF ISSUE - Karthi
		}
		try {
			if(order_line != null && order_line != "") {
				order_line_int = Integer.parseInt(order_line);
			}
			connection = getConnection();
			pStatement = connection.prepareStatement(selectQuery);
			pStatement.setString(1, order_id);
			if(view_by.equalsIgnoreCase("L")) {
				pStatement.setInt(2, order_line_int);
			} else { // added for PERF ISSUE - Start - Karthi
				pStatement.setString(2, patient_id);  
			} // added for PERF ISSUE - End - Karthi
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				isModified = resultSet.getString( "isModified" )  ;
			}
		}
		catch(Exception ex){
			System.err.println("5051. PatOrderByPrivRelQueryBean.java ===> " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return isModified;
	}
	
	public ArrayList getIntervalTestSpecNos(String orderId, String patient_id) throws Exception {
		ArrayList specList = new ArrayList();
		String selectQuery = "SELECT distinct(SPECIMEN_NO) FROM RL_REQUEST_HEADER WHERE ORDER_ID = ? AND PATIENT_ID = ?"; // PATIENT_ID added for PERF ISSUE - Karthi
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(selectQuery);
			pStatement.setString(1, orderId);
			pStatement.setString(2, patient_id); // added for PERF ISSUE - Karthi
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				specList.add(resultSet.getString("SPECIMEN_NO"));
			}
		} catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		} finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return specList;
	}
	public String getLBModStatForIntTest(ArrayList specList, String patient_id) throws Exception {
		String resultModStatus = "";
		//String selectSql = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE ? = SUBSTR (ACCESSION_NUM,5,10) and STATUS = 'C'"; //AAKH-SCF-0252
		//String selectSql = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND  ACCESSION_NUM = 'F'||FACILITY_ID||'#'||?||'@'||CONTR_SYS_EVENT_CODE and PATIENT_ID = ? and STATUS = 'C'"; //AAKH-SCF-0252 // PATIENT_ID, HIST_REC_TYPE added for PERF ISSUE - Karthi//Commented for IN068133
		String selectSql = "SELECT STATUS FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE='LBIN' AND  SUBSTR(ACCESSION_NUM,INSTR (ACCESSION_NUM, '#')+1) = ?||'@'||CONTR_SYS_EVENT_CODE and PATIENT_ID = ? and STATUS = 'C'"; //Modified for IN068133
		String accession_no = "";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			if(specList != null){
				connection = getConnection();
				for(int i=0;i<specList.size();i++){
					accession_no = (String)specList.get(i);
					pStatement = connection.prepareStatement(selectSql);
					pStatement.setString(1, accession_no);
					pStatement.setString(2, patient_id); // PATIENT_ID added for PERF ISSUE - Karthi
					resultSet = pStatement.executeQuery();
					while(resultSet.next()){
						resultModStatus = resultSet.getString( "STATUS" )  ;
					}
					if(resultModStatus.equalsIgnoreCase("C")){
						break;
					}
					if(resultSet != null) resultSet.close();
					if(pStatement != null) pStatement.close();
				}
			}
		} catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		} 
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return resultModStatus;
	}
	//HSA-CRF-0257.1-02 IN058125 - End
	// added for ML-MMOH-SCF-0502 [IN061722] -- Start
	public String getLabInstalledYN() throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String isLabInstalledYN = "N";
		 String sqlQry = "SELECT 'Y' lab_installed FROM ca_ext_image_appl  WHERE ext_image_appl_id = 'IBARL'";
		 try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( sqlQry);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					if(resultSet.next())
					{
						isLabInstalledYN = checkForNull(resultSet.getString( "lab_installed" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return isLabInstalledYN;
	}
	//added for ML-MMOH-SCF-0502 [IN061722] - End
	//IN064614 start
	public String onlinePrintingForBarcode(Hashtable print_barcode_values,HttpServletRequest request, HttpServletResponse response)
	{
		String report_id = "ORPOBCLA",barcode_to_be_executed="";
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		boolean result = false;
		
		String facility_id, patient_id,order_id,module_id,language_id, barcode_reqd_yn,order_catalog_code;
    	String order_line_num,location_type ="",location_code="";
    	language_id = properties.getProperty("LOCALE");
    	
    	String str_barcode_count_records =  checkForNull(print_barcode_values.get("barcode_count_records").toString(),"0");
    	
    	int barcode_count_records = Integer.parseInt(str_barcode_count_records);
 
		
    	String ReportOutput = "";
    	try
	    	{
		        	for(int barcode_count=0;barcode_count<barcode_count_records;barcode_count++){
		        						
						barcode_reqd_yn = (String) print_barcode_values.get("barcode_reqd_yn"+barcode_count);
		        		order_id = (String) print_barcode_values.get("order_id_"+barcode_count);
		        		order_line_num = print_barcode_values.get("order_line_num"+barcode_count).toString();
		        		facility_id = (String) print_barcode_values.get("facility_id"+barcode_count);
		        		patient_id = (String) print_barcode_values.get("patient_id"+barcode_count);
		        		order_catalog_code = (String) print_barcode_values.get("order_catalog_code"+barcode_count);
		        		
		        		module_id = (String) print_barcode_values.get("module_id"+barcode_count);
		        		location_type = checkForNull((String) print_barcode_values.get("location_type"+barcode_count),"");
		        		location_code = checkForNull((String) print_barcode_values.get("location_code"+barcode_count),"");
		        		
		        		
		        		
		        		if("Y".equalsIgnoreCase(barcode_reqd_yn))
		        		{
				
							try
							{
								
								ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
								report1.addParameter("p_facility_id",facility_id ) ;
								report1.addParameter("p_order_id",order_id) ;
								report1.addParameter("p_order_line_num",order_line_num) ;
								report1.addParameter("p_user_name","");
								report1.addParameter("p_report_id",report_id);
								report1.addParameter("p_module_id",module_id);
								report1.addParameter("p_patient_id",patient_id);
								report1.addParameter("p_language_id",language_id);
								result = onlineReports.add( report1) ;
								
								
								ReportOutput = "1";
							}
							catch(Exception e)
							{
								e.printStackTrace();
								ReportOutput = "0";
							}
					
		        		}
		        		
		        	}
		        	
		        		if(result && "1".equals(ReportOutput))
							barcode_to_be_executed = onlineReports.execute( request, response );
	        		
	        	
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	        }
    	return ReportOutput;
	}
	//IN064614 ends
	// added for IN065091 Start
	public String getBTInstalledYN() throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String isBTInstalledYN = "N";
		 String sqlQry = "SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'BT'";
		 try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( sqlQry);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					if(resultSet.next())
					{
						isBTInstalledYN = checkForNull(resultSet.getString( "INSTALL_YN" ),"N")  ;
					}
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return isBTInstalledYN;
	}
	//added for IN065091 - End
	//IN067817 starts
	public String notificationDetails(String order_id,String facilityId) throws Exception	
	{
		 Connection connection 		= null;
		 String specDetails=""; 
		
		CallableStatement	cstmt	=	null;
					try
					{	
						
						 connection = getConnection();
						cstmt	=	connection.prepareCall("{call RL_GET_NOTIFY_DTLS(?,?,?)}");							
						cstmt.setString (1,facilityId);
						cstmt.setString(2,order_id);
						cstmt.registerOutParameter(3, Types.VARCHAR); 
						cstmt.execute();
						specDetails=(String)cstmt.getString(3);
						
						
				}	
				catch(Exception e){
					e.printStackTrace();		
				}
					finally{
						closeStatement(cstmt);
						closeConnection( connection ); 
				}
		return specDetails ;
		}
	//IN067817 ends
	
	//IN072654 Starts
			public boolean getDrugInteractionDtls(String order_catalog_code,String order_id,String viewOrderBy,String order_line_num){
		//		ArrayList<String> interactiondrugCodes = new ArrayList<String>();//46480
				Connection con			= null;
				PreparedStatement psmt = null; 
				ResultSet rset 			= null;
		//		String interYN ="N";//46480
				boolean overRemarksExists = false; 
			
				ArrayList<OrderDrugInteractionVO> drugs = new ArrayList<OrderDrugInteractionVO>();
				OrderDrugInteractionVO drugInteractionVO = null;
			//	ArrayList<ArrayList<String>> drugList =  new ArrayList<ArrayList<String>>();//46480
			//	ArrayList<OrderDrugInteractionVO> interDrugsforLBOrder = null;//46480
				StringBuilder stringBuilder = new StringBuilder();
				//IN073562 Starts
				/*if("H".equals(viewOrderBy)){
				stringBuilder.append(" select a.DRUG_INTERACTION_CODE,a.INTERACTION_STATUS,a.OVERRIDE_REASON ,b.start_date_time,b.end_date_time,c.INTR_REMARKS");
				stringBuilder.append(" from or_order_drug_interaction a, or_order_line b,ph_drug_interaction c WHERE  a.order_id=b.order_id and a.DRUG_INTERACTION_CODE=C.INTR_CODE1");
				stringBuilder.append(" and a.ORDER_ID=? and c.INTR_CODE2=? ");
				}else
				{
					stringBuilder.append(" select distinct a.DRUG_INTERACTION_CODE,a.INTERACTION_STATUS,a.OVERRIDE_REASON ,b.start_date_time,b.end_date_time,c.INTR_REMARKS");
					stringBuilder.append(" from or_order_drug_interaction a, or_order_line b,ph_drug_interaction c WHERE  a.order_id=b.order_id and a.DRUG_INTERACTION_CODE=C.INTR_CODE1");
					stringBuilder.append(" and a.ORDER_ID=? and a.ORDER_CATALOG_CODE=? and c.INTR_CODE2=? AND a.ORDER_LINE_NUM=? ");
				}*/
				
				stringBuilder.append(" SELECT distinct ord.drug_interaction_code, o.start_date_time, o.end_date_time, di.intr_code2, di.intr_restrt_yn, di.intr_remarks,");
				stringBuilder.append(" (SELECT generic_name FROM ph_generic_name WHERE generic_id = pd.generic_id) drugdesc, ORD.OVERRIDE_REASON,ord.INTERACTION_STATUS");
				stringBuilder.append("  FROM or_order_line o, ph_drug_interaction di, or_order od, ph_drug pd,or_order_drug_interaction ord ");
				stringBuilder.append(" WHERE od.order_id = o.order_id AND di.intr_type2 = 'L' AND di.intr_type1 = 'G'  AND o.order_catalog_code = pd.drug_code AND pd.generic_id = di.intr_code1");
				stringBuilder.append(" AND NVL (di.eff_status, 'D') = 'E' AND di.intr_code2 = ? AND ORD.DRUG_INTERACTION_CODE = DI.INTR_CODE1  and ORD.order_catalog_code=?   ");
				stringBuilder.append(" AND ORD.ORDER_ID = ?  AND ORD.ORDER_LINE_NUM = ? AND o.order_line_status NOT IN ('CN', 'DC')   AND od.patient_id = ? ");
				stringBuilder.append(" AND od.encounter_id = ?  AND ord.ADDED_DATE BETWEEN o.start_date_time AND o.end_date_time ");
				stringBuilder.append(" UNION ALL ");
				stringBuilder.append(" SELECT DISTINCT ord.drug_interaction_code, o.start_date_time, o.end_date_time, di.intr_code2, di.intr_restrt_yn, di.intr_remarks,");
				stringBuilder.append("  o.catalog_desc drugdesc, ORD.OVERRIDE_REASON,ord.INTERACTION_STATUS");
				stringBuilder.append("  FROM or_order_line o, ph_drug_interaction di, or_order od, or_order_drug_interaction ord ");
				stringBuilder.append(" WHERE o.order_catalog_code = di.intr_code1 and  od.order_id = o.order_id AND di.intr_type2 = 'L' AND di.intr_type1 = 'D' ");
				stringBuilder.append(" AND NVL (di.eff_status, 'D') = 'E' AND di.intr_code2 = ? AND ORD.DRUG_INTERACTION_CODE = DI.INTR_CODE1  and ORD.order_catalog_code=?   ");
				stringBuilder.append(" AND ORD.ORDER_ID = ?  AND ORD.ORDER_LINE_NUM = ? AND o.order_line_status NOT IN ('CN', 'DC')   AND od.patient_id = ? ");
				stringBuilder.append(" AND od.encounter_id = ?  AND ord.ADDED_DATE BETWEEN o.start_date_time AND o.end_date_time ");
				//IN073562 Starts
				String interactionCode = "";//IN072654
				try {
					con = ConnectionManager.getConnection();
					psmt=con.prepareStatement(stringBuilder.toString());
				
						//IN073562 Starts
						psmt.setString(1,order_catalog_code);
						psmt.setString(2,order_catalog_code);
						psmt.setString(3, order_id);
						psmt.setString(4,order_line_num);
						psmt.setString(5,patient_id);
						psmt.setString(6,encntr_id);
						psmt.setString(7,order_catalog_code);
						psmt.setString(8,order_catalog_code);
						psmt.setString(9, order_id);
						psmt.setString(10,order_line_num);
						psmt.setString(11,patient_id);
						psmt.setString(12,encntr_id);
						//IN073562 Starts
				
						
						rset = psmt.executeQuery();
						while(rset.next())
						{ 
							if(!interactionCode.equals(rset.getString("drug_interaction_code"))){//IN072654
								interactionCode = rset.getString("drug_interaction_code");//IN072654
							drugInteractionVO = new OrderDrugInteractionVO();
						
							drugInteractionVO.setDrugCode(rset.getString("DRUG_INTERACTION_CODE"));
							drugInteractionVO.setDrugStartDate(rset.getString("start_date_time"));

							drugInteractionVO.setDrugDesc(rset.getString("drugdesc"));//IN073562 
							drugInteractionVO.setDrugEndDate(rset.getString("end_date_time"));
							drugInteractionVO.setDrugRestrictYN(rset.getString("INTERACTION_STATUS"));
							drugInteractionVO.setOverrideRemarks(rset.getString("OVERRIDE_REASON"));
							drugInteractionVO.setDrugRemarks(rset.getString("INTR_REMARKS"));
							if(null!= rset.getString("INTERACTION_STATUS") && "Y".equals(rset.getString("INTERACTION_STATUS"))){
								druginteractionYN.put(order_catalog_code, "R");
							}
							drugs.add(drugInteractionVO);
							}
						}
						if(null!=rset)
							rset.close();
						if(null!=drugs && drugs.size() >0){
							druginteractionDtl.put(order_catalog_code, drugs);
							overRemarksExists = true;
						}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} 
				finally{
					try {
						con.close();
						if(null!=psmt){
							psmt.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return overRemarksExists;
			}
		//IN072654 Ends
			
			//added for Common-ICN-0069
		public String getSlidingYN(String orderId, String parent_order_line_num){
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String sliding_yn = "";
			
			try
			{
				connection =getConnection();
			
			pstmt = connection.prepareStatement("SELECT SLIDING_SCALE_YN FROM OR_ORDER_LINE_PH where ORDER_ID = ? AND ORDER_LINE_NUM= ?");
			pstmt.setString(1, orderId);
			pstmt.setString(2, parent_order_line_num);
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next())
			{ 
				sliding_yn = resultSet.getString("SLIDING_SCALE_YN")==null?"":resultSet.getString("SLIDING_SCALE_YN");
		
			}
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		    finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
		   return sliding_yn;	
		} //added for Common-ICN-0069
		   //IN27707 Starts
			public String getOrderStatusType()throws Exception
			{
				Connection connection 		= null;
				PreparedStatement pstmt 	= null;
				ResultSet resultSet 		= null;
				String sql ="";
				String record = "";
				try
				{
					connection = getConnection() ;
					sql = " SELECT DFLT_ORDER_STATUS_YN FROM OR_PARAM WHERE MODULE_ID='OR' ";
					pstmt = connection.prepareStatement(sql);
					
					resultSet = pstmt.executeQuery() ;		
					if ( resultSet != null && resultSet.next()) 
					{
						record = checkForNull(resultSet.getString( "DFLT_ORDER_STATUS_YN" ),"ACT");
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
				return record;
			}
			 
			public String getPractBasedOrderCategory(String facility_id, String practitioner_type){
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String order_cate = "";
			
			try
			{
				connection =getConnection();
			
			pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY FROM OR_ONE_DAY_CONT_ORDER where FACILITY_ID = ? AND PRACTI_TYPE= ?");
			pstmt.setString(1, facility_id);
			pstmt.setString(2, practitioner_type);
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next())
			{ 
				order_cate = resultSet.getString("ORDER_CATEGORY")==null?"":resultSet.getString("ORDER_CATEGORY");
		
			}
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		    finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
		   return order_cate;	
		}
		//IN27707 Ends
		//19314 Start
		public HashMap getCopyPreviousOrderAccess(String facility_id,String practioner_type){
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String restDeptOrdCopyprev = "N";
			HashMap resultMap = new HashMap();
			System.out.println(facility_id+"<==========>"+practioner_type);
			try
			{
				connection =getConnection();
			
				pstmt = connection.prepareStatement("SELECT REST_DEPT_ORD_COPYPREV_YN FROM OR_PARAM_BY_FACILITY where OPERATING_FACILITY_ID = ? ");
				pstmt.setString(1, facility_id);
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next())
				{ 
					restDeptOrdCopyprev = resultSet.getString("REST_DEPT_ORD_COPYPREV_YN")==null?"N":resultSet.getString("REST_DEPT_ORD_COPYPREV_YN");
			
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ; 
				
				pstmt = connection.prepareStatement("SELECT A.ORDER_CATEGORY ORDER_CATEGORY,NVL(B.PLACE_DEPT_ONLY_YN,'N') PLACE_DEPT_ONLY_YN FROM OR_ORDER_CATEGORY A, or_ord_rule_by_pract  B WHERE A.ORDER_CATEGORY not in('CS','CN')  AND B.PRACT_TYPE(+) = ?  AND B.ORDER_CATEGORY_CODE(+)=A.ORDER_CATEGORY order by A.ORDER_CATEGORY ");
				pstmt.setString(1, practioner_type);
				resultSet = pstmt.executeQuery() ;
				while( resultSet != null && resultSet.next() ) 				
				{ 	
					System.out.println("======>"+restDeptOrdCopyprev+"<==========>"+resultSet.getString("ORDER_CATEGORY" ));
					if("N".equals(restDeptOrdCopyprev) && "Y".equals(resultSet.getString("PLACE_DEPT_ONLY_YN"))){
							resultMap.put((String)resultSet.getString("ORDER_CATEGORY"),"Y");
					}else if("Y".equals(restDeptOrdCopyprev) && "Y".equals(resultSet.getString("PLACE_DEPT_ONLY_YN"))){
							resultMap.put((String)resultSet.getString("ORDER_CATEGORY"),"N");
					}else if("N".equals(restDeptOrdCopyprev) && "N".equals(resultSet.getString("PLACE_DEPT_ONLY_YN"))){
							resultMap.put((String)resultSet.getString("ORDER_CATEGORY"),"Y");
					}else if("Y".equals(restDeptOrdCopyprev) && "N".equals(resultSet.getString("PLACE_DEPT_ONLY_YN"))){
							resultMap.put((String)resultSet.getString("ORDER_CATEGORY"),"N");
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		    finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
		   return resultMap;	
		}
		//19314 End.
		
		//ML-MMOH-CRF-1617.1 START
		public ArrayList getApptcancelResonAndRemarks(String order_id, String order_line_num) throws Exception {
		    Connection connection = null;
		    PreparedStatement pstmt = null;
		    ResultSet resultSet = null;
			HashMap<String,String>  resultMap=null;//hr
			String appt_resched_remarks = "";
			String appt_can_remarks = "";
			String appt_can_reason = "";
			String order_category ="";
			ArrayList Details = new ArrayList() ;

		    try {
		        connection = getConnection();
		        String query = "SELECT APPT_RESCHED_REMARKS, APPT_CAN_REMARKS, APPT_CAN_REASON,ORDER_CATEGORY FROM OR_ORDER_LINE WHERE order_id = ? AND order_line_num = ?";
		        pstmt = connection.prepareStatement(query);
		        pstmt.setString(1, order_id);
		        pstmt.setString(2, order_line_num);

		        resultSet = pstmt.executeQuery();
		        if (resultSet.next()) {
		        	resultMap= new HashMap<String,String>();
		        	
		        	appt_resched_remarks  		=	resultSet.getString("APPT_RESCHED_REMARKS")==null?"":resultSet.getString("APPT_RESCHED_REMARKS");
		        	appt_can_remarks  		=	resultSet.getString("APPT_CAN_REMARKS")==null?"":resultSet.getString("APPT_CAN_REMARKS");
		        	appt_can_reason     =    resultSet.getString("APPT_CAN_REASON")==null?"":resultSet.getString("APPT_CAN_REASON");
		        	order_category    =    resultSet.getString("ORDER_CATEGORY")==null?"":resultSet.getString("ORDER_CATEGORY");
		        	
		        	resultMap.put("APPT_RESCHED_REMARKS",appt_resched_remarks);
					resultMap.put("APPT_CAN_REMARKS",appt_can_remarks);
					resultMap.put("APPT_CAN_REASON",appt_can_reason);
					resultMap.put("ORDER_CATEGORY",order_category);
					Details.add(resultMap);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(resultSet);
		        closeStatement(pstmt);
		        closeConnection(connection);
		    }

		    return Details;
		}//ML-MMOH-CRF-1617.1 END

//68801 start.
		public String getExternalRequsitionFormYN(String orderId)
		 {  
			Connection con	= null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String existexternalReqFormYN ="";

		 	 String sql = "SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END AS EXTERNAL_REQUISITION_YN FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE IN ( SELECT ORDER_CATALOG_CODE FROM OR_ORDER_LINE WHERE ORDER_ID = ? ) AND EXTERNAL_REQUISITION_YN = 'Y'";
		 		try{
		 			 con			= getConnection();
		 			pstmt  = con.prepareStatement(sql);
					pstmt.setString(1, orderId);
					rs = pstmt.executeQuery();
					if(rs!=null && rs.next()){
						existexternalReqFormYN	= rs.getString("EXTERNAL_REQUISITION_YN")==null?"N":rs.getString("EXTERNAL_REQUISITION_YN");
					}
					if(rs!=null)
			    		rs.close();			    	
			    	if(pstmt!=null)
			    		pstmt.close();
		 	}catch(Exception e){        		
		 			e.printStackTrace();
		 	}
		 	finally
		 	{
		 		if(con!=null)
					try {
						closeConnection( con ); //62519
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
		 	}
		 		return existexternalReqFormYN;
		 }
//68801  end.
}
