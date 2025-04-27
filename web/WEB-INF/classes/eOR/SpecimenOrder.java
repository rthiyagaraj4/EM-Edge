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
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
03/02/2012	IN030168	VIJAY R			introduced new filter parameter 'ordering practitiner' in manage specimens page, search
										functionality.	
05/02/2012  IN031647	Ramesh G		CA>Place a order for which charge on order is defined in BL setup>Nurse Collect is Checked and
										Dispatch Required is Unchecked>Manage Specimen>Record Collection>Search>The System shows the order as Billed order
07/02/2012	IN031524	Ramesh G	    In Thai screen , Online report for Dispatch Slip is not working 								
08/05/2012	IN032486	Menaka V		Manage Specimen>Operator Status>Reprint Specimen>When Specimen Number and Ordering Practitioner are
										used as Search criteria then the Order details are not  displayed.								
14/08/2012	IN034365	Dinesh T		Script Error occurs in the Redirect order window
10/09/2012	IN035028	Chowminya G		Specimen Collection function record date/time in Thai year format 
01/10/2012	IN034716	Vijay R			In View after dispatch operator status, shows an exception
01/10/2012	IN034716	Vijay K			reopen- updated again on 3/10/2012 In View after dispatch operator status, shows an exception 
08/10/2012	IN034769	Ramesh G		ML-BRU-SCF-0371 
10/04/2013  IN039158    Nijitha S		From manage specimen function, whenever the ‘Ordering facility’ is ‘Select’, Collection barcode label can’t be printed and not appear in printing job queue.
05/06/2013	IN035837	Karthi L 		Requirement for managing future order and specimen number generation.[Bru-HIMS-CRF-320]
27/09/2013  IN043805	ChowminyaG		RL-Interval Tests-Redirect Order-Multifacility
24/01/2014	IN046592	Ramesh G		Manage Specimen is taking more than 40 seconds to complete after clicking on Record 
										when multiple records are selected. The response time is very slow.
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
04/03/2014	  IN047220	   Chowminya	      							Label printed for New list n record Collection, should print only 	for Newlist		
29/08/2014	  IN049737	   Chowminya	 					            MMS-CRF-194.1 Unbilled services will be regrouped into a new order								
04/09/2014    PER0409      Akbar										Newlist & record collection query changes for performance issue
04/11/2014	  IN052314	   Chowminya	 					            Java exception error while doing Manage Specimen for External Patient order							
27/05/2015	IN052230		Karthi L									Order Management-Missing specimens-Dispatch Slip
29/05/2015	IN055673		Karthi L									HSA-CRF-0250_IN052230:Unit Test Issue/02 - When click on reprint from Reprint Dispatch Slip function,
02/06/2015 	IN055694		Karthi L									System does not Select All when a record is Unselected and Selected again.
06/10/2015	IN055737		Karthi L									IN055737 HSA-CRF-0250.1 - Dispatch Slip
29/06/2016	IN060516		Karthi L									MMS-MD-SCF-0017 
02/01/2017	IN061888		Karthi L									To record collection all at 1 go
26/07/2017	IN064835		Vijayakumar K									ML-MMOH-CRF-0578.1 [IN:064835]		
31/10/2017	IN061892		Prakash C					Ramesh G			ML-MMOH-CRF-0544 [IN:061892]	
19/10/2017	IN065324		Dinesh T	19/10/2017		Ramesh G		To display the price in OR screen and the billing 																			status in Manage Specimen screen
17/10/2019	 IN071393		sivabagyam	 17/10/2019        Ramesh G       ML-MMOH-SCF-1369																		status in Manage Specimen screen
28/04/2020	IN072922		Nijitha S                                       MMS-KH-SCF-0068
28/06/2020		IN071820		Ramesh G		28/06/2020		Ramesh G		ML-MMOH-SCF-1413	
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
04/01/2021		5962		Sivabagyam M		04/01/2021		Ramesh G	ML-MMOH-CRF-1491
03/03/2022     29024         K pranay                                        Common-ICN-0092   closing statement
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.* ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderHome;//IN049737
import eOR.ORSpecimenOrder.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class SpecimenOrder extends eOR.Common.OrAdapter implements java.io.Serializable 
{

	protected Hashtable allValues 				= new Hashtable();
    
	protected String 	option_list				="";
	protected String    lb_module				= "";
	protected String    user_id					= "";
	protected String    user_password			= "";
	protected String	session_id					= "";
	protected String 	 prac_type 			    = "";
	protected String 	 order_category 		= "";
	protected String 	 order_category_short_desc   ="";
	protected String 	 order_type_code 		= "";
	protected String 	 order_type_short_desc  ="";
	protected String 	 priority_desc			="";
//	protected String 	 patient_class_short_desc    ="";
//	protected String 	 patient_class			="";
	protected String 	 location_type			="";
	protected String 	 locn_short_desc_location_details="";
	protected String	 order_id				= "";
//	protected String	 patient_id				= "";
	protected String	 encounter_id			= "";
	protected String	 order_date_time		= "";
	protected String	 order_detail			= "";
	protected String	 source_type			= "";
	protected String	 source_code			= "";
//	protected String	 priority				= "";
	protected String    ord_pract_id			= "";
	protected String    ordering_pract_name		= "";
	protected String    order_status			= "";
	protected String    order_status_short_desc	= "";
	protected String    ord_cosign_reqd_yn		= "";
	protected String    total_records 			= "";
//	protected String    date_from				= "";
//	protected String    date_to 				= "";
	protected String    specimen_date			= "";
//	protected String	function_id				= "";
//	protected String 	specimen_type			= "";
//	protected String 	specimen_hdr_date_time	= "";
	protected String	specimen_hdr_collected_by	= "";
	protected String	specimen_hdr_specimen_remarks = "";
	protected String	specimen_hdr_dispatch_mode	= "";
	protected String	specimen_new_list_collected_by	= "";
	protected String	specimen_new_list_specimen_remarks = "";
	protected String	specimen_new_list_seq_no	= "";
	protected String	specimen_new_list_date_time	= "";
	protected String    curr_sys_date			= "";
	protected String	auto_collect			= "";
	protected String	p_collection_list			= "";
	protected String	p_printLocationType		= "";
	protected String	p_printLocation			= "";
	protected String	p_date_from				= "";
	protected String	p_date_to					= "";
	protected String	p_priority				= "";
	protected String	p_location_type			= "";
	protected String	p_locn					= "";
	protected String	p_locn1					= "";
	protected String	p_order_type				= "";
	protected String	p_order_type1				= "";
	protected String	p_option					= "";
	protected String	p_select_specific_order	= "";
	protected String	p_patientId				= "";
	protected String	p_order_id				= "";
	protected String	p_encounter_id			= "";
	protected String	called_from				= "";//IN049737
	protected String	order_details			= "";//IN049737

	
	private String updatePerfLocn = "";
	private String updatePerfFacility = "";
	protected String old_start_date_time = ""; // added for IN035837[CRF 320]
	//HttpServletRequest request 					= null;		//[IN032796]//IN065324, check style issue
	//HttpServletResponse response 				= null;		//[IN032796]//IN065324, check style issue

	Hashtable tabDataPrint 	= new Hashtable();
	Hashtable stored_values =  new Hashtable();
	Hashtable specLabDataPrint =  new Hashtable(); //IN046592

	HashMap<String,ArrayList> selectedLocnRecords =  new HashMap<String,ArrayList>();
	// added for IN052230 - Start
	HashMap patientDispSlipSelected= new HashMap();
	HashMap clonePatientDispSlipSelected = new HashMap(); //IN055694
	HashMap manualBarcodeRemarks = new HashMap(); //Added for IN072184
	//5962 starts
	public SpecimenOrder()
	{
		setSiteSpecific("NO_PRINT_TOSPECIEMEN_REGISTER");
	}
	//5962 ends
	public void addPatientDispSlipSelected(String key,String value)
	{
		if(patientDispSlipSelected == null){
			patientDispSlipSelected= new HashMap();
		}
		patientDispSlipSelected.put(key,value);
	}
	
	public void removePatientDispSlipSelected(String key)
	{
		patientDispSlipSelected.remove(key);
	}
	public HashMap getPatientDispSlipSelected()
	{
		return patientDispSlipSelected;
	}
	public void removeAllPatientDispSlipSelected()
	{
		patientDispSlipSelected.clear();
	}
	public void setClonedPatientDispSlipRecords(HashMap cloneMap){
		clonePatientDispSlipSelected.putAll(cloneMap);
	}
	public HashMap getClonedPatientDispSlipRecords()
	{
		return clonePatientDispSlipSelected;
	}
	public void addPatientDispSlipSelected(HashMap clonePatientDispSlipSelected)
	{
		patientDispSlipSelected.putAll(clonePatientDispSlipSelected);
	}
	public void removeAllClonedPatientDispSlipRecords(){
		clonePatientDispSlipSelected.clear();
	}
	// IN052230 - End
	//added for IN055737 HSA-CRF-0250.1 - Start
	public void addClonedPatientDispSlipRecords(String key,String value)
	{
		if(clonePatientDispSlipSelected == null){
			clonePatientDispSlipSelected= new HashMap();
		}
		clonePatientDispSlipSelected.put(key,value);
	}
	// added for IN055737 HSA-CRF-0250.1 - End 
	public void addSelectedLocnRecord(String key,ArrayList value)
	{
		selectedLocnRecords.put(key,value);
	}
	
	public void removeSelectedLocnRecord(String key)
	{
		selectedLocnRecords.remove(key);
	}
	
	public void removeAllSelectedLocnRecord()
	{
		selectedLocnRecords.clear();
	}
	public ArrayList getselectedLocnRecord(String key)
	{
		return selectedLocnRecords.get(key);
	}
	
	public HashMap getselectedLocnRecords()
	{
		return selectedLocnRecords;
	}
	public void setTotalRecs(String total_records)
	{
		this.total_records = total_records;
	}

	public void setOptionList(String option_list)
	{
		this.option_list = option_list;
	}

	public void setLbInstall(String lb_module)
	{
		this.lb_module = lb_module;
	}

	public void setPracType(String prac_type)
	{
			this.prac_type = prac_type;
	}

	public void setSessionId(String session_id) 
	{
			this.session_id	= session_id;
	}

	public String  getPracType()
	{
		return prac_type;
	}

	public Hashtable getStored_values() 
	{
	   return this.stored_values;
	}

	public Hashtable getTabDataPrint() 
	{
	   return this.tabDataPrint;
	}
	//IN046592 Start.
	public Hashtable getSpecLabDataPrint() 
	{
	   return this.specLabDataPrint;
	}
	//IN046592 End.
	//IN047220 - Start
	public void clearPrintingValues(){
		   stored_values   	    		= new Hashtable(); // Used for On Line Printing
		   tabDataPrint					= new Hashtable(); // Used for On Line Printing
		   specLabDataPrint				= new Hashtable(); //IN046592
	   }
	//IN047220 - End
/*	public void setFunctionId(String function_id){
			this.function_id = function_id;
	}*/
	public void setSpecimenDate(String specimen_date)
	{
		this.specimen_date = specimen_date;
	}

	public void setSpecimen_hdr_dispatch_mode(String specimen_hdr_dispatch_mode) 
	{
		this.specimen_hdr_dispatch_mode = specimen_hdr_dispatch_mode;
	}

	public void setSpecimen_hdr_collected_by(String specimen_hdr_collected_by) 
	{
		this.specimen_hdr_collected_by = specimen_hdr_collected_by;
	}

	public void setSpecimen_hdr_specimen_remarks(String specimen_hdr_specimen_remarks) 
	{
		this.specimen_hdr_specimen_remarks = specimen_hdr_specimen_remarks;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public void setOrderCategory(String order_category)
	{
		this.order_category = order_category;
	}

	public void setOrderCategoryDesc(String order_category_desc)
	{
		this.order_category_short_desc = order_category_desc;
	}

	public void setOrderType(String order_type_code)
	{
		this.order_type_code = order_type_code;
	}

	public void setOrderTypeDesc(String order_type_code_desc)
	{
			this.order_type_short_desc = order_type_code_desc;
	}

/*	public void setPatientClassDesc(String patient_class_short_desc){
			this.patient_class_short_desc = patient_class_short_desc;
	}

	public void setPatientClass(String patient_class){
			this.patient_class = patient_class;
	}
*/

	public void setLocationType(String location_type)
	{
			this.location_type = location_type;
	}

	public void setLocationDesc(String locn)
	{
			this.locn_short_desc_location_details = locn;
	}

	public void setOrderId(String order_id)
	{
			this.order_id= order_id;
	}

/*	public void setPatientId(String patient_id){
			this.patient_id = patient_id;
	}
*/
	public void setEncntrId(String encntr_id)
	{
			this.encounter_id = encntr_id;
	}

/*	public void setDateFrom(String date_from){
			this.order_date_time= date_from;
	}*/
	public void  setOrderDetail(String order_detail)
	{
			this.order_detail=order_detail;
	}

	public void setSourceType(String source_type)
	{
			this.source_type=source_type;
	}

	public void setSourceCode(String source_code)
	{
			this.source_code=source_code;
	}

/*	public void setPriority(String Priority){
			this.priority=Priority;
	}*/

	public void setOrdPractId(String ord_pract_id)
	{
			this.ord_pract_id=ord_pract_id;
	}

	public void setOrderingPractName(String ordering_pract_name)
	{
			this.ordering_pract_name=ordering_pract_name;
	}

	public void setOrderStatus(String order_status)
	{
			this.order_status=order_status;
	}

	public void setOrderStatusDesc(String order_status_short_desc)
	{
			this.order_status_short_desc=order_status_short_desc;
	}

	public void setOrdCosignReqdYn(String ord_cosign_reqd_yn)
	{
			this.ord_cosign_reqd_yn=ord_cosign_reqd_yn;
	}
/*	public void setSpecimenDateTime(String specimen_hdr_date_time){
			if(specimen_hdr_date_time==null) specimen_hdr_date_time = "";
			this.specimen_hdr_date_time = specimen_hdr_date_time;
	}*/

	/*public void setDateTo(String date_to){
			this.date_to= date_to;
	}*/

	public void setCurrentDate(String curr_sys_date)
	{
				this.curr_sys_date= curr_sys_date;
	}

	public void setP_collection_list(String collection_list) 
	{
		this.p_collection_list = collection_list;
	}

	public void setP_printLocationType(String printLocationType) 
	{
		this.p_printLocationType = printLocationType;
	}

	public void setP_printLocation(String printLocation) 
	{
		this.p_printLocation = printLocation;
	}

	public void setP_date_from(String	date_from) 
	{
		this.p_date_from = date_from;
	}

	public void setP_date_to(String date_to) 
	{
		this.p_date_to = date_to;
	}

	public void setP_priority(String priority) 
	{
		this.p_priority = priority;
	}

	public void setP_location_type(String location_type) 
	{
		this.p_location_type = location_type;
	}

	public void setP_locn(String locn) 
	{
		this.p_locn = locn;
	}

	public void setP_locn1(String locn1) 
	{
		this.p_locn1 = locn1;
	}

	public void setP_order_type(String order_type) 
	{
		this.p_order_type = order_type;
	}

	public void setP_order_type1(String order_type1) 
	{
		this.p_order_type1 = order_type1;
	}

	public void setP_option(String option) 
	{
		this.p_option = option;
	}

	public void setP_select_specific_order(String select_specific_order) 
	{
		this.p_select_specific_order = select_specific_order;
	}

	public void setP_patientId(String patientId) 
	{
		this.p_patientId = patientId;
	}

	public void setP_order_id(String order_id) 
	{
		this.p_order_id = order_id;
	}

	public void setP_encounter_id(String encounter_id) 
	{
		this.p_encounter_id = encounter_id;
	}

	public void setAuto_collect(String auto_collect) 
	{
		this.auto_collect = auto_collect;
	}

	public void setSpecimen_new_list_collected_by(String specimen_new_list_collected_by) 
	{
		this.specimen_new_list_collected_by = specimen_new_list_collected_by;
	}
	
	public void setSpecimen_new_list_date_time(String specimen_new_list_date_time) 
	{
		this.specimen_new_list_date_time = specimen_new_list_date_time;
	}

	public void setSpecimen_new_list_specimen_remarks(String specimen_new_list_specimen_remarks) 
	{
		this.specimen_new_list_specimen_remarks = specimen_new_list_specimen_remarks;
	}

	public void setSpecimen_new_list_seq_no(String specimen_new_list_seq_no) 
	{
		this.specimen_new_list_seq_no = specimen_new_list_seq_no;
	}
	//IN049737 - Start
	public void setCalled_from(String called_from) 
	{
		this.called_from = called_from;
	}
	public void setOrder_details(String order_details) 
	{
		this.order_details = order_details;
	}
	//IN049737 - End

	public String getAuto_collect() 
	{
		return this.auto_collect;
	}

	public String getP_encounter_id() 
	{
		return this.p_encounter_id;
	}

	public String getP_order_id() 
	{
		return this.p_order_id;
	}

	public String getP_patientId() 
	{
		return this.p_patientId;
	}

	public String getP_select_specific_order() 
	{
		return this.p_select_specific_order;
	}

	public String getP_option() 
	{
		return this.p_option;
	}

	public String getP_order_type1() 
	{
		return this.p_order_type1;
	}

	public String getP_order_type () 
	{
		return this.p_order_type;
	}

	public String getP_locn1() 
	{
		return this.p_locn1;
	}

	public String getP_locn() 
	{
		return this.p_locn;
	}

	public String getP_location_type() 
	{
		return this.p_location_type;
	}

	public String getP_priority() 
	{
		return this.p_priority;
	}

	public String getP_date_to() 
	{
		return this.p_date_to;
	}

	public String getP_date_from() 
	{
		return this.p_date_from;
	}

	public String getP_printLocation() 
	{
		return this.p_printLocation;
	}

	public String getP_printLocationType() 
	{
		return this.p_printLocationType;
	}

	public String getP_collection_list() 
	{
		return this.p_collection_list;
	}

	public String getMode()
	{
		return mode;
	}

	public String getTotalRecs()
	{
		return total_records;
	}

	public String getspecimen_date()
	{
		return specimen_date;
	}

	public String getOrderCategory()
	{
		return order_category;
	}

	public String getOrderCategoryDesc()
	{
		return order_category_short_desc;
	}

	public String getOrderType()
	{
		return order_type_code;
	}

	public String setOrderTypeDesc()
	{
		return order_type_short_desc;
	}

	public String getPriority()
	{
		return priority_desc;
	}

	public String getLocationType()
	{
		return location_type;
	}

	public String getLocation()
	{
		return locn_short_desc_location_details;
	}

	public String getOrderId()
	{
		return order_id;
	}
	/*public String getPatientId(){
			return patient_id;
	}*/
	public String getEncntrId()
	{
		return encounter_id;
	}
	public String order_date_time()
	{
		return order_date_time;
	}
	public String getOrderDetail()
	{
		return order_detail;
	}
	public String getSourceType()
	{
		return source_type;
	}
	public String getSourceCode()
	{
		return source_code;
	}

	public String getOrdPractId()
	{
		return ord_pract_id;
	}

	public String getOrderingPractName()
	{
		return ordering_pract_name;
	}

	public String getOrderStatus()
	{
		return order_status;
	}

	public String getOrderStatusShortDesc()
	{
		return order_status_short_desc;
	}

	public String getOrdCosignReqdYn()
	{
			return ord_cosign_reqd_yn;
	}

	public String getCurrentDate()
	{
			return curr_sys_date;
	}

	public String getSpecimen_hdr_dispatch_mode() 
	{
		return this.specimen_hdr_dispatch_mode;
	}

	public String getSpecimen_hdr_collected_by() 
	{
		return this.specimen_hdr_collected_by;
	}

	public String getSpecimen_hdr_specimen_remarks() 
	{
		return this.specimen_hdr_specimen_remarks;
	}

	public String getSpecimen_new_list_collected_by() 
	{
		return this.specimen_new_list_collected_by;
	}
	
	public String getSpecimen_new_list_date_time() 
	{
		return this.specimen_new_list_date_time;
	}
	
	public String getSpecimen_new_list_specimen_remarks() 
	{
		return this.specimen_new_list_specimen_remarks;
	}

	public String getSpecimen_new_list_seq_no() 
	{
		return this.specimen_new_list_seq_no;
	}
	//IN049737 - Start
	public String getCalledFrom() 
	{
		return this.called_from;
	}
	public String getOrderDetails() 
	{
		return this.order_details;
	}
	//IN049737 - End
	public String getStartDate() 
	{
			return old_start_date_time;
	}
	public void setStartDate(String old_start_date_time)
	{
				this.old_start_date_time = old_start_date_time;
	}
	//Added for IN072184

	public void setManualBarcodeRemarks(HashMap barCodeRemakrs){
		manualBarcodeRemarks=barCodeRemakrs;
	}
	public HashMap getManualBarcodeRemarks()
	{
		return manualBarcodeRemarks;
	}
//Adding end for IN072184
	
/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public ArrayList  getOrderTypeSpecimen() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try 
		{

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_TYPE_SELECT") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database ORDERTYPESPECIMEN" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}





/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
public ArrayList getLocation(String location_type) throws Exception 
{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
			
			try 
			{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN") ) ;
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5, location_type.trim() ) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "locn_code" )  ;
					record[1] = resultSet.getString( "location_desc" )  ;

					Location.add(record) ;
				}
			} 
			catch ( Exception e )	
			{
				System.err.println( "Error loading values from database GETlOCATION" ) ;
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return Location;
		}


public String getLbInstall(String module_id) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String lb_install_yn	= "N";
	try
	{
	
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					lb_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
				}
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database LBINSTAL" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return lb_install_yn;
}

public String getIntervalTestYn(String order_id) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String interval_test_yn		= "N";
	try
	{
		
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_INTERVAL_TEST_YN"));
			pstmt.setString(1, checkForNull(order_id.trim(),""));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					interval_test_yn = checkForNull(resultSet.getString( "INTERVAL_TEST_YN" ),"N")  ;
				}
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database INTERVAL_TEST_YN" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return interval_test_yn;
}

public ArrayList getIntervalSpecimenDetails(String order_id) throws Exception
{
	Connection connection 			= null;
	PreparedStatement pstmt 		= null;
	ResultSet resultSet 			= null;
	ArrayList SpecimenDetailsFinal	= new ArrayList() ;
	try 
	{
		connection = getConnection() ;
		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_INTERVAL_SPECIMEN_SELECT") ) ;
		pstmt.setString( 1, checkNull(order_id) );

		resultSet = pstmt.executeQuery() ;
		while( resultSet != null && resultSet.next() ) 
		{
			ArrayList SpecimenDetails = new ArrayList();
			SpecimenDetails.add(resultSet.getString( "description" ))  ;
			SpecimenDetails.add(resultSet.getString( "specimen_no" ))  ;
			SpecimenDetails.add(resultSet.getString( "SPECIMEN_COLLECT_DATE_TIME" ))  ;
			SpecimenDetails.add(resultSet.getString("SEQ_NO"));
			SpecimenDetailsFinal.add(SpecimenDetails);
		}
	} 
	catch( Exception e )	
	{
		System.err.println( "Error loading values from database INTERVALSPECIMEN" ) ;
		e.printStackTrace() ;
		throw e ;
	} 
	finally 
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection) ;
	}
	return SpecimenDetailsFinal;
}

public String getSessionId() throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String session_id			= "";
	try
	{
		
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SESSION_SELECT"));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					session_id = checkForNull(resultSet.getString( "session_id" ),"")  ;
				}
			}
		}
		catch ( Exception e )
		{
			System.err.println( "Error loading values from database SESSIONID" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return session_id;
}



private   String  checkNull(String args)
{
	return args==null ||args.equals("")?"":args.trim();

}
/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
// [IN030168] Start
// public ArrayList getSearchDetails(String practitioner_type,String date_from1,String date_to1 ,String priority1 ,String location_type,String locn1,String locn2,String order_type1,String order_type2 ,String option1 ,String patientId1,String order_id1 ,String encounter_id1, String specimen_no, String ordering_facility, String performing_facility ,String status, String ordered_location,String ordered_location_code,int start,int end) throws Exception 
//public ArrayList getSearchDetails(String practitioner_type,String date_from1,String date_to1 ,String priority1 ,String location_type,String locn1,String locn2,String order_type1,String order_type2 ,String option1 ,String patientId1,String order_id1 ,String encounter_id1, String specimen_no, String ordering_facility, String performing_facility ,String status, String ordered_location,String ordered_location_code,int start,int end,String practitioner_id) throws Exception // commented for IN052230 
public ArrayList getSearchDetails(String practitioner_type,String date_from1,String date_to1 ,String priority1 ,String location_type,String locn1,String locn2,String order_type1,String order_type2 ,String option1 ,String patientId1,String order_id1 ,String encounter_id1, String specimen_no, String ordering_facility, String performing_facility ,String status, String ordered_location,String ordered_location_code,int start,int end,String practitioner_id, String multiSelect, String isBarCodeSearchEnabled) throws Exception //addition param added for IN052230, param isBarCodeSearchEnabled added for IN055737 HSA-CRF-0250.1
{ 
// [IN030168] End
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;
		int cnt = 0;
		HashMap dispatchMap = null; // IN052230 
		HashMap clonedDispatchMap = null; //IN055737 HSA-CRF-0250.1
		boolean specimenSite=false;//5962
		specimenSite=isSiteSpecific("NO_PRINT_TOSPECIEMEN_REGISTER");//5962
		//int total_records			= 0;
		/* Thai date validations start 15/02/2007*/

		if(date_from1.equals(" ") || date_from1.equals("null")) date_from1 = "";
		if(date_to1.equals(" ") || date_to1.equals("null")) date_from1 = "";
		if(patientId1.equals(" ") || patientId1.equals("null")) patientId1 = "";
		if(order_id1.equals(" ") || order_id1.equals("null")) order_id1 = "";
		if(encounter_id1.equals(" ") || encounter_id1.equals("null")) encounter_id1 = "";
		if(specimen_no.equals(" ") || specimen_no.equals("null")) specimen_no = "";
		if(ordering_facility.equals(" ") || ordering_facility.equals("null")) ordering_facility = "";
		if(performing_facility.equals(" ") || performing_facility.equals("null")) performing_facility = "";
		// [IN030168] Start
		if(practitioner_id.equals(" ") || practitioner_id.equals("null")) practitioner_id = "";
		// [IN030168] End
		if (!language_id.equals("en"))
		{
			date_from1=com.ehis.util.DateUtils.convertDate(date_from1,"DMYHM",language_id,"en");
			date_to1=com.ehis.util.DateUtils.convertDate(date_to1,"DMYHM",language_id,"en");
		}
		/* Thai date validations end 15/02/2007*/
		try 
		{
			connection = getConnection() ;
			String sql   = "";
			dispatchMap = getPatientDispSlipSelected();
			clonedDispatchMap = getClonedPatientDispSlipRecords();  // IN055737 HSA-CRF-250.1
			//[IN030589] Starts
			if((option1.equals("N")))
			{
				 //sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_DETAIL_RECORDS");//[IN030589]
				 //sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN030589]//IN039158
				 //sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND to_char(c.start_DATE_time,'dd/mm/yyyy hh24:mi') BETWEEN sm_convert_date_2t(TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi'),?) AND sm_convert_date_2t(TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi'),?) AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031524]
				 //sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id, c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//IN039158
				 //PER0409 - start
				//sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id, c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi') AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## &&SOURCETYPE## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt desc";//IN071393
				sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id, c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi') AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num AND c.order_category = b.order_category AND c.order_type_code=b.order_type &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## &&SOURCETYPE## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt,order_id";//IN071393
			
				 if(!patientId1.equals(""))
				{
					//sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = NVL (?,b.patient_id) ");
					sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&PATIENTID##" , " ");
				}
				
				if(!encounter_id1.equals(""))
				{
					//sql = sql.replace("&&ENCOUNTERID##" , " AND NVL (b.encounter_id, 1) = NVL (?, NVL (b.encounter_id, 1)) ");
					sql = sql.replace("&&ENCOUNTERID##" , " AND b.encounter_id = ? ");	// PER0409 
				}
				else
				{
					sql = sql.replace("&&ENCOUNTERID##" , " ");
				}

				if(!ordering_facility.equals(""))
				{
					//sql = sql.replace("&&ORDFACID##" , " AND A.ordering_facility_id = NVL (?, A.ordering_facility_id)");
					sql = sql.replace("&&ORDFACID##" , " AND A.ordering_facility_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&ORDFACID##" , " ");
				}			

				if(!performing_facility.equals(""))
				{
					//sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = NVL (?, a.performing_facility_id)");
					sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&PERFACID##" , " ");
				}
				 // PER0409 - end

				if(!order_id1.equals(""))
				{
					sql = sql.replace("&&ORDERID##" , " and a.order_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDERID##" , " ");
				}
				// PER0409 Starts
				if(!locn1.equals("") && !"null".equals(locn1) )
				{
					sql = sql.replace("&&SOURCECODE##" , " AND NVL (b.source_code, '!')=? ");
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				if(!order_type1.equals("") && !"null".equals(order_type1) )
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " AND b.order_type=? ");
				}
				else
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " ");
				}
				if(!priority1.equals("") && !"null".equals(priority1))
				{
					sql = sql.replace("&&PRIORITY##" , " AND NVL (b.priority, 'R') = ? ");
				}
				else
				{
					sql = sql.replace("&&PRIORITY##" , " ");
				}
				if(!location_type.equals("") && !"null".equals(location_type))
				{
					sql = sql.replace("&&SOURCETYPE##" , " AND NVL (b.source_type, '!') = ? ");
				}
				else
				{
					sql = sql.replace("&&SOURCETYPE##" , " ");
				}
				// PER0409 Ends	
				// [IN030168] Start
				if(!practitioner_id.equals(""))
				{
					//sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = NVL (?, a.ord_pract_id)");
					sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = ? ");
				}
				else
				{
					sql = sql.replace("&&ORDPRACTID##" , " ");
				}
				// [IN030168] End


				if(option1.equals("N"))
				{
					sql = sql.replace("&&DISPATCH##" , " ");
					sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SN' ");
				}
				else if (option1.equals("C"))
				{
					sql = sql.replace("&&DISPATCH##" , " ");

					if(!specimen_no.equals(""))
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SC'  and c.accession_num =  ?");
					}
					else
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SC'");
					}
				}
				else if (option1.equals("D"))
				{
					sql = sql.replace("&&DISPATCH##" , " , TO_CHAR(E.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time ");
					if(!specimen_no.equals(""))
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SD'  and c.accession_num = ?");
					}
					else
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SD' ");
					}
				}
			}
			//[IN030589] Ends
			//if((option1.equals("N")) || (option1.equals("D")) || (option1.equals("C")))//[IN030589]
			if((option1.equals("D")) || (option1.equals("C")))//[IN030589]
			{
				/* 
				[IN030168] Start	
				  sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_DETAIL_RECORDS");//[IN030589]				 
				 //sql ="SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## ORDER BY a.source_type, location_description, start_date_time_dt DESC";
				 */
				 //sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031647]
				 //sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num )  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031647]//IN039158
				 
				//[IN030168] Ends.
				// PER0409 Starts

				//sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num )  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//IN039158
				//sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc, am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num )  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi') AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## &&SOURCETYPE## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt desc";//IN039158  // PER0409
				sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc, am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?,c.order_id,c.order_line_num )  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi') AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num AND c.order_category = b.order_category AND c.order_type_code=b.order_type &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## &&SOURCETYPE## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt,order_id";//IN071393				  	
				if(!patientId1.equals(""))
				{
					//sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = NVL (?,b.patient_id) ");
					sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&PATIENTID##" , " ");
				}
				
				if(!encounter_id1.equals(""))
				{
					//sql = sql.replace("&&ENCOUNTERID##" , " AND NVL (b.encounter_id, 1) = NVL (?, NVL (b.encounter_id, 1)) ");
					sql = sql.replace("&&ENCOUNTERID##" , " AND b.encounter_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&ENCOUNTERID##" , " ");
				}

				if(!ordering_facility.equals(""))
				{
					//sql = sql.replace("&&ORDFACID##" , " AND A.ordering_facility_id = NVL (?, A.ordering_facility_id)");
					sql = sql.replace("&&ORDFACID##" , " AND A.ordering_facility_id = ?");		// PER0409
				}
				else
				{
					sql = sql.replace("&&ORDFACID##" , " ");
				}			

				if(!performing_facility.equals(""))
				{
					//sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = NVL (?, a.performing_facility_id)");
					sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = ? ");	// PER0409
				}
				else
				{
					sql = sql.replace("&&PERFACID##" , " ");
				}

				if(!order_id1.equals(""))
				{
					sql = sql.replace("&&ORDERID##" , " and a.order_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDERID##" , " ");
				}
				// PER0409 Starts
				if(!locn1.equals("") && !"null".equals(locn1) )
				{
					sql = sql.replace("&&SOURCECODE##" , " AND NVL (b.source_code, '!')=? ");
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				if(!order_type1.equals("") && !"null".equals(order_type1) )
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " AND b.order_type=? ");
				}
				else
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " ");
				}
				if(!priority1.equals("") && !"null".equals(priority1))
				{
					sql = sql.replace("&&PRIORITY##" , " AND NVL (b.priority, 'R') = ? ");
				}
				else
				{
					sql = sql.replace("&&PRIORITY##" , " ");
				}
				if(!location_type.equals("") && !"null".equals(location_type))
				{
					sql = sql.replace("&&SOURCETYPE##" , " AND NVL (b.source_type, '!') = ? ");
				}
				else
				{
					sql = sql.replace("&&SOURCETYPE##" , " ");
				}
				// PER0409 Ends				
				// [IN030168] Start
				if(!practitioner_id.equals(""))
				{
					//sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = NVL (?, a.ord_pract_id)");
					sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = ? ");
				}
				else
				{
					sql = sql.replace("&&ORDPRACTID##" , " ");
				}
				// [IN030168] End
				if(option1.equals("N"))
				{
					sql = sql.replace("&&DISPATCH##" , " ");
					sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SN' ");
				}
				else if (option1.equals("C"))
				{
					sql = sql.replace("&&DISPATCH##" , " ");

					if(!specimen_no.equals(""))
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SC'  and c.accession_num =  ?");
					}
					else
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SC'");
					}
				}
				else if (option1.equals("D"))
				{
					sql = sql.replace("&&DISPATCH##" , " , TO_CHAR(E.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time ");
					if(!specimen_no.equals(""))
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SD'  and c.accession_num = ?");
					}
					else
					{
						sql = sql.replace("&&FILTER##" , " AND PEND_STATUS_IND='SD' ");
					}
				}
			}
			else if(option1.equals("R") )
			{
				//sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_SELECT");
				//[IN031647] sql = "SELECT DISTINCT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi')  AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) AND a.order_type_code=NVL (?, a.order_type_code) AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ AND NVL (source_type, '!') = NVL (?, NVL (source_type, '!')) &&ORDFACID## &&PERFACID## &&ORDPRACTID## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&SPECINO## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN030589] 
				// sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi')  AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ &&SOURCETYPE## &&ORDFACID## &&PERFACID## AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031647]//IN032486//IN039158
				//sql = "SELECT DISTINCT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND to_char(c.start_date_time,'dd/mm/yyyy hh24:mi') BETWEEN sm_convert_date_2t(TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi'),?)  AND sm_convert_date_2t(TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi'),?) AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) AND a.order_type_code=NVL (?, a.order_type_code) AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ AND NVL (source_type, '!') = NVL (?, NVL (source_type, '!')) &&ORDFACID## &&PERFACID## &&ORDPRACTID## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&SPECINO## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031524]
				//sql = "SELECT DISTINCT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi')  AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) AND a.order_type_code=NVL (?, a.order_type_code) AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ AND NVL (source_type, '!') = NVL (?, NVL (source_type, '!')) &&ORDFACID## &&PERFACID## AND SUBSTR (a.order_id, 1, 2) != 'CS' &&SPECINO## ORDER BY a.source_type, location_description, start_date_time_dt DESC";
				 //sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi')  AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ &&SOURCETYPE## &&ORDFACID## &&PERFACID## AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt desc";//IN039158//IN071393
				if(!specimenSite)  ///5962 starts
					sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi')  AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC','RG','AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ &&SOURCETYPE## &&ORDFACID## &&PERFACID## AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt, order_id";
				else
					sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi')  AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB' &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id  AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num &&ENCOUNTERID##  &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1  AND b.coll_label_gen_rule = 'G' AND order_status IN ('OS', 'SC', 'AB', 'AV', 'AF','SD') /*AND (   (    NVL (b.coll_label_gen_rule, 'P') IN ('P') AND ? = 'N' AND order_status IN (select order_status_code from or_order_status_code ii where ii.ORDER_STATUS_TYPE between '10' and '25')) OR (NVL (b.coll_label_gen_rule, 'P') = 'G' AND ? = 'R' AND order_status IN ('OS', 'SC', 'RG', 'AB', 'AV', 'AF','SD')) OR (NVL (b.coll_label_gen_rule, 'P') IN ('G', 'X') AND ? = 'C' AND order_status IN ('SC', 'OS', 'AB', 'AV', 'AF') AND coll_reqd_yn = 'Y' AND specimen_collect_yn = 'N' AND specimen_dispatch_yn = 'N'  AND coll_label_gen_date_time IS NULL))*/ &&SOURCETYPE## &&ORDFACID## &&PERFACID## AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt, order_id";
					//5962 ends
				if(!patientId1.equals(""))
				{
					sql = sql.replace("&&PATIENTID##" , " AND a.patient_id = ? ");
				}
				else
				{
					sql = sql.replace("&&PATIENTID##" , " ");
				}
				
				if(!encounter_id1.equals(""))
				{
					sql = sql.replace("&&ENCOUNTERID##" , " AND encounter_id = ? ");
				}
				else
				{
					sql = sql.replace("&&ENCOUNTERID##" , " ");
				}

				if(!ordering_facility.equals(""))
				{
					sql = sql.replace("&&ORDFACID##" , " AND ordering_facility_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDFACID##" , " ");
				}			

				if(!performing_facility.equals(""))
				{
					sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = ?");
				}
				else
				{
					sql = sql.replace("&&PERFACID##" , " ");
				}

				if(!specimen_no.equals(""))
				{
					sql = sql.replace("&&SPECINO##" , " and c.accession_num =  ?");
				}
				else
				{
					sql = sql.replace("&&SPECINO##" , " ");
				}	
				if(!order_id1.equals(""))
				{
					sql = sql.replace("&&ORDERID##" , " and a.order_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDERID##" , " ");
				}
				// [IN030168] Start
				if(!practitioner_id.equals(""))
				{
					//sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = NVL (?, a.ord_pract_id)");
					sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = ? ");
				}
				else
				{
					sql = sql.replace("&&ORDPRACTID##" , " ");
				}
				// [IN030168] End
				//Menaka Starts
				if(!locn1.equals(""))
				{
					//sql = sql.replace("&&SOURCECODE##" , " AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) ");
					sql = sql.replace("&&SOURCECODE##" , " AND NVL (source_code, '!')=? ");
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				if(!order_type1.equals(""))
				{
					//sql = sql.replace("&&ORDERTYPECODE##" , " AND a.order_type_code=NVL (?, a.order_type_code) ");
					sql = sql.replace("&&ORDERTYPECODE##" , " AND a.order_type_code=? ");
				}
				else
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " ");
				}
				if(!priority1.equals(""))
				{
					//sql = sql.replace("&&PRIORITY##" , " AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) ");
					sql = sql.replace("&&PRIORITY##" , " AND NVL (a.priority, 'R') = ? ");
				}
				else
				{
					sql = sql.replace("&&PRIORITY##" , " ");
				}
				if(!location_type.equals(""))
				{
					//sql = sql.replace("&&SOURCETYPE##" , " AND NVL (source_type, '!') = NVL (?, NVL (source_type, '!')) ");
					sql = sql.replace("&&SOURCETYPE##" , " AND NVL (source_type, '!') = ? ");
				}
				else
				{
					sql = sql.replace("&&SOURCETYPE##" , " ");
				}
				//Menaka Ends

			}
			else if (option1.equals("V") || option1.equals("S")) 
			{	
				/* [IN030168] Start
				// view Dispatch Slip
				sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_VIEW_DISPATCH_SLIP_SELECT") ;//[IN030589]
				//sql ="SELECT DISTINCT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num, source_type, source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,TO_CHAR(b.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time,get_age (d.date_of_birth) age,d.sex sex,DECODE (?, 'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id and c.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?, '31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB'  &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num  &&ENCOUNTERID## &&ORDERID## AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) AND a.order_type_code=NVL (?, a.order_type_code) AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) AND b.order_line_num = 1 AND SYSDATE >= c.start_date_time AND source_type = NVL (?, source_type) &&PERFACID## AND (b.dispatch_reqd_yn = 'Y' AND b.specimen_dispatch_yn = 'Y') AND (   coll_reqd_yn = 'N' OR (coll_reqd_yn = 'Y' AND specimen_collect_yn = 'Y')) AND coll_label_gen_rule IN ('G', 'X') AND SUBSTR (a.order_id, 1, 2) != 'CS' &&SPECINO## &&ORDFACID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";
				*/
				//[IN031467]sql = "SELECT  a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,             am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE               WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2') END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num) FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,A.source_type, A.source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code  (a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,E.specimen_type specimen_type,E.specimen_collect_yn specimen_collect_yn,E.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,E.specimen_type,E.specimen_collect_yn,a.priority,c.start_date_time, NULL,a.order_type_code,A.performing_facility_id,?)  or_collection_due, get_age (d.date_of_birth) age, d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code &&DISPATCH## FROM or_order a, or_order_pend_status_log b, or_order_line c, mp_patient d, or_order_line_LB E WHERE a.patient_id = d.patient_id AND c.start_DATE_time BETWEEN TO_DATE (NVL (?,'01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL (?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND b.order_category= 'LB' &&PATIENTID## AND a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND E.order_id = c.order_id AND E.order_line_num = c.order_line_num &&ENCOUNTERID## &&ORDERID## AND NVL (b.source_code, '!') = NVL (?, NVL (b.source_code, '!')) AND b.order_type = NVL (?, b.order_type) AND NVL (b.priority, 'R') = NVL (?, NVL (b.priority, 'R')) AND NVL (b.source_type, '!') = NVL (?, NVL (b.source_type, '!')) AND SUBSTR (a.order_id, 1, 2) != 'CS' &&ORDFACID## &&PERFACID## &&FILTER## &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";
				//sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(  patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num,  source_type,   source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,  performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,TO_CHAR(b.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time,get_age (d.date_of_birth) age,d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id and c.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000 00:01'),'dd/mm/yyyy hh24:mi') AND TO_DATE (NVL(?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB'  &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num  &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1 AND SYSDATE >= c.start_date_time &&SOURCETYPE## &&PERFACID## AND (b.dispatch_reqd_yn = 'Y' AND b.specimen_dispatch_yn = 'Y') AND (   coll_reqd_yn = 'N' OR (coll_reqd_yn = 'Y' AND specimen_collect_yn = 'Y')) AND coll_label_gen_rule IN ('G', 'X') AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDFACID##  &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//IN031645
				//sql = "SELECT DISTINCT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(  patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num,  source_type,   source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,  performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,TO_CHAR(b.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time,get_age (d.date_of_birth) age,d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id and to_char(c.start_date_time,'dd/mm/yyyy hh24:mi') BETWEEN sm_convert_date_2t(TO_DATE (NVL (?, '01/01/1000 00:01'),'dd/mm/yyyy hh24:mi'),?) AND sm_convert_date_2t(TO_DATE (NVL(?,'31/12/3500 23:59'),'dd/mm/yyyy hh24:mi'),?) AND a.order_category = 'LB'  &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num  &&ENCOUNTERID## &&ORDERID## AND NVL (  source_code, '!')=  nvl (?,NVL (   source_code, '!')) AND a.order_type_code=NVL (?, a.order_type_code) AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) AND b.order_line_num = 1 AND SYSDATE >= c.start_date_time AND source_type = NVL (?, source_type) &&PERFACID## AND (b.dispatch_reqd_yn = 'Y' AND b.specimen_dispatch_yn = 'Y') AND (   coll_reqd_yn = 'N' OR (coll_reqd_yn = 'Y' AND specimen_collect_yn = 'Y')) AND coll_label_gen_rule IN ('G', 'X') AND SUBSTR (a.order_id, 1, 2) != 'CS' &&SPECINO## &&ORDFACID##  &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//[IN031524]
				//[IN030168] End
				sql = "SELECT a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type(a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(  patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_id order_id, a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(select max(accession_num) from or_order_line where order_id=a.order_id and accession_num is not null) accession_num,  source_type,   source_code, a.priority priority,a.order_type_code order_type_code,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner(a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,b.specimen_type specimen_type,b.specimen_collect_yn specimen_collect_yn,b.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (c.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (c.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date(a.source_type,a.source_code,b.specimen_type,b.specimen_collect_yn,a.priority,c.start_date_time,NULL,a.order_type_code,  performing_facility_id,?,c.order_id,c.order_line_num) or_collection_due,TO_CHAR(b.specimen_collect_date_time, 'dd/mm/yyyy hh24:mi' ) specimen_collect_date_time,get_age (d.date_of_birth) age,d.sex sex,DECODE (?,'en', d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) PATIENT_NAME,a.source_type,start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,c.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id  FROM or_order a, or_order_line_lb b, or_order_line c,mp_patient d  WHERE a.patient_id=d.patient_id and c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi') AND TO_DATE (?,'dd/mm/yyyy hh24:mi') AND a.order_category = 'LB'  &&PATIENTID## AND a.order_id = b.order_id  AND a.order_id = c.order_id AND b.order_id = c.order_id  AND b.order_line_num = c.order_line_num  &&ENCOUNTERID## &&ORDERID## &&SOURCECODE## &&ORDERTYPECODE## &&PRIORITY## AND b.order_line_num = 1 AND SYSDATE >= c.start_date_time &&SOURCETYPE## &&PERFACID## AND (b.dispatch_reqd_yn = 'Y' AND b.specimen_dispatch_yn = 'Y') AND (   coll_reqd_yn = 'N' OR (coll_reqd_yn = 'Y' AND specimen_collect_yn = 'Y')) AND coll_label_gen_rule IN ('G', 'X') AND /*SUBSTR (a.order_id, 1, 2) != 'CS'*/ c.order_Catalog_nature !='S' &&SPECINO## &&ORDFACID##  &&ORDPRACTID## ORDER BY a.source_type, location_description, start_date_time_dt DESC";//IN039158
				if(!patientId1.equals(""))
				{
					sql = sql.replace("&&PATIENTID##" , " AND a.patient_id = ? ");
				}
				else
				{
					sql = sql.replace("&&PATIENTID##" , " ");
				}
				
				if(!encounter_id1.equals(""))
				{
					sql = sql.replace("&&ENCOUNTERID##" , " AND encounter_id = ?");
				}
				else
				{
					sql = sql.replace("&&ENCOUNTERID##" , " ");
				}

				if(!ordering_facility.equals(""))
				{
					sql = sql.replace("&&ORDFACID##" , " AND a.ordering_facility_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDFACID##" , " ");
				}			

				if(!performing_facility.equals(""))
				{
					sql = sql.replace("&&PERFACID##" , " AND a.performing_facility_id = ?");
				}
				else
				{
					sql = sql.replace("&&PERFACID##" , " ");
				}

				if(!specimen_no.equals(""))
				{
					sql = sql.replace("&&SPECINO##" , " AND c.accession_num =  ?");
				}
				else
				{
					sql = sql.replace("&&SPECINO##" , " ");
				}

				if(!order_id1.equals(""))
				{
					sql = sql.replace("&&ORDERID##" , " and a.order_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDERID##" , " ");
				}
								// [IN030168] Start
				if(!practitioner_id.equals(""))
				{
					//sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = NVL (?, a.ord_pract_id)");
					sql = sql.replace("&&ORDPRACTID##" , " AND a.ord_pract_id = ? ");
				}
				else
				{
					sql = sql.replace("&&ORDPRACTID##" , " ");
				}
				// [IN030168] End
				//Menaka Starts
				if(!locn1.equals(""))
				{
					//sql = sql.replace("&&SOURCECODE##" , " AND NVL (source_code, '!')=nvl(?,NVL (source_code, '!')) ");
					sql = sql.replace("&&SOURCECODE##" , " AND NVL (source_code, '!')=? ");
				}
				else
				{
					sql = sql.replace("&&SOURCECODE##" , " ");
				}
				if(!order_type1.equals(""))
				{
					//sql = sql.replace("&&ORDERTYPECODE##" , " AND a.order_type_code=NVL (?, a.order_type_code) ");
					sql = sql.replace("&&ORDERTYPECODE##" , " AND a.order_type_code=? ");
				}
				else
				{
					sql = sql.replace("&&ORDERTYPECODE##" , " ");
				}
				if(!priority1.equals(""))
				{
					//sql = sql.replace("&&PRIORITY##" , " AND NVL (a.priority, 'R') = NVL (?, NVL (a.priority, 'R')) ");
					sql = sql.replace("&&PRIORITY##" , " AND NVL (a.priority, 'R') = ? ");
				}
				else
				{
					sql = sql.replace("&&PRIORITY##" , " ");
				}
				if(!location_type.equals(""))
				{
					//sql = sql.replace("&&SOURCETYPE##" , " AND NVL (source_type, '!') = NVL (?, NVL (source_type, '!')) ");
					sql = sql.replace("&&SOURCETYPE##" , " AND NVL (source_type, '!') = ? ");
				}
				else
				{
					sql = sql.replace("&&SOURCETYPE##" , " ");
				}
				//Menaka Ends

			}
			//pstmt = connection.prepareStatement(sql); //IN052230
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_READ_ONLY); //IN052230
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(practitioner_type) ) ; 
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(status));
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(date_from1)) ; 
			//pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(date_to1) ) ; 
			//pstmt.setString( ++cnt , language_id);
			if(!patientId1.equals(""))
			{
				pstmt.setString( ++cnt , checkNull(patientId1) ) ;  
			}

			if(!encounter_id1.equals(""))
			{
				pstmt.setString( ++cnt , checkNull(encounter_id1) ) ; 
			}
			if(!order_id1.equals(""))
			{
				pstmt.setString( ++cnt , checkNull(order_id1) ) ;   
			}
			//pstmt.setString( ++cnt , checkNull(locn1) ) ;
			//pstmt.setString( ++cnt , checkNull(order_type1) ) ;  
			//pstmt.setString( ++cnt , checkNull(priority1) ) ;
			//if(option1.equals("R") || option1.equals("S"))
			if(option1.equals("R") || option1.equals("S")||option1.equals("V"))
			{
				if(!locn1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(locn1) ) ;
				}
				if(!order_type1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(order_type1) ) ; 
				}
				if(!priority1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(priority1) ) ;
				}
			}
			//else
			else if(option1.equals("C")||option1.equals("D")||option1.equals("N"))
			/* IN034716 starts */
			{
				// PER0409 - start
				/*pstmt.setString( ++cnt , checkNull(locn1) ) ;
				pstmt.setString( ++cnt , checkNull(order_type1) ) ; 
				pstmt.setString( ++cnt , checkNull(priority1) ) ;*/
				
				if(!locn1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(locn1) ) ;
				}
				if(!order_type1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(order_type1) ) ; 
				}
				if(!priority1.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(priority1) ) ;
				}
				// PER0409 - end
			}
			//Menaka ends
			
			//System.out.println("SpecimenOrder.java,1314,locn1=>"+locn1+",order_type1=>"+order_type1+",priority1=>"+priority1);
			if (option1.equals("V") || option1.equals("S")) 
			{
				if(!location_type.equals(""))//Menaka
				{
					pstmt.setString( ++cnt , checkNull(location_type)) ;
				}	
				if(!performing_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(performing_facility));
				}

				if(!specimen_no.equals(""))
				{
					pstmt.setString( ++cnt , specimen_no);
				}

				if(!ordering_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(ordering_facility));
				}
			}
			else if(option1.equals("R"))
			{
				//pstmt.setString( ++cnt , checkNull(option1)) ;          
				//pstmt.setString( ++cnt , checkNull(option1)) ;          
				//pstmt.setString( ++cnt , checkNull(option1)) ;          
				if(!location_type.equals(""))//Menaka
				{				
					pstmt.setString( ++cnt , checkNull(location_type)); 
				}	
				if(!ordering_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(ordering_facility)); 
				}

				if(!performing_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(performing_facility)) ; 
				}

				if(!specimen_no.equals(""))
				{
					pstmt.setString( ++cnt , specimen_no);      
				}

			}
			else
		    {
				// PER0409 - start
				if(option1.equals("C")||option1.equals("D")||option1.equals("N"))
				{
					if(!location_type.equals(""))
					{
						pstmt.setString( ++cnt , checkNull(location_type)) ;//PERF
					}
				}
				else{
					pstmt.setString( ++cnt , checkNull(location_type)) ;
				}
				//// PER0409 - end
				if(!ordering_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(ordering_facility));
				}

				if(!performing_facility.equals(""))
				{
					pstmt.setString( ++cnt , checkNull(performing_facility));
				}

				if(!(option1.equals("N")))
				{
					if(!specimen_no.equals(""))
					{
						pstmt.setString( ++cnt , specimen_no); 
					}
				}
			}
			// [IN030168] Start
			if(!practitioner_id.equals(""))
				{	
					pstmt.setString( ++cnt , checkNull(practitioner_id)); 
				}
			// [IN030168] End
			
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet!=null) 
			{
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				// IN052230 - Start
			//if (option1.equals("S") && (multiSelect != null && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST"))) - commented for IN055737 HSA-CRF-0250.1
			if (option1.equals("S") && (multiSelect != null && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST")) && isBarCodeSearchEnabled.equalsIgnoreCase("N")) {
				while(resultSet.next()){
					StringBuilder rdsBuilder = new StringBuilder(); // IN055673
					String rdsString = ""; // IN055673
					if(resultSet.getString( "accession_num" ) != null && !dispatchMap.containsKey(resultSet.getString( "accession_num" )) ) {
						rdsBuilder.append(resultSet.getString( "PATIENT_ID" )+"~"+resultSet.getString( "ORDER_ID" )); // IN055673
						rdsString = rdsBuilder.toString();
						addPatientDispSlipSelected(resultSet.getString( "accession_num" ),rdsString);
					}
				}
				resultSet.beforeFirst();
			} else if(option1.equals("S") && (multiSelect != null && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST")) && isBarCodeSearchEnabled.equalsIgnoreCase("Y")) { //added for IN055737 HSA-CRF-0250.1 - Start
				while(resultSet.next()){
					StringBuilder rdsBuilder = new StringBuilder(); 
					String rdsString = "";
					
					if(resultSet.getString( "accession_num" ) != null && !clonedDispatchMap.containsKey(resultSet.getString( "accession_num" )) ) {	
						rdsBuilder.append(resultSet.getString( "PATIENT_ID" )+"~"+resultSet.getString( "ORDER_ID" )); 
						rdsString = rdsBuilder.toString();
						addClonedPatientDispSlipRecords(resultSet.getString( "accession_num" ),rdsString);
					}	
				}
				resultSet.beforeFirst();
			} else {
				resultSet.beforeFirst();
			}
			// IN052230 - End	
			//added for IN055737 HSA-CRF-0250.1 - End
			if(start > 0)
				for(int i=0;(i<start-1 && resultSet.next());i++);

			while(start <= end && resultSet != null && resultSet.next() ) 
			{
					
				ArrayList ResultOrderCat	= new ArrayList() ;
	/*1*/		ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
	/*2*/		ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
	/*3*/		ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
	/*4*/		ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
	/*5*/		ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
	/*6*/		ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ));
	/*7*/		ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS" ))  ;
	/*8*/		ResultOrderCat.add(resultSet.getString( "location_description" ))  ;
	/*9*/		ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
	/*10*/		ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
	/*11*/		ResultOrderCat.add(resultSet.getString( "ENCOUNTER_ID" ))  ;
	/*12*/		ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME" ))  ;
	/*13*/		ResultOrderCat.add(resultSet.getString( "catalog_desc" ))  ;
	/*14*/		ResultOrderCat.add(checkForNull(resultSet.getString( "age" )))  ;
	/*15*/		ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
	/*16*/		ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
	/*17*/		ResultOrderCat.add(resultSet.getString( "PRIORITY" ))  ;
	/*18*/		ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
	/*19*/		ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
	/*20*/		ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
	/*21*/		ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
	/*22*/		ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC" ))  ;
	/*23*/		ResultOrderCat.add(resultSet.getString( "ORD_COSIGN_REQD_YN" ))  ;
	/*24*/		ResultOrderCat.add(resultSet.getString( "COLL_LABEL_GEN_RULE" ))  ;
	/*25*/		ResultOrderCat.add(resultSet.getString( "specimen_type" ))  ;
	/*26*/		ResultOrderCat.add(resultSet.getString( "specimen_collect_yn" ))  ;
	/*27*/		ResultOrderCat.add(checkForNull(resultSet.getString( "sex" )))  ;
	/*28*/		ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS" ))  ;
	/*29*/		ResultOrderCat.add(resultSet.getString( "start_date_time" ))  ;
	/*30*/		ResultOrderCat.add(resultSet.getString( "end_date_time" ))  ;
	/*31*/		ResultOrderCat.add(resultSet.getString( "or_collection_due" ))  ;
	/*32*/		ResultOrderCat.add(resultSet.getString( "accession_num" ))  ;
	/*33*/		ResultOrderCat.add(resultSet.getString( "PATIENT_NAME" ))  ;
	/*33*/		ResultOrderCat.add(resultSet.getString( "cont_order_ind" ))  ;
	/*33*/		ResultOrderCat.add(resultSet.getString( "performing_facility_id" ))  ;
	/*33*/		ResultOrderCat.add(resultSet.getString( "order_catalog_code" ))  ;
				ResultOrderCat.add(resultSet.getString( "ordering_facility_id" ))  ;//IN039158

				if (option1.equals("D")) 
				{
	/*34*/			ResultOrderCat.add(resultSet.getString( "specimen_collect_date_time" ))  ;	
				}
	
				//ResultOrderCat.add( (String.valueOf(total_records)) );
				
				ResultOrderCatFinal.add(ResultOrderCat);
				start++;
				}
				if (resultSet.next())
				{
					ArrayList templist = (ArrayList)ResultOrderCatFinal.get(0);
					templist.add(""+(end+7));
					ResultOrderCatFinal.set(0,templist);
				}
			}
			
		}
		catch( Exception e )	
		{
				System.err.println( "Error loading values from database SEARCH" ) ;
				e.printStackTrace() ;
				throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return ResultOrderCatFinal;
	}


/*  Get the cont_order_ind  ,order_catalog_code & performing_facility_id
 */
    public ArrayList getSpecimenDetails(String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList SpecimenDetails	= new ArrayList() ;
		try 
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_SELECT_OTH_DTLS") ) ;
				pstmt.setString( 1, checkNull(order_id) );

				resultSet = pstmt.executeQuery() ;
				if( resultSet != null && resultSet.next() ) 
				{ // Only One record
					SpecimenDetails.add(resultSet.getString( "CONT_ORDER_IND" ))  ;
					SpecimenDetails.add(resultSet.getString( "PERFORMING_FACILITY_ID" ))  ;
					SpecimenDetails.add(resultSet.getString( "ORDER_CATALOG_CODE" ))  ;
				}
			} 
			catch( Exception e )	
			{
				System.err.println( "Error loading values from database getSpecimenDetails" ) ;
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return SpecimenDetails;
	}
/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) 
	{
	/* Thai date validations start 15/02/2007 */
	updatePerfFacility = (String)recordSet.get("performing_facility");
	
	if (!language_id.equals("en"))
	{
		//if(updatePerfFacility.equals("")) //Commented for --[IN035028]
	//	{
		//--[IN035028] - Start
		if(recordSet.containsKey("date_from") ) 	
		{
			String date_from = (String)recordSet.get("date_from");
			if (date_from == null || date_from.equals(" ") || date_from.equals("null")) date_from="";
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMYHM",language_id,"en");
			recordSet.put("date_from",date_from);	
		}
		
		if(recordSet.containsKey("date_to") ) 
		{
			String date_to = (String)recordSet.get("date_to");	
			if (date_to == null || date_to.equals(" ") || date_to.equals("null")) date_to="";
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMYHM",language_id,"en");
			recordSet.put("date_to",date_to);
		}
		
		if(recordSet.containsKey("specimen_hdr_date_time")) 
		{
			String specimen_hdr_date_time = (String)recordSet.get("specimen_hdr_date_time");
			if (specimen_hdr_date_time == null || specimen_hdr_date_time.equals(" ") || specimen_hdr_date_time.equals("null")) specimen_hdr_date_time="";
			specimen_hdr_date_time = com.ehis.util.DateUtils.convertDate(specimen_hdr_date_time,"DMYHM",language_id,"en");
			recordSet.put("specimen_hdr_date_time",specimen_hdr_date_time);
		}
		
		if(recordSet.containsKey("curr_sys_date")) 
		{
			String curr_sys_date = (String)recordSet.get("curr_sys_date");
			if (curr_sys_date == null || curr_sys_date.equals(" ") || curr_sys_date.equals("null")) curr_sys_date="";
			curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM",language_id,"en");
			recordSet.put("curr_sys_date",curr_sys_date);
		}
		
		if(recordSet.containsKey("specimen_new_list_date_time") )
		{
			String specimen_new_list_date_time = (String)recordSet.get("specimen_new_list_date_time");
			if (specimen_new_list_date_time == null || specimen_new_list_date_time.equals(" ") || specimen_new_list_date_time.equals("null")) specimen_new_list_date_time="";
			specimen_new_list_date_time = com.ehis.util.DateUtils.convertDate(specimen_new_list_date_time,"DMYHM",language_id,"en");
			recordSet.put("specimen_new_list_date_time",specimen_new_list_date_time);
		}
		
		if(recordSet.containsKey("total_recs")) 
		{
			int total_recs=Integer.parseInt((String)recordSet.get("total_recs"));		

			String specimen_date_time = "";
			String order_date_time = "";
			//String specimen_collect_date_time = "";		 	
		
			for(int i=0;i<total_recs;i++)
				{
					specimen_date_time = (String)recordSet.get("specimen_date_time"+i);
					/*validation to remove ~ from the specimen_date_time in order to use convertDate() on this variable  start*/
					if(specimen_date_time.startsWith("~"))
					{
						int length = specimen_date_time.length();
						specimen_date_time = specimen_date_time.substring(1,length);
						specimen_date_time = com.ehis.util.DateUtils.convertDate(specimen_date_time,"DMYHM",language_id,"en");
						specimen_date_time = "~"+specimen_date_time;
					}
					else
					{
						if (specimen_date_time.equals(" ") || specimen_date_time.equals("null")) specimen_date_time="";
						specimen_date_time = com.ehis.util.DateUtils.convertDate(specimen_date_time,"DMYHM",language_id,"en");			
					}
				/*validation to remove ~ from the specimen_date_time in order to use convertDate() on this variable  start*/
				order_date_time = (String)recordSet.get("order_date_time"+i);
				//specimen_collect_date_time = (String)recordSet.get("specimen_collect_date_time"+i); 
				
			
				if (order_date_time.equals(" ") || order_date_time.equals("null")) order_date_time="";
				//	if (specimen_collect_date_time.equals(" ") || specimen_collect_date_time.equals("null")) specimen_collect_date_time=""; 
					
					
				order_date_time = com.ehis.util.DateUtils.convertDate(order_date_time,"DMYHM",language_id,"en");
			//		specimen_collect_date_time = com.ehis.util.DateUtils.convertDate(specimen_collect_date_time,"DMYHM",language_id,"en");
				recordSet.put("specimen_date_time"+i,specimen_date_time);
				recordSet.put("order_date_time"+i,order_date_time);
				//	recordSet.put("specimen_collect_date_time"+i,specimen_collect_date_time);
			
				}
		}	//--[IN035028] - End
		//}
	}

	 /*Thai date validations end 15/02/2007*/
		
	 if(recordSet.containsKey("performing_location"))
	 updatePerfLocn = (String)recordSet.get("performing_location");
	 else
	 updatePerfLocn = "";
		allValues = recordSet;

		this.mode = (String)recordSet.get( "mode" );
		if(recordSet.containsKey("total_recs"))
		{
			setTotalRecs((String)recordSet.get("total_recs"));
		}

		if(recordSet.containsKey("option_list"))
		{
			setOptionList((String)recordSet.get("option_list"));
		}
	/*	if(recordSet.containsKey("specimen_hdr_date_time")){
					setSpecimenDateTime((String)recordSet.get("specimen_hdr_date_time"));
		}*/
		if(recordSet.containsKey("specimen_hdr_collected_by"))
		{
			setSpecimen_hdr_collected_by((String)recordSet.get("specimen_hdr_collected_by"));
		}

		if(recordSet.containsKey("specimen_hdr_specimen_remarks"))
		{
			setSpecimen_hdr_specimen_remarks((String)recordSet.get("specimen_hdr_specimen_remarks"));
		}

		if(recordSet.containsKey("specimen_hdr_dispatch_mode"))
		{
			setSpecimen_hdr_dispatch_mode((String)recordSet.get("specimen_hdr_dispatch_mode"));
		}
		if(recordSet.containsKey("lb_module"))
		{
			setLbInstall((String)recordSet.get("lb_module"));
		}
		if(recordSet.containsKey("order_category"))
		{
			setOrderCategory((String)recordSet.get("order_category"));
		}
		if(recordSet.containsKey("session_id"))
		{
			setSessionId((String)recordSet.get("session_id"));
		}
		if(recordSet.containsKey("curr_sys_date"))
		{
			setCurrentDate((String)recordSet.get("curr_sys_date"));
		}
//
		if(recordSet.containsKey("specimen_date"))
		{		
			setSpecimenDate((String)recordSet.get("specimen_date"));	
		}

		if(recordSet.containsKey("total_recs"))
		{		
			setTotalRecs((String)recordSet.get("total_recs"));	
		}

		if(recordSet.containsKey("order_type"))
		{		
			setOrderType((String)recordSet.get("order_type"));	
		}
//		if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
		if(recordSet.containsKey("location_type"))
		{ 	
			setLocationType((String)recordSet.get("location_type"));
		}

		if(recordSet.containsKey("locn"))
		{				
			setLocationType((String)recordSet.get("locn"));	
		}
//		if(recordSet.containsKey("patientId")){		setPatientId((String)recordSet.get("patientId"));}
		if(recordSet.containsKey("encntr_id")){  		setEncntrId((String)recordSet.get("encntr_id"));}
		if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
//		if(recordSet.containsKey("date_from")){		setDateFrom((String)recordSet.get("date_from"));}
//		if(recordSet.containsKey("date_to")){			setDateTo((String)recordSet.get("date_to"));}
//			if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}
		if(recordSet.containsKey("auto_collect")){			setAuto_collect((String)recordSet.get("auto_collect"));}
		if(recordSet.containsKey("collection_list")){setP_collection_list(checkForNull((String)recordSet.get("collection_list")));};
		if(recordSet.containsKey("print_locn_type")){setP_printLocationType(checkForNull((String)recordSet.get("print_locn_type")));};
		if(recordSet.containsKey("print_locn")) 	{setP_printLocation(checkForNull((String)recordSet.get("print_locn")));};
		if(recordSet.containsKey("date_from")) 	{setP_date_from(checkForNull((String)recordSet.get("date_from")));};
		if(recordSet.containsKey("date_to")) 	{setP_date_to(checkForNull((String)recordSet.get("date_to")));};
		if(recordSet.containsKey("priority")) 	{setP_priority(checkForNull((String)recordSet.get("priority")));};
		if(recordSet.containsKey("location_type")) 	{setP_location_type(checkForNull((String)recordSet.get("location_type")));};
		if(recordSet.containsKey("locn")) 	{setP_locn(checkForNull((String)recordSet.get("locn")));};
		if(recordSet.containsKey("locn1")) 	{setP_locn1(checkForNull((String)recordSet.get("locn1")));};
		if(recordSet.containsKey("order_type")) 	{setP_order_type(checkForNull((String)recordSet.get("order_type")));};
		if(recordSet.containsKey("order_type1")) 	{setP_order_type1(checkForNull((String)recordSet.get("order_type1")));};
		if(recordSet.containsKey("option")) 	{setP_option(checkForNull((String)recordSet.get("option")));};
		if(recordSet.containsKey("select_specific_order")) 	{setP_select_specific_order(checkForNull((String)recordSet.get("select_specific_order")));};
		if(recordSet.containsKey("patientId")) 	{setP_patientId(checkForNull((String)recordSet.get("patientId")));};
		if(recordSet.containsKey("order_id")) 	{setP_order_id(checkForNull((String)recordSet.get("order_id")));};
		if(recordSet.containsKey("encounter_id")) 	{setP_encounter_id(checkForNull((String)recordSet.get("encounter_id")));};

		if(recordSet.containsKey("specimen_new_list_collected_by")){
					setSpecimen_new_list_collected_by((String)recordSet.get("specimen_new_list_collected_by"));
		}
		if(recordSet.containsKey("specimen_new_list_specimen_remarks")){
					setSpecimen_new_list_specimen_remarks((String)recordSet.get("specimen_new_list_specimen_remarks"));
		}
		if(recordSet.containsKey("specimen_new_list_seq_no")){
					setSpecimen_new_list_seq_no((String)recordSet.get("specimen_new_list_seq_no"));
		}
		if(recordSet.containsKey("specimen_new_list_date_time")){
					setSpecimen_new_list_date_time((String)recordSet.get("specimen_new_list_date_time"));
		}
		//added for IN035837[CRF 320] - Start
		if(recordSet.containsKey("old_start_date_time")){
					setStartDate((String)recordSet.get("old_start_date_time"));
		}
		// IN035837[CRF 320] - End
		//IN049737 - Start
		if(recordSet.containsKey("called_from")) 	
		{
			setCalled_from(checkForNull((String)recordSet.get("called_from")));
		}
		if(recordSet.containsKey("order_details")) 	
		{
			setOrder_details(checkForNull((String)recordSet.get("order_details")));
		}
		//IN049737 - End
		//this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;		//[IN032796]//IN065324, check style issue
		//this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;		//[IN032796], check style issue



	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/


	public HashMap insert()
	{
		StringBuffer tracer =  new StringBuffer();
		tracer.append("SpecimenOrder.java,1518");
		StringBuffer tmpBuff	= new StringBuffer();

		java.util.Properties  properties = getProperties();
		user_id				= properties.getProperty( "ecis_jdbc_user" ) ;
		user_password		= properties.getProperty( "ecis_jdbc_password" ) ;
		String jdbc_dns 	= properties.getProperty( "ecis_jdbc_dns" );
		String database_name= "";
		if(jdbc_dns!=null)
			database_name	= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap() ;
		//IN049737 - Start	
		HashMap setBills_dtls = new HashMap();
		String l_specimen_date_time = ""; //MMS-MD-SCF-0017 [IN060516]
		String l_order_date_time = ""; //MMS-MD-SCF-0017 [IN060516]
		try
		{
			//String order_line_num = ""; //Checkstyle
			//String order_catalog_code = ""; //Checkstyle
			String which_page = "";
			//String linerecord=""; //Checkstyle
			//String catalogcode=""; //Checkstyle
			//String patientid=""; //Checkstyle
			//String encounterid=""; //Checkstyle
			//String orderid=""; //Checkstyle
			//String temp_order_id = ""; //Checkstyle
			//String billinginterface=""; //Checkstyle
			String servicepanel="";
			String incl_action="";
			//String incl_action_reason=""; //Checkstyle
			String servicepanelcode="";
			String reRoutePrinterId = "";//IN064835
			int cnt = 0;
			
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			PreparedStatement pstmt1 	= null;
			ResultSet resultSet 			= null;
			
			HashMap updt_map1 = new HashMap();
			HashMap order_detail	 = new HashMap() ;
			TreeMap NewFutureOrders    = new TreeMap();
			ArrayList UnBillOrders = new ArrayList();	
			String[] billing_details =new String[21];
			//IN064835 starts
			if(allValues.contains(reRoutePrinterId))
			{
				reRoutePrinterId = (String)allValues.get("reRoutePrinterId");
			}
			//IN064835 ends
			if(allValues.contains(called_from) && ((String)allValues.get("called_from")).equalsIgnoreCase("unbilled_order_split"))
			{
				StringTokenizer dtls = new StringTokenizer(((String)allValues.get("order_details")),"!");
				while(dtls.hasMoreTokens())
				{
					String str2 = dtls.nextToken();	
					StringTokenizer str3 = new StringTokenizer(str2,"^");
					while(str3.hasMoreTokens())
					{
						String[] record = new String[3];
						record[0] = str3.nextToken();	
						order_id = record[0];
						record[1] = str3.nextToken();
						record[2] = str3.nextToken();
						UnBillOrders.add(record);
					}
				}
			ArrayList UnBillOrderDetail = new ArrayList();	
			ArrayList BillChargeInfo    = new ArrayList();
			
			UnBillOrderDetail = getUnBilledOrderDetails( updatePerfFacility,p_patientId,called_from,order_id,p_encounter_id) ;

			try 
			{
				connection = getConnection() ;
				try
				{	
					sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_LINE_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_LINE_UPDATE") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_STATUS") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_REG_COMPLETE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_REG_COMPLETE") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_SELECT",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_SELECT") );
					sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
					sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE") );
					sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_NEW_ORDER",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_NEW_ORDER") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_CANCEL_LINE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_CANCEL_LINE") );
					sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
					sqlMap.put("SQL_OR_ORDER_GET_STATUS_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE") );
					sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS") );
				}
					catch(Exception e)
					{
						e.printStackTrace();
						map.put( "message", e.getMessage() ) ;
					}
					int no_of_occurance =  UnBillOrderDetail.size() ;
					//int int_total_records = no_of_occurance; //Checkstyle
					String p_episode_visit_num = "";
					String p_source_code = "";
					String p_source_type = "";
					String p_episode_id = "";
					String p_patient_class = "";
					
					for(int i=0; i<UnBillOrderDetail.size(); i++)
					{
						String[] UnBillOrdDtl = (String[]) UnBillOrderDetail.get(i);
						for(int j=0;j<UnBillOrders.size();j++)
						{
							String[] UnBillOrds = (String[]) UnBillOrders.get(j);
							if(UnBillOrdDtl[5].equals(UnBillOrds[1]))
							{
								if(!order_detail.containsKey((((String)UnBillOrdDtl[25])+(String)UnBillOrdDtl[5])))
								{
									BillChargeInfo		= getBillChargeDetails(UnBillOrdDtl[28],UnBillOrdDtl[27],UnBillOrdDtl[30], language_id,"", "",p_patientId,p_encounter_id,UnBillOrdDtl[4],UnBillOrdDtl[16]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
									
									if(BillChargeInfo!=null)
									{
									
										for( int kb=0 ; kb< BillChargeInfo.size() ; kb++ ) 
										{
											billing_details 	= (String[])BillChargeInfo.get(kb);
										
											setBills_dtls		= new HashMap();
					
											setBills_dtls.put("charged_yn"       , billing_details[1]);
											setBills_dtls.put("total_payable"    , billing_details[2]);
											setBills_dtls.put("patient_payable"  , billing_details[3]);
											setBills_dtls.put("quantity"         , UnBillOrdDtl[28]);
											setBills_dtls.put("incl_excl_action" , billing_details[4]);
											setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
											setBills_dtls.put("preapp_yn"        , billing_details[5]);
											setBills_dtls.put("patient_paid_amt" , billing_details[6]);
											setBills_dtls.put("bl_panel_str"     , billing_details[0]);
											setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
											setBills_dtls.put("serv_panel_code"  , billing_details[11]);
											setBills_dtls.put("p_episode_type"	 , billing_details[13]);
											setBills_dtls.put("p_episode_id"	 , billing_details[14]);
											setBills_dtls.put("p_visit_id"		 , billing_details[15]);
											setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
											setBills_dtls.put("error_text"		 , billing_details[9]);
											setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
											setBills_dtls.put("rate"		 ,"");
											servicepanel=checkForNull(billing_details[10],"");
											servicepanelcode=checkForNull(billing_details[11],"");
											incl_action=checkForNull(billing_details[16],"");
											if("".equals(p_episode_visit_num))
												p_episode_visit_num = billing_details[15];
											if("".equals(p_episode_id))
												p_episode_id = billing_details[14];
												
										}
									}
									order_detail = new HashMap();
									order_detail.put("order_id",(String)UnBillOrdDtl[25]);		
									order_detail.put("order_id"+order_id,no_of_occurance);		
									order_detail.put("billing_revise_dtls"+order_id+(String)UnBillOrdDtl[5],setBills_dtls);
									order_detail.put("servicepanelind",(String)allValues.get("servicepanelind"+i));
									order_detail.put("servicepanelcode",(String)allValues.get("servicepanelcode"+i));
									order_detail.put("incl_excl_action",(String)allValues.get("incl_excl_action"+i));
									order_detail.put("incl_excl_action_reason",(String)allValues.get("incl_excl_action_reason"+i));
									order_detail.put("bill_yn",(String)UnBillOrdDtl[26]);					   
									order_detail.put("contr_mod_id",(String)UnBillOrdDtl[29]);					   
									order_detail.put("order_line_num",(String)UnBillOrdDtl[5]);			   
									order_detail.put("catalog_code",(String)UnBillOrdDtl[27]);			   
									order_detail.put("catalog_desc",(String)allValues.get("catalog_desc"+i));			   
									order_detail.put("ord_pract_id",(String)UnBillOrdDtl[16]);					   
									order_detail.put("quantity",(String)UnBillOrdDtl[28]);					   
									order_detail.put("start_date_time",(String)UnBillOrdDtl[30]);				   
									order_detail.put("order_line_num"+order_id,UnBillOrdDtl[5]);		
									order_detail.put("billing_package_ref",UnBillOrdDtl[32]);	
									NewFutureOrders.put((order_id+(String)UnBillOrdDtl[5]),order_detail);
									if("".equals(p_patient_class))
										p_patient_class = UnBillOrdDtl[4];
									if("".equals(p_source_type))
										p_source_type = UnBillOrdDtl[11];
									if("".equals(p_source_code))
										p_source_code = UnBillOrdDtl[12];
									cnt++;
								}
							}
						}
					}
					updt_map1.put("source","unbilled_order_split");
					updt_map1.put( "totalCount"		  , ""+cnt);
					updt_map1.put( "locale"		  , ""+language_id);
					updt_map1.put("future_value",NewFutureOrders);
					updt_map1.put("which_page",which_page);
					updt_map1.put( "login_by_id",login_by_id ) ;
					updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
					updt_map1.put( "login_facility_id",login_facility_id ) ;
					updt_map1.put( "p_patient_class",p_patient_class) ;
					updt_map1.put( "p_patient_id",p_patientId) ;
					updt_map1.put( "p_episode_id",p_episode_id) ;
					updt_map1.put( "p_episode_visit_num",p_episode_visit_num) ;
					updt_map1.put( "p_source_type",p_source_type) ;
					updt_map1.put( "p_source_code",p_source_code) ;
					updt_map1.put( "p_encounter_id",p_encounter_id) ;
					updt_map1.put( "re_route_printer_id",reRoutePrinterId) ;//IN064835

					updt_map1.put( "isBTViewBillDtls",String.valueOf(isSiteSpecific("BT_VIEW_BILL_DTLS")));//IN065324


					
					try 
					{
						updt_map1.put( "properties", getProperties() );
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[]	= new Object[2];
							argArray[0]		= updt_map1;
							argArray[1]		= sqlMap;
						Class [] paramArray = new Class[2];
							paramArray[0]	= updt_map1.getClass();
							paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
						argArray	= null;
						paramArray	= null;
						if(((Boolean) map.get( "result" )).booleanValue())
						{
							map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
						}
						else
						{
							map.put( "message",  (String) map.get( "message" )) ;
						}
						map.put("traceVal", (String)tmpBuff.toString());
						tmpBuff.setLength(0);

					} 
					catch(Exception e) 
					{
						map.put( "message", e.getMessage() ) ;
						e.printStackTrace() ;
					} 
					finally 
					{
						clear();			
					}
				} 
				catch ( Exception e )	
				{
					e.printStackTrace() ;
					throw e ;
				} 
				finally 
				{
					closeStatement( pstmt ) ;
					closeStatement( pstmt1) ;
					closeResultSet( resultSet ) ;
					closeConnection(connection);
				}
				return map;
			}//IN049737 - End else contains the original flow
			else
		{
		int total = Integer.parseInt(total_records);
		int count = 0 ;
		java.util.Date p_specimen_date_time = null; //MMS-MD-SCF-0017 [IN060516] 
		java.util.Date p_order_date_time = null; //MMS-MD-SCF-0017 [IN060516] 
			String[] neonate_mother_dtl= null;
			 
			String option = checkForNull( ((String)allValues.get("option"))); //MMS-MD-SCF-0017 [IN060516]
			for(int i=0; i<total; i++)
			{
				if(((String)allValues.get("select"+i)).equalsIgnoreCase("Y")){
				//String[] updt_dtl	 = new String[23];changed on 7/16/2007 for lb_module by uma 
				//String[] updt_dtl	 = new String[24]; //commented for IN035837[CRF 320]
				//String[] updt_dtl	 = new String[25]; //modified for IN035837[CRF 320]
				String[] updt_dtl	 = new String[26]; 
				updt_dtl[0] = checkForNull( ((String)allValues.get("order_id"+i)));
				if ((checkForNull( ((String)allValues.get("source_type"+i)),"!")).equalsIgnoreCase("N")) 
				{
				  //  updt_dtl[1] = "W";
					updt_dtl[1] = "N";
				} else 
				{
				    updt_dtl[1] = checkForNull( ((String)allValues.get("source_type"+i)),"!");
				}
				updt_dtl[2] = checkForNull( ((String)allValues.get("source_code"+i)),"!!!!");
				updt_dtl[3] = checkForNull( ((String)allValues.get("specimen_type"+i)),"");
				updt_dtl[4] = checkForNull( ((String)allValues.get("order_date_time"+i)));
				updt_dtl[5] = checkForNull( ((String)allValues.get("priority"+i)));
				updt_dtl[6] = checkForNull( ((String)allValues.get("coll_label_gen_rule"+i)));
				updt_dtl[7] = checkForNull( ((String)allValues.get("order_type_code"+i)));
				updt_dtl[8] = checkForNull( ((String)allValues.get("specimen_collect_yn"+i)));

				//if(!specimen_hdr_date_time.equals(""))
				//	updt_dtl[9] = specimen_hdr_date_time;
				//else
				if(!specimen_new_list_date_time.equals(""))
				{
					updt_dtl[9] = checkForNull(specimen_new_list_date_time);
				}
				else
				{
					updt_dtl[9] = checkForNull( ((String)allValues.get("specimen_date_time"+i)));
				}
			
				updt_dtl[10] = checkForNull( ((String)allValues.get("order_category"+i)));
				updt_dtl[11] = checkForNull( ((String)allValues.get("patient_class"+i)));
				updt_dtl[12] = checkForNull( ((String)allValues.get("cont_order_ind"+i)));
				updt_dtl[13] = checkForNull( ((String)allValues.get("order_catalog_code"+i)));
				updt_dtl[14] = checkForNull( ((String)allValues.get("performing_facility_id"+i)));
			
				if(!specimen_new_list_date_time.equals(""))
				{
					updt_dtl[15]=checkForNull(specimen_new_list_seq_no);
				}
				else
				{
					updt_dtl[15] = checkForNull( ((String)allValues.get("seq_no"+i)));
				}
				//if(!specimen_hdr_date_time.equals(""))
				//	updt_dtl[16] = specimen_hdr_collected_by;
				//else
				if(!specimen_new_list_date_time.equals(""))
				{
					updt_dtl[16] = checkForNull(specimen_new_list_collected_by);
				}
				else
				{
					updt_dtl[16] = checkForNull( ((String)allValues.get("collected_by"+i)));
				}
				//if(!specimen_hdr_date_time.equals(""))
				//	updt_dtl[17] = specimen_hdr_specimen_remarks;
				//else
				////////
				//MMS-MD-SCF-0017 [IN060516] - Start
				if("N".equals(option)) {
					try {
						l_specimen_date_time = updt_dtl[9];
						l_order_date_time = updt_dtl[4];
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						p_specimen_date_time = sdf.parse(l_specimen_date_time);
						p_order_date_time = sdf.parse(l_order_date_time);
						if (p_specimen_date_time.before(p_order_date_time)){
							String strMessage		=	 "SPECIMEN_COLLECTION_ORDER_DATE_WARN";
							map.put( "message", strMessage) ;
							strMessage = getMessage(language_id, (String) map.get( "message" ), "OR");
							strMessage = strMessage.replace("$$", updt_dtl[0]);
							map.put( "message", strMessage) ;
					        return map;
						}
					} catch (Exception e) {
			            e.printStackTrace();
					}
				}
				//MMS-MD-SCF-0017 [IN060516] - End
				if(!specimen_new_list_date_time.equals(""))
				{
					try
					{
							updt_dtl[17] = java.net.URLDecoder.decode(checkForNull(((String)specimen_new_list_specimen_remarks)),"UTF-8");
					}
					catch(Exception e)
					{
						System.out.println("Error in getting specimen remarks detail from new list:"+e.toString());
						e.printStackTrace();
					}
				}
				else
				{
					try
					{
					
						updt_dtl[17] = java.net.URLDecoder.decode(checkForNull( ((String)allValues.get("specimen_remarks"+i))),"UTF-8");

					}
					catch(Exception e)
					{
						System.out.println("Error in getting the specimen remarks detail:"+e.toString());
						e.printStackTrace();
					}
				}
				//if(!specimen_hdr_date_time.equals(""))
				//	updt_dtl[18] = specimen_hdr_dispatch_mode;
				//else
				  updt_dtl[18] = checkForNull( ((String)allValues.get("dispatch_mode"+i)));
				  updt_dtl[19] = checkForNull( ((String)allValues.get("interval_test_yn"+i)));
			
				try
				{	
					neonate_mother_dtl= getNeonateMotherPatient(updt_dtl[0],updt_dtl[7]);// order_id and order_type_code
					updt_dtl[20] = checkForNull( neonate_mother_dtl[0]);//mother_patient_id
 					updt_dtl[21] = checkForNull( neonate_mother_dtl[1]);//mother_patient_name
				
				}catch(Exception e)
				{
					System.out.println("Error in getting the nenonate mother detail:"+e.toString());
					e.printStackTrace();
				}

				updt_dtl[22] = checkForNull( ((String)allValues.get("ordering_facility_id"+i)));

				if(updt_dtl[22] == null || updt_dtl[22].equals("null"))
					updt_dtl[22] = updt_dtl[14];  // when ordering facility is null performing facilty is assigned to it.
				updt_dtl[23] = checkForNull( ((String)allValues.get("lab_chking"+i)));//added on 7/16/2007 for lb_module value to ejb 
				updt_dtl[24] = checkForNull( ((String)allValues.get("old_start_date_time"+i)));// added for IN035837[CRF 320]	
				updt_dtl[25] = checkForNull( ((String)allValues.get("specimen_no"+i)));
				tabData.put("data"+count ,updt_dtl);
				count++;
			  }//end of if condition
			}//end of for loop

		tabData.put( "count" ,String.valueOf(count));
		tabData.put( "properties", getProperties() );
		tabData.put( "user_id",user_id ) ;
		tabData.put( "user_password",user_password ) ;
		tabData.put( "database_name",database_name ) ;

		tabData.put( "login_by_id",login_by_id ) ;
		tabData.put( "login_at_ws_no",login_at_ws_no ) ;
		tabData.put( "login_facility_id",login_facility_id ) ;
		tabData.put( "option_list",option_list ) ;
		tabData.put( "curr_sys_date",curr_sys_date ) ;
		tabData.put("auto_collect",auto_collect);
		tabData.put( "lb_module",lb_module ) ;
		tabData.put( "session_id",session_id ) ;
		tabData.put( "re_route_printer_id",reRoutePrinterId ) ;//IN064835
		tabData.put( "barcode_remarks",getManualBarcodeRemarks() ) ;//Added for IN072184
		System.err.println("@@@insert method==="+getManualBarcodeRemarks());

		//Start

		//End

		//ORSpecimenOrderHome  home 		= null;
	    //ORSpecimenOrderRemote remote 	= null;
		try 
		{
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST_DATE",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST_DATE"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE"));
            sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_DATE", OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_DATE"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS"));
			sqlMap.put("SQL_OR_SPECIMEN_UPDATE_SPECIMEN_NO",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_UPDATE_SPECIMEN_NO"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_DTLS",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_DTLS"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_ACCESSION_NUM_SELECT",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_ACCESSION_NUM_SELECT"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER_LINE"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_NEW_LIST_AUTO_COLLECT_NO",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_NEW_LIST_AUTO_COLLECT_NO"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_RECORD_COLLECTION",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_RECORD_COLLECTION"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_RL_NEONATES_UPD_COLLECTION",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_RL_NEONATES_UPD_COLLECTION"));
			sqlMap.put("SQL_OR_CHECK_MODULE_INSTALL_YN",OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_RL_NEONATES",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RL_NEONATES"));
			
			
 			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( 					OrRepository.getOrKeyValue("OR_SPECIMEN_ORDER_JNDI") ) ;
				home  = (ORSpecimenOrderHome) PortableRemoteObject.narrow( object, ORSpecimenOrderHome.class ) ;
				remote = home.create() ;
				
				map = remote.insert( tabData, sqlMap ) ;	*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_SPECIMEN_ORDER_JNDI"), ORSpecimenOrderHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				
				//map.put("message",(String)map.get( "message"));
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

				stored_values = (Hashtable) map.get("stored_values");
				boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
				// Call the Print Routing
				if(result && stored_values!=null)
				{
					if(stored_values.size() > 0)
					{

                        stored_values.put("facility_id",login_facility_id);
					/*	OnLinePrinting online_print = new OnLinePrinting(request,response);
				
						online_print.callSpecimenOnLinePrint(stored_values); // Pass the Hash Table*/
					}
				}
				//[IN032796] Start
				int count_records = map.get("count_records")== null ? 0 :(Integer)map.get("count_records");				
				if(count_records>0){				
					//IN046592 Start.
					/*for(int cr=0;cr<count_records;cr++){
						String report_exec_ind =(String) map.get("report_exec_ind"+cr);	 
						if(result && ("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))){
							OnLinePrinting online_print = new OnLinePrinting();
							Hashtable ht = new Hashtable();
							ht.put("order_id",(String) map.get("order_id_"+cr));							
							//ht.put("facility_id",login_facility_id);				//IN034769
							ht.put("facility_id",(String) map.get("orderingFacility"+cr));  //IN034769							
							ht.put("specimen_no",(String) map.get("specimen_no"+cr));							
							ht.put("login_at_ws_no",login_at_ws_no);
							ht.put("source_type",(String)map.get("source_type"+cr));							
							ht.put("source_code",(String)map.get("source_code"+cr));							
							ht.put("order_type_code",(String)map.get("order_type_code"+cr));							
							ht.put("language_id",language_id);							
							online_print.callSpecimenOnLinePrintReport(ht,request,response);							
						}
					}*/
					
					int recCount = 0;					
					for(int cr=0;cr<count_records;cr++){
						String report_exec_ind =(String) map.get("report_exec_ind"+cr);	 
						if(result && ("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))){	
							specLabDataPrint.put("order_id"+recCount,(String) map.get("order_id_"+cr));
							specLabDataPrint.put("facility_id"+recCount,(String) map.get("orderingFacility"+cr));							
							specLabDataPrint.put("specimen_no"+recCount,(String) map.get("specimen_no"+cr));
							specLabDataPrint.put("specimen_type"+recCount,(String)map.get("specimen_type"+cr));//IN071820
							specLabDataPrint.put("login_at_ws_no"+recCount,login_at_ws_no);
							specLabDataPrint.put("source_type"+recCount,(String)map.get("source_type"+cr));								
							specLabDataPrint.put("source_code"+recCount,(String)map.get("source_code"+cr));							
							specLabDataPrint.put("order_type_code"+recCount,(String)map.get("order_type_code"+cr));							
							specLabDataPrint.put("language_id"+recCount,language_id);							
							recCount++;
						}
					}
					specLabDataPrint.put( "re_route_printer_id",reRoutePrinterId) ;//IN064835
					specLabDataPrint.put("total_recs",Integer.toString(recCount));	
					//IN046592 End.
				}
				//[IN032796] End

				if (result && p_collection_list.equalsIgnoreCase("Y")) 
				{

				    tabDataPrint = new Hashtable();

					tabDataPrint.put( "total_recs" ,"1");
					tabDataPrint.put("facility_id",login_facility_id);
					tabDataPrint.put("collection_list",p_collection_list);
					tabDataPrint.put("printLocationType",this.p_printLocationType);
					tabDataPrint.put("printLocation",this.p_printLocation);
					tabDataPrint.put("option_list",this.option_list);

					tabDataPrint.put("date_from",java.net.URLEncoder.encode((this.p_date_from),"UTF-8"));
					tabDataPrint.put("date_to",java.net.URLEncoder.encode((this.p_date_to),"UTF-8"));
					tabDataPrint.put("priority",this.p_priority);
					tabDataPrint.put("location_type",this.p_location_type);
					tabDataPrint.put("locn",this.p_locn);
					tabDataPrint.put("locn1",this.p_locn1);
					tabDataPrint.put("order_type",this.p_order_type);
					tabDataPrint.put("order_type1",this.p_order_type1);
					tabDataPrint.put("option",this.p_option);
					tabDataPrint.put("select_specific_order",this.p_select_specific_order);
					tabDataPrint.put("patientId",this.p_patientId);
					tabDataPrint.put("order_id",this.p_order_id);
					tabDataPrint.put("encounter_id",this.p_encounter_id);
					tabDataPrint.put( "re_route_printer_id",reRoutePrinterId) ;//IN064835

				//	OnLinePrinting online_print = new OnLinePrinting(request,response);
				//	online_print.callSpecimenCollectOnLinePrint(tabDataPrint);
				
				//	online_print.callSpecimenCollectOnLinePrint(allValues);
			
				}
				else if (result && p_collection_list.equalsIgnoreCase("N")) 
				{
					 //tabDataPrint = new Hashtable();
					// stored_values=new Hashtable();
				}


			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}  
		}	
	}//IN049737 - else condition ends 
	catch(Exception e)
	{
		e.printStackTrace();
		map.put("message",e.getMessage());
	}
		return map ;
   }

public void clear() 
{
		option_list				="";
		lb_module				= "";
		user_id					= "";
		user_password			= "";
		prac_type 			    = "";
		order_category 			= "";
		session_id				= "";
		curr_sys_date			= "";
		removeAllSelectedLocnRecord();
		super.clear();
		manualBarcodeRemarks =new HashMap();//Added for IN072184
 }


	public ArrayList getSysDateTime() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) 
			{
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database SYSDATETIME" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public ArrayList getDispatchMode() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  dispatchMode		= new ArrayList();

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_DISPATCH_MODE_SELECT") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record [] 	= new String[2];
				record[0]			=	resultSet.getString("long_desc");
				record[1]			=	resultSet.getString("transport_mode");
				dispatchMode.add(record)  ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database dISPATCH" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return dispatchMode;
	}

	public ArrayList getSpecimenBehindDetails() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList SpecimenBehindDetails	= new ArrayList() ;
		try 
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_BEHIND_DATE_SELECT") ) ;
				pstmt.setString( 1, login_facility_id );

				resultSet = pstmt.executeQuery() ;
				if( resultSet != null && resultSet.next() ) 
				{ // Only One record
					SpecimenBehindDetails.add(resultSet.getString( "behind_date" ))  ;
					SpecimenBehindDetails.add(resultSet.getString( "ahead_date" ))  ;
					SpecimenBehindDetails.add(resultSet.getString( "specimen_collect_hrs_behind" ))  ;
					SpecimenBehindDetails.add(resultSet.getString( "specimen_collect_hrs_ahead" ))  ;
				}
			} 
			catch( Exception e )	
			{
				System.err.println( "Error loading values from database getSpecimenBehindDetails" ) ;
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return SpecimenBehindDetails;
	}

	public ArrayList getFacilityDetails() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList facilityDetails	= new ArrayList() ;
		try 
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_FACILITY_SELECT") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, login_by_id );

				resultSet = pstmt.executeQuery() ;
				//if( resultSet != null && resultSet.next() ) { // Only One record
				while(resultSet.next()) {
				    String record[] = new String[2];
				    record[0] = checkForNull(resultSet.getString( "facility_name" ),"");
				    record[1] = checkForNull(resultSet.getString( "facility_id" ),"") ;
					facilityDetails.add(record)  ;

				}
		} catch( Exception e )	{
			System.err.println( "Error loading values from database FACILITY" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return facilityDetails;
	}

	public String getInstallYn(String module_id, String facility_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String install_yn			= "N";
		try
		{
				connection			=  getConnection() ;
				pstmt		    	= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, facility_id); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )     
				{
					while(resultSet.next())
					{
						install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	 
			}catch ( Exception e )	{
				System.err.println( "Getting Module ID SM_MODULES_FACILITY"+e ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return install_yn;
	} 
	public ArrayList getLocationOrder(String location_order, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList LocationOrder		= new ArrayList();
		try{
			connection			=  getConnection() ;
			if(location_order.equals("W")) {  // For wing code 
				pstmt		    	= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_LOCATION_ORDER_WING"));
			} else {  // for operation theatre
				pstmt		    	= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_LOCATION_ORDER_THEATRE"));
			}
			pstmt.setString(1, facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )     
			{
				String[] record = null;
				while(resultSet.next())
				{
					record = new String[2];
					record[0] = checkForNull(resultSet.getString( "code" ),"");
					record[1] = checkForNull(resultSet.getString( "short_desc" ),"") ;
					LocationOrder.add(record)  ;
				}
			}	 
		}catch ( Exception e )	{
			System.err.println( "Getting Location Order"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return LocationOrder;
	}  

	public String[] getNeonateMotherPatient(String order_id, String order_type_code) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		ResultSet resultSet 		= null;
		String[] neonate_mother_dtl =new String[2];
		try{
			connection			=  getConnection() ;
			cstmt		    	= connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_MOTHER_PATIENT")+" }");
			cstmt.setString(1, order_id); 							 // order_id
			cstmt.setString(2, order_type_code); 					 // ORDER_TYPE_CODE
			cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;	
			cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;	
			cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;	
			cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;	
			cstmt.execute();
			neonate_mother_dtl[0] 	= cstmt.getString(3)==null?"":cstmt.getString(3);
			neonate_mother_dtl[1] 	= cstmt.getString(4)==null?"":cstmt.getString(4);
		
			
		}catch ( Exception e )	{
			System.err.println( "Getting Location Order"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( cstmt ) ;
			closeConnection(connection);
		}
		return neonate_mother_dtl;
	}  
	public String getNeonateSpecimenYN(String order_id, String order_type_code) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		ResultSet resultSet 		= null;
		String neonate_spec_yn ="";
		try{
			connection			=  getConnection() ;
			cstmt = connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN")+" }");
														
			cstmt.setString(1, order_id); 							 // order_id
			cstmt.setString(2, order_type_code); 					 // ORDER_TYPE_CODE
			cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;		 // neonate_spec_yn
			cstmt.execute();
			neonate_spec_yn 	= cstmt.getString(3)==null?"N":cstmt.getString(3);
			
		}catch ( Exception e )	{
			System.err.println( "Getting Location Order"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( cstmt ) ;
			closeConnection(connection);
		}
		return neonate_spec_yn;
	}  


	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		
		String order_id				 = "";
		String perf_func			 = "";
		String valid_operational_yn	 = "";

		if(option_list.equals("N"))
			perf_func = "NEW_LIST";
		else if(option_list.equals("C"))
			perf_func = "RECORD_COLLECTION";
		else if(option_list.equals("D"))
			perf_func = "RECORD_DISPATCH";
		else{     // when option_list is 'R','S','V' validation is not required.
			return map;
		}

		int total = Integer.parseInt(total_records);
		
		for(int i=0; i<total; i++){
			if(((String)allValues.get("select"+i)).equalsIgnoreCase("Y")){
				order_id = checkForNull( ((String)allValues.get("order_id"+i)));
				valid_operational_yn = getOperationalStatus( perf_func , order_id , "");
			}
			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", "OR_STATUS_CHANGED" ) ;
				map.put( "invalidCode", ""+i ) ;
				
				break;
			}
			
		}
	    return map ;
    }
	
	public String getOrderCatalogCode(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_catalog_code = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_ORDER_CATALOG_SELECT") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			pstmt.setString( 2, order_line_num.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_catalog_code = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return order_catalog_code;
	}
	
	public ArrayList getPerformingFacilityDetails() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  facility_details	= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_FACILITY_SELECT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2,login_by_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
			    String record [] = new String[2];
                record[0] = resultSet.getString("facility_id");
				record[1] = resultSet.getString("facility_name");
				facility_details.add(record);
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return facility_details;
	}

	public ArrayList getPerformingLocationDetails(String performing_facility,String ord_cat,String order_catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  location_details	= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN") ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,performing_facility);
			pstmt.setString(3,ord_cat);
			pstmt.setString(4,order_catalog_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet.next() ) {
			    String record [] = new String[2];
                record[0] = resultSet.getString("code");
				record[1] = resultSet.getString("short_desc");
				location_details.add(record);
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return location_details;
	}
	
	/*public ArrayList getPerformingLocationDetails(String p_performing_facility) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  location_details	= new ArrayList();
		StringBuffer orderCatCode = new StringBuffer();
		
		HashMap<String,ArrayList> selectedOrders = getselectedLocnRecords();
		Set selectedKey = selectedOrders.keySet();
		Iterator iter = selectedKey.iterator();
        
		while (iter.hasNext())
        {
            String str = (String)iter.next();
			//orderCatCode.append("'");
			//orderCatCode.append(str);
			//orderCatCode.append("'");
			
			ArrayList locnData = selectedOrders.get(str);
			//StringTokenizer data = new StringTokenizer(locnData,"##");
			//data.nextToken();
			//String cataCode = data.nextToken();
			//for(int i = 0;i < locnData.size();i++)
			//{
				orderCatCode.append("'");
				orderCatCode.append(locnData.get(1));
				orderCatCode.append("'");
			//}
			if(iter.hasNext())
				orderCatCode.append(",");
		}
		try 
		{
			connection = getConnection();
			String perfLocnQry = "SELECT distinct a.performing_deptloc_code code,or_get_desc.or_performing_deptloc (b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code,?,'2') short_desc,default_yn default_yn FROM or_orderables_for_deptloc a, or_performing_deptloc b WHERE a.performing_facility_id = ? AND a.performing_deptloc_type = DECODE ('LB','LB', 'L') AND a.order_catalog_code in ("+orderCatCode+") AND a.performing_facility_id = b.performing_facility_id AND a.performing_deptloc_type = b.performing_deptloc_type AND a.performing_deptloc_code = b.performing_deptloc_code AND b.eff_status = 'E'";
			pstmt = connection.prepareStatement(perfLocnQry);
			pstmt.setString(1,language_id);
			pstmt.setString(2,p_performing_facility);
			resultSet = pstmt.executeQuery();
			while ( resultSet.next() ) 
			{
			    String record [] = new String[2];
                record[0] = resultSet.getString("code");
				record[1] = resultSet.getString("short_desc");
				location_details.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		int hashSize = location_details.size();
		return location_details;
	}*/

	public ArrayList getPerformingLocationDetails(String p_performing_facility) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  location_details	= new ArrayList();
		StringBuffer orderCatCode = new StringBuffer();
		StringBuffer orderTypeCode = new StringBuffer();
		HashMap<String,ArrayList> selectedOrders = getselectedLocnRecords();
		Set selectedKey = selectedOrders.keySet();
		Iterator iter = selectedKey.iterator();
		String extInstalled = "";
        
		while (iter.hasNext())
        {
            String str = (String)iter.next();
			ArrayList locnData = selectedOrders.get(str);
			orderCatCode.append(locnData.get(1));
			orderTypeCode.append(locnData.get(3));
		}

		try 
		{
			connection = getConnection() ;
			String isExtApplInstalled = "N";
			
			extInstalled = checkForNull(getmoduleRL(orderCatCode.toString(),"LB",orderTypeCode.toString(),p_performing_facility),"");
			if(extInstalled.equals("IBARL"))
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_LB") ) ;
				pstmt.setString(1,p_performing_facility);
				pstmt.setString(2,orderCatCode.toString());
				resultSet = pstmt.executeQuery() ;
				isExtApplInstalled = "Y";
			}

			if(isExtApplInstalled.equals("N"))
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN") ) ;
				pstmt.setString(1,language_id);
				pstmt.setString(2,p_performing_facility);
				pstmt.setString(3,"LB");
				pstmt.setString(4,orderCatCode.toString());
				resultSet = pstmt.executeQuery() ;
			}

			while ( resultSet.next() ) 
			{
			    String record [] = new String[2];
                record[0] = resultSet.getString("code");
				record[1] = resultSet.getString("short_desc");
				location_details.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		//int hashSize = location_details.size(); //Checkstyle
		return location_details;
	}
	
	public HashMap  modify()
	{
		
		int count = 0 ;
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;	
		java.util.Properties  properties = getProperties();
		user_id				= properties.getProperty( "ecis_jdbc_user" ) ;
		user_password		= properties.getProperty( "ecis_jdbc_password" ) ;
		String jdbc_dns 	= properties.getProperty( "ecis_jdbc_dns" );
		String database_name= "";
		String orderDetails = "";
		if(jdbc_dns!=null)
			database_name	= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());
		
		try
		{			
			//orderDetails = checkMatchingLocations(updatePerfFacility,updatePerfLocn);
			HashMap<String,ArrayList> selectedOrders = getselectedLocnRecords();
			Set selectedKey = selectedOrders.keySet();
			Iterator iter = selectedKey.iterator();
			
			//Iterate and check for the setup and then remove the data from the original collection
			
			while (iter.hasNext())
			{
				String str = (String)iter.next();
				String[] updt_dtl	 = new String[3];
				updt_dtl[0] = updatePerfFacility;
				updt_dtl[1] = updatePerfLocn;			
				updt_dtl[2] = checkForNull(str);
				tabData.put("data"+count ,updt_dtl);
				count++;
			}
			
			tabData.put("totalRecords",String.valueOf(count));
			tabData.put( "properties", getProperties() );
			tabData.put( "user_id",user_id ) ;
			tabData.put( "user_password",user_password ) ;
			tabData.put( "database_name",database_name ) ;
			tabData.put( "login_by_id",login_by_id ) ;
			tabData.put( "login_at_ws_no",login_at_ws_no ) ;
			tabData.put( "login_facility_id",login_facility_id ) ;
			tabData.put( "option_list",option_list ) ;
			tabData.put( "curr_sys_date",curr_sys_date ) ;
			tabData.put("auto_collect",auto_collect);
			tabData.put( "lb_module",lb_module ) ;
			tabData.put( "session_id",session_id ) ;
			
			
			sqlMap.put("SQL_OR_UPDATE_PERFORM_LOCN","update or_order set PERFORMING_FACILITY_ID = ?,PERFORMING_DEPTLOC_CODE = ?, MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?, MODIFIED_DATE = to_date(?,'DD/MM/YYYY HH24:MI'),MODIFIED_AT_WS_NO= ?  where order_id = ?");			
			sqlMap.put("SQL_OR_UPDATE_PERFORM_LOCN_LB","update rl_order_outstand set PERFORMING_FACILITY_ID = ?,MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?, MODIFIED_DATE = to_date(?,'DD/MM/YYYY HH24:MI'),MODIFIED_AT_WS_NO= ? where order_id =?");
			sqlMap.put("SQL_OR_UPDATE_PERFORM_LOCN_LB_INTERVAL","update RL_INTERVAL_TEST_SPECIMENS set OPERATING_FACILITY_ID = ? where order_id =?");//IN043805
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_SPECIMEN_ORDER_JNDI"), ORSpecimenOrderHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();
				
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			map.put("message",orderDetails);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map; 	
	}	
	
	public String checkMatchingLocations(String p_performing_facility,String p_performing_location)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		StringBuffer orderDetails = new StringBuffer();
		try 
		{
			connection = getConnection();
			String perfLocnQry = "SELECT a.performing_deptloc_code code,or_get_desc.or_performing_deptloc (b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code,?,'2') short_desc,default_yn default_yn,'Y' recAvailable FROM or_orderables_for_deptloc a, or_performing_deptloc b WHERE a.performing_facility_id = ? AND a.performing_deptloc_type = DECODE ('LB','LB', 'L') AND a.order_catalog_code = ? AND a.performing_facility_id = b.performing_facility_id AND a.performing_deptloc_type = b.performing_deptloc_type AND a.performing_deptloc_code = b.performing_deptloc_code ";
			
			if(!p_performing_location.equals(""))
				perfLocnQry = perfLocnQry + " and a.performing_deptloc_code = ? ";
			
			perfLocnQry = perfLocnQry + " AND b.eff_status = 'E'";
			
			
			
			HashMap<String,ArrayList> selectedOrders = getselectedLocnRecords();
			Set selectedKey = selectedOrders.keySet();
			Iterator iter = selectedKey.iterator();
			String recAvailable;
			ArrayList removableRecords = new ArrayList();
			while (iter.hasNext())
			{
				recAvailable = "N";
				pstmt = connection.prepareStatement(perfLocnQry);
				String str = (String)iter.next();
				//String[] updt_dtl	 = new String[3]; //Checkstyle
				pstmt.setString(1,language_id);
				pstmt.setString(2,p_performing_facility);
				ArrayList locnData = selectedOrders.get(str);
				pstmt.setString(3,(String)locnData.get(1));
				if(!p_performing_location.equals(""))
					pstmt.setString(4,p_performing_location);

				resultSet = pstmt.executeQuery();
				
				while(resultSet!=null && resultSet.next())
				{
					recAvailable = "Y";					
				}
				
				if(recAvailable.equals("N"))
				{
					orderDetails.append(locnData.get(0));
					orderDetails.append(locnData.get(2));
					orderDetails.append("\n");
					removableRecords.add((String)locnData.get(0));
					//removeSelectedLocnRecord((String)locnData.get(0));
				}
				if(pstmt!=null)
					pstmt.close();
				if(resultSet!=null)
					resultSet.close();
			}
			
			for(int k = 0;k<removableRecords.size();k++)
			{
				removeSelectedLocnRecord((String)removableRecords.get(k));
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeStatement(pstmt) ;
				closeResultSet(resultSet) ;
				closeConnection(connection) ;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}		
		return orderDetails.toString();
	}
	
	//IN049737 - Start
	public String getFunctiondtl() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//ArrayList FunctionAppl	= new ArrayList() ; //Checkstyle
		String split_yn = "N";
		
		try 
		{
			connection = getConnection() ;	
			pstmt = connection.prepareStatement("Select count(*) count from OR_PAT_APPLICABLE_FUNC where function_id = 'SPLIT_UNBLD_ORDER' ");

			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) 
			{ 
				if("1".equals(resultSet.getString( "count" )))
				{
					split_yn = "Y";	
				}
			}
		} 
		catch( Exception e )	
		{
			System.err.println( "Error loading values from database getFunctiondtl" ) ;
			e.printStackTrace() ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return split_yn;
	}
	public ArrayList getBillSettlementYN(String ordering_facility, String order_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList SpecimenBillSettleDetails	= new ArrayList() ;
		String bill_set_details = "";
		String record [] 	= new String[2];
		try 
		{
			connection = getConnection() ;	
			
			pstmt = connection.prepareStatement("select or_ord_line_bl_settled(?,'OR',?) settle_detail FROM DUAL");
			pstmt.setString( 1, ordering_facility );
			pstmt.setString( 2, order_id);

			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) 
			{ 
				bill_set_details = checkForNull(resultSet.getString( "settle_detail" ),"")  ;
			}
			
			if(!"".equals(bill_set_details))
			{	
				StringTokenizer st1 = new StringTokenizer(bill_set_details, "~");
		        /*String mainStr = "";
		        String subStr  = "";*/ //Checkstyle
		              
		        while (st1.hasMoreTokens()) 
		        {
		           	record[0]			=	st1.nextToken();
		           	record[1]			=	st1.nextToken();	           	
				} 
		        SpecimenBillSettleDetails.add(record);
			}
		} 
		catch( Exception e )	
		{
			System.err.println( "Error loading values from database SpecimenBillSettleDetails" ) ;
			e.printStackTrace() ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return SpecimenBillSettleDetails;
	}
	
	public ArrayList getUnBilledOrderDetails(String facility_id,String patient_id,String called_from,String order_id,String encounter_id) throws Exception 
	{
			
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList UnBilledOrder = new ArrayList() ;
	
	 		int total_records			= 0;
	
			try {
					
				connection			= getConnection() ;
				
				pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE , a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?)  and a.order_id=?  and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_line_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20')  order by encounter_id,a.order_id,a.ORD_DATE_TIME desc"  ) ;//IN052314 removed encounter from where condition
	
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, facility_id) ;		 
				pstmt.setString( 9, patient_id) ; 
				//pstmt.setString( 10, encounter_id) ;	//IN052314	
				pstmt.setString( 10, order_id) ;	
								
				resultSet = pstmt.executeQuery() ;
				
				while(resultSet!=null && resultSet.next()) 
				{
					String[] record = new String[34];				
					record[0] = checkForNull(resultSet.getString( "order_category" ),"")   ;
					record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
					record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"")  ;
					record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
					record[4] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
					record[5] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
					record[6] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
					record[7] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
					record[8] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
					record[9] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
					record[10] = checkForNull(resultSet.getString( "Priority" ),"")  ;
					record[11] = checkForNull(resultSet.getString( "source_type" ),"")  ;
					record[12] = checkForNull(resultSet.getString( "source_code" ),"")  ;
					record[13] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
					record[14] = checkForNull(resultSet.getString( "order_status" ),"")  ;
					record[15] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
					record[16] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
					record[17] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
					record[18] = checkForNull(resultSet.getString( "sex" ),"")  ;
					record[19] = checkForNull(resultSet.getString( "age" ),"")  ;
					record[20] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
					record[21] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
					record[22] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
					record[23] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
					record[24] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
					record[25] = checkForNull(resultSet.getString( "order_id" ),"");
					record[26] = checkForNull(resultSet.getString( "bill_yn" ),"");
					record[27] = checkForNull(resultSet.getString( "catalog_code" ),"");
					record[28] = checkForNull(resultSet.getString( "order_qty" ),"");
					record[29] = checkForNull(resultSet.getString( "contr_mod_id" ),"");
					record[30] = checkForNull(resultSet.getString( "start_date_time" ),"");
					record[31] = checkForNull(resultSet.getString( "location_description" ),"");	
					record[32] = checkForNull(resultSet.getString( "billing_package_ref" ),"");
					record[33] = String.valueOf(total_records);
					UnBilledOrder.add(record) ;
	 			}
			} catch ( Exception e )	{
	
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
	
			return UnBilledOrder;
		}
	 // Method to get the Billing Info on load of the First Screen.....
	 public ArrayList getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id) throws Exception {

		Connection connection 											= null;
		CallableStatement cstmt 										= null;
		PreparedStatement pstmt 										= null;
		PreparedStatement pstmt_floor_to_start_day	 					= null;
		PreparedStatement pstmt_mod_physician_id	 					= null;
		ResultSet resultSet 											= null;
		ResultSet resultSet_floor_to_start_day 							= null;
		ResultSet resultSet_mod_physician_id 							= null;
		PreparedStatement pstmt_bl 										= null;
		ResultSet rs													= null;
		String l_facility_id											= "";
		ArrayList BillChargeInfo										= new ArrayList() ;

		String[]  billing_details										= new String[21];
		String round_off_start_date										="N";
		String mod_physician_id											="";
		
		try
		{
		
				connection	= getConnection();
				
				if (!order_id.equals("")) 
				{ 
					pstmt_bl = connection.prepareStatement("select a.ordering_facility_id from or_order a,or_order_line b where a.order_id=b.order_id and a.order_id =? and b.order_line_num=?");
					pstmt_bl.setString(1, order_id); 
					pstmt_bl.setString(2, order_line_no); 
					rs	= pstmt_bl.executeQuery() ;
					if ( rs != null )
					{
						while(rs.next())
						{
							l_facility_id = checkForNull(rs.getString( "ordering_facility_id" ),"")  ;
						}
					}
				}
				else 
				{
					l_facility_id = login_facility_id;
				}

				pstmt_mod_physician_id		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MOD_PHYSICIAN_ID"));				
				cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
				cstmt.setString(1, l_facility_id); 
				cstmt.setString(2, encounter_id);  			  	   			 // ENCOUNTER_ID
				cstmt.setString(3, patient_class); 							 // PATIENT_CLASS
				cstmt.setString(4, patient_id); 							 // PATIENT_ID
				cstmt.setDouble(5, Double.parseDouble(checkForNull(quantity,"0")));
				cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
				cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME
				cstmt.setString(8, practitioner_id); 						 // PRACTITIONER_ID
				cstmt.setString(9, language_id); 							 // P_LANGUAGE_ID
				cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // P_STR
				cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // P_CHARGE_BASED_YN
				cstmt.registerOutParameter( 12,  Types.NUMERIC ) ;			 // P_TOT_AMT
				cstmt.registerOutParameter( 13,  Types.NUMERIC ) ;			 // P_PAT_PAYABLE_AMT
				cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;			 // P_EXCL_INCL_IND
				cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_PREAPP_YN
				cstmt.registerOutParameter( 16,  Types.NUMERIC ) ;			 // P_PAT_PAID_AMT
				cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;			 // P_CHARGED_YN
				cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;			 // P_PAT_BILLED_YN
				cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;			 // ERROR_TEXT
				cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;			 // P_SERV_PANEL_IND
				cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;			 // P_SERV_PANEL_CODE
				cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;			 // P_SERVICE_PANEL_NAME
				cstmt.registerOutParameter( 23,  Types.VARCHAR ) ;			 // P_EPISODE_TYPE
				cstmt.registerOutParameter( 24,  Types.NUMERIC ) ;			 // P_EPISODE_ID
				cstmt.registerOutParameter( 25,  Types.NUMERIC ) ;			 // P_VISIT_ID
				cstmt.setString( 26,  order_id ) ;							 // P_ORDER_ID
				cstmt.setString( 27,  order_line_no ) ;						 // P_ORDER_LINE_NO
				cstmt.setString( 28,  null ) ;						 // FPP_YN IN072922
				cstmt.setString( 29,  null ) ;						 // FPP_CATEGORY IN072922
				 

				cstmt.execute();
				billing_details[0]  = checkForNull(cstmt.getString(10),"");
				billing_details[1]  = checkForNull(cstmt.getString(11),"");
				billing_details[2]  = checkForNull(String.valueOf(cstmt.getDouble(12)),"");				
				billing_details[3]  = checkForNull(String.valueOf(cstmt.getDouble(13)),"");				
				billing_details[4]  = checkForNull(cstmt.getString(14),""); 
				billing_details[5]  = checkForNull(cstmt.getString(15),""); 
				billing_details[6]  = checkForNull(String.valueOf(cstmt.getDouble(16)),"");
				billing_details[7]  = checkForNull(cstmt.getString(17),"");
				billing_details[8]  = checkForNull(cstmt.getString(18),"");
				billing_details[9]  = checkForNull(cstmt.getString(19),"");
				billing_details[10] = checkForNull(cstmt.getString(20),"");
				billing_details[11] = checkForNull(cstmt.getString(21),"");
				billing_details[12] = checkForNull(cstmt.getString(22),"");
				billing_details[13] = checkForNull(cstmt.getString(23),"");
				billing_details[14] = checkForNull(cstmt.getString(24),"");
				billing_details[15] = checkForNull(cstmt.getString(25),"");
				billing_details[16]  = checkForNull(cstmt.getString(14),""); // new P_EXCL_INCL_IND
			
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_FUTURE_ORDER_CHARGE_LATER_IND"));
				pstmt.setString(1, "OR");  					 // FACILITY_ID
				pstmt.setString(2, catalog_code);  			  	   			 // ENCOUNTER_ID
				pstmt.setString(3, billing_details[13]); 	
				pstmt.setString(4, catalog_code); 
				pstmt.setString(5, patient_class); 
				
				resultSet	= pstmt.executeQuery() ;
				String futureBillInd ="";
				String Future_date="";
		
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						
						futureBillInd =checkForNull(resultSet.getString( "Future_Bill_ind" ),"")  ;
				
						if (futureBillInd.equals("NOW"))
						{
							billing_details[17]="N";
						}
						else if (futureBillInd.equals("LATER") )
						{
							billing_details[17]="Y";
						}
						else
							billing_details[17]="";
						Future_date=checkForNull(resultSet.getString( "furure_order_date" ),"")  ;
					    billing_details[18]=Future_date;
					}
				}

				pstmt_floor_to_start_day		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FLOOR_TO_START_DAY_YN")); 
				pstmt_floor_to_start_day.setString(1, catalog_code);  			  	   			 // CATALOG_CODE
				pstmt_floor_to_start_day.setString(2, patient_class);                             // PATIENT_CLASS
				resultSet_floor_to_start_day	= pstmt_floor_to_start_day.executeQuery() ;
				

				if (resultSet_floor_to_start_day != null )
				{
					while(resultSet_floor_to_start_day.next())
					{
						round_off_start_date =checkForNull(resultSet_floor_to_start_day.getString( "floor_to_start_day_yn" ),"N")  ;	
					    billing_details[19]=round_off_start_date;
					}
				}
				
				if(!order_id.equalsIgnoreCase(""))
				{
				 
					pstmt_mod_physician_id.setString(1, "OR");  			  	   			   // module_id
					pstmt_mod_physician_id.setString(2, order_id);                             // order_id
					pstmt_mod_physician_id.setString(3, order_line_no);                        // order_line_no
					pstmt_mod_physician_id.setString(4, patient_id);                           // patient_id
					pstmt_mod_physician_id.setString(5, billing_details[13]==null?"":billing_details[13]);// episode_type				
					pstmt_mod_physician_id.setString(6, billing_details[15]==null?"":billing_details[15]);// visit_id
					pstmt_mod_physician_id.setString(7, billing_details[14]==null?"":billing_details[14]);// episode_id
					pstmt_mod_physician_id.setString(8, login_facility_id);// facility_id
					resultSet_mod_physician_id	= pstmt_mod_physician_id.executeQuery() ;
				

					if (resultSet_mod_physician_id != null )
					{
						while(resultSet_mod_physician_id.next())
						{							
							mod_physician_id = checkForNull(resultSet_mod_physician_id.getString( "PHYSICIAN_ID" ),"")  ;			
							billing_details[20] = mod_physician_id;
						}
					}
				}
				else
				{
					billing_details[20] = "";
				}
				BillChargeInfo.add(billing_details) ;

		   }
		   catch ( Exception e )	
			{
				e.printStackTrace() ;
			throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_floor_to_start_day ) ;
				closeResultSet( resultSet_mod_physician_id ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt_bl);
				closeStatement( cstmt);
				closeStatement( pstmt);
				closeStatement( pstmt_floor_to_start_day);
				closeStatement( pstmt_mod_physician_id);
				closeConnection(connection);
			}
			return BillChargeInfo;
	 } // End of getBillChargeDetails
		//IN049737 - End
	 //IN052230 - Start
	 public int insertReprintDispSlipRecords() throws Exception{
		 HashMap dispatchMap = null;
		 Connection con = null;
		 String rdsString = ""; //IN055673
		 String specimen_no = "";
		 //String patient_id = ""; -IN055673
		 //String order_id = ""; -IN055673
		 int print_sequ = 0;
		 PreparedStatement insertStatement = null;
		 PreparedStatement selectStatement = null;
		 ResultSet resultSet = null;
		 boolean insertSuccess = false;
		 String insertSql = "INSERT INTO OR_REPRINT_DISP_SLIP(PRINT_SEQ_NO, SPECIMEN_NO, PATIENT_ID, ORDER_ID) VALUES(?, ?, ?, ?)";
		 String selectSql = "SELECT OR_PRINT_SEQ_NO_DS.NEXTVAL FROM DUAL";
		 try {
			 dispatchMap = getPatientDispSlipSelected();
			 con = getConnection();
			 selectStatement = con.prepareStatement(selectSql);
			 resultSet = selectStatement.executeQuery();
			 while(resultSet.next()){
				 print_sequ = resultSet.getInt(1);
			 }
			 if(dispatchMap != null){
				 boolean batchRecords = false;
				 Iterator itr = dispatchMap.keySet().iterator();
				 insertStatement = con.prepareStatement(insertSql);
				 while(itr.hasNext()){
					 specimen_no = itr.next().toString();
					 //patient_id = (String)dispatchMap.get(specimen_no); -IN055673
					 rdsString = (String)dispatchMap.get(specimen_no);
					 StringTokenizer split_value	=	new StringTokenizer(rdsString,"~"); //IN055673
					 System.out.println("3741. SpecimenOrder.java " + split_value);
					 insertStatement.setInt(1,print_sequ);
					 insertStatement.setString(2, specimen_no);
					 insertStatement.setString(3, split_value.nextToken()); //IN055673
					 insertStatement.setString(4, split_value.nextToken()); //IN055673
					 insertStatement.addBatch();
					 batchRecords = true;
				 }
				 if(batchRecords == true){
					 try {
						insertStatement.executeBatch();
						insertSuccess = true;
					 } catch(BatchUpdateException buEx){
						 insertSuccess = false;
						 System.err.println(" 3754. BatchUpdateException in SpecimenOrder.java => " + buEx.getMessage());
						 buEx.printStackTrace();
					 }
				 }
				 if(insertSuccess == true){
					 con.commit();
				 } else {
					 try {
						 con.rollback();
					 }
					 catch(Exception ex){
						 System.err.println(" 3765. Exception in SpecimenOrder.java => " + ex.getMessage());
						 ex.printStackTrace();
					 }
				 }
			 }
			 
		 } catch(Exception ex){
			 System.err.println(" 3772. Exception in SpecimenOrder.java => " + ex.getMessage());
			 ex.printStackTrace();
		 } finally{
			 if(resultSet != null) resultSet.close();
			 if(selectStatement != null) selectStatement.close();
			 if(insertStatement != null) insertStatement.close();
			 if(con != null) con.close();
		 }
		 return print_sequ;
	 }
	 //IN052230 - End
	//added for IN055737 HSA-CRF-0250.1 - Start
	 public String getBarcodeSearchConfigValue() throws Exception{
		 String allow_bar_code_search_yn = "N";
		 Connection con = null;
		 PreparedStatement selectStatement = null;
		 ResultSet resultSet = null;
		 String selectSql = "SELECT DISP_SLIP_BARCOD_SRCH_YN ALLOW_BAR_CODE_SEARCH_YN FROM OR_PARAM";
		 try {
			 con = getConnection();
			 selectStatement = con.prepareStatement(selectSql);
			 resultSet = selectStatement.executeQuery();
			 while(resultSet.next()){
				 allow_bar_code_search_yn = resultSet.getString("ALLOW_BAR_CODE_SEARCH_YN");
			 }
		 } catch(Exception ex){
			 System.err.println("3846. Exception in SpecimenOrder.java => " + ex.getMessage());
			 ex.printStackTrace();
		 }
		 finally {
			 if(resultSet != null) resultSet.close();
			 if(selectStatement != null)selectStatement.close();
			 if(con != null) con.close();
		 }
		 return allow_bar_code_search_yn;
	 }
	//added for IN055737 HSA-CRF-0250.1
	//added for  - ML-MMOH-CRF-0540 [IN061888] Start
	 public String getCheckAllSpecRecCollection(String login_facility_id) throws Exception{
		 String select_all_spec_rec_collect_yn = "N";
		 Connection con = null;
		 PreparedStatement selectStatement = null;
		 ResultSet resultSet = null;
		 String selectSql = "SELECT SELECT_ALL_SPEC_REC_COLLECT_YN FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID = ?";
		 try {
			 con = getConnection();
			 selectStatement = con.prepareStatement(selectSql);
			 selectStatement.setString(1, login_facility_id);
			 resultSet = selectStatement.executeQuery();
			 while(resultSet.next()){
				 select_all_spec_rec_collect_yn = resultSet.getString("SELECT_ALL_SPEC_REC_COLLECT_YN");
			 }
		 } catch(Exception ex){
			 System.err.println("3893. Exception in SpecimenOrder.java => " + ex.getMessage());
			 ex.printStackTrace();
		 }
		 finally {
			 if(resultSet != null) resultSet.close();
			 if(selectStatement != null)selectStatement.close();
			 if(con != null) con.close();
		 }
		 return select_all_spec_rec_collect_yn;
	 }
	//added for ML-MMOH-CRF-0540 [IN061888] End
	 //IN064835 starts
	 public ArrayList getReRoutePrinters() throws Exception
	 {
		 	Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList printerDetails	= new ArrayList() ;
			try 
			{
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_PRINTER_SELECT") ) ;
					resultSet = pstmt.executeQuery() ;
					while(resultSet.next()) {
					    String record[] = new String[2];
					    record[0] = checkForNull(resultSet.getString( "PRINTER_NAME" ),"");
					    record[1] = checkForNull(resultSet.getString( "PRINTER_ID" ),"") ;
					    printerDetails.add(record)  ;
					}
			} catch( Exception e )	{
				System.err.println( "Error loading values from database printers name" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
		return printerDetails; 
	 }
	 //IN064835 ends
//IN061892
public ArrayList getSpecimenNotRegisteredDetails(String patient_id,String order_id,String time_alert,String priority,String specimen,String practitioner_type,String status,String practitioner_id) throws Exception
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		StringBuffer sql = new StringBuffer();
		int cnt=0;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;

		if(patient_id.equals(" ") || patient_id.equals("null")) patient_id = "";
		if(order_id.equals(" ") || order_id.equals("null")) order_id = "";
		if(time_alert.equals(" ") || time_alert.equals("null")) time_alert = "";
		if(priority.equals(" ") || priority.equals("null")) priority = "";
		if(specimen.equals(" ") || specimen.equals("null")) specimen = "";
		
		try 
		{
			connection = getConnection() ;
			sql.append("SELECT   a.order_category order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,CASE WHEN a.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2')ELSE op_get_desc.op_clinic (a.ordering_facility_id,a.source_code,?,'2')END location_description,a.order_id order_id, a.patient_id patient_id,a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?) catalog_desc,(SELECT MAX (accession_num)FROM or_order_line WHERE order_id = a.order_id AND accession_num IS NOT NULL) accession_num,a.source_type, a.source_code, a.priority priority,a.order_type_code order_type_code, a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,order_status,or_get_desc.or_order_status_code(a.order_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,d.specimen_type specimen_type,d.specimen_collect_yn specimen_collect_yn,d.coll_label_gen_rule coll_label_gen_rule,TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,or_collection_due_date (a.source_type,a.source_code,d.specimen_type,d.specimen_collect_yn,a.priority,b.start_date_time,NULL,a.order_type_code,a.performing_facility_id,?,b.order_id,b.order_line_num) or_collection_due,get_age (c.date_of_birth) age, c.sex sex,DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,a.source_type, start_date_time start_date_time_dt,a.cont_order_ind cont_order_ind,a.performing_facility_id performing_facility_id,b.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id,TO_CHAR (d.specimen_dispatch_date_time,'dd/mm/yyyy hh24:mi') specimen_dispatch_date_time FROM or_order a,or_order_line b,mp_patient c,or_order_line_lb d,or_param_by_facility e WHERE a.patient_id = c.patient_id AND a.order_category = 'LB' AND a.order_id = b.order_id AND d.order_id = b.order_id AND d.order_line_num = b.order_line_num AND a.performing_facility_id = e.operating_facility_id AND SUBSTR (a.order_id, 1, 2) != 'CS' AND a.performing_facility_id = ? AND b.order_line_status = 'SD' AND e.operating_facility_id = ? AND d.specimen_dispatch_date_time < (SELECT SYSDATE - ? / 1440 FROM DUAL) AND EXISTS (SELECT locn_code FROM ca_pract_by_locn_view WHERE facility_id = a.ORDERING_FACILITY_ID AND practitioner_id = ? AND locn_code = a.SOURCE_CODE)");
			
			if(!patient_id.equals(""))
				sql.append(" and a.patient_id =? ");	
			if(!order_id.equals(""))
				sql.append(" and b.order_id =? ");
			if(!specimen.equals(""))
				sql.append(" and b.ACCESSION_NUM =? ");

			if("B".equals(priority))
				sql.append(" and b.PRIORITY IN ('U','S') ");
			else if("U".equals(priority))
				sql.append(" and b.PRIORITY = 'U'");
			else if("S".equals(priority))
				sql.append(" and b.PRIORITY = 'S'");
			
			sql.append("ORDER BY LOCATION_DESCRIPTION, start_date_time_dt DESC");	
			
			pstmt = connection.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(practitioner_type) ) ; 
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(status));
			pstmt.setString( ++cnt , language_id);
			pstmt.setString(++cnt, login_facility_id);
			pstmt.setString(++cnt, login_facility_id);
			pstmt.setString(++cnt, time_alert);
			pstmt.setString(++cnt, practitioner_id);
			
			if(!patient_id.equals(""))
				pstmt.setString(++cnt, patient_id);
			if(!order_id.equals(""))	
				pstmt.setString(++cnt, order_id);
			if(!specimen.equals(""))	
				pstmt.setString(++cnt, specimen);
			
			resultSet = pstmt.executeQuery() ;
			
			while(resultSet.next()){ 
				ArrayList ResultOrderCat	= new ArrayList() ;
	/*0*/		ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
	/*1*/		ResultOrderCat.add(resultSet.getString( "CATALOG_DESC" ))  ;
	/*2*/		ResultOrderCat.add(resultSet.getString( "START_DATE_TIME" ))  ;
	/*3*/		ResultOrderCat.add(resultSet.getString( "SPECIMEN_DISPATCH_DATE_TIME" ))  ;
	/*4*/		ResultOrderCat.add(resultSet.getString( "PATIENT_NAME" ))  ;
	/*5*/		ResultOrderCat.add(resultSet.getString( "SEX" ));
	/*6*/		ResultOrderCat.add(resultSet.getString( "AGE" ))  ;
	/*7*/		ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
	/*8*/		ResultOrderCat.add(resultSet.getString( "ENCOUNTER_ID" ))  ;
	/*9*/		ResultOrderCat.add(resultSet.getString( "LOCATION_DESCRIPTION" ))  ;
				ResultOrderCatFinal.add(ResultOrderCat);
		}
		}
		catch( Exception e )	
		{
				System.err.println( "Error loading values from database SEARCH" ) ;
				e.printStackTrace() ;				
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return ResultOrderCatFinal;		
}//IN061892 ends

//Adding start for MMS-DM-CRF-0170.1
  public ArrayList getScanCountReqForPatientClass(String patClassEncList) throws Exception
	 {
		 	Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList printerDetails	= new ArrayList() ;
			String patient_class   ="";
			String encounter_id= "";
		    ArrayList scanCountSetup    = new ArrayList();
			boolean found = false;
			String scan_count_required_yn="";

			try 
			{
					connection = getConnection() ;
					StringTokenizer dtls = new StringTokenizer(patClassEncList,",");
					while(dtls.hasMoreTokens()){
                         String str2 = dtls.nextToken();
						 System.err.println("str2@@@===="+str2);
					     String[]st = str2.split("~");
						 patient_class =st[0];
						 encounter_id =st[1];
					
						pstmt = connection.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = ? AND PATIENT_CLASS =? ") ;
						pstmt.setString(1, "MANAGE_SPECIMEN");
						pstmt.setString(2, patient_class.trim());
						resultSet = pstmt.executeQuery() ;
						if(resultSet.next())
						{ 
							scan_count_required_yn =resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN");
							if(scan_count_required_yn.equals("Y")){
								scanCountSetup.add(resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN"));
								scanCountSetup.add(resultSet.getString("ALERT_REQUIRED_YN")==null?"N":resultSet.getString("ALERT_REQUIRED_YN"));
								scanCountSetup.add(resultSet.getString("REMARKS_REQUIRED_YN")==null?"N":resultSet.getString("REMARKS_REQUIRED_YN"));
								scanCountSetup.add(encounter_id);
								scanCountSetup.add(patient_class);
								found = true;
								
							}
						}
						closeResultSet( resultSet ) ;//Common-ICN-0092  
						closeStatement( pstmt ) ;//Common-ICN-0092  
                      if (found)
						  break;
                      
					}
				
			} catch( Exception e )	{
				System.err.println( "Error loading values from database printers name" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
		return scanCountSetup; 
	 }//Adding end for MMS-DM-CRF-0170.1.

}
